package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.plugin.comm.a.g;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class f extends BaseAdapter {
    public static int sMG = 44;
    public static int sMH = 5;
    boolean fOg;
    private List<String> fPq = new ArrayList();
    private List<x> jKk = new ArrayList();
    q ktr;
    boolean kvm;
    c kwq = null;
    private Context mContext;
    a sMI;
    private ArrayList<x> sMJ = new ArrayList();
    boolean sMK = false;
    public boolean sML = false;
    public boolean sMM = false;
    private List<Object> sMN = new ArrayList();
    private Set<String> sMO = new HashSet();
    int sMP = 0;
    int sMQ = 0;
    d sMR;
    public boolean sMS = false;
    public boolean sMT = false;
    public boolean sMU = false;
    private boolean sMV = true;
    boolean sMW = false;
    int sMX = 12;
    String sMY;
    private final int sMZ;
    public boolean sNa = false;
    private boolean sNb = true;
    private boolean sNc = false;
    boolean sNd = true;
    public boolean sNe = false;
    String username;

    public interface a {
        void bCb();
    }

    class b {
        public ImageView ipv;
        public TextView jWd;
        public ImageView jWg;
        public int knu;
        public TextView kws;
        public ImageView pmp;
        public ImageView sNf;
        final /* synthetic */ f sNg;

        b(f fVar) {
            this.sNg = fVar;
        }
    }

    public f(Context context) {
        this.mContext = context;
        this.kvm = false;
        this.sMZ = context.getResources().getDimensionPixelSize(com.tencent.mm.plugin.comm.a.b.aWA);
    }

    public final boolean bEX() {
        if (this.sMK) {
            return this.sMM;
        }
        return o.dH(this.username);
    }

    public final void bw(List<String> list) {
        this.sMV = true;
        this.fPq = list;
    }

    public final void ad(ArrayList<x> arrayList) {
        this.sMV = false;
        this.sMJ = arrayList;
    }

    private void bEY() {
        if (this.sMJ != null) {
            w.d("MicroMsg.ContactsListArchAdapter", "initData memberContactList.size %d", Integer.valueOf(this.sMJ.size()));
            this.sMO.clear();
            this.jKk.clear();
            if (this.sMJ.size() > 0) {
                Iterator it = this.sMJ.iterator();
                while (it.hasNext()) {
                    x xVar = (x) it.next();
                    this.jKk.add(xVar);
                    this.sMO.add(xVar.field_username);
                }
            }
            this.sMQ = this.jKk.size();
        }
    }

    public final boolean xs(int i) {
        if (this.kvm) {
            return false;
        }
        if (i >= this.sMQ) {
            return true;
        }
        this.kvm = true;
        bCb();
        return true;
    }

    private void bCb() {
        if (this.sMI != null) {
            this.sMI.bCb();
        }
    }

    private b cS(View view) {
        b bVar = new b(this);
        bVar.sNf = (ImageView) view.findViewById(com.tencent.mm.plugin.comm.a.d.czd);
        bVar.ipv = (ImageView) view.findViewById(com.tencent.mm.plugin.comm.a.d.czm);
        bVar.pmp = (ImageView) view.findViewById(com.tencent.mm.plugin.comm.a.d.kDD);
        bVar.jWd = (TextView) view.findViewById(com.tencent.mm.plugin.comm.a.d.kDF);
        bVar.kws = (TextView) view.findViewById(com.tencent.mm.plugin.comm.a.d.czl);
        bVar.jWg = (ImageView) view.findViewById(com.tencent.mm.plugin.comm.a.d.kDE);
        bVar.ipv.setScaleType(ScaleType.CENTER_CROP);
        view.setTag(bVar);
        return bVar;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        Object item;
        af afVar;
        int i2;
        b cS;
        int dimensionPixelSize;
        if (i < this.sMQ) {
            if (this.sMK) {
                item = getItem(i);
                afVar = null;
                i2 = 0;
            } else {
                item = null;
                afVar = (x) getItem(i);
                i2 = 0;
            }
        } else if (i == this.sMQ && this.sMT) {
            item = null;
            afVar = null;
            i2 = 3;
        } else if (i == this.sMQ + 1 && this.sMS) {
            item = null;
            afVar = null;
            i2 = 4;
        } else if (i == this.sMQ + 1 && this.sMU && !this.sMS) {
            item = null;
            afVar = null;
            i2 = 5;
        } else if (i == this.sMQ + 2 && this.sMU && this.sMS) {
            item = null;
            afVar = null;
            i2 = 5;
        } else {
            item = null;
            afVar = null;
            i2 = 2;
        }
        if (view == null) {
            view = View.inflate(this.mContext, e.dmK, null);
            cS = cS(view);
        } else {
            b bVar = (b) view.getTag();
            if (bVar == null) {
                cS = cS(view);
            } else {
                cS = bVar;
            }
        }
        if (sMH == 4 || this.sNe) {
            dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.plugin.comm.a.b.aXD);
            cS.ipv.getLayoutParams().height = dimensionPixelSize;
            cS.ipv.getLayoutParams().width = dimensionPixelSize;
        } else {
            dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.tencent.mm.plugin.comm.a.b.aXB);
            cS.ipv.getLayoutParams().height = dimensionPixelSize;
            cS.ipv.getLayoutParams().width = dimensionPixelSize;
        }
        cS.sNf.setVisibility(8);
        if (i2 == 0) {
            CharSequence eK;
            cS.ipv.setVisibility(0);
            if (this.fOg) {
                if (bg.mA(afVar.field_conRemark)) {
                    String str = afVar.field_username;
                    if (this.ktr == null) {
                        Object obj = null;
                    } else {
                        eK = this.ktr.eK(str);
                    }
                } else {
                    eK = afVar.field_conRemark;
                }
                if (bg.mA(eK)) {
                    eK = afVar.field_conRemark;
                }
                if (bg.mA(eK)) {
                    eK = afVar.tK();
                }
                eK = h.b(this.mContext, eK, cS.jWd.getTextSize());
            } else if (this.sMK) {
                eK = h.b(this.mContext, com.tencent.mm.pluginsdk.ui.applet.j.a.sNr.bp(item), cS.jWd.getTextSize());
            } else {
                eK = h.b(this.mContext, afVar.tL(), cS.jWd.getTextSize());
            }
            if (eK instanceof SpannableString) {
                cS.jWd.setVisibility(8);
                cS.kws.setVisibility(0);
                cS.kws.setText(eK);
            } else {
                cS.jWd.setVisibility(0);
                cS.kws.setVisibility(8);
                cS.jWd.setText(eK);
            }
            cS.ipv.setContentDescription("");
            if (this.sMK) {
                n.GW().a(com.tencent.mm.pluginsdk.ui.applet.j.a.sNr.bq(item), cS.ipv, this.kwq);
                cS.ipv.setBackgroundDrawable(null);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.a(cS.ipv, afVar.field_username);
                com.tencent.mm.pluginsdk.ui.a aVar = (com.tencent.mm.pluginsdk.ui.a) cS.ipv.getDrawable();
                if (this.sMR != null) {
                    this.sMR.a(aVar);
                }
            }
            if (this.sMK) {
                if (!this.kvm || (this.sMY != null && this.sMY.equals(com.tencent.mm.pluginsdk.ui.applet.j.a.sNr.br(item)))) {
                    cS.pmp.setVisibility(8);
                } else {
                    cS.pmp.setVisibility(0);
                }
            } else if (!this.kvm || (this.sMY != null && this.sMY.equals(afVar.field_username))) {
                cS.pmp.setVisibility(8);
            } else {
                cS.pmp.setVisibility(0);
            }
        } else if (i2 == 3) {
            cS.jWd.setVisibility(i == 0 ? 8 : 4);
            r6 = cS.kws;
            if (i == 0) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            r6.setVisibility(dimensionPixelSize);
            cS.pmp.setVisibility(8);
            if (this.kvm) {
                cS.ipv.setVisibility(4);
            } else {
                cS.ipv.setVisibility(0);
                if (this.sMK) {
                    n.GW().a("", cS.ipv, this.kwq);
                    cS.ipv.setBackgroundDrawable(null);
                }
                cS.ipv.setImageResource(com.tencent.mm.plugin.comm.a.c.bct);
                cS.ipv.setContentDescription(this.mContext.getString(g.kEb));
            }
        } else if (i2 == 4) {
            cS.jWd.setVisibility(1 == i ? 8 : 4);
            r6 = cS.kws;
            if (1 == i) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            r6.setVisibility(dimensionPixelSize);
            cS.pmp.setVisibility(8);
            if (this.kvm || this.sMQ == 0) {
                cS.ipv.setVisibility(4);
            } else {
                cS.ipv.setVisibility(0);
                if (this.sMK) {
                    n.GW().a("", cS.ipv, this.kwq);
                    cS.ipv.setBackgroundDrawable(null);
                }
                cS.ipv.setImageResource(com.tencent.mm.plugin.comm.a.c.bcu);
                cS.ipv.setContentDescription(this.mContext.getString(g.kEg));
            }
        } else if (i2 == 5) {
            r6 = cS.jWd;
            if (i == 0) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            r6.setVisibility(dimensionPixelSize);
            r6 = cS.kws;
            if (i == 0) {
                dimensionPixelSize = 8;
            } else {
                dimensionPixelSize = 4;
            }
            r6.setVisibility(dimensionPixelSize);
            cS.pmp.setVisibility(8);
            if (this.kvm) {
                cS.ipv.setVisibility(4);
            } else {
                cS.ipv.setVisibility(0);
                if (this.sMK) {
                    n.GW().a("", cS.ipv, this.kwq);
                    cS.ipv.setBackgroundDrawable(null);
                }
                cS.ipv.setImageResource(com.tencent.mm.plugin.comm.a.c.kDA);
                cS.ipv.setContentDescription(this.mContext.getString(g.kEQ));
            }
        } else if (i2 == 2) {
            if (this.sMK) {
                n.GW().a("", cS.ipv, this.kwq);
            }
            cS.jWd.setVisibility(4);
            cS.kws.setVisibility(4);
            cS.pmp.setVisibility(8);
            cS.ipv.setVisibility(4);
            cS.ipv.setImageResource(com.tencent.mm.plugin.comm.a.c.bhc);
            cS.ipv.setBackgroundResource(com.tencent.mm.plugin.comm.a.c.bhc);
        }
        if (!this.sMK || item == null) {
            cS.jWg.setVisibility(8);
        }
        cS.knu = i2;
        return view;
    }

    public final boolean xt(int i) {
        return i < this.sMQ;
    }

    public final void notifyChanged() {
        if (this.fPq != null || this.sMJ != null) {
            if (!this.sMV) {
                bEY();
            } else if (this.fPq != null) {
                w.d("MicroMsg.ContactsListArchAdapter", "initData memberList.size %d", Integer.valueOf(this.fPq.size()));
                this.sMO.clear();
                this.jKk.clear();
                this.sMN.clear();
                if (this.fPq.size() > 0) {
                    String str;
                    x xVar;
                    for (String str2 : this.fPq) {
                        if (this.sMK) {
                            this.sMN.add(com.tencent.mm.pluginsdk.ui.applet.j.a.sNr.MN(str2));
                        } else {
                            af Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(str2);
                            if (Rc == null || bg.mA(Rc.field_username) || !Rc.field_username.equals(str2)) {
                                this.jKk.add(new x(this.username));
                            } else {
                                this.jKk.add(Rc);
                            }
                        }
                        this.sMO.add(str2);
                    }
                    if (this.sNb && !bg.mA(this.sMY) && this.fPq.contains(this.sMY)) {
                        if (!this.sMK) {
                            for (x xVar2 : this.jKk) {
                                if (this.sMY.equals(xVar2.field_username)) {
                                    this.jKk.remove(xVar2);
                                    this.jKk.add(0, xVar2);
                                    break;
                                }
                            }
                        }
                        for (Object next : this.sMN) {
                            if (this.sMY.equals(com.tencent.mm.pluginsdk.ui.applet.j.a.sNr.br(next))) {
                                this.sMN.remove(next);
                                this.sMN.add(0, next);
                                break;
                            }
                        }
                    }
                    if (this.sNc && !this.sMK) {
                        String ap = bg.ap((String) com.tencent.mm.kernel.h.vI().vr().get(2, null), "");
                        if (this.fPq.contains(ap)) {
                            this.sMO.remove(ap);
                            for (x xVar22 : this.jKk) {
                                if (ap.equals(xVar22.field_username)) {
                                    this.jKk.remove(xVar22);
                                    break;
                                }
                            }
                        }
                        af Rc2 = ((com.tencent.mm.plugin.messenger.foundation.a.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(ap);
                        if (Rc2 == null || bg.mA(Rc2.field_username) || !Rc2.field_username.equals(ap)) {
                            this.jKk.add(1, new x(ap));
                        } else {
                            this.jKk.add(1, Rc2);
                        }
                        this.sMO.add(ap);
                        if (this.sNd && this.jKk.size() >= 3) {
                            int size = this.jKk.size();
                            LinkedList linkedList = new LinkedList();
                            for (int i = 0; i < size; i++) {
                                xVar22 = (x) this.jKk.get(i);
                                if (xVar22.field_showHead > 0) {
                                    linkedList.add(xVar22.field_showHead);
                                } else if (!bg.mA(xVar22.field_conRemark)) {
                                    linkedList.add(xVar22.field_conRemark);
                                } else if (!bg.mA(xVar22.field_conRemarkPYShort)) {
                                    linkedList.add(xVar22.field_conRemarkPYShort);
                                } else if (!bg.mA(xVar22.field_conRemarkPYFull)) {
                                    linkedList.add(xVar22.field_conRemarkPYFull);
                                } else if (!bg.mA(xVar22.pB())) {
                                    linkedList.add(xVar22.pB());
                                } else if (!bg.mA(xVar22.field_username)) {
                                    linkedList.add(xVar22.field_username);
                                }
                            }
                            w.v("MicroMsg.ContactsListArchAdapter", "klem, order list:%s", linkedList.toString());
                            List arrayList = new ArrayList();
                            arrayList.add(this.jKk.get(0));
                            arrayList.add(this.jKk.get(1));
                            List linkedList2 = new LinkedList();
                            linkedList2.add(linkedList.get(0));
                            linkedList2.add(linkedList.get(0));
                            int size2 = this.jKk.size();
                            for (int i2 = 2; i2 < size2; i2++) {
                                str2 = (String) linkedList.get(i2);
                                int size3 = arrayList.size();
                                int i3 = 1;
                                while (i3 < size3 && str2.compareToIgnoreCase((String) linkedList2.get(i3)) >= 0) {
                                    i3++;
                                }
                                linkedList2.add(i3, str2);
                                arrayList.add(i3, this.jKk.get(i2));
                            }
                            this.jKk.clear();
                            this.jKk = arrayList;
                        }
                    }
                }
                if (this.sMK) {
                    this.sMQ = this.sMN.size();
                } else if (!this.fOg) {
                    this.sMQ = this.jKk.size();
                } else if (bg.mA(this.sMY) || !(this.sMY == null || this.sMY.equals(m.xL()))) {
                    this.sMQ = this.jKk.size() >= sMG ? sMG : this.jKk.size();
                } else {
                    this.sMQ = this.jKk.size() >= sMG + -1 ? sMG - 1 : this.jKk.size();
                }
            }
            if (this.sMQ == 0) {
                this.sMP = sMH;
            } else if (this.sMT && this.sMS && this.sMU) {
                this.sMP = (((this.sMQ + 2) / sMH) + 1) * sMH;
            } else if ((this.sMT && this.sMS && !this.sMU) || ((this.sMT && !this.sMS && this.sMU) || (!this.sMT && this.sMS && this.sMU))) {
                this.sMP = (((this.sMQ + 1) / sMH) + 1) * sMH;
            } else if ((this.sMT && !this.sMS && !this.sMU) || ((!this.sMT && this.sMS && !this.sMU) || (!this.sMT && !this.sMS && this.sMU))) {
                this.sMP = ((this.sMQ / sMH) + 1) * sMH;
            } else if (!(this.sMT || this.sMS || this.sMU)) {
                this.sMP = (((this.sMQ - 1) / sMH) + 1) * sMH;
            }
            w.d("MicroMsg.ContactsListArchAdapter", "Number Size  contactSize :" + this.sMQ + " realySize : " + this.sMP);
            bCb();
        }
    }

    public final int getCount() {
        if (this.sMW) {
            return Math.min(this.sMX, this.sMP);
        }
        return this.sMP;
    }

    public final Object getItem(int i) {
        if (i >= this.sMQ) {
            return null;
        }
        if (this.sMK) {
            return this.sMN.get(i);
        }
        return this.jKk.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }
}
