package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.s.a.g;
import com.tencent.mm.s.a.h;
import java.util.HashMap;
import java.util.Map;

public class MMPageControlView extends LinearLayout {
    public Context context;
    public int count;
    public ImageView fKf;
    public Map<Integer, ImageView> map = new HashMap();
    public int vlf = h.heI;

    public final void dY(int i, int i2) {
        this.count = i;
        tu(i2);
    }

    public MMPageControlView(Context context) {
        super(context);
        this.context = context;
    }

    public MMPageControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public void tu(int i) {
        removeAllViews();
        if (i < this.count) {
            int i2 = this.count;
            for (int i3 = 0; i3 < i2; i3++) {
                this.fKf = null;
                if (i == i3) {
                    if (this.map.size() > i3) {
                        this.fKf = (ImageView) this.map.get(Integer.valueOf(i3));
                    }
                    if (this.fKf == null) {
                        this.fKf = (ImageView) View.inflate(this.context, this.vlf, null).findViewById(g.hcJ);
                        this.map.put(Integer.valueOf(i3), this.fKf);
                    }
                    this.fKf.setSelected(true);
                } else {
                    if (this.map.size() > i3) {
                        this.fKf = (ImageView) this.map.get(Integer.valueOf(i3));
                    }
                    if (this.fKf == null) {
                        this.fKf = (ImageView) View.inflate(this.context, this.vlf, null).findViewById(g.hcJ);
                        this.map.put(Integer.valueOf(i3), this.fKf);
                    }
                    this.fKf.setSelected(false);
                }
                if (i3 == 0) {
                    this.fKf.setPadding(0, 0, 0, 0);
                }
                addView(this.fKf);
            }
        }
    }
}
