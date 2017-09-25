package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.d;
import java.util.ArrayList;

public final class w extends o {
    private Cursor ipM = c.wR().d(this.vUP, "", this.jBA);
    private String vUP;

    public w(MMBaseSelectContactUI mMBaseSelectContactUI, String str) {
        super(mMBaseSelectContactUI, new ArrayList(), false, false);
        this.vUP = str;
        ap.yY();
    }

    public final int getCount() {
        return this.ipM.getCount();
    }

    protected final a hg(int i) {
        if (i < 0 || !this.ipM.moveToPosition(i)) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.SpecialContactAdapter", "create Data Item Error position=%d", new Object[]{Integer.valueOf(i)});
            return null;
        }
        a dVar = new d(i);
        x xVar = new x();
        xVar.b(this.ipM);
        dVar.jiL = xVar;
        dVar.vYg = bcP();
        return dVar;
    }

    public final void finish() {
        super.finish();
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.SpecialContactAdapter", "finish!");
        if (this.ipM != null) {
            this.ipM.close();
            this.ipM = null;
        }
    }
}
