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
package jserver.client;

import java.net.Socket;
import jserver.filesystem.File;
import jserver.filesystem.Filesystem;
import jserver.filesystem.FilesystemFactory;
import jserver.filesystem.FilesystemFactoryImp;
import jserver.http.ProtocolVersion;
import jserver.http.request.Lexer;
import jserver.http.request.Parser;
import jserver.http.request.Request;
import jserver.http.request.RequestFactory;
import jserver.http.request.RequestFactoryImp;
import jserver.http.response.Code;
import jserver.http.response.MimeType;
import jserver.http.response.Response;
import jserver.http.response.ResponseFactory;
import jserver.http.response.ResponseFactoryImp;

/**
 *
 * @author nathiss
 */
public class ClientImp implements Client {
  public ClientImp() {
    this.requestFactory = new RequestFactoryImp();
    this.lexer = this.requestFactory.makeLexer();
    this.parser = this.requestFactory.makeParser();
    this.request = null;
    this.responseFactory = new ResponseFactoryImp();
    this.response = null;
    this.socket = null;
    this.filesystemFactory = new FilesystemFactoryImp();
    this.filesystem = this.filesystemFactory.makeFilesystem();
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public void proccess() {
    this.readAndResponse();
    this.socket.write(this.response.toString());
  }
  
  /**
   * Reads a request and sends a response.
   */
  private void readAndResponse() {
    String rawRequest = this.socket.readAll();
    String [][] lexedRequest = this.lexer.lex(rawRequest);
    this.request = this.parser.parse(lexedRequest);
    
    if (this.isProtocolVersionHttp_1_0()) {
      this.response = this.responseFactory.make(
        Code.HTTP_VERSION_NOT_SUPPORTED
      );
      return;
    }
    
    // Host field is required in HTTP/1.1
    if (!this.request.hasKey("Host")) {
      this.response = this.responseFactory.make(Code.BAD_REQUEST);
      return;
    }
    
    File file = this.filesystem.getFile(this.request.getUri());
    if (file == null) {
      this.response = this.responseFactory.make(Code.NOT_FOUND);
      return;
    }
    
    if (!file.isReadable()) {
      this.response = this.responseFactory.make(Code.FORBIDDEN);
      return;
    }
    
    this.response = this.responseFactory.make(Code.OK);
    String content = file.read();
    this.response.setContent(content);
    this.response.setMimeType(MimeType.extensionToType(file.getExtension()));
  }
  
  /**
   * Checks if a HTTP protocol version is HTTP/1.0.
   * @return true if a HTTP protocol version is HTTP/1.0, false otherwise
   */
  private boolean isProtocolVersionHttp_1_0() {
    return this.request.getProtocolVersion() == ProtocolVersion.HTTP_1_0;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isRunning() {
    return this.socket.isConnected();
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public void close() {
    if (this.isRunning())
      this.socket.close();
  }
  
  /**
   * Sets a socket.
   * @param socket client-connected socket
   */
  public void setSocket(Socket socket) {
    this.socket = new ClientSocket(socket);
  }
  
  /**
   * An abstract requestFactory for a HTTP request object.
   */
  private final RequestFactory requestFactory;
  
  /**
   * A HTTP request object.
   */
  private Request request;
  
  /**
   * A HTTP request lexer.
   */
  private final Lexer lexer;
  
  /**
   * A HTTP request parser.
   */
  private final Parser parser;
  
  /**
   * An abstract requestFactory for a HTTP response.
   */
  private final ResponseFactory responseFactory;
  
  /**
   * A HTTP response object.
   */
  private Response response;
  
  /**
   * A socket connected to the client.
   */
  private ClientSocket socket;
  
  /**
   * An abstract factory for a filesystem.
   */
  private final FilesystemFactory filesystemFactory;
  
  /**
   * A filesystem object.
   */
  private final Filesystem filesystem;
}
