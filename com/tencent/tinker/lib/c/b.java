package com.tencent.tinker.lib.c;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.lib.e.c;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.List;

public class b implements d {
    private static boolean xgh = false;
    protected final Context context;

    public b(Context context) {
        this.context = context;
    }

    public void H(Intent intent) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchServiceStart: patch service start", new Object[0]);
        xgh = false;
        c hu = c.hu(this.context);
        if (!hu.xgT) {
            a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry disabled, just return", new Object[0]);
        } else if (intent == null) {
            a.e("Tinker.UpgradePatchRetry", "onPatchServiceStart intent is null, just return", new Object[0]);
        } else {
            String am = TinkerPatchService.am(intent);
            if (am == null) {
                a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch path is null, just return", new Object[0]);
                return;
            }
            File file = new File(am);
            String X = SharePatchFileUtil.X(file);
            if (X == null) {
                a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch md5 is null, just return", new Object[0]);
                return;
            }
            a R;
            if (hu.xgU.exists()) {
                R = a.R(hu.xgU);
                if (R.fFW == null || R.xgX == null || !X.equals(R.fFW)) {
                    hu.Q(file);
                    R.fFW = X;
                    R.xgX = "1";
                } else {
                    int parseInt = Integer.parseInt(R.xgX);
                    if (parseInt >= hu.xgW) {
                        SharePatchFileUtil.W(hu.xgV);
                        a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry more than max count, delete retry info file!", new Object[0]);
                        return;
                    }
                    R.xgX = String.valueOf(parseInt + 1);
                }
            } else {
                hu.Q(file);
                R = new a(X, "1");
            }
            a.a(hu.xgU, R);
        }
    }

    public void d(File file, int i) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchPackageCheckFail: package check failed. path: %s, code: %d", new Object[]{file.getAbsolutePath(), Integer.valueOf(i)});
        if (i == -3 || i == -4 || i == -8) {
            com.tencent.tinker.lib.d.a.hp(this.context).P(file);
        }
    }

    public void a(File file, SharePatchInfo sharePatchInfo, String str) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchVersionCheckFail: patch version exist. path: %s, version: %s", new Object[]{file.getAbsolutePath(), str});
    }

    public void a(File file, File file2, String str, int i) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchTypeExtractFail: file extract fail type: %s, path: %s, extractTo: %s, filename: %s", new Object[]{ShareTinkerInternals.DZ(i), file.getPath(), file2.getPath(), str});
        com.tencent.tinker.lib.d.a.hp(this.context).P(file);
    }

    public void a(File file, List<File> list, Throwable th) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchDexOptFail: dex opt fail path: %s, dex size: %d", new Object[]{file.getAbsolutePath(), Integer.valueOf(list.size())});
        a.printErrStackTrace("Tinker.DefaultPatchReporter", th, "onPatchDexOptFail:", new Object[0]);
        if (th.getMessage().contains("checkDexOptExist failed") || th.getMessage().contains("checkDexOptFormat failed")) {
            xgh = true;
            for (File W : list) {
                SharePatchFileUtil.W(W);
            }
            return;
        }
        com.tencent.tinker.lib.d.a.hp(this.context).P(file);
    }

    public void a(File file, boolean z, long j) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchResult: patch all result path: %s, success: %b, cost: %d", new Object[]{file.getAbsolutePath(), Boolean.valueOf(z), Long.valueOf(j)});
        if (!xgh) {
            c hu = c.hu(this.context);
            if (!hu.xgT) {
                a.w("Tinker.UpgradePatchRetry", "onPatchServiceResult retry disabled, just return", new Object[0]);
            } else if (hu.xgV.exists()) {
                SharePatchFileUtil.W(hu.xgV);
            }
        }
    }

    public void a(File file, String str, String str2) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchInfoCorrupted: patch info is corrupted. old: %s, new: %s", new Object[]{str, str2});
        com.tencent.tinker.lib.d.a.hp(this.context).aDl();
    }

    public void a(File file, Throwable th) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchException: patch exception path: %s, throwable: %s", new Object[]{file.getAbsolutePath(), th.getMessage()});
        a.e("Tinker.DefaultPatchReporter", "tinker patch exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
        a.printErrStackTrace("Tinker.DefaultPatchReporter", th, "tinker patch exception", new Object[0]);
        com.tencent.tinker.lib.d.a.hp(this.context).tinkerFlags = 0;
        com.tencent.tinker.lib.d.a.hp(this.context).P(file);
    }
}
