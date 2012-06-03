package com.iznenad.jynamo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.iznenad.jynamo.function.Atom;
import com.iznenad.jynamo.undefined.Undefined;

public class JynamoObject implements JynamoMap<Enum, Atom>{

	private Map<Enum,Atom> hashMap;
	
	private JynamoObject(){}
	
	private JynamoObject(JynamoObject original){
		this.hashMap = original.giveEssence();
	}
	
	public void clear() {
		hashMap.clear();
	}

	public boolean containsKey(Object key) {
		return hashMap.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return hashMap.containsValue(value);
	}

	public Set<Map.Entry<Enum, Atom>> entrySet() {
		return hashMap.entrySet();
	}

	public Atom get(Object key) {
		return hashMap.get(key);
	}

	public boolean isEmpty() {
		return hashMap.isEmpty();
	}

	public Set<Enum> keySet() {
		return hashMap.keySet();
	}

	public Atom put(Enum key, Atom value) {
		return hashMap.put(key, value);
	}

	public void putAll(Map<? extends Enum, ? extends Atom> m) {
		hashMap.putAll(m);
	}

	public Atom remove(Object key) {
		return hashMap.remove(key);
	}

	public int size() {
		return hashMap.size();
	}

	public Collection<Atom> values() {
		return hashMap.values();
	}

	public JynamoMap<Enum, Atom> createFrom(Enum[] prototype) {
		if(hashMap == null)
			hashMap = new HashMap<Enum, Atom>(); 
		
		for(Enum key : prototype){
			hashMap.put(key, (Atom)Undefined.nil());
		}
		return this;
	}

	private HashMap<Enum, Atom> giveEssence(){
		return new HashMap<Enum, Atom>(hashMap);
	}
	
	public JynamoMap<Enum, Atom> giveMeACopyOfYouWithThis(Enum e, Atom a) {
		JynamoObject copycat = new JynamoObject(this);
		copycat.put(e, a);
		return copycat;
	}
 
	public void prototype(Initializer initializer) { 
		initializer.init(hashMap);
	} 
	
}
