package com.tencent.recovery.log;

import com.tencent.recovery.log.RecoveryLog.RecoveryLogImpl;
import java.util.ArrayList;
import java.util.List;

public class RecoveryCacheLog implements RecoveryLogImpl {
    List<LogItem> wQi = new ArrayList(100);

    private class LogItem {
        int level;
        String tag;
        String wQj;
        Object[] wQk;
        Throwable wQl;
        final /* synthetic */ RecoveryCacheLog wQm;

        public LogItem(RecoveryCacheLog recoveryCacheLog) {
            this.wQm = recoveryCacheLog;
        }
    }

    public final void v(String str, String str2, Object... objArr) {
        if (this.wQi.size() < 100) {
            LogItem logItem = new LogItem(this);
            logItem.level = 1;
            logItem.tag = str;
            logItem.wQj = str2;
            logItem.wQk = objArr;
            this.wQi.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void d(String str, String str2, Object... objArr) {
        if (this.wQi.size() < 100) {
            LogItem logItem = new LogItem(this);
            logItem.level = 2;
            logItem.tag = str;
            logItem.wQj = str2;
            logItem.wQk = objArr;
            this.wQi.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void i(String str, String str2, Object... objArr) {
        if (this.wQi.size() < 100) {
            LogItem logItem = new LogItem(this);
            logItem.level = 3;
            logItem.tag = str;
            logItem.wQj = str2;
            logItem.wQk = objArr;
            this.wQi.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void w(String str, String str2, Object... objArr) {
        if (this.wQi.size() < 100) {
            LogItem logItem = new LogItem(this);
            logItem.level = 4;
            logItem.tag = str;
            logItem.wQj = str2;
            logItem.wQk = objArr;
            this.wQi.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void e(String str, String str2, Object... objArr) {
        if (this.wQi.size() < 100) {
            LogItem logItem = new LogItem(this);
            logItem.level = 5;
            logItem.tag = str;
            logItem.wQj = str2;
            logItem.wQk = objArr;
            this.wQi.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (this.wQi.size() < 100) {
            LogItem logItem = new LogItem(this);
            logItem.level = 5;
            logItem.tag = str;
            logItem.wQj = str2;
            logItem.wQk = objArr;
            logItem.wQl = th;
            this.wQi.add(logItem);
        }
        String.format(str2, objArr);
    }

    public final void Ie() {
    }
}
