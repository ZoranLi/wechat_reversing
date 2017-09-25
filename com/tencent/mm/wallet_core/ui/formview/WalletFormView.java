package com.tencent.mm.wallet_core.ui.formview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.a.b;
import com.tencent.wcdb.FileUtils;
import com.tenpay.android.wechat.TenpaySecureEditText;
import junit.framework.Assert;

public final class WalletFormView extends LinearLayout implements OnFocusChangeListener {
    public TextView jhl;
    private int oNA;
    private String oNB;
    private int oNC;
    private String oND;
    private int oNE;
    private int oNF;
    private int oNG;
    private String oNH;
    private int oNI;
    private String oNJ;
    private int oNK;
    private int oNL;
    private String oNM;
    public int oNN;
    private int oNO;
    private int oNP;
    private boolean oNQ;
    private boolean oNR;
    private boolean oNS;
    private int oNT;
    private int oNU;
    private int oNV;
    public TextView oNr;
    public WalletIconImageView oNt;
    public TextView oNu;
    private OnFocusChangeListener oNw;
    private OnClickListener oNx;
    public TenpaySecureEditText wFX;
    public a wFY;
    public com.tencent.mm.wallet_core.ui.formview.a.a wFZ;
    public b wGa;
    private int wGb;
    public int wGc;
    private int wGd;
    private int wGe;

    public interface a {
        void gA(boolean z);
    }

    public WalletFormView(Context context, AttributeSet attributeSet, int i) {
        boolean z = false;
        super(context, attributeSet);
        this.jhl = null;
        this.oNr = null;
        this.wFX = null;
        this.oNt = null;
        this.oNu = null;
        this.wFY = null;
        this.oNw = null;
        this.oNx = null;
        this.wFZ = null;
        this.wGa = null;
        this.oNA = -1;
        this.wGb = this.oNA;
        this.wGc = 100;
        this.oNB = "";
        this.oNC = 0;
        this.oND = "";
        this.oNE = 8;
        this.oNF = -1;
        this.oNG = 4;
        this.oNH = "";
        this.oNI = 8;
        this.oNJ = "";
        this.oNK = 19;
        this.oNL = R.e.aVo;
        this.oNM = "";
        this.wGd = 0;
        this.oNN = Integer.MAX_VALUE;
        this.oNO = 1;
        this.oNP = R.g.bhc;
        this.oNQ = true;
        this.oNR = false;
        this.oNS = true;
        this.oNT = 1;
        this.oNU = 5;
        this.oNV = R.e.aUD;
        this.wGe = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.frN, i, 0);
        this.oNA = obtainStyledAttributes.getResourceId(R.n.fse, this.oNA);
        int resourceId = obtainStyledAttributes.getResourceId(R.n.fsk, 0);
        if (resourceId != 0) {
            this.oNB = context.getString(resourceId);
        }
        this.oNF = obtainStyledAttributes.getResourceId(R.n.fsc, this.oNF);
        resourceId = obtainStyledAttributes.getResourceId(R.n.fsi, 0);
        if (resourceId != 0) {
            this.oNH = context.getString(resourceId);
        }
        this.oNG = obtainStyledAttributes.getInteger(R.n.fsd, this.oNG);
        this.oNC = obtainStyledAttributes.getInteger(R.n.fsl, this.oNC);
        this.oNI = obtainStyledAttributes.getInteger(R.n.fsj, this.oNI);
        this.oNE = obtainStyledAttributes.getInteger(R.n.fsh, this.oNE);
        resourceId = obtainStyledAttributes.getResourceId(R.n.fsg, 0);
        if (resourceId != 0) {
            this.oND = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(R.n.frV, 0);
        if (resourceId != 0) {
            this.oNJ = context.getString(resourceId);
        }
        this.oNK = obtainStyledAttributes.getInteger(R.n.frU, this.oNK);
        this.oNL = obtainStyledAttributes.getColor(R.n.fsa, this.oNL);
        resourceId = obtainStyledAttributes.getResourceId(R.n.frZ, 0);
        if (resourceId != 0) {
            this.oNM = context.getString(resourceId);
        }
        this.wGd = obtainStyledAttributes.getInt(R.n.frT, this.wGd);
        this.oNN = obtainStyledAttributes.getInteger(R.n.frX, this.oNN);
        this.oNO = obtainStyledAttributes.getInteger(R.n.frY, this.oNO);
        this.oNP = obtainStyledAttributes.getResourceId(R.n.frQ, this.oNP);
        this.oNQ = obtainStyledAttributes.getBoolean(R.n.frS, this.oNQ);
        this.oNR = obtainStyledAttributes.getBoolean(R.n.frR, this.oNR);
        this.oNS = obtainStyledAttributes.getBoolean(R.n.frS, this.oNS);
        this.oNT = obtainStyledAttributes.getInteger(R.n.frP, this.oNT);
        this.oNU = obtainStyledAttributes.getInteger(R.n.frO, this.oNU);
        this.wGc = obtainStyledAttributes.getInteger(R.n.fsb, this.wGc);
        this.oNV = obtainStyledAttributes.getInteger(R.n.frW, this.oNV);
        this.wGb = obtainStyledAttributes.getResourceId(R.n.fsf, this.wGb);
        this.wGe = obtainStyledAttributes.getInteger(R.n.fsm, 0);
        obtainStyledAttributes.recycle();
        if (this.oNA > 0) {
            z = true;
        }
        Assert.assertTrue(z);
        setOrientation(1);
        if (bg.mA(this.oNB) || this.oNB.length() <= 6) {
            inflate(context, this.oNA, this);
        } else {
            inflate(context, this.wGb, this);
        }
        this.jhl = (TextView) findViewById(R.h.cRK);
        this.oNr = (TextView) findViewById(R.h.cRy);
        this.wFX = (TenpaySecureEditText) findViewById(R.h.cQh);
        this.oNt = (WalletIconImageView) findViewById(R.h.cQD);
        this.oNu = (TextView) findViewById(R.h.cRJ);
    }

