package com.tencent.mm.plugin.sight.encode.ui;

import android.content.Context;
import android.hardware.Camera.Parameters;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.c;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.d;

public abstract class SightCameraView extends FrameLayout implements com.tencent.mm.u.d.a {
    private d iXd;
    private Animation mUG;
    protected int nEL;
    private long pqw;
    protected e pxZ;
    protected com.tencent.mm.plugin.sight.encode.a.a pya;
    protected ImageView pyb;
    protected long pyc;
    protected int pyd;
    protected boolean pye;
    protected boolean pyf;
    protected int pyg;
    private aj pyh;
    private int pyi;
    private Runnable pyj;
    private Runnable pyk;

    class AnonymousClass4 implements Runnable {
        final /* synthetic */ Runnable gWh = null;
        final /* synthetic */ SightCameraView pyl;

        AnonymousClass4(SightCameraView sightCameraView, Runnable runnable) {
            this.pyl = sightCameraView;
        }

        public final void run() {
        }

        public final String toString() {
            return super.toString() + "|stopRecord";
        }
    }

    protected enum a {
        ;

        static {
            pym = 1;
            pyn = 2;
            pyo = 3;
            pyp = new int[]{pym, pyn, pyo};
        }
    }

    public abstract void ak(float f);

    protected abstract void al(String str, boolean z);

    protected abstract void bcZ();

    protected abstract int bda();

    protected abstract int bdb();

    protected abstract void hh(boolean z);

    public abstract boolean isPlaying();

    static /* synthetic */ void b(SightCameraView sightCameraView) {
        w.i("MicroMsg.SightCameraView", "stop record");
        if (sightCameraView.pya == null) {
            throw new IllegalStateException("The mSightMedia must be set!");
        }
        ap.vL().D(new AnonymousClass4(sightCameraView, null));
        sightCameraView.pyh.KH();
        sightCameraView.al(0.0f);
        sightCameraView.bdc();
        sightCameraView.setKeepScreenOn(false);
    }

    public final void sL(int i) {
        this.nEL = i;
    }

