package com.tencent.mm.plugin.sns.abtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.ui.r;

public class NotInterestMenu extends LinearLayout {
    private static int[] pNM = new int[]{j.pLm, j.pLk, j.pLl};
    private Context mContext = null;
    private ListView pNL;
    c pNN = null;
    b pNO = null;
    m pyJ = null;

    class a extends BaseAdapter {
        final /* synthetic */ NotInterestMenu pNP;

        class a {
            TextView pNQ;
            final /* synthetic */ a pNR;

            a(a aVar) {
                this.pNR = aVar;
            }
        }

        a(NotInterestMenu notInterestMenu) {
            this.pNP = notInterestMenu;
        }

        public final int getCount() {
            return NotInterestMenu.pNM.length;
        }

        public final Object getItem(int i) {
            return Integer.valueOf(NotInterestMenu.pNM[i]);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = r.eC(this.pNP.mContext).inflate(g.pGP, viewGroup, false);
                a aVar = new a(this);
                aVar.pNQ = (TextView) view.findViewById(f.pDq);
                view.setTag(aVar);
            }
            ((a) view.getTag()).pNQ.setText(NotInterestMenu.pNM[i]);
            return view;
        }
    }

    public interface b {
        void bdi();
    }

    public interface c {
        void c(m mVar);

        void d(m mVar);

        void e(m mVar);
    }

    public NotInterestMenu(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public NotInterestMenu(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        r.eC(this.mContext).inflate(g.pGO, this);
        this.pNL = (ListView) findViewById(f.pDp);
        this.pNL.setAdapter(new a(this));
        this.pNL.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ NotInterestMenu pNP;

            {
                this.pNP = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.pNP.pNO != null) {
                    this.pNP.pNO.bdi();
                }
                if (this.pNP.pNN != null) {
                    switch (i) {
                        case 0:
                            this.pNP.pNN.c(this.pNP.pyJ);
                            return;
                        case 1:
                            this.pNP.pNN.d(this.pNP.pyJ);
                            return;
                        case 2:
                            this.pNP.pNN.e(this.pNP.pyJ);
                            return;
                        default:
                            return;
                    }
                }
            }
        });
    }
}
