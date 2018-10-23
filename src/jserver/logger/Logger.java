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
package jserver.logger;

import static java.lang.System.exit;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A log manager for the server.
 * @author nathiss
 */
public class Logger {
  private Logger() {}
  
  /**
   * Logs a given message.
   * @param msg a given message
   * @return this instance
   * @see jserver.logger.Logger
   * @see java.lang.String
   */
  public Logger log(String msg) {
    return this.log(msg, LoggerLevel.INFO);
  }
  
  /**
   * Logs a given message.
   * @param msg a given message
   * @param lvl a message level
   * @return this instance
   * @see jserver.logger.Logger
   * @see java.lang.String
   * @see jserver.logger.LoggerLevel
   */
  public Logger log(String msg, LoggerLevel lvl) {
    switch (lvl) {
      case INFO:
        System.out.println(this.getTime() + ": " + msg);
        break;
      case WARNING:
        System.err.println("[WARNING] " + this.getTime() + " " + msg);
        break;
      case ERROR:
        System.err.println("[ERROR] " + this.getTime() + " " + msg);
        exit(1);
      default:
        break;
    }
    return this;
  }
  
  /**
   * Returns a current time formatted to a {@link java.lang.String}.
   * @return a formatted time
   * @see java.lang.String
   */
  private String getTime() {
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    Date now = new Date();
    return sdf.format(now);
  }
  
  /**
   * Returns this instance (singleton).
   * @return this instance
   * @see jserver.logger.Logger
   * @see 
   * <a href="https://en.wikipedia.org/wiki/Singleton_pattern">Singleton</a>
   */
  public static Logger getInstace() {
    return instance;
  }
  
  /**
   * The only instance of this class.
   * @see jserver.logger.Logger
   */
  private final static Logger instance = new Logger();
}
