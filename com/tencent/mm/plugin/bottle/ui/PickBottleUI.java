package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.modelbiz.l;
import com.tencent.mm.plugin.bottle.a.h.a;
import com.tencent.mm.plugin.bottle.a.h.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.h;

public class PickBottleUI extends FrameLayout implements OnClickListener, OnTouchListener {
    float density;
    ae handler = new ae();
    private boolean hasInit = false;
    SprayLayout jXA;
    PickedBottleImageView jXB;
    ImageView jXC;
    private b jXD;
    Runnable jXE = new Runnable(this) {
        final /* synthetic */ PickBottleUI jXH;

        {
            this.jXH = r1;
        }

        public final void run() {
            this.jXH.jXD = new b();
            this.jXH.jXD.a(new a(this) {
                final /* synthetic */ AnonymousClass1 jXI;

                {
                    this.jXI = r1;
                }

                public final void bG(int i, int i2) {
                    if (this.jXI.jXH.jXA != null && this.jXI.jXH.jXB != null) {
                        this.jXI.jXH.jXA.stop();
                        if (i2 == -2002) {
                            this.jXI.jXH.jXD = null;
                            this.jXI.jXH.jXf.jU(0);
                            this.jXI.jXH.jXf.jT(R.l.dPi);
                        }
                        if (this.jXI.jXH.jXD == null) {
                            return;
                        }
                        if (i == 0 && i2 == 0 && this.jXI.jXH.jXD.jUZ != -10001) {
                            if (19990 == this.jXI.jXH.jXD.jUZ) {
                                l.b(this.jXI.jXH.jXD.jVk, this.jXI.jXH.jXD.iconUrl, R.g.bhR);
                            }
                            this.jXI.jXH.jXB.jXp = this.jXI.jXH.jXD.jVe;
                            this.jXI.jXH.jXB.jVk = this.jXI.jXH.jXD.jVk;
                            this.jXI.jXH.jXB.iconUrl = this.jXI.jXH.jXD.iconUrl;
                            this.jXI.jXH.jXB.density = this.jXI.jXH.density;
                            this.jXI.jXH.jXB.show(this.jXI.jXH.jXD.jUZ);
                            this.jXI.jXH.jXC.setVisibility(0);
                            this.jXI.jXH.jXD = null;
                            return;
                        }
                        this.jXI.jXH.jXB.jXp = null;
                        this.jXI.jXH.jXB.show(-10001);
                        this.jXI.jXH.handler.postDelayed(this.jXI.jXH.jXF, 2000);
                    }
                }
            });
        }
    };
    Runnable jXF = new Runnable(this) {
        final /* synthetic */ PickBottleUI jXH;

        {
            this.jXH = r1;
        }

        public final void run() {
            if (this.jXH.jXB != null && this.jXH.jXB.isShown()) {
                this.jXH.jXf.jU(0);
            }
        }
    };
    float jXG;
    BottleBeachUI jXf;
    float jzV;

    public PickBottleUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jXf = (BottleBeachUI) context;
    }

    public PickBottleUI(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jXf = (BottleBeachUI) context;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        KC();
    }

    public final void KC() {
        if (!this.hasInit) {
            this.jXB = (PickedBottleImageView) findViewById(R.h.bur);
            this.jXA = (SprayLayout) this.jXf.findViewById(R.h.buu);
            this.jXC = (ImageView) this.jXf.findViewById(R.h.btV);
            this.jXB.setOnClickListener(this);
            if (!bg.bJR()) {
                setBackgroundResource(R.g.bcO);
            }
            setOnClickListener(this);
            setOnTouchListener(this);
            this.hasInit = true;
        }
    }

    public void setVisibility(int i) {
        this.jXA.setVisibility(i);
        this.jXB.setVisibility(8);
        super.setVisibility(i);
    }

    public void onClick(View view) {
        if (R.h.bur == view.getId()) {
            if (this.jXB.jXp != null) {
                ap.yY();
                c.wW().Ro(this.jXB.jXp);
                ap.yY();
                aj Rm = c.wW().Rm("floatbottle");
                if (!(Rm == null || bg.mA(Rm.field_username))) {
                    Rm.dt(h.xI());
                    ap.yY();
                    c.wW().a(Rm, Rm.field_username);
                }
            }
            this.jXf.onClick(view);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.jXG = motionEvent.getX();
            this.jzV = motionEvent.getY();
        } else if (action == 1) {
            boolean z;
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            action = getHeight();
            int width = getWidth();
            action = (action * 550) / 800;
            int i = (width - ((width * 120) / 480)) / 2;
            width -= i;
            if (y > ((float) action)) {
                z = true;
            } else if (x < ((float) i) - ((((float) i) * y) / ((float) action))) {
                z = true;
            } else {
                z = x > ((((float) i) * y) / ((float) action)) + ((float) width);
            }
            if (z) {
                if (!this.jXB.isShown()) {
                    if (this.jXD != null) {
                        Object obj = this.jXD;
                        ap.vd().b(155, obj);
                        ap.vd().b(156, obj);
                        ap.vd().c(obj.jVl);
                        this.jXD = null;
                    }
                    this.handler.removeCallbacks(this.jXE);
                    this.handler.removeCallbacks(this.jXF);
                    this.jXf.jU(0);
                } else if (this.jXB.jXp == null) {
                    this.jXf.jU(0);
                }
            } else if (n(x, y) && n(this.jXG, this.jzV)) {
                if (this.jXB.jXp != null) {
                    ap.yY();
                    c.wW().Ro(this.jXB.jXp);
                    ap.yY();
                    aj Rm = c.wW().Rm("floatbottle");
                    if (!(Rm == null || bg.mA(Rm.field_username))) {
                        Rm.dt(h.xI());
                        ap.yY();
                        c.wW().a(Rm, Rm.field_username);
                    }
                }
                this.jXf.onClick(this.jXB);
            }
        }
        return true;
    }

    private boolean n(float f, float f2) {
        int height = getHeight();
        int width = getWidth();
        int i = (width * 180) / 480;
        int i2 = (height * 75) / 800;
        float f3 = f - ((float) ((width * 240) / 480));
        float f4 = f2 - ((float) ((height * 495) / 800));
        if (((f4 * f4) / ((float) (i2 * i2))) + ((f3 * f3) / ((float) (i * i))) <= 1.0f) {
            return true;
        }
        return false;
    }
}
