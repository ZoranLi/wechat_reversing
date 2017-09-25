package com.tencent.mm.modelfriend;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.bj.g;
import com.tencent.mm.pluginsdk.l.b;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public final class c extends m implements b {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS addr_upload2 ( id int  PRIMARY KEY , md5 text  , peopleid text  , uploadtime long  , realname text  , realnamepyinitial text  , realnamequanpin text  , username text  , nickname text  , nicknamepyinitial text  , nicknamequanpin text  , type int  , moblie text  , email text  , status int  , reserved1 text  , reserved2 text  , reserved3 int  , reserved4 int , lvbuf BLOG , showhead int  ) ", "CREATE INDEX IF NOT EXISTS upload_time_index ON addr_upload2 ( uploadtime ) ", "CREATE INDEX IF NOT EXISTS addr_upload_user_index ON addr_upload2 ( username ) "};
    public final g hnH;

    public c(g gVar) {
        Object obj = null;
        this.hnH = gVar;
        String str = "addr_upload2";
        Cursor a = gVar.a("PRAGMA table_info( " + str + " )", null, 2);
        int columnIndex = a.getColumnIndex("name");
        Object obj2 = null;
        while (a.moveToNext()) {
            if (columnIndex >= 0) {
                String string = a.getString(columnIndex);
                if ("lvbuf".equalsIgnoreCase(string)) {
                    obj2 = 1;
                } else if ("showhead".equalsIgnoreCase(string)) {
                    obj = 1;
                }
            }
        }
        a.close();
        if (obj2 == null) {
            gVar.eE(str, "Alter table " + str + " add lvbuf BLOB ");
        }
        if (obj == null) {
            gVar.eE(str, "Alter table " + str + " add showhead int ");
        }
    }

    public final boolean A(List<String> list) {
        if (list.size() <= 0) {
            return false;
        }
        boolean z;
        be beVar = new be("MicroMsg.AddrUploadStorage", "delete transaction");
        beVar.addSplit("begin");
        long cs = this.hnH.cs(Thread.currentThread().getId());
        try {
            for (String str : list) {
                if (str != null && str.length() > 0) {
                    int delete = this.hnH.delete("addr_upload2", "id =?", new String[]{b.iX(str)});
                    w.d("MicroMsg.AddrUploadStorage", "delete addr_upload2 md5 :" + str + ", res:" + delete);
                    if (delete > 0) {
                        b(5, this, str);
                    }
                }
            }
            z = true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.AddrUploadStorage", e, "", new Object[0]);
            z = false;
        }
        this.hnH.aD(cs);
        beVar.addSplit("end");
        beVar.dumpToLog();
        return z;
    }

    public final boolean z(List<b> list) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        boolean z;
        be beVar = new be("MicroMsg.AddrUploadStorage", "transaction");
        beVar.addSplit("transation begin");
        long cs = this.hnH.cs(Thread.currentThread().getId());
        for (int i = 0; i < list.size(); i++) {
            b bVar = (b) list.get(i);
            if (bVar != null) {
                boolean z2;
                Cursor a = this.hnH.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where addr_upload2.id = \"" + b.iX(bVar.EP()) + "\"", null, 2);
                if (a == null) {
                    z2 = false;
                } else {
                    try {
                        z2 = a.moveToFirst();
                        a.close();
                    } catch (Exception e) {
                        w.e("MicroMsg.AddrUploadStorage", e.getMessage());
                        z = false;
                    }
                }
                if (z2) {
                    int iX = b.iX(bVar.EP());
                    ContentValues pv = bVar.pv();
                    int i2 = 0;
                    if (pv.size() > 0) {
                        i2 = this.hnH.update("addr_upload2", pv, "id=?", new String[]{String.valueOf(iX)});
                    }
                    if (i2 == 0) {
                        w.i("MicroMsg.AddrUploadStorage", "batchSet update result=0, num:%s email:%s", bVar.EX(), bVar.EY());
                    } else if (i2 < 0) {
                        w.i("MicroMsg.AddrUploadStorage", "batchSet update failed, num:%s email:%s", bVar.EX(), bVar.EY());
                        z = true;
                        break;
                    } else {
                        b(3, this, bVar.EP());
                    }
                } else {
                    bVar.fRW = -1;
                    if (((int) this.hnH.insert("addr_upload2", SlookAirButtonFrequentContactAdapter.ID, bVar.pv())) == -1) {
                        w.i("MicroMsg.AddrUploadStorage", "batchSet insert failed, num:%s email:%s", bVar.EX(), bVar.EY());
                        z = true;
                        break;
                    }
                    b(2, this, bVar.EP());
                }
            }
        }
        z = true;
        this.hnH.aD(cs);
        beVar.addSplit("transation end");
        beVar.dumpToLog();
        return z;
    }

    public final boolean B(List<String> list) {
        boolean z;
        be beVar = new be("MicroMsg.AddrUploadStorage", "set uploaded transaction");
        beVar.addSplit("transation begin");
        long cs = this.hnH.cs(Thread.currentThread().getId());
        try {
            for (String str : list) {
                if (str != null && str.length() > 0) {
                    b bVar = new b();
                    bVar.fRW = 8;
                    bVar.hAt = bg.Ny();
                    ContentValues pv = bVar.pv();
                    int i = 0;
                    if (pv.size() > 0) {
                        i = this.hnH.update("addr_upload2", pv, "id=?", new String[]{b.iX(str)});
                    }
                    w.i("MicroMsg.AddrUploadStorage", "local contact uploaded : " + str + ", update result: " + i);
                }
            }
            z = true;
        } catch (Exception e) {
            w.e("MicroMsg.AddrUploadStorage", e.getMessage());
            z = false;
        }
        this.hnH.aD(cs);
        beVar.addSplit("transation end");
        beVar.dumpToLog();
        if (z) {
            b(3, this, null);
        }
        return z;
    }

    public final int a(String str, b bVar) {
        int i = 0;
        ContentValues pv = bVar.pv();
        if (pv.size() > 0) {
            i = this.hnH.update("addr_upload2", pv, "id=?", new String[]{b.iX(str)});
        }
        if (i > 0) {
            if (bVar.EP().equals(str)) {
                b(3, this, str);
            } else {
                b(5, this, str);
                b(2, this, bVar.EP());
            }
        }
        return i;
    }

    public final b iZ(String str) {
        if (bg.mA(str)) {
            return null;
        }
        b bVar = new b();
        Cursor a = this.hnH.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 where addr_upload2.username=\"" + bg.my(str) + "\"", null, 2);
        w.d("MicroMsg.AddrUploadStorage", "get addrUpload :" + str);
        if (a.moveToFirst()) {
            bVar.b(a);
        }
        a.close();
        return bVar;
    }

    public final b ae(long j) {
        b bVar = new b();
        Cursor a = this.hnH.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 WHERE id=" + Long.toString(j) + ';', null, 2);
        if (a.moveToFirst()) {
            bVar.b(a);
        }
        a.close();
        return bVar;
    }

    public final b ja(String str) {
        b bVar = null;
        if (str != null && str.length() > 0) {
            Cursor a = this.hnH.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2 where addr_upload2.id=\"" + b.iX(str) + "\"", null, 2);
            if (a.moveToFirst()) {
                bVar = new b();
                bVar.b(a);
            }
            w.d("MicroMsg.AddrUploadStorage", "get addrUpload :" + str + ", resCnt:" + (bVar != null ? 1 : 0));
            a.close();
        }
        return bVar;
    }

    public final List<String[]> Fb() {
        Cursor a = this.hnH.a("select addr_upload2.moblie , addr_upload2.md5 from addr_upload2 where addr_upload2.type = 0", null, 2);
        List<String[]> arrayList = new ArrayList();
        while (a.moveToNext()) {
            arrayList.add(new String[]{a.getString(0), a.getString(1)});
        }
        a.close();
        return arrayList;
    }

    public final List<b> jb(String str) {
        w.d("MicroMsg.AddrUploadStorage", "sql : " + str);
        List<b> arrayList = new ArrayList();
        w.d("MicroMsg.AddrUploadStorage", "sql : " + str);
        Cursor a = this.hnH.a(str, null, 2);
        while (a.moveToNext()) {
            b bVar = new b();
            bVar.b(a);
            arrayList.add(bVar);
        }
        a.close();
        return arrayList;
    }

    protected final boolean Fc() {
        if (this.hnH != null && !this.hnH.bKn()) {
            return true;
        }
        String str = "MicroMsg.AddrUploadStorage";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.hnH == null ? "null" : Boolean.valueOf(this.hnH.bKn());
        w.w(str, str2, objArr);
        return false;
    }

    public final String jc(String str) {
        b ja = ja(str);
        if (ja != null) {
            return ja.getUsername();
        }
        return null;
    }

    public final String jd(String str) {
        Cursor a;
        Exception e;
        Throwable th;
        if (!bg.mA(str)) {
            try {
                a = this.hnH.a("addr_upload2", null, "peopleid=?", new String[]{str}, null, null, null, 2);
                try {
                    if (a.moveToFirst()) {
                        b bVar = new b();
                        bVar.b(a);
                        String username = bVar.getUsername();
                        if (a == null) {
                            return username;
                        }
                        a.close();
                        return username;
                    } else if (a != null) {
                        a.close();
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        w.e("MicroMsg.AddrUploadStorage", "getFriendUsernameBySystemAddrBookPeopleId, error:%s", e.getMessage());
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (a != null) {
                            a.close();
                        }
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                a = null;
                w.e("MicroMsg.AddrUploadStorage", "getFriendUsernameBySystemAddrBookPeopleId, error:%s", e.getMessage());
                if (a != null) {
                    a.close();
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                a = null;
                if (a != null) {
                    a.close();
                }
                throw th;
            }
        }
        return null;
    }
}
