package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.kj;
import com.tencent.mm.protocal.c.kk;
import com.tencent.mm.protocal.c.mm;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class l extends k implements j {
    b gUA;
    private e gUD;
    private ArrayList<Long> oAa;

    public l(ArrayList<Long> arrayList) {
        this.oAa = arrayList;
        a aVar = new a();
        aVar.hsm = new kj();
        aVar.hsn = new kk();
        aVar.uri = "/cgi-bin/micromsg-bin/checkconversationfile";
        aVar.hsl = 483;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneCheckConversationFile", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if ((i2 != 0 || i3 != 0) && this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        } else if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 483;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        kj kjVar = (kj) this.gUA.hsj.hsr;
        kjVar.jNd = this.oAa.size();
        LinkedList linkedList = new LinkedList();
        Iterator it = this.oAa.iterator();
        while (it.hasNext()) {
            long longValue = ((Long) it.next()).longValue();
            mm mmVar = new mm();
            mmVar.tfk = longValue;
            linkedList.add(mmVar);
            w.i("MicroMsg.NetSceneCheckConversationFile", "MsgId: %d", new Object[]{Long.valueOf(longValue)});
        }
        kjVar.tqz = linkedList;
        w.i("MicroMsg.NetSceneCheckConversationFile", "Count = %d, MsgInfoList.size = %d", new Object[]{Integer.valueOf(kjVar.jNd), Integer.valueOf(kjVar.tqz.size())});
        return a(eVar, this.gUA, this);
    }
}
