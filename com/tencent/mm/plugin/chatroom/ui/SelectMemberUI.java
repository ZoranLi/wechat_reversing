package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
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
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.l;
import com.tencent.mm.plugin.chatroom.d.n;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class SelectMemberUI extends MMActivity implements e {
    private ListView Fg;
    private p iLz;
    private View jAt;
    private int jZM;
    private q ktr;
    private String kuC;
    private String kwu;
    private MMEditText kwy;
    private View kxa;
    SelectMemberScrollBar kxj;
    private b kxk;
    private boolean kxl;
    private boolean kxm;
    private String mTitle;

    public class a {
        public x jiL;
        final /* synthetic */ SelectMemberUI kxn;
        public int type = 1;

        public a(SelectMemberUI selectMemberUI, x xVar) {
            this.kxn = selectMemberUI;
            this.jiL = xVar;
        }
    }

    public class b extends BaseAdapter {
        List<a> fPq = new ArrayList();
        private q ktr;
        private String kuC;
        private com.tencent.mm.u.c kvX;
        public String kwE;
        String kwG = null;
        List<a> kwH = new ArrayList(0);
        final /* synthetic */ SelectMemberUI kxn;
        public final String kxq = new String(Character.toChars(91));
        volatile boolean kxr = false;
        HashMap<String, Integer> kxs = new HashMap();
        private Context mContext;

        static /* synthetic */ void b(b bVar) {
            if (bVar.fPq != null) {
                Object obj = null;
                int i = 0;
                for (a aVar : bVar.fPq) {
                    String mp;
                    if (aVar.jiL != null) {
                        mp = com.tencent.mm.platformtools.c.mp(bVar.c(aVar.jiL));
                        mp = bg.mA(mp) ? "" : mp.startsWith(bVar.kxq) ? "#" : mp.toUpperCase().substring(0, 1);
                        if (i == 0) {
                            bVar.kxs.put(mp, Integer.valueOf(i));
                        } else if (!(obj == null || mp.equals(obj))) {
                            bVar.kxs.put(mp, Integer.valueOf(i));
                        }
                    } else {
                        mp = null;
                    }
                    i++;
                    String str = mp;
                }
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return kP(i);
        }

        public b(SelectMemberUI selectMemberUI, Context context, q qVar, String str, String str2) {
            this.kxn = selectMemberUI;
            this.ktr = qVar;
            this.kuC = str;
            this.kwG = str2;
            this.mContext = context;
            this.kvX = ap.yY();
        }

        public final void tt(String str) {
            w.i("MicroMsg.SelectMemberAdapter", "[setMemberListBySearch]");
            List arrayList = new ArrayList();
            if (bg.mA(str)) {
                this.fPq = this.kwH;
                return;
            }
            for (a aVar : this.kwH) {
                if (!(aVar == null || aVar.jiL == null || aVar.type != 1)) {
                    af afVar = aVar.jiL;
                    if (afVar.field_conRemark != null && afVar.field_conRemark.contains(str)) {
                        arrayList.add(aVar);
                    } else if (!bg.mA(SeeRoomMemberUI.a(this.ktr, afVar.field_username)) && SeeRoomMemberUI.a(this.ktr, afVar.field_username).contains(str)) {
                        arrayList.add(aVar);
                    } else if (afVar.tK() != null && afVar.tK().contains(str)) {
                        arrayList.add(aVar);
                    } else if (afVar.pB() != null && afVar.pB().contains(str)) {
                        arrayList.add(aVar);
                    } else if (afVar.pA() != null && afVar.pA().contains(str)) {
                        arrayList.add(aVar);
                    } else if (afVar.field_username != null && afVar.field_username.contains(str)) {
                        arrayList.add(aVar);
                    } else if (!com.tencent.mm.j.a.ez(afVar.field_type)) {
                        ap.yY();
                        bb AI = com.tencent.mm.u.c.wS().AI(afVar.field_username);
                        if (!(AI == null || AI.field_conRemark == null || !AI.field_conRemark.contains(str))) {
                            arrayList.add(aVar);
                        }
                    }
                }
            }
            this.fPq = arrayList;
        }

        public final int getCount() {
            if (this.fPq == null || this.kxr) {
                return 0;
            }
            return this.fPq.size();
        }

        public final a kP(int i) {
            return (a) this.fPq.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null) {
                view = View.inflate(this.mContext, R.i.dnB, null);
                c cVar2 = new c();
                cVar2.kwV = (MaskLayout) view.findViewById(R.h.cCa);
                cVar2.jZz = (TextView) view.findViewById(R.h.cCc);
                WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
                cVar2.jZz.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
                cVar2.kwW = (TextView) view.findViewById(R.h.cCb);
                cVar2.kwW.setMaxWidth((windowManager.getDefaultDisplay().getWidth() * 2) / 3);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            x xVar = kP(i).jiL;
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) cVar.kwV.view, xVar.field_username);
            if (xVar.field_verifyFlag == 0) {
                cVar.kwV.bSH();
            } else if (com.tencent.mm.u.ag.a.hlU != null) {
                String eZ = com.tencent.mm.u.ag.a.hlU.eZ(xVar.field_verifyFlag);
                if (eZ != null) {
                    cVar.kwV.d(l.ik(eZ), com.tencent.mm.ui.base.MaskLayout.a.vnV);
                } else {
                    cVar.kwV.bSH();
                }
            } else {
                cVar.kwV.bSH();
            }
            CharSequence c = c(xVar);
            CharSequence charSequence = "";
            if (com.tencent.mm.j.a.ez(xVar.field_type)) {
                charSequence = xVar.gkK;
            }
            if (bg.mA(charSequence)) {
                cVar.kwW.setVisibility(8);
                cVar.kwW.setText("");
            } else {
                cVar.kwW.setVisibility(0);
                cVar.kwW.setText(h.b(this.mContext, charSequence, cVar.kwW.getTextSize()));
            }
            cVar.jZz.setText(h.b(this.mContext, c, cVar.jZz.getTextSize()));
            return view;
        }

        private String c(x xVar) {
            String a;
            if (bg.mA(xVar.field_conRemark)) {
                a = SelectMemberUI.a(this.ktr, xVar.field_username);
            } else {
                a = xVar.field_conRemark;
            }
            if (bg.mA(a)) {
                a = xVar.tK();
            }
            if (com.tencent.mm.j.a.ez(xVar.field_type)) {
                return a;
            }
            ap.yY();
            bb AI = com.tencent.mm.u.c.wS().AI(xVar.field_username);
            if (AI == null || bg.mA(AI.field_conRemark)) {
                return a;
            }
            return AI.field_conRemark;
        }
    }

    private static class c {
        public TextView jZz;
        public MaskLayout kwV;
        public TextView kwW;
    }

    static /* synthetic */ void a(SelectMemberUI selectMemberUI, int i) {
        a kP = selectMemberUI.kxk.kP(i);
        if (kP == null || kP.jiL == null) {
            w.e("MicroMsg.SelectMemberUI", "null == item || null == item.contact");
            return;
        }
        af afVar = kP.jiL;
        final String str = afVar.field_username;
        String a = !bg.mA(afVar.field_conRemark) ? afVar.field_conRemark : a(selectMemberUI.ktr, afVar.field_username);
        if (bg.mA(a)) {
            a = afVar.tK();
        }
        if (!com.tencent.mm.j.a.ez(afVar.field_type)) {
            ap.yY();
            bb AI = com.tencent.mm.u.c.wS().AI(afVar.field_username);
            if (!(AI == null || bg.mA(AI.field_conRemark))) {
                a = AI.field_conRemark;
            }
        }
        g.a(selectMemberUI, !selectMemberUI.kxl ? selectMemberUI.getString(R.l.eNn, new Object[]{a}) : selectMemberUI.getString(R.l.eMU, new Object[]{a}), "", new OnClickListener(selectMemberUI) {
            final /* synthetic */ SelectMemberUI kxn;

            public final void onClick(DialogInterface dialogInterface, int i) {
                ap.vd().a(new n(this.kxn.kuC, str), 0);
                SelectMemberUI selectMemberUI = this.kxn;
                Context context = this.kxn;
                this.kxn.getString(R.l.dIO);
                selectMemberUI.iLz = g.a(context, this.kxn.getString(R.l.eNo), false, null);
            }
        }, new OnClickListener(selectMemberUI) {
            final /* synthetic */ SelectMemberUI kxn;

            {
                this.kxn = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    static /* synthetic */ void a(SelectMemberUI selectMemberUI, String str) {
        selectMemberUI.aHf();
        Intent intent = new Intent(selectMemberUI, SelectMemberChattingRecordUI.class);
        intent.putExtra("RoomInfo_Id", selectMemberUI.kuC);
        intent.putExtra("room_member", str);
        intent.putExtra("title", selectMemberUI.getString(R.l.eQl));
        selectMemberUI.startActivity(intent);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.SelectMemberUI", "[onCreate]");
        this.kuC = getIntent().getStringExtra("RoomInfo_Id");
        w.i("MicroMsg.SelectMemberUI", "[getIntentParams] roomId:%s", new Object[]{this.kuC});
        ap.yY();
        this.ktr = com.tencent.mm.u.c.xa().fW(this.kuC);
        this.kwu = getIntent().getStringExtra("Block_list");
        this.jZM = getIntent().getIntExtra("frome_scene", 0);
        this.mTitle = getIntent().getStringExtra("title");
        this.kxl = getIntent().getBooleanExtra("quit_room", false);
        this.kxm = getIntent().getBooleanExtra("is_show_owner", true);
        KC();
        if (this.jZM == 2) {
            ap.vd().a(990, this);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.jZM == 2) {
            ap.vd().b(990, this);
        }
        if (this.iLz != null && this.iLz.isShowing()) {
            this.iLz.dismiss();
        }
    }

    protected final void KC() {
        qP(bg.mz(this.mTitle));
        this.Fg = (ListView) findViewById(R.h.cjB);
        this.kxa = findViewById(R.h.cBX);
        this.jAt = findViewById(R.h.cBY);
        this.kxk = new b(this, this, this.ktr, this.kuC, this.ktr.field_roomowner);
        this.Fg.setAdapter(this.kxk);
        this.kxj = (SelectMemberScrollBar) findViewById(R.h.cjD);
        this.kxj.setVisibility(0);
        this.kxj.vpW = new com.tencent.mm.ui.base.VerticalScrollBar.a(this) {
            final /* synthetic */ SelectMemberUI kxn;

            {
                this.kxn = r1;
            }

            public final void sd(String str) {
                if ("↑".equals(str)) {
                    this.kxn.Fg.setSelection(0);
                    return;
                }
                int intValue;
                b b = this.kxn.kxk;
                if (b.kxs.containsKey(str)) {
                    intValue = ((Integer) b.kxs.get(str)).intValue();
                } else {
                    intValue = -1;
                }
                if (intValue != -1) {
                    this.kxn.Fg.setSelection(intValue);
                }
            }
        };
        this.kwy = (MMEditText) findViewById(R.h.cBW);
        this.kwy.addTextChangedListener(new TextWatcher(this) {
            final /* synthetic */ SelectMemberUI kxn;
            private aj kxo = new aj(ap.vL().nJF.getLooper(), new com.tencent.mm.sdk.platformtools.aj.a(this) {
                final /* synthetic */ AnonymousClass2 kxp;

                {
                    this.kxp = r1;
                }

                public final boolean oQ() {
                    w.d("MicroMsg.SelectMemberUI", "searchEvent onTimerExpired");
                    b b = this.kxp.kxn.kxk;
                    String obj = this.kxp.kxn.kwy.getText().toString();
                    w.i("MicroMsg.SelectMemberAdapter", "search:%s isLoading:%s", new Object[]{bg.Qj(obj), Boolean.valueOf(b.kxr)});
                    if (!b.kxr) {
                        b.kwE = obj;
                        b.tt(obj);
                        com.tencent.mm.sdk.platformtools.af.v(new Runnable(b) {
                            final /* synthetic */ b kxt;

                            {
                                this.kxt = r1;
                            }

                            public final void run() {
                                this.kxt.notifyDataSetChanged();
                                if (this.kxt.fPq == null || this.kxt.fPq.size() != 0) {
                                    this.kxt.kxn.Fg.setVisibility(0);
                                    this.kxt.kxn.kxa.setVisibility(8);
                                    return;
                                }
                                this.kxt.kxn.Fg.setVisibility(8);
                                this.kxt.kxn.kxa.setVisibility(0);
                            }
                        });
                    }
                    return false;
                }
            }, false);

            {
                this.kxn = r5;
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                this.kxo.KH();
                this.kxo.v(500, 500);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        });
        this.Fg.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SelectMemberUI kxn;

            {
                this.kxn = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                switch (this.kxn.jZM) {
                    case 1:
                        SelectMemberUI.a(this.kxn, this.kxn.kxk.kP(i).jiL.field_username);
                        return;
                    case 2:
                        SelectMemberUI.a(this.kxn, i);
                        return;
                    default:
                        w.w("MicroMsg.SelectMemberUI", "mFromScene is default");
                        return;
                }
            }
        });
        b bVar = this.kxk;
        bVar.kxn.jAt.setVisibility(0);
        ap.vL().D(new Runnable(bVar) {
            final /* synthetic */ b kxt;

            {
                this.kxt = r1;
            }

            public final void run() {
                this.kxt.kxr = true;
                long currentTimeMillis = System.currentTimeMillis();
                b bVar = this.kxt;
                List DU = this.kxt.ktr.DU();
                if (DU != null) {
                    bVar.fPq.clear();
                    for (int i = 0; i < DU.size(); i++) {
                        af Rc = com.tencent.mm.u.c.wR().Rc((String) DU.get(i));
                        boolean equals = Rc.field_username.equals(bVar.kwG);
                        if (!equals || bVar.kxn.kxm) {
                            if (equals && bVar.kxn.kxm) {
                                bVar.fPq.add(0, new a(bVar.kxn, Rc));
                            } else {
                                bVar.fPq.add(new a(bVar.kxn, Rc));
                            }
                        }
                    }
                    Collections.sort(bVar.fPq, new Comparator<a>(bVar) {
                        final /* synthetic */ b kxt;

                        {
                            this.kxt = r1;
                        }

                        public final /* synthetic */ int compare(Object obj, Object obj2) {
                            return com.tencent.mm.platformtools.c.mp(this.kxt.c(((a) obj).jiL)).compareToIgnoreCase(com.tencent.mm.platformtools.c.mp(this.kxt.c(((a) obj2).jiL)));
                        }
                    });
                    bVar.kwH = bVar.fPq;
                }
                b.b(this.kxt);
                w.i("MicroMsg.SelectMemberAdapter", "[load data] cost:%sms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 kxu;

                    {
                        this.kxu = r1;
                    }

                    public final void run() {
                        this.kxu.kxt.kxr = false;
                        this.kxu.kxt.kxn.jAt.setVisibility(8);
                        this.kxu.kxt.notifyDataSetChanged();
                    }
                });
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SelectMemberUI kxn;

            {
                this.kxn = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kxn.setResult(0);
                this.kxn.finish();
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (this.iLz != null && this.iLz.isShowing()) {
            this.iLz.dismiss();
        }
        if (kVar.getType() != 990) {
            return;
        }
        if (i == 0 && i2 == 0) {
            w.i("MicroMsg.SelectMemberUI", "dz[onSceneEnd transfer successfully],owner_username:%s", new Object[]{((n) kVar).username});
            s.makeText(this, R.l.eNm, 1).show();
            Intent intent = new Intent();
            intent.putExtra("RoomInfo_Id", this.kuC);
            intent.putExtra("Chat_User", this.kuC);
            intent.putExtra("Is_Chatroom", true);
            intent.setFlags(67108864);
            d.b(this.uSU.uTo, "chatroom", ".ui.ChatroomInfoUI", intent);
            finish();
            return;
        }
        s.makeText(this, R.l.eNl, 1).show();
        w.w("MicroMsg.SelectMemberUI", "dz[onSceneEnd transfer failed: %d %d %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }

    protected static String a(q qVar, String str) {
        if (qVar == null) {
            return null;
        }
        return qVar.eK(str);
    }

    protected final int getLayoutId() {
        return R.i.dnC;
    }
}
