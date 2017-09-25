package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.a.h;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.m;
import com.tencent.mm.protocal.c.ss;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.conversation.BaseConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI.b;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.r;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;

public class BizChatConversationUI extends BaseConversationUI {
    private View ipu;

    public static class a extends b implements m, com.tencent.mm.sdk.e.m.b {
        public String hvg;
        public p irJ;
        public TextView jWk;
        public ListView jWl;
        public d jWo;
        public boolean jWp = false;
        public com.tencent.mm.ui.tools.m kaF;
        public int kaQ = 0;
        public int kaR = 0;
        public long kbc;
        public String kbi;
        public boolean uPP;
        private LinearLayout vvE;
        public b vvF;
        j vvG;
        public int vvH = 0;
        private com.tencent.mm.modelbiz.a.b.a vvI = new com.tencent.mm.modelbiz.a.b.a(this) {
            final /* synthetic */ a vvL;

            {
                this.vvL = r1;
            }

            public final void a(com.tencent.mm.modelbiz.a.b.a.b bVar) {
                if (bVar != null && bVar.hwH != null && this.vvL.kbi.equals(bVar.hwH.field_brandUserName)) {
                    w.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChatConv change");
                    this.vvL.vvF.eE(bVar.hwG);
                    if (this.vvL.uPP) {
                        this.vvL.vvF.OK();
                    }
                }
            }
        };
        private com.tencent.mm.modelbiz.a.d.a vvJ = new com.tencent.mm.modelbiz.a.d.a(this) {
            final /* synthetic */ a vvL;

            {
                this.vvL = r1;
            }

            public final void a(com.tencent.mm.modelbiz.a.d.a.b bVar) {
                if (bVar != null && bVar.hwR != null && this.vvL.kbi.equals(bVar.hwR.field_brandUserName)) {
                    w.i("MicroMsg.BizChatConversationFmUI", "bizChatExtension bizChat change");
                    this.vvL.vvF.eE(bVar.hwG);
                    if (this.vvL.uPP) {
                        this.vvL.vvF.OK();
                    }
                }
            }
        };
        private com.tencent.mm.modelbiz.c.a vvK = new com.tencent.mm.modelbiz.c.a(this) {
            final /* synthetic */ a vvL;

            {
                this.vvL = r1;
            }

            public final void a(com.tencent.mm.modelbiz.c.a.a aVar) {
                String bTp = this.vvL.bTp();
                if (aVar != null && !bg.mA(aVar.huj) && aVar.huj.equals(bTp)) {
                    int i = this.vvL.vvH;
                    this.vvL.vvH = f.bd(this.vvL.uSU.uTo, bTp);
                    if (this.vvL.vvH != i) {
                        this.vvL.bTn();
                    }
                }
            }
        };

        class AnonymousClass8 implements com.tencent.mm.u.ay.a {
            final /* synthetic */ long hlk;
            final /* synthetic */ a vvL;

            AnonymousClass8(a aVar, long j) {
                this.vvL = aVar;
                this.hlk = j;
            }

            public final boolean zs() {
                return this.vvL.jWp;
            }

            public final void zr() {
                int i = 0;
                if (this.vvL.irJ != null) {
                    com.tencent.mm.modelbiz.w.DJ().V(this.hlk);
                    com.tencent.mm.modelbiz.w.DK().V(this.hlk);
                    com.tencent.mm.modelbiz.a.b DK = com.tencent.mm.modelbiz.w.DK();
                    String str = this.vvL.kbi;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("select count(*) from BizChatConversation");
                    stringBuilder.append(" where brandUserName = '").append(str).append("' ");
                    Cursor a = DK.gUz.a(stringBuilder.toString(), null, 2);
                    if (a != null) {
                        if (a.moveToFirst()) {
                            i = a.getInt(0);
                        }
                        a.close();
                    }
                    if (i <= 0) {
                        ap.yY();
                        c.wW().Rl(this.vvL.kbi);
                    }
                    this.vvL.irJ.dismiss();
                }
            }
        }

