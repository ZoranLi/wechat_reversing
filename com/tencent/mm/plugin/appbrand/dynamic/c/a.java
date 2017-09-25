package com.tencent.mm.plugin.appbrand.dynamic.c;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.d;
import junit.framework.Assert;

public final class a implements com.tencent.mm.pluginsdk.b.a {

    private static class a implements com.tencent.mm.ipcinvoker.a {
        private a() {
        }

        public final void a(Bundle bundle, c cVar) {
            com.tencent.mm.bk.a.e(new Runnable(this) {
                final /* synthetic */ a iHb;

                {
                    this.iHb = r1;
                }

                public final void run() {
                    Assert.assertTrue(String.format("execute assert process(%s) command", new Object[]{d.up()}), false);
                }
            });
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.content.Context r7, final java.lang.String[] r8) {
        /*
        r6 = this;
        r2 = -1;
        r5 = 2;
        r1 = 0;
        r3 = 1;
        r0 = com.tencent.mm.modelappbrand.e.class;
        r0 = com.tencent.mm.kernel.h.h(r0);
        r0 = (com.tencent.mm.modelappbrand.e) r0;
        r0 = r0.AN();
        r0 = r0.AQ();
        if (r0 != 0) goto L_0x0017;
    L_0x0016:
        return r3;
    L_0x0017:
        r0 = "//widget";
        r4 = r8[r1];
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0016;
    L_0x0022:
        r0 = r8.length;
        if (r0 < r5) goto L_0x0016;
    L_0x0025:
        r0 = r8[r3];
        r0 = r0.toLowerCase();
        r4 = r0.hashCode();
        switch(r4) {
            case -1408208058: goto L_0x0040;
            case 547812385: goto L_0x004b;
            default: goto L_0x0032;
        };
    L_0x0032:
        r0 = r2;
    L_0x0033:
        switch(r0) {
            case 0: goto L_0x0037;
            case 1: goto L_0x0056;
            default: goto L_0x0036;
        };
    L_0x0036:
        goto L_0x0016;
    L_0x0037:
        r0 = new com.tencent.mm.plugin.appbrand.dynamic.c.a$1;
        r0.<init>(r6, r8);
        com.tencent.mm.bk.a.post(r0);
        goto L_0x0016;
    L_0x0040:
        r4 = "assert";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0032;
    L_0x0049:
        r0 = r1;
        goto L_0x0033;
    L_0x004b:
        r4 = "debugger";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x0032;
    L_0x0054:
        r0 = r3;
        goto L_0x0033;
    L_0x0056:
        r0 = r8.length;
        if (r0 <= r5) goto L_0x0016;
    L_0x0059:
        r0 = r8[r5];
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x0016;
    L_0x0061:
        r0 = r8[r5];
        r4 = r0.hashCode();
        switch(r4) {
            case 46428: goto L_0x008a;
            case 46800: goto L_0x007f;
            default: goto L_0x006a;
        };
    L_0x006a:
        r0 = r2;
    L_0x006b:
        switch(r0) {
            case 0: goto L_0x006f;
            case 1: goto L_0x0095;
            default: goto L_0x006e;
        };
    L_0x006e:
        goto L_0x0016;
    L_0x006f:
        r0 = com.tencent.mm.modelappbrand.e.class;
        r0 = com.tencent.mm.kernel.h.h(r0);
        r0 = (com.tencent.mm.modelappbrand.e) r0;
        r0 = r0.AN();
        r0.aU(r3);
        goto L_0x0016;
    L_0x007f:
        r4 = "-or";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x006a;
    L_0x0088:
        r0 = r1;
        goto L_0x006b;
    L_0x008a:
        r4 = "-cr";
        r0 = r0.equals(r4);
        if (r0 == 0) goto L_0x006a;
    L_0x0093:
        r0 = r3;
        goto L_0x006b;
    L_0x0095:
        r0 = com.tencent.mm.modelappbrand.e.class;
        r0 = com.tencent.mm.kernel.h.h(r0);
        r0 = (com.tencent.mm.modelappbrand.e) r0;
        r0 = r0.AN();
        r0.aU(r1);
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.dynamic.c.a.a(android.content.Context, java.lang.String[]):boolean");
    }
}
