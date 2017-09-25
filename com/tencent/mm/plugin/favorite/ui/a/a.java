package com.tencent.mm.plugin.favorite.ui.a;

import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import java.util.Set;

public abstract class a extends BaseAdapter implements OnItemClickListener {
    protected Set<Integer> lIU;
    protected com.tencent.mm.plugin.favorite.b.x.a lIV;
    protected a lIW;
    protected long lastUpdateTime;
    protected int type;

    public interface a {
        void aun();
    }

    public abstract void auq();

    public abstract void aur();

    public abstract boolean isEmpty();

    public final int getType() {
        return this.type;
    }

    public final long auo() {
        return this.lastUpdateTime;
    }

    public final void a(a aVar) {
        this.lIW = aVar;
    }

    public final void aup() {
        if (this.lIW != null) {
            this.lIW.aun();
        }
    }

    public final void f(Set<Integer> set) {
        this.lIU = set;
    }

    public final void a(com.tencent.mm.plugin.favorite.b.x.a aVar) {
        this.lIV = aVar;
    }
}
