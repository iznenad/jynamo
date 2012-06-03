package com.iznenad.jynamo.function;

import com.iznenad.jynamo.JynamoMap;

public interface Function<K> extends Atom {

	<T> JynamoMap<Enum, Atom> execute(JynamoMap<Enum, Atom> parameters);
	
}
