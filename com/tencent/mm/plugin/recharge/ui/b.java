package com.tencent.mm.plugin.recharge.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.a.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.r;
import java.util.ArrayList;

public final class b extends BaseAdapter {
    ArrayList<m> oLU = null;
    a oLV = null;

    public interface a {
        void a(m mVar);
    }

    private class b {
        TextView iuF;
        TextView mVG;
        final /* synthetic */ b oLX;
        TextView oLY;

        public b(b bVar) {
            this.oLX = bVar;
        }
    }

    public final int getCount() {
        return this.oLU == null ? 0 : this.oLU.size();
    }

    public final Object getItem(int i) {
        return this.oLU.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        final m mVar = (m) getItem(i);
        if (view == null) {
            view = r.eC(viewGroup.getContext()).inflate(R.i.dmk, viewGroup, false);
            b bVar2 = new b(this);
            bVar2.mVG = (TextView) view.findViewById(R.h.bHZ);
            bVar2.iuF = (TextView) view.findViewById(R.h.name);
            bVar2.oLY = (TextView) view.findViewById(R.h.csz);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.iuF.setText(mVar.name);
        if (bg.mA(mVar.desc)) {
            bVar.mVG.setVisibility(8);
        } else {
            bVar.mVG.setVisibility(0);
            bVar.mVG.setText(mVar.desc);
        }
        if (bg.mA(mVar.ryi)) {
            bVar.oLY.setVisibility(8);
        } else {
            bVar.oLY.setVisibility(0);
            bVar.oLY.setText(mVar.ryi);
        }
        if (mVar.status == 1) {
            view.setEnabled(true);
            bVar.mVG.setEnabled(true);
            bVar.iuF.setEnabled(true);
        } else {
            view.setEnabled(false);
            bVar.mVG.setEnabled(false);
            bVar.iuF.setEnabled(false);
        }
        if (mVar.type == 1 && mVar.ryj.equals("1") && !mVar.ryk.equals("0")) {
            Context context = viewGroup.getContext();
            int parseColor = Color.parseColor(mVar.ryk);
            Drawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius((float) com.tencent.mm.bg.a.fromDPToPix(context, 2));
            gradientDrawable.setColor(parseColor);
            Drawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setShape(0);
            gradientDrawable2.setCornerRadius((float) com.tencent.mm.bg.a.fromDPToPix(context, 2));
            gradientDrawable2.setStroke(2, com.tencent.mm.bg.a.b(context, R.e.aVB));
            Drawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setShape(0);
            gradientDrawable3.setCornerRadius((float) com.tencent.mm.bg.a.fromDPToPix(context, 2));
            gradientDrawable3.setColor(com.tencent.mm.bg.a.b(context, R.e.aVz));
            gradientDrawable3.setStroke(2, parseColor);
            Drawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{16842919}, gradientDrawable);
            stateListDrawable.addState(new int[]{-16842910}, gradientDrawable2);
            stateListDrawable.addState(new int[0], gradientDrawable3);
            Context context2 = viewGroup.getContext();
            int parseColor2 = Color.parseColor(mVar.ryk);
            r6 = new int[3][];
            r6[0] = new int[]{16842919};
            r6[1] = new int[]{-16842910};
            r6[2] = new int[0];
            ColorStateList colorStateList = new ColorStateList(r6, new int[]{com.tencent.mm.bg.a.b(context2, R.e.white), com.tencent.mm.bg.a.b(context2, R.e.aVx), parseColor2});
            bVar.mVG.setTextColor(colorStateList);
            bVar.iuF.setTextColor(colorStateList);
            view.setBackground(stateListDrawable);
        }
        view.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b oLX;

            public final void onClick(View view) {
                if (this.oLX.oLV != null) {
                    this.oLX.oLV.a(mVar);
                }
            }
        });
        return view;
    }
}
