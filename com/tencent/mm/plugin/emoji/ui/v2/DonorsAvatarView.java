package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.bg.a;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.protocal.c.pk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;

public class DonorsAvatarView extends LinearLayout {
    private int kWh;
    private int kWi;
    private int kWj;
    private int kWk;
    private LayoutParams kWl;
    private int mMaxCount;

    public DonorsAvatarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public DonorsAvatarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setOrientation(0);
        this.kWh = a.dO(getContext());
        this.kWi = a.T(getContext(), R.f.aZB);
        this.kWj = a.T(getContext(), R.f.aWA);
        this.kWk = a.T(getContext(), R.f.aXH);
        this.kWl = new LayoutParams(this.kWi, this.kWi);
        this.kWl.leftMargin = this.kWj;
        this.kWl.rightMargin = this.kWj;
        this.mMaxCount = (this.kWh - (this.kWk * 2)) / (this.kWi + (this.kWj * 2));
        w.i("MicroMsg.emoji.DonorsAvatarView", "max count:%d", new Object[]{Integer.valueOf(this.mMaxCount)});
    }

    public final void b(String str, LinkedList<pk> linkedList) {
        removeAllViews();
        if (linkedList != null && linkedList.size() > 0) {
            int size = linkedList.size() > this.mMaxCount ? this.mMaxCount : linkedList.size();
            for (int i = 0; i < size; i++) {
                pk pkVar = (pk) linkedList.get(i);
                if (pkVar != null) {
                    View imageView = new ImageView(getContext());
                    imageView.setLayoutParams(this.kWl);
                    if (bg.mA(pkVar.tvr)) {
                        try {
                            imageView.setImageBitmap(b.a(ab.getContext().getAssets().open("avatar/default_nor_avatar.png"), a.getDensity(null)));
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.emoji.DonorsAvatarView", e, "", new Object[0]);
                        }
                    } else {
                        n.GW().a(pkVar.tvr, imageView, f.g(str, pkVar.tvr, new Object[0]));
                    }
                    addView(imageView);
                }
            }
        }
    }
}
