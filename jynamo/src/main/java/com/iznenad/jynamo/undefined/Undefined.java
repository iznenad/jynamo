package com.iznenad.jynamo.undefined;

import com.iznenad.jynamo.function.Atom;

public final class Undefined implements Atom{

	private static Undefined instance;
	
	private Undefined(){
		
	}
	
	private enum Value{
		UNDEFINED;
	}
	
	@Override
	public String toString(){
		return Value.UNDEFINED.name().toLowerCase();
	}
	
	public static Undefined nil(){
		
		if(instance == null){
			instance = new Undefined();
		}
		
		return instance;
	}
	
}
