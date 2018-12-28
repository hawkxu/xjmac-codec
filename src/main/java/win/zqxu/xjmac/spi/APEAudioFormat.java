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
 * Date: 31.03.2004
 * Time: 19:09:05
 */

/**
 * APE audio format parameters.
 */
public class APEAudioFormat extends AudioFormat {

  /**
   * Constructs an APEAudioFormat with the given parameters. The encoding
   * specifies the convention used to represent the data. The other parameters
   * are further explained in the class description.
   *
   * @param encoding
   *          - the audio encoding technique
   * @param sampleRate
   *          - the number of samples per second
   * @param sampleSizeInBits
   *          - the number of bits in each sample
   * @param channels
   *          - the number of channels (1 for mono, 2 for stereo, and so on)
   * @param frameSize
   *          - the number of bytes in each frame
   * @param frameRate
   *          - the number of frames per second
   * @param bigEndian
   *          - indicates whether the data for a single sample is stored in
   *          big-endian byte order (false means little-endian)
   */
  public APEAudioFormat(Encoding encoding, float sampleRate, int sampleSizeInBits, int channels,
      int frameSize, float frameRate, boolean bigEndian) {
    super(encoding, sampleRate, sampleSizeInBits, channels, frameSize, frameRate, bigEndian);
  }
}
