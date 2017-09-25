package com.tencent.mm.c.b;

import android.media.AudioRecord;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopRecordVoice;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantLock;

public final class e extends f {
    private boolean fAA = false;
    private boolean fAB = false;
    public AudioRecord fAd;
    public int fAo;
    public boolean fAp = false;
    private int fAs = 12800;
    private b fAt = new b(this);
    public com.tencent.mm.compatible.b.a fAu = null;
    public com.tencent.mm.c.b.c.a fAv;
    private final Object fAw = new Object();
    public final byte[] fAx = new byte[0];
    public final Object fAy = new Object();
    private Timer fAz = null;
    public boolean fzP;
    public int mStatus = 0;

    class a extends TimerTask {
        private int fAC = (this.fAF.fAo * 2);
        private int fAD = this.fAF.fAo;
        byte[] fAE = new byte[this.fAC];
        final /* synthetic */ e fAF;

        a(e eVar) {
            this.fAF = eVar;
        }

        public final void run() {
            if (!this.fAF.fAG) {
                int pi = (int) (0.8d * ((double) this.fAF.pi()));
                if (pi < this.fAF.fAo * 8) {
                    pi = this.fAF.fAo * 8;
                }
                if (this.fAF.pj() > pi) {
                    pi = 8;
                } else {
                    pi = 1;
                }
                for (int i = 0; i < pi; i++) {
                    int g = this.fAF.g(this.fAE, this.fAD);
                    if (this.fAF.fAv != null && g == 0) {
                        this.fAF.fAv.d(this.fAE, this.fAD);
                    }
                }
            }
        }
    }

    final class b implements Runnable {
        final /* synthetic */ e fAF;

