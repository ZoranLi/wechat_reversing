package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.f.a.i;
import com.tencent.mm.wallet_core.f.a.l;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;

public final class e {
    public static boolean a(final WalletBaseUI walletBaseUI, k kVar, int i, final int i2, String str) {
        boolean z = false;
        if (i != 1000) {
            return false;
        }
        String string;
        if (bg.mA(str)) {
            string = walletBaseUI.getString(R.l.fkA);
        } else {
            string = str;
        }
        b ai = a.ai(walletBaseUI);
        switch (i2) {
            case -100869:
                g.a(walletBaseUI, walletBaseUI.getString(R.l.ffD), null, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        a.c(walletBaseUI, walletBaseUI.uT, i2);
                        if (walletBaseUI.aIY()) {
                            walletBaseUI.finish();
                        }
                    }
                });
                return true;
            case -100868:
                g.a(walletBaseUI, walletBaseUI.getString(R.l.ffE), null, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        a.c(walletBaseUI, walletBaseUI.uT, i2);
                        if (walletBaseUI.aIY()) {
                            walletBaseUI.finish();
                        }
                    }
                });
                return true;
            case 401:
                int i3;
                if (kVar instanceof i) {
                    i3 = ((i) kVar).rGn;
                } else {
                    i3 = 0;
                }
                if (i3 == 1) {
                    g.a(walletBaseUI, string, "", walletBaseUI.getString(R.l.ffN), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (walletBaseUI.aIY()) {
                                walletBaseUI.finish();
                            }
                        }
                    });
                } else {
                    g.a(walletBaseUI, false, string, "", walletBaseUI.getString(R.l.ffO), walletBaseUI.getString(R.l.dIw), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (m.xY()) {
                                a.b(walletBaseUI, "PayUForgotPwdProcess", null);
                            } else {
                                a.b(walletBaseUI, "ForgotPwdProcess", null);
                            }
                            if (walletBaseUI.aIY()) {
                                walletBaseUI.finish();
                            }
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            walletBaseUI.qU(1);
                        }
                    });
                }
                return true;
            case 402:
            case 403:
            case 408:
                if (ai != null) {
                    return ai.a(walletBaseUI, i2, string);
                }
                return false;
            case TencentLocation.ERROR_UNKNOWN /*404*/:
                if (ai != null) {
                    return ai.a(walletBaseUI, i2, string);
                }
                return false;
            case 405:
                if (kVar instanceof i) {
                    z = ((i) kVar).rGn;
                }
                if (z) {
                    g.a(walletBaseUI, string, "", walletBaseUI.getString(R.l.ffN), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (walletBaseUI.aIY()) {
                                walletBaseUI.finish();
                            }
                        }
                    });
                } else {
                    g.a(walletBaseUI, string, "", walletBaseUI.getString(R.l.fjT), walletBaseUI.getString(R.l.dGs), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            walletBaseUI.lX(true);
                        }
                    }, null);
                }
                return true;
            case 407:
                ccr();
                if (m.xY()) {
                    b(walletBaseUI, i2, string);
                } else {
                    g.a(walletBaseUI, string, null, false, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            a.c(walletBaseUI, null, i2);
                            if (walletBaseUI.aIY()) {
                                walletBaseUI.finish();
                            }
                        }
                    });
                }
                return true;
            case 412:
                g.a(walletBaseUI, string, "", walletBaseUI.getString(R.l.fkQ), walletBaseUI.getString(R.l.dGs), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("key_is_bind_bankcard", false);
                        a.a(walletBaseUI, "BindCardProcess", bundle, new b.a(this) {
                            final /* synthetic */ AnonymousClass9 wEy;

                            {
                                this.wEy = r1;
                            }

                            public final Intent j(int i, Bundle bundle) {
                                return null;
                            }
                        });
                    }
                }, null);
                return true;
            case 414:
                ccr();
                b(walletBaseUI, i2, string);
                return true;
            default:
                return false;
        }
    }

    private static void ccr() {
        k bVar;
        if (m.xY()) {
            bVar = new com.tencent.mm.wallet_core.e.a.b();
        } else {
            bVar = new l();
        }
        ap.vd().a(bVar, 0);
    }

    private static void b(final WalletBaseUI walletBaseUI, final int i, String str) {
        g.a(walletBaseUI, false, str, "", walletBaseUI.getString(R.l.ffC), walletBaseUI.getString(R.l.dGs), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "https://www.payu.co.za/wechat/contact-us/");
                d.b(walletBaseUI, "webview", ".ui.tools.WebViewUI", intent);
                if (walletBaseUI.aIY() || walletBaseUI.uSU.ipu.getVisibility() != 0) {
                    walletBaseUI.finish();
                }
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                a.c(walletBaseUI, walletBaseUI.uT, i);
                if (walletBaseUI.aIY() || walletBaseUI.uSU.ipu.getVisibility() != 0) {
                    walletBaseUI.finish();
                }
            }
        });
    }
}
