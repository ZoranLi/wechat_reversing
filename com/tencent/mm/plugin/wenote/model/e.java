package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class e {
    public static String U(float f) {
        if (f < 1024.0f) {
            return String.format("%.1fB", new Object[]{Float.valueOf(f)});
        } else if (f < 1048576.0f) {
            return String.format("%.1fKB", new Object[]{Float.valueOf(f / 1024.0f)});
        } else if (f < 1.07374182E9f) {
            return String.format("%.1fMB", new Object[]{Float.valueOf((f / 1024.0f) / 1024.0f)});
        } else {
            return String.format("%.1fGB", new Object[]{Float.valueOf(((f / 1024.0f) / 1024.0f) / 1024.0f)});
        }
    }

    public static float aw(long j) {
        float f = 1.0f;
        float f2 = ((float) j) / 1000.0f;
        if (f2 >= 1.0f) {
            f = f2;
        }
        return ((float) Math.round(f * 10.0f)) / 10.0f;
    }

    public static String J(Context context, int i) {
        b fpVar = new fp();
        fpVar.fKp.type = 21;
        fpVar.fKp.context = context;
        fpVar.fKp.fKx = i;
        a.urY.m(fpVar);
        return fpVar.fKq.path;
    }

    public static String Lj(String str) {
        return g.n((str + 18 + System.currentTimeMillis()).getBytes());
    }

    public static String h(rm rmVar) {
        b fpVar = new fp();
        fpVar.fKp.type = 27;
        fpVar.fKp.fKr = rmVar;
        a.urY.m(fpVar);
        return fpVar.fKq.fKz;
    }

    public static String o(rm rmVar) {
        b fpVar = new fp();
        fpVar.fKp.type = 27;
        fpVar.fKp.fKr = rmVar;
        a.urY.m(fpVar);
        return fpVar.fKq.path;
    }

    public static void r(long j, String str) {
        if (j > 0) {
            b fpVar = new fp();
            fpVar.fKp.type = 34;
            fpVar.fKp.fFx = j;
            a.urY.m(fpVar);
            if (fpVar.fKp.fFC != null && fpVar.fKp.fFC.tzn != null && fpVar.fKp.fFC.tzn.size() > 1 && ((rm) fpVar.fKp.fFC.tzn.get(0)).tyk == null) {
                w.i("MicroMsg.WNNoteFavLogic", "Note: Htmlid is null,  do updateFavitemHtmlidStorage");
                if (!bg.mA(str) && com.tencent.mm.a.e.aO(str)) {
                    try {
                        a(fpVar.fKp.fFC, j, bg.convertStreamToString(new FileInputStream(str)));
                    } catch (FileNotFoundException e) {
                        w.e("MicroMsg.WNNoteFavLogic", "Note: FileNotFoundException :%s", new Object[]{e.getMessage()});
                    }
                }
            }
        }
    }

    private static void a(rv rvVar, long j, String str) {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        if (!bg.mA(str) && str.length() != 0) {
            int indexOf;
            Matcher matcher = Pattern.compile("<object[^>]*>", 2).matcher(str);
            String str2 = "WeNote_";
            while (matcher.find()) {
                String group = matcher.group();
                int indexOf2 = group.indexOf(str2);
                if (indexOf2 == -1) {
                    break;
                }
                int indexOf3 = group.indexOf("\"", indexOf2 + 1);
                if (indexOf3 == -1) {
                    break;
                }
                indexOf = group.indexOf(" ", indexOf2 + 1);
                if (indexOf == -1) {
                    break;
                }
                if (indexOf3 >= indexOf) {
                    indexOf3 = indexOf;
                }
                arrayList.add(group.substring(indexOf2, indexOf3));
            }
            LinkedList linkedList = new LinkedList();
            Iterator it = rvVar.tzn.iterator();
            indexOf = 0;
            while (it.hasNext()) {
                rm rmVar = (rm) it.next();
                if (i == 0) {
                    rmVar.Oi("WeNoteHtmlFile");
                    i++;
                    linkedList.add(rmVar);
                } else {
                    if (rmVar.aMw == 1) {
                        rmVar.Oi("-1");
                    } else {
                        int i2 = indexOf + 1;
                        rmVar.Oi((String) arrayList.get(indexOf));
                        indexOf = i2;
                    }
                    linkedList.add(rmVar);
                }
            }
            b fpVar = new fp();
            fpVar.fKp.type = 33;
            fpVar.fKp.fFC = rvVar;
            fpVar.fKp.fFC.tzn = linkedList;
            fpVar.fKp.fFx = j;
            a.urY.m(fpVar);
        }
    }

    public static void Z(ArrayList<String> arrayList) {
        int i = 0;
        if (a.bAZ().stz == null) {
            w.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, getWnNoteBase() is null");
            return;
        }
        rv rvVar = a.bAZ().stz.stH;
        List arrayList2 = new ArrayList();
        HashMap hashMap = new HashMap();
        if (rvVar == null) {
            w.e("MicroMsg.WNNoteFavLogic", "sortNoteDataList, protoItem is null");
            return;
        }
        Iterator it = rvVar.tzn.iterator();
        while (it.hasNext()) {
            rm rmVar = (rm) it.next();
            if (!(bg.mA(rmVar.tyk) || rmVar.tyk.contains("WeNoteHtmlFile") || rmVar.tyk.contains("-1"))) {
                arrayList2.add(rmVar.tyk);
                hashMap.put(rmVar.tyk, rmVar);
            }
        }
        if (arrayList.size() == arrayList2.size() && arrayList2.containsAll(arrayList) && arrayList.containsAll(arrayList2)) {
            int i2;
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                if (!((String) arrayList2.get(i3)).trim().equals(((String) arrayList.get(i3)).trim())) {
                    i2 = 1;
                    break;
                }
            }
            i2 = 0;
            if (i2 != 0) {
                LinkedList linkedList = new LinkedList();
                while (i < arrayList.size()) {
                    linkedList.add(hashMap.get(arrayList.get(i)));
                    i++;
                }
                rvVar.av(linkedList);
                bBd();
                hashMap.clear();
                return;
            }
            return;
        }
        arrayList2.removeAll(arrayList);
        if (arrayList2.size() != 0) {
            List<rm> arrayList3 = new ArrayList();
            Iterator it2 = rvVar.tzn.iterator();
            while (it2.hasNext()) {
                rmVar = (rm) it2.next();
                if (arrayList2.contains(rmVar.tyk)) {
                    arrayList3.add(rmVar);
                }
            }
            for (rm rmVar2 : arrayList3) {
                rvVar.tzn.remove(rmVar2);
            }
            bBd();
        }
    }

    public static void bBd() {
        b fpVar = new fp();
        fpVar.fKp.type = 30;
        if (a.bAZ().stz != null) {
            fpVar.fKp.fFC = a.bAZ().stz.stH;
            a.urY.m(fpVar);
            a.bAZ().stz.Lh(fpVar.fKq.path);
        }
    }
}
