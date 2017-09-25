package com.tencent.mm.ui.d;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.e.a.ri;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.protocal.c.bek;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class b {
    public static void j(final Context context, final String str, final boolean z) {
        int i = 1;
        com.tencent.mm.sdk.b.b riVar = new ri();
        riVar.fYq.fCJ = str;
        riVar.fYq.action = z ? 2 : 1;
        riVar.fYq.fYs = 2;
        a.urY.m(riVar);
        LinkedList linkedList = new LinkedList();
        bek com_tencent_mm_protocal_c_bek = new bek();
        com_tencent_mm_protocal_c_bek.ufl = str;
        if (!z) {
            i = 0;
        }
        com_tencent_mm_protocal_c_bek.ufk = i;
        com_tencent_mm_protocal_c_bek.jOc = 3;
        linkedList.add(com_tencent_mm_protocal_c_bek);
        ap.vd().a(1176, new e() {
            public final void a(int i, int i2, String str, k kVar) {
                int i3 = 1;
                ap.vd().b(1176, (e) this);
                w.d("MicroMsg.AppBrandServiceHelper", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(true));
                if (i != 0 || i2 != 0) {
                    s.makeText(context, R.l.eEW, 0).show();
                    com.tencent.mm.sdk.b.b riVar = new ri();
                    riVar.fYq.fCJ = str;
                    ri.a aVar = riVar.fYq;
                    if (!z) {
                        i3 = 2;
                    }
                    aVar.action = i3;
                    riVar.fYq.fYs = 2;
                    a.urY.m(riVar);
                }
            }
        });
        ap.vd().a(new j(linkedList), 0);
    }

    public static String SS(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        WxaAttributes og = ((com.tencent.mm.plugin.appbrand.i.b) h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(str);
        if (og != null && og.RH() != null) {
            return og.RH().iFV;
        }
        w.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
        return null;
    }

    public static String ST(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        WxaAttributes og = ((com.tencent.mm.plugin.appbrand.i.b) h.h(com.tencent.mm.plugin.appbrand.i.b.class)).og(str);
        if (og != null) {
            return og.field_nickname;
        }
        w.e("MicroMsg.AppBrandServiceHelper", "attr is null or getAppInfo return null");
        return null;
    }
}
