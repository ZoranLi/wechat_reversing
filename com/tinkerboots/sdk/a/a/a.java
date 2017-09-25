package com.tinkerboots.sdk.a.a;

import android.content.Context;
import com.tinkerboots.sdk.b.b;
import com.tinkerboots.sdk.b.c;
import java.util.Map;

public class a implements b {
    public boolean aDm() {
        Context context = b.getContext();
        com.tencent.tinker.lib.d.a hp = com.tencent.tinker.lib.d.a.hp(context);
        if (!com.tinkerboots.sdk.b.a.isConnected(context)) {
            com.tencent.tinker.lib.e.a.i("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, not connect to internet", new Object[0]);
            return false;
        } else if (com.tencent.tinker.lib.e.b.hr(context)) {
            com.tencent.tinker.lib.e.a.i("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, tinker service is running", new Object[0]);
            return false;
        } else if (!hp.qPN) {
            com.tencent.tinker.lib.e.a.i("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, only request on the main process", new Object[0]);
            return false;
        } else if (!c.chX()) {
            return true;
        } else {
            com.tencent.tinker.lib.e.a.e("Tinker.PatchRequestCallback", "TinkerBootsRequestCallback: beforePatchRequest return false, is in ignore channel, current channel:%s", new Object[]{c.chW()});
            return false;
        }
    }

    public void w(Map<String, String> map) {
    }

    public void aDn() {
    }
}
