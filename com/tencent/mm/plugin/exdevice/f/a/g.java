package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.c.bs;
import com.tencent.mm.protocal.c.bt;
import com.tencent.mm.protocal.c.sk;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class g extends a<bs, bt> {
    List<String> jJK;
    private final WeakReference<b<g>> laR;
    public ArrayList<sk> lft;

    protected final /* synthetic */ com.tencent.mm.bd.a aoL() {
        return new bs();
    }

    protected final /* synthetic */ com.tencent.mm.bd.a aoM() {
        return new bt();
    }

    protected final /* synthetic */ void c(com.tencent.mm.bd.a aVar) {
        bs bsVar = (bs) aVar;
        for (String add : this.jJK) {
            bsVar.hNf.add(add);
        }
    }

    public g(List<String> list, b<g> bVar) {
        this.jJK = list;
        this.laR = new WeakReference(bVar);
    }

    public final int getType() {
        return 1777;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneAddFollow", "ap: errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            bt btVar = (bt) abn();
            this.lft = new ArrayList();
            if (btVar.tfb != null) {
                Iterator it = btVar.tfb.iterator();
                while (it.hasNext()) {
                    w.d("MicroMsg.NetSceneAddFollow", "follow: index:%s step: %s username: %s", new Object[]{Integer.valueOf(r1.index), Integer.valueOf(r1.kzY), ((sk) it.next()).username});
                    this.lft.add(r1);
                }
                w.d("MicroMsg.NetSceneAddFollow", "follows: %s, %d", new Object[]{this.lft.toString(), Integer.valueOf(btVar.tfb.size())});
            }
            ad.apv().a(this.lft, "hardcode_rank_id", "hardcode_app_name");
        }
        super.a(i, i2, i3, str, pVar, bArr);
        b bVar = (b) this.laR.get();
        if (bVar != null) {
            bVar.b(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/addfollow";
    }
}
