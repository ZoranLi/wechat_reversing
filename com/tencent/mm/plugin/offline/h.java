package com.tencent.mm.plugin.offline;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.e.a.rv;
import com.tencent.mm.plugin.offline.a.i;
import com.tencent.mm.plugin.offline.a.n;
import com.tencent.mm.plugin.offline.a.p;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.ui.WalletOfflineEntranceUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.d.d;
import com.tencent.mm.wallet_core.d.f;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.y.k;

public class h extends b {
    public final b c(Activity activity, Bundle bundle) {
        b(activity, WalletCheckPwdUI.class, bundle);
        return this;
    }

    public final void a(Activity activity, int i, Bundle bundle) {
        if (activity instanceof WalletCheckPwdUI) {
            J(activity);
        }
    }

    public final void c(Activity activity, int i) {
        if (activity != null) {
            activity.finish();
        }
    }

    public final void d(Activity activity, Bundle bundle) {
        J(activity);
        if (bundle != null && bundle.getBoolean("is_offline_create")) {
            a.M((WalletBaseUI) activity);
        }
    }

    public final boolean e(Activity activity, Bundle bundle) {
        return false;
    }

    public final void J(Activity activity) {
        int i = 2;
        if (activity != null) {
            int i2 = this.lHw.getInt("offline_from_scene", -1);
            if (i2 != 1) {
                if (i2 == 2) {
                    i = 1;
                } else if (i2 == 3) {
                    i = 3;
                } else if (i2 == 4) {
                    i = 6;
                } else if (i2 == 8) {
                    i = 4;
                } else {
                    i = 1;
                }
            }
            g.oUh.i(14096, new Object[]{Integer.valueOf(i)});
            Intent intent = new Intent(activity, WalletOfflineEntranceUI.class);
            intent.putExtra("key_from_scene", i2);
            intent.putExtra("is_offline_create", true);
            a(activity, WalletOfflineEntranceUI.class, intent);
            activity.finish();
        }
    }

