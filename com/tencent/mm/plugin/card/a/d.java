package com.tencent.mm.plugin.card.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.it;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class d implements com.tencent.mm.plugin.card.a.k.a, com.tencent.mm.plugin.card.base.d, e {
    public WeakReference<Context> aeF;
    public List<WeakReference<a>> kcI = new ArrayList();
    public HashMap<a, Boolean> kcU = new HashMap();
    public HashMap<String, Boolean> kcV = new HashMap();
    public HashMap<String, Boolean> kcW = new HashMap();
    public b kcX = null;
    public boolean kcY = false;
    public String kcZ;

    public interface a {
        void afF();

        void afG();

        void f(b bVar);

        void sj(String str);
    }

    public final void release() {
        ap.vd().b(910, this);
        al.agh().b(this);
        b afZ = al.afZ();
        if (afZ.kcI != null && this != null) {
            for (int i = 0; i < afZ.kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) afZ.kcI.get(i);
                if (weakReference != null) {
                    com.tencent.mm.plugin.card.base.d dVar = (com.tencent.mm.plugin.card.base.d) weakReference.get();
                    if (dVar != null && dVar.equals(this)) {
                        afZ.kcI.remove(weakReference);
                        break;
                    }
                }
            }
        }
        this.kcI.clear();
        this.kcU.clear();
        this.kcW.clear();
        this.kcY = false;
    }

    public final void a(a aVar) {
        if (this.kcI == null) {
            this.kcI = new ArrayList();
        }
        if (aVar != null) {
            this.kcI.add(new WeakReference(aVar));
        }
    }

    public final void b(a aVar) {
        if (this.kcI != null && aVar != null) {
            for (int i = 0; i < this.kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kcI.get(i);
                if (weakReference != null) {
                    a aVar2 = (a) weakReference.get();
                    if (aVar2 != null && aVar2.equals(aVar)) {
                        this.kcI.remove(weakReference);
                        return;
                    }
                }
            }
        }
    }

    public final void d(b bVar) {
        this.kcX = bVar;
        if (!(!this.kcY || this.kcX == null || bVar.afm() == null || bVar.afm().equals(this.kcX.afm()))) {
            this.kcY = false;
        }
        if (this.kcI != null) {
            for (int i = 0; i < this.kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kcI.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    Boolean bool = (Boolean) this.kcU.get(aVar);
                    if (!(aVar == null || bool == null || bool.booleanValue())) {
                        aVar.f(bVar);
                    }
                }
            }
        }
    }

    public final void a(a aVar, boolean z) {
        if (this.kcU == null) {
            this.kcU = new HashMap();
        }
        this.kcU.put(aVar, Boolean.valueOf(z));
    }

    public final void c(a aVar) {
        if (this.kcU == null) {
            this.kcU = new HashMap();
        }
        this.kcU.remove(aVar);
    }

    public final void aft() {
        w.i("MicroMsg.CardConsumedMgr", "onDBchange()");
        if (this.kcX == null) {
            w.e("MicroMsg.CardConsumedMgr", "onDBchange(), do nothing, mCardInfo == null");
            return;
        }
        if (this.kcX.aeO()) {
            b sH = al.agi().sH(this.kcX.afm());
        } else {
            Object sr = al.aga().sr(this.kcX.afm());
        }
        if (sH != null && sH.afj() != null && this.kcX != null && this.kcX.afj() != null) {
            w.d("MicroMsg.CardConsumedMgr", "onDBchange() oldState %s, newStatus %s, isDoingConsumedInfo %s, isShareCard %s", new Object[]{Integer.valueOf(this.kcX.afj().status), Integer.valueOf(sH.afj().status), Boolean.valueOf(this.kcY), Boolean.valueOf(this.kcX.aeO())});
            if (this.kcX.aeO() && (this.kcX instanceof ShareCardInfo)) {
                w.d("MicroMsg.CardConsumedMgr", "onDBchange() shareCardState %s", new Object[]{Integer.valueOf(((ShareCardInfo) this.kcX).field_status)});
            } else if (this.kcX.aeO()) {
                w.e("MicroMsg.CardConsumedMgr", "onDBchange() mCardInfo is ShareCard, but not the ShareCardInfo instance!");
            }
            if (sH.afj().status != r2) {
                afB();
                if (this.kcX.aeO() && !this.kcY && sH.afj().status == 1) {
                    w.i("MicroMsg.CardConsumedMgr", "onDBchange(), need to get the consumedinfo , don't finish UI!");
                    Boolean bool = (Boolean) this.kcV.get(this.kcX.afm());
                    if (bool == null || !bool.booleanValue()) {
                        w.i("MicroMsg.CardConsumedMgr", "consumed is null or consumed is false!");
                        long currentTimeMillis = System.currentTimeMillis();
                        Context context = (Context) this.aeF.get();
                        w.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.kcX.afm());
                        com.tencent.mm.plugin.card.sharecard.a.b.a(context, this.kcX);
                        this.kcV.put(this.kcX.afm(), Boolean.valueOf(true));
                        long currentTimeMillis2 = System.currentTimeMillis();
                        ArrayList arrayList = new ArrayList();
                        IDKey iDKey = new IDKey();
                        iDKey.SetID(281);
                        iDKey.SetKey(30);
                        iDKey.SetValue(1);
                        IDKey iDKey2 = new IDKey();
                        iDKey2.SetID(281);
                        iDKey2.SetKey(31);
                        iDKey2.SetValue((int) (currentTimeMillis2 - currentTimeMillis));
                        arrayList.add(iDKey);
                        arrayList.add(iDKey2);
                        g.oUh.b(arrayList, true);
                    } else {
                        w.i("MicroMsg.CardConsumedMgr", "consumed:" + bool.booleanValue());
                    }
                    afD();
                } else if (this.kcX.aeO() && this.kcY) {
                    w.i("MicroMsg.CardConsumedMgr", "onDBchange(), is getting the consumedinfo!");
                } else {
                    w.i("MicroMsg.CardConsumedMgr", "onDBchange(),finish CardConsumeCodeUI!");
                    afC();
                }
                w.i("MicroMsg.CardConsumedMgr", "onDBchange(),card coupon is consumde success!");
            }
            this.kcX = sH;
            e(this.kcX);
        }
    }

    public final void adZ() {
        afB();
    }

    public final void a(com.tencent.mm.plugin.card.model.g gVar) {
        w.i("MicroMsg.CardConsumedMgr", "onChange()");
        w.i("MicroMsg.CardConsumedMgr", "card msg card id is " + gVar.field_card_id);
        if (this.kcX == null) {
            w.e("MicroMsg.CardConsumedMgr", "onChange(), do nothing, mCardInfo == null");
            afC();
            return;
        }
        w.i("MicroMsg.CardConsumedMgr", "card msg card id is " + gVar.field_card_id);
        if (this.kcX.aeN() && gVar.field_card_id != null && gVar.field_card_id.equals(this.kcX.afm()) && gVar.kfl == 3) {
            w.i("MicroMsg.CardConsumedMgr", "it is card type, don't do NetSceneGetShareCardConsumedInfo! finish UI");
            afC();
        } else if (!this.kcX.aeO()) {
            w.i("MicroMsg.CardConsumedMgr", "it is not card type, don't update share card data!");
            afC();
        } else if (gVar.kfl == 3 || !(gVar.field_card_id == null || !gVar.field_card_id.equals(this.kcX.afm()) || TextUtils.isEmpty(gVar.field_consumed_box_id))) {
            long currentTimeMillis = System.currentTimeMillis();
            w.i("MicroMsg.CardConsumedMgr", "consumed share card msg,  update share card data!");
            it afj;
            if (gVar.field_card_id != null && gVar.field_card_id.equals(this.kcX.afm())) {
                b sH = al.agi().sH(this.kcX.afm());
                if (!(sH == null || sH.afj() == null)) {
                    int i = this.kcX.afj().status;
                    w.d("MicroMsg.CardConsumedMgr", "onChange() current oldState %s, newStatus %s, shareCardStatus %s", new Object[]{Integer.valueOf(i), Integer.valueOf(sH.afj().status), Integer.valueOf(((ShareCardInfo) this.kcX).field_status)});
                    if (sH.afj().status != i) {
                        afB();
                    } else if (i != 1) {
                        w.i("MicroMsg.CardConsumedMgr", "share card oldState status is " + i);
                        afj = this.kcX.afj();
                        afj.status = 1;
                        ((ShareCardInfo) this.kcX).field_status = 1;
                        this.kcX.a(afj);
                        l.j(this.kcX);
                    }
                }
            } else if (gVar.field_card_id != null) {
                b sH2 = al.agi().sH(gVar.field_card_id);
                if (sH2 == null || sH2.afj() == null) {
                    w.w("MicroMsg.CardConsumedMgr", "tempCard is null");
                } else {
                    w.d("MicroMsg.CardConsumedMgr", "onChange() not current oldState %s,shareCardStatus %s", new Object[]{Integer.valueOf(sH2.afj().status), Integer.valueOf(sH2.field_status)});
                    if (sH2.afj().status != 1) {
                        afj = sH2.afj();
                        afj.status = 1;
                        sH2.field_status = 1;
                        sH2.a(afj);
                        l.j(sH2);
                    }
                }
            }
            e(this.kcX);
            Boolean bool = (Boolean) this.kcV.get(this.kcX.afm());
            if (bool == null || !bool.booleanValue()) {
                Context context = (Context) this.aeF.get();
                w.i("MicroMsg.CardConsumedMgr", "consume share card, card id is " + this.kcX.afm());
                com.tencent.mm.plugin.card.sharecard.a.b.a(context, this.kcX);
                this.kcV.put(this.kcX.afm(), Boolean.valueOf(true));
                long currentTimeMillis2 = System.currentTimeMillis();
                ArrayList arrayList = new ArrayList();
                IDKey iDKey = new IDKey();
                iDKey.SetID(281);
                iDKey.SetKey(30);
                iDKey.SetValue(1);
                IDKey iDKey2 = new IDKey();
                iDKey2.SetID(281);
                iDKey2.SetKey(31);
                iDKey2.SetValue((int) (currentTimeMillis2 - currentTimeMillis));
                arrayList.add(iDKey);
                arrayList.add(iDKey2);
                g.oUh.b(arrayList, true);
            } else {
                w.i("MicroMsg.CardConsumedMgr", "consumed:" + bool.booleanValue());
            }
            afD();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.CardConsumedMgr", "onSceneEnd, errType = " + i + " errCode = " + i2);
        if (i == 0 && i2 == 0) {
            if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) {
                com.tencent.mm.plugin.card.sharecard.model.d dVar = (com.tencent.mm.plugin.card.sharecard.model.d) kVar;
                if (TextUtils.isEmpty(dVar.kfG)) {
                    w.e("MicroMsg.CardConsumedMgr", "consumed return json is empty!");
                } else {
                    si(dVar.kfG);
                }
                this.kcY = false;
                w.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo ok! finish UI!");
                afC();
            }
        } else if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) {
            this.kcY = false;
            w.e("MicroMsg.CardConsumedMgr", "do NetSceneGetShareCardConsumedInfo failed! finish UI!");
            afC();
        }
    }

    private void si(String str) {
        w.i("MicroMsg.CardConsumedMgr", "startConsumedSuccUI()");
        if (this.kcI != null) {
            int i = 0;
            boolean z = false;
            while (i < this.kcI.size()) {
                boolean z2;
                WeakReference weakReference = (WeakReference) this.kcI.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    Boolean bool = (Boolean) this.kcU.get(aVar);
                    if (!(aVar == null || bool == null || !bool.booleanValue())) {
                        aVar.sj(str);
                        z2 = true;
                        i++;
                        z = z2;
                    }
                }
                z2 = z;
                i++;
                z = z2;
            }
            Boolean bool2 = (Boolean) this.kcV.get(this.kcX.afm());
            if (z) {
                w.i("MicroMsg.CardConsumedMgr", "onStartConsumedSuccUI is handled!");
                this.kcZ = "";
            } else if (bool2 != null && bool2.booleanValue()) {
                w.i("MicroMsg.CardConsumedMgr", "add to launch pending list!");
                this.kcZ = str;
                this.kcW.put(this.kcX.afm(), Boolean.valueOf(true));
            }
        }
    }

    private void e(b bVar) {
        w.i("MicroMsg.CardConsumedMgr", "doUpdateCardInfo()");
        if (this.kcI != null) {
            for (int i = 0; i < this.kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kcI.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.f(bVar);
                    }
                }
            }
        }
    }

    private void afB() {
        w.i("MicroMsg.CardConsumedMgr", "doVibrate()");
        if (this.kcI != null) {
            for (int i = 0; i < this.kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kcI.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.afF();
                    }
                }
            }
        }
    }

    private void afC() {
        w.i("MicroMsg.CardConsumedMgr", "doFinishUI()");
        if (this.kcI != null) {
            for (int i = 0; i < this.kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kcI.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.afG();
                    }
                }
            }
        }
    }

    private void afD() {
        w.i("MicroMsg.CardConsumedMgr", "needDoConsumedInfo(), need to do NetSceneGetShareCardConsumedInfo. ");
        afE();
    }

    private synchronized void afE() {
        if (this.kcY) {
            w.i("MicroMsg.CardConsumedMgr", "isDoingConsumedInfo is true, is doing NetSceneGetShareCardConsumedInfo. return");
        } else {
            w.i("MicroMsg.CardConsumedMgr", "isDoingConsumedInfo is false, do NetSceneGetShareCardConsumedInfo. ");
            this.kcY = true;
            ap.vd().a(new com.tencent.mm.plugin.card.sharecard.model.d(this.kcX.afm(), "", ""), 0);
        }
    }
}
