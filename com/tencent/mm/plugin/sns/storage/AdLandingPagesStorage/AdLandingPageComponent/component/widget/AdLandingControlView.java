package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.ui.base.MMPageControlView;

public class AdLandingControlView extends MMPageControlView {
    public AdLandingControlView(Context context) {
        super(context);
    }

    public AdLandingControlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected final void tu(int i) {
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
                        this.fKf = (ImageView) View.inflate(this.context, this.vlf, null).findViewById(f.hcJ);
                        this.map.put(Integer.valueOf(i3), this.fKf);
                    }
                    this.fKf.setSelected(true);
                } else {
                    if (this.map.size() > i3) {
                        this.fKf = (ImageView) this.map.get(Integer.valueOf(i3));
                    }
                    if (this.fKf == null) {
                        this.fKf = (ImageView) View.inflate(this.context, this.vlf, null).findViewById(f.hcJ);
                        this.map.put(Integer.valueOf(i3), this.fKf);
                    }
                    this.fKf.setSelected(false);
                }
                addView(this.fKf);
            }
        }
    }
}
