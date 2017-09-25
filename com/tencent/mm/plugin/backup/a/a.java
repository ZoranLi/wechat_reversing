package com.tencent.mm.plugin.backup.a;

import java.util.Iterator;
import java.util.LinkedList;

public abstract class a {
    private static String TAG = "MicroMsg.BackupBaseModel";
    private static LinkedList<a> jAV = new LinkedList();

    public abstract void ZY();

    public static void a(a aVar) {
        jAV.add(aVar);
    }

    public static void ZX() {
        Iterator it = jAV.iterator();
        while (it.hasNext()) {
            ((a) it.next()).ZY();
        }
        jAV.clear();
    }
}
