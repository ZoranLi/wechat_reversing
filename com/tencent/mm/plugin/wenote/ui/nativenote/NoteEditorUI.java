package com.tencent.mm.plugin.wenote.ui.nativenote;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.aj;
import android.text.ClipboardManager;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.plugin.wenote.model.a.d;
import com.tencent.mm.plugin.wenote.model.a.f;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.r;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.g;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.ui.h5note.WNNoteFavVoiceBaseView;
import com.tencent.mm.plugin.wenote.ui.nativenote.a.c;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.snackbar.b.b;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

public class NoteEditorUI extends MMActivity implements com.tencent.mm.plugin.wenote.model.nativenote.b.a, com.tencent.mm.plugin.wenote.model.nativenote.manager.g.a {
    private RecyclerView aak;
    private long fGM = -1;
    private long hEY = -1;
    private ae hgN;
    private ProgressDialog isv = null;
    protected b mnV = new b(this) {
        final /* synthetic */ NoteEditorUI syl;

        {
            this.syl = r1;
        }

        public final void aAt() {
            com.tencent.mm.sdk.b.b fpVar = new fp();
            fpVar.fKp.type = 35;
            com.tencent.mm.sdk.b.a.urY.m(fpVar);
        }
    };
    private boolean soD = false;
    private boolean swv = false;
    private p sxC = null;
    private k sxO;
    private c sxP;
    private LinearLayout sxQ;
    private a sxR = null;
    private RelativeLayout sxS = null;
    private g sxT = null;
    private boolean sxU = false;
    private boolean sxV = false;
    private boolean sxW = false;
    private String sxX = "";
    private boolean sxY = false;
    private com.tencent.mm.plugin.wenote.ui.nativenote.a.a sxZ;
    private boolean sya = false;
    private boolean syb = false;
    private a syc;
    private rm syd;
    private boolean sye = false;
    private final Object syf = new Object();
    private float syg = 0.0f;
    private float syh = 0.0f;
    OnTouchListener syi = new OnTouchListener(this) {
        final /* synthetic */ NoteEditorUI syl;

        {
            this.syl = r1;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.syl.syg = motionEvent.getX();
                this.syl.syh = motionEvent.getY();
            }
            float abs;
            if (motionEvent.getAction() == 1 && this.syl.aak.j(motionEvent.getX(), motionEvent.getY()) == null) {
                abs = Math.abs(this.syl.syg - motionEvent.getX());
                float abs2 = Math.abs(this.syl.syh - motionEvent.getY());
                if (abs < 30.0f && abs2 < 30.0f) {
                    int size = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().size();
                    com.tencent.mm.plugin.wenote.model.a.a wS = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().wS(size - 1);
                    if (wS != null) {
                        boolean z;
                        if (!wS.sut) {
                            wS.sut = true;
                            wS.suz = false;
                            wS.suv = -1;
                            this.syl.sxP.bc(size - 1);
                        }
                        if ((wS.sux == null || !wS.sux.hasFocus()) && ((wS.suw == null || !wS.suw.hasFocus()) && (wS.suy == null || !wS.suy.hasFocus()))) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (z) {
                            this.syl.a(Boolean.valueOf(true), false);
                        }
                    }
                }
            } else if (motionEvent.getAction() == 2) {
                abs = Math.abs(this.syl.syg - motionEvent.getX());
                float abs3 = Math.abs(this.syl.syh - motionEvent.getY());
                if ((abs > 120.0f || abs3 > 120.0f) && !this.syl.sya) {
                    this.syl.a(Boolean.valueOf(false), false);
                    ap.vL().e(new Runnable(this) {
                        final /* synthetic */ AnonymousClass21 syx;

                        {
                            this.syx = r1;
                        }

                        public final void run() {
                            if (!this.syx.syl.sxR.sxp) {
                                this.syx.syl.ea(100);
                            }
                            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().bBy();
                        }
                    }, 100);
                }
            }
            return false;
        }
    };
    private boolean syj = false;
    private boolean syk = false;

    class a extends com.tencent.mm.plugin.wenote.ui.nativenote.a.b {
        final /* synthetic */ NoteEditorUI syl;

        a(NoteEditorUI noteEditorUI) {
            this.syl = noteEditorUI;
        }

        public final void bCc() {
            ap.vL().D(new Runnable(this.syl) {
                final /* synthetic */ NoteEditorUI syl;

                {
                    this.syl = r1;
                }

                public final void run() {
                    int i = -1;
                    try {
                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) this.syl.aak.Zf;
                        View a = linearLayoutManager.a(linearLayoutManager.getChildCount() - 1, -1, true, false);
                        if (a != null) {
                            i = LinearLayoutManager.be(a);
                        }
                        com.tencent.mm.plugin.wenote.model.a.a wS = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().wS(i);
                        if (wS != null && wS.getType() == 4 && !((h) wS).suJ) {
                            this.syl.L(i, 0);
                        }
                    } catch (NullPointerException e) {
                    }
                }
            });
        }

        public final void bCd() {
            ap.vL().D(/* anonymous class already generated */);
        }
    }

    public void onCreate(Bundle bundle) {
        this.swv = getIntent().getBooleanExtra("from_session", false);
        this.fGM = getIntent().getLongExtra("message_id", -1);
        this.hEY = getIntent().getLongExtra("key_detail_info_id", -1);
        this.soD = getIntent().getBooleanExtra("edit_status", false);
        this.hgN = new ae();
        w.i("MicroMsg.NoteEditorUI", "OnCreate MainActivity, before setContentView");
        e.f(this);
        super.onCreate(bundle);
        w.i("MicroMsg.NoteEditorUI", "OnCreate MainActivity, after setContentView");
        com.tencent.mm.plugin.wenote.model.a.a eVar = new com.tencent.mm.plugin.wenote.model.a.e();
        eVar.content = "";
        eVar.sut = true;
        eVar.suz = false;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c bBv = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv();
        bBv.jnH = new ArrayList();
        bBv.svl = this;
        bBv.svm = new rm();
        bBv.svn = 0;
        bBv.svo = 0;
        bBv.svp = 0;
        bBv.svq = false;
        if (this.soD) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().a(eVar);
        }
        View view = this.uSU.ipu;
        this.aak = (RecyclerView) findViewById(R.h.cTb);
        this.sxQ = (LinearLayout) view.findViewById(R.h.bKJ);
        this.sxQ.setVisibility(8);
        this.sxS = (RelativeLayout) findViewById(R.h.cSS);
        this.sxS.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ NoteEditorUI syl;

            {
                this.syl = r1;
            }

            public final void onClick(View view) {
                if (this.syl.sxT != null) {
                    this.syl.sxT.svO.dismiss();
                }
                this.syl.sxS.setVisibility(8);
            }
        });
        this.sxT = new g(this, this.sxS);
        this.sxT.svP = this;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        this.sxZ = new com.tencent.mm.plugin.wenote.ui.nativenote.a.a(this);
        this.sxZ.syD = j.aG(this)[1];
        this.aak.a(this.sxZ);
        this.aak.Zl = true;
        this.syc = new a(this);
        this.aak.a(this.syc);
        this.sxO = new k(this, this);
        this.sxO.fFx = this.hEY;
        this.sxO.swv = this.swv;
        this.sxP = new c(this.sxO);
        this.aak.a(this.sxP);
        if (!this.swv) {
            this.aak.setOnTouchListener(this.syi);
        }
        this.aak.ZB.aaf = 0;
        this.aak.ZB.aai = 0;
        this.aak.ZB.aah = 0;
        this.aak.ZB.aag = 120;
        ((aj) this.aak.ZB).acX = false;
        jh(false);
        if (this.swv) {
            this.sxQ.setVisibility(8);
        } else {
            this.sxR = new a();
            a aVar = this.sxR;
            View view2 = this.sxQ;
            aVar.sxn = (WNNoteFavVoiceBaseView) view2.findViewById(R.h.cMZ);
            aVar.lKD = (ImageButton) view2.findViewById(R.h.cNa);
            aVar.sxh = (ImageButton) view2.findViewById(R.h.cSX);
            aVar.sxh.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.a.AnonymousClass1(aVar, this));
            aVar.sxi = (ImageButton) view2.findViewById(R.h.cSY);
            aVar.sxi.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.a.AnonymousClass2(aVar, this));
            aVar.sxj = (ImageButton) view2.findViewById(R.h.cSW);
            aVar.sxj.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.a.AnonymousClass3(aVar, this));
            aVar.sxl = (ImageView) view2.findViewById(R.h.cSZ);
            aVar.sxl.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.a.AnonymousClass4(aVar, this, this));
            aVar.sxk = (LinearLayout) view2.findViewById(R.h.coM);
            aVar.sxm = (TextView) view2.findViewById(R.h.cNL);
            aVar.sxk.setOnClickListener(new com.tencent.mm.plugin.wenote.ui.nativenote.a.AnonymousClass5(aVar, this));
            getWindow().setSoftInputMode(18);
        }
        if (!this.soD) {
            this.sxC = com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.fnL), false, null);
        }
        a(1, R.l.eYj, R.g.bhb, new OnMenuItemClickListener(this) {
            final /* synthetic */ NoteEditorUI syl;

            {
                this.syl = r1;
            }

            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean onMenuItemClick(android.view.MenuItem r7) {
                /*
                r6 = this;
                r2 = 1;
                r1 = 0;
                r3 = new com.tencent.mm.ui.widget.e;
                r0 = r6.syl;
                r0 = r0.uSU;
                r0 = r0.uTo;
                r4 = com.tencent.mm.ui.widget.e.wuP;
                r3.<init>(r0, r4, r1);
                r0 = new com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$11$1;
                r0.<init>(r6);
                r3.qJf = r0;
                r0 = new com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$11$2;
                r0.<init>(r6);
                r3.qJg = r0;
                r0 = r6.syl;
                r0 = r0.swv;
                if (r0 != 0) goto L_0x0037;
            L_0x0025:
                r0 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv();
                r4 = r0.svp;
                if (r4 > 0) goto L_0x0031;
            L_0x002d:
                r0 = r0.svo;
                if (r0 <= 0) goto L_0x0035;
            L_0x0031:
                r0 = r2;
            L_0x0032:
                if (r0 != 0) goto L_0x0037;
            L_0x0034:
                return r1;
            L_0x0035:
                r0 = r1;
                goto L_0x0032;
            L_0x0037:
                r0 = r6.syl;
                r0 = r0.swv;
                if (r0 != 0) goto L_0x0062;
            L_0x003f:
                r0 = r6.syl;
                r0 = r0.uSU;
                r0 = r0.uTG;
                if (r0 != r2) goto L_0x0062;
            L_0x0047:
                r0 = r6.syl;
                r0.aHf();
                r0 = r6.syl;
                r0.bBo();
                r0 = r6.syl;
                r0 = r0.hgN;
                r2 = new com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$11$3;
                r2.<init>(r6, r3);
                r4 = 100;
                r0.postDelayed(r2, r4);
                goto L_0x0034;
            L_0x0062:
                r3.bzh();
                goto L_0x0034;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.11.onMenuItemClick(android.view.MenuItem):boolean");
            }
        });
        qP(getString(R.l.ejQ));
        kt(true);
        a(new OnMenuItemClickListener(this) {
            final /* synthetic */ NoteEditorUI syl;

            {
                this.syl = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.syl.goBack();
                this.syl.finish();
                return true;
            }
        }, R.g.bbC);
        e.g(this);
    }

    public void onBackPressed() {
        goBack();
        super.onBackPressed();
    }

    protected final int getLayoutId() {
        return R.i.dkn;
    }

    private void goBack() {
        if (!this.swv) {
            com.tencent.mm.sdk.b.b fpVar;
            if (!(this.sxV || this.soD)) {
                fpVar = new fp();
                fpVar.fKp.type = 19;
                fpVar.fKp.fFx = this.hEY;
                fpVar.fKp.fKw = -1;
                com.tencent.mm.sdk.b.a.urY.m(fpVar);
                if (!(!fpVar.fKq.fKF)) {
                    this.sxV = true;
                    this.sxW = true;
                } else {
                    return;
                }
            }
            this.hgN.postDelayed(new Runnable(this) {
                final /* synthetic */ NoteEditorUI syl;

                {
                    this.syl = r1;
                }

                public final void run() {
                    this.syl.aHf();
                }
            }, 200);
            this.sxR.a(this);
            final String bBC = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().bBC();
            String Kn = com.tencent.mm.plugin.wenote.b.a.Kn(Pattern.compile("<object[^>]*>", 2).matcher(bBC).replaceAll("#WNNoteNode#[ThisisNoteNodeObj]#WNNoteNode#"));
            if (!(bg.mA(Kn) || Kn.length() == 0)) {
                Kn = Pattern.compile("\\s*|\t|\r|\n").matcher(Kn).replaceAll("");
            }
            if (bg.mA(Kn)) {
                fpVar = new fp();
                fpVar.fKp.type = 12;
                fpVar.fKp.fFx = this.hEY;
                com.tencent.mm.sdk.b.a.urY.m(fpVar);
            } else if (this.soD) {
                w.i("MicroMsg.NoteEditorUI", "leave noteeditorui, do savewnnotefavitem");
                ap.vL().D(new Runnable(this) {
                    final /* synthetic */ NoteEditorUI syl;

                    public final void run() {
                        this.syl.aH(bBC, true);
                    }
                });
            } else if (this.sxV) {
                w.i("MicroMsg.NoteEditorUI", "leave noteeditorui, do updateWNNoteFavitem");
                ap.vL().D(new Runnable(this) {
                    final /* synthetic */ NoteEditorUI syl;

                    public final void run() {
                        this.syl.aH(bBC, false);
                    }
                });
            }
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.sxO != null) {
            k kVar = this.sxO;
            kVar.swI.KH();
            kVar.swB = -1;
            k.swu = null;
            kVar.swt = null;
        }
        if (com.tencent.mm.plugin.wenote.model.a.bAZ().stz != null) {
            com.tencent.mm.plugin.wenote.model.a.bAZ().stz.stD.clear();
            com.tencent.mm.plugin.wenote.model.a.bAZ().stz.soC.clear();
            com.tencent.mm.plugin.wenote.model.a.bAZ().stz.stC.clear();
        }
        com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a bCg = com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.bCg();
        bCg.adL();
        bCg.jXn = null;
        bCg.jXr = null;
        bCg.gJv.clear();
        com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.szl = null;
        if (com.tencent.mm.plugin.wenote.model.j.bBi() != null) {
            com.tencent.mm.plugin.wenote.model.j.destroy();
        }
    }

    private boolean ea(long j) {
        int bBx = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().bBx();
        if (bBx >= 0) {
            com.tencent.mm.plugin.wenote.model.a.a wS = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().wS(bBx);
            wS.sut = false;
            wS.suz = false;
            L(bBx, j);
            return true;
        }
        this.hgN.post(new Runnable(this) {
            final /* synthetic */ NoteEditorUI syl;

            {
                this.syl = r1;
            }

            public final void run() {
                WXRTEditText bBQ = this.syl.sxO.bBQ();
                if (bBQ != null) {
                    bBQ.clearFocus();
                }
            }
        });
        return false;
    }

    public final void L(final int i, long j) {
        Handler handler = getWindow().getDecorView().getHandler();
        if (handler != null) {
            handler.postDelayed(new Runnable(this) {
                final /* synthetic */ NoteEditorUI syl;

                public final void run() {
                    w.i("MicroMsg.NoteEditorUI", "huahuastart: onNotifyItemChanged,position is %d", new Object[]{Integer.valueOf(i)});
                    this.syl.sxP.bc(i);
                    w.i("MicroMsg.NoteEditorUI", "huahuaend: onNotifyItemChanged,position is %d", new Object[]{Integer.valueOf(i)});
                }
            }, j);
        }
    }

    public final void wP(int i) {
        try {
            this.sxP.be(i);
        } catch (Exception e) {
            w.e("MicroMsg.NoteEditorUI", "onNotifyItemRemoved error,positionStart:%d", new Object[]{Integer.valueOf(i)});
        }
    }

    public final void wO(int i) {
        try {
            this.sxP.bd(i);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NoteEditorUI", e, "", new Object[0]);
            w.e("MicroMsg.NoteEditorUI", "onNotifyItemInserted error,positionStart:%d", new Object[]{Integer.valueOf(i)});
        }
    }

    public final void dz(int i, int i2) {
        try {
            this.sxP.R(i, i2);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NoteEditorUI", e, "", new Object[0]);
            w.e("MicroMsg.NoteEditorUI", "onNotifyitemRangeInsert error,positionStart:%d,count:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public final void dA(int i, int i2) {
        try {
            this.sxP.P(i, i2);
        } catch (Exception e) {
            w.e("MicroMsg.NoteEditorUI", "onNotifyItemRangeChanged error,positionStart:%d,count:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        }
    }

    public final void bCb() {
        try {
            this.sxP.aab.notifyChanged();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NoteEditorUI", e, "", new Object[0]);
            w.i("MicroMsg.NoteEditorUI", "onNotifyDataChanged error");
        }
    }

    public final void jh(boolean z) {
        w.i("MicroMsg.NoteEditorUI", "notifyNoteDataListFresh,force:%B", new Object[]{Boolean.valueOf(z)});
        if (this.sxU || com.tencent.mm.plugin.wenote.model.a.bAZ().stz == null) {
            boolean z2;
            String str = "MicroMsg.NoteEditorUI";
            String str2 = "notifyNoteDataListFresh,isInitDataList:%B,SubCoreWNNoteMsg.getCore().getWnNoteBase() == null :%B";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.sxU);
            if (com.tencent.mm.plugin.wenote.model.a.bAZ().stz == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            w.e(str, str2, objArr);
            return;
        }
        r rVar;
        if (this.swv) {
            w.i("MicroMsg.NoteEditorUI", "notifyNoteDataListFresh,open from Session");
            if (com.tencent.mm.plugin.wenote.model.a.bAZ().stz.stA == null) {
                w.e("MicroMsg.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mWNNoteData == null ");
                return;
            }
            rVar = (r) com.tencent.mm.plugin.wenote.model.a.bAZ().stz.stC.get(Long.toString(com.tencent.mm.plugin.wenote.model.a.bAZ().stz.stA.fGM));
        } else {
            w.i("MicroMsg.NoteEditorUI", "notifyNoteDataListFresh,open from fav");
            if (com.tencent.mm.plugin.wenote.model.a.bAZ().stz.stB == null) {
                w.e("MicroMsg.NoteEditorUI", "notifyNoteDataListFresh,SubCoreWNNoteMsg.getCore().getWnNoteBase().mClickedFavItemInfo == null ");
                return;
            }
            rVar = (r) com.tencent.mm.plugin.wenote.model.a.bAZ().stz.stC.get(Long.toString(com.tencent.mm.plugin.wenote.model.a.bAZ().stz.stB.field_localId));
        }
        if (rVar != null) {
            this.sxU = true;
            l(rVar.suR, false);
        }
    }

    public final void a(Boolean bool, boolean z) {
        if (this.sya && !z) {
            return;
        }
        if (bool.booleanValue()) {
            if (!(this.swv || this.soD || this.sxV)) {
                this.sxX = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().bBC();
                this.sxV = true;
            }
            if (this.sxQ.getVisibility() != 0) {
                this.sxQ.setVisibility(0);
            }
            aHj();
            return;
        }
        if (!(this.sxR.sxp || this.sxQ.getVisibility() == 8)) {
            this.sxQ.setVisibility(8);
        }
        if (this.uSU.uTG == 1) {
            super.aHf();
        }
        this.syb = false;
    }

    public final void bit() {
        super.bit();
    }

    public final void aHj() {
        if (!this.syb) {
            super.aHj();
            this.syb = true;
        }
    }

    public final void aHf() {
        super.aHf();
    }

    public final void bBo() {
        if (!this.sxY) {
            a(Boolean.valueOf(false), false);
            ap.vL().e(new Runnable(this) {
                final /* synthetic */ NoteEditorUI syl;

                {
                    this.syl = r1;
                }

                public final void run() {
                    if (!this.syl.sxR.sxp) {
                        this.syl.ea(100);
                    }
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().bBy();
                }
            }, 100);
        }
    }

    public final synchronized void l(final Object obj, boolean z) {
        w.i("MicroMsg.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData,updatebyhtml:%B", new Object[]{Boolean.valueOf(z)});
        if (z || !this.sye) {
            this.sye = z;
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ NoteEditorUI syl;

                public final void run() {
                    synchronized (this.syl.syf) {
                        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().bBw();
                        ArrayList arrayList = (ArrayList) obj;
                        if (arrayList == null) {
                            return;
                        }
                        w.i("MicroMsg.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData start");
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            com.tencent.mm.plugin.wenote.model.a.k kVar = (com.tencent.mm.plugin.wenote.model.a.k) it.next();
                            switch (kVar.type) {
                                case 1:
                                    com.tencent.mm.plugin.wenote.model.a.e eVar = (com.tencent.mm.plugin.wenote.model.a.e) kVar;
                                    if (eVar.content.length() > 400) {
                                        com.tencent.mm.plugin.wenote.model.nativenote.a.a.Lq(eVar.content);
                                    } else {
                                        Object obj;
                                        String str = eVar.content;
                                        String str2 = "<br/>";
                                        int length = str2.length();
                                        if (bg.mA(str) || str.length() < length) {
                                            obj = null;
                                        } else {
                                            int i = 0;
                                            while (i < str.length()) {
                                                int i2 = i + length;
                                                if (i2 > str.length()) {
                                                    obj = null;
                                                } else if (str2.equalsIgnoreCase(str.substring(i, i2))) {
                                                    i = i2;
                                                } else {
                                                    obj = null;
                                                }
                                            }
                                            obj = 1;
                                        }
                                        if (obj != null) {
                                            eVar.content = eVar.content.substring(0, eVar.content.length() - 5);
                                        }
                                    }
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().a(eVar);
                                    break;
                                case 2:
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().a((com.tencent.mm.plugin.wenote.model.a.c) kVar);
                                    break;
                                case 3:
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().a((d) kVar);
                                    break;
                                case 4:
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().a((h) kVar);
                                    break;
                                case 5:
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().a((com.tencent.mm.plugin.wenote.model.a.b) kVar);
                                    break;
                                case 6:
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().a((com.tencent.mm.plugin.wenote.model.a.g) kVar);
                                    break;
                                default:
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().a((f) kVar);
                                    break;
                            }
                        }
                        w.i("MicroMsg.NoteEditorUI", "notifyNoteDataListFresh,setUpNoteData finish");
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass3 syn;

                            {
                                this.syn = r1;
                            }

                            public final void run() {
                                synchronized (this.syn.syl.syf) {
                                    this.syn.syl.bCb();
                                    if (this.syn.syl.sxC != null) {
                                        this.syn.syl.sxC.dismiss();
                                    }
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onActivityResult(int r11, int r12, android.content.Intent r13) {
        /*
        r10 = this;
        super.onActivityResult(r11, r12, r13);
        r0 = "MicroMsg.NoteEditorUI";
        r1 = "onActivityResult reqCode: %d, retCod: %d";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = java.lang.Integer.valueOf(r11);
        r2[r3] = r4;
        r3 = 1;
        r4 = java.lang.Integer.valueOf(r12);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
        r0 = 4101; // 0x1005 float:5.747E-42 double:2.026E-320;
        if (r11 == r0) goto L_0x0024;
    L_0x0021:
        r0 = 1;
        r10.syk = r0;
    L_0x0024:
        r0 = -1;
        if (r12 == r0) goto L_0x002b;
    L_0x0027:
        r0 = 0;
        r10.syj = r0;
    L_0x002a:
        return;
    L_0x002b:
        r0 = 1;
        r10.syj = r0;
        r6 = 2;
        switch(r11) {
            case 4096: goto L_0x0046;
            case 4097: goto L_0x0115;
            case 4098: goto L_0x0295;
            case 4099: goto L_0x0327;
            case 4100: goto L_0x0032;
            case 4101: goto L_0x00aa;
            default: goto L_0x0032;
        };
    L_0x0032:
        r0 = r6;
    L_0x0033:
        if (r0 == 0) goto L_0x002a;
    L_0x0035:
        r1 = 1;
        if (r1 != r0) goto L_0x0412;
    L_0x0038:
        r0 = r10.uSU;
        r0 = r0.uTo;
        r1 = com.tencent.mm.R.l.eia;
        r1 = r10.getString(r1);
        com.tencent.mm.ui.base.g.bl(r0, r1);
        goto L_0x002a;
    L_0x0046:
        if (r13 != 0) goto L_0x005c;
    L_0x0048:
        r3 = 0;
    L_0x0049:
        if (r13 != 0) goto L_0x0064;
    L_0x004b:
        r4 = 0;
    L_0x004c:
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
        if (r0 == 0) goto L_0x006c;
    L_0x0052:
        r0 = "MicroMsg.NoteEditorUI";
        r1 = "want to send record msg, but toUser is null";
        com.tencent.mm.sdk.platformtools.w.w(r0, r1);
        goto L_0x002a;
    L_0x005c:
        r0 = "Select_Conv_User";
        r3 = r13.getStringExtra(r0);
        goto L_0x0049;
    L_0x0064:
        r0 = "custom_send_text";
        r4 = r13.getStringExtra(r0);
        goto L_0x004c;
    L_0x006c:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wT();
        r8 = r10.fGM;
        r2 = r0.cA(r8);
        r0 = r2.field_msgId;
        r8 = r10.fGM;
        r0 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1));
        if (r0 == 0) goto L_0x008b;
    L_0x0081:
        r0 = "MicroMsg.NoteEditorUI";
        r1 = "want to send record msg, but message info is null";
        com.tencent.mm.sdk.platformtools.w.w(r0, r1);
        goto L_0x002a;
    L_0x008b:
        r0 = r10.uSU;
        r0 = r0.uTo;
        r1 = com.tencent.mm.R.l.eit;
        r1 = r10.getString(r1);
        r5 = 0;
        r7 = 0;
        r5 = com.tencent.mm.ui.base.g.a(r0, r1, r5, r7);
        r7 = com.tencent.mm.u.ap.vL();
        r0 = new com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$5;
        r1 = r10;
        r0.<init>(r1, r2, r3, r4, r5);
        r7.D(r0);
        r0 = r6;
        goto L_0x0033;
    L_0x00aa:
        if (r13 != 0) goto L_0x00c2;
    L_0x00ac:
        r0 = 0;
        r1 = r0;
    L_0x00ae:
        if (r13 != 0) goto L_0x00cb;
    L_0x00b0:
        r0 = 0;
    L_0x00b1:
        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
        if (r2 == 0) goto L_0x00d3;
    L_0x00b7:
        r0 = "MicroMsg.NoteEditorUI";
        r1 = "want to send record msg, but toUser is null";
        com.tencent.mm.sdk.platformtools.w.w(r0, r1);
        goto L_0x002a;
    L_0x00c2:
        r0 = "Select_Conv_User";
        r0 = r13.getStringExtra(r0);
        r1 = r0;
        goto L_0x00ae;
    L_0x00cb:
        r0 = "custom_send_text";
        r0 = r13.getStringExtra(r0);
        goto L_0x00b1;
    L_0x00d3:
        r2 = r10.uSU;
        r2 = r2.uTo;
        r3 = com.tencent.mm.R.l.eit;
        r3 = r10.getString(r3);
        r4 = 0;
        r5 = 0;
        r2 = com.tencent.mm.ui.base.g.a(r2, r3, r4, r5);
        r3 = new com.tencent.mm.e.a.fp;
        r3.<init>();
        r4 = r3.fKp;
        r5 = 13;
        r4.type = r5;
        r4 = r3.fKp;
        r5 = r10.uSU;
        r5 = r5.uTo;
        r4.context = r5;
        r4 = r3.fKp;
        r4.toUser = r1;
        r1 = r3.fKp;
        r1.fKv = r0;
        r0 = r3.fKp;
        r4 = r10.hEY;
        r0.fFx = r4;
        r0 = r3.fKp;
        r1 = new com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$6;
        r1.<init>(r10, r2);
        r0.fKu = r1;
        r0 = com.tencent.mm.sdk.b.a.urY;
        r0.m(r3);
        r0 = r6;
        goto L_0x0033;
    L_0x0115:
        r6 = 0;
        r0 = "key_req_result";
        r0 = r13.getParcelableExtra(r0);
        if (r0 != 0) goto L_0x015a;
    L_0x011f:
        r0 = 2;
    L_0x0120:
        r1 = "CropImage_OutputPath_List";
        r1 = r13.getStringArrayListExtra(r1);
        if (r1 == 0) goto L_0x017f;
    L_0x0129:
        r2 = r1.size();
        if (r2 <= 0) goto L_0x017f;
    L_0x012f:
        r2 = com.tencent.mm.plugin.report.service.g.oUh;
        r3 = 14547; // 0x38d3 float:2.0385E-41 double:7.187E-320;
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r7 = java.lang.Integer.valueOf(r0);
        r4[r5] = r7;
        r2.i(r3, r4);
        r2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv();
        r3 = "";
        r4 = "";
        r5 = r1.size();
        r2 = r2.F(r3, r4, r5);
        if (r2 == 0) goto L_0x015c;
    L_0x0154:
        r10.bBq();
        r0 = r6;
        goto L_0x0033;
    L_0x015a:
        r0 = 1;
        goto L_0x0120;
    L_0x015c:
        r2 = r10.uSU;
        r2 = r2.uTo;
        r3 = com.tencent.mm.R.l.dIO;
        r10.getString(r3);
        r3 = com.tencent.mm.R.l.dJd;
        r3 = r10.getString(r3);
        r4 = 0;
        r5 = 0;
        r2 = com.tencent.mm.ui.base.g.a(r2, r3, r4, r5);
        r10.isv = r2;
        r2 = com.tencent.mm.u.ap.vL();
        r3 = new com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$7;
        r3.<init>(r10, r1);
        r2.D(r3);
    L_0x017f:
        r1 = "key_select_video_list";
        r1 = r13.getStringArrayListExtra(r1);
        r2 = "K_SEGMENTVIDEOPATH";
        r2 = r13.getStringExtra(r2);
        r3 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
        if (r3 != 0) goto L_0x019d;
    L_0x0193:
        if (r1 != 0) goto L_0x019d;
    L_0x0195:
        r1 = new java.util.ArrayList;
        r1.<init>();
        r1.add(r2);
    L_0x019d:
        if (r1 == 0) goto L_0x0032;
    L_0x019f:
        r2 = r1.size();
        if (r2 <= 0) goto L_0x0032;
    L_0x01a5:
        r2 = com.tencent.mm.plugin.report.service.g.oUh;
        r3 = 14547; // 0x38d3 float:2.0385E-41 double:7.187E-320;
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r0 = java.lang.Integer.valueOf(r0);
        r4[r5] = r0;
        r2.i(r3, r4);
        r0 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv();
        r2 = "";
        r3 = "";
        r4 = r1.size();
        r0 = r0.F(r2, r3, r4);
        if (r0 == 0) goto L_0x01d0;
    L_0x01ca:
        r10.bBq();
        r0 = r6;
        goto L_0x0033;
    L_0x01d0:
        r0 = 0;
        r0 = r1.get(r0);
        r0 = (java.lang.String) r0;
        r1 = com.tencent.mm.plugin.sight.base.d.Er(r0);
        if (r1 != 0) goto L_0x01f3;
    L_0x01dd:
        r1 = "MicroMsg.NoteEditorUI";
        r2 = "mediaInfo is null, videoPath is %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bg.mz(r0);
        r3[r4] = r0;
        com.tencent.mm.sdk.platformtools.w.e(r1, r2, r3);
        r0 = r6;
        goto L_0x0033;
    L_0x01f3:
        r1 = r1.bbO();
        r2 = (long) r1;
        r4 = new com.tencent.mm.plugin.wenote.model.a.g;
        r4.<init>();
        r1 = 1;
        r4.suJ = r1;
        r1 = "";
        r4.fKz = r1;
        r1 = "";
        r4.fQE = r1;
        r4.duration = r2;
        r1 = 6;
        r4.type = r1;
        r1 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv();
        r1 = r1.bBB();
        r4.suI = r1;
        r1 = com.tencent.mm.a.e.aQ(r0);
        r4.suC = r1;
        r1 = r4.toString();
        r1 = com.tencent.mm.plugin.wenote.model.e.Lj(r1);
        r4.lKv = r1;
        r1 = new com.tencent.mm.protocal.c.rm;
        r1.<init>();
        r10.syd = r1;
        r1 = r10.syd;
        r2 = r4.lKv;
        r1.NY(r2);
        r1 = r10.syd;
        r2 = r4.suC;
        r1.NV(r2);
        r1 = r10.syd;
        r2 = com.tencent.mm.plugin.wenote.model.e.h(r1);
        r1 = r10.syd;
        r3 = com.tencent.mm.plugin.wenote.model.e.o(r1);
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r1 != 0) goto L_0x0032;
    L_0x0250:
        r1 = "MicroMsg.NoteEditorUI";
        r5 = "compressNoteVideo path: %s";
        r7 = 1;
        r7 = new java.lang.Object[r7];
        r8 = 0;
        r7[r8] = r0;
        com.tencent.mm.sdk.platformtools.w.v(r1, r5, r7);
        r1 = new java.util.ArrayList;
        r1.<init>();
        r1.add(r0);
        r0 = new com.tencent.mm.plugin.wenote.model.nativenote.manager.d;
        r5 = new com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$8;
        r5.<init>(r10);
        r0.<init>(r1, r2, r3, r4, r5);
        r1 = r10.uSU;
        r1 = r1.uTo;
        r2 = com.tencent.mm.R.l.dIO;
        r10.getString(r2);
        r2 = com.tencent.mm.R.l.dJd;
        r2 = r10.getString(r2);
        r3 = 1;
        r5 = new com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI$9;
        r5.<init>(r10, r0, r4);
        r1 = com.tencent.mm.ui.base.g.a(r1, r2, r3, r5);
        r10.isv = r1;
        r1 = "NoteEditor_importVideo";
        com.tencent.mm.sdk.f.e.post(r0, r1);
        r0 = r6;
        goto L_0x0033;
    L_0x0295:
        r0 = com.tencent.mm.plugin.report.service.g.oUh;
        r1 = 14547; // 0x38d3 float:2.0385E-41 double:7.187E-320;
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = 4;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.i(r1, r2);
        r0 = 0;
        r1 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv();
        r2 = "";
        r3 = "";
        r4 = 1;
        r1 = r1.F(r2, r3, r4);
        if (r1 == 0) goto L_0x02be;
    L_0x02b9:
        r10.bBq();
        goto L_0x0033;
    L_0x02be:
        r1 = new com.tencent.mm.plugin.wenote.model.a.d;
        r1.<init>();
        r2 = "kwebmap_slat";
        r4 = 0;
        r2 = r13.getDoubleExtra(r2, r4);
        r2 = (float) r2;
        r2 = (double) r2;
        r1.lat = r2;
        r2 = "kwebmap_lng";
        r4 = 0;
        r2 = r13.getDoubleExtra(r2, r4);
        r2 = (float) r2;
        r2 = (double) r2;
        r1.lng = r2;
        r2 = "kwebmap_scale";
        r3 = 0;
        r2 = r13.getIntExtra(r2, r3);
        r2 = (double) r2;
        r1.suO = r2;
        r2 = "Kwebmap_locaion";
        r2 = r13.getStringExtra(r2);
        r3 = "";
        r2 = com.tencent.mm.sdk.platformtools.bg.ap(r2, r3);
        r1.hCE = r2;
        r2 = "kPoiName";
        r2 = r13.getStringExtra(r2);
        r1.ndv = r2;
        r2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv();
        r2 = r2.bBB();
        r1.suI = r2;
        r2 = 3;
        r1.type = r2;
        r2 = 1;
        r1.suJ = r2;
        r2 = "";
        r1.fQE = r2;
        r2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv();
        r3 = r10.sxO;
        r3 = r3.bBU();
        r4 = 0;
        r5 = 0;
        r2.a(r1, r3, r4, r5);
        goto L_0x0033;
    L_0x0327:
        r0 = com.tencent.mm.plugin.report.service.g.oUh;
        r1 = 14547; // 0x38d3 float:2.0385E-41 double:7.187E-320;
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = 5;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.i(r1, r2);
        r0 = "choosed_file_path";
        r0 = r13.getStringExtra(r0);
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r1 == 0) goto L_0x0349;
    L_0x0346:
        r0 = 1;
        goto L_0x0033;
    L_0x0349:
        r1 = new java.io.File;
        r1.<init>(r0);
        r2 = r1.exists();
        if (r2 != 0) goto L_0x0357;
    L_0x0354:
        r0 = 1;
        goto L_0x0033;
    L_0x0357:
        r2 = r1.length();
        r4 = 26214400; // 0x1900000 float:5.2897246E-38 double:1.29516345E-316;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 < 0) goto L_0x0365;
    L_0x0362:
        r0 = 3;
        goto L_0x0033;
    L_0x0365:
        r2 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv();
        r3 = "";
        r4 = "";
        r5 = 1;
        r2 = r2.F(r3, r4, r5);
        if (r2 == 0) goto L_0x037c;
    L_0x0376:
        r10.bBq();
        r0 = r6;
        goto L_0x0033;
    L_0x037c:
        r2 = r10.isv;
        if (r2 == 0) goto L_0x0388;
    L_0x0380:
        r2 = r10.isv;
        r2.dismiss();
        r2 = 0;
        r10.isv = r2;
    L_0x0388:
        r2 = r10.uSU;
        r2 = r2.uTo;
        r3 = com.tencent.mm.R.l.dIO;
        r10.getString(r3);
        r3 = com.tencent.mm.R.l.dJd;
        r3 = r10.getString(r3);
        r4 = 0;
        r5 = 0;
        r2 = com.tencent.mm.ui.base.g.a(r2, r3, r4, r5);
        r10.isv = r2;
        r2 = new com.tencent.mm.plugin.wenote.model.a.b;
        r2.<init>();
        r1 = r1.getName();
        r2.title = r1;
        r1 = com.tencent.mm.a.e.aN(r0);
        r1 = (float) r1;
        r1 = com.tencent.mm.plugin.wenote.model.e.U(r1);
        r2.content = r1;
        r1 = com.tencent.mm.a.e.aQ(r0);
        r1 = com.tencent.mm.plugin.wenote.model.g.Lm(r1);
        r2.fQH = r1;
        r1 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv();
        r1 = r1.bBB();
        r2.suI = r1;
        r1 = 5;
        r2.type = r1;
        r1 = 1;
        r2.suJ = r1;
        r1 = com.tencent.mm.a.e.aQ(r0);
        r2.suC = r1;
        r1 = r2.toString();
        r1 = com.tencent.mm.plugin.wenote.model.e.Lj(r1);
        r2.lKv = r1;
        r1 = new com.tencent.mm.protocal.c.rm;
        r1.<init>();
        r10.syd = r1;
        r1 = r10.syd;
        r3 = r2.lKv;
        r1.NY(r3);
        r1 = r10.syd;
        r3 = r2.suC;
        r1.NV(r3);
        r1 = r10.syd;
        r1 = com.tencent.mm.plugin.wenote.model.e.o(r1);
        r2.fQE = r1;
        r1 = r2.fQE;
        com.tencent.mm.modelsfs.FileOp.p(r0, r1);
        r0 = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv();
        r1 = r10.sxO;
        r1 = r1.bBU();
        r3 = 0;
        r4 = 1;
        r0.a(r2, r1, r3, r4);
        goto L_0x0032;
    L_0x0412:
        r1 = 3;
        if (r1 != r0) goto L_0x002a;
    L_0x0415:
        r0 = r10.uSU;
        r0 = r0.uTo;
        r1 = com.tencent.mm.R.l.ejH;
        r1 = r10.getString(r1);
        r2 = 1;
        r0 = android.widget.Toast.makeText(r0, r1, r2);
        r0.show();
        goto L_0x002a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI.onActivityResult(int, int, android.content.Intent):void");
    }

    public final void aH(String str, boolean z) {
        w.i("MicroMsg.NoteEditorUI", "setEditorExportLogic,htmlstr:%s,isInsert:%B", new Object[]{str, Boolean.valueOf(z)});
        if (z || !str.equals(this.sxX)) {
            rv Lr = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().Lr(str);
            com.tencent.mm.sdk.b.b fpVar;
            if (z) {
                fpVar = new fp();
                fpVar.fKp.type = 19;
                fpVar.fKp.fFC = Lr;
                fpVar.fKp.title = str;
                fpVar.fKp.fFx = this.hEY;
                fpVar.fKp.desc = "fav_add_new_note";
                com.tencent.mm.sdk.b.a.urY.m(fpVar);
            } else {
                fpVar = new fp();
                fpVar.fKp.type = 19;
                fpVar.fKp.fFC = Lr;
                fpVar.fKp.title = str;
                fpVar.fKp.fFx = this.hEY;
                fpVar.fKp.desc = "";
                if (this.sxW) {
                    fpVar.fKp.fKw = -2;
                }
                com.tencent.mm.sdk.b.a.urY.m(fpVar);
            }
            w.i("MicroMsg.NoteEditorUI", "write html to file suc");
        } else if (this.sxO.swE > 0 && !bg.mA(this.sxO.swF) && this.sxO.swG > 0) {
            com.tencent.mm.sdk.b.b fpVar2 = new fp();
            fpVar2.fKp.type = 19;
            fpVar2.fKp.fKw = -3;
            fpVar2.fKp.fFx = this.hEY;
            Intent intent = new Intent();
            intent.putExtra("fav_note_item_status", this.sxO.swE);
            intent.putExtra("fav_note_xml", this.sxO.swF);
            intent.putExtra("fav_note_item_updatetime", this.sxO.swG);
            fpVar2.fKp.fKs = intent;
            com.tencent.mm.sdk.b.a.urY.m(fpVar2);
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.sxY && this.syk && !this.syj) {
            aHj();
        } else if (this.sxY && !this.syk && com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().bBx() >= 0) {
            a(Boolean.valueOf(false), true);
            if (!this.sxR.sxp) {
                ea(10);
            }
        }
        this.syk = false;
        this.syj = false;
        this.sxY = false;
    }

    protected void onPause() {
        super.onPause();
        this.sxY = true;
        this.syb = false;
        if (this.sxR != null) {
            this.sxR.a(this);
        }
        if (com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.bCg().atu()) {
            com.tencent.mm.plugin.wenote.ui.nativenote.voiceview.a.bCg().adL();
        }
    }

    public final void bBn() {
        if (!this.sxR.sxp) {
            ea(0);
            this.sxS.setVisibility(0);
            this.hgN.postDelayed(new Runnable(this) {
                final /* synthetic */ NoteEditorUI syl;

                {
                    this.syl = r1;
                }

                public final void run() {
                    if (this.syl.sxT != null) {
                        this.syl.a(Boolean.valueOf(false), true);
                        g a = this.syl.sxT;
                        int[] iArr = new int[]{0, 0};
                        a.mParentView.getLocationOnScreen(iArr);
                        a.svO.showAtLocation(a.mParentView, 49, 0, iArr[1] + 50);
                    }
                }
            }, 120);
        }
    }

    public final void a(WXRTEditText wXRTEditText) {
        if (wXRTEditText != null && com.tencent.mm.plugin.wenote.model.nativenote.manager.f.bBH()) {
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().a(com.tencent.mm.plugin.wenote.model.nativenote.manager.f.bBG(), wXRTEditText, false, true, true, false);
            a(Boolean.valueOf(false), true);
        }
    }

    public final void bBL() {
        if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.dj(this)) {
            ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
            boolean z = clipboardManager.getText().length() >= 16384 ? true : com.tencent.mm.plugin.wenote.b.b.Lx(clipboardManager.getText().toString()) >= 16384;
            if (z) {
                bBq();
                return;
            }
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().bBw();
            com.tencent.mm.plugin.wenote.model.nativenote.manager.f.QZ();
            com.tencent.mm.plugin.wenote.model.a.a eVar = new com.tencent.mm.plugin.wenote.model.a.e();
            eVar.content = "";
            eVar.sut = false;
            eVar.suz = false;
            eVar.suv = 0;
            eVar.suB = true;
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().a(eVar);
            bCb();
        } else if (com.tencent.mm.plugin.wenote.model.nativenote.manager.f.bBH()) {
            ArrayList bBG = com.tencent.mm.plugin.wenote.model.nativenote.manager.f.bBG();
            if (com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().ab(bBG)) {
                bBq();
                return;
            }
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().bBw();
            com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().a(bBG, null, false, true, false, false);
            a(Boolean.valueOf(false), true);
        }
    }

    public final void bBI() {
        com.tencent.mm.plugin.wenote.model.a.a eVar = new com.tencent.mm.plugin.wenote.model.a.e();
        eVar.content = "";
        eVar.sut = true;
        eVar.suz = false;
        eVar.suv = 0;
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().bBw();
        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().a(eVar);
        bCb();
    }

    public final void bBJ() {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.f.ac(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().bBD());
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setText("");
        }
    }

    public final void bBK() {
        com.tencent.mm.plugin.wenote.model.nativenote.manager.f.ac(com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().bBD());
        ClipboardManager clipboardManager = (ClipboardManager) getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setText("");
        }
        bBI();
    }

    public final void dB(int i, int i2) {
        this.sya = Math.abs(i2 - i) > 0;
    }

    public final void wQ(final int i) {
        if (i >= 0 && i < com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bBv().size()) {
            this.hgN.post(new Runnable(this) {
                final /* synthetic */ NoteEditorUI syl;

                public final void run() {
                    this.syl.aak.aX(i);
                }
            });
        }
    }

    public final void bBp() {
        this.hgN.post(new Runnable(this) {
            final /* synthetic */ NoteEditorUI syl;

            {
                this.syl = r1;
            }

            public final void run() {
                if (this.syl.isv != null) {
                    this.syl.isv.dismiss();
                    this.syl.isv = null;
                }
            }
        });
    }

    public final void bBq() {
        if (this.soD || this.sxV) {
            a(Boolean.valueOf(false), true);
            if (!this.sxR.sxp) {
                ea(10);
            }
            com.tencent.mm.ui.base.g.b(this.uSU.uTo, getString(R.l.fng), null, true);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.NoteEditorUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                if (iArr[0] != 0) {
                    bBr();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void bBr() {
        com.tencent.mm.ui.base.g.a(this, getString(R.l.eFJ), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ NoteEditorUI syl;

            {
                this.syl = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                this.syl.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
            }
        }, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ NoteEditorUI syl;

            {
                this.syl = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
    }
}
