package com.tencent.mm.plugin.bottle.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.media.ToneGenerator;
import android.os.Message;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.bottle.a.h.a;
import com.tencent.mm.plugin.bottle.a.h.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.h;

public class ThrowBottleUI extends FrameLayout implements OnClickListener, a {
    private static final int[] jYx = new int[]{0, 9, 18, 27, 37, 46, 55, 64, 74, 85, 93, 100};
    private static final int[] jYy = new int[]{R.g.bbN, R.g.bbQ, R.g.bbR, R.g.bbS, R.g.bbT, R.g.bbU, R.g.bbV, R.g.bbW, R.g.bbX, R.g.bbO, R.g.bbP};
    ae handler = new ae();
    ImageView jXC;
    BottleBeachUI jXf;
    ToneGenerator jYA;
    private long jYB = -1;
    Toast jYC;
    Vibrator jYD;
    ThrowBottleAnimUI jYE;
    AnimationDrawable jYF;
    ImageView jYG;
    TextView jYH;
    ImageView jYI;
    MMEditText jYJ;
    View jYK;
    Button jYL;
    ImageButton jYM;
    ThrowBottleFooter jYN;
    boolean jYO = false;
    boolean jYP;
    LayoutParams jYQ = null;
    private int jYR = 0;
    int jYS = 0;
    private ThrowBottleAnimUI.a jYT = new ThrowBottleAnimUI.a(this) {
        final /* synthetic */ ThrowBottleUI jYZ;

        {
            this.jYZ = r1;
        }

        public final void adN() {
            this.jYZ.jYE.setVisibility(8);
            this.jYZ.jXf.jU(0);
        }
    };
    final aj jYU = new aj(new aj.a(this) {
        final /* synthetic */ ThrowBottleUI jYZ;

        {
            this.jYZ = r1;
        }

        public final boolean oQ() {
            int i = 0;
            if (this.jYZ.jYz == null) {
                w.w("MM.Bottle.ThrowBottleUI", "bottle recder is null");
                return false;
            }
            int maxAmplitude = this.jYZ.jYz.getMaxAmplitude();
            while (i < ThrowBottleUI.jYy.length) {
                if (maxAmplitude >= ThrowBottleUI.jYx[i] && maxAmplitude < ThrowBottleUI.jYx[i + 1]) {
                    this.jYZ.jYG.setBackgroundDrawable(com.tencent.mm.bg.a.a(this.jYZ.jXf, ThrowBottleUI.jYy[i]));
                    break;
                }
                i++;
            }
            return true;
        }
    }, true);
    final aj jYV = new aj(new aj.a(this) {
        int count = 0;
        final /* synthetic */ ThrowBottleUI jYZ;

        {
            this.jYZ = r2;
        }

        public final boolean oQ() {
            if (this.jYZ.jYB == -1) {
                this.jYZ.jYB = bg.NA();
            }
            if (this.count % 3 == 2) {
                this.jYZ.jYH.setWidth(this.jYZ.jYH.getWidth() + 1);
            }
            this.count++;
            this.count %= 3;
            long aB = bg.aB(this.jYZ.jYB);
            if (aB >= 50000 && aB <= 60000) {
                int i;
                if (this.jYZ.jYC == null) {
                    i = (int) ((60000 - aB) / 1000);
                    this.jYZ.jYC = Toast.makeText(this.jYZ.jXf, this.jYZ.jXf.getResources().getQuantityString(R.j.dsh, i, new Object[]{Integer.valueOf(i)}), 0);
                } else {
                    i = (int) ((60000 - aB) / 1000);
                    this.jYZ.jYC.setText(this.jYZ.jXf.getResources().getQuantityString(R.j.dsh, i, new Object[]{Integer.valueOf(i)}));
                }
                this.jYZ.jYC.show();
            }
            if (aB < 60000) {
                return true;
            }
            w.v("MM.Bottle.ThrowBottleUI", "bottle record stop on countdown");
            this.jYZ.jYP = true;
            this.jYZ.adW();
            this.jYZ.jYO = false;
            aq.B(this.jYZ.jXf, R.l.eYh);
            return false;
        }
    }, true);
    boolean jYW = false;
    @SuppressLint({"HandlerLeak"})
    private final ae jYX = new ae(this) {
        final /* synthetic */ ThrowBottleUI jYZ;

        {
            this.jYZ = r1;
        }

        public final void handleMessage(Message message) {
            super.handleMessage(message);
            this.jYZ.jYL.setBackgroundDrawable(com.tencent.mm.bg.a.a(this.jYZ.jXf, R.g.biZ));
            this.jYZ.jYL.setEnabled(true);
        }
    };
    final h.a jYY = new h.a(this) {
        final /* synthetic */ ThrowBottleUI jYZ;

        {
            this.jYZ = r1;
        }

        public final void onError() {
            this.jYZ.jYz.reset();
            this.jYZ.jYU.KH();
            this.jYZ.jYV.KH();
            ad.Pu("keep_app_silent");
            this.jYZ.jYO = false;
            w.v("MM.Bottle.ThrowBottleUI", "bottle record stop on error");
            Toast.makeText(this.jYZ.jXf, this.jYZ.jXf.getString(R.l.dVh), 0).show();
        }
    };
    boolean jYt = true;
    d jYz;

    public ThrowBottleUI(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jXf = (BottleBeachUI) context;
    }

