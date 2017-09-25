package com.tencent.mm.plugin.offline.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Vibrator;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.e.a.rz;
import com.tencent.mm.plugin.offline.a.r;
import com.tencent.mm.plugin.offline.a.r.g;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.plugin.wallet_core.ui.l;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;

public final class c {
    Vibrator jYD;
    public a odC;
    l odD;
    float odE = 0.0f;
    int odF = 20000;
    public Activity qb;

    class AnonymousClass11 implements OnClickListener {
        final /* synthetic */ c odH;
        final /* synthetic */ g odI;

        AnonymousClass11(c cVar, g gVar) {
            this.odH = cVar;
            this.odI = gVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            if (this.odH.odC != null) {
                this.odH.odC.m(1, this.odI.id, "");
            }
            w.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do pay");
        }
    }

    class AnonymousClass12 implements OnClickListener {
        final /* synthetic */ c odH;
        final /* synthetic */ g odI;

        AnonymousClass12(c cVar, g gVar) {
            this.odH = cVar;
            this.odI = gVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
            if (this.odH.odC != null) {
                this.odH.odC.m(0, this.odI.id, "");
            }
            com.tencent.mm.plugin.offline.g.bu(this.odI.fLT, com.tencent.mm.plugin.offline.g.obE);
            w.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do cancel pay");
        }
    }

    class AnonymousClass1 extends com.tencent.mm.sdk.b.c<rz> {
        final /* synthetic */ PayInfo odG;
        final /* synthetic */ c odH;

        AnonymousClass1(c cVar, PayInfo payInfo) {
            this.odH = cVar;
            this.odG = payInfo;
            this.usg = rz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            rz rzVar = (rz) bVar;
            a.urY.c(this);
            if (rzVar.fZv.result == 0) {
                ap.vd().a(new com.tencent.mm.plugin.offline.a.c(this.odG.fJH), 0);
                com.tencent.mm.plugin.offline.g.aQa();
                this.odH.odC.aQp();
            } else if (rzVar.fZv.result == -1) {
                com.tencent.mm.plugin.offline.g.aQa();
                this.odH.odC.aQp();
            }
            return false;
        }
    }

    class AnonymousClass13 implements com.tencent.mm.plugin.wallet_core.ui.l.c {
        final /* synthetic */ c odH;
        final /* synthetic */ g odI;

        AnonymousClass13(c cVar, g gVar) {
            this.odH = cVar;
            this.odI = gVar;
        }

