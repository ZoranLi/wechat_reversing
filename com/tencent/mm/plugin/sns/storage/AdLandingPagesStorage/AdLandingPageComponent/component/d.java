package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.pluginsdk.ui.d.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONObject;

public final class d extends b {
    LinearLayout lJu;
    private ImageView qhL;
    private ImageView qhM;
    private TextView qhN;
    LinearLayout qhO;
    int qhP;

    public d(Context context, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d dVar, ViewGroup viewGroup) {
        super(context, dVar, viewGroup);
    }

    public final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d bgk() {
        return (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.qib;
    }

    protected final int aTQ() {
        return g.pHa;
    }

    protected final void bgl() {
        this.qhN.setText((CharSequence) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.qib).qfh.get(0));
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.qib).qfQ) {
            this.qhL.setImageDrawable(a.a(this.context, e.pAw));
            this.qhM.setImageDrawable(a.a(this.context, e.pAh));
            this.qhN.setTextColor(WebView.NIGHT_MODE_COLOR);
            this.qhO.setBackgroundResource(e.pzr);
        } else {
            this.qhL.setImageDrawable(a.a(this.context, e.pAv));
            this.qhM.setImageDrawable(a.a(this.context, e.pAg));
            this.qhN.setTextColor(-1);
            this.qhO.setBackgroundResource(e.pzs);
        }
        this.qhO.setPadding((int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.qib).qfM, 0, (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.qib).qfN, 0);
        this.lJu.setPadding(0, (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.qib).qfK, 0, (int) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.qib).qfL);
        a(this.qhO);
        this.qhO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ d qhQ;

            {
                this.qhQ = r1;
            }

            public final void onClick(View view) {
                d dVar = this.qhQ;
                dVar.qhP++;
                if (c.a.sTi != null) {
                    if (this.qhQ.bgk().qfh.size() > 1) {
                        c.a.sTi.a(this.qhQ.context, this.qhQ.bgk().qfh, new OnDismissListener(this) {
                            final /* synthetic */ AnonymousClass1 qhR;

                            {
                                this.qhR = r1;
                            }

                            public final void onDismiss(DialogInterface dialogInterface) {
                                ab.cQ(this.qhR.qhQ.context);
                            }
                        });
                    } else {
                        c.a.sTi.a(this.qhQ.context, (String) this.qhQ.bgk().qfh.get(0), new OnDismissListener(this) {
                            final /* synthetic */ AnonymousClass1 qhR;

                            {
                                this.qhR = r1;
                            }

                            public final void onDismiss(DialogInterface dialogInterface) {
                                ab.cQ(this.qhR.qhQ.context);
                            }
                        }, new Bundle());
                    }
                }
            }
        });
    }

    public final View bgf() {
        if (((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d) this.qib).qfh.isEmpty()) {
            return null;
        }
        View view = this.ipu;
        this.qhL = (ImageView) view.findViewById(f.pCY);
        this.qhM = (ImageView) view.findViewById(f.pAg);
        this.qhN = (TextView) view.findViewById(f.bHZ);
        this.lJu = (LinearLayout) view.findViewById(f.bGr);
        this.qhO = (LinearLayout) view.findViewById(f.pCT);
        return this.ipu;
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
