package com.tencent.mm.plugin.backup.g;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.LinkedList;

public final class b {
    ae handler = new ae(Looper.getMainLooper());
    public LinkedList<a> jIs = new LinkedList();

    class a {
        final /* synthetic */ b jIu;
        public Object obj;
        public int type;

        public a(b bVar, int i, Object obj) {
            this.jIu = bVar;
            this.type = i;
            this.obj = obj;
        }
    }

    public final boolean c(final int i, final Object obj) {
        this.handler.post(new Runnable(this) {
            final /* synthetic */ b jIu;

            public final void run() {
                this.jIu.jIs.add(new a(this.jIu, i, obj));
            }
        });
        return true;
    }
}
