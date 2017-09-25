package com.tencent.mm.plugin.soter.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Process;
import com.tencent.d.a.c.f;
import com.tencent.d.b.b.a;
import com.tencent.d.b.f.i;
import com.tencent.mm.plugin.soter.c.g;
import com.tencent.mm.sdk.platformtools.w;

public final class e extends i {
    public e(Context context, com.tencent.d.b.f.e eVar) {
        super(context, eVar);
    }

    @SuppressLint({"DefaultLocale"})
    protected final void a(String str, int[] iArr) {
        w.v("MicroMsg.SoterTaskInitForWX", "alvinluo generateAuthKeyNames");
        for (int i : iArr) {
            Object blX;
            if (i == 1) {
                blX = g.blX();
            } else {
                blX = String.format("SoterAuthKey_uid%d_salt%s_scene%d", new Object[]{Integer.valueOf(Process.myUid()), f.mz(str), Integer.valueOf(i)});
            }
            w.i("MicroMsg.SoterTaskInitForWX", "alvinluo scene: %d, authKeyName: %s", new Object[]{Integer.valueOf(i), blX});
            a.cfM().cfO().put(i, blX);
        }
    }
}
