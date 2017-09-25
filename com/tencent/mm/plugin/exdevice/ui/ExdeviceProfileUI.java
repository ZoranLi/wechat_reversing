package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.a.kr;
import com.tencent.mm.e.a.pq;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.a.h;
import com.tencent.mm.plugin.exdevice.f.a.i;
import com.tencent.mm.plugin.exdevice.f.b.a.a;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.e;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.c.bdq;
import com.tencent.mm.protocal.c.brc;
import com.tencent.mm.protocal.c.id;
import com.tencent.mm.protocal.c.sk;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.y.k;
import com.tencent.wcdb.FileUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import junit.framework.Assert;

public class ExdeviceProfileUI extends MMActivity implements e, c {
    private static int lmp = 0;
    private boolean GD = false;
    private TextPaint gm = new TextPaint(1);
    private int hbc = 0;
    private String iQO;
    private String jia;
    private boolean lfH;
    private List<String> lfX;
    private List<String> lfY;
    private String lfu;
    private p ljN = null;
    private boolean llA;
    private int llB;
    private List<id> llE;
    private String llT;
    private a llU;
    private ArrayList<String> llV;
    private brc llW;
    private ExdeviceProfileAffectedUserView llX;
    private ImageView llY;
    private ListView llZ;
    private boolean llz;
    private ExdeviceProfileListHeader lma;
    private a lmb;
    private View lmc;
    private volatile boolean lmd;
    private String lme;
    private String lmf;
    private String lmg;
    private List<bdq> lmh;
    private ArrayList<c> lmi;
    private List<sk> lmj;
    private int lmk;
    private b<i> lml = new b<i>(this) {
        final /* synthetic */ ExdeviceProfileUI lmv;

        {
            this.lmv = r1;
        }

        public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
            final i iVar = (i) kVar;
            if (this.lmv.isFinishing() || this.lmv.GD) {
                this.lmv.aql();
                w.i("MicroMsg.Sport.ExdeviceProfileUI", "ExdeviceProfileUI has been destroyed.");
                return;
            }
            this.lmv.lmd = true;
            if (i == 0 && i2 == 0 && iVar != null) {
                this.lmv.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 lmx;

                    public final void run() {
                        if (this.lmx.lmv.ljN != null) {
                            this.lmx.lmv.ljN.dismiss();
                        }
                        this.lmx.lmv.llV = iVar.lfC;
                        this.lmx.lmv.llX.y(this.lmx.lmv.llV);
                    }
                });
                this.lmv.llW = iVar.lfB;
                this.lmv.lmf = iVar.lfx;
                this.lmv.lmg = iVar.lfy;
                this.lmv.lmh = iVar.lfz;
                this.lmv.llA = iVar.lfF;
                this.lmv.llE = iVar.lfE;
                this.lmv.lmj = iVar.lfD;
                this.lmv.lmk = iVar.lfG;
                this.lmv.lfH = iVar.lfH;
                this.lmv.lfu = iVar.lfu;
                this.lmv.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 lmx;

                    {
                        this.lmx = r1;
                    }

