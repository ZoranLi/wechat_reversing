package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.database.MergeCursor;
import android.util.SparseArray;
import com.tencent.mm.R;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.a.g;
import com.tencent.mm.ui.contact.a.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class c extends o implements b {
    private Cursor ipM;
    private int oRR;
    private a vVU;
    private int vVV;
    private int vVW;
    private int vVX;
    private int vVY;
    private int vVZ;
    private int vWa;
    private HashMap<String, Integer> vWb;
    private SparseArray<String> vWc;

    public static class a {
        public String vUP = "@all.contact.without.chatroom";
        public boolean vWd = false;
        public boolean vWe = false;
        public boolean vWf = false;
        public boolean vWg = false;
        public boolean vWh = false;
        public boolean vWi = false;
        public String vWj;
        public String vWk;
        public boolean vWl = false;
        public String vWm = "";
        public String vWn = "";
    }

    public c(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, boolean z2, a aVar, boolean z3) {
        super((l) mMBaseSelectContactUI, (List) list, z, z2, z3);
        this.vVV = Integer.MAX_VALUE;
        this.oRR = Integer.MAX_VALUE;
        this.vVW = Integer.MAX_VALUE;
        this.vVX = Integer.MAX_VALUE;
        this.vVY = Integer.MAX_VALUE;
        this.vVZ = Integer.MAX_VALUE;
        this.vWa = Integer.MAX_VALUE;
        this.vWb = null;
        this.vWc = null;
        w.i("MicroMsg.AlphabetContactAdapter", "create!");
        if (aVar != null) {
            this.vVU = aVar;
        } else {
            this.vVU = new a();
        }
        ap.yY();
        com.tencent.mm.u.c.wR().a(this);
        aue();
    }

    public c(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, a aVar) {
        this(mMBaseSelectContactUI, list, true, z, aVar, false);
    }

    private void aue() {
        this.vVV = Integer.MAX_VALUE;
        this.oRR = Integer.MAX_VALUE;
        this.vVW = Integer.MAX_VALUE;
        this.vVX = Integer.MAX_VALUE;
        this.vVY = Integer.MAX_VALUE;
        this.vWa = Integer.MAX_VALUE;
        if (this.vWb != null) {
            this.vWb.clear();
        } else {
            this.vWb = new HashMap();
        }
        if (this.vWc != null) {
            this.vWc.clear();
        } else {
            this.vWc = new SparseArray();
        }
        List arrayList = new ArrayList();
        Cursor h;
        int count;
        Cursor ci;
        int count2;
        List f;
        String[] u;
        int[] t;
        if (this.vVU.vWh) {
            ap.yY();
            h = com.tencent.mm.u.c.wR().h(bg.f(this.vVU.vWk.split(",")), false);
            arrayList.add(h);
            count = h.getCount();
            w.d("MicroMsg.AlphabetContactAdapter", "ap: recent like count %d", Integer.valueOf(count));
            if (count > 0) {
                this.vWa = 0;
                count = (count + 1) + 0;
                aE(this.vWa, "☆");
            } else {
                this.vWa = Integer.MAX_VALUE;
                count = 0;
            }
            ap.yY();
            ci = com.tencent.mm.u.c.wR().ci(bg.f(this.vVU.vWj.split(",")));
            arrayList.add(ci);
            count2 = ci.getCount();
            if (count2 > 0) {
                this.vVW = count;
                count += count2 + 1;
                aE(this.vVW, "☆");
            } else {
                this.vVW = Integer.MAX_VALUE;
            }
            f = bg.f(this.vVU.vWj.split(","));
            ap.yY();
            arrayList.add(com.tencent.mm.u.c.wR().h(f, true));
            u = o.u(f);
            t = o.t(f);
            if (!(u == null || t == null)) {
                count2 = count;
                for (count = 0; count < u.length; count++) {
                    if (count < t.length) {
                        aE(t[count] + count2, u[count]);
                        count2++;
                    }
                }
                h.getCount();
            }
        } else {
            int i;
            ar wR;
            String str;
            String str2;
            List list;
            boolean z;
            Cursor c;
            if (this.vVU.vWi) {
                this.vVZ = 0;
                aE(this.vVZ, "nonLimit");
                count = 1;
            } else {
                count = 0;
            }
            if (this.vVU.vWl && this.vVU.vWm != null) {
                f = bg.f(this.vVU.vWm.split(";"));
                ap.yY();
                ci = com.tencent.mm.u.c.wR().ce(f);
                arrayList.add(ci);
                count2 = ci.getCount();
                if (count2 > 0) {
                    this.vVV = count;
                    count += count2 + 1;
                    aE(this.oRR, "↑");
                } else {
                    this.vVV = Integer.MAX_VALUE;
                }
            } else if (this.vVU.vWd) {
                f = g.cL(this.jBA);
                if (f.size() == 0) {
                    ap.yY();
                    ci = com.tencent.mm.u.c.wR().aKg();
                } else {
                    ap.yY();
                    ci = com.tencent.mm.u.c.wR().ce(f);
                }
                arrayList.add(ci);
                count2 = ci.getCount();
                if (count2 > 0) {
                    this.oRR = count;
                    count += count2 + 1;
                    aE(this.oRR, "↑");
                } else {
                    this.oRR = Integer.MAX_VALUE;
                }
            }
            if (this.vVU.vWe) {
                ap.yY();
                ci = com.tencent.mm.u.c.wR().cj(this.jBA);
                arrayList.add(ci);
                count2 = ci.getCount();
                if (count2 > 0) {
                    this.vVW = count;
                    count += count2 + 1;
                    aE(this.vVW, "☆");
                    i = count;
                    ap.yY();
                    wR = com.tencent.mm.u.c.wR();
                    str = this.vVU.vUP;
                    str2 = "";
                    list = this.jBA;
                    if (this.vYw) {
                        z = true;
                    } else {
                        z = false;
                    }
                    h = wR.a(str, str2, list, false, z);
                    arrayList.add(h);
                    u = o.a(this.vVU.vUP, "", "", this.jBA);
                    t = o.a(this.vVU.vUP, "", this.jBA, "");
                    if (!(u == null || t == null)) {
                        count2 = i;
                        for (count = 0; count < u.length; count++) {
                            if (count < t.length) {
                                aE(t[count] + count2, u[count]);
                                count2++;
                            }
                        }
                        i += h.getCount() + u.length;
                    }
                    if (this.vVU.vWf) {
                        ap.yY();
                        c = com.tencent.mm.u.c.wR().c("@all.chatroom.contact", "", this.jBA);
                        arrayList.add(c);
                        count = c.getCount();
                        if (count <= 0) {
                            this.vVX = i;
                            i += count + 1;
                            aE(this.vVX, this.vYf.getActivity().getString(R.l.dCs));
                        } else {
                            this.vVX = Integer.MAX_VALUE;
                        }
                    }
                    if (this.vVU.vWg) {
                        ap.yY();
                        c = com.tencent.mm.u.c.wR().c("@verify.contact", "", this.jBA);
                        arrayList.add(c);
                        if (c.getCount() <= 0) {
                            this.vVY = i;
                            aE(this.vVY, this.vYf.getActivity().getString(R.l.dCJ));
                        } else {
                            this.vVY = Integer.MAX_VALUE;
                        }
                    }
                } else {
                    this.vVW = Integer.MAX_VALUE;
                }
            }
            i = count;
            ap.yY();
            wR = com.tencent.mm.u.c.wR();
            str = this.vVU.vUP;
            str2 = "";
            list = this.jBA;
            if (this.vYw) {
                z = false;
            } else {
                z = true;
            }
            h = wR.a(str, str2, list, false, z);
            arrayList.add(h);
            u = o.a(this.vVU.vUP, "", "", this.jBA);
            t = o.a(this.vVU.vUP, "", this.jBA, "");
            count2 = i;
            for (count = 0; count < u.length; count++) {
                if (count < t.length) {
                    aE(t[count] + count2, u[count]);
                    count2++;
                }
            }
            i += h.getCount() + u.length;
            if (this.vVU.vWf) {
                ap.yY();
                c = com.tencent.mm.u.c.wR().c("@all.chatroom.contact", "", this.jBA);
                arrayList.add(c);
                count = c.getCount();
                if (count <= 0) {
                    this.vVX = Integer.MAX_VALUE;
                } else {
                    this.vVX = i;
                    i += count + 1;
                    aE(this.vVX, this.vYf.getActivity().getString(R.l.dCs));
                }
            }
            if (this.vVU.vWg) {
                ap.yY();
                c = com.tencent.mm.u.c.wR().c("@verify.contact", "", this.jBA);
                arrayList.add(c);
                if (c.getCount() <= 0) {
                    this.vVY = Integer.MAX_VALUE;
                } else {
                    this.vVY = i;
                    aE(this.vVY, this.vYf.getActivity().getString(R.l.dCJ));
                }
            }
        }
        w.d("MicroMsg.AlphabetContactAdapter", "headerPosMap=%s", this.vWb.toString());
        this.ipM = new MergeCursor((Cursor[]) arrayList.toArray(new Cursor[0]));
        notifyDataSetChanged();
    }

    private void aE(int i, String str) {
        this.vWb.put(str, Integer.valueOf(i));
        this.vWc.put(i, str);
    }

    public final int TM(String str) {
        if (str.equals("↑")) {
            return 0;
        }
        if (this.vWb == null || !this.vWb.containsKey(str)) {
            return -1;
        }
        return ((Integer) this.vWb.get(str)).intValue() + this.vYf.bcW().getHeaderViewsCount();
    }

    public final int getCount() {
        return this.ipM.getCount() + this.vWb.size();
    }

    protected final com.tencent.mm.ui.contact.a.a hg(int i) {
        if (i == this.vWa) {
            return aF(i, this.vYf.getActivity().getString(R.l.dCV));
        }
        if (i == this.vVV) {
            return aF(i, this.vVU.vWn);
        }
        if (i == this.oRR) {
            return aF(i, this.vYf.getActivity().getString(R.l.dCH));
        }
        if (i == this.vVW) {
            return aF(i, this.vYf.getActivity().getString(R.l.dCA));
        }
        if (i == this.vVX) {
            return aF(i, this.vYf.getActivity().getString(R.l.dCs));
        }
        if (i == this.vVY) {
            return aF(i, this.vYf.getActivity().getString(R.l.dCJ));
        }
        if (i == this.vVZ) {
            return new j(i);
        }
        if (this.vWc.indexOfKey(i) >= 0) {
            return aF(i, (String) this.vWc.get(i));
        }
        int i2 = i;
        int i3 = 0;
        while (i3 <= this.vWc.size()) {
            if (this.vWc.indexOfKey(i2) >= 0) {
                i3++;
            }
            i2--;
            if (i2 < 0) {
                break;
            }
        }
        if (this.ipM.moveToPosition(i - i3)) {
            w.d("MicroMsg.AlphabetContactAdapter", "create contact item position=%d | index=%d", Integer.valueOf(i), Integer.valueOf(i - i3));
            x xVar = new x();
            xVar.b(this.ipM);
            com.tencent.mm.ui.contact.a.a dVar = new d(i);
            dVar.jiL = xVar;
            dVar.vYg = bcP();
            dVar.vYh = this.vYh;
            return dVar;
        }
        w.i("MicroMsg.AlphabetContactAdapter", "create contact item error: position=%d | index=%d", Integer.valueOf(i), Integer.valueOf(i - i3));
        return null;
    }

    private static com.tencent.mm.ui.contact.a.a aF(int i, String str) {
        com.tencent.mm.ui.contact.a.a gVar = new g(i);
        gVar.mdo = str;
        return gVar;
    }

    public final void finish() {
        super.finish();
        w.i("MicroMsg.AlphabetContactAdapter", "finish!");
        if (this.ipM != null) {
            this.ipM.close();
            this.ipM = null;
        }
        ap.yY();
        com.tencent.mm.u.c.wR().b(this);
    }

    public final void a(int i, m mVar, Object obj) {
        aue();
        notifyDataSetChanged();
    }

    protected final boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        int i = aVar.position + 1;
        int[] iArr = new int[]{this.vWa, this.vVV, this.oRR, this.vVW, this.vVX, this.vVY};
        for (int i2 = 0; i2 < 6; i2++) {
            if (i == iArr[i2]) {
                return true;
            }
        }
        if (this.vWc.indexOfKey(i) < 0) {
            return false;
        }
        return true;
    }
}
