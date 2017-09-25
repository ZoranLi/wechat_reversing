package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.AdLandingPagesProxy;
import com.tencent.mm.plugin.sns.ui.widget.SnsTextProgressBar;
import com.tencent.mm.pluginsdk.model.app.g.c;
import com.tencent.mm.protocal.c.jw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.Serializable;
import java.util.List;

public final class m extends j implements e, Serializable {
    public Button qik;
    public SnsTextProgressBar qil;
    public a qim = new a(this, "apkStateMachine");
    public b qin;
    private OnClickListener qio = new OnClickListener(this) {
        final /* synthetic */ m qiq;

        {
            this.qiq = r1;
        }

        public final void onClick(View view) {
            this.qiq.qim.yw(0);
            this.qiq.bgr();
        }
    };
    com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a qip = new com.tencent.mm.plugin.sns.model.AdLandingPagesProxy.a(this) {
        final /* synthetic */ m qiq;

        {
            this.qiq = r1;
        }

        public final void ak(Object obj) {
        }

        public final void f(int i, int i2, Object obj) {
            if (i == 0 && i2 == 0) {
                jw jwVar = new jw();
                try {
                    jwVar.aD((byte[]) obj);
                } catch (Throwable e) {
                    w.e("MicroMsg.AdLandingPageDownloadApkBtnComp", bg.g(e));
                }
                if (!TextUtils.isEmpty(jwVar.tpW)) {
                    w.d("MicroMsg.AdLandingPageDownloadApkBtnComp", "opening url " + jwVar.tpW);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", jwVar.tpW);
                    intent.putExtra("showShare", true);
                    d.b(this.qiq.context, "webview", ".ui.tools.WebViewUI", intent);
                    this.qiq.qim.yw(10);
                    return;
                } else if (jwVar.tpV != null) {
                    this.qiq.bgu().qeZ = jwVar.tpV.tpM;
                    this.qiq.bgu().fFW = jwVar.tpV.tpK;
                    this.qiq.bgu().downloadUrl = jwVar.tpV.tpL;
                    this.qiq.bgu().fileSize = (long) jwVar.tpV.tpP;
                    this.qiq.qim.yw(6);
                    return;
                } else {
                    w.i("MicroMsg.AdLandingPageDownloadApkBtnComp", "resp null");
                    this.qiq.qim.yw(5);
                    return;
                }
            }
            this.qiq.qim.yw(5);
        }
    };

    private class b extends BroadcastReceiver implements Serializable {
        final /* synthetic */ m qiq;

        private b(m mVar) {
            this.qiq = mVar;
        }

