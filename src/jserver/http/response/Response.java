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
package jserver.http.response;

import jserver.http.ProtocolVersion;

/**
 * Object representation of HTTP response.
 * @author nathiss
 */
public interface Response {
  /**
   * Sets a HTTP protocol version for server response. 
   * @param version HTTP protocol version
   */
  public void setProtocolVersion(ProtocolVersion version);
  
  /**
   * Sets a HTTP response code.
   * @param code HTTP response code.
   */
  public void setCode(Code code);
  
  /**
   * Sets a HTTP response MIME type.
   * @param type HTTP response MIME type
   */
  public void setMIME(MimeType type);
  
  /**
   * Sets a payload for a HTTP response.
   * @param data response content
   */
  public void setContent(String data);
}
