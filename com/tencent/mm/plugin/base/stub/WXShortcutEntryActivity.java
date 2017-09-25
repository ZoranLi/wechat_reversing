package com.tencent.mm.plugin.base.stub;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.ac.c;
import com.tencent.mm.plugin.ac.d;
import com.tencent.mm.plugin.ac.e;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity;
import com.tencent.mm.pluginsdk.ui.AutoLoginActivity.b;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public class WXShortcutEntryActivity extends AutoLoginActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final boolean u(Intent intent) {
        return true;
    }

    protected final void a(b bVar, Intent intent) {
        if (intent == null) {
            w.e("MicroMsg.WXShortcutEntryActivity", "intent is null");
            finish();
            return;
        }
        d dVar = new d();
        dVar.a(new e());
        dVar.a(new c());
        int a = s.a(intent, Columns.TYPE, 0);
        if (intent != null) {
            com.tencent.mm.plugin.ac.b bVar2 = (com.tencent.mm.plugin.ac.b) dVar.ptu.get(a);
            if (bVar2 != null) {
                bVar2.q(this, intent);
            }
        }
        finish();
    }
}
