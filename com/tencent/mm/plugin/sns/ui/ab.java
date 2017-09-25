package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.e.a.jc;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.protocal.c.anf;
import com.tencent.mm.protocal.c.bcs;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;
import java.util.LinkedList;
import java.util.List;

public final class ab implements y {
    private String appName = "";
    MMActivity fCi;
    public String fTO = "";
    private c iOT = new c<jc>(this) {
        final /* synthetic */ ab qva;

        {
            this.qva = r2;
            this.usg = jc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            switch (((jc) bVar).fPc.action) {
                case 0:
                case 1:
                    this.qva.quY.setImageResource(e.bho);
                    break;
                case 2:
                case 3:
                case 4:
                    this.qva.quY.setImageResource(e.bhp);
                    break;
            }
            return false;
        }
    };
    private TextView ioX = null;
    private View jIM;
    public boolean kAq = false;
    public String mediaId;
    private int qqL;
    private CdnImageView qqM = null;
    private TextView qqN = null;
    private com.tencent.mm.modelsns.b qqR = null;
    public ImageView quY;
    private Bitmap quZ;
    private boolean qul = false;
    private boolean qum = false;
    public WXMediaMessage qun = null;

    public ab(MMActivity mMActivity) {
        this.fCi = mMActivity;
        a.urY.b(this.iOT);
    }

