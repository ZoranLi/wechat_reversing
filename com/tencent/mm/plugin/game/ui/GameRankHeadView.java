package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.l.b;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.w;

public class GameRankHeadView extends LinearLayout implements OnClickListener {
    TextView iUO;
    TextView mDV;
    private ImageView mDW;
    c mrp;
    TextView myV;
    b mzx;
    m mzz;

    public GameRankHeadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.iUO = (TextView) findViewById(R.h.bTL);
        this.mDV = (TextView) findViewById(R.h.bTx);
        this.myV = (TextView) findViewById(R.h.bTK);
        this.mDW = (ImageView) findViewById(R.h.bUA);
        w.i("MicroMsg.GameRankHeadView", "initView finished");
    }

    final void aCb() {
        if (g.a(getContext(), this.mrp)) {
            if (this.mrp.versionCode > com.tencent.mm.plugin.game.d.c.yc(this.mrp.field_packageName)) {
                this.myV.setText(R.l.eoA);
                return;
            } else {
                this.myV.setText(R.l.eoy);
                return;
            }
        }
        switch (this.mrp.status) {
            case 0:
                if (this.mzz == null) {
                    this.myV.setVisibility(8);
                    this.mDW.setVisibility(8);
                    return;
                }
                this.myV.setVisibility(0);
                this.mDW.setVisibility(0);
                switch (this.mzz.status) {
                    case 0:
                        this.myV.setText(R.l.eov);
                        return;
                    case 1:
                        this.myV.setText(R.l.eow);
                        return;
                    case 2:
                        this.myV.setText(R.l.eou);
                        return;
                    case 3:
                        this.myV.setText(R.l.eox);
                        return;
                    default:
                        return;
                }
            default:
                this.myV.setText(R.l.eov);
                return;
        }
    }

    public void onClick(View view) {
        new e(getContext()).a(this.mrp, new m(this.mrp));
    }
}
