package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.b;
import com.tencent.mm.pluginsdk.ui.tools.f.c;
import com.tencent.mm.pluginsdk.ui.tools.f.d;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.w;

public class VideoSurfaceView extends SurfaceView implements f {
    private int gRD;
    private int gRE;
    private boolean kmK;
    private int ls;
    private a pvi;
    private MediaPlayer pyq;
    private SurfaceHolder qWB;
    private String sXg;
    private boolean sXh;
    private boolean sXi;
    OnVideoSizeChangedListener sXj;
    OnPreparedListener sXk;
    private OnCompletionListener sXl;
    private OnErrorListener sXm;
    Callback sXn;

    static /* synthetic */ void c(VideoSurfaceView videoSurfaceView) {
        if (videoSurfaceView.gRE != 0 && videoSurfaceView.gRD != 0) {
            int i = videoSurfaceView.gRD;
            int i2 = videoSurfaceView.gRE;
            w.v("MicroMsg.VideoSurfaceView", "video size before:" + i + "   " + i2);
            w.v("MicroMsg.VideoSurfaceView", "layout size before:" + videoSurfaceView.getWidth() + "   " + videoSurfaceView.getHeight());
            int width = videoSurfaceView.getWidth();
            int height = videoSurfaceView.getHeight();
            int i3 = width <= 0 ? i : width;
            width = height <= 0 ? i2 : height;
            float f = (((float) i3) * 1.0f) / ((float) i);
            float f2 = (((float) width) * 1.0f) / ((float) i2);
            LayoutParams layoutParams = (LayoutParams) videoSurfaceView.getLayoutParams();
            if (f > f2) {
                layoutParams.width = (int) (((float) i) * f2);
                layoutParams.height = width;
            } else {
                layoutParams.width = i3;
                layoutParams.height = (int) (((float) i2) * f);
            }
            layoutParams.addRule(13);
            videoSurfaceView.setLayoutParams(layoutParams);
            w.v("MicroMsg.VideoSurfaceView", "video size after:" + videoSurfaceView.pyq.getVideoWidth() + "   " + videoSurfaceView.pyq.getVideoHeight());
            w.v("MicroMsg.VideoSurfaceView", "layout size after:" + layoutParams.width + "   " + layoutParams.height);
        }
    }

    public VideoSurfaceView(Context context) {
        this(context, null);
    }

