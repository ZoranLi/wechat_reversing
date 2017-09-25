package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.e.a.nz;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.q;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SeeAccessVerifyInfoUI extends MMActivity {
    private long hER;
    private p irJ;
    private q ktr;
    private com.tencent.mm.u.c kvX;
    private b kvY;
    private String kvZ;
    private String kwa;
    private String kwb;
    private String kwc;
    private String kwd;
    private String kwe;
    private String kwf;
    private String kwg;
    private TextView kwh;
    private TextView kwi;
    private ImageView kwj;
    private TextView kwk;
    private TextView kwl;
    private GridView kwm;

    public class a {
        String fFa;
        final /* synthetic */ SeeAccessVerifyInfoUI kwn;
        String kwp;
        String username;

        a(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI, String str, String str2, String str3) {
            this.kwn = seeAccessVerifyInfoUI;
            this.username = str;
            this.fFa = str2;
            this.kwp = str3;
        }
    }

    public class b extends BaseAdapter {
        List<a> kaa = new ArrayList();
        final /* synthetic */ SeeAccessVerifyInfoUI kwn;
        private com.tencent.mm.ah.a.a.c kwq = null;
        Context mContext;

        public b(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI, Context context) {
            this.kwn = seeAccessVerifyInfoUI;
            this.mContext = context;
            ajA();
            com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
            aVar.hIL = true;
            aVar.hJh = true;
            aVar.hJa = R.k.bes;
            this.kwq = aVar.Hg();
        }

        private void ajA() {
            String[] strArr = null;
            if (bg.mA(this.kwn.kwa)) {
                w.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesUsernames null");
                return;
            }
            String[] split = this.kwn.kwa.split(",");
            if (bg.mA(this.kwn.kvZ)) {
                w.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesNicknames null");
                return;
            }
            String[] split2 = this.kwn.kvZ.split(",");
            if (bg.mA(this.kwn.kwb)) {
                w.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesHeadimgurls null");
            } else {
                strArr = this.kwn.kwb.split(",");
            }
            this.kaa.clear();
            int i = 0;
            while (i < split.length) {
                List list = this.kaa;
                SeeAccessVerifyInfoUI seeAccessVerifyInfoUI = this.kwn;
                String str = split[i];
                String str2 = (split2.length <= i || bg.mA(split2[i])) ? split[i] : split2[i];
                String str3 = (strArr == null || strArr.length <= i || bg.mA(strArr[i])) ? "" : strArr[i];
                list.add(new a(seeAccessVerifyInfoUI, str, str2, str3));
                i++;
            }
        }

        public final int getCount() {
            return this.kaa.size();
        }

        public final Object getItem(int i) {
            return this.kaa.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(final int i, View view, ViewGroup viewGroup) {
            c cd;
            if (view == null) {
                view = View.inflate(this.mContext, R.i.dmK, null);
                cd = this.kwn.cd(view);
            } else {
                c cVar = (c) view.getTag();
                cd = cVar == null ? this.kwn.cd(view) : cVar;
            }
            cd.ipv.setVisibility(0);
            cd.kws.setVisibility(0);
            n.GW().a(((a) this.kaa.get(i)).kwp, cd.ipv, this.kwq);
            cd.kws.setText(h.b(this.mContext, bg.mz(((a) this.kaa.get(i)).fFa), cd.kws.getTextSize()));
            view.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ b kwr;

                public final void onClick(View view) {
                    String tL;
                    String str = ((a) this.kwr.kaa.get(i)).fFa;
                    String str2 = null;
                    if (this.kwr.kwn.ktr != null) {
                        str2 = this.kwr.kwn.ktr.eK(((a) this.kwr.kaa.get(i)).username);
                    }
                    if (bg.mA(str2)) {
                        tL = com.tencent.mm.u.c.wR().Rc(bg.mz(((a) this.kwr.kaa.get(i)).username)).tL();
                    } else {
                        tL = str2;
                    }
                    SeeAccessVerifyInfoUI.a(this.kwr.kwn, ((a) this.kwr.kaa.get(i)).username, tL, str, true);
                }
            });
            return view;
        }
    }

    class c {
        public ImageView ipv;
        final /* synthetic */ SeeAccessVerifyInfoUI kwn;
        public TextView kws;

        c(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI) {
            this.kwn = seeAccessVerifyInfoUI;
        }
    }

    static /* synthetic */ void a(SeeAccessVerifyInfoUI seeAccessVerifyInfoUI, String str, String str2, String str3, boolean z) {
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
            w.i("MicroMsg.SeeAccessVerifyInfoUI", "mTicket:%s", new Object[]{seeAccessVerifyInfoUI.kwg});
            intent.putExtra("key_add_contact_verify_ticket", seeAccessVerifyInfoUI.kwg);
            if (seeAccessVerifyInfoUI.ktr != null) {
                intent.putExtra("Contact_RoomNickname", seeAccessVerifyInfoUI.ktr.eK(str));
            }
            intent.putExtra("Contact_Nick", str3);
            intent.putExtra("Contact_RoomMember", true);
            intent.putExtra("room_name", seeAccessVerifyInfoUI.kwe);
            ap.yY();
            af Rc = com.tencent.mm.u.c.wR().Rc(str);
            if (Rc != null && ((int) Rc.gTQ) > 0 && com.tencent.mm.j.a.ez(Rc.field_type)) {
                com.tencent.mm.sdk.b.b nzVar = new nz();
                nzVar.fVf.intent = intent;
                nzVar.fVf.username = str;
                com.tencent.mm.sdk.b.a.urY.m(nzVar);
            }
            if (Rc != null && Rc.bLe()) {
                g.oUh.A(10298, Rc.field_username + ",14");
            }
            if (z) {
                intent.putExtra("Contact_Scene", 34);
            } else {
                intent.putExtra("Contact_Scene", 14);
            }
            intent.putExtra("Is_RoomOwner", true);
            intent.putExtra("Contact_ChatRoomId", seeAccessVerifyInfoUI.kwe);
            com.tencent.mm.plugin.chatroom.a.imv.d(intent, seeAccessVerifyInfoUI);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.SeeAccessVerifyInfoUI", "[onCreate]");
        qP(getString(R.l.dBI));
        this.hER = getIntent().getLongExtra("msgLocalId", 0);
        this.kwc = getIntent().getStringExtra("invitertitle");
        this.kwd = getIntent().getStringExtra("inviterusername");
        this.kwe = getIntent().getStringExtra("chatroom");
        this.kwf = getIntent().getStringExtra("invitationreason");
        this.kwg = getIntent().getStringExtra("ticket");
        this.kwa = getIntent().getStringExtra("username");
        this.kvZ = getIntent().getStringExtra("nickname");
        this.kwb = getIntent().getStringExtra("headimgurl");
        this.kvX = ap.yY();
        this.ktr = com.tencent.mm.u.c.xa().fV(bg.mz(this.kwe));
        this.kvY = new b(this, this);
        KC();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SeeAccessVerifyInfoUI kwn;

            {
                this.kwn = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kwn.finish();
                return true;
            }
        });
    }

    protected void onResume() {
        w.i("MicroMsg.SeeAccessVerifyInfoUI", "[onResume]");
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dns;
    }

    protected final void KC() {
        CharSequence charSequence = null;
        this.kwh = (TextView) findViewById(R.h.bYp);
        this.kwi = (TextView) findViewById(R.h.bYo);
        this.kwk = (TextView) findViewById(R.h.czl);
        this.kwj = (ImageView) findViewById(R.h.czm);
        this.kwl = (TextView) findViewById(R.h.bmJ);
        this.kwm = (GridView) findViewById(R.h.bsy);
        this.kwm.setAdapter(this.kvY);
        this.kwj.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SeeAccessVerifyInfoUI kwn;

            {
                this.kwn = r1;
            }

            public final void onClick(View view) {
                af Rc = com.tencent.mm.u.c.wR().Rc(bg.mz(this.kwn.kwd));
                String str = Rc.field_nickname;
                String str2 = null;
                if (this.kwn.ktr != null) {
                    str2 = this.kwn.ktr.eK(this.kwn.kwd);
                }
                if (bg.mA(str2)) {
                    str2 = Rc.tL();
                }
                SeeAccessVerifyInfoUI.a(this.kwn, this.kwn.kwd, str2, str, false);
            }
        });
        this.kwm.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SeeAccessVerifyInfoUI kwn;

            {
                this.kwn = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.kwm.postDelayed(new Runnable(this) {
            final /* synthetic */ SeeAccessVerifyInfoUI kwn;

            {
                this.kwn = r1;
            }

            public final void run() {
                int height = (int) ((((float) this.kwn.kwk.getHeight()) + this.kwn.getResources().getDimension(R.f.aWD)) + this.kwn.getResources().getDimension(R.f.aXB));
                if (this.kwn.kvY.getCount() / 4 > 0) {
                    height *= (this.kwn.kvY.getCount() / 4) + 1;
                }
                this.kwn.kwm.setLayoutParams(new LayoutParams(this.kwn.kwm.getWidth(), height));
            }
        }, 100);
        if (this.kwj != null) {
            com.tencent.mm.pluginsdk.ui.a.b.a(this.kwj, bg.mz(this.kwd));
        }
        if (this.kwk != null) {
            TextView textView = this.kwk;
            String mz = bg.mz(this.kwd);
            TextView textView2 = this.kwk;
            if (textView2 != null) {
                af Rc = com.tencent.mm.u.c.wR().Rc(bg.mz(mz));
                if (Rc == null) {
                    w.w("MicroMsg.SeeAccessVerifyInfoUI", "ct == null");
                } else {
                    mz = !bg.mA(Rc.field_conRemark) ? Rc.field_conRemark : this.ktr != null ? this.ktr.eK(mz) : null;
                    if (bg.mA(mz)) {
                        mz = Rc.field_conRemark;
                    }
                    if (bg.mA(mz)) {
                        mz = Rc.tK();
                    }
                    charSequence = h.b(this, bg.mz(mz), textView2.getTextSize());
                }
            }
            textView.setText(charSequence);
        }
        if (this.kwh != null) {
            this.kwh.setText(h.a(this, bg.mz(this.kwc)));
        }
        if (!(this.kwi == null || bg.mA(this.kwf))) {
            this.kwi.setText(h.a(this, "\"" + bg.mz(this.kwf) + "\""));
        }
        if (this.kwl != null) {
            this.kwl.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SeeAccessVerifyInfoUI kwn;

                {
                    this.kwn = r1;
                }

                public final void onClick(View view) {
                    SeeAccessVerifyInfoUI seeAccessVerifyInfoUI = this.kwn;
                    Context context = this.kwn.uSU.uTo;
                    this.kwn.getString(R.l.dIO);
                    seeAccessVerifyInfoUI.irJ = com.tencent.mm.ui.base.g.a(context, this.kwn.getString(R.l.dBJ), false, null);
                    new com.tencent.mm.plugin.chatroom.d.b(this.kwn.kwd, this.kwn.kwe, this.kwn.kwg, new LinkedList(bg.f(this.kwn.kwa.split(",")))).BC().c(this.kwn).f(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.y.a.a<dk>>(this) {
                        final /* synthetic */ AnonymousClass5 kwo;

                        {
                            this.kwo = r1;
                        }

                        public final /* synthetic */ Object call(Object obj) {
                            com.tencent.mm.y.a.a aVar = (com.tencent.mm.y.a.a) obj;
                            if (this.kwo.kwn.irJ != null && this.kwo.kwn.irJ.isShowing()) {
                                this.kwo.kwn.irJ.dismiss();
                            }
                            com.tencent.mm.f.a dn = com.tencent.mm.f.a.dn(aVar.fPf);
                            if (dn != null) {
                                dn.a(this.kwo.kwn, null, null);
                            } else if (aVar.errType == 0 && aVar.errCode == 0) {
                                if (aVar.fGg.getType() == 774) {
                                    ap.yY();
                                    ce cA = com.tencent.mm.u.c.wT().cA(this.kwo.kwn.hER);
                                    cA.bMy();
                                    ap.yY();
                                    com.tencent.mm.u.c.wT().b(cA.field_msgSvrId, cA);
                                    this.kwo.kwn.kwl.setBackgroundResource(R.g.bdb);
                                    this.kwo.kwn.kwl.setTextColor(this.kwo.kwn.getResources().getColor(R.e.aUh));
                                    this.kwo.kwn.kwl.setText(this.kwo.kwn.getString(R.l.esk));
                                    this.kwo.kwn.kwl.setEnabled(false);
                                    g.oUh.a(219, 23, 1, true);
                                }
                            } else if (aVar.fGg.getType() == 774) {
                                w.i("MicroMsg.SeeAccessVerifyInfoUI", "scene type:%s errCode:%s, errType:%s, errMsg:%s", new Object[]{Integer.valueOf(774), Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType), bg.mz(aVar.fPf)});
                                com.tencent.mm.ui.base.g.b(this.kwo.kwn.uSU.uTo, this.kwo.kwn.getString(R.l.dBH), this.kwo.kwn.getString(R.l.dIO), true);
                            }
                            return wCE;
                        }
                    });
                }
            });
        }
        if (this.kwl != null) {
            ap.yY();
            if (com.tencent.mm.u.c.wT().cA(this.hER).bMz()) {
                this.kwl.setBackgroundResource(R.g.bdb);
                this.kwl.setTextColor(getResources().getColor(R.e.aUh));
                this.kwl.setText(getString(R.l.esk));
                this.kwl.setEnabled(false);
            }
        }
    }

    protected final c cd(View view) {
        c cVar = new c(this);
        cVar.ipv = (ImageView) view.findViewById(R.h.czm);
        cVar.kws = (TextView) view.findViewById(R.h.czl);
        return cVar;
    }
}
