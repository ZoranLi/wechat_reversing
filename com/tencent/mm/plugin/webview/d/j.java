package com.tencent.mm.plugin.webview.d;

import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;

public final class j {
    private final LinkedList<String> rZK = new LinkedList();

    public final void Jl(String str) {
        try {
            if (!bg.mA(str)) {
                synchronized (this.rZK) {
                    String str2 = (String) this.rZK.peekLast();
                    String encode = URLEncoder.encode(str);
                    if (str2 == null || !str2.equals(encode)) {
                        this.rZK.addLast(encode);
                    }
                    if (this.rZK.size() > 10) {
                        this.rZK.removeFirst();
                    }
                }
            }
        } catch (Throwable e) {
            w.e("MicroMsg.WebViewURLRouteList", "add exp = %s", new Object[]{bg.g(e)});
        }
    }

    public final String[] bxe() {
        String[] strArr;
        synchronized (this.rZK) {
            strArr = new String[this.rZK.size()];
            Iterator it = this.rZK.iterator();
            int i = 0;
            while (it.hasNext()) {
                int i2 = i + 1;
                strArr[i] = (String) it.next();
                i = i2;
            }
        }
        return strArr;
    }

    public final void bxf() {
        if (b.bIu()) {
            StringBuilder stringBuilder = new StringBuilder("routeList: ");
            synchronized (this.rZK) {
                Iterator it = this.rZK.iterator();
                while (it.hasNext()) {
                    stringBuilder.append(URLDecoder.decode((String) it.next())).append("\n");
                }
            }
            w.d("MicroMsg.WebViewURLRouteList", stringBuilder.toString());
        }
    }
}
