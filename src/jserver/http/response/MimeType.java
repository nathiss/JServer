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
package jserver.http.response;

/**
 *
 * @author nathiss
 */
public enum MimeType {
  /**
   * text/plain
   */
  text_plain,
  
  /**
   * text/html
   */
  text_html,
  
  /**
   * text/css
   */
  text_css,
  
  /**
   * image/gif
   */
  image_gif,
  
  /**
   * image/jpeg
   */
  image_jpeg,
  
  /**
   * image/png
   */
  image_png,
  
  /**
   * application/json
   */
  application_json,
  
  /**
   * application/binary
   */
  application_binary;
  
  /**
   * Return textual phrase for all the types above or null if not supported.
   * @param type MIME type
   * @return textual phrase or null if not implemented
   */
  public static String getMimeTypeText(MimeType type) {
    switch(type) {
      case text_plain:
        return "text/plain";
      case text_html:
        return "text/html";
      case text_css:
        return "text/css";
      case image_gif:
        return "image/gif";
      case image_jpeg:
        return "image/jpeg";
      case image_png:
        return "image/png";
      case application_json:
        return "application/json";
      case application_binary:
        return "application/binary";
      default:
        return null;
    }
  };
}