package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameWebviewRunCgi;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.plugin.webview.ui.tools.widget.e;
import com.tencent.mm.protocal.c.ahd;
import com.tencent.mm.protocal.c.ahe;
import com.tencent.mm.protocal.c.ahf;
import com.tencent.mm.protocal.c.ahg;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public final class y extends a {
    public static final int CTRL_BYTE = 231;
    public static final String NAME = "login";

    class AnonymousClass2 implements GameWebviewRunCgi.a {
        final /* synthetic */ int iHi;
        final /* synthetic */ int iQW;
        final /* synthetic */ d mjZ;
        final /* synthetic */ y mkE;

        AnonymousClass2(y yVar, d dVar, int i, int i2) {
            this.mkE = yVar;
            this.mjZ = dVar;
            this.iHi = i;
            this.iQW = i2;
        }

        public final void a(int i, int i2, String str, b bVar) {
            w.i("MicroMsg.GameJsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            d dVar;
            int i3;
            y yVar;
            if (i != 0 || i2 != 0) {
                dVar = this.mjZ;
                i3 = this.iHi;
                yVar = this.mkE;
                dVar.x(i3, a.d("loginfail", null));
            } else if (this.iQW == 2) {
                w.d("MicroMsg.GameJsApiLogin", "press reject button");
                dVar = this.mjZ;
                i3 = this.iHi;
                yVar = this.mkE;
                dVar.x(i3, a.d("loginfail", null));
            } else {
                ahe com_tencent_mm_protocal_c_ahe = (ahe) bVar.hsk.hsr;
                if (com_tencent_mm_protocal_c_ahe == null || com_tencent_mm_protocal_c_ahe.tLL == null) {
                    dVar = this.mjZ;
                    i3 = this.iHi;
                    yVar = this.mkE;
                    dVar.x(i3, a.d("loginfail", null));
                    return;
                }
                i3 = com_tencent_mm_protocal_c_ahe.tLL.fIz;
                String str2 = com_tencent_mm_protocal_c_ahe.tLL.fIA;
                w.i("MicroMsg.GameJsApiLogin", "jsErrcode = %d", new Object[]{Integer.valueOf(i3)});
                y yVar2;
                if (i3 == 0) {
                    new HashMap().put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, com_tencent_mm_protocal_c_ahe.tLO);
                    d dVar2 = this.mjZ;
                    int i4 = this.iHi;
                    yVar2 = this.mkE;
                    dVar2.x(i4, a.d("loginok", null));
                    w.d("MicroMsg.GameJsApiLogin", "resp data code [%s]", new Object[]{r0});
                    return;
                }
                dVar = this.mjZ;
                i3 = this.iHi;
                yVar2 = this.mkE;
                dVar.x(i3, a.d("loginfail", null));
                w.e("MicroMsg.GameJsApiLogin", "errMsg = %s", new Object[]{str2});
            }
        }
    }

    public final void a(d dVar, JSONObject jSONObject, int i) {
        w.i("MicroMsg.GameJsApiLogin", "invoke");
        final Context azK = dVar.azK();
        LinkedList linkedList = new LinkedList();
        String str = "";
        String str2 = "";
        final String azO = dVar.azO();
        if (bg.mA(azO)) {
            w.e("MicroMsg.GameJsApiLogin", "appId is null!");
            dVar.x(i, a.d("login:fail", null));
            return;
        }
        b.a aVar = new b.a();
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_ahf = new ahf();
        aVar.hsm = com_tencent_mm_protocal_c_ahf;
        aVar.hsn = new ahg();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-login";
        aVar.hsl = 1029;
        aVar.hso = 0;
        aVar.hsp = 0;
        com_tencent_mm_protocal_c_ahf.mtb = azO;
        com_tencent_mm_protocal_c_ahf.tLH = linkedList;
        com_tencent_mm_protocal_c_ahf.tLM = 0;
        com_tencent_mm_protocal_c_ahf.msN = str2;
        com_tencent_mm_protocal_c_ahf.tLN = str;
        com_tencent_mm_protocal_c_ahf.tLJ = 0;
        b BE = aVar.BE();
        final d dVar2 = dVar;
        final int i2 = i;
        GameWebviewRunCgi.a(BE, new GameWebviewRunCgi.a(this) {
            final /* synthetic */ y mkE;

            public final void a(int i, int i2, String str, b bVar) {
                w.i("MicroMsg.GameJsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                d dVar;
                int i3;
                y yVar;
                if (i == 0 && i2 == 0) {
                    ahg com_tencent_mm_protocal_c_ahg = (ahg) bVar.hsk.hsr;
                    if (com_tencent_mm_protocal_c_ahg == null || com_tencent_mm_protocal_c_ahg.tLL == null) {
                        dVar = dVar2;
                        i3 = i2;
                        yVar = this.mkE;
                        dVar.x(i3, a.d("loginfail", null));
                        return;
                    }
                    i3 = com_tencent_mm_protocal_c_ahg.tLL.fIz;
                    String str2 = com_tencent_mm_protocal_c_ahg.tLL.fIA;
                    final String str3 = com_tencent_mm_protocal_c_ahg.tLN;
                    w.i("MicroMsg.GameJsApiLogin", "NetSceneJSLogin jsErrcode %d", new Object[]{Integer.valueOf(i3)});
                    if (i3 == -12000) {
                        final LinkedList linkedList = com_tencent_mm_protocal_c_ahg.tBL;
                        final String str4 = com_tencent_mm_protocal_c_ahg.muS;
                        final String str5 = com_tencent_mm_protocal_c_ahg.tee;
                        w.d("MicroMsg.GameJsApiLogin", "appName %s, appIconUrl %s", new Object[]{str4, str5});
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 mkG;

                            public final void run() {
                                e eVar = new e(azK);
                                e.a anonymousClass1 = new e.a(this) {
                                    final /* synthetic */ AnonymousClass1 mkH;

                                    {
                                        this.mkH = r1;
                                    }

                                    public final void c(int i, Bundle bundle) {
                                        w.i("MicroMsg.GameJsApiLogin", "onRevMsg resultCode %d", new Object[]{Integer.valueOf(i)});
                                        d dVar;
                                        int i2;
                                        y yVar;
                                        switch (i) {
                                            case 1:
                                            case 2:
                                                y yVar2 = this.mkH.mkG.mkE;
                                                d dVar2 = dVar2;
                                                int i3 = i2;
                                                String str = azO;
                                                String str2 = str3;
                                                ArrayList arrayList = (ArrayList) bundle.getSerializable("key_scope");
                                                LinkedList linkedList = new LinkedList();
                                                Iterator it = arrayList.iterator();
                                                while (it.hasNext()) {
                                                    linkedList.add((String) it.next());
                                                }
                                                b.a aVar = new b.a();
                                                com.tencent.mm.bd.a com_tencent_mm_protocal_c_ahd = new ahd();
                                                aVar.hsm = com_tencent_mm_protocal_c_ahd;
                                                aVar.hsn = new ahe();
                                                aVar.uri = "/cgi-bin/mmbiz-bin/js-login-confirm";
                                                aVar.hsl = 1117;
                                                aVar.hso = 0;
                                                aVar.hsp = 0;
                                                com_tencent_mm_protocal_c_ahd.mtb = str;
                                                com_tencent_mm_protocal_c_ahd.tLH = linkedList;
                                                com_tencent_mm_protocal_c_ahd.tLM = 0;
                                                com_tencent_mm_protocal_c_ahd.tLN = str2;
                                                com_tencent_mm_protocal_c_ahd.tLJ = 0;
                                                com_tencent_mm_protocal_c_ahd.tLI = i;
                                                GameWebviewRunCgi.a(aVar.BE(), new AnonymousClass2(yVar2, dVar2, i3, i));
                                                if (i == 2) {
                                                    w.e("MicroMsg.GameJsApiLogin", "fail auth deny!");
                                                    dVar = dVar2;
                                                    i2 = i2;
                                                    yVar = this.mkH.mkG.mkE;
                                                    dVar.x(i2, a.d("loginfail_auth_deny", null));
                                                    return;
                                                }
                                                return;
                                            default:
                                                w.i("MicroMsg.GameJsApiLogin", "press back button!");
                                                dVar = dVar2;
                                                i2 = i2;
                                                yVar = this.mkH.mkG.mkE;
                                                dVar.x(i2, a.d("loginfail_auth_cancel", null));
                                                return;
                                        }
                                    }
                                };
                                d dVar;
                                int i;
                                y yVar;
                                if (linkedList == null || linkedList.size() <= 0) {
                                    w.e("MicroMsg.GameJsApiLogin", "scopeInfoList is empty!");
                                    dVar = dVar2;
                                    i = i2;
                                    yVar = this.mkG.mkE;
                                    dVar.x(i, a.d("loginfail", null));
                                } else if (!eVar.a(linkedList, str4, str5, anonymousClass1)) {
                                    dVar = dVar2;
                                    i = i2;
                                    yVar = this.mkG.mkE;
                                    dVar.x(i, a.d("loginfail", null));
                                }
                            }
                        });
                        return;
                    } else if (i3 == 0) {
                        new HashMap().put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, com_tencent_mm_protocal_c_ahg.tLO);
                        w.d("MicroMsg.GameJsApiLogin", "resp data code [%s]", new Object[]{r0});
                        dVar = dVar2;
                        i3 = i2;
                        yVar = this.mkE;
                        dVar.x(i3, a.d("loginok", null));
                        return;
                    } else {
                        w.e("MicroMsg.GameJsApiLogin", "onSceneEnd NetSceneJSLogin %s", new Object[]{str2});
                        dVar = dVar2;
                        i3 = i2;
                        yVar = this.mkE;
                        dVar.x(i3, a.d("loginfail", null));
                        return;
                    }
                }
                dVar = dVar2;
                i3 = i2;
                yVar = this.mkE;
                dVar.x(i3, a.d("loginfail", null));
            }
        });
    }
}
