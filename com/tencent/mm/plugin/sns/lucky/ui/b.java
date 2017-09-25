package com.tencent.mm.plugin.sns.lucky.ui;

import android.content.Context;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.j.n;
import com.tencent.mm.protocal.c.aex;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public final class b extends BaseAdapter {
    private LayoutInflater Du;
    private final String TAG = "SnsLuckyMoneyReceivedRecordListAdapter";
    private Context mContext;
    List<com.tencent.mm.plugin.q.a.a> nro = new ArrayList();
    private int nuy = 1;

    class a {
        ImageView kDl;
        TextView nrd;
        TextView nsG;
        TextView nsH;
        TextView nuE;
        final /* synthetic */ b pSi;

        a(b bVar) {
            this.pSi = bVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return sS(i);
    }

    public b(Context context) {
        this.mContext = context;
        this.Du = LayoutInflater.from(context);
    }

    public final int getCount() {
        return this.nro.size();
    }

    private com.tencent.mm.plugin.q.a.a sS(int i) {
        return (com.tencent.mm.plugin.q.a.a) this.nro.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence charSequence;
        if (view == null) {
            view = this.Du.inflate(R.i.doL, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.kDl = (ImageView) view.findViewById(R.h.cgl);
            aVar2.nsG = (TextView) view.findViewById(R.h.cgo);
            aVar2.nsH = (TextView) view.findViewById(R.h.cgp);
            aVar2.nrd = (TextView) view.findViewById(R.h.cgj);
            aVar2.nuE = (TextView) view.findViewById(R.h.cgn);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.q.a.a sS = sS(i);
        ap.yY();
        x Rc = c.wR().Rc(sS.jia);
        if (sS.jia != null) {
            com.tencent.mm.pluginsdk.ui.a.b.m(aVar.kDl, sS.jia);
        } else {
            w.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[]{sS.jia});
        }
        TextView textView = aVar.nsH;
        Context context = this.mContext;
        long j = ((long) sS.njd) * 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            charSequence = "";
        } else {
            long timeInMillis = j - new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5)).getTimeInMillis();
            if (timeInMillis <= 0 || timeInMillis > 86400000) {
                Time time = new Time();
                time.set(j);
                charSequence = n.a(context.getString(R.l.elq, new Object[]{" "}), time).toString();
            } else {
                charSequence = new SimpleDateFormat("HH:mm").format(new Date(j));
            }
        }
        textView.setText(charSequence);
        aVar.nsH.setVisibility(0);
        if (Rc != null) {
            com.tencent.mm.plugin.luckymoney.b.n.a(this.mContext, aVar.nsG, Rc.tL());
        } else {
            w.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[]{sS.jia});
        }
        aex com_tencent_mm_protocal_c_aex = new aex();
        try {
            if (sS.nje == null || sS.nje.tZn <= 0) {
                aVar.nrd.setVisibility(8);
                aVar.nuE.setVisibility(0);
                return view;
            }
            com_tencent_mm_protocal_c_aex.aD(com.tencent.mm.platformtools.n.a(sS.nje));
            if (com_tencent_mm_protocal_c_aex.fZT > 0) {
                aVar.nrd.setText(this.mContext.getString(R.l.cfX, new Object[]{e.n(((double) com_tencent_mm_protocal_c_aex.fZT) / 100.0d)}));
                aVar.nuE.setVisibility(8);
            } else {
                aVar.nrd.setVisibility(8);
                aVar.nuE.setVisibility(0);
            }
            return view;
        } catch (Exception e) {
            w.e("SnsLuckyMoneyReceivedRecordListAdapter", e.getMessage() + "hbBuffer is error");
            aVar.nrd.setVisibility(8);
            aVar.nuE.setVisibility(8);
            aVar.kDl.setVisibility(8);
            aVar.nsG.setVisibility(8);
            aVar.nsH.setVisibility(8);
        }
    }
}
