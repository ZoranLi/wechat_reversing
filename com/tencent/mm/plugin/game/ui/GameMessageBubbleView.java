package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.plugin.game.model.q;
import com.tencent.mm.plugin.game.model.q.d;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class GameMessageBubbleView extends LinearLayout implements OnClickListener {
    private Context mContext;
    View mDf;
    private TextView mDg;
    private ImageView mDh;
    private q mDi;
    private final long mDj = 500;
    private long mDk = 0;
    private boolean mHasInit = false;

    public GameMessageBubbleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        if (!this.mHasInit) {
            this.mDh = (ImageView) findViewById(R.h.bUC);
            this.mDg = (TextView) findViewById(R.h.bUB);
            this.mDf = findViewById(R.h.bUD);
            setVisibility(8);
            this.mHasInit = true;
        }
    }

    public final void aBX() {
        SubCoreGameCenter.aBC();
        this.mDi = t.aAS();
        if (this.mDi == null) {
            this.mDf.setOnClickListener(null);
            setVisibility(8);
            return;
        }
        this.mDi.aAN();
        if (this.mDi.field_msgType == 100 && (bg.mA(this.mDi.mpT.gMv) || bg.mA(this.mDi.mpT.mqE) || bg.mA(this.mDi.mpT.mqF) || !this.mDi.mpU.containsKey(this.mDi.mpT.mqF))) {
            w.w("MicroMsg.GameMessageHeaderView", "bubble is invalid");
            this.mDf.setOnClickListener(null);
            setVisibility(8);
            return;
        }
        this.mDg.setText(this.mDi.mpT.gMv);
        n.GW().a(this.mDi.mpT.mqE, this.mDh);
        this.mDf.setOnClickListener(this);
        setVisibility(0);
    }

    public void onClick(View view) {
        if (System.currentTimeMillis() - this.mDk > 500 && this.mDi != null) {
            SubCoreGameCenter.aBC();
            t.aAT();
            int a;
            if (this.mDi.field_msgType == 100) {
                if (!bg.mA(this.mDi.mpT.mqF)) {
                    d dVar = (d) this.mDi.mpU.get(this.mDi.mpT.mqF);
                    if (dVar != null) {
                        a = r.a(this.mContext, this.mDi, dVar, this.mDi.field_appId, MMBitmapFactory.ERROR_IMAGE_SIZE_IS_TOO_LARGE);
                        if (a != 0) {
                            ai.a(this.mContext, 10, MMBitmapFactory.ERROR_IMAGE_SIZE_IS_TOO_LARGE, 1, a, 0, this.mDi.field_appId, 0, this.mDi.mqy, this.mDi.field_gameMsgId, this.mDi.mqz, null);
                        }
                        if (dVar.mqH != 4) {
                            this.mDi.field_isRead = true;
                            SubCoreGameCenter.aBB().c(this.mDi, new String[0]);
                        }
                    }
                }
                this.mDk = System.currentTimeMillis();
                return;
            }
            if (!(this.mDi == null || this.mDi.mpW == 3)) {
                this.mDi.field_isRead = true;
                SubCoreGameCenter.aBB().c(this.mDi, new String[0]);
            }
            switch (this.mDi.mpW) {
                case 1:
                    String str = this.mDi.mpI;
                    if (!bg.mA(str)) {
                        c.n(this.mContext, str, "game_center_bubble");
                    }
                    a = 7;
                    break;
                case 2:
                    if (!bg.mA(this.mDi.field_appId)) {
                        Bundle bundle = new Bundle();
                        bundle.putCharSequence("game_app_id", this.mDi.field_appId);
                        bundle.putInt("game_report_from_scene", MMBitmapFactory.ERROR_IMAGE_SIZE_IS_TOO_LARGE);
                        a = c.a(this.mContext, this.mDi.field_appId, null, bundle);
                        break;
                    }
                    w.e("MicroMsg.GameMessageHeaderView", "message type : " + this.mDi.field_msgType + " ,message.field_appId is null.");
                    a = 0;
                    break;
                case 3:
                    Intent intent = new Intent(this.mContext, GameMessageUI.class);
                    intent.putExtra("game_report_from_scene", MMBitmapFactory.ERROR_IMAGE_SIZE_IS_TOO_LARGE);
                    this.mContext.startActivity(intent);
                    a = 6;
                    break;
                default:
                    w.e("MicroMsg.GameMessageHeaderView", "unknown bubble_action = " + this.mDi.mpW);
                    return;
            }
            ai.a(this.mContext, 10, MMBitmapFactory.ERROR_IMAGE_SIZE_IS_TOO_LARGE, 1, a, 0, this.mDi.field_appId, 0, this.mDi.field_msgType, this.mDi.field_gameMsgId, this.mDi.mqz, null);
            this.mDk = System.currentTimeMillis();
        }
    }
}
