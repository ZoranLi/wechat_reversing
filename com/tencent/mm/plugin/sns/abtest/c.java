package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.tencent.mm.e.a.os;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.a.f;
import com.tencent.mm.u.a.g;
import java.util.HashSet;
import java.util.Set;

public final class c {
    private static boolean pNA = false;
    private static com.tencent.mm.sdk.b.c pNJ = new com.tencent.mm.sdk.b.c<os>() {
        {
            this.usg = os.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            os osVar = (os) bVar;
            if (osVar instanceof os) {
                boolean z = osVar.fVL.fVM;
                long j = osVar.fVL.fLo;
                w.d("MicroMsg.SellerABTestManager", "blockUserEventListener callback, isBlock:%b, snsInfoSvrId:%b", new Object[]{Boolean.valueOf(z), Long.valueOf(j)});
                if (j != 0 && c.pOm.contains(Long.valueOf(j))) {
                    c.k(j, z);
                }
            }
            return false;
        }
    };
    private static String pOl = "0";
    public static Set<Long> pOm = new HashSet();
    private static OnClickListener pOn;

    public static void bdk() {
        if (g.Ae().gu("6") != null) {
            pOl = g.Ae().gu("6").value;
            w.d("MicroMsg.SellerABTestManager", "startABTest, value:%s", new Object[]{pOl});
            pNA = true;
            a.urY.b(pNJ);
            pOn = new OnClickListener() {
                public final void onClick(View view) {
                    if (view.getTag() instanceof m) {
                        m mVar = (m) view.getTag();
                        if (mVar != null && !bg.mA(mVar.bhe())) {
                            c.aw(view.getContext(), mVar.bhe());
                        }
                    }
                }
            };
        }
    }

    public static void bdl() {
        pOn = null;
        a.urY.c(pNJ);
        if (pNA) {
            g.Ae().gu("6").hoE = 2;
            g.Ae().gu("6").result = pOm.size();
            f.a(g.Ae().gu("6"));
            w.d("MicroMsg.SellerABTestManager", "endABTestWhenExitTimeline, scene:%d, result:%s", new Object[]{Integer.valueOf(2), pOm.size()});
        }
        pOl = "0";
        pNA = false;
        pOm.clear();
    }

    public static void k(long j, boolean z) {
        if (pNA) {
            g.Ae().gu("6").hoE = 3;
            g.Ae().gu("6").result = (z ? 2 : 1) + "|" + j;
            f.a(g.Ae().gu("6"));
            w.d("MicroMsg.SellerABTestManager", "endABTestWhenFinishBlock, snsSvrId:%d, isBlock:%b, scene:%d, actionResult:%s", new Object[]{Long.valueOf(j), Boolean.valueOf(z), Integer.valueOf(3), r0});
        }
    }

    public static void b(View view, com.tencent.mm.plugin.sns.ui.a.a.c cVar) {
        if (pNA) {
            cVar.qMy = false;
            cVar.qMw = (ViewStub) view.findViewById(i.f.pFD);
            cVar.qMw.setVisibility(8);
        }
    }

    public static void aw(Context context, String str) {
        m Gf = ae.beL().Gf(str);
        if (Gf != null) {
            String str2 = Gf.field_userName;
            Intent intent = new Intent();
            intent.putExtra("sns_permission_userName", str2);
            intent.putExtra("sns_permission_snsinfo_svr_id", Gf.field_snsId);
            intent.putExtra("sns_permission_block_scene", 7);
            intent.setClass(context, SnsPermissionUI.class);
            context.startActivity(intent);
        }
    }
}
