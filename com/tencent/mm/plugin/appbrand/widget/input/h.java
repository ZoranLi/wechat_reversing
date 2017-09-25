package com.tencent.mm.plugin.appbrand.widget.input;

import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.g.m.c;
import com.tencent.mm.plugin.appbrand.jsapi.d.e.b;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h {
    public final Map<String, b> jtl = new HashMap();

    private static final class a {
        public static final h jtq = new h();
    }

    class AnonymousClass1 implements c {
        final /* synthetic */ String iSw;
        final /* synthetic */ h jtm;

        public AnonymousClass1(h hVar, String str) {
            this.jtm = hVar;
            this.iSw = str;
        }

        public final void onDestroy() {
            d.runOnUiThread(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 jtn;

                {
                    this.jtn = r1;
                }

                public final void run() {
                    this.jtn.jtm.jtl.remove(this.jtn.iSw);
                }
            });
        }
    }

    class AnonymousClass2 implements z {
        final /* synthetic */ WeakReference iSA;
        final /* synthetic */ String iSw;
        final /* synthetic */ h jtm;
        final /* synthetic */ String jto;

        public AnonymousClass2(h hVar, WeakReference weakReference, String str, String str2) {
            this.jtm = hVar;
            this.iSA = weakReference;
            this.iSw = str;
            this.jto = str2;
        }

        public final void a(String str, int i, com.tencent.mm.plugin.appbrand.widget.input.z.a aVar) {
            try {
                m mVar = (m) this.iSA.get();
                if (mVar != null) {
                    JSONObject put = new JSONObject().put(Columns.VALUE, str).put("inputId", this.iSw).put("cursor", i);
                    if (com.tencent.mm.plugin.appbrand.widget.input.z.a.CHANGED.equals(aVar)) {
                        e bVar = new b();
                        bVar.ad(mVar.ivH, mVar.hashCode());
                        bVar.mData = put.put(SlookAirButtonFrequentContactAdapter.DATA, this.jto).toString();
                        bVar.SR();
                        return;
                    }
                    String str2;
                    switch (aVar) {
                        case COMPLETE:
                            str2 = "onKeyboardComplete";
                            break;
                        case CONFIRM:
                            str2 = "onKeyboardConfirm";
                            break;
                        default:
                            str2 = null;
                            break;
                    }
                    if (!bg.mA(str2)) {
                        mVar.f(str2, put.toString(), 0);
                    }
                }
            } catch (Exception e) {
            }
        }
    }
}
