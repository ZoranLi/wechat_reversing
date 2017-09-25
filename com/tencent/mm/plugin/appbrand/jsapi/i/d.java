package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.g.l;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q;
import org.json.JSONObject;

public final class d extends a {
    private static final int CTRL_INDEX = 105;
    private static final String NAME = "showToast";
    public View iUW;
    public aj iUX;

    public final void a(m mVar, JSONObject jSONObject, int i) {
        final com.tencent.mm.plugin.appbrand.g.m b = com.tencent.mm.plugin.appbrand.jsapi.d.b(mVar);
        if (b == null) {
            w.w("MicroMsg.JsApiShowToast", "invoke JsApi JsApiShowToast failed, current page view is null.");
            mVar.x(i, d("fail", null));
            return;
        }
        com.tencent.mm.plugin.appbrand.widget.input.m.j(b);
        final int optInt = jSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 1500);
        final String optString = jSONObject.optString("title");
        final String optString2 = jSONObject.optString("icon", "success");
        final String optString3 = jSONObject.optString(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE);
        final boolean optBoolean = jSONObject.optBoolean("mask");
        final m mVar2 = mVar;
        final int i2 = i;
        af.v(new Runnable(this) {
            final /* synthetic */ d iVc;

            public final void run() {
                if (this.iVc.iUW != null) {
                    d.bC(this.iVc.iUW);
                    this.iVc.iUW = null;
                    if (this.iVc.iUX != null) {
                        this.iVc.iUX.KH();
                    }
                }
                this.iVc.iUW = LayoutInflater.from(b.mContext).inflate(R.i.cUt, null);
                View findViewById = this.iVc.iUW.findViewById(R.h.cFk);
                q.yC().n(mVar2.hashCode() + "toast_name", true).l("toast_view", this.iVc.iUW);
                if (optBoolean) {
                    this.iVc.iUW.setLayoutParams(new LayoutParams(-1, -1));
                    ((LinearLayout) this.iVc.iUW.findViewById(R.h.cFj)).setBackgroundColor(0);
                    this.iVc.iUW.setOnTouchListener(new OnTouchListener(this) {
                        final /* synthetic */ AnonymousClass1 iVd;

                        {
                            this.iVd = r1;
                        }

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            return true;
                        }
                    });
                }
                TextView textView = (TextView) this.iVc.iUW.findViewById(R.h.title);
                final int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(textView.getContext(), 18);
                int fromDPToPix2 = com.tencent.mm.bg.a.fromDPToPix(textView.getContext(), 27);
                if (bg.mA(optString)) {
                    textView.setVisibility(8);
                } else {
                    textView.setLineSpacing(0.0f, 1.0f);
                    textView.setSpannableFactory(new Factory(this) {
                        final /* synthetic */ AnonymousClass1 iVd;

                        public final Spannable newSpannable(CharSequence charSequence) {
                            Spannable newSpannable = super.newSpannable(charSequence);
                            if (!TextUtils.isEmpty(newSpannable)) {
                                newSpannable.setSpan(new com.tencent.mm.plugin.appbrand.widget.e.a((float) fromDPToPix), 0, newSpannable.length(), 18);
                            }
                            return newSpannable;
                        }
                    });
                    textView.setText(optString, BufferType.SPANNABLE);
                    textView.setVisibility(0);
                    findViewById.setPadding(0, fromDPToPix2, 0, 0);
                }
                ImageView imageView = (ImageView) this.iVc.iUW.findViewById(R.h.bZT);
                ProgressBar progressBar = (ProgressBar) this.iVc.iUW.findViewById(R.h.progress);
                if (optString2.equals("loading")) {
                    imageView.setVisibility(8);
                    progressBar.setVisibility(0);
                } else {
                    Drawable c;
                    imageView.setVisibility(0);
                    progressBar.setVisibility(8);
                    if (bg.mA(optString3)) {
                        c = com.tencent.mm.svg.a.a.c(imageView.getResources(), R.k.dtH);
                    } else {
                        Bitmap g = l.g(mVar2.ixr, optString3);
                        c = (g == null || g.isRecycled()) ? null : new BitmapDrawable(imageView.getResources(), g);
                    }
                    if (c != null) {
                        imageView.setImageDrawable(c);
                        imageView.setScaleType(ScaleType.FIT_CENTER);
                    }
                }
                b.jcb.addView(this.iVc.iUW);
                this.iVc.iUX = new aj(new aj.a(this) {
                    final /* synthetic */ AnonymousClass1 iVd;

                    {
                        this.iVd = r1;
                    }

                    public final boolean oQ() {
                        d.bC(this.iVd.iVc.iUW);
                        this.iVd.iVc.iUW = null;
                        q.yC().fP(mVar2.hashCode() + "toast_name");
                        w.d("MicroMsg.JsApiShowToast", "on timer expired!");
                        return true;
                    }
                }, false);
                long j = (long) optInt;
                this.iVc.iUX.v(j, j);
                mVar2.x(i2, this.iVc.d("ok", null));
            }
        });
    }

    public static void bC(View view) {
        if (view != null) {
            view.setVisibility(8);
            if (ViewGroup.class.isInstance(view.getParent())) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
        }
    }
}
