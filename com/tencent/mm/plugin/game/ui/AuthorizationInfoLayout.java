package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Iterator;

public class AuthorizationInfoLayout extends LinearLayout {
    private Context mContext;
    private ArrayList<String> mwe;

    private static class a extends LinearLayout {
        private String iNZ;
        private Context mContext;

        public a(Context context, String str) {
            super(context);
            this.mContext = context;
            this.iNZ = str;
            setGravity(16);
            setOrientation(0);
            setLayoutParams(new LayoutParams(-1, -2));
            View textView = new TextView(this.mContext);
            textView.setText(this.iNZ);
            textView.setTextSize(1, 16.0f * com.tencent.mm.bg.a.dI(this.mContext));
            textView.setTextColor(Color.parseColor("#737373"));
            textView.setGravity(16);
            textView.setCompoundDrawablesWithIntrinsicBounds(R.g.bid, 0, 0, 0);
            textView.setCompoundDrawablePadding(20);
            ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
            layoutParams.leftMargin = 10;
            textView.setLayoutParams(layoutParams);
            addView(textView);
        }
    }

    public AuthorizationInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public final void F(ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            w.i("MicroMsg.AuthorizationInfoLayout", "authinfo is null or nill");
            return;
        }
        this.mwe = arrayList;
        Iterator it = this.mwe.iterator();
        while (it.hasNext()) {
            addView(new a(this.mContext, (String) it.next()));
        }
    }
}
