package com.tencent.mm.plugin.favorite.ui.base;

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
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.e.a.jz;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.f.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.io.File;

public class FavVideoView extends RelativeLayout implements a {
    public String hIN;
    public ae klG;
    public f kmM;
    private ImageView lKn;
    private TextView lKo;
    private boolean lKp;
    private boolean lKq;
    private int lKr;
    private boolean lKs;
    private ProgressBar lKt;
    private MMPinProgressBtn lKu;
    public String lKv;
    private int lKw;
    public c lKx;

    public FavVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FavVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.klG = new ae(Looper.getMainLooper());
        this.lKp = false;
        this.lKq = false;
        this.lKr = 0;
        this.lKs = false;
        this.lKv = "";
        this.lKw = 0;
        this.lKx = new c<jz>(this) {
            final /* synthetic */ FavVideoView lKy;

            {
                this.lKy = r2;
                this.usg = jz.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                jz jzVar = (jz) bVar;
                if (jzVar == null || jzVar.fQn == null) {
                    w.e("MicroMsg.FavVideoView", "downloadVideoListener .event  is null.");
                    return false;
                } else if (!jzVar.fQn.field_dataId.equals(this.lKy.lKv)) {
                    return false;
                } else {
                    w.i("MicroMsg.FavVideoView", "downloadVideoListener callback enter");
                    if ((jzVar.fQn.field_status == 3 || jzVar.fQn.field_status == 2) && e.aO(jzVar.fQn.field_path)) {
                        this.lKy.kmM.stop();
                        this.lKy.klG.post(new Runnable(this.lKy) {
                            final /* synthetic */ FavVideoView lKy;

                            {
                                this.lKy = r1;
                            }

                            public final void run() {
                                if (!(this.lKy.lKt == null || this.lKy.lKt.getVisibility() == 8)) {
                                    this.lKy.lKt.setVisibility(8);
                                }
                                if (this.lKy.lKu != null && this.lKy.lKu.getVisibility() != 8) {
                                    this.lKy.lKu.setVisibility(8);
                                }
                            }
                        });
                        this.lKy.hIN = jzVar.fQn.field_path;
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass7 lKA;

                            {
                                this.lKA = r1;
                            }

                            public final void run() {
                                if (this.lKA.lKy.kmM != null) {
                                    this.lKA.lKy.wq(this.lKA.lKy.hIN);
                                }
                            }
                        });
                        return true;
                    }
                    this.lKy.klG.post(new Runnable(this.lKy, jzVar.fQn.field_offset, jzVar.fQn.field_totalLen) {
                        final /* synthetic */ FavVideoView lKy;

                        public final void run() {
                            if (!(this.lKy.lKt == null || this.lKy.lKt.getVisibility() == 8)) {
                                this.lKy.lKt.setVisibility(8);
                            }
                            if (this.lKy.lKu != null) {
                                if (this.lKy.lKu.getVisibility() != 0) {
                                    this.lKy.lKu.setVisibility(0);
                                }
                                w.i("MicroMsg.FavVideoView", "download video update progress offset:%d  total: %d", new Object[]{Integer.valueOf(r3), Integer.valueOf(r4)});
                                if (this.lKy.lKu.wvs != r4 && r4 > 0) {
                                    this.lKy.lKu.setMax(r4);
                                }
                                this.lKy.lKu.setProgress(r3);
                            }
                        }
                    });
                    return true;
                }
            }
        };
        w.i("MicroMsg.FavVideoView", "%d ui init view.", new Object[]{Integer.valueOf(hashCode())});
        LayoutInflater.from(context).inflate(R.i.dcJ, this);
        this.lKn = (ImageView) findViewById(R.h.cMj);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.h.cMi);
        ((TextView) findViewById(R.h.cLN)).setVisibility(8);
        this.lKu = (MMPinProgressBtn) findViewById(R.h.cLY);
        this.lKt = (ProgressBar) findViewById(R.h.cLT);
        this.lKo = (TextView) findViewById(R.h.cMl);
        if (d.EB()) {
            this.lKq = true;
            this.kmM = new VideoPlayerTextureView(context);
        } else {
            this.lKq = false;
            this.kmM = new VideoTextureView(context);
        }
        this.kmM.a(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        relativeLayout.addView((View) this.kmM, layoutParams);
        com.tencent.mm.sdk.b.a.urY.b(this.lKx);
    }

    public final void onResume() {
        w.i("MicroMsg.FavVideoView", "VideoPlay:   onResume()");
        if (!this.lKp) {
            if (bg.mA(this.hIN) || !e.aO(this.hIN)) {
                w.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is  null, show error, toggleVideo()");
                eg(false);
                return;
            }
            w.i("MicroMsg.FavVideoView", "VideoPlay: fullPath is not null,exist,  toggleVideo()");
            wq(this.hIN);
        }
    }

    private void eg(final boolean z) {
        this.klG.post(new Runnable(this) {
            final /* synthetic */ FavVideoView lKy;

            public final void run() {
                w.i("MicroMsg.FavVideoView", "VideoPlay: switch video model isVideoPlay %b ", new Object[]{Boolean.valueOf(z)});
                View view = (View) this.lKy.kmM;
                if (z) {
                    view.setVisibility(0);
                    this.lKy.lKn.setVisibility(8);
                    return;
                }
                view.setVisibility(8);
                this.lKy.lKn.setVisibility(0);
            }
        });
    }

    public final void wq(String str) {
        w.i("MicroMsg.FavVideoView", "VideoPlay: prepareVideo");
        if (bg.mA(str)) {
            w.e("MicroMsg.FavVideoView", "VideoPlay: %d prepare video but filepath is null.", new Object[]{Integer.valueOf(hashCode())});
            return;
        }
        if (this.kmM != null) {
            if (this.kmM instanceof VideoPlayerTextureView) {
                VideoPlayerTextureView videoPlayerTextureView = (VideoPlayerTextureView) this.kmM;
                ap.yY();
                videoPlayerTextureView.fB(com.tencent.mm.u.c.vr().c(com.tencent.mm.storage.w.a.uGb, false));
            }
            this.kmM.setVideoPath(str);
        }
        ap.yY();
        if (((Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uEZ, Integer.valueOf(0))).intValue() == 1) {
            this.lKo.setText(com.tencent.mm.plugin.sight.base.d.AN(str));
            this.lKo.setVisibility(0);
        }
    }

    public final int bI(int i, int i2) {
        return 0;
    }

    public final void bp(int i, int i2) {
    }

    public final void Uc() {
        this.lKr = 0;
        eg(true);
        this.lKs = this.kmM.start();
        w.i("MicroMsg.FavVideoView", "VideoPlay: startPlay(),duration is %d", new Object[]{Integer.valueOf(this.kmM.getDuration() / 1000)});
    }

    public final void oW() {
        w.i("MicroMsg.FavVideoView", "%d on completion", new Object[]{Integer.valueOf(hashCode())});
        if (com.tencent.mm.compatible.util.d.eq(18) || !this.lKq) {
            w.i("MicroMsg.FavVideoView", "VideoPlay: seek second is %d", new Object[]{Integer.valueOf(0)});
            this.kmM.k(0.0d);
        } else if (this.kmM != null) {
            this.kmM.stop();
        }
    }

    public final void onError(int i, int i2) {
        w.e("MicroMsg.FavVideoView", "VideoPlay: %d on play video error what %d extra %d. isMMVideoPlayer[%b]", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(this.lKq)});
        if (this.lKs) {
            oW();
            return;
        }
        this.lKr = i2;
        final String Ls = this.kmM.Ls();
        this.kmM.stop();
        this.lKp = true;
        eg(false);
        if (this.lKr == -1) {
            this.lKw++;
            if (this.lKw <= 3) {
                af.v(new Runnable(this) {
                    final /* synthetic */ FavVideoView lKy;

                    {
                        this.lKy = r1;
                    }

                    public final void run() {
                        if (this.lKy.kmM != null) {
                            this.lKy.wq(this.lKy.hIN);
                        }
                    }
                });
                return;
            }
        }
        if (!bg.mA(Ls) && FileOp.aO(Ls)) {
            w.e("MicroMsg.FavVideoView", "VideoPlay: start third player to play");
            this.klG.post(new Runnable(this) {
                final /* synthetic */ FavVideoView lKy;

                public final void run() {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.fromFile(new File(Ls)), "video/*");
                    try {
                        this.lKy.getContext().startActivity(intent);
                    } catch (Exception e) {
                        w.e("MicroMsg.FavVideoView", "startActivity fail, activity not found");
                        g.h(this.lKy.getContext(), R.l.eiL, R.l.eiM);
                    }
                }
            });
        }
    }
}
