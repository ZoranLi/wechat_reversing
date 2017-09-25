package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;

public abstract class i {
    protected ProgressDialog isv = null;
    protected TextView jbV;
    protected Point lwL;
    public GestureDetector nlD;
    protected boolean paF = true;
    protected Rect paG;
    protected com.tencent.mm.plugin.scanner.util.b paH;
    protected Point paI;
    protected int paJ;
    protected int paK;
    protected int paL = 40;
    protected int paM = 20;
    protected b paN;
    protected int paO;
    protected boolean paP;
    protected ae paQ = new ae(this) {
        final /* synthetic */ i paR;

        {
            this.paR = r1;
        }

        public final void handleMessage(Message message) {
            if (message != null && message.what == 1 && this.paR.jbV != null) {
                this.paR.jbV.setVisibility(0);
            }
        }
    };

    public interface a {
        void b(Activity activity, int i, int i2, Intent intent);
    }

    public interface b {
        void M(int i, int i2, int i3);

        void a(a aVar);

        void a(String str, int i, int i2, int i3, com.tencent.mm.plugin.scanner.util.e.a aVar);

        void aYA();

        void aYB();

        Activity aYD();

        void aYr();

        void aYy();

        boolean aYz();

        void b(int i, OnClickListener onClickListener);

        void cX(long j);

        View findViewById(int i);

        void gH(boolean z);

        void j(long j, boolean z);
    }

    protected abstract void aYg();

    protected abstract com.tencent.mm.plugin.scanner.util.b aYh();

    protected abstract int aYi();

    protected abstract int aYj();

    protected abstract void aYk();

    protected abstract boolean aYl();

    protected abstract boolean aYm();

    protected abstract void i(Rect rect);

    protected abstract void onResume();

    public final b aYM() {
        return this.paN;
    }

    protected final void gJ(boolean z) {
        if (this.jbV != null) {
            if (z) {
                this.jbV.setVisibility(4);
                this.paQ.sendEmptyMessageDelayed(1, 210);
                return;
            }
            this.paQ.removeMessages(1);
            this.jbV.setVisibility(4);
        }
    }

    public i(b bVar, Point point) {
        this.paN = bVar;
        this.paI = point;
    }

    public i(b bVar, Point point, byte b) {
        this.paN = bVar;
        this.paI = point;
        this.paL = 50;
    }

    protected void onPause() {
        if (this.isv != null && this.isv.isShowing()) {
            this.isv.dismiss();
        }
    }

    public final void c(Point point) {
        this.paI = point;
    }

    protected void cl(View view) {
    }

    protected final double cM(int i, int i2) {
        Context aYD = this.paN.aYD();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) aYD.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        double d = ((double) displayMetrics.densityDpi) / 160.0d;
        w.d("MicroMsg.scanner.ScanMode", "dpiLevel [%s]", new Object[]{Double.valueOf(d)});
        if (d > 1.2d) {
            if (this.paI.x + this.paI.y <= 3000 || d >= 2.4d) {
                this.paJ = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.paN.aYD(), (float) i);
                this.paK = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.paN.aYD(), (float) i2);
            } else {
                this.paJ = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.paN.aYD(), ((float) i) * 1.6f);
                this.paK = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.paN.aYD(), ((float) i2) * 1.6f);
                if (this instanceof j) {
                    int i3 = (int) (((double) this.paI.y) * 0.8d);
                    int i4 = (int) (((double) this.paI.x) * 0.8d);
                    if (this.paJ > i3 && this.paK > i4) {
                        float f = DownloadHelper.SAVE_FATOR;
                        while (this.paJ > i3 && this.paK > i4) {
                            this.paJ = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.paN.aYD(), ((float) i) * f);
                            this.paK = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.paN.aYD(), ((float) i2) * f);
                            f -= 0.1f;
                        }
                        w.i("MicroMsg.scanner.ScanMode", "final adjust ratio: %s", new Object[]{Float.valueOf(f)});
                    }
                }
            }
        } else if (this.paI != null && this.paI.x + this.paI.y > 1560) {
            this.paJ = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.paN.aYD(), ((float) i) * 1.7f);
            this.paK = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.paN.aYD(), ((float) i2) * 1.7f);
        } else if (this.paI == null || this.paI.x + this.paI.y <= 1460) {
            this.paJ = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.paN.aYD(), ((float) i) / 1.1f);
            this.paK = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.paN.aYD(), ((float) i2) / 1.1f);
        } else {
            this.paJ = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.paN.aYD(), ((float) i) * 1.1f);
            this.paK = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.paN.aYD(), ((float) i2) * 1.1f);
        }
        if (this.paJ % 2 == 1) {
            this.paJ++;
        }
        if (this.paK % 2 == 1) {
            this.paK++;
        }
        w.d("MicroMsg.scanner.ScanMode", "frame, width:%d, height:%d, visDisplayFrameRes:%s", new Object[]{Integer.valueOf(this.paJ), Integer.valueOf(this.paK), this.paI});
        return d;
    }

    protected final Rect r(boolean z, boolean z2) {
        if (this.paG == null || z) {
            int i;
            int i2;
            int i3;
            int i4 = this.paI.x;
            int i5 = this.paI.y;
            int a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.paN.aYD(), (float) this.paL);
            if (this.paN.aYz()) {
                i = a;
            } else {
                i = 0;
            }
            if (!z2) {
                i2 = (i4 / 2) - (this.paJ / 2);
                i3 = (this.paJ / 2) + (i4 / 2);
                a = (i5 / 2) - (this.paK / 2);
                if (a - i > 0) {
                    a -= i;
                }
                i = this.paK + a;
            } else if (i4 < i5) {
                i2 = (i5 / 2) - (this.paJ / 2);
                i3 = (this.paJ / 2) + (i5 / 2);
                a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.paN.aYD(), (float) this.paM);
                i = this.paK + a;
            } else {
                i2 = (i4 / 2) - (this.paJ / 2);
                i3 = (this.paJ / 2) + (i4 / 2);
                a = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.paN.aYD(), (float) this.paM);
                i = this.paK + a;
            }
            w.d("MicroMsg.scanner.ScanMode", "framingRect: width = %s, height = %s; left = %s, right = %s, top = %s, bottom = %s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(a), Integer.valueOf(i)});
            this.paG = new Rect(i2, a, i3, i);
        }
        return this.paG;
    }

    protected Rect gK(boolean z) {
        return r(true, z);
    }

    protected void d(Point point) {
        this.lwL = point;
    }

    public boolean oV() {
        return false;
    }

    public final void gL(boolean z) {
        if (this.jbV != null) {
            this.jbV.setVisibility(z ? 0 : 4);
        }
    }
}
