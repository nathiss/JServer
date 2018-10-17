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
package jserver.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import jserver.client.Client;
import jserver.client.ClientImp;

/**
 * Holds all information about the server.
 * @author nathiss
 */
public class ServerImp implements Server { 
  public ServerImp(int port) {
    this.port = port;
    this.running = false;
    try {
      this.serverSocket = new ServerSocket(this.port);
    } catch(IOException e) {
      System.err.println(e);
      this.serverSocket = null;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int getPort() {
    return this.port;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void close() {
    this.running = false;
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isRunning() {
    return this.running;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Client accept() {
    if (this.isRunning())
      return null;
    ClientImp client = new ClientImp();
    try {
      Socket socket = this.serverSocket.accept();
      client.setSocket(socket);
    } catch (IOException ex) {
      Logger.getLogger(ServerImp.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return client;
  }
  
  
  /**
   * Server port number.
   */
  private int port;
  
  /**
   * A flag.
   */
  private boolean running;
  
  /**
   * A server socket.
   */
  private ServerSocket serverSocket;
  
}
