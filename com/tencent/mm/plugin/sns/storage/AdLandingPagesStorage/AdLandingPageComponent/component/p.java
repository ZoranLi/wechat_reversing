package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import org.json.JSONArray;
import org.json.JSONObject;

public final class p extends a {
    private h qhT;
    LinearLayout qjc;

    public p(Context context, o oVar, ViewGroup viewGroup) {
        super(context, oVar, viewGroup);
    }

    public final void bfP() {
        super.bfP();
        for (i bfP : this.qhT.bgQ()) {
            bfP.bfP();
        }
    }

    public final void N(int i, int i2, int i3) {
        super.N(i, i2, i3);
        for (i N : this.qhT.bgQ()) {
            N.N(i, i2, i3);
        }
    }

    public final void bfQ() {
        super.bfQ();
        for (i bfQ : this.qhT.bgQ()) {
            bfQ.bfQ();
        }
    }

    public final void bfO() {
        super.bfO();
        for (i bfO : this.qhT.bgQ()) {
            bfO.bfO();
        }
    }

    protected final void bgl() {
        if (((o) this.qib).qfH == 0) {
            this.qjc.setOrientation(1);
        } else if (((o) this.qib).qfH == 1) {
            this.qjc.setOrientation(0);
        }
        if (this.qhT == null) {
            this.qhT = new h(((o) this.qib).qfG, this.context, ((o) this.qib).bgColor, this.qjc);
            this.qhT.layout();
            return;
        }
        this.qhT.bt(((o) this.qib).qfG);
    }

    public final View bgf() {
        View view = this.ipu;
        this.qjc = (LinearLayout) view.findViewById(f.pEd);
        return view;
    }

    protected final int aTQ() {
        return g.pHb;
    }

    public final boolean q(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        if (super.J(jSONObject)) {
            jSONArray.put(jSONObject);
        }
        for (i iVar : this.qhT.bgQ()) {
            JSONObject jSONObject2 = new JSONObject();
            if (iVar != null && iVar.J(jSONObject2)) {
                jSONArray.put(jSONObject2);
            }
        }
        return true;
    }
}
