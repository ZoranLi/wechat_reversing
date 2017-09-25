package com.tencent.mm.plugin.wallet_index.b.a;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mm.plugin.wallet_index.ui.WalletIapUI.c;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;

public final class a {

    public interface a {
        void a(b bVar, c cVar);
    }

    public static c a(Intent intent, c cVar) {
        b vH;
        if (intent == null) {
            yl("Null data in IAB activity result.");
            vH = b.vH(-1002);
            if (cVar == null) {
                return null;
            }
            cVar.a(vH, null);
            return null;
        }
        int intExtra = intent.getIntExtra("RESPONSE_CODE", 0);
        String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
        String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
        if (intExtra == 0) {
            w.d("MicroMsg.IabResolver", "Successful resultcode from purchase activity.");
            w.d("MicroMsg.IabResolver", "Purchase data: " + stringExtra);
            w.d("MicroMsg.IabResolver", "Data signature: " + stringExtra2);
            w.d("MicroMsg.IabResolver", "Extras: " + intent.getExtras());
            if (stringExtra == null || stringExtra2 == null) {
                yl("BUG: either purchaseData or dataSignature is null.");
                vH = b.vH(-1008);
                if (cVar == null) {
                    return null;
                }
                cVar.a(vH, null);
                return null;
            }
            try {
                d dVar = new d("inapp", stringExtra, stringExtra2);
                stringExtra = dVar.kMS;
                w.d("MicroMsg.IabResolver", "Purchase signature successfully verified.");
                if (cVar != null) {
                    cVar.a(b.vH(0), dVar);
                }
                return new c(stringExtra, dVar);
            } catch (Throwable e) {
                yl("Failed to parse purchase data.");
                w.printErrStackTrace("MicroMsg.IabResolver", e, "", new Object[0]);
                vH = b.vH(-1002);
                if (cVar == null) {
                    return null;
                }
                cVar.a(vH, null);
                return null;
            }
        }
        yl("Purchase failed. Response: " + intExtra);
        vH = b.vH(intExtra);
        if (cVar == null) {
            return null;
        }
        cVar.a(vH, null);
        return null;
    }

    public final int a(Intent intent, a aVar) {
        c cVar = new c();
        int U = U(intent);
        w.d("MicroMsg.IabResolver", "Owned items response: " + String.valueOf(U));
        if (U != 0) {
            aVar.a(b.vH(U), null);
            return U;
        } else if (intent.hasExtra("INAPP_PURCHASE_ITEM_LIST") && intent.hasExtra("INAPP_PURCHASE_DATA_LIST") && intent.hasExtra("INAPP_DATA_SIGNATURE_LIST")) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("INAPP_PURCHASE_ITEM_LIST");
            ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("INAPP_PURCHASE_DATA_LIST");
            ArrayList stringArrayListExtra3 = intent.getStringArrayListExtra("INAPP_DATA_SIGNATURE_LIST");
            int i = 0;
            while (i < stringArrayListExtra2.size()) {
                try {
                    String str = (String) stringArrayListExtra2.get(i);
                    String str2 = (String) stringArrayListExtra3.get(i);
                    String str3 = "MicroMsg.IabResolver";
                    w.d(str3, "Sku is owned: " + ((String) stringArrayListExtra.get(i)));
                    d dVar = new d("inapp", str, str2);
                    if (TextUtils.isEmpty(dVar.hEr)) {
                        w.w("MicroMsg.IabResolver", "In-app billing warning: " + "BUG: empty/null token!");
                        w.d("MicroMsg.IabResolver", "Purchase data: " + str);
                    }
                    cVar.rPz.put(dVar.kMS, dVar);
                    i++;
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.IabResolver", e, "", new Object[0]);
                    aVar.a(b.vH(-1002), cVar);
                }
            }
            aVar.a(b.vH(0), cVar);
            return 0;
        } else {
            yl("Bundle returned from getPurchases() doesn't contain required fields.");
            aVar.a(b.vH(-1002), null);
            return -1002;
        }
    }

    private static void yl(String str) {
        w.e("MicroMsg.IabResolver", "In-app billing error: " + str);
    }

    public static int U(Intent intent) {
        if (intent == null) {
            yl("Intent with no response code, assuming OK (known issue)");
            return 1;
        }
        Object obj = intent.getExtras().get("RESPONSE_CODE");
        if (obj == null) {
            yl("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            yl("Unexpected type for intent response code.");
            yl(obj.getClass().getName());
            throw new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
        }
    }
}
