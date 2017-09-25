package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.a;
import com.tencent.mm.plugin.game.model.ai;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.w;

public class GameInfoView extends RelativeLayout implements OnClickListener {
    private int gLo = 0;
    FrameLayout mBa;
    ImageView mBb;
    private TextView mBc;
    FrameLayout mBd;
    ImageView mBe;
    ImageView mBf;
    ImageView mBg;
    RelativeLayout mBh;
    ImageView mBi;
    TextView mBj;
    ImageView mBk;
    String mBl = "";
    String mBm = "";
    String mBn = "";
    ImageView mBo;
    String mBp = "";
    private int mBq = 1;
    private int mBr = 2;
    private int mBs = 3;
    int mBt = 4;
    String mBu;
    Context mContext;
    int mqT = 0;

    public GameInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mBh = (RelativeLayout) findViewById(R.h.bSJ);
        this.mBh.setOnClickListener(this);
        this.mBi = (ImageView) findViewById(R.h.csX);
        this.mBj = (TextView) findViewById(R.h.ctl);
        this.mBk = (ImageView) findViewById(R.h.brn);
        this.mBa = (FrameLayout) findViewById(R.h.bUG);
        this.mBa.setOnClickListener(this);
        this.mBb = (ImageView) findViewById(R.h.cjO);
        this.mBc = (TextView) findViewById(R.h.bUI);
        this.mBd = (FrameLayout) findViewById(R.h.bTY);
        this.mBd.setOnClickListener(this);
        this.mBe = (ImageView) findViewById(R.h.bVo);
        this.mBf = (ImageView) findViewById(R.h.bVp);
        this.mBo = (ImageView) findViewById(R.h.cAE);
        this.mBg = (ImageView) findViewById(R.h.cAK);
        this.mBg.setOnClickListener(this);
        w.i("MicroMsg.GameInfoView", "initView finished");
    }

    public final void aBS() {
        this.gLo = SubCoreGameCenter.aBB().aAY();
        if (this.gLo > 0 && this.gLo <= 99) {
            this.mBc.setVisibility(0);
            this.mBc.setText(this.gLo);
        } else if (this.gLo > 99) {
            this.mBc.setVisibility(0);
            this.mBc.setText("99+");
            this.mBc.setTextSize(1, 9.0f);
        } else {
            this.mBc.setVisibility(8);
        }
    }

    public void onClick(View view) {
        int i = 7;
        int id = view.getId();
        if (id == R.h.bSJ) {
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                c.n(this.mContext, (String) view.getTag(), "game_center_profile");
                ai.a(this.mContext, 10, (int) MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, this.mBt, 7, this.mqT, this.mBu);
            }
        } else if (id == R.h.bUG) {
            if (view.getTag() == null || !(view.getTag() instanceof String)) {
                r0 = a.aAw();
                if (r0.fRW == 2) {
                    c.n(this.mContext, r0.url, "game_center_msgcenter");
                } else {
                    r0 = new Intent(this.mContext, GameMessageUI.class);
                    r0.putExtra("game_report_from_scene", MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
                    r0.putExtra("game_unread_msg_count", this.gLo);
                    r0.putExtra("game_manage_url", this.mBp);
                    this.mContext.startActivity(r0);
                    i = 6;
                }
            } else {
                c.n(this.mContext, (String) view.getTag(), "game_center_msgcenter");
            }
            if (this.mBc.getVisibility() == 0) {
                r11 = ai.co("resource", "5");
            } else {
                r11 = null;
            }
            ai.a(this.mContext, 10, MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, this.mBr, i, 0, null, this.mqT, 0, null, null, r11);
        } else if (id == R.h.bTY) {
            if (view.getTag() != null && (view.getTag() instanceof String)) {
                c.n(this.mContext, (String) view.getTag(), "game_center_giftcenter");
                if (this.mBf.getVisibility() == 0) {
                    r11 = ai.co("resource", "5");
                } else {
                    r11 = null;
                }
                ai.a(this.mContext, 10, MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, this.mBs, 7, 0, null, this.mqT, 0, null, null, r11);
            }
        } else if (id == R.h.cAK) {
            if (view.getTag() == null || !(view.getTag() instanceof String)) {
                r0 = a.aAw();
                if (r0.fRW == 2) {
                    c.n(this.mContext, r0.url, "game_center_msgcenter");
                } else {
                    r0 = new Intent(this.mContext, GameSearchUI.class);
                    r0.putExtra("game_report_from_scene", MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
                    this.mContext.startActivity(r0);
                    i = 6;
                }
            } else {
                c.n(this.mContext, (String) view.getTag(), "game_center_msgcenter");
            }
            ai.a(this.mContext, 14, 1401, 1, i, 0, null, this.mqT, 0, null, null, null);
        }
    }
}
