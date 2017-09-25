package com.tencent.mm.u;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.a.g;
import java.util.ArrayList;
import java.util.List;

public class ax {
    private static ax hmA;
    public b hmz;

    public enum a {
        ;

        static {
            hmB = 1;
            hmC = 2;
            hmD = 3;
            hmE = 4;
            hmF = new int[]{hmB, hmC, hmD, hmE};
        }
    }

    public interface b {
        void zm();
    }

    public static ax zj() {
        synchronized (ax.class) {
            if (hmA == null) {
                hmA = new ax();
            }
        }
        return hmA;
    }

    private ax() {
    }

    public final boolean a(aw awVar) {
        boolean z = true;
        if (awVar.type == 10000) {
            ap.yY();
            SharedPreferences ef = c.ef("banner");
            if (ef != null) {
                ef.edit().clear().commit();
            }
            if (this.hmz == null) {
                return true;
            }
            this.hmz.zm();
            return true;
        } else if (awVar.type == 57005) {
            return false;
        } else {
            ap.yY();
            SharedPreferences ef2 = c.ef("banner");
            if (ef2 == null) {
                return false;
            }
            Editor edit = ef2.edit();
            aw zk = zk();
            if (gg("HistoryInfo").contains(Integer.valueOf(awVar.type))) {
                z = false;
            }
            if (zk != null && zk.showType == 2) {
                List gg = gg("HistoryInfo");
                if (!gg.contains(Integer.valueOf(zk.type))) {
                    gg.add(Integer.valueOf(zk.type));
                }
                b("HistoryInfo", gg);
            }
            if (z) {
                edit.putInt("CurrentType", awVar.type).putInt("CurrentShowType", awVar.showType).putString("CurrentData", awVar.data).commit();
            }
            if (this.hmz == null) {
                return z;
            }
            this.hmz.zm();
            return z;
        }
    }

    public static aw zk() {
        ap.yY();
        SharedPreferences ef = c.ef("banner");
        if (ef == null) {
            return null;
        }
        int i = ef.getInt("CurrentType", -1);
        int i2 = ef.getInt("CurrentShowType", -1);
        String string = ef.getString("CurrentData", "");
        if (i == -1) {
            return null;
        }
        switch (i) {
            case 1:
                int zl = zl();
                if (zl == a.hmD || zl == a.hmE || g.Ae().Ac()) {
                    if (g.Ae().Ac()) {
                        w.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind bind contacts banner.");
                        return null;
                    }
                    w.i("MicorMsg.MainFrameBannerStorage", "already Bind the Mobile");
                    return null;
                }
            case 2:
                if (zl() == a.hmD || g.Ae().Ac()) {
                    if (g.Ae().Ac()) {
                        w.i("MicorMsg.MainFrameBannerStorage", "has abtest case. ignore bind upload contacts banner.");
                        return null;
                    }
                    w.i("MicorMsg.MainFrameBannerStorage", "already upload the contacts");
                    return null;
                }
            case 3:
                w.i("MicorMsg.MainFrameBannerStorage", "avatar already existed");
                return null;
            case 11:
            case 10000:
            case 57005:
                return null;
        }
        return new aw(i, i2, string);
    }

    public final void aJ(int i, int i2) {
        ap.yY();
        SharedPreferences ef = c.ef("banner");
        if (ef != null) {
            Editor edit = ef.edit();
            switch (i2) {
                case 1:
                    edit.remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
                    break;
                case 2:
                    edit.remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
                    List gg = gg("HistoryInfo");
                    if (!gg.contains(Integer.valueOf(i))) {
                        gg.add(Integer.valueOf(i));
                    }
                    b("HistoryInfo", gg);
                    break;
                case 3:
                    if (i == 3) {
                        edit.remove("CurrentType").remove("CurrentShowType").remove("CurrentData").commit();
                        break;
                    }
                    break;
            }
            if (this.hmz != null) {
                this.hmz.zm();
            }
        }
    }

    private static boolean b(String str, List<Integer> list) {
        ap.yY();
        SharedPreferences ef = c.ef("banner");
        if (ef == null) {
            return false;
        }
        Editor edit = ef.edit();
        edit.putInt(str + "ArraySize", list.size());
        for (int i = 0; i < list.size(); i++) {
            edit.putInt(str + i, ((Integer) list.get(i)).intValue());
        }
        return edit.commit();
    }

    private static List<Integer> gg(String str) {
        ap.yY();
        SharedPreferences ef = c.ef("banner");
        if (ef == null) {
            return null;
        }
        int i = ef.getInt(str + "ArraySize", 0);
        List<Integer> arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(Integer.valueOf(ef.getInt(str + i2, 0)));
        }
        return arrayList;
    }

    public static int zl() {
        try {
            ap.yY();
            String str = (String) c.vr().get(4097, (Object) "");
            ap.yY();
            String str2 = (String) c.vr().get(6, (Object) "");
            boolean yo = m.yo();
            w.d("MicorMsg.MainFrameBannerStorage", "isUpload " + yo + " stat " + m.xP());
            if (str == null || str.length() <= 0) {
                str = null;
            }
            if (str2 == null || str2.length() <= 0) {
                str2 = null;
            }
            if (str == null && r1 == null) {
                return a.hmB;
            }
            if (str != null && r1 == null) {
                return a.hmC;
            }
            if (yo) {
                return a.hmD;
            }
            return a.hmE;
        } catch (Exception e) {
            return a.hmB;
        }
    }
}
