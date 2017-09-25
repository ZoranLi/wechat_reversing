package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.plugin.wear.model.a;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicInteger;

public final class r {
    private static AtomicInteger rUH = new AtomicInteger();

    public static void a(int i, byte[] bArr, boolean z) {
        if (z) {
            bArr = a.bvG().rTo.aQ(bArr);
        }
        int incrementAndGet = rUH.incrementAndGet();
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeInt(0);
            dataOutputStream.writeInt(incrementAndGet);
            dataOutputStream.writeInt(i);
            if (bArr == null || bArr.length <= 0) {
                dataOutputStream.writeInt(0);
            } else {
                dataOutputStream.writeInt(bArr.length);
                dataOutputStream.write(bArr);
            }
            a.bvG().rTo.aO(byteArrayOutputStream.toByteArray());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Wear.WearPushServerLogic", e, "gen response data error connectType=%d, sessionId=%d, funId=%d", new Object[]{Integer.valueOf(0), Integer.valueOf(incrementAndGet), Integer.valueOf(i)});
        }
    }
}
