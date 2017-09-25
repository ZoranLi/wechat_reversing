package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class MMVideoView extends CommonVideoView implements com.tencent.mm.modelvideo.b.a {
    public String hYa;
    public b hYb;
    private String hYc;
    private String hYd;
    public com.tencent.mm.pluginsdk.ui.h.a hYe;
    private int hYf = 0;
    private int hYg = 0;
    private f hYh;
    private int hYi;
    private int hYj;
    private boolean hYk;
    private boolean hYl;
    private int hYm = 0;
    private int hYn;
    private boolean hYo = false;
    private boolean hYp = false;
    private boolean hYq = false;
    private a hYr;
    private boolean hYs = false;
    private aj hYt = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ MMVideoView hYu;

        {
            this.hYu = r1;
        }

        public final boolean oQ() {
            if (this.hYu.kmM == null) {
                return false;
            }
            boolean b;
            boolean isPlaying = this.hYu.kmM.isPlaying();
            if (isPlaying) {
                this.hYu.aFI();
            }
            try {
                int currentPosition = this.hYu.kmM.getCurrentPosition() / 1000;
                this.hYu.nN(currentPosition);
                b = this.hYu.gL(currentPosition);
            } catch (Exception e) {
                w.e(this.hYu.TAG, "%s online video timer check error [%s] ", new Object[]{this.hYu.bDS(), e.toString()});
                b = false;
            }
            if (b && isPlaying) {
                return true;
            }
            return false;
        }
    }, true);

    private static class a {
        int hYv;
        int hYw;
    }

    public MMVideoView(Context context) {
        super(context);
    }

    public MMVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MMVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected final void KC() {
        super.KC();
        this.TAG = "MicroMsg.MMVideoView";
        this.hYh = new f();
        this.hYr = new a();
        this.hYr.hYv = 5;
        this.hYr.hYw = 2;
        reset();
    }

    private void reset() {
        this.hYj = -1;
        this.hYm = 0;
        this.hYi = 0;
        this.hYg = 0;
        this.hYf = 0;
        this.hYl = false;
        this.hYo = false;
        this.hYp = false;
        if (this.hYr != null) {
            this.hYn = this.hYr.hYv;
        }
    }

    public final void b(boolean z, String str, int i) {
        super.b(z, str, i);
        this.hYc = "MMVideo_" + str.hashCode();
        this.hYd = (!bg.mA(this.hYa) ? this.hYa : e.hgu + "appbrandvideo/") + "MMVideo_" + str.hashCode() + ".mp4";
        com.tencent.mm.a.e.aU(this.hYd);
        w.i(this.TAG, "%s set video path [%s %s]", new Object[]{bDS(), this.hYc, this.hYd});
    }

    private void KD() {
        if (this.kmM != null) {
            this.hYo = true;
            this.kmM.setVideoPath(this.hYd);
        }
    }

    public final void KE() {
        super.KE();
        if (this.hYs) {
            this.hYq = true;
            stop();
        }
    }

    public final void KF() {
        super.KF();
        w.i(this.TAG, "%s onUIResume stopDownloadByUiPause[%b] currTimeOnUiPause[%d] isPlayOnUiPause[%b]", new Object[]{bDS(), Boolean.valueOf(this.hYq), Integer.valueOf(this.sHK), Boolean.valueOf(this.sHL)});
        if (this.hYq) {
            w(this.sHK, this.sHL);
        } else if (this.kmM != null && d.eo(24) && (this.kmM instanceof VideoPlayerTextureView)) {
            ((VideoPlayerTextureView) this.kmM).aKC();
        }
    }

    public final void start() {
        w.i(this.TAG, "%s start cdnMediaId[%s] ", new Object[]{bDS(), this.hYc});
        if (this.kmM != null) {
            if (bg.mA(this.kmM.Ls())) {
                Xy();
                this.hYs = true;
                this.hYf = 1;
                this.hYb.n(this.hYc, this.hYd, this.url);
                this.hYb.a(this);
                bjy();
            } else {
                play();
            }
            ei(101);
        }
    }

    public final void oW() {
        super.oW();
        this.hYb.lk(this.hYc);
        reset();
        if (this.kmM != null) {
            this.kmM.stop();
        }
    }

    public final void stop() {
        this.hYb.lk(this.hYc);
        reset();
        super.stop();
    }

    protected final com.tencent.mm.pluginsdk.ui.tools.f bm(Context context) {
        this.sHM = 1;
        com.tencent.mm.pluginsdk.ui.tools.f videoPlayerTextureView = new VideoPlayerTextureView(context);
        videoPlayerTextureView.fB(true);
        return videoPlayerTextureView;
    }

    public final void a(h.d dVar) {
        if (this.kmM instanceof VideoPlayerTextureView) {
            VideoPlayerTextureView videoPlayerTextureView = (VideoPlayerTextureView) this.kmM;
            videoPlayerTextureView.sWX.a(dVar);
            videoPlayerTextureView.requestLayout();
            ei(114);
        }
    }

    private boolean gL(int i) {
        int i2;
        boolean z = false;
        if (this.hYj != -1) {
            i2 = this.hYj;
        } else {
            i2 = i;
        }
        w.i(this.TAG, "%s check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s isPrepareVideo[%b]", new Object[]{bDS(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.hYm), Integer.valueOf(this.hYi), Integer.valueOf(this.hYg), Integer.valueOf(this.hYf), this.hYc, Boolean.valueOf(this.hYo)});
        switch (this.hYf) {
            case 1:
                boolean z2;
                if (!gM(i2)) {
                    this.hYl = true;
                    if (this.hYm > 0) {
                        w.i(this.TAG, "%s pause by load data cdnMediaId %s, playStatus %d", new Object[]{bDS(), this.hYc, Integer.valueOf(this.hYg)});
                        bDV();
                        if (!(this.hYg == 2 || this.hYg == 4)) {
                            this.hYn += this.hYr.hYv;
                            this.hYn = Math.min(this.hYn, 60);
                            bDX();
                            this.hYg = 4;
                        }
                        KG();
                    } else if (this.hYj == -1) {
                        this.hYg = 1;
                    } else {
                        this.hYg = 2;
                    }
                    z2 = false;
                } else if (this.hYo) {
                    MMVideoView mMVideoView;
                    int i3;
                    nN(i2);
                    if (this.hYl) {
                        bDW();
                        bDY();
                        w.i(this.TAG, "%s resume by data gain cdnMediaId %s", new Object[]{bDS(), this.hYc});
                        if (this.hYj != -1) {
                            w(this.hYj, this.hYk);
                            this.hYj = -1;
                            z2 = false;
                            mMVideoView = this;
                        } else if (play()) {
                            z2 = false;
                            mMVideoView = this;
                        } else {
                            z2 = true;
                            mMVideoView = this;
                        }
                        mMVideoView.hYl = z2;
                        i3 = 3;
                        mMVideoView = this;
                    } else {
                        if (this.hYg != 3) {
                            w.i(this.TAG, "%s start to play video playStatus[%d]", new Object[]{bDS(), Integer.valueOf(this.hYg)});
                            if (play()) {
                                i3 = 3;
                                mMVideoView = this;
                            } else {
                                i3 = this.hYg;
                                mMVideoView = this;
                            }
                        }
                        z2 = true;
                    }
                    mMVideoView.hYg = i3;
                    z2 = true;
                } else {
                    w.i(this.TAG, "%s prepare cdnMediaId [%s]", new Object[]{bDS(), this.hYc});
                    KD();
                    z2 = true;
                }
                nN(i2);
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                if (!a(i2, pInt, pInt2)) {
                    w.d(this.TAG, "%s can not calc download.", new Object[]{bDS()});
                } else if (g(pInt.value, pInt2.value, false)) {
                    this.hYm = Math.max(this.hYm, pInt2.value);
                    return true;
                }
                return z2;
            case 2:
                w.w(this.TAG, "%s download error.", new Object[]{bDS()});
                return false;
            case 3:
                if (this.hYo) {
                    if (this.hYl) {
                        MMVideoView mMVideoView2;
                        if (this.hYj != -1) {
                            w(this.hYj, true);
                            this.hYj = -1;
                            mMVideoView2 = this;
                        } else if (play()) {
                            mMVideoView2 = this;
                        } else {
                            z = true;
                            mMVideoView2 = this;
                        }
                        mMVideoView2.hYl = z;
                    }
                    nN(i2);
                    return true;
                }
                KD();
                return true;
            default:
                w.w(this.TAG, "%s check time default.", new Object[]{bDS()});
                return false;
        }
    }

    public final boolean w(int i, boolean z) {
        boolean z2;
        switch (this.hYf) {
            case 0:
                if (!isPrepared()) {
                    this.sHN = this.sHL;
                    this.sHO = this.sHK;
                    start();
                    break;
                }
                break;
            case 1:
                this.hYg = 2;
                PInt pInt = new PInt();
                PInt pInt2 = new PInt();
                a(i, pInt, pInt2);
                if (!g(pInt.value, pInt2.value, true)) {
                    this.hYj = i;
                    this.hYk = z;
                    this.hYl = true;
                    KG();
                    z2 = false;
                    break;
                }
                this.hYj = -1;
                this.hYl = false;
                this.hYm = pInt2.value;
                this.hYg = 3;
                super.w(i, z);
                z2 = true;
                break;
            case 2:
                z2 = true;
                break;
            case 3:
                super.w(i, z);
                z2 = true;
                break;
        }
        z2 = true;
        w.i(this.TAG, "%s seek video time %d, download status %d playStatus %d", new Object[]{bDS(), Integer.valueOf(i), Integer.valueOf(this.hYf), Integer.valueOf(this.hYg)});
        return z2;
    }

    public final void br(boolean z) {
        super.br(z);
        aFI();
    }

    private boolean gM(int i) {
        Exception e;
        if (this.hYf == 3) {
            return true;
        }
        if (this.hYm - i <= 1 && this.hYm < this.hYi) {
            return false;
        }
        boolean ba;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.hYh.a(i, i + 1, pInt, pInt2)) {
                ba = this.hYb.ba(pInt.value, pInt2.value);
                if (!ba) {
                    try {
                        this.hYm = i;
                    } catch (Exception e2) {
                        e = e2;
                        w.e(this.TAG, "%s check video data error %s ", new Object[]{bDS(), e.toString()});
                        return ba;
                    }
                }
            }
            ba = false;
        } catch (Exception e3) {
            e = e3;
            ba = false;
            w.e(this.TAG, "%s check video data error %s ", new Object[]{bDS(), e.toString()});
            return ba;
        }
        return ba;
    }

    private boolean a(int i, PInt pInt, PInt pInt2) {
        pInt.value = Math.max(i, this.hYm);
        if (this.hYg == 1) {
            pInt.value = i;
            pInt2.value = pInt.value + this.hYn;
        }
        if (this.hYg == 2) {
            pInt.value = i - 8;
            if (pInt.value < 0) {
                pInt.value = 0;
            }
            pInt2.value = (pInt.value + this.hYn) + 8;
        }
        if (this.hYg == 3 || this.hYg == 4) {
            pInt.value = this.hYm;
            pInt2.value = ((this.hYn + i) + 1) + this.hYr.hYw;
        }
        if (pInt2.value >= this.hYi + 1) {
            pInt2.value = this.hYi + 1;
        }
        if (pInt2.value < pInt.value) {
            pInt2.value = pInt.value + this.hYr.hYw;
            return false;
        }
        w.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[]{bDS(), Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), Integer.valueOf(i), Integer.valueOf(this.hYg), Integer.valueOf(this.hYm), Integer.valueOf(this.hYn), this.hYc});
        return true;
    }

    private void KG() {
        w.i(this.TAG, "%s pauseByDataBlock ", new Object[]{bDS()});
        Xy();
        pause();
    }

    private boolean g(int i, int i2, boolean z) {
        boolean ba;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        try {
            if (this.hYh.a(i, i2, pInt, pInt2)) {
                ba = this.hYb.ba(pInt.value, pInt2.value);
                if (ba) {
                    String str = this.hYc + "_" + pInt.value + "_" + pInt2.value;
                    if (this.hYp || z) {
                        this.hYp = true;
                        this.hYb.g(this.hYc, pInt.value, pInt2.value);
                    } else {
                        w.i(this.TAG, "%s already request video [%s] isRequestNow[%b] isSeek[%b] ", new Object[]{bDS(), str, Boolean.valueOf(this.hYp), Boolean.valueOf(z)});
                    }
                } else {
                    w.i(this.TAG, "%s already had video data.", new Object[]{bDS()});
                }
                return ba;
            }
        } catch (Exception e) {
            w.e(this.TAG, "%s check video data error[%s] ", new Object[]{bDS(), e.toString()});
        }
        ba = false;
        if (ba) {
            w.i(this.TAG, "%s already had video data.", new Object[]{bDS()});
        } else {
            String str2 = this.hYc + "_" + pInt.value + "_" + pInt2.value;
            if (this.hYp) {
            }
            this.hYp = true;
            this.hYb.g(this.hYc, pInt.value, pInt2.value);
        }
        return ba;
    }

    public final void gK(int i) {
        w.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s", new Object[]{bDS(), Integer.valueOf(i), Integer.valueOf(this.hYi), this.hYc});
        if (this.hYi != 0) {
            w.w(this.TAG, "moov had callback, do nothing.");
            return;
        }
        bDU();
        try {
            if (this.hYh == null) {
                w.w(this.TAG, "%s parser is null, thread is error.", new Object[]{bDS()});
            } else if (this.hYh.m(this.hYd, (long) i)) {
                this.hYi = this.hYh.imd;
                w.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", new Object[]{bDS(), Integer.valueOf(this.hYi), this.hYc});
                if (gL(0)) {
                    KD();
                }
                if (this.hYj == -1) {
                    this.hYg = 1;
                } else {
                    this.hYg = 2;
                }
            } else {
                w.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", new Object[]{bDS(), this.hYc});
                this.hYb.g(this.hYc, 0, -1);
            }
        } catch (Throwable e) {
            w.printErrStackTrace(this.TAG, e, "%s deal moov ready error [%s]", new Object[]{bDS(), this.hYc});
        }
    }

    public final void onDataAvailable(String str, int i, int i2) {
        this.hYp = false;
        if (i < 0 || i2 < 0) {
            w.w(this.TAG, "%s deal data available error offset[%d], length[%d]", new Object[]{bDS(), Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (bg.eB(this.hYc, str)) {
            try {
                this.hYm = this.hYh.bi(i, i2);
            } catch (Exception e) {
                w.e(this.TAG, "%s deal data available file pos to video time error[%s] ", new Object[]{bDS(), e.toString()});
            }
            w.i(this.TAG, "%s deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[]{bDS(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.hYm)});
            bs(true);
        }
    }

    public final void f(String str, int i, int i2) {
        if (bg.eB(this.hYc, str)) {
            w.d(this.TAG, "%s download  onProgress [%d, %d]", new Object[]{bDS(), Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public final void w(String str, int i) {
        boolean z = false;
        if (bg.eB(this.hYc, str) && this.hYf != 3) {
            w.i(this.TAG, "%s download finish [%d]", new Object[]{bDS(), Integer.valueOf(i)});
            if (i == 0) {
                this.hYf = 3;
            }
            if (this.hYe != null) {
                com.tencent.mm.pluginsdk.ui.h.a aVar = this.hYe;
                String str2 = this.hYd;
                if (this.hYg > 0) {
                    z = true;
                }
                aVar.K(str2, z);
            }
            bs(true);
        }
    }

    protected final void bs(boolean z) {
        this.hYt.KH();
        this.hYt.v(500, 500);
    }

    protected final void KH() {
        this.hYt.KH();
    }

    public final int KI() {
        if (this.hYf == 3) {
            return Uu();
        }
        return this.hYm;
    }

    public final void KJ() {
    }

    protected final int KK() {
        return 100;
    }
}
