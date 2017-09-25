package com.tencent.mm.plugin.sns.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bj.g;
import com.tencent.mm.e.a.oz;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class n extends i<m> implements f {
    public static final String[] gUx = new String[]{i.a(m.gTP, "SnsInfo")};
    public static final String[] gaK = new String[]{"CREATE INDEX IF NOT EXISTS serverSnsNameIndex ON SnsInfo ( snsId )", "CREATE INDEX IF NOT EXISTS serverSnsTimeHeadIndex ON SnsInfo ( head )", "DROP INDEX IF EXISTS serverSnsTimeIndex", "DROP INDEX IF EXISTS serverSnsTimeSourceTypeIndex", "CREATE INDEX IF NOT EXISTS snsMultiIndex1 ON SnsInfo ( createTime,snsId,sourceType,type)", "CREATE INDEX IF NOT EXISTS snsMultiIndex2 ON SnsInfo ( sourceType,type,userName)", "CREATE INDEX IF NOT EXISTS snsLocalflagIndex ON SnsInfo ( localFlag )"};
    public static String qnA = " order by SnsInfo.createTime desc ,snsId desc";
    public static String qnB = " order by SnsInfo.createTime asc ,snsId asc";
    private static String qnC = " order by SnsInfo.createTime asc ,snsId asc";
    private static String qnD = " order by SnsInfo.head desc ,SnsInfo.createTime desc ";
    private static String qnE = " order by SnsInfo.head desc ,snsId desc";
    public static String qnF;
    public static String qnG;
    protected static String qnH;
    protected static String qnI = " (sourceType & 2 != 0 ) and type < 21";
    private static String qnJ;
    private static String qnK;
    private static String qnL;
    private static ArrayList<Integer> qnM = bu(Arrays.asList(new Integer[]{Integer.valueOf(16), Integer.valueOf(32), Integer.valueOf(2), Integer.valueOf(8), Integer.valueOf(64), Integer.valueOf(FileUtils.S_IWUSR)}));
    private static ArrayList<Integer> qnN = bu(Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(4), Integer.valueOf(8)}));
    private static String[] qny = new String[]{"snsId", "userName", "localFlag", "createTime", "head", "localPrivate", Columns.TYPE, "sourceType", "likeFlag", "pravited", "stringSeq", "content", "attrBuf", "postBuf", "rowid"};
    public static String qnz;
    public e gUz;
    private boolean qnw;
    private int qnx;

    public final /* synthetic */ boolean a(long j, c cVar) {
        return b(j, (m) cVar);
    }

    public final /* synthetic */ boolean a(c cVar) {
        return z((m) cVar);
    }

    static {
        int i;
        qnz = "";
        qnF = null;
        qnG = null;
        qnH = " (sourceType & 2 != 0 ) ";
        qnJ = null;
        qnK = null;
        qnL = null;
        qnz = "select ";
        for (i = 0; i < qny.length; i++) {
            if (i < qny.length - 1) {
                qnz += " " + qny[i] + ",";
            } else {
                qnz += " " + qny[i] + " ";
            }
        }
        w.i("MicroMsg.SnsInfoStorage", "TIMELINE_SELECT_BEGIN " + qnz);
        List arrayList = new ArrayList();
        Iterator it = qnM.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 16) != 0 && (i & 32) == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        qnF = g(arrayList, "localFlag");
        w.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", new Object[]{qnF});
        arrayList.clear();
        it = qnM.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 32) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        qnG = g(arrayList, "localFlag");
        w.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", new Object[]{qnG});
        arrayList.clear();
        it = qnM.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 64) == 0 && (i & 32) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        qnL = g(arrayList, "localFlag");
        arrayList.clear();
        it = qnN.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 8) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        qnK = g(arrayList, "sourceType");
        w.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", new Object[]{qnK});
        arrayList.clear();
        it = qnN.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 2) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        qnH = g(arrayList, "sourceType");
        w.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", new Object[]{qnH});
        arrayList.clear();
        it = qnN.iterator();
        while (it.hasNext()) {
            i = ((Integer) it.next()).intValue();
            if ((i & 4) != 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        qnJ = g(arrayList, "sourceType");
        w.i("MicroMsg.SnsInfoStorage", "auto optimalize sql %s", new Object[]{qnJ});
    }

    private static boolean bhM() {
        b ozVar = new oz();
        a.urY.m(ozVar);
        return ozVar.fVW.fVX;
    }

    public static String bhN() {
        if (bhM()) {
            return " (sourceType & 2 != 0 ) and type < 21";
        }
        return " (sourceType & 2 != 0 ) ";
    }

    private static String g(List<Integer> list, String str) {
        StringBuilder stringBuilder = new StringBuilder("(");
        stringBuilder.append(str + " in (");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            stringBuilder.append(it.next());
            if (it.hasNext()) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append(")");
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    private static ArrayList<Integer> bu(List<Integer> list) {
        ArrayList arrayList = new ArrayList(list);
        Collection hashSet = new HashSet();
        ArrayList<Integer> arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            Collection arrayList3 = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList3.add(Integer.valueOf(((Integer) it2.next()).intValue() | num.intValue()));
            }
            hashSet.addAll(new HashSet(arrayList3));
            hashSet.add(num);
        }
        hashSet.add(Integer.valueOf(0));
        arrayList2.addAll(hashSet);
        return arrayList2;
    }

    public n(e eVar) {
        boolean z;
        boolean z2 = true;
        super(eVar, m.gTP, "SnsInfo", gaK);
        this.gUz = eVar;
        Cursor a = this.gUz.a("select count(*) from SnsInfo where snsId > 0;", null, 2);
        if (!a.moveToFirst() || a.getInt(0) <= 0) {
            a.close();
            z = false;
        } else {
            w.i("MicroMsg.SnsInfoStorage", "exsits snsId > 0  ,count is %d", new Object[]{Integer.valueOf(a.getInt(0))});
            a.close();
            z = true;
        }
        if (z) {
            z2 = false;
        }
        this.qnw = z2;
        this.qnx = 0;
        if (this.qnw) {
            w.i("MicroMsg.SnsInfoStorage", "all sndId < 0 ,so optimalizeForSnsId");
            return;
        }
        qnA = " order by SnsInfo.createTime desc ,case when snsId < 0 then 0 else 1 end ,  snsId desc";
        qnB = " order by SnsInfo.createTime asc ,case when snsId < 0 then 0 else 1 end ,  snsId asc";
        qnD = " order by SnsInfo.head desc ,SnsInfo.createTime desc ";
        qnE = " order by SnsInfo.head desc ,case when snsId < 0 then 0 else 1 end ,  snsId desc";
    }

    public final int y(m mVar) {
        w.d("MicroMsg.SnsInfoStorage", "SnsInfo Insert");
        if (mVar == null) {
            return -1;
        }
        int insert = (int) this.gUz.insert("SnsInfo", "", mVar.pv());
        w.d("MicroMsg.SnsInfoStorage", "SnsInfo Insert result " + insert);
        return insert;
    }

    public final void a(String str, boolean z, String str2) {
        String str3 = aq(str, z) + " AND  (snsId != 0  ) ";
        if (Go(str2)) {
            str3 = str3 + " AND " + Gs(str2);
        }
        g(z, str3);
    }

    public final void g(boolean z, String str) {
        String str2 = "UPDATE SnsInfo SET sourceType = sourceType & " + ((z ? 4 : 8) ^ -1) + str;
        w.d("MicroMsg.SnsInfoStorage", "updateFilterUserName sql " + str2);
        this.gUz.eE("SnsInfo", str2);
    }

    public final void bhO() {
        Gn(" where " + bhN() + " AND  (snsId != 0  ) ");
    }

    public final void Gl(String str) {
        if (Go(str)) {
            Gn(" where " + Gs(str) + " and " + bhN() + " and  (snsId != 0  ) ");
        }
    }

    public final void Gm(String str) {
        if (Go(str)) {
            Gn(" where " + Gr(str) + " and " + bhN() + " and  (snsId != 0  ) ");
        }
    }

    private void Gn(String str) {
        String str2 = "UPDATE SnsInfo SET sourceType = sourceType & -3" + str;
        w.d("MicroMsg.SnsInfoStorage", "updateFilterTimeLine sql " + str2);
        this.gUz.eE("SnsInfo", str2);
    }

    public final boolean dA(long j) {
        Cursor rawQuery = this.gUz.rawQuery("select *,rowid from SnsInfo  where SnsInfo.snsId=" + j, null);
        int count = rawQuery.getCount();
        rawQuery.close();
        return count > 0;
    }

    public final boolean a(long j, m mVar) {
        if (dA(j)) {
            return b(j, mVar);
        }
        return y(mVar) != -1;
    }

    public static boolean Go(String str) {
        if (str == null || str.equals("")) {
            return false;
        }
        return true;
    }

    public final String Gp(String str) {
        if (str == null || str.equals("")) {
            return " ";
        }
        if (this.qnw) {
            return " (snsId >= " + Gq(bg.my(str)) + " ) ";
        }
        return " (stringSeq >=\"" + bg.my(str) + "\"  ) ";
    }

    private static long Gq(String str) {
        w.i("MicroMsg.SnsInfoStorage", "seq %s to snsId %d ", new Object[]{str, Long.valueOf(new BigInteger(str).longValue())});
        return new BigInteger(str).longValue();
    }

    public final String Gr(String str) {
        if (str == null || str.equals("")) {
            return " ";
        }
        if (this.qnw) {
            return " (snsId > " + Gq(bg.my(str)) + " ) ";
        }
        return " (stringSeq >\"" + bg.my(str) + "\"  ) ";
    }

    public final String Gs(String str) {
        if (str == null || str.equals("")) {
            return " ";
        }
        if (this.qnw) {
            return " (snsId < " + Gq(bg.my(str)) + " ) ";
        }
        return " (stringSeq <\"" + bg.my(str) + "\"  ) ";
    }

    public static String aq(String str, boolean z) {
        String str2 = "";
        if (z) {
            return str2 + " WHERE " + qnJ;
        }
        return (str2 + " WHERE SnsInfo.userName=\"" + bg.my(str) + "\"") + " AND " + qnK;
    }

    public static String c(boolean z, String str, boolean z2) {
        return ("select *,rowid from SnsInfo " + aq(str, z2)) + " AND type in ( 1,2 , 3 , 4 , 18 , 5 , 12 , 9 , 14 , 15 , 13 , 21 , 25)";
    }

    public final long f(long j, int i, boolean z) {
        return c(bhQ(), j, i, z);
    }

    public final long a(long j, int i, String str, boolean z) {
        return c(c(false, str, z), j, i, false);
    }

    private long c(String str, long j, int i, boolean z) {
        String str2;
        if (j != 0) {
            str2 = str + " AND SnsInfo.stringSeq < '" + com.tencent.mm.plugin.sns.data.i.EL(com.tencent.mm.plugin.sns.data.i.df(j)) + "'";
        } else {
            str2 = str;
        }
        if (z) {
            str2 = str2 + " AND  (snsId != 0 ) ";
        }
        Cursor rawQuery = this.gUz.rawQuery((str2 + qnA) + " limit " + i, null);
        if (rawQuery.moveToLast()) {
            m mVar = new m();
            mVar.b(rawQuery);
            rawQuery.close();
            return mVar.field_snsId;
        }
        rawQuery.close();
        return 0;
    }

    public static String bhP() {
        return "select *,rowid from SnsInfo  where " + " (sourceType & 2 != 0 ) ";
    }

    public static String bhQ() {
        return "select *,rowid from SnsInfo  where " + bhN();
    }

    public static String bhR() {
        return "select *,rowid from SnsInfo  where " + (bhM() ? qnI : qnH);
    }

    public static String tG(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select snsId from SnsInfo  where ").append(bhN()).append(" limit 3");
        return stringBuilder.toString();
    }

    public final Cursor a(boolean z, String str, int i, boolean z2, String str2) {
        String c = c(z, str, z2);
        if (Go(str2)) {
            c = c + " AND " + Gp(str2);
        }
        if (z2) {
            c = c + qnD;
        } else {
            c = c + qnE;
        }
        if (i > 0) {
            c = c + " LIMIT " + i;
        }
        w.d("MicroMsg.SnsInfoStorage", "getCursorByUserName in gallery " + c);
        return this.gUz.rawQuery(c, null);
    }

    public final Cursor Ez(String str) {
        String bhQ = bhQ();
        if (Go(str)) {
            bhQ = bhQ + " AND " + Gp(str);
        }
        bhQ = bhQ + qnA;
        w.d("MicroMsg.SnsInfoStorage", "getCursorForTimeLine " + bhQ);
        return this.gUz.rawQuery(bhQ, null);
    }

    public final List<m> ar(String str, boolean z) {
        Cursor a = this.gUz.a("select *,rowid from SnsInfo " + aq(str, z) + " AND type = 4", null, 2);
        List<m> arrayList = new ArrayList();
        while (a.moveToNext()) {
            m mVar = new m();
            mVar.b(a);
            arrayList.add(mVar);
        }
        a.close();
        return arrayList;
    }

    public final int Gt(String str) {
        String bhQ = bhQ();
        if (Go(str)) {
            bhQ = bhQ + " AND " + Gp(str);
        }
        String str2 = (bhQ + " AND  (snsId != 0 ) ") + qnB + " limit 1";
        Cursor a = this.gUz.a(str2, null, 2);
        int i = 0;
        if (a.moveToFirst()) {
            m mVar = new m();
            mVar.b(a);
            i = mVar.field_createTime;
        }
        a.close();
        w.i("MicroMsg.SnsInfoStorage", "getLastTime " + str2 + " createtime " + i);
        return i;
    }

    public final Cursor bM(String str, int i) {
        String str2 = (qnz + " from SnsInfo where ") + bhN();
        if (Go(str)) {
            str2 = str2 + " AND " + Gp(str);
        }
        str2 = (((str2 + " AND createTime >= " + i) + " UNION ") + qnz + " from AdSnsInfo where createTime" + " > " + i) + qnA;
        w.d("MicroMsg.SnsInfoStorage", "getAdCursorForTimeLine " + str2 + " limtiSeq: " + str);
        return this.gUz.rawQuery(str2, null);
    }

    public final void dc(long j) {
        int i;
        ab.getContext().getSharedPreferences(ab.bIX(), 0).edit().putLong("check_trim_time", 0).commit();
        g wO = ae.wO();
        long cs = wO.cs(Thread.currentThread().getId());
        for (i = 0; ((long) i) < j; i++) {
            wO.eE("SnsInfo", "INSERT INTO SnsInfo VALUES(-69999999991777434909,'miaochanchan',2,1402026897,20140606,0,2,2,0,0,'0',X'0A143131373631303534303431393332313136373037120C6D69616F6368616E6368616E18002091F7C49C052A36E8A681E6849FE8B0A2E8BF99E4BBBDE5B7A5EFBC8CE8AEA9E68891E4B88DE4BC9AE69C89E5A29EE882A5E79A84E8BFB9E8B1A1E3808232180D0000000015000000001A0022002A0032003800480050003A0A0A0012001A0022002A0042080A0010021A0022004A0052005A006000680272007A2408001200180022002A0032003A080A0012001A00220042004A040800100052040A001200',X'08E3E5A48CEA8AEA9BA301120C6D69616F6368616E6368616E1A09E88B97E7B1B3E7B1B32091F7C49C052A04080012003000380040005000580068007000800101880100900100A00101B00100B80100',NULL);");
        }
        for (i = 0; ((long) i) < 20000; i++) {
            wO.eE("snsExtInfo3", String.format("INSERT INTO snsExtInfo3 VALUES('zeustest%d','afd',2,1402026897,'d', 0,1, 1, 1, 1, 'a', 'a', NULL);", new Object[]{Integer.valueOf(i)}));
        }
        for (i = 0; ((long) i) < 20000; i++) {
            wO.eE("snsComment", String.format("INSERT INTO snsComment VALUES(-69999999991777434909,0,2,1402026897,'d', 2,1, 'a', 'b', 1, NULL);", new Object[0]));
        }
        wO.aD(cs);
    }

    public final ArrayList<Long> bdx() {
        ArrayList<Long> arrayList = new ArrayList();
        Cursor a = this.gUz.a("SnsInfo", new String[]{"*", "rowid"}, "createTime >=? AND " + qnL, new String[]{String.valueOf(((int) (System.currentTimeMillis() / 1000)) - 172800)}, null, null, "createTime ASC", 2);
        while (a.moveToNext()) {
            try {
                m mVar = new m();
                mVar.b(a);
                if (mVar.qnk != -1 && mVar.field_userName.equals(m.xL())) {
                    arrayList.add(Long.valueOf((long) mVar.qnk));
                    w.d("MicroMsg.SnsInfoStorage", "getAllNeedResendSns, add snsInfo: " + mVar.bhy());
                }
            } finally {
                a.close();
            }
        }
        w.d("MicroMsg.SnsInfoStorage", "getAllNeedResendSns, resendList.size:%d", new Object[]{Integer.valueOf(arrayList.size())});
        return arrayList;
    }

    public final boolean sN(int i) {
        return tH(i) != null;
    }

    public final boolean z(m mVar) {
        if (mVar.tE(32)) {
            return ae.beN().a(mVar.bhJ());
        }
        boolean z = this.gUz.replace("SnsInfo", "", mVar.pv()) > 0;
        w.d("MicroMsg.SnsInfoStorage", "SnsInfo replace result " + z);
        return z;
    }

    public final m dG(long j) {
        m mVar = new m();
        Cursor a = this.gUz.a("select *,rowid from SnsInfo  where SnsInfo.snsId=" + j + " limit 1", null, 2);
        if (a.moveToFirst()) {
            mVar.b(a);
            a.close();
            return mVar;
        }
        a.close();
        return null;
    }

    public final m Gf(String str) {
        if (u.Eu(str)) {
            return dG(u.GA(str));
        }
        e dz = ae.beN().dz(u.GA(str));
        if (dz != null) {
            return dz.bhf();
        }
        return null;
    }

    public final m tH(int i) {
        m mVar = new m();
        Cursor a = this.gUz.a("select *,rowid from SnsInfo  where SnsInfo.rowid=" + i, null, 2);
        if (a.moveToFirst()) {
            mVar.b(a);
            a.close();
            return mVar;
        }
        a.close();
        return null;
    }

    public final m Gg(String str) {
        if (u.Eu(str)) {
            return tH(u.GB(str));
        }
        e tD = ae.beN().tD(u.GB(str));
        if (tD != null) {
            return tD.bhf();
        }
        return null;
    }

    public final boolean b(long j, m mVar) {
        ContentValues pv = mVar.pv();
        pv.remove("rowid");
        if (this.gUz.update("SnsInfo", pv, "snsId=?", new String[]{String.valueOf(j)}) > 0) {
            return true;
        }
        return false;
    }

    public final int b(int i, m mVar) {
        ContentValues pv = mVar.pv();
        pv.remove("rowid");
        return this.gUz.update("SnsInfo", pv, "rowid=?", new String[]{String.valueOf(i)});
    }

    public final boolean delete(long j) {
        int delete = this.gUz.delete("SnsInfo", "snsId=?", new String[]{String.valueOf(j)});
        w.d("MicroMsg.SnsInfoStorage", "del msg " + j + " res " + delete);
        if (delete > 0) {
            return true;
        }
        return false;
    }

    public final boolean tI(int i) {
        if (this.gUz.delete("SnsInfo", "rowid=?", new String[]{String.valueOf(i)}) > 0) {
            return true;
        }
        return false;
    }
}
