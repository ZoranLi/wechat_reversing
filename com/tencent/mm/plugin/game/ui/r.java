package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.te;
import com.tencent.mm.protocal.c.tf;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class r extends BaseAdapter {
    Context context;
    boolean fDw = false;
    ArrayList<b> kyt;
    int mBF = 0;
    boolean mEo = false;
    int mEp = 0;
    int mEq = 0;
    int mEr = 0;
    int mEs = 0;
    private int mEt;
    boolean mEu = false;
    boolean mEv = false;
    private ArrayList<d> mEw;
    int mqY = 0;

    private static class a {
        public View ipu;
        ImageView mEA;
        TextView mEB;
        TextView mEC;
        TextView mED;
        TextView mEE;
        View mEF;
        TextView mEG;
        TextView mEH;
    }

    public static class b {
        public int actionType;
        public String appId;
        public String fDs;
        public String hnA;
        public String iBi;
        public long iam;
        public String iconUrl;
        public String mEI;
        public tf mEJ;
        public String mEK;
        public LinkedList<String> mEL;
        public int mEM;
        public int mEN;
        public boolean mEO = false;
        public boolean mEP = false;
        public c mEQ;
        public String name;
        public int type;

        public static b ac(int i, String str) {
            b bVar = new b();
            bVar.type = i;
            bVar.name = str;
            bVar.mEQ = new c();
            return bVar;
        }

        public static b a(te teVar) {
            b bVar = new b();
            bVar.type = 2;
            bVar.name = teVar.fDC;
            bVar.iBi = teVar.msk;
            bVar.iconUrl = teVar.ohq;
            bVar.mEK = teVar.tAM;
            bVar.mEM = teVar.tBh;
            bVar.mEN = teVar.tBi;
            bVar.appId = teVar.mtb;
            bVar.hnA = teVar.muS;
            bVar.iam = (long) teVar.bHh;
            bVar.mEQ = new c(teVar.tAM, (byte) 0);
            return bVar;
        }
    }

    public static class c {
        public int actionType;
        String appId;
        int fTL;
        int mEM;
        int mEN;
        String mER;
        String mES;
        int position;
        int type;

        public c(String str) {
            this.actionType = 2;
            this.mER = str;
        }

        public c(String str, byte b) {
            this.actionType = 2;
            this.type = 3;
            this.mER = str;
        }

        public c(int i, int i2, String str, String str2) {
            this.actionType = i;
            this.type = i2;
            this.appId = str;
            if (i == 2) {
                this.mER = str2;
            }
        }
    }

    private class d {
        int end = -1;
        final /* synthetic */ r mEz;
        int start = -1;

        public d(r rVar) {
            this.mEz = rVar;
        }
    }

    public r(Context context) {
        this.context = context;
        this.kyt = null;
        this.mEt = context.getResources().getColor(R.e.aTX);
    }

    public final int getCount() {
        return this.kyt == null ? 0 : this.kyt.size();
    }

    public final Object getItem(int i) {
        return this.kyt.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        return ((b) getItem(i)).type;
    }

    public final int getViewTypeCount() {
        return 7;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        b bVar = (b) getItem(i);
        if (view == null) {
            int i2;
            aVar = new a();
            Context context = this.context;
            switch (bVar.type) {
                case 0:
                    i2 = R.i.dfq;
                    break;
                case 1:
                    i2 = R.i.dfk;
                    break;
                case 2:
                    i2 = R.i.dfr;
                    break;
                case 3:
                    i2 = R.i.dfp;
                    break;
                case 5:
                    i2 = R.i.dfm;
                    break;
                case 6:
                    i2 = R.i.dfn;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            view = View.inflate(context, i2, null);
            aVar.ipu = view.findViewById(R.h.bUi);
            aVar.mEA = (ImageView) view.findViewById(R.h.bUl);
            aVar.mEB = (TextView) view.findViewById(R.h.bUm);
            aVar.mEC = (TextView) view.findViewById(R.h.bUh);
            aVar.mED = (TextView) view.findViewById(R.h.bUj);
            aVar.mEE = (TextView) view.findViewById(R.h.bUn);
            aVar.mEF = view.findViewById(R.h.bUk);
            aVar.mEG = (TextView) view.findViewById(R.h.cGb);
            aVar.mEH = (TextView) view.findViewById(R.h.bHh);
            view.setTag(aVar);
            if (!(aVar.mEB == null || aVar.mED == null)) {
                final TextView textView = aVar.mEB;
                final TextView textView2 = aVar.mED;
                textView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener(this) {
                    final /* synthetic */ r mEz;

                    public final void onGlobalLayout() {
                        if (textView.getLineCount() > 1) {
                            textView.setMaxLines(2);
                            textView2.setMaxLines(1);
                            return;
                        }
                        textView2.setMaxLines(2);
                    }
                });
            }
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.game.d.e.a.a aVar2;
        switch (bVar.type) {
            case 0:
                aVar.mED.setText(bVar.name);
                break;
            case 1:
                if (!bg.mA(bVar.iconUrl)) {
                    aVar2 = new com.tencent.mm.plugin.game.d.e.a.a();
                    aVar2.hIJ = false;
                    aVar2.hIL = false;
                    e.aCi().a(aVar.mEA, bVar.iconUrl, aVar2.aCj());
                }
                a(aVar.mEB, bVar.name);
                a(aVar.mEC, bVar.mEI);
                a(aVar.mED, bVar.iBi);
                break;
            case 2:
                if (bg.mA(bVar.iconUrl)) {
                    aVar.mEA.setVisibility(8);
                } else {
                    aVar2 = new com.tencent.mm.plugin.game.d.e.a.a();
                    aVar2.hIJ = false;
                    aVar2.hIL = false;
                    aVar2.mGz = true;
                    e.aCi().a(aVar.mEA, bVar.iconUrl, aVar2.aCj());
                    aVar.mEA.setVisibility(0);
                }
                a(aVar.mEB, bVar.name);
                a(aVar.mED, bVar.iBi);
                if (bg.mA(bVar.hnA)) {
                    aVar.mEG.setVisibility(8);
                } else {
                    aVar.mEG.setText(h.a(this.context, bVar.hnA));
                    aVar.mEG.setVisibility(0);
                }
                if (bVar.iam <= 0) {
                    aVar.mEH.setVisibility(8);
                    break;
                }
                aVar.mEH.setText(com.tencent.mm.plugin.game.d.b.f(this.context, bVar.iam * 1000));
                aVar.mEH.setVisibility(0);
                break;
            case 3:
                if (!bg.mA(bVar.iconUrl)) {
                    aVar2 = new com.tencent.mm.plugin.game.d.e.a.a();
                    aVar2.hIJ = false;
                    aVar2.hIL = false;
                    e.aCi().a(aVar.mEA, bVar.iconUrl, aVar2.aCj());
                }
                a(aVar.mEB, bVar.name);
                a(aVar.mEC, bVar.mEI);
                a(aVar.mED, bVar.iBi);
                TextView textView3 = aVar.mEE;
                LinkedList linkedList = bVar.mEL;
                StringBuilder stringBuilder = new StringBuilder();
                if (!bg.bV(linkedList)) {
                    int size = linkedList.size();
                    for (int i3 = 0; i3 < size - 1; i3++) {
                        stringBuilder.append(((String) linkedList.get(i3)) + "\n");
                    }
                    stringBuilder.append((String) linkedList.get(size - 1));
                    textView3.setVisibility(0);
                    textView3.setText(stringBuilder.toString());
                    break;
                }
                textView3.setVisibility(8);
                break;
            case 5:
                aVar.mEA.setImageResource(R.k.dzs);
                break;
            case 6:
                break;
        }
        aVar.mEB.setText(bVar.name);
        switch (bVar.type) {
            case 0:
                if (!bVar.mEO) {
                    aVar.mEF.setVisibility(0);
                    break;
                }
                aVar.mEF.setVisibility(8);
                break;
            case 1:
            case 2:
            case 3:
            case 5:
                if (bVar.mEP) {
                    aVar.ipu.setBackgroundResource(R.g.bep);
                } else {
                    aVar.ipu.setBackgroundResource(R.g.beo);
                }
                int dimensionPixelSize = this.context.getResources().getDimensionPixelSize(R.f.aXN);
                aVar.ipu.setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
                break;
        }
        return view;
    }

    private void a(TextView textView, String str) {
        if (bg.mA(str)) {
            textView.setVisibility(8);
            return;
        }
        if (this.mEw == null) {
            this.mEw = new ArrayList();
        } else {
            this.mEw.clear();
        }
        StringBuilder stringBuilder = new StringBuilder(str);
        d dVar = new d(this);
        for (int indexOf = stringBuilder.indexOf("<em>"); indexOf >= 0; indexOf = stringBuilder.indexOf("<em>")) {
            dVar.start = indexOf;
            stringBuilder.delete(indexOf, indexOf + 4);
            indexOf = stringBuilder.indexOf("</em>");
            if (indexOf < 0) {
                break;
            }
            dVar.end = indexOf;
            stringBuilder.delete(indexOf, indexOf + 5);
            this.mEw.add(dVar);
        }
        CharSequence spannableString = new SpannableString(stringBuilder.toString());
        Iterator it = this.mEw.iterator();
        while (it.hasNext()) {
            d dVar2 = (d) it.next();
            if (dVar2.start < dVar2.end) {
                spannableString.setSpan(new ForegroundColorSpan(this.mEt), dVar2.start, dVar2.end, 33);
            }
        }
        textView.setText(spannableString);
        textView.setVisibility(0);
    }
}
