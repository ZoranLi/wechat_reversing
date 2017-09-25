package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.sdk.platformtools.ab;

public final class k extends l {
    private a rMS;

    public interface a {
        void akv();
    }

    public k(a aVar) {
        this(2, aVar);
    }

    public k(int i, a aVar) {
        super(i, null);
        this.rMS = aVar;
    }

    public final void onClick(View view) {
        if (this.rMS != null) {
            this.rMS.akv();
        }
    }

    protected final void vF(int i) {
        Context context = ab.getContext();
        super.vF(i);
        if (i == 5) {
            dI(context.getResources().getColor(R.e.white), context.getResources().getColor(R.e.aVR));
        }
    }
}
