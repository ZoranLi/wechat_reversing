package com.tencent.mm.plugin.card.a;

import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.c.iw;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.List;

public final class f {
    public int jZM = 3;
    public b kcX;
    public MMActivity kdb;
    public List<com.tencent.mm.plugin.card.model.b> kdc = new ArrayList();
    public com.tencent.mm.plugin.card.model.b kdd;
    public ArrayList<iw> kde;

    public f(MMActivity mMActivity) {
        this.kdb = mMActivity;
    }

    public final com.tencent.mm.plugin.card.model.b afH() {
        boolean z;
        com.tencent.mm.plugin.card.model.b bVar = new com.tencent.mm.plugin.card.model.b();
        bVar.kdS = 1;
        if (l.kF(this.jZM) || l.kG(this.jZM) || this.jZM == 23) {
            if (!(!this.kcX.isAcceptable() || this.kcX.afi().toE == null || TextUtils.isEmpty(this.kcX.afi().toE.text) || TextUtils.isEmpty(this.kcX.afi().tog))) {
                z = true;
            }
            z = false;
        } else {
            if (!(this.jZM != 6 || !this.kcX.aff() || this.kcX.afi().toE == null || TextUtils.isEmpty(this.kcX.afi().toE.text) || TextUtils.isEmpty(this.kcX.afi().tog))) {
                z = true;
            }
            z = false;
        }
        bVar.kdU = z;
        if (!bVar.kdU && !TextUtils.isEmpty(this.kcX.afi().tox)) {
            bVar.title = this.kcX.afi().tox;
        } else if (o.eU(this.kcX.afi().tog)) {
            bVar.title = getString(R.l.dRq);
            bVar.kdU = false;
        } else {
            bVar.title = getString(R.l.dRp);
            if (this.kcX.afi().toE == null || this.kcX.afi().toE.tAv != 1) {
                bVar.kdV = false;
            } else {
                bVar.kdV = true;
            }
        }
        if (!TextUtils.isEmpty(this.kcX.afi().toz)) {
            bVar.kdH = this.kcX.afi().toz;
        }
        bVar.khk = "";
        bVar.url = "card://jump_service";
        this.kdd = bVar;
        return this.kdd;
    }

    public final String getTitle() {
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(this.kcX.afi().keS)) {
            stringBuilder.append(this.kcX.afi().keS);
        } else if (this.kcX.aeP()) {
            stringBuilder.append(getString(R.l.cWL));
        } else if (this.kcX.aeQ()) {
            stringBuilder.append(getString(R.l.cWr));
        } else if (this.kcX.aeR()) {
            stringBuilder.append(getString(R.l.dQr));
        } else if (this.kcX.aeS()) {
            stringBuilder.append(getString(R.l.dQK));
        } else if (this.kcX.aeT()) {
            stringBuilder.append(getString(R.l.cWF));
        }
        return stringBuilder.toString();
    }

    public final String getString(int i) {
        return this.kdb.getString(i);
    }
}
