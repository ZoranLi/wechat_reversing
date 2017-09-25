package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.media.PlaybackParams;
import android.opengl.GLES20;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.b;
import com.tencent.mm.pluginsdk.ui.tools.f.c;
import com.tencent.mm.pluginsdk.ui.tools.f.d;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMTextureView;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

public class VideoTextureView extends MMTextureView implements f {
    private float aLi;
    private int gRD;
    private int gRE;
    private int jYp;
    private int jYq;
    private boolean kmK;
    private int ls;
    private boolean mNI;
    private Surface nIX;
    public a pvi;
    private MediaPlayer pyq;
    private long sWM;
    public boolean sWN;
    public e sWP;
    private c sWQ;
    private d sWR;
    private boolean sWT;
    private boolean sWU;
    SurfaceTextureListener sWW;
    public o sWX;
    private String sXg;
    private boolean sXh;
    private boolean sXi;
    OnVideoSizeChangedListener sXj;
    OnPreparedListener sXk;
    private OnCompletionListener sXl;
    private OnErrorListener sXm;
    private b sXp;
    private long sXq;
    public int sXr;
    private OnSeekCompleteListener sXs;
    private OnBufferingUpdateListener sXt;
    private OnInfoListener sXu;
    private boolean sXv;
    private long startTime;

    static /* synthetic */ void e(VideoTextureView videoTextureView) {
        LayoutParams layoutParams = (LayoutParams) videoTextureView.getLayoutParams();
        layoutParams.addRule(13);
        videoTextureView.setLayoutParams(layoutParams);
    }

    public VideoTextureView(Context context) {
        this(context, null);
    }

