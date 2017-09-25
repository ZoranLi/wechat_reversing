package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.protocal.c.adg;
import com.tencent.mm.protocal.c.adh;
import com.tencent.mm.protocal.c.sm;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class k extends a<adg, adh> {
    private final WeakReference<b<k>> laR;
    public List<String> lfX;
    public List<String> lfY;
    public List<String> lfZ;

    protected final /* synthetic */ com.tencent.mm.bd.a aoL() {
        return new adg();
    }

    protected final /* synthetic */ com.tencent.mm.bd.a aoM() {
        return new adh();
    }

    protected final /* bridge */ /* synthetic */ void c(com.tencent.mm.bd.a aVar) {
    }

    public k(b<k> bVar) {
        this.laR = new WeakReference(bVar);
    }

    public final int getType() {
        return 1758;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetWeRunFollowerList", "ap: errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            adh com_tencent_mm_protocal_c_adh = (adh) abn();
            this.lfZ = new ArrayList();
            Iterator it = com_tencent_mm_protocal_c_adh.tIT.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                ap.yY();
                if (c.wR().QY(str2)) {
                    this.lfZ.add(str2);
                }
            }
            this.lfX = new ArrayList();
            this.lfY = new ArrayList();
            if (com_tencent_mm_protocal_c_adh.tIU != null) {
                Iterator it2 = com_tencent_mm_protocal_c_adh.tIU.iterator();
                while (it2.hasNext()) {
                    sm smVar = (sm) it2.next();
                    if (smVar.tAw) {
                        this.lfY.add(smVar.username);
                    }
                    ap.yY();
                    if (c.wR().QY(smVar.username)) {
                        this.lfX.add(smVar.username);
                    }
                }
            }
            w.d("MicroMsg.NetSceneGetWeRunFollowerList", "follow:%s %s", new Object[]{Integer.valueOf(this.lfY.size()), this.lfY.toString()});
            w.d("MicroMsg.NetSceneGetWeRunFollowerList", "all follow:%s %s", new Object[]{Integer.valueOf(this.lfX.size()), this.lfX});
        }
        super.a(i, i2, i3, str, pVar, bArr);
        b bVar = (b) this.laR.get();
        if (bVar != null) {
            w.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is not null");
            bVar.b(i2, i3, str, this);
            return;
        }
        w.d("MicroMsg.NetSceneGetWeRunFollowerList", "callback is null");
    }

    protected final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/getwerunfollowerlist";
    }
}
