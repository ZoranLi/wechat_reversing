package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger {
    private static final String TAG = "FileLogger";

    public static void write(StringBuilder stringBuilder, File file, boolean z) {
        FileWriter fileWriter;
        Throwable e;
        try {
            fileWriter = new FileWriter(file, z);
            try {
                fileWriter.write(stringBuilder.toString());
                fileWriter.flush();
                try {
                    fileWriter.close();
                } catch (IOException e2) {
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    Logger.e(TAG, "[write] failed!", e);
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable th) {
                    e = th;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (IOException e6) {
            e = e6;
            fileWriter = null;
            Logger.e(TAG, "[write] failed!", e);
            if (fileWriter != null) {
                fileWriter.close();
            }
        } catch (Throwable th2) {
            e = th2;
            fileWriter = null;
            if (fileWriter != null) {
                fileWriter.close();
            }
            throw e;
        }
    }
}
