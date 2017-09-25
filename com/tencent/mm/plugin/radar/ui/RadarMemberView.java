package com.tencent.mm.plugin.radar.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.radar.a.c.d;
import com.tencent.mm.protocal.c.ati;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;

public class RadarMemberView extends RelativeLayout {
    private ae handler = new ae(this) {
        final /* synthetic */ RadarMemberView oHW;

        {
            this.oHW = r1;
        }

        public final void handleMessage(Message message) {
            if (message.what == 0) {
                this.oHW.a(this.oHW.oHo, this.oHW.oHp);
            } else if (message.what == 1) {
                this.oHW.setVisibility(4);
                this.oHW.reset();
                if (this.oHW.oHE != null) {
                    this.oHW.oHE.setVisibility(0);
                }
                if (this.oHW.oHR != null) {
                    this.oHW.oHR.c(this.oHW.oHo, this.oHW.oHp);
                }
            }
        }
    };
    private x jiL;
    private TextView mdw = null;
    private EditText oBT = null;
    private View oHE = null;
    private View oHF = null;
    private ImageView oHG = null;
    private View oHH = null;
    private Button oHI = null;
    private TextView oHJ = null;
    private TextView oHK = null;
    private Button oHL = null;
    private TextView oHM = null;
    private int[] oHN = null;
    private TextView oHO = null;
    private boolean oHP = false;
    private bb oHQ;
    a oHR = null;
    private OnClickListener oHS = new OnClickListener(this) {
        final /* synthetic */ RadarMemberView oHW;

        {
            this.oHW = r1;
        }

        public final void onClick(View view) {
            String str = "";
            if (this.oHW.jiL != null) {
                if (com.tencent.mm.j.a.ez(this.oHW.jiL.field_type)) {
                    str = this.oHW.jiL.field_conRemark;
                } else {
                    ap.yY();
                    bb AI = c.wS().AI(this.oHW.jiL.field_username);
                    if ((AI == null || bg.mA(AI.field_encryptUsername)) && !bg.mA(this.oHW.jiL.field_encryptUsername)) {
                        ap.yY();
                        AI = c.wS().AI(this.oHW.jiL.field_encryptUsername);
                    }
                    if (AI != null) {
                        str = AI.field_conRemark;
                    }
                }
            }
            if (bg.mA(str) && this.oHW.oHo != null) {
                str = this.oHW.oHo.jOp;
            }
            RadarMemberView.a(this.oHW, str);
        }
    };
    private h oHT = null;
    private View oHU = null;
    private TextView oHV = null;
    public ati oHo = null;
    public d oHp = null;

    public interface a {
        void b(ati com_tencent_mm_protocal_c_ati, d dVar);

        void c(ati com_tencent_mm_protocal_c_ati, d dVar);
    }

    static /* synthetic */ void a(RadarMemberView radarMemberView, String str) {
        radarMemberView.oHU = View.inflate(radarMemberView.getContext(), R.i.dnR, null);
        radarMemberView.mdw = (TextView) radarMemberView.oHU.findViewById(R.h.cCA);
        radarMemberView.mdw.setText("");
        radarMemberView.oBT = (EditText) radarMemberView.oHU.findViewById(R.h.cCz);
        radarMemberView.oHV = (TextView) radarMemberView.oHU.findViewById(R.h.cTh);
        radarMemberView.oHV.setVisibility(0);
        radarMemberView.oBT.setText(str);
        radarMemberView.oHV.setText("50");
        radarMemberView.oBT.setFilters(com.tencent.mm.pluginsdk.ui.tools.h.sWw);
        radarMemberView.oBT.addTextChangedListener(new TextWatcher(radarMemberView) {
            final /* synthetic */ RadarMemberView oHW;

            {
                this.oHW = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                boolean z = false;
                int length = 50 - editable.length();
                if (length < 0) {
                    length = 0;
                }
                if (this.oHW.oHV != null) {
                    this.oHW.oHV.setText(String.valueOf(length));
                }
                if (this.oHW.oHT != null) {
                    Button button = this.oHW.oHT.getButton(-1);
                    if (editable.length() > 0) {
                        z = true;
                    }
                    button.setEnabled(z);
                }
            }
        });
        radarMemberView.oHT = g.a(radarMemberView.getContext(), radarMemberView.getContext().getString(R.l.eHH), radarMemberView.oHU, new DialogInterface.OnClickListener(radarMemberView) {
            final /* synthetic */ RadarMemberView oHW;

            {
                this.oHW = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (this.oHW.oHT != null) {
                    this.oHW.oHT.dismiss();
                    this.oHW.oHT = null;
                }
                RadarMemberView.k(this.oHW);
            }
        }, new DialogInterface.OnClickListener(radarMemberView) {
            final /* synthetic */ RadarMemberView oHW;

            {
                this.oHW = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (this.oHW.oHT != null) {
                    this.oHW.oHT.dismiss();
                    this.oHW.oHT = null;
                }
            }
        });
        radarMemberView.oBT.post(new Runnable(radarMemberView) {
            final /* synthetic */ RadarMemberView oHW;

            {
                this.oHW = r1;
            }

            public final void run() {
                if (this.oHW.getContext() instanceof Activity) {
                    RadarMemberView.O((Activity) this.oHW.getContext());
                }
            }
        });
    }

