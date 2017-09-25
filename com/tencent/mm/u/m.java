package com.tencent.mm.u;

import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.e;
import com.tencent.mm.a.o;
import com.tencent.mm.j.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.a.e.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

public final class m {
    public static boolean eH(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        String xL = xL();
        if (xL != null && xL.length() > 0) {
            return xL.equals(str);
        }
        w.e("MicroMsg.ConfigStorageLogic", "get userinfo fail");
        return false;
    }

    public static int xK() {
        h.vJ();
        Integer num = (Integer) h.vI().vr().get(9, null);
        return num == null ? 0 : num.intValue();
    }

    public static String getUserBindEmail() {
        h.vJ();
        return bg.mz((String) h.vI().vr().get(5, null));
    }

    public static String xL() {
        h.vJ();
        return (String) h.vI().vr().get(2, null);
    }

    public static String xM() {
        h.vJ();
        return (String) h.vI().vr().get(42, null);
    }

    public static String xN() {
        h.vJ();
        return (String) h.vI().vr().get(4, null);
    }

    public static String xO() {
        String xM = xM();
        return !bg.mA(xM) ? xM : xL();
    }

    public static int xP() {
        h.vJ();
        Integer num = (Integer) h.vI().vr().get(7, null);
        return num == null ? 0 : num.intValue();
    }

    public static long xQ() {
        h.vJ();
        Long l = (Long) h.vI().vr().get(147457, null);
        return l == null ? 0 : l.longValue();
    }

    public static int xR() {
        h.vJ();
        Integer num = (Integer) h.vI().vr().get(40, null);
        return num == null ? 0 : num.intValue();
    }

    public static int xS() {
        h.vJ();
        Integer num = (Integer) h.vI().vr().get(339975, null);
        return num == null ? 0 : num.intValue();
    }

    public static boolean eV(int i) {
        return (i & 8192) != 0;
    }

    public static boolean xT() {
        return (xR() & 16384) != 0;
    }

