package com.tencent.mm.plugin.game.gamewebview.d;

import com.tencent.mm.protocal.c.agk;
import java.util.HashMap;

public final class a {
    private static final HashMap<String, agk> moe = new HashMap();

    public static boolean bc(String str, String str2) {
        agk com_tencent_mm_protocal_c_agk = (agk) moe.get(str + "#" + str2);
        if (com_tencent_mm_protocal_c_agk == null || com_tencent_mm_protocal_c_agk.thx != 1) {
            return false;
        }
        return true;
    }
}
