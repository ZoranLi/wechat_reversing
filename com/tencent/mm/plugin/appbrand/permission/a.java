package com.tencent.mm.plugin.appbrand.permission;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.SparseIntArray;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.g.j;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.appbrand.jsapi.share.c;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.widget.f;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.Set;

final class a {
    private static final SparseIntArray jfc = new SparseIntArray() {
        public final int get(int i) {
            return super.get(i, R.l.dEE);
        }
    };
    private static final Set<String> jfd = new HashSet();

    static {
        jfc.put(b.NAME.hashCode(), R.l.dEA);
        jfc.put(JsApiStartPlayVoice.NAME.hashCode(), R.l.dEB);
        jfc.put(JsApiOperateMusicPlayer.NAME.hashCode(), R.l.dEB);
        jfc.put(com.tencent.mm.plugin.appbrand.jsapi.share.b.NAME.hashCode(), R.l.dEC);
        jfc.put(com.tencent.mm.plugin.appbrand.menu.f.a.NAME.hashCode(), R.l.dEC);
        jfc.put(c.NAME.hashCode(), R.l.dEC);
        jfc.put("shareTimeline".hashCode(), R.l.dEC);
        jfc.put(com.tencent.mm.plugin.appbrand.menu.g.a.NAME.hashCode(), R.l.dEC);
        jfc.put("launchMiniProgram".hashCode(), R.l.dEz);
        jfd.add(b.NAME);
        jfd.add(JsApiStartPlayVoice.NAME);
        jfd.add(JsApiOperateMusicPlayer.NAME);
        jfd.add(com.tencent.mm.plugin.appbrand.jsapi.share.b.NAME);
        jfd.add(com.tencent.mm.plugin.appbrand.menu.f.a.NAME);
        jfd.add(c.NAME);
        jfd.add("shareTimeline");
        jfd.add(com.tencent.mm.plugin.appbrand.menu.g.a.NAME);
        jfd.add("launchMiniProgram");
        jfd.add(JsApiMakeVoIPCall.NAME);
        jfd.add(m.NAME);
        jfd.add(q.NAME);
        jfd.add(bc.NAME);
    }

    static void a(final h hVar, com.tencent.mm.plugin.appbrand.jsapi.b bVar) {
        if (hVar != null && bVar != null && jfd.contains(bVar.getName())) {
            String string = ab.getResources().getString(jfc.get(bVar.getName().hashCode()));
            string = ab.getResources().getString(R.l.dED, new Object[]{string});
            d.runOnUiThread(new Runnable() {
                public final void run() {
                    j jVar = hVar.iwr;
                    if (jVar != null) {
                        com.tencent.mm.plugin.appbrand.g.h VN = jVar.VN();
                        if (VN != null) {
                            com.tencent.mm.plugin.appbrand.g.m VC = VN.VC();
                            if (VC != null) {
                                CharSequence charSequence = string;
                                if (VC.jdg != null) {
                                    f fVar = VC.jdg;
                                    fVar.jqH.setText(charSequence);
                                    if (fVar.getTranslationY() != 0.0f && fVar.jqY == null) {
                                        fVar.jqU = a.jrd;
                                        fVar.setVisibility(0);
                                        fVar.jqY = fVar.animate().translationY(0.0f);
                                        fVar.jqY.setListener(new AnimatorListenerAdapter(fVar) {
                                            final /* synthetic */ f jra;

                                            {
                                                this.jra = r1;
                                            }

                                            public final void onAnimationEnd(Animator animator) {
                                                this.jra.mHandler.postDelayed(this.jra.jqW, f.jqV);
                                                this.jra.jqY = null;
                                                this.jra.jqU = a.jre;
                                            }
                                        });
                                        fVar.jqY.start();
                                    }
                                }
                            }
                        }
                    }
                }
            });
        }
    }
}
