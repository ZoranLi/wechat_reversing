package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebviewRunCgi;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.agt;
import com.tencent.mm.protocal.c.agu;
import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ag extends a {
    public static final int CTRL_BYTE = -3;
    public static final String NAME = "preVerifyJSAPI";

    public final void a(final d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiPreVerify", "invoke");
        final String optString = jSONObject.optString("verifyAppId");
        String optString2 = jSONObject.optString("verifySignature");
        String optString3 = jSONObject.optString("verifyNonceStr");
        String optString4 = jSONObject.optString("verifyTimestamp");
        String optString5 = jSONObject.optString("verifySignType");
        JSONArray optJSONArray = jSONObject.optJSONArray("verifyJsApiList");
        w.i("MicroMsg.GameJsApiPreVerify", "appid : %s, %s, %s, %s, %s", new Object[]{optString, optString2, optString3, optString4, optString5});
        String azN = dVar.azN();
        LinkedList linkedList = new LinkedList();
        try {
            w.i("MicroMsg.GameJsApiPreVerify", "jsItem length %s", new Object[]{Integer.valueOf(optJSONArray.length())});
            if (optJSONArray.length() == 0) {
                dVar.x(i, "checkJsApi:param is empty");
                return;
            }
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                String string = optJSONArray.getString(i2);
                if (!bg.mA(string)) {
                    linkedList.add(string);
                }
            }
            if (bg.mA(optString) || linkedList.size() <= 0 || bg.mA(azN)) {
                w.e("MicroMsg.GameJsApiPreVerify", "handlePreVerify wrong args, %s", new Object[]{optString});
                dVar.x(i, a.d("pre_verify_jsapi:fail_invalid_args", null));
                return;
            }
            b.a aVar = new b.a();
            aVar.hsm = new agt();
            aVar.hsn = new agu();
            aVar.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
            aVar.hsl = 1093;
            aVar.hso = 0;
            aVar.hsp = 0;
            b BE = aVar.BE();
            agt com_tencent_mm_protocal_c_agt = (agt) BE.hsj.hsr;
            com_tencent_mm_protocal_c_agt.url = azN;
            com_tencent_mm_protocal_c_agt.fTO = optString;
            com_tencent_mm_protocal_c_agt.tLC = linkedList;
            com_tencent_mm_protocal_c_agt.lUw = optString4;
            com_tencent_mm_protocal_c_agt.tLo = optString3;
            com_tencent_mm_protocal_c_agt.signature = optString2;
            com_tencent_mm_protocal_c_agt.tLp = optString5;
            final int i3 = i;
            GameWebviewRunCgi.a(BE, new GameWebviewRunCgi.a(this) {
                final /* synthetic */ ag mkN;

                public final void a(int i, int i2, String str, b bVar) {
                    d dVar;
                    int i3;
                    ag agVar;
                    if (i == 0 && i2 == 0) {
                        agu com_tencent_mm_protocal_c_agu = (agu) bVar.hsk.hsr;
                        if (com_tencent_mm_protocal_c_agu == null || com_tencent_mm_protocal_c_agu.tLs == null || com_tencent_mm_protocal_c_agu.tLs.fIz != 0) {
                            dVar = dVar;
                            i3 = i3;
                            agVar = this.mkN;
                            dVar.x(i3, a.d("pre_verify_jsapi:fail_" + str, null));
                            return;
                        }
                        d dVar2 = dVar;
                        String str2 = optString;
                        if (!(bg.mA(str2) || bg.mA(dVar2.azN()))) {
                            dVar2.mni.put(d.xI(dVar2.azN()), str2);
                        }
                        c.d dVar3 = new c.d();
                        dVar3.appId = optString;
                        dVar3.sjK = com_tencent_mm_protocal_c_agu.tLF;
                        d dVar4 = dVar;
                        if (!bg.mA(dVar4.azN())) {
                            dVar4.mnj.put(dVar4.azN(), dVar3);
                        }
                        Object obj = com_tencent_mm_protocal_c_agu.tLE;
                        dVar = dVar;
                        JsapiPermissionWrapper JN = dVar.mmH != null ? dVar.mmH.JN(dVar.azN()) : null;
                        if (JN != null) {
                            if (!bg.bV(obj)) {
                                Iterator it = obj.iterator();
                                while (it.hasNext()) {
                                    biy com_tencent_mm_protocal_c_biy = (biy) it.next();
                                    com.tencent.mm.plugin.game.gamewebview.jsapi.c cVar = (com.tencent.mm.plugin.game.gamewebview.jsapi.c) com.tencent.mm.plugin.game.gamewebview.jsapi.d.azm().get(com_tencent_mm_protocal_c_biy.tLm);
                                    if (!(cVar == null || JN.xX(cVar.azi()) == com_tencent_mm_protocal_c_biy.state)) {
                                        JN.a(cVar.azi(), (byte) com_tencent_mm_protocal_c_biy.state);
                                    }
                                }
                            }
                            dVar = dVar;
                            i3 = i3;
                            agVar = this.mkN;
                            dVar.x(i3, a.d("pre_verify_jsapi:ok", null));
                            return;
                        }
                        return;
                    }
                    w.e("MicroMsg.GameJsApiPreVerify", "errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    dVar = dVar;
                    i3 = i3;
                    agVar = this.mkN;
                    dVar.x(i3, a.d("pre_verify_jsapi:fail_" + str, null));
                }
            });
        } catch (Exception e) {
            w.w("MicroMsg.GameJsApiPreVerify", "exception occur " + e.getMessage());
            dVar.x(i, "pre_verify_jsapi:fail");
        }
    }
}
