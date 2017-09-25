package com.tencent.mm.plugin.ipcall.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.as.d;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.ArrayList;
import java.util.List;

public final class f extends BaseAdapter {
    private List<a> fRK;
    private String isw;
    private List<a> mTn = new ArrayList();
    private IPCallCountryCodeSelectUI mTo;
    int[] mTp;
    boolean mTq = false;
    boolean mTr = false;

    static class a {
        TextView jZz;
        TextView mTs;
        TextView mTt;

        a() {
        }
    }

    public f(IPCallCountryCodeSelectUI iPCallCountryCodeSelectUI, List<a> list) {
        this.mTo = iPCallCountryCodeSelectUI;
        this.fRK = list;
        aFb();
        aFc();
    }

    private void aFb() {
        int size = this.fRK.size();
        for (int i = 0; i < size; i++) {
            this.mTn.add(this.fRK.get(i));
        }
        this.mTo.mTf.setVisibility(8);
    }

    private void aFc() {
        this.mTp = new int[this.fRK.size()];
        int size = this.fRK.size();
        for (int i = 0; i < size; i++) {
            this.mTp[i] = ((a) this.fRK.get(i)).aER();
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
                if (((a) this.mTn.get(i)).hJF.toUpperCase().contains(this.isw.toUpperCase()) || ((a) this.mTn.get(i)).mRh.toUpperCase().contains(this.isw.toUpperCase()) || ((a) this.mTn.get(i)).countryCode.contains(this.isw)) {
                    this.fRK.add(this.mTn.get(i));
                }
                i++;
            }
            aFc();
            if (this.fRK.size() == 0) {
                this.mTo.mTf.setVisibility(0);
            } else {
                this.mTo.mTf.setVisibility(8);
            }
            super.notifyDataSetChanged();
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        a aVar2 = (a) getItem(i);
        if (view == null) {
            view = View.inflate(this.mTo, R.i.dga, null);
            aVar = new a();
            aVar.mTs = (TextView) view.findViewById(R.h.bGk);
            aVar.jZz = (TextView) view.findViewById(R.h.bGm);
            aVar.mTt = (TextView) view.findViewById(R.h.bGp);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        int i2 = i > 0 ? this.mTp[i - 1] : -1;
        if (i == 0) {
            aVar.mTs.setVisibility(0);
            if (this.mTr) {
                aVar.mTs.setText(R.l.eGO);
            } else {
                aVar.mTs.setText(op(this.mTp[i]));
            }
        } else if (i <= 0 || this.mTp[i] == i2) {
            aVar.mTs.setVisibility(8);
        } else {
            aVar.mTs.setVisibility(0);
            aVar.mTs.setText(op(this.mTp[i]));
        }
        if (bg.mA(this.isw)) {
            aVar.jZz.setText(aVar2.hJF);
            aVar.mTt.setText(" (+" + aVar2.countryCode + ")");
        } else {
            aVar.jZz.setText(d.a(aVar2.hJF, this.isw));
            aVar.mTt.setText(d.a(" (+" + aVar2.countryCode + ")", this.isw));
        }
        if (this.mTq) {
            aVar.mTt.setVisibility(0);
        } else {
            aVar.mTt.setVisibility(4);
        }
        return view;
    }

    private static String op(int i) {
        String valueOf = String.valueOf((char) i);
        for (String equals : IPCallCountryCodeScrollbar.mTu) {
            if (equals.equals(String.valueOf((char) i))) {
                return valueOf;
            }
        }
        return "#";
    }
}
