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

import java.io.IOException;
import java.net.URL;

import org.apache.commons.lang.StringUtils;

/*import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;*/
import org.mozilla.javascript.Context;
import org.mozilla.javascript.JavaScriptException;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.tools.shell.Global;
import org.mozilla.javascript.tools.shell.Main;

/**
 * @author Jacky.gao
 * @since 2015年1月6日
 */
public class IfAssertor extends AbstractDebugAssertor {
	
	private Context cx;
	//private Global scope;
	private static ScriptableObject sharedScope;
	static URL  dir;
	static {
        dir = IfAssertor.class.getResource("/");	//TODO:当前部署时需自行部署envjs到classes目录下
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

	public boolean eval(Object left, Object right,Datatype datatype) {
		//忽略左侧运算数
		String tj = right == null ? null : right.toString();
		if(StringUtils.isBlank(tj)) {
			return true;
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
			Scriptable scope = init();	//每次都得调用，避免java.lang.RuntimeException: No Context associated with current Thread
			o = cx.evaluateString(scope, tj, "js_IfAssertor", 1, null);
		} catch (JavaScriptException e) {
			//throw new Exception("", e);
			console_err.println("布尔表达式(js表达式)\"" + tj + "\"计算出错:" + e.getMessage());
			e.printStackTrace();
		}
		Boolean b = null;
		if(o==null || o instanceof org.mozilla.javascript.Undefined || StringUtils.isBlank(o.toString()) || "null".equals(o.toString().trim())) {
			b = false;
		} else {
			b = Boolean.parseBoolean(o.toString());
		}

		console.println("布尔表达式(js表达式)\"" + tj + "\"计算结果:" + b);
		return b.booleanValue();
	}

	public boolean support(Op op) {
		return op.equals(Op.If);
	}
}
