package com.tencent.mm.plugin.fts.d;

import android.content.Context;
import android.util.SparseArray;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class h {
    private static a mcK = new a();

    public static class a {
        boolean isReady;
        g mcL;
        public SparseArray<b> mcM = new SparseArray();

        public final synchronized void a(b bVar) {
            this.mcM.put(bVar.getType(), bVar);
        }

        public final synchronized void mV(int i) {
            this.mcM.remove(i);
        }
    }

    public interface b extends Comparable<b> {
        i a(Context context, com.tencent.mm.plugin.fts.d.i.b bVar, int i);

        int getPriority();

        int getType();
    }

    public static void a(b bVar) {
        mcK.a(bVar);
    }

    public static void mV(int i) {
        mcK.mV(i);
    }

    public static void a(g gVar) {
        a aVar = mcK;
        aVar.mcL = gVar;
        aVar.isReady = true;
    }

    public static void ayd() {
        a aVar = mcK;
        if (aVar.mcL != null) {
            aVar.mcL.ayc();
            aVar.mcL = null;
        }
        aVar.isReady = false;
    }

    public static g aye() {
        return mcK.mcL;
    }

    public static LinkedList<i> a(HashSet<Integer> hashSet, Context context, com.tencent.mm.plugin.fts.d.i.b bVar, int i) {
        LinkedList<i> linkedList = new LinkedList();
        Object linkedList2 = new LinkedList();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            b bVar2 = (b) mcK.mcM.get(((Integer) it.next()).intValue());
            if (bVar2 != null) {
                linkedList2.add(bVar2);
            }
        }
        Collections.sort(linkedList2);
        Iterator it2 = linkedList2.iterator();
        while (it2.hasNext()) {
            linkedList.add(((b) it2.next()).a(context, bVar, i));
        }
        return linkedList;
    }

    public static i a(int i, Context context, com.tencent.mm.plugin.fts.d.i.b bVar, int i2) {
        b bVar2 = (b) mcK.mcM.get(i);
        if (bVar2 != null) {
            return bVar2.a(context, bVar, i2);
        }
        return null;
    }
}
