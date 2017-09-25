package com.tencent.mm.wallet_core.ui.formview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnFocusChangeListener;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.r;
import com.tencent.wcdb.FileUtils;
import com.tenpay.android.wechat.TenpaySecureEditText;

public final class EditHintPasswdView extends RelativeLayout implements OnFocusChangeListener {
    private static final int wFO = R.g.beE;
    private OnFocusChangeListener itW;
    private int rov;
    private TenpaySecureEditText wFP;
    private int wFQ;
    private int wFR;
    public int wFS;
    public a wFT;

    public interface a {
        void gA(boolean z);
    }

    public EditHintPasswdView(Context context, AttributeSet attributeSet, int i) {
        int i2;
        super(context, attributeSet);
        this.wFP = null;
        this.wFQ = 6;
        this.rov = 1;
        this.wFR = wFO;
        this.wFS = 1;
        this.wFT = null;
        this.itW = null;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.frA, i, 0);
        this.rov = obtainStyledAttributes.getInteger(R.n.frD, 1);
        this.wFR = obtainStyledAttributes.getResourceId(R.n.frB, wFO);
        this.wFS = obtainStyledAttributes.getInteger(R.n.frC, 1);
        obtainStyledAttributes.recycle();
        this.wFP = (TenpaySecureEditText) r.eC(context).inflate(R.i.dfD, this, true).findViewById(R.h.cQh);
        b.a(this.wFP, this.rov);
        switch (this.rov) {
            case 1:
                i2 = 6;
                break;
            case 3:
                i2 = 3;
                break;
            case 4:
                i2 = 4;
                break;
            default:
                w.i("MicroMsg.EditHintPasswdView", "hy: error or not set format. use default");
                i2 = 6;
                break;
        }
        this.wFQ = i2;
        if (this.wFP != null) {
            this.wFP.setBackgroundResource(this.wFR);
            this.wFP.setImeOptions(6);
            this.wFP.setInputType(FileUtils.S_IWUSR);
            this.wFP.addTextChangedListener(new TextWatcher(this) {
                final /* synthetic */ EditHintPasswdView wFU;

                {
                    this.wFU = r1;
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    if (this.wFU.wFT != null) {
                        this.wFU.wFT.gA(this.wFU.Pb());
                    }
                }
            });
            this.wFP.setOnFocusChangeListener(this);
            super.setEnabled(true);
            super.setClickable(true);
            return;
        }
        w.e("MicroMsg.EditHintPasswdView", "hy: no edit text view");
    }

    public EditHintPasswdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final String ccL() {
        if (this.wFP != null) {
            return aa.Pq(this.wFP.getText().toString());
        }
        w.w("MicroMsg.EditHintPasswdView", "hy: edit view is null");
        return "";
    }

    private boolean Pb() {
        if (this.wFP == null || this.wFP.getInputLength() != this.wFQ) {
            return false;
        }
        return true;
    }

    public final void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.itW = onFocusChangeListener;
    }

    public final OnFocusChangeListener getOnFocusChangeListener() {
        return this.itW;
    }

    public final String getText() {
        if (this.wFP != null) {
            return com.tencent.mm.wallet_core.ui.formview.c.a.a(this.wFS, this.wFP);
        }
        w.w("MicroMsg.EditHintPasswdView", "hy: no edit view");
        return "";
    }

    public final void aWw() {
        if (this.wFP != null) {
            this.wFP.ClearInput();
        }
    }

    protected final void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(b.a(getContext(), 960.0f), i), getDefaultSize(b.a(getContext(), 720.0f), i2));
        int measuredWidth = getMeasuredWidth();
        int i3 = this.wFQ == 0 ? measuredWidth / 6 : measuredWidth / this.wFQ;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(i3, 1073741824);
        setMeasuredDimension(getDefaultSize(measuredWidth, makeMeasureSpec), getDefaultSize(i3, makeMeasureSpec2));
        super.onMeasure(makeMeasureSpec, makeMeasureSpec2);
    }

    public final void onFocusChange(View view, boolean z) {
        if (this.itW != null) {
            this.itW.onFocusChange(this, z);
        }
        if (this.wFT != null) {
            this.wFT.gA(Pb());
        }
    }
}
