package com.tencent.mm.ui;

import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.preference.i;

public abstract class a extends i implements i {
    private Bundle qxV;
    private boolean uNS;
    private boolean uNT;
    private boolean uNU;
    private boolean uNV;
    protected boolean uNW = false;
    protected boolean uNX = false;
    protected boolean uNY;

    protected abstract void bOl();

    protected abstract void bOm();

    protected abstract void bOn();

    protected abstract void bOo();

    protected abstract void bOp();

    protected abstract void bOq();

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.qxV = bundle;
        this.uNT = true;
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void onResume() {
        super.onResume();
        bOv();
        LauncherUI bPI = LauncherUI.bPI();
        if (bPI != null && bPI.uRQ) {
            this.uNW = true;
            if (this.uNX) {
                bOx();
                this.uNX = false;
            }
        }
    }

    public final void bOu() {
        bOs();
        this.uNU = true;
    }

    public final void bOx() {
        if (this.uNW) {
            if (this.uNT) {
                bOl();
                this.uNT = false;
            } else if (this.uNS) {
                bOq();
                bOl();
                w.v("MicroMsg.INIT", "KEVIN tab onRecreate ");
                this.uNS = false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.uNU) {
                bOt();
                this.uNU = false;
            }
            bOm();
            w.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - currentTimeMillis));
            this.uNV = true;
            this.uNW = false;
        }
    }

    public final void bOw() {
        this.uNX = true;
    }

    public final void onPause() {
        super.onPause();
        this.uNY = true;
        if (!this.uNY) {
            return;
        }
        if (this.uNV) {
            long currentTimeMillis = System.currentTimeMillis();
            bOo();
            w.d("MicroMsg.INIT", "KEVIN " + toString() + " onTabPause last : " + (System.currentTimeMillis() - currentTimeMillis));
            this.uNV = false;
            this.uNY = false;
            return;
        }
        this.uNY = false;
    }

    public final void onStop() {
        super.onStop();
        bOp();
    }

    public final void onStart() {
        super.onStart();
        LauncherUI bPI = LauncherUI.bPI();
        if (bPI != null && bPI.uRQ) {
            bOn();
        }
    }

    public void onDestroy() {
        bOq();
        super.onDestroy();
    }
}
