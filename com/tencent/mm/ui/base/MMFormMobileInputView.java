package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.m;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.widget.MMEditText.c;

public class MMFormMobileInputView extends LinearLayout {
    private Context mContext;
    private int vjm;
    private int[] vjn;
    public EditText vjq;
    public EditText vjr;
    private String vjs;
    private String vjt;
    private final int vju;
    private a vjv;

    public interface a {
    }

    @TargetApi(11)
    public MMFormMobileInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = null;
        this.vjm = -1;
        this.vjs = "";
        this.vjt = "";
        this.vju = 13;
        this.vjv = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.fqh, i, 0);
        this.vjm = obtainStyledAttributes.getResourceId(m.hfH, -1);
        obtainStyledAttributes.recycle();
        r.eC(context).inflate(h.heh, this);
        this.mContext = context;
    }

    public MMFormMobileInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onFinishInflate() {
        this.vjq = (EditText) findViewById(g.bGO);
        this.vjr = (EditText) findViewById(g.hcK);
        if (this.vjq == null || this.vjr == null) {
            w.w("MicroMsg.MMFormMobileInputView", "countryCodeET : %s, mobileNumberET : %s", new Object[]{this.vjq, this.vjr});
        } else if (this.vjm != -1) {
            this.vjr.setHint(this.vjm);
        }
        if (this.vjq != null && this.vjr != null) {
            if (this.vjq.hasFocus() || this.vjr.hasFocus()) {
                kM(true);
            } else {
                kM(false);
            }
            OnFocusChangeListener anonymousClass1 = new OnFocusChangeListener(this) {
                final /* synthetic */ MMFormMobileInputView vjw;

                {
                    this.vjw = r1;
                }

                public final void onFocusChange(View view, boolean z) {
                    if (view == this.vjw.vjq || view == this.vjw.vjr) {
                        this.vjw.kM(z);
                    }
                }
            };
            this.vjq.setOnFocusChangeListener(anonymousClass1);
            this.vjr.setOnFocusChangeListener(anonymousClass1);
            this.vjr.addTextChangedListener(new c(this.vjr, null, 20));
            this.vjr.addTextChangedListener(new TextWatcher(this) {
                private an mRA = new an();
                final /* synthetic */ MMFormMobileInputView vjw;

                {
                    this.vjw = r2;
                }

                public final void afterTextChanged(Editable editable) {
                    int selectionEnd = this.vjw.vjr.getSelectionEnd();
                    String obj = this.vjw.vjr.getText().toString();
                    String substring = this.vjw.vjr.getText().toString().substring(0, selectionEnd);
                    if (obj != null && !obj.equals(this.vjw.vjs)) {
                        String obj2 = this.vjw.vjq.getText().toString();
                        this.vjw.vjs = an.formatNumber(obj2.replace("+", ""), obj);
                        this.vjw.vjt = an.formatNumber(obj2.replace("+", ""), substring);
                        if (!obj.equals(this.vjw.vjs)) {
                            this.vjw.vjr.setText(this.vjw.vjs);
                            int length = this.vjw.vjr.getText().toString().length();
                            if (substring != null) {
                                try {
                                    this.vjw.vjt = an.formatNumber(obj2.replace("+", ""), substring);
                                    if (obj.length() > 13 && selectionEnd <= length) {
                                        this.vjw.vjr.setSelection(substring.toString().length());
                                        return;
                                    } else if (selectionEnd > length || this.vjw.vjt.toString().length() > length) {
                                        this.vjw.vjr.setSelection(length - Math.abs(obj.length() - selectionEnd));
                                        return;
                                    } else {
                                        this.vjw.vjr.setSelection(this.vjw.vjt.toString().length());
                                        return;
                                    }
                                } catch (Throwable e) {
                                    w.printErrStackTrace("MicroMsg.MMFormMobileInputView", e, "", new Object[0]);
                                    return;
                                }
                            }
                            this.vjw.vjr.setSelection(0);
                        }
                    }
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
            this.vjq.addTextChangedListener(new TextWatcher(this) {
                final /* synthetic */ MMFormMobileInputView vjw;

                {
                    this.vjw = r1;
                }

                public final void afterTextChanged(Editable editable) {
                    String obj = this.vjw.vjq.getText().toString();
                    if (bg.mA(obj)) {
                        this.vjw.vjq.setText("+");
                        this.vjw.vjq.setSelection(this.vjw.vjq.getText().toString().length());
                    } else if (!obj.contains("+")) {
                        this.vjw.vjq.setText("+" + obj);
                        this.vjw.vjq.setSelection(this.vjw.vjq.getText().toString().length());
                    } else if (obj.length() > 1) {
                        obj = obj.substring(1);
                        if (obj.length() > 4) {
                            this.vjw.vjq.setText(obj.substring(0, 4));
                        }
                    }
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }
            });
        }
    }

    public final void kM(boolean z) {
        de(this.vjq);
        if (z) {
            this.vjq.setBackgroundResource(f.bfV);
        } else {
            this.vjq.setBackgroundResource(f.bfW);
        }
        df(this.vjq);
        de(this.vjr);
        if (z) {
            this.vjr.setBackgroundResource(f.bfV);
        } else {
            this.vjr.setBackgroundResource(f.bfW);
        }
        df(this.vjr);
    }

    private void de(View view) {
        this.vjn = new int[]{view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom()};
    }

    private void df(View view) {
        if (this.vjn != null) {
            view.setPadding(this.vjn[0], this.vjn[1], this.vjn[2], this.vjn[3]);
        }
    }

    public final String getCountryCode() {
        if (this.vjq != null) {
            return this.vjq.getText().toString().trim();
        }
        return "";
    }
}
