package com.tencent.mm.az;

import android.content.Context;
import com.tencent.mm.av.l;
import com.tencent.mm.bb.d;
import com.tencent.mm.i.g;
import com.tencent.mm.sdk.platformtools.bg;

public final class a {
    public static boolean bCj() {
        Object value = g.sV().getValue("EnableStrangerChat");
        String str = "1";
        if (bg.mA(value)) {
            value = "0";
        }
        return str.equals(value);
    }

    public static void dl(Context context) {
        if (bCj() || l.Kz().Kr() <= 0) {
            d.w(context, "nearby", ".ui.NearbyFriendsUI");
        } else {
            d.w(context, "nearby", ".ui.NearbyFriendShowSayHiUI");
        }
    }
}
