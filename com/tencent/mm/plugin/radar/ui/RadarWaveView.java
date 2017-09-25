package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.mm.sdk.platformtools.w;

public class RadarWaveView extends RelativeLayout {
    MediaPlayer oJH = null;
    View oJI;
    Animation oJJ;

    public RadarWaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void aVW() {
        w.d("MicroMsg.RadarWaveView", "start wave animation");
        setVisibility(0);
        this.oJI.startAnimation(this.oJJ);
    }

    public final void aVX() {
        w.d("MicroMsg.RadarWaveView", "stop wave animation. forces, %d, %d", new Object[]{Integer.valueOf(getMeasuredHeight()), Integer.valueOf(getMeasuredWidth())});
        setVisibility(4);
        this.oJI.clearAnimation();
    }
}
