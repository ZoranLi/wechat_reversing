package com.tencent.mm.plugin.welab.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.t;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bb.d;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.welab.a.c;
import com.tencent.mm.plugin.welab.e;
import com.tencent.mm.plugin.welab.g;
import com.tencent.mm.plugin.welab.ui.widget.WelabRoundCornerImageView;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.ain;
import com.tencent.mm.protocal.c.aio;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;

public class WelabAppInfoUI extends MMActivity {
    private String fTO;
    private TextView ioX;
    private Button lKM;
    private TextView ouW;
    private com.tencent.mm.plugin.welab.c.a.a ssW;
    private int ssX;
    private boolean ssY;
    private WelabRoundCornerImageView ssZ;
    private RecyclerView sta;
    private View stb;
    private View stc;
    private MMSwitchBtn std;
    private TextView ste;
    private View stf;
    private View stg;
    private a sth;
    private OnClickListener sti = new OnClickListener(this) {
        final /* synthetic */ WelabAppInfoUI stj;

        {
            this.stj = r1;
        }

        public final void onClick(View view) {
            String obj = view.getTag().toString();
            Intent intent = new Intent();
            intent.putExtra("nowUrl", obj);
            intent.putExtra("urlList", (String[]) ((a) this.stj.sta.fn()).kBf.toArray(new String[0]));
            Context context = this.stj;
            Intent intent2 = new Intent();
            intent2.putExtras(intent.getExtras());
            if (intent.getFlags() != 0) {
                intent2.addFlags(intent.getFlags());
            }
            d.b(context, "subapp", ".ui.gallery.GestureGalleryUI", intent2);
        }
    };

    private class a extends android.support.v7.widget.RecyclerView.a<b> {
        public List<String> kBf;
        final /* synthetic */ WelabAppInfoUI stj;

        public final /* synthetic */ t a(ViewGroup viewGroup, int i) {
            View inflate = this.stj.getLayoutInflater().inflate(c.ssD, viewGroup, false);
            t bVar = new b(this.stj, inflate);
            bVar.stk = (ImageView) inflate.findViewById(com.tencent.mm.plugin.welab.a.b.sss);
            bVar.stk.setOnClickListener(this.stj.sti);
            return bVar;
        }

        public final /* synthetic */ void a(t tVar, int i) {
            b bVar = (b) tVar;
            bVar.stk.setTag(this.kBf.get(i));
            com.tencent.mm.ah.a.a.Hd().a((String) this.kBf.get(i), bVar.stk, com.tencent.mm.plugin.welab.b.bAG().ssQ);
        }

        public a(WelabAppInfoUI welabAppInfoUI) {
            this.stj = welabAppInfoUI;
        }

        public final int getItemCount() {
            return this.kBf.size();
        }
    }

    private class b extends t {
        final /* synthetic */ WelabAppInfoUI stj;
        public ImageView stk;

