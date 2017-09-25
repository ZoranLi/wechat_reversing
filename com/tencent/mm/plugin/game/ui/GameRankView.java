package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.tencent.mm.R;

public class GameRankView extends FrameLayout {
    private Context mContext;
    ListView mEa;
    View mEb;
    q mEc;
    private GameRankFooter mEd;

    public GameRankView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mEa = (ListView) findViewById(R.h.bUQ);
        this.mEd = (GameRankFooter) View.inflate(this.mContext, R.i.dfh, null);
        GameRankFooter gameRankFooter = this.mEd;
        gameRankFooter.mDP.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ GameRankView mEe;

            {
                this.mEe = r1;
            }

            public final void onClick(View view) {
                q a = this.mEe.mEc;
                if (a.mDz.size() > a.mDC) {
                    if (a.mDC + 25 >= a.mDz.size()) {
                        a.mDC = a.mDz.size();
                        a.mDF.aBZ();
                        a.mDH = true;
                    } else {
                        a.mDC += 25;
                        a.mDF.aBY();
                    }
                    a.mDA = a.mDz.subList(0, a.mDC);
                    if (a.mDG || a.mDI <= a.mDC) {
                        a.mDF.aCa();
                    } else if (a.mDE != null) {
                        a.mDF.a(a.mDE);
                    } else {
                        a.mDF.aCa();
                    }
                    a.notifyDataSetChanged();
                }
            }
        });
        this.mEa.addFooterView(this.mEd);
        this.mEc = new q(this.mContext, this.mEd);
        this.mEb = findViewById(R.h.bUO);
    }
}
