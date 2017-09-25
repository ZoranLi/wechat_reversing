package com.tencent.mm.plugin.s;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.view.Surface;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.nio.ByteBuffer;

public final class k extends h {
    private int hTj;
    private int hTk;
    public Surface nAg;
    boolean nAh = false;
    private boolean nAi = false;
    public boolean nAj = false;
    long nAk = -1;

    public k(g gVar, ae aeVar) {
        super(gVar, aeVar);
    }

    final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, BufferInfo bufferInfo) {
        w.d("MicroMsg.VideoTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d", aKs(), Integer.valueOf(this.state), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i));
        if (d.pr(this.state)) {
            w.i("MicroMsg.VideoTrackDataSource", "%s video track flush surface", aKs());
            mediaCodec.releaseOutputBuffer(i, true);
            setState(4);
            return true;
        } else if (d.pq(this.state)) {
            w.d("MicroMsg.VideoTrackDataSource", "%s start to handle precision seek[%d, %d] diff[%d]", aKs(), Long.valueOf(bufferInfo.presentationTimeUs / 1000), Long.valueOf(j), Long.valueOf(j - (bufferInfo.presentationTimeUs / 1000)));
            if ((j - (bufferInfo.presentationTimeUs / 1000) <= 30 ? 1 : null) != null) {
                w.i("MicroMsg.VideoTrackDataSource", "%s precision seek done to surface", aKs());
                mediaCodec.releaseOutputBuffer(i, true);
                if (this.nAi) {
                    setState(7);
                    this.nAi = false;
                }
                this.nAi = true;
            } else {
                mediaCodec.releaseOutputBuffer(i, false);
            }
            return true;
        } else if (d.ps(this.state)) {
            long elapsedRealtime = ((bufferInfo.presentationTimeUs / 1000) - j) - (SystemClock.elapsedRealtime() - j2);
            w.d("MicroMsg.VideoTrackDataSource", "%s earlyMs[%d] time[%d, %d, %d] sample[%d %d]", aKs(), Long.valueOf(elapsedRealtime), Long.valueOf(SystemClock.elapsedRealtime() - j2), Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(j2), Long.valueOf(j), Long.valueOf(bufferInfo.presentationTimeUs / 1000));
            if (elapsedRealtime < -30) {
                w.d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too late to show video frame. throw now", aKs());
                mediaCodec.releaseOutputBuffer(i, false);
                this.nzu.nzl = 0;
                return true;
            } else if (elapsedRealtime < 30) {
                this.nzu.nzi = bufferInfo.presentationTimeUs;
                if (elapsedRealtime > 11) {
                    try {
                        Thread.sleep(elapsedRealtime - 10);
                    } catch (Exception e) {
                    }
                }
                w.i("MicroMsg.VideoTrackDataSource", "%s finish to process index[%d] time[%d] to surface", aKs(), Integer.valueOf(i), Long.valueOf(r2));
                mediaCodec.releaseOutputBuffer(i, true);
                return true;
            } else {
                w.d("MicroMsg.VideoTrackDataSource", "%s finish to process but it too early now do nothing.", aKs());
                return false;
            }
        } else {
            w.i("MicroMsg.VideoTrackDataSource", "%s it no need process buffer now state %d", aKs(), Integer.valueOf(this.state));
            return false;
        }
    }

    final String aKl() {
        return SlookAirButtonRecentMediaAdapter.VIDEO_TYPE;
    }

    final boolean a(MediaCodec mediaCodec) {
        if (mediaCodec != null) {
            MediaFormat mediaFormat;
            if (this.nAg == null) {
                w.w("MicroMsg.VideoTrackDataSource", "%s decoder configure surface but surface is null.", aKs());
                this.nAh = false;
            } else {
                this.nAh = true;
            }
            w.i("MicroMsg.VideoTrackDataSource", "%s handleDecoderBeforeStart", aKs());
            if (this.nzE == null) {
                mediaFormat = this.nzz;
            } else {
                mediaFormat = this.nzE.getTrackFormat(this.nzC);
            }
            mediaCodec.configure(mediaFormat, this.nAg, null, 0);
        }
        return false;
    }

    protected final void b(MediaCodec mediaCodec) {
        w.i("MicroMsg.VideoTrackDataSource", "%s output format changed", aKs());
        mediaCodec.setVideoScalingMode(1);
    }

    @TargetApi(23)
    public final void aKE() {
        if (this.nzG != null) {
            this.nzG.setOutputSurface(this.nAg);
        }
    }

    public final void aKF() {
        w.i("MicroMsg.VideoTrackDataSource", "%s change surface below 23", aKs());
        if (this.nzG != null) {
            aKx();
            m(this.nzu.nzi, -1);
            aKy();
        }
    }

    protected final void a(MediaFormat mediaFormat, String str, int i) {
        int integer;
        int i2;
        super.a(mediaFormat, str, i);
        this.hTj = mediaFormat.getInteger("height");
        this.hTk = mediaFormat.getInteger("width");
        if (mediaFormat.containsKey("rotation-degrees")) {
            integer = mediaFormat.getInteger("rotation-degrees");
            i2 = 1;
        } else {
            integer = SightVideoJNI.getMp4Rotate(this.path);
            w.w("MicroMsg.VideoTrackDataSource", "%s it don't contains rotation key. degrees [%d]", aKs(), Integer.valueOf(integer));
            i2 = 0;
        }
        if (Math.abs(integer) == 90 || Math.abs(integer) == 270) {
            int i3 = this.hTk;
            this.hTk = this.hTj;
            this.hTj = i3;
        }
        if (!(i2 == 0 || AM(str))) {
            integer = 0;
        }
        this.nzv.obtainMessage(4, this.hTk, this.hTj, Integer.valueOf(integer)).sendToTarget();
        w.i("MicroMsg.VideoTrackDataSource", "%s video size[%d, %d] degrees[%d]", aKs(), Integer.valueOf(this.hTk), Integer.valueOf(this.hTj), Integer.valueOf(integer));
    }

    protected final boolean y(int i, long j) {
        w.d("MicroMsg.VideoTrackDataSource", "%s reset extractor flag[%d] needReset[%b]", aKs(), Integer.valueOf(i), Boolean.valueOf(this.nzu.nzn));
        if (!this.nzu.nzn || i != 1 || this.nAk == j) {
            return false;
        }
        boolean m = m(j, -1);
        this.nAk = j;
        return m;
    }

    private boolean AM(String str) {
        boolean z;
        try {
            if ("video/hevc".equalsIgnoreCase(str)) {
                z = true;
                if ("video/hevc".equalsIgnoreCase(str)) {
                    z = true;
                }
                if (z || !g.aKu()) {
                    return false;
                }
                w.i("MicroMsg.VideoTrackDataSource", "%s it is h265 video and black device", aKs());
                return true;
            }
        } catch (Throwable th) {
            w.printErrStackTrace("MicroMsg.VideoTrackDataSource", th, "check is h265 video", new Object[0]);
        }
        z = false;
        if ("video/hevc".equalsIgnoreCase(str)) {
            z = true;
        }
        if (z) {
        }
        return false;
    }
}
