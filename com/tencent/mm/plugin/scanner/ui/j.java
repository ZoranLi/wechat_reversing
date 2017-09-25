package com.tencent.mm.plugin.scanner.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.nl;
import com.tencent.mm.plugin.appbrand.jsapi.l.e;
import com.tencent.mm.plugin.scanner.ui.i.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;

public final class j extends i implements a {
    private long oXi;
    private HighlightRectSideView paU;
    boolean paV = false;
    private OnClickListener paW = new OnClickListener(this) {
        final /* synthetic */ j paX;

        {
            this.paX = r1;
        }

        public final void onClick(View view) {
            View inflate = ((LayoutInflater) this.paX.paN.aYD().getSystemService("layout_inflater")).inflate(R.i.dmQ, null);
            Context aYD = this.paX.paN.aYD();
            g.a(aYD, aYD.getString(R.l.eOu), aYD.getString(R.l.eOt), inflate, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ AnonymousClass1 paY;

                {
                    this.paY = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            }).show();
        }
    };

    public j(b bVar, Point point, DisplayMetrics displayMetrics, int i) {
        Point point2;
        super(bVar, point);
        if (i == 1) {
            point2 = new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            point2 = new Point(displayMetrics.heightPixels, displayMetrics.widthPixels);
        }
        int i2 = point2.y - ((int) (118.0f * displayMetrics.density));
        Point point3 = new Point((int) (((float) ((int) (((float) i2) * 1.586f))) / displayMetrics.density), (int) (((float) i2) / displayMetrics.density));
        bVar.aYD().setResult(0);
        this.paL = 0;
        this.paM = 64;
        cM(point3.x, point3.y);
        if (bg.en(bVar.aYD()) < 100) {
            w.w("MicroMsg.ScanModeBankCard", "memory is not much");
            this.oXi = 280;
            return;
        }
        this.oXi = 80;
    }

    protected final void onResume() {
    }

    protected final void onPause() {
    }

    protected final void aYg() {
    }

    protected final com.tencent.mm.plugin.scanner.util.b aYh() {
        if (this.paH == null && this.paN != null) {
            this.paH = new com.tencent.mm.plugin.scanner.util.g(this, this.paN.aYz(), this.paV);
        }
        return this.paH;
    }

    protected final int aYi() {
        return R.i.dmP;
    }

    protected final int aYj() {
        return e.CTRL_INDEX;
    }

    protected final void aYk() {
    }

    protected final void i(Rect rect) {
        String str;
        LinearLayout linearLayout = (LinearLayout) this.paN.findViewById(R.h.brS);
        TextView textView = (TextView) this.paN.findViewById(R.h.brX);
        this.paU = (HighlightRectSideView) this.paN.findViewById(R.h.brV);
        this.paU.j(rect);
        Intent intent = this.paN.aYD().getIntent();
        if (intent != null) {
            String ap = bg.ap(intent.getStringExtra("bank_card_owner"), "");
            textView.setText(String.format(this.paN.aYD().getResources().getString(R.l.eOv), new Object[]{ap}));
            str = ap;
        } else {
            str = null;
        }
        if (bg.mA(str)) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
            ((ImageView) this.paN.findViewById(R.h.brT)).setOnClickListener(this.paW);
        }
        if (this.paH != null && this.paN != null) {
            com.tencent.mm.plugin.scanner.util.g gVar = (com.tencent.mm.plugin.scanner.util.g) this.paH;
            boolean aYz = this.paN.aYz();
            w.d("MicroMsg.ScanBankCardDecoder", "need rotate:" + aYz);
            gVar.pdC = aYz;
        }
    }

    public final void a(int i, String str, byte[] bArr, int i2, int i3) {
        w.d("MicroMsg.ScanModeBankCard", "decode success, resultType:%d", new Object[]{Integer.valueOf(i)});
        if (3 != i) {
            w.e("MicroMsg.ScanModeBankCard", "decode success, but result type error:" + i);
            return;
        }
        Bitmap bitmap = ((com.tencent.mm.plugin.scanner.util.g) this.paH).pdI;
        if (this.paV) {
            this.paN.aYB();
            ConfirmScanBankCardResultUI.b(bitmap, str);
            return;
        }
        com.tencent.mm.sdk.b.b nlVar = new nl();
        nlVar.fUB.cardId = str;
        nlVar.fUB.fUC = bitmap;
        com.tencent.mm.sdk.b.a.urY.m(nlVar);
        this.paN.aYD().finish();
    }

    public final void aYn() {
        w.d("MicroMsg.ScanModeBankCard", "onDecodeFailed");
        if (this.paN == null) {
            w.e("MicroMsg.ScanModeBankCard", "ui callback is null");
            return;
        }
        this.paU.a(((com.tencent.mm.plugin.scanner.util.g) this.paH).pdE);
        this.paN.cX(this.oXi);
    }

    protected final boolean aYl() {
        return false;
    }

    protected final boolean aYm() {
        return false;
    }

    public final void A(Bundle bundle) {
    }
}
