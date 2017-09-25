package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import com.tencent.mm.e.a.ok;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.ajq;
import com.tencent.mm.protocal.c.bcs;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import java.util.LinkedList;
import java.util.List;

public final class ak implements y {
    private String desc = "";
    public MMActivity fCi;
    public String fFW = "";
    private boolean fGu = false;
    public String fKz = "";
    public String fVB = "";
    public ProgressDialog isv = null;
    private View jIM = null;
    public ProgressBar jKM;
    private int qqL;
    private b qqR = null;
    private boolean qvc = false;
    private Bitmap qvd = null;
    private c qvf = new c<ok>(this) {
        final /* synthetic */ ak qxI;

        {
            this.qxI = r2;
            this.usg = ok.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            ok okVar = (ok) bVar;
            w.i("MicroMsg.SightWidget", "on sight send result callback, type %d", new Object[]{Integer.valueOf(okVar.fVy.type)});
            switch (okVar.fVy.type) {
                case 1:
                    w.i("MicroMsg.SightWidget", "come event done");
                    this.qxI.fVB = okVar.fVy.fVB;
                    this.qxI.fFW = okVar.fVy.fVC;
                    if (this.qxI.isv != null) {
                        this.qxI.isv.dismiss();
                    }
                    this.qxI.qxG.ak(this.qxI.fVB, false);
                    this.qxI.jKM.setVisibility(8);
                    if (okVar.fVy.fVA && this.qxI.qvg != null) {
                        this.qxI.bjh();
                    }
                    w.i("MicroMsg.SightWidget", "mux finish %B videoPath %s %d md5 %s", new Object[]{Boolean.valueOf(okVar.fVy.fVA), okVar.fVy.fVB, Long.valueOf(FileOp.ki(okVar.fVy.fVB)), this.qxI.fFW});
                    break;
            }
            return false;
        }
    };
    aw qvg = null;
    public a qxG;
    public com.tencent.mm.plugin.sight.decode.ui.c qxH = null;

    public ak(MMActivity mMActivity) {
        this.fCi = mMActivity;
    }

    public final void C(Bundle bundle) {
        this.qqR = b.o(this.fCi.getIntent());
        this.fKz = this.fCi.getIntent().getStringExtra("KSightThumbPath");
        this.fVB = this.fCi.getIntent().getStringExtra("KSightPath");
        this.fFW = this.fCi.getIntent().getStringExtra("sight_md5");
        this.qqL = this.fCi.getIntent().getIntExtra("Ksnsupload_source", 0);
        com.tencent.mm.sdk.b.b okVar = new ok();
        okVar.fVy.type = 2;
        com.tencent.mm.sdk.b.a.urY.m(okVar);
        if (bg.mA(this.fVB)) {
            this.fVB = bg.ap(okVar.fVz.fVE, "");
            w.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[]{this.fVB});
        }
        this.fFW = bg.mA(this.fFW) ? bg.ap(okVar.fVz.fVC, "") : this.fFW;
        w.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[]{this.fKz, this.fVB, this.fFW});
        com.tencent.mm.sdk.b.a.urY.b(this.qvf);
    }

    public final void D(Bundle bundle) {
    }

    public final boolean biq() {
        return true;
    }

    public final View bir() {
        this.jIM = View.inflate(this.fCi, g.pIF, null);
        this.qxG = (a) this.jIM.findViewById(f.Kd);
        this.qxG.sF(com.tencent.mm.bg.a.fromDPToPix(this.fCi, 90));
        this.jKM = (ProgressBar) this.jIM.findViewById(f.cbI);
        this.fCi.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.jIM.findViewById(f.bAe).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ak qxI;

            {
                this.qxI = r1;
            }

            public final void onClick(View view) {
                if (FileOp.aO(this.qxI.fVB)) {
                    if (this.qxI.qxH != null) {
                        this.qxI.qxH.dismiss();
                        this.qxI.qxH = null;
                    }
                    this.qxI.qxH = new com.tencent.mm.plugin.sight.decode.ui.c(this.qxI.fCi);
                    com.tencent.mm.plugin.sight.decode.ui.c cVar = this.qxI.qxH;
                    String str = this.qxI.fVB;
                    String str2 = this.qxI.fKz;
                    cVar.hIN = str;
                    cVar.imagePath = str2;
                    cVar = this.qxI.qxH;
                    cVar.fXT = 0;
                    cVar.puA = 0;
                    cVar.lHi = 1;
                    this.qxI.qxH.show();
                    return;
                }
                w.i("MicroMsg.SightWidget", "click videopath is not exist " + this.qxI.fVB);
            }
        });
        w.i("MicroMsg.SightWidget", "videoPath " + this.fVB + " thumbPath " + this.fKz + " " + FileOp.ki(this.fVB) + " " + FileOp.ki(this.fKz));
        if (FileOp.aO(this.fVB)) {
            this.qxG.ak(this.fVB, false);
            this.jKM.setVisibility(8);
            w.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[]{this.fVB, this.fFW});
        } else {
            n EK = i.EK(this.fKz);
            if (EK != null) {
                this.qvd = EK.ww();
                if (i.k(this.qvd)) {
                    this.qxG.y(this.qvd);
                }
            }
            this.jKM.setVisibility(0);
        }
        return this.jIM;
    }

    public final boolean a(int i, int i2, b.a.d.i iVar, String str, List<String> list, ajq com_tencent_mm_protocal_c_ajq, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        if (this.qvg != null) {
            return false;
        }
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
        this.qvg.e(null, null, null, i4, i5);
        if (FileOp.aO(this.fVB)) {
            bjh();
            return true;
        }
        w.i("MicroMsg.SightWidget", "commit file is not exist " + this.fVB);
        Context context = this.fCi;
        this.fCi.getString(j.dIO);
        this.isv = com.tencent.mm.ui.base.g.a(context, this.fCi.getString(j.pMr), true, new OnCancelListener(this) {
            final /* synthetic */ ak qxI;

            {
                this.qxI = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.qxI.qvg = null;
            }
        });
        return true;
    }

    public final void bjh() {
        if (!this.qvc) {
            if (this.qvg.j(this.fVB, this.fKz, this.desc, this.fFW)) {
                com.tencent.mm.sdk.b.b okVar = new ok();
                okVar.fVy.type = 0;
                okVar.fVy.fVA = true;
                com.tencent.mm.sdk.b.a.urY.m(okVar);
                this.qvc = true;
                int commit = this.qvg.commit();
                if (this.qqR != null) {
                    this.qqR.gB(commit);
                    e.qdB.b(this.qqR);
                }
                ae.beR().qxd = 0;
                Intent intent = new Intent();
                intent.putExtra("sns_resume_state", false);
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                intent.setClass(this.fCi, En_424b8e16.class);
                intent.addFlags(67108864);
                this.fCi.startActivity(intent);
                this.fCi.setResult(-1);
                this.fCi.finish();
                return;
            }
            w.i("MicroMsg.SightWidget", "videopath " + FileOp.ki(this.fVB) + " thumb: " + FileOp.ki(this.fKz));
            s.makeText(this.fCi, j.eRk, 0).show();
        }
    }

    public final boolean a(int i, Intent intent) {
        return false;
    }

    public final boolean bis() {
        if (this.isv != null) {
            this.isv.dismiss();
        }
        com.tencent.mm.sdk.b.a.urY.c(this.qvf);
        if (i.k(this.qvd)) {
            this.qvd.recycle();
        }
        return false;
    }
}
