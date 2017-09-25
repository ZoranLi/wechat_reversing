package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.a.a;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.w;

public class GameInfoViewForeign extends RelativeLayout {
    private int gLo = 0;
    private int mBr = 2;
    private TextView mBv;
    private OnClickListener mBw = new OnClickListener(this) {
        final /* synthetic */ GameInfoViewForeign mBx;

        {
            this.mBx = r1;
        }

        public final void onClick(View view) {
            int i = 7;
            if (view.getTag() == null || !(view.getTag() instanceof String)) {
                a aAw = com.tencent.mm.plugin.game.model.a.aAw();
                if (aAw.fRW == 2) {
                    c.n(this.mBx.mContext, aAw.url, "game_center_msgcenter");
                } else {
                    Intent intent = new Intent(this.mBx.mContext, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
                    this.mBx.mContext.startActivity(intent);
                    i = 6;
                }
            } else {
                c.n(this.mBx.mContext, (String) view.getTag(), "game_center_msgcenter");
            }
            ai.a(this.mBx.mContext, 10, MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, this.mBx.mBr, i, 0, null, this.mBx.mqT, 0, null, null, ai.co("resource", "5"));
        }
    };
    private Context mContext;
    int mqT = 0;

    public GameInfoViewForeign(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setOnClickListener(this.mBw);
        this.mBv = (TextView) findViewById(R.h.bUI);
        aBS();
        w.i("MicroMsg.GameInfoViewForeign", "initView finished");
    }

    public final void aBS() {
        this.gLo = SubCoreGameCenter.aBB().aAY();
        if (this.gLo > 0 && this.gLo <= 99) {
            this.mBv.setVisibility(0);
            this.mBv.setText(this.gLo);
        } else if (this.gLo > 99) {
            this.mBv.setVisibility(0);
            this.mBv.setText("99+");
            this.mBv.setTextSize(1, 9.0f);
        } else {
            this.mBv.setVisibility(4);
        }
    }
}
