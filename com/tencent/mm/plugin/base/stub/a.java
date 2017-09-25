package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.l.k;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;

public final class a extends d {
    public a(Context context, String str, String str2, com.tencent.mm.plugin.base.stub.d.a aVar) {
        super(context, str, str2, aVar);
    }

    protected final void Nj() {
        g.a(this.context, R.l.epo, R.l.dIO, false, new OnClickListener(this) {
            final /* synthetic */ a jOZ;

            {
                this.jOZ = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                k kVar = com.tencent.mm.pluginsdk.l.a.sBw;
                if (kVar != null) {
                    kVar.I(this.jOZ.openId, m.xO(), this.jOZ.appId);
                }
                this.jOZ.jPd.cR(false);
            }
        });
    }
}
