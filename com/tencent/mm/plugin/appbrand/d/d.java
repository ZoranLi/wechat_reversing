package com.tencent.mm.plugin.appbrand.d;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.pr;
import com.tencent.mm.plugin.appbrand.b.e;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.List;

public final class d extends com.tencent.mm.plugin.fts.d.a.a {
    public i iJC;
    public List<String> iJD;
    public e iJE;
    public CharSequence iJF;
    private b iJG = new b(this);
    a iJH = new a(this);

    public class a extends com.tencent.mm.plugin.fts.d.a.a.a {
        public TextView iJI;
        public TextView iJJ;
        final /* synthetic */ d iJK;
        public View ipu;
        public ImageView ipv;
        public TextView ipw;

        public a(d dVar) {
            this.iJK = dVar;
            super(dVar);
        }
    }

    public class b extends com.tencent.mm.plugin.fts.d.a.a.b {
        final /* synthetic */ d iJK;

        public b(d dVar) {
            this.iJK = dVar;
            super(dVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(R.i.cTY, viewGroup, false);
            a aVar = this.iJK.iJH;
            aVar.ipv = (ImageView) inflate.findViewById(R.h.bqM);
            aVar.ipw = (TextView) inflate.findViewById(R.h.cJh);
            aVar.ipu = inflate.findViewById(R.h.cAN);
            aVar.iJI = (TextView) inflate.findViewById(R.h.cBp);
            aVar.iJJ = (TextView) inflate.findViewById(R.h.cHg);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, com.tencent.mm.plugin.fts.d.a.a aVar2) {
            int i;
            int i2 = 1;
            d dVar = (d) aVar2;
            a aVar3 = (a) aVar;
            aVar3.ipw.setText(this.iJK.iJF);
            int i3 = this.iJK.iJE.izM;
            long j = this.iJK.iJE.iCb;
            if ((1 & j) > 0) {
                i = R.l.dFR;
            } else if ((j & 2) > 0) {
                i = R.l.dFQ;
            } else {
                i = 0;
                i2 = 0;
            }
            if (i2 == 0 || i3 != 0) {
                aVar3.ipv.setColorFilter(null);
            } else {
                ColorMatrix colorMatrix = new ColorMatrix();
                colorMatrix.setSaturation(0.0f);
                aVar3.ipv.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                aVar3.iJI.setVisibility(0);
                aVar3.iJI.setText(i);
            }
            CharSequence hu = com.tencent.mm.plugin.appbrand.appcache.a.hu(this.iJK.iJE.izM);
            if (bg.mA(hu)) {
                aVar3.iJJ.setVisibility(8);
            } else {
                aVar3.iJJ.setText(hu);
                aVar3.iJJ.setVisibility(0);
            }
            com.tencent.mm.modelappbrand.a.b.AY().a(aVar3.ipv, dVar.iJE.iCa, com.tencent.mm.modelappbrand.a.a.AX(), com.tencent.mm.modelappbrand.a.e.hqF);
        }

        public final boolean a(Context context, com.tencent.mm.plugin.fts.d.a.a aVar) {
            d dVar = (d) aVar;
            com.tencent.mm.sdk.b.b prVar = new pr();
            prVar.fWB.userName = dVar.iJE.fCJ;
            prVar.fWB.fWE = dVar.iJE.izM;
            prVar.fWB.fWH = true;
            prVar.fWB.scene = 1027;
            com.tencent.mm.sdk.b.a.urY.m(prVar);
            return true;
        }
    }

    public d(int i) {
        super(16, i);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.d.a.a.a aVar, Object... objArr) {
        String str;
        boolean z = true;
        boolean z2 = false;
        this.iJE = i.oW(this.iJC.lZO);
        switch (this.iJC.hPr) {
            case 2:
                break;
            case 3:
                z2 = true;
                break;
            default:
                z = false;
                break;
        }
        if (z) {
            this.iJF = com.tencent.mm.as.d.a(this.iJE.appName, this.iJD, z2, this.fRM);
        } else {
            this.iJF = com.tencent.mm.as.d.a(this.iJE.appName, this.iJD, this.fRM);
        }
        if (this.iJE == null) {
            str = "";
        } else {
            str = this.iJE.fCJ;
        }
        this.info = str;
    }

    public final com.tencent.mm.plugin.fts.d.a.a.b Sr() {
        return this.iJG;
    }

    protected final com.tencent.mm.plugin.fts.d.a.a.a Ss() {
        return this.iJH;
    }

    public final String St() {
        return this.iJE.appName;
    }

    public final int Su() {
        return this.iJC.maw;
    }
}
