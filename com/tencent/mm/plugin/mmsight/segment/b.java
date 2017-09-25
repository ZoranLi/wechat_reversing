package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Point;
import com.tencent.mm.plugin.mmsight.segment.f.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class b implements f {
    private int frameCount = 0;
    private a nGt;
    private String nGu;
    private long nGv;
    private long nGw;
    private byte[] nGx = null;
    private int nGy;
    private boolean nfG = false;

    public final int k(String str, long j, long j2) {
        w.i("MicroMsg.FFMpegTranscodeDecoder", "initDecoder, srcFilePath: %s, start: %s, end: %s", new Object[]{str, Long.valueOf(j), Long.valueOf(j2)});
        this.nGu = str;
        this.nGv = j;
        this.nGw = j2;
        if (bg.mA(str)) {
            return -1;
        }
        long NA = bg.NA();
        int ffmpegOpenAndSeekFile = MP4MuxerJNI.ffmpegOpenAndSeekFile(str, ((double) j) * 1000.0d, ((double) j2) * 1000.0d);
        w.i("MicroMsg.FFMpegTranscodeDecoder", "ffmpegOpenAndSeekFile used %sms", new Object[]{Long.valueOf(bg.aB(NA))});
        return ffmpegOpenAndSeekFile;
    }

    public final void B(Runnable runnable) {
        w.i("MicroMsg.FFMpegTranscodeDecoder", "startDecodeBlockLoop");
        this.nfG = true;
        this.frameCount = 0;
        while (this.nfG) {
            long NA = bg.NA();
            this.nGx = MP4MuxerJNI.ffmpegGetNextVideoFrameData(this.nGx);
            w.d("MicroMsg.FFMpegTranscodeDecoder", "ffmpegGetNextVideoFrameData used %sms", new Object[]{Long.valueOf(bg.aB(NA))});
            boolean ffmpegCheckIfReachEndTimestamp = MP4MuxerJNI.ffmpegCheckIfReachEndTimestamp();
            if (this.nGx == null || ffmpegCheckIfReachEndTimestamp) {
                w.e("MicroMsg.FFMpegTranscodeDecoder", "ret buffer is null or reachEnd? %s", new Object[]{Boolean.valueOf(ffmpegCheckIfReachEndTimestamp)});
                this.nfG = false;
                runnable.run();
                return;
            }
            this.frameCount++;
            if ((this.nGy <= 1 || this.frameCount % this.nGy != 0) && this.nGt != null) {
                this.nGt.ay(this.nGx);
            }
        }
    }

    public final void a(a aVar) {
        this.nGt = aVar;
    }

    public final Point aLD() {
        return new Point(MP4MuxerJNI.ffmpegGetVideoWidth(), MP4MuxerJNI.ffmpegGetVideoHeight());
    }

    public final void stop() {
        w.i("MicroMsg.FFMpegTranscodeDecoder", "stop, start: %s", new Object[]{Boolean.valueOf(this.nfG)});
        this.nfG = false;
    }

    public final int aLE() {
        return 2;
    }

    public final void pH(int i) {
        w.i("MicroMsg.FFMpegTranscodeDecoder", "setFrameDropInterval: %s", new Object[]{Integer.valueOf(i)});
        this.nGy = i;
    }
}
