package com.tencent.mm.plugin.card.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.bt;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.b.m;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.al;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeCodeUI;
import com.tencent.mm.plugin.card.ui.a.h;
import com.tencent.mm.plugin.card.ui.view.j;
import com.tencent.mm.plugin.card.ui.view.k;
import com.tencent.mm.plugin.card.ui.view.q;
import com.tencent.mm.plugin.card.ui.view.u;
import com.tencent.mm.plugin.card.ui.view.y;
import com.tencent.mm.plugin.card.ui.view.z;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.au;
import com.tencent.mm.protocal.c.iw;
import com.tencent.mm.protocal.c.lz;
import com.tencent.mm.protocal.c.oa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.pb.common.c.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public final class e implements com.tencent.mm.plugin.card.a.g.a, m, com.tencent.mm.ui.MMActivity.a {
    ListView Fg;
    private final String TAG = "MicroMsg.CardDetailUIContoller";
    LinearLayout dU;
    boolean fKF = false;
    OnClickListener iuW = new OnClickListener(this) {
        final /* synthetic */ e klc;

        {
            this.klc = r1;
        }

        public final void onClick(View view) {
            boolean z = true;
            int i = false;
            if (view.getId() == R.h.bvU || view.getId() == R.h.bvL) {
                if (this.klc.kcX.aeN()) {
                    if (this.klc.kkY != null) {
                        this.klc.kkY.ahf();
                    }
                } else if (this.klc.kcX.aeO() && this.klc.kkY != null) {
                    this.klc.kkY.ahd();
                }
            } else if (view.getId() == R.h.bSd || view.getId() == R.h.bmC) {
                com.tencent.mm.plugin.card.b.b.P(this.klc.kdb, this.klc.kkZ.kkj);
            } else if (view.getId() == R.h.bCR || view.getId() == R.h.bCC) {
                if (view.getId() == R.h.bCR) {
                    this.klc.kkR = false;
                } else if (view.getId() == R.h.bCC) {
                    this.klc.kkR = true;
                }
                if (this.klc.kkE instanceof q) {
                    this.klc.kkQ.koQ = ((q) this.klc.kkE).e(com.tencent.mm.plugin.card.b.c.CARDCODEREFRESHACTION_DOREFRESH);
                }
                j jVar = this.klc.kkQ;
                boolean z2 = this.klc.kkR;
                jVar.ahK();
                jVar.kkR = z2;
                if (jVar.iuS != null && !jVar.iuS.isShowing()) {
                    jVar.iuS.showAtLocation(view.getRootView(), 17, 0, 0);
                    jVar.iuS.setFocusable(true);
                    jVar.iuS.setTouchable(true);
                    jVar.iuS.setBackgroundDrawable(new ColorDrawable(16777215));
                    jVar.iuS.setOutsideTouchable(true);
                    if (jVar.kkR) {
                        jVar.koM.setOnClickListener(jVar.iuW);
                        Bitmap bitmap = jVar.koI;
                        if (jVar.khz != null) {
                            jVar.koI = l.o(jVar.khz);
                        } else {
                            jVar.koI = null;
                        }
                        jVar.koM.setImageBitmap(jVar.koI);
                        jVar.koP.add(0, bitmap);
                        jVar.ahM();
                        jVar.iuU.setVisibility(8);
                        jVar.koL.setVisibility(0);
                        r0 = jVar.kcX.afj().code;
                        if (!i.isNullOrEmpty(jVar.kcX.afj().tnT)) {
                            r0 = jVar.kcX.afj().tnT;
                        } else if (!i.isNullOrEmpty(jVar.koQ)) {
                            r0 = jVar.koQ;
                        }
                        if (TextUtils.isEmpty(r0) || r0.length() > 40) {
                            jVar.koN.setVisibility(8);
                        } else {
                            jVar.koN.setText(m.ti(r0));
                            if (jVar.kcX.aeX()) {
                                jVar.koN.setVisibility(0);
                            } else {
                                jVar.koN.setVisibility(8);
                            }
                        }
                        if (TextUtils.isEmpty(jVar.kcX.afi().kAO)) {
                            jVar.koO.setVisibility(8);
                        } else {
                            jVar.koO.setText(jVar.kcX.afi().kAO);
                            jVar.koO.setVisibility(0);
                        }
                    } else {
                        jVar.iuT.setOnClickListener(jVar.iuW);
                        jVar.iuT.setImageBitmap(jVar.iuR);
                        r0 = jVar.kcX.afj().code;
                        if (!i.isNullOrEmpty(jVar.kcX.afj().tnT)) {
                            r0 = jVar.kcX.afj().tnT;
                        } else if (!i.isNullOrEmpty(jVar.koQ)) {
                            r0 = jVar.koQ;
                        }
                        if (TextUtils.isEmpty(r0) || r0.length() > 40) {
                            jVar.koJ.setVisibility(8);
                        } else {
                            jVar.koJ.setText(m.ti(r0));
                            if (jVar.kcX.aeX()) {
                                jVar.koJ.setVisibility(0);
                            } else {
                                jVar.koJ.setVisibility(8);
                            }
                        }
                        if (TextUtils.isEmpty(jVar.kcX.afi().kAO)) {
                            jVar.koK.setVisibility(8);
                        } else {
                            jVar.koK.setText(jVar.kcX.afi().kAO);
                            jVar.koK.setVisibility(0);
                        }
                        jVar.iuU.setVisibility(0);
                        jVar.koL.setVisibility(8);
                    }
                    jVar.iuS.update();
                }
            } else if (view.getId() == R.h.bwD || view.getId() == R.h.bwz || view.getId() == R.h.bwy || view.getId() == R.h.bCY || view.getId() == R.h.bwx) {
                if (view.getId() == R.h.bwD) {
                    if (this.klc.kcX.aeO()) {
                        int i2;
                        r1 = g.oUh;
                        r5 = new Object[9];
                        r5[0] = "CardConsumedCodeUI";
                        r5[1] = Integer.valueOf(this.klc.kcX.afi().kdF);
                        r5[2] = this.klc.kcX.afn();
                        r5[3] = this.klc.kcX.afm();
                        r5[4] = Integer.valueOf(0);
                        r5[5] = Integer.valueOf(this.klc.kkZ.khL);
                        r5[6] = this.klc.kkZ.kkj;
                        if (this.klc.kcX.afg()) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        r5[7] = Integer.valueOf(i2);
                        r5[8] = "";
                        r1.i(11324, r5);
                        if (this.klc.kkY != null) {
                            this.klc.kkY.de(true);
                            return;
                        }
                        return;
                    }
                    this.klc.a(true, new com.tencent.mm.plugin.card.a.i.b(), false);
                } else if (view.getId() != R.h.bCY || !this.klc.kcX.afi().toS) {
                    if (!this.klc.kcX.aeO()) {
                        this.klc.a(false, new com.tencent.mm.plugin.card.a.i.b(), false);
                    } else if (this.klc.kkY != null) {
                        this.klc.kkY.de(false);
                    }
                }
            } else if (view.getId() == R.h.bnU) {
                if (!TextUtils.isEmpty(this.klc.kcX.afi().tow)) {
                    com.tencent.mm.plugin.card.b.b.a(this.klc.kdb, this.klc.kcX.afi().tow, 3);
                    g.oUh.i(11941, new Object[]{Integer.valueOf(13), this.klc.kcX.afm(), this.klc.kcX.afn(), "", this.klc.kcX.afi().tov});
                }
            } else if (view.getId() == R.h.byb) {
                g.oUh.i(11582, new Object[]{"OpenShareUserSelectView", Integer.valueOf(0), Integer.valueOf(this.klc.kcX.afi().kdF), this.klc.kcX.afn(), this.klc.kcX.afm(), this.klc.kkZ.kkj});
                Intent intent = new Intent();
                intent.putExtra("KLabel_range_index", this.klc.kim);
                intent.putExtra("Klabel_name_list", this.klc.kin);
                intent.putExtra("Kother_user_name_list", this.klc.kio);
                intent.putExtra("k_sns_label_ui_title", this.klc.kdb.getString(R.l.dRQ));
                intent.putExtra("k_sns_label_ui_style", 0);
                intent.putExtra("Ktag_rangeFilterprivate", true);
                com.tencent.mm.bb.d.b(this.klc.kdb, "sns", ".ui.SnsLabelUI", intent, 2);
                this.klc.kdb.uSV = this.klc;
            } else if (view.getId() == R.h.bym) {
                if (this.klc.kcX.afj().tnH != null) {
                    LinkedList linkedList = this.klc.kcX.afj().tnH;
                    int intValue = ((Integer) view.getTag()).intValue();
                    r0 = (lz) linkedList.get(intValue);
                    if (com.tencent.mm.plugin.card.b.b.a(this.klc.kcX.afm(), r0, this.klc.kkZ.khL, this.klc.kkZ.klf)) {
                        g.oUh.i(11941, new Object[]{Integer.valueOf(19), this.klc.kcX.afm(), this.klc.kcX.afn(), "", r0.title});
                    } else if (r0 != null && !TextUtils.isEmpty(r0.url)) {
                        com.tencent.mm.plugin.card.b.b.a(this.klc.kdb, r0.url, 1);
                        g gVar = g.oUh;
                        Object[] objArr = new Object[5];
                        switch (intValue) {
                            case 0:
                                r1 = 10;
                                break;
                            case 1:
                                r1 = 11;
                                break;
                            case 2:
                                r1 = 12;
                                break;
                            case 3:
                                r1 = 16;
                                break;
                            default:
                                r1 = 10;
                                break;
                        }
                        objArr[0] = Integer.valueOf(r1);
                        objArr[1] = this.klc.kcX.afm();
                        objArr[2] = this.klc.kcX.afn();
                        objArr[3] = "";
                        objArr[4] = r0.title;
                        gVar.i(11941, objArr);
                        if (l.a(r0, this.klc.kcX.afm())) {
                            r1 = this.klc.kcX.afm();
                            r0 = r0.title;
                            l.tg(r1);
                            com.tencent.mm.plugin.card.b.b.a(this.klc.kdb, this.klc.kcX.afi().keT);
                        }
                    }
                }
            } else if (view.getId() == R.h.byn) {
                if (this.klc.kcX.afj().tnH != null) {
                    r0 = (lz) this.klc.kcX.afj().tnH.get(0);
                    if (com.tencent.mm.plugin.card.b.b.a(this.klc.kcX.afm(), r0, this.klc.kkZ.khL, this.klc.kkZ.klf)) {
                        g.oUh.i(11941, new Object[]{Integer.valueOf(19), this.klc.kcX.afm(), this.klc.kcX.afn(), "", r0.title});
                    } else if (r0 != null && !TextUtils.isEmpty(r0.url)) {
                        com.tencent.mm.plugin.card.b.b.a(this.klc.kdb, r0.url, 1);
                        g.oUh.i(11941, new Object[]{Integer.valueOf(10), this.klc.kcX.afm(), this.klc.kcX.afn(), "", r0.title});
                        if (l.a(r0, this.klc.kcX.afm())) {
                            r1 = this.klc.kcX.afm();
                            r0 = r0.title;
                            l.tg(r1);
                            com.tencent.mm.plugin.card.b.b.a(this.klc.kdb, this.klc.kcX.afi().keT);
                        }
                    }
                }
            } else if (view.getId() == R.h.byM || view.getId() == R.h.bxU) {
                if (this.klc.kcX.afj().tnO == null) {
                    return;
                }
                if (this.klc.kcX.afa()) {
                    if (!this.klc.kcX.aeO()) {
                        this.klc.a(false, new com.tencent.mm.plugin.card.a.i.b(), false);
                    } else if (this.klc.kkY != null) {
                        this.klc.kkY.de(false);
                    }
                } else if (this.klc.kcX.afb()) {
                    com.tencent.mm.plugin.card.a.i.b bVar = new com.tencent.mm.plugin.card.a.i.b();
                    com.tencent.mm.plugin.card.b.b.a(this.klc.kdb, bVar.kdu, bVar.kdv, false, this.klc.kcX);
                } else {
                    r0 = this.klc.kcX.afj().tnO;
                    if (com.tencent.mm.plugin.card.b.b.a(this.klc.kcX.afm(), r0, this.klc.kkZ.khL, this.klc.kkZ.klf)) {
                        g.oUh.i(11941, new Object[]{Integer.valueOf(20), this.klc.kcX.afm(), this.klc.kcX.afn(), "", r0.title});
                    } else if (r0 != null && !TextUtils.isEmpty(r0.url)) {
                        com.tencent.mm.plugin.card.b.b.a(this.klc.kdb, l.o(r0.url, r0.tpl), 1);
                        g.oUh.i(11941, new Object[]{Integer.valueOf(9), this.klc.kcX.afm(), this.klc.kcX.afn(), "", r0.title});
                        if (l.a(r0, this.klc.kcX.afm())) {
                            r1 = this.klc.kcX.afm();
                            r0 = r0.title;
                            l.tg(r1);
                            com.tencent.mm.plugin.card.b.b.a(this.klc.kdb, this.klc.kcX.afi().keT);
                        }
                    }
                }
            } else if (view.getId() == R.h.bwO || view.getId() == R.h.bvW) {
                oa oaVar = this.klc.kcX.afi().toC;
                r1 = g.oUh;
                r5 = new Object[9];
                r5[0] = "CardLeftRightIntroduceView";
                r5[1] = Integer.valueOf(this.klc.kcX.afi().kdF);
                r5[2] = this.klc.kcX.afn();
                r5[3] = this.klc.kcX.afm();
                r5[4] = Integer.valueOf(0);
                r5[5] = Integer.valueOf(this.klc.kkZ.khL);
                r5[6] = this.klc.kkZ.kkj;
                if (this.klc.kcX.afg()) {
                    i = 1;
                }
                r5[7] = Integer.valueOf(i);
                r5[8] = "";
                r1.i(11324, r5);
                if (oaVar == null || TextUtils.isEmpty(oaVar.url)) {
                    Intent intent2 = new Intent();
                    if (this.klc.kcX instanceof CardInfo) {
                        intent2.putExtra("key_card_info_data", (CardInfo) this.klc.kcX);
                    } else if (this.klc.kcX instanceof ShareCardInfo) {
                        intent2.putExtra("key_card_info_data", (ShareCardInfo) this.klc.kcX);
                    }
                    intent2.setClass(this.klc.kdb, CardDetailPreference.class);
                    this.klc.kdb.startActivity(intent2);
                    return;
                }
                com.tencent.mm.plugin.card.b.b.a(this.klc.kdb, oaVar.url, 1);
            } else if (view.getId() == R.h.cEU) {
                if (com.tencent.mm.plugin.card.sharecard.a.b.sz(this.klc.kcX.afn()) > 1) {
                    e eVar = this.klc;
                    if (this.klc.kkA) {
                        z = false;
                    }
                    eVar.kkA = z;
                    this.klc.agB();
                }
            } else if (view.getId() == R.h.bwa) {
                if (this.klc.kcX.afi().toy != null && !TextUtils.isEmpty(this.klc.kcX.afi().toy.url)) {
                    com.tencent.mm.plugin.card.b.b.a(this.klc.kdb, this.klc.kcX.afi().toy.url, 3);
                    g.oUh.i(11941, new Object[]{Integer.valueOf(3), this.klc.kcX.afm(), this.klc.kcX.afn(), "", this.klc.kcX.afi().toy.text});
                }
            } else if (view.getId() == R.h.bvS) {
                if (this.klc.kcX.afi().toF != null && !bg.mA(this.klc.kcX.afi().toF.url)) {
                    com.tencent.mm.plugin.card.b.b.a(this.klc.kdb, this.klc.kcX.afi().toF.url, 1);
                    g.oUh.i(11941, new Object[]{Integer.valueOf(14), this.klc.kcX.afm(), this.klc.kcX.afn(), "", this.klc.kcX.afi().toF.text});
                }
            } else if (view.getId() == R.h.cEZ || view.getId() == R.h.cFa) {
                if (this.klc.kcX.afi().ton <= 0) {
                    return;
                }
                if (this.klc.kde == null || this.klc.kde.size() == 0) {
                    w.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                    return;
                }
                r0 = (iw) this.klc.kde.get(0);
                com.tencent.mm.plugin.card.b.b.a(this.klc.kdb, r0.fOb, r0.fPF, r0.hCE);
                g gVar2 = g.oUh;
                Object[] objArr2 = new Object[9];
                objArr2[0] = "UsedStoresView";
                objArr2[1] = Integer.valueOf(this.klc.kcX.afi().kdF);
                objArr2[2] = this.klc.kcX.afn();
                objArr2[3] = this.klc.kcX.afm();
                objArr2[4] = Integer.valueOf(0);
                objArr2[5] = Integer.valueOf(this.klc.kkZ.khL);
                objArr2[6] = this.klc.kkZ.kkj;
                if (this.klc.kcX.afg()) {
                    r1 = 1;
                } else {
                    r1 = 0;
                }
                objArr2[7] = Integer.valueOf(r1);
                objArr2[8] = "";
                gVar2.i(11324, objArr2);
                g.oUh.i(11941, new Object[]{Integer.valueOf(5), this.klc.kcX.afm(), this.klc.kcX.afn(), "", r0.name});
            } else if (view.getId() == R.h.cIj) {
                if (this.klc.kde == null || this.klc.kde.size() == 0) {
                    w.e("MicroMsg.CardDetailUIContoller", "mShopList == null || mShopList.size() == 0");
                    return;
                }
                r0 = (iw) this.klc.kde.get(0);
                r1 = (String) view.getTag();
                if (!TextUtils.isEmpty(r1) && r1.equals(this.klc.kdb.getString(R.l.dQs))) {
                    this.klc.ahv();
                } else if (!TextUtils.isEmpty(r0.kfu)) {
                    com.tencent.mm.plugin.card.b.b.a(this.klc.kdb, r0.kfu, 1);
                    g.oUh.i(11941, new Object[]{Integer.valueOf(4), this.klc.kcX.afm(), this.klc.kcX.afn(), "", r0.name});
                }
            } else if (view.getId() == R.h.cIe) {
                this.klc.ahv();
            }
        }
    };
    public com.tencent.mm.plugin.card.base.b kcX;
    public MMActivity kdb;
    public List<com.tencent.mm.plugin.card.model.b> kdc = new ArrayList();
    public ArrayList<iw> kde;
    private View khv;
    public int kim = 0;
    public String kin = "";
    public String kio = "";
    public ArrayList<String> kip = new ArrayList();
    public ArrayList<String> kiq = new ArrayList();
    public boolean kkA = false;
    com.tencent.mm.plugin.card.ui.view.i kkB;
    com.tencent.mm.plugin.card.ui.view.i kkC;
    com.tencent.mm.plugin.card.widget.g kkD;
    public com.tencent.mm.plugin.card.ui.view.g kkE;
    l kkF;
    com.tencent.mm.plugin.card.ui.view.i kkG;
    com.tencent.mm.plugin.card.ui.view.i kkH;
    com.tencent.mm.plugin.card.ui.view.i kkI;
    com.tencent.mm.plugin.card.ui.view.i kkJ;
    com.tencent.mm.plugin.card.ui.view.i kkK;
    com.tencent.mm.plugin.card.ui.view.i kkL;
    com.tencent.mm.plugin.card.ui.view.i kkM;
    com.tencent.mm.plugin.card.ui.view.i kkN;
    com.tencent.mm.plugin.card.ui.view.d kkO;
    com.tencent.mm.plugin.card.ui.view.i kkP;
    public j kkQ;
    public boolean kkR = true;
    f kkS;
    public String kkT = "";
    public String kkU = "";
    public HashMap<Integer, String> kkV = new HashMap();
    public HashMap<String, String> kkW = new HashMap();
    public ArrayList<String> kkX = new ArrayList();
    public d kkY;
    public a kkZ;
    com.tencent.mm.plugin.card.ui.a.g kky;
    com.tencent.mm.plugin.card.ui.view.i kkz;
    private ae kla = new ae(this) {
        final /* synthetic */ e klc;

        {
            this.klc = r1;
        }

        public final void handleMessage(Message message) {
            if (message.obj != null && (message.obj instanceof c)) {
                c cVar = (c) message.obj;
                if (cVar.kll == b.klj) {
                    if (this.klc.kkE != null) {
                        com.tencent.mm.plugin.card.b.d.a(this.klc.kdb, cVar.fPf, false);
                        this.klc.kkE.aiC();
                    }
                } else if (cVar.kll == b.klh) {
                    if (this.klc.kkE != null) {
                        this.klc.kkE.d(com.tencent.mm.plugin.card.b.c.CARDCODEREFRESHACTION_SHOWING_TIMEOUT);
                    }
                } else if (this.klc.kkE != null) {
                    this.klc.kkE.d(cVar.klm);
                }
            }
        }
    };
    com.tencent.mm.sdk.b.c klb = new com.tencent.mm.sdk.b.c<bt>(this) {
        final /* synthetic */ e klc;

        {
            this.klc = r2;
            this.usg = bt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            bt btVar = (bt) bVar;
            if (ap.zb()) {
                w.i("MicroMsg.CardDetailUIContoller", "deal with card notify event ConsumedCardByOfflinePayEvent");
                if (btVar instanceof bt) {
                    if (btVar.fFk.aMA == 0) {
                        com.tencent.mm.plugin.card.b.d.b(this.klc.kdb, this.klc.kdb.getResources().getString(R.l.flk));
                    }
                    return true;
                }
            }
            return false;
        }
    };

    public static class a {
        public int jZM = 3;
        public String kcJ = "";
        public boolean kdR = false;
        public int khL = -1;
        public String kjT = "";
        public String kjU = "";
        public String kkj = "";
        public String kkk = "";
        public String kkl = "";
        public int klf = 0;
    }

    public enum b {
        ;

        static {
            klg = 1;
            klh = 2;
            kli = 3;
            klj = 4;
            klk = new int[]{klg, klh, kli, klj};
        }
    }

    private static class c {
        int errCode;
        String fPf;
        int kll;
        com.tencent.mm.plugin.card.b.c klm;
    }

    public interface d {
        void ahc();

        void ahd();

        void ahe();

        void ahf();

        void ahg();

        void ahh();

        void ahi();

        void d(com.tencent.mm.plugin.card.base.b bVar);

        void de(boolean z);

        void sM(String str);
    }

    public e(MMActivity mMActivity, View view) {
        this.kdb = mMActivity;
        this.khv = view;
    }

    public final void a(com.tencent.mm.plugin.card.base.b bVar, a aVar, ArrayList<iw> arrayList) {
        this.kcX = bVar;
        this.kkZ = aVar;
        this.kde = arrayList;
    }

    public final View findViewById(int i) {
        return this.khv.findViewById(i);
    }

    public final com.tencent.mm.plugin.card.base.b ahj() {
        return this.kcX;
    }

    public final void d(com.tencent.mm.plugin.card.base.b bVar) {
        if (bVar != null) {
            this.kcX = bVar;
            if (this.kkY != null) {
                this.kkY.d(bVar);
            }
            agB();
        }
    }

    public final boolean ahk() {
        return this.kkA;
    }

    public final void ahl() {
        this.kkA = false;
    }

    public final MMActivity ahm() {
        return this.kdb;
    }

    public final OnClickListener ahn() {
        return this.iuW;
    }

    public final com.tencent.mm.plugin.card.ui.a.g aho() {
        return this.kky;
    }

    public final d ahp() {
        return this.kkY;
    }

    public final a ahq() {
        return this.kkZ;
    }

    public final f ahr() {
        return this.kkS;
    }

    public final j ahs() {
        return this.kkQ;
    }

    public final String getString(int i) {
        return this.kdb.getString(i);
    }

    public final void agB() {
        if (this.kcX == null) {
            w.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo == null");
            if (this.kkY != null) {
                this.kkY.ahg();
            }
        } else if (this.kcX.afi() == null) {
            w.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getCardTpInfo() == null");
            if (this.kkY != null) {
                this.kkY.ahg();
            }
        } else if (this.kcX.afj() == null) {
            w.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, mCardInfo.getDataInfo() == null");
            if (this.kkY != null) {
                this.kkY.ahg();
            }
        } else if (this.kcX.aeU()) {
            int i;
            w.i("MicroMsg.CardDetailUIContoller", "doUpdate()");
            w.i("MicroMsg.CardDetailUIContoller", "doUpdate() showAcceptView:" + this.kcX.afi().toL);
            f fVar = this.kkS;
            com.tencent.mm.plugin.card.base.b bVar = this.kcX;
            ArrayList arrayList = this.kde;
            int i2 = this.kkZ.jZM;
            fVar.kcX = bVar;
            fVar.kde = arrayList;
            fVar.jZM = i2;
            boolean z = this.kky == null ? false : this.kcX.aeO() ? !(this.kky instanceof h) : this.kcX.aeP() ? !(this.kky instanceof com.tencent.mm.plugin.card.ui.a.e) : this.kcX.aeS() ? !(this.kky instanceof com.tencent.mm.plugin.card.ui.a.b) : this.kcX.aeQ() ? !(this.kky instanceof com.tencent.mm.plugin.card.ui.a.c) : this.kcX.aeR() ? !(this.kky instanceof com.tencent.mm.plugin.card.ui.a.f) : this.kcX.aeT() ? !(this.kky instanceof com.tencent.mm.plugin.card.ui.a.d) : !(this.kky instanceof com.tencent.mm.plugin.card.ui.a.a);
            if (z) {
                this.kky.release();
                this.kky = null;
                w.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, need recreate show logic, card_type:%d", new Object[]{Integer.valueOf(this.kcX.afi().kdF)});
            }
            if (this.kky == null) {
                w.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, mCardShowLogic == null, card_type:%d", new Object[]{Integer.valueOf(this.kcX.afi().kdF)});
                w.i("MicroMsg.CardDetailUIContoller", "createShowLogic, card_type:%d", new Object[]{Integer.valueOf(this.kcX.afi().kdF)});
                if (!this.kcX.aeO()) {
                    switch (this.kcX.afi().kdF) {
                        case 0:
                            this.kky = new com.tencent.mm.plugin.card.ui.a.c(this.kdb);
                            break;
                        case 10:
                            this.kky = new com.tencent.mm.plugin.card.ui.a.e(this.kdb);
                            break;
                        case 11:
                            this.kky = new com.tencent.mm.plugin.card.ui.a.b(this.kdb);
                            break;
                        case 20:
                            this.kky = new com.tencent.mm.plugin.card.ui.a.f(this.kdb);
                            break;
                        case 30:
                            this.kky = new com.tencent.mm.plugin.card.ui.a.d(this.kdb);
                            break;
                        default:
                            this.kky = new com.tencent.mm.plugin.card.ui.a.a(this.kdb);
                            break;
                    }
                }
                this.kky = new h(this.kdb);
            }
            w.i("MicroMsg.CardDetailUIContoller", "updateShowLogic, card_tye:%d", new Object[]{Integer.valueOf(this.kcX.afi().kdF)});
            this.kky.a(this.kcX, this.kkZ);
            this.kky.aiy();
            w.i("MicroMsg.CardDetailUIContoller", "");
            if (this.kky.aig()) {
                this.kdb.qP(this.kkS.getTitle());
            } else {
                this.kdb.qP("");
            }
            if (this.kcX == null) {
                w.e("MicroMsg.CardDetailUIContoller", "updateWidget, mCardInfo is null");
            } else {
                View aiP;
                LinearLayout linearLayout;
                if (this.kkD != null) {
                    if (this.kcX.aeP()) {
                        if (!(this.kkD instanceof com.tencent.mm.plugin.card.widget.e)) {
                            z = true;
                            if (z) {
                                aiP = this.kkD.aiP();
                                if (aiP != null) {
                                    this.dU.removeView(aiP);
                                }
                                this.dU.removeAllViews();
                                this.dU.invalidate();
                                this.kkD.release();
                                this.kkD = null;
                            }
                            if (this.kkD == null) {
                                if (this.kcX.aeP()) {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.e(this.kdb);
                                } else if (this.kcX.aeS()) {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.c(this.kdb);
                                } else if (this.kcX.aeQ()) {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.b(this.kdb);
                                } else if (this.kcX.aeR()) {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.f(this.kdb);
                                } else if (this.kcX.aeT()) {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.b(this.kdb);
                                } else {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.d(this.kdb);
                                }
                                this.kkD.k(this.kcX);
                                aiP = this.kkD.aiP();
                                if (aiP != null) {
                                    linearLayout = this.dU;
                                    aiP.setLayoutParams(new LayoutParams(-1, -2));
                                    linearLayout.addView(aiP);
                                }
                                this.dU.invalidate();
                                this.kkD.setOnClickListener(this.iuW);
                                i(false, false);
                            }
                            if (this.kkD != null) {
                                if (this.kcX.aeR()) {
                                    ((com.tencent.mm.plugin.card.widget.f) this.kkD).kde = this.kde;
                                }
                                this.kkD.f(this.kcX);
                            }
                        }
                    } else if (this.kcX.aeS()) {
                        if (!(this.kkD instanceof com.tencent.mm.plugin.card.widget.c)) {
                            z = true;
                            if (z) {
                                aiP = this.kkD.aiP();
                                if (aiP != null) {
                                    this.dU.removeView(aiP);
                                }
                                this.dU.removeAllViews();
                                this.dU.invalidate();
                                this.kkD.release();
                                this.kkD = null;
                            }
                            if (this.kkD == null) {
                                if (this.kcX.aeP()) {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.e(this.kdb);
                                } else if (this.kcX.aeS()) {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.c(this.kdb);
                                } else if (this.kcX.aeQ()) {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.b(this.kdb);
                                } else if (this.kcX.aeR()) {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.f(this.kdb);
                                } else if (this.kcX.aeT()) {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.b(this.kdb);
                                } else {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.d(this.kdb);
                                }
                                this.kkD.k(this.kcX);
                                aiP = this.kkD.aiP();
                                if (aiP != null) {
                                    linearLayout = this.dU;
                                    aiP.setLayoutParams(new LayoutParams(-1, -2));
                                    linearLayout.addView(aiP);
                                }
                                this.dU.invalidate();
                                this.kkD.setOnClickListener(this.iuW);
                                i(false, false);
                            }
                            if (this.kkD != null) {
                                if (this.kcX.aeR()) {
                                    ((com.tencent.mm.plugin.card.widget.f) this.kkD).kde = this.kde;
                                }
                                this.kkD.f(this.kcX);
                            }
                        }
                    } else if (this.kcX.aeQ()) {
                        if (!(this.kkD instanceof com.tencent.mm.plugin.card.widget.b)) {
                            z = true;
                            if (z) {
                                aiP = this.kkD.aiP();
                                if (aiP != null) {
                                    this.dU.removeView(aiP);
                                }
                                this.dU.removeAllViews();
                                this.dU.invalidate();
                                this.kkD.release();
                                this.kkD = null;
                            }
                            if (this.kkD == null) {
                                if (this.kcX.aeP()) {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.e(this.kdb);
                                } else if (this.kcX.aeS()) {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.c(this.kdb);
                                } else if (this.kcX.aeQ()) {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.b(this.kdb);
                                } else if (this.kcX.aeR()) {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.f(this.kdb);
                                } else if (this.kcX.aeT()) {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.d(this.kdb);
                                } else {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.b(this.kdb);
                                }
                                this.kkD.k(this.kcX);
                                aiP = this.kkD.aiP();
                                if (aiP != null) {
                                    linearLayout = this.dU;
                                    aiP.setLayoutParams(new LayoutParams(-1, -2));
                                    linearLayout.addView(aiP);
                                }
                                this.dU.invalidate();
                                this.kkD.setOnClickListener(this.iuW);
                                i(false, false);
                            }
                            if (this.kkD != null) {
                                if (this.kcX.aeR()) {
                                    ((com.tencent.mm.plugin.card.widget.f) this.kkD).kde = this.kde;
                                }
                                this.kkD.f(this.kcX);
                            }
                        }
                    } else if (this.kcX.aeR()) {
                        if (!(this.kkD instanceof com.tencent.mm.plugin.card.widget.f)) {
                            z = true;
                            if (z) {
                                aiP = this.kkD.aiP();
                                if (aiP != null) {
                                    this.dU.removeView(aiP);
                                }
                                this.dU.removeAllViews();
                                this.dU.invalidate();
                                this.kkD.release();
                                this.kkD = null;
                            }
                            if (this.kkD == null) {
                                if (this.kcX.aeP()) {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.e(this.kdb);
                                } else if (this.kcX.aeS()) {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.c(this.kdb);
                                } else if (this.kcX.aeQ()) {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.b(this.kdb);
                                } else if (this.kcX.aeR()) {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.f(this.kdb);
                                } else if (this.kcX.aeT()) {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.b(this.kdb);
                                } else {
                                    this.kkD = new com.tencent.mm.plugin.card.widget.d(this.kdb);
                                }
                                this.kkD.k(this.kcX);
                                aiP = this.kkD.aiP();
                                if (aiP != null) {
                                    linearLayout = this.dU;
                                    aiP.setLayoutParams(new LayoutParams(-1, -2));
                                    linearLayout.addView(aiP);
                                }
                                this.dU.invalidate();
                                this.kkD.setOnClickListener(this.iuW);
                                i(false, false);
                            }
                            if (this.kkD != null) {
                                if (this.kcX.aeR()) {
                                    ((com.tencent.mm.plugin.card.widget.f) this.kkD).kde = this.kde;
                                }
                                this.kkD.f(this.kcX);
                            }
                        }
                    } else if (this.kcX.aeT() && !(this.kkD instanceof com.tencent.mm.plugin.card.widget.d)) {
                        z = true;
                        if (z) {
                            aiP = this.kkD.aiP();
                            if (aiP != null) {
                                this.dU.removeView(aiP);
                            }
                            this.dU.removeAllViews();
                            this.dU.invalidate();
                            this.kkD.release();
                            this.kkD = null;
                        }
                        if (this.kkD == null) {
                            if (this.kcX.aeP()) {
                                this.kkD = new com.tencent.mm.plugin.card.widget.e(this.kdb);
                            } else if (this.kcX.aeS()) {
                                this.kkD = new com.tencent.mm.plugin.card.widget.c(this.kdb);
                            } else if (this.kcX.aeQ()) {
                                this.kkD = new com.tencent.mm.plugin.card.widget.b(this.kdb);
                            } else if (this.kcX.aeR()) {
                                this.kkD = new com.tencent.mm.plugin.card.widget.f(this.kdb);
                            } else if (this.kcX.aeT()) {
                                this.kkD = new com.tencent.mm.plugin.card.widget.d(this.kdb);
                            } else {
                                this.kkD = new com.tencent.mm.plugin.card.widget.b(this.kdb);
                            }
                            this.kkD.k(this.kcX);
                            aiP = this.kkD.aiP();
                            if (aiP != null) {
                                linearLayout = this.dU;
                                aiP.setLayoutParams(new LayoutParams(-1, -2));
                                linearLayout.addView(aiP);
                            }
                            this.dU.invalidate();
                            this.kkD.setOnClickListener(this.iuW);
                            i(false, false);
                        }
                        if (this.kkD != null) {
                            if (this.kcX.aeR()) {
                                ((com.tencent.mm.plugin.card.widget.f) this.kkD).kde = this.kde;
                            }
                            this.kkD.f(this.kcX);
                        }
                    }
                }
                z = false;
                if (z) {
                    aiP = this.kkD.aiP();
                    if (aiP != null) {
                        this.dU.removeView(aiP);
                    }
                    this.dU.removeAllViews();
                    this.dU.invalidate();
                    this.kkD.release();
                    this.kkD = null;
                }
                if (this.kkD == null) {
                    if (this.kcX.aeP()) {
                        this.kkD = new com.tencent.mm.plugin.card.widget.e(this.kdb);
                    } else if (this.kcX.aeS()) {
                        this.kkD = new com.tencent.mm.plugin.card.widget.c(this.kdb);
                    } else if (this.kcX.aeQ()) {
                        this.kkD = new com.tencent.mm.plugin.card.widget.b(this.kdb);
                    } else if (this.kcX.aeR()) {
                        this.kkD = new com.tencent.mm.plugin.card.widget.f(this.kdb);
                    } else if (this.kcX.aeT()) {
                        this.kkD = new com.tencent.mm.plugin.card.widget.b(this.kdb);
                    } else {
                        this.kkD = new com.tencent.mm.plugin.card.widget.d(this.kdb);
                    }
                    this.kkD.k(this.kcX);
                    aiP = this.kkD.aiP();
                    if (aiP != null) {
                        linearLayout = this.dU;
                        aiP.setLayoutParams(new LayoutParams(-1, -2));
                        linearLayout.addView(aiP);
                    }
                    this.dU.invalidate();
                    this.kkD.setOnClickListener(this.iuW);
                    i(false, false);
                }
                if (this.kkD != null) {
                    if (this.kcX.aeR()) {
                        ((com.tencent.mm.plugin.card.widget.f) this.kkD).kde = this.kde;
                    }
                    this.kkD.f(this.kcX);
                }
            }
            if (this.kky.aih()) {
                w.i("MicroMsg.CardDetailUIContoller", "updateShareUsersInfoLayout()");
                this.kkz.update();
            } else {
                w.i("MicroMsg.CardDetailUIContoller", "don't updateShareUsersInfoLayout()");
                this.kkz.aiz();
            }
            if (this.kky.ahY()) {
                if (this.kkP == null) {
                    this.kkP = new com.tencent.mm.plugin.card.ui.view.b();
                    this.kkP.a(this);
                }
                w.i("MicroMsg.CardDetailUIContoller", "update CardAcceptView()");
                this.kkP.update();
            } else {
                w.i("MicroMsg.CardDetailUIContoller", "don't update CardAcceptView()");
                if (this.kkP != null) {
                    this.kkP.aiz();
                }
            }
            this.kdb.kr(this.kky.aic());
            if (this.kky.aid()) {
                this.kkV.clear();
                this.kkX.clear();
                if (this.kcX.aeW()) {
                    this.kkX.add(getString(R.l.fnw));
                    this.kkV.put(Integer.valueOf(0), "menu_func_share_friend");
                    this.kkX.add(getString(R.l.fnv));
                    this.kkV.put(Integer.valueOf(1), "menu_func_share_timeline");
                    i = 2;
                } else {
                    i = 0;
                }
                if (!TextUtils.isEmpty(this.kcX.afj().tnK)) {
                    this.kkX.add(getString(R.l.dRs));
                    this.kkV.put(Integer.valueOf(i), "menu_func_report");
                    i++;
                }
                kA(i);
                if (this.kkX.size() > 0) {
                    aht();
                }
            }
            if (this.kky.aie()) {
                this.kkV.clear();
                this.kkX.clear();
                if (this.kcX.aeN() && this.kcX.aeV()) {
                    this.kkX.add(getString(R.l.dRr));
                    this.kkV.put(Integer.valueOf(0), "menu_func_gift");
                    i = 1;
                } else {
                    i = 0;
                }
                if (!TextUtils.isEmpty(this.kcX.afj().tnK)) {
                    this.kkX.add(getString(R.l.dRs));
                    this.kkV.put(Integer.valueOf(i), "menu_func_report");
                    i++;
                }
                if (this.kcX.aeN()) {
                    this.kkX.add(getString(R.l.dGB));
                    this.kkV.put(Integer.valueOf(i), "menu_func_delete");
                    i++;
                } else if (this.kcX.aeO()) {
                    String xL = com.tencent.mm.u.m.xL();
                    String afo = this.kcX.afo();
                    if (xL == null || !xL.equals(afo)) {
                        w.i("MicroMsg.CardDetailUIContoller", "the card is not belong mine");
                    } else {
                        this.kkX.add(getString(R.l.dGB));
                        this.kkV.put(Integer.valueOf(i), "menu_func_delete_share_card");
                        i++;
                    }
                }
                kA(i);
                if (this.kkX.size() > 0) {
                    aht();
                }
            }
            if (this.kky.aif()) {
                this.kkV.clear();
                this.kkX.clear();
                if (TextUtils.isEmpty(this.kcX.afj().tnK)) {
                    i = 0;
                } else {
                    this.kkX.add(getString(R.l.dRs));
                    this.kkV.put(Integer.valueOf(0), "menu_func_report");
                    i = 1;
                }
                kA(i);
                if (this.kkX.size() > 0) {
                    aht();
                }
            }
            if (this.kkD != null && (this.kkD instanceof com.tencent.mm.plugin.card.widget.b)) {
                ((com.tencent.mm.plugin.card.widget.b) this.kkD).aiW();
            }
            i(this.kky.aia(), this.kky.aib());
            if (!this.kcX.aeP() && this.kky.aij()) {
                w.i("MicroMsg.CardDetailUIContoller", "update mFromUserView");
                this.kkB.update();
            } else if (this.kcX.aeP() && this.kky.aij()) {
                w.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout for username");
                this.kkC.update();
            } else if (this.kky.aik()) {
                w.i("MicroMsg.CardDetailUIContoller", "update mAcceptHeaderLayout");
                this.kkC.update();
            } else {
                w.i("MicroMsg.CardDetailUIContoller", "don't update mFromUserView and mAcceptHeaderLayout");
                this.kkC.aiz();
                this.kkB.aiz();
            }
            if (this.kkD != null) {
                this.kkD.dh(this.kky.ahx());
            }
            if (this.fKF) {
                w.i("MicroMsg.CardDetailUIContoller", "updateUIBackground onPause return");
            } else {
                View findViewById;
                LayoutParams layoutParams;
                if (this.kcX.aeN() && this.kcX.aeP()) {
                    this.khv.findViewById(R.h.bwR).setBackgroundColor(this.kdb.getResources().getColor(R.e.aVj));
                    m.b(this.kdb, true);
                } else {
                    this.khv.findViewById(R.h.bwR).setBackgroundColor(l.ta(this.kcX.afi().hib));
                    m.a(this.kdb, this.kcX);
                }
                View findViewById2 = this.khv.findViewById(R.h.bIy);
                View findViewById3 = this.khv.findViewById(R.h.bWh);
                View findViewById4 = this.khv.findViewById(R.h.bIw);
                if (this.kcX.aeN() && this.kky.aij()) {
                    if (this.kcX.aeQ()) {
                        findViewById2.setBackgroundResource(R.g.bdD);
                        this.khv.findViewById(R.h.bSe).setBackgroundResource(R.g.bdo);
                        findViewById4.setBackgroundResource(0);
                    } else if (this.kcX.aeP()) {
                        this.khv.findViewById(R.h.bSe).setBackgroundResource(0);
                        findViewById4.setBackgroundColor(this.kdb.getResources().getColor(R.e.aVj));
                    } else if (this.kcX.aeR()) {
                        findViewById2.setBackgroundResource(R.g.bdD);
                        this.khv.findViewById(R.h.bSe).setBackgroundResource(R.g.bdo);
                        findViewById4.setBackgroundResource(0);
                    } else if (!this.kcX.aeS() && this.kcX.aeT()) {
                        findViewById4.setBackgroundColor(this.kdb.getResources().getColor(R.e.aVj));
                    }
                } else if (this.kcX.aeO()) {
                    if (this.kky.aih() && this.kkA) {
                        findViewById2.setBackgroundResource(R.g.bdD);
                        findViewById4.setBackgroundResource(0);
                    } else if (!this.kky.aih() || this.kkA) {
                        findViewById2.setBackgroundResource(0);
                        if (this.kky.ahx()) {
                            findViewById4.setBackgroundResource(R.g.bdB);
                        } else {
                            findViewById4.setBackgroundResource(R.g.bdD);
                        }
                    } else {
                        findViewById2.setBackgroundResource(R.g.bdB);
                        findViewById4.setBackgroundResource(0);
                    }
                } else if (this.kcX.aeQ()) {
                    findViewById2.setBackgroundResource(0);
                    if (this.kky.ahx()) {
                        findViewById4.setBackgroundResource(R.g.bdB);
                    } else {
                        findViewById4.setBackgroundResource(R.g.bdD);
                    }
                } else if (this.kcX.aeR()) {
                    findViewById2.setBackgroundResource(R.g.bdF);
                    findViewById4.setBackgroundResource(0);
                } else {
                    findViewById2.setBackgroundResource(0);
                    findViewById4.setBackgroundColor(this.kdb.getResources().getColor(R.e.aVj));
                }
                if (this.kcX.aeT()) {
                    TextView textView = (TextView) this.khv.findViewById(R.h.buO);
                    Drawable bitmapDrawable = new BitmapDrawable(com.tencent.mm.sdk.platformtools.d.yp(R.g.bdA));
                    bitmapDrawable.setTileModeX(TileMode.REPEAT);
                    textView.setBackgroundDrawable(bitmapDrawable);
                    textView.setVisibility(0);
                }
                Rect rect = new Rect(0, 0, 0, 0);
                findViewById2.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                findViewById2.invalidate();
                findViewById4.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                findViewById4.invalidate();
                if (this.kcX.aeO() && this.kky.aih() && this.kkA) {
                    findViewById = this.khv.findViewById(R.h.cER);
                    findViewById.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                    findViewById.invalidate();
                }
                if (this.kcX.aeN() && this.kky.aij()) {
                    findViewById = this.khv.findViewById(R.h.bSe);
                    rect.left = this.kdb.getResources().getDimensionPixelOffset(R.f.aXt);
                    rect.right = this.kdb.getResources().getDimensionPixelOffset(R.f.aXt);
                    findViewById.setPadding(rect.left, rect.top, rect.right, rect.bottom);
                    findViewById.invalidate();
                    if (this.kcX.aeR()) {
                        findViewById = this.khv.findViewById(R.h.bSf);
                        layoutParams = (LayoutParams) findViewById.getLayoutParams();
                        int dimensionPixelSize = this.kdb.getResources().getDimensionPixelSize(R.f.aXR);
                        layoutParams.rightMargin = dimensionPixelSize;
                        layoutParams.leftMargin = dimensionPixelSize;
                        findViewById.setLayoutParams(layoutParams);
                    }
                }
                if (this.kky.aij() || this.kky.aih()) {
                    if (this.kkD != null && ((this.kcX.aeN() && this.kcX.aeQ()) || this.kcX.aeO())) {
                        this.kkD.kI(0);
                    }
                } else if (this.kkD != null && ((this.kcX.aeN() && this.kcX.aeQ()) || this.kcX.aeO())) {
                    if (this.kky.ahx()) {
                        this.kkD.kI(R.g.bdE);
                    } else {
                        this.kkD.kI(R.g.bdC);
                    }
                }
                if (this.kkD != null && this.kcX.aeN() && this.kcX.aeP()) {
                    this.kkD.a(l.bJ(l.ta(this.kcX.afi().hib), this.kdb.getResources().getDimensionPixelOffset(R.f.aYO)));
                }
                if (this.kcX.aeN() && this.kcX.aeP()) {
                    layoutParams = (LayoutParams) findViewById2.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    layoutParams.rightMargin = 0;
                    layoutParams.leftMargin = 0;
                    if (TextUtils.isEmpty(this.kcX.afi().tov)) {
                        layoutParams.height = 0;
                        layoutParams.weight = 1.0f;
                    } else {
                        layoutParams.weight = 0.0f;
                        layoutParams.height = -2;
                    }
                    findViewById2.setLayoutParams(layoutParams);
                    layoutParams = (LayoutParams) findViewById3.getLayoutParams();
                    int dimensionPixelSize2 = this.kdb.getResources().getDimensionPixelSize(R.f.aXz);
                    layoutParams.rightMargin = dimensionPixelSize2;
                    layoutParams.leftMargin = dimensionPixelSize2;
                    if (this.kcX.aeP()) {
                        layoutParams.topMargin = this.kdb.getResources().getDimensionPixelSize(R.f.aXw);
                        layoutParams.bottomMargin = this.kdb.getResources().getDimensionPixelSize(R.f.aXx);
                        dimensionPixelSize2 = this.kdb.getResources().getDimensionPixelSize(R.f.aXu);
                        layoutParams.rightMargin = dimensionPixelSize2;
                        layoutParams.leftMargin = dimensionPixelSize2;
                    } else {
                        dimensionPixelSize2 = this.kdb.getResources().getDimensionPixelSize(R.f.aWG);
                        layoutParams.bottomMargin = dimensionPixelSize2;
                        layoutParams.topMargin = dimensionPixelSize2;
                    }
                    findViewById3.setLayoutParams(layoutParams);
                    layoutParams = (LayoutParams) findViewById4.getLayoutParams();
                    layoutParams.bottomMargin = 0;
                    layoutParams.topMargin = 0;
                    layoutParams.rightMargin = 0;
                    layoutParams.leftMargin = 0;
                    if (this.kcX.aeP()) {
                        layoutParams.bottomMargin = this.kdb.getResources().getDimensionPixelSize(R.f.aXu);
                    }
                    if (TextUtils.isEmpty(this.kcX.afi().tov)) {
                        layoutParams.height = 0;
                        layoutParams.weight = 1.0f;
                    } else {
                        layoutParams.weight = 0.0f;
                        layoutParams.height = -2;
                    }
                    findViewById4.setLayoutParams(layoutParams);
                    if (!TextUtils.isEmpty(this.kcX.afi().tov)) {
                        findViewById2 = findViewById(R.h.bnT);
                        layoutParams = (LayoutParams) findViewById2.getLayoutParams();
                        layoutParams.height = 0;
                        layoutParams.weight = 1.0f;
                        findViewById2.setLayoutParams(layoutParams);
                    }
                }
                this.khv.invalidate();
            }
            if (this.kky.aio()) {
                if (this.kkH == null) {
                    this.kkH = new y();
                    this.kkH.a(this);
                }
                w.i("MicroMsg.CardDetailUIContoller", "update CardStatusView");
                this.kkH.update();
            } else {
                w.i("MicroMsg.CardDetailUIContoller", "don't update CardStatusView");
                if (this.kkH != null) {
                    this.kkH.aiz();
                }
            }
            if (this.kky.aix()) {
                if (this.kkG == null) {
                    this.kkG = new com.tencent.mm.plugin.card.ui.view.c();
                    this.kkG.a(this);
                }
                w.i("MicroMsg.CardDetailUIContoller", "update mAdtitleView()");
                this.kkG.update();
            } else {
                w.i("MicroMsg.CardDetailUIContoller", "don't update AdTitleView()");
                if (this.kkG != null) {
                    this.kkG.aiz();
                }
            }
            if (this.kky.aip()) {
                if (this.kkI == null) {
                    this.kkI = new k();
                    this.kkI.a(this);
                }
                w.i("MicroMsg.CardDetailUIContoller", "update mCardDetailFieldView()");
                this.kkI.update();
            } else {
                w.i("MicroMsg.CardDetailUIContoller", "don't update mCardDetailFieldView()");
                if (this.kkI != null) {
                    this.kkI.aiz();
                }
            }
            if (this.kky.aiq()) {
                if (this.kkJ == null) {
                    this.kkJ = new com.tencent.mm.plugin.card.ui.view.w();
                    this.kkJ.a(this);
                }
                w.i("MicroMsg.CardDetailUIContoller", "update CardSecondaryFieldView");
                this.kkJ.update();
            } else {
                w.i("MicroMsg.CardDetailUIContoller", "don't update CardSecondaryFieldView");
                if (this.kkJ != null) {
                    this.kkJ.aiz();
                }
            }
            if (this.kky.air()) {
                if (this.kkK == null) {
                    this.kkK = new com.tencent.mm.plugin.card.ui.view.l();
                    this.kkK.a(this);
                }
                w.i("MicroMsg.CardDetailUIContoller", "update CardDetailTableView");
                this.kkK.update();
            } else {
                w.i("MicroMsg.CardDetailUIContoller", "don't update CardDetailTableView");
                if (this.kkK != null) {
                    this.kkK.aiz();
                }
            }
            if (this.kky.ais()) {
                if (this.kkL == null) {
                    this.kkL = new z();
                    this.kkL.a(this);
                }
                w.i("MicroMsg.CardDetailUIContoller", "update CardThirdFieldView");
                this.kkL.update();
            } else {
                w.i("MicroMsg.CardDetailUIContoller", "don't update CardThirdFieldView");
                if (this.kkL != null) {
                    this.kkL.aiz();
                }
            }
            if (this.kky.aiu()) {
                if (this.kkM == null) {
                    this.kkM = new com.tencent.mm.plugin.card.ui.view.e();
                    this.kkM.a(this);
                }
                w.i("MicroMsg.CardDetailUIContoller", "updateCardAnnoucementView");
                this.kkM.update();
            } else {
                w.i("MicroMsg.CardDetailUIContoller", "don't updateCardAnnoucementView");
                if (this.kkM != null) {
                    this.kkM.aiz();
                }
            }
            if (this.kky.ait()) {
                if (this.kkN == null) {
                    this.kkN = new u();
                    this.kkN.a(this);
                }
                w.i("MicroMsg.CardDetailUIContoller", "updateCardOperateFieldView");
                this.kkN.update();
            } else {
                w.i("MicroMsg.CardDetailUIContoller", "don't updateCardOperateFieldView");
                if (this.kkN != null) {
                    this.kkN.aiz();
                }
            }
            if (this.kky.ail()) {
                com.tencent.mm.plugin.card.model.b bVar2;
                this.kdc.clear();
                List list = this.kdc;
                f fVar2 = this.kkS;
                fVar2.kdc.clear();
                if (!(fVar2.kcX.afj().tnS == null || bg.mA(fVar2.kcX.afj().tnS.title))) {
                    bVar2 = new com.tencent.mm.plugin.card.model.b();
                    bVar2.kdS = 1;
                    bVar2.title = fVar2.kcX.afj().tnS.title;
                    bVar2.khk = "";
                    bVar2.url = "card://jump_card_gift";
                    bVar2.ofg = fVar2.kcX.afj().tnS.ofg;
                    fVar2.kdc.add(bVar2);
                }
                if (fVar2.kcX.afj().tnB != null && fVar2.kcX.afj().tnB.size() > 0) {
                    Collection Z = l.Z(fVar2.kcX.afj().tnB);
                    ((com.tencent.mm.plugin.card.model.b) Z.get(0)).kdT = false;
                    fVar2.kdc.addAll(Z);
                }
                if (((fVar2.jZM == 6 && fVar2.kcX.afj().tnF <= 0) || l.kH(fVar2.jZM)) && fVar2.kcX.afe() && fVar2.kcX.aeN() && fVar2.kcX.aeV()) {
                    bVar2 = new com.tencent.mm.plugin.card.model.b();
                    bVar2.kdS = 1;
                    bVar2.title = ab.getContext().getString(R.l.dRr);
                    bVar2.khk = "";
                    bVar2.url = "card://jump_gift";
                    fVar2.kdc.add(bVar2);
                }
                if (!(fVar2.kcX.afj().status == 0 || fVar2.kcX.afj().status == 1)) {
                    i = fVar2.kcX.afj().status;
                }
                if (fVar2.jZM != 3 && fVar2.jZM == 6) {
                    i = fVar2.kcX.afj().tnF;
                }
                oa oaVar = fVar2.kcX.afi().toC;
                if (fVar2.kcX.afj().tnL != null) {
                    TextUtils.isEmpty(fVar2.kcX.afj().tnL.title);
                }
                com.tencent.mm.plugin.card.model.b bVar3 = new com.tencent.mm.plugin.card.model.b();
                z = fVar2.kcX.aeT() ? false : oaVar == null || oaVar.ttG == null || oaVar.ttG.size() <= 0 || TextUtils.isEmpty((CharSequence) oaVar.ttG.get(0));
                bVar3.kdT = false;
                bVar3.kdS = 1;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(fVar2.getTitle());
                stringBuilder.append(fVar2.getString(R.l.dQH));
                bVar3.title = stringBuilder.toString();
                bVar3.kdH = "";
                bVar3.khk = "";
                bVar3.url = "card://jump_detail";
                if (z) {
                    fVar2.kdc.add(bVar3);
                }
                if (!fVar2.kcX.aeR() || fVar2.kcX.afi().ton <= 0) {
                    iw iwVar;
                    if (!fVar2.kcX.aeP() || fVar2.kcX.afi().ton <= 0) {
                        if (fVar2.kcX.afi().ton > 0) {
                            w.e("MicroMsg.CardDetailDataMgr", "shop_count:" + fVar2.kcX.afi().ton);
                            if (fVar2.kcX.afi().ton > 0 && fVar2.kde != null && fVar2.kde.size() > 0) {
                                iwVar = (iw) fVar2.kde.get(0);
                                if (iwVar != null && iwVar.tnX < 50000.0f) {
                                    bVar3 = new com.tencent.mm.plugin.card.model.b();
                                    bVar3.kdS = 2;
                                    bVar3.title = iwVar.name;
                                    bVar3.kdH = fVar2.kdb.getString(R.l.dRY, new Object[]{l.d(fVar2.kdb, iwVar.tnX), iwVar.hCE});
                                    bVar3.khk = "";
                                    bVar3.url = "card://jump_shop";
                                    bVar3.kdW = iwVar.kdW;
                                    bVar3.hib = fVar2.kcX.afi().hib;
                                    fVar2.kdc.add(bVar3);
                                } else if (iwVar != null) {
                                    w.e("MicroMsg.CardDetailDataMgr", "distance:" + iwVar.tnX);
                                }
                            }
                        }
                    }
                    if (fVar2.kcX.afi().ton > 0 && fVar2.kde == null) {
                        bVar2 = new com.tencent.mm.plugin.card.model.b();
                        bVar2.kdS = 1;
                        if (TextUtils.isEmpty(fVar2.kcX.afi().toN)) {
                            bVar2.title = fVar2.getString(R.l.dQn);
                        } else {
                            bVar2.title = fVar2.kcX.afi().toN;
                        }
                        bVar2.kdH = "";
                        bVar2.khk = "";
                        bVar2.url = "card://jump_shop_list";
                        fVar2.kdc.add(bVar2);
                    } else if (fVar2.kcX.afi().ton > 0 && fVar2.kde != null && fVar2.kde.size() > 0) {
                        com.tencent.mm.plugin.card.model.b bVar4 = new com.tencent.mm.plugin.card.model.b();
                        bVar4.kdS = 1;
                        iwVar = (iw) fVar2.kde.get(0);
                        if (!TextUtils.isEmpty(fVar2.kcX.afi().toN)) {
                            bVar4.title = fVar2.kcX.afi().toN;
                        } else if (fVar2.kcX.aeP() || iwVar.tnX >= 5000.0f) {
                            bVar4.title = fVar2.getString(R.l.dQn);
                        } else if (fVar2.kcX.afi().ton == 1 || fVar2.kde.size() == 1) {
                            w.i("MicroMsg.CardDetailDataMgr", "shop_count is 1 or mShopList size is 1");
                        } else {
                            bVar4.title = fVar2.getString(R.l.dQt);
                        }
                        if (!fVar2.kcX.aeP() || iwVar.tnX >= 2000.0f) {
                            bVar4.kdH = "";
                        } else if (fVar2.kcX.afi().ton > 1 || (fVar2.kde != null && fVar2.kde.size() > 1)) {
                            bVar4.kdH = fVar2.kdb.getString(R.l.dRn, new Object[]{l.d(fVar2.kdb, iwVar.tnX)});
                        } else {
                            bVar4.kdH = l.d(fVar2.kdb, iwVar.tnX);
                        }
                        bVar4.khk = "";
                        bVar4.url = "card://jump_shop_list";
                        fVar2.kdc.add(bVar4);
                    }
                }
                if (!((fVar2.kcX.aeT() && fVar2.kcX.afj().status == 3) || TextUtils.isEmpty(fVar2.kcX.afi().tog))) {
                    fVar2.kdc.add(fVar2.afH());
                }
                list.addAll(fVar2.kdc);
                l lVar = this.kkF;
                Collection collection = this.kdc;
                lVar.kdc.clear();
                lVar.kdc.addAll(collection);
                this.kkF.kps = this.kcX.aeT();
                this.kkF.notifyDataSetChanged();
            } else {
                w.i("MicroMsg.CardDetailUIContoller", "card is membership or share card or general coupon, not accept, don't updateCellData()");
            }
            if (this.kky.aim()) {
                this.kcX.a(this.kcX.afj());
                l.j(this.kcX);
                if (this.kky.ain()) {
                    if (this.kkE == null) {
                        if (this.kcX.afi().toP != null && this.kcX.afi().toP.tuh) {
                            this.kkE = new com.tencent.mm.plugin.card.ui.view.m();
                            com.tencent.mm.plugin.card.a.g agq = al.agq();
                            if (agq.kcI == null) {
                                agq.kcI = new ArrayList();
                            }
                            if (this != null) {
                                agq.kcI.add(new WeakReference(this));
                            }
                        } else if (this.kcX.afi().kdF == 10) {
                            this.kkE = new q();
                        } else {
                            this.kkE = new j();
                        }
                        this.kkE.a(this);
                        this.kkE.update();
                    } else if (this.kkE.h(this.kcX)) {
                        this.kkE.d(this.kcX);
                        this.kkE.update();
                    }
                } else if (this.kkE != null) {
                    this.kkE.aiz();
                }
                if (this.kkD != null) {
                    this.kkD.dg(true);
                }
            } else {
                w.e("MicroMsg.CardDetailUIContoller", "don't update CardCodeView");
                if (this.kkE != null) {
                    this.kkE.aiz();
                }
                if (this.kkD != null) {
                    this.kkD.dg(false);
                }
            }
            if (this.kky.aiv()) {
                w.i("MicroMsg.CardDetailUIContoller", "update CardAdvertiseView");
                this.kkO.update();
            } else {
                w.i("MicroMsg.CardDetailUIContoller", "don't update CardAdvertiseView");
                this.kkO.aiz();
            }
            this.kkQ.kcX = this.kcX;
        } else {
            w.e("MicroMsg.CardDetailUIContoller", "doUpdate fail, not support card type :%d", new Object[]{Integer.valueOf(this.kcX.afi().kdF)});
            if (TextUtils.isEmpty(this.kcX.afi().toq)) {
                com.tencent.mm.ui.base.g.a(this.kdb, getString(R.l.dRx), null, false, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ e klc;

                    {
                        this.klc = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        if (this.klc.kkY != null) {
                            this.klc.kkY.ahg();
                        }
                    }
                });
                return;
            }
            com.tencent.mm.plugin.card.b.b.a(this.kdb, this.kcX.afi().toq, 0);
            if (this.kkY != null) {
                this.kkY.ahg();
            }
        }
    }

    public final void c(com.tencent.mm.plugin.card.b.c cVar) {
        w.i("MicroMsg.CardDetailUIContoller", "onGetCodeSuccess! do update code view!");
        Message obtain = Message.obtain();
        c cVar2 = new c();
        cVar2.kll = b.klg;
        cVar2.klm = cVar;
        obtain.obj = cVar2;
        this.kla.sendMessage(obtain);
    }

    public final void H(int i, String str) {
        String string;
        w.e("MicroMsg.CardDetailUIContoller", "onGetCodeFail! errCode = %d, errMsg=%s", new Object[]{Integer.valueOf(i), str});
        Message obtain = Message.obtain();
        c cVar = new c();
        cVar.kll = b.klj;
        cVar.errCode = i;
        if (i == -1) {
            string = getString(R.l.dQM);
        } else if (i == 2) {
            string = getString(R.l.dQx);
        } else {
            string = getString(R.l.dQL);
        }
        cVar.fPf = string;
        obtain.obj = cVar;
        this.kla.sendMessage(obtain);
    }

    public final void afI() {
        w.i("MicroMsg.CardDetailUIContoller", "on show TimeExpired! do update refresh code view!");
        Message obtain = Message.obtain();
        c cVar = new c();
        cVar.kll = b.klh;
        obtain.obj = cVar;
        this.kla.sendMessage(obtain);
    }

    public final void b(com.tencent.mm.plugin.card.b.c cVar) {
        w.i("MicroMsg.CardDetailUIContoller", "on onReceiveCodeUnavailable! do update refresh code view!");
        Message obtain = Message.obtain();
        c cVar2 = new c();
        cVar2.kll = b.kli;
        cVar2.klm = cVar;
        obtain.obj = cVar2;
        this.kla.sendMessage(obtain);
    }

    public final void a(boolean z, com.tencent.mm.plugin.card.a.i.b bVar, boolean z2) {
        int i = 1;
        if (z) {
            lz lzVar = this.kcX.afj().tnO;
            if (this.kcX.afb()) {
                com.tencent.mm.plugin.card.b.b.a(this.kdb, bVar.kdu, bVar.kdv, z2, this.kcX);
                g.oUh.i(11941, new Object[]{Integer.valueOf(17), this.kcX.afm(), this.kcX.afn(), "", this.kcX.afj().tnO.title});
                return;
            } else if (lzVar != null && !TextUtils.isEmpty(lzVar.tnY) && !TextUtils.isEmpty(lzVar.tnZ)) {
                com.tencent.mm.plugin.card.b.b.a(this.kcX.afm(), lzVar, this.kkZ.khL, this.kkZ.klf);
                r3 = g.oUh;
                r5 = new Object[5];
                r5[0] = Integer.valueOf(6);
                r5[1] = this.kcX.afm();
                r5[2] = this.kcX.afn();
                r5[3] = "";
                r5[4] = lzVar.title != null ? lzVar.title : "";
                r3.i(11941, r5);
                return;
            } else if (lzVar == null || TextUtils.isEmpty(lzVar.url)) {
                g gVar = g.oUh;
                Object[] objArr = new Object[9];
                objArr[0] = "CardConsumedCodeUI";
                objArr[1] = Integer.valueOf(this.kcX.afi().kdF);
                objArr[2] = this.kcX.afn();
                objArr[3] = this.kcX.afm();
                objArr[4] = Integer.valueOf(0);
                objArr[5] = Integer.valueOf(this.kkZ.khL);
                objArr[6] = this.kkZ.kkj;
                if (!this.kcX.afg()) {
                    i = 0;
                }
                objArr[7] = Integer.valueOf(i);
                objArr[8] = "";
                gVar.i(11324, objArr);
                sN(bVar.kdr);
                return;
            } else {
                com.tencent.mm.plugin.card.b.b.a(this.kdb, l.o(lzVar.url, lzVar.tpl), 1);
                r3 = g.oUh;
                r5 = new Object[5];
                r5[0] = Integer.valueOf(6);
                r5[1] = this.kcX.afm();
                r5[2] = this.kcX.afn();
                r5[3] = "";
                r5[4] = lzVar.title != null ? lzVar.title : "";
                r3.i(11941, r5);
                return;
            }
        }
        gVar = g.oUh;
        objArr = new Object[9];
        objArr[0] = "CardConsumedCodeUI";
        objArr[1] = Integer.valueOf(this.kcX.afi().kdF);
        objArr[2] = this.kcX.afn();
        objArr[3] = this.kcX.afm();
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(this.kkZ.khL);
        objArr[6] = this.kkZ.kkj;
        if (!this.kcX.afg()) {
            i = 0;
        }
        objArr[7] = Integer.valueOf(i);
        objArr[8] = "";
        gVar.i(11324, objArr);
        sN(bVar.kdr);
    }

    private void i(boolean z, boolean z2) {
        if (this.kkD != null) {
            this.kkD.i(z, z2);
        }
    }

    private void kA(int i) {
        LinkedList linkedList = this.kcX.afj().tnM;
        if (linkedList != null) {
            this.kkW.clear();
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                au auVar = (au) linkedList.get(i2);
                if (!(bg.mA(auVar.text) || bg.mA(auVar.url))) {
                    this.kkX.add(auVar.text);
                    this.kkV.put(Integer.valueOf(i), auVar.text);
                    this.kkW.put(auVar.text, auVar.url);
                    i++;
                }
            }
        }
    }

    private void aht() {
        int i = R.g.bhb;
        if (this.kcX.aeP()) {
            i = R.g.bds;
        }
        this.kdb.a(0, i, new OnMenuItemClickListener(this) {
            final /* synthetic */ e klc;

            {
                this.klc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                g.oUh.i(11582, new Object[]{"CardDetailUiMenu", Integer.valueOf(1), Integer.valueOf(this.klc.kcX.afi().kdF), this.klc.kcX.afn(), this.klc.kcX.afm(), this.klc.kkZ.kkj});
                com.tencent.mm.ui.base.g.a(this.klc.kdb.uSU.uTo, null, (String[]) this.klc.kkX.toArray(new String[this.klc.kkX.size()]), null, false, new com.tencent.mm.ui.base.g.c(this) {
                    final /* synthetic */ AnonymousClass5 kld;

                    {
                        this.kld = r1;
                    }

                    public final void hq(int i) {
                        String str = (String) this.kld.klc.kkV.get(Integer.valueOf(i));
                        if (!TextUtils.isEmpty(str)) {
                            if (str.equals("menu_func_share_friend")) {
                                int i2;
                                com.tencent.mm.ui.MMActivity.a aVar = this.kld.klc;
                                com.tencent.mm.plugin.card.b.b.a(aVar.kdb, 1, aVar);
                                aVar.kdb.uSV = aVar;
                                g gVar = g.oUh;
                                Object[] objArr = new Object[9];
                                objArr[0] = "BrandContactView";
                                objArr[1] = Integer.valueOf(this.kld.klc.kcX.afi().kdF);
                                objArr[2] = this.kld.klc.kcX.afn();
                                objArr[3] = this.kld.klc.kcX.afm();
                                objArr[4] = Integer.valueOf(0);
                                objArr[5] = Integer.valueOf(this.kld.klc.kkZ.khL);
                                objArr[6] = this.kld.klc.kkZ.kkj;
                                if (this.kld.klc.kcX.afg()) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                objArr[7] = Integer.valueOf(i2);
                                objArr[8] = "";
                                gVar.i(11324, objArr);
                                g.oUh.i(11582, new Object[]{"OperShareFriend", Integer.valueOf(1), Integer.valueOf(this.kld.klc.kcX.afi().kdF), this.kld.klc.kcX.afn(), this.kld.klc.kcX.afm(), this.kld.klc.kkT});
                            } else if (str.equals("menu_func_gift")) {
                                this.kld.klc.ahu();
                            } else if (str.equals("menu_func_delete")) {
                                str = "";
                                if (this.kld.klc.kcX.aeP()) {
                                    str = this.kld.klc.kdb.getString(R.l.dQF);
                                }
                                com.tencent.mm.plugin.card.b.d.a(this.kld.klc.kdb, this.kld.klc.kkZ.kcJ, str, new com.tencent.mm.plugin.card.b.d.a(this) {
                                    final /* synthetic */ AnonymousClass1 kle;

                                    {
                                        this.kle = r1;
                                    }

                                    public final void aeM() {
                                        if (this.kle.kld.klc.kkY != null) {
                                            this.kle.kld.klc.kkY.ahe();
                                        }
                                    }
                                });
                                g.oUh.i(11582, new Object[]{"OperDelete", Integer.valueOf(1), Integer.valueOf(this.kld.klc.kcX.afi().kdF), this.kld.klc.kcX.afn(), this.kld.klc.kcX.afm(), ""});
                            } else if (str.equals("menu_func_service")) {
                                if (!TextUtils.isEmpty(this.kld.klc.kcX.afi().tog)) {
                                    com.tencent.mm.plugin.card.b.b.Q(this.kld.klc.kdb, this.kld.klc.kcX.afi().tog);
                                    al.agg().m(this.kld.klc.kcX.afm(), this.kld.klc.kcX.afn(), 1);
                                }
                                g.oUh.i(11582, new Object[]{"OperService", Integer.valueOf(1), Integer.valueOf(this.kld.klc.kcX.afi().kdF), this.kld.klc.kcX.afn(), this.kld.klc.kcX.afm(), this.kld.klc.kkZ.kkj});
                            } else if (str.equals("menu_func_report")) {
                                if (!TextUtils.isEmpty(this.kld.klc.kcX.afj().tnK)) {
                                    com.tencent.mm.plugin.card.b.b.a(this.kld.klc.kdb, this.kld.klc.kcX.afj().tnK, this.kld.klc.getString(R.l.dRB));
                                }
                                g.oUh.i(11582, new Object[]{"OperReport", Integer.valueOf(1), Integer.valueOf(this.kld.klc.kcX.afi().kdF), this.kld.klc.kcX.afn(), this.kld.klc.kcX.afm(), ""});
                            } else if (str.equals("menu_func_share_timeline")) {
                                com.tencent.mm.platformtools.j.a(new com.tencent.mm.plugin.card.model.m(this.kld.klc.kcX.afi().kdG));
                                Context context = this.kld.klc.kdb;
                                com.tencent.mm.plugin.card.base.b bVar = this.kld.klc.kcX;
                                String str2 = this.kld.klc.kkZ.kcJ;
                                Object obj = this.kld.klc.kkZ.kkl;
                                Intent intent = new Intent();
                                intent.putExtra("Ksnsupload_link", bVar.afi().toq);
                                intent.putExtra("KContentObjDesc", bVar.afi().keT);
                                intent.putExtra("Ksnsupload_title", bVar.afi().title);
                                if (TextUtils.isEmpty(obj)) {
                                    intent.putExtra("KUploadProduct_UserData", str2 + "#");
                                } else {
                                    intent.putExtra("KUploadProduct_UserData", str2 + "#" + obj);
                                }
                                intent.putExtra("Ksnsupload_imgurl", bVar.afi().kdG);
                                if (!TextUtils.isEmpty(bVar.afi().kdG)) {
                                    intent.putExtra("KsnsUpload_imgPath", new com.tencent.mm.plugin.card.model.m(bVar.afi().kdG).Nm());
                                }
                                w.d("MicroMsg.CardActivityHelper", "doShareTimeLine KSnsUploadImgPath:" + intent.getStringExtra("KsnsUpload_imgPath"));
                                intent.putExtra("src_username", com.tencent.mm.u.m.xL());
                                intent.putExtra("src_displayname", com.tencent.mm.u.m.xN());
                                intent.putExtra("Ksnsupload_appid", bVar.afi().fTO);
                                intent.putExtra("Ksnsupload_appname", bVar.afi().tog);
                                intent.putExtra("Ksnsupload_type", 7);
                                String fQ = com.tencent.mm.u.q.fQ("card_package");
                                com.tencent.mm.u.q.yC().n(fQ, true).l("prePublishId", "card_package");
                                intent.putExtra("reportSessionId", fQ);
                                com.tencent.mm.bb.d.a(context, "sns", ".ui.En_c4f742e5", intent, false);
                                g.oUh.i(11582, new Object[]{"OperShareTimeLine", Integer.valueOf(1), Integer.valueOf(this.kld.klc.kcX.afi().kdF), this.kld.klc.kcX.afn(), this.kld.klc.kcX.afm(), this.kld.klc.kkZ.kkj});
                            } else if (str.equals("menu_func_delete_share_card")) {
                                com.tencent.mm.plugin.card.b.d.a(this.kld.klc.kdb, this.kld.klc.kkZ.kcJ, "", new com.tencent.mm.plugin.card.b.d.a(this) {
                                    final /* synthetic */ AnonymousClass1 kle;

                                    {
                                        this.kle = r1;
                                    }

                                    public final void aeM() {
                                        if (this.kle.kld.klc.kkY != null) {
                                            this.kle.kld.klc.kkY.ahh();
                                        }
                                    }
                                });
                            } else {
                                str = (String) this.kld.klc.kkW.get(str);
                                if (!bg.mA(str)) {
                                    com.tencent.mm.plugin.card.b.b.a(this.kld.klc.kdb, str, 0);
                                }
                            }
                        }
                    }
                });
                return true;
            }
        });
    }

    public final void ahu() {
        com.tencent.mm.plugin.card.b.b.a(this.kdb, 0, (com.tencent.mm.ui.MMActivity.a) this);
        this.kdb.uSV = this;
    }

    public final void a(final int i, int i2, Intent intent) {
        switch (i) {
            case 0:
            case 1:
            case 4:
                if (i2 == -1) {
                    this.kkT = intent.getStringExtra("Select_Conv_User");
                    final String str = this.kkT;
                    if (this.kcX.afi() == null) {
                        w.e("MicroMsg.CardDetailUIContoller", "showGiftConfirmDialog mCardInfo.getCardTpInfo() == null");
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    if (i == 0) {
                        if (TextUtils.isEmpty(this.kcX.afk().ubj)) {
                            stringBuilder.append(getString(R.l.eWV));
                        } else {
                            stringBuilder.append(this.kcX.afk().ubj);
                        }
                    } else if (i == 1) {
                        stringBuilder.append(getString(R.l.dRX) + this.kkS.getTitle());
                    } else if (i == 4) {
                        stringBuilder.append(getString(R.l.dRA) + this.kkS.getTitle());
                    }
                    com.tencent.mm.pluginsdk.ui.applet.d.a(this.kdb.uSU, stringBuilder.toString(), this.kcX.afi().kdG, this.kcX.afi().title + "\n" + this.kcX.afi().keT, null, true, this.kdb.getResources().getString(R.l.dIA), new com.tencent.mm.pluginsdk.ui.applet.k.a(this) {
                        final /* synthetic */ e klc;

                        public final void a(boolean z, String str, int i) {
                            if (z) {
                                this.klc.kkU = str;
                                if (i == 0) {
                                    if (this.klc.kkY != null) {
                                        this.klc.kkY.sM(str);
                                    }
                                    g.oUh.i(11582, new Object[]{"OperGift", Integer.valueOf(1), Integer.valueOf(this.klc.kcX.afi().kdF), this.klc.kcX.afn(), this.klc.kcX.afm(), this.klc.kkT});
                                    com.tencent.mm.ui.base.g.bl(this.klc.kdb, this.klc.kdb.getResources().getString(R.l.dQW));
                                } else if (i == 1) {
                                    r0 = this.klc;
                                    r0.kcX.afk().ubj = r0.getString(R.l.dRX) + r0.kkS.getTitle();
                                    l.a(r0.kcX, r0.kkT, r0.kkZ.kkl, 2);
                                    l.bF(r0.kkU, r0.kkT);
                                    com.tencent.mm.ui.base.g.bl(this.klc.kdb, this.klc.kdb.getResources().getString(R.l.dQW));
                                } else if (i == 4) {
                                    r0 = this.klc;
                                    if (TextUtils.isEmpty(r0.kcX.afo())) {
                                        r0.kcX.sf(com.tencent.mm.u.m.xL());
                                    }
                                    r0.kcX.afk().ubj = r0.getString(R.l.dRA) + r0.kkS.getTitle();
                                    l.a(r0.kcX, r0.kkT, r0.kkZ.kkl, 23);
                                    l.bF(r0.kkU, r0.kkT);
                                    g.oUh.i(11582, new Object[]{"OpeRecommendCard", Integer.valueOf(this.klc.kkZ.jZM), Integer.valueOf(this.klc.kcX.afi().kdF), this.klc.kcX.afn(), this.klc.kcX.afm(), this.klc.kkT});
                                    com.tencent.mm.ui.base.g.bl(this.klc.kdb, this.klc.kdb.getResources().getString(R.l.dQW));
                                }
                            }
                        }
                    });
                    return;
                }
                return;
            case 2:
                if (i2 == -1) {
                    this.kim = intent.getIntExtra("Ktag_range_index", 0);
                    w.i("MicroMsg.CardDetailUIContoller", "mPrivateSelelct : %d", new Object[]{Integer.valueOf(this.kim)});
                    if (this.kim >= 2) {
                        this.kin = intent.getStringExtra("Klabel_name_list");
                        this.kio = intent.getStringExtra("Kother_user_name_list");
                        w.d("MicroMsg.CardDetailUIContoller", "mPrivateSelect : %d, names : %s", new Object[]{Integer.valueOf(this.kim), this.kin});
                        if (TextUtils.isEmpty(this.kin) && TextUtils.isEmpty(this.kio)) {
                            w.e("MicroMsg.CardDetailUIContoller", "mLabelNameList by getIntent is empty");
                            return;
                        }
                        List asList = Arrays.asList(this.kin.split(","));
                        this.kiq = l.ab(asList);
                        this.kip = l.aa(asList);
                        if (this.kio != null && this.kio.length() > 0) {
                            this.kip.addAll(Arrays.asList(this.kio.split(",")));
                        }
                        if (this.kiq != null) {
                            w.i("MicroMsg.CardDetailUIContoller", "mPrivateIdsList size is " + this.kiq.size());
                        }
                        if (this.kip != null) {
                            w.i("MicroMsg.CardDetailUIContoller", "mPrivateNamesList size is " + this.kip.size());
                            Iterator it = this.kip.iterator();
                            while (it.hasNext()) {
                                w.d("MicroMsg.CardDetailUIContoller", "username : %s", new Object[]{(String) it.next()});
                            }
                        }
                        if (this.kim == 2) {
                            this.kkO.sQ(this.kdb.getString(R.l.dRP, new Object[]{agD()}));
                            return;
                        } else if (this.kim == 3) {
                            this.kkO.sQ(this.kdb.getString(R.l.dRO, new Object[]{agD()}));
                            return;
                        } else {
                            this.kkO.sQ(this.kdb.getString(R.l.dRN));
                            return;
                        }
                    }
                    this.kkO.sQ(this.kdb.getString(R.l.dRN));
                    return;
                }
                return;
            case 3:
                if (this.kkY != null) {
                    this.kkY.ahi();
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

    private void sN(String str) {
        Intent intent = new Intent();
        if (this.kcX instanceof CardInfo) {
            intent.putExtra("key_card_info_data", (CardInfo) this.kcX);
        } else if (this.kcX instanceof ShareCardInfo) {
            intent.putExtra("key_card_info_data", (ShareCardInfo) this.kcX);
        }
        intent.setClass(this.kdb, CardConsumeCodeUI.class);
        intent.putExtra("key_from_scene", this.kkZ.jZM);
        intent.putExtra("key_previous_scene", this.kkZ.khL);
        intent.putExtra("key_mark_user", str);
        intent.putExtra("key_from_appbrand_type", this.kkZ.klf);
        this.kdb.startActivityForResult(intent, 3);
        this.kdb.uSV = this;
    }

    public final void ahv() {
        int i;
        Intent intent = new Intent();
        if (this.kcX instanceof CardInfo) {
            intent.putExtra("key_card_info_data", (CardInfo) this.kcX);
        } else if (this.kcX instanceof ShareCardInfo) {
            intent.putExtra("key_card_info_data", (ShareCardInfo) this.kcX);
        }
        intent.putExtra("key_from_appbrand_type", this.kkZ.klf);
        intent.setClass(this.kdb, CardShopUI.class);
        this.kdb.startActivity(intent);
        g gVar = g.oUh;
        Object[] objArr = new Object[9];
        objArr[0] = "UsedStoresView";
        objArr[1] = Integer.valueOf(this.kcX.afi().kdF);
        objArr[2] = this.kcX.afn();
        objArr[3] = this.kcX.afm();
        objArr[4] = Integer.valueOf(0);
        objArr[5] = Integer.valueOf(this.kkZ.khL);
        objArr[6] = this.kkZ.kkj;
        if (this.kcX.afg()) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[7] = Integer.valueOf(i);
        objArr[8] = "";
        gVar.i(11324, objArr);
    }

    public final int ahw() {
        if (this.kkS == null) {
            return 0;
        }
        f fVar = this.kkS;
        if (fVar.kdd == null ? false : fVar.kdd.kdV) {
            return 1;
        }
        return 0;
    }

    public final boolean ahx() {
        return this.kky == null ? false : this.kky.ahx();
    }
}
