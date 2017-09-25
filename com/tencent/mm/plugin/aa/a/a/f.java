package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.h;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;

public final class f extends k implements j {
    public String chatroomName;
    private e gUD;
    private b inV;
    private com.tencent.mm.protocal.c.f inY;
    public g inZ;

    public f(long j, String str, List<String> list, int i, long j2, String str2) {
        a aVar = new a();
        aVar.hsm = new com.tencent.mm.protocal.c.f();
        aVar.hsn = new g();
        aVar.hsl = 1624;
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.chatroomName = str2;
        this.inV = aVar.BE();
        this.inY = (com.tencent.mm.protocal.c.f) this.inV.hsj.hsr;
        this.inV.hsA = true;
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.inY.tbk = list.size();
                    this.inY.tbl = j;
                    this.inY.title = URLEncoder.encode(str, "UTF-8");
                    this.inY.tbm = new LinkedList();
                    this.inY.tbm.addAll(list);
                    this.inY.scene = i;
                    this.inY.tbi = str2;
                    this.inY.tbn = h.btK();
                    this.inY.tbo = j2;
                    w.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[]{this.inY.tbn});
                }
            } catch (Exception e) {
                w.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", new Object[]{e.getMessage()});
            }
        }
        w.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp: %s", new Object[]{Integer.valueOf(this.inY.tbk), Long.valueOf(this.inY.tbl), this.inY.title, this.inY.tbm, Integer.valueOf(this.inY.scene), this.inY.tbi, Long.valueOf(this.inY.tbo)});
    }

    public f(long j, String str, int i, int i2, long j2, String str2) {
        a aVar = new a();
        aVar.hsm = new com.tencent.mm.protocal.c.f();
        aVar.hsn = new g();
        aVar.hsl = 1624;
        aVar.uri = "/cgi-bin/mmpay-bin/newaalaunchbymoney";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.inV = aVar.BE();
        this.inY = (com.tencent.mm.protocal.c.f) this.inV.hsj.hsr;
        this.chatroomName = str2;
        try {
            this.inY.tbk = i;
            this.inY.tbl = j;
            this.inY.title = URLEncoder.encode(str, "UTF-8");
            this.inY.tbm = new LinkedList();
            this.inY.scene = i2;
            this.inY.tbi = str2;
            this.inY.tbn = h.btK();
            w.d("MicroMsg.NetSceneAALaunchByMoney", "location %s", new Object[]{this.inY.tbn});
            this.inY.tbo = j2;
        } catch (Exception e) {
            w.e("MicroMsg.NetSceneAALaunchByMoney", "build NetSceneAALaunchByMoney request error: %s", new Object[]{e.getMessage()});
        }
        w.i("MicroMsg.NetSceneAALaunchByMoney", "NetSceneAALaunchByMoney, total_num: %s, per_amount: %s, title: %s, payer_list: %s, scene: %s, groupid: %s, timestamp", new Object[]{Integer.valueOf(this.inY.tbk), Long.valueOf(this.inY.tbl), this.inY.title, this.inY.tbm, Integer.valueOf(this.inY.scene), this.inY.tbi, Long.valueOf(this.inY.tbo)});
    }

    public final int getType() {
        return 1624;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.NetSceneAALaunchByMoney", "doScene");
        this.gUD = eVar2;
        return a(eVar, this.inV, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneAALaunchByMoney", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.inZ = (g) ((b) pVar).hsk.hsr;
        String str2 = "MicroMsg.NetSceneAALaunchByMoney";
        String str3 = "retcode: %s, retmsg: %s, msgxml==null: %s, billNo: %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(this.inZ.kAC);
        objArr[1] = this.inZ.kAD;
        objArr[2] = Boolean.valueOf(this.inZ.tbj == null);
        objArr[3] = this.inZ.tbh;
        w.i(str2, str3, objArr);
        w.d("MicroMsg.NetSceneAALaunchByMoney", "msgxml: %s", new Object[]{this.inZ.tbj});
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
