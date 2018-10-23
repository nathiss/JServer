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

import jserver.http.HttpDate;
import jserver.http.ProtocolVersion;

/**
 * Object representation of HTTP response.
 * @author nathiss
 */
public interface Response {
  /**
   * Returns true if the response is valid, false otherwise.
   * @return true if the response is valid, false otherwise
   */
  public boolean isValid();  

  /**
   * Sets a HTTP protocol version for server response. 
   * @param version HTTP protocol version
   * @see jserver.http.ProtocolVersion
   */
  public void setProtocolVersion(ProtocolVersion version);
  
  /**
   * Sets a HTTP response code.
   * @param code HTTP response code
   * @see jserver.http.response.Code
   */
  public void setCode(Code code);
  
  /**
   * Sets a HTTP response MIME type.
   * @param type HTTP response MIME type
   * @see jserver.http.response.MimeType
   */
  public void setMimeType(MimeType type);
  
  /**
   * Sets a last modification date of a file.
   * @param date a last modification date
   * @see jserver.http.HttpDate
   */
  public void setLastModified(HttpDate date);
  
  /**
   * Sets a payload for a HTTP response.
   * @param data response content
   * @see java.lang.String
   */
  public void setContent(String data);
  
  /**
   * Sets a keep-alive flag
   * @param flag a keep-alive flag
   */
  public void setKeepAlive(boolean flag);
  
  /**
   * Serializes the object to HTTP server response.
   * @return serialized object
   * @see java.lang.String
   */
  @Override
  public String toString();
}
