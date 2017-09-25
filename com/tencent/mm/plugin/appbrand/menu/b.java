package com.tencent.mm.plugin.appbrand.menu;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.ui.base.l;

final class b extends a {
    b() {
        super(k.jaH - 1);
    }

    public final void a(Context context, m mVar, l lVar, String str) {
        if (com.tencent.mm.sdk.a.b.bIu()) {
            lVar.e(this.jaM, "appId: " + str);
        }
    }

    public final void a(Context context, m mVar, String str, j jVar) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("text", str));
            Toast.makeText(context, "copied appId: " + str, 1).show();
        }
    }
}
