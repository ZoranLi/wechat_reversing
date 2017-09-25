package com.tencent.mm.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.a.a.c;
import com.tencent.mm.ah.n;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.o;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.widget.DragSortListView;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort3rdAppUI extends MMActivity {
    private DragSortListView kQI;
    private a uWr;
    private long uWs;
    private List<f> uWt;

    private static class a extends ArrayAdapter<f> {
        List<f> kIf;
        private c lir;
        private Context mContext;
        private long uWs;

        static class a {
            TextView ipw;
            ImageView jbU;
            View kIg;
            ImageView kIh;
            MMSwitchBtn std;

            public a(View view) {
                this.kIh = (ImageView) view.findViewById(R.h.bWo);
                this.jbU = (ImageView) view.findViewById(R.h.bWv);
                this.ipw = (TextView) view.findViewById(R.h.cIU);
                this.std = (MMSwitchBtn) view.findViewById(R.h.cGY);
                this.kIg = view.findViewById(R.h.bGr);
            }
        }

        public a(Context context, List<f> list, long j) {
            super(context, R.i.doO, list);
            this.uWs = j;
            this.mContext = context;
            this.kIf = list;
            com.tencent.mm.ah.a.a.c.a aVar = new com.tencent.mm.ah.a.a.c.a();
            aVar.hJa = R.g.bhr;
            this.lir = aVar.Hg();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            boolean z = true;
            if (view == null) {
                view = View.inflate(this.mContext, R.i.doO, null);
                a aVar2 = new a(view);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            final f fVar = (f) getItem(i);
            aVar.ipw.setText(fVar.field_appName);
            Bitmap b = g.b(fVar.field_appId, 1, com.tencent.mm.bg.a.getDensity(this.mContext));
            if (b == null || b.isRecycled()) {
                n.GW().a(fVar.field_appIconUrl, aVar.jbU, this.lir);
            } else {
                aVar.jbU.setImageBitmap(b);
            }
            MMSwitchBtn mMSwitchBtn = aVar.std;
            if ((fVar.field_appInfoFlag & 16384) != 0) {
                z = false;
            }
            mMSwitchBtn.lS(z);
            aVar.std.wwD = new com.tencent.mm.ui.widget.MMSwitchBtn.a(this) {
                final /* synthetic */ a uWx;

                public final void bK(boolean z) {
                    f fVar;
                    if (z) {
                        fVar = fVar;
                        fVar.field_appInfoFlag &= -16385;
                    } else {
                        fVar = fVar;
                        fVar.field_appInfoFlag |= 16384;
                    }
                    an.aRr().a(fVar, new String[0]);
                }
            };
            view.setVisibility(0);
            return view;
        }
    }

    protected final int getLayoutId() {
        return R.i.doN;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.uWs = getIntent().getLongExtra("KFlag", -1);
        KC();
        this.uWt = g.b((Context) this, this.uWs, true);
        final List ef = an.bDl().ef(this.uWs);
        if (ef != null && ef.size() > 0) {
            Collections.sort(this.uWt, new Comparator<f>(this) {
                final /* synthetic */ Sort3rdAppUI uWu;

                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    return ef.indexOf(((f) obj2).field_appId) - ef.indexOf(((f) obj).field_appId);
                }
            });
        }
        this.uWr = new a(this, this.uWt, this.uWs);
        this.kQI.setAdapter(this.uWr);
    }

    protected final void KC() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ Sort3rdAppUI uWu;

            {
                this.uWu = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.uWu.finish();
                return true;
            }
        });
        qP(getString(R.l.dBM));
        this.kQI = (DragSortListView) findViewById(R.h.cbx);
        this.kQI.wta = new DragSortListView.g(this) {
            final /* synthetic */ Sort3rdAppUI uWu;

            {
                this.uWu = r1;
            }

            public final void bQ(int i, int i2) {
                f fVar = (f) this.uWu.uWr.getItem(i);
                this.uWu.uWr.remove(fVar);
                this.uWu.uWr.insert(fVar, i2);
            }
        };
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onPause() {
        super.onPause();
        if (this.uWr != null) {
            List list = this.uWr.kIf;
            o bDl = an.bDl();
            long j = this.uWs;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("delete from AppSort");
            stringBuilder.append(" where flag = ").append(j).append(" ");
            bDl.gUz.eE("AppSort", stringBuilder.toString());
            if (list != null && list.size() > 0) {
                ap.yY();
                j = com.tencent.mm.u.c.wO().cs(Thread.currentThread().getId());
                o bDl2 = an.bDl();
                for (int i = 0; i < list.size(); i++) {
                    com.tencent.mm.pluginsdk.model.app.n nVar = new com.tencent.mm.pluginsdk.model.app.n();
                    nVar.field_flag = this.uWs;
                    nVar.field_appId = ((f) list.get(i)).field_appId;
                    nVar.field_sortId = i;
                    bDl2.a(nVar);
                }
                ap.yY();
                com.tencent.mm.u.c.wO().aD(j);
            }
        }
    }
}
