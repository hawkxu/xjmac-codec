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

import javax.sound.sampled.AudioFileFormat;

/**
 * Author: Dmitry Vaguine
 * Date: 12.03.2004
 * Time: 13:35:13
 */

/**
 * An instance of the APEAudioFileFormatType class represents one of the
 * standard types of MAC audio file. Static instances are provided for the
 * common types
 */
public class APEAudioFileFormatType extends AudioFileFormat.Type {

  /**
   * Specifies a APE file.
   */
  public static final APEAudioFileFormatType APE = new APEAudioFileFormatType(
      "Monkey's Audio (ape)", "ape");
  /**
   * Specifies a MAC file.
   */
  public static final APEAudioFileFormatType MAC = new APEAudioFileFormatType(
      "Monkey's Audio (mac)", "mac");

  /**
   * Constructs a MAC file type.
   *
   * @param name
   *          - the string that names the file type
   * @param extension
   *          - the string that commonly marks the file type without leading
   *          dot.
   */
  public APEAudioFileFormatType(final String name, final String extension) {
    super(name, extension);
  }

}
