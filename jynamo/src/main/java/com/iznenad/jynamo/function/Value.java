package com.iznenad.jynamo.function;

public interface Value<Type> extends Atom {

	Class type();
	
	Type get();
	
}
