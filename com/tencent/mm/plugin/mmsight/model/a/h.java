package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.c.b.c;
import com.tencent.mm.plugin.mmsight.model.a.c.a;
import com.tencent.mm.plugin.mmsight.model.a.c.b;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.FileUtils;
import java.nio.ByteBuffer;

@TargetApi(16)
public class h implements c {
    int audioSampleRate;
    public c fzv = null;
    private int hzL;
    public MediaCodec nDY;
    private MediaFormat nDZ;
    private BufferInfo nEa;
    long nEb = 0;
    int nEc;
    int nEd;
    long nEe;
    long nEf;
    private final int nEg = 100;
    private int nEh;
    public boolean nEi = false;
    public boolean nEj = false;
    public a nEk = null;
    o nEl;
    public ae nEm = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ h nEw;

        public final void handleMessage(Message message) {
            if (this.nEw.nEk != null) {
                this.nEw.nEk.aLb();
                this.nEw.nEk = null;
            }
        }
    };
    public int nEn;
    protected boolean nEo;
    public boolean nEp;
    public Object nEq = new byte[0];
    public b nEr;
    public boolean nEs = false;
    public ae nEt;
    public Runnable nEu = new Runnable(this) {
        final /* synthetic */ h nEw;

        {
            this.nEw = r1;
        }

        public final void run() {
            if (this.nEw.fzv != null) {
                this.nEw.nEs = true;
                this.nEw.fzv.oX();
            }
        }
    };
    private c.a nEv = new c.a(this) {
        final /* synthetic */ h nEw;

        {
            this.nEw = r1;
        }

        public final void d(byte[] bArr, int i) {
            int i2 = 0;
            this.nEw.nEm.sendEmptyMessage(0);
            if (!this.nEw.nEi) {
                i2 = 1;
            }
            if (i2 == 0) {
                this.nEw.nEn += FileUtils.S_IWUSR;
            }
            boolean z = this.nEw.nEo;
            if (i2 == 0) {
                h hVar = this.nEw;
                if (0 == hVar.nEb) {
                    hVar.nEb = System.nanoTime();
                }
                if (hVar.nEl != null && hVar.nEl.nFJ <= 0) {
                    hVar.nEl.nFJ = System.nanoTime();
                }
                if (hVar.nDY != null) {
                    if (hVar.nDY == null) {
                        w.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:" + z);
                    } else {
                        try {
                            ByteBuffer[] inputBuffers = hVar.nDY.getInputBuffers();
                            int dequeueInputBuffer = hVar.nDY.dequeueInputBuffer(100);
                            hVar.nEc = dequeueInputBuffer;
                            if (dequeueInputBuffer < 0) {
                                w.d("MicroMsg.MMSightAACMediaCodecRecorder", "audio no input available, drain first");
                                hVar.fF(false);
                            }
                            if (hVar.nDY == null) {
                                w.w("MicroMsg.MMSightAACMediaCodecRecorder", "send audio to encoder error, encoder is null, end:" + z);
                            } else if (hVar.nEc >= 0) {
                                ByteBuffer byteBuffer = inputBuffers[hVar.nEc];
                                byteBuffer.clear();
                                byteBuffer.put(bArr);
                                byteBuffer.position(0);
                                hVar.nEd = bArr.length;
                                hVar.nEe = System.nanoTime();
                                hVar.nEe -= (long) ((hVar.nEd / hVar.audioSampleRate) / 1000000000);
                                if (hVar.nEd == -3) {
                                    w.e("MicroMsg.MMSightAACMediaCodecRecorder", "Audio read error");
                                }
                                hVar.nEf = (hVar.nEe - (hVar.nEl != null ? hVar.nEl.nFJ : hVar.nEb)) / 1000;
                                w.v("MicroMsg.MMSightAACMediaCodecRecorder", "queueing " + hVar.nEd + " audio bytes with pts " + hVar.nEf + ", end:" + z + ", enqueue:" + hVar.nEc);
                                if (z) {
                                    w.i("MicroMsg.MMSightAACMediaCodecRecorder", "EOS received in sendAudioToEncoder");
                                    hVar.nDY.queueInputBuffer(hVar.nEc, 0, hVar.nEd, hVar.nEf, 4);
                                } else {
                                    hVar.nDY.queueInputBuffer(hVar.nEc, 0, hVar.nEd, hVar.nEf, 0);
                                }
                            }
                        } catch (Throwable th) {
                            w.e("MicroMsg.MMSightAACMediaCodecRecorder", "_offerAudioEncoder exception " + th.getMessage());
                        }
                    }
                    hVar.fF(z);
                }
            }
            if (z && !this.nEw.nEs) {
                synchronized (this.nEw.nEq) {
                    if (this.nEw.nEr != null) {
                        w.i("MicroMsg.MMSightAACMediaCodecRecorder", "do aac stop callback");
                        this.nEw.nEr.aLc();
                        this.nEw.nEr = null;
                    } else {
                        w.w("MicroMsg.MMSightAACMediaCodecRecorder", "aac stop callback is null");
                    }
                    this.nEw.nEp = true;
                }
                this.nEw.nEs = true;
                this.nEw.nEt.removeCallbacks(this.nEw.nEu);
                this.nEw.nEt.post(this.nEw.nEu);
            }
        }

        public final void ax(int i, int i2) {
            w.w("MicroMsg.MMSightAACMediaCodecRecorder", "on rec error, %d, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
    };
    private long startTime = 0;

    public h(int i, int i2) {
        this.hzL = i2;
        this.audioSampleRate = i;
        this.nEl = null;
        w.i("MicroMsg.MMSightAACMediaCodecRecorder", "create MMSightAACMediaCodecRecorder, audioBitrate: %s, audioSampleRate: %s", new Object[]{Integer.valueOf(this.hzL), Integer.valueOf(this.audioSampleRate)});
    }

    public int ad(int i, String str) {
        if (!(this.nEj || this.fzv == null)) {
            String str2 = "MicroMsg.MMSightAACMediaCodecRecorder";
            String str3 = "call init, before pcmRecorder stop, stopCallback null ? %B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(this.nEr == null);
            w.e(str2, str3, objArr);
            this.fzv.oX();
        }
        if (this.nDY != null) {
            boolean z;
            str2 = "MicroMsg.MMSightAACMediaCodecRecorder";
            str3 = "call init, before audioEncoder stop, stopCallback null ? %B";
            objArr = new Object[1];
            if (this.nEr == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            w.e(str2, str3, objArr);
            this.nDY.stop();
            this.nDY.release();
            this.nDY = null;
            if (this.nEr != null) {
                this.nEr.aLc();
                this.nEr = null;
            }
        }
        this.nEn = 0;
        this.nEo = false;
        this.nEp = false;
        this.nEr = null;
        if (!this.nEj) {
            this.fzv = new c(this.audioSampleRate, 5);
            this.fzv.cY(FileUtils.S_IWUSR);
            this.fzv.as(false);
            this.fzv.fAe = this.nEv;
        }
        if (this.nEt == null) {
            w.i("MicroMsg.MMSightAACMediaCodecRecorder", "create pcm control handler");
            this.nEt = new ae();
        } else if (this.nEt.getLooper() != Looper.myLooper()) {
            w.w("MicroMsg.MMSightAACMediaCodecRecorder", "error pcm control handler looper[%s, %s], recreate handler", new Object[]{this.nEt.getLooper(), Looper.myLooper()});
            this.nEt = new ae();
        }
        w.i("MicroMsg.MMSightAACMediaCodecRecorder", "sample rate %d, audio rate %d", new Object[]{Integer.valueOf(this.audioSampleRate), Integer.valueOf(this.hzL)});
        try {
            this.nEa = new BufferInfo();
            this.nDZ = new MediaFormat();
            this.nDZ.setString("mime", "audio/mp4a-latm");
            this.nDZ.setInteger("aac-profile", 2);
            this.nDZ.setInteger("sample-rate", this.audioSampleRate);
            this.nDZ.setInteger("channel-count", 1);
            this.nDZ.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.hzL);
            this.nDZ.setInteger("max-input-size", 16384);
            this.nDY = MediaCodec.createEncoderByType("audio/mp4a-latm");
            this.nDY.configure(this.nDZ, null, null, 1);
            this.nDY.start();
            return 0;
        } catch (Throwable th) {
            w.printErrStackTrace("MicroMsg.MMSightAACMediaCodecRecorder", th, "start aac encoder error: %s", new Object[]{th.getMessage()});
            if (this.nDY != null) {
                try {
                    this.nDY.stop();
                    this.nDY.release();
                    this.nDY = null;
                } catch (Exception e) {
                    str2 = "MicroMsg.MMSightAACMediaCodecRecorder";
                    str3 = "try to stop aac encoder error: %s";
                    this.nDY = null;
                    w.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecAACInitError");
                    g.oUh.a(440, 15, 1, false);
                    return -1;
                } catch (Throwable th2) {
                    this.nDY = null;
                }
            }
            w.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecAACInitError");
            g.oUh.a(440, 15, 1, false);
            return -1;
        } finally {
            this.nEi = false;
        }
    }

    public final int a(a aVar) {
        int i = 0;
        w.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, onPcmReady: %s", new Object[]{aVar});
        this.nEk = aVar;
        if (!this.nEj) {
            if (this.fzv == null) {
                w.i("MicroMsg.MMSightAACMediaCodecRecorder", "start, pcmrecorder is null");
                return -1;
            } else if (!this.fzv.pf()) {
                i = -1;
            }
        }
        return i;
    }

    public final int a(b bVar) {
        boolean z;
        String str = "MicroMsg.MMSightAACMediaCodecRecorder";
        String str2 = "call stop, pcmRecorder null[%B], old stopCallback null[%B]new stopCallback null[%B], pcmMarkStop[%B]";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(this.fzv == null);
        if (this.nEr == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Boolean.valueOf(bVar == null);
        objArr[3] = Boolean.valueOf(this.nEo);
        w.i(str, str2, objArr);
        if (this.fzv == null && !this.nEj) {
            return -1;
        }
        this.nEo = true;
        synchronized (this.nEq) {
            this.nEr = bVar;
            if (this.nEp && bVar != null) {
                w.i("MicroMsg.MMSightAACMediaCodecRecorder", "has stop, directly call stop callback");
                bVar.aLc();
                this.nEr = null;
            }
        }
        af.f(new Runnable(this) {
            final /* synthetic */ h nEw;

            {
                this.nEw = r1;
            }

            public final void run() {
                try {
                    if (this.nEw.nDY != null) {
                        w.i("MicroMsg.MMSightAACMediaCodecRecorder", "delay to stop encoder");
                        this.nEw.nDY.stop();
                        this.nEw.nDY.release();
                        this.nEw.nDY = null;
                    }
                    if (this.nEw.fzv != null && !this.nEw.nEj) {
                        this.nEw.fzv.oX();
                        this.nEw.fzv = null;
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.MMSightAACMediaCodecRecorder", "delay to stop encoder error: %s", new Object[]{e.getMessage()});
                }
            }
        }, 500);
        return 0;
    }

    public final void clear() {
        w.i("MicroMsg.MMSightAACMediaCodecRecorder", "clear");
        try {
            if (this.nDY != null) {
                w.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop encoder");
                this.nDY.stop();
                this.nDY.release();
                this.nDY = null;
            }
            if (this.fzv != null && !this.nEj) {
                w.i("MicroMsg.MMSightAACMediaCodecRecorder", "stop pcm recorder");
                this.fzv.oX();
                this.fzv = null;
            }
        } catch (Exception e) {
            w.e("MicroMsg.MMSightAACMediaCodecRecorder", "clear error: %s", new Object[]{e.getMessage()});
        }
    }

    public final void aKZ() {
        this.nEi = true;
    }

    public final c.a aLa() {
        return this.nEv;
    }

    public final void fE(boolean z) {
        this.nEj = z;
    }

    final void fF(boolean z) {
        if (this.nDY == null) {
            w.w("MicroMsg.MMSightAACMediaCodecRecorder", "drain audio encoder error, encoder is null, end:" + z);
            return;
        }
        try {
            ByteBuffer[] outputBuffers = this.nDY.getOutputBuffers();
            while (true) {
                this.nEh = this.nDY.dequeueOutputBuffer(this.nEa, 100);
                w.v("MicroMsg.MMSightAACMediaCodecRecorder", "outputBufferIndex-->%s", new Object[]{Integer.valueOf(this.nEh)});
                if (this.nEh == -1) {
                    w.d("MicroMsg.MMSightAACMediaCodecRecorder", "no output available, break");
                    return;
                } else if (this.nEh == -3) {
                    outputBuffers = this.nDY.getOutputBuffers();
                } else if (this.nEh == -2) {
                    MediaFormat outputFormat = this.nDY.getOutputFormat();
                    w.d("MicroMsg.MMSightAACMediaCodecRecorder", "encoder output format changed: " + outputFormat);
                    if (this.nEl != null) {
                        this.nEl.b(outputFormat);
                    }
                } else if (this.nEh < 0) {
                    w.v("MicroMsg.MMSightAACMediaCodecRecorder", "unexpected result from encoder.dequeueOutputBuffer: %s", new Object[]{Integer.valueOf(this.nEh)});
                } else {
                    w.v("MicroMsg.MMSightAACMediaCodecRecorder", "perform encoding");
                    ByteBuffer byteBuffer = outputBuffers[this.nEh];
                    if (byteBuffer == null) {
                        throw new RuntimeException("encoderOutputBuffer " + this.nEh + " was null");
                    }
                    if ((this.nEa.flags & 2) != 0) {
                        w.v("MicroMsg.MMSightAACMediaCodecRecorder", "ignoring BUFFER_FLAG_CODEC_CONFIG,size: %s, %s", new Object[]{Integer.valueOf(this.nEa.size), Boolean.valueOf(aLq())});
                        if (aLq()) {
                            this.nEa.size = 0;
                        }
                    }
                    if (this.nEa.size != 0) {
                        if (!(this.nEl == null || this.nEl.fOV)) {
                            this.nEl.b(this.nDY.getOutputFormat());
                        }
                        byteBuffer.position(this.nEa.offset);
                        byteBuffer.limit(this.nEa.offset + this.nEa.size);
                        a(byteBuffer, this.nEa);
                    }
                    this.nDY.releaseOutputBuffer(this.nEh, false);
                    if ((this.nEa.flags & 4) != 0) {
                        break;
                    }
                }
            }
            if (z) {
                w.w("MicroMsg.MMSightAACMediaCodecRecorder", "do stop audio encoder");
                this.nDY.stop();
                this.nDY.release();
                this.nDY = null;
                return;
            }
            w.w("MicroMsg.MMSightAACMediaCodecRecorder", "reached end of stream unexpectedly");
        } catch (Exception e) {
            w.e("MicroMsg.MMSightAACMediaCodecRecorder", "drainEncoder error: %s", new Object[]{e.getMessage()});
        }
    }

    protected void a(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        if (this.nEl != null && (bufferInfo.flags & 4) == 0) {
            this.nEl.b(byteBuffer, bufferInfo);
        }
    }

    protected boolean aLq() {
        return false;
    }
}
