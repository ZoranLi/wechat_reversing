package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class e extends com.tencent.mm.e.b.e {
    protected static a gTP;
    protected static Map<String, b> qnl = new ConcurrentHashMap();
    protected static Map<String, a> qnm = new ConcurrentHashMap();
    public String qnj = null;
    protected int qnk;

    static {
        a aVar = new a();
        aVar.hXH = new Field[22];
        aVar.columns = new String[23];
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
        aVar.columns[14] = "adinfo";
        aVar.uxd.put("adinfo", "TEXT");
        stringBuilder.append(" adinfo TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "adxml";
        aVar.uxd.put("adxml", "TEXT");
        stringBuilder.append(" adxml TEXT");
        stringBuilder.append(", ");
        aVar.columns[16] = "createAdTime";
        aVar.uxd.put("createAdTime", "INTEGER");
        stringBuilder.append(" createAdTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[17] = "exposureTime";
        aVar.uxd.put("exposureTime", "INTEGER");
        stringBuilder.append(" exposureTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[18] = "firstControlTime";
        aVar.uxd.put("firstControlTime", "INTEGER");
        stringBuilder.append(" firstControlTime INTEGER");
        stringBuilder.append(", ");
        aVar.columns[19] = "recxml";
        aVar.uxd.put("recxml", "TEXT");
        stringBuilder.append(" recxml TEXT");
        stringBuilder.append(", ");
        aVar.columns[20] = "subType";
        aVar.uxd.put("subType", "INTEGER");
        stringBuilder.append(" subType INTEGER");
        stringBuilder.append(", ");
        aVar.columns[21] = "exposureCount";
        aVar.uxd.put("exposureCount", "INTEGER");
        stringBuilder.append(" exposureCount INTEGER");
        aVar.columns[22] = "rowid";
        aVar.uxe = stringBuilder.toString();
        gTP = aVar;
    }

    protected final a sY() {
        return gTP;
    }

    public final b bha() {
        b bVar;
        if (this.field_adxml == null) {
            bVar = null;
        } else if (qnl.containsKey(this.field_adxml)) {
            return (b) qnl.get(this.field_adxml);
        } else {
            bVar = new b(this.field_adxml);
            qnl.put(this.field_adxml, bVar);
        }
        return bVar == null ? new b(null) : bVar;
    }

    public final b bhb() {
        b bVar;
        if (this.field_recxml == null) {
            bVar = null;
        } else if (qnl.containsKey(this.field_recxml)) {
            return (b) qnl.get(this.field_recxml);
        } else {
            bVar = new b(this.field_recxml);
            qnl.put(this.field_recxml, bVar);
        }
        return bVar == null ? new b(null) : bVar;
    }

    public final a bhc() {
        a aVar;
        if (this.field_adinfo == null) {
            aVar = null;
        } else if (qnm.containsKey(this.field_adinfo)) {
            return (a) qnm.get(this.field_adinfo);
        } else {
            aVar = new a(this.field_adinfo);
            qnm.put(this.field_adinfo, aVar);
        }
        return aVar == null ? new a(null) : aVar;
    }

    public final int getSource() {
        b bhb = bhb();
        return bhb == null ? 0 : bhb.qes;
    }

    public final void b(bfc com_tencent_mm_protocal_c_bfc) {
        try {
            this.field_content = com_tencent_mm_protocal_c_bfc.toByteArray();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.AdSnsInfo", e, "", new Object[0]);
        }
    }

    public final boolean Ge(String str) {
        try {
            this.field_content = com.tencent.mm.modelsns.e.kL(str).toByteArray();
            this.qnj = g.n(this.field_content) + g.n(this.field_attrBuf);
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.AdSnsInfo", e, "", new Object[0]);
            return false;
        }
    }

    public final bfc bhd() {
        if (this.field_content == null) {
            return com.tencent.mm.modelsns.e.JH();
        }
        bfc com_tencent_mm_protocal_c_bfc;
        if (this.qnj == null) {
            this.qnj = g.n(this.field_content) + g.n(this.field_attrBuf);
        }
        if (m.qnr.containsKey(this.qnj)) {
            com_tencent_mm_protocal_c_bfc = (bfc) m.qnr.get(this.qnj);
            if (com_tencent_mm_protocal_c_bfc != null) {
                return com_tencent_mm_protocal_c_bfc;
            }
        }
        try {
            com_tencent_mm_protocal_c_bfc = (bfc) new bfc().aD(this.field_content);
            m.qnr.put(this.qnj, com_tencent_mm_protocal_c_bfc);
            return com_tencent_mm_protocal_c_bfc;
        } catch (Exception e) {
            w.e("MicroMsg.AdSnsInfo", "error get snsinfo timeline!");
            return com.tencent.mm.modelsns.e.JH();
        }
    }

    public final void aF(byte[] bArr) {
        this.field_attrBuf = bArr;
        this.qnj = g.n(this.field_content) + g.n(this.field_attrBuf);
    }

    public final void tC(int i) {
        this.field_sourceType |= i;
    }

    public final String bhe() {
        return u.S("ad_table_", this.field_snsId);
    }

    public final m bhf() {
        m mVar = new m();
        mVar.b(bhd());
        w.d("MicroMsg.AdSnsInfo", "from server xml ok %d", new Object[]{Long.valueOf(this.field_snsId)});
        mVar.qnk = this.qnk;
        mVar.field_userName = this.field_userName;
        mVar.fN(this.field_createTime);
        mVar.field_likeFlag = this.field_likeFlag;
        mVar.dC(this.field_snsId);
        mVar.field_sourceType = this.field_sourceType;
        mVar.field_content = this.field_content;
        mVar.tC(2);
        mVar.tC(32);
        mVar.field_attrBuf = this.field_attrBuf;
        bfc bhd = mVar.bhd();
        bhd.jNj = this.field_userName;
        mVar.field_pravited = bhd.tPk;
        mVar.bhv();
        mVar.b(bhd);
        mVar.field_type = bhd.ufB.tsN;
        mVar.field_subType = bhd.ufB.tsP;
        mVar.qnu = this;
        return mVar;
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
        this.qnk = (int) this.uxb;
    }

    public final Bundle bhg() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("values", super.pv());
        bundle.putInt("localid", this.qnk);
        return bundle;
    }

    public final void B(Bundle bundle) {
        if (bundle != null) {
            ContentValues contentValues = (ContentValues) bundle.getParcelable("values");
            this.field_snsId = contentValues.getAsLong("snsId").longValue();
            this.field_userName = contentValues.getAsString("userName");
            this.field_localFlag = contentValues.getAsInteger("localFlag").intValue();
            this.field_createTime = contentValues.getAsInteger("createTime").intValue();
            this.field_head = contentValues.getAsInteger("head").intValue();
            this.field_localPrivate = contentValues.getAsInteger("localPrivate").intValue();
            this.field_type = contentValues.getAsInteger(Columns.TYPE).intValue();
            this.field_sourceType = contentValues.getAsInteger("sourceType").intValue();
            this.field_likeFlag = contentValues.getAsInteger("likeFlag").intValue();
            this.field_pravited = contentValues.getAsInteger("pravited").intValue();
            this.field_stringSeq = contentValues.getAsString("stringSeq");
            this.field_content = contentValues.getAsByteArray("content");
            this.field_attrBuf = contentValues.getAsByteArray("attrBuf");
            this.field_postBuf = contentValues.getAsByteArray("postBuf");
            this.field_adinfo = contentValues.getAsString("adinfo");
            this.field_adxml = contentValues.getAsString("adxml");
            this.field_createAdTime = contentValues.getAsInteger("createAdTime").intValue();
            this.field_exposureTime = contentValues.getAsInteger("exposureTime").intValue();
            this.field_firstControlTime = contentValues.getAsInteger("firstControlTime").intValue();
            this.field_recxml = contentValues.getAsString("recxml");
            this.field_subType = contentValues.getAsInteger("subType").intValue();
            this.uxb = contentValues.getAsLong("rowid").longValue();
            this.qnk = bundle.getInt("localid");
        }
    }
}
