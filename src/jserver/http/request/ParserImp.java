/*
 * The MIT License
 *
 * Copyright 2018 nathiss.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package jserver.http.request;

import jserver.http.ProtocolVersion;

/**
 * ParserImp for HTTP request.
 * @author nathiss
 */
public class ParserImp implements Parser {
  /**
   * {@inheritDoc}
   */
  @Override
  public Request parse(String [][] data) {
    this.data = data;
     RequestImp ret = new RequestImp();
    
     // "METHOD URI PROTOCOL_VERSION"
    if (data.length < 1 || data[0].length != 3)
      return ret;
    ret.setMethod(this.getMethod());
    ret.setUri(this.getUri());
    ret.setProtocolVersion(this.getProtocolVersion());
    
    for (int i = 1; i < data.length; i++) {
      if (data[i].length != 2) // if does not look like "key: value" shema.
        continue;
      int keyLength = data[i][0].length();
      // if colon isn't present then don't parse this line.
      if (data[i][0][keyLength - 1] != ":")
        continue;
      ret.addField(data[i][0].substring(0, keyLength - 1), data[i][1]);
    }
    
    return ret;
  }
  
  /**
   * Returns HTTP request method converted from a string. 
   * @return HTTP request method
   */
  private Method getMethod() {
    return  Method.toMethod(this.data[0][0]);
  }
  
  /**
   * Returns HTTP request URI.
   * @return HTTP request URI
   */
  private String getUri() {
    return this.data[0][1];
  }
  
  /**
   * Returns HTTP protocol version converted from a string
   * @return HTTP protocol version 
   */
  private ProtocolVersion getProtocolVersion() {
    return ProtocolVersion.toProtocolVersion(this.data[0][2]);
  }
  
  /**
   * Lexed HTTP request.
   */
  private String [][] data;
}
