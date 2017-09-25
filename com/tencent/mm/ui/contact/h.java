package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.a.d;
import java.util.ArrayList;
import java.util.List;

public final class h extends o {
    private Cursor ipM = c.wR().ce(this.vXw);
    private List<String> vXw;

    public h(MMBaseSelectContactUI mMBaseSelectContactUI, boolean z, List<String> list) {
        super(mMBaseSelectContactUI, new ArrayList(), true, z);
        this.vXw = list;
        ap.yY();
    }

    public final int getCount() {
        return this.ipM.getCount();
    }

    protected final a hg(int i) {
        if (i < 0 || !this.ipM.moveToPosition(i)) {
            w.e("MicroMsg.CustomContactAdapter", "create Data Item Error position=%d", new Object[]{Integer.valueOf(i)});
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
        w.i("MicroMsg.CustomContactAdapter", "finish!");
        if (this.ipM != null) {
            this.ipM.close();
            this.ipM = null;
        }
    }
}
