package com.tencent.mm.plugin.location.ui.impl;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.modelgeo.b;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.sdk.platformtools.w;

public class PickPoi extends RelativeLayout {
    private Context context;
    Animation ncP;
    View ncQ;
    protected b ngr;
    public a ngz = new a(this) {
        final /* synthetic */ PickPoi nhL;

        {
            this.nhL = r1;
        }

        public final void b(Addr addr) {
            w.d("MicroMsg.PickPoi", "onGetAddrss  %s", new Object[]{addr.toString()});
            if (this.nhL.nhI == null) {
                w.i("MicroMsg.PickPoi", "error, empty poi!");
                return;
            }
            f a = this.nhL.nhI;
            a.nid = addr;
            a.nhT = addr.hCE;
            a.aKd = (double) addr.hCP;
            a.aKe = (double) addr.hCQ;
            a.nhX = addr.hCF;
            a.nhY = addr.hCG;
            a.nia = addr.hCK;
            a.nic = addr.hCM;
            a.nif = addr.hCO;
            w.d("poidata", "roughAddr %s", new Object[]{addr.toString()});
            if (this.nhL.nhK != null) {
                this.nhL.nhK.notifyDataSetChanged();
            }
        }
    };
    private double nhG;
    private double nhH;
    f nhI = new f();
    boolean nhJ = true;
    e nhK = null;

    public PickPoi(Context context) {
        super(context);
        this.context = context;
        init();
    }

    public PickPoi(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    public PickPoi(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    private void init() {
        this.ngr = b.Gi();
        this.ncP = AnimationUtils.loadAnimation(this.context, R.a.aRT);
        this.ncQ = LayoutInflater.from(this.context).inflate(R.i.dgQ, this, true).findViewById(R.h.cbZ);
    }

    public final void i(double d, double d2) {
        this.nhG = d;
        this.nhH = d2;
        this.nhI = new f();
        this.nhI.type = 3;
        this.nhI.mName = this.context.getResources().getString(R.l.ewy);
        this.nhI.aKd = d;
        this.nhI.aKe = d2;
        this.nhI.nhT = "";
        this.ngr.a(this.ngz);
        this.ngr.a(d, d2, this.ngz);
        this.nhJ = true;
    }
}
