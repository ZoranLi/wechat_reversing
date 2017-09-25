package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.h.f;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;

public final class z implements y {
    private String appId;
    private String appName;
    public final MMActivity fCi;
    private String fUR;
    private String fUW;
    private String fUX;
    private int h = -1;
    public String hSX = "";
    public String hjJ = "";
    public String hjK = "";
    private Bitmap hqW = null;
    private String iCS;
    private TextView ioX = null;
    private View jIM = null;
    private boolean nAt = false;
    private String qqI = "";
    private byte[] qqJ = null;
    private String qqK;
    private int qqL;
    private CdnImageView qqM = null;
    private TextView qqN = null;
    private b qqR = null;
    private int qsE = 0;
    private boolean qug = false;
    private String quh;
    private String qui;
    private boolean quj = false;
    private boolean quk = false;
    private boolean qul = false;
    private boolean qum = false;
    private WXMediaMessage qun = null;
    private String quo = "";
    private String qup = "";
    private String quq;
    private String qur;
    private int qus = 0;
    private b qut = null;
    private String quu = "";
    private String quv = "";
    private int quw = 0;
    private String qux = "";
    private String quy = "";
    private String title = "";
    private String videoUrl = "";
    private int w = -1;

    public z(MMActivity mMActivity) {
        this.fCi = mMActivity;
    }

