package com.tencent.mm.plugin.exdevice.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.nv;
import com.tencent.mm.e.a.pq;
import com.tencent.mm.i.g;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.a.j;
import com.tencent.mm.plugin.exdevice.f.a.j.a;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.e;
import com.tencent.mm.plugin.exdevice.f.b.f;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.k;
import com.tencent.wcdb.FileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceRankInfoUI extends MMActivity implements a, e, f, d {
    private static int lmp = FileUtils.S_IWUSR;
    private boolean GD;
    private String jia;
    private boolean lfH;
    public boolean lfT;
    public String lfU;
    private p ljN = null;
    private ImageView llY;
    private Map<String, String> lmF = new HashMap();
    private View lmc;
    private String lme;
    private String lmf;
    private String lmg;
    private boolean lnA;
    private String lnB;
    private boolean lnC;
    private j lnD;
    private b<j> lnE = new b<j>(this) {
        final /* synthetic */ ExdeviceRankInfoUI lnF;

        {
            this.lnF = r1;
        }

        public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
            j jVar = (j) kVar;
            w.i("MicroMsg.Sport.ExdeviceRankInfoUI", "onNetSceneEndCallback, errType(%s), errCode(%s), errMsg(%s).", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
            if (this.lnF.isFinishing() || this.lnF.GD) {
                w.i("MicroMsg.Sport.ExdeviceRankInfoUI", "ExdeviceRankInfoUI has been destroyed.");
                return;
            }
            this.lnF.runOnUiThread(new Runnable(this) {
                final /* synthetic */ AnonymousClass12 lnG;

                {
                    this.lnG = r1;
                }

                public final void run() {
                    if (this.lnG.lnF.ljN != null && this.lnG.lnF.ljN.isShowing()) {
                        this.lnG.lnF.ljN.dismiss();
                        this.lnG.lnF.ljN = null;
                        w.d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
                    }
                }
            });
            if (i == 0 && i2 == 0) {
                this.lnF.lmf = jVar.lfx;
                this.lnF.lmg = jVar.lfy;
                this.lnF.lfU = jVar.lfU;
                this.lnF.lfT = jVar.lfT;
                this.lnF.lfH = jVar.lfH;
                this.lnF.dL(false);
                this.lnF.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass12 lnG;

                    {
                        this.lnG = r1;
                    }

                    public final void run() {
                        this.lnG.lnF.aqt();
                        if (!bg.mA(this.lnG.lnF.lmf)) {
                            this.lnG.lnF.a(0, R.g.bhb, new OnMenuItemClickListener(this) {
                                final /* synthetic */ AnonymousClass3 lnH;

                                {
                                    this.lnH = r1;
                                }

                                public final boolean onMenuItemClick(MenuItem menuItem) {
                                    d.mN(11);
                                    ExdeviceRankInfoUI.j(this.lnH.lnG.lnF);
                                    return true;
                                }
                            });
                        }
                        if (this.lnG.lnF.lnn != null) {
                            this.lnG.lnF.lnn.vt(this.lnG.lnF.lnu);
                        }
                    }
                });
            } else if (this.lnF.lnw == null || this.lnF.lnw.size() == 0) {
                this.lnF.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass12 lnG;

                    {
                        this.lnG = r1;
                    }

                    public final void run() {
                        Toast.makeText(this.lnG.lnF, R.l.egh, 1).show();
                        this.lnG.lnF.finish();
                    }
                });
            }
        }
    };
    private ListView lnj;
    private b lnk;
    private View lnl;
    private ExdeviceRankListHeaderView lnm;
    private ExdeviceRankChampionInfoView lnn;
    private View lno;
    private String lnp;
    private String lnq;
    private String lnr;
    private String lns;
    private com.tencent.mm.plugin.exdevice.f.b.a.a lnt;
    private String lnu;
    private int lnv;
    private List<e> lnw;
    private ArrayList<c> lnx;
    private ArrayList<com.tencent.mm.plugin.exdevice.f.b.a.d> lny;
    private boolean lnz;

    static /* synthetic */ void c(ExdeviceRankInfoUI exdeviceRankInfoUI, String str) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("image_path", str);
        com.tencent.mm.bb.d.a(exdeviceRankInfoUI, ".ui.transmit.SelectConversationUI", intent, 1);
    }

    static /* synthetic */ void j(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(exdeviceRankInfoUI.uSU.uTo, com.tencent.mm.ui.widget.e.wuP, false);
        eVar.qJf = new n.c(exdeviceRankInfoUI) {
            final /* synthetic */ ExdeviceRankInfoUI lnF;

            {
                this.lnF = r1;
            }

            public final void a(l lVar) {
                int i;
                if (w.getLogLevel() == 0) {
                    i = 2;
                } else {
                    i = g.sV().getInt("WeRunLaunchGroupRankWeAppSwitch", 0);
                }
                if (i == 2) {
                    lVar.a(3, this.lnF.getString(R.l.egk), R.k.duZ);
                }
                lVar.a(0, this.lnF.getString(R.l.egj), R.k.duZ);
                lVar.a(1, this.lnF.getString(R.l.egl), R.k.duP);
                lVar.a(2, this.lnF.getString(R.l.egi), R.k.duF);
            }
        };
        eVar.qJg = new n.d(exdeviceRankInfoUI) {
            final /* synthetic */ ExdeviceRankInfoUI lnF;

            {
                this.lnF = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 0:
                        d.mN(15);
                        ExdeviceRankInfoUI.n(this.lnF);
                        return;
                    case 1:
                        d.mN(16);
                        this.lnF.aqz();
                        return;
                    case 2:
                        d.mN(7);
                        ExdeviceRankInfoUI.o(this.lnF);
                        return;
                    case 3:
                        d.mN(36);
                        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                        appBrandStatObject.scene = 1063;
                        ((com.tencent.mm.plugin.appbrand.i.c) h.h(com.tencent.mm.plugin.appbrand.i.c.class)).a(null, "gh_1f9ebf140e39@app", 0, 0, null, appBrandStatObject);
                        return;
                    default:
                        return;
                }
            }
        };
        eVar.bzh();
    }

    static /* synthetic */ void n(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        if (bg.mA(exdeviceRankInfoUI.lfU)) {
            com.tencent.mm.plugin.exdevice.f.b.a.a vf = ad.apx().vf(exdeviceRankInfoUI.jia);
            if (vf != null) {
                exdeviceRankInfoUI.lfU = vf.field_championUrl;
            }
        }
        com.tencent.mm.plugin.exdevice.f.b.a.d d = b.d(exdeviceRankInfoUI.jia, exdeviceRankInfoUI.lny);
        String str = "--";
        String str2 = "0";
        if (d != null) {
            str = String.valueOf(d.field_ranknum);
            str2 = String.valueOf(d.field_score);
        }
        new ac().a(exdeviceRankInfoUI, str, str2, exdeviceRankInfoUI.lfU, new ac.a(exdeviceRankInfoUI) {
            final /* synthetic */ ExdeviceRankInfoUI lnF;

            {
                this.lnF = r1;
            }

            public final void uX(String str) {
                ExdeviceRankInfoUI.c(this.lnF, str);
            }
        });
    }

    static /* synthetic */ void o(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "https://ssl.gongyi.qq.com/yxj_health/index.html");
        com.tencent.mm.bb.d.b(exdeviceRankInfoUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void p(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(exdeviceRankInfoUI.uSU.uTo, com.tencent.mm.ui.widget.e.wuP, false);
        eVar.qJf = new n.c(exdeviceRankInfoUI) {
            final /* synthetic */ ExdeviceRankInfoUI lnF;

            {
                this.lnF = r1;
            }

            public final void a(l lVar) {
                if (this.lnF.lfH) {
                    lVar.e(1, this.lnF.getString(R.l.egp));
                } else {
                    lVar.e(0, this.lnF.getString(R.l.egt));
                }
            }
        };
        eVar.qJg = new n.d(exdeviceRankInfoUI) {
            final /* synthetic */ ExdeviceRankInfoUI lnF;

            {
                this.lnF = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (i) {
                    case 0:
                        this.lnF.lfH = true;
                        d.mN(10);
                        ad.apB();
                        com.tencent.mm.plugin.exdevice.f.b.c.b("", this.lnF.lnr, this.lnF.lnt.field_username, 3);
                        return;
                    default:
                        return;
                }
            }
        };
        eVar.bzh();
    }

    private void dL(boolean z) {
        if (!this.lnA || z) {
            ad.apB();
            this.lny = com.tencent.mm.plugin.exdevice.f.b.c.vb(this.lns);
            this.lnx = ad.apv().apH();
            this.lnw = this.lnk.b(this.lnx, this.lny, this.lfT);
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceRankInfoUI lnF;

                {
                    this.lnF = r1;
                }

                public final void run() {
                    this.lnF.lnk.lmE = this.lnF.lnw;
                    this.lnF.lnk.notifyDataSetChanged();
                    this.lnF.lno.setVisibility(0);
                }
            });
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.GD = false;
        this.jia = m.xL();
        Intent intent = getIntent();
        this.lnp = intent.getStringExtra("key_rank_info");
        this.lnq = intent.getStringExtra("key_rank_semi");
        this.lnr = intent.getStringExtra("app_username");
        this.lns = intent.getStringExtra("rank_id");
        this.lnz = intent.getBooleanExtra("key_is_latest", false);
        this.lnu = intent.getStringExtra("key_champioin_username");
        this.lnv = intent.getIntExtra("device_type", 0);
        this.lnB = intent.getStringExtra("locate_to_username");
        this.lnA = intent.getBooleanExtra("key_only_show_latest_rank", false);
        if (bg.mA(this.lns) || "#".equals(this.lns)) {
            if (!this.lnA) {
                com.tencent.mm.plugin.exdevice.f.b.a.d dVar;
                com.tencent.mm.plugin.exdevice.f.b.b.d apu = ad.apu();
                Cursor a = apu.gUz.a(String.format("select * from %s order by %s desc limit 1", new Object[]{"HardDeviceRankInfo", "rankID"}), null, 2);
                if (a == null) {
                    w.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                    dVar = null;
                } else {
                    if (a.moveToFirst()) {
                        dVar = new com.tencent.mm.plugin.exdevice.f.b.a.d();
                        dVar.b(a);
                    } else {
                        w.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                        dVar = null;
                    }
                    a.close();
                }
                if (dVar != null) {
                    this.lns = dVar.field_rankID;
                    this.lnr = dVar.field_appusername;
                }
            }
            this.lnu = null;
            this.lnz = true;
        }
        ad.apB();
        this.lny = com.tencent.mm.plugin.exdevice.f.b.c.vb(this.lns);
        if (!this.lnA) {
            if (this.lny == null || this.lny.size() <= 0) {
                this.lnx = new ArrayList();
                this.lny = com.tencent.mm.plugin.exdevice.f.a.a.a(this.lns, this.lnr, this.lnp, this.lnq, this.lmF, this.lnx);
                ad.apB();
                com.tencent.mm.plugin.exdevice.f.b.c.b(this.lns, this.lny);
            } else {
                com.tencent.mm.plugin.exdevice.f.a.a.b(this.lnp, this.lnq, this.lmF);
            }
            this.lnx = ad.apv().apH();
        }
        this.lnk = new b(this, this.lnr);
        this.lnk.lmF = this.lmF;
        this.lnw = this.lnk.b(this.lnx, this.lny, this.lfT);
        this.lnk.lmE = this.lnw;
        if (bg.mA(this.lnu)) {
            aqu();
        }
        this.lnt = ad.apx().vf(this.lnu);
        if (this.lnt == null && !bg.mA(this.lnu)) {
            this.lnt = new com.tencent.mm.plugin.exdevice.f.b.a.a();
            this.lnt.field_username = this.lnu;
            this.lnt.field_championMotto = getIntent().getStringExtra("key_champion_info");
            this.lnt.field_championUrl = getIntent().getStringExtra("key_champion_coverimg");
            ad.apB();
            ad.apx().a(this.lnt, true);
        }
        KC();
        if (this.lny != null && this.lny.size() > 0) {
            this.lnn.vt(((com.tencent.mm.plugin.exdevice.f.b.a.d) this.lny.get(0)).field_username);
        }
        ad.apC().a(this);
        ad.apB().lgd = this;
        aqs();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceRankInfoUI lnF;

            {
                this.lnF = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lnF.finish();
                return false;
            }
        });
        zi(R.l.egM);
        ks(true);
        aqt();
        com.tencent.mm.sdk.b.b pqVar = new pq();
        pqVar.fWA.action = 2;
        com.tencent.mm.sdk.b.a.urY.a(pqVar, Looper.getMainLooper());
    }

    private void aqs() {
        w.i("MicroMsg.Sport.ExdeviceRankInfoUI", "updateRankInfoUIFromServer");
        this.lnD = new j(this.lns, this.lnr, this.lnu, this.lnz, this.lnE);
        this.lnD.lfW = this;
        ap.vd().a(this.lnD, 0);
    }

    private void aqt() {
        w.i("MicroMsg.Sport.ExdeviceRankInfoUI", "try2LocateToUser, locate2User(%s), username(%s).", new Object[]{this.lnB, this.jia});
        if (!bg.mA(this.lnB)) {
            int i;
            String str = this.lnB;
            w.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser, locate2User(%s), username(%s).", new Object[]{str, this.jia});
            if (bg.mA(str)) {
                i = -1;
            } else if (this.lnw == null || this.lnw.size() == 0) {
                i = -2;
            } else {
                i = 0;
                while (i < this.lnw.size()) {
                    com.tencent.mm.plugin.exdevice.f.b.a.d dVar = ((e) this.lnw.get(i)).lpF;
                    int i2 = ((e) this.lnw.get(i)).lpG;
                    if (dVar != null && str.equalsIgnoreCase(dVar.field_username) && !str.equalsIgnoreCase(this.jia) && (i2 & 2) != 2) {
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                        w.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser pos(%d).(h : %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(displayMetrics.heightPixels)});
                        this.lnj.setSelectionFromTop(i, i2 / 4);
                        this.lnk.lmG = str;
                        this.lnk.notifyDataSetInvalidated();
                        aqw();
                        break;
                    }
                    i++;
                }
                this.lnk.lmG = null;
                i = -3;
            }
            if (i >= 0) {
                return;
            }
        }
        w.d("MicroMsg.Sport.ExdeviceRankInfoUI", "locate to username is null or nil.");
    }

    private void aqn() {
        if (this.lnt == null || this.jia == null || !this.jia.equals(this.lnt.field_username) || !bg.mA(this.lnt.field_championUrl)) {
            if (this.lmc != null) {
                this.lmc.setVisibility(8);
            }
            if (this.lnt != null && !bg.ap(this.lnt.field_username, "").equals(this.jia) && !bg.mA(this.lnt.field_championUrl)) {
                this.lnm.lnJ = new OnClickListener(this) {
                    final /* synthetic */ ExdeviceRankInfoUI lnF;

                    {
                        this.lnF = r1;
                    }

                    public final void onClick(View view) {
                        ExdeviceRankInfoUI.p(this.lnF);
                    }
                };
                return;
            }
            return;
        }
        if (this.lmc != null) {
            this.lmc.setVisibility(0);
        }
        if (this.lnm != null) {
            this.lnm.lnJ = new OnClickListener(this) {
                final /* synthetic */ ExdeviceRankInfoUI lnF;

                {
                    this.lnF = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.plugin.exdevice.f.a.e.b(this.lnF);
                }
            };
        }
    }

    private void aqu() {
        String aqv = aqv();
        if (!bg.mA(aqv)) {
            this.lnu = aqv;
        }
    }

    private String aqv() {
        if (this.lnw != null) {
            for (e eVar : this.lnw) {
                com.tencent.mm.plugin.exdevice.f.b.a.d dVar = eVar.lpF;
                if (dVar != null && dVar.field_ranknum == 1) {
                    return dVar.field_username;
                }
            }
        }
        return null;
    }

    protected final void KC() {
        int dimensionPixelSize;
        int size;
        boolean z;
        this.lnl = findViewById(R.h.coB);
        ExdeviceRankListHeaderView exdeviceRankListHeaderView = new ExdeviceRankListHeaderView(this);
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        if (i == 0) {
            i = com.tencent.mm.plugin.exdevice.j.b.v(this, getResources().getDimensionPixelSize(R.f.aXb));
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.f.aWR);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.f.aWS);
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        i = ((defaultDisplay.getHeight() / 2) - i) - dimensionPixelSize;
        if (defaultDisplay.getHeight() <= 0 || i <= 0) {
            i = getResources().getDimensionPixelSize(R.f.aXa);
        }
        exdeviceRankListHeaderView.setMinimumHeight(i);
        exdeviceRankListHeaderView.setMinimumWidth(defaultDisplay.getWidth());
        exdeviceRankListHeaderView.setTag(Integer.valueOf(i));
        this.lnm = exdeviceRankListHeaderView;
        MMPullDownView mMPullDownView = (MMPullDownView) findViewById(R.h.cty);
        this.lnj = (ListView) findViewById(R.h.bNb);
        this.lnn = (ExdeviceRankChampionInfoView) findViewById(R.h.byW);
        this.lmc = findViewById(R.h.cCE);
        this.lmc.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExdeviceRankInfoUI lnF;

            {
                this.lnF = r1;
            }

            public final void onClick(View view) {
                w.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap: start change cover");
                com.tencent.mm.plugin.exdevice.f.a.e.b(this.lnF);
            }
        });
        this.lnm.lnN = false;
        aqn();
        mMPullDownView.kP(false);
        mMPullDownView.kR(false);
        mMPullDownView.kQ(false);
        mMPullDownView.kP(false);
        mMPullDownView.kO(false);
        mMPullDownView.vlI = true;
        mMPullDownView.vlL = new MMPullDownView.a(this) {
            final /* synthetic */ ExdeviceRankInfoUI lnF;

            {
                this.lnF = r1;
            }

            public final boolean aqA() {
                boolean z;
                ExdeviceRankInfoUI exdeviceRankInfoUI = this.lnF;
                if (this.lnF.lnw == null || this.lnF.lnw.size() == 0) {
                    z = false;
                } else {
                    z = true;
                }
                exdeviceRankInfoUI.lnC = z;
                return false;
            }
        };
        mMPullDownView.vlz = new MMPullDownView.c(this) {
            final /* synthetic */ ExdeviceRankInfoUI lnF;

            {
                this.lnF = r1;
            }

            public final boolean ako() {
                View childAt = this.lnF.lnj.getChildAt(this.lnF.lnj.getChildCount() - 1);
                int count = this.lnF.lnj.getCount();
                if (count <= 0 || childAt == null || childAt.getBottom() > this.lnF.lnj.getHeight() || this.lnF.lnj.getLastVisiblePosition() != count - 1) {
                    return false;
                }
                return true;
            }
        };
        mMPullDownView.vlT = new MMPullDownView.b(this) {
            final /* synthetic */ ExdeviceRankInfoUI lnF;

            {
                this.lnF = r1;
            }

            public final void aqr() {
                this.lnF.aqw();
            }
        };
        mMPullDownView.vlA = new MMPullDownView.d(this) {
            final /* synthetic */ ExdeviceRankInfoUI lnF;

            {
                this.lnF = r1;
            }

            public final boolean akn() {
                int firstVisiblePosition = this.lnF.lnj.getFirstVisiblePosition();
                if (firstVisiblePosition == 0) {
                    View childAt = this.lnF.lnj.getChildAt(firstVisiblePosition);
                    if (childAt != null && childAt.getTop() >= 0) {
                        return true;
                    }
                }
                return false;
            }
        };
        this.lnj.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ ExdeviceRankInfoUI lnF;

            {
                this.lnF = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                this.lnF.aqw();
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                this.lnF.aqw();
            }
        });
        this.lnj.addHeaderView(this.lnm, null, false);
        View inflate = getLayoutInflater().inflate(R.i.dbS, null);
        this.lno = inflate.findViewById(R.h.bYb);
        inflate.findViewById(R.h.bYa).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExdeviceRankInfoUI lnF;

            {
                this.lnF = r1;
            }

            public final void onClick(View view) {
                d.mN(24);
                Intent intent = new Intent();
                intent.putExtra("Select_Talker_Name", "gh_43f2581f6fd6");
                intent.putExtra("Select_block_List", "gh_43f2581f6fd6");
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("mutil_select_is_ret", true);
                intent.putExtra("Select_Send_Card", true);
                com.tencent.mm.bb.d.a(this.lnF, ".ui.transmit.SelectConversationUI", intent, 3);
            }
        });
        this.lno.setVisibility(8);
        this.lnj.addFooterView(inflate);
        if (this.lnx != null) {
            dimensionPixelSize = this.lnx.size();
        } else {
            dimensionPixelSize = 0;
        }
        if (this.lny != null) {
            size = this.lny.size();
        } else {
            size = 0;
        }
        if (dimensionPixelSize + size == 0) {
            this.lnw = new ArrayList();
            this.lnk.lmE = this.lnw;
            getString(R.l.dIO);
            this.ljN = com.tencent.mm.ui.base.g.a(this, getString(R.l.cbS), true, new OnCancelListener(this) {
                final /* synthetic */ ExdeviceRankInfoUI lnF;

                {
                    this.lnF = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.lnF.ljN != null) {
                        this.lnF.ljN.dismiss();
                        this.lnF.ljN = null;
                    }
                    this.lnF.finish();
                }
            });
        }
        this.lnj.setAdapter(this.lnk);
        this.lnk.lmH = this;
        if (this.lnv == 1) {
            this.lnj.setVisibility(0);
            this.lnl.setVisibility(8);
            z = true;
        } else {
            this.lnj.setVisibility(8);
            this.lnl.setVisibility(0);
            z = false;
        }
        if (z) {
            this.llY = (ImageView) findViewById(R.h.bMF);
            mMPullDownView.vlI = false;
            dimensionPixelSize = com.tencent.mm.bg.a.dO(this);
            i = ((Integer) this.lnm.getTag()).intValue();
            if (this.lfT) {
                i += (getResources().getDimensionPixelSize(R.f.aXd) / 2) + getResources().getDimensionPixelSize(R.f.aXc);
            }
            this.llY.setLayoutParams(new LayoutParams(dimensionPixelSize, i));
            aqx();
            dM(false);
            return;
        }
        w.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: cannot handle this device type");
        finish();
    }

    private void aqw() {
        View childAt = this.lnj.getChildAt(0);
        int[] iArr = new int[2];
        if (childAt != null) {
            if (this.lnj.getFirstVisiblePosition() == 0) {
                childAt.getLocationOnScreen(iArr);
                if (bg.mA(this.lnB) && lmp == FileUtils.S_IWUSR) {
                    lmp = iArr[1];
                }
                int i = iArr[1];
                if (i > 0) {
                    float f;
                    if (i >= lmp) {
                        f = 1.0f;
                    } else {
                        f = ((float) i) / ((float) lmp);
                    }
                    w.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap-alpha: %s", new Object[]{Float.valueOf(f)});
                    this.lnn.setAlpha(f);
                    this.lnn.setVisibility(0);
                    this.lmc.setAlpha(f);
                    return;
                }
            }
            this.lnn.setAlpha(0.0f);
            this.lmc.setAlpha(0.0f);
            this.lnn.setVisibility(8);
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onRestart() {
        super.onRestart();
        dL(true);
    }

    protected void onDestroy() {
        this.GD = true;
        super.onDestroy();
        if (this.lnD != null) {
            this.lnD.lfW = null;
        }
        ad.apC().b(this);
        ad.apB().lgd = null;
        ad.apB().lge = null;
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.dbU;
    }

    private void aqx() {
        if (this.lnt == null) {
            this.llY.setImageResource(R.e.aTt);
            this.lme = null;
        } else if (this.lme == this.lnt.field_championUrl) {
        } else {
            if (this.lme == null || !this.lme.equals(this.lnt.field_championUrl)) {
                com.tencent.mm.plugin.exdevice.f.a.e.a(this, this.llY, this.lnt.field_championUrl, R.e.aTt);
                this.lme = this.lnt.field_championUrl;
            }
        }
    }

    private void dM(boolean z) {
        if (z) {
            aqu();
        }
        if (bg.mA(this.lnr)) {
            this.lnn.setVisibility(8);
            return;
        }
        this.lnn.vt(this.lnu);
        this.lnn.setVisibility(0);
    }

    public final void b(String str, com.tencent.mm.plugin.exdevice.f.b.d dVar) {
        boolean z = (dVar == null || bg.mA(str)) ? false : true;
        Assert.assertTrue(z);
        if ("HardDeviceRankInfo".equals(str)) {
            if (this.lns != null && this.lns.equals(dVar.lfJ)) {
                w.i("MicroMsg.Sport.ExdeviceRankInfoUI", "onRankChange, rankId(%s).", new Object[]{this.lns});
                dL(true);
                if (bg.mA(this.lnu) || !this.lnu.equals(aqv())) {
                    aqu();
                    this.lnt = ad.apx().vf(this.lnu);
                    runOnUiThread(new Runnable(this) {
                        final /* synthetic */ ExdeviceRankInfoUI lnF;

                        {
                            this.lnF = r1;
                        }

                        public final void run() {
                            this.lnF.aqn();
                            this.lnF.aqx();
                        }
                    });
                }
                runOnUiThread(new Runnable(this) {
                    final /* synthetic */ ExdeviceRankInfoUI lnF;

                    {
                        this.lnF = r1;
                    }

                    public final void run() {
                        this.lnF.dM(true);
                        if (this.lnF.lnC) {
                            this.lnF.lnk.notifyDataSetChanged();
                        } else {
                            this.lnF.aqt();
                        }
                    }
                });
            }
        } else if ("HardDeviceChampionInfo".equals(str) && !bg.mA(this.lnu) && this.lnu.equals(dVar.username)) {
            this.lnt = ad.apx().vf(this.lnu);
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceRankInfoUI lnF;

                {
                    this.lnF = r1;
                }

                public final void run() {
                    this.lnF.aqn();
                    this.lnF.aqx();
                }
            });
        }
    }

    public final void vc(String str) {
        w.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank changed to %s", new Object[]{str});
        this.lns = str;
    }

    public final void vv(String str) {
        d.mN(6);
        Intent intent = new Intent(this, ExdeviceProfileUI.class);
        intent.putExtra("username", str);
        intent.putExtra("usernickname", (String) this.lmF.get(str));
        intent.putExtra("app_username", this.lnr);
        intent.putExtra("rank_id", this.lns);
        startActivityForResult(intent, 4);
    }

    public final void aqy() {
        d.mN(31);
        aqz();
    }

    public final void aO(String str, int i) {
        ad.apB();
        String str2 = this.lns;
        String str3 = this.lnr;
        com.tencent.mm.plugin.exdevice.f.b.b.d apu = ad.apu();
        boolean z = (bg.mA(str2) || bg.mA(str) || (i != 1 && i != 0 && i != 2)) ? false : true;
        Assert.assertTrue(z);
        com.tencent.mm.plugin.exdevice.f.b.a.d a = apu.a(new com.tencent.mm.plugin.exdevice.f.b.d(str2, null, str));
        if (a == null) {
            w.w("MicroMsg.ExdeviceRankInfoStg", "hy: info is null. abort");
        } else {
            a.field_selfLikeState = i;
            switch (a.field_selfLikeState) {
                case 0:
                    a.field_likecount--;
                    break;
                case 1:
                    a.field_likecount++;
                    break;
                default:
                    w.w("MicroMsg.ExdeviceRankInfoStg", "hy: still loading...abort");
                    break;
            }
            apu.a(a, true);
        }
        com.tencent.mm.plugin.exdevice.f.b.c.b(str2, str3, str, i);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!com.tencent.mm.plugin.exdevice.f.a.e.a(this, i, i2, intent, this.lnr) && i2 == -1) {
            String stringExtra;
            switch (i) {
                case 1:
                    if (intent == null) {
                        w.e("MicroMsg.Sport.ExdeviceRankInfoUI", "onActivityResult, data is null.(reqestCode : %d)", new Object[]{Integer.valueOf(i)});
                        return;
                    }
                    stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                    if (stringExtra == null || stringExtra.length() == 0) {
                        w.e("MicroMsg.Sport.ExdeviceRankInfoUI", "select conversation failed, toUser is null.");
                        return;
                    }
                    ac.b(this, stringExtra, ac.bS(this), intent.getStringExtra("custom_send_text"), this.lmg);
                    com.tencent.mm.ui.base.g.bl(this.uSU.uTo, getResources().getString(R.l.dIG));
                    w.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Select conversation return.");
                    return;
                case 2:
                    com.tencent.mm.ui.base.g.bl(this.uSU.uTo, getResources().getString(R.l.dIG));
                    w.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Share to timeline return.");
                    return;
                case 3:
                    if (intent != null) {
                        List<String> f = bg.f(intent.getStringExtra("received_card_name").split(","));
                        String stringExtra2 = intent.getStringExtra("custom_send_text");
                        for (String stringExtra3 : f) {
                            com.tencent.mm.plugin.messenger.a.d.aJW().k("gh_43f2581f6fd6", stringExtra3, o.dH(stringExtra3));
                            if (!bg.mA(stringExtra2)) {
                                com.tencent.mm.sdk.b.b nvVar = new nv();
                                nvVar.fVa.fVb = stringExtra3;
                                nvVar.fVa.content = stringExtra2;
                                nvVar.fVa.type = o.fG(stringExtra3);
                                nvVar.fVa.flags = 0;
                                com.tencent.mm.sdk.b.a.urY.m(nvVar);
                            }
                        }
                        return;
                    }
                    return;
                case 4:
                    if (intent != null && intent.getBooleanExtra("KeyNeedUpdateRank", false)) {
                        aqs();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean vw(String str) {
        if (bg.mA(this.lns) || "#".equals(this.lns)) {
            w.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank id is not valid.abort the event");
            Toast.makeText(this, getString(R.l.egz), 0).show();
            return true;
        } else if (!m.xL().equals(str)) {
            return false;
        } else {
            w.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: is self. see who likes me");
            Intent intent = new Intent(this, ExdeviceLikeUI.class);
            intent.putExtra("app_username", this.lnr);
            intent.putExtra("rank_id", this.lns);
            intent.putExtra("key_is_like_read_only", true);
            startActivity(intent);
            return true;
        }
    }

    private void aqz() {
        if (bg.mA(this.lfU)) {
            com.tencent.mm.plugin.exdevice.f.b.a.a vf = ad.apx().vf(this.jia);
            if (vf != null) {
                this.lfU = vf.field_championUrl;
            }
        }
        com.tencent.mm.plugin.exdevice.f.b.a.d d = b.d(this.jia, this.lny);
        String str = "--";
        String str2 = "0";
        if (d != null) {
            str = String.valueOf(d.field_ranknum);
            str2 = String.valueOf(d.field_score);
        }
        new ac().a(this, str, str2, this.lfU, new ac.a(this) {
            final /* synthetic */ ExdeviceRankInfoUI lnF;

            {
                this.lnF = r1;
            }

            public final void uX(String str) {
                Intent intent = new Intent();
                intent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
                intent.putExtra("Ksnsupload_appname", this.lnF.getString(R.l.egL));
                intent.putExtra("Ksnsupload_source", 1);
                intent.putExtra("need_result", true);
                String fQ = q.fQ("wx_sport");
                q.yC().n(fQ, true).l("prePublishId", "wx_sport");
                intent.putExtra("reportSessionId", fQ);
                intent.putExtra("Ksnsupload_type", 0);
                intent.putExtra("sns_kemdia_path", str);
                com.tencent.mm.bb.d.b(this.lnF, "sns", ".ui.En_c4f742e5", intent, 2);
            }
        });
    }

    public final void a(j jVar) {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceRankInfoUI lnF;

            {
                this.lnF = r1;
            }

            public final void run() {
                if (this.lnF.ljN != null && this.lnF.ljN.isShowing()) {
                    this.lnF.ljN.dismiss();
                    this.lnF.ljN = null;
                    w.d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
                }
            }
        });
        this.lmf = jVar.lfx;
        this.lmg = jVar.lfy;
        this.lfU = jVar.lfU;
        this.lfT = jVar.lfT;
        this.lfH = jVar.lfH;
        this.lny = jVar.lfM;
        this.lnx = jVar.lfN;
        this.lnw = this.lnk.b(this.lnx, this.lny, this.lfT);
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceRankInfoUI lnF;

            {
                this.lnF = r1;
            }

            public final void run() {
                this.lnF.lnk.lmE = this.lnF.lnw;
                this.lnF.lnk.notifyDataSetChanged();
                this.lnF.lno.setVisibility(0);
            }
        });
    }
}
