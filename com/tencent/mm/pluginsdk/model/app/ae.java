package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.cy;
import com.tencent.mm.protocal.c.cz;
import com.tencent.mm.protocal.c.ug;
import com.tencent.mm.protocal.c.uh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ae extends w {
    List<String> sDR;

    public ae(List<String> list) {
        a aVar = new a();
        aVar.hsm = new ug();
        aVar.hsn = new uh();
        aVar.uri = "/cgi-bin/micromsg-bin/getappsetting";
        this.ldw = aVar.BE();
        this.sDR = list;
        w.d("MicroMsg.NetSceneGetAppSetting", "<init>, appIdList size = " + list.size());
        LinkedList linkedList = new LinkedList();
        for (String str : list) {
            if (str != null && str.length() > 0) {
                cz czVar = new cz();
                czVar.msh = str;
                linkedList.add(czVar);
            }
        }
        if (linkedList.size() == 0) {
            w.e("MicroMsg.NetSceneGetAppSetting", "doScene fail, reqList is empty");
        }
        ug ugVar = (ug) this.ldw.hsj.hsr;
        ugVar.tCm = linkedList;
        ugVar.tCl = linkedList.size();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetAppSetting", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            uh uhVar = (uh) this.ldw.hsk.hsr;
            w.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, resp appCount = " + uhVar.tCl);
            LinkedList linkedList = uhVar.tCn;
            if (linkedList == null || linkedList.size() == 0) {
                w.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, settingList is empty");
                return;
            }
            i aRr = com.tencent.mm.plugin.w.a.aRr();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                cy cyVar = (cy) it.next();
                f aJ = g.aJ(cyVar.msh, false);
                if (aJ != null) {
                    aJ.field_authFlag = cyVar.tgt;
                    aJ.field_openId = cyVar.mtH;
                    w.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, update ret = " + aRr.a(aJ, new String[0]) + ", appId = " + cyVar.msh);
                }
            }
            return;
        }
        w.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, errType = " + i2 + ", errCode = " + i3);
    }

    public final byte[] aBv() {
        try {
            return ((b) this.ldw.BG()).zh();
        } catch (Throwable e) {
            w.e("MicroMsg.NetSceneGetAppSetting", "toProtBuf error: " + e.getMessage());
            w.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", e, "", new Object[0]);
            return null;
        }
    }

    public final void ar(byte[] bArr) {
        if (bArr == null) {
            w.e("MicroMsg.NetSceneGetAppSetting", "buf is null");
            return;
        }
        try {
            this.ldw.hsk.y(bArr);
        } catch (Throwable e) {
            w.e("MicroMsg.NetSceneGetAppSetting", "bufToResp error: " + e.getMessage());
            w.printErrStackTrace("MicroMsg.NetSceneGetAppSetting", e, "", new Object[0]);
        }
    }

    public final int getType() {
        return 1;
    }
}
