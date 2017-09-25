package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.mm.ap.i;
import com.tencent.mm.app.e.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;

public final class g {
    public static void run() {
        SharedPreferences sharedPreferences;
        int i;
        Context context = ab.getContext();
        a anonymousClass1 = new a() {
            public final void cS(int i) {
                w.i("MicroMsg.PostTaskLightweightJob", "CrashStatus report: key %s ", Integer.valueOf(i));
                com.tencent.mm.plugin.report.service.g.oUh.a(25, (long) i, 1, false);
            }
        };
        if (context != null) {
            try {
                sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
                String[] split = sharedPreferences.getString("crashlist", "").split(";");
                if (split != null && split.length > 0) {
                    Editor edit = sharedPreferences.edit();
                    edit.putString("crashlist", "");
                    edit.commit();
                    for (i = 0; i < split.length; i++) {
                        String[] split2 = split[i] == null ? null : split[i].split(",");
                        if (split2 != null && split2.length >= 2) {
                            if (split2[1].equals("anr")) {
                                anonymousClass1.cS(10);
                            } else {
                                anonymousClass1.cS(11);
                                if ("com.tencent.mm".equals(split2[0])) {
                                    anonymousClass1.cS(14);
                                }
                                if ("com.tencent.mm:push".equals(split2[0])) {
                                    anonymousClass1.cS(17);
                                }
                                if ("com.tencent.mm:tools".equals(split2[0])) {
                                    anonymousClass1.cS(20);
                                }
                                if (split2[1].equals("java")) {
                                    anonymousClass1.cS(12);
                                    if ("com.tencent.mm".equals(split2[0])) {
                                        anonymousClass1.cS(15);
                                    }
                                    if ("com.tencent.mm:push".equals(split2[0])) {
                                        anonymousClass1.cS(18);
                                    }
                                    if ("com.tencent.mm:tools".equals(split2[0])) {
                                        anonymousClass1.cS(21);
                                    }
                                }
                                if (split2[1].equals("jni")) {
                                    anonymousClass1.cS(13);
                                    if ("com.tencent.mm".equals(split2[0])) {
                                        anonymousClass1.cS(16);
                                    }
                                    if ("com.tencent.mm:push".equals(split2[0])) {
                                        anonymousClass1.cS(19);
                                    }
                                    if ("com.tencent.mm:tools".equals(split2[0])) {
                                        anonymousClass1.cS(22);
                                    }
                                }
                                if (split2[1].equals("first")) {
                                    if ("com.tencent.mm".equals(split2[0])) {
                                        anonymousClass1.cS(23);
                                    }
                                    if ("com.tencent.mm:push".equals(split2[0])) {
                                        anonymousClass1.cS(24);
                                    }
                                    if ("com.tencent.mm:tools".equals(split2[0])) {
                                        anonymousClass1.cS(25);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
        context = ab.getContext();
        i = com.tencent.mm.i.g.sV().getInt("AndroidGooglePlayCrashUploadSizeLimit", WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        if (context != null && i > 0) {
            try {
                sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
                if (sharedPreferences.getInt("googleplaysizelimit", WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) != i) {
                    edit = sharedPreferences.edit();
                    edit.putInt("googleplaysizelimit", i);
                    edit.commit();
                }
            } catch (Throwable th2) {
            }
        }
        ap.yY();
        if (u.aA(u.d((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_REPORT_LAST_TIME_REPORT_DYNACFG_VER_LONG, null))) > 21600000) {
            com.tencent.mm.plugin.report.service.g.oUh.a(279, (long) (com.tencent.mm.i.g.sV().getInt("AndroidDynamicConfigVer", 0) % 16), 1, false);
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.USERINFO_REPORT_LAST_TIME_REPORT_DYNACFG_VER_LONG, Long.valueOf(u.Nz()));
        }
        ap.yY();
        if (u.aA(u.d((Long) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_REPORT_LAST_TIME_REPORT_VIDEO_SEND_RECV_COUNT_LONG, null))) > 21600000) {
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.USERINFO_REPORT_LAST_TIME_REPORT_VIDEO_SEND_RECV_COUNT_LONG, Long.valueOf(u.Nz()));
            s KV = o.KV();
            int[] iArr = new int[]{0, 0, 0, 0, 0, 0};
            try {
                w.i("MicroMsg.VideoInfoStorage", "reportVideoMsgCount sql:%s", "select status, videofuncflag, human from videoinfo2 where lastmodifytime > " + (bg.Ny() - 21600));
                Cursor a = KV.hnH.a(r2, null, 2);
                while (a.moveToNext()) {
                    int i2 = a.getInt(0);
                    int i3 = a.getInt(1);
                    String string = a.getString(2);
                    if (111 == i2) {
                        if (i3 == 3) {
                            i2 = 0;
                        } else {
                            i2 = 3;
                        }
                        iArr[i2] = iArr[i2] + 1;
                    } else if (199 != i2) {
                        continue;
                    } else if (m.xL().equals(string)) {
                        i2 = i3 == 3 ? 1 : 4;
                        iArr[i2] = iArr[i2] + 1;
                    } else {
                        i2 = i3 == 3 ? 2 : 5;
                        iArr[i2] = iArr[i2] + 1;
                    }
                }
                a.close();
                com.tencent.mm.plugin.report.service.g.oUh.i(12696, Integer.valueOf(10010), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr[2]), Integer.valueOf(iArr[3]), Integer.valueOf(iArr[4]), Integer.valueOf(iArr[5]));
            } catch (Exception e) {
            }
        }
        if (bg.Nz() - bg.a((Long) h.vI().vr().get(81939, null), 0) > 86400000) {
            i iVar = new i();
        }
        long currentTimeMillis = System.currentTimeMillis();
        ap.yY();
        boolean booleanValue = ((Boolean) c.vr().get(233475, Boolean.valueOf(false))).booleanValue();
        ap.yY();
        if (c.wR().bLv() <= 0) {
            if (!booleanValue) {
                ap.yY();
                c.wW().Rl("officialaccounts");
                ap.yY();
                c.vr().set(233475, Boolean.valueOf(true));
            }
        } else if (booleanValue) {
            ap.yY();
            c.vr().set(233475, Boolean.valueOf(false));
        }
        w.i("MicroMsg.PostTaskLightweightJob", "use time %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }
}
