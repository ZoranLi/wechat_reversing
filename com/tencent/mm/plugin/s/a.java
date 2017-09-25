package com.tencent.mm.plugin.s;

import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.compatible.b.c;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.nio.ByteBuffer;

public final class a extends h {
    private int channels;
    private AudioTrack ibN;
    private boolean kmK = false;
    private int sampleRate;

    public a(g gVar, ae aeVar) {
        super(gVar, aeVar);
    }

    final boolean a(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, BufferInfo bufferInfo) {
        w.d("MicroMsg.AudioTrackDataSource", "%s start to process output buffer state %d time[%d, %d] index %d", aKs(), Integer.valueOf(this.state), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i));
        if (d.ps(this.state)) {
            if (this.ibN == null) {
                Object obj;
                w.i("MicroMsg.AudioTrackDataSource", "%s init audio track", aKs());
                if (this.channels == 0) {
                    this.channels = this.nzz.getInteger("channel-count");
                }
                int i2 = this.channels == 1 ? 4 : 12;
                this.ibN = new c(3, getSampleRate(), i2, 2, AudioTrack.getMinBufferSize(getSampleRate(), i2, 2));
                if (this.ibN == null || this.ibN.getState() == 1) {
                    bQ(this.kmK);
                    obj = 1;
                } else {
                    w.w("MicroMsg.AudioTrackDataSource", "%s can not create audio track [%d]", aKs(), Integer.valueOf(this.ibN.getState()));
                    this.ibN.release();
                    this.ibN = null;
                    obj = null;
                }
                if (obj == null) {
                    return false;
                }
            }
            if (d.pn(this.state) && (this.ibN.getPlayState() == 2 || this.ibN.getPlayState() == 1)) {
                onStart();
            }
            if ((this.state == 4 ? 1 : null) != null && this.ibN.getPlayState() == 3) {
                onPause();
            }
            try {
                this.nzu.nzj = bufferInfo.presentationTimeUs;
                byte[] bArr = new byte[bufferInfo.size];
                byteBuffer.get(bArr);
                byteBuffer.clear();
                if (bArr.length > 0) {
                    this.ibN.write(bArr, 0, bArr.length);
                }
                w.d("MicroMsg.AudioTrackDataSource", "%s finish to process index[%d] time[%d] to audio track", aKs(), Integer.valueOf(i), Long.valueOf(this.nzu.nzj));
                mediaCodec.releaseOutputBuffer(i, false);
            } catch (Exception e) {
                w.e("MicroMsg.AudioTrackDataSource", "%s audio release output buffer error %s", aKs(), e.toString());
            }
            return true;
        }
        w.i("MicroMsg.AudioTrackDataSource", "%s it no need process buffer now state %d", aKs(), Integer.valueOf(this.state));
        return false;
    }

    protected final void onStart() {
        w.i("MicroMsg.AudioTrackDataSource", "%s on start", aKs());
        if (this.ibN != null && this.ibN.getState() == 1) {
            this.ibN.play();
        }
    }

    protected final void onPause() {
        w.i("MicroMsg.AudioTrackDataSource", "%s on pause", aKs());
        if (this.ibN != null && this.ibN.getState() == 1) {
            this.ibN.pause();
        }
    }

    public final void release() {
        try {
            this.ibN.flush();
            this.ibN.release();
        } catch (Exception e) {
        }
        super.release();
    }

    public final void bQ(boolean z) {
        if (this.ibN == null) {
            w.w("MicroMsg.AudioTrackDataSource", "%s set mute[%b] but audio track is null", aKs(), Boolean.valueOf(z));
            this.kmK = z;
        } else if (d.ep(21)) {
            w.d("MicroMsg.AudioTrackDataSource", "%s api below 21 set mute[%b]", aKs(), Boolean.valueOf(z));
            if (z) {
                this.ibN.setStereoVolume(0.0f, 0.0f);
            } else {
                this.ibN.setStereoVolume(1.0f, 1.0f);
            }
        } else {
            w.d("MicroMsg.AudioTrackDataSource", "%s api higher 21 set mute[%b]", aKs(), Boolean.valueOf(z));
            if (z) {
                this.ibN.setVolume(0.0f);
            } else {
                this.ibN.setVolume(1.0f);
            }
        }
    }

    final boolean a(MediaCodec mediaCodec) {
        w.i("MicroMsg.AudioTrackDataSource", "%s handle decoder before start", aKs());
        mediaCodec.configure(this.nzz, null, null, 0);
        return false;
    }

    private int getSampleRate() {
        if (this.sampleRate == 0) {
            this.sampleRate = this.nzz.getInteger("sample-rate");
        }
        return this.sampleRate;
    }

    protected final void b(MediaCodec mediaCodec) {
        w.i("MicroMsg.AudioTrackDataSource", "%s on output format changed", aKs());
        this.sampleRate = 0;
        this.channels = 0;
        this.ibN = null;
    }

    final String aKl() {
        return SlookAirButtonRecentMediaAdapter.AUDIO_TYPE;
    }
}
