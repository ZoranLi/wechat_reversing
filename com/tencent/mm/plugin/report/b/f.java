package com.tencent.mm.plugin.report.b;

import com.tencent.mm.a.p;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ao;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class f {
    public static boolean DA(String str) {
        File file = new File("/sdcard/cov.txt");
        if (file.exists()) {
            String A = ao.hlW.A("login_user_name", "never_login_crash");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("#username=" + A);
            stringBuffer.append("\n");
            stringBuffer.append("#rev=" + e.REV);
            stringBuffer.append("\n");
            stringBuffer.append("#path=" + e.SVNPATH);
            stringBuffer.append("\n");
            if (str.length() > 0) {
                stringBuffer.append("#startrev=" + str);
                stringBuffer.append("\n");
            }
            com.tencent.mm.a.e.e(file.getAbsolutePath(), stringBuffer.toString().getBytes());
            String a = p.a(file, false, "/sdcard/cov/cov_" + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date()) + ".zip");
            if (a == null) {
                w.e("MicroMsg.NetSceneCodeCoverageReport", "zip file failed");
                return false;
            }
            file.delete();
            w.i("MicroMsg.NetSceneCodeCoverageReport", "code coverage try upload :" + A);
            q.a(a, A, false, false, 10, 20004);
            return true;
        }
        w.w("MicroMsg.NetSceneCodeCoverageReport", "codecoverage checkUpload dir never create ?");
        return false;
    }
}
