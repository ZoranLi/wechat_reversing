package com.tencent.mm.ui.tools;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;

public final class d extends BaseAdapter {
    private Context context;
    private List<c> fRK;
    private String isw;
    private List<c> mTn = new ArrayList();
    int[] mTp;
    boolean mTq = false;

    static class a {
        TextView jZz;
        TextView mTs;
        TextView mTt;

        a() {
        }
    }

    public d(Context context, List<c> list) {
        this.context = context;
        this.fRK = list;
        aFb();
        aFc();
    }

    private void aFb() {
        int size = this.fRK.size();
        for (int i = 0; i < size; i++) {
            this.mTn.add(this.fRK.get(i));
        }
    }

    private void aFc() {
        this.mTp = new int[this.fRK.size()];
        int size = this.fRK.size();
        for (int i = 0; i < size; i++) {
            this.mTp[i] = ((c) this.fRK.get(i)).mRg;
        }
    }

    public final int getCount() {
        return this.fRK.size();
    }

    public final Object getItem(int i) {
        return this.fRK.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final void yD(String str) {
        if (str != null) {
            this.isw = str.trim();
            this.fRK.clear();
            int size = this.mTn.size();
            int i = 0;
            while (i < size) {
                if (((c) this.mTn.get(i)).hJF.toUpperCase().contains(this.isw.toUpperCase()) || ((c) this.mTn.get(i)).mRh.toUpperCase().contains(this.isw.toUpperCase()) || ((c) this.mTn.get(i)).countryCode.contains(this.isw)) {
                    this.fRK.add(this.mTn.get(i));
                }
                i++;
            }
            aFc();
            super.notifyDataSetChanged();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        c cVar = (c) getItem(i);
        if (view == null) {
            View inflate;
            if (v.bIL()) {
                inflate = View.inflate(this.context, R.i.cZT, null);
            } else {
                inflate = View.inflate(this.context, R.i.cZS, null);
            }
            a aVar2 = new a();
            aVar2.mTs = (TextView) inflate.findViewById(R.h.bGk);
            aVar2.jZz = (TextView) inflate.findViewById(R.h.bGm);
            aVar2.mTt = (TextView) inflate.findViewById(R.h.bGp);
            inflate.setTag(aVar2);
            view = inflate;
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        int i2 = i > 0 ? this.mTp[i - 1] : -1;
        if (i == 0) {
            aVar.mTs.setVisibility(0);
            aVar.mTs.setText(op(this.mTp[i]));
        } else if (i <= 0 || this.mTp[i] == i2) {
            aVar.mTs.setVisibility(8);
        } else {
            aVar.mTs.setVisibility(0);
            aVar.mTs.setText(op(this.mTp[i]));
        }
        aVar.jZz.setText(cVar.hJF);
        aVar.mTt.setText(cVar.countryCode);
        if (this.mTq) {
            aVar.mTt.setVisibility(0);
        } else {
            aVar.mTt.setVisibility(4);
        }
        return view;
    }

    private static String op(int i) {
        if (v.bIL()) {
            return Integer.toString(i) + "劃";
        }
        return String.valueOf((char) i);
    }
}
