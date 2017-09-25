package com.tencent.mm.plugin.hp.b;

import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.e.a.hr;
import com.tencent.mm.protocal.b.a.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;

public final class i {
    public static void a(String str, String str2, String str3, OnClickListener onClickListener, String str4, OnClickListener onClickListener2) {
        if (bg.mA(str2)) {
            w.e("MicroMsg.Tinker.TinkerBootsUpdateDialogUI", "msg is null");
            return;
        }
        w.i("MicroMsg.Tinker.TinkerBootsUpdateDialogUI", "try to show dialog");
        final String str5 = str;
        final String str6 = str2;
        final String str7 = str3;
        final String str8 = str4;
        final OnClickListener onClickListener3 = onClickListener;
        final OnClickListener onClickListener4 = onClickListener2;
        af.v(new Runnable() {
            public final void run() {
                b hrVar = new hr();
                com.tencent.mm.protocal.b.a.b bVar = new com.tencent.mm.protocal.b.a.b();
                bVar.title = str5;
                bVar.fEr = str6;
                bVar.tbf = new LinkedList();
                a aVar = new a();
                aVar.tbd = str7;
                bVar.tbf.add(aVar);
                aVar = new a();
                aVar.tbd = str8;
                bVar.tbf.add(aVar);
                hrVar.fNi.type = 1;
                hrVar.fNi.fNj = bVar;
                hrVar.fNi.fNk = onClickListener3;
                hrVar.fNi.fNl = onClickListener4;
                com.tencent.mm.sdk.b.a.urY.m(hrVar);
            }
        });
    }
}
