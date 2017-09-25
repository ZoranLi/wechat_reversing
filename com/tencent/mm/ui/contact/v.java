package com.tencent.mm.ui.contact;

import android.app.Activity;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.snackbar.a;
import com.tencent.mm.x.h;
import com.tencent.mm.x.n;
import java.util.List;

public final class v {
    public static String TS(String str) {
        String str2;
        h hs = n.Bm().hs(str);
        ap.yY();
        af Rc = c.wR().Rc(str);
        int i = Rc.gkq;
        if (hs != null) {
            i = hs.gkq;
        }
        BizInfo hW = Rc.bLe() ? e.hW(Rc.field_username) : null;
        String str3 = "<msg username=\"%s\" nickname=\"%s\" alias=\"%s\" fullpy=\"%s\" shortpy=\"%s\" imagestatus=\"%d\" scene=\"17\" province=\"%s\" city=\"%s\" sign=\"%s\" percard=\"%d\" sex=\"%d\" certflag=\"%d\" certinfo=\"%s\" certinfoext=\"\" brandIconUrl=\"%s\" brandHomeUrl=\"\" brandSubscriptConfigUrl=\"\" brandFlags=\"\" regionCode=\"%s\"/>";
        Object[] objArr = new Object[15];
        objArr[0] = bg.PW(Rc.field_username);
        objArr[1] = bg.PW(Rc.tK());
        objArr[2] = bg.PW(Rc.pA());
        objArr[3] = bg.PW(Rc.tK());
        objArr[4] = bg.PW(Rc.pB());
        objArr[5] = Integer.valueOf(i);
        objArr[6] = bg.PW(Rc.getProvince());
        objArr[7] = bg.PW(Rc.getCity());
        objArr[8] = bg.PW(Rc.signature);
        objArr[9] = Integer.valueOf(Rc.gkA);
        objArr[10] = Integer.valueOf(Rc.gkr);
        objArr[11] = Integer.valueOf(Rc.field_verifyFlag);
        objArr[12] = bg.PW(Rc.gkG);
        if (hW == null) {
            str2 = "";
        } else {
            str2 = bg.PW(hW.field_brandIconURL);
        }
        objArr[13] = str2;
        objArr[14] = bg.PW(Rc.gkH);
        return String.format(str3, objArr);
    }

    public static void a(final Activity activity, String str, List<String> list) {
        for (String TS : list) {
            ap.vd().a(new j(str, TS(TS), 42), 0);
        }
        a.e(activity, activity.getString(R.l.esl));
        g.oUh.i(11003, str, Integer.valueOf(3), Integer.valueOf(list.size()));
        activity.setResult(-1);
        com.tencent.mm.sdk.platformtools.af.f(new Runnable() {
            public final void run() {
                activity.finish();
            }
        }, 1800);
    }
}