    public final d a(MMActivity mMActivity, f fVar) {
        return mMActivity instanceof WalletCheckPwdUI ? new d(this, mMActivity, fVar) {
            final /* synthetic */ h obM;

            public final /* synthetic */ CharSequence qK(int i) {
                switch (i) {
                    case 0:
                        return this.wEw.getString(R.l.ffb);
                    case 1:
                        return this.wEw.getString(R.l.ffa);
                    default:
                        return "";
                }
            }

            public final boolean d(int i, int i2, String str, k kVar) {
                if (i == 0 && i2 == 0) {
                    if (kVar instanceof com.tencent.mm.plugin.offline.a.k) {
                        w.i("MicroMsg.OfflineProcess", "Offline is Create ");
                        aQb();
                        this.obM.lHw.putBoolean("is_offline_create", true);
                    } else if (kVar instanceof n) {
                        w.i("MicroMsg.OfflineProcess", "OfflineQueryUser is ok ");
                        f fVar = this.wEx;
                        if (fVar.ita == null || !(fVar.ita == null || fVar.ita.isShowing())) {
                            if (fVar.ita != null) {
                                fVar.ita.dismiss();
                            }
                            if (fVar.mContext == null) {
                                w.w("MicroMsg.WalletNetSceneMgr", "activity has destroyed!!!");
                            } else {
                                fVar.ita = com.tencent.mm.wallet_core.ui.g.a(fVar.mContext, false, new OnCancelListener(fVar) {
                                    final /* synthetic */ f wEA;

                                    {
                                        this.wEA = r1;
                                    }

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        this.wEA.aHT();
                                    }
                                });
                            }
                        }
                        com.tencent.mm.sdk.b.b rvVar = new rv();
                        rvVar.fYR.fYS = new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 obN;

                            {
                                this.obN = r1;
                            }

                            public final void run() {
                                w.d("MicroMsg.OfflineProcess", "tofutest do callback");
                                this.obN.obM.a(this.obN.wEw, 0, this.obN.obM.lHw);
                                this.obN.wEx.bsK();
                            }
                        };
                        com.tencent.mm.sdk.b.a.urY.m(rvVar);
                    } else if (kVar instanceof i) {
                        i iVar = (i) kVar;
                        if ("1".equals(iVar.ocE)) {
                            Activity activity = this.wEw;
                            String str2 = iVar.fOI;
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("key_authen", new Authen());
                            bundle.putString("key_pwd1", this.obM.lHw.getString("key_pwd1"));
                            bundle.putString("key_mobile", str2);
                            bundle.putInt("verify_scene", 1);
                            bundle.putInt("offline_add_fee", this.obM.lHw.getInt("offline_chg_fee", 0));
                            com.tencent.mm.wallet_core.a.a(activity, l.class, bundle);
                            this.obM.a(activity, 0, this.obM.lHw);
                        } else {
                            this.obM.lHw.putBoolean("back_to_coin_purse_ui", true);
                            aQb();
                        }
                    } else if (kVar instanceof p) {
                        a.BZ("");
                        k.aQd();
                        k.aQe().odb = null;
                        this.obM.a(this.wEw, 0, this.obM.lHw);
                    }
                    return true;
                } else if (!(kVar instanceof com.tencent.mm.plugin.offline.a.k)) {
                    return false;
                } else {
                    w.i("MicroMsg.OfflineProcess", "Offline Create is failed!");
                    com.tencent.mm.plugin.offline.a.k kVar2 = (com.tencent.mm.plugin.offline.a.k) kVar;
                    if (i2 != 410) {
                        return false;
                    }
                    final Context context = this.wEw;
                    final int i3 = kVar2.ocS;
                    com.tencent.mm.ui.base.g.a(context, str, "", context.getString(R.l.fie), context.getString(R.l.dGs), new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass1 obN;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            e.Q(context, i3);
                            this.obN.obM.a(context, 0, this.obN.obM.lHw);
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass1 obN;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.obN.obM.a(context, 0, this.obN.obM.lHw);
                        }
                    });
                    return true;
                }
            }

            public final boolean j(Object... objArr) {
                String str = (String) objArr[0];
                this.obM.lHw.putString("key_pwd1", str);
                Bankcard aQO = a.aQO();
                if (aQO == null) {
                    w.e("MicroMsg.OfflineProcess", "no support bank car for offline");
                    aQO = a.aQP();
                }
                if (aQO == null) {
                    w.e("MicroMsg.OfflineProcess", "no any bank car for offline");
                    return false;
                }
                String string = this.obM.lHw.getString("oper");
                if (!a.aQL()) {
                    w.i("MicroMsg.OfflineProcess", "Offline is not Create ");
                    this.wEx.a(new com.tencent.mm.plugin.offline.a.k(aQO, (String) objArr[0], this.obM.lHw.getInt("offline_chg_fee", 0)), true, true);
                } else if (string != null) {
                    w.i("MicroMsg.OfflineProcess", "oper == " + string);
                    if (string.equals("create")) {
                        this.wEx.a(new com.tencent.mm.plugin.offline.a.k(aQO, (String) objArr[0], this.obM.lHw.getInt("offline_chg_fee", 0)), true, true);
                    } else if (string.equals("clr")) {
                        this.wEx.a(new i(aQO, str, "clr", 0, ""), true, true);
                    } else if (string.equals("changeto")) {
                        this.wEx.a(new i(aQO, str, "changeto", this.obM.lHw.getInt("offline_chg_fee"), ""), true, true);
                    } else if (!string.equals("freeze")) {
                        return false;
                    } else {
                        this.wEx.a(new p(str), true, true);
                    }
                }
                return true;
            }

            private void aQb() {
                this.wEx.a(new n(System.currentTimeMillis(), a.oeU), false, true);
            }
        } : super.a(mMActivity, fVar);
    }

    public final String avB() {
        return "OfflineProcess";
    }
}
