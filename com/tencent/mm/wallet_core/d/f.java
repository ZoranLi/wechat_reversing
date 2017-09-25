package com.tencent.mm.wallet_core.d;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.wallet_core.f.a.h;
import com.tencent.mm.wallet_core.f.a.i;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class f implements b, e {
    public String gWO;
    public HashSet<k> isY = new HashSet();
    public HashSet<k> isZ = new HashSet();
    public Dialog ita = null;
    private Set<Integer> ito = new HashSet();
    public Context mContext;
    private c nmQ = null;
    public Bundle uT;
    private a wEz;

    public f(Context context, c cVar) {
        this.mContext = context;
        this.nmQ = cVar;
        this.wEz = new a(this);
    }

    public final void a(k kVar, boolean z) {
        p(kVar);
        this.isY.add(kVar);
        if (z && (this.ita == null || !(this.ita == null || this.ita.isShowing()))) {
            if (this.ita != null) {
                this.ita.dismiss();
            }
            if (this.mContext == null) {
                w.w("MicroMsg.WalletNetSceneMgr", "activity has destroyed!!!");
                return;
            }
            this.ita = g.a(this.mContext, false, new OnCancelListener(this) {
                final /* synthetic */ f wEA;

                {
                    this.wEA = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.wEA.aHT();
                }
            });
        }
        if (r.ijT && (kVar instanceof h) && (((h) kVar).getUri().contains("authen") || ((h) kVar).getUri().contains("verify"))) {
            ((h) kVar).cct();
        }
        ap.vd().a(kVar, 0);
    }

    public final void a(k kVar, boolean z, boolean z2) {
        w.d("MicroMsg.WalletNetSceneMgr", "isShowProgress " + z);
        p(kVar);
        this.isZ.add(kVar);
        if (z && (this.ita == null || !(this.ita == null || this.ita.isShowing()))) {
            if (this.ita != null) {
                this.ita.dismiss();
            }
            if (this.mContext == null) {
                w.w("MicroMsg.WalletNetSceneMgr", "activity has destroyed!!!");
                return;
            } else if (z2) {
                this.ita = g.a(this.mContext, false, new OnCancelListener(this) {
                    final /* synthetic */ f wEA;

                    {
                        this.wEA = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        if (this.wEA.ita != null && this.wEA.isY.isEmpty()) {
                            this.wEA.ita.dismiss();
                            Iterator it = this.wEA.isZ.iterator();
                            while (it.hasNext()) {
                                ap.vd().c((k) it.next());
                            }
                            this.wEA.isZ.clear();
                        }
                    }
                });
            } else {
                this.ita = g.a(this.mContext, this.mContext.getString(R.l.fiG), false, new OnCancelListener(this) {
                    final /* synthetic */ f wEA;

                    {
                        this.wEA = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        if (this.wEA.ita != null && this.wEA.isY.isEmpty()) {
                            this.wEA.ita.dismiss();
                            Iterator it = this.wEA.isZ.iterator();
                            while (it.hasNext()) {
                                ap.vd().c((k) it.next());
                            }
                            this.wEA.isZ.clear();
                        }
                    }
                });
            }
        }
        ap.vd().a(kVar, 0);
    }

    public final void aHT() {
        if (this.ita != null) {
            this.ita.dismiss();
            this.ita = null;
        }
        Iterator it = this.isY.iterator();
        while (it.hasNext()) {
            ap.vd().c((k) it.next());
        }
        it = this.isZ.iterator();
        while (it.hasNext()) {
            ap.vd().c((k) it.next());
        }
        this.isY.clear();
        this.isZ.clear();
    }

    public final void hn(int i) {
        this.ito.add(Integer.valueOf(i));
        ap.vd().a(i, this);
    }

    public final void ho(int i) {
        ap.vd().b(i, this);
        this.ito.remove(Integer.valueOf(i));
        if (this.ito.isEmpty()) {
            aHT();
            this.nmQ = null;
            this.mContext = null;
        }
    }

    public final void aHV() {
        bsK();
    }

    private boolean k(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.WalletNetSceneMgr", "onSceneEnd scene is " + kVar.toString());
        w.d("MicroMsg.WalletNetSceneMgr", "tofutest: errType: %d, errCode: %d, errMsg: %s, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(r.ijT)});
        i iVar;
        if (r.ijT && (kVar instanceof i) && !((i) kVar).wES && !((i) kVar).bsI()) {
            iVar = (i) kVar;
            w.i("MicroMsg.WalletNetSceneMgr", "test do delay query order");
            this.wEz.b(iVar);
            return true;
        } else if (!(kVar instanceof i) || ((i) kVar).bsI()) {
            return false;
        } else {
            if (((i) kVar).wES) {
                w.i("MicroMsg.WalletNetSceneMgr", "getHasRetried pass");
                return false;
            }
            iVar = (i) kVar;
            w.d("MicroMsg.WalletNetSceneMgr", "shouldRetry, network: %B, server: %B", new Object[]{Boolean.valueOf(!iVar.wEd), Boolean.valueOf(this.wEz.a(iVar))});
            if (!this.wEz.a(iVar) && !r0) {
                return false;
            }
            w.i("MicroMsg.WalletNetSceneMgr", "doing delay order query retry");
            this.wEz.b(iVar);
            return true;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        Object obj;
        boolean z;
        if (this.isZ.contains(kVar)) {
            w.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
            if (k(i, i2, str, kVar)) {
                w.i("MicroMsg.WalletNetSceneMgr", "do delay order query.break off!");
                return;
            }
            w.i("MicroMsg.WalletNetSceneMgr", "Not need delay query order,remove scene");
            this.isZ.remove(kVar);
            obj = 1;
        } else if (this.isY.contains(kVar)) {
            w.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
            if (k(i, i2, str, kVar)) {
                w.i("MicroMsg.WalletNetSceneMgr", "do delay order query.break off!");
                return;
            }
            this.isY.remove(kVar);
            w.i("MicroMsg.WalletNetSceneMgr", "Not need delay query order,remove scene");
            int i3 = 1;
        } else {
            obj = null;
        }
        if (this.isZ.isEmpty() && this.isY.isEmpty()) {
            bsK();
            z = true;
        } else {
            z = false;
        }
        if (obj != null && this.nmQ != null) {
            this.nmQ.b(i, i2, str, kVar, z);
        }
    }

    public final void bsK() {
        if (this.ita != null) {
            this.ita.dismiss();
            this.ita = null;
        }
    }

    public final boolean aHU() {
        if (this.isZ.isEmpty() && this.isY.isEmpty()) {
            return false;
        }
        return true;
    }

    private void p(k kVar) {
        if (kVar != null && (kVar instanceof com.tencent.mm.wallet_core.c.k)) {
            ((com.tencent.mm.wallet_core.c.k) kVar).gWO = this.gWO;
            if (this.uT != null) {
                ((com.tencent.mm.wallet_core.c.k) kVar).uT = this.uT;
            } else if (this.mContext instanceof WalletBaseUI) {
                ((com.tencent.mm.wallet_core.c.k) kVar).uT = ((WalletBaseUI) this.mContext).uT;
            }
        }
    }
}
