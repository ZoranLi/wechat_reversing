package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import com.tencent.mm.protocal.c.alo;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class c {
    private static c siR;

    public enum a {
        HVGAME_MENU_ACTION_DEFAULT(0),
        HVGAME_MENU_ACTION_JUMP_H5(1),
        HVGAME_MENU_ACTION_EXIT(2),
        HVGAME_MENU_ACTION_SHARE_TO_FRIEND(3),
        HVGAME_MENU_ACTION_COLLECT(4),
        HVGAME_MENU_ACTION_STICK_ON(5),
        HVGAME_MENU_ACTION_STICK_OFF(6),
        HVGAME_MENU_ACTION_REFRESH(7),
        HVGAME_MENU_ACTION_ADD_TO_DESKTOP(8),
        HVGAME_MENU_ACTION_COMPLAINT(9),
        HVGAME_MENU_ACTION_CUSTOM(10);
        
        private static EnumMap<a, Integer> sje;
        int code;

        static {
            sje = new EnumMap(a.class);
            Iterator it = EnumSet.allOf(a.class).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                sje.put(aVar, Integer.valueOf(aVar.code));
            }
        }

        private a(int i) {
            this.code = i;
        }

        public static boolean wA(int i) {
            return sje.containsValue(Integer.valueOf(i));
        }

        public static a wB(int i) {
            for (Entry entry : sje.entrySet()) {
                if (((Integer) entry.getValue()).intValue() == i) {
                    return (a) entry.getKey();
                }
            }
            return HVGAME_MENU_ACTION_DEFAULT;
        }
    }

    public static c bzg() {
        if (siR == null) {
            synchronized (c.class) {
                if (siR == null) {
                    siR = new c();
                }
            }
        }
        return siR;
    }

    public final l f(List<alo> list, boolean z) {
        if (bg.bV(list)) {
            return null;
        }
        List<alo> arrayList = new ArrayList();
        for (alo com_tencent_mm_protocal_c_alo : list) {
            if (com_tencent_mm_protocal_c_alo != null && a.wA(com_tencent_mm_protocal_c_alo.tAL)) {
                arrayList.add(com_tencent_mm_protocal_c_alo);
            }
        }
        if (bg.bV(arrayList)) {
            return null;
        }
        Collections.sort(arrayList, new Comparator<alo>(this) {
            final /* synthetic */ c siS;

            {
                this.siS = r1;
            }

            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return ((alo) obj).tQt - ((alo) obj2).tQt;
            }
        });
        int i = ((alo) arrayList.get(arrayList.size() - 1)).tQt;
        List<alo> arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList2.add(null);
        }
        for (alo com_tencent_mm_protocal_c_alo2 : arrayList) {
            if (a.wB(com_tencent_mm_protocal_c_alo2.tAL) == a.HVGAME_MENU_ACTION_STICK_ON) {
                if (!z && com_tencent_mm_protocal_c_alo2.tQt > 0 && com_tencent_mm_protocal_c_alo2.tQt <= arrayList2.size()) {
                    arrayList2.set(com_tencent_mm_protocal_c_alo2.tQt - 1, com_tencent_mm_protocal_c_alo2);
                }
            } else if (a.wB(com_tencent_mm_protocal_c_alo2.tAL) == a.HVGAME_MENU_ACTION_STICK_OFF) {
                if (z && com_tencent_mm_protocal_c_alo2.tQt > 0 && com_tencent_mm_protocal_c_alo2.tQt <= arrayList2.size()) {
                    arrayList2.set(com_tencent_mm_protocal_c_alo2.tQt - 1, com_tencent_mm_protocal_c_alo2);
                }
            } else if (com_tencent_mm_protocal_c_alo2.tQt > 0 && com_tencent_mm_protocal_c_alo2.tQt <= arrayList2.size()) {
                arrayList2.set(com_tencent_mm_protocal_c_alo2.tQt - 1, com_tencent_mm_protocal_c_alo2);
            }
        }
        l lVar = new l();
        for (alo com_tencent_mm_protocal_c_alo22 : arrayList2) {
            if (com_tencent_mm_protocal_c_alo22 == null) {
                lVar.e(-1, "");
            } else {
                lVar.e(com_tencent_mm_protocal_c_alo22.tQs, com_tencent_mm_protocal_c_alo22.fDC + "__" + com_tencent_mm_protocal_c_alo22.ohq);
            }
        }
        return lVar;
    }
}
