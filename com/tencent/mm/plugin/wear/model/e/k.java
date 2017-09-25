package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.protocal.c.bob;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class k extends a {
    public final List<Integer> bvW() {
        List<Integer> arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(11011));
        arrayList.add(Integer.valueOf(11010));
        return arrayList;
    }

    protected final byte[] l(int i, byte[] bArr) {
        switch (i) {
            case 11010:
                bob com_tencent_mm_protocal_c_bob = new bob();
                try {
                    com_tencent_mm_protocal_c_bob.aD(bArr);
                } catch (IOException e) {
                }
                a.bvG().rTq.bZ(com_tencent_mm_protocal_c_bob.umH, com_tencent_mm_protocal_c_bob.umT);
                break;
            case 11011:
                String str;
                String str2 = "";
                try {
                    str = new String(bArr, "utf8");
                } catch (UnsupportedEncodingException e2) {
                    str = str2;
                }
                ap.yY();
                x Rc = c.wR().Rc(str);
                if (o.dH(str)) {
                    ap.yY();
                    Rc = c.wR().Rc(str);
                    Rc.dm(0);
                    ap.yY();
                    c.wR().a(str, Rc);
                    ap.yY();
                    c.wQ().b(new com.tencent.mm.ao.k(str, 0));
                } else {
                    o.n(Rc);
                }
                com.tencent.mm.plugin.wear.model.c.a.dv(4, 0);
                break;
        }
        return null;
    }
}
