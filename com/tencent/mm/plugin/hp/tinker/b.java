package com.tencent.mm.plugin.hp.tinker;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.mm.app.n;
import com.tencent.mm.loader.stub.BaseBuildInfo;
import com.tencent.mm.plugin.hp.d.c;
import com.tencent.tinker.lib.a.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.Properties;

public final class b extends a {
    private final int mLG;

    public b(Context context) {
        super(context);
        this.mLG = ((ActivityManager) context.getSystemService("activity")).getMemoryClass();
        com.tencent.tinker.lib.e.a.i("Tinker.TinkerPatchListener", "application maxMemory:" + this.mLG, new Object[0]);
    }

    public final int cw(String str, String str2) {
        boolean z = false;
        com.tencent.tinker.lib.e.a.i("Tinker.TinkerPatchListener", "receive a patch file: %s, file size:%d", new Object[]{str, Long.valueOf(SharePatchFileUtil.V(new File(str)))});
        int cw = super.cw(str, str2);
        if (cw == 0) {
            cw = this.mLG < 45 ? -23 : !c.cq(83886080) ? -21 : 0;
        }
        if (cw == 0) {
            com.tencent.tinker.lib.d.a.hp(this.context);
            if (cw == 0) {
                Properties ab = ShareTinkerInternals.ab(r3);
                if (ab == null) {
                    cw = -24;
                } else {
                    String property = ab.getProperty("patch.basepack.client.ver");
                    com.tencent.tinker.lib.e.a.i("Tinker.TinkerPatchListener", "get BASE_CLIENT_VERSION:" + property, new Object[0]);
                    if (property == null || !property.equalsIgnoreCase(BaseBuildInfo.CLIENT_VERSION)) {
                        cw = -25;
                    }
                }
            }
        }
        if (cw == 0 && ShareTinkerInternals.cgV() && n.a(new Throwable().getStackTrace())) {
            cw = -26;
        }
        if (cw == 0) {
            z = true;
        }
        com.tencent.mm.plugin.hp.b.b.eO(z);
        return cw;
    }
}
