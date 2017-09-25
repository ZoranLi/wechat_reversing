package com.tencent.tinker.loader;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.UncaughtExceptionHandler;

public class TinkerUncaughtHandler implements UncaughtExceptionHandler {
    private final Context context;
    private final UncaughtExceptionHandler uts = Thread.getDefaultUncaughtExceptionHandler();
    private final File xhy;

    public TinkerUncaughtHandler(Context context) {
        this.context = context;
        this.xhy = SharePatchFileUtil.hz(context);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Throwable e;
        new StringBuilder("TinkerUncaughtHandler catch exception:").append(Log.getStackTraceString(th));
        this.uts.uncaughtException(thread, th);
        if (this.xhy != null && (Thread.getDefaultUncaughtExceptionHandler() instanceof TinkerUncaughtHandler)) {
            File parentFile = this.xhy.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                Closeable printWriter;
                try {
                    printWriter = new PrintWriter(new FileWriter(this.xhy, false));
                    try {
                        printWriter.println("process:" + ShareTinkerInternals.hH(this.context));
                        printWriter.println(ShareTinkerInternals.h(th));
                        SharePatchFileUtil.c(printWriter);
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            new StringBuilder("print crash file error:").append(Log.getStackTraceString(e));
                            SharePatchFileUtil.c(printWriter);
                            Process.killProcess(Process.myPid());
                        } catch (Throwable th2) {
                            e = th2;
                            SharePatchFileUtil.c(printWriter);
                            throw e;
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    printWriter = null;
                    new StringBuilder("print crash file error:").append(Log.getStackTraceString(e));
                    SharePatchFileUtil.c(printWriter);
                    Process.killProcess(Process.myPid());
                } catch (Throwable th3) {
                    e = th3;
                    printWriter = null;
                    SharePatchFileUtil.c(printWriter);
                    throw e;
                }
                Process.killProcess(Process.myPid());
            }
        }
    }
}
