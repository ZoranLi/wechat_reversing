package com.tencent.mm.plugin.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateMusicPlayer;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.q;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.j;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.k;
import java.util.Map;

public class SelectMemberChattingRecordUI extends MMActivity {
    private static final f<Integer, c> hkd = new f(32);
    private p iLz;
    private int jZR = 0;
    private String kuC;
    private MMLoadMoreListView kwZ;
    private View kxa;
    private a kxb;
    private String kxc;
    private String mTitle;

    public class a extends k<au> {
        int hOI = -1;
        String kwJ;
        final /* synthetic */ SelectMemberChattingRecordUI kxd;
        String kxe;
        int kxf = -1;
        private q kxg;
        Context mContext;

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (au) obj;
            if (obj == null) {
                obj = new au();
            }
            obj.b(cursor);
            return obj;
        }

        public a(SelectMemberChattingRecordUI selectMemberChattingRecordUI, Context context, String str, String str2, int i) {
            this.kxd = selectMemberChattingRecordUI;
            super(context, new au());
            this.mContext = context;
            this.hOI = i;
            this.kwJ = str;
            this.kxe = str2;
            ap.yY();
            this.kxg = com.tencent.mm.u.c.xa().fW(selectMemberChattingRecordUI.kuC);
        }

        public final void OK() {
            if (this.kxf < 0 || this.kxf > this.hOI) {
                this.kxf = this.hOI - 16;
            }
            if (!bg.mA(this.kxd.kxc) && m.eH(this.kxd.kxc)) {
                ap.yY();
                setCursor(com.tencent.mm.u.c.wT().bm(this.kwJ, this.hOI - this.kxf));
            } else if (!m.eH(this.kxd.kxc)) {
                ap.yY();
                setCursor(com.tencent.mm.u.c.wT().B(this.kwJ, this.kxe, this.hOI - this.kxf));
            }
        }

