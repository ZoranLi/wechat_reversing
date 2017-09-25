package com.tencent.mm.plugin.appbrand;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.smtt.sdk.y;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.util.Iterator;
import java.util.LinkedList;

@JgClassChecked(author = 30, fComment = "checked", lastDate = "20170320", reviewer = 30, vComment = {EType.JSEXECUTECHECK})
public class o extends WebView implements d {
    private final LinkedList<Pair<String, y<String>>> ixx;
    private boolean ixy;
    private WebViewClient ixz;
    private Context mContext;
    private ae mHandler;

    public o(Context context, Object obj, String str) {
        this(context, obj, str, "https://servicewechat.com/app-service");
    }

    public o(Context context, Object obj, String str, String str2) {
        super(context);
        this.ixx = new LinkedList();
        this.ixy = false;
        this.ixz = new WebViewClient(this) {
            final /* synthetic */ o ixC;

            {
                this.ixC = r1;
            }

            public final void onPageFinished(WebView webView, String str) {
                synchronized (this.ixC.ixx) {
                    Iterator it = this.ixC.ixx.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        this.ixC.a((String) pair.first, (y) pair.second);
                    }
                    this.ixC.ixx.clear();
                    this.ixC.ixy = true;
                }
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return true;
            }
        };
        this.mContext = context;
        this.mHandler = new ae(Looper.getMainLooper());
        getSettings().setJavaScriptEnabled(true);
        getSettings().setUserAgentString(s.aZ(this.mContext, getSettings().getUserAgentString()));
        setWebViewClient(this.ixz);
        if (!(obj == null || bg.mA(str))) {
            addJavascriptInterface(obj, str);
        }
        setWillNotDraw(true);
        loadDataWithBaseURL(str2, "<html>\n  <head>\n    <meta http-equiv=\"Content-Security-Policy\" content=\"default-src 'none';script-src 'unsafe-eval';\">\n  </head>\n  <body></body>\n</html>", "text/html", ProtocolPackage.ServerEncoding, null);
    }

    public void evaluateJavascript(String str, y<String> yVar) {
        synchronized (this.ixx) {
            if (this.ixy) {
                a(str, yVar);
                return;
            }
            this.ixx.add(new Pair(str, yVar));
        }
    }

    private void a(final String str, final y<String> yVar) {
        Runnable anonymousClass1 = new Runnable(this) {
            final /* synthetic */ o ixC;

            public final void run() {
                super.evaluateJavascript(str, yVar);
            }
        };
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            anonymousClass1.run();
        } else {
            this.mHandler.post(anonymousClass1);
        }
    }

    public final void Po() {
        destroy();
    }

    public void pause() {
    }

    public void resume() {
    }

    public boolean Pp() {
        return false;
    }
}
