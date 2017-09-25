package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import com.tencent.mm.ui.MMActivity;

public class AppBrandSharedMessageUI extends MMActivity {
    private ListView Fg;
    private MRecyclerView iIM;

    public static class a extends android.support.v7.widget.RecyclerView.a {
        public final t a(ViewGroup viewGroup, int i) {
            return null;
        }

        public final void a(t tVar, int i) {
        }

        public final int getItemCount() {
            return 0;
        }

        public final int getItemViewType(int i) {
            return super.getItemViewType(i);
        }
    }

    private static class b extends BaseAdapter {
        private LayoutInflater Du;

        public b(LayoutInflater layoutInflater) {
            this.Du = layoutInflater;
        }

        public final int getCount() {
            return 0;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final int getItemViewType(int i) {
            return super.getItemViewType(i);
        }

        public final int getViewTypeCount() {
            return 4;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }

    protected final int getLayoutId() {
        return R.i.cUr;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Fg = (ListView) findViewById(R.h.cbt);
        this.iIM = (MRecyclerView) findViewById(R.h.bHG);
        this.Fg.setAdapter(new b(getLayoutInflater()));
        this.Fg.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ AppBrandSharedMessageUI jjH;

            {
                this.jjH = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.iIM.a(new LinearLayoutManager(1, false));
        this.iIM.a(new a());
        this.iIM.addHeaderView(getLayoutInflater().inflate(R.i.cUq, null));
    }
}
