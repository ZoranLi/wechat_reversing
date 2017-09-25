package com.tencent.mm.plugin.multitalk.ui;

import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.List;

public final class a extends o {
    private String chatroomName;
    private List<String> ipK = c.xa().fZ(this.chatroomName);

    public a(l lVar, String str) {
        super(lVar, null, true, true);
        this.chatroomName = str;
        w.i("MicroMsg.multitalk.MultiTalkSelectInitAdapter", "resetData");
        ap.yY();
        if (this.ipK == null) {
            this.ipK = new ArrayList();
        }
    }

    protected final com.tencent.mm.ui.contact.a.a hg(int i) {
        String str = (String) this.ipK.get(i);
        ap.yY();
        x Rc = c.wR().Rc(str);
        com.tencent.mm.ui.contact.a.a aVar = new com.tencent.mm.plugin.multitalk.ui.widget.a(i);
        aVar.jiL = Rc;
        aVar.vYg = bcP();
        return aVar;
    }

    public final int getCount() {
        return this.ipK.size();
    }
}
