package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import com.tencent.mm.a.n;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayOutputStream;
import java.util.zip.CRC32;

public final class b {
    public static int a(byte[] bArr, int i, short s, short s2, int i2, byte[] bArr2) {
        int i3 = 0;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(n.cP(i));
            byteArrayOutputStream.write(new byte[]{(byte) ((s >> 8) & 255), (byte) (s & 255)});
            byteArrayOutputStream.write(new byte[]{(byte) ((s2 >> 8) & 255), (byte) (s2 & 255)});
            byteArrayOutputStream.write(n.cP(i2));
            byteArrayOutputStream.write(n.cP(0));
            byteArrayOutputStream.write(bArr2);
            CRC32 crc32 = new CRC32();
            crc32.update(byteArrayOutputStream.toByteArray());
            return (int) crc32.getValue();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.BakOldPacker", e, "", new Object[i3]);
            return i3;
        }
    }

    public static String Q(byte[] bArr) {
        String str = "";
        r0 = bArr.length > 100 ? bArr.length - 100 : 0;
        while (r0 < bArr.length) {
            str = str + Integer.toHexString(bArr[r0] & 255) + " ";
            r0++;
        }
        w.e("MicroMsg.BakOldPacker", "dump errBuf: %s", new Object[]{str});
        return str;
    }
}
