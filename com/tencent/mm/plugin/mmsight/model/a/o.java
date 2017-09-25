package com.tencent.mm.plugin.mmsight.model.a;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.nio.ByteBuffer;

@TargetApi(18)
@Deprecated
public final class o implements e {
    boolean fOV;
    private MediaMuxer nFG;
    private int nFH;
    private int nFI;
    long nFJ;

    public final boolean aLo() {
        return false;
    }

    public final synchronized void a(MediaFormat mediaFormat) {
        try {
            if (this.nFG != null && this.nFH == -1) {
                this.nFH = this.nFG.addTrack(mediaFormat);
                w.i("MicroMsg.MMSightSystemMediaMuxer", "addX264Track, x264TrackIndex: %s", new Object[]{Integer.valueOf(this.nFH)});
                if (!(this.fOV || this.nFH == -1 || this.nFI == -1)) {
                    w.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
                    this.nFG.start();
                    this.fOV = true;
                }
            }
        } catch (Exception e) {
            w.e("MicroMsg.MMSightSystemMediaMuxer", "addX264Track error: %s", new Object[]{e.getMessage()});
        }
    }

    public final synchronized void b(MediaFormat mediaFormat) {
        try {
            if (this.nFG != null && this.nFI == -1) {
                this.nFI = this.nFG.addTrack(mediaFormat);
                w.i("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack, aacTrackIndex: %s", new Object[]{Integer.valueOf(this.nFI)});
                if (!(this.fOV || this.nFI == -1 || this.nFH == -1)) {
                    w.i("MicroMsg.MMSightSystemMediaMuxer", "start!");
                    this.nFG.start();
                    this.fOV = true;
                }
            }
        } catch (Exception e) {
            w.e("MicroMsg.MMSightSystemMediaMuxer", "addAACTrack error: %s", new Object[]{e.getMessage()});
        }
    }

    public final synchronized void b(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        try {
            if (!(this.nFG == null || this.nFI == -1 || !this.fOV || byteBuffer == null || bufferInfo == null)) {
                long j = bufferInfo.presentationTimeUs;
                bufferInfo.presentationTimeUs = (System.nanoTime() - this.nFJ) / 1000;
                long NA = bg.NA();
                this.nFG.writeSampleData(this.nFI, byteBuffer, bufferInfo);
                w.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[]{Integer.valueOf(bufferInfo.size), Long.valueOf(bg.aB(NA)), Long.valueOf(j), Long.valueOf(bufferInfo.presentationTimeUs)});
            }
        } catch (Exception e) {
            w.e("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData error: %s", new Object[]{e.getMessage()});
        }
    }

    public final synchronized void c(ByteBuffer byteBuffer, BufferInfo bufferInfo) {
        int i = 1;
        synchronized (this) {
            try {
                if (!(this.nFG == null || this.nFH == -1 || !this.fOV)) {
                    int i2 = byteBuffer != null ? 1 : 0;
                    if (bufferInfo == null) {
                        i = 0;
                    }
                    if ((i & i2) != 0) {
                        long j = bufferInfo.presentationTimeUs;
                        bufferInfo.presentationTimeUs = (System.nanoTime() - this.nFJ) / 1000;
                        bufferInfo.flags = 1;
                        long NA = bg.NA();
                        this.nFG.writeSampleData(this.nFH, byteBuffer, bufferInfo);
                        w.v("MicroMsg.MMSightSystemMediaMuxer", "writeAACSampleData size: %s used %dms oldpts %s fix pts: %s", new Object[]{Integer.valueOf(bufferInfo.size), Long.valueOf(bg.aB(NA)), Long.valueOf(j), Long.valueOf(bufferInfo.presentationTimeUs)});
                    }
                }
            } catch (Exception e) {
                w.e("MicroMsg.MMSightSystemMediaMuxer", "writeX264SampleData error: %s", new Object[]{e.getMessage()});
            }
        }
    }
}
