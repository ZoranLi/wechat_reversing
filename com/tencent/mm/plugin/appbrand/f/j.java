package com.tencent.mm.plugin.appbrand.f;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.n.d.d;
import com.tencent.mm.plugin.appbrand.n.f.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Map;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONObject;

public class j {
    public static aj jby = null;
    private String ivH;
    public com.tencent.mm.plugin.appbrand.n.a.a jbw;
    public SSLSocketFactory jbx;

    class AnonymousClass2 implements com.tencent.mm.sdk.platformtools.aj.a {
        final /* synthetic */ a jbA;
        final /* synthetic */ j jbB;

        public AnonymousClass2(j jVar, a aVar) {
            this.jbB = jVar;
            this.jbA = aVar;
        }

        public final boolean oQ() {
            w.e("MicroMsg.AppBrandNetworkWebSocket", "connect response time out");
            this.jbA.pu("connect response time out");
            this.jbB.jbw.close();
            return false;
        }
    }

    class AnonymousClass3 implements com.tencent.mm.sdk.platformtools.aj.a {
        final /* synthetic */ a jbA;
        final /* synthetic */ j jbB;

        public AnonymousClass3(j jVar, a aVar) {
            this.jbB = jVar;
            this.jbA = aVar;
        }

        public final boolean oQ() {
            w.e("MicroMsg.AppBrandNetworkWebSocket", "connect response time out");
            this.jbA.pu("connect response time out");
            this.jbB.jbw.close();
            return false;
        }
    }

    public interface a {
        void TQ();

        void TR();

        void a(ByteBuffer byteBuffer);

        void pu(String str);

        void pv(String str);

        void pw(String str);

        void z(int i, String str);
    }

    class AnonymousClass1 extends com.tencent.mm.plugin.appbrand.n.a.a {
        final /* synthetic */ a jbA;
        final /* synthetic */ j jbB;
        private d jbz = null;
        final /* synthetic */ String val$url;

        public AnonymousClass1(j jVar, URI uri, com.tencent.mm.plugin.appbrand.n.b.a aVar, Map map, int i, String str, a aVar2) {
            this.jbB = jVar;
            this.val$url = str;
            this.jbA = aVar2;
            super(uri, aVar, map, i);
        }

        public final void Vr() {
            w.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: opened", new Object[]{this.val$url});
            j.KH();
            this.jbA.TQ();
        }

        public final void qc(String str) {
            String str2 = "MicroMsg.AppBrandNetworkWebSocket";
            String str3 = "url is %s ,socket onmessage length :%d";
            Object[] objArr = new Object[2];
            objArr[0] = this.val$url;
            objArr[1] = Integer.valueOf(str != null ? str.length() : -1);
            w.i(str2, str3, objArr);
            this.jbA.pv(str);
        }

        public final void B(int i, String str) {
            w.i("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,state: closed ,reason: %s, errCode = %d", new Object[]{this.val$url, str, Integer.valueOf(i)});
            j.KH();
            if (i == -1 || i == -2 || i == -3) {
                if (am.isConnected(ab.getContext())) {
                    this.jbA.pu(str);
                } else {
                    this.jbA.pu("network is down");
                    i = MMBitmapFactory.ERROR_UNSUPPORT_IMAGE_FORMAT;
                }
                this.jbA.z(i, str);
                return;
            }
            this.jbA.z(i, str);
        }

        public final void c(Exception exception) {
            w.e("MicroMsg.AppBrandNetworkWebSocket", "url is %s ,error is %s", new Object[]{this.val$url, exception.toString()});
            this.jbA.pu("exception " + exception.getMessage());
        }

        public final void b(ByteBuffer byteBuffer) {
            String str = "MicroMsg.AppBrandNetworkWebSocket";
            String str2 = "url is %s , socket onMessage buffer length : %d";
            Object[] objArr = new Object[2];
            objArr[0] = this.val$url;
            objArr[1] = Integer.valueOf(byteBuffer != null ? byteBuffer.position() : -1);
            w.i(str, str2, objArr);
            this.jbA.a(byteBuffer);
        }

        public final void a(d dVar) {
            if (dVar.XZ() != com.tencent.mm.plugin.appbrand.n.d.d.a.CONTINUOUS && !dVar.XX()) {
                this.jbz = dVar;
            } else if (dVar.XZ() == com.tencent.mm.plugin.appbrand.n.d.d.a.CONTINUOUS && this.jbz != null) {
                if (this.jbz.XW().position() > 10485760) {
                    w.e("MicroMsg.AppBrandNetworkWebSocket", "Pending Frame exploded");
                    this.jbz = null;
                    return;
                }
                try {
                    this.jbz.e(dVar);
                } catch (Exception e) {
                    w.e("MicroMsg.AppBrandNetworkWebSocket", e.getMessage());
                }
                if (dVar.XX()) {
                    if (this.jbz.XZ() == com.tencent.mm.plugin.appbrand.n.d.d.a.BINARY) {
                        b(this.jbz.XW());
                    } else if (this.jbz.XZ() == com.tencent.mm.plugin.appbrand.n.d.d.a.TEXT) {
                        try {
                            qc(bg.mz(b.m(this.jbz.XW())));
                        } catch (Exception e2) {
                            w.e("MicroMsg.AppBrandNetworkWebSocket", e2.getMessage());
                        }
                    }
                    this.jbz = null;
                }
            }
        }
    }

    public j(String str) {
        this.ivH = str;
        SSLContext pZ = i.pZ(str);
        if (pZ != null) {
            this.jbx = pZ.getSocketFactory();
        }
    }

    public final void Vq() {
        if (this.jbw != null) {
            try {
                w.i("MicroMsg.AppBrandNetworkWebSocket", "try to close socket");
                this.jbw.close();
            } catch (Exception e) {
                w.e("MicroMsg.AppBrandNetworkWebSocket", "send error" + e.toString());
            }
        }
    }

    public static void KH() {
        w.i("MicroMsg.AppBrandNetworkWebSocket", "try to stop connectTimer");
        if (jby != null) {
            synchronized (j.class) {
                if (jby != null) {
                    jby.KH();
                    jby = null;
                }
            }
        }
    }

    public static String o(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterable linkedList = new LinkedList();
        JSONArray optJSONArray = jSONObject.optJSONArray("protocols");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                linkedList.add(optJSONArray.optString(i));
            }
        }
        return !bg.bV(linkedList) ? TextUtils.join(", ", linkedList) : null;
    }

    public static String a(URI uri) {
        String scheme = uri.getScheme();
        if (scheme.equalsIgnoreCase("wss")) {
            scheme = "https";
        } else if (scheme.equalsIgnoreCase("ws")) {
            scheme = "http";
        }
        StringBuilder stringBuilder = new StringBuilder(scheme);
        stringBuilder.append("://");
        stringBuilder.append(uri.getHost());
        int port = uri.getPort();
        Object obj = (port == -1 || ((scheme.equalsIgnoreCase("http") && port == 80) || (scheme.equalsIgnoreCase("https") && port == 443))) ? 1 : null;
        if (obj == null) {
            stringBuilder.append(":");
            stringBuilder.append(uri.getPort());
        }
        return stringBuilder.toString();
    }
}
