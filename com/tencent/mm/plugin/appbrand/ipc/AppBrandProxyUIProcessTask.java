package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import java.lang.reflect.Constructor;

public abstract class AppBrandProxyUIProcessTask implements com.tencent.mm.ui.MMActivity.a {
    public b iKm;

    public static abstract class ProcessRequest implements Parcelable {
        public abstract Class<? extends AppBrandProxyUIProcessTask> SI();

        public ProcessRequest(Parcel parcel) {
            h(parcel);
        }

        public boolean SG() {
            return false;
        }

        public String SH() {
            return null;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
        }

        public void h(Parcel parcel) {
        }
    }

    public static abstract class ProcessResult implements Parcelable {
        public abstract void h(Parcel parcel);

        public ProcessResult(Parcel parcel) {
            h(parcel);
        }
    }

    static final class a {
        static <_Model extends AppBrandProxyUIProcessTask> _Model oY(String str) {
            try {
                Constructor declaredConstructor = Class.forName(str).getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                return (AppBrandProxyUIProcessTask) declaredConstructor.newInstance(new Object[0]);
            } catch (Throwable e) {
                w.e("MicroMsg.AppBrand.IpcProxyUIModelFactory", "create mode object using className(%s), exp = %s", new Object[]{str, bg.g(e)});
                return null;
            }
        }
    }

    public interface b<R extends ProcessResult> {
        void c(R r);
    }

    public abstract void a(ProcessRequest processRequest);

    public final MMActivity SD() {
        return this.iKm.SD();
    }

    public final void a(final ProcessResult processResult) {
        Runnable anonymousClass1 = new Runnable(this) {
            final /* synthetic */ AppBrandProxyUIProcessTask iKn;

            public final void run() {
                if (this.iKn.iKm != null) {
                    this.iKn.iKm.a(processResult);
                }
            }
        };
        if (this.iKm != null) {
            this.iKm.runOnUiThread(anonymousClass1);
        }
    }

    public void a(int i, int i2, Intent intent) {
    }

    public void SF() {
    }
}
