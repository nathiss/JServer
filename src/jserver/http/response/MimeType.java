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
 * A enum holding all used MIME types.
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
   * image/x-icon
   */
  image_x_icon,
  
  /**
   * application/javascript
   */
  application_javascript,
  
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
   * @see java.lang.String
   * @see jserver.http.response.MimeType
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
      case image_x_icon:
        return "image/x-icon";
      case application_javascript:
        return "application/javascript";
      case application_json:
        return "application/json";
      case application_binary:
        return "application/binary";
      default:
        return null;
    }
  }
  
  /**
   * Converts a file extension to a MIME type. 
   * @param extension a file extension
   * @return a mapped MIME type
   * @see jserver.http.response.MimeType
   * @see java.lang.String
   */
  public static MimeType extensionToType(String extension) {
    switch(extension) {
      case "txt":
        return text_plain;
      case "html":
      case "htm":
        return text_html;
      case "css":
        return text_css;
      case "gif":
        return image_gif;
      case "jpeg":
      case "jpg":
        return image_jpeg;
      case "png":
        return image_png;
      case "ico":
        return image_x_icon;
      case "js":
        return application_javascript;
      case "json":
        return application_json;
      default:
        // Absolutelly no idea what the MIME type of this really is, but here
        // you are, dear client.
        return application_binary;
    }
  }
}
