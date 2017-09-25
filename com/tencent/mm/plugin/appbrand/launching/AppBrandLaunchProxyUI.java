package com.tencent.mm.plugin.appbrand.launching;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.WindowManager.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.LaunchParamsOptional;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.b;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.ui.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.p;
import com.tencent.wcdb.database.SQLiteDatabase;

@a(7)
public final class AppBrandLaunchProxyUI extends MMActivity {
    private p iZl;
    private LaunchParcel iZm;

    static final class LaunchParcel implements Parcelable {
        public static final Creator<LaunchParcel> CREATOR = new Creator<LaunchParcel>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new LaunchParcel(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new LaunchParcel[i];
            }
        };
        String appId;
        String iEI;
        AppBrandLaunchReferrer iEK;
        int iPk;
        AppBrandStatObject iZq;
        LaunchParamsOptional iZr;
        String username;
        int version;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.username);
            parcel.writeString(this.appId);
            parcel.writeInt(this.version);
            parcel.writeInt(this.iPk);
            parcel.writeString(this.iEI);
            parcel.writeParcelable(this.iZq, i);
            parcel.writeParcelable(this.iEK, i);
            parcel.writeParcelable(this.iZr, i);
        }

        LaunchParcel() {
        }

        LaunchParcel(Parcel parcel) {
            this.username = parcel.readString();
            this.appId = parcel.readString();
            this.version = parcel.readInt();
            this.iPk = parcel.readInt();
            this.iEI = parcel.readString();
            this.iZq = (AppBrandStatObject) parcel.readParcelable(AppBrandStatObject.class.getClassLoader());
            this.iEK = (AppBrandLaunchReferrer) parcel.readParcelable(AppBrandLaunchReferrer.class.getClassLoader());
            this.iZr = (LaunchParamsOptional) parcel.readParcelable(LaunchParamsOptional.class.getClassLoader());
        }
    }

    static /* synthetic */ boolean b(AppBrandLaunchProxyUI appBrandLaunchProxyUI) {
        return appBrandLaunchProxyUI.isFinishing() || appBrandLaunchProxyUI.uSW;
    }

    public static void a(Context context, String str, String str2, int i, int i2, AppBrandStatObject appBrandStatObject, LaunchParamsOptional launchParamsOptional) {
        a(context, str, null, str2, i, i2, appBrandStatObject, null, launchParamsOptional);
    }

    public static boolean a(Context context, String str, String str2, String str3, int i, int i2, AppBrandStatObject appBrandStatObject, AppBrandLaunchReferrer appBrandLaunchReferrer, LaunchParamsOptional launchParamsOptional) {
        if (bg.mA(str) && bg.mA(str2)) {
            return false;
        }
        if (bg.mA(str2)) {
            str2 = a.UR().pH(str);
        }
        if (!(bg.mA(str2) || i == 2 || !b.qM(str2))) {
            AppBrandInitConfig pJ = a.UR().pJ(str2);
            if (pJ != null && pJ.izM == i) {
                a(context, str, pJ, str3, appBrandStatObject, appBrandLaunchReferrer, launchParamsOptional);
                return true;
            }
        }
        Parcelable launchParcel = new LaunchParcel();
        launchParcel.username = str;
        launchParcel.appId = str2;
        launchParcel.iEI = str3;
        launchParcel.iPk = i;
        launchParcel.version = i2;
        launchParcel.iZq = appBrandStatObject;
        launchParcel.iEK = appBrandLaunchReferrer;
        launchParcel.iZr = launchParamsOptional;
        if (context == null) {
            context = ab.getContext();
        }
        Intent putExtra = new Intent(context, AppBrandLaunchProxyUI.class).putExtra("launch_parcel", launchParcel);
        if (!(context instanceof Activity)) {
            putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        }
        w.v("MicroMsg.AppBrandLaunchProxyUI", "start we app with username(%s) and appId(%s) and statObj(%s)", new Object[]{str, str2, appBrandStatObject});
        putExtra.putExtra("appbrand_report_key_appid", str2);
        putExtra.putExtra("appbrand_report_key_username", str);
        context.startActivity(putExtra);
        return true;
    }

    protected final int getLayoutId() {
        return -1;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g.a(getWindow());
        try {
            this.iZm = (LaunchParcel) getIntent().getParcelableExtra("launch_parcel");
        } catch (Exception e) {
        }
        if (this.iZm == null) {
            finish();
            return;
        }
        getString(R.l.dIO);
        this.iZl = com.tencent.mm.ui.base.g.a(this, getString(R.l.cbS), true, new OnCancelListener(this) {
            final /* synthetic */ AppBrandLaunchProxyUI iZn;

            {
                this.iZn = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.iZn.finish();
            }
        });
        if (this.iZl.getWindow() != null) {
            LayoutParams attributes = this.iZl.getWindow().getAttributes();
            attributes.dimAmount = 0.0f;
            this.iZl.getWindow().setAttributes(attributes);
        }
        d.vL().D(new Runnable(this) {
            final /* synthetic */ AppBrandLaunchProxyUI iZn;

            {
                this.iZn = r1;
            }

            public final void run() {
                d.XG();
                new c(this.iZn.iZm, new c.a(this) {
                    final /* synthetic */ AnonymousClass2 iZo;

                    {
                        this.iZo = r1;
                    }

                    public final void b(final AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
                        if (!AppBrandLaunchProxyUI.b(this.iZo.iZn)) {
                            if (appBrandInitConfig == null) {
                                this.iZo.iZn.finish();
                                return;
                            }
                            String str = appBrandInitConfig.appId;
                            j anonymousClass1 = new j(this, str) {
                                final /* synthetic */ AnonymousClass1 iZp;

                                final void onReady() {
                                    if (!AppBrandLaunchProxyUI.b(this.iZp.iZo.iZn)) {
                                        AppBrandLaunchProxyUI.a(this.iZp.iZo.iZn, this.iZp.iZo.iZn.iZm.username, appBrandInitConfig, this.iZp.iZo.iZn.iZm.iEI, this.iZp.iZo.iZn.iZm.iZq, this.iZp.iZo.iZn.iZm.iEK, this.iZp.iZo.iZn.iZm.iZr);
                                        this.iZp.iZo.iZn.finish();
                                    }
                                }

                                final void US() {
                                    this.iZp.iZo.iZn.finish();
                                }

                                final void UT() {
                                    super.UT();
                                    this.iZp.iZo.iZn.finish();
                                }
                            };
                            if (b.qM(str)) {
                                anonymousClass1.onReady();
                                return;
                            }
                            Context context = this.iZo.iZn;
                            long Nz = bg.Nz();
                            w.d("MicroMsg.AppBrand.PreLaunchCheckForTBS", "check tbs download, cost = %d, cheTBSRet = %d", new Object[]{Long.valueOf(bg.Nz() - Nz), Integer.valueOf(com.tencent.mm.pluginsdk.model.w.a.bCO())});
                            switch (com.tencent.mm.pluginsdk.model.w.a.bCO()) {
                                case 0:
                                    w.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "check(Activity), onReady");
                                    anonymousClass1.onReady();
                                    return;
                                case 1:
                                    w.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "check(Activity), goProxyUI");
                                    if (context != null && !context.isFinishing()) {
                                        Intent putExtra = new Intent().putExtra("intent_extra_download_ignore_network_type", true);
                                        context.uSV = anonymousClass1;
                                        com.tencent.mm.bb.d.b(context, "appbrand", ".ui.AppBrandTBSDownloadProxyUI", putExtra, anonymousClass1.fFR);
                                        return;
                                    }
                                    return;
                                case 2:
                                    w.i("MicroMsg.AppBrand.PreLaunchCheckForTBS", "check(Activity), dealCannotDownload");
                                    anonymousClass1.Va();
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                }).run();
            }
        });
    }

    protected final void onDestroy() {
        super.onDestroy();
        if (this.iZl != null) {
            this.iZl.dismiss();
            this.iZl = null;
        }
    }

    private static void a(Context context, String str, AppBrandInitConfig appBrandInitConfig, String str2, AppBrandStatObject appBrandStatObject, AppBrandLaunchReferrer appBrandLaunchReferrer, LaunchParamsOptional launchParamsOptional) {
        String str3 = null;
        if (context == null) {
            context = ab.getContext();
        }
        appBrandInitConfig.startTime = bg.Nz();
        appBrandInitConfig.iEI = com.tencent.mm.plugin.appbrand.appcache.a.nz(str2);
        appBrandInitConfig.iEK.a(appBrandLaunchReferrer);
        appBrandInitConfig.iEJ = AppBrandStickyBannerLogic.b.ap(appBrandInitConfig.appId, appBrandInitConfig.izM);
        appBrandInitConfig.hpS = launchParamsOptional == null ? null : launchParamsOptional.hpS;
        if (launchParamsOptional != null) {
            str3 = launchParamsOptional.hpT;
        }
        appBrandInitConfig.hpT = str3;
        boolean V = c.PW().V(str, appBrandInitConfig.izM);
        if (c.PX().U(str, appBrandInitConfig.izM)) {
            appBrandStatObject.jfY = 1;
        } else if (V) {
            appBrandStatObject.jfY = 2;
        } else {
            appBrandStatObject.jfY = 3;
        }
        b.a(context, appBrandInitConfig, appBrandStatObject);
        a UR = a.UR();
        if (appBrandInitConfig != null && !bg.mA(appBrandInitConfig.appId)) {
            synchronized (UR.iZe) {
                UR.iZe.put(appBrandInitConfig.appId, appBrandInitConfig);
            }
            if (!bg.mA(str)) {
                synchronized (UR.iZf) {
                    UR.iZf.put(str, appBrandInitConfig.appId);
                }
            }
        }
    }
}
