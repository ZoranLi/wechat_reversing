package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.model.ad;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class h extends BaseAdapter {
    int Ds;
    private Context mContext;
    int mqT;
    private ad myS;

    private class a {
        public ImageView hBi;
        public TextView jkj;
        final /* synthetic */ h myT;
        public TextView myU;
        public TextView myV;
        public TextView myW;
        public GameDetailRankLikeView myX;

        public a(h hVar) {
            this.myT = hVar;
        }
    }

    public h(Context context) {
        this.mContext = context;
    }

    public final void a(ad adVar) {
        this.myS = adVar;
        af.v(new Runnable(this) {
            final /* synthetic */ h myT;

            {
                this.myT = r1;
            }

            public final void run() {
                this.myT.notifyDataSetChanged();
            }
        });
    }

    public final int getCount() {
        return this.myS == null ? 0 : this.myS.mrd.size();
    }

    public final Object getItem(int i) {
        return this.myS.mrd.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(this.Ds, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.myU = (TextView) inflate.findViewById(R.h.bTC);
            aVar2.hBi = (ImageView) inflate.findViewById(R.h.bTz);
            aVar2.jkj = (TextView) inflate.findViewById(R.h.bTB);
            aVar2.myV = (TextView) inflate.findViewById(R.h.bTE);
            aVar2.myW = (TextView) inflate.findViewById(R.h.bTD);
            aVar2.myX = (GameDetailRankLikeView) inflate.findViewById(R.h.bTA);
            aVar2.myX.mqT = this.mqT;
            f((ViewGroup) inflate);
            inflate.setTag(aVar2);
            view = inflate;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.game.model.ad.a aVar3 = (com.tencent.mm.plugin.game.model.ad.a) getItem(i);
        aVar.myU.setText(aVar3.mre);
        b.a(aVar.hBi, aVar3.fSf, 0.5f, false);
        ap.yY();
        x Rc = c.wR().Rc(aVar3.fSf);
        if (Rc != null) {
            aVar.jkj.setText(new SpannableString(com.tencent.mm.pluginsdk.ui.d.h.b(this.mContext, Rc.tL(), aVar.jkj.getTextSize())));
        } else {
            aVar.jkj.setText("");
        }
        if (bg.mA(aVar3.tag)) {
            aVar.myV.setVisibility(8);
        } else {
            aVar.myV.setVisibility(0);
            aVar.myV.setText(aVar3.tag);
        }
        if (bg.mA(aVar3.mrh)) {
            aVar.myW.setText(aVar3.mal);
            GameDetailRankLikeView gameDetailRankLikeView = aVar.myX;
            ad adVar = this.myS;
            gameDetailRankLikeView.myY = adVar;
            gameDetailRankLikeView.ivH = adVar.ivH;
            gameDetailRankLikeView.myZ = (com.tencent.mm.plugin.game.model.ad.a) adVar.mrd.get(i);
            gameDetailRankLikeView.aBR();
            aVar.myX.setVisibility(0);
        } else {
            aVar.myW.setText(aVar3.mrh);
            aVar.myX.setVisibility(8);
        }
        return view;
    }

    private void f(ViewGroup viewGroup) {
        viewGroup.setClipChildren(false);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                ((ViewGroup) childAt).setClipChildren(false);
                f((ViewGroup) childAt);
            }
        }
    }
}
