package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelbiz.l;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.tools.p;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AtSomeoneUI extends MMActivity {
    private static boolean vvf = false;
    private String fJL;
    private ListView kaM;
    private q ktr;
    private String kwu;
    private String kwv;
    private p kww;
    private String mTitle;
    private a vzz;

    private static class b {
        public TextView jZz;
        public MaskLayout kwV;
        public ImageView vvj;
    }

    private static class a extends k<x> {
        private List<String> jBA;
        private q ktr;
        String kwE;
        private String[] vvh;
        private Bitmap vvi;

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            ap.yY();
            Object QX = c.wR().QX(x.h(cursor));
            if (QX != null) {
                return QX;
            }
            x xVar = new x();
            xVar.b(cursor);
            ap.yY();
            c.wR().O(xVar);
            return xVar;
        }

        protected final /* bridge */ /* synthetic */ Object aBW() {
            return null;
        }

        public a(Context context, x xVar, q qVar, String[] strArr, List<String> list) {
            super(context, xVar);
            this.ktr = qVar;
            this.vvh = strArr;
            this.jBA = list;
            this.vvi = d.t(context.getResources().getDrawable(R.k.dtX));
        }

        protected final int aBV() {
            return AtSomeoneUI.vvf ? 1 : 0;
        }

        public final boolean nJ(int i) {
            return false;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            View view2;
            if (view == null) {
                view = View.inflate(this.context, R.i.cUR, null);
                b bVar2 = new b();
                bVar2.kwV = (MaskLayout) view.findViewById(R.h.bqp);
                bVar2.jZz = (TextView) view.findViewById(R.h.bqq);
                bVar2.vvj = (ImageView) view.findViewById(R.h.content);
                view.setTag(bVar2);
                bVar = bVar2;
                view2 = view;
            } else {
                bVar = (b) view.getTag();
                view2 = view;
            }
            if (i == 0 && AtSomeoneUI.vvf) {
                bVar.vvj.setImageBitmap(this.vvi);
                bVar.jZz.setText(this.context.getResources().getString(R.l.dJl, new Object[]{"@"}));
                return view2;
            }
            CharSequence a;
            x xVar = (x) getItem(i - (AtSomeoneUI.vvf ? 1 : 0));
            bVar.jZz.setTextColor(com.tencent.mm.bg.a.S(this.context, !o.fE(xVar.field_username) ? R.e.aVa : R.e.aVb));
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) bVar.kwV.view, xVar.field_username);
            if (xVar.field_verifyFlag == 0) {
                bVar.kwV.bSH();
            } else if (com.tencent.mm.u.ag.a.hlU != null) {
                String eZ = com.tencent.mm.u.ag.a.hlU.eZ(xVar.field_verifyFlag);
                if (eZ != null) {
                    bVar.kwV.d(l.ik(eZ), com.tencent.mm.ui.base.MaskLayout.a.vnV);
                } else {
                    bVar.kwV.bSH();
                }
            } else {
                bVar.kwV.bSH();
            }
            if (u.mA(xVar.field_conRemark)) {
                a = AtSomeoneUI.a(this.ktr, xVar.field_username);
            } else {
                a = xVar.field_conRemark;
            }
            if (u.mA(a)) {
                a = xVar.tK();
            }
            bVar.jZz.setText(h.b(this.context, a, bVar.jZz.getTextSize()));
            return view2;
        }

        public final void OK() {
            List list;
            ap.yY();
            ar wR = c.wR();
            String[] strArr = this.vvh;
            String str = "@all.chatroom";
            String str2 = this.kwE;
            CharSequence charSequence = this.kwE;
            if (this.ktr == null || charSequence == null || this.vvh == null) {
                list = null;
            } else {
                list = new ArrayList();
                for (String str3 : this.vvh) {
                    String eK = this.ktr.eK(str3);
                    if (eK != null && eK.contains(charSequence)) {
                        list.add(str3);
                    }
                }
            }
            setCursor(wR.a(strArr, str, str2, list, this.jBA));
            super.notifyDataSetChanged();
        }

        protected final void OL() {
            aEW();
            OK();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kwu = getIntent().getStringExtra("Block_list");
        this.kwv = getIntent().getStringExtra("Chatroom_member_list");
        this.fJL = getIntent().getStringExtra("Chat_User");
        this.mTitle = getIntent().getStringExtra("Add_address_titile");
        ap.yY();
        this.ktr = c.xa().fV(this.fJL);
        if (this.ktr != null && this.ktr.field_roomowner.equals(m.xL())) {
            vvf = false;
        }
        KC();
    }

    protected final void KC() {
        boolean z = true;
        qP(this.mTitle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AtSomeoneUI vzA;

            {
                this.vzA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vzA.setResult(0);
                this.vzA.finish();
                return true;
            }
        });
        this.kww = new p(true, true);
        this.kww.woe = new com.tencent.mm.ui.tools.p.b(this) {
            final /* synthetic */ AtSomeoneUI vzA;

            {
                this.vzA = r1;
            }

            public final void mR(String str) {
                a a = this.vzA.vzz;
                a.kwE = str;
                a.a(null, null);
            }

            public final boolean mQ(String str) {
                return false;
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
        a(this.kww);
        this.kaM = (ListView) findViewById(R.h.bzj);
        x xVar = new x();
        q qVar = this.ktr;
        String[] strArr = null;
        if (!u.mA(this.kwv)) {
            strArr = this.kwv.split(",");
            w.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", Arrays.toString(strArr));
        }
        if (strArr == null && this.ktr != null) {
            w.w("MicroMsg.AtSomeoneUI", "[getChatroomMember] chatroomMemberList is null!");
            strArr = u.c(this.ktr.DU(), ",").split(",");
        }
        if (strArr == null) {
            String str = "MicroMsg.AtSomeoneUI";
            String str2 = "WTF! member is null? %s";
            Object[] objArr = new Object[1];
            if (this.ktr != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            w.e(str, str2, objArr);
        }
        List linkedList = new LinkedList();
        if (!u.mA(this.kwu)) {
            linkedList = u.f(this.kwu.split(","));
        }
        ap.yY();
        ay AH = c.wZ().AH("@t.qq.com");
        if (AH != null) {
            linkedList.add(AH.name);
        }
        this.vzz = new a(this, xVar, qVar, strArr, linkedList);
        this.kaM.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ AtSomeoneUI vzA;

            {
                this.vzA = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                Intent intent = new Intent();
                if (i == 0 && AtSomeoneUI.vvf) {
                    intent.putExtra("Select_Conv_User", this.vzA.getString(R.l.dJl, new Object[]{""}));
                    intent.putExtra("select_raw_user_name", "notify@all");
                } else {
                    a a = this.vzA.vzz;
                    if (!AtSomeoneUI.vvf) {
                        i2 = 0;
                    }
                    x xVar = (x) a.getItem(i - i2);
                    String a2 = AtSomeoneUI.a(this.vzA.ktr, xVar.field_username);
                    if (u.mA(a2)) {
                        a2 = xVar.tK();
                    }
                    intent.putExtra("select_raw_user_name", xVar.field_username);
                    intent.putExtra("Select_Conv_User", a2);
                }
                this.vzA.setResult(-1, intent);
                this.vzA.finish();
            }
        });
        this.kaM.setAdapter(this.vzz);
    }

    protected void onPause() {
        super.onPause();
        if (this.kww != null) {
            this.kww.bZQ();
        }
    }

    protected void onDestroy() {
        this.vzz.aEW();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.cUS;
    }

    protected static String a(q qVar, String str) {
        if (qVar == null) {
            return null;
        }
        return qVar.eK(str);
    }
}
