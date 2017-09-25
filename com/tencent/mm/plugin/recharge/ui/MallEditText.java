package com.tencent.mm.plugin.recharge.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MallEditText extends LinearLayout implements OnFocusChangeListener {
    private int gravity;
    private int imeOptions;
    private int inputType;
    private TextView ipW;
    private OnFocusChangeListener itW;
    ImageView itZ;
    private String iua;
    String iub;
    int iuc;
    public boolean iue;
    boolean iug;
    private int iuh;
    private int iui;
    b oLA;
    AutoCompleteTextView oLB;
    boolean oLC;
    private a oLD;
    private boolean oLE;
    private List<String[]> oLF;
    private com.tencent.mm.plugin.recharge.model.a oLG;
    private Runnable oLH;
    private boolean oLI;
    private int oLJ;

    private class a extends BaseAdapter implements Filterable {
        final /* synthetic */ MallEditText oLK;
        public List<com.tencent.mm.plugin.recharge.model.a> oLL;
        public boolean oLM;
        private List<com.tencent.mm.plugin.recharge.model.a> oLN;
        private a oLO;
        private String oLP;

        private class a extends Filter {
            final /* synthetic */ a oLQ;

            private a(a aVar) {
                this.oLQ = aVar;
            }

            protected final synchronized FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults;
                FilterResults filterResults2 = new FilterResults();
                List arrayList = new ArrayList();
                String Di = charSequence != null ? com.tencent.mm.plugin.recharge.model.b.Di(charSequence.toString()) : "";
                if (Di.equals(this.oLQ.oLP)) {
                    this.oLQ.oLK.oLB.post(new Runnable(this) {
                        final /* synthetic */ a oLR;

                        {
                            this.oLR = r1;
                        }

                        public final void run() {
                            this.oLR.oLQ.oLK.oLB.dismissDropDown();
                        }
                    });
                    filterResults = filterResults2;
                } else {
                    final com.tencent.mm.plugin.recharge.model.a aVar;
                    boolean z;
                    boolean z2;
                    this.oLQ.oLP = Di;
                    if (this.oLQ.oLK.Pb()) {
                        long currentTimeMillis = System.currentTimeMillis();
                        w.d("MicroMsg.MallEditText", "performFiltering " + charSequence);
                        for (com.tencent.mm.plugin.recharge.model.a aVar2 : this.oLQ.oLN) {
                            if (aVar2.oKT.equals(this.oLQ.oLP)) {
                                aVar2.oKV = com.tencent.mm.plugin.recharge.model.a.oKR;
                                arrayList.clear();
                                arrayList.add(aVar2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            if (this.oLQ.oLK.oLF == null) {
                                try {
                                    this.oLQ.oLK.oLF = com.tencent.mm.pluginsdk.a.dn(this.oLQ.oLK.getContext());
                                } catch (Throwable e) {
                                    w.printErrStackTrace("MicroMsg.MallEditText", e, "", new Object[0]);
                                }
                            }
                            if (this.oLQ.oLK.oLF != null) {
                                for (String[] strArr : this.oLQ.oLK.oLF) {
                                    String Di2 = com.tencent.mm.plugin.recharge.model.b.Di(strArr[2]);
                                    Object dh = dh(this.oLQ.oLP, Di2);
                                    if (com.tencent.mm.plugin.recharge.model.a.oKR.equals(dh)) {
                                        com.tencent.mm.plugin.recharge.model.a aVar3 = new com.tencent.mm.plugin.recharge.model.a(Di2, strArr[1], 1);
                                        aVar3.oKV = com.tencent.mm.plugin.recharge.model.a.oKR;
                                        arrayList.clear();
                                        arrayList.add(aVar3);
                                        break;
                                    } else if (!com.tencent.mm.plugin.recharge.model.a.oKS.equals(dh) && arrayList.size() < 5) {
                                        com.tencent.mm.plugin.recharge.model.a aVar4 = new com.tencent.mm.plugin.recharge.model.a(Di2, strArr[1], 1);
                                        aVar4.oKV = dh;
                                        arrayList.add(aVar4);
                                    }
                                }
                            }
                        }
                        w.d("MicroMsg.MallEditText", " search phone number cost " + (System.currentTimeMillis() - currentTimeMillis) + " ms ");
                        z = true;
                    } else if (bg.mA(this.oLQ.oLP)) {
                        arrayList.addAll(this.oLQ.oLN);
                        z = false;
                    } else {
                        w.d("MicroMsg.MallEditText", "performFiltering " + charSequence);
                        for (com.tencent.mm.plugin.recharge.model.a aVar22 : this.oLQ.oLN) {
                            if (aVar22.oKT.startsWith(this.oLQ.oLP)) {
                                arrayList.add(aVar22);
                            }
                        }
                        z = false;
                    }
                    if (arrayList.size() == 0) {
                        this.oLQ.oLK.oLB.post(new Runnable(this) {
                            final /* synthetic */ a oLR;

                            {
                                this.oLR = r1;
                            }

                            public final void run() {
                                this.oLR.oLQ.oLK.oLB.dismissDropDown();
                            }
                        });
                        z2 = false;
                    } else {
                        if (arrayList.size() == 1 && this.oLQ.oLK.Pb()) {
                            aVar22 = (com.tencent.mm.plugin.recharge.model.a) arrayList.get(0);
                            if (com.tencent.mm.plugin.recharge.model.a.oKR.equals(aVar22.oKV)) {
                                this.oLQ.oLK.oLB.post(new Runnable(this) {
                                    final /* synthetic */ a oLR;

                                    public final void run() {
                                        this.oLR.oLQ.oLK.oLG = aVar22;
                                        if (bg.mA(this.oLR.oLQ.oLK.oLG.name)) {
                                            this.oLR.oLQ.oLK.ipW.setText("");
                                            this.oLR.oLQ.oLK.ipW.setVisibility(8);
                                        } else {
                                            this.oLR.oLQ.oLK.ipW.setText(this.oLR.oLQ.oLK.oLG.name);
                                            this.oLR.oLQ.oLK.ipW.setVisibility(0);
                                        }
                                        this.oLR.oLQ.oLK.oLB.dismissDropDown();
                                    }
                                });
                                z2 = false;
                            }
                        }
                        z2 = z;
                    }
                    List list = this.oLQ.oLL;
                    this.oLQ.oLL = arrayList;
                    this.oLQ.oLM = z2;
                    filterResults2.count = this.oLQ.oLL.size();
                    filterResults2.values = this.oLQ.oLL;
                    w.d("MicroMsg.MallEditText", "results.count " + filterResults2.count);
                    list.clear();
                    filterResults = filterResults2;
                }
                return filterResults;
            }

            protected final void publishResults(CharSequence charSequence, FilterResults filterResults) {
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

        private a(MallEditText mallEditText) {
            this.oLK = mallEditText;
            this.oLL = new ArrayList();
            this.oLM = false;
        }

        public final /* synthetic */ Object getItem(int i) {
            return rN(i);
        }

        public final void bf(List<com.tencent.mm.plugin.recharge.model.a> list) {
            this.oLN = list;
            this.oLL.clear();
            this.oLM = false;
        }

        public final Filter getFilter() {
            w.d("MicroMsg.MallEditText", "getFilter");
            if (this.oLO == null) {
                this.oLO = new a();
            }
            return this.oLO;
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
                        view = View.inflate(this.oLK.getContext(), R.i.dmg, null);
                        c cVar2 = new c(this.oLK);
                        cVar2.oLT = (TextView) view.findViewById(R.h.chn);
                        cVar2.iuF = (TextView) view.findViewById(R.h.chm);
                        view.setTag(cVar2);
                        cVar = cVar2;
                    } else {
                        cVar = (c) view.getTag();
                    }
                    com.tencent.mm.plugin.recharge.model.a rN = rN(i);
                    if (rN == null || cVar == null || cVar.oLT == null || cVar.iuF == null) {
                        return view;
                    }
                    CharSequence Dj = com.tencent.mm.plugin.recharge.model.b.Dj(rN.oKT);
                    w.d("MicroMsg.MallEditText", "record.record " + Dj + ", record.name " + rN.name);
                    if (com.tencent.mm.plugin.recharge.model.a.oKR.equals(rN.oKV)) {
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
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(-65536), i22, i22 + 1, 34);
                            }
                        }
                        cVar.oLT.setText(spannableStringBuilder);
                    }
                    if (rN.name == null || bg.mA(rN.name.trim())) {
                        cVar.iuF.setText("");
                    } else {
                        cVar.iuF.setText(this.oLK.getResources().getString(R.l.eAs, new Object[]{rN.name}));
                    }
                    view.setBackgroundResource(R.g.beo);
                    return view;
                case 1:
                    view = View.inflate(this.oLK.getContext(), R.i.dmh, null);
                    view.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ a oLQ;

                        {
                            this.oLQ = r1;
                        }

                        public final void onClick(View view) {
                            com.tencent.mm.plugin.recharge.a.a.aWd().bf(null);
                            this.oLQ.oLK.b(null);
                            this.oLQ.oLK.oLD.bf(new LinkedList());
                            this.oLQ.oLK.oLD.notifyDataSetChanged();
                        }
                    });
                    return view;
                case 2:
                    view = View.inflate(this.oLK.getContext(), R.i.dmf, null);
                    view.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ a oLQ;

                        {
                            this.oLQ = r1;
                        }

                        public final void onClick(View view) {
                            this.oLQ.oLK.oLB.dismissDropDown();
                        }
                    });
                    return view;
                case 3:
                    View inflate = View.inflate(this.oLK.getContext(), R.i.dmh, null);
                    ((TextView) inflate).setText(R.l.eAk);
                    inflate.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ a oLQ;

                        {
                            this.oLQ = r1;
                        }

                        public final void onClick(View view) {
                            this.oLQ.oLK.oLB.dismissDropDown();
                        }
                    });
                    return inflate;
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

    public interface b {
        void aWj();

        void gA(boolean z);
    }

    private class c {
        TextView iuF;
        final /* synthetic */ MallEditText oLK;
        TextView oLT;

        public c(MallEditText mallEditText) {
            this.oLK = mallEditText;
        }
    }

    public MallEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.oLD = null;
        this.iua = "";
        this.iub = "";
        this.inputType = 1;
        this.oLE = true;
        this.iui = -1;
        this.iuh = 1;
        this.gravity = 19;
        this.iuc = -1;
        this.iug = false;
        this.oLG = null;
        this.iue = true;
        this.oLH = null;
        this.oLI = false;
        this.oLJ = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.n.fqI, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.n.fqQ, 0);
        if (resourceId != 0) {
            this.iua = context.getString(resourceId);
        }
        resourceId = obtainStyledAttributes.getResourceId(R.n.fqR, 0);
        if (resourceId != 0) {
            this.iub = context.getString(resourceId);
        }
        this.inputType = obtainStyledAttributes.getInteger(R.n.fqN, 1);
        this.iue = obtainStyledAttributes.getBoolean(R.n.fqK, true);
        this.gravity = obtainStyledAttributes.getInt(R.n.fqL, 19);
        this.oLE = obtainStyledAttributes.getBoolean(R.n.fqJ, true);
        this.iui = obtainStyledAttributes.getInteger(R.n.fqO, -1);
        this.iuc = obtainStyledAttributes.getInteger(R.n.fqP, 0);
        this.imeOptions = obtainStyledAttributes.getInteger(R.n.fqM, 5);
        obtainStyledAttributes.recycle();
        View inflate = LayoutInflater.from(context).inflate(R.i.dme, this, true);
        this.ipW = (TextView) inflate.findViewById(R.h.cLm);
        this.oLB = (AutoCompleteTextView) inflate.findViewById(R.h.bWk);
        if (com.tencent.mm.bg.a.dM(context)) {
            this.oLB.setTextSize(0, ((float) context.getResources().getDimensionPixelSize(R.f.aXI)) * 1.25f);
        } else {
            this.oLB.setTextSize(0, (float) com.tencent.mm.bg.a.T(context, R.f.aXI));
        }
        this.itZ = (ImageView) inflate.findViewById(R.h.bXC);
        w.d("MicroMsg.MallEditText", "setFormat editType:" + this.iuc);
        this.oLB.setImeOptions(this.imeOptions);
        switch (this.iuc) {
            case 0:
                if (!this.iue) {
                    this.itZ.setImageResource(R.g.bha);
                    this.itZ.setVisibility(0);
                    break;
                }
                break;
            case 1:
                this.iuh = 13;
                this.iui = 13;
                this.inputType = 2;
                rM(R.g.biX);
                this.itZ.setVisibility(0);
                break;
        }
        this.inputType = 1;
        this.oLB.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ MallEditText oLK;

            {
                this.oLK = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                String charSequence2 = charSequence.toString();
                int selectionStart = this.oLK.oLB.getSelectionStart();
                String str = "";
                if (charSequence2 != null) {
                    StringBuilder stringBuilder = new StringBuilder(charSequence2.replaceAll(" ", ""));
                    int length = stringBuilder.length();
                    if (length >= 4) {
                        stringBuilder.insert(3, ' ');
                    }
                    if (length >= 8) {
                        stringBuilder.insert(8, ' ');
                    }
                    str = stringBuilder.toString();
                    length = str.length();
                    if (length > this.oLK.oLJ) {
                        if ((selectionStart == 4 || selectionStart == 9) && i3 == 1) {
                            selectionStart++;
                        } else if ((selectionStart == 4 || selectionStart == 9) && i3 > 1) {
                            selectionStart += i3;
                        }
                    } else if (length < this.oLK.oLJ && (selectionStart == 4 || selectionStart == 9)) {
                        selectionStart--;
                    }
                    this.oLK.oLJ = length;
                }
                String str2 = str;
                int i4 = selectionStart;
                String str3 = str2;
                if (charSequence2.equals(str3)) {
                    this.oLK.aWh();
                    return;
                }
                this.oLK.oLB.setText(str3);
                if (i4 < this.oLK.oLJ) {
                    this.oLK.oLB.setSelection(i4);
                } else {
                    this.oLK.oLB.setSelection(this.oLK.oLJ);
                }
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.oLB.setOnFocusChangeListener(this);
        if (!bg.mA(this.iua)) {
            this.oLB.setHint(this.iua);
        }
        if (this.inputType == 2) {
            this.oLB.setKeyListener(new NumberKeyListener(this) {
                final /* synthetic */ MallEditText oLK;

                {
                    this.oLK = r1;
                }

                public final int getInputType() {
                    return 3;
                }

                protected final char[] getAcceptedChars() {
                    return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ' '};
                }
            });
        } else {
            this.oLB.setInputType(this.inputType);
            this.oLB.setRawInputType(this.inputType);
        }
        this.oLB.setGravity(this.gravity);
        if (!this.oLE) {
            this.oLB.setEnabled(false);
            this.oLB.setTextColor(getResources().getColor(R.e.black));
            this.oLB.setFocusable(false);
            this.oLB.setClickable(false);
        }
        if (this.iue) {
            this.iug = false;
        } else {
            this.iug = true;
            this.oLB.setEnabled(false);
            this.oLB.setFocusable(false);
            this.oLB.setClickable(false);
        }
        if (this.iui != -1) {
            this.oLB.setFilters(new InputFilter[]{new LengthFilter(this.iui)});
        }
        w.d("MicroMsg.MallEditText", "initData editType:" + this.iuc);
        switch (this.iuc) {
            case 1:
                w.d("MicroMsg.MallEditText", "setMobileEditTv");
                List aWe = com.tencent.mm.plugin.recharge.a.a.aWd().aWe();
                this.oLD = new a();
                this.oLD.bf(aWe);
                if (aWe != null && aWe.size() > 0) {
                    this.oLG = (com.tencent.mm.plugin.recharge.model.a) aWe.get(0);
                    b(this.oLG);
                } else if (this.oLF == null) {
                    new Runnable(this) {
                        final /* synthetic */ MallEditText oLK;

                        {
                            this.oLK = r1;
                        }

                        public final void run() {
                            try {
                                this.oLK.oLF = com.tencent.mm.pluginsdk.a.dn(this.oLK.getContext());
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.MallEditText", e, "", new Object[0]);
                            }
                        }
                    }.run();
                }
                if (aWe == null || aWe.size() == 0) {
                    ap.yY();
                    this.oLB.setText((String) com.tencent.mm.u.c.vr().get(6, null));
                    this.oLB.setSelection(this.oLB.getText().length());
                    aWh();
                }
                this.oLB.setAdapter(this.oLD);
                this.oLB.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ MallEditText oLK;

                    {
                        this.oLK = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.oLK.oLG = this.oLK.oLD.rN(i);
                        if (this.oLK.oLG != null) {
                            w.d("MicroMsg.MallEditText", "onItemClick record.record " + this.oLK.oLG.oKT + ", record.name " + this.oLK.oLG.name);
                            this.oLK.b(this.oLK.oLG);
                        }
                        this.oLK.oLB.dismissDropDown();
                    }
                });
                return;
            default:
                return;
        }
    }

    public MallEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void rM(int i) {
        this.oLC = i == R.g.bgg;
        this.itZ.setImageResource(i);
    }

    public final void b(com.tencent.mm.plugin.recharge.model.a aVar) {
        this.oLG = aVar;
        if (aVar != null) {
            this.oLB.setText(aVar.oKT);
            this.oLB.setSelection(this.oLB.getText().length());
            aWh();
            w.d("MicroMsg.MallEditText", "editTv.setText " + aVar.oKT + ", name " + aVar.name + ", isInputValid " + this.iug);
            if (bg.mA(aVar.name) || !this.iug) {
                this.ipW.setText("");
                this.ipW.setVisibility(8);
                return;
            }
            this.ipW.setText(aVar.name);
            this.ipW.setVisibility(0);
            return;
        }
        this.oLB.setText("");
        aWh();
        w.d("MicroMsg.MallEditText", "editTv.setText null");
        this.ipW.setText("");
        this.ipW.setVisibility(8);
    }

    private void aWh() {
        boolean Pb = Pb();
        if (Pb != this.iug) {
            w.d("MicroMsg.MallEditText", "View:" + this.iub + ", editType:" + this.iuc + " inputValid change to " + Pb);
            this.iug = Pb;
            if (this.oLA != null) {
                this.oLA.gA(this.iug);
            }
            if (!Pb) {
                if (this.ipW.getVisibility() == 0) {
                    this.ipW.setText("");
                    this.ipW.setVisibility(8);
                }
                this.oLG = null;
            }
        }
        if (this.oLA != null) {
            this.oLA.aWj();
        }
    }

    public final String getText() {
        switch (this.iuc) {
            case 1:
                return bg.ap(this.oLB.getText().toString(), "");
            default:
                return bg.ap(this.oLB.getText().toString(), "");
        }
    }

    public final boolean Pb() {
        switch (this.iuc) {
            case 1:
                String obj = this.oLB.getText().toString();
                if (obj.length() < this.iuh || obj.length() > this.iui || !PhoneNumberUtils.isGlobalPhoneNumber(com.tencent.mm.plugin.recharge.model.b.Di(obj))) {
                    return false;
                }
                return true;
            default:
                if (this.oLB.getText().length() >= this.iuh) {
                    return true;
                }
                return false;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.iue) {
            return false;
        }
        return true;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.oLB.setOnClickListener(onClickListener);
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        super.setOnFocusChangeListener(onFocusChangeListener);
        this.itW = onFocusChangeListener;
    }

    public void onFocusChange(View view, boolean z) {
        if (this.itW != null) {
            this.itW.onFocusChange(this, z);
        }
        if (!((!this.oLI) != z || z || this.oLH == null)) {
            this.oLH.run();
        }
        this.oLI = z;
        w.d("MicroMsg.MallEditText", "View:" + this.iub + ", editType:" + this.iuc + " onFocusChange to " + z);
        if (this.oLA != null) {
            this.oLA.gA(this.iug);
        }
    }

    public final com.tencent.mm.plugin.recharge.model.a aWi() {
        if (this.oLG != null) {
            return this.oLG;
        }
        this.oLG = new com.tencent.mm.plugin.recharge.model.a(getText(), this.ipW.getText().toString(), 0);
        return this.oLG;
    }
}
