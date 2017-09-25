package android.support.v7.widget;

import android.content.Context;
import android.support.v7.a.a.a;
import android.util.AttributeSet;
import android.widget.SeekBar;

public class AppCompatSeekBar extends SeekBar {
    private k UX;
    private h Um;

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.seekBarStyle);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Um = h.ey();
        this.UX = new k(this, this.Um);
        this.UX.a(attributeSet, i);
    }
}
