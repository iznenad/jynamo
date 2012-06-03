package com.iznenad.jynamo.test

import spock.lang.Specification

import com.iznenad.junamo.testapp.Atoms
import com.iznenad.junamo.testapp.Prototypes
import com.iznenad.jynamo.JynamoObject
import com.iznenad.jynamo.function.Atom
import com.iznenad.jynamo.function.Value
import com.iznenad.jynamo.undefined.Undefined

class JynamoTest extends Specification{

	def object
	
	def setup(){
		object = new JynamoObject<Enum, Atom>().createFrom(Prototypes.Person.values())
	}
	
	def "test creation from prototype"(){

		expect:
		Prototypes.Person.values().each {
			assert object.get(it) == Undefined.nil()	
		}
	}
	
	def "test setting values"(){
		
		when:
		def newObject = object.giveMeACopyOfYouWithThis(Prototypes.Person.NAME, Atoms.helloWorldValue)
		
		then:
		object.get(Prototypes.Person.NAME) == Undefined.nil()
		newObject.get(Prototypes.Person.NAME) == Atoms.helloWorldValue
	} 
	
	def "test executing functions"(){
		when:
		def newObject = object.giveMeACopyOfYouWithThis(Prototypes.Person.AGE, Atoms.age)
		
		then:
		newObject.get(Prototypes.Person.AGE) == Atoms.age
		
		when:
		def thirdObject = Atoms.calculateAgeInFuture.execute(newObject)
		
		then:
		def atom = thirdObject.get(Prototypes.Person.AGE_IN_X_YEARS)
		
		expect:
		atom.get() == 25  
	}
}
