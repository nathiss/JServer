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
package jserver.filesystem;

import jserver.http.HttpDate;

/**
 * A filesystem.
 * @author nathiss
 */
public interface Filesystem {
  /**
   * Returns true if a file under a given path exists and is a regular file,
   * false otherwise.
   * @param path a path to a file
   * @return true if file under a given path exists and is a regular file, false
   * otherwise
   */
  public boolean isRegularFile(String path);
  
  /**
   * Returns true if a file under a given path exists and is a directory, false
   * otherwise.
   * @param path a path to a file
   * @return true if file under a given path exists and is a directory, false
   * otherwise
   */
  public boolean isDirectory(String path);
  
  /**
   * Returns true if a file under a given path exists, false otherwise.
   * @param path
   * @return 
   */
  public boolean exists(String path);
  
  /**
   * Reads a whole file under a given path and return its content or null if
   * the file can not be read. 
   * @param path a path to a file
   * @return file content
   */
  public String read(String path);
  
  /**
   * Returns a last modification date of a file under a given path.
   * @param path a path to a file
   * @return last modification date
   */
  public HttpDate getModificationDate(String path);
}
