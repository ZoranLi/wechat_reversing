package com.tencent.mm.ui.base;

import android.support.v4.view.u;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public abstract class t extends u {
    public Queue<View> vnK = new LinkedList();
    public HashMap<Object, Integer> vnL = new HashMap();
    public SparseArray<Object> vnM = new SparseArray();

    public abstract Object d(int i, View view);

    public abstract MultiTouchImageView nk(int i);

    public Object b(ViewGroup viewGroup, int i) {
        long currentTimeMillis = System.currentTimeMillis();
        View view = null;
        if (this.vnK.size() > 0) {
            view = (View) this.vnK.poll();
        }
        Object d = d(i, view);
        w.i("MicroMsg.MMViewPagerAdapter", "instantiateItem object %s, parent %s position:%s", Integer.valueOf(d.hashCode()), ((View) d).getParent(), Integer.valueOf(i));
        this.vnL.put(d, Integer.valueOf(i));
        this.vnM.put(i, d);
        if (((View) d).getParent() == null) {
            viewGroup.addView((View) d);
        }
        w.i("MicroMsg.MMViewPagerAdapter", "instantiateItem spent : %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return d;
    }

    public void a(ViewGroup viewGroup, int i, Object obj) {
        w.d("MicroMsg.MMViewPagerAdapter", "destroyItem position %s", Integer.valueOf(i));
        w.i("MicroMsg.MMViewPagerAdapter", "destroyItem object %s", Integer.valueOf(obj.hashCode()));
        this.vnK.add((View) obj);
        this.vnL.remove(obj);
        this.vnM.remove(i);
    }

    public final int j(Object obj) {
        if (this.vnL.containsKey(obj)) {
            return ((Integer) this.vnL.get(obj)).intValue();
        }
        return -2;
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }

    public final View Al(int i) {
        Object obj = this.vnM.get(i);
        if (obj != null) {
            return (View) obj;
        }
        return null;
    }

    public final void reset() {
        this.vnK.clear();
        this.vnL.clear();
        this.vnM.clear();
    }

    public int bSD() {
        return -1;
    }

    public int bSE() {
        return -1;
    }

    public void detach() {
        reset();
    }
}
