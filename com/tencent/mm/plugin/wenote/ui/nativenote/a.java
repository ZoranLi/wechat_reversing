package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.b.b;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.h5note.WNNoteFavVoiceBaseView;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.s;

public final class a implements b {
    private boolean fQy = true;
    ImageButton lKD;
    public String sun = "";
    ImageButton sxh;
    ImageButton sxi;
    ImageButton sxj;
    public LinearLayout sxk;
    public ImageView sxl;
    public TextView sxm;
    WNNoteFavVoiceBaseView sxn;
    private int sxo = 1;
    public boolean sxp = false;
    private String sxq = null;
    private int sxr = -1;
    private boolean sxs = false;
    public a syy = this;

    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ a syz;
        final /* synthetic */ Context val$context;

        AnonymousClass1(a aVar, Context context) {
            this.syz = aVar;
            this.val$context = context;
        }

        public final void onClick(View view) {
            c.bBv().Y(-1, false);
            Intent intent = new Intent();
            intent.putExtra("max_select_count", 9);
            intent.putExtra("query_source_type", 13);
            intent.putExtra("query_media_type", 3);
            intent.putExtra("show_header_view", true);
            intent.putExtra("send_btn_string", this.val$context.getString(R.l.ehy));
            Parcelable parcelable = (SightParams) intent.getParcelableExtra("KEY_SIGHT_PARAMS");
            if (parcelable == null) {
                parcelable = new SightParams(4, 0);
            }
            String str = "microMsg_" + System.currentTimeMillis();
            String str2 = e.gSz + str + ".mp4";
            String str3 = e.gSz + str + ".jpeg";
            int intExtra = intent.getIntExtra("key_pick_local_media_duration", 60);
            SightParams sightParams = new SightParams(4, 1);
            sightParams.nAD = 2;
            sightParams.mode = 0;
            if (sightParams.nAE == null) {
                sightParams.nAE = new VideoTransPara();
            }
            sightParams.nAE.duration = intExtra;
            sightParams.h(str, str2, str3, e.gSz + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
            intent.putExtra("KEY_SIGHT_PARAMS", parcelable);
            intent.putExtra("record_video_force_sys_camera", false);
            intent.putExtra("record_video_is_sight_capture", true);
            intent.addFlags(67108864);
            intent.putExtra("key_can_select_video_and_pic", true);
            d.b(this.val$context, "gallery", ".ui.GalleryEntryUI", intent, 4097);
        }
    }

    class AnonymousClass2 implements OnClickListener {
        final /* synthetic */ a syz;
        final /* synthetic */ Context val$context;

        AnonymousClass2(a aVar, Context context) {
            this.syz = aVar;
            this.val$context = context;
        }

        public final void onClick(View view) {
            c.bBv().Y(-1, false);
            w.i("MicroMsg.WNNoteFootPannel", "summerper checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a((Activity) this.val$context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null))});
            if (com.tencent.mm.pluginsdk.i.a.a((Activity) this.val$context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                Intent intent = new Intent();
                intent.putExtra("MMActivity.OverrideExitAnimation", R.a.aRo);
                intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.aQX);
                intent.putExtra("map_view_type", 3);
                d.b(this.val$context, "location", ".ui.RedirectUI", intent, 4098);
            }
        }
    }

    class AnonymousClass3 implements OnClickListener {
        final /* synthetic */ a syz;
        final /* synthetic */ Context val$context;

        AnonymousClass3(a aVar, Context context) {
            this.syz = aVar;
            this.val$context = context;
        }

        public final void onClick(View view) {
            c.bBv().Y(-1, false);
            if (f.rZ()) {
                Intent intent = new Intent(this.val$context, FileExplorerUI.class);
                intent.putExtra("key_title", this.val$context.getString(R.l.eiS));
                ((Activity) this.val$context).startActivityForResult(intent, 4099);
                return;
            }
            s.eP(this.val$context);
        }
    }

    class AnonymousClass4 implements OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.wenote.model.nativenote.b.a syA;
        final /* synthetic */ a syz;
        final /* synthetic */ Context val$context;

        AnonymousClass4(a aVar, Context context, com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar2) {
            this.syz = aVar;
            this.val$context = context;
            this.syA = aVar2;
        }

