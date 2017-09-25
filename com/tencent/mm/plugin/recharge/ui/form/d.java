package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class d extends BaseAdapter implements Filterable {
    private static String TAG = "MicroMsg.MobileHistoryAdapter";
    private Context mContext;
    private AutoCompleteTextView oLB;
    private List<String[]> oLF;
    public List<com.tencent.mm.plugin.recharge.model.a> oLL = new ArrayList();
    public boolean oLM = false;
    private List<com.tencent.mm.plugin.recharge.model.a> oLN;
    private String oLP;
    private b oNZ;
    private MallFormView oNm;
    public d oOa = null;
    public a oOb = null;

    public interface a {
        void aWn();
    }

    private class b extends Filter {
        final /* synthetic */ d oOc;

        private b(d dVar) {
            this.oOc = dVar;
        }

        protected final synchronized FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults;
            FilterResults filterResults2 = new FilterResults();
            List arrayList = new ArrayList();
            String Di = charSequence != null ? com.tencent.mm.plugin.recharge.model.b.Di(charSequence.toString()) : "";
            if (!Di.equals(this.oOc.oLP) || Di.equals("")) {
                boolean z;
                this.oOc.oLP = Di;
                if (this.oOc.oNm.Pb()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    w.i(d.TAG, "performFiltering2 " + charSequence);
                    com.tencent.mm.plugin.recharge.model.a aWf = com.tencent.mm.plugin.recharge.a.a.aWf();
                    if (aWf == null || !Di.equals(aWf.oKT)) {
                        if (this.oOc.oLF == null || this.oOc.oLF.isEmpty()) {
                            this.oOc.oLF = com.tencent.mm.pluginsdk.a.dn(this.oOc.mContext);
                        }
                        if (this.oOc.oLF != null) {
                            for (String[] strArr : this.oOc.oLF) {
                                String Di2 = com.tencent.mm.plugin.recharge.model.b.Di(strArr[2]);
                                Object dh = dh(this.oOc.oLP, Di2);
                                if (com.tencent.mm.plugin.recharge.model.a.oKR.equals(dh)) {
                                    filterResults = filterResults2;
                                    break;
                                } else if (!com.tencent.mm.plugin.recharge.model.a.oKS.equals(dh) && arrayList.size() < 4) {
                                    com.tencent.mm.plugin.recharge.model.a aVar = new com.tencent.mm.plugin.recharge.model.a(Di2, strArr[1], 1);
                                    aVar.oKV = dh;
                                    arrayList.add(aVar);
                                }
                            }
                        }
                        for (com.tencent.mm.plugin.recharge.model.a aVar2 : com.tencent.mm.plugin.recharge.a.a.aWd().aWe()) {
                            Object dh2 = dh(this.oOc.oLP, com.tencent.mm.plugin.recharge.model.b.Di(aVar2.oKT));
                            if (com.tencent.mm.plugin.recharge.model.a.oKR.equals(dh2)) {
                                filterResults = filterResults2;
                                break;
                            } else if (!com.tencent.mm.plugin.recharge.model.a.oKS.equals(dh2) && arrayList.size() < 4) {
                                aVar2.oKV = dh2;
                                arrayList.add(aVar2);
                            }
                        }
                        w.d(d.TAG, " search phone number cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                        z = true;
                    } else {
                        filterResults = filterResults2;
                    }
                } else if (bg.mA(this.oOc.oLP)) {
                    arrayList.addAll(this.oOc.oLN);
                    z = false;
                } else {
                    w.i(d.TAG, "performFiltering1 " + charSequence);
                    for (com.tencent.mm.plugin.recharge.model.a aVar22 : this.oOc.oLN) {
                        if (aVar22.oKT.startsWith(this.oOc.oLP)) {
                            arrayList.add(aVar22);
                        }
                    }
                    z = false;
                }
                filterResults2.count = arrayList.size();
                filterResults2.values = arrayList;
                this.oOc.oLM = z;
                if (arrayList.size() == 0) {
                    this.oOc.oNm.oNW = true;
                } else {
                    this.oOc.oNm.oNW = false;
                }
                filterResults = filterResults2;
            } else {
                this.oOc.oLB.post(new Runnable(this) {
                    final /* synthetic */ b oOd;

                    {
                        this.oOd = r1;
                    }

                    public final void run() {
                        this.oOd.oOc.oLB.dismissDropDown();
                    }
                });
                filterResults = filterResults2;
            }
            return filterResults;
        }

        protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
            if (filterResults.values == null) {
                this.oOc.oLL = new ArrayList();
            } else {
                this.oOc.oLL = (List) filterResults.values;
            }
            w.i(d.TAG, "results.count " + filterResults.count);
            if (filterResults.count > 0) {
                this.oOc.notifyDataSetChanged();
            }
        }

        private static int[] dh(String str, String str2) {
            if (str.equals(str2)) {
                return com.tencent.mm.plugin.recharge.model.a.oKR;
            }
            if (str2 != null && str.length() == str2.length()) {
                int[] iArr = new int[]{-1, -1};
                int i = 0;
                for (int length = str.length() - 1; length > 0; length--) {
                    if (str2.charAt(length) != str.charAt(length)) {
                        i++;
                        if (i > 2) {
                            break;
                        }
                        iArr[i - 1] = length;
                    }
                }
                if (i <= 2) {
                    return iArr;
                }
            }
            return com.tencent.mm.plugin.recharge.model.a.oKS;
        }
    }

    private class c {
        TextView iuF;
        TextView oLT;
        final /* synthetic */ d oOc;
        ImageView oOe;

        public c(d dVar) {
            this.oOc = dVar;
        }
    }

    public interface d {
    }

    public final /* synthetic */ Object getItem(int i) {
        return rN(i);
    }

    public d(MallFormView mallFormView, List<String[]> list) {
        this.mContext = mallFormView.getContext();
        this.oNm = mallFormView;
        this.oLB = (AutoCompleteTextView) mallFormView.oNs;
        this.oLF = list;
    }

    public final void bf(List<com.tencent.mm.plugin.recharge.model.a> list) {
        this.oLN = list;
        this.oLL.clear();
        this.oLM = false;
        notifyDataSetChanged();
    }

    public final Filter getFilter() {
        w.d(TAG, "getFilter");
        if (this.oNZ == null) {
            this.oNZ = new b();
        }
        return this.oNZ;
    }

    public final int getCount() {
        if (this.oLM) {
            return this.oLL.size() + 2;
        }
        return this.oLL.size() > 0 ? this.oLL.size() + 1 : 0;
    }

    public final synchronized com.tencent.mm.plugin.recharge.model.a rN(int i) {
        com.tencent.mm.plugin.recharge.model.a aVar = null;
        synchronized (this) {
            if (this.oLM) {
                if (i != 0) {
                    if (i <= this.oLL.size()) {
                        aVar = (com.tencent.mm.plugin.recharge.model.a) this.oLL.get(i - 1);
                    }
                }
            } else if (i < this.oLL.size()) {
                aVar = (com.tencent.mm.plugin.recharge.model.a) this.oLL.get(i);
            }
        }
        return aVar;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        switch (getItemViewType(i)) {
            case 0:
                c cVar;
                if (view == null) {
                    view = View.inflate(this.mContext, R.i.dmg, null);
                    c cVar2 = new c(this);
                    cVar2.oLT = (TextView) view.findViewById(R.h.chn);
                    cVar2.iuF = (TextView) view.findViewById(R.h.chm);
                    cVar2.oOe = (ImageView) view.findViewById(R.h.cJr);
                    view.setTag(cVar2);
                    cVar = cVar2;
                } else {
                    cVar = (c) view.getTag();
                }
                if (!(cVar == null || cVar.oOe == null)) {
                    if (i == 0) {
                        cVar.oOe.setVisibility(0);
                    } else {
                        cVar.oOe.setVisibility(8);
                    }
                }
                com.tencent.mm.plugin.recharge.model.a rN = rN(i);
                if (rN == null || cVar == null || cVar.oLT == null || cVar.iuF == null) {
                    return view;
                }
                CharSequence Dj = com.tencent.mm.plugin.recharge.model.b.Dj(rN.oKT);
                w.d(TAG, "record.record " + Dj + ", record.name " + rN.name + "，record.location " + rN.oKU);
                if (com.tencent.mm.plugin.recharge.model.a.oKR.equals(rN.oKV)) {
                    cVar.oLT.setTextSize(16.0f);
                    cVar.oLT.setTextColor(this.mContext.getResources().getColor(R.e.aUo));
                    cVar.iuF.setTextColor(this.mContext.getResources().getColor(R.e.aUo));
                    cVar.oLT.setText(Dj);
                } else {
                    CharSequence spannableStringBuilder = new SpannableStringBuilder(Dj);
                    for (int i2 : rN.oKV) {
                        int i22;
                        if (i22 >= 0) {
                            if (i22 >= 7) {
                                i22 += 2;
                            } else if (i22 >= 3) {
                                i22++;
                            }
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.mContext.getResources().getColor(R.e.aVC)), i22, i22 + 1, 34);
                        }
                    }
                    cVar.oLT.setTextSize(24.0f);
                    cVar.oLT.setTextColor(this.mContext.getResources().getColor(R.e.aVo));
                    cVar.iuF.setTextColor(this.mContext.getResources().getColor(R.e.aVo));
                    cVar.oLT.setText(spannableStringBuilder);
                }
                if (rN.name != null && !bg.mA(rN.name.trim())) {
                    if (bg.mA(rN.oKU)) {
                        cVar.iuF.setText(rN.name);
                    } else {
                        cVar.iuF.setText(rN.name + this.mContext.getString(R.l.fjz, new Object[]{rN.oKU}));
                    }
                    if (rN.name.equals(this.mContext.getString(R.l.fjF))) {
                        cVar.iuF.setTextColor(this.mContext.getResources().getColor(R.e.aVA));
                        return view;
                    }
                    cVar.iuF.setTextColor(this.mContext.getResources().getColor(R.e.aVl));
                    return view;
                } else if (bg.mA(rN.oKU)) {
                    cVar.iuF.setText(this.mContext.getString(R.l.fjH));
                    return view;
                } else {
                    cVar.iuF.setText(this.mContext.getString(R.l.fjH) + this.mContext.getString(R.l.fjz, new Object[]{rN.oKU}));
                    return view;
                }
            case 1:
                view = View.inflate(this.mContext, R.i.dmh, null);
                view.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ d oOc;

                    {
                        this.oOc = r1;
                    }

                    public final void onClick(View view) {
                        com.tencent.mm.plugin.recharge.a.a.aWd().bf(null);
                        this.oOc.oNm.aWw();
                        this.oOc.bf(new LinkedList());
                        if (this.oOc.oOb != null) {
                            this.oOc.oOb.aWn();
                        }
                    }
                });
                return view;
            case 2:
                view = View.inflate(this.mContext, R.i.dmf, null);
                view.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ d oOc;

                    {
                        this.oOc = r1;
                    }

                    public final void onClick(View view) {
                        this.oOc.oLB.dismissDropDown();
                    }
                });
                return view;
            case 3:
                view = View.inflate(this.mContext, R.i.dmh, null);
                ((TextView) view.findViewById(R.h.cwA)).setText(R.l.eAk);
                view.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ d oOc;

                    {
                        this.oOc = r1;
                    }

                    public final void onClick(View view) {
                        this.oOc.oLB.dismissDropDown();
                        this.oOc.oNm.aWv();
                    }
                });
                return view;
            default:
                return view;
        }
    }

    public final int getItemViewType(int i) {
        if (this.oLM) {
            if (i == 0) {
                return 2;
            }
            if (i > this.oLL.size()) {
                return 3;
            }
            return 0;
        } else if (i >= this.oLL.size()) {
            return 1;
        } else {
            return 0;
        }
    }

    public final int getViewTypeCount() {
        return 4;
    }
}
