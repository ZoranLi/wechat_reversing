package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;

public class OfflineVideoView extends RelativeLayout implements com.tencent.mm.pluginsdk.ui.tools.f.a {
    private int duration;
    private ae klG;
    private boolean kmK;
    public f kmM;
    private aj kmT;
    private ImageView lKn;
    private boolean lKp;
    private boolean lKq;
    private ProgressBar lKt;
    private RelativeLayout lMj;
    private Context mContext;
    private int nUo;
    public a qvo;
    private boolean qvp;
    private boolean qvq;
    private int qvr;
    private e qvs;

    public interface a {
        boolean a(PString pString);

        void oW();

        void onStart(int i);

        void tt(int i);
    }

    public OfflineVideoView(Context context) {
        this(context, null);
    }

    public OfflineVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OfflineVideoView(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        super(context, attributeSet, i);
        this.mContext = null;
        this.kmK = false;
        this.lKp = false;
        this.qvp = false;
        this.qvq = true;
        this.qvr = -1;
        this.nUo = 0;
        this.duration = 0;
        this.klG = new ae(Looper.getMainLooper());
        this.kmT = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ OfflineVideoView qvu;

            {
                this.qvu = r1;
            }

            public final boolean oQ() {
                if (this.qvu.kmM == null) {
                    return false;
                }
                if (((View) this.qvu.kmM).getAlpha() < 1.0f) {
                    this.qvu.a(true, 1.0f);
                }
                if (this.qvu.kmM.isPlaying()) {
                    this.qvu.aFI();
                    OfflineVideoView offlineVideoView = this.qvu;
                    int currentPosition = this.qvu.kmM.getCurrentPosition() / 1000;
                    if (offlineVideoView.qvo != null) {
                        offlineVideoView.qvo.tt(currentPosition);
                    }
                }
                return true;
            }
        }, true);
        this.qvs = new e(this) {
            final /* synthetic */ OfflineVideoView qvu;

            {
                this.qvu = r1;
            }

            public final void aMm() {
                w.i("MicroMsg.OfflineVideoView", "%d on texture update.", new Object[]{Integer.valueOf(this.qvu.hashCode())});
                try {
                    this.qvu.a(true, 1.0f);
                } catch (Exception e) {
                    w.e("MicroMsg.OfflineVideoView", "texture view update. error " + e.toString());
                }
            }
        };
        this.mContext = context;
        w.i("MicroMsg.OfflineVideoView", "%d ui init view.", new Object[]{Integer.valueOf(hashCode())});
        LayoutInflater.from(this.mContext).inflate(g.pIy, this);
        this.lKn = (ImageView) findViewById(i.f.cMj);
        this.lMj = (RelativeLayout) findViewById(i.f.cMi);
        this.lKt = (ProgressBar) findViewById(i.f.cLT);
        if (d.ep(18)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            this.lKq = true;
            this.kmM = new VideoPlayerTextureView(this.mContext);
        } else {
            this.lKq = false;
            this.kmM = new VideoTextureView(this.mContext);
        }
        this.kmM.a(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.lMj.addView((View) this.kmM, layoutParams);
        a(false, 0.0f);
    }

    public final void bQ(boolean z) {
        this.kmK = z;
        this.kmM.bQ(this.kmK);
    }

    private void onResume() {
        w.d("MicroMsg.OfflineVideoView", "%d on resume %s", new Object[]{Integer.valueOf(hashCode()), bg.bJZ()});
        if (!this.lKp) {
            bji();
        }
        this.qvp = true;
    }

    public final void onDestroy() {
        w.d("MicroMsg.OfflineVideoView", "%d on destroy %s", new Object[]{Integer.valueOf(hashCode()), bg.bJZ()});
        w.i("MicroMsg.OfflineVideoView", "%d logic unInit", new Object[]{Integer.valueOf(hashCode())});
        this.klG.removeCallbacksAndMessages(null);
        this.kmT.KH();
        if (this.kmM != null) {
            this.kmM.stop();
        }
    }

    public final void bji() {
        if (this.qvo != null) {
            PString pString = new PString();
            PString pString2 = new PString();
            if (this.qvo.a(pString)) {
                if (!bg.mA(pString2.value)) {
                    GN(pString2.value);
                }
                if (!bg.mA(pString.value)) {
                    wq(pString.value);
                    return;
                }
                return;
            }
            this.klG.post(new Runnable(this) {
                final /* synthetic */ OfflineVideoView qvu;

                {
                    this.qvu = r1;
                }

                public final void run() {
                    w.i("MicroMsg.OfflineVideoView", "%d show loading. downloadMode %d", new Object[]{Integer.valueOf(this.qvu.hashCode()), Integer.valueOf(this.qvu.hashCode())});
                    if (this.qvu.lKt != null && this.qvu.lKt.getVisibility() != 0) {
                        this.qvu.lKt.setVisibility(0);
                    }
                }
            });
            a(false, 0.0f);
            return;
        }
        w.w("MicroMsg.OfflineVideoView", "%d toggle video but video callback is null", new Object[]{Integer.valueOf(hashCode())});
    }

    public final void GN(final String str) {
        if (!bg.mA(str)) {
            this.klG.post(new Runnable(this) {
                final /* synthetic */ OfflineVideoView qvu;

                public final void run() {
                    if (this.qvu.lKn != null) {
                        w.i("MicroMsg.OfflineVideoView", "%d fresh thumb image", new Object[]{Integer.valueOf(hashCode())});
                        this.qvu.lKn.setImageBitmap(b.c(str, 1.0f));
                    }
                }
            });
        }
    }

    public final void onError(int i, int i2) {
        w.e("MicroMsg.OfflineVideoView", "%d on play video error what %d extra %d isMMVideoPlayer %b errorCount %d", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.lKq), Integer.valueOf(this.nUo)});
        this.nUo++;
        final String Ls = this.kmM.Ls();
        this.kmM.stop();
        this.lKp = true;
        a(false, 0.0f);
        if (this.nUo <= 3) {
            this.klG.postDelayed(new Runnable(this) {
                final /* synthetic */ OfflineVideoView qvu;

                public final void run() {
                    this.qvu.wq(Ls);
                }
            }, 200);
        } else if (!bg.mA(Ls)) {
            w.w("MicroMsg.OfflineVideoView", "%d start third player to play", new Object[]{Integer.valueOf(hashCode())});
            this.klG.post(new Runnable(this) {
                final /* synthetic */ OfflineVideoView qvu;

                public final void run() {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.fromFile(new File(Ls)), "video/*");
                    try {
                        this.qvu.getContext().startActivity(intent);
                    } catch (Exception e) {
                        w.e("MicroMsg.OfflineVideoView", "startActivity fail, activity not found");
                        com.tencent.mm.ui.base.g.h(this.qvu.getContext(), j.eiL, j.eiM);
                    }
                }
            });
        }
    }

    private void a(final boolean z, final float f) {
        this.klG.post(new Runnable(this) {
            final /* synthetic */ OfflineVideoView qvu;

            public final void run() {
                w.i("MicroMsg.OfflineVideoView", "%d switch video model isVideoPlay %b %f", new Object[]{Integer.valueOf(this.qvu.hashCode()), Boolean.valueOf(z), Float.valueOf(f)});
                View view = (View) this.qvu.kmM;
                if (z) {
                    view.setAlpha(f);
                    view.setVisibility(0);
                    this.qvu.lMj.setVisibility(0);
                    this.qvu.lMj.setAlpha(f);
                    if (((double) f) >= 1.0d) {
                        this.qvu.lKn.setVisibility(8);
                        return;
                    }
                    return;
                }
                view.setVisibility(0);
                this.qvu.lMj.setVisibility(0);
                this.qvu.lMj.setAlpha(0.0f);
                this.qvu.lKn.setVisibility(0);
            }
        });
    }

    public final void Uc() {
        a(true, 0.0f);
        this.lKp = false;
        aFI();
        this.duration = this.kmM.getDuration() / 1000;
        w.i("MicroMsg.OfflineVideoView", "%d on prepared. shouldPlayWhenPrepared [%b] shouldSeekTimeWhenPrepared[%d]", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.qvq), Integer.valueOf(this.qvr)});
        if (this.qvq) {
            if (this.qvr <= 0) {
                this.kmM.start();
            } else {
                K(this.qvr, true);
            }
            WZ();
            if (this.qvo != null) {
                this.qvo.onStart(this.duration);
            }
        } else {
            K(this.qvr > 0 ? this.qvr : 0, false);
        }
        this.qvr = -1;
    }

    private void aFI() {
        this.klG.post(new Runnable(this) {
            final /* synthetic */ OfflineVideoView qvu;

            {
                this.qvu = r1;
            }

            public final void run() {
                if (this.qvu.lKt != null && this.qvu.lKt.getVisibility() != 8) {
                    w.i("MicroMsg.OfflineVideoView", "%d hide loading.", new Object[]{Integer.valueOf(this.qvu.hashCode())});
                    this.qvu.lKt.setVisibility(8);
                }
            }
        });
    }

    public final void WZ() {
        this.kmT.v(500, 500);
    }

    public final void oW() {
        w.i("MicroMsg.OfflineVideoView", "%d on completion", new Object[]{Integer.valueOf(hashCode())});
        if (this.qvo != null) {
            this.qvo.oW();
        } else if (d.eq(18) || !this.lKq) {
            K(0, true);
        } else if (this.kmM != null) {
            String Ls = this.kmM.Ls();
            this.kmM.stop();
            wq(Ls);
        }
    }

    public final void wq(String str) {
        w.i("MicroMsg.OfflineVideoView", "%d prepare video  filePath %s", new Object[]{Integer.valueOf(hashCode()), str});
        if (bg.mA(str)) {
            w.w("MicroMsg.OfflineVideoView", "%d prepare video but filepath is null.", new Object[]{Integer.valueOf(hashCode())});
        } else if (this.kmM != null) {
            this.kmM.a(this.qvs);
            this.kmM.setVideoPath(str);
        }
    }

    public final void K(int i, boolean z) {
        w.i("MicroMsg.OfflineVideoView", "%d seek second %d afterSeekPlay %b", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Boolean.valueOf(z)});
        aFI();
        this.kmM.c((double) (i * 1000), z);
        WZ();
    }

    public final void bjj() {
        w.i("MicroMsg.OfflineVideoView", "%d pause", new Object[]{Integer.valueOf(hashCode())});
        w.d("MicroMsg.OfflineVideoView", "%d on pause %s ", new Object[]{Integer.valueOf(hashCode()), bg.bJZ()});
        this.qvq = false;
        if (this.kmM.isPlaying()) {
            this.qvr = this.kmM.getCurrentPosition() / 1000;
        }
        w.i("MicroMsg.OfflineVideoView", "%d pause play", new Object[]{Integer.valueOf(hashCode())});
        this.kmM.pause();
        aFI();
        this.kmT.KH();
    }

    public final void bjk() {
        w.i("MicroMsg.OfflineVideoView", "%d start hasResumed[%b]", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.qvp)});
        this.qvq = true;
        if (!this.qvp) {
            onResume();
        } else if (bg.mA(this.kmM.Ls())) {
            onResume();
        } else if (this.kmM.start() && this.qvo != null) {
            this.qvo.onStart(this.duration);
        }
        WZ();
    }

    public final void R(int i, boolean z) {
        w.i("MicroMsg.OfflineVideoView", "%d ui touch seek second %d afterSeekPlay %b", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Boolean.valueOf(z)});
        K(i, z);
        WZ();
    }

    public final boolean isPlaying() {
        return this.kmM != null ? this.kmM.isPlaying() : false;
    }

    public final int bI(int i, int i2) {
        return 0;
    }

    public final void bp(int i, int i2) {
    }

    public final int getCurrentPosition() {
        if (this.kmM != null) {
            return this.kmM.getCurrentPosition() / 1000;
        }
        return 0;
    }
}
