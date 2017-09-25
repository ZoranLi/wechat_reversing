package com.tencent.mm.plugin.appbrand.n;

import com.tencent.mm.plugin.appbrand.n.b.a;
import com.tencent.mm.plugin.appbrand.n.b.b;
import com.tencent.mm.plugin.appbrand.n.d.d;
import com.tencent.mm.plugin.appbrand.n.e.f;
import com.tencent.mm.plugin.appbrand.n.e.h;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.w;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class c implements a {
    public static boolean DEBUG = false;
    public static int joE = 16384;
    public static final List<a> joF;
    public SelectionKey joG;
    public ByteChannel joH;
    public final BlockingQueue<ByteBuffer> joI;
    public final BlockingQueue<ByteBuffer> joJ;
    private volatile boolean joK = false;
    public int joL = a.a.jov;
    public final d joM;
    private List<a> joN;
    public a joO = null;
    public int joP;
    private d.a joQ = null;
    private ByteBuffer joR = ByteBuffer.allocate(0);
    public com.tencent.mm.plugin.appbrand.n.e.a joS = null;
    private String joT = null;
    private Integer joU = null;
    private Boolean joV = null;
    public String joW = null;

    static {
        List arrayList = new ArrayList(4);
        joF = arrayList;
        arrayList.add(new com.tencent.mm.plugin.appbrand.n.b.c());
        joF.add(new b());
        joF.add(new com.tencent.mm.plugin.appbrand.n.b.d());
    }

    public c(d dVar, a aVar) {
        if (dVar == null || (aVar == null && this.joP == a.b.joC)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.joI = new LinkedBlockingQueue();
        this.joJ = new LinkedBlockingQueue();
        this.joM = dVar;
        this.joP = a.b.joB;
        if (aVar != null) {
            this.joO = aVar.XU();
        }
    }

    public final void c(ByteBuffer byteBuffer) {
        if (DEBUG) {
            w.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"process(\" + socketBuffer.remaining() + \"): {\" + ( socketBuffer.remaining() > 1000 ? \"too big to display\" : new String( socketBuffer.array(), socketBuffer.position(), socketBuffer.remaining() ) ) + \"}\"");
        }
        if (this.joL != a.a.jov) {
            e(byteBuffer);
        } else if (!d(byteBuffer)) {
        } else {
            if (byteBuffer.hasRemaining()) {
                e(byteBuffer);
            } else if (this.joR.hasRemaining()) {
                e(this.joR);
            }
        }
    }

    private boolean d(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        if (this.joR.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.joR.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.joR.capacity() + byteBuffer.remaining());
                this.joR.flip();
                allocate.put(this.joR);
                this.joR = allocate;
            }
            this.joR.put(byteBuffer);
            this.joR.flip();
            byteBuffer2 = this.joR;
        }
        byteBuffer2.mark();
        int i;
        try {
            if (this.joO == null) {
                a.b bVar;
                byteBuffer2.mark();
                if (byteBuffer2.limit() > a.jpl.length) {
                    bVar = a.b.NOT_MATCHED;
                } else if (byteBuffer2.limit() < a.jpl.length) {
                    throw new com.tencent.mm.plugin.appbrand.n.c.a(a.jpl.length);
                } else {
                    i = 0;
                    while (byteBuffer2.hasRemaining()) {
                        if (a.jpl[i] != byteBuffer2.get()) {
                            byteBuffer2.reset();
                            bVar = a.b.NOT_MATCHED;
                            break;
                        }
                        i++;
                    }
                    bVar = a.b.MATCHED;
                }
                if (bVar == a.b.MATCHED) {
                    try {
                        f(ByteBuffer.wrap(com.tencent.mm.plugin.appbrand.n.f.b.re(this.joM.a(this))));
                        c(-3, "", false);
                    } catch (com.tencent.mm.plugin.appbrand.n.c.b e) {
                        w.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "remote peer closed connection before flashpolicy could be transmitted: " + e.toString());
                        c(MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT, "remote peer closed connection before flashpolicy could be transmitted", true);
                    }
                    return false;
                }
            }
            try {
                f j;
                if (this.joP != a.b.joC) {
                    if (this.joP == a.b.joB) {
                        this.joO.iG(this.joP);
                        j = this.joO.j(byteBuffer2);
                        if (j instanceof h) {
                            j = (h) j;
                            if (this.joO.a(this.joS, (h) j) == a.b.MATCHED) {
                                a(j);
                                return true;
                            }
                            c(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, "draft refuses handshake" + j.Yb(), false);
                        } else {
                            e(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, "wrong http function", false);
                            return false;
                        }
                    }
                    return false;
                } else if (this.joO == null) {
                    for (a XU : this.joN) {
                        a XU2 = XU.XU();
                        try {
                            XU2.iG(this.joP);
                            byteBuffer2.reset();
                            j = XU2.j(byteBuffer2);
                            if (j instanceof com.tencent.mm.plugin.appbrand.n.e.a) {
                                j = (com.tencent.mm.plugin.appbrand.n.e.a) j;
                                if (XU2.a((com.tencent.mm.plugin.appbrand.n.e.a) j) == a.b.MATCHED) {
                                    this.joW = j.Ya();
                                    try {
                                        U(a.b(XU2.a((com.tencent.mm.plugin.appbrand.n.e.a) j, this.joM.XO())));
                                        this.joO = XU2;
                                        a(j);
                                        return true;
                                    } catch (com.tencent.mm.plugin.appbrand.n.c.b e2) {
                                        e(e2.jpA, e2.getMessage(), false);
                                        return false;
                                    } catch (Exception e3) {
                                        this.joM.d(e3);
                                        e(-1, e3.getMessage(), false);
                                        return false;
                                    }
                                }
                                continue;
                            } else {
                                e(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, "wrong http function", false);
                                return false;
                            }
                        } catch (com.tencent.mm.plugin.appbrand.n.c.d e4) {
                            w.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "InvalidHandshakeException e: " + e4.toString());
                        }
                    }
                    if (this.joO == null) {
                        c(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, "no draft matches", false);
                    }
                    return false;
                } else {
                    j = this.joO.j(byteBuffer2);
                    if (j instanceof com.tencent.mm.plugin.appbrand.n.e.a) {
                        j = (com.tencent.mm.plugin.appbrand.n.e.a) j;
                        if (this.joO.a((com.tencent.mm.plugin.appbrand.n.e.a) j) == a.b.MATCHED) {
                            a(j);
                            return true;
                        }
                        c(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, "the handshake did finaly not match", false);
                        return false;
                    }
                    e(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, "wrong http function", false);
                    return false;
                }
            } catch (com.tencent.mm.plugin.appbrand.n.c.b e22) {
                w.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + e22.toString());
                a(e22);
            }
        } catch (com.tencent.mm.plugin.appbrand.n.c.a e5) {
            w.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeHandshake: " + e5.toString());
            if (this.joR.capacity() == 0) {
                byteBuffer2.reset();
                i = e5.jpz;
                if (i == 0) {
                    i = byteBuffer2.capacity() + 16;
                }
                this.joR = ByteBuffer.allocate(i);
                this.joR.put(byteBuffer);
            } else {
                this.joR.position(this.joR.limit());
                this.joR.limit(this.joR.capacity());
            }
        }
    }

    private void e(ByteBuffer byteBuffer) {
        try {
            for (d dVar : this.joO.i(byteBuffer)) {
                if (DEBUG) {
                    w.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "matched frame: " + dVar);
                }
                d.a XZ = dVar.XZ();
                boolean XX = dVar.XX();
                if (XZ == d.a.CLOSING) {
                    int XV;
                    String message;
                    String str = "";
                    if (dVar instanceof com.tencent.mm.plugin.appbrand.n.d.a) {
                        com.tencent.mm.plugin.appbrand.n.d.a aVar = (com.tencent.mm.plugin.appbrand.n.d.a) dVar;
                        XV = aVar.XV();
                        message = aVar.getMessage();
                    } else {
                        message = str;
                        XV = MMBitmapFactory.ERROR_IO_FAILED;
                    }
                    if (this.joL == a.a.joy) {
                        d(XV, message, true);
                    } else if (this.joO.XT() == a.a.jpp) {
                        c(XV, message, true);
                    } else {
                        e(XV, message, false);
                    }
                } else if (XZ == d.a.PING) {
                    this.joM.a(this, dVar);
                } else if (XZ == d.a.PONG) {
                    continue;
                } else if (!XX || XZ == d.a.CONTINUOUS) {
                    if (XZ != d.a.CONTINUOUS) {
                        if (this.joQ != null) {
                            throw new com.tencent.mm.plugin.appbrand.n.c.b("Previous continuous frame sequence not completed.");
                        }
                        this.joQ = XZ;
                    } else if (XX) {
                        if (this.joQ == null) {
                            throw new com.tencent.mm.plugin.appbrand.n.c.b("Continuous frame sequence was not started.");
                        }
                        this.joQ = null;
                    } else if (this.joQ == null) {
                        throw new com.tencent.mm.plugin.appbrand.n.c.b("Continuous frame sequence was not started.");
                    }
                    try {
                        this.joM.c(dVar);
                    } catch (Exception e) {
                        this.joM.d(e);
                    }
                } else if (this.joQ != null) {
                    throw new com.tencent.mm.plugin.appbrand.n.c.b("Continuous frame sequence not completed.");
                } else if (XZ == d.a.TEXT) {
                    try {
                        this.joM.qY(com.tencent.mm.plugin.appbrand.n.f.b.m(dVar.XW()));
                    } catch (Exception e2) {
                        this.joM.d(e2);
                    }
                } else if (XZ == d.a.BINARY) {
                    try {
                        this.joM.g(dVar.XW());
                    } catch (Exception e22) {
                        this.joM.d(e22);
                    }
                } else {
                    throw new com.tencent.mm.plugin.appbrand.n.c.b("non control or continious frame expected");
                }
            }
        } catch (com.tencent.mm.plugin.appbrand.n.c.b e3) {
            w.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "decodeFrames: " + e3.toString());
            this.joM.d(e3);
            a(e3);
        }
    }

    public void c(int i, String str, boolean z) {
        if (this.joL != a.a.joy && this.joL != a.a.joz) {
            if (this.joL == a.a.jox) {
                if (i == MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT) {
                    this.joL = a.a.joy;
                    e(i, str, false);
                    return;
                }
                if (this.joO.XT() != a.a.jpn) {
                    try {
                        b(new com.tencent.mm.plugin.appbrand.n.d.b(i, str));
                    } catch (Exception e) {
                        w.e("MicroMsg.AppBrandNetWork.WebSocketImpl", "close: " + e.toString());
                        this.joM.d(e);
                        e(MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT, "generated frame is invalid", false);
                    }
                }
                e(i, str, z);
            } else if (i == -3) {
                e(-3, str, true);
            } else {
                e(-1, str, false);
            }
            if (i == MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED) {
                e(i, str, z);
            }
            this.joL = a.a.joy;
            this.joR = null;
        }
    }

    public synchronized void d(int i, String str, boolean z) {
        if (this.joL != a.a.joz) {
            if (this.joG != null) {
                this.joG.cancel();
            }
            if (this.joH != null) {
                try {
                    this.joH.close();
                } catch (Exception e) {
                    this.joM.d(e);
                }
            }
            try {
                this.joM.E(i, str);
            } catch (Exception e2) {
                this.joM.d(e2);
            }
            if (this.joO != null) {
                this.joO.reset();
            }
            this.joS = null;
            this.joL = a.a.joz;
            this.joI.clear();
        }
    }

    private void iE(int i) {
        d(i, "", true);
    }

    private synchronized void e(int i, String str, boolean z) {
        if (!this.joK) {
            this.joU = Integer.valueOf(i);
            this.joT = str;
            this.joV = Boolean.valueOf(z);
            this.joK = true;
            if (this.joO != null) {
                this.joO.reset();
            }
            this.joS = null;
        }
    }

    public final void XP() {
        if (this.joL == a.a.jov) {
            iE(-1);
        } else if (this.joK) {
            d(this.joU.intValue(), this.joT, this.joV.booleanValue());
        } else if (this.joO.XT() == a.a.jpn) {
            iE(1000);
        } else if (this.joO.XT() != a.a.jpo || this.joP == a.b.joC) {
            iE(MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT);
        } else {
            iE(1000);
        }
    }

    private void a(com.tencent.mm.plugin.appbrand.n.c.b bVar) {
        c(bVar.jpA, bVar.getMessage(), false);
    }

    public final void d(Collection<d> collection) {
        if (isOpen()) {
            for (d b : collection) {
                b(b);
            }
            return;
        }
        throw new com.tencent.mm.plugin.appbrand.n.c.f();
    }

    public final void b(d dVar) {
        if (DEBUG) {
            w.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "\"send frame: \" + framedata ");
        }
        f(this.joO.d(dVar));
    }

    private void f(ByteBuffer byteBuffer) {
        if (DEBUG) {
            w.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "write(\" + buf.remaining() + \"): {\" + ( buf.remaining() > 1000 ? \"too big to display\" : new String( buf.array() ) ) + \"}");
        }
        this.joI.add(byteBuffer);
    }

    public final void U(List<ByteBuffer> list) {
        for (ByteBuffer f : list) {
            f(f);
        }
    }

    private void a(f fVar) {
        if (DEBUG) {
            w.i("MicroMsg.AppBrandNetWork.WebSocketImpl", "open using draft: " + this.joO.getClass().getSimpleName());
        }
        this.joL = a.a.jox;
        try {
            this.joM.XQ();
        } catch (Exception e) {
            this.joM.d(e);
        }
    }

    public final boolean isOpen() {
        return this.joL == a.a.jox;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return super.toString();
    }

    public final InetSocketAddress XN() {
        return this.joM.XR();
    }
}
