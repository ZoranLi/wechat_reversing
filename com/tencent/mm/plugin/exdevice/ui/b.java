package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b extends BaseAdapter {
    private String jia = m.xL();
    List<e> lmE;
    Map<String, String> lmF;
    String lmG;
    d lmH;
    private String lmI;
    private boolean lmJ = false;
    private a lmK = new a();
    private OnClickListener lmL = new OnClickListener(this) {
        final /* synthetic */ b lmP;

        {
            this.lmP = r1;
        }

        public final void onClick(View view) {
            w.i("MicroMsg.ExdeviceRankAdapter", "hy: user clicked on the content");
            this.lmP.lmH.vv(this.lmP.mb(((Integer) view.getTag()).intValue()).lpF.field_username);
        }
    };
    private OnClickListener lmM = new OnClickListener(this) {
        final /* synthetic */ b lmP;

        {
            this.lmP = r1;
        }

        public final void onClick(View view) {
            this.lmP.lmH.vv(this.lmP.jia);
        }
    };
    private OnClickListener lmN = new OnClickListener(this) {
        final /* synthetic */ b lmP;

        {
            this.lmP = r1;
        }

        public final void onClick(View view) {
            this.lmP.lmH.aqy();
        }
    };
    private Context mContext;

    static final class a {
        public View ipY;

        a() {
        }
    }

    static final class b {
        public TextView ldV;
        public View lmQ;
        public View lmR;
        public ImageView lmS;
        public NoMeasuredTextView lmT;
        public TextView lmU;
        public TextView lmV;
        public ExdeviceLikeView lmW;
        public View lmX;
        public View lmY;
        public View lmZ;
        public TextView lna;

        b() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return mb(i);
    }

    public b(Context context, String str) {
        this.mContext = context;
        this.lmI = str;
    }

    private static void c(LinkedList<c> linkedList, String str) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            if (((c) it.next()).field_username.equalsIgnoreCase(str)) {
                w.d("MicroMsg.ExdeviceRankAdapter", "username: %s remove", new Object[]{((c) it.next()).toString()});
                it.remove();
            }
        }
    }

    private static boolean d(LinkedList<c> linkedList, String str) {
        try {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                if (((c) it.next()).field_username.equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            w.d("MicroMsg.ExdeviceRankAdapter", e.toString());
            return false;
        }
    }

    private List<e> a(ArrayList<c> arrayList, ArrayList<d> arrayList2, boolean z) {
        a aVar;
        LinkedList linkedList = new LinkedList(arrayList);
        List arrayList3 = new ArrayList();
        d d = d(this.jia, (ArrayList) arrayList2);
        if (d != null) {
            a aVar2 = this.lmK;
            aVar2.lpF = d;
            aVar2.lpG = 3;
        } else {
            aVar = this.lmK;
            aVar.lpF = null;
            aVar.lmI = this.lmI;
            aVar.username = this.jia;
            aVar.lpG = 7;
        }
        if (z) {
            this.lmK.afo = 2;
        } else {
            this.lmK.afo = 1;
        }
        arrayList3.add(this.lmK.aqG());
        aVar = this.lmK;
        aVar.afo = 0;
        arrayList3.add(aVar.aqG());
        c(linkedList, this.jia);
        Collection arrayList4 = new ArrayList();
        w.d("MicroMsg.ExdeviceRankAdapter", "ap: follow size %s, %s", new Object[]{Integer.valueOf(linkedList.size()), linkedList.toString()});
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            d = (d) it.next();
            a aVar3 = this.lmK;
            aVar3.lpF = d;
            aVar3.afo = 1;
            aVar3.lpG = 4;
            arrayList4.add(aVar3.aqG());
            if (linkedList.size() > 0 && d(linkedList, d.field_username)) {
                aVar3 = this.lmK;
                aVar3.lpF = d;
                aVar3.afo = 1;
                aVar3.lpG = 2;
                arrayList3.add(aVar3.aqG());
                c(linkedList, d.field_username);
            }
        }
        if (linkedList.size() > 0) {
            Iterator it2 = linkedList.iterator();
            while (it2.hasNext()) {
                c cVar = (c) it2.next();
                a aVar4 = this.lmK;
                aVar4.username = cVar.field_username;
                aVar4.lmI = this.lmI;
                aVar4.lpF = null;
                aVar4.afo = 1;
                aVar4.lpG = 6;
                arrayList3.add(aVar4.aqG());
            }
        }
        if (arrayList3.size() > 2) {
            ((e) arrayList3.get(arrayList3.size() - 1)).lpG = (((e) arrayList3.get(arrayList3.size() - 1)).lpG | 2) | 1;
            aVar = this.lmK;
            aVar.afo = 0;
            aVar.lpF = null;
            arrayList3.add(aVar.aqG());
        }
        if (arrayList4.size() > 1) {
            ((e) arrayList4.get(arrayList4.size() - 1)).lpG = 5;
        }
        arrayList3.addAll(arrayList4);
        w.d("MicroMsg.ExdeviceRankAdapter", "rank: %d %s", new Object[]{Integer.valueOf(arrayList2.size()), arrayList2.toString()});
        w.d("MicroMsg.ExdeviceRankAdapter", "all: %s %s", new Object[]{Integer.valueOf(arrayList3.size()), arrayList3.toString()});
        return arrayList3;
    }

    public final List<e> b(ArrayList<c> arrayList, ArrayList<d> arrayList2, boolean z) {
        if (arrayList == null) {
            try {
                arrayList = new ArrayList();
            } catch (Exception e) {
                w.w("MicroMsg.ExdeviceRankAdapter", "ap: rank exception,null info");
                return new ArrayList();
            }
        }
        if (arrayList2 == null) {
            arrayList2 = new ArrayList();
        }
        return a(arrayList, arrayList2, z);
    }

    public static d d(String str, ArrayList<d> arrayList) {
        if (arrayList == null) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equalsIgnoreCase(dVar.field_username)) {
                return dVar;
            }
        }
        return null;
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final boolean isEnabled(int i) {
        return false;
    }

    public final int getCount() {
        return this.lmE == null ? 0 : this.lmE.size();
    }

    public final e mb(int i) {
        return (e) this.lmE.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        return mb(i).afo;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        final d dVar = mb(i).lpF;
        e mb = mb(i);
        int itemViewType = getItemViewType(i);
        int i2 = mb.lpG;
        if (view != null) {
            switch (itemViewType) {
                case 1:
                case 2:
                    bVar = (b) view.getTag();
                    break;
                default:
                    bVar = null;
                    break;
            }
        }
        LayoutInflater from = LayoutInflater.from(this.mContext);
        switch (itemViewType) {
            case 0:
                view = from.inflate(R.i.dbW, viewGroup, false);
                a aVar = new a();
                aVar.ipY = view.findViewById(R.h.bJE);
                view.setTag(aVar);
                bVar = null;
                break;
            case 1:
                view = from.inflate(R.i.dbV, viewGroup, false);
                bVar = new b();
                bVar.lmU = (TextView) view.findViewById(R.h.bNj);
                break;
            case 2:
                view = from.inflate(R.i.dbX, viewGroup, false);
                bVar = new b();
                break;
            default:
                bVar = null;
                break;
        }
        if (bVar != null) {
            bVar.lmQ = view.findViewById(R.h.bGr);
            bVar.lmR = view.findViewById(R.h.bZf);
            bVar.ldV = (TextView) view.findViewById(R.h.bNe);
            bVar.lmS = (ImageView) view.findViewById(R.h.bNh);
            bVar.lmT = (NoMeasuredTextView) view.findViewById(R.h.bNi);
            bVar.lmV = (TextView) view.findViewById(R.h.bMz);
            bVar.lmW = (ExdeviceLikeView) view.findViewById(R.h.bML);
            bVar.lmX = view.findViewById(R.h.bJE);
            bVar.lmZ = view.findViewById(R.h.bNk);
            bVar.lmY = view.findViewById(R.h.bME);
            bVar.lna = (TextView) view.findViewById(R.h.cEL);
            if (bVar.lmT != null) {
                bVar.lmT.H(this.mContext.getResources().getDimension(R.f.aXe));
                bVar.lmT.setTextColor(this.mContext.getResources().getColor(R.e.aTN));
                bVar.lmT.bSn();
                bVar.lmT.voV = true;
            }
            view.setTag(bVar);
        }
        if (!(dVar == null || bVar == null)) {
            if (this.jia.equalsIgnoreCase(dVar.field_username)) {
                this.lmJ = true;
            } else {
                this.lmJ = false;
            }
            if (itemViewType == 2) {
                bVar.ldV.setText(String.valueOf(dVar.field_ranknum));
                bVar.lmV.setText(String.valueOf(dVar.field_score));
                com.tencent.mm.pluginsdk.ui.a.b.m(bVar.lmS, dVar.field_username);
                bVar.lmQ.setOnClickListener(this.lmM);
                bVar.lna.setOnClickListener(this.lmN);
            } else {
                ExdeviceLikeView exdeviceLikeView;
                CharSequence charSequence;
                if (bVar.lmU != null) {
                    if ((i2 & 4) != 4) {
                        bVar.lmU.setVisibility(0);
                        bVar.lmU.setText(this.mContext.getResources().getString(R.l.egA, new Object[]{Integer.valueOf(dVar.field_ranknum)}));
                    } else {
                        bVar.lmU.setVisibility(8);
                    }
                }
                if ((i2 & 2) == 2 || !dVar.field_username.equalsIgnoreCase(this.lmG) || this.jia.equalsIgnoreCase(this.lmG)) {
                    bVar.lmR.setBackgroundColor(this.mContext.getResources().getColor(R.e.aTJ));
                } else {
                    bVar.lmR.setBackgroundColor(this.mContext.getResources().getColor(R.e.aTK));
                }
                if ((i2 & 1) == 1) {
                    bVar.lmX.setVisibility(8);
                } else {
                    bVar.lmX.setVisibility(0);
                }
                if (dVar.field_ranknum >= 100) {
                    bVar.ldV.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(R.f.aXg));
                } else {
                    bVar.ldV.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(R.f.aXf));
                }
                if ((i2 & 2) == 2) {
                    bVar.ldV.setText("");
                } else {
                    bVar.ldV.setText(dVar.field_ranknum);
                }
                if (dVar.field_score >= 10000) {
                    bVar.lmV.setTextColor(this.mContext.getResources().getColor(R.e.aTM));
                } else {
                    bVar.lmV.setTextColor(this.mContext.getResources().getColor(R.e.aTL));
                }
                bVar.lmV.setText(String.valueOf(dVar.field_score));
                com.tencent.mm.pluginsdk.ui.a.b.m(bVar.lmS, dVar.field_username);
                if (!this.lmJ) {
                    ap.yY();
                    if (!(com.tencent.mm.u.c.wR().QY(dVar.field_username) || this.lmF == null || bg.mA((String) this.lmF.get(dVar.field_username)))) {
                        bVar.lmT.setText(h.b(this.mContext, (CharSequence) this.lmF.get(dVar.field_username), bVar.lmT.gm.getTextSize()));
                        exdeviceLikeView = bVar.lmW;
                        i2 = dVar.field_likecount;
                        exdeviceLikeView.llg = i2;
                        charSequence = exdeviceLikeView.llg;
                        if (exdeviceLikeView.llg < 0) {
                            w.w("MicroMsg.ExdeviceLikeView", "hy: like num is negative. set to 0");
                            charSequence = "0";
                        } else if (i2 > 999) {
                            w.d("MicroMsg.ExdeviceLikeView", "hy: like num exceeded the limit. put plus");
                            charSequence = "999+";
                        }
                        if (exdeviceLikeView.llg > 0) {
                            exdeviceLikeView.llj.setVisibility(8);
                        } else {
                            exdeviceLikeView.llj.setVisibility(0);
                        }
                        exdeviceLikeView.llj.setText(charSequence);
                        if (this.lmJ) {
                            bVar.lmW.lY(dVar.field_selfLikeState);
                        } else if (dVar.field_likecount == 0) {
                            bVar.lmW.lY(1);
                        } else {
                            bVar.lmW.lY(0);
                        }
                        if (dVar.field_score <= 0 || this.lmJ) {
                            bVar.lmW.setClickable(true);
                            bVar.lmW.llh = new com.tencent.mm.plugin.exdevice.ui.ExdeviceLikeView.a(this) {
                                final /* synthetic */ b lmP;

                                public final void hq(int i) {
                                    w.i("MicroMsg.ExdeviceRankAdapter", "hy: like view clicked.after statae: %d", new Object[]{Integer.valueOf(i)});
                                    if (this.lmP.lmH != null) {
                                        this.lmP.lmH.aO(dVar.field_username, i);
                                    }
                                }

                                public final boolean aqj() {
                                    if (this.lmP.lmH != null) {
                                        return this.lmP.lmH.vw(dVar.field_username);
                                    }
                                    return true;
                                }
                            };
                        } else {
                            bVar.lmW.setClickable(false);
                        }
                        bVar.lmY.setTag(Integer.valueOf(i));
                        bVar.lmY.setOnClickListener(this.lmL);
                        bVar.lmZ.setTag(Integer.valueOf(i));
                        bVar.lmZ.setOnClickListener(this.lmL);
                    }
                }
                bVar.lmT.setText(h.b(this.mContext, n.eK(dVar.field_username), bVar.lmT.gm.getTextSize()));
                exdeviceLikeView = bVar.lmW;
                i2 = dVar.field_likecount;
                exdeviceLikeView.llg = i2;
                charSequence = exdeviceLikeView.llg;
                if (exdeviceLikeView.llg < 0) {
                    w.w("MicroMsg.ExdeviceLikeView", "hy: like num is negative. set to 0");
                    charSequence = "0";
                } else if (i2 > 999) {
                    w.d("MicroMsg.ExdeviceLikeView", "hy: like num exceeded the limit. put plus");
                    charSequence = "999+";
                }
                if (exdeviceLikeView.llg > 0) {
                    exdeviceLikeView.llj.setVisibility(0);
                } else {
                    exdeviceLikeView.llj.setVisibility(8);
                }
                exdeviceLikeView.llj.setText(charSequence);
                if (this.lmJ) {
                    bVar.lmW.lY(dVar.field_selfLikeState);
                } else if (dVar.field_likecount == 0) {
                    bVar.lmW.lY(0);
                } else {
                    bVar.lmW.lY(1);
                }
                if (dVar.field_score <= 0) {
                }
                bVar.lmW.setClickable(true);
                bVar.lmW.llh = /* anonymous class already generated */;
                bVar.lmY.setTag(Integer.valueOf(i));
                bVar.lmY.setOnClickListener(this.lmL);
                bVar.lmZ.setTag(Integer.valueOf(i));
                bVar.lmZ.setOnClickListener(this.lmL);
            }
        }
        return view;
    }
}