        public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
            if (this.odH.qb instanceof MMActivity) {
                ((MMActivity) this.odH.qb).aHf();
            }
            if (this.odH.odC != null) {
                this.odH.odC.m(1, this.odI.id, str);
            }
            w.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do pay");
        }
    }

    class AnonymousClass15 implements l.a {
        final /* synthetic */ c odH;
        final /* synthetic */ g odI;

        AnonymousClass15(c cVar, g gVar) {
            this.odH = cVar;
            this.odI = gVar;
        }

        public final void aQt() {
            if (this.odH.odC != null) {
                this.odH.odC.m(0, this.odI.id, "");
            }
            com.tencent.mm.plugin.offline.g.bu(this.odI.fLT, com.tencent.mm.plugin.offline.g.obE);
            w.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do cancel pay");
        }
    }

    public c(Activity activity, a aVar) {
        this.qb = activity;
        this.odC = aVar;
    }

    public final void a(k kVar, int i, String str) {
        a(kVar, i, str, null);
    }

    public final void a(k kVar, int i, String str, String str2) {
        w.i("MicroMsg.OfflineLogicMgr", "handleErrorEvent errCode :" + i + " msg:" + str);
        aQq();
        if (i == 409) {
            w.i("MicroMsg.OfflineLogicMgr", "goLimitChangeUI msg:" + str);
            com.tencent.mm.ui.base.g.a(this.qb, str, "", getString(R.l.flo), getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ c odH;

                {
                    this.odH = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    e.Q(this.odH.qb, 0);
                    w.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
                }
            }, new OnClickListener(this) {
                final /* synthetic */ c odH;

                {
                    this.odH = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        } else if (i == 410) {
            w.i("MicroMsg.OfflineLogicMgr", "showBindNewBankcardDialog msg:" + str);
            com.tencent.mm.ui.base.g.a(this.qb, str, "", getString(R.l.fie), getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ c odH;

                {
                    this.odH = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    e.Q(this.odH.qb, 0);
                    w.i("MicroMsg.OfflineLogicMgr", "do startBindBankcard");
                }
            }, new OnClickListener(this) {
                final /* synthetic */ c odH;

                {
                    this.odH = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        } else if (i == 413) {
            w.i("MicroMsg.OfflineLogicMgr", "goChangeBankcard msg:" + str);
            com.tencent.mm.ui.base.g.a(this.qb, str, "", getString(R.l.fkX), getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ c odH;

                {
                    this.odH = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.odH.odC.aQm();
                    w.i("MicroMsg.OfflineLogicMgr", "do changeBankcard");
                }
            }, new OnClickListener(this) {
                final /* synthetic */ c odH;

                {
                    this.odH = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        } else if (i == 411) {
            if (m.btS().buj() || m.btS().bun()) {
                w.i("MicroMsg.OfflineLogicMgr", "is unreg or simplereg");
                return;
            }
            if (com.tencent.mm.plugin.offline.k.oci && (this.qb instanceof WalletOfflineCoinPurseUI)) {
                WalletOfflineCoinPurseUI walletOfflineCoinPurseUI = (WalletOfflineCoinPurseUI) this.qb;
                walletOfflineCoinPurseUI.oeb.setVisibility(4);
                walletOfflineCoinPurseUI.oeo.a(walletOfflineCoinPurseUI.odT, new View.OnClickListener(walletOfflineCoinPurseUI) {
                    final /* synthetic */ WalletOfflineCoinPurseUI oez;

                    {
                        this.oez = r1;
                    }

                    public final void onClick(View view) {
                        com.tencent.mm.plugin.offline.c.a.aQW();
                        com.tencent.mm.plugin.offline.c.a.L(this.oez);
                        this.oez.finish();
                    }
                }, 6);
            } else {
                com.tencent.mm.plugin.offline.c.a.b(this.qb, str);
            }
            com.tencent.mm.plugin.report.service.g.oUh.a(135, 1, 1, true);
        } else if (!(this.qb instanceof WalletBaseUI)) {
            b.a(this.qb, str);
        } else if (!com.tencent.mm.wallet_core.d.e.a((WalletBaseUI) this.qb, kVar, 1000, i, str)) {
            String string;
            Context context = this.qb;
            if (TextUtils.isEmpty(str)) {
                string = context.getString(R.l.fkA);
            } else {
                string = str;
            }
            if (bg.mA(str2)) {
                b.a(context, string);
                return;
            }
            w.i("MicroMsg.OfflineErrorHelper", "error_detail_url is not null ");
            com.tencent.mm.ui.base.g.a(context, string, null, context.getResources().getString(R.l.ffz), context.getResources().getString(R.l.dHT), true, new com.tencent.mm.plugin.offline.ui.b.AnonymousClass2(str2, context), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.OfflineLogicMgr", "errType:" + i + "  errCode" + i2 + " errMsg:" + str + " cgi type:" + kVar.getType());
        com.tencent.mm.plugin.offline.a.e eVar;
        if (i == 0 && i2 == 0) {
            if (!(kVar instanceof com.tencent.mm.plugin.offline.a.e)) {
                return false;
            }
            eVar = (com.tencent.mm.plugin.offline.a.e) kVar;
            String str2 = eVar.ocu;
            aQq();
            if (eVar.ocv != 0 || TextUtils.isEmpty(str2)) {
                if (!(eVar.ocv == 0 || eVar.kAC == 0 || eVar.ocx != 1)) {
                    w.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
                    a(eVar, eVar.ocv, eVar.ocw);
                }
                return true;
            }
            com.tencent.mm.plugin.offline.c.a.a(this.qb, str2, kVar);
            this.qb.finish();
            return true;
        } else if (!(kVar instanceof com.tencent.mm.plugin.offline.a.e)) {
            return false;
        } else {
            eVar = (com.tencent.mm.plugin.offline.a.e) kVar;
            aQq();
            if (eVar.ocx == 1) {
                w.i("MicroMsg.OfflineLogicMgr", "input pwd, but respon exist error!");
                a(kVar, i2, str);
            }
            return true;
        }
    }

    public final void aQq() {
        if (this.odD != null) {
            this.odD.dismiss();
            this.odD = null;
        }
    }

    public final void a(r.b bVar) {
        if (bVar != null) {
            w.i("MicroMsg.OfflineLogicMgr", "showFreeMsg");
            if ("1".equals(bVar.ode)) {
                com.tencent.mm.ui.base.g.a(this.qb, false, bVar.odg, "", getString(R.l.fli), getString(R.l.dGs), new OnClickListener(this) {
                    final /* synthetic */ c odH;

                    {
                        this.odH = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        com.tencent.mm.plugin.offline.c.a.K(this.odH.qb);
                        w.i("MicroMsg.OfflineLogicMgr", "doFreezeOffline");
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ c odH;

                    {
                        this.odH = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.odH.qb.finish();
                    }
                });
            }
        }
    }

    public static boolean aQr() {
        com.tencent.mm.plugin.offline.k.aQd();
        if (com.tencent.mm.plugin.offline.k.aQe().odb != null) {
            return true;
        }
        return false;
    }

    final String getString(int i) {
        return this.qb.getString(i);
    }

    public final void aQs() {
        w.i("MicroMsg.OfflineLogicMgr", "closeOffline");
        if (this.odC != null) {
            this.odC.aQn();
        }
    }
}