    public static boolean xU() {
        return (xR() & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0;
    }

    public static void xV() {
        int xR = xR() | WXMediaMessage.THUMB_LENGTH_LIMIT;
        h.vJ();
        h.vI().vr().set(40, Integer.valueOf(xR));
    }

    public static int xW() {
        h.vJ();
        Integer num = (Integer) h.vI().vr().get(34, null);
        return num == null ? 0 : num.intValue();
    }

    public static boolean xX() {
        boolean z;
        if ((xP() & 262144) != 0) {
            z = true;
        } else {
            z = false;
        }
        w.i("MicroMsg.ConfigStorageLogic", "isGooglePay: %s  User Status: %d", Boolean.valueOf(z), Integer.valueOf(xP()));
        return z;
    }

    public static boolean xY() {
        h.vJ();
        h.vI().vr().jY(true);
        if (xS() == 1) {
            return true;
        }
        return false;
    }

    public static boolean xZ() {
        h.vJ();
        h.vI().vr().jY(true);
        if (xS() == 2) {
            return true;
        }
        return false;
    }

    public static boolean ya() {
        h.vJ();
        h.vI().vr().jY(true);
        if (xS() == 4) {
            return true;
        }
        return false;
    }

    public static boolean yb() {
        return (xW() & 32) == 0;
    }

    public static boolean yc() {
        return (xP() & Downloads.RECV_BUFFER_SIZE) != 0;
    }

    public static boolean yd() {
        ay AH = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wZ().AH("@t.qq.com");
        return AH != null && AH.isEnable();
    }

    public static boolean ye() {
        return (xW() & 2) == 0;
    }

    public static boolean yf() {
        return (xW() & 16) == 0;
    }

    public static boolean yg() {
        return (xW() & FileUtils.S_IWUSR) == 0;
    }

    public static boolean yh() {
        h.vJ();
        return bg.f((Boolean) h.vI().vr().get(8200, null));
    }

    public static boolean yi() {
        return (xW() & SQLiteGlobal.journalSizeLimit) == 0;
    }

    public static boolean yj() {
        return (xW() & 262144) == 0;
    }

    public static boolean yk() {
        return (xW() & 8192) == 0;
    }

    public static boolean yl() {
        return (xW() & 65536) == 0;
    }

    public static boolean ym() {
        h.vJ();
        String str = (String) h.vI().vr().get(65825, null);
        if (bg.mA(str)) {
            return false;
        }
        if (str.equals("0")) {
            return false;
        }
        try {
            if (bg.c(Long.valueOf(bg.getLong(str, 0))) == 0) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean yn() {
        return (xW() & 1) == 0;
    }

    public static boolean yo() {
        return (xP() & WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) == 0;
    }

    public static int yp() {
        h.vJ();
        return bg.a((Integer) h.vI().vr().get(8201, null), 22);
    }

    public static int yq() {
        h.vJ();
        return bg.a((Integer) h.vI().vr().get(8208, null), 8);
    }

    public static x yr() {
        a Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(xL());
        if (Rc != null && ((int) Rc.gTQ) > 0) {
            return Rc;
        }
        x xVar = new x();
        h.vJ();
        String str = (String) h.vI().vr().get(2, null);
        h.vJ();
        String str2 = (String) h.vI().vr().get(4, null);
        xVar.setUsername(str);
        xVar.bR(str2);
        ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().R(xVar);
        return ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(str);
    }

    public static b m(int i, String str) {
        b mVar;
        switch (i) {
            case 2:
                mVar = new com.tencent.mm.ao.m(str, 1);
                break;
            case 18:
                mVar = new com.tencent.mm.ao.m(str, 2);
                break;
            default:
                mVar = null;
                break;
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wQ().b(mVar);
        return mVar;
    }

    public static boolean ys() {
        h.vJ();
        return new o(bg.f((Integer) h.vI().vr().get(9, null))).longValue() != 0;
    }

    public static boolean a(String str, String str2, boolean z) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.ConfigStorageLogic", "canSendRawImage, invalid argument");
            return false;
        } else if (str2 != null && str2.length() > 0 && (x.QM(str2) || x.QO(str2))) {
            return false;
        } else {
            boolean z2;
            double d;
            double d2;
            Options options = new Options();
            if (str == null || str.length() == 0) {
                w.e("MicroMsg.ConfigStorageLogic", "isSmallImg, invalid argument");
            } else {
                if (e.aN(str) < 65536) {
                    z2 = true;
                } else {
                    options.inJustDecodeBounds = true;
                    MMBitmapFactory.decodeFile(str, options, null, 0, new int[0]);
                    d = (double) options.outWidth;
                    double d3 = (double) options.outHeight;
                    if (d < 100.0d && d3 < 100.0d) {
                        w.i("MicroMsg.ConfigStorageLogic", "isSmallImg : true, width = " + d + ", height = " + d3);
                        z2 = true;
                    }
                }
                if (z2) {
                    d = (double) options.outWidth;
                    d2 = (double) options.outHeight;
                    if (d / d2 < 2.5d || d2 / d >= 2.5d) {
                        if (e.aN(str) >= 26214400) {
                            w.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true, width height ratio > %s, imgSize:[%s]", Double.valueOf(2.5d), Integer.valueOf(e.aN(str)));
                            return true;
                        }
                        w.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : false, width height ratio > %s, imgSize:[%s]", Double.valueOf(2.5d), Integer.valueOf(e.aN(str)));
                        return false;
                    } else if (z) {
                        return false;
                    } else {
                        return true;
                    }
                }
                w.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true. isSmallImg");
                return true;
            }
            z2 = false;
            if (z2) {
                d = (double) options.outWidth;
                d2 = (double) options.outHeight;
                if (d / d2 < 2.5d) {
                }
                if (e.aN(str) >= 26214400) {
                    w.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : false, width height ratio > %s, imgSize:[%s]", Double.valueOf(2.5d), Integer.valueOf(e.aN(str)));
                    return false;
                }
                w.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true, width height ratio > %s, imgSize:[%s]", Double.valueOf(2.5d), Integer.valueOf(e.aN(str)));
                return true;
            }
            w.i("MicroMsg.ConfigStorageLogic", "canSendRawImage : true. isSmallImg");
            return true;
        }
    }

    public static void a(int i, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Entry entry : map.entrySet()) {
            stringBuilder.append(String.format(Locale.US, "%s\n%s\n", new Object[]{entry.getKey(), entry.getValue()}));
        }
        h.vJ();
        if (h.vI() != null) {
            h.vJ();
            if (h.vI().vr() != null) {
                h.vJ();
                h.vI().vr().set(327682, stringBuilder.toString());
            }
        }
    }

    public static void b(int i, Map<String, String> map) {
        map.clear();
        h.vJ();
        if (h.vI() != null) {
            h.vJ();
            if (h.vI().vr() != null) {
                h.vJ();
                String str = (String) h.vI().vr().get(327682, null);
                if (str != null) {
                    String[] split = str.split("\n");
                    if (split.length % 2 != 0) {
                        w.e("MicroMsg.ConfigStorageLogic", "key and value not match, len: " + String.valueOf(split.length));
                        return;
                    }
                    for (int i2 = 0; i2 < split.length; i2 += 2) {
                        map.put(split[i2], split[i2 + 1]);
                    }
                    return;
                }
                return;
            }
        }
        w.d("MicroMsg.ConfigStorageLogic", "acc stg is null");
    }

    public static Boolean yt() {
        if (h.vG().uV()) {
            h.vJ();
            String str = (String) h.vI().vr().get(6, null);
            h.vJ();
            if (!Boolean.valueOf(bg.f((Boolean) h.vI().vr().get(340241, null))).booleanValue() || bg.mA(str)) {
                return Boolean.valueOf(false);
            }
            String str2 = "86";
            if (str.startsWith("+")) {
                str = an.yU(str);
            } else {
                str = str2;
            }
            if (str == "86") {
                return Boolean.valueOf(false);
            }
            return Boolean.valueOf(true);
        }
        w.e("MicroMsg.ConfigStorageLogic", "mmcore has not ready");
        return Boolean.valueOf(false);
    }
}
