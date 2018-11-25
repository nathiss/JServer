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
 * The File Interface representing a file on a filesystem.
 */
public interface File {
  /**
   * Reads a whole file and returns its content.
   * @return a file content
   * @see java.lang.String
   */
  public String read();
  
  /**
   * Returns a file modification date.
   * @return a file modification date
   * @see jserver.http.HttpDate
   */
  public HttpDate getModificationDate();
  
  /**
   * Returns an absolute path of this file.
   * @return an absolute path represented as {@link jserver.filesystem.Path}
   * @see jserver.filesystem.Path
   */
  public Path getAbsolutePath();
  
  /**
   * Returns a file name (with an extension)
   * @return a file name
   * @see java.lang.String
   */
  public String getName();
  
  /**
   * Returns a file extension if any or null otherwise.
   * @return a file extension if any or null otherwise
   * @see java.lang.String
   */
  public String getExtension();
  
  /**
   * Returns true if this file is a readable, false otherwise.
   * @return true if this file is a readable, false otherwise
   */
  public boolean isReadable();
}
