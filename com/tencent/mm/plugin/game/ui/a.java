package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.dp;

public final class a extends b<dp> {

    static class a {
        public ImageView mwf;
        public TextView mwg;
        public TextView mwh;

        a() {
        }
    }

    public a(Context context) {
        super(context);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        dp dpVar = (dp) getItem(i);
        if (view == null) {
            view = View.inflate(this.mContext, R.i.cUX, null);
            a aVar2 = new a();
            aVar2.mwf = (ImageView) view.findViewById(R.h.bUc);
            aVar2.mwh = (TextView) view.findViewById(R.h.bmF);
            aVar2.mwg = (TextView) view.findViewById(R.h.bUJ);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        Bitmap xX = xX(dpVar.msh);
        if (xX == null) {
            aVar.mwf.setImageResource(R.g.bcg);
        } else {
            aVar.mwf.setImageBitmap(xX);
        }
        aVar.mwg.setText(g.m(this.mContext, dpVar.msh));
        if (g.LX(dpVar.msh)) {
            aVar.mwh.setText(R.l.epz);
        } else {
            aVar.mwh.setText(R.l.epA);
        }
        return view;
    }
}
