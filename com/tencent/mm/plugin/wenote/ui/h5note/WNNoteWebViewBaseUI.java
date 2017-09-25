package com.tencent.mm.plugin.wenote.ui.h5note;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ay.b;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetLocation;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.r;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.json.JSONObject;

public class WNNoteWebViewBaseUI extends WebViewUI {
    private static String sxJ = com.tencent.mm.ay.a.Me();
    private static int sxL = 0;
    private ImageButton lKD;
    public View qOv = null;
    public OnLongClickListener seC = new OnLongClickListener(this) {
        final /* synthetic */ WNNoteWebViewBaseUI sxM;

        {
            this.sxM = r1;
        }

        public final boolean onLongClick(View view) {
            this.sxM.sxI = true;
            return false;
        }
    };
    public p sxC = null;
    public View sxD = null;
    public LinearLayout sxE;
    public boolean sxF = false;
    public boolean sxG = false;
    public boolean sxH = false;
    public boolean sxI = false;
    private String sxK;
    public WNNoteFavVoiceBaseView sxn;

    private class a extends i {
        final /* synthetic */ WNNoteWebViewBaseUI sxM;

        public a(WNNoteWebViewBaseUI wNNoteWebViewBaseUI) {
            this.sxM = wNNoteWebViewBaseUI;
            super(wNNoteWebViewBaseUI);
        }

        public final boolean b(WebView webView, String str) {
            if (str.startsWith("weixinping://iframe") || str.startsWith("weixinpreinject://iframe")) {
                return super.b(webView, str);
            }
            if (str.contains("wenote")) {
                return super.b(webView, str);
            }
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str);
            d.b(this.sxM, "webview", ".ui.tools.WebViewUI", intent);
            return true;
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            this.sxM.af(0, false);
            this.sxM.af(1, true);
            if (this.sxM.sxG) {
                this.sxM.ae(1, false);
            } else {
                this.sxM.ae(1, true);
            }
            boolean z = this.sxM.sxG;
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            this.sxM.af(0, false);
            this.sxM.af(1, true);
            if (this.sxM.sxG) {
                this.sxM.ae(1, false);
            } else {
                this.sxM.ae(1, true);
            }
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
            return shouldInterceptRequest(webView, webResourceRequest);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            String uri = webResourceRequest.getUrl().toString();
            if (uri.startsWith("file://") && uri.endsWith("WNNote.html")) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            return Ly(uri);
        }

