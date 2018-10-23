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

/**
 * A set of all valid HTTP request methods.
 * @author nathiss
 */
public enum Method {
  /**
   * Transfer a current representation of the target resource.
   */
  GET,
  /**
   * Same as GET, but only transfer the status line and header section.
   */
  HEAD,
  /**
   * Perform resource-specific processing on the request payload.
   */
  POST,
  /**
   * Replace all current representations of the target resource with
   * the request payload.
   */
  PUT,
  /**
   * Remove all current representations of the target resource.
   */
  DELETE,
  /**
   * Establish a tunnel to the server identified by the target resource.
   */
  CONNECT,
  /**
   * Describe the communication options for the target resource.
   */
  OPTIONS,
  /**
   * Perform a message loop-back test along the path to the target resource.
   */
  TRACE;
  
  /**
   * Converts a string to Method.
   * @param method a textual HTTP method
   * @return converted HTTP request method
   * @see java.lang.String
   */
  public static Method toMethod(String method) {
    switch(method) {
      case "GET":
        return GET;
      case "HEAD":
        return HEAD;
      case "POST":
        return POST;
      case "PUT":
        return PUT;
      case "DELETE":
        return DELETE;
      case "CONNECT":
        return CONNECT;
      case "OPTIONS":
        return OPTIONS;
      case "TRACE":
        return TRACE;
      default:
        return null;
    }
  }
}
