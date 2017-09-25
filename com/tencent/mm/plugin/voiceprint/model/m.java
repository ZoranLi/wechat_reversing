package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w;
import java.io.File;

public final class m {
    public static String at(String str, boolean z) {
        String str2 = w.hgq;
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.VoicePrintLogic", "dbCachePath " + str2);
        str2 = str2.endsWith(File.separator) ? str2 + str : str2 + File.separator + str;
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.VoicePrintLogic", "genpath " + str2);
        if (bg.mA(str2)) {
            return null;
        }
        return (z || !new File(str2).exists()) ? str2 : str2;
    }
}
