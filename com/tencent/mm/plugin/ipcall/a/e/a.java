package com.tencent.mm.plugin.ipcall.a.e;

public class a {
    public boolean fOV = false;

    public void start() {
        reset();
        this.fOV = true;
    }

    public void reset() {
    }

    protected void aEK() {
    }

    public final void finish() {
        if (this.fOV) {
            aEK();
            this.fOV = false;
        }
    }
}
