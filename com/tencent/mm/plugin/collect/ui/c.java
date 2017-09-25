package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.j.a;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ag;
import com.tencent.mm.u.ag.b;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.x.n;

public final class c extends Preference {
    public String gLD = null;
    private TextView jhl = null;
    public ImageView kDl = null;
    private Context mContext = null;
    String mTitle = null;
    private View mView = null;

    public c(Context context) {
        super(context);
        this.mContext = context;
        setLayoutResource(R.i.cZk);
    }

    public c(Context context, int i) {
        super(context);
        this.mContext = context;
        setLayoutResource(i);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.jhl = (TextView) view.findViewById(16908310);
        this.kDl = (ImageView) view.findViewById(R.h.bEb);
        this.jhl.setText(h.b(this.mContext, this.mTitle, this.jhl.getTextSize()));
        if (bg.mA(this.gLD)) {
            this.kDl.setVisibility(8);
            return;
        }
        this.kDl.setVisibility(0);
        ap.yY();
        a Rb = com.tencent.mm.u.c.wR().Rb(this.gLD);
        if (Rb == null || ((int) Rb.gTQ) <= 0) {
            w.d("MicroMsg.CollectPayInfoPreference", "Receiver in contactStg and try to get contact");
            final long Nz = bg.Nz();
            ag.a.hlS.a(this.gLD, "", new b.a(this) {
                final /* synthetic */ c kDn;

                public final void p(String str, boolean z) {
                    if (z) {
                        w.v("MicroMsg.CollectPayInfoPreference", "getContact suc; cost=" + (bg.Nz() - Nz) + " ms");
                        com.tencent.mm.x.b.u(str, 3);
                        n.Bz().hf(str);
                    } else {
                        w.w("MicroMsg.CollectPayInfoPreference", "getContact failed");
                    }
                    com.tencent.mm.pluginsdk.ui.a.b.a(this.kDn.kDl, this.kDn.gLD);
                }
            });
            return;
        }
        com.tencent.mm.pluginsdk.ui.a.b.a(this.kDl, this.gLD);
    }
}
