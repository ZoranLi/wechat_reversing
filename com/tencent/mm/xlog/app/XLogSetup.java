package com.tencent.mm.xlog.app;

import android.os.Looper;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.mars.xlog.Xlog;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;

public class XLogSetup {
    public static Boolean appendIsSync;
    public static String cachePath;
    public static boolean hasInit = false;
    public static Boolean isLogcatOpen;
    public static String logPath;
    public static String nameprefix;
    private static boolean setup = false;
    public static Integer toolsLevel;
    public static Xlog xlog = new Xlog();

    public static void realSetupXlog() {
        keep_setupXLog(true, cachePath, logPath, toolsLevel, appendIsSync, isLogcatOpen, nameprefix);
    }

    public static void keep_setupXLog(boolean z, String str, String str2, Integer num, Boolean bool, Boolean bool2, String str3) {
        if (!hasInit) {
            PlatformComm.init(ab.getContext(), new ae(Looper.getMainLooper()));
            hasInit = true;
        }
        cachePath = str;
        logPath = str2;
        toolsLevel = num;
        appendIsSync = bool;
        isLogcatOpen = bool2;
        nameprefix = str3;
        if (z && !setup) {
            setup = true;
            k.b(a.urP, XLogSetup.class.getClassLoader());
            w.a(xlog);
            appendIsSync.booleanValue();
            Xlog.setConsoleLogOpen(isLogcatOpen.booleanValue());
            if (toolsLevel == null) {
                Xlog.AppenderOpen(2, 0, cachePath, logPath, nameprefix);
                LogLogic.initIPxxLogInfo();
                return;
            }
            Xlog.AppenderOpen(toolsLevel.intValue(), 1, cachePath, logPath, nameprefix);
        }
    }
}
