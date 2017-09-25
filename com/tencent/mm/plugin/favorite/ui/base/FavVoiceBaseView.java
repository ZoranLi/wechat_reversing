package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.favorite.b.u;
import com.tencent.mm.plugin.favorite.b.w;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.s;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class FavVoiceBaseView extends LinearLayout implements com.tencent.mm.plugin.favorite.b.w.a {
    private int duration;
    private int fKw;
    public w lFN;
    private ViewGroup lKB;
    private TextView lKC;
    private ImageButton lKD;
    private TextView lKE;
    private a lKF;
    private String path = "";

    private class a extends ae {
        boolean isPaused;
        final /* synthetic */ FavVoiceBaseView lKG;
        float lKH;
        float lKI;
        int lKJ;
        int lKK;

        public a(FavVoiceBaseView favVoiceBaseView) {
            this.lKG = favVoiceBaseView;
        }

        public final void mD(int i) {
            this.isPaused = false;
            this.lKH = x.aw((long) i);
            this.lKI = this.lKH;
            this.lKK = com.tencent.mm.bg.a.fromDPToPix(this.lKG.getContext(), 3);
            this.lKG.lKE.setText(u.s(this.lKG.getContext(), (int) this.lKH));
            this.lKG.lKD.setImageResource(R.k.dAt);
            this.lKG.lKD.setContentDescription(this.lKG.getContext().getResources().getString(R.l.dIj));
            this.lKG.lKC.setWidth(this.lKK);
        }

        public final void begin() {
            stop();
            this.isPaused = false;
            this.lKG.lKD.setImageResource(R.k.dAu);
            this.lKG.lKD.setContentDescription(this.lKG.getContext().getResources().getString(R.l.dHU));
            sendEmptyMessage(Downloads.RECV_BUFFER_SIZE);
        }

        public final void stop() {
            this.isPaused = false;
            removeMessages(Downloads.RECV_BUFFER_SIZE);
            mD(this.lKG.duration);
        }

        public final void auz() {
            this.lKJ = ((int) ((1.0f - (this.lKI / this.lKH)) * ((float) (this.lKG.lKB.getWidth() - this.lKK)))) + this.lKK;
            this.lKG.lKE.setText(u.s(this.lKG.getContext(), Math.min((int) Math.ceil((double) this.lKI), (int) this.lKH)));
            this.lKG.lKC.setWidth(this.lKJ);
        }

        public final void eh(boolean z) {
            this.lKK = com.tencent.mm.bg.a.fromDPToPix(this.lKG.getContext(), 3);
            this.lKG.lKD.setImageResource(R.k.dAt);
            this.lKG.lKD.setContentDescription(this.lKG.getContext().getResources().getString(R.l.dIj));
            auz();
            if (z) {
                this.lKG.lKD.setImageResource(R.k.dAu);
                this.lKG.lKD.setContentDescription(this.lKG.getContext().getResources().getString(R.l.dHU));
                sendEmptyMessage(Downloads.RECV_BUFFER_SIZE);
            }
        }

        public final void handleMessage(Message message) {
            this.lKI = Math.max(0.0f, this.lKI - 0.256f);
            auz();
            if (this.lKI > 0.1f) {
                sendEmptyMessageDelayed(Downloads.RECV_BUFFER_SIZE, 256);
            }
        }
    }

    static /* synthetic */ void i(FavVoiceBaseView favVoiceBaseView) {
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.FavVoiceBaseView", "start play, path[%s] voiceType[%d]", new Object[]{favVoiceBaseView.path, Integer.valueOf(favVoiceBaseView.fKw)});
        if (favVoiceBaseView.lFN.aQ(favVoiceBaseView.path, favVoiceBaseView.fKw)) {
            favVoiceBaseView.lKC.setKeepScreenOn(true);
            favVoiceBaseView.lKF.begin();
            return;
        }
        Toast.makeText(favVoiceBaseView.getContext(), R.l.ejO, 1).show();
    }

    static /* synthetic */ boolean j(FavVoiceBaseView favVoiceBaseView) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.FavVoiceBaseView", "resume play");
        boolean atv = favVoiceBaseView.lFN.atv();
        a aVar = favVoiceBaseView.lKF;
        aVar.isPaused = false;
        aVar.sendEmptyMessage(Downloads.RECV_BUFFER_SIZE);
        aVar.lKG.lKD.setImageResource(R.k.dAu);
        aVar.lKG.lKD.setContentDescription(aVar.lKG.getContext().getResources().getString(R.l.dHU));
        favVoiceBaseView.lKC.setKeepScreenOn(true);
        return atv;
    }

    public FavVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.FavVoiceBaseView", "on configuration changed, is paused ? %B", new Object[]{Boolean.valueOf(this.lKF.isPaused)});
        if (this.lKF.isPaused) {
            this.lKF.postDelayed(new Runnable(this) {
                final /* synthetic */ FavVoiceBaseView lKG;

                {
                    this.lKG = r1;
                }

                public final void run() {
                    this.lKG.lKF.auz();
                }
            }, 128);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.lKB = (ViewGroup) findViewById(R.h.cNf);
        this.lKE = (TextView) findViewById(R.h.cNc);
        this.lKC = (TextView) findViewById(R.h.cNe);
        this.lKD = (ImageButton) findViewById(R.h.cNa);
        this.lKF = new a(this);
        this.lKD.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ FavVoiceBaseView lKG;

            {
                this.lKG = r1;
            }

            public final void onClick(View view) {
                if (!com.tencent.mm.n.a.aJ(view.getContext()) && !com.tencent.mm.n.a.aH(view.getContext())) {
                    if (!f.rZ() && !bg.mA(this.lKG.path)) {
                        s.eP(view.getContext());
                    } else if (!bg.ap(this.lKG.path, "").equals(this.lKG.lFN.path)) {
                        FavVoiceBaseView.i(this.lKG);
                    } else if (this.lKG.lFN.atu()) {
                        this.lKG.atw();
                    } else if (!FavVoiceBaseView.j(this.lKG)) {
                        FavVoiceBaseView.i(this.lKG);
                    }
                }
            }
        });
    }

    public final void A(String str, int i, int i2) {
        this.path = bg.ap(str, "");
        this.fKw = i;
        this.duration = i2;
        if (!this.path.equals(this.lFN.path)) {
            this.lKF.mD(i2);
        } else if (this.lFN.atu()) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.FavVoiceBaseView", "updateInfo .isPlay()");
            r0 = this.lKF;
            this.lFN.oU();
            r0.eh(true);
        } else if (this.lFN.oV()) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.FavVoiceBaseView", "updateInfo .isPause()");
            r0 = this.lKF;
            this.lFN.oU();
            r0.eh(false);
        } else {
            this.lKF.mD(i2);
        }
    }

    public final boolean atw() {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.FavVoiceBaseView", "pause play");
        boolean atw = this.lFN.atw();
        a aVar = this.lKF;
        aVar.isPaused = true;
        aVar.removeMessages(Downloads.RECV_BUFFER_SIZE);
        aVar.lKG.lKD.setImageResource(R.k.dAt);
        aVar.lKG.lKD.setContentDescription(aVar.lKG.getContext().getResources().getString(R.l.dIj));
        this.lKC.setKeepScreenOn(false);
        return atw;
    }

    public final void adL() {
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.FavVoiceBaseView", "stop play");
        this.lFN.adL();
        this.lKF.stop();
        this.lKC.setKeepScreenOn(false);
    }

    public final void aR(String str, int i) {
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.FavVoiceBaseView", "on play, my path %s, my duration %d, play path %s", new Object[]{this.path, Integer.valueOf(this.duration), str});
        if (bg.ap(str, "").equals(this.path)) {
            this.lKC.setKeepScreenOn(true);
            this.lKF.begin();
            return;
        }
        this.lKF.stop();
        this.lKC.setKeepScreenOn(false);
    }

    public final void onFinish() {
        adL();
    }

    public final void onPause() {
        atw();
    }
}
