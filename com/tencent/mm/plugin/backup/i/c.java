package com.tencent.mm.plugin.backup.i;

import com.tencent.mm.plugin.backup.a.e;
import com.tencent.mm.plugin.backup.backuppcmodel.b;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel.a;

public final class c {
    private static String TAG = "MicroMsg.BackupModelFactory";

    public static e jE(int i) {
        switch (i) {
            case -2:
                return a.abR();
            case -1:
                return com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.acg();
            case 1:
                return b.abd();
            case 2:
                return com.tencent.mm.plugin.backup.c.b.aaD();
            default:
                return null;
        }
    }
}
