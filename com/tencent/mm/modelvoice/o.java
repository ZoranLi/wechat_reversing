package com.tencent.mm.modelvoice;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class o {
    public static int lS(String str) {
        if (bg.mA(str)) {
            return -1;
        }
        w.d("MicroMsg.VoiceFile", "fileName " + str);
        if (f(str, 0, false)) {
            return 0;
        }
        if (g(str, 0, false)) {
            return 2;
        }
        return 1;
    }

    public static int e(String str, int i, boolean z) {
        if (bg.mA(str)) {
            return -1;
        }
        w.d("MicroMsg.VoiceFile", "fileName " + str);
        if (f(str, i, z)) {
            return 0;
        }
        if (g(str, i, z)) {
            return 2;
        }
        return 1;
    }

    private static boolean f(String str, int i, boolean z) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        Throwable th;
        if (!z) {
            if (i == 0) {
                str = q.js(str);
            } else {
                str = null;
            }
        }
        w.d("MicroMsg.VoiceFile", "path " + str);
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            try {
                byte[] bArr = new byte[6];
                if (randomAccessFile.read(bArr, 0, 6) == -1) {
                    w.e("MicroMsg.VoiceFile", "read amr file header failed!");
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e2) {
                        w.e("MicroMsg.VoiceFile", "exception:%s", bg.g(e2));
                    }
                    return false;
                }
                w.i("MicroMsg.VoiceFile", "isAmrHeader voice file headHex:|%s| headStr:|%s| AmrFileOperator.AMR_NB_HEAD:|%s|", bg.bl(bArr), new String(bArr), "#!AMR\n");
                if (new String(bArr).endsWith("#!AMR\n")) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e22) {
                        w.e("MicroMsg.VoiceFile", "exception:%s", bg.g(e22));
                    }
                    return true;
                }
                try {
                    randomAccessFile.close();
                } catch (Throwable e222) {
                    w.e("MicroMsg.VoiceFile", "exception:%s", bg.g(e222));
                }
                return false;
            } catch (Exception e3) {
                e222 = e3;
                try {
                    w.printErrStackTrace("MicroMsg.VoiceFile", e222, "", new Object[0]);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable e2222) {
                            w.e("MicroMsg.VoiceFile", "exception:%s", bg.g(e2222));
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    e2222 = th2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable e4) {
                            w.e("MicroMsg.VoiceFile", "exception:%s", bg.g(e4));
                        }
                    }
                    throw e2222;
                }
            }
        } catch (Throwable e42) {
            th = e42;
            randomAccessFile = null;
            e2222 = th;
            w.printErrStackTrace("MicroMsg.VoiceFile", e2222, "", new Object[0]);
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            return false;
        } catch (Throwable e422) {
            th = e422;
            randomAccessFile = null;
            e2222 = th;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw e2222;
        }
    }

    public static boolean g(String str, int i, boolean z) {
        RandomAccessFile randomAccessFile;
        Throwable e;
        Throwable th;
        RandomAccessFile randomAccessFile2 = null;
        if (!z) {
            if (i == 0) {
                str = q.js(str);
            } else if (i == 1) {
                w.e("MicroMsg.VoiceFile", "isSilkHeader usertype error, TYPE_RECOGNIZER_BIZ fileName:%s", str);
                return false;
            } else {
                str = null;
            }
        }
        w.d("MicroMsg.VoiceFile", "isSilkHeader path " + str);
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            try {
                byte[] bArr = new byte[9];
                randomAccessFile.seek(1);
                if (randomAccessFile.read(bArr, 0, 9) == -1) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e2) {
                        w.e("MicroMsg.VoiceFile", "exception:%s", bg.g(e2));
                    }
                    return false;
                }
                w.i("MicroMsg.VoiceFile", "isSilkHeader voice file headHex:|%s| headStr:|%s| AmrFileOperator.AMR_NB_HEAD:|%s|", bg.bl(bArr), new String(bArr), "#!SILK_V3");
                if (new String(bArr).endsWith("#!SILK_V3")) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e22) {
                        w.e("MicroMsg.VoiceFile", "exception:%s", bg.g(e22));
                    }
                    return true;
                }
                try {
                    randomAccessFile.close();
                } catch (Throwable e222) {
                    w.e("MicroMsg.VoiceFile", "exception:%s", bg.g(e222));
                }
                return false;
            } catch (Exception e3) {
                randomAccessFile2 = randomAccessFile;
                try {
                    w.d("MicroMsg.VoiceFile", "isSilkHeader file not found");
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (Throwable e2222) {
                            w.e("MicroMsg.VoiceFile", "exception:%s", bg.g(e2222));
                        }
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = randomAccessFile2;
                    e2222 = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Throwable th22) {
                            w.e("MicroMsg.VoiceFile", "exception:%s", bg.g(th22));
                        }
                    }
                    throw e2222;
                }
            } catch (Throwable th3) {
                e2222 = th3;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw e2222;
            }
        } catch (Exception e4) {
            w.d("MicroMsg.VoiceFile", "isSilkHeader file not found");
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            return false;
        } catch (Throwable th222) {
            th = th222;
            randomAccessFile = null;
            e2222 = th;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw e2222;
        }
    }

    public static int lx(String str) {
        boolean z = true;
        String js;
        File file;
        int length;
        switch (lS(str)) {
            case 0:
                return lT(q.js(str));
            case 1:
                js = q.js(str);
                if (js.length() < 0) {
                    z = false;
                }
                Assert.assertTrue(z);
                file = new File(js);
                if (!file.exists()) {
                    return 0;
                }
                length = (int) file.length();
                if (length > 0) {
                    return length;
                }
                return 0;
            case 2:
                js = q.js(str);
                if (js.length() < 0) {
                    z = false;
                }
                Assert.assertTrue(z);
                file = new File(js);
                if (!file.exists()) {
                    return 0;
                }
                length = (int) file.length();
                return length > 0 ? length : 0;
            default:
                return lT(q.js(str));
        }
    }

    private static int lT(String str) {
        Assert.assertTrue(str.length() >= 0);
        File file = new File(str);
        if (!file.exists()) {
            return 0;
        }
        int length = ((int) file.length()) - 6;
        if (length > 0) {
            return length;
        }
        return 0;
    }
}
