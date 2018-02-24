package com.cts.innerClass;
public class SpellChecker {
	private String test;
   public SpellChecker(){
	   test="swarup";
      System.out.println("Inside SpellChecker constructor." );
   }
   
   public void checkSpelling(){
      System.out.println("Inside checkSpelling." );
   }

public String getTest() {
	return test;
}

public void setTest(String test) {
	this.test = test;
}
}