package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.oi;
import com.tencent.mm.plugin.luckymoney.b.ac;
import com.tencent.mm.plugin.luckymoney.b.af;
import com.tencent.mm.plugin.luckymoney.b.c;
import com.tencent.mm.plugin.luckymoney.b.v;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.ui.f;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.n;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@a(19)
public class LuckyMoneyPrepareUI extends LuckyMoneyBaseUI implements f {
    private aj iUX = null;
    private Dialog ita = null;
    private boolean jMq = false;
    private int jZM;
    private TextView kCk = null;
    private TextView kCp;
    private Button kYj = null;
    protected MyKeyboardWindow mKeyboard;
    private int mType;
    private Button nkd = null;
    private c nmd;
    private LuckyMoneyNumInputView npJ = null;
    private LuckyMoneyMoneyInputView npK = null;
    private LuckyMoneyTextInputView npL = null;
    protected View npM;
    private View npN;
    private View npO;
    private ViewGroup npP;
    private TextView npQ;
    private a npR = new a();
    private int npS;
    private String npT;
    private int npU;
    private boolean npV;
    private String npW;
    private int npX;
    private MMScrollView ntY;
    private int ntZ = 1;
    private String nua = e.UH("CNY");
    private String nub = null;
    private RealnameGuideHelper nuc;
    private com.tencent.mm.sdk.b.c<oi> nud = new com.tencent.mm.sdk.b.c<oi>(this) {
        final /* synthetic */ LuckyMoneyPrepareUI nue;

        {
            this.nue = r2;
            this.usg = oi.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            final com.tencent.mm.plugin.wallet_core.model.a aVar = ((oi) bVar).fVw.fVx;
            if (aVar != null && aVar.bty()) {
                w.i("MicroMsg.LuckyMoneyPrepareUI", "show 261 alert item");
                this.nue.jMq = true;
                g.a(this.nue.uSU.uTo, aVar.fNG, "", aVar.nnQ, aVar.nnP, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass6 nug;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        w.i("MicroMsg.LuckyMoneyPrepareUI", "goto h5: %s", new Object[]{aVar.kAJ});
                        e.m(this.nug.nue.uSU.uTo, aVar.kAJ, false);
                        this.nug.nue.jMq = false;
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass6 nug;

                    {
                        this.nug = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.nug.nue.jMq = false;
                    }
                });
            }
            return false;
        }
    };

    class AnonymousClass17 implements OnFocusChangeListener {
        final /* synthetic */ boolean ipP = false;
        final /* synthetic */ EditText ipR;
        final /* synthetic */ int ipT;
        final /* synthetic */ LuckyMoneyPrepareUI nue;

        AnonymousClass17(LuckyMoneyPrepareUI luckyMoneyPrepareUI, boolean z, int i, EditText editText) {
            this.nue = luckyMoneyPrepareUI;
            this.ipT = i;
            this.ipR = editText;
        }

        public final void onFocusChange(final View view, boolean z) {
            if (!view.isFocused() || this.ipP) {
                new ae().postDelayed(new Runnable(this) {
                    final /* synthetic */ AnonymousClass17 nui;

                    {
                        this.nui = r1;
                    }

                    public final void run() {
                        this.nui.nue.Om();
                        ((InputMethodManager) this.nui.nue.uSU.uTo.getSystemService("input_method")).showSoftInput(this.nui.ipR, 0);
                    }
                }, 200);
                return;
            }
            ((InputMethodManager) this.nue.uSU.uTo.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            new ae().postDelayed(new Runnable(this) {
                final /* synthetic */ AnonymousClass17 nui;

                public final void run() {
                    if (!this.nui.nue.npM.isShown() && view.isShown()) {
                        this.nui.nue.npM.setVisibility(0);
                    }
                    this.nui.nue.mKeyboard.setXMode(this.nui.ipT);
                    this.nui.nue.mKeyboard.setInputEditText((EditText) view);
                    ((InputMethodManager) this.nui.nue.uSU.uTo.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }, 300);
        }
    }

    class AnonymousClass18 implements View.OnClickListener {
        final /* synthetic */ boolean ipP = false;
        final /* synthetic */ EditText ipR;
        final /* synthetic */ int ipT;
        final /* synthetic */ LuckyMoneyPrepareUI nue;

        AnonymousClass18(LuckyMoneyPrepareUI luckyMoneyPrepareUI, boolean z, int i, EditText editText) {
            this.nue = luckyMoneyPrepareUI;
            this.ipT = i;
            this.ipR = editText;
        }

        public final void onClick(View view) {
            if (!this.nue.npM.isShown() && !this.ipP) {
                this.nue.npM.setVisibility(0);
                this.nue.mKeyboard.setInputEditText((EditText) view);
                this.nue.mKeyboard.setXMode(this.ipT);
            } else if (this.ipP) {
                this.nue.npM.setVisibility(8);
                ((InputMethodManager) this.nue.uSU.uTo.getSystemService("input_method")).showSoftInput(this.ipR, 0);
            }
        }
    }

    class AnonymousClass19 implements View.OnClickListener {
        final /* synthetic */ boolean ipP = false;
        final /* synthetic */ EditText ipR;
        final /* synthetic */ View ipS;
        final /* synthetic */ int ipT;
        final /* synthetic */ LuckyMoneyPrepareUI nue;

        AnonymousClass19(LuckyMoneyPrepareUI luckyMoneyPrepareUI, boolean z, EditText editText, View view, int i) {
            this.nue = luckyMoneyPrepareUI;
            this.ipR = editText;
            this.ipS = view;
            this.ipT = i;
        }

        public final void onClick(View view) {
            if (!this.nue.npM.isShown() || this.ipP) {
                if (!this.nue.npM.isShown() && !this.ipP) {
                    ((InputMethodManager) this.nue.uSU.uTo.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
                    new ae().postDelayed(new Runnable(this) {
                        final /* synthetic */ AnonymousClass19 nuj;

                        {
                            this.nuj = r1;
                        }

                        public final void run() {
                            this.nuj.nue.npM.setVisibility(0);
                            this.nuj.ipS.requestFocus();
                            if (this.nuj.nue.mKeyboard != null) {
                                this.nuj.nue.mKeyboard.setInputEditText(this.nuj.ipR);
                            }
                            this.nuj.nue.mKeyboard.setXMode(this.nuj.ipT);
                        }
                    }, 200);
                } else if (this.ipP) {
                    this.nue.npM.setVisibility(8);
                    ((InputMethodManager) this.nue.uSU.uTo.getSystemService("input_method")).showSoftInput(this.ipR, 0);
                }
            } else if (this.nue.mKeyboard != null) {
                this.nue.mKeyboard.setInputEditText(this.ipR);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("key_type", 1);
        this.npS = getIntent().getIntExtra("key_way", 3);
        this.jZM = getIntent().getIntExtra("key_from", 0);
        this.npV = this.jZM == 1;
        this.npX = getIntent().getIntExtra("pay_channel", -1);
        b(new v("v1.0", (byte) 0), true);
        com.tencent.mm.plugin.luckymoney.a.a.aHG();
        this.nmd = com.tencent.mm.plugin.luckymoney.a.a.aHH().aHS();
        w.i("MicroMsg.LuckyMoneyPrepareUI", "mInWay:" + this.npS + "mChannel:" + this.npX);
        w.i("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.npV + ", config " + this.nmd);
        KC();
        com.tencent.mm.sdk.b.a.urY.a(this.nud);
        com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aIi()), Integer.valueOf(1)});
    }

    protected void onResume() {
        super.onResume();
        hn(1970);
    }

    protected void onStop() {
        super.onStop();
        ho(1970);
    }

    protected final void KC() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ LuckyMoneyPrepareUI nue;

            {
                this.nue = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nue.finish();
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
        this.ntY = (MMScrollView) findViewById(R.h.cgr);
        this.npQ = (TextView) findViewById(R.h.cfP);
        if (this.mType == 1) {
            zi(R.l.exG);
            this.npK.setTitle(getString(R.l.eyA));
            this.npK.fx(true);
        } else {
            zi(R.l.exU);
            this.npK.setTitle(getString(R.l.eyB));
            this.npK.fx(false);
        }
        this.npK.nsC = this;
        LuckyMoneyMoneyInputView luckyMoneyMoneyInputView = this.npK;
        luckyMoneyMoneyInputView.nsz.setHint(getString(R.l.exQ));
        this.npJ.nsC = this;
        LuckyMoneyNumInputView luckyMoneyNumInputView = this.npJ;
        luckyMoneyNumInputView.ntK.setHint(getString(R.l.exW));
        this.npL.nsC = this;
        final EditText editText = (EditText) this.npK.findViewById(R.h.cen);
        final EditText editText2 = (EditText) this.npJ.findViewById(R.h.cen);
        e.setNoSystemInputOnEditText(editText);
        ((InputMethodManager) this.uSU.uTo.getSystemService("input_method")).showSoftInput(editText, 0);
        editText.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ LuckyMoneyPrepareUI nue;

            {
                this.nue = r1;
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, "0");
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 3) {
                    editable.delete(indexOf + 3, length);
                } else if (indexOf > 6) {
                    editable.delete(6, indexOf);
                } else if (indexOf == -1 && length > 6) {
                    editable.delete(6, length);
                }
            }
        });
        editText.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ LuckyMoneyPrepareUI nue;

            public final void onClick(View view) {
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                this.nue.z(this.nue.npK, 2);
                this.nue.z(this.nue.npJ, 0);
                this.nue.mKeyboard.setXMode(2);
                this.nue.mKeyboard.setInputEditText((EditText) view);
                this.nue.npM.setVisibility(0);
            }
        });
        editText.requestFocus();
        TextView textView = (TextView) this.npK.findViewById(R.h.cdq);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ LuckyMoneyPrepareUI nue;

                public final void onClick(View view) {
                    editText.setOnClickListener(null);
                    editText2.setOnClickListener(null);
                    this.nue.z(this.nue.npK, 2);
                    this.nue.z(this.nue.npJ, 0);
                    this.nue.mKeyboard.setXMode(2);
                    this.nue.mKeyboard.setInputEditText(editText);
                    this.nue.npM.setVisibility(0);
                }
            });
        }
        e.setNoSystemInputOnEditText(editText2);
        ((InputMethodManager) this.uSU.uTo.getSystemService("input_method")).showSoftInput(editText2, 0);
        editText2.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ LuckyMoneyPrepareUI nue;

            public final void onClick(View view) {
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                this.nue.z(this.nue.npK, 2);
                this.nue.z(this.nue.npJ, 0);
                this.nue.mKeyboard.setXMode(0);
                this.nue.mKeyboard.setInputEditText((EditText) view);
                this.nue.npM.setVisibility(0);
            }
        });
        ((MMEditText) this.npL.findViewById(R.h.cgs)).setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ LuckyMoneyPrepareUI nue;

            public final void onFocusChange(View view, boolean z) {
                editText.setOnClickListener(null);
                editText2.setOnClickListener(null);
                this.nue.z(this.nue.npK, 2);
                this.nue.z(this.nue.npJ, 0);
            }
        });
        if (this.nmd != null) {
            if (this.mType == 1) {
                this.npK.nsD = this.nmd.nlU;
            } else {
                this.npK.nsD = this.nmd.nlX;
            }
            this.npK.nsE = this.nmd.nlZ;
            if (this.nmd.kAM != 1) {
                cK(this.nmd.nmc, this.nmd.nmb);
            }
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
        if (this.npV || this.jZM == 2) {
            zi(R.l.eyy);
            int intExtra = getIntent().getIntExtra("key_chatroom_num", 0);
            if (this.npV && intExtra == 0) {
                w.i("MicroMsg.LuckyMoneyPrepareUI", "single hb");
                this.npJ.setVisibility(8);
            } else {
                String string = getString(R.l.exw);
                String string2 = getString(R.l.exH);
                String string3 = getString(R.l.exs);
                String string4 = getString(R.l.exI);
                if (this.npV && intExtra > 0) {
                    w.i("MicroMsg.LuckyMoneyPrepareUI", "group hb,%d people", new Object[]{Integer.valueOf(intExtra)});
                    String string5 = getString(R.l.exK);
                    string = getString(R.l.exJ);
                    TextView textView2 = (TextView) findViewById(R.h.cfQ);
                    textView2.setText(getString(R.l.exV, new Object[]{Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8))}));
                    textView2.setVisibility(0);
                    string3 = string;
                    string = string5;
                } else if (this.jZM == 2) {
                    w.i("MicroMsg.LuckyMoneyPrepareUI", "f2f hb");
                    this.npL.setVisibility(8);
                }
                f fVar = new f(this);
                final CharSequence spannableString = new SpannableString(string + string2);
                spannableString.setSpan(fVar, string.length(), string.length() + string2.length(), 33);
                final SpannableString spannableString2 = new SpannableString(string3 + string4);
                f fVar2 = new f(this);
                spannableString2.setSpan(fVar2, string3.length(), string3.length() + string4.length(), 33);
                fVar.rKS = new f.a(this) {
                    final /* synthetic */ LuckyMoneyPrepareUI nue;

                    public final void onClick(View view) {
                        int aIH = this.nue.npJ.aIH();
                        double aIA = this.nue.npK.aIA();
                        this.nue.mType = 0;
                        this.nue.npK.mType = this.nue.mType;
                        this.nue.npK.fx(false);
                        this.nue.npK.setTitle(this.nue.getString(R.l.eyB));
                        if (aIA > 0.0d && aIH > 0) {
                            this.nue.npK.zP(e.n(aIA / ((double) aIH)));
                        }
                        this.nue.npK.nsD = this.nue.nmd.nlX;
                        this.nue.kCp.setText(spannableString2);
                        com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.nue.aIi()), Integer.valueOf(3)});
                    }
                };
                fVar2.rKS = new f.a(this) {
                    final /* synthetic */ LuckyMoneyPrepareUI nue;

                    public final void onClick(View view) {
                        int aIH = this.nue.npJ.aIH();
                        double aIA = this.nue.npK.aIA();
                        this.nue.mType = 1;
                        this.nue.npK.mType = this.nue.mType;
                        this.nue.npK.nsD = this.nue.nmd.nlU;
                        this.nue.npK.setTitle(this.nue.getString(R.l.eyA));
                        this.nue.npK.fx(true);
                        if (aIA > 0.0d && aIH > 0) {
                            this.nue.npK.zP(e.n(aIA * ((double) aIH)));
                        }
                        this.nue.kCp.setText(spannableString);
                        com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.nue.aIi()), Integer.valueOf(2)});
                    }
                };
                this.kCp.setMovementMethod(LinkMovementMethod.getInstance());
                this.kCp.setText(spannableString);
                this.kCp.setVisibility(0);
            }
        } else if (this.mType == 1) {
            this.kCp.setText(this.nmd.nlV);
            this.kCp.setVisibility(0);
        } else if (this.mType == 0) {
            this.kCp.setText(this.nmd.nlW);
            this.kCp.setVisibility(0);
        }
        this.nkd.setOnClickListener(new n(this) {
            final /* synthetic */ LuckyMoneyPrepareUI nue;

            {
                this.nue = r1;
            }

            public final void aII() {
                com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.nue.aIi()), Integer.valueOf(4)});
                if (this.nue.npK.aIz() != 0) {
                    s.makeText(this.nue.uSU.uTo, R.l.fdK, 0).show();
                    return;
                }
                long p;
                int aIH = this.nue.npJ.aIH();
                double aIA = this.nue.npK.aIA();
                long j = 0;
                if (this.nue.mType == 1) {
                    p = e.p(aIA);
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(356354, Integer.valueOf(aIH));
                } else {
                    p = e.p(((double) aIH) * aIA);
                    j = e.p(aIA);
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(356353, Integer.valueOf(aIH));
                }
                String input = this.nue.npL.getInput();
                if (bg.mA(input)) {
                    input = bg.mA(this.nue.nub) ? this.nue.getString(R.l.exm) : this.nue.nub;
                }
                if (this.nue.jZM == 2) {
                    this.nue.b(new com.tencent.mm.plugin.luckymoney.f2f.a.c(aIH, (int) p, this.nue.mType, (int) j), false);
                } else {
                    String stringExtra = this.nue.getIntent().getStringExtra("key_username");
                    if (this.nue.ntZ == 1) {
                        k acVar;
                        w.i("MicroMsg.LuckyMoneyPrepareUI", "currency is RMB");
                        if (!this.nue.npV || bg.mA(stringExtra)) {
                            acVar = new ac(aIH, p, j, this.nue.mType, input, com.tencent.mm.plugin.luckymoney.b.n.aHX(), null, null, m.xL(), m.xN(), this.nue.npS);
                        } else {
                            acVar = new ac(aIH, p, j, this.nue.mType, input, com.tencent.mm.plugin.luckymoney.b.n.aHX(), stringExtra, com.tencent.mm.plugin.luckymoney.b.n.eJ(stringExtra), m.xL(), m.xN(), this.nue.npS);
                        }
                        this.nue.b(acVar, false);
                    } else {
                        k wVar;
                        w.i("MicroMsg.LuckyMoneyPrepareUI", "currency=" + this.nue.ntZ);
                        this.nue.hn(1645);
                        if (!this.nue.npV || bg.mA(stringExtra)) {
                            wVar = new com.tencent.mm.plugin.luckymoney.b.w(aIH, p, j, this.nue.mType, input, null, com.tencent.mm.plugin.luckymoney.b.n.aHX(), m.xL(), this.nue.ntZ);
                        } else {
                            wVar = new com.tencent.mm.plugin.luckymoney.b.w(aIH, p, j, this.nue.mType, input, stringExtra, com.tencent.mm.plugin.luckymoney.b.n.aHX(), m.xL(), this.nue.ntZ);
                        }
                        this.nue.b(wVar, false);
                    }
                }
                if (this.nue.ita != null) {
                    this.nue.ita.show();
                } else {
                    this.nue.ita = com.tencent.mm.wallet_core.ui.g.a(this.nue.uSU.uTo, true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass22 nuk;

                        {
                            this.nuk = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            if (this.nuk.nue.ita != null && this.nuk.nue.ita.isShowing()) {
                                this.nuk.nue.ita.dismiss();
                            }
                            if (this.nuk.nue.uSU.ipu.getVisibility() == 8 || this.nuk.nue.uSU.ipu.getVisibility() == 4) {
                                w.i("MicroMsg.LuckyMoneyPrepareUI", "usr cancel, & visibility not visiable, so finish");
                                this.nuk.nue.finish();
                            }
                            this.nuk.nue.nqY.aHT();
                        }
                    });
                }
            }
        });
        this.npR.a(this.npJ);
        this.npR.a(this.npK);
        this.npR.a(this.npL);
        this.npR.g((TextView) findViewById(R.h.cfN));
        this.iUX = new aj(new aj.a(this) {
            final /* synthetic */ LuckyMoneyPrepareUI nue;

            {
                this.nue = r1;
            }

            public final boolean oQ() {
                double d;
                if (this.nue.npK.aIz() == 3 || this.nue.npJ.aIz() == 3) {
                    d = 0.0d;
                } else {
                    int aIH = this.nue.npJ.aIH();
                    d = this.nue.npK.aIA();
                    if (this.nue.mType == 0) {
                        d *= (double) aIH;
                    }
                }
                if (d == 0.0d || d > this.nue.nmd.nlU || this.nue.npR.aIy()) {
                    this.nue.nkd.setClickable(false);
                    this.nue.nkd.setEnabled(false);
                } else {
                    this.nue.nkd.setClickable(true);
                    this.nue.nkd.setEnabled(true);
                }
                w.i("MicroMsg.LuckyMoneyPrepareUI", "onTimeExpired & check: amount=" + d + ", hasErr=" + this.nue.npR.aIy());
                this.nue.iUX.bJq();
                return false;
            }
        }, false);
        if (this.ntY != null) {
            this.ntY.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ LuckyMoneyPrepareUI nue;

                {
                    this.nue = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        this.nue.Om();
                        this.nue.aHf();
                    }
                    return false;
                }
            });
        }
        this.npK.mType = this.mType;
        a(0, R.g.bgJ, new OnMenuItemClickListener(this) {
            final /* synthetic */ LuckyMoneyPrepareUI nue;

            {
                this.nue = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.nue.ntZ == 1) {
                    e.m(this.nue.uSU.uTo, "https://kf.qq.com/touch/scene_product.html?scene_id=kf7", false);
                } else {
                    e.m(this.nue.uSU.uTo, "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
                }
                return true;
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        this.npR.clear();
        this.iUX.bJq();
        if (this.ita != null && this.ita.isShowing()) {
            this.ita.dismiss();
        }
        com.tencent.mm.sdk.b.a.urY.c(this.nud);
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
        w.i("MicroMsg.LuckyMoneyPrepareUI", "errType:" + i + " errCode:" + i2 + " errMsg:" + str + " scenetype:" + kVar.getType());
        if (kVar instanceof ac) {
            if (this.ita != null && this.ita.isShowing()) {
                this.ita.dismiss();
            }
            if (this.jMq) {
                w.i("MicroMsg.LuckyMoneyPrepareUI", "has show alert return");
                return true;
            } else if (i == 0 && i2 == 0) {
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
                g.bl(this, str);
                return true;
            } else {
                if (TextUtils.isEmpty(str)) {
                    str = getString(R.l.fkA);
                }
                g.a(this, str, null, false, new OnClickListener(this) {
                    final /* synthetic */ LuckyMoneyPrepareUI nue;

                    {
                        this.nue = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                return true;
            }
        }
        if (kVar instanceof af) {
            if (i == 0 && i2 == 0) {
                if (this.npV) {
                    com.tencent.mm.ui.snackbar.a.e(this, getString(R.l.esl));
                    com.tencent.mm.sdk.platformtools.af.f(new Runnable(this) {
                        final /* synthetic */ LuckyMoneyPrepareUI nue;

                        {
                            this.nue = r1;
                        }

                        public final void run() {
                            this.nue.finish();
                        }
                    }, 1800);
                } else {
                    aIs();
                    this.npO.setVisibility(0);
                    this.npO.postDelayed(new Runnable(this) {
                        final /* synthetic */ LuckyMoneyPrepareUI nue;

                        {
                            this.nue = r1;
                        }

                        public final void run() {
                            Intent intent = new Intent();
                            intent.setClass(this.nue.uSU.uTo, LuckyMoneyIndexUI.class);
                            intent.addFlags(67108864);
                            this.nue.uSU.uTo.startActivity(intent);
                            this.nue.finish();
                        }
                    }, 1000);
                }
                return true;
            } else if (i2 == 402) {
                g.a(this.uSU.uTo, str, "", getString(R.l.eyp), getString(R.l.dGs), new OnClickListener(this) {
                    final /* synthetic */ LuckyMoneyPrepareUI nue;

                    {
                        this.nue = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        intent.setClass(this.nue.uSU.uTo, LuckyMoneyMyRecordUI.class);
                        intent.putExtra("key_type", 1);
                        this.nue.startActivity(intent);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ LuckyMoneyPrepareUI nue;

                    {
                        this.nue = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        } else if (kVar instanceof v) {
            w.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig resp,errType=" + i + ";errCode=" + i2 + ";errMsg=" + str);
            if (i == 0 && i2 == 0) {
                final v vVar = (v) kVar;
                com.tencent.mm.plugin.luckymoney.a.a.aHG();
                this.nmd = com.tencent.mm.plugin.luckymoney.a.a.aHH().aHS();
                w.i("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.nmd);
                if (this.mType == 1) {
                    this.npK.nsD = this.nmd.nlU;
                } else {
                    this.npK.nsD = this.nmd.nlX;
                }
                this.npK.nsE = this.nmd.nlZ;
                this.npJ.pa(this.nmd.nlT);
                this.nua = vVar.nmb;
                this.ntZ = vVar.kAM;
                this.nub = vVar.nmh;
                if (!(bg.mA(this.nub) || this.npL == null)) {
                    com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                        final /* synthetic */ LuckyMoneyPrepareUI nue;

                        {
                            this.nue = r1;
                        }

                        public final void run() {
                            this.nue.npL.zR(this.nue.nub);
                        }
                    });
                }
                if (vVar.nny && this.npV) {
                    TextView textView = (TextView) findViewById(R.h.cfO);
                    textView.setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ LuckyMoneyPrepareUI nue;

                        {
                            this.nue = r1;
                        }

                        public final void onClick(View view) {
                            com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.nue.aIi()), Integer.valueOf(9)});
                            Intent intent = new Intent();
                            intent.setClass(this.nue.uSU.uTo, LuckyMoneyCanShareListUI.class);
                            this.nue.startActivity(intent);
                        }
                    });
                    com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aIi()), Integer.valueOf(8)});
                    textView.setVisibility(0);
                }
                if (bg.mA(vVar.kAO)) {
                    this.npQ.setVisibility(8);
                } else {
                    w.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + vVar.kAO);
                    this.npQ.setText(vVar.kAO);
                    if (!bg.mA(vVar.nnA)) {
                        this.npQ.setOnClickListener(new View.OnClickListener(this) {
                            final /* synthetic */ LuckyMoneyPrepareUI nue;

                            public final void onClick(View view) {
                                e.m(this.nue.uSU.uTo, vVar.nnA, false);
                            }
                        });
                    }
                    this.npQ.setVisibility(0);
                }
                g.c cVar = new g.c();
                if (vVar.nnC == null || bg.mA(vVar.nnC.content)) {
                    cVar.textColor = getResources().getColor(R.e.aUo);
                } else {
                    cVar.textColor = getResources().getColor(R.e.aWj);
                }
                g.a(this, this.npP, vVar.nnC, cVar);
                cK(vVar.nmc, vVar.nmb);
                b(0.0d, this.nua);
            }
            return true;
        } else if (kVar instanceof com.tencent.mm.plugin.luckymoney.b.w) {
            ho(1645);
            if (this.ita != null && this.ita.isShowing()) {
                this.ita.hide();
            }
            if (i == 0 && i2 == 0) {
                String str2 = ((com.tencent.mm.plugin.luckymoney.b.w) kVar).kBb;
                if (bg.mA(str2)) {
                    w.e("MicroMsg.LuckyMoneyPrepareUI", "payUrl is null");
                } else {
                    w.i("MicroMsg.LuckyMoneyPrepareUI", "payUrl is not null");
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    d.b(this, "webview", ".ui.tools.WebViewUI", intent, 3);
                }
                return true;
            }
        } else if (kVar instanceof com.tencent.mm.plugin.luckymoney.f2f.a.c) {
            if (i == 0 && i2 == 0) {
                if (this.ita != null) {
                    this.ita.dismiss();
                }
                payInfo = new PayInfo();
                payInfo.fJH = ((com.tencent.mm.plugin.luckymoney.f2f.a.c) kVar).fJH;
                payInfo.fRv = 37;
                com.tencent.mm.pluginsdk.wallet.e.a(this, payInfo, 4);
            } else {
                if (!bg.mA(str)) {
                    g.b(this, str, getString(R.l.dIO), true);
                }
                this.ita.dismiss();
            }
            return true;
        }
        return false;
    }

    private void cK(String str, String str2) {
        w.i("MicroMsg.LuckyMoneyPrepareUI", "initH5LuckyMoneyView  currencyWording=" + str);
        TextView textView = (TextView) findViewById(R.h.cdq);
        if (bg.mA(str)) {
            textView.setText(getString(R.l.cdq));
        } else {
            textView.setText(str);
        }
        if (bg.mA(str2)) {
            b(0.0d, e.UH("CNY"));
        } else {
            b(0.0d, str2);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str;
        switch (i) {
            case 1:
                if (intent != null && intent.hasExtra("key_realname_guide_helper")) {
                    this.nuc = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
                }
                if (i2 == -1) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aIi()), Integer.valueOf(5)});
                    String stringExtra = getIntent().getStringExtra("key_username");
                    if (this.npV && !bg.mA(stringExtra)) {
                        g.bl(this, getString(R.l.esl));
                        Map q = bh.q(this.npW, "msg");
                        if (q != null) {
                            str = (String) q.get(".msg.appmsg.wcpayinfo.paymsgid");
                            if (com.tencent.mm.plugin.luckymoney.a.a.aHG().aHJ().zJ(str)) {
                                w.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
                                if (!com.tencent.mm.plugin.luckymoney.b.n.z(this.npW, stringExtra, 1)) {
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
                    View findViewById = findViewById(R.h.cfT);
                    this.npN.setVisibility(0);
                    com.tencent.mm.plugin.luckymoney.b.n.a(findViewById, null);
                    this.kYj.setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ LuckyMoneyPrepareUI nue;

                        {
                            this.nue = r1;
                        }

                        public final void onClick(View view) {
                            com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.nue.aIi()), Integer.valueOf(6)});
                            com.tencent.mm.plugin.luckymoney.b.n.a(this.nue, this.nue.mType, this.nue.npU, true);
                            this.nue.npN.postDelayed(new Runnable(this) {
                                final /* synthetic */ AnonymousClass15 nuh;

                                {
                                    this.nuh = r1;
                                }

                                public final void run() {
                                    this.nuh.nue.npN.setVisibility(8);
                                    this.nuh.nue.aIr();
                                }
                            }, 100);
                        }
                    });
                    ((ImageView) findViewById(R.h.cfM)).setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ LuckyMoneyPrepareUI nue;

                        {
                            this.nue = r1;
                        }

                        public final void onClick(View view) {
                            this.nue.npN.setVisibility(8);
                            this.nue.aIr();
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
                com.tencent.mm.plugin.report.service.g.oUh.i(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aIi()), Integer.valueOf(7), str});
                if (!bg.mA(str)) {
                    k(new af(str.replaceAll(",", "|"), this.npT, "v1.0"));
                    break;
                } else {
                    finish();
                    break;
                }
                break;
            case 3:
                if (intent != null && intent.hasExtra("result_data")) {
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra == null) {
                        w.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY bundle is null");
                        break;
                    }
                    int i3 = bg.getInt(bundleExtra.getString("payState", "2"), 0);
                    w.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY payState is " + i3 + ";STATE_H5_PAY_SUCC=0");
                    if (i3 == 0) {
                        finish();
                        break;
                    }
                }
                break;
            case 4:
                finish();
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
            editText.setOnFocusChangeListener(new AnonymousClass17(this, false, i, editText));
            editText.setOnClickListener(new AnonymousClass18(this, false, i, editText));
            TextView textView = (TextView) view.findViewById(R.h.cdq);
            if (textView != null) {
                textView.setOnClickListener(new AnonymousClass19(this, false, editText, view, i));
            }
            findViewById.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ LuckyMoneyPrepareUI nue;

                {
                    this.nue = r1;
                }

                public final void onClick(View view) {
                    this.nue.Om();
                }
            });
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || this.npM == null || !this.npM.isShown()) {
            return super.onKeyUp(i, keyEvent);
        }
        this.npM.setVisibility(8);
        return true;
    }

    protected final void Om() {
        if (this.npM != null && this.npM.isShown()) {
            this.npM.setVisibility(8);
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
            w.i("MicroMsg.LuckyMoneyPrepareUI", "has error");
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
                w.i("MicroMsg.LuckyMoneyPrepareUI", "perAmount " + d);
                if (this.mType == 0) {
                    if (d > this.nmd.nlX && this.nmd.nlX > 0.0d) {
                        this.npR.pk(getString(R.l.eyd, new Object[]{Math.round(this.nmd.nlX), bg.ap(this.nmd.nmc, "")}));
                        z = true;
                    }
                    z = false;
                } else {
                    if (d > this.nmd.nlY && this.nmd.nlY > 0.0d) {
                        this.npR.pk(getString(R.l.eyd, new Object[]{Math.round(this.nmd.nlY), bg.ap(this.nmd.nmc, "")}));
                        this.npJ.onError();
                        this.npK.onError();
                        z = true;
                    }
                    z = false;
                }
                w.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + z + " for max value");
                if (!z) {
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
                w.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + z + " for min value");
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
        b(d2, this.nua);
    }

    private void b(double d, String str) {
        if (bg.mA(str)) {
            this.kCk.setText(e.o(d));
        } else {
            this.kCk.setText(str + e.n(d));
        }
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

    public void finish() {
        if (this.nuc != null) {
            Intent intent = new Intent();
            intent.putExtra("key_realname_guide_helper", this.nuc);
            d.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", intent);
        }
        super.finish();
    }
}
