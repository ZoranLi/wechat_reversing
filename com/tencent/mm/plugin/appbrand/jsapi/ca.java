package com.tencent.mm.plugin.appbrand.jsapi;

import android.animation.ArgbEvaluator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mm.plugin.appbrand.g.m.AnonymousClass14;
import com.tencent.mm.plugin.appbrand.g.m.AnonymousClass8;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.ui.tools.d;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class ca extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "setNavigationBarColor";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        try {
            long JH = d.JH(jSONObject.getString("frontColor"));
            if (JH == -1) {
                throw new Exception();
            }
            int i2 = (int) JH;
            JH = d.JH(jSONObject.getString("backgroundColor"));
            if (JH == -1) {
                throw new Exception();
            }
            int i3 = (int) JH;
            int i4 = 0;
            Object obj = "";
            JSONObject optJSONObject = jSONObject.optJSONObject("animation");
            if (optJSONObject != null) {
                i4 = optJSONObject.optInt(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                obj = optJSONObject.optString("timingFunc");
            }
            final com.tencent.mm.plugin.appbrand.g.m b = d.b(mVar);
            if (b == null) {
                mVar.x(i, d("fail:no page for now", null));
                return;
            }
            int i5 = b.jdb.CU;
            int i6 = b.jdb.jqj;
            TimeInterpolator linearInterpolator = "linear".equals(obj) ? new LinearInterpolator() : "easeIn".equals(obj) ? new AccelerateInterpolator() : "easeOut".equals(obj) ? new DecelerateInterpolator() : "easeInOut".equals(obj) ? new AccelerateDecelerateInterpolator() : null;
            ValueAnimator valueAnimator = new ValueAnimator();
            valueAnimator.setIntValues(new int[]{i5, i3});
            valueAnimator.setEvaluator(new ArgbEvaluator());
            valueAnimator.setDuration((long) i4);
            valueAnimator.setInterpolator(linearInterpolator);
            valueAnimator.addUpdateListener(new AnimatorUpdateListener(this) {
                final /* synthetic */ ca iPM;

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    com.tencent.mm.plugin.appbrand.g.m mVar = b;
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    mVar.jdh = true;
                    mVar.jdi = intValue;
                    mVar.runOnUiThread(new Runnable(mVar) {
                        final /* synthetic */ m jdm;

                        {
                            this.jdm = r1;
                        }

                        public final void run() {
                            this.jdm.C(this.jdm.jdi, this.jdm.jdk);
                        }
                    });
                    mVar = b;
                    mVar.runOnUiThread(new AnonymousClass8(mVar, ((Integer) valueAnimator.getAnimatedValue()).intValue()));
                }
            });
            ValueAnimator valueAnimator2 = new ValueAnimator();
            valueAnimator2.setIntValues(new int[]{i6, i2});
            valueAnimator2.setEvaluator(new ArgbEvaluator());
            valueAnimator2.setDuration((long) i4);
            valueAnimator2.setInterpolator(linearInterpolator);
            valueAnimator2.addUpdateListener(new AnimatorUpdateListener(this) {
                final /* synthetic */ ca iPM;

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    com.tencent.mm.plugin.appbrand.g.m mVar = b;
                    mVar.runOnUiThread(new AnonymousClass14(mVar, ((Integer) valueAnimator.getAnimatedValue()).intValue()));
                }
            });
            valueAnimator.start();
            valueAnimator2.start();
        } catch (Exception e) {
            w.e("MicroMsg.JsApiSetNavigationBarColor", "Color parse error");
            mVar.x(i, d("fail", null));
        }
    }
}
