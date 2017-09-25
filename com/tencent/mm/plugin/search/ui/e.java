package com.tencent.mm.plugin.search.ui;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.widget.AbsListView;
import com.tencent.mm.as.c;
import com.tencent.mm.as.g;
import com.tencent.mm.plugin.fts.d.a.a;
import com.tencent.mm.plugin.fts.d.h;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashSet;

public final class e extends b implements b {
    private int mde;
    private boolean nhO;
    private ae peL = new ae(Looper.getMainLooper());
    private i pfF;
    private c pfG;
    private boolean pfH;
    private boolean pfI;
    private ae pfJ = new ae(this, Looper.getMainLooper()) {
        final /* synthetic */ e pfL;

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    w.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is true");
                    if (!this.pfL.pfI && this.pfL.getCount() > 0) {
                        com.tencent.mm.plugin.search.a.c.aZl().aya();
                        m.pQA.start();
                        this.pfL.notifyDataSetChanged();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private boolean pfK;

    public e(c cVar, int i, int i2) {
        super(cVar);
        this.mde = i;
        Context context = getContext();
        int i3 = -1;
        switch (i) {
            case -13:
                i3 = 4208;
                break;
            case -7:
                i3 = 4192;
                break;
            case -5:
                i3 = 4144;
                break;
            case -4:
                i3 = 4112;
                break;
            case -3:
                i3 = 4128;
                break;
            case -2:
                i3 = 4160;
                break;
            case -1:
                i3 = 4176;
                break;
        }
        w.i("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | uiLogicType=%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i3)});
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(i3));
        this.pfF = (i) h.a(hashSet, context, this, i2).get(0);
        this.pfG = new c();
    }

    protected final a mT(int i) {
        a mT = this.pfF.mT(i);
        if (mT != null) {
            mT.mdf = i;
        }
        return mT;
    }

    protected final void aZo() {
        this.nhO = true;
        this.pfH = false;
        this.pfG.reset();
        this.pfF.a(this.fRM, this.peL, new HashSet());
    }

    protected final void clearCache() {
        super.clearCache();
        this.pfF.QZ();
        this.pfF.axV();
        this.pfJ.removeMessages(1);
    }

    protected final boolean a(a aVar) {
        if (aVar.mdm) {
            w.d("MicroMsg.FTS.FTSDetailAdapter", "searchType=%d | searchScene=%d | kvPosition=%d | kvSubPosition=%d | kvSearchId=%s | kvDocId=%d", new Object[]{Integer.valueOf(aVar.mde), Integer.valueOf(aVar.mcx), Integer.valueOf(aVar.mdf), Integer.valueOf(aVar.mdg), aVar.mdh, Long.valueOf(aVar.mdi)});
            if (!this.pfH) {
                g.a(this.fRM, true, aZt(), aVar.mde, false);
                this.pfH = true;
            }
            g.a(aVar, this.pfG);
        } else if (aVar instanceof com.tencent.mm.plugin.search.ui.a.c) {
            this.pfK = true;
            g.a(aVar, this.pfG);
        }
        return false;
    }

    public final void finish() {
        if (!this.pfH) {
            this.pfH = true;
            if (!this.pfK) {
                g.a(this.fRM, false, aZt(), this.mde, false);
            }
        }
        this.pfG.reset();
        super.finish();
    }

    public final void a(i iVar, String str) {
        if (str.equals(this.fRM)) {
            this.nhO = false;
        }
        sn(iVar.mS(0));
        notifyDataSetChanged();
        L(getCount(), true);
        this.pfG.hPk = System.currentTimeMillis();
        c cVar = this.pfG;
        for (i.a aVar : ((com.tencent.mm.plugin.fts.d.c) iVar).mcy) {
            cVar.hPl = aVar.mcR.size() + cVar.hPl;
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        super.onScrollStateChanged(absListView, i);
        if (i == 2) {
            this.pfI = true;
            com.tencent.mm.plugin.search.a.c.aZl().axY();
            m.pQA.pause();
            w.d("MicroMsg.FTS.FTSDetailAdapter", "ImageEngine attach is false");
            return;
        }
        this.pfI = false;
        if (!com.tencent.mm.plugin.search.a.c.aZl().axZ()) {
            this.pfJ.removeMessages(1);
            this.pfJ.sendEmptyMessageDelayed(1, 200);
        }
    }
}
