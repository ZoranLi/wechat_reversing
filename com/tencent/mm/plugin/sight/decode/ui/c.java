package com.tencent.mm.plugin.sight.decode.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ah.n;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.e.a.qv;
import com.tencent.mm.plugin.af.a.b;
import com.tencent.mm.plugin.af.a.e;
import com.tencent.mm.plugin.af.a.h;
import com.tencent.mm.pluginsdk.ui.tools.VideoSurfaceView;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.d;
import com.tencent.mm.u.d.a;
import com.tencent.mm.ui.base.i;
import java.io.File;

public final class c extends i implements a {
    public int fXT = 0;
    public String hIN;
    private d iXd = new d();
    public String imagePath;
    private f kmM = null;
    public int lHi = 0;
    public int puA = 0;
    private TextView pvu = null;
    private boolean pvv = false;

    static /* synthetic */ void a(c cVar) {
        if (cVar.kmM.start()) {
            cVar.iXd.a(cVar);
        } else {
            cVar.bcs();
        }
    }

    public c(Context context) {
        super(context, com.tencent.mm.plugin.af.a.i.ras);
    }

    protected final void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        w.d("MicroMsg.VideoPopupHelper", currentTimeMillis + " initView beg");
        super.onCreate(bundle);
        getWindow().setFlags(16777216, 16777216);
        setContentView(com.tencent.mm.plugin.af.a.f.ral);
        if (com.tencent.mm.booter.a.pQ() != null) {
            com.tencent.mm.booter.a.pQ().pS();
        }
        w.d("MicroMsg.VideoPopupHelper", g.sc() + " initView: fullpath:" + this.hIN + ", imagepath:" + this.imagePath);
        this.pvu = (TextView) findViewById(e.cIS);
        findViewById(e.cFd).setVisibility(8);
        ViewGroup viewGroup = (ViewGroup) findViewById(e.cLG);
        viewGroup.setBackgroundResource(b.black);
        w.i("MicroMsg.VideoPopupHelper", "getVideoView, is normal video");
        if (com.tencent.mm.compatible.util.d.eo(14)) {
            this.kmM = new VideoTextureView(getContext());
        } else {
            this.kmM = new VideoSurfaceView(getContext());
        }
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        viewGroup.addView((View) this.kmM, layoutParams);
        this.kmM.a(new f.a(this) {
            final /* synthetic */ c pvw;

            {
                this.pvw = r1;
            }

            public final void Uc() {
                w.d("MicroMsg.VideoPopupHelper", g.sc() + " onPrepared");
                c.a(this.pvw);
            }

            public final void onError(int i, int i2) {
                w.e("MicroMsg.VideoPopupHelper", "on play video error, what %d extra %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                this.pvw.kmM.stop();
                com.tencent.mm.sdk.a.b.r(Base64.encodeToString((com.tencent.mm.plugin.sight.base.d.bbQ() + "[SightPopupHelper] on play video error, what " + i + " extra " + i2 + ", path=" + bg.ap(this.pvw.imagePath, "")).getBytes(), 2), "FullScreenPlaySight");
                final String c = this.pvw.imagePath;
                final Bitmap a = n.GS().a(c, com.tencent.mm.bg.a.getDensity(this.pvw.getContext()), this.pvw.getContext(), -1);
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 pvx;

                    public final void run() {
                        ImageView imageView = (ImageView) this.pvx.pvw.findViewById(e.cMr);
                        imageView.setImageBitmap(a);
                        imageView.setVisibility(0);
                        Intent intent = new Intent();
                        intent.setAction("android.intent.action.VIEW");
                        intent.setDataAndType(Uri.fromFile(new File(c)), "video/*");
                        try {
                            this.pvx.pvw.getContext().startActivity(Intent.createChooser(intent, this.pvx.pvw.getContext().getString(h.ran)));
                        } catch (Exception e) {
                            w.e("MicroMsg.VideoPopupHelper", "startActivity fail, activity not found");
                            com.tencent.mm.ui.base.g.h(this.pvx.pvw.getContext(), h.rap, h.raq);
                        }
                    }
                });
            }

            public final void oW() {
                w.d("MicroMsg.VideoPopupHelper", "on completion");
                this.pvw.pvu.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 pvx;

                    {
                        this.pvx = r1;
                    }

                    public final void run() {
                        this.pvx.pvw.pvu.setVisibility(0);
                        this.pvx.pvw.pvu.startAnimation(AnimationUtils.loadAnimation(this.pvx.pvw.getContext(), com.tencent.mm.plugin.af.a.a.aQX));
                    }
                });
                this.pvw.kmM.bN(true);
                c.a(this.pvw);
            }

            public final int bI(int i, int i2) {
                return 0;
            }

            public final void bp(int i, int i2) {
            }
        });
        findViewById(e.cLG).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c pvw;

            {
                this.pvw = r1;
            }

            public final void onClick(View view) {
                this.pvw.bcs();
            }
        });
        ((View) this.kmM).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c pvw;

            {
                this.pvw = r1;
            }

            public final void onClick(View view) {
                this.pvw.bcs();
            }
        });
        if (this.hIN != null) {
            this.kmM.stop();
            this.kmM.setVideoPath(this.hIN);
        }
        w.d("MicroMsg.VideoPopupHelper", (System.currentTimeMillis() - currentTimeMillis) + " initView end");
        com.tencent.mm.sdk.b.b qvVar = new qv();
        qvVar.fXQ.type = 1;
        com.tencent.mm.sdk.b.a.urY.m(qvVar);
    }

    private void bcs() {
        w.v("check", "onclick");
        if (this.kmM.isPlaying()) {
            this.kmM.pause();
            this.iXd.aS(false);
        }
        new ae().post(new Runnable(this) {
            final /* synthetic */ c pvw;

            {
                this.pvw = r1;
            }

            public final void run() {
                this.pvw.dismiss();
            }
        });
    }

    public final void dismiss() {
        w.d("MicroMsg.VideoPopupHelper", "on dismiss");
        if (com.tencent.mm.booter.a.pQ() != null) {
            com.tencent.mm.booter.a.pQ().pR();
        }
        if (this.kmM != null) {
            this.kmM.a(null);
            this.kmM.stop();
            this.kmM.onDetach();
            findViewById(e.cLG).setOnClickListener(null);
        }
        if (!this.pvv && isShowing()) {
            com.tencent.mm.sdk.b.b qvVar = new qv();
            qvVar.fXQ.type = 0;
            qvVar.fXQ.fXR = this.puA;
            qvVar.fXQ.fXS = this.lHi;
            qvVar.fXQ.fXT = this.fXT;
            com.tencent.mm.sdk.b.a.urY.m(qvVar);
        }
        super.dismiss();
        this.iXd.aS(true);
    }
}