        public final void onClick(View view) {
            c.bBv().Y(-1, false);
            w.i("MicroMsg.WNNoteFootPannel", "summerper checkPermission checkMicrophone[%b],stack[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a((Activity) this.val$context, "android.permission.RECORD_AUDIO", 80, null, null)), bg.bJZ()});
            if (com.tencent.mm.pluginsdk.i.a.a((Activity) this.val$context, "android.permission.RECORD_AUDIO", 80, null, null)) {
                if (!this.syz.sxp) {
                    if (!f.rZ()) {
                        s.eP(this.val$context);
                        return;
                    } else if (com.tencent.mm.n.a.aJ(this.val$context) || com.tencent.mm.n.a.aH(this.val$context)) {
                        return;
                    }
                }
                if (!this.syz.sxp) {
                    g.oUh.i(14547, new Object[]{Integer.valueOf(3)});
                    if (c.bBv().F("", "", 1)) {
                        this.syA.bBq();
                        return;
                    }
                    if (com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.bCg().atu()) {
                        com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.bCg().adL();
                    }
                    this.syz.sxp = true;
                    this.syz.sxk.setVisibility(0);
                    this.syz.sxl.setVisibility(8);
                    com.tencent.mm.plugin.wenote.model.a.a hVar = new h();
                    hVar.type = 4;
                    hVar.suJ = false;
                    hVar.suE = Boolean.valueOf(true);
                    hVar.suQ = this.val$context.getString(R.l.ejT);
                    this.syz.sun = "speex";
                    hVar.fKw = 1;
                    hVar.suI = c.bBv().bBB();
                    hVar.suC = this.syz.sun;
                    hVar.lKv = com.tencent.mm.plugin.wenote.model.e.Lj(hVar.toString());
                    rm rmVar = new rm();
                    rmVar.NY(hVar.lKv);
                    rmVar.NV(hVar.suC);
                    k bBS = k.bBS();
                    if (bBS != null) {
                        c.bBv().a(hVar, bBS.bBU(), false, false);
                    } else {
                        c.bBv().a(hVar, null, false, false);
                    }
                    if (j.bBf().a(bg.getInt(hVar.suI.substring(7), 0), this.syz.sxm, this.syz.syy, hVar.suC, com.tencent.mm.plugin.wenote.model.e.o(rmVar)) < 0) {
                        this.syA.bBr();
                        this.syz.a(this.syA);
                    }
                }
            }
        }
    }

    class AnonymousClass5 implements OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.wenote.model.nativenote.b.a syA;
        final /* synthetic */ a syz;

        AnonymousClass5(a aVar, com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar2) {
            this.syz = aVar;
            this.syA = aVar2;
        }

        public final void onClick(View view) {
            this.syz.a(this.syA);
        }
    }

    public final void bBm() {
        a(null);
    }

    public final void a(com.tencent.mm.plugin.wenote.model.nativenote.b.a aVar) {
        if (this.sxp) {
            this.sxp = false;
            this.sxk.setVisibility(8);
            this.sxl.setVisibility(0);
            j.bBf().bBg();
            String bBh = j.bBf().bBh();
            int i = (int) j.bBf().duration;
            int aw = (int) com.tencent.mm.ay.b.aw((long) i);
            int bBA = c.bBv().bBA();
            com.tencent.mm.plugin.wenote.model.a.a wS = c.bBv().wS(bBA);
            if (!com.tencent.mm.a.e.aO(bBh)) {
                w.e("MicroMsg.WNNoteFootPannel", "voicePath not exist, remove data from datalist and ui");
                c.bBv().X(bBA, false);
                if (aVar != null) {
                    aVar.wP(bBA);
                }
                com.tencent.mm.plugin.wenote.model.a.a eVar = new com.tencent.mm.plugin.wenote.model.a.e();
                eVar.content = "";
                eVar.sut = true;
                eVar.suz = false;
                c.bBv().a(bBA, eVar, true);
            } else if (bBA != -1 && wS != null && wS.getType() == 4) {
                ((h) wS).suE = Boolean.valueOf(false);
                ((h) wS).type = 4;
                ((h) wS).suJ = true;
                ((h) wS).suQ = "";
                ((h) wS).length = i;
                ((h) wS).suP = com.tencent.mm.ay.b.s(ab.getContext(), aw).toString();
                ((h) wS).fQH = com.tencent.mm.ay.a.Mf() + "/fav_fileicon_recording.png";
                ((h) wS).fQE = bBh;
                c bBv = c.bBv();
                if (bBv.svl != null) {
                    bBv.svl.L(bBA, 0);
                }
            }
        }
    }
}
