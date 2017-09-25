package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.protocal.c.sz;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.Iterator;
import java.util.LinkedList;

public final class s extends BaseAdapter {
    private Context context;
    private String fDs = "";
    private LinkedList<a> hkm = new LinkedList();

    public static class a {
        public int actionType;
        public String appId;
        public String description;
        public String mET;
        public String text;
        public int type;
    }

    private static class b {
        TextView iUO;
        ViewGroup mEU;
        TextView mEV;
        TextView mEW;
        ViewGroup mEX;
        TextView mEY;
        ViewGroup mEZ;
    }

    public final /* synthetic */ Object getItem(int i) {
        return nM(i);
    }

    public s(Context context) {
        this.context = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        a nM = nM(i);
        if (view == null) {
            view = View.inflate(this.context, R.i.dfo, null);
            b bVar2 = new b();
            bVar2.iUO = (TextView) view.findViewById(R.h.bUU);
            bVar2.mEU = (ViewGroup) bVar2.iUO.getParent();
            bVar2.mEV = (TextView) view.findViewById(R.h.bUT);
            bVar2.mEW = (TextView) view.findViewById(R.h.bUR);
            bVar2.mEX = (ViewGroup) bVar2.mEV.getParent();
            bVar2.mEY = (TextView) view.findViewById(R.h.bUS);
            bVar2.mEZ = (ViewGroup) bVar2.mEY.getParent().getParent();
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        switch (nM.type) {
            case 1:
                bVar.mEU.setVisibility(0);
                bVar.mEX.setVisibility(8);
                bVar.mEZ.setVisibility(8);
                bVar.mEU.setOnClickListener(null);
                bVar.iUO.setText(nM.text);
                break;
            case 2:
                bVar.mEU.setVisibility(8);
                bVar.mEX.setVisibility(0);
                bVar.mEZ.setVisibility(8);
                bVar.mEV.setText(nM.text);
                bVar.mEW.setText(nM.description);
                break;
            case 3:
                bVar.mEU.setVisibility(8);
                bVar.mEX.setVisibility(8);
                bVar.mEZ.setVisibility(0);
                bVar.mEY.setTextColor(this.context.getResources().getColor(R.e.aVo));
                int color = this.context.getResources().getColor(R.e.aTX);
                int indexOf = nM.text.indexOf(this.fDs);
                if (indexOf < 0) {
                    bVar.mEY.setText(nM.text);
                    break;
                }
                CharSequence spannableString = new SpannableString(nM.text);
                spannableString.setSpan(new ForegroundColorSpan(color), indexOf, this.fDs.length() + indexOf, 33);
                bVar.mEY.setText(spannableString);
                break;
        }
        return view;
    }

    public final int getCount() {
        return this.hkm.size();
    }

    public final a nM(int i) {
        return (a) this.hkm.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final void a(String str, String str2, LinkedList<sz> linkedList) {
        if (!bg.bV(linkedList)) {
            this.fDs = str;
            this.hkm.clear();
            if (bg.mA(str)) {
                a aVar = new a();
                aVar.type = 1;
                if (bg.mA(str2)) {
                    aVar.text = this.context.getString(R.l.bUU);
                } else {
                    aVar.text = str2;
                }
                this.hkm.add(aVar);
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                sz szVar = (sz) it.next();
                a aVar2 = new a();
                aVar2.type = bg.mA(str) ? 2 : 3;
                aVar2.appId = szVar.msh;
                aVar2.text = szVar.tAU;
                aVar2.description = szVar.tgT;
                aVar2.actionType = szVar.tAL;
                aVar2.mET = szVar.tAM;
                this.hkm.add(aVar2);
            }
            notifyDataSetChanged();
        }
    }
}
