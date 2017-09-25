package com.tencent.mm.plugin.sns.storage;

import android.database.Cursor;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.e.b.dc;
import com.tencent.mm.modelsns.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.protocal.c.ali;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class m extends dc {
    protected static a gTP;
    protected static Map<String, bfc> qnr = new ConcurrentHashMap();
    protected static Map<String, ali> qns = new ConcurrentHashMap();
    private boolean pQJ = false;
    public String qnj = null;
    public int qnk;
    public String qnt = null;
    public e qnu;
    private ali qnv = null;

    static {
        a aVar = new a();
        aVar.hXH = new Field[15];
        aVar.columns = new String[16];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "snsId";
        aVar.uxd.put("snsId", "LONG");
        stringBuilder.append(" snsId LONG");
        stringBuilder.append(", ");
        aVar.columns[1] = "userName";
        aVar.uxd.put("userName", "TEXT");
        stringBuilder.append(" userName TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "localFlag";
        aVar.uxd.put("localFlag", "INTEGER");
        stringBuilder.append(" localFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[3] = "createTime";
        aVar.uxd.put("createTime", "INTEGER");
        stringBuilder.append(" createTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[4] = "head";
        aVar.uxd.put("head", "INTEGER");
        stringBuilder.append(" head INTEGER");
        stringBuilder.append(", ");
        aVar.columns[5] = "localPrivate";
        aVar.uxd.put("localPrivate", "INTEGER");
        stringBuilder.append(" localPrivate INTEGER");
        stringBuilder.append(", ");
        aVar.columns[6] = Columns.TYPE;
        aVar.uxd.put(Columns.TYPE, "INTEGER");
        stringBuilder.append(" type INTEGER");
        stringBuilder.append(", ");
        aVar.columns[7] = "sourceType";
        aVar.uxd.put("sourceType", "INTEGER");
        stringBuilder.append(" sourceType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[8] = "likeFlag";
        aVar.uxd.put("likeFlag", "INTEGER");
        stringBuilder.append(" likeFlag INTEGER");
        stringBuilder.append(", ");
        aVar.columns[9] = "pravited";
        aVar.uxd.put("pravited", "INTEGER");
        stringBuilder.append(" pravited INTEGER");
        stringBuilder.append(", ");
        aVar.columns[10] = "stringSeq";
        aVar.uxd.put("stringSeq", "TEXT");
        stringBuilder.append(" stringSeq TEXT");
        stringBuilder.append(", ");
        aVar.columns[11] = "content";
        aVar.uxd.put("content", "BLOB");
        stringBuilder.append(" content BLOB");
        stringBuilder.append(", ");
        aVar.columns[12] = "attrBuf";
        aVar.uxd.put("attrBuf", "BLOB");
        stringBuilder.append(" attrBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[13] = "postBuf";
        aVar.uxd.put("postBuf", "BLOB");
        stringBuilder.append(" postBuf BLOB");
        stringBuilder.append(", ");
        aVar.columns[14] = "subType";
        aVar.uxd.put("subType", "INTEGER");
        stringBuilder.append(" subType INTEGER");
        aVar.columns[15] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public final ali bhq() {
        if (this.field_postBuf == null) {
            return new ali();
        }
        if (this.qnt == null) {
            this.qnt = g.n(this.field_postBuf);
        }
        if (qns.containsKey(this.qnt)) {
            this.qnv = (ali) qns.get(this.qnt);
            if (this.qnv != null) {
                return this.qnv;
            }
        }
        try {
            this.qnv = (ali) new ali().aD(this.field_postBuf);
            qns.put(this.qnt, this.qnv);
            return this.qnv;
        } catch (Exception e) {
            w.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
            return new ali();
        }
    }

    public m(byte b) {
        dC(0);
    }

    public static m x(m mVar) {
        m mVar2 = new m();
        mVar2.qnk = mVar.qnk;
        mVar2.field_snsId = mVar.field_snsId;
        mVar2.field_userName = mVar.field_userName;
        mVar2.field_localFlag = mVar.field_localFlag;
        mVar2.field_createTime = mVar.field_createTime;
        mVar2.field_head = mVar.field_head;
        mVar2.field_localPrivate = mVar.field_localPrivate;
        mVar2.field_type = mVar.field_type;
        mVar2.field_sourceType = mVar.field_sourceType;
        mVar2.field_likeFlag = mVar.field_likeFlag;
        mVar2.field_pravited = mVar.field_pravited;
        mVar2.field_stringSeq = mVar.field_stringSeq;
        mVar2.field_content = mVar.field_content;
        mVar2.field_attrBuf = mVar.field_attrBuf;
        return mVar2;
    }

    public final void dC(long j) {
        this.field_snsId = j;
        if (j != 0) {
            dE(j);
        }
    }

    public final String bhe() {
        if (tE(32)) {
            return u.S("ad_table_", this.field_snsId);
        }
        return u.S("sns_table_", this.field_snsId);
    }

    public final String getUserName() {
        return this.field_userName;
    }

    private static int dD(long j) {
        String format = new SimpleDateFormat("yyyyMMdd").format(new Date(1000 * j));
        try {
            return Integer.valueOf(format).intValue();
        } catch (Exception e) {
            w.e("MicroMsg.SnsInfo", "error valueOf  " + format);
            return (int) (j / 86400);
        }
    }

    public final void fN(int i) {
        if (i - this.field_createTime >= 180 || i - this.field_createTime < 0) {
            this.field_createTime = i;
            this.field_head = dD((long) i);
        } else if (this.field_head == 0) {
            this.field_head = dD((long) this.field_createTime);
        }
    }

    public final int bhr() {
        return this.field_createTime;
    }

    public final void bhs() {
        this.field_localPrivate |= 1;
    }

    public final int bht() {
        return this.field_localPrivate;
    }

    public final boolean bhu() {
        return (this.field_localFlag & FileUtils.S_IWUSR) > 0;
    }

    public final void bhv() {
        this.field_localFlag |= 2;
    }

    public final void bhw() {
        this.field_localFlag &= -3;
    }

    public final boolean bhx() {
        return (this.field_localFlag & 2) > 0;
    }

    public final String bhy() {
        if (tE(32)) {
            return u.S("ad_table_", (long) this.qnk);
        }
        return u.S("sns_table_", (long) this.qnk);
    }

    public final void aF(byte[] bArr) {
        this.field_attrBuf = bArr;
        this.qnj = g.n(this.field_content) + g.n(this.field_attrBuf);
    }

    public final void dE(long j) {
        this.field_stringSeq = i.df(j);
        this.field_stringSeq = i.EL(this.field_stringSeq);
        w.d("MicroMsg.SnsInfo", j + " stringSeq " + this.field_stringSeq);
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        this.qnk = (int) this.uxb;
    }

    public static synchronized void release() {
        synchronized (m.class) {
            qnr.clear();
            qns.clear();
        }
    }

    public final bfc bhd() {
        if (this.field_content == null) {
            return e.JH();
        }
        bfc com_tencent_mm_protocal_c_bfc;
        if (this.qnj == null) {
            this.qnj = g.n(this.field_content) + g.n(this.field_attrBuf);
        }
        if (qnr.containsKey(this.qnj)) {
            com_tencent_mm_protocal_c_bfc = (bfc) qnr.get(this.qnj);
            if (com_tencent_mm_protocal_c_bfc != null) {
                return com_tencent_mm_protocal_c_bfc;
            }
        }
        try {
            com_tencent_mm_protocal_c_bfc = (bfc) new bfc().aD(this.field_content);
            qnr.put(this.qnj, com_tencent_mm_protocal_c_bfc);
            return com_tencent_mm_protocal_c_bfc;
        } catch (Exception e) {
            w.e("MicroMsg.SnsInfo", "error get snsinfo timeline!");
            return e.JH();
        }
    }

    public final void b(bfc com_tencent_mm_protocal_c_bfc) {
        try {
            this.field_content = com_tencent_mm_protocal_c_bfc.toByteArray();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SnsInfo", e, "", new Object[0]);
        }
        this.qnj = g.n(this.field_content) + g.n(this.field_attrBuf);
    }

    public final boolean Ge(String str) {
        try {
            this.field_content = e.kL(str).toByteArray();
            this.qnj = g.n(this.field_content) + g.n(this.field_attrBuf);
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.SnsInfo", e, "", new Object[0]);
            return false;
        }
    }

    public final boolean bhz() {
        return (this.field_localFlag & 16) > 0;
    }

    public final boolean bhA() {
        return (this.field_localFlag & 32) > 0 && this.field_snsId == 0;
    }

    public final void bhB() {
        this.field_localFlag &= -33;
    }

    public final void bhC() {
        this.field_localFlag |= 32;
    }

    public static boolean dF(long j) {
        if (bg.az(j / 1000) > 1200) {
            return true;
        }
        return false;
    }

    public final boolean tE(int i) {
        return (this.field_sourceType & i) > 0;
    }

    public final void tC(int i) {
        this.field_sourceType |= i;
    }

    public final void tF(int i) {
        this.field_sourceType &= i ^ -1;
    }

    public final b bha() {
        if (this.qnu == null) {
            this.qnu = ae.beN().dz(this.field_snsId);
        }
        return this.qnu == null ? new b(null) : this.qnu.bha();
    }

    public final a bhc() {
        if (this.qnu == null) {
            this.qnu = ae.beN().dz(this.field_snsId);
        }
        return this.qnu == null ? new a(null) : this.qnu.bhc();
    }

    public final String bhD() {
        a bhc = bhc();
        return bhc == null ? "" : bhc.qdX;
    }

    public final String bhE() {
        a bhc = bhc();
        return bhc == null ? "" : bhc.qdW;
    }

    public final String bhF() {
        b bha = bha();
        if (bha != null) {
            return bha.qdM;
        }
        return "";
    }

    public final String bhG() {
        a bhc = bhc();
        if (bhc != null) {
            return bhc.qdM;
        }
        return "";
    }

    public final String bhH() {
        a bhc = bhc();
        if (bhc != null) {
            return bhc.iHN;
        }
        return "";
    }

    public final String bhI() {
        a bhc = bhc();
        if (bhc != null) {
            return bhc.pZI;
        }
        return "";
    }

    public final e bhJ() {
        if (this.qnu == null) {
            this.qnu = ae.beN().dz(this.field_snsId);
        }
        if (this.qnu != null) {
            this.qnu.field_createTime = this.field_createTime;
            this.qnu.field_userName = this.field_userName;
            this.qnu.field_likeFlag = this.field_likeFlag;
            this.qnu.field_attrBuf = this.field_attrBuf;
        }
        return this.qnu;
    }

    public final boolean bhK() {
        return tE(32);
    }

    public final boolean isValid() {
        return this.field_snsId != 0;
    }

    public final boolean beu() {
        return this.field_snsId == 0;
    }

    public final int bhL() {
        if (!tE(32)) {
            return -1;
        }
        b bha = bha();
        if (bha.bfI()) {
            return 3;
        }
        if (bha.bfJ()) {
            bfc bhd = bhd();
            if (bhd == null || bhd.ufB.tsN != 15 || bhd.ufI == 1) {
                return 4;
            }
            return 5;
        } else if (this.field_type != 1) {
            return 2;
        } else {
            return 1;
        }
    }

    public final boolean bfJ() {
        int bhL = bhL();
        return bhL == 5 || bhL == 4;
    }

    public final Bundle bhg() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("values", super.pv());
        bundle.putInt("localid", this.qnk);
        if (bhJ() != null) {
            bundle.putBundle("adValues", bhJ().bhg());
        }
        return bundle;
    }
}