                    public final void run() {
                        ExdeviceProfileUI.g(this.lmx.lmv);
                    }
                });
                if (!this.lmv.llz) {
                    this.lmv.aqm();
                }
                this.lmv.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 lmx;

                    {
                        this.lmx = r1;
                    }

                    public final void run() {
                        ExdeviceStepChartView exdeviceStepChartView = (ExdeviceStepChartView) this.lmx.lmv.findViewById(R.h.bNd);
                        if (bg.bV(this.lmx.lmv.lmh)) {
                            if (exdeviceStepChartView != null) {
                                exdeviceStepChartView.aqC();
                            }
                        } else if (exdeviceStepChartView != null) {
                            List j = this.lmx.lmv.lmh;
                            w.i("MicroMsg.exdevice.ExdeviceStepChartView", "aqr:refreshStep,steps.size():" + j.size());
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(exdeviceStepChartView.getResources().getString(R.l.egw));
                            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("d");
                            ArrayList arrayList = new ArrayList();
                            exdeviceStepChartView.lpz.clear();
                            if (j != null) {
                                int size = j.size();
                                if (size <= 7 && size > 0) {
                                    int i;
                                    Date date = new Date();
                                    Calendar instance = Calendar.getInstance();
                                    date.setTime(((long) ((bdq) j.get(0)).kBd) * 1000);
                                    instance.setTime(date);
                                    for (i = 0; i <= 6; i++) {
                                        if (i < size) {
                                            bdq com_tencent_mm_protocal_c_bdq = (bdq) j.get(i);
                                            date.setTime(((long) com_tencent_mm_protocal_c_bdq.kBd) * 1000);
                                            exdeviceStepChartView.lpz.add(simpleDateFormat2.format(date));
                                            arrayList.add(Integer.valueOf(com_tencent_mm_protocal_c_bdq.kzY));
                                        } else {
                                            instance.add(5, -1);
                                            exdeviceStepChartView.lpz.add(0, simpleDateFormat2.format(instance.getTime()));
                                            arrayList.add(0, Integer.valueOf(0));
                                        }
                                    }
                                    for (i = 0; i <= 6; i++) {
                                        exdeviceStepChartView.lps[i] = ((Integer) arrayList.get(i)).intValue();
                                    }
                                    exdeviceStepChartView.lpz.set(0, simpleDateFormat.format(instance.getTime()));
                                }
                                exdeviceStepChartView.invalidate();
                            }
                            this.lmx.lmv.lmb.notifyDataSetChanged();
                        }
                    }
                });
                this.lmv.aqk();
                this.lmv.aql();
            }
        }
    };
    private d lmm = new d(this) {
        final /* synthetic */ ExdeviceProfileUI lmv;

        {
            this.lmv = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 0:
                    com.tencent.mm.plugin.sport.b.d.mN(26);
                    ExdeviceProfileUI.r(this.lmv);
                    return;
                case 1:
                    com.tencent.mm.plugin.sport.b.d.mN(27);
                    ExdeviceProfileUI.q(this.lmv);
                    return;
                case 2:
                    ExdeviceProfileUI.s(this.lmv);
                    return;
                case 3:
                    g.a(this.lmv.uSU.uTo, this.lmv.getString(R.l.egJ), null, true, new OnClickListener(this) {
                        final /* synthetic */ AnonymousClass26 lmD;

                        {
                            this.lmD = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ap.yY();
                            x Rc = com.tencent.mm.u.c.wR().Rc(this.lmD.lmv.jia);
                            com.tencent.mm.plugin.sport.b.d.mN(37);
                            o.f(Rc);
                            this.lmD.lmv.lmu.bIy();
                            if (this.lmD.lmv.ljN != null) {
                                this.lmD.lmv.ljN.show();
                            }
                        }
                    }, null);
                    return;
                case 4:
                    this.lmv.lfH = true;
                    com.tencent.mm.plugin.sport.b.d.mN(10);
                    ad.apB();
                    com.tencent.mm.plugin.exdevice.f.b.c.b("", this.lmv.iQO, this.lmv.jia, 3);
                    return;
                case 5:
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", this.lmv.lfu);
                    com.tencent.mm.bb.d.b(this.lmv, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                default:
                    return;
            }
        }
    };
    private b<h> lmn = new b<h>(this) {
        final /* synthetic */ ExdeviceProfileUI lmv;

        {
            this.lmv = r1;
        }

        public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
            w.i("MicroMsg.Sport.ExdeviceProfileUI", "on NetSceneDelFollow end,errType:" + i + "  errCode:" + i2 + "  errMsg:" + str);
            if (i == 0 && i2 == 0) {
                this.lmv.finish();
            }
        }
    };
    private b<com.tencent.mm.plugin.exdevice.f.a.g> lmo = new b<com.tencent.mm.plugin.exdevice.f.a.g>(this) {
        final /* synthetic */ ExdeviceProfileUI lmv;

        {
            this.lmv = r1;
        }

        public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
            w.i("MicroMsg.Sport.ExdeviceProfileUI", "on NetSceneAddFollow end,errType:" + i + "  errCode:" + i2 + "  errMsg:" + str);
            if (i == 0 && i2 == 0) {
                this.lmv.finish();
            }
        }
    };
    private Runnable lmq = new Runnable(this) {
        final /* synthetic */ ExdeviceProfileUI lmv;

        {
            this.lmv = r1;
        }

        public final void run() {
            BackwardSupportUtil.c.a(this.lmv.llZ);
            if (this.lmv.llZ.getCount() > 0) {
                BackwardSupportUtil.c.b(this.lmv.llZ, this.lmv.llZ.getCount() - 1);
            }
        }
    };
    private b<com.tencent.mm.plugin.exdevice.f.a.g> lmr = new b<com.tencent.mm.plugin.exdevice.f.a.g>(this) {
        final /* synthetic */ ExdeviceProfileUI lmv;

        {
            this.lmv = r1;
        }

        public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
            if (i == 0 && i2 == 0) {
                this.lmv.aqk();
                this.lmv.aql();
                this.lmv.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass15 lmz;

                    {
                        this.lmz = r1;
                    }

                    public final void run() {
                        if (this.lmz.lmv.ljN != null) {
                            this.lmz.lmv.ljN.dismiss();
                        }
                    }
                });
            }
        }
    };
    private List<String> lms;
    private b<com.tencent.mm.plugin.exdevice.f.a.k> lmt = new b<com.tencent.mm.plugin.exdevice.f.a.k>(this) {
        final /* synthetic */ ExdeviceProfileUI lmv;

        {
            this.lmv = r1;
        }

        public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
            com.tencent.mm.plugin.exdevice.f.a.k kVar2 = (com.tencent.mm.plugin.exdevice.f.a.k) kVar;
            if (i == 0 && i2 == 0) {
                this.lmv.lms = kVar2.lfZ;
                this.lmv.lfX = kVar2.lfX;
                this.lmv.lfY = kVar2.lfY;
                this.lmv.runOnUiThread(new Runnable(this) {
                    final /* synthetic */ AnonymousClass17 lmA;

                    {
                        this.lmA = r1;
                    }

                    public final void run() {
                        if (this.lmA.lmv.ljN != null) {
                            this.lmA.lmv.ljN.dismiss();
                        }
                    }
                });
                ExdeviceProfileUI.D(this.lmv);
            }
        }
    };
    private com.tencent.mm.sdk.b.c<kr> lmu = new com.tencent.mm.sdk.b.c<kr>(this) {
        final /* synthetic */ ExdeviceProfileUI lmv;

        {
            this.lmv = r2;
            this.usg = kr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            kr krVar = (kr) bVar;
            w.i("MicroMsg.Sport.ExdeviceProfileUI", "count: %d ret: %s title: %s content: %s", new Object[]{Integer.valueOf(krVar.fRk.count), Integer.valueOf(krVar.fRk.ret), krVar.fRk.fRl, krVar.fRk.fRm});
            if (this.lmv.ljN != null && this.lmv.ljN.isShowing()) {
                this.lmv.ljN.dismiss();
            }
            this.lmv.lmu.dead();
            Intent intent = new Intent();
            intent.putExtra("KeyNeedUpdateRank", true);
            this.lmv.setResult(-1, intent);
            this.lmv.finish();
            return false;
        }
    };
    private Context mContext;

    static /* synthetic */ void A(ExdeviceProfileUI exdeviceProfileUI) {
        com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(exdeviceProfileUI.uSU.uTo, com.tencent.mm.ui.widget.e.wuP, false);
        eVar.qJf = new n.c(exdeviceProfileUI) {
            final /* synthetic */ ExdeviceProfileUI lmv;

            {
                this.lmv = r1;
            }

            public final void a(l lVar) {
                if (this.lmv.lfH) {
                    lVar.e(1, this.lmv.getString(R.l.egp));
                } else {
                    lVar.e(4, this.lmv.getString(R.l.egt));
                }
            }
        };
        eVar.qJg = exdeviceProfileUI.lmm;
        eVar.bzh();
    }

    static /* synthetic */ void D(ExdeviceProfileUI exdeviceProfileUI) {
        Intent intent = new Intent();
        String c = bg.c(exdeviceProfileUI.lms, ",");
        intent.putExtra("wechat_sport_contact", bg.c(exdeviceProfileUI.lfX, ","));
        intent.putExtra("wechat_sport_recent_like", c);
        c = bg.c(exdeviceProfileUI.lfY, ",");
        intent.putExtra("titile", exdeviceProfileUI.getString(R.l.efk));
        intent.putExtra("list_type", 12);
        intent.putExtra("max_limit_num", 10);
        intent.putExtra("too_many_member_tip_string", exdeviceProfileUI.getString(R.l.efl, new Object[]{Integer.valueOf(10)}));
        intent.putExtra("list_attr", s.q(new int[]{2, 4, 1, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, FileUtils.S_IWUSR, 64, 16384}));
        intent.putExtra("always_select_contact", c);
        com.tencent.mm.bb.d.a(exdeviceProfileUI, ".ui.contact.SelectContactUI", intent, 3);
    }

    static /* synthetic */ void d(ExdeviceProfileUI exdeviceProfileUI, String str) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("image_path", str);
        com.tencent.mm.bb.d.a(exdeviceProfileUI, ".ui.transmit.SelectConversationUI", intent, 1);
    }

    static /* synthetic */ void g(ExdeviceProfileUI exdeviceProfileUI) {
        exdeviceProfileUI.uSU.bQf();
        if (m.xL().equals(exdeviceProfileUI.jia)) {
            exdeviceProfileUI.a(0, R.g.bhb, new OnMenuItemClickListener(exdeviceProfileUI) {
                final /* synthetic */ ExdeviceProfileUI lmv;

                {
                    this.lmv = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this.lmv.uSU.uTo, com.tencent.mm.ui.widget.e.wuP, false);
                    eVar.qJf = new n.c(this) {
                        final /* synthetic */ AnonymousClass12 lmy;

                        {
                            this.lmy = r1;
                        }

                        public final void a(l lVar) {
                            lVar.a(0, this.lmy.lmv.getString(R.l.egj), R.k.duZ);
                            lVar.a(1, this.lmy.lmv.getString(R.l.egl), R.k.duP);
                        }
                    };
                    eVar.qJg = this.lmv.lmm;
                    eVar.bzh();
                    return true;
                }
            });
            return;
        }
        ap.yY();
        boolean QY = com.tencent.mm.u.c.wR().QY(exdeviceProfileUI.jia);
        ap.yY();
        boolean tB = com.tencent.mm.u.c.wR().Rc(exdeviceProfileUI.jia).tB();
        if (exdeviceProfileUI.llA && QY) {
            exdeviceProfileUI.a(0, R.g.bhb, new OnMenuItemClickListener(exdeviceProfileUI) {
                final /* synthetic */ ExdeviceProfileUI lmv;

                {
                    this.lmv = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this.lmv.uSU.uTo, com.tencent.mm.ui.widget.e.wuP, false);
                    eVar.qJf = new n.c(this) {
                        final /* synthetic */ AnonymousClass22 lmB;

                        {
                            this.lmB = r1;
                        }

                        public final void a(l lVar) {
                            lVar.e(2, this.lmB.lmv.getString(R.l.egr));
                        }
                    };
                    eVar.qJg = this.lmv.lmm;
                    eVar.bzh();
                    return true;
                }
            });
        } else if (!tB) {
            exdeviceProfileUI.a(0, R.g.bhb, new OnMenuItemClickListener(exdeviceProfileUI) {
                final /* synthetic */ ExdeviceProfileUI lmv;

                {
                    this.lmv = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this.lmv.uSU.uTo, com.tencent.mm.ui.widget.e.wuP, false);
                    eVar.qJf = new n.c(this) {
                        final /* synthetic */ AnonymousClass23 lmC;

                        {
                            this.lmC = r1;
                        }

                        public final void a(l lVar) {
                            if (!bg.mA(this.lmC.lmv.lfu)) {
                                lVar.e(5, this.lmC.lmv.getString(R.l.egq));
                            }
                            lVar.e(3, this.lmC.lmv.getString(R.l.egn));
                        }
                    };
                    eVar.qJg = this.lmv.lmm;
                    eVar.bzh();
                    return true;
                }
            });
        }
    }

    static /* synthetic */ void q(ExdeviceProfileUI exdeviceProfileUI) {
        ac acVar = new ac();
        String valueOf = String.valueOf(exdeviceProfileUI.lmk);
        String str = "0";
        if (exdeviceProfileUI.llW != null) {
            str = String.valueOf(exdeviceProfileUI.llW.score);
        }
        acVar.a(exdeviceProfileUI, valueOf, str, exdeviceProfileUI.lme, new ac.a(exdeviceProfileUI) {
            final /* synthetic */ ExdeviceProfileUI lmv;

            {
                this.lmv = r1;
            }

            public final void uX(String str) {
                Intent intent = new Intent();
                intent.putExtra("Ksnsupload_appid", "wx7fa037cc7dfabad5");
                intent.putExtra("Ksnsupload_appname", this.lmv.getString(R.l.egL));
                intent.putExtra("Ksnsupload_source", 1);
                intent.putExtra("need_result", true);
                String fQ = q.fQ("wx_sport");
                q.yC().n(fQ, true).l("prePublishId", "wx_sport");
                intent.putExtra("reportSessionId", fQ);
                intent.putExtra("Ksnsupload_type", 0);
                intent.putExtra("sns_kemdia_path", str);
                com.tencent.mm.bb.d.b(this.lmv, "sns", ".ui.En_c4f742e5", intent, 2);
            }
        });
    }

    static /* synthetic */ void r(ExdeviceProfileUI exdeviceProfileUI) {
        String valueOf = String.valueOf(exdeviceProfileUI.lmk);
        String str = "0";
        if (exdeviceProfileUI.llW != null) {
            str = String.valueOf(exdeviceProfileUI.llW.score);
        }
        new ac().a(exdeviceProfileUI, valueOf, str, exdeviceProfileUI.lme, new ac.a(exdeviceProfileUI) {
            final /* synthetic */ ExdeviceProfileUI lmv;

            {
                this.lmv = r1;
            }

            public final void uX(String str) {
                ExdeviceProfileUI.d(this.lmv, str);
            }
        });
    }

    static /* synthetic */ void s(ExdeviceProfileUI exdeviceProfileUI) {
        w.i("MicroMsg.Sport.ExdeviceProfileUI", "ap: start to del: %s", new Object[]{exdeviceProfileUI.jia});
        ap.vd().a(new h(exdeviceProfileUI.jia, exdeviceProfileUI.lmn), 0);
    }

    static /* synthetic */ void z(ExdeviceProfileUI exdeviceProfileUI) {
        if (VERSION.SDK_INT >= 11) {
            View childAt = exdeviceProfileUI.llZ.getChildAt(0);
            int[] iArr = new int[2];
            if (childAt != null && exdeviceProfileUI.llZ.getFirstVisiblePosition() == 0) {
                childAt.getLocationOnScreen(iArr);
                if (lmp == 0) {
                    lmp = iArr[1];
                }
                int i = iArr[1];
                if (i > (-lmp) / 2) {
                    exdeviceProfileUI.llX.setAlpha(i > 0 ? ((float) (i * 2)) / (((float) lmp) * 2.0f) : ((float) i) / ((float) lmp));
                    exdeviceProfileUI.llX.setVisibility(0);
                    return;
                }
                exdeviceProfileUI.llX.setAlpha(0.0f);
                exdeviceProfileUI.llX.setVisibility(8);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        CharSequence string;
        super.onCreate(bundle);
        this.mContext = this.uSU.uTo;
        Intent intent = getIntent();
        aqk();
        this.jia = intent.getStringExtra("username");
        this.llT = intent.getStringExtra("usernickname");
        String xL = m.xL();
        if (xL != null) {
            this.llz = xL.equals(this.jia);
        }
        this.iQO = getIntent().getStringExtra("app_username");
        this.llA = ad.apv().vd(this.jia);
        w.d("MicroMsg.Sport.ExdeviceProfileUI", "is follow %s", new Object[]{Boolean.valueOf(this.llA)});
        Assert.assertTrue(!bg.mA(this.jia));
        this.llU = ad.apx().vf(this.jia);
        this.llV = getIntent().getStringArrayListExtra("key_affected_semi");
        getString(R.l.dIO);
        this.ljN = g.a(this, getString(R.l.cbS), new OnCancelListener(this) {
            final /* synthetic */ ExdeviceProfileUI lmv;

            {
                this.lmv = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                if (this.lmv.ljN != null) {
                    this.lmv.ljN.dismiss();
                    this.lmv.ljN = null;
                }
                this.lmv.finish();
            }
        });
        this.llX = (ExdeviceProfileAffectedUserView) findViewById(R.h.bMC);
        this.llY = (ImageView) findViewById(R.h.bMF);
        this.llZ = (ListView) findViewById(R.h.bNa);
        MMPullDownView mMPullDownView = (MMPullDownView) findViewById(R.h.ctw);
        this.llX.y(this.llV);
        aqo();
        this.lmc = findViewById(R.h.cCE);
        mMPullDownView.kP(false);
        mMPullDownView.kR(false);
        mMPullDownView.kQ(false);
        mMPullDownView.kP(false);
        mMPullDownView.kO(false);
        mMPullDownView.vlI = true;
        mMPullDownView.vlz = new MMPullDownView.c(this) {
            final /* synthetic */ ExdeviceProfileUI lmv;

            {
                this.lmv = r1;
            }

            public final boolean ako() {
                View childAt = this.lmv.llZ.getChildAt(this.lmv.llZ.getChildCount() - 1);
                int count = this.lmv.llZ.getAdapter().getCount();
                if (count <= 0 || childAt == null || childAt.getBottom() > this.lmv.llZ.getHeight() || this.lmv.llZ.getLastVisiblePosition() < count - 1) {
                    return false;
                }
                return true;
            }
        };
        mMPullDownView.vlA = new MMPullDownView.d(this) {
            final /* synthetic */ ExdeviceProfileUI lmv;

            {
                this.lmv = r1;
            }

            public final boolean akn() {
                if (this.lmv.llZ.getFirstVisiblePosition() == 0) {
                    View childAt = this.lmv.llZ.getChildAt(this.lmv.llZ.getFirstVisiblePosition());
                    if (childAt != null && childAt.getTop() >= 0) {
                        return true;
                    }
                }
                return false;
            }
        };
        mMPullDownView.vlo = new MMPullDownView.e(this) {
            final /* synthetic */ ExdeviceProfileUI lmv;

            {
                this.lmv = r1;
            }

            public final boolean akm() {
                return true;
            }
        };
        mMPullDownView.vlT = new MMPullDownView.b(this) {
            final /* synthetic */ ExdeviceProfileUI lmv;

            {
                this.lmv = r1;
            }

            public final void aqr() {
                ExdeviceProfileUI.z(this.lmv);
            }
        };
        ExdeviceProfileListHeader exdeviceProfileListHeader = new ExdeviceProfileListHeader(this);
        int v = com.tencent.mm.plugin.exdevice.j.b.v(this, getResources().getDimensionPixelSize(R.f.aXb));
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int dimensionPixelSize = displayMetrics.widthPixels > displayMetrics.heightPixels ? getResources().getDimensionPixelSize(R.f.aWR) : getResources().getDimensionPixelSize(R.f.aWS);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.aXd);
        int dimensionPixelSize3 = getResources().getDimensionPixelSize(R.f.aXc);
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        dimensionPixelSize2 = ((((defaultDisplay.getHeight() / 2) - v) - dimensionPixelSize) - (dimensionPixelSize2 / 2)) - dimensionPixelSize3;
        if (defaultDisplay.getHeight() <= 0 || dimensionPixelSize2 <= 0) {
            dimensionPixelSize2 = getResources().getDimensionPixelSize(R.f.aXa);
        }
        exdeviceProfileListHeader.setMinimumHeight(dimensionPixelSize2);
        exdeviceProfileListHeader.setMinimumWidth(defaultDisplay.getWidth());
        exdeviceProfileListHeader.setTag(Integer.valueOf(((defaultDisplay.getHeight() / 2) - v) - dimensionPixelSize));
        this.lma = exdeviceProfileListHeader;
        this.llZ.addHeaderView(this.lma, null, false);
        this.lmb = new a(this.uSU.uTo, this.iQO, this.llz, this.jia);
        this.lmb.lly = this;
        this.llZ.setAdapter(this.lmb);
        this.llZ.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ ExdeviceProfileUI lmv;

            {
                this.lmv = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                ExdeviceProfileUI.z(this.lmv);
            }
        });
        this.llX.jia = this.jia;
        this.lmc.setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ ExdeviceProfileUI lmv;

            {
                this.lmv = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.plugin.exdevice.f.a.e.b(this.lmv);
            }
        });
        mMPullDownView.vlI = false;
        this.llY.setLayoutParams(new LayoutParams(com.tencent.mm.bg.a.dO(this), ((Integer) this.lma.getTag()).intValue()));
        aqn();
        ad.apC().a(this);
        ap.vd().a(new i(this.jia, bg.mz(this.iQO), this.lml), 0);
        try {
            this.hbc = getResources().getDimensionPixelSize(R.f.aXh);
            if (this.hbc <= 0) {
                this.hbc = 60;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.Sport.ExdeviceProfileUI", e, "", new Object[0]);
            if (this.hbc <= 0) {
                this.hbc = 60;
            }
        } catch (Throwable th) {
            if (this.hbc <= 0) {
                this.hbc = 60;
            }
        }
        w.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: ellipsizeWidth: %s", new Object[]{Integer.valueOf(this.hbc)});
        if (this.llz) {
            string = getString(R.l.egu);
        } else {
            dimensionPixelSize = R.l.egy;
            Object[] objArr = new Object[1];
            xL = this.jia;
            int i = this.hbc;
            CharSequence eK = com.tencent.mm.u.n.eK(xL);
            string = (!xL.equalsIgnoreCase(eK) || bg.mA(this.llT)) ? com.tencent.mm.pluginsdk.ui.d.h.a(this.uSU.uTo, eK) : com.tencent.mm.pluginsdk.ui.d.h.a(this.uSU.uTo, this.llT);
            w.d("MicroMsg.Sport.ExdeviceProfileUI", " width: %d, ap: username %s, ellipseize username %s", new Object[]{Integer.valueOf(i), string, TextUtils.ellipsize(string, this.gm, (float) i, TruncateAt.END)});
            objArr[0] = eK;
            string = com.tencent.mm.pluginsdk.ui.d.h.a(this, getString(dimensionPixelSize, objArr));
        }
        L(string);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceProfileUI lmv;

            {
                this.lmv = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lmv.finish();
                return false;
            }
        });
        w.i("MicroMsg.Sport.ExdeviceProfileUI", "mUsername:" + this.jia);
        if (m.xL().equals(this.jia)) {
            com.tencent.mm.sdk.b.b pqVar = new pq();
            pqVar.fWA.action = 3;
            com.tencent.mm.sdk.b.a.urY.a(pqVar, Looper.getMainLooper());
        }
    }

    private void aqk() {
        this.lmi = ad.apv().apH();
        if (this.lmi != null) {
            w.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow size:%s, %s", new Object[]{Integer.valueOf(this.lmi.size()), this.lmi.toString()});
        } else {
            w.d("MicroMsg.Sport.ExdeviceProfileUI", "ap: follow is null");
        }
        if (bg.bV(this.lmi)) {
            this.llB = 0;
        } else {
            this.llB = this.lmi.size();
        }
    }

    private void aql() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceProfileUI lmv;

            {
                this.lmv = r1;
            }

            public final void run() {
                a k = this.lmv.lmb;
                Object o = this.lmv.lmi;
                List p = this.lmv.llE;
                k.llA = ad.apv().vd(k.jia);
                k.llD = o;
                if (bg.bV(o)) {
                    k.llB = 0;
                } else {
                    k.llB = o.size();
                }
                k.llE = p;
                if (!bg.bV(p)) {
                    k.llC = p.size();
                }
                w.d("MicroMsg.ExdeviceProfileAdapter", "setData,mIsFollower:%s ,mFollowersNum:%s  ,mButtonNum:%s ,mUsername:%s", new Object[]{Boolean.valueOf(k.llA), Integer.valueOf(k.llB), Integer.valueOf(k.llC), k.jia});
                this.lmv.lmb.notifyDataSetChanged();
            }
        });
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        w.v("MicroMsg.Sport.ExdeviceProfileUI", "ExdeviceProfileUI: onResume");
        aqk();
        aql();
        if (!this.llz) {
            ad.apv().vd(this.jia);
            aqm();
        }
    }

    private void aqm() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceProfileUI lmv;

            {
                this.lmv = r1;
            }

            public final void run() {
                ExdeviceProfileUI.g(this.lmv);
                this.lmv.lmb.notifyDataSetChanged();
            }
        });
    }

    protected void onDestroy() {
        this.lmu.dead();
        this.GD = true;
        super.onDestroy();
        ad.apC().b(this);
    }

    private void aqn() {
        String xL = m.xL();
        if (this.lmc != null) {
            this.lmc.setVisibility(8);
        }
        if (!bg.mA(xL) && xL.equals(this.jia)) {
            if (!(this.llU == null || !bg.mA(this.llU.field_championUrl) || this.lmc == null)) {
                this.lmc.setVisibility(0);
            }
            if (this.lma != null) {
                this.lma.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ ExdeviceProfileUI lmv;

                    {
                        this.lmv = r1;
                    }

                    public final void onClick(View view) {
                        com.tencent.mm.plugin.sport.b.d.mN(18);
                        com.tencent.mm.plugin.exdevice.f.a.e.b(this.lmv);
                    }
                });
            }
        } else if (this.llU != null && !bg.mA(this.llU.field_championUrl) && this.lma != null) {
            this.lma.setOnClickListener(new View.OnClickListener(this) {
                final /* synthetic */ ExdeviceProfileUI lmv;

                {
                    this.lmv = r1;
                }

                public final void onClick(View view) {
                    ExdeviceProfileUI.A(this.lmv);
                }
            });
        }
    }

    private void aqo() {
        if (this.llU == null) {
            this.llY.setImageResource(R.e.aTt);
            this.lme = null;
        } else if (this.lme == this.llU.field_championUrl) {
        } else {
            if (this.lme == null || !this.lme.equals(this.llU.field_championUrl)) {
                com.tencent.mm.plugin.exdevice.f.a.e.a(this, this.llY, this.llU.field_championUrl, R.e.aTt);
                this.lme = this.llU.field_championUrl;
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!com.tencent.mm.plugin.exdevice.f.a.e.a(this, i, i2, intent, this.iQO)) {
            switch (i) {
                case 1:
                    if (i2 == -1) {
                        String str;
                        if (intent == null) {
                            str = null;
                        } else {
                            str = intent.getStringExtra("Select_Conv_User");
                        }
                        String bS = ac.bS(this);
                        if (str == null || str.length() == 0) {
                            w.e("MicroMsg.Sport.ExdeviceProfileUI", "select conversation failed, toUser is null.");
                            return;
                        }
                        ac.b(this, str, bS, intent.getStringExtra("custom_send_text"), this.lmg);
                        g.bl(this.uSU.uTo, getResources().getString(R.l.dIG));
                        return;
                    }
                    return;
                case 2:
                    if (i2 == -1) {
                        Toast.makeText(this, R.l.eWg, 1).show();
                        return;
                    }
                    return;
                case 3:
                    if (i2 == -1) {
                        List f = bg.f(intent.getStringExtra("Select_Contact").split(","));
                        if (f != null) {
                            if (this.ljN != null) {
                                this.ljN.show();
                            }
                            ap.vd().a(new com.tencent.mm.plugin.exdevice.f.a.g(f, this.lmr), 0);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dbL;
    }

    public final void b(String str, com.tencent.mm.plugin.exdevice.f.b.d dVar) {
        if ("HardDeviceChampionInfo".equals(str) && this.jia.equals(dVar.username)) {
            w.d("MicroMsg.Sport.ExdeviceProfileUI", "hy: url may changed. maybe reload background");
            this.llU = ad.apx().vf(this.jia);
            runOnUiThread(new Runnable(this) {
                final /* synthetic */ ExdeviceProfileUI lmv;

                {
                    this.lmv = r1;
                }

                public final void run() {
                    this.lmv.aqn();
                    this.lmv.lmb.notifyDataSetChanged();
                    this.lmv.aqo();
                }
            });
        }
    }

    public final void aqp() {
        runOnUiThread(new Runnable(this) {
            final /* synthetic */ ExdeviceProfileUI lmv;

            {
                this.lmv = r1;
            }

            public final void run() {
                if (this.lmv.ljN != null) {
                    this.lmv.ljN.show();
                }
            }
        });
        ap.vd().a(new com.tencent.mm.plugin.exdevice.f.a.k(this.lmt), 0);
    }

    public final void aqq() {
        com.tencent.mm.plugin.sport.b.d.mN(17);
        List arrayList = new ArrayList();
        arrayList.add(this.jia);
        ap.vd().a(new com.tencent.mm.plugin.exdevice.f.a.g(arrayList, this.lmo), 0);
    }
}
