package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.ui.base.MMFrameLayout;
import java.util.ArrayList;

public class PhotosContent extends MMFrameLayout {
    public ArrayList<TagImageView> qwg = new ArrayList();
    private float qwh;
    private int qwi = 120;

    public final void bjz() {
        this.qwg.clear();
    }

    public final void a(TagImageView tagImageView) {
        this.qwg.add(tagImageView);
    }

    public final void tQ(int i) {
        if (i > 0) {
            this.qwh = getResources().getDisplayMetrics().density;
            this.qwi = (int) (((float) this.qwi) * this.qwh);
            if (i >= this.qwi) {
                i = this.qwi;
            }
            for (int i2 = 0; i2 < this.qwg.size(); i2++) {
                View childAt = getChildAt(i2);
                MarginLayoutParams marginLayoutParams = new MarginLayoutParams(childAt.getLayoutParams());
                marginLayoutParams.width = i;
                marginLayoutParams.height = i;
                marginLayoutParams.leftMargin = (int) (((float) (i2 % 3)) * (((float) i) + (this.qwh * 3.0f)));
                marginLayoutParams.topMargin = (int) (((float) (i2 / 3)) * (((float) i) + (this.qwh * 3.0f)));
                LayoutParams layoutParams = new FrameLayout.LayoutParams(marginLayoutParams);
                layoutParams.gravity = 51;
                childAt.setLayoutParams(layoutParams);
            }
            int size = this.qwg.size() / 3;
            if (size > 0) {
                MarginLayoutParams marginLayoutParams2 = (MarginLayoutParams) getLayoutParams();
                marginLayoutParams2.height = (int) ((((float) (size - 1)) * (this.qwh * 3.0f)) + ((float) (i * size)));
                setLayoutParams(marginLayoutParams2);
            }
        }
    }

    public final TagImageView tR(int i) {
        if (i < this.qwg.size()) {
            return (TagImageView) this.qwg.get(i);
        }
        return null;
    }

    public PhotosContent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
