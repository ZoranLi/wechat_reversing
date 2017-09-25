package com.tencent.mm.plugin.search.ui;

import android.os.Looper;
import android.os.Message;
import android.widget.AbsListView;
import com.tencent.mm.as.h;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.search.a.c;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class f extends b implements b {
    private ae peL = new ae(Looper.getMainLooper());
    private boolean pfH;
    private boolean pfI;
    boolean pfK;
    private List<i> pfN;
    private h pfO = new h();
    private long pfP;
    private long pfQ;
    private long pfR;
    private long pfS;
    private ae pfT = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ f pfX;

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    if (!this.pfX.pfI && this.pfX.getCount() > 0) {
                        c.aZl().aya();
                        m.pQA.start();
                        this.pfX.notifyDataSetChanged();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private int pfU = -1;
    boolean pfV;
    private boolean pfW;
    int pfa = 1;

    private class a implements Runnable {
        private String fRM;
        final /* synthetic */ f pfX;
        private i pfY;

        a(f fVar, i iVar, String str) {
            this.pfX = fVar;
            this.fRM = str;
            this.pfY = iVar;
        }

        public final void run() {
            if (!this.pfX.pfV && ((i) this.pfX.pfN.get(this.pfX.pfN.size() - 1)).getType() == this.pfY.getType()) {
                this.pfX.pfV = true;
            }
            int i = 0;
            for (i mS : this.pfX.pfN) {
                i = mS.mS(i);
            }
            this.pfX.sn(i);
            this.pfX.notifyDataSetChanged();
            this.pfX.L(i, this.pfX.pfV);
            if (this.pfX.pfV) {
                this.pfX.pfO.hPk = System.currentTimeMillis();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(com.tencent.mm.plugin.search.ui.c r7, int r8) {
        /*
        r6 = this;
        r0 = 1;
        r6.<init>(r7);
        r6.pfa = r0;
        r1 = new com.tencent.mm.plugin.search.ui.f$1;
        r2 = android.os.Looper.getMainLooper();
        r1.<init>(r6, r2);
        r6.pfT = r1;
        r1 = new com.tencent.mm.sdk.platformtools.ae;
        r2 = android.os.Looper.getMainLooper();
        r1.<init>(r2);
        r6.peL = r1;
        r1 = -1;
        r6.pfU = r1;
        r1 = new com.tencent.mm.as.h;
        r1.<init>();
        r6.pfO = r1;
        r1 = new java.util.HashSet;
        r1.<init>();
        r2 = 16;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = 32;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = 48;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = 64;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = 80;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = 96;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = 112; // 0x70 float:1.57E-43 double:5.53E-322;
        r2 = java.lang.Integer.valueOf(r2);
        r1.add(r2);
        r2 = com.tencent.mm.kernel.h.vG();
        r2 = r2.uV();
        if (r2 == 0) goto L_0x00c8;
    L_0x007d:
        r2 = new com.tencent.mm.e.a.oh;
        r2.<init>();
        r3 = com.tencent.mm.sdk.b.a.urY;
        r3.m(r2);
        r3 = com.tencent.mm.u.c.c.Az();
        r4 = "100193";
        r3 = r3.dX(r4);
        r4 = r3.isValid();
        if (r4 == 0) goto L_0x00c8;
    L_0x0098:
        r4 = "1";
        r3 = r3.bKK();
        r5 = "isOpenLocalSearch";
        r3 = r3.get(r5);
        r3 = r4.equals(r3);
        if (r3 == 0) goto L_0x00c8;
    L_0x00ac:
        r2 = r2.fVr;
        r2 = r2.fVt;
        if (r2 == 0) goto L_0x00c8;
    L_0x00b2:
        if (r0 == 0) goto L_0x00bd;
    L_0x00b4:
        r0 = 144; // 0x90 float:2.02E-43 double:7.1E-322;
        r0 = java.lang.Integer.valueOf(r0);
        r1.add(r0);
    L_0x00bd:
        r0 = r6.getContext();
        r0 = com.tencent.mm.plugin.fts.d.h.a(r1, r0, r6, r8);
        r6.pfN = r0;
        return;
    L_0x00c8:
        r0 = 0;
        goto L_0x00b2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.search.ui.f.<init>(com.tencent.mm.plugin.search.ui.c, int):void");
    }

    protected final com.tencent.mm.plugin.fts.d.a.a mT(int i) {
        com.tencent.mm.plugin.fts.d.a.a aVar = null;
        for (i mT : this.pfN) {
            aVar = mT.mT(i);
            if (aVar != null) {
                break;
            }
        }
        com.tencent.mm.plugin.fts.d.a.a aVar2 = aVar;
        if (aVar2 != null) {
            LinkedList linkedList = new LinkedList();
            for (i mT2 : this.pfN) {
                linkedList.addAll(mT2.axW());
            }
            for (int size = linkedList.size() - 1; size >= 0; size--) {
                if (i > ((Integer) linkedList.get(size)).intValue()) {
                    i -= size;
                    break;
                }
            }
            aVar2.mdf = i;
            if (aVar2.position == getCount() - 1) {
                aVar2.mdd = true;
            }
        }
        return aVar2;
    }

    protected final void aZo() {
        this.pfH = false;
        this.pfK = false;
        this.pfU = -1;
        this.pfV = false;
        this.pfO.reset();
        this.pfa = 1;
        this.pfP = 0;
        this.pfQ = 0;
        this.pfR = 0;
        this.pfS = 0;
        HashSet hashSet = new HashSet();
        hashSet.add("filehelper");
        boolean ys = com.tencent.mm.u.m.ys();
        if (!ys) {
            ys = bg.getInt(g.sV().getValue("BindQQSwitch"), 1) == 1;
        }
        if (!ys) {
            w.i("MicroMsg.FTS.FTSMainAdapter", "summerqq BindQQSwitch off");
            hashSet.add("22");
            hashSet.add("23");
        }
        w.d("MicroMsg.FTS.FTSMainAdapter", "summerqq doSearch blockSet[%d]", new Object[]{Integer.valueOf(hashSet.size())});
        c(hashSet);
    }

    public final void finish() {
        boolean z = true;
        if (!this.pfH) {
            this.pfH = true;
            if (!this.pfK) {
                String str = this.fRM;
                int aZt = aZt();
                if (this.pfO.hPL <= 0) {
                    z = false;
                }
                com.tencent.mm.as.g.a(str, false, aZt, 0, z);
            }
        }
        if (!(this.pfK || this.pfW)) {
            com.tencent.mm.as.i.c(this.fRM, this.pfa, 3, 3);
        }
        this.pfO.reset();
        super.finish();
    }

    protected final void clearCache() {
        super.clearCache();
        for (i iVar : this.pfN) {
            iVar.axV();
            iVar.QZ();
        }
    }

    public final void stopSearch() {
        this.pfT.removeMessages(1);
        super.stopSearch();
    }

    protected final boolean a(com.tencent.mm.plugin.fts.d.a.a aVar) {
        if (aVar.mdm) {
            this.pfW = true;
            w.d("MicroMsg.FTS.FTSMainAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[]{Integer.valueOf(aVar.mde), Integer.valueOf(aVar.mcx), Integer.valueOf(aVar.mdf), Integer.valueOf(aVar.mdg), aVar.mdh, Long.valueOf(aVar.mdi)});
            if (!this.pfH) {
                com.tencent.mm.as.g.a(this.fRM, true, aZt(), 0, this.pfO.hPL > 0);
                this.pfH = true;
            }
            if (!bg.mA(this.fRM)) {
                com.tencent.mm.as.i.c(this.fRM, this.pfa, 1, 3);
            }
            com.tencent.mm.as.g.a(aVar, this.pfO);
            return true;
        }
        if (aVar instanceof com.tencent.mm.plugin.search.ui.a.c) {
            this.pfK = true;
            if (!bg.mA(this.fRM)) {
                com.tencent.mm.as.i.c(this.fRM, this.pfa, 1, 3);
            }
            com.tencent.mm.as.g.a(aVar, this.pfO);
        }
        return false;
    }

    public final void a(i iVar, String str) {
        com.tencent.mm.plugin.fts.d.c cVar = (com.tencent.mm.plugin.fts.d.c) iVar;
        if (str.equals(this.fRM)) {
            c(cVar.mae);
        }
        int i = 0;
        for (int i2 = 0; i2 < cVar.mcy.size(); i2++) {
            i += ((com.tencent.mm.plugin.fts.d.i.a) cVar.mcy.get(i2)).mcR.size();
        }
        if (i > 0 && this.pfP == 0) {
            this.pfP = System.currentTimeMillis() - this.pfl;
            com.tencent.mm.as.g.j(9, this.pfP);
            w.i("MicroMsg.FTS.FTSMainAdapter", "firstItemTime=%d", new Object[]{Long.valueOf(this.pfP)});
        }
        switch (cVar.getType()) {
            case 16:
                if (this.pfQ == 0) {
                    this.pfQ = System.currentTimeMillis() - this.pfl;
                    w.i("MicroMsg.FTS.FTSMainAdapter", "firstGetTopHitsTime=%d", new Object[]{Long.valueOf(this.pfQ)});
                    com.tencent.mm.as.g.j(0, this.pfQ);
                    break;
                }
                break;
            case 32:
                if (this.pfR == 0) {
                    this.pfR = System.currentTimeMillis() - this.pfl;
                    w.i("MicroMsg.FTS.FTSMainAdapter", "firstGetContactTime=%d", new Object[]{Long.valueOf(this.pfR)});
                    com.tencent.mm.as.g.j(3, this.pfR);
                    break;
                }
                break;
            case 48:
                if (this.pfS == 0) {
                    this.pfS = System.currentTimeMillis() - this.pfl;
                    w.i("MicroMsg.FTS.FTSMainAdapter", "firstGetChatroomTime=%d", new Object[]{Long.valueOf(this.pfS)});
                    com.tencent.mm.as.g.j(6, this.pfS);
                    break;
                }
                break;
        }
        h hVar = this.pfO;
        for (com.tencent.mm.plugin.fts.d.i.a aVar : cVar.mcy) {
            switch (aVar.hPq) {
                case -11:
                    hVar.hPT = aVar.mcR.size();
                    break;
                case -8:
                    hVar.hPL = aVar.mcR.size();
                    break;
                case -7:
                    hVar.hPO = aVar.mcR.size();
                    break;
                case -6:
                    hVar.hPQ = aVar.mcR.size();
                    break;
                case -5:
                    hVar.hPS = aVar.mcR.size();
                    break;
                case -4:
                    hVar.hPM = aVar.mcR.size();
                    break;
                case -3:
                    hVar.hPN = aVar.mcR.size();
                    break;
                case -2:
                    hVar.hPP = aVar.mcR.size();
                    break;
                case -1:
                    hVar.hPR = aVar.mcR.size();
                    break;
                default:
                    break;
            }
        }
        new a(this, iVar, str).run();
    }

    private void c(HashSet<String> hashSet) {
        this.pfU++;
        if (this.pfU < this.pfN.size()) {
            ((i) this.pfN.get(this.pfU)).a(this.fRM, this.peL, hashSet);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        super.onScroll(absListView, i, i2, i3);
        if (absListView.getLastVisiblePosition() == getCount() && this.pfV) {
            this.pfa = 2;
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.pfI = true;
            com.tencent.mm.plugin.fts.d.h.aye().axY();
            m.pQA.pause();
            return;
        }
        this.pfI = false;
        if (!com.tencent.mm.plugin.fts.d.h.aye().axZ()) {
            this.pfT.removeMessages(1);
            this.pfT.sendEmptyMessageDelayed(1, 200);
        }
    }
}
