package android.support.v7.widget;

import android.graphics.Outline;

final class c extends b {
    public c(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public final void getOutline(Outline outline) {
        if (this.RH.RO) {
            if (this.RH.RN != null) {
                this.RH.RN.getOutline(outline);
            }
        } else if (this.RH.Qd != null) {
            this.RH.Qd.getOutline(outline);
        }
    }
}
