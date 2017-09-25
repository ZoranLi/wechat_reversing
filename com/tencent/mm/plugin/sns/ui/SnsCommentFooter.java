package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.bba;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class SnsCommentFooter extends BasePanelKeybordLayout {
    private MMActivity fCi;
    private ImageButton nuO;
    MMEditText nuP;
    private Button nuQ;
    ChatFooterPanel nuR;
    boolean nuS = false;
    public boolean nuT = false;
    private boolean nuU = true;
    boolean nuV = true;
    private TextWatcher nuW = new TextWatcher(this) {
        final /* synthetic */ SnsCommentFooter qBh;

        {
            this.qBh = r1;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            if (this.qBh.nuP.getText() != null) {
                this.qBh.nuP.requestFocus();
                boolean z = editable.length() > 0 && editable.toString().trim().length() > 0;
                if (z && this.qBh.nuV) {
                    this.qBh.fy(true);
                    this.qBh.nuV = false;
                }
                if (!z) {
                    this.qBh.fy(false);
                    this.qBh.nuV = true;
                }
            }
        }
    };
    bba pUa = null;
    ImageView qAY;
    Button qAZ;
    int qBa = 0;
    public boolean qBb;
    private String qBc = "";
    private boolean qBd = false;
    a qBe;
    d qBf;
    private bh qBg;
    int state = 0;

    class AnonymousClass7 implements OnClickListener {
        final /* synthetic */ SnsCommentFooter qBh;
        final /* synthetic */ b qBl;

        AnonymousClass7(SnsCommentFooter snsCommentFooter, b bVar) {
            this.qBh = snsCommentFooter;
            this.qBl = bVar;
        }

        public final void onClick(View view) {
            this.qBh.qAY.setImageResource(e.pzw);
            Animation scaleAnimation = new ScaleAnimation(0.9f, 1.3f, 0.9f, 1.3f, 1, 0.5f, 1, 0.5f);
            scaleAnimation.setDuration(400);
            scaleAnimation.setStartOffset(100);
            scaleAnimation.setRepeatCount(0);
            this.qBh.qAY.startAnimation(scaleAnimation);
            scaleAnimation.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ AnonymousClass7 qBm;

                {
                    this.qBm = r1;
                }

                public final void onAnimationEnd(Animation animation) {
                    this.qBm.qBh.qAY.setImageResource(e.pzv);
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationStart(Animation animation) {
                }
            });
            this.qBl.bjZ();
        }
    }

    interface a {
        void bjY();
    }

    interface b {
        void bjZ();
    }

    interface c {
        void GF(String str);
    }

    interface d {
        void azn();
    }

    static /* synthetic */ void h(SnsCommentFooter snsCommentFooter) {
        snsCommentFooter.nuR.onPause();
        snsCommentFooter.nuR.setVisibility(8);
    }

    public final boolean bka() {
        if (this.nuP.getText() == null || bg.mA(this.nuP.getText().toString())) {
            return true;
        }
        return false;
    }

    public SnsCommentFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fCi = (MMActivity) context;
    }

    public final void bkb() {
        ViewGroup viewGroup = (ViewGroup) inflate(this.fCi, g.pHv, this);
        this.qAY = (ImageView) viewGroup.findViewById(f.pFb);
        this.nuQ = (Button) viewGroup.findViewById(f.pBf);
        this.qAZ = (Button) viewGroup.findViewById(f.pAZ);
        this.nuP = (MMEditText) viewGroup.findViewById(f.pAX);
        fy(false);
        this.nuO = (ImageButton) viewGroup.findViewById(f.boi);
        this.nuO.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsCommentFooter qBh;

            {
                this.qBh = r1;
            }

            public final void onClick(View view) {
                this.qBh.nuS = true;
                w.i("MicroMsg.SnsCommentFooter", "state onClick" + this.qBh.state);
                if (this.qBh.state == 0) {
                    this.qBh.bkd();
                    this.qBh.nuP.requestFocus();
                    this.qBh.state = 1;
                    this.qBh.Zd();
                    this.qBh.nuO.setImageResource(e.beg);
                    this.qBh.nuU = false;
                    return;
                }
                SnsCommentFooter.h(this.qBh);
                this.qBh.nuU = false;
                this.qBh.nuP.requestFocus();
                this.qBh.bkc();
                this.qBh.nuO.setImageResource(e.bef);
                this.qBh.state = 0;
            }
        });
        this.nuP.setHint(this.fCi.getString(j.pMR));
        this.nuP.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SnsCommentFooter qBh;

            {
                this.qBh = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.qBh.nuU = false;
                this.qBh.nuR.setVisibility(8);
                this.qBh.nuR.onPause();
                this.qBh.nuO.setImageResource(e.bef);
                if (this.qBh.qBe != null) {
                    this.qBh.qBe.bjY();
                }
                this.qBh.state = 0;
                return false;
            }
        });
        if (com.tencent.mm.pluginsdk.ui.chat.e.sQl == null) {
            this.nuR = new com.tencent.mm.pluginsdk.ui.chat.d(this.fCi);
            return;
        }
        this.nuR = com.tencent.mm.pluginsdk.ui.chat.e.sQl.bR(getContext());
        this.nuR.lw(ChatFooterPanel.SCENE_SNS);
        this.nuR.setVisibility(8);
        this.nuR.setBackgroundResource(e.bcX);
        ((LinearLayout) findViewById(f.czn)).addView(this.nuR, -1, 0);
        this.nuR.anO();
        this.nuR.dA(false);
        this.nuR.sIy = new com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a(this) {
            final /* synthetic */ SnsCommentFooter qBh;

            {
                this.qBh = r1;
            }

            public final void aIN() {
            }

            public final void fz(boolean z) {
            }

            public final void Zh() {
                if (this.qBh.nuP != null && this.qBh.nuP.wvn != null) {
                    this.qBh.nuP.wvn.sendKeyEvent(new KeyEvent(0, 67));
                    this.qBh.nuP.wvn.sendKeyEvent(new KeyEvent(1, 67));
                }
            }

            public final void append(String str) {
                try {
                    this.qBh.nuP.Uz(str);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.SnsCommentFooter", e, "", new Object[0]);
                }
            }
        };
    }

    public void setVisibility(int i) {
        boolean z = false;
        this.state = 0;
        if (i == 0) {
            z = true;
        }
        hK(z);
        super.setVisibility(i);
    }

    public final void hK(boolean z) {
        if (this.nuR != null) {
            this.qBb = z;
            w.i("MicroMsg.SnsCommentFooter", "showState " + z);
            if (z) {
                if (this.state == 0) {
                    bkc();
                    this.nuP.requestFocus();
                    this.nuR.setVisibility(8);
                } else {
                    bkd();
                    this.nuP.requestFocus();
                    Zd();
                }
                this.nuU = false;
                return;
            }
            this.nuR.setVisibility(8);
            this.nuO.setImageResource(i.dzU);
            bkd();
            requestLayout();
        }
    }

    private void bkc() {
        if (this.fCi.uSU.uTG != 1) {
            this.fCi.aHj();
        }
    }

    private void bkd() {
        if (this.fCi.uSU.uTG == 1) {
            this.fCi.aHf();
        }
    }

    private void Zd() {
        this.nuR.onResume();
        this.nuR.setVisibility(0);
        LayoutParams layoutParams = this.nuR.getLayoutParams();
        if (layoutParams != null && com.tencent.mm.compatible.util.j.aF(getContext()) && this.nuU) {
            layoutParams.height = com.tencent.mm.compatible.util.j.aD(getContext());
            this.nuR.setLayoutParams(layoutParams);
            this.nuU = false;
        }
        if (this.qBf != null) {
            this.qBf.azn();
        }
    }

    public final boolean bke() {
        return this.state == 1;
    }

    public final void bkf() {
        if (this.nuP == null) {
            w.e("MicroMsg.SnsCommentFooter", "send edittext is null");
            return;
        }
        this.nuP.removeTextChangedListener(this.nuW);
        this.nuP.addTextChangedListener(this.nuW);
    }

    public final void h(final List<k> list, String str) {
        this.qBc = str;
        if (this.nuP != null) {
            String ap;
            String str2 = "";
            for (k kVar : list) {
                if (str.equals(kVar.arH)) {
                    list.remove(kVar);
                    ap = bg.ap(kVar.text, "");
                    break;
                }
            }
            ap = str2;
            if (bg.mA(ap)) {
                this.nuP.setText("");
            } else {
                this.qAZ.setVisibility(0);
                this.nuQ.setVisibility(8);
                this.nuP.setText("");
                this.nuP.Uz(ap);
            }
            if (!this.qBd) {
                this.nuP.addTextChangedListener(new TextWatcher(this) {
                    final /* synthetic */ SnsCommentFooter qBh;

                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void afterTextChanged(Editable editable) {
                        if (this.qBh.nuP.getText() != null) {
                            k kVar;
                            boolean z;
                            w.d("MicroMsg.SnsCommentFooter", "update commentkey:" + this.qBh.qBc);
                            for (k kVar2 : list) {
                                if (this.qBh.qBc.equals(kVar2.arH)) {
                                    w.d("MicroMsg.SnsCommentFooter", "afterTextChanged update");
                                    kVar2.text = this.qBh.nuP.getText().toString();
                                    z = true;
                                    break;
                                }
                            }
                            z = false;
                            if (!z) {
                                w.d("MicroMsg.SnsCommentFooter", "afterTextChanged add");
                                kVar2 = new k();
                                kVar2.arH = this.qBh.qBc;
                                kVar2.text = this.qBh.nuP.getText().toString();
                                if (kVar2.text != null && kVar2.text.length() > 0) {
                                    list.add(kVar2);
                                }
                            }
                            if (list.size() > 5) {
                                w.d("MicroMsg.SnsCommentFooter", "comments remove");
                                list.remove(0);
                            }
                            this.qBh.nuP.requestFocus();
                            z = editable.length() > 0 && editable.toString().trim().length() > 0;
                            if (z && this.qBh.nuV) {
                                this.qBh.fy(z);
                                this.qBh.nuV = false;
                            }
                            if (!z) {
                                this.qBh.fy(z);
                                this.qBh.nuV = true;
                            }
                        }
                    }
                });
            }
            this.qBd = true;
        }
    }

    public final void a(String str, bba com_tencent_mm_protocal_c_bba) {
        this.qBa = 0;
        if (bg.mA(str)) {
            this.nuP.setHint("");
        } else {
            this.nuP.setHint(h.a(getContext(), str + this.fCi.getString(j.pKr, new Object[]{Float.valueOf(this.nuP.getTextSize())})));
        }
        this.pUa = com_tencent_mm_protocal_c_bba;
    }

    public final void b(String str, bba com_tencent_mm_protocal_c_bba) {
        if (bg.mA(str)) {
            this.nuP.setHint("");
        } else {
            this.nuP.setHint(h.a(getContext(), this.fCi.getString(j.pKj) + str + this.fCi.getString(j.pKr, new Object[]{Float.valueOf(this.nuP.getTextSize())})));
            this.qBa = 1;
        }
        this.pUa = com_tencent_mm_protocal_c_bba;
    }

    public final void bkg() {
        this.nuP.setText("");
        this.nuP.setHint("");
        this.pUa = null;
        this.qBa = 0;
        this.state = 0;
    }

    public final void GR(String str) {
        this.nuP.setHint(h.b(getContext(), str, this.nuP.getTextSize()));
    }

    public final bba bkh() {
        if (this.pUa == null) {
            return new bba();
        }
        return this.pUa;
    }

    public final void a(final c cVar) {
        this.qAZ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsCommentFooter qBh;

            public final void onClick(View view) {
                com.tencent.mm.ui.tools.a.c Ch = com.tencent.mm.ui.tools.a.c.d(this.qBh.nuP).Ch(com.tencent.mm.i.b.sy());
                Ch.wpp = true;
                Ch.a(new com.tencent.mm.ui.tools.a.c.a(this) {
                    final /* synthetic */ AnonymousClass6 qBk;

                    {
                        this.qBk = r1;
                    }

                    public final void ro(String str) {
                        cVar.GF(this.qBk.qBh.nuP.getText().toString());
                        this.qBk.qBh.nuP.setText("");
                    }

                    public final void YN() {
                    }

                    public final void Yp() {
                        com.tencent.mm.ui.base.g.h(this.qBk.qBh.fCi, j.pMV, j.pMW);
                    }
                });
            }
        });
    }

    public final void bki() {
        this.qAY.setVisibility(8);
    }

    protected final void nx(int i) {
        super.nx(i);
        switch (i) {
            case -3:
                this.nuT = true;
                if (getVisibility() == 0 && this.qBg != null) {
                    w.d("MicroMsg.SnsCommentFooter", "jacks dynamic adjust animation up");
                    this.qBg.bln();
                    return;
                }
                return;
            default:
                this.nuT = false;
                return;
        }
    }

    public final void aIL() {
        this.qBg = null;
        if (this.nuR != null) {
            w.i("MicroMsg.SnsCommentFooter", "commentfooter release");
            this.nuR.anN();
            this.nuR.destroy();
        }
    }

    private void fy(boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.sns.i.a.aRm);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), com.tencent.mm.plugin.sns.i.a.aRn);
        loadAnimation.setDuration(150);
        loadAnimation2.setDuration(150);
        if (this.nuQ != null && this.qAZ != null) {
            if (z) {
                if (this.nuQ.getVisibility() != 8 && this.nuQ.getVisibility() != 4) {
                    this.qAZ.startAnimation(loadAnimation);
                    this.qAZ.setVisibility(0);
                    this.nuQ.startAnimation(loadAnimation2);
                    this.nuQ.setVisibility(8);
                } else {
                    return;
                }
            } else if (this.nuQ.getVisibility() != 0 && this.nuQ.getVisibility() != 0) {
                this.nuQ.startAnimation(loadAnimation);
                this.nuQ.setVisibility(0);
                this.qAZ.startAnimation(loadAnimation2);
                this.qAZ.setVisibility(8);
            } else {
                return;
            }
            this.qAZ.getParent().requestLayout();
        }
    }

    protected final List<View> aIM() {
        List<View> arrayList = new ArrayList();
        arrayList.add(this.nuR);
        return arrayList;
    }
}
