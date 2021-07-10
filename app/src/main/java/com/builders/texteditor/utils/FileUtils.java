package com.builders.texteditor.utils;

import android.content.Context;

import com.builders.texteditor.AppController;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileUtils {

    private static Context context = AppController.context;

    public static String getFileValue(String fileName) {
        try {
            StringBuffer outStringBuf = new StringBuffer();
            String inputLine = "";
            FileInputStream fIn = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fIn);
            BufferedReader inBuff = new BufferedReader(isr);
            while ((inputLine = inBuff.readLine()) != null) {
                outStringBuf.append(inputLine);
                outStringBuf.append("\n");
            }
            inBuff.close();
            return outStringBuf.toString();
        } catch (IOException e) {
            return null;
        }
    }

    public static boolean appendFileValue(String fileName, String value) {
        return writeToFile(fileName, value, Context.MODE_APPEND);
    }

    public static boolean setFileValue(String fileName, String value) {
        return writeToFile(fileName, value,
                Context.MODE_APPEND);
    }

    public static boolean writeToFile(String fileName, String value, int writeOrAppendMode) {
        if (writeOrAppendMode != Context.MODE_WORLD_READABLE
                && writeOrAppendMode != Context.MODE_WORLD_WRITEABLE
                && writeOrAppendMode != Context.MODE_APPEND) {
            return false;
        }
        try {
            FileOutputStream fOut = new FileOutputStream(fileName);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            osw.write(value);
            osw.flush();
            osw.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public static void deleteFile(String fileName) {
        context.deleteFile(fileName);
    }
}