        public final void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String action = intent.getAction();
                Object schemeSpecificPart;
                if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                    schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    if (!TextUtils.isEmpty(schemeSpecificPart) && schemeSpecificPart.equals(this.qiq.bgu().uq)) {
                        this.qiq.qim.yw(3);
                    }
                } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                    schemeSpecificPart = intent.getData().getSchemeSpecificPart();
                    if (!TextUtils.isEmpty(schemeSpecificPart) && schemeSpecificPart.equals(this.qiq.bgu().uq)) {
                        this.qiq.qim.yw(4);
                    }
                }
            }
        }
    }

    class a extends com.tencent.mm.sdk.d.d implements Serializable {
        com.tencent.mm.sdk.d.c qiA = new a(this);
        com.tencent.mm.sdk.d.c qiB = new d(this);
        final /* synthetic */ m qiq;
        com.tencent.mm.sdk.d.c qit = new c(this);
        com.tencent.mm.sdk.d.c qiu = new g(this);
        com.tencent.mm.sdk.d.c qiv = new e(this);
        com.tencent.mm.sdk.d.c qiw = new h(this);
        com.tencent.mm.sdk.d.c qix = new i(this);
        com.tencent.mm.sdk.d.c qiy = new f(this);
        com.tencent.mm.sdk.d.c qiz = new b(this);

        class a extends com.tencent.mm.sdk.d.b {
            final /* synthetic */ a qiC;

            a(a aVar) {
                this.qiC = aVar;
            }

            public final void enter() {
                super.enter();
                this.qiC.qiq.qil.setVisibility(8);
                this.qiC.qiq.qik.setEnabled(false);
                this.qiC.qiq.qik.setText(!TextUtils.isEmpty(this.qiC.qiq.bgu().qfc) ? this.qiC.qiq.bgu().qfc : "暂不支持安卓手机");
                this.qiC.qiq.qik.setVisibility(0);
            }
        }

        class b extends com.tencent.mm.sdk.d.b {
            final /* synthetic */ a qiC;

            b(a aVar) {
                this.qiC = aVar;
            }

            public final boolean f(Message message) {
                w.i("LogStateTransitionState", "recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        this.qiC.b(this.qiC.qiv);
                        return true;
                    case 5:
                        this.qiC.FX("下载失败");
                        this.qiC.b(this.qiC.qiy);
                        return true;
                    case 6:
                        this.qiC.b(this.qiC.qit);
                        return true;
                    case 10:
                        this.qiC.b(this.qiC.qiu);
                        return true;
                    default:
                        return false;
                }
            }

            public final void enter() {
                super.enter();
                AdLandingPagesProxy.getInstance().doAdChannelScene(this.qiC.qiq.bgu().uq, this.qiC.qiq.bgu().channelId, this.qiC.qiq.qip);
                AdLandingPagesProxy.getInstance().stopTask(this.qiC.qiq.bgu().fTO);
                this.qiC.qiq.qik.setVisibility(8);
                this.qiC.qiq.qil.setVisibility(0);
                this.qiC.qiq.qil.setProgress(0);
                w.i("LogStateTransitionState", "appid %s, channelId %s", new Object[]{this.qiC.qiq.bgu().uq, this.qiC.qiq.bgu().channelId});
            }
        }

        class c extends com.tencent.mm.sdk.d.b {
            final /* synthetic */ a qiC;
            com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a qiD;

            private class a implements com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.a.a {
                final /* synthetic */ c qiE;

                public a(c cVar) {
                    this.qiE = cVar;
                }

                public final void start() {
                }

                public final void sT(int i) {
                    com.tencent.mm.sdk.d.d dVar = this.qiE.qiC.qiq.qim;
                    c cVar = dVar.uwt;
                    if (cVar != null) {
                        cVar.sendMessage(Message.obtain(dVar.uwt, 1, i, 0));
                    }
                }

                public final void bdI() {
                    w.i("LogStateTransitionState", "paused");
                    this.qiE.qiC.qiq.qim.yw(7);
                }

                public final void bdJ() {
                }

                public final void bdK() {
                    this.qiE.qiC.qiq.qim.yw(9);
                }

                public final void bdL() {
                    this.qiE.qiC.qiq.qim.yw(8);
                }

                public final void bdM() {
                }
            }

            c(a aVar) {
                this.qiC = aVar;
            }

            public final void enter() {
                super.enter();
                this.qiC.qiq.qik.setVisibility(8);
                this.qiC.qiq.qil.setVisibility(0);
                if (AdLandingPagesProxy.getInstance().isPaused(this.qiC.qiq.bgu().fTO) || AdLandingPagesProxy.getInstance().isDownloading(this.qiC.qiq.bgu().fTO)) {
                    if (this.qiD == null) {
                        this.qiD = new a(this);
                    }
                    this.qiC.qiq.qil.setProgress(AdLandingPagesProxy.getInstance().getTaskProgress(this.qiC.qiq.bgu().fTO));
                    if (!AdLandingPagesProxy.getInstance().resumeTask(this.qiC.qiq.bgu().fTO, this.qiD, this.qiC.qiq.bgu().qdX, this.qiC.qiq.bgu().qdW)) {
                        AdLandingPagesProxy.getInstance().stopTask(this.qiC.qiq.bgu().fTO);
                        this.qiC.b(this.qiC.qit);
                    }
                } else if (TextUtils.isEmpty(this.qiC.qiq.bgu().downloadUrl)) {
                    this.qiC.b(this.qiC.qiz);
                } else if (AdLandingPagesProxy.getInstance().isApkExist(this.qiC.qiq.bgu().fTO)) {
                    this.qiC.qiq.qil.setProgress(100);
                    this.qiC.b(this.qiC.qiw);
                } else {
                    AdLandingPagesProxy.getInstance().stopTask(this.qiC.qiq.bgu().fTO);
                    this.qiD = new a(this);
                    AdLandingPagesProxy.getInstance().startDownload(this.qiC.qiq.bgu().fTO, this.qiC.qiq.bgu().uq, this.qiC.qiq.bgu().fFW, this.qiC.qiq.bgu().downloadUrl, this.qiC.qiq.bgu().qeZ, this.qiC.qiq.bgu().qfa, this.qiD, this.qiC.qiq.bgu().qdX, this.qiC.qiq.bgu().qdW);
                }
            }

            public final boolean f(Message message) {
                w.i("LogStateTransitionState", "recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        if (AdLandingPagesProxy.getInstance().pauseTask(this.qiC.qiq.bgu().fTO) && AdLandingPagesProxy.getInstance().isPaused(this.qiC.qiq.bgu().fTO)) {
                            this.qiC.b(this.qiC.qiv);
                        }
                        return true;
                    case 1:
                        int i = message.arg1;
                        if (i >= 0) {
                            this.qiC.qiq.qil.setProgress(i);
                        }
                        return true;
                    case 3:
                        this.qiC.b(this.qiC.qix);
                        return true;
                    case 7:
                        this.qiC.b(this.qiC.qiv);
                        return true;
                    case 8:
                        this.qiC.FX("下载失败");
                        this.qiC.b(this.qiC.qiy);
                        return true;
                    case 9:
                        if (this.qiC.qiq.bgu().qfa) {
                            AdLandingPagesProxy.getInstance().reportDownloadInfo(4, this.qiC.qiq.bgu().fTO, this.qiC.qiq.bgu().uq, this.qiC.qiq.bgu().fFW, this.qiC.qiq.bgu().downloadUrl);
                        }
                        this.qiC.qiq.bgw();
                        this.qiC.b(this.qiC.qiw);
                        return true;
                    default:
                        return false;
                }
            }
        }

        class d extends com.tencent.mm.sdk.d.b {
            final /* synthetic */ a qiC;

            d(a aVar) {
                this.qiC = aVar;
            }

            public final void enter() {
                super.enter();
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b bgu = this.qiC.qiq.bgu();
                Object obj = (bgu.qfb == 0 || bgu.qfb == 2) ? 1 : null;
                if (obj != null) {
                    this.qiC.b(this.qiC.qiu);
                } else {
                    this.qiC.b(this.qiC.qiA);
                }
            }
        }

        class e extends com.tencent.mm.sdk.d.b {
            final /* synthetic */ a qiC;

            e(a aVar) {
                this.qiC = aVar;
            }

            public final void enter() {
                super.enter();
                this.qiC.qiq.qil.setVisibility(8);
                this.qiC.qiq.qik.setVisibility(0);
                this.qiC.qiq.qik.setText("继续下载");
            }

            public final boolean f(Message message) {
                w.i("LogStateTransitionState", "recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        this.qiC.b(this.qiC.qit);
                        return true;
                    case 3:
                        this.qiC.b(this.qiC.qix);
                        return true;
                    case 8:
                        this.qiC.FX("下载失败");
                        this.qiC.b(this.qiC.qiy);
                        return true;
                    default:
                        return false;
                }
            }
        }

        class f extends com.tencent.mm.sdk.d.b {
            final /* synthetic */ a qiC;

            f(a aVar) {
                this.qiC = aVar;
            }

            public final void enter() {
                super.enter();
                this.qiC.qiq.qil.setVisibility(8);
                this.qiC.qiq.qik.setVisibility(0);
                this.qiC.qiq.qik.setText("重新下载");
            }

            public final boolean f(Message message) {
                w.i("LogStateTransitionState", "recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        this.qiC.b(this.qiC.qiz);
                        return true;
                    default:
                        return false;
                }
            }
        }

        class g extends com.tencent.mm.sdk.d.b {
            final /* synthetic */ a qiC;

            g(a aVar) {
                this.qiC = aVar;
            }

            public final void enter() {
                super.enter();
                if (this.qiC.qiq.qin == null) {
                    this.qiC.qiq.qin = new b();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                    intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                    intentFilter.addDataScheme("package");
                    this.qiC.qiq.context.registerReceiver(this.qiC.qiq.qin, intentFilter);
                }
                if (AdLandingPagesProxy.getInstance().isPkgInstalled(this.qiC.qiq.bgu().uq)) {
                    this.qiC.b(this.qiC.qix);
                } else if (AdLandingPagesProxy.getInstance().isApkExist(this.qiC.qiq.bgu().fTO)) {
                    this.qiC.b(this.qiC.qiw);
                } else if (AdLandingPagesProxy.getInstance().isDownloading(this.qiC.qiq.bgu().fTO)) {
                    this.qiC.b(this.qiC.qit);
                } else if (AdLandingPagesProxy.getInstance().isPaused(this.qiC.qiq.bgu().fTO)) {
                    this.qiC.b(this.qiC.qiv);
                } else {
                    this.qiC.qiq.qil.setVisibility(8);
                    this.qiC.qiq.qik.setVisibility(0);
                    this.qiC.qiq.qik.setText(this.qiC.qiq.bgu().title);
                }
            }

            public final boolean f(Message message) {
                w.i("LogStateTransitionState", "recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        this.qiC.b(this.qiC.qiz);
                        return true;
                    case 3:
                        this.qiC.b(this.qiC.qix);
                        return true;
                    case 11:
                        this.qiC.b(this.qiC.qiu);
                        return true;
                    default:
                        return false;
                }
            }
        }

        class h extends com.tencent.mm.sdk.d.b {
            final /* synthetic */ a qiC;
            private boolean qiF;

            h(a aVar) {
                this.qiC = aVar;
            }

            public final void enter() {
                super.enter();
                if (AdLandingPagesProxy.getInstance().isApkExist(this.qiC.qiq.bgu().fTO)) {
                    this.qiC.qiq.qil.setVisibility(8);
                    this.qiC.qiq.qik.setVisibility(0);
                    this.qiC.qiq.qik.setText("安装应用");
                    this.qiF = true;
                    return;
                }
                this.qiC.b(this.qiC.qiu);
            }

            public final boolean f(Message message) {
                w.i("LogStateTransitionState", "recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        if (AdLandingPagesProxy.getInstance().installApp(this.qiC.qiq.context, this.qiC.qiq.bgu().fTO)) {
                            this.qiF = true;
                            return true;
                        }
                        this.qiC.FX("安装失败");
                        this.qiC.b(this.qiC.qiy);
                        return true;
                    case 2:
                        if (!AdLandingPagesProxy.getInstance().isApkExist(this.qiC.qiq.bgu().fTO)) {
                            this.qiC.b(this.qiC.qiu);
                        }
                        return true;
                    case 3:
                        if (this.qiF) {
                            this.qiF = false;
                            AdLandingPagesProxy.getInstance().reportDownloadInfo(5, this.qiC.qiq.bgu().fTO, this.qiC.qiq.bgu().uq, this.qiC.qiq.bgu().fFW, this.qiC.qiq.bgu().downloadUrl);
                        }
                        this.qiC.b(this.qiC.qix);
                        return true;
                    default:
                        return false;
                }
            }
        }

        class i extends com.tencent.mm.sdk.d.b {
            final /* synthetic */ a qiC;

            i(a aVar) {
                this.qiC = aVar;
            }

            public final void enter() {
                super.enter();
                if (AdLandingPagesProxy.getInstance().isPkgInstalled(this.qiC.qiq.bgu().uq)) {
                    this.qiC.qiq.qil.setVisibility(8);
                    this.qiC.qiq.qik.setVisibility(0);
                    this.qiC.qiq.qik.setText("打开应用");
                    return;
                }
                this.qiC.b(this.qiC.qiw);
            }

            public final boolean f(Message message) {
                w.i("LogStateTransitionState", "recv msg.what " + message.what);
                switch (message.what) {
                    case 0:
                        if (this.qiC.qiq.bgv()) {
                            return true;
                        }
                        this.qiC.FX("打开失败");
                        this.qiC.b(this.qiC.qix);
                        return true;
                    case 4:
                        this.qiC.b(this.qiC.qiu);
                        AdLandingPagesProxy.getInstance().deleteDeferredDeepLink(this.qiC.qiq.bgu().uq);
                        return true;
                    default:
                        return false;
                }
            }
        }

        protected a(m mVar, String str) {
            this.qiq = mVar;
            super(str, Looper.getMainLooper());
            b(this.qiu);
            b(this.qit);
            b(this.qiv);
            b(this.qiw);
            b(this.qix);
            b(this.qiy);
            b(this.qiz);
            b(this.qiA);
            b(this.qiB);
            c(this.qiB);
            AdLandingPagesProxy.getInstance().addReportInfo(mVar.bgu().fTO, mVar.bgu().qdX, mVar.bgu().qdW);
        }

        public final void FX(String str) {
            com.tencent.mm.ui.base.g.bl(this.qiq.context, str);
        }
    }

    public m(Context context, com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b bVar, ViewGroup viewGroup) {
        super(context, bVar, viewGroup);
    }

    public final com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b bgu() {
        return (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qib;
    }

    protected final void bgl() {
        this.qik.setText(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qib).title);
        this.qim.yw(11);
    }

    @TargetApi(17)
    public final View bgf() {
        this.qhP = 0;
        View view = this.ipu;
        this.qik = (Button) view.findViewById(f.bJY);
        this.qik.setOnClickListener(this.qio);
        this.qil = (SnsTextProgressBar) view.findViewById(f.pCr);
        this.qil.setProgress(0);
        this.qil.setVisibility(8);
        this.qil.setOnClickListener(this.qio);
        this.qim.start();
        return view;
    }

    protected final int aTQ() {
        return g.pGU;
    }

    public final void bfP() {
        super.bfP();
        this.qim.yw(2);
    }

    public final void bfO() {
        super.bfO();
        if (this.qin != null) {
            this.context.unregisterReceiver(this.qin);
            this.qin = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
    }

    public final boolean bgv() {
        if (this.context == null || TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qib).fTO) || TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qib).uq)) {
            return false;
        }
        if (TextUtils.isEmpty(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qib).qfd)) {
            com.tencent.mm.bk.a.post(new Runnable(this) {
                final /* synthetic */ m qiq;

                {
                    this.qiq = r1;
                }

                public final void run() {
                    com.tencent.mm.pluginsdk.model.app.g.a(this.qiq.context, this.qiq.context.getPackageManager().getLaunchIntentForPackage(this.qiq.bgu().uq), com.tencent.mm.pluginsdk.model.app.g.m(this.qiq.context, this.qiq.bgu().fTO), new c(this) {
                        final /* synthetic */ AnonymousClass4 qis;

                        {
                            this.qis = r1;
                        }

                        public final void ex(boolean z) {
                            if (!z) {
                                ab.cQ(this.qis.qiq.context);
                            }
                        }
                    });
                }
            });
        } else {
            final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qib).qfd));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            List x = bg.x(this.context, intent);
            if (!(x == null || x.isEmpty())) {
                Object b;
                if (TextUtils.isEmpty(intent.getPackage()) && x.size() == 1) {
                    b = com.tencent.mm.pluginsdk.model.app.g.b((ResolveInfo) x.get(0));
                } else {
                    b = intent.getPackage();
                }
                if (!bg.mz(ab.getPackageName()).equals(b)) {
                    com.tencent.mm.bk.a.post(new Runnable(this) {
                        final /* synthetic */ m qiq;

                        public final void run() {
                            com.tencent.mm.pluginsdk.model.app.g.a(this.qiq.context, intent, com.tencent.mm.pluginsdk.model.app.g.m(this.qiq.context, this.qiq.bgu().fTO), new c(this) {
                                final /* synthetic */ AnonymousClass3 qir;

                                {
                                    this.qir = r1;
                                }

                                public final void ex(boolean z) {
                                    if (!z) {
                                        ab.cQ(this.qir.qiq.context);
                                    }
                                }
                            });
                        }
                    });
                }
            }
        }
        AdLandingPagesProxy.getInstance().reportDownloadInfo(9, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qib).fTO, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qib).uq, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qib).fFW, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qib).downloadUrl);
        return true;
    }

    public final void bgw() {
        w.d("MicroMsg.AdLandingPageDownloadApkBtnComp", "writing deferred deep link");
        AdLandingPagesProxy.getInstance().writeDeferredDeepLink(((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qib).uq, ((com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b) this.qib).qfd);
    }
}
