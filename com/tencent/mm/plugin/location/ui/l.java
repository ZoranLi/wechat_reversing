package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mm.R;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;

public final class l {
    public Resources Cu;
    public Context mContext;
    public a nfj;
    public h nfk = null;

    class AnonymousClass8 implements OnClickListener {
        final /* synthetic */ int izu;
        final /* synthetic */ l nfl;

        public AnonymousClass8(l lVar, int i) {
            this.nfl = lVar;
            this.izu = i;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (this.nfl.nfj != null) {
                this.nfl.nfj.oH(this.izu);
            }
        }
    }

    public interface a {
        void aGV();

        void aGW();

        void aGX();

        void fp(boolean z);

        void oH(int i);
    }

    public l(Context context, a aVar) {
        this.mContext = context;
        this.nfj = aVar;
        this.Cu = this.mContext.getResources();
    }

    public final void aGU() {
        if (!oF(67590)) {
            g.a(this.mContext, this.Cu.getString(R.l.ewF), "", false, new OnClickListener(this) {
                final /* synthetic */ l nfl;

                {
                    this.nfl = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.nfl.nfj != null) {
                        this.nfl.nfj.aGV();
                    }
                }
            }, new OnClickListener(this) {
                final /* synthetic */ l nfl;

                {
                    this.nfl = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            oG(67590);
        } else if (this.nfj != null) {
            this.nfj.aGV();
        }
    }

    public static boolean oF(int i) {
        ap.yY();
        Object obj = c.vr().get(i, null);
        if (obj == null) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }

    public static void oG(int i) {
        ap.yY();
        c.vr().set(i, Boolean.valueOf(true));
    }
}
