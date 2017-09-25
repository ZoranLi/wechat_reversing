package com.tencent.tinker.lib.d;

import android.content.Intent;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

public final class b {
    public static boolean b(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
        if (tinkerResultIntent != null && ShareIntentUtil.an(tinkerResultIntent) == 0) {
            return true;
        }
        return false;
    }

    public static String c(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
        if (tinkerResultIntent == null) {
            return null;
        }
        String i = ShareIntentUtil.i(tinkerResultIntent, "intent_patch_old_version");
        String i2 = ShareIntentUtil.i(tinkerResultIntent, "intent_patch_new_version");
        boolean hE = ShareTinkerInternals.hE(applicationLike.getApplication());
        if (i == null || i2 == null) {
            return null;
        }
        if (hE) {
            return i2;
        }
        return i;
    }

    public static void d(ApplicationLike applicationLike) {
        if (applicationLike == null || applicationLike.getApplication() == null) {
            throw new TinkerRuntimeException("tinkerApplication is null");
        }
        if (b(applicationLike)) {
            a.e("Tinker.TinkerApplicationHelper", "it is not safety to clean patch when tinker is loaded, you should kill all your process after clean!", new Object[0]);
        }
        SharePatchFileUtil.d(SharePatchFileUtil.hx(applicationLike.getApplication()));
    }
}