        protected final void OL() {
            OK();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = LayoutInflater.from(this.context).inflate(R.i.dir, null, false);
                bVar = new b();
                bVar.ipv = (ImageView) view.findViewById(R.h.bqM);
                bVar.jWd = (TextView) view.findViewById(R.h.cof);
                bVar.kxh = (TextView) view.findViewById(R.h.clB);
                bVar.kxi = (TextView) view.findViewById(R.h.cKN);
                view.setTag(bVar);
            }
            au auVar = (au) getItem(i);
            bVar = (b) view.getTag();
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar.ipv, this.kxe);
            String str = this.kxe;
            ap.yY();
            af Rc = com.tencent.mm.u.c.wR().Rc(str);
            CharSequence a = !bg.mA(Rc.field_conRemark) ? Rc.field_conRemark : SelectMemberChattingRecordUI.a(this.kxg, Rc.field_username);
            if (bg.mA(a)) {
                a = Rc.tK();
            }
            if (!com.tencent.mm.j.a.ez(Rc.field_type)) {
                ap.yY();
                bb AI = com.tencent.mm.u.c.wS().AI(Rc.field_username);
                if (!(AI == null || bg.mA(AI.field_conRemark))) {
                    a = AI.field_conRemark;
                }
            }
            a(a, bVar.jWd);
            a(SelectMemberChattingRecordUI.a(ab.getContext(), auVar.field_type, auVar.field_content, this.kxe, auVar.field_isSend).trim(), bVar.kxh);
            a(o.c(this.kxd, auVar.field_createTime, true), bVar.kxi);
            return view;
        }

        private static boolean a(CharSequence charSequence, TextView textView) {
            if (charSequence == null || charSequence.length() == 0) {
                textView.setVisibility(8);
                return false;
            }
            textView.setText(h.a(textView.getContext(), charSequence));
            textView.setVisibility(0);
            return true;
        }
    }

    private static class b {
        public ImageView ipv;
        public TextView jWd;
        public TextView kxh;
        public TextView kxi;
    }

    static /* synthetic */ void a(SelectMemberChattingRecordUI selectMemberChattingRecordUI, long j) {
        w.i("MicroMsg.SelectMemberChattingRecordUI", "[goToChattingUI] msgLocalId:%s", new Object[]{Long.valueOf(j)});
        com.tencent.mm.plugin.chatroom.a.imv.e(new Intent().putExtra("Chat_User", selectMemberChattingRecordUI.kuC).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", j), selectMemberChattingRecordUI);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.i("MicroMsg.SelectMemberChattingRecordUI", "[onCreate]");
        this.kuC = getIntent().getStringExtra("RoomInfo_Id");
        this.kxc = getIntent().getStringExtra("room_member");
        w.i("MicroMsg.SelectMemberChattingRecordUI", "roomId:%s", new Object[]{this.kuC});
        this.mTitle = getIntent().getStringExtra("title");
        if (!bg.mA(this.kxc) && m.eH(this.kxc)) {
            ap.yY();
            this.jZR = com.tencent.mm.u.c.wT().AG(this.kuC);
        } else if (!m.eH(this.kxc)) {
            ap.yY();
            this.jZR = com.tencent.mm.u.c.wT().cP(this.kuC, this.kxc);
        }
        KC();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.iLz != null && this.iLz.isShowing()) {
            this.iLz.dismiss();
        }
    }

    protected final void KC() {
        super.KC();
        qP(bg.mz(this.mTitle));
        this.kwZ = (MMLoadMoreListView) findViewById(R.h.cjB);
        this.kwZ.bSh();
        this.kxb = new a(this, this, this.kuC, this.kxc, this.jZR);
        this.kwZ.setAdapter(this.kxb);
        this.kxa = findViewById(R.h.cBX);
        if ((this.jZR == 0 ? 1 : 0) != 0) {
            this.kxa.setVisibility(0);
            this.kwZ.setVisibility(8);
        }
        this.kwZ.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SelectMemberChattingRecordUI kxd;

            {
                this.kxd = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                au auVar = (au) this.kxd.kxb.getItem(i);
                if (auVar != null) {
                    SelectMemberChattingRecordUI.a(this.kxd, auVar.field_msgId);
                }
            }
        });
        this.kwZ.vkV = new com.tencent.mm.ui.base.MMLoadMoreListView.a(this) {
            final /* synthetic */ SelectMemberChattingRecordUI kxd;

            {
                this.kxd = r1;
            }

            public final void ajC() {
                if (this.kxd.kxb != null) {
                    a a = this.kxd.kxb;
                    a.kxf -= 16;
                    if (!bg.mA(a.kxd.kxc) && m.eH(a.kxd.kxc)) {
                        ap.yY();
                        a.setCursor(com.tencent.mm.u.c.wT().bm(a.kwJ, a.hOI - a.kxf));
                    } else if (!m.eH(a.kxd.kxc)) {
                        ap.yY();
                        a.setCursor(com.tencent.mm.u.c.wT().B(a.kwJ, a.kxe, a.hOI - a.kxf));
                    }
                    this.kxd.kxb.notifyDataSetChanged();
                }
            }
        };
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SelectMemberChattingRecordUI kxd;

            {
                this.kxd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kxd.setResult(0);
                this.kxd.finish();
                return true;
            }
        });
    }

    protected static String a(q qVar, String str) {
        if (qVar == null) {
            return null;
        }
        return qVar.eK(str);
    }

    protected final int getLayoutId() {
        return R.i.dnA;
    }

    public static String a(Context context, int i, String str, String str2, int i2) {
        String str3 = "";
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(str);
        switch (i) {
            case -1879048186:
                return context.getString(R.l.eIM, new Object[]{ek.title});
            case -1879048185:
            case -1879048183:
            case -1879048176:
                return context.getString(R.l.eIC, new Object[]{ek.title});
            case 1:
                return str.substring(str.indexOf(":\n") + 1);
            case 3:
            case 23:
            case 33:
                return context.getString(R.l.dIi);
            case 34:
                n nVar = new n(str);
                return context.getString(R.l.eIP, new Object[]{Integer.valueOf((int) com.tencent.mm.modelvoice.q.aw(nVar.time))});
            case JsApiGetLocation.CTRL_INDEX /*37*/:
                if (str == null || str.length() <= 0) {
                    return str3;
                }
                d RI = d.RI(str);
                if (RI.rUK == null || RI.rUK.length() <= 0) {
                    return str3;
                }
                switch (RI.scene) {
                    case 18:
                        return context.getString(R.l.elP, new Object[]{RI.getDisplayName()});
                    case 22:
                    case 23:
                    case 24:
                    case 26:
                    case 27:
                    case 28:
                    case JsApiChooseImage.CTRL_INDEX /*29*/:
                        return context.getString(R.l.elZ, new Object[]{RI.getDisplayName()});
                    case 25:
                        return context.getString(R.l.eli, new Object[]{RI.getDisplayName()});
                    default:
                        return context.getString(R.l.emf, new Object[]{RI.getDisplayName()});
                }
            case 42:
                if (bg.mz(str).length() <= 0) {
                    return str3;
                }
                CharSequence gi = ay.gi(str);
                if (!TextUtils.isEmpty(gi)) {
                    CharSequence charSequence = gi;
                }
                ap.yY();
                com.tencent.mm.storage.au.a Av = com.tencent.mm.u.c.wT().Av(str);
                ap.yY();
                str3 = com.tencent.mm.u.c.wR().Rc(str2).tL();
                if (com.tencent.mm.u.o.dH(str3)) {
                    str3 = j.s(j.eD(str3));
                }
                if (i2 == 1) {
                    return context.getString(R.l.elj, new Object[]{str3, Av.getDisplayName()});
                }
                return context.getString(R.l.elk, new Object[]{str3, Av.getDisplayName()});
            case 43:
            case 62:
                return context.getString(62 == i ? R.l.dIH : R.l.dIX);
            case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                return context.getString(R.l.dGL);
            case 48:
                ap.yY();
                com.tencent.mm.storage.au.b Aw = com.tencent.mm.u.c.wT().Aw(str);
                return context.getString(R.l.eIH, new Object[]{Aw.label});
            case 49:
                if (ek == null) {
                    w.e("MicroMsg.SelectMemberChattingRecordUI", "decode msg content failed");
                    return "";
                }
                switch (ek.type) {
                    case 2:
                        return context.getString(R.l.dIi);
                    case 3:
                        return context.getString(R.l.eII, new Object[]{ek.title});
                    case 4:
                        return context.getString(R.l.eIO, new Object[]{ek.title});
                    case 5:
                        return context.getString(R.l.eIN, new Object[]{ek.getTitle()});
                    case 6:
                        return context.getString(R.l.eIG, new Object[]{ek.title});
                    case 7:
                        return str3;
                    case 8:
                        return context.getString(R.l.dGM);
                    case 15:
                    case 26:
                    case 27:
                        return context.getString(R.l.dGL);
                    case 17:
                        return context.getString(R.l.eIH, new Object[]{ek.title});
                    case 19:
                        return context.getString(R.l.eIK, new Object[]{ek.title});
                    case 24:
                        c cVar;
                        int i3 = R.l.eIJ;
                        Object[] objArr = new Object[1];
                        String str4 = ek.hhQ;
                        if (bg.mA(str4)) {
                            w.e("MicroMsg.SelectMemberChattingRecordUI", "xml is null");
                            cVar = null;
                        } else {
                            int hashCode = str4.hashCode();
                            cVar = (c) hkd.get(Integer.valueOf(hashCode));
                            if (cVar != null) {
                                w.d("MicroMsg.SelectMemberChattingRecordUI", "get record msg data from cache");
                            } else {
                                Map q = str4.trim().startsWith("<recordinfo>") ? bh.q(str4, "recordinfo") : bh.q("<recordinfo>" + str4 + "</recordinfo>", "recordinfo");
                                if (q == null) {
                                    w.e("MicroMsg.SelectMemberChattingRecordUI", "values is null: %s", new Object[]{str4});
                                    cVar = null;
                                } else {
                                    c cVar2 = new c();
                                    cVar2.title = (String) q.get(".recordinfo.title");
                                    cVar2.desc = (String) q.get(".recordinfo.desc");
                                    cVar2.tbg = (String) q.get(".recordinfo.favusername");
                                    hkd.put(Integer.valueOf(hashCode), cVar2);
                                    cVar = cVar2;
                                }
                            }
                        }
                        objArr[0] = cVar.desc;
                        return context.getString(i3, objArr);
                    case 25:
                        return context.getString(R.l.dGD);
                    default:
                        return "";
                }
            case 369098801:
            case 452984881:
                return context.getString(R.l.eIE, new Object[]{ek.title});
            case 419430449:
                str3 = context.getString(R.l.eIL);
                if (ek == null) {
                    return str3;
                }
                int i4 = i2 == 1 ? 1 : 0;
                switch (ek.his) {
                    case 1:
                        if (i4 != 0) {
                            return context.getString(R.l.dJh);
                        }
                        return context.getString(R.l.dJk);
                    case 3:
                        if (i4 != 0) {
                            return context.getString(R.l.dJi);
                        }
                        return context.getString(R.l.dJf);
                    case 4:
                        if (i4 != 0) {
                            return context.getString(R.l.dJj);
                        }
                        return context.getString(R.l.dJg);
                    default:
                        return bg.mz(ek.title);
                }
            case 436207665:
            case 469762097:
                if (ek == null) {
                    w.e("MicroMsg.SelectMemberChattingRecordUI", "decode msg content failed");
                    return "";
                } else if (i2 == 1) {
                    return context.getString(R.l.eID, new Object[]{ek.hiT, ek.hiQ});
                } else {
                    return context.getString(R.l.eID, new Object[]{ek.hiT, ek.hiP});
                }
            case 503316529:
                if (ek == null) {
                    w.e("MicroMsg.SelectMemberChattingRecordUI", "decode msg content failed");
                    return "";
                } else if (i2 == 1) {
                    return context.getString(R.l.eID, new Object[]{ek.hiT, ek.hjh});
                } else {
                    return context.getString(R.l.eID, new Object[]{ek.hiT, ek.hjg});
                }
            case 520093745:
                return context.getString(R.l.eIE, new Object[]{""});
            default:
                return str3;
        }
    }
}
