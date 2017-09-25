package com.tencent.mm.plugin.shake.c.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public final class a {
    private static SimpleDateFormat krb = null;

    public static void baM() {
        w.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance()");
        if (baN()) {
            w.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is open");
            if (!bbh()) {
                w.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time, close card entrance");
                ap.yY();
                c.vr().a(com.tencent.mm.storage.w.a.uzo, Boolean.valueOf(false));
                return;
            }
            return;
        }
        w.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is not open");
        if (bbh()) {
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.uzo, Boolean.valueOf(true));
            w.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() open shake card entrance");
            return;
        }
        w.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time");
    }

    public static boolean baN() {
        if (ap.zb()) {
            boolean booleanValue;
            ap.yY();
            Object obj = c.vr().get(com.tencent.mm.storage.w.a.uzo, Boolean.valueOf(false));
            if (obj != null) {
                booleanValue = ((Boolean) obj).booleanValue();
            } else {
                booleanValue = false;
            }
            return booleanValue;
        }
        w.e("MicroMsg.ShakeCardUtil", "acc is not ready");
        return false;
    }

    private static boolean bbh() {
        ap.yY();
        int intValue = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.uzp, Integer.valueOf(0))).intValue();
        ap.yY();
        int intValue2 = ((Integer) c.vr().get(com.tencent.mm.storage.w.a.uzq, Integer.valueOf(0))).intValue();
        w.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time : " + intValue + " end time : " + intValue2);
        if (intValue <= 0) {
            w.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is " + intValue + " , invalid");
            return false;
        } else if (intValue2 <= 0) {
            w.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil end time  is " + intValue2 + " , invalid");
            return false;
        } else if (intValue >= intValue2) {
            w.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is >= end time, invalid time");
            return false;
        } else {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            w.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time : " + currentTimeMillis);
            if (currentTimeMillis < intValue || currentTimeMillis > intValue2) {
                w.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is not incled in [btime, etime]");
                return false;
            }
            w.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is incled in [btime, etime]");
            return true;
        }
    }

    public static int bbi() {
        ap.yY();
        return ((Integer) c.vr().get(com.tencent.mm.storage.w.a.uzv, Integer.valueOf(0))).intValue();
    }

    public static String bbj() {
        ap.yY();
        return (String) c.vr().get(com.tencent.mm.storage.w.a.uzu, "");
    }

    public static String bbk() {
        ap.yY();
        return (String) c.vr().get(com.tencent.mm.storage.w.a.uzr, "");
    }

    public static String bbl() {
        ap.yY();
        return (String) c.vr().get(com.tencent.mm.storage.w.a.uzx, "");
    }

    public static String bbm() {
        ap.yY();
        return (String) c.vr().get(com.tencent.mm.storage.w.a.uzw, "");
    }

    public static String bbn() {
        ap.yY();
        return (String) c.vr().get(com.tencent.mm.storage.w.a.uzA, "");
    }

    public static String bbo() {
        ap.yY();
        return (String) c.vr().get(com.tencent.mm.storage.w.a.uzz, "");
    }

    public static boolean sx(int i) {
        return i >= 0 && i <= 5;
    }

    public static int bbp() {
        ap.yY();
        int currentTimeMillis = (int) (System.currentTimeMillis() % 10);
        int nextInt = (new Random((long) c.uH()).nextInt(10) + currentTimeMillis) % 10;
        w.i("MicroMsg.ShakeCardUtil", "genShakeCardFrequencyLevel retRand:" + nextInt);
        return nextInt;
    }

    public static int sy(int i) {
        switch (i) {
            case 1:
                return 10;
            case 2:
                return 30;
            case 3:
                return 60;
            case 4:
                return 120;
            case 5:
                return 240;
            default:
                return 0;
        }
    }

    public static int sz(int i) {
        switch (i) {
            case 1:
                return 20;
            case 2:
                return 30;
            case 3:
                return 60;
            case 4:
                return 90;
            case 5:
                return 120;
            case 6:
                return ck.CTRL_INDEX;
            case 7:
                return 180;
            case 8:
                return 240;
            case 9:
                return e.CTRL_INDEX;
            default:
                return 10;
        }
    }

    public static int ta(String str) {
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            w.e("MicroMsg.ShakeCardUtil", "string format error");
        } else {
            try {
                String toUpperCase = str.substring(1).toUpperCase();
                rgb = Color.argb(255, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
            } catch (Exception e) {
                w.e("MicroMsg.ShakeCardUtil", e.toString());
            }
        }
        return rgb;
    }

    public static String aq(long j) {
        long j2 = 1000 * j;
        new GregorianCalendar().setTimeInMillis(j2);
        if (krb == null) {
            krb = new SimpleDateFormat("yyyy.MM.dd");
        }
        return krb.format(new Date(j2));
    }

    public static void o(Context context, String str, String str2) {
        w.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil doCardDetailUI()");
        Intent intent = new Intent();
        intent.putExtra("key_card_id", str);
        intent.putExtra("key_card_ext", str2);
        intent.putExtra("key_from_scene", 15);
        d.b(context, "card", ".ui.CardDetailUI", intent);
    }

    public static boolean bbq() {
        return baN() && v.bIJ();
    }

    public static void baO() {
        w.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil setShakeCardEntranceData()");
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int i = 86400 + currentTimeMillis;
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uzp, Integer.valueOf(currentTimeMillis));
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uzq, Integer.valueOf(i));
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uzr, "");
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uzv, Integer.valueOf(0));
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uzs, Integer.valueOf(1));
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uzt, Integer.valueOf(6));
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uzu, "");
        com.tencent.mm.q.c.uk().t(262154, true);
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uzw, String.valueOf(currentTimeMillis));
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uzx, "hello");
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uzy, "shake card");
    }

    public static void baP() {
        w.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil clearShakeCardEntranceData()");
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uzp, Integer.valueOf(0));
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uzq, Integer.valueOf(0));
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uzr, "");
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uzv, Integer.valueOf(0));
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uzs, Integer.valueOf(0));
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uzt, Integer.valueOf(0));
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uzu, "");
        com.tencent.mm.q.c.uk().t(262154, false);
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uzw, "");
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uzx, "");
        ap.yY();
        c.vr().a(com.tencent.mm.storage.w.a.uzy, "");
    }
}
