package android.support.v4.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

public class ContentLoadingProgressBar extends ProgressBar {
    private boolean Bh = false;
    private boolean Bi = false;
    private final Runnable Bj = new Runnable(this) {
        final /* synthetic */ ContentLoadingProgressBar Bl;

        {
            this.Bl = r1;
        }

        public final void run() {
            this.Bl.Bh = false;
            this.Bl.mStartTime = -1;
            this.Bl.setVisibility(8);
        }
    };
    private final Runnable Bk = new Runnable(this) {
        final /* synthetic */ ContentLoadingProgressBar Bl;

        {
            this.Bl = r1;
        }

        public final void run() {
            this.Bl.Bi = false;
            if (!this.Bl.oN) {
                this.Bl.mStartTime = System.currentTimeMillis();
                this.Bl.setVisibility(0);
            }
        }
    };
    private long mStartTime = -1;
    private boolean oN = false;

    public ContentLoadingProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        cl();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        cl();
    }

    private void cl() {
        removeCallbacks(this.Bj);
        removeCallbacks(this.Bk);
    }
}
