package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.map.m;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyEmptyUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandNearbyWebViewUI;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.protocal.c.adr;
import com.tencent.mm.protocal.c.ang;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.wcdb.database.SQLiteDatabase;

final class c implements OnClickListener, com.tencent.mm.plugin.appbrand.b.c.b {
    View abf;
    public Activity fPi;
    private ThreeDotsLoadingView jmH;
    private int jmK = b.jna;
    public final int jmL;
    private final int jmM;
    public final int jmN;
    private final f jmO = new a(this);
    private final int jmP = -1;
    View jmQ;
    TextView jmR;
    public AppBrandNearbyShowcaseView jmS;
    public View jmT;
    private ImageView jmU;
    public boolean jmV = false;

    private final class a implements f {
        final /* synthetic */ c jmW;

        public a(c cVar) {
            this.jmW = cVar;
        }

        public final Bitmap i(Bitmap bitmap) {
            Bitmap a = d.a(bitmap, false, (float) (bitmap.getWidth() / 2), false);
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a, this.jmW.jmL, this.jmW.jmL, false);
            if (a != createScaledBitmap) {
                l.wu().f(a);
            }
            a = Bitmap.createBitmap(this.jmW.jmL + (this.jmW.jmN * 2), this.jmW.jmL + (this.jmW.jmN * 2), Config.ARGB_8888);
            Canvas canvas = new Canvas(a);
            canvas.drawBitmap(createScaledBitmap, (float) this.jmW.jmN, (float) this.jmW.jmN, new Paint());
            l.wu().f(createScaledBitmap);
            Paint paint = new Paint();
            paint.setColor(-1);
            paint.setAntiAlias(true);
            paint.setStyle(Style.STROKE);
            paint.setStrokeWidth((float) this.jmW.jmN);
            canvas.drawCircle((float) ((this.jmW.jmL / 2) + this.jmW.jmN), (float) ((this.jmW.jmL / 2) + this.jmW.jmN), (float) (this.jmW.jmL / 2), paint);
            return a;
        }

