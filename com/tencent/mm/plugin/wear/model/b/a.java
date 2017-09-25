package com.tencent.mm.plugin.wear.model.b;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.ab;

public final class a {
    public static void I(Bundle bundle) {
        Intent intent = new Intent();
        intent.setPackage(ab.getContext().getPackageName());
        intent.setAction("com.tencent.mm.wear.message");
        intent.putExtras(bundle);
        ab.getContext().sendBroadcast(intent);
    }
}
