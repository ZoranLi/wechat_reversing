package com.tencent.mm.ui.transmit;

import android.os.Looper;
import com.tencent.mm.kernel.h;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.m;
import java.util.ArrayList;
import java.util.List;

public final class b extends m {
    String fRM;
    private ae handler = new ae(Looper.getMainLooper());
    private a mah;
    List<i> maj;
    private MMCreateChatroomUI wpC;
    private j wpD = new j(this) {
        final /* synthetic */ b wpE;

        {
            this.wpE = r1;
        }

        public final void a(g gVar) {
            if (gVar.aMA == 0) {
                this.wpE.maj = gVar.maj;
            } else {
                this.wpE.maj = null;
            }
            if (this.wpE.maj == null) {
                this.wpE.maj = new ArrayList();
            }
            if (this.wpE.maj.size() == 0) {
                i iVar = new i();
                iVar.lZO = "no_result​";
                this.wpE.maj = new ArrayList();
                this.wpE.maj.add(iVar);
            }
            this.wpE.clearCache();
            this.wpE.notifyDataSetChanged();
            this.wpE.vYe.r(gVar.lYe.fRM, this.wpE.maj.size(), true);
        }
    };

    public b(MMCreateChatroomUI mMCreateChatroomUI, int i) {
        super(mMCreateChatroomUI, false, i);
        this.wpC = mMCreateChatroomUI;
    }

    public final void a(String str, int[] iArr, boolean z) {
        this.fRM = str;
        f fVar = new f();
        fVar.handler = this.handler;
        fVar.mag = this.wpD;
        fVar.fRM = str;
        fVar.maf = com.tencent.mm.plugin.fts.a.b.b.maC;
        fVar.maa = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
        fVar.mae.add("filehelper");
        fVar.mae.add(com.tencent.mm.u.m.xL());
        fVar.mae.addAll(this.wpC.wpG.caa());
        this.mah = ((l) h.j(l.class)).search(2, fVar);
    }

    public final void QZ() {
        if (this.mah != null) {
            ((l) h.j(l.class)).cancelSearchTask(this.mah);
        }
        this.fRM = null;
    }

    protected final com.tencent.mm.ui.contact.a.a hg(int i) {
        com.tencent.mm.ui.contact.a.a hVar;
        i iVar = (i) this.maj.get(i);
        if (iVar.lZO.equals("no_result​")) {
            hVar = new com.tencent.mm.ui.contact.a.h(i);
        } else {
            com.tencent.mm.ui.contact.a.a dVar = new d(i);
            dVar.iJC = iVar;
            dVar.mai = new String[]{this.fRM};
            dVar.vYg = bcP();
            dVar.wal = true;
            dVar.mdf = i + 1;
            dVar.cc(dVar.iJC.type, dVar.iJC.hPr);
            hVar = dVar;
        }
        hVar.fRM = this.fRM;
        hVar.scene = this.scene;
        hVar.vYg = false;
        return hVar;
    }

    public final int getCount() {
        if (this.maj != null) {
            return this.maj.size();
        }
        return 0;
    }
}
