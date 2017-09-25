package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.l.k;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;

public class d {
    protected String appId;
    protected Context context;
    protected a jPd;
    protected String openId;

    public interface a {
        void cR(boolean z);
    }

    public d(Context context, String str, String str2, a aVar) {
        this.context = context;
        this.appId = str;
        this.openId = str2;
        this.jPd = aVar;
    }

    public final void acH() {
        if (this.openId == null || this.openId.length() == 0) {
            w.w("MicroMsg.OpenIdChecker", "doCheck, openId is null");
            this.jPd.cR(true);
            return;
        }
        f aJ = g.aJ(this.appId, false);
        if (aJ == null) {
            w.e("MicroMsg.OpenIdChecker", "doCheck fail, local app is null, appId = " + this.appId);
            this.jPd.cR(true);
        } else if (u.mA(aJ.field_openId)) {
            w.w("MicroMsg.OpenIdChecker", "doCheck fail, local openId is null, appId = " + this.appId);
            w.d("MicroMsg.OpenIdChecker", "doCheck, trigger getappsetting, appId = " + this.appId);
            an.aRs().Jl(this.appId);
            this.jPd.cR(true);
        } else if (this.openId.equalsIgnoreCase(aJ.field_openId)) {
            w.d("MicroMsg.OpenIdChecker", "doCheck succ, appId = " + this.appId);
            this.jPd.cR(true);
        } else {
            w.w("MicroMsg.OpenIdChecker", "doCheck fail, appId = " + this.appId + ", openId = " + this.openId + ", localOpenId = " + aJ.field_openId);
            Nj();
        }
    }

    protected void Nj() {
        com.tencent.mm.ui.base.g.b(this.context, R.l.eFn, R.l.dIO, new OnClickListener(this) {
            final /* synthetic */ d jPe;

            {
                this.jPe = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                k kVar = com.tencent.mm.pluginsdk.l.a.sBw;
                if (kVar != null) {
                    kVar.I(this.jPe.openId, m.xO(), this.jPe.appId);
                }
                this.jPe.jPd.cR(true);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ d jPe;

            {
                this.jPe = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                k kVar = com.tencent.mm.pluginsdk.l.a.sBw;
                if (kVar != null) {
                    kVar.I(this.jPe.openId, m.xO(), this.jPe.appId);
                }
                this.jPe.jPd.cR(false);
            }
        });
    }
}
