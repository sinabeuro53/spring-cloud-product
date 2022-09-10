package com.example.springcloudproduct.core.common.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

/**
 * packageName  :   com.example.springcloudproduct.core.common.utils
 * fileName     :   ImageUtils
 * author       :   sinabeuro53
 * date         :   2022-03-21
 * description  :
 */
public class ImageUtils {
    public static byte[] imageToByteArray (String filePath) throws Exception
    {
        byte[] returnValue = null;

        ByteArrayOutputStream baos = null;
        FileInputStream fis = null;

        try
        {
            baos = new ByteArrayOutputStream();
            fis  = new FileInputStream(filePath);

            byte[] buf = new byte[1024];
            int read = 0;

            while ((read=fis.read(buf, 0, buf.length)) != -1)
            {
                baos.write(buf, 0, read);
            }

            returnValue = baos.toByteArray();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (baos != null)
            {
                baos.close();
            }
            if (fis != null)
            {
                fis.close();
            }
        }

        return returnValue;
    }

    public static byte[] imageToByteArray (byte[] byteData) throws Exception
    {
        byte[] returnValue = null;

        ByteArrayOutputStream baos = null;
        FileInputStream fis = null;

        try
        {
            baos = new ByteArrayOutputStream();
            baos.write(byteData);
            returnValue = baos.toByteArray();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (baos != null)
            {
                baos.close();
            }
            if (fis != null)
            {
                fis.close();
            }
        }

        return returnValue;
    }
}
