package com.tencent.mm.plugin.wallet.bind.ui;

import android.text.TextUtils;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;

public final class b {
    public static boolean a(Bankcard bankcard) {
        if (bankcard == null) {
            return false;
        }
        ap.yY();
        String str = (String) c.vr().get(196659, null);
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        String[] split = str.split("&");
        if (split == null || split.length == 0) {
            return true;
        }
        for (String str2 : split) {
            if (str2 != null && str2.equals(bankcard.field_bankcardType)) {
                return false;
            }
        }
        return true;
    }
}
