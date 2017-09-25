package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ah.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.protocal.c.bcs;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.r;
import java.util.LinkedList;
import java.util.List;

public final class ah implements y {
    private String appId = "";
    private String appName = "";
    private MMActivity fCi;
    private String fOa = "";
    private String fUR;
    private int h = -1;
    private String hSX = "";
    private Bitmap hqW = null;
    private int iIb = 9;
    private TextView ioX = null;
    private View jIM = null;
    private boolean nAt = false;
    private String qqI = "";
    private byte[] qqJ = null;
    private String qqK;
    private int qqL;
    private CdnImageView qqM = null;
    private TextView qqN = null;
    private int qqO;
    private String qqP = "";
    private String qqQ = "";
    private b qqR = null;
    private String title = "";
    private int w = -1;

    public ah(MMActivity mMActivity, int i) {
        this.fCi = mMActivity;
        this.iIb = i;
    }

    public final void C(Bundle bundle) {
        this.qqR = b.o(this.fCi.getIntent());
        this.w = this.fCi.getIntent().getIntExtra("Ksnsupload_width", -1);
        this.h = this.fCi.getIntent().getIntExtra("Ksnsupload_height", -1);
        this.qqL = this.fCi.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.hSX = bg.ap(this.fCi.getIntent().getStringExtra("Ksnsupload_link"), "");
        this.title = bg.ap(this.fCi.getIntent().getStringExtra("Ksnsupload_title"), "");
        this.qqI = bg.ap(this.fCi.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
        this.fOa = this.fCi.getIntent().getStringExtra("KsnsUpload_imgPath");
        this.nAt = this.fCi.getIntent().getBooleanExtra("ksnsis_video", false);
        this.fUR = bg.ap(this.fCi.getIntent().getStringExtra("src_username"), "");
        this.qqK = bg.ap(this.fCi.getIntent().getStringExtra("src_displayname"), "");
        this.qqQ = bg.ap(this.fCi.getIntent().getStringExtra("KContentObjDesc"), "");
        this.qqP = bg.ap(this.fCi.getIntent().getStringExtra("KUploadProduct_UserData"), "");
        this.appName = bg.ap(this.fCi.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.appId = bg.ap(this.fCi.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.qqO = this.fCi.getIntent().getIntExtra("KUploadProduct_subType", 0);
    }

    public final void D(Bundle bundle) {
    }

    public final boolean biq() {
        return true;
    }

    public final View bir() {
        this.jIM = r.eC(this.fCi).inflate(g.pIC, null);
        this.qqM = (CdnImageView) this.jIM.findViewById(f.pCJ);
        this.ioX = (TextView) this.jIM.findViewById(f.pGi);
        this.qqN = (TextView) this.jIM.findViewById(f.pDD);
        if (this.nAt) {
            this.jIM.findViewById(f.state).setVisibility(0);
        } else {
            this.jIM.findViewById(f.state).setVisibility(8);
        }
        this.ioX.setText(this.title);
        if (this.iIb == 13) {
            this.ioX.setText(this.title + "\n" + this.qqQ);
        }
        if (!bg.mA(this.qqI)) {
            this.qqM.setVisibility(0);
            this.qqM.L(this.qqI, 0, 0);
        } else if (bg.bm(this.qqJ)) {
            this.qqM.setVisibility(8);
        } else {
            this.qqM.setVisibility(0);
            this.hqW = d.bd(this.qqJ);
            this.qqM.setImageBitmap(this.hqW);
        }
        i.b(this.qqM, this.fCi);
        return this.jIM;
    }

    public final boolean a(int i, int i2, b.a.d.i iVar, String str, List<String> list, ajq com_tencent_mm_protocal_c_ajq, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        aw awVar = new aw(this.iIb);
        pInt.value = awVar.jFe;
        if (i3 > a.pQH) {
            awVar.tj(2);
        }
        awVar.FD(this.title).FB(this.qqQ).FC(this.hSX).Fy(str);
        if (!bg.mA(this.fOa)) {
            awVar.a(FileOp.c(this.fOa, 0, -1), this.qqQ, this.title, this.qqO, this.qqP);
        } else if (!(bg.mA(this.qqI) || n.GR() == null)) {
            n.GR();
            Bitmap gS = com.tencent.mm.ah.b.gS(this.qqI);
            if (gS != null) {
                awVar.a(d.K(gS), "", "");
            }
        }
        if (iVar != null) {
            awVar.dx(iVar.token, iVar.tPO);
        }
        awVar.tn(this.qqL);
        awVar.FG(this.fUR);
        awVar.FH(this.qqK);
        awVar.e(null, null, null, i4, i5);
        if (z) {
            awVar.to(1);
        } else {
            awVar.to(0);
        }
        awVar.br(list2);
        if (!bg.mA(this.appId)) {
            awVar.FE(this.appId);
            awVar.FF(this.appName);
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
        awVar.aj(linkedList);
        awVar.a(com_tencent_mm_protocal_c_ajq);
        int commit = awVar.commit();
        if (this.qqR != null) {
            this.qqR.gB(commit);
            e.qdB.b(this.qqR);
        }
        ae.beH().bdz();
        this.fCi.finish();
        return false;
    }

    public final boolean a(int i, Intent intent) {
        return false;
    }

    public final boolean bis() {
        if (!(this.hqW == null || this.hqW.isRecycled())) {
            this.hqW.recycle();
        }
        return false;
    }
}
