package com.tencent.mm.bj;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.os.HandlerThread;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.repair.DBDumpUtil;
import com.tencent.wcdb.repair.DBDumpUtil.ExecuteSqlCallback;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public class g implements e {
    public String TAG = "MicroMsg.SqliteDB";
    public int field_MARK_CURSOR_CHECK_IGNORE = 1;
    private long jCI = 0;
    private a uLW = null;
    public a uLX = new a();
    private String uLY = "";
    public String uLZ = "";
    protected e uLy = null;
    public final LinkedList<b> uMa = new LinkedList();
    private ae uMb = null;

    public interface a {
        void vA();

        void vy();

        void vz();
    }

    public static class b {
        public long lastReportTime;
        public Cursor uMf;
        public String uMg;
        public long uMh;
        public boolean uMi;
        public String uMj;
        public String uxg;
    }

    public interface c {
        String[] pP();
    }

    public g(a aVar) {
        this.uLW = aVar;
    }

    protected void finalize() {
        cQ(null);
    }

    public void wL() {
        cQ(null);
    }

    public void cQ(String str) {
        if (this.uLy != null) {
            if (this.uLW != null) {
                this.uLW.vy();
            }
            w.w(this.TAG, "begin close db, inTrans:%b ticket:%s  thr:%d {%s}", Boolean.valueOf(inTransaction()), Long.toHexString(this.jCI), Long.valueOf(Thread.currentThread().getId()), bg.bJZ());
            com.tencent.mm.compatible.util.g.a aVar = new com.tencent.mm.compatible.util.g.a();
            if (str != null) {
                this.uLY = str;
            }
            this.uLy.close();
            this.uLy = null;
            w.d(this.TAG, "end close db time:%d", Long.valueOf(aVar.se()));
        }
    }

    public final boolean bKn() {
        return this.uLy == null || !this.uLy.isOpen();
    }

    private void Su(String str) {
        String um = ab.um();
        String packageName = ab.getPackageName();
        w.i(this.TAG, "check process :[%s] [%s] path[%s]", um, packageName, str);
        if (um != null && packageName != null && !packageName.equals(um)) {
            Assert.assertTrue("processName:" + um + "  packagename:" + packageName, false);
        }
    }

    public final boolean b(String str, HashMap<Integer, c> hashMap, boolean z, boolean z2) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            this.TAG += "." + str.substring(lastIndexOf + 1);
        }
        Su(str);
        if (!this.uLX.a(str, hashMap, true, z2) || this.uLX.uLy == null) {
            this.uLy = null;
            this.uLX = null;
            w.e(this.TAG, "initDB failed.");
            return false;
        }
        this.uLy = this.uLX.uLy;
        return true;
    }

    public final boolean a(String str, String str2, String str3, long j, String str4, HashMap<Integer, c> hashMap, boolean z) {
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            this.TAG += "." + str.substring(lastIndexOf + 1);
        }
        Su(str2);
        if (!this.uLX.a(str, str2, str3, j, str4, hashMap, z) || this.uLX.uLy == null) {
            this.uLZ = this.uLX.getError();
            this.uLy = null;
            this.uLX = null;
            w.i(this.TAG, "initDB failed. %s", this.uLZ);
            return false;
        }
        this.uLZ = this.uLX.getError();
        this.uLy = this.uLX.uLy;
        return true;
    }

    public final boolean a(String str, String str2, long j, String str3, HashMap<Integer, c> hashMap) {
        return a(str, str2, "", j, str3, hashMap, true);
    }

    public final boolean isOpen() {
        if (this.uLy != null && this.uLy.isOpen()) {
            return true;
        }
        Assert.assertTrue("DB has been closed :[" + this.uLY + "]", bg.mA(this.uLY));
        return false;
    }

    public final String getKey() {
        if (this.uLX == null) {
            return null;
        }
        return this.uLX.arH;
    }

    public final String getPath() {
        if (isOpen()) {
            return this.uLy.getPath();
        }
        w.e(this.TAG, "DB IS CLOSED ! {%s}", bg.bJZ());
        return null;
    }

    public static String dP(String str) {
        if (bg.mA(str)) {
            return "";
        }
        return DatabaseUtils.sqlEscapeString(str);
    }

    public final Cursor query(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5) {
        return a(str, strArr, str2, strArr2, str3, str4, str5, 0);
    }

    public final Cursor a(String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, int i) {
        if (isOpen()) {
            b.begin();
            try {
                Cursor a = this.uLy.a(str, strArr, str2, strArr2, str3, str4, str5, i);
                b.a(str, a, this.jCI);
                return a;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.c.oTb.a(181, 10, 1, false);
                w.e(this.TAG, "execSQL Error :" + e.getMessage());
                b.i(e);
                return c.bNI();
            }
        }
        w.e(this.TAG, "DB IS CLOSED ! {%s}", bg.bJZ());
        return c.bNI();
    }

    public final Cursor a(final String str, String[] strArr, int i) {
        Assert.assertTrue("sql is null ", !bg.mA(str));
        if (isOpen()) {
            b.begin();
            try {
                final Cursor a = this.uLy.a(str, strArr, i);
                if (com.tencent.mm.sdk.a.b.bIs() || com.tencent.mm.sdk.a.b.bIu()) {
                    if (this.uMb == null) {
                        HandlerThread Qu = com.tencent.mm.sdk.f.e.Qu("CheckCursor");
                        Qu.start();
                        this.uMb = new ae(Qu.getLooper());
                    }
                    final StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                    this.uMb.postDelayed(new Runnable(this) {
                        final /* synthetic */ g uMe;

                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            /*
                            r15 = this;
                            r4 = com.tencent.mm.sdk.platformtools.bg.Nz();	 Catch:{ Exception -> 0x0045 }
                            r0 = r0;	 Catch:{ Exception -> 0x0045 }
                            if (r0 == 0) goto L_0x0010;
                        L_0x0008:
                            r0 = r0;	 Catch:{ Exception -> 0x0045 }
                            r0 = r0.isClosed();	 Catch:{ Exception -> 0x0045 }
                            if (r0 == 0) goto L_0x0011;
                        L_0x0010:
                            return;
                        L_0x0011:
                            r6 = new java.util.HashMap;	 Catch:{ Exception -> 0x0045 }
                            r6.<init>();	 Catch:{ Exception -> 0x0045 }
                            r3 = 0;
                            r0 = r15.uMe;	 Catch:{ Exception -> 0x0045 }
                            r7 = r0.uMa;	 Catch:{ Exception -> 0x0045 }
                            monitor-enter(r7);	 Catch:{ Exception -> 0x0045 }
                            r0 = r15.uMe;	 Catch:{ all -> 0x0042 }
                            r0 = r0.uMa;	 Catch:{ all -> 0x0042 }
                            r8 = r0.iterator();	 Catch:{ all -> 0x0042 }
                        L_0x0024:
                            r0 = r8.hasNext();	 Catch:{ all -> 0x0042 }
                            if (r0 == 0) goto L_0x0191;
                        L_0x002a:
                            r0 = r8.next();	 Catch:{ all -> 0x0042 }
                            r0 = (com.tencent.mm.bj.g.b) r0;	 Catch:{ all -> 0x0042 }
                            if (r0 == 0) goto L_0x003e;
                        L_0x0032:
                            r1 = r0.uMf;	 Catch:{ all -> 0x0042 }
                            if (r1 == 0) goto L_0x003e;
                        L_0x0036:
                            r1 = r0.uMf;	 Catch:{ all -> 0x0042 }
                            r1 = r1.isClosed();	 Catch:{ all -> 0x0042 }
                            if (r1 == 0) goto L_0x0067;
                        L_0x003e:
                            r8.remove();	 Catch:{ all -> 0x0042 }
                            goto L_0x0024;
                        L_0x0042:
                            r0 = move-exception;
                            monitor-exit(r7);	 Catch:{ all -> 0x0042 }
                            throw r0;	 Catch:{ Exception -> 0x0045 }
                        L_0x0045:
                            r0 = move-exception;
                            r1 = r15.uMe;
                            r1 = r1.TAG;
                            r2 = "checkCursor table:[%s] e:%s[%s]";
                            r3 = 3;
                            r3 = new java.lang.Object[r3];
                            r4 = 0;
                            r5 = r10;
                            r3[r4] = r5;
                            r4 = 1;
                            r5 = r0.getMessage();
                            r3[r4] = r5;
                            r4 = 2;
                            r0 = com.tencent.mm.sdk.platformtools.bg.g(r0);
                            r3[r4] = r0;
                            com.tencent.mm.sdk.platformtools.w.e(r1, r2, r3);
                            goto L_0x0010;
                        L_0x0067:
                            r10 = r0.lastReportTime;	 Catch:{ all -> 0x0042 }
                            r10 = r4 - r10;
                            r12 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
                            r10 = r10 / r12;
                            r12 = 100;
                            r1 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
                            if (r1 <= 0) goto L_0x00ba;
                        L_0x0074:
                            r0.lastReportTime = r4;	 Catch:{ all -> 0x0042 }
                            r1 = r0.uMi;	 Catch:{ all -> 0x0042 }
                            if (r1 == 0) goto L_0x0118;
                        L_0x007a:
                            r1 = r0.uMj;	 Catch:{ all -> 0x0042 }
                            r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0042 }
                            if (r1 == 0) goto L_0x00df;
                        L_0x0082:
                            r1 = r15.uMe;	 Catch:{ all -> 0x0042 }
                            r1 = r1.TAG;	 Catch:{ all -> 0x0042 }
                            r2 = "CheckCursorRES time:%d MSG: BadOut cu:%s caller:%s outCu:%b kw:%s";
                            r9 = 5;
                            r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x0042 }
                            r10 = 0;
                            r12 = r0.uMh;	 Catch:{ all -> 0x0042 }
                            r12 = r4 - r12;
                            r11 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x0042 }
                            r9[r10] = r11;	 Catch:{ all -> 0x0042 }
                            r10 = 1;
                            r11 = r0.uMf;	 Catch:{ all -> 0x0042 }
                            r11 = r11.hashCode();	 Catch:{ all -> 0x0042 }
                            r11 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x0042 }
                            r9[r10] = r11;	 Catch:{ all -> 0x0042 }
                            r10 = 2;
                            r11 = r0.uMg;	 Catch:{ all -> 0x0042 }
                            r9[r10] = r11;	 Catch:{ all -> 0x0042 }
                            r10 = 3;
                            r11 = r0.uMi;	 Catch:{ all -> 0x0042 }
                            r11 = java.lang.Boolean.valueOf(r11);	 Catch:{ all -> 0x0042 }
                            r9[r10] = r11;	 Catch:{ all -> 0x0042 }
                            r10 = 4;
                            r11 = r0.uMj;	 Catch:{ all -> 0x0042 }
                            r9[r10] = r11;	 Catch:{ all -> 0x0042 }
                            com.tencent.mm.sdk.platformtools.w.w(r1, r2, r9);	 Catch:{ all -> 0x0042 }
                        L_0x00ba:
                            r1 = r0.uMg;	 Catch:{ all -> 0x0042 }
                            r1 = r6.get(r1);	 Catch:{ all -> 0x0042 }
                            r1 = (android.util.Pair) r1;	 Catch:{ all -> 0x0042 }
                            if (r1 != 0) goto L_0x0154;
                        L_0x00c4:
                            r2 = r0.uMg;	 Catch:{ all -> 0x0042 }
                            r9 = new android.util.Pair;	 Catch:{ all -> 0x0042 }
                            r10 = r0.uMh;	 Catch:{ all -> 0x0042 }
                            r10 = r4 - r10;
                            r12 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
                            r1 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
                            if (r1 <= 0) goto L_0x0152;
                        L_0x00d2:
                            r1 = 1;
                        L_0x00d3:
                            r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x0042 }
                            r9.<init>(r1, r0);	 Catch:{ all -> 0x0042 }
                            r6.put(r2, r9);	 Catch:{ all -> 0x0042 }
                            goto L_0x0024;
                        L_0x00df:
                            r1 = r15.uMe;	 Catch:{ all -> 0x0042 }
                            r1 = r1.TAG;	 Catch:{ all -> 0x0042 }
                            r2 = "CheckCursorRES time:%d MSG: Adapter cu:%s caller:%s outCu:%b kw:%s";
                            r9 = 5;
                            r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x0042 }
                            r10 = 0;
                            r12 = r0.uMh;	 Catch:{ all -> 0x0042 }
                            r12 = r4 - r12;
                            r11 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x0042 }
                            r9[r10] = r11;	 Catch:{ all -> 0x0042 }
                            r10 = 1;
                            r11 = r0.uMf;	 Catch:{ all -> 0x0042 }
                            r11 = r11.hashCode();	 Catch:{ all -> 0x0042 }
                            r11 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x0042 }
                            r9[r10] = r11;	 Catch:{ all -> 0x0042 }
                            r10 = 2;
                            r11 = r0.uMg;	 Catch:{ all -> 0x0042 }
                            r9[r10] = r11;	 Catch:{ all -> 0x0042 }
                            r10 = 3;
                            r11 = r0.uMi;	 Catch:{ all -> 0x0042 }
                            r11 = java.lang.Boolean.valueOf(r11);	 Catch:{ all -> 0x0042 }
                            r9[r10] = r11;	 Catch:{ all -> 0x0042 }
                            r10 = 4;
                            r11 = r0.uMj;	 Catch:{ all -> 0x0042 }
                            r9[r10] = r11;	 Catch:{ all -> 0x0042 }
                            com.tencent.mm.sdk.platformtools.w.w(r1, r2, r9);	 Catch:{ all -> 0x0042 }
                            goto L_0x00ba;
                        L_0x0118:
                            r1 = r15.uMe;	 Catch:{ all -> 0x0042 }
                            r1 = r1.TAG;	 Catch:{ all -> 0x0042 }
                            r2 = "CheckCursorRES time:%d MSG: NOTCLOSE cu:%s caller:%s outCu:%b kw:%s";
                            r9 = 5;
                            r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x0042 }
                            r10 = 0;
                            r12 = r0.uMh;	 Catch:{ all -> 0x0042 }
                            r12 = r4 - r12;
                            r11 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x0042 }
                            r9[r10] = r11;	 Catch:{ all -> 0x0042 }
                            r10 = 1;
                            r11 = r0.uMf;	 Catch:{ all -> 0x0042 }
                            r11 = r11.hashCode();	 Catch:{ all -> 0x0042 }
                            r11 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x0042 }
                            r9[r10] = r11;	 Catch:{ all -> 0x0042 }
                            r10 = 2;
                            r11 = r0.uMg;	 Catch:{ all -> 0x0042 }
                            r9[r10] = r11;	 Catch:{ all -> 0x0042 }
                            r10 = 3;
                            r11 = r0.uMi;	 Catch:{ all -> 0x0042 }
                            r11 = java.lang.Boolean.valueOf(r11);	 Catch:{ all -> 0x0042 }
                            r9[r10] = r11;	 Catch:{ all -> 0x0042 }
                            r10 = 4;
                            r11 = r0.uMj;	 Catch:{ all -> 0x0042 }
                            r9[r10] = r11;	 Catch:{ all -> 0x0042 }
                            com.tencent.mm.sdk.platformtools.w.w(r1, r2, r9);	 Catch:{ all -> 0x0042 }
                            goto L_0x00ba;
                        L_0x0152:
                            r1 = 0;
                            goto L_0x00d3;
                        L_0x0154:
                            r10 = r0.uMh;	 Catch:{ all -> 0x0042 }
                            r10 = r4 - r10;
                            r12 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
                            r2 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
                            if (r2 <= 0) goto L_0x0393;
                        L_0x015e:
                            r9 = r0.uMg;	 Catch:{ all -> 0x0042 }
                            r10 = new android.util.Pair;	 Catch:{ all -> 0x0042 }
                            r2 = r1.first;	 Catch:{ all -> 0x0042 }
                            r2 = (java.lang.Integer) r2;	 Catch:{ all -> 0x0042 }
                            r2 = r2.intValue();	 Catch:{ all -> 0x0042 }
                            r2 = r2 + 1;
                            r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0042 }
                            r10.<init>(r2, r0);	 Catch:{ all -> 0x0042 }
                            r6.put(r9, r10);	 Catch:{ all -> 0x0042 }
                            r0 = r1.first;	 Catch:{ all -> 0x0042 }
                            r0 = (java.lang.Integer) r0;	 Catch:{ all -> 0x0042 }
                            r0 = r0.intValue();	 Catch:{ all -> 0x0042 }
                            r0 = r0 + 1;
                            if (r3 >= r0) goto L_0x018f;
                        L_0x0182:
                            r0 = r1.first;	 Catch:{ all -> 0x0042 }
                            r0 = (java.lang.Integer) r0;	 Catch:{ all -> 0x0042 }
                            r0 = r0.intValue();	 Catch:{ all -> 0x0042 }
                            r0 = r0 + 1;
                        L_0x018c:
                            r3 = r0;
                            goto L_0x0024;
                        L_0x018f:
                            r0 = r3;
                            goto L_0x018c;
                        L_0x0191:
                            r0 = r15.uMe;	 Catch:{ all -> 0x0042 }
                            r0 = r0.TAG;	 Catch:{ all -> 0x0042 }
                            r1 = "CheckCursor: checkAss max:%d list:%d map:%d";
                            r2 = 3;
                            r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0042 }
                            r8 = 0;
                            r9 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x0042 }
                            r2[r8] = r9;	 Catch:{ all -> 0x0042 }
                            r8 = 1;
                            r9 = r15.uMe;	 Catch:{ all -> 0x0042 }
                            r9 = r9.uMa;	 Catch:{ all -> 0x0042 }
                            r9 = r9.size();	 Catch:{ all -> 0x0042 }
                            r9 = java.lang.Integer.valueOf(r9);	 Catch:{ all -> 0x0042 }
                            r2[r8] = r9;	 Catch:{ all -> 0x0042 }
                            r8 = 2;
                            r9 = r6.size();	 Catch:{ all -> 0x0042 }
                            r9 = java.lang.Integer.valueOf(r9);	 Catch:{ all -> 0x0042 }
                            r2[r8] = r9;	 Catch:{ all -> 0x0042 }
                            com.tencent.mm.sdk.platformtools.w.d(r0, r1, r2);	 Catch:{ all -> 0x0042 }
                            r0 = com.tencent.mm.sdk.a.b.bIs();	 Catch:{ all -> 0x0042 }
                            if (r0 == 0) goto L_0x0242;
                        L_0x01c5:
                            r0 = 20;
                        L_0x01c7:
                            if (r3 > r0) goto L_0x01db;
                        L_0x01c9:
                            r0 = r15.uMe;	 Catch:{ all -> 0x0042 }
                            r0 = r0.uMa;	 Catch:{ all -> 0x0042 }
                            r1 = r0.size();	 Catch:{ all -> 0x0042 }
                            r0 = com.tencent.mm.sdk.a.b.bIs();	 Catch:{ all -> 0x0042 }
                            if (r0 == 0) goto L_0x0245;
                        L_0x01d7:
                            r0 = 50;
                        L_0x01d9:
                            if (r1 <= r0) goto L_0x025f;
                        L_0x01db:
                            r0 = "";
                            r1 = r6.keySet();	 Catch:{ all -> 0x0042 }
                            r3 = r1.iterator();	 Catch:{ all -> 0x0042 }
                            r2 = r0;
                        L_0x01e7:
                            r0 = r3.hasNext();	 Catch:{ all -> 0x0042 }
                            if (r0 == 0) goto L_0x0248;
                        L_0x01ed:
                            r0 = r3.next();	 Catch:{ all -> 0x0042 }
                            r0 = (java.lang.String) r0;	 Catch:{ all -> 0x0042 }
                            r1 = r6.get(r0);	 Catch:{ all -> 0x0042 }
                            r1 = (android.util.Pair) r1;	 Catch:{ all -> 0x0042 }
                            r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0042 }
                            r4.<init>();	 Catch:{ all -> 0x0042 }
                            r2 = r4.append(r2);	 Catch:{ all -> 0x0042 }
                            r0 = r2.append(r0);	 Catch:{ all -> 0x0042 }
                            r2 = ",";
                            r0 = r0.append(r2);	 Catch:{ all -> 0x0042 }
                            r2 = r1.first;	 Catch:{ all -> 0x0042 }
                            r0 = r0.append(r2);	 Catch:{ all -> 0x0042 }
                            r2 = ",";
                            r2 = r0.append(r2);	 Catch:{ all -> 0x0042 }
                            r0 = r1.second;	 Catch:{ all -> 0x0042 }
                            r0 = (com.tencent.mm.bj.g.b) r0;	 Catch:{ all -> 0x0042 }
                            r0 = r0.uMi;	 Catch:{ all -> 0x0042 }
                            r0 = r2.append(r0);	 Catch:{ all -> 0x0042 }
                            r2 = ",";
                            r2 = r0.append(r2);	 Catch:{ all -> 0x0042 }
                            r0 = r1.second;	 Catch:{ all -> 0x0042 }
                            r0 = (com.tencent.mm.bj.g.b) r0;	 Catch:{ all -> 0x0042 }
                            r0 = r0.uMj;	 Catch:{ all -> 0x0042 }
                            r0 = r2.append(r0);	 Catch:{ all -> 0x0042 }
                            r1 = ";";
                            r0 = r0.append(r1);	 Catch:{ all -> 0x0042 }
                            r0 = r0.toString();	 Catch:{ all -> 0x0042 }
                            r2 = r0;
                            goto L_0x01e7;
                        L_0x0242:
                            r0 = 50;
                            goto L_0x01c7;
                        L_0x0245:
                            r0 = 100;
                            goto L_0x01d9;
                        L_0x0248:
                            r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0042 }
                            r1 = "LeakCursor:";
                            r0.<init>(r1);	 Catch:{ all -> 0x0042 }
                            r0 = r0.append(r2);	 Catch:{ all -> 0x0042 }
                            r0 = r0.toString();	 Catch:{ all -> 0x0042 }
                            r1 = 0;
                            junit.framework.Assert.assertTrue(r0, r1);	 Catch:{ all -> 0x0042 }
                            monitor-exit(r7);	 Catch:{ all -> 0x0042 }
                            goto L_0x0010;
                        L_0x025f:
                            monitor-exit(r7);	 Catch:{ all -> 0x0042 }
                            r6 = com.tencent.mm.sdk.platformtools.bg.Nz();	 Catch:{ Exception -> 0x0045 }
                            r3 = new com.tencent.mm.bj.g$b;	 Catch:{ Exception -> 0x0045 }
                            r3.<init>();	 Catch:{ Exception -> 0x0045 }
                            r0 = r0;	 Catch:{ Exception -> 0x0045 }
                            r3.uMf = r0;	 Catch:{ Exception -> 0x0045 }
                            r0 = r10;	 Catch:{ Exception -> 0x0045 }
                            r3.uxg = r0;	 Catch:{ Exception -> 0x0045 }
                            r3.uMh = r4;	 Catch:{ Exception -> 0x0045 }
                            r0 = "";
                            r3.uMg = r0;	 Catch:{ Exception -> 0x0045 }
                            r0 = 1;
                            r3.uMi = r0;	 Catch:{ Exception -> 0x0045 }
                            r0 = 0;
                            r1 = r0;
                        L_0x027d:
                            r0 = r1;	 Catch:{ Exception -> 0x0045 }
                            r0 = r0.length;	 Catch:{ Exception -> 0x0045 }
                            if (r1 >= r0) goto L_0x033e;
                        L_0x0282:
                            r0 = r1;	 Catch:{ Exception -> 0x0045 }
                            r0 = r0[r1];	 Catch:{ Exception -> 0x0045 }
                            r0 = r0.getClassName();	 Catch:{ Exception -> 0x0045 }
                            r2 = r1;	 Catch:{ Exception -> 0x0045 }
                            r2 = r2[r1];	 Catch:{ Exception -> 0x0045 }
                            r8 = r2.getMethodName();	 Catch:{ Exception -> 0x0045 }
                            r2 = r1;	 Catch:{ Exception -> 0x0045 }
                            r2 = r2[r1];	 Catch:{ Exception -> 0x0045 }
                            r2 = r2.getLineNumber();	 Catch:{ Exception -> 0x0045 }
                            r9 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0045 }
                            r9.<init>();	 Catch:{ Exception -> 0x0045 }
                            r10 = "com.tencent.mm.";
                            r11 = "";
                            r10 = r0.replace(r10, r11);	 Catch:{ Exception -> 0x0045 }
                            r9 = r9.append(r10);	 Catch:{ Exception -> 0x0045 }
                            r10 = ":";
                            r9 = r9.append(r10);	 Catch:{ Exception -> 0x0045 }
                            r9 = r9.append(r8);	 Catch:{ Exception -> 0x0045 }
                            r10 = "(";
                            r9 = r9.append(r10);	 Catch:{ Exception -> 0x0045 }
                            r2 = r9.append(r2);	 Catch:{ Exception -> 0x0045 }
                            r9 = ")";
                            r2 = r2.append(r9);	 Catch:{ Exception -> 0x0045 }
                            r2 = r2.toString();	 Catch:{ Exception -> 0x0045 }
                            r9 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0045 }
                            r0 = "field_MARK_CURSOR_CHECK_IGNORE";
                            r0 = r9.getDeclaredField(r0);	 Catch:{ Exception -> 0x0317 }
                            if (r0 == 0) goto L_0x0315;
                        L_0x02db:
                            r0 = 1;
                        L_0x02dc:
                            if (r0 != 0) goto L_0x031c;
                        L_0x02de:
                            r0 = r3.uMg;	 Catch:{ Exception -> 0x0045 }
                            r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x0045 }
                            if (r0 == 0) goto L_0x0321;
                        L_0x02e6:
                            r3.uMg = r2;	 Catch:{ Exception -> 0x0045 }
                            r9 = r9.getMethods();	 Catch:{ Exception -> 0x0045 }
                            r2 = 0;
                            r10 = r9.length;	 Catch:{ Exception -> 0x0045 }
                            r0 = 0;
                            r14 = r0;
                            r0 = r2;
                            r2 = r14;
                        L_0x02f2:
                            if (r2 >= r10) goto L_0x031a;
                        L_0x02f4:
                            r11 = r9[r2];	 Catch:{ Exception -> 0x0045 }
                            r12 = r11.getName();	 Catch:{ Exception -> 0x0045 }
                            r12 = r12.equals(r8);	 Catch:{ Exception -> 0x0045 }
                            if (r12 == 0) goto L_0x0312;
                        L_0x0300:
                            r0 = r11.getReturnType();	 Catch:{ Exception -> 0x0045 }
                            r0 = r0.getName();	 Catch:{ Exception -> 0x0045 }
                            r11 = ".Cursor";
                            r0 = r0.contains(r11);	 Catch:{ Exception -> 0x0045 }
                            r11 = 1;
                            if (r0 == r11) goto L_0x031a;
                        L_0x0312:
                            r2 = r2 + 1;
                            goto L_0x02f2;
                        L_0x0315:
                            r0 = 0;
                            goto L_0x02dc;
                        L_0x0317:
                            r0 = move-exception;
                            r0 = 0;
                            goto L_0x02dc;
                        L_0x031a:
                            r3.uMi = r0;	 Catch:{ Exception -> 0x0045 }
                        L_0x031c:
                            r0 = r1 + 1;
                            r1 = r0;
                            goto L_0x027d;
                        L_0x0321:
                            r0 = r3.uMi;	 Catch:{ Exception -> 0x0045 }
                            if (r0 == 0) goto L_0x033e;
                        L_0x0325:
                            r0 = r2.toLowerCase();	 Catch:{ Exception -> 0x0045 }
                            r8 = "cursor";
                            r8 = r0.contains(r8);	 Catch:{ Exception -> 0x0045 }
                            if (r8 != 0) goto L_0x033b;
                        L_0x0332:
                            r8 = "adapter";
                            r0 = r0.contains(r8);	 Catch:{ Exception -> 0x0045 }
                            if (r0 == 0) goto L_0x031c;
                        L_0x033b:
                            r3.uMj = r2;	 Catch:{ Exception -> 0x0045 }
                            goto L_0x031c;
                        L_0x033e:
                            r0 = r3.uMg;	 Catch:{ Exception -> 0x0045 }
                            r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x0045 }
                            if (r0 == 0) goto L_0x034e;
                        L_0x0346:
                            r0 = r1;	 Catch:{ Exception -> 0x0045 }
                            r0 = com.tencent.mm.sdk.platformtools.ah.b(r0);	 Catch:{ Exception -> 0x0045 }
                            r3.uMg = r0;	 Catch:{ Exception -> 0x0045 }
                        L_0x034e:
                            r0 = r15.uMe;	 Catch:{ Exception -> 0x0045 }
                            r1 = r0.uMa;	 Catch:{ Exception -> 0x0045 }
                            monitor-enter(r1);	 Catch:{ Exception -> 0x0045 }
                            r0 = r15.uMe;	 Catch:{ all -> 0x0390 }
                            r0 = r0.uMa;	 Catch:{ all -> 0x0390 }
                            r0.add(r3);	 Catch:{ all -> 0x0390 }
                            monitor-exit(r1);	 Catch:{ all -> 0x0390 }
                            r0 = r15.uMe;	 Catch:{ Exception -> 0x0045 }
                            r0 = r0.TAG;	 Catch:{ Exception -> 0x0045 }
                            r1 = "checkCursor insert [%d,%d] caller:%s outCu:%b kw:%s";
                            r2 = 5;
                            r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0045 }
                            r8 = 0;
                            r6 = r6 - r4;
                            r6 = java.lang.Long.valueOf(r6);	 Catch:{ Exception -> 0x0045 }
                            r2[r8] = r6;	 Catch:{ Exception -> 0x0045 }
                            r6 = 1;
                            r4 = com.tencent.mm.sdk.platformtools.bg.aA(r4);	 Catch:{ Exception -> 0x0045 }
                            r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x0045 }
                            r2[r6] = r4;	 Catch:{ Exception -> 0x0045 }
                            r4 = 2;
                            r5 = r3.uMg;	 Catch:{ Exception -> 0x0045 }
                            r2[r4] = r5;	 Catch:{ Exception -> 0x0045 }
                            r4 = 3;
                            r5 = r3.uMi;	 Catch:{ Exception -> 0x0045 }
                            r5 = java.lang.Boolean.valueOf(r5);	 Catch:{ Exception -> 0x0045 }
                            r2[r4] = r5;	 Catch:{ Exception -> 0x0045 }
                            r4 = 4;
                            r3 = r3.uMj;	 Catch:{ Exception -> 0x0045 }
                            r2[r4] = r3;	 Catch:{ Exception -> 0x0045 }
                            com.tencent.mm.sdk.platformtools.w.d(r0, r1, r2);	 Catch:{ Exception -> 0x0045 }
                            goto L_0x0010;
                        L_0x0390:
                            r0 = move-exception;
                            monitor-exit(r1);	 Catch:{ all -> 0x0390 }
                            throw r0;	 Catch:{ Exception -> 0x0045 }
                        L_0x0393:
                            r0 = r3;
                            goto L_0x018c;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.bj.g.1.run():void");
                        }
                    }, 500);
                }
                b.a(str, a, this.jCI);
                return a;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.c.oTb.a(181, 10, 1, false);
                w.e(this.TAG, "execSQL Error :" + e.getMessage());
                b.i(e);
                return c.bNI();
            }
        }
        w.e(this.TAG, "DB IS CLOSED ! {%s}", bg.bJZ());
        return c.bNI();
    }

    public final Cursor rawQuery(String str, String[] strArr) {
        return a(str, strArr, 0);
    }

    public final boolean a(String str, String str2, String str3, List<String> list, ExecuteSqlCallback executeSqlCallback) {
        if (isOpen()) {
            return DBDumpUtil.doRecoveryDb(this.uLy.uLH, str, str2, str3, list, null, executeSqlCallback, true);
        }
        w.e(this.TAG, "DB IS CLOSED ! {%s}", bg.bJZ());
        return false;
    }

    public final long getPageSize() {
        return this.uLy.uLH.getPageSize();
    }

    public final SQLiteDatabase bNN() {
        if (this.uLy.uLH != null) {
            return this.uLy.uLH;
        }
        return this.uLy.uLI;
    }

    public final boolean eE(String str, String str2) {
        Assert.assertTrue("sql is null ", !bg.mA(str2));
        if (isOpen()) {
            b.begin();
            try {
                this.uLy.execSQL(str2);
                b.a(str2, null, this.jCI);
                return true;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.c.oTb.a(181, 11, 1, false);
                String message = e.getMessage();
                w.e(this.TAG, "execSQL Error :" + message);
                if (message != null && message.contains("no such table")) {
                    w.d("MicroMsg.DBInit", "resetIniCache iniFilename:%s", this.uLX.uLz);
                    com.tencent.mm.loader.stub.b.deleteFile(r1.uLz);
                    Assert.assertTrue("clean ini cache and reboot", false);
                }
                b.i(e);
                return false;
            }
        }
        w.e(this.TAG, "DB IS CLOSED ! {%s}", bg.bJZ());
        return false;
    }

    public final long insert(String str, String str2, ContentValues contentValues) {
        return a(str, str2, contentValues, false);
    }

    public final long a(String str, String str2, ContentValues contentValues, boolean z) {
        if (isOpen()) {
            b.begin();
            try {
                long insert = this.uLy.insert(str, str2, contentValues);
                b.a(str, null, this.jCI);
                return insert;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.c.oTb.a(181, 11, 1, false);
                w.e(this.TAG, "insert Error :" + e.getMessage());
                b.i(e);
                if (!z) {
                    return -1;
                }
                throw e;
            }
        }
        w.e(this.TAG, "DB IS CLOSED ! {%s}", bg.bJZ());
        return -2;
    }

    public final int update(String str, ContentValues contentValues, String str2, String[] strArr) {
        if (isOpen()) {
            b.begin();
            try {
                int update = this.uLy.update(str, contentValues, str2, strArr);
                b.a(str, null, this.jCI);
                return update;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.c.oTb.a(181, 11, 1, false);
                w.e(this.TAG, "update Error :" + e.getMessage());
                b.i(e);
                return -1;
            }
        }
        w.e(this.TAG, "DB IS CLOSED ! {%s}", bg.bJZ());
        return -2;
    }

    public final long replace(String str, String str2, ContentValues contentValues) {
        if (isOpen()) {
            b.begin();
            try {
                long replace = this.uLy.replace(str, str2, contentValues);
                b.a(str, null, this.jCI);
                return replace;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.c.oTb.a(181, 11, 1, false);
                w.e(this.TAG, "repalce  Error :" + e.getMessage());
                b.i(e);
                return -1;
            }
        }
        w.e(this.TAG, "DB IS CLOSED ! {%s}", bg.bJZ());
        return -2;
    }

    public final int delete(String str, String str2, String[] strArr) {
        if (isOpen()) {
            b.begin();
            try {
                int delete = this.uLy.delete(str, str2, strArr);
                b.a(str, null, this.jCI);
                return delete;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.c.oTb.a(181, 11, 1, false);
                w.e(this.TAG, "delete Error :" + e.getMessage());
                b.i(e);
                return -1;
            }
        }
        w.e(this.TAG, "DB IS CLOSED ! {%s}", bg.bJZ());
        return -2;
    }

    public final boolean Sv(String str) {
        if (isOpen()) {
            try {
                this.uLy.execSQL("DROP TABLE " + str);
            } catch (Exception e) {
                com.tencent.mm.plugin.report.c.oTb.a(181, 11, 1, false);
                w.e(this.TAG, "drop table Error :" + e.getMessage());
                b.i(e);
            }
        } else {
            w.e(this.TAG, "DB IS CLOSED ! {%s}", bg.bJZ());
        }
        return false;
    }

    public final synchronized long cs(long j) {
        long j2 = -1;
        synchronized (this) {
            w.i(this.TAG, "beginTransaction thr:(%d,%d) ticket:%d db:%b  {%s}", Long.valueOf(j), Long.valueOf(Thread.currentThread().getId()), Long.valueOf(this.jCI), Boolean.valueOf(isOpen()), bg.bJZ());
            if (!isOpen()) {
                w.e(this.TAG, "DB IS CLOSED ! {%s}", bg.bJZ());
                j2 = -4;
            } else if (this.jCI > 0) {
                w.e(this.TAG, "ERROR beginTransaction transactionTicket:" + this.jCI);
            } else if (af.isMainThread() || j != -1) {
                try {
                    b.begin();
                    this.uLy.beginTransaction();
                    b.a("beginTrans", null, 0);
                    this.jCI = bg.Nz() & 2147483647L;
                    this.jCI |= (r2 & 2147483647L) << 32;
                    if (this.uLW != null) {
                        this.uLW.vz();
                    }
                    j2 = this.jCI;
                } catch (Exception e) {
                    com.tencent.mm.plugin.report.c.oTb.a(181, 8, 1, false);
                    w.e(this.TAG, "beginTransaction Error :" + e.getMessage());
                    b.i(e);
                    j2 = -3;
                }
            } else {
                w.e(this.TAG, "FORBID: beginTrans UNKNOW_THREAD ParamID:%d nowThr:%d", Long.valueOf(j), Long.valueOf(r2));
                j2 = -2;
            }
        }
        return j2;
    }

    public final synchronized int aD(long j) {
        int i = 0;
        synchronized (this) {
            long Nz = bg.Nz();
            w.i(this.TAG, "endTransaction thr:%d ticket:(%d,%d) db:%b  {%s} ", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(j), Long.valueOf(this.jCI), Boolean.valueOf(isOpen()), bg.bJZ());
            if (!isOpen()) {
                w.e(this.TAG, "DB IS CLOSED ! {%s}", bg.bJZ());
                i = -4;
            } else if (j != this.jCI) {
                w.e(this.TAG, "ERROR endTransaction ticket:" + j + " transactionTicket:" + this.jCI);
                i = -1;
            } else {
                if (((j >> 32) & 2147483647L) != r4) {
                    w.e(this.TAG, "FORBID: endTrans UNKNOW_THREAD ticket:%s ParamID:%d nowThr:%d", Long.toHexString(j), Long.valueOf((j >> 32) & 2147483647L), Long.valueOf(r4));
                    i = -2;
                } else {
                    try {
                        b.begin();
                        this.uLy.endTransaction();
                        w.i(this.TAG, "endTransaction Succ Time:%d thr:%d ticket:(%d,%d) db:%b  {%s} ", Long.valueOf(bg.aA(Nz)), Long.valueOf(r4), Long.valueOf(j), Long.valueOf(this.jCI), Boolean.valueOf(isOpen()), bg.bJZ());
                        b.a("endTrans", null, 0);
                        this.jCI = 0;
                        if (this.uLW != null) {
                            this.uLW.vA();
                        }
                    } catch (Exception e) {
                        w.e(this.TAG, "endTransaction Error :" + e.getMessage());
                        com.tencent.mm.plugin.report.c.oTb.a(181, 9, 1, false);
                        b.i(e);
                        i = -3;
                    }
                }
            }
        }
        return i;
    }

    public final synchronized boolean inTransaction() {
        boolean z = false;
        synchronized (this) {
            if (!isOpen()) {
                w.e(this.TAG, "DB IS CLOSED ! {%s}", bg.bJZ());
            } else if (this.jCI > 0) {
                z = true;
            }
        }
        return z;
    }
}
