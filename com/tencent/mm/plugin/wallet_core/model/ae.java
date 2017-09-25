package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.e.b.dr;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.lang.reflect.Field;

public final class ae extends dr {
    public static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[16];
        aVar.columns = new String[17];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = OpenSDKTool4Assistant.EXTRA_UIN;
        aVar.uxd.put(OpenSDKTool4Assistant.EXTRA_UIN, "TEXT PRIMARY KEY ");
        stringBuilder.append(" uin TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = OpenSDKTool4Assistant.EXTRA_UIN;
        aVar.columns[1] = "is_reg";
        aVar.uxd.put("is_reg", "INTEGER");
        stringBuilder.append(" is_reg INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "true_name";
        aVar.uxd.put("true_name", "TEXT");
        stringBuilder.append(" true_name TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "card_num";
        aVar.uxd.put("card_num", "INTEGER");
        stringBuilder.append(" card_num INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "isDomesticUser";
        aVar.uxd.put("isDomesticUser", "INTEGER");
        stringBuilder.append(" isDomesticUser INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "cre_type";
        aVar.uxd.put("cre_type", "INTEGER");
        stringBuilder.append(" cre_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = "main_card_bind_serialno";
        aVar.uxd.put("main_card_bind_serialno", "TEXT");
        stringBuilder.append(" main_card_bind_serialno TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "ftf_pay_url";
        aVar.uxd.put("ftf_pay_url", "TEXT");
        stringBuilder.append(" ftf_pay_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "switchConfig";
        aVar.uxd.put("switchConfig", "INTEGER");
        stringBuilder.append(" switchConfig INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "reset_passwd_flag";
        aVar.uxd.put("reset_passwd_flag", "TEXT");
        stringBuilder.append(" reset_passwd_flag TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "find_passwd_url";
        aVar.uxd.put("find_passwd_url", "TEXT");
        stringBuilder.append(" find_passwd_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "is_open_touch";
        aVar.uxd.put("is_open_touch", "INTEGER");
        stringBuilder.append(" is_open_touch INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "lct_wording";
        aVar.uxd.put("lct_wording", "TEXT");
        stringBuilder.append(" lct_wording TEXT");
        stringBuilder.append(", ");
        aVar.columns[13] = "lct_url";
        aVar.uxd.put("lct_url", "TEXT");
        stringBuilder.append(" lct_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[14] = "cre_name";
        aVar.uxd.put("cre_name", "TEXT");
        stringBuilder.append(" cre_name TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "lqt_state";
        aVar.uxd.put("lqt_state", "INTEGER");
        stringBuilder.append(" lqt_state INTEGER");
        aVar.columns[16] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public final boolean buj() {
        return this.field_is_reg == 0;
    }

    public final boolean buk() {
        return this.field_is_reg == -1;
    }
}
