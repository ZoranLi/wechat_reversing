package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.n;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.ViewPager.h;
import android.support.v4.view.u;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mm.b.f;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.model.AdlandingRemoteServiceConnectedReceiver;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdLandingViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.AdlandingDummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.DummyViewPager;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.g;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.snackbar.b.b;
import com.tencent.wcdb.FileUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class SnsAdNativeLandingPagesUI extends MMActivity {
    public static boolean qyd = false;
    int cGa;
    String fVJ;
    private boolean jEa = false;
    private ImageView jXC;
    private int jYq;
    private long jgn = 0;
    private int klK = 0;
    private int klL = 0;
    private int klM = 0;
    private int klN = 0;
    private ImageView lMk;
    String lfx;
    String lfy;
    private d lvq = new d(ab.getContext());
    protected b mnV = new b(this) {
        final /* synthetic */ SnsAdNativeLandingPagesUI qyz;

        {
            this.qyz = r1;
        }

        public final void aAt() {
            try {
                AdLandingPagesProxy.getInstance().favEditTag();
            } catch (Exception e) {
                w.e("MicroMsg.SnsAdNativeLandingPagesUI", "favorite edittag fail, ex = " + e.getMessage());
            }
        }
    };
    String pZI;
    String qdX;
    String qeT;
    int qfV;
    private int qiP = 1000;
    private int qiQ = 700;
    private int qiR = 250;
    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w qlC;
    private View qlS;
    public LinkedList<c> qxS = new LinkedList();
    private ImageView qxT;
    private ImageView qxU;
    Bundle qxV;
    b qxW;
    boolean qxX = false;
    String qxY;
    String qxZ;
    private ImageView qya;
    String qyb;
    String qyc;
    g qye = new g();
    boolean qyf = false;
    int qyg;
    String qyh;
    String qyi;
    String qyj;
    private AdlandingDummyViewPager qyk;
    int qyl;
    private ae qym = new ae();
    private LinkedList<View> qyn;
    private boolean qyo = true;
    private View qyp;
    m qyq;
    private int qyr = Integer.MIN_VALUE;
    private volatile int qys = 2;
    private BroadcastReceiver qyt = new BroadcastReceiver(this) {
        final /* synthetic */ SnsAdNativeLandingPagesUI qyz;

        {
            this.qyz = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("show", 0);
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) ((n) this.qyz.qyk.yr).I(this.qyz.qyk.ys);
            w.d("MicroMsg.SnsAdNativeLandingPagesUI", "recv videoProgressbarStatusChangeReceiver show %d", new Object[]{Integer.valueOf(intExtra)});
            if (bVar.bgT()) {
                bVar.bgS();
            } else {
                bVar.bgR();
            }
        }
    };
    private BroadcastReceiver qyu = new BroadcastReceiver(this) {
        final /* synthetic */ SnsAdNativeLandingPagesUI qyz;

        {
            this.qyz = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            this.qyz.bjI();
        }
    };
    private a qyv = new a(this) {
        final /* synthetic */ SnsAdNativeLandingPagesUI qyz;

        {
            this.qyz = r1;
        }

        public final void a(com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bVar) {
            final RecyclerView bgP = bVar.bgP();
            if (bgP != null) {
                bgP.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                    final /* synthetic */ AnonymousClass8 qyD;

                    public final boolean onPreDraw() {
                        bgP.getViewTreeObserver().removeOnPreDrawListener(this);
                        this.qyD.qyz.qys = this.qyD.qyz.qys - 1;
                        SnsAdNativeLandingPagesUI.d(this.qyD.qyz);
                        return true;
                    }
                });
            }
        }
    };
    private e qyw = new h(this) {
        final /* synthetic */ SnsAdNativeLandingPagesUI qyz;

        {
            this.qyz = r1;
        }

        public final void a(int i, float f, int i2) {
            super.a(i, f, i2);
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b e = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) ((Fragment) this.qyz.qyx.get(Integer.valueOf(((c) this.qyz.qxS.get(this.qyz.qyk.ys)).id))));
            if (e.qlB != null) {
                e.qlB.bgg();
            }
        }

        public final void W(int i) {
            super.W(i);
            ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) ((Fragment) this.qyz.qyx.get(Integer.valueOf(((c) this.qyz.qxS.get(this.qyz.qyk.ys)).id)))).qlG = i;
            Fragment fragment;
            if (i == 1) {
                for (int i2 = 0; i2 < this.qyz.qxS.size(); i2++) {
                    fragment = (Fragment) this.qyz.qyx.get(Integer.valueOf(((c) this.qyz.qxS.get(i2)).id));
                    if (fragment != null) {
                        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment).bgR();
                    }
                }
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab.cQ(this.qyz.uSU.uTo);
            } else if (i == 0) {
                fragment = (Fragment) this.qyz.qyx.get(Integer.valueOf(((c) this.qyz.qxS.get(this.qyz.qyk.ys)).id));
                if (fragment != null) {
                    ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment).bgS();
                }
            }
        }

        public final void V(int i) {
            super.V(i);
            for (int i2 = 0; i2 < this.qyz.qxS.size(); i2++) {
                Fragment fragment = (Fragment) this.qyz.qyx.get(Integer.valueOf(((c) this.qyz.qxS.get(i2)).id));
                if (fragment != null) {
                    if (i2 == i) {
                        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment).bgS();
                    } else {
                        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment).bgR();
                    }
                }
            }
        }
    };
    private Map<Integer, Fragment> qyx = new HashMap();
    private BroadcastReceiver qyy = new BroadcastReceiver(this) {
        final /* synthetic */ SnsAdNativeLandingPagesUI qyz;

        {
            this.qyz = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                w.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_OFF");
            } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                w.d("MicroMsg.SnsAdNativeLandingPagesUI", "android.intent.action.SCREEN_ON");
                this.qyz.bjI();
            }
        }
    };
    private long startTime;

    static /* synthetic */ void F(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        for (i iVar : snsAdNativeLandingPagesUI.bjH()) {
            if (iVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) {
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a) iVar).bfN();
            }
        }
    }

    static /* synthetic */ void d(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        if (snsAdNativeLandingPagesUI.qys == 0) {
            snsAdNativeLandingPagesUI.bjK();
            if (snsAdNativeLandingPagesUI.qyo && snsAdNativeLandingPagesUI.qyp != null && snsAdNativeLandingPagesUI.qxX) {
                snsAdNativeLandingPagesUI.qyo = false;
                snsAdNativeLandingPagesUI.klK = snsAdNativeLandingPagesUI.getIntent().getIntExtra("img_gallery_top", 0);
                snsAdNativeLandingPagesUI.klL = snsAdNativeLandingPagesUI.getIntent().getIntExtra("img_gallery_left", 0);
                snsAdNativeLandingPagesUI.klM = snsAdNativeLandingPagesUI.getIntent().getIntExtra("img_gallery_width", 0);
                snsAdNativeLandingPagesUI.klN = snsAdNativeLandingPagesUI.getIntent().getIntExtra("img_gallery_height", 0);
                snsAdNativeLandingPagesUI.qxW.p(snsAdNativeLandingPagesUI.klL, snsAdNativeLandingPagesUI.klK, snsAdNativeLandingPagesUI.klM, snsAdNativeLandingPagesUI.klN);
                snsAdNativeLandingPagesUI.jXC.setVisibility(8);
                snsAdNativeLandingPagesUI.qxT.setVisibility(8);
                b bVar = snsAdNativeLandingPagesUI.qxW;
                View view = snsAdNativeLandingPagesUI.qyp;
                LinkedList linkedList = snsAdNativeLandingPagesUI.qyn;
                View view2 = snsAdNativeLandingPagesUI.lMk;
                snsAdNativeLandingPagesUI.isFullScreen();
                b.b anonymousClass14 = new b.b(snsAdNativeLandingPagesUI) {
                    final /* synthetic */ SnsAdNativeLandingPagesUI qyz;

                    {
                        this.qyz = r1;
                    }

                    public final void onAnimationStart() {
                        w.d("MicroMsg.SnsAdNativeLandingPagesUI", "enter anim start");
                    }

                    public final void onAnimationEnd() {
                        w.d("MicroMsg.SnsAdNativeLandingPagesUI", "enter anim end");
                        this.qyz.jXC.setVisibility(0);
                        if (this.qyz.bjJ()) {
                            this.qyz.qxT.setVisibility(0);
                        }
                        this.qyz.qxU.setVisibility(0);
                        this.qyz.setRequestedOrientation(1);
                        this.qyz.bjD();
                    }
                };
                if (!(VERSION.SDK_INT < 12 || view == null || bVar.qoB == bVar.qoy || bVar.qoB == bVar.qoA || bVar.qoB == bVar.qoz)) {
                    bVar.k(view, false);
                    com.tencent.mm.pluginsdk.e.ds(bVar.context);
                    view.setPivotX(0.0f);
                    view.setPivotY(0.0f);
                    view.setScaleX(bVar.qoo);
                    view.setScaleY(bVar.qoo);
                    view.setTranslationX((float) bVar.qok);
                    view.setTranslationY((float) bVar.qol);
                    if (view2 != null) {
                        view2.setAlpha(0.0f);
                        view2.animate().setDuration((long) bVar.qov).setInterpolator(new DecelerateInterpolator(1.2f)).alpha(1.0f);
                    }
                    Iterator it = linkedList.iterator();
                    while (it.hasNext()) {
                        ((View) it.next()).setAlpha(0.0f);
                    }
                    view.animate().setDuration((long) bVar.qov).setInterpolator(new DecelerateInterpolator(1.2f)).scaleX(1.0f).scaleY(1.0f).translationX(0.0f).translationY(0.0f).setListener(new com.tencent.mm.plugin.sns.ui.b.AnonymousClass1(bVar, anonymousClass14, view, linkedList));
                    bVar.mHandler.postDelayed(new com.tencent.mm.plugin.sns.ui.b.AnonymousClass2(bVar, view, linkedList), (long) bVar.qov);
                }
            } else {
                snsAdNativeLandingPagesUI.setRequestedOrientation(1);
                ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) snsAdNativeLandingPagesUI.qyx.get(Integer.valueOf(((c) snsAdNativeLandingPagesUI.qxS.getFirst()).id))).bgS();
                snsAdNativeLandingPagesUI.bjD();
            }
            snsAdNativeLandingPagesUI.qym.postDelayed(new Runnable(snsAdNativeLandingPagesUI) {
                final /* synthetic */ SnsAdNativeLandingPagesUI qyz;

                {
                    this.qyz = r1;
                }

                public final void run() {
                }
            }, 50);
        }
    }

    static /* synthetic */ void t(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        w.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTransimt snsAdNativeLadingPagesUI");
        g gVar = snsAdNativeLandingPagesUI.qye;
        gVar.qmY++;
        AdLandingPagesProxy.getInstance().doTransimt(snsAdNativeLandingPagesUI, snsAdNativeLandingPagesUI.qxY, snsAdNativeLandingPagesUI.lfy, snsAdNativeLandingPagesUI.qyb, snsAdNativeLandingPagesUI.qyc, snsAdNativeLandingPagesUI.lfx);
    }

    static /* synthetic */ void u(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        w.i("MicroMsg.SnsAdNativeLandingPagesUI", "doShareToTimeline snsAdNativeLadingPagesUI");
        g gVar = snsAdNativeLandingPagesUI.qye;
        gVar.qmX++;
        String str = snsAdNativeLandingPagesUI.lfx;
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline fail, link is null");
            return;
        }
        int i = snsAdNativeLandingPagesUI.klM;
        w.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline, init intent");
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_width", i);
        intent.putExtra("Ksnsupload_height", i);
        intent.putExtra("Ksnsupload_link", snsAdNativeLandingPagesUI.lfx);
        intent.putExtra("Ksnsupload_title", snsAdNativeLandingPagesUI.lfy);
        intent.putExtra("Ksnsupload_imgurl", snsAdNativeLandingPagesUI.qyb);
        intent.putExtra("Ksnsupload_canvas_info", snsAdNativeLandingPagesUI.qxY);
        intent.putExtra("Ksnsupload_contentattribute", 0);
        intent.putExtra("Ksnsupload_source", 1);
        intent.putExtra("Ksnsupload_type", 1);
        w.i("MicroMsg.SnsAdNativeLandingPagesUI", "doTimeline, start activity");
        intent.putExtra("need_result", true);
        str = "sns_";
        if (snsAdNativeLandingPagesUI.cGa == 1 || snsAdNativeLandingPagesUI.cGa == 2 || snsAdNativeLandingPagesUI.cGa == 3 || snsAdNativeLandingPagesUI.cGa == 4 || snsAdNativeLandingPagesUI.cGa == 9 || snsAdNativeLandingPagesUI.cGa == 10 || snsAdNativeLandingPagesUI.cGa == 11) {
            str = "sns_" + snsAdNativeLandingPagesUI.fVJ;
        } else if (snsAdNativeLandingPagesUI.cGa == 5 || snsAdNativeLandingPagesUI.cGa == 6) {
            str = "msg_" + snsAdNativeLandingPagesUI.getIntent().getExtras().getLong("msg_id", -2147483648L);
        } else if (snsAdNativeLandingPagesUI.cGa == 7) {
            str = "fav_" + snsAdNativeLandingPagesUI.getIntent().getExtras().getString("sns_landing_favid");
        }
        String fQ = q.fQ(str);
        q.yC().n(fQ, true).l("prePublishId", str);
        intent.putExtra("reportSessionId", fQ);
        com.tencent.mm.bb.d.a(snsAdNativeLandingPagesUI.uSU.uTo, "sns", ".ui.En_c4f742e5", intent, 1, false);
    }

    static /* synthetic */ void v(SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI) {
        g gVar = snsAdNativeLandingPagesUI.qye;
        gVar.hPR++;
        w.i("MicroMsg.SnsAdNativeLandingPagesUI", "doFav snsAdNativeLadingPagesUI");
        long j = snsAdNativeLandingPagesUI.getIntent().getExtras().getLong("msg_id", -2147483648L);
        String str = null;
        if (!bg.mA(snsAdNativeLandingPagesUI.fVJ)) {
            str = AdLandingPagesProxy.getInstance().getSnsInfo(snsAdNativeLandingPagesUI.fVJ).bhy();
        }
        ((com.tencent.mm.plugin.fav.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.fav.a.a.class)).a(AdLandingPagesProxy.getInstance().doFavAdlanding(j, str, snsAdNativeLandingPagesUI.cGa, snsAdNativeLandingPagesUI.lfx, bg.mz(snsAdNativeLandingPagesUI.getIntent().getStringExtra("prePublishId")), snsAdNativeLandingPagesUI.lfy, snsAdNativeLandingPagesUI.qyc, snsAdNativeLandingPagesUI.qxY, 34, snsAdNativeLandingPagesUI.qyb), 34, snsAdNativeLandingPagesUI, snsAdNativeLandingPagesUI.mnV);
    }

    private void bjD() {
        Iterator it = this.qxS.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) this.qyx.get(Integer.valueOf(((c) it.next()).id));
            bVar.qlE = true;
            if (bVar.qlD) {
                bVar.bgM();
            }
        }
        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) this.qyx.get(Integer.valueOf(((c) this.qxS.getFirst()).id))).bgS();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.a aVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b.a(this);
        bjI();
        this.jYq = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ab.cP(this)[1];
        this.qxV = bundle;
        this.uSU.bQg();
        getWindow().addFlags(FileUtils.S_IWUSR);
        AdLandingPagesProxy.create(this.lvq);
        this.lvq.G(new Runnable(this) {
            final /* synthetic */ SnsAdNativeLandingPagesUI qyz;

            {
                this.qyz = r1;
            }

            public final void run() {
                AdlandingRemoteServiceConnectedReceiver.a(android.support.v4.content.d.k(this.qyz));
                SnsAdNativeLandingPagesUI snsAdNativeLandingPagesUI = this.qyz;
                snsAdNativeLandingPagesUI.cGa = snsAdNativeLandingPagesUI.getIntent().getIntExtra("sns_landig_pages_from_source", 1);
                snsAdNativeLandingPagesUI.qfV = snsAdNativeLandingPagesUI.getIntent().getIntExtra("sns_landig_pages_origin_from_source", 0);
                snsAdNativeLandingPagesUI.qxY = snsAdNativeLandingPagesUI.getIntent().getStringExtra("sns_landing_pages_xml");
                snsAdNativeLandingPagesUI.qye.pZL = snsAdNativeLandingPagesUI.getIntent().getStringExtra("sns_landing_pages_expid");
                snsAdNativeLandingPagesUI.qxZ = snsAdNativeLandingPagesUI.getIntent().getStringExtra("sns_landing_pages_xml_prefix");
                snsAdNativeLandingPagesUI.fVJ = snsAdNativeLandingPagesUI.getIntent().getStringExtra("sns_landing_pages_share_sns_id");
                snsAdNativeLandingPagesUI.pZI = snsAdNativeLandingPagesUI.getIntent().getStringExtra("sns_landing_pages_ux_info");
                snsAdNativeLandingPagesUI.qdX = snsAdNativeLandingPagesUI.getIntent().getStringExtra("sns_landing_pages_aid");
                snsAdNativeLandingPagesUI.qeT = snsAdNativeLandingPagesUI.getIntent().getStringExtra("sns_landing_pages_traceid");
                Object stringExtra = snsAdNativeLandingPagesUI.getIntent().getStringExtra("sns_landing_pages_extra");
                g gVar = snsAdNativeLandingPagesUI.qye;
                if (!TextUtils.isEmpty(stringExtra)) {
                    gVar.extra += "&extra1=" + URLEncoder.encode(stringExtra);
                }
                snsAdNativeLandingPagesUI.qyq = AdLandingPagesProxy.getInstance().getSnsInfo(snsAdNativeLandingPagesUI.fVJ);
                AdLandingPagesProxy.getInstance().asyncCacheXml(snsAdNativeLandingPagesUI.fVJ);
                SnsAdNativeLandingPagesUI.qyd = snsAdNativeLandingPagesUI.getIntent().getBooleanExtra("sns_landing_is_native_sight_ad", false);
                if (snsAdNativeLandingPagesUI.qxZ == null || "".equals(snsAdNativeLandingPagesUI.qxY)) {
                    snsAdNativeLandingPagesUI.qxZ = "adxml";
                }
                if (bg.mA(snsAdNativeLandingPagesUI.qxY) || bg.mA(snsAdNativeLandingPagesUI.qxZ)) {
                    w.e("MicroMsg.SnsAdNativeLandingPagesUI", "landingPagesXml is " + snsAdNativeLandingPagesUI.qxY + ",landingPagesXmlPrex is " + snsAdNativeLandingPagesUI.qxZ);
                } else {
                    Map q = f.q(snsAdNativeLandingPagesUI.qxY, snsAdNativeLandingPagesUI.qxZ);
                    if (q == null) {
                        w.e("MicroMsg.SnsAdNativeLandingPagesUI", "parse landingpagexml is error,landingpagexml is " + snsAdNativeLandingPagesUI.qxY);
                    } else {
                        if (snsAdNativeLandingPagesUI.cGa == 1 || snsAdNativeLandingPagesUI.cGa == 2 || snsAdNativeLandingPagesUI.cGa == 14) {
                            long j = 0;
                            if (snsAdNativeLandingPagesUI.qyq != null) {
                                j = snsAdNativeLandingPagesUI.qyq.field_snsId;
                            }
                            q.put("." + snsAdNativeLandingPagesUI.qxZ + ".originSnsId", String.valueOf(j));
                            q.put("." + snsAdNativeLandingPagesUI.qxZ + ".originUxInfo", snsAdNativeLandingPagesUI.pZI);
                            snsAdNativeLandingPagesUI.qxY = snsAdNativeLandingPagesUI.qxY.replace("<" + snsAdNativeLandingPagesUI.qxZ + ">", "<" + snsAdNativeLandingPagesUI.qxZ + ">\n<originSnsId>" + j + "</originSnsId>\n<originUxInfo>" + snsAdNativeLandingPagesUI.pZI + "</originUxInfo>");
                            snsAdNativeLandingPagesUI.qye.pZI = snsAdNativeLandingPagesUI.pZI;
                            snsAdNativeLandingPagesUI.qye.fVJ = String.valueOf(j);
                        } else {
                            snsAdNativeLandingPagesUI.qye.fVJ = (String) q.get("." + snsAdNativeLandingPagesUI.qxZ + ".originSnsId");
                            snsAdNativeLandingPagesUI.qye.pZI = (String) q.get("." + snsAdNativeLandingPagesUI.qxZ + ".originUxInfo");
                            snsAdNativeLandingPagesUI.pZI = snsAdNativeLandingPagesUI.qye.pZI;
                        }
                        snsAdNativeLandingPagesUI.qye.qna = AdLandingPagesProxy.getInstance().getSnsStatExtBySnsId(bg.PZ(snsAdNativeLandingPagesUI.qye.fVJ));
                        snsAdNativeLandingPagesUI.lfy = bg.ap((String) q.get("." + snsAdNativeLandingPagesUI.qxZ + ".adCanvasInfo.shareTitle"), "");
                        snsAdNativeLandingPagesUI.qye.qnb = bg.ap((String) q.get("." + snsAdNativeLandingPagesUI.qxZ + ".adCanvasInfo.canvasId"), "");
                        snsAdNativeLandingPagesUI.lfx = bg.ap((String) q.get("." + snsAdNativeLandingPagesUI.qxZ + ".adCanvasInfo.shareWebUrl"), "");
                        snsAdNativeLandingPagesUI.qyc = bg.ap((String) q.get("." + snsAdNativeLandingPagesUI.qxZ + ".adCanvasInfo.shareDesc"), "");
                        snsAdNativeLandingPagesUI.qyg = bg.PY(bg.ap((String) q.get("." + snsAdNativeLandingPagesUI.qxZ + ".adCanvasInfo.bizId"), ""));
                        snsAdNativeLandingPagesUI.qyh = bg.ap((String) q.get("." + snsAdNativeLandingPagesUI.qxZ + ".adCanvasInfo.shareAppId"), "");
                        snsAdNativeLandingPagesUI.qyi = bg.ap((String) q.get("." + snsAdNativeLandingPagesUI.qxZ + ".adCanvasInfo.shareType"), "");
                        snsAdNativeLandingPagesUI.qyj = bg.ap((String) q.get("." + snsAdNativeLandingPagesUI.qxZ + ".adCanvasInfo.userInfo"), "");
                        snsAdNativeLandingPagesUI.qyl = bg.PY(bg.ap((String) q.get("." + snsAdNativeLandingPagesUI.qxZ + ".adCanvasInfo.disableShareBitSet"), ""));
                        String str = "." + snsAdNativeLandingPagesUI.qxZ;
                        String str2 = (String) q.get(str + ".adCanvasInfo.arrowDownIconStyle.iconUrl");
                        if (TextUtils.isEmpty(str2)) {
                            snsAdNativeLandingPagesUI.qlC = null;
                        } else {
                            if (snsAdNativeLandingPagesUI.qlC == null) {
                                snsAdNativeLandingPagesUI.qlC = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w();
                            }
                            snsAdNativeLandingPagesUI.qlC.iconUrl = str2;
                            int PY = bg.PY((String) q.get(str + ".adCanvasInfo.sizeType"));
                            int PY2 = bg.PY((String) q.get(str + ".adCanvasInfo.basicRootFontSize"));
                            int PY3 = bg.PY((String) q.get(str + ".adCanvasInfo.basicWidth"));
                            int i = (PY2 == 0 && PY == 1) ? com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.qmC : PY2;
                            PY2 = (PY3 == 0 && PY == 1) ? com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.qmB : PY3;
                            snsAdNativeLandingPagesUI.qlC.qfL = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a(bg.Qa((String) q.get(str + ".adCanvasInfo.arrowDownIconStyle.paddingBottom")), PY, PY2, i);
                            snsAdNativeLandingPagesUI.qlC.width = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a(bg.Qa((String) q.get(str + ".adCanvasInfo.arrowDownIconStyle.layoutWidth")), PY, PY2, i);
                            snsAdNativeLandingPagesUI.qlC.height = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.a(bg.Qa((String) q.get(str + ".adCanvasInfo.arrowDownIconStyle.layoutHeight")), PY, PY2, i);
                        }
                        snsAdNativeLandingPagesUI.qxS = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.k(snsAdNativeLandingPagesUI.qxY, snsAdNativeLandingPagesUI.qxZ, snsAdNativeLandingPagesUI.qdX, snsAdNativeLandingPagesUI.qeT);
                        if (snsAdNativeLandingPagesUI.qxS.size() > 0) {
                            String str3 = "";
                            c cVar = (c) snsAdNativeLandingPagesUI.qxS.get(0);
                            if (cVar.qms.size() > 0) {
                                p pVar = (p) cVar.qms.get(0);
                                if (pVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m) {
                                    snsAdNativeLandingPagesUI.qyb = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m) pVar).qfy;
                                } else if (pVar instanceof l) {
                                    snsAdNativeLandingPagesUI.qyb = ((l) pVar).qfy;
                                } else if (pVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n) {
                                    snsAdNativeLandingPagesUI.qyb = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n) pVar).qfA;
                                    str3 = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n) pVar).qfz;
                                }
                            }
                            if (snsAdNativeLandingPagesUI.qyq != null) {
                                bfc bhd = snsAdNativeLandingPagesUI.qyq.bhd();
                                if (!(bhd == null || bhd.ufB == null || bhd.ufB.tsO == null || bhd.ufB.tsO.isEmpty())) {
                                    alh com_tencent_mm_protocal_c_alh = (alh) bhd.ufB.tsO.getFirst();
                                    String str4 = am.du(AdLandingPagesProxy.getInstance().getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + com.tencent.mm.plugin.sns.data.i.j(com_tencent_mm_protocal_c_alh);
                                    str2 = com_tencent_mm_protocal_c_alh.msN;
                                    if (str3.equals(str2)) {
                                        str2 = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.d.dB("adId", str2);
                                        if (!FileOp.aO(str2) && FileOp.aO(str4)) {
                                            w.i("MicroMsg.SnsAdNativeLandingPagesUI", "copy outsideFiel:%s->%s", new Object[]{str4, str2});
                                            FileOp.p(str4, str2);
                                        }
                                    }
                                }
                            }
                        }
                        snsAdNativeLandingPagesUI.qxX = snsAdNativeLandingPagesUI.getIntent().getBooleanExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                        if (snsAdNativeLandingPagesUI.qxX) {
                            snsAdNativeLandingPagesUI.qye.qmP = 0;
                            snsAdNativeLandingPagesUI.qye.gKy = 0;
                        } else {
                            snsAdNativeLandingPagesUI.qye.qmP = 1;
                            snsAdNativeLandingPagesUI.qye.gKy = 1;
                        }
                        snsAdNativeLandingPagesUI.qye.qmQ = snsAdNativeLandingPagesUI.cGa;
                        snsAdNativeLandingPagesUI.qye.qmR = 0;
                        snsAdNativeLandingPagesUI.qye.qmS = 0;
                        snsAdNativeLandingPagesUI.qye.qmT = 1;
                        snsAdNativeLandingPagesUI.qye.qmU = 0;
                        snsAdNativeLandingPagesUI.qye.qfV = snsAdNativeLandingPagesUI.qfV;
                    }
                }
                this.qyz.bjI();
                this.qyz.KC();
                if (this.qyz.qyg == 1) {
                    AdLandingPagesProxy.getInstance().doDynamicUpdateScene(this.qyz.qyh, this.qyz.qyi, this.qyz.qyj, new AdLandingPagesProxy.a(this) {
                        final /* synthetic */ AnonymousClass10 qyE;

                        {
                            this.qyE = r1;
                        }

                        public final void ak(final Object obj) {
                            this.qyE.qyz.qym.removeCallbacksAndMessages(null);
                            this.qyE.qyz.qym.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass1 qyF;

                                public final void run() {
                                    this.qyF.qyE.qyz.qxS = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.e.c(this.qyF.qyE.qyz.qxY, this.qyF.qyE.qyz.qxZ, (String) obj, this.qyF.qyE.qyz.qdX, this.qyF.qyE.qyz.qeT);
                                    af.v(new Runnable(this) {
                                        final /* synthetic */ AnonymousClass1 qyG;

                                        {
                                            this.qyG = r1;
                                        }

                                        public final void run() {
                                            this.qyG.qyF.qyE.qyz.bjF();
                                        }
                                    });
                                }
                            });
                        }

                        public final void f(int i, int i2, Object obj) {
                        }
                    });
                }
                this.qyz.jEa = true;
            }
        });
        this.startTime = System.currentTimeMillis();
    }

    protected final int Ol() {
        return 1;
    }

    protected void onDestroy() {
        getWindow().clearFlags(FileUtils.S_IWUSR);
        if (this.jEa) {
            w.i("MicroMsg.SnsAdNativeLandingPagesUI", "the SnsAdNativeLadingPagesUI is destroy");
            if (!this.qyf) {
                bjE();
                qg();
            }
        }
        unregisterReceiver(this.qyy);
        if (this.uSU.uTG == 1) {
            aHf();
        }
        super.onDestroy();
    }

    private void bjE() {
        for (Fragment fragment : ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c) this.qyk.yr).pZ) {
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment;
            if (bVar.qlB != null && bVar.getUserVisibleHint()) {
                bVar.qlB.bgH();
            }
        }
    }

    private void qg() {
        int i;
        Iterator it;
        List<i> bjG = bjG();
        this.jgn += System.currentTimeMillis() - this.startTime;
        this.qye.qmW = (int) this.jgn;
        g gVar = this.qye;
        if (this.qxS == null) {
            i = 0;
        } else {
            it = this.qxS.iterator();
            i = 0;
            while (it.hasNext()) {
                i = ((c) it.next()).qms.size() + i;
            }
        }
        gVar.qmV = i;
        g gVar2 = this.qye;
        JSONArray jSONArray = new JSONArray();
        for (i iVar : bjG) {
            if (!iVar.bgp().qfU) {
                JSONObject jSONObject = new JSONObject();
                if (!iVar.q(jSONArray)) {
                    if (iVar.J(jSONObject)) {
                        jSONArray.put(jSONObject);
                    }
                    if (iVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n) {
                        it = ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n) iVar).bgx().iterator();
                        while (it.hasNext()) {
                            jSONArray.put((JSONObject) it.next());
                        }
                    }
                }
            }
        }
        gVar2.qmZ = jSONArray.toString();
        w.d("MicroMsg.AdLandingPagesReportInfo", "componentsStatStr:%s", new Object[]{gVar2.qmZ});
        if (!bg.mA(gVar2.qmZ)) {
            try {
                gVar2.qmZ = URLEncoder.encode(gVar2.qmZ, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                w.e("MicroMsg.AdLandingPagesReportInfo", "not support encode " + e.toString());
            }
        }
        String bgY = this.qye.bgY();
        com.tencent.mm.plugin.report.service.g.oUh.A(13387, bgY);
        w.i("MicroMsg.SnsAdNativeLandingPagesUI", "post kv stat 13387 data: " + bgY);
    }

    protected void onResume() {
        super.onResume();
        w.i("MicroMsg.SnsAdNativeLandingPagesUI", "onResume");
        bjI();
        android.support.v4.content.d.k(this).a(this.qyt, new IntentFilter("com.tencent.mm.adlanding.video_progressbar_change"));
        android.support.v4.content.d.k(this).a(this.qyu, new IntentFilter("com.tencent.mm.adlanding.set_uioption"));
        if (this.jEa) {
            this.startTime = System.currentTimeMillis();
        }
        registerReceiver(this.qyy, new IntentFilter("android.intent.action.SCREEN_ON"));
    }

    protected void onPause() {
        super.onPause();
        if (this.jEa) {
            this.jgn += System.currentTimeMillis() - this.startTime;
        }
        android.support.v4.content.d.k(this).unregisterReceiver(this.qyt);
        android.support.v4.content.d.k(this).unregisterReceiver(this.qyu);
    }

    public final void VK() {
        this.qye.gKy = 2;
        g gVar = this.qye;
        gVar.qmU++;
        super.VK();
    }

    private void bjF() {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c cVar;
        if (this.qxS != null) {
            Iterator it = this.qxS.iterator();
            while (it.hasNext()) {
                List<p> list = ((c) it.next()).qms;
                if (list != null) {
                    for (p pVar : list) {
                        pVar.tq(this.qfV == 0 ? this.cGa : this.qfV);
                        pVar.hC(qyd);
                        pVar.FV(this.pZI);
                    }
                }
            }
        }
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c cVar2 = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c) this.qyk.yr;
        if (cVar2 == null) {
            u cVar3 = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c(aR(), new ArrayList());
            this.qyk.a(cVar3);
            cVar = cVar3;
        } else {
            cVar = cVar2;
        }
        int i = 0;
        while (i < this.qxS.size()) {
            c cVar4 = (c) this.qxS.get(i);
            if (cVar4.qfT) {
                Object obj = (Fragment) this.qyx.get(Integer.valueOf(cVar4.id));
                if (obj == null) {
                    boolean z;
                    DummyViewPager dummyViewPager = this.qyk;
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.w wVar = this.qlC;
                    if (i == this.qxS.size() - 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    obj = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b.a(cVar4, dummyViewPager, wVar, z, i == 0 ? this.qyv : null, this.qxX);
                    this.qyx.put(Integer.valueOf(cVar4.id), obj);
                } else {
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b bVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) obj;
                    if (bVar.qlw != cVar4) {
                        bVar.qlw = cVar4;
                        bVar.auz();
                    }
                }
                cVar.pZ.remove(obj);
                if (i >= cVar.pZ.size()) {
                    cVar.pZ.add(obj);
                } else {
                    cVar.pZ.add(i, obj);
                }
            }
            i++;
        }
        cVar.notifyDataSetChanged();
        AdLandingViewPager adLandingViewPager = this.qyk;
        int size = this.qxS.size();
        if (size <= 0) {
            new StringBuilder("Requested offscreen page limit ").append(size).append(" too small; defaulting to 1");
            size = 1;
        }
        if (size != adLandingViewPager.yJ) {
            adLandingViewPager.yJ = size;
            adLandingViewPager.populate();
        }
    }

    private List<i> bjG() {
        List<i> arrayList = new ArrayList();
        for (Fragment fragment : ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c) this.qyk.yr).pZ) {
            arrayList.addAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment).bgQ());
        }
        return arrayList;
    }

    private List<i> bjH() {
        List<i> arrayList = new ArrayList();
        arrayList.addAll(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) this.qyx.get(Integer.valueOf(((c) this.qxS.getFirst()).id))).bgQ());
        return arrayList;
    }

    @TargetApi(16)
    protected final void KC() {
        super.KC();
        this.qlS = findViewById(com.tencent.mm.plugin.sns.i.f.czn);
        this.qyk = (AdlandingDummyViewPager) findViewById(com.tencent.mm.plugin.sns.i.f.pGp);
        AdlandingDummyViewPager adlandingDummyViewPager = this.qyk;
        adlandingDummyViewPager.qlq.add(this.qyw);
        this.lMk = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.bSt);
        this.qxU = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.pEa);
        this.jXC = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.pDZ);
        this.jXC.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsAdNativeLandingPagesUI qyz;

            {
                this.qyz = r1;
            }

            public final void onClick(View view) {
                this.qyz.ahz();
            }
        });
        this.qxT = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.pEo);
        if (bjJ()) {
            this.qxT.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SnsAdNativeLandingPagesUI qyz;

                {
                    this.qyz = r1;
                }

                public final void onClick(View view) {
                    final com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(this.qyz, com.tencent.mm.ui.widget.e.wuP, false);
                    eVar.qJf = new com.tencent.mm.ui.base.n.c(this) {
                        final /* synthetic */ AnonymousClass12 qyH;

                        {
                            this.qyH = r1;
                        }

                        public final void a(com.tencent.mm.ui.base.l lVar) {
                            if (this.qyH.qyz.qyl == 0 || (this.qyH.qyz.qyl & 2) == 0) {
                                lVar.a(1, this.qyH.qyz.getString(j.eLL), com.tencent.mm.plugin.sns.i.i.duZ);
                            }
                            if (this.qyH.qyz.qyl == 0 || (this.qyH.qyz.qyl & 1) == 0) {
                                lVar.a(2, this.qyH.qyz.getString(j.pKo), com.tencent.mm.plugin.sns.i.i.duP);
                            }
                            if ((this.qyH.qyz.qyl == 0 || (this.qyH.qyz.qyl & 4) == 0) && this.qyH.qyz.cGa != 7) {
                                lVar.a(3, this.qyH.qyz.getString(j.dTs), com.tencent.mm.plugin.sns.i.i.duI);
                            }
                        }
                    };
                    eVar.wva = new com.tencent.mm.ui.widget.e.a(this) {
                        final /* synthetic */ AnonymousClass12 qyH;

                        {
                            this.qyH = r1;
                        }

                        public final void onDismiss() {
                            this.qyH.qyz.bjI();
                        }
                    };
                    eVar.qJg = new com.tencent.mm.ui.base.n.d(this) {
                        final /* synthetic */ AnonymousClass12 qyH;

                        {
                            this.qyH = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            this.qyH.qyz.bjI();
                            if (menuItem != null) {
                                switch (menuItem.getItemId()) {
                                    case 1:
                                        SnsAdNativeLandingPagesUI.t(this.qyH.qyz);
                                        return;
                                    case 2:
                                        SnsAdNativeLandingPagesUI.u(this.qyH.qyz);
                                        return;
                                    case 3:
                                        SnsAdNativeLandingPagesUI.v(this.qyH.qyz);
                                        return;
                                    default:
                                        return;
                                }
                            }
                        }
                    };
                    eVar.sjm = true;
                    if (this.qyz.isFullScreen()) {
                        eVar.bzh();
                        return;
                    }
                    this.qyz.aHf();
                    this.qyz.qxT.postDelayed(new Runnable(this) {
                        final /* synthetic */ AnonymousClass12 qyH;

                        public final void run() {
                            eVar.bzh();
                        }
                    }, 300);
                }
            });
        } else {
            this.qxT.setVisibility(8);
        }
        this.qya = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.pFq);
        if (this.qxS == null || this.qxS.size() == 0) {
            w.e("MicroMsg.SnsAdNativeLandingPagesUI", "landingPages is null");
            return;
        }
        bjF();
        this.qxW = new b(this.uSU.uTo);
        this.qlS.addOnLayoutChangeListener(new OnLayoutChangeListener(this) {
            final /* synthetic */ SnsAdNativeLandingPagesUI qyz;

            {
                this.qyz = r1;
            }

            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (this.qyz.qlS.getHeight() == this.qyz.jYq) {
                    this.qyz.qlS.removeOnLayoutChangeListener(this);
                    this.qyz.qys = this.qyz.qys - 1;
                    SnsAdNativeLandingPagesUI.d(this.qyz);
                }
            }
        });
    }

    private boolean isFullScreen() {
        boolean z;
        if (this.qxS != null) {
            Iterator it = this.qxS.iterator();
            z = false;
            while (it.hasNext()) {
                Iterator it2 = ((c) it.next()).qms.iterator();
                while (it2.hasNext()) {
                    if (((p) it2.next()).type == 82) {
                        z = true;
                        break;
                    }
                }
            }
        }
        z = false;
        if (z) {
            return false;
        }
        return true;
    }

    private void bjI() {
        w.i("MicroMsg.SnsAdNativeLandingPagesUI", "setFullScreen");
        int i = 4102;
        getWindow().getAttributes();
        if (isFullScreen()) {
            i = 5126;
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        } else {
            getWindow().clearFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        getWindow().getDecorView().setSystemUiVisibility(i);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.pHk;
    }

    private boolean bjJ() {
        if (this.qyl == 0 || (this.qyl & 4) == 0 || (this.qyl & 2) == 0 || (this.qyl & 1) == 0) {
            return true;
        }
        return false;
    }

    private void bjK() {
        Iterator it;
        List<i> bjH = bjH();
        LinkedList linkedList = new LinkedList();
        for (i view : bjH) {
            linkedList.add((View) view.getView().getParent());
        }
        this.qyp = null;
        if (this.qyn != null) {
            this.qyn.clear();
        }
        if (!linkedList.isEmpty()) {
            this.qyp = (View) linkedList.removeFirst();
            if (this.qyn == null) {
                this.qyn = new LinkedList();
            }
            this.qyn.clear();
            int height = this.qyp.getHeight();
            it = linkedList.iterator();
            int i = height;
            while (it.hasNext()) {
                View view2 = (View) it.next();
                i += view2.getHeight();
                this.qyn.add(view2);
                if (i >= this.jYq) {
                    return;
                }
            }
        }
    }

    public final void ahz() {
        bjE();
        qg();
        this.qyf = true;
        if (this.qxX) {
            this.qyk.k(0, false);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) this.qyx.get(Integer.valueOf(((c) this.qxS.getFirst()).id))).bgP().Zf;
            linearLayoutManager.Xv = 0;
            linearLayoutManager.Xw = 0;
            if (linearLayoutManager.Xy != null) {
                linearLayoutManager.Xy.XK = -1;
            }
            linearLayoutManager.requestLayout();
            bjE();
            if (this.qyp != null) {
                this.qyp.postDelayed(new Runnable(this) {
                    final /* synthetic */ SnsAdNativeLandingPagesUI qyz;

                    {
                        this.qyz = r1;
                    }

                    public final void run() {
                        this.qyz.bjK();
                        SnsAdNativeLandingPagesUI.F(this.qyz);
                        this.qyz.qxW.p(this.qyz.klL, this.qyz.klK, this.qyz.klM, this.qyz.klN);
                        b bVar = this.qyz.qxW;
                        View K = this.qyz.qyp;
                        LinkedList L = this.qyz.qyn;
                        View M = this.qyz.lMk;
                        b.b anonymousClass1 = new b.b(this) {
                            final /* synthetic */ AnonymousClass3 qyA;

                            {
                                this.qyA = r1;
                            }

                            public final void onAnimationStart() {
                                this.qyA.qyz.jXC.setVisibility(8);
                            }

                            public final void onAnimationEnd() {
                                new ae().post(new Runnable(this) {
                                    final /* synthetic */ AnonymousClass1 qyB;

                                    {
                                        this.qyB = r1;
                                    }

                                    public final void run() {
                                        this.qyB.qyA.qyz.finish();
                                        this.qyB.qyA.qyz.overridePendingTransition(0, 0);
                                    }
                                });
                            }
                        };
                        if (VERSION.SDK_INT >= 12 && K != null && bVar.qoB != bVar.qoy && bVar.qoB != bVar.qoA && bVar.qoB != bVar.qox) {
                            K.getLocationOnScreen(new int[2]);
                            bVar.k(K, true);
                            if (M != null) {
                                M.animate().setDuration(300).setInterpolator(new DecelerateInterpolator(1.2f)).alpha(0.0f);
                            }
                            Animation animationSet = new AnimationSet(true);
                            Animation anonymousClass3 = new com.tencent.mm.plugin.sns.ui.b.AnonymousClass3(bVar, bVar.qoo, bVar.qoo, K, null);
                            anonymousClass3.setDuration(300);
                            anonymousClass3.setInterpolator(new DecelerateInterpolator(1.2f));
                            animationSet.addAnimation(anonymousClass3);
                            anonymousClass3 = new TranslateAnimation(0.0f, (float) bVar.qok, 0.0f, (float) bVar.qol);
                            anonymousClass3.setDuration(300);
                            anonymousClass3.setInterpolator(new DecelerateInterpolator(1.2f));
                            animationSet.addAnimation(anonymousClass3);
                            animationSet.setFillAfter(true);
                            animationSet.setAnimationListener(new com.tencent.mm.plugin.sns.ui.b.AnonymousClass4(bVar, anonymousClass1));
                            K.startAnimation(animationSet);
                            Iterator it = L.iterator();
                            while (it.hasNext()) {
                                ((View) it.next()).setAlpha(0.0f);
                            }
                        }
                    }
                }, 10);
                return;
            }
            finish();
            overridePendingTransition(0, 0);
            return;
        }
        finish();
    }

    public void onBackPressed() {
        ahz();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (i2 == -1) {
                com.tencent.mm.ui.base.g.bl(this.uSU.uTo, this.uSU.uTo.getString(j.dIG));
            }
        } else if (i == 2) {
            if (intent.getBooleanExtra("kfavorite", false)) {
                ((com.tencent.mm.plugin.fav.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.fav.a.a.class)).a(AdLandingPagesProxy.getInstance().doFav(intent, 42), 42, this, this.mnV);
            }
        } else if (i == v.qka) {
            try {
                String stringExtra = intent.getStringExtra("KComponentCid");
                for (i iVar : bjG()) {
                    if (iVar.bgq().equals(stringExtra)) {
                        v vVar = (v) iVar;
                        int intExtra = intent.getIntExtra("KStreamVideoPlayCount", 0);
                        int intExtra2 = intent.getIntExtra("KStreamVideoPlayCompleteCount", 0);
                        int intExtra3 = intent.getIntExtra("KStreamVideoTotalPlayTimeInMs", 0);
                        vVar.pPu = intExtra + vVar.pPu;
                        vVar.pPv += intExtra2;
                        vVar.pPw += intExtra3;
                        break;
                    }
                }
            } catch (Exception e) {
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void bit() {
        super.bit();
        if (this.qyk != null) {
            this.qyk.postDelayed(new Runnable(this) {
                final /* synthetic */ SnsAdNativeLandingPagesUI qyz;

                {
                    this.qyz = r1;
                }

                public final void run() {
                    if (this.qyz.uSU.uTG != 1) {
                        this.qyz.bjI();
                    }
                    ArrayList arrayList = new ArrayList();
                    for (Fragment fragment : ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.c) this.qyz.qyk.yr).pZ) {
                        ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget.verticalviewpager.a.b) fragment).bgL();
                    }
                }
            }, 500);
        }
    }
}
