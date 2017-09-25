package com.tencent.mm.plugin.wenote.ui.h5note;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ay.b;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.s;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class WNNoteFavVoiceBaseView extends LinearLayout {
    int duration;
    int fKw;
    private ae hgN;
    d iYF = null;
    int lFb = 0;
    private ViewGroup lKB;
    private ImageButton lKD;
    private TextView lKE;
    String path = "";
    private TextView swS;
    private TextView swT;
    private WNNoteFavVoiceBaseView swU;
    private SeekBar swV;
    String swW;
    boolean swX;
    boolean swY;
    boolean swZ;
    double sxa;
    a sxb;
    private boolean sxc = false;
    private OnSeekBarChangeListener sxd = new OnSeekBarChangeListener(this) {
        final /* synthetic */ WNNoteFavVoiceBaseView sxe;

        {
            this.sxe = r1;
        }

        public final void onStopTrackingTouch(SeekBar seekBar) {
            w.i("MicroMsg.WNNoteFavVoiceBaseView", "onStopTrackingTouch");
            this.sxe.sxc = false;
            int f = (int) (((double) (this.sxe.duration * seekBar.getProgress())) * 0.01d);
            float aw = b.aw((long) f);
            this.sxe.sxb.lKI = this.sxe.sxb.lKH - aw;
            this.sxe.lFb = f;
            if (this.sxe.iYF != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putInt("actionCode", 3);
                    this.sxe.iYF.d(55, bundle);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.WNNoteFavVoiceBaseView", e, "", new Object[0]);
                }
            }
        }

        public final void onStartTrackingTouch(SeekBar seekBar) {
            w.i("MicroMsg.WNNoteFavVoiceBaseView", "onStartTrackingTouch");
            this.sxe.sxc = true;
        }

        public final void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            w.i("MicroMsg.WNNoteFavVoiceBaseView", "onProgressChanged");
            if (this.sxe.sxc) {
                this.sxe.lKE.setText(b.s(this.sxe.getContext(), (int) b.aw((long) ((int) (((double) (this.sxe.duration * seekBar.getProgress())) * 0.01d)))));
            }
        }
    };

    private class a extends ae {
        boolean isPaused;
        float lKH;
        float lKI;
        int lKJ;
        int lKK;
        boolean nwF = false;
        final /* synthetic */ WNNoteFavVoiceBaseView sxe;

        public a(WNNoteFavVoiceBaseView wNNoteFavVoiceBaseView) {
            this.sxe = wNNoteFavVoiceBaseView;
        }

        public final void mD(int i) {
            this.isPaused = false;
            if (!this.nwF) {
                this.lKH = b.aw((long) i);
                if (this.sxe.lFb == 0) {
                    this.lKI = this.lKH;
                }
                this.lKK = com.tencent.mm.bg.a.fromDPToPix(this.sxe.getContext(), 3);
                this.sxe.hgN.post(new Runnable(this) {
                    final /* synthetic */ a sxf;

                    {
                        this.sxf = r1;
                    }

                    public final void run() {
                        this.sxf.sxe.lKE.setText(b.s(this.sxf.sxe.getContext(), 0));
                        this.sxf.sxe.swS.setText(b.s(this.sxf.sxe.getContext(), (int) this.sxf.lKH));
                        if (this.sxf.nwF) {
                            this.sxf.sxe.lKD.setImageResource(R.g.bmh);
                        } else {
                            this.sxf.sxe.lKD.setImageResource(R.g.bmg);
                        }
                        this.sxf.sxe.lKD.setContentDescription(this.sxf.sxe.getContext().getResources().getString(R.l.dHU));
                    }
                });
            }
        }

        public final void begin() {
            this.nwF = false;
            stop();
            this.isPaused = false;
            this.sxe.hgN.post(new Runnable(this) {
                final /* synthetic */ a sxf;

                {
                    this.sxf = r1;
                }

                public final void run() {
                    this.sxf.sxe.lKD.setImageResource(R.g.bmg);
                    this.sxf.sxe.lKD.setContentDescription(this.sxf.sxe.getContext().getResources().getString(R.l.dHU));
                    this.sxf.removeMessages(Downloads.RECV_BUFFER_SIZE);
                    this.sxf.sendEmptyMessage(Downloads.RECV_BUFFER_SIZE);
                }
            });
        }

        public final void pause() {
            this.isPaused = true;
            removeMessages(Downloads.RECV_BUFFER_SIZE);
            this.sxe.lKD.setImageResource(R.g.bmh);
            this.sxe.lKD.setContentDescription(this.sxe.getContext().getResources().getString(R.l.dIj));
        }

        public final void stop() {
            this.isPaused = false;
            mD(this.sxe.duration);
        }

        public final void auz() {
            if (!this.sxe.sxc) {
                this.lKJ = ((int) ((1.0f - (this.lKI / this.lKH)) * ((float) (this.sxe.lKB.getWidth() - this.lKK)))) + this.lKK;
                this.sxe.lKE.setText(b.s(this.sxe.getContext(), (int) (this.lKH - this.lKI)));
                this.sxe.swV.setProgress((int) ((1.0f - (this.lKI / this.lKH)) * 100.0f));
                if (this.lKI <= 0.1f) {
                    this.nwF = true;
                    this.isPaused = false;
                    removeMessages(Downloads.RECV_BUFFER_SIZE);
                    this.sxe.lKE.setText(b.s(this.sxe.getContext(), 0));
                    this.sxe.lKD.setImageResource(R.g.bmh);
                    this.sxe.lKD.setContentDescription(this.sxe.getContext().getResources().getString(R.l.dIj));
                    this.sxe.lFb = 0;
                    this.sxe.swV.setProgress(0);
                }
            }
        }

        public final void b(double d, int i, boolean z) {
            this.lKH = b.aw((long) i);
            this.lKI = (float) Math.max(0.0d, Math.min((double) this.lKH, ((double) this.lKH) * (1.0d - d)));
            this.lKK = com.tencent.mm.bg.a.fromDPToPix(this.sxe.getContext(), 3);
            this.sxe.lKD.setImageResource(R.g.bmh);
            this.sxe.lKD.setContentDescription(this.sxe.getContext().getResources().getString(R.l.dIj));
            auz();
            if (z) {
                this.sxe.lKD.setImageResource(R.g.bmg);
                this.sxe.lKD.setContentDescription(this.sxe.getContext().getResources().getString(R.l.dHU));
                removeMessages(Downloads.RECV_BUFFER_SIZE);
                sendEmptyMessage(Downloads.RECV_BUFFER_SIZE);
            }
        }

        public final void handleMessage(Message message) {
            if (message.what == 4097) {
                int i = message.arg1;
                if (!this.nwF) {
                    this.sxe.lKE.setText(b.s(this.sxe.getContext(), 0));
                    this.sxe.swS.setText(b.s(this.sxe.getContext(), (int) this.lKH));
                    this.sxe.lKD.setImageResource(R.g.bmg);
                    this.sxe.lKD.setContentDescription(this.sxe.getContext().getResources().getString(R.l.dHU));
                    return;
                }
                return;
            }
            this.lKI = Math.max(0.0f, this.lKI - 0.256f);
            auz();
            if (this.lKI <= 0.1f) {
                this.lKI = this.lKH;
            } else {
                sendEmptyMessageDelayed(Downloads.RECV_BUFFER_SIZE, 256);
            }
        }
    }

    public WNNoteFavVoiceBaseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        w.i("MicroMsg.WNNoteFavVoiceBaseView", "on configuration changed, is paused ? %B", new Object[]{Boolean.valueOf(this.sxb.isPaused)});
        if (this.sxb.isPaused) {
            this.sxb.postDelayed(new Runnable(this) {
                final /* synthetic */ WNNoteFavVoiceBaseView sxe;

                {
                    this.sxe = r1;
                }

                public final void run() {
                    this.sxe.sxb.auz();
                }
            }, 128);
        }
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.swU = (WNNoteFavVoiceBaseView) findViewById(R.h.cMZ);
        this.lKB = (ViewGroup) findViewById(R.h.cNf);
        this.lKE = (TextView) findViewById(R.h.cNc);
        this.swS = (TextView) findViewById(R.h.cNd);
        this.lKD = (ImageButton) findViewById(R.h.cNa);
        this.swT = (TextView) findViewById(R.h.cNb);
        this.hgN = new ae();
        this.swV = (SeekBar) findViewById(R.h.cNE);
        this.swV.setProgress(0);
        this.swV.setOnSeekBarChangeListener(this.sxd);
        this.swT.setClickable(true);
        this.swT.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WNNoteFavVoiceBaseView sxe;

            {
                this.sxe = r1;
            }

            public final void onClick(View view) {
                this.sxe.path = "";
                View l = this.sxe.swU;
                Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) (WNNoteFavVoiceBaseView.cN(l) * -1));
                translateAnimation.setDuration(500);
                l.startAnimation(translateAnimation);
                l.setVisibility(8);
                this.sxe.adL();
                this.sxe.bBV();
            }
        });
        this.sxb = new a(this);
        this.lKD.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WNNoteFavVoiceBaseView sxe;

            {
                this.sxe = r1;
            }

            public final void onClick(View view) {
                this.sxe.dk(view.getContext());
            }
        });
    }

    public final void dk(Context context) {
        if (!com.tencent.mm.n.a.aJ(context) && !com.tencent.mm.n.a.aH(context)) {
            if (!f.rZ() && !bg.mA(this.path)) {
                s.eP(context);
            } else if (this.iYF != null) {
                try {
                    Bundle bundle = new Bundle();
                    bundle.putInt("actionCode", 1);
                    this.iYF.d(55, bundle);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.WNNoteFavVoiceBaseView", e, "", new Object[0]);
                }
            }
        }
    }

    final void ake() {
        w.d("MicroMsg.WNNoteFavVoiceBaseView", "start play, path[%s] voiceType[%d]", new Object[]{this.path, Integer.valueOf(this.fKw)});
        if (this.iYF != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("path", this.path);
                bundle.putInt("voicetype", this.fKw);
                bundle.putInt("position", this.lFb);
                this.iYF.d(58, bundle);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.WNNoteFavVoiceBaseView", e, "", new Object[0]);
            }
        }
    }

    public final void adL() {
        w.d("MicroMsg.WNNoteFavVoiceBaseView", "stop play");
        if (this.iYF != null) {
            try {
                this.iYF.d(56, null);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.WNNoteFavVoiceBaseView", e, "", new Object[0]);
            }
        }
        this.lFb = 0;
        this.swV.setProgress(0);
        this.sxb.stop();
    }

    public final void bBV() {
        w.d("MicroMsg.WNNoteFavVoiceBaseView", "stop play");
        if (this.iYF != null) {
            try {
                this.iYF.d(59, null);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.WNNoteFavVoiceBaseView", e, "", new Object[0]);
            }
        }
    }

    static int cN(View view) {
        int height = view.getHeight();
        if (height != 0) {
            return height;
        }
        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
        return view.getMeasuredHeight();
    }
}
