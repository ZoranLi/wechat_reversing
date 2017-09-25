package com.tencent.mm.plugin.ipcall.a;

import com.tencent.mm.e.a.hw;
import com.tencent.mm.protocal.c.art;
import com.tencent.mm.protocal.c.asc;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.LinkedList;

public final class h extends c<hw> {
    public a mNi;

    public interface a {
        void a(art com_tencent_mm_protocal_c_art);
    }

    public h() {
        this.usg = hw.class.getName().hashCode();
    }

    private boolean a(hw hwVar) {
        if (hwVar instanceof hw) {
            Object obj = hwVar.fNx.fNy;
            if (obj != null && obj.length > 0 && obj[0] == (byte) 101) {
                Object obj2 = new byte[(obj.length - 1)];
                System.arraycopy(obj, 1, obj2, 0, obj2.length);
                try {
                    art com_tencent_mm_protocal_c_art = (art) new art().aD(obj2);
                    w.d("MicroMsg.IPCallSvrNotifyListener", "roomId: %d, roomKey: %d, DtmfPayloadType: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_art.tvL), Long.valueOf(com_tencent_mm_protocal_c_art.tvM), Integer.valueOf(com_tencent_mm_protocal_c_art.mOh)});
                    LinkedList linkedList = com_tencent_mm_protocal_c_art.tWo;
                    if (linkedList != null) {
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            asc com_tencent_mm_protocal_c_asc = (asc) it.next();
                            w.d("MicroMsg.IPCallSvrNotifyListener", "userstatus: %d, userstatusKey: %d, memberId: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_asc.tVh), Integer.valueOf(com_tencent_mm_protocal_c_asc.tWy), Integer.valueOf(com_tencent_mm_protocal_c_asc.tWx)});
                        }
                    }
                    if (this.mNi != null) {
                        this.mNi.a(com_tencent_mm_protocal_c_art);
                    }
                } catch (Exception e) {
                    w.e("MicroMsg.IPCallSvrNotifyListener", "parse PstnNotify error: %s", new Object[]{e.getMessage()});
                }
            }
        }
        return false;
    }
}
