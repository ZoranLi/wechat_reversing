package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.e.a.ok;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.ajp;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bcs;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.QImageView;
import java.util.LinkedList;
import java.util.List;

public final class ac implements y {
    private String appId;
    private String appName;
    String desc = "";
    public MMActivity fCi;
    public String fFW = "";
    private boolean fGu = false;
    public String fKz = "";
    public String fVB = "";
    String hhy;
    private String iCS;
    public ProgressDialog isv = null;
    private View jIM = null;
    String mLO;
    private int qqL;
    private b qqR = null;
    private boolean qsD = false;
    private boolean qul = false;
    private boolean qum = false;
    private WXMediaMessage qun = null;
    SightPlayImageView qvb;
    public boolean qvc = false;
    private Bitmap qvd = null;
    private aks qve = new aks();
    private c qvf = new c<ok>(this) {
        final /* synthetic */ ac qvk;

        {
            this.qvk = r2;
            this.usg = ok.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ok okVar = (ok) bVar;
            w.i("MicroMsg.SightWidget", "on sight send result callback, type %d", new Object[]{Integer.valueOf(okVar.fVy.type)});
            switch (okVar.fVy.type) {
                case 1:
                    w.i("MicroMsg.SightWidget", "come event done");
                    this.qvk.fVB = okVar.fVy.fVB;
                    this.qvk.fFW = okVar.fVy.fVC;
                    if (this.qvk.isv != null) {
                        this.qvk.isv.dismiss();
                    }
                    if (okVar.fVy.fVA && this.qvk.qvg != null) {
                        this.qvk.bjh();
                    }
                    w.i("MicroMsg.SightWidget", "mux finish %B videoPath %s %d md5 %s", new Object[]{Boolean.valueOf(okVar.fVy.fVA), okVar.fVy.fVB, Long.valueOf(FileOp.ki(okVar.fVy.fVB)), this.qvk.fFW});
                    break;
            }
            return false;
        }
    };
    aw qvg = null;
    private int qvh = 0;
    public Runnable qvi = new Runnable(this) {
        final /* synthetic */ ac qvk;

        {
            this.qvk = r1;
        }

        public final void run() {
            this.qvk.bjh();
        }
    };
    public Runnable qvj = new Runnable(this) {
        final /* synthetic */ ac qvk;

        {
            this.qvk = r1;
        }

        public final void run() {
            w.i("MicroMsg.SightWidget", "showProgress");
            ac acVar = this.qvk;
            Context context = this.qvk.fCi;
            this.qvk.fCi.getString(j.dIO);
            acVar.isv = g.a(context, this.qvk.fCi.getString(j.pMr), false, new OnCancelListener(this) {
                final /* synthetic */ AnonymousClass5 qvl;

                {
                    this.qvl = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.qvl.qvk.qvg = null;
                    this.qvl.qvk.qvc = false;
                    af.I(this.qvl.qvk.qvi);
                }
            });
        }
    };

    public ac(MMActivity mMActivity) {
        this.fCi = mMActivity;
    }

