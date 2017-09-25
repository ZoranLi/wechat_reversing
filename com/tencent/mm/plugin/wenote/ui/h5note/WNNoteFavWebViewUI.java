package com.tencent.mm.plugin.wenote.ui.h5note;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.WebViewKeyboardLinearLayout;
import com.tencent.mm.plugin.wenote.model.b.b;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.MMWebView.a;
import com.tencent.mm.ui.widget.e;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import org.json.JSONObject;

public class WNNoteFavWebViewUI extends WNNoteWebViewBaseUI implements b {
    private boolean fQy = true;
    private long hEY = -1;
    private ImageButton lKD;
    private int sxg = 1;
    private ImageButton sxh;
    private ImageButton sxi;
    private ImageButton sxj;
    private LinearLayout sxk;
    private ImageView sxl;
    private TextView sxm;
    private WNNoteFavVoiceBaseView sxn;
    private int sxo;
    private boolean sxp = false;
    private String sxq = null;
    private int sxr = -1;
    private boolean sxs = false;
    ae sxt = new ae(this) {
        final /* synthetic */ WNNoteFavWebViewUI sxu;

        {
            this.sxu = r1;
        }

        public final void handleMessage(Message message) {
            this.sxu.rVm.bzq();
            sendEmptyMessageDelayed(4112, 250);
        }
    };

    static /* synthetic */ WNNoteFavWebViewUI o(WNNoteFavWebViewUI wNNoteFavWebViewUI) {
        return wNNoteFavWebViewUI;
    }

    protected final MMWebView byd() {
        return a.fj(this);
    }

    protected final void axz() {
        super.axz();
    }

