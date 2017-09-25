package com.tencent.mm.plugin.profile.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.ao.n;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.pluginsdk.d.a;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.preference.HelperHeaderPreference;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.bm;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.net.URI;
import java.net.URL;

public final class m implements a, b {
    public Context context;
    private boolean fFU;
    private f isJ;
    private x jiL;

    public m(Context context) {
        this.context = context;
    }

    public final boolean sa(String str) {
        if (bg.mz(str).length() <= 0) {
            return false;
        }
        if ("contact_info_go_to_sync".equals(str)) {
            if (p.n(this.context, "com.tencent.qqpim")) {
                Intent launchIntentForPackage = this.context.getPackageManager().getLaunchIntentForPackage("com.tencent.qqpim");
                launchIntentForPackage.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.context.startActivity(launchIntentForPackage);
            } else {
                g.a(this.context, R.l.dZf, R.l.dIO, R.l.dGE, R.l.dGs, new OnClickListener(this) {
                    final /* synthetic */ m ouT;

                    {
                        this.ouT = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        String str = "http://tools.3g.qq.com/j/wechatandriodpim";
                        if (com.tencent.mm.sdk.platformtools.f.fuV == 1) {
                            Intent addFlags = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.tencent.qqpim")).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                            if (bg.j(this.ouT.context, addFlags)) {
                                this.ouT.context.startActivity(addFlags);
                                return;
                            }
                            str = "https://play.google.com/store/apps/details?id=com.tencent.qqpim";
                        }
                        try {
                            URL url = new URL(str);
                            URL toURL = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(), url.getPath(), url.getQuery(), url.getRef()).toURL();
                            com.tencent.mm.plugin.downloader.model.f.a aVar = new com.tencent.mm.plugin.downloader.model.f.a();
                            aVar.tN("qqpim.apk");
                            aVar.tL(toURL.toString());
                            aVar.dn(true);
                            aVar.la(1);
                            e.akM().a(aVar.kHa);
                        } catch (Exception e) {
                            w.e("MicroMsg.ContactWidgetQQSync", "dz[download qq mail error:%s]", new Object[]{e.toString()});
                        }
                    }
                }, null);
            }
            return true;
        } else if ("contact_info_remind_me_syncing".equals(str)) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.isJ.Td("contact_info_remind_me_syncing");
            ap.yY();
            c.vr().set(65792, Boolean.valueOf(checkBoxPreference.isChecked()));
            bm.n(6, checkBoxPreference.isChecked() ? "1" : "2");
            return true;
        } else if (str.equals("contact_info_qqsync_install")) {
            h(this.context, true);
            return true;
        } else if (!str.equals("contact_info_qqsync_uninstall")) {
            return false;
        } else {
            g.a(this.context, this.context.getString(R.l.eTH), "", this.context.getString(R.l.dGt), this.context.getString(R.l.dGs), new OnClickListener(this) {
                final /* synthetic */ m ouT;

                {
                    this.ouT = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.ouT.h(this.ouT.context, false);
                }
            }, null);
            return true;
        }
    }

    public final void h(Context context, final boolean z) {
        String string = z ? context.getString(R.l.eTE) : context.getString(R.l.eTL);
        context.getString(R.l.dIO);
        final ProgressDialog a = g.a(context, string, true, null);
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ m ouT;

            public final void run() {
                boolean z = z;
                bm.n(6, z ? TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL : "4");
                int xW = com.tencent.mm.u.m.xW();
                int i = z ? xW & -129 : xW | FileUtils.S_IWUSR;
                ap.yY();
                c.vr().set(34, Integer.valueOf(i));
                ap.yY();
                c.wQ().b(new n("", "", "", "", "", "", "", "", i, "", ""));
                if (!z) {
                    ay.gl("qqsync");
                    ap.yY();
                    c.wW().Rl("qqsync");
                }
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass3 ouU;

                    {
                        this.ouU = r1;
                    }

                    public final void run() {
                        a.dismiss();
                    }
                });
            }
        });
    }

    public final boolean a(f fVar, x xVar, boolean z, int i) {
        ap.yY();
        c.vr().a(this);
        this.isJ = fVar;
        this.jiL = xVar;
        fVar.addPreferencesFromResource(R.o.ftA);
        adH();
        return true;
    }

    public final boolean adI() {
        ap.yY();
        c.vr().b(this);
        return true;
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        if (this.fFU != com.tencent.mm.u.m.yg()) {
            adH();
        }
    }

    private void adH() {
        boolean z;
        boolean z2 = true;
        this.fFU = com.tencent.mm.u.m.yg();
        HelperHeaderPreference helperHeaderPreference = (HelperHeaderPreference) this.isJ.Td("contact_info_header_helper");
        helperHeaderPreference.Y(this.jiL.field_username, this.jiL.tL(), this.context.getString(R.l.dZg));
        helperHeaderPreference.kg(this.fFU ? 1 : 0);
        f fVar = this.isJ;
        String str = "contact_info_go_to_sync";
        if (this.fFU) {
            z = false;
        } else {
            z = true;
        }
        fVar.aV(str, z);
        fVar = this.isJ;
        str = "contact_info_remind_me_syncing_tip";
        if (this.fFU) {
            z = false;
        } else {
            z = true;
        }
        fVar.aV(str, z);
        this.isJ.aV("contact_info_qqsync_install", this.fFU);
        f fVar2 = this.isJ;
        String str2 = "contact_info_qqsync_uninstall";
        if (this.fFU) {
            z2 = false;
        }
        fVar2.aV(str2, z2);
    }
}
