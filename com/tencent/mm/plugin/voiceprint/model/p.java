package com.tencent.mm.plugin.voiceprint.model;

import android.os.Message;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class p implements com.tencent.mm.compatible.b.e.a {
    public static int fBC = 100;
    public String fyF = "";
    public k fyH = null;
    public com.tencent.mm.compatible.util.b ict;
    private int jVa = 0;
    public long lNF = 0;
    public boolean qTm = false;
    public int qTp = 0;
    public b rcQ;
    public String rcR;
    public boolean rcS = false;
    public a rcT = null;

    public interface a {
        void boC();
    }

    private final class b extends Thread {
        ae handler;
        final /* synthetic */ p rcU;

        public b(final p pVar) {
            this.rcU = pVar;
            this.handler = new ae(this) {
                final /* synthetic */ b rcW;

                public final void handleMessage(Message message) {
                    if (this.rcW.rcU.qTp > 0) {
                        this.rcW.rcU.qTp = 2;
                    }
                }
            };
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r7 = this;
            r6 = 0;
            r0 = r7.rcU;
            r0 = r0.fyH;
            if (r0 != 0) goto L_0x0011;
        L_0x0007:
            r0 = "MicroMsg.VoicePrintRecoder";
            r1 = "Stop Record Failed recorder == null";
            com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        L_0x0010:
            return;
        L_0x0011:
            r1 = r7.rcU;
            monitor-enter(r1);
            r0 = r7.rcU;	 Catch:{ all -> 0x0096 }
            r0 = r0.fyF;	 Catch:{ all -> 0x0096 }
            r2 = 1;
            r0 = com.tencent.mm.plugin.voiceprint.model.m.at(r0, r2);	 Catch:{ all -> 0x0096 }
            r2 = "MicroMsg.VoicePrintRecoder";
            r3 = "fullPathName %s";
            r4 = 1;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0096 }
            r5 = 0;
            r4[r5] = r0;	 Catch:{ all -> 0x0096 }
            com.tencent.mm.sdk.platformtools.w.d(r2, r3, r4);	 Catch:{ all -> 0x0096 }
            r2 = r7.rcU;	 Catch:{ all -> 0x0096 }
            r2.rcR = r0;	 Catch:{ all -> 0x0096 }
            r2 = r7.rcU;	 Catch:{ all -> 0x0096 }
            r2 = r2.ict;	 Catch:{ all -> 0x0096 }
            if (r2 == 0) goto L_0x003d;
        L_0x0036:
            r2 = r7.rcU;	 Catch:{ all -> 0x0096 }
            r2 = r2.ict;	 Catch:{ all -> 0x0096 }
            r2.requestFocus();	 Catch:{ all -> 0x0096 }
        L_0x003d:
            r2 = r7.rcU;	 Catch:{ all -> 0x0096 }
            r2 = r2.fyH;	 Catch:{ all -> 0x0096 }
            r0 = r2.bw(r0);	 Catch:{ all -> 0x0096 }
            if (r0 != 0) goto L_0x0099;
        L_0x0047:
            r0 = r7.rcU;	 Catch:{ all -> 0x0096 }
            r2 = 0;
            r0.fyF = r2;	 Catch:{ all -> 0x0096 }
            r0 = "MicroMsg.VoicePrintRecoder";
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0096 }
            r3 = "Thread Start Record  Error fileName[";
            r2.<init>(r3);	 Catch:{ all -> 0x0096 }
            r3 = r7.rcU;	 Catch:{ all -> 0x0096 }
            r3 = r3.fyF;	 Catch:{ all -> 0x0096 }
            r2 = r2.append(r3);	 Catch:{ all -> 0x0096 }
            r3 = "]";
            r2 = r2.append(r3);	 Catch:{ all -> 0x0096 }
            r2 = r2.toString();	 Catch:{ all -> 0x0096 }
            com.tencent.mm.sdk.platformtools.w.d(r0, r2);	 Catch:{ all -> 0x0096 }
            r0 = r7.rcU;	 Catch:{ all -> 0x0096 }
            r0 = r0.fyH;	 Catch:{ all -> 0x0096 }
            r0.oX();	 Catch:{ all -> 0x0096 }
            r0 = r7.rcU;	 Catch:{ all -> 0x0096 }
            r2 = 0;
            r0.fyH = r2;	 Catch:{ all -> 0x0096 }
            r0 = r7.rcU;	 Catch:{ all -> 0x0096 }
            r0 = r0.ict;	 Catch:{ all -> 0x0096 }
            if (r0 == 0) goto L_0x0086;
        L_0x007f:
            r0 = r7.rcU;	 Catch:{ all -> 0x0096 }
            r0 = r0.ict;	 Catch:{ all -> 0x0096 }
            r0.rY();	 Catch:{ all -> 0x0096 }
        L_0x0086:
            r0 = r7.rcU;	 Catch:{ all -> 0x0096 }
            r0 = r0.rcT;	 Catch:{ all -> 0x0096 }
            if (r0 == 0) goto L_0x0093;
        L_0x008c:
            r0 = r7.rcU;	 Catch:{ all -> 0x0096 }
            r0 = r0.rcT;	 Catch:{ all -> 0x0096 }
            r0.boC();	 Catch:{ all -> 0x0096 }
        L_0x0093:
            monitor-exit(r1);	 Catch:{ all -> 0x0096 }
            goto L_0x0010;
        L_0x0096:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0096 }
            throw r0;
        L_0x0099:
            r0 = r7.rcU;	 Catch:{ all -> 0x0096 }
            r2 = com.tencent.mm.sdk.platformtools.bg.NA();	 Catch:{ all -> 0x0096 }
            r0.lNF = r2;	 Catch:{ all -> 0x0096 }
            r0 = "MicroMsg.VoicePrintRecoder";
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0096 }
            r3 = "Thread Started Record fileName[";
            r2.<init>(r3);	 Catch:{ all -> 0x0096 }
            r3 = r7.rcU;	 Catch:{ all -> 0x0096 }
            r3 = r3.fyF;	 Catch:{ all -> 0x0096 }
            r2 = r2.append(r3);	 Catch:{ all -> 0x0096 }
            r3 = "]";
            r2 = r2.append(r3);	 Catch:{ all -> 0x0096 }
            r2 = r2.toString();	 Catch:{ all -> 0x0096 }
            com.tencent.mm.sdk.platformtools.w.d(r0, r2);	 Catch:{ all -> 0x0096 }
            monitor-exit(r1);	 Catch:{ all -> 0x0096 }
            r0 = r7.handler;
            r2 = 1;
            r0.sendEmptyMessageDelayed(r6, r2);
            goto L_0x0010;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.voiceprint.model.p.b.run():void");
        }
    }

    public final void cW(int i) {
        w.d("MicroMsg.VoicePrintRecoder", " Recorder onBluetoothHeadsetStateChange :" + i);
        if (!this.qTm) {
            this.qTm = true;
            ap.yZ().b(this);
            this.fyH = new k();
            this.rcQ = new b(this);
            this.rcQ.start();
            this.rcS = false;
            this.qTp = 1;
        }
    }

    public final boolean pd() {
        long j = 0;
        ap.yZ().qH();
        this.rcS = false;
        w.d("MicroMsg.VoicePrintRecoder", "stop Record :" + this.fyF);
        synchronized (this) {
            w.d("MicroMsg.VoicePrintRecoder", "stop synchronized Record :" + this.fyF);
            if (this.fyH != null) {
                this.fyH.oX();
            }
        }
        if (this.qTp != 2) {
            this.fyF = null;
            this.rcS = false;
            w.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fyF);
        } else {
            if (this.lNF > 0) {
                j = bg.aB(this.lNF);
            }
            this.jVa = (int) j;
            if (this.jVa < 1000) {
                w.d("MicroMsg.VoicePrintRecoder", "Stop " + this.fyF + " by voiceLen: " + this.jVa);
                this.fyF = "";
                this.rcS = false;
            } else {
                this.rcS = true;
                w.d("MicroMsg.VoicePrintRecoder", "Stop file success: " + this.fyF);
            }
            this.fyF = "";
        }
        this.qTp = -1;
        w.d("MicroMsg.VoicePrintRecoder", "bLongEnough " + this.rcS);
        if (this.ict != null) {
            this.ict.rY();
        }
        return this.rcS;
    }
}
