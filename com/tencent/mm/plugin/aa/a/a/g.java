package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.compatible.util.p;
import com.tencent.mm.network.j;
import com.tencent.mm.protocal.c.h;
import com.tencent.mm.protocal.c.i;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public final class g extends k implements j {
    public String chatroomName;
    private e gUD;
    private b inV;
    private h ioa;
    public i iob;

    public g(String str, long j, List<com.tencent.mm.protocal.c.j> list, int i, String str2, long j2) {
        a aVar = new a();
        aVar.hsm = new h();
        aVar.hsn = new i();
        aVar.hsl = 1655;
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbyperson";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.inV = aVar.BE();
        this.ioa = (h) this.inV.hsj.hsr;
        this.inV.hsA = true;
        try {
            this.ioa.title = p.encode(str, "UTF-8");
            this.ioa.tbq = j;
            this.ioa.tbm = new LinkedList();
            this.ioa.tbm.addAll(list);
            this.ioa.scene = i;
            this.ioa.tbi = str2;
            this.ioa.tbn = com.tencent.mm.plugin.wallet_core.model.h.btK();
            this.ioa.tbo = j2;
            w.d("MicroMsg.NetSceneAALaunchByPerson", "location %s", new Object[]{this.ioa.tbn});
        } catch (Exception e) {
            w.e("MicroMsg.NetSceneAALaunchByPerson", "build NetSceneAALaunchByPerson request error: %s", new Object[]{e.getMessage()});
        }
        this.chatroomName = str2;
        w.i("MicroMsg.NetSceneAALaunchByPerson", "NetSceneAALaunchByPerson, title: %s, total_pay_amount: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s", new Object[]{this.ioa.title, Long.valueOf(this.ioa.tbq), this.ioa.tbm, Integer.valueOf(this.ioa.scene), this.ioa.tbi, Long.valueOf(this.ioa.tbo)});
    }

    public final int getType() {
        return 1655;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.d("MicroMsg.NetSceneAALaunchByPerson", "doScene");
        this.gUD = eVar2;
        return a(eVar, this.inV, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneAALaunchByPerson", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.iob = (i) ((b) pVar).hsk.hsr;
        String str2 = "MicroMsg.NetSceneAALaunchByPerson";
        String str3 = "retcode: %s, retmsg: %s, bill_no: %s, msgxml==null: %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.iob.kAC);
        objArr[1] = this.iob.kAD;
        objArr[2] = this.iob.tbh;
        objArr[3] = Boolean.valueOf(this.iob.tbj == null);
        w.i(str2, str3, objArr);
        w.d("MicroMsg.NetSceneAALaunchByPerson", "msgxml: %s", new Object[]{this.iob.tbj});
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
