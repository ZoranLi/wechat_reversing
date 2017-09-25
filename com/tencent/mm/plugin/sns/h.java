package com.tencent.mm.plugin.sns;

import com.tencent.mm.e.a.lb;
import com.tencent.mm.plugin.sns.model.v;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;

public final class h extends c<lb> {
    public h() {
        this.usg = lb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lb lbVar = (lb) bVar;
        if (!(lbVar instanceof lb)) {
            w.f("MicroMsg.PostSnsTagMemberOptionListener", "mismatched event");
            return false;
        } else if (lbVar.fRI.fRK == null) {
            w.e("MicroMsg.PostSnsTagMemberOptionListener", "event.data.list is null!");
            return false;
        } else {
            k vVar = new v(lbVar.fRI.fJA, lbVar.fRI.fRJ, "", lbVar.fRI.fRK.size(), lbVar.fRI.fRK, lbVar.fRI.scene);
            w.i("MicroMsg.PostSnsTagMemberOptionListener", "opCode " + lbVar.fRI.fJA + " memberList " + lbVar.fRI.fRK.size() + " scene " + lbVar.fRI.scene);
            com.tencent.mm.kernel.h.vH().gXC.a(vVar, 0);
            return true;
        }
    }
}
