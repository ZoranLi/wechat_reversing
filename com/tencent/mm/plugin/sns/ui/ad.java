package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import b.a.d.i;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.protocal.c.bcs;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;

public final class ad implements y {
    private String appName = "";
    private MMActivity fCi;
    private String fTO = "";
    private int qqL;
    private b qqR = null;
    private boolean qul = false;
    private boolean qum = false;
    private WXMediaMessage qun = null;
    private String qvm = "";
    private boolean qvn = false;

    public ad(MMActivity mMActivity, boolean z) {
        this.fCi = mMActivity;
        this.qvn = z;
    }

    public final void C(Bundle bundle) {
        this.qqR = b.o(this.fCi.getIntent());
        this.qvm = this.fCi.getIntent().getStringExtra("Kdescription");
        this.fTO = bg.ap(this.fCi.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bg.ap(this.fCi.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.qul = this.fCi.getIntent().getBooleanExtra("KThrid_app", false);
        this.qum = this.fCi.getIntent().getBooleanExtra("KSnsAction", false);
        this.qqL = this.fCi.getIntent().getIntExtra("Ksnsupload_source", 0);
        Bundle bundleExtra = this.fCi.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.qun = new Req(bundleExtra).message;
        }
    }

    public final void D(Bundle bundle) {
    }

    public final boolean biq() {
        return this.qvn;
    }

    public final View bir() {
        return null;
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, ajq com_tencent_mm_protocal_c_ajq, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        if (this.fCi.isFinishing()) {
            return false;
        }
        aw awVar = new aw(2);
        pInt.value = awVar.jFe;
        if (i3 > a.pQH) {
            awVar.tj(2);
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
        if (z) {
            awVar.to(1);
        } else {
            awVar.to(0);
        }
        if (iVar != null) {
            awVar.dx(iVar.token, iVar.tPO);
        }
        awVar.tn(this.qqL);
        if (this.qul) {
            awVar.tn(5);
        }
        if (this.qum && this.qun != null) {
            awVar.Fz(this.qun.mediaTagName);
            awVar.Q(this.fTO, this.qun.messageExt, this.qun.messageAction);
        }
        awVar.e(null, null, null, i4, i5);
        awVar.Fy(str).a(com_tencent_mm_protocal_c_ajq).aj(linkedList).tl(i).tm(i2).br(list2);
        int commit = awVar.commit();
        if (this.qqR != null) {
            this.qqR.gB(commit);
            e.qdB.b(this.qqR);
        }
        this.fCi.setResult(-1);
        ae.beH().bdz();
        this.fCi.finish();
        return true;
    }

    public final boolean a(int i, Intent intent) {
        return false;
    }

    public final boolean bis() {
        return false;
    }
}
