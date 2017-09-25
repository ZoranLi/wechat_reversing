package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class b extends Drawable {
    final ActionBarContainer RH;

    public b(ActionBarContainer actionBarContainer) {
        this.RH = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.RH.RO) {
            if (this.RH.Qd != null) {
                this.RH.Qd.draw(canvas);
            }
            if (this.RH.RM != null && this.RH.RP) {
                this.RH.RM.draw(canvas);
            }
        } else if (this.RH.RN != null) {
            this.RH.RN.draw(canvas);
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
