package com.tencent.mm.sdk.platformtools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public class MMNativeJpeg {
    public static final int FAKE_PARTIAL_PROGRESSIVE_QUALITY = 25;
    public static final String TAG = "MMJPEG.JAVA";

    private static String exception2String(Throwable th) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void Destroy() {
    }

    private static boolean checkAndroidVersion() {
        if (VERSION.SDK_INT >= 11) {
            return true;
        }
        w.i(TAG, "early version before android 3.0  unsupported.");
        return false;
    }

    private static boolean checkFileExist(String str) {
        boolean z = false;
        try {
            z = new File(str).exists();
        } catch (Throwable e) {
            w.e(TAG, "checkfileexist. exception:%s", exception2String(e));
        }
        return z;
    }

    public static int queryQuality(String str) {
        if (!checkAndroidVersion() || !checkFileExist(str)) {
            return 0;
        }
        try {
            int queryQuality = mmjpeg.queryQuality(str);
            w.i(TAG, "after query quality:%d", Integer.valueOf(queryQuality));
            if (queryQuality < 10000 && queryQuality >= 24) {
                return queryQuality;
            }
            if (1 == mmjpeg.isProgressiveFile(str)) {
                return 25;
            }
            w.w(TAG, "invalid jpeg file or too small quality.");
            return 0;
        } catch (Throwable e) {
            w.e(TAG, "queryQuality failed. exception:%s", exception2String(e));
            return 0;
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.Crash", e2, "May cause dvmFindCatchBlock crash!", new Object[0]);
            throw ((IncompatibleClassChangeError) new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(e2));
        } catch (Error e3) {
            w.e(TAG, "queryQuality error. java.lang.UnsatisfiedLinkError: queryQuality, %s", e3.toString());
            return 0;
        }
    }

    public static boolean isProgressive(String str) {
        w.v(TAG, "isProgressive:%s", str);
        if (!checkAndroidVersion() || !checkFileExist(str)) {
            return false;
        }
        w.d(TAG, "check progressive for file:%s", str);
        try {
            int isProgressiveFile = mmjpeg.isProgressiveFile(str);
            if (1 == isProgressiveFile || isProgressiveFile == 0) {
                w.i(TAG, "file:%s progressive:%d", str, Integer.valueOf(isProgressiveFile));
                if (isProgressiveFile == 1) {
                    return true;
                }
                return false;
            }
            w.e(TAG, "check failed. error:%d", Integer.valueOf(isProgressiveFile));
            return false;
        } catch (Throwable e) {
            w.e(TAG, "isProgressive exception:%s", exception2String(e));
            return false;
        }
    }

    public static boolean convertToProgressive(String str, int i) {
        if (!checkAndroidVersion()) {
            return false;
        }
        try {
            String str2 = str + ".prog.dat";
            w.d(TAG, "convert %s to %s use progressive.quality:%d", str, str2, Integer.valueOf(i));
            if (mmjpeg.convertToProgressive(str, str2) != 0) {
                w.e(TAG, "convert failed. error:%d", Integer.valueOf(mmjpeg.convertToProgressive(str, str2)));
                return false;
            }
            w.i(TAG, "convert ret:%b", Boolean.valueOf(j.p(str2, str, true)));
            return j.p(str2, str, true);
        } catch (Throwable e) {
            w.e(TAG, "convertToProgressive exception:%s", exception2String(e));
            return false;
        }
    }

    public static Bitmap decodeAsBitmap(String str) {
        w.v(TAG, "decodeAsBitmap:%s", str);
        try {
            JpegParams queryParams = mmjpeg.queryParams(str);
            if (queryParams == null) {
                w.e(TAG, "can't query jpeg parames.");
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(queryParams.Width, queryParams.Height, Config.ARGB_8888);
            if (mmjpeg.decodeToBitmap(str, createBitmap)) {
                w.i(TAG, "decode bitmap successed.");
                return createBitmap;
            }
            w.e(TAG, "can't decode to bmp.");
            return null;
        } catch (Throwable e) {
            w.e(TAG, "decodeAsBitmap exception:%s", exception2String(e));
            return null;
        } catch (OutOfMemoryError e2) {
            w.e(TAG, "decodeAsBitmap OOM:%s", str);
            return null;
        }
    }

    public static boolean Convert2Baseline(String str, int i) {
        Throwable e;
        if (isProgressive(str)) {
            FileOutputStream fileOutputStream = null;
            try {
                FileOutputStream fileOutputStream2;
                Bitmap decodeFile = BitmapFactory.decodeFile(str);
                if (decodeFile == null) {
                    w.i(TAG, "c2b:use mmjpeg to decode.");
                    decodeFile = decodeAsBitmap(str);
                }
                if (decodeFile != null) {
                    String str2 = str + ".base";
                    CompressFormat compressFormat = CompressFormat.JPEG;
                    fileOutputStream2 = new FileOutputStream(str2);
                    try {
                        if (decodeFile.compress(compressFormat, i, fileOutputStream2)) {
                            w.i(TAG, "c2b: convert baseline %s ok.", str2);
                            boolean p = j.p(str2, str, true);
                            try {
                                fileOutputStream2.close();
                                return p;
                            } catch (Exception e2) {
                                return p;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        fileOutputStream = fileOutputStream2;
                        try {
                            w.e(TAG, "c2b:exception:%s", exception2String(e));
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e4) {
                                }
                            }
                            return false;
                        } catch (Throwable th) {
                            e = th;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Exception e5) {
                                }
                            }
                            throw e;
                        }
                    } catch (OutOfMemoryError e6) {
                        fileOutputStream = fileOutputStream2;
                        w.e(TAG, "c2b: oom");
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e7) {
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        e = th2;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw e;
                    }
                }
                fileOutputStream2 = null;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (Exception e8) {
                    }
                }
            } catch (Exception e9) {
                e = e9;
                w.e(TAG, "c2b:exception:%s", exception2String(e));
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return false;
            } catch (OutOfMemoryError e10) {
                w.e(TAG, "c2b: oom");
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return false;
            }
            return false;
        }
        w.e(TAG, "c2b: not progressive file.%s", str);
        return true;
    }

    public static boolean IsJpegFile(String str) {
        try {
            if (mmjpeg.queryParams(str) != null) {
                return true;
            }
            w.e(TAG, "IsJpegFile : can't query jpeg parames.");
            return false;
        } catch (Throwable e) {
            w.e(TAG, "IsJpegFile exception:%s", exception2String(e));
            return false;
        }
    }
}
