package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.ch;
import com.tencent.mm.plugin.game.c.ci;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.sdk.platformtools.bg;

public class GameClassifyView extends LinearLayout implements OnClickListener {
    private LinearLayout lJu;
    private Context mContext;
    private int mqT;
    private LayoutInflater myo;

    private static class a {
        public String extInfo;
        public int position;
        public String url;

        public a(String str, int i, String str2) {
            this.url = str;
            this.position = i;
            this.extInfo = str2;
        }
    }

    public GameClassifyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.myo = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        this.lJu = (LinearLayout) findViewById(R.h.bUv);
    }

    public final void a(ci ciVar, int i, int i2) {
        if (ciVar == null || bg.bV(ciVar.muY)) {
            setVisibility(8);
            return;
        }
        this.mqT = i2;
        if (this.myo == null) {
            this.myo = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        }
        while (this.lJu.getChildCount() < ciVar.muY.size()) {
            LinearLayout linearLayout = (LinearLayout) this.myo.inflate(R.i.deo, this, false);
            linearLayout.setOnClickListener(this);
            this.lJu.addView(linearLayout, new LayoutParams(-2, -2, 1.0f));
        }
        for (int i3 = 0; i3 < this.lJu.getChildCount(); i3++) {
            if (i3 < ciVar.muY.size()) {
                this.lJu.getChildAt(i3).setVisibility(0);
            } else {
                this.lJu.getChildAt(i3).setVisibility(8);
            }
        }
        for (int i4 = 0; i4 < ciVar.muY.size(); i4++) {
            linearLayout = (LinearLayout) this.lJu.getChildAt(i4);
            TextView textView = (TextView) linearLayout.findViewById(R.h.bSM);
            e.aCi().f((ImageView) linearLayout.findViewById(R.h.bSL), ((ch) ciVar.muY.get(i4)).muU);
            textView.setText(((ch) ciVar.muY.get(i4)).fDC);
            linearLayout.setTag(new a(((ch) ciVar.muY.get(i4)).msF, i4 + 1, ((ch) ciVar.muY.get(i4)).msG));
        }
        setVisibility(0);
        if (i == 2) {
            ai.a(this.mContext, 1019, 1, null, this.mqT, null);
        }
    }

    public void onClick(View view) {
        if (view.getTag() != null && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            if (!bg.mA(aVar.url)) {
                c.aa(this.mContext, aVar.url);
                ai.a(this.mContext, 10, 1019, aVar.position, 7, null, this.mqT, aVar.extInfo);
            }
        }
    }
}
