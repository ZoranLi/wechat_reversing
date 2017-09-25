package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.bb;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.dd;
import com.tencent.mm.e.a.kt;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.ab.a;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.y;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.tools.ShowImageUI;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.y.e;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AppAttachDownloadUI extends MMActivity implements a, j.a, e {
    private long fGM;
    private String fOu;
    private boolean fQy;
    private String fSs;
    private au fTk;
    private String fyF;
    private String hhE;
    private String iAS;
    private ProgressBar jKM;
    private f kOv;
    private Button lKM;
    private View lKQ;
    private Button lWP;
    private String mLP;
    private String mediaId;
    private int moU;
    private MMImageView oBr;
    private ImageView oBs;
    private ab sDx;
    private TextView vdD;
    private View vxm;
    private TextView vxn;
    private TextView vxo;
    private boolean vxp;
    private com.tencent.mm.t.f.a vxq;
    private boolean vxr = false;
    private boolean vxs = false;
    private boolean vxt = true;
    private int vxu = Downloads.MIN_RETYR_AFTER;
    private LinearLayout vxv;
    private LinearLayout vxw;

    static /* synthetic */ void a(AppAttachDownloadUI appAttachDownloadUI, boolean z) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (z) {
            b ddVar = new dd();
            ddVar.fGW.fGM = appAttachDownloadUI.fGM;
            com.tencent.mm.sdk.b.a.urY.m(ddVar);
            switch (appAttachDownloadUI.moU) {
                case 0:
                    arrayList.add(appAttachDownloadUI.getString(R.l.eLH));
                    arrayList.add(appAttachDownloadUI.getString(R.l.ebN));
                    arrayList2.add(Integer.valueOf(0));
                    arrayList2.add(Integer.valueOf(3));
                    if (ddVar.fGX.fGu) {
                        arrayList.add(appAttachDownloadUI.getString(R.l.ebR));
                        arrayList2.add(Integer.valueOf(4));
                        break;
                    }
                    break;
                case 6:
                    arrayList.add(appAttachDownloadUI.getString(R.l.eLH));
                    arrayList.add(appAttachDownloadUI.getString(R.l.ebN));
                    arrayList2.add(Integer.valueOf(0));
                    arrayList2.add(Integer.valueOf(3));
                    Long LB = com.tencent.mm.pluginsdk.b.a.LB(appAttachDownloadUI.iAS);
                    if (ddVar.fGX.fGu || (LB != null && g.m(appAttachDownloadUI.uSU.uTo, LB.longValue()))) {
                        arrayList.add(appAttachDownloadUI.getString(R.l.ebR));
                        arrayList2.add(Integer.valueOf(4));
                    }
                    if (d.Jt("favorite")) {
                        arrayList.add(appAttachDownloadUI.getString(R.l.eGa));
                        arrayList2.add(Integer.valueOf(2));
                        break;
                    }
                    break;
                default:
                    arrayList.add(appAttachDownloadUI.getString(R.l.eLH));
                    arrayList2.add(Integer.valueOf(0));
                    break;
            }
        } else if (d.Jt("favorite")) {
            arrayList.add(appAttachDownloadUI.getString(R.l.eGa));
            arrayList2.add(Integer.valueOf(2));
        }
        if (com.tencent.mm.sdk.a.b.bIu() && appAttachDownloadUI.fyF.startsWith("fts_template") && appAttachDownloadUI.fyF.endsWith(".zip")) {
            arrayList.add(appAttachDownloadUI.getString(R.l.ebI));
            arrayList2.add(Integer.valueOf(5));
        }
        com.tencent.mm.ui.base.g.a(appAttachDownloadUI, null, arrayList, arrayList2, null, false, new com.tencent.mm.ui.base.g.d(appAttachDownloadUI) {
            final /* synthetic */ AppAttachDownloadUI vxx;

            {
                this.vxx = r1;
            }

            public final void bN(int i, int i2) {
                switch (i2) {
                    case 0:
                        AppAttachDownloadUI.c(this.vxx);
                        return;
                    case 2:
                        AppAttachDownloadUI.d(this.vxx);
                        return;
                    case 3:
                        AppAttachDownloadUI.e(this.vxx);
                        return;
                    case 4:
                        AppAttachDownloadUI.f(this.vxx);
                        return;
                    case 5:
                        AppAttachDownloadUI.g(this.vxx);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    static /* synthetic */ void c(AppAttachDownloadUI appAttachDownloadUI) {
        boolean z = false;
        if (appAttachDownloadUI.vxq != null && (appAttachDownloadUI.vxq.hhu != 0 || appAttachDownloadUI.vxq.hhq > 26214400)) {
            z = true;
        }
        Intent intent = new Intent(appAttachDownloadUI, MsgRetransmitUI.class);
        intent.putExtra("Retr_Msg_content", appAttachDownloadUI.fSs);
        intent.putExtra("Retr_Msg_Type", 2);
        intent.putExtra("Retr_Msg_Id", appAttachDownloadUI.fTk.field_msgId);
        intent.putExtra("Retr_Big_File", z);
        appAttachDownloadUI.startActivity(intent);
    }

    static /* synthetic */ void d(AppAttachDownloadUI appAttachDownloadUI) {
        b cbVar = new cb();
        com.tencent.mm.pluginsdk.model.e.a(cbVar, appAttachDownloadUI.fTk);
        cbVar.fFA.activity = appAttachDownloadUI;
        cbVar.fFA.fFH = 39;
        com.tencent.mm.sdk.b.a.urY.m(cbVar);
    }

    static /* synthetic */ void e(AppAttachDownloadUI appAttachDownloadUI) {
        Intent intent = new Intent(appAttachDownloadUI, AppAttachFileListUI.class);
        intent.setFlags(67108864);
        appAttachDownloadUI.startActivity(intent);
        com.tencent.mm.plugin.report.service.g.oUh.i(11168, new Object[]{Integer.valueOf(6), Integer.valueOf(1)});
    }

    static /* synthetic */ void f(AppAttachDownloadUI appAttachDownloadUI) {
        Intent intent = new Intent(appAttachDownloadUI, ChattingSendDataToDeviceUI.class);
        intent.putExtra("Retr_Msg_Id", appAttachDownloadUI.fTk.field_msgId);
        appAttachDownloadUI.startActivity(intent);
    }

    static /* synthetic */ void g(AppAttachDownloadUI appAttachDownloadUI) {
        b bbVar = new bb();
        bbVar.fEA.fEB = 27;
        bbVar.fEA.fEC = 1;
        bbVar.fEA.filePath = appAttachDownloadUI.bTA().field_fileFullPath;
        com.tencent.mm.sdk.b.a.urY.m(bbVar);
        s.makeText(com.tencent.mm.sdk.platformtools.ab.getContext(), String.format("current template is %d", new Object[]{Integer.valueOf(com.tencent.mm.as.d.hPo)}), 1).show();
    }

    static /* synthetic */ void r(AppAttachDownloadUI appAttachDownloadUI) {
        com.tencent.mm.pluginsdk.model.app.b bTA = appAttachDownloadUI.bTA();
        if (bTA == null) {
            w.e("MicroMsg.AppAttachDownloadUI", "open fail, info is null");
        } else if (bTA.field_fileFullPath == null || bTA.field_fileFullPath.length() == 0) {
            w.e("MicroMsg.AppAttachDownloadUI", "open fail, field fileFullPath is null");
        } else {
            com.tencent.mm.pluginsdk.ui.tools.a.b(appAttachDownloadUI, bTA.field_fileFullPath, appAttachDownloadUI.iAS, 1);
            appAttachDownloadUI.lKM.setEnabled(false);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        init();
    }

    private void init() {
        boolean z;
        zi(R.l.bKu);
        this.fGM = getIntent().getLongExtra("app_msg_id", -1);
        if (this.fGM == -1) {
            z = false;
        } else {
            ap.yY();
            this.fTk = c.wT().cA(this.fGM);
            if (this.fTk == null || this.fTk.field_msgId == 0 || this.fTk.field_content == null) {
                z = false;
            } else {
                this.vxp = o.dH(this.fTk.field_talker);
                this.fSs = this.fTk.field_content;
                if (this.vxp && this.fTk.field_isSend == 0) {
                    String str = this.fTk.field_content;
                    if (this.vxp && str != null) {
                        str = ay.gj(str);
                    }
                    this.fSs = str;
                }
                this.vxq = com.tencent.mm.t.f.a.ek(this.fSs);
                if (this.vxq == null) {
                    w.e("MicroMsg.AppAttachDownloadUI", "summerapp parse msgContent error, %s", new Object[]{this.fSs});
                    z = false;
                } else {
                    if (u.mA(this.vxq.fCW) && !u.mA(this.vxq.hhx)) {
                        w.e("MicroMsg.AppAttachDownloadUI", "summerapp msgContent format error, %s", new Object[]{this.fSs});
                        this.vxq.fCW = this.vxq.hhx.hashCode();
                    }
                    this.moU = this.vxq.type;
                    this.mediaId = this.vxq.fCW;
                    this.fyF = u.mz(this.vxq.title);
                    this.iAS = u.mz(this.vxq.hhr).toLowerCase();
                    this.mLP = u.mz(this.vxq.filemd5);
                    this.fOu = u.mz(this.vxq.fOu);
                    this.hhE = u.mz(this.vxq.hhE);
                    w.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams msgId[%d], sender[%d], msgContent[%s], appType[%d], mediaId[%s], fileName[%s]", new Object[]{Long.valueOf(this.fGM), Integer.valueOf(this.fTk.field_isSend), this.fSs, Integer.valueOf(this.moU), this.mediaId, this.fyF});
                    com.tencent.mm.pluginsdk.model.app.b bTA = bTA();
                    if (bTA == null) {
                        w.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo is null");
                        this.vxs = false;
                    } else {
                        File file = new File(bTA.field_fileFullPath);
                        if (bTA.field_offset > 0) {
                            this.vxs = true;
                        } else {
                            this.vxs = false;
                        }
                        w.i("MicroMsg.AppAttachDownloadUI", "summerapp initParams attInfo field_fileFullPath[%s], field_offset[%d], isDownloadStarted[%b]", new Object[]{bTA.field_fileFullPath, Long.valueOf(bTA.field_offset), Boolean.valueOf(this.vxs)});
                    }
                    z = a(bTA) ? com.tencent.mm.pluginsdk.ui.tools.a.a(this, bTA.field_fileFullPath, this.iAS, 1) : true;
                }
            }
        }
        if (z) {
            File file2 = new File(com.tencent.mm.compatible.util.e.gSx);
            if (!file2.exists()) {
                file2.mkdir();
            }
            an.abL().c(this);
            KC();
            return;
        }
        finish();
    }

    protected void onDestroy() {
        an.abL().f(this);
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        ap.vd().a(221, this);
        ap.vd().a(728, this);
        b ktVar = new kt();
        ktVar.fRn.fRo = true;
        com.tencent.mm.sdk.b.a.urY.a(ktVar, getMainLooper());
        w.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI req pause auto download logic");
        this.lKM.setEnabled(true);
    }

    protected void onPause() {
        ap.vd().b(221, this);
        ap.vd().b(728, this);
        super.onPause();
        b ktVar = new kt();
        ktVar.fRn.fRo = false;
        com.tencent.mm.sdk.b.a.urY.a(ktVar, getMainLooper());
        w.d("MicroMsg.AppAttachDownloadUI", "AppAttachDownloadUI cancel pause auto download logic");
    }

    protected final void KC() {
        this.oBr = (MMImageView) findViewById(R.h.bKv);
        this.lKQ = findViewById(R.h.bKm);
        this.jKM = (ProgressBar) findViewById(R.h.bKl);
        this.oBs = (ImageView) findViewById(R.h.bKq);
        this.lWP = (Button) findViewById(R.h.bKa);
        this.lKM = (Button) findViewById(R.h.bKk);
        this.vxm = findViewById(R.h.bKb);
        this.vdD = (TextView) findViewById(R.h.bKh);
        this.vxn = (TextView) findViewById(R.h.bKc);
        this.vxo = (TextView) findViewById(R.h.bKg);
        this.vxv = (LinearLayout) findViewById(R.h.bKi);
        this.vxw = (LinearLayout) findViewById(R.h.cbE);
        this.oBs.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AppAttachDownloadUI vxx;

            {
                this.vxx = r1;
            }

            public final void onClick(View view) {
                this.vxx.lKQ.setVisibility(8);
                this.vxx.lWP.setVisibility(0);
                this.vxx.vxm.setVisibility(8);
                w.i("MicroMsg.AppAttachDownloadUI", "summerapp stopBtn downloadAppAttachScene[%s]", new Object[]{this.vxx.sDx});
                if (this.vxx.sDx != null) {
                    ab a = this.vxx.sDx;
                    a aVar = this.vxx;
                    if (!a.sDL) {
                        com.tencent.mm.modelcdntran.g.El().iP(a.hGx);
                        a.sDF = an.abL().LW(a.mediaId);
                    }
                    w.i("MicroMsg.NetSceneDownloadAppAttach", "summerbig pause listener[%s], info[%s], justSaveFile[%b], stack[%s]", new Object[]{aVar, a.sDF, Boolean.valueOf(a.sDL), bg.bJZ()});
                    if (a.sDF != null) {
                        if (a.sDF.field_status == 101 && aVar != null) {
                            aVar.bDg();
                        }
                        a.sDF.field_status = 102;
                        if (!a.sDL) {
                            an.abL().c(a.sDF, new String[0]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                com.tencent.mm.sdk.e.c l = this.vxx.bTA();
                if (l != null && l.field_status != 199) {
                    w.i("MicroMsg.AppAttachDownloadUI", "summerapp stopBtn onClick but scene is null and set status[%d] paused", new Object[]{Long.valueOf(l.field_status)});
                    l.field_status = 102;
                    an.abL().c(l, new String[0]);
                }
            }
        });
        this.lWP.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AppAttachDownloadUI vxx;

            {
                this.vxx = r1;
            }

            public final void onClick(View view) {
                this.vxx.lKQ.setVisibility(0);
                this.vxx.lWP.setVisibility(8);
                this.vxx.vxm.setVisibility(0);
                if (this.vxx.bTz()) {
                    com.tencent.mm.sdk.e.c l = this.vxx.bTA();
                    if (l != null) {
                        l.field_status = 101;
                        l.field_lastModifyTime = bg.Ny();
                        an.abL().c(l, new String[0]);
                    }
                    this.vxx.sDx = new ab(this.vxx.fGM, this.vxx.mediaId, this.vxx.kOv);
                    ap.vd().a(this.vxx.sDx, 0);
                }
            }
        });
        this.lKM.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AppAttachDownloadUI vxx;

            {
                this.vxx = r1;
            }

            public final void onClick(View view) {
                this.vxx.vxt = true;
                AppAttachDownloadUI.r(this.vxx);
            }
        });
        switch (this.moU) {
            case 0:
            case 7:
                if (!bg.Qm(this.iAS)) {
                    this.oBr.setImageResource(R.k.dto);
                    break;
                } else {
                    this.oBr.setImageResource(R.g.bbY);
                    break;
                }
            case 2:
                this.oBr.setImageResource(R.g.bbY);
                break;
            case 4:
                this.oBr.setImageResource(R.k.dtr);
                break;
            case 6:
                this.oBr.setImageResource(q.LV(this.iAS));
                break;
            default:
                this.oBr.setImageResource(R.k.dto);
                break;
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AppAttachDownloadUI vxx;

            {
                this.vxx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.vxx.sDx != null) {
                    ap.vd().c(this.vxx.sDx);
                }
                this.vxx.finish();
                return true;
            }
        });
        this.fQy = getIntent().getBooleanExtra("app_show_share", true);
        if (this.fQy) {
            a(0, R.k.dsS, new OnMenuItemClickListener(this) {
                final /* synthetic */ AppAttachDownloadUI vxx;

                {
                    this.vxx = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppAttachDownloadUI.a(this.vxx, this.vxx.vxr);
                    return false;
                }
            });
        }
        this.vxr = false;
        com.tencent.mm.pluginsdk.model.app.b bTA = bTA();
        boolean z = (bTA == null || !new File(bTA.field_fileFullPath).exists()) ? false : bTA.azf() || (this.fTk.field_isSend == 1 && bTA.field_isUpload);
        if (z) {
            w.i("MicroMsg.AppAttachDownloadUI", "summerapp isCanOpenFile");
            this.vxr = true;
            bTB();
        } else if (bTA != null && bTA.azf() && !new File(bTA.field_fileFullPath).exists()) {
            w.i("MicroMsg.AppAttachDownloadUI", "summerapp set fail info[%s]", new Object[]{bTA});
            this.vxv.setVisibility(8);
            this.vxw.setVisibility(0);
        } else if (!this.vxr) {
            this.kOv = new f(this) {
                final /* synthetic */ AppAttachDownloadUI vxx;

                {
                    this.vxx = r1;
                }

                public final void a(int i, int i2, k kVar) {
                    float f;
                    if (i2 == 0) {
                        f = 0.0f;
                    } else {
                        f = (((float) i) * 100.0f) / ((float) i2);
                    }
                    if (i < i2 && this.vxx.lKQ.getVisibility() != 0) {
                        this.vxx.lKQ.setVisibility(0);
                        this.vxx.lWP.setVisibility(8);
                        this.vxx.vxm.setVisibility(0);
                    }
                    this.vxx.jKM.setProgress((int) f);
                }
            };
            switch (this.moU) {
                case 0:
                case 6:
                    if (this.vxs) {
                        this.lWP.setVisibility(0);
                    } else {
                        this.lWP.setVisibility(8);
                    }
                    this.lKQ.setVisibility(8);
                    this.vxm.setVisibility(8);
                    this.lKM.setVisibility(8);
                    this.vdD.setVisibility(8);
                    this.vxo.setVisibility(0);
                    if (this.fyF.equals("")) {
                        this.vxo.setText(getString(R.l.eFm));
                    } else {
                        this.vxo.setText(this.fyF);
                    }
                    String mimeType = getMimeType();
                    if (mimeType == null || mimeType.equals("")) {
                        this.vdD.setText(getString(R.l.ebJ));
                    } else {
                        this.vdD.setText(getString(R.l.ebK));
                    }
                    if (bg.Qm(this.iAS)) {
                        this.vdD.setVisibility(8);
                        break;
                    }
                    break;
                case 2:
                    this.lKQ.setVisibility(0);
                    this.vxm.setVisibility(0);
                    this.lWP.setVisibility(8);
                    this.lKM.setVisibility(8);
                    this.vxo.setVisibility(8);
                    this.vdD.setVisibility(8);
                    if (bTz()) {
                        this.sDx = new ab(this.fGM, this.mediaId, this.kOv);
                        ap.vd().a(this.sDx, 0);
                        break;
                    }
                    break;
                case 7:
                    if (this.vxs) {
                        this.lWP.setVisibility(0);
                    } else {
                        this.lWP.setVisibility(8);
                    }
                    this.lKQ.setVisibility(8);
                    this.vxm.setVisibility(8);
                    this.lKM.setVisibility(8);
                    this.vxo.setVisibility(8);
                    this.vdD.setVisibility(8);
                    this.vdD.setText(getString(R.l.ebK));
                    break;
            }
            w.i("MicroMsg.AppAttachDownloadUI", "summerapp progressCallBack[%s], isDownloadFinished[%b], isDownloadStarted[%b]", new Object[]{this.kOv, Boolean.valueOf(this.vxr), Boolean.valueOf(this.vxs)});
            if (!this.vxr && !this.vxs) {
                this.lKQ.setVisibility(0);
                this.lWP.setVisibility(8);
                this.vxm.setVisibility(0);
                if (bTz()) {
                    this.sDx = new ab(this.fGM, this.mediaId, this.kOv);
                    ap.vd().a(this.sDx, 0);
                }
            }
        }
    }

    private boolean bTz() {
        com.tencent.mm.pluginsdk.model.app.b bVar;
        boolean z;
        int i = -1;
        com.tencent.mm.pluginsdk.model.app.b bTA = bTA();
        String str;
        if (bTA == null) {
            l.b(this.fGM, this.fSs, null);
            bTA = bTA();
            if (bTA != null) {
                String str2 = "MicroMsg.AppAttachDownloadUI";
                str = "summerapp tryInitAttachInfo newInfo systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], signature len[%d]";
                Object[] objArr = new Object[8];
                objArr[0] = Long.valueOf(bTA.uxb);
                objArr[1] = Long.valueOf(bTA.field_totalLen);
                objArr[2] = bTA.field_fileFullPath;
                objArr[3] = Long.valueOf(bTA.field_type);
                objArr[4] = bTA.field_mediaId;
                objArr[5] = Long.valueOf(bTA.field_msgInfoId);
                objArr[6] = Boolean.valueOf(bTA.field_isUpload);
                if (bTA.field_signature != null) {
                    i = bTA.field_signature.length();
                }
                objArr[7] = Integer.valueOf(i);
                w.i(str2, str, objArr);
                if (this.vxq.hhu != 0 || this.vxq.hhq > 26214400) {
                    boolean z2;
                    if (u.mA(bTA.field_signature)) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    bVar = bTA;
                    z = z2;
                }
            }
            z = true;
            bVar = bTA;
        } else {
            File file = new File(bTA.field_fileFullPath);
            if (bTA.field_status == 199 && !file.exists()) {
                w.i("MicroMsg.AppAttachDownloadUI", "summerapp tryInitAttachInfo info exist but file not!");
                l.b(this.fGM, this.fSs, null);
            }
            str = "MicroMsg.AppAttachDownloadUI";
            String str3 = "summerapp tryInitAttachInfo info exist systemRowid [%d], totalLen[%d], field_fileFullPath[%s], type[%d], mediaId[%s], msgid[%d], upload[%b], file.exists[%b], status[%d], signature len[%d]";
            Object[] objArr2 = new Object[10];
            objArr2[0] = Long.valueOf(bTA.uxb);
            objArr2[1] = Long.valueOf(bTA.field_totalLen);
            objArr2[2] = bTA.field_fileFullPath;
            objArr2[3] = Long.valueOf(bTA.field_type);
            objArr2[4] = bTA.field_mediaId;
            objArr2[5] = Long.valueOf(bTA.field_msgInfoId);
            objArr2[6] = Boolean.valueOf(bTA.field_isUpload);
            objArr2[7] = Boolean.valueOf(file.exists());
            objArr2[8] = Long.valueOf(bTA.field_status);
            if (bTA.field_signature != null) {
                i = bTA.field_signature.length();
            }
            objArr2[9] = Integer.valueOf(i);
            w.i(str, str3, objArr2);
            z = true;
            bVar = bTA;
        }
        if (!z) {
            ap.vd().a(new y(bVar, this.hhE, this.mLP, this.fyF, this.iAS, this.fOu), 0);
        }
        return z;
    }

    private String getMimeType() {
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(this.fSs);
        String str = null;
        if (ek.hhr != null && ek.hhr.length() > 0) {
            str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(ek.hhr);
        }
        if (str != null && str.length() != 0) {
            return str;
        }
        w.w("MicroMsg.AppAttachDownloadUI", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
        return "*/" + ek.hhr;
    }

    private com.tencent.mm.pluginsdk.model.app.b bTA() {
        com.tencent.mm.pluginsdk.model.app.b eb = an.abL().eb(this.fGM);
        if (eb != null) {
            w.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId [%d] stack[%s]", new Object[]{Long.valueOf(this.fGM), u.NC()});
        } else {
            eb = l.Mh(this.mediaId);
            if (eb == null) {
                w.i("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo by msgId and mediaId is null stack[%s]", new Object[]{u.NC()});
            } else if (!(eb.field_msgInfoId == this.fGM || com.tencent.mm.a.e.aO(eb.field_fileFullPath))) {
                l.b(this.fGM, this.fSs, null);
                final com.tencent.mm.pluginsdk.model.app.b eb2 = an.abL().eb(this.fGM);
                if (eb2 == null) {
                    w.w("MicroMsg.AppAttachDownloadUI", "summerapp getAppAttachInfo create new info from local but failed stack[%s]", new Object[]{u.NC()});
                } else {
                    com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                        final /* synthetic */ AppAttachDownloadUI vxx;

                        public final void run() {
                            boolean c;
                            long currentTimeMillis = System.currentTimeMillis();
                            long p = com.tencent.mm.a.e.p(eb.field_fileFullPath, eb2.field_fileFullPath);
                            if (p > 0) {
                                eb2.field_offset = p;
                                if (AppAttachDownloadUI.a(eb2)) {
                                    eb2.field_status = 199;
                                }
                                c = an.abL().c(eb2, new String[0]);
                            } else {
                                c = false;
                            }
                            w.i("MicroMsg.AppAttachDownloadUI", "summerapp copyAttachFromLocal size[%d], id[%d, %d], ret[%b], new status[%d], take[%d]ms", new Object[]{Long.valueOf(p), Long.valueOf(eb.field_msgInfoId), Long.valueOf(eb2.field_msgInfoId), Boolean.valueOf(c), Long.valueOf(eb2.field_status), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        }
                    }, "copyAttachFromLocal");
                }
            }
        }
        return eb;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.tencent.mm.pluginsdk.ui.tools.a.a(this, i, i2, intent, this.vxt, R.l.ebP, R.l.ebQ, 1);
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        com.tencent.mm.pluginsdk.model.app.b bTA = bTA();
        if (bTA != null) {
            long j = bTA.field_totalLen;
            this.vxn.setText(getString(R.l.ebL, new Object[]{u.ay(bTA.field_offset), u.ay(j)}));
            int i = bTA.field_totalLen == 0 ? 0 : (int) ((bTA.field_offset * 100) / bTA.field_totalLen);
            w.v("MicroMsg.AppAttachDownloadUI", "summerapp attach progress:" + i + " offset:" + r4 + " totallen:" + j);
            this.jKM.setProgress(i);
            if (bTA.field_status == 199 && i >= 100 && !this.vxr) {
                this.vxr = true;
                if (bTA != null) {
                    Toast.makeText(this, getString(R.l.ebU) + " : " + bTA.field_fileFullPath.replaceFirst(com.tencent.mm.compatible.util.e.hgs, com.tencent.mm.compatible.util.e.gSw), this.vxu).show();
                    com.tencent.mm.pluginsdk.ui.tools.a.a(this, bTA.field_fileFullPath, this.iAS, 1);
                }
                af.f(new Runnable(this) {
                    final /* synthetic */ AppAttachDownloadUI vxx;

                    {
                        this.vxx = r1;
                    }

                    public final void run() {
                        this.vxx.bTB();
                    }
                }, 200);
            }
            if (this.lKQ.getVisibility() != 0 && i < 100 && !bTA.field_isUpload && bTA.field_status == 101) {
                w.i("MicroMsg.AppAttachDownloadUI", "summerapp still downloading updateProgress progress[%d]", new Object[]{Integer.valueOf(i)});
                this.lKQ.setVisibility(0);
                this.lWP.setVisibility(8);
                this.vxm.setVisibility(0);
            }
        }
    }

    private void bTB() {
        Intent intent;
        switch (this.moU) {
            case 0:
            case 6:
                if (!bTC()) {
                    return;
                }
                if (bg.Qm(this.iAS)) {
                    com.tencent.mm.pluginsdk.model.app.b bTA = bTA();
                    Intent intent2 = new Intent(this, ShowImageUI.class);
                    intent2.putExtra("key_message_id", this.fTk.field_msgId);
                    intent2.putExtra("key_image_path", bTA.field_fileFullPath);
                    intent2.putExtra("key_favorite", true);
                    startActivity(intent2);
                    finish();
                    return;
                }
                String mimeType = getMimeType();
                this.vdD.setVisibility(0);
                this.lKQ.setVisibility(8);
                this.vxm.setVisibility(8);
                this.lWP.setVisibility(8);
                this.vxo.setVisibility(0);
                if (this.fyF.equals("")) {
                    this.vxo.setText(getString(R.l.eFm));
                } else {
                    this.vxo.setText(this.fyF);
                }
                if (mimeType == null || mimeType.equals("")) {
                    this.lKM.setVisibility(8);
                    this.vdD.setText(getString(R.l.ebJ));
                    return;
                }
                this.lKM.setVisibility(0);
                this.vdD.setText(getString(R.l.ebK));
                return;
            case 2:
                if (bTC()) {
                    intent = new Intent(this, ImageGalleryUI.class);
                    intent.putExtra("img_gallery_msg_id", this.fTk.field_msgId);
                    intent.putExtra("img_gallery_talker", this.fTk.field_talker);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0, 0);
                    return;
                }
                return;
            case 7:
                intent = new Intent();
                intent.putExtra("App_MsgId", this.fGM);
                setResult(-1, intent);
                finish();
                return;
            default:
                this.lKM.setVisibility(0);
                this.lKQ.setVisibility(8);
                this.vxm.setVisibility(8);
                return;
        }
    }

    private boolean bTC() {
        com.tencent.mm.pluginsdk.model.app.b bTA = bTA();
        if (bTA == null) {
            return true;
        }
        if (com.tencent.mm.a.e.aO(bTA.field_fileFullPath)) {
            this.lKQ.setVisibility(8);
            this.vxm.setVisibility(8);
            this.lWP.setVisibility(8);
            return true;
        }
        this.vxv.setVisibility(8);
        this.vxw.setVisibility(0);
        return false;
    }

    protected final int getLayoutId() {
        return R.i.dak;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd type[%d], [%d, %d, %s]", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar.getType() != 221 && kVar.getType() != 728) {
            return;
        }
        if (kVar.getType() == 728 && i == 0 && i2 == 0) {
            com.tencent.mm.pluginsdk.model.app.b bTA = bTA();
            String str2 = "MicroMsg.AppAttachDownloadUI";
            String str3 = "summerapp onSceneEnd CheckBigFileDownload ok signature len[%d] start NetSceneDownloadAppAttach";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(bTA.field_signature == null ? -1 : bTA.field_signature.length());
            w.i(str2, str3, objArr);
            this.sDx = new ab(this.fGM, this.mediaId, this.kOv);
            ap.vd().a(this.sDx, 0);
            return;
        }
        if (this.sDx == null && (kVar instanceof ab)) {
            ab abVar = (ab) kVar;
            com.tencent.mm.pluginsdk.model.app.b bTA2 = bTA();
            if (!(bTA2 == null || u.mA(bTA2.field_mediaSvrId) || !bTA2.field_mediaSvrId.equals(abVar.getMediaId()))) {
                this.sDx = abVar;
                w.i("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd reset downloadAppAttachScene[%s] by mediaSvrId[%s]", new Object[]{this.sDx, bTA2.field_mediaSvrId});
            }
        }
        if (i != 0 || i2 != 0) {
            if (i2 != 0 && com.tencent.mm.sdk.a.b.bIu()) {
                Toast.makeText(this, "errCode[" + i2 + "]", 0).show();
            }
            if (i2 == -5103059) {
                this.vxw.setVisibility(0);
                this.vxv.setVisibility(8);
                return;
            }
            this.lKQ.setVisibility(8);
            this.lWP.setVisibility(0);
            this.vxm.setVisibility(8);
            w.e("MicroMsg.AppAttachDownloadUI", "summerapp onSceneEnd, download fail, type = " + kVar.getType() + " errType = " + i + ", errCode = " + i2);
        }
    }

    public final void bDg() {
        Toast.makeText(this, R.l.ebS, 0).show();
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        init();
    }

    private static boolean a(com.tencent.mm.pluginsdk.model.app.b bVar) {
        if (bVar == null) {
            return false;
        }
        File file = new File(bVar.field_fileFullPath);
        if (file.exists() && file.length() == bVar.field_totalLen) {
            return true;
        }
        return false;
    }
}
