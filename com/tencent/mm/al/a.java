package com.tencent.mm.al;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

public final class a {
    public static boolean aH(Context context) {
        return com.tencent.mm.n.a.aH(context);
    }

    public static boolean HD() {
        return com.tencent.mm.pluginsdk.l.a.sBy != null && com.tencent.mm.pluginsdk.l.a.sBy.aGu();
    }

    public static h a(Context context, int i, final Runnable runnable) {
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.zW(R.l.dIO);
        aVar.zX(i);
        aVar.zZ(R.l.eCa).a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        aVar.kK(true);
        aVar.d(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
        h WJ = aVar.WJ();
        WJ.show();
        return WJ;
    }
}
