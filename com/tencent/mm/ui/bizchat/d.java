package com.tencent.mm.ui.bizchat;

import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.modelbiz.a.c;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.g;
import com.tencent.mm.ui.contact.o;

public final class d extends o implements b {
    private Cursor ipM;
    private String kbi;
    private int oRR;

    public d(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, false, false);
        w.i("MicroMsg.RecentConversationAdapter", "create!");
        this.kbi = str;
        aue();
    }

    private void aue() {
        w.i("MicroMsg.RecentConversationAdapter", "resetData");
        if (this.ipM != null) {
            this.ipM.close();
            this.ipM = null;
        }
        this.ipM = com.tencent.mm.modelbiz.w.DK().io(this.kbi);
        this.oRR = 0;
    }

    public final int getCount() {
        return this.ipM.getCount() + 1;
    }

    protected final a hg(int i) {
        a gVar;
        if (i == this.oRR) {
            gVar = new g(i);
            gVar.mdo = this.vYf.getActivity().getResources().getString(R.l.eQt);
            return gVar;
        } else if (i <= this.oRR || !this.ipM.moveToPosition((i - this.oRR) - 1)) {
            w.e("MicroMsg.RecentConversationAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
            return null;
        } else {
            gVar = new a(i);
            com.tencent.mm.modelbiz.a.a aVar = new com.tencent.mm.modelbiz.a.a();
            aVar.b(this.ipM);
            if (gVar.kbc != -1) {
                return gVar;
            }
            gVar.kbc = aVar.field_bizChatId;
            c aa = com.tencent.mm.modelbiz.w.DJ().aa(aVar.field_bizChatId);
            if (aa.DV()) {
                gVar.ipq = aa.field_chatName;
                gVar.vvk = aa.field_headImageUrl;
                gVar.username = aa.field_brandUserName;
            } else {
                j iD = com.tencent.mm.modelbiz.w.DL().iD(aa.field_bizChatServId);
                if (iD != null) {
                    gVar.ipq = iD.field_userName;
                    gVar.vvk = iD.field_headImageUrl;
                    gVar.username = iD.field_brandUserName;
                }
            }
            if (bg.J(gVar.ipq)) {
                gVar.ipq = this.vYf.getActivity().getResources().getString(R.l.eMB);
            }
            if (!bg.mA(gVar.username)) {
                return gVar;
            }
            gVar.username = aVar.field_brandUserName;
            return gVar;
        }
    }

    public final void finish() {
        super.finish();
        w.i("MicroMsg.RecentConversationAdapter", "finish!");
        if (this.ipM != null) {
            this.ipM.close();
            this.ipM = null;
        }
    }

    public final void a(int i, m mVar, Object obj) {
        aue();
        notifyDataSetChanged();
    }
}
