package com.tencent.mm.plugin.card.a;

import com.tencent.mm.plugin.card.b.c;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.q;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ae;
import com.tencent.mm.plugin.card.model.ah;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.i;
import com.tencent.mm.plugin.card.model.k;
import com.tencent.mm.protocal.c.aot;
import com.tencent.mm.protocal.c.asl;
import com.tencent.mm.protocal.c.asm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g implements e {
    public List<WeakReference<a>> kcI = new ArrayList();
    public c kdf;
    public int kdg;
    public aj kdh = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ g kdi;

        {
            this.kdi = r1;
        }

        public final boolean oQ() {
            w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onTimerExpired, do refresh code!");
            g gVar = this.kdi;
            w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onShowTimeExpired()");
            if (gVar.kcI != null) {
                for (int i = 0; i < gVar.kcI.size(); i++) {
                    WeakReference weakReference = (WeakReference) gVar.kcI.get(i);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.afI();
                        }
                    }
                }
            }
            return true;
        }
    }, false);

    public interface a {
        void H(int i, String str);

        void afI();

        void b(c cVar);

        void c(c cVar);
    }

    public final void release() {
        this.kdg = 0;
        afz();
        w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "removeNetSceneListener!");
        ap.vd().b(1382, this);
        ap.vd().b(1275, this);
    }

    public final void a(b bVar, q qVar) {
        if (!g(bVar)) {
            w.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode !");
            G(2, "");
        } else if (!l.isNetworkAvailable(ab.getContext())) {
            w.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "isNetworkAvailable false cannot connet network!");
            G(-1, "");
        } else if (this.kdg >= 3) {
            w.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doRequestNetSceneGetDynamicQrcode is  limit requestcount:" + this.kdg + ",cannot request!");
        } else {
            a(bVar.afm(), qVar);
            this.kdg++;
        }
    }

    public final void a(q qVar) {
        w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard! fromScene=%d", new Object[]{Integer.valueOf(qVar.scene)});
        List<CardInfo> afP = al.aga().afP();
        if (afP.isEmpty()) {
            w.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard do update all offileQrcode is failure! is dynamic cardList is empyt!fromScene=%d", new Object[]{Integer.valueOf(qVar.scene)});
            return;
        }
        for (CardInfo cardInfo : afP) {
            if (cardInfo == null) {
                w.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! cardInfo is null fromScene=%d", new Object[]{Integer.valueOf(qVar.scene)});
            } else if (qVar == null) {
                w.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  is failure! fromScene is null!");
            } else {
                w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard  get dynamic code! cardId= %s,fromScene=%d", new Object[]{cardInfo.afm(), Integer.valueOf(qVar.scene)});
                if (g(cardInfo)) {
                    int i;
                    String afm = cardInfo.afm();
                    i ss = al.agp().ss(afm);
                    if (ss == null) {
                        i = 1;
                    } else {
                        List st = al.ago().st(afm);
                        if (st.isEmpty()) {
                            i = 1;
                        } else if (st.size() < ss.field_lower_bound) {
                            this.kdf = c.CARDCODEREFRESHACTION_UPDATECHANGE;
                            i = 1;
                        } else if (a(ss)) {
                            this.kdf = c.CARDCODEREFRESHACTION_UNSHOWN_TIMEOUT;
                            i = 1;
                        } else {
                            i = 0;
                        }
                    }
                    if (i == 0) {
                        w.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "do not need  get qrCode!  cardId =%s,fromScene=%d", new Object[]{cardInfo.afm(), Integer.valueOf(qVar.scene)});
                    } else {
                        w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doUpdateOfflineQrcodeByDynaimicCard doNetSceneGetDynamicQrcode! fromScene=%d", new Object[]{Integer.valueOf(qVar.scene)});
                        a(cardInfo.afm(), qVar);
                    }
                } else {
                    w.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "cannot  get qrCode ! cardId =%s", new Object[]{cardInfo.afm()});
                }
            }
        }
    }

    public final void b(com.tencent.mm.plugin.card.model.g gVar) {
        String str = gVar.field_card_id;
        com.tencent.mm.plugin.card.model.l ago = al.ago();
        List st;
        k sv;
        if (gVar.kfm) {
            st = al.ago().st(str);
            sv = ago.sv(str);
            w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is true! delete all card code data by card_id=%s", new Object[]{str});
            if (ago.gR(str)) {
                if (sv != null) {
                    w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,notify ui to refresh!", new Object[]{str});
                    b(c.CARDCODEREFRESHACTION_BANCODE);
                }
                a(str, st, c.CARDCODEREFRESHACTION_BANCODE);
                return;
            }
            return;
        }
        List<com.tencent.mm.plugin.card.model.g.c> st2 = gVar.kfn;
        if (st2 == null) {
            w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! unavailableQrCodeList is empty, do nothing! card_id=%s", new Object[]{str});
            return;
        }
        w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get msg allUnavailable is false! delete card code data by unavailableQrCodeList, card_id=%s，unavailableQrCodeList size= %d", new Object[]{str, Integer.valueOf(st2.size())});
        sv = ago.sv(str);
        LinkedList linkedList = new LinkedList();
        for (com.tencent.mm.plugin.card.model.g.c cVar : st2) {
            if (al.ago().bv(str, cVar.kfv)) {
                linkedList.add(b(str, cVar.kfv, c.CARDCODEREFRESHACTION_BANCODE));
            }
        }
        if (sv != null) {
            w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code is showing card_id= %s,code_id= %s, notify ui to refresh!", new Object[]{str, sv.field_code_id});
            b(c.CARDCODEREFRESHACTION_BANCODE);
        }
        if (!linkedList.isEmpty()) {
            B(linkedList);
        }
    }

    public static boolean a(i iVar) {
        if (System.currentTimeMillis() - iVar.field_fetch_time <= ((long) (iVar.field_expire_time_interval * 1000))) {
            return false;
        }
        w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "code  expire time is true! currentTime= %s,codeFetchTime=%s,field_expire_time_interval=%s", new Object[]{Long.valueOf(System.currentTimeMillis()), Long.valueOf(iVar.field_fetch_time), Integer.valueOf(iVar.field_expire_time_interval)});
        return true;
    }

    public final void afz() {
        w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "stopRefreshCodeTimer!");
        if (!this.kdh.bJq()) {
            this.kdh.KH();
        }
    }

    private static boolean g(b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.afj() != null && bVar.afj().tnV) {
            return true;
        }
        w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "get cardInfo is_commom_card is false!");
        return false;
    }

    private void a(String str, q qVar) {
        w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneGetDynamicQrcode, cardId:" + str + ",scene :" + (qVar == null ? 0 : qVar.scene));
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        com.tencent.mm.y.k aeVar = new ae(linkedList, qVar == null ? 0 : qVar.scene);
        ap.vd().a(1382, this);
        ap.vd().a(aeVar, 0);
    }

    private void a(String str, List<k> list, c cVar) {
        if (cVar == null) {
            w.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport error! CardCodeRefreshAction is null! cannot report!");
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (k kVar : list) {
            linkedList.add(b(str, kVar.field_code_id, cVar));
        }
        B(linkedList);
    }

    public final void a(String str, String str2, c cVar) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(b(str, str2, cVar));
        w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "doNetSceneReport, operate_list=%d,refreshAction=%d", new Object[]{Integer.valueOf(linkedList.size()), Integer.valueOf(cVar.action)});
        B(linkedList);
    }

    private void B(LinkedList<aot> linkedList) {
        ap.vd().a(1275, this);
        ap.vd().a(new ah(linkedList), 0);
    }

    private static aot b(String str, String str2, c cVar) {
        aot com_tencent_mm_protocal_c_aot = new aot();
        com_tencent_mm_protocal_c_aot.fVl = str;
        com_tencent_mm_protocal_c_aot.kfv = str2;
        com_tencent_mm_protocal_c_aot.tTQ = new Long(System.currentTimeMillis() / 1000).intValue();
        com_tencent_mm_protocal_c_aot.tTR = cVar == null ? -1 : cVar.action;
        return com_tencent_mm_protocal_c_aot;
    }

    private void a(asm com_tencent_mm_protocal_c_asm) {
        if (com_tencent_mm_protocal_c_asm != null) {
            String str = com_tencent_mm_protocal_c_asm.fVl;
            if (al.agp().ss(str) == null) {
                al.agp().b(b(com_tencent_mm_protocal_c_asm));
            } else {
                al.agp().c(b(com_tencent_mm_protocal_c_asm), new String[0]);
            }
            List st = al.ago().st(str);
            if (!(st.isEmpty() || !al.ago().gR(str) || this.kdf == null)) {
                a(str, st, this.kdf);
            }
            Iterator it = com_tencent_mm_protocal_c_asm.tWS.iterator();
            while (it.hasNext()) {
                asl com_tencent_mm_protocal_c_asl = (asl) it.next();
                com.tencent.mm.sdk.e.c kVar = new k();
                kVar.field_card_id = str;
                kVar.field_code_id = com_tencent_mm_protocal_c_asl.kfv;
                kVar.field_code = com.tencent.mm.plugin.card.b.e.bC(str, com_tencent_mm_protocal_c_asl.data);
                al.ago().b(kVar);
            }
        }
    }

    private static i b(asm com_tencent_mm_protocal_c_asm) {
        i iVar = new i();
        iVar.field_card_id = com_tencent_mm_protocal_c_asm.fVl;
        iVar.field_lower_bound = com_tencent_mm_protocal_c_asm.tWN;
        iVar.field_expire_time_interval = com_tencent_mm_protocal_c_asm.tWQ;
        iVar.field_need_insert_show_timestamp = com_tencent_mm_protocal_c_asm.tWO;
        iVar.field_show_expire_interval = com_tencent_mm_protocal_c_asm.tWR;
        iVar.field_show_timestamp_encrypt_key = com_tencent_mm_protocal_c_asm.tWP;
        iVar.field_fetch_time = System.currentTimeMillis();
        return iVar;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, errType = " + i + " errCode = " + i2 + ",NetSceneBase=" + (kVar != null ? kVar.getClass() : ""));
        if (i != 0 || i2 != 0) {
            w.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, errType = " + i + " errCode = " + i2 + " cmd:" + (kVar != null ? kVar.getType() : 0) + "  NetSceneBase=" + (kVar != null ? kVar.getClass() : ""));
            if (kVar instanceof ae) {
                G(i2, str);
                ap.vd().b(1382, this);
                return;
            }
            ap.vd().b(1275, this);
        } else if (kVar instanceof ae) {
            asm com_tencent_mm_protocal_c_asm = ((ae) kVar).kfX;
            if (com_tencent_mm_protocal_c_asm == null) {
                w.e("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSceneEnd, resp  qr_code_item_list is null ");
                return;
            }
            a(com_tencent_mm_protocal_c_asm);
            a(this.kdf);
            ap.vd().b(1382, this);
        } else {
            ap.vd().b(1275, this);
        }
    }

    private void a(c cVar) {
        w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onSuccess()");
        if (this.kcI != null) {
            for (int i = 0; i < this.kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kcI.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.c(cVar);
                    }
                }
            }
        }
    }

    public final void G(int i, String str) {
        w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onFail()");
        if (this.kcI != null) {
            for (int i2 = 0; i2 < this.kcI.size(); i2++) {
                WeakReference weakReference = (WeakReference) this.kcI.get(i2);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.H(i, str);
                    }
                }
            }
        }
    }

    private void b(c cVar) {
        w.i("MicroMsg.CardDynamicQrcodeOfflineMgr", "onReceiveCodeUnavailable()");
        if (this.kcI != null) {
            for (int i = 0; i < this.kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kcI.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.b(cVar);
                    }
                }
            }
        }
    }
}
