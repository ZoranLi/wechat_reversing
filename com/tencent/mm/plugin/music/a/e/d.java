package com.tencent.mm.plugin.music.a.e;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.w;

public final class d extends b {
    public MediaPlayer ics = new i();
    public boolean nDu = true;
    public a nTZ;

    private class a implements Runnable {
        boolean isStop = true;
        final /* synthetic */ d nUa;

        public a(d dVar) {
            this.nUa = dVar;
        }

        public final void run() {
            w.i("MicroMsg.Music.MMMediaPlayer", "start run play progress task");
            while (!this.isStop) {
                try {
                    if (this.nUa.ics != null && this.nUa.ics.isPlaying()) {
                        int currentPosition = this.nUa.ics.getCurrentPosition();
                        int duration = this.nUa.ics.getDuration();
                        if (currentPosition > 0 && duration > 0) {
                            this.nUa.qk((currentPosition * 100) / duration);
                        }
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "onPlayUpdate", new Object[0]);
                }
                try {
                    Thread.sleep(200);
                } catch (Throwable e2) {
                    w.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e2, "sleep", new Object[0]);
                }
            }
        }
    }

    public d() {
        this.ics.setAudioStreamType(3);
        this.ics.setOnCompletionListener(new OnCompletionListener(this) {
            final /* synthetic */ d nUa;

            {
                this.nUa = r1;
            }

            public final void onCompletion(MediaPlayer mediaPlayer) {
                w.e("MicroMsg.Music.MMMediaPlayer", "onCompletion, stop music");
                this.nUa.fX(true);
            }
        });
        this.ics.setOnSeekCompleteListener(new OnSeekCompleteListener(this) {
            final /* synthetic */ d nUa;

            {
                this.nUa = r1;
            }

            public final void onSeekComplete(MediaPlayer mediaPlayer) {
                if (this.nUa.ics != null && this.nUa.ics.isPlaying()) {
                    w.i("MicroMsg.Music.MMMediaPlayer", "onSeekComplete");
                    try {
                        this.nUa.ics.start();
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "start", new Object[0]);
                    }
                }
            }
        });
        this.ics.setOnPreparedListener(new OnPreparedListener(this) {
            final /* synthetic */ d nUa;

            {
                this.nUa = r1;
            }

            public final void onPrepared(MediaPlayer mediaPlayer) {
                if (this.nUa.ics != null) {
                    w.i("MicroMsg.Music.MMMediaPlayer", "onPrepared");
                    try {
                        this.nUa.ics.start();
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "start", new Object[0]);
                    }
                    this.nUa.nDu = false;
                    this.nUa.onStart();
                    if (this.nUa.nTZ != null) {
                        this.nUa.nTZ.isStop = true;
                    }
                    this.nUa.nTZ = new a(this.nUa);
                    Runnable runnable = this.nUa.nTZ;
                    runnable.isStop = false;
                    e.post(runnable, "music_play_progress_runnable");
                }
            }
        });
        this.ics.setOnErrorListener(new OnErrorListener(this) {
            final /* synthetic */ d nUa;

            {
                this.nUa = r1;
            }

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                w.e("MicroMsg.Music.MMMediaPlayer", "onError, what:%d, extra:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                this.nUa.fW(false);
                return false;
            }
        });
    }

    public final boolean isPlaying() {
        boolean z = false;
        try {
            z = this.ics.isPlaying();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "setSourcePath", new Object[z]);
        }
        return z;
    }

    public final boolean aOc() {
        return !this.nDu;
    }

    public final void BC(String str) {
        w.i("MicroMsg.Music.MMMediaPlayer", "setSourcePath, sourcePath:%s", new Object[]{str});
        try {
            this.ics.setDataSource(str);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "setSourcePath", new Object[0]);
        }
    }

    public final int aOd() {
        return this.ics.getCurrentPosition();
    }

    public final int getDuration() {
        return this.ics.getDuration();
    }

    public final void play() {
        w.i("MicroMsg.Music.MMMediaPlayer", "play");
        if (aOc()) {
            try {
                if (!this.ics.isPlaying()) {
                    this.ics.start();
                    return;
                }
                return;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "start", new Object[0]);
                return;
            }
        }
        try {
            this.ics.prepareAsync();
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e2, "prepareAsync", new Object[0]);
        }
    }

    public final void stop() {
        w.i("MicroMsg.Music.MMMediaPlayer", "stop");
        this.nDu = true;
        try {
            if (this.ics != null) {
                this.ics.stop();
                this.ics.release();
            }
            if (this.nTZ != null) {
                this.nTZ.isStop = true;
                this.nTZ = null;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Music.MMMediaPlayer", e, "stop", new Object[0]);
        }
        fX(false);
    }

    public final void pause() {
        w.i("MicroMsg.Music.MMMediaPlayer", "pause");
        if (aOc()) {
            this.ics.pause();
        }
    }

    public final void seek(long j) {
        w.i("MicroMsg.Music.MMMediaPlayer", "seek %d", new Object[]{Long.valueOf(j)});
        this.ics.seekTo((int) j);
    }

    public final String aOe() {
        return null;
    }
}
