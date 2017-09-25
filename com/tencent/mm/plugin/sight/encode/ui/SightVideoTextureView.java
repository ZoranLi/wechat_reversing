package com.tencent.mm.plugin.sight.encode.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Surface;
import android.view.TextureView;
import android.view.TextureView.SurfaceTextureListener;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.MMTextureView;

@TargetApi(14)
public class SightVideoTextureView extends SightCameraView {
    private String ptO;
    private MediaPlayer pyq;
    private TextureView pyr;
    SurfaceTexture pys;
    private Surface pyt;
    private boolean pyu;
    private boolean pyv;

    public SightVideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.pyr = null;
        this.pys = null;
        this.pyt = null;
        this.pyr = (TextureView) findViewById(R.h.cGR);
        this.pyr.setSurfaceTextureListener(new SurfaceTextureListener(this) {
            final /* synthetic */ SightVideoTextureView pyw;

            {
                this.pyw = r1;
            }

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                w.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureAvailable, [%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                this.pyw.pyd = a.pym;
                this.pyw.pys = surfaceTexture;
                ((MMTextureView) this.pyw.pyr).bSB();
                w.i("MicroMsg.SightVideoTextureView", "available texture %s, wantPlay %B", new Object[]{surfaceTexture, Boolean.valueOf(this.pyw.pyv)});
                if (this.pyw.pyv) {
                    this.pyw.al(this.pyw.ptO, this.pyw.pyu);
                }
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                w.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureSizeChanged, [%d, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                this.pyw.pyd = a.pyn;
                w.i("MicroMsg.SightVideoTextureView", "changed texture %s", new Object[]{surfaceTexture});
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                w.i("MicroMsg.SightVideoTextureView", "onSurfaceTextureDestroyed");
                this.pyw.pyd = a.pyo;
                this.pyw.pys = null;
                this.pyw.pyf = false;
                w.i("MicroMsg.SightVideoTextureView", "destroyed texture %s", new Object[]{surfaceTexture});
                return true;
            }

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }
        });
    }

    public SightVideoTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    protected final void hh(boolean z) {
        if (this.pyq != null) {
            try {
                if (!this.pyq.isPlaying()) {
                    return;
                }
                if (z) {
                    try {
                        this.pyq.setVolume(0.0f, 0.0f);
                        return;
                    } catch (Exception e) {
                        w.w("MicroMsg.SightVideoTextureView", "try to set MediaPlayer Volume 0, 0 Fail: %s", new Object[]{e.getMessage()});
                        return;
                    }
                }
                bdd();
                try {
                    this.pyq.setVolume(1.0f, 1.0f);
                } catch (Exception e2) {
                    w.w("MicroMsg.SightVideoTextureView", "try to set MediaPlayer Volume 1, 1 Fail: %s", new Object[]{e2.getMessage()});
                }
            } catch (Exception e22) {
                w.w("MicroMsg.SightVideoTextureView", "setIsMute %B, check MediaPlayer playing Fail: %s", new Object[]{Boolean.valueOf(z), e22.getMessage()});
            }
        }
    }

    public final void al(final String str, final boolean z) {
        w.i("MicroMsg.SightVideoTextureView", "start play video, path %s, mute %B, wantPlay %B", new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(this.pyv)});
        this.ptO = str;
        this.pyu = z;
        if (this.pys == null) {
            w.w("MicroMsg.SightVideoTextureView", "play video fail, texture is null");
            this.pyv = true;
            return;
        }
        this.pyv = false;
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ SightVideoTextureView pyw;

            public final void run() {
                if (this.pyw.pyq != null) {
                    try {
                        this.pyw.pyq.stop();
                        this.pyw.pyq.release();
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.SightVideoTextureView", e, "", new Object[0]);
                        w.w("MicroMsg.SightVideoTextureView", "try to release mediaplayer error");
                    }
                }
                try {
                    this.pyw.pyq = new i();
                    this.pyw.pyq.setOnCompletionListener(new OnCompletionListener(this) {
                        final /* synthetic */ AnonymousClass2 pyy;

                        {
                            this.pyy = r1;
                        }

                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            w.i("MicroMsg.SightVideoTextureView", "complete playing %s ", new Object[]{str});
                            this.pyy.pyw.bde();
                        }
                    });
                    this.pyw.pyq.setOnErrorListener(new OnErrorListener(this) {
                        final /* synthetic */ AnonymousClass2 pyy;

                        {
                            this.pyy = r1;
                        }

                        public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                            w.i("MicroMsg.SightVideoTextureView", "play %s error", new Object[]{str});
                            return false;
                        }
                    });
                    this.pyw.pyq.setDataSource(str);
                    SightVideoTextureView sightVideoTextureView = this.pyw;
                    SightVideoTextureView sightVideoTextureView2 = this.pyw;
                    sightVideoTextureView.pyt = sightVideoTextureView2.pys != null ? new Surface(sightVideoTextureView2.pys) : null;
                    this.pyw.pyq.setSurface(this.pyw.pyt);
                    this.pyw.pyq.setAudioStreamType(3);
                    if (z) {
                        this.pyw.pyq.setVolume(0.0f, 0.0f);
                    } else {
                        this.pyw.bdd();
                    }
                    this.pyw.pyq.setScreenOnWhilePlaying(true);
                    this.pyw.pyq.setLooping(true);
                    this.pyw.pyq.prepare();
                    this.pyw.pyq.start();
                } catch (Throwable e2) {
                    w.e("MicroMsg.SightVideoTextureView", "play %s, error: %s, %s", new Object[]{str, e2.getMessage(), bg.g(e2)});
                }
            }

            public final String toString() {
                return super.toString() + "|playVideo";
            }
        });
    }

    public final boolean isPlaying() {
        boolean z = false;
        try {
            if (this.pyq != null) {
                z = this.pyq.isPlaying();
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SightVideoTextureView", e, "", new Object[0]);
        }
        return z;
    }

    public final void bcZ() {
        w.i("MicroMsg.SightVideoTextureView", "stop play video, wantPlay %B", new Object[]{Boolean.valueOf(this.pyv)});
        if (this.pyq != null || this.pyv) {
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ SightVideoTextureView pyw;

                {
                    this.pyw = r1;
                }

                public final void run() {
                    try {
                        this.pyw.bde();
                        this.pyw.pyq.stop();
                        this.pyw.pyq.release();
                        if (this.pyw.pyt != null && this.pyw.pyt.isValid()) {
                            this.pyw.pyt.release();
                            this.pyw.pyt = null;
                        }
                    } catch (Throwable e) {
                        w.w("MicroMsg.SightVideoTextureView", "stop play video error: %s, %s", new Object[]{e.getMessage(), bg.g(e)});
                    }
                    this.pyw.pyq = null;
                }

                public final String toString() {
                    return super.toString() + "|stopPlayVideo";
                }
            });
        } else {
            w.w("MicroMsg.SightVideoTextureView", "mediaplayer is null, do nothing when stop play video");
        }
    }

    protected final int bda() {
        if (this.pyr != null) {
            return this.pyr.getWidth();
        }
        return 0;
    }

    protected final int bdb() {
        if (this.pyr != null) {
            return this.pyr.getHeight();
        }
        return 0;
    }

    public final void ak(float f) {
        LayoutParams layoutParams = this.pyr.getLayoutParams();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        w.i("MicroMsg.SightVideoTextureView", "setFixPreviewRate [%f], dm[%d, %d]", new Object[]{Float.valueOf(f), Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels)});
        layoutParams.width = displayMetrics.widthPixels;
        layoutParams.height = (int) (((float) displayMetrics.widthPixels) / f);
        w.i("MicroMsg.SightVideoTextureView", "setFixPreviewRate width:%d, height:%d", new Object[]{Integer.valueOf(layoutParams.width), Integer.valueOf(layoutParams.height)});
        this.pyr.setLayoutParams(layoutParams);
        DisplayMetrics displayMetrics2 = getResources().getDisplayMetrics();
        LayoutParams layoutParams2 = getLayoutParams();
        layoutParams2.width = displayMetrics2.widthPixels;
        layoutParams2.height = (int) (((float) displayMetrics2.widthPixels) / f);
        w.i("MicroMsg.SightCameraView", "resizeLayout width:%d, height:%d, previewRate %f", new Object[]{Integer.valueOf(layoutParams2.width), Integer.valueOf(layoutParams2.height), Float.valueOf(f)});
        postInvalidate();
    }
}
