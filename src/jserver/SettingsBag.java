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
package jserver;

import java.util.HashMap;

/**
 *
 */
public class SettingsBag {
  /**
   * Initializes this object.
   */
  private SettingsBag() {
    this.map = new HashMap<>();
  }
  
  /**
   * Stored a given value under a given key.
   * @param key a given key
   * @param value a given value
   * @return this instance
   * @see java.lang.String
   * @see jserver.SettingsBag
   */
  public SettingsBag set(String key, String value) {
    this.map.put(key, value);
    return this;
  }
  
  /**
   * Returns a stored value under a given key.
   * @param key a given key
   * @return a stored value
   * @see java.lang.String
   */
  public String get(String key) {
    return this.map.get(key);
  }
  
  /**
   * Returns this instance.
   * @return this instance
   * @see jserver.SettingsBag
   * @see
   * <a href="https://en.wikipedia.org/wiki/Singleton_pattern">Singleton</a>
   */
  public static SettingsBag getInstance() {
    return instance;
  }
  
  /**
   * An associative array.
   * @see java.util.HashMap
   * @see java.lang.String
   */
  private final HashMap<String, String> map;
  
  /**
   * The only instance of this class.
   * @see jserver.SettingsBag
   */
  private final static SettingsBag instance = new SettingsBag();
}
