package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.plugin.wear.model.h;
import java.util.ArrayList;
import java.util.List;

public final class n extends a {
    public final List<Integer> bvW() {
        List arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11033));
        arrayList.add(Integer.valueOf(11030));
        return arrayList;
    }

    protected final byte[] l(int i, byte[] bArr) {
        switch (i) {
            case 11030:
                if (new String(bArr).equals("arm_v7")) {
                    return h.II("wechatvoicesilk_v7a");
                }
                return h.II("wechatvoicesilk");
            case 11033:
                return h.II("stlport_shared");
            default:
                return null;
        }
    }
}
