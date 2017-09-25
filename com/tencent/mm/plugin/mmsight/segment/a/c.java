package com.tencent.mm.plugin.mmsight.segment.a;

import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.segment.a.a.b;
import com.tencent.mm.plugin.mmsight.segment.a.a.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;

public final class c implements a {
    private aj hMA;
    private a nJE;
    private HandlerThread nJF = e.cE("check auto job", 10);
    public com.tencent.mm.plugin.mmsight.segment.a.a.c nJG = null;
    public boolean nJH;
    private com.tencent.mm.plugin.mmsight.segment.a.a.c nJI = new com.tencent.mm.plugin.mmsight.segment.a.a.c(this) {
        final /* synthetic */ c nJK;

        {
            this.nJK = r1;
        }

        public final void bb(Object obj) {
            if (this.nJK.nJG != null) {
                this.nJK.nJG.bb(obj);
            }
        }
    };
    private com.tencent.mm.sdk.platformtools.aj.a nJJ = new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ c nJK;

        {
            this.nJK = r1;
        }

        public final boolean oQ() {
            if (this.nJK.nJH) {
                return false;
            }
            try {
                if (!this.nJK.isPlaying()) {
                    return true;
                }
                int currentPosition = this.nJK.getCurrentPosition();
                if (this.nJK.nJf != null) {
                    this.nJK.nJf.pK(currentPosition);
                }
                w.d("MicroMsg.SectionRepeatMediaPlayer", "position[%d] repeat[%d, %d] duration[%d]", new Object[]{Integer.valueOf(currentPosition), Integer.valueOf(this.nJK.nJx), Integer.valueOf(this.nJK.nJy), Integer.valueOf(this.nJK.getDuration())});
                if (currentPosition < this.nJK.nJy) {
                    return true;
                }
                w.i("MicroMsg.SectionRepeatMediaPlayer", "reach repeat end time, seek to %s", new Object[]{Integer.valueOf(this.nJK.nJy)});
                this.nJK.seekTo(this.nJK.nJx);
                return false;
            } catch (IllegalStateException e) {
                w.e("MicroMsg.SectionRepeatMediaPlayer", "MediaPlayer may be released. %s", new Object[]{e.getMessage()});
                if (this.nJK.nJH) {
                    return false;
                }
                return true;
            }
        }
    };
    public a nJf;
    public int nJx;
    public int nJy;

    public interface a {
        void pK(int i);
    }

    public c() {
        int intValue = ((Integer) CaptureMMProxy.getInstance().get(com.tencent.mm.storage.w.a.uFj, Integer.valueOf(-1))).intValue();
        if (intValue == 1) {
            w.i("MicroMsg.SectionRepeatMediaPlayer", "used system media player");
            this.nJE = new d();
        } else if (intValue == 2) {
            w.i("MicroMsg.SectionRepeatMediaPlayer", "used mm video player");
            this.nJE = new b();
        } else if (CaptureMMProxy.getInstance().checkUseMMVideoPlayer()) {
            w.i("MicroMsg.SectionRepeatMediaPlayer", "default used mm video player");
            this.nJE = new b();
        } else {
            w.i("MicroMsg.SectionRepeatMediaPlayer", "default used system media player");
            this.nJE = new d();
        }
        this.nJF.start();
        this.hMA = new aj(this.nJF.getLooper(), this.nJJ, true);
    }

    public final void setLoop(int i, int i2) {
        this.nJx = i;
        this.nJy = i2;
        if (this.nJE != null) {
            this.nJE.setLoop(this.nJx, this.nJy);
        }
    }

    public final void setDataSource(String str) {
        this.nJE.setDataSource(str);
    }

    public final void release() {
        this.nJH = true;
        this.nJE.release();
        if (this.hMA != null) {
            this.hMA.KH();
        }
        if (this.nJF != null) {
            this.nJF.quit();
        }
    }

    public final void start() {
        this.nJE.start();
        this.hMA.v(30, 30);
    }

    public final void pause() {
        this.nJE.pause();
        this.hMA.KH();
    }

    public final void stop() {
        this.nJE.stop();
        this.hMA.KH();
    }

    public final void a(com.tencent.mm.plugin.mmsight.segment.a.a.c cVar) {
        this.nJE.a(cVar);
    }

    public final void setAudioStreamType(int i) {
        this.nJE.setAudioStreamType(i);
    }

    public final int getCurrentPosition() {
        return this.nJE.getCurrentPosition();
    }

    public final int getDuration() {
        if (this.nJE != null) {
            return this.nJE.getDuration();
        }
        return 0;
    }

    public final void setSurface(Surface surface) {
        this.nJE.setSurface(surface);
    }

    public final boolean isPlaying() {
        return this.nJE.isPlaying();
    }

    public final void seekTo(int i) {
        this.nJE.seekTo(i);
    }

    public final void prepareAsync() {
        this.nJE.prepareAsync();
    }

    public final void setLooping(boolean z) {
        this.nJE.setLooping(z);
    }

    public final void a(com.tencent.mm.plugin.mmsight.segment.a.a.a aVar) {
        this.nJE.a(aVar);
    }

    public final void a(d dVar) {
        this.nJE.a(dVar);
    }

    public final void a(b bVar) {
        this.nJE.a(bVar);
    }
}
