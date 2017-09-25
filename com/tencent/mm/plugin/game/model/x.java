package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.model.q.a;
import com.tencent.mm.plugin.game.model.q.d;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.Map;

public final class x {
    public static x mqV;

    static x aAZ() {
        if (mqV == null) {
            mqV = new x();
        }
        return mqV;
    }

    static void c(Map<String, String> map, q qVar) {
        String str = ".sysmsg.gamecenter.jump_info.jump";
        qVar.mpU.clear();
        int i = 0;
        while (true) {
            String str2;
            if (i == 0) {
                str2 = str;
            } else {
                str2 = str + i;
            }
            if (map.containsKey(str2)) {
                String str3 = (String) map.get(str2 + ".$id");
                d dVar = new d();
                dVar.mqH = bg.getInt((String) map.get(str2 + ".jump_type"), 0);
                dVar.lkK = bg.ap((String) map.get(str2 + ".jump_url"), "");
                if (!bg.mA(str3)) {
                    qVar.mpU.put(str3, dVar);
                }
                i++;
            } else {
                return;
            }
        }
    }

    static void d(Map<String, String> map, q qVar) {
        qVar.mqy = bg.getInt((String) map.get(".sysmsg.gamecenter.report.msg_subtype"), 0);
        qVar.mqz = bg.ap((String) map.get(".sysmsg.gamecenter.report.noticeid"), "");
    }

    static void e(Map<String, String> map, q qVar) {
        boolean z;
        boolean z2 = true;
        qVar.mqg.url = bg.ap((String) map.get(".sysmsg.gamecenter.float_layer.open_url"), "");
        a aVar = qVar.mqg;
        if (bg.getInt((String) map.get(".sysmsg.gamecenter.float_layer.full_screen"), 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        aVar.mpB = z;
        qVar.mqg.orientation = bg.getInt((String) map.get(".sysmsg.gamecenter.float_layer.orientation"), 0);
        aVar = qVar.mqg;
        if (bg.getInt((String) map.get(".sysmsg.gamecenter.float_layer.is_transparent"), 0) != 1) {
            z2 = false;
        }
        aVar.mqD = z2;
    }
}
