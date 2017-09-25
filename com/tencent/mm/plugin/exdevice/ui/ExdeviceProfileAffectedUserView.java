package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.MMHorList;
import com.tencent.mm.x.h;
import com.tencent.mm.x.i;
import com.tencent.mm.x.n;
import java.util.ArrayList;

public class ExdeviceProfileAffectedUserView extends LinearLayout {
    String jia;
    private TextView llM;
    private MMHorList llN;
    private a llO;
    private ArrayList<String> llP;

    private class a extends BaseAdapter {
        final /* synthetic */ ExdeviceProfileAffectedUserView llQ;
        private Runnable llR;

        class a {
            ImageView hBi;
            final /* synthetic */ a llS;

            a(a aVar) {
                this.llS = aVar;
            }
        }

        private a(ExdeviceProfileAffectedUserView exdeviceProfileAffectedUserView) {
            this.llQ = exdeviceProfileAffectedUserView;
            this.llR = new Runnable(this) {
                final /* synthetic */ a llS;

                {
                    this.llS = r1;
                }

                public final void run() {
                    this.llS.notifyDataSetChanged();
                }
            };
        }

        public final /* synthetic */ Object getItem(int i) {
            return hO(i);
        }

        public final int getCount() {
            return this.llQ.llP == null ? 0 : this.llQ.llP.size();
        }

        private String hO(int i) {
            return (String) this.llQ.llP.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            String hO = hO(i);
            if (view == null) {
                view = LayoutInflater.from(this.llQ.getContext()).inflate(R.i.dbM, viewGroup, false);
                a aVar2 = new a(this);
                aVar2.hBi = (ImageView) view.findViewById(R.h.bqG);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            Runnable runnable = this.llR;
            i Bm = n.Bm();
            if (Bm != null) {
                h hs = Bm.hs(hO);
                if (hs == null || bg.mA(hs.Bt())) {
                    com.tencent.mm.u.ag.a.hlS.a(hO, "", new com.tencent.mm.plugin.exdevice.model.f.AnonymousClass1(bg.Nz(), runnable));
                }
            }
            b.n(aVar.hBi, hO);
            return view;
        }
    }

    public ExdeviceProfileAffectedUserView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.i.dbH, this, true);
        this.llM = (TextView) inflate.findViewById(R.h.csQ);
        this.llN = (MMHorList) inflate.findViewById(R.h.csP);
        int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(context, 44);
        this.llN.vkI = true;
        this.llN.vkJ = fromDPToPix;
        this.llN.vkH = true;
        this.llO = new a();
        this.llN.setAdapter(this.llO);
        this.llN.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ExdeviceProfileAffectedUserView llQ;

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                String str = (String) adapterView.getAdapter().getItem(i);
                w.d("MicroMsg.ExdeviceProfileAffectedUserView", "onItemClick, username : %s", new Object[]{str});
                if (bg.mA(str)) {
                    w.w("MicroMsg.ExdeviceProfileAffectedUserView", "username is null.");
                    return;
                }
                Intent intent = new Intent(context, ExdeviceProfileUI.class);
                intent.putExtra("username", str);
                context.startActivity(intent);
            }
        });
        this.llM.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExdeviceProfileAffectedUserView llQ;

            {
                this.llQ = r1;
            }

            public final void onClick(View view) {
                String xL = m.xL();
                if (xL != null && xL.equals(this.llQ.jia)) {
                    this.llQ.llN.setVisibility(this.llQ.llN.getVisibility() == 0 ? 8 : 0);
                }
            }
        });
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ExdeviceProfileAffectedUserView llQ;

            {
                this.llQ = r1;
            }

            public final void onClick(View view) {
                this.llQ.llM.performClick();
            }
        });
        setVisibility(8);
    }

    public final void y(ArrayList<String> arrayList) {
        this.llP = arrayList;
        if (this.llP == null || this.llP.size() == 0) {
            this.llM.setText("");
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.llM.setText(getResources().getString(R.l.ego, new Object[]{Integer.valueOf(this.llP.size())}));
        this.llO.notifyDataSetChanged();
    }
}
