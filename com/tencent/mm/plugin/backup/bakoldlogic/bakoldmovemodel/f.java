package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel;

import com.tencent.mm.a.e;
import com.tencent.mm.i.g;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.plugin.backup.a.h;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a.b;
import com.tencent.mm.plugin.backup.f.b.c;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.List;

public final class f implements b, d, c {
    public boolean jDR = false;
    private boolean jDT = true;
    public com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a jJZ;
    b jKf;
    private boolean jKg = false;
    public d jKh;
    public b jKi;
    private a jKj;
    public List<String> jKk;
    public PLong jKl;
    public PInt jKm;
    public long jKn;
    public Object lock = new Object();

    public interface a {
        void acc();
    }

    public final void a(List<String> list, PLong pLong, PInt pInt) {
        this.jKk = list;
        this.jKl = pLong;
        this.jKm = pInt;
    }

    public final void a(a aVar) {
        w.d("MicroMsg.MoveBakServer", "setOnAuthOK onAuthCb is null : " + (aVar == null));
        this.jKj = aVar;
    }

    public final void bx(boolean z) {
        if (!z) {
            com.tencent.mm.plugin.backup.h.a aVar = new com.tencent.mm.plugin.backup.h.a();
            aVar.ID = a.abR().jBm;
            try {
                com.tencent.mm.plugin.backup.f.b.r(aVar.toByteArray(), 5);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MoveBakServer", e, "", new Object[0]);
            }
        }
        acb();
    }

