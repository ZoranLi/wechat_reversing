package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;

public class AppInstallerUI extends MMBaseActivity {
    private static AppInstallerUI uqb = null;
    private String desc;
    private String fFW;
    private h oHT = null;
    private int qvw;
    private h uqa = null;
    private OnClickListener uqc = new OnClickListener(this) {
        final /* synthetic */ AppInstallerUI uqd;

        {
            this.uqd = r1;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            w.d("MicroMsg.AppInstallerUI", "getBtn (ok button) is click");
            if (this.uqd.qvw == 2) {
                i.Y(this.uqd, 3);
            }
            String DE = c.DE(this.uqd.fFW);
            w.d("MicroMsg.AppInstallerUI", DE);
            if (DE != null) {
                a.urH.ad(1, true);
                g.oUh.a(405, 72, 1, true);
                new ae().postDelayed(new Runnable(this.uqd, DE) {
                    final /* synthetic */ AppInstallerUI uqd;

                    public final void run() {
                        this.uqd.startActivity(bg.PN(r5));
                        this.uqd.finish();
                    }
                }, 300);
                return;
            }
            g.oUh.a(405, 73, 1, true);
            w.e("MicroMsg.AppInstallerUI", "pack not found!");
            com.tencent.mm.ui.base.g.bl(this.uqd, this.uqd.getString(R.l.eYS));
            i.bIh();
            this.uqd.finish();
        }
    };

    static /* synthetic */ void a(AppInstallerUI appInstallerUI) {
        w.d("MicroMsg.AppInstallerUI", "showInstallCancelAlert");
        if (appInstallerUI.oHT != null && appInstallerUI.oHT.isShowing()) {
            appInstallerUI.oHT.dismiss();
        }
        if (appInstallerUI.uqa == null || !appInstallerUI.uqa.isShowing()) {
            appInstallerUI.uqa = com.tencent.mm.ui.base.g.a((Context) appInstallerUI, R.l.dPW, R.l.dIO, R.l.dPX, R.l.eaL, false, new OnClickListener(appInstallerUI) {
                final /* synthetic */ AppInstallerUI uqd;

                {
                    this.uqd = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    w.d("MicroMsg.AppInstallerUI", "install dialog had been canceled");
                    if (this.uqd.oHT != null && this.uqd.oHT.isShowing()) {
                        this.uqd.oHT.dismiss();
                    }
                    a.urH.ad(2, true);
                    if (this.uqd.qvw == 2) {
                        i.Y(this.uqd, 4);
                    }
                    g.oUh.a(405, 74, 1, true);
                    i.bIc();
                    this.uqd.finish();
                }
            }, new OnClickListener(appInstallerUI) {
                final /* synthetic */ AppInstallerUI uqd;

                {
                    this.uqd = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    g.oUh.a(405, 75, 1, true);
                    if (this.uqd.oHT != null && !this.uqd.oHT.isShowing()) {
                        this.uqd.oHT.show();
                    }
                }
            });
            return;
        }
        w.d("MicroMsg.AppInstallerUI", "cancelDialog already shown");
    }

    public static AppInstallerUI bHO() {
        return uqb;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.d("MicroMsg.AppInstallerUI", "onCreate");
        com.tencent.mm.sandbox.c.f(hashCode(), this);
        MMActivity.et(this);
        if (AppUpdaterUI.bHP() != null && !AppUpdaterUI.bHP().isFinishing()) {
            w.d("MicroMsg.AppInstallerUI", "AppUpdaterUI is there, finish self");
            finish();
        } else if (uqb == null || uqb.isFinishing() || uqb == this) {
            uqb = this;
            this.fFW = i.Nu();
            if (bg.mA(this.fFW) || c.DE(this.fFW) == null) {
                finish();
                return;
            }
            this.desc = i.bHZ();
            this.qvw = i.bIa();
            setContentView(R.i.empty);
            a aVar = new a(this);
            aVar.zW(R.l.emb);
            aVar.kK(true);
            aVar.d(new OnCancelListener(this) {
                final /* synthetic */ AppInstallerUI uqd;

                {
                    this.uqd = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    AppInstallerUI.a(this.uqd);
                }
            });
            aVar.SX(getString(R.l.eme, new Object[]{this.desc}));
            aVar.zZ(R.l.esE).a(false, this.uqc);
            aVar.Aa(R.l.eYQ).b(null);
            this.oHT = aVar.WJ();
            this.oHT.setCanceledOnTouchOutside(false);
            this.oHT.show();
            g.oUh.a(405, 71, 1, true);
            if (this.qvw == 2) {
                i.f(this, 2, i.bIb() + 1);
            }
        } else {
            w.d("MicroMsg.AppInstallerUI", "duplicate instance, finish self");
            finish();
        }
    }

    protected void onDestroy() {
        w.d("MicroMsg.AppInstallerUI", "onDestroy");
        if (this.oHT != null && this.oHT.isShowing()) {
            this.oHT.dismiss();
        }
        if (this.uqa != null && this.uqa.isShowing()) {
            this.uqa.dismiss();
        }
        if (uqb == this) {
            uqb = null;
        }
        com.tencent.mm.sandbox.c.g(hashCode(), this);
        super.onDestroy();
    }
}
