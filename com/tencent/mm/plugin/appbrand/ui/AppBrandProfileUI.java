package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.nv;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.config.p;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.jsapi.op_report.AppBrandOpReportLogic.AppBrandOnOpReportStartEvent;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.widget.WxaBindBizInfoView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMTintStatusBarActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.e;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public final class AppBrandProfileUI extends MMTintStatusBarActivity implements OnClickListener, com.tencent.mm.sdk.e.j.a {
    private String jia;
    private s jic;
    private long jjf = 0;
    private LinearLayout jjg;
    private TableLayout jjh;
    private ImageView jji;
    private TextView jjj;
    private TextView jjk;
    private TextView jjl;
    private View jjm;
    private View jjn;
    private TextView jjo;
    private a jjp;
    private WxaExposedParams jjq;
    private e jjr;

    private final class a extends t implements OnClickListener {
        final /* synthetic */ AppBrandProfileUI jjs;
        WxaBindBizInfoView jjy;

        a(AppBrandProfileUI appBrandProfileUI, View view) {
            this.jjs = appBrandProfileUI;
            super(view);
            this.jjy = (WxaBindBizInfoView) view.findViewById(R.h.csR);
            view.setOnClickListener(this);
        }

        public final void onClick(View view) {
            Collection collection = this.jjy.jrG;
            if (collection == null || collection.isEmpty()) {
                w.i("MicroMsg.AppBrandProfileUI", "deal onBindBizInfo click failed, bindBizInfoList is null or nil.");
            } else if (collection.size() == 1) {
                d.b(this.abf.getContext(), "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", ((WxaEntryInfo) collection.get(0)).username).putExtra("key_start_biz_profile_from_app_brand_profile", true).putExtra("force_get_contact", true));
                this.jjs.br(3, 1);
            } else {
                Intent intent = new Intent(this.jjs.uSU.uTo, WxaBindBizInfoUI.class);
                intent.putParcelableArrayListExtra("wxa_entry_info_list", new ArrayList(collection));
                this.jjs.uSU.uTo.startActivity(intent);
            }
        }
    }

    static /* synthetic */ void a(AppBrandProfileUI appBrandProfileUI) {
        if (appBrandProfileUI.jjr == null || !appBrandProfileUI.jjr.isShowing()) {
            appBrandProfileUI.jjr = new e(appBrandProfileUI, e.wuP, false);
            appBrandProfileUI.jjr.qJf = new c(appBrandProfileUI) {
                final /* synthetic */ AppBrandProfileUI jjs;

                {
                    this.jjs = r1;
                }

                public final void a(l lVar) {
                    lVar.clear();
                    lVar.dX(2, R.l.dDG);
                    lVar.dX(1, R.l.dEb);
                }
            };
            appBrandProfileUI.jjr.qJg = new n.d(appBrandProfileUI) {
                final /* synthetic */ AppBrandProfileUI jjs;

                {
                    this.jjs = r1;
                }

                public final void c(MenuItem menuItem, int i) {
                    switch (menuItem.getItemId()) {
                        case 1:
                            if (this.jjs.jjq == null) {
                                w.e("MicroMsg.AppBrandProfileUI", "wxaExposedParams is null");
                                return;
                            }
                            Intent intent = new Intent();
                            String a = com.tencent.mm.plugin.appbrand.n.a(this.jjs.jjq);
                            w.i("MicroMsg.AppBrandProfileUI", "wxaExposedParams:%s", new Object[]{this.jjs.jjq.toString()});
                            w.v("MicroMsg.AppBrandProfileUI", "KRawUrl " + a);
                            intent.putExtra("rawUrl", a);
                            intent.putExtra("forceHideShare", true);
                            d.b(this.jjs, "webview", ".ui.tools.WebViewUI", intent);
                            this.jjs.br(7, 1);
                            if (this.jjs.jjq.fFr == 3) {
                                AppBrandOnOpReportStartEvent.pz(this.jjs.jic.appId);
                                return;
                            }
                            return;
                        case 2:
                            d.b(this.jjs, "appbrand", ".ui.AppBrandAuthorizeUI", new Intent(this.jjs, AppBrandAuthorizeUI.class).putExtra("key_username", this.jjs.jia));
                            this.jjs.br(10, 1);
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        appBrandProfileUI.jjr.bzh();
    }

    static /* synthetic */ void a(AppBrandProfileUI appBrandProfileUI, s sVar, long j) {
        boolean z = true;
        if (!appBrandProfileUI.isFinishing() && !appBrandProfileUI.uSW && sVar != null) {
            if ((appBrandProfileUI.jic == null || !bg.mz(appBrandProfileUI.jic.iGg).equals(sVar.iGg)) && appBrandProfileUI.jji != null) {
                b.AY().a(appBrandProfileUI.jji, sVar.iGg, com.tencent.mm.modelappbrand.a.a.AX(), new com.tencent.mm.modelappbrand.a.e());
            }
            if ((appBrandProfileUI.jic == null || !bg.mz(appBrandProfileUI.jic.fFa).equals(sVar.fFa)) && appBrandProfileUI.jjj != null) {
                appBrandProfileUI.jjj.setText(sVar.fFa);
                appBrandProfileUI.qP(sVar.fFa);
            }
            if ((appBrandProfileUI.jic == null || !bg.mz(appBrandProfileUI.jic.signature).equals(sVar.signature)) && appBrandProfileUI.jjk != null) {
                if (bg.mA(sVar.signature)) {
                    appBrandProfileUI.jjk.setText("");
                    appBrandProfileUI.jjk.setVisibility(8);
                } else {
                    appBrandProfileUI.jjk.setText(sVar.signature);
                    appBrandProfileUI.jjk.setVisibility(0);
                }
            }
            if ((appBrandProfileUI.jic == null || !bg.mz(sVar.RM()).equals(appBrandProfileUI.jic.RM())) && appBrandProfileUI.jjl != null) {
                appBrandProfileUI.jjl.setText(sVar.RM());
                appBrandProfileUI.jjm.setVisibility(0);
            }
            if (appBrandProfileUI.jjp != null) {
                Collection collection = sVar.iFN;
                if (bg.bV(collection)) {
                    appBrandProfileUI.jjp.abf.setVisibility(8);
                } else {
                    WxaBindBizInfoView wxaBindBizInfoView = appBrandProfileUI.jjp.jjy;
                    wxaBindBizInfoView.jrG.clear();
                    if (!(collection == null || collection.isEmpty())) {
                        wxaBindBizInfoView.jrG.addAll(collection);
                    }
                    wxaBindBizInfoView.cq(true);
                    appBrandProfileUI.jjp.abf.setVisibility(0);
                }
                if (j != appBrandProfileUI.jjf && (2 & j) > 0) {
                    appBrandProfileUI.jjp.abf.setVisibility(8);
                }
            }
            if ((appBrandProfileUI.jic == null || !bg.mz(sVar.hvv).equals(appBrandProfileUI.jic.hvv)) && appBrandProfileUI.jjo != null) {
                appBrandProfileUI.jjo.setText(sVar.hvv);
            }
            if (appBrandProfileUI.jic == null || appBrandProfileUI.jic.iGc != sVar.iGc) {
                if (sVar.iGc == 0) {
                    z = false;
                }
                appBrandProfileUI.cf(z);
            }
            appBrandProfileUI.jic = sVar;
            appBrandProfileUI.jjf = j;
        }
    }

    public static void a(Context context, String str, String str2, WxaExposedParams wxaExposedParams) {
        if (!bg.mA(str)) {
            if (context == null) {
                context = ab.getContext();
            }
            Intent putExtra = new Intent(context, AppBrandProfileUI.class).putExtra("key_username", str).putExtra("key_from_scene", 3).putExtra("key_scene_note", str2).putExtra("key_can_swipe_back", true).putExtra("key_scene_exposed_params", wxaExposedParams);
            if (wxaExposedParams != null) {
                Bundle bundle = new Bundle();
                bundle.putInt("stat_scene", 6);
                bundle.putString("stat_app_id", wxaExposedParams.appId);
                bundle.putString("stat_url", wxaExposedParams.iGe);
                putExtra.putExtra("_stat_obj", bundle);
            }
            if (!(context instanceof Activity)) {
                putExtra.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            }
            context.startActivity(putExtra);
        }
    }

    protected final int getLayoutId() {
        return -1;
    }

    protected final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        if (!bg.mA(this.jia)) {
            p.RG().f(this);
        }
        String stringExtra = getIntent().getStringExtra("key_username");
        this.jia = stringExtra;
        if (bg.mA(stringExtra)) {
            finish();
        } else {
            cg(true);
        }
    }

    public final void onBackPressed() {
        super.onBackPressed();
        br(6, 1);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_username");
        this.jia = stringExtra;
        if (bg.mA(stringExtra)) {
            finish();
            return;
        }
        View childAt;
        View childAt2;
        this.jjq = (WxaExposedParams) getIntent().getParcelableExtra("key_scene_exposed_params");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AppBrandProfileUI jjs;

            {
                this.jjs = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jjs.onBackPressed();
                return true;
            }
        });
        a(0, R.g.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ AppBrandProfileUI jjs;

            {
                this.jjs = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppBrandProfileUI.a(this.jjs);
                return true;
            }
        });
        LayoutInflater from = LayoutInflater.from(this);
        View inflate = from.inflate(R.i.cUj, this.jjg, true);
        View inflate2 = from.inflate(R.i.cUi, this.jjg, true);
        this.jjh = (TableLayout) inflate.findViewById(R.h.ctm);
        TableLayout tableLayout = this.jjh;
        if (tableLayout != null) {
            int i = getResources().getDisplayMetrics().widthPixels;
            int childCount = tableLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                childAt = tableLayout.getChildAt(i2);
                if (childAt instanceof TableRow) {
                    TableRow tableRow = (TableRow) childAt;
                    if (tableRow.getChildCount() > 1) {
                        childAt2 = tableRow.getChildAt(0);
                        if (childAt2 != null && (childAt2 instanceof TextView)) {
                            ((TextView) childAt2).setMaxWidth((i / 2) - tableRow.getPaddingLeft());
                        }
                    }
                }
            }
        }
        this.jji = (ImageView) inflate.findViewById(R.h.csX);
        this.jjj = (TextView) inflate.findViewById(R.h.csZ);
        this.jjk = (TextView) inflate.findViewById(R.h.csT);
        this.jjl = (TextView) inflate.findViewById(R.h.ctj);
        this.jjm = inflate.findViewById(R.h.cti);
        this.jjp = new a(this, inflate.findViewById(R.h.csS));
        this.jjn = inflate.findViewById(R.h.csV);
        this.jjo = (TextView) this.jjn.findViewById(R.h.csW);
        cf(true);
        inflate.setClickable(false);
        inflate.setLongClickable(false);
        inflate2.setClickable(false);
        inflate2.setLongClickable(false);
        childAt = inflate2.findViewById(R.h.csU);
        childAt2 = inflate2.findViewById(R.h.ctk);
        childAt.setOnClickListener(this);
        childAt2.setOnClickListener(this);
        cg(true);
    }

    protected final void bE(View view) {
        super.bE(view);
        View scrollView = new ScrollView(this);
        scrollView.setBackgroundResource(R.e.aSR);
        this.jjg = new LinearLayout(this);
        this.jjg.setOrientation(1);
        scrollView.addView(this.jjg, new LayoutParams(-1, -2));
        ((FrameLayout) view).addView(scrollView);
    }

    protected final void onResume() {
        super.onResume();
        if (this.uUD != null) {
            this.uUD.mEnable = getIntent().getBooleanExtra("key_can_swipe_back", true);
        }
    }

    private void cf(boolean z) {
        if (this.jjn != null) {
            if (z) {
                this.jjn.setVisibility(8);
                return;
            }
            this.jjn.setVisibility(0);
            this.jjn.setOnClickListener(this);
        }
    }

    private void br(int i, int i2) {
        b(i, i2, bg.Ny());
    }

    private void b(int i, int i2, long j) {
        if (!bg.mA(this.jic == null ? null : this.jic.appId)) {
            int intExtra = getIntent().getIntExtra("key_from_scene", 3);
            String mz = bg.mz(getIntent().getStringExtra("key_scene_note"));
            w.d("MicroMsg.AppBrandProfileUI", "stev report(%s), appId %s, scene %s, sceneNote %s, eventId %s, result %s", new Object[]{Integer.valueOf(13919), r0, Integer.valueOf(intExtra), mz, Integer.valueOf(i), Integer.valueOf(i2)});
            g.oUh.i(13919, new Object[]{r0, Integer.valueOf(intExtra), mz, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j)});
        }
    }

    protected final void onDestroy() {
        super.onDestroy();
        p.RG().f(this);
    }

    public final void onClick(final View view) {
        if (view.getId() == R.h.csV) {
            if (this.jic != null && !bg.mA(this.jic.appId)) {
                d.b(this.uSU.uTo, "webview", ".ui.tools.WebViewUI", new Intent().putExtra("rawUrl", com.tencent.mm.plugin.appbrand.n.nw(this.jic.appId)).putExtra("forceHideShare", true));
                br(2, 1);
            }
        } else if (view.getId() == R.h.csU) {
            if (this.jic != null) {
                Bundle bundleExtra = getIntent().getBundleExtra("_stat_obj");
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                appBrandStatObject.fWL = com.tencent.mm.plugin.appbrand.report.b.e(appBrandStatObject.scene, bundleExtra);
                appBrandStatObject.fWM = com.tencent.mm.plugin.appbrand.report.b.f(appBrandStatObject.scene, bundleExtra);
                AppBrandLaunchProxyUI.a((Context) this, this.jic.username, null, 0, -1, appBrandStatObject, null);
                br(4, 1);
            }
        } else if (view.getId() == R.h.ctk) {
            final s oj = p.oj(this.jia);
            if (oj == null) {
                w.w("MicroMsg.AppBrandProfileUI", "attrs is null.");
                return;
            }
            Serializable hashMap = new HashMap();
            hashMap.put("desc", "");
            hashMap.put(Columns.TYPE, Integer.valueOf(1));
            hashMap.put("title", oj.fFa);
            hashMap.put("img_url", oj.iGg);
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("mutil_select_is_ret", true);
            intent.putExtra("select_is_ret", true);
            intent.putExtra("scene_from", 3);
            intent.putExtra("appbrand_params", hashMap);
            intent.putExtra("Retr_Msg_Type", 2);
            d.a((MMActivity) view.getContext(), ".ui.transmit.SelectConversationUI", intent, 1, new com.tencent.mm.ui.MMActivity.a(this) {
                final /* synthetic */ AppBrandProfileUI jjs;

                public final void a(int i, int i2, Intent intent) {
                    if (i != 1) {
                        this.jjs.br(8, 2);
                    } else if (i2 == -1) {
                        String str;
                        if (intent == null) {
                            str = null;
                        } else {
                            str = intent.getStringExtra("Select_Conv_User");
                        }
                        if (str == null || str.length() == 0) {
                            w.i("MicroMsg.AppBrandProfileUI", "mmOnActivityResult fail, toUser is null");
                            return;
                        }
                        String str2;
                        w.i("MicroMsg.AppBrandProfileUI", "result success toUser : %s ", new Object[]{str});
                        if (intent == null) {
                            str2 = null;
                        } else {
                            str2 = intent.getStringExtra("custom_send_text");
                        }
                        String str3 = oj.appId;
                        q.yC().n(q.fQ("wxapp_" + str3), true).l("prePublishId", "wxapp_" + str3);
                        com.tencent.mm.t.f.a aVar = new com.tencent.mm.t.f.a();
                        aVar.title = oj.fFa;
                        aVar.type = 33;
                        aVar.hjM = this.jjs.jia;
                        aVar.hjN = str3;
                        aVar.hjO = 1;
                        aVar.fUX = "wxapp_" + str3;
                        aVar.thumburl = oj.iGg;
                        aVar.url = com.tencent.mm.plugin.appbrand.n.nx(str3);
                        aVar.fUR = this.jjs.jia;
                        aVar.fUS = oj.fFa;
                        for (String str4 : bg.f(str.split(","))) {
                            int i3;
                            com.tencent.mm.pluginsdk.model.app.l.a(aVar, str3, oj.fFa, str4, null, null);
                            if (!bg.mA(str2)) {
                                com.tencent.mm.sdk.b.b nvVar = new nv();
                                nvVar.fVa.fVb = str4;
                                nvVar.fVa.content = str2;
                                nvVar.fVa.type = o.fG(str4);
                                nvVar.fVa.flags = 0;
                                com.tencent.mm.sdk.b.a.urY.m(nvVar);
                            }
                            if (str4.endsWith("@chatroom")) {
                                i3 = 9;
                            } else {
                                i3 = 8;
                            }
                            this.jjs.b(i3, 1, bg.Ny());
                        }
                        com.tencent.mm.ui.base.g.bl(view.getContext(), view.getContext().getResources().getString(R.l.dIG));
                    }
                }
            });
        }
    }

    private void cg(final boolean z) {
        com.tencent.mm.sdk.f.e.post(new Runnable(this) {
            final /* synthetic */ AppBrandProfileUI jjs;

            public final void run() {
                final s oj = p.oj(this.jjs.jia);
                final long oi = p.oi(this.jjs.jia);
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass6 jjx;

                    public final void run() {
                        AppBrandProfileUI.a(this.jjx.jjs, oj, oi);
                        if (z && !this.jjx.jjs.isFinishing() && !this.jjx.jjs.uSW) {
                            p.RG().a(this.jjx.jjs, com.tencent.mm.plugin.appbrand.m.d.vL().nJF.getLooper());
                        }
                    }
                });
                if (z) {
                    com.tencent.mm.plugin.appbrand.config.q.ov(this.jjs.jia);
                    this.jjs.br(1, 1);
                }
            }
        }, "AppBrandProfile");
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        if (lVar.uxq == 3 && (lVar.obj instanceof String) && !bg.mA(this.jia) && this.jia.equals((String) lVar.obj)) {
            cg(false);
        }
    }
}
