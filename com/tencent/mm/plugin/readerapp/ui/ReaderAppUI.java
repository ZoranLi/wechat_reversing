package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.model.s;
import com.tencent.mm.pluginsdk.ui.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bd;
import com.tencent.mm.u.be;
import com.tencent.mm.u.c;
import com.tencent.mm.u.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.CustomFitTextView;
import com.tencent.mm.ui.widget.g;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class ReaderAppUI extends MMActivity implements com.tencent.mm.platformtools.j.a {
    private static float density;
    private int fSM = 0;
    private g kaU;
    private String neQ = "";
    private View nsQ;
    private ListView nxG;
    private MMPullDownView nxK;
    private d nxN = new d(this) {
        final /* synthetic */ ReaderAppUI oKk;

        {
            this.oKk = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            int groupId = menuItem.getGroupId();
            bd bdVar;
            long longValue;
            switch (menuItem.getItemId()) {
                case 0:
                    if (this.oKk.fSM == 20) {
                        List c = com.tencent.mm.plugin.readerapp.b.g.aWb().c(((Long) this.oKk.oKf.getItem(groupId)).longValue(), this.oKk.fSM);
                        if (c.size() > 0) {
                            bdVar = (bd) c.get(0);
                            com.tencent.mm.t.f.a aVar = new com.tencent.mm.t.f.a();
                            aVar.title = bdVar.getTitle();
                            aVar.description = bdVar.zI();
                            aVar.action = "view";
                            aVar.type = 5;
                            aVar.url = bdVar.getUrl();
                            String a = com.tencent.mm.t.f.a.a(aVar, null, null);
                            Intent intent = new Intent();
                            intent.putExtra("Retr_Msg_content", a);
                            intent.putExtra("Retr_Msg_Type", 2);
                            intent.putExtra("Retr_Msg_thumb_path", s.n(bdVar.zH(), bdVar.type, "@T"));
                            intent.putExtra("Retr_Msg_Id", 7377812);
                            a = q.fQ(bdVar.hnE);
                            intent.putExtra("reportSessionId", a);
                            com.tencent.mm.u.q.b n = q.yC().n(a, true);
                            n.l("prePublishId", "msg_" + bdVar.hnE);
                            n.l("preUsername", "newsapp");
                            n.l("preChatName", "newsapp");
                            n.l("preMsgIndex", Integer.valueOf(0));
                            n.l("sendAppMsgScene", Integer.valueOf(1));
                            com.tencent.mm.plugin.readerapp.a.a.imv.l(intent, this.oKk);
                            return;
                        }
                        return;
                    }
                    return;
                case 1:
                    if (this.oKk.fSM == 20) {
                        List c2 = com.tencent.mm.plugin.readerapp.b.g.aWb().c(((Long) this.oKk.oKf.getItem(groupId)).longValue(), this.oKk.fSM);
                        if (!c2.isEmpty()) {
                            w.i("MicroMsg.ReaderAppUI", "fav time %d, index %d, size %d", new Object[]{Long.valueOf(longValue), Integer.valueOf(this.oKk.oKi), Integer.valueOf(c2.size())});
                            if (this.oKk.oKi >= c2.size()) {
                                this.oKk.oKi = 0;
                            }
                            bdVar = (bd) c2.get(this.oKk.oKi);
                            com.tencent.mm.sdk.b.b cbVar = new cb();
                            String fQ = q.fQ(bdVar.hnE);
                            com.tencent.mm.u.q.b n2 = q.yC().n(fQ, true);
                            n2.l("prePublishId", "msg_" + bdVar.hnE);
                            n2.l("preUsername", "newsapp");
                            n2.l("preChatName", "newsapp");
                            n2.l("preMsgIndex", Integer.valueOf(0));
                            n2.l("sendAppMsgScene", Integer.valueOf(1));
                            cbVar.fFA.fFF = fQ;
                            com.tencent.mm.plugin.readerapp.b.b.a(cbVar, bdVar, this.oKk.oKi);
                            cbVar.fFA.fFH = 7;
                            cbVar.fFA.activity = this.oKk;
                            com.tencent.mm.sdk.b.a.urY.m(cbVar);
                            return;
                        }
                        return;
                    }
                    return;
                case 2:
                    longValue = ((Long) this.oKk.oKf.getItem(groupId)).longValue();
                    if (longValue != 0) {
                        com.tencent.mm.plugin.readerapp.b.g.t(longValue, this.oKk.fSM);
                        be aWb = com.tencent.mm.plugin.readerapp.b.g.aWb();
                        int a2 = this.oKk.fSM;
                        w.d("MicroMsg.ReaderAppInfoStorage", "deleteGroup:%s", new Object[]{"delete from " + be.fe(a2) + " where time = " + longValue});
                        if (aWb.hnH.eE(be.fe(a2), "delete from " + be.fe(a2) + " where time = " + longValue)) {
                            aWb.fh(a2);
                            aWb.doNotify();
                        }
                    }
                    this.oKk.refresh();
                    return;
                default:
                    return;
            }
        }
    };
    private a<Long> oKf;
    private e oKg = null;
    private ae oKh = new ae();
    private int oKi = 0;

    class a extends a<Long> {
        private Context context;
        private int hOI;
        private int kor;
        final /* synthetic */ ReaderAppUI oKk;
        private ImageGetter oKn = new ImageGetter(this) {
            final /* synthetic */ a oKr;

            {
                this.oKr = r1;
            }

            public final Drawable getDrawable(String str) {
                Drawable drawable = this.oKr.oKk.getResources().getDrawable(bg.getInt(str, 0));
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                return drawable;
            }
        };
        private int oKo = 0;
        private int oKp = 0;
        private int oKq = 0;

        final class a {
            TextView iUO;
            ProgressBar lKt;
            final /* synthetic */ a oKr;
            View oKs;
            View oKt;
            ImageView oKu;
            ImageView oKv;
            View oKw;

            a(a aVar) {
                this.oKr = aVar;
            }
        }

        final class b {
            TextView iUO;
            ProgressBar lKt;
            TextView mzk;
            TextView nxA;
            ViewGroup oKA;
            ViewGroup oKB;
            CustomFitTextView oKC;
            LinearLayout oKD;
            List<a> oKE;
            final /* synthetic */ a oKr;
            View oKw;
            TextView oKx;
            ImageView oKy;
            View oKz;

            b(a aVar) {
                this.oKr = aVar;
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            return Long.valueOf(cursor.getLong(0));
        }

        public final /* synthetic */ Object getItem(int i) {
            return rL(i);
        }

        public a(ReaderAppUI readerAppUI, Context context, Long l) {
            this.oKk = readerAppUI;
            super(context, l);
            this.context = context;
            this.kor = 3;
            this.hOI = com.tencent.mm.plugin.readerapp.b.g.aWb().ff(readerAppUI.fSM);
            this.oKp = context.getResources().getDimensionPixelSize(R.f.aXR);
            this.oKq = context.getResources().getDimensionPixelSize(R.f.aWZ);
            this.oKo = context.getResources().getDimensionPixelSize(R.f.aWA);
        }

        protected final void OL() {
            OK();
        }

        public final boolean ahI() {
            return this.kor >= this.hOI;
        }

        public final int aWc() {
            return this.kor;
        }

        public final int ahJ() {
            if (ahI()) {
                return 0;
            }
            this.kor += 3;
            if (this.kor <= this.hOI) {
                return 3;
            }
            this.kor = this.hOI;
            return this.hOI % 3;
        }

        public final void OK() {
            this.hOI = com.tencent.mm.plugin.readerapp.b.g.aWb().ff(20);
            setCursor(com.tencent.mm.plugin.readerapp.b.g.aWb().aK(this.kor, 20));
            super.notifyDataSetChanged();
        }

        private Long rL(int i) {
            return (Long) super.getItem(i);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            int i2;
            w.w("MicroMsg.ReaderAppUI", "ashutest get view position %d", new Object[]{Integer.valueOf(i)});
            if (view == null) {
                bVar = new b(this);
                view = View.inflate(this.context, R.i.dlN, null);
                bVar.mzk = (TextView) view.findViewById(R.h.cvt);
                bVar.oKB = (ViewGroup) view.findViewById(R.h.cvp);
                bVar.iUO = (TextView) view.findViewById(R.h.cvu);
                bVar.oKx = (TextView) view.findViewById(R.h.cvr);
                bVar.oKy = (ImageView) view.findViewById(R.h.cvs);
                bVar.nxA = (TextView) view.findViewById(R.h.cvq);
                bVar.oKz = view.findViewById(R.h.cJo);
                bVar.oKA = (ViewGroup) view.findViewById(R.h.cJc);
                bVar.oKC = (CustomFitTextView) view.findViewById(R.h.cJf);
                bVar.oKD = (LinearLayout) view.findViewById(R.h.bIt);
                bVar.lKt = (ProgressBar) view.findViewById(R.h.bZu);
                bVar.oKw = view.findViewById(R.h.bKf);
                bVar.oKE = new ArrayList();
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            for (a aVar : bVar.oKE) {
                bVar.oKB.removeView(aVar.oKs);
            }
            bVar.oKE.clear();
            List c = com.tencent.mm.plugin.readerapp.b.g.aWb().c(rL(i).longValue(), 20);
            if (c.size() > 0) {
                int size = c.size();
                bd bdVar = (bd) c.get(0);
                bVar.iUO.setText(bdVar.getTitle());
                bVar.nxA.setText(bdVar.zI());
                bVar.mzk.setText(o.c(this.context, bdVar.time, false));
                bVar.oKx.setText(o.Z(this.context.getString(R.l.elp), bdVar.hnz));
                if (this.oKk.oKg != null) {
                    bVar.mzk.setTextColor(this.oKk.oKg.sIq);
                    if (this.oKk.oKg.sIr) {
                        bVar.mzk.setShadowLayer(2.0f, 1.2f, 1.2f, this.oKk.oKg.sIs);
                    } else {
                        bVar.mzk.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                    }
                    if (this.oKk.oKg.sIt) {
                        bVar.mzk.setBackgroundResource(R.g.bdQ);
                        bVar.mzk.setPadding(this.oKp, this.oKo, this.oKp, this.oKo);
                    } else {
                        bVar.mzk.setBackgroundColor(0);
                    }
                }
                boolean z = true;
                bVar.lKt.setVisibility(8);
                bVar.oKw.setVisibility(8);
                if (bdVar.zC()) {
                    bVar.oKC.c(bdVar.getTitle(), 4, true, R.g.biU);
                } else {
                    bVar.oKC.c(bdVar.getTitle(), 4, false, -1);
                }
                if (bg.mA(bdVar.zH())) {
                    bVar.oKy.setVisibility(8);
                    z = false;
                } else {
                    bVar.oKy.setVisibility(0);
                    bVar.oKy.setImageBitmap(j.a(new s(bdVar.zH(), bdVar.type, "@T", this.lre)));
                }
                bVar.oKz.setOnClickListener(this.oKk.a(bdVar, this.oKk.fSM, 0));
                if (size > 1) {
                    a(bVar, false, z);
                    for (i2 = 1; i2 < size - 1; i2++) {
                        a(bVar, c, R.i.dlU, i2);
                    }
                    a(bVar, c, R.i.dlT, size - 1);
                } else {
                    a(bVar, true, !z);
                }
            }
            bVar.oKz.setTag(Integer.valueOf(i));
            bVar.oKz.setTag(R.h.cvF, Integer.valueOf(0));
            this.oKk.kaU.c(bVar.oKz, new OnCreateContextMenuListener(this.oKk, c.size() == 1) {
                final /* synthetic */ ReaderAppUI oKk;

                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    contextMenu.clear();
                    if (this.oKk.fSM == 20) {
                        contextMenu.setHeaderTitle(R.l.erT);
                    } else {
                        contextMenu.setHeaderTitle(R.l.erW);
                    }
                    if (20 == this.oKk.fSM) {
                        if (r2) {
                            contextMenu.add(intValue, 0, 1, R.l.eIb);
                        }
                        if (com.tencent.mm.bb.d.Jt("favorite")) {
                            contextMenu.add(intValue, 1, 2, R.l.eGa);
                        }
                        this.oKk.oKi = ((Integer) view.getTag(R.h.cvF)).intValue();
                    }
                    contextMenu.add(intValue, 2, 3, R.l.eIa);
                }
            }, this.oKk.nxN);
            int i3 = 1;
            for (a aVar2 : bVar.oKE) {
                aVar2.oKs.setTag(Integer.valueOf(i));
                this.oKk.kaU.c(aVar2.oKs, /* anonymous class already generated */, this.oKk.nxN);
                i2 = i3 + 1;
                aVar2.oKs.setTag(R.h.cvF, Integer.valueOf(i3));
                i3 = i2;
            }
            return view;
        }

        private void a(b bVar, List<bd> list, int i, int i2) {
            a aVar = new a(this);
            aVar.oKs = View.inflate(this.context, i, null);
            aVar.iUO = (TextView) aVar.oKs.findViewById(R.h.title);
            aVar.oKu = (ImageView) aVar.oKs.findViewById(R.h.bGY);
            aVar.oKv = (ImageView) aVar.oKs.findViewById(R.h.cLu);
            aVar.oKt = aVar.oKs.findViewById(R.h.bGZ);
            aVar.lKt = (ProgressBar) aVar.oKs.findViewById(R.h.cbS);
            aVar.oKw = aVar.oKs.findViewById(R.h.cbJ);
            if (bVar != null) {
                bVar.oKB.addView(aVar.oKs);
                bVar.oKE.add(aVar);
            }
            bd bdVar = (bd) list.get(i2);
            aVar.iUO.setText(bdVar.getTitle());
            aVar.lKt.setVisibility(8);
            aVar.oKw.setVisibility(8);
            if (bdVar.zC()) {
                aVar.iUO.setText(Html.fromHtml(bdVar.getTitle() + "<img src='" + R.g.biV + "'/>", this.oKn, null));
            } else {
                aVar.iUO.setText(bdVar.getTitle());
            }
            if (bg.mA(bdVar.zH())) {
                aVar.oKt.setVisibility(8);
                aVar.oKv.setVisibility(8);
            } else {
                aVar.oKu.setVisibility(0);
                aVar.oKu.setImageBitmap(j.a(new s(bdVar.zH(), bdVar.type, "@S", this.lre)));
            }
            aVar.oKs.setOnClickListener(this.oKk.a(bdVar, this.oKk.fSM, i2));
        }

        private void a(b bVar, boolean z, boolean z2) {
            int i;
            int i2 = 0;
            bVar.oKD.setVisibility(z ? 0 : 8);
            if (z) {
                bVar.oKz.setBackgroundResource(R.g.biT);
                bVar.oKz.setPadding(this.oKq, this.oKq, this.oKq, this.oKq);
            } else {
                bVar.oKz.setBackgroundResource(R.g.biR);
                bVar.oKz.setPadding(this.oKq, this.oKq, this.oKq, this.oKp);
            }
            TextView textView = bVar.iUO;
            if (z || !(z || z2)) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
            textView = bVar.oKx;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
            textView = bVar.nxA;
            if (z) {
                i = 0;
            } else {
                i = 8;
            }
            textView.setVisibility(i);
            ViewGroup viewGroup = bVar.oKA;
            if (z || !z2) {
                i2 = 8;
            }
            viewGroup.setVisibility(i2);
        }
    }

    class b extends a<Long> {
        private Context context;
        private int hOI = this.kor;
        private int kor = 3;
        final /* synthetic */ ReaderAppUI oKk;
        private int oKo;
        private int oKp;

        class a {
            TextView mzk;
            ReaderItemListView oKF;
            final /* synthetic */ b oKG;

            a(b bVar) {
                this.oKG = bVar;
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            return Long.valueOf(cursor.getLong(0));
        }

        public b(ReaderAppUI readerAppUI, Context context, Long l) {
            this.oKk = readerAppUI;
            super(context, l);
            this.context = context;
            this.oKo = context.getResources().getDimensionPixelSize(R.f.aWA);
            this.oKp = context.getResources().getDimensionPixelSize(R.f.aXR);
        }

        protected final void OL() {
            OK();
        }

        public final boolean ahI() {
            return this.kor >= this.hOI;
        }

        public final int aWc() {
            return this.kor;
        }

        public final int ahJ() {
            if (ahI()) {
                return 0;
            }
            this.kor += 3;
            if (this.kor <= this.hOI) {
                return 3;
            }
            this.kor = this.hOI;
            return this.hOI % 3;
        }

        public final void OK() {
            this.hOI = com.tencent.mm.plugin.readerapp.b.g.aWb().ff(this.oKk.fSM);
            setCursor(com.tencent.mm.plugin.readerapp.b.g.aWb().aK(this.kor, this.oKk.fSM));
            super.notifyDataSetChanged();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                aVar = new a(this);
                view = View.inflate(this.context, R.i.dlO, null);
                aVar.oKF = (ReaderItemListView) view.findViewById(R.h.cvH);
                aVar.mzk = (TextView) view.findViewById(R.h.cvt);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.mzk.setText(o.c(this.context, ((Long) getItem(i)).longValue(), false));
            ReaderItemListView readerItemListView = aVar.oKF;
            long longValue = ((Long) getItem(i)).longValue();
            OnCreateContextMenuListener a = /* anonymous class already generated */;
            d g = this.oKk.nxN;
            readerItemListView.position = i;
            readerItemListView.oKJ = a;
            readerItemListView.nxN = g;
            readerItemListView.oKH = com.tencent.mm.plugin.readerapp.b.g.aWb().c(longValue, readerItemListView.type);
            readerItemListView.oKI.notifyDataSetChanged();
            if (this.oKk.oKg != null) {
                aVar.mzk.setTextColor(this.oKk.oKg.sIq);
                if (this.oKk.oKg.sIr) {
                    aVar.mzk.setShadowLayer(2.0f, 1.2f, 1.2f, this.oKk.oKg.sIs);
                } else {
                    aVar.mzk.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                }
                if (this.oKk.oKg.sIt) {
                    aVar.mzk.setBackgroundResource(R.g.bdQ);
                    aVar.mzk.setPadding(this.oKp, this.oKo, this.oKp, this.oKo);
                } else {
                    aVar.mzk.setBackgroundColor(0);
                }
            }
            return view;
        }
    }

    static /* synthetic */ String a(ReaderAppUI readerAppUI, String str) {
        int i = 1;
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.ReaderAppUI", "appendArgs fail, srcUrl is null");
            return "";
        }
        int i2;
        List linkedList;
        String format;
        PackageInfo Dh = readerAppUI.Dh("com.tencent.news");
        if (Dh == null) {
            w.i("MicroMsg.ReaderAppUI", "isNewsInstallAndSupport false, pkgInfo is null");
        } else if (Dh.versionCode >= 220) {
            i2 = 1;
            if (i2 == 0) {
                i = 0;
            }
            w.i("MicroMsg.ReaderAppUI", "appendArgsForNews, isNewsInstallAndSupport = " + i);
            linkedList = new LinkedList();
            linkedList.add(new BasicNameValuePair("isappinstalled", String.valueOf(i)));
            format = URLEncodedUtils.format(linkedList, ProtocolPackage.ServerEncoding);
            return str.contains("?") ? str + "&" + format : str + "?" + format;
        }
        i2 = 0;
        if (i2 == 0) {
            i = 0;
        }
        w.i("MicroMsg.ReaderAppUI", "appendArgsForNews, isNewsInstallAndSupport = " + i);
        linkedList = new LinkedList();
        linkedList.add(new BasicNameValuePair("isappinstalled", String.valueOf(i)));
        format = URLEncodedUtils.format(linkedList, ProtocolPackage.ServerEncoding);
        if (str.contains("?")) {
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fSM = getIntent().getIntExtra(Columns.TYPE, 0);
        density = com.tencent.mm.bg.a.getDensity(this);
        KC();
        this.neQ = bd.fd(this.fSM);
    }

    public void onDestroy() {
        if (this.oKf != null) {
            this.oKf.aEW();
            this.oKf.uSN = null;
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dlI;
    }

    protected void onResume() {
        super.onResume();
        j.b(this);
        if (this.fSM == 20) {
            zi(R.l.erT);
        } else {
            zi(R.l.erW);
        }
        ap.getNotification().db(this.neQ);
        ap.getNotification().cancelNotification(this.neQ);
        ap.yY();
        c.wW().Ro(this.neQ);
        com.tencent.mm.plugin.readerapp.b.g.aWb().c(this.oKf);
        this.oKf.a(null, null);
        refresh();
    }

    protected void onPause() {
        super.onPause();
        ap.getNotification().db("");
        com.tencent.mm.plugin.readerapp.b.g.aWb().f(this.oKf);
        j.c(this);
        ap.yY();
        c.wW().Ro(this.neQ);
    }

    public final void refresh() {
        TextView textView = (TextView) findViewById(R.h.bLU);
        textView.setText(this.fSM == 20 ? R.l.biW : R.l.eIh);
        if (this.oKf.getCount() == 0) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
    }

    protected final void KC() {
        try {
            this.oKg = new e(bg.convertStreamToString(getAssets().open("chatting/default_chat.xml")));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ReaderAppUI", e, "", new Object[0]);
        }
        this.nxG = (ListView) findViewById(R.h.cvD);
        this.nxK = (MMPullDownView) findViewById(R.h.cvG);
        this.nsQ = getLayoutInflater().inflate(R.i.dlL, null);
        this.nxG.addHeaderView(this.nsQ);
        ((TextView) findViewById(R.h.bLU)).setText(R.l.eHW);
        if (this.fSM == 20) {
            this.oKf = new a(this, this, Long.valueOf(0));
        } else if (this.fSM == 11) {
            this.oKf = new b(this, this, Long.valueOf(0));
        }
        this.nxG.setOnScrollListener(this.oKf);
        this.nxG.setAdapter(this.oKf);
        this.nxG.setTranscriptMode(0);
        registerForContextMenu(this.nxG);
        this.kaU = new g(this);
        if (this.oKf.getCount() == 0) {
            Intent intent = new Intent(this, ReaderAppIntroUI.class);
            intent.putExtra(Columns.TYPE, this.fSM);
            startActivity(intent);
            finish();
            return;
        }
        this.nxK.vln = new MMPullDownView.g(this) {
            final /* synthetic */ ReaderAppUI oKk;

            {
                this.oKk = r1;
            }

            public final boolean akp() {
                if (this.oKk.oKf.ahI()) {
                    this.oKk.nxG.setSelectionFromTop(0, this.oKk.nxK.vlp);
                } else {
                    int ahJ = this.oKk.oKf.ahJ();
                    w.v("MicroMsg.ReaderAppUI", "onLoadData add count:" + ahJ);
                    this.oKk.oKf.a(null, null);
                    this.oKk.nxG.setSelectionFromTop(ahJ, this.oKk.nxK.vlp);
                }
                return true;
            }
        };
        this.nxK.kR(true);
        this.nxK.vlz = new MMPullDownView.c(this) {
            final /* synthetic */ ReaderAppUI oKk;

            {
                this.oKk = r1;
            }

            public final boolean ako() {
                View childAt = this.oKk.nxG.getChildAt(this.oKk.nxG.getChildCount() - 1);
                if (childAt != null && childAt.getBottom() <= this.oKk.nxG.getHeight() && this.oKk.nxG.getLastVisiblePosition() == this.oKk.nxG.getAdapter().getCount() - 1) {
                    return true;
                }
                return false;
            }
        };
        this.nxK.vlA = new MMPullDownView.d(this) {
            final /* synthetic */ ReaderAppUI oKk;

            {
                this.oKk = r1;
            }

            public final boolean akn() {
                View childAt = this.oKk.nxG.getChildAt(this.oKk.nxG.getFirstVisiblePosition());
                if (childAt == null || childAt.getTop() != 0) {
                    return false;
                }
                return true;
            }
        };
        this.nxK.kP(true);
        this.oKf.uSN = new com.tencent.mm.ui.k.a(this) {
            final /* synthetic */ ReaderAppUI oKk;

            {
                this.oKk = r1;
            }

            public final void OH() {
                this.oKk.nxK.kO(this.oKk.oKf.ahI());
            }

            public final void OI() {
            }
        };
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ReaderAppUI oKk;

            {
                this.oKk = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oKk.finish();
                return true;
            }
        });
        a(0, R.l.dBM, R.k.dsW, new OnMenuItemClickListener(this) {
            final /* synthetic */ ReaderAppUI oKk;

            {
                this.oKk = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.plugin.readerapp.a.a.imv.d(new Intent().putExtra("Contact_User", this.oKk.neQ), this.oKk);
                return true;
            }
        });
        this.nxG.setSelection((this.oKf.aWc() - 1) + this.nxG.getHeaderViewsCount());
    }

    public final OnClickListener a(final bd bdVar, final int i, final int i2) {
        return new OnClickListener(this) {
            final /* synthetic */ ReaderAppUI oKk;

            public final void onClick(View view) {
                if (20 == i) {
                    Intent intent = new Intent();
                    intent.putExtra("mode", 1);
                    String url = bdVar.getUrl();
                    intent.putExtra("news_svr_id", bdVar.hnE);
                    intent.putExtra("news_svr_tweetid", bdVar.zD());
                    intent.putExtra("rawUrl", ReaderAppUI.a(this.oKk, url));
                    intent.putExtra("title", bdVar.getName());
                    intent.putExtra("webpageTitle", bdVar.getTitle());
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    Bundle bundle = new Bundle();
                    bundle.putInt("snsWebSource", 3);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("shortUrl", bdVar.zE());
                    intent.putExtra(Columns.TYPE, bdVar.type);
                    intent.putExtra("tweetid", bdVar.zD());
                    intent.putExtra("geta8key_username", "newsapp");
                    intent.putExtra("KPublisherId", "msg_" + Long.toString(bdVar.hnE));
                    intent.putExtra("pre_username", "newsapp");
                    intent.putExtra("prePublishId", "msg_" + Long.toString(bdVar.hnE));
                    intent.putExtra("preUsername", "newsapp");
                    intent.putExtra("preChatName", "newsapp");
                    intent.putExtra("preMsgIndex", i2);
                    com.tencent.mm.plugin.readerapp.a.a.imv.j(intent, this.oKk);
                }
            }
        };
    }

    public final void k(String str, Bitmap bitmap) {
        w.d("MicroMsg.ReaderAppUI", "onUpdate");
        if (this == null || isFinishing() || bitmap == null) {
            w.d("MicroMsg.ReaderAppUI", "readerappui is finish");
        } else {
            this.oKh.post(new Runnable(this) {
                final /* synthetic */ ReaderAppUI oKk;

                {
                    this.oKk = r1;
                }

                public final void run() {
                    if (this.oKk.oKf != null) {
                        this.oKk.oKf.notifyDataSetChanged();
                    }
                }
            });
        }
    }

    private PackageInfo Dh(String str) {
        PackageInfo packageInfo = null;
        if (str.length() != 0) {
            try {
                packageInfo = this.uSU.uTo.getPackageManager().getPackageInfo(str, 0);
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ReaderAppUI", e, "", new Object[0]);
            }
        }
        return packageInfo;
    }
}
