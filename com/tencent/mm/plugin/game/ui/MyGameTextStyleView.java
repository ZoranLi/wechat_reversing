package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.c.x;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.widget.EllipsizingTextView;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.w;

public class MyGameTextStyleView extends LinearLayout implements OnClickListener {
    String appId;
    TextView iUO;
    Context mContext;
    TextView mFV;
    TextView mFW;
    EllipsizingTextView mFY;
    LinearLayout mFZ;
    ImageView mGa;
    ImageView mGb;
    LinearLayout mGc;
    ImageView mGd;
    RelativeLayout mGe;
    ImageView mGf;
    int mqT;

    public MyGameTextStyleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mFV = (TextView) findViewById(R.h.ckY);
        this.mFW = (TextView) findViewById(R.h.ckX);
        this.iUO = (TextView) findViewById(R.h.title);
        this.mFY = (EllipsizingTextView) findViewById(R.h.bHZ);
        this.mFY.setMaxLines(2);
        this.mFZ = (LinearLayout) findViewById(R.h.cFF);
        this.mGa = (ImageView) findViewById(R.h.bHy);
        this.mGb = (ImageView) findViewById(R.h.cFD);
        this.mGc = (LinearLayout) findViewById(R.h.cxm);
        this.mGd = (ImageView) findViewById(R.h.cxl);
        this.mGe = (RelativeLayout) findViewById(R.h.bsG);
        this.mGf = (ImageView) findViewById(R.h.bsE);
        w.i("MicroMsg.MyGameTextStyleView", "initView finished");
    }

    public void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof x)) {
            w.w("MicroMsg.MyGameTextStyleView", "jumpURL is null");
            return;
        }
        x xVar = (x) view.getTag();
        c.n(this.mContext, xVar.mts.msF, "game_center_mygame_comm");
        ai.a(this.mContext, 10, MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, xVar.mtq, 7, this.appId, this.mqT, ai.xR(xVar.msG));
    }
}
