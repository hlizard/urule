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

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author Jacky.gao
 * @since 2015年1月6日
 */
public class IfAssertor implements Assertor {

	public boolean eval(Object left, Object right,Datatype datatype) {
		//忽略左侧运算数
		String tj = right == null ? null : right.toString();
		if(StringUtils.isBlank(tj)) {
			return true;
		}
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("JavaScript");
		Object o = null;
		try {
			o = engine.eval(tj);
		} catch (ScriptException e) {
			//throw new Exception("", e);
			System.err.println("布尔表达式\"" + tj + "\"计算出错:" + e.getMessage());
			e.printStackTrace();
		}
		Boolean b = Boolean.parseBoolean(o.toString());

		System.out.println("布尔表达式\"" + tj + "\"计算结果:" + b);
		return b;
	}

	public boolean support(Op op) {
		return op.equals(Op.If);
	}
}
