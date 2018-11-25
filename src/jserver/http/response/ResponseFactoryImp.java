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
 * Creates response objects for each of HTTP status codes. 
 */
public class ResponseFactoryImp implements ResponseFactory {

  /**
   * {@inheritDoc}
   */
  @Override
  public Response make(Code code) {
    switch(code) {
      case OK:
        return this.makeOk();
      case BAD_REQUEST:
        return this.makeBadRequest();
      case FORBIDDEN:
        return this.makeForbidden();
      case NOT_FOUND:
        return this.makeNotFound();
      case METHOD_NOT_ALLOWED:
        return this.makeMethodNotAllowed();
      case INTERNAL_SERVER_ERROR:
        return this.makeInternalServerError();
      case NOT_IMPLEMENTED:
        return this.makeNotImplemented();
      case HTTP_VERSION_NOT_SUPPORTED:
        return this.makeHttpVersionNotSupported();
    }
    return null;
  }
  
  /**
   * Creates a HTTP OK response.
   * @return HTTP OK response
   * @see jserver.http.response.Response
   */
  private Response makeOk() {
    Response ret = new ResponseImp();
    ret.setCode(Code.OK);
    ret.setMimeType(MimeType.text_plain);
    ret.setProtocolVersion(ProtocolVersion.HTTP_1_1);
    ret.setContent("200 OK");
    
    return ret;
  }
  
  /**
   * Creates a HTTP Bad Request response.
   * @return HTTP Bad Request response
   * @see jserver.http.response.Response
   */
  private Response makeBadRequest() {
    Response ret = new ResponseImp();
    ret.setCode(Code.BAD_REQUEST);
    ret.setMimeType(MimeType.text_html);
    ret.setProtocolVersion(ProtocolVersion.HTTP_1_1);
    ret.setContent("<h1>400 Bad Request</h1>");
    
    return ret;
  } 
  
  /**
   * Creates a HTTP Forbidden response.
   * @return HTTP Forbidden response
   * @see jserver.http.response.Response
   */
  private Response makeForbidden() {
    Response ret = new ResponseImp();
    ret.setCode(Code.FORBIDDEN);
    ret.setMimeType(MimeType.text_html);
    ret.setProtocolVersion(ProtocolVersion.HTTP_1_1);
    ret.setContent("<h1>403 FORBIDDEN</h1>");
    
    return ret;
  }
  
  /**
   * Creates a HTTP Not Found response.
   * @return HTTP Not Found response
   * @see jserver.http.response.Response
   */
  private Response makeNotFound() {
    Response ret = new ResponseImp();
    ret.setCode(Code.NOT_FOUND);
    ret.setMimeType(MimeType.text_html);
    ret.setProtocolVersion(ProtocolVersion.HTTP_1_1);
    ret.setContent("<h1>404 Not Found</h1>");
    
    return ret;
  }
  
  /**
   * Creates a HTTP Method Not Allowed response.
   * @return HTTP Method Not Allowed response
   * @see jserver.http.response.Response
   */
  private Response makeMethodNotAllowed() {
    Response ret = new ResponseImp();
    ret.setCode(Code.METHOD_NOT_ALLOWED);
    ret.setMimeType(MimeType.text_html);
    ret.setProtocolVersion(ProtocolVersion.HTTP_1_1);
    ret.setContent("<h1>405 Method Not Allowed</h1>");
    
    return ret;
  }
  
  /**
   * Creates a HTTP Internal Server Error response.
   * @return HTTP Internal Server Error response
   * @see jserver.http.response.Response
   */
  private Response makeInternalServerError() {
    Response ret = new ResponseImp();
    ret.setCode(Code.INTERNAL_SERVER_ERROR);
    ret.setMimeType(MimeType.text_html);
    ret.setProtocolVersion(ProtocolVersion.HTTP_1_1);
    ret.setContent("<h1>500 Internal Server Error</h1>");
    
    return ret;
  }
  
  /**
   * Creates a HTTP Not Implemented response.
   * @return HTTP Not Implemented response
   * @see jserver.http.response.Response
   */
  private Response makeNotImplemented() {
    Response ret = new ResponseImp();
    ret.setCode(Code.NOT_IMPLEMENTED);
    ret.setMimeType(MimeType.text_html);
    ret.setProtocolVersion(ProtocolVersion.HTTP_1_1);
    ret.setContent("<h1>501 Not Implemented</h1>");
    
    return ret;
  }
  
  /**
   * Creates a HTTP Version Not Supported response.
   * @return HTTP Version Not Supported response
   * @see jserver.http.response.Response
   */
  private Response makeHttpVersionNotSupported() {
    Response ret = new ResponseImp();
    ret.setCode(Code.HTTP_VERSION_NOT_SUPPORTED);
    ret.setMimeType(MimeType.text_html);
    ret.setProtocolVersion(ProtocolVersion.HTTP_1_1);
    ret.setContent("<h1>505 HTTP Version Not Supported</h1>");
    
    return ret;
  }
  
}
