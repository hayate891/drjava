/*BEGIN_COPYRIGHT_BLOCK
 *
 * Copyright (c) 2001-2008, JavaPLT group at Rice University (drjava@rice.edu)
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *    * Redistributions of source code must retain the above copyright
 *      notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above copyright
 *      notice, this list of conditions and the following disclaimer in the
 *      documentation and/or other materials provided with the distribution.
 *    * Neither the names of DrJava, the JavaPLT group, Rice University, nor the
 *      names of its contributors may be used to endorse or promote products
 *      derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * This software is Open Source Initiative approved Open Source Software.
 * Open Source Initative Approved is a trademark of the Open Source Initiative.
 * 
 * This file is part of DrJava.  Download the current version of this project
 * from http://www.drjava.org/ or http://sourceforge.net/projects/drjava/
 * 
 * END_COPYRIGHT_BLOCK*/

package edu.rice.cs.javalanglevels;

import java.io.*;

/**
 * A simple tuple class to represent source location for pieces of the AST.
 */
public final class SourceInfo {
  
  /**The file this SourceInfo belongs to*/
  private final File _file;
  
  /**The line this piece of the AST starts on*/
  private final int _startLine;
  
  /**The column this piece of the AST starts on*/
  private final int _startColumn;
  
  /**The line this piece of the AST ends on*/
  private final int _endLine;
  
  /**The column this piece of the AST ends on*/
  private final int _endColumn;

  /**
   * Constructs a SourceInfo, given a value for the file and the coordinates.
   */
  public SourceInfo(File file,
                    int startLine,
                    int startColumn,
                    int endLine,
                    int endColumn)
  {
    _file = file;
    _startLine = startLine;
    _startColumn = startColumn;
    _endLine = endLine;
    _endColumn = endColumn;
  }

  /**@return the file*/
  final public File getFile() { return _file; }

  /**@return the start line*/
  final public int getStartLine() { return _startLine; }
  
  /**@return the start column*/
  final public int getStartColumn() { return _startColumn; }
  
  /**@return the end line*/
  final public int getEndLine() { return _endLine; }
  
  /**@return the end column*/
  final public int getEndColumn() { return _endColumn; }

  /**@return a readable representation of the information stored in this SourceInfo*/
  public String toString() {
    String fileName;
    if (_file == null) {
      fileName = "(no file)";
    }
    else {
      fileName = _file.getName();
    }

    return "[" + fileName + ": " +
           "(" + _startLine + "," + _startColumn + ")-" +
           "(" + _endLine + "," + _endColumn + ")]";
  }

  /**All fields must match for these to be equal*/
  public boolean equals(Object obj) {
    if (obj == null) return false;

    if (obj.getClass() != this.getClass()) {
      return false;
    }
    else {
      SourceInfo casted = (SourceInfo) obj;

      File tF = getFile();
      File oF = casted.getFile();

      if ( ((tF == null) && (oF != null)) ||
           ((tF != null) && ! tF.equals(oF)))
      {
        return false;
      }

      if (! (getStartLine() == casted.getStartLine())) return false;
      if (! (getStartColumn() == casted.getStartColumn())) return false;
      if (! (getEndLine() == casted.getEndLine())) return false;
      if (! (getEndColumn() == casted.getEndColumn())) return false;
      return true;
    }
  }

  /**
   * Implementation of hashCode that is consistent with
   * equals. The value of the hashCode is formed by
   * XORing the hashcode of the class object with
   * the hashcodes of all the fields of the object.
   */
  public final int hashCode() {
    int code = getClass().hashCode();

    if (getFile() != null) {
      code ^= getFile().hashCode();
    }

    code ^= getStartLine();
    code ^= getStartColumn();
    code ^= getEndLine();
    code ^= getEndColumn();
    return code;
  }
}
