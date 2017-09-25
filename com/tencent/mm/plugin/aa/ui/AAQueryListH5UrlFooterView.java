package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ui.r;

public class AAQueryListH5UrlFooterView extends LinearLayout {
    TextView ipc;

    public AAQueryListH5UrlFooterView(Context context) {
        super(context);
        init(context);
    }

    public AAQueryListH5UrlFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AAQueryListH5UrlFooterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.ipc = (TextView) r.eC(context).inflate(R.i.cTw, this, true).findViewById(R.h.bmt);
    }
}
