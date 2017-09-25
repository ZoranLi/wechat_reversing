package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.content.Context;
import android.text.ClipboardManager;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.wenote.b.b;
import com.tencent.mm.plugin.wenote.model.a.a;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class f {
    private static ArrayList<a> jjQ;

    public static void ac(ArrayList<a> arrayList) {
        if (jjQ != null) {
            jjQ.clear();
        }
        jjQ = arrayList;
        Set hashSet = new HashSet();
        Iterator it = jjQ.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            String d = b.d(aVar);
            if (!bg.mA(d)) {
                hashSet.add(d);
            }
            String e = b.e(aVar);
            if (!bg.mA(e)) {
                hashSet.add(e);
            }
        }
        com.tencent.mm.ay.a.idW = hashSet;
    }

    public static ArrayList<a> bBG() {
        ArrayList<a> arrayList = new ArrayList();
        Iterator it = jjQ.iterator();
        while (it.hasNext()) {
            Object obj;
            a c = b.c((a) it.next());
            if (c == null) {
                obj = null;
            } else {
                Object obj2 = 1;
                int type = c.getType();
                if (type == 2 || type == 6 || type == 4 || type == 5) {
                    String d = b.d(c);
                    if (bg.mA(d) || !FileOp.aO(d)) {
                        obj2 = null;
                    }
                }
                if (type == 2 || type == 6) {
                    String e = b.e(c);
                    if (bg.mA(e) || !FileOp.aO(e)) {
                        obj2 = null;
                    }
                }
                if (obj2 != null) {
                    k kVar = (k) c;
                    if (kVar.suH != null) {
                        kVar.suH.NY(kVar.lKv);
                        kVar.suH.Oi(kVar.suI);
                    }
                }
                obj = obj2;
            }
            if (obj != null) {
                arrayList.add(c);
            }
        }
        return arrayList;
    }

    public static boolean bBH() {
        if (jjQ == null || jjQ.size() <= 0) {
            return false;
        }
        return true;
    }

    public static void QZ() {
        if (jjQ != null) {
            jjQ.clear();
        }
        com.tencent.mm.ay.a.idW = null;
    }

    public static boolean dj(Context context) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
        if (clipboardManager == null) {
            return false;
        }
        if (clipboardManager.getText() == null) {
            return false;
        }
        if (clipboardManager.getText().length() <= 0) {
            return false;
        }
        return true;
    }
}
