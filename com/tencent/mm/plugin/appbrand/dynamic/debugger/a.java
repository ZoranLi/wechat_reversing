package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Bundle;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.ArrayList;

public final class a {
    private static com.tencent.mm.plugin.appbrand.dynamic.core.MiniJsBridge.a iHL = new com.tencent.mm.plugin.appbrand.dynamic.core.MiniJsBridge.a() {
        public final void ab(String str, int i) {
            Bundle bundle = new Bundle();
            bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
            bundle.putInt(DownloadInfo.STATUS, i);
            e.a("com.tencent.mm", bundle, a.class, null);
        }
    };

    private static class a implements com.tencent.mm.ipcinvoker.a {
        private a() {
        }

        public final void a(Bundle bundle, c cVar) {
            b.ab(bundle.getString(SlookAirButtonFrequentContactAdapter.ID), bundle.getInt(DownloadInfo.STATUS));
        }
    }

    private static class b implements com.tencent.mm.ipcinvoker.a {
        private b() {
        }

        public final void a(Bundle bundle, c cVar) {
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("logList");
            if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
                w.i("MicroMsg.WidgetDebugIPCBridge", "logList is null or nil.");
            } else {
                b.a(bundle.getString(SlookAirButtonFrequentContactAdapter.ID), parcelableArrayList);
            }
        }
    }

    public static void a(String str, ArrayList<LogInfo> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putString(SlookAirButtonFrequentContactAdapter.ID, str);
        bundle.putParcelableArrayList("logList", arrayList);
        e.a("com.tencent.mm", bundle, b.class, null);
    }

    public static com.tencent.mm.plugin.appbrand.dynamic.core.MiniJsBridge.a Se() {
        return iHL;
    }
}
