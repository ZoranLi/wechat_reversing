package com.tencent.mm.plugin.wallet.bind.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.ui.view.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import java.util.ArrayList;
import java.util.List;

public class a extends BaseAdapter {
    private final Context mContext;
    private int mCount = 0;
    private ArrayList<Bankcard> rwt;
    private int rwu;
    com.tencent.mm.plugin.wallet_core.d.a rwv;
    List<String> rww;

    class a {
        public RelativeLayout rwA = null;
        public ImageView rwB = null;
        public ImageView rwC = null;
        public TextView rwD = null;
        public TextView rwE = null;
        public TextView rwF = null;
        public ImageView rwG = null;
        public ImageView rwH = null;
        public ImageView rwI = null;
        final /* synthetic */ a rwJ;
        public TextView rwx = null;
        public TextView rwy = null;
        public TextView rwz = null;

        a(a aVar) {
            this.rwJ = aVar;
        }
    }

    public /* synthetic */ Object getItem(int i) {
        return vs(i);
    }

    public a(Context context, ArrayList<Bankcard> arrayList) {
        this.mContext = context;
        this.rwt = arrayList;
        this.rwu = 0;
        this.rwv = new com.tencent.mm.plugin.wallet_core.d.a();
        this.rwv.b(this.mContext, this.rwt);
        bsr();
    }

    public final void T(ArrayList<Bankcard> arrayList) {
        this.rwt = arrayList;
        if (arrayList != null) {
            this.mCount = arrayList.size();
        } else {
            this.mCount = 0;
        }
        if (this.mCount > 0) {
            this.rwv.b(this.mContext, this.rwt);
        }
        bsr();
    }

    private void bsr() {
        ap.yY();
        this.rww = bg.f(((String) c.vr().get(com.tencent.mm.storage.w.a.uIv, "")).split(","));
    }

    public int getCount() {
        return this.mCount;
    }

    private Bankcard vs(int i) {
        if (i < 0 || i >= this.mCount) {
            return null;
        }
        return (Bankcard) this.rwt.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getItemViewType(int i) {
        Bankcard vs = vs(i);
        if (vs == null) {
            return 4;
        }
        if (vs.field_bankcardState == 9) {
            if (vs.field_wxcreditState == 0) {
                return 2;
            }
            return 3;
        } else if (vs.btz() && "CITIC_CREDIT".equals(vs.field_bankcardType)) {
            return 5;
        } else {
            if (!vs.btD() || m.xY()) {
                return 1;
            }
            return 0;
        }
    }

    public int getViewTypeCount() {
        return 6;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        boolean z;
        Bankcard vs = vs(i);
        int itemViewType = getItemViewType(i);
        if (this.rww == null || this.rww.isEmpty() || vs == null) {
            z = false;
        } else {
            for (String equals : this.rww) {
                if (equals.equals(vs.field_bindSerial)) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        w.v("MicroMsg.BankcardListAdapter", "getView, pos: %d, bottom_wording: %s, showNew: %s", new Object[]{Integer.valueOf(i), vs.field_card_bottom_wording, Boolean.valueOf(z)});
        int i2;
        a aVar;
        switch (itemViewType) {
            case 0:
                return b.a(this.mContext, view, vs, R.i.dqd, this.rwv, z);
            case 1:
                return b.a(this.mContext, view, vs, R.i.dqh, this.rwv, z);
            case 2:
                i2 = R.i.dqj;
                if (view == null || view.getTag() == null) {
                    view = View.inflate(this.mContext, i2, null);
                    a aVar2 = new a(this);
                    aVar2.rwC = (ImageView) view.findViewById(R.h.brY);
                    aVar2.rwy = (TextView) view.findViewById(R.h.brZ);
                    aVar2.rwF = (TextView) view.findViewById(R.h.cnP);
                    aVar2.rwG = (ImageView) view.findViewById(R.h.bsi);
                    aVar2.rwH = (ImageView) view.findViewById(R.h.bsj);
                    aVar2.rwI = (ImageView) view.findViewById(R.h.bsk);
                    view.setTag(aVar2);
                    aVar = aVar2;
                } else {
                    aVar = (a) view.getTag();
                }
                aVar.rwy.setText(this.mContext.getString(R.l.ffU, new Object[]{vs.field_bankName}));
                if (b.a(vs)) {
                    aVar.rwF.setVisibility(0);
                    return view;
                }
                aVar.rwF.setVisibility(8);
                return view;
            case 3:
                i2 = R.i.dql;
                if (view == null || view.getTag() == null) {
                    view = View.inflate(this.mContext, i2, null);
                    a aVar3 = new a(this);
                    aVar3.rwC = (ImageView) view.findViewById(R.h.brY);
                    aVar3.rwy = (TextView) view.findViewById(R.h.brZ);
                    aVar3.rwD = (TextView) view.findViewById(R.h.bsg);
                    aVar3.rwG = (ImageView) view.findViewById(R.h.bsi);
                    aVar3.rwH = (ImageView) view.findViewById(R.h.bsj);
                    aVar3.rwI = (ImageView) view.findViewById(R.h.bsk);
                    view.setTag(aVar3);
                    aVar = aVar3;
                } else {
                    aVar = (a) view.getTag();
                }
                switch (vs.field_wxcreditState) {
                    case 1:
                        aVar.rwD.setBackgroundResource(R.g.blN);
                        aVar.rwD.setVisibility(0);
                        break;
                    case 3:
                        aVar.rwD.setBackgroundResource(R.g.blI);
                        aVar.rwD.setVisibility(0);
                        break;
                    default:
                        aVar.rwD.setVisibility(8);
                        break;
                }
                aVar.rwy.setText(vs.field_bankName);
                this.rwv.a(this.mContext, vs, aVar.rwC);
                return view;
            case 4:
                return View.inflate(this.mContext, R.i.dqe, null);
            case 5:
                return b.a(this.mContext, view, vs, R.i.dqk, this.rwv, z);
            default:
                return view;
        }
    }
}
