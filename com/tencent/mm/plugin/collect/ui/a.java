package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.collect.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.r;
import com.tencent.mm.wallet_core.ui.WalletTextView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class a extends BaseAdapter {
    List<com.tencent.mm.plugin.collect.b.a> kBf = new ArrayList();
    private Context mContext;

    private static class a {
        TextView kBg;
        WalletTextView kBh;
        TextView kBi;

        public a(View view) {
            this.kBg = (TextView) view.findViewById(R.h.bDg);
            this.kBh = (WalletTextView) view.findViewById(R.h.bDx);
            this.kBi = (TextView) view.findViewById(R.h.bDh);
        }
    }

    public a(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.kBf.size();
    }

    public final Object getItem(int i) {
        return this.kBf.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = r.eC(this.mContext).inflate(R.i.cYZ, viewGroup, false);
            view.setTag(new a(view));
        }
        com.tencent.mm.plugin.collect.b.a aVar = (com.tencent.mm.plugin.collect.b.a) this.kBf.get(i);
        a aVar2 = (a) view.getTag();
        aVar2.kBg.setText(new SimpleDateFormat(this.mContext.getString(R.l.dWr)).format(new Date(aVar.timestamp * 1000)));
        aVar2.kBh.setText(c.kV(aVar.bPo));
        if (bg.mA(aVar.desc)) {
            aVar2.kBi.setVisibility(8);
        } else {
            aVar2.kBi.setText(aVar.desc);
            aVar2.kBi.setVisibility(0);
        }
        return view;
    }
}
