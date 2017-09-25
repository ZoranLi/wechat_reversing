package com.tencent.mm.lib.riskscanner;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.c.a.b;
import com.tencent.c.a.b.a;
import com.tencent.mm.sdk.platformtools.w;

public class RiskScannerReqBufferProvider extends ContentProvider {
    public static final Uri CONTENT_URI = Uri.parse("content://com.tencent.mm.lib.riskscanner.RiskScannerReqBufferProvider");

    public boolean onCreate() {
        w.i("MicroMsg.RiskScannerReqBufferProvider", "onCreate called.");
        return true;
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        Bundle[] bundleArr = new Bundle[]{null};
        if ("prepareReqBuffer".equals(str)) {
            w.i("MicroMsg.RiskScannerReqBufferProvider", "invoke method: %s, with arg: %s, extras: %s", str, str2, bundle);
            return aM(getContext());
        }
        w.w("MicroMsg.RiskScannerReqBufferProvider", "unknown method: %s", str);
        return bundleArr[0];
    }

    private Bundle aM(Context context) {
        final Bundle[] bundleArr = new Bundle[]{null};
        try {
            a.wi();
            b.a(context, new a(this) {
                final /* synthetic */ RiskScannerReqBufferProvider hbq;

                public final void e(int i, byte[] bArr) {
                    a.eT(i);
                    Bundle[] bundleArr = bundleArr;
                    Bundle bundle = new Bundle();
                    bundleArr[0] = bundle;
                    if (i == 0 && bArr != null) {
                        bundle.putInt("errCode", i);
                        bundle.putByteArray("reqBufferBase64", bArr);
                    }
                }
            });
        } catch (Throwable th) {
            a.d(th);
        }
        return bundleArr[0];
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
