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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Wrapper for java.net.ClientSocket.
 * @author nathiss
 */
public class ClientSocket {
  public ClientSocket(Socket socket) {
    this.socket = socket;
    try {
      this.ois = new DataInputStream(this.socket.getInputStream());
      this.oos = new DataOutputStream(this.socket.getOutputStream());
    }
    catch (IOException e) {
      this.ois = null;
      this.oos = null;
      Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, e);
    }
  }
  
  /**
   * Reads all bytes from a input stream and returns them as a string.
   * @return all bytes from a input stream
   */
  public String readAll() {
    try {
      byte [] bytes = new byte[4096];
      this.ois.read(bytes);
      return new String(bytes);
    }
    catch (IOException e) {
      System.err.print(e);
      return null;
    }
  }
  
  /**
   * 
   * @param data a data for a client.
   */
  public void write(String data) {
    try {
      this.oos.write(data.getBytes());
      this.oos.flush();
    } catch (IOException e) {}
  }
  
  /**
   * Returns true if the socket is still connected, false otherwise.
   * @return true if the socket is still connected, false otherwise
   */
  public boolean isConnected() {
    return this.socket.isConnected();
  }
  
  /**
   * Closes the connection to a client.
   */
  public void close() {
    try {
      this.oos.close();
      this.ois.close();
      this.socket.close();
    }
    catch (IOException e) {
      this.oos = null;
      this.ois = null;
      this.socket = null;
    }
  }
  
  /**
   * A socket connected to a client.
   */
  private Socket socket;
  
  /**
   * A input stream for the socket.
   */
  private DataInputStream ois;
  
  /**
   * A output stream for the socket.
   */
  private DataOutputStream oos;
}
