package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.model.q.a;
import com.tencent.mm.plugin.game.model.q.h;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.Map;

public final class s {
    static String s(Map<String, String> map) {
        return bg.ap((String) map.get(".sysmsg.gamecenter.formatcontent"), "");
    }

    static void a(Map<String, String> map, q qVar) {
        qVar.mpP.clear();
        String str = ".sysmsg.gamecenter.userinfo";
        int i = 0;
        while (true) {
            String str2;
            if (i == 0) {
                str2 = str;
            } else {
                str2 = str + i;
            }
            if (map.containsKey(str2)) {
                h hVar = new h();
                hVar.userName = bg.ap((String) map.get(str2 + ".username"), "");
                hVar.aIO = bg.ap((String) map.get(str2 + ".nickname"), "");
                hVar.mqN = bg.ap((String) map.get(str2 + ".usericon"), "");
                hVar.mqP = bg.ap((String) map.get(str2 + ".badge_icon"), "");
                hVar.mqQ = bg.ap((String) map.get(str2 + ".$jump_id"), "");
                qVar.mpP.add(hVar);
                i++;
            } else {
                return;
            }
        }
    }

    static long t(Map<String, String> map) {
        return bg.getLong((String) map.get(".sysmsg.game_control_info.control_flag"), 0);
    }

    static void b(Map<String, String> map, q qVar) {
        boolean z;
        boolean z2 = true;
        qVar.mqg.url = bg.ap((String) map.get(".sysmsg.gamecenter.floatlayer.open_url"), "");
        a aVar = qVar.mqg;
        if (bg.getInt((String) map.get(".sysmsg.gamecenter.floatlayer.full_screen"), 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        aVar.mpB = z;
        qVar.mqg.orientation = bg.getInt((String) map.get(".sysmsg.gamecenter.floatlayer.orientation"), 0);
        aVar = qVar.mqg;
        if (bg.getInt((String) map.get(".sysmsg.gamecenter.floatlayer.is_transparent"), 0) != 1) {
            z2 = false;
        }
        aVar.mqD = z2;
    }
}
