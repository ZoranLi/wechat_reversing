package com.tencent.mm.plugin.emoji.ui.smiley;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.bi.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.r;

public final class b extends a {

    class a {
        ImageView jbU;
        final /* synthetic */ b kTr;

        public a(b bVar, View view) {
            this.kTr = bVar;
            this.jbU = (ImageView) view.findViewById(R.h.bqm);
        }
    }

    public b(Context context, f fVar) {
        super(context, fVar);
    }

    public final int getCount() {
        return this.kTl;
    }

    public final Object getItem(int i) {
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = r.eC(this.mContext).inflate(R.i.doH, null);
            f fVar = this.kTj;
            if (fVar.kUU == 0) {
                fVar.kUU = fVar.aog() / fVar.uK("TAG_DEFAULT_TAB");
            }
            view.setLayoutParams(new LayoutParams(fVar.kUU, this.kTj.kUQ));
            aVar = new a(this, view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == getCount() - 1) {
            aVar.jbU.setImageResource(R.g.bev);
            aVar.jbU.setContentDescription(this.mContext.getString(R.l.ebt));
        } else {
            int i2 = ((this.kTl - 1) * this.kTn) + i;
            if (i2 > this.jZR - 1) {
                aVar.jbU.setImageDrawable(null);
                aVar.jbU.setContentDescription("");
                w.i("MicroMsg.emoji.DefaultSmileyAdapter", "real position is bigger real count.");
            } else {
                Drawable iP = e.bKD().iP(i2);
                aVar.jbU.setImageDrawable(iP);
                CharSequence text = e.bKD().getText(i2);
                if (bg.mA(text)) {
                    text = view.getResources().getString(R.l.edO);
                }
                aVar.jbU.setContentDescription(text);
                if (iP == null) {
                    w.i("MicroMsg.emoji.DefaultSmileyAdapter", "drawable is null. realPosition:%d description:%s", new Object[]{Integer.valueOf(i2), text});
                }
            }
        }
        return view;
    }
}
