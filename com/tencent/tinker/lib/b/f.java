package com.tencent.tinker.lib.b;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.tinker.lib.service.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.io.IOException;

public final class f extends a {
    public final boolean a(Context context, String str, a aVar) {
        com.tencent.tinker.lib.d.a hp = com.tencent.tinker.lib.d.a.hp(context);
        File file = new File(str);
        if (!ShareTinkerInternals.Ea(hp.tinkerFlags) || !ShareTinkerInternals.hD(context)) {
            com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch is disabled, just return", new Object[0]);
            return false;
        } else if (SharePatchFileUtil.U(file)) {
            ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(context);
            int a = ShareTinkerInternals.a(context, hp.tinkerFlags, file, shareSecurityCheck);
            if (a != 0) {
                com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchPackageCheckFail", new Object[0]);
                hp.xgr.d(file, a);
                return false;
            }
            String X = SharePatchFileUtil.X(file);
            if (X == null) {
                com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch md5 is null, just return", new Object[0]);
                return false;
            }
            SharePatchInfo sharePatchInfo;
            aVar.xgj = X;
            com.tencent.tinker.lib.e.a.i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchMd5:%s", new Object[]{X});
            String absolutePath = hp.xgo.getAbsolutePath();
            File VR = SharePatchFileUtil.VR(absolutePath);
            File VQ = SharePatchFileUtil.VQ(absolutePath);
            SharePatchInfo m = SharePatchInfo.m(VQ, VR);
            if (m == null) {
                sharePatchInfo = new SharePatchInfo("", X, Build.FINGERPRINT, "odex");
            } else if (m.xiG == null || m.xiH == null || m.xgB == null) {
                com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchInfoCorrupted", new Object[0]);
                hp.xgr.a(file, m.xiG, m.xiH);
                return false;
            } else if (SharePatchFileUtil.VU(X)) {
                sharePatchInfo = new SharePatchInfo(m.xiG, X, Build.FINGERPRINT, m.xgB.equals("interpet") ? "changing" : m.xgB);
            } else {
                com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchVersionCheckFail md5 %s is valid", new Object[]{X});
                hp.xgr.a(file, m, X);
                return false;
            }
            absolutePath = absolutePath + "/" + SharePatchFileUtil.VS(X);
            com.tencent.tinker.lib.e.a.i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchVersionDirectory:%s", new Object[]{absolutePath});
            File file2 = new File(absolutePath + "/" + SharePatchFileUtil.VT(X));
            try {
                if (!X.equals(SharePatchFileUtil.X(file2))) {
                    SharePatchFileUtil.k(file, file2);
                    com.tencent.tinker.lib.e.a.w("Tinker.UpgradePatch", "UpgradePatch copy patch file, src file: %s size: %d, dest file: %s size:%d", new Object[]{file.getAbsolutePath(), Long.valueOf(file.length()), file2.getAbsolutePath(), Long.valueOf(file2.length())});
                }
                if (d.a(hp, shareSecurityCheck, context, absolutePath, file2)) {
                    String str2;
                    boolean z;
                    if (ShareTinkerInternals.DX(hp.tinkerFlags)) {
                        str2 = (String) shareSecurityCheck.xiS.get("assets/so_meta.txt");
                        if (str2 == null) {
                            com.tencent.tinker.lib.e.a.w("Tinker.BsDiffPatchInternal", "patch recover, library is not contained", new Object[0]);
                            z = true;
                        } else {
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            z = c.a(context, absolutePath + "/lib/", str2, file2);
                            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
                            com.tencent.tinker.lib.e.a.i("Tinker.BsDiffPatchInternal", "recover lib result:%b, cost:%d", new Object[]{Boolean.valueOf(z), Long.valueOf(elapsedRealtime)});
                        }
                    } else {
                        com.tencent.tinker.lib.e.a.w("Tinker.BsDiffPatchInternal", "patch recover, library is not enabled", new Object[0]);
                        z = true;
                    }
                    if (z) {
                        if (ShareTinkerInternals.DY(hp.tinkerFlags)) {
                            str2 = (String) shareSecurityCheck.xiS.get("assets/res_meta.txt");
                            if (str2 == null || str2.length() == 0) {
                                com.tencent.tinker.lib.e.a.w("Tinker.ResDiffPatchInternal", "patch recover, resource is not contained", new Object[0]);
                                z = true;
                            } else {
                                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                if (e.c(context, absolutePath + "/res/", str2, file2)) {
                                    z = true;
                                } else {
                                    com.tencent.tinker.lib.e.a.w("Tinker.ResDiffPatchInternal", "patch recover, extractDiffInternals fail", new Object[0]);
                                    z = false;
                                }
                                elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                                com.tencent.tinker.lib.e.a.i("Tinker.ResDiffPatchInternal", "recover resource result:%b, cost:%d", new Object[]{Boolean.valueOf(z), Long.valueOf(elapsedRealtime2)});
                            }
                        } else {
                            com.tencent.tinker.lib.e.a.w("Tinker.ResDiffPatchInternal", "patch recover, resource is not enabled", new Object[0]);
                            z = true;
                        }
                        if (!z) {
                            com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch resource failed", new Object[0]);
                            return false;
                        } else if (!d.a(file, hp)) {
                            com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, check dex opt file failed", new Object[0]);
                            return false;
                        } else if (SharePatchInfo.a(VQ, sharePatchInfo, VR)) {
                            com.tencent.tinker.lib.e.a.w("Tinker.UpgradePatch", "UpgradePatch tryPatch: done, it is ok", new Object[0]);
                            return true;
                        } else {
                            com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, rewrite patch info failed", new Object[0]);
                            hp.xgr.a(file, sharePatchInfo.xiG, sharePatchInfo.xiH);
                            return false;
                        }
                    }
                    com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch library failed", new Object[0]);
                    return false;
                }
                com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch dex failed", new Object[0]);
                return false;
            } catch (IOException e) {
                com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:copy patch file fail from %s to %s", new Object[]{file.getPath(), file2.getPath()});
                hp.xgr.a(file, file2, file.getName(), 1);
                return false;
            }
        } else {
            com.tencent.tinker.lib.e.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch file is not found, just return", new Object[0]);
            return false;
        }
    }
}
