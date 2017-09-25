package com.tencent.mm.plugin.favorite.b;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b extends i<a> {
    public static final String[] gUx = new String[]{i.a(a.gTP, "FavCdnInfo")};
    public e gUz;
    private List<a> hDb = new LinkedList();

    public interface a {
        void b(a aVar);
    }

    public final /* synthetic */ boolean a(c cVar, String[] strArr) {
        return b((a) cVar, strArr);
    }

    public final /* synthetic */ boolean b(c cVar) {
        return a((a) cVar);
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        return a((a) cVar, strArr);
    }

    public final void a(a aVar) {
        this.hDb.add(aVar);
    }

    public final void b(a aVar) {
        this.hDb.remove(aVar);
    }

    public b(e eVar) {
        super(eVar, a.gTP, "FavCdnInfo", null);
        this.gUz = eVar;
    }

    public final boolean a(a aVar) {
        int i = 0;
        if (aVar == null || !super.b(aVar)) {
            return false;
        }
        a[] aVarArr = new a[this.hDb.size()];
        this.hDb.toArray(aVarArr);
        int length = aVarArr.length;
        while (i < length) {
            a aVar2 = aVarArr[i];
            if (aVar2 != null) {
                aVar2.b(aVar);
            }
            i++;
        }
        return true;
    }

    public final boolean a(a aVar, String... strArr) {
        int i = 0;
        if (!super.c(aVar, strArr)) {
            return false;
        }
        a[] aVarArr = new a[this.hDb.size()];
        this.hDb.toArray(aVarArr);
        int length = aVarArr.length;
        while (i < length) {
            aVarArr[i].b(aVar);
            i++;
        }
        return true;
    }

    public final boolean b(a aVar, String... strArr) {
        int i = 0;
        if (!super.a(aVar, strArr)) {
            return false;
        }
        a[] aVarArr = new a[this.hDb.size()];
        this.hDb.toArray(aVarArr);
        int length = aVarArr.length;
        while (i < length) {
            aVarArr[i].b(aVar);
            i++;
        }
        return true;
    }

    public final a vN(String str) {
        a aVar = null;
        if (bg.mA(str)) {
            w.e("MicroMsg.FavCdnStorage", "md5 null");
        } else {
            Cursor a = this.gUz.a("select * from FavCdnInfo where dataId = '" + str + "'", null, 2);
            if (a != null) {
                if (a.moveToFirst()) {
                    aVar = new a();
                    aVar.b(a);
                }
                a.close();
            }
        }
        return aVar;
    }

    public final void a(j jVar) {
        this.gUz.eE("FavCdnInfo", "update FavCdnInfo set status = 1,modifyTime = " + bg.Nz() + " where favLocalId = " + jVar.field_localId + " and type = 0" + " and status <> 3");
    }

    public final List<a> bQ(long j) {
        List<a> arrayList = new ArrayList();
        Cursor a = this.gUz.a("select * from FavCdnInfo where favLocalId = " + j, null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                a aVar = new a();
                aVar.b(a);
                arrayList.add(aVar);
            }
            a.close();
        }
        w.v("MicroMsg.FavCdnStorage", "getInfos size:%d", new Object[]{Integer.valueOf(arrayList.size())});
        return arrayList;
    }

    public final void bR(long j) {
        this.gUz.eE("FavCdnInfo", String.format("delete from %s where %s = %d and %s = %d", new Object[]{"FavCdnInfo", "favLocalId", Long.valueOf(j), Columns.TYPE, Integer.valueOf(0)}));
    }

    public final int m(long j, int i) {
        Cursor a = this.gUz.a("select status from FavCdnInfo where favLocalId = " + j + " and type = " + i, null, 2);
        if (a == null) {
            return 3;
        }
        if (a.moveToFirst()) {
            int i2 = 1;
            int i3 = 1;
            int i4 = 1;
            do {
                int i5 = a.getInt(0);
                if (i5 == 1) {
                    a.close();
                    return 1;
                }
                if (i5 != 4) {
                    i4 = 0;
                }
                if (i5 != 2) {
                    i3 = 0;
                }
                if (i5 != 3) {
                    i2 = 0;
                }
            } while (a.moveToNext());
            a.close();
            if (i3 != 0) {
                return 2;
            }
            if (i4 != 0) {
                return 4;
            }
            if (i2 != 0) {
                return 3;
            }
            return 0;
        }
        a.close();
        return 3;
    }

    public final boolean bS(long j) {
        a aVar = new a();
        aVar.field_favLocalId = j;
        return b(aVar, "favLocalId");
    }
}
