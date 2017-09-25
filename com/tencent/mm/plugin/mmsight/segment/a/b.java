package com.tencent.mm.plugin.mmsight.segment.a;

import android.os.Looper;
import android.view.Surface;
import com.tencent.mm.plugin.mmsight.segment.a.a.a;
import com.tencent.mm.plugin.mmsight.segment.a.a.c;
import com.tencent.mm.plugin.mmsight.segment.a.a.d;
import com.tencent.mm.plugin.s.i;
import com.tencent.mm.plugin.s.j;
import com.tencent.mm.sdk.platformtools.w;

public final class b implements a {
    public boolean Ht = false;
    public boolean fOV = false;
    public d nJA;
    public com.tencent.mm.plugin.mmsight.segment.a.a.b nJB;
    public c nJC;
    public i nJu = new i(Looper.getMainLooper());
    public int nJv;
    public boolean nJw = false;
    public int nJx = 0;
    private int nJy = 0;
    public a nJz;

    public b() {
        i iVar = this.nJu;
        if (iVar.nzQ != null) {
            j jVar = iVar.nzQ;
            if (jVar.nzu != null) {
                jVar.nzu.nzm = false;
            }
        }
        this.nJu.fB(false);
        this.nJu.nzR = new com.tencent.mm.plugin.s.c(this) {
            final /* synthetic */ b nJD;

            {
                this.nJD = r1;
            }

            public final void Uc() {
                if (this.nJD.nJB != null) {
                    this.nJD.nJB.ba(this.nJD.nJu);
                }
                if (this.nJD.fOV) {
                    this.nJD.nJu.start();
                }
                this.nJD.Ht = true;
            }

            public final void oW() {
                if (this.nJD.nJw) {
                    this.nJD.nJu.pu(this.nJD.nJx);
                }
            }

            public final void onError(int i, int i2) {
                if (this.nJD.nJz != null) {
                    this.nJD.nJz.cr(i, i2);
                }
            }

            public final void aKn() {
                w.i("MicroMsg.MMSegmentVideoPlayer", "onSeekComplete, onSeekCompleteListener: %s", new Object[]{this.nJD.nJC});
                if (this.nJD.nJC != null) {
                    this.nJD.nJC.bb(this.nJD.nJu);
                } else if (this.nJD.fOV) {
                    this.nJD.nJu.start();
                }
            }

            public final void E(int i, int i2, int i3) {
                this.nJD.nJv = i3;
                if (this.nJD.nJA != null) {
                    this.nJD.nJA.H(i, i2, i3);
                }
            }
        };
    }

    public final void setSurface(Surface surface) {
        this.nJu.setSurface(surface);
    }

    public final void setDataSource(String str) {
        this.nJu.setPath(str);
    }

    public final void prepareAsync() {
        this.nJu.aKz();
    }

    public final void start() {
        if (this.Ht) {
            this.nJu.start();
        }
        this.fOV = true;
    }

    public final void stop() {
        this.nJu.nzQ.stop();
        this.fOV = false;
    }

    public final void pause() {
        this.nJu.pause();
    }

    public final boolean isPlaying() {
        return this.nJu.isPlaying();
    }

    public final void seekTo(int i) {
        if (this.nJu != null) {
            w.i("MicroMsg.MMSegmentVideoPlayer", "seekTo: %s", new Object[]{Integer.valueOf(i)});
            this.nJu.pu(i);
        }
    }

    public final int getCurrentPosition() {
        return this.nJu.aKA();
    }

    public final int getDuration() {
        return (int) this.nJu.nzQ.nzB;
    }

    public final void release() {
        this.nJu.release();
    }

    public final void setAudioStreamType(int i) {
    }

    public final void setLooping(boolean z) {
        this.nJw = z;
    }

    public final void setLoop(int i, int i2) {
        this.nJx = i;
        this.nJy = i2;
    }

    public final void a(com.tencent.mm.plugin.mmsight.segment.a.a.b bVar) {
        this.nJB = bVar;
    }

    public final void a(c cVar) {
        this.nJC = cVar;
    }

    public final void a(d dVar) {
        this.nJA = dVar;
    }

    public final void a(a aVar) {
        this.nJz = aVar;
    }
}
