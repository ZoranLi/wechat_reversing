package com.tencent.mm.plugin.order.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.a.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.List;

public final class b implements a {
    public final List<Preference> a(final Context context, final f fVar, final MallTransactionObject mallTransactionObject) {
        f fVar2;
        f fVar3;
        List<Preference> arrayList = new ArrayList();
        boolean z = mallTransactionObject.fyT == 2;
        if (!(bg.mA(mallTransactionObject.ogc) || bg.mA(mallTransactionObject.iEP))) {
            d dVar = new d(context);
            dVar.lia = mallTransactionObject.iEP;
            dVar.mName = mallTransactionObject.ogc;
            dVar.mOnClickListener = new OnClickListener(this) {
                final /* synthetic */ b oio;

                public final void onClick(View view) {
                    if (!bg.mA(mallTransactionObject.ogb)) {
                        e.P(context, mallTransactionObject.ogb);
                    }
                }
            };
            arrayList.add(dVar);
            arrayList.add(new PreferenceSmallCategory(context));
        }
        w.i("MicroMsg.FetchOrderPrefFactory", "getOrderPrefList() chargeFee is " + mallTransactionObject.ogr + " and fetchTotalFee is " + mallTransactionObject.ogB);
        h hVar;
        if (TextUtils.isEmpty(mallTransactionObject.ogr)) {
            CharSequence string;
            boolean z2;
            i iVar = new i(context);
            iVar.oiI = e.d(mallTransactionObject.kBc, mallTransactionObject.oga);
            if (z) {
                string = context.getString(R.l.fgP);
            } else {
                string = context.getString(R.l.fgZ);
            }
            iVar.setTitle(string);
            if (!bg.mA(mallTransactionObject.ofS)) {
                iVar.Cu(mallTransactionObject.ofS);
            }
            arrayList.add(iVar);
            if (mallTransactionObject.kBc == mallTransactionObject.ogg || mallTransactionObject.ogg <= 0.0d) {
                z2 = false;
            } else {
                hVar = new h(context);
                hVar.oiF = false;
                hVar.oiG = true;
                arrayList.add(hVar);
                fVar2 = new f(context);
                fVar2.setContent(e.d(mallTransactionObject.ogg, mallTransactionObject.oga));
                fVar2.setTitle(R.l.fhh);
                arrayList.add(fVar2);
                if (!bg.mA(mallTransactionObject.ogf)) {
                    g gVar = new g(context);
                    gVar.setTitle(R.l.fgW);
                    gVar.jid = fVar;
                    String[] split = mallTransactionObject.ogf.split("\n");
                    if (split.length == 1) {
                        gVar.oiy = split[0];
                    } else {
                        gVar.oiy = context.getString(R.l.fgX, new Object[]{Integer.valueOf(split.length), e.d(mallTransactionObject.ogg - mallTransactionObject.kBc, mallTransactionObject.oga)});
                        gVar.a(split, TruncateAt.MIDDLE);
                    }
                    arrayList.add(gVar);
                }
                z2 = true;
            }
            h hVar2 = new h(context);
            hVar2.oiF = z2;
            hVar2.oiG = true;
            arrayList.add(hVar2);
        } else {
            i iVar2 = new i(context);
            iVar2.oiI = e.d(mallTransactionObject.ogB, mallTransactionObject.oga);
            iVar2.setTitle(context.getString(R.l.fgQ));
            if (!bg.mA(mallTransactionObject.ogC)) {
                iVar2.Cu(mallTransactionObject.ogC);
            }
            arrayList.add(iVar2);
            hVar = new h(context);
            hVar.oiF = false;
            hVar.oiG = true;
            arrayList.add(hVar);
            fVar2 = new f(context);
            fVar2.setTitle(R.l.fgZ);
            fVar2.setContent(e.d(mallTransactionObject.kBc, mallTransactionObject.oga));
            arrayList.add(fVar2);
            fVar2 = new f(context);
            fVar2.setTitle(R.l.fgR);
            fVar2.setContent(mallTransactionObject.ogr);
            arrayList.add(fVar2);
        }
        if (!bg.mA(mallTransactionObject.desc)) {
            if (z) {
                fVar3 = new f(context);
                fVar3.setTitle(R.l.fhf);
                fVar3.setContent(mallTransactionObject.desc);
                arrayList.add(fVar3);
            } else {
                fVar3 = new f(context);
                fVar3.setTitle(R.l.cQP);
                if (bg.mA(mallTransactionObject.ofQ)) {
                    fVar3.setContent(mallTransactionObject.desc);
                } else {
                    String string2 = context.getString(R.l.fgS);
                    fVar3.a(mallTransactionObject.desc + " " + string2, mallTransactionObject.desc.length() + 1, string2.length() + (mallTransactionObject.desc.length() + 1), new OnClickListener(this) {
                        final /* synthetic */ b oio;

                        public final void onClick(View view) {
                            fVar3.setContent(mallTransactionObject.desc + "\n" + mallTransactionObject.ofQ);
                            fVar.notifyDataSetChanged();
                        }
                    });
                }
                arrayList.add(fVar3);
            }
        }
        if (!bg.mA(mallTransactionObject.ofP)) {
            fVar3 = new f(context);
            fVar3.setTitle(R.l.fhg);
            fVar3.setContent(mallTransactionObject.ofP);
            arrayList.add(fVar3);
        }
        if (!bg.mA(mallTransactionObject.ofU)) {
            fVar3 = new f(context);
            fVar3.setTitle(R.l.fhs);
            fVar3.setContent(mallTransactionObject.ofU);
            if (!bg.mA(mallTransactionObject.ofV)) {
                fVar3.Ct(mallTransactionObject.ofV);
            }
            arrayList.add(fVar3);
        }
        fVar3 = new f(context);
        fVar3.setTitle(R.l.fhc);
        fVar3.setContent(e.CK(mallTransactionObject.hFf));
        arrayList.add(fVar3);
        if (mallTransactionObject.ogn > 0) {
            fVar3 = new f(context);
            fVar3.setTitle(R.l.fha);
            fVar3.setContent(e.CK(mallTransactionObject.ogn));
            arrayList.add(fVar3);
        } else if (mallTransactionObject.ogm > 0) {
            fVar3 = new f(context);
            fVar3.setTitle(R.l.fhd);
            fVar3.setContent(e.CK(mallTransactionObject.ogm));
            arrayList.add(fVar3);
        } else {
            w.e("MicroMsg.FetchOrderPrefFactory", "hy: is fetch but no arrive time or fetch time");
        }
        if (!bg.mA(mallTransactionObject.ofY)) {
            fVar2 = new f(context);
            fVar2.setTitle(R.l.fhb);
            String str = mallTransactionObject.ofY;
            if (!bg.mA(mallTransactionObject.ofZ)) {
                str = str + "(" + mallTransactionObject.ofZ + ")";
            }
            fVar2.setContent(str);
            arrayList.add(fVar2);
        }
        if (!bg.mA(mallTransactionObject.ofX)) {
            fVar3 = new f(context);
            fVar3.setTitle(R.l.fhe);
            fVar3.setContent(mallTransactionObject.ofX);
            arrayList.add(fVar3);
        }
        h hVar3;
        if (bg.mA(mallTransactionObject.ogk) && bg.mA(mallTransactionObject.ogb) && bg.mA(mallTransactionObject.ofD)) {
            hVar3 = new h(context);
            hVar3.oiF = true;
            hVar3.jzz = false;
            arrayList.add(hVar3);
        } else {
            hVar3 = new h(context);
            hVar3.oiF = true;
            arrayList.add(hVar3);
            arrayList.add(com.tencent.mm.plugin.order.model.a.a(context, mallTransactionObject));
        }
        return arrayList;
    }
}
