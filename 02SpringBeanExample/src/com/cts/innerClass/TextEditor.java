package com.cts.innerClass;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
	
   private SpellChecker spellChecker;
  // @Autowired
    // a setter method to inject the dependency.
   public void setSpellChecker(SpellChecker spellChecker) {
      System.out.println("Inside setSpellChecker." );
      this.spellChecker = spellChecker;
   }
   
   // a getter method to return spellChecker
   public SpellChecker getSpellChecker() {
      return spellChecker;
   }
   public void spellCheck() {
      spellChecker.checkSpelling();
   }




}