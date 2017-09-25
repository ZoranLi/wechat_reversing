package com.tencent.mm.plugin.wear.model.f;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.plugin.wear.model.e.r;
import com.tencent.mm.protocal.c.boe;
import java.io.IOException;

public final class k extends c {
    private int code;
    private String fEr;

    public k(int i, String str) {
        this.code = i;
        this.fEr = str;
    }

    protected final void send() {
        boe com_tencent_mm_protocal_c_boe = new boe();
        switch (this.code) {
            case 0:
                com_tencent_mm_protocal_c_boe.ueH = 0;
                break;
            case 6:
                com_tencent_mm_protocal_c_boe.ueH = 196610;
                break;
            case 7:
                com_tencent_mm_protocal_c_boe.ueH = 196615;
                break;
            case 8:
                com_tencent_mm_protocal_c_boe.ueH = 196614;
                break;
            case 9:
                com_tencent_mm_protocal_c_boe.ueH = 196613;
                break;
        }
        com_tencent_mm_protocal_c_boe.ulM = this.fEr;
        try {
            a.bvG();
            r.a(20016, com_tencent_mm_protocal_c_boe.toByteArray(), true);
        } catch (IOException e) {
        }
    }

    public final String getName() {
        return "WearPushPayResponseTask";
    }
}
