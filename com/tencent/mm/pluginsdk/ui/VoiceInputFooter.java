package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.m;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class VoiceInputFooter extends BasePanelKeybordLayout {
    private MMActivity fCi;
    ChatFooterPanel nuR;
    MMEditText qGv = null;
    m sKE;
    ImageButton sKF;
    private ImageButton sKG;
    LinearLayout sKH;
    private boolean sKI = false;
    private boolean sKJ = false;
    private final int sKK = 1;
    private final int sKL = 2;
    a sKM;

    public interface a {
        void bEz();

        void jo(boolean z);
    }

    static /* synthetic */ void c(VoiceInputFooter voiceInputFooter) {
        voiceInputFooter.qGv.requestFocus();
        if (voiceInputFooter.sKI) {
            voiceInputFooter.bEx();
            voiceInputFooter.fCi.aHj();
        } else {
            voiceInputFooter.sKI = true;
            voiceInputFooter.fCi.aHf();
            if (voiceInputFooter.bli()) {
                voiceInputFooter.YD();
            }
            if (voiceInputFooter.sKE != null) {
                voiceInputFooter.sKE.setVisibility(0);
            }
            voiceInputFooter.sKG.setImageResource(R.g.beg);
            int U = com.tencent.mm.bg.a.U(voiceInputFooter.fCi, R.f.bbk);
            voiceInputFooter.sKG.setPadding(U, 0, U, 0);
            voiceInputFooter.sKF.setImageResource(R.g.bef);
            voiceInputFooter.sKF.setVisibility(8);
            if (voiceInputFooter.sKM != null) {
                voiceInputFooter.sKM.jo(true);
            }
        }
        mN(2);
    }

    static /* synthetic */ void d(VoiceInputFooter voiceInputFooter) {
        if (voiceInputFooter.bEw()) {
            voiceInputFooter.bEx();
        }
        if (voiceInputFooter.sKJ) {
            voiceInputFooter.qGv.requestFocus();
            voiceInputFooter.YD();
            voiceInputFooter.fCi.aHj();
            voiceInputFooter.sKF.setImageResource(R.g.bef);
        } else {
            voiceInputFooter.fCi.aHf();
            voiceInputFooter.sKJ = true;
            voiceInputFooter.nuR.onResume();
            voiceInputFooter.nuR.setVisibility(0);
            voiceInputFooter.qGv.requestFocus();
            voiceInputFooter.sKF.setImageResource(R.g.beg);
            voiceInputFooter.sKG.setImageResource(R.g.ble);
        }
        mN(1);
    }

    public VoiceInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fCi = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) r.eC(this.fCi).inflate(R.i.dpC, this);
        this.sKG = (ImageButton) viewGroup.findViewById(R.h.boo);
        this.sKG.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VoiceInputFooter sKN;

            {
                this.sKN = r1;
            }

            public final void onClick(View view) {
                VoiceInputFooter.c(this.sKN);
            }
        });
        this.sKF = (ImageButton) viewGroup.findViewById(R.h.boi);
        this.sKF.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VoiceInputFooter sKN;

            {
                this.sKN = r1;
            }

            public final void onClick(View view) {
                VoiceInputFooter.d(this.sKN);
            }
        });
        if (e.sQl == null) {
            this.nuR = new d(this.fCi);
            return;
        }
        this.nuR = e.sQl.bR(getContext());
        this.nuR.lw(ChatFooterPanel.SCENE_SNS);
        this.nuR.setVisibility(8);
        this.sKH = (LinearLayout) findViewById(R.h.czn);
        this.sKH.setOnClickListener(null);
        this.sKH.addView(this.nuR, -1, 0);
        this.nuR.anO();
        this.nuR.dA(false);
        this.nuR.sIy = new com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a(this) {
            final /* synthetic */ VoiceInputFooter sKN;

            {
                this.sKN = r1;
            }

            public final void aIN() {
            }

            public final void fz(boolean z) {
            }

            public final void Zh() {
                this.sKN.qGv.wvn.sendKeyEvent(new KeyEvent(0, 67));
                this.sKN.qGv.wvn.sendKeyEvent(new KeyEvent(1, 67));
            }

            public final void append(String str) {
                try {
                    this.sKN.qGv.Uz(str);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.VoiceInputFooter", e, "", new Object[0]);
                }
            }
        };
    }

    public final boolean bli() {
        return this.nuR.getVisibility() == 0;
    }

    public final boolean bEw() {
        return this.sKE.getVisibility() == 0;
    }

    final void bEx() {
        this.sKI = false;
        if (this.sKE != null) {
            this.sKE.pause();
            this.sKE.setVisibility(8);
            this.sKG.setImageResource(R.g.ble);
            this.sKG.setPadding(0, 0, com.tencent.mm.bg.a.U(this.fCi, R.f.bbk), 0);
            this.sKF.setVisibility(0);
            if (this.sKM != null) {
                this.sKM.jo(false);
            }
        }
    }

    final void YD() {
        this.sKJ = false;
        this.nuR.onPause();
        this.nuR.setVisibility(8);
    }

    protected final List<View> aIM() {
        List<View> arrayList = new ArrayList();
        arrayList.add(this.nuR);
        arrayList.add(this.sKE);
        return arrayList;
    }

    private static void mN(int i) {
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        if (i == 1) {
            voiceInputBehavior.smileIconClick = 1;
        } else if (i == 2) {
            voiceInputBehavior.voiceIconClick = 1;
        } else {
            return;
        }
        w.i("MicroMsg.VoiceInputFooter", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime));
        com.tencent.mm.bd.a com_tencent_mm_plugin_report_kvdata_log_13905 = new log_13905();
        com_tencent_mm_plugin_report_kvdata_log_13905.viOp_ = voiceInputBehavior;
        g.oUh.b(13905, com_tencent_mm_plugin_report_kvdata_log_13905);
    }
}
