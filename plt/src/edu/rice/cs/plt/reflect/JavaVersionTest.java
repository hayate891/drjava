/*BEGIN_COPYRIGHT_BLOCK*

PLT Utilities BSD License

Copyright (c) 2007-2008 JavaPLT group at Rice University
All rights reserved.

Developed by:   Java Programming Languages Team
                Rice University
                http://www.cs.rice.edu/~javaplt/

Redistribution and use in source and binary forms, with or without modification, are permitted 
provided that the following conditions are met:

    - Redistributions of source code must retain the above copyright notice, this list of conditions 
      and the following disclaimer.
    - Redistributions in binary form must reproduce the above copyright notice, this list of 
      conditions and the following disclaimer in the documentation and/or other materials provided 
      with the distribution.
    - Neither the name of the JavaPLT group, Rice University, nor the names of the library's 
      contributors may be used to endorse or promote products derived from this software without 
      specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR 
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND 
FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS AND 
CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL 
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, 
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER 
IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

*END_COPYRIGHT_BLOCK*/

package edu.rice.cs.plt.reflect;

import java.util.Set;
import java.util.TreeSet;
import edu.rice.cs.plt.iter.IterUtil;
import junit.framework.TestCase;

import static edu.rice.cs.plt.reflect.JavaVersion.*;

public class JavaVersionTest extends TestCase {
  
  public void testParseClassVersion() {
    assertEquals(JAVA_6, parseClassVersion("50.0"));
    assertEquals(JAVA_5, parseClassVersion("49.0"));
    assertEquals(JAVA_1_4, parseClassVersion("48.0"));
  }
  
  public void testParseFullVersion() {
    FullVersion v1 = parseFullVersion("1.4.2_10");
    assertEquals(JAVA_1_4, v1.majorVersion());
    assertEquals("1.4.2_10", v1.versionString());
    
    FullVersion v2 = parseFullVersion("1.4.3");
    assertEquals(JAVA_1_4, v2.majorVersion());
    assertEquals("1.4.3", v2.versionString());
    
    FullVersion v3 = parseFullVersion("1.5.0.1");
    assertEquals(JAVA_5, v3.majorVersion());
    assertEquals("5.0_1", v3.versionString());
    
    FullVersion v4 = parseFullVersion("1.5.1-beta");
    assertEquals(JAVA_5, v4.majorVersion());
    assertEquals("5.1-beta", v4.versionString());
    
    FullVersion v5 = parseFullVersion("1.5.1");
    assertEquals(JAVA_5, v5.majorVersion());
    assertEquals("5.1", v5.versionString());
    
    FullVersion v6 = parseFullVersion("1.6.0_2");
    assertEquals(JAVA_6, v6.majorVersion());
    assertEquals("6.0_2", v6.versionString());
    
    FullVersion v7 = parseFullVersion("1.6.0_11");
    assertEquals("6.0_11", v7.versionString());
    
    Set<FullVersion> sorter = new TreeSet<FullVersion>();
    sorter.add(v7);
    sorter.add(v5);
    sorter.add(v3);
    sorter.add(v1);
    sorter.add(v2);
    sorter.add(v4);
    sorter.add(v6);
    
    assertTrue(IterUtil.isEqual(sorter, IterUtil.make(v1, v2, v3, v4, v5, v6, v7)));
  }
  
}