    protected final void KC() {
        this.hEY = getIntent().getLongExtra("key_detail_info_id", -1);
        this.sxG = getIntent().getBooleanExtra("edit_status", false);
        this.fQy = getIntent().getBooleanExtra("show_share", true);
        this.sxo = 1;
        super.KC();
        if (this.sxG) {
            qP(getString(R.l.ejP));
            a(new OnMenuItemClickListener(this) {
                final /* synthetic */ WNNoteFavWebViewUI sxu;

                {
                    this.sxu = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.sxu.goBack();
                    return true;
                }
            }, R.g.bbC);
            a(1, getString(R.l.emz), new OnMenuItemClickListener(this) {
                final /* synthetic */ WNNoteFavWebViewUI sxu;

                {
                    this.sxu = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.sxu.bBZ();
                    this.sxu.bBW();
                    this.sxu.finish();
                    return true;
                }
            }, l.b.uTY);
            ae(1, false);
        } else {
            qP(getString(R.l.ejQ));
            kt(true);
            a(new OnMenuItemClickListener(this) {
                final /* synthetic */ WNNoteFavWebViewUI sxu;

                {
                    this.sxu = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.sxu.finish();
                    return true;
                }
            }, R.g.bbC);
            if (this.fQy) {
                a(1, R.l.eYj, R.g.bhb, new OnMenuItemClickListener(this) {
                    final /* synthetic */ WNNoteFavWebViewUI sxu;

                    {
                        this.sxu = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        e eVar = new e(this.sxu.uSU.uTo, e.wuP, false);
                        eVar.qJf = new c(this) {
                            final /* synthetic */ AnonymousClass12 sxy;

                            {
                                this.sxy = r1;
                            }

                            public final void a(com.tencent.mm.ui.base.l lVar) {
                                if (this.sxy.sxu.getIntent().getBooleanExtra("key_detail_can_share_to_friend", true)) {
                                    lVar.e(0, this.sxy.sxu.getString(R.l.ejs));
                                }
                                lVar.e(1, this.sxy.sxu.getString(R.l.ehS));
                                lVar.e(2, this.sxy.sxu.uSU.uTo.getString(R.l.dGB));
                            }
                        };
                        eVar.qJg = new d(this) {
                            final /* synthetic */ AnonymousClass12 sxy;

                            {
                                this.sxy = r1;
                            }

                            public final void c(MenuItem menuItem, int i) {
                                Intent intent;
                                switch (menuItem.getItemId()) {
                                    case 0:
                                        intent = new Intent();
                                        intent.putExtra("Select_Conv_Type", 3);
                                        intent.putExtra("scene_from", 1);
                                        intent.putExtra("mutil_select_is_ret", true);
                                        intent.putExtra("select_fav_local_id", this.sxy.sxu.hEY);
                                        com.tencent.mm.bb.d.a(this.sxy.sxu, ".ui.transmit.SelectConversationUI", intent, Downloads.RECV_BUFFER_SIZE);
                                        g.oUh.i(10651, new Object[]{Integer.valueOf(18), Integer.valueOf(1), Integer.valueOf(0)});
                                        return;
                                    case 1:
                                        intent = new Intent();
                                        intent.putExtra("key_fav_scene", 2);
                                        intent.putExtra("key_fav_item_id", this.sxy.sxu.hEY);
                                        com.tencent.mm.bb.d.b(this.sxy.sxu.uSU.uTo, "favorite", ".ui.FavTagEditUI", intent);
                                        return;
                                    case 2:
                                        com.tencent.mm.ui.base.g.a(this.sxy.sxu.uSU.uTo, this.sxy.sxu.getString(R.l.dGC), "", new OnClickListener(this) {
                                            final /* synthetic */ AnonymousClass2 sxz;

                                            {
                                                this.sxz = r1;
                                            }

                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                this.sxz.sxy.sxu.sxC = com.tencent.mm.ui.base.g.a(this.sxz.sxy.sxu.uSU.uTo, this.sxz.sxy.sxu.getString(R.l.dGC), false, null);
                                                try {
                                                    if (this.sxz.sxy.sxu.iYF != null) {
                                                        Bundle bundle = new Bundle();
                                                        bundle.putLong("localId", this.sxz.sxy.sxu.hEY);
                                                        this.sxz.sxy.sxu.iYF.d(60, bundle);
                                                    }
                                                } catch (RemoteException e) {
                                                }
                                            }
                                        }, null);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        };
                        eVar.bzh();
                        return false;
                    }
                });
            } else {
                if (this.sxE == null) {
                    this.sxE = (LinearLayout) findViewById(R.h.cSV);
                }
                this.sxE.setVisibility(8);
                return;
            }
        }
        this.sxn = (WNNoteFavVoiceBaseView) findViewById(R.h.cMZ);
        this.lKD = (ImageButton) findViewById(R.h.cNa);
        this.sxh = (ImageButton) findViewById(R.h.cSX);
        this.sxh.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WNNoteFavWebViewUI sxu;

            {
                this.sxu = r1;
            }

            public final void onClick(View view) {
                if (this.sxu.sxD.getVisibility() != 0) {
                    if (this.sxu.sxr == -3) {
                        this.sxu.sxs = true;
                        this.sxu.aHf();
                    }
                    Intent intent = new Intent();
                    intent.putExtra("max_select_count", 9);
                    intent.putExtra("query_source_type", 4);
                    intent.putExtra("send_btn_string", this.sxu.getString(R.l.ehy));
                    intent.addFlags(67108864);
                    com.tencent.mm.bb.d.b(this.sxu, "gallery", ".ui.GalleryEntryUI", intent, 4097);
                }
            }
        });
        this.sxi = (ImageButton) findViewById(R.h.cSY);
        this.sxi.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WNNoteFavWebViewUI sxu;

            {
                this.sxu = r1;
            }

