package com.tencent.mm.plugin.music.a.e;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Process;
import com.tencent.mm.compatible.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class e extends b {
    public int channels = 0;
    public long duration = 0;
    public AudioTrack ibN;
    private boolean nDu = true;
    public MediaCodec nUb;
    public String nUc;
    public boolean nUd = false;
    private Runnable nUe = new Runnable(this) {
        final /* synthetic */ e nUf;

        {
            this.nUf = r1;
        }

        public final void run() {
            w.i("MicroMsg.Music.MMPlayer", "starting...");
            Process.setThreadPriority(-19);
            if (bg.mA(this.nUf.nUc)) {
                w.e("MicroMsg.Music.MMPlayer", "source path is null");
                this.nUf.fW(false);
                return;
            }
            this.nUf.nzE = new MediaExtractor();
            try {
                this.nUf.nzE.setDataSource(this.nUf.nUc);
                MediaFormat mediaFormat = null;
                try {
                    int readSampleData;
                    MediaFormat trackFormat;
                    w.e("MicroMsg.Music.MMPlayer", "tractCount is %d", new Object[]{Integer.valueOf(this.nUf.nzE.getTrackCount())});
                    for (int i = 0; i < readSampleData; i++) {
                        trackFormat = this.nUf.nzE.getTrackFormat(i);
                        this.nUf.nzA = trackFormat.getString("mime");
                        if (!bg.mA(this.nUf.nzA) && this.nUf.nzA.startsWith("audio/")) {
                            mediaFormat = trackFormat;
                            break;
                        }
                    }
                    if (mediaFormat == null) {
                        w.e("MicroMsg.Music.MMPlayer", "format is null");
                        this.nUf.fW(true);
                        this.nUf.aOf();
                        return;
                    }
                    w.i("MicroMsg.Music.MMPlayer", "format:%s", new Object[]{mediaFormat});
                    this.nUf.sampleRate = mediaFormat.getInteger("sample-rate");
                    this.nUf.channels = mediaFormat.getInteger("channel-count");
                    this.nUf.duration = mediaFormat.getLong("durationUs");
                    try {
                        this.nUf.nUb = MediaCodec.createDecoderByType(this.nUf.nzA);
                        this.nUf.nUb.configure(mediaFormat, null, null, 0);
                        this.nUf.nUb.start();
                        ByteBuffer[] inputBuffers = this.nUf.nUb.getInputBuffers();
                        ByteBuffer[] outputBuffers = this.nUf.nUb.getOutputBuffers();
                        w.i("MicroMsg.Music.MMPlayer", "Track info: extractorFormat: %s mime: %s sampleRate: %s channels: %s duration: %s", new Object[]{mediaFormat, this.nUf.nzA, Integer.valueOf(this.nUf.sampleRate), Integer.valueOf(this.nUf.channels), Long.valueOf(this.nUf.duration)});
                        this.nUf.nzE.selectTrack(0);
                        BufferInfo bufferInfo = new BufferInfo();
                        Object obj = null;
                        int i2 = 0;
                        this.nUf.nTV.nUi = 3;
                        this.nUf.onStart();
                        ByteBuffer[] byteBufferArr = outputBuffers;
                        Object obj2 = null;
                        while (obj == null && i2 < 50) {
                            this.nUf.aOj();
                            if (!this.nUf.aOc()) {
                                break;
                            }
                            Object obj3;
                            int dequeueOutputBuffer;
                            int i3;
                            ByteBuffer byteBuffer;
                            byte[] bArr;
                            e eVar;
                            i2++;
                            if (obj2 == null) {
                                int dequeueInputBuffer = this.nUf.nUb.dequeueInputBuffer(1000);
                                if (dequeueInputBuffer >= 0) {
                                    readSampleData = this.nUf.nzE.readSampleData(inputBuffers[dequeueInputBuffer], 0);
                                    if (readSampleData < 0) {
                                        w.e("MicroMsg.Music.MMPlayer", "saw input EOS. Stopping playback");
                                        obj3 = 1;
                                        readSampleData = 0;
                                    } else {
                                        try {
                                            this.nUf.presentationTimeUs = this.nUf.nzE.getSampleTime();
                                            this.nUf.qk(this.nUf.duration == 0 ? 0 : (int) ((100 * this.nUf.presentationTimeUs) / this.nUf.duration));
                                            obj3 = obj2;
                                        } catch (Throwable e) {
                                            w.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "error", new Object[0]);
                                            this.nUf.fW(true);
                                        } finally {
                                            this.nUf.aOf();
                                            this.nUf.aOg();
                                            this.nUf.aOh();
                                            this.nUf.nUc = null;
                                            this.nUf.nzA = null;
                                            this.nUf.sampleRate = 0;
                                            this.nUf.channels = 0;
                                            this.nUf.presentationTimeUs = 0;
                                            this.nUf.duration = 0;
                                        }
                                    }
                                    this.nUf.nUb.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, this.nUf.presentationTimeUs, obj3 != null ? 4 : 0);
                                    if (obj3 == null) {
                                        this.nUf.nzE.advance();
                                    }
                                    dequeueOutputBuffer = this.nUf.nUb.dequeueOutputBuffer(bufferInfo, 1000);
                                    if (dequeueOutputBuffer >= 0) {
                                        if (bufferInfo.size <= 0) {
                                            i3 = 0;
                                        } else {
                                            i3 = i2;
                                        }
                                        byteBuffer = byteBufferArr[dequeueOutputBuffer];
                                        bArr = new byte[bufferInfo.size];
                                        byteBuffer.get(bArr);
                                        byteBuffer.clear();
                                        if (bArr.length > 0) {
                                            if (this.nUf.ibN == null) {
                                                eVar = this.nUf;
                                                w.i("MicroMsg.Music.MMPlayer", "createAudioTrack");
                                                readSampleData = eVar.channels != 1 ? 4 : 12;
                                                eVar.ibN = new c(3, eVar.sampleRate, readSampleData, 2, AudioTrack.getMinBufferSize(eVar.sampleRate, readSampleData, 2));
                                                if (eVar.ibN == null && eVar.ibN.getState() == 1) {
                                                    obj2 = 1;
                                                } else {
                                                    w.e("MicroMsg.Music.MMPlayer", "audio track not initialized");
                                                    obj2 = null;
                                                }
                                                if (obj2 != null) {
                                                    w.e("MicroMsg.Music.MMPlayer", "audio track not initialized");
                                                    this.nUf.fW(true);
                                                    return;
                                                }
                                                this.nUf.ibN.play();
                                            }
                                            this.nUf.ibN.write(bArr, 0, bArr.length);
                                            this.nUf.nUd = true;
                                        }
                                        this.nUf.nUb.releaseOutputBuffer(dequeueOutputBuffer, false);
                                        if ((bufferInfo.flags & 4) == 0) {
                                            w.e("MicroMsg.Music.MMPlayer", "saw output EOS.");
                                            obj2 = 1;
                                        } else {
                                            obj2 = obj;
                                        }
                                        i2 = i3;
                                        obj = obj2;
                                        obj2 = obj3;
                                    } else if (dequeueOutputBuffer == -3) {
                                        outputBuffers = this.nUf.nUb.getOutputBuffers();
                                        w.i("MicroMsg.Music.MMPlayer", "output buffers have changed.");
                                        byteBufferArr = outputBuffers;
                                        obj2 = obj3;
                                    } else if (dequeueOutputBuffer != -2) {
                                        trackFormat = this.nUf.nUb.getOutputFormat();
                                        w.i("MicroMsg.Music.MMPlayer", "output format has changed to " + trackFormat);
                                        this.nUf.sampleRate = trackFormat.getInteger("sample-rate");
                                        this.nUf.channels = trackFormat.getInteger("channel-count");
                                        this.nUf.aOh();
                                        obj2 = obj3;
                                    } else {
                                        w.i("MicroMsg.Music.MMPlayer", "dequeueOutputBuffer returned " + dequeueOutputBuffer);
                                        obj2 = obj3;
                                    }
                                } else {
                                    w.e("MicroMsg.Music.MMPlayer", "inputBufIndex " + dequeueInputBuffer);
                                }
                            }
                            obj3 = obj2;
                            dequeueOutputBuffer = this.nUf.nUb.dequeueOutputBuffer(bufferInfo, 1000);
                            if (dequeueOutputBuffer >= 0) {
                                if (bufferInfo.size <= 0) {
                                    i3 = i2;
                                } else {
                                    i3 = 0;
                                }
                                byteBuffer = byteBufferArr[dequeueOutputBuffer];
                                bArr = new byte[bufferInfo.size];
                                byteBuffer.get(bArr);
                                byteBuffer.clear();
                                if (bArr.length > 0) {
                                    if (this.nUf.ibN == null) {
                                        eVar = this.nUf;
                                        w.i("MicroMsg.Music.MMPlayer", "createAudioTrack");
                                        if (eVar.channels != 1) {
                                        }
                                        eVar.ibN = new c(3, eVar.sampleRate, readSampleData, 2, AudioTrack.getMinBufferSize(eVar.sampleRate, readSampleData, 2));
                                        if (eVar.ibN == null) {
                                        }
                                        w.e("MicroMsg.Music.MMPlayer", "audio track not initialized");
                                        obj2 = null;
                                        if (obj2 != null) {
                                            this.nUf.ibN.play();
                                        } else {
                                            w.e("MicroMsg.Music.MMPlayer", "audio track not initialized");
                                            this.nUf.fW(true);
                                            return;
                                        }
                                    }
                                    this.nUf.ibN.write(bArr, 0, bArr.length);
                                    this.nUf.nUd = true;
                                }
                                this.nUf.nUb.releaseOutputBuffer(dequeueOutputBuffer, false);
                                if ((bufferInfo.flags & 4) == 0) {
                                    obj2 = obj;
                                } else {
                                    w.e("MicroMsg.Music.MMPlayer", "saw output EOS.");
                                    obj2 = 1;
                                }
                                i2 = i3;
                                obj = obj2;
                                obj2 = obj3;
                            } else if (dequeueOutputBuffer == -3) {
                                outputBuffers = this.nUf.nUb.getOutputBuffers();
                                w.i("MicroMsg.Music.MMPlayer", "output buffers have changed.");
                                byteBufferArr = outputBuffers;
                                obj2 = obj3;
                            } else if (dequeueOutputBuffer != -2) {
                                w.i("MicroMsg.Music.MMPlayer", "dequeueOutputBuffer returned " + dequeueOutputBuffer);
                                obj2 = obj3;
                            } else {
                                trackFormat = this.nUf.nUb.getOutputFormat();
                                w.i("MicroMsg.Music.MMPlayer", "output format has changed to " + trackFormat);
                                this.nUf.sampleRate = trackFormat.getInteger("sample-rate");
                                this.nUf.channels = trackFormat.getInteger("channel-count");
                                this.nUf.aOh();
                                obj2 = obj3;
                            }
                        }
                        boolean z = (this.nUf.duration / 1000) - (this.nUf.presentationTimeUs / 1000) < 2000;
                        if (i2 >= 50) {
                            w.i("MicroMsg.Music.MMPlayer", "onError, noOutputCounter:%d", new Object[]{Integer.valueOf(i2)});
                            this.nUf.fW(true);
                        } else {
                            w.i("MicroMsg.Music.MMPlayer", "onStop, isComplete:%b", new Object[]{Boolean.valueOf(z)});
                            this.nUf.fX(z);
                        }
                        this.nUf.aOf();
                        this.nUf.aOg();
                        this.nUf.aOh();
                        this.nUf.nUc = null;
                        this.nUf.nzA = null;
                        this.nUf.sampleRate = 0;
                        this.nUf.channels = 0;
                        this.nUf.presentationTimeUs = 0;
                        this.nUf.duration = 0;
                        w.i("MicroMsg.Music.MMPlayer", "stopping...");
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.Music.MMPlayer", e2, "createDecoderByType", new Object[0]);
                        this.nUf.fW(true);
                        this.nUf.aOf();
                        this.nUf.aOg();
                    }
                } catch (Throwable e22) {
                    w.printErrStackTrace("MicroMsg.Music.MMPlayer", e22, "get media format from media extractor", new Object[0]);
                }
            } catch (Throwable e222) {
                w.printErrStackTrace("MicroMsg.Music.MMPlayer", e222, "set extractor data source", new Object[0]);
                this.nUf.fW(true);
            }
        }
    };
    public String nzA = null;
    public MediaExtractor nzE;
    public long presentationTimeUs = 0;
    public int sampleRate = 0;

    public final void BC(String str) {
        this.nUc = str;
    }

    public final void aOf() {
        try {
            if (this.nzE != null) {
                this.nzE.release();
                this.nzE = null;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "releaseMediaExtractor", new Object[0]);
        }
    }

    public final void aOg() {
        try {
            if (this.nUb != null) {
                this.nUb.stop();
                this.nUb.release();
                this.nUb = null;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "releaseMediaCodec", new Object[0]);
        }
    }

    public final void aOh() {
        try {
            if (this.ibN != null) {
                this.ibN.flush();
                this.ibN.release();
                this.ibN = null;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "releaseAudioTrack", new Object[0]);
        }
    }

    public final int aOd() {
        return (int) (this.presentationTimeUs / 1000);
    }

    public final int getDuration() {
        return (int) (this.duration / 1000);
    }

    public final void play() {
        w.i("MicroMsg.Music.MMPlayer", "play");
        if (!aOc()) {
            this.nDu = false;
            com.tencent.mm.sdk.f.e.post(this.nUe, "music_player");
        } else if (aOc() && this.nTV.aOk()) {
            this.nTV.nUi = 3;
            aOi();
        }
    }

    private synchronized void aOi() {
        w.i("MicroMsg.Music.MMPlayer", "sync notify");
        try {
            notify();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "syncNotify", new Object[0]);
        }
    }

    public final void stop() {
        w.i("MicroMsg.Music.MMPlayer", "stop");
        this.nDu = true;
        if (this.nTV.aOk()) {
            aOi();
        }
    }

    public final void pause() {
        w.i("MicroMsg.Music.MMPlayer", "pause");
        if (aOc()) {
            this.nTV.nUi = 2;
        }
    }

    public final void seek(long j) {
        this.nzE.seekTo(1000 * j, 2);
    }

    public final synchronized void aOj() {
        while (aOc() && this.nTV.aOk()) {
            try {
                w.i("MicroMsg.Music.MMPlayer", "wait play");
                wait();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Music.MMPlayer", e, "waitPlay", new Object[0]);
            }
        }
    }

    public final boolean isPlaying() {
        return this.nTV.isPlaying();
    }

    public final boolean aOc() {
        return !this.nDu;
    }

    protected final void fW(boolean z) {
        this.nUd = false;
        this.nTV.nUi = 4;
        this.nDu = true;
        super.fW(z);
    }

    protected final void fX(boolean z) {
        this.nTV.nUi = 4;
        this.nDu = true;
        super.fX(z);
    }

    public final String aOe() {
        return this.nzA;
    }
}
