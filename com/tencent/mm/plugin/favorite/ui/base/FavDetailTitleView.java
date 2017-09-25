package com.tencent.mm.plugin.favorite.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;

public class FavDetailTitleView extends LinearLayout {
    private ImageView ipv;
    private TextView ipw;

    public FavDetailTitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.ipv = (ImageView) findViewById(R.h.bqM);
        this.ipw = (TextView) findViewById(R.h.cJh);
    }

    public final void z(j jVar) {
        if (jVar != null && jVar.field_favProto != null) {
            CharSequence eL;
            if (14 != jVar.field_type || bg.mA(jVar.field_favProto.title)) {
                this.ipv.setVisibility(0);
                rw rwVar = jVar.field_favProto.tzl;
                if (rwVar == null || bg.mA(rwVar.tyQ)) {
                    w.v("MicroMsg.FavDetailTitleView", "display name, from item info user[%s]", new Object[]{jVar.field_fromUser});
                    eL = x.eL(jVar.field_fromUser);
                    b.a(this.ipv, jVar.field_fromUser);
                } else {
                    eL = n.eK(rwVar.tyQ);
                    String eL2;
                    if (m.xL().equals(rwVar.fOu)) {
                        eL2 = x.eL(rwVar.toUser);
                        if (!bg.ap(eL2, "").equals(rwVar.toUser)) {
                            eL = eL + " - " + eL2;
                        }
                    } else {
                        eL2 = x.eL(rwVar.fOu);
                        if (!bg.ap(eL2, "").equals(rwVar.fOu)) {
                            eL = eL + " - " + eL2;
                        }
                    }
                    w.v("MicroMsg.FavDetailTitleView", "display name, source from[%s] to[%s]", new Object[]{rwVar.fOu, rwVar.toUser});
                    b.a(this.ipv, rwVar.tyQ);
                }
            } else {
                eL = jVar.field_favProto.title;
                this.ipv.setVisibility(8);
            }
            this.ipw.setText(h.b(getContext(), eL, this.ipw.getTextSize()));
        }
    }
}
