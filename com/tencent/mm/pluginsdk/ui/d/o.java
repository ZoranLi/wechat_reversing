package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.ui.base.s;
import java.io.File;

public final class o {
    public static boolean oz() {
        boolean z = true;
        if (h.vG().uV()) {
            boolean z2;
            if (bg.Hp() || f.fuV == 1 || bg.getInt(g.sV().getValue("ShowWeixinPBIntro"), 0) != 0 || p.n(ab.getContext(), "com.tencent.pb")) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                int a = bg.a((Integer) h.vI().vr().get(a.USERINFO_WXPHONE_PB_COUNT_INT, null), 3);
                w.v("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, counter = %d", Integer.valueOf(a));
                if (a <= 0) {
                    return false;
                }
                h.vI().vr().set(352257, Integer.valueOf(a - 1));
                return true;
            }
            String str = "MicroMsg.WxPhoneBookHelper";
            String str2 = "%b, %b, %b, %b";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(bg.Hp());
            if (f.fuV != 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            if (bg.getInt(g.sV().getValue("ShowWeixinPBIntro"), 0) == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[2] = Boolean.valueOf(z2);
            if (p.n(ab.getContext(), "com.tencent.pb")) {
                z = false;
            }
            objArr[3] = Boolean.valueOf(z);
            w.d(str, str2, objArr);
            return false;
        }
        w.e("MicroMsg.WxPhoneBookHelper", "needDisplayWxPBMenuItem, account not ready");
        return false;
    }

    public static void d(Context context, Bundle bundle) {
        int i = bundle != null ? bundle.getInt("fromScene") : 0;
        com.tencent.mm.plugin.report.service.g.oUh.i(11621, Integer.valueOf(i), Integer.valueOf(0));
        FileDownloadTaskInfo tJ = e.akM().tJ("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
        if (tJ == null || tJ.status != 3) {
            s.makeText(context, context.getString(R.l.dUY), MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN).show();
            com.tencent.mm.plugin.downloader.model.f.a aVar = new com.tencent.mm.plugin.downloader.model.f.a();
            aVar.tL("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
            aVar.tN(context.getString(R.l.dVe));
            aVar.la(1);
            aVar.dn(true);
            e.akM().a(aVar.kHa);
            return;
        }
        w.i("MicroMsg.WxPhoneBookHelper", "weixin phonebook already download successfully, install directly");
        if (com.tencent.mm.a.e.aO(tJ.path)) {
            q.e(context, Uri.fromFile(new File(tJ.path)));
        }
    }
}