    public final void C(Bundle bundle) {
        this.qqR = b.o(this.fCi.getIntent());
        this.qsE = this.fCi.getIntent().getIntExtra("Ksnsupload_type", 0);
        this.quw = this.fCi.getIntent().getIntExtra("KSnsStreamVideoTotalTime", 0);
        this.qux = bg.ap(this.fCi.getIntent().getStringExtra("KSnsStreamVideoWroding"), "");
        this.quy = bg.ap(this.fCi.getIntent().getStringExtra("KSnsStreamVideoWebUrl"), "");
        this.hjJ = bg.ap(this.fCi.getIntent().getStringExtra("KSnsStreamVideoAduxInfo"), "");
        this.hjK = bg.ap(this.fCi.getIntent().getStringExtra("KSnsStreamVideoPublishId"), "");
        this.w = this.fCi.getIntent().getIntExtra("Ksnsupload_width", -1);
        this.h = this.fCi.getIntent().getIntExtra("Ksnsupload_height", -1);
        this.qqL = this.fCi.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.qui = bg.ap(this.fCi.getIntent().getStringExtra("key_snsad_statextstr"), "");
        this.hSX = bg.ap(this.fCi.getIntent().getStringExtra("Ksnsupload_link"), "");
        this.title = bg.ap(this.fCi.getIntent().getStringExtra("Ksnsupload_title"), "");
        this.qqI = bg.ap(this.fCi.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
        this.qqJ = this.fCi.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
        if (this.qqJ == null && this.qun != null && this.qun.mediaObject != null && (this.qun.mediaObject instanceof WXImageObject)) {
            this.qqJ = ((WXImageObject) this.qun.mediaObject).imageData;
        }
        this.nAt = this.fCi.getIntent().getBooleanExtra("ksnsis_video", false);
        this.quj = this.fCi.getIntent().getBooleanExtra("ksnsis_music", false);
        this.quk = this.fCi.getIntent().getBooleanExtra("ksnsis_appbrand", false);
        this.fUR = bg.ap(this.fCi.getIntent().getStringExtra("src_username"), "");
        this.qqK = bg.ap(this.fCi.getIntent().getStringExtra("src_displayname"), "");
        this.appId = bg.ap(this.fCi.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bg.ap(this.fCi.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.qul = this.fCi.getIntent().getBooleanExtra("KThrid_app", false);
        this.qum = this.fCi.getIntent().getBooleanExtra("KSnsAction", false);
        this.quq = bg.ap(this.fCi.getIntent().getStringExtra("ShareUrlOriginal"), "");
        this.qur = bg.ap(this.fCi.getIntent().getStringExtra("ShareUrlOpen"), "");
        this.fUW = bg.ap(this.fCi.getIntent().getStringExtra("JsAppId"), "");
        this.fUX = bg.ap(this.fCi.getIntent().getStringExtra("KPublisherId"), "");
        this.iCS = bg.ap(this.fCi.getIntent().getStringExtra("reportSessionId"), "");
        this.qus = this.fCi.getIntent().getIntExtra("Ksnsupload_contentattribute", 0);
        this.quu = bg.ap(this.fCi.getIntent().getStringExtra("KsnsUpload_BrandUsername"), "");
        this.quv = bg.ap(this.fCi.getIntent().getStringExtra("KsnsUpload_BrandPath"), "");
        this.quh = bg.ap(this.fCi.getIntent().getStringExtra("KlinkThumb_url"), "");
        if (this.quh.startsWith("http://mmsns.qpic.cn") || this.quh.startsWith("https://mmsns.qpic.cn")) {
            this.qqI = this.quh;
            this.qqJ = null;
            w.i("MicroMsg.LinkWidget", "get thumb url %s", new Object[]{this.quh});
        }
        Bundle bundleExtra = this.fCi.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.qun = new Req(bundleExtra).message;
            if (bg.mA(this.title)) {
                this.title = this.qun.title;
            }
            if (bg.mA(this.qup)) {
                this.qup = this.qun.description;
            }
            if (bg.bm(this.qqJ)) {
                this.qqJ = this.qun.thumbData;
            }
        }
        String stringExtra = this.fCi.getIntent().getStringExtra("KSnsStrId");
        m Gg = ae.beL().Gg(bg.ap(this.fCi.getIntent().getStringExtra("KSnsLocalId"), ""));
        if (!bg.mA(stringExtra)) {
            this.qut = b.gz(706);
            this.qut.gD(this.qut.hTu).kH(System.currentTimeMillis()).gD(this.qut.hTw).gD(1).kH(stringExtra);
            if (Gg != null) {
                this.qut.gC(Gg.field_type);
                this.qut.bp(Gg.tE(32)).kG(Gg.bhI()).kG(this.hSX);
            }
            f.qdB.a(this.qut);
        }
    }

    public final void D(Bundle bundle) {
    }

    public final boolean biq() {
        return true;
    }

    public final View bir() {
        this.jIM = r.eC(this.fCi).inflate(g.pIC, null);
        if (!bg.mA(this.hSX)) {
            this.jIM.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ z quz;

                {
                    this.quz = r1;
                }

                public final void onClick(View view) {
                    w.i("MicroMsg.LinkWidget", "adlink url " + this.quz.hSX);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", this.quz.hSX);
                    a.imv.j(intent, this.quz.fCi);
                }
            });
        }
        this.qqM = (CdnImageView) this.jIM.findViewById(i.f.pCJ);
        this.ioX = (TextView) this.jIM.findViewById(i.f.pGi);
        this.qqN = (TextView) this.jIM.findViewById(i.f.pDD);
        if (this.nAt || this.quj) {
            this.jIM.findViewById(i.f.state).setVisibility(0);
        } else {
            this.jIM.findViewById(i.f.state).setVisibility(8);
        }
        if (bg.mA(this.title)) {
            this.ioX.setText(au.Hd(this.hSX));
        } else {
            this.ioX.setText(this.title);
        }
        if (!bg.mA(this.qqI)) {
            this.qqM.setVisibility(0);
            this.qqM.L(this.qqI, 0, 0);
        } else if (bg.bm(this.qqJ)) {
            this.qqM.setImageResource(i.i.dtu);
            this.qqM.setVisibility(0);
        } else {
            this.qqM.setVisibility(0);
            this.hqW = d.bd(this.qqJ);
            this.qqM.setImageBitmap(this.hqW);
            this.qug = true;
        }
        com.tencent.mm.plugin.sns.data.i.b(this.qqM, this.fCi);
        return this.jIM;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int r11, int r12, b.a.d.i r13, java.lang.String r14, java.util.List<java.lang.String> r15, com.tencent.mm.protocal.c.ajq r16, int r17, boolean r18, java.util.List<java.lang.String> r19, com.tencent.mm.pointers.PInt r20, java.lang.String r21, int r22, int r23) {
        /*
        r10 = this;
        r1 = r10.quj;
        if (r1 == 0) goto L_0x00f3;
    L_0x0004:
        r1 = new com.tencent.mm.plugin.sns.model.aw;
        r2 = 4;
        r1.<init>(r2);
    L_0x000a:
        r2 = r1.jFe;
        r0 = r20;
        r0.value = r2;
        r2 = com.tencent.mm.plugin.sns.c.a.pQH;
        r0 = r17;
        if (r0 <= r2) goto L_0x001a;
    L_0x0016:
        r2 = 4;
        r1.tj(r2);
    L_0x001a:
        r2 = r10.qqJ;
        if (r2 != 0) goto L_0x0061;
    L_0x001e:
        com.tencent.mm.ah.n.GR();
        r2 = r10.qqI;
        r2 = com.tencent.mm.ah.b.gS(r2);
        if (r2 == 0) goto L_0x0061;
    L_0x0029:
        r3 = r2.isRecycled();
        if (r3 != 0) goto L_0x0061;
    L_0x002f:
        r3 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r4 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r5 = 0;
        r6 = 0;
        r2 = com.tencent.mm.sdk.platformtools.d.a(r2, r3, r4, r5, r6);
        r3 = "MicroMsg.LinkWidget";
        r4 = "create bitmap %d %d";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = r2.getHeight();
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        r6 = 1;
        r7 = r2.getWidth();
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);
        r2 = com.tencent.mm.sdk.platformtools.d.K(r2);
        r10.qqJ = r2;
    L_0x0061:
        r2 = r10.title;
        r2 = r1.FD(r2);
        r3 = r10.hSX;
        r2 = r2.FB(r3);
        r3 = r10.hSX;
        r2 = r2.FC(r3);
        r2.Fy(r14);
        r2 = r10.quj;
        if (r2 == 0) goto L_0x015e;
    L_0x007a:
        r2 = r10.qqJ;
        r3 = r10.hSX;
        r4 = r10.hSX;
        r5 = r10.hSX;
        r6 = 3;
        r7 = "";
        r8 = "";
        r2 = r1.a(r2, r3, r4, r5, r6, r7, r8);
        if (r2 != 0) goto L_0x008f;
    L_0x008f:
        r2 = r10.qqL;
        r1.tn(r2);
        r2 = r10.fUR;
        r1.FG(r2);
        r2 = r10.qqK;
        r1.FH(r2);
        r2 = r10.qui;
        r3 = r1.pYp;
        r4 = com.tencent.mm.sdk.platformtools.bg.mz(r2);
        r3.qui = r4;
        r3 = "MicroMsg.UploadPackHelper";
        r4 = "setStatExtStr:%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r5[r6] = r2;
        com.tencent.mm.sdk.platformtools.w.i(r3, r4, r5);
        if (r18 == 0) goto L_0x0254;
    L_0x00b9:
        r2 = 1;
        r1.to(r2);
    L_0x00bd:
        r0 = r19;
        r1.br(r0);
        r3 = new java.util.LinkedList;
        r3.<init>();
        if (r15 == 0) goto L_0x025a;
    L_0x00c9:
        r2 = new java.util.LinkedList;
        r2.<init>();
        r4 = com.tencent.mm.u.o.yA();
        r5 = r15.iterator();
    L_0x00d6:
        r2 = r5.hasNext();
        if (r2 == 0) goto L_0x025a;
    L_0x00dc:
        r2 = r5.next();
        r2 = (java.lang.String) r2;
        r6 = r4.contains(r2);
        if (r6 != 0) goto L_0x00d6;
    L_0x00e8:
        r6 = new com.tencent.mm.protocal.c.bcs;
        r6.<init>();
        r6.jNj = r2;
        r3.add(r6);
        goto L_0x00d6;
    L_0x00f3:
        r1 = r10.nAt;
        if (r1 == 0) goto L_0x00ff;
    L_0x00f7:
        r1 = new com.tencent.mm.plugin.sns.model.aw;
        r2 = 5;
        r1.<init>(r2);
        goto L_0x000a;
    L_0x00ff:
        r1 = r10.quk;
        if (r1 == 0) goto L_0x011c;
    L_0x0103:
        r1 = new com.tencent.mm.plugin.sns.model.aw;
        r2 = 25;
        r1.<init>(r2);
        r2 = r10.quu;
        r3 = r1.pYp;
        r3 = r3.ufH;
        r3.username = r2;
        r2 = r10.quv;
        r3 = r1.pYp;
        r3 = r3.ufH;
        r3.path = r2;
        goto L_0x000a;
    L_0x011c:
        r1 = r10.qsE;
        r2 = 11;
        if (r1 != r2) goto L_0x0156;
    L_0x0122:
        r1 = new com.tencent.mm.plugin.sns.model.aw;
        r2 = 18;
        r1.<init>(r2);
        r2 = new com.tencent.mm.protocal.c.bdt;
        r2.<init>();
        r3 = r10.qux;
        r2.hjG = r3;
        r3 = r10.title;
        r2.hjF = r3;
        r3 = r10.hSX;
        r2.hjD = r3;
        r3 = r10.quy;
        r2.hjH = r3;
        r3 = r10.quw;
        r2.hjE = r3;
        r3 = r10.qqI;
        r2.hjI = r3;
        r3 = r10.hjJ;
        r2.hjJ = r3;
        r3 = r10.hjK;
        r2.hjK = r3;
        r1.pYu = r2;
        r3 = r1.pYp;
        r3.ufG = r2;
        goto L_0x000a;
    L_0x0156:
        r1 = new com.tencent.mm.plugin.sns.model.aw;
        r2 = 3;
        r1.<init>(r2);
        goto L_0x000a;
    L_0x015e:
        r2 = r10.nAt;
        if (r2 == 0) goto L_0x01a4;
    L_0x0162:
        r2 = 0;
        r3 = r10.qun;
        if (r3 == 0) goto L_0x030a;
    L_0x0167:
        r2 = r10.qun;
        r2 = r2.mediaObject;
        r2 = (com.tencent.mm.opensdk.modelmsg.WXVideoObject) r2;
        r5 = r2;
    L_0x016e:
        r2 = r10.qqJ;
        r3 = r10.hSX;
        if (r5 != 0) goto L_0x0192;
    L_0x0174:
        r4 = r10.hSX;
    L_0x0176:
        if (r5 != 0) goto L_0x019b;
    L_0x0178:
        r5 = r10.hSX;
    L_0x017a:
        r6 = 4;
        r7 = r10.title;
        r8 = "";
        r7 = com.tencent.mm.sdk.platformtools.bg.ap(r7, r8);
        r8 = r10.qup;
        r9 = "";
        r8 = com.tencent.mm.sdk.platformtools.bg.ap(r8, r9);
        r1.a(r2, r3, r4, r5, r6, r7, r8);
        goto L_0x008f;
    L_0x0192:
        r4 = r5.videoLowBandUrl;
        r6 = r10.hSX;
        r4 = com.tencent.mm.sdk.platformtools.bg.ap(r4, r6);
        goto L_0x0176;
    L_0x019b:
        r5 = r5.videoUrl;
        r6 = r10.hSX;
        r5 = com.tencent.mm.sdk.platformtools.bg.ap(r5, r6);
        goto L_0x017a;
    L_0x01a4:
        r2 = r10.quh;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 != 0) goto L_0x01fa;
    L_0x01ac:
        r2 = r10.quh;
        r3 = "";
        r4 = "";
        r5 = r10.w;
        r6 = r10.h;
        r7 = "";
        r2 = com.tencent.mm.plugin.sns.model.aw.R(r7, r2, r2);
        if (r2 != 0) goto L_0x01cc;
    L_0x01c1:
        r2 = "MicroMsg.UploadPackHelper";
        r3 = "share img o.url is null!";
        com.tencent.mm.sdk.platformtools.w.e(r2, r3);
        goto L_0x008f;
    L_0x01cc:
        r2.msk = r3;
        if (r5 <= 0) goto L_0x01df;
    L_0x01d0:
        if (r6 <= 0) goto L_0x01df;
    L_0x01d2:
        r7 = new com.tencent.mm.protocal.c.alj;
        r7.<init>();
        r6 = (float) r6;
        r7.tPZ = r6;
        r5 = (float) r5;
        r7.tPY = r5;
        r2.tPl = r7;
    L_0x01df:
        r5 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
        if (r5 != 0) goto L_0x01e7;
    L_0x01e5:
        r2.fDC = r4;
    L_0x01e7:
        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
        if (r4 != 0) goto L_0x01ef;
    L_0x01ed:
        r2.msk = r3;
    L_0x01ef:
        r3 = r1.pYp;
        r3 = r3.ufB;
        r3 = r3.tsO;
        r3.add(r2);
        goto L_0x008f;
    L_0x01fa:
        r2 = r10.qqJ;
        if (r2 == 0) goto L_0x008f;
    L_0x01fe:
        r2 = r10.quk;
        if (r2 == 0) goto L_0x022c;
    L_0x0202:
        r4 = r10.qqJ;
        if (r4 != 0) goto L_0x0239;
    L_0x0206:
        r2 = 0;
    L_0x0207:
        if (r2 == 0) goto L_0x022c;
    L_0x0209:
        r2 = "MicroMsg.LinkWidget";
        r3 = "isPngThumbData";
        com.tencent.mm.sdk.platformtools.w.i(r2, r3);
        r2 = r10.qqJ;
        r2 = com.tencent.mm.plugin.sns.ui.e.aG(r2);
        if (r2 == 0) goto L_0x022c;
    L_0x021a:
        r3 = r2.length;
        if (r3 <= 0) goto L_0x022c;
    L_0x021d:
        r3 = "MicroMsg.LinkWidget";
        r4 = "use covert data";
        com.tencent.mm.sdk.platformtools.w.i(r3, r4);
        r2 = com.tencent.mm.plugin.sns.ui.e.aG(r2);
        r10.qqJ = r2;
    L_0x022c:
        r2 = r10.qqJ;
        r3 = "";
        r4 = "";
        r1.a(r2, r3, r4);
        goto L_0x008f;
    L_0x0239:
        r2 = r4.length;
        r3 = 4;
        if (r2 >= r3) goto L_0x023f;
    L_0x023d:
        r2 = 0;
        goto L_0x0207;
    L_0x023f:
        r2 = 1;
        r3 = 4;
        r5 = new byte[r3];
        r5 = {-119, 80, 78, 71};
        r3 = 0;
    L_0x0247:
        r6 = 4;
        if (r3 >= r6) goto L_0x0207;
    L_0x024a:
        r6 = r4[r3];
        r7 = r5[r3];
        if (r6 == r7) goto L_0x0251;
    L_0x0250:
        r2 = 0;
    L_0x0251:
        r3 = r3 + 1;
        goto L_0x0247;
    L_0x0254:
        r2 = 0;
        r1.to(r2);
        goto L_0x00bd;
    L_0x025a:
        if (r13 == 0) goto L_0x0263;
    L_0x025c:
        r2 = r13.token;
        r4 = r13.tPO;
        r1.dx(r2, r4);
    L_0x0263:
        r1.aj(r3);
        r2 = r10.appId;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 != 0) goto L_0x0273;
    L_0x026e:
        r2 = r10.appId;
        r1.FE(r2);
    L_0x0273:
        r2 = r10.appName;
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r2 != 0) goto L_0x0287;
    L_0x027b:
        r2 = r10.appName;
        r3 = "";
        r2 = com.tencent.mm.sdk.platformtools.bg.ap(r2, r3);
        r1.FF(r2);
    L_0x0287:
        r2 = r10.qul;
        if (r2 == 0) goto L_0x028f;
    L_0x028b:
        r2 = 5;
        r1.tn(r2);
    L_0x028f:
        r0 = r16;
        r1.a(r0);
        r2 = r10.qum;
        if (r2 == 0) goto L_0x02b0;
    L_0x0298:
        r2 = r10.qun;
        if (r2 == 0) goto L_0x02b0;
    L_0x029c:
        r2 = r10.qun;
        r2 = r2.mediaTagName;
        r1.Fz(r2);
        r2 = r10.appId;
        r3 = r10.qun;
        r3 = r3.messageExt;
        r4 = r10.qun;
        r4 = r4.messageAction;
        r1.Q(r2, r3, r4);
    L_0x02b0:
        r0 = r21;
        r1.FA(r0);
        r2 = r10.quq;
        r3 = r10.qur;
        r4 = r10.fUW;
        r5 = r22;
        r6 = r23;
        r1.e(r2, r3, r4, r5, r6);
        r2 = r10.fUX;
        r3 = r1.pYq;
        r3.fUX = r2;
        r2 = r10.iCS;
        r1.nV(r2);
        r2 = r10.qus;
        r3 = r1.pYp;
        r3.hhv = r2;
        r1 = r1.commit();
        r2 = r10.qqR;
        if (r2 == 0) goto L_0x02e7;
    L_0x02db:
        r2 = r10.qqR;
        r2.gB(r1);
        r2 = com.tencent.mm.plugin.sns.h.e.qdB;
        r3 = r10.qqR;
        r2.b(r3);
    L_0x02e7:
        r2 = r10.qut;
        if (r2 == 0) goto L_0x02fc;
    L_0x02eb:
        r2 = r10.qut;
        r2.gB(r1);
        r1 = com.tencent.mm.plugin.sns.h.f.qdB;
        r2 = r10.qut;
        r1.b(r2);
        r1 = r10.qut;
        r1.JE();
    L_0x02fc:
        r1 = com.tencent.mm.plugin.sns.model.ae.beH();
        r1.bdz();
        r1 = r10.fCi;
        r1.finish();
        r1 = 0;
        return r1;
    L_0x030a:
        r5 = r2;
        goto L_0x016e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.z.a(int, int, b.a.d.i, java.lang.String, java.util.List, com.tencent.mm.protocal.c.ajq, int, boolean, java.util.List, com.tencent.mm.pointers.PInt, java.lang.String, int, int):boolean");
    }

    public final boolean a(int i, Intent intent) {
        return false;
    }

    public final boolean bis() {
        if (!(this.hqW == null || this.hqW.isRecycled() || !this.qug)) {
            this.hqW.recycle();
        }
        return false;
    }
}