    public VideoSurfaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qWB = null;
        this.pyq = null;
        this.sXj = new OnVideoSizeChangedListener(this) {
            final /* synthetic */ VideoSurfaceView sXo;

            {
                this.sXo = r1;
            }

            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                this.sXo.gRD = mediaPlayer.getVideoWidth();
                this.sXo.gRE = mediaPlayer.getVideoHeight();
                w.v("MicroMsg.VideoSurfaceView", "on size change size:( " + this.sXo.gRD + " , " + this.sXo.gRE + " )");
                VideoSurfaceView.c(this.sXo);
            }
        };
        this.sXk = new OnPreparedListener(this) {
            final /* synthetic */ VideoSurfaceView sXo;

            {
                this.sXo = r1;
            }

            public final void onPrepared(MediaPlayer mediaPlayer) {
                this.sXo.sXh = true;
                if (this.sXo.pvi != null) {
                    this.sXo.pvi.Uc();
                }
                this.sXo.gRD = mediaPlayer.getVideoWidth();
                this.sXo.gRE = mediaPlayer.getVideoHeight();
                VideoSurfaceView.c(this.sXo);
                if (this.sXo.gRD == 0 || this.sXo.gRE == 0) {
                    if (this.sXo.sXi) {
                        this.sXo.pyq.start();
                        this.sXo.sXi = false;
                    }
                } else if (this.sXo.sXi) {
                    this.sXo.pyq.start();
                    this.sXo.sXi = false;
                }
            }
        };
        this.sXl = new OnCompletionListener(this) {
            final /* synthetic */ VideoSurfaceView sXo;

            {
                this.sXo = r1;
            }

            public final void onCompletion(MediaPlayer mediaPlayer) {
                if (this.sXo.pvi != null) {
                    this.sXo.pvi.bI(this.sXo.pyq.getCurrentPosition(), this.sXo.pyq.getDuration());
                    this.sXo.pvi.oW();
                }
            }
        };
        this.sXm = new OnErrorListener(this) {
            final /* synthetic */ VideoSurfaceView sXo;

            {
                this.sXo = r1;
            }

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                w.d("MicroMsg.VideoSurfaceView", "Error: " + i + "," + i2);
                if (this.sXo.pvi != null) {
                    this.sXo.pvi.onError(i, i2);
                }
                return true;
            }
        };
        this.sXn = new Callback(this) {
            final /* synthetic */ VideoSurfaceView sXo;

            {
                this.sXo = r1;
            }

            public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
                w.i("MicroMsg.VideoSurfaceView", "on surface changed %d*%d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (this.sXo.pyq != null && this.sXo.sXh && this.sXo.gRD == i2 && this.sXo.gRE == i3) {
                    this.sXo.pyq.start();
                }
            }

            public final void surfaceCreated(SurfaceHolder surfaceHolder) {
                w.i("MicroMsg.VideoSurfaceView", "on surface created");
                this.sXo.qWB = surfaceHolder;
                this.sXo.auE();
            }

            public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                w.i("MicroMsg.VideoSurfaceView", "on surface destroyed");
                this.sXo.qWB = null;
                if (this.sXo.pyq != null) {
                    this.sXo.pvi.bI(this.sXo.pyq.getCurrentPosition(), this.sXo.pyq.getDuration());
                    this.sXo.pyq.reset();
                    this.sXo.pyq.release();
                    this.sXo.pyq = null;
                }
            }
        };
        this.kmK = false;
        this.gRD = 0;
        this.gRE = 0;
        getHolder().addCallback(this.sXn);
        getHolder().setType(3);
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
    }

    public final void setVideoPath(String str) {
        this.sXg = str;
        this.sXi = false;
        auE();
        requestLayout();
    }

    public final String Ls() {
        return this.sXg;
    }

    public final void stop() {
        if (this.pyq != null) {
            this.pyq.stop();
            this.pyq.release();
            this.pyq = null;
        }
    }

    private void auE() {
        if (this.sXg != null && this.qWB != null) {
            if (this.pyq != null) {
                this.pyq.stop();
                this.pyq.release();
                this.pyq = null;
            }
            try {
                this.pyq = new i();
                this.pyq.setOnPreparedListener(this.sXk);
                this.pyq.setOnVideoSizeChangedListener(this.sXj);
                this.sXh = false;
                w.v("MicroMsg.VideoSurfaceView", "reset duration to -1 in openVideo");
                this.ls = -1;
                this.pyq.setOnCompletionListener(this.sXl);
                this.pyq.setOnErrorListener(this.sXm);
                this.pyq.setDataSource(this.sXg);
                this.pyq.setDisplay(this.qWB);
                this.pyq.setAudioStreamType(3);
                this.pyq.setScreenOnWhilePlaying(true);
                this.pyq.prepareAsync();
                this.gRE = this.pyq.getVideoHeight();
                this.gRD = this.pyq.getVideoWidth();
                bQ(this.kmK);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.VideoSurfaceView", e, "prepare async error %s", e.getMessage());
                if (this.pvi != null) {
                    this.pvi.onError(-1, -1);
                }
            }
        }
    }

    public final void pause() {
        if (this.pyq != null && this.sXh && this.pyq.isPlaying()) {
            this.pyq.pause();
        }
        this.sXi = false;
    }

    public final int getDuration() {
        if (this.pyq == null || !this.sXh) {
            this.ls = -1;
            return this.ls;
        } else if (this.ls > 0) {
            return this.ls;
        } else {
            this.ls = this.pyq.getDuration();
            return this.ls;
        }
    }

    public final int getCurrentPosition() {
        if (this.pyq == null || !this.sXh) {
            return 0;
        }
        return this.pyq.getCurrentPosition();
    }

    public final boolean isPlaying() {
        if (this.pyq == null || !this.sXh) {
            return false;
        }
        return this.pyq.isPlaying();
    }

    public final void bN(boolean z) {
        if (this.pyq != null) {
            this.pyq.setLooping(z);
        }
    }

    public final void a(a aVar) {
        this.pvi = aVar;
    }

    public final void onDetach() {
    }

    public final boolean start() {
        if (this.pyq == null || !this.sXh) {
            this.sXi = true;
        } else {
            this.pyq.start();
            this.sXi = false;
        }
        return true;
    }

    public final boolean i(Context context, boolean z) {
        return start();
    }

    public final double bcw() {
        return 0.0d;
    }

    public final void k(double d) {
        if (this.pyq != null) {
            w.d("MicroMsg.VideoSurfaceView", "seek to time: " + d);
            this.pyq.seekTo((int) d);
            start();
        }
    }

    public final void he(boolean z) {
    }

    public final long bcx() {
        return 0;
    }

    public final void bQ(boolean z) {
        this.kmK = z;
        if (this.pyq == null) {
            return;
        }
        if (this.kmK) {
            this.pyq.setVolume(0.0f, 0.0f);
        } else {
            this.pyq.setVolume(0.5f, 0.5f);
        }
    }

    public final void c(double d, boolean z) {
        k(d);
    }

    public final void a(e eVar) {
    }

    public final void a(c cVar) {
    }

    public final void a(b bVar) {
    }

    public final void a(d dVar) {
    }
}
