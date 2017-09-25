package com.tencent.mm.pluginsdk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.e.a.rl;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.wcdb.FileUtils;

@a(3)
public class VoiceInputUI extends MMActivity {
    private String fEr;
    private Button kSO;
    private int offset;
    private MMEditText sLn;
    private VoiceInputFooter sLo;
    private String sLp;
    private long sLq = 0;
    private boolean sLr = true;
    private boolean sLs = false;
    private OnTouchListener sLt = new OnTouchListener(this) {
        final /* synthetic */ VoiceInputUI sLw;

        {
            this.sLw = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.sLw.textChangeCount = this.sLw.textChangeCount + 1;
            } else if (motionEvent.getAction() == 1) {
                VoiceInputFooter b;
                if (this.sLw.sLo.bEw()) {
                    b = this.sLw.sLo;
                    b.bEx();
                    b.setVisibility(8);
                }
                if (this.sLw.sLo.bli()) {
                    b = this.sLw.sLo;
                    b.YD();
                    b.setVisibility(8);
                }
                b = this.sLw.sLo;
                b.setVisibility(0);
                if (b.sKF != null) {
                    b.sKF.setImageResource(R.g.bef);
                }
            }
            return false;
        }
    };
    private OnMenuItemClickListener sLu = new OnMenuItemClickListener(this) {
        final /* synthetic */ VoiceInputUI sLw;

        {
            this.sLw = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            this.sLw.sLn.setText("");
            this.sLw.sLs = true;
            this.sLw.xn(6);
            return true;
        }
    };
    private VoiceInputFooter.a sLv = new VoiceInputFooter.a(this) {
        final /* synthetic */ VoiceInputUI sLw;

        {
            this.sLw = r1;
        }

        public final void jo(boolean z) {
            if (z) {
                this.sLw.kSO.setVisibility(4);
            } else {
                this.sLw.kSO.setVisibility(0);
            }
        }

        public final void bEz() {
            this.sLw.xn(8);
        }
    };
    private int textChangeCount = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(FileUtils.S_IWUSR);
        Intent intent = getIntent();
        if (intent != null) {
            this.fEr = intent.getStringExtra("text");
            this.offset = intent.getIntExtra("offset", -1);
            this.sLp = intent.getStringExtra("punctuation");
        }
        this.sLq = bg.NA();
        this.textChangeCount = 0;
        this.sLs = false;
        this.sLr = true;
        this.sLn = (MMEditText) findViewById(R.h.cMQ);
        this.kSO = (Button) findViewById(R.h.cMP);
        this.sLn.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ VoiceInputUI sLw;

            {
                this.sLw = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                w.d("VoiceInputUI", "afterTextChanged firstTextChange:%s,textChange:%s", Boolean.valueOf(this.sLw.sLr), Boolean.valueOf(this.sLw.sLs));
                if (this.sLw.sLr) {
                    this.sLw.sLr = false;
                    return;
                }
                this.sLw.sLs = true;
                this.sLw.sLn.requestLayout();
            }
        });
        this.kSO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ VoiceInputUI sLw;

            {
                this.sLw = r1;
            }

            public final void onClick(View view) {
                VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                voiceInputBehavior.send = 3;
                VoiceInputUI.a(voiceInputBehavior);
                this.sLw.xn(7);
            }
        });
        qP(getString(R.l.fay));
        kr(true);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ VoiceInputUI sLw;

            {
                this.sLw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.sLw.xn(1);
                return true;
            }
        });
        this.sLn.setOnTouchListener(this.sLt);
        this.sLn.Uz(this.fEr);
        if (this.offset != -1) {
            this.sLn.setSelection(this.offset);
        }
        this.sLo = (VoiceInputFooter) findViewById(R.h.czE);
        VoiceInputFooter voiceInputFooter = this.sLo;
        MMEditText mMEditText = this.sLn;
        String str = this.sLp;
        voiceInputFooter.qGv = mMEditText;
        mMEditText.setOnClickListener(new OnClickListener(voiceInputFooter) {
            final /* synthetic */ VoiceInputFooter sKN;

            {
                this.sKN = r1;
            }

            public final void onClick(View view) {
                if (this.sKN.getVisibility() == 8) {
                    this.sKN.setVisibility(0);
                }
                if (this.sKN.bEw()) {
                    this.sKN.bEx();
                }
                if (this.sKN.bli()) {
                    this.sKN.YD();
                }
            }
        });
        mMEditText.setOnEditorActionListener(new OnEditorActionListener(voiceInputFooter) {
            final /* synthetic */ VoiceInputFooter sKN;

            {
                this.sKN = r1;
            }

            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return false;
            }
        });
        if (voiceInputFooter.sKE == null) {
            voiceInputFooter.sKE = new m(voiceInputFooter.getContext(), true, voiceInputFooter.qGv);
            voiceInputFooter.sKE.sQP = new m.a(voiceInputFooter) {
                final /* synthetic */ VoiceInputFooter sKN;

                {
                    this.sKN = r1;
                }

                public final void bEy() {
                }

                public final void MI(String str) {
                    if (this.sKN.sKM != null) {
                        this.sKN.sKM.bEz();
                    }
                }

                public final void jn(boolean z) {
                }
            };
            voiceInputFooter.sKE.xJ(j.aD(voiceInputFooter.getContext()));
        }
        voiceInputFooter.sKE.bGe();
        voiceInputFooter.sKE.bFk();
        voiceInputFooter.sKE.setVisibility(8);
        m mVar = voiceInputFooter.sKE;
        if (str != null) {
            mVar.sRl = str;
        }
        mVar.bGg();
        voiceInputFooter.sKH.addView(voiceInputFooter.sKE, -1, 0);
        this.sLo.sKM = this.sLv;
    }

    protected void onResume() {
        super.onResume();
        this.sLn.requestFocus();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.sLo != null) {
            VoiceInputFooter voiceInputFooter = this.sLo;
            if (voiceInputFooter.nuR != null) {
                voiceInputFooter.nuR.anN();
                voiceInputFooter.nuR.destroy();
            }
            if (voiceInputFooter.sKE != null) {
                voiceInputFooter.sKE.destory();
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dpB;
    }

    public final void VK() {
        xn(3);
        super.VK();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            xn(2);
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void xn(int i) {
        w.i("VoiceInputUI", "alvinluo voiceinputui finish type: %d, call stack: %s", Integer.valueOf(i), bg.bJZ().toString());
        if (i == 8) {
            mN(7);
        } else {
            mN(i);
        }
        b rlVar = new rl();
        if (i == 7) {
            rlVar.fYv.action = 1;
        } else if (i == 8) {
            rlVar.fYv.action = 4;
        } else {
            rlVar.fYv.action = 2;
        }
        if (this.sLs) {
            rlVar.fYv.fYw = 1;
        } else {
            rlVar.fYv.fYw = 2;
        }
        rlVar.fYv.result = this.sLn.getText().toString();
        com.tencent.mm.sdk.b.a.urY.m(rlVar);
        bg.cX(this.sLn);
        super.finish();
    }

    private static void a(VoiceInputBehavior voiceInputBehavior) {
        w.i("VoiceInputUI", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime));
        com.tencent.mm.bd.a com_tencent_mm_plugin_report_kvdata_log_13905 = new log_13905();
        com_tencent_mm_plugin_report_kvdata_log_13905.viOp_ = voiceInputBehavior;
        g.oUh.b(13905, com_tencent_mm_plugin_report_kvdata_log_13905);
    }

    private void mN(int i) {
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        voiceInputBehavior.textChangeCount = this.textChangeCount;
        voiceInputBehavior.textChangeReturn = i;
        if (this.sLq != 0) {
            voiceInputBehavior.textChangeTime = bg.aB(this.sLq);
            this.sLq = 0;
        }
        a(voiceInputBehavior);
    }
}
