package com.tencent.recovery.log;

import java.util.ArrayList;

public class RecoveryLog {
    private static RecoveryLogImpl hOF = new RecoveryCacheLog();

    public interface RecoveryLogImpl {
        void Ie();

        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void v(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void Ie() {
        hOF.Ie();
    }

    public static void i(String str, String str2, Object... objArr) {
        if (hOF != null) {
            hOF.i(str, str2, objArr);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (hOF != null) {
            hOF.e(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (hOF != null) {
            hOF.printErrStackTrace(str, th, str2, objArr);
        }
    }

    public static void a(RecoveryLogImpl recoveryLogImpl) {
        if (hOF instanceof RecoveryCacheLog) {
            RecoveryCacheLog recoveryCacheLog = (RecoveryCacheLog) hOF;
            int size = recoveryCacheLog.wQi.size();
            for (int i = 0; i < size; i++) {
                LogItem logItem = (LogItem) recoveryCacheLog.wQi.get(i);
                switch (logItem.level) {
                    case 1:
                        recoveryLogImpl.v(logItem.tag, logItem.wQj, logItem.wQk);
                        break;
                    case 2:
                        recoveryLogImpl.d(logItem.tag, logItem.wQj, logItem.wQk);
                        break;
                    case 3:
                        recoveryLogImpl.i(logItem.tag, logItem.wQj, logItem.wQk);
                        break;
                    case 4:
                        recoveryLogImpl.w(logItem.tag, logItem.wQj, logItem.wQk);
                        break;
                    case 5:
                        if (logItem.wQl == null) {
                            recoveryLogImpl.e(logItem.tag, logItem.wQj, logItem.wQk);
                            break;
                        } else {
                            recoveryLogImpl.printErrStackTrace(logItem.tag, logItem.wQl, logItem.wQj, logItem.wQk);
                            break;
                        }
                    default:
                        break;
                }
            }
            recoveryCacheLog.wQi = new ArrayList();
        }
        hOF = recoveryLogImpl;
    }

    public static void cdx() {
        if (hOF instanceof RecoveryFileLog) {
            ((RecoveryFileLog) hOF).bc("", true);
        }
    }

    public static RecoveryLogImpl cdy() {
        return hOF;
    }
}
