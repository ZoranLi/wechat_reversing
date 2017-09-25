package com.tencent.mm.sandbox.updater;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mm.a.g;
import com.tencent.mm.b.a;
import com.tencent.mm.b.h;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;

public final class i {
    private static final long[] ijY = new long[]{0, 259200000, 604800000};

    private static String cq(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.UpdateUtil", e, "", new Object[0]);
            return null;
        }
    }

    public static String dS(Context context) {
        String cq = cq(context);
        if (cq == null || !new File(cq).exists()) {
            return null;
        }
        a aZ = a.aZ(cq);
        return (aZ == null || aZ.fuS == null) ? g.aV(cq) : aZ.fuS.apkMd5;
    }

    public static int e(Context context, String str, String str2, String str3) {
        return h.b(cq(context), str, str2, str3);
    }

    public static void X(Context context, int i) {
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
        intent.putExtra("intent_extra_is_silence_stat", false);
        intent.putExtra("intent_extra_opcode", i);
        context.sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
    }

    public static void Y(Context context, int i) {
        f(context, i, 0);
    }

    public static void f(Context context, int i, int i2) {
        Intent intent = new Intent();
        intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_UPDATE");
        intent.putExtra("intent_extra_is_silence_stat", true);
        intent.putExtra("intent_extra_opcode", i);
        if (i == 2) {
            intent.putExtra("intent_extra_install_dialog_times", i2);
        }
        context.sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
    }

    public static String Nu() {
        return MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "update_config_prefs", 4).getString("update_downloaded_pack_md5_key", null);
    }

    public static String bHY() {
        return MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "update_config_prefs", 4).getString("update_downloaded_pack_sig_key", null);
    }

    public static String bHZ() {
        return MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "update_config_prefs", 4).getString("update_downloaded_pack_desc_key", null);
    }

    public static int bIa() {
        return MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "update_config_prefs", 4).getInt("update_downloaded_pack_download_mode", 0);
    }

    public static void a(String str, String str2, String str3, int i, int i2, int i3, String str4) {
        MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "update_config_prefs", 4).edit().putString("update_downloaded_pack_md5_key", str).putString("update_downloaded_pack_sig_key", str2).putString("update_downloaded_pack_desc_key", str3).putInt("update_downloaded_pack_size_key", i).putInt("update_downloaded_pack_download_mode", i2).putInt("update_downloaded_pack_update_type", i3).putString("update_download_not_auto_download_range", str4).commit();
        w.i("MicroMsg.UpdateUtil", "summerupdate putDownloadedPackInfo md5: %s size: %s range: %s", str, Integer.valueOf(i), str4);
    }

    public static int bIb() {
        w.i("MicroMsg.UpdateUtil", "getIgnoreDownloadedPackTimes times %s", Integer.valueOf(MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "update_config_prefs", 4).getInt("update_downloaded_cancel_times", 0)));
        return MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "update_config_prefs", 4).getInt("update_downloaded_cancel_times", 0);
    }

    public static void bIc() {
        int i = 0;
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "update_config_prefs", 4);
        int i2 = sharedPreferences.getInt("update_downloaded_cancel_times", 0);
        w.i("MicroMsg.UpdateUtil", "putIgnoreDownloadedPack times %s", Integer.valueOf(i2));
        if (i2 >= ijY.length - 1) {
            String Nu = Nu();
            StringBuffer stringBuffer = null;
            if (!bg.mA(Nu)) {
                String[] bId = bId();
                stringBuffer = new StringBuffer();
                stringBuffer.append(Nu);
                if (bId != null) {
                    int length = bId.length;
                    while (i < length) {
                        String str = bId[i];
                        if (!bg.mA(str)) {
                            stringBuffer.append(":");
                            stringBuffer.append(str);
                        }
                        i++;
                    }
                }
            }
            sharedPreferences.edit().clear().commit();
            if (stringBuffer != null) {
                sharedPreferences.edit().putString("update_downloaded_ignored_pack", stringBuffer.toString()).commit();
                return;
            }
            return;
        }
        sharedPreferences.edit().putLong("update_downloaded_cancel_ts", System.currentTimeMillis()).putInt("update_downloaded_cancel_times", i2 + 1).commit();
    }

    public static boolean OY(String str) {
        String[] bId = bId();
        if (bId == null) {
            return false;
        }
        for (String equals : bId) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static String[] bId() {
        String string = MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "update_config_prefs", 4).getString("update_downloaded_ignored_pack", null);
        if (bg.mA(string)) {
            return null;
        }
        return string.split(":");
    }

    public static void bIe() {
        MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "update_config_prefs", 4).edit().putLong("update_downloading_in_silence", System.currentTimeMillis()).putBoolean("update_download_start_one_immediate", false).commit();
        w.i("MicroMsg.UpdateUtil", "putDowningInSilence");
    }

    public static void bIf() {
        MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "update_config_prefs", 4).edit().putBoolean("update_download_start_one_immediate", true).commit();
        w.i("MicroMsg.UpdateUtil", "putOneDownloadTask");
    }

    public static void bIg() {
        MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "update_config_prefs", 4).edit().remove("update_downloading_in_silence").commit();
        w.i("MicroMsg.UpdateUtil", "removeUnfinishDownloadingInSilence");
    }

    public static void bIh() {
        MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "update_config_prefs", 4).edit().clear().commit();
        w.i("MicroMsg.UpdateUtil", "clearUpdateConfigPrefs");
    }

    public static long l(String str, long j, long j2) {
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "update_flowstat_prefs", 4);
        long j3 = sharedPreferences.getLong(str, 0);
        w.i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flowUp %s, flowDown %s", str, Long.valueOf(j), Long.valueOf(j2));
        w.i("MicroMsg.UpdateUtil", "putPackFlowStat pack %s, flow %s", str, Long.valueOf(j3));
        j3 += j + j2;
        sharedPreferences.edit().putLong(str, j3).commit();
        return j3;
    }

    public static long OZ(String str) {
        w.i("MicroMsg.UpdateUtil", "getPackFlowStat pack %s, flow %s", str, Long.valueOf(MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "update_flowstat_prefs", 4).getLong(str, 0)));
        return MultiProcessSharedPreferences.getSharedPreferences(ab.getContext(), "update_flowstat_prefs", 4).getLong(str, 0);
    }
}
