package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;

public abstract class af extends c {
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS deleteflag_index ON Contact(deleteFlag)"};
    private static final int gaT = "rowid".hashCode();
    private static final int gca = Columns.TYPE.hashCode();
    private static final int gdt = "username".hashCode();
    private static final int geU = "lvbuff".hashCode();
    private static final int ghU = "nickname".hashCode();
    private static final int gkb = "alias".hashCode();
    private static final int gkc = "conRemark".hashCode();
    private static final int gkd = "domainList".hashCode();
    private static final int gke = "pyInitial".hashCode();
    private static final int gkf = "quanPin".hashCode();
    private static final int gkg = "showHead".hashCode();
    private static final int gkh = "weiboFlag".hashCode();
    private static final int gki = "weiboNickname".hashCode();
    private static final int gkj = "conRemarkPYFull".hashCode();
    private static final int gkk = "conRemarkPYShort".hashCode();
    private static final int gkl = "verifyFlag".hashCode();
    private static final int gkm = "encryptUsername".hashCode();
    private static final int gkn = "chatroomFlag".hashCode();
    private static final int gko = "deleteFlag".hashCode();
    private static final int gkp = "contactLabelIds".hashCode();
    private int cGa;
    public String fOI;
    private String field_alias;
    public int field_chatroomFlag;
    public String field_conRemark;
    public String field_conRemarkPYFull;
    public String field_conRemarkPYShort;
    public String field_contactLabelIds;
    public int field_deleteFlag;
    public String field_domainList;
    public String field_encryptUsername;
    public byte[] field_lvbuff;
    public String field_nickname;
    private String field_pyInitial;
    private String field_quanPin;
    public int field_showHead;
    public int field_type;
    public String field_username;
    public int field_verifyFlag;
    public int field_weiboFlag;
    public String field_weiboNickname;
    private boolean gbE = false;
    private boolean gds = false;
    private boolean gey = false;
    private boolean ghQ = false;
    private boolean gjM = false;
    private boolean gjN = false;
    private boolean gjO = false;
    private boolean gjP = false;
    private boolean gjQ = false;
    private boolean gjR = false;
    private boolean gjS = false;
    private boolean gjT = false;
    private boolean gjU = false;
    private boolean gjV = false;
    private boolean gjW = false;
    private boolean gjX = false;
    private boolean gjY = false;
    private boolean gjZ = false;
    public int gkA;
    private String gkB;
    private String gkC;
    public String gkD;
    public int gkE;
    public String gkF;
    public String gkG;
    public String gkH;
    public int gkI;
    public int gkJ;
    public String gkK;
    public String gkL;
    public String gkM;
    public String gkN;
    public String gkO;
    public String gkP;
    public String gkQ;
    public String gkR;
    private int gkS;
    private boolean gka = false;
    public int gkq;
    public int gkr;
    public String gks;
    public long gkt;
    public String gku;
    public int gkv;
    public int gkw;
    public String gkx;
    public String gky;
    public int gkz;
    public String signature;
    public int uin;

    public void setUsername(String str) {
        this.field_username = str;
        this.gds = true;
    }

    public final String getUsername() {
        return this.field_username;
    }

    public void bO(String str) {
        this.field_alias = str;
        this.gjM = true;
    }

    public String pA() {
        return this.field_alias;
    }

    public void bP(String str) {
        this.field_conRemark = str;
        this.gjN = true;
    }

    public void bQ(String str) {
        this.field_domainList = str;
        this.gjO = true;
    }

    public void bR(String str) {
        this.field_nickname = str;
        this.ghQ = true;
    }

    public void bS(String str) {
        this.field_pyInitial = str;
        this.gjP = true;
    }

    public String pB() {
        return this.field_pyInitial;
    }

    public void bT(String str) {
        this.field_quanPin = str;
        this.gjQ = true;
    }

    public String pC() {
        return this.field_quanPin;
    }

    public void dc(int i) {
        this.field_showHead = i;
        this.gjR = true;
    }

    public void setType(int i) {
        this.field_type = i;
        this.gbE = true;
    }

    public void dd(int i) {
        this.field_weiboFlag = i;
        this.gjS = true;
    }

    public void bU(String str) {
        this.field_weiboNickname = str;
        this.gjT = true;
    }

