package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ListView;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.widget.input.i.a;
import com.tencent.mm.plugin.appbrand.widget.input.y;

public final class c {
    final y jvV;
    public final e jvW;
    public final a jwi = new a(this) {
        final /* synthetic */ c jwm;

        {
            this.jwm = r1;
        }

        public final void YJ() {
            this.jwm.jwk = Integer.MIN_VALUE;
            this.jwm.iX(3);
        }

        public final void YK() {
            this.jwm.jwk = Integer.MIN_VALUE;
            this.jwm.iX(3);
        }
    };
    public m jwj;
    public int jwk = Integer.MIN_VALUE;
    boolean jwl = false;

    c(y yVar, e eVar) {
        this.jvV = yVar;
        this.jvW = eVar;
    }

    public final void iX(final int i) {
        final ListView listView = this.jvW.jwq;
        if (listView != null && this.jvW.iuS.isShowing()) {
            if (1 == i && this.jwl) {
                this.jwk = Integer.MIN_VALUE;
                this.jwl = false;
            }
            listView.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                final /* synthetic */ c jwm;

                /* JADX WARNING: inconsistent code. */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final boolean onPreDraw() {
                    /*
                    r12 = this;
                    r6 = 0;
                    r10 = 1;
                    r0 = r0;
                    r0 = r0.getViewTreeObserver();
                    r0.removeOnPreDrawListener(r12);
                    r5 = r12.jwm;
                    r0 = r5.jvW;
                    r0 = r0.iuS;
                    r0 = r0.isShowing();
                    if (r0 == 0) goto L_0x0035;
                L_0x0017:
                    r0 = r5.jvW;
                    r0 = r0.jwq;
                    if (r0 == 0) goto L_0x0035;
                L_0x001d:
                    r0 = r5.jvW;
                    r0 = r0.jwq;
                    r0 = r0.getAdapter();
                    if (r0 == 0) goto L_0x0035;
                L_0x0027:
                    r0 = r5.jvW;
                    r0 = r0.jwq;
                    r0 = r0.getAdapter();
                    r0 = r0.getCount();
                    if (r0 > 0) goto L_0x0036;
                L_0x0035:
                    return r10;
                L_0x0036:
                    r0 = r5.jvV;
                    r4 = r0.Yq();
                    if (r4 == 0) goto L_0x0035;
                L_0x003e:
                    r0 = r5.jvV;
                    r0 = r0.getContext();
                    r1 = 8;
                    r7 = com.tencent.mm.bg.a.fromDPToPix(r0, r1);
                    r0 = r5.jvW;
                    r0 = r0.jwq;
                    r0 = r0.getChildAt(r6);
                    r3 = r0.getHeight();
                    r0 = r5.jvW;
                    r0 = r0.jwq;
                    r0 = r0.getAdapter();
                    r0 = r0.getCount();
                    r2 = r0 * r3;
                    r0 = r7 * 2;
                    r1 = r2 + r0;
                    r0 = r3 * 3;
                    r8 = r7 * 2;
                    r0 = r0 + r8;
                    if (r1 <= r0) goto L_0x013d;
                L_0x006f:
                    r1 = r7 * 2;
                    r1 = r0 - r1;
                L_0x0073:
                    r2 = r5.jvW;
                    r2.XW = r0;
                    r0 = 2;
                    r0 = new int[r0];
                    r2 = r5.jvV;
                    r2 = r2.getView();
                    r2.getLocationInWindow(r0);
                    r2 = r0[r10];
                    r8 = r5.jvV;
                    r8 = r8.getView();
                    r8 = r8.getHeight();
                    r2 = r2 + r8;
                    r4.getLocationInWindow(r0);
                    r0 = r0[r10];
                    r4 = r5;
                    r11 = r0;
                    r0 = r3;
                    r3 = r2;
                    r2 = r11;
                L_0x009a:
                    r8 = r4.jwk;
                    r9 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
                    if (r8 == r9) goto L_0x00a6;
                L_0x00a0:
                    r8 = r4.jwk;
                    r9 = 0 - r7;
                    if (r8 < r9) goto L_0x00d4;
                L_0x00a6:
                    r8 = r2 - r3;
                    r9 = r1 + r7;
                    if (r8 < r9) goto L_0x00d4;
                L_0x00ac:
                    r0 = r4.jvW;
                    r2 = r4.jvV;
                    r2 = r2.getView();
                    r0.Yg = r2;
                    r0 = r4.jvW;
                    r2 = r7 * 2;
                    r1 = r1 + r2;
                    r0.XW = r1;
                    r0 = r4.jvW;
                    r1 = 0 - r7;
                    r0.setVerticalOffset(r1);
                L_0x00c4:
                    r0 = r5.jvW;
                    r0.show();
                    r0 = r5.jvW;
                    r1 = r0.Ya;
                    if (r1 != 0) goto L_0x013a;
                L_0x00cf:
                    r0 = r6;
                L_0x00d0:
                    r5.jwk = r0;
                    goto L_0x0035;
                L_0x00d4:
                    r8 = r4.jvV;
                    r8 = r8.getView();
                    r8 = r8.getHeight();
                    r8 = r3 - r8;
                    if (r8 < r1) goto L_0x0106;
                L_0x00e2:
                    r0 = r4.jvW;
                    r2 = r4.jvV;
                    r2 = r2.getView();
                    r0.Yg = r2;
                    r0 = r4.jvW;
                    r2 = r7 * 2;
                    r2 = r2 + r1;
                    r0.XW = r2;
                    r0 = r4.jvW;
                    r1 = r1 + r7;
                    r1 = -r1;
                    r2 = r4.jvV;
                    r2 = r2.getView();
                    r2 = r2.getHeight();
                    r1 = r1 - r2;
                    r0.setVerticalOffset(r1);
                    goto L_0x00c4;
                L_0x0106:
                    if (r1 > r0) goto L_0x0137;
                L_0x0108:
                    r2 = r4.jvW;
                    r2.XW = r0;
                    r0 = r4.jvW;
                    r2 = r4.jvV;
                    r2 = r2.getView();
                    r0.Yg = r2;
                    r0 = r4.jwk;
                    r2 = 0 - r7;
                    if (r0 >= r2) goto L_0x012f;
                L_0x011c:
                    r0 = r4.jvW;
                    r1 = r1 + r7;
                    r1 = -r1;
                    r2 = r4.jvV;
                    r2 = r2.getView();
                    r2 = r2.getHeight();
                    r1 = r1 - r2;
                    r0.setVerticalOffset(r1);
                    goto L_0x00c4;
                L_0x012f:
                    r0 = r4.jvW;
                    r1 = 0 - r7;
                    r0.setVerticalOffset(r1);
                    goto L_0x00c4;
                L_0x0137:
                    r1 = r1 - r0;
                    goto L_0x009a;
                L_0x013a:
                    r0 = r0.XY;
                    goto L_0x00d0;
                L_0x013d:
                    r0 = r1;
                    r1 = r2;
                    goto L_0x0073;
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.widget.input.autofill.c.3.onPreDraw():boolean");
                }
            });
        }
    }
}
