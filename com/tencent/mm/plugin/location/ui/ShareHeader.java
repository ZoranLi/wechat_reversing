package com.tencent.mm.plugin.location.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.MMImageButton;

public class ShareHeader extends LinearLayout {
    private TextView ioX;
    private Context mContext;
    public ViewGroup ndR;
    public MMImageButton ndS;
    public MMImageButton ndT;

    @TargetApi(11)
    public ShareHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    public ShareHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        View inflate = View.inflate(this.mContext, R.i.cEJ, this);
        this.ndR = (ViewGroup) inflate.findViewById(R.h.bVX);
        this.ndS = (MMImageButton) inflate.findViewById(R.h.cJb);
        this.ndT = (MMImageButton) inflate.findViewById(R.h.cJd);
        this.ioX = (TextView) inflate.findViewById(R.h.title);
    }
}
