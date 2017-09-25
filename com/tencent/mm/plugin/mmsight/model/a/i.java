package com.tencent.mm.plugin.mmsight.model.a;

import android.media.MediaRecorder;
import android.os.Message;
import com.tencent.mm.c.b.c;
import com.tencent.mm.plugin.mmsight.model.a.c.a;
import com.tencent.mm.plugin.mmsight.model.a.c.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;

public final class i implements c {
    private int audioSampleRate;
    private int hzL;
    public a nEk;
    private ae nEm = new ae(this) {
        final /* synthetic */ i nEz;

        {
            this.nEz = r1;
        }

        public final void handleMessage(Message message) {
            if (this.nEz.nEk != null) {
                this.nEz.nEk.aLb();
                this.nEz.nEk = null;
            }
        }
    };
    private MediaRecorder nEx;
    private boolean nEy = false;

    public final int a(com.tencent.mm.plugin.mmsight.model.a.c.a r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r3 = 1;
        r0 = 0;
        r1 = "MicroMsg.MMSightAACMediaRecorder";
        r2 = "start, onPcmReady: %s";
        r3 = new java.lang.Object[r3];
        r3[r0] = r8;
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
        r7.nEk = r8;
        r1 = r7.nEx;	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        if (r1 == 0) goto L_0x001e;	 Catch:{ Exception -> 0x0024, all -> 0x003f }
    L_0x0015:
        r1 = r7.nEy;	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        if (r1 != 0) goto L_0x001e;	 Catch:{ Exception -> 0x0024, all -> 0x003f }
    L_0x0019:
        r1 = r7.nEx;	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        r1.start();	 Catch:{ Exception -> 0x0024, all -> 0x003f }
    L_0x001e:
        r1 = r7.nEm;
        r1.sendEmptyMessage(r0);
    L_0x0023:
        return r0;
    L_0x0024:
        r1 = move-exception;
        r2 = "MicroMsg.MMSightAACMediaRecorder";	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        r3 = "start record aac.mp4 error:%s";	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        r4 = 1;	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        r5 = 0;	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        r6 = r1.getMessage();	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        r4[r5] = r6;	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r2, r1, r3, r4);	 Catch:{ Exception -> 0x0024, all -> 0x003f }
        r1 = r7.nEm;
        r1.sendEmptyMessage(r0);
        r0 = -1;
        goto L_0x0023;
    L_0x003f:
        r1 = move-exception;
        r2 = r7.nEm;
        r2.sendEmptyMessage(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.model.a.i.a(com.tencent.mm.plugin.mmsight.model.a.c$a):int");
    }

    public i(int i, int i2) {
        this.audioSampleRate = i;
        this.hzL = i2;
        w.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder, sampleRate: %s, bitrate: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final int ad(int i, String str) {
        w.i("MicroMsg.MMSightAACMediaRecorder", "MMSightAACMediaRecorder init tempPath[%s], sampleRate[%d]", new Object[]{str, Integer.valueOf(this.audioSampleRate)});
        this.nEx = new MediaRecorder();
        this.nEx.setAudioSource(1);
        this.nEx.setOutputFormat(2);
        this.nEx.setAudioEncoder(3);
        this.nEx.setAudioChannels(1);
        this.nEx.setAudioEncodingBitRate(this.hzL);
        this.nEx.setAudioSamplingRate(this.audioSampleRate);
        this.nEx.setOutputFile(str);
        try {
            this.nEx.prepare();
            return 0;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e, "mediaRecorder prepare error: %s", new Object[]{e.getMessage()});
            return -1;
        }
    }

    public final int a(b bVar) {
        w.i("MicroMsg.MMSightAACMediaRecorder", "stop, mediaRecorder: %s, callback: %s", new Object[]{this.nEx, bVar});
        if (this.nEx != null) {
            try {
                if (!this.nEy) {
                    this.nEx.stop();
                    this.nEx.release();
                }
                this.nEx = null;
                if (bVar == null) {
                    return 0;
                }
                bVar.aLc();
                return 0;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e, "stop record aac.mp4 error:%s", new Object[]{e.getMessage()});
                return -1;
            }
        } else if (bVar == null) {
            return 0;
        } else {
            bVar.aLc();
            return 0;
        }
    }

    public final void clear() {
        try {
            if (this.nEx != null) {
                if (!this.nEy) {
                    this.nEx.stop();
                    this.nEx.release();
                }
                this.nEx = null;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MMSightAACMediaRecorder", e, "clear error: %s", new Object[]{e.getMessage()});
        }
    }

    public final void aKZ() {
    }

    public final c.a aLa() {
        return null;
    }

    public final void fE(boolean z) {
        this.nEy = z;
    }
}
