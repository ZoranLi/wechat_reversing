package com.tencent.mm.plugin.shake.c.b;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.e.a.ob;
import com.tencent.mm.e.a.oc;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.i;

public final class a extends i {
    private static final String kfw = (e.hgu + "card");
    private Resources Cu;
    private OnClickListener iuW = new OnClickListener(this) {
        final /* synthetic */ a ppG;

        {
            this.ppG = r1;
        }

        public final void onClick(View view) {
            if (view.getId() == R.h.bwv) {
                this.ppG.dismiss();
                if (this.ppG.ppE != null) {
                    this.ppG.ppE.bbg();
                }
                w.i("MicroMsg.ShakeCardDialog", "close ShakeCardDialog");
            } else if (view.getId() != R.h.bvL) {
            } else {
                if (this.ppG.ppD == a.ppI) {
                    this.ppG.ppD = a.ppJ;
                    this.ppG.kYg.setVisibility(0);
                    this.ppG.bbe();
                    a.d(this.ppG);
                } else if (this.ppG.ppD == a.ppJ) {
                } else {
                    if (this.ppG.ppD == a.ppL) {
                        a.d(this.ppG);
                    } else if (this.ppG.ppD == a.ppK) {
                        com.tencent.mm.sdk.b.a.urY.b(this.ppG.ppF);
                        a.f(this.ppG);
                    }
                }
            }
        }
    };
    private ProgressBar kYg;
    private String kcJ = "";
    private View khv;
    private ImageView kie;
    private Button kif;
    private ImageView nkY;
    private TextView oRV;
    private boolean ppA = false;
    private int ppB = 0;
    private com.tencent.mm.e.a.ob.b ppC;
    private int ppD = a.ppI;
    private b ppE;
    private c ppF = new c<oc>(this) {
        final /* synthetic */ a ppG;

        {
            this.ppG = r2;
            this.usg = oc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            this.ppG.dismiss();
            if (this.ppG.ppE != null) {
                this.ppG.ppE.bbg();
            }
            w.i("MicroMsg.ShakeCardDialog", "gift event come, do close ShakeCardDialog");
            return false;
        }
    };
    private com.tencent.mm.plugin.shake.c.a.e ppi;
    private View ppl;
    private TextView ppm;
    private TextView ppn;
    private TextView ppo;
    private TextView ppp;
    private View ppq;
    private View ppr;
    private View pps;
    private TextView ppt;
    private TextView ppu;
    private TextView ppv;
    private View ppw;
    private ImageView ppx;
    private boolean ppy;
    public boolean ppz = false;

    private enum a {
        ;

        static {
            ppI = 1;
            ppJ = 2;
            ppK = 3;
            ppL = 4;
            ppM = new int[]{ppI, ppJ, ppK, ppL};
        }
    }

    public interface b {
        void bbg();
    }

    static /* synthetic */ void d(a aVar) {
        w.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept()");
        if (TextUtils.isEmpty(aVar.ppi.kdE)) {
            w.e("MicroMsg.ShakeCardDialog", "card_tp_id is empty befor doNetSceneAccept");
            return;
        }
        final com.tencent.mm.sdk.b.b obVar = new ob();
        obVar.fVk = null;
        obVar.fVj.fVl = aVar.ppi.kdE;
        obVar.fVj.fVm = aVar.ppi.fVm;
        obVar.fVj.fVn = 15;
        obVar.nFq = new Runnable(aVar) {
            final /* synthetic */ a ppG;

            public final void run() {
                w.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept callback");
                this.ppG.ppC = obVar.fVk;
                if (this.ppG.ppC != null) {
                    this.ppG.kYg.setVisibility(8);
                    if (this.ppG.ppC != null) {
                        this.ppG.kcJ = this.ppG.ppC.fVl;
                    }
                    if (this.ppG.ppC == null || !this.ppG.ppC.fHO) {
                        this.ppG.ppD = a.ppL;
                        this.ppG.bbd();
                        this.ppG.bbf();
                        return;
                    }
                    this.ppG.ppD = a.ppK;
                    this.ppG.bbd();
                    a.i(this.ppG);
                    this.ppG.ppz = true;
                    if (this.ppG.ppE != null) {
                        this.ppG.ppE.bbg();
                        return;
                    }
                    return;
                }
                w.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept callback, mCardAcceptResult == null");
            }
        };
        com.tencent.mm.sdk.b.a.urY.a(obVar, Looper.getMainLooper());
    }

