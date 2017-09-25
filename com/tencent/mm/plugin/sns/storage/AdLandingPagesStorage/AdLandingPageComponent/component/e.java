package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e extends a {
    private List<i> qfi = new ArrayList();
    private com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e qhS;
    private h qhT;

    public e(Context context, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e eVar, ViewGroup viewGroup) {
        super(context, eVar, viewGroup);
        this.qhS = eVar;
    }

    protected final void bgl() {
        if (this.qhT == null) {
            this.qhT = new h(this.qhS.qfi, this.context, 0, (FrameLayout) this.ipu);
            this.qhT.layout();
            return;
        }
        this.qhT.bt(this.qhS.qfi);
    }

    protected final View bgm() {
        return new FrameLayout(this.context);
    }

    public final void bfP() {
        super.bfP();
        for (i bfP : this.qfi) {
            bfP.bfP();
        }
    }

    public final void bfQ() {
        super.bfQ();
        for (i bfQ : this.qfi) {
            bfQ.bfQ();
        }
    }

    public final void N(int i, int i2, int i3) {
        super.N(i, i2, i3);
        for (i N : this.qfi) {
            N.N(i, i2, i3);
        }
    }

    public final void bfO() {
        super.bfO();
        for (i bfO : this.qfi) {
            bfO.bfO();
        }
    }

    public final boolean q(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        if (super.J(jSONObject)) {
            jSONArray.put(jSONObject);
        }
        for (i iVar : this.qfi) {
            JSONObject jSONObject2 = new JSONObject();
            if (iVar != null && iVar.J(jSONObject2)) {
                jSONArray.put(jSONObject2);
            }
        }
        return true;
    }
}
