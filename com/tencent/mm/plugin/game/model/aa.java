package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.c.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public class aa {
    public static c a(c cVar) {
        c cVar2 = null;
        if (cVar == null) {
            w.e("MicroMsg.GamePBData", "Invalid pb object");
        } else if (bg.mA(cVar.msh)) {
            w.e("MicroMsg.GamePBData", "No AppID field, abort");
        } else {
            w.i("MicroMsg.GamePBData", "Parsing AppID: %s", new Object[]{cVar.msh});
            cVar2 = new c();
            cVar2.field_appId = cVar.msh;
            cVar2.field_appName = cVar.msj;
            cVar2.field_appIconUrl = cVar.msi;
            cVar2.field_appType = ",1,";
            cVar2.field_packageName = cVar.msm;
            cVar2.field_appVersion = cVar.jOb;
            cVar2.field_appInfoFlag = cVar.msp;
            if (cVar.mso != null) {
                cVar2.bD(cVar.mso.msS);
                cVar2.bG(cVar.mso.msT);
                cVar2.da(cVar.mso.msW);
                cVar2.bH(cVar.mso.msU);
                cVar2.moS = cVar.mso.msY;
                cVar2.moT = (long) cVar.mso.msX;
                cVar2.fLG = cVar.mso.msZ;
            }
            if (!(cVar.mso == null || cVar.mso.msV == null)) {
                cVar2.bM(cVar.mso.msV.msS);
                cVar2.bN(cVar.mso.msV.mvX);
                cVar2.bK(cVar.mso.msV.mvY);
                cVar2.bL(cVar.mso.msV.mvZ);
                cVar2.db(cVar.mso.msV.mwb);
            }
            cVar2.moz = cVar.msk;
            cVar2.moy = cVar.msl;
            cVar2.status = cVar.jNB;
            cVar2.moB = cVar.mse;
            cVar2.versionCode = cVar.msn;
            cVar2.fDE = cVar.msg;
            cVar2.moD = cVar.msq;
            cVar2.moL = cVar.msv;
            if (!(cVar.mso == null || cVar.mso.msV == null)) {
                cVar2.moE = cVar.mso.msV.mwa;
                cVar2.moF = cVar.mso.msV.mwc;
                cVar2.moG = cVar.mso.msV.mwd;
            }
            cVar2.moU = cVar.msx;
            cVar2.moV = cVar.msy;
        }
        return cVar2;
    }
}
