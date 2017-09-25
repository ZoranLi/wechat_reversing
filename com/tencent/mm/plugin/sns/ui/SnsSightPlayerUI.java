package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.om;
import com.tencent.mm.e.a.oq;
import com.tencent.mm.e.a.ou;
import com.tencent.mm.e.a.ov;
import com.tencent.mm.e.a.qv;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.a.a.c;
import com.tencent.mm.plugin.sns.a.a.j;
import com.tencent.mm.plugin.sns.a.a.j.e;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bdu;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.u.d;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.x;
import com.tencent.mm.y.k;
import java.io.File;

@a(3)
public class SnsSightPlayerUI extends MMActivity implements b, d.a {
    private int duration = 0;
    private String fJz = "";
    private String fKz = "";
    private alh fVV = null;
    private int fXT = 0;
    private VelocityTracker fk;
    private String hIN = "";
    private boolean hoD = false;
    private d iXd;
    private GestureDetector iXs;
    private String imagePath = "";
    private boolean isInit = false;
    Bundle klH;
    private boolean klI = false;
    g klJ;
    private int klK = 0;
    private int klL = 0;
    private int klM = 0;
    private int klN = 0;
    f kmM = null;
    public l kmS;
    private int lHi = 0;
    private TextView lKS = null;
    private boolean lKV = false;
    private ImageView lMk;
    private float mwV = 0.0f;
    n.d nxN = new n.d(this) {
        final /* synthetic */ SnsSightPlayerUI qGq;

        {
            this.qGq = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            Intent intent;
            switch (menuItem.getItemId()) {
                case 1:
                    intent = new Intent();
                    m Gg = ae.beL().Gg(this.qGq.fJz);
                    if (Gg != null) {
                        w.i("MicroMsg.SnsSightPlayerUI", "expose id " + Gg.bhe());
                    }
                    intent.putExtra("k_expose_msg_id", Gg == null ? Integer.valueOf(0) : Gg.bhe());
                    intent.putExtra("k_username", Gg == null ? "" : Gg.field_userName);
                    intent.putExtra("showShare", false);
                    intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(33)}));
                    com.tencent.mm.bb.d.b(this.qGq, "webview", ".ui.tools.WebViewUI", intent);
                    return;
                case 2:
                    m Gg2 = ae.beL().Gg(this.qGq.fJz);
                    if (Gg2 != null) {
                        cb cbVar = new cb();
                        com.tencent.mm.plugin.sns.i.a.a(cbVar, Gg2);
                        cbVar.fFA.activity = this.qGq;
                        cbVar.fFA.fFH = 17;
                        com.tencent.mm.sdk.b.a.urY.m(cbVar);
                        if (this.qGq.pQJ) {
                            k cVar = new c(Gg2.bhH(), 11, 5, "", 2);
                            h.vJ();
                            h.vH().gXC.a(cVar, 0);
                            j.a(j.d.Sight, j.c.Fav, e.Full, 0, Gg2);
                        }
                        if (this.qGq.scene == 0) {
                            com.tencent.mm.sdk.b.b oqVar = new oq();
                            oqVar.fVK.fGN = Gg2.bhy();
                            oqVar.fVK.fVJ = i.g(Gg2);
                            com.tencent.mm.sdk.b.a.urY.m(oqVar);
                            return;
                        }
                        return;
                    }
                    return;
                case 3:
                    this.qGq.qEt = true;
                    Intent intent2 = new Intent();
                    intent2.putExtra("Select_Conv_Type", 3);
                    intent2.putExtra("select_is_ret", true);
                    intent2.putExtra("mutil_select_is_ret", true);
                    intent2.putExtra("image_path", this.qGq.imagePath);
                    intent2.putExtra("Retr_Msg_Type", 11);
                    com.tencent.mm.bb.d.a(this.qGq, ".ui.transmit.SelectConversationUI", intent2, 4097);
                    return;
                case 4:
                    m Gg3 = ae.beL().Gg(this.qGq.fJz);
                    if (Gg3 != null) {
                        intent = new Intent();
                        if (Gg3.bhd().ufB.tsN == 15 && ((alh) Gg3.bhd().ufB.tsO.get(0)) == null) {
                            w.w("MicroMsg.SnsSightPlayerUI", "send sight fail, mediaObj is null");
                            return;
                        }
                        intent.putExtra("exdevice_open_scene_type", 2);
                        intent.putExtra("sns_local_id", this.qGq.fJz);
                        intent.putExtra("sns_send_data_ui_activity", true);
                        com.tencent.mm.bb.d.a(this.qGq, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private boolean pQJ = false;
    private int puA = 0;
    ViewGroup pvE;
    private int pvM = 0;
    private int pvN = 0;
    public int pvU = 0;
    private TextView pvu = null;
    private boolean pvv = false;
    private boolean qEt = false;
    private float qEv = 0.0f;
    private boolean qEw = false;
    private boolean qEx = false;
    private boolean qEy = false;
    private com.tencent.mm.plugin.sns.a.a.h qGi = new com.tencent.mm.plugin.sns.a.a.h("SnsSightPlayerUI");
    private String qGj = "";
    private TextView qGk = null;
    private MMPinProgressBtn qGl = null;
    private m qGm = null;
    private String qGn = "";
    private RelativeLayout qGo;
    OnCreateContextMenuListener qGp = new OnCreateContextMenuListener(this) {
        final /* synthetic */ SnsSightPlayerUI qGq;

        {
            this.qGq = r1;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            int i;
            if (bg.PY(com.tencent.mm.i.g.sV().getValue("SIGHTCannotTransmitForFav")) == 0) {
                w.i("MicroMsg.SnsSightPlayerUI", "config can forward sight, thumb existed %B, video existed %B", new Object[]{Boolean.valueOf(FileOp.aO(this.qGq.imagePath)), Boolean.valueOf(FileOp.aO(this.qGq.hIN))});
                if (FileOp.aO(this.qGq.imagePath) && r3) {
                    contextMenu.add(0, 3, 0, this.qGq.getString(com.tencent.mm.plugin.sns.i.j.pKn));
                    i = 1;
                    if (com.tencent.mm.bb.d.Jt("favorite")) {
                        contextMenu.add(0, 2, 0, this.qGq.getString(com.tencent.mm.plugin.sns.i.j.eGa));
                    }
                    if (i != 0) {
                        com.tencent.mm.sdk.b.b ddVar;
                        ddVar = new dd();
                        ddVar.fGW.fGN = this.qGq.fJz;
                        com.tencent.mm.sdk.b.a.urY.m(ddVar);
                        if (ddVar.fGX.fGu) {
                            contextMenu.add(0, 4, 0, this.qGq.getString(com.tencent.mm.plugin.sns.i.j.pJF));
                        }
                    }
                    if (!this.qGq.pQJ) {
                        contextMenu.add(0, 1, 0, this.qGq.uSU.uTo.getString(com.tencent.mm.plugin.sns.i.j.pMH));
                    }
                }
            }
            i = 0;
            if (com.tencent.mm.bb.d.Jt("favorite")) {
                contextMenu.add(0, 2, 0, this.qGq.getString(com.tencent.mm.plugin.sns.i.j.eGa));
            }
            if (i != 0) {
                ddVar = new dd();
                ddVar.fGW.fGN = this.qGq.fJz;
                com.tencent.mm.sdk.b.a.urY.m(ddVar);
                if (ddVar.fGX.fGu) {
                    contextMenu.add(0, 4, 0, this.qGq.getString(com.tencent.mm.plugin.sns.i.j.pJF));
                }
            }
            if (!this.qGq.pQJ) {
                contextMenu.add(0, 1, 0, this.qGq.uSU.uTo.getString(com.tencent.mm.plugin.sns.i.j.pMH));
            }
        }
    };
    private float qzl = 1.0f;
    private int qzm = 0;
    private int qzn = 0;
    private int scene = 0;

    public void onCreate(Bundle bundle) {
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        this.scene = getIntent().getIntExtra("intent_from_scene", -1);
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        this.uSU.bQg();
        ae.beG().a(this);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(getResources().getColor(com.tencent.mm.plugin.sns.i.c.black));
        }
        if (com.tencent.mm.compatible.util.d.eo(19)) {
            getWindow().setFlags(201327616, 201327616);
        } else {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.klH = bundle;
        this.iXd = new d();
        this.hIN = getIntent().getStringExtra("intent_videopath");
        this.imagePath = getIntent().getStringExtra("intent_thumbpath");
        this.fJz = getIntent().getStringExtra("intent_localid");
        this.pQJ = getIntent().getBooleanExtra("intent_isad", false);
        this.qGm = ae.beL().Gg(this.fJz);
        if (this.pQJ) {
            boolean z;
            if (this.qGm == null) {
                z = false;
            } else {
                this.fVV = (alh) this.qGm.bhd().ufB.tsO.get(0);
                String du = am.du(ae.getAccSnsPath(), this.fVV.mQY);
                this.qGn = du + i.k(this.fVV);
                this.fKz = du + i.e(this.fVV);
                z = true;
            }
            if (!z) {
                finish();
                return;
            }
        }
        if (com.tencent.mm.n.a.oH() != null) {
            com.tencent.mm.n.a.oH().pS();
        }
        this.qGi.pPs = bg.NA();
        this.qGo = (RelativeLayout) findViewById(com.tencent.mm.plugin.sns.i.f.bGC);
        this.qGo.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SnsSightPlayerUI qGq;

            {
                this.qGq = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.qGq.ahz();
                return true;
            }
        });
        w.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.g.sc() + " initView: fullpath:" + this.hIN + ", imagepath:" + this.imagePath);
        this.klJ = new g(this.uSU.uTo);
        this.lMk = (ImageView) findViewById(com.tencent.mm.plugin.sns.i.f.bSt);
        this.lMk.setLayerType(2, null);
        this.pvu = (TextView) findViewById(com.tencent.mm.plugin.sns.i.f.cIS);
        this.qGl = (MMPinProgressBtn) findViewById(com.tencent.mm.plugin.sns.i.f.cFo);
        this.pvE = (ViewGroup) findViewById(com.tencent.mm.plugin.sns.i.f.cLG);
        this.kmM = com.tencent.mm.pluginsdk.ui.tools.n.dG(this.uSU.uTo);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.lKS = (TextView) findViewById(com.tencent.mm.plugin.sns.i.f.cFd);
        this.pvE.addView((View) this.kmM, 0, layoutParams);
        this.qGk = (TextView) findViewById(com.tencent.mm.plugin.sns.i.f.pGf);
        this.qGk.setText("");
        if (!this.pQJ) {
            this.qGk.setVisibility(8);
        }
        if (this.pQJ) {
            if (this.fVV == null) {
                this.lKS.setVisibility(8);
            } else if (bg.mA(this.fVV.tPp)) {
                w.i("MicroMsg.SnsSightPlayerUI", "onCreate: there is no attachurl, show more info btn");
                final bfc bhd = this.qGm.bhd();
                com.tencent.mm.plugin.sns.storage.b bha = this.qGm.bha();
                CharSequence charSequence = bha.qeg;
                final String str = bha.qeh;
                if (bg.mA(charSequence) || bg.mA(str)) {
                    this.lKS.setVisibility(8);
                } else {
                    this.lKS.setVisibility(0);
                    this.lKS.setText(charSequence);
                    this.lKS.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ SnsSightPlayerUI qGq;

                        public final void onClick(View view) {
                            if (j.b.Sight.value != 0) {
                                j.a(j.a.DetailInVideo, bhd.mQY, this.qGq.qGm.bhc() == null ? "" : this.qGq.qGm.bhc().pZI, 1, j.b.Sight.value, bhd.jNj, null, bhd.mQY, 0, 0, 0);
                            }
                            final Intent intent = new Intent();
                            Bundle bundle = new Bundle();
                            bundle.putString("key_snsad_statextstr", bhd.qui);
                            intent.putExtra("jsapiargs", bundle);
                            intent.putExtra("rawUrl", str);
                            intent.putExtra("useJs", true);
                            k cVar = new c(this.qGq.qGm.bhH(), 18, 5, "", 2);
                            h.vJ();
                            h.vH().gXC.a(cVar, 0);
                            new com.tencent.mm.sdk.platformtools.ae(Looper.getMainLooper()).post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass7 qGt;

                                public final void run() {
                                    com.tencent.mm.plugin.sns.c.a.imv.j(intent, this.qGt.qGq);
                                    this.qGt.qGq.finish();
                                }
                            });
                        }
                    });
                }
            } else {
                du = getResources().getString(com.tencent.mm.plugin.sns.i.j.eWK);
                if (this.fVV.qLq / 60 > 0) {
                    du = du + getResources().getString(com.tencent.mm.plugin.sns.i.j.eWM, new Object[]{Integer.valueOf(this.fVV.qLq / 60)});
                }
                if (this.fVV.qLq % 60 > 0) {
                    du = du + getResources().getString(com.tencent.mm.plugin.sns.i.j.eWN, new Object[]{Integer.valueOf(this.fVV.qLq % 60)});
                }
                this.lKS.setText(du + getResources().getString(com.tencent.mm.plugin.sns.i.j.eWL));
                this.lKS.setVisibility(0);
                this.lKS.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ SnsSightPlayerUI qGq;

                    {
                        this.qGq = r1;
                    }

                    public final void onClick(View view) {
                        com.tencent.mm.modelsns.b gz;
                        if (this.qGq.qGm.tE(32)) {
                            j.a(j.b.Sight, j.a.EnterCompleteVideo, this.qGq.qGm);
                        }
                        Intent intent = new Intent();
                        String du = am.du(ae.getAccSnsPath(), this.qGq.fVV.mQY);
                        String k = i.k(this.qGq.fVV);
                        intent.setClass(this.qGq, VideoAdPlayerUI.class);
                        intent.putExtra("KFullVideoPath", du + k);
                        intent.putExtra("KThumbPath", this.qGq.imagePath);
                        intent.putExtra("IsAd", true);
                        intent.putExtra("KStremVideoUrl", this.qGq.fVV.tPp);
                        intent.putExtra("KThumUrl", bg.mA(this.qGq.fVV.tPs) ? this.qGq.fVV.tPi : this.qGq.fVV.tPs);
                        intent.putExtra("KMediaId", this.qGq.fVV.mQY);
                        intent.putExtra("KUrl", this.qGq.fVV.msN);
                        intent.putExtra("KViewId", this.qGq.qGm.bhH());
                        bfc bhd = this.qGq.qGm.bhd();
                        String str = "KSta_StremVideoAduxInfo";
                        if (this.qGq.qGm.bhc() == null) {
                            du = "";
                        } else {
                            du = this.qGq.qGm.bhc().pZI;
                        }
                        intent.putExtra(str, du);
                        intent.putExtra("KSta_StremVideoPublishId", bhd.mQY);
                        intent.putExtra("KSta_SourceType", 1);
                        intent.putExtra("KSta_Scene", j.b.Sight.value);
                        intent.putExtra("KSta_FromUserName", bhd.jNj);
                        intent.putExtra("KSta_SnSId", bhd.mQY);
                        intent.putExtra("KSta_SnsStatExtStr", bhd.qui);
                        intent.putExtra("KMediaVideoTime", this.qGq.fVV.qLq);
                        if (bg.mA(this.qGq.fVV.tPt)) {
                            du = bhd.ufy;
                        } else {
                            du = this.qGq.fVV.tPt;
                        }
                        intent.putExtra("KMediaTitle", du);
                        com.tencent.mm.plugin.sns.storage.b bha = this.qGq.qGm.bha();
                        if (bha != null && bha.qef == 0) {
                            intent.putExtra("StreamWording", bha.qeg);
                            intent.putExtra("StremWebUrl", bha.qeh);
                        }
                        m Gg = ae.beL().Gg(this.qGq.fJz);
                        if (this.qGq.scene == 0) {
                            gz = com.tencent.mm.modelsns.b.gz(747);
                        } else {
                            gz = com.tencent.mm.modelsns.b.gA(747);
                        }
                        gz.kG(i.g(Gg)).gC(Gg.field_type).bp(true).kG(Gg.bhI()).gC(this.qGq.fVV.qLq);
                        gz.JE();
                        if (this.qGq.scene == 0) {
                            gz = com.tencent.mm.modelsns.b.gz(748);
                        } else {
                            gz = com.tencent.mm.modelsns.b.gA(748);
                        }
                        gz.kG(i.g(Gg)).gC(Gg.field_type).bp(true).kG(Gg.bhI()).gC(this.qGq.fVV.qLq);
                        gz.b(intent, "intent_key_StatisticsOplog");
                        this.qGq.startActivity(intent);
                        k cVar = new c(this.qGq.qGm.bhH(), 14, 5, "", 2);
                        h.vJ();
                        h.vH().gXC.a(cVar, 0);
                        if (this.qGq.scene == 0) {
                            com.tencent.mm.sdk.b.b omVar = new om();
                            omVar.fVG.fOV = true;
                            com.tencent.mm.sdk.b.a.urY.m(omVar);
                        }
                    }
                });
            }
            com.tencent.mm.pluginsdk.ui.tools.m.a(this.lKS, (VideoSightView) this.kmM);
        } else {
            this.lKS.setVisibility(8);
        }
        this.kmM.a(new f.a(this) {
            final /* synthetic */ SnsSightPlayerUI qGq;

            {
                this.qGq = r1;
            }

            public final void Uc() {
                w.d("MicroMsg.SnsSightPlayerUI", com.tencent.mm.compatible.util.g.sc() + " onPrepared");
                this.qGq.hd(true);
            }

            public final void onError(int i, int i2) {
                w.e("MicroMsg.SnsSightPlayerUI", "on play video error, what %d extra %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                this.qGq.kmM.stop();
                if (!this.qGq.lKV) {
                    this.qGq.lKV = true;
                    com.tencent.mm.sdk.a.b.r(Base64.encodeToString((com.tencent.mm.plugin.sight.base.d.bbQ() + "[SnsSightPlayerUI] on play video error, what " + i + " extra " + i2 + ", path=" + bg.ap(this.qGq.imagePath, "")).getBytes(), 2), "FullScreenPlaySight");
                    final String c = this.qGq.imagePath;
                    final Bitmap a = com.tencent.mm.ah.n.GS().a(c, com.tencent.mm.bg.a.getDensity(this.qGq.uSU.uTo), this.qGq.uSU.uTo, -1);
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass9 qGu;

                        public final void run() {
                            ImageView imageView = (ImageView) this.qGu.qGq.findViewById(com.tencent.mm.plugin.sns.i.f.cMr);
                            if (imageView != null) {
                                imageView.setImageBitmap(a);
                                imageView.setVisibility(0);
                            }
                            Intent intent = new Intent();
                            intent.setAction("android.intent.action.VIEW");
                            intent.setDataAndType(Uri.fromFile(new File(c)), "video/*");
                            try {
                                this.qGu.qGq.uSU.uTo.startActivity(Intent.createChooser(intent, this.qGu.qGq.uSU.uTo.getString(com.tencent.mm.plugin.sns.i.j.ejL)));
                            } catch (Exception e) {
                                w.e("MicroMsg.SnsSightPlayerUI", "startActivity fail, activity not found");
                                com.tencent.mm.ui.base.g.h(this.qGu.qGq.uSU.uTo, com.tencent.mm.plugin.sns.i.j.eiL, com.tencent.mm.plugin.sns.i.j.eiM);
                            }
                        }
                    });
                }
            }

            public final void oW() {
                w.d("MicroMsg.SnsSightPlayerUI", "on completion");
                if (!this.qGq.pQJ) {
                    this.qGq.pvu.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass9 qGu;

                        {
                            this.qGu = r1;
                        }

                        public final void run() {
                            if (this.qGu.qGq.pvu.getVisibility() != 0) {
                                this.qGu.qGq.pvu.setVisibility(0);
                                this.qGu.qGq.pvu.startAnimation(AnimationUtils.loadAnimation(this.qGu.qGq.uSU.uTo, com.tencent.mm.plugin.sns.i.a.aQX));
                            }
                        }
                    });
                }
                this.qGq.kmM.bN(true);
                com.tencent.mm.plugin.sns.a.a.a.a aVar = this.qGq.qGi.pPx;
                aVar.pQt++;
                this.qGq.hd(false);
            }

            public final int bI(int i, int i2) {
                return 0;
            }

            public final void bp(int i, int i2) {
            }
        });
        findViewById(com.tencent.mm.plugin.sns.i.f.cLG).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsSightPlayerUI qGq;

            {
                this.qGq = r1;
            }

            public final void onClick(View view) {
                this.qGq.ahz();
            }
        });
        ((View) this.kmM).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SnsSightPlayerUI qGq;

            {
                this.qGq = r1;
            }

            public final void onClick(View view) {
                this.qGq.ahz();
            }
        });
        this.iXs = new GestureDetector(this.uSU.uTo, new SimpleOnGestureListener(this) {
            final /* synthetic */ SnsSightPlayerUI qGq;

            {
                this.qGq = r1;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                float translationX = (((View) this.qGq.kmM).getTranslationX() + motionEvent2.getX()) - motionEvent.getX();
                float translationY = (((View) this.qGq.kmM).getTranslationY() + motionEvent2.getY()) - motionEvent.getY();
                if (this.qGq.qEw) {
                    ((View) this.qGq.kmM).setTranslationX(translationX);
                    ((View) this.qGq.kmM).setTranslationY(translationY);
                }
                return true;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                this.qGq.qEy = true;
                super.onLongPress(motionEvent);
            }
        });
        ((View) this.kmM).setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SnsSightPlayerUI qGq;

            {
                this.qGq = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                float f = 1.0f;
                this.qGq.iXs.onTouchEvent(motionEvent);
                if (this.qGq.fk == null) {
                    this.qGq.fk = VelocityTracker.obtain();
                }
                this.qGq.fk.addMovement(motionEvent);
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        this.qGq.mwV = motionEvent.getX();
                        this.qGq.qEv = motionEvent.getY();
                        break;
                    case 1:
                        if (this.qGq.qEx) {
                            ((View) this.qGq.kmM).setPivotX((float) (this.qGq.pvE.getWidth() / 2));
                            ((View) this.qGq.kmM).setPivotY((float) (this.qGq.pvE.getHeight() / 2));
                            ((View) this.qGq.kmM).setScaleX(1.0f);
                            ((View) this.qGq.kmM).setScaleY(1.0f);
                            ((View) this.qGq.kmM).setTranslationX(0.0f);
                            ((View) this.qGq.kmM).setTranslationY(0.0f);
                            MMActivity mMActivity = this.qGq;
                            if (mMActivity.kmS == null) {
                                mMActivity.kmS = new l(mMActivity.uSU.uTo);
                            }
                            mMActivity.kmS.a((View) mMActivity.kmM, mMActivity.qGp, mMActivity.nxN);
                            if (this.qGq.lKS != null) {
                                this.qGq.lKS.setVisibility(0);
                            }
                            this.qGq.qEw = false;
                            this.qGq.qEy = false;
                            break;
                        } else if (!this.qGq.qEw || this.qGq.qEy) {
                            this.qGq.qEy = false;
                            break;
                        } else {
                            this.qGq.ahz();
                            this.qGq.qEy = false;
                            return true;
                        }
                        break;
                    case 2:
                        float translationX = ((View) this.qGq.kmM).getTranslationX();
                        float translationY = ((View) this.qGq.kmM).getTranslationY();
                        VelocityTracker n = this.qGq.fk;
                        n.computeCurrentVelocity(1000);
                        int xVelocity = (int) n.getXVelocity();
                        int yVelocity = (int) n.getYVelocity();
                        if ((Math.abs(translationX) > 250.0f || Math.abs(yVelocity) <= Math.abs(xVelocity) || yVelocity <= 0 || this.qGq.qEy) && !this.qGq.qEw) {
                            this.qGq.qEw = false;
                        } else {
                            float height = 1.0f - (translationY / ((float) this.qGq.pvE.getHeight()));
                            if (height <= 1.0f) {
                                f = height;
                            }
                            if (((yVelocity > 0 && f < this.qGq.qzl) || yVelocity < 0) && ((double) f) >= 0.5d) {
                                this.qGq.qzm = (int) translationX;
                                this.qGq.qzn = (int) translationY;
                                this.qGq.qzl = f;
                                if (this.qGq.lKS != null) {
                                    this.qGq.lKS.setVisibility(8);
                                }
                                ((View) this.qGq.kmM).setPivotX((float) (this.qGq.pvE.getWidth() / 2));
                                ((View) this.qGq.kmM).setPivotY((float) (this.qGq.pvE.getHeight() / 2));
                                ((View) this.qGq.kmM).setScaleX(f);
                                ((View) this.qGq.kmM).setScaleY(f);
                                this.qGq.lMk.setAlpha(f);
                            }
                            this.qGq.qEw = true;
                        }
                        if (translationY > 200.0f) {
                            this.qGq.qEx = false;
                        } else if (translationY > 10.0f) {
                            this.qGq.qEx = true;
                        }
                        if (translationY > 50.0f) {
                            ((View) this.qGq.kmM).setOnLongClickListener(null);
                        }
                        if (this.qGq.fk != null) {
                            this.qGq.fk.recycle();
                            this.qGq.fk = null;
                        }
                        if (this.qGq.qEw) {
                            return true;
                        }
                        break;
                }
                return false;
            }
        });
        if (FileOp.aO(this.hIN)) {
            if (this.hIN != null) {
                this.kmM.stop();
                this.kmM.setVideoPath(this.hIN);
            }
            this.qGl.setVisibility(8);
            this.qGi.pPq = 1;
        } else {
            ae.beG().a(this.fVV, 6, null, an.uJM);
            this.qGl.setVisibility(0);
            this.qGl.caB();
            this.qGi.pPq = 0;
        }
        w.d("MicroMsg.SnsSightPlayerUI", (System.currentTimeMillis() - currentTimeMillis) + " initView end");
        com.tencent.mm.sdk.b.b qvVar = new qv();
        qvVar.fXQ.type = 1;
        com.tencent.mm.sdk.b.a.urY.m(qvVar);
        if (this.kmS == null) {
            this.kmS = new l(this.uSU.uTo);
        }
        this.kmS.a((View) this.kmM, this.qGp, this.nxN);
        ((View) this.kmM).post(new Runnable(this) {
            final /* synthetic */ SnsSightPlayerUI qGq;

            {
                this.qGq = r1;
            }

            public final void run() {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                this.qGq.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                if (this.qGq.kmM instanceof VideoSightView) {
                    ((VideoSightView) this.qGq.kmM).sF(displayMetrics.widthPixels);
                }
                ((View) this.qGq.kmM).requestLayout();
                ((View) this.qGq.kmM).postInvalidate();
            }
        });
    }

    public void finish() {
        if (!this.hoD) {
            super.finish();
            this.hoD = true;
        }
    }

    private void hd(boolean z) {
        this.kmM.start();
        this.duration = this.kmM.getDuration();
        w.i("MicroMsg.SnsSightPlayerUI", "startplay get duration " + this.duration);
        this.iXd.a(this);
        if (z) {
            this.qGi.pPx.pQx = getResources().getConfiguration().orientation == 2 ? 2 : 1;
            this.qGi.pPx.pQy = bg.NA();
            this.qGi.pPx.pQw = 2;
        }
    }

    private void bgC() {
        w.i("MicroMsg.SnsSightPlayerUI", "snsSightplayui pauseplay");
        this.kmM.pause();
        this.kmM.onDetach();
        this.iXd.aS(false);
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.sns.i.g.pHZ;
    }

    public void onDestroy() {
        boolean z = true;
        super.onDestroy();
        if (this.pQJ) {
            String bhH = this.qGm.bhH();
            String bdp = this.qGi.bdp();
            h.vJ();
            h.vH().gXC.a(new com.tencent.mm.plugin.sns.a.a.d(bhH, this.scene == 0 ? 1 : 2, 2, this.qGi.pPr, null, null, 2, bdp, -1), 0);
        }
        w.d("MicroMsg.SnsSightPlayerUI", "on dismiss");
        if (this.pQJ && this.qGm != null && this.qGm.tE(32)) {
            j.a(j.b.Sight, j.a.LeavelFullScreen, this.qGm);
        }
        ae.beG().b(this);
        com.tencent.mm.modelsns.b o = com.tencent.mm.modelsns.b.o(getIntent());
        if (o != null) {
            if (this.pQJ) {
                if (bg.mA(this.fVV.tPp)) {
                    z = false;
                }
                o.bp(z);
            } else {
                o.bp(false);
            }
            o.update();
            o.JE();
        }
        if (com.tencent.mm.n.a.oH() != null) {
            com.tencent.mm.n.a.oH().pR();
        }
        if (this.kmM != null) {
            this.kmM.a(null);
            this.kmM.stop();
            this.kmM.onDetach();
        }
        if (!this.pvv) {
            com.tencent.mm.sdk.b.b qvVar = new qv();
            qvVar.fXQ.type = 0;
            qvVar.fXQ.fXR = this.puA;
            qvVar.fXQ.fXS = this.lHi;
            qvVar.fXQ.fXT = this.fXT;
            com.tencent.mm.sdk.b.a.urY.m(qvVar);
        }
        this.iXd.aS(false);
    }

    public void onStart() {
        Bundle bundle = this.klH;
        if (!this.klI) {
            this.klI = true;
            if (VERSION.SDK_INT >= 12) {
                this.klK = getIntent().getIntExtra("img_gallery_top", 0);
                this.klL = getIntent().getIntExtra("img_gallery_left", 0);
                this.klM = getIntent().getIntExtra("img_gallery_width", 0);
                this.klN = getIntent().getIntExtra("img_gallery_height", 0);
                this.klJ.p(this.klL, this.klK, this.klM, this.klN);
                if (bundle == null) {
                    this.pvE.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener(this) {
                        final /* synthetic */ SnsSightPlayerUI qGq;

                        {
                            this.qGq = r1;
                        }

                        public final boolean onPreDraw() {
                            this.qGq.pvE.getViewTreeObserver().removeOnPreDrawListener(this);
                            this.qGq.klJ.a(this.qGq.pvE, this.qGq.lMk, null);
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
        if (!this.isInit) {
            w.i("MicroMsg.SnsSightPlayerUI", "initOrientation " + getResources().getConfiguration().orientation);
            if (getResources().getConfiguration().orientation == 2) {
                T(getResources().getConfiguration().orientation, true);
            }
            this.isInit = true;
        }
        if (this.pvN == 0 || this.pvM == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.pvN = displayMetrics.heightPixels;
            this.pvM = displayMetrics.widthPixels;
        }
        if (this.qEt && FileOp.aO(this.hIN)) {
            hd(false);
            this.qEt = false;
        }
    }

    public void onPause() {
        super.onPause();
        int i = getResources().getConfiguration().orientation;
        w.i("MicroMsg.SnsSightPlayerUI", "onpause  " + i);
        ud(i);
        if (this.qEt) {
            bgC();
            return;
        }
        bgC();
        w.v("check", "onclick");
        new com.tencent.mm.sdk.platformtools.ae().post(new Runnable(this) {
            final /* synthetic */ SnsSightPlayerUI qGq;

            {
                this.qGq = r1;
            }

            public final void run() {
                this.qGq.finish();
            }
        });
    }

    public final void ahz() {
        int width = this.pvE.getWidth();
        int height = this.pvE.getHeight();
        if (!(this.klM == 0 || this.klN == 0)) {
            height = (int) ((((float) width) / ((float) this.klM)) * ((float) this.klN));
        }
        this.klJ.ek(width, height);
        this.klJ.p(this.klL, this.klK, this.klM, this.klN);
        if (((double) this.qzl) != 1.0d) {
            width = x.eE(this.uSU.uTo);
            this.klJ.wmy = 1.0f / this.qzl;
            if (!(this.qzm == 0 && this.qzn == 0)) {
                this.klJ.el(((int) (((float) (this.pvE.getWidth() / 2)) * (1.0f - this.qzl))) + this.qzm, (int) ((((float) ((width + this.pvE.getHeight()) / 2)) - (((float) (height / 2)) * this.qzl)) + ((float) this.qzn)));
            }
        }
        this.klJ.a(this.pvE, this.lMk, new g.b(this) {
            final /* synthetic */ SnsSightPlayerUI qGq;

            {
                this.qGq = r1;
            }

            public final void onAnimationStart() {
                if (this.qGq.lKS != null) {
                    this.qGq.lKS.setVisibility(8);
                }
            }

            public final void onAnimationEnd() {
                new com.tencent.mm.sdk.platformtools.ae().post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 qGr;

                    {
                        this.qGr = r1;
                    }

                    public final void run() {
                        this.qGr.qGq.finish();
                        this.qGr.qGq.overridePendingTransition(0, 0);
                    }
                });
            }
        }, null);
    }

    public void onBackPressed() {
        ahz();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (4097 == i) {
            if (-1 == i2) {
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                for (String str : bg.f(stringExtra.split(","))) {
                    if (this.scene == 0) {
                        m Gg = ae.beL().Gg(this.fJz);
                        if (Gg != null) {
                            com.tencent.mm.sdk.b.b ouVar;
                            if (o.dH(str)) {
                                ouVar = new ou();
                                ouVar.fVO.fVJ = i.g(Gg);
                                ouVar.fVO.fGN = Gg.bhy();
                                com.tencent.mm.sdk.b.a.urY.m(ouVar);
                            } else {
                                ouVar = new ov();
                                ouVar.fVP.fVJ = i.g(Gg);
                                ouVar.fVP.fGN = Gg.bhy();
                                com.tencent.mm.sdk.b.a.urY.m(ouVar);
                            }
                        }
                    }
                    bfc bhd = this.qGm.bhd();
                    if (this.pQJ) {
                        com.tencent.mm.plugin.sns.storage.b bha = this.qGm.bha();
                        bdu com_tencent_mm_protocal_c_bdu = new bdu();
                        com_tencent_mm_protocal_c_bdu.tyZ = this.fVV.qLq;
                        com_tencent_mm_protocal_c_bdu.hjD = this.fVV.tPp;
                        if (bhd.ufB.tsN == 15) {
                            com_tencent_mm_protocal_c_bdu.hjJ = this.qGm.bhc().pZI;
                            com_tencent_mm_protocal_c_bdu.hjK = bhd.mQY;
                        } else {
                            com_tencent_mm_protocal_c_bdu.hjJ = bhd.ufG.hjJ;
                            com_tencent_mm_protocal_c_bdu.hjK = bhd.ufG.hjK;
                        }
                        com_tencent_mm_protocal_c_bdu.hjF = bg.mA(this.fVV.tPt) ? bhd.ufy : this.fVV.tPt;
                        if (bg.mA(this.fVV.tPs)) {
                            stringExtra = this.fVV.tPi;
                        } else {
                            stringExtra = this.fVV.tPs;
                        }
                        com_tencent_mm_protocal_c_bdu.hjI = stringExtra;
                        if (bha != null && bha.qef == 0) {
                            com_tencent_mm_protocal_c_bdu.hjH = bha.qeh;
                            com_tencent_mm_protocal_c_bdu.hjG = bha.qeg;
                        }
                        com_tencent_mm_protocal_c_bdu.hjH = bha.qdM;
                        w.i("MicroMsg.SnsSightPlayerUI", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d streamvideothumburl %s, duration: %s", new Object[]{str, this.hIN, this.imagePath, this.fVV.tPp, Integer.valueOf(this.fVV.qLq), com_tencent_mm_protocal_c_bdu.hjI, Integer.valueOf(i.ER(this.hIN))});
                        com.tencent.mm.plugin.messenger.a.d.aJW().a(this, str, this.hIN, this.imagePath, 43, r7, com_tencent_mm_protocal_c_bdu, false, false, bhd.qui);
                    } else {
                        w.i("MicroMsg.SnsSightPlayerUI", "send sight to %s, videopath %s, thumbpath %s, duration: %s", new Object[]{str, this.hIN, this.imagePath, Integer.valueOf(i.ER(this.hIN))});
                        com.tencent.mm.plugin.messenger.a.d.aJW().a(this, str, this.hIN, this.imagePath, 43, r7, bhd.qui);
                    }
                    if (stringExtra2 != null) {
                        com.tencent.mm.plugin.messenger.a.d.aJW().cM(stringExtra2, str);
                    }
                    com.tencent.mm.ui.snackbar.a.e(this, getString(com.tencent.mm.plugin.sns.i.j.esl));
                    if (this.pQJ) {
                        j.c cVar;
                        int eC;
                        k cVar2 = new c(this.qGm.bhH(), 12, 5, "", 2);
                        h.vJ();
                        h.vH().gXC.a(cVar2, 0);
                        boolean dH = o.dH(str);
                        j.d dVar = j.d.Sight;
                        if (dH) {
                            cVar = j.c.Chatroom;
                        } else {
                            cVar = j.c.Chat;
                        }
                        e eVar = e.Full;
                        if (dH) {
                            eC = com.tencent.mm.u.j.eC(str);
                        } else {
                            eC = 0;
                        }
                        j.a(dVar, cVar, eVar, eC, this.qGm);
                    }
                }
            } else if (this.pQJ) {
                k cVar3 = new c(this.qGm.bhH(), 13, 5, "", 2);
                h.vJ();
                h.vH().gXC.a(cVar3, 0);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void ES(String str) {
    }

    public final void ao(String str, boolean z) {
    }

    public final void bdD() {
    }

    public final void ap(String str, boolean z) {
        w.i("MicroMsg.SnsSightPlayerUI", "onSightFinish " + str);
        if (this.pQJ && !bg.mA(str) && this.fVV != null && str.equals(this.fVV.mQY) && FileOp.aO(this.hIN)) {
            this.qGi.pPq = 1;
            this.kmM.setVideoPath(this.hIN);
            hd(true);
            if (this.qGl != null) {
                this.qGl.setVisibility(8);
            }
        }
    }

    protected final int Ol() {
        return 7;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        w.i("MicroMsg.SnsSightPlayerUI", "onConfigurationChanged " + configuration.orientation + " " + this.pvU);
        if (this.pvU != configuration.orientation) {
            int i = configuration.orientation;
            T(configuration.orientation, false);
            this.pvU = configuration.orientation;
        }
    }

    private void T(int i, boolean z) {
        if (this.pvN == 0 || this.pvM == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.pvN = displayMetrics.heightPixels;
            this.pvM = displayMetrics.widthPixels;
        }
        LayoutParams layoutParams = this.pvE.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.qGk.getLayoutParams();
        LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        if (i == 1) {
            layoutParams3.width = this.pvM;
            layoutParams3.height = (int) (((((double) this.pvM) * 1.0d) * 240.0d) / 320.0d);
            layoutParams2.addRule(12, 0);
            layoutParams2.addRule(1, 0);
            layoutParams2.addRule(11, -1);
            layoutParams2.addRule(3, this.pvE.getId());
            findViewById(com.tencent.mm.plugin.sns.i.f.cIS).setVisibility(0);
        } else {
            layoutParams3.height = this.pvM;
            layoutParams3.width = (int) (((((double) this.pvM) * 1.0d) * 320.0d) / 240.0d);
            layoutParams2.addRule(11, 0);
            layoutParams2.addRule(3, 0);
            layoutParams2.addRule(12, -1);
            layoutParams2.addRule(1, this.pvE.getId());
            findViewById(com.tencent.mm.plugin.sns.i.f.cIS).setVisibility(8);
        }
        w.i("MicroMsg.SnsSightPlayerUI", "orientation " + i + " " + layoutParams3.width + " " + layoutParams3.height);
        ((View) this.kmM).setLayoutParams(layoutParams3);
        if (this.kmM instanceof com.tencent.mm.plugin.sight.decode.a.a) {
            ((com.tencent.mm.plugin.sight.decode.a.a) this.kmM).cR(layoutParams3.width, layoutParams3.height);
        }
        layoutParams.height = layoutParams3.height;
        layoutParams.width = layoutParams3.width;
        this.pvu.setLayoutParams(layoutParams2);
        this.pvE.setLayoutParams(layoutParams);
        ((View) this.kmM).requestLayout();
        if (!z) {
            ud(i);
        }
    }

    private void ud(int i) {
        if (this.pQJ && this.kmM.isPlaying()) {
            if (this.duration == 0) {
                this.duration = this.kmM.getDuration();
            }
            this.qGi.sM(this.duration);
            this.qGi.pPx.pQy = bg.NA();
            this.qGi.pPx.pQx = i == 2 ? 2 : 1;
            this.qGi.pPx.pQw = 2;
            w.i("MicroMsg.SnsSightPlayerUI", "duration " + this.duration + " orient " + this.qGi.pPx.pQx);
        }
    }
}
