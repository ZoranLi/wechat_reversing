package com.tinkerboots.sdk.tinker.b;

import android.content.Context;
import com.tencent.tinker.lib.a.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tinkerboots.sdk.b.c;
import java.io.File;

public final class b extends a {
    public b(Context context) {
        super(context);
    }

    public final int cw(String str, String str2) {
        File file = new File(str);
        com.tencent.tinker.lib.e.a.i("Tinker.TinkerServerPatchListener", "receive a patch file: %s, file size:%d", new Object[]{str, Long.valueOf(SharePatchFileUtil.V(file))});
        int cw = super.cw(str, str2);
        if (cw != 0) {
            return cw;
        }
        if (c.chX()) {
            return -20;
        }
        return 0;
    }
}
