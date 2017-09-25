package com.tencent.mm.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import com.tencent.mm.sdk.platformtools.w;

public abstract class AbstractTabChildActivity extends ActionBarActivity {

    public static abstract class a extends q implements i {
        private Bundle qxV;
        private boolean uNS;
        private boolean uNT;
        private boolean uNU;
        protected boolean uNV;
        protected boolean uNW = false;
        protected boolean uNX = false;
        protected boolean uNY;
        protected boolean uNZ = false;

        public abstract void bOl();

        public abstract void bOm();

        public abstract void bOn();

        public abstract void bOo();

        public abstract void bOp();

        public abstract void bOq();

        public abstract void bOr();

        public abstract void bOs();

        public abstract void bOt();

        public final void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.uNT = true;
            this.qxV = bundle;
        }

        public int getLayoutId() {
            return 0;
        }

        public final void bOu() {
            bOs();
            this.uNU = true;
        }

        public final boolean onKeyDown(int i, KeyEvent keyEvent) {
            if (i == 4 && keyEvent.getAction() == 0) {
                return false;
            }
            return super.onKeyDown(i, keyEvent);
        }

        public void onResume() {
            super.onResume();
            LauncherUI bPI = LauncherUI.bPI();
            if (bPI != null && bPI.uRQ) {
                this.uNW = true;
                if (this.uNX) {
                    bOx();
                    this.uNX = false;
                }
            }
        }

        public final void bOv() {
        }

        public final void bOw() {
            this.uNX = true;
        }

        public void onPause() {
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

        public final void bOx() {
            if (this.uNW) {
                if (this.uNT) {
                    bOl();
                    this.uNT = false;
                } else if (this.uNS) {
                    if (this.uNZ) {
                        bOq();
                    }
                    bOl();
                    w.v("MicroMsg.INIT", "KEVIN tab onRecreate " + toString());
                    this.uNS = false;
                }
                this.uNZ = true;
                long currentTimeMillis = System.currentTimeMillis();
                if (this.uNU) {
                    this.uNU = false;
                    bOt();
                }
                bOm();
                w.d("MicroMsg.INIT", "KEVIN " + toString() + " OnTabResume last : " + (System.currentTimeMillis() - currentTimeMillis));
                this.uNV = true;
                this.uNW = false;
            }
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
            if (this.uNZ) {
                bOq();
            }
            super.onDestroy();
        }

        public boolean biv() {
            return false;
        }
    }
}
