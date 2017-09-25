package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;

final class k extends j {
    private static final int[] PZ = new int[]{16843074};
    private final SeekBar UY;

    k(SeekBar seekBar, h hVar) {
        super(seekBar, hVar);
        this.UY = seekBar;
    }

    final void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        ap a = ap.a(this.UY.getContext(), attributeSet, PZ, i);
        Drawable bG = a.bG(0);
        if (bG != null) {
            this.UY.setThumb(bG);
        }
        a.aeG.recycle();
    }
}
