package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.e.b.bp;
import com.tencent.mm.plugin.exdevice.b.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.model.r;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.k;

public final class e extends ae implements com.tencent.mm.y.e {
    private int jUO;
    private m laU;
    private d lhw;
    private b lhx = null;
    private a lhy;

    public e(int i, long j, int i2, int i3, byte[] bArr) {
        this.lhx = new b(j, i2, i3, bArr);
        this.jUO = i;
    }

    public final void a(int i, int i2, String str, k kVar) {
        ap.vd().b(541, this);
        w.i("MicroMsg.exdevice.MMAuthTaskExcuter", "onscen end, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        r rVar = (r) kVar;
        bp vi = ad.apt().vi(this.lhx.jUL);
        if (vi == null) {
            w.e("MicroMsg.exdevice.MMAuthTaskExcuter", "SubCoreExDevice.getHardDeviceInfoStorage().getByDeviceId Failed!!!");
            return;
        }
        if (System.currentTimeMillis() / 1000 < ((long) vi.gtO)) {
            w.e("MicroMsg.exdevice.MMAuthTaskExcuter", "device has been blocked");
            this.lhx.a(-5, "", new byte[0]);
            this.lhy = new a(this.lhx, this.lhw);
            boolean b = this.lhy.b(this.laU);
            w.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[]{Boolean.valueOf(b)});
            return;
        }
        this.lhx.a(i2, str, rVar.apn());
        this.lhy = new a(this.lhx, this.lhw);
        b = this.lhy.b(this.laU);
        w.i("MicroMsg.exdevice.MMAuthTaskExcuter", "auth start task : %b", new Object[]{Boolean.valueOf(b)});
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.plugin.exdevice.service.m r11, com.tencent.mm.plugin.exdevice.i.d r12) {
        /*
        r10 = this;
        r0 = -5;
        r1 = r10.jUO;
        if (r0 == r1) goto L_0x000f;
    L_0x0005:
        r0 = -3;
        r1 = r10.jUO;
        if (r0 == r1) goto L_0x000f;
    L_0x000a:
        r0 = -4;
        r1 = r10.jUO;
        if (r0 != r1) goto L_0x0053;
    L_0x000f:
        r0 = "MicroMsg.exdevice.MMAuthTaskExcuter";
        r1 = "Error Code = %d, reply errorcode to device and close channel";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r10.jUO;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.w.e(r0, r1, r2);
        r0 = r10.lhx;
        r1 = -1;
        r2 = "";
        r3 = 0;
        r3 = new byte[r3];
        r0.a(r1, r2, r3);
        r0 = new com.tencent.mm.plugin.exdevice.i.a;
        r1 = r10.lhx;
        r0.<init>(r1, r12);
        r10.lhy = r0;
        r0 = r10.lhy;
        r0 = r0.b(r11);
        r1 = "MicroMsg.exdevice.MMAuthTaskExcuter";
        r2 = "auth start task : %b";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = java.lang.Boolean.valueOf(r0);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
    L_0x0052:
        return r0;
    L_0x0053:
        r0 = com.tencent.mm.plugin.exdevice.model.ad.apt();
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = r10.lhx;
        r2 = r2.jUL;
        r1 = r1.append(r2);
        r1 = r1.toString();
        r3 = r0.vi(r1);
        if (r3 != 0) goto L_0x0087;
    L_0x006e:
        r0 = "MicroMsg.exdevice.MMAuthTaskExcuter";
        r1 = "get device info failed : %d";
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r10.lhx;
        r4 = r4.jUL;
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.w.e(r0, r1, r2);
        r0 = 0;
        goto L_0x0052;
    L_0x0087:
        r0 = r10.lhx;
        r0 = r0.aoS();
        r4 = r0;
        r4 = (com.tencent.mm.plugin.exdevice.e.a) r4;
        if (r4 != 0) goto L_0x00ca;
    L_0x0092:
        r0 = "MicroMsg.exdevice.MMAuthTaskExcuter";
        r1 = "Auth Request parse failed!!!, Tell device before stop this task";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        r0 = r10.lhx;
        r1 = -4;
        r2 = "";
        r3 = 0;
        r3 = new byte[r3];
        r0.a(r1, r2, r3);
        r0 = new com.tencent.mm.plugin.exdevice.i.a;
        r1 = r10.lhx;
        r0.<init>(r1, r12);
        r10.lhy = r0;
        r0 = r10.lhy;
        r0 = r0.b(r11);
        r1 = "MicroMsg.exdevice.MMAuthTaskExcuter";
        r2 = "auth start task : %b";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = java.lang.Boolean.valueOf(r0);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
        goto L_0x0052;
    L_0x00ca:
        r0 = r4.leK;
        r1 = 2;
        if (r0 != r1) goto L_0x0132;
    L_0x00cf:
        r0 = r4.leM;
        if (r0 == 0) goto L_0x00e7;
    L_0x00d3:
        r0 = r4.leM;
        r0 = r0.sYA;
        r1 = com.tencent.mm.sdk.platformtools.bg.bm(r0);
        if (r1 == 0) goto L_0x0120;
    L_0x00dd:
        r0 = -1;
    L_0x00df:
        r2 = r10.lhx;
        r6 = r2.jUL;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 == 0) goto L_0x01da;
    L_0x00e7:
        r0 = "MicroMsg.exdevice.MMAuthTaskExcuter";
        r1 = "Auth Request parse fail!!!, Invalid MacAddress";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        r0 = r10.lhx;
        r1 = -1;
        r2 = "";
        r3 = 0;
        r3 = new byte[r3];
        r0.a(r1, r2, r3);
        r0 = new com.tencent.mm.plugin.exdevice.i.a;
        r1 = r10.lhx;
        r0.<init>(r1, r12);
        r10.lhy = r0;
        r0 = r10.lhy;
        r0 = r0.b(r11);
        r1 = "MicroMsg.exdevice.MMAuthTaskExcuter";
        r2 = "auth start task : %b";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = java.lang.Boolean.valueOf(r0);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
        goto L_0x0052;
    L_0x0120:
        r1 = 8;
        r1 = new byte[r1];
        r1 = {0, 0, 0, 0, 0, 0, 0, 0};
        r2 = 0;
        r5 = 2;
        r6 = 6;
        java.lang.System.arraycopy(r0, r2, r1, r5, r6);
        r0 = com.tencent.mm.plugin.exdevice.j.b.ak(r1);
        goto L_0x00df;
    L_0x0132:
        r0 = r4.leK;
        r1 = 1;
        if (r0 == r1) goto L_0x013c;
    L_0x0137:
        r0 = r4.leK;
        r1 = 1;
        if (r0 != r1) goto L_0x01a1;
    L_0x013c:
        r0 = r4.leH;
        if (r0 == 0) goto L_0x0168;
    L_0x0140:
        r0 = r4.leH;
        r0 = r0.sYA;
        r1 = 0;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r5 = r3.field_deviceType;
        r2 = r2.append(r5);
        r5 = r3.field_deviceID;
        r2 = r2.append(r5);
        r2 = r2.toString();
        r2 = r2.getBytes();
        r2 = com.tencent.mm.a.g.o(r2);
        r0 = com.tencent.mm.plugin.exdevice.j.b.a(r0, r1, r2);
        if (r0 != 0) goto L_0x01da;
    L_0x0168:
        r0 = "MicroMsg.exdevice.MMAuthTaskExcuter";
        r1 = "Auth Request parse fail!!!, Invalid Md5DeviceTypeAndDeviceId";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        r0 = r10.lhx;
        r1 = -1;
        r2 = "";
        r3 = 0;
        r3 = new byte[r3];
        r0.a(r1, r2, r3);
        r0 = new com.tencent.mm.plugin.exdevice.i.a;
        r1 = r10.lhx;
        r0.<init>(r1, r12);
        r10.lhy = r0;
        r0 = r10.lhy;
        r0 = r0.b(r11);
        r1 = "MicroMsg.exdevice.MMAuthTaskExcuter";
        r2 = "auth start task : %b";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = java.lang.Boolean.valueOf(r0);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
        goto L_0x0052;
    L_0x01a1:
        r0 = "MicroMsg.exdevice.MMAuthTaskExcuter";
        r1 = "Auth Request parse fail!!!, Invalid AuthMethod";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        r0 = r10.lhx;
        r1 = -8;
        r2 = "";
        r3 = 0;
        r3 = new byte[r3];
        r0.a(r1, r2, r3);
        r0 = new com.tencent.mm.plugin.exdevice.i.a;
        r1 = r10.lhx;
        r0.<init>(r1, r12);
        r10.lhy = r0;
        r0 = r10.lhy;
        r0 = r0.b(r11);
        r1 = "MicroMsg.exdevice.MMAuthTaskExcuter";
        r2 = "auth start task : %b";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = java.lang.Boolean.valueOf(r0);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
        goto L_0x0052;
    L_0x01da:
        if (r3 == 0) goto L_0x02eb;
    L_0x01dc:
        r0 = r3.gtO;
        r0 = (long) r0;
        r6 = java.lang.System.currentTimeMillis();
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 / r8;
        r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1));
        if (r0 >= 0) goto L_0x0223;
    L_0x01ea:
        r0 = "MicroMsg.exdevice.MMAuthTaskExcuter";
        r1 = "device has been blocked";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        r0 = r10.lhx;
        r1 = -5;
        r2 = "";
        r3 = 0;
        r3 = new byte[r3];
        r0.a(r1, r2, r3);
        r0 = new com.tencent.mm.plugin.exdevice.i.a;
        r1 = r10.lhx;
        r0.<init>(r1, r12);
        r10.lhy = r0;
        r0 = r10.lhy;
        r0 = r0.b(r11);
        r1 = "MicroMsg.exdevice.MMAuthTaskExcuter";
        r2 = "auth start task : %b";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = java.lang.Boolean.valueOf(r0);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
        goto L_0x0052;
    L_0x0223:
        r0 = r3.gtP;
        r2 = r3.gtN;
        r6 = (long) r2;
        r6 = r6 + r0;
        r8 = 0;
        r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r5 <= 0) goto L_0x02eb;
    L_0x022f:
        r6 = (long) r2;
        r0 = r0 + r6;
        r6 = java.lang.System.currentTimeMillis();
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 / r8;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 >= 0) goto L_0x02eb;
    L_0x023c:
        r0 = com.tencent.mm.plugin.exdevice.service.u.apU();
        r1 = r10.lhx;
        r6 = r1.jUL;
        r1 = 1;
        r1 = r0.l(r6, r1);
        r0 = com.tencent.mm.plugin.exdevice.service.u.apU();
        r2 = r10.lhx;
        r6 = r2.jUL;
        r2 = 2;
        r2 = r0.l(r6, r2);
        r5 = "MicroMsg.exdevice.MMAuthTaskExcuter";
        r6 = "has not reach time out, just set back sessionkey, get auth buf from local, auth buf length = %d, session key buf lenght = %d";
        r0 = 2;
        r7 = new java.lang.Object[r0];
        r8 = 0;
        if (r1 != 0) goto L_0x02de;
    L_0x0262:
        r0 = -1;
    L_0x0263:
        r0 = java.lang.Integer.valueOf(r0);
        r7[r8] = r0;
        r8 = 1;
        if (r2 != 0) goto L_0x02e0;
    L_0x026c:
        r0 = -1;
    L_0x026d:
        r0 = java.lang.Integer.valueOf(r0);
        r7[r8] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r5, r6, r7);
        if (r1 == 0) goto L_0x02e2;
    L_0x0278:
        if (r2 == 0) goto L_0x02e2;
    L_0x027a:
        r0 = com.tencent.mm.plugin.exdevice.service.u.apU();
        r4 = r3.field_mac;
        r0.bx(r4);
        r0 = 2;
        r1 = com.tencent.mm.plugin.exdevice.service.u.apU();
        r4 = r3.field_mac;
        r1 = r1.bu(r4);
        if (r0 != r1) goto L_0x029d;
    L_0x0290:
        com.tencent.mm.plugin.exdevice.model.ad.apE();
        r0 = r3.field_brandName;
        r1 = r3.field_url;
        r4 = 2;
        r5 = r3.field_deviceID;
        com.tencent.mm.plugin.exdevice.model.e.a(r0, r1, r4, r5);
    L_0x029d:
        r0 = r10.lhx;
        r1 = 0;
        r4 = "";
        r5 = com.tencent.mm.plugin.exdevice.service.u.apU();
        r6 = r10.lhx;
        r6 = r6.jUL;
        r8 = 1;
        r5 = r5.l(r6, r8);
        r0.a(r1, r4, r5);
        r0 = new com.tencent.mm.plugin.exdevice.i.a;
        r1 = r10.lhx;
        r4 = r10.lhw;
        r0.<init>(r1, r4);
        r10.lhy = r0;
        r0 = r3.field_mac;
        r11.setChannelSessionKey(r0, r2);
        r0 = r10.lhy;
        r0 = r0.b(r11);
        r1 = "MicroMsg.exdevice.MMAuthTaskExcuter";
        r2 = "auth start task : %b";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = java.lang.Boolean.valueOf(r0);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
        goto L_0x0052;
    L_0x02de:
        r0 = r1.length;
        goto L_0x0263;
    L_0x02e0:
        r0 = r2.length;
        goto L_0x026d;
    L_0x02e2:
        r0 = "MicroMsg.exdevice.MMAuthTaskExcuter";
        r1 = "has not reach time out, but local authbuf is null, do auth from server";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
    L_0x02eb:
        r0 = "MicroMsg.exdevice.MMAuthTaskExcuter";
        r1 = "now do really auth from server";
        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
        r10.laU = r11;
        r10.lhw = r12;
        r5 = 0;
        if (r4 == 0) goto L_0x0305;
    L_0x02fb:
        r0 = r4.leL;
        if (r0 == 0) goto L_0x0305;
    L_0x02ff:
        r0 = r4.leL;
        r5 = r0.toByteArray();
    L_0x0305:
        r0 = com.tencent.mm.u.ap.vd();
        r1 = 541; // 0x21d float:7.58E-43 double:2.673E-321;
        r0.a(r1, r10);
        r0 = new com.tencent.mm.plugin.exdevice.model.r;
        r1 = r3.field_brandName;
        r2 = r3.field_deviceType;
        r3 = r3.field_deviceID;
        r4 = r4.leJ;
        r0.<init>(r1, r2, r3, r4, r5);
        r1 = com.tencent.mm.u.ap.vd();
        r2 = 0;
        r1.a(r0, r2);
        r0 = 1;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.i.e.a(com.tencent.mm.plugin.exdevice.service.m, com.tencent.mm.plugin.exdevice.i.d):boolean");
    }
}
