package com.tencent.mm.compatible.i;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.sdk.platformtools.w;

public final class b {
    public static boolean b(Activity activity, int i) {
        final Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        intent.putExtra("android.intent.extra.videoQuality", 0);
        a.a(8, new a.a() {
            public final void run() {
                intent.putExtra("android.intent.extra.durationLimit", 30);
                intent.putExtra("android.intent.extra.sizeLimit", 10485760);
            }
        });
        try {
            activity.startActivityForResult(intent, 4372);
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.TakeVideoUtil", e, "", new Object[0]);
            return false;
        }
    }
}
