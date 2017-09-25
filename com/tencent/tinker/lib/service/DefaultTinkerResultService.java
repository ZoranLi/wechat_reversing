package com.tencent.tinker.lib.service;

import android.os.Process;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.lib.e.b;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import java.io.File;

public class DefaultTinkerResultService extends AbstractResultService {
    public void a(a aVar) {
        if (aVar == null) {
            a.e("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received null result!!!!", new Object[0]);
            return;
        }
        a.i("Tinker.DefaultTinkerResultService", "DefaultTinkerResultService received a result:%s ", new Object[]{aVar.toString()});
        b.hq(getApplicationContext());
        if (aVar.fHO) {
            O(new File(aVar.xgi));
            if (b(aVar)) {
                Process.killProcess(Process.myPid());
            } else {
                a.i("Tinker.DefaultTinkerResultService", "I have already install the newly patch version!", new Object[0]);
            }
        }
    }

    public static void O(File file) {
        if (SharePatchFileUtil.U(file)) {
            a.w("Tinker.DefaultTinkerResultService", "deleteRawPatchFile rawFile path: %s", new Object[]{file.getPath()});
            String name = file.getName();
            if (name.startsWith("patch-") && name.endsWith(".apk")) {
                File parentFile = file.getParentFile();
                if (!parentFile.getName().startsWith("patch-")) {
                    SharePatchFileUtil.W(file);
                    return;
                } else if (!parentFile.getParentFile().getName().equals("tinker")) {
                    SharePatchFileUtil.W(file);
                    return;
                } else {
                    return;
                }
            }
            SharePatchFileUtil.W(file);
        }
    }

    public final boolean b(a aVar) {
        com.tencent.tinker.lib.d.a hp = com.tencent.tinker.lib.d.a.hp(getApplicationContext());
        if (hp.xgw) {
            d dVar = hp.xgv;
            if (dVar != null) {
                String str = dVar.xgA;
                if (aVar.xgj != null && aVar.xgj.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }
}
