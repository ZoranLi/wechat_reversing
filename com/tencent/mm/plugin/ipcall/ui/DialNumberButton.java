package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;

public class DialNumberButton extends RelativeLayout {
    TextView mRi;
    TextView mRj;
    private boolean mRk = false;

    public DialNumberButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(getContext()).inflate(R.i.dag, this);
        this.mRi = (TextView) findViewById(R.h.bIW);
        this.mRj = (TextView) findViewById(R.h.bIX);
        if (d.eo(16)) {
            this.mRi.setTypeface(Typeface.create("sans-serif-light", 0));
            this.mRj.setTypeface(Typeface.create("sans-serif-normal", 0));
        }
        setClipChildren(false);
        setClipToPadding(false);
    }

    public final String aES() {
        return this.mRi.getText().toString();
    }

    public final String aET() {
        return this.mRj.getText().toString();
    }

    public final void fc(boolean z) {
        this.mRk = z;
        if (this.mRk) {
            if ("#".equals(this.mRi.getText()) || "*".equals(this.mRi.getText())) {
                this.mRi.setTextColor(getContext().getResources().getColor(R.e.aTv));
            } else {
                this.mRi.setTextColor(getContext().getResources().getColor(R.e.aTx));
            }
            this.mRj.setTextColor(getContext().getResources().getColor(R.e.aTv));
            setBackgroundDrawable(getResources().getDrawable(R.g.bew));
            return;
        }
        if ("#".equals(this.mRi.getText()) || "*".equals(this.mRi.getText())) {
            this.mRi.setTextColor(getContext().getResources().getColor(R.e.aTv));
        } else {
            this.mRi.setTextColor(getContext().getResources().getColor(R.e.aTw));
        }
        this.mRj.setTextColor(getContext().getResources().getColor(R.e.aTv));
        setBackgroundDrawable(getResources().getDrawable(R.g.bex));
    }
}
