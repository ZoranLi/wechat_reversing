package com.tencent.mm.ui.friend;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.text.TextUtils;
import com.tencent.mm.R;
import com.tencent.mm.ag.b;
import com.tencent.mm.modelfriend.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.d;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;

public final class h implements e {
    private Context context;
    private ProgressDialog koS;
    public a whI;

    public interface a {
        void lC(boolean z);
    }

    public h(Context context, a aVar) {
        this.context = context;
        this.whI = aVar;
    }

    final void j(Cursor cursor) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        if (cursor != null) {
            cursor.moveToFirst();
            int count = cursor.getCount();
            for (int i = 0; i < count; i++) {
                o oVar = new o();
                oVar.b(cursor);
                arrayList.add(oVar.field_googlegmail);
                arrayList2.add(Integer.valueOf(i));
                arrayList3.add(oVar);
                cursor.moveToNext();
            }
            arrayList2.add(Integer.valueOf(-1));
        }
        Context context = this.context;
        String string = this.context.getResources().getString(R.l.epU);
        this.context.getResources().getString(R.l.dGs);
        g.a(context, string, arrayList, arrayList2, new d(this) {
            final /* synthetic */ h whJ;

            public final void bN(int i, int i2) {
                if (i2 != -1) {
                    this.whJ.Ue(((o) arrayList3.get(i2)).field_googlegmail);
                }
            }
        });
    }

    public final void Ue(String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        final k bVar = new b(arrayList);
        ap.vd().a(bVar, 0);
        Context context = this.context;
        this.context.getString(R.l.ete);
        this.koS = g.a(context, this.context.getString(R.l.etc), true, new OnCancelListener(this) {
            final /* synthetic */ h whJ;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(bVar);
                this.whJ.whI.lC(false);
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.SendInviteGoogleContact";
        String str3 = "[onSceneEnd] errType:%d,errCode:%d,errMsg:%s";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        objArr[2] = str;
        w.i(str2, str3, objArr);
        if (kVar.getType() == 489) {
            if (this.koS != null) {
                this.koS.dismiss();
                this.koS = null;
            }
            ap.vd().b(489, (e) this);
            if (i == 0 && i2 == 0) {
                w.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteSuccess");
                g.a(this.context, R.l.etb, R.l.dIO, new OnClickListener(this) {
                    final /* synthetic */ h whJ;

                    {
                        this.whJ = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.whJ.whI.lC(true);
                    }
                });
                return;
            }
            w.i("MicroMsg.SendInviteGoogleContact", "dealSendInviteFail");
            this.whI.lC(false);
        }
    }
}
