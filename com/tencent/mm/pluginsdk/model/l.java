package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.pluginsdk.model.app.w;
import com.tencent.mm.protocal.c.acf;
import com.tencent.mm.protocal.c.acg;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.b.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class l extends w {
    public String sCu;

    public l(String str, LinkedList<String> linkedList) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneGetUserInfoInApp", "appID: %s", str);
        this.sCu = str;
        a aVar = new a();
        aVar.hsm = new acf();
        aVar.hsn = new acg();
        aVar.uri = "/cgi-bin/micromsg-bin/getuserinfoinapp";
        this.ldw = aVar.BE();
        acf com_tencent_mm_protocal_c_acf = (acf) this.ldw.hsj.hsr;
        com_tencent_mm_protocal_c_acf.msh = str;
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (!bg.mA(str2)) {
                linkedList2.add(n.mw(str2));
            }
        }
        com_tencent_mm_protocal_c_acf.tiO = linkedList2;
        com_tencent_mm_protocal_c_acf.tDK = linkedList.size();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + i2 + ", errCode = " + i3);
        if (i2 != 0 || i3 != 0) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + i2 + ", errCode = " + i3);
        }
    }

    public final byte[] aBv() {
        try {
            return ((b) this.ldw.BG()).zh();
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneGetUserInfoInApp", e.getMessage());
            com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", e, "", new Object[0]);
            return null;
        }
    }

    public final void ar(byte[] bArr) {
        if (bArr == null) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneGetUserInfoInApp", "buf is null");
            return;
        }
        try {
            this.ldw.hsk.y(bArr);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.NetSceneGetUserInfoInApp", e.getMessage());
            com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.NetSceneGetUserInfoInApp", e, "", new Object[0]);
        }
    }

    public final int getType() {
        return 14;
    }
}
