package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class q extends BaseAdapter {
    private Context mContext;
    List<a> mDA;
    int mDC = 0;
    String mDD;
    a mDE;
    GameRankFooter mDF;
    boolean mDG = false;
    boolean mDH = false;
    int mDI = 0;
    LinkedList<a> mDz;

    public static class a implements Serializable {
        public String fSf;
        public int level = 0;
        public long mal;
        public int mre;
    }

    static final class b {
        public TextView mDJ;
        public ImageView mDK;
        public ImageView mDL;
        public TextView mDM;
        public TextView mDN;
        public ImageView mDO;

        b() {
        }
    }

    public q(Context context, GameRankFooter gameRankFooter) {
        this.mContext = context;
        this.mDz = new LinkedList();
        this.mDA = new LinkedList();
        this.mDD = m.xL();
        this.mDF = gameRankFooter;
    }

    public final void S(LinkedList<a> linkedList) {
        int i = 25;
        if (linkedList.size() == 0) {
            w.i("MicroMsg.GameRankAdapter", "Null or empty rank info");
            return;
        }
        this.mDz.clear();
        this.mDz.addAll(linkedList);
        if (this.mDz.size() <= 25) {
            i = this.mDz.size();
        }
        this.mDC = i;
        this.mDA = this.mDz.subList(0, this.mDC);
        this.mDI = 0;
        if (this.mDz != null && this.mDz.size() > 0) {
            Iterator it = this.mDz.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                this.mDI++;
                if (!bg.mA(aVar.fSf) && aVar.fSf.equals(this.mDD)) {
                    this.mDE = aVar;
                    break;
                }
            }
        }
        if (this.mDC == this.mDz.size()) {
            this.mDF.aBZ();
            this.mDH = true;
        } else {
            this.mDF.aBY();
        }
        if (this.mDG || this.mDI <= this.mDC) {
            this.mDF.aCa();
        } else if (this.mDE != null) {
            this.mDF.a(this.mDE);
        } else {
            this.mDF.aCa();
        }
    }

    public final int getCount() {
        return this.mDA.size();
    }

    public final Object getItem(int i) {
        return this.mDA.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            bVar = new b();
            view = View.inflate(this.mContext, R.i.dfi, null);
            bVar.mDJ = (TextView) view.findViewById(R.h.cvi);
            bVar.mDK = (ImageView) view.findViewById(R.h.cvh);
            bVar.mDL = (ImageView) view.findViewById(R.h.cLe);
            bVar.mDM = (TextView) view.findViewById(R.h.cLg);
            bVar.mDN = (TextView) view.findViewById(R.h.cLk);
            bVar.mDO = (ImageView) view.findViewById(R.h.cLf);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        a aVar = (a) getItem(i);
        ap.yY();
        af Rc = c.wR().Rc(aVar.fSf);
        if (Rc != null) {
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar.mDL, Rc.field_username);
            bVar.mDM.setText(new SpannableString(h.b(this.mContext, Rc.tL(), bVar.mDM.getTextSize())));
        }
        bVar.mDN.setText(bg.formatNumber(aVar.mal));
        switch (aVar.mre) {
            case 1:
                bVar.mDJ.setVisibility(8);
                bVar.mDK.setVisibility(0);
                bVar.mDK.setImageResource(R.g.bfF);
                break;
            case 2:
                bVar.mDJ.setVisibility(8);
                bVar.mDK.setVisibility(0);
                bVar.mDK.setImageResource(R.g.bkc);
                break;
            case 3:
                bVar.mDJ.setVisibility(8);
                bVar.mDK.setVisibility(0);
                bVar.mDK.setImageResource(R.g.bcZ);
                break;
            default:
                bVar.mDJ.setVisibility(0);
                bVar.mDK.setVisibility(8);
                bVar.mDJ.setText(aVar.mre);
                break;
        }
        switch (aVar.level) {
            case 1:
                bVar.mDO.setVisibility(0);
                bVar.mDO.setImageResource(R.g.bfy);
                break;
            case 2:
                bVar.mDO.setVisibility(0);
                bVar.mDO.setImageResource(R.g.bfz);
                break;
            case 3:
                bVar.mDO.setVisibility(0);
                bVar.mDO.setImageResource(R.g.bfA);
                break;
            case 4:
                bVar.mDO.setVisibility(0);
                bVar.mDO.setImageResource(R.g.bfB);
                break;
            default:
                bVar.mDO.setVisibility(8);
                break;
        }
        if (i == 0) {
            if (getCount() == 1) {
                if (yb(aVar.fSf)) {
                    view.setBackgroundResource(R.g.bht);
                } else {
                    view.setBackgroundResource(R.g.bhs);
                }
            } else if (yb(aVar.fSf)) {
                view.setBackgroundResource(R.g.bhz);
            } else {
                view.setBackgroundResource(R.g.bhy);
            }
        } else if (i != getCount() - 1) {
            view.setBackgroundColor(Color.parseColor("#00000000"));
            if (yb(aVar.fSf)) {
                view.setBackgroundResource(R.g.bhx);
            } else {
                view.setBackgroundResource(R.g.bhw);
            }
        } else if (yb(aVar.fSf)) {
            if (this.mDH) {
                view.setBackgroundResource(R.g.bhv);
            } else {
                view.setBackgroundResource(R.g.bhx);
            }
        } else if (this.mDH) {
            view.setBackgroundResource(R.g.bhu);
        } else {
            view.setBackgroundResource(R.g.bhw);
        }
        return view;
    }

    private boolean yb(String str) {
        if (bg.mA(str) || bg.mA(this.mDD)) {
            return false;
        }
        boolean equals = this.mDD.equals(str);
        this.mDG = equals;
        return equals;
    }
}
