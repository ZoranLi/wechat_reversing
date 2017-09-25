package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.util.AttributeSet;
import android.view.View;

class ViewOffsetBehavior<V extends View> extends Behavior<V> {
    private z lG;
    private int lH = 0;
    private int lI = 0;

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean a(CoordinatorLayout coordinatorLayout, V v, int i) {
        d(coordinatorLayout, v, i);
        if (this.lG == null) {
            this.lG = new z(v);
        }
        this.lG.ay();
        if (this.lH != 0) {
            this.lG.f(this.lH);
            this.lH = 0;
        }
        if (this.lI != 0) {
            z zVar = this.lG;
            int i2 = this.lI;
            if (zVar.lM != i2) {
                zVar.lM = i2;
                zVar.az();
            }
            this.lI = 0;
        }
        return true;
    }

    protected void d(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.e(v, i);
    }

    public boolean f(int i) {
        if (this.lG != null) {
            return this.lG.f(i);
        }
        this.lH = i;
        return false;
    }

    public int I() {
        return this.lG != null ? this.lG.lL : 0;
    }
}
