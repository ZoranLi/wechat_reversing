package com.tencent.mm.ui.base;

import android.content.Context;
import android.support.v4.view.u;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.sdk.platformtools.w;
import java.util.LinkedList;
import java.util.Queue;

public abstract class d extends u {
    public Context context;
    private int iIw = 0;
    private Queue<View> vgG;

    public abstract View a(View view, ViewGroup viewGroup, int i);

    public abstract int aOq();

    public abstract void qn(int i);

    public d(Context context) {
        this.context = context;
        this.vgG = new LinkedList();
    }

    public final boolean a(View view, Object obj) {
        return view.equals(obj);
    }

    public final Object b(ViewGroup viewGroup, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        View a = a((View) this.vgG.poll(), viewGroup, i);
        if (a.getLayoutParams() == null) {
            a.setLayoutParams(new LayoutParams(-1, -1));
        }
        viewGroup.addView(a);
        w.v("MicroMsg.CustomPagerAdapter", "instantiateItem usetime: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        return a;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        this.vgG.add(view);
        qn(i);
        w.d("MicroMsg.CustomPagerAdapter", "recycle queue size %d", new Object[]{Integer.valueOf(this.vgG.size())});
    }

    public final void notifyDataSetChanged() {
        this.iIw = aOq();
        super.notifyDataSetChanged();
    }

    public final int j(Object obj) {
        if (this.iIw <= 0) {
            return super.j(obj);
        }
        this.iIw--;
        return -2;
    }
}
