package com.tencent.recovery.log;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl;
import com.tencent.recovery.storage.MMappedFileStorage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RecoveryFileLog implements RecoveryLogImpl {
    private MMappedFileStorage wQn;
    private SimpleDateFormat wQo;
    private boolean wQp;

    public RecoveryFileLog(Context context) {
        File file = new File(context.getFilesDir(), "recovery");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "recovery.log");
        if (file2.length() > 5242880) {
            file2.delete();
        }
        this.wQn = new MMappedFileStorage(file2.getAbsolutePath());
        this.wQo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    }

    public final synchronized void bc(String str, boolean z) {
        this.wQn.c(str.getBytes(), z);
    }

    public final void v(String str, String str2, Object... objArr) {
        bc(ae("V", str, String.format(str2, objArr)), false);
        if (this.wQp) {
            String.format(str2, objArr);
        }
    }

    public final void i(String str, String str2, Object... objArr) {
        bc(ae("I", str, String.format(str2, objArr)), false);
        if (this.wQp) {
            String.format(str2, objArr);
        }
    }

    public final void w(String str, String str2, Object... objArr) {
        bc(ae("W", str, String.format(str2, objArr)), false);
        if (this.wQp) {
            String.format(str2, objArr);
        }
    }

    public final void d(String str, String str2, Object... objArr) {
        bc(ae("D", str, String.format(str2, objArr)), false);
        if (this.wQp) {
            String.format(str2, objArr);
        }
    }

    public final void e(String str, String str2, Object... objArr) {
        bc(ae("E", str, String.format(str2, objArr)), false);
        if (this.wQp) {
            String.format(str2, objArr);
        }
    }

    public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        String str3 = "E";
        bc(ae(str3, str, String.format(str2, objArr) + "  " + Log.getStackTraceString(th)), false);
        if (this.wQp) {
            String.format(str2, objArr);
        }
    }

    public final void Ie() {
        this.wQp = true;
    }

    private String ae(String str, String str2, String str3) {
        String format = this.wQo.format(new Date());
        return String.format("%s​%s​[%d][%d][%s]: %s​​", new Object[]{str, str2, Integer.valueOf(Process.myPid()), Long.valueOf(Thread.currentThread().getId()), format, str3});
    }
}