    public void bV(String str) {
        this.field_conRemarkPYFull = str;
        this.gjU = true;
    }

    public void bW(String str) {
        this.field_conRemarkPYShort = str;
        this.gjV = true;
    }

    public void u(byte[] bArr) {
        this.field_lvbuff = bArr;
        this.gey = true;
    }

    public void de(int i) {
        this.field_verifyFlag = i;
        this.gjW = true;
    }

    public void bX(String str) {
        this.field_encryptUsername = str;
        this.gjX = true;
    }

    public void df(int i) {
        this.field_chatroomFlag = i;
        this.gjY = true;
    }

    public void dg(int i) {
        this.field_deleteFlag = i;
        this.gjZ = true;
    }

    public void bY(String str) {
        this.field_contactLabelIds = str;
        this.gka = true;
    }

    public void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gdt == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.gds = true;
                } else if (gkb == hashCode) {
                    this.field_alias = cursor.getString(i);
                } else if (gkc == hashCode) {
                    this.field_conRemark = cursor.getString(i);
                } else if (gkd == hashCode) {
                    this.field_domainList = cursor.getString(i);
                } else if (ghU == hashCode) {
                    this.field_nickname = cursor.getString(i);
                } else if (gke == hashCode) {
                    this.field_pyInitial = cursor.getString(i);
                } else if (gkf == hashCode) {
                    this.field_quanPin = cursor.getString(i);
                } else if (gkg == hashCode) {
                    this.field_showHead = cursor.getInt(i);
                } else if (gca == hashCode) {
                    this.field_type = cursor.getInt(i);
                } else if (gkh == hashCode) {
                    this.field_weiboFlag = cursor.getInt(i);
                } else if (gki == hashCode) {
                    this.field_weiboNickname = cursor.getString(i);
                } else if (gkj == hashCode) {
                    this.field_conRemarkPYFull = cursor.getString(i);
                } else if (gkk == hashCode) {
                    this.field_conRemarkPYShort = cursor.getString(i);
                } else if (geU == hashCode) {
                    this.field_lvbuff = cursor.getBlob(i);
                } else if (gkl == hashCode) {
                    this.field_verifyFlag = cursor.getInt(i);
                } else if (gkm == hashCode) {
                    this.field_encryptUsername = cursor.getString(i);
                } else if (gkn == hashCode) {
                    this.field_chatroomFlag = cursor.getInt(i);
                } else if (gko == hashCode) {
                    this.field_deleteFlag = cursor.getInt(i);
                } else if (gkp == hashCode) {
                    this.field_contactLabelIds = cursor.getString(i);
                } else if (gaT == hashCode) {
                    this.uxb = cursor.getLong(i);
                }
            }
            pD();
        }
    }

    public final ContentValues pv() {
        try {
            if (this.gey) {
                t tVar = new t();
                tVar.bIH();
                tVar.yt(this.gkq);
                tVar.yt(this.gkr);
                tVar.Pm(this.gks);
                tVar.es(this.gkt);
                tVar.yt(this.uin);
                tVar.Pm(this.gku);
                tVar.Pm(this.fOI);
                tVar.yt(this.gkv);
                tVar.yt(this.gkw);
                tVar.Pm(this.gkx);
                tVar.Pm(this.gky);
                tVar.yt(this.gkz);
                tVar.yt(this.gkA);
                tVar.Pm(this.signature);
                tVar.Pm(this.gkB);
                tVar.Pm(this.gkC);
                tVar.Pm(this.gkD);
                tVar.yt(this.gkE);
                tVar.yt(this.cGa);
                tVar.Pm(this.gkF);
                tVar.yt(this.field_verifyFlag);
                tVar.Pm(this.gkG);
                tVar.Pm(this.gkH);
                tVar.yt(this.gkI);
                tVar.yt(this.gkJ);
                tVar.Pm(this.gkK);
                tVar.Pm(this.gkL);
                tVar.Pm(this.gkM);
                tVar.Pm(this.gkN);
                tVar.Pm(this.gkO);
                tVar.Pm(this.gkP);
                tVar.Pm(this.gkQ);
                tVar.Pm(this.gkR);
                tVar.yt(this.gkS);
                this.field_lvbuff = tVar.bII();
            }
        } catch (Exception e) {
            w.e("MicroMsg.SDK.BaseContact", "get value failed, %s", e.getMessage());
        }
        ContentValues contentValues = new ContentValues();
        if (this.field_username == null) {
            this.field_username = "";
        }
        if (this.gds) {
            contentValues.put("username", this.field_username);
        }
        if (this.field_alias == null) {
            this.field_alias = "";
        }
        if (this.gjM) {
            contentValues.put("alias", this.field_alias);
        }
        if (this.field_conRemark == null) {
            this.field_conRemark = "";
        }
        if (this.gjN) {
            contentValues.put("conRemark", this.field_conRemark);
        }
        if (this.field_domainList == null) {
            this.field_domainList = "";
        }
        if (this.gjO) {
            contentValues.put("domainList", this.field_domainList);
        }
        if (this.field_nickname == null) {
            this.field_nickname = "";
        }
        if (this.ghQ) {
            contentValues.put("nickname", this.field_nickname);
        }
        if (this.field_pyInitial == null) {
            this.field_pyInitial = "";
        }
        if (this.gjP) {
            contentValues.put("pyInitial", this.field_pyInitial);
        }
        if (this.field_quanPin == null) {
            this.field_quanPin = "";
        }
        if (this.gjQ) {
            contentValues.put("quanPin", this.field_quanPin);
        }
        if (this.gjR) {
            contentValues.put("showHead", Integer.valueOf(this.field_showHead));
        }
        if (this.gbE) {
            contentValues.put(Columns.TYPE, Integer.valueOf(this.field_type));
        }
        if (this.gjS) {
            contentValues.put("weiboFlag", Integer.valueOf(this.field_weiboFlag));
        }
        if (this.field_weiboNickname == null) {
            this.field_weiboNickname = "";
        }
        if (this.gjT) {
            contentValues.put("weiboNickname", this.field_weiboNickname);
        }
        if (this.field_conRemarkPYFull == null) {
            this.field_conRemarkPYFull = "";
        }
        if (this.gjU) {
            contentValues.put("conRemarkPYFull", this.field_conRemarkPYFull);
        }
        if (this.field_conRemarkPYShort == null) {
            this.field_conRemarkPYShort = "";
        }
        if (this.gjV) {
            contentValues.put("conRemarkPYShort", this.field_conRemarkPYShort);
        }
        if (this.gey) {
            contentValues.put("lvbuff", this.field_lvbuff);
        }
        if (this.gjW) {
            contentValues.put("verifyFlag", Integer.valueOf(this.field_verifyFlag));
        }
        if (this.field_encryptUsername == null) {
            this.field_encryptUsername = "";
        }
        if (this.gjX) {
            contentValues.put("encryptUsername", this.field_encryptUsername);
        }
        if (this.gjY) {
            contentValues.put("chatroomFlag", Integer.valueOf(this.field_chatroomFlag));
        }
        if (this.gjZ) {
            contentValues.put("deleteFlag", Integer.valueOf(this.field_deleteFlag));
        }
        if (this.field_contactLabelIds == null) {
            this.field_contactLabelIds = "";
        }
        if (this.gka) {
            contentValues.put("contactLabelIds", this.field_contactLabelIds);
        }
        if (this.uxb > 0) {
            contentValues.put("rowid", Long.valueOf(this.uxb));
        }
        return contentValues;
    }

    public void dh(int i) {
        this.gkq = i;
        this.gey = true;
    }

    public void di(int i) {
        this.gkr = i;
        this.gey = true;
    }

    public void bZ(String str) {
        this.gks = str;
        this.gey = true;
    }

    public void r(long j) {
        this.gkt = j;
        this.gey = true;
    }

    public void dj(int i) {
        this.uin = i;
        this.gey = true;
    }

    public void ca(String str) {
        this.gku = str;
        this.gey = true;
    }

    public void cb(String str) {
        this.fOI = str;
        this.gey = true;
    }

    public void dk(int i) {
        this.gkv = i;
        this.gey = true;
    }

    public void dl(int i) {
        this.gkw = i;
        this.gey = true;
    }

    public void cc(String str) {
        this.gkx = str;
        this.gey = true;
    }

    public void cd(String str) {
        this.gky = str;
        this.gey = true;
    }

    public void dm(int i) {
        this.gkz = i;
        this.gey = true;
    }

    public void dn(int i) {
        this.gkA = i;
        this.gey = true;
    }

    public void ce(String str) {
        this.signature = str;
        this.gey = true;
    }

    public String getProvince() {
        return this.gkB;
    }

    public void cf(String str) {
        this.gkB = str;
        this.gey = true;
    }

    public String getCity() {
        return this.gkC;
    }

    public void cg(String str) {
        this.gkC = str;
        this.gey = true;
    }

    public void ch(String str) {
        this.gkD = str;
        this.gey = true;
    }

    public void do(int i) {
        this.gkE = i;
        this.gey = true;
    }

    public int getSource() {
        return this.cGa;
    }

    public void setSource(int i) {
        this.cGa = i;
        this.gey = true;
    }

    public void ci(String str) {
        this.gkF = str;
        this.gey = true;
    }

    public void cj(String str) {
        this.gkG = str;
        this.gey = true;
    }

    public void ck(String str) {
        this.gkH = str;
        this.gey = true;
    }

    public void dp(int i) {
        this.gkI = i;
        this.gey = true;
    }

    public void dq(int i) {
        this.gkJ = i;
        this.gey = true;
    }

    public void cl(String str) {
        this.gkK = str;
        this.gey = true;
    }

    public void cm(String str) {
        this.gkL = str;
        this.gey = true;
    }

    public void cn(String str) {
        this.gkM = str;
        this.gey = true;
    }

    public void co(String str) {
        this.gkN = str;
        this.gey = true;
    }

    public void cp(String str) {
        this.gkO = str;
        this.gey = true;
    }

    public void cq(String str) {
        this.gkP = str;
        this.gey = true;
    }

    public void cr(String str) {
        this.gkQ = str;
        this.gey = true;
    }

    public void cs(String str) {
        this.gkR = str;
        this.gey = true;
    }

    public final void dr(int i) {
        this.gkS = i;
        this.gey = true;
    }

    public final void pD() {
        try {
            if (this.field_lvbuff != null && this.field_lvbuff.length != 0) {
                t tVar = new t();
                int bh = tVar.bh(this.field_lvbuff);
                if (bh != 0) {
                    w.e("MicroMsg.SDK.BaseContact", "parse LVBuffer error:" + bh);
                    return;
                }
                this.gkq = tVar.getInt();
                this.gkr = tVar.getInt();
                this.gks = tVar.getString();
                this.gkt = tVar.getLong();
                this.uin = tVar.getInt();
                this.gku = tVar.getString();
                this.fOI = tVar.getString();
                this.gkv = tVar.getInt();
                this.gkw = tVar.getInt();
                this.gkx = tVar.getString();
                this.gky = tVar.getString();
                this.gkz = tVar.getInt();
                this.gkA = tVar.getInt();
                this.signature = tVar.getString();
                this.gkB = tVar.getString();
                this.gkC = tVar.getString();
                this.gkD = tVar.getString();
                this.gkE = tVar.getInt();
                this.cGa = tVar.getInt();
                this.gkF = tVar.getString();
                this.field_verifyFlag = tVar.getInt();
                this.gkG = tVar.getString();
                if (!tVar.bIG()) {
                    this.gkH = tVar.getString();
                }
                if (!tVar.bIG()) {
                    this.gkI = tVar.getInt();
                }
                if (!tVar.bIG()) {
                    this.gkJ = tVar.getInt();
                }
                if (!tVar.bIG()) {
                    this.gkK = tVar.getString();
                }
                if (!tVar.bIG()) {
                    this.gkL = tVar.getString();
                }
                if (!tVar.bIG()) {
                    this.gkM = tVar.getString();
                }
                if (!tVar.bIG()) {
                    this.gkN = tVar.getString();
                }
                if (!tVar.bIG()) {
                    this.gkO = tVar.getString();
                }
                if (!tVar.bIG()) {
                    this.gkP = tVar.getString();
                }
                if (!tVar.bIG()) {
                    this.gkQ = tVar.getString();
                }
                if (!tVar.bIG()) {
                    this.gkR = tVar.getString();
                }
                if (!tVar.bIG()) {
                    this.gkS = tVar.getInt();
                }
            }
        } catch (Exception e) {
            w.e("MicroMsg.SDK.BaseContact", "get value failed");
        }
    }
}
