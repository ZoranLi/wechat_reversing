package com.tencent.mm.plugin.card.sharecard.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import java.util.List;

public final class g extends BaseAdapter {
    List<b> kiF;
    c kiu;
    Context mContext;

    public final /* synthetic */ Object getItem(int i) {
        return kl(i);
    }

    public final int getCount() {
        return this.kiF.size();
    }

    public final b kl(int i) {
        return (b) this.kiF.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.kiu.a(i, view, kl(i));
    }
}