    public final void C(Bundle bundle) {
        this.qqR = b.o(this.fCi.getIntent());
        this.mLO = bg.ap(this.fCi.getIntent().getStringExtra("KSightCdnUrl"), "");
        this.hhy = bg.ap(this.fCi.getIntent().getStringExtra("KSightCdnThumbUrl"), "");
        this.appId = bg.ap(this.fCi.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bg.ap(this.fCi.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.qul = this.fCi.getIntent().getBooleanExtra("KThrid_app", false);
        this.qum = this.fCi.getIntent().getBooleanExtra("KSnsAction", false);
        this.qsD = this.fCi.getIntent().getBooleanExtra("Kis_take_photo", false);
        this.qqL = this.fCi.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.iCS = bg.ap(this.fCi.getIntent().getStringExtra("reportSessionId"), "");
        Bundle bundleExtra = this.fCi.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.qun = new Req(bundleExtra).message;
        }
        this.fKz = this.fCi.getIntent().getStringExtra("KSightThumbPath");
        this.fVB = this.fCi.getIntent().getStringExtra("KSightPath");
        this.fFW = this.fCi.getIntent().getStringExtra("sight_md5");
        byte[] byteArrayExtra = this.fCi.getIntent().getByteArrayExtra("KMMSightExtInfo");
        if (byteArrayExtra != null) {
            try {
                this.qve.aD(byteArrayExtra);
            } catch (Exception e) {
                w.i("MicroMsg.SightWidget", "error %s", new Object[]{e.getMessage()});
            }
        }
        if (this.qve == null) {
            this.qve = new aks();
            this.qve.tOs = this.qsD;
        }
        com.tencent.mm.sdk.b.b okVar = new ok();
        okVar.fVy.type = 2;
        a.urY.m(okVar);
        if (bg.mA(this.fVB)) {
            this.fVB = bg.ap(okVar.fVz.fVE, "");
            w.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[]{this.fVB});
        }
        this.fFW = bg.mA(this.fFW) ? bg.ap(okVar.fVz.fVC, "") : this.fFW;
        w.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[]{this.fKz, this.fVB, this.fFW});
        a.urY.b(this.qvf);
    }

    public final void D(Bundle bundle) {
    }

    public final boolean biq() {
        return true;
    }

    public final View bir() {
        this.jIM = View.inflate(this.fCi, i.g.pIE, null);
        this.qvb = (SightPlayImageView) this.jIM.findViewById(f.cId);
        this.fCi.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.qvb.cR(com.tencent.mm.bg.a.fromDPToPix(this.fCi, 64), com.tencent.mm.bg.a.fromDPToPix(this.fCi, 64));
        this.qvb.a(QImageView.a.wxt);
        this.qvb.pvl = true;
        this.qvb.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ac qvk;

            {
                this.qvk = r1;
            }

            public final void onClick(View view) {
                if (FileOp.aO(this.qvk.fVB)) {
                    int[] iArr = new int[2];
                    if (view != null) {
                        view.getLocationInWindow(iArr);
                    }
                    int width = view.getWidth();
                    int height = view.getHeight();
                    Intent intent = new Intent(this.qvk.fCi, SnsOnlineVideoActivity.class);
                    intent.putExtra("intent_videopath", this.qvk.fVB);
                    intent.putExtra("intent_thumbpath", this.qvk.fKz);
                    intent.putExtra("intent_isad", false);
                    intent.putExtra("intent_ispreview", true);
                    intent.putExtra("img_gallery_left", iArr[0]);
                    intent.putExtra("img_gallery_top", iArr[1]);
                    intent.putExtra("img_gallery_width", width);
                    intent.putExtra("img_gallery_height", height);
                    this.qvk.fCi.startActivity(intent);
                    this.qvk.fCi.overridePendingTransition(0, 0);
                    return;
                }
                w.i("MicroMsg.SightWidget", "click videopath is not exist " + this.qvk.fVB);
            }
        });
        w.i("MicroMsg.SightWidget", "videoPath " + this.fVB + " thumbPath " + this.fKz + " " + FileOp.ki(this.fVB) + " " + FileOp.ki(this.fKz));
        if (FileOp.aO(this.fVB)) {
            w.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[]{this.fVB, this.fFW});
        }
        this.qvb.hb(false);
        this.qvb.ak(this.fVB, false);
        return this.jIM;
    }

    public final boolean a(int i, int i2, b.a.d.i iVar, String str, List<String> list, ajq com_tencent_mm_protocal_c_ajq, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        if (this.qvg != null) {
            return false;
        }
        if (this.qvc) {
            return true;
        }
        this.qvc = true;
        this.desc = str;
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            LinkedList linkedList2 = new LinkedList();
            List yA = o.yA();
            for (String str3 : list) {
                if (!yA.contains(str3)) {
                    bcs com_tencent_mm_protocal_c_bcs = new bcs();
                    com_tencent_mm_protocal_c_bcs.jNj = str3;
                    linkedList.add(com_tencent_mm_protocal_c_bcs);
                }
            }
        }
        this.qvg = new aw(15);
        pInt.value = this.qvg.jFe;
        if (i3 > com.tencent.mm.plugin.sns.c.a.pQH) {
            this.qvg.tj(3);
        }
        aw Fy = this.qvg.Fy(str);
        LinkedList linkedList3 = new LinkedList();
        Fy.a(com_tencent_mm_protocal_c_ajq).aj(linkedList).tl(i).tm(i2).br(list2);
        if (z) {
            this.qvg.to(1);
        } else {
            this.qvg.to(0);
        }
        this.qvg.br(list2);
        this.qvg.tn(this.qqL);
        this.qvg.fWi = this.qve;
        this.qvg.e(null, null, null, i4, i5);
        if (!bg.mA(this.appId)) {
            this.qvg.FE(this.appId);
        }
        if (!bg.mA(this.appName)) {
            this.qvg.FF(bg.ap(this.appName, ""));
        }
        if (this.qul) {
            this.qvg.tn(5);
        }
        if (this.qum && this.qun != null) {
            this.qvg.Fz(this.qun.mediaTagName);
            this.qvg.Q(this.appId, this.qun.messageExt, this.qun.messageAction);
        }
        af.f(this.qvj, 700);
        e.post(new Runnable(this) {
            final /* synthetic */ ac qvk;

            {
                this.qvk = r1;
            }

            public final void run() {
                ac acVar = this.qvk;
                long currentTimeMillis = System.currentTimeMillis();
                if (TextUtils.isEmpty(acVar.mLO) || TextUtils.isEmpty(acVar.hhy)) {
                    if (!acVar.qvg.j(acVar.fVB, acVar.fKz, acVar.desc, acVar.fFW)) {
                        w.i("MicroMsg.SightWidget", "commitInThread videopath " + FileOp.ki(acVar.fVB) + " thumb: " + FileOp.ki(acVar.fKz));
                        af.v(new Runnable(acVar) {
                            final /* synthetic */ ac qvk;

                            {
                                this.qvk = r1;
                            }

                            public final void run() {
                                s.makeText(this.qvk.fCi, j.eRk, 0).show();
                            }
                        });
                    }
                    w.i("MicroMsg.SightWidget", "commitInThread cost time %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                } else {
                    int i;
                    aw awVar = acVar.qvg;
                    String str = acVar.fVB;
                    String str2 = acVar.fKz;
                    String str3 = acVar.desc;
                    String str4 = acVar.fFW;
                    String str5 = acVar.mLO;
                    String str6 = acVar.hhy;
                    String str7 = ae.getAccSnsTmpPath() + com.tencent.mm.a.g.n(str.getBytes());
                    aw.FI(str7);
                    FileOp.p(str, str7);
                    String str8 = ae.getAccSnsTmpPath() + com.tencent.mm.a.g.n(str2.getBytes());
                    FileOp.p(str2, str8);
                    alh a = aw.a("", 6, str7, str8, str4, str5, str6);
                    if (a == null) {
                        w.e("MicroMsg.UploadPackHelper", "share img o.imagePath is null!");
                        i = 0;
                    } else {
                        a.msk = str3;
                        if (bg.mA(a.fDC)) {
                            a.fDC = str3;
                        }
                        awVar.pYp.ufB.tsO.add(a);
                        ajp com_tencent_mm_protocal_c_ajp = new ajp();
                        com_tencent_mm_protocal_c_ajp.tNq = a.pRa;
                        awVar.pYq.tPG.add(com_tencent_mm_protocal_c_ajp);
                        i = 1;
                    }
                    if (i == 0) {
                        w.i("MicroMsg.SightWidget", "commitInThread videopath " + FileOp.ki(acVar.fVB) + " thumb: " + FileOp.ki(acVar.fKz) + ",cdnUrl " + acVar.mLO + "cdnThubmUrl " + acVar.hhy);
                        af.v(new Runnable(acVar) {
                            final /* synthetic */ ac qvk;

                            {
                                this.qvk = r1;
                            }

                            public final void run() {
                                s.makeText(this.qvk.fCi, j.eRk, 0).show();
                            }
                        });
                    }
                    w.i("MicroMsg.SightWidget", "commitInThread cost time %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                }
                w.i("MicroMsg.SightWidget", "removeRunnable showProgress");
                af.I(this.qvk.qvj);
                if (this.qvk.qvg != null) {
                    af.v(this.qvk.qvi);
                }
            }
        }, "sight_send_ready");
        return true;
    }

    public final void bjh() {
        if (this.qvg != null) {
            if (this.isv != null) {
                this.isv.dismiss();
            }
            w.i("MicroMsg.SightWidget", "commitDone");
            com.tencent.mm.sdk.b.b okVar = new ok();
            okVar.fVy.type = 0;
            okVar.fVy.fVA = true;
            a.urY.m(okVar);
            this.qvc = true;
            int commit = this.qvg.commit();
            if (this.qqR != null) {
                this.qqR.gB(commit);
                com.tencent.mm.plugin.sns.h.e.qdB.b(this.qqR);
            }
            ae.beR().qxd = 0;
            if (this.fCi.getIntent() != null && this.fCi.getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false)) {
                Intent intent = new Intent();
                intent.putExtra("sns_resume_state", false);
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                intent.setClass(this.fCi, En_424b8e16.class);
                intent.addFlags(67108864);
                this.fCi.startActivity(intent);
            }
            this.fCi.setResult(-1);
            this.fCi.finish();
            ae.beH().bdz();
        }
    }

    public final boolean a(int i, Intent intent) {
        return false;
    }

    public final boolean bis() {
        if (this.isv != null) {
            this.isv.dismiss();
        }
        this.qvb.ak(this.fVB, true);
        a.urY.c(this.qvf);
        if (com.tencent.mm.plugin.sns.data.i.k(this.qvd)) {
            this.qvd.recycle();
        }
        return false;
    }
}
