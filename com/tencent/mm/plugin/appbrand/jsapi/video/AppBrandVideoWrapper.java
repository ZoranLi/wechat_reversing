package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.q;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.h.a;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.d;

public class AppBrandVideoWrapper extends RelativeLayout implements h, a, b, c, d.a {
    private h iWU;
    b iWV;
    private g iWW;
    private h.d iWX;
    private boolean iWY;
    private float iWZ;
    private int iXa;
    private boolean iXb;
    private boolean iXc;
    private d iXd;
    private Context mContext;
    private String url;

    public AppBrandVideoWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppBrandVideoWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iWX = h.d.sIX;
        this.iWY = false;
        this.iWZ = -1.0f;
        this.mContext = context;
        this.iXd = new d();
    }

    public final void b(boolean z, String str, int i) {
        boolean z2;
        int i2 = 1;
        this.iXa = i;
        this.iXb = z;
        PString pString = new PString();
        pString.value = str;
        if (bg.mA(pString.value) || pString.value.indexOf("wxfile://") != 0) {
            z2 = false;
        } else {
            pString.value = pString.value.substring(9);
            z2 = true;
        }
        this.iXc = z2;
        this.url = pString.value;
        if (this.iWU == null) {
            if (a(this.iXb, this.url, "")) {
                w.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[]{Integer.valueOf(hashCode())});
                this.iWU = Ur();
            } else {
                w.i("MicroMsg.AppBrandVideoWrapper", "%d use mm video view !", new Object[]{Integer.valueOf(hashCode())});
                this.iWU = Us();
            }
        } else if (a(this.iXb, this.url, "")) {
            if (this.iWU instanceof MMVideoView) {
                this.iWU.stop();
                this.iWU.Ut();
                removeView((View) this.iWU);
                w.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[]{Integer.valueOf(hashCode())});
                this.iWU = Ur();
            } else {
                w.i("MicroMsg.AppBrandVideoWrapper", "%d use last common video view !", new Object[]{Integer.valueOf(hashCode())});
                this.iWU.stop();
                i2 = 0;
            }
        } else if (this.iWU instanceof CommonVideoView) {
            this.iWU.stop();
            this.iWU.Ut();
            removeView((View) this.iWU);
            w.i("MicroMsg.AppBrandVideoWrapper", "%d use mm video view !", new Object[]{Integer.valueOf(hashCode())});
            this.iWU = Us();
        } else {
            w.i("MicroMsg.AppBrandVideoWrapper", "%d use last mm video view !", new Object[]{Integer.valueOf(hashCode())});
            this.iWU.stop();
            i2 = 0;
        }
        a(this.iWX);
        N(this.iWZ);
        bQ(this.iWY);
        if (i2 != 0) {
            a(this.iWW);
            LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.addRule(13);
            addView((View) this.iWU, layoutParams);
        }
        this.iWU.b(this.iXb, this.url, this.iXa);
    }

    private h Ur() {
        h commonVideoView = new CommonVideoView(this.mContext);
        commonVideoView.sHT = this;
        commonVideoView.a((b) this);
        a(600, 200, 1, false);
        return commonVideoView;
    }

    private h Us() {
        h mMVideoView = new MMVideoView(this.mContext);
        mMVideoView.sHT = this;
        mMVideoView.a((b) this);
        mMVideoView.hYb = new AppBrandOnlineVideoProxy();
        mMVideoView.hYb.a(mMVideoView);
        mMVideoView.hYe = this;
        String str = e.hgu + "appbrandvideo/";
        com.tencent.mm.sdk.platformtools.h.KS(str);
        mMVideoView.hYa = str;
        a(600, 201, 1, false);
        return mMVideoView;
    }

    private boolean a(boolean z, String str, String str2) {
        if (z || this.iXc) {
            return true;
        }
        if (com.tencent.mm.compatible.util.d.ep(18)) {
            return true;
        }
        w.d("MicroMsg.AppBrandVideoWrapper", "checkUseSystemPlayer abtestFlag[%d]", new Object[]{Integer.valueOf(ab.getContext().getSharedPreferences("system_config_prefs", 4).getInt("appbrand_video_player", -1))});
        if (ab.getContext().getSharedPreferences("system_config_prefs", 4).getInt("appbrand_video_player", -1) <= 0) {
            w.i("MicroMsg.AppBrandVideoWrapper", "abtest is zero, use system player");
            return true;
        } else if (!bg.mA(str) && str.contains(".m3u8")) {
            w.i("MicroMsg.AppBrandVideoWrapper", "%d it is m3u8 file use system player.", new Object[]{Integer.valueOf(hashCode())});
            a(600, 204, 1, false);
            return true;
        } else if (!q.lq(str2)) {
            return false;
        } else {
            w.i("MicroMsg.AppBrandVideoWrapper", "%d it is m3u8 file use system player.", new Object[]{Integer.valueOf(hashCode())});
            a(600, 204, 1, false);
            return true;
        }
    }

    public final void a(g gVar) {
        this.iWW = gVar;
        if (this.iWU != null) {
            this.iWU.a(this.iWW);
        }
    }

    public final void Ut() {
        if (this.iWU != null) {
            this.iWU.Ut();
        }
    }

    public final boolean hS(int i) {
        if (this.iWU != null) {
            return this.iWU.hS(i);
        }
        return false;
    }

    public final boolean w(int i, boolean z) {
        if (this.iWU != null) {
            return this.iWU.w(i, z);
        }
        return false;
    }

    public final int Uu() {
        if (this.iWU != null) {
            return this.iWU.Uu();
        }
        return this.iXa;
    }

    public final int Uv() {
        if (this.iWU != null) {
            return this.iWU.Uv();
        }
        return 0;
    }

    public final int Uw() {
        if (this.iWU != null) {
            return this.iWU.Uw();
        }
        return 0;
    }

    public final int KI() {
        if (this.iWU != null) {
            return this.iWU.KI();
        }
        return 0;
    }

    public final boolean isPlaying() {
        if (this.iWU != null) {
            return this.iWU.isPlaying();
        }
        return false;
    }

    public final boolean Ux() {
        if (this.iWU != null) {
            return this.iWU.Ux();
        }
        return false;
    }

    public final void start() {
        if (this.iWU != null) {
            this.iWU.start();
            setKeepScreenOn(true);
            this.iXd.a(this);
        }
    }

    public final void stop() {
        if (this.iWU != null) {
            this.iWU.stop();
            this.iXd.aS(false);
            setKeepScreenOn(false);
        }
    }

    public final boolean pause() {
        if (this.iWU == null) {
            return false;
        }
        setKeepScreenOn(false);
        this.iXd.aS(false);
        return this.iWU.pause();
    }

    public final void bQ(boolean z) {
        this.iWY = z;
        if (this.iWU != null) {
            this.iWU.bQ(this.iWY);
        }
    }

    public final void KF() {
        if (this.iWU != null) {
            this.iWU.KF();
        }
    }

    public final void KE() {
        if (this.iWU != null) {
            this.iWU.KE();
        }
        this.iXd.aS(false);
        setKeepScreenOn(false);
    }

    public final void Uy() {
        if (this.iWU != null) {
            this.iWU.Uy();
        }
        this.iXd.aS(false);
        setKeepScreenOn(false);
    }

    public final void a(h.d dVar) {
        this.iWX = dVar;
        if (this.iWU != null) {
            this.iWU.a(this.iWX);
        }
    }

    public final boolean N(float f) {
        if (f <= 0.0f) {
            return false;
        }
        this.iWZ = f;
        if (this.iWU != null) {
            return this.iWU.N(this.iWZ);
        }
        return false;
    }

    public final void K(String str, boolean z) {
        w.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[]{Integer.valueOf(hashCode()), str, Boolean.valueOf(z)});
        if (!z) {
            int i;
            boolean z2;
            if (a(false, "", str)) {
                if (this.iWU instanceof MMVideoView) {
                    this.iWU.stop();
                    this.iWU.Ut();
                    removeView((View) this.iWU);
                    w.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use common video view !", new Object[]{Integer.valueOf(hashCode())});
                    this.iWU = Ur();
                    i = 1;
                }
                z2 = false;
            } else {
                if (this.iWU instanceof CommonVideoView) {
                    this.iWU.stop();
                    this.iWU.Ut();
                    removeView((View) this.iWU);
                    w.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use mm video view !", new Object[]{Integer.valueOf(hashCode())});
                    this.iWU = Us();
                    i = 1;
                }
                z2 = false;
            }
            a(this.iWX);
            N(this.iWZ);
            bQ(this.iWY);
            if (i != 0) {
                a(this.iWW);
                LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(13);
                addView((View) this.iWU, layoutParams);
                this.iWU.b(this.iXb, this.url, this.iXa);
                this.iWU.start();
            }
        }
    }

    public final void onError(int i, int i2) {
        w.w("MicroMsg.AppBrandVideoWrapper", "%d onError[%d, %d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.iWV != null) {
            this.iWV.onError(i, i2);
        }
    }

    public final void Uc() {
        w.i("MicroMsg.AppBrandVideoWrapper", "%d onPrepared", new Object[]{Integer.valueOf(hashCode())});
        if (this.iWV != null) {
            this.iWV.Uc();
        }
        if (Ux()) {
            a(600, 203, 1, false);
        } else {
            a(600, 202, 1, false);
        }
    }

    public final void Ud() {
        w.i("MicroMsg.AppBrandVideoWrapper", "%d onVideoEnded", new Object[]{Integer.valueOf(hashCode())});
        if (this.iWV != null) {
            this.iWV.Ud();
        }
    }

    public final void bp(int i, int i2) {
        w.i("MicroMsg.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.iWV != null) {
            this.iWV.bp(i, i2);
        }
    }

    public final void Ue() {
        w.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPause", new Object[]{Integer.valueOf(hashCode())});
        setKeepScreenOn(false);
        this.iXd.aS(false);
        if (this.iWV != null) {
            this.iWV.Ue();
        }
    }

    public final void Uf() {
        w.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPlay", new Object[]{Integer.valueOf(hashCode())});
        setKeepScreenOn(true);
        this.iXd.a(this);
        if (this.iWV != null) {
            this.iWV.Uf();
        }
    }

    public void setKeepScreenOn(boolean z) {
        w.d("MicroMsg.AppBrandVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[]{Boolean.valueOf(z), bg.bJZ()});
        super.setKeepScreenOn(z);
    }

    public final void a(long j, long j2, long j3, boolean z) {
        com.tencent.mm.plugin.report.service.g.oUh.a(600, j2, 1, false);
    }

    public final void A(int i, String str) {
        com.tencent.mm.plugin.report.service.g.oUh.A(14349, str);
    }
}
