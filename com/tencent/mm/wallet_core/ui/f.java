package com.tencent.mm.wallet_core.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c.g;
import com.tencent.mm.wallet_core.d.e;
import com.tencent.mm.wallet_core.e.a.b;
import com.tencent.mm.wallet_core.f.a.l;
import com.tencent.mm.y.k;

public final class f {
    private static int laH = 0;
    private static String laI = null;
    private static int lav = 0;

    public static void a(final WalletBaseUI walletBaseUI, int i, int i2, String str, k kVar, boolean z) {
        boolean aQj;
        boolean z2;
        boolean z3 = true;
        if (bg.mA(str)) {
            str = walletBaseUI.getString(R.l.fkA);
        }
        if (kVar instanceof g) {
            aQj = ((g) kVar).aQj();
        } else {
            aQj = true;
        }
        if (kVar instanceof com.tencent.mm.wallet_core.c.f) {
            z2 = ((com.tencent.mm.wallet_core.c.f) kVar).fVM;
        } else {
            z2 = aQj;
        }
        w.i("MicroMsg.WalletDispatcher", "dispatch errType:%d errCode %s ,errMsg: %s, isBlock %s scene: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(z2), kVar});
        if (!((kVar instanceof l) || (kVar instanceof b))) {
            if (kVar instanceof g) {
                boolean z4;
                g gVar = (g) kVar;
                if (gVar.wDY == null) {
                    z4 = false;
                } else {
                    z4 = "1".equals(gVar.wDY.trim());
                }
                if (z4) {
                    w.d("MicroMsg.WalletDispatcher", "order pay end!!!");
                    Bundle bundle = walletBaseUI.uT;
                    bundle.putInt("intent_pay_end_errcode", i2);
                    bundle.putString("intent_pay_app_url", gVar.wDZ);
                    bundle.putString("intent_wap_pay_jump_url", gVar.wEa);
                    bundle.putBoolean("intent_pay_end", true);
                    a.l(walletBaseUI, bundle);
                }
                if (z2 && e.a(walletBaseUI, kVar, i, i2, str)) {
                    aQj = false;
                } else {
                    aQj = true;
                }
                if (!aQj) {
                    w.d("MicroMsg.WalletDispatcher", "wallet base consume this response before subclass!");
                } else if ((walletBaseUI.ccE() == null || !walletBaseUI.ccF().d(i, i2, str, kVar)) && !walletBaseUI.d(i, i2, str, (g) kVar) && z2) {
                    if (i == 0 && i2 == 0) {
                        w.d("MicroMsg.WalletDispatcher", "wallet this response havn't error!");
                    } else {
                        laH = i;
                        lav = i2;
                        laI = str;
                        w.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
                    }
                }
            } else if (!walletBaseUI.d(i, i2, str, kVar) && z2) {
                if (i == 0 && i2 == 0) {
                    w.d("MicroMsg.WalletDispatcher", "wallet other scene this response havn't error!");
                } else {
                    laH = i;
                    lav = i2;
                    laI = str;
                    w.d("MicroMsg.WalletDispatcher", "wallet base consume this response in the end!");
                }
            }
        }
        if (z) {
            w.d("MicroMsg.WalletDispatcher", "scenes & forcescenes isEmpty! %s", new Object[]{Boolean.valueOf(z2)});
            if (lav != 0) {
                w.e("MicroMsg.WalletDispatcher", "showAlert! mErrCode : " + lav);
                if (kVar instanceof g) {
                    final String cbX = ((g) kVar).cbX();
                    if (!bg.mA(cbX)) {
                        w.i("MicroMsg.WalletDispatcher", "error_detail_url is not null ");
                        com.tencent.mm.ui.base.g.a(walletBaseUI.uSU.uTo, laI, null, walletBaseUI.getResources().getString(R.l.ffz), walletBaseUI.getResources().getString(R.l.dHT), true, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", cbX);
                                d.b(walletBaseUI.uSU.uTo, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                                e.CM(3);
                                f.c(walletBaseUI);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                f.c(walletBaseUI);
                            }
                        });
                        e.CM(4);
                        if (z3) {
                            w.i("MicroMsg.WalletDispatcher", "error_detail_url is null ");
                            com.tencent.mm.ui.base.g.a(walletBaseUI.uSU.uTo, laI, null, false, new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    f.c(walletBaseUI);
                                }
                            });
                        }
                    }
                }
                z3 = false;
                if (z3) {
                    w.i("MicroMsg.WalletDispatcher", "error_detail_url is null ");
                    com.tencent.mm.ui.base.g.a(walletBaseUI.uSU.uTo, laI, null, false, /* anonymous class already generated */);
                }
            } else if (!walletBaseUI.aJb()) {
                walletBaseUI.re(0);
            }
        }
    }

    public static void c(WalletBaseUI walletBaseUI) {
        if (laH == 1000) {
            switch (lav) {
                case 1:
                    if (!walletBaseUI.aJb()) {
                        walletBaseUI.re(0);
                    }
                    walletBaseUI.qU(0);
                    break;
                case 3:
                    a.c(walletBaseUI.uSU.uTo, walletBaseUI.uT, lav);
                    break;
                default:
                    if (!walletBaseUI.aIY() && walletBaseUI.ccA() == 0) {
                        walletBaseUI.qU(0);
                        break;
                    } else {
                        walletBaseUI.finish();
                        break;
                    }
                    break;
            }
        }
        a.j(walletBaseUI.uSU.uTo, lav);
        laH = 0;
        lav = 0;
        laI = null;
    }

    public static void ccC() {
        laH = 0;
        lav = 0;
        laI = null;
    }
}