    static /* synthetic */ void f(a aVar) {
        w.i("MicroMsg.ShakeCardDialog", "goCardDetailUI ShakeCardDialog");
        g.oUh.A(11665, aVar.kcJ);
        com.tencent.mm.plugin.shake.c.c.a.o(aVar.getContext(), aVar.kcJ, aVar.ppi.fVm);
    }

    static /* synthetic */ void i(a aVar) {
        aVar.bbe();
        if (aVar.ppD == a.ppK) {
            aVar.oRV.setText(R.l.eUX);
            if (aVar.ppB == 1) {
                aVar.ppx.setImageResource(R.k.dzw);
            } else {
                aVar.ppx.setImageResource(R.k.dzx);
            }
        }
    }

    private a(Context context) {
        super(context, R.m.foL);
        w.i("MicroMsg.ShakeCardDialog", "init shake card dialog");
        this.Cu = context.getResources();
        setCanceledOnTouchOutside(true);
        getWindow().setSoftInputMode(2);
        this.khv = View.inflate(context, R.i.cDA, null);
        this.ppl = this.khv.findViewById(R.h.cDA);
        this.ppm = (TextView) this.khv.findViewById(R.h.byK);
        this.ppn = (TextView) this.khv.findViewById(R.h.byx);
        this.ppo = (TextView) this.khv.findViewById(R.h.bwI);
        this.nkY = (ImageView) this.khv.findViewById(R.h.bwv);
        this.kif = (Button) this.khv.findViewById(R.h.bvL);
        this.ppp = (TextView) this.khv.findViewById(R.h.bvR);
        this.kYg = (ProgressBar) this.khv.findViewById(R.h.bye);
        this.nkY.setOnClickListener(this.iuW);
        this.kif.setOnClickListener(this.iuW);
        this.ppq = this.khv.findViewById(R.h.bwf);
        this.ppr = this.khv.findViewById(R.h.cTd);
        this.pps = this.khv.findViewById(R.h.byL);
        this.kie = (ImageView) this.khv.findViewById(R.h.bxF);
        this.ppt = (TextView) this.khv.findViewById(R.h.byE);
        this.ppu = (TextView) this.khv.findViewById(R.h.bwl);
        this.ppv = (TextView) this.khv.findViewById(R.h.byC);
        this.ppw = this.khv.findViewById(R.h.byh);
        this.ppx = (ImageView) this.khv.findViewById(R.h.cyH);
        this.oRV = (TextView) this.khv.findViewById(R.h.cyG);
        this.ppB = com.tencent.mm.plugin.shake.c.c.a.bbi();
    }

    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            w.i("MicroMsg.ShakeCardDialog", "back key in shake card dialog");
            dismiss();
            if (this.ppE != null) {
                this.ppE.bbg();
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.khv);
    }

    public final void setCancelable(boolean z) {
        super.setCancelable(z);
        this.ppy = z;
        setCanceledOnTouchOutside(this.ppy);
    }

    public final void dismiss() {
        try {
            if (this.ppE != null) {
                this.ppE.bbg();
            }
            if (!(this.ppD == a.ppK || this.ppA)) {
                this.ppA = true;
                w.i("MicroMsg.ShakeCardDialog", "ShakeCardDialog card is not cancel accepte");
                ap.vd().a(new com.tencent.mm.plugin.shake.c.a.a(this.ppi.kdE, this.ppi.fVm), 0);
            }
            com.tencent.mm.sdk.b.a.urY.c(this.ppF);
            w.i("MicroMsg.ShakeCardDialog", "dismiss ShakeCardDialog");
            super.dismiss();
        } catch (Exception e) {
            w.e("MicroMsg.ShakeCardDialog", "dismiss exception, e = " + e.getMessage());
        }
    }

    private void bbd() {
        if (this.ppD == a.ppK) {
            this.ppq.setVisibility(8);
            this.ppw.setVisibility(0);
        } else if (this.ppD == a.ppI || this.ppD == a.ppJ || this.ppD == a.ppL) {
            this.ppq.setVisibility(0);
            this.ppw.setVisibility(8);
        }
    }

    private void bbe() {
        if (this.ppD == a.ppI || this.ppD == a.ppL) {
            if (TextUtils.isEmpty(this.ppi.poS)) {
                this.kif.setText(R.l.dQo);
            } else {
                this.kif.setText(this.ppi.poS);
            }
        } else if (this.ppD == a.ppJ) {
            this.kif.setText("");
        } else if (this.ppD == a.ppK) {
            this.kif.setText(R.l.eVc);
        }
    }

    private void bbf() {
        int dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R.f.baZ);
        Drawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) dimensionPixelOffset, (float) dimensionPixelOffset, (float) dimensionPixelOffset, (float) dimensionPixelOffset, 0.0f, 0.0f, 0.0f, 0.0f}, null, null));
        shapeDrawable.getPaint().setColor(com.tencent.mm.plugin.shake.c.c.a.ta(this.ppi.hib));
        this.pps.setBackgroundDrawable(shapeDrawable);
        bbe();
        if (!TextUtils.isEmpty(this.ppi.poQ)) {
            this.ppm.setText(this.ppi.poQ);
        }
        if (!TextUtils.isEmpty(this.ppi.poU)) {
            this.ppn.setText(this.ppi.poU);
            this.ppn.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.ppi.poR)) {
            this.ppo.setText(this.ppi.poR);
            this.ppo.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.ppi.kdG)) {
            dimensionPixelOffset = getContext().getResources().getDimensionPixelSize(R.f.baY);
            ImageView imageView = this.kie;
            String str = this.ppi.kdG;
            int i = R.k.dzv;
            if (!(imageView == null || TextUtils.isEmpty(str))) {
                if (TextUtils.isEmpty(str)) {
                    imageView.setImageResource(i);
                } else {
                    com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
                    aVar.hIO = e.hgu;
                    n.GX();
                    aVar.hJg = null;
                    aVar.hIN = String.format("%s/%s", new Object[]{kfw, com.tencent.mm.a.g.n(str.getBytes())});
                    aVar.hIL = true;
                    aVar.hJi = true;
                    aVar.hIJ = true;
                    aVar.hIS = dimensionPixelOffset;
                    aVar.hIR = dimensionPixelOffset;
                    aVar.hJa = i;
                    n.GW().a(str, imageView, aVar.Hg());
                }
            }
        }
        if (!TextUtils.isEmpty(this.ppi.title)) {
            this.ppt.setText(this.ppi.title);
        }
        if (!TextUtils.isEmpty(this.ppi.keT)) {
            this.ppu.setText(this.ppi.keT);
        }
        if (this.ppi.kdL > 0) {
            this.ppv.setText(getContext().getString(R.l.dSt, new Object[]{com.tencent.mm.plugin.shake.c.c.a.aq((long) this.ppi.kdL)}));
        }
        if (this.ppD == a.ppL) {
            this.ppp.setVisibility(0);
        } else {
            this.ppp.setVisibility(8);
        }
    }

    public static a a(Context context, com.tencent.mm.plugin.shake.c.a.e eVar, OnCancelListener onCancelListener, b bVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        a aVar = new a(context);
        aVar.setOnCancelListener(onCancelListener);
        aVar.setCancelable(true);
        aVar.ppi = eVar;
        if (aVar.ppi == null) {
            w.e("MicroMsg.ShakeCardDialog", "updateView() mCardItem == null");
        } else {
            if (TextUtils.isEmpty(aVar.ppi.title)) {
                aVar.ppm.setText(aVar.ppi.title);
            }
            w.i("MicroMsg.ShakeCardDialog", "updateView() action_type is has card");
            aVar.ppD = a.ppI;
            aVar.bbd();
            aVar.bbf();
            if (aVar.ppB == 0) {
                aVar.ppl.setBackgroundResource(R.g.bjy);
                aVar.ppr.setBackgroundResource(R.g.bjz);
                aVar.ppm.setTextColor(aVar.Cu.getColor(R.e.black));
                aVar.ppn.setTextColor(aVar.Cu.getColor(R.e.aVi));
                aVar.ppo.setTextColor(aVar.Cu.getColor(R.e.aVi));
                aVar.oRV.setTextColor(aVar.getContext().getResources().getColor(R.e.black));
                aVar.kif.setBackgroundResource(R.g.bda);
                aVar.kif.setTextColor(aVar.getContext().getResources().getColor(R.e.white));
                aVar.ppp.setTextColor(aVar.getContext().getResources().getColor(R.e.aVk));
            }
        }
        aVar.ppE = bVar;
        aVar.show();
        com.tencent.mm.ui.base.g.a(context, aVar);
        return aVar;
    }
}
