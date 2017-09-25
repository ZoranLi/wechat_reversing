package com.tencent.mm.plugin.appbrand.jsapi;

public final class ba extends a {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "navigateToMiniProgram";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.tencent.mm.plugin.appbrand.m r11, org.json.JSONObject r12, int r13) {
        /*
        r10 = this;
        r5 = 2;
        r2 = 0;
        r1 = 0;
        r3 = 1;
        r0 = "appId";
        r8 = r12.optString(r0, r1);
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r8);
        if (r0 == 0) goto L_0x001c;
    L_0x0011:
        r0 = "fail:invalid data";
        r0 = r10.d(r0, r1);
        r11.x(r13, r0);
    L_0x001b:
        return;
    L_0x001c:
        r0 = r11.ivH;
        r0 = r8.equals(r0);
        if (r0 == 0) goto L_0x002f;
    L_0x0024:
        r0 = "fail:target appId is the same as the caller appId";
        r0 = r10.d(r0, r1);
        r11.x(r13, r0);
        goto L_0x001b;
    L_0x002f:
        r0 = "path";
        r4 = r12.optString(r0, r1);
        r0 = "extraData";
        r0 = r12.optJSONObject(r0);
        if (r0 != 0) goto L_0x0044;
    L_0x003f:
        r0 = new org.json.JSONObject;
        r0.<init>();
    L_0x0044:
        r1 = "envVersion";
        r1 = r12.optString(r1);
        r6 = r11.ivH;
        r6 = com.tencent.mm.plugin.appbrand.b.mY(r6);
        r6 = r6.iFk;
        r7 = r6.izV;
        if (r1 != 0) goto L_0x005a;
    L_0x0057:
        r1 = "";
    L_0x005a:
        r6 = -1;
        r9 = r1.hashCode();
        switch(r9) {
            case 110628630: goto L_0x00e3;
            case 1090594823: goto L_0x00ef;
            case 1559690845: goto L_0x00d8;
            default: goto L_0x0062;
        };
    L_0x0062:
        r1 = r6;
    L_0x0063:
        switch(r1) {
            case 0: goto L_0x00fb;
            case 1: goto L_0x00fe;
            default: goto L_0x0066;
        };
    L_0x0066:
        r1 = r2;
    L_0x0067:
        if (r7 == r3) goto L_0x0101;
    L_0x0069:
        if (r7 == r5) goto L_0x0101;
    L_0x006b:
        r7 = r2;
    L_0x006c:
        r1 = "";
        r2 = com.tencent.mm.plugin.appbrand.jsapi.d.b(r11);
        if (r2 == 0) goto L_0x0079;
    L_0x0075:
        r1 = r2.jde;
        r1 = r1.jdV;
    L_0x0079:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r5 = r11.ivH;
        r2 = r2.append(r5);
        r5 = ":";
        r2 = r2.append(r5);
        r5 = com.tencent.mm.compatible.util.p.encode(r1);
        r5 = com.tencent.mm.sdk.platformtools.bg.mz(r5);
        r2 = r2.append(r5);
        r2 = r2.toString();
        r6 = new com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
        r6.<init>();
        r5 = 1037; // 0x40d float:1.453E-42 double:5.123E-321;
        r6.scene = r5;
        r5 = r11.ivH;
        r5 = com.tencent.mm.plugin.appbrand.b.mZ(r5);
        r5 = r5.fWK;
        r6.fWK = r5;
        r6.fCN = r2;
        r5 = new com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
        r5.<init>();
        r2 = r11.ivH;
        r5.appId = r2;
        r0 = r0.toString();
        r5.iEM = r0;
        r5.iEL = r3;
        r5.url = r1;
        r9 = new com.tencent.mm.plugin.appbrand.ui.AppBrandPreInitTask;
        r0 = new com.tencent.mm.plugin.appbrand.jsapi.ba$1;
        r1 = r10;
        r2 = r11;
        r3 = r13;
        r0.<init>(r1, r2, r3, r4, r5, r6);
        r9.<init>(r8, r7, r6, r0);
        r9.SM();
        com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService.a(r9);
        goto L_0x001b;
    L_0x00d8:
        r9 = "develop";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x0062;
    L_0x00e1:
        r1 = r2;
        goto L_0x0063;
    L_0x00e3:
        r9 = "trial";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x0062;
    L_0x00ec:
        r1 = r3;
        goto L_0x0063;
    L_0x00ef:
        r9 = "release";
        r1 = r1.equals(r9);
        if (r1 == 0) goto L_0x0062;
    L_0x00f8:
        r1 = r5;
        goto L_0x0063;
    L_0x00fb:
        r1 = r3;
        goto L_0x0067;
    L_0x00fe:
        r1 = r5;
        goto L_0x0067;
    L_0x0101:
        r7 = r1;
        goto L_0x006c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.ba.a(com.tencent.mm.plugin.appbrand.m, org.json.JSONObject, int):void");
    }
}
