package com.tencent.mm.plugin.appbrand.jsapi.h;

import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.g.m;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.plugin.appbrand.widget.picker.YANumberPicker;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 257;
    private static final String NAME = "showMultiPickerView";

    private static final class a extends com.tencent.mm.plugin.appbrand.jsapi.e {
        private static final int CTRL_INDEX = 259;
        private static final String NAME = "onMultiPickerViewChange";
    }

    private final class b extends c implements Runnable {
        private final AtomicReference<com.tencent.mm.plugin.appbrand.widget.picker.d.a[]> iUp = new AtomicReference();
        final /* synthetic */ e iUq;

        public b(e eVar) {
            this.iUq = eVar;
        }

        final void k(JSONObject jSONObject) {
            JSONArray optJSONArray = jSONObject.optJSONArray("array");
            JSONArray optJSONArray2 = jSONObject.optJSONArray("current");
            if (optJSONArray == null || optJSONArray2 == null || optJSONArray.length() != optJSONArray2.length()) {
                e("fail:invalid data", null);
            } else if (optJSONArray.length() <= 0) {
                e("fail empty range", null);
            } else {
                try {
                    Object obj = new com.tencent.mm.plugin.appbrand.widget.picker.d.a[optJSONArray.length()];
                    int i = 1;
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        int i3;
                        JSONArray jSONArray = optJSONArray.getJSONArray(i2);
                        int i4 = optJSONArray2.getInt(i2);
                        String[] strArr = new String[jSONArray.length()];
                        for (i3 = 0; i3 < strArr.length; i3++) {
                            strArr[i3] = jSONArray.getString(i3);
                        }
                        obj[i2] = new com.tencent.mm.plugin.appbrand.widget.picker.d.a(strArr, i4);
                        if (jSONArray.length() <= 0) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        i &= i3;
                    }
                    if (i != 0) {
                        e("fail empty range", null);
                        return;
                    }
                    this.iUp.set(obj);
                    d.runOnUiThread(this);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.JsApiShowMultiPickerView", e, "opt params", new Object[0]);
                    e("fail:invalid data", null);
                }
            }
        }

        public final void run() {
            com.tencent.mm.plugin.appbrand.widget.picker.d dVar = (com.tencent.mm.plugin.appbrand.widget.picker.d) q(com.tencent.mm.plugin.appbrand.widget.picker.d.class);
            if (dVar == null) {
                e("fail cant init view", null);
                return;
            }
            com.tencent.mm.plugin.appbrand.widget.picker.d.a[] aVarArr = (com.tencent.mm.plugin.appbrand.widget.picker.d.a[]) this.iUp.get();
            if (aVarArr == null || aVarArr.length <= 0) {
                e("fail error data", null);
                return;
            }
            if (aVarArr != null && aVarArr.length > 0) {
                int ZG = dVar.ZG();
                dVar.S(true);
                if (ZG < aVarArr.length) {
                    ZG = aVarArr.length - ZG;
                    if (ZG > 0) {
                        for (int i = ZG; i > 0; i--) {
                            View anonymousClass2 = new com.tencent.mm.plugin.appbrand.widget.picker.d.AnonymousClass2(dVar, dVar.getContext());
                            anonymousClass2.jzO = dVar.jyv;
                            String str = "end";
                            String[] strArr = new String[]{"end", "middle", "start"};
                            for (ZG = 0; ZG < 3; ZG++) {
                                if (strArr[ZG].equals(str)) {
                                    anonymousClass2.jzs = str;
                                    break;
                                }
                            }
                            anonymousClass2.jzs = "end";
                            anonymousClass2.setDividerHeight(com.tencent.mm.bg.a.fromDPToPix(dVar.getContext(), 1));
                            anonymousClass2.setTag(R.h.bpj, Integer.valueOf(dVar.jyt.getChildCount()));
                            dVar.jyt.addView(anonymousClass2, new LayoutParams(0, -1, 1.0f));
                        }
                    }
                } else if (ZG > aVarArr.length) {
                    dVar.ja(ZG - aVarArr.length);
                }
                for (ZG = 0; ZG < aVarArr.length; ZG++) {
                    YANumberPicker iZ = dVar.iZ(ZG);
                    com.tencent.mm.plugin.appbrand.widget.picker.d.a aVar = aVarArr[ZG];
                    iZ.h(aVar.jyx);
                    iZ.setValue(aVar.jyy);
                    iZ.jzO = dVar.jyv;
                }
                dVar.jyt.setWeightSum((float) dVar.ZG());
                dVar.S(false);
            }
            this.jyg.jyG = new com.tencent.mm.plugin.appbrand.widget.picker.g.a<int[]>(this) {
                final /* synthetic */ b iUr;

                {
                    this.iUr = r1;
                }

                public final /* synthetic */ void c(boolean z, Object obj) {
                    int[] iArr = (int[]) obj;
                    this.iUr.jyg.hide();
                    if (!z) {
                        this.iUr.e("cancel", null);
                    } else if (iArr == null || iArr.length <= 0) {
                        this.iUr.e("fail error result", null);
                    } else {
                        JSONArray jSONArray = new JSONArray();
                        for (int put : iArr) {
                            jSONArray.put(put);
                        }
                        Map hashMap = new HashMap(1);
                        hashMap.put("current", jSONArray);
                        this.iUr.e("ok", hashMap);
                    }
                }
            };
            this.jyg.jyI = new com.tencent.mm.plugin.appbrand.widget.picker.g.b<int[]>(this) {
                final /* synthetic */ b iUr;

                {
                    this.iUr = r1;
                }

                public final /* synthetic */ void aK(Object obj) {
                    int[] iArr = (int[]) obj;
                    int i = iArr[0];
                    int i2 = iArr[1];
                    com.tencent.mm.plugin.appbrand.jsapi.e aVar = new a();
                    Map hashMap = new HashMap(2);
                    hashMap.put("errMsg", "ok");
                    hashMap.put("column", Integer.valueOf(i));
                    hashMap.put("current", Integer.valueOf(i2));
                    aVar.q(hashMap);
                    c cVar = this.iUr;
                    if (cVar.iNd == null) {
                        c cVar2 = null;
                    } else {
                        m mVar = (m) cVar.iNd.get();
                    }
                    if (cVar2 != null) {
                        aVar.a(cVar2).g(new int[]{cVar2.hashCode()});
                    }
                }
            };
            this.jyg.show();
        }
    }

    public final void a(m mVar, JSONObject jSONObject, int i) {
        new b(this).a(this, mVar, jSONObject, i);
    }
}
