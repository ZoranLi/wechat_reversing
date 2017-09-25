package com.tencent.mm.plugin.address.b.b;

import android.app.Dialog;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashSet;

public final class a implements e {
    public HashSet<k> isY;
    public HashSet<k> isZ;
    public Dialog ita;

    public final void a(int i, int i2, String str, k kVar) {
        if (this.isZ.contains(kVar)) {
            this.isZ.remove(kVar);
            w.d("MicroMsg.InvoiceNetSceneMgr", "has find scene ");
        } else if (this.isY.contains(kVar)) {
            this.isY.remove(kVar);
            w.d("MicroMsg.InvoiceNetSceneMgr", "has find forcescenes ");
        }
        if (this.isZ.isEmpty() && this.isY.isEmpty() && this.ita != null) {
            this.ita.dismiss();
            this.ita = null;
        }
    }
}
