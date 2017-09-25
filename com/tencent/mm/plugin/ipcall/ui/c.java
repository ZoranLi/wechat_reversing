package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.g.d;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.k;
import com.tencent.mm.x.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class c extends k<com.tencent.mm.plugin.ipcall.a.g.c> implements com.tencent.mm.x.d.a {
    static HashMap<String, com.tencent.mm.plugin.ipcall.a.g.c> mQV = null;
    private String isw;
    boolean kau = false;
    HashMap<String, Integer> kxs = new HashMap();
    private Context mContext;
    an mRA = new an();
    private d mRY;
    private HashMap<Long, com.tencent.mm.plugin.ipcall.a.g.c> mRZ = new HashMap();
    private HashSet<String> mSa = new HashSet();
    private boolean mSb = false;
    private OnClickListener mSc = new OnClickListener(this) {
        final /* synthetic */ c mSd;

        {
            this.mSd = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof Integer) {
                com.tencent.mm.plugin.ipcall.a.g.c on = this.mSd.on(((Integer) view.getTag()).intValue());
                Intent intent = new Intent(this.mSd.context, IPCallUserProfileUI.class);
                intent.putExtra("IPCallProfileUI_contactid", on.field_contactId);
                intent.putExtra("IPCallProfileUI_systemUsername", on.field_systemAddressBookUsername);
                intent.putExtra("IPCallProfileUI_wechatUsername", on.field_wechatUsername);
                this.mSd.context.startActivity(intent);
            }
        }
    };

    class a {
        final /* synthetic */ c mSd;
        String mSe;
        String mSf;

        public a(c cVar, String str, String str2) {
            this.mSd = cVar;
            this.mSf = str2;
            this.mSe = str;
        }
    }

    private class b {
        ImageView ioV;
        TextView jiJ;
        final /* synthetic */ c mSd;
        TextView mSg;
        LinearLayout mSh;
        TextView mSi;
        TextView mSj;
        TextView mSk;
        TextView mSl;
        ImageView mSm;
        View mSn;
        View mSp;
        View mSq;
        ImageView mSr;

        public b(c cVar) {
            this.mSd = cVar;
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (com.tencent.mm.plugin.ipcall.a.g.c) obj;
        if (obj == null) {
            obj = new com.tencent.mm.plugin.ipcall.a.g.c();
        }
        obj.b(cursor);
        return obj;
    }

    public final /* synthetic */ Object getItem(int i) {
        return on(i);
    }

    public c(Context context) {
        super(context, null);
        ko(true);
        this.mContext = context;
        this.mRY = new d(context);
        n.Bl().a(this);
    }

    public final int getCount() {
        return super.getCount();
    }

    public final int aEV() {
        return super.getCount();
    }

    public final com.tencent.mm.plugin.ipcall.a.g.c on(int i) {
        return (com.tencent.mm.plugin.ipcall.a.g.c) super.getItem(i);
    }

    public final void yD(String str) {
        this.isw = str;
        if (bg.mA(this.isw)) {
            this.mSb = false;
        } else {
            this.mSb = true;
        }
        this.uSM.clear();
        OK();
        notifyDataSetChanged();
    }

    public final void OK() {
        Cursor yv;
        Object obj = null;
        if (this.mSb) {
            this.kau = true;
            yv = i.aEn().yv(this.isw);
            this.kau = false;
        } else {
            yv = i.aEn().gUz.query("IPCallAddressItem", d.mQX, null, null, null, null, "upper(sortKey) asc");
        }
        if (yv != null) {
            yv.moveToFirst();
        }
        setCursor(yv);
        if (getCursor() != null) {
            Cursor cursor = getCursor();
            try {
                if (cursor.moveToFirst()) {
                    int i = 0;
                    while (!cursor.isAfterLast()) {
                        com.tencent.mm.plugin.ipcall.a.g.c cVar = new com.tencent.mm.plugin.ipcall.a.g.c();
                        cVar.b(cursor);
                        String yE = yE(cVar.field_sortKey);
                        if (i == 0) {
                            this.kxs.put(yE, Integer.valueOf(i));
                        } else if (obj != null) {
                            if (!yE.equals(obj)) {
                                this.kxs.put(yE, Integer.valueOf(i));
                            }
                        }
                        i++;
                        cursor.moveToNext();
                        String str = yE;
                    }
                }
            } catch (Exception e) {
                w.e("MicroMsg.IPCallAddressAdapter", "initSectionPosMap error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final void aEW() {
        super.aEW();
    }

    protected final void OL() {
        super.aEW();
        OK();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.i.dgk, viewGroup, false);
            b bVar = new b(this);
            bVar.mSp = view.findViewById(R.h.bZk);
            bVar.mSq = view.findViewById(R.h.bJJ);
            bVar.ioV = (ImageView) view.findViewById(R.h.bqM);
            bVar.jiJ = (TextView) view.findViewById(R.h.cof);
            bVar.mSg = (TextView) view.findViewById(R.h.crB);
            bVar.mSh = (LinearLayout) view.findViewById(R.h.cwh);
            bVar.mSi = (TextView) view.findViewById(R.h.cwi);
            bVar.mSj = (TextView) view.findViewById(R.h.cwj);
            bVar.mSk = (TextView) view.findViewById(R.h.bnH);
            bVar.mSl = (TextView) view.findViewById(R.h.bnB);
            bVar.mSm = (ImageView) view.findViewById(R.h.bnC);
            bVar.mSn = view.findViewById(R.h.bZm);
            bVar.mSn.setClickable(true);
            bVar.mSr = (ImageView) view.findViewById(R.h.divider);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        bVar2.mSn.setClickable(true);
        bVar2.mSn.setTag(Integer.valueOf(i));
        bVar2.mSr.setVisibility(8);
        if (nJ(i)) {
            bVar2.jiJ.setVisibility(8);
            bVar2.mSg.setVisibility(8);
            bVar2.mSh.setVisibility(8);
            bVar2.ioV.setVisibility(8);
            bVar2.ioV.setTag(null);
            bVar2.mSl.setVisibility(8);
            bVar2.mSk.setVisibility(8);
            bVar2.mSm.setVisibility(8);
        } else {
            com.tencent.mm.plugin.ipcall.a.g.c on = on(i);
            if (on != null) {
                CharSequence charSequence;
                if (bg.mA(on.field_systemAddressBookUsername)) {
                    bVar2.jiJ.setVisibility(8);
                    bVar2.mSg.setVisibility(8);
                } else {
                    bVar2.jiJ.setVisibility(0);
                    LayoutParams layoutParams;
                    RelativeLayout.LayoutParams layoutParams2;
                    if (this.mSb) {
                        bVar2.mSg.setVisibility(0);
                        layoutParams = (LayoutParams) bVar2.mSp.getLayoutParams();
                        layoutParams.height = (int) bVar2.mSg.getContext().getResources().getDimension(R.f.aYg);
                        bVar2.mSp.setLayoutParams(layoutParams);
                        layoutParams2 = (RelativeLayout.LayoutParams) bVar2.ioV.getLayoutParams();
                        layoutParams2.height = (int) bVar2.ioV.getContext().getResources().getDimension(R.f.aYd);
                        layoutParams2.width = (int) bVar2.ioV.getContext().getResources().getDimension(R.f.aYd);
                        bVar2.ioV.setLayoutParams(layoutParams2);
                    } else {
                        bVar2.mSg.setVisibility(8);
                        layoutParams = (LayoutParams) bVar2.mSp.getLayoutParams();
                        layoutParams.height = (int) bVar2.mSg.getContext().getResources().getDimension(R.f.aYf);
                        bVar2.mSp.setLayoutParams(layoutParams);
                        layoutParams2 = (RelativeLayout.LayoutParams) bVar2.ioV.getLayoutParams();
                        layoutParams2.height = (int) bVar2.ioV.getContext().getResources().getDimension(R.f.aYe);
                        layoutParams2.width = (int) bVar2.ioV.getContext().getResources().getDimension(R.f.aYe);
                        bVar2.ioV.setLayoutParams(layoutParams2);
                    }
                    if (this.mSb && on.mQW == null && mQV != null && mQV.containsKey(on.field_contactId)) {
                        on.mQW = ((com.tencent.mm.plugin.ipcall.a.g.c) mQV.get(on.field_contactId)).mQW;
                    } else if (this.mSb && on.mQW == null && (mQV == null || mQV.containsKey(on.field_contactId))) {
                        on.mQW = com.tencent.mm.plugin.ipcall.a.g.b.ys(on.field_contactId);
                    }
                    if (!bg.mA(this.isw) && (bg.k(this.isw.charAt(0)) || this.isw.startsWith("+"))) {
                        bVar2.mSg.setText(com.tencent.mm.as.d.a(a(on, this.isw), an.PA(this.isw)));
                        bVar2.jiJ.setText(com.tencent.mm.as.d.a(on.field_systemAddressBookUsername, this.isw));
                    } else if (!bg.mA(this.isw) && !bg.k(this.isw.charAt(0))) {
                        String str;
                        CharSequence charSequence2 = on.field_systemAddressBookUsername;
                        String str2 = on.field_systemAddressBookUsername;
                        CharSequence charSequence3 = this.isw;
                        if (bg.mA(charSequence3) || bg.mA(str2)) {
                            str = "";
                        } else {
                            if (!bg.PH(charSequence3) && bg.PI(charSequence3)) {
                                int i2;
                                int i3;
                                List arrayList = new ArrayList();
                                for (i2 = 0; i2 < str2.length(); i2++) {
                                    String substring = str2.substring(i2, i2 + 1);
                                    arrayList.add(new a(this, com.tencent.mm.platformtools.c.mp(substring), substring));
                                }
                                for (i2 = 2; i2 <= str2.length(); i2++) {
                                    for (i3 = 0; i3 <= str2.length() - i2; i3++) {
                                        String substring2 = str2.substring(i3, i3 + i2);
                                        arrayList.add(new a(this, com.tencent.mm.platformtools.c.mp(substring2), substring2));
                                    }
                                }
                                for (i3 = 0; i3 < arrayList.size(); i3++) {
                                    a aVar = (a) arrayList.get(i3);
                                    if (aVar.mSe.contains(charSequence3)) {
                                        str = aVar.mSf;
                                        break;
                                    }
                                }
                            }
                            charSequence = charSequence3;
                        }
                        bVar2.jiJ.setText(com.tencent.mm.as.d.a(charSequence2, str));
                        bVar2.mSg.setText(a(on, this.isw));
                    } else if (bg.mA(this.isw)) {
                        bVar2.jiJ.setText(on.field_systemAddressBookUsername);
                    }
                }
                ImageView imageView = bVar2.ioV;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    imageView.setTag(null);
                    imageView.setImageResource(R.g.bfX);
                    if (on != null) {
                        if (!bg.mA(on.field_contactId) && !bg.mA(on.field_wechatUsername)) {
                            this.mRY.a(on.field_contactId, on.field_wechatUsername, imageView);
                        } else if (!bg.mA(on.field_contactId)) {
                            this.mRY.b(on.field_contactId, imageView);
                        } else if (!bg.mA(on.field_wechatUsername)) {
                            this.mRY.c(on.field_wechatUsername, imageView);
                        }
                        if (!bg.mA(on.field_wechatUsername)) {
                            this.mSa.add(on.field_wechatUsername);
                        }
                    }
                }
                bVar2.mSh.setVisibility(8);
                charSequence = yE(on.field_sortKey);
                if (i == 0) {
                    bVar2.mSk.setVisibility(0);
                    bVar2.mSk.setText(charSequence);
                    bVar2.mSl.setVisibility(8);
                } else if (yE(on(i - 1).field_sortKey).equals(charSequence)) {
                    bVar2.mSk.setVisibility(8);
                    bVar2.mSk.setText("");
                    bVar2.mSl.setVisibility(8);
                } else {
                    bVar2.mSk.setVisibility(0);
                    bVar2.mSk.setText(charSequence);
                    bVar2.mSl.setVisibility(8);
                }
            }
            bVar2.mSn.setVisibility(8);
            bVar2.mSm.setVisibility(8);
            bVar2.mSm.setOnClickListener(this.mSc);
        }
        Object obj = 1;
        if (!(on(i + 1) == null || on(i) == null || yE(on(i + 1).field_sortKey).equals(yE(on(i).field_sortKey)))) {
            obj = null;
        }
        if (i + 1 == getCount() || r1 == null) {
            bVar2.mSq.setVisibility(8);
        } else {
            bVar2.mSq.setVisibility(0);
        }
        return view;
    }

    private static String a(com.tencent.mm.plugin.ipcall.a.g.c cVar, String str) {
        if (!(cVar == null || cVar.mQW == null)) {
            Iterator it = cVar.mQW.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2.contains(str)) {
                    return str2;
                }
            }
        }
        return null;
    }

    private static String yE(String str) {
        if (bg.mA(str)) {
            return "";
        }
        if (str.startsWith(com.tencent.mm.plugin.ipcall.a.g.b.kxq)) {
            return "#";
        }
        return str.toUpperCase().substring(0, 1);
    }

    public final int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    public final int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    public final void ho(String str) {
        if (this.mSa.contains(str)) {
            af.v(new Runnable(this) {
                final /* synthetic */ c mSd;

                {
                    this.mSd = r1;
                }

                public final void run() {
                    this.mSd.notifyDataSetChanged();
                }
            });
        }
    }

    public final void notifyDataSetChanged() {
        this.mRZ.clear();
        super.notifyDataSetChanged();
    }
}
