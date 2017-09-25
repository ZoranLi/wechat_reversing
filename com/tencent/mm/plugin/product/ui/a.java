package com.tencent.mm.plugin.product.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a extends BaseAdapter {
    private Context oqt;
    private List<com.tencent.mm.plugin.product.c.a> oqu;
    private List<Boolean> oqv;
    private int oqw = 1;

    public final /* synthetic */ Object getItem(int i) {
        return rf(i);
    }

    public a(Context context) {
        this.oqt = context;
    }

    public final void aZ(List<com.tencent.mm.plugin.product.c.a> list) {
        this.oqu = list;
        this.oqw = 0;
        this.oqv = new ArrayList();
        if (this.oqu != null) {
            Set hashSet = new HashSet();
            for (com.tencent.mm.plugin.product.c.a aVar : list) {
                this.oqv.add(Boolean.valueOf(false));
                hashSet.add(Integer.valueOf(aVar.jOc));
            }
            this.oqw = list.size();
        }
        if (this.oqw <= 0) {
            this.oqw = 1;
        }
    }

    public final void a(Activity activity, View view, int i) {
        b bVar = (b) view.getTag();
        w.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.type" + bVar.type);
        w.i("MicroMsg.MallCustomActionAdapter", "onItemClick holder.content" + bVar.oqA);
        Intent intent;
        switch (bVar.type) {
            case 0:
                return;
            case 1:
                if (bVar.oqA instanceof String) {
                    intent = new Intent();
                    intent.putExtra("rawUrl", (String) bVar.oqA);
                    intent.putExtra("showShare", false);
                    d.b(this.oqt, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent, 10000);
                    return;
                }
                return;
            case 2:
                if (bVar.oqA instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) bVar.oqA;
                    intent = new Intent(activity, MallGalleryUI.class);
                    intent.putExtra("keys_img_urls", arrayList);
                    activity.startActivity(intent);
                    return;
                }
                return;
            case 4:
            case 6:
                if (bVar.oqA instanceof String) {
                    String str = (String) bVar.oqA;
                    Intent intent2 = new Intent();
                    intent2.putExtra("title", bVar.title);
                    intent2.putExtra("neverGetA8Key", false);
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("show_bottom", false);
                    intent2.putExtra(SlookAirButtonFrequentContactAdapter.DATA, str);
                    intent2.putExtra("QRDataFlag", false);
                    d.b(activity, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent2);
                    return;
                }
                return;
            case 5:
                if (((Boolean) this.oqv.get(i)).booleanValue()) {
                    this.oqv.set(i, Boolean.valueOf(false));
                } else {
                    this.oqv.set(i, Boolean.valueOf(true));
                }
                notifyDataSetChanged();
                return;
            default:
                w.w("MicroMsg.MallCustomActionAdapter", "not support type");
                return;
        }
    }

    public final int getCount() {
        return this.oqu != null ? this.oqu.size() : 0;
    }

    private com.tencent.mm.plugin.product.c.a rf(int i) {
        return (com.tencent.mm.plugin.product.c.a) this.oqu.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getViewTypeCount() {
        return this.oqw;
    }

    public final int getItemViewType(int i) {
        return rf(i).jOc;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.oqt, R.i.dlb, null);
            bVar = new b();
            bVar.jhl = (TextView) view.findViewById(R.h.cJh);
            bVar.oqx = (TextView) view.findViewById(R.h.cGP);
            bVar.oqy = (ImageView) view.findViewById(R.h.bXw);
            bVar.oqz = (HtmlTextView) view.findViewById(R.h.bIB);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        com.tencent.mm.plugin.product.c.a rf = rf(i);
        if (rf != null) {
            bVar.jhl.setText(rf.msj);
            bVar.oqx.setText(rf.opH);
            bVar.type = rf.jOc;
            bVar.oqA = rf.opI;
            bVar.title = rf.msj;
            switch (rf.jOc) {
                case 0:
                    bVar.oqy.setVisibility(8);
                    break;
                case 5:
                case 6:
                    if (((Boolean) this.oqv.get(i)).booleanValue()) {
                        bVar.oqz.setVisibility(0);
                    } else {
                        bVar.oqz.setVisibility(8);
                    }
                    if (!bVar.oqz.getText().equals(rf.opI)) {
                        bVar.oqz.setText(rf.opI);
                        break;
                    }
                    break;
            }
        }
        return view;
    }
}
