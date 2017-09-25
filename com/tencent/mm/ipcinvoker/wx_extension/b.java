package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.g;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;

public final class b {

    public interface a {
        void a(int i, int i2, String str, com.tencent.mm.y.b bVar);
    }

    private static final class b implements g<com.tencent.mm.y.b, IPCRunCgiRespWrapper> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, final h hVar) {
            com.tencent.mm.y.b bVar = (com.tencent.mm.y.b) obj;
            if (bVar == null || bVar.hsk.hsr.getClass() == com.tencent.mm.bd.a.class) {
                w.e("MicroMsg.IPCRunCgi", "InvokeTask, mm received invalid rr %s", new Object[]{bVar});
                hVar.ak(IPCRunCgiRespWrapper.ux());
                return;
            }
            u.a(bVar, new com.tencent.mm.y.u.a(this) {
                final /* synthetic */ b gWx;

                public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                    if (hVar != null) {
                        IPCRunCgiRespWrapper iPCRunCgiRespWrapper = new IPCRunCgiRespWrapper();
                        iPCRunCgiRespWrapper.errType = i;
                        iPCRunCgiRespWrapper.errCode = i2;
                        iPCRunCgiRespWrapper.fPf = str;
                        iPCRunCgiRespWrapper.gUA = bVar;
                        hVar.ak(iPCRunCgiRespWrapper);
                    }
                    return 0;
                }
            }, true);
        }
    }

    public static void a(com.tencent.mm.y.b bVar, final a aVar) {
        if (ab.bJb()) {
            u.a(bVar, new com.tencent.mm.y.u.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.y.b bVar, k kVar) {
                    if (aVar != null) {
                        aVar.a(i, i2, str, bVar);
                    }
                    return 0;
                }
            }, true);
        } else {
            XIPCInvoker.a("com.tencent.mm", bVar, b.class, new h<IPCRunCgiRespWrapper>() {
                public final /* synthetic */ void ak(Object obj) {
                    IPCRunCgiRespWrapper iPCRunCgiRespWrapper = (IPCRunCgiRespWrapper) obj;
                    if (aVar != null && iPCRunCgiRespWrapper != null) {
                        aVar.a(iPCRunCgiRespWrapper.errType, iPCRunCgiRespWrapper.errCode, iPCRunCgiRespWrapper.fPf, iPCRunCgiRespWrapper.gUA);
                    }
                }
            });
        }
    }
}
