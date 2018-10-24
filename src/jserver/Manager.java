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
package jserver;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import jserver.client.Client;
import jserver.logger.Logger;
import jserver.server.Server;
import jserver.server.ServerImp;

/**
 * A connection manager.
 * @author nathiss
 */
public class Manager {
  /**
   * Initializes the server.
   * @param port a server port
   * @param root a root directory path
   */
  public Manager(int port, String root) {
    SettingsBag.getInstance()
      .set("port", Integer.toString(port))
      .set("root", root)
      .set("isRunning", "1");
    
    this.clients = new CopyOnWriteArrayList<>();
    this.server = new ServerImp(port);
  }
  
  /**
   * Prints a usage info.
   * @param name a name of the program
   * @see java.lang.String
   */
  private void printUsage(String name) {
    System.out.println("Usage: " + name + " port www_root");
  }
  
  /**
   * Starts the server.
   * @see jserver.server.Server
   */
  public void run() {
    SettingsBag bag = SettingsBag.getInstance();
    while(bag.get("isRunning").equals("1")) {
      Client client = this.server.accept();
      Runnable runnable =
        () -> client.proccess();
      int id = client.hashCode();
      Logger.getInstace().log("New Client (id: " + id + "). Starting Thread.");
      Thread thread = new Thread(runnable, Integer.toString(id));
      thread.start();
      this.clients.add(thread);
      
      this.checkThreads();
    }
  }
  
  /**
   * Checks if any of created threads is not running anymore, then removes it.
   */
  private void checkThreads() {
      Iterator<Thread> it = this.clients.iterator();
      while (it.hasNext()) {
        Thread th = it.next();
        if (!th.isAlive()) {
          Logger.getInstace().log("Connection to client (id: " + th.getName() +
            ") ended. Removing thread."
          );
          clients.remove(th);
        }
      }
      
  }

  /**
   * A list of threads.
   * @see java.util.List
   * @see java.lang.Thread
   */
  private final List<Thread> clients;
  
  /**
   * A server object.
   * @see jserver.server.Server
   */
  private final Server server;
}
