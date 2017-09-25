package com.tencent.mm.plugin.appbrand.n.b;

import com.tencent.mm.plugin.appbrand.n.d.d;
import com.tencent.mm.plugin.appbrand.n.e.c;
import com.tencent.mm.plugin.appbrand.n.e.e;
import com.tencent.mm.plugin.appbrand.n.e.f;
import com.tencent.mm.plugin.appbrand.n.e.h;
import com.tencent.mm.plugin.appbrand.n.e.i;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.wcdb.FileUtils;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class a {
    public static int jpj = 1000;
    public static int jpk = 64;
    public static final byte[] jpl = com.tencent.mm.plugin.appbrand.n.f.b.re("<policy-file-request/>\u0000");
    protected int joP = 0;
    protected com.tencent.mm.plugin.appbrand.n.d.d.a jpm = null;

    public enum a {
        ;

        static {
            jpn = 1;
            jpo = 2;
            jpp = 3;
            jpq = new int[]{jpn, jpo, jpp};
        }
    }

    public enum b {
        MATCHED,
        NOT_MATCHED
    }

    public abstract List<d> M(String str, boolean z);

    public abstract int XT();

    public abstract a XU();

    public abstract b a(com.tencent.mm.plugin.appbrand.n.e.a aVar);

    public abstract b a(com.tencent.mm.plugin.appbrand.n.e.a aVar, h hVar);

    public abstract com.tencent.mm.plugin.appbrand.n.e.b a(com.tencent.mm.plugin.appbrand.n.e.b bVar);

    public abstract c a(com.tencent.mm.plugin.appbrand.n.e.a aVar, i iVar);

    public abstract List<d> a(ByteBuffer byteBuffer, boolean z);

    public abstract ByteBuffer d(d dVar);

    public abstract List<d> i(ByteBuffer byteBuffer);

    public abstract void reset();

    private static String h(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.remaining());
        byte b = (byte) 48;
        while (byteBuffer.hasRemaining()) {
            byte b2 = byteBuffer.get();
            allocate.put(b2);
            if (b == (byte) 13 && b2 == (byte) 10) {
                allocate.limit(allocate.position() - 2);
                allocate.position(0);
                byteBuffer2 = allocate;
                break;
            }
            b = b2;
        }
        byteBuffer.position(byteBuffer.position() - allocate.position());
        byteBuffer2 = null;
        return byteBuffer2 == null ? null : com.tencent.mm.plugin.appbrand.n.f.b.q(byteBuffer2.array(), byteBuffer2.limit());
    }

    public static com.tencent.mm.plugin.appbrand.n.a.b<List> b(f fVar) {
        StringBuilder stringBuilder = new StringBuilder(100);
        if (fVar instanceof com.tencent.mm.plugin.appbrand.n.e.a) {
            stringBuilder.append("GET ");
            stringBuilder.append(((com.tencent.mm.plugin.appbrand.n.e.a) fVar).Ya());
            stringBuilder.append(" HTTP/1.1");
        } else if (fVar instanceof h) {
            stringBuilder.append("HTTP/1.1 101 " + ((h) fVar).Yb());
        } else {
            stringBuilder.append("GET ");
            stringBuilder.append(((com.tencent.mm.plugin.appbrand.n.e.a) fVar).Ya());
            stringBuilder.append(" HTTP/1.1");
            w.e("MicroMsg.AppBrandNetWork.Draft", "unknow role");
        }
        stringBuilder.append("\r\n");
        Iterator Yc = fVar.Yc();
        while (Yc.hasNext()) {
            String str = (String) Yc.next();
            String rc = fVar.rc(str);
            stringBuilder.append(str);
            stringBuilder.append(": ");
            stringBuilder.append(rc);
            stringBuilder.append("\r\n");
        }
        stringBuilder.append("\r\n");
        byte[] rf = com.tencent.mm.plugin.appbrand.n.f.b.rf(stringBuilder.toString());
        byte[] Yd = fVar.Yd();
        ByteBuffer allocate = ByteBuffer.allocate((Yd == null ? 0 : Yd.length) + rf.length);
        allocate.put(rf);
        if (Yd != null) {
            allocate.put(Yd);
        }
        allocate.flip();
        return Collections.singletonList(allocate);
    }

    public final f j(ByteBuffer byteBuffer) {
        int i = this.joP;
        String h = h(byteBuffer);
        if (h == null) {
            throw new com.tencent.mm.plugin.appbrand.n.c.a(byteBuffer.capacity() + FileUtils.S_IWUSR);
        }
        String[] split = h.split(" ", 3);
        if (split.length != 3) {
            throw new com.tencent.mm.plugin.appbrand.n.c.d();
        }
        f eVar;
        if (i == com.tencent.mm.plugin.appbrand.n.a.b.joB) {
            eVar = new e();
            i iVar = (i) eVar;
            iVar.a(Short.parseShort(split[1]));
            iVar.rb(split[2]);
        } else {
            eVar = new com.tencent.mm.plugin.appbrand.n.e.d();
            eVar.ra(split[1]);
        }
        while (true) {
            String h2 = h(byteBuffer);
            if (h2 != null && h2.length() > 0) {
                String[] split2 = h2.split(":", 2);
                if (split2.length != 2) {
                    throw new com.tencent.mm.plugin.appbrand.n.c.d("not an http header");
                }
                eVar.put(split2[0], split2[1].replaceFirst("^ +", ""));
            } else if (h2 == null) {
                return eVar;
            } else {
                throw new com.tencent.mm.plugin.appbrand.n.c.a();
            }
        }
        if (h2 == null) {
            return eVar;
        }
        throw new com.tencent.mm.plugin.appbrand.n.c.a();
    }

    public static int iF(int i) {
        if (i >= 0) {
            return i;
        }
        throw new com.tencent.mm.plugin.appbrand.n.c.b("Negative count");
    }

    public final void iG(int i) {
        this.joP = i;
    }
}
