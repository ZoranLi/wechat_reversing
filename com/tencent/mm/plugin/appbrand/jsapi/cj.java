package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public final class cj {
    public static int g(String... strArr) {
        int i = 0;
        for (String str : strArr) {
            if (str != null) {
                i += str.length();
            }
        }
        return i;
    }

    private static String o(File file) {
        IOException e;
        Throwable th;
        if (!file.exists()) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                char[] cArr = new char[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (read != -1) {
                        stringBuffer.append(String.valueOf(cArr, 0, read));
                    } else {
                        try {
                            bufferedReader.close();
                            return stringBuffer.toString();
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    throw e;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (IOException e4) {
            e = e4;
            bufferedReader = null;
            throw e;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e22) {
                    throw e22;
                }
            }
            throw th;
        }
    }

    public static void f(String str, String... strArr) {
        FileWriter fileWriter;
        Throwable th;
        try {
            fileWriter = new FileWriter(new File(ab.getContext().getCacheDir(), str));
            try {
                for (String write : strArr) {
                    fileWriter.write(write);
                }
                try {
                    fileWriter.close();
                } catch (IOException e) {
                }
            } catch (Throwable th2) {
                th = th2;
                if (fileWriter != null) {
                    try {
                        fileWriter.close();
                    } catch (IOException e2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            fileWriter = null;
            if (fileWriter != null) {
                fileWriter.close();
            }
            throw th;
        }
    }

    public static String pn(String str) {
        return o(new File(ab.getContext().getCacheDir(), str));
    }

    public static void po(String str) {
        w.i("MicroMsg.JsApiStorageHelper", "deleteTmpFile: " + str + ":" + new File(ab.getContext().getCacheDir(), str).delete());
    }
}
