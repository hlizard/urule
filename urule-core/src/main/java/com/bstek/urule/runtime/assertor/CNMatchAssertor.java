/*******************************************************************************
 * Copyright 2017 Bstek
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package com.bstek.urule.runtime.assertor;

import com.bstek.urule.model.library.Datatype;
import com.bstek.urule.model.rule.Op;
import org.apache.commons.lang.StringUtils;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.JavaScriptException;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.tools.shell.Global;
import org.mozilla.javascript.tools.shell.Main;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/*import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;*/

/**
 * @author Jacky.gao
 * @since 2015年1月6日
 */
public class CNMatchAssertor extends AbstractDebugAssertor {
	
	private Context cx;
	//private Global scope;
	private static ScriptableObject sharedScope;
	static URL  dir;
	static {
        dir = CNMatchAssertor.class.getResource("/");	//TODO:当前部署时需自行部署envjs到classes目录下
	}
	private static ThreadLocal<Context> jscontextHolder = new ThreadLocal<Context>();
	
	private Scriptable init() {
		cx = jscontextHolder.get();
		if(cx == null) {
			console.println("new cx!");
	        cx = Context.enter();
	        cx.setOptimizationLevel(-1);
	        cx.setLanguageVersion(200);	//即VERSION_ES6
	        
	        if (sharedScope == null) {
//	        	sharedScope = cx.initStandardObjects();
//	        	//sharedScope = cx.initStandardObjects(null, true);	//密封所有标准库对象
	        	//使用cx.initStandardObjects();会出现org.mozilla.javascript.EcmaError: ReferenceError: "print" is not defined. (file:/E:/MyCode/workspace-sts-3.9.5.RELEASE/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/morpho/WEB-INF/classes/envjs/env.rhino.js#1856)
	        	sharedScope = new Global(cx);
	        }
	        try {
				Main.processFile(cx, sharedScope, dir + "envjs/env.rhino.js");	//Caused by: java.lang.StackOverflowError
		        Main.processFile(cx, sharedScope, dir + "envjs/jquery.js");
		        Main.processFile(cx, sharedScope, dir + "envjs/jquery.linq.min.js");
		        Main.processFile(cx, sharedScope, dir + "envjs/moment.min.js");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cx.evaluateString(sharedScope, "var _s_obj = {};", "js_sharedScope_init", 1, null);	//_s_obj将用于跨表达式传值
//			// Force the LiveConnect stuff to be loaded. 
//			String loadMe = "RegExp; getClass; java; Packages; JavaAdapter;";
//			cx.evaluateString(sharedScope , loadMe, "lazyLoad", 0, null);
//	        sharedScope.sealObject();	//密封共享范围本身
	        //org.mozilla.javascript.EvaluatorException: Cannot modify a property of a sealed object: Envjs. (file:/E:/MyCode/WJRE/morpho/target/classes/envjs/env.rhino.js#8)
	        
	        jscontextHolder.set(cx);
	        String rhinoVersion = cx.getImplementationVersion();
	        console.println("rhinoVersion:"+rhinoVersion);
		}
//		if(scope == null) {
//	        scope = new Global(cx);
//		}
		Scriptable newScope = cx.newObject(sharedScope);
		newScope.setPrototype(sharedScope);
		newScope.setParentScope(null);
		return newScope;
	}
	
	protected void finalize( )
	{
		if (cx!=null) {
			cx.exit();
		}
	}

	public boolean eval(Object leftObj, Object right,Datatype datatype) {
		//忽略左侧运算数
		String tj = right == null ? null : right.toString().replace("\r", "\\n").replace("\n", "\\n").replace("\\n\n", "\\n");
		if(StringUtils.isBlank(tj)) {
			return true;
		}
		tj = tj.trim();
		String left = null;
		if(leftObj != null){
			left = datatype.convertObjectToString(leftObj).trim().replace("\r", "\\n").replace("\n", "\\n").replace("\\n\n", "\\n");
		}
		if(tj.startsWith("javascript:")){
			tj = tj.substring(11);
			if(StringUtils.isBlank(left)){
				tj = "var x=undefined;\n"+tj;
			} else {
				tj = "var x='"+left+"';\n"+tj;
			}

		} else {
			if(tj.equals(left)){
				console.println("\""+left+"\"匹配\""+tj+"\"");
				return true;
			} else if("true".equals(left)) {
				switch(tj) {	//肯定答案
					case "是":
					case "一致":
					case "存在":
					case "通过":
					case "有":
						console.println("\""+left+"\"匹配\""+tj+"\"");
						return true;
					default:
						console.println("\""+left+"\"不匹配\""+tj+"\"");
						return false;
				}
			} else if("false".equals(left)) {
				switch(tj) {	//否定答案
					case "不是":
					case "否":
					case "不一致":
					case "不存在":
					case "不通过":
					case "无":
					case "没有":
						console.println("\""+left+"\"匹配\""+tj+"\"");
						return true;
					default:
						console.println("\""+left+"\"不匹配\""+tj+"\"");
						return false;
				}
			} else {
				if(StringUtils.isBlank(left)) {
					left = "undefined";
				}
				tj = tj.replaceAll("\\s*", "");	//替换所有空白
				tj = tj.replace("≧", ">=");
				tj = tj.replace("≦", "<=");
				tj = tj.replace("≥", ">=");
				tj = tj.replace("≤", "<=");
				tj = tj.replace("＞", ">");
				tj = tj.replace("＜", "<");
				tj = tj.replace("÷", "/");
				tj = tj.replace("×", "*");
				tj = tj.replace("（", "(");
				tj = tj.replace("）", ")");
				tj = tj.replace("›", ">");
				//if(tj.indexOf('，') > 0 || tj.indexOf(',') > 0 || tj.indexOf('；') > 0 || tj.indexOf(';') > 0){
				{
					String spliter = ",|，|;|；";
					int indexOfJH = tj.indexOf('-');
					if(indexOfJH>0 && ((Character.isDigit(tj.charAt(indexOfJH-1))
							|| (tj.charAt(indexOfJH-1)!='=' && tj.charAt(indexOfJH-1)!='>' && tj.charAt(indexOfJH-1)!='<'
							&& tj.charAt(indexOfJH-1)!='、' && tj.charAt(indexOfJH-1)!='于')))){
						spliter+="|-";
					}
					String[] andParts = tj.split(spliter);
					List<String> fhlist = new ArrayList<String>(); Map<String, String> fhdict = new Hashtable<String, String>();
					fhlist.add("大于等于");			fhdict.put(fhlist.get(fhlist.size()-1), ">=");
					fhlist.add("大于或等于");		fhdict.put(fhlist.get(fhlist.size()-1), ">=");
					fhlist.add("小于等于");			fhdict.put(fhlist.get(fhlist.size()-1), "<=");
					fhlist.add("小于或等于");		fhdict.put(fhlist.get(fhlist.size()-1), "<=");
					fhlist.add("大于");				fhdict.put(fhlist.get(fhlist.size()-1), ">");
					fhlist.add("等于");				fhdict.put(fhlist.get(fhlist.size()-1), "==");
					fhlist.add("小于");				fhdict.put(fhlist.get(fhlist.size()-1), "<");
					fhlist.add("不等于");			fhdict.put(fhlist.get(fhlist.size()-1), "!=");
					fhlist.add("不大于");			fhdict.put(fhlist.get(fhlist.size()-1), "<=");
					fhlist.add("大小于");			fhdict.put(fhlist.get(fhlist.size()-1), ">=");

					String finddw = null;
					Map<String, String> dwdict = new Hashtable<String, String>();
					dwdict.put("万", "*10000");
					dwdict.put("%", "%");
					for(int i = 0 ; i<andParts.length; i++){
						//翻译中文比较运算
						for (String key: fhlist){
							if(andParts[i].startsWith(key)){
								andParts[i] = fhdict.get(key)+andParts[i].substring(key.length());
							}
						}
						//查找单位
						for (String dw: dwdict.keySet()){
							int indexOfDW = andParts[i].indexOf(dw);
							if(indexOfDW>0 && Character.isDigit(andParts[i].charAt(indexOfDW-1))){
								finddw = dw;
							}
						}
					}
					//if(!Character.isDigit(andParts[0].charAt(0)) || andParts[0].charAt(0)!='>' || andParts[0].charAt(0)!='<'
					//		|| andParts[0].charAt(0)!='=' || andParts[0].charAt(0)!='!' || andParts[0].charAt(0)!='-'){
					//	//淡季6个月以上
					//}
					//统一单位
					if(finddw!=null){
						for(int i = 0 ; i<andParts.length; i++){
							if(andParts[i].indexOf(finddw)<0){
								andParts[i] = andParts[i] + dwdict.get(finddw);	//TODO:插入到数字后面
							} else {
								andParts[i] = andParts[i].replace(finddw, dwdict.get(finddw));
							}
						}
					}
					boolean allHasNum = false;
					for(String andPart:andParts){
					    if(StringUtils.isNotBlank(andPart) && Pattern.compile("[0-9]").matcher(andPart).find()){
					        allHasNum = true;
                        } else {
					        allHasNum = false;
					        break;
                        }
                    }
					if(allHasNum){
					    StringBuilder sb = new StringBuilder();
                        for(int i = 0 ; i<andParts.length; i++){
                        	if(andParts[i].indexOf('、')>0) {
                        		//copy from line 235
    							String[] orParts = andParts[i].split("、");
    							for(int j=0;j<orParts.length;j++){
    								if(j==0){
    									sb.append("(");
    								}
    								boolean hasNum = false;
    								for(int k=0;k<orParts[j].length();k++) {
    									if(Character.isDigit(orParts[j].charAt(k))) {
    										hasNum = true;
    										break;
    									}
    								}
    								if(!hasNum && !"undefined".equals(left)) {
    									sb.append('\'');
    								}
    								sb.append(left);
    								if(!hasNum && !"undefined".equals(left)) {
    									sb.append('\'');
    								}
    								if(!hasNum) {
    									sb.append("==\'");
    								}
    								if(Character.isDigit(orParts[j].charAt(0))){
    									if(orParts[j].indexOf("以下")>0 || orParts[j].indexOf("以内")>0){
    										sb.append("<");
    										if(orParts[j].indexOf("不含")<0 && orParts[j].indexOf("不包含")<0 && orParts[j].indexOf("含")>0){
    											sb.append("=");
    										}
    									} else if (orParts[j].indexOf("以上")>0){
    										sb.append(">");
    										if(orParts[j].indexOf("不含")<0 && orParts[j].indexOf("不包含")<0 && orParts[j].indexOf("含")>0){
    											sb.append("=");
    										}
    									} else {
    										sb.append("==");
    									}
    								}
    								FixExprRight(orParts[j], sb);
    								if(!hasNum) {
    									sb.append('\'');
    								}
    								if(j!=orParts.length-1){
    									sb.append(" || ");
    								} else {
    									sb.append(")");
    								}
    							}
                        		continue;
                        	}
                            sb.append(left);
                            if(Character.isDigit(andParts[i].charAt(0))){
                            	if(andParts[i].indexOf("以下")>0 || andParts[i].indexOf("以内")>0){
									sb.append("<");
									if(andParts[i].indexOf("不含")<0 && andParts[i].indexOf("不包含")<0 && andParts[i].indexOf("含")>0){
										sb.append("=");
									}
								} else if (andParts[i].indexOf("以上")>0){
									sb.append(">");
									if(andParts[i].indexOf("不含")<0 && andParts[i].indexOf("不包含")<0 && andParts[i].indexOf("含")>0){
										sb.append("=");
									}
								} else if (andParts.length > 1) {
									sb.append(i % 2 == 0 ? ">" : "<");
									if(andParts[i].indexOf("不含")<0 && andParts[i].indexOf("不包含")<0){
										sb.append("=");
									}
								} else {
									sb.append("==");
								}
							}
							FixExprRight(andParts[i], sb);
                            if(i!=andParts.length-1){
                                sb.append(" && ");
                            }
                        }
						tj=sb.toString();
                    } else {
						StringBuilder sb = new StringBuilder();
						for(int i = 0 ; i<andParts.length; i++){
							String[] orParts = andParts[i].split("、");
							for(int j=0;j<orParts.length;j++){
								if(j==0){
									sb.append("(");
								}
								boolean hasNum = false;
								for(int k=0;k<orParts[j].length();k++) {
									if(Character.isDigit(orParts[j].charAt(k))) {
										hasNum = true;
										break;
									}
								}
								if(!hasNum && !"undefined".equals(left)) {
									sb.append('\'');
								}
								sb.append(left);
								if(!hasNum && !"undefined".equals(left)) {
									sb.append('\'');
								}
								if(!hasNum) {
									sb.append("==\'");
								}
								if(Character.isDigit(orParts[j].charAt(0))){
									if(orParts[j].indexOf("以下")>0 || orParts[j].indexOf("以内")>0){
										sb.append("<");
										if(orParts[j].indexOf("不含")<0 && orParts[j].indexOf("不包含")<0 && orParts[j].indexOf("含")>0){
											sb.append("=");
										}
									} else if (orParts[j].indexOf("以上")>0){
										sb.append(">");
										if(orParts[j].indexOf("不含")<0 && orParts[j].indexOf("不包含")<0 && orParts[j].indexOf("含")>0){
											sb.append("=");
										}
									} else {
										sb.append("==");
									}
								}
								FixExprRight(orParts[j], sb);
								if(!hasNum) {
									sb.append('\'');
								}
								if(j!=orParts.length-1){
									sb.append(" || ");
								} else {
									sb.append(")");
								}
							}

							if(i!=andParts.length-1){
								sb.append(" && ");
							}
						}
						tj=sb.toString();
					}
				}
			}
		}

	/*		ScriptEngineManager factory = new ScriptEngineManager();
			ScriptEngine engine = factory.getEngineByName("JavaScript");
			Object o = null;
			try {
				o = engine.eval(tj);
			} catch (ScriptException e) {
				//throw new Exception("", e);
				console_err.println("布尔表达式\"" + tj + "\"计算出错:" + e.getMessage());
				e.printStackTrace();
			}*/
		Object o = null;
		try {
//			init();	//每次都得调用，避免java.lang.RuntimeException: No Context associated with current Thread
//			if(scope==null) {
//				console_err.println("scope为空！");
//				scope = new Global(cx);
//			}
			Scriptable scope = init();
			o = cx.evaluateString(scope, tj, "js_CNMatchAssertor", 1, null);
		} catch (Exception e) {
			console_err.println("参数\""+left+"\", 表达式\"" + right + "\" => 布尔表达式(js表达式)\"" + tj + "\"计算出错:" + e.getMessage());
			throw e;
		}
		if(o==null) {
			console_err.println("警告：参数\""+left+"\", 表达式\"" + right + "\" => 布尔表达式(js表达式)\"" + tj + "\"计算结果为null！");
			return false;
		}
		boolean b = Boolean.parseBoolean(o.toString());

		console.println("参数\""+left+"\", 表达式\"" + right + "\" => 布尔表达式(js表达式)\"" + tj + "\"计算结果:" + b);
		return b;
	}

	private void FixExprRight(String andPart, StringBuilder sb) {
		int indexOfNumEnd = andPart.length();
		int numBegin = -1;
		for(int j = 0; j< andPart.length(); j++){
			if(numBegin>-1){
				if(!Character.isDigit(andPart.charAt(j)) && andPart.charAt(j)!='.' && andPart.charAt(j)!='/' && andPart.charAt(j)!='*'){
					indexOfNumEnd = j;
					break;
				}
			} else if(Character.isDigit(andPart.charAt(j))){
				numBegin = j;
			}
		}
		if(indexOfNumEnd<andPart.length() && andPart.charAt(indexOfNumEnd) == '%'){
			String numStr = andPart.substring(numBegin, indexOfNumEnd);
			BigDecimal num = BigDecimal.valueOf(Double.valueOf(numStr)).divide(BigDecimal.valueOf(100));
			sb.append(andPart.substring(0, numBegin));
			sb.append(num);
		} else {
			sb.append(andPart.substring(0, indexOfNumEnd));
		}
	}

	public boolean support(Op op) {
		return op.equals(Op.CNMatch);
	}
}
