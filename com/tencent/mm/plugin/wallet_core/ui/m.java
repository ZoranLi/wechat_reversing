package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.v;
import java.util.ArrayList;

public final class m extends BaseAdapter {
    private Context mContext;
    ArrayList<v> mData = null;
    v rOp = null;

    private class a {
        TextView iUO;
        ImageView rOq;
        final /* synthetic */ m rOr;

        public a(m mVar) {
            this.rOr = mVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return vG(i);
    }

    public m(Context context, ArrayList<v> arrayList) {
        this.mContext = context;
        this.mData = arrayList;
    }

    public final int getCount() {
        if (this.mData != null) {
            return this.mData.size();
        }
        return 0;
    }

    public final v vG(int i) {
        if (this.mData == null || getCount() <= i) {
            return null;
        }
        return (v) this.mData.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.mContext, R.i.drw, null);
            a aVar2 = new a(this);
            aVar2.iUO = (TextView) view.findViewById(R.h.title);
            aVar2.rOq = (ImageView) view.findViewById(R.h.cCk);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        v vG = vG(i);
        if (vG != null) {
            aVar.iUO.setText(vG.field_wallet_name);
            if (vG.field_wallet_selected == 1) {
                this.rOp = vG;
                aVar.rOq.setImageResource(R.k.dze);
            } else {
                aVar.rOq.setImageResource(R.k.dzd);
            }
        }
        return view;
    }
}
