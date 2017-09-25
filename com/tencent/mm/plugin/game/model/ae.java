package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.c.ac;
import com.tencent.mm.plugin.game.c.ad;
import com.tencent.mm.plugin.game.c.ao;
import com.tencent.mm.plugin.game.c.bi;
import com.tencent.mm.plugin.game.c.bk;
import com.tencent.mm.plugin.game.c.br;
import com.tencent.mm.plugin.game.c.s;
import com.tencent.mm.plugin.game.c.x;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class ae extends aa {
    public ao mri;
    private boolean mrj;
    public LinkedList<c> mrk;
    public HashMap<String, Integer> mrl;
    public a mrm;

    public static class a {
        public LinkedList<a> mrn = new LinkedList();
        public br mro;

        public static class a {
            public c mrp;
            public LinkedList<x> mrq;
        }
    }

    public ae(com.tencent.mm.bd.a aVar) {
        this.mrl = new HashMap();
        if (aVar == null) {
            this.mri = new ao();
            return;
        }
        this.mri = (ao) aVar;
        this.mrj = true;
        Oe();
    }

    public ae(byte[] bArr) {
        this.mrl = new HashMap();
        this.mri = new ao();
        if (bArr != null && bArr.length != 0) {
            try {
                this.mri.aD(bArr);
            } catch (IOException e) {
                w.e("MicroMsg.GamePBDataIndex", "Parsing Failed: %s", new Object[]{e.getMessage()});
            }
            this.mrj = false;
            Oe();
        }
    }

    private void Oe() {
        LinkedList linkedList;
        LinkedList linkedList2 = new LinkedList();
        if (this.mri.muk == null || this.mri.muk.msJ == null) {
            linkedList = linkedList2;
        } else {
            Iterator it = this.mri.muk.msJ.iterator();
            int i = 1;
            while (it.hasNext()) {
                ac acVar = (ac) it.next();
                if (acVar.msc != null) {
                    c a = aa.a(acVar.msc);
                    if (a != null) {
                        if (acVar.msc.msw == null) {
                            a.moQ = ai.xR(acVar.msG);
                        } else if (acVar.msc.msw.msj == null || acVar.msc.msw.mvi == null) {
                            a.moQ = ai.xR(acVar.msG);
                        } else {
                            a.moM = acVar.msc.msw.msj;
                            a.moN = acVar.msc.msw.mvi;
                            a.moQ = ai.H(acVar.msG, "label", a.moM);
                        }
                        if (acVar.mtA != null) {
                            Iterator it2 = acVar.mtA.iterator();
                            while (it2.hasNext()) {
                                ad adVar = (ad) it2.next();
                                if (adVar != null) {
                                    if (adVar.mtB == null || adVar.mtB.size() == 0) {
                                        a.moH.add("");
                                    } else {
                                        StringBuilder stringBuilder = new StringBuilder();
                                        for (int i2 = 0; i2 < adVar.mtB.size(); i2++) {
                                            ap.yY();
                                            com.tencent.mm.storage.x Rc = c.wR().Rc((String) adVar.mtB.get(i2));
                                            if (Rc == null || Rc.gTQ == 0) {
                                                stringBuilder.append((String) adVar.mtB.get(i2));
                                            } else {
                                                stringBuilder.append(Rc.tL());
                                            }
                                            if (i2 < adVar.mtB.size() - 1) {
                                                stringBuilder.append("、");
                                            }
                                        }
                                        stringBuilder.append(" ");
                                        a.moH.add(stringBuilder.toString());
                                    }
                                    a.moH.add(adVar.mtg);
                                }
                            }
                        }
                        a.scene = 10;
                        a.fTL = MMBitmapFactory.ERROR_BEGIN_SAMPLE_FAILED;
                        int i3 = i + 1;
                        a.position = i;
                        linkedList2.add(a);
                        i = i3;
                    }
                }
            }
            linkedList = linkedList2;
        }
        this.mrk = linkedList;
        this.mrm = aBm();
        if (this.mrj) {
            d.U(this.mrk);
            if (!(this.mrm == null || bg.bV(this.mrm.mrn))) {
                LinkedList linkedList3 = new LinkedList();
                Iterator it3 = this.mrm.mrn.iterator();
                while (it3.hasNext()) {
                    linkedList3.add(((a) it3.next()).mrp);
                }
                d.U(linkedList3);
            }
            aBo();
            SubCoreGameCenter.aBH().init(ab.getContext());
        }
    }

    public final com.tencent.mm.plugin.game.c.ae aBk() {
        return this.mri != null ? this.mri.muj : null;
    }

    public final bi aBl() {
        return this.mri != null ? this.mri.mup : null;
    }

    private a aBm() {
        if (this.mri.mun == null || bg.bV(this.mri.mun.msJ)) {
            return null;
        }
        a aVar = new a();
        Iterator it = this.mri.mun.msJ.iterator();
        int i = 0;
        while (it.hasNext()) {
            s sVar = (s) it.next();
            c a = aa.a(sVar.msc);
            if (a != null) {
                a.moO = sVar.msk;
                a.scene = 10;
                a.fTL = MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED;
                i++;
                a.position = i;
                a aVar2 = new a();
                aVar2.mrp = a;
                aVar2.mrq = sVar.mth;
                aVar.mrn.add(aVar2);
            }
        }
        aVar.mro = this.mri.mun.mtn;
        return aVar;
    }

    public final LinkedList<c> aBn() {
        LinkedList<c> linkedList = new LinkedList();
        if (this.mri.muo == null || this.mri.muo.mve == null) {
            return linkedList;
        }
        Iterator it = this.mri.muo.mve.iterator();
        while (it.hasNext()) {
            bk bkVar = (bk) it.next();
            if (bkVar != null) {
                c a = aa.a(bkVar.msc);
                if (a != null) {
                    a.bF(bkVar.mvg);
                    linkedList.addFirst(a);
                }
            }
        }
        return linkedList;
    }

    private void aBo() {
        this.mrl = new HashMap();
        if (this.mri.muo != null && this.mri.muo.mve != null) {
            Iterator it = this.mri.muo.mve.iterator();
            while (it.hasNext()) {
                bk bkVar = (bk) it.next();
                c a = aa.a(bkVar.msc);
                if (a != null) {
                    this.mrl.put(a.field_appId, Integer.valueOf(a.versionCode));
                    f Me = an.aRr().Me(a.field_appId);
                    if (Me != null) {
                        Me.bF(bkVar.mvg);
                        if (!an.aRr().a(Me, new String[0])) {
                            w.e("MicroMsg.GamePBDataIndex", "Store rank info failed, AppID: %s", new Object[]{Me.field_appId});
                        }
                    }
                }
            }
        }
    }
}
