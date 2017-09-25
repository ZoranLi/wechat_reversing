package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.plugin.brandservice.ui.base.BaseSortView;
import com.tencent.mm.plugin.brandservice.ui.base.f;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.alx;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.protocal.c.bed;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EnterpriseBizContactListView extends BaseSortView {
    String kaE;
    boolean kaL;
    private ListView kaM;
    int kaN = -1;
    b kaO;
    private a kaP;
    private int kaQ = 0;
    private int kaR = 0;

    private static class a implements e {
        public p irJ;
        public String kaT;
        g kaU;
        WeakReference<EnterpriseBizContactListView> kaV;

        class AnonymousClass1 implements OnCreateContextMenuListener {
            final /* synthetic */ int kA;
            final /* synthetic */ a kaW;

            AnonymousClass1(a aVar, int i) {
                this.kaW = aVar;
                this.kA = i;
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
                contextMenu.add(this.kA, 1, 0, R.l.eeN);
            }
        }

        class AnonymousClass3 implements OnClickListener {
            final /* synthetic */ String gTC;
            final /* synthetic */ a kaW;
            final /* synthetic */ Context val$context;

            AnonymousClass3(a aVar, String str, Context context) {
                this.kaW = aVar;
                this.gTC = str;
                this.val$context = context;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                final k cVar = new com.tencent.mm.plugin.profile.a.c(this.gTC, true);
                ap.vd().a(1394, this.kaW);
                ap.vd().a(cVar, 0);
                a aVar = this.kaW;
                Context context = this.val$context;
                this.val$context.getString(R.l.dIO);
                aVar.irJ = com.tencent.mm.ui.base.g.a(context, this.val$context.getString(R.l.dJd), true, new OnCancelListener(this) {
                    final /* synthetic */ AnonymousClass3 kaY;

                    public final void onCancel(DialogInterface dialogInterface) {
                        ap.vd().c(cVar);
                        ap.vd().b(1394, this.kaY.kaW);
                    }
                });
            }
        }

        public a(EnterpriseBizContactListView enterpriseBizContactListView) {
            this.kaV = new WeakReference(enterpriseBizContactListView);
        }

        protected final void finalize() {
            ap.vd().b(1394, this);
            super.finalize();
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (this.irJ != null && this.irJ.isShowing()) {
                this.irJ.dismiss();
            }
            if (i == 0 && i2 == 0 && kVar.getType() == 1394) {
                bec aTu = ((com.tencent.mm.plugin.profile.a.c) kVar).aTu();
                bed aTt = ((com.tencent.mm.plugin.profile.a.c) kVar).aTt();
                if (aTt == null || aTt.tkR == null || aTt.tkR.ret != 0) {
                    if (aTt == null || aTt.tkR == null) {
                        w.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:resp == null", new Object[]{Integer.valueOf(kVar.getType())});
                        return;
                    }
                    w.w("MicroMsg.BrandService.EnterpriseBizContactListView", "chuangchen onSceneEnd type:%s, err:code:%s", new Object[]{Integer.valueOf(kVar.getType()), Integer.valueOf(aTt.tkR.ret)});
                } else if (aTu.uff) {
                    com.tencent.mm.sdk.e.c hW = com.tencent.mm.modelbiz.e.hW(aTu.tkL);
                    hW.field_brandFlag |= 1;
                    com.tencent.mm.bd.a com_tencent_mm_protocal_c_alx = new alx();
                    com_tencent_mm_protocal_c_alx.hAR = hW.field_brandFlag;
                    com_tencent_mm_protocal_c_alx.jNj = aTu.tkL;
                    ap.yY();
                    com.tencent.mm.u.c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(47, com_tencent_mm_protocal_c_alx));
                    com.tencent.mm.modelbiz.w.DH().c(hW, new String[0]);
                    ap.yY();
                    com.tencent.mm.u.c.wW().Rl(hW.field_username);
                    ap.yY();
                    if (com.tencent.mm.u.c.wW().Rw(hW.field_enterpriseFather) <= 0) {
                        ap.yY();
                        com.tencent.mm.u.c.wW().Rl(hW.field_enterpriseFather);
                    } else {
                        ap.yY();
                        com.tencent.mm.u.c.wV().QH(hW.field_enterpriseFather);
                    }
                    EnterpriseBizContactListView enterpriseBizContactListView = (EnterpriseBizContactListView) this.kaV.get();
                    if (enterpriseBizContactListView != null) {
                        enterpriseBizContactListView.refresh();
                    }
                }
            }
        }
    }

    public interface b {
        boolean ael();
    }

    public static class c {
        String iconUrl;
        public View ipu;
        ImageView ipv;
        TextView jWd;
        public TextView jZy;
        ImageView kaZ;
        View kba;
        String username;
    }

    private class d implements Comparator<f> {
        final /* synthetic */ EnterpriseBizContactListView kaS;

        public d(EnterpriseBizContactListView enterpriseBizContactListView) {
            this.kaS = enterpriseBizContactListView;
        }

        public final /* synthetic */ int compare(Object obj, Object obj2) {
            f fVar = (f) obj;
            f fVar2 = (f) obj2;
            String str = fVar.kcl;
            String str2 = fVar2.kcl;
            int compareToIgnoreCase = (str == null || str2 == null) ? 0 : str.compareToIgnoreCase(str2);
            if (compareToIgnoreCase != 0) {
                if (str.equalsIgnoreCase("#")) {
                    compareToIgnoreCase = 1;
                }
                return str2.equalsIgnoreCase("#") ? -1 : compareToIgnoreCase;
            } else {
                com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) fVar.data;
                com.tencent.mm.plugin.brandservice.a.b bVar2 = (com.tencent.mm.plugin.brandservice.a.b) fVar2.data;
                if (!(str == null || str2 == null || (!str.equalsIgnoreCase("!2") && !str.equalsIgnoreCase("!1")))) {
                    int sZ = bVar.jiL.sZ();
                    int sZ2 = bVar2.jiL.sZ();
                    Object obj3 = ((sZ < 97 || sZ > 122) && (sZ < 65 || sZ > 90)) ? 1 : null;
                    Object obj4 = ((sZ2 < 97 || sZ2 > 122) && (sZ2 < 65 || sZ2 > 90)) ? 1 : null;
                    if (obj3 != null && obj4 == null) {
                        return 1;
                    }
                    if (obj3 == null && obj4 != null) {
                        return -1;
                    }
                }
                int compareToIgnoreCase2 = (bVar.jiL == null || bVar.jiL.pC() == null || bVar.jiL.pC().length() <= 0 || bVar2.jiL == null || bVar2.jiL.pC() == null || bVar2.jiL.pC().length() <= 0) ? 0 : bVar.jiL.pC().compareToIgnoreCase(bVar2.jiL.pC());
                if (compareToIgnoreCase2 != 0) {
                    return compareToIgnoreCase2;
                }
                compareToIgnoreCase2 = (bVar.jiL == null || bVar.jiL.field_nickname == null || bVar.jiL.field_nickname.length() <= 0 || bVar2.jiL == null || bVar2.jiL.field_nickname == null || bVar2.jiL.field_nickname.length() <= 0) ? 0 : bVar.jiL.field_nickname.compareToIgnoreCase(bVar2.jiL.field_nickname);
                if (compareToIgnoreCase2 != 0) {
                    return compareToIgnoreCase2;
                }
                compareToIgnoreCase = (bVar.jiL == null || bVar.jiL.field_username == null || bVar.jiL.field_username.length() <= 0 || bVar2.jiL == null || bVar2.jiL.field_username == null || bVar2.jiL.field_username.length() <= 0) ? 0 : bVar.jiL.field_username.compareToIgnoreCase(bVar2.jiL.field_username);
                return compareToIgnoreCase == 0 ? 0 : compareToIgnoreCase;
            }
        }
    }

    static /* synthetic */ void a(TextView textView, Context context, String str, int i) {
        if (textView != null && !bg.mA(str)) {
            try {
                textView.setText(new SpannableString(h.c(context, str, i)));
            } catch (Exception e) {
                textView.setText("");
            }
        }
    }

    static /* synthetic */ void a(EnterpriseBizContactListView enterpriseBizContactListView, BizInfo bizInfo, int i) {
        com.tencent.mm.modelbiz.b hC = com.tencent.mm.modelbiz.w.DO().hC(enterpriseBizContactListView.kaE);
        long j = hC != null ? hC.field_wwCorpId : 0;
        long j2 = hC != null ? hC.field_wwUserVid : 0;
        long CM = bizInfo.CM();
        com.tencent.mm.plugin.report.service.g.oUh.i(14507, new Object[]{Long.valueOf(j), Long.valueOf(CM), Long.valueOf(j2), Integer.valueOf(2), Integer.valueOf(2), Integer.valueOf(i)});
        w.d("MicroMsg.BrandService.EnterpriseBizContactListView", "enter biz enterprise sub barnd report: %s,%s,%s,%s,%s,%s", new Object[]{Long.valueOf(j), Long.valueOf(CM), Long.valueOf(j2), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(i)});
    }

    public EnterpriseBizContactListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void refresh() {
        List arrayList = new ArrayList();
        com.tencent.mm.modelbiz.w.DH();
        Cursor t = com.tencent.mm.modelbiz.d.t(this.kaE, this.kaL);
        while (t.moveToNext()) {
            com.tencent.mm.plugin.brandservice.a.b bVar = new com.tencent.mm.plugin.brandservice.a.b();
            if (t != null) {
                af xVar = new x();
                xVar.b(t);
                BizInfo bizInfo = new BizInfo();
                bizInfo.b(t);
                bVar.userName = xVar.field_username;
                bVar.jiL = xVar;
                bVar.jZc = bizInfo;
            }
            if (bVar.jiL != null) {
                f fVar = new f();
                fVar.data = bVar;
                if (bVar.jZc.CJ()) {
                    fVar.kcl = "!1";
                } else if (bVar.jiL.tG()) {
                    fVar.kcl = "!2";
                } else {
                    int sZ = bVar.jiL.sZ();
                    if (sZ >= 97 && sZ <= 122) {
                        sZ -= 32;
                    }
                    if (sZ < 65 || sZ > 90) {
                        fVar.kcl = "#";
                    } else {
                        fVar.kcl = ((char) sZ);
                    }
                }
                arrayList.add(fVar);
            }
        }
        t.close();
        this.kaN = arrayList.size();
        Collections.sort(arrayList, new d(this));
        W(arrayList);
        super.refresh();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.kaQ = (int) motionEvent.getRawX();
            this.kaR = (int) motionEvent.getRawY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void aem() {
        this.acN = new OnItemClickListener(this) {
            final /* synthetic */ EnterpriseBizContactListView kaS;

            {
                this.kaS = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Object tag = view.getTag();
                if (tag != null && (tag instanceof c)) {
                    c cVar = (c) tag;
                    if (!bg.mA(cVar.username)) {
                        boolean ic = com.tencent.mm.modelbiz.e.ic(cVar.username);
                        boolean dr = com.tencent.mm.modelbiz.e.dr(cVar.username);
                        BizInfo hW = com.tencent.mm.modelbiz.e.hW(cVar.username);
                        String CL = hW == null ? null : hW.CL();
                        if (CL == null) {
                            CL = "";
                        }
                        if (ic) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", CL);
                            intent.putExtra("useJs", true);
                            intent.putExtra("srcUsername", cVar.username);
                            intent.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                            intent.addFlags(67108864);
                            com.tencent.mm.bb.d.b(this.kaS.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                            EnterpriseBizContactListView.a(this.kaS, hW, 2);
                        } else if (dr) {
                            r1 = new Intent();
                            r1.putExtra("Contact_User", cVar.username);
                            r1.addFlags(67108864);
                            r1.putExtra("biz_chat_from_scene", 3);
                            com.tencent.mm.bb.d.a(this.kaS.getContext(), ".ui.bizchat.BizChatConversationUI", r1);
                        } else {
                            r1 = new Intent();
                            r1.addFlags(67108864);
                            r1.putExtra("finish_direct", true);
                            r1.putExtra("Chat_User", cVar.username);
                            r1.putExtra("chat_from_scene", 2);
                            Context context = this.kaS.getContext();
                            w.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
                            com.tencent.mm.plugin.brandservice.a.imv.e(r1, context);
                            EnterpriseBizContactListView.a(this.kaS, hW, 1);
                        }
                    }
                }
            }
        };
        if (this.mMode == 0) {
            this.kbJ = new OnItemLongClickListener(this) {
                final /* synthetic */ EnterpriseBizContactListView kaS;

                {
                    this.kaS = r1;
                }

                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (this.kaS.kaP == null) {
                        this.kaS.kaP = new a(this.kaS);
                    }
                    a a = this.kaS.kaP;
                    int b = this.kaS.kaQ;
                    int c = this.kaS.kaR;
                    if (a.kaU == null) {
                        EnterpriseBizContactListView enterpriseBizContactListView = (EnterpriseBizContactListView) a.kaV.get();
                        if (enterpriseBizContactListView == null) {
                            return false;
                        }
                        a.kaU = new g(enterpriseBizContactListView.getContext());
                    }
                    Object tag = view.getTag();
                    if (tag == null || !(tag instanceof c)) {
                        return false;
                    }
                    a.kaT = ((c) tag).username;
                    if (bg.mA(a.kaT) || com.tencent.mm.modelbiz.e.dr(a.kaT)) {
                        return false;
                    }
                    a.kaU.wvD = view;
                    a.kaU.a(adapterView, i, j, new AnonymousClass1(a, i), new com.tencent.mm.ui.base.n.d(a) {
                        final /* synthetic */ a kaW;

                        {
                            this.kaW = r1;
                        }

                        public final void c(MenuItem menuItem, int i) {
                            if (!bg.mA(this.kaW.kaT) && menuItem.getItemId() == 1) {
                                a aVar = this.kaW;
                                String str = this.kaW.kaT;
                                EnterpriseBizContactListView enterpriseBizContactListView = (EnterpriseBizContactListView) aVar.kaV.get();
                                if (enterpriseBizContactListView != null) {
                                    Context context = enterpriseBizContactListView.getContext();
                                    com.tencent.mm.ui.base.g.a(context, context.getString(R.l.eeF), "", context.getString(R.l.eeE), context.getString(R.l.dGs), new AnonymousClass3(aVar, str, context), null);
                                }
                            }
                        }
                    }, b, c);
                    return true;
                }
            };
        }
    }

    public static void release() {
        com.tencent.mm.modelbiz.w.DP().DB();
    }

    public final boolean a(String str, f fVar) {
        if (!(bg.mA(str) || fVar == null)) {
            com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) fVar.data;
            if (bVar == null) {
                return false;
            }
            String tL = bVar.jiL.tL();
            String pB = bVar.jiL.pB();
            String pC = bVar.jiL.pC();
            String toUpperCase = str.toUpperCase();
            if (!(bg.mA(tL) || tL.toUpperCase().indexOf(toUpperCase) == -1) || (!(bg.mA(pB) || pB.toUpperCase().indexOf(toUpperCase) == -1) || (!bg.mA(pC) && pC.toUpperCase().startsWith(toUpperCase)))) {
                return true;
            }
        }
        return false;
    }

    public final View inflate() {
        return View.inflate(getContext(), R.i.dbf, this);
    }

    public final VerticalScrollBar aen() {
        return (VerticalScrollBar) findViewById(R.h.cFm);
    }

    public final ListView getListView() {
        this.kaM = (ListView) findViewById(R.h.cbx);
        return this.kaM;
    }

    public final View aeo() {
        TextView textView = (TextView) findViewById(R.h.coo);
        textView.setText(R.l.eeO);
        return textView;
    }

    public final com.tencent.mm.plugin.brandservice.ui.base.e.a aep() {
        return new com.tencent.mm.plugin.brandservice.ui.base.e.a(this) {
            final /* synthetic */ EnterpriseBizContactListView kaS;

            {
                this.kaS = r1;
            }

            public final View a(f fVar, View view, boolean z, boolean z2) {
                c cVar;
                long NA = bg.NA();
                Context context = this.kaS.getContext();
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(R.i.dbc, null);
                    cVar = new c();
                    cVar.jZy = (TextView) view.findViewById(R.h.byO);
                    cVar.ipu = view.findViewById(R.h.bGx);
                    cVar.ipv = (ImageView) view.findViewById(R.h.boO);
                    cVar.kaZ = (ImageView) view.findViewById(R.h.cnM);
                    cVar.jWd = (TextView) view.findViewById(R.h.buQ);
                    cVar.kba = view.findViewById(R.h.cCn);
                    view.setTag(cVar);
                } else {
                    cVar = (c) view.getTag();
                }
                com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) fVar.data;
                if (bVar == null) {
                    w.e("MicroMsg.BrandService.EnterpriseBizContactListView", "should not be empty");
                } else {
                    Object obj = null;
                    if (bVar.jZc.CJ()) {
                        obj = 1;
                    }
                    if (this.kaS.kbL && z) {
                        if (fVar.kcl.equals("!2")) {
                            cVar.jZy.setText(this.kaS.getContext().getString(R.l.eeT));
                            cVar.jZy.setVisibility(0);
                        } else if (!fVar.kcl.equals("!1")) {
                            cVar.jZy.setText(fVar.kcl);
                            cVar.jZy.setVisibility(0);
                        }
                        if (obj == null) {
                            cVar.username = bVar.userName;
                            cVar.ipv.setImageResource(R.k.dwJ);
                            EnterpriseBizContactListView.a(cVar.jWd, context, this.kaS.getResources().getString(R.l.eeB), (int) cVar.jWd.getTextSize());
                        } else {
                            cVar.username = bVar.userName;
                            cVar.iconUrl = bVar.jZc.field_brandIconURL;
                            cVar.ipv.setTag(bVar.userName);
                            com.tencent.mm.pluginsdk.ui.a.b.a(cVar.ipv, cVar.username);
                            EnterpriseBizContactListView.a(cVar.jWd, context, bVar.jiL.tL(), (int) cVar.jWd.getTextSize());
                        }
                        w.v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", new Object[]{Integer.valueOf(bVar.jZc.field_status)});
                        cVar.kaZ.setVisibility(bVar.jZc.field_status != 1 ? 0 : 8);
                        if (this.kaS.mMode == 0 || !z2) {
                            cVar.kba.setBackgroundResource(R.g.bgh);
                        } else {
                            cVar.kba.setBackgroundResource(R.g.bep);
                        }
                        if (this.kaS.kbM) {
                            cVar.ipu.setPadding(cVar.ipu.getPaddingLeft(), cVar.ipu.getPaddingTop(), (int) this.kaS.getContext().getResources().getDimension(R.f.aXH), cVar.ipu.getPaddingBottom());
                        } else {
                            cVar.ipu.setPadding(cVar.ipu.getPaddingLeft(), cVar.ipu.getPaddingTop(), (int) this.kaS.getContext().getResources().getDimension(R.f.aWz), cVar.ipu.getPaddingBottom());
                        }
                        w.v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", new Object[]{Long.valueOf(bg.aB(NA))});
                    }
                    cVar.jZy.setVisibility(8);
                    if (obj == null) {
                        cVar.username = bVar.userName;
                        cVar.iconUrl = bVar.jZc.field_brandIconURL;
                        cVar.ipv.setTag(bVar.userName);
                        com.tencent.mm.pluginsdk.ui.a.b.a(cVar.ipv, cVar.username);
                        EnterpriseBizContactListView.a(cVar.jWd, context, bVar.jiL.tL(), (int) cVar.jWd.getTextSize());
                    } else {
                        cVar.username = bVar.userName;
                        cVar.ipv.setImageResource(R.k.dwJ);
                        EnterpriseBizContactListView.a(cVar.jWd, context, this.kaS.getResources().getString(R.l.eeB), (int) cVar.jWd.getTextSize());
                    }
                    w.v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", new Object[]{Integer.valueOf(bVar.jZc.field_status)});
                    if (bVar.jZc.field_status != 1) {
                    }
                    cVar.kaZ.setVisibility(bVar.jZc.field_status != 1 ? 0 : 8);
                    if (this.kaS.mMode == 0) {
                    }
                    cVar.kba.setBackgroundResource(R.g.bgh);
                    if (this.kaS.kbM) {
                        cVar.ipu.setPadding(cVar.ipu.getPaddingLeft(), cVar.ipu.getPaddingTop(), (int) this.kaS.getContext().getResources().getDimension(R.f.aXH), cVar.ipu.getPaddingBottom());
                    } else {
                        cVar.ipu.setPadding(cVar.ipu.getPaddingLeft(), cVar.ipu.getPaddingTop(), (int) this.kaS.getContext().getResources().getDimension(R.f.aWz), cVar.ipu.getPaddingBottom());
                    }
                    w.v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", new Object[]{Long.valueOf(bg.aB(NA))});
                }
                return view;
            }
        };
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.kaO != null) {
            this.kaO.ael();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
