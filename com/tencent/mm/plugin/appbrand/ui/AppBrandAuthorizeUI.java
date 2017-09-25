package com.tencent.mm.plugin.appbrand.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.m.d;
import com.tencent.mm.protocal.c.alv;
import com.tencent.mm.protocal.c.bpr;
import com.tencent.mm.protocal.c.bps;
import com.tencent.mm.protocal.c.bqc;
import com.tencent.mm.protocal.c.bqd;
import com.tencent.mm.protocal.c.dq;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;
import com.tencent.mm.y.u;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppBrandAuthorizeUI extends MMPreference {
    private String ivH;
    private String jia;
    List<dq> jib = new ArrayList();
    private s jic;
    protected f jid;
    private boolean jie = false;
    private boolean jif = true;
    private boolean jig = false;

    static /* synthetic */ void a(AppBrandAuthorizeUI appBrandAuthorizeUI, String str) {
        a aVar = new a();
        aVar.hsm = new bpr();
        aVar.hsn = new bps();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp_getauthinfo";
        aVar.hsl = 1196;
        aVar.hso = 0;
        aVar.hsp = 0;
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_bpr = new bpr();
        com_tencent_mm_protocal_c_bpr.appId = str;
        aVar.hsm = com_tencent_mm_protocal_c_bpr;
        u.a(aVar.BE(), new u.a(appBrandAuthorizeUI) {
            final /* synthetic */ AppBrandAuthorizeUI jih;

            {
                this.jih = r1;
            }

            public final int a(int i, int i2, String str, b bVar, k kVar) {
                w.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                if (i == 0 && i2 == 0) {
                    bps com_tencent_mm_protocal_c_bps = (bps) bVar.hsk.hsr;
                    if (com_tencent_mm_protocal_c_bps == null) {
                        this.jih.cd(true);
                        w.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq failed, response is null!");
                    } else {
                        int i3 = com_tencent_mm_protocal_c_bps.unT.errCode;
                        String str2 = com_tencent_mm_protocal_c_bps.unT.fPf;
                        if (i3 == 0) {
                            this.jih.jib = com_tencent_mm_protocal_c_bps.unU;
                            AppBrandAuthorizeUI.a(this.jih, this.jih.jib);
                        } else {
                            this.jih.cd(true);
                            w.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppGetAuthInfoReq error %s", new Object[]{str2});
                        }
                    }
                } else {
                    this.jih.cd(true);
                }
                return 0;
            }
        }, true);
    }

    static /* synthetic */ void a(AppBrandAuthorizeUI appBrandAuthorizeUI, String str, List list) {
        LinkedList linkedList = new LinkedList();
        for (dq dqVar : list) {
            alv com_tencent_mm_protocal_c_alv = new alv();
            com_tencent_mm_protocal_c_alv.tQz = dqVar.scope;
            com_tencent_mm_protocal_c_alv.tQA = dqVar.state;
            linkedList.add(com_tencent_mm_protocal_c_alv);
        }
        a aVar = new a();
        aVar.hsm = new bqc();
        aVar.hsn = new bqd();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp_modauth";
        aVar.hsl = 1188;
        aVar.hso = 0;
        aVar.hsp = 0;
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_bqc = new bqc();
        com_tencent_mm_protocal_c_bqc.appId = str;
        com_tencent_mm_protocal_c_bqc.uon = linkedList;
        aVar.hsm = com_tencent_mm_protocal_c_bqc;
        u.a(aVar.BE(), new u.a(appBrandAuthorizeUI) {
            final /* synthetic */ AppBrandAuthorizeUI jih;

            {
                this.jih = r1;
            }

            public final int a(int i, int i2, String str, b bVar, k kVar) {
                w.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                if (i == 0 && i2 == 0) {
                    bqd com_tencent_mm_protocal_c_bqd = (bqd) bVar.hsk.hsr;
                    if (com_tencent_mm_protocal_c_bqd == null) {
                        w.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq failed, response is null!");
                    } else {
                        int i3 = com_tencent_mm_protocal_c_bqd.unT.errCode;
                        String str2 = com_tencent_mm_protocal_c_bqd.unT.fPf;
                        if (i3 == 0) {
                            w.d("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq OK!");
                            try {
                                p.on(this.jih.jia);
                            } catch (Exception e) {
                            }
                        } else {
                            w.e("MicroMsg.AppBrandAuthorizeUI", "WxaAppModAuthReq error %s", new Object[]{str2});
                        }
                    }
                }
                return 0;
            }
        }, true);
    }

    static /* synthetic */ void a(AppBrandAuthorizeUI appBrandAuthorizeUI, final List list) {
        if (list == null || list.size() <= 0) {
            w.e("MicroMsg.AppBrandAuthorizeUI", "authItems is empty");
            appBrandAuthorizeUI.cd(true);
            return;
        }
        appBrandAuthorizeUI.cd(false);
        appBrandAuthorizeUI.runOnUiThread(new Runnable(appBrandAuthorizeUI) {
            final /* synthetic */ AppBrandAuthorizeUI jih;

            public final void run() {
                w.d("MicroMsg.AppBrandAuthorizeUI", "initAuthItem authItems.size = %d", new Object[]{Integer.valueOf(list.size())});
                for (dq dqVar : list) {
                    boolean z;
                    Preference checkBoxPreference = new CheckBoxPreference(this.jih);
                    checkBoxPreference.vrZ = false;
                    checkBoxPreference.setKey(dqVar.scope);
                    checkBoxPreference.setTitle(dqVar.thc);
                    if (dqVar.state == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    checkBoxPreference.vqm = z;
                    this.jih.jid.a(checkBoxPreference);
                }
                this.jih.jid.notifyDataSetChanged();
                w.d("MicroMsg.AppBrandAuthorizeUI", "initAuthItem finish");
            }
        });
    }

    public final int ON() {
        return R.o.fte;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AppBrandAuthorizeUI jih;

            {
                this.jih = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jih.WK();
                this.jih.finish();
                return false;
            }
        });
        zi(R.l.dDG);
        this.jid = this.vrv;
        String stringExtra = getIntent().getStringExtra("key_username");
        this.jia = stringExtra;
        if (bg.mA(stringExtra)) {
            finish();
            return;
        }
        this.jig = getIntent().getBooleanExtra("key_app_authorize_jsapi", false);
        this.jic = p.oj(this.jia);
        if (this.jic == null) {
            w.e("MicroMsg.AppBrandAuthorizeUI", "AppBrandBizInfo is Null");
            return;
        }
        this.ivH = this.jic.appId;
        d.vL().D(new Runnable(this) {
            final /* synthetic */ AppBrandAuthorizeUI jih;

            {
                this.jih = r1;
            }

            public final void run() {
                AppBrandAuthorizeUI.a(this.jih, this.jih.ivH);
            }
        });
    }

    public final boolean a(final f fVar, final Preference preference) {
        w.d("MicroMsg.AppBrandAuthorizeUI", "onPreferenceTreeClcik.(key : %s)", new Object[]{preference.igL});
        if (this.jib == null) {
            w.w("MicroMsg.AppBrandAuthorizeUI", "mAuthItem == null");
        } else {
            String str = preference.igL;
            if (bg.mA(str)) {
                w.e("MicroMsg.AppBrandAuthorizeUI", "key is null");
            } else {
                for (final dq dqVar : this.jib) {
                    if (str.equals(bg.mz(dqVar.scope))) {
                        this.jie = true;
                        if (((CheckBoxPreference) preference).isChecked()) {
                            dqVar.state = 1;
                        } else if (this.jif) {
                            this.jif = false;
                            h.a aVar = new h.a(this);
                            aVar.SX(getString(R.l.dDx));
                            aVar.SZ(getString(R.l.dDw));
                            aVar.a(new OnClickListener(this) {
                                final /* synthetic */ AppBrandAuthorizeUI jih;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    dqVar.state = 2;
                                    w.d("MicroMsg.AppBrandAuthorizeUI", "set authItem.state close");
                                }
                            });
                            aVar.Ta(getString(R.l.dGs));
                            aVar.b(new OnClickListener(this) {
                                final /* synthetic */ AppBrandAuthorizeUI jih;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    w.d("MicroMsg.AppBrandAuthorizeUI", "set authItem.state open");
                                    dqVar.state = 1;
                                    ((CheckBoxPreference) preference).vqm = true;
                                    fVar.notifyDataSetChanged();
                                }
                            });
                            aVar.d(new OnCancelListener(this) {
                                final /* synthetic */ AppBrandAuthorizeUI jih;

                                public final void onCancel(DialogInterface dialogInterface) {
                                    w.d("MicroMsg.AppBrandAuthorizeUI", "on cancel click!");
                                    dqVar.state = 1;
                                    ((CheckBoxPreference) preference).vqm = true;
                                    fVar.notifyDataSetChanged();
                                }
                            });
                            h WJ = aVar.WJ();
                            WJ.setCanceledOnTouchOutside(false);
                            WJ.show();
                        } else {
                            dqVar.state = 2;
                        }
                    }
                }
            }
        }
        return false;
    }

    private void cd(final boolean z) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ AppBrandAuthorizeUI jih;

            public final void run() {
                Preference preference = new Preference(this.jih);
                preference.vrZ = false;
                if (z) {
                    preference.setLayoutResource(R.i.cTT);
                    preference.setTitle(this.jih.getString(R.l.dDy, new Object[]{this.jih.jic.fFa}));
                } else {
                    preference.setLayoutResource(R.i.cTU);
                    preference.setTitle(this.jih.getString(R.l.dDz, new Object[]{this.jih.jic.fFa}));
                }
                this.jih.jid.a(preference);
                this.jih.jid.notifyDataSetChanged();
            }
        });
    }

    protected void onPause() {
        if (this.jie) {
            w.d("MicroMsg.AppBrandAuthorizeUI", "onPause key change!");
            af.v(new Runnable(this) {
                final /* synthetic */ AppBrandAuthorizeUI jih;

                {
                    this.jih = r1;
                }

                public final void run() {
                    if (this.jih.jie) {
                        this.jih.jie = false;
                        AppBrandAuthorizeUI.a(this.jih, this.jih.ivH, this.jih.jib);
                    }
                }
            });
        }
        super.onPause();
    }

    public void onBackPressed() {
        w.d("MicroMsg.AppBrandAuthorizeUI", "onBackPressed !");
        WK();
        super.onBackPressed();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    private void WK() {
        if (this.jig) {
            JSONArray jSONArray = new JSONArray();
            for (dq dqVar : this.jib) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("scope", dqVar.scope);
                    jSONObject.put("state", dqVar.state);
                    jSONObject.put("desc", dqVar.thc);
                    jSONArray.put(jSONObject);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.AppBrandAuthorizeUI", e, "", new Object[0]);
                }
            }
            w.d("MicroMsg.AppBrandAuthorizeUI", "authInfo %s", new Object[]{jSONArray});
            Intent intent = new Intent();
            intent.putExtra("key_app_authorize_state", jSONArray.toString());
            setResult(-1, intent);
        }
    }
}
