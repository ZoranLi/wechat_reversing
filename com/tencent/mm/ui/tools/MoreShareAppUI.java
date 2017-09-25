package com.tencent.mm.ui.tools;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.DragSortListView;
import com.tencent.mm.ui.widget.DragSortListView.g;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.List;

public class MoreShareAppUI extends MMActivity {
    private DragSortListView kQI;
    private List<f> uWt;
    private a wnv;

    private static class a extends ArrayAdapter<f> {
        private List<f> kIf;
        private Context mContext;

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

        public a(Context context, List<f> list) {
            super(context, R.i.djE, list);
            this.mContext = context;
            this.kIf = list;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = View.inflate(this.mContext, R.i.djE, null);
                a aVar2 = new a(view);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.ipw.setText(((f) getItem(i)).field_appName);
            view.setVisibility(0);
            return view;
        }
    }

    protected final int getLayoutId() {
        return R.i.djD;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ MoreShareAppUI wnw;

            {
                this.wnw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.wnw.finish();
                return true;
            }
        });
        a(0, getString(R.l.ecV), new OnMenuItemClickListener(this) {
            final /* synthetic */ MoreShareAppUI wnw;

            {
                this.wnw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });
        this.wnv = new a(this, this.uWt);
        this.kQI.setAdapter(this.wnv);
    }

    protected final void KC() {
        zi(R.l.dPH);
        this.kQI = (DragSortListView) findViewById(R.h.cbx);
        this.kQI.wta = new g(this) {
            final /* synthetic */ MoreShareAppUI wnw;

            {
                this.wnw = r1;
            }

            public final void bQ(int i, int i2) {
                f fVar = (f) this.wnw.wnv.getItem(i);
                this.wnw.wnv.kIf.remove(i);
                this.wnw.wnv.notifyDataSetChanged();
                this.wnw.wnv.insert(fVar, i2);
            }
        };
    }
}
