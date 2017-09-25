package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.content.Context;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.j;

public final class c extends a {
    public static final int CTRL_INDEX = 216;
    public static final String NAME = "saveVideoToPhotosAlbum";

    final boolean k(Context context, String str, String str2) {
        String mr = d.mr("mp4");
        if (!j.ex(str, mr)) {
            mr = null;
        }
        if (bg.mA(mr)) {
            return false;
        }
        Toast.makeText(context, com.tencent.mm.plugin.appbrand.m.d.e(R.l.fam, mr), 1).show();
        k.b(mr, context);
        return true;
    }

    final boolean pt(String str) {
        return bg.mz(str).toLowerCase().contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE);
    }
}