    private void acb() {
        synchronized (this.lock) {
            if (this.jJZ != null) {
                this.jJZ.cancel();
                this.jJZ = null;
            }
            if (this.jKf != null) {
                this.jKf.cancel();
                this.jKf = null;
            }
            e.d(new File(h.aan()));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r9, int r10, byte[] r11, int r12) {
        /*
        r8 = this;
        r6 = 3;
        r5 = 2;
        r7 = 1;
        r1 = 0;
        r2 = "MicroMsg.MoveBakServer";
        r3 = "onNotify isLocal:%b, type:%d, seq:%d, buf.len:%d";
        r0 = 4;
        r4 = new java.lang.Object[r0];
        r0 = java.lang.Boolean.valueOf(r9);
        r4[r1] = r0;
        r0 = java.lang.Integer.valueOf(r10);
        r4[r7] = r0;
        r0 = java.lang.Integer.valueOf(r12);
        r4[r5] = r0;
        if (r11 != 0) goto L_0x0131;
    L_0x0021:
        r0 = r1;
    L_0x0022:
        r0 = java.lang.Integer.valueOf(r0);
        r4[r6] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r2, r3, r4);
        if (r9 == 0) goto L_0x0033;
    L_0x002d:
        r0 = "";
        r8.onError(r10, r0);
    L_0x0033:
        if (r10 != r7) goto L_0x01a2;
    L_0x0035:
        r2 = new com.tencent.mm.plugin.backup.h.v;
        r2.<init>();
        r2.aD(r11);	 Catch:{ IOException -> 0x0139 }
        r0 = "MicroMsg.MoveBakServer";
        r3 = "req info, id:%s, step:%d";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x0139 }
        r5 = 0;
        r6 = r2.ID;	 Catch:{ IOException -> 0x0139 }
        r4[r5] = r6;	 Catch:{ IOException -> 0x0139 }
        r5 = 1;
        r6 = r2.jOa;	 Catch:{ IOException -> 0x0139 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ IOException -> 0x0139 }
        r4[r5] = r6;	 Catch:{ IOException -> 0x0139 }
        com.tencent.mm.sdk.platformtools.w.i(r0, r3, r4);	 Catch:{ IOException -> 0x0139 }
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR();	 Catch:{ IOException -> 0x0139 }
        r0 = r0.jBm;	 Catch:{ IOException -> 0x0139 }
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);	 Catch:{ IOException -> 0x0139 }
        if (r0 == 0) goto L_0x006b;
    L_0x0063:
        r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR();	 Catch:{ IOException -> 0x0139 }
        r3 = r2.ID;	 Catch:{ IOException -> 0x0139 }
        r0.jBm = r3;	 Catch:{ IOException -> 0x0139 }
    L_0x006b:
        r0 = r2.ID;	 Catch:{ IOException -> 0x0139 }
        r3 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR();	 Catch:{ IOException -> 0x0139 }
        r3 = r3.jBm;	 Catch:{ IOException -> 0x0139 }
        r0 = r0.equals(r3);	 Catch:{ IOException -> 0x0139 }
        if (r0 == 0) goto L_0x0187;
    L_0x0079:
        r0 = r2.jOa;	 Catch:{ IOException -> 0x0139 }
        if (r0 != 0) goto L_0x00fa;
    L_0x007d:
        r0 = r2.jMQ;	 Catch:{ IOException -> 0x0139 }
        r0 = r0.sYA;	 Catch:{ IOException -> 0x0139 }
        r3 = r2.jOd;	 Catch:{ IOException -> 0x0139 }
        r4 = com.tencent.mm.plugin.backup.bakoldlogic.a.b.jIX;	 Catch:{ IOException -> 0x0139 }
        r3 = r3 & r4;
        if (r3 != 0) goto L_0x0134;
    L_0x0088:
        r3 = 0;
        r8.jDT = r3;	 Catch:{ IOException -> 0x0139 }
    L_0x008b:
        r3 = new com.tencent.mm.plugin.backup.h.w;	 Catch:{ IOException -> 0x0139 }
        r3.<init>();	 Catch:{ IOException -> 0x0139 }
        r4 = 0;
        r3.jOa = r4;	 Catch:{ IOException -> 0x0139 }
        r4 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR();	 Catch:{ IOException -> 0x0139 }
        r4 = r4.jBm;	 Catch:{ IOException -> 0x0139 }
        r3.ID = r4;	 Catch:{ IOException -> 0x0139 }
        r4 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR();	 Catch:{ IOException -> 0x0139 }
        r4 = r4.jBn;	 Catch:{ IOException -> 0x0139 }
        r5 = new java.lang.String;	 Catch:{ IOException -> 0x0139 }
        r6 = com.tencent.mm.plugin.backup.a.e.aai();	 Catch:{ IOException -> 0x0139 }
        r0 = com.tencent.mm.a.k.a(r0, r6);	 Catch:{ IOException -> 0x0139 }
        r5.<init>(r0);	 Catch:{ IOException -> 0x0139 }
        r0 = r4.equals(r5);	 Catch:{ IOException -> 0x0139 }
        if (r0 == 0) goto L_0x0155;
    L_0x00b4:
        r0 = "MicroMsg.MoveBakServer";
        r4 = "get auth req stpe 0 and validate hello  success, and send ok";
        com.tencent.mm.sdk.platformtools.w.i(r0, r4);	 Catch:{ IOException -> 0x0139 }
        r0 = 0;
        r3.jNB = r0;	 Catch:{ IOException -> 0x0139 }
        r0 = new com.tencent.mm.bd.b;	 Catch:{ IOException -> 0x0139 }
        r4 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR();	 Catch:{ IOException -> 0x0139 }
        r4 = r4.jBo;	 Catch:{ IOException -> 0x0139 }
        r4 = r4.getBytes();	 Catch:{ IOException -> 0x0139 }
        r5 = com.tencent.mm.plugin.backup.a.e.aai();	 Catch:{ IOException -> 0x0139 }
        r4 = com.tencent.mm.a.k.b(r4, r5);	 Catch:{ IOException -> 0x0139 }
        r0.<init>(r4);	 Catch:{ IOException -> 0x0139 }
        r3.jMQ = r0;	 Catch:{ IOException -> 0x0139 }
        r0 = com.tencent.mm.i.g.sV();	 Catch:{ IOException -> 0x0139 }
        r4 = "ChattingRecordsKvstatDisable";
        r0 = r0.getValue(r4);	 Catch:{ IOException -> 0x0139 }
        r4 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bg.getInt(r0, r4);	 Catch:{ IOException -> 0x0139 }
        if (r0 != 0) goto L_0x00f2;
    L_0x00eb:
        r0 = r3.jOd;	 Catch:{ IOException -> 0x0139 }
        r4 = com.tencent.mm.plugin.backup.bakoldlogic.a.b.jIX;	 Catch:{ IOException -> 0x0139 }
        r0 = r0 | r4;
        r3.jOd = r0;	 Catch:{ IOException -> 0x0139 }
    L_0x00f2:
        r0 = r3.toByteArray();	 Catch:{ IOException -> 0x0162 }
        r3 = 2;
        com.tencent.mm.plugin.backup.f.b.d(r0, r3, r12);	 Catch:{ IOException -> 0x0162 }
    L_0x00fa:
        r0 = r2.jOa;	 Catch:{ IOException -> 0x0139 }
        if (r0 != r7) goto L_0x0130;
    L_0x00fe:
        r0 = r2.jMQ;	 Catch:{ IOException -> 0x0139 }
        r0 = r0.sYA;	 Catch:{ IOException -> 0x0139 }
        r2 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR();	 Catch:{ IOException -> 0x0139 }
        r2 = r2.jBo;	 Catch:{ IOException -> 0x0139 }
        r3 = new java.lang.String;	 Catch:{ IOException -> 0x0139 }
        r4 = com.tencent.mm.plugin.backup.a.e.aai();	 Catch:{ IOException -> 0x0139 }
        r0 = com.tencent.mm.a.k.a(r0, r4);	 Catch:{ IOException -> 0x0139 }
        r3.<init>(r0);	 Catch:{ IOException -> 0x0139 }
        r0 = r2.equals(r3);	 Catch:{ IOException -> 0x0139 }
        if (r0 == 0) goto L_0x017a;
    L_0x011b:
        r0 = "MicroMsg.MoveBakServer";
        r2 = "get auth req step 1 and validate ok success";
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);	 Catch:{ IOException -> 0x0139 }
        r0 = 1;
        r8.jKg = r0;	 Catch:{ IOException -> 0x0139 }
        r0 = r8.jKj;	 Catch:{ IOException -> 0x0139 }
        if (r0 == 0) goto L_0x0170;
    L_0x012b:
        r0 = r8.jKj;	 Catch:{ IOException -> 0x0139 }
        r0.acc();	 Catch:{ IOException -> 0x0139 }
    L_0x0130:
        return;
    L_0x0131:
        r0 = r11.length;
        goto L_0x0022;
    L_0x0134:
        r3 = 1;
        r8.jDT = r3;	 Catch:{ IOException -> 0x0139 }
        goto L_0x008b;
    L_0x0139:
        r0 = move-exception;
        r8.jKg = r1;
        r2 = "MicroMsg.MoveBakServer";
        r3 = "";
        r4 = new java.lang.Object[r1];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r2, r0, r3, r4);
        r2 = "MicroMsg.MoveBakServer";
        r3 = "parse bakauth req failed, %s";
        r4 = new java.lang.Object[r7];
        r4[r1] = r0;
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);
        goto L_0x0130;
    L_0x0155:
        r0 = 1;
        r3.jNB = r0;	 Catch:{ IOException -> 0x0139 }
        r0 = "MicroMsg.MoveBakServer";
        r4 = "get auth req stpe 0 and valite failed, hello failed";
        com.tencent.mm.sdk.platformtools.w.e(r0, r4);	 Catch:{ IOException -> 0x0139 }
        goto L_0x00f2;
    L_0x0162:
        r0 = move-exception;
        r3 = "MicroMsg.MoveBakServer";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ IOException -> 0x0139 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r0, r4, r5);	 Catch:{ IOException -> 0x0139 }
        goto L_0x00fa;
    L_0x0170:
        r0 = "MicroMsg.MoveBakServer";
        r2 = "onAuthCb is null.";
        com.tencent.mm.sdk.platformtools.w.w(r0, r2);	 Catch:{ IOException -> 0x0139 }
        goto L_0x0130;
    L_0x017a:
        r0 = "MicroMsg.MoveBakServer";
        r2 = "get auth req stpe 1 and validate ok failed";
        com.tencent.mm.sdk.platformtools.w.e(r0, r2);	 Catch:{ IOException -> 0x0139 }
        r0 = 0;
        r8.jKg = r0;	 Catch:{ IOException -> 0x0139 }
        goto L_0x0130;
    L_0x0187:
        r0 = "MicroMsg.MoveBakServer";
        r3 = "id not equel:self:%s, req.id:%s";
        r4 = 2;
        r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x0139 }
        r5 = 0;
        r6 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR();	 Catch:{ IOException -> 0x0139 }
        r6 = r6.jBm;	 Catch:{ IOException -> 0x0139 }
        r4[r5] = r6;	 Catch:{ IOException -> 0x0139 }
        r5 = 1;
        r2 = r2.ID;	 Catch:{ IOException -> 0x0139 }
        r4[r5] = r2;	 Catch:{ IOException -> 0x0139 }
        com.tencent.mm.sdk.platformtools.w.e(r0, r3, r4);	 Catch:{ IOException -> 0x0139 }
        goto L_0x0130;
    L_0x01a2:
        r0 = r8.jKg;
        if (r0 != 0) goto L_0x01bf;
    L_0x01a6:
        r0 = "MicroMsg.MoveBakServer";
        r2 = "not resp nonAuth is inval status!!! type:%d, seq:%d";
        r3 = new java.lang.Object[r5];
        r4 = java.lang.Integer.valueOf(r10);
        r3[r1] = r4;
        r1 = java.lang.Integer.valueOf(r12);
        r3[r7] = r1;
        com.tencent.mm.sdk.platformtools.w.w(r0, r2, r3);
        goto L_0x0130;
    L_0x01bf:
        if (r10 != r6) goto L_0x01c4;
    L_0x01c1:
        r8.jq(r12);
    L_0x01c4:
        r0 = 5;
        if (r10 != r0) goto L_0x0130;
    L_0x01c7:
        r8.acb();
        goto L_0x0130;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.f.a(boolean, int, byte[], int):void");
    }

    public final void jq(final int i) {
        n(0, 0);
        com.tencent.mm.plugin.backup.g.a.abC().abF();
        List list = this.jKk;
        PLong pLong = this.jKl;
        PInt pInt = this.jKm;
        this.jKk = list;
        this.jKl = pLong;
        this.jKm = pInt;
        com.tencent.mm.sdk.f.e.post(new Runnable(this) {
            final /* synthetic */ f jKo;

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r10 = this;
                r8 = 0;
                r3 = 0;
                r7 = 1;
                r6 = 0;
                r0 = r10.jKo;
                r0 = r0.jKk;
                if (r0 == 0) goto L_0x0017;
            L_0x000b:
                r0 = r10.jKo;
                r0 = r0.jKl;
                if (r0 == 0) goto L_0x0017;
            L_0x0011:
                r0 = r10.jKo;
                r0 = r0.jKm;
                if (r0 != 0) goto L_0x0082;
            L_0x0017:
                r0 = r10.jKo;
                r1 = new com.tencent.mm.pointers.PLong;
                r1.<init>();
                r0.jKl = r1;
                r0 = r10.jKo;
                r1 = new com.tencent.mm.pointers.PInt;
                r1.<init>();
                r0.jKm = r1;
                r0 = r10.jKo;
                r0 = r0.jJZ;
                if (r0 == 0) goto L_0x0036;
            L_0x002f:
                r0 = r10.jKo;
                r0 = r0.jJZ;
                r0.cancel();
            L_0x0036:
                r0 = r10.jKo;
                r1 = new com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a;
                r2 = r10.jKo;
                r1.<init>(r2, r3);
                r0.jJZ = r1;
                r0 = r10.jKo;
                r1 = r10.jKo;
                r1 = r1.jJZ;
                r2 = r10.jKo;
                r2 = r2.jKl;
                r3 = r10.jKo;
                r3 = r3.jKm;
                r1 = r1.a(r2, r3);
                r0.jKk = r1;
                r0 = r10.jKo;
                r0 = r0.jKk;
                if (r0 == 0) goto L_0x0067;
            L_0x005b:
                r0 = r10.jKo;
                r0 = r0.jKl;
                if (r0 == 0) goto L_0x0067;
            L_0x0061:
                r0 = r10.jKo;
                r0 = r0.jKm;
                if (r0 != 0) goto L_0x0071;
            L_0x0067:
                r0 = "MicroMsg.MoveBakServer";
                r1 = "isCancel, quit.";
                com.tencent.mm.sdk.platformtools.w.e(r0, r1);
            L_0x0070:
                return;
            L_0x0071:
                r0 = r10.jKo;
                r1 = r10.jKo;
                r1 = r1.jKk;
                r2 = r10.jKo;
                r2 = r2.jKl;
                r3 = r10.jKo;
                r3 = r3.jKm;
                r0.a(r1, r2, r3);
            L_0x0082:
                r0 = "MicroMsg.MoveBakServer";
                r1 = "transfer conversation size:%d, addupSize:%d, pCount:%d";
                r2 = 3;
                r2 = new java.lang.Object[r2];
                r3 = r10.jKo;
                r3 = r3.jKk;
                r3 = r3.size();
                r3 = java.lang.Integer.valueOf(r3);
                r2[r6] = r3;
                r3 = r10.jKo;
                r3 = r3.jKl;
                r4 = r3.value;
                r3 = java.lang.Long.valueOf(r4);
                r2[r7] = r3;
                r3 = 2;
                r4 = r10.jKo;
                r4 = r4.jKm;
                r4 = r4.value;
                r4 = java.lang.Integer.valueOf(r4);
                r2[r3] = r4;
                com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
                r0 = r10.jKo;
                r1 = r0.lock;
                monitor-enter(r1);
                r0 = r10.jKo;	 Catch:{ all -> 0x00c7 }
                r0 = r0.jKk;	 Catch:{ all -> 0x00c7 }
                if (r0 != 0) goto L_0x00ca;
            L_0x00c0:
                r0 = r10.jKo;	 Catch:{ all -> 0x00c7 }
                r2 = 0;
                r0.jKf = r2;	 Catch:{ all -> 0x00c7 }
                monitor-exit(r1);	 Catch:{ all -> 0x00c7 }
                goto L_0x0070;
            L_0x00c7:
                r0 = move-exception;
                monitor-exit(r1);	 Catch:{ all -> 0x00c7 }
                throw r0;
            L_0x00ca:
                r0 = r10.jKo;	 Catch:{ all -> 0x00c7 }
                r0 = r0.jKf;	 Catch:{ all -> 0x00c7 }
                if (r0 == 0) goto L_0x00d7;
            L_0x00d0:
                r0 = r10.jKo;	 Catch:{ all -> 0x00c7 }
                r0 = r0.jKf;	 Catch:{ all -> 0x00c7 }
                r0.cancel();	 Catch:{ all -> 0x00c7 }
            L_0x00d7:
                r0 = r10.jKo;	 Catch:{ all -> 0x00c7 }
                r2 = new com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.b;	 Catch:{ all -> 0x00c7 }
                r2.<init>();	 Catch:{ all -> 0x00c7 }
                r0.jKf = r2;	 Catch:{ all -> 0x00c7 }
                monitor-exit(r1);	 Catch:{ all -> 0x00c7 }
                r1 = new com.tencent.mm.plugin.backup.h.o;
                r1.<init>();
                r0 = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a.abR();
                r0 = r0.jBm;
                r1.ID = r0;
                r0 = r10.jKo;
                r0 = r0.jKk;
                r0 = r0.size();
                r2 = (long) r0;
                r1.jNz = r2;
                r0 = r10.jKo;
                r0 = r0.jKl;
                r2 = r0.value;
                r1.jNA = r2;
                r1.jNB = r6;
                r0 = r10.jKo;
                r0 = r0.jDR;
                if (r0 == 0) goto L_0x0167;
            L_0x0109:
                r0 = com.tencent.mm.plugin.backup.bakoldlogic.a.b.jAX;
            L_0x010b:
                r1.jNC = r0;
                r0 = r1.toByteArray();	 Catch:{ IOException -> 0x016a }
                r1 = 4;
                r2 = r5;	 Catch:{ IOException -> 0x016a }
                com.tencent.mm.plugin.backup.f.b.d(r0, r1, r2);	 Catch:{ IOException -> 0x016a }
                r0 = r10.jKo;
                r2 = r0.jKf;
                r0 = r10.jKo;
                r3 = r0.jKk;
                r0 = r10.jKo;
                r0 = r0.jKl;
                r0 = r0.value;
                r2.jJK = r3;
                r2.fKF = r6;
                r2.htv = r6;
                r2.jJO = r6;
                r3 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
                if (r3 != 0) goto L_0x0134;
            L_0x0131:
                r4 = 1;
                r0 = r0 + r4;
            L_0x0134:
                r2.jJP = r0;
                r2.jJQ = r8;
                r2.jJR = r6;
                r0 = r2.jJL;
                r0.clear();
                com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.h.setProgress(r6);
                r0 = r10.jKo;
                r0 = r0.jKf;
                r1 = r10.jKo;
                r0.jJM = r1;
                r0 = r10.jKo;
                r2 = java.lang.System.currentTimeMillis();
                r0.jKn = r2;
                r0 = r10.jKo;
                r0 = r0.jKf;
                r1 = new com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.b$1;
                r1.<init>(r0);
                r0 = "BakPCServer_startBak";
                r0 = com.tencent.mm.sdk.f.e.d(r1, r0, r7);
                r0.start();
                goto L_0x0070;
            L_0x0167:
                r0 = com.tencent.mm.plugin.backup.bakoldlogic.a.b.jAW;
                goto L_0x010b;
            L_0x016a:
                r0 = move-exception;
                r1 = "MicroMsg.MoveBakServer";
                r2 = "prase resp error!!";
                com.tencent.mm.sdk.platformtools.w.e(r1, r2);
                r1 = "MicroMsg.MoveBakServer";
                r2 = "";
                r3 = new java.lang.Object[r6];
                com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r3);
                goto L_0x0070;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.f.1.run():void");
            }
        }, "MoveBakServer.calcelate");
    }

    public final void onError(int i, String str) {
        if (this.jKh != null) {
            this.jKh.onError(i, str);
        }
    }

    public final void b(long j, long j2, int i) {
        if (this.jKh != null) {
            this.jKh.b(j, j2, i);
        }
    }

    public final void bE(int i, int i2) {
    }

    public final void abW() {
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.jKn);
        d dVar = new d();
        dVar.ID = a.abR().jBm;
        if (this.jDT && bg.getInt(g.sV().getValue("ChattingRecordsKvstatDisable"), 0) == 0) {
            dVar.jMS = this.jKk.size();
            dVar.jMT = this.jKm.value;
            dVar.jMU = this.jKf.jJU;
            dVar.jMV = (int) (this.jKl.value / AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            dVar.jMW = (int) (this.jKf.jJV / AppSupportContentFlag.MMAPP_SUPPORT_XLS);
            dVar.jMX = this.jKf.jJS;
            dVar.jMY = this.jKf.jJT;
            dVar.jMZ = currentTimeMillis;
            dVar.jNa = com.tencent.mm.protocal.d.sYN;
            w.i("MicroMsg.MoveBakServer", "NewBakMoveInfoKvstat, Server, ServerSessionCount:%d, ServerMessageCount:%d, ServerFileCount:%d, CalculateSize:%d, ServerDataPushSize:%d, ServerReadDBTotalTime:%d, ServerReadFileTotalTime:%d, ServerCostTotalTime:%d, ServerVersion:%x", new Object[]{Integer.valueOf(dVar.jMS), Integer.valueOf(dVar.jMT), Integer.valueOf(dVar.jMU), Integer.valueOf(dVar.jMV), Integer.valueOf(dVar.jMW), Integer.valueOf(dVar.jMX), Integer.valueOf(dVar.jMY), Integer.valueOf(dVar.jMZ), Integer.valueOf(dVar.jNa)});
        }
        try {
            com.tencent.mm.plugin.backup.f.b.r(dVar.toByteArray(), 8);
        } catch (Throwable e) {
            w.e("MicroMsg.MoveBakServer", "onNetFinish parse req failed");
            w.printErrStackTrace("MicroMsg.MoveBakServer", e, "", new Object[0]);
        }
        if (this.jKh != null) {
            this.jKh.abW();
        }
    }

    public final void aac() {
        if (this.jKh != null) {
            this.jKh.aac();
        }
    }

    public final void n(int i, long j) {
        w.i("MicroMsg.MoveBakServer", "onCalcuProgress progress:%d, calcuSize%d", new Object[]{Integer.valueOf(i), Long.valueOf(j)});
        if (this.jKi != null) {
            this.jKi.n(i, j);
        }
    }

    public final void abO() {
        if (this.jKi != null) {
            this.jKi.abO();
        }
    }
}
