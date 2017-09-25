package com.tencent.mm.plugin.appbrand.jsapi.map;

import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.w;
import org.json.JSONObject;

public final class c extends com.tencent.mm.plugin.appbrand.jsapi.base.c {
    public static final int CTRL_INDEX = 140;
    public static final String NAME = "addMapControls";

    private static class a extends e {
        private static final int CTRL_INDEX = 143;
        private static final String NAME = "onMapControlClick";
    }

    protected final int h(JSONObject jSONObject) {
        int i = 0;
        try {
            i = jSONObject.optInt("mapId");
        } catch (Exception e) {
            w.e("MicroMsg.JsApiAddMapControls", "get mapId error, exception : %s", new Object[]{e});
        }
        return i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean a(final com.tencent.mm.plugin.appbrand.g.m r14, final int r15, android.view.View r16, org.json.JSONObject r17) {
        /*
        r13 = this;
        r1 = r14.jdc;
        r2 = 1;
        r2 = r1.B(r15, r2);
        if (r2 != 0) goto L_0x001e;
    L_0x0009:
        r1 = "MicroMsg.JsApiAddMapControls";
        r2 = "KeyValueSet(%s) is null.";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r5 = java.lang.Integer.valueOf(r15);
        r3[r4] = r5;
        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
        r1 = 0;
    L_0x001d:
        return r1;
    L_0x001e:
        r1 = "controls";
        r0 = r17;
        r1 = r0.has(r1);	 Catch:{ Exception -> 0x0158 }
        if (r1 == 0) goto L_0x016b;
    L_0x0029:
        r1 = "map_controls";
        r1 = r2.fS(r1);	 Catch:{ Exception -> 0x0158 }
        r1 = (java.util.List) r1;	 Catch:{ Exception -> 0x0158 }
        if (r1 != 0) goto L_0x0174;
    L_0x0034:
        r1 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0158 }
        r1.<init>();	 Catch:{ Exception -> 0x0158 }
        r3 = "map_controls";
        r2.l(r3, r1);	 Catch:{ Exception -> 0x0158 }
        r5 = r1;
    L_0x0040:
        r1 = r5.size();	 Catch:{ Exception -> 0x0158 }
        if (r1 <= 0) goto L_0x0060;
    L_0x0046:
        r1 = 0;
        r2 = r1;
    L_0x0048:
        r1 = r5.size();	 Catch:{ Exception -> 0x0158 }
        if (r2 >= r1) goto L_0x005d;
    L_0x004e:
        r1 = r5.get(r2);	 Catch:{ Exception -> 0x0158 }
        r1 = (android.widget.ImageView) r1;	 Catch:{ Exception -> 0x0158 }
        r3 = 8;
        r1.setVisibility(r3);	 Catch:{ Exception -> 0x0158 }
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x0048;
    L_0x005d:
        r5.clear();	 Catch:{ Exception -> 0x0158 }
    L_0x0060:
        r6 = new org.json.JSONArray;	 Catch:{ Exception -> 0x0158 }
        r1 = "controls";
        r0 = r17;
        r1 = r0.optString(r1);	 Catch:{ Exception -> 0x0158 }
        r6.<init>(r1);	 Catch:{ Exception -> 0x0158 }
        r1 = 0;
        r4 = r1;
    L_0x0070:
        r1 = r6.length();	 Catch:{ Exception -> 0x0158 }
        if (r4 >= r1) goto L_0x016b;
    L_0x0076:
        r1 = r6.get(r4);	 Catch:{ Exception -> 0x0158 }
        r1 = (org.json.JSONObject) r1;	 Catch:{ Exception -> 0x0158 }
        r2 = "iconPath";
        r3 = r1.optString(r2);	 Catch:{ Exception -> 0x0158 }
        r2 = "clickable";
        r7 = r1.optBoolean(r2);	 Catch:{ Exception -> 0x0158 }
        r2 = "data";
        r8 = r1.optString(r2);	 Catch:{ Exception -> 0x0158 }
        r2 = "position";
        r9 = r1.getJSONObject(r2);	 Catch:{ JSONException -> 0x012a }
        r2 = 0;
        r1 = 0;
        r10 = new android.widget.ImageView;	 Catch:{ Exception -> 0x0158 }
        r11 = r16.getContext();	 Catch:{ Exception -> 0x0158 }
        r10.<init>(r11);	 Catch:{ Exception -> 0x0158 }
        r11 = "wxfile://";
        r11 = r3.startsWith(r11);	 Catch:{ Exception -> 0x0158 }
        if (r11 == 0) goto L_0x013d;
    L_0x00ac:
        r11 = r14.ivH;	 Catch:{ Exception -> 0x0158 }
        r3 = com.tencent.mm.plugin.appbrand.appstorage.c.aH(r11, r3);	 Catch:{ Exception -> 0x0158 }
        if (r3 == 0) goto L_0x00c6;
    L_0x00b4:
        r1 = r3.hos;	 Catch:{ Exception -> 0x0158 }
        r2 = 0;
        r2 = com.tencent.mm.sdk.platformtools.d.decodeFile(r1, r2);	 Catch:{ Exception -> 0x0158 }
        r10.setImageBitmap(r2);	 Catch:{ Exception -> 0x0158 }
        r1 = r2.getHeight();	 Catch:{ Exception -> 0x0158 }
        r2 = r2.getWidth();	 Catch:{ Exception -> 0x0158 }
    L_0x00c6:
        r3 = "width";
        r3 = r9.has(r3);	 Catch:{ Exception -> 0x0158 }
        if (r3 == 0) goto L_0x0171;
    L_0x00cf:
        r2 = "width";
        r3 = 0;
        r2 = com.tencent.mm.plugin.appbrand.m.h.a(r9, r2, r3);	 Catch:{ Exception -> 0x0158 }
        r3 = r2;
    L_0x00d8:
        r2 = "height";
        r2 = r9.has(r2);	 Catch:{ Exception -> 0x0158 }
        if (r2 == 0) goto L_0x016e;
    L_0x00e1:
        r1 = "height";
        r2 = 0;
        r1 = com.tencent.mm.plugin.appbrand.m.h.a(r9, r1, r2);	 Catch:{ Exception -> 0x0158 }
        r2 = r1;
    L_0x00ea:
        r1 = "top";
        r11 = 0;
        r11 = com.tencent.mm.plugin.appbrand.m.h.a(r9, r1, r11);	 Catch:{ Exception -> 0x0158 }
        r1 = "left";
        r12 = 0;
        r9 = com.tencent.mm.plugin.appbrand.m.h.a(r9, r1, r12);	 Catch:{ Exception -> 0x0158 }
        r0 = r16;
        r0 = (android.widget.FrameLayout) r0;	 Catch:{ Exception -> 0x0158 }
        r1 = r0;
        r12 = new android.widget.FrameLayout$LayoutParams;	 Catch:{ Exception -> 0x0158 }
        r12.<init>(r3, r2);	 Catch:{ Exception -> 0x0158 }
        r2 = 0;
        r3 = 0;
        r12.setMargins(r9, r11, r2, r3);	 Catch:{ Exception -> 0x0158 }
        r1.addView(r10, r12);	 Catch:{ Exception -> 0x0158 }
        r5.add(r10);	 Catch:{ Exception -> 0x0158 }
        if (r7 == 0) goto L_0x0125;
    L_0x0111:
        r1 = new com.tencent.mm.plugin.appbrand.jsapi.map.c$1;	 Catch:{ Exception -> 0x0158 }
        r1.<init>(r13, r10);	 Catch:{ Exception -> 0x0158 }
        r10.setOnTouchListener(r1);	 Catch:{ Exception -> 0x0158 }
        r1 = 1;
        r10.setClickable(r1);	 Catch:{ Exception -> 0x0158 }
        r1 = new com.tencent.mm.plugin.appbrand.jsapi.map.c$2;	 Catch:{ Exception -> 0x0158 }
        r1.<init>(r13, r15, r8, r14);	 Catch:{ Exception -> 0x0158 }
        r10.setOnClickListener(r1);	 Catch:{ Exception -> 0x0158 }
    L_0x0125:
        r1 = r4 + 1;
        r4 = r1;
        goto L_0x0070;
    L_0x012a:
        r1 = move-exception;
        r2 = "MicroMsg.JsApiAddMapControls";
        r3 = "parse position error, exception : %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0158 }
        r5 = 0;
        r4[r5] = r1;	 Catch:{ Exception -> 0x0158 }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ Exception -> 0x0158 }
        r1 = 0;
        goto L_0x001d;
    L_0x013d:
        r11 = r14.ixr;	 Catch:{ Exception -> 0x0158 }
        r3 = com.tencent.mm.plugin.appbrand.g.l.g(r11, r3);	 Catch:{ Exception -> 0x0158 }
        if (r3 == 0) goto L_0x00c6;
    L_0x0145:
        r11 = r3.isRecycled();	 Catch:{ Exception -> 0x0158 }
        if (r11 != 0) goto L_0x00c6;
    L_0x014b:
        r10.setImageBitmap(r3);	 Catch:{ Exception -> 0x0158 }
        r1 = r3.getHeight();	 Catch:{ Exception -> 0x0158 }
        r2 = r3.getWidth();	 Catch:{ Exception -> 0x0158 }
        goto L_0x00c6;
    L_0x0158:
        r1 = move-exception;
        r2 = "MicroMsg.JsApiAddMapControls";
        r3 = "parse circles error, exception : %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r1;
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);
        r1 = 0;
        goto L_0x001d;
    L_0x016b:
        r1 = 1;
        goto L_0x001d;
    L_0x016e:
        r2 = r1;
        goto L_0x00ea;
    L_0x0171:
        r3 = r2;
        goto L_0x00d8;
    L_0x0174:
        r5 = r1;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.map.c.a(com.tencent.mm.plugin.appbrand.g.m, int, android.view.View, org.json.JSONObject):boolean");
    }
}