        b(e eVar) {
            this.fAF = eVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r11 = this;
            r2 = -1;
            r10 = 1;
            r9 = 2;
            r3 = 0;
            r0 = "MicroMsg.RecordModeAsyncRead";
            r1 = "RecordThread started. frameSize:%d";
            r4 = new java.lang.Object[r10];
            r5 = r11.fAF;
            r5 = r5.fAo;
            r5 = java.lang.Integer.valueOf(r5);
            r4[r3] = r5;
            com.tencent.mm.sdk.platformtools.w.i(r0, r1, r4);
            r0 = -123456789; // 0xfffffffff8a432eb float:-2.6642794E34 double:NaN;
            r1 = r11.fAF;
            r1 = r1.fzT;
            if (r0 == r1) goto L_0x0043;
        L_0x0022:
            r0 = "MicroMsg.RecordModeAsyncRead";
            r1 = new java.lang.StringBuilder;
            r4 = "set priority to ";
            r1.<init>(r4);
            r4 = r11.fAF;
            r4 = r4.fzT;
            r1 = r1.append(r4);
            r1 = r1.toString();
            com.tencent.mm.sdk.platformtools.w.i(r0, r1);
            r0 = r11.fAF;
            r0 = r0.fzT;
            android.os.Process.setThreadPriority(r0);
        L_0x0043:
            r0 = r11.fAF;
            r1 = r0.fAy;
            monitor-enter(r1);
            r0 = r11.fAF;	 Catch:{ all -> 0x009f }
            r0 = r0.mStatus;	 Catch:{ all -> 0x009f }
            if (r10 == r0) goto L_0x006a;
        L_0x004e:
            r0 = "MicroMsg.RecordModeAsyncRead";
            r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009f }
            r3 = "status is not inited, now status: ";
            r2.<init>(r3);	 Catch:{ all -> 0x009f }
            r3 = r11.fAF;	 Catch:{ all -> 0x009f }
            r3 = r3.mStatus;	 Catch:{ all -> 0x009f }
            r2 = r2.append(r3);	 Catch:{ all -> 0x009f }
            r2 = r2.toString();	 Catch:{ all -> 0x009f }
            com.tencent.mm.sdk.platformtools.w.e(r0, r2);	 Catch:{ all -> 0x009f }
            monitor-exit(r1);	 Catch:{ all -> 0x009f }
        L_0x0069:
            return;
        L_0x006a:
            r0 = r11.fAF;	 Catch:{ all -> 0x009f }
            r4 = 2;
            r0.mStatus = r4;	 Catch:{ all -> 0x009f }
            monitor-exit(r1);	 Catch:{ all -> 0x009f }
            r0 = r11.fAF;
            r0 = r0.fAo;
            r0 = new byte[r0];
        L_0x0076:
            r1 = r11.fAF;
            r1 = r1.mStatus;
            if (r9 != r1) goto L_0x0095;
        L_0x007c:
            r1 = r11.fAF;
            r1 = r1.fAx;
            monitor-enter(r1);
            r4 = r11.fAF;	 Catch:{ all -> 0x00c1 }
            r4 = r4.fAG;	 Catch:{ all -> 0x00c1 }
            if (r4 == 0) goto L_0x00a2;
        L_0x0087:
            r4 = r11.fAF;	 Catch:{ InterruptedException -> 0x0245 }
            r4 = r4.fAx;	 Catch:{ InterruptedException -> 0x0245 }
            r4.wait();	 Catch:{ InterruptedException -> 0x0245 }
        L_0x008e:
            r4 = r11.fAF;	 Catch:{ all -> 0x00c1 }
            r4 = r4.mStatus;	 Catch:{ all -> 0x00c1 }
            if (r9 == r4) goto L_0x00a2;
        L_0x0094:
            monitor-exit(r1);	 Catch:{ all -> 0x00c1 }
        L_0x0095:
            r0 = "MicroMsg.RecordModeAsyncRead";
            r1 = "RecordThread exited.";
            com.tencent.mm.sdk.platformtools.w.i(r0, r1);
            goto L_0x0069;
        L_0x009f:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x009f }
            throw r0;
        L_0x00a2:
            monitor-exit(r1);	 Catch:{ all -> 0x00c1 }
            r1 = r11.fAF;
            r1 = r1.fAd;
            if (r1 != 0) goto L_0x00c4;
        L_0x00a9:
            r0 = "MicroMsg.RecordModeAsyncRead";
            r1 = "mAudioRecord is null, so stop record.";
            com.tencent.mm.sdk.platformtools.w.i(r0, r1);
            r0 = r11.fAF;
            r1 = r0.fAy;
            monitor-enter(r1);
            r0 = r11.fAF;	 Catch:{ all -> 0x00be }
            r2 = 3;
            r0.mStatus = r2;	 Catch:{ all -> 0x00be }
            monitor-exit(r1);	 Catch:{ all -> 0x00be }
            goto L_0x0095;
        L_0x00be:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00be }
            throw r0;
        L_0x00c1:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x00c1 }
            throw r0;
        L_0x00c4:
            r1 = r11.fAF;
            r1 = r1.fzP;
            if (r1 == 0) goto L_0x00d0;
        L_0x00ca:
            r0 = r11.fAF;
            r0 = r0.fAo;
            r0 = new byte[r0];
        L_0x00d0:
            r1 = r11.fAF;
            r4 = r11.fAF;
            r4 = r4.fAH;
            r4 = r4 + 1;
            r1.fAH = r4;
            r1 = new com.tencent.mm.compatible.util.g$a;
            r1.<init>();
            r1 = r11.fAF;
            r1 = r1.fAd;
            r4 = r11.fAF;
            r4 = r4.fAo;
            r1 = r1.read(r0, r3, r4);
            r4 = r11.fAF;
            r4 = r4.mStatus;
            if (r9 != r4) goto L_0x0095;
        L_0x00f1:
            r4 = r11.fAF;
            r4 = r4.fAk;
            if (r4 == 0) goto L_0x00fe;
        L_0x00f7:
            r4 = r11.fAF;
            r4 = r4.fAk;
            r4.c(r1, r0);
        L_0x00fe:
            r4 = r11.fAF;
            r4 = r4.fAo;
            if (r4 == r1) goto L_0x011a;
        L_0x0104:
            r4 = "MicroMsg.RecordModeAsyncRead";
            r5 = new java.lang.StringBuilder;
            r6 = "read len ";
            r5.<init>(r6);
            r5 = r5.append(r1);
            r5 = r5.toString();
            com.tencent.mm.sdk.platformtools.w.i(r4, r5);
        L_0x011a:
            r4 = r11.fAF;
            r4 = r4.fAo;
            if (r1 >= r4) goto L_0x012e;
        L_0x0120:
            r4 = "MicroMsg.RecordModeAsyncRead";
            r5 = "read too fast? sleep 10 ms";
            com.tencent.mm.sdk.platformtools.w.i(r4, r5);
            r4 = 10;
            java.lang.Thread.sleep(r4);	 Catch:{ InterruptedException -> 0x0242 }
        L_0x012e:
            r4 = r11.fAF;
            r4 = r4.fAv;
            if (r4 == 0) goto L_0x0076;
        L_0x0134:
            if (r1 <= 0) goto L_0x0076;
        L_0x0136:
            r4 = r0.length;
            if (r1 <= r4) goto L_0x013a;
        L_0x0139:
            r1 = r0.length;
        L_0x013a:
            r4 = r11.fAF;
            r4 = r4.fAu;
            if (r4 == 0) goto L_0x022a;
        L_0x0140:
            r4 = r11.fAF;
            r4 = r4.fAp;
            if (r4 == 0) goto L_0x0149;
        L_0x0146:
            java.util.Arrays.fill(r0, r3, r1, r3);
        L_0x0149:
            r4 = r11.fAF;
            r5 = r4.fAu;
            if (r1 <= 0) goto L_0x0162;
        L_0x014f:
            r4 = r5.gNg;
            if (r4 == 0) goto L_0x0158;
        L_0x0153:
            r4 = r5.gNh;
            r4.lock();
        L_0x0158:
            r4 = r5.gNe;
            r6 = r5.gNf;
            if (r4 != r6) goto L_0x0186;
        L_0x015e:
            r4 = r5.gNb;
        L_0x0160:
            if (r1 <= r4) goto L_0x01c0;
        L_0x0162:
            r1 = r2;
        L_0x0163:
            if (r1 == 0) goto L_0x0076;
        L_0x0165:
            r4 = "MicroMsg.RecordModeAsyncRead";
            r5 = "WriteToBuffer Failed, ret:%d AudioBuffer length: %d";
            r6 = new java.lang.Object[r9];
            r1 = java.lang.Integer.valueOf(r1);
            r6[r3] = r1;
            r1 = r11.fAF;
            r1 = r1.fAu;
            r1 = r1.qC();
            r1 = java.lang.Integer.valueOf(r1);
            r6[r10] = r1;
            com.tencent.mm.sdk.platformtools.w.e(r4, r5, r6);
            goto L_0x0076;
        L_0x0186:
            r4 = r5.gNf;
            r4 = r4 + 1;
            r6 = r5.gNb;
            r4 = r4 % r6;
            r6 = r5.gNe;
            if (r4 != r6) goto L_0x0193;
        L_0x0191:
            r4 = r3;
            goto L_0x0160;
        L_0x0193:
            r4 = r5.gNe;
            r6 = r5.gNf;
            if (r4 >= r6) goto L_0x01af;
        L_0x0199:
            r4 = r5.gNf;
            r6 = r5.gNe;
            r4 = r4 - r6;
            r5.gNc = r4;
        L_0x01a0:
            r4 = r5.gNg;
            if (r4 == 0) goto L_0x01a9;
        L_0x01a4:
            r4 = r5.gNh;
            r4.unlock();
        L_0x01a9:
            r4 = r5.gNb;
            r6 = r5.gNc;
            r4 = r4 - r6;
            goto L_0x0160;
        L_0x01af:
            r4 = r5.gNe;
            r6 = r5.gNf;
            if (r4 <= r6) goto L_0x01a0;
        L_0x01b5:
            r4 = r5.gNf;
            r6 = r5.gNb;
            r4 = r4 + r6;
            r6 = r5.gNe;
            r4 = r4 - r6;
            r5.gNc = r4;
            goto L_0x01a0;
        L_0x01c0:
            r4 = r5.gNf;
            r4 = r4 + r1;
            r6 = r5.gNb;
            r4 = r4 % r6;
            r6 = r5.gNe;
            if (r4 != r6) goto L_0x01cc;
        L_0x01ca:
            r1 = r2;
            goto L_0x0163;
        L_0x01cc:
            r4 = r5.gNg;
            if (r4 == 0) goto L_0x01d5;
        L_0x01d0:
            r4 = r5.gNh;
            r4.lock();
        L_0x01d5:
            r4 = r5.gNe;
            r6 = r5.gNf;
            if (r4 >= r6) goto L_0x021a;
        L_0x01db:
            r4 = r5.gNb;
            r6 = r5.gNf;
            r4 = r4 - r6;
            if (r1 <= r4) goto L_0x021a;
        L_0x01e2:
            r4 = r5.gNd;
            r6 = r5.gNf;
            r7 = r5.gNb;
            r8 = r5.gNf;
            r7 = r7 - r8;
            java.lang.System.arraycopy(r0, r3, r4, r6, r7);
            r4 = r5.gNb;
            r6 = r5.gNf;
            r4 = r4 - r6;
            r6 = r5.gNd;
            r7 = r5.gNb;
            r8 = r5.gNf;
            r7 = r7 - r8;
            r7 = r1 - r7;
            java.lang.System.arraycopy(r0, r4, r6, r3, r7);
            r4 = r5.gNb;
            r6 = r5.gNf;
            r4 = r4 - r6;
            r1 = r1 - r4;
            r5.gNf = r1;
            r1 = r5.gNf;
            r4 = r5.gNb;
            r1 = r1 % r4;
            r5.gNf = r1;
        L_0x020e:
            r1 = r5.gNg;
            if (r1 == 0) goto L_0x0217;
        L_0x0212:
            r1 = r5.gNh;
            r1.unlock();
        L_0x0217:
            r1 = r3;
            goto L_0x0163;
        L_0x021a:
            r4 = r5.gNd;
            r6 = r5.gNf;
            java.lang.System.arraycopy(r0, r3, r4, r6, r1);
            r4 = r5.gNf;
            r1 = r1 + r4;
            r4 = r5.gNb;
            r1 = r1 % r4;
            r5.gNf = r1;
            goto L_0x020e;
        L_0x022a:
            r4 = r11.fAF;
            r4 = r4.fAv;
            if (r4 == 0) goto L_0x0076;
        L_0x0230:
            r4 = r11.fAF;
            r4 = r4.fAp;
            if (r4 == 0) goto L_0x0239;
        L_0x0236:
            java.util.Arrays.fill(r0, r3, r1, r3);
        L_0x0239:
            r4 = r11.fAF;
            r4 = r4.fAv;
            r4.d(r0, r1);
            goto L_0x0076;
        L_0x0242:
            r4 = move-exception;
            goto L_0x012e;
        L_0x0245:
            r4 = move-exception;
            goto L_0x008e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.c.b.e.b.run():void");
        }
    }

    public e(AudioRecord audioRecord, boolean z, int i, com.tencent.mm.c.b.c.a aVar, boolean z2) {
        this.fAd = audioRecord;
        this.fzP = z;
        this.fAo = i;
        this.fAv = aVar;
        this.fAB = z2;
    }

    public final boolean pf() {
        boolean z = true;
        w.i("MicroMsg.RecordModeAsyncRead", JsApiStartRecordVoice.NAME);
        synchronized (this.fAy) {
            this.mStatus = 1;
        }
        com.tencent.mm.sdk.f.e.b(this.fAt, "RecordModeAsyncRead_record", 10);
        if (true == this.fAB) {
            boolean z2;
            this.fAu = new com.tencent.mm.compatible.b.a();
            if (this.fAu == null) {
                w.e("MicroMsg.RecordModeAsyncRead", "new m_audioBuffer error ");
                z2 = false;
            } else {
                this.fAs = this.fAo * 20;
                w.i("MicroMsg.RecordModeAsyncRead", "audioBuffer init mAudioBufferSize: " + this.fAs);
                com.tencent.mm.compatible.b.a aVar = this.fAu;
                int i = this.fAs;
                if (i <= 0) {
                    z2 = true;
                } else {
                    aVar.gNd = new byte[i];
                    if (aVar.gNd == null) {
                        z2 = true;
                    } else {
                        aVar.gNb = i;
                        if (aVar.gNg) {
                            aVar.gNh = new ReentrantLock();
                        }
                        z2 = false;
                    }
                }
                if (z2) {
                    w.e("MicroMsg.RecordModeAsyncRead", new StringBuilder("audioBuffer init failed, error code = -1").toString());
                    z2 = false;
                } else {
                    z2 = true;
                }
            }
            if (z2) {
                if (this.fAA || this.fAz != null) {
                    w.w("MicroMsg.RecordModeAsyncRead", "Timer has been created or, timer has been started, " + this.fAA);
                } else {
                    this.fAz = new Timer();
                    if (this.fAz != null) {
                        z = false;
                    }
                }
                if (z) {
                    w.e("MicroMsg.RecordModeAsyncRead", new StringBuilder("InitAudioRecTimer failed, error code = -1").toString());
                    return false;
                }
                this.fAz.scheduleAtFixedRate(new a(this), 60, 20);
                this.fAA = true;
            } else {
                w.e("MicroMsg.RecordModeAsyncRead", "initAudioBuffer failed");
                return false;
            }
        }
        return true;
    }

    public final void oP() {
        w.i("MicroMsg.RecordModeAsyncRead", JsApiStopRecordVoice.NAME);
        synchronized (this.fAy) {
            this.mStatus = 3;
        }
        synchronized (this.fAx) {
            this.fAx.notify();
        }
        com.tencent.mm.sdk.f.e.O(this.fAt);
        try {
            com.tencent.mm.sdk.f.e.Q(this.fAt);
        } catch (InterruptedException e) {
        }
        if (this.fAu != null) {
            if (this.fAz != null) {
                this.fAz.cancel();
                this.fAz = null;
            }
            com.tencent.mm.compatible.b.a aVar = this.fAu;
            aVar.gNb = 0;
            aVar.gNc = 0;
            aVar.gNe = 0;
            aVar.gNf = 0;
            aVar.gNd = null;
            synchronized (this.fAw) {
                this.fAu = null;
                this.fAv = null;
            }
            this.fAA = false;
            this.fAu = null;
        }
    }

    public final int pi() {
        synchronized (this.fAw) {
            if (this.fAu != null) {
                int i = this.fAu.gNb;
                return i;
            }
            return -1;
        }
    }

    public final int pj() {
        synchronized (this.fAw) {
            if (this.fAu != null) {
                int qC = this.fAu.qC();
                return qC;
            }
            return -1;
        }
    }

    public final int g(byte[] bArr, int i) {
        int i2 = -1;
        synchronized (this.fAw) {
            if (this.fAu != null) {
                com.tencent.mm.compatible.b.a aVar = this.fAu;
                if (i > 0 && i <= aVar.qC() && bArr != null && aVar.gNe != aVar.gNf) {
                    if (aVar.gNg) {
                        aVar.gNh.lock();
                    }
                    if (aVar.gNe < aVar.gNf) {
                        System.arraycopy(aVar.gNd, aVar.gNe, bArr, 0, i);
                        aVar.gNe += i;
                    } else if (i <= aVar.gNb - aVar.gNe) {
                        System.arraycopy(aVar.gNd, aVar.gNe, bArr, 0, i);
                        aVar.gNe += i;
                    } else {
                        System.arraycopy(aVar.gNd, aVar.gNe, bArr, 0, aVar.gNb - aVar.gNe);
                        System.arraycopy(aVar.gNd, 0, bArr, aVar.gNb - aVar.gNe, i - (aVar.gNb - aVar.gNe));
                        aVar.gNe = i - (aVar.gNb - aVar.gNe);
                    }
                    if (aVar.gNg) {
                        aVar.gNh.unlock();
                    }
                    i2 = 0;
                }
            }
        }
        return i2;
    }

    public final void au(boolean z) {
        this.fAp = z;
    }
}
