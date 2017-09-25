package com.tencent.mm.plugin.card.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.ui.r;
import java.util.Iterator;
import java.util.LinkedList;

public final class w extends i {
    private View kqA;
    private View kqB;

    public final void KC() {
    }

    public final void update() {
        b ahj = this.kqe.ahj();
        g aho = this.kqe.aho();
        lz lzVar;
        if (ahj.afj().tnH != null && ahj.afj().tnH.size() > 1) {
            if (this.kqA == null) {
                this.kqA = ((ViewStub) findViewById(R.h.byl)).inflate();
            }
            if (this.kqB != null) {
                this.kqB.setVisibility(8);
            }
            Context ahm = this.kqe.ahm();
            View view = this.kqA;
            OnClickListener ahn = this.kqe.ahn();
            LinkedList linkedList = ahj.afj().tnH;
            int ta = l.ta(ahj.afi().hib);
            ((ViewGroup) view).removeAllViews();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                lzVar = (lz) it.next();
                View inflate = r.eC(ahm).inflate(R.i.cWS, (ViewGroup) view, false);
                inflate.setId(R.h.bym);
                inflate.setTag(Integer.valueOf(linkedList.indexOf(lzVar)));
                inflate.setOnClickListener(ahn);
                if (TextUtils.isEmpty(lzVar.url)) {
                    inflate.setEnabled(false);
                }
                ((TextView) inflate.findViewById(R.h.cBm)).setText(lzVar.title);
                TextView textView = (TextView) inflate.findViewById(R.h.cBj);
                textView.setText(lzVar.kdH);
                textView.setTextColor(ta);
                ((ViewGroup) view).addView(inflate);
                if (linkedList.indexOf(lzVar) + 1 != linkedList.size()) {
                    ((ViewGroup) view).addView(r.eC(ahm).inflate(R.i.cWT, (ViewGroup) view, false));
                }
            }
            if (!(!ahj.aeP() || ahj.afj().tnO == null || TextUtils.isEmpty(ahj.afj().tnO.title))) {
                this.kqA.setBackgroundResource(R.g.bhc);
            }
            if (!ahj.aeP() && aho.aim()) {
                this.kqA.setBackgroundResource(R.g.bhc);
            }
        } else if (ahj.afj().tnH == null || ahj.afj().tnH.size() != 1) {
            if (this.kqA != null) {
                this.kqA.setVisibility(8);
            }
            if (this.kqB != null) {
                this.kqB.setVisibility(8);
            }
        } else {
            if (this.kqB == null) {
                this.kqB = ((ViewStub) findViewById(R.h.byk)).inflate();
            }
            if (this.kqA != null) {
                this.kqA.setVisibility(8);
            }
            View view2 = this.kqB;
            OnClickListener ahn2 = this.kqe.ahn();
            LinkedList linkedList2 = ahj.afj().tnH;
            if (linkedList2.size() == 1) {
                view2.findViewById(R.h.byn).setVisibility(0);
                lzVar = (lz) linkedList2.get(0);
                ((TextView) view2.findViewById(R.h.cBn)).setText(lzVar.title);
                ((TextView) view2.findViewById(R.h.cBk)).setText(lzVar.kdH);
                ((TextView) view2.findViewById(R.h.cBk)).setTextColor(l.ta(ahj.afi().hib));
                view2.findViewById(R.h.byn).setOnClickListener(ahn2);
                if (TextUtils.isEmpty(lzVar.url)) {
                    view2.findViewById(R.h.byn).setEnabled(false);
                }
            }
            if (!(!ahj.aeP() || ahj.afj().tnO == null || TextUtils.isEmpty(ahj.afj().tnO.title))) {
                this.kqB.setBackgroundResource(R.g.bhc);
            }
            if (!ahj.aeP() && aho.aim()) {
                this.kqB.setBackgroundResource(R.g.bhc);
            }
        }
    }

    public final void aiz() {
        if (this.kqA != null) {
            this.kqA.setVisibility(8);
        }
        if (this.kqB != null) {
            this.kqB.setVisibility(8);
        }
    }
}
