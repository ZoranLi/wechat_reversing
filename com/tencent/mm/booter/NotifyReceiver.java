package com.tencent.mm.booter;

import android.app.Notification;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.e.a.lc;
import com.tencent.mm.kernel.api.h;
import com.tencent.mm.network.z;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NotifyReceiver extends BroadcastReceiver {
    private static WakerLock gJG = null;
    private static WakerLock gJT = null;
    private static Set<Long> gJU = new HashSet();
    private static Lock gJV = new ReentrantLock(false);
    private static byte[] gJW = new byte[0];
    private static byte[] gJX = new byte[0];
    private static a gJY;
    private static boolean gJZ = true;

    public static class NotifyService extends Service {
        Boolean gKc = null;
        private h gKd;

        public static class InnerService extends Service {
            public void onCreate() {
                super.onCreate();
                try {
                    startForeground(-1212, new Notification());
                } catch (NullPointerException e) {
                    w.e("MicroMsg.NotifyReceiver", "set service for mm exception:%s", e);
                }
                stopSelf();
            }

            public void onDestroy() {
                stopForeground(true);
                super.onDestroy();
            }

            public IBinder onBind(Intent intent) {
                return null;
            }
        }

        private void l(android.content.Intent r14) {
            /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:72:0x02bd
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.modifyBlocksTree(BlockProcessor.java:248)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r13 = this;
            r0 = "notify_option_type";
            r1 = 0;
            r2 = r14.getIntExtra(r0, r1);
            if (r2 != 0) goto L_0x0014;
        L_0x000a:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = "receiveImp invalid opcode.";
            com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        L_0x0013:
            return;
        L_0x0014:
            r0 = com.tencent.mm.kernel.h.vG();
            r0 = r0.uV();
            if (r0 != 0) goto L_0x0025;
        L_0x001e:
            r0 = com.tencent.mm.kernel.h.vG();
            r0.initialize();
        L_0x0025:
            r0 = com.tencent.mm.kernel.h.vG();
            r0 = r0.uV();
            if (r0 == 0) goto L_0x0035;
        L_0x002f:
            r0 = com.tencent.mm.kernel.a.uP();
            if (r0 == 0) goto L_0x0063;
        L_0x0035:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = "receiveImp hasSetuin:%b  isHold:%b  opcode:%d";
            r3 = 3;
            r3 = new java.lang.Object[r3];
            r4 = 0;
            r5 = com.tencent.mm.kernel.h.vG();
            r5 = r5.uV();
            r5 = java.lang.Boolean.valueOf(r5);
            r3[r4] = r5;
            r4 = 1;
            r5 = com.tencent.mm.kernel.a.uP();
            r5 = java.lang.Boolean.valueOf(r5);
            r3[r4] = r5;
            r4 = 2;
            r2 = java.lang.Integer.valueOf(r2);
            r3[r4] = r2;
            com.tencent.mm.sdk.platformtools.w.e(r0, r1, r3);
            goto L_0x0013;
        L_0x0063:
            r0 = com.tencent.mm.kernel.h.vd();
            r0 = r0.hsZ;
            if (r0 != 0) goto L_0x0086;
        L_0x006b:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = "receiveImp  opcode:%d  getDispatcher == null";
            r3 = 1;
            r3 = new java.lang.Object[r3];
            r4 = 0;
            r5 = java.lang.Integer.valueOf(r2);
            r3[r4] = r5;
            com.tencent.mm.sdk.platformtools.w.w(r0, r1, r3);
            r0 = com.tencent.mm.kernel.h.vd();
            r1 = 1;
            r0.aW(r1);
        L_0x0086:
            r0 = r13.gKc;
            if (r0 != 0) goto L_0x009b;
        L_0x008a:
            r0 = com.tencent.mm.sdk.a.b.bIu();
            if (r0 == 0) goto L_0x00ce;
        L_0x0090:
            r0 = r13;
        L_0x0091:
            r1 = 0;
            r12 = r1;
            r1 = r0;
            r0 = r12;
        L_0x0095:
            r0 = java.lang.Boolean.valueOf(r0);
            r1.gKc = r0;
        L_0x009b:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = "handleCommand useOld:%s operationCode:%d";
            r3 = 2;
            r3 = new java.lang.Object[r3];
            r4 = 0;
            r5 = r13.gKc;
            r3[r4] = r5;
            r4 = 1;
            r5 = java.lang.Integer.valueOf(r2);
            r3[r4] = r5;
            com.tencent.mm.sdk.platformtools.w.i(r0, r1, r3);
            switch(r2) {
                case 1: goto L_0x00fb;
                case 2: goto L_0x018f;
                default: goto L_0x00b6;
            };
        L_0x00b6:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = new java.lang.StringBuilder;
            r3 = "invald opCode:";
            r1.<init>(r3);
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.w.e(r0, r1);
            goto L_0x0013;
        L_0x00ce:
            r0 = com.tencent.mm.plugin.zero.b.a.class;
            r0 = com.tencent.mm.kernel.h.h(r0);
            r0 = (com.tencent.mm.plugin.zero.b.a) r0;
            r0 = r0.sV();
            r1 = "AndroidOldNotifyReceiver";
            r0 = r0.getValue(r1);
            r1 = 0;
            r0 = com.tencent.mm.sdk.platformtools.bg.getInt(r0, r1);
            com.tencent.mm.kernel.h.vJ();
            com.tencent.mm.kernel.h.vG();
            r1 = com.tencent.mm.kernel.a.uH();
            r3 = 100;
            r1 = com.tencent.mm.a.h.aw(r1, r3);
            if (r0 <= r1) goto L_0x061e;
        L_0x00f8:
            r0 = 1;
            r1 = r13;
            goto L_0x0095;
        L_0x00fb:
            r0 = r13.gKc;
            r0 = r0.booleanValue();
            if (r0 == 0) goto L_0x010d;
        L_0x0103:
            r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
            r1 = "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NETWORK_AVAILABLE";
            s(r0, r1);
        L_0x010d:
            r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
            r1 = "MicroMsg.NotifyReceiver";
            r2 = "dealWithLooper";
            com.tencent.mm.sdk.platformtools.w.i(r1, r2);
            r1 = com.tencent.mm.kernel.h.vG();
            r1 = r1.uV();
            if (r1 == 0) goto L_0x012a;
        L_0x0124:
            r1 = com.tencent.mm.kernel.a.uP();
            if (r1 == 0) goto L_0x0159;
        L_0x012a:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = new java.lang.StringBuilder;
            r2 = "receiveImp hasSetuin:";
            r1.<init>(r2);
            r2 = com.tencent.mm.kernel.h.vG();
            r2 = r2.uV();
            r1 = r1.append(r2);
            r2 = " isHold:";
            r1 = r1.append(r2);
            r2 = com.tencent.mm.kernel.a.uP();
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.w.w(r0, r1);
            goto L_0x0013;
        L_0x0159:
            r1 = com.tencent.mm.kernel.h.vd();
            r1 = r1.foreground;
            if (r1 != 0) goto L_0x016c;
        L_0x0161:
            if (r0 == 0) goto L_0x017e;
        L_0x0163:
            r0 = com.tencent.mm.sdk.platformtools.am.isWap(r0);
            if (r0 != 0) goto L_0x017e;
        L_0x0169:
            r0 = 1;
        L_0x016a:
            if (r0 != 0) goto L_0x0180;
        L_0x016c:
            r0 = com.tencent.mm.plugin.zero.b.b.class;
            r0 = com.tencent.mm.kernel.h.h(r0);
            r0 = (com.tencent.mm.plugin.zero.b.b) r0;
            r0 = r0.Hy();
            r1 = 2;
            r0.gg(r1);
            goto L_0x0013;
        L_0x017e:
            r0 = 0;
            goto L_0x016a;
        L_0x0180:
            r0 = com.tencent.mm.kernel.h.vd();
            r1 = new com.tencent.mm.modelmulti.k;
            r1.<init>();
            r2 = 0;
            r0.a(r1, r2);
            goto L_0x0013;
        L_0x018f:
            r0 = r13.gKc;
            r0 = r0.booleanValue();
            if (r0 == 0) goto L_0x0468;
        L_0x0197:
            r0 = com.tencent.mm.sdk.platformtools.ab.getContext();
            r1 = "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NOTIFY";
            s(r0, r1);
            r0 = "notify_respType";
            r1 = 0;
            r3 = r14.getIntExtra(r0, r1);
            r0 = "notify_respBuf";
            r4 = r14.getByteArrayExtra(r0);
            r0 = "notify_skey";
            r5 = r14.getByteArrayExtra(r0);
            r0 = "notfiy_recv_time";
            r6 = -1;
            r6 = r14.getLongExtra(r0, r6);
            r1 = "MicroMsg.NotifyReceiver";
            r2 = "dealWithNotify respType:%d recvTime:%d respBuf:%d sessionkey:%s ";
            r0 = 4;
            r8 = new java.lang.Object[r0];
            r0 = 0;
            r9 = java.lang.Integer.valueOf(r3);
            r8[r0] = r9;
            r0 = 1;
            r9 = java.lang.Long.valueOf(r6);
            r8[r0] = r9;
            r9 = 2;
            if (r4 != 0) goto L_0x0202;
        L_0x01da:
            r0 = -1;
        L_0x01db:
            r0 = java.lang.Integer.valueOf(r0);
            r8[r9] = r0;
            r0 = 3;
            r9 = com.tencent.mm.sdk.platformtools.bg.bo(r5);
            r9 = com.tencent.mm.sdk.platformtools.bg.Qj(r9);
            r8[r0] = r9;
            com.tencent.mm.sdk.platformtools.w.i(r1, r2, r8);
            switch(r3) {
                case 39: goto L_0x03f2;
                case 138: goto L_0x02c5;
                case 268369921: goto L_0x0204;
                case 1000000205: goto L_0x0358;
                case 2147480001: goto L_0x0401;
                default: goto L_0x01f2;
            };
        L_0x01f2:
            r0 = com.tencent.mm.plugin.zero.PluginZero.class;
            r0 = com.tencent.mm.kernel.h.j(r0);
            r0 = (com.tencent.mm.plugin.zero.PluginZero) r0;
            r1 = r0.sAT;
            r2 = r13;
            r1.a(r2, r3, r4, r5, r6);
            goto L_0x0013;
        L_0x0202:
            r0 = r4.length;
            goto L_0x01db;
        L_0x0204:
            r0 = com.tencent.mm.sdk.platformtools.bg.bm(r5);
            if (r0 == 0) goto L_0x0222;
        L_0x020a:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = new java.lang.StringBuilder;
            r2 = "dkpush dealWithNotify session:";
            r1.<init>(r2);
            r1 = r1.append(r5);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.w.e(r0, r1);
            goto L_0x0013;
        L_0x0222:
            r0 = com.tencent.mm.sdk.platformtools.bg.bm(r4);
            if (r0 != 0) goto L_0x022d;
        L_0x0228:
            r0 = r4.length;
            r1 = 8;
            if (r0 > r1) goto L_0x0238;
        L_0x022d:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = "dkpush dealWithNotify respBuf error ";
            com.tencent.mm.sdk.platformtools.w.e(r0, r1);
            goto L_0x0013;
        L_0x0238:
            r0 = 0;
            r0 = com.tencent.mm.a.n.c(r4, r0);
            r1 = 4;
            r1 = com.tencent.mm.a.n.c(r4, r1);
            r2 = r4.length;
            r2 = r2 + -8;
            if (r1 == r2) goto L_0x0260;
        L_0x0247:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = new java.lang.StringBuilder;
            r2 = "dkpush: respBuf length error len:";
            r1.<init>(r2);
            r2 = r4.length;
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.w.e(r0, r1);
            goto L_0x0013;
        L_0x0260:
            r2 = new byte[r1];
            r3 = 8;
            r8 = 0;
            java.lang.System.arraycopy(r4, r3, r2, r8, r1);
            r3 = "MicroMsg.NotifyReceiver";
            r8 = "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d";
            r9 = 4;
            r9 = new java.lang.Object[r9];
            r10 = 0;
            r11 = java.lang.Integer.valueOf(r0);
            r9[r10] = r11;
            r10 = 1;
            r1 = java.lang.Integer.valueOf(r1);
            r9[r10] = r1;
            r1 = 2;
            r4 = r4.length;
            r4 = java.lang.Integer.valueOf(r4);
            r9[r1] = r4;
            r1 = 3;
            r4 = java.lang.Long.valueOf(r6);
            r9[r1] = r4;
            com.tencent.mm.sdk.platformtools.w.i(r3, r8, r9);
            r1 = com.tencent.mm.booter.NotifyReceiver.gJV;	 Catch:{ all -> 0x02bc }
            r1.lock();	 Catch:{ all -> 0x02bc }
            com.tencent.mm.modelmulti.m.a(r0, r2, r5, r6);	 Catch:{ all -> 0x02bc }
            r0 = com.tencent.mm.booter.NotifyReceiver.gJU;	 Catch:{ all -> 0x02bc }
            r1 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x02bc }
            r0.add(r1);	 Catch:{ all -> 0x02bc }
            r0 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x02bc }
            r1 = "NotifyReceiver.NotifyData";	 Catch:{ all -> 0x02bc }
            t(r0, r1);	 Catch:{ all -> 0x02bc }
            r0 = com.tencent.mm.booter.NotifyReceiver.gJV;
            r0.unlock();
            goto L_0x0013;
        L_0x02b9:
            r0 = move-exception;
            goto L_0x0013;
        L_0x02bc:
            r0 = move-exception;
            r1 = com.tencent.mm.booter.NotifyReceiver.gJV;	 Catch:{ Exception -> 0x061b }
            r1.unlock();	 Catch:{ Exception -> 0x061b }
        L_0x02c4:
            throw r0;
        L_0x02c5:
            if (r4 != 0) goto L_0x0343;
        L_0x02c7:
            r0 = 7;
            r2 = r0;
        L_0x02c9:
            if (r4 != 0) goto L_0x034a;
        L_0x02cb:
            r0 = 2;
            r1 = r0;
        L_0x02cd:
            r3 = "MicroMsg.NotifyReceiver";
            r5 = "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ";
            r0 = 3;
            r6 = new java.lang.Object[r0];
            r0 = 0;
            r7 = java.lang.Integer.valueOf(r2);
            r6[r0] = r7;
            r0 = 1;
            r7 = java.lang.Integer.valueOf(r1);
            r6[r0] = r7;
            r7 = 2;
            if (r4 != 0) goto L_0x034d;
        L_0x02e7:
            r0 = -1;
        L_0x02e8:
            r0 = java.lang.Integer.valueOf(r0);
            r6[r7] = r0;
            com.tencent.mm.sdk.platformtools.w.d(r3, r5, r6);
            r0 = com.tencent.mm.booter.NotifyReceiver.gJV;	 Catch:{ all -> 0x034f }
            r0.lock();	 Catch:{ all -> 0x034f }
            r0 = com.tencent.mm.plugin.zero.b.b.class;	 Catch:{ all -> 0x034f }
            r0 = com.tencent.mm.kernel.h.h(r0);	 Catch:{ all -> 0x034f }
            r0 = (com.tencent.mm.plugin.zero.b.b) r0;	 Catch:{ all -> 0x034f }
            r0 = r0.Hy();	 Catch:{ all -> 0x034f }
            r2 = (long) r2;	 Catch:{ all -> 0x034f }
            r4 = "";	 Catch:{ all -> 0x034f }
            r0 = r0.a(r2, r1, r4);	 Catch:{ all -> 0x034f }
            if (r0 <= 0) goto L_0x0337;	 Catch:{ all -> 0x034f }
        L_0x030e:
            r1 = "MicroMsg.NotifyReceiver";	 Catch:{ all -> 0x034f }
            r2 = "add scene hash to memo, hash:%d";	 Catch:{ all -> 0x034f }
            r3 = 1;	 Catch:{ all -> 0x034f }
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x034f }
            r4 = 0;	 Catch:{ all -> 0x034f }
            r5 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x034f }
            r3[r4] = r5;	 Catch:{ all -> 0x034f }
            com.tencent.mm.sdk.platformtools.w.d(r1, r2, r3);	 Catch:{ all -> 0x034f }
            r1 = com.tencent.mm.booter.NotifyReceiver.gJU;	 Catch:{ all -> 0x034f }
            r2 = (long) r0;	 Catch:{ all -> 0x034f }
            r0 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x034f }
            r1.add(r0);	 Catch:{ all -> 0x034f }
            r0 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x034f }
            r1 = "NotifyReceiver.dealWithNotify:MMFunc_NewSync";	 Catch:{ all -> 0x034f }
            t(r0, r1);	 Catch:{ all -> 0x034f }
        L_0x0337:
            r0 = com.tencent.mm.booter.NotifyReceiver.gJV;
            r0.unlock();
            goto L_0x0013;
        L_0x0340:
            r0 = move-exception;
            goto L_0x0013;
        L_0x0343:
            r0 = 0;
            r0 = com.tencent.mm.a.n.c(r4, r0);
            r2 = r0;
            goto L_0x02c9;
        L_0x034a:
            r0 = 1;
            r1 = r0;
            goto L_0x02cd;
        L_0x034d:
            r0 = r4.length;
            goto L_0x02e8;
        L_0x034f:
            r0 = move-exception;
            r1 = com.tencent.mm.booter.NotifyReceiver.gJV;	 Catch:{ Exception -> 0x0618 }
            r1.unlock();	 Catch:{ Exception -> 0x0618 }
        L_0x0357:
            throw r0;
        L_0x0358:
            r1 = "MicroMsg.NotifyReceiver";
            r2 = new java.lang.StringBuilder;
            r0 = "oreh on newsynccheck2 notify, notify=";
            r2.<init>(r0);
            if (r4 == 0) goto L_0x03ce;
        L_0x0365:
            r0 = 1;
        L_0x0366:
            r0 = r2.append(r0);
            r0 = r0.toString();
            com.tencent.mm.sdk.platformtools.w.d(r1, r0);
            r1 = new com.tencent.mm.protocal.aa$b;
            r1.<init>();
            r1.y(r4);	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r0 = com.tencent.mm.booter.NotifyReceiver.gJV;	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r0.lock();	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r0 = com.tencent.mm.plugin.zero.b.b.class;	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r0 = com.tencent.mm.kernel.h.h(r0);	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r0 = (com.tencent.mm.plugin.zero.b.b) r0;	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r0 = r0.Hy();	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r2 = r1.taj;	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r4 = 1;	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r1 = r1.bHr();	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r0 = r0.a(r2, r4, r1);	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            if (r0 <= 0) goto L_0x03c2;	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
        L_0x0399:
            r1 = "MicroMsg.NotifyReceiver";	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r2 = "add scene hash to memo, hash:%d";	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r3 = 1;	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r4 = 0;	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r5 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r3[r4] = r5;	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            com.tencent.mm.sdk.platformtools.w.d(r1, r2, r3);	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r1 = com.tencent.mm.booter.NotifyReceiver.gJU;	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r2 = (long) r0;	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r0 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r1.add(r0);	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r0 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r1 = "NotifyReceiver.dealWithNotify:MM_PKT_NEW_SYNC_CHECK2_RESP";	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            t(r0, r1);	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
        L_0x03c2:
            r0 = com.tencent.mm.booter.NotifyReceiver.gJV;	 Catch:{ Exception -> 0x03cb }
            r0.unlock();	 Catch:{ Exception -> 0x03cb }
            goto L_0x0013;
        L_0x03cb:
            r0 = move-exception;
            goto L_0x0013;
        L_0x03ce:
            r0 = 0;
            goto L_0x0366;
        L_0x03d0:
            r0 = move-exception;
            r1 = "MicroMsg.NotifyReceiver";	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r2 = "";	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r3 = 0;	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r3);	 Catch:{ Exception -> 0x03d0, all -> 0x03e9 }
            r0 = com.tencent.mm.booter.NotifyReceiver.gJV;
            r0.unlock();
            goto L_0x0013;
        L_0x03e6:
            r0 = move-exception;
            goto L_0x0013;
        L_0x03e9:
            r0 = move-exception;
            r1 = com.tencent.mm.booter.NotifyReceiver.gJV;	 Catch:{ Exception -> 0x0615 }
            r1.unlock();	 Catch:{ Exception -> 0x0615 }
        L_0x03f1:
            throw r0;
        L_0x03f2:
            r0 = com.tencent.mm.kernel.h.vd();
            r1 = new com.tencent.mm.modelmulti.k;
            r1.<init>();
            r2 = 0;
            r0.a(r1, r2);
            goto L_0x0013;
        L_0x0401:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = "dkpush GCM Notify";
            com.tencent.mm.sdk.platformtools.w.d(r0, r1);
            r0 = com.tencent.mm.plugin.zero.b.b.class;
            r0 = com.tencent.mm.kernel.h.h(r0);
            r0 = (com.tencent.mm.plugin.zero.b.b) r0;
            r0 = r0.Hy();
            r2 = 7;
            r1 = 13;
            r4 = "";
            r0 = r0.a(r2, r1, r4);
            r1 = com.tencent.mm.booter.NotifyReceiver.gJV;	 Catch:{ all -> 0x045f }
            r1.lock();	 Catch:{ all -> 0x045f }
            if (r0 <= 0) goto L_0x0453;	 Catch:{ all -> 0x045f }
        L_0x042a:
            r1 = "MicroMsg.NotifyReceiver";	 Catch:{ all -> 0x045f }
            r2 = "add scene hash to memo, hash:%d";	 Catch:{ all -> 0x045f }
            r3 = 1;	 Catch:{ all -> 0x045f }
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x045f }
            r4 = 0;	 Catch:{ all -> 0x045f }
            r5 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x045f }
            r3[r4] = r5;	 Catch:{ all -> 0x045f }
            com.tencent.mm.sdk.platformtools.w.d(r1, r2, r3);	 Catch:{ all -> 0x045f }
            r1 = com.tencent.mm.booter.NotifyReceiver.gJU;	 Catch:{ all -> 0x045f }
            r2 = (long) r0;	 Catch:{ all -> 0x045f }
            r0 = java.lang.Long.valueOf(r2);	 Catch:{ all -> 0x045f }
            r1.add(r0);	 Catch:{ all -> 0x045f }
            r0 = com.tencent.mm.sdk.platformtools.ab.getContext();	 Catch:{ all -> 0x045f }
            r1 = "NotifyReceiver.dealWithNotify:MM_PKT_GCM_NOTIFY";	 Catch:{ all -> 0x045f }
            t(r0, r1);	 Catch:{ all -> 0x045f }
        L_0x0453:
            r0 = com.tencent.mm.booter.NotifyReceiver.gJV;
            r0.unlock();
            goto L_0x0013;
        L_0x045c:
            r0 = move-exception;
            goto L_0x0013;
        L_0x045f:
            r0 = move-exception;
            r1 = com.tencent.mm.booter.NotifyReceiver.gJV;	 Catch:{ Exception -> 0x0612 }
            r1.unlock();	 Catch:{ Exception -> 0x0612 }
        L_0x0467:
            throw r0;
        L_0x0468:
            r0 = "notify_respType";
            r1 = 0;
            r3 = r14.getIntExtra(r0, r1);
            r0 = "notify_respBuf";
            r4 = r14.getByteArrayExtra(r0);
            r0 = "notify_skey";
            r5 = r14.getByteArrayExtra(r0);
            r0 = "notfiy_recv_time";
            r6 = -1;
            r6 = r14.getLongExtra(r0, r6);
            r1 = "MicroMsg.NotifyReceiver";
            r2 = "dealWithNotify respType:%d recvTime:%d respBuf:%d sessionkey:%s ";
            r0 = 4;
            r8 = new java.lang.Object[r0];
            r0 = 0;
            r9 = java.lang.Integer.valueOf(r3);
            r8[r0] = r9;
            r0 = 1;
            r9 = java.lang.Long.valueOf(r6);
            r8[r0] = r9;
            r9 = 2;
            if (r4 != 0) goto L_0x04c9;
        L_0x04a1:
            r0 = -1;
        L_0x04a2:
            r0 = java.lang.Integer.valueOf(r0);
            r8[r9] = r0;
            r0 = 3;
            r9 = com.tencent.mm.sdk.platformtools.bg.bo(r5);
            r9 = com.tencent.mm.sdk.platformtools.bg.Qj(r9);
            r8[r0] = r9;
            com.tencent.mm.sdk.platformtools.w.i(r1, r2, r8);
            switch(r3) {
                case 39: goto L_0x0603;
                case 138: goto L_0x055d;
                case 268369921: goto L_0x04cb;
                case 1000000205: goto L_0x05cb;
                case 2147480001: goto L_0x05aa;
                default: goto L_0x04b9;
            };
        L_0x04b9:
            r0 = com.tencent.mm.plugin.zero.PluginZero.class;
            r0 = com.tencent.mm.kernel.h.j(r0);
            r0 = (com.tencent.mm.plugin.zero.PluginZero) r0;
            r1 = r0.sAT;
            r2 = r13;
            r1.a(r2, r3, r4, r5, r6);
            goto L_0x0013;
        L_0x04c9:
            r0 = r4.length;
            goto L_0x04a2;
        L_0x04cb:
            r0 = com.tencent.mm.sdk.platformtools.bg.bm(r5);
            if (r0 == 0) goto L_0x04e9;
        L_0x04d1:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = new java.lang.StringBuilder;
            r2 = "dkpush dealWithNotify session:";
            r1.<init>(r2);
            r1 = r1.append(r5);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.w.e(r0, r1);
            goto L_0x0013;
        L_0x04e9:
            r0 = com.tencent.mm.sdk.platformtools.bg.bm(r4);
            if (r0 != 0) goto L_0x04f4;
        L_0x04ef:
            r0 = r4.length;
            r1 = 8;
            if (r0 > r1) goto L_0x04ff;
        L_0x04f4:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = "dkpush dealWithNotify respBuf error ";
            com.tencent.mm.sdk.platformtools.w.e(r0, r1);
            goto L_0x0013;
        L_0x04ff:
            r0 = 0;
            r0 = com.tencent.mm.a.n.c(r4, r0);
            r1 = 4;
            r1 = com.tencent.mm.a.n.c(r4, r1);
            r2 = r4.length;
            r2 = r2 + -8;
            if (r1 == r2) goto L_0x0527;
        L_0x050e:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = new java.lang.StringBuilder;
            r2 = "dkpush: respBuf length error len:";
            r1.<init>(r2);
            r2 = r4.length;
            r1 = r1.append(r2);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.w.e(r0, r1);
            goto L_0x0013;
        L_0x0527:
            r2 = new byte[r1];
            r3 = 8;
            r8 = 0;
            java.lang.System.arraycopy(r4, r3, r2, r8, r1);
            r3 = "MicroMsg.NotifyReceiver";
            r8 = "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d";
            r9 = 4;
            r9 = new java.lang.Object[r9];
            r10 = 0;
            r11 = java.lang.Integer.valueOf(r0);
            r9[r10] = r11;
            r10 = 1;
            r1 = java.lang.Integer.valueOf(r1);
            r9[r10] = r1;
            r1 = 2;
            r4 = r4.length;
            r4 = java.lang.Integer.valueOf(r4);
            r9[r1] = r4;
            r1 = 3;
            r4 = java.lang.Long.valueOf(r6);
            r9[r1] = r4;
            com.tencent.mm.sdk.platformtools.w.i(r3, r8, r9);
            com.tencent.mm.modelmulti.m.a(r0, r2, r5, r6);
            goto L_0x0013;
        L_0x055d:
            if (r4 != 0) goto L_0x059e;
        L_0x055f:
            r0 = 7;
            r2 = r0;
        L_0x0561:
            if (r4 != 0) goto L_0x05a5;
        L_0x0563:
            r0 = 2;
            r1 = r0;
        L_0x0565:
            r3 = "MicroMsg.NotifyReceiver";
            r5 = "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ";
            r0 = 3;
            r6 = new java.lang.Object[r0];
            r0 = 0;
            r7 = java.lang.Integer.valueOf(r2);
            r6[r0] = r7;
            r0 = 1;
            r7 = java.lang.Integer.valueOf(r1);
            r6[r0] = r7;
            r7 = 2;
            if (r4 != 0) goto L_0x05a8;
        L_0x057f:
            r0 = -1;
        L_0x0580:
            r0 = java.lang.Integer.valueOf(r0);
            r6[r7] = r0;
            com.tencent.mm.sdk.platformtools.w.i(r3, r5, r6);
            r0 = com.tencent.mm.plugin.zero.b.b.class;
            r0 = com.tencent.mm.kernel.h.h(r0);
            r0 = (com.tencent.mm.plugin.zero.b.b) r0;
            r0 = r0.Hy();
            r2 = (long) r2;
            r4 = "";
            r0.a(r2, r1, r4);
            goto L_0x0013;
        L_0x059e:
            r0 = 0;
            r0 = com.tencent.mm.a.n.c(r4, r0);
            r2 = r0;
            goto L_0x0561;
        L_0x05a5:
            r0 = 1;
            r1 = r0;
            goto L_0x0565;
        L_0x05a8:
            r0 = r4.length;
            goto L_0x0580;
        L_0x05aa:
            r0 = "MicroMsg.NotifyReceiver";
            r1 = "dkpush GCM Notify";
            com.tencent.mm.sdk.platformtools.w.i(r0, r1);
            r0 = com.tencent.mm.plugin.zero.b.b.class;
            r0 = com.tencent.mm.kernel.h.h(r0);
            r0 = (com.tencent.mm.plugin.zero.b.b) r0;
            r0 = r0.Hy();
            r2 = 7;
            r1 = 13;
            r4 = "";
            r0.a(r2, r1, r4);
            goto L_0x0013;
        L_0x05cb:
            r1 = "MicroMsg.NotifyReceiver";
            r2 = new java.lang.StringBuilder;
            r0 = "oreh on newsynccheck2 notify, notify=";
            r2.<init>(r0);
            if (r4 == 0) goto L_0x0601;
        L_0x05d8:
            r0 = 1;
        L_0x05d9:
            r0 = r2.append(r0);
            r0 = r0.toString();
            com.tencent.mm.sdk.platformtools.w.i(r1, r0);
            r1 = new com.tencent.mm.protocal.aa$b;
            r1.<init>();
            r0 = com.tencent.mm.plugin.zero.b.b.class;
            r0 = com.tencent.mm.kernel.h.h(r0);
            r0 = (com.tencent.mm.plugin.zero.b.b) r0;
            r0 = r0.Hy();
            r2 = r1.taj;
            r4 = 1;
            r1 = r1.bHr();
            r0.a(r2, r4, r1);
            goto L_0x0013;
        L_0x0601:
            r0 = 0;
            goto L_0x05d9;
        L_0x0603:
            r0 = com.tencent.mm.kernel.h.vd();
            r1 = new com.tencent.mm.modelmulti.k;
            r1.<init>();
            r2 = 0;
            r0.a(r1, r2);
            goto L_0x0013;
        L_0x0612:
            r1 = move-exception;
            goto L_0x0467;
        L_0x0615:
            r1 = move-exception;
            goto L_0x03f1;
        L_0x0618:
            r1 = move-exception;
            goto L_0x0357;
        L_0x061b:
            r1 = move-exception;
            goto L_0x02c4;
        L_0x061e:
            r0 = r13;
            goto L_0x0091;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.booter.NotifyReceiver.NotifyService.l(android.content.Intent):void");
        }

        public void onStart(Intent intent, int i) {
            k(intent);
        }

        public int onStartCommand(Intent intent, int i, int i2) {
            w.i("MicroMsg.NotifyReceiver", "NotifyService onStartCommand flags :" + i + "startId :" + i2 + " intent " + intent);
            k(intent);
            return 2;
        }

        public IBinder onBind(Intent intent) {
            return null;
        }

        private void k(final Intent intent) {
            if (intent == null) {
                w.e("MicroMsg.NotifyReceiver", "receiveImp receiveIntent == null");
                return;
            }
            if (com.tencent.mm.kernel.h.vJ().gYJ.gZf) {
                boolean z = false;
            } else {
                w.e("MicroMsg.NotifyReceiver", "summerboot WorkerProfile not has create, status %d", Integer.valueOf(0));
                if (this.gKd != null) {
                    com.tencent.mm.kernel.h.vJ().b(this.gKd);
                }
                final long currentTimeMillis = System.currentTimeMillis();
                this.gKd = new h(this) {
                    final /* synthetic */ NotifyService gKg;

                    public final void oh() {
                        com.tencent.mm.kernel.h.vJ().b(this);
                        this.gKg.gKd = null;
                        long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                        w.i("MicroMsg.NotifyReceiver", "summerboot startupDone[%b] take[%d]ms tid[%d] post last notify task", Boolean.valueOf(com.tencent.mm.kernel.h.vJ().gYJ.gZf), Long.valueOf(currentTimeMillis), Long.valueOf(Thread.currentThread().getId()));
                        c.oTb.i(11098, Integer.valueOf(3600), Long.valueOf(currentTimeMillis));
                        c.oTb.a(99, 214, 1, false);
                        af.f(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 gKh;

                            {
                                this.gKh = r1;
                            }

                            public final void run() {
                                w.i("MicroMsg.NotifyReceiver", "summerboot startupDone do delay notify task");
                                this.gKh.gKg.l(intent);
                                c.oTb.a(99, 215, 1, false);
                            }
                        }, 500);
                    }

                    public final void ak(boolean z) {
                    }
                };
                com.tencent.mm.kernel.h.vJ().a(this.gKd);
                c.oTb.a(99, 213, 1, false);
                int i = -1;
            }
            if (i < 0) {
                w.e("MicroMsg.NotifyReceiver", "summerboot status %s", Integer.valueOf(-1));
                return;
            }
            l(intent);
        }

        public void onCreate() {
            super.onCreate();
            if (VERSION.SDK_INT < 24 && !com.tencent.mm.compatible.util.h.sf()) {
                if (VERSION.SDK_INT < 18) {
                    startForeground(-1212, new Notification());
                } else if (getSharedPreferences("system_config_prefs", 4).getBoolean("set_service", false)) {
                    startForeground(-1212, new Notification());
                    startService(new Intent(this, InnerService.class));
                    w.i("MicroMsg.NotifyReceiver", "set service for mm.");
                }
                new ae().postDelayed(new Runnable(this) {
                    final /* synthetic */ NotifyService gKg;

                    {
                        this.gKg = r1;
                    }

                    public final void run() {
                        this.gKg.stopForeground(true);
                    }
                }, ab.bIY().getLong("mm_stop_service_time", 86400000));
            }
        }

        public static void cT(String str) {
            synchronized (NotifyReceiver.gJW) {
                if (NotifyReceiver.gJG == null) {
                    NotifyReceiver.gJG = new WakerLock(ab.getContext());
                }
            }
            NotifyReceiver.gJG.lock(5000, str);
        }

        private static void s(Context context, String str) {
            synchronized (NotifyReceiver.gJW) {
                if (NotifyReceiver.gJG == null) {
                    NotifyReceiver.gJG = new WakerLock(context);
                }
            }
            NotifyReceiver.gJG.lock(14000, str);
        }

        private static void t(Context context, String str) {
            synchronized (NotifyReceiver.gJX) {
                if (NotifyReceiver.gJT == null) {
                    NotifyReceiver.gJT = new WakerLock(context);
                }
            }
            NotifyReceiver.gJT.lock(60000, str);
        }
    }

    public static class a implements e {
        public static long gKa = 0;

        public final void a(int i, int i2, String str, k kVar) {
            long j;
            long hashCode = (long) kVar.hashCode();
            if (kVar.getType() == 268369922) {
                j = ((com.tencent.mm.modelmulti.h) kVar).hKi;
            } else {
                j = hashCode;
            }
            try {
                NotifyReceiver.gJV.lock();
                String str2 = "MicroMsg.NotifyReceiver";
                String str3 = "NotifyReceiver onSceneEnd type:%d syncHash: %d hashInMemo: %b isLocking: %b";
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(kVar.getType());
                objArr[1] = Long.valueOf(j);
                objArr[2] = Boolean.valueOf(NotifyReceiver.gJU.contains(Long.valueOf(j)));
                objArr[3] = Boolean.valueOf(NotifyReceiver.gJT != null ? NotifyReceiver.gJT.isLocking() : false);
                w.i(str2, str3, objArr);
                NotifyReceiver.gJU.remove(Long.valueOf(j));
                if (NotifyReceiver.gJU.isEmpty()) {
                    synchronized (NotifyReceiver.gJX) {
                        if (NotifyReceiver.gJT != null) {
                            NotifyReceiver.gJT.unLock();
                        }
                    }
                    w.i("MicroMsg.NotifyReceiver", "all scene done, unlock wakelock.");
                } else {
                    w.i("MicroMsg.NotifyReceiver", "rest %d scene undone, keep wakelock.", Integer.valueOf(NotifyReceiver.gJU.size()));
                }
                switch (kVar.getType()) {
                    case 138:
                        if (com.tencent.mm.kernel.h.vG().uV()) {
                            Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                                final /* synthetic */ a gKb;

                                {
                                    this.gKb = r1;
                                }

                                public final boolean queueIdle() {
                                    a aVar = this.gKb;
                                    com.tencent.mm.kernel.h.vJ();
                                    com.tencent.mm.kernel.h.vL().D(new Runnable(aVar) {
                                        final /* synthetic */ a gKb;

                                        {
                                            this.gKb = r1;
                                        }

                                        public final void run() {
                                            if (com.tencent.mm.kernel.h.vG().uV()) {
                                                int i;
                                                if (bg.f((Integer) com.tencent.mm.kernel.h.vI().vr().get(15, null)) == 0) {
                                                    i = 1;
                                                } else {
                                                    i = 0;
                                                }
                                                if (i != 0) {
                                                    w.e("MicroMsg.NotifyReceiver", "not init finish , do not post sync task");
                                                    return;
                                                }
                                                long Nz = bg.Nz();
                                                if (Nz - a.gKa <= 0 || Nz - a.gKa >= 10000) {
                                                    a.gKa = Nz;
                                                    w.i("MicroMsg.NotifyReceiver", "begin post sync task");
                                                    Nz = bg.NA();
                                                    com.tencent.mm.sdk.b.a.urY.m(new lc());
                                                    w.i("MicroMsg.NotifyReceiver", "end post sync task, cost=%d, Idle done", Long.valueOf(bg.aB(Nz)));
                                                    this.gKb.C(3000);
                                                    return;
                                                }
                                                w.d("MicroMsg.NotifyReceiver", "sync task limit now - last : %d", Long.valueOf(Nz - a.gKa));
                                            }
                                        }

                                        public final String toString() {
                                            return super.toString() + "|doPostSyncTask";
                                        }
                                    });
                                    return false;
                                }
                            });
                            if (i == 0 && i2 == 0 && com.tencent.mm.u.a.wI()) {
                                try {
                                    com.tencent.mm.kernel.h.vJ();
                                    com.tencent.mm.u.a aVar = com.tencent.mm.kernel.h.vG().gXj;
                                    if (aVar.hkH > -1) {
                                        aVar.hkH++;
                                    }
                                    w.i("MicroMsg.AccInfoCacheInWorker", "countNormalCgi :%s ", Long.valueOf(aVar.hkH));
                                    if (aVar.hkH == 2 || aVar.hkH == 5) {
                                        c.oTb.a(226, aVar.hkH == 2 ? 37 : 38, 1, false);
                                        c.oTb.i(11098, Integer.valueOf(MMBitmapFactory.ERROR_PNG_BUG_DETECTED_BEGIN), Long.valueOf(aVar.hkH));
                                        break;
                                    }
                                } catch (Throwable th) {
                                    w.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", bg.g(th));
                                    break;
                                }
                            }
                        }
                        break;
                }
                C(7000);
            } finally {
                try {
                    NotifyReceiver.gJV.unlock();
                } catch (Exception e) {
                }
            }
        }

        public final void C(long j) {
            if (z.MH().getBoolean("is_in_notify_mode", false)) {
                new ae(Looper.myLooper()).postDelayed(new Runnable(this) {
                    final /* synthetic */ a gKb;

                    {
                        this.gKb = r1;
                    }

                    public final void run() {
                        w.i("MicroMsg.NotifyReceiver", "checkKillProcess, canKillProcess :%b", Boolean.valueOf(NotifyReceiver.gJZ));
                        synchronized (NotifyReceiver.gJW) {
                            if (NotifyReceiver.gJG != null) {
                                NotifyReceiver.gJG.unLock();
                            }
                            NotifyReceiver.gJG = null;
                        }
                        if (NotifyReceiver.gJZ) {
                            PluginZero pluginZero = (PluginZero) com.tencent.mm.kernel.h.j(PluginZero.class);
                            if (pluginZero.sAS != null) {
                                pluginZero.sAS.acP();
                            }
                            w.bIQ();
                            Process.killProcess(Process.myPid());
                        }
                    }
                }, j);
            }
        }
    }

    public static void pW() {
        w.i("MicroMsg.NotifyReceiver", "markUIShow");
        gJZ = false;
        z.MH().edit().putBoolean("is_in_notify_mode", false).commit();
    }

    public static void pX() {
        com.tencent.mm.kernel.h.vd().b(138, gJY);
        com.tencent.mm.kernel.h.vd().b(39, gJY);
        com.tencent.mm.kernel.h.vd().b(268369922, gJY);
        if (gJY == null) {
            gJY = new a();
        }
        com.tencent.mm.kernel.h.vd().a(138, gJY);
        com.tencent.mm.kernel.h.vd().a(39, gJY);
        com.tencent.mm.kernel.h.vd().a(268369922, gJY);
    }

    public void onReceive(Context context, Intent intent) {
        w.i("MicroMsg.NotifyReceiver", "onReceive intent :%s", intent);
        if (intent != null) {
            if (com.tencent.mm.kernel.k.aK(context)) {
                w.i("MicroMsg.NotifyReceiver", "fully exited, no need to start service");
                return;
            }
            Intent intent2 = new Intent(context, NotifyService.class);
            if (intent.getBooleanExtra("intent_from_shoot_key", false)) {
                intent2.putExtra("notify_option_type", 3);
            }
            intent2.putExtras(intent);
            context.startService(intent2);
        }
    }
}
