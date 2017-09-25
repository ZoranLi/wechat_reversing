package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.pluginsdk.ui.tools.b;
import com.tencent.mm.protocal.c.gm;
import com.tencent.mm.protocal.c.uc;
import com.tencent.mm.protocal.c.ud;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ad extends w {
    private static final String[] sDQ = new String[]{"wxf109da3e26cf89f1", "wxc56bba830743541e", "wx41dd4f6ef137bd0b"};

    public ad(List<String> list) {
        int i = 0;
        a aVar = new a();
        aVar.hsm = new uc();
        aVar.hsn = new ud();
        aVar.uri = "/cgi-bin/micromsg-bin/getappinfolist";
        this.ldw = aVar.BE();
        uc ucVar = (uc) this.ldw.hsj.hsr;
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            String[] strArr = new String[list.size()];
            list.toArray(strArr);
            int length = strArr.length;
            while (i < length) {
                String str = strArr[i];
                if (!bg.mA(str)) {
                    linkedList.add(n.mw(str));
                }
                i++;
            }
        }
        ucVar.tCh = linkedList;
        ucVar.jNd = linkedList.size();
    }

    public final int getType() {
        return 7;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetAppInfoList", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            LinkedList linkedList = ((ud) this.ldw.hsk.hsr).tCi;
            if (linkedList != null && !linkedList.isEmpty()) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    gm gmVar = (gm) it.next();
                    if (gmVar != null) {
                        a(g.aJ(gmVar.mtb, false), gmVar);
                    }
                }
                return;
            }
            return;
        }
        w.e("MicroMsg.NetSceneGetAppInfoList", "errType = " + i2 + ", errCode = " + i3);
    }

    private static void a(f fVar, gm gmVar) {
        boolean z;
        int i = 0;
        if (fVar == null) {
            fVar = new f();
            fVar.field_appId = gmVar.mtb;
            z = true;
        } else {
            z = false;
        }
        w.i("MicroMsg.NetSceneGetAppInfoList", "appid:[%s], appinfoflag:[%d] AppSupportContentType:%d", gmVar.mtb, Integer.valueOf(gmVar.msp), Long.valueOf(gmVar.tkA));
        w.i("MicroMsg.NetSceneGetAppInfoList", "appId=%s, appName=%s, status=%s, appInfoFlag=%s", fVar.field_appId, fVar.field_appName, Integer.valueOf(fVar.field_status), Integer.valueOf(fVar.field_appInfoFlag));
        if (!fVar.bCV() || bg.mA(fVar.field_appName)) {
            fVar.field_appName = gmVar.msj;
        }
        if (!fVar.bCV() || bg.mA(fVar.field_appName_en)) {
            fVar.field_appName_en = gmVar.tkm;
        }
        if (!fVar.bCV() || bg.mA(fVar.field_appName_tw)) {
            fVar.field_appName_tw = gmVar.tko;
        }
        fVar.field_appDiscription = gmVar.tgT;
        fVar.field_appDiscription_en = gmVar.tkn;
        fVar.field_appDiscription_tw = gmVar.tkp;
        fVar.field_appWatermarkUrl = gmVar.tkt;
        fVar.field_packageName = gmVar.teg;
        fVar.field_signature = p.Mi(gmVar.tku);
        w.i("MicroMsg.NetSceneGetAppInfoList", "get signature, server sig : %s, gen sig: %s ", gmVar.tku, fVar.field_signature);
        fVar.field_appType = gmVar.tgZ;
        if (!bg.mA(fVar.field_appType) && (fVar.field_appType.startsWith("1") || fVar.field_appType.startsWith("6"))) {
            fVar.field_appType = "," + fVar.field_appType;
        }
        fVar.field_appInfoFlag = gmVar.msp;
        fVar.field_appVersion = gmVar.tkv;
        fVar.bC(gmVar.thb);
        fVar.field_appWatermarkUrl = gmVar.tkt;
        if (!(bg.mA(gmVar.tky) || bg.mA(gmVar.tkz))) {
            w.i("MicroMsg.NetSceneGetAppInfoList", "get app download url and download md5 : [%s], [%s], [%s]", fVar.field_appName, gmVar.tky, gmVar.tkz);
            fVar.bD(gmVar.tky);
            fVar.bG(gmVar.tkz);
        }
        fVar.bH(gmVar.teh);
        fVar.field_svrAppSupportContentType = gmVar.tkA;
        if (gmVar.tkw > fVar.gfd) {
            fVar.gfe = 1;
            fVar.gey = true;
        }
        fVar.gfd = gmVar.tkw;
        fVar.gey = true;
        String str = gmVar.teg;
        String str2 = gmVar.teg;
        int i2 = (str == null || str.length() == 0 || str2 == null || str2.length() == 0) ? true : 0;
        if (i2 != 0) {
            w.e("MicroMsg.NetSceneGetAppInfoList", "no android app, packageName = " + gmVar.teg + "appid: " + fVar.field_appId);
        }
        if (fVar.bCU()) {
            b.Nk(fVar.field_appId);
        }
        i aRr = com.tencent.mm.plugin.w.a.aRr();
        if (z) {
            fVar.field_status = i2 != 0 ? 3 : 4;
            fVar.field_modifyTime = System.currentTimeMillis();
            fVar.field_appIconUrl = gmVar.tkr;
            if (fVar.field_appId != null) {
                while (i < sDQ.length) {
                    if (fVar.field_appId.equals(sDQ[i])) {
                        fVar.field_status = -1;
                        break;
                    }
                    i++;
                }
            }
            if (aRr.l(fVar)) {
                com.tencent.mm.plugin.w.a.aRp().cu(fVar.field_appId, 1);
                com.tencent.mm.plugin.w.a.aRp().cu(fVar.field_appId, 2);
                com.tencent.mm.plugin.w.a.aRp().cu(fVar.field_appId, 3);
                com.tencent.mm.plugin.w.a.aRp().cu(fVar.field_appId, 4);
                com.tencent.mm.plugin.w.a.aRp().cu(fVar.field_appId, 5);
                return;
            }
            w.e("MicroMsg.NetSceneGetAppInfoList", "onGYNetEnd : insert fail");
            return;
        }
        fVar.field_status = i2 != 0 ? 3 : fVar.field_status;
        if (fVar.field_appId != null) {
            for (Object equals : sDQ) {
                if (fVar.field_appId.equals(equals)) {
                    fVar.field_status = -1;
                    break;
                }
            }
        }
        z = (fVar == null || fVar.field_appIconUrl == null || fVar.field_appIconUrl.length() == 0) ? true : (gmVar == null || gmVar.tkx == null || gmVar.tkx.length() == 0) ? false : !fVar.field_appIconUrl.equals(gmVar.tkr);
        if (z) {
            w.i("MicroMsg.NetSceneGetAppInfoList", "oldIcon = %s, newIcon = %s", fVar.field_appIconUrl, gmVar.tkr);
            fVar.field_appIconUrl = gmVar.tkr;
            com.tencent.mm.plugin.w.a.aRp().cu(fVar.field_appId, 1);
            com.tencent.mm.plugin.w.a.aRp().cu(fVar.field_appId, 2);
            com.tencent.mm.plugin.w.a.aRp().cu(fVar.field_appId, 3);
            com.tencent.mm.plugin.w.a.aRp().cu(fVar.field_appId, 4);
            com.tencent.mm.plugin.w.a.aRp().cu(fVar.field_appId, 5);
        }
        w.i("MicroMsg.NetSceneGetAppInfoList", "update appinfo " + aRr.a(fVar, new String[0]) + ", appid = " + gmVar.mtb);
    }

    public final byte[] aBv() {
        try {
            return ((com.tencent.mm.y.b.b) this.ldw.BG()).zh();
        } catch (Exception e) {
            w.e("MicroMsg.NetSceneGetAppInfoList", "toProtBuf failed: " + e.getMessage());
            return null;
        }
    }

    public final void ar(byte[] bArr) {
        if (bArr == null) {
            w.e("MicroMsg.NetSceneGetAppInfoList", "buf is null");
            return;
        }
        try {
            this.ldw.hsk.y(bArr);
        } catch (Throwable e) {
            w.e("MicroMsg.NetSceneGetAppInfoList", "parse error: " + e.getMessage());
            w.printErrStackTrace("MicroMsg.NetSceneGetAppInfoList", e, "", new Object[0]);
        }
    }
}
