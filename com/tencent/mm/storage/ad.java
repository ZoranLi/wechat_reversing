package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.bj.c;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.b.af;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.u.o;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ad extends m implements ar {
    public static final String[] gUx = new String[]{i.a(x.gTP, "rcontact"), i.a(x.gTP, "bottlecontact"), i.a(y.gTP, "ContactCmdBuf"), "CREATE TABLE IF NOT EXISTS contact ( contactID INTEGER PRIMARY KEY, sex INT, type INT, showHead INT, username VARCHAR(40), nickname VARCHAR(40), pyInitial VARCHAR(40), quanPin VARCHAR(60), reserved TEXT );", "CREATE TABLE IF NOT EXISTS contact_ext ( username VARCHAR(40), Uin INTEGER DEFAULT 0, Email VARCHAR(128), Mobile VARCHAR(40), ShowFlag INTEGER DEFAULT 0 , ConType INTEGER DEFAULT 0 , ConRemark TEXT, ConRemark_PYShort TEXT, ConRemark_PYFull TEXT, ConQQMBlog TEXT, ConSMBlog TEXT, DomainList TEXT, reserved1 INT DEFAULT 0 , reserved2 INT DEFAULT 0 , reserved3 INT DEFAULT 0 , reserved4 INT DEFAULT 0 , reserved5 INT DEFAULT 0 , reserved6 TEXT, reserved7 TEXT, reserved8 TEXT, reserved9 TEXT, reserved10 TEXT, weiboflag  INT DEFAULT 0 ,weibonickname TEXT  );"};
    public static final String[] gaK = new String[]{"CREATE UNIQUE INDEX IF NOT EXISTS  contact_username_unique_index ON rcontact ( username )", "CREATE INDEX IF NOT EXISTS  contact_alias_index ON rcontact ( alias )", "CREATE INDEX IF NOT EXISTS  en_username_unique_index ON rcontact ( encryptUsername )", "CREATE UNIQUE INDEX IF NOT EXISTS  bottle_username_unique_index ON bottlecontact ( username )", "CREATE INDEX IF NOT EXISTS type_verifyFlag_index ON rcontact ( type,verifyFlag ) "};
    private static String uIR = "showHead = 32";
    private static String uIS = "type & 64 !=0 ";
    private e gUz;
    private final k<a, x> hug = new k<a, x>(this) {
        final /* synthetic */ ad uIT;

        {
            this.uIT = r1;
        }

        protected final /* synthetic */ void o(Object obj, Object obj2) {
            ((a) obj).a(this.uIT, (x) obj2);
        }
    };
    private e uIO;
    public final f<String, x> uIP = new f(com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX);
    public final f<String, Integer> uIQ = new f(400);

    private static String QV(String str) {
        return "select *,rowid from " + QW(str) + " ";
    }

    private static String QW(String str) {
        if (x.eO(str)) {
            return "bottlecontact";
        }
        return "rcontact";
    }

    public ad(g gVar) {
        int i = 1;
        int i2 = 0;
        Cursor a = gVar.a("PRAGMA table_info( contact_ext )", null, 2);
        int columnIndex = a.getColumnIndex("name");
        int i3 = 0;
        int i4 = 0;
        while (a.moveToNext() && (i4 == 0 || i3 == 0)) {
            if (columnIndex >= 0) {
                String string = a.getString(columnIndex);
                if ("weiboNickname".equalsIgnoreCase(string)) {
                    i3 = 1;
                } else if ("weiboFlag".equalsIgnoreCase(string)) {
                    i4 = 1;
                }
            }
        }
        a.close();
        if (i4 == 0) {
            gVar.eE("contact_ext", "Alter table contact_ext add weiboFlag INT DEFAULT 0 ");
        }
        if (i3 == 0) {
            gVar.eE("contact_ext", "Alter table contact_ext add weiboNickname INT DEFAULT 0 ");
        }
        Cursor a2 = gVar.a("PRAGMA table_info( rcontact )", null, 2);
        i4 = a2.getColumnIndex("name");
        while (a2.moveToNext()) {
            if (i4 >= 0) {
                if ("verifyFlag".equalsIgnoreCase(a2.getString(i4))) {
                    break;
                }
            }
        }
        i = 0;
        a2.close();
        if (i == 0) {
            gVar.eE("rcontact", "Alter table rcontact add verifyFlag INT DEFAULT 0 ");
        }
        for (String eE : i.a(com.tencent.mm.j.a.gTP, "bottlecontact", (e) gVar)) {
            gVar.eE("bottlecontact", eE);
        }
        for (String eE2 : i.a(com.tencent.mm.j.a.gTP, "rcontact", (e) gVar)) {
            gVar.eE("rcontact", eE2);
        }
        String[] strArr = gaK;
        i = strArr.length;
        while (i2 < i) {
            gVar.eE("rcontact", strArr[i2]);
            i2++;
        }
        this.gUz = gVar;
        this.uIO = gVar;
    }

    public final void a(a aVar) {
        this.hug.a(aVar, null);
    }

    public final void b(a aVar) {
        if (this.hug != null) {
            this.hug.remove(aVar);
        }
    }

    public final x QX(String str) {
        x xVar = (x) this.uIP.get(str);
        return xVar != null ? xVar : null;
    }

    public final void O(x xVar) {
        if (xVar != null && xVar.field_username != null && xVar.field_type != 0) {
            this.uIP.k(xVar.field_username, xVar);
            this.uIQ.k(xVar.field_username, Integer.valueOf(xVar.field_type));
        }
    }

    private void DZ(String str) {
        if (!bg.mA(str)) {
            this.uIP.remove(str);
            this.uIQ.remove(str);
        }
    }

    public final boolean QY(String str) {
        if (bg.mA(str) || (str.contains("@") && !str.endsWith("@stranger"))) {
            return false;
        }
        Integer num = (Integer) this.uIQ.get(str);
        if (num != null) {
            return com.tencent.mm.j.a.ez(num.intValue());
        }
        af Rc = Rc(str);
        if (Rc == null || !(Rc.field_username.equals(str) || str.equals(Rc.field_encryptUsername))) {
            this.uIQ.k(str, Integer.valueOf(0));
            return false;
        }
        this.uIQ.k(str, Integer.valueOf(Rc.field_type));
        return com.tencent.mm.j.a.ez(Rc.field_type);
    }

    public final boolean P(x xVar) {
        if (Re(xVar.field_username)) {
            if (a(xVar.field_username, xVar) == 0) {
                return true;
            }
            return false;
        } else if (S(xVar) < 0) {
            return false;
        } else {
            return true;
        }
    }

    public final x QZ(String str) {
        if (bg.mA(str)) {
            return null;
        }
        x xVar = new x();
        Cursor a = this.gUz.a("select *,rowid from rcontact where alias=" + g.dP(str), null, 2);
        if (a.moveToFirst()) {
            xVar.b(a);
            O(xVar);
        }
        a.close();
        xVar.bLj();
        return xVar;
    }

    public final Cursor a(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2) {
        String str3 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff from rcontact " + e(str, str2, list) + cg(list2) + bLw();
        w.v("MicroMsg.ContactStorage", str3);
        if (!z) {
            return this.gUz.a(str3, null, 4);
        }
        com.tencent.mm.bj.a.f[] fVarArr = new com.tencent.mm.bj.a.f[2];
        String str4 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff from rcontact " + i(list, z2) + bLx();
        w.v("MicroMsg.ContactStorage", "favourSql " + str3);
        Cursor a = this.gUz.a(str4, null, 4);
        Cursor a2 = this.gUz.a(str3, null, 4);
        if (!(a instanceof com.tencent.mm.bj.a.f) || !(a2 instanceof com.tencent.mm.bj.a.f)) {
            return c.bNI();
        }
        fVarArr[0] = (com.tencent.mm.bj.a.f) a;
        fVarArr[1] = (com.tencent.mm.bj.a.f) a2;
        return new com.tencent.mm.bj.a.e(fVarArr);
    }

    public final Cursor cc(List<String> list) {
        boolean z;
        int i = 0;
        if (list.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String str = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,type from rcontact  where ";
        while (i < list.size()) {
            if (i != list.size() - 1) {
                str = str + "username = '" + ((String) list.get(i)) + "' OR ";
            } else {
                str = str + "username = '" + ((String) list.get(i)) + "'";
            }
            i++;
        }
        return this.gUz.rawQuery(str + bLw(), null);
    }

    public final Cursor cd(List<String> list) {
        boolean z;
        int i = 0;
        if (list.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String str = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff from rcontact  where ";
        while (i < list.size()) {
            if (i != list.size() - 1) {
                str = str + "username = '" + ((String) list.get(i)) + "' OR ";
            } else {
                str = str + "username = '" + ((String) list.get(i)) + "'";
            }
            i++;
        }
        return this.gUz.rawQuery(str + bLw(), null);
    }

    public final Cursor b(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2) {
        String str3 = "select username from rcontact " + e(str, str2, list) + cg(list2) + bLw();
        w.v("MicroMsg.ContactStorage", str3);
        if (!z) {
            return this.gUz.rawQuery(str3, null);
        }
        com.tencent.mm.bj.a.f[] fVarArr = new com.tencent.mm.bj.a.f[2];
        String str4 = "select username from rcontact " + i(list, z2) + bLx();
        w.v("MicroMsg.ContactStorage", "favourSql " + str3);
        Cursor a = this.gUz.a(str4, null, 4);
        Cursor a2 = this.gUz.a(str3, null, 4);
        if (!(a instanceof com.tencent.mm.bj.a.f) || !(a2 instanceof com.tencent.mm.bj.a.f)) {
            return c.bNI();
        }
        fVarArr[0] = (com.tencent.mm.bj.a.f) a;
        fVarArr[1] = (com.tencent.mm.bj.a.f) a2;
        return new com.tencent.mm.bj.a.e(fVarArr);
    }

    public final x Ra(String str) {
        if (bg.mA(str)) {
            return null;
        }
        if (x.eO(str)) {
            str = x.QR(str);
        }
        x QX = QX(str);
        if (QX != null) {
            QX.bLj();
            return QX;
        }
        QX = new x();
        Cursor a = this.gUz.a(QV(str) + " where username=" + g.dP(str), null, 2);
        if (a.moveToFirst()) {
            QX.b(a);
            O(QX);
        }
        a.close();
        QX.bLj();
        return QX;
    }

    public final x Rb(String str) {
        if (bg.mA(str)) {
            return null;
        }
        if (x.eO(str)) {
            str = x.QR(str);
        }
        x QX = QX(str);
        if (QX != null) {
            return QX;
        }
        QX = new x();
        Cursor a = this.gUz.a(QV(str) + " where username=" + g.dP(str) + " or encryptUsername=" + g.dP(str), null, 2);
        if (a.moveToFirst()) {
            QX.b(a);
            O(QX);
        }
        a.close();
        return QX;
    }

    public final x Rc(String str) {
        if (bg.mA(str)) {
            return null;
        }
        if (x.eO(str)) {
            str = x.QR(str);
        }
        x QX = QX(str);
        if (QX != null) {
            return QX;
        }
        QX = new x();
        Cursor a = this.gUz.a(QV(str) + " where username=" + g.dP(str) + " or encryptUsername=" + g.dP(str), null, 2);
        if (a.moveToFirst()) {
            QX.b(a);
            a.close();
            QX.bLj();
            O(QX);
        } else {
            a.close();
        }
        return QX;
    }

    public final x ez(long j) {
        x xVar = null;
        if (j > 0) {
            Cursor a = this.gUz.a("select * ,rowid from rcontact  where rowid=" + j, null, 2);
            if (a.moveToFirst()) {
                xVar = new x();
                xVar.b(a);
                O(xVar);
            }
            a.close();
            if (xVar != null) {
                xVar.bLj();
            }
        }
        return xVar;
    }

    public final long Rd(String str) {
        com.tencent.mm.j.a Rc = Rc(str);
        if (Rc == null || Rc.gTQ <= 0) {
            return -1;
        }
        return (long) ((int) Rc.gTQ);
    }

    public final boolean Re(String str) {
        af Rc = Rc(str);
        if (Rc == null || bg.mA(Rc.field_username) || !Rc.field_username.equals(str)) {
            return false;
        }
        return true;
    }

    public final boolean Rf(String str) {
        boolean z = false;
        if (!bg.mA(str)) {
            Cursor a = this.gUz.a("select count(*) from " + QW(str) + " where type & " + com.tencent.mm.j.a.tu() + " !=0 and username=" + g.dP(str), null, 2);
            if (a.moveToFirst() && a.getInt(0) > 0) {
                z = true;
            }
            a.close();
        }
        return z;
    }

    public final boolean Q(x xVar) {
        Assert.assertTrue("contact NULL !", xVar != null);
        if (!T(xVar)) {
            return true;
        }
        xVar.dc(xVar.sZ());
        this.hug.by(xVar);
        this.hug.doNotify();
        w.d("MicroMsg.ContactStorage", "replace : username=%s, showHead=%d, verifyFlag=%d", xVar.field_username, Integer.valueOf(xVar.field_showHead), Integer.valueOf(xVar.field_verifyFlag));
        ContentValues pv = xVar.pv();
        if (((int) xVar.gTQ) > 0) {
            pv.put("rowid", Integer.valueOf((int) xVar.gTQ));
        }
        boolean z = this.gUz.replace(QW(xVar.field_username), com.tencent.mm.j.a.gTP.uxc, pv) > 0;
        DZ(xVar.field_username);
        if (!bg.mA(xVar.field_encryptUsername)) {
            DZ(xVar.field_encryptUsername);
        }
        if (!z) {
            return false;
        }
        b(4, this, xVar.field_username);
        return true;
    }

    public final boolean R(x xVar) {
        return S(xVar) > 0;
    }

    public final int S(x xVar) {
        if (bg.mz(xVar.field_username).length() <= 0) {
            w.e("MicroMsg.ContactStorage", "FATAL ERROR, invalid contact, empty username");
            return -1;
        }
        int i;
        xVar.dc(xVar.sZ());
        this.hug.by(xVar);
        this.hug.doNotify();
        int insert = (int) this.gUz.insert(QW(xVar.field_username), com.tencent.mm.j.a.gTP.uxc, xVar.pv());
        int aA = (int) bg.aA(System.currentTimeMillis());
        boolean z = b.foreground;
        com.tencent.mm.plugin.report.c cVar = com.tencent.mm.plugin.report.c.oTb;
        int i2 = z ? 11 : 14;
        if (z) {
            i = 12;
        } else {
            i = 15;
        }
        cVar.c(463, i2, i, aA, false);
        w.i("MicroMsg.ContactStorage", "insert : username=%s, showHead=%d, verifyFlag=%d, ret=:%d take[%s]ms fg:%b", xVar.field_username, Integer.valueOf(xVar.field_showHead), Integer.valueOf(xVar.field_verifyFlag), Integer.valueOf(insert), Integer.valueOf(aA), Boolean.valueOf(z));
        if (insert != -1) {
            xVar.gTQ = (long) insert;
            O(xVar);
            b(2, this, xVar.field_username);
            return insert;
        }
        w.e("MicroMsg.ContactStorage", "insert failed: username=" + xVar.field_username);
        return -1;
    }

    public final int x(String str, byte[] bArr) {
        int i = -1;
        if (bg.mA(str)) {
            w.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
            return -1;
        }
        y yVar = new y();
        yVar.field_cmdbuf = bArr;
        yVar.field_username = str;
        int replace = (int) this.gUz.replace("ContactCmdBuf", "username", yVar.pv());
        String str2 = "MicroMsg.ContactStorage";
        String str3 = "setCmdbuf user:%s buf:%d result:%d";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        if (bArr != null) {
            i = bArr.length;
        }
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(replace);
        w.d(str2, str3, objArr);
        return replace;
    }

    public final byte[] Rg(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
            return null;
        }
        y yVar = new y();
        Cursor a = this.gUz.a("ContactCmdBuf", null, "username=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            yVar.b(a);
        }
        a.close();
        String str2 = "MicroMsg.ContactStorage";
        String str3 = "getCmdbuf user:%s buf:%d";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(yVar.field_cmdbuf == null ? -1 : yVar.field_cmdbuf.length);
        w.d(str2, str3, objArr);
        return yVar.field_cmdbuf;
    }

    public final int Rh(String str) {
        if (bg.mA(str)) {
            w.e("MicroMsg.ContactStorage", "delCmdBuf failed user is null");
            return -1;
        }
        w.d("MicroMsg.ContactStorage", "delCmdBuf user:%s ret:%d", str, Integer.valueOf(this.gUz.delete("ContactCmdBuf", "username=?", new String[]{str})));
        return this.gUz.delete("ContactCmdBuf", "username=?", new String[]{str});
    }

    public final int Ri(String str) {
        Assert.assertTrue(str.length() > 0);
        if (x.eO(str)) {
            str = x.QR(str);
        }
        DZ(str);
        x xVar = new x(str);
        xVar.setType(0);
        xVar.setUsername("fake_" + bg.Nz());
        xVar.bX("fake_" + bg.Nz());
        int update = this.gUz.update(QW(str), xVar.pv(), "username=?", new String[]{str});
        Rh(str);
        w.w("MicroMsg.ContactStorage", "delete (because the fucking talker id , dk just mark it  disappear .) user:%s res:%s %s", str, Integer.valueOf(update), bg.bJZ());
        if (update != 0) {
            b(5, this, str);
        }
        return update;
    }

    public final int a(String str, x xVar) {
        w.i("MicroMsg.ContactStorage", "begin to update contact : " + str);
        if (!T(xVar)) {
            return 1;
        }
        int update;
        long currentTimeMillis = System.currentTimeMillis();
        if (x.eO(str)) {
            str = x.QR(str);
        }
        xVar.dc(xVar.sZ());
        this.hug.by(xVar);
        this.hug.doNotify();
        ContentValues pv = xVar.pv();
        if (((int) xVar.gTQ) > 0) {
            pv.put("rowid", Integer.valueOf((int) xVar.gTQ));
        }
        if (pv.size() > 0) {
            update = this.gUz.update(QW(str), pv, "username=?", new String[]{str});
        } else {
            update = 0;
        }
        w.i("MicroMsg.ContactStorage", "update : username=%s, showHead=%d, verifyFlag=%d, result1=%d, take[%d]ms", xVar.field_username, Integer.valueOf(xVar.field_showHead), Integer.valueOf(xVar.field_verifyFlag), Integer.valueOf(update), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        DZ(str);
        if (!bg.mA(xVar.field_encryptUsername)) {
            DZ(xVar.field_encryptUsername);
        }
        if (update == 0) {
            return update;
        }
        b(4, this, str);
        return update;
    }

    public final int b(String str, x xVar) {
        int i = 0;
        if (bg.mA(str) || xVar == null || bg.mA(xVar.field_username)) {
            w.e("MicroMsg.ContactStorage", "update : wrong input!");
            return 0;
        }
        w.d("MicroMsg.ContactStorage", "updateEncryptUser contact: " + xVar.field_username + " enUsername: " + str);
        if (!T(xVar)) {
            return 1;
        }
        if (x.eO(xVar.field_username)) {
            xVar.setUsername(x.QR(xVar.field_username));
        }
        xVar.dc(xVar.sZ());
        this.hug.by(xVar);
        this.hug.doNotify();
        w.d("MicroMsg.ContactStorage", "update : oldUsername=%s, username=%s, showHead=%d, verifyFlag=%d", str, xVar.field_username, Integer.valueOf(xVar.field_showHead), Integer.valueOf(xVar.field_verifyFlag));
        ContentValues pv = xVar.pv();
        x xVar2;
        if (xVar.gTQ <= 0) {
            xVar2 = new x(str);
            xVar2.setType(0);
            xVar2.setUsername("fake_" + bg.Nz());
            xVar2.bX("fake_" + bg.Nz());
            w.d("MicroMsg.ContactStorage", "newContact.contactId <= 0 | delete " + QW(str) + " user :" + str + ", res:" + this.gUz.update(QW(str), xVar2.pv(), "username=?", new String[]{str}));
            if (pv.size() > 0) {
                i = (int) this.gUz.replace(QW(xVar.field_username), com.tencent.mm.j.a.gTP.uxc, pv);
            }
        } else if (!str.equals(xVar.field_username)) {
            xVar2 = new x(str);
            xVar2.setType(0);
            xVar2.setUsername("fake_" + bg.Nz());
            xVar2.bX("fake_" + bg.Nz());
            w.d("MicroMsg.ContactStorage", "delete " + QW(str) + " user :" + str + ", res:" + this.gUz.update(QW(str), xVar2.pv(), "username=?", new String[]{str}));
            if (pv.size() > 0) {
                i = this.gUz.update(QW(xVar.field_username), pv, "rowid=?", new String[]{xVar.gTQ});
            }
        } else if (pv.size() > 0) {
            w.i("MicroMsg.ContactStorage", "summercontact en equal username[%s], result1[%d], contactId[%d]", xVar.field_username, Integer.valueOf(this.gUz.update(QW(xVar.field_username), pv, "rowid=?", new String[]{xVar.gTQ})), Long.valueOf(xVar.gTQ));
            i = r1;
        }
        DZ(xVar.field_username);
        if (!bg.mA(xVar.field_encryptUsername)) {
            DZ(xVar.field_encryptUsername);
        }
        b(3, this, str);
        b(3, this, xVar.field_username);
        return i;
    }

    public final void c(String str, x xVar) {
        if (str != null) {
            if (x.eO(str)) {
                str = x.QR(str);
            }
            xVar.dc(xVar.sZ());
            if (o.d(xVar)) {
                xVar.dc(43);
                xVar.bS(com.tencent.mm.platformtools.c.mq(xVar.tK()));
                xVar.bT(com.tencent.mm.platformtools.c.mp(xVar.tK()));
                xVar.bV(com.tencent.mm.platformtools.c.mp(xVar.tL()));
                xVar.bW(xVar.tL());
                return;
            }
            if (o.fu(xVar.field_username)) {
                w.i("MicroMsg.ContactStorage", "update official account helper showhead %d", Integer.valueOf(31));
                xVar.dc(31);
            }
            this.hug.by(xVar);
            this.hug.doNotify();
            w.d("MicroMsg.ContactStorage", "username=%s, showHead=%d, verifyFlag=%d", xVar.field_username, Integer.valueOf(xVar.field_showHead), Integer.valueOf(xVar.field_verifyFlag));
            ContentValues pv = xVar.pv();
            if (((int) xVar.gTQ) > 0) {
                pv.put("rowid", Integer.valueOf((int) xVar.gTQ));
            }
            if (pv.size() > 0) {
                this.gUz.update(QW(str), pv, "username=?", new String[]{str});
            }
        }
    }

    public final Cursor ce(List<String> list) {
        boolean z;
        int i = 0;
        if (list.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String str = "select * ,rowid from rcontact  where ";
        while (i < list.size()) {
            if (i != list.size() - 1) {
                str = str + "username = '" + ((String) list.get(i)) + "' OR ";
            } else {
                str = str + "username = '" + ((String) list.get(i)) + "'";
            }
            i++;
        }
        return this.gUz.rawQuery(str + bLw(), null);
    }

    public final Cursor cf(List<String> list) {
        boolean z;
        int i = 0;
        if (list.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String str = "select * ,rowid from rcontact  where (";
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i2 != list.size() - 1) {
                str = str + "username = '" + ((String) list.get(i2)) + "' OR ";
            } else {
                str = str + "username = '" + ((String) list.get(i2)) + "'";
            }
        }
        str = str + ") order by case username ";
        while (i < list.size()) {
            str = str + " when '" + ((String) list.get(i)) + "' then " + i;
            i++;
        }
        str = str + " end";
        w.d("MicroMsg.ContactStorage", "getCursorByNamesInListOrder sql:" + str);
        return this.gUz.rawQuery(str, null);
    }

    public final List<String> bLq() {
        Cursor a = this.gUz.a("select username from rcontact where " + bLz(), null, 2);
        List arrayList = new ArrayList();
        if (a != null) {
            if (a.moveToFirst()) {
                do {
                    arrayList.add(a.getString(0));
                } while (a.moveToNext());
            }
            a.close();
        }
        return arrayList;
    }

    public final Cursor bLr() {
        return this.gUz.rawQuery("select * ,rowid from rcontact  where " + ("type & " + com.tencent.mm.j.a.tu() + "=0 and username like '%@chatroom" + "'"), null);
    }

    public final Cursor bLs() {
        String str = "select * ,rowid from rcontact " + bLy() + " AND type & 256" + " !=0 " + bLw();
        w.v("MicroMsg.ContactStorage", str);
        return this.gUz.rawQuery(str, null);
    }

    public final Cursor bLt() {
        String str = "select * ,rowid from rcontact  where " + uIS + " and verifyFlag & " + x.bLg() + " !=0 ";
        w.v("MicroMsg.ContactStorage", "dkbf:" + str);
        return this.gUz.rawQuery(str, null);
    }

    public final Cursor bLu() {
        String str = "select * ,rowid from rcontact " + bLy() + " AND " + uIS + " AND " + uIR + bLx();
        w.v("MicroMsg.ContactStorage", str);
        return this.gUz.rawQuery(str, null);
    }

    private static String cg(List<String> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : list) {
            stringBuilder.append(" or username = '").append(append).append("'");
        }
        return stringBuilder.toString();
    }

    public final Cursor a(String str, String str2, List<String> list, boolean z, boolean z2) {
        String str3 = "select * ,rowid from rcontact " + e(str, str2, list) + cg(null) + bLw();
        w.v("MicroMsg.ContactStorage", str3);
        return this.gUz.rawQuery(str3, null);
    }

    private static String ch(List<String> list) {
        String cg = cg(list);
        int indexOf = cg.indexOf("or");
        if (indexOf <= 2) {
            return cg.substring(indexOf + 2);
        }
        return cg;
    }

    public final Cursor h(List<String> list, boolean z) {
        String str = "select * ,rowid from rcontact  where " + ch(list);
        if (z) {
            str = str + " " + bLw();
        }
        w.d("MicroMsg.ContactStorage", "sql " + str);
        return this.gUz.rawQuery(str, null);
    }

    public final Cursor ci(List<String> list) {
        return this.gUz.rawQuery("select * ,rowid from rcontact where (" + uIS + ") and (" + ch(list) + ")" + bLx(), null);
    }

    public final Cursor cj(List<String> list) {
        String str = "select * ,rowid from rcontact " + i(list, false) + bLx();
        w.v("MicroMsg.ContactStorage", "favourSql " + str);
        return this.gUz.rawQuery(str, null);
    }

    public final Cursor c(String str, String str2, List<String> list) {
        return a(str, str2, (List) list, false, false);
    }

    public final Cursor d(String str, String str2, List<String> list) {
        String str3 = "select * ,rowid from rcontact " + e(str, str2, list) + bLw();
        w.v("MicroMsg.ContactStorage", str3);
        return this.gUz.rawQuery(str3, null);
    }

    public final int bLv() {
        int i = 0;
        String str = "select count(rowid) from rcontact " + e("@biz.contact", null, null);
        w.v("MicroMsg.ContactStorage", str);
        Cursor a = this.gUz.a(str, null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }

    public final List<String> ck(List<String> list) {
        if (list.isEmpty()) {
            w.w("MicroMsg.ContactStorage", "getFilterList: but white list is empty");
            return new LinkedList();
        }
        long NA = bg.NA();
        List<String> linkedList = new LinkedList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("username='").append((String) list.get(0)).append("'");
        for (int i = 1; i < list.size(); i++) {
            stringBuilder.append(" or username='").append((String) list.get(i)).append("'");
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("showHead asc, ");
        stringBuilder2.append("pyInitial asc, ");
        stringBuilder2.append("quanPin asc, ");
        stringBuilder2.append("nickname asc, ");
        stringBuilder2.append("username asc ");
        w.i("MicroMsg.ContactStorage", "getFilterList: sql is %s", String.format("select %s from %s where (%s) and (%s & %d != 0)  order by %s", new Object[]{"username", "rcontact", stringBuilder.toString(), Columns.TYPE, Integer.valueOf(com.tencent.mm.j.a.tt()), stringBuilder2.toString()}));
        Cursor a = this.gUz.a(r0, null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                linkedList.add(a.getString(0));
            }
            a.close();
        }
        w.i("MicroMsg.ContactStorage", "getFilerList: use time[%d ms] whiteList[%s], usernameList[%s]", Long.valueOf(bg.aB(NA)), list, linkedList.toString());
        return linkedList;
    }

    public final int[] b(String str, String str2, String[] strArr, List<String> list) {
        String str3 = "select distinct showHead from rcontact " + e(str, str2, list) + F(strArr) + bLw();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.gUz.rawQuery(str3, null);
        w.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct db.rawQuery last" + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount() >= 0 ? rawQuery.getCount() : 0;
        w.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct  cu.getCount() last" + (System.currentTimeMillis() - currentTimeMillis));
        int[] iArr = new int[count];
        if (rawQuery.getCount() > 0) {
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        return iArr;
    }

    public final int[] b(String str, String str2, String str3, List<String> list) {
        String str4 = "select distinct showHead from rcontact " + e(str, str2, list) + Rj(str3) + bLw();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.gUz.rawQuery(str4, null);
        w.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount() >= 0 ? rawQuery.getCount() : 0;
        w.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        int[] iArr = new int[count];
        if (rawQuery.getCount() > 0) {
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        return iArr;
    }

    public final int[] cl(List<String> list) {
        String str = "select distinct showHead from rcontact  where (" + ch(list) + ") " + bLw();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.gUz.rawQuery(str, null);
        w.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount() >= 0 ? rawQuery.getCount() : 0;
        w.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        int[] iArr = new int[count];
        if (rawQuery.getCount() > 0) {
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        return iArr;
    }

    public final int[] c(String str, String str2, String str3, List<String> list) {
        int[] iArr = null;
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.gUz.rawQuery(("select count(*) from rcontact " + e(str, str2, list) + Rj(str3)) + " group by showHead", null);
        w.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount();
        w.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        if (count > 0) {
            iArr = new int[count];
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        return iArr;
    }

    public final int[] cm(List<String> list) {
        int[] iArr = null;
        long currentTimeMillis = System.currentTimeMillis();
        Cursor a = this.gUz.a(("select count(*) from rcontact " + "where " + ch(list)) + " group by showHead", null, 2);
        w.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = a.getCount();
        w.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        if (count > 0) {
            iArr = new int[count];
            for (int i = 0; i < count; i++) {
                a.moveToPosition(i);
                iArr[i] = a.getInt(0);
            }
        }
        a.close();
        return iArr;
    }

    public final int[] c(String str, String str2, String[] strArr, List<String> list) {
        int[] iArr = null;
        Cursor rawQuery = this.gUz.rawQuery(("select count(*) from rcontact " + e(str, str2, list) + F(strArr)) + " group by showHead", null);
        if (rawQuery.getCount() > 0) {
            int count = rawQuery.getCount();
            iArr = new int[count];
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        return iArr;
    }

    public final Cursor a(String[] strArr, String str, List<String> list) {
        String str2 = "select * ,rowid from rcontact " + e(str, null, list) + F(strArr);
        if (strArr != null && strArr.length > 0) {
            String str3 = str2 + " order by 1=1 ";
            int length = strArr.length;
            str2 = str3;
            int i = 0;
            while (i < length) {
                i++;
                str2 = str2 + ",username='" + strArr[i] + "' desc";
            }
        }
        w.v("MicroMsg.ContactStorage", "getSearchCursorByArrOrder sql : " + str2);
        return this.gUz.rawQuery(str2, null);
    }

    public final Cursor a(String[] strArr, String str, String str2, List<String> list, List<String> list2) {
        String str3 = "select * ,rowid from rcontact " + e(str, str2, list2) + F(strArr) + n(str2, list) + bLw();
        w.i("MicroMsg.ContactStorage", str3);
        return this.gUz.rawQuery(str3, null);
    }

    private static String n(String str, List<String> list) {
        if (str == null || str.equals("")) {
            return "";
        }
        String str2 = " and (";
        if (!(list == null || list.size() == 0)) {
            String str3 = str2;
            for (String str22 : list) {
                str3 = str3 + "username = '" + str22 + "' or ";
            }
            str22 = str3;
        }
        return (((((((str22 + "conRemark like '%" + str + "%' or ") + "conRemarkPYFull like '%" + str + "%' or ") + "conRemarkPYShort like '%" + str + "%' or ") + "alias like '%" + str + "%' or ") + "username like '%" + str + "%' or ") + "nickname like '%" + str + "%' or ") + "pyInitial like '%" + str + "%' or ") + "quanPin like '%" + str + "%' )";
    }

    private static String F(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        String str = " and (";
        int i = 0;
        while (i < strArr.length) {
            if (i > 0) {
                str = str + " or ";
            }
            String str2 = str + "username = '" + strArr[i] + "' ";
            i++;
            str = str2;
        }
        return str + " )";
    }

    public final String Rj(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        return (((((((" and (" + "conRemark like '%" + str + "%' or ") + "conRemarkPYFull like '%" + str + "%' or ") + "conRemarkPYShort like '%" + str + "%' or ") + "alias like '%" + str + "%' or ") + "username like '%" + str + "%' or ") + "nickname like '%" + str + "%' or ") + "pyInitial like '%" + str + "%' or ") + "quanPin like '%" + str + "%' )";
    }

    private static String bLw() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" order by showHead asc, ");
        stringBuffer.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" case when length(conRemark) > 0 then upper(conRemark) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" upper(quanPin) asc, ");
        stringBuffer.append(" upper(nickname) asc, ");
        stringBuffer.append(" upper(username) asc ");
        return stringBuffer.toString();
    }

    public final String Dk() {
        return bLw();
    }

    public final String bLx() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" order by case when verifyFlag & " + x.bLg() + " != 0 then 0 else 1 end , showHead asc, ");
        stringBuffer.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" case when length(conRemark) > 0 then upper(conRemark) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" upper(quanPin) asc, ");
        stringBuffer.append(" upper(nickname) asc, ");
        stringBuffer.append(" upper(username) asc ");
        return stringBuffer.toString();
    }

    private static String G(boolean z, boolean z2) {
        String str = "type & " + com.tencent.mm.j.a.tt() + "!=0";
        if (z) {
            str = str + " or type & " + com.tencent.mm.j.a.tw() + "!=0";
        }
        str = ((" where (" + str + ")") + " and type & " + com.tencent.mm.j.a.tx() + "=0 ") + " and type & " + com.tencent.mm.j.a.tu() + " =0 ";
        if (z2) {
            return str;
        }
        return str + " and verifyFlag & " + x.bLg() + " =0 ";
    }

    private static String bLy() {
        return (" where (" + ("type & " + com.tencent.mm.j.a.tt() + "!=0") + ") and ") + "type & " + com.tencent.mm.j.a.tx() + "=0  ";
    }

    private static String bLz() {
        return "( (" + ("type & " + com.tencent.mm.j.a.tt() + "!=0") + ") and type & " + com.tencent.mm.j.a.tu() + "=0 and username like '%@chatroom" + "')";
    }

    private static String bLA() {
        return "( (" + ("type & " + com.tencent.mm.j.a.tt() + "!=0") + ") and type & " + com.tencent.mm.j.a.tu() + "=0 and username like '%@talkroom" + "')";
    }

    public final String i(List<String> list, boolean z) {
        String str = G(false, z) + " AND " + uIS;
        String str2 = "";
        if (list != null && list.size() > 0) {
            String str3 = str2;
            for (String str22 : list) {
                str3 = str3 + " AND username != '" + str22 + "'";
            }
            str22 = str3;
        }
        return str + str22;
    }

    public final String e(String str, String str2, List<String> list) {
        String str3;
        String str4;
        boolean z = true;
        String str5 = "";
        if (str == null || str.equals("@all.android")) {
            str3 = str5 + G(true, false);
        } else if (str.equals("@all.contact.android")) {
            str3 = str5 + bLy();
        } else if (str.equals("@all.chatroom.contact")) {
            str3 = str5 + ((" where (" + ("(type & " + com.tencent.mm.j.a.tt() + "!=0 and username like '%@chatroom" + "')") + ") and ") + "type & " + com.tencent.mm.j.a.tx() + "=0 ");
        } else if (str.equals("@all.contact.without.chatroom")) {
            r2 = new StringBuilder().append(str5);
            r3 = G(false, false);
            if (r3 == null || r3.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = r2.append(r3 + " and ( username not like '%@%'" + (" or (" + bLA() + ')') + ")").toString();
        } else if (str.equals("@black.android")) {
            str3 = str5 + (" where type & " + com.tencent.mm.j.a.tu() + "!=0");
        } else if (str.equals("@werun.black.android")) {
            str3 = str5 + (" where type & " + com.tencent.mm.j.a.tv() + "!=0");
        } else if (str.equals("@t.qq.com")) {
            str3 = str5 + (" where username like '%" + "@t.qq.com" + "'");
        } else if (str.equals("@domain.android")) {
            r2 = new StringBuilder().append(str5);
            r3 = G(true, false);
            if (r3 == null || r3.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = r2.append(r3 + " and domainList like '%" + str2 + "%'").toString();
        } else if (str.equals("@micromsg.qq.com")) {
            r2 = new StringBuilder().append(str5);
            r3 = G(false, false);
            if (r3 == null || r3.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str4 = " or (" + bLz() + ')';
            str3 = r2.append(r3 + " and ( username not like '%@%'" + str4 + (" or (" + bLA() + ')') + ")").toString();
        } else if (str.equals("@micromsg.no.verify.biz.qq.com")) {
            r2 = new StringBuilder().append(str5);
            r3 = (((" where (" + ("type & " + com.tencent.mm.j.a.tt() + " !=0 ") + ") and ") + "type & " + com.tencent.mm.j.a.tx() + " =0 and ") + "type & " + com.tencent.mm.j.a.tu() + " =0 and ") + "verifyFlag & " + x.bLg() + " =0";
            if (r3 == null || r3.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = r2.append(r3 + " and ( username not like '%@%'" + (" or (" + bLz() + ')') + ")").toString();
        } else if (str.equals("@micromsg.with.all.biz.qq.com")) {
            r2 = new StringBuilder().append(str5);
            r3 = ((" where (" + ("type & " + com.tencent.mm.j.a.tt() + " !=0 ") + ") and ") + "type & " + com.tencent.mm.j.a.tx() + " =0 and ") + "type & " + com.tencent.mm.j.a.tu() + " =0";
            if (r3 == null || r3.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = r2.append(r3 + " and ( username not like '%@%'" + (" or (" + bLz() + ')') + ")").toString();
        } else if (str.equals("@qqim")) {
            r2 = new StringBuilder().append(str5);
            r3 = "@qqim";
            String G = G(false, false);
            if (G == null || G.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = r2.append(G + " and username like '%" + r3 + "'").toString();
        } else if (str.equals("@all.chatroom")) {
            str3 = str5 + (" where (" + (((("type & " + com.tencent.mm.j.a.tt() + " !=0") + " or type & 2 !=0") + " or type & 4 !=0") + " or 1") + ") ");
        } else if (str.equals("@verify.contact")) {
            str3 = str5 + (" where (" + (("type & " + com.tencent.mm.j.a.tt() + " != 0 and ") + "verifyFlag & " + x.bLf() + " != 0") + ") ");
        } else if (str.equals("@biz.contact")) {
            str3 = str5 + (" where (" + (("type & " + com.tencent.mm.j.a.tt() + " != 0 and ") + "verifyFlag & " + x.bLg() + " != 0") + ") ");
        } else if (str.equals("@all.weixin.android")) {
            str3 = str5 + (" where (" + ("type & " + com.tencent.mm.j.a.tt() + " != 0 or  (username not like '%@qqim" + "' and username not like '%@qr" + "' and username not like '%@bottle" + "' and username not like '%@fb" + "' and username not like '%@google" + "' and username not like '%@t.qq.com" + "' and username not like '%@t.sina.com" + "' and username not like '%@t.sina.com" + "')") + ") ");
        } else {
            w.d("MicroMsg.ContactStorage", "unknow role type");
            str3 = str5 + G(false, false);
        }
        str4 = "";
        if (list != null && list.size() > 0) {
            str5 = str4;
            for (String str42 : list) {
                str5 = str5 + " and username != '" + str42 + "'";
            }
            str42 = str5;
        }
        return str3 + str42;
    }

    public final int b(String[] strArr, String... strArr2) {
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select count(username) from rcontact where ");
        stringBuilder.append("type & ").append(com.tencent.mm.j.a.tt()).append(" !=0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.j.a.tx()).append(" =0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.j.a.tu()).append(" =0 and ");
        stringBuilder.append("verifyFlag & 8").append(" = 0 and ");
        stringBuilder.append("( username not like '%@%')");
        if (strArr != null && strArr.length > 0) {
            for (String append : strArr) {
                stringBuilder.append(" and rcontact.username").append(" != '").append(append).append("'");
            }
        }
        for (i = 0; i < 4; i++) {
            stringBuilder.append(" and rcontact.username").append(" != '").append(strArr2[i]).append("'");
        }
        stringBuilder.append(" or username = 'weixin").append("'");
        Cursor a = this.gUz.a(stringBuilder.toString(), null, 2);
        if (a == null || !a.moveToFirst()) {
            i = 0;
        } else {
            i = a.getInt(0);
            a.close();
        }
        w.d("MicroMsg.ContactStorage", "getNormalContactCount, sql:%s, result:%d", r2, Integer.valueOf(i));
        return i;
    }

    public final int c(String[] strArr, String... strArr2) {
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select count(username) from rcontact where ");
        stringBuilder.append("type & ").append(com.tencent.mm.j.a.tt()).append(" !=0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.j.a.tx()).append(" =0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.j.a.tu()).append(" =0 and ");
        stringBuilder.append("verifyFlag & 8").append(" = 0 and ");
        stringBuilder.append("( username like '%@chatroom')");
        if (strArr != null && strArr.length > 0) {
            for (String append : strArr) {
                stringBuilder.append(" and rcontact.username").append(" != '").append(append).append("'");
            }
        }
        for (i = 0; i < 4; i++) {
            stringBuilder.append(" and rcontact.username").append(" != '").append(strArr2[i]).append("'");
        }
        Cursor a = this.gUz.a(stringBuilder.toString(), null, 2);
        if (a == null || !a.moveToFirst()) {
            i = 0;
        } else {
            i = a.getInt(0);
            a.close();
        }
        w.v("MicroMsg.ContactStorage", "getChatroomContactCount, sql:%s, result:%d", r2, Integer.valueOf(i));
        return i;
    }

    public final Cursor aKg() {
        return this.gUz.rawQuery("select * ,rowid from rcontact  where rowid = -1", null);
    }

    protected final boolean Fc() {
        if (this.gUz != null && !this.gUz.bKn()) {
            return true;
        }
        String str = "MicroMsg.ContactStorage";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.gUz == null ? "null" : Boolean.valueOf(this.gUz.bKn());
        w.w(str, str2, objArr);
        return false;
    }

    private static boolean T(x xVar) {
        boolean z = false;
        if (xVar != null) {
            int i = xVar.versionCode;
            if (i > 0) {
                z = true;
            }
            w.d("MicroMsg.ContactStorage", "it need to update contact: " + z + " version code : " + i + " user: " + xVar.field_username);
        }
        return z;
    }
}
