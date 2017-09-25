package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bb.d;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;

public final class g extends b {
    private LinearLayout lJu;
    private ImageView qhM;
    private TextView qhN;
    private LinearLayout qhO;
    int qhP;
    public com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g qhW;
    private View qhX;
    private ImageView qhY;

    public g(Context context, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g gVar, ViewGroup viewGroup) {
        super(context, gVar, viewGroup);
        this.qhW = gVar;
    }

    public final View bgf() {
        View view = this.ipu;
        this.qhY = (ImageView) view.findViewById(f.pCY);
        this.qhM = (ImageView) view.findViewById(f.pAg);
        this.qhN = (TextView) view.findViewById(f.bHZ);
        this.qhO = (LinearLayout) view.findViewById(f.pCT);
        this.lJu = (LinearLayout) view.findViewById(f.bGr);
        this.qhX = this.qhO;
        return this.ipu;
    }

    protected final void bgl() {
        this.qhN.setText(this.qhW.qfj.naQ);
        if (this.qhW.qfQ) {
            this.qhY.setImageDrawable(a.a(this.context, e.pzK));
            this.qhM.setImageDrawable(a.a(this.context, e.pAh));
            this.qhN.setTextColor(WebView.NIGHT_MODE_COLOR);
            this.qhO.setBackgroundResource(e.pzr);
        } else {
            this.qhY.setImageDrawable(a.a(this.context, e.pzJ));
            this.qhM.setImageDrawable(a.a(this.context, e.pAg));
            this.qhN.setTextColor(-1);
            this.qhO.setBackgroundResource(e.pzs);
        }
        this.qhO.setPadding((int) this.qhW.qfM, 0, (int) this.qhW.qfN, 0);
        this.lJu.setPadding(0, (int) this.qhW.qfK, 0, (int) this.qhW.qfL);
        a(this.qhO);
        OnClickListener anonymousClass1 = new OnClickListener(this) {
            final /* synthetic */ g qhZ;

            {
                this.qhZ = r1;
            }

            public final void onClick(View view) {
                g gVar = this.qhZ;
                gVar.qhP++;
                Intent intent = new Intent();
                intent.putExtra("map_view_type", 1);
                intent.putExtra("kwebmap_slat", this.qhZ.qhW.qfj.naO);
                intent.putExtra("kwebmap_lng", this.qhZ.qhW.qfj.naP);
                intent.putExtra("kwebmap_scale", this.qhZ.qhW.qfj.fOd);
                intent.putExtra("kPoiName", this.qhZ.qhW.qfj.fRX);
                intent.putExtra("Kwebmap_locaion", this.qhZ.qhW.qfj.naQ);
                w.i("AdLandingBorderedComp", "locatint to slat " + this.qhZ.qhW.qfj.naO + ", slong " + this.qhZ.qhW.qfj.naP + ", " + this.qhZ.qhW.qfj.fRX);
                d.b(this.qhZ.context, "location", ".ui.RedirectUI", intent, 2);
            }
        };
        if (this.qhX != null) {
            this.qhX.setOnClickListener(anonymousClass1);
        }
    }

    protected final int aTQ() {
        return com.tencent.mm.plugin.sns.i.g.pHa;
    }

    public final boolean J(JSONObject jSONObject) {
        if (!super.J(jSONObject)) {
            return false;
        }
        try {
            jSONObject.put("clickCount", this.qhP);
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("AdLandingBorderedComp", e, "", new Object[0]);
            return false;
        }
    }
}
