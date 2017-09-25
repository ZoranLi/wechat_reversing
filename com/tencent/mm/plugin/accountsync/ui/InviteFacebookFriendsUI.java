package com.tencent.mm.plugin.accountsync.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.h;
import com.tencent.mm.modelfriend.i;
import com.tencent.mm.modelfriend.q;
import com.tencent.mm.modelfriend.v;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.account.FacebookAuthUI;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.g.a.d;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.tools.p;
import com.tencent.mm.x.b;
import com.tencent.mm.y.e;
import java.util.ArrayList;
import java.util.List;

public class InviteFacebookFriendsUI extends MMActivity implements e {
    private ListView iss;
    a ist;
    private View isu;
    private ProgressDialog isv = null;
    String isw;
    private final int isx = 5;

    public static class a extends k<h> {
        private int[] hBc;
        String isF;
        private boolean[] isG;

        public static class a {
            TextView hBj;
            ImageView ioV;
            TextView isH;
            CheckBox isI;
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (h) obj;
            if (obj == null) {
                obj = new h();
            }
            obj.b(cursor);
            return obj;
        }

        public a(Context context, com.tencent.mm.ui.k.a aVar) {
            super(context, new h());
            this.uSN = aVar;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            h hVar = (h) getItem(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(this.context, R.i.dcd, null);
                aVar2.ioV = (ImageView) view.findViewById(R.h.bGj);
                aVar2.hBj = (TextView) view.findViewById(R.h.ctJ);
                aVar2.isH = (TextView) view.findViewById(R.h.bYi);
                aVar2.isI = (CheckBox) view.findViewById(R.h.bYt);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.hBj.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.context, hVar.Fd(), aVar.hBj.getTextSize()));
            Bitmap gZ = b.gZ(hVar.gkt);
            if (gZ == null) {
                aVar.ioV.setImageDrawable(com.tencent.mm.bg.a.a(this.context, R.k.bes));
            } else {
                aVar.ioV.setImageBitmap(gZ);
            }
            aVar.isI.setChecked(this.isG[i]);
            if (af.Gc().jj(Long.toString(hVar.gkt))) {
                aVar.isH.setVisibility(0);
            } else {
                aVar.isH.setVisibility(8);
            }
            return view;
        }

        public final long[] OJ() {
            int i;
            int i2 = 0;
            int i3 = 0;
            for (boolean z : this.isG) {
                if (z) {
                    i3++;
                }
            }
            long[] jArr = new long[i3];
            int i4 = 0;
            while (i4 < getCount()) {
                if (this.isG[i4]) {
                    i = i2 + 1;
                    jArr[i2] = ((h) getItem(i4)).gkt;
                    i3 = i;
                } else {
                    i3 = i2;
                }
                i4++;
                i2 = i3;
            }
            return jArr;
        }

        public final void hk(int i) {
            if (i >= 0 && i < this.isG.length) {
                this.isG[i] = !this.isG[i];
                super.notifyDataSetChanged();
            }
        }

