package com.tencent.mm.plugin.chatroom.e;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;

public final class a implements com.tencent.mm.u.bp.a {
    public final void a(com.tencent.mm.y.d.a aVar) {
        int i = 1;
        bu buVar = aVar.hst;
        if (buVar.mtd == CdnLogic.MediaType_FAVORITE_VIDEO) {
            String a = n.a(buVar.tff);
            if (bg.mA(a)) {
                w.w("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "msg content is null");
                return;
            }
            String a2 = n.a(buVar.tfd);
            ap.yY();
            ce x = c.wT().x(a2, buVar.tfk);
            if (x.field_msgId <= 0) {
                i = 0;
            }
            x.y(buVar.tfk);
            x.z(ay.i(a2, (long) buVar.ogM));
            x.setType(CdnLogic.MediaType_FAVORITE_VIDEO);
            x.setContent(a);
            x.dw(0);
            x.cH(a2);
            x.cN(buVar.tfi);
            x.dG(x.gxE & -769);
            ay.a(x, aVar);
            if (i == 0) {
                ay.i(x);
                return;
            }
            ap.yY();
            c.wT().b(buVar.tfk, x);
            return;
        }
        w.i("MicroMsg.ChatroomAccessVerifySysCmdMsgListener", "not new xml type:%d ", new Object[]{Integer.valueOf(buVar.mtd)});
    }
}
