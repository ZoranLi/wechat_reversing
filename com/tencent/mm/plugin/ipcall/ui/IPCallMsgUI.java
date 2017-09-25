package com.tencent.mm.plugin.ipcall.ui;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import android.text.format.DateFormat;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.g.g;
import com.tencent.mm.plugin.ipcall.a.g.h;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.r;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class IPCallMsgUI extends MMActivity {
    private View koo;
    private boolean kop = true;
    private ListView mUX;
    private a mUY;
    private View mUZ;
    private com.tencent.mm.sdk.e.j.a mVa = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ IPCallMsgUI mVb;

        {
            this.mVb = r1;
        }

        public final void a(String str, l lVar) {
            new ae(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ AnonymousClass7 mVc;

                {
                    this.mVc = r1;
                }

                public final void run() {
                    synchronized (this.mVc.mVb.mUY) {
                        w.v("MicroMsg.IPCallMsgUI", "comment notify");
                        this.mVc.mVb.mUY.a(null, null);
                    }
                }
            });
        }
    };

    class a extends k<g> {
        int hOI = this.kor;
        protected f jVY;
        protected c jVZ;
        protected d jWb = new d(this) {
            final /* synthetic */ a mVe;

            {
                this.mVe = r1;
            }

            public final void a(MMSlideDelView mMSlideDelView, boolean z) {
                if (z) {
                    mVd.add(mMSlideDelView);
                } else {
                    mVd.remove(mMSlideDelView);
                }
            }

            public final boolean aFg() {
                return mVd.size() > 0;
            }

            public final void aFh() {
                for (MMSlideDelView mMSlideDelView : mVd) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.bSs();
                    }
                }
                mVd.clear();
            }

            public final void aFi() {
                for (MMSlideDelView mMSlideDelView : mVd) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.bSr();
                    }
                }
                mVd.clear();
            }
        };
        int kor = 10;
        final /* synthetic */ IPCallMsgUI mVb;
        private Set<MMSlideDelView> mVd = new HashSet();

        class a {
            TextView ioX;
            TextView iuD;
            TextView lle;
            final /* synthetic */ a mVe;

            a(a aVar) {
                this.mVe = aVar;
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (g) obj;
            if (obj == null) {
                obj = new g();
                w.d("MicroMsg.IPCallMsgUI", "new IPCallMsg");
            }
            obj.b(cursor);
            return obj;
        }

        public a(IPCallMsgUI iPCallMsgUI, Context context, g gVar) {
            this.mVb = iPCallMsgUI;
            super(context, gVar);
        }

        public final long getItemId(int i) {
            return ((g) getItem(i)).uxb;
        }

        protected final void OL() {
            aEW();
            OK();
        }

        public final void a(f fVar) {
            this.jVY = fVar;
        }

        public final void a(c cVar) {
            this.jVZ = cVar;
        }

        public final synchronized void a(String str, l lVar) {
            super.a(str, lVar);
        }

        public final void OK() {
            this.hOI = i.aEq().getCount();
            h aEq = i.aEq();
            int i = this.kor;
            setCursor(aEq.gUz.query("IPCallMsg", h.mRc, null, null, null, null, "pushTime desc limit " + i));
            notifyDataSetChanged();
        }

        public final boolean ahI() {
            return this.kor >= this.hOI;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            CharSequence charSequence;
            g gVar = (g) getItem(i);
            if (view == null || !(view.getTag() instanceof a)) {
                view = r.eC(this.context).inflate(R.i.dgn, null);
                aVar = new a(this);
                aVar.ioX = (TextView) view.findViewById(R.h.cIV);
                aVar.iuD = (TextView) view.findViewById(R.h.bGw);
                aVar.lle = (TextView) view.findViewById(R.h.cIn);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.ioX.setText(gVar.field_title);
            aVar.iuD.setText(gVar.field_content);
            TextView textView = aVar.lle;
            Context context = this.mVb.uSU.uTo;
            long j = gVar.field_pushTime * 1000;
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
            String str = (String) DateFormat.format(context.getString(R.l.elp), j);
            if (str.indexOf("-") > 0) {
                charSequence = (str.split("-")[1] + " " + com.tencent.mm.plugin.ipcall.b.c.an(context, str.split("-")[0]) + " ") + " " + ((String) com.tencent.mm.plugin.ipcall.b.c.g(context, j));
            } else {
                long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
                if (timeInMillis <= 0 || timeInMillis > 86400000) {
                    timeInMillis = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                    charSequence = (timeInMillis <= 0 || timeInMillis > 86400000) ? str + " " + ((String) com.tencent.mm.plugin.ipcall.b.c.g(context, j)) : context.getString(R.l.elH) + " " + ((String) com.tencent.mm.plugin.ipcall.b.c.g(context, j));
                } else {
                    charSequence = ((String) com.tencent.mm.plugin.ipcall.b.c.g(context, j));
                }
            }
            textView.setText(charSequence);
            if ((gVar.field_isRead == (short) 1 ? 1 : null) != null) {
                aVar.ioX.setTextColor(this.mVb.getResources().getColor(R.e.aUq));
            } else {
                aVar.ioX.setTextColor(this.mVb.getResources().getColor(R.e.aUr));
            }
            return view;
        }
    }

    protected final int Ol() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.dgo;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i.aEq().c(this.mVa);
        KC();
    }

    public void onDestroy() {
        w.d("MicroMsg.IPCallMsgUI", "msgui onDestroy");
        i.aEq().f(this.mVa);
        this.mUY.aEW();
        h aEq = i.aEq();
        ContentValues contentValues = new ContentValues();
        contentValues.put("isRead", Short.valueOf((short) 1));
        aEq.gUz.update(aEq.getTableName(), contentValues, "isRead!=? ", new String[]{"1"});
        super.onDestroy();
    }

    protected final void KC() {
        zi(R.l.euI);
        this.mUZ = findViewById(R.h.bYU);
        this.mUX = (ListView) findViewById(R.h.bYV);
        this.koo = r.eC(this).inflate(R.i.diz, null);
        this.mUX.addFooterView(this.koo);
        this.mUY = new a(this, this, new g());
        this.mUY.a(new c(this) {
            final /* synthetic */ IPCallMsgUI mVb;

            {
                this.mVb = r1;
            }

            public final int cb(View view) {
                return this.mVb.mUX.getPositionForView(view);
            }
        });
        this.mUY.a(new f(this) {
            final /* synthetic */ IPCallMsgUI mVb;

            {
                this.mVb = r1;
            }

            public final void s(View view, int i) {
                this.mVb.mUX.performItemClick(view, i, 0);
            }
        });
        this.mUY.uSN = new com.tencent.mm.ui.k.a(this) {
            final /* synthetic */ IPCallMsgUI mVb;

            {
                this.mVb = r1;
            }

            public final void OI() {
            }

            public final void OH() {
                if (this.mVb.mUY.getCount() == 0) {
                    this.mVb.mUX.setVisibility(8);
                    this.mVb.mUZ.setVisibility(0);
                    return;
                }
                this.mVb.mUX.setVisibility(0);
                this.mVb.mUZ.setVisibility(8);
            }
        };
        this.mUX.setAdapter(this.mUY);
        this.mUX.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ IPCallMsgUI mVb;

            {
                this.mVb = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                g gVar = (g) this.mVb.mUY.getItem(i);
                if (!bg.mA(gVar.field_descUrl)) {
                    int i2 = gVar.field_msgType;
                    com.tencent.mm.plugin.report.service.g.oUh.i(13780, new Object[]{Integer.valueOf(i2)});
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", gVar.field_descUrl);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.bb.d.b(this.mVb, "webview", ".ui.tools.WebViewUI", intent);
                }
            }
        });
        this.mUX.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ IPCallMsgUI mVb;

            {
                this.mVb = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    a b = this.mVb.mUY;
                    if (!b.ahI()) {
                        b.kor += 10;
                        if (b.kor > b.hOI) {
                            b.kor = b.hOI;
                        }
                    } else if (b.mVb.koo.getParent() != null) {
                        b.mVb.mUX.removeFooterView(b.mVb.koo);
                    }
                    this.mVb.mUY.a(null, null);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        if (this.mUY.getCount() == 0) {
            this.mUX.setVisibility(8);
            this.mUZ.setVisibility(0);
            kr(false);
        } else {
            this.mUX.setVisibility(0);
            this.mUZ.setVisibility(8);
            kr(true);
        }
        if (this.mUY.ahI()) {
            this.mUX.removeFooterView(this.koo);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallMsgUI mVb;

            {
                this.mVb = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mVb.finish();
                return true;
            }
        });
        if (this.mUY.ahI()) {
            this.mUX.removeFooterView(this.koo);
        }
    }
}
