package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.as.f;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.BizInfo.ExtInfo;
import com.tencent.mm.plugin.brandservice.ui.base.c;
import com.tencent.mm.protocal.c.axh;
import com.tencent.mm.protocal.c.hw;
import com.tencent.mm.protocal.c.ia;
import com.tencent.mm.protocal.c.mz;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.u.ap;
import java.util.List;

public final class a extends c {
    private static b jZs;
    protected String iconUrl;
    protected CharSequence jZt;
    protected CharSequence jZu;
    protected CharSequence jZv;
    protected boolean jZw;
    protected boolean jZx;
    protected CharSequence nickName;
    protected String username;

    public static class a extends com.tencent.mm.plugin.brandservice.a.a.a implements com.tencent.mm.plugin.brandservice.ui.base.a.a {
        public View jZA;
        public TextView jZB;
        public TextView jZC;
        public TextView jZD;
        public View jZE;
        public TextView jZy;
        public TextView jZz;
    }

    public static class b extends com.tencent.mm.plugin.brandservice.ui.base.a.b {
        public final boolean a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a aVar, Object... objArr) {
            if (!(aVar instanceof a)) {
                return false;
            }
            a aVar2 = (a) aVar;
            if (aVar.data instanceof ia) {
                ia iaVar = (ia) aVar.data;
                if (iaVar.tmo == null || iaVar.tmo.tlW == null) {
                    w.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
                    return false;
                }
                String str;
                int i;
                int i2 = 0;
                c cVar = null;
                String str2 = "";
                if (objArr != null) {
                    c cVar2;
                    if (objArr.length <= 0 || !(objArr[0] instanceof c)) {
                        cVar2 = null;
                    } else {
                        cVar2 = (c) objArr[0];
                    }
                    if (objArr.length > 2 && (objArr[2] instanceof Integer)) {
                        i2 = ((Integer) objArr[2]).intValue();
                    }
                    if (objArr.length <= 3 || !(objArr[3] instanceof String)) {
                        cVar = cVar2;
                        str = str2;
                        i = i2;
                    } else {
                        i = i2;
                        c cVar3 = cVar2;
                        str = (String) objArr[3];
                        cVar = cVar3;
                    }
                } else {
                    str = str2;
                    i = 0;
                }
                String str3 = iaVar.tmo.msF;
                axh com_tencent_mm_protocal_c_axh = iaVar.tmo.tlW;
                String str4 = com_tencent_mm_protocal_c_axh.tLj != null ? com_tencent_mm_protocal_c_axh.tLj.tZr : null;
                String str5 = com_tencent_mm_protocal_c_axh.ttp != null ? com_tencent_mm_protocal_c_axh.ttp.tZr : null;
                if (bg.mA(str5)) {
                    w.e("MicroMsg.BizContactDataItem", "onItemClick but username is null");
                    return false;
                }
                int i3;
                f.jY(str5);
                if (bg.mA(str3)) {
                    ap.yY();
                    af Rc = com.tencent.mm.u.c.wR().Rc(str5);
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putString("Contact_Ext_Args_Search_Id", str);
                    bundle.putInt("Contact_Ext_Args_Index", aVar2.aew());
                    bundle.putString("Contact_Ext_Args_Query_String", "");
                    bundle.putInt("Contact_Scene", i);
                    intent.putExtra("Contact_Ext_Args", bundle);
                    intent.putExtra("Contact_User", str5);
                    intent.putExtra("Contact_Scene", i);
                    if (!com.tencent.mm.j.a.ez(Rc.field_type)) {
                        intent.putExtra("Contact_Alias", com_tencent_mm_protocal_c_axh.hAI);
                        intent.putExtra("Contact_Nick", str4);
                        intent.putExtra("Contact_Signature", com_tencent_mm_protocal_c_axh.hAG);
                        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ab(com_tencent_mm_protocal_c_axh.hAM, com_tencent_mm_protocal_c_axh.hAE, com_tencent_mm_protocal_c_axh.hAF));
                        intent.putExtra("Contact_Sex", com_tencent_mm_protocal_c_axh.hAD);
                        intent.putExtra("Contact_VUser_Info", com_tencent_mm_protocal_c_axh.tMQ);
                        intent.putExtra("Contact_VUser_Info_Flag", com_tencent_mm_protocal_c_axh.tMP);
                        intent.putExtra("Contact_KWeibo_flag", com_tencent_mm_protocal_c_axh.tMT);
                        intent.putExtra("Contact_KWeibo", com_tencent_mm_protocal_c_axh.tMR);
                        intent.putExtra("Contact_KWeiboNick", com_tencent_mm_protocal_c_axh.tMS);
                        if (com_tencent_mm_protocal_c_axh.tZV != null) {
                            try {
                                intent.putExtra("Contact_customInfo", com_tencent_mm_protocal_c_axh.tZV.toByteArray());
                            } catch (Throwable e) {
                                w.printErrStackTrace("MicroMsg.BizContactDataItem", e, "", new Object[0]);
                            }
                        }
                    }
                    com.tencent.mm.plugin.brandservice.a.imv.d(intent, context);
                    i3 = 1;
                } else {
                    i3 = 8;
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", str3);
                    intent2.putExtra("useJs", true);
                    intent2.putExtra("vertical_scroll", true);
                    d.b(context, "webview", ".ui.tools.WebViewUI", intent2);
                }
                com.tencent.mm.plugin.brandservice.ui.c.b aev = aVar2.aev();
                if (!(aev == null || cVar == null)) {
                    aev.a(cVar, aVar, i3, str5, aVar2.aew(), aVar2.getPosition());
                }
                return true;
            }
            w.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BusinessResultItem.");
            return false;
        }

        public final View b(Context context, View view) {
            if (view == null) {
                return View.inflate(context, R.i.dnl, null);
            }
            return view;
        }

        public final void a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar, com.tencent.mm.plugin.brandservice.ui.base.a aVar2) {
            int i = 8;
            if (context == null || aVar == null || aVar2 == null || aVar2.data == null) {
                w.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            } else if (!(aVar instanceof a)) {
                w.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
            } else if (aVar2 instanceof a) {
                a aVar3 = (a) aVar;
                a aVar4 = (a) aVar2;
                aVar3.username = aVar4.username;
                aVar3.iconUrl = aVar4.iconUrl;
                com.tencent.mm.plugin.brandservice.ui.base.d.a.a(aVar3.ipv, aVar4.username, aVar4.iconUrl);
                aVar3.jZA.setVisibility(aVar4.jZw ? 0 : 8);
                View view = aVar3.jZE;
                if (aVar4.jZx) {
                    i = 0;
                }
                view.setVisibility(i);
                com.tencent.mm.plugin.brandservice.a.a.b(aVar3.jZz, aVar4.nickName);
                boolean b = com.tencent.mm.plugin.brandservice.a.a.b(aVar3.jZD, aVar4.jZv);
                boolean b2 = com.tencent.mm.plugin.brandservice.a.a.b(aVar3.jZC, aVar4.jZu);
                if (com.tencent.mm.plugin.brandservice.a.a.b(aVar3.jZB, aVar4.jZt)) {
                    if (b || b2) {
                        aVar3.jZB.setMaxLines(1);
                    } else {
                        aVar3.jZB.setMaxLines(2);
                    }
                }
                w.d("MicroMsg.BizContactDataItem", "fillingView , nickName : %s, followFriends : %s.", new Object[]{aVar4.nickName, aVar4.jZu});
            } else {
                w.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
            }
        }

        public final void a(View view, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar) {
            if (view != null && aVar != null && (aVar instanceof a)) {
                a aVar2 = (a) aVar;
                aVar2.jZy = (TextView) view.findViewById(R.h.bGk);
                aVar2.jZE = view.findViewById(R.h.btH);
                aVar2.ipv = (ImageView) view.findViewById(R.h.bqH);
                aVar2.jZz = (TextView) view.findViewById(R.h.coe);
                aVar2.jZA = view.findViewById(R.h.cLv);
                aVar2.jZC = (TextView) view.findViewById(R.h.bQQ);
                aVar2.jZB = (TextView) view.findViewById(R.h.bXU);
                aVar2.jZD = (TextView) view.findViewById(R.h.cTm);
            }
        }
    }

    public a(Object obj) {
        super(5, obj);
    }

    public final com.tencent.mm.plugin.brandservice.ui.base.a.b aed() {
        if (jZs == null) {
            jZs = new b();
        }
        return jZs;
    }

    public final com.tencent.mm.plugin.brandservice.ui.base.a.a aee() {
        return new a();
    }

    public final void a(Context context, com.tencent.mm.plugin.brandservice.ui.base.a.a aVar, Object... objArr) {
        ExtInfo.c cVar = null;
        if (!this.kbB) {
            if (context == null || aVar == null || this.data == null) {
                w.e("MicroMsg.BizContactDataItem", "Context or ViewHolder or DataItem or DataItem.data is null.");
            } else if (!(aVar instanceof a)) {
                w.e("MicroMsg.BizContactDataItem", "The DataItem is not a instance of BizContactViewHolder.");
            } else if (this.data instanceof ia) {
                a aVar2 = (a) aVar;
                ia iaVar = (ia) this.data;
                if (iaVar.tmo == null || iaVar.tmo.tlW == null) {
                    w.e("MicroMsg.BizContactDataItem", "The brItem.ContactItem or brItem.ContactItem.ContactItem is null.");
                    return;
                }
                BizInfo bizInfo;
                axh com_tencent_mm_protocal_c_axh = iaVar.tmo.tlW;
                hw hwVar = iaVar.tmo.tlT;
                if (objArr != null && objArr.length > 1 && (objArr[1] instanceof List)) {
                    this.iJD = (List) objArr[1];
                }
                this.username = com_tencent_mm_protocal_c_axh.ttp.tZr;
                this.iconUrl = com_tencent_mm_protocal_c_axh.tqc;
                this.jZu = hwVar == null ? "" : hwVar.tmc;
                String str = com_tencent_mm_protocal_c_axh.tLj == null ? null : com_tencent_mm_protocal_c_axh.tLj.tZr;
                try {
                    List list = this.iJD;
                    aVar2.jZz.getTextSize();
                    this.nickName = com.tencent.mm.plugin.brandservice.a.a.b(context, str, list);
                } catch (Exception e) {
                    this.nickName = "";
                }
                String str2 = com_tencent_mm_protocal_c_axh.ttp.tZr;
                mz mzVar = com_tencent_mm_protocal_c_axh.tZV;
                if (mzVar != null) {
                    bizInfo = new BizInfo();
                    bizInfo.field_username = str2;
                    com.tencent.mm.plugin.brandservice.a.a.a(bizInfo, mzVar);
                } else {
                    bizInfo = null;
                }
                if (!(bizInfo == null || bizInfo.bd(false) == null)) {
                    cVar = bizInfo.bd(false).Db();
                }
                if (cVar != null) {
                    boolean z;
                    if (!bizInfo.bd(false).Dd() || bg.mA(cVar.hvm)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    this.jZx = z;
                    this.jZw = com_tencent_mm_protocal_c_axh.tMP != 0;
                }
                w.v("MicroMsg.BizContactDataItem", "verifyFlag : %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_axh.tMP)});
                String str3 = com_tencent_mm_protocal_c_axh.hAI;
                if (this.iJD.size() > 0 && str3 != null && str3.toLowerCase().equals(((String) this.iJD.get(0)).toLowerCase())) {
                    try {
                        List list2 = this.iJD;
                        aVar2.jZD.getTextSize();
                        this.jZv = com.tencent.mm.plugin.brandservice.a.a.b(context, str3, list2);
                        this.jZv = TextUtils.concat(new CharSequence[]{context.getResources().getString(R.l.ePM), this.jZv});
                    } catch (Exception e2) {
                        this.jZv = "";
                    }
                }
                if (this.jZv == null || this.jZv.length() == 0 || this.jZu == null || this.jZu.length() == 0) {
                    try {
                        str = com_tencent_mm_protocal_c_axh.hAG;
                        List list3 = this.iJD;
                        aVar2.jZB.getTextSize();
                        this.jZt = com.tencent.mm.plugin.brandservice.a.a.b(context, str, list3);
                    } catch (Exception e3) {
                        this.jZt = "";
                    }
                }
                w.d("MicroMsg.BizContactDataItem", "nickName : %s, followFriends : %s.", new Object[]{this.nickName, this.jZu});
                this.kbB = true;
            } else {
                w.e("MicroMsg.BizContactDataItem", "The ViewHolder is not a instance of BusinessResultItem.");
            }
        }
    }
}
