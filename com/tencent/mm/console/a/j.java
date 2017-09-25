package com.tencent.mm.console.a;

import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.b;

public final class j implements a {
    static {
        b.a(new j(), "//wear");
    }

    public static void init() {
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(android.content.Context r8, java.lang.String[] r9) {
        /*
        r7 = this;
        r6 = 0;
        r3 = 2;
        r0 = 0;
        r2 = -1;
        r1 = 1;
        r4 = com.tencent.mm.sdk.platformtools.w.getLogLevel();
        if (r4 == 0) goto L_0x000c;
    L_0x000b:
        return r0;
    L_0x000c:
        r4 = r9.length;
        if (r4 >= r3) goto L_0x0011;
    L_0x000f:
        r0 = r1;
        goto L_0x000b;
    L_0x0011:
        r4 = r9[r1];
        r5 = r4.hashCode();
        switch(r5) {
            case 107332: goto L_0x0020;
            case 351608024: goto L_0x002a;
            case 990157655: goto L_0x0035;
            default: goto L_0x001a;
        };
    L_0x001a:
        r0 = r2;
    L_0x001b:
        switch(r0) {
            case 0: goto L_0x0040;
            case 1: goto L_0x0046;
            default: goto L_0x001e;
        };
    L_0x001e:
        r0 = r1;
        goto L_0x000b;
    L_0x0020:
        r3 = "log";
        r3 = r4.equals(r3);
        if (r3 == 0) goto L_0x001a;
    L_0x0029:
        goto L_0x001b;
    L_0x002a:
        r0 = "version";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x001a;
    L_0x0033:
        r0 = r1;
        goto L_0x001b;
    L_0x0035:
        r0 = "reconnect";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x001a;
    L_0x003e:
        r0 = r3;
        goto L_0x001b;
    L_0x0040:
        r0 = com.tencent.mm.pluginsdk.l.ab.sBH;
        r0.bvJ();
        goto L_0x001e;
    L_0x0046:
        r0 = new android.widget.TextView;
        r0.<init>(r8);
        r3 = com.tencent.mm.pluginsdk.l.ab.sBH;
        r3 = r3.bvI();
        r0.setText(r3);
        r3 = 19;
        r0.setGravity(r3);
        r3 = 1092616192; // 0x41200000 float:10.0 double:5.398241246E-315;
        r0.setTextSize(r1, r3);
        r3 = new android.view.ViewGroup$LayoutParams;
        r4 = -2;
        r3.<init>(r2, r4);
        r0.setLayoutParams(r3);
        r2 = -16711936; // 0xffffffffff00ff00 float:-1.7146522E38 double:NaN;
        r0.setTextColor(r2);
        r2 = android.graphics.Typeface.MONOSPACE;
        r0.setTypeface(r2);
        r2 = r8.getResources();
        r3 = com.tencent.mm.R.f.aXt;
        r2 = r2.getDimensionPixelSize(r3);
        r0.setPadding(r2, r2, r2, r2);
        com.tencent.mm.ui.base.g.a(r8, r6, r0, r6);
        goto L_0x001e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.console.a.j.a(android.content.Context, java.lang.String[]):boolean");
    }
}
