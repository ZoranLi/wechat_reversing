package com.tencent.mm.plugin.game.model;

import android.content.Context;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.w;

public final class m {
    public int fLG = 2;
    public int mode = 1;
    public boolean mpA = false;
    public c mpz;
    public int progress = 0;
    public int status = 0;

    public m(c cVar) {
        this.mpz = cVar;
    }

    public final void cj(Context context) {
        if (this.mpz != null) {
            int i = this.mpz.gfl;
            int i2 = this.mpz.gfl;
            w.i("MicroMsg.GameDownloadInfo", "AppId: %s, Initial downloadMode: %d", new Object[]{this.mpz.field_appId, Integer.valueOf(i)});
            if (i == 2) {
                i2 = 3;
            }
            if (i2 == 3 && !g.n(context, "wx3909f6add1206543")) {
                i2 = 1;
            }
            if (i2 != 1) {
                FileDownloadTaskInfo tI = e.akM().tI(this.mpz.field_appId);
                if (tI.status == 1 || tI.status == 2 || tI.status == 3) {
                    i2 = 1;
                }
            }
            this.mode = i2;
            w.i("MicroMsg.GameDownloadInfo", "AppId: %s, Final downloadMode: %d", new Object[]{this.mpz.field_appId, Integer.valueOf(i2)});
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void aAK() {
        /*
        r10 = this;
        r9 = 3;
        r8 = 2;
        r7 = 1;
        r6 = 0;
        r0 = r10.mpz;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = r10.mode;
        switch(r0) {
            case 1: goto L_0x0032;
            case 2: goto L_0x00b7;
            case 3: goto L_0x00b7;
            default: goto L_0x000e;
        };
    L_0x000e:
        r10.status = r6;
    L_0x0010:
        r0 = "MicroMsg.GameDownloadInfo";
        r1 = "Updating Download Status, AppId: %s, downloadMode: %d, downloadStatus: %d";
        r2 = new java.lang.Object[r9];
        r3 = r10.mpz;
        r3 = r3.field_appId;
        r2[r6] = r3;
        r3 = r10.mode;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r7] = r3;
        r3 = r10.status;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r8] = r3;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
        goto L_0x0008;
    L_0x0032:
        r0 = com.tencent.mm.plugin.downloader.model.e.akM();
        r1 = r10.mpz;
        r1 = r1.field_appId;
        r0 = r0.tI(r1);
        r1 = r0.fLG;
        r10.fLG = r1;
        r1 = r0.kHg;
        if (r1 == 0) goto L_0x0049;
    L_0x0046:
        r10.status = r6;
        goto L_0x0008;
    L_0x0049:
        r2 = r0.fLh;
        r4 = 0;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 == 0) goto L_0x007e;
    L_0x0051:
        r2 = r0.fLg;
        r2 = (double) r2;
        r4 = r0.fLh;
        r4 = (double) r4;
        r2 = r2 / r4;
        r4 = 4636737291354636288; // 0x4059000000000000 float:0.0 double:100.0;
        r2 = r2 * r4;
        r1 = (int) r2;
        r10.progress = r1;
    L_0x005e:
        r1 = "MicroMsg.GameDownloadInfo";
        r2 = new java.lang.StringBuilder;
        r3 = "status = ";
        r2.<init>(r3);
        r3 = r0.status;
        r2 = r2.append(r3);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.w.d(r1, r2);
        r1 = r0.status;
        switch(r1) {
            case 0: goto L_0x0087;
            case 1: goto L_0x0081;
            case 2: goto L_0x0084;
            case 3: goto L_0x008a;
            case 4: goto L_0x00a1;
            default: goto L_0x007b;
        };
    L_0x007b:
        r10.status = r6;
        goto L_0x0010;
    L_0x007e:
        r10.progress = r6;
        goto L_0x005e;
    L_0x0081:
        r10.status = r7;
        goto L_0x0010;
    L_0x0084:
        r10.status = r8;
        goto L_0x0010;
    L_0x0087:
        r10.status = r6;
        goto L_0x0010;
    L_0x008a:
        r1 = r0.path;
        r1 = com.tencent.mm.a.e.aO(r1);
        if (r1 == 0) goto L_0x0096;
    L_0x0092:
        r10.status = r9;
        goto L_0x0010;
    L_0x0096:
        r1 = com.tencent.mm.plugin.downloader.model.e.akM();
        r2 = r0.id;
        r1.aT(r2);
        goto L_0x000e;
    L_0x00a1:
        r0 = r10.progress;
        if (r0 == 0) goto L_0x00b3;
    L_0x00a5:
        r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
        r0 = com.tencent.mm.sdk.platformtools.am.isConnected(r0);
        if (r0 != 0) goto L_0x00b3;
    L_0x00af:
        r10.status = r8;
        goto L_0x0010;
    L_0x00b3:
        r10.status = r6;
        goto L_0x0010;
    L_0x00b7:
        r0 = r10.mpz;
        if (r0 == 0) goto L_0x0008;
    L_0x00bb:
        com.tencent.mm.plugin.game.model.ay.aBw();
        r0 = r10.mpz;
        r0 = r0.gfn;
        r0 = com.tencent.mm.plugin.game.model.ay.xU(r0);
        r1 = "MicroMsg.GameDownloadInfo";
        r2 = "query download status : %d";
        r3 = new java.lang.Object[r7];
        r4 = java.lang.Integer.valueOf(r0);
        r3[r6] = r4;
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
        switch(r0) {
            case 1: goto L_0x00de;
            case 2: goto L_0x00de;
            case 3: goto L_0x00e2;
            case 4: goto L_0x00e6;
            default: goto L_0x00da;
        };
    L_0x00da:
        r10.status = r6;
        goto L_0x0010;
    L_0x00de:
        r10.status = r7;
        goto L_0x0010;
    L_0x00e2:
        r10.status = r8;
        goto L_0x0010;
    L_0x00e6:
        r10.status = r9;
        goto L_0x0010;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.model.m.aAK():void");
    }

    public final void aAL() {
        this.mode = 1;
        this.mpA = true;
    }
}
