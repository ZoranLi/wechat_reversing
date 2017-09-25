package com.tencent.mm.plugin.order.ui;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderProductListUI extends WalletBaseUI {
    private String hiE = "";
    private List<ProductSectionItem> jkZ = new ArrayList();
    private String kAj = "";
    private BaseAdapter kjh;
    private ListView ohI;

    private class a extends BaseAdapter {
        final /* synthetic */ MallOrderProductListUI ohJ;

        private a(MallOrderProductListUI mallOrderProductListUI) {
            this.ohJ = mallOrderProductListUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return qW(i);
        }

        public final int getCount() {
            return this.ohJ.jkZ.size();
        }

        private ProductSectionItem qW(int i) {
            return (ProductSectionItem) this.ohJ.jkZ.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = View.inflate(this.ohJ, R.i.die, null);
                b bVar2 = new b(this.ohJ);
                bVar2.kow = (ImageView) view.findViewById(R.h.bZC);
                bVar2.ohK = (TextView) view.findViewById(R.h.bZB);
                bVar2.ohL = (TextView) view.findViewById(R.h.bZy);
                bVar2.ohM = (TextView) view.findViewById(R.h.bZD);
                bVar2.ohN = (TextView) view.findViewById(R.h.bZz);
                bVar2.ohO = (TextView) view.findViewById(R.h.bZE);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            ProductSectionItem qW = qW(i);
            bVar.kdG = qW.iconUrl;
            if (TextUtils.isEmpty(bVar.kdG) || !e.UI(bVar.kdG)) {
                bVar.kow.setImageResource(R.k.dxD);
            } else {
                bVar.kow.setImageBitmap(j.a(new com.tencent.mm.plugin.order.c.b(bVar.kdG)));
            }
            bVar.ohK.setText(qW.name);
            bVar.ohL.setText(Skus.aW(qW.ohn));
            bVar.ohM.setText(qW.oho);
            bVar.ohN.setText("+" + qW.count);
            j.a(bVar);
            bVar.ohO.setVisibility(8);
            return view;
        }
    }

    private class b implements com.tencent.mm.platformtools.j.a {
        String kdG;
        ImageView kow;
        final /* synthetic */ MallOrderProductListUI ohJ;
        TextView ohK;
        TextView ohL;
        TextView ohM;
        TextView ohN;
        TextView ohO;

        public b(MallOrderProductListUI mallOrderProductListUI) {
            this.ohJ = mallOrderProductListUI;
        }

        public final void k(String str, final Bitmap bitmap) {
            if (str != null && str.equals(this.kdG)) {
                this.kow.post(new Runnable(this) {
                    final /* synthetic */ b ohQ;

                    public final void run() {
                        this.ohQ.kow.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    static /* synthetic */ void a(MallOrderProductListUI mallOrderProductListUI, ProductSectionItem productSectionItem) {
        if (!c.ar(mallOrderProductListUI, productSectionItem.jumpUrl)) {
            c.as(mallOrderProductListUI, productSectionItem.ohp);
        }
    }

    public final boolean d(int i, int i2, String str, k kVar) {
        return false;
    }

    protected final int getLayoutId() {
        return R.i.did;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        re(0);
        KC();
    }

    @Deprecated
    protected final void KC() {
        zi(R.l.ezJ);
        Bundle bundle = this.uT;
        Collection parcelableArrayList = bundle.getParcelableArrayList("order_product_list");
        if (parcelableArrayList != null && parcelableArrayList.size() > 0) {
            this.jkZ.clear();
            this.jkZ.addAll(parcelableArrayList);
        }
        this.kAj = bundle.getString("key_trans_id");
        this.hiE = bundle.getString("appname");
        this.ohI = (ListView) findViewById(R.h.cqj);
        this.kjh = new a();
        this.ohI.setAdapter(this.kjh);
        this.kjh.notifyDataSetChanged();
        this.ohI.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MallOrderProductListUI ohJ;

            {
                this.ohJ = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ProductSectionItem productSectionItem = (ProductSectionItem) this.ohJ.jkZ.get(i);
                if (productSectionItem != null) {
                    MallOrderProductListUI.a(this.ohJ, productSectionItem);
                    c.a(Boolean.valueOf(false), this.ohJ.hiE, this.ohJ.kAj, productSectionItem.name, productSectionItem.ohp);
                }
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        if (com.tencent.mm.wallet_core.a.ai(this) instanceof com.tencent.mm.plugin.order.a.a) {
            com.tencent.mm.wallet_core.a.af(this);
        }
        return true;
    }
}
