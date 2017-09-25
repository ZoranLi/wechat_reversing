package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.model.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;

public class FaceProcessHintView extends LinearLayout {
    private h lCR;
    private int lCS;
    private Animation lCT;

    public FaceProcessHintView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceProcessHintView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lCR = null;
        this.lCS = 0;
        this.lCT = null;
        setOrientation(0);
        setMinimumHeight(b.a(getContext(), 36.0f));
        this.lCT = AnimationUtils.loadAnimation(context, a.lsj);
        this.lCT.setInterpolator(new AccelerateDecelerateInterpolator());
    }
}
