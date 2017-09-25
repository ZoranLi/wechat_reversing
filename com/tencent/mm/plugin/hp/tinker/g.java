package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class g {
    public static boolean ae(Context context, String str) {
        String string = context.getSharedPreferences("tinker_patch_share_config", 4).getString("tinker_before_install", "");
        w.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "isBeforeDownloadDialogHaveCancel current patchID :%s patchID:%s", new Object[]{string, str});
        if (bg.mA(string) || bg.mA(str) || !string.equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    public static void af(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_before_install", str).apply();
        }
    }

    public static void ag(Context context, String str) {
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_msg_key", str).apply();
    }

    public static void cr(Context context) {
        int i = com.tencent.mm.i.g.sV().getInt("TinkerCheckUpdateInterval", 12);
        if (i < 0) {
            w.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "saveTinkerCheckUpdateTinker hours < 0 ");
            return;
        }
        w.i("MicroMsg.Tinker.TinkerPatchSharedPreferencesUtil", "saveTinkerCheckUpdateTinker hours:%d", new Object[]{Integer.valueOf(i)});
        context.getSharedPreferences("tinker_patch_share_config", 4).edit().putInt("check_tinker_update_interval", i).apply();
    }

    public static int cs(Context context) {
        return context.getSharedPreferences("tinker_patch_share_config", 4).getInt("check_tinker_update_interval", 12);
    }
}
