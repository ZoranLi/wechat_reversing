package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.shake.d.b.a;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.protocal.c.azm;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.io.File;

public final class i {
    public static String bbv() {
        if (ap.zb()) {
            StringBuilder stringBuilder = new StringBuilder();
            ap.yY();
            File file = new File(stringBuilder.append(c.xv()).append("shakemusic/").toString());
            if (!(file.exists() && file.isDirectory())) {
                w.w("MicroMsg.ShakeMusicLogic", "storage dir[%s] not perpare, try to create it", new Object[]{file.getAbsolutePath()});
                file.mkdir();
            }
            File file2 = new File(file, ".nomedia");
            if (!file2.exists()) {
                w.w("MicroMsg.ShakeMusicLogic", "no media file[%s] not exists, try to create it", new Object[]{file.getAbsolutePath()});
                try {
                    file2.createNewFile();
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.ShakeMusicLogic", e, "", new Object[0]);
                }
            }
            if (file.exists()) {
                return file.getAbsolutePath() + "/";
            }
            w.w("MicroMsg.ShakeMusicLogic", "create storage dir fail");
            return null;
        }
        w.w("MicroMsg.ShakeMusicLogic", "getSaveDirPath: acc stg has not set uin");
        return null;
    }

    public static anf a(byte[] bArr, long j) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            azm com_tencent_mm_protocal_c_azm = (azm) new azm().aD(bArr);
            anf com_tencent_mm_protocal_c_anf = new anf();
            com_tencent_mm_protocal_c_anf.tRH = 4;
            com_tencent_mm_protocal_c_anf.tqY = String.valueOf(com_tencent_mm_protocal_c_azm.uaO);
            com_tencent_mm_protocal_c_anf.tRI = com_tencent_mm_protocal_c_azm.tRI;
            com_tencent_mm_protocal_c_anf.tRL = n.b(com_tencent_mm_protocal_c_azm.tGy);
            com_tencent_mm_protocal_c_anf.tRM = n.b(com_tencent_mm_protocal_c_azm.tGz);
            com_tencent_mm_protocal_c_anf.tRR = a.CA(com_tencent_mm_protocal_c_anf.tRM);
            com_tencent_mm_protocal_c_anf.tiL = com_tencent_mm_protocal_c_azm.tiL;
            com_tencent_mm_protocal_c_anf.tRQ = n.b(com_tencent_mm_protocal_c_azm.tGx);
            com_tencent_mm_protocal_c_anf.tRJ = n.b(com_tencent_mm_protocal_c_azm.uaP);
            com_tencent_mm_protocal_c_anf.tRK = n.b(com_tencent_mm_protocal_c_azm.uaQ);
            com_tencent_mm_protocal_c_anf.tRP = n.b(com_tencent_mm_protocal_c_azm.uaT);
            com_tencent_mm_protocal_c_anf.tRN = n.b(com_tencent_mm_protocal_c_azm.uaR);
            com_tencent_mm_protocal_c_anf.tRO = n.b(com_tencent_mm_protocal_c_azm.uaS);
            com_tencent_mm_protocal_c_anf.pRp = j;
            return com_tencent_mm_protocal_c_anf;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ShakeMusicLogic", e, "", new Object[0]);
            w.w("MicroMsg.ShakeMusicLogic", "get music wrapper bytes fail");
            return null;
        }
    }
}
