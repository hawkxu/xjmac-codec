/*
 *  21.04.2004 Original verion. davagin@udm.ru.
 *-----------------------------------------------------------------------
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 *----------------------------------------------------------------------
 */

package win.zqxu.xjmac.spi;

import javax.sound.sampled.AudioFormat;

/**
 * Author: Dmitry Vaguine
 * Date: 12.03.2004
 * Time: 13:35:13
 */

/**
 * The encoding of MAC audio.
 */
public class APEEncoding extends AudioFormat.Encoding {
  /**
   * Static instance of APE Encoding.
   */
  public static final AudioFormat.Encoding APE = new APEEncoding("APE");

  /**
   * Constructs a new APEEncoding
   *
   * @param encodingName
   *          - the name of the new type of encoding
   */
  public APEEncoding(String encodingName) {
    super(encodingName);
  }

}
