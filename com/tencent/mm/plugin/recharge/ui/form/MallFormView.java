package com.tencent.mm.plugin.recharge.ui.form;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.wallet.WalletIconImageView;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.FileUtils;
import junit.framework.Assert;

public final class MallFormView extends LinearLayout implements OnFocusChangeListener {
    private TextView jhl;
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
    private int oNN;
    private int oNO;
    private int oNP;
    private boolean oNQ;
    private boolean oNR;
    private boolean oNS;
    private int oNT;
    private int oNU;
    private int oNV;
    public boolean oNW;
    private TextView oNr;
    public EditText oNs;
    public WalletIconImageView oNt;
    public TextView oNu;
    public a oNv;
    private OnFocusChangeListener oNw;
    private OnClickListener oNx;
    private a oNy;
    b oNz;

    public interface a {
        void gA(boolean z);
    }

    public MallFormView(Context context, AttributeSet attributeSet, int i) {
        boolean z = false;
        super(context, attributeSet);
        this.jhl = null;
        this.oNr = null;
        this.oNs = null;
        this.oNt = null;
        this.oNu = null;
        this.oNv = null;
        this.oNw = null;
        this.oNx = null;
        this.oNy = null;
        this.oNz = null;
        this.oNA = -1;
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
        this.oNN = Integer.MAX_VALUE;
        this.oNO = 1;
        this.oNP = R.g.bhc;
        this.oNQ = true;
        this.oNR = false;
        this.oNS = true;
        this.oNT = 1;
        this.oNU = 5;
        this.oNV = R.e.aUD;
        this.oNW = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.fqS, i, 0);
        this.oNA = obtainStyledAttributes.getResourceId(R.n.frh, this.oNA);
        int resourceId = obtainStyledAttributes.getResourceId(R.n.frm, 0);
        if (resourceId != 0) {
            this.oNB = context.getString(resourceId);
        }
        this.oNF = obtainStyledAttributes.getResourceId(R.n.frf, this.oNF);
        resourceId = obtainStyledAttributes.getResourceId(R.n.frk, 0);
        if (resourceId != 0) {
            this.oNH = context.getString(resourceId);
        }
        this.oNG = obtainStyledAttributes.getInteger(R.n.frg, this.oNG);
        this.oNC = obtainStyledAttributes.getInteger(R.n.frn, this.oNC);
        this.oNI = obtainStyledAttributes.getInteger(R.n.frl, this.oNI);
        this.oNE = obtainStyledAttributes.getInteger(R.n.frj, this.oNE);
        resourceId = obtainStyledAttributes.getResourceId(R.n.fri, 0);
        if (resourceId != 0) {
            this.oND = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(R.n.fqZ, 0);
        if (resourceId != 0) {
            this.oNJ = context.getString(resourceId);
        }
        this.oNK = obtainStyledAttributes.getInteger(R.n.fqY, this.oNK);
        this.oNL = obtainStyledAttributes.getColor(R.n.fre, this.oNL);
        resourceId = obtainStyledAttributes.getResourceId(R.n.frd, 0);
        if (resourceId != 0) {
            this.oNM = context.getString(resourceId);
        }
        this.oNN = obtainStyledAttributes.getInteger(R.n.frb, this.oNN);
        this.oNO = obtainStyledAttributes.getInteger(R.n.frc, this.oNO);
        this.oNP = obtainStyledAttributes.getResourceId(R.n.fqV, this.oNP);
        this.oNQ = obtainStyledAttributes.getBoolean(R.n.fqX, this.oNQ);
        this.oNR = obtainStyledAttributes.getBoolean(R.n.fqW, this.oNR);
        this.oNS = obtainStyledAttributes.getBoolean(R.n.fqX, this.oNS);
        this.oNT = obtainStyledAttributes.getInteger(R.n.fqU, this.oNT);
        this.oNU = obtainStyledAttributes.getInteger(R.n.fqT, this.oNU);
        this.oNV = obtainStyledAttributes.getInteger(R.n.fra, this.oNV);
        obtainStyledAttributes.recycle();
        if (this.oNA > 0) {
            z = true;
        }
        Assert.assertTrue(z);
        setOrientation(1);
        inflate(context, this.oNA, this);
        this.jhl = (TextView) findViewById(R.h.ciK);
        this.oNr = (TextView) findViewById(R.h.chG);
        this.oNs = (EditText) findViewById(R.h.chb);
        this.oNt = (WalletIconImageView) findViewById(R.h.chk);
        this.oNu = (TextView) findViewById(R.h.ciJ);
    }

