package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.mm.bj.f;
import com.tencent.mm.bj.f.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.w;

public final class j extends i<i> implements a {
    public static final String[] gUx = new String[]{i.a(i.gTP, "IPCallPopularCountry")};
    public e gUz;
    public m hBv = new m(this) {
        final /* synthetic */ j mRe;

        {
            this.mRe = r1;
        }

        protected final boolean Fc() {
            if (this.mRe.gUz != null && !this.mRe.gUz.bKn()) {
                return true;
            }
            String str = "MicroMsg.IPCallPopularCountryStorage";
            String str2 = "shouldProcessEvent db is close :%s";
            Object[] objArr = new Object[1];
            objArr[0] = this.mRe.gUz == null ? "null" : Boolean.valueOf(this.mRe.gUz.bKn());
            w.w(str, str2, objArr);
            return false;
        }
    };

    public j(e eVar) {
        super(eVar, i.gTP, "IPCallPopularCountry", null);
        this.gUz = eVar;
    }

    public final String getTableName() {
        return "IPCallPopularCountry";
    }

    public final int a(f fVar) {
        if (fVar != null) {
            this.gUz = fVar;
        }
        return 0;
    }

    public final void v(int i, long j) {
        boolean a;
        c iVar = new i();
        Cursor a2 = this.gUz.a("IPCallPopularCountry", null, "countryCode=?", new String[]{Integer.toString(i)}, null, null, null, 2);
        if (a2.moveToFirst()) {
            iVar.b(a2);
            iVar.field_callTimeCount++;
            iVar.field_lastCallTime = j;
            a = super.a(iVar);
            a2.close();
        } else {
            w.i("MicroMsg.IPCallPopularCountryStorage", "get null with countryCode:" + i);
            a2.close();
            iVar.field_countryCode = i;
            iVar.field_lastCallTime = j;
            iVar.field_callTimeCount = 1;
            a = b(iVar);
        }
        w.i("MicroMsg.IPCallPopularCountryStorage", "updatePopularCountryCode ret:" + a);
    }
}
