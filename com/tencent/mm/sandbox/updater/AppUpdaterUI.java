package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a;
import com.tencent.wcdb.database.SQLiteDatabase;

public class AppUpdaterUI extends MMBaseActivity {
    private static AppUpdaterUI uqg = null;
    private Button jMJ;
    private h oHT = null;
    private OnClickListener uqc = new OnClickListener(this) {
        final /* synthetic */ AppUpdaterUI uqk;

        {
            this.uqk = r1;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            w.d("MicroMsg.AppUpdaterUI", "getBtn (ok button) is click");
            if (this.uqk.uqh.qvw == 1) {
                i.Y(this.uqk, 6);
            }
            if (!com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted")) {
                w.e("MicroMsg.AppUpdaterUI", "no sdcard.");
                this.uqk.oHT.dismiss();
                AppUpdaterUI.c(this.uqk);
            } else if ((this.uqk.uqh.fuX & 1) != 0) {
                w.e("MicroMsg.AppUpdaterUI", "package has set external update mode");
                Uri parse = Uri.parse(this.uqk.uqh.fuZ);
                Intent addFlags = new Intent("android.intent.action.VIEW", parse).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                if (parse == null || addFlags == null || !bg.j(this.uqk, addFlags)) {
                    w.e("MicroMsg.AppUpdaterUI", "parse market uri failed, jump to weixin.qq.com");
                    this.uqk.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY));
                } else {
                    w.i("MicroMsg.AppUpdaterUI", "parse market uri ok");
                    this.uqk.startActivity(addFlags);
                }
                this.uqk.bHR();
            } else {
                String DE = c.DE(this.uqk.uqh.fFW);
                w.d("MicroMsg.AppUpdaterUI", DE);
                if (DE != null) {
                    w.i("MicroMsg.AppUpdaterUI", "update package already exist.");
                    i.X(this.uqk, 8);
                    if (this.uqk.uqh.urv) {
                        i.X(this.uqk, 0);
                    } else {
                        i.X(this.uqk, 9);
                    }
                    this.uqk.uqh.ad(1, true);
                    this.uqk.uqi.FW(DE);
                    return;
                }
                w.d("MicroMsg.AppUpdaterUI", "current downloadMode : %s", Integer.valueOf(this.uqk.uqh.qvw));
                w.d("MicroMsg.AppUpdaterUI", "current updateType : %s", Integer.valueOf(this.uqk.uqh.upV));
                if (this.uqk.uqh.qvw == 0) {
                    this.uqk.uqh.bIj();
                } else if (this.uqk.uqh.qvw == 1) {
                    w.d("MicroMsg.AppUpdaterUI", "gonna start UpdaterService");
                    this.uqk.bHR();
                    Intent intent = new Intent(this.uqk.getIntent());
                    intent.setClass(this.uqk, UpdaterService.class);
                    intent.putExtra("intent_extra_run_in_foreground", true);
                    this.uqk.startService(intent);
                    if (this.uqk.uqh.urz) {
                        g.oUh.a(614, 56, 1, false);
                    }
                } else {
                    w.e("MicroMsg.AppUpdaterUI", "silence download never go here!");
                }
            }
        }
    };
    private Button uqf;
    private j uqh;
    private g uqi = new g(this) {
        final /* synthetic */ AppUpdaterUI uqk;

        {
            this.uqk = r1;
        }

        public final void cx(int i, int i2) {
            int i3 = (int) (i <= 0 ? 0 : (((long) i2) * 100) / ((long) i));
            if (i3 == 100) {
                this.uqk.uqf.setText(this.uqk.getString(R.l.eYZ));
            } else {
                this.uqk.uqf.setText(this.uqk.getString(R.l.eYX) + i3 + "%");
            }
        }

        public final void bHS() {
            w.e("MicroMsg.AppUpdaterUI", "no sdcard.");
            if (this.uqk.oHT != null) {
                this.uqk.oHT.dismiss();
            }
            if (!this.uqk.isFinishing()) {
                AppUpdaterUI.c(this.uqk);
            }
        }

        public final void bHT() {
            if (this.uqk.oHT != null) {
                this.uqk.oHT.dismiss();
            }
            if (!this.uqk.isFinishing()) {
                AppUpdaterUI.d(this.uqk);
            }
        }

        public final void bgn() {
            if (!this.uqk.isFinishing()) {
                this.uqk.uqf.setText(R.l.eYX);
                this.uqk.uqf.setEnabled(false);
            }
        }

        public final void FW(String str) {
            if (this.uqk.oHT != null) {
                this.uqk.oHT.dismiss();
            }
            if (!this.uqk.isFinishing()) {
                w.d("MicroMsg.AppUpdaterUI", str);
                if (str != null) {
                    AppUpdaterUI.a(this.uqk, str);
                    this.uqk.uqf.setEnabled(false);
                }
            }
        }

        public final void a(c cVar) {
            if (!this.uqk.isFinishing()) {
                if (cVar instanceof c) {
                    g.oUh.a(405, 67, 1, true);
                    w.e("MicroMsg.AppUpdaterUI", "download package from cdn error. switch to webserver");
                    if (this.uqk.oHT != null) {
                        this.uqk.oHT.setMessage(this.uqk.getString(R.l.emd, new Object[]{this.uqk.uqh.desc, this.uqk.getString(R.l.eYU), bg.ay((long) this.uqk.uqh.size)}));
                    }
                    if (this.uqk.uqh.urv) {
                        g.oUh.a(405, 68, 1, true);
                        AppUpdaterUI.a(this.uqk, cVar);
                        return;
                    }
                    return;
                }
                g.oUh.a(405, 69, 1, true);
                com.tencent.mm.ui.base.g.a(this.uqk, R.l.eYV, R.l.dIO, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 uql;

                    {
                        this.uql = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        w.d("MicroMsg.AppUpdaterUI", "go to WebView");
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://weixin.qq.com/m"));
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        this.uql.uqk.startActivity(intent);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 uql;

                    {
                        this.uql = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        }
    };
    private OnClickListener uqj = new OnClickListener(this) {
        final /* synthetic */ AppUpdaterUI uqk;

        {
            this.uqk = r1;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppUpdaterUI.g(this.uqk);
        }
    };

    static /* synthetic */ void a(AppUpdaterUI appUpdaterUI, final c cVar) {
        w.d("MicroMsg.AppUpdaterUI", "showDownloadFullPackAlert()");
        h a = com.tencent.mm.ui.base.g.a((Context) appUpdaterUI, appUpdaterUI.getString(R.l.emc, new Object[]{bg.ay((long) appUpdaterUI.uqh.size)}), appUpdaterUI.getString(R.l.dIO), new OnClickListener(appUpdaterUI) {
            final /* synthetic */ AppUpdaterUI uqk;

            public final void onClick(DialogInterface dialogInterface, int i) {
                w.d("MicroMsg.AppUpdaterUI", "click download button");
                i.X(this.uqk, 11);
                if (cVar != null) {
                    cVar.deleteTempFile();
                }
                j e = this.uqk.uqh;
                e.urx = true;
                e.bIj();
            }
        });
        a.setOnCancelListener(new OnCancelListener(appUpdaterUI) {
            final /* synthetic */ AppUpdaterUI uqk;

            {
                this.uqk = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                w.d("MicroMsg.AppUpdaterUI", "click cancel button");
                i.X(this.uqk, 12);
                AppUpdaterUI.i(this.uqk);
            }
        });
        a.setCanceledOnTouchOutside(false);
    }

    static /* synthetic */ void a(AppUpdaterUI appUpdaterUI, final String str) {
        g.oUh.a(405, 70, 1, true);
        new ae().postDelayed(new Runnable(appUpdaterUI) {
            final /* synthetic */ AppUpdaterUI uqk;

            public final void run() {
                this.uqk.startActivity(bg.PN(str));
                this.uqk.bHR();
            }
        }, 300);
    }

    static /* synthetic */ void c(AppUpdaterUI appUpdaterUI) {
        w.d("MicroMsg.AppUpdaterUI", "showNoSDCardAlert");
        g.oUh.a(405, 65, 1, true);
        com.tencent.mm.ui.base.g.a((Context) appUpdaterUI, appUpdaterUI.getString(R.l.eZa), appUpdaterUI.getString(R.l.dIO), new OnClickListener(appUpdaterUI) {
            final /* synthetic */ AppUpdaterUI uqk;

            {
                this.uqk = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppUpdaterUI.i(this.uqk);
            }
        }).setOnCancelListener(new OnCancelListener(appUpdaterUI) {
            final /* synthetic */ AppUpdaterUI uqk;

            {
                this.uqk = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppUpdaterUI.i(this.uqk);
            }
        });
    }

    static /* synthetic */ void d(AppUpdaterUI appUpdaterUI) {
        w.d("MicroMsg.AppUpdaterUI", "showSDCardFullAlert");
        g.oUh.a(405, 66, 1, true);
        com.tencent.mm.ui.base.g.a((Context) appUpdaterUI, appUpdaterUI.getString(R.l.eZd), appUpdaterUI.getString(R.l.dIO), new OnClickListener(appUpdaterUI) {
            final /* synthetic */ AppUpdaterUI uqk;

            {
                this.uqk = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppUpdaterUI.i(this.uqk);
            }
        }).setOnCancelListener(new OnCancelListener(appUpdaterUI) {
            final /* synthetic */ AppUpdaterUI uqk;

            {
                this.uqk = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppUpdaterUI.i(this.uqk);
            }
        });
    }

    static /* synthetic */ void g(AppUpdaterUI appUpdaterUI) {
        w.d("MicroMsg.AppUpdaterUI", "showDownloadCancelAlert");
        if (appUpdaterUI.uqh.urA) {
            com.tencent.mm.ui.base.g.b(appUpdaterUI, R.l.dPV, R.l.dIO, new OnClickListener(appUpdaterUI) {
                final /* synthetic */ AppUpdaterUI uqk;

                {
                    this.uqk = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    w.d("MicroMsg.AppUpdaterUI", "update dialog had been canceled");
                    if (this.uqk.oHT != null && this.uqk.oHT.isShowing()) {
                        this.uqk.oHT.dismiss();
                    }
                    i.X(this.uqk, 6);
                    if (this.uqk.uqh.urz) {
                        g.oUh.a(614, 59, 1, false);
                    }
                    this.uqk.uqh.cancel();
                    this.uqk.uqh.ad(2, true);
                    this.uqk.bHR();
                }
            }, new OnClickListener(appUpdaterUI) {
                final /* synthetic */ AppUpdaterUI uqk;

                {
                    this.uqk = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    if (this.uqk.oHT != null && !this.uqk.oHT.isShowing()) {
                        this.uqk.oHT.show();
                    }
                }
            });
            return;
        }
        if (appUpdaterUI.uqh.qvw == 1) {
            i.Y(appUpdaterUI, 7);
            if (appUpdaterUI.uqh.urz) {
                g.oUh.a(614, 57, 1, false);
            }
        }
        i.X(appUpdaterUI, 6);
        appUpdaterUI.uqh.ad(2, true);
        appUpdaterUI.bHR();
    }

    static /* synthetic */ void i(AppUpdaterUI appUpdaterUI) {
        appUpdaterUI.uqh.cancel();
        appUpdaterUI.uqh.ad(2, true);
        appUpdaterUI.bHR();
    }

    public static AppUpdaterUI bHP() {
        return uqg;
    }

    public static void bHQ() {
        if (uqg != null) {
            uqg.bHR();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.d("MicroMsg.AppUpdaterUI", "onCreate");
        com.tencent.mm.sandbox.c.f(hashCode(), this);
        MMActivity.et(this);
        if (AppInstallerUI.bHO() != null && !AppInstallerUI.bHO().isFinishing()) {
            w.d("MicroMsg.AppUpdaterUI", "AppInstallerUI is there, finish self");
            finish();
        } else if (uqg == null || uqg.isFinishing() || uqg == this) {
            uqg = this;
            setContentView(R.i.empty);
            this.uqh = a.urH;
            if (!this.uqh.ac(getIntent())) {
                w.e("MicroMsg.AppUpdaterUI", "updaterManager.handleCommand return false");
                bHR();
            } else if (this.uqh.upV != 999 || this.uqh.uqx == null || this.uqh.uqx.length <= 0) {
                String string;
                w.d("MicroMsg.AppUpdaterUI", "showUpdateDlg, downloadUrls = " + this.uqh.uqx);
                a aVar = new a(this);
                aVar.zW(R.l.emb);
                aVar.kK(true);
                aVar.d(new OnCancelListener(this) {
                    final /* synthetic */ AppUpdaterUI uqk;

                    {
                        this.uqk = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppUpdaterUI.g(this.uqk);
                    }
                });
                if (!this.uqh.urv || this.uqh.uru == null) {
                    w.d("MicroMsg.AppUpdaterUI", "had try to download full pack.");
                    string = getString(R.l.emd, new Object[]{this.uqh.desc, getString(R.l.eYU), bg.ay((long) this.uqh.size)});
                } else {
                    string = getString(R.l.emd, new Object[]{this.uqh.desc, getString(R.l.eYY), bg.ay((long) this.uqh.uru.size)});
                }
                int i = this.uqh.upV != 1 ? R.l.eYQ : R.l.eYT;
                aVar.SX(string);
                aVar.zZ(R.l.eZc).a(false, this.uqc);
                aVar.Aa(i);
                this.oHT = aVar.WJ();
                this.oHT.setCanceledOnTouchOutside(false);
                this.uqf = this.oHT.getButton(-1);
                this.jMJ = this.oHT.getButton(-2);
                this.oHT.show();
                if (this.uqh.qvw == 1) {
                    i.Y(this, 5);
                }
                j jVar = this.uqh;
                g gVar = this.uqi;
                if (gVar != null && !jVar.urq.contains(gVar)) {
                    jVar.urq.add(gVar);
                }
            } else {
                w.d("MicroMsg.AppUpdaterUI", "into emergency status");
                new ae().postDelayed(new Runnable(this) {
                    final /* synthetic */ AppUpdaterUI uqk;

                    {
                        this.uqk = r1;
                    }

                    public final void run() {
                        com.tencent.mm.ui.base.g.a(this.uqk, this.uqk.uqh.desc, this.uqk.getString(R.l.dIO), new OnClickListener(this) {
                            final /* synthetic */ AnonymousClass7 uqm;

                            {
                                this.uqm = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.uqm.uqk.uqh.uqx[0]));
                                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                                ab.getContext().startActivity(intent);
                                this.uqm.uqk.bHR();
                            }
                        }).setOnCancelListener(new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass7 uqm;

                            {
                                this.uqm = r1;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                this.uqm.uqk.bHR();
                            }
                        });
                    }
                }, 100);
            }
        } else {
            w.d("MicroMsg.AppUpdaterUI", "duplicate instance, finish self");
            w.d("MicroMsg.AppUpdaterUI", "we already got one instance, does it gonna leak?");
            finish();
        }
    }

    protected void onDestroy() {
        w.d("MicroMsg.AppUpdaterUI", "onDestroy");
        com.tencent.mm.sandbox.c.g(hashCode(), this);
        if (this.uqh != null) {
            j jVar = this.uqh;
            jVar.urq.remove(this.uqi);
        }
        if (uqg == this) {
            uqg = null;
        }
        super.onDestroy();
    }

    private void bHR() {
        if (this.oHT != null && this.oHT.isShowing()) {
            this.oHT.dismiss();
        }
        finish();
    }
}
