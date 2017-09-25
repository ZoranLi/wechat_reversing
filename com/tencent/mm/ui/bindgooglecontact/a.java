package com.tencent.mm.ui.bindgooglecontact;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.o;
import com.tencent.mm.modelfriend.p;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.k;

public final class a extends k<o> {
    private LayoutInflater dZ = LayoutInflater.from(this.mContext);
    private Context mContext;
    private String mFilter;
    a vsJ;
    private String vsq;

    interface a {
        void AE(int i);
    }

    class b {
        ImageView ioV;
        TextView ipa;
        TextView iuF;
        String ovd;
        int position;
        TextView vsK;
        View vsL;
        ProgressBar vsM;
        final /* synthetic */ a vsN;

        public b(final a aVar, View view) {
            this.vsN = aVar;
            this.ioV = (ImageView) view.findViewById(R.h.bVe);
            this.iuF = (TextView) view.findViewById(R.h.bVi);
            this.vsL = view.findViewById(R.h.bVj);
            this.ipa = (TextView) view.findViewById(R.h.bVk);
            this.vsM = (ProgressBar) view.findViewById(R.h.bVh);
            this.vsK = (TextView) view.findViewById(R.h.bVf);
            this.vsL.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ b vsP;

                public final void onClick(View view) {
                    w.d("MicroMsg.GoogleContact.GoogleFriendAdapter", "onClick");
                    if (this.vsP.vsN.vsJ != null) {
                        this.vsP.vsN.vsJ.AE(this.vsP.position);
                    }
                }
            });
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (o) obj;
        if (obj == null) {
            obj = new o();
        }
        obj.b(cursor);
        return obj;
    }

    public a(Context context, String str) {
        super(context, new o());
        this.vsq = str;
        this.mContext = context;
    }

    protected final void OL() {
        OK();
    }

    public final void OK() {
        p Gg = af.Gg();
        String str = this.mFilter;
        String str2 = this.vsq;
        StringBuilder stringBuilder = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            stringBuilder.append(" WHERE ( GoogleFriend.googlegmail!='" + str2 + "' )");
        } else {
            stringBuilder.append(" WHERE ( ");
            stringBuilder.append("GoogleFriend.googlegmail!='" + str2 + "' AND ");
            stringBuilder.append("GoogleFriend.googlename LIKE '%" + str + "%' OR ");
            stringBuilder.append("GoogleFriend.googlenamepy LIKE '%" + str + "%' OR ");
            stringBuilder.append("GoogleFriend.googlegmail LIKE '%" + str + "%' OR ");
            stringBuilder.append("GoogleFriend.nickname LIKE '%" + str + "%' ) ");
        }
        stringBuilder.append(" GROUP BY googleid,contecttype");
        stringBuilder.append(" ORDER BY status , googlenamepy ASC , usernamepy ASC");
        setCursor(Gg.gUz.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend  " + stringBuilder.toString(), null));
        super.notifyDataSetChanged();
    }

    public final void yD(String str) {
        this.mFilter = bg.my(str);
        aEW();
        OK();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null) {
            view = this.dZ.inflate(R.i.dfw, null);
            b bVar2 = new b(this, view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        o oVar = (o) getItem(i);
        if (oVar != null) {
            bVar.position = i;
            bVar.ovd = oVar.field_googlegmail;
            Bitmap a;
            switch (oVar.field_status) {
                case 0:
                case 2:
                    if (oVar.field_small_url != null) {
                        a = com.tencent.mm.x.b.a(oVar.field_username, false, -1);
                    } else {
                        a = null;
                    }
                    if (a != null) {
                        bVar.ioV.setImageBitmap(a);
                        break;
                    }
                    bVar.ioV.setImageDrawable(com.tencent.mm.bg.a.a(this.mContext, R.k.bes));
                    break;
                case 1:
                    a = com.tencent.mm.x.b.gW(oVar.field_googleid);
                    if (a != null) {
                        bVar.ioV.setImageBitmap(a);
                        break;
                    }
                    bVar.ioV.setImageDrawable(com.tencent.mm.bg.a.a(this.mContext, R.k.bes));
                    break;
            }
            if (TextUtils.isEmpty(oVar.field_googlename)) {
                bVar.iuF.setText(bg.Qi(oVar.field_googlegmail));
            } else {
                bVar.iuF.setText(oVar.field_googlename);
            }
            switch (oVar.field_status) {
                case 0:
                    bVar.vsL.setClickable(true);
                    bVar.vsL.setBackgroundResource(R.g.bda);
                    bVar.ipa.setText(R.l.epH);
                    bVar.ipa.setTextColor(this.mContext.getResources().getColor(R.e.white));
                    break;
                case 1:
                    bVar.vsL.setClickable(true);
                    bVar.vsL.setBackgroundResource(R.g.bdb);
                    bVar.ipa.setText(R.l.epP);
                    bVar.ipa.setTextColor(this.mContext.getResources().getColor(R.e.aUz));
                    break;
                case 2:
                    bVar.vsL.setClickable(false);
                    bVar.vsL.setBackgroundDrawable(null);
                    bVar.ipa.setText(R.l.epJ);
                    bVar.ipa.setTextColor(this.mContext.getResources().getColor(R.e.aUz));
                    break;
            }
            switch (oVar.field_googlecgistatus) {
                case 0:
                    bVar.ipa.setVisibility(4);
                    bVar.vsM.setVisibility(0);
                    break;
                case 1:
                    bVar.vsL.setClickable(false);
                    bVar.vsL.setBackgroundDrawable(null);
                    bVar.ipa.setVisibility(0);
                    bVar.vsM.setVisibility(8);
                    bVar.ipa.setTextColor(this.mContext.getResources().getColor(R.e.aUz));
                    switch (oVar.field_status) {
                        case 0:
                            bVar.ipa.setText(R.l.epI);
                            break;
                        case 1:
                            bVar.ipa.setText(R.l.epQ);
                            break;
                        default:
                            break;
                    }
                case 2:
                    bVar.ipa.setVisibility(0);
                    bVar.vsM.setVisibility(8);
                    switch (oVar.field_status) {
                        case 0:
                            bVar.ipa.setText(R.l.epH);
                            bVar.ipa.setTextColor(this.mContext.getResources().getColor(R.e.white));
                            break;
                        case 1:
                            bVar.ipa.setText(R.l.epP);
                            bVar.ipa.setTextColor(this.mContext.getResources().getColor(R.e.aUz));
                            break;
                        default:
                            break;
                    }
            }
            bVar.vsK.setText(oVar.field_googlegmail);
        }
        return view;
    }
}
