package com.tencent.mm.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.w;

public abstract class o implements OnMenuItemClickListener {
    private long pyc = -1;

    public abstract void bsU();

    public boolean onMenuItemClick(MenuItem menuItem) {
        w.i("MicroMsg.MMCustomMenuItemClickListener", "button onclick");
        if (this.pyc != -1) {
            if ((System.nanoTime() - this.pyc) / 1000000 < 500) {
                w.i("MicroMsg.MMCustomMenuItemClickListener", "click time limited limitetime:%d, delaytime:%d", Long.valueOf((System.nanoTime() - this.pyc) / 1000000), Long.valueOf(500));
                return false;
            }
        }
        this.pyc = System.nanoTime();
        bsU();
        return false;
    }
}
