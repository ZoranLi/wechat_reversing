package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.model.q.h;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.LinkedList;

public class GameMessageListContainerView extends LinearLayout {
    private Context mContext;

    public GameMessageListContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    public final void a(q qVar, LinkedList<h> linkedList, int i, int i2, f<String, Bitmap> fVar) {
        if (qVar == null || bg.bV(linkedList)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        int i3 = i > linkedList.size() ? 1 : 2;
        int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.aWA);
        while (getChildCount() < i3) {
            View gameMessageListUserIconView = new GameMessageListUserIconView(this.mContext);
            if (getChildCount() > 0) {
                gameMessageListUserIconView.setPadding(0, dimensionPixelSize, 0, 0);
            }
            if (gameMessageListUserIconView.mCO != null) {
                gameMessageListUserIconView.mCO.mqT = i2;
            } else {
                gameMessageListUserIconView.mCO = new r(gameMessageListUserIconView.mContext, i2);
            }
            addView(gameMessageListUserIconView);
        }
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (i4 < i3) {
                getChildAt(i4).setVisibility(0);
                GameMessageListUserIconView gameMessageListUserIconView2 = (GameMessageListUserIconView) getChildAt(i4);
                LinkedList linkedList2 = new LinkedList();
                int i5 = i4 * i;
                while (i5 < (i4 + 1) * i && i5 < linkedList.size()) {
                    linkedList2.add(linkedList.get(i5));
                    i5++;
                }
                gameMessageListUserIconView2.a(qVar, linkedList2, fVar);
            } else {
                getChildAt(i4).setVisibility(8);
            }
        }
    }
}
