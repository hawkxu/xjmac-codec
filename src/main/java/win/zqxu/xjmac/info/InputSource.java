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
package win.zqxu.xjmac.info;

import java.io.IOException;

import win.zqxu.xjmac.tools.ByteBuffer;
import win.zqxu.xjmac.tools.File;
import win.zqxu.xjmac.tools.IntegerPointer;
import win.zqxu.xjmac.tools.JMACException;

/**
 * Author: Dmitry Vaguine Date: 07.05.2004 Time: 14:07:31
 */
public abstract class InputSource {
  // construction / destruction
  public InputSource(File pIO, WaveFormat pwfeSource, IntegerPointer pTotalBlocks,
      IntegerPointer pHeaderBytes, IntegerPointer pTerminatingBytes) throws IOException {
  }

  public InputSource(String pSourceName, WaveFormat pwfeSource, IntegerPointer pTotalBlocks,
      IntegerPointer pHeaderBytes, IntegerPointer pTerminatingBytes) throws IOException {
  }

  // get data
  public abstract int GetData(ByteBuffer pBuffer, int nBlocks) throws IOException;

  // get header / terminating data
  public abstract void GetHeaderData(byte[] pBuffer) throws IOException;

  public abstract void GetTerminatingData(byte[] pBuffer) throws IOException;

  public abstract void Close() throws IOException;

  public static InputSource CreateInputSource(String pSourceName, WaveFormat pwfeSource,
      IntegerPointer pTotalBlocks, IntegerPointer pHeaderBytes, IntegerPointer pTerminatingBytes)
      throws IOException {
    // error check the parameters
    if ((pSourceName == null) || (pSourceName.length() == 0))
      throw new JMACException("Bad Parameters");

    // get the extension
    int index = pSourceName.lastIndexOf('.');
    String pExtension = "";
    if (index >= 0)
      pExtension = pSourceName.substring(pSourceName.lastIndexOf('.'));

    // create the proper input source
    if (pExtension.toLowerCase().equals(".wav")) {
      return new WAVInputSource(pSourceName, pwfeSource, pTotalBlocks, pHeaderBytes,
          pTerminatingBytes);
    } else
      throw new JMACException("Invalid Input File");
  }
}
