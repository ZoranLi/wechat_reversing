package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;

public final class h extends BaseSmallView {
    private TextView lle = ((TextView) findViewById(R.h.cOO));

    public h(Context context) {
        super(context, null);
        LayoutInflater.from(context).inflate(R.i.dpQ, this);
    }

    public final void HF(String str) {
        this.lle.setTextSize(1, 14.0f);
        this.lle.setText(str);
    }

    public final void HE(String str) {
        this.lle.setTextSize(1, 12.0f);
        this.lle.setText(str);
    }

    public final void a(CaptureView captureView) {
    }

    protected final void brc() {
    }

    protected final void brd() {
    }

    protected final void onAnimationEnd() {
    }
}
