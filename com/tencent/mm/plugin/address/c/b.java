package com.tencent.mm.plugin.address.c;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class b implements e {
    public HashSet<k> isY = new HashSet();
    public HashSet<k> isZ = new HashSet();
    public Dialog ita = null;
    private a itn = null;
    private Set<Integer> ito = new HashSet();
    private Context mContext;

    public b(Context context, a aVar) {
        this.mContext = context;
        this.itn = aVar;
    }

    public final void g(k kVar) {
        w.d("MicroMsg.WalletNetSceneMgr", new StringBuilder("isShowProgress true").toString());
        this.isZ.add(kVar);
        if (this.ita == null || !(this.ita == null || this.ita.isShowing())) {
            if (this.ita != null) {
                this.ita.dismiss();
            }
            this.ita = g.a(this.mContext, "", true, new OnCancelListener(this) {
                final /* synthetic */ b itp;

                {
                    this.itp = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.itp.ita != null && this.itp.isY.isEmpty()) {
                        this.itp.ita.dismiss();
                        Iterator it = this.itp.isZ.iterator();
                        while (it.hasNext()) {
                            ap.vd().c((k) it.next());
                        }
                        this.itp.isZ.clear();
                    }
                }
            });
        }
        ap.vd().a(kVar, 0);
    }

    public final void hn(int i) {
        this.ito.add(Integer.valueOf(i));
        ap.vd().a(i, this);
    }

    public final void ho(int i) {
        ap.vd().b(i, this);
        this.ito.remove(Integer.valueOf(i));
        if (this.ito.isEmpty()) {
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
            this.itn = null;
            this.mContext = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        Object obj = 1;
        if (this.isZ.contains(kVar)) {
            this.isZ.remove(kVar);
            w.d("MicroMsg.WalletNetSceneMgr", "has find scene ");
        } else if (this.isY.contains(kVar)) {
            this.isY.remove(kVar);
            w.d("MicroMsg.WalletNetSceneMgr", "has find forcescenes ");
        } else {
            obj = null;
        }
        if (this.isZ.isEmpty() && this.isY.isEmpty() && this.ita != null) {
            this.ita.dismiss();
            this.ita = null;
        }
        if (obj != null && this.itn != null) {
            this.itn.e(i, i2, str, kVar);
        }
    }
}
