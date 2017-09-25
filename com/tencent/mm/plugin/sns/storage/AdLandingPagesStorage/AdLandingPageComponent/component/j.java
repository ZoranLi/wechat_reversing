package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public abstract class j extends a {
    int qhP = 0;

    public j(Context context, p pVar, ViewGroup viewGroup) {
        super(context, pVar, viewGroup);
    }

    protected final void bgr() {
        this.qhP++;
    }

    public final boolean J(JSONObject jSONObject) {
        if (!super.J(jSONObject)) {
            return false;
        }
        try {
            jSONObject.put("clickCount", this.qhP);
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Sns.AdLandingPageBtnBaseComp", e, "", new Object[0]);
            return false;
        }
    }
}
