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
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class f extends d {
    private final int OS;
    private final MMActivity fCi;
    private String isF;
    private com.tencent.mm.ui.friend.d.a whh;
    boolean whp = false;
    private a whq = new a(this) {
        final /* synthetic */ f whr;

        {
            this.whr = r1;
        }

        public final void f(int i, String str, int i2) {
            w.d("MicroMsg.QQFriendAdapterCaseB", "[cpan] postion:%d qq:%s status:%d", new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)});
            ad adVar = (ad) this.whr.getItem(i);
            if (adVar == null) {
                w.e("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend is null. qq:%s", new Object[]{str});
                return;
            }
            w.d("MicroMsg.QQFriendAdapterCaseB", "qq friend:%s", new Object[]{adVar.toString()});
            if (adVar.hCc == 1) {
                com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.whr.fCi, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
                    final /* synthetic */ AnonymousClass1 whs;

                    {
                        this.whs = r1;
                    }

                    public final void a(boolean z, boolean z2, String str, String str2) {
                        w.i("MicroMsg.QQFriendAdapterCaseB", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), str, str2});
                        long longValue = new o(o.aY(str2)).longValue();
                        ad af = af.Gd().af(longValue);
                        if (z && af != null) {
                            af.username = str;
                        }
                        if (af != null) {
                            af.hry = 2;
                            w.d("MicroMsg.QQFriendAdapterCaseB", "f :%s", new Object[]{af.toString()});
                            af.Gd().a(longValue, af);
                            this.whs.whr.OK();
                        } else {
                            w.w("MicroMsg.QQFriendAdapterCaseB", "cpan qq friend is null. qq:%s", new Object[]{str2});
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
                if (bg.mA(adVar.getUsername())) {
                    w.w("MicroMsg.QQFriendAdapterCaseB", "[cpan] qq friend username is null.");
                    return;
                }
                aVar.b(adVar.getUsername(), linkedList, true);
                adVar.hry = 1;
                af.Gd().a(adVar.hCb, adVar);
                this.whr.OK();
            }
        }
    };

    interface a {
        void f(int i, String str, int i2);
    }

    class b {
        String hSs;
        ImageView ioV;
        TextView ipa;
        TextView jiJ;
        ProgressBar oFf;
        TextView qHr;
        int status;
        int umb;
        TextView vuC;
        View vuw;
        final /* synthetic */ f whr;

        public b(final f fVar, View view) {
            this.whr = fVar;
            this.qHr = (TextView) view.findViewById(R.h.bRX);
            this.ioV = (ImageView) view.findViewById(R.h.bRW);
            this.jiJ = (TextView) view.findViewById(R.h.bRY);
            this.vuC = (TextView) view.findViewById(R.h.bSb);
            this.vuw = view.findViewById(R.h.bRV);
            this.ipa = (TextView) view.findViewById(R.h.bSa);
            this.oFf = (ProgressBar) view.findViewById(R.h.bRZ);
            this.vuw.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ b whu;

                public final void onClick(View view) {
                    if (this.whu.whr.whq != null) {
                        this.whu.whr.whq.f(this.whu.umb, this.whu.hSs, this.whu.status);
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

    public f(MMActivity mMActivity, int i) {
        super(mMActivity, new ad());
        this.fCi = mMActivity;
        this.OS = i;
        this.whp = mMActivity.getIntent().getBooleanExtra("qqgroup_sendmessage", false);
        ko(true);
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
            setCursor(af.Gd().v(this.OS, this.whp));
        } else {
            setCursor(af.Gd().b(this.OS, this.isF, this.whp));
        }
        if (!(this.whh == null || this.isF == null)) {
            this.whh.zA(getCursor().getCount());
        }
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        ad adVar = (ad) getItem(i);
        if (view == null) {
            view = View.inflate(this.fCi, R.i.ddC, null);
            b bVar2 = new b(this, view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.umb = i;
        bVar.hSs = adVar.hCb;
        bVar.status = adVar.hCc;
        bVar.jiJ.setText(h.b(this.fCi, adVar.getDisplayName(), bVar.jiJ.getTextSize()));
        bVar.vuC.setText(h.b(this.fCi, adVar.FP(), bVar.vuC.getTextSize()));
        if (this.whp) {
            Bitmap Q;
            if (o.aY(bVar.hSs) != 0) {
                Q = com.tencent.mm.x.b.Q(adVar.hCb);
            } else {
                Q = null;
            }
            if (Q == null) {
                bVar.ioV.setImageDrawable(com.tencent.mm.bg.a.a(this.fCi, R.k.bes));
            } else {
                bVar.ioV.setImageBitmap(Q);
            }
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar.ioV, adVar.getUsername());
        }
        if (!this.whp) {
            switch (adVar.hCc) {
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
                    bVar.oFf.setVisibility(4);
                    break;
                case 1:
                    bVar.ipa.setVisibility(4);
                    bVar.oFf.setVisibility(0);
                    break;
                default:
                    break;
            }
        }
        bVar.vuw.setVisibility(8);
        ad adVar2 = (ad) getItem(i - 1);
        int i2 = adVar2 == null ? -1 : adVar2.hrx;
        String str = "MicroMsg.QQFriendAdapterCaseB";
        String str2 = "qq friend pre:%s";
        Object[] objArr = new Object[1];
        objArr[0] = adVar2 != null ? adVar2.toString() : "";
        w.d(str, str2, objArr);
        str = "MicroMsg.QQFriendAdapterCaseB";
        str2 = "qq friend:%s";
        objArr = new Object[1];
        objArr[0] = adVar != null ? adVar.toString() : "";
        w.d(str, str2, objArr);
        if (i == 0) {
            CharSequence b = b(adVar);
            if (bg.mA(b)) {
                w.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[]{adVar.getUsername(), Integer.valueOf(i)});
                bVar.qHr.setVisibility(8);
            } else {
                bVar.qHr.setVisibility(0);
                bVar.qHr.setText(b);
                bVar.qHr.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        } else {
            boolean z;
            if (adVar.hrx != i2) {
                z = true;
            } else {
                z = false;
            }
            CharSequence b2 = b(adVar);
            if (bg.mA(b2) || !r1) {
                w.w("MicroMsg.QQFriendAdapterCaseB", "get display show head return null, user[%s] pos[%d]", new Object[]{adVar.getUsername(), Integer.valueOf(i)});
                bVar.qHr.setVisibility(8);
            } else {
                bVar.qHr.setVisibility(0);
                bVar.qHr.setText(b2);
                bVar.qHr.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        return view;
    }

    private static String b(ad adVar) {
        if (adVar.hrx == 123) {
            return "#";
        }
        return String.valueOf((char) adVar.hrx);
    }

    public final void ho(String str) {
    }
}
