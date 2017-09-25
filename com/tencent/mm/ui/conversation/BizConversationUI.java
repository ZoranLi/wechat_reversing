package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.l;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.aj;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.modelsimple.i;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.nh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ae;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.conversation.BaseConversationUI.b;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.widget.g;

public class BizConversationUI extends BaseConversationUI {
    private View ipu;

    public static class a extends b {
        public String fJL = "";
        public String huj;
        private p irJ = null;
        TextView jWk;
        public boolean jWp = false;
        public int kaQ = 0;
        public int kaR = 0;
        public g kaU;
        public d nxN = new d(this) {
            final /* synthetic */ a wbF;

            {
                this.wbF = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                        ap.yY();
                        af Rc = c.wR().Rc(this.wbF.fJL);
                        if (Rc == null) {
                            w.e("MicroMsg.BizConversationUI", "changed biz stick status failed, contact is null, talker = " + this.wbF.fJL);
                            return;
                        } else if (Rc.tG()) {
                            com.tencent.mm.plugin.report.service.g.oUh.i(13307, Rc.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(2));
                            o.m(this.wbF.fJL, true);
                            return;
                        } else {
                            com.tencent.mm.plugin.report.service.g.oUh.i(13307, Rc.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2));
                            o.l(this.wbF.fJL, true);
                            return;
                        }
                    case 2:
                        ap.yY();
                        com.tencent.mm.ui.tools.b.a(com.tencent.mm.modelbiz.w.DH().hO(this.wbF.fJL), this.wbF.bPj(), c.wR().Rc(this.wbF.fJL), 2);
                        return;
                    case 3:
                        this.wbF.TT(this.wbF.fJL);
                        return;
                    default:
                        return;
                }
            }
        };
        private com.tencent.mm.sdk.b.c oUy = new com.tencent.mm.sdk.b.c<l>(this) {
            final /* synthetic */ a wbF;

            {
                this.wbF = r2;
                this.usg = l.class.getName().hashCode();
            }

            public final /* bridge */ /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                l lVar = (l) bVar;
                if (!(lVar == null || lVar.fCE == null || lVar.fCE.fCF)) {
                    this.wbF.wbE = 0;
                }
                return false;
            }
        };
        public ae vWD;
        public d waV;
        public ListView wbC;
        private String wbD;
        public long wbE = 0;

        private static class a extends d {
            private String fRu;

            public a(Context context, String str, com.tencent.mm.ui.k.a aVar) {
                super(context, aVar);
                this.fRu = str;
            }

            public final void OK() {
                ap.yY();
                setCursor(c.wW().c(o.hlr, this.jBA, this.fRu));
                if (this.uSN != null) {
                    this.uSN.OH();
                }
                super.notifyDataSetChanged();
            }
        }

        public final void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.huj = bPj().getIntent().getStringExtra("enterprise_biz_name");
            if (bg.mA(this.huj)) {
                this.huj = "officialaccounts";
            }
            if (bg.mz(this.huj).equals("officialaccounts")) {
                com.tencent.mm.plugin.report.service.g.oUh.A(11404, "");
            }
            this.wbD = bPj().getIntent().getStringExtra("enterprise_biz_display_name");
            if (bg.mA(this.wbD)) {
                this.wbD = getString(R.l.dOP);
            }
            qP(this.wbD);
            this.wbC = (ListView) findViewById(R.h.cJi);
            this.jWk = (TextView) findViewById(R.h.bLU);
            this.jWk.setText(R.l.ees);
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ a wbF;

                {
                    this.wbF = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.wbF.finish();
                    return true;
                }
            });
            AnonymousClass11 anonymousClass11 = new OnClickListener(this) {
                final /* synthetic */ a wbF;

                {
                    this.wbF = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.platformtools.a.b.a(this.wbF.wbC);
                }
            };
            this.waV = new a(bPj(), this.huj, new com.tencent.mm.ui.k.a(this) {
                final /* synthetic */ a wbF;

                {
                    this.wbF = r1;
                }

                public final void OH() {
                    a aVar = this.wbF;
                    if (this.wbF.waV.getCount() <= 0) {
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
            this.waV.a(new MMSlideDelView.c(this) {
                final /* synthetic */ a wbF;

                {
                    this.wbF = r1;
                }

                public final int cb(View view) {
                    return this.wbF.wbC.getPositionForView(view);
                }
            });
            this.waV.a(new f(this) {
                final /* synthetic */ a wbF;

                {
                    this.wbF = r1;
                }

                public final void s(View view, int i) {
                    this.wbF.wbC.performItemClick(view, i, 0);
                }
            });
            this.wbC.setAdapter(this.waV);
            this.kaU = new g(bPj());
            this.wbC.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ a wbF;

                {
                    this.wbF = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.wbF.vWD = (ae) this.wbF.waV.getItem(i);
                    this.wbF.fJL = this.wbF.vWD.field_username;
                    aj ajVar = this.wbF.vWD;
                    if (ajVar == null) {
                        w.e("MicroMsg.BizConversationUI", "user should not be null. position:%d, size:%d", Integer.valueOf(i), Integer.valueOf(this.wbF.waV.getCount()));
                        this.wbF.waV.notifyDataSetChanged();
                        return;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putInt("biz_click_item_unread_count", this.wbF.vWD.field_unReadCount);
                    bundle.putInt("biz_click_item_position", i + 1);
                    this.wbF.wbz.a(ajVar.field_username, bundle, true);
                }
            });
            this.wbC.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ a wbF;

                {
                    this.wbF = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            this.wbF.kaQ = (int) motionEvent.getRawX();
                            this.wbF.kaR = (int) motionEvent.getRawY();
                            break;
                    }
                    return false;
                }
            });
            this.wbC.setOnItemLongClickListener(new OnItemLongClickListener(this) {
                final /* synthetic */ a wbF;

                {
                    this.wbF = r1;
                }

                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    this.wbF.vWD = (ae) this.wbF.waV.getItem(i);
                    this.wbF.fJL = this.wbF.vWD.field_username;
                    this.wbF.kaU.a(view, i, j, this.wbF, this.wbF.nxN, this.wbF.kaQ, this.wbF.kaR);
                    return true;
                }
            });
            this.waV.a(new MMSlideDelView.c(this) {
                final /* synthetic */ a wbF;

                {
                    this.wbF = r1;
                }

                public final int cb(View view) {
                    return this.wbF.wbC.getPositionForView(view);
                }
            });
            this.waV.a(new f(this) {
                final /* synthetic */ a wbF;

                {
                    this.wbF = r1;
                }

                public final void s(View view, int i) {
                    this.wbF.wbC.performItemClick(view, i, 0);
                }
            });
            this.waV.a(new e(this) {
                final /* synthetic */ a wbF;

                {
                    this.wbF = r1;
                }

                public final void aQ(Object obj) {
                    if (obj == null) {
                        w.e("MicroMsg.BizConversationUI", "onItemDel object null");
                        return;
                    }
                    this.wbF.TT(obj.toString());
                }
            });
            if ("officialaccounts".equals(this.huj)) {
                com.tencent.mm.storage.c dX = com.tencent.mm.u.c.c.Az().dX("100045");
                boolean z = dX.isValid() && "1".equals(dX.bKK().get("isOpenSearch"));
                w.d("MicroMsg.BizConversationUI", "open search entrance:%b", Boolean.valueOf(z));
                if (z) {
                    a(1, R.l.eYk, R.k.dsU, new OnMenuItemClickListener(this) {
                        final /* synthetic */ a wbF;

                        {
                            this.wbF = r1;
                        }

                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            if (com.tencent.mm.as.d.Ii()) {
                                Intent Il = com.tencent.mm.as.d.Il();
                                Il.putExtra("title", this.wbF.getString(R.l.enr));
                                Il.putExtra("searchbar_tips", this.wbF.getString(R.l.enr));
                                Il.putExtra("KRightBtn", true);
                                Il.putExtra("ftsneedkeyboard", true);
                                Il.putExtra("publishIdPrefix", "bs");
                                Il.putExtra("ftsType", 2);
                                Il.putExtra("ftsbizscene", 11);
                                Il.putExtra("rawUrl", com.tencent.mm.as.d.m(com.tencent.mm.as.d.a(11, true, 2)));
                                Il.putExtra("key_load_js_without_delay", true);
                                Il.addFlags(67108864);
                                com.tencent.mm.bb.d.b(ab.getContext(), "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", Il);
                            } else {
                                w.e("MicroMsg.BizConversationUI", "fts h5 template not avail");
                            }
                            return true;
                        }
                    });
                }
            }
            ap.yY();
            c.wW().a(this.waV);
            this.wbE = System.currentTimeMillis();
            com.tencent.mm.sdk.b.a.urY.b(this.oUy);
        }

        protected final int getLayoutId() {
            return R.i.dpe;
        }

        public final String getUserName() {
            return this.huj;
        }

        public final void onDestroy() {
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ a wbF;

                {
                    this.wbF = r1;
                }

                public final void run() {
                    if (ap.zb() && "officialaccounts".equals(this.wbF.huj)) {
                        int i;
                        long currentTimeMillis = System.currentTimeMillis();
                        int i2 = 0;
                        int i3 = 0;
                        int i4 = 0;
                        long j = 0;
                        StringBuilder stringBuilder = new StringBuilder("");
                        ap.yY();
                        Cursor c = c.wW().c(o.hlr, null, this.wbF.huj);
                        if (c != null) {
                            int columnIndex = c.getColumnIndex("unReadCount");
                            int columnIndex2 = c.getColumnIndex("conversationTime");
                            int columnIndex3 = c.getColumnIndex("flag");
                            int count = c.getCount();
                            ae aeVar = new ae();
                            while (c.moveToNext()) {
                                aeVar.t(c.getLong(columnIndex3));
                                i = c.getInt(columnIndex);
                                if (i > 0) {
                                    j = c.getLong(columnIndex2);
                                    i3++;
                                    i2 += i;
                                } else {
                                    i = 0;
                                }
                                stringBuilder.append(c.isFirst() ? "" : ".").append(i);
                                ap.yY();
                                if (c.wW().g(aeVar)) {
                                    i4++;
                                }
                            }
                            c.close();
                            i = i2;
                            i2 = i3;
                            i3 = i4;
                            i4 = count;
                        } else {
                            i = 0;
                            i2 = 0;
                            i3 = 0;
                            i4 = 0;
                        }
                        com.tencent.mm.plugin.report.service.g.oUh.i(13771, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(j / 1000), Integer.valueOf(i3), stringBuilder.toString());
                        w.v("MicroMsg.BizConversationUI", "report use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }
                }
            });
            if (this.wbE != 0 && "officialaccounts".equals(this.huj)) {
                com.tencent.mm.plugin.report.service.g.oUh.i(13932, Integer.valueOf(((int) (System.currentTimeMillis() - this.wbE)) / 1000));
            }
            com.tencent.mm.sdk.b.a.urY.c(this.oUy);
            if (ap.zb()) {
                ap.yY();
                c.wW().b(this.waV);
            }
            if (this.waV != null) {
                this.waV.onDestroy();
            }
            super.onDestroy();
        }

        public final void onResume() {
            w.v("MicroMsg.BizConversationUI", "on resume");
            if (this.waV != null) {
                this.waV.onResume();
            }
            super.onResume();
        }

        public final void onPause() {
            w.i("MicroMsg.BizConversationUI", "on pause");
            ap.yY();
            c.wW().Ro(this.huj);
            if (this.waV != null) {
                this.waV.onPause();
            }
            super.onPause();
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            if (!(this.fJL == null || this.fJL.isEmpty())) {
                this.fJL = "";
            }
            if (i2 == -1) {
            }
        }

        public final void TT(String str) {
            if (bg.mA(str)) {
                w.e("MicroMsg.BizConversationUI", "Delete Conversation and messages fail because username is null or nil.");
                return;
            }
            if ("officialaccounts".equals(this.huj)) {
                com.tencent.mm.plugin.report.service.g.oUh.i(13773, Integer.valueOf(0), Integer.valueOf(this.vWD.field_unReadCount), Integer.valueOf(0), this.vWD.field_username);
            }
            ap.yY();
            ce Ah = c.wT().Ah(str);
            com.tencent.mm.bd.a nhVar = new nh();
            nhVar.ttp = new avx().OV(bg.mz(str));
            nhVar.tfk = Ah.field_msgSvrId;
            ap.yY();
            c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(8, nhVar));
            this.jWp = false;
            Context bPj = bPj();
            getString(R.l.dIO);
            final ProgressDialog a = com.tencent.mm.ui.base.g.a(bPj, getString(R.l.dJd), true, new OnCancelListener(this) {
                final /* synthetic */ a wbF;

                {
                    this.wbF = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.wbF.jWp = true;
                }
            });
            ay.a(str, new com.tencent.mm.u.ay.a(this) {
                final /* synthetic */ a wbF;

                public final boolean zs() {
                    return this.wbF.jWp;
                }

                public final void zr() {
                    if (a != null) {
                        a.dismiss();
                    }
                }
            });
            ap.yY();
            af Rc = c.wR().Rc(str);
            ap.yY();
            aj Rm = c.wW().Rm(str);
            ap.yY();
            c.wW().Rl(str);
            if (Rm == null) {
                return;
            }
            if (Rm.eC(4194304) || (Rc != null && Rc.bLe() && !com.tencent.mm.j.a.ez(Rc.field_type) && Rm.field_conversationTime < com.tencent.mm.modelbiz.w.DT())) {
                ap.vd().a(new i(str), 0);
            }
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            ap.yY();
            af Rc = c.wR().Rc(this.fJL);
            if (Rc == null) {
                w.e("MicroMsg.BizConversationUI", "onCreateContextMenu, contact is null, talker = " + this.fJL);
                return;
            }
            CharSequence tL = Rc.tL();
            if (tL.toLowerCase().endsWith("@chatroom") && bg.mA(Rc.field_nickname)) {
                tL = getString(R.l.dVr);
            }
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            contextMenu.setHeaderTitle(h.a(bPj(), tL));
            if (com.tencent.mm.j.a.ez(Rc.field_type)) {
                if (Rc.tG()) {
                    contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.l.eza);
                } else {
                    contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.l.eak);
                }
                contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.l.eyW);
            }
            contextMenu.add(adapterContextMenuInfo.position, 3, 0, R.l.ezd);
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
