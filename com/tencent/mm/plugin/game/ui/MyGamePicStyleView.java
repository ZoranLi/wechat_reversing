package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.x;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.w;

public class MyGamePicStyleView extends LinearLayout implements OnClickListener {
    String appId;
    Context mContext;
    TextView mFV;
    TextView mFW;
    ImageView mFX;
    int mqT;

    public MyGamePicStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mFV = (TextView) findViewById(R.h.ckY);
        this.mFW = (TextView) findViewById(R.h.ckX);
        this.mFX = (ImageView) findViewById(R.h.crH);
        w.i("MicroMsg.MyGamePicStyleView", "initView finished");
    }

    public void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof x)) {
            w.w("MicroMsg.MyGamePicStyleView", "jumpURL is null");
            return;
        }
        x xVar = (x) view.getTag();
        c.n(this.mContext, xVar.mtt.msF, "game_center_mygame_comm");
        ai.a(this.mContext, 10, MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, xVar.mtq, 7, this.appId, this.mqT, ai.xR(xVar.msG));
    }
}
