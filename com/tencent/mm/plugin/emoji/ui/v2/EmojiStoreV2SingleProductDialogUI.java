package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ah.a.c.i;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.cm;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.c.a;
import com.tencent.mm.plugin.gif.MMGIFImageView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ov;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.r;

public class EmojiStoreV2SingleProductDialogUI extends MMBaseActivity {
    private String aGN;
    public String gLD;
    private int hPi;
    private h ihw;
    private a kLG = new a(this) {
        final /* synthetic */ EmojiStoreV2SingleProductDialogUI kYq;

        {
            this.kYq = r1;
        }

        public final void i(c cVar) {
            if (cVar == null || this.kYq.kYd == null || !this.kYq.kYd.tup.equals(cVar.EP())) {
                w.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "somethings error.");
            } else {
                EmojiStoreV2SingleProductDialogUI.e(this.kYq);
            }
        }
    };
    private long kMa;
    private ov kYd = new ov();
    private c kYe;
    private View kYf;
    private ProgressBar kYg;
    private MMGIFImageView kYh;
    private ImageView kYi;
    private Button kYj;
    private Button kYk;
    private OnClickListener kYl = new OnClickListener(this) {
        final /* synthetic */ EmojiStoreV2SingleProductDialogUI kYq;

        {
            this.kYq = r1;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            EmojiStoreV2SingleProductDialogUI.a(this.kYq, this.kYq.kYd);
            g gVar = g.oUh;
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(this.kYq.hPi);
            objArr[1] = Integer.valueOf(2);
            objArr[2] = this.kYq.kYd == null ? "" : this.kYq.kYd.tup;
            objArr[3] = Long.valueOf(this.kYq.kMa);
            gVar.i(12787, objArr);
        }
    };
    private OnClickListener kYm = new OnClickListener(this) {
        final /* synthetic */ EmojiStoreV2SingleProductDialogUI kYq;

        {
            this.kYq = r1;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            EmojiStoreV2SingleProductDialogUI.b(this.kYq, this.kYq.kYd);
            g gVar = g.oUh;
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(this.kYq.hPi);
            objArr[1] = Integer.valueOf(1);
            objArr[2] = this.kYq.kYd == null ? "" : this.kYq.kYd.tup;
            objArr[3] = Long.valueOf(this.kYq.kMa);
            gVar.i(12787, objArr);
        }
    };
    private View.OnClickListener kYn = new View.OnClickListener(this) {
        final /* synthetic */ EmojiStoreV2SingleProductDialogUI kYq;

        {
            this.kYq = r1;
        }

        public final void onClick(View view) {
            this.kYq.setResult(0);
            this.kYq.finish();
            this.kYq.overridePendingTransition(R.a.aRm, R.a.aRn);
        }
    };
    private i kYo = new i(this) {
        final /* synthetic */ EmojiStoreV2SingleProductDialogUI kYq;

        {
            this.kYq = r1;
        }

        public final void a(String str, Bitmap bitmap, Object... objArr) {
            if (bitmap != null && objArr != null && objArr.length > 0 && this.kYq.mHandler != null && objArr[0] != null && (objArr[0] instanceof ov)) {
                ov ovVar = (ov) objArr[0];
                if (this.kYq.kYd != null && ovVar != null && ovVar.tup.equals(this.kYq.kYd.tup)) {
                    EmojiStoreV2SingleProductDialogUI.e(this.kYq);
                }
            }
        }
    };
    private com.tencent.mm.sdk.b.c kYp = new com.tencent.mm.sdk.b.c<cm>(this) {
        final /* synthetic */ EmojiStoreV2SingleProductDialogUI kYq;

        {
            this.kYq = r2;
            this.usg = cm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            cm cmVar = (cm) bVar;
            if (cmVar != null && (cmVar instanceof cm) && this.kYq.kYd != null && cmVar.fFV.fFW.equals(this.kYq.kYd.tup)) {
                EmojiStoreV2SingleProductDialogUI.e(this.kYq);
            }
            return false;
        }
    };
    private ae mHandler = new ae();

    static /* synthetic */ void a(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI, ov ovVar) {
        if (bg.mA(emojiStoreV2SingleProductDialogUI.gLD)) {
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("select_is_ret", true);
            intent.putExtra("mutil_select_is_ret", true);
            intent.putExtra("Retr_Msg_Type", 5);
            intent.putExtra("Retr_Msg_thumb_path", ovVar.tup);
            intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.aQX);
            d.a(emojiStoreV2SingleProductDialogUI, ".ui.transmit.SelectConversationUI", intent, 9001);
            emojiStoreV2SingleProductDialogUI.overridePendingTransition(R.a.aRq, R.a.aQY);
            return;
        }
        emojiStoreV2SingleProductDialogUI.a(emojiStoreV2SingleProductDialogUI.gLD, ovVar);
    }

    static /* synthetic */ void b(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI, ov ovVar) {
        if (ovVar != null) {
            c Si = com.tencent.mm.plugin.emoji.model.h.amc().kLa.Si(ovVar.tup);
            ap.yY();
            String D = EmojiLogic.D(com.tencent.mm.u.c.xi(), ovVar.tgW, ovVar.tup);
            if (Si == null && e.aO(D)) {
                int i = o.Pj(D) ? c.uLa : c.uKZ;
                c cVar = new c();
                cVar.field_md5 = ovVar.tup;
                cVar.field_catalog = c.uKT;
                cVar.field_type = i;
                cVar.field_size = e.aN(D);
                cVar.field_temp = 1;
                cVar.field_designerID = ovVar.tuq;
                cVar.field_thumbUrl = ovVar.ohq;
                com.tencent.mm.plugin.emoji.model.h.amc().kLa.r(cVar);
                Si = cVar;
            }
            if (Si != null) {
                com.tencent.mm.plugin.emoji.model.h.alY().a(emojiStoreV2SingleProductDialogUI, Si, 5, m.xL());
                return;
            }
            return;
        }
        w.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "add failed");
    }

    static /* synthetic */ void e(EmojiStoreV2SingleProductDialogUI emojiStoreV2SingleProductDialogUI) {
        if (emojiStoreV2SingleProductDialogUI.mHandler != null) {
            emojiStoreV2SingleProductDialogUI.mHandler.post(new Runnable(emojiStoreV2SingleProductDialogUI) {
                final /* synthetic */ EmojiStoreV2SingleProductDialogUI kYq;

                {
                    this.kYq = r1;
                }

                public final void run() {
                    this.kYq.kYg.setVisibility(8);
                    this.kYq.kYh.setVisibility(0);
                    this.kYq.kYe = com.tencent.mm.plugin.emoji.model.h.amc().kLa.Si(this.kYq.kYd.tup);
                    if (this.kYq.kYe == null || (this.kYq.kYe.field_reserved4 & c.uLn) != c.uLn) {
                        this.kYq.kYh.ct(this.kYq.aGN, null);
                    } else {
                        this.kYq.kYh.h(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().g(this.kYq.kYe), "");
                    }
                    this.kYq.anJ();
                    this.kYq.kYj.setEnabled(true);
                    this.kYq.kYj.setTextColor(this.kYq.getResources().getColor(R.e.aUd));
                }
            });
        }
    }

    public void onCreate(Bundle bundle) {
        View view;
        String str;
        h.a aVar;
        h WJ;
        super.onCreate(bundle);
        setContentView(R.i.bkS);
        this.hPi = getIntent().getIntExtra("scene", 0);
        this.kMa = getIntent().getLongExtra("searchID", 0);
        this.gLD = getIntent().getStringExtra("Select_Conv_User");
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("extra_object");
        if (byteArrayExtra != null) {
            try {
                this.kYd = (ov) this.kYd.aD(byteArrayExtra);
                if (this.kYd != null) {
                    this.kYe = com.tencent.mm.plugin.emoji.model.h.amc().kLa.Si(this.kYd.tup);
                    if (!(this.kYe == null || bg.mA(this.kYe.field_groupId) || !bg.mA(this.kYd.tgW))) {
                        this.kYd.tgW = this.kYe.field_groupId;
                    }
                }
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", e, "", new Object[0]);
            }
            com.tencent.mm.sdk.b.a.urY.b(this.kYp);
            com.tencent.mm.plugin.emoji.model.h.alW().kLG = this.kLG;
            this.kYf = r.eC(this).inflate(R.i.daQ, null);
            this.kYg = (ProgressBar) this.kYf.findViewById(R.h.bJu);
            this.kYh = (MMGIFImageView) this.kYf.findViewById(R.h.bJs);
            this.kYi = (ImageView) this.kYf.findViewById(R.h.bJp);
            this.kYi.setOnClickListener(this.kYn);
            view = this.kYf;
            str = "";
            if ((this instanceof Activity) || !isFinishing()) {
                aVar = new h.a(this);
                aVar.SW(str);
                aVar.dd(view);
                aVar.kK(true);
                WJ = aVar.WJ();
                WJ.show();
                com.tencent.mm.ui.base.g.a(this, WJ);
            } else {
                WJ = null;
            }
            this.ihw = WJ;
            this.ihw.a(getString(R.l.dIA), false, this.kYl);
            this.ihw.b(getString(R.l.dDk), false, this.kYm);
            this.ihw.setOnDismissListener(new OnDismissListener(this) {
                final /* synthetic */ EmojiStoreV2SingleProductDialogUI kYq;

                {
                    this.kYq = r1;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                    this.kYq.setResult(0);
                    this.kYq.finish();
                }
            });
            this.kYj = this.ihw.getButton(-1);
            this.kYj.setTextColor(getResources().getColor(R.e.aUd));
            this.kYk = this.ihw.getButton(-2);
            ap.yY();
            this.aGN = EmojiLogic.D(com.tencent.mm.u.c.xi(), this.kYd.tgW, this.kYd.tup);
            if (e.aN(this.aGN) <= 0) {
                this.kYh.setVisibility(0);
                this.kYg.setVisibility(8);
                this.kYe = com.tencent.mm.plugin.emoji.model.h.amc().kLa.Si(this.kYd.tup);
                if (this.kYe == null && (this.kYe.field_reserved4 & c.uLn) == c.uLn) {
                    this.kYh.h(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().g(this.kYe), "");
                } else {
                    this.kYh.ct(this.aGN, null);
                }
                anJ();
            }
            this.kYh.setVisibility(8);
            this.kYg.setVisibility(0);
            this.kYk.setText(R.l.eda);
            this.kYj.setText(R.l.dIA);
            this.kYk.setEnabled(false);
            this.kYk.setTextColor(getResources().getColor(R.e.aUg));
            this.kYj.setEnabled(false);
            this.kYj.setTextColor(getResources().getColor(R.e.aUg));
            com.tencent.mm.ah.a.a alV = com.tencent.mm.plugin.emoji.model.h.alV();
            String str2 = this.kYd.msN;
            str = this.kYd.msN;
            alV.a(str2, null, f.g(this.aGN, this.kYd), this.kYo);
            return;
        }
        setResult(0);
        finish();
        com.tencent.mm.sdk.b.a.urY.b(this.kYp);
        com.tencent.mm.plugin.emoji.model.h.alW().kLG = this.kLG;
        this.kYf = r.eC(this).inflate(R.i.daQ, null);
        this.kYg = (ProgressBar) this.kYf.findViewById(R.h.bJu);
        this.kYh = (MMGIFImageView) this.kYf.findViewById(R.h.bJs);
        this.kYi = (ImageView) this.kYf.findViewById(R.h.bJp);
        this.kYi.setOnClickListener(this.kYn);
        view = this.kYf;
        str = "";
        if (this instanceof Activity) {
        }
        aVar = new h.a(this);
        aVar.SW(str);
        aVar.dd(view);
        aVar.kK(true);
        WJ = aVar.WJ();
        WJ.show();
        com.tencent.mm.ui.base.g.a(this, WJ);
        this.ihw = WJ;
        this.ihw.a(getString(R.l.dIA), false, this.kYl);
        this.ihw.b(getString(R.l.dDk), false, this.kYm);
        this.ihw.setOnDismissListener(/* anonymous class already generated */);
        this.kYj = this.ihw.getButton(-1);
        this.kYj.setTextColor(getResources().getColor(R.e.aUd));
        this.kYk = this.ihw.getButton(-2);
        ap.yY();
        this.aGN = EmojiLogic.D(com.tencent.mm.u.c.xi(), this.kYd.tgW, this.kYd.tup);
        if (e.aN(this.aGN) <= 0) {
            this.kYh.setVisibility(8);
            this.kYg.setVisibility(0);
            this.kYk.setText(R.l.eda);
            this.kYj.setText(R.l.dIA);
            this.kYk.setEnabled(false);
            this.kYk.setTextColor(getResources().getColor(R.e.aUg));
            this.kYj.setEnabled(false);
            this.kYj.setTextColor(getResources().getColor(R.e.aUg));
            com.tencent.mm.ah.a.a alV2 = com.tencent.mm.plugin.emoji.model.h.alV();
            String str22 = this.kYd.msN;
            str = this.kYd.msN;
            alV2.a(str22, null, f.g(this.aGN, this.kYd), this.kYo);
            return;
        }
        this.kYh.setVisibility(0);
        this.kYg.setVisibility(8);
        this.kYe = com.tencent.mm.plugin.emoji.model.h.amc().kLa.Si(this.kYd.tup);
        if (this.kYe == null) {
        }
        this.kYh.ct(this.aGN, null);
        anJ();
    }

    protected void onResume() {
        super.onResume();
        anJ();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 9001 && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (!bg.mA(stringExtra) && this.kYd != null) {
                w.d("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "UserName:%s ,MD5:%s", new Object[]{stringExtra, this.kYd.tup});
                a(stringExtra, this.kYd);
                com.tencent.mm.plugin.messenger.a.d.aJW().cM(intent.getStringExtra("custom_send_text"), stringExtra);
            }
        }
    }

    private void anJ() {
        this.kYe = com.tencent.mm.plugin.emoji.model.h.amc().kLa.Si(this.kYd.tup);
        if (this.kYe != null && this.kYe.field_catalog == com.tencent.mm.storage.a.a.uKS && bg.mA(this.kYe.field_groupId)) {
            this.kYk.setEnabled(false);
            this.kYk.setText(R.l.dDk);
            this.kYk.setTextColor(getResources().getColor(R.e.aUg));
        } else if (e.aO(this.aGN)) {
            this.kYk.setEnabled(true);
            this.kYk.setText(R.l.eda);
            this.kYk.setTextColor(getResources().getColor(R.e.aUd));
        } else {
            this.kYk.setEnabled(false);
            this.kYk.setEnabled(false);
            this.kYk.setText(R.l.eda);
            this.kYk.setTextColor(getResources().getColor(R.e.aUg));
        }
    }

    private void a(String str, ov ovVar) {
        if (bg.mA(str) || ovVar == null) {
            w.i("MicroMsg.emoji.EmojiStoreV2SingleProductDialogUI", "username or emoji is null.");
            return;
        }
        c cVar;
        c Si = com.tencent.mm.plugin.emoji.model.h.amc().kLa.Si(ovVar.tup);
        if (Si == null) {
            ap.yY();
            String D = EmojiLogic.D(com.tencent.mm.u.c.xi(), ovVar.tgW, ovVar.tup);
            if (e.aO(D)) {
                Si = com.tencent.mm.plugin.emoji.model.h.amc().kLa.b(ovVar.tup, "", c.uKT, o.Pj(D) ? c.uLa : c.uKZ, e.aN(D), "");
                Si.field_designerID = ovVar.tuq;
                Si.field_thumbUrl = ovVar.ohq;
            }
            cVar = Si;
        } else {
            Si.field_designerID = ovVar.tuq;
            Si.field_thumbUrl = ovVar.ohq;
            cVar = Si;
        }
        for (String str2 : bg.f(bg.ap(str, "").split(","))) {
            if (cVar != null) {
                com.tencent.mm.plugin.emoji.model.h.alY().a(str2, cVar, null);
                setResult(-1);
                finish();
                overridePendingTransition(R.a.aRm, R.a.aRn);
            }
        }
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.b.a.urY.c(this.kYp);
        com.tencent.mm.plugin.emoji.model.h.alW().kLG = null;
        super.onDestroy();
    }
}
