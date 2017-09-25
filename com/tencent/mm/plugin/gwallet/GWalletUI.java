package com.tencent.mm.plugin.gwallet;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.jg.JgMethodChecked;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.plugin.gwallet.a.b.2;
import com.tencent.mm.plugin.gwallet.a.b.3;
import com.tencent.mm.plugin.gwallet.a.b.a;
import com.tencent.mm.plugin.gwallet.a.b.b;
import com.tencent.mm.plugin.gwallet.a.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

@JgClassChecked(author = 31, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.ACTIVITYCHECK, EType.RECEIVERCHECK})
public class GWalletUI extends Activity {
    BroadcastReceiver iRM = new BroadcastReceiver(this) {
        final /* synthetic */ GWalletUI mKt;

        {
            this.mKt = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if ("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST".equals(intent.getAction())) {
                List stringArrayListExtra = intent.getStringArrayListExtra("tokens");
                final boolean booleanExtra = intent.getBooleanExtra("IS_FAILED_CONSUME", false);
                if (stringArrayListExtra == null || stringArrayListExtra.size() == 0) {
                    GWalletUI.a(this.mKt, 0, null);
                } else {
                    e.post(new 2(this.mKt.mKl, stringArrayListExtra, new b(this) {
                        final /* synthetic */ AnonymousClass3 mKv;

                        public final void b(c cVar, Intent intent) {
                            w.d("MicroMsg.GWalletUI", "Purchase finished: " + cVar + ", purchase: " + intent);
                            Intent intent2 = new Intent("com.tencent.mm.gwallet.ACTION_CONSUME_RESPONSE");
                            if (booleanExtra) {
                                intent2.putExtra("RESPONSE_CODE", -3000);
                            } else {
                                intent2.putExtra("RESPONSE_CODE", 0);
                            }
                            GWalletUI.a(this.mKv.mKt, -1, intent2);
                        }
                    }, new ae()), "IabHelper_consumeAsync");
                }
            }
        }
    };
    private com.tencent.mm.plugin.gwallet.a.b mKl = null;

