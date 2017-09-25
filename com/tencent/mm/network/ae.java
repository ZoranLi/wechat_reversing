package com.tencent.mm.network;

import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.stn.StnLogic.ICallBack;
import com.tencent.mm.a.n;
import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

public final class ae implements ICallBack {
    private static WakerLock ifN = null;
    private static int ifO = 1000000205;
    private static int ifP = cf.CTRL_INDEX;
    private static byte[] ifQ;
    private static byte[] ifR;

    private static String exception2String(Exception exception) {
        Writer stringWriter = new StringWriter();
        exception.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public final boolean makesureAuthed() {
        boolean z = false;
        if (z.MO() != null) {
            try {
                z = z.MO().Mw();
            } catch (Exception e) {
                w.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[z]).append(", ").append(e.getStackTrace()[1]);
            }
        }
        return z;
    }

    public final String[] onNewDns(String str) {
        return new String[0];
    }

    public final void onPush(final int i, final byte[] bArr) {
        if (z.MQ() != null) {
            try {
                if (ifN == null) {
                    ifN = new WakerLock(z.getContext());
                }
                ifN.lock(1000, "StnLogic.onNotify");
                z.MM().post(new Runnable(this) {
                    final /* synthetic */ ae ifU;

                    public final void run() {
                        z.MQ().onPush(i, bArr);
                    }
                });
            } catch (Exception e) {
                w.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
            }
        }
    }

