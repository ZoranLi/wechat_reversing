package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public final class t extends i<s> implements j {
    public static final String[] gUx = new String[]{i.a(s.gTP, "snsTagInfo2")};
    public e gUz;

    public t(e eVar) {
        super(eVar, s.gTP, "snsTagInfo2", null);
        this.gUz = eVar;
    }

    public static String bhY() {
        return "select tagId, tagName, count, rowid from snsTagInfo2";
    }

    public final s dI(long j) {
        String stringBuilder = new StringBuilder("select *, rowid from snsTagInfo2 where tagId = ? ").toString();
        Cursor a = this.gUz.a(stringBuilder, new String[]{String.valueOf(j)}, 2);
        s sVar = new s();
        if (a.moveToFirst()) {
            sVar.b(a);
        }
        a.close();
        return sVar;
    }

    public final List<String> dd(long j) {
        s dI = dI(j);
        if (dI.field_memberList == null || dI.field_memberList.equals("")) {
            return new ArrayList();
        }
        return bg.f(dI.field_memberList.split(","));
    }

    public final String de(long j) {
        return dI(j).field_tagName;
    }

    public final List<Long> bhZ() {
        Cursor a = this.gUz.a("snsTagInfo2", new String[]{"tagId"}, null, null, null, null, null, 2);
        List<Long> arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(Long.valueOf(a.getLong(0)));
        }
        a.close();
        return arrayList;
    }

    public final boolean a(s sVar) {
        if (sVar.field_tagId == 0) {
            return false;
        }
        long j = sVar.field_tagId;
        String stringBuilder = new StringBuilder("select *, rowid from snsTagInfo2 where tagId = ? ").toString();
        Cursor a = this.gUz.a(stringBuilder, new String[]{String.valueOf(j)}, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        if (moveToFirst) {
            super.a(sVar);
        } else {
            super.b(sVar);
        }
        return true;
    }

    public final int dJ(long j) {
        return this.gUz.delete("snsTagInfo2", " tagId = ? ", new String[]{String.valueOf(j)});
    }

    public final boolean o(long j, String str) {
        String str2 = "select tagId, tagName, count, rowid from snsTagInfo2 where tagId > 5" + " AND  tagName  =\"" + bg.my(str) + "\" AND  tagId != " + j;
        w.d("MicroMsg.SnsTagInfoStorage", "isTagNameExist " + str2);
        Cursor a = this.gUz.a(str2, null, 2);
        boolean moveToFirst = a.moveToFirst();
        a.close();
        return moveToFirst;
    }

    public final Cursor getCursor() {
        return this.gUz.rawQuery(new StringBuilder("select *, rowid from snsTagInfo2 where tagId > 5").toString(), null);
    }

    public final boolean P(String str, long j) {
        s dI = dI(5);
        if (bg.mA(dI.field_memberList)) {
            return false;
        }
        return bg.f(dI.field_memberList.split(",")).contains(str);
    }

    public final boolean bdy() {
        if (bhZ().size() == 0) {
            return false;
        }
        return true;
    }
}