        public final void OK() {
            i FZ = af.FZ();
            String str = this.isF;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" where facebookfriend.status = 102 ");
            if (str != null && str.length() > 0) {
                stringBuilder.append(" and ( ");
                stringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
                stringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
                stringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
            }
            setCursor(FZ.hnH.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + stringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null, 0));
            this.hBc = new int[getCount()];
            this.isG = new boolean[getCount()];
            super.notifyDataSetChanged();
        }

        protected final void OL() {
            OK();
        }
    }

    static /* synthetic */ void c(InviteFacebookFriendsUI inviteFacebookFriendsUI) {
        w.e("MicroMsg.InviteFacebookFriendsUI", "dealWithRefreshTokenFail");
        inviteFacebookFriendsUI.av(inviteFacebookFriendsUI.getString(R.l.dIO), inviteFacebookFriendsUI.getString(R.l.ehf));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.ehl);
        ap.vd().a(32, (e) this);
        KC();
    }

    protected void onDestroy() {
        ap.vd().b(32, (e) this);
        this.ist.aEW();
        super.onDestroy();
    }

    protected final void KC() {
        this.iss = (ListView) findViewById(R.h.ckw);
        final TextView textView = (TextView) findViewById(R.h.bLU);
        textView.setText(R.l.ehe);
        p pVar = new p(true, true);
        pVar.woe = new p.b(this) {
            final /* synthetic */ InviteFacebookFriendsUI isy;

            {
                this.isy = r1;
            }

            public final boolean mQ(String str) {
                return false;
            }

            public final void mR(String str) {
                this.isy.isw = bg.my(str);
                InviteFacebookFriendsUI inviteFacebookFriendsUI = this.isy;
                if (inviteFacebookFriendsUI.ist != null) {
                    a aVar = inviteFacebookFriendsUI.ist;
                    aVar.isF = bg.my(inviteFacebookFriendsUI.isw.trim());
                    aVar.aEW();
                    aVar.OK();
                }
            }

            public final void OD() {
            }

            public final void OE() {
            }

            public final void OF() {
            }

            public final void OG() {
            }
        };
        a(pVar);
        this.ist = new a(this, new com.tencent.mm.ui.k.a(this) {
            final /* synthetic */ InviteFacebookFriendsUI isy;

            public final void OH() {
                if (!m.ym()) {
                    return;
                }
                if (this.isy.ist.getCount() == 0) {
                    textView.setVisibility(0);
                } else {
                    textView.setVisibility(8);
                }
            }

            public final void OI() {
            }
        });
        this.iss.setAdapter(this.ist);
        this.isu = findViewById(R.h.ckx);
        this.iss.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ InviteFacebookFriendsUI isy;

            {
                this.isy = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.isy.ist.OJ().length >= 50) {
                    g.h(this.isy, R.l.ehk, R.l.dIO);
                    return;
                }
                this.isy.ist.hk(i - this.isy.iss.getHeaderViewsCount());
                if (this.isy.ist.OJ().length > 0) {
                    this.isy.ks(true);
                } else {
                    this.isy.ks(false);
                }
            }
        });
        w.d("MicroMsg.InviteFacebookFriendsUI", "isBindForFacebookApp:" + m.ym());
        if (m.ym()) {
            this.iss.setVisibility(0);
            this.isu.setVisibility(8);
            ap.yY();
            long c = bg.c((Long) c.vr().get(65831, null));
            ap.yY();
            String mz = bg.mz((String) c.vr().get(65830, null));
            if (bg.aA(c) > 86400000 && mz.length() > 0) {
                com.tencent.mm.ui.g.a.c cVar = new com.tencent.mm.ui.g.a.c("290293790992170");
                cVar.TX(mz);
                new com.tencent.mm.ui.account.h(cVar, new com.tencent.mm.v.a(this) {
                    final /* synthetic */ InviteFacebookFriendsUI isy;

                    {
                        this.isy = r1;
                    }

                    public final void m(Bundle bundle) {
                        super.m(bundle);
                    }

                    public final void onError(int i, String str) {
                        super.onError(i, str);
                        if (i == 3) {
                            InviteFacebookFriendsUI.c(this.isy);
                        }
                    }
                }).bQS();
            }
            final com.tencent.mm.y.k vVar = new v();
            vVar.FH();
            final aj ajVar = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
                final /* synthetic */ InviteFacebookFriendsUI isy;

                public final boolean oQ() {
                    ap.yY();
                    c.vr().set(65829, Integer.valueOf(1));
                    ap.vd().a(vVar, 0);
                    return false;
                }
            }, false);
            ap.yY();
            if (bg.f((Integer) c.vr().get(65829, null)) > 0) {
                ap.yY();
                c.vr().set(65829, Integer.valueOf(1));
                ap.vd().a(vVar, 0);
            } else {
                ajVar.v(5000, 5000);
            }
            Context context = this.uSU.uTo;
            getString(R.l.dIO);
            this.isv = g.a(context, getString(R.l.eHh), true, new OnCancelListener(this) {
                final /* synthetic */ InviteFacebookFriendsUI isy;

                public final void onCancel(DialogInterface dialogInterface) {
                    ajVar.KH();
                    ap.vd().c(vVar);
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ InviteFacebookFriendsUI isy;

            {
                this.isy = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.isy.aHf();
                this.isy.finish();
                return true;
            }
        });
        AnonymousClass9 anonymousClass9 = new OnClickListener(this) {
            final /* synthetic */ InviteFacebookFriendsUI isy;

            {
                this.isy = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.isy.iss);
            }
        };
        a(0, getString(R.l.ehi), new OnMenuItemClickListener(this) {
            final /* synthetic */ InviteFacebookFriendsUI isy;

            {
                this.isy = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.g.a.c cVar = new com.tencent.mm.ui.g.a.c("290293790992170");
                Bundle bundle = new Bundle();
                bundle.putString("message", this.isy.getString(R.l.ehh));
                final long[] OJ = this.isy.ist.OJ();
                String l = Long.toString(OJ[0]);
                for (int i = 1; i < OJ.length; i++) {
                    l = (l + ",") + Long.toString(OJ[i]);
                }
                bundle.putString("to", l);
                cVar.a(this.isy, "apprequests", bundle, new com.tencent.mm.ui.g.a.c.a(this) {
                    final /* synthetic */ AnonymousClass10 isD;

                    public final void a(d dVar) {
                        w.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
                    }

                    public final void a(com.tencent.mm.ui.g.a.b bVar) {
                        w.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite error");
                    }

                    public final void m(Bundle bundle) {
                        w.i("MicroMsg.InviteFacebookFriendsUI", "fbinvite oncomplete");
                        List arrayList = new ArrayList();
                        arrayList.add(new com.tencent.mm.ao.i.a(33, Integer.toString(OJ.length)));
                        ap.yY();
                        c.wQ().b(new com.tencent.mm.ao.i(arrayList));
                        for (long j : OJ) {
                            q qVar = new q();
                            qVar.username = Long.toString(j);
                            qVar.hBx = 5;
                            qVar.hve = (int) bg.Ny();
                            af.Gc().a(qVar);
                        }
                        g.a(this.isD.isy, R.l.ehj, R.l.dIO, R.l.dJe, R.l.dHQ, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 isE;

                            {
                                this.isE = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.isE.isD.isy.ist.OK();
                            }
                        }, new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass1 isE;

                            {
                                this.isE = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                this.isE.isD.isy.finish();
                            }
                        });
                    }

                    public final void onCancel() {
                        w.e("MicroMsg.InviteFacebookFriendsUI", "fbinvite cancle");
                    }
                });
                return true;
            }
        });
        ks(false);
    }

    private void av(String str, String str2) {
        g.a((Context) this, str2, str, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ InviteFacebookFriendsUI isy;

            {
                this.isy = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(this.isy.uSU.uTo, FacebookAuthUI.class);
                intent.putExtra("is_force_unbind", true);
                this.isy.uSU.uTo.startActivity(intent);
                this.isy.finish();
            }
        }, null);
    }

    protected final int getLayoutId() {
        return R.i.dcQ;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.InviteFacebookFriendsUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (kVar.getType() == 32) {
            if (this.isv != null) {
                this.isv.dismiss();
                this.isv = null;
            }
            if (i == 4 && i2 == -68) {
                if (bg.mA(str)) {
                    str = "error";
                }
                av(getString(R.l.dIO), str);
            } else if (i == 0 && i2 == 0) {
                this.ist.a(null, null);
            } else {
                Toast.makeText(this, R.l.eBa, 0).show();
            }
        }
    }
}
