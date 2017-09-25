package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import com.tencent.mm.e.a.ag;
import com.tencent.mm.plugin.brandservice.a.h;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;

public class Plugin implements c {
    public k createApplication() {
        a.urY.b(new com.tencent.mm.sdk.b.c<ag>(this) {
            final /* synthetic */ Plugin jZa;

            {
                this.jZa = r2;
                this.usg = ag.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                ag agVar = (ag) bVar;
                if (agVar == null || !(agVar instanceof ag)) {
                    return false;
                }
                ag agVar2 = agVar;
                switch (agVar2.fDq.action) {
                    case 1:
                        Context context = agVar2.fDq.context;
                        String str = agVar2.fDq.fDs;
                        String str2 = agVar2.fDq.title;
                        int i = agVar2.fDq.fromScene;
                        long j = agVar2.fDq.fDt;
                        int i2 = agVar2.fDq.offset;
                        boolean z = agVar2.fDq.fDu;
                        if (context == null || bg.mA(str)) {
                            w.e("MicroMsg.BrandService.BrandServiceLogic", "context(%s) or keyword(%s) is null or nil.", new Object[]{context, str});
                            return false;
                        }
                        ap.vd().a(1071, new a(context, str, j, i2, i, str2, z, agVar2));
                        ap.vd().a(new h(str, j, i2, i, ""), 0);
                        return true;
                    default:
                        w.d("MicroMsg.BrandService.BrandServiceLogic", "Do not support the action(%d).", new Object[]{Integer.valueOf(agVar2.fDq.action)});
                        return false;
                }
            }
        });
        return new a();
    }

    public com.tencent.mm.pluginsdk.d.b getContactWidgetFactory() {
        return null;
    }

    public am createSubCore() {
        return new b();
    }
}
