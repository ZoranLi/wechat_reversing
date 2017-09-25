package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.nz;
import com.tencent.mm.e.b.af;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.i;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SeeRoomMemberUI extends MMActivity implements e {
    private static int kwA = 5;
    private String fJL;
    private boolean fOg;
    private p iLz;
    private boolean ksZ;
    private q ktr;
    private String kuC;
    private String kuR;
    private int kuS;
    private String kuT;
    private boolean kuU;
    private GridView kwm;
    private b kwt;
    private String kwu;
    private String kwv;
    private com.tencent.mm.ui.tools.p kww;
    private String kwx;
    private MMEditText kwy;
    private int kwz;
    private String mTitle;
    private String username;
    private int wa;

    private static class a {
        x jiL;
        int type;

        public a(int i, x xVar) {
            this.type = i;
            this.jiL = xVar;
        }
    }

    private class b extends BaseAdapter {
        private List<a> fPq = new ArrayList();
        private List<String> jBA;
        private String ktm;
        private q ktr;
        private com.tencent.mm.u.c kvX;
        final /* synthetic */ SeeRoomMemberUI kwB;
        public String kwE;
        private boolean kwF = false;
        private String kwG = null;
        private List<a> kwH;
        private Context mContext;

        public final /* synthetic */ Object getItem(int i) {
            return kN(i);
        }

        public b(SeeRoomMemberUI seeRoomMemberUI, Context context, q qVar, String str, List<String> list, String str2) {
            this.kwB = seeRoomMemberUI;
            this.ktr = qVar;
            this.ktm = str;
            this.jBA = list;
            this.kwG = str2;
            this.mContext = context;
            this.kvX = ap.yY();
            ag(j.eA(str));
        }

        public final void ag(List<String> list) {
            if (list != null) {
                this.fPq.clear();
                for (int i = 0; i < list.size(); i++) {
                    af Rc = com.tencent.mm.u.c.wR().Rc((String) list.get(i));
                    if (Rc == null || !Rc.field_username.equals(this.kwG)) {
                        this.fPq.add(new a(1, Rc));
                    } else {
                        this.fPq.add(0, new a(1, Rc));
                    }
                }
                this.fPq.add(new a(2, null));
                if (this.kwB.kuU) {
                    this.fPq.add(new a(3, null));
                }
                this.kwH = this.fPq;
                notifyDataSetChanged();
            }
        }

        public final a kN(int i) {
            return (a) this.fPq.get(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null) {
                view = View.inflate(this.mContext, R.i.dnt, null);
                cVar = new c();
                cVar.ipv = (ImageView) view.findViewById(R.h.cBw);
                cVar.jZz = (TextView) view.findViewById(R.h.cBy);
                cVar.jZz.setMaxWidth((((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth() * 2) / 3);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a aVar = (a) this.fPq.get(i);
            if (aVar != null && aVar.type == 1) {
                CharSequence charSequence;
                af afVar = aVar.jiL;
                com.tencent.mm.pluginsdk.ui.a.b.a(cVar.ipv, afVar.field_username);
                String a = SeeRoomMemberUI.a(this.ktr, afVar.field_username);
                if (bg.mA(afVar.field_conRemark)) {
                    Object obj = a;
                } else {
                    charSequence = afVar.field_conRemark;
                }
                if (bg.mA(charSequence)) {
                    charSequence = afVar.tK();
                }
                if (!(a == null || a.equals("") || charSequence.equals(a))) {
                    charSequence = a + "( " + charSequence + " )";
                }
                cVar.jZz.setVisibility(0);
                cVar.jZz.setText(h.b(this.mContext, charSequence, cVar.jZz.getTextSize()));
            } else if (aVar != null && aVar.type == 2) {
                cVar.jZz.setVisibility(4);
                cVar.ipv.setImageResource(R.g.bct);
            } else if (aVar != null && aVar.type == 3) {
                cVar.jZz.setVisibility(4);
                cVar.ipv.setImageResource(R.g.bcu);
            }
            return view;
        }

        public final void ts(String str) {
            this.kwF = true;
            this.kwE = str;
            List arrayList = new ArrayList();
            if (bg.mA(str)) {
                this.fPq = this.kwH;
            } else {
                for (a aVar : this.kwH) {
                    if (!(aVar == null || aVar.jiL == null || aVar.type != 1)) {
                        af afVar = aVar.jiL;
                        if (afVar.field_conRemark != null && afVar.field_conRemark.toUpperCase().contains(str.toUpperCase())) {
                            arrayList.add(aVar);
                        } else if (!bg.mA(SeeRoomMemberUI.a(this.ktr, afVar.field_username)) && SeeRoomMemberUI.a(this.ktr, afVar.field_username).contains(str)) {
                            arrayList.add(aVar);
                        } else if (afVar.tK() != null && afVar.tK().toUpperCase().contains(str.toUpperCase())) {
                            arrayList.add(aVar);
                        } else if (afVar.pB() != null && afVar.pB().toUpperCase().contains(str.toUpperCase())) {
                            arrayList.add(aVar);
                        } else if (afVar.pA() != null && afVar.pA().contains(str)) {
                            arrayList.add(aVar);
                        } else if (afVar.field_username != null && afVar.field_username.contains(str)) {
                            arrayList.add(aVar);
                        } else if (!com.tencent.mm.j.a.ez(afVar.field_type)) {
                            ap.yY();
                            bb AI = com.tencent.mm.u.c.wS().AI(afVar.field_username);
                            if (!(AI == null || AI.field_conRemark == null || !AI.field_conRemark.toUpperCase().contains(str.toUpperCase()))) {
                                arrayList.add(aVar);
                            }
                        }
                    }
                }
                w.i("MicroMsg.SeeRoomMemberUI", "[setMemberListBySearch]");
                this.fPq = arrayList;
            }
            notifyDataSetChanged();
        }

        public final int getCount() {
            return this.fPq.size();
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    private static class c {
        public ImageView ipv;
        public TextView jZz;
    }

    static /* synthetic */ void a(SeeRoomMemberUI seeRoomMemberUI, int i) {
        if (seeRoomMemberUI.kwt.kN(i).type == 1) {
            String str = seeRoomMemberUI.kwt.kN(i).jiL.field_username;
            w.d("MicroMsg.SeeRoomMemberUI", "roomPref del " + i + " userName : " + str);
            ap.yY();
            if (bg.ap((String) com.tencent.mm.u.c.vr().get(2, null), "").equals(str)) {
                g.h(seeRoomMemberUI.uSU.uTo, R.l.eMt, R.l.dIO);
            } else {
                seeRoomMemberUI.tq(str);
            }
        }
    }

    static /* synthetic */ void a(SeeRoomMemberUI seeRoomMemberUI, Context context) {
        if (context != null && aji()) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", seeRoomMemberUI.getString(R.l.dSY, new Object[]{v.bIN()}));
            intent.putExtra("geta8key_username", m.xL());
            intent.putExtra("showShare", false);
            d.b(seeRoomMemberUI, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
        }
    }

    static /* synthetic */ void a(SeeRoomMemberUI seeRoomMemberUI, String str, String str2, String str3) {
        if (bg.mA(str2)) {
            ap.yY();
            bb AI = com.tencent.mm.u.c.wS().AI(str);
            if (!(AI == null || bg.mA(AI.field_encryptUsername))) {
                str2 = AI.field_conRemark;
            }
        }
        if (!bg.mA(str)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", str);
            intent.putExtra("Contact_RemarkName", str2);
            if (seeRoomMemberUI.fOg && seeRoomMemberUI.ktr != null) {
                intent.putExtra("Contact_RoomNickname", seeRoomMemberUI.ktr.eK(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", seeRoomMemberUI.kuR);
            ap.yY();
            af Rc = com.tencent.mm.u.c.wR().Rc(str);
            if (Rc != null && ((int) Rc.gTQ) > 0 && com.tencent.mm.j.a.ez(Rc.field_type)) {
                com.tencent.mm.sdk.b.b nzVar = new nz();
                nzVar.fVf.intent = intent;
                nzVar.fVf.username = str;
                com.tencent.mm.sdk.b.a.urY.m(nzVar);
            }
            if (seeRoomMemberUI.fOg) {
                if (Rc != null && Rc.bLe()) {
                    com.tencent.mm.plugin.report.service.g.oUh.A(10298, Rc.field_username + ",14");
                }
                intent.putExtra("Contact_Scene", 14);
            } else if (seeRoomMemberUI.ksZ) {
                intent.putExtra("Contact_Scene", 44);
                if (!m.eH(Rc.field_username)) {
                    intent.putExtra("Contact_IsLBSFriend", true);
                }
            }
            intent.putExtra("Is_RoomOwner", seeRoomMemberUI.kuU);
            intent.putExtra("Contact_ChatRoomId", seeRoomMemberUI.kuC);
            com.tencent.mm.plugin.chatroom.a.imv.d(intent, seeRoomMemberUI);
        }
    }

    static /* synthetic */ void d(SeeRoomMemberUI seeRoomMemberUI) {
        String c = bg.c(j.eA(seeRoomMemberUI.kuC), ",");
        Intent intent = new Intent();
        intent.putExtra("titile", seeRoomMemberUI.getString(R.l.dCT));
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", s.vYO);
        intent.putExtra("always_select_contact", c);
        intent.putExtra("scene", 4);
        d.a(seeRoomMemberUI, ".ui.contact.SelectContactUI", intent, 1);
    }

    static /* synthetic */ void e(SeeRoomMemberUI seeRoomMemberUI) {
        com.tencent.mm.plugin.report.service.g.oUh.a(219, 8, 1, true);
        List eA = j.eA(seeRoomMemberUI.kuC);
        String c = bg.c(eA, ",");
        int size = eA.size();
        Intent intent = new Intent();
        intent.putExtra("RoomInfo_Id", seeRoomMemberUI.kuC);
        intent.putExtra("Is_Chatroom", true);
        intent.putExtra("Chatroom_member_list", c);
        intent.putExtra("room_member_count", size);
        intent.putExtra("Is_RoomOwner", seeRoomMemberUI.kuU);
        intent.putExtra("list_attr", s.vYO);
        intent.putExtra("room_name", seeRoomMemberUI.kuC);
        intent.putExtra("room_owner_name", seeRoomMemberUI.ktr.field_roomowner);
        intent.setClass(seeRoomMemberUI, SelectDelRoomMemberUI.class);
        seeRoomMemberUI.startActivityForResult(intent, 2);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.plugin.report.service.g.oUh.a(219, 2, 1, true);
        ap.vd().a(990, this);
        ap.vd().a(179, this);
        ap.vd().a(120, this);
        ap.vd().a(610, this);
        this.kuC = getIntent().getStringExtra("RoomInfo_Id");
        this.fJL = getIntent().getStringExtra("Chat_User");
        this.kwv = getIntent().getStringExtra("Chatroom_member_list");
        this.fOg = getIntent().getBooleanExtra("Is_Chatroom", true);
        this.ksZ = getIntent().getBooleanExtra("Is_Lbsroom", false);
        this.kuU = getIntent().getBooleanExtra("Is_RoomOwner", false);
        this.kuT = getIntent().getStringExtra("room_owner_name");
        this.mTitle = getIntent().getStringExtra("Add_address_titile");
        ap.yY();
        this.ktr = com.tencent.mm.u.c.xa().fV(this.fJL == null ? this.kuC : this.fJL);
        this.kuS = getIntent().getIntExtra("room_member_count", 0);
        this.kuR = getIntent().getStringExtra("room_name");
        this.wa = getIntent().getIntExtra("offset", 0);
        this.kwz = getIntent().getIntExtra("first_pos", 0);
        KC();
        if (this.kwt != null) {
            ajB();
            this.kwm.setSelection(this.kwz * kwA < this.kwt.getCount() ? this.kwz * kwA : this.kwt.getCount() - 1);
            this.kwm.postDelayed(new Runnable(this) {
                final /* synthetic */ SeeRoomMemberUI kwB;

                {
                    this.kwB = r1;
                }

                public final void run() {
                    if (VERSION.SDK_INT >= 19) {
                        this.kwB.kwm.scrollListBy(this.kwB.wa);
                        return;
                    }
                    SeeRoomMemberUI.a((Object) this.kwB.kwm, "trackMotionScroll", new Object[]{Integer.valueOf(-this.kwB.wa), Integer.valueOf(-this.kwB.wa)}, new Class[]{Integer.TYPE, Integer.TYPE});
                }
            }, 100);
        }
    }

    public void onResume() {
        super.onResume();
        if (this.kwt != null) {
            this.kwt.ts(this.kwy.getText().toString());
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.kwm.setNumColumns(bN(this));
    }

    private static int bN(Context context) {
        if (context == null) {
            return 0;
        }
        int width = (int) ((((float) ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth()) - (context.getResources().getDimension(R.f.aXw) * 1.0f)) / ((float) ((int) ((context.getResources().getDimension(R.f.aXz) * 2.0f) + context.getResources().getDimension(R.f.aXB)))));
        w.i("MicroMsg.SeeRoomMemberUI", "[getWrapColNum] :%s", new Object[]{Integer.valueOf(width)});
        kwA = width;
        return width;
    }

    protected final void KC() {
        qP(this.mTitle + "(" + this.kuS + ")");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SeeRoomMemberUI kwB;

            {
                this.kwB = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kwB.setResult(0);
                this.kwB.finish();
                return true;
            }
        });
        this.kwy = (MMEditText) findViewById(R.h.cmc);
        this.kwm = (GridView) findViewById(R.h.bzi);
        this.kwm.setNumColumns(bN(this));
        this.kwm.setColumnWidth(getResources().getDimensionPixelSize(R.f.aXw));
        q qVar = this.ktr;
        String str = this.kuC;
        List linkedList = new LinkedList();
        if (!bg.mA(this.kwu)) {
            linkedList = bg.f(this.kwu.split(","));
        }
        ap.yY();
        ay AH = com.tencent.mm.u.c.wZ().AH("@t.qq.com");
        if (AH != null) {
            linkedList.add(AH.name);
        }
        this.kwt = new b(this, this, qVar, str, linkedList, this.kuT);
        this.kwy.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SeeRoomMemberUI kwB;

            {
                this.kwB = r1;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.kwB.kwt.ts(charSequence.toString());
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.kwm.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SeeRoomMemberUI kwB;

            {
                this.kwB = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a kN = this.kwB.kwt.kN(i);
                if (kN.type == 2) {
                    w.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Add member");
                    com.tencent.mm.plugin.report.service.g.oUh.a(219, 6, 1, true);
                    SeeRoomMemberUI.d(this.kwB);
                } else if (kN.type == 3) {
                    w.i("MicroMsg.SeeRoomMemberUI", "[onItemClick] Delete member");
                    SeeRoomMemberUI.e(this.kwB);
                } else if (kN.type == 1) {
                    af afVar = this.kwB.kwt.kN(i).jiL;
                    if (afVar == null) {
                        w.e("MicroMsg.SeeRoomMemberUI", "cont is null");
                        return;
                    }
                    this.kwB.username = afVar.field_username;
                    String str = afVar.field_nickname;
                    String a = SeeRoomMemberUI.a(this.kwB.ktr, this.kwB.username);
                    if (bg.mA(a)) {
                        this.kwB.kwx = afVar.tL();
                    } else {
                        this.kwB.kwx = a;
                    }
                    u.h(this.kwB.kwy.getText().toString(), 1, 6, i + 1);
                    SeeRoomMemberUI.a(this.kwB, this.kwB.username, this.kwB.kwx, str);
                }
            }
        });
        this.kwm.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ SeeRoomMemberUI kwB;

            {
                this.kwB = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                if (this.kwB.kuU) {
                    af afVar = this.kwB.kwt.kN(i).jiL;
                    if (afVar != null) {
                        if (!this.kwB.ktr.field_roomowner.equals(afVar.field_username)) {
                            g.a(this.kwB, this.kwB.getString(R.l.eMe), "", new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass8 kwC;

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    SeeRoomMemberUI.a(this.kwC.kwB, i);
                                }
                            }, new OnClickListener(this) {
                                final /* synthetic */ AnonymousClass8 kwC;

                                {
                                    this.kwC = r1;
                                }

                                public final void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                        }
                    }
                } else {
                    w.i("MicroMsg.SeeRoomMemberUI", "U are not a roomowner");
                }
                return true;
            }
        });
        this.kwm.setAdapter(this.kwt);
    }

    private void ajB() {
        ap.yY();
        this.ktr = com.tencent.mm.u.c.xa().fV(this.fJL == null ? this.kuC : this.fJL);
        List eA = j.eA(this.kuC);
        if (this.kwt != null) {
            this.kwt.ag(eA);
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.kww != null) {
            this.kww.bZQ();
        }
    }

    protected void onDestroy() {
        ap.vd().b(990, this);
        ap.vd().b(179, this);
        ap.vd().b(120, this);
        ap.vd().b(610, this);
        if (this.iLz != null && this.iLz.isShowing()) {
            this.iLz.dismiss();
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dnu;
    }

    private void tq(String str) {
        if (str != null && !str.equals("")) {
            List linkedList = new LinkedList();
            linkedList.add(str);
            final k gVar = new com.tencent.mm.plugin.chatroom.d.g(this.kuC, linkedList);
            getString(R.l.dIO);
            this.iLz = g.a(this, getString(R.l.eMd), true, new OnCancelListener(this) {
                final /* synthetic */ SeeRoomMemberUI kwB;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(gVar);
                }
            });
            ap.vd().a(gVar, 0);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.iLz != null && this.iLz.isShowing()) {
            this.iLz.dismiss();
        }
        com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(str);
        if (dn != null) {
            dn.a(this, null, null);
        } else if (i != 0 || i2 != 0) {
            if (kVar.getType() == 179 && i2 == -66) {
                g.b(this, getString(R.l.ebr), getString(R.l.dIO), true);
            }
            if (kVar.getType() == 120) {
                a(i2, (com.tencent.mm.plugin.chatroom.d.d) kVar);
            } else if (kVar.getType() == 610) {
                g.b(this, getString(R.l.esW), getString(R.l.dIO), true);
            }
        } else if (i == 0 && i2 == 0) {
            switch (kVar.getType()) {
                case 120:
                    a(i2, (com.tencent.mm.plugin.chatroom.d.d) kVar);
                    ajB();
                    break;
                case 179:
                    ajB();
                    break;
                case 610:
                    g.b(this, getString(R.l.esX), null, true);
                    break;
            }
            if (this.ktr != null) {
                qP(this.mTitle + "(" + this.ktr.DU().size() + ")");
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    if (!o.eN(stringExtra)) {
                        g.b(this, getString(R.l.eML), getString(R.l.dIO), true);
                        return;
                    } else if (tr(stringExtra)) {
                        g.b(this, getString(R.l.dCc), getString(R.l.dIO), true);
                        return;
                    } else if (bg.f(stringExtra.split(",")) != null) {
                        final String stringExtra2 = intent.getStringExtra("Select_Contact");
                        ap.yY();
                        q fV = com.tencent.mm.u.c.xa().fV(this.kuC);
                        if (fV == null) {
                            return;
                        }
                        if (fV.bKV() == 2) {
                            com.tencent.mm.pluginsdk.ui.applet.d.a(this.uSU, getString(R.l.eLG), getString(R.l.eIw), getString(R.l.dIA), new com.tencent.mm.pluginsdk.ui.applet.k.a(this) {
                                final /* synthetic */ SeeRoomMemberUI kwB;

                                public final void a(boolean z, String str, int i) {
                                    if (z) {
                                        this.kwB.n(stringExtra2, str, R.l.etf);
                                    }
                                }
                            });
                            return;
                        } else {
                            n(stringExtra, null, R.l.dCi);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                return;
            case 2:
                if (intent != null) {
                    tq(intent.getStringExtra("Select_Contact"));
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void n(String str, String str2, int i) {
        if (!o.eN(str)) {
            g.b(this, getString(R.l.eML), getString(R.l.dIO), true);
        } else if (tr(str)) {
            g.b(this, getString(R.l.dCc), getString(R.l.dIO), true);
        } else {
            List f = bg.f(str.split(","));
            if (f != null) {
                final k dVar = new com.tencent.mm.plugin.chatroom.d.d(this.kuC, f, str2);
                getString(R.l.dIO);
                this.iLz = g.a(this, getString(i), true, new OnCancelListener(this) {
                    final /* synthetic */ SeeRoomMemberUI kwB;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(dVar);
                    }
                });
                ap.vd().a(dVar, 0);
            }
        }
    }

    private void a(int i, com.tencent.mm.plugin.chatroom.d.d dVar) {
        Object obj = null;
        String str = "";
        String str2 = "";
        String string = ab.getContext().getString(R.l.dTc);
        final List list = dVar.ksL;
        final List list2 = dVar.ksN;
        final List list3 = dVar.fPw;
        if (i != -2012 || ((list == null || list.isEmpty()) && (list2 == null || list2.isEmpty()))) {
            ap.yY();
            q fW = com.tencent.mm.u.c.xa().fW(this.kuC);
            if (i == -116 && aji() && !bg.mA(fW.field_roomowner)) {
                str = getString(R.l.eMI);
                str2 = getString(R.l.eMH);
                obj = 1;
            }
            if (i == -23) {
                str = getString(R.l.eMO);
                str2 = getString(R.l.eMN);
            }
            if (i == -109) {
                str = getString(R.l.eMK);
                str2 = getString(R.l.eMJ);
            }
            if (i == -122) {
                str = getString(R.l.eMO);
                int i2 = R.l.eMM;
                Object[] objArr = new Object[2];
                str2 = null;
                ap.yY();
                af Rc = com.tencent.mm.u.c.wR().Rc(this.ktr.field_roomowner);
                if (Rc != null && ((int) Rc.gTQ) > 0) {
                    str2 = Rc.field_conRemark;
                }
                if (bg.mA(str2)) {
                    str2 = this.ktr.field_roomowner;
                    if (this.ktr == null) {
                        str2 = null;
                    } else {
                        str2 = this.ktr.eK(str2);
                    }
                }
                if (bg.mA(str2) && Rc != null && ((int) Rc.gTQ) > 0) {
                    str2 = Rc.tK();
                }
                if (bg.mA(str2)) {
                    str2 = this.ktr.field_roomowner;
                }
                objArr[0] = str2;
                objArr[1] = Integer.valueOf(fW.bKW());
                str2 = getString(i2, objArr);
            }
            list2 = dVar.ksM;
            if (list3 == null || list3.size() <= 0 || (list3.size() != dVar.fOw && (list2 == null || list2.size() <= 0 || dVar.fOw != list3.size() + list2.size()))) {
                list2 = dVar.ksM;
                if (list2 != null && list2.size() > 0) {
                    str2 = str2 + getString(R.l.elw, new Object[]{bg.c(ae(list2), string)});
                }
                list2 = dVar.fPv;
                if (list2 != null && list2.size() > 0) {
                    str = getString(R.l.dCa);
                    str2 = str2 + getString(R.l.elD, new Object[]{bg.c(ae(list2), string)});
                }
                list2 = dVar.fPt;
                if (list2 != null && list2.size() > 0) {
                    str = getString(R.l.dCa);
                    str2 = str2 + getString(R.l.elx, new Object[]{bg.c(ae(list2), string)});
                }
                Collection collection = dVar.ksN;
                if (!(list3 == null || list3.isEmpty()) || (collection != null && collection.size() > 0)) {
                    List arrayList = new ArrayList();
                    arrayList.addAll(list3);
                    arrayList.addAll(collection);
                    d(dVar.chatroomName, list3);
                    str2 = str2 + getString(R.l.elm, new Object[]{bg.c(ae(arrayList), string)});
                    if (list3 != null && list3.isEmpty()) {
                        str2 = null;
                    }
                }
                if (str2 != null && str2.length() > 0) {
                    if (obj != null) {
                        g.a(this, str2, str, new OnClickListener(this) {
                            final /* synthetic */ SeeRoomMemberUI kwB;

                            {
                                this.kwB = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                SeeRoomMemberUI.a(this.kwB, this.kwB);
                            }
                        }, null);
                    } else {
                        g.b(this, str2, str, true);
                    }
                }
                fW.bKV();
                return;
            }
            List linkedList = new LinkedList();
            for (int i3 = 0; i3 < list3.size(); i3++) {
                linkedList.add(list3.get(i3));
            }
            str2 = "";
            String string2 = ab.getContext().getString(R.l.dTc);
            if (!(list2 == null || list2.isEmpty())) {
                str2 = getString(R.l.ell, new Object[]{bg.c(ae(list2), string2)}) + "\n";
            }
            if (!linkedList.isEmpty()) {
                str2 = str2 + getString(R.l.elm, new Object[]{bg.c(ae(linkedList), string2)});
            }
            g.a(this, str2, "", getString(R.l.elg), new OnClickListener(this) {
                final /* synthetic */ SeeRoomMemberUI kwB;

                {
                    this.kwB = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.kwB.ajB();
                }
            });
            d(dVar.chatroomName, linkedList);
            return;
        }
        string = getString(R.l.dCb);
        String string3 = getString(R.l.esL);
        String string4 = getString(R.l.dGs);
        final com.tencent.mm.plugin.chatroom.d.d dVar2 = dVar;
        AnonymousClass12 anonymousClass12 = new OnClickListener(this) {
            final /* synthetic */ SeeRoomMemberUI kwB;

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.kwB.d(dVar2.chatroomName, list3);
                List arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.addAll(list2);
                final k kVar = new com.tencent.mm.plugin.chatroom.d.k(this.kwB.kuC, arrayList);
                ap.vd().a(kVar, 0);
                SeeRoomMemberUI seeRoomMemberUI = this.kwB;
                Context context = this.kwB;
                this.kwB.getString(R.l.dIO);
                seeRoomMemberUI.iLz = g.a(context, this.kwB.getString(R.l.eMC), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass12 kwD;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(kVar);
                    }
                });
            }
        };
        g.a(this, string, null, string3, string4, anonymousClass12, new OnClickListener(this) {
            final /* synthetic */ SeeRoomMemberUI kwB;

            {
                this.kwB = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    private void d(String str, List<String> list) {
        if (list != null && list.size() > 0) {
            List linkedList = new LinkedList();
            for (int i = 0; i < list.size(); i++) {
                linkedList.add(list.get(i));
            }
            i.a(str, linkedList, getString(R.l.dTb), true, "weixin://findfriend/verifycontact/" + str + "/");
        }
    }

    private static boolean aji() {
        return bg.getInt(com.tencent.mm.i.g.sV().getValue("ChatroomGlobalSwitch"), 1) == 1;
    }

    private static List<String> ae(List<String> list) {
        List<String> linkedList = new LinkedList();
        if (!ap.zb()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            ap.yY();
            com.tencent.mm.j.a Rc = com.tencent.mm.u.c.wR().Rc(obj2);
            if (!(Rc == null || ((int) Rc.gTQ) == 0)) {
                obj2 = Rc.tL();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    private boolean tr(String str) {
        if (bg.mz(m.xL()).equals(str)) {
            return true;
        }
        List<String> eA = j.eA(this.kuC);
        if (eA == null) {
            return false;
        }
        boolean z = false;
        for (String equals : eA) {
            boolean z2;
            if (equals.equals(str)) {
                z2 = true;
            } else {
                z2 = z;
            }
            z = z2;
        }
        return z;
    }

    protected static String a(q qVar, String str) {
        if (qVar == null) {
            return "";
        }
        return qVar.eK(str);
    }

    private static Object a(Object obj, String str, Object[] objArr, Class[] clsArr) {
        if (obj == null) {
            return null;
        }
        Method declaredMethod;
        Object invoke;
        Class cls = obj.getClass();
        while (cls != Object.class) {
            try {
                declaredMethod = cls.getDeclaredMethod(str, clsArr);
                break;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e, "", new Object[0]);
            } catch (Throwable e2) {
                w.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e2, "", new Object[0]);
            }
        }
        declaredMethod = null;
        if (declaredMethod != null) {
            declaredMethod.setAccessible(true);
            try {
                invoke = declaredMethod.invoke(obj, objArr);
            } catch (Throwable e3) {
                w.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e3, "", new Object[0]);
                invoke = null;
            } catch (Throwable e32) {
                w.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e32, "", new Object[0]);
                invoke = null;
            } catch (Throwable e322) {
                w.printErrStackTrace("MicroMsg.SeeRoomMemberUI", e322, "", new Object[0]);
            }
            return invoke;
        }
        invoke = null;
        return invoke;
        cls = cls.getSuperclass();
    }
}