    public WalletFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void tC(String str) {
        this.oNB = str;
        ccN();
    }

    public final void UR(String str) {
        if (this.wFX == null) {
            return;
        }
        if (this.wGa == null || !this.wGa.d(this, str)) {
            this.wFX.set3DesEncrptData(str);
            setSelection(getInputLength());
        }
    }

    public final void setImeOptions(int i) {
        if (this.wFX != null) {
            this.wFX.setImeOptions(i);
        }
    }

    public final void setInputType(int i) {
        if (this.wFX != null) {
            this.wFX.setInputType(i);
        }
    }

    public final void setText(String str) {
        if (this.wFX == null) {
            return;
        }
        if (this.wGa == null || !this.wGa.c(this, str)) {
            this.wFX.setText(str);
            this.wFX.setSelection(getInputLength());
        }
    }

    private void aWu() {
        if (this.oNt != null && !bg.mA(getText()) && this.wFX != null && this.wFX.isEnabled() && this.wFX.isClickable() && this.wFX.isFocusable() && this.wFX.isFocused()) {
            this.oNt.g(new OnClickListener(this) {
                final /* synthetic */ WalletFormView wGf;

                {
                    this.wGf = r1;
                }

                public final void onClick(View view) {
                    this.wGf.aWw();
                }
            });
        } else if (this.oNt != null) {
            this.oNt.bGO();
        } else {
            w.v("MicroMsg.WalletFormView", "hy: no info iv");
        }
    }

