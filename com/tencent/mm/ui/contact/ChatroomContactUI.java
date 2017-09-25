package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.VoiceSearchLayout;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.pluginsdk.ui.tools.p;
import com.tencent.mm.protocal.c.awp;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.voicesearch.VoiceSearchResultUI;
import com.tencent.mm.ui.voicesearch.b;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class ChatroomContactUI extends MMActivity implements a, e {
    private int kaQ = 0;
    private int kaR = 0;
    private g kaU;
    private d ktu = new d(new OnScrollListener(this) {
        final /* synthetic */ ChatroomContactUI vWA;

        {
            this.vWA = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    });
    private TextView lGB;
    private n.d lmm = new n.d(this) {
        final /* synthetic */ ChatroomContactUI vWA;

        {
            this.vWA = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 1:
                    ChatroomContactUI.TN(this.vWA.vVs);
                    return;
                default:
                    return;
            }
        }
    };
    private ListView mZO;
    private VoiceSearchLayout uQu;
    private ContactCountView vVD;
    private b vVq;
    private String vVs;
    private p vWy;
    private d vWz;

    static /* synthetic */ void TN(String str) {
        ap.yY();
        x Rc = c.wR().Rc(str);
        Rc.td();
        o.t(Rc);
        if (o.dH(str)) {
            ap.yY();
            c.wR().Ri(str);
            ap.yY();
            c.xa().gb(str);
            return;
        }
        ap.yY();
        c.wR().a(str, Rc);
    }

    static /* synthetic */ void a(ChatroomContactUI chatroomContactUI, String str) {
        if (str == null || str.length() <= 0) {
            if (chatroomContactUI.vVD != null) {
                chatroomContactUI.vVD.setVisible(true);
            }
        } else if (chatroomContactUI.vVD != null) {
            chatroomContactUI.vVD.setVisible(false);
        }
        if (str == null || str.length() == 0) {
            chatroomContactUI.mZO.setAdapter(chatroomContactUI.vWz);
            chatroomContactUI.mZO.setBackgroundColor(chatroomContactUI.getResources().getColor(R.e.aVP));
            chatroomContactUI.vWz.notifyDataSetChanged();
            chatroomContactUI.vVq.lP(false);
            chatroomContactUI.vWz.OK();
            return;
        }
        chatroomContactUI.mZO.setAdapter(chatroomContactUI.vVq);
        chatroomContactUI.mZO.setBackgroundColor(chatroomContactUI.getResources().getColor(R.e.white));
        chatroomContactUI.vVq.lP(true);
        b bVar = chatroomContactUI.vVq;
        String Uw = b.Uw(str);
        if (!(Uw == null || Uw.equals(bVar.wrX))) {
            bVar.aa(new Runnable(bVar) {
                final /* synthetic */ b wsd;

                {
                    this.wsd = r1;
                }

                public final void run() {
                    this.wsd.wsa = true;
                    this.wsd.hkm.clear();
                }
            });
        }
        bVar.wrX = Uw;
        bVar.vvh = null;
        if (bVar.wrX == null) {
            bVar.wrX = "";
        }
        bVar.aEW();
        bVar.OK();
        chatroomContactUI.vVq.notifyDataSetChanged();
    }

    static /* synthetic */ void b(ChatroomContactUI chatroomContactUI, String str) {
        if (str != null && str.length() > 0) {
            if (o.fu(str)) {
                w.e("MicroMsg.ChatroomContactUI", "error, 4.5 do not contain this contact %s", str);
                return;
            }
            Intent intent = new Intent(chatroomContactUI.uSU.uTo, En_5b8fbb1e.class);
            intent.addFlags(67108864);
            intent.putExtra("Chat_User", str);
            intent.putExtra("Chat_Mode", 1);
            chatroomContactUI.uSU.uTo.startActivity(intent);
            if (str != null && str.length() > 0) {
                e.a(intent, str);
                chatroomContactUI.startActivity(intent);
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.cXh;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.dCs);
        KC();
        ap.vd().a(138, (e) this);
        ap.yY();
        c.wR().a(this.vWz);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        ap.yY();
        if (c.wR().Rc(this.vVs) == null) {
            w.e("MicroMsg.ChatroomContactUI", "onCreateContextMenu, contact is null, username = " + this.vVs);
        } else if (o.eS(this.vVs)) {
            contextMenu.setHeaderTitle(h.a(view.getContext(), com.tencent.mm.u.n.eK(this.vVs)));
            contextMenu.add(adapterContextMenuInfo.position, 1, 0, R.l.dCw);
        }
    }

    public final void KC() {
        ((TextView) findViewById(R.h.bMf)).setVisibility(8);
        this.mZO = (ListView) findViewById(R.h.bnw);
        this.mZO.setAdapter(null);
        this.lGB = (TextView) findViewById(R.h.bMf);
        this.lGB.setText(R.l.dCy);
        String str = "@all.chatroom.contact";
        this.vWz = new d(this, str);
        this.vWz.ko(true);
        this.vVq = new b(this.uSU.uTo, 1);
        this.vVq.vUP = str;
        this.vWy = new p((byte) 0);
        this.vWy.a(new p.a(this) {
            final /* synthetic */ ChatroomContactUI vWA;

            {
                this.vWA = r1;
            }

            public final void OF() {
            }

            public final void OG() {
            }

            public final void mR(String str) {
                w.d("MicroMsg.ChatroomContactUI", "onSearchBarChange %s", str);
                ChatroomContactUI.a(this.vWA, u.my(str));
            }

            public final void OD() {
            }

            public final void OE() {
            }

            public final void aej() {
                w.v("MicroMsg.ChatroomContactUI", "onVoiceSearchStart");
                this.vWA.aHf();
            }

            public final void aek() {
            }

            public final void a(boolean z, String[] strArr, long j, int i) {
                w.v("MicroMsg.ChatroomContactUI", "onVoiceReturn");
                if (z) {
                    Intent intent = new Intent(this.vWA.uSU.uTo, VoiceSearchResultUI.class);
                    intent.putExtra("VoiceSearchResultUI_Resultlist", strArr);
                    intent.putExtra("VoiceSearchResultUI_VoiceId", j);
                    intent.putExtra("VoiceSearchResultUI_ShowType", i);
                    this.vWA.uSU.uTo.startActivity(intent);
                    return;
                }
                intent = new Intent(this.vWA.uSU.uTo, VoiceSearchResultUI.class);
                intent.putExtra("VoiceSearchResultUI_Resultlist", new String[0]);
                intent.putExtra("VoiceSearchResultUI_Error", this.vWA.uSU.uTo.getString(R.l.elv));
                intent.putExtra("VoiceSearchResultUI_VoiceId", j);
                intent.putExtra("VoiceSearchResultUI_ShowType", i);
                this.vWA.uSU.uTo.startActivity(intent);
            }

            public final boolean mQ(String str) {
                return false;
            }
        });
        a(this.vWy);
        this.vWz.a(new MMSlideDelView.c(this) {
            final /* synthetic */ ChatroomContactUI vWA;

            {
                this.vWA = r1;
            }

            public final int cb(View view) {
                return this.vWA.mZO.getPositionForView(view);
            }
        });
        this.vWz.a(new f(this) {
            final /* synthetic */ ChatroomContactUI vWA;

            {
                this.vWA = r1;
            }

            public final void s(View view, int i) {
                this.vWA.mZO.performItemClick(view, i, 0);
            }
        });
        this.vWz.a(new MMSlideDelView.e(this) {
            final /* synthetic */ ChatroomContactUI vWA;

            {
                this.vWA = r1;
            }

            public final void aQ(Object obj) {
                if (obj == null) {
                    w.e("MicroMsg.ChatroomContactUI", "onItemDel object null");
                    return;
                }
                ChatroomContactUI.TN(obj.toString());
                this.vWA.aFP();
            }
        });
        this.mZO.setOnScrollListener(this.ktu);
        this.vWz.sMR = this.ktu;
        this.kaU = new g(this.uSU.uTo);
        this.mZO.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ChatroomContactUI vWA;

            {
                this.vWA = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                w.d("MicroMsg.ChatroomContactUI", "onItemClick " + i + (this.vWA.vVq == null ? this.vWA.vVq : Boolean.valueOf(this.vWA.vVq.wsb)));
                if (i >= this.vWA.mZO.getHeaderViewsCount()) {
                    int headerViewsCount = i - this.vWA.mZO.getHeaderViewsCount();
                    if (this.vWA.vVq == null || !this.vWA.vVq.wsb) {
                        ChatroomContactUI.b(this.vWA, ((x) this.vWA.vWz.getItem(headerViewsCount)).field_username);
                        return;
                    }
                    boolean nJ = this.vWA.vVq.nJ(headerViewsCount);
                    boolean Ck = this.vWA.vVq.Ck(headerViewsCount);
                    w.d("MicroMsg.ChatroomContactUI", "onItemClick " + Ck);
                    if (Ck) {
                        this.vWA.vVq.Uv(this.vWA.vWy == null ? "" : this.vWA.vWy.bzZ());
                    } else if (nJ) {
                        awp Cj = this.vWA.vVq.Cj(headerViewsCount);
                        String str = Cj.ttp.tZr;
                        ap.yY();
                        af Rc = c.wR().Rc(str);
                        if (com.tencent.mm.j.a.ez(Rc.field_type)) {
                            r1 = new Intent();
                            r1.putExtra("Contact_User", str);
                            r1.putExtra("Contact_Scene", 3);
                            if (str != null && str.length() > 0) {
                                if (Rc.bLe()) {
                                    com.tencent.mm.plugin.report.service.g.oUh.A(10298, str + ",3");
                                }
                                e.a(r1, str);
                                com.tencent.mm.bb.d.b(this.vWA, "profile", ".ui.ContactInfoUI", r1);
                                return;
                            }
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", Cj.ttp.tZr);
                        intent.putExtra("Contact_Alias", Cj.hAI);
                        intent.putExtra("Contact_Nick", Cj.tLj.tZr);
                        intent.putExtra("Contact_Signature", Cj.hAG);
                        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ab(Cj.hAM, Cj.hAE, Cj.hAF));
                        intent.putExtra("Contact_Sex", Cj.hAD);
                        intent.putExtra("Contact_VUser_Info", Cj.tMQ);
                        intent.putExtra("Contact_VUser_Info_Flag", Cj.tMP);
                        intent.putExtra("Contact_KWeibo_flag", Cj.tMT);
                        intent.putExtra("Contact_KWeibo", Cj.tMR);
                        intent.putExtra("Contact_KWeiboNick", Cj.tMS);
                        intent.putExtra("Contact_KSnsIFlag", Cj.tMV.hAO);
                        intent.putExtra("Contact_KSnsBgId", Cj.tMV.hAQ);
                        intent.putExtra("Contact_KSnsBgUrl", Cj.tMV.hAP);
                        if (Cj.tMW != null) {
                            try {
                                intent.putExtra("Contact_customInfo", Cj.tMW.toByteArray());
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.ChatroomContactUI", e, "", new Object[0]);
                            }
                        }
                        if ((Cj.tMP & 8) > 0) {
                            com.tencent.mm.plugin.report.service.g.oUh.A(10298, str + ",3");
                        }
                        com.tencent.mm.bb.d.b(this.vWA, "profile", ".ui.ContactInfoUI", intent);
                    } else {
                        af kO = this.vWA.vVq.kO(headerViewsCount);
                        if (kO == null) {
                            w.e("MicroMsg.ChatroomContactUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", Integer.valueOf(this.vWA.vVq.getCount()), Integer.valueOf(headerViewsCount));
                            return;
                        }
                        u.h(this.vWA.vWy.bzZ(), 9, 3, headerViewsCount + 1);
                        String str2 = kO.field_username;
                        r1 = new Intent(this.vWA.uSU.uTo, En_5b8fbb1e.class);
                        r1.addFlags(67108864);
                        r1.putExtra("Chat_User", str2);
                        r1.putExtra("Chat_Mode", 1);
                        this.vWA.uSU.uTo.startActivity(r1);
                    }
                }
            }
        });
        this.mZO.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ ChatroomContactUI vWA;

            {
                this.vWA = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                w.d("MicroMsg.ChatroomContactUI", "onItemLongClick, targetview is SearchBar::ListView, pos = " + i);
                if (i < this.vWA.mZO.getHeaderViewsCount()) {
                    w.w("MicroMsg.ChatroomContactUI", "on item long click, but match header view");
                    return true;
                } else if (this.vWA.vVq != null && this.vWA.vVq.wsb) {
                    return true;
                } else {
                    String str = ((x) this.vWA.vWz.getItem(i - this.vWA.mZO.getHeaderViewsCount())).field_username;
                    if (o.fu(str) || o.fv(str)) {
                        return true;
                    }
                    this.vWA.vVs = str;
                    this.vWA.kaU.a(view, i, j, this.vWA, this.vWA.lmm, this.vWA.kaQ, this.vWA.kaR);
                    return true;
                }
            }
        });
        this.mZO.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ChatroomContactUI vWA;

            {
                this.vWA = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        this.vWA.aHf();
                        this.vWA.kaQ = (int) motionEvent.getRawX();
                        this.vWA.kaR = (int) motionEvent.getRawY();
                        break;
                }
                if (this.vWA.vWz != null) {
                    d f = this.vWA.vWz;
                    if (f.hBe != null) {
                        f.hBe.onTouchEvent(motionEvent);
                    }
                }
                if (this.vWA.vVq != null) {
                    b d = this.vWA.vVq;
                    if (d.hBe != null) {
                        d.hBe.onTouchEvent(motionEvent);
                    }
                }
                return false;
            }
        });
        ListView listView = this.mZO;
        View contactCountView = new ContactCountView(this);
        this.vVD = contactCountView;
        listView.addFooterView(contactCountView, null, false);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ChatroomContactUI vWA;

            {
                this.vWA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vWA.finish();
                return false;
            }
        });
        a(0, R.l.dBP, R.k.dsI, new OnMenuItemClickListener(this) {
            final /* synthetic */ ChatroomContactUI vWA;

            {
                this.vWA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(this.vWA, SelectContactUI.class);
                intent.putExtra("titile", this.vWA.getString(R.l.dCS));
                intent.putExtra("list_type", 0);
                intent.putExtra("list_attr", s.q(s.vYP, 256, 512));
                this.vWA.uSU.uTo.startActivity(intent);
                return false;
            }
        });
        AnonymousClass4 anonymousClass4 = new OnClickListener(this) {
            final /* synthetic */ ChatroomContactUI vWA;

            {
                this.vWA = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.vWA.mZO);
            }
        };
        this.mZO.setAdapter(this.vWz);
        this.vVq.lP(false);
        this.mZO.setVisibility(0);
        this.uQu = new VoiceSearchLayout(this);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(14);
        this.uQu.setLayoutParams(layoutParams);
        this.uQu.xo(BackwardSupportUtil.b.a((Context) this, 100.0f));
        this.uQu.setVisibility(8);
        ((ViewGroup) findViewById(R.h.cNM)).addView(this.uQu);
        if (this.uQu != null) {
            this.uQu.sLB = new VoiceSearchLayout.b(this) {
                final /* synthetic */ ChatroomContactUI vWA;

                {
                    this.vWA = r1;
                }

                public final void jt(boolean z) {
                    w.d("MicroMsg.ChatroomContactUI", "visible " + z);
                    if (z) {
                        int firstVisiblePosition = this.vWA.mZO.getFirstVisiblePosition();
                        w.d("MicroMsg.ChatroomContactUI", "getFirstVisiblePosition  " + firstVisiblePosition);
                        if (firstVisiblePosition > 0) {
                            this.vWA.mZO.post(new Runnable(this) {
                                final /* synthetic */ AnonymousClass5 vWB;

                                {
                                    this.vWB = r1;
                                }

                                public final void run() {
                                    this.vWB.vWA.mZO.setSelection(0);
                                }
                            });
                        }
                    }
                }
            };
        }
        if (this.vWz.getCount() == 0) {
            this.lGB.setSingleLine(false);
            this.lGB.setPadding(40, 0, 40, 0);
            this.lGB.setVisibility(0);
        }
    }

    protected void onResume() {
        super.onResume();
        if (this.vVD != null) {
            this.vVD.vWC = 2;
            this.vVD.bXO();
        }
        ap.yY();
        c.xa().c(this);
        if (!(this.vWy == null || this.uQu == null)) {
            com.tencent.mm.bb.d.bGP();
            if (com.tencent.mm.ai.b.Hp() || !v.bIN().equals("zh_CN")) {
                this.vWy.sXA = false;
            } else {
                this.vWy.sXA = true;
                this.vWy.o(this.uQu);
            }
        }
        if (this.vVq != null) {
            this.vVq.onResume();
        }
    }

    protected void onPause() {
        super.onPause();
        ap.yY();
        c.xa().f(this);
        if (this.vWy != null) {
            p pVar = this.vWy;
            pVar.bZQ();
            pVar.cancel();
        }
        if (this.vVq != null) {
            this.vVq.onPause();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        ap.vd().b(138, (e) this);
        ap.yY();
        c.wR().b(this.vWz);
        d dVar = this.vWz;
        if (dVar.hBe != null) {
            dVar.hBe.detach();
            dVar.hBe = null;
        }
        this.vWz.aEW();
        this.vWz.uSN = null;
        this.vVq.detach();
        this.vVq.aEW();
    }

    private void aFP() {
        if (this.vWz != null) {
            this.vWz.a(null, null);
        }
        if (this.vVq != null) {
            this.vVq.a(null, null);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (u.bp(this) && !com.tencent.mm.ui.p.a.a(this, i, i2, str, 4) && i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 138:
                    aFP();
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(String str, l lVar) {
        if (this.vVD != null) {
            this.vVD.vWC = 2;
            this.vVD.bXO();
        }
    }
}
