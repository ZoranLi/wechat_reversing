package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.profile.a.c;
import com.tencent.mm.protocal.c.alx;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.protocal.c.bed;
import com.tencent.mm.protocal.c.nh;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI.b;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public class EnterpriseConversationUI extends BaseConversationUI {
    private View ipu;

    public static class a extends b implements m.b, e {
        public int fromScene;
        private long gKS = 0;
        long hVi = 0;
        public String huj;
        public p irJ;
        public long jBj = 0;
        TextView jWk;
        public boolean jWp = false;
        public String kaT = "";
        public l kmS;
        public d nxN;
        private LinearLayout vvE = null;
        public int vvH = 0;
        private com.tencent.mm.modelbiz.c.a vvK = new com.tencent.mm.modelbiz.c.a(this) {
            final /* synthetic */ a wdK;

            {
                this.wdK = r1;
            }

            public final void a(com.tencent.mm.modelbiz.c.a.a aVar) {
                if (aVar != null && !bg.mA(aVar.huj) && aVar.huj.equals(this.wdK.huj)) {
                    int i = this.wdK.vvH;
                    this.wdK.vvH = f.bd(this.wdK.uSU.uTo, this.wdK.huj);
                    if (this.wdK.vvH != i) {
                        this.wdK.bTn();
                    }
                }
            }
        };
        public ListView wbC;
        private String wbD;
        public com.tencent.mm.ui.tools.m wdE;
        public h wdF;
        String wdG = null;
        private ae wdH;
        public int wdI = -2;
        public String wdJ = null;

        class AnonymousClass5 implements OnClickListener {
            final /* synthetic */ String gTC;
            final /* synthetic */ Context val$context;
            final /* synthetic */ a wdK;

            AnonymousClass5(a aVar, String str, Context context) {
                this.wdK = aVar;
                this.gTC = str;
                this.val$context = context;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                final k cVar = new c(this.gTC, true);
                ap.vd().a(1394, this.wdK);
                ap.vd().a(cVar, 0);
                a aVar = this.wdK;
                Context context = this.val$context;
                this.val$context.getString(R.l.dIO);
                aVar.irJ = g.a(context, this.val$context.getString(R.l.dJd), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass5 wdL;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(cVar);
                        ap.vd().b(1394, this.wdL.wdK);
                    }
                });
            }
        }

        public final void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.huj = bPj().getIntent().getStringExtra("enterprise_biz_name");
            this.wbD = bPj().getIntent().getStringExtra("enterprise_biz_display_name");
            this.fromScene = bPj().getIntent().getIntExtra("enterprise_from_scene", 5);
            qP(this.wbD);
            this.wbC = (ListView) findViewById(R.h.cJi);
            this.jWk = (TextView) findViewById(R.h.bLU);
            this.jWk.setText(R.l.eeJ);
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ a wdK;

                {
                    this.wdK = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.wdK.finish();
                    return true;
                }
            });
            AnonymousClass10 anonymousClass10 = new View.OnClickListener(this) {
                final /* synthetic */ a wdK;

                {
                    this.wdK = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.platformtools.a.b.a(this.wdK.wbC);
                }
            };
            if (com.tencent.mm.modelbiz.e.hW(this.huj) != null) {
                if (this.huj != null) {
                    w.DO();
                    com.tencent.mm.modelbiz.c.a(this.huj, null);
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.EnterpriseConversationUI", "update father attr from svr bizName:%s", this.huj);
                } else {
                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.EnterpriseConversationUI", "bizName is null!!!");
                }
                bTn();
                a(1, R.l.eYk, R.k.dsU, new OnMenuItemClickListener(this) {
                    final /* synthetic */ a wdK;

                    {
                        this.wdK = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        Intent intent = new Intent();
                        intent.putExtra("enterprise_biz_name", this.wdK.huj);
                        intent.addFlags(67108864);
                        com.tencent.mm.bb.d.b(this.wdK.uSU.uTo, "brandservice", ".ui.EnterpriseBizSearchUI", intent);
                        return true;
                    }
                });
                a(2, R.l.dBP, R.k.dsI, new OnMenuItemClickListener(this) {
                    final /* synthetic */ a wdK;

                    {
                        this.wdK = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        if (this.wdK.wdE != null) {
                            this.wdK.wdE.dismiss();
                            this.wdK.wdE = null;
                        }
                        this.wdK.wdE = new com.tencent.mm.ui.tools.m(this.wdK.uSU.uTo);
                        this.wdK.wdE.qJf = new n.c(this) {
                            final /* synthetic */ AnonymousClass13 wdM;

                            {
                                this.wdM = r1;
                            }

                            public final void a(com.tencent.mm.ui.base.l lVar) {
                                if (this.wdM.wdK.vvH == 1) {
                                    lVar.W(2, R.l.efa, R.k.dsN);
                                    f.j(this.wdM.wdK.uSU.uTo, this.wdM.wdK.huj, 5);
                                }
                                lVar.W(3, R.l.dZx, R.k.dyx);
                                lVar.W(4, R.l.eeI, R.k.dsM);
                                lVar.W(5, R.l.dBQ, R.k.dsW);
                            }
                        };
                        this.wdK.wdE.qJg = new d(this) {
                            final /* synthetic */ AnonymousClass13 wdM;

                            {
                                this.wdM = r1;
                            }

                            public final void c(MenuItem menuItem, int i) {
                                int i2 = 0;
                                Intent intent;
                                switch (menuItem.getItemId()) {
                                    case 2:
                                        f.k(this.wdM.wdK.uSU.uTo, this.wdM.wdK.huj, 5);
                                        break;
                                    case 3:
                                        intent = new Intent(this.wdM.wdK.bPj(), SelectConversationUI.class);
                                        intent.putExtra("Select_Talker_Name", this.wdM.wdK.huj);
                                        intent.putExtra("Select_block_List", this.wdM.wdK.huj);
                                        intent.putExtra("Select_Send_Card", true);
                                        intent.putExtra("Select_Conv_Type", 3);
                                        this.wdM.wdK.startActivityForResult(intent, 1);
                                        i2 = 3;
                                        break;
                                    case 4:
                                        i2 = 4;
                                        Intent intent2 = new Intent();
                                        intent2.putExtra("enterprise_biz_name", this.wdM.wdK.huj);
                                        intent2.putExtra("enterprise_scene", 2);
                                        com.tencent.mm.bb.d.b(this.wdM.wdK.bPj(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent2);
                                        break;
                                    case 5:
                                        intent = new Intent();
                                        intent.putExtra("Contact_User", this.wdM.wdK.huj);
                                        com.tencent.mm.bb.d.b(this.wdM.wdK.bPj(), "profile", ".ui.ContactInfoUI", intent);
                                        i2 = 5;
                                        break;
                                }
                                f.cK(this.wdM.wdK.huj, i2);
                            }
                        };
                        this.wdK.wdE.dL();
                        f.cK(this.wdK.huj, 1);
                        return false;
                    }
                });
                this.wdF = new h(bPj(), this.huj, new com.tencent.mm.ui.k.a(this) {
                    final /* synthetic */ a wdK;

                    {
                        this.wdK = r1;
                    }

                    public final void OH() {
                        a aVar = this.wdK;
                        if (this.wdK.wdF.getCount() <= 0) {
                            aVar.jWk.setVisibility(0);
                            aVar.wbC.setVisibility(8);
                            return;
                        }
                        aVar.jWk.setVisibility(8);
                        aVar.wbC.setVisibility(0);
                    }

                    public final void OI() {
                    }
                });
                this.wdF.a(new MMSlideDelView.c(this) {
                    final /* synthetic */ a wdK;

                    {
                        this.wdK = r1;
                    }

                    public final int cb(View view) {
                        return this.wdK.wbC.getPositionForView(view);
                    }
                });
                this.wdF.a(new MMSlideDelView.f(this) {
                    final /* synthetic */ a wdK;

                    {
                        this.wdK = r1;
                    }

                    public final void s(View view, int i) {
                        this.wdK.wbC.performItemClick(view, i, 0);
                    }
                });
                this.wdF.a(new MMSlideDelView.e(this) {
                    final /* synthetic */ a wdK;

                    {
                        this.wdK = r1;
                    }

                    public final void aQ(Object obj) {
                        if (obj == null) {
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.EnterpriseConversationUI", "onItemDel object null");
                            return;
                        }
                        this.wdK.TT(obj.toString());
                    }
                });
                this.wbC.setAdapter(this.wdF);
                this.wbC.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ a wdK;

                    {
                        this.wdK = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        String str = null;
                        com.tencent.mm.storage.ae aeVar = (com.tencent.mm.storage.ae) this.wdK.wdF.getItem(i);
                        if (aeVar == null) {
                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.EnterpriseConversationUI", "user should not be null. position:%d, size:%d", Integer.valueOf(i), Integer.valueOf(this.wdK.wdF.getCount()));
                            this.wdK.wdF.notifyDataSetChanged();
                        } else if (com.tencent.mm.modelbiz.e.dr(aeVar.field_username)) {
                            Intent intent = new Intent(this.wdK.bPj(), BizChatConversationUI.class);
                            intent.putExtra("Contact_User", aeVar.field_username);
                            intent.putExtra("biz_chat_from_scene", 7);
                            intent.addFlags(67108864);
                            this.wdK.startActivity(intent);
                        } else if (com.tencent.mm.modelbiz.e.ic(aeVar.field_username)) {
                            BizInfo hW = com.tencent.mm.modelbiz.e.hW(aeVar.field_username);
                            if (hW != null) {
                                str = hW.CL();
                            }
                            if (str == null) {
                                str = "";
                            }
                            Intent intent2 = new Intent();
                            intent2.putExtra("rawUrl", str);
                            intent2.putExtra("useJs", true);
                            intent2.putExtra("srcUsername", aeVar.field_username);
                            intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                            intent2.addFlags(67108864);
                            com.tencent.mm.bb.d.b(this.wdK.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent2);
                            this.wdK.a(hW, 2, aeVar.field_unReadCount);
                        } else {
                            this.wdK.wbz.a(aeVar.field_username, null, true);
                            this.wdK.a(com.tencent.mm.modelbiz.e.hW(aeVar.field_username), 1, aeVar.field_unReadCount);
                        }
                    }
                });
                this.kmS = new l(bPj());
                this.nxN = new d(this) {
                    final /* synthetic */ a wdK;

                    {
                        this.wdK = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 1:
                                this.wdK.TT(this.wdK.kaT);
                                return;
                            case 2:
                                q qVar = this.wdK;
                                String str = this.wdK.kaT;
                                Context context = qVar.uSU.uTo;
                                g.a(context, context.getString(R.l.eeF), "", context.getString(R.l.eeE), context.getString(R.l.dGs), new AnonymousClass5(qVar, str, context), null);
                                return;
                            case 3:
                                a.TW(this.wdK.kaT);
                                return;
                            default:
                                return;
                        }
                    }
                };
                this.wbC.setOnItemLongClickListener(new OnItemLongClickListener(this) {
                    final /* synthetic */ a wdK;

                    {
                        this.wdK = r1;
                    }

                    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                        com.tencent.mm.storage.ae aeVar = (com.tencent.mm.storage.ae) this.wdK.wdF.getItem(i);
                        this.wdK.kaT = aeVar.field_username;
                        this.wdK.kmS.a(view, i, j, this.wdK, this.wdK.nxN);
                        return true;
                    }
                });
            }
            this.gKS = System.currentTimeMillis() / 1000;
            ap.yY();
            aj Rm = com.tencent.mm.u.c.wW().Rm(this.huj);
            if (Rm != null) {
                this.wdI = Rm.field_unReadCount;
                if (this.wdI == 0 && Rm.field_unReadMuteCount > 0) {
                    this.wdI = -1;
                }
                this.jBj = Rm.field_conversationTime / 1000;
                this.wdJ = Rm.field_isSend == 1 ? null : Rm.field_digestUser;
            }
            w.DO().a(this.vvK, bPj().getMainLooper());
            ap.yY();
            com.tencent.mm.u.c.wW().a(this);
            ap.yY();
            com.tencent.mm.u.c.wR().a(this);
            if (this.wdF != null) {
                if (this.wdH == null) {
                    this.wdH = new ae(this) {
                        final /* synthetic */ a wdK;

                        {
                            this.wdK = r1;
                        }

                        public final void handleMessage(Message message) {
                            if (message != null && message.what == 1 && this.wdK.bPj() != null && !this.wdK.bPj().isFinishing()) {
                                int i;
                                int count = this.wdK.wdF.getCount();
                                LinkedList linkedList = new LinkedList();
                                LinkedList linkedList2 = new LinkedList();
                                int i2 = 0;
                                int i3 = 0;
                                int i4 = 0;
                                int i5 = 0;
                                while (i5 < count) {
                                    int i6;
                                    com.tencent.mm.storage.ae aeVar = (com.tencent.mm.storage.ae) this.wdK.wdF.getItem(i5);
                                    if (aeVar != null) {
                                        String str = aeVar.field_username;
                                        if (str != null) {
                                            if (o.eU(str) && com.tencent.mm.modelbiz.e.ie(str)) {
                                                af Rc = ((h) com.tencent.mm.kernel.h.h(h.class)).wR().Rc(str);
                                                boolean Rt = ((h) com.tencent.mm.kernel.h.h(h.class)).wW().Rt(str);
                                                Object obj = (Rc == null || (Rc.field_type & 2048) == 0) ? null : 1;
                                                if (obj != null && !Rt) {
                                                    ((h) com.tencent.mm.kernel.h.h(h.class)).wW().Rr(str);
                                                } else if (obj == null && Rt) {
                                                    ((h) com.tencent.mm.kernel.h.h(h.class)).wW().Rs(str);
                                                }
                                                if (com.tencent.mm.modelbiz.e.ic(str)) {
                                                    linkedList2.add(str);
                                                }
                                                if (aeVar.field_unReadCount > 0) {
                                                    if (o.fJ(str)) {
                                                        i = i3;
                                                        int i7 = i4;
                                                        i4 = i2 + 1;
                                                        i6 = i7;
                                                    } else {
                                                        i = i3 + 1;
                                                        i6 = aeVar.field_unReadCount + i4;
                                                        i4 = i2;
                                                    }
                                                    i5++;
                                                    i2 = i4;
                                                    i3 = i;
                                                    i4 = i6;
                                                }
                                            } else {
                                                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.EnterpriseConversationUI", "checkEnterpriseChildConv delete conv %s", str);
                                                linkedList.add(str);
                                                i6 = i4;
                                                i = i3;
                                                i4 = i2;
                                                i5++;
                                                i2 = i4;
                                                i3 = i;
                                                i4 = i6;
                                            }
                                        }
                                    }
                                    i6 = i4;
                                    i = i3;
                                    i4 = i2;
                                    i5++;
                                    i2 = i4;
                                    i3 = i;
                                    i4 = i6;
                                }
                                com.tencent.mm.modelbiz.b hC = w.DO().hC(this.wdK.huj);
                                int i8 = hC != null ? hC.field_qyUin : 0;
                                long j = hC != null ? hC.field_wwCorpId : 0;
                                long j2 = hC != null ? hC.field_wwUserVid : 0;
                                i5 = 0;
                                if (!bg.mA(this.wdK.wdJ)) {
                                    i5 = w.DO().hE(this.wdK.wdJ);
                                }
                                com.tencent.mm.plugin.report.service.g.oUh.i(12892, this.wdK.huj, Integer.valueOf(this.wdK.fromScene), Integer.valueOf(count), "", Integer.valueOf(this.wdK.wdI), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(this.wdK.jBj), Integer.valueOf(i5), Integer.valueOf(i8), Long.valueOf(j), Long.valueOf(j2));
                                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.EnterpriseConversationUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", this.wdK.huj, Integer.valueOf(this.wdK.fromScene), Integer.valueOf(count), "", Integer.valueOf(this.wdK.wdI), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(this.wdK.jBj), Integer.valueOf(i5), Integer.valueOf(i8), Long.valueOf(j), Long.valueOf(j2));
                                if (linkedList.size() > 0) {
                                    ap.yY();
                                    com.tencent.mm.u.c.wW().aw(linkedList);
                                    this.wdK.wdF.OK();
                                }
                                if (w.DR().hB(this.wdK.huj)) {
                                    w.DO();
                                    com.tencent.mm.modelbiz.c.a(this.wdK.huj, null);
                                }
                                com.tencent.mm.modelbiz.a DR = w.DR();
                                a aVar = this.wdK;
                                if (aVar.wdG == null) {
                                    w.DH();
                                    String hS = com.tencent.mm.modelbiz.d.hS(aVar.huj);
                                    if (bg.mA(hS)) {
                                        hS = "";
                                    }
                                    aVar.wdG = hS;
                                }
                                DR.hB(bg.mA(aVar.wdG) ? null : aVar.wdG);
                                if (linkedList2.size() > 0) {
                                    for (i = 0; i < linkedList2.size(); i++) {
                                        w.DR().hB((String) linkedList2.get(i));
                                    }
                                }
                            }
                        }
                    };
                } else {
                    this.wdH.removeMessages(1);
                }
                this.wdH.sendEmptyMessageDelayed(1, 500);
            }
        }

        protected final int getLayoutId() {
            return R.i.dbk;
        }

        public final String getUserName() {
            return this.huj;
        }

        public final void onDestroy() {
            w.DO().a(this.vvK);
            if (ap.zb()) {
                ap.yY();
                com.tencent.mm.u.c.wW().b(this);
                ap.yY();
                com.tencent.mm.u.c.wR().b(this);
            }
            if (this.wdF != null) {
                m.b bVar = this.wdF;
                bVar.wcl.KH();
                if (bVar.vvu != null) {
                    bVar.vvu.clear();
                    bVar.vvu = null;
                }
                bVar.aEW();
                bVar.uSN = null;
                ap.yY();
                com.tencent.mm.u.c.wW().b(bVar);
            }
            ap.vd().b(1394, (e) this);
            if (this.gKS > 0 && this.hVi > 0) {
                long j = this.hVi - this.gKS;
                com.tencent.mm.modelbiz.b hC = w.DO().hC(this.huj);
                int i = hC != null ? hC.field_qyUin : 0;
                int i2 = hC != null ? hC.field_userUin : 0;
                com.tencent.mm.plugin.report.service.g.oUh.i(13465, "", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(j));
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.EnterpriseConversationUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(j));
            }
            super.onDestroy();
        }

        public final void onResume() {
            com.tencent.mm.sdk.platformtools.w.v("MicroMsg.EnterpriseConversationUI", "on resume");
            if (this.wdF != null) {
                this.wdF.onResume();
            }
            super.onResume();
            if (!o.eU(this.huj)) {
                finish();
            }
        }

        public final void onPause() {
            com.tencent.mm.sdk.platformtools.w.v("MicroMsg.EnterpriseConversationUI", "on pause");
            ap.yY();
            com.tencent.mm.u.c.wW().Ro(this.huj);
            if (this.wdF != null) {
                this.wdF.onPause();
            }
            super.onPause();
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            switch (i) {
                case 1:
                    if (i2 == -1 && intent != null) {
                        String stringExtra = intent.getStringExtra("be_send_card_name");
                        String stringExtra2 = intent.getStringExtra("received_card_name");
                        boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                        String stringExtra3 = intent.getStringExtra("custom_send_text");
                        com.tencent.mm.plugin.messenger.a.d.aJW().k(stringExtra, stringExtra2, booleanExtra);
                        com.tencent.mm.plugin.messenger.a.d.aJW().cM(stringExtra3, stringExtra2);
                        com.tencent.mm.ui.snackbar.a.e(bPj(), this.uSU.uTo.getString(R.l.ekV));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public final void bTn() {
            this.vvH = f.bd(this.uSU.uTo, this.huj);
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
                ((TextView) inflate.findViewById(R.h.cJh)).setText(R.l.eeZ);
                this.vvE.addView(inflate);
                inflate.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ a wdK;

                    {
                        this.wdK = r1;
                    }

                    public final void onClick(View view) {
                        f.k(this.wdK.uSU.uTo, this.wdK.huj, 3);
                    }
                });
                f.j(this.uSU.uTo, this.huj, 3);
                f.be(this.uSU.uTo, this.huj);
            }
            if (this.vvE == null) {
                return;
            }
            if (this.vvH == 2) {
                this.vvE.setVisibility(0);
                com.tencent.mm.modelbiz.b hC = w.DO().hC(this.huj);
                int i2 = hC != null ? hC.field_qyUin : 0;
                int i3 = hC != null ? hC.field_userUin : 0;
                long j = hC != null ? hC.field_wwCorpId : 0;
                long j2 = hC != null ? hC.field_wwUserVid : 0;
                com.tencent.mm.plugin.report.service.g.oUh.i(13656, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(j), Long.valueOf(j2));
                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.EnterpriseConversationUI", "expose wework btn on session list  report: %s,%s,%s,%s,%s,%s", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(6), Integer.valueOf(3), Long.valueOf(j), Long.valueOf(j2));
                return;
            }
            this.vvE.setVisibility(8);
        }

        public final void a(BizInfo bizInfo, int i, int i2) {
            com.tencent.mm.modelbiz.b hC = w.DO().hC(this.huj);
            long j = hC != null ? hC.field_wwCorpId : 0;
            long j2 = hC != null ? hC.field_wwUserVid : 0;
            int i3 = i2 > 0 ? 1 : 2;
            long CM = bizInfo == null ? 0 : bizInfo.CM();
            com.tencent.mm.plugin.report.service.g.oUh.i(14507, Long.valueOf(j), Long.valueOf(CM), Long.valueOf(j2), Integer.valueOf(1), Integer.valueOf(i3), Integer.valueOf(i));
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.EnterpriseConversationUI", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", Long.valueOf(j), Long.valueOf(CM), Long.valueOf(j2), Integer.valueOf(1), Integer.valueOf(i3), Integer.valueOf(i));
        }

        public static void TW(String str) {
            ap.yY();
            if (com.tencent.mm.u.c.wR().Rc(str) == null) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.EnterpriseConversationUI", "changed biz stick status failed, contact is null, talker = " + str);
                return;
            }
            ap.yY();
            if (com.tencent.mm.u.c.wW().Rt(str)) {
                o.m(str, true);
            } else {
                com.tencent.mm.u.g.eq(str);
            }
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (this.irJ != null && this.irJ.isShowing()) {
                this.irJ.dismiss();
            }
            if (i == 0 && i2 == 0 && kVar.getType() == 1394) {
                bec aTu = ((c) kVar).aTu();
                bed aTt = ((c) kVar).aTt();
                if (aTt == null || aTt.tkR == null || aTt.tkR.ret != 0) {
                    if (aTt == null || aTt.tkR == null) {
                        com.tencent.mm.sdk.platformtools.w.w("MicroMsg.EnterpriseConversationUI", "chuangchen onSceneEnd type:%s, err:resp == null", Integer.valueOf(kVar.getType()));
                        return;
                    }
                    com.tencent.mm.sdk.platformtools.w.w("MicroMsg.EnterpriseConversationUI", "chuangchen onSceneEnd type:%s, err:code:%s", Integer.valueOf(kVar.getType()), Integer.valueOf(aTt.tkR.ret));
                } else if (aTu.uff) {
                    com.tencent.mm.sdk.e.c hW = com.tencent.mm.modelbiz.e.hW(aTu.tkL);
                    hW.field_brandFlag |= 1;
                    com.tencent.mm.bd.a com_tencent_mm_protocal_c_alx = new alx();
                    com_tencent_mm_protocal_c_alx.hAR = hW.field_brandFlag;
                    com_tencent_mm_protocal_c_alx.jNj = aTu.tkL;
                    ap.yY();
                    com.tencent.mm.u.c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(47, com_tencent_mm_protocal_c_alx));
                    w.DH().c(hW, new String[0]);
                    ap.yY();
                    com.tencent.mm.u.c.wW().Rl(hW.field_username);
                    ap.yY();
                    if (com.tencent.mm.u.c.wW().Rw(hW.field_enterpriseFather) <= 0) {
                        ap.yY();
                        com.tencent.mm.u.c.wW().Rl(hW.field_enterpriseFather);
                        return;
                    }
                    ap.yY();
                    com.tencent.mm.u.c.wV().QH(hW.field_enterpriseFather);
                }
            }
        }

        public final void TT(String str) {
            if (bg.mA(str)) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.EnterpriseConversationUI", "Delete Conversation and messages fail because username is null or nil.");
                return;
            }
            ap.yY();
            ce Ah = com.tencent.mm.u.c.wT().Ah(str);
            com.tencent.mm.bd.a nhVar = new nh();
            nhVar.ttp = new avx().OV(bg.mz(str));
            nhVar.tfk = Ah.field_msgSvrId;
            ap.yY();
            com.tencent.mm.u.c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(8, nhVar));
            this.jWp = false;
            Context bPj = bPj();
            getString(R.l.dIO);
            final ProgressDialog a = g.a(bPj, getString(R.l.dJd), true, new OnCancelListener(this) {
                final /* synthetic */ a wdK;

                {
                    this.wdK = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.wdK.jWp = true;
                }
            });
            ay.a(str, new com.tencent.mm.u.ay.a(this) {
                final /* synthetic */ a wdK;

                public final boolean zs() {
                    return this.wdK.jWp;
                }

                public final void zr() {
                    if (a != null) {
                        a.dismiss();
                    }
                }
            });
            ap.yY();
            com.tencent.mm.u.c.wW().Rl(str);
            BizInfo hO = w.DH().hO(str);
            ap.yY();
            com.tencent.mm.u.c.wV().QH(hO.field_enterpriseFather);
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            ap.yY();
            af Rc = com.tencent.mm.u.c.wR().Rc(this.kaT);
            if (Rc == null) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.EnterpriseConversationUI", "onCreateContextMenu, contact is null, talker = " + this.kaT);
                return;
            }
            CharSequence tL = Rc.tL();
            if (tL.toLowerCase().endsWith("@chatroom") && bg.mA(Rc.field_nickname)) {
                tL = getString(R.l.dVr);
            }
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.h.a(bPj(), tL));
            if (Rc.tG()) {
                contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.l.eza);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.l.eeT);
            }
            contextMenu.add(adapterContextMenuInfo.position, 2, 1, R.l.eeN);
            contextMenu.add(adapterContextMenuInfo.position, 1, 2, R.l.ezd);
        }

        public final void a(int i, m mVar, Object obj) {
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

    public void finish() {
        if (this.wbn != null && (this.wbn instanceof a)) {
            ((a) this.wbn).hVi = System.currentTimeMillis() / 1000;
        }
        super.finish();
    }
}
