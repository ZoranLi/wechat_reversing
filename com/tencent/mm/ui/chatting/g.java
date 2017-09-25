package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.a.d.b;
import com.tencent.mm.ah.n;
import com.tencent.mm.app.MMApplicationLike;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.t.f;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.chatting.ah.a;

final class g extends a {
    public static final int vyt = (((int) com.tencent.mm.bg.a.getDensity(MMApplicationLike.applicationLike.getApplication())) * 64);
    public TextView ipw;
    public TextView ipx;
    public int vym = 0;
    public MMImageView vyp;
    public TextView vyq;
    public View vyr;
    public boolean vys;

    public g(int i) {
        super(i);
    }

    public final g o(View view, boolean z) {
        super.dn(view);
        this.vys = z;
        this.kxi = (TextView) this.mil.findViewById(R.h.bBA);
        this.mfD = (CheckBox) view.findViewById(R.h.bAd);
        this.nRW = this.mil.findViewById(R.h.bAX);
        this.piH = (TextView) this.mil.findViewById(R.h.bBG);
        this.vyp = (MMImageView) this.mil.findViewById(R.h.bqf);
        this.ipw = (TextView) this.mil.findViewById(R.h.bqg);
        this.ipx = (TextView) this.mil.findViewById(R.h.bqe);
        this.vyq = (TextView) this.mil.findViewById(R.h.bqc);
        this.vyr = this.mil.findViewById(R.h.bqd);
        this.vym = ah.eU(ab.getContext());
        return this;
    }

    public final void a(final Context context, f.a aVar, String str, boolean z) {
        a.I(this.vBZ, this.vym);
        com.tencent.mm.ah.a.a GW;
        String v;
        ImageView imageView;
        c.a aVar2;
        switch (aVar.type) {
            case 16:
                if (aVar != null) {
                    this.ipw.setText(aVar.description);
                    this.ipx.setText(aVar.hiz);
                    this.vyp.setVisibility(0);
                    if (z) {
                        GW = n.GW();
                        v = n.GS().v(str, true);
                        imageView = this.vyp;
                        aVar2 = new c.a();
                        aVar2.hIQ = 1;
                        aVar2 = aVar2.aO(vyt, vyt);
                        aVar2.hJa = R.k.dtu;
                        aVar2.hJi = true;
                        GW.a(v, imageView, aVar2.Hg());
                        return;
                    }
                    this.vyp.setImageResource(R.g.bhO);
                    return;
                }
                return;
            case 34:
                if (aVar.title == null || aVar.title.length() <= 0) {
                    this.ipw.setVisibility(8);
                } else {
                    this.ipw.setVisibility(0);
                    this.ipw.setText(aVar.title);
                    if (bg.mA(aVar.hiI)) {
                        this.ipw.setTextColor(context.getResources().getColor(R.e.black));
                    } else {
                        this.ipw.setTextColor(bg.aF(aVar.hiI, context.getResources().getColor(R.e.black)));
                    }
                }
                this.ipx.setMaxLines(2);
                this.ipx.setVisibility(0);
                this.ipx.setText(aVar.description);
                if (bg.mA(aVar.hiJ)) {
                    this.ipx.setTextColor(context.getResources().getColor(R.e.aUf));
                } else {
                    this.ipx.setTextColor(bg.aF(aVar.hiJ, context.getResources().getColor(R.e.aUf)));
                }
                if (bg.mA(aVar.hiE)) {
                    this.vyq.setText(R.l.dUb);
                } else {
                    this.vyq.setText(aVar.hiE);
                }
                if (z) {
                    final Bitmap a = n.GS().a(str, com.tencent.mm.bg.a.getDensity(context), false);
                    if (!(a == null || a.isRecycled())) {
                        this.vyp.setImageBitmap(d.a(a, false, (float) (a.getWidth() / 2)));
                    }
                    if (bg.mA(aVar.hiH)) {
                        this.vyr.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                            final /* synthetic */ g vyu;

                            public final boolean onPreDraw() {
                                this.vyu.vyr.getViewTreeObserver().removeOnPreDrawListener(this);
                                int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(context, 24);
                                Bitmap bitmap = a;
                                if (bitmap == null || bitmap.isRecycled()) {
                                    bitmap = d.U(context.getResources().getColor(R.e.aTo), fromDPToPix, fromDPToPix);
                                }
                                int height = bitmap.getHeight();
                                if (fromDPToPix <= height) {
                                    height = fromDPToPix;
                                }
                                Bitmap c = d.c(d.N(Bitmap.createScaledBitmap(bitmap, height, height, true)), 20);
                                height = this.vyu.vyr.getHeight();
                                int width = this.vyu.vyr.getWidth();
                                if (height == 0) {
                                    height = com.tencent.mm.bg.a.T(context, R.f.aZf);
                                }
                                if (width == 0) {
                                    width = com.tencent.mm.bg.a.T(context, R.f.aZg);
                                }
                                if (this.vyu.vys) {
                                    bitmap = d.a(c, R.g.bdG, width, height);
                                } else {
                                    bitmap = d.a(c, R.g.bdR, width, height);
                                }
                                this.vyu.vyr.setBackgroundDrawable(new BitmapDrawable(bitmap));
                                return true;
                            }
                        });
                        return;
                    }
                    GW = n.GW();
                    v = aVar.hiH;
                    imageView = new ImageView(context);
                    aVar2 = new c.a();
                    aVar2.hIL = true;
                    GW.a(v, imageView, aVar2.Hg(), new com.tencent.mm.ah.a.c.g(this) {
                        final /* synthetic */ g vyu;

                        public final void jK(String str) {
                        }

                        public final void a(String str, View view, b bVar) {
                            if (bVar.bitmap != null) {
                                final Bitmap bitmap = bVar.bitmap;
                                this.vyu.vyr.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                                    final /* synthetic */ AnonymousClass1 vyv;

                                    public final boolean onPreDraw() {
                                        Bitmap a;
                                        this.vyv.vyu.vyr.getViewTreeObserver().removeOnPreDrawListener(this);
                                        int height = this.vyv.vyu.vyr.getHeight();
                                        int width = this.vyv.vyu.vyr.getWidth();
                                        if (height == 0) {
                                            height = com.tencent.mm.bg.a.T(context, R.f.aZf);
                                        }
                                        if (width == 0) {
                                            width = com.tencent.mm.bg.a.T(context, R.f.aZg);
                                        }
                                        if (this.vyv.vyu.vys) {
                                            a = d.a(bitmap, R.g.bdG, width, height);
                                        } else {
                                            a = d.a(bitmap, R.g.bdR, width, height);
                                        }
                                        this.vyv.vyu.vyr.setBackgroundDrawable(new BitmapDrawable(a));
                                        return true;
                                    }
                                });
                            }
                        }
                    });
                    return;
                }
                this.vyp.setImageBitmap(BitmapFactory.decodeResource(context.getResources(), R.g.bhO));
                return;
            default:
                if (aVar != null) {
                    this.ipw.setText(aVar.description);
                    this.ipx.setText(aVar.hiz);
                    this.vyp.setVisibility(0);
                    if (z) {
                        GW = n.GW();
                        v = n.GS().v(str, true);
                        imageView = this.vyp;
                        aVar2 = new c.a();
                        aVar2.hIQ = 1;
                        aVar2 = aVar2.aO(vyt, vyt);
                        aVar2.hJa = R.k.dtu;
                        aVar2.hJi = true;
                        GW.a(v, imageView, aVar2.Hg());
                        return;
                    }
                    this.vyp.setImageResource(R.g.bhO);
                    return;
                }
                return;
        }
    }
}
