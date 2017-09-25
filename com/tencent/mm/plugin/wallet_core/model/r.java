package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.mm.e.b.dm;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.json.JSONArray;

public final class r extends dm {
    public static a gTP;
    public ArrayList<MallFunction> nvg = new ArrayList();
    private ArrayList<MallNews> nvh = new ArrayList();
    private ArrayList<com.tencent.mm.plugin.wallet_core.model.mall.a> nvi = new ArrayList();
    public SparseArray<String> nvj = new SparseArray();

    static {
        a aVar = new a();
        aVar.hXH = new Field[5];
        aVar.columns = new String[6];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wallet_region";
        aVar.uxd.put("wallet_region", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "wallet_region";
        aVar.columns[1] = "function_list";
        aVar.uxd.put("function_list", "TEXT");
        stringBuilder.append(" function_list TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "new_list";
        aVar.uxd.put("new_list", "TEXT");
        stringBuilder.append(" new_list TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "banner_list";
        aVar.uxd.put("banner_list", "TEXT");
        stringBuilder.append(" banner_list TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "type_name_list";
        aVar.uxd.put("type_name_list", "TEXT");
        stringBuilder.append(" type_name_list TEXT");
        aVar.columns[5] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        String str = this.field_function_list;
        String str2 = this.field_new_list;
        String str3 = this.field_banner_list;
        String str4 = this.field_type_name_list;
        try {
            if (!bg.mA(str)) {
                this.nvg = b.w(new JSONArray(str));
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e, "", new Object[0]);
        }
        try {
            if (!bg.mA(str2)) {
                this.nvh = b.t(new JSONArray(str2));
            }
        } catch (Throwable e2) {
            this.nvh = null;
            w.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e2, "", new Object[0]);
        }
        try {
            if (!bg.mA(str3)) {
                this.nvi = b.u(new JSONArray(str3));
            }
        } catch (Throwable e22) {
            this.nvi = null;
            w.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e22, "", new Object[0]);
        }
        try {
            if (!bg.mA(str4)) {
                this.nvj = b.v(new JSONArray(str4));
            }
        } catch (Throwable e222) {
            this.nvj = null;
            w.printErrStackTrace("MicroMsg.WalletFunciontListInfo", e222, "", new Object[0]);
        }
    }
}
