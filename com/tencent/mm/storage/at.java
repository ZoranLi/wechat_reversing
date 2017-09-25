package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public final class at extends m {
    public static final String[] gUx = new String[]{"CREATE TABLE IF NOT EXISTS  MediaDuplication  (md5 text , size int , path text , createtime long, remuxing text, duration int, status int);", "DROP INDEX IF EXISTS MediaDuplicationMD5Index ", "CREATE INDEX IF NOT EXISTS MD5Index ON MediaDuplication ( md5 )"};
    public e gUz;

    protected final boolean Fc() {
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public at(com.tencent.mm.bj.g r15) {
        /*
        r14 = this;
        r12 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
        r11 = 2;
        r1 = 1;
        r4 = 0;
        r6 = 0;
        r14.<init>();
        r14.gUz = r15;
        r7 = "MediaDuplication";
        r0 = r14.gUz;	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r3 = "PRAGMA table_info( ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r2 = r2.append(r7);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r3 = " )";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r3 = 0;
        r5 = 2;
        r2 = r0.a(r2, r3, r5);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r0 = "name";
        r8 = r2.getColumnIndex(r0);	 Catch:{ Exception -> 0x0195 }
        r0 = r6;
        r3 = r6;
        r5 = r6;
    L_0x0037:
        r9 = r2.moveToNext();	 Catch:{ Exception -> 0x0195 }
        if (r9 == 0) goto L_0x0064;
    L_0x003d:
        if (r8 < 0) goto L_0x0037;
    L_0x003f:
        r9 = r2.getString(r8);	 Catch:{ Exception -> 0x0195 }
        r10 = "remuxing";
        r10 = r10.equalsIgnoreCase(r9);	 Catch:{ Exception -> 0x0195 }
        if (r10 == 0) goto L_0x004e;
    L_0x004c:
        r5 = r1;
        goto L_0x0037;
    L_0x004e:
        r10 = "duration";
        r10 = r10.equalsIgnoreCase(r9);	 Catch:{ Exception -> 0x0195 }
        if (r10 == 0) goto L_0x0059;
    L_0x0057:
        r3 = r1;
        goto L_0x0037;
    L_0x0059:
        r10 = "status";
        r9 = r10.equalsIgnoreCase(r9);	 Catch:{ Exception -> 0x0195 }
        if (r9 == 0) goto L_0x0037;
    L_0x0062:
        r0 = r1;
        goto L_0x0037;
    L_0x0064:
        r2.close();	 Catch:{ Exception -> 0x0195 }
        r2 = com.tencent.mm.kernel.h.vI();	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r2 = r2.gYg;	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r8 = java.lang.Thread.currentThread();	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r8 = r8.getId();	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r8 = r2.cs(r8);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        if (r5 != 0) goto L_0x008c;
    L_0x007b:
        r2 = "MicroMsg.MediaCheckDuplicationStorage";
        r5 = "it had no [remuxing] column, alter table now";
        com.tencent.mm.sdk.platformtools.w.i(r2, r5);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r2 = "alter table MediaDuplication add remuxing text ";
        r5 = r14.gUz;	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r5.eE(r7, r2);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
    L_0x008c:
        if (r3 != 0) goto L_0x009f;
    L_0x008e:
        r2 = "MicroMsg.MediaCheckDuplicationStorage";
        r3 = "it had no [duration] column, alter table now";
        com.tencent.mm.sdk.platformtools.w.i(r2, r3);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r2 = "alter table MediaDuplication add duration int ";
        r3 = r14.gUz;	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r3.eE(r7, r2);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
    L_0x009f:
        if (r0 != 0) goto L_0x00b2;
    L_0x00a1:
        r0 = "MicroMsg.MediaCheckDuplicationStorage";
        r2 = "it had no [status] column, alter table now";
        com.tencent.mm.sdk.platformtools.w.i(r0, r2);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r0 = "alter table MediaDuplication add status int ";
        r2 = r14.gUz;	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r2.eE(r7, r0);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
    L_0x00b2:
        r2 = 0;
        r0 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x00c1;
    L_0x00b8:
        r0 = com.tencent.mm.kernel.h.vI();	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r0 = r0.gYg;	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
        r0.aD(r8);	 Catch:{ Exception -> 0x0116, all -> 0x0145 }
    L_0x00c1:
        r7 = "MediaDuplication";
        r2 = 0;
        r0 = r14.gUz;	 Catch:{ Exception -> 0x014c, all -> 0x017d }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x014c, all -> 0x017d }
        r8 = "SELECT count(*) from ";
        r5.<init>(r8);	 Catch:{ Exception -> 0x014c, all -> 0x017d }
        r5 = r5.append(r7);	 Catch:{ Exception -> 0x014c, all -> 0x017d }
        r5 = r5.toString();	 Catch:{ Exception -> 0x014c, all -> 0x017d }
        r8 = 0;
        r9 = 2;
        r5 = r0.a(r5, r8, r9);	 Catch:{ Exception -> 0x014c, all -> 0x017d }
        r0 = r5.moveToFirst();	 Catch:{ Exception -> 0x0187 }
        if (r0 == 0) goto L_0x0197;
    L_0x00e4:
        r0 = 0;
        r0 = r5.getInt(r0);	 Catch:{ Exception -> 0x0187 }
    L_0x00e9:
        r5.close();	 Catch:{ Exception -> 0x018b }
        if (r0 < r12) goto L_0x00f7;
    L_0x00ee:
        r5 = r14.gUz;	 Catch:{ Exception -> 0x018d, all -> 0x017d }
        r8 = 0;
        r9 = 0;
        r2 = r5.delete(r7, r8, r9);	 Catch:{ Exception -> 0x018d, all -> 0x017d }
        r2 = (long) r2;
    L_0x00f7:
        r4 = "MicroMsg.MediaCheckDuplicationStorage";
        r5 = "MediaDuplication record[%d], max record[%d], deleteRecord[%d]";
        r7 = 3;
        r7 = new java.lang.Object[r7];
        r0 = java.lang.Integer.valueOf(r0);
        r7[r6] = r0;
        r0 = java.lang.Integer.valueOf(r12);
        r7[r1] = r0;
        r0 = java.lang.Long.valueOf(r2);
        r7[r11] = r0;
        com.tencent.mm.sdk.platformtools.w.i(r4, r5, r7);
        return;
    L_0x0116:
        r0 = move-exception;
        r2 = r4;
    L_0x0118:
        r3 = "MicroMsg.MediaCheckDuplicationStorage";
        r5 = "";
        r7 = 0;
        r7 = new java.lang.Object[r7];	 Catch:{ all -> 0x0192 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r3, r0, r5, r7);	 Catch:{ all -> 0x0192 }
        r3 = "MicroMsg.MediaCheckDuplicationStorage";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0192 }
        r7 = "tryAddDBCol error: ";
        r5.<init>(r7);	 Catch:{ all -> 0x0192 }
        r0 = r0.toString();	 Catch:{ all -> 0x0192 }
        r0 = r5.append(r0);	 Catch:{ all -> 0x0192 }
        r0 = r0.toString();	 Catch:{ all -> 0x0192 }
        com.tencent.mm.sdk.platformtools.w.e(r3, r0);	 Catch:{ all -> 0x0192 }
        if (r2 == 0) goto L_0x00c1;
    L_0x0140:
        r2.close();
        goto L_0x00c1;
    L_0x0145:
        r0 = move-exception;
    L_0x0146:
        if (r4 == 0) goto L_0x014b;
    L_0x0148:
        r4.close();
    L_0x014b:
        throw r0;
    L_0x014c:
        r0 = move-exception;
        r5 = r4;
        r4 = r0;
        r0 = r6;
    L_0x0150:
        r7 = "MicroMsg.MediaCheckDuplicationStorage";
        r8 = "";
        r9 = 0;
        r9 = new java.lang.Object[r9];	 Catch:{ all -> 0x0185 }
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r7, r4, r8, r9);	 Catch:{ all -> 0x0185 }
        r7 = "MicroMsg.MediaCheckDuplicationStorage";
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0185 }
        r9 = "check to delete MediaDuplication. error : ";
        r8.<init>(r9);	 Catch:{ all -> 0x0185 }
        r4 = r4.toString();	 Catch:{ all -> 0x0185 }
        r4 = r8.append(r4);	 Catch:{ all -> 0x0185 }
        r4 = r4.toString();	 Catch:{ all -> 0x0185 }
        com.tencent.mm.sdk.platformtools.w.e(r7, r4);	 Catch:{ all -> 0x0185 }
        if (r5 == 0) goto L_0x00f7;
    L_0x0178:
        r5.close();
        goto L_0x00f7;
    L_0x017d:
        r0 = move-exception;
        r5 = r4;
    L_0x017f:
        if (r5 == 0) goto L_0x0184;
    L_0x0181:
        r5.close();
    L_0x0184:
        throw r0;
    L_0x0185:
        r0 = move-exception;
        goto L_0x017f;
    L_0x0187:
        r0 = move-exception;
        r4 = r0;
        r0 = r6;
        goto L_0x0150;
    L_0x018b:
        r4 = move-exception;
        goto L_0x0150;
    L_0x018d:
        r5 = move-exception;
        r13 = r5;
        r5 = r4;
        r4 = r13;
        goto L_0x0150;
    L_0x0192:
        r0 = move-exception;
        r4 = r2;
        goto L_0x0146;
    L_0x0195:
        r0 = move-exception;
        goto L_0x0118;
    L_0x0197:
        r0 = r6;
        goto L_0x00e9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.storage.at.<init>(com.tencent.mm.bj.g):void");
    }

    public final boolean p(String str, int i, String str2) {
        if (bg.mA(str2)) {
            w.e("MicroMsg.MediaCheckDuplicationStorage", "insert path is null");
            return false;
        }
        if (i <= 0) {
            int aN = com.tencent.mm.a.e.aN(str2);
            if (aN <= 0) {
                w.e("MicroMsg.MediaCheckDuplicationStorage", "insert path insize:%d size:%d  path:%s", Integer.valueOf(i), Integer.valueOf(aN), str2);
                return false;
            }
            i = aN;
        }
        if (bg.mA(str)) {
            str = g.aV(str2);
            if (bg.mA(str)) {
                w.e("MicroMsg.MediaCheckDuplicationStorage", "insert path read md5 failed  path:%s", str2);
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("md5", str);
        contentValues.put("size", Integer.valueOf(i));
        contentValues.put("path", str2);
        contentValues.put("createtime", Long.valueOf(bg.Nz()));
        contentValues.put(DownloadInfo.STATUS, Integer.valueOf(101));
        w.i("MicroMsg.MediaCheckDuplicationStorage", "insert Ret:%d size:%d md5:%s path:%s", Long.valueOf(this.gUz.insert("MediaDuplication", "", contentValues)), Integer.valueOf(i), str, str2);
        return this.gUz.insert("MediaDuplication", "", contentValues) > 0;
    }

    public final String cH(String str, int i) {
        if (bg.mA(str) || i <= 0) {
            w.e("MicroMsg.MediaCheckDuplicationStorage", "check  md5:%s size:%d", str, Integer.valueOf(i));
            return "";
        }
        Cursor a = this.gUz.a("select path from MediaDuplication where md5 = '" + str + "' and  size = " + i + " and status != 100", null, 2);
        if (a == null) {
            w.e("MicroMsg.MediaCheckDuplicationStorage", "check query return null sql:%s", r1);
            return null;
        }
        String str2 = "";
        if (a.moveToNext()) {
            str2 = a.getString(0);
        }
        a.close();
        if (bg.mA(str2) || com.tencent.mm.a.e.aN(str2) > 0) {
            return str2;
        }
        w.w("MicroMsg.MediaCheckDuplicationStorage", "check file size is zero, delete db record now. path[%s], fileSize[%d], size[%d]", str2, Integer.valueOf(com.tencent.mm.a.e.aN(str2)), Integer.valueOf(i));
        this.gUz.delete("MediaDuplication", "md5=? AND size=? AND status!=?", new String[]{str, String.valueOf(i), "100"});
        return "";
    }

    public final boolean H(String str, String str2, int i) {
        if (bg.mA(str) || bg.mA(str2)) {
            w.w("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing info, but path is null. [%s, %s] ", str, str2);
            return false;
        }
        int aN = com.tencent.mm.a.e.aN(str);
        int aN2 = com.tencent.mm.a.e.aN(str2);
        if (aN <= 0 || aN2 <= 0) {
            w.w("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing info, but file size is zero.[%d, %d]", Integer.valueOf(aN), Integer.valueOf(aN2));
            return false;
        }
        String aV = g.aV(str);
        if (bg.mA(aV)) {
            w.w("MicroMsg.MediaCheckDuplicationStorage", "import file is not null, but md5 is null, path " + str + " size : " + aN);
            return false;
        }
        long NA = bg.NA();
        ContentValues contentValues = new ContentValues();
        contentValues.put("md5", aV);
        contentValues.put("size", Integer.valueOf(aN));
        contentValues.put("createtime", Long.valueOf(bg.Nz()));
        contentValues.put("remuxing", str2);
        contentValues.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, Integer.valueOf(i));
        contentValues.put(DownloadInfo.STATUS, Integer.valueOf(100));
        w.i("MicroMsg.MediaCheckDuplicationStorage", "insert video remuxing ret[%d], size[%d], md5[%s], remuxingPath[%s], importPath[%s], duration[%d], cost time[%d]", Long.valueOf(this.gUz.insert("MediaDuplication", "", contentValues)), Integer.valueOf(aN), aV, str2, str, Integer.valueOf(i), Long.valueOf(bg.aB(NA)));
        return this.gUz.insert("MediaDuplication", "", contentValues) > 0;
    }

    public final boolean a(String str, PString pString, PInt pInt) {
        if (bg.mA(str)) {
            w.d("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but import path is null.");
            return false;
        }
        int aN = com.tencent.mm.a.e.aN(str);
        if (aN <= 0) {
            w.w("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but file size is zero. path : " + str);
            return false;
        }
        String aV = g.aV(str);
        if (bg.mA(aV)) {
            w.w("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing, but md5 is null. path : " + str);
            return false;
        }
        String str2 = "select remuxing, duration from MediaDuplication  where md5 = '" + aV + "' AND  size = " + aN + " AND status = 100";
        long NA = bg.NA();
        Cursor cursor = null;
        try {
            cursor = this.gUz.a(str2, null, 2);
            if (cursor != null && cursor.moveToFirst()) {
                pString.value = cursor.getString(0);
                pInt.value = cursor.getInt(1);
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MediaCheckDuplicationStorage", e, "", new Object[0]);
            w.e("MicroMsg.MediaCheckDuplicationStorage", "check video remuxing error: " + e.toString());
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        if (bg.mA(pString.value)) {
            w.d("MicroMsg.MediaCheckDuplicationStorage", "it has no remuxing path.");
            return false;
        } else if (com.tencent.mm.a.e.aN(pString.value) <= 0) {
            w.w("MicroMsg.MediaCheckDuplicationStorage", "remuxing file size is zero, delete db record now. remuxing path : " + pString.value);
            this.gUz.delete("MediaDuplication", "md5=? AND size=? AND status=?", new String[]{aV, String.valueOf(aN), "100"});
            pString.value = null;
            return false;
        } else {
            w.i("MicroMsg.MediaCheckDuplicationStorage", "check remuxing file success. remuxing path[%s], duration [%d], cost time[%d]", pString.value, Integer.valueOf(pInt.value), Long.valueOf(bg.aB(NA)));
            return true;
        }
    }
}
