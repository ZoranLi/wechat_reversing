package com.tencent.mm.plugin.photoedit.c;

import android.content.Context;
import com.tencent.mm.pluginsdk.ui.chat.j;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.c;

public final class e implements j {
    private Context mContext;
    private a olb;

    public interface a {
        void aJU();

        void q(c cVar);
    }

    public e(Context context, a aVar) {
        this.olb = aVar;
        this.mContext = context;
    }

    public final void n(c cVar) {
        if (this.olb != null) {
            this.olb.q(cVar);
            w.i("MicroMsg.WrappedSimleyPanelCallback", "emoji:%s", new Object[]{cVar});
        }
    }

    public final void o(c cVar) {
        if (this.olb != null) {
            this.olb.q(cVar);
            w.i("MicroMsg.WrappedSimleyPanelCallback", "emoji:%s", new Object[]{cVar});
        }
    }

    public final boolean aJS() {
        return true;
    }

    public final boolean aJT() {
        return true;
    }

    public final void aJU() {
        if (this.olb != null) {
            this.olb.aJU();
        }
    }
}
