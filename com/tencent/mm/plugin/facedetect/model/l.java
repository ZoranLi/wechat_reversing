package com.tencent.mm.plugin.facedetect.model;

import com.tencent.mm.e.a.bb;
import com.tencent.mm.sdk.b.c;

public final class l extends c<bb> {
    public l() {
        this.usg = bb.class.getName().hashCode();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b r9) {
        /*
        r8 = this;
        r7 = -1;
        r1 = 0;
        r2 = 1;
        r9 = (com.tencent.mm.e.a.bb) r9;
        r0 = r9.fEA;
        r0 = r0.fEB;
        r3 = 42;
        if (r0 != r3) goto L_0x0065;
    L_0x000d:
        r0 = "MicroMsg.FaceModuleResUpdateListener";
        r3 = "hy: new face file update coming. subtype: %d, file path: %s, file version: %d";
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = r9.fEA;
        r5 = r5.fEC;
        r5 = java.lang.Integer.valueOf(r5);
        r4[r1] = r5;
        r5 = r9.fEA;
        r5 = r5.filePath;
        r4[r2] = r5;
        r5 = 2;
        r6 = r9.fEA;
        r6 = r6.fED;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.w.i(r0, r3, r4);
        r0 = r9.fEA;
        r3 = r0.fEC;
        r0 = r9.fEA;
        r4 = r0.fED;
        switch(r3) {
            case 0: goto L_0x0066;
            case 1: goto L_0x007d;
            default: goto L_0x003f;
        };
    L_0x003f:
        r0 = "MicroMsg.FaceModuleResUpdateListener";
        r3 = "hy: error subtype";
        com.tencent.mm.sdk.platformtools.w.e(r0, r3);
    L_0x0048:
        r0 = r1;
    L_0x0049:
        if (r0 != 0) goto L_0x00a8;
    L_0x004b:
        r0 = "MicroMsg.FaceModuleResUpdateListener";
        r2 = "hy: get lower version";
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);
        r0 = com.tencent.mm.pluginsdk.k.a.b.b.c.sFE;
        r2 = r9.fEA;
        r2 = r2.fEB;
        r3 = r9.fEA;
        r3 = r3.fEC;
        r4 = r9.fEA;
        r4 = r4.fED;
        r0.R(r2, r3, r4);
    L_0x0065:
        return r1;
    L_0x0066:
        r0 = com.tencent.mm.u.ao.hlW;
        r5 = "LAST_LOGIN_FACE_MODEL_DETECT_VERSION";
        r6 = "-1";
        r0 = r0.A(r5, r6);
        r0 = com.tencent.mm.sdk.platformtools.bg.getInt(r0, r7);
    L_0x0076:
        if (r4 <= r0) goto L_0x0048;
    L_0x0078:
        switch(r3) {
            case 0: goto L_0x008e;
            case 1: goto L_0x009b;
            default: goto L_0x007b;
        };
    L_0x007b:
        r0 = r2;
        goto L_0x0049;
    L_0x007d:
        r0 = com.tencent.mm.u.ao.hlW;
        r5 = "LAST_LOGIN_FACE_MODEL_ALIGNMENT_VERSION";
        r6 = "-1";
        r0 = r0.A(r5, r6);
        r0 = com.tencent.mm.sdk.platformtools.bg.getInt(r0, r7);
        goto L_0x0076;
    L_0x008e:
        r0 = com.tencent.mm.u.ao.hlW;
        r3 = "LAST_LOGIN_FACE_MODEL_DETECT_VERSION";
        r4 = java.lang.String.valueOf(r4);
        r0.L(r3, r4);
        goto L_0x007b;
    L_0x009b:
        r0 = com.tencent.mm.u.ao.hlW;
        r3 = "LAST_LOGIN_FACE_MODEL_ALIGNMENT_VERSION";
        r4 = java.lang.String.valueOf(r4);
        r0.L(r3, r4);
        goto L_0x007b;
    L_0x00a8:
        r0 = r9.fEA;
        r0 = r0.fEC;
        if (r0 != 0) goto L_0x00ec;
    L_0x00ae:
        r0 = com.tencent.mm.u.ao.hlW;
        r3 = "LAST_LOGIN_FACE_MODEL_SDCARD_PATH_DETECT";
        r4 = r9.fEA;
        r4 = r4.filePath;
        r0.L(r3, r4);
    L_0x00ba:
        r0 = r9.fEA;
        r0 = r0.fEC;
        r0 = com.tencent.mm.plugin.facedetect.model.o.ml(r0);
        if (r0 != 0) goto L_0x0133;
    L_0x00c4:
        r0 = "MicroMsg.FaceModuleResUpdateListener";
        r3 = "hy: copy failed. reset version code and path";
        com.tencent.mm.sdk.platformtools.w.w(r0, r3);
        r0 = r9.fEA;
        r0 = r0.fEC;
        if (r0 != 0) goto L_0x0109;
    L_0x00d3:
        r0 = com.tencent.mm.u.ao.hlW;
        r2 = "LAST_LOGIN_FACE_MODEL_SDCARD_PATH_DETECT";
        r3 = r9.fEA;
        r3 = r3.filePath;
        r0.L(r2, r3);
        r0 = com.tencent.mm.u.ao.hlW;
        r2 = "LAST_LOGIN_FACE_MODEL_DETECT_VERSION";
        r3 = "-1";
        r0.L(r2, r3);
        goto L_0x0065;
    L_0x00ec:
        r0 = r9.fEA;
        r0 = r0.fEC;
        if (r0 != r2) goto L_0x00ff;
    L_0x00f2:
        r0 = com.tencent.mm.u.ao.hlW;
        r3 = "LAST_LOGIN_FACE_MODEL_SDCARD_PATH_ALIGNMENT";
        r4 = r9.fEA;
        r4 = r4.filePath;
        r0.L(r3, r4);
        goto L_0x00ba;
    L_0x00ff:
        r0 = "MicroMsg.FaceModuleResUpdateListener";
        r3 = "hy: invalid subtype";
        com.tencent.mm.sdk.platformtools.w.e(r0, r3);
        goto L_0x00ba;
    L_0x0109:
        r0 = r9.fEA;
        r0 = r0.fEC;
        if (r0 != r2) goto L_0x0128;
    L_0x010f:
        r0 = com.tencent.mm.u.ao.hlW;
        r2 = "LAST_LOGIN_FACE_MODEL_SDCARD_PATH_ALIGNMENT";
        r3 = r9.fEA;
        r3 = r3.filePath;
        r0.L(r2, r3);
        r0 = com.tencent.mm.u.ao.hlW;
        r2 = "LAST_LOGIN_FACE_MODEL_ALIGNMENT_VERSION";
        r3 = "-1";
        r0.L(r2, r3);
        goto L_0x0065;
    L_0x0128:
        r0 = "MicroMsg.FaceModuleResUpdateListener";
        r2 = "hy: invalid subtype";
        com.tencent.mm.sdk.platformtools.w.e(r0, r2);
        goto L_0x0065;
    L_0x0133:
        r0 = "MicroMsg.FaceModuleResUpdateListener";
        r2 = "hy: load success. mark as not retry";
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);
        r0 = com.tencent.mm.pluginsdk.k.a.b.b.c.sFE;
        r2 = r9.fEA;
        r2 = r2.fEB;
        r3 = r9.fEA;
        r3 = r3.fEC;
        r4 = r9.fEA;
        r4 = r4.fED;
        r0.R(r2, r3, r4);
        goto L_0x0065;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.facedetect.model.l.a(com.tencent.mm.sdk.b.b):boolean");
    }
}
