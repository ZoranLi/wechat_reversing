package com.tencent.mm.ui.friend;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.modelfriend.ad;
import com.tencent.mm.modelfriend.ae;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bm;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class e extends d {
    private final int OS;
    private final MMActivity fCi;
    private String isF;
    private final a whf;
    private final c whg;
    private com.tencent.mm.ui.friend.d.a whh;
    boolean whi = false;
    private a whj = new a(this) {
        final /* synthetic */ e whk;

        {
            this.whk = r1;
        }

        public final void f(int i, String str, int i2) {
            w.d("MicroMsg.QQFriendAdapter", "[cpan] postion:%d qq:%s status:%d", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)});
            ad adVar = (ad) this.whk.getItem(i);
            if (adVar == null) {
                w.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend is null. qq:%s", new Object[]{str});
            } else if (bg.mA(adVar.getUsername())) {
                w.e("MicroMsg.QQFriendAdapter", "[cpan] qq friend username is null. qq:%s", new Object[]{str});
            } else {
                w.d("MicroMsg.QQFriendAdapter", "qq friend:%s", new Object[]{adVar.toString()});
                if (adVar.hCc == 0) {
                    int[] iArr = new int[]{o.aY(adVar.hCb)};
                    g gVar = new g(this.whk.fCi, new com.tencent.mm.ui.friend.g.a(this) {
                        final /* synthetic */ AnonymousClass1 whl;

                        {
                            this.whl = r1;
                        }

                        public final void k(boolean z, String str) {
                            ad af = af.Gd().af((long) o.aY(str));
                            if (af != null) {
                                af.hry = 2;
                                w.d("MicroMsg.QQFriendAdapter", "qq friend onSendInviteEmail:%s", new Object[]{af.toString()});
                                af.Gd().a(af.hCb, af);
                                this.whl.whk.OK();
                                return;
                            }
                            w.w("MicroMsg.QQFriendAdapter", "cpan qq friedn is null. qq:%s", new Object[]{af});
                        }
                    }, (byte) 0);
                    gVar.r(iArr);
                    gVar.sLW = adVar.hCb;
                    adVar.hry = 1;
                    af.Gd().a(adVar.hCb, adVar);
                    this.whk.OK();
                } else if (adVar.hCc == 1) {
                    com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.whk.fCi, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
                        final /* synthetic */ AnonymousClass1 whl;

                        {
                            this.whl = r1;
                        }

                        public final void a(boolean z, boolean z2, String str, String str2) {
                            w.i("MicroMsg.QQFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2});
                            long longValue = new o(o.aY(str2)).longValue();
                            ad af = af.Gd().af(longValue);
                            if (af != null && z) {
                                af.username = str;
                            }
                            if (af != null) {
                                af.hry = 2;
                                w.d("MicroMsg.QQFriendAdapter", "f :%s", new Object[]{af.toString()});
                                af.Gd().a(longValue, af);
                                this.whl.whk.OK();
                            } else {
                                w.w("MicroMsg.QQFriendAdapter", "cpan qq friend is null. qq:%s", new Object[]{str2});
                            }
                            if (z && af != null) {
                                d.Ud(str);
                            }
                        }
                    });
                    aVar.sLW = adVar.hCb;
                    aVar.sLV = false;
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(Integer.valueOf(12));
                    aVar.b(adVar.getUsername(), linkedList, true);
                    adVar.hry = 1;
                    af.Gd().a(adVar.hCb, adVar);
                    this.whk.OK();
                }
            }
        }
    };

    interface a {
        void f(int i, String str, int i2);
    }

    class b {
        TextView hBj;
        ImageView ioV;
        TextView ipa;
        int status;
        int umb;
        View vuw;
        ProgressBar vux;
        final /* synthetic */ e whk;
        String whm;

        public b(final e eVar, View view) {
            this.whk = eVar;
            this.ioV = (ImageView) view.findViewById(R.h.bGj);
            this.hBj = (TextView) view.findViewById(R.h.ctJ);
            this.vuw = view.findViewById(R.h.ctD);
            this.ipa = (TextView) view.findViewById(R.h.ctL);
            this.vux = (ProgressBar) view.findViewById(R.h.ctK);
            this.vuw.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ b who;

                public final void onClick(View view) {
                    if (this.who.whk.whj != null) {
                        this.who.whk.whj.f(this.who.umb, this.who.whm, this.who.status);
                    }
                }
            });
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (ad) obj;
        if (obj == null) {
            obj = new ad();
        }
        obj.b(cursor);
        return obj;
    }

    public e(MMActivity mMActivity, int i) {
        super(mMActivity, new ad());
        this.fCi = mMActivity;
        this.OS = i;
        this.whi = mMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
        this.whf = new a(mMActivity, new com.tencent.mm.ui.friend.a.a(this) {
            final /* synthetic */ e whk;

            {
                this.whk = r1;
            }

            public final void Uc(String str) {
                ae Gd = af.Gd();
                ad jk = Gd.jk(str);
                if (jk == null) {
                    w.w("MicroMsg.QQFriendAdapter", "[cpan] dealSucc failed. qqlist is null. username is :%s", new Object[]{str});
                    return;
                }
                jk.hCc = 2;
                Gd.a(jk.hCb, jk);
                this.whk.notifyDataSetChanged();
                ap.yY();
                com.tencent.mm.e.b.af Rc = c.wR().Rc(str);
                if (Rc == null) {
                    ad jk2 = af.Gd().jk(str);
                    if (jk2 != null) {
                        jk2.FW();
                        w.d("MicroMsg.QQFriendAdapter", "user " + str + " qq " + jk2.hCb);
                        af.Gd().a(jk2.hCb, jk2);
                    }
                } else if (!((Rc.field_conRemark != null && !Rc.field_conRemark.equals("")) || jk == null || jk.FT() == null || jk.FT().equals(""))) {
                    com.tencent.mm.u.o.b(Rc, jk.FT());
                }
                bm.zN().c(26, new Object[0]);
            }

            public final void ba(String str, boolean z) {
                if (z) {
                    ad jk = af.Gd().jk(str);
                    if (jk != null) {
                        jk.FW();
                        w.d("MicroMsg.QQFriendAdapter", "user " + str + " qq " + jk.hCb);
                        af.Gd().a(jk.hCb, jk);
                    } else {
                        w.w("MicroMsg.QQFriendAdapter", "[cpan] dealFail failed. qqlist is null. username is :%s", new Object[]{str});
                    }
                }
                this.whk.notifyDataSetChanged();
            }
        });
        this.whg = new c(mMActivity, new com.tencent.mm.ui.friend.c.a(this) {
            final /* synthetic */ e whk;

            {
                this.whk = r1;
            }

            public final void lB(boolean z) {
                if (z) {
                    this.whk.notifyDataSetChanged();
                }
            }
        });
    }

    public final void a(com.tencent.mm.ui.friend.d.a aVar) {
        this.whh = aVar;
    }

    public final void yD(String str) {
        this.isF = bg.my(str.trim());
        aEW();
        OK();
    }

    protected final void OL() {
        OK();
    }

    public final void OK() {
        aEW();
        if (bg.mA(this.isF)) {
            setCursor(af.Gd().v(this.OS, this.whi));
        } else {
            setCursor(af.Gd().b(this.OS, this.isF, this.whi));
        }
        if (!(this.whh == null || this.isF == null)) {
            this.whh.zA(getCursor().getCount());
        }
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        Bitmap Q;
        ad adVar = (ad) getItem(i);
        if (view == null) {
            view = View.inflate(this.fCi, R.i.dly, null);
            bVar = new b(this, view);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.umb = i;
        bVar.whm = adVar.hCb;
        bVar.status = adVar.hCc;
        bVar.hBj.setText(h.b(this.fCi, adVar.getDisplayName(), bVar.hBj.getTextSize()));
        if (o.aY(adVar.hCb) != 0) {
            Q = com.tencent.mm.x.b.Q(adVar.hCb);
        } else {
            Q = null;
        }
        if (Q == null) {
            bVar.ioV.setImageDrawable(com.tencent.mm.bg.a.a(this.fCi, R.k.bes));
        } else {
            bVar.ioV.setImageBitmap(Q);
        }
        if (!this.whi) {
            switch (adVar.hCc) {
                case 0:
                    if (adVar.hry != 2) {
                        bVar.vuw.setClickable(true);
                        bVar.vuw.setBackgroundResource(R.g.bda);
                        bVar.ipa.setText(R.l.emS);
                        bVar.ipa.setTextColor(this.fCi.getResources().getColor(R.e.white));
                        break;
                    }
                    bVar.vuw.setClickable(false);
                    bVar.vuw.setBackgroundDrawable(null);
                    bVar.ipa.setText(R.l.emT);
                    bVar.ipa.setTextColor(this.fCi.getResources().getColor(R.e.aUz));
                    break;
                case 1:
                case 2:
                    ap.yY();
                    if (!c.wR().QY(adVar.getUsername()) && !m.xL().equals(adVar.getUsername())) {
                        if (adVar.hry != 2) {
                            bVar.vuw.setClickable(true);
                            bVar.vuw.setBackgroundResource(R.g.bda);
                            bVar.ipa.setText(R.l.emQ);
                            bVar.ipa.setTextColor(this.fCi.getResources().getColor(R.e.white));
                            break;
                        }
                        bVar.vuw.setClickable(false);
                        bVar.vuw.setBackgroundDrawable(null);
                        bVar.ipa.setText(R.l.emV);
                        bVar.ipa.setTextColor(this.fCi.getResources().getColor(R.e.aUz));
                        break;
                    }
                    bVar.vuw.setClickable(false);
                    bVar.vuw.setBackgroundDrawable(null);
                    bVar.ipa.setText(R.l.emR);
                    bVar.ipa.setTextColor(this.fCi.getResources().getColor(R.e.aUz));
                    break;
                    break;
            }
            switch (adVar.hry) {
                case 0:
                case 2:
                    bVar.ipa.setVisibility(0);
                    bVar.vux.setVisibility(4);
                    break;
                case 1:
                    bVar.ipa.setVisibility(4);
                    bVar.vux.setVisibility(0);
                    break;
                default:
                    break;
            }
        }
        bVar.vuw.setVisibility(8);
        return view;
    }

    public final void ho(String str) {
        notifyDataSetChanged();
    }
}
