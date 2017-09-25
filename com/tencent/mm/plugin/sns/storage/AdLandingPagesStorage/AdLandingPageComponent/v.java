package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent;

import java.util.ArrayList;
import java.util.List;

public final class v extends p {
    public List<a> pcf = new ArrayList();
    public String qgi = "";
    public float qgj;
    public String qgk = "";
    public int qgl;
    public int qgm;
    public int qgn;
    public int qgo;
    public String qgp = "";

    public static class a {
        public String label = "";
        public String qgq = "";
        public float value;

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (aVar.label.equals(this.label) && aVar.qgq.equals(this.qgq) && aVar.value == this.value) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (int) (((float) (this.label.hashCode() + this.qgq.hashCode())) + this.value);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        if (r5 != r4) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = r5 instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v;
        if (r2 == 0) goto L_0x0079;
    L_0x0009:
        r5 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v) r5;
        r2 = r5.qgi;
        if (r2 != 0) goto L_0x004d;
    L_0x000f:
        r2 = r4.qgi;
        if (r2 != 0) goto L_0x004b;
    L_0x0013:
        r2 = r5.qgj;
        r3 = r4.qgj;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 != 0) goto L_0x004b;
    L_0x001b:
        r2 = r5.qgk;
        if (r2 != 0) goto L_0x0058;
    L_0x001f:
        r2 = r4.qgk;
        if (r2 != 0) goto L_0x004b;
    L_0x0023:
        r2 = r5.qgl;
        r3 = r4.qgl;
        if (r2 != r3) goto L_0x004b;
    L_0x0029:
        r2 = r5.qgm;
        r3 = r4.qgm;
        if (r2 != r3) goto L_0x004b;
    L_0x002f:
        r2 = r5.qgn;
        r3 = r4.qgn;
        if (r2 != r3) goto L_0x004b;
    L_0x0035:
        r2 = r5.qgo;
        r3 = r4.qgo;
        if (r2 != r3) goto L_0x004b;
    L_0x003b:
        r2 = r5.pcf;
        if (r2 != 0) goto L_0x0063;
    L_0x003f:
        r2 = r4.pcf;
        if (r2 != 0) goto L_0x004b;
    L_0x0043:
        r2 = r5.qgp;
        if (r2 != 0) goto L_0x006e;
    L_0x0047:
        r2 = r4.qgp;
        if (r2 == 0) goto L_0x0004;
    L_0x004b:
        r0 = r1;
        goto L_0x0004;
    L_0x004d:
        r2 = r5.qgi;
        r3 = r4.qgi;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x004b;
    L_0x0057:
        goto L_0x0013;
    L_0x0058:
        r2 = r5.qgk;
        r3 = r4.qgk;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x004b;
    L_0x0062:
        goto L_0x0023;
    L_0x0063:
        r2 = r5.pcf;
        r3 = r4.pcf;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x004b;
    L_0x006d:
        goto L_0x0043;
    L_0x006e:
        r2 = r5.qgp;
        r3 = r4.qgp;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x004b;
    L_0x0078:
        goto L_0x0004;
    L_0x0079:
        r0 = r1;
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return super.hashCode();
    }
}
