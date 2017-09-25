package com.tencent.mm.pluginsdk.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mm.R;
import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

@TargetApi(16)
public class VoiceInputLayoutImpl extends VoiceInputLayout {
    private OnTouchListener nIz = new OnTouchListener(this) {
        final /* synthetic */ VoiceInputLayoutImpl sLk;

        {
            this.sLk = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.sLk.sLh = false;
                    this.sLk.sLi = bg.NA();
                    w.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_DOWN currentState %s longClickStartTime %s", new Object[]{Integer.valueOf(this.sLk.sKB), Long.valueOf(this.sLk.sLi)});
                    m a = this.sLk.sLg;
                    w.d("MicroMsg.VoiceInputDrawable", "readyPressState %s", new Object[]{Integer.valueOf(a.sKB)});
                    a.sKB = 6;
                    a.jsj.cancel();
                    a.sKs = 0.0f;
                    a.invalidateSelf();
                    this.sLk.F(false, false);
                    break;
                case 1:
                    w.d("MicroMsg.VoiceInputLayoutImp", "btn onTouch ACTION_UP currentState %s longClickDown %s", new Object[]{Integer.valueOf(this.sLk.sKB), Boolean.valueOf(this.sLk.sLh)});
                    if (!this.sLk.sLh) {
                        this.sLk.F(false, true);
                        break;
                    }
                    this.sLk.F(true, false);
                    this.sLk.sLh = false;
                    this.sLk.sLi = 0;
                    break;
            }
            return false;
        }
    };
    private View sLf;
    private m sLg;
    private boolean sLh = false;
    private long sLi;
    private OnLongClickListener sLj = new OnLongClickListener(this) {
        final /* synthetic */ VoiceInputLayoutImpl sLk;

        {
            this.sLk = r1;
        }

        public final boolean onLongClick(View view) {
            w.d("MicroMsg.VoiceInputLayoutImp", "btn onLongClickListener currentState %s", new Object[]{Integer.valueOf(this.sLk.sKB)});
            this.sLk.sLh = true;
            m a = this.sLk.sLg;
            w.d("MicroMsg.VoiceInputDrawable", "longClickState %s", new Object[]{Integer.valueOf(a.sKB)});
            a.sKB = 7;
            a.jsj.cancel();
            a.sKs = 0.0f;
            a.invalidateSelf();
            return true;
        }
    };

    public VoiceInputLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public VoiceInputLayoutImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.sLf = inflate(context, R.i.dpz, this).findViewById(R.h.cNC);
        this.sLf.setLayerType(1, null);
        this.sLg = new m(context);
        this.sLf.setBackground(this.sLg);
        this.sLf.setEnabled(true);
        this.sLf.setOnTouchListener(this.nIz);
        this.sLf.setOnLongClickListener(this.sLj);
        reset(true);
        if (!isInEditMode() && !bEM()) {
            bEL();
        }
    }

    public final void F(boolean z, boolean z2) {
        w.d("MicroMsg.VoiceInputLayoutImp", "directStart currentState = %s longUp = %s clickUp = %s", new Object[]{Integer.valueOf(this.sKB), Boolean.valueOf(z), Boolean.valueOf(z2)});
        if (this.sKB == 1) {
            if (z || z2) {
                if (z && !z2) {
                    aa(4, this.sLh);
                    aa(this.sKB, this.sLh);
                    this.sLg.bEv();
                }
            } else if (bEM()) {
                bEA();
            } else {
                bEL();
            }
        } else if (this.sKB == 2) {
            if (z2) {
                this.sLg.bEv();
                bEB();
                if (this.sLb != null) {
                    this.sLb.bEF();
                }
                aa(5, this.sLh);
                return;
            }
            if (z) {
                aa(4, this.sLh);
            }
            aa(this.sKB, this.sLh);
            be();
        } else if (!z && !z2) {
            aa(this.sKB, this.sLh);
            bEB();
        } else if (z && !z2) {
            aa(4, this.sLh);
            aa(this.sKB, this.sLh);
            this.sLg.bEv();
        }
    }

    private void bEL() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ VoiceInputLayoutImpl sLk;

            {
                this.sLk = r1;
            }

            public final void run() {
                m a = this.sLk.sLg;
                w.d("MicroMsg.VoiceInputDrawable", "disableState %s", new Object[]{Integer.valueOf(a.sKB)});
                a.sKB = 5;
                a.jsj.cancel();
                a.sKs = 0.0f;
                a.invalidateSelf();
            }
        });
        bED();
    }

    private static boolean bEM() {
        int BR = ap.vd().BR();
        return BR == 4 || BR == 6;
    }

    protected final void jq(boolean z) {
        runOnUiThread(new Runnable(this, true) {
            final /* synthetic */ VoiceInputLayoutImpl sLk;

            public final void run() {
                m a = this.sLk.sLg;
                w.d("MicroMsg.VoiceInputDrawable", "recordingStartState() called with: maxAmplitudeRate = [%s] fromLongCkick = %s", new Object[]{Integer.valueOf(0), Boolean.valueOf(true)});
                if (!true) {
                    a.sKB = 3;
                }
                a.sKx = true;
                a.invalidateSelf();
            }
        });
    }

    protected final void jr(boolean z) {
        if (!z) {
            aa(17, false);
        }
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ VoiceInputLayoutImpl sLk;

            {
                this.sLk = r1;
            }

            public final void run() {
                m a = this.sLk.sLg;
                w.d("MicroMsg.VoiceInputDrawable", "recognizingState %s", new Object[]{Integer.valueOf(a.sKB)});
                a.sKB = 4;
                a.jsj.cancel();
                a.sKs = 0.0f;
                a.jsj.setInterpolator(new AccelerateDecelerateInterpolator());
                a.jsj.setDuration(1000);
                a.jsj.setRepeatCount(-1);
                a.jsj.start();
            }
        });
    }

    protected final void onReset() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ VoiceInputLayoutImpl sLk;

            {
                this.sLk = r1;
            }

            public final void run() {
                this.sLk.sLg.bEv();
            }
        });
    }

    protected final void xm(final int i) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ VoiceInputLayoutImpl sLk;

            public final void run() {
                boolean z = true;
                m a = this.sLk.sLg;
                w.d("MicroMsg.VoiceInputDrawable", "recordingState() called with: maxAmplitudeRate = [%s]", new Object[]{Integer.valueOf(i)});
                if (i >= 28) {
                    z = false;
                }
                a.sKx = z;
                a.invalidateSelf();
            }
        });
    }

    private static void runOnUiThread(Runnable runnable) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            af.v(runnable);
        } else {
            runnable.run();
        }
    }

    private void aa(int i, boolean z) {
        a com_tencent_mm_plugin_report_kvdata_log_13905 = new log_13905();
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        if (!z) {
            voiceInputBehavior.click = i;
        } else if (this.sKY) {
            voiceInputBehavior.fullScreenVoiceLongClick = i;
            if (!(i == 4 || !this.sLh || this.sLi == 0)) {
                voiceInputBehavior.fullScreenVoiceLongClickTime = bg.aB(this.sLi);
            }
        } else {
            voiceInputBehavior.longClick = i;
            if (!(i == 4 || !this.sLh || this.sLi == 0)) {
                voiceInputBehavior.longClickTime = bg.aB(this.sLi);
            }
        }
        com_tencent_mm_plugin_report_kvdata_log_13905.viOp_ = voiceInputBehavior;
        g.oUh.b(13905, com_tencent_mm_plugin_report_kvdata_log_13905);
        w.i("MicroMsg.VoiceInputLayoutImp", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", new Object[]{Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime)});
    }
}
