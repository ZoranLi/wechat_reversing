package com.tencent.mm.plugin.appbrand.widget.d;

import android.view.View;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import org.json.JSONObject;

public abstract class a extends c {
    public static final LinkedList<Runnable> jxG = new LinkedList();
    public static boolean jxH = false;
    public static a jxI = new a() {
        public final void Zz() {
            d.vL().D(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 jxJ;

                {
                    this.jxJ = r1;
                }

                public final void run() {
                    synchronized (this) {
                        Runnable runnable = (Runnable) a.jxG.pollFirst();
                        if (runnable != null) {
                            runnable.run();
                        } else {
                            w.i("MicroMsg.BaseMarkerAnimatorJsApi", "markerAnimatorJsApi processed!");
                            a.jxH = false;
                        }
                    }
                }
            });
        }
    };

    public interface a {
        void Zz();
    }

    public abstract boolean a(m mVar, int i, View view, JSONObject jSONObject, a aVar, a aVar2);

    protected final boolean a(m mVar, int i, View view, JSONObject jSONObject, a aVar) {
        final m mVar2 = mVar;
        final int i2 = i;
        final View view2 = view;
        final JSONObject jSONObject2 = jSONObject;
        final a aVar2 = aVar;
        Runnable anonymousClass2 = new Runnable(this) {
            final /* synthetic */ a jxL;

            public final void run() {
                this.jxL.a(mVar2, i2, view2, jSONObject2, a.jxI, aVar2);
            }
        };
        if (jxH) {
            jxG.add(anonymousClass2);
            w.i("MicroMsg.BaseMarkerAnimatorJsApi", "add to MarkerAnimator!");
        } else {
            jxH = true;
            anonymousClass2.run();
        }
        return true;
    }
}
