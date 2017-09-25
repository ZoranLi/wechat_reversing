package com.tencent.mm.modelcontrol;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.ay.b;
import com.tencent.mm.u.l;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class c implements am {
    public static synchronized c Er() {
        c cVar;
        synchronized (c.class) {
            cVar = (c) l.o(c.class);
        }
        return cVar;
    }

    public static boolean l(au auVar) {
        if (auVar == null) {
            w.w("MicroMsg.SubCoreAutoDownload", "this message is null, can not auto download.");
            return false;
        } else if (!auVar.bMh()) {
            w.w("MicroMsg.SubCoreAutoDownload", "this message is not image, please tell cash.");
            return false;
        } else if (m(auVar)) {
            return Es();
        } else {
            w.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download C2C image.");
            return false;
        }
    }

    public static boolean Es() {
        String value = ((a) h.h(a.class)).sV().getValue("C2CImgNotAutoDownloadTimeRange");
        w.i("MicroMsg.BusyTimeControlLogic", "C2CImgNotAutoDownloadTimeRange value: " + value);
        if (b.iT(value)) {
            w.i("MicroMsg.SubCoreAutoDownload", "it is busy time now , do not auto download C2C image.");
            return false;
        }
        int i = bg.getInt(((a) h.h(a.class)).sV().getValue("ChatImgAutoDownload"), 1);
        if (i == 3) {
            w.i("MicroMsg.SubCoreAutoDownload", "settings is not auto download C2C image. ChatImgAutoDownload : " + i);
            return false;
        }
        Context context = ab.getContext();
        if (i == 2 && com.tencent.mm.sdk.platformtools.am.isWifi(context)) {
            w.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
            return true;
        } else if (i == 1 && com.tencent.mm.sdk.platformtools.am.isWifi(context)) {
            w.i("MicroMsg.SubCoreAutoDownload", "it is wifi now, auto download C2C image.");
            return true;
        } else {
            long j = (long) bg.getInt(((a) h.h(a.class)).sV().getValue("ChatImgAutoDownloadMax"), 0);
            long a = bg.a((Long) h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, null), 0);
            long PZ = bg.PZ((String) DateFormat.format("M", System.currentTimeMillis()));
            long a2 = bg.a((Long) h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, null), 0);
            w.d("MicroMsg.SubCoreAutoDownload", "currentmonth " + PZ + " month " + a2 + " maxcount " + j + " current " + a + " downloadMode: " + i);
            if (PZ != a2) {
                w.i("MicroMsg.SubCoreAutoDownload", "update month %d ", Long.valueOf(PZ));
                h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_AUTOGETBIG_IMG_CURRENT_LONG, Long.valueOf(0));
                h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_AUTOGETBIG_IMG_CURRENT_DATE_LONG, Long.valueOf(PZ));
                a2 = 0;
            } else {
                a2 = a;
            }
            if (a2 > j && j > 0) {
                w.i("MicroMsg.SubCoreAutoDownload", "this month had auto download " + a2 + " C2C image, can not auto download.");
                return false;
            } else if (i == 1 && (com.tencent.mm.sdk.platformtools.am.isWifi(context) || com.tencent.mm.sdk.platformtools.am.is3G(context) || com.tencent.mm.sdk.platformtools.am.is4G(context))) {
                w.i("MicroMsg.SubCoreAutoDownload", "it is wifi or 3,4G now, auto download C2C image.");
                return true;
            } else {
                w.i("MicroMsg.SubCoreAutoDownload", "default can not auto download C2C image.");
                return false;
            }
        }
    }

    public static boolean Et() {
        String value = ((a) h.h(a.class)).sV().getValue("SnsImgPreLoadingAroundTimeLimit");
        w.i("MicroMsg.BusyTimeControlLogic", "SnsImgPreLoadingAroundTimeLimit value: " + value);
        if (b.iT(value)) {
            w.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download SNS image.");
            return false;
        }
        w.i("MicroMsg.SubCoreAutoDownload", "it is not busy time, can auto download SNS image.");
        return true;
    }

    public static boolean a(PInt pInt, PInt pInt2, PInt pInt3) {
        pInt.value = 0;
        int i = bg.getInt(((a) h.h(a.class)).sV().getValue("SIGHTAutoLoadNetwork"), 1);
        pInt2.value = i;
        if (i == 3) {
            w.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video");
            return false;
        }
        boolean isWifi = com.tencent.mm.sdk.platformtools.am.isWifi(ab.getContext());
        if (i == 2 && !isWifi) {
            w.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video.");
            return false;
        } else if (com.tencent.mm.sdk.platformtools.am.is2G(ab.getContext())) {
            w.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video.");
            return false;
        } else {
            String value = ((a) h.h(a.class)).sV().getValue("SnsSightNoAutoDownload");
            if (!bg.mA(value)) {
                try {
                    w.i("MicroMsg.SubCoreAutoDownload", "dynamicConfigValSeq " + value);
                    long j = bg.getLong(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()), 0) - ((((long) (((int) b.Eq()) - 8)) * 60) / 1000);
                    String[] split = value.split(",");
                    long j2 = bg.getLong(split[0], 0);
                    if (j <= bg.getLong(split[1], 0) && j >= j2) {
                        w.i("MicroMsg.SubCoreAutoDownload", "config settings can not auto download SNS short video");
                        pInt3.value = 1;
                        return false;
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.SubCoreAutoDownload", "paser error %s msg: %s", value, e.getMessage());
                }
            }
            String value2 = ((a) h.h(a.class)).sV().getValue("SnsSightNotAutoDownloadTimeRange");
            w.i("MicroMsg.BusyTimeControlLogic", "SnsSightNotAutoDownloadTimeRange value: " + value2);
            if (b.iT(value2)) {
                int i2;
                w.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto download(but need check again) SNS short video");
                if (i == 2) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                pInt.value = i2;
                return false;
            }
            w.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download.");
            return true;
        }
    }

    public static boolean a(PInt pInt, PInt pInt2) {
        pInt.value = 0;
        int i = bg.getInt(((a) h.h(a.class)).sV().getValue("SIGHTAutoLoadNetwork"), 1);
        pInt2.value = i;
        if (i == 3) {
            w.i("MicroMsg.SubCoreAutoDownload", "user settings can not auto download SNS short video[AD]");
            return false;
        }
        boolean isWifi = com.tencent.mm.sdk.platformtools.am.isWifi(ab.getContext());
        if (i == 2 && !isWifi) {
            w.i("MicroMsg.SubCoreAutoDownload", "it is not wifi now, and status_only_wifi, not auto download SNS short video[AD].");
            return false;
        } else if (com.tencent.mm.sdk.platformtools.am.is2G(ab.getContext())) {
            w.i("MicroMsg.SubCoreAutoDownload", "it is 2G now, can not auto download SNS short video[AD].");
            return false;
        } else {
            String value = ((a) h.h(a.class)).sV().getValue("SnsAdSightNotAutoDownloadTimeRange");
            w.i("MicroMsg.BusyTimeControlLogic", "isSnsAdSightNotAutoDownload value: " + value);
            if (b.iT(value)) {
                int i2;
                w.i("MicroMsg.SubCoreAutoDownload", "it is busy time now, can not auto(but need check again) download SNS short video[AD]");
                if (i == 2) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                pInt.value = i2;
                return false;
            }
            w.i("MicroMsg.SubCoreAutoDownload", "skip all not auto download case, then auto download[AD].");
            return true;
        }
    }

    public static boolean m(au auVar) {
        if (auVar == null) {
            w.w("MicroMsg.SubCoreAutoDownload", "this message is null.");
            return false;
        }
        b gm = ay.gm(auVar.gxF);
        if (gm == null) {
            w.i("MicroMsg.SubCoreAutoDownload", "this message had no msg source.");
            return true;
        }
        String str = gm.hmX;
        if (bg.mA(str)) {
            w.i("MicroMsg.SubCoreAutoDownload", "this message had no not auto download time range config.");
            return true;
        } else if (b.iT(str)) {
            w.i("MicroMsg.SubCoreAutoDownload", "this message need control, can not auto download. timeRange : " + str);
            return false;
        } else {
            w.i("MicroMsg.SubCoreAutoDownload", "this message need control, but it is not the time. timeRange: " + str);
            return true;
        }
    }

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
    }
}
