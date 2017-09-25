package com.tencent.mm.plugin.fingerprint.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.soter.c.g;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class e {
    private static boolean lOf = false;

    public static String getUserId() {
        return aa.Pq(aa.Pq(com.tencent.mm.wallet_core.ui.e.getUsername()) + aa.Pq(p.rB()));
    }

    public static String avl() {
        return g.blX();
    }

    public static void avm() {
        ap.yY();
        c.vr().a(a.uAY, Boolean.valueOf(true));
    }

    public static boolean avn() {
        ap.yY();
        Object obj = c.vr().get(a.uAY, Boolean.valueOf(false));
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static void avo() {
        ap.yY();
        c.vr().a(a.uAZ, Boolean.valueOf(true));
    }

    public static void el(boolean z) {
        ap.yY();
        c.vr().a(a.uBb, Boolean.valueOf(z));
    }

    public static boolean avp() {
        ap.yY();
        Object obj = c.vr().get(a.uBb, Boolean.FALSE);
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static void em(boolean z) {
        ap.yY();
        c.vr().a(a.uBc, Boolean.valueOf(z));
    }

    public static boolean avq() {
        ap.yY();
        Object obj = c.vr().get(a.uBc, Boolean.valueOf(false));
        if (obj != null) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public static void en(boolean z) {
        lOf = z;
    }

    public static boolean avr() {
        return lOf;
    }

    public static boolean avd() {
        return c.auV() && avq() && lOf;
    }

    public static boolean avs() {
        w.i("MicroMsg.FingerPrintUtil", "isShowFPOpenGuide");
        if (avp()) {
            w.e("MicroMsg.FingerPrintUtil", "the fingerprint is open ready");
            return false;
        } else if (!c.auV()) {
            w.e("MicroMsg.FingerPrintUtil", "device is not support");
            return false;
        } else if (m.btS().buj() || m.btS().bun()) {
            w.e("MicroMsg.FingerPrintUtil", "user had not reg wxpay");
            return false;
        } else if (m.btS().buq().buh()) {
            com.tencent.mm.plugin.fingerprint.a.auQ();
            com.tencent.mm.plugin.fingerprint.a.auR();
            if (!c.auX() || avn()) {
                return false;
            }
            w.i("MicroMsg.FingerPrintUtil", "will showOpenFingerPrintPayGuide()");
            return true;
        } else {
            w.e("MicroMsg.FingerPrintUtil", "isSupportTouchPay is false");
            return false;
        }
    }

    public static boolean avt() {
        w.i("MicroMsg.FingerPrintUtil", "isShowFPSettingGuide");
        if (avp()) {
            w.e("MicroMsg.FingerPrintUtil", "the fingerprint is open ready");
            return false;
        } else if (!c.auV()) {
            w.e("MicroMsg.FingerPrintUtil", "device is not support");
            return false;
        } else if (m.btS().buj() || m.btS().bun()) {
            w.e("MicroMsg.FingerPrintUtil", "user had not reg wxpay");
            return false;
        } else if (m.btS().buq().buh()) {
            c cVar = new c();
            if (!c.auX()) {
                boolean booleanValue;
                ap.yY();
                Object obj = c.vr().get(a.uAZ, Boolean.valueOf(false));
                if (obj != null) {
                    booleanValue = ((Boolean) obj).booleanValue();
                } else {
                    booleanValue = false;
                }
                if (!booleanValue) {
                    w.i("MicroMsg.FingerPrintUtil", "will call showSetFingerPrintGuide()");
                    return true;
                }
            }
            return false;
        } else {
            w.e("MicroMsg.FingerPrintUtil", "isSupportTouchPay is false");
            return false;
        }
    }

    public static final String ca(Context context) {
        return context.getApplicationContext().getFilesDir().getAbsolutePath() + "/b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec";
    }

    public static int cb(Context context) {
        InputStream open;
        Throwable e;
        int i;
        InputStream open2;
        FileOutputStream fileOutputStream;
        byte[] bArr;
        int read;
        Throwable e2;
        FileOutputStream fileOutputStream2 = null;
        String ca = ca(context);
        File file = new File(ca);
        if (file.exists()) {
            CharSequence f = com.tencent.mm.a.g.f(file);
            CharSequence charSequence = "";
            try {
                open = context.getAssets().open("b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec");
                if (open != null) {
                    try {
                        charSequence = com.tencent.mm.a.g.a(open, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    } catch (IOException e3) {
                        e = e3;
                        try {
                            w.printErrStackTrace("MicroMsg.FingerPrintUtil", e, "", new Object[0]);
                            if (open != null) {
                                try {
                                    open.close();
                                } catch (Throwable e4) {
                                    w.printErrStackTrace("MicroMsg.FingerPrintUtil", e4, "", new Object[0]);
                                }
                            }
                            if (!!TextUtils.isEmpty(f)) {
                            }
                            if (!TextUtils.isEmpty(f)) {
                            }
                            i = 1;
                            if (i != 0) {
                                return 0;
                            }
                            try {
                                open2 = context.getAssets().open("b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec");
                                try {
                                    fileOutputStream = new FileOutputStream(file);
                                    try {
                                        bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                                        while (true) {
                                            read = open2.read(bArr);
                                            if (read != -1) {
                                                break;
                                            }
                                            fileOutputStream.write(bArr, 0, read);
                                        }
                                        fileOutputStream.flush();
                                        if (open2 != null) {
                                            try {
                                                open2.close();
                                            } catch (Throwable e22) {
                                                w.printErrStackTrace("MicroMsg.FingerPrintUtil", e22, "", new Object[0]);
                                                w.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e22.getMessage());
                                            }
                                        }
                                        try {
                                            fileOutputStream.close();
                                            i = 0;
                                        } catch (Throwable e222) {
                                            w.printErrStackTrace("MicroMsg.FingerPrintUtil", e222, "", new Object[0]);
                                            w.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e222.getMessage());
                                            i = 0;
                                        }
                                    } catch (Exception e5) {
                                        e222 = e5;
                                        fileOutputStream2 = fileOutputStream;
                                        open = open2;
                                        try {
                                            w.printErrStackTrace("MicroMsg.FingerPrintUtil", e222, "", new Object[0]);
                                            w.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets Exception " + e222.getMessage());
                                            if (open != null) {
                                                try {
                                                    open.close();
                                                } catch (Throwable e2222) {
                                                    w.printErrStackTrace("MicroMsg.FingerPrintUtil", e2222, "", new Object[0]);
                                                    w.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e2222.getMessage());
                                                }
                                            }
                                            if (fileOutputStream2 != null) {
                                                try {
                                                    fileOutputStream2.close();
                                                    i = -1;
                                                } catch (Throwable e22222) {
                                                    w.printErrStackTrace("MicroMsg.FingerPrintUtil", e22222, "", new Object[0]);
                                                    w.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e22222.getMessage());
                                                    i = -1;
                                                }
                                            } else {
                                                i = -1;
                                            }
                                            if (Runtime.getRuntime().exec("chmod 777 " + ca).waitFor() != 0) {
                                                w.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                                                return i;
                                            }
                                            w.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                                            return i;
                                        } catch (Throwable th) {
                                            e22222 = th;
                                            if (open != null) {
                                                try {
                                                    open.close();
                                                } catch (Throwable e6) {
                                                    w.printErrStackTrace("MicroMsg.FingerPrintUtil", e6, "", new Object[0]);
                                                    w.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close in stream Exception " + e6.getMessage());
                                                }
                                            }
                                            if (fileOutputStream2 != null) {
                                                try {
                                                    fileOutputStream2.close();
                                                } catch (Throwable e62) {
                                                    w.printErrStackTrace("MicroMsg.FingerPrintUtil", e62, "", new Object[0]);
                                                    w.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets close out stream Exception " + e62.getMessage());
                                                }
                                            }
                                            throw e22222;
                                        }
                                    } catch (Throwable th2) {
                                        e22222 = th2;
                                        fileOutputStream2 = fileOutputStream;
                                        open = open2;
                                        if (open != null) {
                                            open.close();
                                        }
                                        if (fileOutputStream2 != null) {
                                            fileOutputStream2.close();
                                        }
                                        throw e22222;
                                    }
                                } catch (Exception e7) {
                                    e22222 = e7;
                                    open = open2;
                                    w.printErrStackTrace("MicroMsg.FingerPrintUtil", e22222, "", new Object[0]);
                                    w.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets Exception " + e22222.getMessage());
                                    if (open != null) {
                                        open.close();
                                    }
                                    if (fileOutputStream2 != null) {
                                        i = -1;
                                    } else {
                                        fileOutputStream2.close();
                                        i = -1;
                                    }
                                    if (Runtime.getRuntime().exec("chmod 777 " + ca).waitFor() != 0) {
                                        w.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                                        return i;
                                    }
                                    w.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                                    return i;
                                } catch (Throwable th3) {
                                    e22222 = th3;
                                    open = open2;
                                    if (open != null) {
                                        open.close();
                                    }
                                    if (fileOutputStream2 != null) {
                                        fileOutputStream2.close();
                                    }
                                    throw e22222;
                                }
                            } catch (Exception e8) {
                                e22222 = e8;
                                w.printErrStackTrace("MicroMsg.FingerPrintUtil", e22222, "", new Object[0]);
                                w.e("MicroMsg.FingerPrintUtil", "copyTAFromAssets Exception " + e22222.getMessage());
                                if (open != null) {
                                    open.close();
                                }
                                if (fileOutputStream2 != null) {
                                    fileOutputStream2.close();
                                    i = -1;
                                } else {
                                    i = -1;
                                }
                                if (Runtime.getRuntime().exec("chmod 777 " + ca).waitFor() != 0) {
                                    w.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                                    return i;
                                }
                                w.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                                return i;
                            }
                            try {
                                if (Runtime.getRuntime().exec("chmod 777 " + ca).waitFor() != 0) {
                                    w.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                                    return i;
                                }
                                w.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                                return i;
                            } catch (Exception e9) {
                                w.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file Exception " + e9.getMessage());
                                return i;
                            }
                        } catch (Throwable th4) {
                            e22222 = th4;
                            if (open != null) {
                                try {
                                    open.close();
                                } catch (Throwable e622) {
                                    w.printErrStackTrace("MicroMsg.FingerPrintUtil", e622, "", new Object[0]);
                                }
                            }
                            throw e22222;
                        }
                    }
                }
                if (open != null) {
                    try {
                        open.close();
                    } catch (Throwable e42) {
                        w.printErrStackTrace("MicroMsg.FingerPrintUtil", e42, "", new Object[0]);
                    }
                }
            } catch (Throwable e6222) {
                e42 = e6222;
                open = null;
                w.printErrStackTrace("MicroMsg.FingerPrintUtil", e42, "", new Object[0]);
                if (open != null) {
                    open.close();
                }
                if (!TextUtils.isEmpty(f)) {
                }
                if (TextUtils.isEmpty(f)) {
                }
                i = 1;
                if (i != 0) {
                    return 0;
                }
                open2 = context.getAssets().open("b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec");
                fileOutputStream = new FileOutputStream(file);
                bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                while (true) {
                    read = open2.read(bArr);
                    if (read != -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.flush();
                if (open2 != null) {
                    open2.close();
                }
                fileOutputStream.close();
                i = 0;
                if (Runtime.getRuntime().exec("chmod 777 " + ca).waitFor() != 0) {
                    w.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
                    return i;
                }
                w.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
                return i;
            } catch (Throwable th5) {
                e22222 = th5;
                open = null;
                if (open != null) {
                    open.close();
                }
                throw e22222;
            }
            if (!TextUtils.isEmpty(f) && !TextUtils.isEmpty(r0) && f.equals(r0)) {
                i = 0;
            } else if (TextUtils.isEmpty(f) || !TextUtils.isEmpty(r0)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
            i = 1;
            open = null;
        }
        if (i != 0) {
            return 0;
        }
        open2 = context.getAssets().open("b7c9a7fd-851e-7761-07df-8ab7c0b02787.sec");
        fileOutputStream = new FileOutputStream(file);
        bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            read = open2.read(bArr);
            if (read != -1) {
                break;
            }
            fileOutputStream.write(bArr, 0, read);
        }
        fileOutputStream.flush();
        if (open2 != null) {
            open2.close();
        }
        fileOutputStream.close();
        i = 0;
        if (Runtime.getRuntime().exec("chmod 777 " + ca).waitFor() != 0) {
            w.i("MicroMsg.FingerPrintUtil", "chmod wechat ta file succeed ");
            return i;
        }
        w.e("MicroMsg.FingerPrintUtil", "chmod wechat ta file failed ");
        return i;
    }
}
