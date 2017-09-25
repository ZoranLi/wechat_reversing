package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.brandservice.ui.base.c;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.u.ap;

public final class b extends c {
    private static com.tencent.mm.plugin.brandservice.ui.base.a.b jZF;
    protected String iconUrl;
    public CharSequence ipq;
    protected String jZG;
    protected CharSequence jZt;
    protected boolean jZw;
    protected boolean jZx;
    protected String username;

    public static class a extends com.tencent.mm.plugin.brandservice.a.a.a implements com.tencent.mm.plugin.brandservice.ui.base.a.a {
        public TextView jWd;
        public View jZA;
        public TextView jZB;
        public View jZE;
        public TextView jZy;
    }

    public b(Object obj, String str) {
        super(6, obj);
        this.jZG = str;
    }

    public final com.tencent.mm.plugin.brandservice.ui.base.a.b aed() {
        if (jZF == null) {
            jZF = new com.tencent.mm.plugin.brandservice.ui.base.a.b(this) {
                final /* synthetic */ b jZH;

                {
                    this.jZH = r1;
                }

                public final boolean a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a aVar, Object... objArr) {
                    if (!(aVar instanceof b)) {
                        return false;
                    }
                    String str;
                    String str2;
                    b bVar = (b) aVar;
                    axg com_tencent_mm_protocal_c_axg = (axg) aVar.data;
                    if (com_tencent_mm_protocal_c_axg.tLj != null) {
                        str = com_tencent_mm_protocal_c_axg.tLj.tZr;
                    } else {
                        str = null;
                    }
                    if (com_tencent_mm_protocal_c_axg.ttp != null) {
                        str2 = com_tencent_mm_protocal_c_axg.ttp.tZr;
                    } else {
                        str2 = null;
                    }
                    if (bg.mA(str2)) {
                        w.e("MicroMsg.BizRecommDataItem", "onItemClick but username is null");
                        return false;
                    }
                    c cVar;
                    ap.yY();
                    af Rc = com.tencent.mm.u.c.wR().Rc(str2);
                    Intent intent = new Intent();
                    if (com.tencent.mm.j.a.ez(Rc.field_type)) {
                        intent.putExtra("Contact_User", str2);
                        intent.putExtra("Contact_Scene", 55);
                    } else {
                        intent.putExtra("Contact_User", str2);
                        intent.putExtra("Contact_Alias", com_tencent_mm_protocal_c_axg.hAI);
                        intent.putExtra("Contact_Nick", str);
                        intent.putExtra("Contact_Signature", com_tencent_mm_protocal_c_axg.hAG);
                        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ab(com_tencent_mm_protocal_c_axg.hAM, com_tencent_mm_protocal_c_axg.hAE, com_tencent_mm_protocal_c_axg.hAF));
                        intent.putExtra("Contact_Sex", com_tencent_mm_protocal_c_axg.hAD);
                        intent.putExtra("Contact_VUser_Info", com_tencent_mm_protocal_c_axg.tMQ);
                        intent.putExtra("Contact_VUser_Info_Flag", com_tencent_mm_protocal_c_axg.tMP);
                        intent.putExtra("Contact_KWeibo_flag", com_tencent_mm_protocal_c_axg.tMT);
                        intent.putExtra("Contact_KWeibo", com_tencent_mm_protocal_c_axg.tMR);
                        intent.putExtra("Contact_KWeiboNick", com_tencent_mm_protocal_c_axg.tMS);
                        intent.putExtra("Contact_Scene", 55);
                        if (com_tencent_mm_protocal_c_axg.tMW != null) {
                            try {
                                intent.putExtra("Contact_customInfo", com_tencent_mm_protocal_c_axg.tMW.toByteArray());
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.BizRecommDataItem", e, "", new Object[0]);
                            }
                        }
                    }
                    com.tencent.mm.plugin.brandservice.a.imv.d(intent, context);
                    if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof c)) {
                        cVar = null;
                    } else {
                        cVar = (c) objArr[0];
                    }
                    com.tencent.mm.plugin.brandservice.ui.c.b aev = bVar.aev();
                    if (aev == null || cVar == null) {
                        return true;
                    }
                    aev.a(cVar, aVar, 1, str2, bVar.aew(), bVar.getPosition());
                    return true;
                }

                public final View b(Context context, View view) {
                    if (view == null) {
                        return View.inflate(context, R.i.dnl, null);
                    }
                    return view;
                }

                public final void a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar, com.tencent.mm.plugin.brandservice.ui.base.a aVar2) {
                    int i = 0;
                    if (context == null || aVar == null || aVar2 == null || aVar2.data == null) {
                        w.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
                    } else if (!(aVar instanceof a)) {
                        w.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of BizRecommViewHolder.");
                    } else if (aVar2.data instanceof axg) {
                        int i2;
                        a aVar3 = (a) aVar;
                        b bVar = (b) aVar2;
                        aVar3.username = bVar.username;
                        aVar3.iconUrl = bVar.iconUrl;
                        com.tencent.mm.plugin.brandservice.ui.base.d.a.a(aVar3.ipv, bVar.username, bVar.iconUrl);
                        aVar3.jWd.setText(bVar.ipq, BufferType.SPANNABLE);
                        View view = aVar3.jZE;
                        if (bVar.jZx) {
                            i2 = 0;
                        } else {
                            i2 = 8;
                        }
                        view.setVisibility(i2);
                        View view2 = aVar3.jZA;
                        if (!bVar.jZw) {
                            i = 8;
                        }
                        view2.setVisibility(i);
                        aVar3.jZB.setText(bVar.jZt, BufferType.SPANNABLE);
                        com.tencent.mm.plugin.brandservice.a.a.b(aVar3.jZy, bVar.jZG);
                    } else {
                        w.e("MicroMsg.BizRecommDataItem", "The ViewHolder is not a instance of SearchOrRecommendItem.");
                    }
                }

                public final void a(View view, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar) {
                    if (view != null && aVar != null && (aVar instanceof a)) {
                        a aVar2 = (a) aVar;
                        aVar2.ipv = (ImageView) view.findViewById(R.h.bqH);
                        aVar2.jWd = (TextView) view.findViewById(R.h.coe);
                        aVar2.jZy = (TextView) view.findViewById(R.h.bGk);
                        aVar2.jZE = view.findViewById(R.h.btH);
                        aVar2.jZA = view.findViewById(R.h.cLv);
                        aVar2.jZB = (TextView) view.findViewById(R.h.bXU);
                    }
                }
            };
        }
        return jZF;
    }

    public final com.tencent.mm.plugin.brandservice.ui.base.a.a aee() {
        return new a();
    }

    public final void a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar, Object... objArr) {
        if (!this.kbB) {
            if (context == null || aVar == null || this.data == null) {
                w.e("MicroMsg.BizRecommDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            } else if (!(aVar instanceof a)) {
                w.e("MicroMsg.BizRecommDataItem", "The DataItem is not a instance of BizProductViewHolder.");
            } else if (this.data instanceof axg) {
                axg com_tencent_mm_protocal_c_axg = (axg) this.data;
                try {
                    this.ipq = h.b(context, com_tencent_mm_protocal_c_axg.tLj != null ? com_tencent_mm_protocal_c_axg.tLj.toString() : "", ((a) aVar).jWd.getTextSize());
                } catch (Exception e) {
                    this.ipq = "";
                }
                this.iconUrl = com_tencent_mm_protocal_c_axg.tqc;
                this.username = com_tencent_mm_protocal_c_axg.ttp.toString();
            } else {
                w.e("MicroMsg.BizRecommDataItem", "The data is not a instance of SearchOrRecommendItem.");
            }
        }
    }
}
