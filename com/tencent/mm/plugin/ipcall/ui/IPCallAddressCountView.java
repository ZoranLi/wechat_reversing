package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R;

public class IPCallAddressCountView extends FrameLayout {
    private View lmQ;
    private TextView mSJ;

    public IPCallAddressCountView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private IPCallAddressCountView(Context context) {
        super(context);
        init();
    }

    public IPCallAddressCountView(Context context, int i) {
        this(context);
        oo(i);
    }

    private void init() {
        inflate(getContext(), R.i.dfW, this);
        this.lmQ = findViewById(R.h.bES);
        this.mSJ = (TextView) findViewById(R.h.bER);
    }

    public final void oo(int i) {
        this.mSJ.setText(getContext().getResources().getQuantityString(R.j.dsg, i, new Object[]{Integer.valueOf(i)}));
    }
}
