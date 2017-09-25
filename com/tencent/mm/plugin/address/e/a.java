package com.tencent.mm.plugin.address.e;

import android.content.Intent;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    public static Intent b(b bVar) {
        if (bVar == null) {
            w.e("MicroMsg.AddrUtil", "addressObj == null");
            return null;
        }
        Intent intent = new Intent();
        intent.putExtra("nationalCode", bVar.itz);
        intent.putExtra("userName", bVar.itx);
        intent.putExtra("telNumber", bVar.ity);
        intent.putExtra("addressPostalCode", bVar.itv);
        intent.putExtra("proviceFirstStageName", bVar.its);
        intent.putExtra("addressCitySecondStageName", bVar.itt);
        intent.putExtra("addressCountiesThirdStageName", bVar.itu);
        intent.putExtra("addressDetailInfo", bVar.itw);
        return intent;
    }
}
