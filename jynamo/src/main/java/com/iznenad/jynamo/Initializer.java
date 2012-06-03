package com.iznenad.jynamo;

import java.util.Map;

import com.iznenad.jynamo.function.Atom;

public interface Initializer {
	void init(Map<Enum, Atom> hashMap);
}
 