package com.tencent.mm.ui.contact.a;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.bg.a;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;

public final class b extends e {
    public String aIO;
    public int rqp = 0;
    private boolean wan;

    public b(int i) {
        super(i);
    }

    public final void br(Context context) {
        if (this.rqp == 0 || this.aIO == null) {
            x xVar = this.jiL;
            if (!this.wan) {
                ap.yY();
                xVar = c.wR().Rc(this.username);
                this.jiL = xVar;
                this.wan = true;
            }
            if (xVar == null) {
                this.ipq = "";
                return;
            }
            this.ipq = h.c(context, n.c(xVar), a.T(context, R.f.aXI));
            this.username = xVar.field_username;
            return;
        }
        this.wax = this.rqp;
        this.waw = this.aIO;
    }
}