    public final void C(Bundle bundle) {
        this.qun = new Req(this.fCi.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
        this.mediaId = this.fCi.getIntent().getStringExtra("Ksnsupload_musicid");
        this.qqR = com.tencent.mm.modelsns.b.o(this.fCi.getIntent());
        this.fTO = bg.ap(this.fCi.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bg.ap(this.fCi.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.qul = this.fCi.getIntent().getBooleanExtra("KThrid_app", false);
        this.qum = this.fCi.getIntent().getBooleanExtra("KSnsAction", false);
        this.qqL = this.fCi.getIntent().getIntExtra("Ksnsupload_source", 0);
    }

    public final void D(Bundle bundle) {
    }

    public final boolean biq() {
        return true;
    }

    public final void bjg() {
        new ae(this.fCi.getMainLooper()).post(new Runnable(this) {
            final /* synthetic */ ab qva;

            {
                this.qva = r1;
            }

            public final void run() {
                com.tencent.mm.am.b.HH();
                this.qva.kAq = false;
            }
        });
    }

    public final View bir() {
        this.jIM = r.eC(this.fCi).inflate(g.pID, null);
        this.qqM = (CdnImageView) this.jIM.findViewById(f.pCJ);
        this.ioX = (TextView) this.jIM.findViewById(f.pGi);
        this.qqN = (TextView) this.jIM.findViewById(f.pDD);
        this.jIM.findViewById(f.state).setVisibility(8);
        this.ioX.setText(this.qun.title);
        if (this.qun.thumbData != null) {
            this.quZ = d.bd(this.qun.thumbData);
        }
        this.qqM.setImageBitmap(this.quZ);
        if (bg.mA(this.qun.description)) {
            this.qqN.setVisibility(8);
        } else {
            this.qqN.setText(this.qun.description);
            this.qqN.setVisibility(0);
        }
        this.quY = (ImageView) this.jIM.findViewById(f.state);
        this.quY.setVisibility(0);
        if (com.tencent.mm.am.b.HJ() && this.kAq) {
            this.quY.setImageResource(e.bho);
        } else {
            this.quY.setImageResource(e.bhp);
        }
        this.quY.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ab qva;

            {
                this.qva = r1;
            }

            public final void onClick(View view) {
                if (com.tencent.mm.am.b.HJ()) {
                    this.qva.bjg();
                    return;
                }
                ab abVar = this.qva;
                if (abVar.qun == null) {
                    w.w("MicroMsg.MusicWidget", "doBeingPlayMusic: but item is null");
                } else {
                    new ae(abVar.fCi.getMainLooper()).post(new Runnable(abVar) {
                        final /* synthetic */ ab qva;

                        {
                            this.qva = r1;
                        }

                        public final void run() {
                            if (3 == this.qva.qun.getType()) {
                                this.qva.kAq = true;
                                WXMusicObject wXMusicObject = (WXMusicObject) this.qva.qun.mediaObject;
                                String ap = bg.ap(!bg.mA(wXMusicObject.musicUrl) ? wXMusicObject.musicUrl : wXMusicObject.musicLowBandUrl, "");
                                String ap2 = bg.ap(!bg.mA(wXMusicObject.musicDataUrl) ? wXMusicObject.musicDataUrl : wXMusicObject.musicUrl, "");
                                if (bg.mA(this.qva.mediaId)) {
                                    this.qva.mediaId = System.currentTimeMillis();
                                }
                                anf com_tencent_mm_protocal_c_anf = new anf();
                                com_tencent_mm_protocal_c_anf.tRH = 1;
                                com_tencent_mm_protocal_c_anf.tqY = this.qva.mediaId;
                                com_tencent_mm_protocal_c_anf.tRI = 0.0f;
                                com_tencent_mm_protocal_c_anf.tRL = "";
                                com_tencent_mm_protocal_c_anf.tRR = null;
                                com_tencent_mm_protocal_c_anf.tiL = 1;
                                com_tencent_mm_protocal_c_anf.tRQ = null;
                                com_tencent_mm_protocal_c_anf.tRJ = this.qva.qun.title;
                                com_tencent_mm_protocal_c_anf.tRK = this.qva.qun.description;
                                com_tencent_mm_protocal_c_anf.tRP = ap;
                                com_tencent_mm_protocal_c_anf.tRO = ap2;
                                com_tencent_mm_protocal_c_anf.tRN = ap2;
                                com_tencent_mm_protocal_c_anf.ttW = "";
                                com_tencent_mm_protocal_c_anf.tRS = com.tencent.mm.plugin.sns.model.ae.xv();
                                com_tencent_mm_protocal_c_anf.mtb = this.qva.fTO;
                                com.tencent.mm.am.b.b(com_tencent_mm_protocal_c_anf);
                            }
                        }
                    });
                }
            }
        });
        i.b(this.qqM, this.fCi);
        return this.jIM;
    }

    public final boolean a(int i, int i2, b.a.d.i iVar, String str, List<String> list, ajq com_tencent_mm_protocal_c_ajq, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        com.tencent.mm.plugin.sns.model.ae.beH();
        aw a = av.a(this.qun, str, this.fTO, this.appName);
        if (a == null) {
            w.e("MicroMsg.MusicWidget", "packHelper == null, %s, %s", new Object[]{this.fTO, this.appName});
            return false;
        }
        pInt.value = a.jFe;
        if (i3 > com.tencent.mm.plugin.sns.c.a.pQH) {
            a.tj(4);
        }
        a.tn(this.qqL);
        if (this.qul) {
            a.tn(5);
        }
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
        a.aj(linkedList);
        if (iVar != null) {
            a.dx(iVar.token, iVar.tPO);
        }
        a.a(com_tencent_mm_protocal_c_ajq);
        if (z) {
            a.to(1);
        } else {
            a.to(0);
        }
        a.br(list2);
        a.e(null, null, null, i4, i5);
        if (this.qum && this.qun != null) {
            a.Fz(this.qun.mediaTagName);
            a.Q(this.fTO, this.qun.messageExt, this.qun.messageAction);
        }
        int commit = a.commit();
        if (this.qqR != null) {
            this.qqR.gB(commit);
            com.tencent.mm.plugin.sns.h.e.qdB.b(this.qqR);
        }
        com.tencent.mm.plugin.sns.model.ae.beH().bdz();
        this.fCi.finish();
        return false;
    }

    public final boolean a(int i, Intent intent) {
        return false;
    }

    public final boolean bis() {
        if (!(this.quZ == null || this.quZ.isRecycled())) {
            this.quZ.recycle();
        }
        a.urY.c(this.iOT);
        if (com.tencent.mm.am.b.HJ() && this.kAq) {
            bjg();
        }
        return com.tencent.mm.am.b.HJ();
    }
}
