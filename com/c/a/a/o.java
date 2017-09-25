package com.c.a.a;

import android.os.Environment;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

final class o {
    private static String aLX;
    private static final SimpleDateFormat aLY = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss", Locale.US);
    private static final SimpleDateFormat aLZ = new SimpleDateFormat("yyyMMddHHmmss", Locale.US);

    protected static boolean m(String str, String str2) {
        String str3 = null;
        if (aLX == null) {
            boolean z;
            if (Environment.getExternalStorageState().equals("mounted")) {
                File file = new File(Environment.getExternalStorageDirectory() + "/" + y.aPr);
                boolean exists = file.exists();
                if (!exists) {
                    exists = file.mkdir();
                }
                if (exists) {
                    str3 = file.toString();
                }
                aLX = str3;
                z = exists;
            } else {
                aLX = null;
                z = false;
            }
            if (!z) {
                return false;
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(aLX + "/" + str + ".txt", true);
            fileWriter.write("\n" + aLY.format(new Date()) + ',' + str2);
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected static String no() {
        return aLZ.format(new Date());
    }
}
