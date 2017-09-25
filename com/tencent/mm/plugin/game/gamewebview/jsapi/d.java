package com.tencent.mm.plugin.game.gamewebview.jsapi;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetGameCommInfo;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ad;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ae;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.af;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ag;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ah;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ai;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aj;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ak;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.al;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.am;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.an;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ao;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ap;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ar;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.as;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.at;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.au;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.av;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aw;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.c;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.e;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.f;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.g;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.h;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.j;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.l;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.m;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.o;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.p;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.q;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.r;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.s;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.t;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.u;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.w;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.x;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.y;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.z;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.HashMap;
import java.util.Map;

public final class d {
    private static Map<String, c> mjU;

    public static Map<String, c> azm() {
        if (mjU == null || mjU.size() == 0) {
            mjU = new HashMap();
            a(new a());
            a(new b());
            a(new c());
            a(new com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d());
            a(new e());
            a(new f());
            a(new g());
            a(new h());
            a(new i());
            a(new j());
            a(new k());
            a(new l());
            a(new m());
            a(new n());
            a(new GameJsApiGetGameCommInfo());
            a(new o());
            a(new p());
            a(new q());
            a(new GameJsApiGetOpenDeviceId());
            a(new r());
            a(new s());
            a(new t());
            a(new u());
            a(new v());
            a(new w());
            a(new GameJsApiLaunchApplication());
            a(new x());
            a(new y());
            a(new z());
            a(new ab());
            a(new aa());
            a(new ac());
            a(new ad());
            a(new ae());
            a(new GameJsApiOperateGameCenterMsg());
            a(new af());
            a(new ag());
            a(new ah());
            a(new ai());
            a(new aj());
            a(new ak());
            a(new GameJsApiSendAppMessage());
            a(new al());
            a(new am());
            a(new an());
            a(new ao());
            a(new ap());
            a(new aq());
            a(new ar());
            a(new as());
            a(new at());
            a(new au());
            a(new av());
            a(new aw());
        }
        return mjU;
    }

    private static void a(c cVar) {
        if (!bg.mA(cVar.getName())) {
            mjU.put(cVar.getName(), cVar);
        }
    }
}
