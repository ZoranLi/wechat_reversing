package com.tencent.mm.plugin.record.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.e.a.js;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.e;
import java.util.LinkedList;
import java.util.List;

public class FavRecordDetailUI extends RecordMsgBaseUI {
    private boolean fQy = true;
    private String lJZ = String.valueOf(this.lLP);
    private long lLP = -1;
    private c oOX;
    private boolean oOY = true;
    private com.tencent.mm.sdk.b.c oOZ = new com.tencent.mm.sdk.b.c<js>(this) {
        final /* synthetic */ FavRecordDetailUI oPa;

        {
            this.oPa = r2;
            this.usg = js.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            js jsVar = (js) bVar;
            if (this.oPa.lLP == ((long) jsVar.fQf.fQg)) {
                c cR = d.cR((long) jsVar.fQf.fQg);
                a bVar2 = new b();
                bVar2.oOR = cR;
                if (!(cR == null || cR.field_favProto == null)) {
                    bVar2.oOQ = cR.field_favProto.tzn;
                    this.oPa.oPm.a(bVar2);
                }
            }
            return false;
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    protected final void aWK() {
        this.lLP = getIntent().getLongExtra("key_detail_info_id", -1);
        this.fQy = getIntent().getBooleanExtra("show_share", true);
        this.oOX = d.cR(this.lLP);
        this.lJZ = String.valueOf(this.lLP);
        if (this.oOX == null) {
            finish();
            return;
        }
        a bVar = new b();
        bVar.oOR = this.oOX;
        bVar.oOQ = this.oOX.field_favProto.tzn;
        List<rm> list = bVar.oOQ;
        if (list == null) {
            this.oOY = false;
        } else if (list.size() == 0) {
            this.oOY = false;
        } else {
            for (rm rmVar : list) {
                if (rmVar.tyq != 0) {
                    this.oOY = false;
                    break;
                }
            }
            this.oOY = true;
        }
        super.aWK();
        this.oPm.a(bVar);
        a.urY.b(this.oOZ);
        a.urY.b(((d) this.oPm).oOT);
    }

    protected final h aWL() {
        return new d(this, new c(this));
    }

    protected void onResume() {
        super.onResume();
        b bVar = (b) ((d) this.oPm).oPi;
        if (bVar.oOR != null) {
            c cR = d.cR(bVar.oOR.field_localId);
            if (cR != null && cR.field_favProto != null) {
                Object obj;
                LinkedList linkedList = cR.field_favProto.tzn;
                for (rm contains : bVar.oOQ) {
                    if (!linkedList.contains(contains)) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    a bVar2 = new b();
                    bVar2.oOR = cR;
                    bVar2.oOQ = cR.field_favProto.tzn;
                    this.oPm.a(bVar2);
                }
            }
        }
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onDestroy() {
        if (this.oOZ != null) {
            a.urY.c(this.oOZ);
        }
        if (!(this.oPm == null || ((d) this.oPm).oOT == null)) {
            a.urY.c(((d) this.oPm).oOT);
        }
        super.onDestroy();
    }

    protected final String aWM() {
        if (14 == this.oOX.field_type && !bg.mA(this.oOX.field_favProto.title)) {
            return this.oOX.field_favProto.title;
        }
        rw rwVar = this.oOX.field_favProto.tzl;
        if (rwVar == null || bg.mA(rwVar.tyQ)) {
            w.v("MicroMsg.FavRecordDetailUI", "display name, from item info user[%s]", new Object[]{this.oOX.field_fromUser});
            return m.eL(this.oOX.field_fromUser);
        }
        String eK = n.eK(rwVar.tyQ);
        String eL;
        if (com.tencent.mm.u.m.xL().equals(rwVar.fOu)) {
            eL = m.eL(rwVar.toUser);
            if (!bg.ap(eL, "").equals(rwVar.toUser)) {
                eK = eK + " - " + eL;
            }
        } else {
            eL = m.eL(rwVar.fOu);
            if (!bg.ap(eL, "").equals(rwVar.fOu)) {
                eK = eK + " - " + eL;
            }
        }
        w.v("MicroMsg.FavRecordDetailUI", "display name, source from[%s] to[%s]", new Object[]{rwVar.fOu, rwVar.toUser});
        return eK;
    }

    protected final String aWN() {
        LinkedList linkedList = this.oOX.field_favProto.tzn;
        if (linkedList.size() > 0) {
            return ((rm) linkedList.getFirst()).tyg;
        }
        return null;
    }

    protected final String aWO() {
        LinkedList linkedList = this.oOX.field_favProto.tzn;
        if (linkedList.size() > 0) {
            return ((rm) linkedList.getLast()).tyg;
        }
        return null;
    }

    protected final void aWP() {
        if (this.fQy) {
            a(0, R.l.eYj, R.g.bhb, new OnMenuItemClickListener(this) {
                final /* synthetic */ FavRecordDetailUI oPa;

                {
                    this.oPa = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    e eVar = new e(this.oPa.uSU.uTo, e.wuP, false);
                    eVar.qJf = new com.tencent.mm.ui.base.n.c(this) {
                        final /* synthetic */ AnonymousClass2 oPb;

                        {
                            this.oPb = r1;
                        }

                        public final void a(l lVar) {
                            w.i("MicroMsg.FavRecordDetailUI", "favItemInfo: id %d, status %d", new Object[]{Integer.valueOf(this.oPb.oPa.oOX.field_id), Integer.valueOf(this.oPb.oPa.oOX.field_itemStatus)});
                            if (this.oPb.oPa.oOX.field_id > 0 && !this.oPb.oPa.oOX.ati() && !this.oPb.oPa.oOX.atj() && this.oPb.oPa.oOY) {
                                lVar.e(0, this.oPb.oPa.getString(R.l.ejs));
                            }
                            lVar.e(3, this.oPb.oPa.getString(R.l.ehS));
                            lVar.e(2, this.oPb.oPa.getString(R.l.dGB));
                        }
                    };
                    eVar.qJg = new com.tencent.mm.ui.base.n.d(this) {
                        final /* synthetic */ AnonymousClass2 oPb;

                        {
                            this.oPb = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            Intent intent;
                            switch (menuItem.getItemId()) {
                                case 0:
                                    intent = new Intent();
                                    intent.putExtra("Select_Conv_Type", 3);
                                    intent.putExtra("scene_from", 1);
                                    intent.putExtra("mutil_select_is_ret", true);
                                    intent.putExtra("select_fav_local_id", this.oPb.oPa.oOX.field_localId);
                                    com.tencent.mm.bb.d.a(this.oPb.oPa, ".ui.transmit.SelectConversationUI", intent, 4097);
                                    g.oUh.i(10651, new Object[]{Integer.valueOf(14), Integer.valueOf(1), Integer.valueOf(0)});
                                    return;
                                case 2:
                                    com.tencent.mm.ui.base.g.a(this.oPb.oPa.uSU.uTo, this.oPb.oPa.getString(R.l.dGC), "", new OnClickListener(this) {
                                        final /* synthetic */ AnonymousClass2 oPc;

                                        {
                                            this.oPc = r1;
                                        }

                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            final p a = com.tencent.mm.ui.base.g.a(this.oPc.oPb.oPa.uSU.uTo, this.oPc.oPb.oPa.getString(R.l.dGC), false, null);
                                            b fpVar = new fp();
                                            fpVar.fKp.type = 12;
                                            fpVar.fKp.fFx = this.oPc.oPb.oPa.lLP;
                                            fpVar.fKp.fKu = new Runnable(this) {
                                                final /* synthetic */ AnonymousClass1 oPd;

                                                public final void run() {
                                                    a.dismiss();
                                                    w.d("MicroMsg.FavRecordDetailUI", "do del, local id %d", new Object[]{Long.valueOf(this.oPd.oPc.oPb.oPa.lLP)});
                                                    this.oPd.oPc.oPb.oPa.finish();
                                                }
                                            };
                                            a.urY.m(fpVar);
                                        }
                                    }, null);
                                    return;
                                case 3:
                                    intent = new Intent();
                                    intent.putExtra("key_fav_scene", 2);
                                    intent.putExtra("key_fav_item_id", this.oPb.oPa.lLP);
                                    com.tencent.mm.bb.d.b(this.oPb.oPa.uSU.uTo, "favorite", ".ui.FavTagEditUI", intent);
                                    return;
                                case 4:
                                    intent = new Intent();
                                    intent.putExtra("key_fav_scene", 1);
                                    intent.putExtra("key_fav_item_id", this.oPb.oPa.oOX.field_localId);
                                    com.tencent.mm.bb.d.b(this.oPb.oPa.uSU.uTo, "favorite", ".ui.FavTagEditUI", intent);
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
        if (4097 == i && -1 == i2) {
            b fpVar = new fp();
            fpVar.fKp.type = 32;
            fpVar.fKp.fFx = this.lLP;
            a.urY.m(fpVar);
            if (fpVar.fKq.fKF) {
                com.tencent.mm.ui.base.g.bl(this.uSU.uTo, getString(R.l.dAL));
                return;
            }
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            final Dialog a = com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.eit), false, null);
            b fpVar2 = new fp();
            fpVar2.fKp.type = 13;
            fpVar2.fKp.context = this.uSU.uTo;
            fpVar2.fKp.toUser = stringExtra;
            fpVar2.fKp.fKv = stringExtra2;
            fpVar2.fKp.fFx = this.lLP;
            fpVar2.fKp.fKu = new Runnable(this) {
                final /* synthetic */ FavRecordDetailUI oPa;

                public final void run() {
                    a.dismiss();
                    com.tencent.mm.ui.snackbar.a.e(this.oPa, this.oPa.getString(R.l.ekV));
                }
            };
            a.urY.m(fpVar2);
        }
    }
}
