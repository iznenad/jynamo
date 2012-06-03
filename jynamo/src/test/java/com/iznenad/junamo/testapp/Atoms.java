package com.iznenad.junamo.testapp;

import com.iznenad.jynamo.JynamoMap;
import com.iznenad.jynamo.function.Atom;
import com.iznenad.jynamo.function.Function;
import com.iznenad.jynamo.function.Value;

public class Atoms {

	public static Value<String> helloWorldValue = new Value<String>() {
		
		public String get() {
			return "Hello, World!";
		}
		
		public Class type() {
			return String.class;
		}
	};
	
	public static Value<Integer> age = new Value<Integer>(){
		
		public Integer get() {return new Integer(10);};
		
		public Class type() {return Integer.class;};
	};
	
	public static Function<Integer> calculateAgeInFuture = new Function<Integer>() {
		
		public <T> JynamoMap<Enum, Atom> execute(JynamoMap<Enum, Atom> parameters) {
			
			final Value<Integer> age = (Value)parameters.get(Prototypes.Person.AGE);
			
			return parameters.giveMeACopyOfYouWithThis(Prototypes.Person.AGE_IN_X_YEARS, new Value<Integer>() {
				public Integer get() {
					return age.get() + 15;
				}
				
				public Class type() {
					return Integer.class;
				}
			});
		}
	};
}
