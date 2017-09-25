package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;

public class GameLibraryCategoriesView extends LinearLayout implements OnClickListener {
    private LinearLayout lJu;
    private int mBM;
    private int mBN;
    private Context mContext;
    int mqT;

    public static class a {
        public String jhe;
        public int mBO;
        public String mBP;
        public String mBQ;
        public int position;
    }

    public GameLibraryCategoriesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.lJu = (LinearLayout) findViewById(R.h.bUq);
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        this.mBM = (width * 100) / 750;
        this.mBN = (width - (this.mBM * 6)) / 14;
        this.lJu.setPadding(this.mBN, com.tencent.mm.bg.a.fromDPToPix(this.mContext, 12), this.mBN, com.tencent.mm.bg.a.fromDPToPix(this.mContext, 12));
    }

    public final void H(LinkedList<a> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            w.e("MicroMsg.GameLibraryCategoriesView", "No categories");
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.lJu.removeAllViews();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            View linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            View imageView = new ImageView(this.mContext);
            ScaleType scaleType = ScaleType.MATRIX;
            imageView.setScaleType(ScaleType.FIT_XY);
            com.tencent.mm.ah.a.a GW = n.GW();
            String str = aVar.jhe;
            com.tencent.mm.ah.a.a.c.a aVar2 = new com.tencent.mm.ah.a.a.c.a();
            aVar2.hIK = true;
            GW.a(str, imageView, aVar2.Hg());
            linearLayout.addView(imageView, this.mBM, this.mBM);
            imageView = new TextView(this.mContext);
            imageView.setText(aVar.mBP);
            imageView.setTextSize(1, 14.0f);
            imageView.setTextColor(getResources().getColor(R.e.aUo));
            imageView.setSingleLine(true);
            imageView.setEllipsize(TruncateAt.END);
            imageView.setGravity(17);
            imageView.setLayoutParams(new LayoutParams(-1, -2));
            imageView.setPadding(0, com.tencent.mm.bg.a.fromDPToPix(this.mContext, 6), 0, 0);
            linearLayout.addView(imageView);
            linearLayout.setTag(aVar);
            linearLayout.setOnClickListener(this);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(this.mBN, 0, this.mBN, 0);
            this.lJu.addView(linearLayout, layoutParams);
        }
    }

    public void onClick(View view) {
        if (view.getTag() instanceof a) {
            a aVar = (a) view.getTag();
            int i = 7;
            if (bg.mA(aVar.mBQ)) {
                Intent intent = new Intent(this.mContext, GameCategoryUI.class);
                intent.putExtra("extra_type", 1);
                intent.putExtra("extra_category_id", aVar.mBO);
                intent.putExtra("extra_category_name", aVar.mBP);
                intent.putExtra("game_report_from_scene", aVar.mBO + 100);
                this.mContext.startActivity(intent);
                i = 6;
            } else {
                c.aa(this.mContext, aVar.mBQ);
            }
            ai.a(this.mContext, 11, aVar.mBO + 100, aVar.position, i, this.mqT, null);
        }
    }
}
