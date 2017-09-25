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
import android.widget.TextView;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.m;
import com.tencent.mm.sdk.platformtools.w;

public class MMFormInputView extends LinearLayout {
    private TextView ipw;
    private int layout;
    private Context mContext;
    public EditText oBT;
    private int vjl;
    private int vjm;
    private int[] vjn;
    public OnFocusChangeListener vjo;

    static /* synthetic */ void c(MMFormInputView mMFormInputView) {
        if (mMFormInputView.vjn != null) {
            mMFormInputView.setPadding(mMFormInputView.vjn[0], mMFormInputView.vjn[1], mMFormInputView.vjn[2], mMFormInputView.vjn[3]);
        }
    }

    @TargetApi(11)
    public MMFormInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = null;
        this.vjl = -1;
        this.vjm = -1;
        this.layout = -1;
        this.vjo = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.fqh, i, 0);
        this.vjm = obtainStyledAttributes.getResourceId(m.hfH, -1);
        this.vjl = obtainStyledAttributes.getResourceId(m.hfJ, -1);
        this.layout = obtainStyledAttributes.getResourceId(m.hfI, this.layout);
        obtainStyledAttributes.recycle();
        inflate(context, this.layout, this);
        this.mContext = context;
    }

    public MMFormInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onFinishInflate() {
        this.ipw = (TextView) findViewById(g.title);
        this.oBT = (EditText) findViewById(g.bKP);
        if (this.ipw == null || this.oBT == null) {
            w.w("MicroMsg.MMFormInputView", "titleTV : %s, contentET : %s", this.ipw, this.oBT);
        } else {
            if (this.vjl != -1) {
                this.ipw.setText(this.vjl);
            }
            if (this.vjm != -1) {
                this.oBT.setHint(this.vjm);
            }
        }
        if (this.oBT != null) {
            this.oBT.setOnFocusChangeListener(new OnFocusChangeListener(this) {
                final /* synthetic */ MMFormInputView vjp;

                {
                    this.vjp = r1;
                }

                public final void onFocusChange(View view, boolean z) {
                    if (view == this.vjp.oBT) {
                        this.vjp.vjn = new int[]{this.vjp.getPaddingLeft(), this.vjp.getPaddingTop(), this.vjp.getPaddingRight(), this.vjp.getPaddingBottom()};
                        if (z) {
                            this.vjp.setBackgroundResource(f.bfV);
                        } else {
                            this.vjp.setBackgroundResource(f.bfW);
                        }
                        MMFormInputView.c(this.vjp);
                    }
                    if (this.vjp.vjo != null) {
                        this.vjp.vjo.onFocusChange(view, z);
                    }
                }
            });
        }
    }

    public final void setText(String str) {
        if (this.oBT != null) {
            this.oBT.setText(str);
        } else {
            w.e("MicroMsg.MMFormInputView", "contentET is null!");
        }
    }

    public final void setInputType(int i) {
        if (this.oBT != null) {
            this.oBT.setInputType(i);
        } else {
            w.e("MicroMsg.MMFormInputView", "contentET is null!");
        }
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        if (textWatcher == null || this.oBT == null) {
            w.w("MicroMsg.MMFormInputView", "watcher : %s, contentET : %s", textWatcher, this.oBT);
            return;
        }
        this.oBT.addTextChangedListener(textWatcher);
    }

    public final Editable getText() {
        if (this.oBT != null) {
            return this.oBT.getText();
        }
        w.e("MicroMsg.MMFormInputView", "contentET is null!");
        return null;
    }
}
