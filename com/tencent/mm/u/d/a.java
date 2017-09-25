package com.tencent.mm.u.d;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.StatFs;
import com.tencent.mm.a.o;
import com.tencent.mm.ap.m;
import com.tencent.mm.ap.t;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ao;
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
import java.util.LinkedList;
import java.util.Locale;

public class a implements a {
    private static final String fwJ;
    private static final String fwK;
    public static String fwL = "";
    private static a hoY;
    static final String hoZ = (e.hgs + "/tencent/MicroMsg/Handler/");
    public static final String hpa = (hoZ + "Handler.trace");
    public static final long hpd = Looper.getMainLooper().getThread().getId();
    public static SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ");
    public long[] fwN;
    public SharedPreferences hgx;
    public long hpb;
    public volatile boolean hpc;
    public long hpe;
    public long hpf;
    private long hpg;
    public long hph;
    public long hpi;
    private long hpj;
    public long hpk;
    public int hpl;
    public int hpm;
    public int hpn;
    public Long[] hpo;
    public long hpp;
    private String hpq;
    public LinkedList<a> hpr;

    class AnonymousClass3 implements Runnable {
        final /* synthetic */ a hps;
        final /* synthetic */ String hpt;

        AnonymousClass3(a aVar, String str) {
            this.hps = aVar;
            this.hpt = str;
        }

