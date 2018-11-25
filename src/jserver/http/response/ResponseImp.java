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

import java.nio.charset.Charset;
import jserver.http.HttpDate;
import jserver.http.ProtocolVersion;

/**
 * Object representation of HTTP response.
 */
public class ResponseImp implements Response {
  public ResponseImp() {
    this.version = null;
    this.code = null;
    this.mimeType = null;
    this.data = null;
    this.lastModified = null;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isValid() {
    return this.version != null &&
           this.code != null &&
           this.mimeType != null &&
           this.data != null;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setProtocolVersion(ProtocolVersion version) {
    this.version = version;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setCode(Code code) {
    this.code = code;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setMimeType(MimeType type) {
    this.mimeType = type;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public void setLastModified(HttpDate date) {
    this.lastModified = date;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setContent(String data) {
    this.data = data;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public String toString() {
    if (!this.isValid())
      return null;
    
    String ret = ProtocolVersion.getProtocolVersionText(this.version) + " ";
    ret += 
      this.code.getValue() + " " + Code.getReasonPhrase(this.code) + "\r\n";
    
    if (this.lastModified != null)
      ret += "Last-Modified: " + this.lastModified.toString() + "\r\n";
    
    ret += "Connection : close\r\n";  // We're supporting persisting connection.
    ret += "Date: " + this.getServerTime() + "\r\n";
    ret += "Server: JServer\r\n";
    ret += "Content-Length: " + this.data.length() + "\r\n";
    // TODO(nathiss): charset hard coded...
    ret += "Content-Type: " + MimeType.getMimeTypeText(this.mimeType) + "; ";
    ret += "charset=UTF-8\r\n";
    ret += "\r\n";
    ret += this.data + "\r\n";
    return ret;
  }
  
  /**
   * Returns a string representation of a current time. 
   * @return a string representation of a current time
   */
  private String getServerTime() {
    return new HttpDate().toString();
  }
  
  /**
   * HTTP protocol version of a response.
   */
  private ProtocolVersion version;
  
  /**
   * HTTP status code.
   */
  private Code code;
  
  /**
   * HTTP MIME Type of a payload.
   */
  private MimeType mimeType;
  
  /**
   * HTTP payload.
   */
  private String data;
  
  /**
   * A date of a file last modification.
   */
  private HttpDate lastModified;
}
