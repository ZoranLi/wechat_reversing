package com.tencent.mm.plugin.bbom;

import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.c.alq;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ba;

public final class f implements k {
    private String jPS = null;

    public f(String str) {
        this.jPS = str;
    }

    public final void a(alq com_tencent_mm_protocal_c_alq, au auVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<msgsource>");
        stringBuilder.append("<strangerantispamticket ticket=\"" + this.jPS + "\"></strangerantispamticket>");
        stringBuilder.append(bg.mz(ba.zy()));
        String str = (bg.mA(com_tencent_mm_protocal_c_alq.tfi) || !com_tencent_mm_protocal_c_alq.tfi.startsWith("<msgsource>")) ? "<msgsource></msgsource>" : com_tencent_mm_protocal_c_alq.tfi;
        com_tencent_mm_protocal_c_alq.tfi = str;
        com_tencent_mm_protocal_c_alq.tfi = com_tencent_mm_protocal_c_alq.tfi.replace("<msgsource>", stringBuilder.toString());
    }
}
