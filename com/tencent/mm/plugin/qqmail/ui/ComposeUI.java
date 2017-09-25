package com.tencent.mm.plugin.qqmail.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.qqmail.b.d;
import com.tencent.mm.plugin.qqmail.b.e;
import com.tencent.mm.plugin.qqmail.b.i;
import com.tencent.mm.plugin.qqmail.b.j;
import com.tencent.mm.plugin.qqmail.b.t;
import com.tencent.mm.plugin.qqmail.b.u;
import com.tencent.mm.plugin.qqmail.b.v;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.smtt.export.external.interfaces.ConsoleMessage;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"SetJavaScriptEnabled"})
public class ComposeUI extends MMActivity {
    private static List<i> oBC;
    private int mode = 5;
    private v oAA = w.aUA();
    private Map<String, String> oAH = new HashMap();
    private ScrollView oBD;
    protected MailAddrsViewControl oBE;
    private ImageView oBF;
    private LinearLayout oBG;
    private LinearLayout oBH;
    private MailAddrsViewControl oBI;
    private ImageView oBJ;
    private LinearLayout oBK;
    private MailAddrsViewControl oBL;
    private ImageView oBM;
    private EditText oBN;
    private LinearLayout oBO;
    private TextView oBP;
    private ImageView oBQ;
    private LinearLayout oBR;
    private TextView oBS;
    private EditText oBT;
    private WebView oBU;
    private j oBV;
    private b oBW;
    public c oBX = new c(this);
    private p oBY;
    private String oBZ;
    private long oBg;
    private o oCa;
    public boolean oCb = true;
    public boolean oCc = true;
    public boolean oCd = false;
    private String oCe = ("(function() { \nvar imgList = document.getElementsByTagName('img');var result = ''; \nfor (var i = 0; i < imgList.length; i++) {var img = imgList[i];var info = img.id + '@@' + img.src;result += info + '&&'}return result;" + "})()".trim());
    private String oCf = "document.getElementById('history').innerHTML";
    private String oCg = "<div id=\"htmlContent\" contenteditable=\"true\" >";
    private String oCh = "</div>";
    private String oCi = null;
    private String oCj = null;
    private String oCk = "weixin://get_img_info/";
    private String oCl = "weixin://get_mail_content/";
    private String oCm = "weixin://img_onclick/";
    private boolean oCn = false;
    private boolean oCo = false;
    private aj oCp = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ ComposeUI oCy;

        {
            this.oCy = r1;
        }

