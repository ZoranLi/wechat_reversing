package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.luckymoney.b.ac;
import com.tencent.mm.plugin.luckymoney.b.af;
import com.tencent.mm.plugin.luckymoney.b.c;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.v;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyCanShareListUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.luckymoney.ui.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@a(19)
public class SnsLuckyMoneyPrepareUI extends LuckyMoneyBaseUI implements f {
    private aj iUX = null;
    protected Dialog ita = null;
    protected TextView kCk = null;
    private TextView kCp;
    protected Button kYj = null;
    private ScrollView liX;
    protected MyKeyboardWindow mKeyboard;
    private int mType;
    protected Button nkd = null;
    private c nmd;
    protected LuckyMoneyNumInputView npJ = null;
    protected LuckyMoneyMoneyInputView npK = null;
    protected LuckyMoneyTextInputView npL = null;
    protected View npM;
    private View npN;
    private View npO;
    private ViewGroup npP;
    private TextView npQ;
    private com.tencent.mm.plugin.luckymoney.ui.a npR = new com.tencent.mm.plugin.luckymoney.ui.a();
    private int npS;
    private String npT;
    private int npU;
    private boolean npV;
    private String npW;
    private int npX;
    private com.tencent.mm.wallet_core.ui.a npY;

    class AnonymousClass10 implements OnFocusChangeListener {
        final /* synthetic */ boolean ipP = false;
        final /* synthetic */ EditText ipR;
        final /* synthetic */ int ipT;
        final /* synthetic */ SnsLuckyMoneyPrepareUI npZ;

        AnonymousClass10(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI, boolean z, int i, EditText editText) {
            this.npZ = snsLuckyMoneyPrepareUI;
            this.ipT = i;
            this.ipR = editText;
        }

