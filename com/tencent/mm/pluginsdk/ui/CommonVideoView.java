package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class CommonVideoView extends AbstractVideoView {
    protected int iXa;
    protected boolean iXb;
    public String url;

    public CommonVideoView(Context context) {
        super(context);
    }

    public CommonVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CommonVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void KC() {
        super.KC();
        this.TAG = "MicroMsg.CommonVideoView";
    }

    public void b(boolean z, String str, int i) {
        w.i(this.TAG, "%s set video path isLive [%b] url [%s] durationSec [%d]", new Object[]{bDS(), Boolean.valueOf(z), str, Integer.valueOf(i)});
        this.iXb = z;
        this.url = str;
        this.iXa = i;
        MC(str);
    }

    public f bm(Context context) {
        this.sHM = 0;
        return new VideoTextureView(context);
    }

    public void start() {
        if (this.kmM != null) {
            w.i(this.TAG, "%s start path [%s] [%s]", new Object[]{bDS(), this.kmM.Ls(), bg.bJZ()});
            if (bg.mA(this.kmM.Ls())) {
                this.kmM.setVideoPath(this.url);
                Xy();
                bjy();
            } else {
                play();
            }
            ei((long) (KK() + 1));
        }
    }

    public void a(d dVar) {
        if (this.kmM instanceof VideoTextureView) {
            VideoTextureView videoTextureView = (VideoTextureView) this.kmM;
            videoTextureView.sWX.a(dVar);
            videoTextureView.requestLayout();
            ei((long) (KK() + 14));
        }
    }

    public final boolean N(float f) {
        w.i(this.TAG, "%s set play rate [%f]", new Object[]{bDS(), Float.valueOf(f)});
        if (!(this.kmM instanceof VideoTextureView)) {
            return false;
        }
        ei((long) (KK() + 13));
        return ((VideoTextureView) this.kmM).N(f);
    }

    public final int Uu() {
        if (this.iXa <= 0) {
            return super.Uu();
        }
        return this.iXa;
    }

    public int KI() {
        try {
            if (this.kmM instanceof VideoTextureView) {
                return (int) (((((float) ((VideoTextureView) this.kmM).sXr) * 1.0f) / 100.0f) * ((float) super.Uu()));
            }
        } catch (Throwable e) {
            w.printErrStackTrace(this.TAG, e, "%s get cache time sec error", new Object[]{bDS()});
        }
        return 0;
    }

    public boolean w(int i, boolean z) {
        if (!Ux()) {
            return super.w(i, z);
        }
        w.w(this.TAG, "%s it is live, don't seek ", new Object[]{bDS()});
        return false;
    }

    public void KF() {
        super.KF();
        if (this.kmM != null && (this.kmM instanceof VideoTextureView)) {
            if (this.sHL) {
                play();
            } else {
                ((VideoTextureView) this.kmM).aKC();
            }
        }
    }

    public void KE() {
        super.KE();
    }

    public final void dH(int i, int i2) {
        w.d(this.TAG, "%s onInfo [%d %d]", new Object[]{bDS(), Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 701) {
            Xy();
            bDX();
            bDV();
            ei((long) (KK() + 40));
        } else if (i == 702) {
            aFI();
            bDW();
            bDY();
        }
    }

    public void oW() {
        if (Ux()) {
            w.i(this.TAG, "%s it is live video, do not completion", new Object[]{bDS()});
            stop();
            start();
            return;
        }
        super.oW();
    }

    public final boolean Ux() {
        boolean isPrepared = isPrepared();
        int duration = this.kmM.getDuration();
        if (this.iXb) {
            isPrepared = true;
        } else if (!isPrepared || duration > 0) {
            isPrepared = false;
        } else {
            isPrepared = true;
        }
        w.d(this.TAG, "%s is live video result [%b] isPrepared[%b] durationMs[%d] isLive[%b]", new Object[]{bDS(), Boolean.valueOf(isPrepared), Boolean.valueOf(isPrepared()), Integer.valueOf(duration), Boolean.valueOf(this.iXb)});
        return isPrepared;
    }

    public int KK() {
        return 0;
    }
}
