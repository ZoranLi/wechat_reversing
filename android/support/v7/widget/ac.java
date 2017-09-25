package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.b.k;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.q;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public final class ac extends a {
    final RecyclerView aak;
    final a abu = new a(this) {
        final /* synthetic */ ac abv;

        {
            this.abv = r1;
        }

        public final void a(View view, b bVar) {
            super.a(view, bVar);
            if (!this.abv.gd() && this.abv.aak.Zf != null) {
                this.abv.aak.Zf.b(view, bVar);
            }
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (this.abv.gd() || this.abv.aak.Zf == null) {
                return false;
            }
            h hVar = this.abv.aak.Zf;
            m mVar = hVar.aak.YX;
            q qVar = hVar.aak.ZL;
            return false;
        }
    };

    public ac(RecyclerView recyclerView) {
        this.aak = recyclerView;
    }

    public final boolean gd() {
        RecyclerView recyclerView = this.aak;
        return !recyclerView.Zm || recyclerView.Zv || recyclerView.YZ.et();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean performAccessibilityAction(android.view.View r8, int r9, android.os.Bundle r10) {
        /*
        r7 = this;
        r5 = -1;
        r2 = 1;
        r1 = 0;
        r0 = super.performAccessibilityAction(r8, r9, r10);
        if (r0 == 0) goto L_0x000b;
    L_0x0009:
        r1 = r2;
    L_0x000a:
        return r1;
    L_0x000b:
        r0 = r7.gd();
        if (r0 != 0) goto L_0x000a;
    L_0x0011:
        r0 = r7.aak;
        r0 = r0.Zf;
        if (r0 == 0) goto L_0x000a;
    L_0x0017:
        r0 = r7.aak;
        r4 = r0.Zf;
        r0 = r4.aak;
        r0 = r0.YX;
        r0 = r4.aak;
        r0 = r0.ZL;
        r0 = r4.aak;
        if (r0 == 0) goto L_0x000a;
    L_0x0027:
        switch(r9) {
            case 4096: goto L_0x0065;
            case 8192: goto L_0x0037;
            default: goto L_0x002a;
        };
    L_0x002a:
        r0 = r1;
        r3 = r1;
    L_0x002c:
        if (r3 != 0) goto L_0x0030;
    L_0x002e:
        if (r0 == 0) goto L_0x000a;
    L_0x0030:
        r1 = r4.aak;
        r1.scrollBy(r0, r3);
        r1 = r2;
        goto L_0x000a;
    L_0x0037:
        r0 = r4.aak;
        r0 = android.support.v4.view.z.h(r0, r5);
        if (r0 == 0) goto L_0x0096;
    L_0x003f:
        r0 = r4.RQ;
        r3 = r4.getPaddingTop();
        r0 = r0 - r3;
        r3 = r4.getPaddingBottom();
        r0 = r0 - r3;
        r0 = -r0;
    L_0x004c:
        r3 = r4.aak;
        r3 = android.support.v4.view.z.g(r3, r5);
        if (r3 == 0) goto L_0x0091;
    L_0x0054:
        r3 = r4.aar;
        r5 = r4.getPaddingLeft();
        r3 = r3 - r5;
        r5 = r4.getPaddingRight();
        r3 = r3 - r5;
        r3 = -r3;
        r6 = r3;
        r3 = r0;
        r0 = r6;
        goto L_0x002c;
    L_0x0065:
        r0 = r4.aak;
        r0 = android.support.v4.view.z.h(r0, r2);
        if (r0 == 0) goto L_0x0094;
    L_0x006d:
        r0 = r4.RQ;
        r3 = r4.getPaddingTop();
        r0 = r0 - r3;
        r3 = r4.getPaddingBottom();
        r0 = r0 - r3;
    L_0x0079:
        r3 = r4.aak;
        r3 = android.support.v4.view.z.g(r3, r2);
        if (r3 == 0) goto L_0x0091;
    L_0x0081:
        r3 = r4.aar;
        r5 = r4.getPaddingLeft();
        r3 = r3 - r5;
        r5 = r4.getPaddingRight();
        r3 = r3 - r5;
        r6 = r3;
        r3 = r0;
        r0 = r6;
        goto L_0x002c;
    L_0x0091:
        r3 = r0;
        r0 = r1;
        goto L_0x002c;
    L_0x0094:
        r0 = r1;
        goto L_0x0079;
    L_0x0096:
        r0 = r1;
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ac.performAccessibilityAction(android.view.View, int, android.os.Bundle):boolean");
    }

    public final void a(View view, b bVar) {
        super.a(view, bVar);
        bVar.setClassName(RecyclerView.class.getName());
        if (!gd() && this.aak.Zf != null) {
            h hVar = this.aak.Zf;
            m mVar = hVar.aak.YX;
            q qVar = hVar.aak.ZL;
            if (z.h(hVar.aak, -1) || z.g(hVar.aak, -1)) {
                bVar.addAction(8192);
                bVar.setScrollable(true);
            }
            if (z.h(hVar.aak, 1) || z.g(hVar.aak, 1)) {
                bVar.addAction(Downloads.RECV_BUFFER_SIZE);
                bVar.setScrollable(true);
            }
            b.zK.f(bVar.zL, new k(b.zK.a(hVar.a(mVar, qVar), hVar.b(mVar, qVar), false, 0)).zL);
        }
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !gd()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.Zf != null) {
                recyclerView.Zf.onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }
}
