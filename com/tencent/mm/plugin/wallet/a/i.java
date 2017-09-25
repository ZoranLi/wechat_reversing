package com.tencent.mm.plugin.wallet.a;

import com.tencent.mm.e.a.gz;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;

public final class i extends c<gz> {
    public i() {
        this.usg = gz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        int i = 0;
        gz gzVar = (gz) bVar;
        if (!(gzVar instanceof gz)) {
            return false;
        }
        gzVar.fMo.fMq = m.btS().bup();
        String akr = m.btS().akr();
        if (bg.mA(akr)) {
            gzVar.fMo.fMp = "";
        } else {
            String str = "";
            while (i < akr.length() - 1) {
                str = str + "*";
                i++;
            }
            gzVar.fMo.fMp = str + akr.substring(akr.length() - 1, akr.length());
        }
        return true;
    }
}
