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
package jserver.http;

/**
 * A set of valid HTTP protocol versions.
 * @author nathiss
 */
public enum ProtocolVersion {
  /**
   * HTTP/1.0
   */
  HTTP_1_0,
  
  /**
   * HTTP/1.1
   */
  HTTP_1_1;
  
  /**
   * Return textual phrase for all the versions above or null if not supported.
   * @param version HTTP protocol version
   * @return textual phrase or null if not implemented
   */
  public static String getProtocolVersionText(ProtocolVersion version) {
    switch(version) {
      case HTTP_1_0:
        return "HTTP/1.0";
      case HTTP_1_1:
        return "HTTP/1.1";
      default:
        return null;
    }
  }
  
  /**
   * Converts a string to HTTP protocol version.
   * @param version a textual HTTP protocol version
   * @return converted HTTP protocol version
   */
  public static ProtocolVersion toProtocolVersion(String version) {
    switch(version) {
      case "HTTP/1.0":
        return HTTP_1_0;
      case "HTTP/1.1":
        return HTTP_1_1;
      default:
        return null;
    }
  }
}
