package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.e;
import com.tencent.mm.protocal.c.awh;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import com.tencent.mm.ui.r;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public final class c extends com.tencent.mm.plugin.appbrand.widget.b.a {
    private final String iQO;
    private final String iQP;
    private AuthorizeItemListView jqq;
    private b jqr;
    private LinearLayout jqs;
    private Context mContext;

    public interface a {
        void c(int i, Bundle bundle);
    }

    private static final class b extends BaseAdapter {
        private LinkedList<awh> jqw;

        private static final class a {
            ImageView jqA;
            TextView jqB;
        }

        public final /* synthetic */ Object getItem(int i) {
            return iH(i);
        }

        b(LinkedList<awh> linkedList) {
            this.jqw = linkedList;
        }

        public final int getCount() {
            return this.jqw == null ? 0 : this.jqw.size();
        }

        private awh iH(int i) {
            return (awh) this.jqw.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (this.jqw == null || this.jqw.size() <= 0) {
                return null;
            }
            a aVar;
            final awh iH = iH(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(viewGroup.getContext(), R.i.cUW, null);
                aVar2.jqA = (ImageView) view.findViewById(R.h.boN);
                aVar2.jqB = (TextView) view.findViewById(R.h.boM);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (iH.tZA == 1) {
                aVar.jqA.setImageResource(R.k.dxA);
            } else if (iH.tZA == 3) {
                aVar.jqA.setImageResource(R.k.dxz);
            } else {
                aVar.jqA.setImageResource(R.k.dxy);
            }
            aVar.jqB.setText(iH.msk);
            final ImageView imageView = aVar.jqA;
            aVar.jqA.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ b jqz;

                public final void onClick(View view) {
                    if (iH.tZA == 2) {
                        imageView.setImageResource(R.k.dxA);
                        iH.tZA = 1;
                    } else if (iH.tZA == 1) {
                        imageView.setImageResource(R.k.dxy);
                        iH.tZA = 2;
                    }
                }
            });
            return view;
        }
    }

    public c(Context context, final LinkedList<awh> linkedList, String str, String str2, final a aVar) {
        super(context, (byte) 0);
        this.mContext = context;
        this.iQO = bg.mz(str);
        this.iQP = str2;
        if (linkedList == null || linkedList.size() <= 0) {
            throw new IllegalArgumentException("scopeInfoList is empty or null");
        }
        View view = (ViewGroup) r.eC(this.mContext).inflate(R.i.cTS, null);
        setContentView(view);
        com.tencent.mm.modelappbrand.a.b.AY().a((ImageView) view.findViewById(R.h.bpE), this.iQP, com.tencent.mm.modelappbrand.a.a.AX(), e.hqF);
        ((TextView) view.findViewById(R.h.bpK)).setText(this.mContext.getString(R.l.ewH, new Object[]{this.iQO}));
        this.jqq = (AuthorizeItemListView) view.findViewById(R.h.bqz);
        this.jqr = new b(linkedList);
        this.jqq.setAdapter(this.jqr);
        if (linkedList.size() > 5) {
            this.jqq.Ul = linkedList.size();
            this.jqs = (LinearLayout) view.findViewById(R.h.bqA);
            LayoutParams layoutParams = (LayoutParams) this.jqs.getLayoutParams();
            layoutParams.height = this.mContext.getResources().getDimensionPixelSize(R.f.bam);
            this.jqs.setLayoutParams(layoutParams);
        }
        ((Button) view.findViewById(R.h.ccz)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c jqv;

            public final void onClick(View view) {
                Serializable arrayList = new ArrayList();
                int i = 0;
                while (i < linkedList.size()) {
                    if (((awh) linkedList.get(i)).tZA == 2 || ((awh) linkedList.get(i)).tZA == 3) {
                        arrayList.add(((awh) linkedList.get(i)).tlA);
                    }
                    i++;
                }
                w.i("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
                Bundle bundle = new Bundle();
                bundle.putSerializable("key_scope", arrayList);
                aVar.c(1, bundle);
                this.dismiss();
            }
        });
        ((Button) view.findViewById(R.h.ccH)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ c jqv;

            public final void onClick(View view) {
                Serializable arrayList = new ArrayList();
                int i = 0;
                while (i < linkedList.size()) {
                    if (((awh) linkedList.get(i)).tZA == 2 || ((awh) linkedList.get(i)).tZA == 3) {
                        arrayList.add(((awh) linkedList.get(i)).tlA);
                    }
                    i++;
                }
                w.i("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
                Bundle bundle = new Bundle();
                bundle.putSerializable("key_scope", arrayList);
                aVar.c(2, bundle);
                this.dismiss();
            }
        });
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new OnCancelListener(this) {
            final /* synthetic */ c jqv;

            public final void onCancel(DialogInterface dialogInterface) {
                w.i("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
                aVar.c(3, null);
            }
        });
    }
}
