package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.protocal.c.ea;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.a.c;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.a.b;
import com.tencent.mm.ui.tools.a.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;

public class EmojiAddCustomDialogUI extends MMBaseActivity implements e {
    private int hPi;
    private ProgressDialog kIa;
    private h kPA;
    private h kPB;
    private String kPx;
    private String kPy;
    private c kPz;
    private Context mContext;
    private ae mHandler = new ae(this) {
        final /* synthetic */ EmojiAddCustomDialogUI kPC;

        {
            this.kPC = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED /*1001*/:
                    EmojiAddCustomDialogUI.a(this.kPC, this.kPC.getString(R.l.edY));
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ void a(EmojiAddCustomDialogUI emojiAddCustomDialogUI, String str) {
        emojiAddCustomDialogUI.getString(R.l.dIO);
        emojiAddCustomDialogUI.kIa = g.a(emojiAddCustomDialogUI, str, true, new OnCancelListener(emojiAddCustomDialogUI) {
            final /* synthetic */ EmojiAddCustomDialogUI kPC;

            {
                this.kPC = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(0);
        }
        this.mContext = this;
        this.kPx = getIntent().getStringExtra("extra_id");
        this.hPi = getIntent().getIntExtra("extra_scence", -1);
        this.kPy = getIntent().getStringExtra("extra_username");
        if (bg.mA(this.kPx)) {
            w.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "md5 is null.");
            finish();
        }
        this.kPz = com.tencent.mm.plugin.emoji.model.h.amc().kLa.Si(this.kPx);
        ap.vd().a(698, this);
        ap.vd().a(423, this);
        ap.vd().a(703, this);
        this.mHandler.sendEmptyMessageDelayed(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, 300);
        Context context = this.mContext;
        final c cVar = this.kPz;
        if (context == null) {
            w.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. context is null");
        } else if (cVar == null) {
            w.e("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. emoji is null");
        } else {
            b Ur = b.Ur(cVar.eN(cVar.field_groupId, cVar.EP()));
            Ur.hP = com.tencent.mm.i.b.sA();
            Ur.Cg(com.tencent.mm.i.b.sB()).a(new a(this) {
                final /* synthetic */ EmojiAddCustomDialogUI kPC;

                public final void a(b bVar) {
                    if (com.tencent.mm.plugin.emoji.model.h.amc().kLa.jZ(false) >= n.alO()) {
                        w.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji failed. over max size.");
                        this.kPC.amV();
                        this.kPC.ane();
                        com.tencent.mm.plugin.report.service.g.oUh.i(10431, new Object[]{Integer.valueOf(this.kPC.hPi), this.kPC.kPz.EP(), this.kPC.kPz.field_designerID, this.kPC.kPz.field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(this.kPC.kPz.field_size), this.kPC.kPy, this.kPC.kPz.field_activityid});
                    } else if (cVar.field_catalog == c.uKY || bg.mA(cVar.field_groupId) || (!bg.mA(cVar.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().uf(cVar.field_groupId))) {
                        EmojiAddCustomDialogUI.j(cVar);
                    } else {
                        ap.vd().a(new com.tencent.mm.plugin.emoji.f.g(cVar.field_groupId, (byte) 0), 0);
                    }
                }

                public final void anf() {
                    this.kPC.amV();
                    this.kPC.kPA = g.a(this.kPC.mContext, this.kPC.mContext.getString(R.l.ecv), "", this.kPC.getString(R.l.esq), new OnClickListener(this.kPC) {
                        final /* synthetic */ EmojiAddCustomDialogUI kPC;

                        {
                            this.kPC = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.kPC.finish();
                        }
                    });
                    com.tencent.mm.plugin.report.service.g.oUh.i(10431, new Object[]{Integer.valueOf(this.kPC.hPi), this.kPC.kPz.EP(), this.kPC.kPz.field_designerID, this.kPC.kPz.field_groupId, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(this.kPC.kPz.field_size), this.kPC.kPy, this.kPC.kPz.field_activityid});
                }
            });
        }
    }

    protected void onDestroy() {
        ap.vd().b(698, this);
        ap.vd().b(423, this);
        ap.vd().b(703, this);
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, k kVar) {
        int type = kVar.getType();
        if (type == 698) {
            if (i2 == -434) {
                w.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error over size.");
                amV();
                ane();
                com.tencent.mm.plugin.report.service.g.oUh.i(10431, new Object[]{Integer.valueOf(this.hPi), this.kPz.EP(), this.kPz.field_designerID, this.kPz.field_groupId, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(this.kPz.field_size), this.kPy, this.kPz.field_activityid});
            } else if (i == 0 && i2 == 0) {
                w.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd ok.");
                ea eaVar = (ea) ((com.tencent.mm.plugin.emoji.f.c) kVar).gUA.hsk.hsr;
                if (((eaVar != null ? 1 : 0) & (eaVar.thP != null ? 1 : 0)) == 0 || eaVar.thP.size() <= 0) {
                    and();
                    return;
                }
                w.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "upload size is %d", new Object[]{Integer.valueOf(eaVar.thP.size())});
                eaVar.thP.get(0);
                ap.vd().a(new f(this.kPz), 0);
                w.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "start upload emoji");
            } else {
                anc();
            }
        } else if (type == 423) {
            com.tencent.mm.plugin.emoji.f.g gVar = (com.tencent.mm.plugin.emoji.f.g) kVar;
            if (gVar == null || bg.mA(gVar.kMS) || this.kPz == null || bg.mA(this.kPz.field_groupId) || !this.kPz.field_groupId.equalsIgnoreCase(gVar.kMS)) {
                w.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "no the same product ID");
            } else if (i == 0 && i2 == 0) {
                j(this.kPz);
            } else if (i2 == 4) {
                amV();
                uC(getString(R.l.ecl));
            } else if (i2 == 8) {
                amV();
                uC(getString(R.l.eck));
            } else if (i2 == 9) {
                amV();
                uC(getString(R.l.ecj));
            } else if (i2 == -2) {
                amV();
                uC(getString(R.l.ecm));
            } else {
                amV();
                uC(getString(R.l.eci));
            }
        } else if (type != 703) {
        } else {
            if (i == 0 && i2 == 0) {
                and();
            } else {
                anc();
            }
        }
    }

    private void anc() {
        w.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji onSceneEnd error.");
        amV();
        g.bl(this.mContext, ab.getContext().getString(R.l.eci));
        com.tencent.mm.plugin.report.service.g.oUh.i(10431, new Object[]{Integer.valueOf(this.hPi), this.kPz.EP(), this.kPz.field_designerID, this.kPz.field_groupId, Integer.valueOf(1), Integer.valueOf(3), Integer.valueOf(this.kPz.field_size), this.kPy, this.kPz.field_activityid});
        finish();
    }

    private void and() {
        w.d("MicroMsg.emoji.EmojiAddCustomDialogUI", "dealSaveSuccess");
        if (this.kPz.field_catalog != c.uKY) {
            this.kPz.field_catalog = c.uKY;
            int bNE = com.tencent.mm.plugin.emoji.model.h.amc().kLa.bNE();
            if (bNE < n.alO()) {
                bNE = n.alO();
            } else {
                bNE++;
            }
            this.kPz.field_reserved3 = bNE;
            com.tencent.mm.plugin.emoji.model.h.amc().kLa.t(this.kPz);
            com.tencent.mm.plugin.report.service.g.oUh.i(10431, new Object[]{Integer.valueOf(this.hPi), this.kPz.EP(), this.kPz.field_designerID, this.kPz.field_groupId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(this.kPz.field_size), this.kPy, this.kPz.field_activityid});
            com.tencent.mm.plugin.emoji.e.e.alz().c(this.kPz, false);
        }
        String str = this.kPz.eN(this.kPz.field_groupId, this.kPz.EP()) + "_cover";
        if (!(bg.mA(this.kPz.field_thumbUrl) || com.tencent.mm.a.e.aO(str))) {
            com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
            aVar.hIN = str;
            aVar.hIL = true;
            aVar.hIJ = false;
            com.tencent.mm.ah.n.GW().a(this.kPz.field_thumbUrl, null, aVar.Hg());
        }
        com.tencent.mm.storage.a.b bVar = com.tencent.mm.plugin.emoji.model.h.amc().kLb;
        if (!com.tencent.mm.storage.a.b.bNg()) {
            com.tencent.mm.plugin.emoji.model.h.amc().kLb.bNh();
        }
        amV();
        g.bl(this.mContext, ab.getContext().getString(R.l.dDk));
        finish();
    }

    private static void j(c cVar) {
        w.i("MicroMsg.emoji.EmojiAddCustomDialogUI", "[cpan] save emoji start.do NetSceneBackupEmojiOperate ");
        List arrayList = new ArrayList();
        arrayList.add(cVar.EP());
        ap.vd().a(new com.tencent.mm.plugin.emoji.f.c(1, arrayList), 0);
    }

    private void ane() {
        this.kPA = g.a(this.mContext, R.l.eep, R.l.dGO, R.l.edr, R.l.dGs, new OnClickListener(this) {
            final /* synthetic */ EmojiAddCustomDialogUI kPC;

            {
                this.kPC = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent();
                com.tencent.mm.plugin.report.service.g.oUh.i(11596, new Object[]{Integer.valueOf(3)});
                intent.setClass(this.kPC.mContext, EmojiCustomUI.class);
                this.kPC.startActivity(intent);
            }
        }, new OnClickListener(this) {
            final /* synthetic */ EmojiAddCustomDialogUI kPC;

            {
                this.kPC = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.kPC.finish();
            }
        });
        if (this.kPA != null) {
            this.kPA.setOnDismissListener(new OnDismissListener(this) {
                final /* synthetic */ EmojiAddCustomDialogUI kPC;

                {
                    this.kPC = r1;
                }

                public final void onDismiss(DialogInterface dialogInterface) {
                    this.kPC.finish();
                }
            });
        }
    }

    private void uC(String str) {
        this.kPB = g.b(this, str, "", true);
        this.kPB.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ EmojiAddCustomDialogUI kPC;

            {
                this.kPC = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                this.kPC.finish();
            }
        });
    }

    protected final void amV() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
        }
        if (this.kIa != null && this.kIa.isShowing()) {
            this.kIa.dismiss();
        }
    }
}
