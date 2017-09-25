package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.k;
import com.tencent.mm.x.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class h extends k<c> implements com.tencent.mm.x.d.a {
    private static HashMap<String, c> mQV = null;
    private boolean kau = false;
    private d mRY;
    private HashMap<Long, c> mRZ = new HashMap();
    private HashSet<String> mSa = new HashSet();
    private boolean mSb = false;
    ArrayList<com.tencent.mm.plugin.ipcall.a.g.k> mVI;
    private OnClickListener mVJ = new OnClickListener(this) {
        final /* synthetic */ h mVK;

        {
            this.mVK = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof Integer) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (com.tencent.mm.plugin.ipcall.b.c.cu(this.mVK.context)) {
                    com.tencent.mm.plugin.ipcall.a.g.k ou = this.mVK.ou(intValue);
                    c cVar = null;
                    if (ou.field_addressId > 0) {
                        if (this.mVK.mRZ.containsKey(Long.valueOf(ou.field_addressId))) {
                            cVar = (c) this.mVK.mRZ.get(Long.valueOf(ou.field_addressId));
                        } else {
                            cVar = i.aEn().cr(ou.field_addressId);
                        }
                        if (cVar != null) {
                            this.mVK.mRZ.put(Long.valueOf(ou.field_addressId), cVar);
                        }
                    }
                    Intent intent;
                    if (cVar != null) {
                        intent = new Intent(this.mVK.context, IPCallTalkUI.class);
                        intent.putExtra("IPCallTalkUI_phoneNumber", ou.field_phonenumber);
                        intent.putExtra("IPCallTalkUI_contactId", cVar.field_contactId);
                        intent.putExtra("IPCallTalkUI_nickname", cVar.field_systemAddressBookUsername);
                        intent.putExtra("IPCallTalkUI_toWechatUsername", cVar.field_wechatUsername);
                        intent.putExtra("IPCallTalkUI_dialScene", 3);
                        g.oUh.i(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3)});
                        ((FragmentActivity) this.mVK.context).startActivityForResult(intent, MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
                        return;
                    }
                    intent = new Intent(this.mVK.context, IPCallTalkUI.class);
                    intent.putExtra("IPCallTalkUI_phoneNumber", ou.field_phonenumber);
                    intent.putExtra("IPCallTalkUI_dialScene", 3);
                    g.oUh.i(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3)});
                    ((FragmentActivity) this.mVK.context).startActivityForResult(intent, MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
                }
            }
        }
    };

    private class a {
        ImageView ioV;
        TextView jiJ;
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
        final /* synthetic */ h mVK;

        public a(h hVar) {
            this.mVK = hVar;
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (c) obj;
        if (obj == null) {
            obj = new c();
        }
        obj.b(cursor);
        return obj;
    }

    public h(Context context) {
        super(context, null);
        ko(true);
        this.mRY = new d(context);
        n.Bl().a(this);
    }

    protected final void OL() {
        this.mVI = m.aEQ();
    }

    public final void OK() {
        this.mVI = m.aEQ();
    }

    public final int getCount() {
        if (this.mVI == null) {
            this.mVI = m.aEQ();
        }
        if (this.mVI != null) {
            return this.mVI.size();
        }
        return 0;
    }

    public final com.tencent.mm.plugin.ipcall.a.g.k ou(int i) {
        return (com.tencent.mm.plugin.ipcall.a.g.k) this.mVI.get(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.i.dgk, viewGroup, false);
            a aVar = new a(this);
            aVar.mSp = view.findViewById(R.h.bZk);
            aVar.mSq = view.findViewById(R.h.bJJ);
            aVar.ioV = (ImageView) view.findViewById(R.h.bqM);
            aVar.jiJ = (TextView) view.findViewById(R.h.cof);
            aVar.mSg = (TextView) view.findViewById(R.h.crB);
            aVar.mSh = (LinearLayout) view.findViewById(R.h.cwh);
            aVar.mSi = (TextView) view.findViewById(R.h.cwi);
            aVar.mSj = (TextView) view.findViewById(R.h.cwj);
            aVar.mSk = (TextView) view.findViewById(R.h.bnH);
            aVar.mSl = (TextView) view.findViewById(R.h.bnB);
            aVar.mSm = (ImageView) view.findViewById(R.h.bnC);
            aVar.mSn = view.findViewById(R.h.bZm);
            aVar.mSn.setClickable(true);
            aVar.mSr = (ImageView) view.findViewById(R.h.divider);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        aVar2.mSn.setClickable(true);
        aVar2.mSn.setTag(Integer.valueOf(i));
        aVar2.mSr.setVisibility(8);
        if (nJ(i)) {
            aVar2.jiJ.setVisibility(8);
            aVar2.mSg.setVisibility(8);
            aVar2.mSh.setVisibility(8);
            aVar2.ioV.setVisibility(8);
            aVar2.ioV.setTag(null);
            aVar2.mSl.setVisibility(8);
            aVar2.mSk.setVisibility(8);
            aVar2.mSm.setVisibility(8);
        } else {
            com.tencent.mm.plugin.ipcall.a.g.k ou = ou(i);
            if (ou != null) {
                c cr;
                if (i == 0) {
                    aVar2.mSl.setVisibility(0);
                    aVar2.mSk.setVisibility(8);
                    aVar2.mSl.setText(this.context.getString(R.l.eub));
                } else {
                    aVar2.mSl.setVisibility(8);
                    aVar2.mSk.setVisibility(8);
                }
                aVar2.mSr.setVisibility(0);
                aVar2.jiJ.setVisibility(0);
                LayoutParams layoutParams = (LayoutParams) aVar2.mSp.getLayoutParams();
                layoutParams.height = (int) aVar2.mSg.getContext().getResources().getDimension(R.f.aYf);
                aVar2.mSp.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aVar2.ioV.getLayoutParams();
                layoutParams2.height = (int) aVar2.ioV.getContext().getResources().getDimension(R.f.aYe);
                layoutParams2.width = (int) aVar2.ioV.getContext().getResources().getDimension(R.f.aYe);
                aVar2.ioV.setLayoutParams(layoutParams2);
                if (ou.field_addressId > 0) {
                    cr = this.mRZ.containsKey(Long.valueOf(ou.field_addressId)) ? (c) this.mRZ.get(Long.valueOf(ou.field_addressId)) : i.aEn().cr(ou.field_addressId);
                    if (cr != null) {
                        this.mRZ.put(Long.valueOf(ou.field_addressId), cr);
                        aVar2.jiJ.setText(cr.field_systemAddressBookUsername);
                    }
                } else {
                    aVar2.jiJ.setText(com.tencent.mm.plugin.ipcall.b.a.yY(ou.field_phonenumber));
                    cr = null;
                }
                aVar2.mSg.setVisibility(8);
                aVar2.mSh.setVisibility(0);
                aVar2.mSj.setText(com.tencent.mm.plugin.ipcall.b.c.cv(ou.field_calltime));
                if (ou.field_duration > 0) {
                    aVar2.mSi.setText(com.tencent.mm.plugin.ipcall.b.c.cx(ou.field_duration));
                } else {
                    aVar2.mSi.setText(com.tencent.mm.plugin.ipcall.b.c.oz(ou.field_status));
                }
                ImageView imageView = aVar2.ioV;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    imageView.setTag(null);
                    imageView.setImageResource(R.g.bfX);
                    if (cr != null) {
                        if (!bg.mA(cr.field_contactId) && !bg.mA(cr.field_wechatUsername)) {
                            this.mRY.a(cr.field_contactId, cr.field_wechatUsername, imageView);
                        } else if (!bg.mA(cr.field_contactId)) {
                            this.mRY.b(cr.field_contactId, imageView);
                        } else if (!bg.mA(cr.field_wechatUsername)) {
                            this.mRY.c(cr.field_wechatUsername, imageView);
                        }
                        if (!bg.mA(cr.field_wechatUsername)) {
                            this.mSa.add(cr.field_wechatUsername);
                        }
                    }
                }
            }
            aVar2.mSn.setVisibility(0);
            aVar2.mSm.setVisibility(0);
            aVar2.mSn.setOnClickListener(this.mVJ);
        }
        return view;
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
                final /* synthetic */ h mVK;

                {
                    this.mVK = r1;
                }

                public final void run() {
                    this.mVK.notifyDataSetChanged();
                }
            });
        }
    }

    public final void notifyDataSetChanged() {
        this.mVI = m.aEQ();
        this.mRZ.clear();
        super.notifyDataSetChanged();
    }
}
