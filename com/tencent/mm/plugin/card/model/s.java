package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.protocal.c.ez;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class s extends k implements j {
    private final b gUA;
    private e gUD;
    private LinkedList<aj> kfL;
    public LinkedList<aj> kfM = new LinkedList();

    public s(LinkedList<aj> linkedList) {
        this.kfL = linkedList;
        a aVar = new a();
        aVar.hsm = new ey();
        aVar.hsn = new ez();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetcarditem";
        aVar.hsl = 559;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((ey) this.gUA.hsj.hsr).tiF = C(linkedList);
    }

    public final int getType() {
        return 559;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            Object obj = ((ez) this.gUA.hsk.hsr).kfG;
            if (TextUtils.isEmpty(obj)) {
                w.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
                this.gUD.a(4, -1, null, this);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList sT = f.sT(obj);
            if (sT != null) {
                if (this.kfL != null) {
                    this.kfM.addAll(this.kfL);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                ap.yY();
                long cs = c.wO().cs(Thread.currentThread().getId());
                int i4 = 0;
                Iterator it = sT.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    CardInfo cardInfo = (CardInfo) it.next();
                    i5++;
                    if (!l.b(cardInfo)) {
                        i4++;
                        LinkedList linkedList = this.kfM;
                        if (cardInfo != null) {
                            aj ajVar = new aj();
                            ajVar.field_cardUserId = cardInfo.field_card_id;
                            linkedList.remove(ajVar);
                        }
                    }
                    i4 = i4;
                }
                ap.yY();
                c.wO().aD(cs);
                w.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd do transaction use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                w.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, deal CardObject %d fail of %d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5)});
                l.aiI();
                if (sT.size() > 0) {
                    int currentTimeMillis3 = (int) (System.currentTimeMillis() - currentTimeMillis);
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(281);
                    iDKey.SetKey(43);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(281);
                    iDKey2.SetKey(44);
                    iDKey2.SetValue(currentTimeMillis3);
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(281);
                    iDKey3.SetKey(45);
                    iDKey3.SetValue(sT.size());
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(281);
                    iDKey4.SetKey(47);
                    iDKey4.SetValue(currentTimeMillis3 / sT.size());
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    g.oUh.b(arrayList, true);
                }
            }
            this.gUD.a(0, 0, str, this);
            return;
        }
        w.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gUD.a(i2, i3, str, this);
    }

    private static LinkedList<String> C(LinkedList<aj> linkedList) {
        LinkedList<String> linkedList2 = new LinkedList();
        if (linkedList == null || linkedList.size() == 0) {
            return linkedList2;
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            aj ajVar = (aj) it.next();
            if (ajVar != null) {
                linkedList2.add(ajVar.field_cardUserId);
            }
        }
        return linkedList2;
    }
}
