package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.plugin.s.b;
import com.tencent.mm.plugin.s.i;
import com.tencent.mm.plugin.s.k;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.c;
import com.tencent.mm.pluginsdk.ui.tools.f.d;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMTextureView;

public class VideoPlayerTextureView extends MMTextureView implements f {
    private boolean Ht;
    private int gRD;
    private int gRE;
    private boolean kmK;
    public Surface nIX;
    private boolean nzn;
    private boolean nzo;
    public b nzx;
    private String path;
    public a pvi;
    public i sWJ;
    private int sWK;
    private boolean sWL;
    private long sWM;
    private boolean sWN;
    public boolean sWO;
    private e sWP;
    private c sWQ;
    private d sWR;
    private boolean sWS;
    private boolean sWT;
    public boolean sWU;
    private com.tencent.mm.plugin.s.c sWV;
    private SurfaceTextureListener sWW;
    public o sWX;

    static /* synthetic */ void i(VideoPlayerTextureView videoPlayerTextureView) {
        LayoutParams layoutParams = (LayoutParams) videoPlayerTextureView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.addRule(13);
            videoPlayerTextureView.setLayoutParams(layoutParams);
        }
    }

    public VideoPlayerTextureView(Context context) {
        this(context, null);
    }

    public VideoPlayerTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoPlayerTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gRE = 0;
        this.gRD = 0;
        this.sWK = 0;
        this.Ht = false;
        this.sWL = true;
        this.sWM = 0;
        this.sWN = false;
        this.sWO = false;
        this.nzn = false;
        this.nzo = false;
        this.sWS = false;
        this.sWT = false;
        this.sWU = false;
        this.sWV = new com.tencent.mm.plugin.s.c(this) {
            final /* synthetic */ VideoPlayerTextureView sWY;

            {
                this.sWY = r1;
            }

            public final void Uc() {
                this.sWY.Ht = true;
                this.sWY.bQ(this.sWY.kmK);
                if (this.sWY.pvi != null) {
                    this.sWY.pvi.Uc();
                }
                this.sWY.requestLayout();
            }

            public final void oW() {
                if (this.sWY.pvi != null) {
                    this.sWY.pvi.oW();
                }
            }

            public final void onError(int i, int i2) {
                if (this.sWY.pvi != null) {
                    this.sWY.pvi.onError(i, i2);
                }
            }

            public final void aKn() {
                if (this.sWY.sWQ != null) {
                    this.sWY.sWQ.br(this.sWY.sWL);
                }
                if (!this.sWY.sWL) {
                    w.d("MicroMsg.VideoPlayerTextureView", "player seek done, but don't play now.");
                    this.sWY.sWL = true;
                } else if (this.sWY.sWJ != null) {
                    w.d("MicroMsg.VideoPlayerTextureView", "%s player seek done", this.sWY.sWJ.aKs());
                    this.sWY.sWJ.start();
                }
            }

            public final void E(int i, int i2, int i3) {
                w.i("MicroMsg.VideoPlayerTextureView", "video size changed size[%d, %d] degrees[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
                this.sWY.sWX.reset();
                this.sWY.sWK = i3;
                this.sWY.gRD = i;
                this.sWY.gRE = i2;
                VideoPlayerTextureView.i(this.sWY);
                if (this.sWY.pvi != null) {
                    this.sWY.pvi.bp(this.sWY.gRD, this.sWY.gRE);
                }
            }
        };
        this.sWW = new SurfaceTextureListener(this) {
            final /* synthetic */ VideoPlayerTextureView sWY;

            {
                this.sWY = r1;
            }

            public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                w.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] available [%d, %d] pauseByDestroyed[%b]", Integer.valueOf(this.sWY.hashCode()), Integer.valueOf(surfaceTexture.hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.sWY.sWT));
                try {
                    this.sWY.bSB();
                    this.sWY.nIX = new Surface(surfaceTexture);
                    if (this.sWY.sWJ == null || !this.sWY.Ht) {
                        this.sWY.auE();
                    } else {
                        i g = this.sWY.sWJ;
                        Surface o = this.sWY.nIX;
                        if (o != null) {
                            w.i("MicroMsg.VideoPlayerImpl", "%s change surface[%d] ", g.nzQ.nzu.aKs(), Integer.valueOf(o.hashCode()));
                            k kVar = r0.nzZ;
                            w.i("MicroMsg.VideoTrackDataSource", "%s set out put surface", kVar.aKs());
                            kVar.nAg = o;
                            if (com.tencent.mm.compatible.util.d.eo(23)) {
                                kVar.aKE();
                            } else {
                                kVar.aKF();
                            }
                        }
                        if (this.sWY.sWT) {
                            this.sWY.sWJ.start();
                        } else {
                            this.sWY.sWU = true;
                            this.sWY.sWM = 0;
                            this.sWY.sWJ.bQ(true);
                            this.sWY.sWJ.start();
                        }
                        this.sWY.sWT = false;
                    }
                    VideoPlayerTextureView.i(this.sWY);
                    if (this.sWY.sWR != null) {
                        this.sWY.sWR.KJ();
                    }
                } catch (Exception e) {
                }
            }

            public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
                w.d("MicroMsg.VideoPlayerTextureView", "surface[%d] size changed [%d, %d]", Integer.valueOf(surfaceTexture.hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
                VideoPlayerTextureView.i(this.sWY);
            }

            public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                w.i("MicroMsg.VideoPlayerTextureView", "%d surface[%d] destroyed", Integer.valueOf(this.sWY.hashCode()), Integer.valueOf(surfaceTexture.hashCode()));
                this.sWY.nIX = null;
                this.sWY.sWT = false;
                this.sWY.sWU = false;
                if (this.sWY.sWJ == null) {
                    this.sWY.sWT = false;
                } else if (this.sWY.isPlaying()) {
                    this.sWY.sWT = true;
                    this.sWY.sWJ.pause();
                }
                return false;
            }

            public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
                if (this.sWY.sWU && this.sWY.sWM > 0) {
                    this.sWY.sWJ.pause();
                    this.sWY.sWJ.bQ(this.sWY.kmK);
                    this.sWY.sWU = false;
                }
                if (this.sWY.sWM > 0 && this.sWY.sWP != null) {
                    w.i("MicroMsg.VideoPlayerTextureView", "%d notify surface update", Integer.valueOf(this.sWY.hashCode()));
                    this.sWY.sWP.aMm();
                    this.sWY.sWP = null;
                }
                this.sWY.sWM = System.currentTimeMillis();
            }
        };
        this.sWX = new o();
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

    public final void a(f.b bVar) {
    }

    public final void a(d dVar) {
        this.sWR = dVar;
    }

    public final void fB(boolean z) {
        this.nzn = z;
        if (this.sWJ != null) {
            this.sWJ.fB(z);
        }
    }

    public final void fC(boolean z) {
        this.nzo = z;
        if (this.sWJ != null) {
            this.sWJ.fC(z);
        }
    }

    public final boolean isPlaying() {
        if (this.sWJ != null) {
            return this.sWJ.isPlaying();
        }
        return false;
    }

    public final void setVideoPath(String str) {
        w.i("MicroMsg.VideoPlayerTextureView", "%d set video path [%s]", Integer.valueOf(hashCode()), str);
        this.path = str;
        auE();
        requestLayout();
    }

    public final String Ls() {
        return this.path;
    }

    public final boolean start() {
        if (this.sWJ == null || !this.Ht) {
            boolean z;
            String str = "MicroMsg.VideoPlayerTextureView";
            String str2 = "%d player is null[%b] or it prepared [%b]";
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(hashCode());
            if (this.sWJ == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = Boolean.valueOf(this.Ht);
            w.w(str, str2, objArr);
            return false;
        }
        str = "MicroMsg.VideoPlayerTextureView";
        str2 = "%d player start pauseWhenUpdated[%b] pauseByDestroyed[%b] surface[%b]";
        objArr = new Object[4];
        objArr[0] = Integer.valueOf(hashCode());
        objArr[1] = Boolean.valueOf(this.sWU);
        objArr[2] = Boolean.valueOf(this.sWT);
        objArr[3] = Boolean.valueOf(this.nIX != null);
        w.i(str, str2, objArr);
        if (this.nIX == null) {
            this.sWT = true;
            return true;
        } else if (this.sWU) {
            this.sWT = true;
            this.sWU = false;
            bQ(this.kmK);
            return true;
        } else {
            this.sWJ.start();
            return true;
        }
    }

    public final boolean i(Context context, boolean z) {
        return start();
    }

    public final void stop() {
        w.i("MicroMsg.VideoPlayerTextureView", "%d player stop", Integer.valueOf(hashCode()));
        if (this.sWJ != null) {
            this.sWJ.nzR = null;
            this.sWJ.nzQ.stop();
            this.sWJ.release();
            this.sWJ = null;
        }
        this.sWX.reset();
        this.Ht = false;
        this.path = null;
        this.sWM = 0;
    }

    public final void pause() {
        if (this.sWJ != null && this.sWJ.isPlaying()) {
            this.sWJ.pause();
        }
        this.sWT = false;
    }

    public final void onDetach() {
    }

    public final void bN(boolean z) {
    }

    public final void a(a aVar) {
        this.pvi = aVar;
    }

    public final int getCurrentPosition() {
        if (this.sWJ != null) {
            return this.sWJ.aKA();
        }
        return 0;
    }

    public final int getDuration() {
        if (this.sWJ != null) {
            return (int) this.sWJ.nzQ.nzB;
        }
        return 0;
    }

    public final double bcw() {
        return 0.0d;
    }

    public final void k(double d) {
        if (this.sWJ != null) {
            this.sWJ.pu((int) d);
        }
    }

    public final void c(double d, boolean z) {
        this.sWL = z;
        k(d);
    }

    public final void he(boolean z) {
    }

    public final long bcx() {
        return this.sWM;
    }

    public final void bQ(boolean z) {
        this.kmK = z;
        if (this.sWJ != null) {
            w.i("MicroMsg.VideoPlayerTextureView", "%d set mute [%b]", Integer.valueOf(hashCode()), Boolean.valueOf(z));
            this.sWJ.bQ(z);
        }
    }

    private void auE() {
        w.i("MicroMsg.VideoPlayerTextureView", "%d open video [%s]", Integer.valueOf(hashCode()), this.path);
        if (this.sWJ != null) {
            this.sWJ.nzR = null;
            this.sWJ.nzQ.stop();
            this.sWJ.release();
            this.sWJ = null;
        }
        if (bg.mA(this.path) || this.nIX == null) {
            w.w("MicroMsg.VideoPlayerTextureView", "%d open video but path is null or mSurface is null", Integer.valueOf(hashCode()));
            return;
        }
        try {
            this.Ht = false;
            this.sWJ = new i(Looper.getMainLooper());
            this.sWJ.setPath(this.path);
            i iVar = this.sWJ;
            b bVar = this.nzx;
            if (!(bVar == null || iVar.nzQ == null)) {
                iVar.nzQ.nzZ.nzx = bVar;
            }
            this.sWJ.fB(this.nzn);
            this.sWJ.fC(this.nzo);
            this.sWJ.nzR = this.sWV;
            this.sWJ.setSurface(this.nIX);
            this.sWJ.nzQ.nzZ.nAj = this.sWS;
            if (this.nIX != null) {
                this.sWJ.aKz();
            } else if (this.sWO) {
                this.sWJ.aKz();
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.VideoPlayerTextureView", e, "prepare async error %s", e.getMessage());
            if (this.pvi != null) {
                this.pvi.onError(-1, -1);
            }
        }
    }

    public final void aKC() {
        if (this.sWJ != null && this.Ht) {
            w.i("MicroMsg.VideoPlayerTextureView", "%d flush surface start ", Integer.valueOf(hashCode()));
            i iVar = this.sWJ;
            if (iVar.nzQ != null) {
                iVar.nzQ.aKC();
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.gRD == 0 || this.gRE == 0) {
            setMeasuredDimension(1, 1);
            return;
        }
        this.sWX.r(getDefaultSize(1, i), getDefaultSize(1, i2), this.gRD, this.gRE);
        int i3 = this.sWX.sXy;
        int i4 = this.sWX.sXz;
        if (this.sWK == 90 || this.sWK == 270) {
            Matrix matrix = new Matrix();
            matrix.set(getMatrix());
            float f = ((float) i3) / 2.0f;
            float f2 = ((float) i4) / 2.0f;
            float f3 = ((float) i4) / ((float) i3);
            matrix.postRotate((float) this.sWK, f, f2);
            matrix.postScale(1.0f / f3, f3, f, f2);
            setTransform(matrix);
        }
        setMeasuredDimension(i3, i4);
    }
}
