package com.tencent.mm.plugin.appbrand.n.a;

import com.tencent.mm.plugin.appbrand.n.b;
import com.tencent.mm.plugin.appbrand.n.c;
import com.tencent.mm.plugin.appbrand.n.e.d;
import com.tencent.mm.plugin.appbrand.n.e.f;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.w;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CountDownLatch;

public abstract class a extends b implements com.tencent.mm.plugin.appbrand.n.a, Runnable {
    private com.tencent.mm.plugin.appbrand.n.b.a joO;
    protected URI joX = null;
    public c joY = null;
    private Socket joZ = null;
    private InputStream jpa;
    public OutputStream jpb;
    private Proxy jpc = Proxy.NO_PROXY;
    public Runnable jpd;
    private Map<String, String> jpe;
    private CountDownLatch jpf = new CountDownLatch(1);
    private CountDownLatch jpg = new CountDownLatch(1);
    private int jph = 0;

    private class a implements Runnable {
        final /* synthetic */ a jpi;

        public a(a aVar) {
            this.jpi = aVar;
        }

        public final void run() {
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer byteBuffer = (ByteBuffer) this.jpi.joY.joI.take();
                    this.jpi.jpb.write(byteBuffer.array(), 0, byteBuffer.limit());
                    this.jpi.jpb.flush();
                } catch (IOException e) {
                    this.jpi.joY.XP();
                    return;
                } catch (InterruptedException e2) {
                    return;
                }
            }
        }
    }

    public abstract void B(int i, String str);

    public abstract void Vr();

    public abstract void c(Exception exception);

    public abstract void qc(String str);

    public a(URI uri, com.tencent.mm.plugin.appbrand.n.b.a aVar, Map<String, String> map, int i) {
        if (uri == null) {
            throw new IllegalArgumentException();
        } else if (aVar == null) {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        } else {
            this.joX = uri;
            this.joO = aVar;
            this.jpe = map;
            this.jph = i;
            this.joY = new c(this, aVar);
        }
    }

    public final void connect() {
        if (this.jpd != null) {
            w.i("MicroMsg.AppBrandNetWork.WebSocketClient", "WebSocketClient objects are not reuseable");
            return;
        }
        this.jpd = this;
        e.post(this.jpd, "WebsocketWriteThread");
    }

    public final void close() {
        if (this.jpd != null) {
            this.joY.c(1000, "", false);
        }
    }

    public void run() {
        try {
            if (this.joZ == null) {
                this.joZ = new Socket(this.jpc);
            } else if (this.joZ.isClosed()) {
                throw new IOException();
            }
            if (!this.joZ.isBound()) {
                this.joZ.connect(new InetSocketAddress(this.joX.getHost(), getPort()), this.jph);
            }
            this.jpa = this.joZ.getInputStream();
            this.jpb = this.joZ.getOutputStream();
            XS();
            this.jpd = new a(this);
            e.post(this.jpd, "WebsocketWriteThread");
            byte[] bArr = new byte[c.joE];
            while (true) {
                try {
                    if (!(this.joY.joL == com.tencent.mm.plugin.appbrand.n.a.a.joz)) {
                        int read = this.jpa.read(bArr);
                        if (read != -1) {
                            this.joY.c(ByteBuffer.wrap(bArr, 0, read));
                        }
                    }
                    break;
                } catch (IOException e) {
                    this.joY.XP();
                    return;
                } catch (Exception e2) {
                    c(e2);
                    this.joY.d(MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT, e2.getMessage(), false);
                    return;
                }
            }
            this.joY.XP();
        } catch (Exception e22) {
            B(-1, "");
            this.joY.d(-1, e22.getMessage(), false);
        }
    }

    private int getPort() {
        int port = this.joX.getPort();
        if (port != -1) {
            return port;
        }
        String scheme = this.joX.getScheme();
        if (scheme.equals("wss")) {
            return 443;
        }
        if (scheme.equals("ws")) {
            return 80;
        }
        throw new RuntimeException("unkonow scheme" + scheme);
    }

    private void XS() {
        String path = this.joX.getPath();
        String query = this.joX.getQuery();
        if (path == null || path.length() == 0) {
            path = "/";
        }
        if (query != null) {
            path = path + "?" + query;
        }
        int port = getPort();
        query = this.joX.getHost() + (port != 80 ? ":" + port : "");
        com.tencent.mm.plugin.appbrand.n.e.b dVar = new d();
        dVar.ra(path);
        dVar.put("Host", query);
        if (this.jpe != null) {
            for (Entry entry : this.jpe.entrySet()) {
                dVar.put((String) entry.getKey(), (String) entry.getValue());
            }
        }
        c cVar = this.joY;
        cVar.joS = cVar.joO.a(dVar);
        cVar.joW = dVar.Ya();
        if (cVar.joW != null) {
            com.tencent.mm.plugin.appbrand.n.b.a aVar = cVar.joO;
            f fVar = cVar.joS;
            int i = cVar.joP;
            cVar.U(com.tencent.mm.plugin.appbrand.n.b.a.b(fVar));
        }
    }

    public final void qY(String str) {
        qc(str);
    }

    public final void g(ByteBuffer byteBuffer) {
        b(byteBuffer);
    }

    public final void c(com.tencent.mm.plugin.appbrand.n.d.d dVar) {
        a(dVar);
    }

    public final void XQ() {
        this.jpf.countDown();
        Vr();
    }

    public final void E(int i, String str) {
        this.jpf.countDown();
        this.jpg.countDown();
        if (this.jpd != null) {
            e.O(this.jpd);
        }
        try {
            if (this.joZ != null) {
                this.joZ.close();
            }
        } catch (Exception e) {
            c(e);
        }
        B(i, str);
    }

    public final void d(Exception exception) {
        c(exception);
    }

    public final InetSocketAddress XR() {
        if (this.joZ != null) {
            return (InetSocketAddress) this.joZ.getLocalSocketAddress();
        }
        return null;
    }

    public void b(ByteBuffer byteBuffer) {
    }

    public void a(com.tencent.mm.plugin.appbrand.n.d.d dVar) {
    }

    public final void a(Socket socket) {
        if (this.joZ != null) {
            w.i("MicroMsg.AppBrandNetWork.WebSocketClient", "socket has already been set");
        } else {
            this.joZ = socket;
        }
    }

    public final void b(com.tencent.mm.plugin.appbrand.n.d.d dVar) {
        this.joY.b(dVar);
    }

    public final InetSocketAddress XN() {
        return this.joY.XN();
    }
}
