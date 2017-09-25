package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import com.tencent.mm.R;
import com.tencent.mm.plugin.product.c.h;
import com.tencent.mm.plugin.product.c.m;

public final class j extends BaseAdapter {
    private Context mContext;
    m orL;
    String orM;

    public final /* synthetic */ Object getItem(int i) {
        return rh(i);
    }

    public j(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.orL.oqj != null ? this.orL.oqj.size() : 0;
    }

    private h rh(int i) {
        return (h) this.orL.oqj.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final boolean isEnabled(int i) {
        return rh(i).oqb;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        h rh = rh(i);
        if (view == null || view.getTag() == null) {
            inflate = View.inflate(this.mContext, R.i.dlf, null);
        } else {
            inflate = view;
        }
        CheckBox checkBox = (CheckBox) inflate;
        checkBox.setText(rh.name);
        checkBox.setEnabled(rh.oqb);
        checkBox.setChecked(rh.id.equals(this.orM));
        if (!rh.oqb) {
            inflate.setBackgroundResource(R.g.biy);
        } else if (rh.id.equals(this.orM)) {
            inflate.setBackgroundResource(R.g.biA);
        } else {
            inflate.setBackgroundResource(R.g.biz);
        }
        inflate.setTag(new Pair(this.orL.oqh, rh.id));
        return inflate;
    }
}
