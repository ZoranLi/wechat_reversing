package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.bk.a;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.b;
import com.tencent.mm.modelbiz.d;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.s;

public final class f {
    public static int bd(Context context, String str) {
        if (bg.mA(str)) {
            return 0;
        }
        int i;
        b hC = w.DO().hC(str);
        if (hC == null || (hC.field_userFlag & 2) == 0) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            return 0;
        }
        if (hC.field_wwExposeTimes < hC.field_wwMaxExposeTimes || p.n(context, "com.tencent.wework")) {
            return 2;
        }
        return 1;
    }

    public static void be(Context context, String str) {
        if (!bg.mA(str) && !p.n(context, "com.tencent.wework")) {
            w.DO().hF(str);
        }
    }

    public static void j(Context context, String str, int i) {
        if (p.n(context, "com.tencent.wework")) {
            Q(str, 4, i);
        } else {
            Q(str, 5, i);
        }
    }

    public static void k(final Context context, final String str, final int i) {
        Q(str, 1, i);
        if (p.n(context, "com.tencent.wework")) {
            Intent launchIntentForPackage;
            Q(str, 2, i);
            PackageInfo az = p.az(context, "com.tencent.wework");
            if (bg.mA(az.versionName) || az.versionName.compareTo("1.3.3") < 0) {
                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.wework");
            } else {
                String str2;
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                if (i == 2 || i == 4 || i == 6) {
                    str2 = "wxwork://createconversation";
                } else {
                    str2 = "wxwork://conversationlist";
                }
                intent.setData(Uri.parse(str2));
                launchIntentForPackage = intent;
            }
            a.post(new Runnable() {
                public final void run() {
                    g.a(context, launchIntentForPackage, context.getString(R.l.eeU));
                }
            });
            return;
        }
        com.tencent.mm.ui.base.g.a(context, R.l.eeX, 0, R.l.eeW, R.l.dGs, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                Context context = context;
                String str = str;
                f.Q(str, 3, i);
                w.DH();
                String str2 = "https://work.weixin.qq.com/wework_admin/commdownload?from=conv%s";
                Object[] objArr = new Object[1];
                objArr[0] = bg.mA(d.hS(str)) ? "off" : "on";
                str = String.format(str2, objArr);
                FileDownloadTaskInfo tJ = e.akM().tJ(str);
                if (tJ != null && tJ.status == 3 && com.tencent.mm.a.e.aO(tJ.path)) {
                    com.tencent.mm.loader.stub.b.deleteFile(tJ.path);
                }
                s.makeText(context, context.getString(R.l.eeY), MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN).show();
                com.tencent.mm.plugin.downloader.model.f.a aVar = new com.tencent.mm.plugin.downloader.model.f.a();
                aVar.tL(str);
                aVar.tN(context.getString(R.l.eeU));
                aVar.la(1);
                aVar.dn(true);
                e.akM().a(aVar.kHa);
            }
        }, null);
    }

    static int Q(String str, int i, int i2) {
        BizInfo hO = w.DH().hO(str);
        if (hO.CI()) {
            str = hO.CO();
        }
        b hC = w.DO().hC(str);
        int i3 = hC != null ? hC.field_qyUin : 0;
        int i4 = hC != null ? hC.field_userUin : 0;
        long j = hC != null ? hC.field_wwCorpId : 0;
        long j2 = hC != null ? hC.field_wwUserVid : 0;
        com.tencent.mm.plugin.report.service.g.oUh.i(13656, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.EnterpriseHelper", "enterprise wework action report: %s,%s,%s,%s,%s,%s", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2));
        return i2;
    }

    public static void cK(String str, int i) {
        if (i > 0) {
            int i2;
            int i3;
            b hC = w.DO().hC(str);
            if (hC != null) {
                i2 = hC.field_qyUin;
            } else {
                i2 = 0;
            }
            if (hC != null) {
                i3 = hC.field_userUin;
            } else {
                i3 = 0;
            }
            com.tencent.mm.plugin.report.service.g.oUh.i(13703, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i));
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.EnterpriseHelper", "enterprise click report: %s,%s,%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i));
        }
    }
}
