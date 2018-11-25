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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import jserver.http.HttpDate;

/**
 * A class representing a file on a filesystem.
 */
public class FileImp implements File {
  public FileImp(Path path) {
    this.file = new java.io.File(path.toString());
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public String read() {
    try {
    Scanner scanner = new Scanner(this.file);
    String ret = new String();
    while(scanner.hasNextLine())
      ret += scanner.nextLine();
    return ret;
    }
    catch (FileNotFoundException e) {
      System.err.println(e);
      return null;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public HttpDate getModificationDate() {
    long rawDate = this.file.lastModified();
    return new HttpDate(new Date(rawDate));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Path getAbsolutePath() {
    try {
    return new Path(this.file.getCanonicalPath());
    }
    catch (IOException e) {
      System.err.println(e);
      return null;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getName() {
    return this.file.getName();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getExtension() {
    String name = this.getName();
    int idx = name.indexOf('.', 1);
    if (idx == -1)
      return null;
    String extension = name.substring(idx + 1);
    if (extension.length() == 0)
      return null;
    return extension;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isReadable() {
    return this.file.canRead();
  }
  
  /**
   * Returns true if this file is a regular file.
   * @return true if this file is a regular file
   */
  public boolean isRegularFile() {
    return this.file.isFile();
  }
  
  /**
   * An object representing a file on a filesystem.
   * @see java.io.File
   */
  private final java.io.File file;
}
