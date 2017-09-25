package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.k;

public final class v implements t {
    public k fGg;
    public p irJ;
    public Context mContext;
    public a sDB;

    public interface a {
        void boq();
    }

    public v(Context context, a aVar) {
        this.mContext = context;
        this.sDB = aVar;
    }

    public final void a(int i, int i2, String str, w wVar) {
        w.i("MicroMsg.LoadAppInfoAfterLogin", "OnScenEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
        an.aBG().b(7, this);
        if (this.irJ != null && this.irJ.isShowing()) {
            this.irJ.dismiss();
            this.irJ = null;
        }
        if (this.sDB != null) {
            this.sDB.boq();
        }
        g.bCY();
    }
}
