package com.tencent.mm.modelrecovery;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;

public final class a {
    public static void If() {
        File file = new File(ab.getContext().getFilesDir(), "/recovery/recovery.log");
        String str = null;
        if (file.exists() && file.length() > 0) {
            try {
                str = FileOp.aT(file.getAbsolutePath());
                file.delete();
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Recovery.RecoveryLogUtil", e, "recoveryLog", new Object[0]);
            }
        }
        if (bg.mA(str)) {
            w.i("MicroMsg.Recovery.RecoveryLogUtil", "not found recovery log");
            return;
        }
        for (String str2 : str2.split("​​")) {
            String[] split = str2.split("​");
            if (split != null && split.length == 3) {
                String str3 = split[0];
                int i = -1;
                switch (str3.hashCode()) {
                    case 69:
                        if (str3.equals("E")) {
                            i = 0;
                            break;
                        }
                        break;
                }
                switch (i) {
                    case 0:
                        w.e(split[1], split[2]);
                        break;
                    default:
                        w.i(split[1], split[2]);
                        break;
                }
            }
            w.i("MicroMsg.Recovery.RecoveryLogUtil", str2);
        }
    }
}
