package com.tencent.mm.plugin.sns;

import com.tencent.mm.e.a.hm;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;

public final class f extends c<hm> {
    private m pyJ;
    private String pyM;
    private bfc pyN;

    public f() {
        this.usg = hm.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        hm hmVar = (hm) bVar;
        if (hmVar instanceof hm) {
            this.pyM = hmVar.fMT.fGN;
            this.pyJ = ae.beL().Gg(this.pyM);
            this.pyN = this.pyJ.bhd();
            if (this.pyN != null) {
                hmVar.fMU.fMV = this.pyN;
                return true;
            }
        }
        w.f("MicroMsg.GetSnsObjectDetailListener", "mismatched event");
        return false;
    }
}
