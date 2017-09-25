package android.support.v4.view;

import android.view.WindowInsets;

final class aq extends ap {
    final WindowInsets zI;

    aq(WindowInsets windowInsets) {
        this.zI = windowInsets;
    }

    public final int getSystemWindowInsetLeft() {
        return this.zI.getSystemWindowInsetLeft();
    }

    public final int getSystemWindowInsetTop() {
        return this.zI.getSystemWindowInsetTop();
    }

    public final int getSystemWindowInsetRight() {
        return this.zI.getSystemWindowInsetRight();
    }

    public final int getSystemWindowInsetBottom() {
        return this.zI.getSystemWindowInsetBottom();
    }

    public final boolean isConsumed() {
        return this.zI.isConsumed();
    }

    public final ap ca() {
        return new aq(this.zI.consumeSystemWindowInsets());
    }

    public final ap d(int i, int i2, int i3, int i4) {
        return new aq(this.zI.replaceSystemWindowInsets(i, i2, i3, i4));
    }
}
