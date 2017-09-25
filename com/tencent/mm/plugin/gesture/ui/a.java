package com.tencent.mm.plugin.gesture.ui;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gesture.ui.widget.PatternLockView;

final class a {
    TextView mIw = null;
    FrameLayout mIx = null;
    PatternLockView mIy = null;
    TextView mIz = null;
    View mView = null;

    public a(Activity activity) {
        this.mView = View.inflate(activity, R.i.dfL, null);
        this.mIw = (TextView) this.mView.findViewById(R.h.cKj);
        this.mIx = (FrameLayout) this.mView.findViewById(R.h.cqI);
        this.mIy = (PatternLockView) this.mView.findViewById(R.h.cqH);
        this.mIz = (TextView) this.mView.findViewById(R.h.cKc);
    }
}
