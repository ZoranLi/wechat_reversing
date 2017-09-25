package com.tencent.mm.plugin.card.a;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.ac;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class c implements e {
    List<WeakReference<a>> kcI = new ArrayList();
    public String kcJ = "";
    public LinkedList<String> kcK = new LinkedList();
    public int kcL;
    private int kcM;
    private int kcN;
    private int kcO;
    private int kcP = 60;
    private boolean kcQ = false;
    private aj kcR = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ c kcT;

        {
            this.kcT = r1;
        }

        public final boolean oQ() {
            w.i("MicroMsg.CardCodeMgr", "onTimerExpired, do request code");
            this.kcT.sh(this.kcT.kcJ);
            this.kcT.afw();
            return true;
        }
    }, false);
    private aj kcS = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ c kcT;

        {
            this.kcT = r1;
        }

        public final boolean oQ() {
            w.i("MicroMsg.CardCodeMgr", "onTimerExpired, do refresh code one minute");
            c cVar = this.kcT;
            w.i("MicroMsg.CardCodeMgr", "onCodeChange()");
            if (cVar.kcI != null) {
                for (int i = 0; i < cVar.kcI.size(); i++) {
                    WeakReference weakReference = (WeakReference) cVar.kcI.get(i);
                    if (weakReference != null) {
                        a aVar = (a) weakReference.get();
                        if (aVar != null) {
                            aVar.afA();
                        }
                    }
                }
            }
            this.kcT.afy();
            return true;
        }
    }, false);

    public interface a {
        void afA();

        void onSuccess();

        void sg(String str);
    }

    public final void release() {
        ap.vd().b(577, this);
        this.kcK.clear();
        this.kcQ = false;
        this.kcJ = "";
        this.kcL = 0;
        this.kcM = 0;
        this.kcN = 0;
        this.kcO = 0;
        afx();
        afz();
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

    private void onSuccess() {
        w.i("MicroMsg.CardCodeMgr", "onSuccess()");
        if (this.kcI != null) {
            for (int i = 0; i < this.kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kcI.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.onSuccess();
                    }
                }
            }
        }
    }

    private void sg(String str) {
        w.i("MicroMsg.CardCodeMgr", "onFail()");
        if (this.kcI != null) {
            for (int i = 0; i < this.kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) this.kcI.get(i);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.sg(str);
                    }
                }
            }
        }
    }

    public final String getCode() {
        if (this.kcK == null || this.kcK.size() == 0) {
            w.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
            return "";
        } else if (this.kcL >= this.kcK.size()) {
            w.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
            sh(this.kcJ);
            return "";
        } else {
            if (this.kcN >= this.kcK.size() - this.kcL) {
                w.i("MicroMsg.CardCodeMgr", "do request code, because the request_count >= than (codes.size() - show_count)");
                sh(this.kcJ);
            }
            w.i("MicroMsg.CardCodeMgr", "getCode, show_count:" + this.kcL + " request_count:" + this.kcN + " codes size:" + this.kcK.size());
            LinkedList linkedList = this.kcK;
            int i = this.kcL;
            this.kcL = i + 1;
            return (String) linkedList.get(i);
        }
    }

    public final boolean isEmpty() {
        if (this.kcK == null || this.kcK.size() == 0) {
            w.e("MicroMsg.CardCodeMgr", "getCode, codes is empty");
            return true;
        } else if (this.kcL < this.kcK.size()) {
            return false;
        } else {
            w.e("MicroMsg.CardCodeMgr", "getCode, all codes has show! ");
            return true;
        }
    }

    public final void sh(String str) {
        if (this.kcQ) {
            w.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), is doing get codes");
        } else if (TextUtils.isEmpty(str)) {
            w.e("MicroMsg.CardCodeMgr", "doGetCardCodes(), mCardId is empty!");
        } else {
            w.i("MicroMsg.CardCodeMgr", "doGetCardCodes() do get codes, card id " + str);
            this.kcQ = true;
            this.kcJ = str;
            ap.vd().a(new ac(this.kcJ), 0);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.CardCodeMgr", "onSceneEnd, errType = " + i + " errCode = " + i2);
        if (i == 0 && i2 == 0) {
            if (kVar instanceof ac) {
                this.kcQ = false;
                w.e("MicroMsg.CardCodeMgr", "get codes success for card id " + this.kcJ);
                ac acVar = (ac) kVar;
                this.kcM = acVar.kcM;
                this.kcN = acVar.kcN;
                this.kcO = acVar.kcO;
                if (acVar.kcK != null) {
                    this.kcK.clear();
                    this.kcK.addAll(acVar.kcK);
                    this.kcL = 0;
                }
                onSuccess();
                afw();
                if (this.kcO != 0) {
                    afy();
                }
            }
        } else if (kVar instanceof ac) {
            this.kcQ = false;
            w.e("MicroMsg.CardCodeMgr", "get codes failed  for card id " + this.kcJ);
            sg(str);
        }
    }

    public final void afw() {
        afx();
        w.i("MicroMsg.CardCodeMgr", "startRequestCodeTimer() request_time:" + this.kcM);
        if (this.kcM <= 0 || TextUtils.isEmpty(this.kcJ)) {
            w.e("MicroMsg.CardCodeMgr", "not to start request code timer!");
            return;
        }
        long j = (long) (this.kcM * 1000);
        this.kcR.v(j, j);
        w.i("MicroMsg.CardCodeMgr", "start request code timer!");
    }

    private void afx() {
        w.i("MicroMsg.CardCodeMgr", "stopRequestCodeTimer!");
        if (!this.kcR.bJq()) {
            this.kcR.KH();
        }
    }

    public final void afy() {
        afz();
        w.i("MicroMsg.CardCodeMgr", "startRefreshCodeTimer() refresh_interval:" + this.kcO);
        if (this.kcO > 0) {
            long j = (long) (this.kcO * 1000);
            this.kcS.v(j, j);
            w.i("MicroMsg.CardCodeMgr", "start refresh code timer!");
            return;
        }
        j = (long) (this.kcP * 1000);
        this.kcS.v(j, j);
        w.e("MicroMsg.CardCodeMgr", "not to start refresh code timer!");
    }

    public final void afz() {
        w.i("MicroMsg.CardCodeMgr", "stopRefreshCodeTimer()!");
        if (!this.kcS.bJq()) {
            this.kcS.KH();
        }
    }
}
