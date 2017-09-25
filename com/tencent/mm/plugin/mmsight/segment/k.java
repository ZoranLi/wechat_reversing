package com.tencent.mm.plugin.mmsight.segment;

import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.media.Image;
import android.media.Image.Plane;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.nio.ByteBuffer;

@TargetApi(21)
public final class k extends j {
    public static String TAG = "MicroMsg.MediaCodecTranscodeDecoder21";

    public k(MediaExtractor mediaExtractor, MediaFormat mediaFormat, int i) {
        super(mediaExtractor, mediaFormat, i);
        w.i(TAG, "init ");
    }

    protected final int a(MediaCodecInfo mediaCodecInfo, String str) {
        w.i(TAG, "selectColorFormat, mimeType: %s, codecInfo: %s", new Object[]{str, mediaCodecInfo});
        long NA = bg.NA();
        CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
        w.i(TAG, "getCapabilitiesForType used %sms", new Object[]{Long.valueOf(bg.aB(NA))});
        w.i(TAG, "color format length: %s", new Object[]{Integer.valueOf(capabilitiesForType.colorFormats.length)});
        int i = 0;
        for (int i2 : capabilitiesForType.colorFormats) {
            w.i(TAG, "capabilities colorFormat: %s", new Object[]{Integer.valueOf(i2)});
            if (pI(i2) && (i2 > i || i2 == 2135033992)) {
                i = i2;
            }
        }
        w.i(TAG, "codec: %s, colorFormat: %s", new Object[]{mediaCodecInfo.getName(), Integer.valueOf(i)});
        return i;
    }

    protected final boolean pI(int i) {
        switch (i) {
            case 2135033992:
                return true;
            default:
                return false;
        }
    }

    protected final boolean aLO() {
        if (this.nzG == null) {
            w.e(TAG, "drainDecoder, decoder is null");
            return true;
        }
        int dequeueOutputBuffer = this.nzG.dequeueOutputBuffer(this.nFV, 60000);
        w.i(TAG, "outputBufferIndex-->" + dequeueOutputBuffer);
        while (dequeueOutputBuffer != -1) {
            if (dequeueOutputBuffer == -3) {
                w.i(TAG, "decoder output buffers changed");
            } else if (dequeueOutputBuffer == -2) {
                this.nGJ = this.nzG.getOutputFormat();
                w.i(TAG, "decoder output format changed: " + this.nGJ);
            } else if (dequeueOutputBuffer < 0) {
                w.w(TAG, "unexpected result from decoder.dequeueOutputBuffer: " + dequeueOutputBuffer);
            } else {
                w.v(TAG, "perform decoding");
                long NA = bg.NA();
                byte[] a = a(this.nzG.getOutputImage(dequeueOutputBuffer));
                w.v(TAG, "perform decoding costImage %s", new Object[]{Long.valueOf(bg.aB(NA))});
                if (a == null) {
                    break;
                } else if (a.length != 0) {
                    BufferInfo bufferInfo = this.nFV;
                    if (a == null) {
                        w.e(TAG, "processDecodeOutputBuffer error! byteBuffer is null");
                    } else {
                        w.i(TAG, "processDecodeOutputBuffer, byteBuffer: %s, bufferInfo: %s, size: %d", new Object[]{a, bufferInfo, Integer.valueOf(bufferInfo.size)});
                        this.nGJ = this.nzG.getOutputFormat();
                        if (this.nGt != null) {
                            this.nGt.ay(a);
                        }
                    }
                    this.nzG.releaseOutputBuffer(dequeueOutputBuffer, false);
                    long j = this.nFV.presentationTimeUs;
                    if (this.nGw != 1 && j >= this.nGw * 1000) {
                        w.e(TAG, "exceed endTimeMs");
                        return true;
                    } else if ((this.nFV.flags & 4) == 0) {
                        return false;
                    } else {
                        w.i(TAG, "receive end of stream");
                        try {
                            this.nzG.stop();
                            this.nzG.release();
                            this.nzG = null;
                            return true;
                        } catch (Exception e) {
                            w.e(TAG, "stop and release decoder error: %s", new Object[]{e.getMessage()});
                            return true;
                        }
                    }
                } else {
                    this.nzG.releaseOutputBuffer(dequeueOutputBuffer, false);
                }
            }
            dequeueOutputBuffer = this.nzG.dequeueOutputBuffer(this.nFV, 60000);
            if (dequeueOutputBuffer < 0) {
                break;
            }
        }
        w.i(TAG, "no output from decoder available, break");
        return false;
    }

    public final int aLE() {
        return 2;
    }

    private static byte[] a(Image image) {
        int i;
        int format = image.getFormat();
        int width = image.getWidth();
        int height = image.getHeight();
        int i2 = 0;
        Plane[] planes = image.getPlanes();
        w.i(TAG, "planes len %d, datalen: %s width %d height %d format %d", new Object[]{Integer.valueOf(planes.length), Integer.valueOf(((width * height) * ImageFormat.getBitsPerPixel(format)) / 8), Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(format)});
        byte[] h = j.nEA.h(Integer.valueOf(i));
        format = 0;
        while (format < planes.length) {
            ByteBuffer buffer = planes[format].getBuffer();
            int rowStride = planes[format].getRowStride();
            int pixelStride = planes[format].getPixelStride();
            int i3 = format == 0 ? width : width / 2;
            i = format == 0 ? height : height / 2;
            w.v(TAG, "row planes rowStride %d w %d h %d pixelStride %d", new Object[]{Integer.valueOf(rowStride), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(pixelStride)});
            byte[] h2 = j.nEA.h(Integer.valueOf(rowStride));
            for (int i4 = 0; i4 < i; i4++) {
                int bitsPerPixel = ImageFormat.getBitsPerPixel(35) / 8;
                if (pixelStride == bitsPerPixel) {
                    bitsPerPixel *= i3;
                    buffer.get(h, i2, bitsPerPixel);
                    if (i - i4 != 1) {
                        buffer.position((buffer.position() + rowStride) - bitsPerPixel);
                    }
                    i2 += bitsPerPixel;
                } else {
                    if (i - i4 == 1) {
                        buffer.get(h2, 0, (width - pixelStride) + 1);
                    } else {
                        buffer.get(h2, 0, rowStride);
                    }
                    bitsPerPixel = 0;
                    while (bitsPerPixel < i3) {
                        int i5 = i2 + 1;
                        h[i2] = h2[bitsPerPixel * pixelStride];
                        bitsPerPixel++;
                        i2 = i5;
                    }
                }
            }
            j.nEA.x(h2);
            format++;
        }
        return h;
    }
}
