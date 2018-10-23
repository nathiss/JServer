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

/**
 * A set of all used HTTP response codes.
 * @author nathiss
 */
public enum Code {
  /**
   * OK
   */
  OK(200),
  
  /**
   * Bad Request
   */
  BAD_REQUEST(400),
  
  /**
   * Forbidden
   */
  FORBIDDEN(403),
  
  /**
   * Not Found
   */
  NOT_FOUND(404),
  
  /**
   * Method Not Allowed
   */
  METHOD_NOT_ALLOWED(405),
  
  /**
   * Internal Server Error
   */
  INTERNAL_SERVER_ERROR(500),
  
  /**
   * Not Implemented
   */
  NOT_IMPLEMENTED(501),
  
  /**
   * HTTP Version Not Supported 
   */
  HTTP_VERSION_NOT_SUPPORTED(505);
  
  /**
   * Returns textual reason phrase for all the codes above or null if not
   * supported.
   * @param code HTTP response code
   * @return textual reason phrase or null if not implemented
   * @see java.lang.String
   * @see jserver.http.response.Code
   */
  public static String getReasonPhrase(Code code) {
    switch(code) {
      case OK:
        return "OK";
      case BAD_REQUEST:
        return "Bad Request";
      case FORBIDDEN:
        return "Forbidden";
      case NOT_FOUND:
        return "Not Found";
      case METHOD_NOT_ALLOWED:
        return "Method Not Allowed";
      case HTTP_VERSION_NOT_SUPPORTED:
        return "HTTP Version Not Supported";
      default:
        return null;
    }
  }
  
  /**
   * Returns an integer value of enum constant.
   * @return an integer value
   */
  public int getValue() {
    return this.id;
  }
  
  /**
   * Sets a value of a enum constant.
   * @param id an integer value
   * @see jserver.http.response.Code
   */
  private Code(int id) {
    this.id = id;
  }
  
  /**
   * Constant integer value. 
   */
  private final int id;
}
