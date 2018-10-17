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
public class FilesystemImp implements Filesystem {

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isRegularFile(String path) {
    return new File(path).isFile();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean isDirectory(String path) {
    return new File(path).isDirectory();
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public boolean exists(String path) {
    return new File(path).exists();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String read(String path) {
    try {
      byte [] encoded = Files.readAllBytes(Paths.get(path));
      return new String(encoded, Charset.defaultCharset());
    }
    catch (IOException e) {
      return null;
    }
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public HttpDate getModificationDate(String path) {
    long rawDate = new File(path).lastModified();
    return new HttpDate(new Date(rawDate));
  }
  
}
