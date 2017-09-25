package com.tencent.mm.plugin.luckymoney.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.wallet_core.d.b;
import com.tencent.mm.wallet_core.d.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class i implements b, e {
    private String gWO;
    public p irJ = null;
    public HashSet<k> isY = new HashSet();
    public HashSet<k> isZ = new HashSet();
    private Set<Integer> ito = new HashSet();
    private Context mContext;
    private c nmQ = null;

    public i(Context context, c cVar) {
        this.mContext = context;
        this.nmQ = cVar;
    }

    public final void a(k kVar, boolean z) {
        j(kVar);
        this.isY.add(kVar);
        if (z && (this.irJ == null || !(this.irJ == null || this.irJ.isShowing()))) {
            if (this.irJ != null) {
                this.irJ.dismiss();
            }
            this.irJ = g.a(this.mContext, this.mContext.getString(R.l.cbS), false, new OnCancelListener(this) {
                final /* synthetic */ i nmR;

                {
                    this.nmR = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.nmR.aHT();
                }
            });
        }
        ap.vd().a(kVar, 0);
    }

    public final void b(k kVar, boolean z) {
        w.d("MicroMsg.WalletNetSceneMgr", "isShowProgress " + z);
        j(kVar);
        this.isZ.add(kVar);
        if (z && (this.irJ == null || !(this.irJ == null || this.irJ.isShowing()))) {
            if (this.irJ != null) {
                this.irJ.dismiss();
            }
            this.irJ = g.a(this.mContext, this.mContext.getString(R.l.cbS), true, new OnCancelListener(this) {
                final /* synthetic */ i nmR;

                {
                    this.nmR = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.nmR.irJ != null && this.nmR.isY.isEmpty()) {
                        this.nmR.irJ.dismiss();
                        Iterator it = this.nmR.isZ.iterator();
                        while (it.hasNext()) {
                            ap.vd().c((k) it.next());
                        }
                        this.nmR.isZ.clear();
                    }
                }
            });
        }
        ap.vd().a(kVar, 0);
    }

    public final void aHT() {
        if (this.irJ != null) {
            this.irJ.dismiss();
            this.irJ = null;
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

    public final void a(int i, int i2, String str, k kVar) {
        Object obj;
        boolean z;
        if (this.isZ.contains(kVar)) {
            this.isZ.remove(kVar);
            w.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
            obj = 1;
        } else if (this.isY.contains(kVar)) {
            this.isY.remove(kVar);
            w.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
            int i3 = 1;
        } else {
            obj = null;
        }
        if (this.isZ.isEmpty() && this.isY.isEmpty()) {
            if (this.irJ != null) {
                this.irJ.dismiss();
                this.irJ = null;
            }
            z = true;
        } else {
            z = false;
        }
        if (obj != null && this.nmQ != null) {
            this.nmQ.b(i, i2, str, kVar, z);
        }
    }

    public final boolean aHU() {
        if (this.isZ.isEmpty() && this.isY.isEmpty()) {
            return false;
        }
        return true;
    }

    private void j(k kVar) {
        if (kVar != null && (kVar instanceof com.tencent.mm.wallet_core.c.k)) {
            ((com.tencent.mm.wallet_core.c.k) kVar).gWO = this.gWO;
        }
    }

    public final void aHV() {
        if (this.irJ != null && this.irJ.isShowing()) {
            this.irJ.dismiss();
        }
    }
}
