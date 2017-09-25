package com.tencent.mm.plugin.record.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.record.a.m;
import com.tencent.mm.plugin.record.a.s;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.t.f.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.e;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;
import java.util.Iterator;

public class RecordMsgDetailUI extends RecordMsgBaseUI {
    private long fGM = -1;
    private boolean fQy = true;
    private String fTh = null;
    private p iLz = null;
    private c oPp = null;
    private boolean oPq = false;
    private String oPr = "";
    private String oPs = "";
    private String title = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void aWK() {
        this.fGM = getIntent().getLongExtra("message_id", -1);
        this.fTh = getIntent().getStringExtra("record_xml");
        this.fQy = getIntent().getBooleanExtra("record_show_share", true);
        this.oPq = getIntent().getBooleanExtra("big_appmsg", false);
        this.oPp = m.Dp(this.fTh);
        if (this.oPp != null) {
            if (a(this.oPp) != null) {
                this.title = a(this.oPp);
            } else {
                this.title = this.oPp.title;
            }
            if (!bg.bV(this.oPp.hkm)) {
                this.oPr = ((rm) this.oPp.hkm.getFirst()).tyg;
                this.oPs = ((rm) this.oPp.hkm.getLast()).tyg;
            }
        } else {
            ap.yY();
            ce cA = com.tencent.mm.u.c.wT().cA(this.fGM);
            a B = a.B(cA.field_content, cA.field_reserved);
            if (B != null) {
                this.title = B.title;
                this.iLz = p.b(this, getString(R.l.cbS), true, 0, null);
            }
        }
        if (this.fTh == null || this.oPp == null) {
            aWS();
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ RecordMsgDetailUI oPt;

                {
                    this.oPt = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.oPt.finish();
                    return true;
                }
            });
            if (this.oPq && an.abL().eb(this.fGM) != null) {
                ap.yY();
                ap.vd().a(new ab(this.fGM, com.tencent.mm.u.c.wT().cA(this.fGM).field_msgSvrId, new f(this) {
                    final /* synthetic */ RecordMsgDetailUI oPt;

                    {
                        this.oPt = r1;
                    }

                    public final void a(int i, int i2, k kVar) {
                        if (i == i2) {
                            if (this.oPt.iLz != null) {
                                this.oPt.iLz.dismiss();
                                this.oPt.iLz = null;
                            }
                            ap.yY();
                            ce cA = com.tencent.mm.u.c.wT().cA(this.oPt.fGM);
                            String str = cA.field_content;
                            if (o.dH(cA.field_talker)) {
                                str = ay.gj(cA.field_content);
                            }
                            a ek = a.ek(str);
                            if (ek != null) {
                                this.oPt.fTh = ek.hhQ;
                                this.oPt.oPp = m.Dp(this.oPt.fTh);
                                if (this.oPt.oPp != null) {
                                    if (this.oPt.a(this.oPt.oPp) != null) {
                                        this.oPt.title = this.oPt.a(this.oPt.oPp);
                                    } else {
                                        this.oPt.title = this.oPt.oPp.title;
                                    }
                                    this.oPt.oPr = ((rm) this.oPt.oPp.hkm.getFirst()).tyg;
                                    this.oPt.oPs = ((rm) this.oPt.oPp.hkm.getLast()).tyg;
                                }
                                this.oPt.ar();
                            }
                        }
                    }
                }), 0);
                return;
            }
            return;
        }
        ar();
    }

    private String a(c cVar) {
        Object obj = null;
        if (cVar == null) {
            return null;
        }
        Iterator it = cVar.hkm.iterator();
        int i = 0;
        Object obj2 = null;
        String str = null;
        while (it.hasNext()) {
            rm rmVar = (rm) it.next();
            if (rmVar.tyc.tyu.tyQ != null) {
                i = 1;
                str = this.uSU.uTo.getString(R.l.eIF);
            } else {
                String str2;
                if (rmVar.tyc.tyu.fOu != null) {
                    if (obj2 == null) {
                        obj2 = rmVar.tye;
                    } else if (obj2 != rmVar.tye) {
                        str2 = rmVar.tye;
                        obj = str2;
                    }
                }
                str2 = obj;
                obj = str2;
            }
        }
        if (obj2 != null && obj == null && r2 == 0) {
            return this.uSU.uTo.getString(R.l.ejc, new Object[]{obj2});
        } else if (obj2 == null || obj == null || obj2 == obj || r2 != 0) {
            return str;
        } else {
            return this.uSU.uTo.getString(R.l.ejb, new Object[]{obj2, obj});
        }
    }

    private void ar() {
        a fVar = new f();
        fVar.oOQ = this.oPp.hkm;
        fVar.fGM = this.fGM;
        fVar.fTh = this.fTh;
        super.aWK();
        this.oPm.a(fVar);
        s.aWF().a((e) this.oPm);
    }

    protected final h aWL() {
        return new e(this, new g());
    }

    protected void onDestroy() {
        super.onDestroy();
        s.aWF().b((e) this.oPm);
    }

    protected final String aWM() {
        return this.title;
    }

    protected final String aWN() {
        return this.oPr;
    }

    protected final String aWO() {
        return this.oPs;
    }

    protected final void aWP() {
        if (this.fQy) {
            a(0, R.g.bhb, new OnMenuItemClickListener(this) {
                final /* synthetic */ RecordMsgDetailUI oPt;

                {
                    this.oPt = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    e eVar = new e(this.oPt.uSU.uTo, e.wuP, false);
                    eVar.qJf = new n.c(this) {
                        final /* synthetic */ AnonymousClass3 oPu;

                        {
                            this.oPu = r1;
                        }

                        public final void a(l lVar) {
                            lVar.e(0, this.oPu.oPt.getString(R.l.ejs));
                            lVar.e(2, this.oPu.oPt.getString(R.l.eGa));
                        }
                    };
                    eVar.qJg = new d(this) {
                        final /* synthetic */ AnonymousClass3 oPu;

                        {
                            this.oPu = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            switch (menuItem.getItemId()) {
                                case 0:
                                    Intent intent = new Intent();
                                    intent.putExtra("Select_Conv_Type", 3);
                                    intent.putExtra("select_is_ret", true);
                                    intent.putExtra("mutil_select_is_ret", true);
                                    intent.putExtra("Retr_Msg_Type", 10);
                                    intent.putExtra("Retr_Msg_Id", this.oPu.oPt.fGM);
                                    com.tencent.mm.bb.d.a(this.oPu.oPt, ".ui.transmit.SelectConversationUI", intent, MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
                                    return;
                                case 2:
                                    b cbVar = new cb();
                                    com.tencent.mm.pluginsdk.model.e.a(cbVar, this.oPu.oPt.fGM);
                                    cbVar.fFA.fFH = 9;
                                    cbVar.fFA.activity = this.oPu.oPt;
                                    com.tencent.mm.sdk.b.a.urY.m(cbVar);
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    eVar.bzh();
                    return true;
                }
            });
        }
    }

    protected final void b(int i, int i2, Intent intent) {
        if (-1 != i2) {
            w.e("MicroMsg.RecordMsgDetailUI", "processResult %d", new Object[]{Integer.valueOf(i2)});
        } else if (MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED == i) {
            final String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            final String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            if (bg.mA(stringExtra)) {
                w.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but toUser is null");
                return;
            }
            ap.yY();
            final ce cA = com.tencent.mm.u.c.wT().cA(this.fGM);
            if (cA.field_msgId != this.fGM) {
                w.w("MicroMsg.RecordMsgDetailUI", "want to send record msg, but message info is null");
                return;
            }
            final Dialog a = g.a(this.uSU.uTo, getString(R.l.eit), false, null);
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ RecordMsgDetailUI oPt;

                public final void run() {
                    m.a(stringExtra, stringExtra2, cA);
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 oPw;

                        {
                            this.oPw = r1;
                        }

                        public final void run() {
                            a.dismiss();
                        }
                    });
                }

                public final String toString() {
                    return super.toString() + "|onActivityResult";
                }
            });
        } else if (MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED == i && intent.getBooleanExtra("kfavorite", false)) {
            b cbVar = new cb();
            com.tencent.mm.pluginsdk.model.e.a(cbVar, intent);
            cbVar.fFA.activity = this;
            cbVar.fFA.fFH = 8;
            com.tencent.mm.sdk.b.a.urY.m(cbVar);
        }
    }
}
