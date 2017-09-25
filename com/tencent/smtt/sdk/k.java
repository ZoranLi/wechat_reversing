package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.opensdk.constants.ConstantsAPI.AppSupportContentFlag;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class k {
    private static k wUE;
    private Context ty;
    Map<String, Object> wUF = new HashMap();
    public SharedPreferences wUG;

    private k(Context context) {
        this.wUG = context.getSharedPreferences("tbs_download_config", 4);
        this.ty = context.getApplicationContext();
    }

    public static synchronized k cef() {
        k kVar;
        synchronized (k.class) {
            kVar = wUE;
        }
        return kVar;
    }

    public static synchronized k fM(Context context) {
        k kVar;
        synchronized (k.class) {
            if (wUE == null) {
                wUE = new k(context);
            }
            kVar = wUE;
        }
        return kVar;
    }

    public final synchronized void CY(int i) {
        try {
            Editor edit = this.wUG.edit();
            edit.putInt("tbs_download_interrupt_code", i);
            edit.putLong("tbs_download_interrupt_time", System.currentTimeMillis());
            edit.commit();
        } catch (Exception e) {
        }
    }

    public final synchronized void CZ(int i) {
        Editor edit = this.wUG.edit();
        edit.putInt("tbs_install_interrupt_code", i);
        edit.commit();
    }

    public final synchronized long ceg() {
        int i;
        i = this.wUG.getInt("tbs_download_maxflow", 0);
        if (i == 0) {
            i = 20;
        }
        return ((long) (i * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) * AppSupportContentFlag.MMAPP_SUPPORT_XLS;
    }

    public final synchronized long ceh() {
        return l.ceu() >= 0 ? l.ceu() : this.wUG.getLong("retry_interval", 86400);
    }

    public final synchronized long cei() {
        long j;
        int i = 0;
        synchronized (this) {
            int i2 = this.wUG.getInt("tbs_download_min_free_space", 0);
            if (i2 != 0) {
                i = i2;
            }
            j = ((long) (i * WXMediaMessage.DESCRIPTION_LENGTH_LIMIT)) * AppSupportContentFlag.MMAPP_SUPPORT_XLS;
        }
        return j;
    }

    public final synchronized int cej() {
        int i;
        i = this.wUG.getInt("tbs_download_success_max_retrytimes", 0);
        if (i == 0) {
            i = 3;
        }
        return i;
    }

    public final synchronized int cek() {
        int i;
        i = this.wUG.getInt("tbs_download_failed_max_retrytimes", 0);
        if (i == 0) {
            i = 100;
        }
        return i;
    }

    public final synchronized int cel() {
        int i;
        if (this.wUG.contains("tbs_download_interrupt_code")) {
            i = this.wUG.getInt("tbs_download_interrupt_code", -99);
            if (i == -119 || i == -121) {
                i = this.wUG.getInt("tbs_download_interrupt_code_reason", -119);
            }
            if (System.currentTimeMillis() - this.wUG.getLong("tbs_download_interrupt_time", 0) > 86400000) {
                i -= 98000;
            }
        } else {
            try {
                i = !new File(new File(this.ty.getFilesDir(), "shared_prefs"), "tbs_download_config").exists() ? -97 : !this.wUG.contains("tbs_needdownload") ? -96 : -101;
            } catch (Throwable th) {
                i = -95;
            }
        }
        i = (this.ty == null || !"com.tencent.mobileqq".equals(this.ty.getApplicationInfo().packageName) || "CN".equals(Locale.getDefault().getCountry())) ? (i * 1000) + this.wUG.getInt("tbs_install_interrupt_code", -1) : -320;
        return i;
    }

    public final synchronized void commit() {
        Editor edit = this.wUG.edit();
        for (String str : this.wUF.keySet()) {
            Object obj = this.wUF.get(str);
            if (obj instanceof String) {
                edit.putString(str, (String) obj);
            } else {
                try {
                    if (obj instanceof Boolean) {
                        edit.putBoolean(str, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Long) {
                        edit.putLong(str, ((Long) obj).longValue());
                    } else if (obj instanceof Integer) {
                        edit.putInt(str, ((Integer) obj).intValue());
                    } else if (obj instanceof Float) {
                        edit.putFloat(str, ((Float) obj).floatValue());
                    }
                } catch (Exception e) {
                }
            }
        }
        edit.commit();
        this.wUF.clear();
    }
}
