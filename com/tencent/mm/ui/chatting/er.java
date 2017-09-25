package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.bw;
import com.tencent.mm.plugin.appbrand.jsapi.cp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.ah.a;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

final class er extends a {
    public static final int vOK = com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), cp.CTRL_INDEX);
    public static final int vOL = com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), bw.CTRL_INDEX);
    static c vOM;
    protected ThreeDotsLoadingView jmH;
    protected ImageView vON;
    protected ViewGroup vOO;
    protected View vOP;
    protected TextView vyE;
    protected ImageView vyP;
    protected ImageView vyR;
    protected ImageView vyS;
    protected ChattingItemFooter vyU;
    protected ImageView vyV;
    protected LinearLayout vyW;
    protected ViewGroup vyX;
    protected TextView vyY;
    protected LinearLayout vyZ;
    ImageView vyy;
    protected TextView vzj;
    protected ImageView vzk;
    protected TextView vzl;
    protected TextView vzm;
    protected LinearLayout vzn;
    protected TextView vzq;

    static {
        c.a aVar = new c.a();
        aVar.hJa = R.k.dtz;
        aVar.aO(com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 20), com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 20)).hIJ = true;
        vOM = aVar.Hg();
    }

    public er(int i) {
        super(i);
    }

    public final er r(View view, boolean z) {
        super.dn(view);
        this.vyP = (ImageView) view.findViewById(R.h.bzL);
        this.vyR = (ImageView) this.mil.findViewById(R.h.bAn);
        this.vyS = (ImageView) this.mil.findViewById(R.h.bBz);
        this.vyE = (TextView) view.findViewById(R.h.bzy);
        this.vyV = (ImageView) view.findViewById(R.h.bzF);
        this.mfD = (CheckBox) view.findViewById(R.h.bAd);
        this.nRW = view.findViewById(R.h.bAX);
        this.piH = (TextView) view.findViewById(R.h.bBG);
        this.vyU = (ChattingItemFooter) view.findViewById(R.h.aTR);
        this.vyW = (LinearLayout) view.findViewById(R.h.bpI);
        this.vyX = (ViewGroup) view.findViewById(R.h.cco);
        this.vyY = (TextView) view.findViewById(R.h.ccm);
        this.vyZ = (LinearLayout) view.findViewById(R.h.bzR);
        this.vBZ = view.findViewById(R.h.bAe);
        if (!z) {
            this.vyy = (ImageView) this.mil.findViewById(R.h.bBy);
            this.oDJ = (ProgressBar) this.mil.findViewById(R.h.cKX);
        }
        this.vzn = (LinearLayout) view.findViewById(R.h.bzr);
        this.jmH = (ThreeDotsLoadingView) view.findViewById(R.h.cbU);
        this.vON = (ImageView) view.findViewById(R.h.bHc);
        this.vzq = (TextView) view.findViewById(R.h.bzu);
        this.vzj = (TextView) view.findViewById(R.h.bzt);
        this.vzk = (ImageView) view.findViewById(R.h.bzv);
        this.vzl = (TextView) view.findViewById(R.h.bzx);
        this.vzm = (TextView) view.findViewById(R.h.bzw);
        this.vOO = (ViewGroup) view.findViewById(R.h.bHf);
        return this;
    }
}
