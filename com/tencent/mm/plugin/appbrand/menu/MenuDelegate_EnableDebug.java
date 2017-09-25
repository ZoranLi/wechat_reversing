package com.tencent.mm.plugin.appbrand.menu;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.app.c;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.l;

public final class MenuDelegate_EnableDebug extends a {

    private static class SetAppDebugModeTask extends MainProcessTask {
        public static final Creator<SetAppDebugModeTask> CREATOR = new Creator<SetAppDebugModeTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                SetAppDebugModeTask setAppDebugModeTask = new SetAppDebugModeTask();
                setAppDebugModeTask.f(parcel);
                return setAppDebugModeTask;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new SetAppDebugModeTask[i];
            }
        };
        public String appId;
        public boolean fFU;

        public final void PM() {
            String str = this.appId;
            boolean z = this.fFU;
            if (!bg.mA(str) && c.PV() != null) {
                c.PV().aL(str + "_AppDebugEnabled", String.valueOf(z));
            }
        }

        public final void f(Parcel parcel) {
            this.appId = parcel.readString();
            this.fFU = parcel.readByte() != (byte) 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeByte(this.fFU ? (byte) 1 : (byte) 0);
        }
    }

    public MenuDelegate_EnableDebug() {
        super(k.jaA - 1);
    }

    public final void a(Context context, m mVar, l lVar, String str) {
        Object obj;
        CharSequence string;
        if (!bg.mA(str)) {
            AppBrandSysConfig mY = b.mY(str);
            if (!(mY == null || mY.iFk.izV == 0)) {
                obj = 1;
                if (obj != null) {
                    if (mVar.ixr.iwo.iER) {
                        string = context.getString(R.l.dDX);
                    } else {
                        string = context.getString(R.l.dDV);
                    }
                    lVar.e(k.jaA - 1, string);
                }
            }
        }
        obj = null;
        if (obj != null) {
            if (mVar.ixr.iwo.iER) {
                string = context.getString(R.l.dDX);
            } else {
                string = context.getString(R.l.dDV);
            }
            lVar.e(k.jaA - 1, string);
        }
    }

    public final void a(Context context, m mVar, String str, j jVar) {
        e(context, str, !mVar.ixr.iwo.iER);
    }

    public static void e(final Context context, String str, boolean z) {
        String string;
        MainProcessTask setAppDebugModeTask = new SetAppDebugModeTask();
        setAppDebugModeTask.appId = str;
        setAppDebugModeTask.fFU = z;
        AppBrandMainProcessService.a(setAppDebugModeTask);
        if (setAppDebugModeTask.fFU) {
            string = context.getString(R.l.dDO);
        } else {
            string = context.getString(R.l.dDN);
        }
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(new Runnable() {
                public final void run() {
                    Toast.makeText(context, string, 0).show();
                    ((Activity) context).finish();
                }
            });
        }
    }
}
