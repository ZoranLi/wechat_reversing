package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.protocal.c.iw;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

public final class f extends a {
    protected TextView ipw;
    public ArrayList<iw> kde;
    private View krZ;
    private ImageView ksa;
    private TextView ksb;
    private TextView ksc;
    private View ksd;
    private TextView kse;
    private TextView ksf;
    private ImageView ksg;
    private TextView ksh;

    public f(Context context) {
        super(context);
    }

    protected final void aiS() {
        this.ipw = (TextView) aiR().findViewById(R.h.byE);
        this.krZ = aiR().findViewById(R.h.bwj);
        this.ksa = (ImageView) aiR().findViewById(R.h.cIh);
        this.ksb = (TextView) aiR().findViewById(R.h.cIg);
        this.ksc = (TextView) aiR().findViewById(R.h.cIf);
        this.ksd = aiR().findViewById(R.h.cIj);
        this.kse = (TextView) aiR().findViewById(R.h.cIl);
        this.ksf = (TextView) aiR().findViewById(R.h.cIk);
        this.ksg = (ImageView) aiR().findViewById(R.h.cIi);
        this.ksh = (TextView) aiR().findViewById(R.h.cIe);
    }

    protected final void aiT() {
        if (this.kcX.afi().toM != null && !TextUtils.isEmpty(this.kcX.afi().toM.title)) {
            this.krx.setText(this.kcX.afi().toM.title);
        } else if (TextUtils.isEmpty(this.kcX.afi().keT)) {
            this.krx.setText("");
        } else {
            this.krx.setText(this.kcX.afi().keT);
        }
        if (this.kcX.afi().toM == null || TextUtils.isEmpty(this.kcX.afi().toM.kdH)) {
            this.ipw.setText("");
            this.ipw.setVisibility(8);
        } else {
            this.ipw.setText(this.kcX.afi().toM.kdH);
            this.ipw.setVisibility(0);
        }
        w.i("MicroMsg.CardWidgetTicket", "updateContentView()");
        if (bg.mA(this.kcX.afi().tos)) {
            m.a(this.ksa, R.g.bdy, l.ta(this.kcX.afi().hib));
        } else {
            m.a(this.mContext, this.ksa, this.kcX.afi().tos, this.mContext.getResources().getDimensionPixelSize(R.f.aYW), R.g.bdy, l.ta(this.kcX.afi().hib));
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        lz lzVar;
        if (this.kcX.afi().toj != null && this.kcX.afi().toj.size() >= 2) {
            w.i("MicroMsg.CardWidgetTicket", "primary_fields length is >= 2");
            lzVar = (lz) this.kcX.afi().toj.get(0);
            lz lzVar2 = (lz) this.kcX.afi().toj.get(1);
            stringBuilder.append(lzVar.title).append(" - ").append(lzVar2.title);
            if (!(TextUtils.isEmpty(lzVar.kdI) || TextUtils.isEmpty(lzVar2.kdI))) {
                stringBuilder2.append(lzVar.kdI).append(" ").append(lzVar.kdH);
                stringBuilder2.append(" - ");
                stringBuilder2.append(lzVar2.kdI).append(" ").append(lzVar2.kdH);
            }
        } else if (this.kcX.afi().toj != null && this.kcX.afi().toj.size() == 1) {
            w.i("MicroMsg.CardWidgetTicket", "primary_fields length is == 1");
            lzVar = (lz) this.kcX.afi().toj.get(0);
            stringBuilder.append(lzVar.title);
            stringBuilder2.append(lzVar.kdH);
        }
        if (TextUtils.isEmpty(stringBuilder.toString())) {
            this.ksb.setText("");
        } else {
            this.ksb.setText(stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(stringBuilder2.toString())) {
            w.i("MicroMsg.CardWidgetTicket", "sub_title_builder is not empty!");
            this.ksc.setText(stringBuilder2.toString());
            this.ksc.setVisibility(0);
        } else if (TextUtils.isEmpty(this.kcX.afi().toA)) {
            this.ksc.setVisibility(8);
        } else {
            w.i("MicroMsg.CardWidgetTicket", "primary_sub_title is not empty!");
            this.ksc.setText(this.kcX.afi().toA);
            this.ksc.setVisibility(0);
        }
        w.e("MicroMsg.CardWidgetTicket", "updateShopView(), shop_count:" + this.kcX.afi().ton);
        if (this.kcX.afi().ton <= 0) {
            this.ksd.setVisibility(8);
            this.ksh.setVisibility(8);
        } else {
            iw iwVar;
            this.ksd.setVisibility(0);
            this.ksd.setOnClickListener(this.iuW);
            m.a(this.ksg, R.g.bdz, l.ta(this.kcX.afi().hib));
            if (this.kde == null || this.kde.size() <= 0) {
                iwVar = null;
            } else {
                iwVar = (iw) this.kde.get(0);
            }
            if (this.kcX.afi().ton == 1 && iwVar != null) {
                this.kse.setText(iwVar.name);
                this.ksf.setText(this.mContext.getString(R.l.dRY, new Object[]{l.d(this.mContext, iwVar.tnX), iwVar.hCE}));
                this.ksh.setVisibility(8);
                this.ksd.setTag(iwVar.name);
            } else if (this.kcX.afi().ton > 1 && iwVar != null) {
                this.kse.setText(iwVar.name);
                this.ksf.setText(this.mContext.getString(R.l.dRY, new Object[]{l.d(this.mContext, iwVar.tnX), iwVar.hCE}));
                this.ksh.setVisibility(0);
                this.ksh.setOnClickListener(this.iuW);
                this.ksd.setTag(iwVar.name);
            } else if (this.kcX.afi().ton > 0) {
                this.kse.setText(R.l.dQs);
                this.ksf.setText(this.mContext.getString(R.l.dSs, new Object[]{Integer.valueOf(this.kcX.afi().ton)}));
                this.ksh.setVisibility(8);
                this.ksh.setOnClickListener(null);
                this.ksd.setTag(this.mContext.getString(R.l.dQs));
            }
        }
        if (this.kcX.afh()) {
            this.krZ.setVisibility(8);
        } else {
            this.krZ.setVisibility(0);
        }
    }
}
