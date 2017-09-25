package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;

public final class f {
    private MMActivity kdb;
    private View khv;
    private b kiy;
    private int kmX;
    private View kmY;
    private TextView kmZ;
    private TextView kna;
    private ImageView knb;
    private ImageView[] knc = new ImageView[3];
    private TextView knd;
    private ImageView kne;

    public f(MMActivity mMActivity, View view, int i, b bVar) {
        this.kdb = mMActivity;
        this.khv = view;
        this.kmX = i;
        this.kiy = bVar;
        this.kmY = this.khv.findViewById(R.h.bxn);
        this.kmZ = (TextView) this.khv.findViewById(R.h.bxp);
        this.kna = (TextView) this.khv.findViewById(R.h.bxo);
        this.knd = (TextView) this.khv.findViewById(R.h.bxO);
        this.knb = (ImageView) this.khv.findViewById(R.h.bxq);
        this.knc[0] = (ImageView) this.khv.findViewById(R.h.bxk);
        this.knc[1] = (ImageView) this.khv.findViewById(R.h.bxl);
        this.knc[2] = (ImageView) this.khv.findViewById(R.h.bxm);
        this.kne = (ImageView) this.khv.findViewById(R.h.byg);
        if (this.kmX == 1) {
            this.kmZ.setText(this.kdb.getString(R.l.dRk, new Object[]{Integer.valueOf(0)}));
            this.knb.setImageResource(R.g.bdr);
        } else if (this.kmX == 2) {
            this.kmZ.setText(R.l.dRT);
            this.knb.setImageResource(R.g.bdw);
        } else if (this.kmX == 3) {
            this.kmZ.setText(this.kdb.getString(R.l.dSq, new Object[]{Integer.valueOf(b.agt())}));
            this.knb.setImageResource(R.g.bdx);
        }
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.kmY.setOnClickListener(onClickListener);
    }

    public final void ar() {
        if (this.kmX == 2) {
            l lVar = (l) al.agf().getValue("key_share_card_layout_data");
            if (lVar == null) {
                w.w("MicroMsg.CardHomePageItemController", "updateShareCardView data is null");
                return;
            }
            if (bg.mA(lVar.khk)) {
                this.kna.setVisibility(8);
            } else {
                this.kna.setVisibility(0);
                this.kna.setText(lVar.khk);
            }
            if (bg.bV(lVar.khj)) {
                for (int i = 0; i < 3; i++) {
                    this.knc[i].setVisibility(8);
                }
            } else {
                for (int i2 = 0; i2 < 3; i2++) {
                    if (i2 < lVar.khj.size()) {
                        this.knc[i2].setVisibility(0);
                        m.a(this.knc[i2], (String) lVar.khj.get(i2), this.kdb.getResources().getDimensionPixelSize(R.f.aXu), R.g.bhq, true);
                    } else {
                        this.knc[i2].setVisibility(8);
                    }
                }
            }
            if (lVar.fVv) {
                this.knd.setVisibility(0);
            } else {
                this.knd.setVisibility(8);
            }
            if (bg.bV(lVar.khj) || lVar.khj.size() != 1 || !lVar.fVu || lVar.fVv) {
                this.kne.setVisibility(8);
            } else {
                this.kne.setVisibility(0);
            }
        } else if (this.kmX == 3) {
            this.kmZ.setText(this.kdb.getString(R.l.dSq, new Object[]{Integer.valueOf(b.agt())}));
            String str = (String) al.agf().getValue("key_card_entrance_tips");
            if (bg.mA(str)) {
                this.kna.setVisibility(8);
                return;
            }
            this.kna.setText(str);
            this.kna.setVisibility(0);
        }
    }

    public final void setVisibility(int i) {
        this.khv.setVisibility(i);
    }
}
