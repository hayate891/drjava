/*BEGIN_COPYRIGHT_BLOCK
 *
 * This file is a part of DrJava. Current versions of this project are available
 * at http://sourceforge.net/projects/drjava
 *
 * Copyright (C) 2001-2002 JavaPLT group at Rice University (javaplt@rice.edu)
 * 
 * DrJava is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * DrJava is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 * or see http://www.gnu.org/licenses/gpl.html
 *
 * In addition, as a special exception, the JavaPLT group at Rice University
 * (javaplt@rice.edu) gives permission to link the code of DrJava with
 * the classes in the gj.util package, even if they are provided in binary-only
 * form, and distribute linked combinations including the DrJava and the
 * gj.util package. You must obey the GNU General Public License in all
 * respects for all of the code used other than these classes in the gj.util
 * package: Dictionary, HashtableEntry, ValueEnumerator, Enumeration,
 * KeyEnumerator, Vector, Hashtable, Stack, VectorEnumerator.
 *
 * If you modify this file, you may extend this exception to your version of the
 * file, but you are not obligated to do so. If you do not wish to
 * do so, delete this exception statement from your version. (However, the
 * present version of DrJava depends on these classes, so you'd want to
 * remove the dependency first!)
 *
END_COPYRIGHT_BLOCK*/
/**
 * @version $Id$
 *
 * Tests Rule #1: Is START within a multiline comment?
 * (see http://www.owlnet.rice.edu/~creis/comp312/indentrules.html)
 *
 */

package edu.rice.cs.drjava.model.definitions.indent;

import junit.framework.*;
import edu.rice.cs.drjava.model.definitions.DefinitionsDocument;
import edu.rice.cs.drjava.model.definitions.reducedmodel.*;

public class QuestionInsideCommentTest extends IndentRulesTestCase {
  public QuestionInsideCommentTest(String name) {
    super(name);
  }
  // generic rule always returns false...
  // to use until we get the actual implementation
  static IndentRuleQuestion rule1 = new 
    IndentRuleQuestion(new ActionDoNothing(), new ActionDoNothing()) {
	  public boolean applyRule(DefinitionsDocument doc) { // Modified by Stephan
      return false;
    }
  };
    //  public void setUp() {
    //    try {
    //    _setDocText("\n/*\nfoo\n*/\nbar\nfoo /* bar\n// /*\nfoo */ bar\n// /*\nblah");
    //           .  .    .   .    .   .       .      .   .       .         .
    // sample code:          expected result:
    //                       F
    //  /*                   F
    //  foo                  T
    //  */                   T
    //  bar                  F
    //  foo /* bar           F,F
    //  // /*                T
    //  foo */ bar           T,T
    //  // /*
    //  blah                 F
    //    } catch (javax.swing.text.BadLocationException ex) {
    //      throw new RuntimeException("Bad Location Exception");
    //    }
    //  }

  public void testDummy() {}
  
  /*
  public void testDocStart() throws javax.swing.text.BadLocationException {      
    //_doc.setCurrentLocation(0);
    assertEquals(false, rule1.applyRule(_doc, 0));
  }
  public void testLineBeginsComment() throws javax.swing.text.BadLocationException {
    //_doc.setCurrentLocation(3);
    assertEquals(false, rule1.applyRule(_doc, 3));
  }
  public void testFooLine() throws javax.swing.text.BadLocationException {
    //_doc.setCurrentLocation(6);
    assertEquals(true, rule1.applyRule(_doc, 6));
  }
  public void testLineEndsComment() throws javax.swing.text.BadLocationException {
    //_doc.setCurrentLocation(9);
    assertEquals(true, rule1.applyRule(_doc, 9));
  }
  public void testBarLine() throws javax.swing.text.BadLocationException {
    //_doc.setCurrentLocation(13);
    assertEquals(false, rule1.applyRule(_doc, 13));
  }
  public void testSlashStarMidLineBefore() throws javax.swing.text.BadLocationException {
    //_doc.setCurrentLocation(16);
    assertEquals(false, rule1.applyRule(_doc, 16));
  }
  public void testSlashStarMidLineAfter() throws javax.swing.text.BadLocationException {
    //_doc.setCurrentLocation(24);
    assertEquals(false, rule1.applyRule(_doc, 24));
  }
  public void testCommentedOutSlashStar() throws javax.swing.text.BadLocationException {
    //_doc.setCurrentLocation(30);
    assertEquals(true, rule1.applyRule(_doc, 30));
  }
  public void testStarSlashMidLineBefore() throws javax.swing.text.BadLocationException {
    //_doc.setCurrentLocation(33);
    assertEquals(true, rule1.applyRule(_doc, 33));
  }
  public void testStarSlashMidLineAfter() throws javax.swing.text.BadLocationException {
    //_doc.setCurrentLocation(41);
    assertEquals(true, rule1.applyRule(_doc, 41));
  }
  public void testAfterCommentedOutSlashStar() throws javax.swing.text.BadLocationException {
    //_doc.setCurrentLocation(49);
    assertEquals(false, rule1.applyRule(_doc, 49));
  }
  */
}
