package com.tencent.mm.plugin.wallet_core.model;

import android.database.Cursor;
import com.tencent.mm.e.b.dq;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.apq;
import com.tencent.mm.protocal.c.bmj;
import com.tencent.mm.protocal.c.bmm;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Field;
import java.util.Iterator;

public final class ab extends dq {
    public static a gTP;
    public String nnA = "";
    private apq rHY = new apq();
    public bmj rHZ = null;
    public bmm rIa = null;
    public boolean rIb = false;
    public String rIc = "";
    public String rId = "";
    public String rIe = "";
    public String rIf = "";

    static {
        a aVar = new a();
        aVar.hXH = new Field[2];
        aVar.columns = new String[3];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "wallet_region";
        aVar.uxd.put("wallet_region", "INTEGER PRIMARY KEY ");
        stringBuilder.append(" wallet_region INTEGER PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "wallet_region";
        aVar.columns[1] = "wallet_grey_item_buf";
        aVar.uxd.put("wallet_grey_item_buf", "BLOB");
        stringBuilder.append(" wallet_grey_item_buf BLOB");
        aVar.columns[2] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public ab() {
        if (this.rHZ == null) {
            this.rHZ = new bmj();
        }
        if (this.rIa == null) {
            this.rIa = new bmm();
        }
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        this.rHY = new apq();
        try {
            this.rHY = (apq) this.rHY.aD(this.field_wallet_grey_item_buf);
            this.rHZ = this.rHY.tUC;
            this.rIa = this.rHY.tUD;
            this.rIb = this.rHY.tUE;
            this.rIf = "";
            Iterator it = this.rHY.tUF.iterator();
            while (it.hasNext()) {
                this.rIf += ((String) it.next()) + "\n";
            }
            if (this.rHY.tUA != null) {
                this.rIc = n.a(this.rHY.tUA.ulX);
                this.rId = n.a(this.rHY.tUA.ulY);
            }
            if (this.rHY.tUB != null) {
                this.rIe = n.a(this.rHY.tUB.ulV);
                this.nnA = n.a(this.rHY.tUB.ulW);
            }
            w.v("WalletRegionGreyItem", "noticeContent %s", new Object[]{this.rIe});
        } catch (Exception e) {
            w.e("WalletRegionGreyItem", "parser PayIBGGetOverseaWalletRsp error");
        }
        if (this.rHZ == null) {
            this.rHZ = new bmj();
        }
        if (this.rIa == null) {
            this.rIa = new bmm();
        }
    }
}
