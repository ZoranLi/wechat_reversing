package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.plugin.wear.model.h;
import com.tencent.mm.protocal.c.bot;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class l extends c {
    private String fJL;
    private int rTT;

    public l(int i, String str) {
        this.rTT = i;
        this.fJL = str;
    }

    public final String getName() {
        return "WearVoipControllerTask";
    }

    protected final void send() {
        switch (this.rTT) {
            case 20010:
                bot com_tencent_mm_protocal_c_bot = new bot();
                com_tencent_mm_protocal_c_bot.umH = this.fJL;
                com_tencent_mm_protocal_c_bot.jOp = h.IH(this.fJL);
                try {
                    a.bvG();
                    r.a(this.rTT, com_tencent_mm_protocal_c_bot.toByteArray(), false);
                    return;
                } catch (IOException e) {
                    return;
                }
            case 20011:
            case 20012:
                try {
                    a.bvG();
                    r.a(this.rTT, this.fJL.getBytes("utf8"), false);
                    return;
                } catch (UnsupportedEncodingException e2) {
                    return;
                }
            default:
                return;
        }
    }
}
