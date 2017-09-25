package com.tencent.mm.plugin.aa.ui;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.d.l;

public final class a extends l {
    private a ioR;

    public interface a {
        void NZ();
    }

    public a(a aVar) {
        super(2, null);
        this.ioR = aVar;
    }

    public final void onClick(View view) {
        if (this.ioR != null) {
            this.ioR.NZ();
        }
    }
}