    public VideoTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nIX = null;
        this.pyq = null;
        this.startTime = 0;
        this.sXq = 0;
        this.jYp = 0;
        this.jYq = 0;
        this.sXr = 0;
        this.mNI = false;
        this.sWN = false;
        this.sXj = new OnVideoSizeChangedListener(this) {
            final /* synthetic */ VideoTextureView sXx;

            {
                this.sXx = r1;
            }

            public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                try {
                    if (mediaPlayer != this.sXx.pyq) {
                        w.w("MicroMsg.VideoTextureView", "another player on video size changed, return now.[%s, %s]", mediaPlayer, this.sXx.pyq);
                        return;
                    }
                    this.sXx.gRD = mediaPlayer.getVideoWidth();
                    this.sXx.gRE = mediaPlayer.getVideoHeight();
                    w.i("MicroMsg.VideoTextureView", "on size change size:( " + this.sXx.gRD + " , " + this.sXx.gRE + " )");
                    if (this.sXx.pvi != null) {
                        this.sXx.pvi.bp(this.sXx.gRD, this.sXx.gRE);
                    }
                    VideoTextureView.e(this.sXx);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.VideoTextureView", e, "on video size changed error[%d, %d]", Integer.valueOf(i), Integer.valueOf(i2));
                }
            }
        };
        this.sXk = new OnPreparedListener(this) {
            final /* synthetic */ VideoTextureView sXx;

            {
                this.sXx = r1;
            }

            public final void onPrepared(MediaPlayer mediaPlayer) {
                if (mediaPlayer == this.sXx.pyq || mediaPlayer == null) {
                    int videoHeight;
                    this.sXx.sXh = true;
                    this.sXx.gRD = mediaPlayer != null ? mediaPlayer.getVideoWidth() : 0;
                    VideoTextureView videoTextureView = this.sXx;
                    if (mediaPlayer != null) {
                        videoHeight = mediaPlayer.getVideoHeight();
                    } else {
                        videoHeight = 0;
                    }
                    videoTextureView.gRE = videoHeight;
                    w.i("MicroMsg.VideoTextureView", "on prepared. size [%d, %d] mStartWhenPrepared %b ", Integer.valueOf(this.sXx.gRD), Integer.valueOf(this.sXx.gRE), Boolean.valueOf(this.sXx.sXi));
                    VideoTextureView.e(this.sXx);
                    if (this.sXx.gRD == 0 || this.sXx.gRE == 0) {
                        if (this.sXx.sXi) {
                            this.sXx.pyq.start();
                            this.sXx.sXi = false;
                            this.sXx.pyq.setLooping(this.sXx.mNI);
                        }
                    } else if (this.sXx.sXi) {
                        this.sXx.pyq.start();
                        this.sXx.pyq.setLooping(this.sXx.mNI);
                        this.sXx.sXi = false;
                    }
                    if (this.sXx.pvi != null) {
                        this.sXx.pvi.Uc();
                        return;
                    }
                    return;
                }
                w.w("MicroMsg.VideoTextureView", "another player callback, release now.[%s, %s]", mediaPlayer, this.sXx.pyq);
                new Thread(this.sXx, mediaPlayer) {
                    final /* synthetic */ VideoTextureView sXx;

                    public final void run() {
                        try {
                            if (r2 != null) {
                                w.i("MicroMsg.VideoTextureView", "%d another thread to release player[%s]", Integer.valueOf(this.sXx.hashCode()), r2);
                                r2.stop();
                                r2.release();
                            }
                        } catch (Exception e) {
                        }
                    }
                }.start();
            }
        };
        this.sXs = new OnSeekCompleteListener(this) {
            final /* synthetic */ VideoTextureView sXx;

            {
                this.sXx = r1;
            }

            public final void onSeekComplete(MediaPlayer mediaPlayer) {
                int currentPosition = mediaPlayer != null ? mediaPlayer.getCurrentPosition() : -1;
                w.i("MicroMsg.VideoTextureView", "video seek complete curPos[%d] mStartWhenPrepared[%b]", Integer.valueOf(currentPosition), Boolean.valueOf(this.sXx.sXi));
                if (this.sXx.sXi) {
                    this.sXx.start();
                } else {
                    this.sXx.pause();
                }
                if (this.sXx.sWQ != null) {
                    this.sXx.sWQ.br(this.sXx.sXi);
                }
                this.sXx.sWM = 0;
            }
        };
        this.sXt = new OnBufferingUpdateListener(this) {
            final /* synthetic */ VideoTextureView sXx;

            {
                this.sXx = r1;
            }

            public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                w.d("MicroMsg.VideoTextureView", "onBufferingUpdate percent[%d]", Integer.valueOf(i));
                this.sXx.sXr = i;
            }
        };
        this.sXu = new OnInfoListener(this) {
            final /* synthetic */ VideoTextureView sXx;

            {
                this.sXx = r1;
            }

            public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                w.d("MicroMsg.VideoTextureView", "onInfo [%d %d]", Integer.valueOf(i), Integer.valueOf(i2));
                if (this.sXx.sXp != null) {
                    this.sXx.sXp.dH(i, i2);
                }
                return false;
            }
        };
        this.sXl = new OnCompletionListener(this) {
            final /* synthetic */ VideoTextureView sXx;

            {
                this.sXx = r1;
            }

            public final void onCompletion(MediaPlayer mediaPlayer) {
                w.i("MicroMsg.VideoTextureView", "video on completion");
                this.sXx.sXq = bg.Ny();
                if (this.sXx.pvi != null) {
                    this.sXx.pvi.oW();
                }
            }
        };
        this.sXm = new OnErrorListener(this) {
            final /* synthetic */ VideoTextureView sXx;

            {
                this.sXx = r1;
            }

            public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                w.w("MicroMsg.VideoTextureView", "Error: " + i + "," + i2);
                if (this.sXx.pvi != null) {
                    this.sXx.pvi.onError(i, i2);
                }
                return true;
            }
        };
        this.sWM = 0;
        this.sWT = false;
        this.sWU = false;
        this.sXv = false;
        this.sWW = new SurfaceTextureListener(this) {
            final /* synthetic */ VideoTextureView sXx;

            {
                this.sXx = r1;
            }

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                if (this.sXx.sWU) {
                    if (this.sXx.pyq != null) {
                        this.sXx.pyq.pause();
                        if (this.sXx.kmK) {
                            this.sXx.pyq.setVolume(0.0f, 0.0f);
                        } else {
                            this.sXx.pyq.setVolume(1.0f, 1.0f);
                        }
                    }
                    this.sXx.sWU = false;
                }
                if (this.sXx.sWM > 0 && this.sXx.sWP != null) {
                    this.sXx.sWP.aMm();
                    this.sXx.sWP = null;
                }
                this.sXx.sWM = System.currentTimeMillis();
                if (this.sXx.sXv) {
                    w.i("MicroMsg.VideoTextureView", "%d flush surface pause now time[%d]", Integer.valueOf(this.sXx.hashCode()), Integer.valueOf(this.sXx.getCurrentPosition()));
                    if (this.sXx.pyq != null) {
                        this.sXx.pyq.pause();
                        this.sXx.bQ(this.sXx.kmK);
                    }
                    this.sXx.sXv = false;
                }
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                w.i("MicroMsg.VideoTextureView", "on texture size changed width : " + i + " height : " + i2);
                if (this.sXx.pyq != null && this.sXx.sXh && this.sXx.gRD == i && this.sXx.gRE == i2) {
                    this.sXx.pyq.start();
                }
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                w.i("MicroMsg.VideoTextureView", "%d on texture destroyed mIsPrepared[%b]", Integer.valueOf(this.sXx.hashCode()), Boolean.valueOf(this.sXx.sXh));
                this.sXx.nIX = null;
                if (this.sXx.pyq == null || !this.sXx.sXh) {
                    this.sXx.bGH();
                    this.sXx.sWT = false;
                } else if (this.sXx.isPlaying()) {
                    this.sXx.sWT = true;
                    this.sXx.pyq.pause();
                }
                return false;
            }

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                this.sXx.jYp = i;
                this.sXx.jYq = i2;
                this.sXx.bSB();
                this.sXx.nIX = new Surface(surfaceTexture);
                w.i("MicroMsg.VideoTextureView", "%d on texture available %d*%d mIsPrepared[%b] mSurface[%d] ", Integer.valueOf(this.sXx.hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.sXx.sXh), Integer.valueOf(this.sXx.nIX.hashCode()));
                if (this.sXx.pyq == null || !this.sXx.sXh) {
                    this.sXx.auE();
                } else {
                    this.sXx.pyq.setSurface(this.sXx.nIX);
                    if (this.sXx.sWT) {
                        this.sXx.pyq.start();
                    } else {
                        this.sXx.sWU = true;
                        this.sXx.pyq.setVolume(0.0f, 0.0f);
                        this.sXx.pyq.start();
                    }
                    this.sXx.sWT = false;
                }
                if (this.sXx.sWR != null) {
                    this.sXx.sWR.KJ();
                }
            }
        };
        this.kmK = false;
        this.sWX = new o();
        this.aLi = -1.0f;
        this.gRD = 0;
        this.gRE = 0;
        setSurfaceTextureListener(this.sWW);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public final void a(e eVar) {
        this.sWP = eVar;
    }

    public final void a(c cVar) {
        this.sWQ = cVar;
    }

    public final void a(b bVar) {
        this.sXp = bVar;
    }

    public final void a(d dVar) {
        this.sWR = dVar;
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
        long j;
        long j2 = this.sXq > 0 ? this.sXq - this.startTime : 2147483647L;
        long Ny = bg.Ny() - this.startTime;
        if (j2 > Ny) {
            j = Ny;
        } else {
            j = j2;
        }
        int i = ((int) j) * 1000;
        if (i > getDuration()) {
            i = getDuration();
        }
        w.i("MicroMsg.VideoTextureView", "stop : dur:%d stop:%d comp:%d", Integer.valueOf(getDuration()), Long.valueOf(Ny), Long.valueOf(j2));
        if (this.pvi != null) {
            this.pvi.bI(i, getDuration());
        }
        bGH();
        this.sWX.reset();
        try {
            if (this.nIX != null && this.sXh) {
                SurfaceTexture surfaceTexture = getSurfaceTexture();
                if (surfaceTexture != null) {
                    w.i("MicroMsg.VideoTextureView", "%d releaseSurface", Integer.valueOf(hashCode()));
                    EGL10 egl10 = (EGL10) EGLContext.getEGL();
                    EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                    egl10.eglInitialize(eglGetDisplay, null);
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    egl10.eglChooseConfig(eglGetDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344}, eGLConfigArr, 1, new int[1]);
                    EGLConfig eGLConfig = eGLConfigArr[0];
                    EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
                    EGLSurface eglCreateWindowSurface = egl10.eglCreateWindowSurface(eglGetDisplay, eGLConfig, surfaceTexture, new int[]{12344});
                    egl10.eglMakeCurrent(eglGetDisplay, eglCreateWindowSurface, eglCreateWindowSurface, eglCreateContext);
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    GLES20.glClear(16384);
                    egl10.eglSwapBuffers(eglGetDisplay, eglCreateWindowSurface);
                    egl10.eglDestroySurface(eglGetDisplay, eglCreateWindowSurface);
                    egl10.eglMakeCurrent(eglGetDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                    egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
                    egl10.eglTerminate(eglGetDisplay);
                }
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.VideoTextureView", e, "release surface", new Object[0]);
        }
        this.sXg = "";
        this.sXr = 0;
        this.sXh = false;
        this.sXi = false;
        this.sWM = 0;
    }

    private void bGH() {
        boolean z = true;
        String str = "MicroMsg.VideoTextureView";
        String str2 = "%d release media player isPrepared[%b] player is null[%b] ";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Boolean.valueOf(this.sXh);
        if (this.pyq != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        w.i(str, str2, objArr);
        if (this.pyq != null) {
            this.pyq.setOnErrorListener(null);
            this.pyq.setOnVideoSizeChangedListener(null);
            try {
                this.pyq.stop();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.VideoTextureView", e, "stop media player error", new Object[0]);
            }
            try {
                this.pyq.reset();
                this.pyq.release();
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.VideoTextureView", e2, "reset media player error", new Object[0]);
            }
        }
        this.pyq = null;
    }

    private void auE() {
        if (!bg.mA(this.sXg) && this.nIX != null) {
            bGH();
            w.i("MicroMsg.VideoTextureView", "%d open video %s", Integer.valueOf(hashCode()), this.sXg);
            try {
                this.pyq = new i();
                this.pyq.setOnPreparedListener(this.sXk);
                this.pyq.setOnVideoSizeChangedListener(this.sXj);
                this.sXh = false;
                w.v("MicroMsg.VideoTextureView", "reset duration to -1 in openVideo");
                this.ls = -1;
                this.sXr = 0;
                this.pyq.setOnCompletionListener(this.sXl);
                this.pyq.setOnErrorListener(this.sXm);
                this.pyq.setOnSeekCompleteListener(this.sXs);
                this.pyq.setOnBufferingUpdateListener(this.sXt);
                this.pyq.setOnInfoListener(this.sXu);
                this.pyq.setDataSource(this.sXg);
                this.pyq.setSurface(this.nIX);
                this.pyq.setAudioStreamType(3);
                this.pyq.setScreenOnWhilePlaying(true);
                this.pyq.prepareAsync();
                this.gRE = this.pyq.getVideoHeight();
                this.gRD = this.pyq.getVideoWidth();
                bQ(this.kmK);
                N(this.aLi);
                w.i("MicroMsg.VideoTextureView", "%d open video success player[%s] ", Integer.valueOf(hashCode()), Integer.valueOf(this.pyq.hashCode()));
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.VideoTextureView", e, "prepare async error path", new Object[0]);
                if (this.pvi != null) {
                    this.pvi.onError(-1, -1);
                }
            }
        }
    }

    public final void aKC() {
        if (this.pyq != null && this.sXh && this.nIX != null && this.nIX.isValid()) {
            w.i("MicroMsg.VideoTextureView", "%d flush surface start time[%d] ", Integer.valueOf(hashCode()), Integer.valueOf(getCurrentPosition()));
            this.sXv = true;
            this.pyq.setVolume(0.0f, 0.0f);
            this.pyq.start();
        }
    }

    public final void pause() {
        if (this.pyq != null && this.sXh && this.pyq.isPlaying()) {
            w.d("MicroMsg.VideoTextureView", "pause video.");
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
        if (this.pyq != null && this.sXh) {
            return this.pyq.getCurrentPosition();
        }
        if (this.pyq == null) {
            return -1;
        }
        return 0;
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
        this.mNI = true;
    }

    public final void a(a aVar) {
        this.pvi = aVar;
    }

    public final void onDetach() {
    }

    public final boolean start() {
        if (this.nIX == null) {
            w.w("MicroMsg.VideoTextureView", "%d it surface not ready, do not start", Integer.valueOf(hashCode()));
            this.sWT = true;
            this.sXi = true;
            return false;
        }
        this.startTime = this.startTime == 0 ? bg.Ny() : this.startTime;
        w.i("MicroMsg.VideoTextureView", "start %d mIsPrepared %b pauseWhenUpdated %b", Long.valueOf(this.startTime), Boolean.valueOf(this.sXh), Boolean.valueOf(this.sWU));
        if (this.pyq != null && this.sXh) {
            if (this.sWU) {
                this.sWU = false;
                bQ(this.kmK);
            }
            this.pyq.start();
            this.sXi = true;
            return true;
        } else if (this.pyq == null && this.sXh) {
            this.sXi = true;
            auE();
            requestLayout();
            return true;
        } else {
            this.sXi = true;
            return false;
        }
    }

    public final boolean i(Context context, boolean z) {
        return start();
    }

    public final double bcw() {
        return 0.0d;
    }

    public final void k(double d) {
        if (this.pyq != null) {
            this.pyq.seekTo((int) d);
            this.sXi = true;
            w.d("MicroMsg.VideoTextureView", "seek to time: " + d + " curr pos : " + this.pyq.getCurrentPosition());
        }
    }

    public final void c(double d, boolean z) {
        k(d);
        this.sXi = z;
    }

    public final void he(boolean z) {
    }

    public final long bcx() {
        return this.sWM;
    }

    public final void bQ(boolean z) {
        w.i("MicroMsg.VideoTextureView", "%d set mute %b", Integer.valueOf(hashCode()), Boolean.valueOf(z));
        this.kmK = z;
        if (this.pyq == null) {
            return;
        }
        if (this.kmK) {
            this.pyq.setVolume(0.0f, 0.0f);
        } else {
            this.pyq.setVolume(1.0f, 1.0f);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.gRD == 0 || this.gRE == 0) {
            setMeasuredDimension(1, 1);
            return;
        }
        this.sWX.r(getDefaultSize(1, i), getDefaultSize(1, i2), this.gRD, this.gRE);
        setMeasuredDimension(this.sWX.sXy, this.sWX.sXz);
    }

    public final boolean N(float f) {
        if (f <= 0.0f) {
            return false;
        }
        this.aLi = f;
        if (com.tencent.mm.compatible.util.d.eo(23)) {
            return ar(this.aLi);
        }
        return false;
    }

    private boolean ar(float f) {
        if (VERSION.SDK_INT >= 23) {
            try {
                if (this.pyq != null && com.tencent.mm.compatible.util.d.eo(23)) {
                    PlaybackParams playbackParams = this.pyq.getPlaybackParams();
                    if (playbackParams == null) {
                        playbackParams = new PlaybackParams();
                    }
                    this.pyq.setPlaybackParams(playbackParams.setSpeed(f));
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.VideoTextureView", e, "%s handle play rate error", Integer.valueOf(hashCode()));
                return false;
            }
        }
        return true;
    }
}
