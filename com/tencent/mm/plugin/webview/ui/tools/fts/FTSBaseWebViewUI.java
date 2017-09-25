package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.as.i;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.FileUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FTSBaseWebViewUI extends WebViewUI implements com.tencent.mm.ui.fts.widget.FTSEditTextView.a, com.tencent.mm.ui.fts.widget.a.a {
    private com.tencent.mm.ui.fts.widget.a pfq;
    int scene;
    private com.tencent.mm.plugin.webview.c.a sgE;
    private boolean sgS;
    private boolean sgc;
    int type;

    public class a implements com.tencent.mm.ui.fts.widget.a.b {
        String sgP;
        int sgQ;
        final /* synthetic */ FTSBaseWebViewUI sgT;
        String userName;

        public a(FTSBaseWebViewUI fTSBaseWebViewUI) {
            this.sgT = fTSBaseWebViewUI;
        }

        public final String getTagName() {
            return this.sgP;
        }

        public final int compareTo(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return -1;
            }
            return this.sgP.compareTo(((a) obj).sgP);
        }
    }

    private class b extends i {
        final /* synthetic */ FTSBaseWebViewUI sgT;

        public b(FTSBaseWebViewUI fTSBaseWebViewUI) {
            this.sgT = fTSBaseWebViewUI;
            super(fTSBaseWebViewUI);
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            w.i("MicroMsg.FTS.FTSBaseWebViewUI", "onPageFinished %s", new Object[]{str});
            this.sgT.ks(false);
            if (this.sgT.pfq != null && !this.sgT.sgc) {
                FTSBaseWebViewUI.byV();
                this.sgT.pfq.wiF.vqz.clearFocus();
                this.sgT.aHf();
            }
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            w.i("MicroMsg.FTS.FTSBaseWebViewUI", "onPageStarted %s", new Object[]{str});
            this.sgT.ks(false);
            if (!(this.sgT.pfq == null || this.sgT.sgc)) {
                FTSBaseWebViewUI.byW();
                this.sgT.pfq.wiF.vqz.clearFocus();
                this.sgT.aHf();
            }
            i.aX(this.sgT.scene, 1);
            i.aY(this.sgT.scene, 1);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            if (!(webResourceRequest == null || webResourceRequest.getUrl() == null || !webResourceRequest.getUrl().toString().startsWith("weixin://fts"))) {
                WebResourceResponse JW = JW(webResourceRequest.getUrl().toString());
                if (JW != null) {
                    return JW;
                }
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (!(webResourceRequest == null || webResourceRequest.getUrl() == null || !webResourceRequest.getUrl().toString().startsWith("weixin://fts"))) {
                WebResourceResponse JW = JW(webResourceRequest.getUrl().toString());
                if (JW != null) {
                    return JW;
                }
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (str.startsWith("weixin://fts")) {
                WebResourceResponse JW = JW(str);
                if (JW != null) {
                    return JW;
                }
            }
            return super.shouldInterceptRequest(webView, str);
        }

        private static WebResourceResponse JW(String str) {
            InputStream openRead;
            w.i("MicroMsg.FTS.FTSBaseWebViewUI", "url=%s | thread=%d", new Object[]{str, Long.valueOf(Thread.currentThread().getId())});
            try {
                openRead = FileOp.openRead(Uri.parse(str).getQueryParameter("path"));
            } catch (Exception e) {
                openRead = null;
            }
            if (openRead != null) {
                return new WebResourceResponse("image/*", "utf8", openRead);
            }
            return null;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.sgE = new com.tencent.mm.plugin.webview.c.a(this.uSU.uTo, this.oET);
    }

    protected void axz() {
        super.axz();
        String trim = bg.ap(getIntent().getStringExtra("ftsQuery"), "").trim();
        this.type = getIntent().getIntExtra("ftsType", 0);
        this.scene = getIntent().getIntExtra("ftsbizscene", 3);
        this.sgc = getIntent().getBooleanExtra("ftsneedkeyboard", false);
        this.sgS = getIntent().getBooleanExtra("ftscaneditable", true);
        this.oET.setWebViewClient(new b(this));
        this.oET.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FTSBaseWebViewUI sgT;

            {
                this.sgT = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.sgT.aHf();
                return false;
            }
        });
        if (this.sgS) {
            this.pfq = new com.tencent.mm.ui.fts.widget.a(this);
            this.pfq.wiG = this;
            this.pfq.wiF.GR(getHint());
            this.pfq.wiF.wih = this;
            cO().cP().setCustomView(this.pfq);
            if (!bg.mA(trim)) {
                this.pfq.wiF.q(trim, null);
            }
            if (this.sgc) {
                this.pfq.wiF.bYZ();
                this.pfq.wiF.bYY();
            }
        }
        ks(false);
        if (this.sez != null) {
            this.sez.iQ(true);
        }
        this.oET.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ FTSBaseWebViewUI sgT;

            {
                this.sgT = r1;
            }

            public final boolean onLongClick(View view) {
                return true;
            }
        });
        this.sgE.rVm = this.rVm;
    }

    private void byN() {
        aHf();
        finish();
    }

    protected final int byi() {
        return R.g.bbC;
    }

    protected final boolean bys() {
        return true;
    }

    protected final String byX() {
        return this.pfq.wiF.byX();
    }

    protected final String byY() {
        return this.pfq.wiF.byY();
    }

    protected final boolean byj() {
        return false;
    }

    public final void aZv() {
        byN();
    }

    public final void aZw() {
        if (!this.pfq.wiF.vqz.hasFocus()) {
            this.pfq.wiF.bYZ();
            aHj();
        }
    }

    protected void onResume() {
        super.onResume();
        this.sgE.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.sgE.onPause();
    }

    public void a(String str, String str2, List<com.tencent.mm.ui.fts.widget.a.b> list, com.tencent.mm.ui.fts.widget.FTSEditTextView.b bVar) {
        w.i("MicroMsg.FTS.FTSBaseWebViewUI", "onEditTextChange %s %s %s", new Object[]{str, str2, bVar});
        if (bVar == com.tencent.mm.ui.fts.widget.FTSEditTextView.b.UserInput || bVar == com.tencent.mm.ui.fts.widget.FTSEditTextView.b.ClearText) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ FTSBaseWebViewUI sgT;

                {
                    this.sgT = r1;
                }

                public final void run() {
                    if (this.sgT.rVm != null) {
                        this.sgT.rVm.a(this.sgT.byX(), this.sgT.byY(), this.sgT.byZ(), 0);
                    }
                }
            });
        }
    }

    public final void gM(boolean z) {
        if (z) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ FTSBaseWebViewUI sgT;

                {
                    this.sgT = r1;
                }

                public final void run() {
                    if (this.sgT.rVm != null) {
                        this.sgT.rVm.a(this.sgT.byX(), this.sgT.byY(), this.sgT.byZ(), 0);
                    }
                }
            });
        }
    }

    public final void aZs() {
        if (this.pfq != null) {
            if (!this.pfq.wiF.vqz.hasFocus()) {
                this.pfq.wiF.bYZ();
                aHj();
            }
            this.pfq.wiF.GR(getHint());
        }
    }

    public boolean WV() {
        w.i("MicroMsg.FTS.FTSBaseWebViewUI", "onSearchKeyDown");
        if (byX().length() > 0) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ FTSBaseWebViewUI sgT;

                {
                    this.sgT = r1;
                }

                public final void run() {
                    if (this.sgT.rVm != null) {
                        this.sgT.rVm.a(this.sgT.byX(), this.sgT.byY(), this.sgT.byZ(), 0, "", 0);
                    }
                }
            });
            aHf();
        }
        return false;
    }

    public final JSONArray byZ() {
        List<com.tencent.mm.ui.fts.widget.a.b> list = this.pfq.wiF.qGU;
        JSONArray jSONArray = new JSONArray();
        for (com.tencent.mm.ui.fts.widget.a.b bVar : list) {
            a aVar = (a) bVar;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("tagName", aVar.sgP);
                jSONObject.put("tagType", aVar.sgQ);
                jSONObject.put("userName", aVar.userName);
                jSONArray.put(jSONObject);
            } catch (JSONException e) {
            }
        }
        return jSONArray;
    }

    protected final void p(int i, Bundle bundle) {
        int i2 = 0;
        final String string;
        final String string2;
        switch (i) {
            case 60:
                this.sgE.a(bundle, this.scene);
                return;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                this.sgE.K(bundle);
                return;
            case 62:
                this.sgE.L(bundle);
                return;
            case 119:
                string = bundle.getString("fts_key_json_data");
                final boolean z = bundle.getBoolean("fts_key_new_query", true);
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ FTSBaseWebViewUI sgT;

                    public final void run() {
                        if (this.sgT.rVm != null) {
                            this.sgT.rVm.aA(string, z);
                        }
                    }
                });
                return;
            case 120:
                i2 = bundle.getInt("fts_key_ret", 0);
                string2 = bundle.getString("fts_key_data");
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ FTSBaseWebViewUI sgT;

                    public final void run() {
                        if (this.sgT.rVm != null) {
                            this.sgT.rVm.ax(i2, string2);
                        }
                    }
                });
                return;
            case 121:
                string2 = bundle.getString("fts_key_json_data");
                final int i3 = bundle.getInt("fts_key_teach_request_type", 0);
                i2 = bundle.getInt("fts_key_is_cache_data", 0);
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ FTSBaseWebViewUI sgT;

                    public final void run() {
                        if (this.sgT.rVm != null) {
                            this.sgT.rVm.d(i3, string2, i2);
                        }
                    }
                });
                return;
            case 122:
                string2 = bundle.getString("fts_key_new_query");
                String string3 = bundle.getString("fts_key_custom_query");
                boolean z2 = bundle.getBoolean("fts_key_need_keyboard", false);
                String string4 = bundle.getString("fts_key_tag_list");
                w.i("MicroMsg.FTS.FTSBaseWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", new Object[]{string2, Boolean.valueOf(z2)});
                List arrayList = new ArrayList();
                try {
                    if (!bg.mA(string4)) {
                        JSONArray jSONArray = new JSONArray(string4);
                        while (i2 < jSONArray.length()) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            a aVar = new a(this);
                            aVar.sgP = jSONObject.getString("tagName");
                            aVar.sgQ = jSONObject.getInt("tagType");
                            aVar.userName = jSONObject.getString("userName");
                            arrayList.add(aVar);
                            i2++;
                        }
                    }
                } catch (Exception e) {
                }
                if (this.pfq != null) {
                    if (arrayList.size() > 0) {
                        this.pfq.wiF.q(string3, arrayList);
                    } else {
                        this.pfq.wiF.q(string2, arrayList);
                    }
                }
                if (z2) {
                    this.handler.post(new Runnable(this) {
                        final /* synthetic */ FTSBaseWebViewUI sgT;

                        {
                            this.sgT = r1;
                        }

                        public final void run() {
                            if (this.sgT.rVm != null) {
                                this.sgT.rVm.a(this.sgT.byX(), this.sgT.byY(), this.sgT.byZ(), 0);
                            }
                        }
                    });
                    if (this.pfq != null) {
                        this.pfq.wiF.bYZ();
                    }
                    byz();
                    return;
                } else if (this.pfq != null) {
                    this.pfq.wiF.vqz.clearFocus();
                    return;
                } else {
                    return;
                }
            case 124:
                string = bundle.getString("fts_key_json_data");
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ FTSBaseWebViewUI sgT;

                    public final void run() {
                        if (this.sgT.rVm != null) {
                            this.sgT.rVm.Kb(string);
                        }
                    }
                });
                return;
            case 125:
                string2 = bundle.getString("fts_key_sns_id");
                i2 = bundle.getInt("fts_key_status", 0);
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ FTSBaseWebViewUI sgT;

                    public final void run() {
                        if (this.sgT.rVm != null) {
                            this.sgT.rVm.cn(string2, i2);
                        }
                    }
                });
                return;
            case FileUtils.S_IWUSR /*128*/:
                bundle.getString("fts_key_json_data");
                bundle.getBoolean("fts_key_new_query", true);
                final Map hashMap = new HashMap();
                for (String string5 : bundle.keySet()) {
                    hashMap.put(string5, bundle.get(string5));
                }
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ FTSBaseWebViewUI sgT;

                    public final void run() {
                        if (this.sgT.rVm != null) {
                            this.sgT.rVm.X(hashMap);
                        }
                    }
                });
                return;
            case 100001:
                this.sgE.J(bundle);
                return;
            default:
                return;
        }
    }

    public void onDestroy() {
        try {
            if (this.iYF != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("webview_id", hashCode());
                this.iYF.p(1, bundle);
            }
            this.sgE.onDestroy();
        } catch (RemoteException e) {
        }
        aHf();
        super.onDestroy();
    }

    protected String getHint() {
        return null;
    }

    protected final int getLayoutId() {
        return R.i.ddY;
    }

    protected static boolean byV() {
        return true;
    }

    protected static boolean byW() {
        return true;
    }

    protected final boolean byx() {
        return false;
    }

    protected final void byf() {
        byN();
    }
}
