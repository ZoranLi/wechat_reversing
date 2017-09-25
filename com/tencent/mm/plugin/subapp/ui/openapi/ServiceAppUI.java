package com.tencent.mm.plugin.subapp.ui.openapi;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.q;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ServiceAppUI extends MMPreference implements e {
    private String fJL;
    private f isJ;
    private ServicePreference qUA;
    private PreferenceTitleCategory qUB;
    private PreferenceTitleCategory qUC;
    private List<com.tencent.mm.pluginsdk.model.app.f> qUD = new ArrayList();
    private List<com.tencent.mm.pluginsdk.model.app.f> qUE = new ArrayList();
    private OnItemClickListener qUF;
    private OnItemClickListener qUG;
    private ServicePreference qUz;

    static /* synthetic */ void a(ServiceAppUI serviceAppUI, com.tencent.mm.pluginsdk.model.app.f fVar) {
        if (fVar == null) {
            w.e("MicroMsg.ServiceAppUI", "app is null");
            return;
        }
        g.oUh.i(10923, new Object[]{Integer.valueOf(13), fVar.field_appId, Integer.valueOf(1)});
        if (fVar.gfx == 2 && !bg.mA(fVar.gfw)) {
            int size;
            Intent intent;
            Bundle bundle;
            String d = v.d(serviceAppUI.getSharedPreferences(ab.bIX(), 0));
            if ("language_default".equalsIgnoreCase(d) && Locale.getDefault() != null) {
                d = Locale.getDefault().toString();
            }
            if (o.dH(serviceAppUI.fJL)) {
                ap.yY();
                q fV = c.xa().fV(serviceAppUI.fJL);
                if (fV != null) {
                    size = fV.DU().size();
                    intent = new Intent();
                    bundle = new Bundle();
                    bundle.putString("jsapi_args_appid", fVar.field_appId);
                    bundle.putBoolean("isFromService", true);
                    bundle.putString("sendAppMsgToUserName", serviceAppUI.fJL);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("forceHideShare", true);
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[]{fVar.gfw, Integer.valueOf(size), d}));
                    d.b(serviceAppUI.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
                    serviceAppUI.finish();
                }
            }
            size = 1;
            intent = new Intent();
            bundle = new Bundle();
            bundle.putString("jsapi_args_appid", fVar.field_appId);
            bundle.putBoolean("isFromService", true);
            bundle.putString("sendAppMsgToUserName", serviceAppUI.fJL);
            intent.putExtra("jsapiargs", bundle);
            intent.putExtra("forceHideShare", true);
            intent.putExtra("show_bottom", false);
            intent.putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[]{fVar.gfw, Integer.valueOf(size), d}));
            d.b(serviceAppUI.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent);
            serviceAppUI.finish();
        } else if (fVar.gfx == 3) {
            Intent intent2 = new Intent();
            intent2.putExtra("service_app_package_name", fVar.field_packageName);
            intent2.putExtra("service_app_openid", fVar.field_openId);
            intent2.putExtra("service_app_appid", fVar.field_appId);
            serviceAppUI.setResult(-1, intent2);
            serviceAppUI.finish();
        } else if (fVar.gfx == 1) {
            b.imv.o(serviceAppUI.uSU.uTo, fVar.gfw);
            serviceAppUI.finish();
        }
    }

    public final int ON() {
        return R.o.fuc;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected void onResume() {
        super.onResume();
        KC();
        if (this.qUz != null) {
            this.qUz.onResume();
        }
        if (this.qUA != null) {
            this.qUA.onResume();
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.qUz != null) {
            this.qUz.onPause();
        }
        if (this.qUA != null) {
            this.qUA.onPause();
        }
    }

    protected final void KC() {
        zi(R.l.eRo);
        this.fJL = getIntent().getStringExtra("service_app_talker_user");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ServiceAppUI qUH;

            {
                this.qUH = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qUH.finish();
                return true;
            }
        });
        this.qUD.clear();
        this.qUE.clear();
        Cursor cG = o.dH(this.fJL) ? an.aRr().cG(0, 2) : o.eV(this.fJL) ? an.aRr().cG(0, 4) : an.aRr().cG(0, 1);
        if (cG != null) {
            if (cG.moveToFirst()) {
                do {
                    com.tencent.mm.pluginsdk.model.app.f fVar = new com.tencent.mm.pluginsdk.model.app.f();
                    fVar.b(cG);
                    if (fVar.field_serviceAppType == 1) {
                        this.qUD.add(fVar);
                    } else if (fVar.field_serviceAppType == 2) {
                        this.qUE.add(fVar);
                    }
                } while (cG.moveToNext());
            }
            cG.close();
        }
        if (this.qUF == null) {
            this.qUF = new OnItemClickListener(this) {
                final /* synthetic */ ServiceAppUI qUH;

                {
                    this.qUH = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (this.qUH.qUz == null) {
                        w.e("MicroMsg.ServiceAppUI", "wx onItemClick wxServicePref null");
                        return;
                    }
                    com.tencent.mm.pluginsdk.model.app.f uw = this.qUH.qUz.uw(i);
                    if (uw == null) {
                        w.e("MicroMsg.ServiceAppUI", "wx onItemClick app is null");
                        return;
                    }
                    w.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[]{Integer.valueOf(uw.gfx), uw.field_packageName, uw.field_appId});
                    ServiceAppUI.a(this.qUH, uw);
                }
            };
        }
        if (this.qUG == null) {
            this.qUG = new OnItemClickListener(this) {
                final /* synthetic */ ServiceAppUI qUH;

                {
                    this.qUH = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (this.qUH.qUA == null) {
                        w.e("MicroMsg.ServiceAppUI", "biz onItemClick bizServicePref null");
                        return;
                    }
                    com.tencent.mm.pluginsdk.model.app.f uw = this.qUH.qUA.uw(i);
                    if (uw == null) {
                        w.e("MicroMsg.ServiceAppUI", "biz onItemClick app is null");
                        return;
                    }
                    w.i("MicroMsg.ServiceAppUI", "onItemClick, jumpType[%d], package[%s], appid[%s]", new Object[]{Integer.valueOf(uw.gfx), uw.field_packageName, uw.field_appId});
                    ServiceAppUI.a(this.qUH, uw);
                }
            };
        }
        this.isJ = this.vrv;
        this.isJ.removeAll();
        if (this.qUD.size() > 0) {
            this.qUz = new ServicePreference(this);
            this.qUz.qUn = this.qUD;
            if (this.qUF != null) {
                this.qUz.qUq = this.qUF;
            }
            if (this.qUB == null) {
                this.qUB = new PreferenceTitleCategory(this);
                this.qUB.setTitle(R.l.foa);
            }
            this.isJ.a(this.qUB);
            this.isJ.a(this.qUz);
        }
        if (this.qUE.size() > 0) {
            this.qUA = new ServicePreference(this);
            this.qUA.qUn = this.qUE;
            if (this.qUG != null) {
                this.qUA.qUq = this.qUG;
            }
            if (this.qUC == null) {
                this.qUC = new PreferenceTitleCategory(this);
                this.qUC.setTitle(R.l.dOS);
            }
            this.isJ.a(this.qUC);
            this.isJ.a(this.qUA);
        }
    }

    public final boolean a(f fVar, Preference preference) {
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        if (i != 0 || i2 != 0) {
            w.e("MicroMsg.ServiceAppUI", "onSceneEnd, errType = " + i + ", errCode = " + i2);
        }
    }
}
