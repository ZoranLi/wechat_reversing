package com.tencent.mm.plugin.gwallet.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b {
    public Context mContext;
    public boolean mKA = false;
    public boolean mKB = false;
    public int mKC;
    public b mKD;
    public String mKE;
    public com.a.a.a.a mKy;
    private ServiceConnection mKz;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ ae jWW;
        final /* synthetic */ b mKG;
        final /* synthetic */ List mKH;
        final /* synthetic */ b mKI;

        public AnonymousClass2(b bVar, List list, b bVar2, ae aeVar) {
            this.mKG = bVar;
            this.mKH = list;
            this.mKI = bVar2;
            this.jWW = aeVar;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r6 = this;
            r0 = 0;
            r1 = r6.mKH;
            r2 = r1.iterator();
            r1 = r0;
        L_0x0008:
            r0 = r2.hasNext();
            if (r0 == 0) goto L_0x00b1;
        L_0x000e:
            r0 = r2.next();
            r0 = (java.lang.String) r0;
            r3 = r6.mKG;	 Catch:{ a -> 0x007e }
            r4 = "consume";
            r3.yk(r4);	 Catch:{ a -> 0x007e }
            if (r0 == 0) goto L_0x0027;
        L_0x001e:
            r4 = "";
            r4 = r0.equals(r4);	 Catch:{ RemoteException -> 0x0067 }
            if (r4 == 0) goto L_0x0041;
        L_0x0027:
            r4 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x0067 }
            r5 = "Can't consume ";
            r4.<init>(r5);	 Catch:{ RemoteException -> 0x0067 }
            r4 = r4.append(r0);	 Catch:{ RemoteException -> 0x0067 }
            r5 = ". No token.";
            r4 = r4.append(r5);	 Catch:{ RemoteException -> 0x0067 }
            r4 = r4.toString();	 Catch:{ RemoteException -> 0x0067 }
            com.tencent.mm.plugin.gwallet.a.b.yl(r4);	 Catch:{ RemoteException -> 0x0067 }
        L_0x0041:
            r4 = r3.mKy;	 Catch:{ RemoteException -> 0x0067 }
            r5 = 3;
            r3 = r3.mContext;	 Catch:{ RemoteException -> 0x0067 }
            r3 = r3.getPackageName();	 Catch:{ RemoteException -> 0x0067 }
            r3 = r4.c(r5, r3, r0);	 Catch:{ RemoteException -> 0x0067 }
            if (r3 != 0) goto L_0x0085;
        L_0x0050:
            r3 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x0067 }
            r4 = "Successfully consumed token: ";
            r3.<init>(r4);	 Catch:{ RemoteException -> 0x0067 }
            r3 = r3.append(r0);	 Catch:{ RemoteException -> 0x0067 }
            r3 = r3.toString();	 Catch:{ RemoteException -> 0x0067 }
            r4 = "MicroMsg.IabHelper";
            com.tencent.mm.sdk.platformtools.w.d(r4, r3);	 Catch:{ RemoteException -> 0x0067 }
            goto L_0x0008;
        L_0x0067:
            r1 = move-exception;
            r3 = new com.tencent.mm.plugin.gwallet.a.a;	 Catch:{ a -> 0x007e }
            r4 = new java.lang.StringBuilder;	 Catch:{ a -> 0x007e }
            r5 = "Remote exception while consuming. token: ";
            r4.<init>(r5);	 Catch:{ a -> 0x007e }
            r0 = r4.append(r0);	 Catch:{ a -> 0x007e }
            r0 = r0.toString();	 Catch:{ a -> 0x007e }
            r3.<init>(r0, r1);	 Catch:{ a -> 0x007e }
            throw r3;	 Catch:{ a -> 0x007e }
        L_0x007e:
            r0 = move-exception;
            r0 = r0.mKx;
            r0 = r0.mKQ;
            r1 = r0;
            goto L_0x0008;
        L_0x0085:
            r1 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x0067 }
            r4 = "Error consuming consuming token ";
            r1.<init>(r4);	 Catch:{ RemoteException -> 0x0067 }
            r1 = r1.append(r0);	 Catch:{ RemoteException -> 0x0067 }
            r1 = r1.toString();	 Catch:{ RemoteException -> 0x0067 }
            r4 = "MicroMsg.IabHelper";
            com.tencent.mm.sdk.platformtools.w.d(r4, r1);	 Catch:{ RemoteException -> 0x0067 }
            r1 = new com.tencent.mm.plugin.gwallet.a.a;	 Catch:{ RemoteException -> 0x0067 }
            r4 = new java.lang.StringBuilder;	 Catch:{ RemoteException -> 0x0067 }
            r5 = "Error consuming token ";
            r4.<init>(r5);	 Catch:{ RemoteException -> 0x0067 }
            r4 = r4.append(r0);	 Catch:{ RemoteException -> 0x0067 }
            r4 = r4.toString();	 Catch:{ RemoteException -> 0x0067 }
            r1.<init>(r3, r4);	 Catch:{ RemoteException -> 0x0067 }
            throw r1;	 Catch:{ RemoteException -> 0x0067 }
        L_0x00b1:
            r0 = r6.mKI;
            if (r0 == 0) goto L_0x00c7;
        L_0x00b5:
            r0 = new com.tencent.mm.plugin.gwallet.a.c;
            r2 = "";
            r0.<init>(r1, r2);
            r1 = r6.jWW;
            r2 = new com.tencent.mm.plugin.gwallet.a.b$2$1;
            r2.<init>(r6, r0);
            r1.post(r2);
        L_0x00c7:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gwallet.a.b.2.run():void");
        }
    }

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ ae jWW;
        final /* synthetic */ b mKG;
        final /* synthetic */ String mKL;
        final /* synthetic */ b mKM;

        public AnonymousClass3(b bVar, String str, ae aeVar, b bVar2) {
            this.mKG = bVar;
            this.mKL = str;
            this.jWW = aeVar;
            this.mKM = bVar2;
        }

        public final void run() {
            c cVar = new c(0, "Inventory refresh successful.");
            final Intent intent = new Intent();
            try {
                int e = this.mKG.e(intent, this.mKL);
                if (e != 0) {
                    cVar = new c(e, "Error refreshing inventory (querying owned items).");
                }
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.IabHelper", e2, "", new Object[0]);
                cVar = new c(-1001, "Remote exception while refreshing inventory.");
            } catch (Throwable e22) {
                w.printErrStackTrace("MicroMsg.IabHelper", e22, "", new Object[0]);
                cVar = new c(-1002, "Error parsing JSON response while refreshing inventory.");
            }
            intent.putExtra("RESPONSE_CODE", cVar.mKQ);
            this.jWW.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass3 mKP;

                public final void run() {
                    this.mKP.mKM.b(cVar, intent);
                }
            });
        }
    }

    public interface a {
        void a(c cVar);
    }

    public interface b {
        void b(c cVar, Intent intent);
    }

    public interface c {
        void a(c cVar, Intent intent);
    }

    public b(Context context) {
        this.mContext = context;
    }

    public final void a(final a aVar) {
        if (this.mKA) {
            throw new IllegalStateException("IAB helper is already set up.");
        }
        w.d("MicroMsg.IabHelper", "Starting in-app billing setup.");
        this.mKz = new ServiceConnection(this) {
            final /* synthetic */ b mKG;

            public final void onServiceDisconnected(ComponentName componentName) {
                w.d("MicroMsg.IabHelper", "Billing service disconnected.");
                this.mKG.mKy = null;
            }

            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                w.d("MicroMsg.IabHelper", "Billing service connected.");
                this.mKG.mKy = com.a.a.a.a.a.c(iBinder);
                String packageName = this.mKG.mContext.getPackageName();
                try {
                    w.d("MicroMsg.IabHelper", "Checking for in-app billing 3 support.");
                    int b = this.mKG.mKy.b(3, packageName, "inapp");
                    if (b != 0) {
                        if (aVar != null) {
                            aVar.a(new c(b, "Error checking for billing v3 support."));
                        }
                        this.mKG.mKB = false;
                        return;
                    }
                    w.d("MicroMsg.IabHelper", "In-app billing version 3 supported for " + packageName);
                    int b2 = this.mKG.mKy.b(3, packageName, "subs");
                    if (b2 == 0) {
                        w.d("MicroMsg.IabHelper", "Subscriptions AVAILABLE.");
                        this.mKG.mKB = true;
                    } else {
                        w.d("MicroMsg.IabHelper", "Subscriptions NOT AVAILABLE. Response: " + b2);
                    }
                    this.mKG.mKA = true;
                    if (aVar != null) {
                        aVar.a(new c(0, "Setup successful."));
                    }
                } catch (Throwable e) {
                    if (aVar != null) {
                        aVar.a(new c(-1001, "RemoteException while setting up in-app billing."));
                    }
                    w.printErrStackTrace("MicroMsg.IabHelper", e, "", new Object[0]);
                }
            }
        };
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        if (this.mContext == null || this.mContext.getPackageManager() == null || this.mContext.getPackageManager().queryIntentServices(intent, 0) == null || this.mContext.getPackageManager().queryIntentServices(intent, 0).isEmpty()) {
            aVar.a(new c(-2001, "Google play not installed!"));
        } else {
            this.mContext.bindService(intent, this.mKz, 1);
        }
    }

    public final void dispose() {
        w.d("MicroMsg.IabHelper", "Disposing.");
        this.mKA = false;
        if (this.mKz != null) {
            w.d("MicroMsg.IabHelper", "Unbinding from service.");
            try {
                if (this.mContext != null) {
                    this.mContext.unbindService(this.mKz);
                }
            } catch (IllegalArgumentException e) {
                w.e("MicroMsg.IabHelper", e.toString());
            }
            this.mKz = null;
            this.mKy = null;
        }
    }

    public final void yk(String str) {
        if (!this.mKA) {
            w.e("MicroMsg.IabHelper", "Illegal state for operation (" + str + "): IAB helper is not set up.");
            throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + str);
        }
    }

    public final boolean a(ArrayList<String> arrayList, c cVar) {
        yk("query details");
        Intent intent = new Intent();
        if (arrayList == null || arrayList.size() == 0) {
            w.e("MicroMsg.IabHelper", "query list is empty!");
            c cVar2 = new c(5, "no query list or is empty");
            intent.putExtra("RESPONSE_CODE", 5);
            intent.putExtra("QUERY_DETAIL_INFO", new ArrayList());
            cVar.a(cVar2, intent);
            return true;
        }
        try {
            w.d("MicroMsg.IabHelper", "query detail list with the size is " + arrayList.size());
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
            bundle = this.mKy.a(3, this.mContext.getPackageName(), "inapp", bundle);
            int z = z(bundle);
            w.d("MicroMsg.IabHelper", "detail response: " + String.valueOf(z));
            if (z != 0) {
                w.d("MicroMsg.IabHelper", "cannot query details");
                cVar2 = new c(z, "cannot query details");
                intent.putExtra("RESPONSE_CODE", z);
                cVar.a(cVar2, intent);
                return true;
            }
            c cVar3 = new c(z, "query list ok!");
            w.d("MicroMsg.IabHelper", "result code : " + z);
            intent.putExtra("RESPONSE_CODE", z);
            intent.putExtra("RESPONSE_QUERY_DETAIL_INFO", bundle.getStringArrayList("DETAILS_LIST"));
            cVar.a(cVar3, intent);
            Iterator it = bundle.getStringArrayList("DETAILS_LIST").iterator();
            while (it.hasNext()) {
                w.d("MicroMsg.IabHelper", (String) it.next());
            }
            return true;
        } catch (Throwable e) {
            yl("RemoteException while launching query details ");
            w.printErrStackTrace("MicroMsg.IabHelper", e, "", new Object[0]);
            cVar2 = new c(-1001, "Remote exception while starting purchase flow");
            intent.putExtra("RESPONSE_CODE", 6);
            intent.putExtra("QUERY_DETAIL_INFO", new ArrayList());
            cVar.a(cVar2, intent);
            return false;
        }
    }

    public final int e(Intent intent, String str) {
        w.d("MicroMsg.IabHelper", "Querying owned items, item type: " + str);
        w.d("MicroMsg.IabHelper", "Package name: " + this.mContext.getPackageName());
        String str2 = null;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        do {
            w.d("MicroMsg.IabHelper", "Calling getPurchases with continuation token: " + str2);
            Bundle a = this.mKy.a(3, this.mContext.getPackageName(), str, str2);
            int z = z(a);
            w.d("MicroMsg.IabHelper", "Owned items response: " + String.valueOf(z));
            if (z != 0) {
                w.d("MicroMsg.IabHelper", "getPurchases() failed: " + z);
                return z;
            } else if (a.containsKey("INAPP_PURCHASE_ITEM_LIST") && a.containsKey("INAPP_PURCHASE_DATA_LIST") && a.containsKey("INAPP_DATA_SIGNATURE_LIST")) {
                arrayList.addAll(a.getStringArrayList("INAPP_PURCHASE_ITEM_LIST"));
                arrayList2.addAll(a.getStringArrayList("INAPP_PURCHASE_DATA_LIST"));
                arrayList3.addAll(a.getStringArrayList("INAPP_DATA_SIGNATURE_LIST"));
                str2 = a.getString("INAPP_CONTINUATION_TOKEN");
                w.d("MicroMsg.IabHelper", "Continuation token: " + str2);
            } else {
                yl("Bundle returned from getPurchases() doesn't contain required fields.");
                return -1002;
            }
        } while (!TextUtils.isEmpty(str2));
        intent.putStringArrayListExtra("INAPP_PURCHASE_ITEM_LIST", arrayList);
        intent.putStringArrayListExtra("INAPP_PURCHASE_DATA_LIST", arrayList2);
        intent.putStringArrayListExtra("INAPP_DATA_SIGNATURE_LIST", arrayList3);
        return 0;
    }

    public static String nV(int i) {
        String[] split = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] split2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error/-1009:Subscriptions not available/-1010:Invalid consumption attempt".split("/");
        if (i <= DownloadResult.CODE_UNDEFINED) {
            int i2 = -1000 - i;
            if (i2 < 0 || i2 >= split2.length) {
                return String.valueOf(i) + ":Unknown IAB Helper Error";
            }
            return split2[i2];
        } else if (i < 0 || i >= split.length) {
            return String.valueOf(i) + ":Unknown";
        } else {
            return split[i];
        }
    }

    public static int z(Bundle bundle) {
        Object obj = bundle.get("RESPONSE_CODE");
        if (obj == null) {
            w.d("MicroMsg.IabHelper", "Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            yl("Unexpected type for bundle response code.");
            yl(obj.getClass().getName());
            throw new RuntimeException("Unexpected type for bundle response code: " + obj.getClass().getName());
        }
    }

    public static void yl(String str) {
        w.e("MicroMsg.IabHelper", "In-app billing error: " + str);
    }
}