        public final void onFocusChange(final View view, boolean z) {
            if (!view.isFocused() || this.ipP) {
                new ae().postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass10 nqc;

                    {
                        this.nqc = r1;
                    }

                    public final void run() {
                        this.nqc.npZ.Om();
                        ((InputMethodManager) this.nqc.npZ.uSU.uTo.getSystemService("input_method")).showSoftInput(this.nqc.ipR, 0);
                    }
                }, 200);
                return;
            }
            ((InputMethodManager) this.npZ.uSU.uTo.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            new ae().postDelayed(new Runnable(this) {
                final /* synthetic */ AnonymousClass10 nqc;

                public final void run() {
                    if (!this.nqc.npZ.npM.isShown() && view.isShown()) {
                        SnsLuckyMoneyPrepareUI.k(this.nqc.npZ);
                    }
                    this.nqc.npZ.mKeyboard.setXMode(this.nqc.ipT);
                    this.nqc.npZ.mKeyboard.setInputEditText((EditText) view);
                    ((InputMethodManager) this.nqc.npZ.uSU.uTo.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }, 300);
        }
    }

    class AnonymousClass12 implements OnClickListener {
        final /* synthetic */ boolean ipP = false;
        final /* synthetic */ EditText ipR;
        final /* synthetic */ int ipT;
        final /* synthetic */ SnsLuckyMoneyPrepareUI npZ;

        AnonymousClass12(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI, boolean z, int i, EditText editText) {
            this.npZ = snsLuckyMoneyPrepareUI;
            this.ipT = i;
            this.ipR = editText;
        }

        public final void onClick(View view) {
            if (!this.npZ.npM.isShown() && !this.ipP) {
                SnsLuckyMoneyPrepareUI.k(this.npZ);
                this.npZ.mKeyboard.setXMode(this.ipT);
            } else if (this.ipP) {
                this.npZ.Om();
                ((InputMethodManager) this.npZ.uSU.uTo.getSystemService("input_method")).showSoftInput(this.ipR, 0);
            }
        }
    }

    class AnonymousClass13 implements OnClickListener {
        final /* synthetic */ boolean ipP = false;
        final /* synthetic */ EditText ipR;
        final /* synthetic */ int ipT;
        final /* synthetic */ SnsLuckyMoneyPrepareUI npZ;

        AnonymousClass13(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI, boolean z, int i, EditText editText) {
            this.npZ = snsLuckyMoneyPrepareUI;
            this.ipT = i;
            this.ipR = editText;
        }

        public final void onClick(View view) {
            if (!this.npZ.npM.isShown() && !this.ipP) {
                SnsLuckyMoneyPrepareUI.k(this.npZ);
                this.npZ.mKeyboard.setXMode(this.ipT);
            } else if (this.ipP) {
                this.npZ.Om();
                ((InputMethodManager) this.npZ.uSU.uTo.getSystemService("input_method")).showSoftInput(this.ipR, 0);
            }
        }
    }

    static /* synthetic */ void k(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        if (snsLuckyMoneyPrepareUI.npM != null && !snsLuckyMoneyPrepareUI.npM.isShown()) {
            snsLuckyMoneyPrepareUI.npM.setVisibility(0);
            snsLuckyMoneyPrepareUI.npY.gC(true);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("key_type", 1);
        this.npS = getIntent().getIntExtra("key_way", 3);
        this.npV = getIntent().getIntExtra("key_from", 0) == 1;
        this.npX = getIntent().getIntExtra("pay_channel", -1);
        b(new v("v1.0", (byte) 0), false);
        com.tencent.mm.plugin.luckymoney.a.a.aHG();
        this.nmd = com.tencent.mm.plugin.luckymoney.a.a.aHH().aHS();
        w.d("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.npV + ", config " + this.nmd);
        KC();
        g.oUh.i(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aIi()), Integer.valueOf(1)});
    }

    protected final void KC() {
        r(getResources().getDrawable(R.g.bgs));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyPrepareUI npZ;

            {
                this.npZ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.npZ.finish();
                return true;
            }
        });
        this.npN = findViewById(R.h.cfS);
        this.npO = findViewById(R.h.cfV);
        this.kYj = (Button) findViewById(R.h.cfU);
        this.npL = (LuckyMoneyTextInputView) findViewById(R.h.cgx);
        this.npL.zR(getString(R.l.exm));
        this.nkd = (Button) findViewById(R.h.cfL);
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.h.cHC);
        this.npM = findViewById(R.h.cHB);
        this.kCp = (TextView) findViewById(R.h.cfK);
        this.npJ = (LuckyMoneyNumInputView) findViewById(R.h.cfH);
        this.npK = (LuckyMoneyMoneyInputView) findViewById(R.h.cdp);
        this.kCk = (TextView) findViewById(R.h.cfW);
        this.npP = (ViewGroup) findViewById(R.h.cfR);
        this.liX = (ScrollView) findViewById(R.h.cgr);
        this.npQ = (TextView) findViewById(R.h.cfP);
        if (this.mType == 1) {
            this.npK.setTitle(getString(R.l.eyA));
            this.npK.fx(true);
        } else {
            this.npK.setTitle(getString(R.l.eyB));
            this.npK.fx(false);
        }
        this.npK.nsC = this;
        this.npJ.nsC = this;
        this.npL.nsC = this;
        final EditText editText = (EditText) this.npK.findViewById(R.h.cen);
        final EditText editText2 = (EditText) this.npJ.findViewById(R.h.cen);
        e.setNoSystemInputOnEditText(editText);
        ((InputMethodManager) this.uSU.uTo.getSystemService("input_method")).showSoftInput(editText, 0);
        editText.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyPrepareUI npZ;

            public final void onClick(View view) {
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                this.npZ.z(this.npZ.npK, 2);
                this.npZ.z(this.npZ.npJ, 0);
                this.npZ.mKeyboard.setXMode(2);
                this.npZ.mKeyboard.setInputEditText((EditText) view);
                SnsLuckyMoneyPrepareUI.k(this.npZ);
            }
        });
        TextView textView = (TextView) this.npK.findViewById(R.h.cdq);
        if (textView != null) {
            textView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SnsLuckyMoneyPrepareUI npZ;

                public final void onClick(View view) {
                    editText.setOnClickListener(null);
                    editText2.setOnClickListener(null);
                    this.npZ.z(this.npZ.npK, 2);
                    this.npZ.z(this.npZ.npJ, 0);
                    this.npZ.mKeyboard.setXMode(2);
                    SnsLuckyMoneyPrepareUI.k(this.npZ);
                }
            });
        }
        e.setNoSystemInputOnEditText(editText2);
        ((InputMethodManager) this.uSU.uTo.getSystemService("input_method")).showSoftInput(editText2, 0);
        editText2.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyPrepareUI npZ;

            public final void onClick(View view) {
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                this.npZ.z(this.npZ.npK, 2);
                this.npZ.z(this.npZ.npJ, 0);
                this.npZ.mKeyboard.setXMode(0);
                this.npZ.mKeyboard.setInputEditText((EditText) view);
                SnsLuckyMoneyPrepareUI.k(this.npZ);
            }
        });
        if (this.nmd != null) {
            if (this.mType == 1) {
                this.npK.nsD = this.nmd.nlU;
            } else {
                this.npK.nsD = this.nmd.nlX;
            }
            this.npK.nsE = this.nmd.nlZ;
        }
        if (!this.npV || getIntent().getIntExtra("key_chatroom_num", 0) > 1) {
            this.npJ.zQ("");
        } else {
            this.npJ.zQ("1");
        }
        this.npJ.pa(this.nmd.nlT);
        this.npJ.ntO = 1;
        w.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.npJ.aIH());
        this.npK.aIB();
        if (this.npV) {
            if (getIntent().getIntExtra("key_chatroom_num", 0) > 0) {
                String string = getString(R.l.exK);
                String string2 = getString(R.l.exH);
                String string3 = getString(R.l.exJ);
                String string4 = getString(R.l.exI);
                final CharSequence spannableString = new SpannableString(string + string2);
                com.tencent.mm.plugin.wallet_core.ui.f fVar = new com.tencent.mm.plugin.wallet_core.ui.f(this);
                spannableString.setSpan(fVar, string.length(), string.length() + string2.length(), 33);
                final SpannableString spannableString2 = new SpannableString(string3 + string4);
                com.tencent.mm.plugin.wallet_core.ui.f fVar2 = new com.tencent.mm.plugin.wallet_core.ui.f(this);
                spannableString2.setSpan(fVar2, string3.length(), string3.length() + string4.length(), 33);
                fVar.rKS = new com.tencent.mm.plugin.wallet_core.ui.f.a(this) {
                    final /* synthetic */ SnsLuckyMoneyPrepareUI npZ;

                    public final void onClick(View view) {
                        int aIH = this.npZ.npJ.aIH();
                        double aIA = this.npZ.npK.aIA();
                        this.npZ.mType = 0;
                        this.npZ.npK.mType = this.npZ.mType;
                        this.npZ.npK.fx(false);
                        this.npZ.npK.setTitle(this.npZ.getString(R.l.eyB));
                        if (aIA > 0.0d && aIH > 0) {
                            this.npZ.npK.zP(e.n(aIA / ((double) aIH)));
                        }
                        this.npZ.npK.nsD = this.npZ.nmd.nlX;
                        this.npZ.kCp.setText(spannableString2);
                        g.oUh.i(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.npZ.aIi()), Integer.valueOf(3)});
                    }
                };
                fVar2.rKS = new com.tencent.mm.plugin.wallet_core.ui.f.a(this) {
                    final /* synthetic */ SnsLuckyMoneyPrepareUI npZ;

                    public final void onClick(View view) {
                        int aIH = this.npZ.npJ.aIH();
                        double aIA = this.npZ.npK.aIA();
                        this.npZ.mType = 1;
                        this.npZ.npK.mType = this.npZ.mType;
                        this.npZ.npK.setTitle(this.npZ.getString(R.l.eyA));
                        this.npZ.npK.fx(true);
                        if (aIA > 0.0d && aIH > 0) {
                            this.npZ.npK.zP(e.n(aIA * ((double) aIH)));
                        }
                        this.npZ.npK.nsD = this.npZ.nmd.nlU;
                        this.npZ.kCp.setText(spannableString);
                        g.oUh.i(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.npZ.aIi()), Integer.valueOf(2)});
                    }
                };
                this.kCp.setMovementMethod(LinkMovementMethod.getInstance());
                this.kCp.setText(spannableString);
                this.kCp.setVisibility(0);
            } else {
                this.npJ.setVisibility(8);
            }
        } else if (this.mType == 1) {
            this.kCp.setText(this.nmd.nlV);
            this.kCp.setVisibility(0);
        } else if (this.mType == 0) {
            this.kCp.setText(this.nmd.nlW);
            this.kCp.setVisibility(0);
        }
        this.nkd.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsLuckyMoneyPrepareUI npZ;

            {
                this.npZ = r1;
            }

            public final void onClick(View view) {
                g.oUh.i(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.npZ.aIi()), Integer.valueOf(4)});
                if (this.npZ.npK.aIz() != 0) {
                    s.makeText(this.npZ.uSU.uTo, R.l.fdK, 0).show();
                    return;
                }
                long p;
                k acVar;
                int aIH = this.npZ.npJ.aIH();
                double aIA = this.npZ.npK.aIA();
                long j = 0;
                if (this.npZ.mType == 1) {
                    p = e.p(aIA);
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(356354, Integer.valueOf(aIH));
                } else {
                    p = e.p(((double) aIH) * aIA);
                    j = e.p(aIA);
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(356353, Integer.valueOf(aIH));
                }
                String input = this.npZ.npL.getInput();
                if (bg.mA(input)) {
                    input = this.npZ.getString(R.l.exm);
                }
                String stringExtra = this.npZ.getIntent().getStringExtra("key_username");
                if (!this.npZ.npV || bg.mA(stringExtra)) {
                    acVar = new ac(aIH, p, j, this.npZ.mType, input, n.aHX(), null, null, m.xL(), m.xN(), this.npZ.npS);
                } else {
                    acVar = new ac(aIH, p, j, this.npZ.mType, input, n.aHX(), stringExtra, n.eJ(stringExtra), m.xL(), m.xN(), this.npZ.npS);
                }
                this.npZ.b(acVar, false);
                if (this.npZ.ita != null) {
                    this.npZ.ita.show();
                    return;
                }
                this.npZ.ita = com.tencent.mm.wallet_core.ui.g.a(this.npZ.uSU.uTo, true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass16 nqf;

                    {
                        this.nqf = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        if (this.nqf.npZ.ita != null && this.nqf.npZ.ita.isShowing()) {
                            this.nqf.npZ.ita.hide();
                        }
                        if (this.nqf.npZ.uSU.ipu.getVisibility() == 8 || this.nqf.npZ.uSU.ipu.getVisibility() == 4) {
                            w.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
                            this.nqf.npZ.finish();
                        }
                        this.nqf.npZ.nqY.aHT();
                    }
                });
            }
        });
        this.kCk.setText(e.o(0.0d));
        this.npR.a(this.npJ);
        this.npR.a(this.npK);
        this.npR.a(this.npL);
        this.npR.g((TextView) findViewById(R.h.cfN));
        if (this.npV && this.mType == 1) {
            TextView textView2 = (TextView) findViewById(R.h.cfQ);
            textView2.setText(getString(R.l.exV, new Object[]{Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8))}));
            textView2.setVisibility(0);
        }
        this.iUX = new aj(new aj.a(this) {
            final /* synthetic */ SnsLuckyMoneyPrepareUI npZ;

            {
                this.npZ = r1;
            }

            public final boolean oQ() {
                double d;
                if (this.npZ.npK.aIz() == 3 || this.npZ.npJ.aIz() == 3) {
                    d = 0.0d;
                } else {
                    int aIH = this.npZ.npJ.aIH();
                    d = this.npZ.npK.aIA();
                    if (this.npZ.mType == 0) {
                        d *= (double) aIH;
                    }
                }
                if (d == 0.0d || d > this.npZ.nmd.nlU || this.npZ.npR.aIy()) {
                    this.npZ.nkd.setClickable(false);
                    this.npZ.nkd.setEnabled(false);
                } else {
                    this.npZ.nkd.setClickable(true);
                    this.npZ.nkd.setEnabled(true);
                }
                w.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d + ", hasErr=" + this.npZ.npR.aIy());
                this.npZ.iUX.bJq();
                return false;
            }
        }, false);
        if (this.liX != null) {
            this.liX.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ SnsLuckyMoneyPrepareUI npZ;

                {
                    this.npZ = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        this.npZ.Om();
                        this.npZ.aHf();
                    }
                    return false;
                }
            });
        }
        this.npK.mType = this.mType;
        if (this.npV && getIntent().getIntExtra("key_chatroom_num", 0) == 0) {
            this.npK.requestFocus();
        } else {
            this.npJ.requestFocus();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.npR.clear();
        this.iUX.bJq();
        if (this.ita != null && this.ita.isShowing()) {
            this.ita.dismiss();
        }
    }

    protected final int getLayoutId() {
        return R.i.dht;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.npN.getVisibility() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.npN.setVisibility(8);
        aIr();
        return true;
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        if (kVar instanceof ac) {
            if (this.ita != null && this.ita.isShowing()) {
                this.ita.hide();
            }
            if (i == 0 && i2 == 0) {
                ac acVar = (ac) kVar;
                this.npU = acVar.kAx;
                this.npT = acVar.njw;
                this.npW = acVar.nnM;
                PayInfo payInfo = new PayInfo();
                payInfo.fJH = acVar.nnL;
                payInfo.fRv = 37;
                payInfo.fRr = this.npX;
                com.tencent.mm.pluginsdk.wallet.e.a(this, payInfo, 1);
                return true;
            } else if (i2 == 401) {
                this.nkd.setEnabled(false);
                this.nkd.setClickable(false);
                this.iUX.v(5000, 5000);
                com.tencent.mm.ui.base.g.bl(this, str);
                return true;
            } else {
                com.tencent.mm.ui.base.g.bl(this, str);
                return true;
            }
        }
        if (kVar instanceof af) {
            if (i == 0 && i2 == 0) {
                if (this.npV) {
                    com.tencent.mm.ui.base.g.bl(this, getString(R.l.esl));
                    finish();
                } else {
                    aIs();
                    this.npO.postDelayed(new Runnable(this) {
                        final /* synthetic */ SnsLuckyMoneyPrepareUI npZ;

                        {
                            this.npZ = r1;
                        }

                        public final void run() {
                            Intent intent = new Intent();
                            intent.setClass(this.npZ.uSU.uTo, LuckyMoneyIndexUI.class);
                            intent.addFlags(67108864);
                            this.npZ.uSU.uTo.startActivity(intent);
                            this.npZ.finish();
                        }
                    }, 1000);
                }
                return true;
            } else if (i2 == 402) {
                com.tencent.mm.ui.base.g.a(this.uSU.uTo, str, "", getString(R.l.eyp), getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ SnsLuckyMoneyPrepareUI npZ;

                    {
                        this.npZ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.setClass(this.npZ.uSU.uTo, LuckyMoneyMyRecordUI.class);
                        intent.putExtra("key_type", 1);
                        this.npZ.startActivity(intent);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ SnsLuckyMoneyPrepareUI npZ;

                    {
                        this.npZ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        } else if (kVar instanceof v) {
            if (i == 0 && i2 == 0) {
                final v vVar = (v) kVar;
                com.tencent.mm.plugin.luckymoney.a.a.aHG();
                this.nmd = com.tencent.mm.plugin.luckymoney.a.a.aHH().aHS();
                w.d("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.nmd);
                if (this.mType == 1) {
                    this.npK.nsD = this.nmd.nlU;
                } else {
                    this.npK.nsD = this.nmd.nlX;
                }
                this.npK.nsE = this.nmd.nlZ;
                this.npJ.pa(this.nmd.nlT);
                if (vVar.nny && this.npV) {
                    TextView textView = (TextView) findViewById(R.h.cfO);
                    textView.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ SnsLuckyMoneyPrepareUI npZ;

                        {
                            this.npZ = r1;
                        }

                        public final void onClick(View view) {
                            g.oUh.i(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.npZ.aIi()), Integer.valueOf(9)});
                            Intent intent = new Intent();
                            intent.setClass(this.npZ.uSU.uTo, LuckyMoneyCanShareListUI.class);
                            this.npZ.startActivity(intent);
                        }
                    });
                    g.oUh.i(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aIi()), Integer.valueOf(8)});
                    textView.setVisibility(0);
                }
                if (bg.mA(vVar.kAO)) {
                    this.npQ.setVisibility(8);
                } else {
                    w.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + vVar.kAO);
                    this.npQ.setText(vVar.kAO);
                    if (!bg.mA(vVar.nnA)) {
                        this.npQ.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ SnsLuckyMoneyPrepareUI npZ;

                            public final void onClick(View view) {
                                e.m(this.npZ.uSU.uTo, vVar.nnA, false);
                            }
                        });
                    }
                    this.npQ.setVisibility(0);
                }
                com.tencent.mm.plugin.luckymoney.ui.g.c cVar = new com.tencent.mm.plugin.luckymoney.ui.g.c();
                cVar.textColor = getResources().getColor(R.e.aWj);
                com.tencent.mm.plugin.luckymoney.ui.g.a(this, this.npP, vVar.nnC, cVar);
            }
            return true;
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    g.oUh.i(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aIi()), Integer.valueOf(5)});
                    String stringExtra = getIntent().getStringExtra("key_username");
                    if (this.npV && !bg.mA(stringExtra)) {
                        com.tencent.mm.ui.base.g.bl(this, getString(R.l.esl));
                        Map q = bh.q(this.npW, "msg");
                        if (q != null) {
                            str = (String) q.get(".msg.appmsg.wcpayinfo.paymsgid");
                            if (com.tencent.mm.plugin.luckymoney.a.a.aHG().aHJ().zJ(str)) {
                                w.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
                                if (!n.z(this.npW, stringExtra, 1)) {
                                    w.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
                                    com.tencent.mm.plugin.luckymoney.a.a.aHG().aHJ().zK(str);
                                }
                            } else {
                                w.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
                            }
                            finish();
                            break;
                        }
                        w.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
                        finish();
                        return;
                    }
                    aIs();
                    new ae().postDelayed(new Runnable(this) {
                        final /* synthetic */ SnsLuckyMoneyPrepareUI npZ;

                        {
                            this.npZ = r1;
                        }

                        public final void run() {
                            this.npZ.npN.setVisibility(0);
                            Animation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                            scaleAnimation.setDuration(800);
                            scaleAnimation.setStartOffset(200);
                            scaleAnimation.setInterpolator(new BounceInterpolator());
                            this.npZ.findViewById(R.h.cfT).startAnimation(scaleAnimation);
                        }
                    }, 200);
                    this.kYj.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ SnsLuckyMoneyPrepareUI npZ;

                        {
                            this.npZ = r1;
                        }

                        public final void onClick(View view) {
                            g.oUh.i(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.npZ.aIi()), Integer.valueOf(6)});
                            n.a(this.npZ, this.npZ.mType, this.npZ.npU, false);
                            this.npZ.npN.postDelayed(new Runnable(this) {
                                final /* synthetic */ AnonymousClass8 nqb;

                                {
                                    this.nqb = r1;
                                }

                                public final void run() {
                                    this.nqb.npZ.npN.setVisibility(8);
                                    this.nqb.npZ.aIr();
                                }
                            }, 100);
                        }
                    });
                    ((ImageView) findViewById(R.h.cfM)).setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ SnsLuckyMoneyPrepareUI npZ;

                        {
                            this.npZ = r1;
                        }

                        public final void onClick(View view) {
                            this.npZ.npN.setVisibility(8);
                            this.npZ.aIr();
                        }
                    });
                    break;
                }
                break;
            case 2:
                if (i2 != -1 || intent == null) {
                    if (i2 == 0) {
                        Intent intent2 = new Intent();
                        intent2.setClass(this.uSU.uTo, LuckyMoneyMyRecordUI.class);
                        intent2.putExtra("key_type", 1);
                        startActivity(intent2);
                        break;
                    }
                }
                str = intent.getStringExtra("Select_Conv_User");
                g.oUh.i(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aIi()), Integer.valueOf(7), str});
                if (!bg.mA(str)) {
                    k(new af(str.replaceAll(",", "|"), this.npT, "v1.0"));
                    break;
                } else {
                    finish();
                    break;
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void z(View view, int i) {
        this.mKeyboard = (MyKeyboardWindow) findViewById(R.h.cHC);
        this.npM = findViewById(R.h.cHB);
        View findViewById = findViewById(R.h.bkI);
        EditText editText = (EditText) view.findViewById(R.h.cen);
        if (this.mKeyboard != null && editText != null && this.npM != null) {
            e.setNoSystemInputOnEditText(editText);
            editText.setOnFocusChangeListener(new AnonymousClass10(this, false, i, editText));
            editText.setOnClickListener(new AnonymousClass12(this, false, i, editText));
            TextView textView = (TextView) view.findViewById(R.h.cdq);
            if (textView != null) {
                textView.setOnClickListener(new AnonymousClass13(this, false, i, editText));
            }
            findViewById.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SnsLuckyMoneyPrepareUI npZ;

                {
                    this.npZ = r1;
                }

                public final void onClick(View view) {
                    this.npZ.Om();
                }
            });
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || this.npM == null || !this.npM.isShown()) {
            return super.onKeyUp(i, keyEvent);
        }
        Om();
        return true;
    }

    protected final void Om() {
        if (this.npM != null && this.npM.isShown()) {
            this.npM.setVisibility(8);
            this.npY.gC(false);
        }
    }

    public final void aIh() {
        double d;
        double d2;
        com.tencent.mm.plugin.luckymoney.a.a.aHG();
        this.nmd = com.tencent.mm.plugin.luckymoney.a.a.aHH().aHS();
        if (this.npK.aIz() == 3 || this.npJ.aIz() == 3) {
            d = 0.0d;
            d2 = 0.0d;
        } else {
            int aIH = this.npJ.aIH();
            d2 = this.npK.aIA();
            if (this.mType == 0) {
                d2 *= (double) aIH;
                d = this.npK.aIA();
            } else {
                d = aIH > 0 ? this.npK.aIA() / ((double) aIH) : 0.0d;
            }
        }
        if (this.npR.aIx()) {
            this.nkd.setClickable(false);
            this.nkd.setEnabled(false);
        } else {
            boolean z;
            if (d2 == 0.0d || d == 0.0d) {
                z = true;
            } else if (d2 > this.nmd.nlU && this.nmd.nlU > 0.0d) {
                this.npR.pk(getString(R.l.eyz, new Object[]{Math.round(this.nmd.nlU), bg.ap(this.nmd.nmc, "")}));
                z = true;
            } else if (d > 0.0d) {
                boolean z2;
                if (this.mType == 0) {
                    if (d > this.nmd.nlX && this.nmd.nlX > 0.0d) {
                        this.npR.pk(getString(R.l.eyd, new Object[]{Math.round(this.nmd.nlX), bg.ap(this.nmd.nmc, "")}));
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    if (d > this.nmd.nlY && this.nmd.nlY > 0.0d) {
                        this.npR.pk(getString(R.l.eyd, new Object[]{Math.round(this.nmd.nlY), bg.ap(this.nmd.nmc, "")}));
                        this.npJ.onError();
                        this.npK.onError();
                        z2 = true;
                    }
                    z2 = false;
                }
                if (!z2) {
                    if (this.mType == 0) {
                        if (d < this.nmd.nlZ) {
                            this.npR.pk(getString(R.l.eye, new Object[]{e.n(this.nmd.nlZ), bg.ap(this.nmd.nmc, "")}));
                            z = true;
                        }
                    } else if (d < 0.01d) {
                        this.npR.pk(getString(R.l.eye, new Object[]{"0.01", bg.ap(this.nmd.nmc, "")}));
                        this.npJ.onError();
                        this.npK.onError();
                        z = true;
                    }
                }
                z = z2;
            } else {
                z = false;
            }
            if (z) {
                this.nkd.setClickable(false);
                this.nkd.setEnabled(false);
            } else {
                this.nkd.setClickable(true);
                this.nkd.setEnabled(true);
            }
        }
        this.kCk.setText(e.o(d2));
    }

    private int aIi() {
        if (!this.npV) {
            return 3;
        }
        if (getIntent().getIntExtra("key_chatroom_num", 0) > 0) {
            return 2;
        }
        return 1;
    }
}
