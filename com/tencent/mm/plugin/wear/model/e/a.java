package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.List;

public abstract class a {
    public abstract List<Integer> bvW();

    protected abstract byte[] l(int i, byte[] bArr);

    public final void b(int i, int i2, int i3, byte[] bArr) {
        if (vL(i3) && bArr != null) {
            bArr = com.tencent.mm.plugin.wear.model.a.bvG().rTo.aP(bArr);
            if (bArr == null) {
                w.e("MicroMsg.Wear.BaseHttpServer", "request data decrypt error");
                return;
            }
        }
        byte[] l = l(i3, bArr);
        if (bvX()) {
            if (vK(i3)) {
                l = com.tencent.mm.plugin.wear.model.a.bvG().rTo.aQ(l);
            }
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            try {
                dataOutputStream.writeInt(i);
                dataOutputStream.writeInt(i2);
                dataOutputStream.writeInt(i3);
                if (l == null || l.length <= 0) {
                    dataOutputStream.writeInt(0);
                } else {
                    dataOutputStream.writeInt(l.length);
                    dataOutputStream.write(l);
                }
                l = byteArrayOutputStream.toByteArray();
                w.i("MicroMsg.Wear.BaseHttpServer", "send data funId=%d length=%d", new Object[]{Integer.valueOf(i3), Integer.valueOf(l.length)});
                if (vM(i3)) {
                    e.post(new Runnable(this) {
                        final /* synthetic */ a rUq;

                        public final void run() {
                            com.tencent.mm.plugin.wear.model.a.bvG().rTo.aO(l);
                        }
                    }, "WearSendResponseTask");
                } else {
                    com.tencent.mm.plugin.wear.model.a.bvG().rTo.aO(l);
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.Wear.BaseHttpServer", e, "gen response data error connectType=%d, sessionId=%d, funId=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
            }
        }
    }

    protected boolean vK(int i) {
        return false;
    }

    protected boolean vL(int i) {
        return false;
    }

    public boolean vM(int i) {
        return false;
    }

    public boolean bvX() {
        return true;
    }
}
