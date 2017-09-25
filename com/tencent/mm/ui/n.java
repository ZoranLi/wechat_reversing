package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.w;

public abstract class n implements OnClickListener {
    private long pyc = -1;

    public abstract void aII();

    public void onClick(View view) {
        w.i("MicroMsg.MMCustomClickListener", "button onclick");
        if (this.pyc != -1) {
            if ((System.nanoTime() - this.pyc) / 1000000 < 3000) {
                w.i("MicroMsg.MMCustomClickListener", "click time limited limitetime:%d, delaytime:%d", new Object[]{Long.valueOf((System.nanoTime() - this.pyc) / 1000000), Long.valueOf(3000)});
                return;
            }
        }
        this.pyc = System.nanoTime();
        aII();
    }
}
