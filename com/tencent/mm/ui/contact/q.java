package com.tencent.mm.ui.contact;

import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.b.b;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.contact.a.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class q extends m {
    private int count = 0;
    private String fRM;
    private ae handler = new ae(Looper.getMainLooper());
    private a mah;
    private String[] mai;
    private List<i> mce = null;
    private List<i> nxk = null;
    private int vVX = Integer.MAX_VALUE;
    private int vVY = Integer.MAX_VALUE;
    private int vYA = Integer.MAX_VALUE;
    private boolean vYB = true;
    private int vYC = Integer.MAX_VALUE;
    private boolean vYD = true;
    private int vYE = Integer.MAX_VALUE;
    private List<i> vYF = null;
    private List<i> vYG = null;
    private List<Integer> vYH;
    private j vYI = new j(this) {
        final /* synthetic */ q vYK;

        {
            this.vYK = r1;
        }

        public final void a(g gVar) {
            switch (gVar.aMA) {
                case -3:
                case -2:
                case -1:
                    if (gVar.lYe.fRM.equals(this.vYK.fRM)) {
                        q.c(this.vYK);
                        return;
                    }
                    return;
                case 0:
                    if (this.vYK.mah != null && this.vYK.mah.equals(this.vYK.mah)) {
                        this.vYK.bYk();
                        this.vYK.mai = gVar.mai;
                        q.a(this.vYK, gVar.maj);
                        this.vYK.vYF = gVar.maj;
                        d.aD(gVar.maj);
                        this.vYK.f(gVar.lYe.fRM, q.c(this.vYK), true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    protected j vYJ = new j(this) {
        final /* synthetic */ q vYK;

        {
            this.vYK = r1;
        }

        public final void a(g gVar) {
            switch (gVar.aMA) {
                case -3:
                case -2:
                case -1:
                    if (gVar.lYe.fRM.equals(this.vYK.fRM)) {
                        q.c(this.vYK);
                        return;
                    }
                    return;
                case 0:
                    if (this.vYK.mah != null && this.vYK.mah.equals(this.vYK.mah)) {
                        this.vYK.mai = gVar.mai;
                        q.a(this.vYK, gVar.maj);
                        if (gVar.maj.size() > 0) {
                            switch (((i) gVar.maj.get(0)).type) {
                                case WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT /*131072*/:
                                    this.vYK.nxk = gVar.maj;
                                    break;
                                case 131075:
                                    this.vYK.mce = gVar.maj;
                                    break;
                                case 131076:
                                    this.vYK.vYG = gVar.maj;
                                    break;
                                default:
                                    w.i("MicroMsg.MMSearchContactAdapter", "not support search");
                                    break;
                            }
                        }
                        this.vYK.f(gVar.lYe.fRM, q.c(this.vYK), true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private List<String> vYx;
    private int vYy = Integer.MAX_VALUE;
    private int vYz = Integer.MAX_VALUE;

    static /* synthetic */ void a(q qVar, List list) {
        if (qVar.vYx != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                i iVar = (i) list.get(size);
                if (!qVar.vYx.contains(iVar.lZO)) {
                    int i = iVar.type;
                    Object obj = (i == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || i == 131075 || i == 131076) ? 1 : null;
                    if (obj != null) {
                    }
                }
                list.remove(size);
            }
        }
    }

    static /* synthetic */ boolean c(q qVar) {
        if (qVar.vYH.size() <= 0) {
            return true;
        }
        HashSet hashSet = new HashSet();
        if (qVar.vYF != null) {
            for (i iVar : qVar.vYF) {
                hashSet.add(iVar.lZO);
            }
        }
        int intValue = ((Integer) qVar.vYH.remove(0)).intValue();
        f fVar = new f();
        fVar.fRM = qVar.fRM;
        fVar.maa = new int[]{intValue};
        fVar.mae = hashSet;
        fVar.mag = qVar.vYJ;
        fVar.handler = qVar.handler;
        if (intValue == 131075) {
            fVar.lZZ = 32;
            fVar.maf = com.tencent.mm.plugin.fts.a.b.a.maB;
        } else {
            fVar.lZZ = 16;
            fVar.maf = b.maC;
        }
        qVar.mah = ((l) h.j(l.class)).search(2, fVar);
        return false;
    }

    public q(MMBaseSelectContactUI mMBaseSelectContactUI, List<String> list, boolean z, int i) {
        super(mMBaseSelectContactUI, z, i);
        this.vYx = list;
        this.vYH = new ArrayList();
        w.i("MicroMsg.MMSearchContactAdapter", "Create!");
        Oe();
    }

    public void aZ(String str, boolean z) {
        if (this.vYe != null) {
            this.vYe.r(str, getCount(), z);
        }
    }

    public void a(String str, int[] iArr, boolean z) {
        clearTask();
        this.fRM = str;
        this.vYH.clear();
        for (int valueOf : iArr) {
            this.vYH.add(Integer.valueOf(valueOf));
        }
        HashSet hashSet = new HashSet();
        if (!z) {
            hashSet.add("filehelper");
        }
        w.i("MicroMsg.MMSearchContactAdapter", "doSearch: query=%s", this.fRM);
        f fVar = new f();
        fVar.fRM = str;
        fVar.maa = iArr;
        fVar.mad = 3;
        fVar.mag = this.vYI;
        fVar.handler = this.handler;
        fVar.scene = 1;
        fVar.mae = hashSet;
        this.mah = ((l) h.j(l.class)).search(1, fVar);
    }

    private void clearTask() {
        if (this.mah != null) {
            ((l) h.j(l.class)).cancelSearchTask(this.mah);
            this.mah = null;
        }
    }

    private void bYk() {
        this.vYz = Integer.MAX_VALUE;
        this.vYA = Integer.MAX_VALUE;
        this.vYB = true;
        this.vYC = Integer.MAX_VALUE;
        this.vVX = Integer.MAX_VALUE;
        this.vYD = true;
        this.vYE = Integer.MAX_VALUE;
        this.vVY = Integer.MAX_VALUE;
        this.vYF = null;
        this.nxk = null;
        this.mce = null;
        this.vYG = null;
        this.mai = null;
        clearCache();
        notifyDataSetChanged();
    }

    private void Oe() {
        w.i("MicroMsg.MMSearchContactAdapter", "initData!");
        this.fRM = null;
        bYk();
        clearTask();
        clearCache();
    }

    public final void QZ() {
        Oe();
    }

    private void f(String str, boolean z, boolean z2) {
        int cM = cM(this.vYF);
        int cM2 = cM(this.nxk);
        int cM3 = cM(this.mce);
        int cM4 = cM(this.vYG);
        if (cM > 0) {
            this.vYz = 0;
            cM = (cM + 1) + 0;
        } else {
            this.vYz = Integer.MAX_VALUE;
            cM = 0;
        }
        if (cM2 > 0) {
            this.vYA = cM;
            if (cM2 <= 3 || (cM3 <= 0 && cM4 <= 0)) {
                this.vYC = Integer.MAX_VALUE;
                cM += cM2 + 1;
            } else if (this.vYB) {
                cM += 4;
                this.vYC = cM;
                cM++;
            } else {
                cM += cM2 + 1;
                this.vYC = cM;
                cM++;
            }
        } else {
            this.vYA = Integer.MAX_VALUE;
        }
        if (this.mai.length <= 1 || bcP()) {
            this.vYy = Integer.MAX_VALUE;
        } else {
            this.vYy = cM;
            cM++;
        }
        if (cM3 > 0) {
            this.vVX = cM;
            if (cM3 <= 3 || cM4 <= 0) {
                this.vYE = Integer.MAX_VALUE;
                cM += cM3 + 1;
            } else if (this.vYD) {
                cM += 4;
                this.vYE = cM;
                cM++;
            } else {
                cM += cM3 + 1;
                this.vYE = cM;
                cM++;
            }
        } else {
            this.vVX = Integer.MAX_VALUE;
        }
        if (cM4 > 0) {
            this.vVY = cM;
            cM += cM4 + 1;
        } else {
            this.vVY = Integer.MAX_VALUE;
        }
        w.i("MicroMsg.MMSearchContactAdapter", "setCount %d", Integer.valueOf(cM));
        this.count = cM;
        if (z2) {
            aZ(str, z);
        }
        clearCache();
        notifyDataSetChanged();
    }

    public int getCount() {
        return this.count;
    }

    private static int cM(List<? extends Object> list) {
        return list == null ? 0 : list.size();
    }

    public com.tencent.mm.ui.contact.a.a hg(int i) {
        com.tencent.mm.ui.contact.a.a fVar;
        if (i == this.vYy) {
            fVar = new com.tencent.mm.ui.contact.a.f(i);
            fVar.mai = this.mai;
            fVar.wal = true;
        } else if (i == this.vYz) {
            fVar = ed(R.l.enm, i);
        } else if (i == this.vYA) {
            fVar = ed(R.l.enf, i);
        } else if (i == this.vVX) {
            fVar = ed(R.l.ene, i);
        } else if (i == this.vVY) {
            fVar = ed(R.l.enc, i);
        } else if (i == this.vYC) {
            fVar = u(R.l.enf, i, this.vYB);
        } else if (i == this.vYE) {
            fVar = u(R.l.ene, i, this.vYD);
        } else if (i > this.vVY) {
            r2 = (i - this.vVY) - 1;
            r1 = new com.tencent.mm.ui.contact.a.d(i);
            r1.iJC = (i) this.vYG.get(r2);
            r1.mai = this.mai;
            r1.vYg = bcP();
            r1.wal = true;
            r1.mdf = r2 + 1;
            r1.cc(r1.iJC.type, r1.iJC.hPr);
            fVar = r1;
        } else if (i > this.vVX) {
            r2 = (i - this.vVX) - 1;
            r1 = new c(i);
            r1.iJC = (i) this.mce.get(r2);
            r1.mai = this.mai;
            r1.vYg = bcP();
            r1.wal = true;
            r1.mdf = r2 + 1;
            r1.cc(r1.iJC.type, r1.iJC.hPr);
            fVar = r1;
        } else if (i > this.vYA) {
            r2 = (i - this.vYA) - 1;
            r1 = new com.tencent.mm.ui.contact.a.d(i);
            r1.iJC = (i) this.nxk.get(r2);
            r1.mai = this.mai;
            r1.vYg = bcP();
            r1.wal = true;
            r1.mdf = r2 + 1;
            r1.cc(r1.iJC.type, r1.iJC.hPr);
            fVar = r1;
        } else if (i > this.vYz) {
            r2 = (i - this.vYz) - 1;
            i iVar = (i) this.vYF.get(r2);
            if (iVar.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || iVar.type == 131076) {
                r1 = new com.tencent.mm.ui.contact.a.d(i);
                r1.iJC = iVar;
                r1.mai = this.mai;
                r1.vYg = bcP();
                r1.wak = true;
                r1.wal = true;
                r1.mdf = r2 + 1;
                r1.cc(r1.iJC.type, r1.iJC.hPr);
                fVar = r1;
            } else if (iVar.type == 131075) {
                r1 = new c(i);
                r1.iJC = iVar;
                r1.mai = this.mai;
                r1.vYg = bcP();
                r1.wak = true;
                r1.wal = true;
                r1.mdf = r2 + 1;
                r1.cc(r1.iJC.type, r1.iJC.hPr);
                fVar = r1;
            } else {
                w.e("MicroMsg.MMSearchContactAdapter", "createTopHitsDataItem return unkown type %d", Integer.valueOf(iVar.type));
                fVar = null;
            }
        } else {
            w.e("MicroMsg.MMSearchContactAdapter", "unkown position=%d", Integer.valueOf(i));
            fVar = null;
        }
        if (fVar != null) {
            fVar.fRM = this.fRM;
            fVar.scene = this.scene;
        }
        return fVar;
    }

    private static com.tencent.mm.ui.contact.a.a u(int i, int i2, boolean z) {
        com.tencent.mm.ui.contact.a.a iVar = new com.tencent.mm.ui.contact.a.i(i2);
        iVar.rqp = i;
        iVar.waM = z;
        return iVar;
    }

    private com.tencent.mm.ui.contact.a.a ed(int i, int i2) {
        com.tencent.mm.ui.contact.a.a gVar = new com.tencent.mm.ui.contact.a.g(i2);
        gVar.mdo = this.vYf.getActivity().getResources().getString(i);
        return gVar;
    }

    public void finish() {
        super.finish();
        w.i("MicroMsg.MMSearchContactAdapter", "finish!");
        Oe();
    }

    protected boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        int i = aVar.position + 1;
        int[] iArr = new int[]{this.vYz, this.vYA, this.vVX, this.vVY};
        for (int i2 = 0; i2 < 4; i2++) {
            if (i == iArr[i2]) {
                return true;
            }
        }
        return false;
    }

    public final boolean BM(int i) {
        int headerViewsCount = i - this.vYf.bcW().getHeaderViewsCount();
        if (headerViewsCount == this.vYC) {
            if (this.vYB) {
                headerViewsCount = this.vYf.bcW().getSelectedItemPosition();
                this.vYB = false;
                f(this.fRM, true, false);
                this.vYf.bcW().setSelection(headerViewsCount);
                return true;
            }
            this.vYB = true;
            f(this.fRM, true, false);
            this.vYf.bcW().setSelection(this.vYC);
            return true;
        } else if (headerViewsCount != this.vYE) {
            com.tencent.mm.ui.contact.a.a BL = BL(headerViewsCount);
            if (!(BL == null || !BL.wal || this.vYy == Integer.MAX_VALUE)) {
                if (BL.position == this.vYy) {
                    u.BN(1);
                    return false;
                }
                u.BN(0);
            }
            return false;
        } else if (this.vYD) {
            headerViewsCount = this.vYf.bcW().getSelectedItemPosition();
            this.vYD = false;
            f(this.fRM, true, false);
            this.vYf.bcW().setSelection(headerViewsCount);
            return true;
        } else {
            this.vYD = true;
            f(this.fRM, true, false);
            this.vYf.bcW().setSelection(this.vYE);
            return true;
        }
    }
}
