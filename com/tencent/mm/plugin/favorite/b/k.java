package com.tencent.mm.plugin.favorite.b;

import android.database.Cursor;
import com.tencent.mm.plugin.favorite.b.x.a;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;

public final class k extends i<j> {
    public static final String[] gUx = new String[]{i.a(j.gTP, "FavItemInfo")};
    public static final String lEl = ("xml,edittime" + ",ext,favProto" + ",flag,fromUser" + ",id,itemStatus" + ",localId,localSeq" + ",realChatName,sourceCreateTime" + ",sourceId,sourceType" + ",toUser,type" + ",updateSeq,updateTime" + ",tagProto,sessionId" + ",datatotalsize,rowid");
    public e gUz;

    public final /* synthetic */ boolean b(c cVar) {
        return c((j) cVar);
    }

    public final /* synthetic */ boolean c(c cVar, String[] strArr) {
        return a((j) cVar, strArr);
    }

    public k(e eVar) {
        super(eVar, j.gTP, "FavItemInfo", null);
        this.gUz = eVar;
    }

    public final j bT(long j) {
        if (this.gUz == null) {
            w.e("MicroMsg.FavItemInfoStorage", "getBtLocalId, but db is null, return");
            return null;
        }
        Cursor a = this.gUz.a("FavItemInfo", null, "localId=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            j jVar = new j();
            try {
                jVar.b(a);
                a.close();
                return jVar;
            } catch (Exception e) {
                w.e("MicroMsg.FavItemInfoStorage", "getByLocalId convertFrom(cu) cause IlleagalStateException, return null");
                a.close();
                return null;
            }
        }
        w.w("MicroMsg.FavItemInfoStorage", "klem getByLocalId:%d, no data", new Object[]{Long.valueOf(j)});
        a.close();
        return null;
    }

    public final j bU(long j) {
        Cursor rawQuery = this.gUz.rawQuery("Select * from FavItemInfo where id = " + j, null);
        if (rawQuery.getCount() != 0) {
            j jVar = new j();
            rawQuery.moveToFirst();
            try {
                jVar.b(rawQuery);
                rawQuery.close();
                return jVar;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.FavItemInfoStorage", e, "", new Object[0]);
                w.e("MicroMsg.FavItemInfoStorage", "getByFavId(%d),info.convertFrom error", new Object[]{Long.valueOf(j)});
                rawQuery.close();
                return null;
            }
        }
        w.w("MicroMsg.FavItemInfoStorage", "klem getByFavId:%d, no data", new Object[]{Long.valueOf(j)});
        rawQuery.close();
        return null;
    }

    public final j vS(String str) {
        Cursor a = this.gUz.a("FavItemInfo", null, "sourceId=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            j jVar = new j();
            jVar.b(a);
            a.close();
            return jVar;
        }
        w.w("MicroMsg.FavItemInfoStorage", "klem getBySourceId:%s, no data", new Object[]{str});
        a.close();
        return null;
    }

