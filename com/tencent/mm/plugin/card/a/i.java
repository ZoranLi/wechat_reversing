package com.tencent.mm.plugin.card.a;

import android.text.TextUtils;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.card.sharecard.model.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public final class i implements e {
    private List<WeakReference<a>> kcI = new ArrayList();
    public ArrayList<String> kdj = new ArrayList();
    public ArrayList<String> kdk = new ArrayList();
    public ae kdl = new ae();
    public HashMap<String, Runnable> kdm = new LinkedHashMap();

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int hQN;
        final /* synthetic */ String kdn;
        final /* synthetic */ int kdo = 0;
        final /* synthetic */ int kdp = 0;
        final /* synthetic */ i kdq;

        AnonymousClass1(i iVar, String str, int i, int i2, int i3) {
            this.kdq = iVar;
            this.kdn = str;
            this.hQN = i3;
        }

        public final void run() {
            i.d(this.kdn, this.kdo, this.kdp, this.hQN);
            w.i("MicroMsg.CardMarkCodeMgr", "run the unmark task, the card is " + this.kdn + " system.time:" + System.currentTimeMillis());
        }
    }

    public interface a {
        void b(String str, b bVar);

        void bu(String str, String str2);

        void sm(String str);
    }

    public static class b {
        public String kdr;
        public int kds = 0;
        public String kdt;
        public int kdu;
        public String kdv;
    }

    public i() {
        ap.vd().a(907, this);
        this.kdj.clear();
        this.kdk.clear();
        this.kdm.clear();
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

    private void a(String str, b bVar) {
        w.i("MicroMsg.CardMarkCodeMgr", "markSuccess()");
        if (this.kcI != null) {
            if (this.kdj.contains(str) || this.kdk.contains(str)) {
                for (int i = 0; i < this.kcI.size(); i++) {
                    WeakReference weakReference = (WeakReference) this.kcI.get(i);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            if (this.kdj.contains(str)) {
                                aVar.b(str, bVar);
                            } else if (this.kdk.contains(str)) {
                                aVar.sm(str);
                            }
                        }
                    }
                }
                return;
            }
            w.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card id is not in mark list and un mark list.");
        }
    }

    private void bt(String str, String str2) {
        w.i("MicroMsg.CardMarkCodeMgr", "onMarkFail()");
        if (this.kcI != null) {
            if (!this.kdj.contains(str) || this.kdk.contains(str)) {
                w.i("MicroMsg.CardMarkCodeMgr", "markSuccess the card is not in mark list");
                return;
            }
            for (int i = 0; i < this.kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kcI.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.bu(str, str2);
                    }
                }
            }
        }
    }

    private void sk(String str) {
        w.i("MicroMsg.CardMarkCodeMgr", "removeId()");
        if (this.kdj.contains(str) && !this.kdk.contains(str)) {
            this.kdj.remove(str);
            w.i("MicroMsg.CardMarkCodeMgr", "remove mark card id in mMarkList. card is " + str);
        }
        if (!this.kdj.contains(str) && this.kdk.contains(str)) {
            this.kdk.remove(str);
            Runnable runnable = (Runnable) this.kdm.get(str);
            this.kdm.remove(str);
            this.kdl.removeCallbacks(runnable);
            w.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is " + str);
            w.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is " + str);
        }
    }

    private void sl(String str) {
        w.i("MicroMsg.CardMarkCodeMgr", "cancelUnmark()");
        if (this.kdk.contains(str)) {
            this.kdk.remove(str);
            w.i("MicroMsg.CardMarkCodeMgr", "remove unmark card id in mUnMarkList. card is " + str);
        }
        if (this.kdm.containsKey(str)) {
            w.i("MicroMsg.CardMarkCodeMgr", "remove unmark card mask id in mId2Runner. card is " + str);
            Runnable runnable = (Runnable) this.kdm.get(str);
            this.kdm.remove(str);
            this.kdl.removeCallbacks(runnable);
        }
    }

    public final void x(String str, int i, int i2) {
        w.i("MicroMsg.CardMarkCodeMgr", "doMarkCode()");
        sl(str);
        if (!this.kdj.contains(str)) {
            this.kdj.add(str);
        }
        d(str, i, 1, i2);
    }

    public final void aA(String str, int i) {
        w.i("MicroMsg.CardMarkCodeMgr", "doUnmarkCode()");
        sl(str);
        this.kdk.add(str);
        Runnable anonymousClass1 = new AnonymousClass1(this, str, 0, 0, i);
        this.kdl.postDelayed(anonymousClass1, (long) (bg.getInt(g.sW().z("ShareCard", "UnMarkDelay"), 0) * 1000));
        this.kdm.put(str, anonymousClass1);
        w.i("MicroMsg.CardMarkCodeMgr", "add unmark card mask id in mId2Runner. card is " + str + " system.time:" + System.currentTimeMillis());
    }

    public static void d(String str, int i, int i2, int i3) {
        if (TextUtils.isEmpty(str)) {
            w.i("MicroMsg.CardMarkCodeMgr", "card_id is empty, don't call NetSceneMarkShareCard cgi");
            return;
        }
        w.i("MicroMsg.CardMarkCodeMgr", "doMarkNetscene()");
        ap.vd().a(new f(str, i, i2, i3), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, errType = " + i + " errCode = " + i2);
        f fVar;
        if (i == 0 && i2 == 0) {
            if (kVar instanceof f) {
                fVar = (f) kVar;
                b bVar = new b();
                bVar.kdr = fVar.kdr;
                bVar.kds = fVar.kds;
                bVar.kdt = fVar.kdt;
                bVar.kdu = fVar.kdu;
                bVar.kdv = fVar.kdv;
                w.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markSuccess original_card_id = " + fVar.kgY);
                w.i("MicroMsg.CardMarkCodeMgr", "mark_user:" + bVar.kdr + " mark_succ:" + bVar.kds + " mark_card_id:" + bVar.kdt + " expire_time:" + bVar.kdu + " pay_qrcode_wording:" + bVar.kdv);
                a(fVar.kgY, bVar);
                sk(fVar.kgY);
            }
        } else if (kVar instanceof f) {
            fVar = (f) kVar;
            w.i("MicroMsg.CardMarkCodeMgr", "onSceneEnd, markFail original_card_id = " + fVar.kgY);
            bt(fVar.kgY, str);
            sk(fVar.kgY);
        }
    }
}
