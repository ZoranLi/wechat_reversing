package com.tencent.mm.plugin.multitalk.ui;

import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.q;
import java.util.List;

public final class b extends q {
    private String chatroomName;
    private String fRM;
    private String[] ipL;
    private Cursor ipM;

    public b(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, null, true, 0);
        this.chatroomName = str;
        ap.yY();
        List fZ = c.xa().fZ(this.chatroomName);
        if (fZ != null) {
            this.ipL = bg.bU(fZ);
        }
    }

    public final void a(String str, int[] iArr, boolean z) {
        w.i("MicroMsg.multitalk.MultiTalkSelectSearchAdapter", "doSearch: %s", new Object[]{str});
        clearCache();
        this.fRM = str;
        if (this.ipM != null) {
            this.ipM.close();
            this.ipM = null;
        }
        if (!(bg.mA(this.fRM) || this.ipL == null)) {
            ap.yY();
            this.ipM = c.wR().a(this.ipL, "@all.chatroom", this.fRM, null, null);
        }
        notifyDataSetChanged();
        aZ(str, true);
    }

    protected final a hg(int i) {
        if (!this.ipM.moveToPosition(i)) {
            return null;
        }
        x xVar = new x();
        xVar.b(this.ipM);
        a aVar = new com.tencent.mm.plugin.multitalk.ui.widget.a(i);
        aVar.jiL = xVar;
        aVar.vYg = bcP();
        aVar.fRM = this.fRM;
        return aVar;
    }

    public final void finish() {
        super.finish();
        if (this.ipM != null) {
            this.ipM.close();
            this.ipM = null;
        }
    }

    public final int getCount() {
        if (this.ipM == null) {
            return 0;
        }
        return this.ipM.getCount();
    }
}
