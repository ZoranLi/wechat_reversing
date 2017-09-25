package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.eo;
import com.tencent.mm.protocal.c.ep;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;

public final class r extends k implements j {
    private final b gUA;
    private e gUD;
    private int kfK = 0;

    public r(LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.hsm = new eo();
        aVar.hsn = new ep();
        aVar.uri = "/cgi-bin/micromsg-bin/batchdelcarditem";
        aVar.hsl = 560;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((eo) this.gUA.hsj.hsr).tiF = linkedList;
    }

    public final int getType() {
        return 560;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((ep) this.gUA.hsk.hsr).tiG;
            String str2 = "MicroMsg.NetSceneBatchDelCardItem";
            String str3 = "onGYNetEnd, resp list count = %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(linkedList == null ? 0 : linkedList.size());
            w.i(str2, str3, objArr);
            if (linkedList == null || linkedList.size() == 0) {
                w.e("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd fail, resp list is null");
            } else {
                this.kfK = 0;
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    boolean z;
                    String str4 = (String) it.next();
                    if (TextUtils.isEmpty(str4)) {
                        w.e("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem fail, id is null");
                        z = false;
                    } else {
                        c cardInfo = new CardInfo();
                        cardInfo.field_card_id = str4;
                        z = al.aga().a(cardInfo, new String[0]);
                        w.i("MicroMsg.NetSceneBatchDelCardItem", "processDelCardItem, delRet = %b", new Object[]{Boolean.valueOf(z)});
                    }
                    if (!z) {
                        this.kfK++;
                    }
                }
                w.d("MicroMsg.NetSceneBatchDelCardItem", "onGYNetEnd, %d fail items", new Object[]{Integer.valueOf(this.kfK)});
            }
        }
        this.gUD.a(i2, i3, str, this);
    }
}