        public final String Bc() {
            return "WxaNearbyShowcaseIcon";
        }
    }

    private enum b {
        ;

        static {
            jmY = 1;
            jmZ = 2;
            jna = 3;
            jnb = 4;
            jnc = new int[]{jmY, jmZ, jna, jnb};
        }
    }

    c(Activity activity, ViewGroup viewGroup) {
        this.fPi = activity;
        this.jmL = com.tencent.mm.bg.a.fromDPToPix(activity, 25);
        this.jmM = com.tencent.mm.bg.a.fromDPToPix(activity, 15);
        this.jmN = com.tencent.mm.bg.a.fromDPToPix(activity, 2);
        this.abf = LayoutInflater.from(activity).inflate(R.i.cUn, viewGroup, false);
        View findViewById = this.abf.findViewById(R.h.bGC);
        this.jmT = findViewById;
        findViewById.setOnClickListener(this);
        this.jmQ = this.abf.findViewById(R.h.cmX);
        this.jmR = (TextView) this.abf.findViewById(R.h.cmW);
        this.jmS = (AppBrandNearbyShowcaseView) this.abf.findViewById(R.h.cmS);
        this.jmS.iI(4);
        AppBrandNearbyShowcaseView appBrandNearbyShowcaseView = this.jmS;
        int i = this.jmL + (this.jmN * 2);
        if (i > 0 && i != appBrandNearbyShowcaseView.dO) {
            appBrandNearbyShowcaseView.dO = i;
            appBrandNearbyShowcaseView.Yf();
        }
        appBrandNearbyShowcaseView = this.jmS;
        i = this.jmM;
        if (i >= 0 && appBrandNearbyShowcaseView.jqD != i) {
            appBrandNearbyShowcaseView.jqD = i;
            appBrandNearbyShowcaseView.Yf();
        }
        this.jmH = (ThreeDotsLoadingView) this.abf.findViewById(R.h.cmU);
        this.jmU = (ImageView) this.abf.findViewById(R.h.cmV);
    }

    final void Xy() {
        this.jmK = b.jnb;
        bG(this.jmQ);
        bG(this.jmU);
        b(this.jmH, null);
        this.jmH.caQ();
    }

    public final void Xz() {
        if (this.abf != null) {
            com.tencent.mm.plugin.appbrand.b.d.d dVar;
            if (com.tencent.mm.plugin.appbrand.b.c.QT()) {
                this.abf.setVisibility(0);
                dVar = ((AppBrandLauncherUI) this.fPi).jiy;
                if (dVar != null) {
                    dVar.iBY[5] = "1";
                }
            } else {
                this.abf.setVisibility(8);
            }
            this.jmH.Wd();
            bG(this.jmH);
            adr QX = com.tencent.mm.plugin.appbrand.b.c.QX();
            if (QX == null) {
                this.jmK = b.jmY;
                bG(this.jmQ);
                b(this.jmU, null);
            } else if (QX.jDf <= 0 || bg.bV(QX.tJi)) {
                this.jmK = b.jna;
                bG(this.jmQ);
            } else {
                boolean z;
                int childCount;
                this.jmK = b.jmZ;
                dVar = ((AppBrandLauncherUI) this.fPi).jiy;
                if (dVar != null) {
                    dVar.iBY[3] = "1";
                }
                this.jmS.iI(Math.min(QX.tJi.size(), 4));
                if (this.jmQ.getVisibility() != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    AppBrandNearbyShowcaseView appBrandNearbyShowcaseView = this.jmS;
                    if (appBrandNearbyShowcaseView.getChildCount() > 1) {
                        for (childCount = appBrandNearbyShowcaseView.getChildCount() - 1; childCount >= 0; childCount--) {
                            View childAt = appBrandNearbyShowcaseView.getChildAt(childCount);
                            childAt.setTranslationX((float) ((LayoutParams) childAt.getLayoutParams()).rightMargin);
                        }
                    }
                }
                this.jmR.setText(this.fPi.getString(R.l.dEV, new Object[]{Integer.valueOf(QX.jDf)}));
                for (childCount = 0; childCount < this.jmS.getChildCount(); childCount++) {
                    com.tencent.mm.modelappbrand.a.b AY = com.tencent.mm.modelappbrand.a.b.AY();
                    AppBrandNearbyShowcaseView appBrandNearbyShowcaseView2 = this.jmS;
                    AY.a((ImageView) appBrandNearbyShowcaseView2.getChildAt((appBrandNearbyShowcaseView2.getChildCount() - 1) - childCount), ((ang) QX.tJi.get(childCount)).tSc, com.tencent.mm.modelappbrand.a.a.AX(), this.jmO);
                }
                b(this.jmQ, new Runnable(this) {
                    final /* synthetic */ c jmW;

                    public final void run() {
                        int i = 1;
                        if (z && this.jmW.jmS != null) {
                            AppBrandNearbyShowcaseView appBrandNearbyShowcaseView = this.jmW.jmS;
                            if (appBrandNearbyShowcaseView.getChildCount() > 1) {
                                int i2 = m.CTRL_INDEX;
                                while (i < appBrandNearbyShowcaseView.getChildCount()) {
                                    appBrandNearbyShowcaseView.getChildAt(i).animate().setDuration((long) i2).translationX(0.0f).start();
                                    i2 += 50;
                                    i++;
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    private void bG(final View view) {
        if (view.getVisibility() == 0) {
            view.animate().setDuration(200).alpha(0.0f).withEndAction(new Runnable(this) {
                final /* synthetic */ c jmW;

                public final void run() {
                    view.setVisibility(8);
                }
            }).start();
        }
    }

    private static void b(View view, Runnable runnable) {
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().setDuration(200).alpha(1.0f).withEndAction(runnable).start();
    }

    public final void Ra() {
        if (this.abf != null) {
            this.abf.post(new Runnable(this) {
                final /* synthetic */ c jmW;

                {
                    this.jmW = r1;
                }

                public final void run() {
                    this.jmW.Xz();
                    if (this.jmW.jmV) {
                        this.jmW.jmT.performClick();
                        this.jmW.jmV = false;
                    }
                }
            });
        }
    }

    public final void onClick(View view) {
        Object obj = null;
        if (view.getId() == R.h.bGC && this.fPi != null && b.jnb != this.jmK) {
            if (b.jna == this.jmK) {
                XA();
                this.fPi.startActivityForResult(new Intent(this.fPi, AppBrandNearbyEmptyUI.class), 3);
                return;
            }
            boolean z = com.tencent.mm.plugin.appbrand.b.c.QX() != null && com.tencent.mm.plugin.appbrand.b.c.QY();
            this.jmV = z;
            if (b.jmY == this.jmK || this.jmV) {
                obj = 1;
            }
            Runnable anonymousClass5 = new Runnable(this) {
                final /* synthetic */ c jmW;

                {
                    this.jmW = r1;
                }

                public final void run() {
                    if (this.jmW.fPi != null) {
                        adr QX = com.tencent.mm.plugin.appbrand.b.c.QX();
                        if (QX != null && !bg.mA(QX.tJg)) {
                            Intent putExtra = new Intent(this.jmW.fPi, AppBrandNearbyWebViewUI.class).putExtra("rawUrl", QX.tJg);
                            if (!(this.jmW.fPi instanceof Activity)) {
                                putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            }
                            this.jmW.fPi.startActivityForResult(putExtra, 3);
                            this.jmW.XA();
                            com.tencent.mm.plugin.appbrand.report.a.c cVar = new com.tencent.mm.plugin.appbrand.report.a.c();
                            cVar.jgy = com.tencent.mm.plugin.appbrand.report.a.c.b.TOP_ENTRANCE_IN_DESKTOP;
                            cVar.jgz = QX.jDf;
                            cVar.jgA = QX.tJe;
                            cVar.jgC = com.tencent.mm.plugin.appbrand.report.a.c.a.NEARBY_H5;
                            cVar.qg();
                        }
                    }
                }
            };
            if (obj != null) {
                Xy();
                com.tencent.mm.plugin.appbrand.b.c.refresh();
                return;
            }
            anonymousClass5.run();
        }
    }

    public final void XA() {
        if (this.fPi != null) {
            com.tencent.mm.plugin.appbrand.b.d.d dVar = ((AppBrandLauncherUI) this.fPi).jiy;
            if (dVar != null) {
                dVar.iBY[8] = "1";
            }
        }
    }
}
