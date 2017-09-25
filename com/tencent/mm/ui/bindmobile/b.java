package com.tencent.mm.ui.bindmobile;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bm;
import com.tencent.mm.u.m;
import java.util.LinkedList;

public final class b extends a {
    private int[] hBc;
    private String isF;
    private com.tencent.mm.ui.bindmobile.a.a vur;
    private com.tencent.mm.ui.bindmobile.a.b vus = new com.tencent.mm.ui.bindmobile.a.b(this) {
        final /* synthetic */ b vut;

        {
            this.vut = r1;
        }

        public final void e(int i, String str, int i2) {
            w.d("MicroMsg.MobileFriendAdapter", "[cpan] postion:%d md5:%s status:%d", Integer.valueOf(i), str, Integer.valueOf(i2));
            final com.tencent.mm.modelfriend.b bVar = (com.tencent.mm.modelfriend.b) this.vut.getItem(i);
            if (bVar == null) {
                w.e("MicroMsg.MobileFriendAdapter", "[cpan] mobile Friend is null. mobile:%s", str);
                return;
            }
            w.d("MicroMsg.MobileFriendAdapter", "mobile friend:%s", bVar.toString());
            if (bVar.status == 1) {
                com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.vut.context, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
                    final /* synthetic */ AnonymousClass1 vuu;

                    {
                        this.vuu = r1;
                    }

                    public final void a(boolean z, boolean z2, String str, String str2) {
                        w.i("MicroMsg.MobileFriendAdapter", "cpan ok:%b hasSendVerify:%b  username:%s gitemId:%s", Boolean.valueOf(z), Boolean.valueOf(z2), str, str2);
                        com.tencent.mm.modelfriend.b ja = af.FY().ja(str2);
                        if (ja == null) {
                            w.w("MicroMsg.MobileFriendAdapter", "cpan qq friend is null. qq:%s", str2);
                        } else if (z) {
                            ja.username = str;
                            ja.status = 2;
                            ja.hry = 2;
                            w.d("MicroMsg.MobileFriendAdapter", "f :%s", ja.toString());
                            af.FY().a(str2, ja);
                            this.vuu.vut.OK();
                            bm.zN().c(26, new Object[0]);
                        }
                    }
                });
                aVar.sLO = new com.tencent.mm.pluginsdk.ui.applet.a.b(this) {
                    final /* synthetic */ AnonymousClass1 vuu;

                    public final boolean aFo() {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", bVar.getUsername());
                        intent.putExtra("Contact_Nick", bVar.EU());
                        intent.putExtra("Contact_Scene", 13);
                        intent.putExtra("sayhi_with_sns_perm_send_verify", true);
                        intent.putExtra("sayhi_with_sns_perm_add_remark", true);
                        intent.putExtra("sayhi_with_jump_to_profile", true);
                        d.b(this.vuu.vut.context, "profile", ".ui.SayHiWithSnsPermissionUI", intent, 1);
                        return true;
                    }
                };
                if (this.vut.context instanceof MobileFriendUI) {
                    ((MobileFriendUI) this.vut.context).uSV = new com.tencent.mm.ui.MMActivity.a(this) {
                        final /* synthetic */ AnonymousClass1 vuu;

                        public final void a(int i, int i2, Intent intent) {
                            if (i == 1 && i2 == -1) {
                                ((MobileFriendUI) this.vuu.vut.context).b(bVar);
                            }
                        }
                    };
                }
                aVar.sLW = bVar.EP();
                aVar.sLV = false;
                LinkedList linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(13));
                aVar.b(bVar.getUsername(), linkedList, false);
            }
        }
    };

    class a {
        String fFW;
        TextView hBj;
        TextView ipa;
        int status;
        int umb;
        final /* synthetic */ b vut;
        View vuw;
        ProgressBar vux;

        public a(final b bVar, View view) {
            this.vut = bVar;
            this.hBj = (TextView) view.findViewById(R.h.ckz);
            this.vuw = view.findViewById(R.h.ckr);
            this.ipa = (TextView) view.findViewById(R.h.ckC);
            this.vux = (ProgressBar) view.findViewById(R.h.ckB);
            this.vuw.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a vuz;

                public final void onClick(View view) {
                    if (this.vuz.vut.vus != null) {
                        this.vuz.vut.vus.e(this.vuz.umb, this.vuz.fFW, this.vuz.status);
                    }
                }
            });
        }
    }

    public final void a(com.tencent.mm.ui.bindmobile.a.a aVar) {
        this.vur = aVar;
    }

    public b(Context context, com.tencent.mm.ui.k.a aVar) {
        super(context, new com.tencent.mm.modelfriend.b());
        this.uSN = aVar;
        this.context = context;
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
        c FY = af.FY();
        String str = this.isF;
        StringBuilder stringBuilder = new StringBuilder();
        if (str != null && str.length() > 0) {
            stringBuilder.append(" and ( ");
            stringBuilder.append("addr_upload2.realname like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.realnamepyinitial like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.realnamequanpin like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.username like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.nickname like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.nicknamepyinitial like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.nicknamequanpin like '%" + str + "%' )");
        }
        stringBuilder.append(" and (");
        stringBuilder.append("addr_upload2.status=1");
        stringBuilder.append(" or ");
        stringBuilder.append("addr_upload2.status=2");
        stringBuilder.append(")");
        ap.yY();
        str = (String) com.tencent.mm.u.c.vr().get(6, null);
        Cursor a = (str == null || str.equals("")) ? FY.hnH.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + stringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null, 0) : FY.hnH.a("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + str + stringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null, 0);
        setCursor(a);
        this.hBc = new int[getCount()];
        if (!(this.vur == null || this.isF == null)) {
            this.vur.zA(getCursor().getCount());
        }
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        com.tencent.mm.modelfriend.b bVar = (com.tencent.mm.modelfriend.b) getItem(i);
        if (view == null) {
            view = View.inflate(this.context, R.i.djw, null);
            a aVar2 = new a(this, view);
            aVar2.hBj = (TextView) view.findViewById(R.h.ckz);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.umb = i;
        aVar.fFW = bVar.EP();
        aVar.status = bVar.status;
        aVar.hBj.setText(bVar.ER());
        switch (bVar.status) {
            case 0:
                if (bVar.hry != 2) {
                    aVar.vuw.setClickable(true);
                    aVar.vuw.setBackgroundResource(R.g.bda);
                    aVar.ipa.setText(R.l.emS);
                    aVar.ipa.setTextColor(this.context.getResources().getColor(R.e.white));
                    break;
                }
                aVar.vuw.setClickable(false);
                aVar.vuw.setBackgroundDrawable(null);
                aVar.ipa.setText(R.l.emT);
                aVar.ipa.setTextColor(this.context.getResources().getColor(R.e.aUz));
                break;
            case 1:
            case 2:
                w.d("MicroMsg.MobileFriendAdapter", "username:%s", bVar.getUsername());
                ap.yY();
                if (!com.tencent.mm.u.c.wR().QY(bVar.getUsername()) && !m.xL().equals(bVar.getUsername())) {
                    if (bVar.hry != 2) {
                        aVar.vuw.setClickable(true);
                        aVar.vuw.setBackgroundResource(R.g.bda);
                        aVar.ipa.setText(R.l.emQ);
                        aVar.ipa.setTextColor(this.context.getResources().getColor(R.e.white));
                        break;
                    }
                    aVar.vuw.setClickable(false);
                    aVar.vuw.setBackgroundDrawable(null);
                    aVar.ipa.setText(R.l.emV);
                    aVar.ipa.setTextColor(this.context.getResources().getColor(R.e.aUz));
                    break;
                }
                aVar.vuw.setClickable(false);
                aVar.vuw.setBackgroundDrawable(null);
                aVar.ipa.setText(R.l.emR);
                aVar.ipa.setTextColor(this.context.getResources().getColor(R.e.aUz));
                break;
                break;
        }
        switch (bVar.hry) {
            case 0:
            case 2:
                aVar.ipa.setVisibility(0);
                aVar.vux.setVisibility(4);
                break;
            case 1:
                aVar.ipa.setVisibility(4);
                aVar.vux.setVisibility(0);
                break;
        }
        return view;
    }

    private static com.tencent.mm.modelfriend.b a(com.tencent.mm.modelfriend.b bVar, Cursor cursor) {
        if (bVar == null) {
            bVar = new com.tencent.mm.modelfriend.b();
        }
        bVar.b(cursor);
        return bVar;
    }
}
