package com.tencent.mm.plugin.fts.a.a;

import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Comparator;
import java.util.HashSet;

public final class f {
    public String fJL = null;
    public String fRM = null;
    public ae handler = null;
    public int lZZ = 0;
    public int[] maa = null;
    public int[] mab = null;
    public int mad = Integer.MAX_VALUE;
    public HashSet<String> mae = new HashSet();
    public Comparator<i> maf = null;
    public j mag = null;
    public int scene = -1;

    public static f a(String str, int[] iArr, int[] iArr2, int i, HashSet<String> hashSet, Comparator<i> comparator, j jVar, ae aeVar) {
        f fVar = new f();
        fVar.fRM = str;
        fVar.fJL = null;
        fVar.maa = iArr;
        fVar.mab = iArr2;
        fVar.mad = i;
        fVar.mae = hashSet;
        fVar.maf = comparator;
        fVar.mag = jVar;
        fVar.handler = aeVar;
        return fVar;
    }
}