    public final boolean req2Buf(int i, Object obj, ByteArrayOutputStream byteArrayOutputStream, int[] iArr, int i2) {
        boolean z = false;
        if (z.MP() != null) {
            try {
                z = z.MP().a(i, byteArrayOutputStream, iArr, i2);
            } catch (Exception e) {
                w.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[z]).append(", ").append(e.getStackTrace()[1]);
            }
        }
        return z;
    }

    public final int buf2Resp(int i, Object obj, byte[] bArr, int[] iArr, int i2) {
        int i3 = -1;
        if (z.MP() != null) {
            try {
                i3 = z.MP().a(i, bArr, iArr);
            } catch (Exception e) {
                w.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
            }
        }
        return i3;
    }

    public final int onTaskEnd(int i, Object obj, int i2, int i3) {
        Exception exception;
        int i4;
        if (z.MP() == null) {
            return 0;
        }
        try {
            int gW = z.MP().gW(i);
            try {
                final int i5 = i;
                final Object obj2 = obj;
                final int i6 = i2;
                final int i7 = i3;
                z.MM().post(new Runnable(this) {
                    final /* synthetic */ ae ifU;

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        /*
                        r25 = this;
                        r15 = com.tencent.mm.network.z.MP();
                        r0 = r25;
                        r0 = r2;
                        r16 = r0;
                        r0 = r25;
                        r2 = r4;
                        r0 = r25;
                        r5 = r5;
                        r4 = -1;
                        r14 = 0;
                        r0 = r15.ifl;
                        r17 = r0;
                        monitor-enter(r17);
                        r18 = r15.gX(r16);	 Catch:{ all -> 0x02d1 }
                        r3 = -1;
                        r0 = r18;
                        if (r3 != r0) goto L_0x0045;
                    L_0x0022:
                        r3 = "MicroMsg.MMNativeNetTaskAdapter";
                        r4 = "mmcgi onGYNetEnd GET FROM QUEUE failed. native:[%d,%d] taskId:%d ";
                        r6 = 3;
                        r6 = new java.lang.Object[r6];	 Catch:{ all -> 0x02d1 }
                        r7 = 0;
                        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x02d1 }
                        r6[r7] = r2;	 Catch:{ all -> 0x02d1 }
                        r2 = 1;
                        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x02d1 }
                        r6[r2] = r5;	 Catch:{ all -> 0x02d1 }
                        r2 = 2;
                        r5 = java.lang.Integer.valueOf(r16);	 Catch:{ all -> 0x02d1 }
                        r6[r2] = r5;	 Catch:{ all -> 0x02d1 }
                        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r6);	 Catch:{ all -> 0x02d1 }
                        monitor-exit(r17);	 Catch:{ all -> 0x02d1 }
                    L_0x0044:
                        return;
                    L_0x0045:
                        r6 = 0;
                        switch(r2) {
                            case 0: goto L_0x01e0;
                            case 1: goto L_0x01e3;
                            case 2: goto L_0x01e6;
                            case 3: goto L_0x01e9;
                            case 4: goto L_0x01ec;
                            case 5: goto L_0x01ef;
                            case 6: goto L_0x01f2;
                            case 7: goto L_0x01f5;
                            case 8: goto L_0x020a;
                            case 9: goto L_0x020d;
                            default: goto L_0x0049;
                        };	 Catch:{ all -> 0x02d1 }
                    L_0x0049:
                        r3 = "MicroMsg.MMNativeNetTaskAdapter";
                        r7 = "c2JavaErrorType not exits c_errType:%d";
                        r8 = 1;
                        r8 = new java.lang.Object[r8];	 Catch:{ all -> 0x02d1 }
                        r9 = 0;
                        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x02d1 }
                        r8[r9] = r2;	 Catch:{ all -> 0x02d1 }
                        com.tencent.mm.sdk.platformtools.w.f(r3, r7, r8);	 Catch:{ all -> 0x02d1 }
                    L_0x005c:
                        if (r6 != 0) goto L_0x005f;
                    L_0x005e:
                        r5 = 0;
                    L_0x005f:
                        r2 = 3;
                        if (r6 != r2) goto L_0x0063;
                    L_0x0062:
                        r5 = -1;
                    L_0x0063:
                        r2 = com.tencent.mm.network.z.MK();	 Catch:{ all -> 0x02d1 }
                        r2 = r2.ifD;	 Catch:{ all -> 0x02d1 }
                        if (r2 != 0) goto L_0x0079;
                    L_0x006b:
                        r2 = 1;
                        if (r6 != r2) goto L_0x0079;
                    L_0x006e:
                        r2 = "MicroMsg.MMNativeNetTaskAdapter";
                        r3 = "network not available";
                        com.tencent.mm.sdk.platformtools.w.i(r2, r3);	 Catch:{ all -> 0x02d1 }
                        r6 = 2;
                        r5 = -1;
                    L_0x0079:
                        r2 = r15.ifl;	 Catch:{ all -> 0x02d1 }
                        r2 = r2[r18];	 Catch:{ all -> 0x02d1 }
                        r0 = r2.ifp;	 Catch:{ all -> 0x02d1 }
                        r19 = r0;
                        r2 = r15.ifl;	 Catch:{ all -> 0x02d1 }
                        r2 = r2[r18];	 Catch:{ all -> 0x02d1 }
                        r2 = r2.ifq;	 Catch:{ all -> 0x02d1 }
                        r3 = r15.ifl;	 Catch:{ all -> 0x02d1 }
                        r3 = r3[r18];	 Catch:{ all -> 0x02d1 }
                        r0 = r3.startTime;	 Catch:{ all -> 0x02d1 }
                        r20 = r0;
                        r3 = r15.ifl;	 Catch:{ all -> 0x02d1 }
                        r7 = 0;
                        r3[r18] = r7;	 Catch:{ all -> 0x02d1 }
                        if (r6 != 0) goto L_0x0597;
                    L_0x0096:
                        r3 = r19.Cn();	 Catch:{ RemoteException -> 0x058c }
                        r3 = r3.Cq();	 Catch:{ RemoteException -> 0x058c }
                        if (r3 == 0) goto L_0x0597;
                    L_0x00a0:
                        r6 = 4;
                        r3 = r19.Cn();	 Catch:{ RemoteException -> 0x058c }
                        r5 = r3.Cq();	 Catch:{ RemoteException -> 0x058c }
                        r12 = r5;
                        r13 = r6;
                    L_0x00ab:
                        r11 = r19.getType();	 Catch:{ RemoteException -> 0x058f }
                        r22 = com.tencent.mm.network.z.MO();	 Catch:{ RemoteException -> 0x0235 }
                        r3 = r19.Cn();	 Catch:{ RemoteException -> 0x0235 }
                        r23 = r3.BX();	 Catch:{ RemoteException -> 0x0235 }
                        r3 = "MicroMsg.AutoAuth";
                        r4 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x021f }
                        r5 = "summerauth onGYNetEnd threadId: 0";
                        r4.<init>(r5);	 Catch:{ RemoteException -> 0x021f }
                        r5 = " errType: ";
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r4 = r4.append(r13);	 Catch:{ RemoteException -> 0x021f }
                        r5 = " errCode: ";
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r4 = r4.append(r12);	 Catch:{ RemoteException -> 0x021f }
                        r5 = " errMsg: ";
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r5 = 0;
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r5 = " rr: ";
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r0 = r19;
                        r4 = r4.append(r0);	 Catch:{ RemoteException -> 0x021f }
                        r5 = " type: ";
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r5 = r19.getType();	 Catch:{ RemoteException -> 0x021f }
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r5 = " netIdGetCertBeforeAutoAuth: ";
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r0 = r22;
                        r5 = r0.ieu;	 Catch:{ RemoteException -> 0x021f }
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r4 = r4.toString();	 Catch:{ RemoteException -> 0x021f }
                        com.tencent.mm.sdk.platformtools.w.d(r3, r4);	 Catch:{ RemoteException -> 0x021f }
                        if (r12 == 0) goto L_0x0210;
                    L_0x011c:
                        r0 = r22;
                        r3 = r0.iel;	 Catch:{ RemoteException -> 0x021f }
                        r3 = r3 + 1;
                        r0 = r22;
                        r0.iel = r3;	 Catch:{ RemoteException -> 0x021f }
                    L_0x0126:
                        r24 = r19.Cn();	 Catch:{ RemoteException -> 0x021f }
                        r3 = r19.getType();	 Catch:{ RemoteException -> 0x021f }
                        switch(r3) {
                            case 126: goto L_0x0258;
                            case 381: goto L_0x051a;
                            case 701: goto L_0x0258;
                            case 702: goto L_0x0258;
                            default: goto L_0x0131;
                        };
                    L_0x0131:
                        r3 = r19.BM();	 Catch:{ RemoteException -> 0x0235 }
                        r5 = r12;
                        r4 = r13;
                    L_0x0137:
                        monitor-exit(r17);	 Catch:{ all -> 0x02d1 }
                        r6 = "MicroMsg.MMNativeNetTaskAdapter";
                        r7 = "mmcgi onTaskEnd type:%d time:%d hash[%d,%d] [%d,%d]";
                        r8 = 6;
                        r8 = new java.lang.Object[r8];
                        r9 = 0;
                        r10 = java.lang.Integer.valueOf(r11);
                        r8[r9] = r10;
                        r9 = 1;
                        r12 = com.tencent.mm.sdk.platformtools.bg.aA(r20);
                        r10 = java.lang.Long.valueOf(r12);
                        r8[r9] = r10;
                        r9 = 2;
                        r10 = java.lang.Integer.valueOf(r16);
                        r8[r9] = r10;
                        r9 = 3;
                        r3 = java.lang.Integer.valueOf(r3);
                        r8[r9] = r3;
                        r3 = 4;
                        r9 = java.lang.Integer.valueOf(r4);
                        r8[r3] = r9;
                        r3 = 5;
                        r9 = java.lang.Integer.valueOf(r5);
                        r8[r3] = r9;
                        com.tencent.mm.sdk.platformtools.w.i(r6, r7, r8);
                        r3 = 4;
                        if (r3 != r4) goto L_0x018f;
                    L_0x0175:
                        r3 = -1;
                        if (r3 == r5) goto L_0x0183;
                    L_0x0178:
                        r3 = -2;
                        if (r3 == r5) goto L_0x0183;
                    L_0x017b:
                        r3 = -24;
                        if (r3 == r5) goto L_0x0183;
                    L_0x017f:
                        r3 = -34;
                        if (r3 != r5) goto L_0x018f;
                    L_0x0183:
                        r3 = com.tencent.mm.network.z.MM();
                        r6 = new com.tencent.mm.network.y$1;
                        r6.<init>(r15, r11, r5);
                        r3.post(r6);
                    L_0x018f:
                        r3 = r19.Cn();	 Catch:{ Exception -> 0x01b0 }
                        r6 = r3.Cp();	 Catch:{ Exception -> 0x01b0 }
                        if (r6 == 0) goto L_0x057a;
                    L_0x0199:
                        r3 = r6.length();	 Catch:{ Exception -> 0x01b0 }
                        if (r3 <= 0) goto L_0x057a;
                    L_0x019f:
                        r3 = r19.Cn();	 Catch:{ Exception -> 0x01b0 }
                        r8 = r3.BX();	 Catch:{ Exception -> 0x01b0 }
                        r3 = r18;
                        r7 = r19;
                        r2.a(r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x01b0 }
                        goto L_0x0044;
                    L_0x01b0:
                        r2 = move-exception;
                        r3 = "MicroMsg.MMNativeNetTaskAdapter";
                        r4 = "onGYNetEnd cb %s";
                        r5 = 1;
                        r5 = new java.lang.Object[r5];
                        r6 = 0;
                        r7 = r2.getMessage();
                        r5[r6] = r7;
                        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);
                        r3 = "MicroMsg.MMNativeNetTaskAdapter";
                        r4 = "exception:%s taskid:%d";
                        r5 = 2;
                        r5 = new java.lang.Object[r5];
                        r6 = 0;
                        r2 = com.tencent.mm.sdk.platformtools.bg.g(r2);
                        r5[r6] = r2;
                        r2 = 1;
                        r6 = java.lang.Integer.valueOf(r16);
                        r5[r2] = r6;
                        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r5);
                        goto L_0x0044;
                    L_0x01e0:
                        r6 = 0;
                        goto L_0x005c;
                    L_0x01e3:
                        r6 = 2;
                        goto L_0x005c;
                    L_0x01e6:
                        r6 = 2;
                        goto L_0x005c;
                    L_0x01e9:
                        r6 = 1;
                        goto L_0x005c;
                    L_0x01ec:
                        r6 = 1;
                        goto L_0x005c;
                    L_0x01ef:
                        r6 = 1;
                        goto L_0x005c;
                    L_0x01f2:
                        r6 = 1;
                        goto L_0x005c;
                    L_0x01f5:
                        r2 = -3002; // 0xfffffffffffff446 float:NaN double:NaN;
                        if (r2 == r5) goto L_0x01fd;
                    L_0x01f9:
                        r2 = -3003; // 0xfffffffffffff445 float:NaN double:NaN;
                        if (r2 != r5) goto L_0x0200;
                    L_0x01fd:
                        r6 = 4;
                        goto L_0x005c;
                    L_0x0200:
                        r2 = -10001; // 0xffffffffffffd8ef float:NaN double:NaN;
                        if (r2 != r5) goto L_0x0207;
                    L_0x0204:
                        r6 = 6;
                        goto L_0x005c;
                    L_0x0207:
                        r6 = 5;
                        goto L_0x005c;
                    L_0x020a:
                        r6 = 4;
                        goto L_0x005c;
                    L_0x020d:
                        r6 = 1;
                        goto L_0x005c;
                    L_0x0210:
                        r3 = r19.getType();	 Catch:{ RemoteException -> 0x021f }
                        r4 = 10;
                        if (r3 == r4) goto L_0x0126;
                    L_0x0218:
                        r3 = 0;
                        r0 = r22;
                        r0.iel = r3;	 Catch:{ RemoteException -> 0x021f }
                        goto L_0x0126;
                    L_0x021f:
                        r3 = move-exception;
                        r4 = "MicroMsg.AutoAuth";
                        r5 = "exception:%s";
                        r6 = 1;
                        r6 = new java.lang.Object[r6];	 Catch:{ RemoteException -> 0x0235 }
                        r7 = 0;
                        r3 = com.tencent.mm.sdk.platformtools.bg.g(r3);	 Catch:{ RemoteException -> 0x0235 }
                        r6[r7] = r3;	 Catch:{ RemoteException -> 0x0235 }
                        com.tencent.mm.sdk.platformtools.w.e(r4, r5, r6);	 Catch:{ RemoteException -> 0x0235 }
                        goto L_0x0131;
                    L_0x0235:
                        r3 = move-exception;
                        r4 = r11;
                        r5 = r12;
                        r6 = r13;
                    L_0x0239:
                        r7 = "MicroMsg.MMNativeNetTaskAdapter";
                        r8 = "exception:%s taskid:%d";
                        r9 = 2;
                        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x02d1 }
                        r10 = 0;
                        r3 = com.tencent.mm.sdk.platformtools.bg.g(r3);	 Catch:{ all -> 0x02d1 }
                        r9[r10] = r3;	 Catch:{ all -> 0x02d1 }
                        r3 = 1;
                        r10 = java.lang.Integer.valueOf(r16);	 Catch:{ all -> 0x02d1 }
                        r9[r3] = r10;	 Catch:{ all -> 0x02d1 }
                        com.tencent.mm.sdk.platformtools.w.e(r7, r8, r9);	 Catch:{ all -> 0x02d1 }
                        r3 = r14;
                        r11 = r4;
                        r4 = r6;
                        goto L_0x0137;
                    L_0x0258:
                        r3 = "MicroMsg.AutoAuth";
                        r4 = "summerauth end type: %d, ret:[%d,%d][%s]";
                        r5 = 4;
                        r5 = new java.lang.Object[r5];	 Catch:{ RemoteException -> 0x021f }
                        r6 = 0;
                        r7 = r19.getType();	 Catch:{ RemoteException -> 0x021f }
                        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ RemoteException -> 0x021f }
                        r5[r6] = r7;	 Catch:{ RemoteException -> 0x021f }
                        r6 = 1;
                        r7 = java.lang.Integer.valueOf(r13);	 Catch:{ RemoteException -> 0x021f }
                        r5[r6] = r7;	 Catch:{ RemoteException -> 0x021f }
                        r6 = 2;
                        r7 = java.lang.Integer.valueOf(r12);	 Catch:{ RemoteException -> 0x021f }
                        r5[r6] = r7;	 Catch:{ RemoteException -> 0x021f }
                        r6 = 3;
                        r7 = 0;
                        r5[r6] = r7;	 Catch:{ RemoteException -> 0x021f }
                        com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);	 Catch:{ RemoteException -> 0x021f }
                        r3 = r24.Cq();	 Catch:{ RemoteException -> 0x021f }
                        if (r3 != 0) goto L_0x028b;
                    L_0x0287:
                        if (r13 != 0) goto L_0x028b;
                    L_0x0289:
                        if (r12 == 0) goto L_0x032a;
                    L_0x028b:
                        r3 = r19.getType();	 Catch:{ RemoteException -> 0x021f }
                        r4 = 126; // 0x7e float:1.77E-43 double:6.23E-322;
                        if (r3 != r4) goto L_0x02d4;
                    L_0x0293:
                        r3 = "MicroMsg.AutoAuth";
                        r4 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x021f }
                        r5 = "net.end: reg err: type=";
                        r4.<init>(r5);	 Catch:{ RemoteException -> 0x021f }
                        r5 = r19.getType();	 Catch:{ RemoteException -> 0x021f }
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r5 = " err=";
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r4 = r4.append(r13);	 Catch:{ RemoteException -> 0x021f }
                        r5 = ",";
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r4 = r4.append(r12);	 Catch:{ RemoteException -> 0x021f }
                        r5 = " errmsg=";
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r5 = 0;
                        r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x021f }
                        r4 = r4.toString();	 Catch:{ RemoteException -> 0x021f }
                        com.tencent.mm.sdk.platformtools.w.e(r3, r4);	 Catch:{ RemoteException -> 0x021f }
                        goto L_0x0131;
                    L_0x02d1:
                        r2 = move-exception;
                        monitor-exit(r17);	 Catch:{ all -> 0x02d1 }
                        throw r2;
                    L_0x02d4:
                        switch(r12) {
                            case -213: goto L_0x02d9;
                            case -205: goto L_0x02d9;
                            case -100: goto L_0x02d9;
                            default: goto L_0x02d7;
                        };
                    L_0x02d7:
                        goto L_0x0131;
                    L_0x02d9:
                        r3 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ RemoteException -> 0x021f }
                        r4 = "auth_hold_prefs";
                        r5 = 0;
                        r3 = r3.getSharedPreferences(r4, r5);	 Catch:{ RemoteException -> 0x021f }
                        r3 = r3.edit();	 Catch:{ RemoteException -> 0x021f }
                        r4 = "auth_ishold";
                        r5 = 1;
                        r3 = r3.putBoolean(r4, r5);	 Catch:{ RemoteException -> 0x021f }
                        r3.commit();	 Catch:{ RemoteException -> 0x021f }
                        r3 = -213; // 0xffffffffffffff2b float:NaN double:NaN;
                        if (r12 != r3) goto L_0x0306;
                    L_0x02f8:
                        r3 = com.tencent.mm.plugin.report.c.oTb;	 Catch:{ RemoteException -> 0x021f }
                        r4 = 148; // 0x94 float:2.07E-43 double:7.3E-322;
                        r6 = 31;
                        r8 = 1;
                        r10 = 0;
                        r3.a(r4, r6, r8, r10);	 Catch:{ RemoteException -> 0x021f }
                        goto L_0x0131;
                    L_0x0306:
                        r3 = -100;
                        if (r12 != r3) goto L_0x0318;
                    L_0x030a:
                        r3 = com.tencent.mm.plugin.report.c.oTb;	 Catch:{ RemoteException -> 0x021f }
                        r4 = 148; // 0x94 float:2.07E-43 double:7.3E-322;
                        r6 = 32;
                        r8 = 1;
                        r10 = 0;
                        r3.a(r4, r6, r8, r10);	 Catch:{ RemoteException -> 0x021f }
                        goto L_0x0131;
                    L_0x0318:
                        r3 = -205; // 0xffffffffffffff33 float:NaN double:NaN;
                        if (r12 != r3) goto L_0x0131;
                    L_0x031c:
                        r3 = com.tencent.mm.plugin.report.c.oTb;	 Catch:{ RemoteException -> 0x021f }
                        r4 = 148; // 0x94 float:2.07E-43 double:7.3E-322;
                        r6 = 33;
                        r8 = 1;
                        r10 = 0;
                        r3.a(r4, r6, r8, r10);	 Catch:{ RemoteException -> 0x021f }
                        goto L_0x0131;
                    L_0x032a:
                        r3 = r19.Co();	 Catch:{ RemoteException -> 0x021f }
                        r4 = "MicroMsg.AutoAuth";
                        r5 = "summerauth accinfo doAuthEnd type:%d, ret:%d loginDecodeFailedTry:%d";
                        r6 = 3;
                        r6 = new java.lang.Object[r6];	 Catch:{ RemoteException -> 0x021f }
                        r7 = 0;
                        r8 = r19.getType();	 Catch:{ RemoteException -> 0x021f }
                        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ RemoteException -> 0x021f }
                        r6[r7] = r8;	 Catch:{ RemoteException -> 0x021f }
                        r7 = 1;
                        r8 = java.lang.Integer.valueOf(r3);	 Catch:{ RemoteException -> 0x021f }
                        r6[r7] = r8;	 Catch:{ RemoteException -> 0x021f }
                        r7 = 2;
                        r0 = r22;
                        r8 = r0.hSy;	 Catch:{ RemoteException -> 0x021f }
                        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ RemoteException -> 0x021f }
                        r6[r7] = r8;	 Catch:{ RemoteException -> 0x021f }
                        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r6);	 Catch:{ RemoteException -> 0x021f }
                        r4 = 2;
                        if (r3 != r4) goto L_0x0416;
                    L_0x035a:
                        r3 = r19.getType();	 Catch:{ RemoteException -> 0x021f }
                        r4 = 702; // 0x2be float:9.84E-43 double:3.47E-321;
                        if (r3 != r4) goto L_0x0131;
                    L_0x0362:
                        r3 = com.tencent.mm.plugin.report.c.oTb;	 Catch:{ RemoteException -> 0x021f }
                        r4 = 148; // 0x94 float:2.07E-43 double:7.3E-322;
                        r6 = 34;
                        r8 = 1;
                        r10 = 0;
                        r3.a(r4, r6, r8, r10);	 Catch:{ RemoteException -> 0x021f }
                        r0 = r22;
                        r3 = r0.hSy;	 Catch:{ RemoteException -> 0x021f }
                        r3 = r3 + 1;
                        r0 = r22;
                        r0.hSy = r3;	 Catch:{ RemoteException -> 0x021f }
                        r0 = r22;
                        r3 = r0.hSy;	 Catch:{ RemoteException -> 0x021f }
                        r4 = 1;
                        if (r3 <= r4) goto L_0x03a7;
                    L_0x037f:
                        r3 = "MicroMsg.AutoAuth";
                        r4 = "summerauth loginDecodeFailedTry beyond 1 no more try!";
                        com.tencent.mm.sdk.platformtools.w.w(r3, r4);	 Catch:{ RemoteException -> 0x021f }
                        r3 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x021f }
                        r4 = "auth_decode_failed_";
                        r3.<init>(r4);	 Catch:{ RemoteException -> 0x021f }
                        r4 = 0;
                        r5 = "";
                        r4 = com.tencent.mm.sdk.platformtools.bg.ap(r4, r5);	 Catch:{ RemoteException -> 0x021f }
                        r3 = r3.append(r4);	 Catch:{ RemoteException -> 0x021f }
                        r3 = r3.toString();	 Catch:{ RemoteException -> 0x021f }
                        r0 = r22;
                        r0.c(r13, r12, r3);	 Catch:{ RemoteException -> 0x021f }
                        goto L_0x0131;
                    L_0x03a7:
                        r5 = r24.uH();	 Catch:{ RemoteException -> 0x03df }
                        r3 = r24.Cr();	 Catch:{ RemoteException -> 0x03df }
                        r4 = com.tencent.mm.sdk.platformtools.bg.bm(r3);	 Catch:{ RemoteException -> 0x03df }
                        if (r4 == 0) goto L_0x0401;
                    L_0x03b5:
                        r3 = "";
                        r4 = r3;
                    L_0x03b9:
                        r3 = com.tencent.mm.sdk.platformtools.bg.bm(r23);	 Catch:{ RemoteException -> 0x03df }
                        if (r3 == 0) goto L_0x0407;
                    L_0x03bf:
                        r3 = "";
                    L_0x03c2:
                        r0 = r22;
                        r3 = r0.e(r4, r3, r5);	 Catch:{ RemoteException -> 0x03df }
                        if (r3 == 0) goto L_0x040c;
                    L_0x03ca:
                        r0 = r22;
                        r3 = r0.ieq;	 Catch:{ RemoteException -> 0x03df }
                        r0 = r23;
                        r3.htN = r0;	 Catch:{ RemoteException -> 0x03df }
                    L_0x03d2:
                        r0 = r22;
                        r3 = r0.ier;	 Catch:{ RemoteException -> 0x03df }
                        r4 = 0;
                        r5 = 0;
                        r0 = r19;
                        r0.a(r3, r4, r5);	 Catch:{ RemoteException -> 0x03df }
                        goto L_0x0131;
                    L_0x03df:
                        r3 = move-exception;
                        r4 = "MicroMsg.AutoAuth";
                        r5 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x021f }
                        r6 = "summerauth save serverid aak failed 1 cookie:";
                        r5.<init>(r6);	 Catch:{ RemoteException -> 0x021f }
                        r6 = com.tencent.mm.sdk.platformtools.bg.bo(r23);	 Catch:{ RemoteException -> 0x021f }
                        r5 = r5.append(r6);	 Catch:{ RemoteException -> 0x021f }
                        r5 = r5.toString();	 Catch:{ RemoteException -> 0x021f }
                        r6 = 0;
                        r6 = new java.lang.Object[r6];	 Catch:{ RemoteException -> 0x021f }
                        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r4, r3, r5, r6);	 Catch:{ RemoteException -> 0x021f }
                        com.tencent.mm.sdk.platformtools.w.bIP();	 Catch:{ RemoteException -> 0x021f }
                        throw r3;	 Catch:{ RemoteException -> 0x021f }
                    L_0x0401:
                        r3 = com.tencent.mm.sdk.platformtools.bg.bo(r3);	 Catch:{ RemoteException -> 0x03df }
                        r4 = r3;
                        goto L_0x03b9;
                    L_0x0407:
                        r3 = com.tencent.mm.sdk.platformtools.bg.bo(r23);	 Catch:{ RemoteException -> 0x03df }
                        goto L_0x03c2;
                    L_0x040c:
                        r3 = "MicroMsg.AutoAuth";
                        r4 = "summerauth save serverid aak failed 1";
                        com.tencent.mm.sdk.platformtools.w.w(r3, r4);	 Catch:{ RemoteException -> 0x03df }
                        goto L_0x03d2;
                    L_0x0416:
                        r3 = 0;
                        r0 = r22;
                        r0.hSy = r3;	 Catch:{ RemoteException -> 0x021f }
                        r5 = r19.Cm();	 Catch:{ RemoteException -> 0x021f }
                        r3 = "MicroMsg.AutoAuth";
                        r4 = "summerauth accinfo %d: username:%s, wxusername:%s, ticket:%s, session:%s, uin:%d";
                        r6 = 6;
                        r6 = new java.lang.Object[r6];	 Catch:{ RemoteException -> 0x04f8 }
                        r7 = 0;
                        r8 = r19.getType();	 Catch:{ RemoteException -> 0x04f8 }
                        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ RemoteException -> 0x04f8 }
                        r6[r7] = r8;	 Catch:{ RemoteException -> 0x04f8 }
                        r7 = 1;
                        r8 = r5.getUserName();	 Catch:{ RemoteException -> 0x04f8 }
                        r6[r7] = r8;	 Catch:{ RemoteException -> 0x04f8 }
                        r7 = 2;
                        r8 = r24.Cv();	 Catch:{ RemoteException -> 0x04f8 }
                        r6[r7] = r8;	 Catch:{ RemoteException -> 0x04f8 }
                        r7 = 3;
                        r8 = r24.Cr();	 Catch:{ RemoteException -> 0x04f8 }
                        r8 = com.tencent.mm.sdk.platformtools.bg.bl(r8);	 Catch:{ RemoteException -> 0x04f8 }
                        r8 = com.tencent.mm.sdk.platformtools.bg.Qj(r8);	 Catch:{ RemoteException -> 0x04f8 }
                        r6[r7] = r8;	 Catch:{ RemoteException -> 0x04f8 }
                        r7 = 4;
                        r8 = r24.vc();	 Catch:{ RemoteException -> 0x04f8 }
                        r8 = com.tencent.mm.sdk.platformtools.bg.bl(r8);	 Catch:{ RemoteException -> 0x04f8 }
                        r8 = com.tencent.mm.sdk.platformtools.bg.Qj(r8);	 Catch:{ RemoteException -> 0x04f8 }
                        r6[r7] = r8;	 Catch:{ RemoteException -> 0x04f8 }
                        r7 = 5;
                        r8 = r24.uH();	 Catch:{ RemoteException -> 0x04f8 }
                        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ RemoteException -> 0x04f8 }
                        r6[r7] = r8;	 Catch:{ RemoteException -> 0x04f8 }
                        com.tencent.mm.sdk.platformtools.w.i(r3, r4, r6);	 Catch:{ RemoteException -> 0x04f8 }
                        r6 = r24.uH();	 Catch:{ RemoteException -> 0x04f8 }
                        r3 = r24.Cr();	 Catch:{ RemoteException -> 0x04f8 }
                        r4 = com.tencent.mm.sdk.platformtools.bg.bm(r3);	 Catch:{ RemoteException -> 0x04f8 }
                        if (r4 == 0) goto L_0x04d7;
                    L_0x047b:
                        r3 = "";
                        r4 = r3;
                    L_0x047f:
                        r3 = com.tencent.mm.sdk.platformtools.bg.bm(r23);	 Catch:{ RemoteException -> 0x04f8 }
                        if (r3 == 0) goto L_0x04dd;
                    L_0x0485:
                        r3 = "";
                    L_0x0488:
                        r0 = r22;
                        r3 = r0.e(r4, r3, r6);	 Catch:{ RemoteException -> 0x04f8 }
                        if (r3 == 0) goto L_0x04e2;
                    L_0x0490:
                        r0 = r22;
                        r3 = r0.ieq;	 Catch:{ RemoteException -> 0x04f8 }
                        r0 = r23;
                        r3.htN = r0;	 Catch:{ RemoteException -> 0x04f8 }
                        r0 = r22;
                        r3 = r0.ieq;	 Catch:{ RemoteException -> 0x04f8 }
                        r4 = r5.getUserName();	 Catch:{ RemoteException -> 0x04f8 }
                        r3.username = r4;	 Catch:{ RemoteException -> 0x04f8 }
                        r0 = r22;
                        r3 = r0.ieq;	 Catch:{ RemoteException -> 0x04f8 }
                        r4 = r24.Cv();	 Catch:{ RemoteException -> 0x04f8 }
                        r3.ieb = r4;	 Catch:{ RemoteException -> 0x04f8 }
                        r0 = r22;
                        r3 = r0.ieq;	 Catch:{ RemoteException -> 0x04f8 }
                        r4 = r24.vc();	 Catch:{ RemoteException -> 0x04f8 }
                        r5 = r24.uH();	 Catch:{ RemoteException -> 0x04f8 }
                        r3.i(r4, r5);	 Catch:{ RemoteException -> 0x04f8 }
                        r0 = r22;
                        r3 = r0.ieq;	 Catch:{ RemoteException -> 0x04f8 }
                        r4 = r24.BZ();	 Catch:{ RemoteException -> 0x04f8 }
                        r3.iea = r4;	 Catch:{ RemoteException -> 0x04f8 }
                        r3 = r24.uH();	 Catch:{ RemoteException -> 0x04f8 }
                        com.tencent.mm.a.o.getString(r3);	 Catch:{ RemoteException -> 0x04f8 }
                    L_0x04cc:
                        r3 = "MicroMsg.AutoAuth";
                        r4 = "summerauth decode and save ok!";
                        com.tencent.mm.sdk.platformtools.w.i(r3, r4);	 Catch:{ RemoteException -> 0x021f }
                        goto L_0x0131;
                    L_0x04d7:
                        r3 = com.tencent.mm.sdk.platformtools.bg.bo(r3);	 Catch:{ RemoteException -> 0x04f8 }
                        r4 = r3;
                        goto L_0x047f;
                    L_0x04dd:
                        r3 = com.tencent.mm.sdk.platformtools.bg.bo(r23);	 Catch:{ RemoteException -> 0x04f8 }
                        goto L_0x0488;
                    L_0x04e2:
                        r3 = com.tencent.mm.plugin.report.c.oTb;	 Catch:{ RemoteException -> 0x04f8 }
                        r4 = 148; // 0x94 float:2.07E-43 double:7.3E-322;
                        r6 = 35;
                        r8 = 1;
                        r10 = 0;
                        r3.a(r4, r6, r8, r10);	 Catch:{ RemoteException -> 0x04f8 }
                        r3 = "MicroMsg.AutoAuth";
                        r4 = "summerauth save serverid aak failed 2";
                        com.tencent.mm.sdk.platformtools.w.w(r3, r4);	 Catch:{ RemoteException -> 0x04f8 }
                        goto L_0x04cc;
                    L_0x04f8:
                        r3 = move-exception;
                        r4 = "MicroMsg.AutoAuth";
                        r5 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x021f }
                        r6 = "summerauth save serverid aak failed 2 cookie:";
                        r5.<init>(r6);	 Catch:{ RemoteException -> 0x021f }
                        r6 = com.tencent.mm.sdk.platformtools.bg.bo(r23);	 Catch:{ RemoteException -> 0x021f }
                        r5 = r5.append(r6);	 Catch:{ RemoteException -> 0x021f }
                        r5 = r5.toString();	 Catch:{ RemoteException -> 0x021f }
                        r6 = 0;
                        r6 = new java.lang.Object[r6];	 Catch:{ RemoteException -> 0x021f }
                        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r4, r3, r5, r6);	 Catch:{ RemoteException -> 0x021f }
                        com.tencent.mm.sdk.platformtools.w.bIP();	 Catch:{ RemoteException -> 0x021f }
                        throw r3;	 Catch:{ RemoteException -> 0x021f }
                    L_0x051a:
                        if (r13 != 0) goto L_0x0541;
                    L_0x051c:
                        if (r12 != 0) goto L_0x0541;
                    L_0x051e:
                        r3 = r19.Cn();	 Catch:{ RemoteException -> 0x021f }
                        r3 = r3.Cs();	 Catch:{ RemoteException -> 0x021f }
                        r4 = r19.Cn();	 Catch:{ RemoteException -> 0x021f }
                        r4 = r4.Ct();	 Catch:{ RemoteException -> 0x021f }
                        r5 = r19.Cn();	 Catch:{ RemoteException -> 0x021f }
                        r5 = r5.Cu();	 Catch:{ RemoteException -> 0x021f }
                        com.tencent.mm.protocal.ac.G(r3, r4, r5);	 Catch:{ RemoteException -> 0x021f }
                        r4 = android.os.SystemClock.elapsedRealtime();	 Catch:{ RemoteException -> 0x021f }
                        r0 = r22;
                        r0.iet = r4;	 Catch:{ RemoteException -> 0x021f }
                    L_0x0541:
                        r3 = com.tencent.mm.platformtools.r.iiW;	 Catch:{ RemoteException -> 0x021f }
                        r4 = 10003; // 0x2713 float:1.4017E-41 double:4.942E-320;
                        if (r3 != r4) goto L_0x0594;
                    L_0x0547:
                        r3 = com.tencent.mm.platformtools.r.iiX;	 Catch:{ RemoteException -> 0x021f }
                        if (r3 <= 0) goto L_0x0594;
                    L_0x054b:
                        r3 = com.tencent.mm.platformtools.r.iiX;	 Catch:{ RemoteException -> 0x021f }
                        r4 = 1;
                        if (r3 > r4) goto L_0x0553;
                    L_0x0550:
                        r3 = 0;
                        com.tencent.mm.platformtools.r.iiX = r3;	 Catch:{ RemoteException -> 0x021f }
                    L_0x0553:
                        r4 = 4;
                        r3 = 0;
                        r5 = "";
                        r6 = "";
                        r7 = 0;
                        com.tencent.mm.protocal.ac.G(r5, r6, r7);	 Catch:{ RemoteException -> 0x021f }
                    L_0x055f:
                        r0 = r22;
                        r5 = r0.ieu;	 Catch:{ RemoteException -> 0x021f }
                        r6 = -1;
                        if (r5 == r6) goto L_0x0131;
                    L_0x0566:
                        if (r4 != 0) goto L_0x0573;
                    L_0x0568:
                        if (r3 != 0) goto L_0x0573;
                    L_0x056a:
                        r3 = 0;
                        r4 = 0;
                        r0 = r22;
                        r1 = r19;
                        r0.a(r1, r3, r4);	 Catch:{ RemoteException -> 0x021f }
                    L_0x0573:
                        r3 = -1;
                        r0 = r22;
                        r0.ieu = r3;	 Catch:{ RemoteException -> 0x021f }
                        goto L_0x0131;
                    L_0x057a:
                        r6 = 0;
                        r3 = r19.Cn();	 Catch:{ Exception -> 0x01b0 }
                        r8 = r3.BX();	 Catch:{ Exception -> 0x01b0 }
                        r3 = r18;
                        r7 = r19;
                        r2.a(r3, r4, r5, r6, r7, r8);	 Catch:{ Exception -> 0x01b0 }
                        goto L_0x0044;
                    L_0x058c:
                        r3 = move-exception;
                        goto L_0x0239;
                    L_0x058f:
                        r3 = move-exception;
                        r5 = r12;
                        r6 = r13;
                        goto L_0x0239;
                    L_0x0594:
                        r3 = r12;
                        r4 = r13;
                        goto L_0x055f;
                    L_0x0597:
                        r12 = r5;
                        r13 = r6;
                        goto L_0x00ab;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.network.ae.2.run():void");
                    }
                });
                return gW;
            } catch (Exception e) {
                exception = e;
                i4 = gW;
                w.e("StnCallBack", exception2String(exception));
                new StringBuilder().append(exception.getClass().getSimpleName()).append(":").append(exception.getStackTrace()[0]).append(", ").append(exception.getStackTrace()[1]);
                return i4;
            }
        } catch (Exception e2) {
            exception = e2;
            i4 = 0;
            w.e("StnCallBack", exception2String(exception));
            new StringBuilder().append(exception.getClass().getSimpleName()).append(":").append(exception.getStackTrace()[0]).append(", ").append(exception.getStackTrace()[1]);
            return i4;
        }
    }

    public final void reportConnectInfo(int i, int i2) {
        try {
            z.ML().gY(i);
        } catch (Throwable e) {
            w.e("StnCallBack", "reportConnectInfo :%s", bg.g(e));
        }
    }

    public final int getLongLinkIdentifyCheckBuffer(ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2, int[] iArr) {
        iArr[0] = ifP;
        iArr[1] = ifO;
        if (a(byteArrayOutputStream, byteArrayOutputStream2) != 0 && byteArrayOutputStream.size() != 0 && byteArrayOutputStream2.size() != 0) {
            return StnLogic.ECHECK_NOW;
        }
        requestDoSync();
        return StnLogic.ECHECK_NEXT;
    }

    public final boolean onLongLinkIdentifyResp(byte[] bArr, byte[] bArr2) {
        if (!(bArr == null || bArr2 == null)) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr2);
            } catch (IOException e) {
            }
            onPush(ifO, byteArrayOutputStream.toByteArray());
        }
        return true;
    }

    public final String[] requestNetCheckShortLinkHosts() {
        return new String[0];
    }

    private static int a(ByteArrayOutputStream byteArrayOutputStream, ByteArrayOutputStream byteArrayOutputStream2) {
        int i = 0;
        if (z.MO() != null) {
            try {
                byte[] Mx = z.MO().Mx();
                if (Mx != null) {
                    byteArrayOutputStream.write(Mx);
                    ifQ = Mx;
                }
                Mx = z.MO().gXJ;
                if (Mx != null) {
                    byteArrayOutputStream2.write(Mx);
                    ifR = Mx;
                }
                i = z.MO().ieq.uH();
            } catch (Exception e) {
                w.e("StnCallBack", exception2String(e));
                if (!(ifQ == null || ifR == null)) {
                    try {
                        byteArrayOutputStream.write(ifQ);
                        byteArrayOutputStream2.write(ifR);
                    } catch (IOException e2) {
                    }
                }
            }
        }
        return i;
    }

    public final void requestDoSync() {
        if (z.MQ() != null) {
            try {
                z.MM().post(new Runnable(this) {
                    final /* synthetic */ ae ifU;

                    {
                        this.ifU = r1;
                    }

                    public final void run() {
                        z.MQ().onPush(24, n.cP(7));
                    }
                });
            } catch (Exception e) {
                w.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[0]).append(", ").append(e.getStackTrace()[1]);
            }
        }
    }

    public final boolean isLogoned() {
        boolean z = false;
        if (z.MO() != null) {
            try {
                z = z.MO().ieq.BY();
            } catch (Exception e) {
                w.e("StnCallBack", exception2String(e));
                new StringBuilder().append(e.getClass().getSimpleName()).append(":").append(e.getStackTrace()[z]).append(", ").append(e.getStackTrace()[1]);
            }
        }
        return z;
    }
}
