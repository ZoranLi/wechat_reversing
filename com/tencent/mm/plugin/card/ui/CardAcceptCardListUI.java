package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.b.h;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ab;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.g;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa;
import com.tencent.mm.protocal.c.azt;
import com.tencent.mm.protocal.c.bab;
import com.tencent.mm.protocal.c.bde;
import com.tencent.mm.protocal.c.iu;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CardAcceptCardListUI extends MMActivity implements a, e {
    int fVn = 8;
    private String hir = "";
    private p iLz = null;
    protected ListView kcr = null;
    protected RelativeLayout kct = null;
    private boolean kdR = false;
    private String kfR = "";
    private int kfS;
    private String kfT;
    private int kfU;
    private String kfV;
    private Button kif;
    public int kim = 0;
    private String kin = "";
    private String kio = "";
    public ArrayList<String> kip = new ArrayList();
    public ArrayList<String> kiq = new ArrayList();
    HashMap<String, Integer> kjD = new HashMap();
    private View kjJ;
    private View kjK;
    private View kjL;
    protected a kjM = null;
    private View kjN;
    private View kjO;
    private TextView kjP;
    private Button kjQ;
    LinkedList<iu> kjR = new LinkedList();
    int kjS = 7;
    String kjT = "";
    String kjU = "";
    private String kjV = "";
    LinkedList<iu> kjW = new LinkedList();
    LinkedList<String> kjX = new LinkedList();

    static /* synthetic */ void a(CardAcceptCardListUI cardAcceptCardListUI, LinkedList linkedList) {
        cardAcceptCardListUI.da(true);
        LinkedList linkedList2 = new LinkedList();
        for (int i = 0; i < linkedList.size(); i++) {
            iu iuVar = (iu) linkedList.get(i);
            azt com_tencent_mm_protocal_c_azt = new azt();
            com_tencent_mm_protocal_c_azt.kdE = iuVar.kdE;
            com_tencent_mm_protocal_c_azt.fVm = iuVar.fVm;
            com_tencent_mm_protocal_c_azt.tcP = cardAcceptCardListUI.kjT;
            com_tencent_mm_protocal_c_azt.tcO = cardAcceptCardListUI.kjU;
            com_tencent_mm_protocal_c_azt.tcQ = cardAcceptCardListUI.kjS;
            linkedList2.add(com_tencent_mm_protocal_c_azt);
        }
        bab a = l.a(cardAcceptCardListUI.kim, cardAcceptCardListUI.kip, cardAcceptCardListUI.kiq);
        bde com_tencent_mm_protocal_c_bde = new bde();
        com_tencent_mm_protocal_c_bde.ueu = cardAcceptCardListUI.hir;
        ap.vd().a(new g(0, linkedList2, "", cardAcceptCardListUI.kjV, a, cardAcceptCardListUI.fVn, com_tencent_mm_protocal_c_bde), 0);
    }

    static /* synthetic */ LinkedList b(CardAcceptCardListUI cardAcceptCardListUI) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < cardAcceptCardListUI.kjR.size(); i++) {
            linkedList.add(cardAcceptCardListUI.kjR.get(i));
        }
        return linkedList;
    }

    static /* synthetic */ void c(CardAcceptCardListUI cardAcceptCardListUI) {
        w.i("MicroMsg.CardAcceptCardListUI", "doSelectShareUser");
        com.tencent.mm.plugin.report.service.g.oUh.i(11582, new Object[]{"OpenShareUserSelectView", Integer.valueOf(0), "", "", "", ""});
        Intent intent = new Intent();
        intent.putExtra("KLabel_range_index", cardAcceptCardListUI.kim);
        intent.putExtra("Klabel_name_list", cardAcceptCardListUI.kin);
        intent.putExtra("Kother_user_name_list", cardAcceptCardListUI.kio);
        intent.putExtra("k_sns_label_ui_title", cardAcceptCardListUI.getString(R.l.dRQ));
        intent.putExtra("k_sns_label_ui_style", 0);
        intent.putExtra("Ktag_rangeFilterprivate", true);
        d.b(cardAcceptCardListUI, "sns", ".ui.SnsLabelUI", intent, 2);
        cardAcceptCardListUI.uSV = cardAcceptCardListUI;
    }

    protected final int getLayoutId() {
        return R.i.bvQ;
    }

    protected final void KC() {
        zi(R.l.dQc);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardAcceptCardListUI kjY;

            {
                this.kjY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                w.v("MicroMsg.CardAcceptCardListUI", "setBackBtn cancel");
                this.kjY.ky(1);
                return true;
            }
        });
        this.kjJ = findViewById(R.h.bvQ);
        this.kjK = findViewById(R.h.cJs);
        this.kjL = findViewById(R.h.cbs);
        this.kjK.setVisibility(4);
        this.kcr = (ListView) findViewById(16908298);
        this.kct = (RelativeLayout) findViewById(R.h.bGB);
        this.kcr.setEmptyView(this.kct);
        this.kjM = new a(this);
        this.kcr.setAdapter(this.kjM);
        this.kcr.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CardAcceptCardListUI kjY;

            {
                this.kjY = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            }
        });
        this.kjN = findViewById(R.h.bvU);
        this.kif = (Button) findViewById(R.h.bvL);
        this.kif.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CardAcceptCardListUI kjY;

            {
                this.kjY = r1;
            }

            public final void onClick(View view) {
                if (this.kjY.kdR) {
                    CardAcceptCardListUI.a(this.kjY, CardAcceptCardListUI.b(this.kjY));
                    return;
                }
                CardAcceptCardListUI cardAcceptCardListUI = this.kjY;
                LinkedList b = CardAcceptCardListUI.b(this.kjY);
                cardAcceptCardListUI.da(true);
                ap.vd().a(new com.tencent.mm.plugin.card.model.p(b, cardAcceptCardListUI.fVn, cardAcceptCardListUI.kjT, cardAcceptCardListUI.kjU, cardAcceptCardListUI.kjS), 0);
            }
        });
        this.kif.setEnabled(false);
        this.kjO = findViewById(R.h.byc);
        this.kjP = (TextView) findViewById(R.h.byd);
        this.kjQ = (Button) findViewById(R.h.byb);
        this.kjQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CardAcceptCardListUI kjY;

            {
                this.kjY = r1;
            }

            public final void onClick(View view) {
                CardAcceptCardListUI.c(this.kjY);
            }
        });
        Intent intent = getIntent();
        if (intent == null) {
            w.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () intent == null");
            ky(2);
            return;
        }
        w.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI handle data");
        String stringExtra = intent.getStringExtra("key_in_card_list");
        this.fVn = intent.getIntExtra("key_from_scene", 8);
        String stringExtra2 = intent.getStringExtra("key_package_name");
        String stringExtra3 = intent.getStringExtra("key_sign");
        this.kjS = getIntent().getIntExtra("key_stastic_scene", 7);
        this.kjT = getIntent().getStringExtra("src_username");
        this.kjU = getIntent().getStringExtra("js_url");
        this.kjV = getIntent().getStringExtra("key_consumed_card_id");
        this.hir = getIntent().getStringExtra("key_template_id");
        Collection aC = h.aC(stringExtra, this.fVn);
        if (aC == null || aC.size() == 0) {
            w.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () tempList == null || tempList.size() == 0");
            ky(2);
            return;
        }
        this.kjR.clear();
        this.kjR.addAll(aC);
        this.kjW.clear();
        this.kjX.clear();
        this.kjD.clear();
        LinkedList linkedList = this.kjR;
        da(true);
        ap.vd().a(new ab(linkedList, this.fVn, stringExtra2, stringExtra3, this.kjT, this.kjU, this.kjV, this.kjS), 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.vd().a(690, this);
        ap.vd().a(687, this);
        ap.vd().a(902, this);
        KC();
    }

    protected void onDestroy() {
        ap.vd().b(690, this);
        ap.vd().b(687, this);
        ap.vd().b(902, this);
        this.kjR.clear();
        a aVar = this.kjM;
        aVar.kiF.clear();
        aVar.mContext = null;
        super.onDestroy();
    }

    void da(boolean z) {
        if (z) {
            this.iLz = p.b(this, getString(R.l.cbS), false, 0, null);
        } else if (this.iLz != null && this.iLz.isShowing()) {
            this.iLz.dismiss();
            this.iLz = null;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (i != 0 || i2 != 0) {
            w.e("MicroMsg.CardAcceptCardListUI", "CardAddEntranceUI onSceneEnd() netsene type" + kVar.getType() + "errType = " + i + " errCode = " + i2);
            da(false);
            com.tencent.mm.plugin.card.b.d.b(this, str, i2);
            if (kVar instanceof com.tencent.mm.plugin.card.model.p) {
                this.kfR = str;
            } else if (kVar instanceof g) {
                this.kfR = "";
            }
        } else if (kVar instanceof ab) {
            da(false);
            ab abVar = (ab) kVar;
            r0 = abVar.kfG;
            this.kfS = abVar.kfS;
            this.kfT = abVar.kfT;
            this.kfU = abVar.kfU;
            this.kfV = abVar.kfV;
            w.i("MicroMsg.CardAcceptCardListUI", "accept_button_status: " + this.kfS + "  accept_button_wording: " + this.kfT);
            w.i("MicroMsg.CardAcceptCardListUI", "private_status: " + this.kfU + "  private_wording: " + this.kfV);
            List sT = f.sT(r0);
            Collection Y = Y(sT);
            if (sT == null || sT.size() <= 0) {
                w.e("MicroMsg.CardAcceptCardListUI", "The card info list size is 0!");
            } else {
                w.i("MicroMsg.CardAcceptCardListUI", "The card info list size is " + sT.size());
                if (Y != null && Y.size() > 0) {
                    a aVar = this.kjM;
                    Map map = this.kjD;
                    if (Y != null) {
                        aVar.kiF.clear();
                        aVar.kiF.addAll(Y);
                        aVar.kjD.putAll(map);
                    }
                }
                this.kjM.notifyDataSetChanged();
                if (((CardInfo) sT.get(0)).aeO()) {
                    this.kdR = true;
                }
            }
            this.kjK.setVisibility(0);
            if (this.kjM.getCount() > 0) {
                Drawable bJ;
                b kx = this.kjM.kx(0);
                m.a((MMActivity) this, kx);
                this.kjJ.setBackgroundColor(l.ta(kx.afi().hib));
                this.kjN.setVisibility(0);
                Drawable stateListDrawable = new StateListDrawable();
                r2 = getResources().getDimensionPixelOffset(R.f.aYP);
                if (this.kfS == 1) {
                    this.kif.setEnabled(true);
                    bJ = l.bJ(l.ta(kx.afi().hib), r2);
                    int[] iArr = new int[]{16842919};
                    stateListDrawable.addState(iArr, l.bJ(l.aF(kx.afi().hib, aa.CTRL_BYTE), r2));
                    stateListDrawable.addState(new int[0], bJ);
                } else {
                    this.kif.setEnabled(false);
                    stateListDrawable.addState(new int[0], l.bJ(l.aF(kx.afi().hib, aa.CTRL_BYTE), r2));
                }
                this.kif.setBackgroundDrawable(stateListDrawable);
                if (!TextUtils.isEmpty(this.kfT)) {
                    this.kif.setText(this.kfT);
                }
                if (this.kfU == 1) {
                    int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.f.aXH);
                    Drawable d = l.d(this, getResources().getColor(R.e.white), dimensionPixelOffset);
                    stateListDrawable = l.bJ(getResources().getColor(R.e.white), dimensionPixelOffset);
                    bJ = new StateListDrawable();
                    bJ.addState(new int[]{16842919}, stateListDrawable);
                    bJ.addState(new int[0], d);
                    this.kjQ.setBackgroundDrawable(bJ);
                    int[] iArr2 = new int[]{l.ta(kx.afi().hib), getResources().getColor(R.e.white)};
                    this.kjQ.setTextColor(new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, iArr2));
                    this.kjO.setVisibility(0);
                    if (TextUtils.isEmpty(this.kfV)) {
                        this.kjP.setText(R.l.dRN);
                        return;
                    } else {
                        this.kjP.setText(this.kfV);
                        return;
                    }
                }
                this.kjO.setVisibility(8);
                LayoutParams layoutParams = (LayoutParams) this.kjK.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(R.f.aXR);
                layoutParams.bottomMargin = getResources().getDimensionPixelSize(R.f.aXv);
                this.kjK.setLayoutParams(layoutParams);
                this.kjK.invalidate();
                layoutParams = (LayoutParams) this.kjN.getLayoutParams();
                layoutParams.addRule(8, R.h.cbs);
                this.kjN.setLayoutParams(layoutParams);
                this.kjN.invalidate();
                return;
            }
            this.kjN.setVisibility(8);
            this.kjO.setVisibility(8);
            this.kjJ.setBackgroundColor(getResources().getColor(R.e.aVj));
        } else if (kVar instanceof com.tencent.mm.plugin.card.model.p) {
            da(false);
            com.tencent.mm.plugin.card.model.p pVar = (com.tencent.mm.plugin.card.model.p) kVar;
            if (pVar.kfH != 0) {
                r0 = pVar.kfI;
                if (TextUtils.isEmpty(r0)) {
                    r0 = getString(R.l.dQq);
                }
                com.tencent.mm.ui.base.g.a(this, r0, null, false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ CardAcceptCardListUI kjY;

                    {
                        this.kjY = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.kjY.ky(2);
                    }
                });
                this.kfR = pVar.kfG;
                return;
            }
            com.tencent.mm.ui.base.g.bl(this, getResources().getString(R.l.dQV));
            r0 = new Intent();
            r0.putExtra("card_list", pVar.kfG);
            setResult(-1, r0);
            w.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for card");
            l.aiI();
            finish();
        } else if (kVar instanceof g) {
            da(false);
            String str2 = ((g) kVar).kfG;
            r2 = ((g) kVar).kfH;
            r0 = ((g) kVar).kfI;
            this.kfR = str2;
            if (r2 != 0) {
                if (TextUtils.isEmpty(r0)) {
                    r0 = getString(R.l.dRW);
                }
                com.tencent.mm.ui.base.g.a(this, r0, null, false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ CardAcceptCardListUI kjY;

                    {
                        this.kjY = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        this.kjY.ky(2);
                    }
                });
                return;
            }
            com.tencent.mm.ui.base.g.bl(this, getResources().getString(R.l.dQh));
            r0 = new Intent();
            r0.putExtra("card_list", this.kfR);
            setResult(-1, r0);
            w.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for sharecard");
            l.aiK();
            ShareCardInfo shareCardInfo = new ShareCardInfo();
            f.a(shareCardInfo, str2);
            l.a(shareCardInfo);
            al.agh().adZ();
            finish();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            w.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI onKeyDown() back cancel");
            ky(1);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void ky(int i) {
        w.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI finishUI() result_code:" + i);
        Intent intent = new Intent();
        intent.putExtra("card_list", this.kfR);
        intent.putExtra("result_code", i);
        setResult(0, intent);
        finish();
    }

    public final void a(int i, int i2, Intent intent) {
        switch (i) {
            case 2:
                if (i2 == -1) {
                    this.kim = intent.getIntExtra("Ktag_range_index", 0);
                    w.i("MicroMsg.CardAcceptCardListUI", "mPrivateSelelct : %d", new Object[]{Integer.valueOf(this.kim)});
                    if (this.kim >= 2) {
                        this.kin = intent.getStringExtra("Klabel_name_list");
                        this.kio = intent.getStringExtra("Kother_user_name_list");
                        w.d("MicroMsg.CardAcceptCardListUI", "mPrivateSelect : %d, names : %s", new Object[]{Integer.valueOf(this.kim), this.kin});
                        if (TextUtils.isEmpty(this.kin) && TextUtils.isEmpty(this.kio)) {
                            w.e("MicroMsg.CardAcceptCardListUI", "mLabelNameList by getIntent is empty");
                            agR();
                            return;
                        }
                        List asList = Arrays.asList(this.kin.split(","));
                        this.kiq = l.ab(asList);
                        this.kip = l.aa(asList);
                        if (this.kio != null && this.kio.length() > 0) {
                            this.kip.addAll(Arrays.asList(this.kio.split(",")));
                        }
                        if (this.kiq != null) {
                            w.i("MicroMsg.CardAcceptCardListUI", "mPrivateIdsList size is " + this.kiq.size());
                        }
                        if (this.kip != null) {
                            w.i("MicroMsg.CardAcceptCardListUI", "mPrivateNamesList size is " + this.kip.size());
                            Iterator it = this.kip.iterator();
                            while (it.hasNext()) {
                                w.d("MicroMsg.CardAcceptCardListUI", "username : %s", new Object[]{(String) it.next()});
                            }
                        }
                        if (TextUtils.isEmpty(this.kin)) {
                            agR();
                            return;
                        } else if (this.kim == 2) {
                            this.kjP.setText(getString(R.l.dRP, new Object[]{agD()}));
                            return;
                        } else if (this.kim == 3) {
                            this.kjP.setText(getString(R.l.dRO, new Object[]{agD()}));
                            return;
                        } else {
                            return;
                        }
                    }
                    agR();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private String agD() {
        if (!TextUtils.isEmpty(this.kin) && !TextUtils.isEmpty(this.kio)) {
            return this.kin + "," + l.te(this.kio);
        }
        if (!TextUtils.isEmpty(this.kin)) {
            return this.kin;
        }
        if (TextUtils.isEmpty(this.kio)) {
            return "";
        }
        return l.te(this.kio);
    }

    private void agR() {
        if (TextUtils.isEmpty(this.kfV)) {
            this.kjP.setText(R.l.dRN);
        } else {
            this.kjP.setText(this.kfV);
        }
    }

    private ArrayList<CardInfo> Y(List<CardInfo> list) {
        if (list == null || list.size() == 0) {
            w.e("MicroMsg.CardAcceptCardListUI", "geCardInfoListByTpId list is empty!");
            return null;
        }
        this.kjW.clear();
        this.kjX.clear();
        this.kjD.clear();
        ArrayList<CardInfo> arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            CardInfo cardInfo = (CardInfo) list.get(i);
            if (this.kjX.contains(cardInfo.field_card_tp_id)) {
                this.kjD.put(cardInfo.field_card_tp_id, Integer.valueOf(((Integer) this.kjD.get(cardInfo.field_card_tp_id)).intValue() + 1));
            } else {
                arrayList.add(cardInfo);
                this.kjD.put(cardInfo.field_card_tp_id, Integer.valueOf(1));
                this.kjX.add(cardInfo.field_card_tp_id);
            }
        }
        return arrayList;
    }
}
