package com.tencent.mm.ui.transmit;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ah.k;
import com.tencent.mm.e.a.nv;
import com.tencent.mm.modelmulti.j;
import com.tencent.mm.plugin.messenger.a.c;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.t.f;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bm;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.contact.v;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.a;
import java.util.List;

public final class d implements c {
    public final void A(String str, String str2, int i) {
        if (str == null || str2 == null) {
            w.w("MicroMsg.SendMsgMgr", "send msg args error, toUser[%s] content[%s]", str, str2);
            return;
        }
        ap.vd().a(new j(str, str2, i), 0);
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, String str4) {
        a(context, str, str2, str3, i, i2, null, false, false, str4);
    }

    public final void a(Context context, String str, String str2, String str3, int i, int i2, bdu com_tencent_mm_protocal_c_bdu, boolean z, boolean z2, String str4) {
        int i3 = 1;
        if (context == null) {
            w.w("MicroMsg.SendMsgMgr", "send vedio context is null");
        } else if (str == null || str2 == null) {
            w.w("MicroMsg.SendMsgMgr", "send vedio args error, toUser[%s] fileName[%s]", str, str2);
        } else {
            ap.yY();
            if (com.tencent.mm.u.c.isSDCardAvailable()) {
                final a aVar = new a();
                context.getResources().getString(R.l.dIO);
                Dialog a = g.a(context, context.getResources().getString(R.l.dIB), true, new OnCancelListener(this) {
                    final /* synthetic */ d wrf;

                    public final void onCancel(DialogInterface dialogInterface) {
                        aVar.wqp = true;
                    }
                });
                aVar.context = context;
                aVar.fyF = str2;
                aVar.wqq = str3;
                aVar.ita = a;
                aVar.userName = str;
                aVar.fUY = str4;
                aVar.wqt = false;
                if (62 == i) {
                    aVar.hYB = 11;
                }
                if (i <= 0) {
                    i3 = 0;
                }
                aVar.wpP = i3;
                aVar.iap = i2;
                aVar.wqr = false;
                aVar.wqu = com_tencent_mm_protocal_c_bdu;
                aVar.execute(new Object[0]);
                return;
            }
            w.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
            Toast.makeText(context, R.l.eBz, 1).show();
        }
    }

    public final void b(Context context, String str, String str2, int i, String str3, String str4) {
        if (str == null || str2 == null) {
            w.w("MicroMsg.SendMsgMgr", "sendImg: args error, toUser[%s], fileName[%s]", str, str2);
            return;
        }
        ap.yY();
        if (com.tencent.mm.u.c.isSDCardAvailable()) {
            ap.vd().a(new k(4, m.xL(), str, str2, i, null, 0, str3, str4, true, R.g.bdJ), 0);
            bm.zN().c(bm.hnW, null);
            return;
        }
        w.w("MicroMsg.SendMsgMgr", "sdcard not ready, send video fail");
        Toast.makeText(context, R.l.eBz, 1).show();
    }

    public final void a(String str, byte[] bArr, String str2, String str3) {
        if (str == null) {
            w.w("MicroMsg.SendMsgMgr", "sendAppMsg: args error, toUser is null");
            return;
        }
        w.v("MicroMsg.SendMsgMgr", "for track bug sendAppMsg %s", str2);
        f.a ek = f.a.ek(bg.PX(str2));
        if (ek == null) {
            w.w("MicroMsg.SendMsgMgr", "send: parse app msg content return null");
            return;
        }
        b bVar = new b();
        w.i("MicroMsg.SendMsgMgr", "content.attachid %s", ek.fCW);
        if (!bg.mA(ek.fCW)) {
            long j = bg.getLong(ek.fCW, -1);
            if (j != -1) {
                an.abL().b(j, (com.tencent.mm.sdk.e.c) bVar);
                if (bVar.uxb != j) {
                    bVar = an.abL().LW(ek.fCW);
                    if (bVar == null || !bVar.field_mediaSvrId.equals(ek.fCW)) {
                        bVar = null;
                    }
                    if (bVar == null) {
                        w.i("MicroMsg.SendMsgMgr", "appAttachInfo1  %s", ek.fCW);
                    } else {
                        w.i("MicroMsg.SendMsgMgr", "appAttachInfo2  %s : %s : %s", ek.fCW, Long.valueOf(bVar.uxb), bVar.field_fileFullPath);
                    }
                }
            } else {
                bVar = an.abL().LW(ek.fCW);
                if (bVar == null || !bVar.field_mediaSvrId.equals(ek.fCW)) {
                    bVar = null;
                }
                if (bVar == null) {
                    w.i("MicroMsg.SendMsgMgr", "appAttachInfo3  %s", ek.fCW);
                } else {
                    w.i("MicroMsg.SendMsgMgr", "appAttachInfo4  %s : %s : %s", ek.fCW, Long.valueOf(bVar.uxb), bVar.field_fileFullPath);
                }
            }
        }
        String str4 = "";
        if (!(bVar == null || bVar.field_fileFullPath == null || bVar.field_fileFullPath.equals(""))) {
            ap.yY();
            str4 = l.W(com.tencent.mm.u.c.xn(), ek.title, ek.hhr);
            com.tencent.mm.sdk.platformtools.j.p(bVar.field_fileFullPath, str4, false);
            w.i("MicroMsg.SendMsgMgr", "copy from src %s to dest %s size: %s", bVar.field_fileFullPath, str4, Integer.valueOf(e.aN(bVar.field_fileFullPath)));
        }
        f.a a = f.a.a(ek);
        a.hht = 3;
        l.a(a, ek.appId, ek.appName, str, str4, bArr, str3);
    }

    public final void k(String str, String str2, boolean z) {
        if (z) {
            ap.vd().a(new j(bg.ap(str2, ""), v.TS(str), 42), 0);
            return;
        }
        List f = bg.f(bg.ap(str2, "").split(","));
        String TS = v.TS(str);
        for (int i = 0; i < f.size(); i++) {
            ap.vd().a(new j((String) f.get(i), TS, 42), 0);
        }
    }

    public final void cM(String str, String str2) {
        List<String> f = bg.f(bg.ap(str2, "").split(","));
        if (!TextUtils.isEmpty(str)) {
            for (String str3 : f) {
                com.tencent.mm.sdk.b.b nvVar = new nv();
                nvVar.fVa.fVb = str3;
                nvVar.fVa.content = str;
                nvVar.fVa.type = o.fG(str3);
                nvVar.fVa.flags = 0;
                com.tencent.mm.sdk.b.a.urY.m(nvVar);
            }
        }
    }
}
