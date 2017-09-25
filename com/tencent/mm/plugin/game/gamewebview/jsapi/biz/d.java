package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebviewRunCgi;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.webview.ui.tools.widget.e;
import com.tencent.mm.protocal.c.agz;
import com.tencent.mm.protocal.c.aha;
import com.tencent.mm.protocal.c.ahb;
import com.tencent.mm.protocal.c.ahc;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d extends a {
    public static final int CTRL_BYTE = 232;
    public static final String NAME = "authorize";

    class AnonymousClass2 implements GameWebviewRunCgi.a {
        final /* synthetic */ int iHi;
        final /* synthetic */ int iQW;
        final /* synthetic */ com.tencent.mm.plugin.game.gamewebview.ui.d mjZ;
        final /* synthetic */ d mke;

        AnonymousClass2(d dVar, com.tencent.mm.plugin.game.gamewebview.ui.d dVar2, int i, int i2) {
            this.mke = dVar;
            this.mjZ = dVar2;
            this.iHi = i;
            this.iQW = i2;
        }

        public final void a(int i, int i2, String str, b bVar) {
            w.i("MicroMsg.GameJsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            com.tencent.mm.plugin.game.gamewebview.ui.d dVar;
            int i3;
            d dVar2;
            if (i != 0 || i2 != 0) {
                dVar = this.mjZ;
                i3 = this.iHi;
                dVar2 = this.mke;
                dVar.x(i3, a.d("authorizefail", null));
            } else if (this.iQW == 2) {
                w.d("MicroMsg.GameJsApiAuthorize", "press reject button");
                dVar = this.mjZ;
                i3 = this.iHi;
                dVar2 = this.mke;
                dVar.x(i3, a.d("authorizefail", null));
            } else {
                aha com_tencent_mm_protocal_c_aha = (aha) bVar.hsk.hsr;
                if (com_tencent_mm_protocal_c_aha == null || com_tencent_mm_protocal_c_aha.tLL == null) {
                    dVar = this.mjZ;
                    i3 = this.iHi;
                    dVar2 = this.mke;
                    dVar.x(i3, a.d("authorizefail", null));
                    return;
                }
                i3 = com_tencent_mm_protocal_c_aha.tLL.fIz;
                String str2 = com_tencent_mm_protocal_c_aha.tLL.fIA;
                w.i("MicroMsg.GameJsApiAuthorize", "jsErrcode = %d", new Object[]{Integer.valueOf(i3)});
                if (i3 == 0) {
                    dVar = this.mjZ;
                    i3 = this.iHi;
                    dVar2 = this.mke;
                    dVar.x(i3, a.d("authorizeok", null));
                    return;
                }
                w.e("MicroMsg.GameJsApiAuthorize", "ERROR = %s", new Object[]{str2});
                dVar = this.mjZ;
                i3 = this.iHi;
                dVar2 = this.mke;
                dVar.x(i3, a.d("authorizefail", null));
            }
        }
    }

    public final void a(com.tencent.mm.plugin.game.gamewebview.ui.d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiAuthorize", "invoke");
        final Context azK = dVar.azK();
        JSONArray optJSONArray = jSONObject.optJSONArray("scope");
        if (optJSONArray == null) {
            w.e("MicroMsg.GameJsApiAuthorize", "scope is null!");
            dVar.x(i, a.d("authorize:fail", null));
            return;
        }
        final String azO = dVar.azO();
        if (bg.mA(azO)) {
            w.e("MicroMsg.GameJsApiAuthorize", "appId is null!");
            dVar.x(i, a.d("authorize:fail", null));
            return;
        }
        LinkedList linkedList = new LinkedList();
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            linkedList.add(optJSONArray.optString(i2));
        }
        b.a aVar = new b.a();
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_ahb = new ahb();
        aVar.hsm = com_tencent_mm_protocal_c_ahb;
        aVar.hsn = new ahc();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize";
        aVar.hsl = 1157;
        aVar.hso = 0;
        aVar.hsp = 0;
        com_tencent_mm_protocal_c_ahb.mtb = azO;
        com_tencent_mm_protocal_c_ahb.tLH = linkedList;
        com_tencent_mm_protocal_c_ahb.tLJ = 0;
        final com.tencent.mm.plugin.game.gamewebview.ui.d dVar2 = dVar;
        final int i3 = i;
        GameWebviewRunCgi.a(aVar.BE(), new GameWebviewRunCgi.a(this) {
            final /* synthetic */ d mke;

            public final void a(int i, int i2, String str, b bVar) {
                w.i("MicroMsg.GameJsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                com.tencent.mm.plugin.game.gamewebview.ui.d dVar;
                int i3;
                d dVar2;
                if (i == 0 && i2 == 0) {
                    ahc com_tencent_mm_protocal_c_ahc = (ahc) bVar.hsk.hsr;
                    if (com_tencent_mm_protocal_c_ahc == null || com_tencent_mm_protocal_c_ahc.tLL == null) {
                        dVar = dVar2;
                        i3 = i3;
                        dVar2 = this.mke;
                        dVar.x(i3, a.d("authorize:fail", null));
                        return;
                    }
                    i3 = com_tencent_mm_protocal_c_ahc.tLL.fIz;
                    String str2 = com_tencent_mm_protocal_c_ahc.tLL.fIA;
                    w.i("MicroMsg.GameJsApiAuthorize", "jsErrcode = %d", new Object[]{Integer.valueOf(i3)});
                    if (i3 == -12000) {
                        final LinkedList linkedList = com_tencent_mm_protocal_c_ahc.tBL;
                        str2 = com_tencent_mm_protocal_c_ahc.muS;
                        final String str3 = com_tencent_mm_protocal_c_ahc.tee;
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 mkh;

                            public final void run() {
                                e eVar = new e(azK);
                                e.a anonymousClass1 = new e.a(this) {
                                    final /* synthetic */ AnonymousClass1 mki;

                                    {
                                        this.mki = r1;
                                    }

                                    public final void c(int i, Bundle bundle) {
                                        w.i("MicroMsg.GameJsApiAuthorize", "stev onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
                                        com.tencent.mm.plugin.game.gamewebview.ui.d dVar;
                                        int i2;
                                        d dVar2;
                                        switch (i) {
                                            case 1:
                                            case 2:
                                                d dVar3 = this.mki.mkh.mke;
                                                com.tencent.mm.plugin.game.gamewebview.ui.d dVar4 = dVar2;
                                                int i3 = i3;
                                                String str = azO;
                                                ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                                                LinkedList linkedList = new LinkedList();
                                                Iterator it = arrayList.iterator();
                                                while (it.hasNext()) {
                                                    linkedList.add((String) it.next());
                                                }
                                                b.a aVar = new b.a();
                                                com.tencent.mm.bd.a com_tencent_mm_protocal_c_agz = new agz();
                                                aVar.hsm = com_tencent_mm_protocal_c_agz;
                                                aVar.hsn = new aha();
                                                aVar.uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
                                                aVar.hsl = 1158;
                                                aVar.hso = 0;
                                                aVar.hsp = 0;
                                                com_tencent_mm_protocal_c_agz.mtb = str;
                                                com_tencent_mm_protocal_c_agz.tLH = linkedList;
                                                com_tencent_mm_protocal_c_agz.tLJ = 0;
                                                com_tencent_mm_protocal_c_agz.tLI = i;
                                                GameWebviewRunCgi.a(aVar.BE(), new AnonymousClass2(dVar3, dVar4, i3, i));
                                                if (i == 2) {
                                                    dVar = dVar2;
                                                    i2 = i3;
                                                    dVar2 = this.mki.mkh.mke;
                                                    dVar.x(i2, a.d("authorize:fail_auth_deny", null));
                                                    return;
                                                }
                                                return;
                                            default:
                                                w.d("MicroMsg.GameJsApiAuthorize", "press back button!");
                                                dVar = dVar2;
                                                i2 = i3;
                                                dVar2 = this.mki.mkh.mke;
                                                dVar.x(i2, a.d("authorize:fail_auth_cancel", null));
                                                return;
                                        }
                                    }
                                };
                                com.tencent.mm.plugin.game.gamewebview.ui.d dVar;
                                int i;
                                d dVar2;
                                if (linkedList == null || linkedList.size() <= 0) {
                                    w.e("MicroMsg.GameJsApiAuthorize", "scopeInfoList is empty!");
                                    dVar = dVar2;
                                    i = i3;
                                    dVar2 = this.mkh.mke;
                                    dVar.x(i, a.d("authorize:fail", null));
                                } else if (!eVar.a(linkedList, str2, str3, anonymousClass1)) {
                                    dVar = dVar2;
                                    i = i3;
                                    dVar2 = this.mkh.mke;
                                    dVar.x(i, a.d("authorize:fail", null));
                                }
                            }
                        });
                        return;
                    } else if (i3 == 0) {
                        dVar = dVar2;
                        i3 = i3;
                        dVar2 = this.mke;
                        dVar.x(i3, a.d("authorize:ok", null));
                        return;
                    } else {
                        w.e("MicroMsg.GameJsApiAuthorize", "ERROR = %s", new Object[]{str2});
                        dVar = dVar2;
                        i3 = i3;
                        dVar2 = this.mke;
                        dVar.x(i3, a.d("authorize:fail", null));
                        return;
                    }
                }
                dVar = dVar2;
                i3 = i3;
                dVar2 = this.mke;
                dVar.x(i3, a.d("authorize:fail", null));
            }
        });
    }
}
