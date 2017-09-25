package com.tencent.mm.plugin.appbrand.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.am.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map.Entry;

public final class AppBrandMusicClientService {
    public static AppBrandMusicClientService jao = new AppBrandMusicClientService();
    public HashMap<String, b> jan = new HashMap();
    public volatile String jap = "";

    private static final class a implements i<IPCString, IPCBoolean> {
        private a() {
        }

        public final /* synthetic */ Object al(Object obj) {
            return new IPCBoolean(a.iwi.nn(((IPCString) obj).value));
        }
    }

    public interface b {
        void QI();

        void onStop();
    }

    private static class StopBackgroundMusicTask extends MainProcessTask {
        public static final Creator<StopBackgroundMusicTask> CREATOR = new Creator<StopBackgroundMusicTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new StopBackgroundMusicTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StopBackgroundMusicTask[i];
            }
        };
        public String appId;

        public StopBackgroundMusicTask(Parcel parcel) {
            f(parcel);
        }

        public final void PM() {
            w.i("MicroMsg.AppBrandMusicClientService", "runInMainProcess");
            String str = a.iwi.iwg;
            if (!bg.mA(str) && !str.equals(this.appId)) {
                w.i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[]{str, this.appId});
                SL();
            } else if (a.iwi.nn(this.appId)) {
                if (c.HP()) {
                    w.i("MicroMsg.AppBrandMusicClientService", "stop music ok");
                } else {
                    w.e("MicroMsg.AppBrandMusicClientService", "stop music fail");
                }
                SL();
            } else {
                w.i("MicroMsg.AppBrandMusicClientService", "appid not match cannot operate, can't not stop, preAppId:%s, appId:%s", new Object[]{str, this.appId});
                SL();
            }
        }

        public final void f(Parcel parcel) {
            this.appId = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
        }
    }

    private AppBrandMusicClientService() {
    }

    public final void hY(int i) {
        w.i("MicroMsg.AppBrandMusicClientService", "notifyAction, action:%d", new Object[]{Integer.valueOf(i)});
        for (Entry entry : this.jan.entrySet()) {
            if (entry != null) {
                String str = (String) entry.getKey();
                b bVar = (b) entry.getValue();
                if (!TextUtils.isEmpty(this.jap) && this.jap.equalsIgnoreCase(str)) {
                    w.i("MicroMsg.AppBrandMusicClientService", "current play music appId is %s", new Object[]{this.jap});
                    if (bVar != null) {
                        if (i == 10) {
                            bVar.QI();
                        } else if (i == 2) {
                            bVar.onStop();
                        }
                    }
                }
            }
        }
    }

    public static boolean pN(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return ((IPCBoolean) XIPCInvoker.a("com.tencent.mm", new IPCString(str), a.class)).value;
        } catch (Exception e) {
            w.e("MicroMsg.AppBrandMusicClientService", "isPlayingMusic ? %s, e = %s", new Object[]{str, e});
            return false;
        }
    }
}
