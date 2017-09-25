package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.pluginsdk.ui.tools.f.b;
import com.tencent.mm.pluginsdk.ui.tools.f.c;
import com.tencent.mm.pluginsdk.ui.tools.f.d;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public abstract class AbstractVideoView extends RelativeLayout implements h, a, b, c, d, e {
    private boolean Ht;
    public String TAG;
    protected ae hgN;
    protected h.b iWV;
    public f kmM;
    protected ImageView lHs;
    protected ProgressBar lKt;
    protected Context mContext;
    private int nUo;
    protected TextView qvB;
    protected boolean sHD;
    protected RelativeLayout sHE;
    protected TextView sHF;
    protected LinearLayout sHG;
    protected VideoPlayerSeekBar sHH;
    protected g sHI;
    protected boolean sHJ;
    public int sHK;
    public boolean sHL;
    public int sHM;
    public boolean sHN;
    public int sHO;
    protected aj sHP;
    protected aj sHQ;
    private com.tencent.mm.plugin.sight.decode.ui.b sHR;
    private OnClickListener sHS;
    public h.c sHT;
    protected l sHU;

    public abstract int KK();

    static /* synthetic */ void b(AbstractVideoView abstractVideoView) {
        w.i(abstractVideoView.TAG, "%s reset error count ", new Object[]{abstractVideoView.bDS()});
        abstractVideoView.nUo = 0;
        abstractVideoView.ei((long) (abstractVideoView.KK() + 91));
    }

    public AbstractVideoView(Context context) {
        this(context, null);
    }

    public AbstractVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbstractVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "MicroMsg.AbstractVideoView";
        this.sHD = true;
        this.sHJ = true;
        this.sHK = 0;
        this.sHL = false;
        this.hgN = new ae(Looper.getMainLooper());
        this.sHM = 0;
        this.sHN = true;
        this.sHO = -1;
        this.nUo = 0;
        this.Ht = false;
        this.sHP = new aj(new aj.a(this) {
            final /* synthetic */ AbstractVideoView sHV;

            {
                this.sHV = r1;
            }

            public final boolean oQ() {
                if (!this.sHV.isPlaying()) {
                    return false;
                }
                if (this.sHV.sHL) {
                    if (this.sHV.iWV != null) {
                        this.sHV.iWV.Uf();
                    }
                    this.sHV.sHL = false;
                }
                this.sHV.nN(this.sHV.Uw());
                this.sHV.jk(this.sHV.isPlaying());
                return true;
            }
        }, true);
        this.sHQ = new aj(new aj.a(this) {
            final /* synthetic */ AbstractVideoView sHV;

            {
                this.sHV = r1;
            }

            public final boolean oQ() {
                if (this.sHV.nUo <= 0) {
                    return false;
                }
                if (!this.sHV.isPlaying()) {
                    return true;
                }
                AbstractVideoView.b(this.sHV);
                return false;
            }
        }, true);
        this.sHR = new com.tencent.mm.plugin.sight.decode.ui.b(this) {
            final /* synthetic */ AbstractVideoView sHV;

            {
                this.sHV = r1;
            }

            public final void Uh() {
            }

            public final void hR(int i) {
                if (this.sHV.w(i, true)) {
                    this.sHV.bs(false);
                }
                this.sHV.sHH.bX(true);
            }
        };
        this.sHS = new OnClickListener(this) {
            final /* synthetic */ AbstractVideoView sHV;

            {
                this.sHV = r1;
            }

            public final void onClick(View view) {
                w.i(this.sHV.TAG, "%s seek bar play button on click ", new Object[]{this.sHV.bDS()});
                this.sHV.bDT();
            }
        };
        this.sHT = null;
        this.sHU = new l();
        this.mContext = context;
        KC();
    }

    public f bm(Context context) {
        return null;
    }

    public void KC() {
        w.i(this.TAG, "%s init view ", new Object[]{bDS()});
        LayoutInflater.from(this.mContext).inflate(com.tencent.mm.plugin.y.a.b.ooN, this);
        this.lHs = (ImageView) findViewById(com.tencent.mm.plugin.y.a.a.cMj);
        this.sHE = (RelativeLayout) findViewById(com.tencent.mm.plugin.y.a.a.cMi);
        this.qvB = (TextView) findViewById(com.tencent.mm.plugin.y.a.a.cLN);
        this.lKt = (ProgressBar) findViewById(com.tencent.mm.plugin.y.a.a.cLT);
        this.sHF = (TextView) findViewById(com.tencent.mm.plugin.y.a.a.cMl);
        this.sHG = (LinearLayout) findViewById(com.tencent.mm.plugin.y.a.a.cLQ);
        VideoPlayerSeekBar videoPlayerSeekBar = (VideoPlayerSeekBar) findViewById(com.tencent.mm.plugin.y.a.a.cLX);
        this.sHH = videoPlayerSeekBar;
        this.sHI = videoPlayerSeekBar;
        this.sHH.puM = this.sHR;
        this.sHH.setOnClickListener(this.sHS);
        this.kmM = bm(this.mContext);
        this.kmM.a(this);
        this.kmM.a(this);
        this.kmM.a(this);
        this.kmM.a(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.sHE.addView((View) this.kmM, layoutParams);
    }

    public final void a(g gVar) {
        if (gVar instanceof View) {
            Ut();
            this.sHI = gVar;
            this.sHJ = false;
            this.sHG.addView((View) this.sHI);
            return;
        }
        w.w(this.TAG, "%s set video footer view but is not view", new Object[]{bDS()});
    }

    public final void Ut() {
        this.sHG.removeView((View) this.sHI);
    }

    private void jk(boolean z) {
        this.sHI.jk(z);
    }

    public void bs(boolean z) {
        this.sHP.v(500, 500);
    }

    public int KI() {
        return 0;
    }

    public void KH() {
        this.sHP.KH();
    }

    public final void nN(int i) {
        this.sHI.tt(i);
    }

    public final void Xy() {
        this.hgN.post(new Runnable(this) {
            final /* synthetic */ AbstractVideoView sHV;

            {
                this.sHV = r1;
            }

            public final void run() {
                if (this.sHV.lKt != null && this.sHV.lKt.getVisibility() != 0) {
                    w.i(this.sHV.TAG, "%s show loading", new Object[]{this.sHV.bDS()});
                    this.sHV.lKt.setVisibility(0);
                }
            }
        });
    }

    public final void aFI() {
        w.d(this.TAG, "%s hide loading %s", new Object[]{bDS(), bg.bJZ()});
        this.hgN.post(new Runnable(this) {
            final /* synthetic */ AbstractVideoView sHV;

            {
                this.sHV = r1;
            }

            public final void run() {
                if (this.sHV.lKt != null && this.sHV.lKt.getVisibility() != 8) {
                    w.i(this.sHV.TAG, "%s hide loading", new Object[]{this.sHV.bDS()});
                    this.sHV.lKt.setVisibility(8);
                }
            }
        });
    }

    public final String bDS() {
        return hashCode();
    }

    public final boolean bDT() {
        if (this.kmM == null) {
            return false;
        }
        if (isPlaying()) {
            pause();
        } else if (bg.mA(this.kmM.Ls())) {
            start();
        } else {
            play();
        }
        return true;
    }

    public final boolean play() {
        if (this.sHD) {
            ei((long) (KK() + 3));
            if (this.kmM == null) {
                return false;
            }
            boolean start = this.kmM.start();
            w.i(this.TAG, "%s video play [%b] isPlayOnUiPause[%b]", new Object[]{bDS(), Boolean.valueOf(start), Boolean.valueOf(this.sHL)});
            jk(start);
            if (start) {
                this.sHL = false;
                bs(false);
                if (this.iWV != null) {
                    this.iWV.Uf();
                }
            }
            return start;
        }
        w.w(this.TAG, "%s ui on pause now, why u call me to play? [%s]", new Object[]{bDS(), bg.bJZ()});
        return false;
    }

    public final boolean pause() {
        w.i(this.TAG, "%s pause", new Object[]{bDS()});
        ei((long) (KK() + 4));
        if (this.kmM == null) {
            return false;
        }
        jk(false);
        this.kmM.pause();
        KH();
        if (this.iWV != null) {
            this.iWV.Ue();
        }
        this.sHU.qwb = bg.Nz();
        return true;
    }

    public final boolean hS(int i) {
        return w(i, isPlaying());
    }

    public boolean w(int i, boolean z) {
        int i2;
        boolean isPrepared = isPrepared();
        int Uu = Uu();
        if (Uu <= 0 || i <= Uu) {
            i2 = i;
        } else {
            i2 = Uu;
        }
        boolean z2 = this.kmM != null ? !bg.mA(this.kmM.Ls()) : false;
        w.i(this.TAG, "%s seek to [%d %d] seconds afterPlay[%b] isPrepared[%b] duration[%d] hadSetPath[%b]", new Object[]{bDS(), Integer.valueOf(i2), Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(isPrepared), Integer.valueOf(Uu), Boolean.valueOf(z2)});
        ei((long) (KK() + 5));
        if (!isPrepared) {
            this.sHO = i2;
            if (z2) {
                this.sHN = true;
            } else {
                this.sHN = z;
                start();
            }
        } else if (this.kmM != null) {
            Xy();
            nN(i2);
            this.kmM.c((double) (i2 * 1000), z);
            return z;
        }
        return false;
    }

    public int Uu() {
        if (this.kmM != null) {
            return Math.round((float) (this.kmM.getDuration() / 1000));
        }
        return -1;
    }

    public final int Uv() {
        if (this.kmM != null) {
            return this.kmM.getCurrentPosition();
        }
        return 0;
    }

    public final int Uw() {
        if (this.kmM != null) {
            return Math.round((float) (this.kmM.getCurrentPosition() / 1000));
        }
        return 0;
    }

    public final boolean isPlaying() {
        if (this.kmM != null) {
            return this.kmM.isPlaying();
        }
        return false;
    }

    public final boolean isPrepared() {
        boolean z = this.kmM != null ? !bg.mA(this.kmM.Ls()) && this.Ht : false;
        w.d(this.TAG, "%s is prepared [%b] isPrepared[%b]", new Object[]{bDS(), Boolean.valueOf(z), Boolean.valueOf(this.Ht)});
        return z;
    }

    public final void a(h.b bVar) {
        this.iWV = bVar;
    }

    public void stop() {
        w.i(this.TAG, "%s stop", new Object[]{bDS()});
        ei((long) (KK() + 6));
        if (this.kmM != null) {
            this.kmM.stop();
        }
        this.sHO = -1;
        this.sHN = true;
        this.Ht = false;
        KH();
        this.hgN.postDelayed(new Runnable(this) {
            final /* synthetic */ AbstractVideoView sHV;

            {
                this.sHV = r1;
            }

            public final void run() {
                try {
                    this.sHV.nN(0);
                    this.sHV.jk(this.sHV.isPlaying());
                } catch (Throwable th) {
                }
            }
        }, 10);
        this.sHU.sJW = bg.Nz();
        if (this.sHU.blockCount > 0) {
            int i;
            int i2;
            if (am.isWifi(this.mContext)) {
                i = 41;
                i2 = 45;
            } else if (am.is4G(this.mContext)) {
                i = 46;
                i2 = 50;
            } else if (am.is3G(this.mContext)) {
                i = 51;
                i2 = 55;
            } else if (am.is2G(this.mContext)) {
                i = 56;
                i2 = 60;
            }
            w.d(this.TAG, "%s rptBlockCount [%d]", new Object[]{bDS(), Integer.valueOf(bg.f((Integer) com.tencent.mm.plugin.report.c.a(this.sHU.blockCount, new int[]{1, 2, 3, 4}, i + KK(), i2 + KK())))});
            ei((long) i2);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.sHU.sJU).append(",");
        stringBuffer.append(this.sHU.sJV).append(",");
        stringBuffer.append(this.sHU.sJW).append(",");
        stringBuffer.append(this.sHU.qwb).append(",");
        stringBuffer.append(this.sHU.sJX).append(",");
        stringBuffer.append(this.sHU.sJY).append(",");
        stringBuffer.append(this.sHU.sJZ).append(",");
        stringBuffer.append(this.sHU.blockCount).append(",");
        stringBuffer.append(this.sHU.sJV - this.sHU.sJU).append(",");
        stringBuffer.append(this.sHU.url).append(",");
        stringBuffer.append(this.sHU.duration).append(",");
        stringBuffer.append(this.sHU.sKa).append(",");
        stringBuffer.append(this.sHU.sKb).append(",");
        stringBuffer.append(this.sHU.qvZ).append(",");
        stringBuffer.append(this.sHU.qvZ > this.sHU.sJU ? this.sHU.qvZ - this.sHU.sJU : 0).append(",");
        stringBuffer.append(this.sHM);
        w.i(this.TAG, "%s rpt video kv stat{%s}", new Object[]{bDS(), stringBuffer.toString()});
        if (this.sHT != null) {
            this.sHT.A(14349, r0);
        }
    }

    public final void bQ(boolean z) {
        if (this.kmM != null) {
            this.kmM.bQ(z);
        }
    }

    public void KF() {
        w.i(this.TAG, "%s onUIResume", new Object[]{bDS()});
        this.sHD = true;
        ei((long) (KK() + 10));
    }

    public void KE() {
        w.i(this.TAG, "%s onUIPause", new Object[]{bDS()});
        this.sHK = Uw();
        this.sHL = isPlaying();
        pause();
        KH();
        this.sHD = false;
        ei((long) (KK() + 11));
    }

    public final void Uy() {
        w.i(this.TAG, "%s onUIDestroy", new Object[]{bDS()});
        stop();
        this.hgN.removeCallbacksAndMessages(null);
        KH();
        this.sHQ.KH();
        ei((long) (KK() + 12));
    }

    public final void onError(int i, int i2) {
        w.w(this.TAG, "%s onError info [%d %d] errorCount[%d]", new Object[]{bDS(), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.nUo)});
        ei((long) (KK() + 90));
        this.nUo++;
        if (this.nUo > 5) {
            ei((long) (KK() + 92));
            this.sHU.sKa = i;
            this.sHU.sKb = i2;
            if (this.iWV != null) {
                this.iWV.onError(i, i2);
            }
            aFI();
            return;
        }
        final int Uw = Uw();
        w.i(this.TAG, "%s onError now, try to start again. currPlaySec[%d]", new Object[]{bDS(), Integer.valueOf(Uw)});
        stop();
        Xy();
        this.hgN.postDelayed(new Runnable(this) {
            final /* synthetic */ AbstractVideoView sHV;

            public final void run() {
                this.sHV.w(Uw, true);
            }
        }, 200);
    }

    public final void Uc() {
        w.i(this.TAG, "%s onPrepared startWhenPrepared[%b] seekTimeWhenPrepared[%d] isPrepared[%b]", new Object[]{bDS(), Boolean.valueOf(this.sHN), Integer.valueOf(this.sHO), Boolean.valueOf(this.Ht)});
        this.Ht = true;
        if (this.kmM != null) {
            this.kmM.a(this);
        }
        int Uu = Uu();
        if (!(this.sHI == null || this.sHI.bcm() == Uu)) {
            this.sHI.sH(Uu);
        }
        if (!this.sHN) {
            w(this.sHO < 0 ? 0 : this.sHO, this.sHN);
        } else if (this.sHO < 0) {
            play();
        } else {
            w(this.sHO, this.sHN);
        }
        this.sHO = -1;
        this.sHN = true;
        if (this.iWV != null) {
            this.iWV.Uc();
        }
        if (this.nUo > 0) {
            w.d(this.TAG, "%s start error check timer", new Object[]{bDS()});
            this.sHQ.v(5000, 5000);
        }
        ei((long) (KK() + 2));
        if (this.sHU.sJV == 0) {
            this.sHU.sJV = bg.Nz();
        }
        this.sHU.duration = Uu();
        if (this.sHU.sJU > 0 && this.sHU.sJV > 0) {
            int i;
            int i2 = (int) ((this.sHU.sJV - this.sHU.sJU) / 1000);
            if (am.isWifi(this.mContext)) {
                i = 20;
                Uu = 24;
            } else if (am.is4G(this.mContext)) {
                i = 25;
                Uu = 29;
            } else if (am.is3G(this.mContext)) {
                i = 30;
                Uu = 34;
            } else if (am.is2G(this.mContext)) {
                i = 35;
                Uu = 39;
            } else {
                return;
            }
            w.d(this.TAG, "%s rptFirstPlayTime [%d]", new Object[]{bDS(), Integer.valueOf(bg.f((Integer) com.tencent.mm.plugin.report.c.a(i2, new int[]{1, 2, 3, 4}, i + KK(), Uu + KK())))});
            ei((long) Uu);
        }
    }

    public final void aMm() {
        w.i(this.TAG, "%s onTextureUpdate ", new Object[]{bDS()});
        aFI();
    }

    public void oW() {
        w.i(this.TAG, "%s onCompletion", new Object[]{bDS()});
        aFI();
        KH();
        if (this.iWV != null) {
            this.iWV.Ud();
        }
        ei((long) (KK() + 7));
    }

    public final int bI(int i, int i2) {
        return 0;
    }

    public final void bp(int i, int i2) {
        w.i(this.TAG, "%s on get video size [%d, %d]", new Object[]{bDS(), Integer.valueOf(i), Integer.valueOf(i2)});
        if (this.iWV != null) {
            this.iWV.bp(i, i2);
        }
        ei((long) (KK() + 8));
    }

    public void br(boolean z) {
        w.i(this.TAG, "%s on seek complete startPlay[%b]", new Object[]{bDS(), Boolean.valueOf(z)});
        if (this.kmM != null) {
            this.kmM.a(this);
        }
        aFI();
        jk(z);
        nN(Uw());
        if (z) {
            bs(false);
            this.sHL = false;
            if (this.iWV != null) {
                this.iWV.Uf();
            }
        }
    }

    public void KJ() {
        w.i(this.TAG, "%s on surface available", new Object[]{bDS()});
        bs(false);
    }

    public final void ei(long j) {
        if (this.sHT != null) {
            this.sHT.a(600, j, 1, false);
        }
    }

    public final void bjy() {
        if (this.sHU.sJU == 0) {
            this.sHU.sJU = bg.Nz();
        }
    }

    public final void bDU() {
        if (this.sHU.qvZ == 0) {
            this.sHU.qvZ = bg.Nz();
        }
    }

    public final void bDV() {
        this.sHU.sJX = bg.Nz();
    }

    public final void bDW() {
        this.sHU.sJY = bg.Nz();
        if (this.sHU.sJX > 0) {
            l lVar = this.sHU;
            lVar.sJZ += this.sHU.sJY - this.sHU.sJX;
        }
    }

    public final void bDX() {
        l lVar = this.sHU;
        lVar.blockCount++;
    }

    protected final void MC(String str) {
        this.sHU.url = str;
    }

    public final void bDY() {
        if (this.sHU.sJY > 0 && this.sHU.sJX > 0) {
            int i;
            int i2;
            int i3 = (int) ((this.sHU.sJY - this.sHU.sJX) / 1000);
            if (am.isWifi(this.mContext)) {
                i = 70;
                i2 = 74;
            } else if (am.is4G(this.mContext)) {
                i = 75;
                i2 = 79;
            } else if (am.is3G(this.mContext)) {
                i = 80;
                i2 = 84;
            } else if (am.is2G(this.mContext)) {
                i = 85;
                i2 = 89;
            } else {
                return;
            }
            w.d(this.TAG, "%s rptResumeTime [%d]", new Object[]{bDS(), Integer.valueOf(bg.f((Integer) com.tencent.mm.plugin.report.c.a(i3, new int[]{1, 2, 3, 4}, i + KK(), i2 + KK())))});
            ei((long) i2);
        }
    }
}
