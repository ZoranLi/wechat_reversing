package com.tencent.mm.ui.chatting.gallery;

import android.view.View;
import com.tencent.mm.storage.au;

public abstract class a {
    protected b vPU;

    public a(b bVar) {
        this.vPU = bVar;
    }

    public void detach() {
        this.vPU = null;
    }

    public boolean a(j jVar, au auVar, int i) {
        return false;
    }

    public final j Bk(int i) {
        if (this.vPU == null) {
            return null;
        }
        View Al = this.vPU.Al(i);
        return Al == null ? null : (j) Al.getTag();
    }

    public final void Bl(int i) {
        if (this.vPU != null) {
            View Al = this.vPU.Al(i);
            if (Al != null && Al.getTag() != null) {
                a((j) Al.getTag(), this.vPU.Bm(i), i);
            }
        }
    }
}
