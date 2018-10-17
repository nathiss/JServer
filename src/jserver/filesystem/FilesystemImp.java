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
 * An class representing a filesystem.
 * @author nathiss
 */
public class FilesystemImp implements Filesystem {
  public FilesystemImp() {
    this(null);
  }
  
  public FilesystemImp(String rootDir) {
    this.rootDir = new Path();
    this.setRootDir(rootDir);
  }
  
  /**
   * Sets a root directory path.
   * @param path a root directory path
   */
  public final void setRootDir(String path) {
    this.rootDir.set(path);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public final File getFile(String filePath) {
    Path uri = new Path(filePath);
    if (uri.equals("/"))
      uri = new Path("index.html");
    Path absolutePath = this.rootDir.join(uri);
    FileImp file = new FileImp(absolutePath);
    if (file.getAbsolutePath().toString().startsWith(this.rootDir.toString()) &&
        file.isRegularFile())
      return file;
    return null;
  }
  
  /**
   * A filesystem root dir.
   */
  private Path rootDir;
}
