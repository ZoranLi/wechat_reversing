package com.tencent.mm.plugin.safedevice;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.k;

public final class a implements k {
    public static i imv;
    private static h imw;

    public final void a(i iVar) {
        imv = iVar;
    }

    public final void a(h hVar) {
        imw = hVar;
    }

    public static void a(Context context, Intent intent, Intent intent2) {
        imv.a(context, intent, intent2);
    }
}
