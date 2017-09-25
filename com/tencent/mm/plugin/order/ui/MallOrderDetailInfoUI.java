package com.tencent.mm.plugin.order.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.mm.plugin.order.model.f;
import com.tencent.mm.plugin.order.model.h;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.y.k;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderDetailInfoUI extends WalletBaseUI implements com.tencent.mm.platformtools.j.a {
    private ListView Fg;
    private OnClickListener iuW = new OnClickListener(this) {
        final /* synthetic */ MallOrderDetailInfoUI ohH;

        {
            this.ohH = r1;
        }

        public final void onClick(View view) {
            if (view.getId() == R.h.cpQ) {
                if (this.ohH.ogH.ofx != null) {
                    c.ar(this.ohH, this.ohH.ogH.ofx.msF);
                    c.a(Boolean.valueOf(this.ohH.ohB), this.ohH.ogH.fKK, this.ohH.kAj, this.ohH.ogH.ofx.ofF, "");
                }
            } else if (view.getId() == R.h.cqe || view.getId() == R.h.cqd) {
                if (this.ohH.ogH.ofy != null && this.ohH.ogH.ofy.size() > 0) {
                    boolean z;
                    if (TextUtils.isEmpty(((ProductSectionItem) this.ohH.ogH.ofy.get(0)).jumpUrl)) {
                        z = false;
                    } else {
                        z = c.ar(this.ohH, ((ProductSectionItem) this.ohH.ogH.ofy.get(0)).jumpUrl);
                    }
                    if (!z) {
                        c.as(this.ohH, ((ProductSectionItem) this.ohH.ogH.ofy.get(0)).ohp);
                    }
                    c.a(Boolean.valueOf(this.ohH.ohB), this.ohH.ogH.fKK, this.ohH.kAj, ((ProductSectionItem) this.ohH.ogH.ofy.get(0)).name, "");
                }
            } else if (view.getId() == R.h.cqc) {
                Bundle bundle = this.ohH.uT;
                bundle.putParcelableArrayList("order_product_list", this.ohH.ogH.ofy);
                bundle.putInt("key_enter_id", 0);
                bundle.putString("key_trans_id", this.ohH.kAj);
                bundle.putString("appname", this.ohH.ogH.fKK);
                com.tencent.mm.wallet_core.a.k(this.ohH, new Bundle());
                c.a(Boolean.valueOf(this.ohH.ohB), this.ohH.ogH.fKK, this.ohH.kAj, this.ohH.getResources().getString(R.l.ezJ), "");
            } else if (view.getId() == R.h.cql) {
                String string = this.ohH.uT.getString("key_trans_id");
                Bundle bundle2 = this.ohH.uT;
                bundle2.putString("key_trans_id", string);
                bundle2.putInt("key_enter_id", 1);
                if (this.ohH.ogH != null) {
                    bundle2.putParcelable("transaction_data", this.ohH.ogH.ofw);
                }
                com.tencent.mm.wallet_core.a.k(this.ohH, bundle2);
                c.a(Boolean.valueOf(this.ohH.ohB), this.ohH.ogH.fKK, this.ohH.kAj, this.ohH.getResources().getString(R.l.ezI), "");
            } else if (view.getId() == R.h.cpO) {
                g.a(this.ohH, "商家已退全款，总价125元，包含商品价格115元，邮费10元，请确认是否同意通过该处理结果。", this.ohH.getString(R.l.ezB), this.ohH.getString(R.l.ezK), this.ohH.getString(R.l.ezL), new DialogInterface.OnClickListener(this.ohH) {
                    final /* synthetic */ MallOrderDetailInfoUI ohH;

                    {
                        this.ohH = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                }, new DialogInterface.OnClickListener(this.ohH) {
                    final /* synthetic */ MallOrderDetailInfoUI ohH;

                    {
                        this.ohH = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            } else if (view.getId() == R.h.bWq) {
                if (this.ohH.ogH != null && this.ohH.ogH.ofD != null) {
                    this.ohH.ohs = this.ohH.ogH.ofD;
                    MallOrderDetailInfoUI.c(this.ohH);
                    c.a(Boolean.valueOf(this.ohH.ohB), this.ohH.ogH.fKK, this.ohH.kAj, this.ohH.getResources().getString(R.l.ezH), "");
                }
            } else if (view.getId() == R.h.cTl) {
                e.Q(this.ohH, this.ohH.ogH.fKK);
                c.a(Boolean.valueOf(this.ohH.ohB), this.ohH.ogH.fKK, this.ohH.kAj, this.ohH.getResources().getString(R.l.ezN), "");
            }
        }
    };
    private String kAj = "";
    private HashMap<String, View> odL = new HashMap();
    private List<com.tencent.mm.plugin.order.model.MallOrderDetailObject.a> ofz = new ArrayList();
    protected MallOrderDetailObject ogH = null;
    private View ohA;
    private boolean ohB = false;
    private boolean ohC = false;
    private int ohD = 0;
    private CheckedTextView ohE;
    private CheckedTextView ohF;
    OnClickListener ohG = new OnClickListener(this) {
        final /* synthetic */ MallOrderDetailInfoUI ohH;

        {
            this.ohH = r1;
        }

        public final void onClick(View view) {
            if (this.ohH.ohE != null && this.ohH.ohF != null) {
                if (view.getId() == R.h.cpK) {
                    this.ohH.ohE.setSelected(true);
                    this.ohH.ohF.setSelected(false);
                    this.ohH.ohD = 100;
                    return;
                }
                this.ohH.ohE.setSelected(false);
                this.ohH.ohF.setSelected(true);
                this.ohH.ohD = -100;
            }
        }
    };
    String ohs;
    private a oht;
    private View ohu;
    private View ohv;
    private View ohw;
    private View ohx;
    private View ohy;
    private View ohz;

    private class a extends BaseAdapter {
        final /* synthetic */ MallOrderDetailInfoUI ohH;

        private a(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
            this.ohH = mallOrderDetailInfoUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return qV(i);
        }

        public final int getCount() {
            return this.ohH.ofz.size();
        }

        private com.tencent.mm.plugin.order.model.MallOrderDetailObject.a qV(int i) {
            return (com.tencent.mm.plugin.order.model.MallOrderDetailObject.a) this.ohH.ofz.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            com.tencent.mm.plugin.order.model.MallOrderDetailObject.a qV = qV(i);
            View findViewById;
            switch (qV.type) {
                case 1:
                    view = View.inflate(this.ohH, R.i.dhR, null);
                    findViewById = view.findViewById(R.h.cpI);
                    this.ohH.ohE = (CheckedTextView) view.findViewById(R.h.cpK);
                    this.ohH.ohF = (CheckedTextView) view.findViewById(R.h.cpH);
                    this.ohH.ohE.setOnClickListener(this.ohH.ohG);
                    this.ohH.ohF.setOnClickListener(this.ohH.ohG);
                    if (i + 1 < getCount()) {
                        MallOrderDetailInfoUI.a(findViewById, qV(i + 1));
                        break;
                    }
                    break;
                case 2:
                    view = View.inflate(this.ohH, R.i.dhQ, null);
                    TextView textView = (TextView) view.findViewById(R.h.cpH);
                    findViewById = view.findViewById(R.h.cpI);
                    if (bg.getInt(qV.value, 0) >= 0) {
                        textView.setText(R.l.ezD);
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.k.dxE, 0);
                    } else {
                        textView.setText(R.l.ezC);
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.k.dxC, 0);
                    }
                    if (i + 1 < getCount()) {
                        MallOrderDetailInfoUI.a(findViewById, qV(i + 1));
                        break;
                    }
                    break;
                default:
                    b bVar;
                    if (view == null) {
                        view = View.inflate(this.ohH, R.i.dhP, null);
                        b bVar2 = new b(this.ohH);
                        bVar2.koz = (TextView) view.findViewById(R.h.cpM);
                        bVar2.kpx = (TextView) view.findViewById(R.h.cpL);
                        bVar2.kpy = (TextView) view.findViewById(R.h.cpJ);
                        bVar2.jIM = view.findViewById(R.h.cpI);
                        view.setTag(bVar2);
                        bVar = bVar2;
                    } else {
                        bVar = (b) view.getTag();
                    }
                    bVar.koz.setText(qV.name);
                    if (TextUtils.isEmpty(qV.value)) {
                        bVar.kpx.setVisibility(4);
                    } else {
                        bVar.kpx.setVisibility(0);
                        bVar.kpx.setText(qV.value);
                    }
                    if (qV.kdT) {
                        bVar.kpy.setVisibility(0);
                    } else {
                        bVar.kpy.setVisibility(8);
                    }
                    if (i + 1 < getCount()) {
                        MallOrderDetailInfoUI.a(bVar.jIM, qV(i + 1));
                        break;
                    }
                    break;
            }
            return view;
        }

        public final int getItemViewType(int i) {
            return qV(i).type;
        }

        public final int getViewTypeCount() {
            return 3;
        }
    }

    private class b {
        View jIM;
        TextView koz;
        TextView kpx;
        TextView kpy;
        final /* synthetic */ MallOrderDetailInfoUI ohH;

        public b(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
            this.ohH = mallOrderDetailInfoUI;
        }
    }

    static /* synthetic */ void c(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        if (!TextUtils.isEmpty(mallOrderDetailInfoUI.ohs)) {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(mallOrderDetailInfoUI.ohs).toString()));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            mallOrderDetailInfoUI.startActivity(intent);
        }
    }

    static /* synthetic */ void d(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        Context context = mallOrderDetailInfoUI;
        g.a(context, "", new String[]{mallOrderDetailInfoUI.getString(R.l.ezM)}, "", false, new g.c(mallOrderDetailInfoUI) {
            final /* synthetic */ MallOrderDetailInfoUI ohH;

            {
                this.ohH = r1;
            }

            public final void hq(int i) {
                switch (i) {
                    case 0:
                        c.aq(this.ohH, this.ohH.ogH.ofC);
                        return;
                    default:
                        return;
                }
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dhX;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.wallet_core.b ai = com.tencent.mm.wallet_core.a.ai(this);
        if (ai != null && (ai instanceof com.tencent.mm.plugin.order.a.a)) {
            String string = this.uT.getString("key_trans_id");
            this.kAj = string;
            if (string != null) {
                com.tencent.mm.plugin.order.a.b.aRw();
                if (!com.tencent.mm.plugin.order.a.b.aRz().Cp(string)) {
                    this.ohB = false;
                    k(new h(string));
                }
            }
            com.tencent.mm.plugin.order.a.b.aRw();
            if (com.tencent.mm.plugin.order.a.b.aRz().Cp(string)) {
                MallOrderDetailObject mallOrderDetailObject;
                this.ohB = true;
                com.tencent.mm.plugin.order.a.b.aRw();
                com.tencent.mm.plugin.order.model.c aRz = com.tencent.mm.plugin.order.a.b.aRz();
                if (TextUtils.isEmpty(string)) {
                    mallOrderDetailObject = null;
                } else {
                    w.v("MicroMsg.MallPayMsgManager", "getMallOrderDetailObjectByMsgId msgId:" + string);
                    mallOrderDetailObject = com.tencent.mm.plugin.order.model.c.a(aRz.Cq(string));
                }
                this.ogH = mallOrderDetailObject;
                if (this.ogH == null) {
                    aRJ();
                }
            } else {
                w.w("MicroMsg.MallOrderDetailInfoUI", "mOrders info is Illegal!");
                aRJ();
            }
        }
        KC();
    }

    protected final void KC() {
        if (this.ohB) {
            com.tencent.mm.plugin.order.a.b.aRw();
            j Cq = com.tencent.mm.plugin.order.a.b.aRz().Cq(this.kAj);
            int intValue = (Cq == null || TextUtils.isEmpty(Cq.ohd) || !c.tb(Cq.ohd)) ? -1 : Integer.valueOf(Cq.ohd).intValue();
            if (intValue == 2) {
                zi(R.l.ezE);
            } else if (intValue == 1) {
                zi(R.l.ezF);
            }
        } else {
            zi(R.l.ezG);
        }
        this.ohu = findViewById(R.h.cpQ);
        this.ohv = findViewById(R.h.cpP);
        this.ohz = findViewById(R.h.cqe);
        this.ohA = findViewById(R.h.cqc);
        this.ohy = findViewById(R.h.cqd);
        this.ohw = findViewById(R.h.cql);
        this.ohx = findViewById(R.h.cqk);
        this.ohu.setOnClickListener(this.iuW);
        this.ohA.setOnClickListener(this.iuW);
        this.ohz.setOnClickListener(this.iuW);
        this.ohy.setOnClickListener(this.iuW);
        this.ohw.setOnClickListener(this.iuW);
        findViewById(R.h.cpO).setOnClickListener(this.iuW);
        findViewById(R.h.bWq).setOnClickListener(this.iuW);
        findViewById(R.h.cTl).setOnClickListener(this.iuW);
        this.Fg = (ListView) findViewById(R.h.cpN);
        this.oht = new a();
        this.Fg.setAdapter(this.oht);
        this.oht.notifyDataSetChanged();
        this.Fg.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ MallOrderDetailInfoUI ohH;

            {
                this.ohH = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                com.tencent.mm.plugin.order.model.MallOrderDetailObject.a aVar = (com.tencent.mm.plugin.order.model.MallOrderDetailObject.a) this.ohH.ofz.get(i);
                if (!TextUtils.isEmpty(aVar.jumpUrl)) {
                    c.ar(this.ohH, aVar.jumpUrl);
                }
                c.a(Boolean.valueOf(this.ohH.ohB), this.ohH.ogH.fKK, this.ohH.kAj, aVar.name, "");
            }
        });
        aRH();
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

    public final boolean d(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            return false;
        }
        if (kVar instanceof h) {
            MallOrderDetailObject mallOrderDetailObject = ((h) kVar).ogH;
            w.d("MicroMsg.MallOrderDetailInfoUI", "tempObject:" + mallOrderDetailObject);
            if (mallOrderDetailObject != null) {
                this.ogH = mallOrderDetailObject;
                aRH();
            }
        }
        return true;
    }

    private void aRH() {
        if (this.ogH != null) {
            com.tencent.mm.platformtools.j.a(this);
            this.odL.clear();
            com.tencent.mm.plugin.order.model.MallOrderDetailObject.b bVar = this.ogH.ofx;
            if (bVar != null) {
                CharSequence charSequence;
                String str = bVar.ofF;
                if (TextUtils.isEmpty(bVar.ofG)) {
                    Object obj = str;
                } else {
                    charSequence = str + "：" + bVar.ofG;
                }
                if (this.ohB) {
                    this.ohu.setVisibility(8);
                    this.ohv.setVisibility(0);
                    ((TextView) this.ohv.findViewById(R.h.cpS)).setText(charSequence);
                    ((TextView) this.ohv.findViewById(R.h.cpR)).setText(e.CK(this.ogH.ofE));
                    if (TextUtils.isEmpty(bVar.thumbUrl) || !e.UI(bVar.thumbUrl)) {
                        e((ImageView) this.ohv.findViewById(R.h.cqb));
                    } else {
                        k((ImageView) this.ohv.findViewById(R.h.cqb), bVar.thumbUrl);
                    }
                } else {
                    this.ohv.setVisibility(8);
                    this.ohu.setVisibility(0);
                    ((TextView) this.ohu.findViewById(R.h.cpS)).setText(charSequence);
                    ((TextView) this.ohu.findViewById(R.h.cpR)).setText(e.CK(this.ogH.ofE));
                    if (TextUtils.isEmpty(bVar.thumbUrl) || !e.UI(bVar.thumbUrl)) {
                        e((ImageView) this.ohu.findViewById(R.h.cqb));
                    } else {
                        k((ImageView) this.ohu.findViewById(R.h.cqb), bVar.thumbUrl);
                    }
                }
            } else {
                this.ohu.setVisibility(8);
                this.ohv.setVisibility(8);
            }
            List list = this.ogH.ofy;
            if (list == null || list.size() == 0) {
                this.ohy.setVisibility(8);
                this.ohz.setVisibility(8);
                this.ohA.setVisibility(8);
            } else if (list.size() == 1) {
                this.ohA.setVisibility(8);
                ProductSectionItem productSectionItem = (ProductSectionItem) list.get(0);
                if (TextUtils.isEmpty(productSectionItem.iconUrl)) {
                    this.ohz.setVisibility(8);
                    this.ohy.setVisibility(0);
                    ((TextView) this.ohy.findViewById(R.h.bZB)).setText(productSectionItem.name);
                    if (TextUtils.isEmpty(productSectionItem.jumpUrl)) {
                        Rect rect = new Rect();
                        rect.set(this.ohy.findViewById(R.h.bZA).getPaddingLeft(), this.ohy.findViewById(R.h.bZA).getPaddingTop(), this.ohy.findViewById(R.h.bZA).getPaddingRight(), this.ohy.findViewById(R.h.bZA).getPaddingBottom());
                        this.ohy.findViewById(R.h.bZA).setBackgroundResource(R.g.bgh);
                        this.ohy.findViewById(R.h.bZA).setPadding(rect.left, rect.top, rect.right, rect.bottom);
                    } else {
                        ((TextView) this.ohy.findViewById(R.h.bZB)).setTextColor(getResources().getColor(R.e.aUW));
                    }
                } else {
                    this.ohy.setVisibility(8);
                    this.ohz.setVisibility(0);
                    ((TextView) this.ohz.findViewById(R.h.bZB)).setText(productSectionItem.name);
                    ((TextView) this.ohz.findViewById(R.h.bZD)).setText(productSectionItem.oho);
                    ((TextView) this.ohz.findViewById(R.h.bZz)).setText("+" + productSectionItem.count);
                    ((TextView) this.ohz.findViewById(R.h.bZy)).setText(Skus.aW(productSectionItem.ohn));
                    if (!TextUtils.isEmpty(productSectionItem.iconUrl)) {
                        k((ImageView) this.ohz.findViewById(R.h.bZC), productSectionItem.iconUrl);
                    }
                }
            } else {
                this.ohy.setVisibility(8);
                this.ohz.setVisibility(8);
                this.ohA.setVisibility(0);
                if (list.size() == 2) {
                    a(this.ohA.findViewById(R.h.cqf), (ProductSectionItem) list.get(0));
                    a(this.ohA.findViewById(R.h.cqg), (ProductSectionItem) list.get(1));
                    this.ohA.findViewById(R.h.cqh).setVisibility(8);
                    this.ohA.findViewById(R.h.cqi).setVisibility(8);
                } else if (list.size() == 3) {
                    a(this.ohA.findViewById(R.h.cqf), (ProductSectionItem) list.get(0));
                    a(this.ohA.findViewById(R.h.cqg), (ProductSectionItem) list.get(1));
                    a(this.ohA.findViewById(R.h.cqh), (ProductSectionItem) list.get(2));
                    this.ohA.findViewById(R.h.cqi).setVisibility(8);
                } else if (list.size() >= 4) {
                    a(this.ohA.findViewById(R.h.cqf), (ProductSectionItem) list.get(0));
                    a(this.ohA.findViewById(R.h.cqg), (ProductSectionItem) list.get(1));
                    a(this.ohA.findViewById(R.h.cqh), (ProductSectionItem) list.get(2));
                    a(this.ohA.findViewById(R.h.cqi), (ProductSectionItem) list.get(3));
                }
            }
            MallTransactionObject mallTransactionObject = this.ogH.ofw;
            if (mallTransactionObject != null) {
                this.ohw.setVisibility(0);
                ((TextView) findViewById(R.h.cqm)).setText(e.d(mallTransactionObject.kBc, mallTransactionObject.oga));
                if (!(this.ogH == null || this.ogH.ofz == null || this.ogH.ofz.size() <= 0)) {
                    a(this.ohx, (com.tencent.mm.plugin.order.model.MallOrderDetailObject.a) this.ogH.ofz.get(0));
                }
            } else {
                this.ohw.setVisibility(8);
            }
            Collection collection = this.ogH.ofz;
            if (collection != null) {
                this.ofz.addAll(collection);
                this.oht.notifyDataSetChanged();
            }
            findViewById(R.h.chx).setVisibility(0);
            if (this.ogH != null && TextUtils.isEmpty(this.ogH.ofD) && TextUtils.isEmpty(this.ogH.fKK)) {
                findViewById(R.h.chx).setVisibility(8);
            } else if (this.ogH != null && !TextUtils.isEmpty(this.ogH.ofD) && TextUtils.isEmpty(this.ogH.fKK)) {
                findViewById(R.h.cTl).setVisibility(8);
                findViewById(R.h.cTk).setVisibility(8);
                r0 = (TextView) findViewById(R.h.bWq);
                r0.setVisibility(0);
                r0.setGravity(3);
            } else if (!(this.ogH == null || !TextUtils.isEmpty(this.ogH.ofD) || TextUtils.isEmpty(this.ogH.fKK))) {
                findViewById(R.h.bWq).setVisibility(8);
                findViewById(R.h.cTk).setVisibility(8);
                r0 = (TextView) findViewById(R.h.cTl);
                r0.setVisibility(0);
                r0.setGravity(3);
            }
            if (this.ogH != null && !TextUtils.isEmpty(this.ogH.ofC)) {
                a(0, R.g.bhb, new OnMenuItemClickListener(this) {
                    final /* synthetic */ MallOrderDetailInfoUI ohH;

                    {
                        this.ohH = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        MallOrderDetailInfoUI.d(this.ohH);
                        return true;
                    }
                });
            }
        }
    }

    private void a(View view, ProductSectionItem productSectionItem) {
        if (view != null && productSectionItem != null) {
            view.setVisibility(0);
            TextView textView = (TextView) view.findViewById(R.h.bZB);
            if (textView != null) {
                textView.setText(productSectionItem.name);
            }
            if (!TextUtils.isEmpty(productSectionItem.iconUrl)) {
                k((ImageView) view.findViewById(R.h.bZC), productSectionItem.iconUrl);
            }
        }
    }

    private void k(ImageView imageView, String str) {
        if (imageView != null && !TextUtils.isEmpty(str) && e.UI(str)) {
            imageView.setImageBitmap(com.tencent.mm.platformtools.j.a(new com.tencent.mm.plugin.order.c.b(str)));
            this.odL.put(str, imageView);
        }
    }

    private static void a(View view, com.tencent.mm.plugin.order.model.MallOrderDetailObject.a aVar) {
        if (aVar != null) {
            Rect rect = new Rect();
            rect.left = view.getPaddingLeft();
            rect.right = view.getPaddingRight();
            rect.top = view.getPaddingTop();
            rect.bottom = view.getPaddingBottom();
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (aVar == null || !aVar.kdT) {
                view.setBackgroundResource(R.g.bgh);
            } else {
                view.setBackgroundResource(R.g.bhc);
            }
            view.setLayoutParams(layoutParams);
            view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public final void k(String str, Bitmap bitmap) {
        ImageView imageView = (ImageView) this.odL.get(str);
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }

    private void e(ImageView imageView) {
        Bitmap decodeResource = com.tencent.mm.compatible.f.a.decodeResource(getResources(), R.k.dxF);
        if (decodeResource != null) {
            imageView.setImageBitmap(d.a(decodeResource, false, 96.0f));
        }
    }

    private void aRI() {
        if (!this.ohC && this.ohD != 0) {
            ap.vd().a(new f(this.kAj, "", this.ohD), 0);
            this.ohC = true;
        }
    }

    public void finish() {
        aRI();
        super.finish();
    }

    public void onDestroy() {
        aRI();
        super.onDestroy();
    }

    public final void qU(int i) {
        finish();
    }

    private void aRJ() {
        g.a(this.uSU.uTo, R.l.fgY, 0, new DialogInterface.OnClickListener(this) {
            final /* synthetic */ MallOrderDetailInfoUI ohH;

            {
                this.ohH = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.ohH.finish();
            }
        });
    }
}
