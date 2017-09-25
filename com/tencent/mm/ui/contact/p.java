package com.tencent.mm.ui.contact;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.R;
import com.tencent.mm.modelbiz.a.c;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.contact.m.a;
import java.util.List;

public final class p extends q {
    private String fRM;
    private ae handler = new ae(Looper.getMainLooper());
    private Cursor ipM;
    private String kbi;
    private a vYe;
    private List<String> vYx = null;

    public p(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, false, 0);
        this.kbi = str;
        w.i("MicroMsg.MMSearchContactAdapter", "Create!");
        Oe();
    }

    public final void a(a aVar) {
        this.vYe = aVar;
    }

    public final void aZ(String str, boolean z) {
        if (this.vYe != null) {
            this.vYe.r(str, getCount(), z);
        }
    }

    private void Oe() {
        w.i("MicroMsg.MMSearchContactAdapter", "initData!");
        this.fRM = null;
        clearCache();
    }

    public final int getCount() {
        return this.ipM == null ? 0 : this.ipM.getCount();
    }

    protected final com.tencent.mm.ui.contact.a.a hg(int i) {
        com.tencent.mm.ui.contact.a.a aVar = null;
        if (i < 0 || !this.ipM.moveToPosition(i)) {
            w.e("MicroMsg.MMSearchContactAdapter", "create Data Item Error position=%d", Integer.valueOf(i));
        } else {
            aVar = new com.tencent.mm.ui.bizchat.a(i);
            c cVar = new c();
            cVar.b(this.ipM);
            if (aVar.kbc == -1) {
                aVar.kbc = cVar.field_bizChatLocalId;
                if (cVar.DV()) {
                    aVar.ipq = cVar.field_chatName;
                    aVar.vvk = cVar.field_headImageUrl;
                    aVar.username = cVar.field_brandUserName;
                } else {
                    j iD = com.tencent.mm.modelbiz.w.DL().iD(cVar.field_bizChatServId);
                    if (iD != null) {
                        aVar.ipq = iD.field_userName;
                        aVar.vvk = iD.field_headImageUrl;
                        aVar.username = iD.field_brandUserName;
                    }
                }
                if (bg.J(aVar.ipq)) {
                    aVar.ipq = this.vYf.getActivity().getResources().getString(R.l.eMB);
                }
                if (bg.mA(aVar.username)) {
                    aVar.username = cVar.field_brandUserName;
                }
            }
        }
        return aVar;
    }

    public final void finish() {
        super.finish();
        w.i("MicroMsg.MMSearchContactAdapter", "finish!");
        Oe();
    }

    protected final boolean c(com.tencent.mm.ui.contact.a.a aVar) {
        return true;
    }
}
