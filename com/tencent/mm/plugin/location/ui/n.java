package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.w;

public final class n implements c {
    public boolean fJm = false;
    public boolean isVisible = true;
    private String naK;
    public double naO = 1000000.0d;
    public double naP = 1000000.0d;
    private TextView ncN;
    private ProgressBar ncO;
    public String ncS = "";
    public boolean nds = true;
    public View ndt;
    public d ndu;
    public String ndv;
    public ImageView ngb;
    public FrameLayout ngc;
    public View ngd;
    private TextView nge;
    public TextView ngf;

    public final void fs(boolean z) {
        if (z && this.isVisible) {
            this.ngc.setVisibility(0);
        } else if ((!z || this.isVisible) && !z && this.isVisible) {
            this.ngc.setVisibility(4);
        }
    }

    public final void b(LocationInfo locationInfo) {
        this.naO = locationInfo.naO;
        this.naP = locationInfo.naP;
    }

    public final void zD(String str) {
        w.d("ZItemOverlay", "popView " + this.ndt.getWidth() + " " + this.ndt.getHeight());
        this.ncN = (TextView) this.ndt.findViewById(R.h.ccr);
        this.ncO = (ProgressBar) this.ndt.findViewById(R.h.cch);
        this.nge = (TextView) this.ndt.findViewById(R.h.cck);
        this.ndt.findViewById(R.h.cci).setVisibility(0);
        if (str == null || str.equals("")) {
            this.ncO.setVisibility(0);
        } else {
            this.ncO.setVisibility(8);
            this.ncN.setVisibility(0);
            this.ncN.setText(str);
        }
        if (this.ndv == null || this.ndv.equals("")) {
            this.nge.setText("");
            this.nge.setVisibility(8);
        } else {
            this.nge.setVisibility(0);
            this.nge.setText(this.ndv);
        }
        if (this.nds) {
            this.ndt.setVisibility(0);
            this.ndu.updateLocaitonPinLayout(this.ndt, this.naO, this.naP);
            this.ndt.invalidate();
        }
    }

    public n(d dVar, Context context) {
        View inflate = View.inflate(context, R.i.dig, null);
        this.ngf = (TextView) inflate.findViewById(R.h.bVs);
        this.ngf.setVisibility(8);
        inflate.setVisibility(8);
        this.ngb = (ImageView) inflate.findViewById(R.h.cbZ);
        this.ngb.setImageResource(R.g.bgj);
        this.ngc = (FrameLayout) inflate.findViewById(R.h.ciL);
        this.ngd = inflate.findViewById(R.h.cbW);
        this.ndu = dVar;
        this.ndt = inflate;
    }

    public final void setText(String str) {
        this.naK = str;
        zD(this.naK);
    }

    public final String aGw() {
        return this.ncS;
    }
}
