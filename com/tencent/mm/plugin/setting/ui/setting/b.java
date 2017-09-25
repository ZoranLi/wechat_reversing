package com.tencent.mm.plugin.setting.ui.setting;

import android.widget.LinearLayout;

final class b {
    LinearLayout pnA;
    LinearLayout pnw;
    LinearLayout pnx;
    LinearLayout pny;
    LinearLayout pnz;

    b() {
    }

    public final void Ec(String str) {
        if (str.equals("downloading")) {
            this.pnw.setVisibility(0);
            this.pnx.setVisibility(8);
            this.pny.setVisibility(8);
            this.pnz.setVisibility(8);
            this.pnA.setVisibility(8);
        } else if (str.equals("downloaded")) {
            this.pnw.setVisibility(8);
            this.pnx.setVisibility(0);
            this.pny.setVisibility(8);
            this.pnz.setVisibility(8);
            this.pnA.setVisibility(8);
        } else if (str.equals("undownloaded")) {
            this.pnw.setVisibility(8);
            this.pnx.setVisibility(8);
            this.pny.setVisibility(0);
            this.pnz.setVisibility(8);
            this.pnA.setVisibility(8);
        } else if (str.equals("using")) {
            this.pnw.setVisibility(8);
            this.pnx.setVisibility(8);
            this.pny.setVisibility(8);
            this.pnz.setVisibility(0);
            this.pnA.setVisibility(8);
        } else if (str.equals("canceling")) {
            this.pnw.setVisibility(8);
            this.pnx.setVisibility(8);
            this.pny.setVisibility(8);
            this.pnz.setVisibility(8);
            this.pnA.setVisibility(0);
        }
    }
}
