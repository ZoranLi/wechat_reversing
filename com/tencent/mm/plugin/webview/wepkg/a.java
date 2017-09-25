package com.tencent.mm.plugin.webview.wepkg;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.webview.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgPreloadFile;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.webview.wepkg.model.WepkgVersionManager;
import com.tencent.mm.plugin.webview.wepkg.model.f;
import com.tencent.mm.plugin.webview.wepkg.model.g;
import com.tencent.mm.plugin.webview.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static final Map<String, Boolean> soS = Collections.synchronizedMap(new HashMap());
    public aj fyI;
    MMActivity kdb;
    public String mlI;
    public MMWebView qjb;
    public boolean soO;
    public f soP;
    public WepkgVersion soQ;
    public long soR;
    public a soT;
    private int soU;
    public c soV;
    public b soW;
    a soX;

    public interface a {
        boolean azU();
    }

    public class b extends ProxyWebViewClientExtension {
        final /* synthetic */ a soY;

        public b(a aVar) {
            this.soY = aVar;
        }

        public final Object onMiscCallBack(String str, Bundle bundle) {
            boolean z = false;
            String str2 = "MicroMsg.Wepkg.WePkgPlugin";
            String str3 = "method = %s, bundler == null ? %b";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (bundle == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            w.i(str2, str3, objArr);
            if (bg.mA(str) || bundle == null || !this.soY.soO || this.soY.soP == null || !str.equalsIgnoreCase("shouldInterceptMediaUrl")) {
                return null;
            }
            String string = bundle.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
            w.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack origin mediaUrl:" + string);
            if (bg.mA(string)) {
                return null;
            }
            w.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack replace localPath");
            f fVar = this.soY.soP;
            string = d.KQ(string);
            if (!(bg.mA(string) || fVar.sqC == null || fVar.sqC.get(string) == null)) {
                WepkgPreloadFile wepkgPreloadFile = (WepkgPreloadFile) fVar.sqC.get(string);
                if (!bg.mA(wepkgPreloadFile.filePath)) {
                    File file = new File(wepkgPreloadFile.filePath);
                    if (file.exists() && file.isFile() && file.length() == ((long) wepkgPreloadFile.size)) {
                        string = wepkgPreloadFile.filePath;
                        if (!bg.mA(string)) {
                            return null;
                        }
                        w.i("MicroMsg.Wepkg.WePkgPlugin", "localFile:" + string);
                        return string;
                    }
                }
            }
            string = null;
            if (!bg.mA(string)) {
                return null;
            }
            w.i("MicroMsg.Wepkg.WePkgPlugin", "localFile:" + string);
            return string;
        }
    }

    public class c extends WebViewClient {
        final /* synthetic */ a soY;

        public c(a aVar) {
            this.soY = aVar;
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            w.d("MicroMsg.Wepkg.WePkgPlugin", "onPageStarted, url = %s", new Object[]{str});
            this.soY.soR = System.currentTimeMillis();
            this.soY.jd(this.soY.soO);
            super.onPageStarted(webView, str, bitmap);
        }

        public final void onPageFinished(WebView webView, String str) {
            w.d("MicroMsg.Wepkg.WePkgPlugin", "onPageFinished, url = %s", new Object[]{str});
            if (this.soY.soR != 0) {
                long currentTimeMillis = System.currentTimeMillis() - this.soY.soR;
                String KO = d.KO(str);
                if (bg.mA(KO)) {
                    com.tencent.mm.plugin.webview.wepkg.utils.a.b("PageLoadTime", str, "", null, 2, currentTimeMillis, null);
                } else if (!this.soY.soO || this.soY.soQ == null) {
                    com.tencent.mm.plugin.webview.wepkg.utils.a.b("PageLoadTime", str, KO, null, 0, currentTimeMillis, null);
                } else {
                    com.tencent.mm.plugin.webview.wepkg.utils.a.b("PageLoadTime", str, this.soY.soQ.sqL, this.soY.soQ.version, 1, currentTimeMillis, null);
                }
                this.soY.soR = 0;
            }
            if (this.soY.soO && this.soY.soP != null) {
                if ((this.soY.soP.KB(d.KQ(this.soY.mlI)) != null ? 1 : null) != null) {
                    w.i("MicroMsg.Wepkg.WePkgPlugin", "startTimer");
                    this.soY.fyI.v(1000, 1000);
                }
            }
            this.soY.jd(this.soY.soO);
            super.onPageFinished(webView, str);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (!this.soY.soO) {
                return null;
            }
            WebResourceResponse KB;
            if (this.soY.soP != null) {
                KB = this.soY.soP.KB(d.KQ(str));
            } else {
                KB = null;
            }
            if (KB != null) {
                w.i("MicroMsg.Wepkg.WePkgPlugin", "shouldInterceptRequest, url = %s", new Object[]{str});
                if (this.soY.soQ != null) {
                    com.tencent.mm.plugin.webview.wepkg.utils.a.b("RequestHook", str, this.soY.soQ.sqL, this.soY.soQ.version, 1, 0, null);
                }
                return KB;
            } else if (this.soY.soQ == null) {
                return null;
            } else {
                com.tencent.mm.plugin.webview.wepkg.utils.a.b("RequestHook", str, this.soY.soQ.sqL, this.soY.soQ.version, 0, 0, null);
                return null;
            }
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest == null || webResourceRequest.getUrl() == null || bg.mA(webResourceRequest.getUrl().toString()) || !this.soY.soO) {
                return null;
            }
            WebResourceResponse KB;
            if (this.soY.soP != null) {
                KB = this.soY.soP.KB(d.KQ(webResourceRequest.getUrl().toString()));
            } else {
                KB = null;
            }
            if (KB != null) {
                w.i("MicroMsg.Wepkg.WePkgPlugin", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{webResourceRequest.getUrl(), webResourceRequest.getMethod(), Boolean.valueOf(webResourceRequest.isForMainFrame())});
                if (this.soY.soQ != null) {
                    com.tencent.mm.plugin.webview.wepkg.utils.a.b("RequestHook", webResourceRequest.getUrl().toString(), this.soY.soQ.sqL, this.soY.soQ.version, 1, 0, null);
                }
                return KB;
            } else if (this.soY.soQ == null) {
                return null;
            } else {
                com.tencent.mm.plugin.webview.wepkg.utils.a.b("RequestHook", webResourceRequest.getUrl().toString(), this.soY.soQ.sqL, this.soY.soQ.version, 0, 0, null);
                return null;
            }
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            if (webResourceRequest == null || webResourceRequest.getUrl() == null || bg.mA(webResourceRequest.getUrl().toString()) || !this.soY.soO) {
                return null;
            }
            WebResourceResponse KB;
            if (this.soY.soP != null) {
                KB = this.soY.soP.KB(d.KQ(webResourceRequest.getUrl().toString()));
            } else {
                KB = null;
            }
            if (KB != null) {
                w.i("MicroMsg.Wepkg.WePkgPlugin", "shouldInterceptRequest, url = %s, method = %s, isForMainFrame = %b", new Object[]{webResourceRequest.getUrl(), webResourceRequest.getMethod(), Boolean.valueOf(webResourceRequest.isForMainFrame())});
                if (this.soY.soQ != null) {
                    com.tencent.mm.plugin.webview.wepkg.utils.a.b("RequestHook", webResourceRequest.getUrl().toString(), this.soY.soQ.sqL, this.soY.soQ.version, 1, 0, null);
                }
                return KB;
            } else if (this.soY.soQ == null) {
                return null;
            } else {
                com.tencent.mm.plugin.webview.wepkg.utils.a.b("RequestHook", webResourceRequest.getUrl().toString(), this.soY.soQ.sqL, this.soY.soQ.version, 0, 0, null);
                return null;
            }
        }
    }

    public a(MMActivity mMActivity, MMWebView mMWebView) {
        this.soO = false;
        this.soR = 0;
        this.soU = 0;
        this.fyI = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
            final /* synthetic */ a soY;

            {
                this.soY = r1;
            }

            public final boolean oQ() {
                a aVar = this.soY;
                if ((aVar.soT == null ? aVar.soX : aVar.soT).azU()) {
                    this.soY.wL(0);
                } else {
                    w.i("MicroMsg.Wepkg.WePkgPlugin", "white screen");
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 spa;

                        {
                            this.spa = r1;
                        }

                        public final void run() {
                            int i = 0;
                            try {
                                w.i("MicroMsg.Wepkg.WePkgPlugin", "load url from net");
                                this.spa.soY.soO = false;
                                this.spa.soY.qjb.loadUrl(this.spa.soY.mlI);
                                SharedPreferences sharedPreferences = this.spa.soY.kdb.getSharedPreferences("we_pkg_sp", 4);
                                if (sharedPreferences != null) {
                                    i = sharedPreferences.getInt("white_screen_times", 0);
                                }
                                if (i > 1) {
                                    if (this.spa.soY.soQ != null) {
                                        com.tencent.mm.plugin.webview.wepkg.utils.a.b("whiteScreen", this.spa.soY.mlI, this.spa.soY.soQ.sqL, this.spa.soY.soQ.version, -1, 0, null);
                                    }
                                    String KO = d.KO(this.spa.soY.mlI);
                                    com.tencent.mm.plugin.webview.wepkg.utils.b.sru.srw.remove(KO);
                                    g.KD(KO);
                                    SharedPreferences sharedPreferences2 = this.spa.soY.kdb.getSharedPreferences("we_pkg_sp", 4);
                                    if (sharedPreferences2 != null) {
                                        w.i("MicroMsg.Wepkg.WePkgPlugin", "disableWePkg");
                                        sharedPreferences2.edit().putBoolean("disable_we_pkg", true).commit();
                                        return;
                                    }
                                    return;
                                }
                                this.spa.soY.wL(i + 1);
                            } catch (Exception e) {
                            }
                        }
                    });
                }
                return false;
            }
        }, false);
        this.soV = new c(this);
        this.soW = new b(this);
        this.soX = new a(this) {
            final /* synthetic */ a soY;

            {
                this.soY = r1;
            }

            public final boolean azU() {
                return true;
            }
        };
        this.kdb = mMActivity;
        this.qjb = mMWebView;
    }

    public a(MMActivity mMActivity, MMWebView mMWebView, int i) {
        this(mMActivity, mMWebView);
        this.soU = i;
    }

    public final void onCreate(String str) {
        if (this.soU == 0) {
            this.soU = this.kdb.hashCode();
        }
        com.tencent.mm.plugin.webview.wepkg.utils.b.srt.add(Integer.valueOf(this.soU));
        this.mlI = str;
        if (!d.KR(this.mlI)) {
            com.tencent.mm.plugin.webview.wepkg.utils.a.b("EnterWeb", this.mlI, d.KO(this.mlI), null, 2, 0, null);
        } else if (WepkgMainProcessService.Ux()) {
            w.i("MicroMsg.Wepkg.WePkgPlugin", "WepkgMainProcessService is live");
            this.soP = g.KC(this.mlI);
            if (!(this.soP == null || this.soP.sqr == null)) {
                this.soO = true;
                this.soQ = this.soP.sqr;
            }
            d.vL().e(new Runnable(this) {
                final /* synthetic */ a soY;

                {
                    this.soY = r1;
                }

                public final void run() {
                    WepkgVersionManager.cp(d.KO(this.soY.mlI), 0);
                }
            }, 2000);
            w.i("MicroMsg.Wepkg.WePkgPlugin", "wepkgAvailable:%s", new Object[]{Boolean.valueOf(this.soO)});
            if (this.soO && this.soQ != null) {
                com.tencent.mm.plugin.webview.wepkg.utils.a.b("EnterWeb", this.mlI, this.soQ.sqL, this.soQ.version, 1, 0, null);
            }
        } else {
            w.i("MicroMsg.Wepkg.WePkgPlugin", "WepkgMainProcessService is dead");
            d.a(this.mlI, new com.tencent.mm.plugin.webview.wepkg.model.a(this) {
                final /* synthetic */ a soY;

                {
                    this.soY = r1;
                }

                public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                    if (baseWepkgProcessTask instanceof WepkgCrossProcessTask) {
                        final String str = ((WepkgCrossProcessTask) baseWepkgProcessTask).sqv;
                        d.vL().D(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 soZ;

                            public final void run() {
                                g.KC(str);
                                WepkgVersionManager.cp(d.KO(str), 0);
                            }
                        });
                    }
                }
            });
            com.tencent.mm.plugin.webview.wepkg.utils.a.b("EnterWeb", this.mlI, d.KO(this.mlI), null, 0, 0, com.tencent.mm.plugin.webview.wepkg.utils.a.wN(10));
        }
        w.i("MicroMsg.Wepkg.WePkgPlugin", "pkgid:%s,  wepkgAvailable:%b", new Object[]{d.KO(str), Boolean.valueOf(this.soO)});
    }

    public final void onDestroy() {
        if (com.tencent.mm.plugin.webview.wepkg.utils.b.srt.contains(Integer.valueOf(this.soU))) {
            com.tencent.mm.plugin.webview.wepkg.utils.b.srt.remove(Integer.valueOf(this.soU));
        }
        if (com.tencent.mm.plugin.webview.wepkg.utils.b.srt.size() == 0) {
            com.tencent.mm.plugin.webview.wepkg.utils.b.sru.srw.clear();
            w.i("MicroMsg.Wepkg.WePkgPlugin", "clear wepkg info in memory");
        }
    }

    public final boolean bAn() {
        return this.soQ == null || !this.soQ.srb;
    }

    public final void jd(final boolean z) {
        w.i("MicroMsg.Wepkg.WePkgPlugin", "useWepkg:" + z);
        af.v(new Runnable(this) {
            final /* synthetic */ a soY;

            public final void run() {
                if (this.soY.qjb != null) {
                    this.soY.qjb.evaluateJavascript(String.format("javascript:(function() {window.__usewepkg__=%s;})();", new Object[]{Boolean.valueOf(z)}), null);
                    return;
                }
                w.i("MicroMsg.Wepkg.WePkgPlugin", "injectWepkgState, webview == null");
            }
        });
    }

    public final void wL(int i) {
        SharedPreferences sharedPreferences = this.kdb.getSharedPreferences("we_pkg_sp", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("white_screen_times", i).commit();
        }
    }
}
