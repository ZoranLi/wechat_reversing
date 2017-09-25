package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.e.a.sl;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import java.util.ArrayList;
import java.util.List;

public final class o extends a {
    public final List<Integer> bvW() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11028));
        arrayList.add(Integer.valueOf(11027));
        return arrayList;
    }

    protected final byte[] l(int i, byte[] bArr) {
        switch (i) {
            case 11027:
                uU(1);
                break;
            case 11028:
                uU(2);
                break;
        }
        return null;
    }

    private static void uU(int i) {
        b slVar = new sl();
        slVar.gad.fEG = i;
        a.urY.m(slVar);
    }
}
