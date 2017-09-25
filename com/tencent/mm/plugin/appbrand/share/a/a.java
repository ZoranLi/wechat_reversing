package com.tencent.mm.plugin.appbrand.share.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.e;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.modelappbrand.h;
import com.tencent.mm.modelappbrand.r;
import com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class a implements h {
    private final Map<String, SoftReference<e>> jhf = new ConcurrentHashMap();
    private final Map<String, SoftReference<f>> jhg = new ConcurrentHashMap();
    private final Map<Integer, a> jhh = new ConcurrentHashMap();

    private interface a {
        void w(Bundle bundle);
    }

    public final View aR(Context context) {
        Assert.assertNotNull(context);
        return new WxaShareMessagePage(context);
    }

    public final boolean a(String str, View view, Bundle bundle) {
        Assert.assertNotNull(view);
        Assert.assertNotNull(bundle);
        if (!(view instanceof WxaShareMessagePage)) {
            return false;
        }
        w.i("MicroMsg.WxaShareMessageService", "onBindView(%s, %s)", new Object[]{str, Integer.valueOf(view.hashCode())});
        final WxaShareMessagePage wxaShareMessagePage = (WxaShareMessagePage) view;
        boolean z = bundle.getBoolean("is_dynamic_page");
        wxaShareMessagePage.jhl.setText(bundle.getString("title", ""));
        if (z) {
            wxaShareMessagePage.jhm.setVisibility(4);
            View view2 = wxaShareMessagePage.jho;
            view2.setVisibility(0);
            bundle.putInt("view_init_width", WxaShareMessagePage.WA());
            bundle.putInt("view_init_height", WxaShareMessagePage.WB());
            ((com.tencent.mm.modelappbrand.e) com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.e.class)).a(str, view2, bundle, new r(new com.tencent.mm.modelappbrand.f(this) {
                final /* synthetic */ a jhj;

                public final void q(View view, int i) {
                    switch (i) {
                        case 0:
                            wxaShareMessagePage.jhp.setVisibility(0);
                            wxaShareMessagePage.jhn.setVisibility(4);
                            wxaShareMessagePage.jhp.caQ();
                            return;
                        case 1:
                            wxaShareMessagePage.jhp.Wd();
                            wxaShareMessagePage.jhp.setVisibility(4);
                            wxaShareMessagePage.jhn.setVisibility(0);
                            wxaShareMessagePage.jhn.setImageResource(R.k.dwD);
                            return;
                        case 4:
                            wxaShareMessagePage.jhp.setVisibility(4);
                            wxaShareMessagePage.jhn.setVisibility(4);
                            return;
                        default:
                            wxaShareMessagePage.jhp.Wd();
                            wxaShareMessagePage.jhp.setVisibility(4);
                            wxaShareMessagePage.jhn.setVisibility(0);
                            wxaShareMessagePage.jhn.setImageResource(R.k.dtG);
                            return;
                    }
                }
            }));
        } else {
            wxaShareMessagePage.jho.setVisibility(4);
            wxaShareMessagePage.jhm.setVisibility(0);
            byte[] byteArray = bundle.getByteArray("image_data");
            if (byteArray != null && byteArray.length > 0) {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                if (!(decodeByteArray == null || decodeByteArray.isRecycled())) {
                    wxaShareMessagePage.n(decodeByteArray);
                    return true;
                }
            }
            String string = bundle.getString("delay_load_img_path");
            if (bg.mA(string)) {
                wxaShareMessagePage.qG(bundle.getString("image_url"));
            } else {
                Bitmap gN = b.AY().gN(string);
                if (gN != null) {
                    if (gN.isRecycled()) {
                        wxaShareMessagePage.qG(string);
                    } else {
                        wxaShareMessagePage.n(gN);
                    }
                    return true;
                }
                wxaShareMessagePage.jhp.setVisibility(0);
                wxaShareMessagePage.jhn.setVisibility(4);
                wxaShareMessagePage.jhm.setVisibility(4);
                wxaShareMessagePage.jhp.caQ();
                this.jhh.put(Integer.valueOf(1), new a(this) {
                    final /* synthetic */ a jhj;

                    public final void w(final Bundle bundle) {
                        com.tencent.mm.bk.a.W(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 jhk;

                            public final void run() {
                                wxaShareMessagePage.qG(bundle.getString("delay_load_img_path"));
                            }
                        });
                    }
                });
            }
        }
        return true;
    }

    public final void a(String str, View view) {
        Assert.assertNotNull(view);
        if (view instanceof WxaShareMessagePage) {
            w.i("MicroMsg.WxaShareMessageService", "onUnbindView(%s, %s)", new Object[]{str, Integer.valueOf(view.hashCode())});
            ((com.tencent.mm.modelappbrand.e) com.tencent.mm.kernel.h.h(com.tencent.mm.modelappbrand.e.class)).a(str, ((WxaShareMessagePage) view).jho);
            this.jhh.remove(Integer.valueOf(1));
        }
    }

    public final void n(Bundle bundle) {
        a aVar = (a) this.jhh.get(Integer.valueOf(1));
        if (aVar != null) {
            aVar.w(bundle);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.modelappbrand.a.b.e aL(int r5, int r6) {
        /*
        r4 = this;
        r0 = "%d-%d-dp";
        r1 = 2;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = java.lang.Integer.valueOf(r5);
        r1[r2] = r3;
        r2 = 1;
        r3 = java.lang.Integer.valueOf(r6);
        r1[r2] = r3;
        r1 = java.lang.String.format(r0, r1);
        r0 = r4.jhf;
        r0 = r0.get(r1);
        r0 = (java.lang.ref.SoftReference) r0;
        if (r0 == 0) goto L_0x002a;
    L_0x0022:
        r0 = r0.get();
        r0 = (com.tencent.mm.modelappbrand.a.b.e) r0;
        if (r0 != 0) goto L_0x005d;
    L_0x002a:
        monitor-enter(r4);
        r0 = r4.jhf;	 Catch:{ all -> 0x005e }
        r0 = r0.get(r1);	 Catch:{ all -> 0x005e }
        r0 = (java.lang.ref.SoftReference) r0;	 Catch:{ all -> 0x005e }
        if (r0 == 0) goto L_0x003d;
    L_0x0035:
        r0 = r0.get();	 Catch:{ all -> 0x005e }
        r0 = (com.tencent.mm.modelappbrand.a.b.e) r0;	 Catch:{ all -> 0x005e }
        if (r0 != 0) goto L_0x005c;
    L_0x003d:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x005e }
        r2 = com.tencent.mm.bg.a.fromDPToPix(r0, r5);	 Catch:{ all -> 0x005e }
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x005e }
        r3 = com.tencent.mm.bg.a.fromDPToPix(r0, r6);	 Catch:{ all -> 0x005e }
        r0 = new com.tencent.mm.plugin.appbrand.share.a;	 Catch:{ all -> 0x005e }
        r0.<init>(r2, r3);	 Catch:{ all -> 0x005e }
        r2 = r4.jhf;	 Catch:{ all -> 0x005e }
        r3 = new java.lang.ref.SoftReference;	 Catch:{ all -> 0x005e }
        r3.<init>(r0);	 Catch:{ all -> 0x005e }
        r2.put(r1, r3);	 Catch:{ all -> 0x005e }
    L_0x005c:
        monitor-exit(r4);	 Catch:{ all -> 0x005e }
    L_0x005d:
        return r0;
    L_0x005e:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x005e }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.share.a.a.aL(int, int):com.tencent.mm.modelappbrand.a.b$e");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.modelappbrand.a.b.f AO() {
        /*
        r5 = this;
        r3 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r4 = 90;
        r0 = "%d-%d-dp";
        r1 = 2;
        r1 = new java.lang.Object[r1];
        r2 = 0;
        r3 = java.lang.Integer.valueOf(r3);
        r1[r2] = r3;
        r2 = 1;
        r3 = java.lang.Integer.valueOf(r4);
        r1[r2] = r3;
        r1 = java.lang.String.format(r0, r1);
        r0 = r5.jhg;
        r0 = r0.get(r1);
        r0 = (java.lang.ref.SoftReference) r0;
        if (r0 == 0) goto L_0x002e;
    L_0x0026:
        r0 = r0.get();
        r0 = (com.tencent.mm.modelappbrand.a.b.f) r0;
        if (r0 != 0) goto L_0x0065;
    L_0x002e:
        monitor-enter(r5);
        r0 = r5.jhg;	 Catch:{ all -> 0x0066 }
        r0 = r0.get(r1);	 Catch:{ all -> 0x0066 }
        r0 = (java.lang.ref.SoftReference) r0;	 Catch:{ all -> 0x0066 }
        if (r0 == 0) goto L_0x0041;
    L_0x0039:
        r0 = r0.get();	 Catch:{ all -> 0x0066 }
        r0 = (com.tencent.mm.modelappbrand.a.b.f) r0;	 Catch:{ all -> 0x0066 }
        if (r0 != 0) goto L_0x0064;
    L_0x0041:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x0066 }
        r2 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r2 = com.tencent.mm.bg.a.fromDPToPix(r0, r2);	 Catch:{ all -> 0x0066 }
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x0066 }
        r3 = 90;
        r3 = com.tencent.mm.bg.a.fromDPToPix(r0, r3);	 Catch:{ all -> 0x0066 }
        r0 = new com.tencent.mm.plugin.appbrand.share.b;	 Catch:{ all -> 0x0066 }
        r0.<init>(r2, r3);	 Catch:{ all -> 0x0066 }
        r2 = r5.jhg;	 Catch:{ all -> 0x0066 }
        r3 = new java.lang.ref.SoftReference;	 Catch:{ all -> 0x0066 }
        r3.<init>(r0);	 Catch:{ all -> 0x0066 }
        r2.put(r1, r3);	 Catch:{ all -> 0x0066 }
    L_0x0064:
        monitor-exit(r5);	 Catch:{ all -> 0x0066 }
    L_0x0065:
        return r0;
    L_0x0066:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0066 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.share.a.a.AO():com.tencent.mm.modelappbrand.a.b$f");
    }
}
