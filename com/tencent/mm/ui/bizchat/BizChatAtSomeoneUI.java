package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.modelbiz.a.c;
import com.tencent.mm.modelbiz.a.e;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.tools.p;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BizChatAtSomeoneUI extends MMActivity {
    private static boolean vvf = false;
    private String fJL;
    private ListView kaM;
    private long kbc;
    private String kwu;
    private String kwv;
    private p kww;
    private String mTitle;
    private a vvd;
    private c vve;

    private static class b {
        public TextView jZz;
        public MaskLayout kwV;
        public ImageView vvj;
    }

    private static class a extends k<j> {
        private List<String> jBA;
        String kwE;
        private com.tencent.mm.ah.a.a.c kwq = null;
        private c vve;
        private String[] vvh;
        private Bitmap vvi;

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            j jVar = new j();
            jVar.b(cursor);
            return jVar;
        }

        protected final /* bridge */ /* synthetic */ Object aBW() {
            return null;
        }

        public a(Context context, j jVar, c cVar, String[] strArr, List<String> list) {
            super(context, jVar);
            this.vve = cVar;
            this.vvh = strArr;
            this.jBA = list;
            com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
            aVar.hIO = e.iA(this.vve.field_brandUserName);
            aVar.hIL = true;
            aVar.hJh = true;
            aVar.hJa = R.k.bes;
            this.kwq = aVar.Hg();
            this.vvi = d.t(context.getResources().getDrawable(R.k.dtX));
        }

        protected final int aBV() {
            return BizChatAtSomeoneUI.vvf ? 1 : 0;
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
                view.setTag(bVar2);
                bVar = bVar2;
                view2 = view;
            } else {
                bVar = (b) view.getTag();
                view2 = view;
            }
            if (i == 0 && BizChatAtSomeoneUI.vvf) {
                bVar.vvj.setImageBitmap(this.vvi);
                bVar.jZz.setText(this.context.getResources().getString(R.l.dJl, new Object[]{"@"}));
                return view2;
            }
            j jVar = (j) getItem(i - (BizChatAtSomeoneUI.vvf ? 1 : 0));
            bVar.jZz.setTextColor(com.tencent.mm.bg.a.S(this.context, R.e.aVa));
            n.GW().a(jVar.field_headImageUrl, (ImageView) bVar.kwV.view, this.kwq);
            bVar.kwV.bSH();
            bVar.jZz.setText(h.b(this.context, BizChatAtSomeoneUI.a(this.vve, jVar.field_userId), bVar.jZz.getTextSize()));
            return view2;
        }

        public final void OK() {
            String str;
            aEW();
            com.tencent.mm.modelbiz.a.k DL = w.DL();
            String[] strArr = this.vvh;
            String str2 = this.kwE;
            List list = this.jBA;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select *  from BizChatUserInfo where ");
            StringBuilder append = stringBuilder.append(com.tencent.mm.modelbiz.a.k.a(strArr, list));
            if (str2 == null || str2.equals("")) {
                str = "";
            } else {
                str = " and (" + "userName like '%" + str2 + "%' )";
            }
            append.append(str);
            StringBuilder append2 = stringBuilder.append(" order by ");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(" case when length(BizChatUserInfo.userNamePY) > 0 then upper(").append("BizChatUserInfo.userNamePY) ");
            stringBuffer.append(" else upper(BizChatUserInfo.userName) end asc, ");
            stringBuffer.append(" upper(BizChatUserInfo.userNamePY) asc, ");
            stringBuffer.append(" upper(BizChatUserInfo.userName) asc ");
            append2.append(stringBuffer.toString());
            setCursor(DL.gUz.rawQuery(stringBuilder.toString(), null));
            super.notifyDataSetChanged();
        }

        protected final void OL() {
            OK();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kwu = getIntent().getStringExtra("Block_list");
        this.kwv = getIntent().getStringExtra("Chatroom_member_list");
        this.fJL = getIntent().getStringExtra("Chat_User");
        this.mTitle = getIntent().getStringExtra("Add_address_titile");
        this.kbc = getIntent().getLongExtra("key_biz_chat_id", -1);
        this.vve = w.DJ().aa(this.kbc);
        if (this.vve == null) {
            com.tencent.mm.sdk.platformtools.w.w("MicroMsg.AtSomeoneUI", "bizChatInfo is null");
            finish();
            return;
        }
        if (this.vve != null && this.vve.field_ownerUserId.equals(m.xL())) {
            vvf = true;
        }
        KC();
    }

    protected final void KC() {
        qP(this.mTitle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ BizChatAtSomeoneUI vvg;

            {
                this.vvg = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vvg.setResult(0);
                this.vvg.finish();
                return true;
            }
        });
        this.kww = new p(true, true);
        this.kww.woe = new com.tencent.mm.ui.tools.p.b(this) {
            final /* synthetic */ BizChatAtSomeoneUI vvg;

            {
                this.vvg = r1;
            }

            public final void mR(String str) {
                a a = this.vvg.vvd;
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
        j jVar = new j();
        c cVar = this.vve;
        String[] strArr = null;
        if (!u.mA(this.kwv)) {
            strArr = this.kwv.split(";");
            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.AtSomeoneUI", "chatroom members name=[%s]", Arrays.toString(strArr));
        }
        List linkedList = new LinkedList();
        if (!u.mA(this.kwu)) {
            linkedList = u.f(this.kwu.split(";"));
        }
        this.vvd = new a(this, jVar, cVar, strArr, linkedList);
        this.kaM.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ BizChatAtSomeoneUI vvg;

            {
                this.vvg = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent();
                if (i == 0 && BizChatAtSomeoneUI.vvf) {
                    intent.putExtra("Select_Conv_User", this.vvg.getString(R.l.dJl, new Object[]{""}));
                    intent.putExtra("select_raw_user_name", "notify@all");
                } else {
                    j jVar = (j) this.vvg.vvd.getItem(i);
                    String a = BizChatAtSomeoneUI.a(this.vvg.vve, jVar.field_userId);
                    intent.putExtra("select_raw_user_name", jVar.field_userId);
                    intent.putExtra("Select_Conv_User", a);
                }
                this.vvg.setResult(-1, intent);
                this.vvg.finish();
            }
        });
        this.kaM.setAdapter(this.vvd);
        this.kaM.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ BizChatAtSomeoneUI vvg;

            {
                this.vvg = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                n.GW().bi(i);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
    }

    protected void onPause() {
        super.onPause();
        if (this.kww != null) {
            this.kww.bZQ();
        }
    }

    protected void onDestroy() {
        this.vvd.aEW();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.cUS;
    }

    protected static String a(c cVar, String str) {
        if (cVar == null) {
            return null;
        }
        return cVar.eK(str);
    }
}
