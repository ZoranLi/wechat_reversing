package com.tencent.tinker.loader;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public class TinkerLoader extends AbstractTinkerLoader {
    private static final String TAG = "Tinker.TinkerLoader";
    private SharePatchInfo patchInfo;

    public Intent tryLoad(TinkerApplication tinkerApplication) {
        Intent intent = new Intent();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        tryLoadPatchFilesInternal(tinkerApplication, intent);
        ShareIntentUtil.a(intent, SystemClock.elapsedRealtime() - elapsedRealtime);
        return intent;
    }

    private void tryLoadPatchFilesInternal(TinkerApplication tinkerApplication, Intent intent) {
        int tinkerFlags = tinkerApplication.getTinkerFlags();
        if (!ShareTinkerInternals.Ea(tinkerFlags)) {
            ShareIntentUtil.a(intent, -1);
        } else if (ShareTinkerInternals.hF(tinkerApplication)) {
            ShareIntentUtil.a(intent, -1);
        } else {
            File hx = SharePatchFileUtil.hx(tinkerApplication);
            if (hx == null) {
                ShareIntentUtil.a(intent, -2);
                return;
            }
            String absolutePath = hx.getAbsolutePath();
            if (hx.exists()) {
                File VQ = SharePatchFileUtil.VQ(absolutePath);
                if (VQ.exists()) {
                    File VR = SharePatchFileUtil.VR(absolutePath);
                    this.patchInfo = SharePatchInfo.m(VQ, VR);
                    if (this.patchInfo == null) {
                        ShareIntentUtil.a(intent, -4);
                        return;
                    }
                    String str = this.patchInfo.xiG;
                    String str2 = this.patchInfo.xiH;
                    String str3 = this.patchInfo.xgB;
                    if (str == null || str2 == null || str3 == null) {
                        ShareIntentUtil.a(intent, -4);
                        return;
                    }
                    intent.putExtra("intent_patch_old_version", str);
                    intent.putExtra("intent_patch_new_version", str2);
                    boolean hE = ShareTinkerInternals.hE(tinkerApplication);
                    Object obj = !str.equals(str2) ? 1 : null;
                    Object obj2 = (str3.equals("changing") && hE) ? 1 : null;
                    str3 = ShareTinkerInternals.bL(tinkerApplication, str3);
                    intent.putExtra("intent_patch_oat_dir", str3);
                    if (obj == null || !hE) {
                        str2 = str;
                    }
                    if (ShareTinkerInternals.mA(str2)) {
                        ShareIntentUtil.a(intent, -5);
                        return;
                    }
                    str = SharePatchFileUtil.VS(str2);
                    if (str == null) {
                        ShareIntentUtil.a(intent, -6);
                        return;
                    }
                    absolutePath = absolutePath + "/" + str;
                    File file = new File(absolutePath);
                    if (file.exists()) {
                        File file2 = new File(file.getAbsolutePath(), SharePatchFileUtil.VT(str2));
                        if (SharePatchFileUtil.U(file2)) {
                            ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(tinkerApplication);
                            int a = ShareTinkerInternals.a(tinkerApplication, tinkerFlags, file2, shareSecurityCheck);
                            if (a != 0) {
                                intent.putExtra("intent_patch_package_patch_check", a);
                                ShareIntentUtil.a(intent, -8);
                                return;
                            }
                            intent.putExtra("intent_patch_package_config", shareSecurityCheck.cgU());
                            boolean DW = ShareTinkerInternals.DW(tinkerFlags);
                            if (DW && !TinkerDexLoader.a(absolutePath, shareSecurityCheck, str3, intent)) {
                                return;
                            }
                            if (!ShareTinkerInternals.DX(tinkerFlags) || TinkerSoLoader.a(absolutePath, shareSecurityCheck, intent)) {
                                boolean DY = ShareTinkerInternals.DY(tinkerFlags);
                                if (!DY || TinkerResourceLoader.a(tinkerApplication, absolutePath, shareSecurityCheck, intent)) {
                                    boolean z = ShareTinkerInternals.cgV() && ShareTinkerInternals.VW(this.patchInfo.xiI) && VERSION.SDK_INT >= 21;
                                    intent.putExtra("intent_patch_system_ota", z);
                                    if ((hE && obj != null) || obj2 != null) {
                                        this.patchInfo.xiG = str2;
                                        this.patchInfo.xgB = str3;
                                        if (!SharePatchInfo.a(VQ, this.patchInfo, VR)) {
                                            ShareIntentUtil.a(intent, -19);
                                            return;
                                        } else if (obj2 != null) {
                                            SharePatchFileUtil.aP(absolutePath + "/interpet");
                                        }
                                    }
                                    if (checkSafeModeCount(tinkerApplication)) {
                                        if (DW) {
                                            boolean a2 = TinkerDexLoader.a(tinkerApplication, absolutePath, str3, intent, z);
                                            if (z) {
                                                this.patchInfo.xiI = Build.FINGERPRINT;
                                                this.patchInfo.xgB = a2 ? "interpet" : "odex";
                                                obj2 = null;
                                                if (SharePatchInfo.a(VQ, this.patchInfo, VR)) {
                                                    intent.putExtra("intent_patch_oat_dir", this.patchInfo.xgB);
                                                } else {
                                                    ShareIntentUtil.a(intent, -19);
                                                    return;
                                                }
                                            }
                                            if (!a2) {
                                                return;
                                            }
                                        }
                                        if (!DY || TinkerResourceLoader.a(tinkerApplication, absolutePath, intent)) {
                                            if (obj2 != null) {
                                                ShareTinkerInternals.hG(tinkerApplication);
                                            }
                                            ShareIntentUtil.a(intent, 0);
                                            return;
                                        }
                                        return;
                                    }
                                    intent.putExtra("intent_patch_exception", new TinkerRuntimeException("checkSafeModeCount fail"));
                                    ShareIntentUtil.a(intent, -25);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        ShareIntentUtil.a(intent, -7);
                        return;
                    }
                    ShareIntentUtil.a(intent, -6);
                    return;
                }
                new StringBuilder("tryLoadPatchFiles:patch info not exist:").append(VQ.getAbsolutePath());
                ShareIntentUtil.a(intent, -3);
                return;
            }
            ShareIntentUtil.a(intent, -2);
        }
    }

    private boolean checkSafeModeCount(TinkerApplication tinkerApplication) {
        String str = "tinker_own_config_" + ShareTinkerInternals.hH(tinkerApplication);
        SharedPreferences sharedPreferences = tinkerApplication.getSharedPreferences(str, 0);
        int i = sharedPreferences.getInt("safe_mode_count", 0) + 1;
        new StringBuilder("tinker safe mode preferName:").append(str).append(" count:").append(i);
        if (i >= 3) {
            sharedPreferences.edit().putInt("safe_mode_count", 0).commit();
            return false;
        }
        tinkerApplication.setUseSafeMode(true);
        sharedPreferences.edit().putInt("safe_mode_count", i).commit();
        return true;
    }
}
