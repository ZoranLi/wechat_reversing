package com.tencent.mm.plugin.card.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"UseValueOf"})
public final class g extends BaseAdapter {
    private OnClickListener iuW = new OnClickListener(this) {
        final /* synthetic */ g knA;

        {
            this.knA = r1;
        }

        public final void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            g gVar = this.knA;
            if (((Boolean) gVar.kny.get(intValue)).booleanValue()) {
                gVar.kny.set(intValue, Boolean.valueOf(false));
            } else {
                gVar.kny.set(intValue, Boolean.valueOf(true));
            }
            gVar.notifyDataSetChanged();
        }
    };
    private boolean keP = true;
    List<CardInfo> kiF = new ArrayList();
    c kiu;
    private boolean knx = false;
    List<Boolean> kny = new ArrayList();
    a knz;
    Context mContext;

    public interface a {
    }

    public final /* synthetic */ Object getItem(int i) {
        return kx(i);
    }

    public g(Context context) {
        this.kiu = new k(context, this);
        this.mContext = context;
    }

    public final int getCount() {
        return this.kiF.size();
    }

    public final CardInfo kx(int i) {
        return (CardInfo) this.kiF.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b kx = kx(i);
        kx.keP = this.keP;
        View a = this.kiu.a(i, view, kx);
        if (this.knx && kx.aeU()) {
            this.kiu.u(a, 0);
            if (((Boolean) this.kny.get(i)).booleanValue()) {
                this.kiu.t(a, R.g.bdl);
            } else {
                this.kiu.t(a, R.g.bdm);
            }
            this.kiu.a(a, i, this.iuW);
        } else {
            this.kiu.u(a, 8);
        }
        return a;
    }
}
