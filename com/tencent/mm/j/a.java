package com.tencent.mm.j;

import android.database.Cursor;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.a.o;
import com.tencent.mm.e.b.af;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.lang.reflect.Field;

public class a extends af {
    public static com.tencent.mm.sdk.e.c.a gTP;
    private static a gTR = null;
    public long gTQ;
    public int versionCode;

    public interface a {
        String bs(String str);

        String bt(String str);
    }

    static {
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.hXH = new Field[19];
        aVar.columns = new String[20];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "username";
        aVar.uxd.put("username", "TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.uxc = "username";
        aVar.columns[1] = "alias";
        aVar.uxd.put("alias", "TEXT default '' ");
        stringBuilder.append(" alias TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[2] = "conRemark";
        aVar.uxd.put("conRemark", "TEXT default '' ");
        stringBuilder.append(" conRemark TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[3] = "domainList";
        aVar.uxd.put("domainList", "TEXT default '' ");
        stringBuilder.append(" domainList TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[4] = "nickname";
        aVar.uxd.put("nickname", "TEXT default '' ");
        stringBuilder.append(" nickname TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[5] = "pyInitial";
        aVar.uxd.put("pyInitial", "TEXT default '' ");
        stringBuilder.append(" pyInitial TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[6] = "quanPin";
        aVar.uxd.put("quanPin", "TEXT default '' ");
        stringBuilder.append(" quanPin TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[7] = "showHead";
        aVar.uxd.put("showHead", "INTEGER default '0' ");
        stringBuilder.append(" showHead INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[8] = Columns.TYPE;
        aVar.uxd.put(Columns.TYPE, "INTEGER default '0' ");
        stringBuilder.append(" type INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[9] = "weiboFlag";
        aVar.uxd.put("weiboFlag", "INTEGER default '0' ");
        stringBuilder.append(" weiboFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[10] = "weiboNickname";
        aVar.uxd.put("weiboNickname", "TEXT default '' ");
        stringBuilder.append(" weiboNickname TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[11] = "conRemarkPYFull";
        aVar.uxd.put("conRemarkPYFull", "TEXT default '' ");
        stringBuilder.append(" conRemarkPYFull TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[12] = "conRemarkPYShort";
        aVar.uxd.put("conRemarkPYShort", "TEXT default '' ");
        stringBuilder.append(" conRemarkPYShort TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[13] = "lvbuff";
        aVar.uxd.put("lvbuff", "BLOB");
        stringBuilder.append(" lvbuff BLOB");
        stringBuilder.append(", ");
        aVar.columns[14] = "verifyFlag";
        aVar.uxd.put("verifyFlag", "INTEGER default '0' ");
        stringBuilder.append(" verifyFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[15] = "encryptUsername";
        aVar.uxd.put("encryptUsername", "TEXT default '' ");
        stringBuilder.append(" encryptUsername TEXT default '' ");
        stringBuilder.append(", ");
        aVar.columns[16] = "chatroomFlag";
        aVar.uxd.put("chatroomFlag", "INTEGER");
        stringBuilder.append(" chatroomFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "deleteFlag";
        aVar.uxd.put("deleteFlag", "INTEGER default '0' ");
        stringBuilder.append(" deleteFlag INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.columns[18] = "contactLabelIds";
        aVar.uxd.put("contactLabelIds", "TEXT default '' ");
        stringBuilder.append(" contactLabelIds TEXT default '' ");
        aVar.columns[19] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    public final com.tencent.mm.sdk.e.c.a sY() {
        return gTP;
    }

    public a(String str) {
        this();
        if (str == null) {
            str = "";
        }
        setUsername(str);
    }

    public a() {
        this.versionCode = 0;
        super.setUsername("");
        super.bR("");
        super.bS("");
        super.bT("");
        super.bO("");
        super.bP("");
        super.bW("");
        super.bV("");
        super.bQ("");
        super.dd(0);
        super.bU("");
        super.dc(0);
        super.setType(0);
        super.de(0);
        super.df(0);
        super.bY("");
        super.di(0);
        super.ch("");
        super.do(0);
        super.dj(0);
        super.ca("");
        super.cb("");
        super.dk(0);
        super.dl(0);
        super.cc("");
        super.cd("");
        super.dm(1);
        super.dh(0);
        super.dn(0);
        super.ce("");
        super.cf("");
        super.cg("");
        super.setSource(0);
        super.cj("");
        super.ci("");
        super.r(0);
        super.bZ("");
        super.ck("");
        super.dp(0);
        super.cn("");
        super.co("");
        super.cp("");
        super.cs("");
        this.versionCode = 0;
    }

    public static void a(a aVar) {
        gTR = aVar;
    }

    public static String dM(String str) {
        return gTR != null ? gTR.bs(str) : null;
    }

    public final int sZ() {
        int i = 32;
        if (this.field_conRemarkPYShort != null && !this.field_conRemarkPYShort.equals("")) {
            i = this.field_conRemarkPYShort.charAt(0);
        } else if (this.field_conRemarkPYFull != null && !this.field_conRemarkPYFull.equals("")) {
            i = this.field_conRemarkPYFull.charAt(0);
        } else if (super.pB() != null && !super.pB().equals("")) {
            i = super.pB().charAt(0);
        } else if (super.pC() != null && !super.pC().equals("")) {
            i = super.pC().charAt(0);
        } else if (this.field_nickname != null && !this.field_nickname.equals("") && isLetter(this.field_nickname.charAt(0))) {
            i = this.field_nickname.charAt(0);
        } else if (!(this.field_username == null || this.field_username.equals("") || !isLetter(this.field_username.charAt(0)))) {
            i = this.field_username.charAt(0);
        }
        if (i >= 97 && i <= 122) {
            return (char) (i - 32);
        }
        if (i < 65 || i > 90) {
            return 123;
        }
        return i;
    }

    public final void ta() {
        setType(0);
    }

    public final void tb() {
        setType(this.field_type | 4);
    }

    public final void tc() {
        setType(this.field_type | 1);
    }

    public final void td() {
        w.w("MicroMsg.RContact", "unSetContact!! user:%s oldType:%d [%s]", this.field_username, Integer.valueOf(this.field_type), bg.bJZ());
        setType(this.field_type & -2);
    }

    public final void te() {
        setType(this.field_type | 8);
    }

    public final void tf() {
        setType(this.field_type & -9);
    }

    public final void tg() {
        setType(this.field_type | SQLiteGlobal.journalSizeLimit);
    }

    public final void th() {
        setType(this.field_type & -524289);
    }

    public final void ti() {
        setType(this.field_type | 2);
    }

    public final void tj() {
        setType(this.field_type & -3);
    }

    public final void tk() {
        setType(this.field_type & -2049);
    }

    public final void tl() {
        setType(this.field_type | 32);
    }

    public final void tm() {
        setType(this.field_type & -33);
    }

    public final void tn() {
        setType(this.field_type | 64);
    }

    public final void to() {
        setType(this.field_type & -65);
    }

    public final void tp() {
        setType(this.field_type | 512);
    }

    public final void tq() {
        setType(this.field_type & -513);
    }

    public final void tr() {
        setType(this.field_type | 256);
    }

    public final void ts() {
        setType(this.field_type & -257);
    }

    public static int tt() {
        return 1;
    }

    public static int tu() {
        return 8;
    }

    public static int tv() {
        return SQLiteGlobal.journalSizeLimit;
    }

    public static int tw() {
        return 16;
    }

    public static int tx() {
        return 32;
    }

    public final boolean ty() {
        return ez(this.field_type);
    }

    public static boolean ez(int i) {
        if ((i & 1) != 0) {
            return true;
        }
        return false;
    }

    public final boolean isHidden() {
        return (this.field_type & 32) != 0;
    }

    public final boolean tz() {
        return (this.field_type & 4) != 0;
    }

    public final boolean tA() {
        return (this.field_type & 8) != 0;
    }

    public final boolean tB() {
        return (SQLiteGlobal.journalSizeLimit & this.field_type) != 0;
    }

    public final boolean tC() {
        return (this.field_type & 64) != 0;
    }

    public final boolean tD() {
        return (this.field_type & 512) != 0;
    }

    public final boolean tE() {
        return (this.field_type & WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) == 0;
    }

    public final boolean tF() {
        return (this.field_type & 256) != 0;
    }

    public final boolean tG() {
        return (this.field_type & 2048) != 0;
    }

    public final boolean tH() {
        return (WXMediaMessage.THUMB_LENGTH_LIMIT & this.field_type) != 0;
    }

    public final void tI() {
        setType(this.field_type | WXMediaMessage.THUMB_LENGTH_LIMIT);
    }

    private static boolean isLetter(char c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    public final int tJ() {
        return (int) this.gTQ;
    }

    public final String pB() {
        return (super.pB() == null || super.pB().length() < 0) ? pC() : super.pB();
    }

    public final String pC() {
        return (super.pC() == null || super.pC().length() < 0) ? this.field_nickname : super.pC();
    }

    public final String pA() {
        String bt = gTR != null ? gTR.bt(this.field_username) : null;
        return bt == null ? super.pA() : bt;
    }

    public final String tK() {
        String bs = gTR != null ? gTR.bs(this.field_username) : null;
        if (bs != null) {
            return bs;
        }
        if (this.field_nickname == null || this.field_nickname.length() <= 0) {
            return tM();
        }
        return this.field_nickname;
    }

    public final String tL() {
        if (this.field_conRemark == null || this.field_conRemark.trim().equals("")) {
            return tK();
        }
        return this.field_conRemark;
    }

    public final String tM() {
        String pA = pA();
        if (!bg.mA(pA)) {
            return pA;
        }
        pA = dN(this.field_username);
        return (pA == null || pA.length() == 0) ? this.field_username : pA;
    }

    public final int getSource() {
        return super.getSource() % Constants.MAX_BUFFER_SIZE;
    }

    public final int tN() {
        return super.getSource();
    }

    public static String dN(String str) {
        if (str == null) {
            return null;
        }
        if (str.toLowerCase().endsWith("@t.qq.com")) {
            return "@" + str.replace("@t.qq.com", "");
        }
        if (!str.toLowerCase().endsWith("@qqim")) {
            return str;
        }
        str = str.replace("@qqim", "");
        long longValue = Long.valueOf(str).longValue();
        if (longValue < 0) {
            return new o(longValue).toString();
        }
        return str;
    }

    public final void eA(int i) {
        df((this.field_chatroomFlag & -2) | (i & 1));
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        this.gTQ = this.uxb;
        super.u(null);
    }

    private int tO() {
        int i = this.versionCode + 1;
        this.versionCode = i;
        return i;
    }

    public final void setUsername(String str) {
        if (!bg.eB(this.field_username, str)) {
            super.setUsername(str);
            tO();
        }
    }

    public final void bO(String str) {
        if (!bg.eB(pA(), str)) {
            super.bO(str);
            tO();
        }
    }

    public final void bP(String str) {
        if (!bg.eB(this.field_conRemark, str)) {
            super.bP(str);
            tO();
        }
    }

    public final void bQ(String str) {
        if (!bg.eB(this.field_domainList, str)) {
            super.bQ(str);
            tO();
        }
    }

    public final void bR(String str) {
        if (!bg.eB(this.field_nickname, str)) {
            super.bR(str);
            tO();
        }
    }

    public final void bS(String str) {
        if (!bg.eB(pB(), str)) {
            super.bS(str);
            tO();
        }
    }

    public final void bT(String str) {
        if (!bg.eB(pC(), str)) {
            super.bT(str);
            tO();
        }
    }

    public final void dc(int i) {
        if (!bg.dN(this.field_showHead, i)) {
            super.dc(i);
            tO();
        }
    }

    public final void setType(int i) {
        if (!bg.dN(this.field_type, i)) {
            super.setType(i);
            tO();
        }
    }

    public final void dd(int i) {
        if (!bg.dN(this.field_weiboFlag, i)) {
            super.dd(i);
            tO();
        }
    }

    public final void bU(String str) {
        if (!bg.eB(this.field_weiboNickname, str)) {
            super.bU(str);
            tO();
        }
    }

    public final void bV(String str) {
        if (!bg.eB(this.field_conRemarkPYFull, str)) {
            super.bV(str);
            tO();
        }
    }

    public final void bW(String str) {
        if (!bg.eB(this.field_conRemarkPYShort, str)) {
            super.bW(str);
            tO();
        }
    }

    public final void u(byte[] bArr) {
        if (!bg.isEqual(this.field_lvbuff, bArr)) {
            super.u(bArr);
            tO();
        }
    }

    public final void de(int i) {
        if (!bg.dN(this.field_verifyFlag, i)) {
            super.de(i);
            tO();
        }
    }

    public final void bX(String str) {
        if (!bg.eB(this.field_encryptUsername, str)) {
            super.bX(str);
            tO();
        }
    }

    public final void df(int i) {
        if (!bg.dN(this.field_chatroomFlag, i)) {
            super.df(i);
            tO();
        }
    }

    public final void dg(int i) {
        if (!bg.dN(this.field_deleteFlag, i)) {
            super.dg(i);
            tO();
        }
    }

    public final void bY(String str) {
        if (!bg.eB(this.field_contactLabelIds, str)) {
            super.bY(str);
            tO();
        }
    }

    public final void dh(int i) {
        if (!bg.dN(this.gkq, i)) {
            super.dh(i);
            tO();
        }
    }

    public final void di(int i) {
        if (!bg.dN(this.gkr, i)) {
            super.di(i);
            tO();
        }
    }

    public final void bZ(String str) {
        if (!bg.eB(this.gks, str)) {
            super.bZ(str);
            tO();
        }
    }

    public final void r(long j) {
        if (!bg.x(this.gkt, j)) {
            super.r(j);
            tO();
        }
    }

    public final void dj(int i) {
        if (!bg.dN(this.uin, i)) {
            super.dj(i);
            tO();
        }
    }

    public final void ca(String str) {
        if (!bg.eB(this.gku, str)) {
            super.ca(str);
            tO();
        }
    }

    public final void cb(String str) {
        if (!bg.eB(this.fOI, str)) {
            super.cb(str);
            tO();
        }
    }

    public final void dk(int i) {
        if (!bg.dN(this.gkv, i)) {
            super.dk(i);
            tO();
        }
    }

    public final void dl(int i) {
        if (!bg.dN(this.gkw, i)) {
            super.dl(i);
            tO();
        }
    }

    public final void cc(String str) {
        if (!bg.eB(this.gkx, str)) {
            super.cc(str);
            tO();
        }
    }

    public final void cd(String str) {
        if (!bg.eB(this.gky, str)) {
            super.cd(str);
            tO();
        }
    }

    public final void dm(int i) {
        if (!bg.dN(this.gkz, i)) {
            super.dm(i);
            tO();
        }
    }

    public final void dn(int i) {
        if (!bg.dN(this.gkA, i)) {
            super.dn(i);
            tO();
        }
    }

    public final void ce(String str) {
        if (!bg.eB(this.signature, str)) {
            super.ce(str);
            tO();
        }
    }

    public void cf(String str) {
        if (!bg.eB(getProvince(), str)) {
            super.cf(str);
            tO();
        }
    }

    public void cg(String str) {
        if (!bg.eB(getCity(), str)) {
            super.cg(str);
            tO();
        }
    }

    public final void ch(String str) {
        if (!bg.eB(this.gkD, str)) {
            super.ch(str);
            tO();
        }
    }

    public final void do(int i) {
        if (!bg.dN(this.gkE, i)) {
            super.do(i);
            tO();
        }
    }

    public final void setSource(int i) {
        if (!bg.dN(super.getSource(), i)) {
            super.setSource(i);
            tO();
        }
    }

    public final void ci(String str) {
        if (!bg.eB(this.gkF, str)) {
            super.ci(str);
            tO();
        }
    }

    public final void cj(String str) {
        if (!bg.eB(this.gkG, str)) {
            super.cj(str);
            tO();
        }
    }

    public void ck(String str) {
        if (!bg.eB(this.gkH, str)) {
            super.ck(str);
            tO();
        }
    }

    public final void dp(int i) {
        if (!bg.dN(this.gkI, i)) {
            super.dp(i);
            tO();
        }
    }

    public final void dq(int i) {
        if (!bg.dN(this.gkJ, i)) {
            super.dq(i);
            tO();
        }
    }

    public final void cl(String str) {
        if (!bg.eB(this.gkK, str)) {
            super.cl(str);
            tO();
        }
    }

    public final void cm(String str) {
        if (!bg.eB(this.gkL, str)) {
            super.cm(str);
            tO();
        }
    }

    public final void cn(String str) {
        if (!bg.eB(this.gkM, str)) {
            super.cn(str);
            tO();
        }
    }

    public final void co(String str) {
        if (!bg.eB(this.gkN, str)) {
            super.co(str);
            tO();
        }
    }

    public final void cp(String str) {
        if (!bg.eB(this.gkO, str)) {
            super.cp(str);
            tO();
        }
    }

    public final void cq(String str) {
        if (!bg.eB(this.gkP, str)) {
            super.cq(str);
            tO();
        }
    }

    public final void cr(String str) {
        if (!bg.eB(this.gkQ, str)) {
            super.cr(str);
            tO();
        }
    }

    public final void cs(String str) {
        if (!bg.eB(this.gkR, str)) {
            super.cs(str);
            tO();
        }
    }
}
