package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.gt;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Req;
import com.tencent.mm.opensdk.modelmsg.SendAuth.Resp;
import com.tencent.mm.plugin.webview.model.t;
import com.tencent.mm.plugin.webview.model.u;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.aod;
import com.tencent.mm.protocal.c.awk;
import com.tencent.mm.protocal.c.awm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;

public final class SDKOAuthUI extends MMActivity implements e {
    private p iLz;
    private String ivH;
    private Req sbA;
    private aj sbB;
    private a sbC;
    private boolean sbD;

    private static final class a extends BaseAdapter {
        private LayoutInflater Du;
        private LinkedList<aod> sbG;

        private static final class a {
            ImageView jqA;
            TextView jqB;
        }

        public final /* synthetic */ Object getItem(int i) {
            return wk(i);
        }

        public a(Context context, LinkedList<aod> linkedList) {
            this.Du = LayoutInflater.from(context);
            this.sbG = linkedList;
        }

        public final LinkedList<String> bxO() {
            LinkedList<String> linkedList = new LinkedList();
            for (int i = 0; i < this.sbG.size(); i++) {
                aod com_tencent_mm_protocal_c_aod = (aod) this.sbG.get(i);
                if (com_tencent_mm_protocal_c_aod.tTm == 2 || com_tencent_mm_protocal_c_aod.tTm == 3) {
                    linkedList.add(com_tencent_mm_protocal_c_aod.scope);
                }
            }
            return linkedList;
        }

        public final int getCount() {
            return this.sbG == null ? 0 : this.sbG.size();
        }