        public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            if (bg.mA(str) || (str.startsWith("file://") && str.endsWith("WNNote.html"))) {
                return super.shouldInterceptRequest(webView, str);
            }
            return Ly(str);
        }

        private WebResourceResponse Ly(String str) {
            if (!WNNoteWebViewBaseUI.a(this.sxM, str).booleanValue()) {
                return new WebResourceResponse("text/plain", "utf8", new ByteArrayInputStream("".getBytes()));
            }
            InputStream openRead;
            w.i("MicroMsg.WNNoteWebViewBaseUI", "url=%s | thread=%d", new Object[]{str, Long.valueOf(Thread.currentThread().getId())});
            String uri = Uri.parse(str).toString();
            try {
                openRead = FileOp.openRead(uri.substring("file://".length(), uri.length()));
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.WNNoteWebViewBaseUI", e, "", new Object[0]);
                openRead = null;
            }
            if (openRead != null) {
                return new WebResourceResponse("image/*", "utf8", openRead);
            }
            return null;
        }
    }

    static /* synthetic */ Boolean a(WNNoteWebViewBaseUI wNNoteWebViewBaseUI, String str) {
        if (bg.mA(str) || !str.startsWith("file://")) {
            return Boolean.valueOf(true);
        }
        return (str.startsWith(sxJ) || str.startsWith(wNNoteWebViewBaseUI.sxK)) ? Boolean.valueOf(true) : Boolean.valueOf(false);
    }

    protected void axz() {
        super.axz();
        this.oET.setWebViewClient(new a(this));
        if (this.sxG) {
            this.oET.setOnLongClickListener(this.seC);
        } else {
            this.oET.setOnLongClickListener(new OnLongClickListener(this) {
                final /* synthetic */ WNNoteWebViewBaseUI sxM;

                {
                    this.sxM = r1;
                }

                public final boolean onLongClick(View view) {
                    return true;
                }
            });
        }
        if (this.sez != null) {
            this.sez.iQ(true);
        }
    }

    protected void KC() {
        int bCa;
        super.KC();
        this.sxK = getIntent().getStringExtra("note_sdcard_recources_dir");
        this.sxF = true;
        this.sxE = (LinearLayout) findViewById(R.h.cSV);
        if (com.tencent.mm.compatible.util.d.eo(21)) {
            bCa = bCa();
        } else {
            bCa = 0;
        }
        this.qOv = View.inflate(this.uSU.uTo, R.i.drX, null);
        this.sxn = (WNNoteFavVoiceBaseView) this.qOv.findViewById(R.h.cMZ);
        this.lKD = (ImageButton) findViewById(R.h.cNa);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, bCa, 0, 0);
        if (this.uSU.ipu != null) {
            ((ViewGroup) getWindow().getDecorView()).addView(this.qOv, layoutParams);
            this.qOv.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ WNNoteWebViewBaseUI sxM;

                {
                    this.sxM = r1;
                }

                public final void onClick(View view) {
                }
            });
        }
        this.sxD = r.eC(this).inflate(R.i.drW, null);
        ((ViewGroup) this.uSU.ipu).addView(this.sxD, new FrameLayout.LayoutParams(-1, -2, 17));
        this.sxD.setVisibility(8);
        this.oET.getSettings().setAllowFileAccessFromFileURLs(true);
    }

    protected void a(WebViewKeyboardLinearLayout webViewKeyboardLinearLayout, int i) {
        com.tencent.mm.compatible.util.d.eo(21);
    }

    protected void s(int i, final Bundle bundle) {
        String string;
        int i2;
        WNNoteFavVoiceBaseView wNNoteFavVoiceBaseView;
        switch (i) {
            case 26:
                String string2 = bundle.getString("editorId");
                string = bundle.getString("localPath");
                String string3 = bundle.getString("iconPath", null);
                i2 = bundle.getInt("voiceDuration", 0);
                final JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("localEditorId", string2);
                    jSONObject.put("localPath", string);
                    jSONObject.put("downloaded", true);
                    if (!bg.mA(string3)) {
                        jSONObject.put("iconPath", string3);
                    }
                    if (i2 > 0) {
                        jSONObject.put(Columns.TYPE, 4);
                        jSONObject.put("length", (int) b.aw((long) i2));
                        jSONObject.put("lengthStr", b.s(this.uSU.uTo, jSONObject.getInt("length")).toString());
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.WNNoteWebViewBaseUI", e, "", new Object[0]);
                }
                w.i("MicroMsg.WNNoteWebViewBaseUI", "WNNote: Insert:%s", new Object[]{jSONObject.toString()});
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ WNNoteWebViewBaseUI sxM;

                    public final void run() {
                        if (this.sxM.rVm != null) {
                            this.sxM.rVm.R(jSONObject);
                        }
                    }
                });
                return;
            case 34:
                if (this.sxC != null) {
                    this.sxC.dismiss();
                }
                finish();
                return;
            case 36:
                w.d("MicroMsg.WNNoteWebViewBaseUI", "webview reload");
                this.oET.reload();
                return;
            case JsApiGetLocation.CTRL_INDEX /*37*/:
                if (bg.mA(this.sxn.path) || !this.sxn.path.equals(bundle.getString("voicePath"))) {
                    this.sxn.adL();
                    View view = this.sxn;
                    view.setVisibility(0);
                    Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) (WNNoteFavVoiceBaseView.cN(view) * -1), 0.0f);
                    translateAnimation.setDuration(500);
                    view.startAnimation(translateAnimation);
                    this.sxn.iYF = this.iYF;
                    wNNoteFavVoiceBaseView = this.sxn;
                    wNNoteFavVoiceBaseView.path = bundle.getString("voicePath");
                    wNNoteFavVoiceBaseView.fKw = bundle.getInt("voiceType");
                    wNNoteFavVoiceBaseView.duration = bundle.getInt("voiceDuration");
                    string = wNNoteFavVoiceBaseView.path;
                    int i3 = wNNoteFavVoiceBaseView.fKw;
                    i2 = wNNoteFavVoiceBaseView.duration;
                    wNNoteFavVoiceBaseView.path = bg.ap(string, "");
                    wNNoteFavVoiceBaseView.fKw = i3;
                    wNNoteFavVoiceBaseView.duration = i2;
                    if (wNNoteFavVoiceBaseView.iYF != null) {
                        try {
                            Bundle bundle2 = new Bundle();
                            bundle2.putInt("actionCode", 2);
                            wNNoteFavVoiceBaseView.iYF.d(55, bundle2);
                        } catch (Throwable e2) {
                            w.printErrStackTrace("MicroMsg.WNNoteFavVoiceBaseView", e2, "", new Object[0]);
                        }
                    }
                    this.sxn.dk(this.uSU.uTo);
                    return;
                }
                return;
            case 38:
                wNNoteFavVoiceBaseView = this.sxn;
                string = bundle.getString("path");
                boolean z = bundle.getBoolean("isPlay");
                boolean z2 = bundle.getBoolean("resumePlay");
                boolean z3 = bundle.getBoolean("isPause");
                double d = bundle.getDouble("getProgress");
                wNNoteFavVoiceBaseView.swW = string;
                wNNoteFavVoiceBaseView.swX = z;
                wNNoteFavVoiceBaseView.swY = z2;
                wNNoteFavVoiceBaseView.swZ = z3;
                wNNoteFavVoiceBaseView.sxa = d;
                WNNoteFavVoiceBaseView wNNoteFavVoiceBaseView2 = this.sxn;
                int i4 = bundle.getInt("actionCode");
                if (i4 == 1) {
                    if (!bg.ap(wNNoteFavVoiceBaseView2.path, "").equals(wNNoteFavVoiceBaseView2.swW)) {
                        wNNoteFavVoiceBaseView2.ake();
                        return;
                    } else if (wNNoteFavVoiceBaseView2.swX) {
                        w.i("MicroMsg.WNNoteFavVoiceBaseView", "pause play");
                        if (wNNoteFavVoiceBaseView2.iYF != null) {
                            try {
                                wNNoteFavVoiceBaseView2.iYF.d(57, null);
                            } catch (Throwable e22) {
                                w.printErrStackTrace("MicroMsg.WNNoteFavVoiceBaseView", e22, "", new Object[0]);
                            }
                        }
                        wNNoteFavVoiceBaseView2.sxb.pause();
                        return;
                    } else {
                        w.i("MicroMsg.WNNoteFavVoiceBaseView", "resume play");
                        boolean z4 = wNNoteFavVoiceBaseView2.swY;
                        a aVar = wNNoteFavVoiceBaseView2.sxb;
                        aVar.isPaused = false;
                        aVar.removeMessages(Downloads.RECV_BUFFER_SIZE);
                        aVar.sendEmptyMessage(Downloads.RECV_BUFFER_SIZE);
                        aVar.sxe.lKD.setImageResource(R.g.bmg);
                        aVar.sxe.lKD.setContentDescription(aVar.sxe.getContext().getResources().getString(R.l.dHU));
                        if (!z4) {
                            wNNoteFavVoiceBaseView2.ake();
                            return;
                        }
                        return;
                    }
                } else if (i4 == 2) {
                    if (!wNNoteFavVoiceBaseView2.path.equals(wNNoteFavVoiceBaseView2.swW)) {
                        wNNoteFavVoiceBaseView2.sxb.mD(wNNoteFavVoiceBaseView2.duration);
                        return;
                    } else if (wNNoteFavVoiceBaseView2.swX) {
                        wNNoteFavVoiceBaseView2.sxb.b(wNNoteFavVoiceBaseView2.sxa, wNNoteFavVoiceBaseView2.duration, true);
                        return;
                    } else if (wNNoteFavVoiceBaseView2.swZ) {
                        wNNoteFavVoiceBaseView2.sxb.b(wNNoteFavVoiceBaseView2.sxa, wNNoteFavVoiceBaseView2.duration, false);
                        return;
                    } else {
                        wNNoteFavVoiceBaseView2.sxb.mD(wNNoteFavVoiceBaseView2.duration);
                        return;
                    }
                } else if (i4 == 3 && wNNoteFavVoiceBaseView2.swX) {
                    wNNoteFavVoiceBaseView2.ake();
                    return;
                } else {
                    return;
                }
            case 39:
                wNNoteFavVoiceBaseView = this.sxn;
                if (bundle.getBoolean("result")) {
                    wNNoteFavVoiceBaseView.sxb.begin();
                    return;
                } else {
                    Toast.makeText(wNNoteFavVoiceBaseView.getContext(), R.l.ejO, 1).show();
                    return;
                }
            case 40:
                wNNoteFavVoiceBaseView = this.sxn;
                switch (bundle.getInt("actionCode")) {
                    case 1:
                        if (bundle.getBoolean("result")) {
                            wNNoteFavVoiceBaseView.sxb.stop();
                            return;
                        }
                        if (bundle.getInt("position", 0) == 0) {
                            wNNoteFavVoiceBaseView.lFb = 0;
                        }
                        wNNoteFavVoiceBaseView.sxb.begin();
                        return;
                    case 2:
                        wNNoteFavVoiceBaseView.sxb.nwF = true;
                        wNNoteFavVoiceBaseView.sxb.stop();
                        return;
                    case 3:
                        wNNoteFavVoiceBaseView.sxb.pause();
                        return;
                    default:
                        return;
                }
            case 44:
                if (this.sxC == null) {
                    this.sxC = g.a(this.uSU.uTo, getString(R.l.fnL), true, null);
                    return;
                }
                return;
            case 45:
                if (this.sxC != null) {
                    this.sxC.dismiss();
                }
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ WNNoteWebViewBaseUI sxM;

                    public final void run() {
                        if (this.sxM.sxD.getVisibility() == 0) {
                            this.sxM.sxD.setVisibility(8);
                        }
                        if (bundle == null) {
                            return;
                        }
                        if (bundle.getBoolean("AC_WNNOTE_SEND_TO_USER")) {
                            com.tencent.mm.ui.snackbar.a.e(this.sxM, this.sxM.uSU.uTo.getString(R.l.ekV));
                            return;
                        }
                        String string = this.sxM.uSU.uTo.getString(R.l.ejl);
                        if (bundle.getBoolean("AC_WNNOTE_SEND_TO_USER_FAILE_REASON")) {
                            string = this.sxM.uSU.uTo.getString(R.l.dAL);
                        }
                        g.bl(this.sxM.uSU.uTo, string);
                    }
                });
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.drY;
    }

    public void finish() {
        super.finish();
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onStart() {
        super.onStart();
    }

    protected final boolean byy() {
        return true;
    }

    protected final boolean bys() {
        return false;
    }

    protected void onDestroy() {
        this.sxn.adL();
        this.sxn.bBV();
        this.handler.post(new Runnable(this) {
            final /* synthetic */ WNNoteWebViewBaseUI sxM;

            {
                this.sxM = r1;
            }

            public final void run() {
                try {
                    if (this.sxM.iYF != null) {
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("wenote_editstatus", false);
                        this.sxM.iYF.d(51, bundle);
                    }
                } catch (RemoteException e) {
                }
            }
        });
        super.onDestroy();
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
    }

    private int bCa() {
        int dimensionPixelSize;
        Throwable e;
        if (sxL != 0) {
            return sxL;
        }
        try {
            Class cls = Class.forName("com.android.internal.R$dimen");
            dimensionPixelSize = getResources().getDimensionPixelSize(bg.getInt(cls.getField("status_bar_height").get(cls.newInstance()).toString(), 0));
            try {
                sxL = dimensionPixelSize;
                return dimensionPixelSize;
            } catch (Exception e2) {
                e = e2;
                w.printErrStackTrace("MicroMsg.WNNoteWebViewBaseUI", e, "", new Object[0]);
                return dimensionPixelSize;
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            dimensionPixelSize = 38;
            e = th;
            w.printErrStackTrace("MicroMsg.WNNoteWebViewBaseUI", e, "", new Object[0]);
            return dimensionPixelSize;
        }
    }

    protected final boolean bxX() {
        return false;
    }
}