        public final boolean oQ() {
            this.oCy.kr(ComposeUI.a(this.oCy, true));
            return true;
        }
    }, true);
    private aj oCq = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ ComposeUI oCy;

        {
            this.oCy = r1;
        }

        public final boolean oQ() {
            if (this.oCy.oCb && ComposeUI.a(this.oCy, false) && this.oCy.mode == 5) {
                ComposeUI.b(this.oCy);
                if (this.oCy.oCa != null) {
                    this.oCy.oCa.dismiss();
                }
                this.oCy.oCa = s.a(this.oCy, this.oCy.getString(R.l.eGq), 2000);
            }
            return true;
        }
    }, true);
    com.tencent.mm.plugin.qqmail.b.j.a oCr = new com.tencent.mm.plugin.qqmail.b.j.a(this) {
        final /* synthetic */ ComposeUI oCy;

        {
            this.oCy = r1;
        }

        public final void onComplete() {
            com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.b bVar = new com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.b(this.oCy, this.oCy.oBV.CP(null));
            this.oCy.oBE.a(bVar);
            this.oCy.oBI.a(bVar);
            this.oCy.oBL.a(bVar);
        }
    };
    private OnClickListener oCs = new OnClickListener(this) {
        final /* synthetic */ ComposeUI oCy;

        {
            this.oCy = r1;
        }

        public final void onClick(View view) {
            this.oCy.oBG.setVisibility(8);
            this.oCy.oBH.setVisibility(0);
            this.oCy.oBK.setVisibility(0);
            this.oCy.oBG.post(new Runnable(this) {
                final /* synthetic */ AnonymousClass7 oCA;

                {
                    this.oCA = r1;
                }

                public final void run() {
                    this.oCA.oCy.oBH.requestFocus();
                    this.oCA.oCy.oBI.aVi();
                    this.oCA.oCy.oBL.aVi();
                }
            });
        }
    };
    private OnClickListener oCt = new OnClickListener(this) {
        final /* synthetic */ ComposeUI oCy;

        {
            this.oCy = r1;
        }

        public final void onClick(View view) {
            g.a(this.oCy, null, new String[]{this.oCy.getString(R.l.eGp), this.oCy.getString(R.l.eGm), this.oCy.getString(R.l.eGn)}, null, new com.tencent.mm.ui.base.g.c(this) {
                final /* synthetic */ AnonymousClass8 oCB;

                {
                    this.oCB = r1;
                }

                public final void hq(int i) {
                    switch (i) {
                        case 0:
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ComposeUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.oCB.oCy.uSU.uTo, "android.permission.CAMERA", 16, "", "")), bg.bJZ(), this.oCB.oCy.uSU.uTo});
                            if (com.tencent.mm.pluginsdk.i.a.a(this.oCB.oCy.uSU.uTo, "android.permission.CAMERA", 16, "", "")) {
                                this.oCB.oCy.adG();
                                return;
                            }
                            return;
                        case 1:
                            k.a(this.oCB.oCy, 4, null);
                            return;
                        case 2:
                            this.oCB.oCy.startActivityForResult(new Intent(this.oCB.oCy, FileExplorerUI.class), 5);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    };
    private OnMenuItemClickListener oCu = new OnMenuItemClickListener(this) {
        final /* synthetic */ ComposeUI oCy;

        {
            this.oCy = r1;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            if ((ComposeUI.a(this.oCy, false) && this.oCy.mode == 5) || this.oCy.mode == 6) {
                g.a(this.oCy.uSU.uTo, this.oCy.getString(R.l.eGt), "", this.oCy.getString(R.l.eGv), this.oCy.getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass10 oCC;

                    {
                        this.oCC = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oCC.oCy.setResult(0);
                        this.oCC.oCy.finish();
                    }
                }, null);
            } else {
                this.oCy.setResult(0);
                this.oCy.finish();
            }
            return true;
        }
    };
    private OnClickListener oCv = new OnClickListener(this) {
        final /* synthetic */ ComposeUI oCy;

        {
            this.oCy = r1;
        }

        public final void onClick(View view) {
            this.oCy.aHf();
            this.oCy.oBN.getText().toString();
            this.oCy.aUN();
            if (this.oCy.aUO()) {
                ComposeUI composeUI = this.oCy;
                Context context = this.oCy;
                this.oCy.getString(R.l.dIO);
                composeUI.oBY = g.a(context, this.oCy.getString(R.l.eGh), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass11 oCD;

                    {
                        this.oCD = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        this.oCD.oCy.oBW.aUW();
                        this.oCD.oCy.oBW.oDz = null;
                        w.aUz().cancel(this.oCD.oCy.oBg);
                    }
                });
                if (this.oCy.oBW.aUX()) {
                    this.oCy.oBg = ComposeUI.H(this.oCy);
                    return;
                }
                this.oCy.oBY.setMessage(this.oCy.getString(R.l.eGe));
                this.oCy.oBW.oDz = new com.tencent.mm.plugin.qqmail.ui.b.b(this) {
                    final /* synthetic */ AnonymousClass11 oCD;

                    {
                        this.oCD = r1;
                    }

                    public final void aUP() {
                        this.oCD.oCy.oBY.setMessage(this.oCD.oCy.getString(R.l.eGe));
                    }

                    public final void onComplete() {
                        this.oCD.oCy.oBg = ComposeUI.H(this.oCD.oCy);
                    }
                };
            }
        }
    };
    private OnClickListener oCw = new OnClickListener(this) {
        final /* synthetic */ ComposeUI oCy;

        {
            this.oCy = r1;
        }

        public final void onClick(View view) {
            if (this.oCy.oBW.aUX()) {
                com.tencent.mm.pluginsdk.ui.tools.s.a(this.oCy.oBU, this.oCy.oCl, this.oCy.oCf);
                this.oCy.oCo = true;
                return;
            }
            this.oCy.oBY = g.a(this.oCy, this.oCy.getString(R.l.eGe), true, new OnCancelListener(this) {
                final /* synthetic */ AnonymousClass13 oCE;

                {
                    this.oCE = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.oCE.oCy.oBW.aUW();
                    this.oCE.oCy.oBW.oDz = null;
                }
            });
            this.oCy.oBW.oDz = new com.tencent.mm.plugin.qqmail.ui.b.b(this) {
                final /* synthetic */ AnonymousClass13 oCE;

                {
                    this.oCE = r1;
                }

                public final void aUP() {
                }

                public final void onComplete() {
                    this.oCE.oCy.oBY.dismiss();
                    com.tencent.mm.pluginsdk.ui.tools.s.a(this.oCE.oCy.oBU, this.oCE.oCy.oCl, this.oCE.oCy.oCf);
                    this.oCE.oCy.oCo = true;
                }
            };
        }
    };
    private com.tencent.mm.plugin.qqmail.b.p.a oCx = new com.tencent.mm.plugin.qqmail.b.p.a(this) {
        final /* synthetic */ ComposeUI oCy;

        {
            this.oCy = r1;
        }

        public final void onSuccess(String str, Map<String, String> map) {
            g.a(this.oCy, R.l.eGi, R.l.dIO, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ AnonymousClass15 oCF;

                {
                    this.oCF = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    File file = new File(w.aUz().oAg.ozj.ozt + com.tencent.mm.plugin.qqmail.b.c.bx(this.oCF.oCy.oBZ, this.oCF.oCy.ozk));
                    if (file.exists()) {
                        file.delete();
                    }
                    this.oCF.oCy.setResult(-1);
                    this.oCF.oCy.finish();
                }
            });
            this.oCy.oBV.bb(this.oCy.oBE.oEd);
            this.oCy.oBV.bb(this.oCy.oBI.oEd);
            this.oCy.oBV.bb(this.oCy.oBL.oEd);
        }

        public final void onError(int i, String str) {
            if (i == -5) {
                this.oCy.oBX.a(new com.tencent.mm.plugin.qqmail.ui.c.a(this) {
                    final /* synthetic */ AnonymousClass15 oCF;

                    {
                        this.oCF = r1;
                    }

                    public final void aUC() {
                        ComposeUI.H(this.oCF.oCy);
                    }

                    public final void aUD() {
                    }
                });
            } else {
                g.a(this.oCy, str, this.oCy.getString(R.l.eGg), null);
            }
        }

        public final void onComplete() {
            if (this.oCy.oBY != null) {
                this.oCy.oBY.dismiss();
                this.oCy.oBY = null;
            }
        }
    };
    private int ozk = 1;

    private class a extends WebChromeClient {
        final /* synthetic */ ComposeUI oCy;

        public a(ComposeUI composeUI) {
            this.oCy = composeUI;
        }

        @Deprecated
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ComposeUI", "console, consoleMessage: %s", new Object[]{consoleMessage});
            String Nv = com.tencent.mm.pluginsdk.ui.tools.s.Nv(consoleMessage != null ? consoleMessage.message() : null);
            String[] split;
            if (Nv.startsWith(this.oCy.oCm)) {
                this.oCy.aHf();
                try {
                    String[] split2 = URLDecoder.decode(Nv.substring(this.oCy.oCm.length()), ProtocolPackage.ServerEncoding).split("@@")[0].split(":");
                    String str = split2[0];
                    String str2 = split2[1];
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[]{split[1], str, str2});
                    ap.yY();
                    ce cA = com.tencent.mm.u.c.wT().cA((long) Integer.valueOf(str).intValue());
                    Intent intent = new Intent(this.oCy, MailImageDownloadUI.class);
                    intent.putExtra("img_msg_id", cA.field_msgId);
                    intent.putExtra("img_server_id", cA.field_msgSvrId);
                    intent.putExtra("img_download_compress_type", 0);
                    intent.putExtra("img_download_username", cA.field_talker);
                    this.oCy.startActivity(intent);
                    return true;
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.w.w("MicroMsg.ComposeUI", "consoleMessage IMG_ONCLICK, ex = %s", new Object[]{e.getMessage()});
                }
            } else if (Nv.startsWith(this.oCy.oCl)) {
                try {
                    this.oCy.oCj = URLDecoder.decode(Nv.substring(this.oCy.oCl.length()), ProtocolPackage.ServerEncoding);
                } catch (Exception e2) {
                    com.tencent.mm.sdk.platformtools.w.w("MicroMsg.ComposeUI", "consoleMessage GET_MAIL_CONTENT, ex = %s", new Object[]{e2.getMessage()});
                }
                if (this.oCy.oCo) {
                    if (this.oCy.oCj.indexOf("<img") == -1) {
                        this.oCy.oAH.clear();
                        ComposeUI.r(this.oCy);
                        return true;
                    }
                    com.tencent.mm.pluginsdk.ui.tools.s.a(this.oCy.oBU, this.oCy.oCk, this.oCy.oCe);
                }
                return true;
            } else {
                if (Nv.startsWith(this.oCy.oCk)) {
                    this.oCy.oAH.clear();
                    try {
                        String[] split3 = URLDecoder.decode(Nv.substring(this.oCy.oCk.length()), ProtocolPackage.ServerEncoding).split("&&");
                        for (String Nv2 : split3) {
                            split = Nv2.split("@@");
                            Object obj = split[0].split(":")[1];
                            Object obj2 = split[1];
                            if (obj2.startsWith("file://")) {
                                obj2 = obj2.replaceFirst("file://", "");
                            }
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ComposeUI", "put msgImgInfoMap, msgSvrId: %s, path: %s", new Object[]{obj, obj2});
                            this.oCy.oAH.put(obj, obj2);
                        }
                        if (this.oCy.oCo) {
                            ComposeUI.r(this.oCy);
                        }
                        return true;
                    } catch (Exception e22) {
                        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.ComposeUI", "consoleMessage GET_IMG_INFO, ex = %s", new Object[]{e22.getMessage()});
                        return true;
                    }
                }
                return super.onConsoleMessage(consoleMessage);
            }
        }
    }

    private class b extends WebViewClient {
        private boolean oCL = false;
        final /* synthetic */ ComposeUI oCy;

        public b(ComposeUI composeUI) {
            this.oCy = composeUI;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.ComposeUI", "shouldOverrideUrlLoading, url = %s", new Object[]{str});
            String[] split;
            String str2;
            if (str.startsWith(this.oCy.oCm)) {
                this.oCy.aHf();
                try {
                    split = URLDecoder.decode(str.substring(this.oCy.oCm.length()), ProtocolPackage.ServerEncoding).split("@@")[0].split(":");
                    String str3 = split[0];
                    str2 = split[1];
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[]{r0[1], str3, str2});
                    ap.yY();
                    ce cA = com.tencent.mm.u.c.wT().cA((long) Integer.valueOf(str3).intValue());
                    Intent intent = new Intent(this.oCy, MailImageDownloadUI.class);
                    intent.putExtra("img_msg_id", cA.field_msgId);
                    intent.putExtra("img_server_id", cA.field_msgSvrId);
                    intent.putExtra("img_download_compress_type", 0);
                    intent.putExtra("img_download_username", cA.field_talker);
                    this.oCy.startActivity(intent);
                } catch (Exception e) {
                    com.tencent.mm.sdk.platformtools.w.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading IMG_ONCLICK, ex = %s", new Object[]{e.getMessage()});
                }
            } else if (str.startsWith(this.oCy.oCl)) {
                try {
                    this.oCy.oCj = URLDecoder.decode(str.substring(this.oCy.oCl.length()), ProtocolPackage.ServerEncoding);
                } catch (Exception e2) {
                    com.tencent.mm.sdk.platformtools.w.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_MAIL_CONTENT, ex = %s", new Object[]{e2.getMessage()});
                }
                if (this.oCy.oCo) {
                    if (this.oCy.oCj.indexOf("<img") == -1) {
                        this.oCy.oAH.clear();
                        ComposeUI.r(this.oCy);
                    } else {
                        com.tencent.mm.pluginsdk.ui.tools.s.a(this.oCy.oBU, this.oCy.oCk, this.oCy.oCe);
                    }
                }
            } else if (str.startsWith(this.oCy.oCk)) {
                this.oCy.oAH.clear();
                try {
                    String[] split2 = URLDecoder.decode(str.substring(this.oCy.oCk.length()), ProtocolPackage.ServerEncoding).split("&&");
                    for (String str22 : split2) {
                        split = str22.split("@@");
                        Object obj = split[0].split(":")[1];
                        Object obj2 = split[1];
                        if (obj2.startsWith("file://")) {
                            obj2 = obj2.replaceFirst("file://", "");
                        }
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ComposeUI", "put msgImgInfoMap, msgSvrId: %s, path: %s", new Object[]{obj, obj2});
                        this.oCy.oAH.put(obj, obj2);
                    }
                    if (this.oCy.oCo) {
                        ComposeUI.r(this.oCy);
                    }
                } catch (Exception e22) {
                    com.tencent.mm.sdk.platformtools.w.w("MicroMsg.ComposeUI", "shouldOverrideUrlLoading GET_IMG_INFO, ex = %s", new Object[]{e22.getMessage()});
                }
            }
            return true;
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (!this.oCy.oCn) {
                com.tencent.mm.pluginsdk.ui.tools.s.b(this.oCy.oBU);
                this.oCy.oCn = true;
            }
        }

        public final void onPageFinished(WebView webView, String str) {
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.ComposeUI", "onPageFinished, url = %s, firstTimeLoaded = %b", new Object[]{str, Boolean.valueOf(this.oCL)});
            if (!this.oCL) {
                this.oCL = true;
                com.tencent.mm.pluginsdk.ui.tools.s.a(this.oCy.oBU, this.oCy.oCl, this.oCy.oCf);
            }
            super.onPageFinished(webView, str);
        }
    }

    private class c extends com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.c {
        private ImageView oCM;
        final /* synthetic */ ComposeUI oCy;
        private int tag;

        public c(ComposeUI composeUI, ImageView imageView, int i) {
            this.oCy = composeUI;
            this.oCM = imageView;
            this.tag = i;
        }

        public final void gq(boolean z) {
            ImageView imageView;
            int i = 0;
            ComposeUI.y(this.oCy);
            if (this.oCy.oCd) {
                imageView = this.oCM;
            } else {
                imageView = this.oCM;
                if (!z) {
                    i = 4;
                }
            }
            imageView.setVisibility(i);
            if ((this.tag == 1 || this.tag == 2) && !z) {
                this.oCy.oBG.postDelayed(new Runnable(this) {
                    final /* synthetic */ c oCN;

                    {
                        this.oCN = r1;
                    }

                    public final void run() {
                        if (!this.oCN.oCy.oBI.oEe.isFocused() && !this.oCN.oCy.oBL.oEe.isFocused() && this.oCN.oCy.oBI.oEd.size() == 0 && this.oCN.oCy.oBL.oEd.size() == 0 && this.oCN.oCy.oBI.aVd() && this.oCN.oCy.oBL.aVd()) {
                            this.oCN.oCy.oBG.setVisibility(0);
                            this.oCN.oCy.oBH.setVisibility(8);
                            this.oCN.oCy.oBK.setVisibility(8);
                        }
                    }
                }, 10);
            }
        }
    }

    static /* synthetic */ long H(ComposeUI composeUI) {
        Map hashMap = new HashMap();
        hashMap.put("from", "");
        hashMap.put("to", composeUI.oBE.aVg());
        hashMap.put("cc", composeUI.oBI.aVg());
        hashMap.put("bcc", composeUI.oBL.aVg());
        hashMap.put("subject", composeUI.getSubject());
        hashMap.put("content", composeUI.aUN());
        hashMap.put("attachlist", composeUI.oBW.aUU());
        hashMap.put("sendtype", (composeUI.ozk == 4 ? 1 : composeUI.ozk));
        hashMap.put("oldmailid", composeUI.oBZ);
        com.tencent.mm.plugin.qqmail.b.p.c cVar = new com.tencent.mm.plugin.qqmail.b.p.c();
        cVar.oAr = false;
        cVar.oAq = true;
        return w.aUz().a("/cgi-bin/composesendwithattach", hashMap, cVar, composeUI.oCx);
    }

    static /* synthetic */ boolean a(ComposeUI composeUI, boolean z) {
        if (z && composeUI.oBE.oEd.size() == 0 && composeUI.oBI.oEd.size() == 0 && composeUI.oBL.oEd.size() == 0 && !composeUI.oBE.aVf() && !composeUI.oBI.aVf() && !composeUI.oBL.aVf()) {
            return false;
        }
        if (composeUI.mode == 5) {
            if (composeUI.oBN.getText().toString().trim().length() == 0 && composeUI.oBW.aUV().size() == 0 && composeUI.oBT.getText().length() == 0) {
                return false;
            }
        } else if (composeUI.mode == 6 && composeUI.oBN.getText().toString().trim().length() == 0 && composeUI.oBW.aUV().size() == 0) {
            return false;
        }
        return true;
    }

    static /* synthetic */ void b(ComposeUI composeUI) {
        d dVar = new d();
        dVar.ozk = composeUI.ozk;
        dVar.ozl = composeUI.oBZ;
        dVar.ozm = composeUI.oBE.oEd;
        dVar.ozn = composeUI.oBI.oEd;
        dVar.ozo = composeUI.oBL.oEd;
        dVar.ozq = composeUI.oBN.getText().toString();
        dVar.ozp = composeUI.oBW.aUV();
        if (composeUI.mode != 6 && composeUI.mode == 5) {
            dVar.content = composeUI.aUN();
            dVar.ozr = composeUI.mode;
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ComposeUI", "save draft mail as normal mode");
        }
        com.tencent.mm.plugin.qqmail.b.c cVar = w.aUz().oAg;
        try {
            cVar.ozj.aUm();
            e.r(cVar.ozj.ozt + com.tencent.mm.plugin.qqmail.b.c.bx(dVar.ozl, dVar.ozk), dVar.toByteArray());
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.DraftBoxMgr", e, "", new Object[0]);
        }
    }

    static /* synthetic */ void r(ComposeUI composeUI) {
        String str = null;
        ap.yY();
        String oVar = new com.tencent.mm.a.o(((Integer) com.tencent.mm.u.c.vr().get(9, null)).intValue()).toString();
        oVar = !bg.mA(oVar) ? oVar + "@qq.com" : null;
        u uVar = new u();
        uVar.fOu = oVar;
        uVar.ozq = composeUI.getSubject();
        if (!bg.mA(composeUI.oBE.aVg())) {
            uVar.ozT = composeUI.oBE.aVg().split(",");
        }
        if (!bg.mA(composeUI.oBI.aVg())) {
            uVar.ozU = composeUI.oBI.aVg().split(",");
        }
        if (!bg.mA(composeUI.oBL.aVg())) {
            uVar.ozV = composeUI.oBL.aVg().split(",");
        }
        oVar = composeUI.aUN();
        if (!bg.mA(oVar)) {
            str = oVar.replaceAll("src=\"file://", "src=\"cid:").replaceAll("height=\"100\"", "style=\"max-width: 200px; max-width:300px;\"");
        }
        uVar.oAG = str;
        if (composeUI.oAH.size() > 0) {
            Map map = composeUI.oAH;
            uVar.oAH = new HashMap();
            uVar.oAH.putAll(map);
        }
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.ComposeUI", "send mail content: \n%s", new Object[]{str});
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.ComposeUI", "msgImgInfoMap.size: %d", new Object[]{Integer.valueOf(composeUI.oAH.size())});
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.ComposeUI", "uploadedAttachidMap.size: %d", new Object[]{Integer.valueOf(composeUI.oBW.oDx.size())});
        if (composeUI.oBW.oDx.size() > 0 && composeUI.oBW.oDy.size() > 0) {
            map = composeUI.oBW.oDx;
            uVar.oAI = new LinkedHashMap();
            uVar.oAI.putAll(map);
            map = composeUI.oBW.oDy;
            uVar.oAJ = new LinkedHashMap();
            uVar.oAJ.putAll(map);
        }
        v vVar = composeUI.oAA;
        if (vVar.oAL == null) {
            vVar.oAL = new t();
        }
        vVar.oAL.a(uVar);
        composeUI.oCo = false;
        g.bl(composeUI.uSU.uTo, composeUI.getString(R.l.ekV));
        af.f(new Runnable(composeUI) {
            final /* synthetic */ ComposeUI oCy;

            {
                this.oCy = r1;
            }

            public final void run() {
                this.oCy.setResult(-1);
                this.oCy.finish();
            }
        }, 800);
    }

    static /* synthetic */ void y(ComposeUI composeUI) {
        composeUI.oBF.setVisibility(4);
        composeUI.oBJ.setVisibility(4);
        composeUI.oBM.setVisibility(4);
    }

    protected final int getLayoutId() {
        return R.i.dlC;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oCi = this.oCg + "%s" + this.oCh;
        this.oCn = false;
        this.oCo = false;
        this.ozk = getIntent().getIntExtra("composeType", 1);
        this.oBZ = getIntent().getStringExtra("mailid");
        if (this.oBZ == null) {
            this.oBZ = "";
        }
        this.mode = getIntent().getIntExtra("mail_mode", 5);
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.ComposeUI", "onCreate, mode = %d", new Object[]{Integer.valueOf(this.mode)});
        KC();
        this.oBV = w.aUz().oAf;
        this.oBV.a(this.oCr);
        this.oBV.aUo();
        this.oCq.v(180000, 180000);
    }

    protected void onResume() {
        super.onResume();
        this.oCp.v(1500, 1500);
    }

    protected void onPause() {
        super.onPause();
        aHf();
        this.oCp.KH();
        if (this.oCa != null) {
            this.oCa.dismiss();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (oBC != null) {
            oBC = null;
        }
        this.oBW.aUW();
        ap.vd().b(484, this.oBW);
        this.oBV.b(this.oCr);
        this.oBX.release();
        this.oCq.KH();
    }

    private void aUL() {
        this.oBE.clearFocus();
        this.oBI.clearFocus();
        this.oBL.clearFocus();
    }

    protected final void KC() {
        String str;
        CharSequence charSequence;
        this.oBD = (ScrollView) findViewById(R.h.cuf);
        this.oBE = (MailAddrsViewControl) findViewById(R.h.cub);
        this.oBF = (ImageView) findViewById(R.h.ctW);
        this.oBG = (LinearLayout) findViewById(R.h.cue);
        this.oBH = (LinearLayout) findViewById(R.h.cua);
        this.oBI = (MailAddrsViewControl) findViewById(R.h.ctZ);
        this.oBJ = (ImageView) findViewById(R.h.ctV);
        this.oBK = (LinearLayout) findViewById(R.h.ctY);
        this.oBL = (MailAddrsViewControl) findViewById(R.h.ctX);
        this.oBM = (ImageView) findViewById(R.h.ctU);
        this.oBN = (EditText) findViewById(R.h.cuj);
        this.oBO = (LinearLayout) findViewById(R.h.ctT);
        this.oBS = (TextView) findViewById(R.h.crX);
        this.oBT = (EditText) findViewById(R.h.cug);
        this.oBU = com.tencent.mm.ui.widget.MMWebView.a.i(this, R.h.cuh);
        this.oBP = (TextView) findViewById(R.h.cud);
        this.oBQ = (ImageView) findViewById(R.h.cuc);
        this.oBR = (LinearLayout) findViewById(R.h.crW);
        this.oBE.aVe();
        this.oBI.aVe();
        this.oBL.aVe();
        CharSequence stringExtra = getIntent().getStringExtra("mail_content");
        List<String> stringArrayListExtra = getIntent().getStringArrayListExtra("mail_attach");
        List stringArrayListExtra2 = getIntent().getStringArrayListExtra("mail_attach_title");
        d bw = w.aUz().oAg.bw(this.oBZ, this.ozk);
        this.oBW = new b(this, this.oBP, this.oBQ, this.oBR, (byte) 0);
        if (!bg.mA(stringExtra)) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ComposeUI", "read mail from extra");
            if (this.mode == 6) {
                aUM();
                this.oBE.requestFocus();
                this.oCj = String.format(this.oCi, new Object[]{stringExtra});
                this.oBU.loadDataWithBaseURL("", this.oCj, "text/html", ProtocolPackage.ServerEncoding, "");
                this.oBT.setVisibility(8);
                this.oBU.setVisibility(0);
            } else if (this.mode == 5) {
                this.oBT.setVisibility(0);
                this.oBU.setVisibility(8);
                if (stringExtra.indexOf("<div>") != -1) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ComposeUI", "set content in html format");
                    this.oBT.setText(Html.fromHtml(stringExtra));
                } else {
                    this.oBT.setText(stringExtra);
                }
            }
            this.oBW.mode = this.mode;
            if (this.mode == 6) {
                int i = 0;
                for (String str2 : stringArrayListExtra) {
                    File file = new File(str2);
                    if (file.exists()) {
                        if (((int) file.length()) + this.oBW.aVa() > 52428800) {
                            g.a(this, R.l.eGM, R.l.dIO, null);
                            break;
                        }
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ComposeUI", "in upload file mode = %d", new Object[]{Integer.valueOf(this.mode)});
                        int i2 = i + 1;
                        this.oBW.de(str2, (String) stringArrayListExtra2.get(i));
                        i = i2;
                    }
                }
            }
        } else if (bw == null || this.mode != 6) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ComposeUI", "no extra or draf mail content");
            if (this.mode == 6) {
                aUM();
                this.oBE.requestFocus();
                this.oCj = String.format(this.oCi, new Object[]{""});
                this.oBU.loadDataWithBaseURL("", this.oCj, "text/html", ProtocolPackage.ServerEncoding, "");
                this.oBT.setVisibility(8);
                this.oBU.setVisibility(0);
            } else if (this.mode == 5) {
                this.oBU.setVisibility(8);
                this.oBT.setVisibility(0);
            }
            this.oBW.mode = this.mode;
        } else {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ComposeUI", "read mail from draftMail");
            this.oBE.be(bw.ozm);
            this.oBI.be(bw.ozn);
            this.oBL.be(bw.ozo);
            this.oBN.setText(bw.ozq);
            charSequence = bw.content;
            this.mode = 5;
            if (charSequence.indexOf("<div>") != -1) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ComposeUI", "set content in html format");
                this.oBT.setText(Html.fromHtml(charSequence));
            } else {
                this.oBT.setText(charSequence);
            }
            this.oBW.mode = this.mode;
            this.oBW.bd(bw.ozp);
            this.oBW.aUZ();
            this.oBU.setVisibility(8);
            this.oBT.setVisibility(0);
        }
        String[] stringArrayExtra;
        if (this.ozk != 1) {
            stringArrayExtra = getIntent().getStringArrayExtra("toList");
            String[] stringArrayExtra2 = getIntent().getStringArrayExtra("ccList");
            String[] stringArrayExtra3 = getIntent().getStringArrayExtra("bccList");
            String stringExtra2 = getIntent().getStringExtra("subject");
            this.oBE.a(stringArrayExtra, false);
            this.oBI.a(stringArrayExtra2, false);
            this.oBL.a(stringArrayExtra3, false);
            if (!bg.mA(stringExtra2)) {
                EditText editText = this.oBN;
                StringBuilder stringBuilder = new StringBuilder();
                if (this.ozk == 2) {
                    str2 = "Re:";
                } else {
                    str2 = "Fwd:";
                }
                editText.setText(stringBuilder.append(str2).append(stringExtra2).toString());
            }
        } else if (this.ozk == 2 || this.ozk == 3) {
            this.oBS.setVisibility(0);
        } else if (this.ozk == 4) {
            stringArrayExtra = getIntent().getStringArrayExtra("toList");
            if (stringArrayExtra != null && stringArrayExtra.length > 0) {
                this.oBE.a(stringArrayExtra, false);
            }
        } else if (this.ozk == 1) {
            charSequence = getIntent().getStringExtra("subject");
            if (!bg.mA(charSequence)) {
                this.oBN.setText(charSequence);
            }
        }
        if (this.oBI.oEd.size() > 0 || this.oBL.oEd.size() > 0) {
            this.oBG.setVisibility(8);
            this.oBH.setVisibility(0);
            this.oBK.setVisibility(0);
        }
        if (this.ozk == 2 && this.mode != 6 && this.mode == 5) {
            this.oBT.requestFocus();
            this.oBT.setSelection(0);
            this.oBD.postDelayed(new Runnable(this) {
                final /* synthetic */ ComposeUI oCy;

                {
                    this.oCy = r1;
                }

                public final void run() {
                    this.oCy.oBD.fullScroll(130);
                }
            }, 1000);
        }
        this.oBE.oEg = new c(this, this.oBF, 0);
        this.oBI.oEg = new c(this, this.oBJ, 1);
        this.oBL.oEg = new c(this, this.oBM, 2);
        com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.a anonymousClass19 = new com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.a(this) {
            final /* synthetic */ ComposeUI oCy;

            {
                this.oCy = r1;
            }

            public final void b(final MailAddrsViewControl mailAddrsViewControl) {
                g.a(this.oCy.uSU.uTo, this.oCy.getString(R.l.eGB), "", new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass19 oCI;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        mailAddrsViewControl.oEe.setText("");
                        this.oCI.oCy.oCq.postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 oCJ;

                            {
                                this.oCJ = r1;
                            }

                            public final void run() {
                                this.oCJ.oCI.oCy.aUL();
                                mailAddrsViewControl.requestFocus();
                                this.oCJ.oCI.oCy.aHj();
                            }
                        }, 150);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass19 oCI;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.oCI.oCy.oCq.postDelayed(new Runnable(this) {
                            final /* synthetic */ AnonymousClass2 oCK;

                            {
                                this.oCK = r1;
                            }

                            public final void run() {
                                this.oCK.oCI.oCy.aUL();
                                mailAddrsViewControl.requestFocus();
                                this.oCK.oCI.oCy.aHj();
                            }
                        }, 150);
                    }
                });
            }

            public final void aUQ() {
                s.a(this.oCy, this.oCy.getString(R.l.eGB), 1500);
            }
        };
        this.oBE.oEi = anonymousClass19;
        this.oBI.oEi = anonymousClass19;
        this.oBL.oEi = anonymousClass19;
        this.oBF.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ComposeUI oCy;

            {
                this.oCy = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.oCy, MailAddrListUI.class);
                intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", this.oCy.oBE.a(false, null));
                intent.putExtra("MMActivity.OverrideExitAnimation", R.a.aRo);
                intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.aQX);
                this.oCy.startActivityForResult(intent, 0);
                this.oCy.overridePendingTransition(R.a.aRq, R.a.aQY);
            }
        });
        this.oBJ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ComposeUI oCy;

            {
                this.oCy = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.oCy, MailAddrListUI.class);
                intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", this.oCy.oBI.a(false, null));
                intent.putExtra("MMActivity.OverrideExitAnimation", R.a.aRo);
                intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.aQX);
                this.oCy.startActivityForResult(intent, 1);
                this.oCy.overridePendingTransition(R.a.aRq, R.a.aQY);
            }
        });
        this.oBM.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ComposeUI oCy;

            {
                this.oCy = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.oCy, MailAddrListUI.class);
                intent.putExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA", this.oCy.oBL.a(false, null));
                intent.putExtra("MMActivity.OverrideExitAnimation", R.a.aRo);
                intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.aQX);
                this.oCy.startActivityForResult(intent, 2);
                this.oCy.overridePendingTransition(R.a.aRq, R.a.aQY);
            }
        });
        this.oBG.setOnClickListener(this.oCs);
        final ImageView imageView = (ImageView) findViewById(R.h.cui);
        if (this.oCc && this.oBN.getText().length() > 0) {
            imageView.setVisibility(0);
        }
        this.oBN.setOnFocusChangeListener(new OnFocusChangeListener(this) {
            final /* synthetic */ ComposeUI oCy;

            {
                this.oCy = r1;
            }

            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    this.oCy.oBN.setSelection(this.oCy.oBN.getText().length());
                }
            }
        });
        this.oBN.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ ComposeUI oCy;

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                int i4 = 4;
                if (this.oCy.oCc) {
                    ImageView imageView = imageView;
                    if (this.oCy.oBN.getText().length() > 0) {
                        i4 = 0;
                    }
                    imageView.setVisibility(i4);
                    return;
                }
                imageView.setVisibility(4);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        imageView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ComposeUI oCy;

            {
                this.oCy = r1;
            }

            public final void onClick(View view) {
                this.oCy.oBN.getText().clear();
                this.oCy.oBN.requestFocus();
            }
        });
        this.oBO.setOnClickListener(this.oCt);
        zi(R.l.eGw);
        if (getIntent().getBooleanExtra("show_qqmail", false)) {
            ap.yY();
            int intValue = ((Integer) com.tencent.mm.u.c.vr().get(9, Integer.valueOf(0))).intValue();
            if (intValue == 0) {
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.ComposeUI", "want to show qqmail address, but unbind qq");
            } else {
                SE(new com.tencent.mm.a.o(intValue) + "@qq.com");
            }
        }
        b(this.oCu);
        if (this.mode == 5) {
            a(0, getString(R.l.dIA), new OnMenuItemClickListener(this) {
                final /* synthetic */ ComposeUI oCy;

                {
                    this.oCy = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.oCy.oCv.onClick(null);
                    return false;
                }
            });
        } else if (this.mode == 6) {
            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ComposeUI", "set onShareModeSendListener");
            a(0, getString(R.l.dIA), new OnMenuItemClickListener(this) {
                final /* synthetic */ ComposeUI oCy;

                {
                    this.oCy = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.oCy.oCw.onClick(null);
                    return false;
                }
            });
        }
        kr(false);
        aUL();
    }

    private void aUM() {
        if (this.oBU != null) {
            this.oBU.clearFocus();
            this.oBU.getSettings().setJavaScriptEnabled(true);
            this.oBU.setWebViewClient(new b(this));
            this.oBU.setWebChromeClient(new a(this));
            this.oBU.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ ComposeUI oCy;

                {
                    this.oCy = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                        case 1:
                            if (!view.hasFocus()) {
                                view.requestFocus();
                                break;
                            }
                            break;
                    }
                    return false;
                }
            });
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        this.oCu.onMenuItemClick(null);
        return true;
    }

    private void adG() {
        if (!k.c(this, com.tencent.mm.compatible.util.e.gSz, "microMsg." + System.currentTimeMillis() + ".jpg", 3)) {
            Toast.makeText(this, getString(R.l.eQD), 1).show();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ComposeUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    adG();
                    return;
                } else {
                    g.a(this, getString(R.l.eFG), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ ComposeUI oCy;

                        {
                            this.oCy = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.oCy.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }

    private String aUN() {
        if (this.mode == 6) {
            com.tencent.mm.pluginsdk.ui.tools.s.a(this.oBU, this.oCl, this.oCf);
            if (this.oCj != null) {
                int indexOf = this.oCj.indexOf(this.oCg);
                int lastIndexOf = this.oCj.lastIndexOf(this.oCh);
                if (indexOf == -1 || lastIndexOf == -1) {
                    return this.oCj;
                }
                return this.oCj.substring(indexOf + this.oCg.length(), lastIndexOf + this.oCh.length());
            }
        } else if (this.mode == 5) {
            return this.oBT.getText().toString();
        }
        return null;
    }

    private String getSubject() {
        int i = 40;
        String obj = this.oBN.getText().toString();
        if (obj.trim().length() > 0) {
            return obj;
        }
        obj = aUN();
        if (this.mode == 5) {
            if (obj.length() > 0) {
                if (obj.length() <= 40) {
                    i = obj.length();
                }
                return obj.substring(0, i);
            }
        } else if (this.mode == 6 && !bg.mA(obj)) {
            if (obj.length() <= 40) {
                i = obj.length();
            }
            return obj.substring(0, i);
        }
        return getString(R.l.eGu);
    }

    protected final boolean aUO() {
        if (!this.oBE.aVh()) {
            Toast.makeText(this, R.l.eGx, 1).show();
            return false;
        } else if (!this.oBI.aVh()) {
            Toast.makeText(this, R.l.eGs, 1).show();
            return false;
        } else if (!this.oBL.aVh()) {
            Toast.makeText(this, R.l.eGr, 1).show();
            return false;
        } else if ((this.oBE.oEd.size() + this.oBI.oEd.size()) + this.oBL.oEd.size() <= 20) {
            return true;
        } else {
            Toast.makeText(this, R.l.eGD, 1).show();
            return false;
        }
    }

    static void bc(List<i> list) {
        oBC = list;
    }

    private static void a(MailAddrsViewControl mailAddrsViewControl) {
        if (oBC != null) {
            List list = oBC;
            if (list != null) {
                int i;
                i iVar;
                int i2;
                for (i = 0; i < mailAddrsViewControl.oEd.size(); i++) {
                    iVar = (i) mailAddrsViewControl.oEd.get(i);
                    i2 = 0;
                    while (i2 < list.size()) {
                        if (iVar.naK.equalsIgnoreCase(((i) list.get(i2)).naK)) {
                            break;
                        }
                        i2++;
                    }
                    if (i2 == list.size()) {
                        mailAddrsViewControl.f(iVar);
                    }
                }
                for (i = 0; i < list.size(); i++) {
                    iVar = (i) list.get(i);
                    i2 = 0;
                    while (i2 < mailAddrsViewControl.oEd.size()) {
                        if (iVar.naK.equalsIgnoreCase(((i) mailAddrsViewControl.oEd.get(i2)).naK)) {
                            break;
                        }
                        i2++;
                    }
                    if (i2 == mailAddrsViewControl.oEd.size()) {
                        mailAddrsViewControl.e(iVar);
                    }
                }
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            String b;
            switch (i) {
                case 0:
                    a(this.oBE);
                    aHj();
                    return;
                case 1:
                    a(this.oBI);
                    aHj();
                    return;
                case 2:
                    a(this.oBL);
                    aHj();
                    return;
                case 3:
                    ap.yY();
                    b = k.b(this, intent, com.tencent.mm.u.c.xb());
                    if (b != null) {
                        CV(b);
                        aUL();
                        return;
                    }
                    return;
                case 4:
                    if (intent != null) {
                        ap.yY();
                        b = com.tencent.mm.ui.tools.a.c(this, intent, com.tencent.mm.u.c.xb());
                        if (b != null && b.length() > 0) {
                            CV(b);
                            aUL();
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    if (intent != null) {
                        CV(intent.getStringExtra("choosed_file_path"));
                        aUL();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private void CV(final String str) {
        final File file = new File(str);
        if (!file.exists()) {
            return;
        }
        if (this.oBW.oDv.containsKey(str)) {
            g.h(this.uSU.uTo, R.l.eGK, R.l.dIO);
            return;
        }
        final int length = (int) file.length();
        if (length > 20971520) {
            g.a(this, R.l.eGL, R.l.dIO, null);
            return;
        }
        g.a(this, getString(R.l.eGN, new Object[]{bg.ay((long) length)}), getString(R.l.dIO), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ ComposeUI oCy;

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (this.oCy.oBW.aVa() + length > 52428800) {
                    g.a(this.oCy, R.l.eGM, R.l.dIO, null);
                    return;
                }
                if (this.oCy.oBN.getText().toString().trim().length() == 0) {
                    String trim = file.getName().trim();
                    int lastIndexOf = trim.lastIndexOf(".");
                    EditText j = this.oCy.oBN;
                    if (lastIndexOf <= 0) {
                        lastIndexOf = trim.length();
                    }
                    j.setText(trim.substring(0, lastIndexOf));
                }
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ComposeUI", "in upload file mode = %d", new Object[]{Integer.valueOf(this.oCy.mode)});
                this.oCy.oBW.de(str, null);
            }
        }, null);
    }

    public void setRequestedOrientation(int i) {
    }
}
