package com.tencent.mm.plugin.card.sharecard.model;

import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.abf;
import com.tencent.mm.protocal.c.abg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class e extends k implements j {
    private final b gUA;
    private com.tencent.mm.y.e gUD;
    public LinkedList<String> kfL;
    public LinkedList<String> kfM = new LinkedList();

    public e(LinkedList<String> linkedList) {
        this.kfL = linkedList;
        a aVar = new a();
        aVar.hsm = new abf();
        aVar.hsn = new abg();
        aVar.uri = "/cgi-bin/micromsg-bin/getsharecardlist";
        aVar.hsl = 903;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((abf) this.gUA.hsj.hsr).tiF = linkedList;
        w.i("MicroMsg.NetSceneGetShareCardList", "card_ids length is " + linkedList.size());
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(903), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            abg com_tencent_mm_protocal_c_abg = (abg) this.gUA.hsk.hsr;
            w.v("MicroMsg.NetSceneGetShareCardList", "json:" + com_tencent_mm_protocal_c_abg.kfG);
            Object obj = com_tencent_mm_protocal_c_abg.kfG;
            if (TextUtils.isEmpty(obj)) {
                w.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd fail, resp json_ret is null");
                this.gUD.a(4, -1, null, this);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList sS = f.sS(obj);
            if (sS != null) {
                if (this.kfL != null) {
                    this.kfM.addAll(this.kfL);
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                ap.yY();
                long cs = c.wO().cs(Thread.currentThread().getId());
                Iterator it = sS.iterator();
                int i4 = 0;
                int i5 = 0;
                while (it.hasNext()) {
                    ShareCardInfo shareCardInfo = (ShareCardInfo) it.next();
                    i4++;
                    if (l.a(shareCardInfo)) {
                        w.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd update share card count");
                        com.tencent.mm.plugin.card.sharecard.a.b.O(ab.getContext(), shareCardInfo.field_card_tp_id);
                        if (shareCardInfo.field_status != 0) {
                            com.tencent.mm.plugin.card.sharecard.a.b.bw(shareCardInfo.field_card_id, shareCardInfo.field_card_tp_id);
                        }
                    } else {
                        i5++;
                        this.kfM.remove(shareCardInfo.field_card_id);
                    }
                }
                ap.yY();
                c.wO().aD(cs);
                w.i("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd do transaction use time %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                w.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, deal CardObject %d fail of %d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i4)});
                l.aiK();
                if (sS.size() > 0) {
                    int currentTimeMillis3 = (int) (System.currentTimeMillis() - currentTimeMillis);
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(281);
                    iDKey.SetKey(17);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(281);
                    iDKey2.SetKey(18);
                    iDKey2.SetValue(currentTimeMillis3);
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(281);
                    iDKey3.SetKey(19);
                    iDKey3.SetValue(sS.size());
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(281);
                    iDKey4.SetKey(21);
                    iDKey4.SetValue(currentTimeMillis3 / sS.size());
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    g.oUh.b(arrayList, true);
                }
            }
            this.gUD.a(i2, i3, str, this);
            return;
        }
        w.e("MicroMsg.NetSceneGetShareCardList", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 903;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
