package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.d.l;

public final class a extends l {
    private a rvc;

    public interface a {
        void NZ();
    }

    public a(a aVar) {
        super(2, null);
        this.rvc = aVar;
    }

    public final void onClick(View view) {
        if (this.rvc != null) {
            this.rvc.NZ();
        }
    }
}
