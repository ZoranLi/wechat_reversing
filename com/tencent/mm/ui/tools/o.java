package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.w;

public final class o implements Runnable {
    public int mMode;
    public ListView ohI;
    public long wnS = System.currentTimeMillis();
    public int wnT;
    public int wnU;
    public int wnV;
    private final int wnW;
    public int wnX;

    public o(ListView listView) {
        this.ohI = listView;
        this.wnW = ViewConfiguration.get(this.ohI.getContext()).getScaledFadingEdgeLength();
        w.d("ScrollerRunnable", "mExtraScroll: %d", Integer.valueOf(this.wnW));
    }

    public final void run() {
        if (System.currentTimeMillis() - this.wnS <= 10000) {
            int height = this.ohI.getHeight();
            int firstVisiblePosition = this.ohI.getFirstVisiblePosition();
            int childCount;
            switch (this.mMode) {
                case 1:
                    childCount = this.ohI.getChildCount() - 1;
                    firstVisiblePosition += childCount;
                    if (childCount >= 0) {
                        if (firstVisiblePosition == this.wnU) {
                            if (this.wnX > 20) {
                                this.ohI.setSelection(this.wnT);
                                w.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
                            } else {
                                this.ohI.post(this);
                                this.wnX++;
                                w.d("ScrollerRunnable", "dz:try scroll lastpos = %d", Integer.valueOf(firstVisiblePosition));
                                return;
                            }
                        }
                        this.wnX = 0;
                        View childAt = this.ohI.getChildAt(childCount);
                        int height2 = childAt.getHeight();
                        childCount = height - childAt.getTop();
                        if (firstVisiblePosition < this.ohI.getCount() - 1) {
                            height = this.wnW;
                        } else {
                            height = this.ohI.getPaddingBottom();
                        }
                        this.ohI.smoothScrollBy(height + (height2 - childCount), this.wnV);
                        this.wnU = firstVisiblePosition;
                        if (firstVisiblePosition < this.wnT) {
                            this.ohI.post(this);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    if (firstVisiblePosition == this.wnU) {
                        if (this.wnX > 20) {
                            this.ohI.setSelection(this.wnT);
                            w.d("ScrollerRunnable", "dz:try scroll at same item more than 10, direct seletion");
                        } else {
                            this.ohI.post(this);
                            this.wnX++;
                            w.d("ScrollerRunnable", "dz:try scroll firstPos = %d", Integer.valueOf(firstVisiblePosition));
                            return;
                        }
                    }
                    this.wnX = 0;
                    View childAt2 = this.ohI.getChildAt(0);
                    if (childAt2 != null) {
                        childCount = childAt2.getTop();
                        if (firstVisiblePosition > 0) {
                            height = this.wnW;
                        } else {
                            height = this.ohI.getPaddingTop();
                        }
                        this.ohI.smoothScrollBy(childCount - height, this.wnV);
                        this.wnU = firstVisiblePosition;
                        if (firstVisiblePosition > this.wnT) {
                            this.ohI.post(this);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
