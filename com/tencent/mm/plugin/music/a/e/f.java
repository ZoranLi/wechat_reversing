package com.tencent.mm.plugin.music.a.e;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;
import java.util.Map;

public final class f {
    private static HashMap<Integer, Boolean> nUg = new HashMap();
    private static HashMap<Integer, Long> nUh = new HashMap();

    static {
        nUg.put(Integer.valueOf(0), Boolean.valueOf(false));
        nUg.put(Integer.valueOf(1), Boolean.valueOf(false));
        nUg.put(Integer.valueOf(4), Boolean.valueOf(false));
        nUg.put(Integer.valueOf(5), Boolean.valueOf(false));
        nUg.put(Integer.valueOf(6), Boolean.valueOf(false));
        nUg.put(Integer.valueOf(7), Boolean.valueOf(false));
        nUg.put(Integer.valueOf(8), Boolean.valueOf(false));
        nUg.put(Integer.valueOf(9), Boolean.valueOf(false));
        nUh.put(Integer.valueOf(0), Long.valueOf(0));
        nUh.put(Integer.valueOf(1), Long.valueOf(0));
        nUh.put(Integer.valueOf(4), Long.valueOf(0));
        nUh.put(Integer.valueOf(5), Long.valueOf(0));
        nUh.put(Integer.valueOf(6), Long.valueOf(0));
        nUh.put(Integer.valueOf(7), Long.valueOf(0));
        nUh.put(Integer.valueOf(8), Long.valueOf(0));
        nUh.put(Integer.valueOf(9), Long.valueOf(0));
    }

    public static boolean ql(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - ((Long) nUh.get(Integer.valueOf(i))).longValue() < 10000) {
            return ((Boolean) nUg.get(Integer.valueOf(i))).booleanValue();
        }
        nUh.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
        c dX = com.tencent.mm.u.c.c.Az().dX("100283");
        if (dX.isValid()) {
            Map bKK = dX.bKK();
            if (bKK == null) {
                w.e("MicroMsg.MusicPlayerSwitcher", "supportQQMusicPlayer args == null");
                return qm(i);
            } else if (!bKK.containsKey("support_player_flag")) {
                w.e("MicroMsg.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the support_player_flag key");
                return qm(i);
            } else if (TextUtils.isEmpty((CharSequence) bKK.get("support_player_flag"))) {
                w.e("MicroMsg.MusicPlayerSwitcher", "supportQQMusicPlayer not contain the the value is empty");
                return qm(i);
            } else {
                int intValue;
                boolean cy;
                try {
                    intValue = Integer.valueOf((String) bKK.get("support_player_flag"), 16).intValue();
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.MusicPlayerSwitcher", e, "supportQQMusicPlayer", new Object[0]);
                    intValue = 0;
                }
                w.i("MicroMsg.MusicPlayerSwitcher", "supportQQMusicPlayer contain support_player_flag:%s", new Object[]{r0});
                ap.yY();
                currentTimeMillis = ((Long) com.tencent.mm.u.c.vr().get(a.uGM, Long.valueOf(0))).longValue();
                if (currentTimeMillis == 0) {
                    w.i("MicroMsg.MusicPlayerSwitcher", "sequence is 0");
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(a.uGM, Long.valueOf(dX.field_sequence));
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(a.uGL, Integer.valueOf(intValue));
                    cy = cy(i, intValue);
                } else if (currentTimeMillis == dX.field_sequence) {
                    w.i("MicroMsg.MusicPlayerSwitcher", "sequence is equal, check flag from local switch flag");
                    ap.yY();
                    cy = cy(i, ((Integer) com.tencent.mm.u.c.vr().get(a.uGL, Integer.valueOf(intValue))).intValue());
                } else {
                    w.i("MicroMsg.MusicPlayerSwitcher", "sequence is diff, update local data");
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(a.uGM, Long.valueOf(dX.field_sequence));
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(a.uGL, Integer.valueOf(intValue));
                    cy = cy(i, intValue);
                }
                nUg.put(Integer.valueOf(i), Boolean.valueOf(cy));
                return cy;
            }
        }
        w.e("MicroMsg.MusicPlayerSwitcher", "supportQQMusicPlayer item.isValid is false");
        return qm(i);
    }

    private static boolean qm(int i) {
        ap.yY();
        boolean cy = cy(i, ((Integer) com.tencent.mm.u.c.vr().get(a.uGL, Integer.valueOf(0))).intValue());
        w.i("MicroMsg.MusicPlayerSwitcher", "checkLocalSupportPlayerFlag support_player_flag:%s", new Object[]{Integer.toHexString(r0)});
        nUg.put(Integer.valueOf(i), Boolean.valueOf(cy));
        return cy;
    }

    private static boolean cy(int i, int i2) {
        if (i == 0 && (i2 & 1) > 0) {
            w.i("MicroMsg.MusicPlayerSwitcher", "support CHATTING_UI");
            return true;
        } else if (i == 1 && (i2 & 2) > 0) {
            w.i("MicroMsg.MusicPlayerSwitcher", "support SNS_TIMELINE_UI");
            return true;
        } else if (i == 4 && (i2 & 4) > 0) {
            w.i("MicroMsg.MusicPlayerSwitcher", "support SHAKE_MUSIC_UI");
            return true;
        } else if (i == 5 && (i2 & 8) > 0) {
            w.i("MicroMsg.MusicPlayerSwitcher", "support PRODUCT_UI");
            return true;
        } else if (i == 6 && (i2 & 16) > 0) {
            w.i("MicroMsg.MusicPlayerSwitcher", "support FAVORITE_UI");
            return true;
        } else if (i == 7 && (i2 & 32) > 0) {
            w.i("MicroMsg.MusicPlayerSwitcher", "support WEBVIEW_UI");
            return true;
        } else if (i == 8 && (i2 & 64) > 0) {
            w.i("MicroMsg.MusicPlayerSwitcher", "support SNS_USER_TIMELINE_UI");
            return true;
        } else if (i != 9 || (i2 & FileUtils.S_IWUSR) <= 0) {
            w.i("MicroMsg.MusicPlayerSwitcher", "QQMusicPlayer not support this scene %d", new Object[]{Integer.valueOf(i)});
            return false;
        } else {
            w.i("MicroMsg.MusicPlayerSwitcher", "support SEARCH_TIMELINE_UI");
            return true;
        }
    }
}
