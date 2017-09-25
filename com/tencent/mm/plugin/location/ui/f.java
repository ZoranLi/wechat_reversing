package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.w;

public final class f implements c {
    public boolean fJm = false;
    private boolean isVisible = true;
    private String naK;
    private double naO = 1000000.0d;
    private double naP = 1000000.0d;
    private String ncS = "";
    private boolean nds = true;
    private View ndt;
    private d ndu;
    public String ndv;
    private TextView ndw;
    private TextView ndx;
    public ImageButton ndy;

    public f(d dVar, Context context) {
        View findViewById = ((Activity) context).findViewById(R.h.ccd);
        this.ndw = (TextView) findViewById.findViewById(R.h.ccb);
        this.ndx = (TextView) findViewById.findViewById(R.h.ccc);
        this.ndy = (ImageButton) findViewById.findViewById(R.h.ccj);
        this.ndu = dVar;
        this.ndt = findViewById;
    }

    public final void setText(String str) {
        this.naK = str;
        CharSequence charSequence = this.naK;
        w.d("NewItemOverlay", "popView " + this.ndt.getWidth() + " " + this.ndt.getHeight());
        if (!(charSequence == null || charSequence.equals(""))) {
            this.ndx.setText(charSequence);
        }
        if (this.ndv == null || this.ndv.equals("")) {
            this.ndw.setText(R.l.ewp);
        } else {
            this.ndw.setText(this.ndv);
        }
        if (this.nds) {
            this.ndt.setVisibility(0);
            this.ndt.invalidate();
        }
    }

    public final String aGw() {
        return this.ncS;
    }
}
