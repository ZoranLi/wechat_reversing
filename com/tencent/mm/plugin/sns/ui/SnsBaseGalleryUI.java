package com.tencent.mm.plugin.sns.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.e.a.aj;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.i.c;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.s.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.MMGestureGallery;

public abstract class SnsBaseGalleryUI extends MMActivity implements a {
    private boolean jVV = true;
    private LinearLayout qyV;
    r qyW;
    private LinearLayout qyX;
    s qyY;
    private boolean qyZ = true;
    private TextView qza = null;
    protected SnsInfoFlip qzb;
    protected Button qzc;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ae.beG().N(3, true);
        this.qyV = (LinearLayout) findViewById(f.pCX);
        this.qyX = (LinearLayout) findViewById(f.content);
        this.qyY = new s(this, this);
        s sVar = this.qyY;
        w.i("MicroMsg.GalleryTitleManager", "onAttach");
        h.vJ();
        h.vH().gXC.a(218, sVar);
        com.tencent.mm.sdk.b.a.urY.b(sVar.lHl);
        com.tencent.mm.sdk.b.a.urY.b(sVar.qtq);
    }

    public void onResume() {
        super.onResume();
        if (this.qyW != null) {
            this.qyW.refresh();
        }
    }

    public final void addView(View view) {
        this.qyV.addView(view, new LayoutParams(-1, -1));
    }

    @SuppressLint({"ResourceAsColor"})
    public final void o(boolean z, int i) {
        this.qyW = new r(this, i, z);
        this.qyW.setBackgroundColor(c.transparent);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        this.qyW.getBackground().setAlpha(50);
        this.qyX.addView(this.qyW, layoutParams);
        this.qyW.fJn = getIntent().getIntExtra("sns_source", 0);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.qyY != null) {
            s sVar = this.qyY;
            w.i("MicroMsg.GalleryTitleManager", "onDetch");
            h.vJ();
            h.vH().gXC.b(218, sVar);
            com.tencent.mm.sdk.b.a.urY.c(sVar.lHl);
            com.tencent.mm.sdk.b.a.urY.c(sVar.qtq);
        }
        if (this.qzb != null) {
            SnsInfoFlip snsInfoFlip = this.qzb;
            if (snsInfoFlip.qBQ != null && (snsInfoFlip.qBQ instanceof MMGestureGallery)) {
                MMGestureGallery mMGestureGallery = (MMGestureGallery) snsInfoFlip.qBQ;
                mMGestureGallery.wmO.release();
                mMGestureGallery.wmP.release();
                mMGestureGallery.wmN.release();
            }
            this.qzb.onDestroy();
        }
    }

    protected int getLayoutId() {
        return g.pHz;
    }

    public void bO(String str, int i) {
        if (this.qyZ && !ae.beu()) {
            m Gg = ae.beL().Gg(str);
            if (Gg == null || Gg.field_snsId == 0) {
                kr(false);
            } else {
                kr(true);
            }
        }
    }

    protected void onPause() {
        if (this.qzb != null) {
            this.qzb.onPause();
        }
        if (this.qyY != null) {
            s sVar = this.qyY;
            if (sVar.qtn != null) {
                b ajVar = new aj();
                ajVar.fDJ.activity = (Activity) sVar.context;
                ajVar.fDJ.fDK = sVar.qtn;
                com.tencent.mm.sdk.b.a.urY.m(ajVar);
                sVar.qtn = null;
                sVar.fFp = 0;
                sVar.fFo = 0;
            }
        }
        super.onPause();
    }

    public final void dF(String str, String str2) {
        if (this.qyZ) {
            qP(str);
            SE(str2);
        }
    }

    public void bN(String str, int i) {
    }

    public void adz() {
        int i = 8;
        boolean z = false;
        if (this.qyZ) {
            int i2;
            if (this.jVV) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            zg(i2);
            if (this.qyW != null) {
                r rVar = this.qyW;
                if (!this.jVV) {
                    i = 0;
                }
                rVar.setVisibility(i);
            }
            if (!this.jVV) {
                z = true;
            }
            this.jVV = z;
        }
    }

    public final void biU() {
        this.jVV = false;
        zg(8);
        if (this.qyW != null) {
            this.qyW.setVisibility(8);
        }
    }
}
