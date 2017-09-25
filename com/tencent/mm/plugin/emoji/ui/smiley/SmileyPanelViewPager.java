package com.tencent.mm.plugin.emoji.ui.smiley;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.u;
import android.util.AttributeSet;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.CustomViewPager;

public class SmileyPanelViewPager extends CustomViewPager {
    private final String TAG = "MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager";
    f kTE;
    private int kVA = 0;
    private int kVB = 0;
    a kVy;
    private boolean kVz = j.aF(getContext());

    public interface a {
        void lz(int i);
    }

    public SmileyPanelViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (bg.getInt(VERSION.SDK, 0) >= 9) {
            setOverScrollMode(2);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager", "alvinluo w: %d, h: %d, oldw: %d, oldh: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        boolean aF = j.aF(getContext());
        if (this.kTE != null && (((i > 0 && i3 != i) || (i2 > 0 && i4 != i2)) && ((i2 > 0 && i2 != this.kVA) || (i > 0 && i != this.kVB)))) {
            if (this.kTE.kUW <= 0) {
                this.kTE.lB(i2);
            }
            this.kTE.kUX = i;
            this.kTE.kUT = 0;
            if (!(this.kVy == null || (this.kTE.kVk && !this.kTE.kVl && this.kVz == aF))) {
                w.d("MicroMsg.emoji.SmileyPanel.SmileyPanelViewPager", "need deal cache size.");
                this.kTE.kVl = false;
                this.kVy.lz(i2);
            }
        }
        this.kVz = aF;
        if (i2 > 0) {
            this.kVA = i2;
        }
        if (i > 0) {
            this.kVB = i;
        }
    }

    public final void a(u uVar) {
        super.a(uVar);
    }

    public final void a(g gVar) {
        if (gVar != null) {
            gVar.aos();
            gVar.kVC = false;
        }
        super.a(gVar);
    }
}
