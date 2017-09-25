package com.tencent.mm.plugin.appbrand.jsapi.video;

import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import org.json.JSONObject;

public final class b extends c {
    private static final int CTRL_INDEX = 114;
    public static final String NAME = "operateVideoPlayer";

    protected final int h(JSONObject jSONObject) {
        return jSONObject.optInt("videoPlayerId");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean a(com.tencent.mm.plugin.appbrand.g.m r8, int r9, android.view.View r10, org.json.JSONObject r11) {
        /*
        r7 = this;
        r3 = -1;
        r1 = 1;
        r0 = 0;
        r2 = "MicroMsg.JsApiOperateVideoPlayer";
        r4 = "onUpdateView : videoPlayerId=%d";
        r5 = new java.lang.Object[r1];
        r6 = java.lang.Integer.valueOf(r9);
        r5[r0] = r6;
        com.tencent.mm.sdk.platformtools.w.i(r2, r4, r5);
        r2 = r10 instanceof com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
        if (r2 != 0) goto L_0x0022;
    L_0x0018:
        r1 = "MicroMsg.JsApiOperateVideoPlayer";
        r2 = "view not AppBrandVideoView";
        com.tencent.mm.sdk.platformtools.w.e(r1, r2);
    L_0x0021:
        return r0;
    L_0x0022:
        r2 = "type";
        r4 = r11.optString(r2);
        r2 = "MicroMsg.JsApiOperateVideoPlayer";
        r5 = "onUpdateView operateType=%s";
        r6 = new java.lang.Object[r1];
        r6[r0] = r4;
        com.tencent.mm.sdk.platformtools.w.i(r2, r5, r6);
        r10 = (com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView) r10;
        r2 = r4.hashCode();
        switch(r2) {
            case -802181223: goto L_0x007d;
            case 1222225: goto L_0x009e;
            case 3443508: goto L_0x0051;
            case 3526264: goto L_0x0093;
            case 3540994: goto L_0x0067;
            case 106440182: goto L_0x005c;
            case 458133450: goto L_0x0072;
            case 1355420059: goto L_0x0088;
            default: goto L_0x003f;
        };
    L_0x003f:
        r2 = r3;
    L_0x0040:
        switch(r2) {
            case 0: goto L_0x00a9;
            case 1: goto L_0x00af;
            case 2: goto L_0x00b3;
            case 3: goto L_0x00b7;
            case 4: goto L_0x00bb;
            case 5: goto L_0x00bf;
            case 6: goto L_0x0110;
            case 7: goto L_0x0148;
            default: goto L_0x0043;
        };
    L_0x0043:
        r2 = "MicroMsg.JsApiOperateVideoPlayer";
        r3 = "onUpdateView operateType not supported: %s";
        r1 = new java.lang.Object[r1];
        r1[r0] = r4;
        com.tencent.mm.sdk.platformtools.w.w(r2, r3, r1);
        goto L_0x0021;
    L_0x0051:
        r2 = "play";
        r2 = r4.equals(r2);
        if (r2 == 0) goto L_0x003f;
    L_0x005a:
        r2 = r0;
        goto L_0x0040;
    L_0x005c:
        r2 = "pause";
        r2 = r4.equals(r2);
        if (r2 == 0) goto L_0x003f;
    L_0x0065:
        r2 = r1;
        goto L_0x0040;
    L_0x0067:
        r2 = "stop";
        r2 = r4.equals(r2);
        if (r2 == 0) goto L_0x003f;
    L_0x0070:
        r2 = 2;
        goto L_0x0040;
    L_0x0072:
        r2 = "requestFullScreen";
        r2 = r4.equals(r2);
        if (r2 == 0) goto L_0x003f;
    L_0x007b:
        r2 = 3;
        goto L_0x0040;
    L_0x007d:
        r2 = "exitFullScreen";
        r2 = r4.equals(r2);
        if (r2 == 0) goto L_0x003f;
    L_0x0086:
        r2 = 4;
        goto L_0x0040;
    L_0x0088:
        r2 = "playbackRate";
        r2 = r4.equals(r2);
        if (r2 == 0) goto L_0x003f;
    L_0x0091:
        r2 = 5;
        goto L_0x0040;
    L_0x0093:
        r2 = "seek";
        r2 = r4.equals(r2);
        if (r2 == 0) goto L_0x003f;
    L_0x009c:
        r2 = 6;
        goto L_0x0040;
    L_0x009e:
        r2 = "sendDanmu";
        r2 = r4.equals(r2);
        if (r2 == 0) goto L_0x003f;
    L_0x00a7:
        r2 = 7;
        goto L_0x0040;
    L_0x00a9:
        r10.start();
    L_0x00ac:
        r0 = r1;
        goto L_0x0021;
    L_0x00af:
        r10.pause();
        goto L_0x00ac;
    L_0x00b3:
        r10.stop();
        goto L_0x00ac;
    L_0x00b7:
        r10.bT(r1);
        goto L_0x00ac;
    L_0x00bb:
        r10.bT(r0);
        goto L_0x00ac;
    L_0x00bf:
        r2 = "data";
        r2 = r11.optJSONArray(r2);
        if (r2 == 0) goto L_0x00ce;
    L_0x00c8:
        r3 = r2.length();
        if (r3 != 0) goto L_0x00d9;
    L_0x00ce:
        r1 = "MicroMsg.JsApiOperateVideoPlayer";
        r2 = "onUpdateView dataArr nil";
        com.tencent.mm.sdk.platformtools.w.w(r1, r2);
        goto L_0x0021;
    L_0x00d9:
        r4 = -4616189618054758400; // 0xbff0000000000000 float:0.0 double:-1.0;
        r2 = r2.optDouble(r0, r4);
        r4 = 0;
        r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r4 >= 0) goto L_0x00f8;
    L_0x00e5:
        r4 = "MicroMsg.JsApiOperateVideoPlayer";
        r5 = "rate invalid %f";
        r1 = new java.lang.Object[r1];
        r2 = java.lang.Double.valueOf(r2);
        r1[r0] = r2;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r1);
        goto L_0x0021;
    L_0x00f8:
        r2 = (float) r2;
        r3 = "MicroMsg.AppBrandVideoView";
        r4 = "setPlaybackRate %s";
        r5 = new java.lang.Object[r1];
        r6 = java.lang.Float.valueOf(r2);
        r5[r0] = r6;
        com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);
        r0 = r10.iWh;
        r0.N(r2);
        goto L_0x00ac;
    L_0x0110:
        r2 = "data";
        r2 = r11.optJSONArray(r2);
        if (r2 == 0) goto L_0x011f;
    L_0x0119:
        r4 = r2.length();
        if (r4 != 0) goto L_0x012a;
    L_0x011f:
        r1 = "MicroMsg.JsApiOperateVideoPlayer";
        r2 = "onUpdateView dataArr nil";
        com.tencent.mm.sdk.platformtools.w.w(r1, r2);
        goto L_0x0021;
    L_0x012a:
        r2 = r2.optInt(r0, r3);
        if (r2 >= 0) goto L_0x0143;
    L_0x0130:
        r3 = "MicroMsg.JsApiOperateVideoPlayer";
        r4 = "pos invalid %d";
        r1 = new java.lang.Object[r1];
        r2 = java.lang.Integer.valueOf(r2);
        r1[r0] = r2;
        com.tencent.mm.sdk.platformtools.w.i(r3, r4, r1);
        goto L_0x0021;
    L_0x0143:
        r10.z(r2, r0);
        goto L_0x00ac;
    L_0x0148:
        r2 = "data";
        r2 = r11.optJSONArray(r2);
        if (r2 == 0) goto L_0x0157;
    L_0x0151:
        r3 = r2.length();
        if (r3 != 0) goto L_0x0162;
    L_0x0157:
        r1 = "MicroMsg.JsApiOperateVideoPlayer";
        r2 = "onUpdateView dataArr nil";
        com.tencent.mm.sdk.platformtools.w.w(r1, r2);
        goto L_0x0021;
    L_0x0162:
        r3 = r2.length();
        if (r3 != r1) goto L_0x0177;
    L_0x0168:
        r3 = "";
        r0 = r2.optString(r0, r3);
        r2 = "";
        r10.aZ(r0, r2);
        goto L_0x00ac;
    L_0x0177:
        r3 = "";
        r0 = r2.optString(r0, r3);
        r3 = "";
        r2 = r2.optString(r1, r3);
        r10.aZ(r0, r2);
        goto L_0x00ac;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.video.b.a(com.tencent.mm.plugin.appbrand.g.m, int, android.view.View, org.json.JSONObject):boolean");
    }
}