        private aod wk(int i) {
            return (aod) this.sbG.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (this.sbG == null || this.sbG.size() <= 0) {
                return null;
            }
            a aVar;
            final aod wk = wk(i);
            if (view == null) {
                a aVar2 = new a();
                view = this.Du.inflate(R.i.dng, null, false);
                aVar2.jqA = (ImageView) view.findViewById(R.h.boN);
                aVar2.jqB = (TextView) view.findViewById(R.h.boM);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (wk.tTm == 1) {
                aVar.jqA.setImageResource(R.k.dxA);
            } else if (wk.tTm == 3) {
                aVar.jqA.setImageResource(R.k.dxz);
            } else {
                aVar.jqA.setImageResource(R.k.dxy);
            }
            aVar.jqB.setText(wk.desc);
            final ImageView imageView = aVar.jqA;
            aVar.jqA.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a sbI;

                public final void onClick(View view) {
                    if (wk.tTm == 2) {
                        imageView.setImageResource(R.k.dxA);
                        wk.tTm = 1;
                    } else if (wk.tTm == 1) {
                        imageView.setImageResource(R.k.dxy);
                        wk.tTm = 2;
                    }
                }
            });
            return view;
        }
    }

    static /* synthetic */ void a(SDKOAuthUI sDKOAuthUI, String str, String str2, String str3, LinkedList linkedList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < linkedList.size(); i++) {
            stringBuilder.append((String) linkedList.get(i)).append(",");
        }
        w.i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorizeConfirm selectedScopes: %s", new Object[]{stringBuilder.toString()});
        if (sDKOAuthUI.sbB != null) {
            sDKOAuthUI.sbB.KH();
            sDKOAuthUI.sbB.v(3000, 3000);
        } else {
            sDKOAuthUI.sbB = new aj(new com.tencent.mm.sdk.platformtools.aj.a(sDKOAuthUI) {
                final /* synthetic */ SDKOAuthUI sbE;

                {
                    this.sbE = r1;
                }

                public final boolean oQ() {
                    if (this.sbE.isFinishing()) {
                        w.i("MicroMsg.SdkOAuthUI", "onTimerExpired isFinishing");
                    } else {
                        this.sbE.bxL();
                    }
                    return false;
                }
            }, false);
            sDKOAuthUI.sbB.v(3000, 3000);
        }
        ap.vd().a(new u(1, str, str2, str3, linkedList), 0);
    }

    static /* synthetic */ void b(SDKOAuthUI sDKOAuthUI, String str) {
        String JL = JL(sDKOAuthUI.ivH);
        if (bg.mA(JL)) {
            w.e("MicroMsg.SdkOAuthUI", "dealWithError pkg nil");
            return;
        }
        Resp resp = new Resp();
        resp.transaction = sDKOAuthUI.sbA.transaction;
        resp.errCode = -1;
        resp.errStr = str;
        resp.lang = sDKOAuthUI.bxN();
        resp.country = getCountry();
        sDKOAuthUI.a(JL, resp);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        qP(getString(R.l.fnc));
        SE(getString(R.l.ePy));
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SDKOAuthUI sbE;

            {
                this.sbE = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.sbE.bxK();
                this.sbE.finish();
                return true;
            }
        });
        if (ap.zb()) {
            this.sbD = false;
            Bundle extras = getIntent().getExtras();
            String string = extras.getString(ConstantsAPI.CONTENT);
            if (bg.mA(string)) {
                w.e("MicroMsg.SdkOAuthUI", "init content is nil");
                return;
            }
            this.ivH = Uri.parse(string).getQueryParameter("appid");
            string = this.ivH;
            f aJ = g.aJ(string, false);
            if (aJ != null && bg.mA(aJ.field_openId)) {
                w.i("MicroMsg.SdkOAuthUI", "checkGetAppSetting appId: %s ", new Object[]{string});
                b gtVar = new gt();
                gtVar.fMe.appId = string;
                com.tencent.mm.sdk.b.a.urY.m(gtVar);
            }
            this.sbA = new Req(extras);
            string = this.ivH;
            String str = this.sbA.scope;
            String str2 = this.sbA.state;
            String JL = JL(this.ivH);
            w.i("MicroMsg.SdkOAuthUI", "doSDKOauthAuthorize appid: %s", new Object[]{string});
            bxL();
            ap.vd().a(new t(string, str, str2, JL, bg.mA(JL) ? null : com.tencent.mm.a.g.n(com.tencent.mm.pluginsdk.model.app.p.aR(this, JL)[0].toByteArray())), 0);
            return;
        }
        w.e("MicroMsg.SdkOAuthUI", "start, hasSetUin fail");
        Toast.makeText(this, R.l.dBK, 1).show();
    }

    protected final void onResume() {
        super.onResume();
        ap.vd().a(1346, this);
        ap.vd().a(1388, this);
    }

    protected final void onPause() {
        super.onPause();
        ap.vd().b(1388, this);
        ap.vd().b(1346, this);
    }

    protected final void onDestroy() {
        super.onDestroy();
        if (this.iLz != null) {
            this.iLz.dismiss();
        }
        if (this.sbB != null) {
            this.sbB.KH();
        }
    }

    protected final int getLayoutId() {
        return R.i.dnh;
    }

    public final void VK() {
        super.VK();
        bxK();
    }

    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        bxK();
        finish();
        return true;
    }

    private void JJ(String str) {
        String str2 = null;
        w.i("MicroMsg.SdkOAuthUI", "dealWithLoginCallback url : %s", new Object[]{str});
        String JL = JL(this.ivH);
        if (bg.mA(JL)) {
            w.e("MicroMsg.SdkOAuthUI", "dealWithLoginCallback pkg nil");
            return;
        }
        Uri uri;
        Resp resp = new Resp();
        resp.transaction = this.sbA.transaction;
        resp.lang = bxN();
        resp.country = getCountry();
        if (bg.mA(str)) {
            uri = null;
        } else {
            uri = Uri.parse(str);
        }
        if (uri != null) {
            str2 = uri.getQueryParameter(TMQQDownloaderOpenSDKConst.UINTYPE_CODE);
            resp.state = uri.getQueryParameter("state");
            resp.errStr = uri.getQueryParameter("reason");
        }
        if (bg.mA(str2)) {
            resp.errCode = -1;
        } else if (str2.toLowerCase().equals("authdeny")) {
            resp.errCode = -4;
        } else {
            resp.errCode = 0;
            resp.code = str2;
        }
        resp.url = str;
        w.i("MicroMsg.SdkOAuthUI", "dealWithLoginCallback, pkg:%s code:%s errCode:%d state:%s", new Object[]{JL, resp.code, Integer.valueOf(resp.errCode), resp.state});
        a(JL, resp);
        finish();
    }

    private void bxK() {
        LinkedList linkedList;
        w.i("MicroMsg.SdkOAuthUI", "dealWithCancel");
        String JL = JL(this.ivH);
        String str = this.ivH;
        String str2 = this.sbA.state;
        if (this.sbC == null) {
            linkedList = null;
        } else {
            linkedList = this.sbC.bxO();
        }
        ap.vd().a(new u(2, str, str2, JL, linkedList), 0);
        Resp resp = new Resp();
        resp.transaction = this.sbA.transaction;
        resp.errCode = -2;
        resp.lang = bxN();
        resp.country = getCountry();
        a(JL, resp);
    }

    private void a(String str, Resp resp) {
        if (this.sbD) {
            w.i("MicroMsg.SdkOAuthUI", "doCallback has callback");
        } else if (!bg.mA(str)) {
            this.sbD = true;
            Bundle bundle = new Bundle();
            resp.toBundle(bundle);
            com.tencent.mm.pluginsdk.model.app.p.aa(bundle);
            Args args = new Args();
            args.targetPkgName = str;
            args.bundle = bundle;
            MMessageActV2.send(this, args);
        }
    }

    private void JK(final String str) {
        com.tencent.mm.ui.base.g.a(this, str, getString(R.l.fmU), new DialogInterface.OnClickListener(this) {
            final /* synthetic */ SDKOAuthUI sbE;

            public final void onClick(DialogInterface dialogInterface, int i) {
                SDKOAuthUI.b(this.sbE, str);
            }
        });
    }

    private void bxL() {
        if (this.iLz == null || this.iLz.isShowing()) {
            this.iLz = com.tencent.mm.ui.base.g.a(this, getString(R.l.eFd), true, new OnCancelListener(this) {
                final /* synthetic */ SDKOAuthUI sbE;

                {
                    this.sbE = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    try {
                        dialogInterface.dismiss();
                    } catch (Exception e) {
                        w.e("MicroMsg.SdkOAuthUI", "showProgressDlg onCancel exp: %s ", new Object[]{e.getLocalizedMessage()});
                    }
                }
            });
        } else {
            this.iLz.show();
        }
    }

    private void bxM() {
        if (this.iLz != null) {
            this.iLz.dismiss();
        }
    }

    private boolean wj(int i) {
        if (i == 1 || i == 2 || i == 7 || i == 8) {
            w.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, errType = " + i);
            return false;
        } else if (am.isConnected(this)) {
            return true;
        } else {
            w.e("MicroMsg.SdkOAuthUI", "isNetworkAvailable false, not connected");
            return false;
        }
    }

    private String bxN() {
        return v.d(getSharedPreferences(ab.bIX(), 0));
    }

    private static String getCountry() {
        ap.yY();
        return bg.ap((String) c.vr().get(274436, null), null);
    }

    private static String JL(String str) {
        f aJ = g.aJ(str, false);
        if (aJ != null) {
            return aJ.field_packageName;
        }
        w.w("MicroMsg.SdkOAuthUI", "dealWithCancel getAppInfo null; appid: %s", new Object[]{str});
        return null;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof t) {
            w.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd errType:%d errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            bxM();
            if (i == 0 && i2 == 0) {
                final awm com_tencent_mm_protocal_c_awm = (awm) ((t) kVar).gUA.hsk.hsr;
                if (com_tencent_mm_protocal_c_awm.tTj || com_tencent_mm_protocal_c_awm.tTk) {
                    w.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeEnd direct login");
                    JJ(com_tencent_mm_protocal_c_awm.tpW);
                    return;
                }
                ImageView imageView = (ImageView) findViewById(R.h.bpE);
                TextView textView = (TextView) findViewById(R.h.bpK);
                ListView listView = (ListView) findViewById(R.h.bqz);
                Button button = (Button) findViewById(R.h.ccB);
                com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
                aVar.hJa = R.k.dxP;
                n.GW().a(com_tencent_mm_protocal_c_awm.tTi, imageView, aVar.Hg());
                textView.setText(com_tencent_mm_protocal_c_awm.hiE);
                this.sbC = new a(this, com_tencent_mm_protocal_c_awm.tTh);
                listView.setAdapter(this.sbC);
                button.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ SDKOAuthUI sbE;

                    public final void onClick(View view) {
                        if (com_tencent_mm_protocal_c_awm.tTl) {
                            SDKOAuthUI.a(this.sbE, this.sbE.ivH, this.sbE.sbA.state, SDKOAuthUI.JL(this.sbE.ivH), this.sbE.sbC.bxO());
                        } else {
                            this.sbE.JJ(com_tencent_mm_protocal_c_awm.tpW);
                        }
                    }
                });
                findViewById(R.h.czn).setVisibility(0);
            } else if (wj(i)) {
                JK(str);
            } else {
                JK(getString(R.l.fmV));
            }
        } else if (kVar instanceof u) {
            w.i("MicroMsg.SdkOAuthUI", "onSDKOauthAuthorizeConfirmEnd errType:%d errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (this.sbB != null) {
                this.sbB.KH();
            }
            bxM();
            if (i == 0 && i2 == 0) {
                JJ(((awk) ((u) kVar).gUA.hsk.hsr).tpW);
            } else if (wj(i)) {
                JK(str);
            } else {
                JK(getString(R.l.fmV));
            }
        }
    }
}
