package com.tencent.mm.u;

import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.b;

public class e implements d {
    private static final a hla = new a();

    private static final class a extends com.tencent.mm.bn.a<com.tencent.mm.plugin.messenger.foundation.a.a> implements com.tencent.mm.plugin.messenger.foundation.a.a {
        public final void a(com.tencent.mm.y.d.a aVar, au auVar, String str, String str2, boolean z) {
            final com.tencent.mm.y.d.a aVar2 = aVar;
            final au auVar2 = auVar;
            final String str3 = str;
            final String str4 = str2;
            final boolean z2 = z;
            a(new com.tencent.mm.bn.a.a<com.tencent.mm.plugin.messenger.foundation.a.a>(this) {
                final /* synthetic */ a hlf;

                public final /* synthetic */ void ao(Object obj) {
                    ((com.tencent.mm.plugin.messenger.foundation.a.a) obj).a(aVar2, auVar2, str3, str4, z2);
                }
            });
        }
    }

    public static void a(com.tencent.mm.plugin.messenger.foundation.a.a aVar) {
        hla.bI(aVar);
    }

    public b b(com.tencent.mm.y.d.a aVar) {
        bu buVar = aVar.hst;
        String str = (String) h.vI().vr().get(2, (Object) "");
        if (str.length() <= 0) {
            return null;
        }
        String a = n.a(buVar.tfd);
        String a2 = n.a(buVar.tfe);
        if (bg.mz(a).length() <= 0 || bg.mz(a2).length() <= 0) {
            w.e("MicroMsg.BaseMsgExtension", "neither from-user nor to-user can be empty");
            return null;
        }
        au a3 = a(buVar, a, a2, str);
        if (a3 == null) {
            return null;
        }
        int i;
        au auVar;
        boolean z = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wZ().has(a) || str.equals(a);
        if (z) {
            a3.dw(1);
            a3.cH(a2);
            i = buVar.jNB;
            auVar = a3;
        } else {
            a3.dw(0);
            a3.cH(a);
            if (buVar.jNB > 3) {
                i = buVar.jNB;
                auVar = a3;
            } else {
                i = 3;
                auVar = a3;
            }
        }
        auVar.dv(i);
        if (buVar.mtd == 10000) {
            a3.dv(4);
        }
        a3.cN(buVar.tfi);
        hla.a(aVar, a3, a, a2, z);
        if (a3.field_msgId == 0) {
            ay.a(a3, aVar);
            a3.x(ay.i(a3));
            b bVar = new b(a3, true);
            if (aVar.hsu) {
                return bVar;
            }
            az.k(a3.field_talker, ((long) aVar.hst.ogM) * 1000);
            return bVar;
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().b(buVar.tfk, a3);
        return new b(a3, false);
    }

    public au a(bu buVar, String str, String str2, String str3) {
        String str4 = str3.equals(str) ? str2 : str;
        au x = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aJX().x(str4, buVar.tfk);
        w.i("MicroMsg.BaseMsgExtension", "summerbadcr dkmsgid prepareMsgInfo svrid:%d localid:%d  from:%s to:%s talker:%s", Long.valueOf(buVar.tfk), Long.valueOf(x.field_msgId), str, str2, str4);
        if (x.field_msgId != 0 && x.field_createTime + 604800000 < ay.i(str4, (long) buVar.ogM)) {
            w.w("MicroMsg.BaseMsgExtension", "dkmsgid prepareMsgInfo msg Too Old Remove it. svrid:%d localid:%d", Long.valueOf(buVar.tfk), Long.valueOf(x.field_msgId));
            ay.L(x.field_msgId);
            x.x(0);
        }
        if (x.field_msgId != 0) {
            return x;
        }
        x = new au();
        x.y(buVar.tfk);
        x.z(ay.i(str4, (long) buVar.ogM));
        x.setType(buVar.mtd);
        x.setContent(bg.Qn(bg.mz(n.a(buVar.tff))));
        return x;
    }

    public void h(au auVar) {
    }
}
