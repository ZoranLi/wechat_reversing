package com.tencent.mm.ab;

import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ab;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.ArrayList;
import java.util.List;

public final class a extends ab {
    public final boolean eX(int i) {
        return i != 0 && i < 604372991;
    }

    public final String getTag() {
        return "MicroMsg.App.BizInfoDataTransfer";
    }

    public final void transfer(int i) {
        w.d("MicroMsg.App.BizInfoDataTransfer", "the previous version is %d", Integer.valueOf(i));
        if (i != 0 && i < 604372991) {
            ap.yY();
            g wO = c.wO();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select BizInfo.username").append(", BizInfo.extInfo");
            stringBuilder.append(" from rcontact , BizInfo");
            stringBuilder.append(" where rcontact.username").append(" = BizInfo.username");
            stringBuilder.append(" and (rcontact.type").append(" & 1 ) != 0 ");
            stringBuilder.append(" and ( rcontact.verifyFlag").append(" & 8 ) != 0 ");
            String stringBuilder2 = stringBuilder.toString();
            List<String> arrayList = new ArrayList();
            w.d("MicroMsg.App.BizInfoDataTransfer", "sql %s", stringBuilder2);
            Cursor a = wO.a(stringBuilder.toString(), null, 2);
            if (a != null) {
                while (a.moveToNext()) {
                    BizInfo bizInfo = new BizInfo();
                    bizInfo.b(a);
                    if (bizInfo.bd(false).De() == 1) {
                        arrayList.add(bizInfo.field_username);
                    }
                }
                a.close();
            }
            if (arrayList.size() > 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Update BizInfo set type").append(" = 1 where 1 !=1 ");
                for (String append : arrayList) {
                    stringBuilder.append(" or username = '").append(append).append("'");
                }
                w.d("MicroMsg.App.BizInfoDataTransfer", "update sql %s", stringBuilder.toString());
                com.tencent.mm.modelbiz.w.DH().eE("BizInfo", append);
            }
        }
    }
}
