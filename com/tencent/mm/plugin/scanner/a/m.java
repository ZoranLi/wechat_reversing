package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.e.a.ak;
import com.tencent.mm.e.a.lw;
import com.tencent.mm.e.a.lx;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.plugin.z.a.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class m {
    public c oWE = new c<lw>(this) {
        final /* synthetic */ m oWH;

        {
            this.oWH = r2;
            this.usg = lw.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            return this.oWH.h((lw) bVar);
        }
    };
    public c oWF = new c<ak>(this) {
        final /* synthetic */ m oWH;

        {
            this.oWH = r2;
            this.usg = ak.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            return this.oWH.h((ak) bVar);
        }
    };
    a oWG = new a(this) {
        final /* synthetic */ m oWH;

        {
            this.oWH = r1;
        }

        public final void i(String str, String str2, int i, int i2) {
            w.i("MicroMsg.RecogQBarOfImageFileListener", "result: %s, codeType: %s, codeVersion: %s, filePath:%s", new Object[]{str2, Integer.valueOf(i), Integer.valueOf(i2), str});
            l.oWo.aEK();
            b lyVar = new ly();
            lyVar.fTe.filePath = str;
            lyVar.fTe.result = str2;
            lyVar.fTe.fFo = i;
            lyVar.fTe.fFp = i2;
            com.tencent.mm.sdk.b.a.urY.m(lyVar);
        }

        public final void Dd(String str) {
            w.i("MicroMsg.RecogQBarOfImageFileListener", "result(failed): %s", new Object[]{str});
            b lxVar = new lx();
            lxVar.fTd.filePath = str;
            com.tencent.mm.sdk.b.a.urY.m(lxVar);
        }
    };

    public final boolean h(b bVar) {
        if (bVar != null) {
            if (bVar instanceof lw) {
                l.oWo.reset();
                l.oWo.sd(l.oWn);
                lw lwVar = (lw) bVar;
                com.tencent.mm.plugin.scanner.c.aXW().oVz.a(lwVar.fTb.filePath, this.oWG, lwVar.fTb.fTc);
            } else if (bVar instanceof ak) {
                l.oWo.aEK();
                ak akVar = (ak) bVar;
                com.tencent.mm.plugin.z.a.b bVar2 = com.tencent.mm.plugin.scanner.c.aXW().oVz;
                String str = akVar.fDL.filePath;
                w.i("MicroMsg.FileScanQueueService", "cancelDecode, fileUri: %s, callback: %x", new Object[]{str, Integer.valueOf(this.oWG.hashCode())});
                if (bg.mA(str)) {
                    w.e("MicroMsg.FileScanQueueService", "cancel failed, uri is null or nil");
                } else {
                    bVar2.jiB.post(new com.tencent.mm.plugin.z.a.b.AnonymousClass2(bVar2, str, r2));
                }
            }
        }
        return false;
    }
}
