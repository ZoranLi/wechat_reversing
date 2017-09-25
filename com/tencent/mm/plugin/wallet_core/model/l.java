package com.tencent.mm.plugin.wallet_core.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class l<K> {
    List<K> rFA = new LinkedList();
    public Vector<b> rFB = new Vector();
    List<String> rFC = new LinkedList();
    Map<String, Integer> rFz = new HashMap();

    static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] rFD = new int[a.btM().length];

        static {
            try {
                rFD[a.rFG - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                rFD[a.rFF - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                rFD[a.rFE - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public enum a {
        ;

        static {
            rFE = 1;
            rFF = 2;
            rFG = 3;
            rFH = new int[]{rFE, rFF, rFG};
        }

        public static int[] btM() {
            return (int[]) rFH.clone();
        }
    }

    public class b {
        public K rFI;
        public int rFJ;
        final /* synthetic */ l rFK;

        public b(l lVar) {
            this.rFK = lVar;
        }
    }

    public abstract String a(Vector<b> vector, int i);

    public final void c(List<K> list, List<K> list2, List<String> list3) {
        int i;
        this.rFC = list3;
        this.rFA = list2;
        this.rFB.clear();
        this.rFB = new Vector(list.size());
        for (i = 0; i < list.size(); i++) {
            b bVar = new b(this);
            Object obj = list.get(i);
            bVar.rFI = obj;
            if (this.rFA.contains(obj)) {
                bVar.rFJ = a.rFF;
            } else {
                bVar.rFJ = a.rFE;
            }
            this.rFB.add(bVar);
        }
        this.rFz.clear();
        for (i = 0; i < list3.size(); i++) {
            this.rFz.put(list3.get(i), Integer.valueOf(0));
        }
        btL();
    }

    public final void dt(int i, int i2) {
        ((b) this.rFB.get(i)).rFJ = i2;
    }

    public final void btL() {
        for (int i = 0; i < this.rFB.size(); i++) {
            if (((b) this.rFB.get(i)).rFJ != a.rFF) {
                String a = a(this.rFB, i);
                if (!this.rFz.containsKey(a)) {
                    Object obj;
                    String[] Ij = com.tencent.mm.plugin.wallet_core.ui.a.Ij(a);
                    for (int i2 = 0; i2 < this.rFC.size(); i2++) {
                        for (CharSequence contains : Ij) {
                            if (!((String) this.rFC.get(i2)).contains(contains)) {
                                obj = null;
                                break;
                            }
                        }
                        int i3 = 1;
                        if (obj != null) {
                            obj = 1;
                            break;
                        }
                    }
                    obj = null;
                    if (obj == null) {
                        dt(i, a.rFE);
                    }
                }
                dt(i, a.rFG);
            }
        }
    }
}
