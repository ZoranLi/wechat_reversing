package com.tencent.mm.compatible.util;

import android.content.Context;

public final class b {
    public b gSp = null;
    private final String gSq = "audio_lock";
    public Context mContext = null;

    public interface a {
        void cX(int i);
    }

    public interface b {
        void a(a aVar);

        boolean rY();

        boolean requestFocus();
    }

    public b(Context context) {
        this.mContext = context;
        com.tencent.mm.compatible.a.a.a(8, new com.tencent.mm.compatible.a.a.a(this) {
            final /* synthetic */ b gSr;

            {
                this.gSr = r1;
            }

            public final void run() {
                this.gSr.gSp = new c(this.gSr.mContext);
            }
        });
    }

    public final boolean requestFocus() {
        boolean z;
        synchronized ("audio_lock") {
            if (this.gSp == null) {
                z = false;
            } else {
                z = this.gSp.requestFocus();
            }
        }
        return z;
    }

    public final boolean rY() {
        boolean z;
        synchronized ("audio_lock") {
            if (this.gSp == null) {
                z = false;
            } else {
                z = this.gSp.rY();
            }
        }
        return z;
    }

    public final void a(a aVar) {
        if (this.gSp != null) {
            this.gSp.a(aVar);
        }
    }
}
