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

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import jserver.http.HttpDate;

/**
 * A filesystem.
 * @author nathiss
 */
public class Filesystem {
  private Filesystem() {
    this.rootDir = null;
  }
  
  /**
   * Returns true if a file under a given path exists and is a regular file,
   * false otherwise.
   * @param path a path to a file
   * @return true if file under a given path exists and is a regular file, false
   * otherwise
   */
  public boolean isRegularFile(String path) {
    return new File(this.join(path)).isFile();
  }

  /**
   * Returns true if a file under a given path exists and is a directory, false
   * otherwise.
   * @param path a path to a file
   * @return true if file under a given path exists and is a directory, false
   * otherwise
   */
  public boolean isDirectory(String path) {
    return new File(this.join(path)).isDirectory();
  }
  
  /**
   * Returns true if a file under a given path exists, false otherwise.
   * @param path a path to a file
   * @return true if a file under a given path exists, false otherwise
   */
  public boolean exists(String path) {
    return new File(this.join(path)).exists();
  }

  /**
   * Reads a whole file under a given path and return its content or null if
   * the file can not be read. 
   * @param path a path to a file
   * @return a file content
   */
  public String read(String path) {
    try {
      byte [] encoded = Files.readAllBytes(Paths.get(this.join(path)));
      return new String(encoded, Charset.defaultCharset());
    }
    catch (IOException e) {
      return null;
    }
  }

  /**
   * Returns a last modification date of a file under a given path.
   * @param path a path to a file
   * @return a last modification date
   */
  public HttpDate getModificationDate(String path) {
    long rawDate = new File(this.join(path)).lastModified();
    return new HttpDate(new Date(rawDate));
  }
  
  /**
   * Returns a static instance of this class.
   * @return a static instance
   */
  public static Filesystem getInstance() {
    return instance;
  }
  
  /**
   * Sets a root directory for a filesystem.
   * @param path a root directory path
   */
  public void setRootDir(String path) {
    if (path.length() > 1 && path.charAt(path.length() - 1) == '/')
      path = path.substring(0, path.length() - 1);
    this.rootDir = path;
  }
  
  /**
   * Returns a root directory path.
   * @return a root directory path
   */
  public String getRootDir() {
    return this.rootDir;
  }
  
  /**
   * Concatenates two paths, path1 is a root.
   * @param path1 a first path
   * @param path2 a second path
   * @return a concatenated path
   */
  private String join(String path) {
    if (this.rootDir == null)
      return path;
    if (path.charAt(0) == '/')
      path = path.substring(1);
    return this.rootDir + path;
  }
 
  /**
   * Singleton.
   */
  private static final Filesystem instance = new Filesystem();
  
  private String rootDir;
}
