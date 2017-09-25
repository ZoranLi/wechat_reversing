package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.graphics.Paint;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.mm.bg.a;
import com.tencent.mm.s.a.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class AutoHintSizeEditText extends EditText {
    private float vqf;
    private Paint vqg;
    private String vqh = "";
    private int vqi = Integer.MIN_VALUE;
    private float vqj;

    public AutoHintSizeEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public AutoHintSizeEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.vqf = getTextSize();
        this.vqj = this.vqf;
        this.vqg = new Paint(getPaint());
        addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ AutoHintSizeEditText vqk;

            {
                this.vqk = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                this.vqk.a(editable, this.vqk.getHint(), (this.vqk.getWidth() - this.vqk.getPaddingLeft()) - this.vqk.getPaddingRight());
            }
        });
    }

    private void a(Editable editable, CharSequence charSequence, int i) {
        if (editable == null || bg.mA(editable.toString())) {
            if (charSequence != null && !bg.mA(charSequence.toString())) {
                String charSequence2 = charSequence.toString();
                if (!this.vqh.equals(charSequence2) || this.vqi != i) {
                    this.vqh = charSequence2;
                    this.vqi = i;
                    if (getPaint().measureText(charSequence2) > ((float) i)) {
                        int dimensionPixelSize = getResources().getDimensionPixelSize(e.aXW);
                        int fromDPToPix = a.fromDPToPix(getContext(), 1);
                        for (int i2 = ((int) this.vqf) - fromDPToPix; i2 > dimensionPixelSize; i2 -= fromDPToPix) {
                            this.vqg.setTextSize((float) i2);
                            if (this.vqg.measureText(charSequence2) < ((float) i)) {
                                w.v("MicroMsg.AutoHintSizeEdittext", "get new hint text size %d", new Object[]{Integer.valueOf(i2)});
                                this.vqj = (float) i2;
                                setTextSize(0, (float) i2);
                                return;
                            }
                        }
                    }
                } else if (getTextSize() != this.vqj) {
                    w.v("MicroMsg.AutoHintSizeEdittext", "use last hint text size %f", new Object[]{Float.valueOf(this.vqj)});
                    setTextSize(0, this.vqj);
                }
            } else if (getTextSize() != this.vqf) {
                w.v("MicroMsg.AutoHintSizeEdittext", "hint is null, reset text size %f", new Object[]{Float.valueOf(this.vqf)});
                setTextSize(0, this.vqf);
            }
        } else if (getTextSize() != this.vqf) {
            w.v("MicroMsg.AutoHintSizeEdittext", "content not null, reset text size %f", new Object[]{Float.valueOf(this.vqf)});
            setTextSize(0, this.vqf);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        w.d("MicroMsg.AutoHintSizeEdittext", "on layout, changed %B", new Object[]{Boolean.valueOf(z)});
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            a(getText(), getHint(), ((i3 - i) - getPaddingLeft()) - getPaddingRight());
        }
    }
}
