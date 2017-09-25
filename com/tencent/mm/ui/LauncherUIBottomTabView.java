package com.tencent.mm.ui;

import android.content.Context;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.is;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.tools.s;
import com.tencent.smtt.sdk.WebView;

public class LauncherUIBottomTabView extends RelativeLayout implements c {
    protected int lzi = 0;
    private long mDk = 0;
    private com.tencent.mm.ui.c.a uRT;
    protected a uRU;
    protected a uRV;
    protected a uRW;
    protected a uRX;
    private int uRY = 0;
    private int uRZ;
    private int uSa;
    private int uSb;
    private int uSc = 0;
    private int uSd;
    private int uSe;
    private int uSf;
    private int uSg;
    private int uSh;
    private int uSi;
    private int uSj = -1;
    private int uSk = 0;
    protected OnClickListener uSl = new OnClickListener(this) {
        private final long qqS = 300;
        final /* synthetic */ LauncherUIBottomTabView uSt;

        {
            this.uSt = r3;
        }

        public final void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.uSt.uSj == intValue && intValue == 0 && System.currentTimeMillis() - this.uSt.mDk <= 300) {
                w.v("MicroMsg.LauncherUITabView", "onMainTabDoubleClick");
                this.uSt.uSm.removeMessages(0);
                com.tencent.mm.sdk.b.a.urY.m(new is());
                this.uSt.mDk = System.currentTimeMillis();
                this.uSt.uSj = intValue;
                return;
            }
            if (this.uSt.uRT != null) {
                if (intValue == 0 && this.uSt.uSj == 0) {
                    w.v("MicroMsg.LauncherUITabView", "do double click check");
                    this.uSt.uSm.sendEmptyMessageDelayed(0, 300);
                } else {
                    w.v("MicroMsg.LauncherUITabView", "directly dispatch tab click event");
                    this.uSt.mDk = System.currentTimeMillis();
                    this.uSt.uSj = intValue;
                    this.uSt.uRT.lK(intValue);
                    return;
                }
            }
            this.uSt.mDk = System.currentTimeMillis();
            this.uSt.uSj = intValue;
            w.w("MicroMsg.LauncherUITabView", "on tab click, index %d, but listener is null", (Integer) view.getTag());
        }
    };
    private ae uSm = new ae(this) {
        final /* synthetic */ LauncherUIBottomTabView uSt;

        {
            this.uSt = r1;
        }

        public final void handleMessage(Message message) {
            w.v("MicroMsg.LauncherUITabView", "onMainTabClick");
            this.uSt.uRT.lK(0);
        }
    };
    private int uSn = 0;
    private int uSo = 0;
    private int uSp = 0;
    private boolean uSq = false;
    private int uSr = 0;
    private boolean uSs = false;

    protected class a {
        final /* synthetic */ LauncherUIBottomTabView uSt;
        View uSu;
        TabIconView uSv;
        TextView uSw;
        TextView uSx;
        ImageView uSy;

        protected a(LauncherUIBottomTabView launcherUIBottomTabView) {
            this.uSt = launcherUIBottomTabView;
        }
    }

    public LauncherUIBottomTabView(Context context) {
        super(context);
        init();
    }

    public LauncherUIBottomTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public LauncherUIBottomTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public final void a(com.tencent.mm.ui.c.a aVar) {
        this.uRT = aVar;
    }

    private a a(int i, ViewGroup viewGroup) {
        a aVar = new a(this);
        aVar.uSu = r.eC(getContext()).inflate(R.i.dix, viewGroup, false);
        if (com.tencent.mm.bg.a.dM(getContext())) {
            aVar.uSu = r.eC(getContext()).inflate(R.i.diy, viewGroup, false);
        } else {
            aVar.uSu = r.eC(getContext()).inflate(R.i.dix, viewGroup, false);
        }
        aVar.uSv = (TabIconView) aVar.uSu.findViewById(R.h.bWx);
        aVar.uSw = (TextView) aVar.uSu.findViewById(R.h.bWz);
        aVar.uSx = (TextView) aVar.uSu.findViewById(R.h.cKK);
        aVar.uSx.setBackgroundResource(s.fg(getContext()));
        aVar.uSy = (ImageView) aVar.uSu.findViewById(R.h.bJV);
        aVar.uSu.setTag(Integer.valueOf(i));
        aVar.uSu.setOnClickListener(this.uSl);
        aVar.uSw.setTextSize(0, ((float) com.tencent.mm.bg.a.U(getContext(), R.f.aXW)) * com.tencent.mm.bg.a.dK(getContext()));
        return aVar;
    }

    private void init() {
        ViewGroup linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        addView(linearLayout, new LayoutParams(-1, -2));
        this.uSk = (int) (((float) com.tencent.mm.bg.a.U(getContext(), R.f.aWT)) * com.tencent.mm.bg.a.dK(getContext()));
        a a = a(0, linearLayout);
        a.uSu.setId(-16777215);
        a.uSw.setText(R.l.cgW);
        a.uSw.setTextColor(getResources().getColor(R.e.aVh));
        a.uSv.g(R.k.dxT, R.k.dxU, R.k.dxV, com.tencent.mm.bg.a.dM(getContext()));
        a.uSx.setVisibility(4);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, this.uSk);
        layoutParams.weight = 1.0f;
        linearLayout.addView(a.uSu, layoutParams);
        this.uRU = a;
        a = a(1, linearLayout);
        a.uSu.setId(-16777214);
        a.uSw.setText(R.l.eyP);
        a.uSw.setTextColor(getResources().getColor(R.e.aVi));
        a.uSv.g(R.k.dxQ, R.k.dxR, R.k.dxS, com.tencent.mm.bg.a.dM(getContext()));
        a.uSx.setVisibility(4);
        layoutParams = new LinearLayout.LayoutParams(0, this.uSk);
        layoutParams.weight = 1.0f;
        linearLayout.addView(a.uSu, layoutParams);
        this.uRW = a;
        a = a(2, linearLayout);
        a.uSu.setId(-16777213);
        a.uSw.setText(R.l.eyN);
        a.uSw.setTextColor(getResources().getColor(R.e.aVi));
        a.uSv.g(R.k.dxW, R.k.dxX, R.k.dxY, com.tencent.mm.bg.a.dM(getContext()));
        a.uSx.setVisibility(4);
        layoutParams = new LinearLayout.LayoutParams(0, this.uSk);
        layoutParams.weight = 1.0f;
        linearLayout.addView(a.uSu, layoutParams);
        this.uRV = a;
        a = a(3, linearLayout);
        a.uSu.setId(-16777212);
        a.uSw.setText(R.l.ezn);
        a.uSw.setTextColor(getResources().getColor(R.e.aVi));
        a.uSv.g(R.k.dxZ, R.k.dya, R.k.dyb, com.tencent.mm.bg.a.dM(getContext()));
        a.uSx.setVisibility(4);
        layoutParams = new LinearLayout.LayoutParams(0, this.uSk);
        layoutParams.weight = 1.0f;
        linearLayout.addView(a.uSu, layoutParams);
        this.uRX = a;
        this.uRY = getResources().getColor(R.e.aVh);
        this.uRZ = (this.uRY & 16711680) >> 16;
        this.uSa = (this.uRY & 65280) >> 8;
        this.uSb = this.uRY & 255;
        this.uSc = getResources().getColor(R.e.aVi);
        this.uSd = (this.uSc & 16711680) >> 16;
        this.uSe = (this.uSc & 65280) >> 8;
        this.uSf = this.uSc & 255;
        this.uSg = this.uRZ - this.uSd;
        this.uSh = this.uSa - this.uSe;
        this.uSi = this.uSb - this.uSf;
    }

    public final void yV(int i) {
        w.d("MicroMsg.LauncherUITabView", "updateMainTabUnread %d", Integer.valueOf(i));
        this.uSn = i;
        if (i <= 0) {
            this.uRU.uSx.setText("");
            this.uRU.uSx.setVisibility(4);
        } else if (i > 99) {
            this.uRU.uSx.setText(getContext().getString(R.l.eYP));
            this.uRU.uSx.setVisibility(0);
            this.uRU.uSy.setVisibility(4);
        } else {
            this.uRU.uSx.setText(String.valueOf(i));
            this.uRU.uSx.setVisibility(0);
            this.uRU.uSy.setVisibility(4);
        }
    }

    public final void bOy() {
        if (this.uRU != null && this.uRW != null && this.uRV != null) {
        }
    }

    public final void yW(int i) {
        this.uSo = i;
        if (i <= 0) {
            this.uRW.uSx.setText("");
            this.uRW.uSx.setVisibility(4);
        } else if (i > 99) {
            this.uRW.uSx.setText(getContext().getString(R.l.eYP));
            this.uRW.uSx.setVisibility(0);
            this.uRW.uSy.setVisibility(4);
        } else {
            this.uRW.uSx.setText(String.valueOf(i));
            this.uRW.uSx.setVisibility(0);
            this.uRW.uSy.setVisibility(4);
        }
    }

    public final void yX(int i) {
        this.uSp = i;
        if (i <= 0) {
            this.uRV.uSx.setText("");
            this.uRV.uSx.setVisibility(4);
        } else if (i > 99) {
            this.uRV.uSx.setText(getContext().getString(R.l.eYP));
            this.uRV.uSx.setVisibility(0);
            this.uRV.uSy.setVisibility(4);
        } else {
            this.uRV.uSx.setText(String.valueOf(i));
            this.uRV.uSx.setVisibility(0);
            this.uRV.uSy.setVisibility(4);
        }
    }

    public final void ke(boolean z) {
        int i = 4;
        this.uSq = z;
        this.uRV.uSx.setVisibility(4);
        ImageView imageView = this.uRV.uSy;
        if (z) {
            i = 0;
        }
        imageView.setVisibility(i);
    }

    public final void yY(int i) {
        this.uSr = i;
        if (i <= 0) {
            this.uRX.uSx.setText("");
            this.uRX.uSx.setVisibility(4);
        } else if (i > 99) {
            this.uRX.uSx.setText(getContext().getString(R.l.eYP));
            this.uRX.uSx.setVisibility(0);
            this.uRX.uSy.setVisibility(4);
        } else {
            this.uRX.uSx.setText(String.valueOf(i));
            this.uRX.uSx.setVisibility(0);
            this.uRX.uSy.setVisibility(4);
        }
    }

    public final void kf(boolean z) {
        int i = 4;
        this.uSs = z;
        this.uRX.uSx.setVisibility(4);
        ImageView imageView = this.uRX.uSy;
        if (z) {
            i = 0;
        }
        imageView.setVisibility(i);
    }

    public final void i(int i, float f) {
        int i2 = (int) (255.0f * f);
        int i3 = 255 - i2;
        int i4 = (((((int) ((((float) this.uSg) * f) + ((float) this.uSd))) << 16) + (((int) ((((float) this.uSh) * f) + ((float) this.uSe))) << 8)) + ((int) ((((float) this.uSi) * f) + ((float) this.uSf)))) + WebView.NIGHT_MODE_COLOR;
        int i5 = (((((int) ((((float) this.uSg) * (1.0f - f)) + ((float) this.uSd))) << 16) + (((int) ((((float) this.uSh) * (1.0f - f)) + ((float) this.uSe))) << 8)) + ((int) ((((float) this.uSi) * (1.0f - f)) + ((float) this.uSf)))) + WebView.NIGHT_MODE_COLOR;
        switch (i) {
            case 0:
                this.uRU.uSv.zy(i3);
                this.uRW.uSv.zy(i2);
                this.uRU.uSw.setTextColor(i5);
                this.uRW.uSw.setTextColor(i4);
                return;
            case 1:
                this.uRW.uSv.zy(i3);
                this.uRV.uSv.zy(i2);
                this.uRW.uSw.setTextColor(i5);
                this.uRV.uSw.setTextColor(i4);
                return;
            case 2:
                this.uRV.uSv.zy(i3);
                this.uRX.uSv.zy(i2);
                this.uRV.uSw.setTextColor(i5);
                this.uRX.uSw.setTextColor(i4);
                return;
            default:
                return;
        }
    }

    public final int bOF() {
        return this.lzi;
    }

    public final void lJ(int i) {
        this.lzi = i;
        switch (i) {
            case 0:
                this.uRU.uSv.zy(255);
                this.uRV.uSv.zy(0);
                this.uRW.uSv.zy(0);
                this.uRX.uSv.zy(0);
                this.uRU.uSw.setTextColor(this.uRY);
                this.uRV.uSw.setTextColor(this.uSc);
                this.uRW.uSw.setTextColor(this.uSc);
                this.uRX.uSw.setTextColor(this.uSc);
                break;
            case 1:
                this.uRU.uSv.zy(0);
                this.uRV.uSv.zy(0);
                this.uRW.uSv.zy(255);
                this.uRX.uSv.zy(0);
                this.uRU.uSw.setTextColor(this.uSc);
                this.uRV.uSw.setTextColor(this.uSc);
                this.uRW.uSw.setTextColor(this.uRY);
                this.uRX.uSw.setTextColor(this.uSc);
                break;
            case 2:
                this.uRU.uSv.zy(0);
                this.uRV.uSv.zy(255);
                this.uRW.uSv.zy(0);
                this.uRX.uSv.zy(0);
                this.uRU.uSw.setTextColor(this.uSc);
                this.uRV.uSw.setTextColor(this.uRY);
                this.uRW.uSw.setTextColor(this.uSc);
                this.uRX.uSw.setTextColor(this.uSc);
                break;
            case 3:
                this.uRU.uSv.zy(0);
                this.uRV.uSv.zy(0);
                this.uRW.uSv.zy(0);
                this.uRX.uSv.zy(255);
                this.uRU.uSw.setTextColor(this.uSc);
                this.uRV.uSw.setTextColor(this.uSc);
                this.uRW.uSw.setTextColor(this.uSc);
                this.uRX.uSw.setTextColor(this.uRY);
                break;
        }
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
