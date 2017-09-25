package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.fts.widget.SOSEditTextView;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.FileUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseSOSWebViewUI extends WebViewUI implements com.tencent.mm.ui.fts.widget.FTSEditTextView.a {
    static String sgH = "search_wa_widget_init_out_time";
    String fFF;
    protected ImageButton nVk;
    int rVk = -1;
    int scene;
    protected SOSEditTextView sgA;
    protected View sgB;
    List<c> sgC;
    protected int sgD;
    private com.tencent.mm.plugin.webview.c.a sgE;
    boolean sgF;
    boolean sgG;
    private boolean sgc;
    View sgz;
    int type;

    protected class c {
        List<com.tencent.mm.ui.fts.widget.a.b> qGU;
        final /* synthetic */ BaseSOSWebViewUI sgI;
        String sgR;
        int type;

        protected c(BaseSOSWebViewUI baseSOSWebViewUI) {
            this.sgI = baseSOSWebViewUI;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (cVar.type == this.type && cVar.sgR.equals(this.sgR)) {
                return true;
            }
            return false;
        }
    }

    public class a implements com.tencent.mm.ui.fts.widget.a.b {
        final /* synthetic */ BaseSOSWebViewUI sgI;
        String sgP;
        int sgQ;
        String userName;

        public a(BaseSOSWebViewUI baseSOSWebViewUI) {
            this.sgI = baseSOSWebViewUI;
        }

        public final String getTagName() {
            return this.sgP;
        }

        public final int compareTo(Object obj) {
            if (obj == null || !(obj instanceof com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.a)) {
                return -1;
            }
            return this.sgP.compareTo(((com.tencent.mm.plugin.webview.ui.tools.fts.FTSBaseWebViewUI.a) obj).sgP);
        }
    }

    private class b extends i {
        final /* synthetic */ BaseSOSWebViewUI sgI;

        public b(BaseSOSWebViewUI baseSOSWebViewUI) {
            this.sgI = baseSOSWebViewUI;
            super(baseSOSWebViewUI);
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            w.i("MicroMsg.FTS.BaseSOSWebViewUI", "scene %d, onPageFinished %s", new Object[]{Integer.valueOf(this.sgI.scene), str});
            this.sgI.ks(false);
            if (!(this.sgI.sgA == null || this.sgI.sgc)) {
                BaseSOSWebViewUI.byV();
                this.sgI.sgA.vqz.clearFocus();
                this.sgI.aHf();
            }
            this.sgI.sgG = true;
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            w.i("MicroMsg.FTS.BaseSOSWebViewUI", "onPageStarted %s", new Object[]{str});
            this.sgI.ks(false);
            if (this.sgI.sgA != null && !this.sgI.sgc) {
                BaseSOSWebViewUI.byW();
                this.sgI.sgA.vqz.clearFocus();
                this.sgI.aHf();
            }
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
            w.i("MicroMsg.FTS.BaseSOSWebViewUI", "url=%s | thread=%d", new Object[]{str, Long.valueOf(Thread.currentThread().getId())});
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
        cO().cP().hide();
        this.sgE = new com.tencent.mm.plugin.webview.c.a(this.uSU.uTo, this.oET);
    }

    protected final int bya() {
        return this.jkQ;
    }

    protected void axz() {
        super.axz();
        this.type = getIntent().getIntExtra("ftsType", 0);
        this.scene = getIntent().getIntExtra("ftsbizscene", 3);
        this.sgc = getIntent().getBooleanExtra("ftsneedkeyboard", false);
        this.fFF = getIntent().getStringExtra("ftssessionid");
        this.sgz = findViewById(R.h.cAM);
        this.sgA = (SOSEditTextView) findViewById(R.h.cFW);
        this.sgA.wih = this;
        this.sgA.GR(getHint());
        this.sgB = findViewById(R.h.bvK);
        this.sgB.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BaseSOSWebViewUI sgI;

            {
                this.sgI = r1;
            }

            public final void onClick(View view) {
                this.sgI.byQ();
            }
        });
        this.nVk = (ImageButton) findViewById(R.h.bqR);
        this.nVk.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BaseSOSWebViewUI sgI;

            {
                this.sgI = r1;
            }

            public final void onClick(View view) {
                this.sgI.byN();
            }
        });
        this.oET.setWebViewClient(new b(this));
        this.oET.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ BaseSOSWebViewUI sgI;

            {
                this.sgI = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.sgI.aHf();
                return false;
            }
        });
        if (this.sez != null) {
            this.sez.iQ(true);
        }
        this.oET.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ BaseSOSWebViewUI sgI;

            {
                this.sgI = r1;
            }

            public final boolean onLongClick(View view) {
                return true;
            }
        });
        if (d.eo(23) && !h.sf()) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 8192);
        }
        this.sgE.rVm = this.rVm;
    }

    protected void onResume() {
        super.onResume();
        this.sgE.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.sgE.onPause();
    }

    protected final void byN() {
        aHf();
        if (this.sgC != null && this.sgC.size() > 1) {
            this.sgC.remove(0);
            final c cVar = (c) this.sgC.get(0);
            this.sgA.q(cVar.sgR, cVar.qGU);
            this.handler.post(new Runnable(this) {
                final /* synthetic */ BaseSOSWebViewUI sgI;

                public final void run() {
                    if (this.sgI.rVm != null) {
                        this.sgI.byO();
                        this.sgI.sgD = cVar.type;
                        this.sgI.byP();
                        Bundle bundle = new Bundle();
                        bundle.putInt(Columns.TYPE, this.sgI.sgD);
                        bundle.putBoolean("isHomePage", true);
                        if (this.sgI.sgD != 0) {
                            bundle.putInt("scene", 22);
                        } else {
                            bundle.putInt("scene", 20);
                        }
                        try {
                            Bundle l = this.sgI.iYF.l(4, bundle);
                            this.sgI.rVm.a(l.getString(Columns.TYPE, "0"), l.getString("isMostSearchBiz", "0"), l.getString("isSug", "0"), l.getString("scene", "0"), l.getString("isLocalSug", "0"), this.sgI.byX(), this.sgI.byY(), this.sgI.byZ(), this.sgI.byS(), this.sgI.byT());
                        } catch (RemoteException e) {
                        }
                    }
                }
            });
        } else if (this.sgF) {
            byQ();
        } else {
            finish();
        }
    }

    protected void byO() {
    }

    protected void byP() {
    }

    protected void byQ() {
        this.sgA.clearText();
        aHf();
        this.handler.post(new Runnable(this) {
            final /* synthetic */ BaseSOSWebViewUI sgI;

            {
                this.sgI = r1;
            }

            public final void run() {
                if (this.sgI.rVm != null) {
                    this.sgI.rVm.a(this.sgI.byX(), this.sgI.byY(), this.sgI.byZ(), 1);
                }
            }
        });
        this.sgC = null;
        this.sgF = false;
        this.sgE.onDestroy();
    }

    protected final boolean bys() {
        return true;
    }

    public final void aZw() {
        if (!this.sgA.vqz.hasFocus()) {
            this.sgA.bYZ();
            aHj();
        }
    }

    protected final boolean byj() {
        return false;
    }

    public void a(String str, String str2, List<com.tencent.mm.ui.fts.widget.a.b> list, com.tencent.mm.ui.fts.widget.FTSEditTextView.b bVar) {
        w.i("MicroMsg.FTS.BaseSOSWebViewUI", "onEditTextChange %s %s %s", new Object[]{str, str2, bVar});
        if (bVar == com.tencent.mm.ui.fts.widget.FTSEditTextView.b.UserInput || bVar == com.tencent.mm.ui.fts.widget.FTSEditTextView.b.ClearText) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ BaseSOSWebViewUI sgI;

                {
                    this.sgI = r1;
                }

                public final void run() {
                    if (this.sgI.rVm != null) {
                        this.sgI.rVm.a(this.sgI.byX(), this.sgI.byY(), this.sgI.byZ(), 0);
                    }
                }
            });
        }
    }

    public void gM(boolean z) {
        if (z) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ BaseSOSWebViewUI sgI;

                {
                    this.sgI = r1;
                }

                public final void run() {
                    if (this.sgI.rVm != null) {
                        this.sgI.rVm.a(this.sgI.byX(), this.sgI.byY(), this.sgI.byZ(), 0);
                    }
                }
            });
        }
    }

    public final void aZs() {
        if (this.sgA != null) {
            if (!this.sgA.vqz.hasFocus()) {
                this.sgA.bYZ();
                aHj();
            }
            this.sgA.GR(getHint());
        }
    }

    protected String getHint() {
        return null;
    }

    public boolean WV() {
        this.sgA.vqz.clearFocus();
        aHf();
        if (this.sgA.byX().length() > 0) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ BaseSOSWebViewUI sgI;

                {
                    this.sgI = r1;
                }

                public final void run() {
                    if (this.sgI.rVm != null) {
                        this.sgI.rVm.a(this.sgI.byX(), this.sgI.byY(), this.sgI.byZ(), 0, this.sgI.byS(), this.sgI.byT());
                    }
                }
            });
            aHf();
            byR();
            this.sgF = true;
        }
        return true;
    }

    protected final void byR() {
        if (this.sgC == null) {
            this.sgC = new ArrayList();
        }
        if (byX().length() > 0) {
            c cVar = new c(this);
            cVar.type = this.sgD;
            cVar.qGU = new ArrayList(this.sgA.qGU);
            cVar.sgR = this.sgA.byY();
            if (this.sgC.size() == 0) {
                this.sgC.add(cVar);
            } else if (!cVar.equals((c) this.sgC.get(0))) {
                this.sgC.add(0, cVar);
            }
        }
    }

    protected String byS() {
        return "";
    }

    protected int byT() {
        return 0;
    }

    public final SOSEditTextView byU() {
        return this.sgA;
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

    protected void p(int i, Bundle bundle) {
        int i2 = 0;
        final String string;
        final String string2;
        switch (i) {
            case 60:
                if (bza()) {
                    this.sgE.a(bundle, this.scene);
                    return;
                } else {
                    w.w("MicroMsg.FTS.BaseSOSWebViewUI", "current state is not search");
                    return;
                }
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
                    final /* synthetic */ BaseSOSWebViewUI sgI;

                    public final void run() {
                        if (this.sgI.rVm != null) {
                            this.sgI.rVm.aA(string, z);
                        }
                    }
                });
                return;
            case 120:
                i2 = bundle.getInt("fts_key_ret", 0);
                string2 = bundle.getString("fts_key_data");
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ BaseSOSWebViewUI sgI;

                    public final void run() {
                        if (this.sgI.rVm != null) {
                            this.sgI.rVm.ax(i2, string2);
                        }
                    }
                });
                return;
            case 121:
                string2 = bundle.getString("fts_key_json_data");
                final int i3 = bundle.getInt("fts_key_teach_request_type", 0);
                i2 = bundle.getInt("fts_key_is_cache_data", 0);
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ BaseSOSWebViewUI sgI;

                    public final void run() {
                        if (this.sgI.rVm != null) {
                            this.sgI.rVm.d(i3, string2, i2);
                        }
                    }
                });
                return;
            case 122:
                string2 = bundle.getString("fts_key_new_query");
                String string3 = bundle.getString("fts_key_custom_query");
                boolean z2 = bundle.getBoolean("fts_key_need_keyboard", false);
                String string4 = bundle.getString("fts_key_tag_list");
                w.i("MicroMsg.FTS.BaseSOSWebViewUI", "onFTSSearchQueryChange: totalQuery: %s isInputChange %b", new Object[]{string2, Boolean.valueOf(z2)});
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
                if (this.sgA != null) {
                    if (arrayList.size() > 0) {
                        this.sgA.q(string3, arrayList);
                    } else {
                        this.sgA.q(string2, arrayList);
                    }
                }
                if (z2) {
                    this.handler.post(new Runnable(this) {
                        final /* synthetic */ BaseSOSWebViewUI sgI;

                        {
                            this.sgI = r1;
                        }

                        public final void run() {
                            if (this.sgI.rVm != null) {
                                this.sgI.rVm.a(this.sgI.byX(), this.sgI.byY(), this.sgI.byZ(), 0);
                            }
                        }
                    });
                    if (this.sgA != null) {
                        this.sgA.bYZ();
                    }
                    byz();
                    return;
                }
                if (this.sgA != null) {
                    this.sgA.vqz.clearFocus();
                }
                byR();
                return;
            case 124:
                string = bundle.getString("fts_key_json_data");
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ BaseSOSWebViewUI sgI;

                    public final void run() {
                        if (this.sgI.rVm != null) {
                            this.sgI.rVm.Kb(string);
                        }
                    }
                });
                return;
            case 125:
                string2 = bundle.getString("fts_key_sns_id");
                i2 = bundle.getInt("fts_key_status", 0);
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ BaseSOSWebViewUI sgI;

                    public final void run() {
                        if (this.sgI.rVm != null) {
                            this.sgI.rVm.cn(string2, i2);
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
                    final /* synthetic */ BaseSOSWebViewUI sgI;

                    public final void run() {
                        if (this.sgI.rVm != null) {
                            this.sgI.rVm.X(hashMap);
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

    protected final String byX() {
        return this.sgA.byX();
    }

    protected final String byY() {
        return this.sgA.byY();
    }

    public final JSONArray byZ() {
        List<com.tencent.mm.ui.fts.widget.a.b> list = this.sgA.qGU;
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

    public void onBackPressed() {
        byN();
    }

    public boolean bza() {
        return false;
    }
}
