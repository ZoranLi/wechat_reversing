package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.b.a.k;
import android.view.LayoutInflater;
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
import com.tencent.mm.protocal.c.awh;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.AuthorizeItemListView;
import com.tencent.mm.ui.base.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public final class e {
    private Context context;
    private String iQO = "";
    private String iQP;
    public AuthorizeItemListView jqq;
    private LinearLayout jqs;
    private b snG;

    public interface a {
        void c(int i, Bundle bundle);
    }

    private class b extends BaseAdapter {
        private LinkedList<awh> jqw;
        final /* synthetic */ e snI;

        private class a {
            ImageView jqA;
            TextView jqB;
            final /* synthetic */ b snJ;

            public a(b bVar) {
                this.snJ = bVar;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return iH(i);
        }

        public b(e eVar, LinkedList<awh> linkedList) {
            this.snI = eVar;
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
                a aVar2 = new a(this);
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
                final /* synthetic */ b snJ;

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

    public e(Context context) {
        this.context = context;
    }

    public final boolean a(LinkedList<awh> linkedList, String str, String str2, String str3, a aVar) {
        w.d("MicroMsg.AppBrandAuthorizeDialog", "stev AppBrandAuthorizeDialog showAlert!");
        this.iQO = str;
        this.iQP = str2;
        return a(str3, linkedList, aVar);
    }

    public final boolean a(LinkedList<awh> linkedList, String str, String str2, a aVar) {
        return a(linkedList, str, str2, null, aVar);
    }

    private boolean a(String str, final LinkedList<awh> linkedList, final a aVar) {
        if (linkedList == null || linkedList.size() <= 0) {
            w.e("MicroMsg.AppBrandAuthorizeDialog", "scopeInfoList is empty or null");
            return false;
        }
        final i iVar = new i(this.context, R.m.foM);
        LinearLayout linearLayout = (LinearLayout) ((LayoutInflater) this.context.getSystemService("layout_inflater")).inflate(R.i.cUV, null);
        TextView textView = (TextView) linearLayout.findViewById(R.h.cSM);
        if (!bg.mA(str)) {
            textView.setText(str);
        }
        ImageView imageView = (ImageView) linearLayout.findViewById(R.h.bpE);
        Drawable a = k.a(ab.getResources(), com.tencent.mm.compatible.f.a.decodeResource(ab.getResources(), R.k.dtD));
        a.bt();
        if (imageView != null) {
            com.tencent.mm.modelappbrand.a.b.AY().a(imageView, this.iQP, a, com.tencent.mm.modelappbrand.a.e.hqF);
        }
        textView = (TextView) linearLayout.findViewById(R.h.bpK);
        if (this.iQO == null) {
            this.iQO = "";
        }
        textView.setText(this.context.getString(R.l.ewH, new Object[]{this.iQO}));
        this.jqq = (AuthorizeItemListView) linearLayout.findViewById(R.h.bqz);
        this.snG = new b(this, linkedList);
        this.jqq.setAdapter(this.snG);
        if (linkedList.size() > 5) {
            this.jqq.Ul = linkedList.size();
            this.jqs = (LinearLayout) linearLayout.findViewById(R.h.bqA);
            LayoutParams layoutParams = (LayoutParams) this.jqs.getLayoutParams();
            layoutParams.height = this.context.getResources().getDimensionPixelSize(R.f.bam);
            this.jqs.setLayoutParams(layoutParams);
        }
        ((Button) linearLayout.findViewById(R.h.ccz)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ e snI;

            public final void onClick(View view) {
                Serializable arrayList = new ArrayList();
                int i = 0;
                while (i < linkedList.size()) {
                    if (((awh) linkedList.get(i)).tZA == 2 || ((awh) linkedList.get(i)).tZA == 3) {
                        arrayList.add(((awh) linkedList.get(i)).tlA);
                    }
                    i++;
                }
                w.d("MicroMsg.AppBrandAuthorizeDialog", "stev acceptButton click!");
                Bundle bundle = new Bundle();
                bundle.putSerializable("key_scope", arrayList);
                aVar.c(1, bundle);
                iVar.dismiss();
            }
        });
        ((Button) linearLayout.findViewById(R.h.ccH)).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ e snI;

            public final void onClick(View view) {
                Serializable arrayList = new ArrayList();
                int i = 0;
                while (i < linkedList.size()) {
                    if (((awh) linkedList.get(i)).tZA == 2 || ((awh) linkedList.get(i)).tZA == 3) {
                        arrayList.add(((awh) linkedList.get(i)).tlA);
                    }
                    i++;
                }
                w.d("MicroMsg.AppBrandAuthorizeDialog", "stev rejectButton click!");
                Bundle bundle = new Bundle();
                bundle.putSerializable("key_scope", arrayList);
                aVar.c(2, bundle);
                iVar.dismiss();
            }
        });
        iVar.setCanceledOnTouchOutside(false);
        iVar.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ e snI;

            {
                this.snI = r1;
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                if (this.snI.jqq != null) {
                    this.snI.jqq.setAdapter(null);
                }
            }
        });
        iVar.setOnCancelListener(new OnCancelListener(this) {
            final /* synthetic */ e snI;

            public final void onCancel(DialogInterface dialogInterface) {
                w.d("MicroMsg.AppBrandAuthorizeDialog", "stev dialog onCancel");
                aVar.c(3, null);
            }
        });
        iVar.setContentView(linearLayout);
        try {
            iVar.show();
            return true;
        } catch (Exception e) {
            w.e("MicroMsg.AppBrandAuthorizeDialog", "dialog show failed %s", new Object[]{e.getMessage()});
            return false;
        }
    }
}