    static /* synthetic */ void a(GWalletUI gWalletUI) {
        Intent intent = gWalletUI.getIntent();
        String stringExtra = intent.getStringExtra("product_id");
        String stringExtra2 = intent.getStringExtra("developer_pay_load");
        com.tencent.mm.plugin.gwallet.a.b bVar = gWalletUI.mKl;
        String str = "inapp";
        b anonymousClass2 = new b(gWalletUI) {
            final /* synthetic */ GWalletUI mKt;

            {
                this.mKt = r1;
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            @com.jg.JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {com.jg.EType.INTENTCHECK})
            public final void b(com.tencent.mm.plugin.gwallet.a.c r6, android.content.Intent r7) {
                /*
                r5 = this;
                r0 = 1;
                r1 = 0;
                r2 = "MicroMsg.GWalletUI";
                r3 = new java.lang.StringBuilder;
                r4 = "Purchase finished: ";
                r3.<init>(r4);
                r3 = r3.append(r6);
                r4 = ", purchase: ";
                r3 = r3.append(r4);
                r3 = r3.append(r7);
                r3 = r3.toString();
                com.tencent.mm.sdk.platformtools.w.d(r2, r3);
                if (r7 != 0) goto L_0x0051;
            L_0x0025:
                r7 = new android.content.Intent;
                r2 = "com.tencent.mm.gwallet.ACTION_PAY_RESPONSE";
                r7.<init>(r2);
                r2 = "RESPONSE_CODE";
                r3 = r6.mKQ;
                r7.putExtra(r2, r3);
            L_0x0035:
                r2 = r5.mKt;
                r2.sendBroadcast(r7);
                r2 = r6.isSuccess();
                if (r2 != 0) goto L_0x005a;
            L_0x0040:
                r2 = r6.mKQ;
                r3 = 7;
                if (r2 != r3) goto L_0x0058;
            L_0x0045:
                r2 = r0;
            L_0x0046:
                if (r2 != 0) goto L_0x005a;
            L_0x0048:
                if (r0 == 0) goto L_0x0050;
            L_0x004a:
                r0 = r5.mKt;
                r2 = 0;
                com.tencent.mm.plugin.gwallet.GWalletUI.a(r0, r1, r2);
            L_0x0050:
                return;
            L_0x0051:
                r2 = "com.tencent.mm.gwallet.ACTION_PAY_RESPONSE";
                r7.setAction(r2);
                goto L_0x0035;
            L_0x0058:
                r2 = r1;
                goto L_0x0046;
            L_0x005a:
                r0 = r1;
                goto L_0x0048;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gwallet.GWalletUI.2.b(com.tencent.mm.plugin.gwallet.a.c, android.content.Intent):void");
            }
        };
        bVar.yk("launchPurchaseFlow");
        if (!str.equals("subs") || bVar.mKB) {
            try {
                w.d("MicroMsg.IabHelper", "Constructing buy intent for " + stringExtra + ", item type: " + str + ", extraData: " + stringExtra2);
                Bundle a = bVar.mKy.a(3, bVar.mContext.getPackageName(), stringExtra, str, stringExtra2);
                int z = com.tencent.mm.plugin.gwallet.a.b.z(a);
                if (z != 0) {
                    anonymousClass2.b(new c(z, "Unable to buy item"), null);
                    return;
                }
                PendingIntent pendingIntent = (PendingIntent) a.getParcelable("BUY_INTENT");
                w.d("MicroMsg.IabHelper", "Launching buy intent for " + stringExtra + ". Request code: 10001");
                bVar.mKC = CdnLogic.MediaType_FAVORITE_FILE;
                bVar.mKD = anonymousClass2;
                bVar.mKE = str;
                gWalletUI.startIntentSenderForResult(pendingIntent.getIntentSender(), CdnLogic.MediaType_FAVORITE_FILE, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
                return;
            } catch (Throwable e) {
                com.tencent.mm.plugin.gwallet.a.b.yl("SendIntentException while launching purchase flow for sku " + stringExtra);
                w.printErrStackTrace("MicroMsg.IabHelper", e, "", new Object[0]);
                anonymousClass2.b(new c(-1004, "Failed to send intent."), null);
                return;
            } catch (Throwable e2) {
                com.tencent.mm.plugin.gwallet.a.b.yl("RemoteException while launching purchase flow for sku " + stringExtra);
                w.printErrStackTrace("MicroMsg.IabHelper", e2, "", new Object[0]);
                anonymousClass2.b(new c(-1001, "Remote exception while starting purchase flow"), null);
                return;
            }
        }
        anonymousClass2.b(new c(-1009, "Subscriptions are not available."), null);
    }

    static /* synthetic */ void a(GWalletUI gWalletUI, int i, Intent intent) {
        w.d("MicroMsg.GWalletUI", "Finish GWallet. setResult:" + i);
        gWalletUI.setResult(i, intent);
        gWalletUI.finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        w.d("MicroMsg.GWalletUI", "Creating IAB helper.");
        this.mKl = new com.tencent.mm.plugin.gwallet.a.b(this);
        w.d("MicroMsg.GWalletUI", "Starting setup.");
        this.mKl.a(new a(this) {
            final /* synthetic */ GWalletUI mKt;

            {
                this.mKt = r1;
            }

            public final void a(c cVar) {
                w.d("MicroMsg.GWalletUI", "Setup finished.");
                if (cVar.isSuccess()) {
                    if ("com.tencent.mm.gwallet.ACTION_PAY_REQUEST".equals(this.mKt.getIntent().getAction())) {
                        GWalletUI.a(this.mKt);
                        return;
                    } else {
                        this.mKt.eM(this.mKt.getIntent().getBooleanExtra("is_direct", true));
                        return;
                    }
                }
                w.e("MicroMsg.GWalletUI", "Problem setting up in-app billing: " + cVar);
                Intent intent = new Intent();
                intent.putExtra("RESPONSE_CODE", cVar.mKQ);
                GWalletUI.a(this.mKt, -1, intent);
            }
        });
    }

    public final void eM(final boolean z) {
        com.tencent.mm.plugin.gwallet.a.b bVar = this.mKl;
        b anonymousClass4 = new b(this) {
            final /* synthetic */ GWalletUI mKt;

            @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
            public final void b(c cVar, Intent intent) {
                w.d("MicroMsg.GWalletUI", "Query inventory finished. data : " + intent);
                if (intent == null) {
                    intent = new Intent("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
                    intent.putExtra("RESPONSE_CODE", cVar.mKQ);
                } else {
                    intent.setAction("com.tencent.mm.gwallet.ACTION_QUERY_RESPONSE");
                }
                if (!z) {
                    intent.putExtra("is_direct", false);
                }
                this.mKt.sendBroadcast(intent);
            }
        };
        ae aeVar = new ae();
        bVar.yk("queryInventory");
        e.post(new 3(bVar, "inapp", aeVar, anonymousClass4), "IabHelper_queryInventoryAsync");
    }

    protected void onNewIntent(Intent intent) {
        if ("com.tencent.mm.gwallet.ACTION_QUERY_REQUEST".equals(intent.getAction())) {
            eM(intent.getBooleanExtra("is_direct", true));
        }
        super.onNewIntent(intent);
    }

    public void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.gwallet.ACTION_CONSUME_REQUEST");
        registerReceiver(this.iRM, intentFilter);
    }

    protected void onStop() {
        super.onStop();
        unregisterReceiver(this.iRM);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        com.tencent.mm.plugin.gwallet.a.b bVar = this.mKl;
        if (i == bVar.mKC) {
            bVar.yk("handleActivityResult");
            if (intent == null) {
                com.tencent.mm.plugin.gwallet.a.b.yl("Null data in IAB activity result.");
                c cVar = new c(-1002, "Null data in IAB result");
                if (bVar.mKD != null) {
                    bVar.mKD.b(cVar, null);
                    return;
                }
                return;
            }
            int i3;
            Object obj = intent.getExtras().get("RESPONSE_CODE");
            if (obj == null) {
                com.tencent.mm.plugin.gwallet.a.b.yl("Intent with no response code, assuming OK (known issue)");
                i3 = 0;
            } else if (obj instanceof Integer) {
                i3 = ((Integer) obj).intValue();
            } else if (obj instanceof Long) {
                i3 = (int) ((Long) obj).longValue();
            } else {
                com.tencent.mm.plugin.gwallet.a.b.yl("Unexpected type for intent response code.");
                com.tencent.mm.plugin.gwallet.a.b.yl(obj.getClass().getName());
                throw new RuntimeException("Unexpected type for intent response code: " + obj.getClass().getName());
            }
            String stringExtra = intent.getStringExtra("INAPP_PURCHASE_DATA");
            String stringExtra2 = intent.getStringExtra("INAPP_DATA_SIGNATURE");
            w.d("MicroMsg.IabHelper", "Purchase data: " + stringExtra);
            w.d("MicroMsg.IabHelper", "Data signature: " + stringExtra2);
            w.d("MicroMsg.IabHelper", "Extras: " + intent.getExtras());
            w.d("MicroMsg.IabHelper", "Expected item type: " + bVar.mKE);
            c cVar2 = new c(i3, "Null data in IAB result");
            if (bVar.mKD != null) {
                bVar.mKD.b(cVar2, intent);
            }
        }
    }

    protected void onDestroy() {
        w.d("MicroMsg.GWalletUI", "Destroying helper.");
        if (this.mKl != null) {
            this.mKl.dispose();
        }
        this.mKl = null;
        super.onDestroy();
    }
}
