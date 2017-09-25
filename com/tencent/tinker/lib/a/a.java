package com.tencent.tinker.lib.a;

import android.content.Context;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.lib.e.b;
import com.tencent.tinker.lib.e.c;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class a implements b {
    public final Context context;

    public a(Context context) {
        this.context = context;
    }

    public final int VM(String str) {
        int cw = cw(str, SharePatchFileUtil.X(new File(str)));
        if (cw == 0) {
            TinkerPatchService.bI(this.context, str);
        } else {
            com.tencent.tinker.lib.d.a.hp(this.context).xgq.c(new File(str), cw);
        }
        return cw;
    }

    public int cw(String str, String str2) {
        com.tencent.tinker.lib.d.a hp = com.tencent.tinker.lib.d.a.hp(this.context);
        if (!ShareTinkerInternals.Ea(hp.tinkerFlags) || !ShareTinkerInternals.hD(this.context)) {
            return -1;
        }
        if (!SharePatchFileUtil.U(new File(str))) {
            return -2;
        }
        if (hp.xgu) {
            return -4;
        }
        if (b.hr(this.context)) {
            return -3;
        }
        if (ShareTinkerInternals.cgW()) {
            return -5;
        }
        hp = com.tencent.tinker.lib.d.a.hp(this.context);
        if (hp.xgw) {
            d dVar = hp.xgv;
            if (!(dVar == null || dVar.xgD || !str2.equals(dVar.xgA))) {
                return -6;
            }
        }
        if (c.hu(this.context).VO(str2)) {
            return 0;
        }
        return -7;
    }
}
