package com.tencent.mm.plugin.webview.model;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.modelcache.o;
import com.tencent.mm.plugin.webview.modelcache.p;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class af {
    private int rXa = -1;
    public ArrayList<String> rXb = new ArrayList();
    public ArrayList<String> rXc = new ArrayList();
    public List<Integer> rXd = new ArrayList();
    public final Map<String, Boolean> rXe = new HashMap();
    public final Set<String> rXf = new HashSet();

    public final WebResourceResponse a(String str, String str2, boolean z, d dVar, int i) {
        if (bg.mA(str2)) {
            w.e("MicroMsg.WebViewResourceInterrupter", "url is null, return ");
            return null;
        } else if (bg.mA(str2) || !str2.startsWith("weixin://resourceid/")) {
            if (z) {
                int intValue;
                if (!bg.mA(str2) && p.xt(str2)) {
                    String toLowerCase = str2.toLowerCase();
                    if (toLowerCase.contains("localhost") || toLowerCase.contains("127.0.0.1") || toLowerCase.contains(s.bGM())) {
                        if (this.rXd != null && this.rXd.size() > 0) {
                            for (Integer intValue2 : this.rXd) {
                                intValue = intValue2.intValue();
                                if (!toLowerCase.contains("localhost:" + intValue)) {
                                    if (toLowerCase.contains("127.0.0.1:" + intValue)) {
                                    }
                                }
                                w.i("MicroMsg.WebViewResourceInterrupter", "int white list : %s, port = %d", new Object[]{toLowerCase, Integer.valueOf(intValue)});
                            }
                        }
                        w.e("MicroMsg.WebViewResourceInterrupter", "not allowed to load local url : %s", new Object[]{toLowerCase});
                        intValue = 1;
                    }
                    intValue = 0;
                    break;
                }
                intValue = 0;
                if (intValue != 0) {
                    w.f("MicroMsg.WebViewResourceInterrupter", "local url, interrupt request : %s", new Object[]{str2});
                    return new WebResourceResponse("image/*", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(new byte[0]));
                }
            }
            if (b(str2, dVar)) {
                w.e("MicroMsg.WebViewResourceInterrupter", "this is a ad request, interrupt request : %s", new Object[]{str2});
                return new WebResourceResponse("image/*", ProtocolPackage.ServerEncoding, new ByteArrayInputStream(new byte[0]));
            }
            if (bg.mA(str)) {
                w.e("MicroMsg.WebViewResourceInterrupter", "tryInterceptWebViewCacheResource, mainDocumentURL is null or nil, let webview itself do the loading, requestURL = %s", new Object[]{str2});
            } else if (dVar == null) {
                w.e("MicroMsg.WebViewResourceInterrupter", "tryInterceptWebViewCacheResource, invoker is null, let webview itself do the loading");
            } else {
                w.i("MicroMsg.WebViewResourceInterrupter", "tryInterceptWebViewCacheResource, currentURL = %s, requestURL = %s", new Object[]{str, str2});
                if (bg.mA(str) || bg.mA(str2)) {
                    w.i("MicroMsg.WebViewResourceInterrupter", "requestURL or mainDocumentURL is invalid");
                } else {
                    o oVar = a.rYq;
                }
            }
            return null;
        } else {
            w.i("MicroMsg.WebViewResourceInterrupter", "it is wechat resource is, should intercept");
            try {
                return new WebResourceResponse("image/*", ProtocolPackage.ServerEncoding, ah.IY(dVar.cb(str2, 1)));
            } catch (Exception e) {
                w.e("MicroMsg.WebViewResourceInterrupter", "get webview jssdk resource failed %s", new Object[]{e.getMessage()});
                return null;
            }
        }
    }

    private boolean b(String str, d dVar) {
        Iterator it;
        if (this.rXa == -1) {
            try {
                Bundle d = dVar.d(31, null);
                if (d != null) {
                    this.rXa = d.getInt("webview_ad_intercept_control_flag");
                    this.rXb = d.getStringArrayList("webview_ad_intercept_whitelist_domins");
                    this.rXc = d.getStringArrayList("webview_ad_intercept_blacklist_domins");
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("white domain list :\n");
                    it = this.rXb.iterator();
                    while (it.hasNext()) {
                        stringBuilder.append((String) it.next()).append("\n");
                    }
                    stringBuilder.append("black list domain list : \n");
                    it = this.rXc.iterator();
                    while (it.hasNext()) {
                        stringBuilder.append((String) it.next()).append("\n");
                    }
                    w.i("MicroMsg.WebViewResourceInterrupter", stringBuilder.toString());
                }
            } catch (Exception e) {
                w.e("MicroMsg.WebViewResourceInterrupter", "get ad domain failed : %s", new Object[]{e.getMessage()});
                this.rXa = 0;
            }
        }
        if (this.rXa == 0) {
            return false;
        }
        String host = Uri.parse(str).getHost();
        w.d("MicroMsg.WebViewResourceInterrupter", "check has verified this domain : %s, is in black list = %b", new Object[]{host, this.rXe.get(host)});
        if (bg.mA(host)) {
            return false;
        }
        if (this.rXe.containsKey(host)) {
            return ((Boolean) this.rXe.get(host)).booleanValue();
        }
        if (this.rXb != null && this.rXb.size() > 0) {
            it = this.rXb.iterator();
            while (it.hasNext()) {
                if (host.contains((String) it.next())) {
                    this.rXe.put(host, Boolean.valueOf(false));
                    w.i("MicroMsg.WebViewResourceInterrupter", "white list, ignore check the url");
                    return false;
                }
            }
        }
        if (this.rXc != null && this.rXc.size() > 0) {
            it = this.rXc.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!bg.mA(str2) && host.contains(str2)) {
                    if (this.rXa == 1) {
                        this.rXe.put(host, Boolean.valueOf(true));
                        w.e("MicroMsg.WebViewResourceInterrupter", "black list, should stop the request, domain = %s, url = %s", new Object[]{str2, str});
                        return true;
                    } else if (this.rXa == 2) {
                        w.i("MicroMsg.WebViewResourceInterrupter", "black list, just get html content and report, domain = %s, url = %s", new Object[]{str2, str});
                        this.rXf.add(host);
                        this.rXe.put(host, Boolean.valueOf(false));
                        return false;
                    }
                }
            }
        }
        this.rXe.put(host, Boolean.valueOf(false));
        return false;
    }
}
