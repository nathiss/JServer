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

import java.util.HashMap;
import jserver.http.ProtocolVersion;

/**
 * Object representation of HTTP request.
 * @author nathiss
 */
public class RequestImp implements Request {
  public RequestImp() {
    this.method = null;
    this.uri = null;
    this.version = null;
    this.fields = new HashMap<>();
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isValid() {
    return this.getMethod() != null &&
           this.getUri() != null    &&
           this.getProtocolVersion() != null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Method getMethod() {
    return this.method;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getUri() {
    return this.uri;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public ProtocolVersion getProtocolVersion() {
    return this.version;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String get(String key) {
    return this.fields.get(key);
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public boolean hasKey(String key) {
    return this.fields.containsKey(key);
  }
  
  /**
   * Sets a HTTP request method
   * @param method HTTP request method
   */
  public void setMethod(Method method) {
    this.method = method;
  }
  
  /**
   * Sets a HTTP request URI
   * @param uri HTTP request URI
   */
  public void setUri(String uri) {
    this.uri = uri;
  }
  
  /**
   * Sets a HTTP protocol version
   * @param version HTTP protocol version
   */
  public void setProtocolVersion(ProtocolVersion version) {
    this.version = version;
  }
  
  /**
   * Adds a field to associative array.
   * @param key a key to be stored in a map
   * @param value a value to be stored in a map under a given key
   */
  public void addField(String key, String value) {
    this.fields.put(key, value);
  }
  
  /**
   * A method of HTTP request.
   */
  private Method method;
  
  /**
   * A URI of HTTP request.
   */
  private String uri;
  
  /**
   * A HTTP protocol version.
   */
  private ProtocolVersion version;
  
  /**
   * Associative array of key-value pairs from HTTP request header fields.
   */
  private final HashMap<String, String> fields;
  
}
