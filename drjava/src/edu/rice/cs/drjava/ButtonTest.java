package  edu.rice.cs.drjava;

import  junit.framework.*;
import  java.io.File;
import  java.util.Vector;
import  javax.swing.text.BadLocationException;
import  junit.extensions.*;


/**
 * @version $Id$
 * put your documentation comment here
 */
public class ButtonTest extends TestCase {
  MainFrame _m;

  /**
   * put your documentation comment here
   * @param   String name
   */
  public ButtonTest(String name) {
    super(name);
  }

  /**
   * put your documentation comment here
   */
  public void setUp() {
    _m = new MainFrame();
  }

  /**
   * put your documentation comment here
   * @return 
   */
  public static Test suite() {
    return  new TestSuite(ButtonTest.class);
  }

  /**
   * put your documentation comment here
   */
  public void testSaveButtonInitiallyDisabled() {
    assertTrue(!_m._saveButton.isEnabled());
  }

  /**
   * put your documentation comment here
   */
  public void testCompileButtonInitiallyDisabled() {
    assertTrue(!_m._compileButton.isEnabled());
  }

  /**
   * put your documentation comment here
   * @exception BadLocationException
   */
  public void testSaveEnabledAfterModification() throws BadLocationException {
    DefinitionsDocument d = _m.getDefPane()._doc();
    d.insertString(0, "this is a test", null);
    assertTrue(_m._saveButton.isEnabled());
  }

  /**
   * put your documentation comment here
   * @exception BadLocationException
   */
  public void testCompileDisabledAfterModification() throws BadLocationException {
    DefinitionsDocument d = _m.getDefPane()._doc();
    d.insertString(0, "this is a test", null);
    assertTrue(!_m._compileButton.isEnabled());
  }

  /**
   * put your documentation comment here
   * @exception BadLocationException
   */
  public void testCompileEnabledAfterSave() throws BadLocationException {
    DefinitionsPane v = _m.getDefPane();
    DefinitionsDocument d = v._doc();
    d.insertString(0, "this is a test", null);
    assertTrue(_m.saveToFile("button-test-file"));
    assertTrue(_m._compileButton.isEnabled());
    assertTrue(new File("button-test-file").delete());
  }

  /**
   * put your documentation comment here
   * @exception BadLocationException
   */
  public void testSaveDisabledAfterSave() throws BadLocationException {
    DefinitionsPane v = _m.getDefPane();
    DefinitionsDocument d = v._doc();
    d.insertString(0, "this is a test", null);
    assertTrue(_m.saveToFile("button-test-file"));
    assertTrue(!_m._saveButton.isEnabled());
    assertTrue(new File("button-test-file").delete());
  }

  /**
   * put your documentation comment here
   * @exception BadLocationException
   */
  public void testCompileDisabledAfterCompile() throws BadLocationException {
    DefinitionsPane v = _m.getDefPane();
    DefinitionsDocument d = v._doc();
    d.insertString(0, "public class C{}", null);
    assertTrue(_m.saveToFile("C.java"));
    try {
      _m.compile();
    } catch (NullPointerException ex) {
    // A compilation will cause messages to be written to
    // the compile-errors window, which doesn't exist in a
    // barebones MainFrame.
    }
    assertTrue(!_m._compileButton.isEnabled());
    new File("C.java").delete();
    new File("C.class").delete();
  }
}