    static /* synthetic */ boolean k(RadarMemberView radarMemberView) {
        if (radarMemberView.oBT == null) {
            return false;
        }
        String trim = radarMemberView.oBT.getText().toString().trim();
        String b = c.b(radarMemberView.oHo);
        if (bg.mA(b)) {
            return false;
        }
        if (com.tencent.mm.j.a.ez(radarMemberView.jiL.field_type)) {
            ap.yY();
            bb AI = c.wS().AI(radarMemberView.jiL.field_username);
            if ((AI == null || bg.mA(AI.field_encryptUsername)) && !bg.mA(radarMemberView.jiL.field_encryptUsername)) {
                ap.yY();
                AI = c.wS().AI(radarMemberView.jiL.field_encryptUsername);
            }
            if (!(AI == null || bg.mA(AI.field_encryptUsername))) {
                ap.yY();
                c.wS().AJ(AI.field_encryptUsername);
            }
            radarMemberView.jiL.bP(trim);
            o.b(radarMemberView.jiL, trim);
        } else {
            radarMemberView.jiL.bP(trim);
            ap.yY();
            c.wS().a(new bb(b, trim));
        }
        if (radarMemberView.oHK != null) {
            radarMemberView.oHK.setText(trim);
        }
        return true;
    }

    public RadarMemberView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RadarMemberView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void c(String str, d dVar) {
        if (isShowing() && !this.oHP) {
            if (str.equals(this.oHo.twU) || str.equals(this.oHo.jNj)) {
                a(this.oHo, dVar);
            }
        }
    }

    private void a(ati com_tencent_mm_protocal_c_ati, d dVar) {
        this.oHO.setVisibility(0);
        switch (dVar) {
            case Stranger:
                this.oHK.setVisibility(0);
                this.oHL.setVisibility(0);
                this.oHI.setText(R.l.eHL);
                this.oHI.setVisibility(0);
                this.oHJ.setVisibility(8);
                this.oHM.setVisibility(8);
                return;
            case Verifying:
                this.oHK.setVisibility(0);
                this.oHL.setVisibility(0);
                this.oHJ.setText(R.l.eHO);
                this.oHI.setVisibility(8);
                this.oHJ.setVisibility(0);
                this.oHM.setVisibility(8);
                return;
            case Added:
                this.oHK.setVisibility(0);
                this.oHL.setVisibility(0);
                this.oHJ.setText(R.l.eHA);
                this.oHI.setVisibility(8);
                this.oHJ.setVisibility(0);
                this.oHM.setVisibility(8);
                return;
            case NeedVerify:
                this.oHK.setVisibility(0);
                this.oHL.setVisibility(0);
                this.oHI.setText(R.l.eHz);
                this.oHI.setVisibility(0);
                this.oHJ.setVisibility(8);
                this.oHM.setText(getContext().getString(R.l.cuW, new Object[]{com_tencent_mm_protocal_c_ati.jOp}));
                this.oHM.setVisibility(0);
                return;
            default:
                return;
        }
    }

