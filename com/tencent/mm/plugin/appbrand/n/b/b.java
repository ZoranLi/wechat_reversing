package com.tencent.mm.plugin.appbrand.n.b;

import com.tencent.mm.plugin.appbrand.n.d.c;
import com.tencent.mm.plugin.appbrand.n.d.d;
import com.tencent.mm.plugin.appbrand.n.d.e;
import com.tencent.mm.plugin.appbrand.n.e.f;
import com.tencent.mm.plugin.appbrand.n.e.h;
import com.tencent.mm.plugin.appbrand.n.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class b extends a {
    private ByteBuffer jpu;
    private d jpv = null;
    private final Random jpw = new Random();

    private class a extends Throwable {
        int jpx;
        final /* synthetic */ b jpy;

        public a(b bVar, int i) {
            this.jpy = bVar;
            this.jpx = i;
        }
    }

    public static int c(f fVar) {
        int i = -1;
        String rc = fVar.rc("Sec-WebSocket-Version");
        if (rc.length() > 0) {
            try {
                i = new Integer(rc.trim()).intValue();
            } catch (NumberFormatException e) {
            }
        }
        return i;
    }

    public final com.tencent.mm.plugin.appbrand.n.b.a.b a(com.tencent.mm.plugin.appbrand.n.e.a aVar, h hVar) {
        int i = 1;
        String rc = aVar.rc("Sec-WebSocket-Protocol");
        String rc2 = hVar.rc("Sec-WebSocket-Protocol");
        if (!(bg.mA(rc) || bg.mA(rc2))) {
            w.d("MicroMsg.AppBrandNetWork.Draft_10", "respProtocol is %s", new Object[]{rc2});
            for (Object equals : rc.split(", ")) {
                if (rc2.equals(equals)) {
                    break;
                }
            }
            i = 0;
            if (i == 0) {
                return com.tencent.mm.plugin.appbrand.n.b.a.b.NOT_MATCHED;
            }
        }
        if (!aVar.rd("Sec-WebSocket-Key") || !hVar.rd("Sec-WebSocket-Accept")) {
            return com.tencent.mm.plugin.appbrand.n.b.a.b.NOT_MATCHED;
        }
        if (qZ(aVar.rc("Sec-WebSocket-Key")).equals(hVar.rc("Sec-WebSocket-Accept"))) {
            return com.tencent.mm.plugin.appbrand.n.b.a.b.MATCHED;
        }
        return com.tencent.mm.plugin.appbrand.n.b.a.b.NOT_MATCHED;
    }

    public com.tencent.mm.plugin.appbrand.n.b.a.b a(com.tencent.mm.plugin.appbrand.n.e.a aVar) {
        int c = c(aVar);
        if (c != 7 && c != 8) {
            return com.tencent.mm.plugin.appbrand.n.b.a.b.NOT_MATCHED;
        }
        Object obj = (aVar.rc("Upgrade").equalsIgnoreCase("websocket") && aVar.rc("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade")) ? 1 : null;
        return obj != null ? com.tencent.mm.plugin.appbrand.n.b.a.b.MATCHED : com.tencent.mm.plugin.appbrand.n.b.a.b.NOT_MATCHED;
    }

    public final ByteBuffer d(d dVar) {
        int i;
        int i2;
        int i3 = -128;
        int i4 = 0;
        ByteBuffer XW = dVar.XW();
        int i5 = this.joP == com.tencent.mm.plugin.appbrand.n.a.b.joB ? 1 : 0;
        int i6 = XW.remaining() <= 125 ? 1 : XW.remaining() <= 65535 ? 2 : 8;
        if (i6 > 1) {
            i = i6 + 1;
        } else {
            i = i6;
        }
        ByteBuffer allocate = ByteBuffer.allocate(((i5 != 0 ? 4 : 0) + (i + 1)) + XW.remaining());
        com.tencent.mm.plugin.appbrand.n.d.d.a XZ = dVar.XZ();
        if (XZ == com.tencent.mm.plugin.appbrand.n.d.d.a.CONTINUOUS) {
            i = 0;
        } else if (XZ == com.tencent.mm.plugin.appbrand.n.d.d.a.TEXT) {
            i = 1;
        } else if (XZ == com.tencent.mm.plugin.appbrand.n.d.d.a.BINARY) {
            i = 2;
        } else if (XZ == com.tencent.mm.plugin.appbrand.n.d.d.a.CLOSING) {
            i = 8;
        } else if (XZ == com.tencent.mm.plugin.appbrand.n.d.d.a.PING) {
            i = 9;
        } else if (XZ == com.tencent.mm.plugin.appbrand.n.d.d.a.PONG) {
            i = 10;
        } else {
            w.e("MicroMsg.AppBrandNetWork.Draft_10", "Don't know how to handle force close" + XZ.toString());
            i = 8;
        }
        if (dVar.XX()) {
            i2 = -128;
        } else {
            i2 = 0;
        }
        allocate.put((byte) (i | ((byte) i2)));
        byte[] h = h((long) XW.remaining(), i6);
        if (i6 == 1) {
            byte b = h[0];
            if (i5 == 0) {
                i3 = 0;
            }
            allocate.put((byte) (b | i3));
        } else if (i6 == 2) {
            if (i5 == 0) {
                i3 = 0;
            }
            allocate.put((byte) (i3 | 126));
            allocate.put(h);
        } else if (i6 == 8) {
            if (i5 == 0) {
                i3 = 0;
            }
            allocate.put((byte) (i3 | 127));
            allocate.put(h);
        } else {
            w.e("MicroMsg.AppBrandNetWork.Draft_10", "Size representation not supported/specified");
        }
        if (i5 != 0) {
            ByteBuffer allocate2 = ByteBuffer.allocate(4);
            allocate2.putInt(this.jpw.nextInt());
            allocate.put(allocate2.array());
            while (XW.hasRemaining()) {
                allocate.put((byte) (XW.get() ^ allocate2.get(i4 % 4)));
                i4++;
            }
        } else {
            allocate.put(XW);
        }
        allocate.flip();
        return allocate;
    }

    public final List<d> a(ByteBuffer byteBuffer, boolean z) {
        c eVar = new e();
        try {
            eVar.l(byteBuffer);
        } catch (com.tencent.mm.plugin.appbrand.n.c.b e) {
            w.e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + e.toString());
        }
        eVar.cj(true);
        eVar.a(com.tencent.mm.plugin.appbrand.n.d.d.a.BINARY);
        eVar.ck(z);
        return Collections.singletonList(eVar);
    }

    public final List<d> M(String str, boolean z) {
        c eVar = new e();
        try {
            eVar.l(ByteBuffer.wrap(com.tencent.mm.plugin.appbrand.n.f.b.re(str)));
        } catch (com.tencent.mm.plugin.appbrand.n.c.b e) {
            w.e("MicroMsg.AppBrandNetWork.Draft_10", "createFrames setPayload exception" + e.toString());
        }
        eVar.cj(true);
        eVar.a(com.tencent.mm.plugin.appbrand.n.d.d.a.TEXT);
        eVar.ck(z);
        return Collections.singletonList(eVar);
    }

    private static String qZ(String str) {
        String str2 = str.trim() + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
        try {
            return com.tencent.mm.plugin.appbrand.n.f.a.M(MessageDigest.getInstance("SHA1").digest(str2.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            w.e("MicroMsg.AppBrandNetWork.Draft_10", "not such algorithm " + e.toString());
            return "";
        }
    }

    public com.tencent.mm.plugin.appbrand.n.e.b a(com.tencent.mm.plugin.appbrand.n.e.b bVar) {
        bVar.put("Upgrade", "websocket");
        bVar.put("Connection", "Upgrade");
        bVar.put("Sec-WebSocket-Version", "8");
        byte[] bArr = new byte[16];
        this.jpw.nextBytes(bArr);
        bVar.put("Sec-WebSocket-Key", com.tencent.mm.plugin.appbrand.n.f.a.M(bArr));
        return bVar;
    }

    public com.tencent.mm.plugin.appbrand.n.e.c a(com.tencent.mm.plugin.appbrand.n.e.a aVar, i iVar) {
        iVar.put("Upgrade", "websocket");
        iVar.put("Connection", aVar.rc("Connection"));
        iVar.rb("Switching Protocols");
        String rc = aVar.rc("Sec-WebSocket-Key");
        if (rc == null) {
            throw new com.tencent.mm.plugin.appbrand.n.c.d("missing Sec-WebSocket-Key");
        }
        iVar.put("Sec-WebSocket-Accept", qZ(rc));
        return iVar;
    }

    private static byte[] h(long j, int i) {
        byte[] bArr = new byte[i];
        int i2 = (i * 8) - 8;
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ((int) (j >>> (i2 - (i3 * 8))));
        }
        return bArr;
    }

    public final List<d> i(ByteBuffer byteBuffer) {
        while (true) {
            List<d> linkedList = new LinkedList();
            if (this.jpu == null) {
                break;
            }
            try {
                break;
            } catch (a e) {
                this.jpu.limit();
                ByteBuffer allocate = ByteBuffer.allocate(a.iF(e.jpx));
                this.jpu.rewind();
                allocate.put(this.jpu);
                this.jpu = allocate;
            }
        }
        byteBuffer.mark();
        int remaining = byteBuffer.remaining();
        int remaining2 = this.jpu.remaining();
        if (remaining2 > remaining) {
            this.jpu.put(byteBuffer.array(), byteBuffer.position(), remaining);
            byteBuffer.position(remaining + byteBuffer.position());
            return Collections.emptyList();
        }
        this.jpu.put(byteBuffer.array(), byteBuffer.position(), remaining2);
        byteBuffer.position(byteBuffer.position() + remaining2);
        linkedList.add(k((ByteBuffer) this.jpu.duplicate().position(0)));
        this.jpu = null;
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(k(byteBuffer));
            } catch (a e2) {
                byteBuffer.reset();
                this.jpu = ByteBuffer.allocate(a.iF(e2.jpx));
                this.jpu.put(byteBuffer);
            }
        }
        return linkedList;
    }

    private d k(ByteBuffer byteBuffer) {
        int i = 10;
        int i2 = 0;
        int remaining = byteBuffer.remaining();
        if (remaining < 2) {
            throw new a(this, 2);
        }
        boolean z;
        byte b = byteBuffer.get();
        if ((b >> 8) != 0) {
            z = true;
        } else {
            z = false;
        }
        byte b2 = (byte) ((b & 127) >> 4);
        if (b2 != (byte) 0) {
            throw new com.tencent.mm.plugin.appbrand.n.c.c("bad rsv " + b2);
        }
        int i3;
        com.tencent.mm.plugin.appbrand.n.d.d.a aVar;
        b2 = byteBuffer.get();
        if ((b2 & -128) != 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        b2 = (byte) (b2 & 127);
        b = (byte) (b & 15);
        switch (b) {
            case (byte) 0:
                aVar = com.tencent.mm.plugin.appbrand.n.d.d.a.CONTINUOUS;
                break;
            case (byte) 1:
                aVar = com.tencent.mm.plugin.appbrand.n.d.d.a.TEXT;
                break;
            case (byte) 2:
                aVar = com.tencent.mm.plugin.appbrand.n.d.d.a.BINARY;
                break;
            case (byte) 8:
                aVar = com.tencent.mm.plugin.appbrand.n.d.d.a.CLOSING;
                break;
            case (byte) 9:
                aVar = com.tencent.mm.plugin.appbrand.n.d.d.a.PING;
                break;
            case (byte) 10:
                aVar = com.tencent.mm.plugin.appbrand.n.d.d.a.PONG;
                break;
            default:
                throw new com.tencent.mm.plugin.appbrand.n.c.c("unknow optcode " + ((short) b));
        }
        if (z || !(aVar == com.tencent.mm.plugin.appbrand.n.d.d.a.PING || aVar == com.tencent.mm.plugin.appbrand.n.d.d.a.PONG || aVar == com.tencent.mm.plugin.appbrand.n.d.d.a.CLOSING)) {
            int intValue;
            int i4;
            byte b3;
            if (b2 >= (byte) 0 && b2 <= (byte) 125) {
                i = 2;
                b3 = b2;
            } else if (aVar == com.tencent.mm.plugin.appbrand.n.d.d.a.PING || aVar == com.tencent.mm.plugin.appbrand.n.d.d.a.PONG || aVar == com.tencent.mm.plugin.appbrand.n.d.d.a.CLOSING) {
                throw new com.tencent.mm.plugin.appbrand.n.c.c("more than 125 octets");
            } else if (b2 == (byte) 126) {
                if (remaining < 4) {
                    throw new a(this, 4);
                }
                byte[] bArr = new byte[3];
                bArr[1] = byteBuffer.get();
                bArr[2] = byteBuffer.get();
                intValue = new BigInteger(bArr).intValue();
                i = 4;
            } else if (remaining < 10) {
                throw new a(this, 10);
            } else {
                byte[] bArr2 = new byte[8];
                for (intValue = 0; intValue < 8; intValue++) {
                    bArr2[intValue] = byteBuffer.get();
                }
                long longValue = new BigInteger(bArr2).longValue();
                if (longValue > 2147483647L) {
                    w.e("MicroMsg.AppBrandNetWork.Draft_10", "Payloadsize is to big...");
                    b3 = b2;
                } else {
                    intValue = (int) longValue;
                }
            }
            if (i3 != 0) {
                i4 = 4;
            } else {
                i4 = 0;
            }
            i4 = (i4 + i) + intValue;
            if (remaining < i4) {
                throw new a(this, i4);
            }
            d bVar;
            ByteBuffer allocate = ByteBuffer.allocate(a.iF(intValue));
            if (i3 != 0) {
                byte[] bArr3 = new byte[4];
                byteBuffer.get(bArr3);
                while (i2 < intValue) {
                    allocate.put((byte) (byteBuffer.get() ^ bArr3[i2 % 4]));
                    i2++;
                }
            } else {
                allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                byteBuffer.position(byteBuffer.position() + allocate.limit());
            }
            if (aVar == com.tencent.mm.plugin.appbrand.n.d.d.a.CLOSING) {
                bVar = new com.tencent.mm.plugin.appbrand.n.d.b();
            } else {
                bVar = new e();
                bVar.cj(z);
                bVar.a(aVar);
            }
            allocate.flip();
            bVar.l(allocate);
            return bVar;
        }
        throw new com.tencent.mm.plugin.appbrand.n.c.c("control frames may no be fragmented");
    }

    public final void reset() {
        this.jpu = null;
    }

    public a XU() {
        return new b();
    }

    public final int XT() {
        return com.tencent.mm.plugin.appbrand.n.b.a.a.jpp;
    }
}