        public b(WelabAppInfoUI welabAppInfoUI, View view) {
            this.stj = welabAppInfoUI;
            super(view);
        }
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            this.fTO = intent.getStringExtra("para_appid");
            this.ssW = com.tencent.mm.plugin.welab.b.bAG().KU(this.fTO);
            this.ssX = this.ssW.field_Switch;
            if (getIntent().getIntExtra("para_from_with_red_point", 0) != 1) {
                z = false;
            }
            this.ssY = z;
        }
        KC();
        e.o(this.fTO, 2, this.ssY);
    }

    protected final int getLayoutId() {
        return c.ssF;
    }

    protected final void KC() {
        super.KC();
        if (this.ssW == null) {
            w.e("WelabAppInfoUI", "info is null");
            return;
        }
        bPR();
        zk(8);
        if (VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(201326592);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(com.tencent.mm.plugin.welab.a.a.sso));
        }
        if (cO().cP() != null) {
            cO().cP().getCustomView().setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.welab.a.a.sso));
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WelabAppInfoUI stj;

            {
                this.stj = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.stj.aHf();
                this.stj.finish();
                return true;
            }
        });
        this.ssZ = (WelabRoundCornerImageView) findViewById(com.tencent.mm.plugin.welab.a.b.ssp);
        this.ioX = (TextView) findViewById(com.tencent.mm.plugin.welab.a.b.title);
        this.ouW = (TextView) findViewById(com.tencent.mm.plugin.welab.a.b.summary);
        this.sta = (RecyclerView) findViewById(com.tencent.mm.plugin.welab.a.b.sst);
        this.stb = findViewById(com.tencent.mm.plugin.welab.a.b.ssq);
        this.lKM = (Button) findViewById(com.tencent.mm.plugin.welab.a.b.cpt);
        this.stc = findViewById(com.tencent.mm.plugin.welab.a.b.ssr);
        this.std = (MMSwitchBtn) findViewById(com.tencent.mm.plugin.welab.a.b.checkbox);
        this.ste = (TextView) findViewById(com.tencent.mm.plugin.welab.a.b.ssB);
        this.stf = findViewById(com.tencent.mm.plugin.welab.a.b.ssA);
        this.stg = findViewById(com.tencent.mm.plugin.welab.a.b.ssx);
        this.sta.a(new LinearLayoutManager(0, false));
        this.sta.setOverScrollMode(2);
        this.sth = new a(this);
        this.sta.a(this.sth);
    }

    protected void onPause() {
        super.onPause();
        if (this.ssX != this.ssW.field_Switch) {
            com.tencent.mm.plugin.welab.b.bAG().ssN.c(this.ssW, new String[0]);
            com.tencent.mm.bd.a com_tencent_mm_protocal_c_aio = new aio();
            ain com_tencent_mm_protocal_c_ain = new ain();
            com_tencent_mm_protocal_c_ain.tMw = bg.PY(this.ssW.field_expId);
            com_tencent_mm_protocal_c_ain.tMx = this.ssW.field_LabsAppId;
            com_tencent_mm_protocal_c_ain.tAL = this.ssW.field_Switch == 2 ? 1 : 2;
            com_tencent_mm_protocal_c_aio.gMT.add(com_tencent_mm_protocal_c_ain);
            ((h) com.tencent.mm.kernel.h.h(h.class)).wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(207, com_tencent_mm_protocal_c_aio));
            e.o(this.fTO, this.ssW.field_Switch == 2 ? 4 : 5, this.ssY);
        }
    }

    protected void onResume() {
        TextView textView;
        com.tencent.mm.ah.a.a Hd;
        super.onResume();
        if (this.ssW.bAR() && this.ssW.field_Type == 1) {
            this.stb.setVisibility(0);
            this.ste.setText(getResources().getString(com.tencent.mm.plugin.welab.a.d.ssK) + this.ssW.Lb("field_Title"));
            SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
            this.std.setEnabled(true);
            if (this.ssW.field_Switch == 2) {
                sharedPreferences.edit().putBoolean(bAS(), true).commit();
                this.std.lS(true);
            } else {
                sharedPreferences.edit().putBoolean(bAS(), false).commit();
                this.std.lS(false);
            }
            this.std.wwD = new com.tencent.mm.ui.widget.MMSwitchBtn.a(this) {
                final /* synthetic */ WelabAppInfoUI stj;

                {
                    this.stj = r1;
                }

                public final void bK(boolean z) {
                    if (this.stj.ssW.field_Switch == 2) {
                        this.stj.ssW.field_Switch = 1;
                    } else if (this.stj.ssW.field_Switch == 1) {
                        this.stj.ssW.field_Switch = 2;
                    }
                }
            };
        } else {
            this.stb.setVisibility(8);
        }
        if (this.ssW.bAR()) {
            this.lKM.setText(getResources().getString(com.tencent.mm.plugin.welab.a.d.ssI) + this.ssW.Lb("field_Title"));
            if (this.ssW.field_Type != 1) {
                this.lKM.setVisibility(0);
                this.lKM.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ WelabAppInfoUI stj;

                    {
                        this.stj = r1;
                    }

                    public final void onClick(View view) {
                        w.i("WelabAppInfoUI", "open func " + this.stj.fTO);
                        com.tencent.mm.plugin.welab.b bAG = com.tencent.mm.plugin.welab.b.bAG();
                        Activity activity = this.stj;
                        String b = this.stj.fTO;
                        com.tencent.mm.plugin.welab.a.a.b bVar = (com.tencent.mm.plugin.welab.a.a.b) bAG.ssO.get(b);
                        if (bVar != null) {
                            w.i("WelabMgr", "use custome opener to open " + b);
                            bVar.c(activity, b);
                        } else {
                            w.i("WelabMgr", "use default opener open " + b);
                            if (bAG.KU(b).field_Type != 2) {
                                w.e("WelabMgr", "can not find opener for " + b);
                            } else if (bAG.ssP != null) {
                                bAG.ssP.c(activity, b);
                            } else {
                                w.e("WelabMgr", "defaultWeAppOpener is null!");
                            }
                        }
                        e.o(this.stj.fTO, 7, this.stj.ssY);
                    }
                });
                textView = this.ioX;
                com.tencent.mm.plugin.welab.b.bAG();
                textView.setText(com.tencent.mm.plugin.welab.b.a(this.ssW));
                this.ouW.setText(this.ssW.Lb("field_Introduce"));
                if (this.ssW.bAR()) {
                    this.stc.setVisibility(8);
                } else {
                    this.stc.setVisibility(0);
                    this.stc.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ WelabAppInfoUI stj;

                        {
                            this.stj = r1;
                        }

                        public final void onClick(View view) {
                            try {
                                String str = "";
                                com.tencent.mm.kernel.h.vG();
                                int uH = com.tencent.mm.kernel.a.uH();
                                String encode = URLEncoder.encode(com.tencent.mm.protocal.d.sYL, ProtocolPackage.ServerEncoding);
                                String encode2 = URLEncoder.encode(bg.bJS(), ProtocolPackage.ServerEncoding);
                                String encode3 = URLEncoder.encode(p.rA(), ProtocolPackage.ServerEncoding);
                                String encode4 = URLEncoder.encode(com.tencent.mm.protocal.d.sYG, ProtocolPackage.ServerEncoding);
                                String encode5 = URLEncoder.encode(com.tencent.mm.protocal.d.sYH, ProtocolPackage.ServerEncoding);
                                String encode6 = URLEncoder.encode(com.tencent.mm.protocal.d.sYI, ProtocolPackage.ServerEncoding);
                                com.tencent.mm.kernel.h.vG();
                                String str2 = ("https://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=feedback/index" + "&from=" + URLEncoder.encode(this.stj.ssW.field_expId + "|" + this.stj.fTO) + "&version=" + com.tencent.mm.protocal.d.sYN + "&lang=" + v.ea(ab.getContext()) + "&" + bg.mz(str) + ("&uin=" + uH + "&deviceName=" + encode + "&timeZone=" + encode2 + "&imei=" + encode3 + "&deviceBrand=" + encode4 + "&deviceModel=" + encode5 + "&ostype=" + encode6 + "&clientSeqID=" + URLEncoder.encode(com.tencent.mm.kernel.a.uY(), ProtocolPackage.ServerEncoding) + "&signature=" + URLEncoder.encode(bg.ep(ab.getContext()), ProtocolPackage.ServerEncoding) + "&scene=" + (bg.mA(str) ? 0 : 1))) + "#/comment/4134";
                                Intent intent = new Intent();
                                intent.putExtra("showShare", false);
                                intent.putExtra("rawUrl", str2);
                                intent.putExtra("title", "意见反馈");
                                intent.putExtra("neverGetA8Key", true);
                                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.sYZ);
                                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.sYW);
                                d.b(this.stj, "webview", ".ui.tools.WebViewUI", intent);
                            } catch (UnsupportedEncodingException e) {
                                w.e("WelabAppInfoUI", "[oneliang]UnsupportedEncodingException:%s", new Object[]{e.getMessage()});
                            }
                        }
                    });
                }
                if (this.ssW.bAR()) {
                    this.stf.setVisibility(0);
                    this.stg.setVisibility(8);
                } else {
                    this.stf.setVisibility(8);
                    this.stg.setVisibility(0);
                }
                bAT();
                this.ssZ.stu = 0.5f;
                Hd = com.tencent.mm.ah.a.a.Hd();
                com.tencent.mm.plugin.welab.b.bAG();
                Hd.a(com.tencent.mm.plugin.welab.b.b(this.ssW), this.ssZ, com.tencent.mm.plugin.welab.b.bAG().ssQ);
            }
        }
        this.lKM.setVisibility(8);
        textView = this.ioX;
        com.tencent.mm.plugin.welab.b.bAG();
        textView.setText(com.tencent.mm.plugin.welab.b.a(this.ssW));
        this.ouW.setText(this.ssW.Lb("field_Introduce"));
        if (this.ssW.bAR()) {
            this.stc.setVisibility(8);
        } else {
            this.stc.setVisibility(0);
            this.stc.setOnClickListener(/* anonymous class already generated */);
        }
        if (this.ssW.bAR()) {
            this.stf.setVisibility(0);
            this.stg.setVisibility(8);
        } else {
            this.stf.setVisibility(8);
            this.stg.setVisibility(0);
        }
        bAT();
        this.ssZ.stu = 0.5f;
        Hd = com.tencent.mm.ah.a.a.Hd();
        com.tencent.mm.plugin.welab.b.bAG();
        Hd.a(com.tencent.mm.plugin.welab.b.b(this.ssW), this.ssZ, com.tencent.mm.plugin.welab.b.bAG().ssQ);
    }

    private String bAS() {
        return "switch_" + this.ssW.field_LabsAppId;
    }

    private void bAT() {
        String Lb = this.ssW.Lb("field_ImgUrl_android");
        if (TextUtils.isEmpty(Lb)) {
            Lb = this.ssW.Lb("field_ImgUrl");
        }
        List KX = g.KX(Lb);
        Iterator it = KX.iterator();
        while (it.hasNext()) {
            if (TextUtils.isEmpty((String) it.next())) {
                it.remove();
            }
        }
        if (KX.isEmpty()) {
            this.sta.setVisibility(8);
            return;
        }
        this.sta.setVisibility(0);
        this.sth.kBf = KX;
        this.sth.aab.notifyChanged();
    }
}
