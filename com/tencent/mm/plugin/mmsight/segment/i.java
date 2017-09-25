package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Process;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class i implements com.tencent.mm.plugin.mmsight.segment.f.a {
    private static int nHh = -1;
    int gPG;
    private Object lock = new byte[0];
    private int nDE;
    private int nDF;
    VideoTransPara nGL;
    private int nGU;
    private int nGV;
    private int nGW;
    private int nGX;
    private int nGY;
    private int nGZ;
    public String nGu;
    long nGv = -1;
    long nGw = -1;
    int nGy = -1;
    a nHa;
    Thread nHb;
    private int nHc = 0;
    MediaExtractor nHd;
    int nHe;
    f nHf;
    private boolean nHg = false;
    private MediaFormat nHi;

    private class a implements Runnable {
        int nEV;
        volatile int nFi;
        Object nFp = new Object();
        final /* synthetic */ i nHj;
        boolean nHk;

        public a(i iVar) {
            this.nHj = iVar;
        }

        public final void run() {
            if (this.nEV == -1) {
                this.nEV = Process.myTid();
                Process.setThreadPriority(Process.myTid(), -2);
                w.i("MicroMsg.MediaCodecFFMpegTranscoder", "encodeTid: %s", new Object[]{Integer.valueOf(this.nEV)});
            }
            this.nFi = 0;
            synchronized (this.nFp) {
                long NA;
                while (!this.nHk) {
                    NA = bg.NA();
                    w.i("MicroMsg.MediaCodecFFMpegTranscoder", "try trigger encode");
                    int triggerEncodeForSegment = MP4MuxerJNI.triggerEncodeForSegment(Math.max(0, this.nFi), false);
                    w.i("MicroMsg.MediaCodecFFMpegTranscoder", "ing: trigger encode use %dms, Encode index[%d, %d), threadId: %s", new Object[]{Long.valueOf(bg.aB(NA)), Integer.valueOf(this.nFi), Integer.valueOf(triggerEncodeForSegment), Long.valueOf(Thread.currentThread().getId())});
                    if (triggerEncodeForSegment == this.nFi) {
                        try {
                            Thread.sleep(20);
                        } catch (Exception e) {
                            w.e("MicroMsg.MediaCodecFFMpegTranscoder", "thread sleep error");
                        }
                    }
                    this.nFi = triggerEncodeForSegment;
                }
                NA = bg.NA();
                this.nFi = MP4MuxerJNI.triggerEncodeForSegment(this.nFi, true);
                w.i("MicroMsg.MediaCodecFFMpegTranscoder", "end: trigger encode use %dms, curEncode index %d, threadId: %s", new Object[]{Long.valueOf(bg.aB(NA)), Integer.valueOf(this.nFi), Long.valueOf(Thread.currentThread().getId())});
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int aLN() {
        /*
        r7 = 21;
        r6 = 3;
        r5 = 2;
        r4 = -1;
        r3 = 1;
        r0 = com.tencent.mm.plugin.mmsight.model.CaptureMMProxy.getInstance();
        r1 = com.tencent.mm.storage.w.a.uFh;
        r2 = java.lang.Integer.valueOf(r4);
        r0 = r0.get(r1, r2);
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        if (r0 == r4) goto L_0x0034;
    L_0x001c:
        if (r0 != r3) goto L_0x002c;
    L_0x001e:
        r0 = com.tencent.mm.compatible.util.d.eo(r7);
        if (r0 == 0) goto L_0x0029;
    L_0x0024:
        nHh = r5;
    L_0x0026:
        r0 = nHh;
    L_0x0028:
        return r0;
    L_0x0029:
        nHh = r3;
        goto L_0x0026;
    L_0x002c:
        if (r0 != r5) goto L_0x0031;
    L_0x002e:
        nHh = r3;
        goto L_0x0026;
    L_0x0031:
        nHh = r6;
        goto L_0x0026;
    L_0x0034:
        r0 = nHh;
        if (r0 == r4) goto L_0x003b;
    L_0x0038:
        r0 = nHh;
        goto L_0x0028;
    L_0x003b:
        r0 = com.tencent.mm.compatible.d.p.gRj;
        r0 = r0.gRu;
        if (r0 == r4) goto L_0x005b;
    L_0x0041:
        if (r0 != r3) goto L_0x0048;
    L_0x0043:
        nHh = r3;
    L_0x0045:
        r0 = nHh;
        goto L_0x0028;
    L_0x0048:
        if (r0 != r5) goto L_0x0056;
    L_0x004a:
        r0 = com.tencent.mm.compatible.util.d.eo(r7);
        if (r0 == 0) goto L_0x0053;
    L_0x0050:
        nHh = r5;
        goto L_0x0045;
    L_0x0053:
        nHh = r3;
        goto L_0x0045;
    L_0x0056:
        if (r0 != r6) goto L_0x0045;
    L_0x0058:
        nHh = r6;
        goto L_0x0045;
    L_0x005b:
        r0 = com.tencent.mm.plugin.mmsight.model.CaptureMMProxy.getInstance();
        r1 = "SightSegCutMinApiLevel";
        r0 = r0.getDynamicConfig(r1);
        r0 = com.tencent.mm.sdk.platformtools.bg.getInt(r0, r7);
        r0 = com.tencent.mm.compatible.util.d.eo(r0);
        if (r0 == 0) goto L_0x0058;
    L_0x0070:
        nHh = r3;
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.segment.i.aLN():int");
    }

    public final int c(MediaFormat mediaFormat) {
        w.i("MicroMsg.MediaCodecFFMpegTranscoder", "initDecoder, format: %s, filePath: %s", new Object[]{mediaFormat, this.nGu});
        this.nHi = mediaFormat;
        int aLN = aLN();
        if (aLN == 1) {
            this.nHf = new j(this.nHd, mediaFormat, this.nHe);
            this.nHg = false;
        } else if (aLN == 2) {
            this.nHf = new k(this.nHd, mediaFormat, this.nHe);
            this.nHg = false;
        } else {
            this.nHf = new b();
            this.nHg = true;
        }
        if (this.nHf == null) {
            w.i("MicroMsg.MediaCodecFFMpegTranscoder", "use default config");
            this.nHf = new j(this.nHd, mediaFormat, this.nHe);
            this.nHg = false;
        }
        aLN = this.nHf.k(this.nGu, this.nGv, this.nGw);
        w.i("MicroMsg.MediaCodecFFMpegTranscoder", "init decoder ret: %s", new Object[]{Integer.valueOf(aLN)});
        if (aLN < 0 && (nHh == 1 || nHh == 2)) {
            w.i("MicroMsg.MediaCodecFFMpegTranscoder", "init mediaCodecDecoder failed, try ffmepg");
            try {
                this.nHf.stop();
                this.nHf = null;
            } catch (Exception e) {
            }
            this.nHf = new b();
            this.nHg = true;
            nHh = 3;
            aLN = this.nHf.k(this.nGu, this.nGv, this.nGw);
        }
        this.nHf.a(this);
        w.i("MicroMsg.MediaCodecFFMpegTranscoder", "init finish, ret: %d, decoderType: %d", new Object[]{Integer.valueOf(aLN), Integer.valueOf(nHh)});
        return aLN;
    }

    public final void cq(int i, int i2) {
        w.i("MicroMsg.MediaCodecFFMpegTranscoder", "registerDesiredSize: %s, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        this.nGU = i;
        this.nGV = i2;
    }

    private static Point k(int i, int i2, int i3, int i4) {
        w.d("MicroMsg.MediaCodecFFMpegTranscoder", "scale() called with: decoderOutputWidth = [" + i + "], decoderOutputHeight = [" + i2 + "], specWidth = [" + i3 + "], specHeight = [" + i4 + "]");
        if (i > i3 || i2 > i4) {
            int max = Math.max(i, i2);
            int min = Math.min(i, i2);
            int max2 = Math.max(i3, i4);
            int min2 = Math.min(i3, i4);
            if (max % 16 == 0 && Math.abs(max - max2) < 16 && min % 16 == 0 && Math.abs(min - min2) < 16) {
                w.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, same len divide by 16, no need scale");
                return null;
            } else if (max / 2 == max2 && min / 2 == min2) {
                w.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio");
                r0 = i / 2;
                max = i2 / 2;
                if (r0 % 2 != 0) {
                    r0++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                return new Point(r0, max);
            } else {
                r0 = max / 2;
                max = min / 2;
                if (r0 % 16 != 0 || Math.abs(r0 - max2) >= 16 || max % 16 != 0 || Math.abs(max - min2) >= 16) {
                    Point point = new Point();
                    if (i < i2) {
                        max = Math.min(i3, i4);
                        r0 = (int) (((double) i2) / ((((double) i) * 1.0d) / ((double) max)));
                    } else {
                        r0 = Math.min(i3, i4);
                        max = (int) (((double) i) / ((((double) i2) * 1.0d) / ((double) r0)));
                    }
                    if (r0 % 2 != 0) {
                        r0++;
                    }
                    if (max % 2 != 0) {
                        max++;
                    }
                    w.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, outputsize: %s %s", new Object[]{Integer.valueOf(max), Integer.valueOf(r0)});
                    point.x = max;
                    point.y = r0;
                    return point;
                }
                w.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, double ratio divide by 16");
                r0 = i / 2;
                max = i2 / 2;
                if (r0 % 2 != 0) {
                    r0++;
                }
                if (max % 2 != 0) {
                    max++;
                }
                return new Point(r0, max);
            }
        }
        w.i("MicroMsg.MediaCodecFFMpegTranscoder", "calc scale, small or equal to spec size");
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void release() {
        /*
        r7 = this;
        r2 = 1;
        r6 = -1;
        r5 = 0;
        r0 = "MicroMsg.MediaCodecFFMpegTranscoder";
        r1 = "release, decoderType: %d";
        r2 = new java.lang.Object[r2];
        r3 = nHh;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r5] = r3;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
        r0 = r7.nHf;	 Catch:{ Exception -> 0x0025 }
        if (r0 == 0) goto L_0x001f;
    L_0x001a:
        r0 = r7.nHf;	 Catch:{ Exception -> 0x0025 }
        r0.stop();	 Catch:{ Exception -> 0x0025 }
    L_0x001f:
        com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI.releaseDataBuf(r5);
        nHh = r6;
    L_0x0024:
        return;
    L_0x0025:
        r0 = move-exception;
        r1 = "MicroMsg.MediaCodecFFMpegTranscoder";
        r2 = "release error: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x003f }
        r4 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x003f }
        r3[r4] = r0;	 Catch:{ all -> 0x003f }
        com.tencent.mm.sdk.platformtools.w.e(r1, r2, r3);	 Catch:{ all -> 0x003f }
        com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI.releaseDataBuf(r5);
        nHh = r6;
        goto L_0x0024;
    L_0x003f:
        r0 = move-exception;
        com.tencent.mm.plugin.mmsight.segment.MP4MuxerJNI.releaseDataBuf(r5);
        nHh = r6;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.segment.i.release():void");
    }

    public final void ay(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            w.i("MicroMsg.MediaCodecFFMpegTranscoder", "onYuvDataImp error data is null!!");
            return;
        }
        Point k;
        Point aLD = this.nHf.aLD();
        this.nDE = aLD.x;
        this.nDF = aLD.y;
        if (this.nGZ <= 0 || this.nGY <= 0) {
            k = k(this.nDE, this.nDF, this.nGU, this.nGV);
            if (k != null) {
                this.nGY = k.x;
                this.nGZ = k.y;
            } else {
                this.nGY = this.nDE;
                this.nGZ = this.nDF;
            }
            w.i("MicroMsg.MediaCodecFFMpegTranscoder", "scaleYuvTargetWidth: %s, scaleYuvTargetHeight: %s, srcWidth: %s, srcHeight: %s", new Object[]{Integer.valueOf(this.nGY), Integer.valueOf(this.nGZ), Integer.valueOf(this.nDE), Integer.valueOf(this.nDF)});
        }
        long NA = bg.NA();
        int i = 0;
        int i2 = 0;
        if (this.nHi != null) {
            i = this.nHi.getInteger("width");
            i2 = this.nHi.getInteger("height");
            if (this.nGW <= 0 || this.nGX <= 0) {
                boolean z;
                k = k(i, i2, this.nGU, this.nGV);
                if (k != null) {
                    this.nGW = k.x;
                    this.nGX = k.y;
                    z = true;
                } else {
                    if (Math.abs(i2 - aLD.y) <= 0 || i != aLD.x) {
                        this.nGW = aLD.x;
                        this.nGX = aLD.y;
                    } else {
                        this.nGW = i;
                        this.nGX = i2;
                    }
                    z = false;
                }
                if (z) {
                    this.nGY = this.nGW;
                    this.nGZ = this.nGX;
                }
                w.i("MicroMsg.MediaCodecFFMpegTranscoder", "videoTargetWidth: %s, videoTargetHeight: %s, initWidth: %s, initHeight: %s, videoNeedScale: %s", new Object[]{Integer.valueOf(this.nGW), Integer.valueOf(this.nGX), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)});
            }
        }
        this.nHc = this.nHf.aLE();
        int writeYuvDataForSegment = MP4MuxerJNI.writeYuvDataForSegment(bArr, aLD.x, aLD.y, this.nGY, this.nGZ, this.nHc, i, i2);
        w.i("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment used %sms", new Object[]{Long.valueOf(bg.aB(NA))});
        if (writeYuvDataForSegment < 0) {
            w.e("MicroMsg.MediaCodecFFMpegTranscoder", "writeYuvDataForSegment error: %s", new Object[]{Integer.valueOf(writeYuvDataForSegment)});
        }
        if (this.nHa == null) {
            MP4MuxerJNI.initH264Encoder(this.nGW, this.nGX, (float) this.nGL.gPE, this.nGL.hzY, this.nGL.hzO, 8, this.nGL.hzN, 23.0f);
            this.nHa = new a(this);
            this.nHb = e.b(this.nHa, "MediaCodecFFMpegTranscoder_Encoder");
            this.nHb.start();
            w.i("MicroMsg.MediaCodecFFMpegTranscoder", "initAndStartEncoder");
        }
    }
}
