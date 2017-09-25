package com.tencent.mm.plugin.appbrand.jsapi.base;

import android.os.Looper;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.g.m.c;
import com.tencent.mm.plugin.appbrand.g.s;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q.b;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class a extends d {

    class AnonymousClass2 implements c {
        final /* synthetic */ m iMo;
        final /* synthetic */ b iOl;
        final /* synthetic */ a iRj;
        final /* synthetic */ int iRk;

        AnonymousClass2(a aVar, m mVar, int i, b bVar) {
            this.iRj = aVar;
            this.iMo = mVar;
            this.iRk = i;
            this.iOl = bVar;
        }

        public final void onDestroy() {
            this.iMo.b((c) this);
            af.v(new Runnable(this) {
                final /* synthetic */ AnonymousClass2 iRl;

                {
                    this.iRl = r1;
                }

                public final void run() {
                    this.iRl.iMo.jdc.ii(this.iRl.iRk);
                }
            });
            this.iMo.jdc.im(this.iRk);
            this.iOl.recycle();
            System.gc();
        }
    }

    public abstract View a(m mVar, JSONObject jSONObject);

    public final void a(com.tencent.mm.plugin.appbrand.m mVar, JSONObject jSONObject, int i) {
        super.a(mVar, jSONObject, i);
        m b = d.b(mVar);
        if (b == null) {
            w.w("MicroMsg.BaseInsertViewJsApi", "invoke JsApi insertView failed, current page view is null.");
            mVar.x(i, d("fail:page is null", null));
            return;
        }
        a(mVar, i, b, jSONObject);
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        super.a(mVar, jSONObject, i);
        a(mVar, i, mVar, jSONObject);
    }

    private void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, int i, m mVar, JSONObject jSONObject) {
        final m mVar2 = mVar;
        final com.tencent.mm.plugin.appbrand.jsapi.c cVar2 = cVar;
        final int i2 = i;
        final JSONObject jSONObject2 = jSONObject;
        af.v(new Runnable(this) {
            final /* synthetic */ a iRj;

            public final void run() {
                if (mVar2 == null) {
                    w.w("MicroMsg.BaseInsertViewJsApi", "page view has been release.");
                    cVar2.x(i2, this.iRj.d("fail:page is null", null));
                    return;
                }
                View a = this.iRj.a(mVar2, jSONObject2);
                if (a == null) {
                    w.w("MicroMsg.BaseInsertViewJsApi", "inflate view return null.");
                    cVar2.x(i2, this.iRj.d("inflate view failed", null));
                    return;
                }
                try {
                    int h = this.iRj.h(jSONObject2);
                    if (mVar2.jdc.ik(h)) {
                        w.w("MicroMsg.BaseInsertViewJsApi", "insert view(%d) failed, it has been inserted before.", new Object[]{Integer.valueOf(h)});
                        cVar2.x(i2, this.iRj.d("fail:the view has already exist", null));
                        return;
                    }
                    boolean booleanValue;
                    b B;
                    String str;
                    int optInt = jSONObject2.optInt("parentId", 0);
                    try {
                        int[] i = d.i(jSONObject2);
                        int j = d.j(jSONObject2);
                        s sVar = mVar2.jdc;
                        bb anonymousClass2 = new com.tencent.mm.plugin.appbrand.g.s.AnonymousClass2(sVar, Boolean.valueOf(false), a, h, optInt, i, j);
                        booleanValue = Thread.currentThread() == Looper.getMainLooper().getThread() ? ((Boolean) anonymousClass2.b(null)).booleanValue() : ((Boolean) anonymousClass2.b(sVar.mHandler)).booleanValue();
                    } catch (JSONException e) {
                        w.e("MicroMsg.BaseInsertViewJsApi", "parse position error. Exception :%s", new Object[]{e});
                        booleanValue = false;
                    }
                    if (booleanValue) {
                        a aVar = this.iRj;
                        m mVar = mVar2;
                        JSONObject jSONObject = jSONObject2;
                        if (aVar.Tf()) {
                            B = mVar.jdc.B(h, true);
                            B.o("disableScroll", jSONObject.optBoolean("disableScroll", false));
                            B.o("enableLongClick", aVar.Tg());
                            B.H(SlookAirButtonFrequentContactAdapter.DATA, jSONObject.optString(SlookAirButtonFrequentContactAdapter.DATA));
                            if (jSONObject.optBoolean("gesture", false)) {
                                if (mVar == null || a == null || B == null) {
                                    w.i("MicroMsg.ViewMotionHelper", "setOnTouchListener failed, page or view or keyValueSet is null.");
                                } else {
                                    a.setOnTouchListener(new com.tencent.mm.plugin.appbrand.jsapi.k.b.a(mVar, B));
                                }
                            }
                        }
                        this.iRj.b(mVar2, h, a, jSONObject2);
                    }
                    a aVar2 = this.iRj;
                    m mVar2 = mVar2;
                    B = mVar2.jdc.B(h, true);
                    if (((c) B.fS("baseViewDestroyListener")) == null) {
                        c anonymousClass22 = new AnonymousClass2(aVar2, mVar2, h, B);
                        B.l("baseViewDestroyListener", anonymousClass22);
                        mVar2.a(anonymousClass22);
                    }
                    w.i("MicroMsg.BaseInsertViewJsApi", "insert view(parentId : %s, viewId : %s, view : %s, r : %s)", new Object[]{Integer.valueOf(optInt), Integer.valueOf(h), Integer.valueOf(a.hashCode()), Boolean.valueOf(booleanValue)});
                    com.tencent.mm.plugin.appbrand.jsapi.c cVar = cVar2;
                    int i2 = i2;
                    d dVar = this.iRj;
                    if (booleanValue) {
                        str = "ok";
                    } else {
                        str = "fail:insert view fail";
                    }
                    cVar.x(i2, dVar.d(str, null));
                } catch (JSONException e2) {
                    cVar2.x(i2, this.iRj.d("fail:invalid view id", null));
                }
            }
        });
    }

    public void b(m mVar, int i, View view, JSONObject jSONObject) {
    }

    public boolean Tf() {
        return false;
    }

    public boolean Tg() {
        return false;
    }
}
