package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmovemodel;

import com.tencent.mm.plugin.backup.bakoldlogic.a.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public final class e implements c {
    public static LinkedList<String> hNf = null;
    public static boolean jDr = false;
    public static ArrayList<a> jKb = new ArrayList();
    public static ArrayList<a> jKc = null;
    public com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.a jJZ;
    public c jKa;
    public aj jKd;
    private Object lock = new Object();

    public static ArrayList<a> abX() {
        return jKb;
    }

    public static void z(LinkedList<String> linkedList) {
        hNf = linkedList;
    }

    public static LinkedList<String> abY() {
        return hNf;
    }

    public static void n(ArrayList<a> arrayList) {
        jKc = arrayList;
    }

    public static ArrayList<a> abZ() {
        return jKc;
    }

    public static boolean aca() {
        return jDr;
    }

    public final void a(long j, long j2, ArrayList<a> arrayList, boolean z) {
        w.i("MicroMsg.BakMoveChooseServer", "onCalcuChooseProgress progress:%d, converSize%d", new Object[]{Long.valueOf(j), Long.valueOf(j2)});
        if (z) {
            jKb = (ArrayList) arrayList.clone();
        }
        if (this.jKa != null) {
            this.jKa.a(j, j2, arrayList, z);
        }
    }

    public final void a(ArrayList<a> arrayList, PLong pLong, PInt pInt) {
        Collections.sort(arrayList);
        jKb = (ArrayList) arrayList.clone();
        jDr = true;
        if (this.jKa != null) {
            this.jKa.a(arrayList, pLong, pInt);
        }
    }
}
