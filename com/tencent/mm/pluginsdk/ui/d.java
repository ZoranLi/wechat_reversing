package com.tencent.mm.pluginsdk.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d implements OnScrollListener {
    private OnScrollListener sIl;
    private ArrayList<WeakReference<a>> sIm;

    public interface a {
        void onScrollStateChanged(boolean z);
    }

    public d() {
        this(null);
    }

    public d(OnScrollListener onScrollListener) {
        this.sIm = new ArrayList();
        this.sIl = onScrollListener;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.sIl != null) {
            this.sIl.onScroll(absListView, i, i2, i3);
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            jl(true);
        } else {
            jl(false);
        }
        if (this.sIl != null) {
            this.sIl.onScrollStateChanged(absListView, i);
        }
    }

    public final void a(a aVar) {
        this.sIm.add(new WeakReference(aVar));
    }

    private void jl(boolean z) {
        for (int i = 0; i < this.sIm.size(); i++) {
            WeakReference weakReference = (WeakReference) this.sIm.get(i);
            if (weakReference != null) {
                a aVar = (a) weakReference.get();
                if (aVar != null) {
                    aVar.onScrollStateChanged(z);
                } else {
                    this.sIm.remove(i);
                }
            } else {
                this.sIm.remove(i);
            }
        }
    }
}
