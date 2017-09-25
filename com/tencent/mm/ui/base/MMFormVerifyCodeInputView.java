package com.tencent.mm.ui.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.k;
import com.tencent.mm.s.a.m;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.w;

public class MMFormVerifyCodeInputView extends LinearLayout {
    private aj hQV;
    private TextView ipw;
    private int layout;
    private Context mContext;
    public EditText oBT;
    private int vjA;
    private int vjB;
    public OnClickListener vjC;
    private int vjl;
    private int vjm;
    private int[] vjn;
    private OnFocusChangeListener vjo;
    private TextView vjx;
    private Button vjy;
    private int vjz;

    static /* synthetic */ void c(MMFormVerifyCodeInputView mMFormVerifyCodeInputView) {
        if (mMFormVerifyCodeInputView.vjn != null) {
            mMFormVerifyCodeInputView.setPadding(mMFormVerifyCodeInputView.vjn[0], mMFormVerifyCodeInputView.vjn[1], mMFormVerifyCodeInputView.vjn[2], mMFormVerifyCodeInputView.vjn[3]);
        }
    }

    @TargetApi(11)
    public MMFormVerifyCodeInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.mContext = null;
        this.vjl = -1;
        this.vjm = -1;
        this.vjz = -1;
        this.layout = -1;
        this.vjA = 60;
        this.vjB = this.vjA;
        this.vjo = null;
        this.vjC = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, m.fqh, i, 0);
        this.vjm = obtainStyledAttributes.getResourceId(m.hfH, -1);
        this.vjl = obtainStyledAttributes.getResourceId(m.hfJ, -1);
        this.vjz = obtainStyledAttributes.getResourceId(m.hfG, -1);
        this.layout = obtainStyledAttributes.getResourceId(m.hfI, this.layout);
        obtainStyledAttributes.recycle();
        inflate(context, this.layout, this);
        this.mContext = context;
    }

    public MMFormVerifyCodeInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public void onFinishInflate() {
        this.ipw = (TextView) findViewById(g.title);
        this.oBT = (EditText) findViewById(g.bKP);
        this.vjx = (TextView) findViewById(g.hdp);
        this.vjy = (Button) findViewById(g.hda);
        if (this.ipw == null || this.oBT == null || this.vjx == null || this.vjy == null) {
            w.w("MicroMsg.MMFormVerifyCodeInputView", "titleTV : %s, contentET : %s, timerTv: %s, sendSmsBtn: %s", this.ipw, this.oBT, this.vjx, this.vjy);
        } else {
            if (this.vjl != -1) {
                this.ipw.setText(this.vjl);
            }
            if (this.vjm != -1) {
                this.oBT.setHint(this.vjm);
            }
            if (this.vjz != -1) {
                this.vjy.setText(this.vjz);
            }
        }
        if (this.oBT != null) {
            this.oBT.setOnFocusChangeListener(new OnFocusChangeListener(this) {
                final /* synthetic */ MMFormVerifyCodeInputView vjD;

                {
                    this.vjD = r1;
                }

                public final void onFocusChange(View view, boolean z) {
                    if (view == this.vjD.oBT) {
                        this.vjD.vjn = new int[]{this.vjD.getPaddingLeft(), this.vjD.getPaddingTop(), this.vjD.getPaddingRight(), this.vjD.getPaddingBottom()};
                        if (z) {
                            this.vjD.setBackgroundResource(f.bfV);
                        } else {
                            this.vjD.setBackgroundResource(f.bfW);
                        }
                        MMFormVerifyCodeInputView.c(this.vjD);
                    }
                    if (this.vjD.vjo != null) {
                        this.vjD.vjo.onFocusChange(view, z);
                    }
                }
            });
        }
        if (this.vjy != null) {
            this.vjy.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ MMFormVerifyCodeInputView vjD;

                {
                    this.vjD = r1;
                }

                public final void onClick(View view) {
                    if (this.vjD.vjC != null) {
                        this.vjD.vjC.onClick(view);
                    }
                }
            });
        }
    }

    public final void bRS() {
        this.vjy.setVisibility(8);
        this.vjx.setVisibility(0);
        this.vjx.setText(getContext().getString(k.hfm, new Object[]{Integer.valueOf(this.vjA)}));
        if (this.hQV != null) {
            this.hQV.KH();
            this.hQV.v(1000, 1000);
        } else if (getContext() != null) {
            this.hQV = new aj(getContext().getMainLooper(), new a(this) {
                final /* synthetic */ MMFormVerifyCodeInputView vjD;

                {
                    this.vjD = r1;
                }

                public final boolean oQ() {
                    this.vjD.vjB = this.vjD.vjB - 1;
                    this.vjD.vjx.setText(this.vjD.getContext().getString(k.hfm, new Object[]{Integer.valueOf(this.vjD.vjB)}));
                    if (this.vjD.vjB == 0) {
                        this.vjD.hQV.KH();
                        this.vjD.vjB = this.vjD.vjA;
                        this.vjD.vjy.setVisibility(0);
                        this.vjD.vjx.setVisibility(8);
                    }
                    return true;
                }
            }, true);
            this.hQV.v(1000, 1000);
        } else {
            this.hQV.KH();
        }
    }

    public final void reset() {
        if (this.hQV != null) {
            this.hQV.KH();
        }
        this.oBT.setText("");
        this.vjx.setVisibility(8);
        this.vjB = this.vjA;
        this.vjy.setVisibility(0);
    }

    public final void bRT() {
        if (this.oBT != null) {
            this.oBT.setInputType(3);
        } else {
            w.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        }
    }

    public final Editable getText() {
        if (this.oBT != null) {
            return this.oBT.getText();
        }
        w.e("MicroMsg.MMFormVerifyCodeInputView", "contentET is null!");
        return null;
    }
}
