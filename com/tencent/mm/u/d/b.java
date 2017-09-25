package com.tencent.mm.u.d;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Process;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.util.Base64;
import com.tencent.mm.a.o;
import com.tencent.mm.ap.m;
import com.tencent.mm.ap.t;
import com.tencent.mm.bj.g;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public final class b implements a {
    private static final String fwJ;
    private static final String fwK;
    public static List<String> hpF = Arrays.asList(new String[]{"FTS5IndexMicroMsg.db"});
    private static b hpv;
    public static final String hpw = (e.hgs + "/tencent/MicroMsg/SQLTrace/");
    public long[] fwN = new long[]{0, 0, 0};
    private SharedPreferences hgx = ab.bIY();
    public long hpA;
    public long hpB;
    public long hpC;
    public long hpD;
    private long hpE;
    public long hpb = 0;
    public volatile boolean hpc = false;
    public long hpx;
    public long hpy;
    public long hpz;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ b hpG;
        final /* synthetic */ String hpH;

        public AnonymousClass3(b bVar, String str) {
            this.hpG = bVar;
            this.hpH = str;
        }

        public final void run() {
            RandomAccessFile randomAccessFile;
            Throwable e;
            b bVar = this.hpG;
            String str = b.hpw + "MMSQL.trace";
            String str2 = this.hpH + "\n";
            if (f.rZ()) {
                File file;
                try {
                    file = new File(b.hpw);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    bVar.a(new File(b.hpw, "MMSQL.trace"), false);
                } catch (Exception e2) {
                    w.e("MicroMsg.SQLTraceManager", "init dir fail");
                }
                file = new File(str);
                if (file.length() > bVar.hpB) {
                    w.e("MicroMsg.SQLTraceManager", "log file invaild foramt,recreate");
                    bVar.a(file, true);
                }
                try {
                    randomAccessFile = new RandomAccessFile(str, "rw");
                    try {
                        randomAccessFile.seek(randomAccessFile.length());
                        randomAccessFile.write(com.tencent.mm.bl.e.bp(str2.getBytes()));
                        try {
                            randomAccessFile.close();
                        } catch (Throwable e3) {
                            w.printErrStackTrace("MicroMsg.SQLTraceManager", e3, "appendToFile fail with exception", new Object[0]);
                        }
                    } catch (IOException e4) {
                        e3 = e4;
                        try {
                            w.printErrStackTrace("MicroMsg.SQLTraceManager", e3, "appendToFile fail with exception", new Object[0]);
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Throwable e32) {
                                    w.printErrStackTrace("MicroMsg.SQLTraceManager", e32, "appendToFile fail with exception", new Object[0]);
                                }
                            }
                            bVar.i(new File(b.hpw + "MMSQL.trace"));
                            return;
                        } catch (Throwable th) {
                            e32 = th;
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Throwable e5) {
                                    w.printErrStackTrace("MicroMsg.SQLTraceManager", e5, "appendToFile fail with exception", new Object[0]);
                                }
                            }
                            throw e32;
                        }
                    }
                } catch (IOException e6) {
                    e32 = e6;
                    randomAccessFile = null;
                    w.printErrStackTrace("MicroMsg.SQLTraceManager", e32, "appendToFile fail with exception", new Object[0]);
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    bVar.i(new File(b.hpw + "MMSQL.trace"));
                    return;
                } catch (Throwable th2) {
                    e32 = th2;
                    randomAccessFile = null;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    throw e32;
                }
                bVar.i(new File(b.hpw + "MMSQL.trace"));
                return;
            }
            w.i("MicroMsg.SQLTraceManager", "sdcard is not  Available,appendToFile fail ");
        }
    }

    static {
        String rB = p.rB();
        fwJ = rB;
        fwK = o.getString(rB.hashCode());
    }

    public static b AG() {
        if (hpv == null) {
            hpv = new b();
        }
        return hpv;
    }

    public b() {
        AH();
    }

    private void AH() {
        this.hpx = this.hgx.getLong("sql_trace_main_thread_select_interval_time", 300);
        this.hpy = this.hgx.getLong("sql_trace_main_thread_update_interval_time", 500);
        this.hpz = this.hgx.getLong("sql_trace_child_thread_interval_time", 1500);
        long aQ = aQ(ab.getContext());
        if (aQ > 0) {
            this.hpx += aQ;
            this.hpy += aQ;
            this.hpz += aQ;
            w.i("MicroMsg.SQLTraceManager", "auto adapte Time %d", Long.valueOf(aQ));
        }
        this.hpA = this.hgx.getLong("sql_trace_child_transaction_interval_time", 5000);
        this.hpE = this.hgx.getLong("sql_trace_file_full_size", 30720);
        this.hpB = this.hgx.getLong("sql_trace_log_file_max_size", 35840);
        this.hpC = this.hgx.getLong("sql_trace_upload_file_min_size", 10240);
        this.hpD = this.hgx.getLong("sql_upload_time_interval", 21600000);
        i(new File(hpw, "MMSQL.trace"));
        w.i("MicroMsg.SQLTraceManager", "update arg %d %d %d %d %d %d %d %d", Long.valueOf(this.hpx), Long.valueOf(this.hpy), Long.valueOf(this.hpz), Long.valueOf(this.hpA), Long.valueOf(this.hpE), Long.valueOf(this.hpB), Long.valueOf(this.hpC), Long.valueOf(this.hpD));
    }

    public static void setup() {
        if (ab.usY) {
            w.i("MicroMsg.SQLTraceManager", "trace setup delete old file ret: " + com.tencent.mm.loader.stub.b.deleteFile(hpw + "MMSQL.trace"));
        }
    }

    void i(File file) {
        boolean z = true;
        if (file.exists()) {
            this.hpc = file.length() > this.hpE;
            if (this.hpc) {
                long aP = aP(ab.getContext());
                String str = "MicroMsg.SQLTraceManager";
                String str2 = "has mark lastFullTime %b";
                Object[] objArr = new Object[1];
                if (aP == 0) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                w.i(str, str2, objArr);
                if (aP == 0) {
                    d(ab.getContext(), System.currentTimeMillis());
                    return;
                }
                return;
            }
            return;
        }
        this.hpc = false;
    }

    public static String gF(String str) {
        FileInputStream fileInputStream;
        Throwable e;
        FileInputStream fileInputStream2;
        try {
            fileInputStream2 = new FileInputStream(new File(str));
            try {
                byte[] bArr = new byte[fileInputStream2.available()];
                fileInputStream2.read(bArr);
                String str2 = new String(com.tencent.mm.bl.e.bp(bArr));
                try {
                    fileInputStream2.close();
                    return str2;
                } catch (Throwable e2) {
                    w.printErrStackTrace("MicroMsg.SQLTraceManager", e2, "", new Object[0]);
                    return str2;
                }
            } catch (IOException e3) {
                fileInputStream = fileInputStream2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e4) {
                        w.printErrStackTrace("MicroMsg.SQLTraceManager", e4, "", new Object[0]);
                    }
                }
                return null;
            } catch (Throwable th) {
                e4 = th;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Throwable e22) {
                        w.printErrStackTrace("MicroMsg.SQLTraceManager", e22, "", new Object[0]);
                    }
                }
                throw e4;
            }
        } catch (IOException e5) {
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return null;
        } catch (Throwable th2) {
            e4 = th2;
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw e4;
        }
    }

    private static long a(String str, g gVar) {
        Cursor a = gVar.a("select count(*) from " + str, null, 2);
        long j = 0;
        if (a.moveToFirst()) {
            j = a.getLong(0);
        }
        a.close();
        return j;
    }

    private String AD() {
        String format;
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        printStream.println("#client.version=" + d.sYN);
        printStream.println("#accinfo.revision=" + com.tencent.mm.sdk.platformtools.e.REV);
        printStream.println("#accinfo.uin=" + ao.hlW.A("last_login_uin", fwK));
        printStream.println("#accinfo.dev=" + fwJ);
        printStream.println("#accinfo.build=" + com.tencent.mm.sdk.platformtools.e.TIME + ":" + com.tencent.mm.sdk.platformtools.e.HOSTNAME + ":" + com.tencent.mm.sdk.platformtools.f.fuV);
        String str = "";
        try {
            StatFs statFs = new StatFs(h.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(e.hgs);
            format = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(((ActivityManager) ab.getContext().getSystemService("activity")).getMemoryClass()), r4.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), e.hgs, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
        } catch (Exception e) {
            w.e("MicroMsg.SQLTraceManager", "check data size failed :%s", e.getMessage());
            format = str;
        }
        printStream.println("#accinfo.data=" + format);
        Date date = new Date();
        printStream.println("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date));
        long aQ = aQ(ab.getContext());
        if (aQ > 0) {
            printStream.println("#logfile.autoAdapteTime :" + aQ);
        }
        if (aP(ab.getContext()) != 0) {
            long aP = aP(ab.getContext()) - aO(ab.getContext());
            printStream.println("#logfile.fulllast :" + aP);
            if (aP > 0 && aP < 28800000) {
                PreferenceManager.getDefaultSharedPreferences(ab.getContext()).edit().putLong("sql_trace_log_autoAdaptaTime", aQ + 100).commit();
                w.i("MicroMsg.SQLTraceManager", "auto Adapte Time to %d", Long.valueOf(aQ));
                AH();
            }
        } else {
            printStream.println("#logfile.fullTimelast :" + (System.currentTimeMillis() - aO(ab.getContext())));
        }
        m[] gl = t.Ic().gl(21);
        if (gl == null || gl.length == 0 || gl[0] == null) {
            printStream.println("#traceconfig hardcode");
        } else {
            printStream.println("#traceconfig id=" + gl[0].id + " version=" + gl[0].version);
        }
        if (this.fwN[1] != -1) {
            printStream.println("#wxpackage :cache size=" + this.fwN[0] + " data size= " + this.fwN[1] + " code size =" + this.fwN[2]);
        }
        StringBuilder stringBuilder = new StringBuilder("#dbsize : EnMicroMsg.db size=");
        ap.yY();
        printStream.println(stringBuilder.append(new File(c.vp()).length()).toString());
        stringBuilder = new StringBuilder("#dbsize : SnsMicroMsg.db size=");
        StringBuilder stringBuilder2 = new StringBuilder();
        ap.yY();
        printStream.println(stringBuilder.append(new File(stringBuilder2.append(c.xu()).append("SnsMicroMsg.db").toString()).length()).toString());
        ap.yY();
        a(c.wP(), printStream, Arrays.asList(new String[]{"message", "rconversation", "rcontact", "ImgInfo2", "BizInfo", "img_flag", "fmessage_conversation", "AppInfo", "AppMessage", "EmojiInfo", "EmojiGroupInfo", "bottleconversation", "bottlemessage", "chatroom", "rbottleconversation", "userinfo"}));
        printStream.println("#sql.content:");
        format = byteArrayOutputStream.toString();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
        }
        return format;
    }

    private static void a(g gVar, PrintStream printStream, List<String> list) {
        if (gVar == null || !gVar.isOpen()) {
            w.i("MicroMsg.SQLTraceManager", "db is not open!");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (list == null || list.size() <= 0) {
            Cursor a = gVar.a("select name from sqlite_master where type='table' ", null, 2);
            while (a.moveToNext()) {
                String string = a.getString(0);
                printStream.println("#table : " + string + " count=" + a(string, gVar));
            }
            a.close();
        } else {
            for (String str : list) {
                printStream.println("#table : " + str + " count=" + a(str, gVar));
            }
        }
        w.i("MicroMsg.SQLTraceManager", "dump all table count last %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public static void a(String str, String str2, StringBuilder stringBuilder) {
        stringBuilder.append(str).append(":").append(str2).append(" ");
    }

    public final void gG(String str) {
        if (str == null) {
            str = "";
        }
        Intent intent = new Intent();
        intent.setClassName(ab.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
        intent.setAction("uncatch_exception");
        intent.putExtra("exceptionPid", Process.myPid());
        String str2 = "userName";
        String A = ao.hlW.A("login_weixin_username", "");
        if (bg.mA(A)) {
            A = ao.hlW.A("login_user_name", "never_login_crash");
        }
        intent.putExtra(str2, A);
        intent.putExtra("tag", "SqlTrace");
        intent.putExtra("exceptionMsg", Base64.encodeToString((AD() + str).getBytes(), 2));
        ab.getContext().startService(intent);
    }

    public final void a(File file, boolean z) {
        w.i("MicroMsg.SQLTraceManager", "build log file ,needRecreate %b", Boolean.valueOf(z));
        if (file.exists()) {
            if (z) {
                file.delete();
            }
            i(file);
        }
        try {
            file.createNewFile();
            Context context = ab.getContext();
            PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_trace_log_file_create_time", System.currentTimeMillis()).commit();
            d(ab.getContext(), 0);
        } catch (IOException e) {
            w.e("MicroMsg.SQLTraceManager", "recreate log file fail");
        }
        i(file);
    }

    public static void c(Context context, long j) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_report_lastUploadTime", j).commit();
    }

    public static long aN(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_report_lastUploadTime", 0);
    }

    private static long aO(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_file_create_time", 0);
    }

    private static void d(Context context, long j) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putLong("sql_trace_log_file_full_time", j).commit();
    }

    private static long aP(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_file_full_time", 0);
    }

    private static long aQ(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getLong("sql_trace_log_autoAdaptaTime", 0);
    }

    public final void AE() {
        w.i("MicroMsg.SQLTraceManager", "updateIntervalArg ");
        AH();
    }
}
