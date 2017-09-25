package com.tencent.mm.plugin.mmsight.segment.a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.view.Surface;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.plugin.mmsight.segment.a.a.a;
import com.tencent.mm.plugin.mmsight.segment.a.a.b;
import com.tencent.mm.plugin.mmsight.segment.a.a.c;

public final class d implements a {
    private MediaPlayer ics = new i();

    public final void setSurface(Surface surface) {
        this.ics.setSurface(surface);
    }

    public final void setDataSource(String str) {
        this.ics.setDataSource(str);
    }

    public final void prepareAsync() {
        this.ics.prepareAsync();
    }

    public final void start() {
        this.ics.start();
    }

    public final void stop() {
        this.ics.stop();
    }

    public final void pause() {
        this.ics.pause();
    }

    public final boolean isPlaying() {
        return this.ics.isPlaying();
    }

    public final void seekTo(int i) {
        this.ics.seekTo(i);
    }

    public final int getCurrentPosition() {
        return this.ics.getCurrentPosition();
    }

    public final int getDuration() {
        return this.ics.getDuration();
    }

    public final void release() {
        this.ics.release();
    }

    public final void setAudioStreamType(int i) {
        this.ics.setAudioStreamType(i);
    }

    public final void setLooping(boolean z) {
        this.ics.setLooping(z);
    }

    public final void setLoop(int i, int i2) {
    }

    public final void a(final b bVar) {
        if (bVar == null) {
            this.ics.setOnPreparedListener(null);
        } else {
            this.ics.setOnPreparedListener(new OnPreparedListener(this) {
                final /* synthetic */ d nJM;

                public final void onPrepared(MediaPlayer mediaPlayer) {
                    bVar.ba(mediaPlayer);
                }
            });
        }
    }

    public final void a(final c cVar) {
        if (cVar == null) {
            this.ics.setOnSeekCompleteListener(null);
        } else {
            this.ics.setOnSeekCompleteListener(new OnSeekCompleteListener(this) {
                final /* synthetic */ d nJM;

                public final void onSeekComplete(MediaPlayer mediaPlayer) {
                    cVar.bb(mediaPlayer);
                }
            });
        }
    }

    public final void a(final com.tencent.mm.plugin.mmsight.segment.a.a.d dVar) {
        if (dVar == null) {
            this.ics.setOnVideoSizeChangedListener(null);
        } else {
            this.ics.setOnVideoSizeChangedListener(new OnVideoSizeChangedListener(this) {
                final /* synthetic */ d nJM;

                public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                    dVar.H(i, i2, 0);
                }
            });
        }
    }

    public final void a(final a aVar) {
        if (aVar == null) {
            this.ics.setOnErrorListener(null);
        } else {
            this.ics.setOnErrorListener(new OnErrorListener(this) {
                final /* synthetic */ d nJM;

                public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    return aVar.cr(i, i2);
                }
            });
        }
    }
}
