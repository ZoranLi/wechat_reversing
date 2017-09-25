package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;

public class TranslateCommentTextView extends LinearLayout {
    public SnsTranslateResultView qAT;
    public MaskTextView qLm;

    public TranslateCommentTextView(Context context) {
        super(context);
        init();
    }

    public TranslateCommentTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(g.pIA, this);
        this.qLm = (MaskTextView) findViewById(f.pCa);
        this.qAT = (SnsTranslateResultView) findViewById(f.pFZ);
        this.qAT.setVisibility(8);
    }
}