    public final void a(View view, final ati com_tencent_mm_protocal_c_ati, d dVar) {
        CharSequence charSequence;
        w.d("MicroMsg.RadarMemberView", "popup");
        this.oHp = dVar;
        this.oHo = com_tencent_mm_protocal_c_ati;
        if (this.oHF == null) {
            this.oHF = findViewById(R.h.cuQ);
        }
        if (this.oHG == null) {
            this.oHG = (ImageView) findViewById(R.h.cuD);
        }
        if (this.oHH == null) {
            this.oHH = findViewById(R.h.cuC);
        }
        if (this.oHI == null) {
            this.oHI = (Button) findViewById(R.h.cuF);
        }
        this.oHI.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RadarMemberView oHW;

            public final void onClick(View view) {
                if (this.oHW.oHp != null && this.oHW.oHR != null) {
                    this.oHW.oHR.b(com_tencent_mm_protocal_c_ati, this.oHW.oHp);
                    this.oHW.dismiss();
                }
            }
        });
        if (this.oHJ == null) {
            this.oHJ = (TextView) findViewById(R.h.cuG);
        }
        if (this.oHK == null) {
            this.oHK = (TextView) findViewById(R.h.cuK);
        }
        if (this.oHL == null) {
            this.oHL = (Button) findViewById(R.h.cuJ);
            this.oHL.setOnClickListener(this.oHS);
        }
        if (this.oHM == null) {
            this.oHM = (TextView) findViewById(R.h.cuW);
        }
        setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ RadarMemberView oHW;

            {
                this.oHW = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (view != this.oHW.oHI && motionEvent.getAction() == 1 && this.oHW.isShowing()) {
                    this.oHW.dismiss();
                }
                return true;
            }
        });
        if (this.oHO == null) {
            this.oHO = (TextView) findViewById(R.h.bNq);
        }
        this.oHO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RadarMemberView oHW;

            {
                this.oHW = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("k_username", this.oHW.jiL.field_username);
                intent.putExtra("showShare", false);
                intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(38)}));
                com.tencent.mm.bb.d.b(this.oHW.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        String b = c.b(com_tencent_mm_protocal_c_ati);
        if (!bg.mA(b)) {
            ap.yY();
            this.jiL = c.wR().Rc(b);
        }
        if (this.jiL == null || !com.tencent.mm.j.a.ez(this.jiL.field_type)) {
            ap.yY();
            this.oHQ = c.wS().AI(b);
            charSequence = this.oHQ.field_conRemark;
        } else {
            charSequence = this.jiL.field_conRemark;
        }
        if (this.jiL == null || bg.mA(charSequence)) {
            this.oHK.setText(com.tencent.mm.pluginsdk.ui.d.h.b(getContext(), com_tencent_mm_protocal_c_ati.jOp, this.oHK.getTextSize()));
        } else {
            this.oHK.setText(com.tencent.mm.pluginsdk.ui.d.h.b(getContext(), charSequence, this.oHK.getTextSize()));
        }
        this.oHK.setVisibility(4);
        this.oHL.setVisibility(4);
        reset();
        this.oHE = view;
        ImageView imageView = (ImageView) this.oHE.findViewById(R.h.cuS);
        View findViewById = this.oHE.findViewById(R.h.cuC);
        this.oHE.setVisibility(4);
        this.oHG.setImageDrawable(imageView.getDrawable());
        this.oHH.setVisibility(0);
        int[] iArr = new int[2];
        findViewById.getLocationInWindow(iArr);
        int[] iArr2 = new int[2];
        this.oHF.getLocationInWindow(iArr2);
        this.oHN = iArr2;
        setVisibility(0);
        Animation animationSet = new AnimationSet(true);
        animationSet.setFillAfter(true);
        animationSet.setRepeatCount(1);
        animationSet.setDuration(500);
        float height = ((float) this.oHF.getHeight()) / ((float) findViewById.getHeight());
        Animation translateAnimation = new TranslateAnimation((float) iArr[0], ((float) iArr2[0]) - (((float) ((findViewById.getWidth() - findViewById.getHeight()) / 2)) * height), (float) iArr[1], (float) iArr2[1]);
        animationSet.addAnimation(new ScaleAnimation(1.0f, height, 1.0f, height));
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ RadarMemberView oHW;

            {
                this.oHW = r1;
            }

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                w.d("MicroMsg.RadarMemberView", "popup animation end");
                this.oHW.handler.sendEmptyMessage(0);
            }
        });
        this.oHH.startAnimation(animationSet);
    }

    public final void dismiss() {
        w.d("MicroMsg.RadarMemberView", "dismiss");
        if (!this.oHP) {
            this.oHP = true;
            View findViewById = this.oHE.findViewById(R.h.cuC);
            Animation animationSet = new AnimationSet(true);
            animationSet.setFillAfter(true);
            animationSet.setRepeatCount(1);
            animationSet.setDuration(500);
            int[] iArr = this.oHN;
            int[] iArr2 = new int[2];
            findViewById.getLocationInWindow(iArr2);
            float height = ((float) this.oHF.getHeight()) / ((float) findViewById.getHeight());
            Animation translateAnimation = new TranslateAnimation(((float) iArr[0]) - (((float) ((findViewById.getWidth() - findViewById.getHeight()) / 2)) * height), (float) iArr2[0], (float) iArr[1], (float) iArr2[1]);
            animationSet.addAnimation(new ScaleAnimation(height, 1.0f, height, 1.0f));
            animationSet.addAnimation(translateAnimation);
            animationSet.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ RadarMemberView oHW;

                {
                    this.oHW = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    w.d("MicroMsg.RadarMemberView", "dismiss animation end");
                    this.oHW.oHP = false;
                    this.oHW.handler.sendEmptyMessage(1);
                }
            });
            this.oHK.setVisibility(4);
            this.oHL.setVisibility(4);
            this.oHI.setVisibility(8);
            this.oHJ.setVisibility(8);
            this.oHM.setVisibility(8);
            this.oHO.setVisibility(8);
            this.oHH.startAnimation(animationSet);
        }
    }

    private void reset() {
        this.oHH.setVisibility(8);
        this.oHK.setVisibility(4);
        this.oHL.setVisibility(4);
        this.oHI.setVisibility(8);
        this.oHJ.setVisibility(8);
        this.oHM.setVisibility(8);
        this.oHO.setVisibility(8);
    }

    public final boolean isShowing() {
        return getVisibility() == 0;
    }

    public static void O(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager != null) {
            View currentFocus = activity.getCurrentFocus();
            if (currentFocus != null && currentFocus.getWindowToken() != null) {
                inputMethodManager.toggleSoftInput(0, 2);
            }
        }
    }
}
