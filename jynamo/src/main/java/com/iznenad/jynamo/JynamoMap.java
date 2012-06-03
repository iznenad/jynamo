package com.iznenad.jynamo;

import java.util.Map;

public interface JynamoMap<Enum, Atom> extends Map<Enum ,Atom>{

	JynamoMap<Enum, Atom> giveMeACopyOfYouWithThis(Enum e, Atom a);
	
	void prototype(Initializer initializer);
	
}
  