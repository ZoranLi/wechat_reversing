package com.tencent.mm.plugin.aa.ui;

import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.l;
import com.tencent.mm.ui.contact.o;
import java.util.List;

public final class d extends o {
    private String chatroomName;
    private List<String> ipK = h.mG(this.chatroomName);

    public d(l lVar, String str) {
        super(lVar, null, true, true);
        this.chatroomName = str;
        w.i("MicroMsg.AASelectInitAdapter", "resetData");
    }

    protected final a hg(int i) {
        String str = (String) this.ipK.get(i);
        ap.yY();
        x Rc = c.wR().Rc(str);
        a cVar = new c(i);
        cVar.fET = this.chatroomName;
        cVar.jiL = Rc;
        cVar.vYg = true;
        return cVar;
    }

    public final int getCount() {
        return this.ipK.size();
    }
}
