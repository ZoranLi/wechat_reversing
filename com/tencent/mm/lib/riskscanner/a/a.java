package com.tencent.mm.lib.riskscanner.a;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.lib.riskscanner.RiskScannerReqBufferProvider;

public final class a {
    public static Bundle aM(Context context) {
        Bundle bundle = null;
        try {
            bundle = context.getContentResolver().call(RiskScannerReqBufferProvider.CONTENT_URI, "prepareReqBuffer", null, null);
        } catch (Throwable th) {
        }
        return bundle;
    }
}
