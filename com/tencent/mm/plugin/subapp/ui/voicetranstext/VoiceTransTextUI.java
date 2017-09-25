package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.text.ClipboardManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.jo;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.o;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bf;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class VoiceTransTextUI extends MMActivity implements OnClickListener, e {
    private final String TAG = "MicroMsg.VoiceTransTextUI";
    private long gLE;
    private int iE;
    private int jdF;
    private int jdG;
    private View kHP = null;
    private ScrollView liX = null;
    private Button lyE = null;
    private ae mHandler = new ae(this) {
        final /* synthetic */ VoiceTransTextUI qWg;

        {
            this.qWg = r1;
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                this.qWg.hU(true);
            } else if (i == 2) {
                this.qWg.hU(false);
            }
        }
    };
    private long oIN = 0;
    private bf qRT;
    private a qRW;
    private c qRX;
    private b qRY;
    private com.tencent.mm.modelvoice.b qRZ;
    private volatile boolean qSb = false;
    private boolean qSc = false;
    private aj qSd;
    private View qVQ = null;
    private View qVR = null;
    private LinearLayout qVS = null;
    private TextView qVT = null;
    private int qVU = 6;
    private boolean qVV = false;
    private p qVW;
    private au qVX;
    private c qVY;
    private boolean qVZ = false;
    private boolean qWa = false;
    private int qWb;
    private OnTouchListener qWc;
    private OnClickListener qWd = new OnClickListener(this) {
        final /* synthetic */ VoiceTransTextUI qWg;

        {
            this.qWg = r1;
        }

        public final void onClick(View view) {
            this.qWg.finish();
        }
    };
    private ClipboardManager qWe;
    private OnLongClickListener qWf = new OnLongClickListener(this) {
        final /* synthetic */ VoiceTransTextUI qWg;

        {
            this.qWg = r1;
        }

        public final boolean onLongClick(View view) {
            w.d("MicroMsg.VoiceTransTextUI", "onLongClick");
            g.a(this.qWg, "", new String[]{this.qWg.getString(R.l.dGx)}, "", new g.c(this) {
                final /* synthetic */ AnonymousClass2 qWh;

                {
                    this.qWh = r1;
                }

                public final void hq(int i) {
                    if (i == 0 && this.qWh.qWg.qWe != null && this.qWh.qWg.qVT != null) {
                        this.qWh.qWg.qWe.setText(this.qWh.qWg.qVT.getText());
                    }
                }
            });
            return false;
        }
    };

    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] qWk = new int[a.bnq().length];
        static final /* synthetic */ int[] qWl = new int[b.bnr().length];

        static {
            try {
                qWl[b.qWr - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                qWl[b.qWs - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                qWl[b.qWt - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                qWk[a.qWm - 1] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                qWk[a.qWn - 1] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                qWk[a.qWo - 1] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                qWk[a.qWp - 1] = 4;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    private enum a {
        ;

        public static int[] bnq() {
            return (int[]) qWq.clone();
        }

        static {
            qWm = 1;
            qWn = 2;
            qWo = 3;
            qWp = 4;
            qWq = new int[]{qWm, qWn, qWo, qWp};
        }
    }

    private enum b {
        ;

        public static int[] bnr() {
            return (int[]) qWu.clone();
        }

        static {
            qWr = 1;
            qWs = 2;
            qWt = 3;
            qWu = new int[]{qWr, qWs, qWt};
        }
    }

    static /* synthetic */ void l(VoiceTransTextUI voiceTransTextUI) {
        voiceTransTextUI.jdF = 0;
        voiceTransTextUI.jdG = 0;
        voiceTransTextUI.qVZ = false;
        voiceTransTextUI.qWa = false;
        voiceTransTextUI.mHandler.removeMessages(0);
    }

    public void onCreate(Bundle bundle) {
        int i;
        bf bfVar = null;
        super.onCreate(bundle);
        this.iE = ViewConfiguration.get(this.uSU.uTo).getScaledTouchSlop();
        this.qWe = (ClipboardManager) getSystemService("clipboard");
        this.kHP = findViewById(R.h.cNK);
        this.qVQ = findViewById(R.h.cNF);
        this.qVR = findViewById(R.h.cNJ);
        this.qVT = (TextView) findViewById(R.h.cNH);
        this.lyE = (Button) findViewById(R.h.cNG);
        this.qVS = (LinearLayout) findViewById(R.h.cNI);
        this.liX = (ScrollView) findViewById(R.h.bSn);
        this.qWc = new OnTouchListener(this) {
            final /* synthetic */ VoiceTransTextUI qWg;

            {
                this.qWg = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.qWg.oIN = bg.NA();
                        this.qWg.jdF = view.getScrollY();
                        this.qWg.jdG = this.qWg.jdF;
                        this.qWg.mHandler.removeMessages(0);
                        if (this.qWg.qVZ) {
                            this.qWg.qVZ = false;
                            this.qWg.qWa = true;
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                    case 4:
                        if (Math.abs(this.qWg.jdG - view.getScrollY()) > this.qWg.iE) {
                            this.qWg.mHandler.sendMessage(this.qWg.mHandler.obtainMessage(0, view));
                        }
                        if ((bg.NA() - this.qWg.oIN) < 800 && Math.abs(this.qWg.jdG - view.getScrollY()) <= this.qWg.iE && !this.qWg.qWa) {
                            this.qWg.mHandler.removeMessages(0);
                            VoiceTransTextUI.l(this.qWg);
                            this.qWg.finish();
                        }
                        this.qWg.qWa = false;
                        break;
                }
                return false;
            }
        };
        this.qVT.setOnLongClickListener(this.qWf);
        this.qVT.setOnClickListener(this.qWd);
        this.gLE = getIntent().getExtras().getLong("voice_trans_text_msg_id", -1);
        if (this.gLE < 0) {
            i = 0;
        } else {
            w.i("MicroMsg.VoiceTransTextUI", "msg Id:%d", Long.valueOf(this.gLE));
            com.tencent.mm.storage.bg Lz = m.Lz();
            if (this.gLE >= 0) {
                bf bfVar2 = new bf();
                Cursor a = Lz.gUz.a("VoiceTransText", null, "msgId=?", new String[]{String.valueOf(r6)}, null, null, null, 2);
                if (a.moveToFirst()) {
                    bfVar2.b(a);
                }
                a.close();
                bfVar = bfVar2;
            }
            this.qRT = bfVar;
            if (this.qRT == null || bg.mA(this.qRT.field_content)) {
                String string = getIntent().getExtras().getString("voice_trans_text_img_path");
                if (bg.mA(string)) {
                    i = 0;
                } else {
                    this.qVW = m.Ly().mg(string);
                    if (this.qVW != null) {
                        w.i("MicroMsg.VoiceTransTextUI", "get voiceInfo");
                        i = 1;
                    } else {
                        ap.yY();
                        this.qVX = com.tencent.mm.u.c.wT().cA(this.gLE);
                        if (this.qVX != null) {
                            w.i("MicroMsg.VoiceTransTextUI", "get MsgInfo");
                            i = 1;
                        } else {
                            i = 0;
                        }
                    }
                }
            } else {
                w.i("MicroMsg.VoiceTransTextUI", "get voiceTransText");
                i = 1;
            }
        }
        if (i == 0) {
            w.d("MicroMsg.VoiceTransTextUI", "error invalid msgId");
            return;
        }
        ActionBar cP = cO().cP();
        if (cP != null) {
            cP.hide();
        }
        KC();
    }

    protected final int getLayoutId() {
        return R.i.dpK;
    }

    protected final void KC() {
        Object obj;
        zi(R.l.faY);
        this.lyE.setOnClickListener(this);
        if (this.qRT == null || bg.mA(this.qRT.field_content)) {
            obj = null;
        } else {
            as(b.qWr, this.qRT.field_content);
            if (!(this.liX == null || this.qVS == null)) {
                this.mHandler.postDelayed(new Runnable(this) {
                    final /* synthetic */ VoiceTransTextUI qWg;

                    {
                        this.qWg = r1;
                    }

                    public final void run() {
                        this.qWg.liX.setPadding(0, 0, 0, 0);
                        this.qWg.qVS.setGravity(17);
                    }
                }, 5);
            }
            obj = 1;
        }
        if (obj == null) {
            as(b.qWs, null);
            uz(a.qWm);
        }
    }

    private void uz(int i) {
        bnm();
        switch (AnonymousClass9.qWk[i - 1]) {
            case 1:
                w.i("MicroMsg.VoiceTransTextUI", "net check");
                if (pI() > 0) {
                    w.i("MicroMsg.VoiceTransTextUI", "has msg svr id: %d", Long.valueOf(pI()));
                    this.qRW = new a(bnn(), bno(), bnp().getFormat(), pI(), getFileName());
                } else {
                    w.i("MicroMsg.VoiceTransTextUI", "not existex msg svr id: %d", Long.valueOf(pI()));
                    this.qRW = new a(bnn(), bno(), getFileName());
                }
                ap.vd().a(this.qRW, 0);
                ap.vd().a(this.qRW.getType(), (e) this);
                if (this.qVY == null) {
                    if (this.qVY == null) {
                        this.qVY = new c<jo>(this) {
                            final /* synthetic */ VoiceTransTextUI qWg;

                            {
                                this.qWg = r2;
                                this.usg = jo.class.getName().hashCode();
                            }

                            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                                jo joVar = (jo) bVar;
                                w.i("MicroMsg.VoiceTransTextUI", "receive notify, process----> may be pass.");
                                if (this.qWg.qRW != null && !this.qWg.qSc && (joVar instanceof jo) && joVar.fPY.fPZ == this.qWg.qRW.qVO) {
                                    w.i("MicroMsg.VoiceTransTextUI", "");
                                    if (this.qWg.qSb) {
                                        w.i("MicroMsg.VoiceTransTextUI", "has new result! but need wait. so, wait.");
                                        this.qWg.qVV = true;
                                    } else {
                                        new ae(this.qWg.getMainLooper()).post(new Runnable(this) {
                                            final /* synthetic */ AnonymousClass5 qWi;

                                            {
                                                this.qWi = r1;
                                            }

                                            public final void run() {
                                                w.i("MicroMsg.VoiceTransTextUI", "notify has new trans, so pull");
                                                if (this.qWi.qWg.qSd != null) {
                                                    this.qWi.qWg.qSd.KH();
                                                }
                                                this.qWi.qWg.uz(a.qWp);
                                            }
                                        });
                                    }
                                }
                                return false;
                            }
                        };
                    }
                    com.tencent.mm.sdk.b.a.urY.b(this.qVY);
                    return;
                }
                return;
            case 2:
                w.i("MicroMsg.VoiceTransTextUI", "net upload");
                if (this.qRW == null) {
                    w.d("MicroMsg.VoiceTransTextUI", "request upload must after check!");
                    return;
                } else if (bnp() == null) {
                    w.d("MicroMsg.VoiceTransTextUI", "can't get FileOperator!");
                    return;
                } else {
                    this.qRX = new c(bnn(), this.qRW.qVM, bnp().getFormat(), getFileName());
                    ap.vd().a(this.qRX, 0);
                    ap.vd().a(this.qRX.getType(), (e) this);
                    return;
                }
            case 3:
                w.i("MicroMsg.VoiceTransTextUI", "net upload more");
                if (this.qRX == null) {
                    w.d("MicroMsg.VoiceTransTextUI", "upload more need has upload netScene!");
                    return;
                }
                this.qRX = new c(this.qRX);
                ap.vd().a(this.qRX, 0);
                ap.vd().a(this.qRX.getType(), (e) this);
                return;
            case 4:
                this.qVV = false;
                if (this.qSb) {
                    w.i("MicroMsg.VoiceTransTextUI", "pulling so pass");
                    return;
                }
                w.i("MicroMsg.VoiceTransTextUI", "net get");
                if (this.qRW == null) {
                    w.d("MicroMsg.VoiceTransTextUI", "request get must after check!");
                    return;
                }
                this.qSb = true;
                this.qRY = new b(bnn());
                ap.vd().a(this.qRY, 0);
                ap.vd().a(this.qRY.getType(), (e) this);
                return;
            default:
                return;
        }
    }

    private void as(int i, String str) {
        while (true) {
            switch (AnonymousClass9.qWl[i - 1]) {
                case 1:
                    if (!bg.mA(str)) {
                        this.qVS.setVisibility(0);
                        this.qVQ.setVisibility(8);
                        this.lyE.setVisibility(4);
                        this.qVR.setVisibility(8);
                        this.qVT.setText(str);
                        hU(true);
                        break;
                    }
                    i = b.qWt;
                    str = null;
                case 2:
                    this.qVS.setVisibility(0);
                    this.qVQ.setVisibility(0);
                    this.lyE.setVisibility(0);
                    if (str != null) {
                        this.qVT.setText(str);
                        hU(false);
                        break;
                    }
                    break;
                case 3:
                    this.qVS.setVisibility(8);
                    this.qVQ.setVisibility(8);
                    this.lyE.setHeight(0);
                    this.lyE.setVisibility(8);
                    this.qVR.setVisibility(0);
                    break;
                default:
                    break;
            }
            if (i == b.qWr || i == b.qWt) {
                this.liX.setOnTouchListener(this.qWc);
                this.kHP.setOnClickListener(this.qWd);
                return;
            }
            this.liX.setOnTouchListener(null);
            this.kHP.setOnClickListener(null);
            return;
        }
    }

    private void bnm() {
        w.d("MicroMsg.VoiceTransTextUI", "cancel all net");
        if (this.qRW != null) {
            ap.vd().c(this.qRW);
            ap.vd().b(this.qRW.getType(), (e) this);
        }
        if (this.qRX != null) {
            ap.vd().c(this.qRX);
            ap.vd().b(this.qRX.getType(), (e) this);
        }
        if (this.qRY != null) {
            ap.vd().c(this.qRY);
            ap.vd().b(this.qRY.getType(), (e) this);
        }
    }

    private String bnn() {
        if (this.qVW != null) {
            return this.qVW.clientId;
        }
        return this.qVX.field_talker + this.qVX.field_msgId + "T" + this.qVX.field_createTime;
    }

    private int bno() {
        if (this.qVW != null) {
            return this.qVW.hrs;
        }
        return o.lx(this.qVX.field_imgPath);
    }

    private long pI() {
        return this.qVW == null ? -1 : this.qVW.fTQ;
    }

    private String getFileName() {
        if (this.qVW != null) {
            return this.qVW.fyF;
        }
        return this.qVX.field_imgPath;
    }

    private com.tencent.mm.modelvoice.b bnp() {
        if (this.qRZ == null) {
            if (this.qVW != null) {
                this.qRZ = q.lV(this.qVW.fyF);
            } else if (this.qVX != null) {
                this.qRZ = q.lV(this.qVX.field_imgPath);
            } else {
                w.d("MicroMsg.VoiceTransTextUI", "error why get fileOperator, already has transContent. ");
            }
        }
        return this.qRZ;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = null;
        if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 546:
                    if (this.qRW.mState == a.qVK) {
                        w.i("MicroMsg.VoiceTransTextUI", "check result: done");
                        if (this.qRW.bnj()) {
                            str2 = this.qRW.qVL.uji;
                        }
                        Ho(str2);
                        return;
                    } else if (this.qRW.mState == a.qVJ) {
                        if (this.qRW.qVL != null && bg.mA(this.qRW.qVL.uji)) {
                            as(b.qWs, this.qRW.qVL.uji);
                        }
                        w.i("MicroMsg.VoiceTransTextUI", "check result: processing");
                        uz(a.qWp);
                        return;
                    } else if (this.qRW.mState == a.qVI) {
                        w.i("MicroMsg.VoiceTransTextUI", "check result: not exist");
                        uz(a.qWn);
                        return;
                    } else if (this.qRW.qVN != null) {
                        this.qVU = this.qRW.qVN.tXl;
                        return;
                    } else {
                        return;
                    }
                case 547:
                    if (this.qRX.bnl()) {
                        w.i("MicroMsg.VoiceTransTextUI", "succeed upload");
                        uz(a.qWp);
                        return;
                    }
                    w.d("MicroMsg.VoiceTransTextUI", "start upload more: start:%d, len:%d", Integer.valueOf(this.qRX.qVM.tgK), Integer.valueOf(this.qRX.qVM.tgL));
                    uz(a.qWo);
                    return;
                case 548:
                    this.qVU = this.qRY.qVP;
                    this.qSb = false;
                    if (!this.qRY.isComplete() && this.qRY.bnj()) {
                        as(b.qWs, this.qRY.qVL.uji);
                        w.d("MicroMsg.VoiceTransTextUI", "result valid:%s", this.qRY.qVL.uji);
                    } else if (!this.qRY.bnj()) {
                        w.d("MicroMsg.VoiceTransTextUI", "result not valid");
                    }
                    if (this.qRY.isComplete()) {
                        w.i("MicroMsg.VoiceTransTextUI", "succeed get");
                        if (this.qRY.bnj()) {
                            str2 = this.qRY.qVL.uji;
                        }
                        Ho(str2);
                        return;
                    } else if (this.qVV) {
                        w.i("MicroMsg.VoiceTransTextUI", "do get now! --- Notify new result");
                        uz(a.qWp);
                        return;
                    } else {
                        w.i("MicroMsg.VoiceTransTextUI", "do get again after:%ds", Integer.valueOf(this.qVU));
                        final int i3 = this.qVU;
                        if (!this.qSc) {
                            if (this.qSd == null) {
                                this.qSd = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
                                    final /* synthetic */ VoiceTransTextUI qWg;

                                    public final boolean oQ() {
                                        if (!this.qWg.qSc) {
                                            w.d("MicroMsg.VoiceTransTextUI", "timmer get, delay:%d", Integer.valueOf(i3));
                                            this.qWg.uz(a.qWp);
                                        }
                                        return false;
                                    }
                                }, false);
                            }
                            long j = (long) (i3 * 1000);
                            this.qSd.v(j, j);
                            return;
                        }
                        return;
                    }
                default:
                    return;
            }
        }
        this.qSc = true;
        as(b.qWt, null);
    }

    private void Ho(String str) {
        this.qSc = true;
        if (!bg.mA(str)) {
            com.tencent.mm.storage.bg Lz = m.Lz();
            bf bfVar = new bf();
            bfVar.field_msgId = this.gLE;
            bfVar.Sa(bnn());
            bfVar.field_content = str;
            Lz.a(bfVar);
        }
        as(b.qWr, str);
    }

    protected void onDestroy() {
        bnm();
        if (this.qSd != null) {
            this.qSd.KH();
        }
        if (this.qVY != null) {
            com.tencent.mm.sdk.b.a.urY.c(this.qVY);
            this.qVY = null;
        }
        super.onDestroy();
    }

    public void onClick(View view) {
        finish();
    }

    private void hU(final boolean z) {
        if (this.liX != null && this.qVS != null) {
            this.mHandler.postDelayed(new Runnable(this) {
                final /* synthetic */ VoiceTransTextUI qWg;

                public final void run() {
                    if (this.qWg.liX.getMeasuredHeight() >= this.qWg.qVS.getMeasuredHeight()) {
                        this.qWg.liX.fullScroll(130);
                        int scrollY = this.qWg.liX.getScrollY();
                        this.qWg.qWb = this.qWg.liX.getPaddingTop();
                        this.qWg.qWb = this.qWg.qWb - scrollY;
                        if (z) {
                            this.qWg.liX.setPadding(0, 0, 0, 0);
                            this.qWg.lyE.setVisibility(8);
                            this.qWg.lyE.setHeight(0);
                        } else if (this.qWg.qWb > 0) {
                            this.qWg.liX.setPadding(0, this.qWg.qWb, 0, 0);
                        }
                    }
                }
            }, 5);
        }
    }
}
