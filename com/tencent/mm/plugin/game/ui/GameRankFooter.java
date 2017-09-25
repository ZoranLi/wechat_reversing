package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.game.ui.q.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public class GameRankFooter extends LinearLayout {
    private Context mContext;
    TextView mDP;
    private View mDQ;
    private TextView mDR;
    private ImageView mDS;
    private TextView mDT;
    private TextView mDU;
    private boolean mHasInit = false;

    public GameRankFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        if (!this.mHasInit) {
            init();
            this.mHasInit = true;
        }
    }

    public final void aBY() {
        this.mDP.setVisibility(0);
    }

    public final void aBZ() {
        this.mDP.setVisibility(8);
    }

    public final void a(a aVar) {
        if (this.mHasInit && this.mDQ.getVisibility() != 0) {
            this.mDQ.setVisibility(0);
            ap.yY();
            af Rc = c.wR().Rc(aVar.fSf);
            if (Rc != null) {
                b.a(this.mDS, Rc.field_username);
                this.mDT.setText(h.b(this.mContext, Rc.tL(), this.mDT.getTextSize()));
            }
            this.mDR.setText(aVar.mre);
            this.mDU.setText(bg.formatNumber(aVar.mal));
        }
    }

    public final void aCa() {
        if (this.mDQ != null && this.mDQ.getVisibility() != 8) {
            this.mDQ.setVisibility(8);
        }
    }

    private void init() {
        this.mDP = (TextView) findViewById(R.h.cbF);
        this.mDQ = findViewById(R.h.cmi);
        this.mDR = (TextView) findViewById(R.h.cvg);
        this.mDS = (ImageView) findViewById(R.h.cLe);
        this.mDT = (TextView) findViewById(R.h.cLg);
        this.mDU = (TextView) findViewById(R.h.cLk);
    }
}
