package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.e.a.is;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;

public class LauncherUITabView extends RelativeLayout implements c {
    protected int lzi = 0;
    private long mDk = 0;
    private Matrix npi = new Matrix();
    private com.tencent.mm.ui.c.a uRT;
    private int uSB;
    private Bitmap uSC;
    private ImageView uSD;
    protected a uSE;
    protected a uSF;
    protected a uSG;
    protected a uSH;
    private int uSj = -1;
    protected OnClickListener uSl = new OnClickListener(this) {
        private final long qqS = 300;
        final /* synthetic */ LauncherUITabView uSI;

        {
            this.uSI = r3;
        }

        public final void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.uSI.uSj == intValue && intValue == 0 && System.currentTimeMillis() - this.uSI.mDk <= 300) {
                w.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
                this.uSI.uSm.removeMessages(0);
                com.tencent.mm.sdk.b.a.urY.m(new is());
                this.uSI.mDk = System.currentTimeMillis();
                this.uSI.uSj = intValue;
                return;
            }
            if (this.uSI.uRT != null) {
                if (intValue == 0 && this.uSI.uSj == 0) {
                    this.uSI.uSm.sendEmptyMessageDelayed(0, 300);
                } else {
                    this.uSI.mDk = System.currentTimeMillis();
                    this.uSI.uSj = intValue;
                    this.uSI.uRT.lK(intValue);
                    return;
                }
            }
            this.uSI.mDk = System.currentTimeMillis();
            this.uSI.uSj = intValue;
            w.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", new Object[]{(Integer) view.getTag()});
        }
    };
    private ae uSm = new ae(this) {
        final /* synthetic */ LauncherUITabView uSI;

        {
            this.uSI = r1;
        }

        public final void handleMessage(Message message) {
            w.v("MicroMsg.LauncherUITabView", "onMainTabClick");
            this.uSI.uRT.lK(0);
        }
    };
    private int uSn = 0;
    private int uSo = 0;
    private int uSp = 0;
    private boolean uSq = false;
    private int uSr = 0;
    private boolean uSs = false;

    protected class a {
        final /* synthetic */ LauncherUITabView uSI;
        MMTabView uSJ;

        protected a(LauncherUITabView launcherUITabView) {
            this.uSI = launcherUITabView;
        }
    }

    public LauncherUITabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LauncherUITabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public final void a(com.tencent.mm.ui.c.a aVar) {
        this.uRT = aVar;
    }

    private a ze(int i) {
        a aVar = new a(this);
        aVar.uSJ = new MMTabView(getContext(), i);
        aVar.uSJ.setTag(Integer.valueOf(i));
        aVar.uSJ.setOnClickListener(this.uSl);
        return aVar;
    }

    private void init() {
        View linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundResource(R.e.white);
        linearLayout.setId(2307141);
        linearLayout.setOrientation(0);
        addView(linearLayout, new LayoutParams(-1, -2));
        this.uSD = new ImageView(getContext());
        this.uSD.setImageMatrix(this.npi);
        this.uSD.setScaleType(ScaleType.MATRIX);
        this.uSD.setId(2307142);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, com.tencent.mm.bg.a.fromDPToPix(getContext(), 3));
        layoutParams.addRule(8, 2307141);
        addView(this.uSD, layoutParams);
        a ze = ze(0);
        ze.uSJ.setText(R.l.eyO);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.bbj));
        layoutParams2.weight = 1.0f;
        linearLayout.addView(ze.uSJ, layoutParams2);
        this.uSE = ze;
        ze = ze(1);
        ze.uSJ.setText(R.l.eyP);
        layoutParams2 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.bbj));
        layoutParams2.weight = 1.0f;
        linearLayout.addView(ze.uSJ, layoutParams2);
        this.uSF = ze;
        ze = ze(2);
        ze.uSJ.setText(R.l.eyN);
        layoutParams2 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.bbj));
        layoutParams2.weight = 1.0f;
        linearLayout.addView(ze.uSJ, layoutParams2);
        this.uSG = ze;
        ze = ze(3);
        ze.uSJ.setText(R.l.ezn);
        layoutParams2 = new LinearLayout.LayoutParams(0, getResources().getDimensionPixelSize(R.f.bbj));
        layoutParams2.weight = 1.0f;
        linearLayout.addView(ze.uSJ, layoutParams2);
        this.uSH = ze;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        w.d("MicroMsg.LauncherUITabView", "on layout, width %d", new Object[]{Integer.valueOf(i3 - i)});
        this.uSB = (i3 - i) / 4;
        int i5 = this.uSB;
        if (this.uSC == null || this.uSC.getWidth() != i5) {
            String str = "MicroMsg.LauncherUITabView";
            String str2 = "sharp width changed, from %d to %d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.uSC == null ? -1 : this.uSC.getWidth());
            objArr[1] = Integer.valueOf(i5);
            w.w(str, str2, objArr);
            this.uSC = Bitmap.createBitmap(i5, com.tencent.mm.bg.a.fromDPToPix(getContext(), 3), Config.ARGB_8888);
            new Canvas(this.uSC).drawColor(getResources().getColor(R.e.aWu));
            i(this.lzi, 0.0f);
            this.uSD.setImageBitmap(this.uSC);
        }
        lJ(this.lzi);
    }

    public final void yV(int i) {
        w.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", new Object[]{Integer.valueOf(i)});
        this.uSn = i;
        if (i <= 0) {
            this.uSE.uSJ.SH(null);
        } else if (i > 99) {
            this.uSE.uSJ.SH(getContext().getString(R.l.eYP));
        } else {
            this.uSE.uSJ.SH(String.valueOf(i));
        }
    }

    public final void bOy() {
        if (this.uSE != null && this.uSF != null && this.uSG != null && this.uSH != null) {
            this.uSE.uSJ.bQq();
            this.uSF.uSJ.bQq();
            this.uSG.uSJ.bQq();
            this.uSH.uSJ.bQq();
        }
    }

    public final void yW(int i) {
        this.uSo = i;
        if (i <= 0) {
            this.uSF.uSJ.SH(null);
        } else if (i > 99) {
            this.uSF.uSJ.SH(getContext().getString(R.l.eYP));
        } else {
            this.uSF.uSJ.SH(String.valueOf(i));
        }
    }

    public final void yX(int i) {
        this.uSp = i;
        if (i <= 0) {
            this.uSG.uSJ.SH(null);
        } else if (i > 99) {
            this.uSG.uSJ.SH(getContext().getString(R.l.eYP));
        } else {
            this.uSG.uSJ.SH(String.valueOf(i));
        }
    }

    public final void yY(int i) {
        this.uSr = i;
        if (i <= 0) {
            this.uSH.uSJ.SH(null);
        } else if (i > 99) {
            this.uSH.uSJ.SH(getContext().getString(R.l.eYP));
        } else {
            this.uSH.uSJ.SH(String.valueOf(i));
        }
    }

    public final void ke(boolean z) {
        this.uSq = z;
        this.uSG.uSJ.kz(z);
    }

    public final void kf(boolean z) {
        this.uSs = z;
        this.uSH.uSJ.kz(z);
    }

    public final void i(int i, float f) {
        this.npi.setTranslate(((float) this.uSB) * (((float) i) + f), 0.0f);
        this.uSD.setImageMatrix(this.npi);
    }

    public final int bOF() {
        return this.lzi;
    }

    public final void lJ(int i) {
        this.lzi = i;
        this.uSE.uSJ.setTextColor(i == 0 ? getResources().getColorStateList(R.e.aWu) : getResources().getColorStateList(R.e.aUw));
        this.uSF.uSJ.setTextColor(i == 1 ? getResources().getColorStateList(R.e.aWu) : getResources().getColorStateList(R.e.aUw));
        this.uSG.uSJ.setTextColor(i == 2 ? getResources().getColorStateList(R.e.aWu) : getResources().getColorStateList(R.e.aUw));
        this.uSH.uSJ.setTextColor(i == 3 ? getResources().getColorStateList(R.e.aWu) : getResources().getColorStateList(R.e.aUw));
        this.mDk = System.currentTimeMillis();
        this.uSj = this.lzi;
    }

    public final int bOz() {
        return this.uSn;
    }

    public final int bOA() {
        return this.uSo;
    }

    public final int bOB() {
        return this.uSp;
    }

    public final int bOC() {
        return this.uSr;
    }

    public final boolean bOD() {
        return this.uSq;
    }

    public final boolean bOE() {
        return this.uSs;
    }
}
