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

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import win.zqxu.xjmac.decoder.IAPEDecompress;
import win.zqxu.xjmac.info.APETag;
import win.zqxu.xjmac.tools.Globals;

/**
 * Author: Dmitry Vaguine
 * Date: 13.05.2004
 * Time: 11:48:13
 */

/**
 * APE properties helper.
 */
public class APEPropertiesHelper {

  /**
   * Reads the properties from APE file and creates two Map's (for audio file
   * format and for audio format).
   *
   * @param decoder
   *          - decoder from which this method should get the properties.
   * @param fileProperties
   *          - properties Map for audio file format properties
   * @param formatProperties
   *          - properties Map for audio format properties
   * @throws IOException
   *           - in case of IO error occured
   */
  public static void readProperties(IAPEDecompress decoder, Map<String, Object> fileProperties,
      Map<String, Object> formatProperties) throws IOException {
    formatProperties.put("bitrate", new Integer(decoder.getApeInfoDecompressAverageBitrate()));
    formatProperties.put("vbr", new Boolean(true));
    formatProperties.put("quality", new Integer(10));

    formatProperties.put("ape.version", new Integer(decoder.getApeInfoFileVersion()));
    formatProperties.put("ape.compressionlevel", new Integer(decoder.getApeInfoCompressionLevel()));
    formatProperties.put("ape.formatflags", new Integer(decoder.getApeInfoFormatFlags()));
    formatProperties.put("ape.totalframes", new Integer(decoder.getApeInfoTotalFrames()));
    formatProperties.put("ape.blocksperframe", new Integer(decoder.getApeInfoBlocksPerFrame()));
    formatProperties.put("ape.finalframeblocks", new Integer(decoder.getApeInfoFinalFrameBlocks()));
    formatProperties.put("ape.blockalign", new Integer(decoder.getApeInfoBlockAlign()));
    formatProperties.put("ape.totalblocks", new Integer(decoder.getApeInfoTotalBlocks()));
    formatProperties.put("ape.peaklevel", new Integer(decoder.getApeInfoPeakLevel()));

    fileProperties.put("duration", new Long(decoder.getApeInfoLengthMs()));
    if (decoder.getApeInfoIoSource().isLocal()) {
      APETag tag = decoder.getApeInfoTag();
      fileProperties.put("author", tag.GetFieldString(APETag.APE_TAG_FIELD_ARTIST));
      fileProperties.put("title", tag.GetFieldString(APETag.APE_TAG_FIELD_TITLE));
      fileProperties.put("copyright", tag.GetFieldString(APETag.APE_TAG_FIELD_COPYRIGHT));
      String year = tag.GetFieldString(APETag.APE_TAG_FIELD_YEAR);
      Date date = null;
      try {
        Calendar c = Calendar.getInstance();
        c.clear();
        c.set(Calendar.YEAR, Integer.parseInt(year));
        date = c.getTime();
      } catch (Exception e) {
      }
      fileProperties.put("date", date);
      fileProperties.put("comment", tag.GetFieldString(APETag.APE_TAG_FIELD_COMMENT));

      fileProperties.put("album", tag.GetFieldString(APETag.APE_TAG_FIELD_ALBUM));
      fileProperties.put("track", tag.GetFieldString(APETag.APE_TAG_FIELD_TRACK));
      fileProperties.put("genre", tag.GetFieldString(APETag.APE_TAG_FIELD_GENRE));
    }
    if (Globals.DEBUG) {
      System.out.println("File Properties");
      System.out.println("duration: " + fileProperties.get("duration"));
      System.out.println("author: " + fileProperties.get("author"));
      System.out.println("title: " + fileProperties.get("title"));
      System.out.println("copyright: " + fileProperties.get("copyright"));
      System.out.println("date: " + fileProperties.get("date"));
      System.out.println("comment: " + fileProperties.get("comment"));
      System.out.println("album: " + fileProperties.get("album"));
      System.out.println("track: " + fileProperties.get("track"));
      System.out.println("genre: " + fileProperties.get("genre"));

      System.out.println("Format Properties");
      System.out.println("bitrate: " + formatProperties.get("bitrate"));
      System.out.println("vbr: " + formatProperties.get("vbr"));
      System.out.println("quality: " + formatProperties.get("quality"));

      System.out.println("ape.version: " + formatProperties.get("ape.version"));
      System.out.println("ape.compressionlevel: " + formatProperties.get("ape.compressionlevel"));
      System.out.println("ape.formatflags: " + formatProperties.get("ape.formatflags"));
      System.out.println("ape.totalframes: " + formatProperties.get("ape.totalframes"));
      System.out.println("ape.blocksperframe: " + formatProperties.get("ape.blocksperframe"));
      System.out.println("ape.finalframeblocks: " + formatProperties.get("ape.finalframeblocks"));
      System.out.println("ape.blockalign: " + formatProperties.get("ape.blockalign"));
      System.out.println("ape.totalblocks: " + formatProperties.get("ape.totalblocks"));
      System.out.println("ape.peaklevel: " + formatProperties.get("ape.peaklevel"));
    }
  }

}