        public final void run() {
            Throwable e;
            a aVar = this.hps;
            String str = a.hpa;
            String str2 = this.hpt;
            if (f.rZ()) {
                File file;
                try {
                    file = new File(a.hoZ);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    aVar.a(new File(a.hoZ, "Handler.trace"), false);
                } catch (Exception e2) {
                }
                file = new File(str);
                if (file.length() > aVar.hph) {
                    w.e("MicroMsg.HandlerTraceManager", "summer log file invaild foramt, recreate");
                    aVar.a(file, true);
                }
                RandomAccessFile randomAccessFile;
                try {
                    randomAccessFile = new RandomAccessFile(str, "rw");
                    try {
                        randomAccessFile.seek(randomAccessFile.length());
                        randomAccessFile.write(com.tencent.mm.bl.e.bp(str2.getBytes()));
                        try {
                            randomAccessFile.close();
                        } catch (Exception e3) {
                        }
                    } catch (IOException e4) {
                        e = e4;
                        try {
                            w.printErrStackTrace("MicroMsg.HandlerTraceManager", e, "summer appendToFile fail with exception", new Object[0]);
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Exception e5) {
                                }
                            }
                            aVar.i(new File(a.hpa));
                            return;
                        } catch (Throwable th) {
                            e = th;
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Exception e6) {
                                }
                            }
                            throw e;
                        }
                    }
                } catch (IOException e7) {
                    e = e7;
                    randomAccessFile = null;
                    w.printErrStackTrace("MicroMsg.HandlerTraceManager", e, "summer appendToFile fail with exception", new Object[0]);
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    aVar.i(new File(a.hpa));
                    return;
                } catch (Throwable th2) {
                    e = th2;
                    randomAccessFile = null;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    throw e;
                }
                aVar.i(new File(a.hpa));
                return;
            }
            w.i("MicroMsg.HandlerTraceManager", "summer sdcard is not Available, appendToFile fail ");
        }

        public final String toString() {
            return super.toString() + "|mark";
        }
    }

    static class a implements Comparable<a> {
        long hpu;
        String info;

        a() {
        }

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return (int) (((a) obj).hpu - this.hpu);
        }
    }

    static {
        String rB = p.rB();
        fwJ = rB;
        fwK = o.getString(rB.hashCode());
    }

    private a() {
        this.fwN = new long[]{0, 0, 0};
        this.hpb = 0;
        this.hpc = false;
        this.hpe = 8000;
        this.hpf = 800;
        this.hpg = 25600;
        this.hph = 35840;
        this.hpi = 86400000;
        this.hpj = 180000;
        this.hpk = 5000;
        this.hpl = 120;
        this.hpm = 50;
        this.hpn = 1800000;
        this.hgx = ab.bIY();
        this.hpo = new Long[18];
        this.hpp = 0;
        this.hpq = "";
        this.hpr = new LinkedList();
        this.hpe = this.hgx.getLong("handler_debug_log_time", 8000);
        this.hpf = this.hgx.getLong("handler_debug_log_time_main", 800);
        this.hpg = this.hgx.getLong("handler_trace_file_full_size", 25600);
        this.hph = this.hgx.getLong("handler_log_file_max_size", 35840);
        this.hpi = this.hgx.getLong("handler_upload_time_interval", 86400000);
        Arrays.fill(this.hpo, Long.valueOf(0));
    }

    public static a AC() {
        if (hoY == null) {
            synchronized (a.class) {
                if (hoY == null) {
                    hoY = new a();
                }
            }
        }
        return hoY;
    }

    void i(File file) {
        boolean z = true;
        if (file.exists()) {
            this.hpc = file.length() > this.hpg;
            if (this.hpc) {
                long j = this.hgx.getLong("handler_trace_log_file_full_time", 0);
                String str = "MicroMsg.HandlerTraceManager";
                String str2 = "has mark lastFullTime %b";
                Object[] objArr = new Object[1];
                if (j == 0) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                w.i(str, str2, objArr);
                if (j == 0) {
                    this.hgx.edit().putLong("handler_trace_log_file_full_time", System.currentTimeMillis()).commit();
                    return;
                }
                return;
            }
            return;
        }
        this.hpc = false;
    }

    final String AD() {
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
            w.e("MicroMsg.HandlerTraceManager", "summer check data size failed :%s", e.getMessage());
            format = str;
        }
        printStream.println("#accinfo.data=" + format);
        Date date = new Date();
        printStream.println("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date));
        printStream.println("#logfile.fulllast :" + (this.hgx.getLong("handler_trace_log_file_full_time", 0) - this.hgx.getLong("handler_trace_log_file_create_time", 0)));
        if (this.fwN[1] != -1) {
            printStream.println("#wxpackage :cache size=" + this.fwN[0] + " data size=" + this.fwN[1] + " code size=" + this.fwN[2]);
        }
        m[] gl = t.Ic().gl(21);
        if (gl == null || gl.length == 0 || gl[0] == null) {
            printStream.println("#traceconfig hardcode");
        } else {
            printStream.println("#traceconfig id=" + gl[0].id + " version=" + gl[0].version);
        }
        printStream.println("#handler.content:");
        format = byteArrayOutputStream.toString();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e2) {
        }
        return format;
    }

    public static String gF(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        Throwable th;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str2 = new String(com.tencent.mm.bl.e.bp(bArr));
                try {
                    fileInputStream.close();
                    return str2;
                } catch (Exception e) {
                    return str2;
                }
            } catch (IOException e2) {
                fileInputStream2 = fileInputStream;
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (Exception e3) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        } catch (IOException e5) {
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public final void a(File file, boolean z) {
        w.i("MicroMsg.HandlerTraceManager", "build log file ,needRecreate %b", Boolean.valueOf(z));
        if (file.exists()) {
            if (z) {
                file.delete();
            }
            i(file);
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            w.e("MicroMsg.HandlerTraceManager", "recreate log file fail");
        }
        Editor edit = this.hgx.edit();
        edit.putLong("handler_trace_log_file_create_time", System.currentTimeMillis());
        edit.putLong("handler_trace_log_file_full_time", 0).commit();
        i(file);
    }

    public final void AE() {
        w.i("MicroMsg.HandlerTraceManager", "summerc onUpdateComplete");
        this.hpe = this.hgx.getLong("handler_debug_log_time", 8000);
        this.hpf = this.hgx.getLong("handler_debug_log_time_main", 800);
        this.hpg = this.hgx.getLong("handler_trace_file_full_size", 25600);
        this.hph = this.hgx.getLong("handler_log_file_max_size", 35840);
        this.hpi = this.hgx.getLong("handler_upload_time_interval", 86400000);
        this.hpj = this.hgx.getLong("handler_worker_assert_time", 180000);
        this.hpk = this.hgx.getLong("handler_worker_warn_time", 5000);
        this.hpl = (int) this.hgx.getLong("handler_worker_warn_task_max_size", 120);
        this.hpm = (int) this.hgx.getLong("handler_worker_warn_task_keep_size", 50);
        this.hpn = (int) this.hgx.getLong("handler_worker_warn_task_keep_size", 1800000);
        i(new File(hpa));
    }
}
