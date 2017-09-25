package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.ac;
import com.tencent.smtt.sdk.ae;
import com.tencent.smtt.sdk.y;
import java.util.concurrent.CountDownLatch;

public class AppBrandX5BasedJsEngine implements d {
    public ae ixF;
    private volatile boolean ixG;
    private volatile boolean ixH = false;
    private volatile CountDownLatch ixI;
    private com.tencent.mm.sdk.platformtools.ae mHandler;

    public AppBrandX5BasedJsEngine(Context context, Object obj, String str) {
        this.ixF = new ae(context);
        this.ixG = false;
        this.ixF.addJavascriptInterface(obj, str);
        this.mHandler = new com.tencent.mm.sdk.platformtools.ae(Looper.getMainLooper());
        this.ixF.addJavascriptInterface(this, "WeixinJsThreadCaller");
    }

    @JavascriptInterface
    public int callFromJsThread() {
        w.d("MicroMsg.AppBrandX5BasedJsEngine", "enter callFromJsThread, pendingPause %b", new Object[]{Boolean.valueOf(this.ixH)});
        if (this.ixH) {
            w.i("MicroMsg.AppBrandX5BasedJsEngine", "pause await threadId %d", new Object[]{Long.valueOf(Thread.currentThread().getId())});
            this.ixH = false;
            this.ixI = new CountDownLatch(1);
            try {
                this.ixI.await();
            } catch (InterruptedException e) {
                w.e("MicroMsg.AppBrandX5BasedJsEngine", "pause await e = %s", new Object[]{e});
            }
        }
        return 1;
    }

    public void evaluateJavascript(final String str, final y<String> yVar) {
        if (!this.ixG) {
            Runnable anonymousClass1 = new Runnable(this) {
                final /* synthetic */ AppBrandX5BasedJsEngine ixK;

                public final void run() {
                    ae aeVar = this.ixK.ixF;
                    String str = str;
                    y yVar = yVar;
                    if (ae.wXd) {
                        try {
                            ac cfb = ac.cfb();
                            if (cfb != null && cfb.cfc()) {
                                cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "evaluateJavascript", new Class[]{String.class, ValueCallback.class, Object.class}, new Object[]{str, yVar, aeVar.wXh});
                            }
                        } catch (Exception e) {
                        }
                    } else if (aeVar.vsw != null) {
                        aeVar.vsw.evaluateJavascript(str, yVar);
                    }
                }
            };
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                anonymousClass1.run();
            } else {
                this.mHandler.post(anonymousClass1);
            }
        }
    }

    public final void Po() {
        if (!this.ixG) {
            ae aeVar = this.ixF;
            if (ae.wXd) {
                try {
                    ac cfb = ac.cfb();
                    if (cfb != null && cfb.cfc()) {
                        cfb.cfd().wWu.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "destroyX5JsCore", new Class[]{Object.class}, new Object[]{aeVar.wXh});
                    }
                } catch (Exception e) {
                }
            } else if (aeVar.vsw != null) {
                aeVar.vsw.clearHistory();
                aeVar.vsw.clearCache(true);
                aeVar.vsw.loadUrl("about:blank");
                aeVar.vsw.freeMemory();
                aeVar.vsw.pauseTimers();
                aeVar.vsw.destroy();
                aeVar.vsw = null;
            }
        }
        this.ixG = true;
    }

    public void pause() {
        if (Pp()) {
            this.ixH = true;
            evaluateJavascript("var ret = WeixinJsThreadCaller.callFromJsThread();", new y<String>(this) {
                final /* synthetic */ AppBrandX5BasedJsEngine ixK;

                {
                    this.ixK = r1;
                }

                public final /* synthetic */ void onReceiveValue(Object obj) {
                    w.d("MicroMsg.AppBrandX5BasedJsEngine", "invoke callFromJsThread ret %s", new Object[]{(String) obj});
                }
            });
        }
    }

    public void resume() {
        this.ixH = false;
        if (this.ixI != null) {
            this.ixI.countDown();
            this.ixI = null;
        }
    }

    public boolean Pp() {
        return true;
    }
}
