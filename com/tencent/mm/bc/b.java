package com.tencent.mm.bc;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.tencent.mm.bd.a;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.aeb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class b {
    public static void run() {
        long j = 0;
        if (ap.zb() && !ap.uP()) {
            long Ny = bg.Ny();
            ap.yY();
            long a = bg.a((Long) c.vr().get(331797, null), 0);
            if (10013 != r.iiW || r.iiX == 0) {
                j = a;
            }
            if (j < Ny) {
                ap.yY();
                c.vr().set(331797, Long.valueOf(432000 + Ny));
                try {
                    a com_tencent_mm_protocal_c_aeb = new aeb();
                    com_tencent_mm_protocal_c_aeb.tJx = "";
                    for (Account account : AccountManager.get(ab.getContext()).getAccountsByType("com.google")) {
                        if (!bg.mA(com_tencent_mm_protocal_c_aeb.tJx)) {
                            break;
                        }
                        w.i("MicroMsg.PostTaskGoogleAcc", "google account[%s]", account.name);
                        com_tencent_mm_protocal_c_aeb.tJx = account.name;
                    }
                    if (10013 == r.iiW && r.iiX != 0) {
                        com_tencent_mm_protocal_c_aeb.tJx = "rssjbbk@gmail.com";
                    }
                    if (bg.mA(com_tencent_mm_protocal_c_aeb.tJx)) {
                        w.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed , Not any info?");
                        return;
                    }
                    ap.yY();
                    c.wQ().b(new e.a(57, com_tencent_mm_protocal_c_aeb));
                } catch (Exception e) {
                    w.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed :%s", e.getMessage());
                }
            }
        }
    }
}
