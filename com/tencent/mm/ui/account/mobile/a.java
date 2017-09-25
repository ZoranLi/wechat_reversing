package com.tencent.mm.ui.account.mobile;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bb;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.k;

public final class a {
    private String fWY;
    private String hSs = "";
    boolean uZk = false;
    private String username = "";
    private String vcW = "";
    private a vcX;

    public interface a {
        void a(ProgressDialog progressDialog);
    }

    public a(a aVar, String str, String str2, String str3) {
        this.username = str;
        this.hSs = str3;
        this.vcW = str2;
        this.vcX = aVar;
    }

    public final void h(MMActivity mMActivity) {
        final k uVar = new u(this.username, this.vcW, 0, "", "", "", 0, "", false, true);
        ap.vd().a(uVar, 0);
        a aVar = this.vcX;
        mMActivity.getString(R.l.dIO);
        aVar.a(g.a((Context) mMActivity, mMActivity.getString(R.l.ewX), true, new OnCancelListener(this) {
            final /* synthetic */ a vcY;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(uVar);
            }
        }));
    }

    public final void a(final MMActivity mMActivity, int i, int i2, String str, k kVar) {
        if (i == 4 && (i2 == -16 || i2 == -17)) {
            ap.vd().a(new bb(new com.tencent.mm.u.bb.a(this) {
                final /* synthetic */ a vcY;

                {
                    this.vcY = r1;
                }

                public final void a(e eVar) {
                    if (eVar != null) {
                        c Cc = eVar.Cc();
                        byte[] bArr = new byte[0];
                        ap.yY();
                        Cc.i(bArr, com.tencent.mm.u.c.uH());
                    }
                }
            }), 0);
            int i3 = 1;
        } else {
            boolean z = false;
        }
        if (kVar instanceof u) {
            this.fWY = ((u) kVar).Jh();
        }
        if (i3 != 0 || (i == 0 && i2 == 0)) {
            ap.unhold();
            d.bc(mMActivity);
            m.mv(this.hSs);
            m.a(mMActivity, new Runnable(this) {
                final /* synthetic */ a vcY;

                public final void run() {
                    Intent ak = com.tencent.mm.plugin.c.a.imv.ak(mMActivity);
                    ak.addFlags(67108864);
                    mMActivity.startActivity(ak);
                    mMActivity.finish();
                }
            }, false, 2);
            if (this.uZk) {
                String string = ab.getContext().getSharedPreferences("randomid_prefs", 4).getString("randomID", "");
                com.tencent.mm.plugin.report.service.g.oUh.i(11930, string, Integer.valueOf(4));
            }
        } else if (i2 == -106) {
            m.E(mMActivity, str);
        } else if (i2 == -217) {
            m.a(mMActivity, com.tencent.mm.pluginsdk.a.a.a((u) kVar), i2);
        } else {
            int i4;
            if (com.tencent.mm.plugin.c.a.imw.a((Context) mMActivity, i, i2, str)) {
                i4 = 1;
            } else {
                if (i == 4) {
                    switch (i2) {
                        case -140:
                            if (!bg.mA(this.fWY)) {
                                m.j(mMActivity, str, this.fWY);
                            }
                            i4 = 1;
                            break;
                        case -100:
                            ap.hold();
                            g.a((Context) mMActivity, TextUtils.isEmpty(ap.uI()) ? com.tencent.mm.bg.a.V(mMActivity, R.l.ezi) : ap.uI(), mMActivity.getString(R.l.dIO), new OnClickListener(this) {
                                final /* synthetic */ a vcY;

                                {
                                    this.vcY = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            }, new OnCancelListener(this) {
                                final /* synthetic */ a vcY;

                                {
                                    this.vcY = r1;
                                }

                                public final void onCancel(DialogInterface dialogInterface) {
                                }
                            });
                            i4 = 1;
                            break;
                        case -75:
                            g.h(mMActivity, R.l.dDe, R.l.dIO);
                            i4 = 1;
                            break;
                        case -72:
                            g.h(mMActivity, R.l.eJZ, R.l.dIO);
                            i4 = 1;
                            break;
                        case -9:
                            g.h(mMActivity, R.l.ewM, R.l.ewN);
                            i4 = 1;
                            break;
                        case -1:
                            if (ap.vd().BR() == 5) {
                                g.h(mMActivity, R.l.eDp, R.l.eDo);
                                i4 = 1;
                                break;
                            }
                        case -4:
                        case -3:
                            g.h(mMActivity, R.l.efc, R.l.ewN);
                            i4 = 1;
                            break;
                    }
                }
                boolean z2 = false;
            }
            if (i4 == 0) {
                Toast.makeText(mMActivity, mMActivity.getString(R.l.elh, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            }
        }
    }
}