            public final void onClick(View view) {
                if (this.sxu.sxD.getVisibility() != 0) {
                    if (this.sxu.sxr == -3) {
                        this.sxu.sxs = true;
                        this.sxu.aHf();
                    }
                    w.i("MicroMsg.WNNoteFavWebViewUI", "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.sxu, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
                    if (com.tencent.mm.pluginsdk.i.a.a(this.sxu, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                        Intent intent = new Intent();
                        intent.putExtra("MMActivity.OverrideExitAnimation", R.a.aRo);
                        intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.aQX);
                        intent.putExtra("map_view_type", 3);
                        com.tencent.mm.bb.d.b(this.sxu, "location", ".ui.RedirectUI", intent, 4098);
                    }
                }
            }
        });
        this.sxj = (ImageButton) findViewById(R.h.cSW);
        this.sxj.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WNNoteFavWebViewUI sxu;

            {
                this.sxu = r1;
            }

            public final void onClick(View view) {
                if (this.sxu.sxD.getVisibility() != 0) {
                    if (this.sxu.sxr == -3) {
                        this.sxu.sxs = true;
                        this.sxu.aHf();
                    }
                    if (f.rZ()) {
                        Intent intent = new Intent(this.sxu, FileExplorerUI.class);
                        intent.putExtra("key_title", this.sxu.getString(R.l.eiS));
                        this.sxu.startActivityForResult(intent, 4099);
                        return;
                    }
                    s.eP(this.sxu.uSU.uTo);
                }
            }
        });
        this.sxl = (ImageView) findViewById(R.h.cSZ);
        this.sxl.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WNNoteFavWebViewUI sxu;

            {
                this.sxu = r1;
            }

            public final void onClick(View view) {
                if (this.sxu.sxD.getVisibility() != 0) {
                    w.i("MicroMsg.WNNoteFavWebViewUI", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.sxu, "android.permission.RECORD_AUDIO", 80, null, null)), bg.bJZ()});
                    if (!com.tencent.mm.pluginsdk.i.a.a(this.sxu, "android.permission.RECORD_AUDIO", 80, null, null)) {
                        return;
                    }
                    if (this.sxu.rVm == null) {
                        w.e("MicroMsg.WNNoteFavWebViewUI", "wenote_h5_footer_voice jsapi=null");
                        return;
                    }
                    if (this.sxu.sxr != -3) {
                        this.sxu.rVm.bzr();
                    }
                    if (!this.sxu.sxp) {
                        if (!f.rZ()) {
                            s.eP(this.sxu.uSU.uTo);
                            return;
                        } else if (com.tencent.mm.n.a.aJ(this.sxu.uSU.uTo) || com.tencent.mm.n.a.aH(this.sxu.uSU.uTo)) {
                            return;
                        }
                    }
                    if (!this.sxu.sxp) {
                        this.sxu.sxp = true;
                        this.sxu.sxk.setVisibility(0);
                        this.sxu.sxl.setVisibility(8);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put(Columns.TYPE, 4);
                            jSONObject.put("downloaded", false);
                            jSONObject.put("placeHolder", this.sxu.getString(R.l.ejT));
                        } catch (Throwable e) {
                            w.printErrStackTrace("MicroMsg.WNNoteFavWebViewUI", e, "", new Object[0]);
                        }
                        this.sxu.T(jSONObject);
                        j.bBf().a(this.sxu.sxo - 1, this.sxu.sxm, WNNoteFavWebViewUI.o(this.sxu), "amr", "");
                        this.sxu.rVm.bzq();
                    }
                }
            }
        });
        this.sxk = (LinearLayout) findViewById(R.h.coM);
        this.sxm = (TextView) findViewById(R.h.cNL);
        this.sxk.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ WNNoteFavWebViewUI sxu;

            {
                this.sxu = r1;
            }

            public final void onClick(View view) {
                if (this.sxu.sxD.getVisibility() != 0) {
                    this.sxu.bBZ();
                }
            }
        });
        getWindow().setSoftInputMode(16);
    }

    protected final void a(WebViewKeyboardLinearLayout webViewKeyboardLinearLayout, int i) {
        super.a(webViewKeyboardLinearLayout, i);
        w.i("MicroMsg.WNNoteFavWebViewUI", "onKeyBoardStateChange, state = " + i);
        this.sxr = i;
        if (i != -2) {
            return;
        }
        if (this.sxs || this.sxI) {
            this.sxI = false;
        } else if (this.rVm != null) {
            this.rVm.bzr();
        }
    }

    public void finish() {
        super.finish();
    }

    public void onBackPressed() {
        if (this.sxG) {
            goBack();
        } else {
            super.onBackPressed();
        }
    }

    public void onStart() {
        if (!this.sxG && this.sxF) {
            this.sxF = false;
            this.sxD.setVisibility(0);
        }
        super.onStart();
    }

    protected final void s(int i, Bundle bundle) {
        super.s(i, bundle);
        String string;
        switch (i) {
            case 28:
                bundle.getString("fts_key_json_data");
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ WNNoteFavWebViewUI sxu;

                    {
                        this.sxu = r1;
                    }

                    public final void run() {
                        if (this.sxu.rVm != null) {
                            this.sxu.rVm.iZ(true);
                        }
                    }
                });
                return;
            case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                final JSONObject jSONObject = new JSONObject();
                try {
                    boolean z = bundle.getBoolean("downloaded");
                    jSONObject.put("localEditorId", bundle.getString("localEditorId"));
                    jSONObject.put("downloaded", bundle.getString("downloaded"));
                    if (z) {
                        jSONObject.put("length", bundle.getInt("length"));
                        jSONObject.put("lengthStr", bundle.getString("lengthStr"));
                        jSONObject.put("iconPath", bundle.getString("iconPath"));
                        jSONObject.put("localPath", bundle.getString("localPath"));
                    } else {
                        jSONObject.put("placeHolder", bundle.getString("placeHolder"));
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.WNNoteFavWebViewUI", e, "", new Object[0]);
                }
                this.handler.post(new Runnable(this) {
                    final /* synthetic */ WNNoteFavWebViewUI sxu;

                    public final void run() {
                        if (this.sxu.rVm != null) {
                            this.sxu.rVm.R(jSONObject);
                        }
                    }
                });
                return;
            case v.CTRL_BYTE /*41*/:
                this.rVm.ja(true);
                return;
            case 42:
                if (bundle.getBoolean("showVKB", false)) {
                    aHj();
                    return;
                }
                string = bundle.getString("maxhtmlid");
                if (bg.mA(string)) {
                    w.e("MicroMsg.WNNoteFavWebViewUI", "maxhtmlid is null");
                    return;
                } else if (7 < string.length()) {
                    string = string.substring(7, string.length());
                    if (string.matches("[0-9]+")) {
                        this.sxg = bg.getInt(string, 0);
                        this.sxg++;
                        return;
                    }
                    return;
                } else {
                    return;
                }
            case 43:
                if (!this.sxG) {
                    bBY();
                    return;
                }
                return;
            case JsApiGetMusicPlayerState.CTRL_INDEX /*46*/:
                int i2 = bundle.getInt("operation_type");
                bundle.getInt("event.data.type");
                switch (i2) {
                    case 1:
                    case 2:
                        return;
                    case 3:
                        try {
                            T(new JSONObject(bundle.getString("jsonobjstr")));
                            return;
                        } catch (Throwable e2) {
                            w.printErrStackTrace("MicroMsg.WNNoteFavWebViewUI", e2, "", new Object[0]);
                            return;
                        }
                    case 4:
                        string = bundle.getString("jsonobjstr");
                        try {
                            b(new JSONObject(string), bundle.getInt("updateEditorId"));
                            return;
                        } catch (Throwable e22) {
                            w.printErrStackTrace("MicroMsg.WNNoteFavWebViewUI", e22, "", new Object[0]);
                            return;
                        }
                    case 5:
                        string = bundle.getString("htmlStr", "");
                        if (this.sxG) {
                            this.sxq = string;
                            this.handler.post(new Runnable(this) {
                                final /* synthetic */ WNNoteFavWebViewUI sxu;

                                {
                                    this.sxu = r1;
                                }

                                public final void run() {
                                    if (bg.mA(this.sxu.sxq)) {
                                        w.w("MicroMsg.WNNoteFavWebViewUI", "input is empty!!");
                                        this.sxu.ae(1, false);
                                        return;
                                    }
                                    this.sxu.ae(1, true);
                                }
                            });
                            return;
                        }
                        return;
                    case 6:
                        this.rVm.bzq();
                        if (this.sxs) {
                            this.rVm.ja(true);
                            aHj();
                            this.sxs = false;
                            return;
                        }
                        this.rVm.bzr();
                        return;
                    case 7:
                        this.rVm.bzq();
                        return;
                    default:
                        return;
                }
            default:
                return;
        }
    }

    protected void onDestroy() {
        this.sxt.removeMessages(4112);
        j.bBf().bBg();
        super.onDestroy();
    }

    public final void bBW() {
        this.sxt.removeMessages(4112);
        this.handler.post(new Runnable(this) {
            final /* synthetic */ WNNoteFavWebViewUI sxu;

            {
                this.sxu = r1;
            }

            public final void run() {
                if (this.sxu.rVm != null) {
                    this.sxu.rVm.iZ(true);
                }
            }
        });
    }

    public final void bBX() {
        this.sxt.removeMessages(4112);
        this.handler.post(new Runnable(this) {
            final /* synthetic */ WNNoteFavWebViewUI sxu;

            {
                this.sxu = r1;
            }

            public final void run() {
                if (this.sxu.rVm != null) {
                    this.sxu.rVm.iZ(false);
                }
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onActivityResult(int r11, int r12, android.content.Intent r13) {
        /*
        r10 = this;
        r2 = 2;
        r8 = 0;
        r1 = 0;
        r4 = 1;
        r3 = 0;
        super.onActivityResult(r11, r12, r13);
        r0 = "MicroMsg.WNNoteFavWebViewUI";
        r5 = "onActivityResult reqCode: %d, retCod: %d";
        r6 = new java.lang.Object[r2];
        r7 = java.lang.Integer.valueOf(r11);
        r6[r3] = r7;
        r7 = java.lang.Integer.valueOf(r12);
        r6[r4] = r7;
        com.tencent.mm.sdk.platformtools.w.i(r0, r5, r6);
        r0 = -1;
        if (r12 == r0) goto L_0x002d;
    L_0x0023:
        r0 = r10.sxs;
        if (r0 == 0) goto L_0x002c;
    L_0x0027:
        r10.aHj();
        r10.sxs = r3;
    L_0x002c:
        return;
    L_0x002d:
        switch(r11) {
            case 4096: goto L_0x0043;
            case 4097: goto L_0x00e2;
            case 4098: goto L_0x0111;
            case 4099: goto L_0x0173;
            case 4100: goto L_0x00a6;
            default: goto L_0x0030;
        };
    L_0x0030:
        r0 = r2;
    L_0x0031:
        if (r0 == 0) goto L_0x002c;
    L_0x0033:
        if (r4 != r0) goto L_0x01c6;
    L_0x0035:
        r0 = r10.uSU;
        r0 = r0.uTo;
        r1 = com.tencent.mm.R.l.eia;
        r1 = r10.getString(r1);
        com.tencent.mm.ui.base.g.bl(r0, r1);
        goto L_0x002c;
    L_0x0043:
        if (r13 != 0) goto L_0x0059;
    L_0x0045:
        r5 = r1;
    L_0x0046:
        if (r13 != 0) goto L_0x0062;
    L_0x0048:
        r0 = r1;
    L_0x0049:
        r6 = com.tencent.mm.sdk.platformtools.bg.mA(r5);
        if (r6 == 0) goto L_0x006a;
    L_0x004f:
        r0 = "MicroMsg.WNNoteFavWebViewUI";
        r1 = "want to send record msg, but toUser is null";
        com.tencent.mm.sdk.platformtools.w.w(r0, r1);
        goto L_0x002c;
    L_0x0059:
        r0 = "Select_Conv_User";
        r0 = r13.getStringExtra(r0);
        r5 = r0;
        goto L_0x0046;
    L_0x0062:
        r0 = "custom_send_text";
        r0 = r13.getStringExtra(r0);
        goto L_0x0049;
    L_0x006a:
        r6 = r10.uSU;
        r6 = r6.uTo;
        r7 = com.tencent.mm.R.l.eit;
        r7 = r10.getString(r7);
        r1 = com.tencent.mm.ui.base.g.a(r6, r7, r3, r1);
        r10.sxC = r1;
        r1 = r10.iYF;
        if (r1 == 0) goto L_0x0030;
    L_0x007e:
        r1 = new android.os.Bundle;
        r1.<init>();
        r6 = "username";
        r1.putString(r6, r5);
        r5 = "customText";
        r1.putString(r5, r0);
        r0 = r10.iYF;	 Catch:{ RemoteException -> 0x0098 }
        r5 = 62;
        r0.d(r5, r1);	 Catch:{ RemoteException -> 0x0098 }
        r0 = r2;
        goto L_0x0031;
    L_0x0098:
        r0 = move-exception;
        r1 = "MicroMsg.WNNoteFavWebViewUI";
        r5 = "";
        r3 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r5, r3);
        r0 = r2;
        goto L_0x0031;
    L_0x00a6:
        r0 = "voicepath";
        r0 = r13.getStringExtra(r0);
        r1 = "voiceduration";
        r1 = r13.getIntExtra(r1, r3);
        r2 = r10.iYF;
        if (r2 == 0) goto L_0x00df;
    L_0x00b8:
        r2 = new android.os.Bundle;
        r2.<init>();
        r5 = "voicepath";
        r2.putString(r5, r0);
        r0 = "duration";
        r2.putInt(r0, r1);
        r0 = r10.iYF;	 Catch:{ RemoteException -> 0x00d3 }
        r1 = 64;
        r0.d(r1, r2);	 Catch:{ RemoteException -> 0x00d3 }
        r0 = r3;
        goto L_0x0031;
    L_0x00d3:
        r0 = move-exception;
        r1 = "MicroMsg.WNNoteFavWebViewUI";
        r2 = "";
        r5 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r2, r5);
    L_0x00df:
        r0 = r3;
        goto L_0x0031;
    L_0x00e2:
        r0 = "CropImage_OutputPath_List";
        r0 = r13.getStringArrayListExtra(r0);
        if (r0 == 0) goto L_0x00f1;
    L_0x00eb:
        r1 = r0.size();
        if (r1 != 0) goto L_0x00fc;
    L_0x00f1:
        r0 = "MicroMsg.WNNoteFavWebViewUI";
        r1 = "onActivityResult pathList is null or nil";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        goto L_0x002c;
    L_0x00fc:
        r1 = r0.size();
        if (r1 <= r4) goto L_0x0104;
    L_0x0102:
        r10.sxs = r3;
    L_0x0104:
        r1 = r10.handler;
        r2 = new com.tencent.mm.plugin.wenote.ui.h5note.WNNoteFavWebViewUI$6;
        r2.<init>(r10, r0);
        r1.post(r2);
        r0 = r3;
        goto L_0x0031;
    L_0x0111:
        r0 = X(r13);
        r1 = new android.os.Bundle;
        r1.<init>();
        r2 = "latitude";
        r5 = "kwebmap_slat";
        r6 = r13.getDoubleExtra(r5, r8);
        r5 = (float) r6;
        r6 = (double) r5;
        r1.putDouble(r2, r6);
        r2 = "longtitude";
        r5 = "kwebmap_lng";
        r6 = r13.getDoubleExtra(r5, r8);
        r5 = (float) r6;
        r6 = (double) r5;
        r1.putDouble(r2, r6);
        r2 = "scale";
        r5 = "kwebmap_scale";
        r5 = r13.getIntExtra(r5, r3);
        r1.putInt(r2, r5);
        r2 = "loclabel";
        r5 = "Kwebmap_locaion";
        r5 = r13.getStringExtra(r5);
        r6 = "";
        r5 = com.tencent.mm.sdk.platformtools.bg.ap(r5, r6);
        r1.putString(r2, r5);
        r2 = "locpoiname";
        r5 = "kPoiName";
        r5 = r13.getStringExtra(r5);
        r1.putString(r2, r5);
        r2 = r10.handler;
        r5 = new com.tencent.mm.plugin.wenote.ui.h5note.WNNoteFavWebViewUI$7;
        r5.<init>(r10, r1, r0);
        r2.post(r5);
        r0 = r3;
        goto L_0x0031;
    L_0x0173:
        r0 = "choosed_file_path";
        r0 = r13.getStringExtra(r0);
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r1 == 0) goto L_0x0183;
    L_0x0180:
        r0 = r4;
        goto L_0x0031;
    L_0x0183:
        r1 = new java.io.File;
        r1.<init>(r0);
        r5 = r1.exists();
        if (r5 != 0) goto L_0x0191;
    L_0x018e:
        r0 = r4;
        goto L_0x0031;
    L_0x0191:
        r6 = r1.length();
        r8 = 26214400; // 0x1900000 float:5.2897246E-38 double:1.29516345E-316;
        r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r1 < 0) goto L_0x019f;
    L_0x019c:
        r0 = 3;
        goto L_0x0031;
    L_0x019f:
        r1 = r10.iYF;
        if (r1 == 0) goto L_0x0030;
    L_0x01a3:
        r1 = new android.os.Bundle;
        r1.<init>();
        r5 = "path";
        r1.putString(r5, r0);
        r0 = r10.iYF;	 Catch:{ RemoteException -> 0x01b8 }
        r5 = 67;
        r0.d(r5, r1);	 Catch:{ RemoteException -> 0x01b8 }
        r0 = r2;
        goto L_0x0031;
    L_0x01b8:
        r0 = move-exception;
        r1 = "MicroMsg.WNNoteFavWebViewUI";
        r5 = "";
        r3 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.w.printErrStackTrace(r1, r0, r5, r3);
        goto L_0x0030;
    L_0x01c6:
        r1 = 3;
        if (r1 != r0) goto L_0x002c;
    L_0x01c9:
        r0 = r10.uSU;
        r0 = r0.uTo;
        r1 = com.tencent.mm.R.l.ejH;
        r1 = r10.getString(r1);
        r0 = android.widget.Toast.makeText(r0, r1, r4);
        r0.show();
        goto L_0x002c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.ui.h5note.WNNoteFavWebViewUI.onActivityResult(int, int, android.content.Intent):void");
    }

    private void e(JSONObject jSONObject, String str) {
        try {
            jSONObject.put("localEditorId", str);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.WNNoteFavWebViewUI", e, "", new Object[0]);
        }
        this.rVm.R(jSONObject);
        final String jSONObject2 = jSONObject.toString();
        this.handler.post(new Runnable(this) {
            final /* synthetic */ WNNoteFavWebViewUI sxu;

            public final void run() {
                if (this.sxu.iYF != null) {
                    Bundle bundle = new Bundle();
                    bundle.putString("insertJsonString", jSONObject2);
                    try {
                        this.sxu.iYF.d(53, bundle);
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.WNNoteFavWebViewUI", e, "", new Object[0]);
                    }
                }
            }
        });
    }

    private void b(JSONObject jSONObject, int i) {
        e(jSONObject, "WeNote_" + Integer.toString(i));
    }

    private void T(JSONObject jSONObject) {
        if (!this.sxG) {
            bBY();
        }
        StringBuilder stringBuilder = new StringBuilder("WeNote_");
        int i = this.sxo;
        this.sxo = i + 1;
        e(jSONObject, stringBuilder.append(Integer.toString(i)).toString());
    }

    private void bBY() {
        if (!this.sxG) {
            this.sxG = true;
        }
        if (this.sxg > 1) {
            this.sxo = this.sxg;
        }
        this.sxH = true;
        qP(getString(R.l.ejP));
        a(new OnMenuItemClickListener(this) {
            final /* synthetic */ WNNoteFavWebViewUI sxu;

            {
                this.sxu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.sxu.goBack();
                return true;
            }
        }, R.g.bbC);
        a(1, getString(R.l.emz), new OnMenuItemClickListener(this) {
            final /* synthetic */ WNNoteFavWebViewUI sxu;

            {
                this.sxu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.sxu.bBZ();
                this.sxu.bBX();
                this.sxu.finish();
                return true;
            }
        }, l.b.uTY);
        ae(1, false);
        this.oET.setOnLongClickListener(this.seC);
    }

    public final void bBZ() {
        if (this.sxp) {
            this.sxp = false;
            this.sxk.setVisibility(8);
            this.sxl.setVisibility(0);
            j.bBf().bBg();
            String bBh = j.bBf().bBh();
            JSONObject jSONObject = new JSONObject();
            if (!bg.mA(bBh)) {
                int i = (int) j.bBf().duration;
                int aw = (int) com.tencent.mm.ay.b.aw((long) i);
                try {
                    jSONObject.put("downloaded", true);
                    jSONObject.put("length", i);
                    jSONObject.put("lengthStr", com.tencent.mm.ay.b.s(this.uSU.uTo, aw).toString());
                    jSONObject.put("iconPath", com.tencent.mm.ay.a.Mf() + "/fav_fileicon_recording.png");
                    jSONObject.put("localPath", bBh);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.WNNoteFavWebViewUI", e, "", new Object[0]);
                }
            }
            try {
                jSONObject.put(Columns.TYPE, 4);
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.WNNoteFavWebViewUI", e2, "", new Object[0]);
            }
            b(jSONObject, j.bBf().sup);
            this.rVm.bzq();
        }
    }

    private void goBack() {
        aHf();
        if (bg.mA(this.sxq)) {
            finish();
        } else {
            com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.eOl), "", getString(R.l.dPP), getString(R.l.dPQ), new OnClickListener(this) {
                final /* synthetic */ WNNoteFavWebViewUI sxu;

                {
                    this.sxu = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.sxu.bBZ();
                    WNNoteFavWebViewUI wNNoteFavWebViewUI = this.sxu;
                    if (wNNoteFavWebViewUI.sxH) {
                        wNNoteFavWebViewUI.bBX();
                    } else {
                        wNNoteFavWebViewUI.bBW();
                    }
                    this.sxu.finish();
                }
            }, new OnClickListener(this) {
                final /* synthetic */ WNNoteFavWebViewUI sxu;

                {
                    this.sxu = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.sxu.setResult(0);
                    this.sxu.finish();
                }
            });
        }
    }

    private static String X(Intent intent) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Columns.TYPE, 3);
            jSONObject.put("downloaded", true);
            jSONObject.put("poiName", intent.getStringExtra("kPoiName"));
            jSONObject.put("address", bg.ap(intent.getStringExtra("Kwebmap_locaion"), ""));
            jSONObject.put("lat", (double) ((float) intent.getDoubleExtra("kwebmap_slat", 0.0d)));
            jSONObject.put("lng", (double) ((float) intent.getDoubleExtra("kwebmap_lng", 0.0d)));
            jSONObject.put("scale", intent.getIntExtra("kwebmap_scale", 0));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.WNNoteFavWebViewUI", e, "", new Object[0]);
        }
        return jSONObject.toString();
    }

    public final void bBm() {
        bBZ();
    }

    public final void qP(String str) {
        if (this.sxG) {
            super.qP(getString(R.l.ejP));
        } else {
            super.qP(getString(R.l.ejQ));
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.WNNoteFavWebViewUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                if (iArr[0] != 0) {
                    com.tencent.mm.ui.base.g.a(this, getString(R.l.eFJ), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ WNNoteFavWebViewUI sxu;

                        {
                            this.sxu = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            this.sxu.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, new OnClickListener(this) {
                        final /* synthetic */ WNNoteFavWebViewUI sxu;

                        {
                            this.sxu = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }
}