        public final void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.kbi = bPj().getIntent().getStringExtra("Contact_User");
            w.i("MicroMsg.BizChatConversationFmUI", "[regitListener]");
            com.tencent.mm.modelbiz.w.DK().a(this.vvI, bPj().getMainLooper());
            com.tencent.mm.modelbiz.w.DJ().a(this.vvJ, bPj().getMainLooper());
            com.tencent.mm.modelbiz.w.DO().a(this.vvK, bPj().getMainLooper());
            ap.yY();
            c.wW().a(this);
            this.jWk = (TextView) findViewById(R.h.bLU);
            this.jWk.setText(R.l.ezg);
            this.jWl = (ListView) findViewById(R.h.cJi);
            bTn();
            this.vvF = new b(bPj(), new com.tencent.mm.ui.k.a(this) {
                final /* synthetic */ a vvL;

                {
                    this.vvL = r1;
                }

                public final void OH() {
                    this.vvL.qP(n.eK(this.vvL.kbi));
                    if (this.vvL.vvF.getCount() <= 0) {
                        this.vvL.jWk.setVisibility(0);
                        this.vvL.jWl.setVisibility(8);
                        return;
                    }
                    this.vvL.jWk.setVisibility(8);
                    if (this.vvL.jWl != null) {
                        this.vvL.jWl.setVisibility(0);
                    }
                }

                public final void OI() {
                }
            }, this.kbi);
            this.vvF.a(new MMSlideDelView.c(this) {
                final /* synthetic */ a vvL;

                {
                    this.vvL = r1;
                }

                public final int cb(View view) {
                    return this.vvL.jWl.getPositionForView(view);
                }
            });
            this.vvF.a(new MMSlideDelView.f(this) {
                final /* synthetic */ a vvL;

                {
                    this.vvL = r1;
                }

                public final void s(View view, int i) {
                    this.vvL.jWl.performItemClick(view, i, 0);
                }
            });
            this.vvF.a(new e(this) {
                final /* synthetic */ a vvL;

                {
                    this.vvL = r1;
                }

                public final void aQ(Object obj) {
                    if (obj == null) {
                        w.e("MicroMsg.BizChatConversationFmUI", "onItemDel object null");
                    }
                }
            });
            this.jWl.setAdapter(this.vvF);
            this.jWo = new d(this) {
                final /* synthetic */ a vvL;

                {
                    this.vvL = r1;
                }

                public final void c(MenuItem menuItem, int i) {
                    com.tencent.mm.modelbiz.a.a U;
                    switch (menuItem.getItemId()) {
                        case 0:
                            a aVar = this.vvL;
                            long j = this.vvL.kbc;
                            w.i("MicroMsg.BizChatConversationFmUI", "deleteChatroom");
                            com.tencent.mm.modelbiz.w.DJ().aa(j);
                            aVar.jWp = false;
                            Context bPj = aVar.bPj();
                            aVar.getString(R.l.dIO);
                            aVar.irJ = g.a(bPj, aVar.getString(R.l.dJd), true, new OnCancelListener(aVar) {
                                final /* synthetic */ a vvL;

                                {
                                    this.vvL = r1;
                                }

                                public final void onCancel(DialogInterface dialogInterface) {
                                    this.vvL.jWp = true;
                                }
                            });
                            com.tencent.mm.u.g.a(aVar.kbi, j, new AnonymousClass8(aVar, j));
                            return;
                        case 1:
                            U = com.tencent.mm.modelbiz.w.DK().U(this.vvL.kbc);
                            U.field_unReadCount = 1;
                            U.field_atCount = 0;
                            com.tencent.mm.modelbiz.w.DK().b(U);
                            com.tencent.mm.modelstat.b.hUp.A(U.field_brandUserName, true);
                            return;
                        case 2:
                            com.tencent.mm.modelbiz.w.DK().W(this.vvL.kbc);
                            com.tencent.mm.modelstat.b.hUp.A(com.tencent.mm.modelbiz.w.DK().U(this.vvL.kbc).field_brandUserName, false);
                            return;
                        case 3:
                            U = com.tencent.mm.modelbiz.w.DK().U(this.vvL.kbc);
                            if (com.tencent.mm.modelbiz.w.DK().X(this.vvL.kbc)) {
                                com.tencent.mm.modelbiz.w.DK().Z(this.vvL.kbc);
                                com.tencent.mm.modelstat.b.hUp.b(true, U.field_brandUserName, false);
                                return;
                            }
                            com.tencent.mm.modelbiz.w.DK().Y(this.vvL.kbc);
                            com.tencent.mm.modelstat.b.hUp.b(true, U.field_brandUserName, true);
                            return;
                        default:
                            return;
                    }
                }
            };
            final com.tencent.mm.ui.widget.g gVar = new com.tencent.mm.ui.widget.g(bPj());
            this.jWl.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ a vvL;