    public final boolean c(j jVar) {
        Assert.assertTrue(jVar.field_localId > 0);
        if (jVar.field_favProto.tzl != null) {
            rw rwVar = jVar.field_favProto.tzl;
            if (rwVar.fFq <= 0) {
                w.w("MicroMsg.FavItemInfoStorage", "insert::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[]{Integer.valueOf(jVar.field_id), Long.valueOf(jVar.field_localId), Integer.valueOf(jVar.field_type), Integer.valueOf(rwVar.fFq)});
                rwVar.yj(1);
            } else {
                rwVar.yj(rwVar.fFq);
            }
        }
        e(jVar);
        boolean a = a(jVar, false);
        if (a) {
            a(jVar.field_localId, 2, Long.valueOf(jVar.field_localId));
        }
        return a;
    }

    public final boolean a(j jVar, String... strArr) {
        if (jVar.field_favProto.tzl != null) {
            rw rwVar = jVar.field_favProto.tzl;
            if (rwVar.fFq <= 0) {
                w.w("MicroMsg.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[]{Integer.valueOf(jVar.field_id), Long.valueOf(jVar.field_localId), Integer.valueOf(jVar.field_type), Integer.valueOf(rwVar.fFq)});
                rwVar.yj(1);
            } else {
                rwVar.yj(rwVar.fFq);
            }
        }
        e(jVar);
        boolean a = super.a(jVar, false, strArr);
        if (a) {
            a(jVar.field_localId, 3, Long.valueOf(jVar.field_localId));
        }
        w.d("MicroMsg.FavItemInfoStorage", "update result[%B]", new Object[]{Boolean.valueOf(a)});
        return a;
    }

    public final boolean n(long j, int i) {
        String str = "select count(updateTime) from FavItemInfo where updateTime < " + j;
        if (i != -1) {
            str = str + " and type = " + i;
        }
        Cursor a = this.gUz.a(str, null, 2);
        if (a == null) {
            return true;
        }
        a.moveToFirst();
        if (a.getInt(0) == 0) {
            a.close();
            return true;
        }
        a.close();
        return false;
    }

    public final LinkedList<Integer> p(long j, int i) {
        LinkedList<Integer> linkedList = new LinkedList();
        String str = "select id from FavItemInfo where updateTime >= " + j;
        if (i != -1) {
            str = str + " and type = " + i;
        }
        Cursor a = this.gUz.a((str + " and updateSeq > localSeq") + " order by updateTime desc", null, 2);
        if (a == null) {
            return linkedList;
        }
        while (a.moveToNext()) {
            linkedList.add(Integer.valueOf(a.getInt(0)));
        }
        a.close();
        return linkedList;
    }

    public final List<j> a(long j, int i, Set<Integer> set, a aVar) {
        if (set == null || !set.contains(Integer.valueOf(i))) {
            String str;
            List<j> arrayList = new ArrayList();
            String str2 = "select " + lEl + " from FavItemInfo where updateTime" + " >= " + j;
            if (i != -1) {
                str = str2 + " and type = " + i;
            } else if (set != null) {
                str = str2;
                for (Integer intValue : set) {
                    str = str + " and type != " + intValue.intValue();
                }
            } else {
                str = str2;
            }
            Cursor a = this.gUz.a((str + " and itemStatus > 0") + " order by updateTime desc", null, 2);
            if (a == null) {
                return arrayList;
            }
            while (a.moveToNext()) {
                j jVar = new j();
                try {
                    jVar.b(a);
                    if (aVar == null || !aVar.g(jVar)) {
                        arrayList.add(jVar);
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.FavItemInfoStorage", "fav getlist convertfrom (cu) error,continue");
                }
            }
            a.close();
            return arrayList;
        }
        w.w("MicroMsg.FavItemInfoStorage", "getList::block set contains target type, error, do return null");
        return null;
    }

    public final void r(int i, long j) {
        w.d("MicroMsg.FavItemInfoStorage", "setStatus status:%d,localId:%d", new Object[]{Integer.valueOf(i), Long.valueOf(j)});
        this.gUz.eE("FavItemInfo", "update FavItemInfo set itemStatus = " + i + " where localId = " + j);
        Qr(String.valueOf(j));
    }

    public final void d(j jVar) {
        String str = "delete from FavItemInfo where localId = " + jVar.field_localId;
        w.i("MicroMsg.FavItemInfoStorage", "delete sql: " + str);
        this.gUz.eE("FavItemInfo", str);
        a(jVar.field_localId, 5, Long.valueOf(jVar.field_localId));
    }

    public final List<j> atp() {
        List<j> list = null;
        Cursor a = this.gUz.a("select " + lEl + " from FavItemInfo where itemStatus" + "=3 or itemStatus" + "=6 or itemStatus" + "=11 or itemStatus" + "=14 or itemStatus" + "=16 or itemStatus" + "=18", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                list = new ArrayList();
                do {
                    j jVar = new j();
                    jVar.b(a);
                    list.add(jVar);
                } while (a.moveToNext());
            }
            a.close();
        }
        return list;
    }

    public final ArrayList<j> a(List<Long> list, List<j> list2, Set<Integer> set, a aVar) {
        if (list == null || list.size() == 0 || list.size() > 20) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("select ").append(lEl).append(" from FavItemInfo where ");
        if (set != null && set.size() > 0) {
            stringBuffer.append("( 1=1");
            for (Integer append : set) {
                stringBuffer.append(" and type != ").append(append);
            }
            stringBuffer.append(") and ");
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                stringBuffer.append("( ");
            }
            if (i == size - 1) {
                stringBuffer.append("localId = ").append(list.get(i)).append(" )");
            } else {
                stringBuffer.append("localId = ").append(list.get(i)).append(" or ");
            }
        }
        stringBuffer.append(" order by updateTime desc");
        w.d("MicroMsg.FavItemInfoStorage", "get list by id list sql %s", new Object[]{stringBuffer.toString()});
        Cursor a = this.gUz.a(r0, null, 2);
        if (a == null) {
            return null;
        }
        ArrayList<j> arrayList;
        if (a.moveToFirst()) {
            ArrayList<j> arrayList2 = new ArrayList();
            do {
                j jVar;
                if (list2 == null || list2.isEmpty()) {
                    jVar = new j();
                } else {
                    jVar = (j) list2.remove(0);
                }
                jVar.b(a);
                if (aVar == null || !aVar.g(jVar)) {
                    arrayList2.add(jVar);
                } else {
                    w.w("MicroMsg.FavItemInfoStorage", "id[%d] type[%d] match filter", new Object[]{Integer.valueOf(jVar.field_id), Integer.valueOf(jVar.field_type)});
                }
            } while (a.moveToNext());
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        a.close();
        return arrayList;
    }

    public final boolean b(j jVar, String... strArr) {
        if (jVar.field_favProto.tzl != null) {
            rw rwVar = jVar.field_favProto.tzl;
            if (rwVar.fFq <= 0) {
                w.w("MicroMsg.FavItemInfoStorage", "update::favid %d favlocalid %d type %d, sourceTypeError %d", new Object[]{Integer.valueOf(jVar.field_id), Long.valueOf(jVar.field_localId), Integer.valueOf(jVar.field_type), Integer.valueOf(rwVar.fFq)});
                rwVar.yj(1);
            } else {
                rwVar.yj(rwVar.fFq);
            }
        }
        return super.a(jVar, false, strArr);
    }

    public static long e(j jVar) {
        for (int i : x.lFh) {
            if (i == jVar.field_type) {
                long j;
                if (jVar.field_favProto != null) {
                    Iterator it = jVar.field_favProto.tzn.iterator();
                    j = 0;
                    while (it.hasNext()) {
                        j = ((rm) it.next()).txD + j;
                    }
                } else {
                    j = 0;
                }
                jVar.field_datatotalsize = j;
                w.d("MicroMsg.FavItemInfoStorage", "calFavItemInfoTotalLength id:%d,length:%d", new Object[]{Integer.valueOf(jVar.field_id), Long.valueOf(j)});
                return j;
            }
        }
        return 0;
    }

    public final List<Long> atq() {
        List arrayList = new ArrayList();
        Cursor a = this.gUz.a("select localId from FavItemInfo" + " order by updateTime desc", null, 2);
        if (a != null) {
            if (a.getCount() == 0) {
                a.close();
            } else {
                while (a.moveToNext()) {
                    arrayList.add(Long.valueOf(a.getLong(0)));
                }
                a.close();
            }
        }
        return arrayList;
    }
}
