package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.Downloads;

public class RadarTipsView extends RelativeLayout {
    View oIA = null;
    LinearLayout oIB = null;
    private final int oIC = 0;
    private final int oID = 1;
    private final int oIE = 2;
    private final int oIF = 3;
    private final int oIG = 3;
    ae oIH = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ RadarTipsView oIS;

        public final void handleMessage(Message message) {
            if (message.what == 0) {
                this.oIS.aVS();
            } else if (message.what == 1) {
                if (this.oIS.oIJ && this.oIS.oIL) {
                    r0 = this.oIS;
                    r0.bz(r0.getContext().getString(R.l.eHN), -1);
                }
            } else if (message.what == 2) {
            } else {
                if (message.what == 3) {
                    r0 = this.oIS;
                    r0.oII = true;
                    r0.oIR = 2;
                    w.d("MicroMsg.RadarTipsView", "showNoviceEducation");
                    r0.oIK = true;
                    r0.oIA.setVisibility(8);
                    r0.oIA.clearAnimation();
                    r0.setVisibility(0);
                    r0.oIB.setVisibility(0);
                    r0.oIB.startAnimation(r0.oIx);
                    r0.oIB.requestFocus();
                } else if (message.what == 3) {
                    this.oIS.aVR();
                }
            }
        }
    };
    boolean oII = false;
    private boolean oIJ = true;
    boolean oIK = false;
    boolean oIL = false;
    int oIM = 0;
    long oIN = 0;
    boolean oIO = false;
    private boolean oIP = false;
    private int oIQ = 0;
    int oIR = 0;
    private ae oIw = new ae(this) {
        final /* synthetic */ RadarTipsView oIS;

        {
            this.oIS = r1;
        }

        public final void handleMessage(Message message) {
            this.oIS.setVisibility(8);
        }
    };
    Animation oIx = null;
    Animation oIy = null;
    TextView oIz = null;

    public RadarTipsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RadarTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void bz(String str, int i) {
        this.oII = true;
        this.oIB.setVisibility(8);
        this.oIB.clearAnimation();
        this.oIz.setText(str);
        setVisibility(0);
        this.oIA.setVisibility(0);
        this.oIA.startAnimation(this.oIx);
        this.oIH.removeMessages(0);
        this.oIH.removeMessages(2);
        if (i > 0) {
            this.oIH.sendEmptyMessageDelayed(0, (long) i);
        }
    }

    public final void Dg(String str) {
        this.oIR = 3;
        bz(str, Downloads.MIN_RETYR_AFTER);
    }

    public final void aVR() {
        this.oII = false;
        this.oIR = 0;
        w.d("MicroMsg.RadarTipsView", "hidNoviceEducation");
        this.oIH.removeMessages(3);
        if (getVisibility() == 0 && this.oIB.getVisibility() == 0) {
            this.oIB.clearAnimation();
            if (this.oIA.getAnimation() == this.oIy) {
                this.oIA.clearAnimation();
            }
            w.d("MicroMsg.RadarTipsView", "hideNoviceEducation real");
            this.oIB.startAnimation(this.oIy);
        }
    }

    public final void gx(boolean z) {
        this.oIJ = z;
        if (!this.oIJ) {
            aVS();
            aVT();
            aVR();
        }
    }

    public final void aVS() {
        w.d("MicroMsg.RadarTipsView", "hideRadarTips");
        if (getVisibility() == 0 && this.oIA.getVisibility() == 0) {
            if (this.oIB.getAnimation() == this.oIy) {
                this.oIB.clearAnimation();
            }
            this.oIA.clearAnimation();
            w.d("MicroMsg.RadarTipsView", "hideRadarTips real");
            this.oIR = 0;
            this.oII = false;
            this.oIA.startAnimation(this.oIy);
        }
    }

    public final void aVT() {
        this.oII = false;
        this.oIH.removeMessages(1);
        this.oIH.removeMessages(2);
        this.oIH.removeMessages(3);
    }
}
