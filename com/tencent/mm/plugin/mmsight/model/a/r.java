package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecInfo.EncoderCapabilities;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.f.a;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.nio.ByteBuffer;

@TargetApi(16)
public class r implements f {
    private int bitrate = 0;
    public boolean fOV = false;
    int frameCount;
    public boolean fzy = false;
    int lKi;
    boolean nCV = false;
    int nDG;
    protected MediaCodec nDY;
    private int nEh = -1;
    private o nEl;
    int nFL = -1;
    int nFM = -1;
    int nFN = -1;
    int nFO = -1;
    public a nFP = new a(this.nGa);
    private int nFQ;
    private int nFR;
    protected MediaFormat nFS;
    private long nFT = 0;
    private int nFU = -1;
    private BufferInfo nFV;
    private boolean nFW = false;
    private int nFX;
    private int nFY;
    public a nFZ;
    private a.a nGa = new a.a(this) {
        final /* synthetic */ r nGb;

        {
            this.nGb = r1;
        }

        public final void output(byte[] bArr) {
            long NA = bg.NA();
            boolean aKY = this.nGb.nFP.aKY();
            r rVar = this.nGb;
            boolean z = aKY && this.nGb.fzy;
            rVar.b(bArr, z);
            j.nEA.x(bArr);
            w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "markStop: %s isEnd %s costTime %d", new Object[]{Boolean.valueOf(this.nGb.fzy), Boolean.valueOf(aKY), Long.valueOf(bg.aB(NA))});
            if (aKY && this.nGb.fzy) {
                this.nGb.aLA();
            }
        }
    };
    int neJ;
    private ByteBuffer[] nzI;
    private ByteBuffer[] nzK;
    long startTime = 0;

    public r(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        this.nFQ = i;
        this.nFR = i2;
        w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "create MMSightYUVMediaCodecRecorder, init targetWidth: %d, targetHeight: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
        w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "create MMSightYUVMediaCodecRecorder, after align 16, targetWidth: %d, targetHeight: %d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)});
        this.neJ = i3;
        this.lKi = i4;
        this.nFY = i7;
        this.nFX = i6;
        this.nEl = null;
        this.nFV = new BufferInfo();
        this.bitrate = i5;
        this.nCV = z;
        w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "create BigSightMediaCodecYUVRecorder, frameWidth: %s, frameHeight: %s, targetWidth: %s, targetHeight: %s, bitrate: %s, needRotateEachFrame: %s, muxer: %s", new Object[]{Integer.valueOf(this.nFQ), Integer.valueOf(this.nFR), Integer.valueOf(this.neJ), Integer.valueOf(this.lKi), Integer.valueOf(i5), Boolean.valueOf(z), null});
    }

    public int cp(int i, int i2) {
        int i3 = -1;
        try {
            this.nFL = i2;
            i3 = aLy();
        } catch (Exception e) {
            w.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "init error: %s, try to re-init again", new Object[]{e.getMessage()});
            try {
                CaptureMMProxy.getInstance().set(com.tencent.mm.storage.w.a.uFl, Integer.valueOf(-1));
                i3 = aLy();
            } catch (Exception e2) {
                w.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "re-init again error: %s", new Object[]{e2.getMessage()});
                k.aKR();
            }
        }
        return i3;
    }

    private int aLy() {
        int intValue;
        MediaCodecInfo mediaCodecInfo;
        long NA = bg.NA();
        String str = "video/avc";
        int codecCount = MediaCodecList.getCodecCount();
        loop0:
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                String[] supportedTypes = codecInfoAt.getSupportedTypes();
                for (String equalsIgnoreCase : supportedTypes) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        mediaCodecInfo = codecInfoAt;
                        break loop0;
                    }
                }
                continue;
            }
        }
        mediaCodecInfo = null;
        if (mediaCodecInfo == null) {
            w.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "Unable to find an appropriate codec for video/avc");
            k.aKR();
            return -1;
        }
        long NA2;
        int i2;
        w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "found codec: %s, used %sms", new Object[]{mediaCodecInfo.getName(), Long.valueOf(bg.aB(NA))});
        NA = bg.NA();
        intValue = ((Integer) CaptureMMProxy.getInstance().get(com.tencent.mm.storage.w.a.uFl, Integer.valueOf(-1))).intValue();
        w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "saveColorFormat: %s", new Object[]{Integer.valueOf(intValue)});
        if (intValue <= 0) {
            intValue = 0;
            NA2 = bg.NA();
            CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType("video/avc");
            w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "getCapabilitiesForType used %sms", new Object[]{Long.valueOf(bg.aB(NA2))});
            w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "color format length: %s", new Object[]{Integer.valueOf(capabilitiesForType.colorFormats.length)});
            for (int i3 : capabilitiesForType.colorFormats) {
                Object obj;
                w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "capabilities colorFormat: %s", new Object[]{Integer.valueOf(i3)});
                switch (i3) {
                    case 19:
                    case 21:
                    case 2130706688:
                        obj = 1;
                        break;
                    default:
                        obj = null;
                        break;
                }
                if (obj != null && (i3 > intValue || i3 == 21)) {
                    intValue = i3;
                }
            }
            w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "codec: %s, colorFormat: %s", new Object[]{mediaCodecInfo.getName(), Integer.valueOf(intValue)});
        }
        this.nDG = intValue;
        long aB = bg.aB(NA);
        if (this.nDG > 0 && aB > 200) {
            CaptureMMProxy.getInstance().set(com.tencent.mm.storage.w.a.uFl, Integer.valueOf(this.nDG));
        }
        w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "found colorFormat: %s, used %sms", new Object[]{Integer.valueOf(this.nDG), Long.valueOf(aB)});
        NA2 = bg.NA();
        String str2;
        if (this.nCV) {
            str2 = "video/avc";
            intValue = (this.nFL == 180 || this.nFL == 0) ? this.neJ : this.lKi;
            i2 = (this.nFL == 180 || this.nFL == 0) ? this.lKi : this.neJ;
            this.nFS = MediaFormat.createVideoFormat(str2, intValue, i2);
        } else {
            str2 = "video/avc";
            intValue = (this.nFL == 180 || this.nFL == 0) ? this.lKi : this.neJ;
            i2 = (this.nFL == 180 || this.nFL == 0) ? this.neJ : this.lKi;
            this.nFS = MediaFormat.createVideoFormat(str2, intValue, i2);
        }
        w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "createVideoFormat used %sms", new Object[]{Long.valueOf(bg.aB(NA2))});
        if (mediaCodecInfo != null) {
            CodecCapabilities capabilitiesForType2;
            if (d.eo(23)) {
                try {
                    capabilitiesForType2 = mediaCodecInfo.getCapabilitiesForType("video/avc");
                    if (capabilitiesForType2 != null) {
                        CodecProfileLevel[] codecProfileLevelArr = capabilitiesForType2.profileLevels;
                        if (codecProfileLevelArr != null) {
                            CodecProfileLevel codecProfileLevel = new CodecProfileLevel();
                            codecProfileLevel.level = 0;
                            codecProfileLevel.profile = 0;
                            for (CodecProfileLevel codecProfileLevel2 : codecProfileLevelArr) {
                                Object obj2;
                                int i4 = codecProfileLevel2.profile;
                                int i5 = codecProfileLevel2.level;
                                w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "profile: %s, level: %s", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5)});
                                switch (i4) {
                                    case 1:
                                    case 2:
                                    case 8:
                                        obj2 = 1;
                                        break;
                                    default:
                                        obj2 = null;
                                        break;
                                }
                                if (obj2 != null && i4 >= codecProfileLevel.profile && i5 >= codecProfileLevel.level) {
                                    codecProfileLevel.profile = i4;
                                    codecProfileLevel.level = i5;
                                }
                            }
                            w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "best profile: %s, level: %s", new Object[]{Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level)});
                            if (codecProfileLevel.profile > 0 && codecProfileLevel.level >= 256) {
                                this.nFS.setInteger("profile", codecProfileLevel.profile);
                                this.nFS.setInteger("level", 256);
                            }
                        }
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "trySetProfile error: %s", new Object[]{e.getMessage()});
                }
            }
            try {
                if (d.eo(21)) {
                    capabilitiesForType2 = mediaCodecInfo.getCapabilitiesForType("video/avc");
                    if (capabilitiesForType2 != null) {
                        EncoderCapabilities encoderCapabilities = capabilitiesForType2.getEncoderCapabilities();
                        if (encoderCapabilities != null) {
                            if (encoderCapabilities.isBitrateModeSupported(2)) {
                                w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "support cbr bitrate mode");
                                this.nFS.setInteger("bitrate-mode", 2);
                            } else if (encoderCapabilities.isBitrateModeSupported(0)) {
                                w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "support cq bitrate mode");
                                this.nFS.setInteger("bitrate-mode", 0);
                            } else {
                                w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "both cbr and cq bitrate mode not support!");
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                w.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "trySetBitRateMode error: %s", new Object[]{e2.getMessage()});
            }
        }
        this.nFS.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.bitrate);
        this.nFS.setInteger("frame-rate", this.nFY);
        this.nFS.setInteger("color-format", this.nDG);
        this.nFS.setInteger("i-frame-interval", this.nFX);
        w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "mediaFormat: %s", new Object[]{this.nFS});
        this.nDY = MediaCodec.createByCodecName(mediaCodecInfo.getName());
        this.nDY.configure(this.nFS, null, null, 1);
        this.nDY.start();
        return 0;
    }

    public final void b(byte[] bArr, boolean z) {
        try {
            if (!this.fOV) {
                w.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData, not start!");
            } else if (this.nDY == null) {
                w.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder is null");
            } else {
                if (this.nEl != null && this.nEl.nFJ <= 0) {
                    this.nEl.nFJ = System.nanoTime();
                }
                long NA = bg.NA();
                this.nzI = this.nDY.getInputBuffers();
                this.nzK = this.nDY.getOutputBuffers();
                int dequeueInputBuffer = this.nDY.dequeueInputBuffer(100);
                this.nFU = dequeueInputBuffer;
                if (dequeueInputBuffer < 0) {
                    w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "video no input available, drain first");
                    aLz();
                }
                if (this.nDY == null) {
                    w.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder is null");
                    return;
                }
                w.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "inputBufferIndex: %s", new Object[]{Integer.valueOf(this.nFU)});
                long NA2 = bg.NA();
                if (this.nFU >= 0) {
                    long nanoTime = ((System.nanoTime() - ((long) ((bArr.length / 1600000) / 1000000000))) - (this.nEl != null ? this.nEl.nFJ : this.startTime)) / 1000;
                    w.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "presentationTime: " + nanoTime);
                    ByteBuffer byteBuffer = this.nzI[this.nFU];
                    byteBuffer.clear();
                    byteBuffer.put(bArr);
                    byteBuffer.position(0);
                    if (!this.fOV || z) {
                        w.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "end of stream");
                        this.nFW = true;
                        this.nDY.queueInputBuffer(this.nFU, 0, bArr.length, nanoTime, 4);
                    } else {
                        this.nDY.queueInputBuffer(this.nFU, 0, bArr.length, nanoTime, 0);
                    }
                } else {
                    w.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "input buffer not available");
                }
                aLz();
                w.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder used %sms %sms", new Object[]{Long.valueOf(bg.aB(NA)), Long.valueOf(bg.aB(NA2))});
            }
        } catch (Throwable e) {
            w.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecWriteYUVError");
            g.oUh.a(440, 21, 1, false);
            w.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "writeData error: %s", new Object[]{e.getMessage()});
            w.printErrStackTrace("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", e, "", new Object[0]);
        }
    }

    private void aLz() {
        this.nEh = this.nDY.dequeueOutputBuffer(this.nFV, 100);
        w.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "outputBufferIndex-->" + this.nEh);
        while (true) {
            if (this.nEh != -1) {
                if (this.nEh != -3) {
                    if (this.nEh != -2) {
                        if (this.nEh >= 0) {
                            w.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "perform encoding");
                            ByteBuffer byteBuffer = this.nzK[this.nEh];
                            if (byteBuffer != null) {
                                this.frameCount++;
                                if ((this.nFV.flags & 2) != 0) {
                                    w.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG, size: %s, %s", new Object[]{Integer.valueOf(this.nFV.size), Boolean.valueOf(false)});
                                }
                                if (this.nFV.size != 0) {
                                    if (!(this.nEl == null || this.nEl.fOV)) {
                                        this.nEl.a(this.nDY.getOutputFormat());
                                    }
                                    byteBuffer.position(this.nFV.offset);
                                    byteBuffer.limit(this.nFV.offset + this.nFV.size);
                                    a(byteBuffer, this.nFV);
                                }
                                this.nDY.releaseOutputBuffer(this.nEh, false);
                                if ((this.nFV.flags & 4) != 0) {
                                    break;
                                }
                            }
                            throw new RuntimeException("encoderOutputBuffer " + this.nEh + " was null");
                        }
                        w.w("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "unexpected result from encoder.dequeueOutputBuffer: " + this.nEh);
                    } else {
                        MediaFormat outputFormat = this.nDY.getOutputFormat();
                        w.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder output format changed: " + outputFormat);
                        if (this.nEl != null) {
                            this.nEl.a(outputFormat);
                        }
                    }
                } else {
                    this.nzK = this.nDY.getOutputBuffers();
                    w.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "encoder output buffers changed");
                }
            } else {
                w.d("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "no output from encoder available, break encoderEndStream %s", new Object[]{Boolean.valueOf(this.nFW)});
                if (!this.nFW) {
                    return;
                }
            }
            this.nEh = this.nDY.dequeueOutputBuffer(this.nFV, 100);
            if (this.nEh <= 0) {
                w.v("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "get outputBufferIndex %d", new Object[]{Integer.valueOf(this.nEh)});
            }
            if (this.nEh < 0 && !this.nFW) {
                return;
            }
        }
        if (this.fzy) {
            w.w("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "do stop encoder");
            try {
                this.nDY.stop();
                this.nDY.release();
                this.nFP.stop();
                this.nDY = null;
                this.fOV = false;
                if (this.nFZ != null) {
                    this.nFZ.aLp();
                    return;
                }
                return;
            } catch (Exception e) {
                w.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "do stop encoder error: %s", new Object[]{e.getMessage()});
                return;
            }
        }
        w.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "reached end of stream unexpectedly");
    }

    protected void a(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.nEl != null && (bufferInfo.flags & 4) == 0) {
            this.nEl.c(byteBuffer, bufferInfo);
        }
    }

    public final void a(a aVar) {
        this.nFZ = aVar;
        this.fzy = true;
        w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "!!!stop, isStart!!: %s %s isEnd %s", new Object[]{Boolean.valueOf(this.fOV), this.nFZ, Boolean.valueOf(this.nFP.aKY())});
        if (this.nFP.aKY()) {
            aLA();
        }
    }

    public final void aLA() {
        w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "stopImp %s", new Object[]{bg.bJZ().toString()});
        try {
            if (this.fOV) {
                af.f(new Runnable(this) {
                    final /* synthetic */ r nGb;

                    {
                        this.nGb = r1;
                    }

                    public final void run() {
                        try {
                            if (this.nGb.nDY != null) {
                                w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "delay to stop encoder");
                                this.nGb.nFP.stop();
                                this.nGb.nDY.stop();
                                this.nGb.nDY.release();
                                this.nGb.nDY = null;
                                this.nGb.fOV = false;
                                if (this.nGb.nFZ != null) {
                                    this.nGb.nFZ.aLp();
                                }
                            }
                        } catch (Exception e) {
                            w.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "delay to stop encoder error: %s", new Object[]{e.getMessage()});
                        }
                    }
                }, 500);
            }
        } catch (Exception e) {
            w.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "stop error: %s", new Object[]{e.getMessage()});
        }
    }

    public final long aLx() {
        return System.currentTimeMillis() - this.startTime;
    }

    public void clear() {
        w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "clear");
        try {
            if (this.nDY != null) {
                w.i("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "stop encoder");
                this.nFP.stop();
                this.nDY.stop();
                this.nDY.release();
                this.nDY = null;
                this.fOV = false;
            }
        } catch (Exception e) {
            w.e("MicroMsg.MMSightYUVMediaCodecBufIdRecorder", "clear error: %s", new Object[]{e.getMessage()});
        }
    }
}
