package com.tencent.mm.plugin.masssend.a;

import com.tencent.mm.e.a.rd;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.apb;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public final class i extends c<rd> {
    public i() {
        this.usg = rd.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        List list = ((rd) bVar).fYf.fYg;
        if (list == null || list.size() <= 0) {
            w.e("MicroMsg.UpdateMassSendPlaceTopListener", "empty mass send top config package");
        } else {
            byte[] a = n.a(((apb) list.get(0)).tfV);
            if (!(a == null || a.length == 0)) {
                String str = new String(a);
                w.i("MicroMsg.UpdateMassSendPlaceTopListener", "MassSendTopConfXml:" + str);
                h.aJu().zU(str);
            }
        }
        return false;
    }
}
