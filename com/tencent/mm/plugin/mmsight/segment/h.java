package com.tencent.mm.plugin.mmsight.segment;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.HandlerThread;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class h {
    public MediaCodec nGH;
    public MediaCodec nGI;
    MediaFormat nGJ;
    MediaFormat nGK;
    VideoTransPara nGL;
    boolean nGM = true;
    List<byte[]> nGN = null;
    private boolean nGO = false;
    private boolean nGP = false;
    private byte[] nGQ;
    private HandlerThread nGR = null;
    private ae nGS = null;
    private long nGv;
    private long nGw;
    String nzA = null;
    private MediaExtractor nzE;

    public h(MediaExtractor mediaExtractor, MediaFormat mediaFormat, long j, long j2, VideoTransPara videoTransPara) {
        this.nzE = mediaExtractor;
        this.nGJ = mediaFormat;
        this.nGv = j;
        this.nGw = j2;
        this.nGL = videoTransPara;
        this.nzA = mediaFormat.getString("mime");
        this.nGN = new ArrayList();
        w.i("MicroMsg.MediaCodecAACTranscoder", "create MediaCodecAACTranscoder, startTimeMs: %s, endTimeMs: %s, mime: %s, srcMediaFormat: %s, para: %s", new Object[]{Long.valueOf(j), Long.valueOf(j2), this.nzA, mediaFormat, videoTransPara});
    }

    public final void aLK() {
        this.nGO = false;
        this.nGP = false;
        while (this.nGH != null && this.nzE != null) {
            try {
                ByteBuffer[] inputBuffers = this.nGH.getInputBuffers();
                int dequeueInputBuffer = this.nGH.dequeueInputBuffer(20000);
                if (dequeueInputBuffer < 0) {
                    w.d("MicroMsg.MediaCodecAACTranscoder", "decoder no input buffer available, drain first");
                    aLL();
                }
                if (dequeueInputBuffer >= 0) {
                    boolean z;
                    w.d("MicroMsg.MediaCodecAACTranscoder", "decoderInputBufferIndex: %d", new Object[]{Integer.valueOf(dequeueInputBuffer)});
                    ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                    byteBuffer.clear();
                    byteBuffer.position(0);
                    int readSampleData = this.nzE.readSampleData(byteBuffer, 0);
                    long sampleTime = this.nzE.getSampleTime();
                    this.nzE.advance();
                    w.d("MicroMsg.MediaCodecAACTranscoder", "sampleSize: %s, pts: %s", new Object[]{Integer.valueOf(readSampleData), Long.valueOf(sampleTime)});
                    if (sampleTime >= this.nGw * 1000 || sampleTime <= 0 || readSampleData <= 0) {
                        w.i("MicroMsg.MediaCodecAACTranscoder", "reach end time, send EOS and try delay stop decoder");
                        this.nGP = true;
                        af.f(new Runnable(this) {
                            final /* synthetic */ h nGT;

                            {
                                this.nGT = r1;
                            }

                            public final void run() {
                                try {
                                    if (this.nGT.nGH != null) {
                                        w.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop decoder");
                                        this.nGT.nGH.stop();
                                        this.nGT.nGH.release();
                                        this.nGT.nGH = null;
                                    }
                                } catch (Exception e) {
                                    w.e("MicroMsg.MediaCodecAACTranscoder", "delayStopDecoder error: %s", new Object[]{e.getMessage()});
                                }
                            }
                        }, 500);
                        z = true;
                    } else {
                        z = false;
                    }
                    if (this.nGH == null) {
                        return;
                    }
                    if (z) {
                        w.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
                        this.nGH.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, 4);
                    } else {
                        this.nGH.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, sampleTime, 0);
                    }
                }
                aLL();
                if (this.nGP && this.nGI == null) {
                    return;
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e, "startTranscodeBlockLoop error: %s", new Object[]{e.getMessage()});
                return;
            }
        }
        w.e("MicroMsg.MediaCodecAACTranscoder", "startTranscodeBlockLoop error");
    }

    private void aLL() {
        if (this.nGH != null) {
            try {
                ByteBuffer[] outputBuffers = this.nGH.getOutputBuffers();
                BufferInfo bufferInfo = new BufferInfo();
                ByteBuffer[] byteBufferArr = outputBuffers;
                while (true) {
                    int dequeueOutputBuffer = this.nGH.dequeueOutputBuffer(bufferInfo, 20000);
                    w.d("MicroMsg.MediaCodecAACTranscoder", "decoderOutputBufferIndex: %s", new Object[]{Integer.valueOf(dequeueOutputBuffer)});
                    if (dequeueOutputBuffer == -1) {
                        w.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
                        return;
                    } else if (dequeueOutputBuffer == -3) {
                        byteBufferArr = this.nGH.getOutputBuffers();
                    } else if (dequeueOutputBuffer == -2) {
                        this.nGJ = this.nGH.getOutputFormat();
                        w.i("MicroMsg.MediaCodecAACTranscoder", "srcMediaFormat change: %s", new Object[]{this.nGJ});
                    } else if (dequeueOutputBuffer < 0) {
                        w.e("MicroMsg.MediaCodecAACTranscoder", "unexpected decoderOutputBufferIndex: %s", new Object[]{Integer.valueOf(dequeueOutputBuffer)});
                    } else {
                        w.v("MicroMsg.MediaCodecAACTranscoder", "perform decoding");
                        ByteBuffer byteBuffer = byteBufferArr[dequeueOutputBuffer];
                        if (byteBuffer == null) {
                            w.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve decoderOutputBuffer is null!!");
                            return;
                        }
                        if ((bufferInfo.flags & 2) != 0) {
                            w.e("MicroMsg.MediaCodecAACTranscoder", "ignore BUFFER_FLAG_CODEC_CONFIG");
                            bufferInfo.size = 0;
                        }
                        if (bufferInfo.size > 0) {
                            byteBuffer.position(bufferInfo.offset);
                            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            a(byteBuffer, bufferInfo, (bufferInfo.flags & 4) != 0);
                        }
                        this.nGH.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((bufferInfo.flags & 4) != 0) {
                            break;
                        }
                    }
                }
                w.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
                if (this.nGH != null) {
                    this.nGH.stop();
                    this.nGH.release();
                    this.nGH = null;
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e, "drainDecoder error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    private void a(ByteBuffer byteBuffer, BufferInfo bufferInfo, boolean z) {
        if (byteBuffer != null) {
            w.d("MicroMsg.MediaCodecAACTranscoder", "processDecodeBuffer, EOS: %s, finishGetAllInputAACData: %s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(this.nGP)});
            if (this.nGM) {
                if (!this.nGO) {
                    aLM();
                    this.nGO = true;
                }
                if (this.nGQ == null) {
                    this.nGQ = new byte[byteBuffer.remaining()];
                    byteBuffer.get(this.nGQ, 0, byteBuffer.remaining());
                }
                a(this.nGQ, bufferInfo.presentationTimeUs, z);
                return;
            }
            Object obj = new byte[byteBuffer.remaining()];
            byteBuffer.get(obj, 0, byteBuffer.remaining());
            this.nGN.add(obj);
            if (this.nGP || z) {
                try {
                    this.nGH.stop();
                    this.nGH.release();
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e, "", new Object[0]);
                }
                aLM();
                this.nGO = true;
                int i = 0;
                for (byte[] bArr : this.nGN) {
                    boolean z2;
                    long j = bufferInfo.presentationTimeUs;
                    if (i >= this.nGN.size() - 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    a(bArr, j, z2);
                    i++;
                }
            }
        }
    }

    private void aLM() {
        if (this.nGI == null || !this.nGM || this.nGO) {
            try {
                this.nGK = new MediaFormat();
                this.nGK.setString("mime", "audio/mp4a-latm");
                this.nGK.setInteger("aac-profile", 2);
                this.nGK.setInteger("sample-rate", this.nGL.audioSampleRate);
                this.nGK.setInteger("channel-count", 1);
                this.nGK.setInteger(FFmpegMetadataRetriever.METADATA_KEY_VARIANT_BITRATE, this.nGL.hzL);
                this.nGK.setInteger("max-input-size", 16384);
                this.nGI = MediaCodec.createEncoderByType(this.nzA);
                this.nGI.configure(this.nGK, null, null, 1);
                this.nGI.start();
                w.i("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, create new encoder");
                return;
            } catch (Exception e) {
                w.e("MicroMsg.MediaCodecAACTranscoder", "checkInitAndStartEncoder, not canEncodeDecodeBothExist, error: %s", new Object[]{e.getMessage()});
                return;
            }
        }
        this.nGH.start();
    }

    private void a(byte[] bArr, long j, boolean z) {
        if (this.nGI != null && bArr != null) {
            ByteBuffer[] inputBuffers = this.nGI.getInputBuffers();
            int dequeueInputBuffer = this.nGI.dequeueInputBuffer(20000);
            if (dequeueInputBuffer < 0) {
                w.d("MicroMsg.MediaCodecAACTranscoder", "encoder no input buffer available, drain first");
                aLz();
            }
            if (dequeueInputBuffer >= 0) {
                int i;
                ByteBuffer byteBuffer = inputBuffers[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.position(0);
                byteBuffer.put(bArr);
                if (z) {
                    w.i("MicroMsg.MediaCodecAACTranscoder", "last, send EOS and try delay stop encoder");
                    i = 1;
                    af.f(new Runnable(this) {
                        final /* synthetic */ h nGT;

                        {
                            this.nGT = r1;
                        }

                        public final void run() {
                            try {
                                if (this.nGT.nGI != null) {
                                    w.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop encoder");
                                    this.nGT.nGI.stop();
                                    this.nGT.nGI.release();
                                    this.nGT.nGI = null;
                                }
                            } catch (Exception e) {
                                w.e("MicroMsg.MediaCodecAACTranscoder", "delayStopEncoder error: %s", new Object[]{e.getMessage()});
                            }
                        }
                    }, 500);
                } else {
                    i = 0;
                }
                if (this.nGI == null) {
                    return;
                }
                if (i != 0) {
                    w.i("MicroMsg.MediaCodecAACTranscoder", "EOS received in sendAudioToEncoder");
                    this.nGI.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j, 4);
                } else {
                    this.nGI.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j, 0);
                }
            }
            aLz();
        }
    }

    private void aLz() {
        if (this.nGI != null) {
            try {
                ByteBuffer[] outputBuffers = this.nGI.getOutputBuffers();
                BufferInfo bufferInfo = new BufferInfo();
                while (true) {
                    int dequeueOutputBuffer = this.nGI.dequeueOutputBuffer(bufferInfo, 20000);
                    w.d("MicroMsg.MediaCodecAACTranscoder", "encoderOutputBufferIndex: %s", new Object[]{Integer.valueOf(dequeueOutputBuffer)});
                    if (dequeueOutputBuffer == -1) {
                        w.d("MicroMsg.MediaCodecAACTranscoder", "no output available, break");
                        return;
                    } else if (dequeueOutputBuffer == -3) {
                        outputBuffers = this.nGI.getOutputBuffers();
                    } else if (dequeueOutputBuffer == -2) {
                        this.nGK = this.nGI.getOutputFormat();
                        w.i("MicroMsg.MediaCodecAACTranscoder", "dstMediaFormat change: %s", new Object[]{this.nGK});
                    } else if (dequeueOutputBuffer < 0) {
                        w.e("MicroMsg.MediaCodecAACTranscoder", "unexpected encoderOutputBufferIndex: %s", new Object[]{Integer.valueOf(dequeueOutputBuffer)});
                    } else {
                        w.v("MicroMsg.MediaCodecAACTranscoder", "perform encoding");
                        ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                        if (byteBuffer == null) {
                            w.e("MicroMsg.MediaCodecAACTranscoder", "ERROR, retrieve encoderOutputBuffer is null!!");
                            return;
                        }
                        if (bufferInfo.size > 0) {
                            byteBuffer.position(bufferInfo.offset);
                            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            if (byteBuffer != null) {
                                MP4MuxerJNI.writeAACData(0, byteBuffer, bufferInfo.size);
                            }
                        }
                        this.nGI.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((bufferInfo.flags & 4) != 0) {
                            break;
                        }
                    }
                }
                w.i("MicroMsg.MediaCodecAACTranscoder", "receive EOS!");
                if (this.nGI != null) {
                    this.nGI.stop();
                    this.nGI.release();
                    this.nGI = null;
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MediaCodecAACTranscoder", e, "drainEncoder error: %s", new Object[]{e.getMessage()});
            }
        }
    }
}