    public MallFormView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void aWu() {
        if (this.oNt != null && !bg.mA(getText()) && this.oNs != null && this.oNs.isEnabled() && this.oNs.isClickable() && this.oNs.isFocusable() && this.oNs.isFocused()) {
            this.oNt.g(new OnClickListener(this) {
                final /* synthetic */ MallFormView oNY;

                {
                    this.oNY = r1;
                }

                public final void onClick(View view) {
                    this.oNY.aWw();
                }
            });
        } else if (this.oNt != null) {
            this.oNt.bGO();
        } else {
            w.v("MicroMsg.WalletFormView", "hy: no info iv");
        }
    }

    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    protected final void onFinishInflate() {
        super.onFinishInflate();
        if (this.jhl != null) {
            this.jhl.setText(this.oNB);
            this.jhl.setVisibility(this.oNC);
        }
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
        getContext();
        if (this.oNs != null) {
            int length;
            this.oNs.setHint(this.oNJ);
            this.oNs.setGravity(this.oNK);
            this.oNs.setTextColor(this.oNL);
            CharSequence charSequence = this.oNM;
            if (this.oNs != null) {
                this.oNs.setText(charSequence);
                EditText editText = this.oNs;
                if (this.oNs != null) {
                    length = this.oNs.getText().length();
                } else {
                    length = 0;
                }
                editText.setSelection(length);
            }
            this.oNs.setBackgroundResource(this.oNP);
            this.oNs.setEnabled(this.oNQ);
            this.oNs.setFocusable(this.oNS);
            this.oNs.setClickable(this.oNR);
            this.oNs.setHintTextColor(this.oNV);
            length = this.oNU;
            if (this.oNs != null) {
                this.oNs.setImeOptions(length);
            }
            length = this.oNT;
            if (this.oNs != null) {
                this.oNs.setInputType(length);
            }
            this.oNs.addTextChangedListener(new TextWatcher(this) {
                private boolean oNX = false;
                final /* synthetic */ MallFormView oNY;

                {
                    this.oNY = r2;
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    if (this.oNY.Pb() != this.oNX) {
                        if (this.oNY.oNv != null) {
                            this.oNY.oNv.gA(this.oNY.Pb());
                        }
                        this.oNX = this.oNY.Pb();
                    }
                    this.oNY.aWu();
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                }
            });
            this.oNs.setOnFocusChangeListener(this);
        }
        aWu();
        if (this.oNs != null) {
            if (this.oNT == 2) {
                this.oNs.setKeyListener(new NumberKeyListener(this) {
                    final /* synthetic */ MallFormView oNY;

                    {
                        this.oNY = r1;
                    }

                    public final int getInputType() {
                        return 3;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                    }
                });
            } else if (this.oNT == 4) {
                this.oNs.setKeyListener(new NumberKeyListener(this) {
                    final /* synthetic */ MallFormView oNY;

                    {
                        this.oNY = r1;
                    }

                    public final int getInputType() {
                        return 1;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'x', 'X'};
                    }
                });
            } else if (this.oNT == FileUtils.S_IWUSR) {
                this.oNs.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.oNs.setKeyListener(new NumberKeyListener(this) {
                    final /* synthetic */ MallFormView oNY;

                    {
                        this.oNY = r1;
                    }

                    public final int getInputType() {
                        return 18;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
                    }
                });
                this.oNs.setRawInputType(18);
            } else if (this.oNT == 3) {
                this.oNs.setKeyListener(new NumberKeyListener(this) {
                    final /* synthetic */ MallFormView oNY;

                    {
                        this.oNY = r1;
                    }

                    public final int getInputType() {
                        return 3;
                    }

                    protected final char[] getAcceptedChars() {
                        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '-'};
                    }
                });
            } else {
                this.oNs.setInputType(this.oNT);
            }
            if (this.oNN != -1) {
                this.oNs.setFilters(new InputFilter[]{new LengthFilter(this.oNN)});
            }
        }
    }

    @SuppressLint({"WrongCall"})
    protected final void onMeasure(int i, int i2) {
        if (this.oNy == null || !this.oNy.aWr()) {
            super.onMeasure(i, i2);
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.oNy != null && this.oNy.aWs()) {
            return true;
        }
        if (this.oNs != null && b(this.oNs, motionEvent) && !this.oNs.isClickable()) {
            w.d("MicroMsg.WalletFormView", "hy: click on content but content is not clickable. whole view perform click");
            return true;
        } else if (!b(this.oNt, motionEvent) || motionEvent.getAction() != 1) {
            return false;
        } else {
            w.d("MicroMsg.WalletFormView", "hy: click on info iv");
            this.oNt.performClick();
            return true;
        }
    }

    private boolean b(View view, MotionEvent motionEvent) {
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

    public final void aWv() {
        w.d("MicroMsg.WalletFormView", "shouldClearFocus: %s", new Object[]{Boolean.valueOf(this.oNW)});
        if (this.oNW) {
            this.oNs.clearFocus();
        } else {
            this.oNW = true;
        }
    }

    public final String getText() {
        if (this.oNs != null) {
            String obj = this.oNs.getText().toString();
            if (this.oNz == null || !this.oNz.aWt()) {
                return obj;
            }
            return this.oNz.Dn(obj);
        }
        w.e("MicroMsg.WalletFormView", "hy: no content et. return nil");
        return "";
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
    }

    public final void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.oNw = onFocusChangeListener;
    }

    public final boolean Pb() {
        if (this.oNs != null) {
            int length = this.oNs.getText() == null ? 0 : this.oNs.getText().length();
            if (length > this.oNN || length < this.oNO) {
                return false;
            }
            return this.oNz != null ? this.oNz.a(this) : true;
        } else {
            w.e("MicroMsg.WalletFormView", "hy: no content edit text. true as default");
            return true;
        }
    }

    public final void aWw() {
        if (this.oNs != null) {
            this.oNs.setText("");
        }
    }

    public final void onFocusChange(View view, boolean z) {
        if (this.oNw != null) {
            this.oNw.onFocusChange(this, z);
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