    public void setVisibility(int i) {
        this.jXC.setVisibility(8);
        if (i == 0) {
            this.jYt = true;
            this.jYG.setVisibility(8);
            this.jYH.setVisibility(8);
            this.jYH.setWidth(b.a(this.jXf, 120.0f));
            this.jYI.setVisibility(0);
            ((View) this.jYJ.getParent()).setVisibility(8);
            this.jYJ.setText("");
            this.jYN.setVisibility(0);
            c.d(this.jYJ).Ch(com.tencent.mm.i.b.sw()).a(null);
            this.jYM.setImageDrawable(com.tencent.mm.bg.a.a(this.jXf, R.g.beg));
            this.jYL.setBackgroundDrawable(com.tencent.mm.bg.a.a(this.jXf, R.g.biZ));
            this.jYL.setText(this.jYt ? R.l.dPE : R.l.dPB);
            ((LinearLayout) this.jXf.findViewById(R.h.buF)).setVisibility(0);
            this.jXf.getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        } else {
            this.jXf.getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        super.setVisibility(i);
    }

    public void onClick(View view) {
        if (R.h.btQ != view.getId()) {
            this.jXf.jU(0);
        } else if (this.jYt || this.jYJ.getText().toString().trim().length() <= 0) {
            adU();
        } else {
            g.a(this.jXf, getResources().getString(R.l.dPy), null, getResources().getString(R.l.dPz), new g.c(this) {
                final /* synthetic */ ThrowBottleUI jYZ;

                {
                    this.jYZ = r1;
                }

                public final void hq(int i) {
                    if (i == 0) {
                        this.jYZ.jYJ.setText("");
                        this.jYZ.adU();
                    }
                }
            }, null);
        }
    }

    private void adU() {
        boolean z;
        int i = 8;
        this.jYH.setVisibility(8);
        this.jYI.setVisibility(this.jYt ? 8 : 0);
        View view = (View) this.jYJ.getParent();
        if (this.jYt) {
            i = 0;
        }
        view.setVisibility(i);
        if (this.jYt) {
            this.jYJ.requestFocus();
        }
        if (this.jYt) {
            z = false;
        } else {
            z = true;
        }
        this.jYt = z;
        this.jYM.setImageDrawable(this.jYt ? com.tencent.mm.bg.a.a(this.jXf, R.g.beg) : com.tencent.mm.bg.a.a(this.jXf, R.g.beh));
        if (this.jYt) {
            cW(false);
        } else {
            cW(true);
        }
        this.jYL = (Button) this.jXf.findViewById(R.h.buD);
        this.jYL.setText(this.jYt ? R.l.dPE : R.l.dPB);
    }

    private void adV() {
        int left;
        int width;
        int i;
        if (this.jYt) {
            left = this.jYH.getLeft();
            int top = this.jYH.getTop();
            width = this.jYH.getWidth();
            i = left;
            left = top;
        } else {
            i = this.jYJ.getLeft();
            width = 0;
            left = this.jYJ.getTop();
        }
        this.jYE = (ThrowBottleAnimUI) this.jXf.findViewById(R.h.buz);
        this.jYE.jYs = this.jYT;
        ThrowBottleAnimUI throwBottleAnimUI = this.jYE;
        throwBottleAnimUI.jYt = this.jYt;
        throwBottleAnimUI.Wx = i;
        throwBottleAnimUI.Wy = left;
        throwBottleAnimUI.jYr = width;
        throwBottleAnimUI.setVisibility(0);
        af.f(new Runnable(throwBottleAnimUI) {
            final /* synthetic */ ThrowBottleAnimUI jYv;

            {
                this.jYv = r1;
            }

            public final void run() {
                if (this.jYv.jXf != null && !this.jYv.jXf.isFinishing() && this.jYv.jYk != null && this.jYv.jYl != null) {
                    this.jYv.jYk.setVisibility(0);
                    this.jYv.jXf.jVO = false;
                    this.jYv.jXf.jU(-1);
                    this.jYv.adS();
                    this.jYv.adQ();
                    ThrowBottleAnimUI.f(this.jYv);
                    this.jYv.jYl.startAnimation(this.jYv.jYm);
                }
            }
        }, 100);
    }

    private void cW(boolean z) {
        if (z) {
            ((InputMethodManager) this.jXf.getSystemService("input_method")).showSoftInput(this.jYJ, 0);
        } else {
            ((InputMethodManager) this.jXf.getSystemService("input_method")).hideSoftInputFromWindow(this.jYJ.getWindowToken(), 2);
        }
    }

    public final boolean adW() {
        w.d("MM.Bottle.ThrowBottleUI", "bottle record stop");
        if (this.jYW) {
            boolean pd;
            this.jXf.getWindow().getDecorView().setKeepScreenOn(false);
            if (this.jYF != null) {
                this.jYF.stop();
            }
            if (this.jYz != null) {
                pd = this.jYz.pd();
                ad.Pu("keep_app_silent");
                this.jYU.KH();
                this.jYV.KH();
                this.jYB = -1;
            } else {
                pd = false;
            }
            if (pd) {
                adV();
            } else {
                this.jYL.setEnabled(false);
                this.jYL.setBackgroundDrawable(com.tencent.mm.bg.a.a(this.jXf, R.g.biY));
                this.jYG.setVisibility(8);
                this.jYH.setVisibility(8);
                this.jYX.sendEmptyMessageDelayed(0, 500);
                ap.yY();
                if (com.tencent.mm.u.c.isSDCardAvailable()) {
                    this.jXf.jT(R.l.dPA);
                }
            }
        }
        this.jYW = false;
        return false;
    }

    public final void bG(int i, int i2) {
        if (i2 == -2002) {
            this.jXf.jU(0);
            this.jXf.jT(R.l.dPi);
        }
    }
}
