package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.content.Context;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.j;

public final class b extends a {
    public static final int CTRL_INDEX = 217;
    public static final String NAME = "saveImageToPhotosAlbum";

    final boolean k(final Context context, String str, String str2) {
        if (bg.mA(str)) {
            return false;
        }
        String MB = s.MB(str2);
        if (bg.mA(MB)) {
            MB = "jpg";
        }
        String mr = d.mr(MB);
        boolean p = j.p(str, mr, false);
        if (!p) {
            return p;
        }
        d.b(mr, context);
        af.v(new Runnable(this) {
            final /* synthetic */ b iTC;

            public final void run() {
                Toast.makeText(context, context.getString(R.l.eaX, new Object[]{d.Nk()}), 1).show();
            }
        });
        return p;
    }

    final boolean pt(String str) {
        return bg.mz(str).toLowerCase().contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE);
    }
}
