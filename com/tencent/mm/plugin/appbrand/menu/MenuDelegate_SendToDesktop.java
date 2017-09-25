package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.e.a.bp;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.l;

public final class MenuDelegate_SendToDesktop extends a {

    private static class SendShortcutToDesktopTask extends MainProcessTask {
        public static final Creator<SendShortcutToDesktopTask> CREATOR = new Creator<SendShortcutToDesktopTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new SendShortcutToDesktopTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SendShortcutToDesktopTask[i];
            }
        };
        public int fKL;
        private String ivH;
        public boolean jat;
        private Context mContext;
        public String username;

        public SendShortcutToDesktopTask(Context context, String str, String str2, int i) {
            this.mContext = context;
            this.username = str;
            this.ivH = str2;
            this.fKL = i;
        }

        public SendShortcutToDesktopTask(Parcel parcel) {
            f(parcel);
        }

        public final void PM() {
            final Context context = ab.getContext();
            String str = this.username;
            int i = this.fKL;
            if (context == null || str == null) {
                w.e("MicroMsg.AppBrandShortcutManager", "remove fail, context or username is null.");
            } else {
                b bpVar = new bp();
                bpVar.fEY.username = str;
                com.tencent.mm.sdk.b.a.urY.m(bpVar);
                if (bpVar.fEZ.fFb == null) {
                    w.e("MicroMsg.AppBrandShortcutManager", "no such user");
                } else {
                    Intent a = com.tencent.mm.plugin.base.model.a.a(context, bpVar, i, com.tencent.mm.plugin.base.model.a.a(context, com.tencent.mm.plugin.base.model.a.a(bpVar), i), false);
                    if (a == null) {
                        w.e("MicroMsg.AppBrandShortcutManager", "remove fail, intent is null");
                    } else {
                        c.m(context, a);
                        w.i("MicroMsg.AppBrandShortcutManager", "remove shortcut %s", new Object[]{str});
                    }
                }
            }
            af.f(new Runnable(this) {
                final /* synthetic */ SendShortcutToDesktopTask jau;

                public final void run() {
                    SendShortcutToDesktopTask sendShortcutToDesktopTask = this.jau;
                    boolean b = com.tencent.mm.plugin.base.model.a.b(context, this.jau.username, this.jau.fKL);
                    sendShortcutToDesktopTask.jat = b;
                    if (b) {
                        g.oUh.a(443, 1, 1, false);
                    }
                    this.jau.SL();
                }
            }, 1000);
        }

        public final void SK() {
            if (this.mContext != null && this.jat) {
                AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(this.ivH);
                if (mY != null) {
                    SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(this.mContext, "pref_appbrand_" + mY.uin, 4);
                    if (!sharedPreferences.contains("has_show_send_to_desktop_tips")) {
                        if (com.tencent.mm.plugin.appbrand.b.mW(this.ivH) != null) {
                            Context context = this.mContext;
                            com.tencent.mm.ui.base.g.b(context, context.getString(R.l.dEc), context.getString(R.l.dIO), false);
                        }
                        sharedPreferences.edit().putBoolean("has_show_send_to_desktop_tips", true).commit();
                    }
                }
            }
        }

        public final void f(Parcel parcel) {
            this.username = parcel.readString();
            this.fKL = parcel.readInt();
            this.jat = parcel.readInt() != 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.username);
            parcel.writeInt(this.fKL);
            parcel.writeInt(this.jat ? 1 : 0);
        }
    }

    public MenuDelegate_SendToDesktop() {
        super(k.jaF - 1);
    }

    public final void a(Context context, m mVar, l lVar, String str) {
        if (com.tencent.mm.plugin.appbrand.b.mZ(str).scene != 1023) {
            lVar.e(this.jaM, context.getString(R.l.dFT));
        }
    }

    public final void a(Context context, m mVar, String str, j jVar) {
        AppBrandSysConfig mY = com.tencent.mm.plugin.appbrand.b.mY(str);
        Object obj = mY.fCJ;
        if (context == null || TextUtils.isEmpty(obj)) {
            w.i("MicroMsg.MenuDelegate_SendToDesktop", "performItemClick failed, context or username is null or nil.");
            return;
        }
        AppBrandMainProcessService.a(new SendShortcutToDesktopTask(context, obj, str, mY.iFk.izV));
        com.tencent.mm.plugin.appbrand.report.a.a(str, mVar.jde.jdU, 14, "", bg.Ny(), 1, 0);
    }
}