                {
                    this.vvL = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        this.vvL.kaQ = (int) motionEvent.getRawX();
                        this.vvL.kaR = (int) motionEvent.getRawY();
                    }
                    return false;
                }
            });
            this.jWl.setOnItemLongClickListener(new OnItemLongClickListener(this) {
                final /* synthetic */ a vvL;

                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    gVar.a(view, i, j, this.vvL, this.vvL.jWo, this.vvL.kaQ, this.vvL.kaR);
                    return true;
                }
            });
            this.jWl.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ a vvL;

                {
                    this.vvL = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.vvL.eF(((com.tencent.mm.modelbiz.a.a) this.vvL.vvF.getItem(i)).field_bizChatId);
                }
            });
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ a vvL;

                {
                    this.vvL = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.vvL.finish();
                    return true;
                }
            });
            a(1, R.l.eYk, R.k.dsU, new OnMenuItemClickListener(this) {
                final /* synthetic */ a vvL;

                {
                    this.vvL = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    w.v("MicroMsg.BizChatConversationFmUI", "search btn was clicked.");
                    Intent intent = new Intent(this.vvL.uSU.uTo, BizChatSearchUI.class);
                    intent.putExtra("enterprise_biz_name", this.vvL.kbi);
                    intent.putExtra("biz_chat_search_scene", 1);
                    intent.putExtra("biz_chat_search_text", "");
                    intent.addFlags(67108864);
                    this.vvL.startActivity(intent);
                    return true;
                }
            });
            a(2, R.l.dBP, R.k.dsI, new OnMenuItemClickListener(this) {
                final /* synthetic */ a vvL;

                {
                    this.vvL = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    if (this.vvL.kaF != null) {
                        this.vvL.kaF.dismiss();
                        this.vvL.kaF = null;
                    }
                    this.vvL.kaF = new com.tencent.mm.ui.tools.m(this.vvL.uSU.uTo);
                    this.vvL.kaF.qJf = new com.tencent.mm.ui.base.n.c(this) {
                        final /* synthetic */ AnonymousClass5 vvM;

                        {
                            this.vvM = r1;
                        }

                        public final void a(l lVar) {
                            if (this.vvM.vvL.vvH == 1) {
                                lVar.W(2, R.l.efa, R.k.dsN);
                                f.j(this.vvM.vvL.uSU.uTo, this.vvM.vvL.kbi, 6);
                            }
                            lVar.W(1, R.l.dOU, R.k.dsJ);
                            lVar.W(4, R.l.dOT, R.k.dsL);
                            lVar.W(3, R.l.dBQ, R.k.dsW);
                        }
                    };
                    this.vvL.kaF.qJg = new d(this) {
                        final /* synthetic */ AnonymousClass5 vvM;

                        {
                            this.vvM = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            Intent intent;
                            switch (menuItem.getItemId()) {
                                case 1:
                                    q qVar = this.vvM.vvL;
                                    qVar.vvG = com.tencent.mm.modelbiz.w.DL().iD(com.tencent.mm.modelbiz.w.DL().iF(qVar.kbi));
                                    if (qVar.vvG == null || bg.mA(qVar.vvG.field_addMemberUrl)) {
                                        Toast.makeText(qVar.bPj(), qVar.getString(R.l.dOV), 0).show();
                                        qVar.bTo();
                                        return;
                                    }
                                    Intent intent2 = new Intent();
                                    intent2.putExtra("rawUrl", qVar.vvG.field_addMemberUrl);
                                    w.i("MicroMsg.BizChatConversationFmUI", "KRawUrl :%s", qVar.vvG.field_addMemberUrl);
                                    intent2.putExtra("useJs", true);
                                    intent2.addFlags(67108864);
                                    com.tencent.mm.bb.d.b(qVar.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent2, 1);
                                    return;
                                case 2:
                                    f.k(this.vvM.vvL.uSU.uTo, this.vvM.vvL.kbi, 6);
                                    return;
                                case 3:
                                    if (bg.mA(this.vvM.vvL.hvg)) {
                                        BizInfo hO = com.tencent.mm.modelbiz.w.DH().hO(this.vvM.vvL.kbi);
                                        this.vvM.vvL.hvg = hO.CO();
                                    }
                                    if (!bg.mA(this.vvM.vvL.hvg) && com.tencent.mm.modelbiz.w.DR().hB(this.vvM.vvL.hvg)) {
                                        com.tencent.mm.modelbiz.w.DO();
                                        com.tencent.mm.modelbiz.c.a(this.vvM.vvL.hvg, null);
                                    }
                                    intent = new Intent();
                                    intent.putExtra("Contact_User", this.vvM.vvL.kbi);
                                    com.tencent.mm.bb.d.b(this.vvM.vvL.bPj(), "profile", ".ui.ContactInfoUI", intent);
                                    return;
                                case 4:
                                    if (bg.mA(this.vvM.vvL.kbi)) {
                                        w.e("MicroMsg.BizChatConversationFmUI", "brandUserName null");
                                        return;
                                    }
                                    intent = new Intent(this.vvM.vvL.uSU.uTo, BizChatFavUI.class);
                                    intent.putExtra("Contact_User", this.vvM.vvL.kbi);
                                    intent.addFlags(67108864);
                                    this.vvM.vvL.startActivity(intent);
                                    return;
                                default:
                                    return;
                            }
                        }
                    };
                    this.vvL.kaF.dL();
                    return false;
                }
            });
            bTo();
            ap.vL().e(new Runnable(this) {
                final /* synthetic */ a vvL;

                {
                    this.vvL = r1;
                }

                public final void run() {
                    w.i("MicroMsg.BizChatConversationFmUI", "updateChatInfoFromSvr");
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    Cursor io = com.tencent.mm.modelbiz.w.DK().io(this.vvL.kbi);
                    if (io.moveToFirst()) {
                        while (!io.isAfterLast()) {
                            com.tencent.mm.modelbiz.a.a aVar = new com.tencent.mm.modelbiz.a.a();
                            aVar.b(io);
                            io.moveToNext();
                            com.tencent.mm.modelbiz.a.c aa = com.tencent.mm.modelbiz.w.DJ().aa(aVar.field_bizChatId);
                            if (aa.DW()) {
                                if (aa.DV()) {
                                    linkedList2.add(aa.field_bizChatServId);
                                } else {
                                    linkedList.add(aa.field_bizChatServId);
                                }
                            }
                        }
                    }
                    io.close();
                    if (linkedList2.size() > 0) {
                        com.tencent.mm.modelbiz.w.DN().a(linkedList2, this.vvL.kbi);
                    }
                    this.vvL.ay(linkedList);
                    if (linkedList.size() > 0) {
                        com.tencent.mm.modelbiz.w.DN().b(linkedList, this.vvL.kbi);
                    }
                }
            }, 300);
            String bTp = bTp();
            if (bTp != null) {
                com.tencent.mm.modelbiz.w.DO();
                com.tencent.mm.modelbiz.c.a(bTp, null);
                w.e("MicroMsg.BizChatConversationFmUI", "update father attr from svr mainBizName:%s", bTp);
            } else {
                w.e("MicroMsg.BizChatConversationFmUI", "mainBizName is null!!!");
            }
            Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                final /* synthetic */ a vvL;

                {
                    this.vvL = r1;
                }

                public final boolean queueIdle() {
                    this.vvL.hvg = com.tencent.mm.modelbiz.w.DH().hO(this.vvL.kbi).CO();
                    int intExtra = this.vvL.bPj().getIntent().getIntExtra("biz_chat_from_scene", 7);
                    int i = -1;
                    if (this.vvL.vvF != null) {
                        i = this.vvL.vvF.getCount();
                    }
                    com.tencent.mm.modelbiz.b hC = com.tencent.mm.modelbiz.w.DO().hC(this.vvL.hvg);
                    int i2 = hC != null ? hC.field_qyUin : 0;
                    int i3 = hC != null ? hC.field_userUin : 0;
                    int hE = com.tencent.mm.modelbiz.w.DO().hE(this.vvL.kbi);
                    long j = hC != null ? hC.field_wwCorpId : 0;
                    long j2 = hC != null ? hC.field_wwUserVid : 0;
                    com.tencent.mm.plugin.report.service.g.oUh.i(12648, this.vvL.hvg, this.vvL.kbi, Integer.valueOf(intExtra), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(hE), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2));
                    w.d("MicroMsg.BizChatConversationFmUI", "bizchat report belong:%s,brandUserName:%s,fromScene:%s,itemCount:%s,fatherUin:%d,childUin:%d,userUin:%d,wwCorpId:%l,wwUserVidL%l", this.vvL.hvg, this.vvL.kbi, Integer.valueOf(intExtra), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(hE), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2));
                    return false;
                }
            });
            Intent intent = bPj().getIntent();
            if (s.a(intent, "biz_chat_need_to_jump_to_chatting_ui", false)) {
                long longExtra = intent.getLongExtra("biz_chat_chat_id", -1);
                if (longExtra != -1) {
                    eF(longExtra);
                }
            }
        }

        protected final int getLayoutId() {
            return R.i.dbk;
        }

        public final String getUserName() {
            if (bg.mA(this.hvg)) {
                return this.kbi;
            }
            return this.hvg;
        }

        public final void onDestroy() {
            w.i("MicroMsg.BizChatConversationFmUI", "[unRegitListener]");
            com.tencent.mm.modelbiz.w.DK().a(this.vvI);
            com.tencent.mm.modelbiz.w.DJ().a(this.vvJ);
            com.tencent.mm.modelbiz.w.DO().a(this.vvK);
            if (ap.zb()) {
                ap.yY();
                c.wW().b(this);
            }
            this.vvF.aEW();
            b bVar = this.vvF;
            if (bVar.vvu != null) {
                bVar.vvu.clear();
                bVar.vvu = null;
            }
            super.onDestroy();
        }

        public final void onResume() {
            super.onResume();
            ap.yY();
            af Rc = c.wR().Rc(this.kbi);
            if (Rc == null || !com.tencent.mm.j.a.ez(Rc.field_type)) {
                finish();
                return;
            }
            BizInfo hW = com.tencent.mm.modelbiz.e.hW(this.kbi);
            if (hW == null || hW.field_enterpriseFather == null || !o.eU(hW.field_enterpriseFather)) {
                finish();
                return;
            }
            if (Rc.tD()) {
                zo(0);
            } else {
                zo(8);
            }
            this.uPP = true;
            this.vvF.a(null, null);
            ap.getNotification().db(this.kbi);
        }

        public final void onPause() {
            w.i("MicroMsg.BizChatConversationFmUI", "on pause");
            ap.yY();
            c.wW().Ro(this.kbi);
            com.tencent.mm.modelbiz.a.b DK = com.tencent.mm.modelbiz.w.DK();
            String str = this.kbi;
            if (bg.mA(str)) {
                w.e("MicroMsg.BizConversationStorage", "brandUserName is null");
            } else {
                boolean eE = DK.gUz.eE("BizChatConversation", "update BizChatConversation set newUnReadCount = 0 where newUnReadCount != 0 and brandUserName = '" + str + "'");
                w.d("MicroMsg.BizConversationStorage", "resetNewUnreadCount :%s,sql:%s", Boolean.valueOf(eE), str);
            }
            if (this.vvF != null) {
                this.vvF.onPause();
            }
            this.uPP = false;
            ap.getNotification().db("");
            super.onPause();
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            com.tencent.mm.modelbiz.a.a aVar = (com.tencent.mm.modelbiz.a.a) this.vvF.getItem(adapterContextMenuInfo.position);
            this.kbc = aVar.field_bizChatId;
            if (aVar.field_unReadCount <= 0) {
                contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.l.eyZ);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.l.eyX);
            }
            com.tencent.mm.modelbiz.w.DK();
            if (com.tencent.mm.modelbiz.a.b.c(aVar)) {
                contextMenu.add(adapterContextMenuInfo.position, 3, 1, R.l.eza);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 3, 1, R.l.eyY);
            }
            contextMenu.add(adapterContextMenuInfo.position, 0, 2, R.l.ezd);
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1) {
                switch (i) {
                    case 1:
                        boolean z;
                        Bundle bundleExtra = intent.getBundleExtra("result_data");
                        if (bundleExtra != null) {
                            String str;
                            w.i("MicroMsg.BizChatConversationFmUI", "bundle != null");
                            String string = bundleExtra.getString("enterprise_members");
                            ss ssVar = new ss();
                            com.tencent.mm.modelbiz.a.c cVar = new com.tencent.mm.modelbiz.a.c();
                            if (this.vvG != null) {
                                str = this.vvG.field_addMemberUrl;
                            } else {
                                str = null;
                            }
                            cVar.field_addMemberUrl = str;
                            cVar.field_brandUserName = this.kbi;
                            if (!com.tencent.mm.modelbiz.a.e.a(cVar, string, null, ssVar)) {
                                z = false;
                            } else if (cVar.field_bizChatLocalId != -1) {
                                eF(cVar.field_bizChatLocalId);
                                z = true;
                            } else {
                                com.tencent.mm.modelbiz.w.DN();
                                final com.tencent.mm.modelbiz.a.n a = h.a(this.kbi, ssVar, (m) this);
                                Context bPj = bPj();
                                getString(R.l.dIO);
                                this.irJ = g.a(bPj, getString(R.l.dJd), true, new OnCancelListener(this) {
                                    final /* synthetic */ a vvL;

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        com.tencent.mm.modelbiz.w.DN();
                                        h.f(a);
                                    }
                                });
                                z = true;
                            }
                        } else {
                            z = false;
                        }
                        if (!z) {
                            Toast.makeText(bPj(), getString(R.l.eMc), 0).show();
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        public final void a(int i, k kVar) {
            if (this.irJ != null) {
                this.irJ.dismiss();
                this.irJ = null;
            }
            if (kVar.getType() == 1355) {
                com.tencent.mm.modelbiz.a.c iq = com.tencent.mm.modelbiz.w.DJ().iq(((com.tencent.mm.modelbiz.a.n) kVar).Eb().ttc.tAE.tkF);
                if (iq == null) {
                    Toast.makeText(ab.getContext(), getString(R.l.eMc), 0).show();
                } else {
                    eF(iq.field_bizChatLocalId);
                }
            }
        }

        public final void bTn() {
            String bTp = bTp();
            this.vvH = f.bd(this.uSU.uTo, bTp);
            if (this.vvH == 2 && this.vvE == null) {
                this.vvE = (LinearLayout) findViewById(R.h.bottom_bar);
                LayoutParams layoutParams = this.vvE.getLayoutParams();
                layoutParams.height = com.tencent.mm.bg.a.T(this.uSU.uTo, R.f.aWT);
                this.vvE.setLayoutParams(layoutParams);
                View inflate = r.eC(this.uSU.uTo).inflate(R.i.dbl, this.vvE, false);
                float dI = com.tencent.mm.bg.a.dI(this.uSU.uTo);
                ImageView imageView = (ImageView) inflate.findViewById(R.h.bWx);
                int i = imageView.getLayoutParams().height;
                imageView.getLayoutParams().height = (int) (((float) i) * dI);
                imageView.getLayoutParams().width = (int) (dI * ((float) i));
                imageView.requestLayout();
                ((TextView) inflate.findViewById(R.h.cJh)).setText(R.l.eeV);
                this.vvE.addView(inflate);
                inflate.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ a vvL;

                    {
                        this.vvL = r1;
                    }

                    public final void onClick(View view) {
                        f.k(this.vvL.uSU.uTo, this.vvL.kbi, 4);
                    }
                });
                f.j(this.uSU.uTo, this.kbi, 4);
                f.be(this.uSU.uTo, bTp);
            }
            if (this.vvE == null) {
                return;
            }
            if (this.vvH == 2) {
                this.vvE.setVisibility(0);
            } else {
                this.vvE.setVisibility(8);
            }
        }

        final void bTo() {
            boolean z = false;
            String iF = com.tencent.mm.modelbiz.w.DL().iF(this.kbi);
            this.vvG = com.tencent.mm.modelbiz.w.DL().iD(iF);
            String str = "MicroMsg.BizChatConversationFmUI";
            String str2 = "updateBizChatMyUserInfo: %s:%s,myBizChatUserInfo is null:%s";
            Object[] objArr = new Object[3];
            objArr[0] = this.kbi;
            objArr[1] = iF;
            if (this.vvG == null) {
                z = true;
            }
            objArr[2] = Boolean.valueOf(z);
            w.i(str, str2, objArr);
            if (bg.mA(iF) || this.vvG == null || this.vvG.DW() || bg.mA(this.vvG.field_addMemberUrl)) {
                com.tencent.mm.modelbiz.w.DN();
                h.a(this.kbi, (m) this);
                Context bPj = bPj();
                getString(R.l.dIO);
                this.irJ = g.a(bPj, getString(R.l.dJd), true, new OnCancelListener(this) {
                    final /* synthetic */ a vvL;

                    {
                        this.vvL = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        this.vvL.finish();
                    }
                });
            }
        }

        public final void ay(LinkedList<String> linkedList) {
            if (linkedList.size() == 0) {
                w.i("MicroMsg.BizChatConversationFmUI", "userIdList is empty");
                return;
            }
            SharedPreferences SB = SB(ab.bIX());
            if (SB.getBoolean("FIRST_TIME_IN_BIZCHAT_CONV_" + this.kbi, true)) {
                w.i("MicroMsg.BizChatConversationFmUI", "updateData");
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.mm.sdk.e.e eVar = com.tencent.mm.modelbiz.w.DL().gUz;
                long j = 0;
                if (eVar instanceof com.tencent.mm.bj.g) {
                    j = ((com.tencent.mm.bj.g) eVar).cs(Thread.currentThread().getId());
                }
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    com.tencent.mm.modelbiz.a.c iq = com.tencent.mm.modelbiz.w.DJ().iq(str);
                    if (!(iq == null || iq.DV())) {
                        j iD = com.tencent.mm.modelbiz.w.DL().iD(str);
                        str = iD != null ? iD.field_userName : null;
                        if (!(str == null || str.equals(iq.field_chatName))) {
                            iq.field_chatName = str;
                            com.tencent.mm.modelbiz.w.DJ().b(iq);
                        }
                    }
                }
                if (eVar instanceof com.tencent.mm.bj.g) {
                    ap.yY();
                    c.wO().aD(j);
                }
                SB.edit().putBoolean("FIRST_TIME_IN_BIZCHAT_CONV_" + this.kbi, false).commit();
                w.d("MicroMsg.BizChatConversationFmUI", "updateData use time:%s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
        }

        public final String bTp() {
            if (bg.mA(this.hvg)) {
                this.hvg = com.tencent.mm.modelbiz.w.DH().hO(this.kbi).CO();
            }
            return this.hvg;
        }

        public final void eF(long j) {
            Bundle bundle = new Bundle();
            bundle.putLong("key_biz_chat_id", j);
            bundle.putBoolean("finish_direct", false);
            bundle.putBoolean("key_need_send_video", false);
            bundle.putBoolean("key_is_biz_chat", true);
            this.wbz.a(this.kbi, bundle, true);
        }

        public final void a(int i, com.tencent.mm.sdk.e.m mVar, Object obj) {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ipu = r.eC(this).inflate(R.i.cVP, null);
        setContentView(this.ipu);
        this.wbn = new a();
        aR().aV().a(R.h.ckn, this.wbn).commit();
        com.tencent.mm.pluginsdk.e.a(this, this.ipu);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.tencent.mm.pluginsdk.e.a(this, this.ipu);
    }
}
