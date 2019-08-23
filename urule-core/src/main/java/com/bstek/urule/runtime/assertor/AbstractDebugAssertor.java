package com.bstek.urule.runtime.assertor;

import java.io.PrintStream;

import com.bstek.urule.model.library.Datatype;

public abstract class AbstractDebugAssertor implements IDebugAssertor {
	
	protected PrintStream console;
	protected PrintStream console_err;
	
	public AbstractDebugAssertor() {
		console = System.out;
		console_err = System.err;
	}
	
	public boolean evalDebug(Object leftObj, Object right,Datatype datatype, PrintStream console, PrintStream console_err) {
		this.console = console;
		this.console_err = console_err;
		try {
			return eval(leftObj, right, datatype);
		}finally {
			this.console = System.out;
			this.console_err = System.err;
		}
	}

}
