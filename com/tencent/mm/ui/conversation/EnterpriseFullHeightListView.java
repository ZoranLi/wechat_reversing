package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;

public class EnterpriseFullHeightListView extends ListView {
    private int kpi = 0;
    public boolean wdN = true;
    private View wdO;

    public EnterpriseFullHeightListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EnterpriseFullHeightListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (!this.wdN) {
            if (!this.wdN) {
                int i5;
                int headerViewsCount = getHeaderViewsCount();
                int count = getAdapter().getCount();
                int i6;
                if (this.wdO != null) {
                    i6 = count - 1;
                    count = 0;
                    i5 = headerViewsCount;
                    headerViewsCount = i6;
                } else {
                    i6 = count;
                    count = 0;
                    i5 = headerViewsCount;
                    headerViewsCount = i6;
                }
                while (i5 < headerViewsCount) {
                    if (this.kpi <= 0) {
                        try {
                            View view = getAdapter().getView(i5, null, this);
                            view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                            this.kpi = view.getMeasuredHeight();
                        } catch (Exception e) {
                        }
                    }
                    try {
                        count += this.kpi;
                        if (count <= i2) {
                            i5++;
                        } else if (this.wdO != null) {
                            removeFooterView(this.wdO);
                            this.wdO = null;
                            return;
                        } else {
                            return;
                        }
                    } catch (Exception e2) {
                        return;
                    }
                }
                if (count < i2) {
                    if (this.wdO == null) {
                        this.wdO = new View(getContext());
                    }
                    removeFooterView(this.wdO);
                    this.wdO.setLayoutParams(new LayoutParams(-1, i2 - count));
                    addFooterView(this.wdO, null, false);
                }
            }
        }
    }
}