    public SightCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pyc = -1;
        this.pyd = a.pyo;
        this.pye = false;
        this.pyf = false;
        this.nEL = 320;
        this.pyg = 6500;
        this.pqw = 0;
        this.pyh = new aj(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ SightCameraView pyl;

            {
                this.pyl = r1;
            }

            public final boolean oQ() {
                float bcH = ((float) this.pyl.pya.bcH()) / ((float) this.pyl.pyg);
                if (Float.compare(bcH, 0.0f) > 0 || System.currentTimeMillis() - this.pyl.pqw <= 20000) {
                    if (Float.compare(bcH, 1.0f) <= 0 || this.pyl.pya.bcI() != com.tencent.mm.plugin.sight.encode.a.a.a.pwH) {
                        this.pyl.al(bcH);
                    } else if (!this.pyl.pya.bcG()) {
                        SightCameraView.b(this.pyl);
                    }
                    return true;
                }
                w.e("MicroMsg.SightCameraView", "ERROR record duration, %dms !!!", new Object[]{Long.valueOf(20000)});
                this.pyl.asD();
                return false;
            }
        }, true);
        this.pyi = -1;
        this.pyj = new Runnable(this) {
            final /* synthetic */ SightCameraView pyl;

            {
                this.pyl = r1;
            }

            public final void run() {
            }

            public final String toString() {
                return super.toString() + "|startRecord";
            }
        };
        this.pyk = new Runnable(this) {
            final /* synthetic */ SightCameraView pyl;

            {
                this.pyl = r1;
            }

            public final void run() {
            }

            public final String toString() {
                return super.toString() + "|cancelRecord";
            }
        };
        this.iXd = new d();
        if (com.tencent.mm.plugin.sight.base.d.bbP()) {
            inflate(getContext(), R.i.doD, this);
        } else {
            inflate(getContext(), R.i.doC, this);
        }
        this.pye = false;
        this.pyf = false;
        this.pxZ = new e();
        e eVar = this.pxZ;
        w.i("MicroMsg.SightCamera", "init needRotate %s", new Object[]{Boolean.valueOf(false)});
        if (p.gRe.gRC) {
            eVar.pxW.nDc = p.gRe.gRE;
            eVar.pxW.nDd = p.gRe.gRD;
            eVar.pxW.nDb = p.gRe.gRG;
        }
        eVar.pxW.nDm = c.getNumberOfCameras();
        eVar.pxW.gPG = 0;
        this.pyb = (ImageView) findViewById(R.h.ctr);
        bdc();
    }

    public SightCameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void al(float f) {
        w.d("MicroMsg.SightCameraView", "update progress %f", new Object[]{Float.valueOf(f)});
        if (this.pyi < 0) {
            this.pyi = getResources().getDisplayMetrics().widthPixels;
        }
        if (f < 0.0f) {
            LayoutParams layoutParams = this.pyb.getLayoutParams();
            layoutParams.width = this.pyi;
            this.pyb.setLayoutParams(layoutParams);
        } else if (f > 1.0f) {
            r0 = (this.pyi / 2) - 1;
            r1 = this.pyb.getLayoutParams();
            r1.width = this.pyi - (r0 * 2);
            this.pyb.setLayoutParams(r1);
        } else {
            r0 = (int) ((((float) getResources().getDisplayMetrics().widthPixels) * f) / 2.0f);
            r1 = this.pyb.getLayoutParams();
            r1.width = this.pyi - (r0 * 2);
            this.pyb.setLayoutParams(r1);
        }
    }

    private void bdc() {
        if (this.pyb.getVisibility() != 4) {
            if (this.mUG != null) {
                this.mUG.cancel();
            }
            this.pyb.setVisibility(4);
        }
    }

    protected final void asD() {
        w.w("MicroMsg.SightCameraView", "cancel record");
        if (this.pya == null) {
            throw new IllegalStateException("The mSightMedia must be set!");
        }
        ap.vL().bJl().removeCallbacks(this.pyj);
        ap.vL().D(this.pyk);
        this.pyh.KH();
        al(0.0f);
        bdc();
        setKeepScreenOn(false);
    }

    protected final void bdd() {
        this.iXd.a(this);
    }

    protected final void bde() {
        this.iXd.aS(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getAction() == 0 && this.pye && this.pyf) {
            w.i("MicroMsg.SightCameraView", "check double click %dms", new Object[]{Long.valueOf(SystemClock.elapsedRealtime() - this.pyc)});
            if (SystemClock.elapsedRealtime() - this.pyc < 400) {
                this.pxZ.pxY.removeMessages(4354);
                e eVar = this.pxZ;
                if (eVar.nBJ) {
                    Parameters parameters;
                    try {
                        parameters = eVar.gPJ.getParameters();
                    } catch (Throwable e) {
                        w.e("MicroMsg.SightCamera", "getParameters failed %s", new Object[]{e.getMessage()});
                        w.printErrStackTrace("MicroMsg.SightCamera", e, "", new Object[0]);
                        parameters = null;
                    }
                    if (parameters != null) {
                        w.i("MicroMsg.SightCamera", "trigger zoom, has zoomed %B, isSupported %B", new Object[]{Boolean.valueOf(eVar.nBH), Boolean.valueOf(parameters.isZoomSupported())});
                        if (parameters.isZoomSupported()) {
                            eVar.pxY.removeMessages(4353);
                            if (eVar.nBH) {
                                eVar.pxY.nCu = false;
                                eVar.pxY.nBH = false;
                                eVar.pxY.nCt = a.c(parameters) * -1;
                                eVar.pxY.sendMessage(eVar.pxY.obtainMessage(4353, eVar.gPJ));
                            } else {
                                eVar.pxY.nCu = false;
                                eVar.pxY.nBH = true;
                                eVar.pxY.nCt = a.c(parameters);
                                eVar.pxY.sendMessage(eVar.pxY.obtainMessage(4353, eVar.gPJ));
                            }
                            if (!eVar.nBH) {
                                z = true;
                            }
                            eVar.nBH = z;
                        }
                    }
                } else {
                    w.w("MicroMsg.SightCamera", "want to trigger zoom, but current status is not preview");
                }
            } else {
                e eVar2 = this.pxZ;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int bda = bda();
                int bdb = bdb();
                if (!com.tencent.mm.compatible.util.d.ep(14)) {
                    eVar2.pxY.removeMessages(4354);
                    eVar2.pxY.nCw = x;
                    eVar2.pxY.mTA = y;
                    eVar2.pxY.nCx = bda;
                    eVar2.pxY.nCy = bdb;
                    eVar2.pxY.sendMessageDelayed(eVar2.pxY.obtainMessage(4354, eVar2.gPJ), 400);
                }
            }
            this.pyc = SystemClock.elapsedRealtime();
            motionEvent.getX();
            motionEvent.getY();
            com.tencent.mm.compatible.util.d.ep(14);
        }
        return true;
    }
}
