package com.tencent.mm.ui.base;

import android.content.Intent;
import android.os.Process;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.sdk.platformtools.ab;

public final class x {
    public static void a(boolean z, Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        intent.setAction(z ? "com.tencent.mm.ui.ACTION_ACTIVE" : "com.tencent.mm.ui.ACTION_DEACTIVE");
        intent.putExtra("_application_context_process_", ab.um());
        intent.putExtra("process_id", Process.myPid());
        intent.putExtra("process_is_mm", ab.bJb());
        ab.getContext().sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
    }
}
