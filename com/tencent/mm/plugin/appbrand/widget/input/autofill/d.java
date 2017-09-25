package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.EditText;
import android.widget.ListAdapter;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.d.e;
import com.tencent.mm.plugin.appbrand.widget.input.a.a.a;
import com.tencent.mm.plugin.appbrand.widget.input.y;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class d {
    public static <Input extends EditText & y> void a(m mVar, Input input, a aVar) {
        if (((y) input).YQ()) {
            final WeakReference weakReference = new WeakReference(mVar);
            final WeakReference weakReference2 = new WeakReference(input);
            h anonymousClass1 = new h() {
                public final void a(String str, h.a aVar) {
                    EditText editText = (EditText) weakReference2.get();
                    m mVar = (m) weakReference.get();
                    if (editText != null && mVar != null) {
                        String Yi = ((y) editText).Yi();
                        if (!bg.mA(Yi)) {
                            e.a aVar2 = new e.a();
                            Map hashMap = new HashMap();
                            hashMap.put(SlookAirButtonFrequentContactAdapter.ID, str);
                            hashMap.put(Columns.TYPE, aVar.name().toLowerCase());
                            hashMap.put("inputId", Yi);
                            aVar2.ad(mVar.ivH, mVar.hashCode()).q(hashMap).g(new int[]{mVar.hashCode()});
                        }
                    }
                }
            };
            b Zi = ((y) input).Zi();
            Zi.jwb = new a(Zi.jvV.getContext(), aVar.jwH);
            Zi.jwb.jvO = Zi.jvZ;
            AutoFillListPopupWindowBase autoFillListPopupWindowBase = Zi.jvW;
            ListAdapter listAdapter = Zi.jwb;
            if (autoFillListPopupWindowBase.mObserver == null) {
                autoFillListPopupWindowBase.mObserver = new c();
            } else if (autoFillListPopupWindowBase.FA != null) {
                autoFillListPopupWindowBase.FA.unregisterDataSetObserver(autoFillListPopupWindowBase.mObserver);
            }
            autoFillListPopupWindowBase.FA = listAdapter;
            if (autoFillListPopupWindowBase.FA != null) {
                listAdapter.registerDataSetObserver(autoFillListPopupWindowBase.mObserver);
            }
            if (autoFillListPopupWindowBase.jwq != null) {
                autoFillListPopupWindowBase.jwq.setAdapter(autoFillListPopupWindowBase.FA);
            }
            Zi.jvZ.jwh = anonymousClass1;
            int i = "screen".equalsIgnoreCase(aVar.jwG) ? f.jwx : f.jwy;
            if (i != 0) {
                Zi.jwa = i;
            }
            Zi.Zu();
        }
    }
}
