package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.e.b.dn;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Field;
import org.json.JSONObject;

public final class v extends dn {
    public static a gTP;

    static {
        a aVar = new a();
        aVar.hXH = new Field[6];
        aVar.columns = new String[7];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wallet_tpa_country";
        aVar.uxd.put("wallet_tpa_country", "TEXT PRIMARY KEY ");
        stringBuilder.append(" wallet_tpa_country TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "wallet_tpa_country";
        aVar.columns[1] = "wallet_type";
        aVar.uxd.put("wallet_type", "INTEGER");
        stringBuilder.append(" wallet_type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[2] = "wallet_name";
        aVar.uxd.put("wallet_name", "TEXT");
        stringBuilder.append(" wallet_name TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "wallet_selected";
        aVar.uxd.put("wallet_selected", "INTEGER");
        stringBuilder.append(" wallet_selected INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "wallet_balance";
        aVar.uxd.put("wallet_balance", "INTEGER");
        stringBuilder.append(" wallet_balance INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "wallet_tpa_country_mask";
        aVar.uxd.put("wallet_tpa_country_mask", "INTEGER");
        stringBuilder.append(" wallet_tpa_country_mask INTEGER");
        aVar.columns[6] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public static v O(JSONObject jSONObject) {
        if (jSONObject == null) {
            w.e("MicroMsg.WalletKindInfo", "json is null");
            return null;
        }
        v vVar = new v();
        vVar.field_wallet_tpa_country = jSONObject.optString("wallet_tpa_country");
        vVar.field_wallet_name = jSONObject.optString("wallet_name");
        vVar.field_wallet_selected = jSONObject.optInt("wallet_selected");
        vVar.field_wallet_type = jSONObject.optInt("wallet_type");
        vVar.field_wallet_balance = jSONObject.optInt("wallet_balance");
        vVar.field_wallet_tpa_country_mask = jSONObject.optInt("wallet_tpa_country_mask");
        if (!bg.mA(vVar.field_wallet_tpa_country)) {
            return vVar;
        }
        w.e("MicroMsg.WalletKindInfo", "wallet_id is illegal");
        return null;
    }
}
