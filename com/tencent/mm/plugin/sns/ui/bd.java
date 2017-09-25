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
import com.tencent.mm.plugin.sns.model.av;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.protocal.c.bcs;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;

public final class bd implements y {
    private String appName = "";
    private MMActivity fCi;
    private String fTO = "";
    private int qqL;
    private b qqR = null;
    private boolean qul = false;
    private boolean qum = false;
    private WXMediaMessage qun = null;
    private String qvm = "";

    public bd(MMActivity mMActivity) {
        this.fCi = mMActivity;
    }

    public final void C(Bundle bundle) {
        this.qqR = b.o(this.fCi.getIntent());
        this.qvm = this.fCi.getIntent().getStringExtra("Kdescription");
        this.fTO = bg.ap(this.fCi.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bg.ap(this.fCi.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.qul = this.fCi.getIntent().getBooleanExtra("KThrid_app", false);
        this.qum = this.fCi.getIntent().getBooleanExtra("KSnsAction", false);
        this.qqL = this.fCi.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.qun = new Req(this.fCi.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    }

    public final void D(Bundle bundle) {
    }

    public final boolean biq() {
        return true;
    }

    public final View bir() {
        return null;
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, ajq com_tencent_mm_protocal_c_ajq, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        ae.beH();
        aw a = av.a(this.qun, str, this.fTO, this.appName);
        if (a == null) {
            w.e("MicroMsg.TextWidget", "packHelper == null, %s, %s", new Object[]{this.fTO, this.appName});
            return false;
        }
        pInt.value = a.jFe;
        if (i3 > a.pQH) {
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
        return false;
    }
}