    public final boolean ccM() {
        return this.wFX != null ? this.wFX.isFocusable() : false;
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    protected final void onFinishInflate() {
        super.onFinishInflate();
        ccN();
        if (this.oNr != null) {
            this.oNr.setText(this.oND);
            this.oNr.setVisibility(this.oNE);
        }
        if (this.oNt != null) {
            this.oNt.setImageResource(this.oNF);
            this.oNt.setVisibility(this.oNG);
        }
        if (this.oNu != null) {
            this.oNu.setText(this.oNH);
            this.oNu.setVisibility(this.oNI);
        }
        Context context = getContext();
        if (this.wFX != null) {
            if (this.wGe == 1) {
                this.wFX.setTypeface(e.fm(context));
            }
            this.wFX.setHint(this.oNJ);
            this.wFX.setGravity(this.oNK);
            this.wFX.setTextColor(this.oNL);
            setText(this.oNM);
            b.a(this.wFX, this.wGd);
            this.wFX.setBackgroundResource(this.oNP);
            this.wFX.setEnabled(this.oNQ);
            this.wFX.setFocusable(this.oNS);
            this.wFX.setClickable(this.oNR);
            this.wFX.setHintTextColor(this.oNV);
            setImeOptions(this.oNU);
            setInputType(this.oNT);
            this.wFX.addTextChangedListener(new TextWatcher(this) {
                private boolean oNX = false;
                final /* synthetic */ WalletFormView wGf;

                {
                    this.wGf = r2;
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    if (this.wGf.Pb() != this.oNX) {
                        if (this.wGf.wFY != null) {
                            this.wGf.wFY.gA(this.wGf.Pb());
                        }
                        this.oNX = this.wGf.Pb();
                    }
                    this.wGf.aWu();
                }
            });
            this.wFX.setOnFocusChangeListener(this);
        }
        aWu();
        if (this.wFX != null) {
            if (this.oNT == 2) {
                this.wFX.setKeyListener(new NumberKeyListener(this) {
                    final /* synthetic */ WalletFormView wGf;

                    {
                        this.wGf = r1;
                    }

                    public final int getInputType() {
                        return 3;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                    }
                });
            } else if (this.oNT == 4) {
                this.wFX.setKeyListener(new NumberKeyListener(this) {
                    final /* synthetic */ WalletFormView wGf;

                    {
                        this.wGf = r1;
                    }

                    public final int getInputType() {
                        return 1;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
                    }
                });
            } else if (this.oNT == FileUtils.S_IWUSR) {
                this.wFX.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.wFX.setKeyListener(new NumberKeyListener(this) {
                    final /* synthetic */ WalletFormView wGf;

                    {
                        this.wGf = r1;
                    }

                    public final int getInputType() {
                        return 18;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                    }
                });
                this.wFX.setRawInputType(18);
            } else if (this.oNT == 3) {
                this.wFX.setKeyListener(new NumberKeyListener(this) {
                    final /* synthetic */ WalletFormView wGf;

                    {
                        this.wGf = r1;
                    }

                    public final int getInputType() {
                        return 3;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-'};
                    }
                });
            } else {
                this.wFX.setInputType(this.oNT);
            }
            if (this.oNN != -1) {
                this.wFX.setFilters(new InputFilter[]{new LengthFilter(this.oNN)});
            }
        }
        if (this.wFZ != null) {
            this.wFZ.bsk();
        }
    }

    public final void setHint(CharSequence charSequence) {
        if (this.wFX != null) {
            this.wFX.setHint(charSequence);
        }
    }

    public final void setOnEditorActionListener(OnEditorActionListener onEditorActionListener) {
        this.wFX.setOnEditorActionListener(onEditorActionListener);
    }

    @SuppressLint({"WrongCall"})
    protected final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.wFZ != null && this.wFZ.a(this, motionEvent)) {
            return true;
        }
        if (this.wFX != null && b(this.wFX, motionEvent) && !this.wFX.isClickable()) {
            w.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
            return true;
        } else if (!b(this.oNt, motionEvent) || motionEvent.getAction() != 1) {
            return false;
        } else {
            w.d("MicroMsg.WalletFormView", "hy: click on info iv");
            aWu();
            this.oNt.performClick();
            return true;
        }
    }

    final boolean b(View view, MotionEvent motionEvent) {
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        Rect rect;
        if (view != null) {
            rect = new Rect();
            view.getHitRect(rect);
            if (view == this.oNt) {
                rect.left -= 50;
                rect.right += 50;
                rect.top -= 25;
                rect.bottom += 25;
            }
        } else {
            rect = null;
        }
        if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return true;
        }
        return false;
    }

    private void ccN() {
        if (this.jhl != null) {
            this.jhl.setText(this.oNB);
            this.jhl.setVisibility(this.oNC);
        }
    }

    public final void setSelection(int i) {
        if (this.wFX != null) {
            this.wFX.setSelection(i);
        }
    }

    public final String getText() {
        if (this.wFX != null) {
            String a = com.tencent.mm.wallet_core.ui.formview.c.a.a(this.wGc, this.wFX);
            if (this.wGa == null || !this.wGa.aWt()) {
                return a;
            }
            return this.wGa.e(this, a);
        }
        w.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
        return "";
    }

    public final KeyListener getKeyListener() {
        if (this.wFX != null) {
            return this.wFX.getKeyListener();
        }
        w.w("MicroMsg.WalletFormView", "hy: no content et");
        return null;
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public final void j(OnClickListener onClickListener) {
        this.oNx = onClickListener;
        if (this.oNt != null) {
            this.oNt.setOnClickListener(this.oNx);
        }
    }

    public final void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.oNw = onFocusChangeListener;
    }

    public final void a(TextWatcher textWatcher) {
        if (this.wFX != null) {
            this.wFX.addTextChangedListener(textWatcher);
        }
    }

    public final void setKeyListener(KeyListener keyListener) {
        if (this.wFX != null) {
            this.wFX.setKeyListener(keyListener);
        }
    }

    public final boolean Pb() {
        if (this.wFX != null) {
            int inputLength = this.wFX.getInputLength();
            if (inputLength > this.oNN || inputLength < this.oNO) {
                return false;
            }
            if (this.wGa != null) {
                return this.wGa.h(this);
            }
            return true;
        }
        w.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
        return true;
    }

    public final void aWw() {
        if (this.wFX != null) {
            this.wFX.ClearInput();
        }
    }

    public final boolean dF(View view) {
        if (getVisibility() != 0) {
            if (view != null) {
                view.setVisibility(8);
            }
            return true;
        } else if (bg.mA(getText())) {
            if (view != null) {
                view.setVisibility(4);
            }
            if (this.jhl == null) {
                return false;
            }
            this.jhl.setEnabled(true);
            return false;
        } else if (Pb()) {
            if (view != null) {
                view.setVisibility(4);
            }
            if (this.jhl != null) {
                this.jhl.setEnabled(true);
            }
            return true;
        } else {
            if (view != null) {
                view.setVisibility(0);
            }
            if (this.jhl == null) {
                return false;
            }
            this.jhl.setEnabled(false);
            return false;
        }
    }

    public final void setFilters(InputFilter[] inputFilterArr) {
        if (this.wFX != null) {
            this.wFX.setFilters(inputFilterArr);
        }
    }

    private int getInputLength() {
        return this.wFX != null ? this.wFX.getInputLength() : 0;
    }

    public final void ccO() {
        if (this.wFX != null) {
            this.wFX.setFocusable(true);
            this.wFX.requestFocus();
            ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this.wFX, 0);
        }
    }

    public final void onFocusChange(View view, boolean z) {
        if (this.oNw != null) {
            this.oNw.onFocusChange(this, z);
        }
        if (this.wFY != null) {
            this.wFY.gA(Pb());
        }
        if (Pb()) {
            if (this.jhl != null) {
                this.jhl.setEnabled(true);
            }
        } else if (this.jhl != null) {
            this.jhl.setEnabled(false);
        }
        aWu();
    }
}
