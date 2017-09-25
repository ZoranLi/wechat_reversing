package com.tencent.mm.plugin.dbbackup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Parcel;
import android.os.PowerManager;
import android.os.Process;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mm.a.g;
import com.tencent.mm.ah.n;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.e.a.lc;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.tmassistantsdk.downloadservice.DownloadHelper;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.repair.BackupKit;
import com.tencent.wcdb.repair.DBDumpUtil.ExecuteSqlCallback;
import com.tencent.wcdb.repair.RecoverKit;
import com.tencent.wcdb.repair.RepairKit;
import com.tencent.wcdb.repair.RepairKit.MasterInfo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d implements am {
    public static final SQLiteCipherSpec kFy = new SQLiteCipherSpec().setPageSize(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT).setSQLCipherVersion(1);
    private BroadcastReceiver hLK;
    public boolean hLL = false;
    public boolean hLM = true;
    public Runnable hLO;
    public volatile BackupKit kFi;
    public volatile RecoverKit kFj;
    public volatile RepairKit kFk;
    public volatile boolean kFl = false;
    public boolean kFm = false;
    public boolean kFn = false;
    public long kFo = 0;
    public long kFp = 600000;
    public long kFq = 0;
    public int kFr = 10;
    private boolean kFs = false;
    final SimpleDateFormat kFt = new SimpleDateFormat("HH:mm:ss.SSS");
    private String kFu;
    private FLock kFv;
    private com.tencent.mm.sdk.e.j.a kFw;
    private c kFx;

    private static class a extends RuntimeException {
        a(String str) {
            super(str);
        }
    }

    private static long[] tD(String str) {
        Throwable e;
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(str + ".bcur"));
            try {
                long parseLong = Long.parseLong(bufferedReader.readLine());
                long parseLong2 = Long.parseLong(bufferedReader.readLine());
                long parseLong3 = Long.parseLong(bufferedReader.readLine());
                long parseLong4 = Long.parseLong(bufferedReader.readLine());
                long[] jArr = new long[]{parseLong, parseLong2, parseLong3, parseLong4};
                try {
                    bufferedReader.close();
                    return jArr;
                } catch (IOException e2) {
                    return jArr;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    w.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to read previous cursor '%s'", str);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e4) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            w.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to read previous cursor '%s'", str);
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw e;
        }
    }

    public static boolean a(String str, long[] jArr) {
        Throwable e;
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(str + ".bcur");
            try {
                for (long l : jArr) {
                    fileWriter.write(Long.toString(l) + "\n");
                }
                try {
                    fileWriter.close();
                    return true;
                } catch (IOException e2) {
                    return true;
                }
            } catch (IOException e3) {
                e = e3;
                try {
                    w.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to write previous cursor '%s'", str);
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e4) {
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    e = th;
                    if (fileWriter != null) {
                        try {
                            fileWriter.close();
                        } catch (IOException e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (IOException e6) {
            e = e6;
            fileWriter = null;
            w.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to write previous cursor '%s'", str);
            if (fileWriter != null) {
                fileWriter.close();
            }
            return false;
        } catch (Throwable th2) {
            e = th2;
            fileWriter = null;
            if (fileWriter != null) {
                fileWriter.close();
            }
            throw e;
        }
    }

    public final boolean a(boolean z, b bVar) {
        if (this.kFl) {
            w.i("MicroMsg.SubCoreDBBackup", "Backup or recover task is in progress, %s canceled", "backup");
            return false;
        }
        long j;
        String[] strArr;
        boolean z2;
        int i;
        final com.tencent.mm.u.c yY = ap.yY();
        final String vp = com.tencent.mm.u.c.vp();
        final SQLiteDatabase bNN = com.tencent.mm.u.c.wO().bNN();
        final String str = vp + ".bak";
        final String str2 = str + ".tmp";
        final String str3 = vp + ".sm";
        final String str4 = str3 + ".tmp";
        int i2 = 8;
        if (z) {
            if (FileOp.aO(str)) {
                i2 = 24;
                FileOp.p(str, str2);
            } else {
                z = false;
            }
        }
        long j2 = -1;
        long j3 = -1;
        long j4 = -1;
        Cursor rawQueryWithFactory = bNN.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(msgId) FROM message;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            j = rawQueryWithFactory.getLong(0);
        } else {
            j = -1;
        }
        rawQueryWithFactory.close();
        rawQueryWithFactory = bNN.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(id) FROM ImgInfo2;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            j2 = rawQueryWithFactory.getLong(0);
        }
        rawQueryWithFactory.close();
        rawQueryWithFactory = bNN.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(rowid) FROM videoinfo2;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            j3 = rawQueryWithFactory.getLong(0);
        }
        rawQueryWithFactory.close();
        rawQueryWithFactory = bNN.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(rowid) FROM EmojiInfo;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            j4 = rawQueryWithFactory.getLong(0);
        }
        rawQueryWithFactory.close();
        final long[] jArr = new long[]{j, j2, j3, j4};
        final long[] tD = z ? tD(vp) : null;
        if (tD == null || tD.length < 4) {
            strArr = new String[]{"message", "msgId <= " + jArr[0], "ImgInfo2", "id <= " + jArr[1], "videoinfo2", "rowid <= " + jArr[2], "EmojiInfo", "rowid <= " + jArr[3], "conversation", null, "rconversation", null};
        } else {
            strArr = new String[12];
            strArr[0] = "message";
            strArr[1] = String.format("msgId > %d AND msgId <= %d", new Object[]{Long.valueOf(tD[0]), Long.valueOf(jArr[0])});
            strArr[2] = "ImgInfo2";
            strArr[3] = String.format("id > %d AND id <= %d", new Object[]{Long.valueOf(tD[1]), Long.valueOf(jArr[1])});
            strArr[4] = "videoinfo2";
            strArr[5] = String.format("rowid > %d AND rowid <= %d", new Object[]{Long.valueOf(tD[2]), Long.valueOf(jArr[2])});
            strArr[6] = "EmojiInfo";
            strArr[7] = String.format("rowid > %d AND rowid <= %d", new Object[]{Long.valueOf(tD[3]), Long.valueOf(jArr[3])});
            strArr[8] = "conversation";
            strArr[9] = null;
            strArr[10] = "rconversation";
            strArr[11] = null;
        }
        if (tD == null) {
            z2 = false;
        } else {
            z2 = z;
        }
        if (this.kFs) {
            i = i2 | 3;
        } else {
            i = i2;
        }
        final b bVar2 = bVar;
        Runnable anonymousClass1 = new Runnable(this) {
            final /* synthetic */ d kFL;

            public final void run() {
                if (this.kFL.kFl) {
                    this.kFL.kFi = null;
                    try {
                        String str;
                        int i;
                        int i2;
                        long nanoTime = System.nanoTime();
                        byte[] o = g.o((p.rA() + com.tencent.mm.u.c.uH()).getBytes());
                        File file = new File(str3);
                        if (!(z2 && file.exists())) {
                            boolean renameTo;
                            boolean save = MasterInfo.save(bNN, str4, o);
                            File file2 = new File(str4);
                            if (save) {
                                file.delete();
                                renameTo = file2.renameTo(file);
                            } else {
                                file2.delete();
                                renameTo = save;
                            }
                            long nanoTime2 = System.nanoTime() - nanoTime;
                            str = "MicroMsg.SubCoreDBBackup";
                            String str2 = "Master table backup %s, elapsed %.3f";
                            Object[] objArr = new Object[2];
                            objArr[0] = renameTo ? "SUCCEEDED" : "FAILED";
                            objArr[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
                            w.i(str, str2, objArr);
                            com.tencent.mm.plugin.report.service.g.oUh.a(181, renameTo ? 24 : 25, 1, false);
                        }
                        long length = new File(vp).length();
                        long length2 = new File(str2).length();
                        String str3 = "MicroMsg.SubCoreDBBackup";
                        String str4 = "Backup started [%s, cursor: %d ~ %d]";
                        Object[] objArr2 = new Object[3];
                        objArr2[0] = z2 ? "incremental" : "new";
                        objArr2[1] = Long.valueOf(tD != null ? tD[0] : 0);
                        objArr2[2] = Long.valueOf(jArr != null ? jArr[0] : 0);
                        w.i(str3, str4, objArr2);
                        int i3 = z2 ? 10011 : 10000;
                        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                        Object[] objArr3 = new Object[2];
                        objArr3[0] = Integer.valueOf(i3);
                        objArr3[1] = String.format("%d|%d|%s", new Object[]{Long.valueOf(length), Long.valueOf(length2), this.kFL.kFt.format(new Date())});
                        gVar.i(11098, objArr3);
                        this.kFL.kFi = new BackupKit(bNN, str2, o, i, strArr);
                        int run = this.kFL.kFi.run();
                        nanoTime = System.nanoTime() - nanoTime;
                        File file3 = new File(str2);
                        long length3 = file3.length();
                        if (run == 0) {
                            d.a(vp, jArr);
                            file = new File(str);
                            file.delete();
                            file3.renameTo(file);
                            if (z2) {
                                i = 19;
                                i2 = 10012;
                            } else {
                                i = 16;
                                i2 = CdnLogic.MediaType_FAVORITE_FILE;
                            }
                        } else {
                            file3.delete();
                            if (run == 1) {
                                if (z2) {
                                    i = 20;
                                    i2 = 10013;
                                } else {
                                    i = 17;
                                    i2 = CdnLogic.MediaType_FAVORITE_VIDEO;
                                }
                            } else if (z2) {
                                i = 21;
                                i2 = 10014;
                            } else {
                                i = 18;
                                i2 = 10003;
                            }
                        }
                        str = "MicroMsg.SubCoreDBBackup";
                        str3 = "Database %s backup %s, elapsed %.2f seconds.";
                        objArr3 = new Object[3];
                        objArr3[0] = z2 ? "incremental" : "new";
                        String str5 = run == 0 ? "succeeded" : run == 1 ? "canceled" : "failed";
                        objArr3[1] = str5;
                        objArr3[2] = Float.valueOf(((float) nanoTime) / 1.0E9f);
                        w.i(str, str3, objArr3);
                        com.tencent.mm.plugin.report.service.g.oUh.a(181, (long) i, 1, false);
                        com.tencent.mm.plugin.report.service.g gVar2 = com.tencent.mm.plugin.report.service.g.oUh;
                        Object[] objArr4 = new Object[2];
                        objArr4[0] = Integer.valueOf(i2);
                        objArr4[1] = String.format("%d|%d|%d|%d|%d|%s", new Object[]{Long.valueOf(length), Long.valueOf(length2), Long.valueOf(length3), Integer.valueOf(this.kFL.kFi.statementCount()), Long.valueOf(nanoTime / 1000000), this.kFL.kFt.format(new Date())});
                        gVar2.i(11098, objArr4);
                        if (bVar2 != null) {
                            bVar2.kZ(run);
                        }
                        this.kFL.kFi.release();
                        this.kFL.kFi = null;
                        StringBuilder stringBuilder = new StringBuilder();
                        h.vJ();
                        FileOp.kl(stringBuilder.append(h.vI().gYf).append("dbback").toString());
                        str5 = str3;
                        StringBuilder stringBuilder2 = new StringBuilder();
                        h.vJ();
                        FileOp.p(str5, stringBuilder2.append(h.vI().gYf).append("dbback/EnMicroMsg.db.sm").toString());
                        str5 = str;
                        stringBuilder2 = new StringBuilder();
                        h.vJ();
                        FileOp.p(str5, stringBuilder2.append(h.vI().gYf).append("dbback/EnMicroMsg.db.bak").toString());
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database backup, path: %s", vp);
                        if (bVar2 != null) {
                            bVar2.kZ(-1);
                        }
                        com.tencent.mm.plugin.report.service.g.oUh.a(181, z2 ? 18 : 21, 1, false);
                    } finally {
                        if (this.kFL.kFi != null) {
                            this.kFL.kFi.release();
                            this.kFL.kFi = null;
                        }
                        this.kFL.kFl = false;
                    }
                } else if (bVar2 != null) {
                    bVar2.kZ(1);
                }
            }
        };
        this.kFl = true;
        e.post(anonymousClass1, "DB Backup");
        return true;
    }

    public final synchronized boolean akH() {
        boolean z = false;
        synchronized (this) {
            this.kFl = false;
            if (this.kFi != null) {
                this.kFi.cancel();
                z = true;
            }
        }
        return z;
    }

    public final synchronized int a(String str, b bVar) {
        final com.tencent.mm.u.c yY = ap.yY();
        final long bJV = bg.bJV();
        final String str2 = str;
        final b bVar2 = bVar;
        Runnable anonymousClass2 = new Runnable(this) {
            final /* synthetic */ d kFL;

            public final void run() {
                SQLiteDatabase openDatabase;
                int i;
                Exception exception;
                Throwable e;
                this.kFL.kFj = null;
                try {
                    com.tencent.mm.u.c.wT();
                    com.tencent.mm.u.c.wW();
                    n.GS();
                    o.KV();
                    long nanoTime = System.nanoTime();
                    byte[] bytes = (p.rA() + com.tencent.mm.u.c.uH()).getBytes();
                    byte[] o = g.o(bytes);
                    byte[] bytes2 = g.n(bytes).substring(0, 7).getBytes();
                    int i2 = SQLiteDatabase.CREATE_IF_NECESSARY;
                    if (com.tencent.mm.bj.e.bNM()) {
                        i2 = 805306368;
                    }
                    openDatabase = SQLiteDatabase.openDatabase(com.tencent.mm.u.c.wO().bNN().getPath(), bytes2, d.kFy, null, i2, null, 0);
                    try {
                        String[] strArr;
                        long length;
                        if (str2 != null) {
                            strArr = new String[]{str2};
                        } else {
                            String[] strArr2 = new String[2];
                            strArr2[0] = com.tencent.mm.u.c.vn() + ".bak";
                            StringBuilder stringBuilder = new StringBuilder();
                            h.vJ();
                            strArr2[1] = stringBuilder.append(h.vI().gYf).append("dbback/EnMicroMsg.db.bak").toString();
                            strArr = strArr2;
                        }
                        i = -3;
                        int length2 = strArr.length;
                        int i3 = 0;
                        long j = 0;
                        while (i3 < length2) {
                            String str = strArr[i3];
                            try {
                                File file = new File(str);
                                if (file.canRead()) {
                                    length = file.length();
                                    try {
                                        w.i("MicroMsg.SubCoreDBBackup", "[Recover] backupSize: %d, diskFreeSpace: %d", Long.valueOf(length), Long.valueOf(bJV));
                                        if (bJV >= 10 * length) {
                                            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                                            Object[] objArr = new Object[2];
                                            objArr[0] = Integer.valueOf(10004);
                                            objArr[1] = String.format("%d|%d", new Object[]{Long.valueOf(length), Long.valueOf(bJV)});
                                            gVar.i(11098, objArr);
                                            this.kFL.kFj = new RecoverKit(openDatabase, str, o);
                                            break;
                                        }
                                        if (bVar2 != null) {
                                            bVar2.kZ(-2);
                                        }
                                        if (this.kFL.kFj != null) {
                                            this.kFL.kFj.release();
                                            this.kFL.kFj = null;
                                        }
                                        if (openDatabase != null) {
                                            openDatabase.close();
                                        }
                                        this.kFL.kFl = false;
                                        ap.vL().bJk();
                                        return;
                                    } catch (Exception e2) {
                                        exception = e2;
                                        j = length;
                                        try {
                                            w.e("MicroMsg.SubCoreDBBackup", "Initialize RecoverKit failed: " + exception.getMessage());
                                            i = -1;
                                            i3++;
                                        } catch (Exception e3) {
                                            e = e3;
                                        }
                                    }
                                } else {
                                    continue;
                                    i3++;
                                }
                            } catch (Exception e4) {
                                exception = e4;
                                w.e("MicroMsg.SubCoreDBBackup", "Initialize RecoverKit failed: " + exception.getMessage());
                                i = -1;
                                i3++;
                            }
                        }
                        length = j;
                        int i4;
                        if (this.kFL.kFj == null) {
                            i4 = -3;
                            try {
                                com.tencent.mm.plugin.report.service.g.oUh.a(181, 31, 1, true);
                                throw new RuntimeException();
                            } catch (Exception e5) {
                                e = e5;
                                i = i4;
                                try {
                                    w.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database recovery", new Object[0]);
                                    if (bVar2 != null) {
                                        bVar2.kZ(i);
                                    }
                                    com.tencent.mm.plugin.report.service.g.oUh.a(181, 23, 1, true);
                                    if (this.kFL.kFj != null) {
                                        this.kFL.kFj.release();
                                        this.kFL.kFj = null;
                                    }
                                    if (openDatabase != null) {
                                        openDatabase.close();
                                    }
                                    this.kFL.kFl = false;
                                    ap.vL().bJk();
                                } catch (Throwable th) {
                                    e = th;
                                    if (this.kFL.kFj != null) {
                                        this.kFL.kFj.release();
                                        this.kFL.kFj = null;
                                    }
                                    if (openDatabase != null) {
                                        openDatabase.close();
                                    }
                                    this.kFL.kFl = false;
                                    ap.vL().bJk();
                                    throw e;
                                }
                            }
                        }
                        int i5;
                        int i6;
                        i4 = this.kFL.kFj.run(false);
                        d.akJ();
                        long nanoTime2 = System.nanoTime() - nanoTime;
                        i3 = this.kFL.kFj.successCount();
                        int failureCount = this.kFL.kFj.failureCount();
                        String lastError = this.kFL.kFj.lastError();
                        this.kFL.kFj.release();
                        this.kFL.kFj = null;
                        openDatabase.close();
                        openDatabase = null;
                        String str2 = "MicroMsg.SubCoreDBBackup";
                        String str3 = "Database recover %s, elapsed %.2f seconds. [success: %d, failure: %d]";
                        Object[] objArr2 = new Object[4];
                        String str4 = i4 == 0 ? "succeeded" : i4 == 1 ? "canceled" : "failed";
                        objArr2[0] = str4;
                        objArr2[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
                        objArr2[2] = Integer.valueOf(i3);
                        objArr2[3] = Integer.valueOf(failureCount);
                        w.i(str2, str3, objArr2);
                        if (i4 == 0) {
                            i5 = 10005;
                            i6 = 22;
                        } else if (i4 == 1) {
                            i5 = 10006;
                            i6 = -1;
                        } else {
                            i5 = 10007;
                            i6 = 23;
                            com.tencent.mm.plugin.report.service.g.oUh.d("DBRepair", "Backup recover failed: " + lastError, null);
                        }
                        com.tencent.mm.plugin.report.service.g gVar2 = com.tencent.mm.plugin.report.service.g.oUh;
                        objArr2 = new Object[2];
                        objArr2[0] = Integer.valueOf(i5);
                        objArr2[1] = String.format("%d|%d|%d|%d", new Object[]{Long.valueOf(length), Long.valueOf(nanoTime2 / 1000000), Integer.valueOf(i3), Integer.valueOf(failureCount)});
                        gVar2.i(11098, objArr2);
                        if (i6 >= 0) {
                            com.tencent.mm.plugin.report.service.g.oUh.a(181, (long) i6, 1, true);
                        }
                        if (bVar2 != null) {
                            bVar2.kZ(i4);
                        }
                        if (this.kFL.kFj != null) {
                            this.kFL.kFj.release();
                            this.kFL.kFj = null;
                        }
                        this.kFL.kFl = false;
                        ap.vL().bJk();
                    } catch (Exception e6) {
                        e = e6;
                        i = -1;
                        w.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database recovery", new Object[0]);
                        if (bVar2 != null) {
                            bVar2.kZ(i);
                        }
                        com.tencent.mm.plugin.report.service.g.oUh.a(181, 23, 1, true);
                        if (this.kFL.kFj != null) {
                            this.kFL.kFj.release();
                            this.kFL.kFj = null;
                        }
                        if (openDatabase != null) {
                            openDatabase.close();
                        }
                        this.kFL.kFl = false;
                        ap.vL().bJk();
                    }
                } catch (Exception e7) {
                    e = e7;
                    openDatabase = null;
                    i = -1;
                    w.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to start database recovery", new Object[0]);
                    if (bVar2 != null) {
                        bVar2.kZ(i);
                    }
                    com.tencent.mm.plugin.report.service.g.oUh.a(181, 23, 1, true);
                    if (this.kFL.kFj != null) {
                        this.kFL.kFj.release();
                        this.kFL.kFj = null;
                    }
                    if (openDatabase != null) {
                        openDatabase.close();
                    }
                    this.kFL.kFl = false;
                    ap.vL().bJk();
                } catch (Throwable th2) {
                    e = th2;
                    openDatabase = null;
                    if (this.kFL.kFj != null) {
                        this.kFL.kFj.release();
                        this.kFL.kFj = null;
                    }
                    if (openDatabase != null) {
                        openDatabase.close();
                    }
                    this.kFL.kFl = false;
                    ap.vL().bJk();
                    throw e;
                }
            }
        };
        this.kFl = true;
        ap.vL().bJi();
        ap.vL().H(anonymousClass2);
        return 0;
    }

    public final synchronized int b(String str, final b bVar) {
        int i = 0;
        synchronized (this) {
            final com.tencent.mm.u.c yY = ap.yY();
            if (str == null) {
                str = com.tencent.mm.u.c.vn();
            }
            long bJV = bg.bJV();
            File file = str == null ? null : new File(str);
            if (file == null || !file.canRead()) {
                i = -3;
            } else {
                w.i("MicroMsg.SubCoreDBBackup", "[Repair] inFileSize: %d, diskFreeSpace: %d", Long.valueOf(file.length()), Long.valueOf(bJV));
                if (((float) bJV) < ((float) file.length()) * DownloadHelper.SAVE_FATOR) {
                    i = -2;
                } else {
                    Runnable anonymousClass3 = new Runnable(this) {
                        final /* synthetic */ d kFL;
                        final String[] kFO = new String[]{"message", "ImgInfo2", "videoinfo2", "EmojiInfo", "conversation", "rconversation"};

                        public final void run() {
                            SQLiteDatabase openDatabase;
                            Throwable e;
                            SQLiteDatabase sQLiteDatabase;
                            MasterInfo masterInfo;
                            this.kFL.kFk = null;
                            try {
                                com.tencent.mm.u.c.wT();
                                com.tencent.mm.u.c.wW();
                                n.GS();
                                o.KV();
                                byte[] bytes = (p.rA() + com.tencent.mm.u.c.uH()).getBytes();
                                byte[] o = g.o(bytes);
                                byte[] bytes2 = g.n(bytes).substring(0, 7).getBytes();
                                int i = SQLiteDatabase.CREATE_IF_NECESSARY;
                                if (com.tencent.mm.bj.e.bNM()) {
                                    i = 805306368;
                                }
                                openDatabase = SQLiteDatabase.openDatabase(com.tencent.mm.u.c.wO().bNN().getPath(), bytes2, d.kFy, null, i, null, 0);
                                try {
                                    long nanoTime = System.nanoTime();
                                    String[] strArr = new String[2];
                                    strArr[0] = str + ".sm";
                                    StringBuilder stringBuilder = new StringBuilder();
                                    h.vJ();
                                    strArr[1] = stringBuilder.append(h.vI().gYf).append("dbback/EnMicroMsg.db.sm").toString();
                                    int i2 = 0;
                                    MasterInfo masterInfo2 = null;
                                    while (i2 < 2) {
                                        String str = strArr[i2];
                                        try {
                                            masterInfo2 = MasterInfo.load(str, o, this.kFO);
                                            w.i("MicroMsg.SubCoreDBBackup", "Loaded saved master: " + str);
                                            break;
                                        } catch (Exception e2) {
                                            try {
                                                w.e("MicroMsg.SubCoreDBBackup", "Failed to load saved master: " + e2.getMessage());
                                                i2++;
                                            } catch (Exception e3) {
                                                e = e3;
                                                sQLiteDatabase = openDatabase;
                                                masterInfo = masterInfo2;
                                            } catch (Throwable th) {
                                                e = th;
                                                masterInfo = masterInfo2;
                                            }
                                        } catch (Throwable th2) {
                                            e = th2;
                                            masterInfo = masterInfo2;
                                        }
                                    }
                                    if (masterInfo2 == null) {
                                        masterInfo2 = MasterInfo.make(this.kFO);
                                        w.w("MicroMsg.SubCoreDBBackup", "Saved master not available.");
                                        com.tencent.mm.plugin.report.service.g.oUh.a(181, 32, 1, true);
                                    } else if (i2 > 0) {
                                        w.i("MicroMsg.SubCoreDBBackup", "Use backup saved master.");
                                        com.tencent.mm.plugin.report.service.g.oUh.a(181, 33, 1, true);
                                    }
                                    this.kFL.kFk = new RepairKit(str, bytes2, d.kFy, masterInfo2);
                                    boolean output = this.kFL.kFk.output(openDatabase, 1);
                                    int i3 = (this.kFL.kFk.isHeaderCorrupted() && this.kFL.kFk.isDataCorrupted()) ? 0 : 1;
                                    int i4 = output & i3;
                                    openDatabase.close();
                                    sQLiteDatabase = null;
                                    try {
                                        masterInfo2.release();
                                        masterInfo = null;
                                        try {
                                            this.kFL.kFk.release();
                                            this.kFL.kFk = null;
                                            d.akJ();
                                            long nanoTime2 = System.nanoTime() - nanoTime;
                                            String str2 = "MicroMsg.SubCoreDBBackup";
                                            String str3 = "DB repair %s, elapsed %.2f seconds.";
                                            Object[] objArr = new Object[2];
                                            objArr[0] = i4 != 0 ? "succeeded" : "failed";
                                            objArr[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
                                            w.i(str2, str3, objArr);
                                            if (i4 != 0) {
                                                i3 = 26;
                                                if (bVar != null) {
                                                    bVar.kZ(0);
                                                }
                                            } else {
                                                i3 = 27;
                                                if (bVar != null) {
                                                    bVar.kZ(-1);
                                                }
                                                com.tencent.mm.plugin.report.service.g.oUh.d("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
                                            }
                                            com.tencent.mm.plugin.report.service.g.oUh.a(181, (long) i3, 1, true);
                                            if (this.kFL.kFk != null) {
                                                this.kFL.kFk.release();
                                                this.kFL.kFk = null;
                                            }
                                            this.kFL.kFl = false;
                                            ap.vL().bJk();
                                        } catch (Exception e4) {
                                            e = e4;
                                            try {
                                                w.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to repair database '%s'", str);
                                                if (bVar != null) {
                                                    bVar.kZ(-1);
                                                }
                                                com.tencent.mm.plugin.report.service.g.oUh.d("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
                                                com.tencent.mm.plugin.report.service.g.oUh.a(181, 27, 1, true);
                                                if (this.kFL.kFk != null) {
                                                    this.kFL.kFk.release();
                                                    this.kFL.kFk = null;
                                                }
                                                if (sQLiteDatabase != null) {
                                                    sQLiteDatabase.close();
                                                }
                                                if (masterInfo != null) {
                                                    masterInfo.release();
                                                }
                                                this.kFL.kFl = false;
                                                ap.vL().bJk();
                                            } catch (Throwable th3) {
                                                e = th3;
                                                openDatabase = sQLiteDatabase;
                                                if (this.kFL.kFk != null) {
                                                    this.kFL.kFk.release();
                                                    this.kFL.kFk = null;
                                                }
                                                if (openDatabase != null) {
                                                    openDatabase.close();
                                                }
                                                if (masterInfo != null) {
                                                    masterInfo.release();
                                                }
                                                this.kFL.kFl = false;
                                                ap.vL().bJk();
                                                throw e;
                                            }
                                        } catch (Throwable th4) {
                                            e = th4;
                                            openDatabase = null;
                                            if (this.kFL.kFk != null) {
                                                this.kFL.kFk.release();
                                                this.kFL.kFk = null;
                                            }
                                            if (openDatabase != null) {
                                                openDatabase.close();
                                            }
                                            if (masterInfo != null) {
                                                masterInfo.release();
                                            }
                                            this.kFL.kFl = false;
                                            ap.vL().bJk();
                                            throw e;
                                        }
                                    } catch (Exception e5) {
                                        e = e5;
                                        masterInfo = masterInfo2;
                                        w.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to repair database '%s'", str);
                                        if (bVar != null) {
                                            bVar.kZ(-1);
                                        }
                                        com.tencent.mm.plugin.report.service.g.oUh.d("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
                                        com.tencent.mm.plugin.report.service.g.oUh.a(181, 27, 1, true);
                                        if (this.kFL.kFk != null) {
                                            this.kFL.kFk.release();
                                            this.kFL.kFk = null;
                                        }
                                        if (sQLiteDatabase != null) {
                                            sQLiteDatabase.close();
                                        }
                                        if (masterInfo != null) {
                                            masterInfo.release();
                                        }
                                        this.kFL.kFl = false;
                                        ap.vL().bJk();
                                    } catch (Throwable th5) {
                                        e = th5;
                                        openDatabase = null;
                                        masterInfo = masterInfo2;
                                        if (this.kFL.kFk != null) {
                                            this.kFL.kFk.release();
                                            this.kFL.kFk = null;
                                        }
                                        if (openDatabase != null) {
                                            openDatabase.close();
                                        }
                                        if (masterInfo != null) {
                                            masterInfo.release();
                                        }
                                        this.kFL.kFl = false;
                                        ap.vL().bJk();
                                        throw e;
                                    }
                                } catch (Exception e6) {
                                    e = e6;
                                    sQLiteDatabase = openDatabase;
                                    masterInfo = null;
                                    w.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to repair database '%s'", str);
                                    if (bVar != null) {
                                        bVar.kZ(-1);
                                    }
                                    com.tencent.mm.plugin.report.service.g.oUh.d("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
                                    com.tencent.mm.plugin.report.service.g.oUh.a(181, 27, 1, true);
                                    if (this.kFL.kFk != null) {
                                        this.kFL.kFk.release();
                                        this.kFL.kFk = null;
                                    }
                                    if (sQLiteDatabase != null) {
                                        sQLiteDatabase.close();
                                    }
                                    if (masterInfo != null) {
                                        masterInfo.release();
                                    }
                                    this.kFL.kFl = false;
                                    ap.vL().bJk();
                                } catch (Throwable th6) {
                                    e = th6;
                                    masterInfo = null;
                                    if (this.kFL.kFk != null) {
                                        this.kFL.kFk.release();
                                        this.kFL.kFk = null;
                                    }
                                    if (openDatabase != null) {
                                        openDatabase.close();
                                    }
                                    if (masterInfo != null) {
                                        masterInfo.release();
                                    }
                                    this.kFL.kFl = false;
                                    ap.vL().bJk();
                                    throw e;
                                }
                            } catch (Exception e7) {
                                e = e7;
                                sQLiteDatabase = null;
                                masterInfo = null;
                                w.printErrStackTrace("MicroMsg.SubCoreDBBackup", e, "Failed to repair database '%s'", str);
                                if (bVar != null) {
                                    bVar.kZ(-1);
                                }
                                com.tencent.mm.plugin.report.service.g.oUh.d("DBRepair", "Repair failed: " + RepairKit.lastError(), null);
                                com.tencent.mm.plugin.report.service.g.oUh.a(181, 27, 1, true);
                                if (this.kFL.kFk != null) {
                                    this.kFL.kFk.release();
                                    this.kFL.kFk = null;
                                }
                                if (sQLiteDatabase != null) {
                                    sQLiteDatabase.close();
                                }
                                if (masterInfo != null) {
                                    masterInfo.release();
                                }
                                this.kFL.kFl = false;
                                ap.vL().bJk();
                            } catch (Throwable th7) {
                                e = th7;
                                openDatabase = null;
                                masterInfo = null;
                                if (this.kFL.kFk != null) {
                                    this.kFL.kFk.release();
                                    this.kFL.kFk = null;
                                }
                                if (openDatabase != null) {
                                    openDatabase.close();
                                }
                                if (masterInfo != null) {
                                    masterInfo.release();
                                }
                                this.kFL.kFl = false;
                                ap.vL().bJk();
                                throw e;
                            }
                        }
                    };
                    this.kFl = true;
                    ap.vL().bJi();
                    ap.vL().H(anonymousClass3);
                }
            }
        }
        return i;
    }

    public final int a(final b bVar) {
        ap.yY();
        final File file = new File(com.tencent.mm.u.c.vn());
        if (!file.canRead()) {
            return -3;
        }
        StringBuilder append = new StringBuilder().append(p.rA());
        ap.yY();
        final String substring = g.n(append.append(com.tencent.mm.u.c.uH()).toString().getBytes()).substring(0, 7);
        w.i("MicroMsg.SubCoreDBBackup", "db recover needSize : %d blockSize:%d", Long.valueOf(file.length() * 2), Long.valueOf(bg.bJV()));
        if (bg.bJV() < file.length() * 2) {
            return -2;
        }
        ap.vL().bJi();
        ap.vL().H(new Runnable(this) {
            final /* synthetic */ d kFL;

            public final void run() {
                int i;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                }
                ap.yY();
                String xu = com.tencent.mm.u.c.xu();
                String str = xu + file.getName().replace(".db", "temp.db");
                w.i("MicroMsg.SubCoreDBBackup", "temp db path is %s", str);
                file.renameTo(new File(str));
                String str2 = xu + "sqlTemp.sql";
                List asList = Arrays.asList(new String[]{"getcontactinfo", "contact", "contact_ext", "ContactCmdBuf", "rcontact", "img_flag", "userinfo"});
                final int[] iArr = new int[1];
                long currentTimeMillis = System.currentTimeMillis();
                ap.yY();
                boolean a = com.tencent.mm.u.c.wO().a(str, substring, str2, asList, new ExecuteSqlCallback(this) {
                    final /* synthetic */ AnonymousClass4 kFS;

                    public final String preExecute(String str) {
                        int[] iArr = iArr;
                        iArr[0] = iArr[0] + 1;
                        return null;
                    }
                });
                if (a) {
                    ap.yY();
                    com.tencent.mm.u.c.wT().aKa();
                    ap.yY();
                    com.tencent.mm.u.c.wW().bLF();
                    ap.yY();
                    com.tencent.mm.u.c.wT().aKc();
                    ap.yY();
                    com.tencent.mm.u.c.wT().aKb();
                    i = 12;
                } else {
                    i = 15;
                }
                com.tencent.mm.plugin.report.service.g.oUh.a(181, (long) i, 1, true);
                w.i("MicroMsg.SubCoreDBBackup", "execute %d sql and last %d", Integer.valueOf(iArr[0]), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                Object[] objArr = new Object[3];
                objArr[0] = Integer.valueOf(a ? 1 : 0);
                objArr[1] = iArr;
                objArr[2] = Long.valueOf(r2);
                gVar.i(11224, objArr);
                ap.vL().bJk();
                if (bVar != null) {
                    bVar.kZ(a ? 0 : -1);
                }
            }
        });
        return 0;
    }

    public final void b(final b bVar) {
        final File file = new File(ab.getContext().getFilesDir(), "DBRecoverStarted");
        final WakerLock wakerLock = new WakerLock(ab.getContext());
        b anonymousClass5 = new b(this) {
            final /* synthetic */ d kFL;
            int kFT = 0;

            public final void kZ(int i) {
                while (true) {
                    if (this.kFT > 0) {
                        w.i("MicroMsg.SubCoreDBBackup", "Recovery stage %d result: %d", Integer.valueOf(this.kFT), Integer.valueOf(i));
                    }
                    if (i == 0) {
                        file.delete();
                        com.tencent.mm.plugin.report.service.g.oUh.a(181, 29, 1, true);
                        if (bVar != null) {
                            bVar.kZ(i);
                        }
                        wakerLock.unLock();
                        return;
                    } else if (i == -2) {
                        file.delete();
                        com.tencent.mm.plugin.report.service.g.oUh.a(181, 3, 1, true);
                        if (bVar != null) {
                            bVar.kZ(i);
                        }
                        wakerLock.unLock();
                        return;
                    } else {
                        int i2 = this.kFT + 1;
                        this.kFT = i2;
                        switch (i2) {
                            case 1:
                                w.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: REPAIR", Integer.valueOf(this.kFT));
                                i = this.kFL.b(null, this);
                                break;
                            case 2:
                                w.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: BACKUP RECOVER", Integer.valueOf(this.kFT));
                                i = this.kFL.a(null, (b) this);
                                break;
                            case 3:
                                w.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: DUMP", Integer.valueOf(this.kFT));
                                i = this.kFL.a(this);
                                break;
                            default:
                                file.delete();
                                com.tencent.mm.plugin.report.service.g.oUh.a(181, 30, 1, true);
                                if (bVar != null) {
                                    bVar.kZ(i);
                                }
                                wakerLock.unLock();
                                return;
                        }
                        if (i == 0) {
                            return;
                        }
                    }
                }
            }
        };
        w.i("MicroMsg.SubCoreDBBackup", "Database recover started.");
        wakerLock.lock();
        com.tencent.mm.plugin.report.service.g.oUh.a(181, 28, 1, true);
        try {
            file.createNewFile();
        } catch (IOException e) {
        }
        anonymousClass5.kZ(-1);
    }

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        String readLine;
        boolean z2;
        String str = h.vI().cachePath + "account.lck";
        this.kFu = str;
        BufferedReader bufferedReader;
        try {
            this.kFv = new FLock(str);
            if (this.kFv.bID()) {
                FileWriter fileWriter = new FileWriter(str);
                fileWriter.write(Integer.toString(Process.myPid()));
                fileWriter.close();
                w.i("MicroMsg.DuplicateDetect", "No account multiple instances detected.");
            } else {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(str));
                int PY = bg.PY(bufferedReader2.readLine());
                bufferedReader2.close();
                if (!(PY == 0 || PY == Process.myPid())) {
                    File file = new File("/proc/" + PY + "/status");
                    if (file.isFile() && file.canRead()) {
                        bufferedReader = new BufferedReader(new FileReader(file));
                        do {
                            readLine = bufferedReader.readLine();
                            if (readLine != null) {
                            }
                            break;
                        } while (!readLine.startsWith("State:"));
                        String[] split = readLine.split(": \\t");
                        if (split.length > 1 && (split[1].equals("S") || split[1].equals("R"))) {
                            throw new a("Multiple instances of WeChat with same account detected. Last PID: " + PY);
                        }
                        bufferedReader.close();
                    }
                }
                w.i("MicroMsg.DuplicateDetect", "Account reentrant within same process detected.");
            }
        } catch (a e) {
            throw e;
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.DuplicateDetect", e2, "Failed to initialize lock file: " + str, new Object[0]);
            this.kFv.unlock();
            this.kFv = null;
            new File(this.kFu).delete();
            this.kFu = null;
        } catch (Throwable th) {
            bufferedReader.close();
        }
        ap.yY();
        t vr = com.tencent.mm.u.c.vr();
        SQLiteDatabase bNN = com.tencent.mm.u.c.wO().bNN();
        this.kFq = vr.yB(237569);
        this.kFr = vr.getInt(237570, 10);
        if (vr.getInt(237571, 0) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.kFs = z2;
        Context context = ab.getContext();
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
            if (intExtra == 2 || intExtra == 5) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.hLL = z2;
        } else {
            this.hLL = false;
        }
        this.hLM = ((PowerManager) context.getSystemService("power")).isScreenOn();
        this.kFw = new com.tencent.mm.sdk.e.j.a(this) {
            final /* synthetic */ d kFL;

            {
                this.kFL = r1;
            }

            public final void a(String str, l lVar) {
                if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                    d.akI();
                }
            }
        };
        com.tencent.mm.u.c.c.Az().c(this.kFw);
        akI();
        this.kFx = new c<lc>(this) {
            final /* synthetic */ d kFL;

            {
                this.kFL = r2;
                this.usg = lc.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                com.tencent.mm.i.e sV = com.tencent.mm.i.g.sV();
                if (com.tencent.mm.sdk.a.b.bIu()) {
                    this.kFL.kFn = true;
                    this.kFL.kFo = Long.MAX_VALUE;
                } else {
                    int i = sV.getInt("AndroidDBBackupPercentage", 0);
                    ap.yY();
                    this.kFL.kFn = com.tencent.mm.a.h.aw(com.tencent.mm.u.c.uH(), 100) < i;
                    this.kFL.kFo = (long) sV.getInt("AndroidDBBackupMaxDBSizeMB", 0);
                    this.kFL.kFo *= 1048576;
                }
                this.kFL.kFp = (long) sV.getInt("AndroidDBBackupWaitSeconds", 600);
                this.kFL.kFp *= 1000;
                String str = "MicroMsg.SubCoreDBBackup";
                String str2 = "Auto backup enabled: %b, max size: %s, debugger: %b";
                Object[] objArr = new Object[3];
                objArr[0] = Boolean.valueOf(this.kFL.kFn);
                objArr[1] = this.kFL.kFo == Long.MAX_VALUE ? "not limited" : Long.valueOf(this.kFL.kFo);
                objArr[2] = Boolean.valueOf(com.tencent.mm.sdk.a.b.bIu());
                w.d(str, str2, objArr);
                return true;
            }
        };
        com.tencent.mm.sdk.b.a.urY.b(this.kFx);
        this.hLK = new BroadcastReceiver(this) {
            final /* synthetic */ d kFL;

            {
                this.kFL = r1;
            }

            public final void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                boolean z = true;
                switch (action.hashCode()) {
                    case -2128145023:
                        if (action.equals("android.intent.action.SCREEN_OFF")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1886648615:
                        if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1538406691:
                        if (action.equals("android.intent.action.BATTERY_CHANGED")) {
                            z = false;
                            break;
                        }
                        break;
                    case -1454123155:
                        if (action.equals("android.intent.action.SCREEN_ON")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1019184907:
                        if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        Parcel obtain = Parcel.obtain();
                        intent.getExtras().writeToParcel(obtain, 0);
                        FileOp.k(ab.getContext().getFilesDir().getAbsolutePath() + "/battery.bin", obtain.marshall());
                        obtain.recycle();
                        return;
                    case true:
                        this.kFL.hLM = true;
                        break;
                    case true:
                        this.kFL.hLM = false;
                        break;
                    case true:
                        this.kFL.hLL = true;
                        break;
                    case true:
                        this.kFL.hLL = false;
                        break;
                }
                w.v("MicroMsg.SubCoreDBBackup", "Action received: %s, interactive: %s, charging: %s", action, Boolean.valueOf(this.kFL.hLM), Boolean.valueOf(this.kFL.hLL));
                if (this.kFL.kFn && this.kFL.hLO == null && this.kFL.hLL && !this.kFL.hLM) {
                    if (System.currentTimeMillis() - this.kFL.kFq < 86400000) {
                        w.d("MicroMsg.SubCoreDBBackup", "Last backup time not matched.");
                        return;
                    }
                    z = this.kFL.kFr < 10;
                    final b anonymousClass1 = new b(this) {
                        final /* synthetic */ AnonymousClass9 kFX;

                        public final void kZ(int i) {
                            this.kFX.kFL.kFm = false;
                            ap.yY();
                            t vr = com.tencent.mm.u.c.vr();
                            this.kFX.kFL.kFq = System.currentTimeMillis();
                            if (i == 0) {
                                vr.setLong(237569, this.kFX.kFL.kFq);
                                if (z) {
                                    d dVar = this.kFX.kFL;
                                    dVar.kFr++;
                                } else {
                                    this.kFX.kFL.kFr = 0;
                                }
                                vr.setInt(237570, this.kFX.kFL.kFr);
                            } else if (i != 1) {
                                vr.setLong(237569, this.kFX.kFL.kFq);
                                if (z) {
                                    this.kFX.kFL.kFr = 10;
                                    vr.setInt(237570, this.kFX.kFL.kFr);
                                }
                            } else {
                                return;
                            }
                            vr.jY(false);
                        }
                    };
                    this.kFL.hLO = new Runnable(this) {
                        final /* synthetic */ AnonymousClass9 kFX;

                        public final void run() {
                            this.kFX.kFL.hLO = null;
                            ap.yY();
                            long length = new File(com.tencent.mm.u.c.vp()).length();
                            long bJV = bg.bJV();
                            if (length == 0) {
                                w.i("MicroMsg.SubCoreDBBackup", "Invalid database size, backup canceled.");
                            } else if (length > this.kFX.kFL.kFo || length > bJV) {
                                w.i("MicroMsg.SubCoreDBBackup", "Not enough disk space, backup canceled.");
                                com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.oUh;
                                Object[] objArr = new Object[2];
                                objArr[0] = Integer.valueOf(10008);
                                objArr[1] = String.format("%d|%d", new Object[]{Long.valueOf(length), Long.valueOf(bJV)});
                                gVar.i(11098, objArr);
                            } else {
                                this.kFX.kFL.kFm = this.kFX.kFL.a(z, anonymousClass1);
                                if (this.kFX.kFL.kFm) {
                                    w.i("MicroMsg.SubCoreDBBackup", "Auto database backup started.");
                                }
                            }
                        }
                    };
                    ap.vL().e(this.kFL.hLO, this.kFL.kFp);
                    w.i("MicroMsg.SubCoreDBBackup", "Auto database backup scheduled.");
                    com.tencent.mm.plugin.report.service.g.oUh.i(11098, Integer.valueOf(10009), this.kFL.kFt.format(new Date()));
                } else if (this.kFL.hLO != null) {
                    ap.vL().bJl().removeCallbacks(this.kFL.hLO);
                    this.kFL.hLO = null;
                    w.i("MicroMsg.SubCoreDBBackup", "Auto database backup canceled.");
                    com.tencent.mm.plugin.report.service.g.oUh.i(11098, Integer.valueOf(10010), this.kFL.kFt.format(new Date()));
                } else if (this.kFL.kFm) {
                    this.kFL.akH();
                    this.kFL.kFm = false;
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        context.registerReceiver(this.hLK, intentFilter);
        com.tencent.mm.pluginsdk.b.b.a(new c(this), "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb");
        String str2 = "MicroMsg.SubCoreDBBackup";
        String str3 = "Auto database backup %s. Device status:%s interactive,%s charging.";
        Object[] objArr = new Object[3];
        objArr[0] = this.kFn ? "enabled" : "disabled";
        objArr[1] = this.hLM ? "" : " not";
        objArr[2] = this.hLL ? "" : " not";
        w.i(str2, str3, objArr);
        readLine = bNN.getPath() + ".sm";
        str2 = readLine + ".tmp";
        File file2 = new File(readLine);
        if (!file2.isFile()) {
            long nanoTime = System.nanoTime();
            StringBuilder append = new StringBuilder().append(p.rA());
            ap.yY();
            z2 = MasterInfo.save(bNN, str2, g.o(append.append(com.tencent.mm.u.c.uH()).toString().getBytes()));
            File file3 = new File(str2);
            if (z2) {
                file2.delete();
                z2 = file3.renameTo(file2);
            } else {
                file3.delete();
            }
            long nanoTime2 = System.nanoTime() - nanoTime;
            str2 = "MicroMsg.SubCoreDBBackup";
            String str4 = "Master table backup %s, elapsed %.3f";
            Object[] objArr2 = new Object[2];
            objArr2[0] = z2 ? "SUCCEEDED" : "FAILED";
            objArr2[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
            w.i(str2, str4, objArr2);
            com.tencent.mm.plugin.report.service.g.oUh.a(181, z2 ? 24 : 25, 1, false);
        }
        readLine = com.tencent.mm.u.c.xu();
        ap.vL().e(new Runnable(this) {
            final /* synthetic */ d kFL;

            public final void run() {
                if (!FileOp.aO((readLine + "corrupted/EnMicroMsg.db") + ".corrupt")) {
                    long currentTimeMillis = System.currentTimeMillis();
                    File file = new File(readLine + "corrupted");
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        int length = listFiles.length;
                        int i = 0;
                        while (i < length) {
                            if (currentTimeMillis - listFiles[i].lastModified() >= 7776000000L) {
                                i++;
                            } else {
                                return;
                            }
                        }
                        if (FileOp.y(file.getPath(), false)) {
                            w.i("MicroMsg.SubCoreDBBackup", "Corrupted databases removed.");
                        }
                    }
                }
            }
        }, 60000);
    }

    public final void aN(boolean z) {
    }

    public final void onAccountRelease() {
        akH();
        this.kFm = false;
        if (this.hLO != null) {
            ap.vL().bJl().removeCallbacks(this.hLO);
            this.hLO = null;
        }
        if (this.kFx != null) {
            com.tencent.mm.sdk.b.a.urY.c(this.kFx);
            this.kFx = null;
        }
        if (this.hLK != null) {
            ab.getContext().unregisterReceiver(this.hLK);
            this.hLK = null;
        }
        com.tencent.mm.pluginsdk.b.b.B("//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb");
        if (this.kFv != null && this.kFu != null && this.kFu.length() > 0) {
            this.kFv.unlock();
            this.kFv = null;
            new File(this.kFu).delete();
            this.kFu = null;
            w.i("MicroMsg.DuplicateDetect", "Instance exited.");
        }
    }

    public static void akI() {
        com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100274");
        if (dX.isValid()) {
            Map bKK = dX.bKK();
            Map hashMap = new HashMap();
            hashMap.put("wal", Integer.valueOf(bg.getInt((String) bKK.get("wal"), 0)));
            hashMap.put("alter_cursor", Integer.valueOf(bg.getInt((String) bKK.get("alter_cursor"), 0)));
            com.tencent.mm.bj.e.ah(hashMap);
        }
    }

    static void akJ() {
        com.tencent.mm.plugin.messenger.foundation.a.a.c wT = com.tencent.mm.u.c.wT();
        wT.aKa();
        wT.aKc();
        wT.aKb();
        com.tencent.mm.u.c.wW().bLF();
        n.GS().GD();
        t vr = com.tencent.mm.u.c.vr();
        vr.a(com.tencent.mm.storage.w.a.USERINFO_EMOJI_NEW_EMOJI_INT, Integer.valueOf(0));
        vr.a(com.tencent.mm.storage.w.a.USERINFO_EMOJI_NEW_PANEL_INT, Integer.valueOf(0));
        vr.a(com.tencent.mm.storage.w.a.USERINFO_EMOJI_NEW_SUGGEST_INT, Integer.valueOf(0));
    }
}
