package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.nn;
import com.tencent.mm.plugin.scanner.util.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.plugin.scanner.util.l;
import com.tencent.mm.protocal.c.hh;
import com.tencent.mm.protocal.c.hi;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public abstract class c extends i implements a {
    private long oXi;
    public int oXj;
    private HighlightRectSideView oXk;
    public k oXl;
    private p oXm;
    private h oXn;

    protected abstract b a(a aVar);

    protected abstract float aYd();

    protected abstract String aYe();

    protected abstract int aYf();

    public c(i.b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        super(bVar, point);
        this.oXj = 0;
        this.oXl = null;
        this.oXm = null;
        this.oXn = null;
        this.paL = 0;
        this.paM = 0;
        float aYd = aYd();
        Point point2 = i == 1 ? new Point(displayMetrics.widthPixels, displayMetrics.heightPixels) : new Point(displayMetrics.heightPixels, displayMetrics.widthPixels);
        int i2 = (int) (((float) point2.y) * 0.8f);
        int i3 = (int) (((float) point2.x) * 0.8f);
        if (((float) i2) * aYd > ((float) point2.x)) {
            i2 = (int) (((float) i3) / aYd);
        } else {
            i3 = (int) (((float) i2) * aYd);
        }
        Point point3 = new Point((int) (((float) i3) / displayMetrics.density), (int) (((float) i2) / displayMetrics.density));
        this.paM = (int) (((((float) point2.y) / displayMetrics.density) - ((float) point3.y)) / 2.0f);
        cM(point3.x, point3.y);
        if (bg.en(bVar.aYD()) < 100) {
            w.w("MicroMsg.BaseScanModeLicence", "memory is not much");
            this.oXi = 280;
            return;
        }
        this.oXi = 80;
    }

    protected final void onResume() {
    }

    protected final void aYg() {
    }

    protected final b aYh() {
        if (this.paH == null) {
            this.paH = a(this);
        }
        return this.paH;
    }

    protected final int aYi() {
        return R.i.dmY;
    }

    protected final int aYj() {
        return 0;
    }

    protected final void aYk() {
    }

    protected final void cl(View view) {
        if (view != null) {
            TextView textView = (TextView) view.findViewById(R.h.byD);
            if (textView != null) {
                textView.setText(view.getContext().getString(R.l.eOP, new Object[]{view.getContext().getString(aYf())}));
            }
        }
    }

    protected final boolean aYl() {
        return false;
    }

    protected final boolean aYm() {
        return false;
    }

    protected final void i(Rect rect) {
        w.d("MicroMsg.BaseScanModeLicence", "smoothie, maskRect = %s", new Object[]{rect});
        HighlightRectSideView highlightRectSideView = (HighlightRectSideView) this.paN.findViewById(R.h.bxj);
        if (highlightRectSideView != null) {
            highlightRectSideView.j(rect);
        }
        this.oXk = highlightRectSideView;
    }

    public void a(int i, String str, byte[] bArr, int i2, int i3) {
        w.d("MicroMsg.BaseScanModeLicence", "onDecodeSuccess");
        Vibrator vibrator = (Vibrator) ab.getContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(new long[]{0, 50}, 1);
        }
        Bitmap bitmap = ((l) this.paH).pen;
        final String aYe = aYe();
        if (this.oXm != null) {
            this.oXm.dismiss();
        }
        Context aYD = this.paN.aYD();
        aYD.getString(R.l.dIO);
        this.oXm = g.a(aYD, aYD.getString(R.l.eOU), false, null);
        this.oXm.setOnKeyListener(new OnKeyListener(this) {
            final /* synthetic */ c oXp;

            public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (i != 4 || keyEvent.getAction() != 1) {
                    return false;
                }
                this.oXp.DG(aYe);
                return true;
            }
        });
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new hh();
        aVar.hsn = new hi();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanlicense";
        aVar.hsl = 1803;
        com.tencent.mm.y.b BE = aVar.BE();
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (bitmap.compress(CompressFormat.JPEG, 80, byteArrayOutputStream)) {
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            if (bg.bm(toByteArray)) {
                p(2, aYe, "");
                return;
            }
            hh hhVar = (hh) BE.hsj.hsr;
            hhVar.tls = new com.tencent.mm.bd.b(toByteArray);
            if (aYe.equals("driving")) {
                hhVar.tlr = 0;
            } else if (aYe.equals("identity")) {
                hhVar.tlr = 1;
            }
            this.oXl = u.a(BE, new u.a(this) {
                final /* synthetic */ c oXp;

                public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                    w.i("MicroMsg.BaseScanModeLicence", "errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    c cVar = this.oXp;
                    cVar.oXj++;
                    this.oXp.p(i2, aYe, ((hi) bVar.hsk.hsr).tlt);
                    return 0;
                }
            }, false);
            return;
        }
        p(2, aYe, "");
    }

    public final void aYn() {
        w.d("MicroMsg.BaseScanModeLicence", "onDecodeFail");
        if (this.paN == null) {
            w.e("MicroMsg.BaseScanModeLicence", "ui callback is null");
        } else {
            aYo();
        }
    }

    private void aYo() {
        this.oXk.a(((l) this.paH).pdE);
        this.paN.cX(this.oXi);
    }

    public final void DG(final String str) {
        if (this.oXn != null) {
            this.oXn.dismiss();
        }
        this.oXn = g.a(this.paN.aYD(), R.l.eOQ, R.l.dIO, new OnClickListener(this) {
            final /* synthetic */ c oXp;

            public final void onClick(DialogInterface dialogInterface, int i) {
                ap.vd().c(this.oXp.oXl);
                com.tencent.mm.sdk.b.b nnVar = new nn();
                nnVar.fUE.cardType = str;
                nnVar.fUE.fUF = 2;
                com.tencent.mm.sdk.b.a.urY.m(nnVar);
                this.oXp.paN.aYD().finish();
            }
        }, null);
    }

    public final void p(int i, String str, String str2) {
        com.tencent.mm.sdk.b.b nnVar;
        if (i == 0) {
            nnVar = new nn();
            nnVar.fUE.cardType = str;
            nnVar.fUE.fUF = 1;
            nnVar.fUE.fUG = str2;
            if (this.paH instanceof l) {
                nnVar.fUE.fUH = ((l) this.paH).pen;
            }
            com.tencent.mm.sdk.b.a.urY.a(nnVar, Looper.getMainLooper());
            if (this.oXm != null) {
                this.oXm.dismiss();
            }
            this.paN.aYD().finish();
        } else if ((i & 2) > 0 && (i & 1) > 0) {
            r0 = new nn();
            r0.fUE.cardType = str;
            r0.fUE.fUF = 0;
            r0.fUE.fUG = str2;
            com.tencent.mm.sdk.b.a.urY.a(r0, Looper.getMainLooper());
            if (this.oXm != null) {
                this.oXm.dismiss();
            }
            this.paN.aYD().finish();
        } else if (this.oXj >= 3) {
            nnVar = new nn();
            nnVar.fUE.cardType = str;
            nnVar.fUE.fUF = 1;
            nnVar.fUE.fUG = str2;
            if (this.paH instanceof l) {
                nnVar.fUE.fUH = ((l) this.paH).pen;
            }
            com.tencent.mm.sdk.b.a.urY.a(nnVar, Looper.getMainLooper());
            if (this.oXm != null) {
                this.oXm.dismiss();
            }
            this.paN.aYD().finish();
        } else if ((i & 1) <= 0 || this.oXj >= 3) {
            r0 = new nn();
            r0.fUE.cardType = str;
            r0.fUE.fUF = 0;
            r0.fUE.fUG = str2;
            com.tencent.mm.sdk.b.a.urY.a(r0, Looper.getMainLooper());
            if (this.oXm != null) {
                this.oXm.dismiss();
            }
            this.paN.aYD().finish();
        } else {
            if (this.oXm != null) {
                this.oXm.dismiss();
            }
            aYh().aYV();
            int i2 = (i & 32) > 0 ? R.l.eOS : (i & 64) > 0 ? R.l.eOT : R.l.eOR;
            Toast.makeText(this.paN.aYD(), i2, 0).show();
            aYo();
        }
    }

    public final void A(Bundle bundle) {
    }
}
