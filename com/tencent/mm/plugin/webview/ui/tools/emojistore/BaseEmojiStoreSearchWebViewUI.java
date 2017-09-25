package com.tencent.mm.plugin.webview.ui.tools.emojistore;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.36;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.ui.tools.p.b;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;

public class BaseEmojiStoreSearchWebViewUI extends WebViewUI implements b {
    String fRM;
    private p jZI;
    private boolean sgc;
    private boolean sgd = true;
    private int sge;
    private int type;

    private class a extends i {
        final /* synthetic */ BaseEmojiStoreSearchWebViewUI sgf;

        public a(BaseEmojiStoreSearchWebViewUI baseEmojiStoreSearchWebViewUI) {
            this.sgf = baseEmojiStoreSearchWebViewUI;
            super(baseEmojiStoreSearchWebViewUI);
        }

        public final void onPageFinished(WebView webView, String str) {
            w.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "onPageFinished url:%s", new Object[]{str});
            super.onPageFinished(webView, str);
            this.sgf.ks(false);
            this.sgf.jZI.Ug(this.sgf.fRM);
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            this.sgf.ks(false);
        }
    }

    protected final void axz() {
        super.axz();
        this.fRM = getIntent().getStringExtra("keyword");
        this.type = getIntent().getIntExtra(Columns.TYPE, 0);
        this.sgc = getIntent().getBooleanExtra("showkeyboard", false);
        this.sge = getIntent().getIntExtra("sence", 0);
        this.oET.setWebViewClient(new a(this));
        this.oET.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ BaseEmojiStoreSearchWebViewUI sgf;

            {
                this.sgf = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.sgf.aHf();
                return false;
            }
        });
        this.jZI = new p();
        a(this.jZI);
        this.jZI.lK(false);
        this.jZI.woe = this;
        ks(false);
        if (this.sez != null) {
            this.sez.iQ(true);
        }
        this.oET.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ BaseEmojiStoreSearchWebViewUI sgf;

            {
                this.sgf = r1;
            }

            public final boolean onLongClick(View view) {
                return true;
            }
        });
    }

    public final void OE() {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        if (this.jZI != null) {
            this.jZI.a(this, menu);
            this.jZI.setHint(getString(R.l.ecT));
        }
        return true;
    }

    public final void OD() {
        finish();
    }

    public final void mR(String str) {
        if (this.sgd && bg.mA(str)) {
            this.sgd = false;
            if (this.sgc) {
                this.jZI.bZv();
                aHj();
                return;
            }
            af.f(new Runnable(this) {
                final /* synthetic */ BaseEmojiStoreSearchWebViewUI sgf;

                {
                    this.sgf = r1;
                }

                public final void run() {
                    this.sgf.jZI.clearFocus();
                    this.sgf.aHf();
                }
            }, 500);
        }
    }

    public final boolean mQ(String str) {
        if (str != null) {
            str = str.trim();
        }
        this.fRM = str;
        if (!bg.mA(str)) {
            this.fRM = str;
            this.handler.post(new Runnable(this) {
                final /* synthetic */ BaseEmojiStoreSearchWebViewUI sgf;

                {
                    this.sgf = r1;
                }

                public final void run() {
                    if (this.sgf.rVm != null) {
                        this.sgf.rVm.bzp();
                    }
                }
            });
            Bundle bundle = new Bundle();
            bundle.putInt(Columns.TYPE, this.type);
            bundle.putString("nextPageBuffer", "");
            bundle.putString("keyword", this.fRM);
            bundle.putInt("webview_instance_id", hashCode());
            bundle.putLong("searchID", this.rVm.bzs());
            try {
                if (this.iYF != null) {
                    this.iYF.o(1, bundle);
                } else {
                    w.e("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "invoker should not be null");
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", e, "doSearch", new Object[0]);
            }
        }
        aHf();
        String str2 = "";
        if (!bg.mA(str)) {
            str2 = str.replace(",", " ");
        }
        g.oUh.i(13054, new Object[]{Integer.valueOf(this.sge), Integer.valueOf(1), str2});
        return false;
    }

    public final void OF() {
        this.jZI.bZv();
        aHj();
    }

    public final void OG() {
    }

    protected void r(int i, Bundle bundle) {
        w.i("MicroMsg.emoji.BaseEmojiStoreSearchWebViewUI", "handleEmojiStoreAction action:%d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case 80001:
                String string = bundle.getString("emoji_store_json_data");
                boolean z = bundle.getBoolean("emoji_store_new_query", true);
                String string2 = bundle.getString("emoji_store_page_buf");
                long j = bundle.getLong("emoji_store_search_id");
                d dVar = this.rVm;
                if (dVar.sjS) {
                    w.i("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData success, ready");
                    Map hashMap = new HashMap();
                    hashMap.put("json", string);
                    hashMap.put("newQuery", Boolean.valueOf(z));
                    hashMap.put("nextPageBuffer", string2);
                    w.d("MicroMsg.JsApiHandler", "cpan emoji set SearchID:%d", new Object[]{Long.valueOf(j)});
                    dVar.skd = j;
                    w.i("MicroMsg.JsApiHandler", "event:%s", new Object[]{com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.a("getSearchEmotionDataCallBack", hashMap, dVar.sjU, dVar.sjV)});
                    af.v(new 36(dVar, string));
                    return;
                }
                w.e("MicroMsg.JsApiHandler", "onEmojiStoreGetSearchData fail, not ready");
                return;
            case 80002:
                this.rVm.bzp();
                return;
            default:
                super.r(i, bundle);
                return;
        }
    }

    protected final void byf() {
        finish();
    }

    protected final int getLayoutId() {
        return R.i.daY;
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final boolean byt() {
        return true;
    }
}
