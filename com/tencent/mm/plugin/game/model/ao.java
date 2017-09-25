package com.tencent.mm.plugin.game.model;

import com.tencent.mm.network.p;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.w;
import com.tencent.mm.protocal.c.dp;
import com.tencent.mm.protocal.c.uk;
import com.tencent.mm.protocal.c.ul;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class ao extends w {
    public ao(String str) {
        a aVar = new a();
        aVar.hsm = new uk();
        aVar.hsn = new ul();
        aVar.uri = "/cgi-bin/micromsg-bin/getauthapplist";
        aVar.hsl = 394;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.ldw = aVar.BE();
        uk ukVar = (uk) this.ldw.hsj.hsr;
        ukVar.jOc = 1;
        ukVar.mtJ = str;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        ul ulVar = (ul) this.ldw.hsk.hsr;
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneGetAuthAppList", "errType = " + i2 + ", errCode = " + i3 + ", get authlist count = " + ulVar.tCl);
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ulVar.tCo;
            if (linkedList != null && linkedList.size() > 0) {
                i aRt = com.tencent.mm.plugin.w.a.a.a.aRv().aRt();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    dp dpVar = (dp) it.next();
                    f aJ = g.aJ(dpVar.msh, true);
                    if (aJ != null) {
                        a(aJ, dpVar);
                        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneGetAuthAppList", "onGYNetEnd, update ret = " + aRt.a(aJ, new String[0]) + ", appId = " + aJ.field_appId);
                    } else {
                        aJ = new f();
                        aJ.field_appId = dpVar.msh;
                        a(aJ, dpVar);
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneGetAuthAppList", "insert game appinfo:" + dpVar.msh + ", ret = " + aRt.l(aJ));
                    }
                }
                return;
            }
            return;
        }
        com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneGetAuthAppList", "errType = " + i2 + ", errCode = " + i3);
    }

    private static void a(f fVar, dp dpVar) {
        fVar.field_appType = dpVar.tgZ;
        fVar.field_appIconUrl = dpVar.muU;
        fVar.field_appName = dpVar.muS;
        fVar.field_authFlag = dpVar.tgt;
        fVar.bB(dpVar.tha);
        fVar.bC(dpVar.thb);
    }

    public final byte[] aBv() {
        try {
            return ((b) this.ldw.BG()).zh();
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.NetSceneGetAuthAppList", e, "", new Object[0]);
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneGetAuthAppList", "reqToBuf failed: " + e.getMessage());
            return null;
        }
    }

    public final void ar(byte[] bArr) {
        if (bArr == null) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneGetAuthAppList", "buf is null");
            return;
        }
        try {
            this.ldw.hsk.y(bArr);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneGetAuthAppList", e.getMessage());
            com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.NetSceneGetAuthAppList", e, "", new Object[0]);
        }
    }

    public final int getType() {
        return 3;
    }
}
