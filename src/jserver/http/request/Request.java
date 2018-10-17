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
 * Object representation of HTTP request.
 * @author nathiss
 */
public interface Request {
  /**
   * Returns true if the request has been parsed properly, false otherwise.
   * @return true if the request has been parsed properly, false otherwise
   */
  public boolean isValid();
  
  /**
   * Returns a HTTP request method or null if the request is invalid.
   * @return a HTTP request method or null if the request is invalid
   */
  public Method getMethod();
  
  /**
   * Returns a URI or null if the request is invalid.
   * @return a URI or null if the request is invalid
   */
  public String getUri();
  
  /**
   * Returns a HTTP protocol version or null if the request is invalid.
   * @return a HTTP protocol version or null if the request is invalid
   */
  public ProtocolVersion getProtocolVersion();
  
  /**
   * Returns an associated value for a given key or null if key does not exist.
   * @param key an index in the associative array
   * @return a value associated with a given key or null if key does not exist
   */
  public String get(String key);
  
  /**
   * Returns true if a given key exists in the associative array,
   * false otherwise.
   * @param key a given key
   * @return true if a given key exists in the associative array,
   * false otherwise
   */
  public boolean hasKey(String key);
}
