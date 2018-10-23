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

/**
 * A Class representing a filesystem path.
 * @author nathiss
 */
public class Path {
  /**
   * Sets a stored path to null.
   */
  public Path() {
    this.path = null;
  }
  
  /**
   * Stores a given path.
   * @param path a given path
   * @see java.lang.String
   */
  public Path(String path) {
    this.set(path);
  }
  
  /**
   * Sets a stored path.
   * @param path a path to be stored
   * @see java.lang.String
   */
  public final void set(String path) {
    this.path = this.format(path);
  }
  
  /**
   * Returns a stored path.
   * @return a stored path
   * @see java.lang.String
   */
  @Override
  public final String toString() {
    return this.path;
  }
  
  /**
   * Splits a stored path into an array of directory/file names.
   * @return a splitted path
   * @see java.lang.String
   */
  public String [] split() {
    if (this.path.equals("/"))
      return new String[]{"/"};
    return this.path.split("/");
  }
  
  /**
   * Compares this path and a given one.
   * @param path a path to compare
   * @return true if paths are equal, false otherwise
   * @see jserver.filesystem.Path
   */
  public boolean equals(Path path) {
    return this.path.equals(path.path);
  }
  
  /**
   * Compares this path and a given one.
   * @param path a path to compare
   * @return true if paths are equal, false otherwise
   * @see java.lang.Path
   */
  public boolean equals(String path) {
    return this.path.equals(path);
  }
  
  /**
   * Returns a length of a stored path.
   * @return a length of a stored path
   */
  public int length() {
    return this.path.length();
  }
  
  /**
   * If a slash is the last character of a given path removes it and return that
   * path, if null is given return null.
   * @param path a path to format
   * @return formatted path or null if null is given
   * @see java.lang.String
   */
  private String format(String path) {
    if (path == null)
      return null;
    if (path.length() == 1)
      return path;
    if (path.charAt(path.length() - 1) == '/')
      return path.substring(0, path.length() - 1);
    return path.replaceAll("/+", "/");
  }
  
  /**
   * Joins two paths and return a concatenated path.
   * @param path a second path to concatenate
   * @return a concatenated path
   * @see jserver.filesystem.Path
   */
  public Path join(Path path) {
    if (path == null || path.equals("/"))
      return this;
    if (path.path.charAt(0) != '/')
      path.path = "/" + path.path;
    Path ret = new Path();
    ret.set(this.path + path.path);
    return ret;
  }
  
  /**
   * A stored path.
   * @see java.lang.String
   */
  private String path;
}
