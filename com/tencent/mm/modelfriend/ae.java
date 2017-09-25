package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.w;

public final class ae extends m {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS qqlist ( qq long  PRIMARY KEY , wexinstatus int  , groupid int  , username text  , nickname text  , pyinitial text  , quanpin text  , qqnickname text  , qqpyinitial text  , qqquanpin text  , qqremark text  , qqremarkpyinitial text  , qqremarkquanpin text  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int  ) ", "CREATE INDEX IF NOT EXISTS groupid_index ON qqlist ( groupid ) ", "CREATE INDEX IF NOT EXISTS qq_index ON qqlist ( qq ) "};
    public final g hnH;

    public ae(g gVar) {
        this.hnH = gVar;
    }

    public final Cursor v(int i, boolean z) {
        String str;
        String[] strArr;
        if (z) {
            str = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid=?  order by reserved3";
            strArr = new String[]{String.valueOf(i)};
        } else {
            str = "select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid=? and (wexinstatus=? or wexinstatus=?) order by reserved3";
            strArr = new String[]{String.valueOf(i), "1", "2"};
        }
        return this.hnH.a(str, strArr, 0);
    }

    public final Cursor b(int i, String str, boolean z) {
        w.d("MicroMsg.QQListStorage", "getByGroupID: GroupID:" + i + ", searchby:" + str);
        StringBuilder stringBuilder = new StringBuilder();
        if (z) {
            stringBuilder.append("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + i + "\" and ( ");
        } else {
            stringBuilder.append("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.groupid = \"" + i + "\" and (wexinstatus =\"1" + "\" or wexinstatus =\"2" + "\") and ( ");
        }
        stringBuilder.append("qqlist.qq like '%" + str + "%' or ");
        stringBuilder.append("qqlist.username like '%" + str + "%' or ");
        stringBuilder.append("qqlist.nickname like '%" + str + "%' or ");
        stringBuilder.append("qqlist.pyinitial like '%" + str + "%' or ");
        stringBuilder.append("qqlist.quanpin like '%" + str + "%' or ");
        stringBuilder.append("qqlist.qqnickname like '%" + str + "%' or ");
        stringBuilder.append("qqlist.qqpyinitial like '%" + str + "%' or ");
        stringBuilder.append("qqlist.qqquanpin like '%" + str + "%' or ");
        stringBuilder.append("qqlist.qqremark like '%" + str + "%' )");
        stringBuilder.append(" order by reserved3");
        return this.hnH.a(stringBuilder.toString(), null, 0);
    }

    public final ad af(long j) {
        ad adVar = null;
        Cursor a = this.hnH.a("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.qq = \"" + j + "\"", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                adVar = new ad();
                adVar.b(a);
            }
            a.close();
        }
        return adVar;
    }

    public final ad jk(String str) {
        ad adVar = null;
        Cursor a = this.hnH.a("select qqlist.qq,qqlist.wexinstatus,qqlist.groupid,qqlist.username,qqlist.nickname,qqlist.pyinitial,qqlist.quanpin,qqlist.qqnickname,qqlist.qqpyinitial,qqlist.qqquanpin,qqlist.qqremark,qqlist.qqremarkpyinitial,qqlist.qqremarkquanpin,qqlist.reserved1,qqlist.reserved2,qqlist.reserved3,qqlist.reserved4 from qqlist  where qqlist.username = \"" + str + "\"", null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                adVar = new ad();
                adVar.b(a);
            }
            a.close();
        }
        return adVar;
    }

    public final int a(long j, ad adVar) {
        int i = 0;
        ContentValues FO = adVar.FO();
        if (FO.size() > 0) {
            i = this.hnH.update("qqlist", FO, "qq=?", new String[]{String.valueOf(j)});
        }
        if (i > 0) {
            b(3, this, String.valueOf(j));
        }
        return i;
    }

    public final boolean a(ad adVar) {
        if (adVar == null) {
            return false;
        }
        w.d("MicroMsg.QQListStorage", "insert: name:" + adVar.FQ());
        adVar.fRW = -1;
        if (((int) this.hnH.insert("qqlist", "qq", adVar.FO())) == -1) {
            return false;
        }
        b(2, this, adVar.hCb);
        return true;
    }

    protected final boolean Fc() {
        if (this.hnH != null && !this.hnH.bKn()) {
            return true;
        }
        String str = "MicroMsg.QQListStorage";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.hnH == null ? "null" : Boolean.valueOf(this.hnH.bKn());
        w.w(str, str2, objArr);
        return false;
    }

    public final boolean fJ(int i) {
        boolean z = false;
        Cursor cursor = null;
        try {
            cursor = this.hnH.a("select reserved3 from qqlist where groupid=? and reserved3=?  limit 1", new String[]{String.valueOf(i), "0"}, 2);
            if (cursor != null && cursor.moveToFirst()) {
                z = true;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            w.e("MicroMsg.QQListStorage", "[cpan] check qq list show head faild.:%s", e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return z;
    }
}
