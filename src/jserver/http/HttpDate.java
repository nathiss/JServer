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
package jserver.http;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Converts a {@link Date} to a {@link String} representation of the date.
 * @author nathiss
 */
public class HttpDate {
  /**
   * Converts current time to a {@link String}.
   */
  public HttpDate() {
    this(Calendar.getInstance().getTime());
  }
  
  /**
   * Converts a {@link Date} to a {@link String}.
   * @param date 
   */
  public HttpDate(Date date) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(
      "EEE, dd MMM yyyy HH:mm:ss z", Locale.US
    );
    dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    this.date = dateFormat.format(date);
  }
  
  /**
   * Returns converted {@link Date}.
   * @return string representation of this object
   */
  @Override
  public String toString() {
    return this.date;
  }
  
  /**
   * Converted date.
   */
  private String date;
}