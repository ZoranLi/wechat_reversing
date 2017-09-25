package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.R;
import com.tencent.mm.e.a.oc;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.plugin.card.a.c.a;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.i;
import com.tencent.mm.plugin.card.b.h;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.aa;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.model.o;
import com.tencent.mm.plugin.card.model.r;
import com.tencent.mm.plugin.card.model.t;
import com.tencent.mm.plugin.card.model.v;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.g;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI;
import com.tencent.mm.plugin.card.ui.view.q;
import com.tencent.mm.plugin.card.ui.view.x;
import com.tencent.mm.protocal.c.azt;
import com.tencent.mm.protocal.c.bab;
import com.tencent.mm.protocal.c.bde;
import com.tencent.mm.protocal.c.it;
import com.tencent.mm.protocal.c.iw;
import com.tencent.mm.protocal.c.jc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class CardDetailUI extends MMActivity implements a, d.a, i.a, au.a, e {
    private final String TAG = "MicroMsg.CardDetailUI";
    private float gKj = -85.0f;
    private float gKk = -1000.0f;
    private com.tencent.mm.modelgeo.a.a gKp = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ CardDetailUI kkw;

        {
            this.kkw = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
            if (!z) {
                return true;
            }
            if (this.kkw.gKj == -85.0f && this.kkw.gKk == -1000.0f) {
                this.kkw.gKj = f2;
                this.kkw.gKk = f;
                al.agg().o(this.kkw.gKj, this.kkw.gKk);
            }
            if (this.kkw.kku) {
                this.kkw.ahb();
                this.kkw.kku = false;
            }
            this.kkw.aeH();
            return false;
        }
    };
    private String hir = "";
    private c hvP;
    private p iLz = null;
    private Vibrator jYD;
    private int jZM = 3;
    private String kcJ = "";
    private b kcX;
    private String kdA = "";
    private boolean kdR = false;
    private ArrayList<iw> kde;
    private int khL = -1;
    private boolean khY = false;
    private boolean kiV = false;
    private int kjS = 0;
    private String kjT = "";
    private String kjU = "";
    private String kjV = "";
    e kki;
    private String kkj = "";
    private String kkk = "";
    private String kkl = "";
    private boolean kkm = false;
    private boolean kkn = false;
    private boolean kko = false;
    private String kkp = "";
    private e.a kkq;
    private boolean kkr = false;
    private boolean kks = true;
    private boolean kkt = false;
    private boolean kku = false;
    private String kkv = "";
    ae mHandler = new ae();
    private long mStartTime = 0;

    static /* synthetic */ void a(CardDetailUI cardDetailUI, String str) {
        cardDetailUI.da(true);
        ap.vd().a(new af(cardDetailUI.kcX.afm(), str, 18), 0);
    }

    static /* synthetic */ void h(CardDetailUI cardDetailUI) {
        int i;
        cardDetailUI.da(true);
        azt com_tencent_mm_protocal_c_azt = new azt();
        if (cardDetailUI.jZM == 3) {
            com_tencent_mm_protocal_c_azt.fVl = cardDetailUI.kcJ;
            i = 1;
        } else {
            com_tencent_mm_protocal_c_azt.kdE = cardDetailUI.kcJ;
            i = 0;
        }
        com_tencent_mm_protocal_c_azt.fVm = cardDetailUI.kkl;
        com_tencent_mm_protocal_c_azt.tcP = cardDetailUI.kjT;
        com_tencent_mm_protocal_c_azt.tcO = cardDetailUI.kjU;
        com_tencent_mm_protocal_c_azt.tcQ = cardDetailUI.kjS;
        LinkedList linkedList = new LinkedList();
        linkedList.add(com_tencent_mm_protocal_c_azt);
        bab a = l.a(cardDetailUI.kki.kim, cardDetailUI.kki.kip, cardDetailUI.kki.kiq);
        bde com_tencent_mm_protocal_c_bde = new bde();
        com_tencent_mm_protocal_c_bde.ueu = cardDetailUI.hir;
        com_tencent_mm_protocal_c_bde.keV = cardDetailUI.kkp;
        w.i("MicroMsg.CardDetailUI", "ShareCardItem upload templateId:%s", new Object[]{cardDetailUI.hir});
        ap.vd().a(new g(i, linkedList, cardDetailUI.kcX.afi().tog, cardDetailUI.kjV, a, cardDetailUI.jZM, com_tencent_mm_protocal_c_bde), 0);
    }

    static /* synthetic */ void i(CardDetailUI cardDetailUI) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(cardDetailUI.kcJ);
        cardDetailUI.da(true);
        ap.vd().a(new r(linkedList), 0);
    }

    static /* synthetic */ void j(CardDetailUI cardDetailUI) {
        cardDetailUI.da(true);
        String afn = (cardDetailUI.jZM == 6 || TextUtils.isEmpty(cardDetailUI.kcX.afn())) ? cardDetailUI.kcJ : cardDetailUI.kcX.afn();
        int ahw = cardDetailUI.kki.ahw();
        bde com_tencent_mm_protocal_c_bde = new bde();
        com_tencent_mm_protocal_c_bde.ueu = cardDetailUI.hir;
        com_tencent_mm_protocal_c_bde.keV = cardDetailUI.kkp;
        w.i("MicroMsg.CardDetailUI", "AcceptItemInfo templateId:%s", new Object[]{cardDetailUI.hir});
        ap.vd().a(new o(afn, cardDetailUI.jZM, cardDetailUI.kkj, cardDetailUI.kkl, cardDetailUI.kjT, cardDetailUI.kjU, cardDetailUI.kjS, ahw, com_tencent_mm_protocal_c_bde), 0);
    }

    protected final int getLayoutId() {
        return R.i.cWt;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mStartTime = System.currentTimeMillis();
        agW();
        d agl = al.agl();
        ActionBarActivity actionBarActivity = this.uSU.uTo;
        ap.vd().a(910, agl);
        al.agh().a(agl);
        com.tencent.mm.plugin.card.a.b afZ = al.afZ();
        if (afZ.kcI == null) {
            afZ.kcI = new ArrayList();
        }
        if (agl != null) {
            afZ.kcI.add(new WeakReference(agl));
        }
        agl.aeF = new WeakReference(actionBarActivity);
        al.agl().a((d.a) this);
        al.agm().a(this);
        com.tencent.mm.plugin.card.a.c agn = al.agn();
        ap.vd().a(577, agn);
        agn.kcK.clear();
        agn.kcL = 0;
        al.agn().a(this);
        KC();
    }

    protected void onResume() {
        super.onResume();
        agW();
        if (this.hvP != null) {
            this.hvP.a(this.gKp, true);
        }
        this.kki.fKF = false;
        au.a(this);
        al.agl().a(this, true);
        if ((!this.kkm && !this.kkn) || !this.kcX.aeO()) {
            return;
        }
        if (this.kcX.afb()) {
            al.agm().aA(this.kcJ, 2);
            Boolean bool = (Boolean) al.agl().kcW.get(this.kcJ);
            boolean z = bool != null && bool.booleanValue();
            if (!z || TextUtils.isEmpty(al.agl().kcZ)) {
                w.i("MicroMsg.CardDetailUI", "onResume, not need launch succ ui or jsonRet is empty!");
                return;
            }
            w.i("MicroMsg.CardDetailUI", "onResume, do launch succ UI!");
            sj(al.agl().kcZ);
            return;
        }
        al.agm().aA(this.kcJ, 1);
    }

    protected void onPause() {
        agX();
        super.onPause();
        this.kki.fKF = true;
        al.agl().a(this, false);
        au.a(null);
    }

    public final void XF() {
        com.tencent.mm.plugin.card.ui.view.g gVar = this.kki.kkE;
        if (gVar != null) {
            gVar.aiD();
        }
    }

    protected void onDestroy() {
        al.agl().c(this);
        agX();
        al.agl().b(this);
        al.agl().release();
        al.agm().b(this);
        al.agn().b(this);
        al.agn().release();
        e eVar = this.kki;
        f fVar = eVar.kkS;
        fVar.kcX = null;
        fVar.kdc.clear();
        eVar.kkS = null;
        j jVar = eVar.kkQ;
        l.p(jVar.koI);
        for (int size = jVar.koP.size() - 1; size >= 0; size--) {
            l.p((Bitmap) jVar.koP.remove(size));
        }
        jVar.koP.clear();
        if (jVar.iuS.isShowing()) {
            jVar.iuS.dismiss();
        }
        jVar.iuS = null;
        jVar.ahL();
        jVar.iwk = null;
        jVar.kcX = null;
        eVar.kkQ = null;
        if (eVar.kkD != null) {
            eVar.kkD.release();
        }
        eVar.kdb.uSV = null;
        com.tencent.mm.sdk.b.a.urY.c(eVar.klb);
        eVar.kkz.destroy();
        eVar.kkC.destroy();
        eVar.kkB.destroy();
        eVar.kkO.destroy();
        if (eVar.kkP != null) {
            eVar.kkP.destroy();
        }
        if (eVar.kkH != null) {
            eVar.kkH.destroy();
        }
        if (eVar.kkG != null) {
            eVar.kkG.destroy();
        }
        if (eVar.kkI != null) {
            eVar.kkI.destroy();
        }
        if (eVar.kkJ != null) {
            eVar.kkJ.destroy();
        }
        if (eVar.kkK != null) {
            eVar.kkK.destroy();
        }
        if (eVar.kkL != null) {
            eVar.kkL.destroy();
        }
        if (eVar.kkM != null) {
            eVar.kkM.destroy();
        }
        if (eVar.kkN != null) {
            eVar.kkN.destroy();
        }
        if (eVar.kkE != null) {
            eVar.kkE.destroy();
        }
        eVar.kky = null;
        com.tencent.mm.plugin.card.a.g agq = al.agq();
        if (agq.kcI != null && eVar != null) {
            for (int i = 0; i < agq.kcI.size(); i++) {
                WeakReference weakReference = (WeakReference) agq.kcI.get(i);
                if (weakReference != null) {
                    com.tencent.mm.plugin.card.a.g.a aVar = (com.tencent.mm.plugin.card.a.g.a) weakReference.get();
                    if (aVar != null && aVar.equals(eVar)) {
                        agq.kcI.remove(weakReference);
                        break;
                    }
                }
            }
        }
        al.agq().release();
        this.jYD.cancel();
        aeH();
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (this.kcX != null) {
            com.tencent.mm.plugin.report.service.g.oUh.i(13219, new Object[]{"CardDetailView", Integer.valueOf(this.jZM), this.kcX.afn(), this.kcX.afm(), Long.valueOf(currentTimeMillis)});
        } else {
            com.tencent.mm.plugin.report.service.g.oUh.i(13219, new Object[]{"CardDetailView", Integer.valueOf(this.jZM), this.kcJ, this.kcJ, Long.valueOf(currentTimeMillis)});
        }
        if ((this.kkm || this.kkn) && this.kcX.aeO()) {
            if (this.kcX.afb()) {
                al.agm().aA(this.kcJ, 2);
            } else {
                al.agm().aA(this.kcJ, 1);
            }
        }
        super.onDestroy();
    }

    public final void VK() {
        super.VK();
        if (this.khL == 26) {
            overridePendingTransition(0, 0);
        }
    }

    private void agW() {
        ap.vd().a(645, this);
        ap.vd().a(651, this);
        ap.vd().a(563, this);
        ap.vd().a(652, this);
        ap.vd().a(560, this);
        ap.vd().a(699, this);
        ap.vd().a(902, this);
        ap.vd().a(904, this);
        ap.vd().a(1163, this);
    }

    private void agX() {
        ap.vd().b(645, this);
        ap.vd().b(651, this);
        ap.vd().b(563, this);
        ap.vd().b(652, this);
        ap.vd().b(560, this);
        ap.vd().b(699, this);
        ap.vd().b(902, this);
        ap.vd().b(904, this);
        ap.vd().b(1163, this);
    }

    protected final void KC() {
        boolean z;
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardDetailUI kkw;

            {
                this.kkw = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kkw.dd(true);
                return true;
            }
        });
        this.jYD = (Vibrator) getSystemService("vibrator");
        if (this.kki == null) {
            this.kki = new e(this, this.uSU.ipu);
            Object obj = this.kki;
            obj.kkQ = new j(obj.kdb);
            j jVar = obj.kkQ;
            jVar.khH = jVar.iwk.getWindow().getAttributes().screenBrightness;
            if (jVar.iuS == null) {
                View inflate = View.inflate(jVar.iwk, R.i.cWR, null);
                jVar.iuU = inflate.findViewById(R.h.csh);
                jVar.iuT = (ImageView) inflate.findViewById(R.h.csg);
                jVar.koJ = (TextView) inflate.findViewById(R.h.csj);
                jVar.koK = (TextView) inflate.findViewById(R.h.csi);
                jVar.koL = inflate.findViewById(R.h.csd);
                jVar.koM = (ImageView) inflate.findViewById(R.h.csc);
                jVar.koN = (MMVerticalTextView) inflate.findViewById(R.h.cLB);
                jVar.koO = (MMVerticalTextView) inflate.findViewById(R.h.cLC);
                inflate.setOnClickListener(new OnClickListener(jVar) {
                    final /* synthetic */ j koR;

                    {
                        this.koR = r1;
                    }

                    public final void onClick(View view) {
                        if (this.koR.iuS != null && this.koR.iuS.isShowing()) {
                            this.koR.iuS.dismiss();
                        }
                    }
                });
                jVar.iuS = new com.tencent.mm.ui.base.o(inflate, -1, -1, true);
                jVar.iuS.update();
                jVar.iuS.setBackgroundDrawable(new ColorDrawable(16777215));
                jVar.iuS.setOnDismissListener(new OnDismissListener(jVar) {
                    final /* synthetic */ j koR;

                    {
                        this.koR = r1;
                    }

                    public final void onDismiss() {
                    }
                });
            }
            obj.kkS = new f(obj.kdb);
            obj.kdb.uSV = obj;
            com.tencent.mm.sdk.b.a.urY.b(obj.klb);
            e eVar = this.kki;
            if (eVar.kkz == null) {
                eVar.kkz = new x();
                eVar.kkz.a(eVar);
            }
            if (eVar.kkB == null) {
                eVar.kkB = new com.tencent.mm.plugin.card.ui.view.o();
                eVar.kkB.a(eVar);
            }
            if (eVar.kkC == null) {
                eVar.kkC = new com.tencent.mm.plugin.card.ui.view.a();
                eVar.kkC.a(eVar);
            }
            eVar.Fg = (ListView) eVar.findViewById(R.h.byQ);
            eVar.kkF = new l(eVar.kdb.uSU.uTo);
            eVar.kkF.kpr = eVar.iuW;
            eVar.Fg.setAdapter(eVar.kkF);
            eVar.kkF.notifyDataSetChanged();
            eVar.Fg.setOnItemClickListener(new OnItemClickListener(eVar) {
                final /* synthetic */ e klc;

                {
                    this.klc = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    com.tencent.mm.plugin.card.model.b bVar = (com.tencent.mm.plugin.card.model.b) this.klc.kdc.get(i);
                    if (bVar != null && !TextUtils.isEmpty(bVar.url)) {
                        Intent intent = new Intent();
                        if (this.klc.kcX instanceof CardInfo) {
                            intent.putExtra("key_card_info_data", (CardInfo) this.klc.kcX);
                        } else if (this.klc.kcX instanceof ShareCardInfo) {
                            intent.putExtra("key_card_info_data", (ShareCardInfo) this.klc.kcX);
                        }
                        com.tencent.mm.plugin.report.service.g gVar;
                        Object[] objArr;
                        if (bVar.url.equals("card://jump_detail")) {
                            int i2;
                            if (this.klc.kcX.afi().toC == null || TextUtils.isEmpty(this.klc.kcX.afi().toC.url)) {
                                intent.setClass(this.klc.kdb, CardDetailPreference.class);
                                this.klc.kdb.startActivity(intent);
                            } else {
                                com.tencent.mm.plugin.card.b.b.a(this.klc.kdb, this.klc.kcX.afi().toC.url, 1);
                            }
                            gVar = com.tencent.mm.plugin.report.service.g.oUh;
                            objArr = new Object[9];
                            objArr[0] = "CardLeftRightIntroduceView";
                            objArr[1] = Integer.valueOf(this.klc.kcX.afi().kdF);
                            objArr[2] = this.klc.kcX.afn();
                            objArr[3] = this.klc.kcX.afm();
                            objArr[4] = Integer.valueOf(0);
                            objArr[5] = Integer.valueOf(this.klc.kkZ.khL);
                            objArr[6] = this.klc.kkZ.kkj;
                            if (this.klc.kcX.afg()) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            objArr[7] = Integer.valueOf(i2);
                            objArr[8] = "";
                            gVar.i(11324, objArr);
                        } else if (bVar.url.equals("card://jump_shop_list") && this.klc.kcX.afi().ton > 0) {
                            this.klc.ahv();
                        } else if (!bVar.url.equals("card://jump_shop") || this.klc.kcX.afi().ton <= 0) {
                            if (bVar.url.equals("card://jump_service")) {
                                if (!TextUtils.isEmpty(this.klc.kcX.afi().tog)) {
                                    com.tencent.mm.plugin.card.b.b.Q(this.klc.kdb, this.klc.kcX.afi().tog);
                                    al.agg().m(this.klc.kcX.afm(), this.klc.kcX.afn(), 1);
                                }
                                com.tencent.mm.plugin.report.service.g.oUh.i(11582, new Object[]{"OperService", Integer.valueOf(1), Integer.valueOf(this.klc.kcX.afi().kdF), this.klc.kcX.afn(), this.klc.kcX.afm(), this.klc.kkZ.kkj});
                            } else if (bVar.url.equals("card://jump_gift")) {
                                this.klc.ahu();
                                e eVar = this.klc;
                                if (eVar.kcX.afj().tnS == null) {
                                    w.i("MicroMsg.CardDetailUIContoller", "mCardInfo.getDataInfo().gifting_info_cell is null");
                                } else if (eVar.kcX.afj().tnS.tsh == null) {
                                    w.e("MicroMsg.CardDetailUIContoller", "mCardInfo.getDataInfo().gifting_info_cell.gifting_info is null");
                                } else {
                                    com.tencent.mm.plugin.report.service.g.oUh.i(13866, new Object[]{Integer.valueOf(6), eVar.kcX.afj().tnS.tsh.tcV, com.tencent.mm.a.o.getString(eVar.kcX.afj().tnS.tsh.tcU)});
                                }
                            } else if (bVar.url.equals("card://jump_card_gift")) {
                                if (this.klc.kcX.afj().tnS == null) {
                                    w.e("MicroMsg.CardDetailUIContoller", "jump_card_gift mCardInfo.getDataInfo().gifting_info_cell is null");
                                } else if (this.klc.kcX.afj().tnS.tsh == null) {
                                    w.e("MicroMsg.CardDetailUIContoller", "jump_card_gift mCardInfo.getDataInfo().gifting_info_cell.gifting_info is null");
                                } else {
                                    e eVar2 = this.klc;
                                    w.d("MicroMsg.CardDetailUIContoller", "doJumpCardGift, order_id:%s, biz_uin:%d", new Object[]{this.klc.kcX.afj().tnS.tsh.tcV, Integer.valueOf(this.klc.kcX.afj().tnS.tsh.tcU)});
                                    Intent intent2 = new Intent(eVar2.kdb, CardGiftReceiveUI.class);
                                    intent2.putExtra("key_biz_uin", r2);
                                    intent2.putExtra("key_order_id", r0);
                                    intent2.putExtra("key_gift_into", (CardGiftInfo) eVar2.kdb.getIntent().getParcelableExtra("key_card_git_info"));
                                    eVar2.kdb.startActivity(intent2);
                                    com.tencent.mm.plugin.report.service.g.oUh.i(13866, new Object[]{Integer.valueOf(5), this.klc.kcX.afj().tnS.tsh.tcV, com.tencent.mm.a.o.getString(this.klc.kcX.afj().tnS.tsh.tcU)});
                                }
                            } else if ((bVar.tpl & 32) > 0) {
                                com.tencent.mm.ui.MMActivity.a aVar = this.klc;
                                com.tencent.mm.plugin.card.b.b.a(aVar.kdb, 4, aVar);
                                aVar.kdb.uSV = aVar;
                            } else if (com.tencent.mm.plugin.card.b.b.d(this.klc.kcX.afm(), bVar.tnY, bVar.tnZ, this.klc.kkZ.khL, this.klc.kkZ.klf)) {
                                com.tencent.mm.plugin.report.service.g.oUh.i(11941, new Object[]{Integer.valueOf(21), this.klc.kcX.afm(), this.klc.kcX.afn(), "", bVar.title});
                            } else {
                                String afm;
                                com.tencent.mm.plugin.card.b.b.a(this.klc.kdb, l.o(bVar.url, bVar.tpl), 1);
                                com.tencent.mm.plugin.report.service.g.oUh.i(11492, new Object[]{Integer.valueOf(this.klc.kkZ.khL), this.klc.kkZ.kkk, this.klc.kcX.afm(), this.klc.kcX.afn(), Integer.valueOf(this.klc.kcX.afj().status), afm, Integer.valueOf(this.klc.kcX.afi().kdF), this.klc.kcX.afi().tog});
                                com.tencent.mm.plugin.report.service.g.oUh.i(11941, new Object[]{Integer.valueOf(6), this.klc.kcX.afm(), this.klc.kcX.afn(), "", bVar.title});
                                if (l.a(bVar, this.klc.kcX.afm())) {
                                    afm = this.klc.kcX.afm();
                                    r0 = bVar.title;
                                    l.tg(afm);
                                    com.tencent.mm.plugin.card.b.b.a(this.klc.kdb, this.klc.kcX.afi().keT);
                                }
                            }
                        } else if (this.klc.kde == null || this.klc.kde.size() == 0) {
                            w.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                        } else {
                            iw iwVar = (iw) this.klc.kde.get(0);
                            if (!(iwVar == null || TextUtils.isEmpty(iwVar.kfu))) {
                                com.tencent.mm.plugin.card.b.b.a(this.klc.kdb, iwVar.kfu, 1);
                                com.tencent.mm.plugin.report.service.g.oUh.i(11941, new Object[]{Integer.valueOf(4), this.klc.kcX.afm(), this.klc.kcX.afn(), "", iwVar.name});
                            }
                            gVar = com.tencent.mm.plugin.report.service.g.oUh;
                            objArr = new Object[9];
                            objArr[0] = "UsedStoresView";
                            objArr[1] = Integer.valueOf(this.klc.kcX.afi().kdF);
                            objArr[2] = this.klc.kcX.afn();
                            objArr[3] = this.klc.kcX.afm();
                            objArr[4] = Integer.valueOf(0);
                            objArr[5] = Integer.valueOf(this.klc.kkZ.khL);
                            objArr[6] = this.klc.kkZ.kkj;
                            objArr[7] = Integer.valueOf(this.klc.kcX.afg() ? 1 : 0);
                            objArr[8] = "";
                            gVar.i(11324, objArr);
                        }
                    }
                }
            });
            eVar.dU = (LinearLayout) eVar.findViewById(R.h.bWh);
            eVar.kkO = new com.tencent.mm.plugin.card.ui.view.d();
            eVar.kkO.a(eVar);
            eVar.kkQ.kcX = eVar.kcX;
        }
        int intExtra = getIntent().getIntExtra("key_from_scene", -1);
        w.i("MicroMsg.CardDetailUI", "scene:%d", new Object[]{Integer.valueOf(intExtra)});
        String stringExtra;
        com.tencent.mm.plugin.card.model.d sV;
        if (intExtra == 2 || intExtra == 6 || intExtra == 5) {
            this.jZM = intExtra;
            stringExtra = getIntent().getStringExtra("key_card_app_msg");
            sV = com.tencent.mm.plugin.card.b.g.sV(stringExtra);
            if (sV != null) {
                this.kcJ = sV.fVl;
                this.kkj = sV.keR;
                this.kkl = sV.fVm;
                int i = sV.keU;
                w.i("MicroMsg.CardDetailUI", "scene is " + intExtra + ", isRecommend is " + i);
                if (i == 1 && intExtra == 2) {
                    this.jZM = 23;
                }
                this.kkp = sV.keV;
                w.i("MicroMsg.CardDetailUI", "recommend_card_id is " + this.kkp);
            }
            this.kkk = com.tencent.mm.plugin.card.b.g.sW(stringExtra);
        } else if (l.kG(intExtra) || intExtra == 0 || intExtra == 1 || intExtra == 3 || intExtra == 4 || intExtra == 9 || intExtra == 12 || intExtra == 15 || intExtra == 17 || intExtra == 21) {
            this.jZM = intExtra;
            this.kcJ = getIntent().getStringExtra("key_card_id");
            this.kkl = getIntent().getStringExtra("key_card_ext");
            this.kdR = getIntent().getBooleanExtra("key_is_share_card", false);
            this.kjS = getIntent().getIntExtra("key_stastic_scene", 0);
            this.kjV = getIntent().getStringExtra("key_consumed_card_id");
            if (intExtra == 7 || intExtra == 16) {
                this.kjT = getIntent().getStringExtra("src_username");
                this.kjU = getIntent().getStringExtra("js_url");
                this.hir = getIntent().getStringExtra("key_template_id");
            } else if (this.kdR && intExtra == 3) {
                this.kdA = getIntent().getStringExtra("key_card_tp_id");
                this.kcJ = com.tencent.mm.plugin.card.sharecard.a.b.by(this.kcJ, this.kdA);
            } else if (intExtra == 8) {
                this.kkr = getIntent().getBooleanExtra("key_is_sms_add_card", false);
            }
        } else if (intExtra == 50 || intExtra == 27) {
            this.jZM = getIntent().getIntExtra("key_previous_scene", 50);
            if (!(this.jZM == 26 || this.jZM == 27)) {
                this.jZM = 3;
            }
            this.hir = getIntent().getStringExtra("key_template_id");
            if (this.jZM == 27) {
                b bVar = (b) getIntent().getParcelableExtra("key_card_info");
                if (bVar != null) {
                    this.kcX = bVar;
                    this.kcJ = this.kcX.afm();
                    agY();
                    ahb();
                    if (this.kcX.afc()) {
                        al.agn().sh(this.kcX.afm());
                    }
                    agB();
                }
                agZ();
                l.aiI();
            } else {
                LinkedList aE = k.aE(getIntent().getStringExtra("card_list"), this.jZM);
                if (aE == null || aE.size() == 0) {
                    w.e("MicroMsg.CardDetailUI", "initData tempList size is empty");
                    dd(true);
                } else {
                    da(true);
                    this.kcJ = ((jc) aE.get(0)).kdE;
                    intExtra = getIntent().getIntExtra("key_previous_scene", 51);
                    bde com_tencent_mm_protocal_c_bde = new bde();
                    com_tencent_mm_protocal_c_bde.ueu = this.hir;
                    w.i("MicroMsg.CardDetailUI", "doBatchGetCardItemByTpInfo templateId:%s", new Object[]{this.hir});
                    ap.vd().a(new t(aE, com_tencent_mm_protocal_c_bde, intExtra), 0);
                }
                agY();
            }
            this.kki.a(this.kcX, this.kkq, this.kde);
            this.kki.kkY = new e.d(this) {
                final /* synthetic */ CardDetailUI kkw;

                {
                    this.kkw = r1;
                }

                public final void ahd() {
                    CardDetailUI.h(this.kkw);
                }

                public final void sM(String str) {
                    CardDetailUI.a(this.kkw, str);
                }

                public final void ahe() {
                    CardDetailUI.i(this.kkw);
                }

                public final void ahf() {
                    CardDetailUI.j(this.kkw);
                }

                public final void ahg() {
                    this.kkw.dd(true);
                }

                public final void ahh() {
                    ap.vd().a(new com.tencent.mm.plugin.card.sharecard.model.a(this.kkw.kcJ), 0);
                }

                public final void d(b bVar) {
                    this.kkw.kcX = bVar;
                    this.kkw.kcJ = bVar.afm();
                    this.kkw.kkq.kcJ = this.kkw.kcJ;
                }

                public final void ahc() {
                    this.kkw.ahc();
                }

                public final void ahi() {
                    w.i("MicroMsg.CardDetailUI", "onConsumeCodeUIResult()");
                }

                public final void de(boolean z) {
                    w.i("MicroMsg.CardDetailUI", "doMark()");
                    this.kkw.kkn = true;
                    this.kkw.da(true);
                    this.kkw.kko = z;
                    if (this.kkw.kcX.afb()) {
                        al.agm().x(this.kkw.kcJ, l.th(this.kkw.kcX.afo()), 2);
                    } else {
                        al.agm().x(this.kkw.kcJ, l.th(this.kkw.kcX.afo()), 1);
                    }
                }
            };
            w.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
            this.kiV = z;
            if (!this.kiV) {
                this.hvP = c.Gk();
                aeF();
            }
        } else if (intExtra == 51) {
            if (getIntent().getIntExtra("key_previous_scene", 51) == 26) {
                this.jZM = 26;
            } else {
                this.jZM = 3;
            }
            this.kcJ = getIntent().getStringExtra("key_card_id");
            this.kcX = al.agf().kcz;
            if (this.kcX == null) {
                this.kcX = al.aga().sr(this.kcJ);
            }
            agY();
            if (this.kcX == null) {
                w.e("MicroMsg.CardDetailUI", "initData, mCardId is null from scene == ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_VIEW_UI");
                dd(true);
            } else {
                ahb();
                agB();
                agZ();
                if (this.kcX.afc()) {
                    al.agn().sh(this.kcX.afm());
                }
            }
            this.kki.a(this.kcX, this.kkq, this.kde);
            this.kki.kkY = /* anonymous class already generated */;
            w.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
            this.kiV = z;
            if (!this.kiV) {
                this.hvP = c.Gk();
                aeF();
            }
        } else if (intExtra == 26) {
            this.jZM = intExtra;
            this.kcJ = getIntent().getStringExtra("key_card_id");
            this.kkl = getIntent().getStringExtra("key_card_ext");
        } else {
            this.jZM = intExtra;
            stringExtra = getIntent().getStringExtra("key_card_app_msg");
            sV = com.tencent.mm.plugin.card.b.g.sV(stringExtra);
            if (sV != null) {
                this.kcJ = sV.fVl;
                this.kkj = sV.keR;
                this.kkl = sV.fVm;
            }
            this.kkk = com.tencent.mm.plugin.card.b.g.sW(stringExtra);
        }
        agY();
        if (TextUtils.isEmpty(this.kcJ)) {
            w.e("MicroMsg.CardDetailUI", "initData, mCardId is null");
            dd(true);
        } else {
            if (intExtra == 2 || intExtra == 6 || ((intExtra == 4 && !this.kdR) || intExtra == 5 || intExtra == 17 || intExtra == 21 || intExtra == 23)) {
                z = true;
            } else if (intExtra == 15) {
                Object value = al.agf().getValue("key_accept_card_info");
                if (value == null || !(value instanceof CardInfo)) {
                    z = true;
                } else {
                    this.kcX = (CardInfo) value;
                    z = false;
                }
            } else if (this.kdR) {
                this.kcX = al.agi().sH(this.kcJ);
                z = false;
            } else {
                this.kcX = al.aga().sr(this.kcJ);
                z = false;
            }
            if (z || this.kcX == null) {
                w.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene1 is true or no cardinfo with cardId = " + this.kcJ + " isShareCard is " + this.kdR);
                da(true);
                if (this.kdR) {
                    ahc();
                } else {
                    aha();
                }
            } else {
                w.d("MicroMsg.CardDetailUI", "initData(), cardId = " + this.kcJ);
                iw afl = this.kcX.afl();
                if (afl != null) {
                    this.kde = new ArrayList();
                    this.kde.add(afl);
                }
                agB();
                if (this.kcX.afc()) {
                    al.agn().sh(this.kcX.afm());
                }
                if (this.kdR) {
                    this.kks = true;
                    z = true;
                } else {
                    if (((long) ((int) (System.currentTimeMillis() / 1000))) - this.kcX.afp() >= 86400) {
                        this.kks = true;
                        z = true;
                    } else if (this.kcX.aeZ()) {
                        this.kks = true;
                        z = true;
                    }
                }
                if (z) {
                    w.i("MicroMsg.CardDetailUI", "initData fail, isNeedDoNetScene2 is true or no cardinfo with cardId = " + this.kcJ + " isShareCard is " + this.kdR);
                    if (this.kdR) {
                        ahc();
                    } else {
                        aha();
                    }
                } else {
                    ahb();
                }
                agZ();
            }
        }
        this.kki.a(this.kcX, this.kkq, this.kde);
        this.kki.kkY = /* anonymous class already generated */;
        w.i("MicroMsg.CardDetailUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
        this.kiV = z;
        if (!this.kiV) {
            this.hvP = c.Gk();
            aeF();
        }
    }

    private void agY() {
        this.khL = this.jZM;
        this.kkq = new e.a();
        this.kkq.jZM = this.jZM;
        this.kkq.khL = this.khL;
        this.kkq.kcJ = this.kcJ;
        this.kkq.kkj = this.kkj;
        this.kkq.kkl = this.kkl;
        this.kkq.kkk = this.kkk;
        this.kkq.kjT = this.kjT;
        this.kkq.kjU = this.kjU;
        this.kkq.kdR = this.kdR;
        this.kkq.klf = getIntent().getIntExtra("key_from_appbrand_type", 0);
    }

    private void agZ() {
        int i = 1;
        if (!this.kkt && this.kcX != null) {
            this.kkt = true;
            com.tencent.mm.plugin.report.service.g gVar;
            Object[] objArr;
            if (this.kdR) {
                gVar = com.tencent.mm.plugin.report.service.g.oUh;
                objArr = new Object[9];
                objArr[0] = "ShareCardDetailUI";
                objArr[1] = Integer.valueOf(this.kcX.afi().kdF);
                objArr[2] = this.kcX.afn();
                objArr[3] = this.kcX.afm();
                objArr[4] = Integer.valueOf(0);
                objArr[5] = Integer.valueOf(this.khL);
                objArr[6] = this.kkj;
                if (!this.kcX.afg()) {
                    i = 0;
                }
                objArr[7] = Integer.valueOf(i);
                objArr[8] = "";
                gVar.i(11324, objArr);
                return;
            }
            gVar = com.tencent.mm.plugin.report.service.g.oUh;
            objArr = new Object[9];
            objArr[0] = "CardDetailView";
            objArr[1] = Integer.valueOf(this.kcX.afi().kdF);
            objArr[2] = this.kcX.afn();
            objArr[3] = this.kcX.afm();
            objArr[4] = Integer.valueOf(0);
            objArr[5] = Integer.valueOf(this.khL);
            objArr[6] = this.kkj;
            if (!this.kcX.afg()) {
                i = 0;
            }
            objArr[7] = Integer.valueOf(i);
            objArr[8] = "";
            gVar.i(11324, objArr);
        }
    }

    private void agB() {
        this.kkq.jZM = this.jZM;
        this.kkq.khL = this.khL;
        this.kkq.kcJ = this.kcJ;
        this.kki.a(this.kcX, this.kkq, this.kde);
        this.kki.agB();
        al.agl().kcX = this.kcX;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + i + " errCode = " + i2);
        int i3;
        if (i == 0 && i2 == 0) {
            da(false);
            b bVar;
            b cardInfo;
            if (kVar instanceof aa) {
                String str2 = ((aa) kVar).kfG;
                if (TextUtils.isEmpty(str2)) {
                    w.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetCardItemInfo return json is null");
                    return;
                }
                bVar = this.kcX;
                cardInfo = new CardInfo();
                com.tencent.mm.plugin.card.b.f.a((CardInfo) cardInfo, str2);
                if (!TextUtils.isEmpty(cardInfo.afm())) {
                    this.kcJ = cardInfo.afm();
                } else if (TextUtils.isEmpty(cardInfo.afm()) && !this.kcJ.equals(cardInfo.afn())) {
                    w.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[]{this.kcJ, cardInfo.afn()});
                    return;
                }
                this.kcX = cardInfo;
                ahb();
                if (this.jZM == 3) {
                    if (bVar != null) {
                        ((CardInfo) this.kcX).field_stickyAnnouncement = ((CardInfo) bVar).field_stickyAnnouncement;
                        ((CardInfo) this.kcX).field_stickyEndTime = ((CardInfo) bVar).field_stickyEndTime;
                        ((CardInfo) this.kcX).field_stickyIndex = ((CardInfo) bVar).field_stickyIndex;
                        ((CardInfo) this.kcX).field_label_wording = ((CardInfo) bVar).field_label_wording;
                        this.kcX.a(bVar.afl());
                    }
                    if (this.kks) {
                        l.j(this.kcX);
                    } else {
                        w.e("MicroMsg.CardDetailUI", "onSceneEnd(), NetSceneGetCardItemInfo updateDataToDB is false");
                    }
                }
                agB();
                agZ();
                if (this.kcX.afc()) {
                    al.agn().sh(this.kcX.afm());
                    return;
                }
                return;
            } else if (kVar instanceof o) {
                if (this.khL == 26) {
                    da(false);
                }
                r1 = ((o) kVar).kfG;
                r2 = ((o) kVar).kfH;
                r0 = ((o) kVar).kfI;
                if (r2 != 0) {
                    b(i2, str, r2, r0);
                } else {
                    com.tencent.mm.ui.base.g.bl(this, getResources().getString(R.l.dQp));
                }
                if (TextUtils.isEmpty(r1)) {
                    w.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneAcceptCardItem return json is null");
                    return;
                }
                this.jZM = 3;
                if (this.kcX == null) {
                    this.kcX = new CardInfo();
                }
                com.tencent.mm.plugin.card.b.f.a((CardInfo) this.kcX, r1);
                if (!TextUtils.isEmpty(this.kcX.afm())) {
                    this.kcJ = this.kcX.afm();
                }
                if (this.kki.ahw() == 1) {
                    e eVar = this.kki;
                    if (eVar.kkS != null) {
                        f fVar = eVar.kkS;
                        if (fVar.kdd != null) {
                            fVar.kdd.kdU = false;
                        }
                    }
                }
                if (this.khL != 26) {
                    ahb();
                    agB();
                }
                l.aiI();
                cardInfo = this.kcX;
                if (cardInfo.aeP()) {
                    ap.yY();
                    r0 = (Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uAS, Integer.valueOf(0));
                    if (r0 == null || r0.intValue() != 1) {
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAS, Integer.valueOf(1));
                    }
                    this.kkv = this.kcX.afs();
                    if (this.khL != 7 || this.khL == 16) {
                        r0 = new Intent();
                        r0.putExtra("key_code", this.kkv);
                        setResult(-1, r0);
                        kz(-1);
                    } else if (!this.kkr && this.khL == 8) {
                        dd(true);
                    } else if (this.khL == 26 && r2 == 0) {
                        dd(true);
                    }
                    if (!this.kcX.afc()) {
                        al.agn().sh(this.kcX.afm());
                        return;
                    }
                    return;
                }
                ap.yY();
                r0 = (Integer) com.tencent.mm.u.c.vr().get(282884, null);
                if (r0 == null || r0.intValue() != 1) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(282884, Integer.valueOf(1));
                }
                this.kkv = this.kcX.afs();
                if (this.khL != 7) {
                }
                r0 = new Intent();
                r0.putExtra("key_code", this.kkv);
                setResult(-1, r0);
                kz(-1);
                if (!this.kcX.afc()) {
                    al.agn().sh(this.kcX.afm());
                    return;
                }
                return;
                if (l.aiL()) {
                    com.tencent.mm.plugin.card.b.d.c(this, R.i.cXa, R.l.dQm, cardInfo.afi().keS);
                } else {
                    com.tencent.mm.plugin.card.b.d.c(this, R.i.cWZ, R.l.dQl, cardInfo.afi().keS);
                }
                this.kkv = this.kcX.afs();
                if (this.khL != 7) {
                }
                r0 = new Intent();
                r0.putExtra("key_code", this.kkv);
                setResult(-1, r0);
                kz(-1);
                if (!this.kcX.afc()) {
                    al.agn().sh(this.kcX.afm());
                    return;
                }
                return;
            } else if (kVar instanceof v) {
                this.kde = ((v) kVar).kfP;
                if (this.kcX != null && this.kde != null && this.kde.size() > 0) {
                    this.kcX.a((iw) this.kde.get(0));
                    agB();
                    com.tencent.mm.sdk.e.c sH;
                    if (this.kcX.aeO()) {
                        sH = al.agi().sH(this.kcJ);
                        if (sH != null) {
                            sH.a((iw) this.kde.get(0));
                            al.agi().c(sH, new String[]{this.kcJ});
                            return;
                        }
                        return;
                    }
                    sH = al.aga().sr(this.kcJ);
                    if (sH != null) {
                        sH.a((iw) this.kde.get(0));
                        al.aga().c(sH, new String[]{this.kcJ});
                        return;
                    }
                    return;
                } else if (this.kcX != null && this.kde == null) {
                    this.kcX.a(null);
                    agB();
                    com.tencent.mm.sdk.e.c sH2;
                    if (this.kcX.aeO()) {
                        sH2 = al.agi().sH(this.kcJ);
                        if (sH2 != null) {
                            sH2.a(null);
                            al.agi().c(sH2, new String[]{this.kcJ});
                            return;
                        }
                        return;
                    }
                    sH2 = al.aga().sr(this.kcJ);
                    if (sH2 != null) {
                        sH2.a(null);
                        al.aga().c(sH2, new String[]{this.kcJ});
                        return;
                    }
                    return;
                } else {
                    return;
                }
            } else if (kVar instanceof af) {
                i3 = ((af) kVar).kfH;
                r0 = ((af) kVar).kfI;
                if (i3 == 10000) {
                    if (TextUtils.isEmpty(r0)) {
                        r0 = getString(R.l.dQR);
                    }
                    com.tencent.mm.plugin.card.b.d.b(this, r0);
                    return;
                }
                this.kkl = ((af) kVar).fVm;
                dc(true);
                it afj = this.kcX.afj();
                afj.status = 3;
                this.kcX.a(afj);
                l.j(this.kcX);
                agB();
                if (this.khL == 3) {
                    dd(true);
                    return;
                } else if (this.khL == 15) {
                    com.tencent.mm.sdk.b.a.urY.m(new oc());
                    return;
                } else {
                    return;
                }
            } else if (kVar instanceof r) {
                com.tencent.mm.ui.base.g.bl(this, getResources().getString(R.l.dQG));
                al.afZ();
                com.tencent.mm.plugin.card.a.b.kn(4);
                dd(true);
                return;
            } else if (kVar instanceof t) {
                LinkedList linkedList = ((t) kVar).kfN;
                if (linkedList != null && linkedList.size() > 0) {
                    b bVar2 = (b) linkedList.get(0);
                    if (bVar2 == null || this.kcJ.equals(bVar2.afn())) {
                        this.kcX = bVar2;
                        if (this.kcX != null) {
                            this.kcJ = this.kcX.afm();
                            ahb();
                            if (this.kcX.afc()) {
                                al.agn().sh(this.kcX.afm());
                            }
                        }
                        if (this.jZM == 26) {
                            this.jZM = 3;
                        }
                        agB();
                    } else {
                        w.e("MicroMsg.CardDetailUI", "mCardId:%s, mCardTpId:%s is different, error", new Object[]{this.kcJ, bVar2.afn()});
                        return;
                    }
                }
                agZ();
                l.aiI();
                return;
            } else if (kVar instanceof g) {
                r1 = ((g) kVar).kfG;
                r2 = ((g) kVar).kfH;
                r0 = ((g) kVar).kfI;
                if (r2 != 0) {
                    if (TextUtils.isEmpty(r0)) {
                        r0 = getString(R.l.dQe);
                    }
                    com.tencent.mm.plugin.card.b.d.b(this, r0);
                    w.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, accept card error, ret_msg:%s", new Object[]{r0});
                    return;
                }
                com.tencent.mm.ui.base.g.bl(this, getResources().getString(R.l.dQh));
                if (TextUtils.isEmpty(r1)) {
                    w.e("MicroMsg.CardDetailUI", "NetSceneShareCardItem onSceneEnd, json is null");
                    return;
                }
                this.jZM = 3;
                if (this.kcX == null) {
                    this.kcX = new ShareCardInfo();
                } else if (this.kcX instanceof CardInfo) {
                    this.kcX = new ShareCardInfo();
                }
                com.tencent.mm.plugin.card.b.f.a((ShareCardInfo) this.kcX, r1);
                r0 = (ShareCardInfo) this.kcX;
                if (TextUtils.isEmpty(r1)) {
                    w.e("MicroMsg.CardInfoParser", "parserShareCardItemEncryptCodeForSingle jsonContent is null");
                } else {
                    try {
                        JSONArray optJSONArray = new JSONObject(r1).optJSONArray("card_list");
                        if (optJSONArray != null) {
                            r0.kdJ = optJSONArray.optJSONObject(0).optString("encrypt_code");
                            w.i("MicroMsg.CardInfoParser", "encrypt_code:" + r0.kdJ);
                        }
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.CardInfoParser", e, "", new Object[0]);
                        w.e("MicroMsg.CardInfoParser", e.getMessage());
                    }
                }
                if (!TextUtils.isEmpty(this.kcX.afm())) {
                    this.kcJ = this.kcX.afm();
                }
                if (TextUtils.isEmpty(this.kcX.afo())) {
                    ((ShareCardInfo) this.kcX).field_from_username = m.xL();
                }
                l.a((ShareCardInfo) this.kcX);
                ahb();
                agB();
                l.aiK();
                al.agh().adZ();
                this.kkv = this.kcX.afs();
                if (this.khL == 7 || this.khL == 16) {
                    r0 = new Intent();
                    r0.putExtra("key_code", this.kkv);
                    setResult(-1, r0);
                    kz(-1);
                } else if (!this.kkr && this.khL == 8) {
                    dd(true);
                }
                ap.yY();
                r0 = (Integer) com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uAQ, Integer.valueOf(0));
                if (r0 == null || r0.intValue() != 1) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(com.tencent.mm.storage.w.a.uAQ, Integer.valueOf(1));
                    com.tencent.mm.plugin.card.b.d.c(this, R.i.cXc, R.l.dRS, "");
                }
                if (this.kcX.afc()) {
                    al.agn().sh(this.kcX.afm());
                    return;
                }
                return;
            } else if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.c) {
                Object obj = ((com.tencent.mm.plugin.card.sharecard.model.c) kVar).kfG;
                if (TextUtils.isEmpty(obj)) {
                    w.e("MicroMsg.CardDetailUI", "onSceneEnd, NetSceneGetShareCard json is null");
                    return;
                }
                bVar = this.kcX;
                this.kcX = new ShareCardInfo();
                r0 = (ShareCardInfo) this.kcX;
                if (TextUtils.isEmpty(obj)) {
                    w.e("MicroMsg.CardInfoParser", "parserShareCardItemJson jsonContent is null");
                } else {
                    try {
                        com.tencent.mm.plugin.card.b.f.a(r0, new JSONObject(obj));
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.CardInfoParser", e2, "", new Object[0]);
                    }
                }
                if (bVar != null) {
                    if (!TextUtils.isEmpty(bVar.afo())) {
                        ((ShareCardInfo) this.kcX).field_from_username = ((ShareCardInfo) bVar).field_from_username;
                    }
                    ((ShareCardInfo) this.kcX).field_app_id = ((ShareCardInfo) bVar).field_app_id;
                    ((ShareCardInfo) this.kcX).field_consumer = ((ShareCardInfo) bVar).field_consumer;
                    ((ShareCardInfo) this.kcX).field_share_time = ((ShareCardInfo) bVar).field_share_time;
                    ((ShareCardInfo) this.kcX).field_updateTime = ((ShareCardInfo) bVar).field_updateTime;
                    ((ShareCardInfo) this.kcX).field_begin_time = ((ShareCardInfo) bVar).field_begin_time;
                    ((ShareCardInfo) this.kcX).field_end_time = ((ShareCardInfo) bVar).field_end_time;
                    ((ShareCardInfo) this.kcX).field_block_mask = ((ShareCardInfo) bVar).field_block_mask;
                    this.kcX.a(bVar.afl());
                    ((ShareCardInfo) this.kcX).field_categoryType = ((ShareCardInfo) bVar).field_categoryType;
                    ((ShareCardInfo) this.kcX).field_itemIndex = ((ShareCardInfo) bVar).field_itemIndex;
                    if (((ShareCardInfo) bVar).field_status != ((ShareCardInfo) this.kcX).field_status) {
                        w.i("MicroMsg.CardDetailUI", "getsharecared return, the status is " + ((ShareCardInfo) this.kcX).field_status);
                        com.tencent.mm.plugin.card.sharecard.a.b.a((Context) this, this.kcX);
                    }
                }
                if (!TextUtils.isEmpty(this.kcX.afm())) {
                    this.kcJ = this.kcX.afm();
                }
                agB();
                ahb();
                agZ();
                if (this.jZM == 3) {
                    if (this.kks) {
                        l.j(this.kcX);
                    } else {
                        w.e("MicroMsg.CardDetailUI", "onSceneEnd() sharecard updateDataToDB is false");
                    }
                }
                if (this.kcX.afc()) {
                    al.agn().sh(this.kcX.afm());
                    return;
                }
                return;
            } else if (!(kVar instanceof com.tencent.mm.plugin.card.sharecard.model.a)) {
                return;
            } else {
                if (((com.tencent.mm.plugin.card.sharecard.model.a) kVar).kfH != 0) {
                    com.tencent.mm.plugin.card.b.d.b(this, getString(R.l.dQE));
                    return;
                }
                w.i("MicroMsg.CardDetailUI", "delete share card, card id is " + this.kcX.afm());
                com.tencent.mm.plugin.card.sharecard.a.b.a((Context) this, this.kcX);
                com.tencent.mm.ui.base.g.bl(this, getResources().getString(R.l.dQG));
                al.agh().agr();
                dd(true);
                return;
            }
        }
        CharSequence charSequence;
        w.e("MicroMsg.CardDetailUI", "onSceneEnd, errType = " + i + " errCode = " + i2 + " cmd:" + kVar.getType());
        da(false);
        Object obj2;
        if (kVar instanceof af) {
            dc(false);
            i3 = ((af) kVar).kfH;
            charSequence = ((af) kVar).kfI;
            if (i3 == 10000) {
                if (TextUtils.isEmpty(charSequence)) {
                    charSequence = getString(R.l.dQR);
                }
            }
            obj2 = str;
        } else if (kVar instanceof o) {
            kz(0);
            b(i2, str, ((o) kVar).kfH, ((o) kVar).kfI);
            return;
        } else {
            if (kVar instanceof v) {
                return;
            }
            obj2 = str;
        }
        if (TextUtils.isEmpty(charSequence)) {
            charSequence = getString(R.l.fkA);
        }
        Toast.makeText(this.uSU.uTo, charSequence, 0).show();
    }

    private void b(int i, String str, int i2, String str2) {
        w.e("MicroMsg.CardDetailUI", "handleAcceptError, errCode = " + i + " errMsg = " + str + " ret_code:" + i2 + " ret_msg:" + str2);
        if (i2 == 10000) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.l.dQf);
            }
            this.kcX.afj().status = 4;
            agB();
        } else if (i2 == CdnLogic.MediaType_FAVORITE_FILE) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.l.dQi);
            }
            this.kcX.afj().status = 5;
            agB();
        } else if (i2 == CdnLogic.MediaType_FAVORITE_VIDEO) {
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.l.dRw);
            }
        } else if (TextUtils.isEmpty(str2)) {
            str2 = getString(R.l.dQd);
        }
        com.tencent.mm.plugin.card.b.d.b(this, str2);
    }

    private void da(boolean z) {
        if (z) {
            this.iLz = p.b(this, getString(R.l.cbS), true, 0, null);
        } else if (this.iLz != null && this.iLz.isShowing()) {
            this.iLz.dismiss();
            this.iLz = null;
        }
    }

    private void dc(boolean z) {
        if (z) {
            l.bF(this.kki.kkU, this.kki.kkT);
        }
    }

    private void aha() {
        bde com_tencent_mm_protocal_c_bde = new bde();
        com_tencent_mm_protocal_c_bde.ueu = this.hir;
        com_tencent_mm_protocal_c_bde.keV = this.kkp;
        w.i("MicroMsg.CardDetailUI", "GetCardItemInfo templateId:%s", new Object[]{this.hir});
        ap.vd().a(new aa(this.kcJ, this.jZM, this.kkj, this.kkl, this.kjT, this.kjU, this.kjS, this.kjV, com_tencent_mm_protocal_c_bde), 0);
    }

    private void ahb() {
        String afn;
        if (!TextUtils.isEmpty(this.kcX.afn())) {
            afn = this.kcX.afn();
        } else if (TextUtils.isEmpty(this.kcJ)) {
            w.e("MicroMsg.CardDetailUI", "doNetSceneCardShopLBS card id is null, return");
            return;
        } else {
            afn = this.kcJ;
        }
        if (this.kcX != null && this.kcX.afi().ton == 1) {
            float f = this.gKj;
            float f2 = this.gKk;
            if (f == -85.0f || f2 == -1000.0f) {
                f = al.agg().gKj;
                f2 = al.agg().gKk;
            }
            ap.vd().a(new v(afn, f2, f, this.kcX.afm()), 0);
        } else if (this.kcX == null || this.kcX.afi().ton <= 1) {
            if (this.kcX != null) {
                this.kcX.a(null);
                agB();
                com.tencent.mm.sdk.e.c sH;
                if (this.kcX.aeO()) {
                    sH = al.agi().sH(this.kcJ);
                    if (sH != null) {
                        sH.a(null);
                        al.agi().c(sH, new String[]{this.kcJ});
                        return;
                    }
                    return;
                }
                sH = al.aga().sr(this.kcJ);
                if (sH != null) {
                    sH.a(null);
                    al.aga().c(sH, new String[]{this.kcJ});
                }
            }
        } else if (this.gKj != -85.0f && this.gKk != -1000.0f) {
            this.kku = false;
            ap.vd().a(new v(afn, this.gKk, this.gKj, this.kcX.afm()), 0);
        } else if (!this.kku) {
            this.kku = true;
            if (this.kiV) {
                aeF();
            }
        }
    }

    private void ahc() {
        ap.vd().a(new com.tencent.mm.plugin.card.sharecard.model.c(this.kcJ), 0);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            w.e("MicroMsg.CardDetailUI", "onKeyDown finishUI");
            dd(false);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void dd(boolean z) {
        if ((this.khL == 7 || this.khL == 8 || this.khL == 16 || this.khL == 26) && this.jZM == 3) {
            Intent intent = new Intent();
            intent.putExtra("key_code", this.kkv);
            setResult(-1, intent);
            if (z) {
                finish();
            }
        } else if ((this.khL == 7 && this.jZM == 7) || ((this.khL == 16 && this.jZM == 16) || ((this.khL == 8 && this.jZM == 8) || (this.khL == 26 && this.jZM == 26)))) {
            setResult(0);
            if (z) {
                finish();
            }
        } else if (z) {
            finish();
        }
    }

    private void kz(int i) {
        if (this.khL == 7 || this.khL == 16) {
            LinkedList linkedList = new LinkedList();
            com.tencent.mm.plugin.card.model.e eVar = new com.tencent.mm.plugin.card.model.e();
            eVar.kdE = this.kcX.afn();
            eVar.fVm = this.kkl;
            eVar.code = this.kkv;
            linkedList.add(eVar);
            com.tencent.mm.sdk.b.b bVar = new com.tencent.mm.e.a.b();
            bVar.fCf.aMA = i;
            if (i == -1) {
                bVar.fCf.fCg = h.a(linkedList, true, this.khL);
            } else {
                bVar.fCf.fCg = h.a(linkedList, false, this.khL);
            }
            com.tencent.mm.sdk.b.a.urY.m(bVar);
            return;
        }
        w.i("MicroMsg.CardDetailUI", "mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_JSAPI and mPreviousScene != ConstantsProtocal.MM_CARD_ITEM_FROM_SCENE_NEARBY_PEOPLE_JSAPI ,don't push accept event");
    }

    private void aeF() {
        if (this.hvP == null) {
            this.hvP = c.Gk();
        }
        this.hvP.a(this.gKp, true);
    }

    private void aeH() {
        if (this.hvP != null) {
            this.hvP.c(this.gKp);
        }
    }

    private void agK() {
        this.hvP = c.Gk();
        aeF();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.CardDetailUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 69:
                if (iArr[0] == 0) {
                    w.i("MicroMsg.CardDetailUI", "onMPermissionGranted LocationPermissionGranted " + this.kiV);
                    if (!this.kiV) {
                        this.kiV = true;
                        agK();
                        return;
                    }
                    return;
                }
                com.tencent.mm.ui.base.g.a(this, getString(R.l.eFI), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ CardDetailUI kkw;

                    {
                        this.kkw = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.kkw.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }, null);
                return;
            default:
                return;
        }
    }

    private synchronized void si(String str) {
        if (this.khY) {
            w.e("MicroMsg.CardDetailUI", "has start CardConsumeSuccessUI!");
        } else {
            w.i("MicroMsg.CardDetailUI", "startConsumedSuccUI() ");
            this.khY = true;
            Intent intent = new Intent(this, CardConsumeSuccessUI.class);
            intent.putExtra("KEY_CARD_ID", this.kcX.afm());
            intent.putExtra("KEY_CARD_CONSUMED_JSON", str);
            intent.putExtra("KEY_CARD_COLOR", this.kcX.afi().hib);
            intent.putExtra("key_stastic_scene", this.jZM);
            intent.putExtra("key_from_scene", 0);
            startActivity(intent);
        }
    }

    public final void f(b bVar) {
        if (bVar == null) {
            w.e("MicroMsg.CardDetailUI", "cardInfo is empty, not to do onDataChange");
        } else if (this.kcX == null || !this.kcX.afm().equals(bVar.afm())) {
            w.e("MicroMsg.CardDetailUI", "is not the same card, not to do onDataChange");
        } else if (this.kki.ahx()) {
            w.i("MicroMsg.CardDetailUI", "onDataChange");
            this.kcX = bVar;
            this.kcJ = this.kcX.afm();
            if (this.kcX.afc() && al.agn().isEmpty()) {
                al.agn().sh(this.kcX.afm());
            }
            agB();
        } else {
            w.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onDataChange");
        }
    }

    public final void afF() {
        w.i("MicroMsg.CardDetailUI", "onVibrate");
        this.jYD.vibrate(300);
    }

    public final void afG() {
        w.i("MicroMsg.CardDetailUI", "onFinishUI");
    }

    public final void sj(final String str) {
        if (this.kki.ahx()) {
            w.i("MicroMsg.CardDetailUI", "onStartConsumedSuccUI");
            this.mHandler.post(new Runnable(this) {
                final /* synthetic */ CardDetailUI kkw;

                public final void run() {
                    this.kkw.si(str);
                }
            });
            return;
        }
        w.e("MicroMsg.CardDetailUI", "because the card is not accept, not to do onStartConsumedSuccUI");
    }

    public final void b(String str, i.b bVar) {
        if (TextUtils.isEmpty(str) || str.equals(this.kcJ)) {
            da(false);
            w.i("MicroMsg.CardDetailUI", "onMarkSuccess()");
            w.i("MicroMsg.CardDetailUI", "markSucc:" + bVar.kds + " markCardId: " + bVar.kdt);
            this.kkn = false;
            if (bVar.kds != 1) {
                this.kkm = false;
                com.tencent.mm.plugin.card.b.d.b(this, getString(R.l.dRj));
                return;
            } else if (TextUtils.isEmpty(bVar.kdt) || this.kcX.afm().equals(bVar.kdt)) {
                w.i("MicroMsg.CardDetailUI", "markCardId is same as now id!");
                this.kkm = true;
                a(bVar);
                return;
            } else {
                w.i("MicroMsg.CardDetailUI", "markCardId is diff as now id!");
                if (this.kcX.aeO()) {
                    b sH = al.agi().sH(bVar.kdt);
                    if (sH != null) {
                        this.kcX = sH;
                        this.kcJ = bVar.kdt;
                        agB();
                        al.agl().d(this.kcX);
                        w.i("MicroMsg.CardDetailUI", "update the mCardInfo");
                        this.kkm = true;
                        a(bVar);
                        return;
                    }
                    w.e("MicroMsg.CardDetailUI", "The mark card id not exist the card info in DB!， mark failed!");
                    com.tencent.mm.plugin.card.b.d.b(this, getString(R.l.dRi));
                    this.kkm = false;
                    return;
                }
                return;
            }
        }
        w.e("MicroMsg.CardDetailUI", "onMarkSuccess(), the mark card id is diff from current id!");
    }

    public final void bu(String str, String str2) {
        if (TextUtils.isEmpty(str) || str.equals(this.kcJ)) {
            w.i("MicroMsg.CardDetailUI", "onMarkFail()");
            this.kkm = false;
            this.kkn = false;
            da(false);
            if (TextUtils.isEmpty(str2)) {
                str2 = getString(R.l.dRi);
            }
            com.tencent.mm.plugin.card.b.d.b(this, str2);
            return;
        }
        w.e("MicroMsg.CardDetailUI", "onMarkFail(), the mark card id is diff from current id!");
    }

    public final void sm(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.kcJ)) {
            this.kkm = false;
        } else {
            w.e("MicroMsg.CardDetailUI", "onUnmarkSuccess(), the mark card id is diff from current id!");
        }
    }

    private void a(i.b bVar) {
        if (this.kki.fKF) {
            w.i("MicroMsg.CardDetailUI", "UI is pause, not to jumpMarkUI()");
            return;
        }
        w.i("MicroMsg.CardDetailUI", "jumpMarkUI()");
        this.kki.a(this.kko, bVar, true);
    }

    public final void afA() {
        w.i("MicroMsg.CardDetailUI", "code change");
        if (this.kki.kkE instanceof q) {
            ((q) this.kki.kkE).koQ = al.agn().getCode();
            this.kki.agB();
        }
    }

    public final void sg(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.tencent.mm.plugin.card.b.d.a(this, str, true);
        }
    }

    public final void onSuccess() {
        if (this.kki.kkE instanceof q) {
            ((q) this.kki.kkE).koQ = al.agn().getCode();
            this.kki.agB();
        }
        w.i("MicroMsg.CardDetailUI", "code get success");
    }
}
