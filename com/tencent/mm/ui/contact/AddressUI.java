package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.FragmentActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.av.l;
import com.tencent.mm.e.b.af;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.awp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.AlphabetScrollBar;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.voicesearch.b;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;
import java.util.List;

public class AddressUI extends FragmentActivity {
    public q vxO;

    public static class a extends com.tencent.mm.ui.AbstractTabChildActivity.a implements e {
        private final long hXO = 180000;
        private ProgressDialog isv = null;
        List<String> jBA = new LinkedList();
        public int kaQ;
        public int kaR;
        public g kaU;
        d ktu = new d(new OnScrollListener(this) {
            final /* synthetic */ a vVM;

            {
                this.vVM = r1;
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (i >= 2 && !this.vVM.vVw) {
                    this.vVM.vVw = true;
                }
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 2) {
                    com.tencent.mm.bl.d.bOi().cJ(AddressUI.class.getName() + ".Listview", 4);
                }
            }
        });
        public n.d lmm = new n.d(this) {
            final /* synthetic */ a vVM;

            {
                this.vVM = r1;
            }

            public final void c(MenuItem menuItem, int i) {
                switch (menuItem.getItemId()) {
                    case 1:
                    case 2:
                        this.vVM.TL(this.vVM.vVs);
                        return;
                    case 7:
                        q qVar = this.vVM;
                        String str = this.vVM.vVs;
                        ap.yY();
                        af Rc = c.wR().Rc(str);
                        if (com.tencent.mm.j.a.ez(Rc.field_type)) {
                            Intent intent = new Intent();
                            intent.setClass(qVar.uSU.uTo, ContactRemarkInfoModUI.class);
                            intent.putExtra("Contact_User", Rc.field_username);
                            intent.putExtra("view_mode", true);
                            qVar.uSU.uTo.startActivity(intent);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        private Animation lxO;
        public ListView mZO;
        public boolean nhO = false;
        public TextView uXM;
        public String vUP;
        private String vUQ;
        private b vVA;
        private b vVB;
        private b vVC;
        private ContactCountView vVD;
        public i vVE;
        boolean vVF;
        private boolean vVG = true;
        private LinearLayout vVH;
        private Animation vVI;
        private com.tencent.mm.ui.base.VerticalScrollBar.a vVJ = new com.tencent.mm.ui.base.VerticalScrollBar.a(this) {
            final /* synthetic */ a vVM;

            {
                this.vVM = r1;
            }

            public final void sd(String str) {
                int i = 0;
                if (this.vVM.getString(R.l.ePv).equals(str)) {
                    this.vVM.mZO.setSelection(0);
                    return;
                }
                a aVar = this.vVM.vVp;
                w.v("MicroMsg.AddressAdapter", "getSections");
                String[] strArr = aVar.vUV;
                if (strArr == null) {
                    return;
                }
                if ("↑".equals(str)) {
                    this.vVM.mZO.setSelection(0);
                } else if ("☆".equals(str)) {
                    this.vVM.mZO.setSelection(this.vVM.mZO.getHeaderViewsCount());
                } else {
                    while (i < strArr.length && strArr[i] != null) {
                        if (strArr[i].equals(str)) {
                            this.vVM.mZO.setSelection(this.vVM.vVp.getPositionForSection(i) + this.vVM.mZO.getHeaderViewsCount());
                            return;
                        }
                        i++;
                    }
                }
            }
        };
        List<String> vVK = new LinkedList();
        private Runnable vVL = new Runnable(this) {
            final /* synthetic */ a vVM;

            {
                this.vVM = r1;
            }

            public final void run() {
                q qVar = this.vVM;
                LauncherUI launcherUI = (LauncherUI) qVar.uSU.uTo;
                if (launcherUI == null || launcherUI.uRM.lCS == 1) {
                    BackwardSupportUtil.c.a(qVar.mZO);
                    new ae().postDelayed(new Runnable(qVar) {
                        final /* synthetic */ a vVM;

                        {
                            this.vVM = r1;
                        }

                        public final void run() {
                            this.vVM.mZO.setSelection(0);
                        }
                    }, 300);
                }
            }
        };
        TextView vVn;
        private TextView vVo;
        public a vVp;
        public b vVq;
        private String vVr;
        public String vVs = "";
        private int vVt;
        private AlphabetScrollBar vVu;
        private LinearLayout vVv = null;
        public boolean vVw = false;
        private boolean vVx = false;
        private k vVy;
        private BizContactEntranceView vVz;

        protected final int getLayoutId() {
            return R.i.cTF;
        }

        public final boolean biv() {
            return false;
        }

        public final boolean Xb() {
            return true;
        }

        public final void lv(boolean z) {
            if (this.vVu != null) {
                if (this.lxO == null) {
                    this.lxO = AnimationUtils.loadAnimation(this.uSU.uTo, R.a.aQV);
                    this.lxO.setDuration(200);
                }
                if (this.vVI == null) {
                    this.vVI = AnimationUtils.loadAnimation(this.uSU.uTo, R.a.aQV);
                    this.vVI.setDuration(200);
                }
                if (z) {
                    if (this.vVu.getVisibility() != 0) {
                        this.vVu.setVisibility(0);
                        this.vVu.startAnimation(this.lxO);
                    }
                } else if (4 != this.vVu.getVisibility()) {
                    this.vVu.setVisibility(8);
                    this.vVu.startAnimation(this.vVI);
                }
            }
        }

        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            ap.yY();
            af Rc = c.wR().Rc(this.vVs);
            if (Rc == null) {
                w.e("MicroMsg.AddressUI", "onCreateContextMenu, contact is null, username = " + this.vVs);
            } else if (!m.xL().equals(Rc.field_username)) {
                if (o.eS(this.vVs)) {
                    contextMenu.setHeaderTitle(h.a(view.getContext(), Rc.tL()));
                    contextMenu.add(adapterContextMenuInfo.position, 2, 0, R.l.dCw);
                } else if (!o.fh(this.vVs) && !o.fx(this.vVs)) {
                    contextMenu.setHeaderTitle(h.a(view.getContext(), Rc.tL()));
                    if (com.tencent.mm.j.a.ez(Rc.field_type) && Rc.field_deleteFlag != 1) {
                        contextMenu.add(adapterContextMenuInfo.position, 7, 0, R.l.dYN);
                    }
                }
            }
        }

        public final void TL(String str) {
            ap.yY();
            c.wR().b(this.vVp);
            ap.yY();
            x Rc = c.wR().Rc(str);
            Rc.td();
            o.t(Rc);
            if (o.dH(str)) {
                ap.yY();
                c.wR().Ri(str);
                ap.yY();
                c.xa().gb(str);
            } else {
                ap.yY();
                c.wR().a(str, Rc);
            }
            this.vVp.cU(str, 5);
            ap.yY();
            c.wR().a(this.vVp);
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (this.isv != null) {
                this.isv.dismiss();
                this.isv = null;
            }
            if (!u.bp(this.uSU.uTo) || com.tencent.mm.ui.p.a.a(this.uSU.uTo, i, i2, str, 4) || i != 0 || i2 == 0) {
            }
        }

        private void bXK() {
            this.jBA = new LinkedList();
            this.vVK = new LinkedList();
            com.tencent.mm.bb.d.bGP();
            this.jBA.add("tmessage");
            this.vVK.addAll(this.jBA);
            if (!this.jBA.contains("officialaccounts")) {
                this.jBA.add("officialaccounts");
            }
            this.jBA.add("helper_entry");
            if (this.vVp != null) {
                this.vVp.cK(this.jBA);
            }
            if (this.vVq != null) {
                this.vVq.cK(this.vVK);
            }
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            w.i("MicroMsg.AddressUI", "onAcvityResult requestCode: %d", Integer.valueOf(i));
            if (i == 6 && i2 == -1) {
                bPk();
                finish();
            } else if (i2 == -1) {
                switch (i) {
                    case 4:
                        if (this.uPP) {
                            bPj().setResult(-1);
                        } else {
                            bPj().setResult(-1, intent);
                        }
                        finish();
                        return;
                    default:
                        return;
                }
            }
        }

        protected final void bOl() {
            w.v("MicroMsg.AddressUI", "address ui on create");
            w.v("MicroMsg.AddressUI", "on address ui create");
            this.vVw = false;
            this.nhO = false;
            this.vVx = false;
            this.vUP = null;
            this.vUQ = null;
            this.vVr = null;
            ap.vd().a(138, (e) this);
            this.vUP = "@all.contact.without.chatroom";
            this.vUQ = getStringExtra("Contact_GroupFilter_Str");
            this.vVr = getString(R.l.eqI);
            this.vVt = getIntExtra("List_Type", 2);
            w.v("MicroMsg.AddressUI", "on address ui init view, %s", getResources().getDisplayMetrics());
            if (this.mZO != null) {
                if (this.vVy != null) {
                    this.mZO.removeHeaderView(this.vVy);
                }
                if (this.vVz != null) {
                    this.mZO.removeHeaderView(this.vVz);
                }
                if (this.vVA != null) {
                    this.mZO.removeHeaderView(this.vVA);
                }
                if (this.vVC != null) {
                    this.mZO.removeHeaderView(this.vVC);
                }
            }
            this.mZO = (ListView) findViewById(R.h.bnw);
            this.mZO.setScrollingCacheEnabled(false);
            this.vVn = (TextView) findViewById(R.h.bLM);
            this.vVn.setText(R.l.dCx);
            this.uXM = (TextView) findViewById(R.h.bMf);
            this.uXM.setText(R.l.dCz);
            this.vVo = (TextView) findViewById(R.h.bMi);
            this.vVo.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a vVM;

                {
                    this.vVM = r1;
                }

                public final void onClick(View view) {
                }
            });
            this.vVp = new a(this.uSU.uTo, this.vUP, this.vUQ, this.vVt);
            this.mZO.setAdapter(null);
            this.vVp.a(new com.tencent.mm.ui.e.a(this) {
                final /* synthetic */ a vVM;

                {
                    this.vVM = r1;
                }

                public final void OH() {
                    a aVar = this.vVM;
                    this.vVM.vVp.getCount();
                    aVar.vVn.setVisibility(8);
                    aVar.mZO.setVisibility(0);
                    this.vVM.vVp.bXH();
                }

                public final void OI() {
                }
            });
            this.vVp.vVc = true;
            this.vVp.l(this);
            this.vVp.a(new MMSlideDelView.c(this) {
                final /* synthetic */ a vVM;

                {
                    this.vVM = r1;
                }

                public final int cb(View view) {
                    return this.vVM.mZO.getPositionForView(view);
                }
            });
            this.vVp.a(new f(this) {
                final /* synthetic */ a vVM;

                {
                    this.vVM = r1;
                }

                public final void s(View view, int i) {
                    this.vVM.mZO.performItemClick(view, i, 0);
                }
            });
            this.vVp.a(new MMSlideDelView.e(this) {
                final /* synthetic */ a vVM;

                {
                    this.vVM = r1;
                }

                public final void aQ(Object obj) {
                    if (obj == null) {
                        w.e("MicroMsg.AddressUI", "onItemDel object null");
                    } else {
                        this.vVM.TL(obj.toString());
                    }
                }
            });
            this.vVq = new b(this.uSU.uTo, 1);
            this.vVq.lQ(true);
            this.vVH = new LinearLayout(this.uSU.uTo);
            this.vVH.setOrientation(1);
            this.mZO.addHeaderView(this.vVH);
            this.vVB = new b(this.uSU.uTo, com.tencent.mm.ui.contact.b.a.ContactIpCall);
            this.vVH.addView(this.vVB);
            ap.yY();
            ((Boolean) c.vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.valueOf(false))).booleanValue();
            this.vVB.setVisible(false);
            this.vVy = new k(this.uSU.uTo);
            this.vVH.addView(this.vVy);
            this.vVA = new b(this.uSU.uTo, com.tencent.mm.ui.contact.b.a.Chatromm);
            this.vVH.addView(this.vVA);
            this.vVA.setVisible(true);
            this.vVC = new b(this.uSU.uTo, com.tencent.mm.ui.contact.b.a.ContactLabel);
            this.vVH.addView(this.vVC);
            this.vVC.setVisible(true);
            ListView listView = this.mZO;
            View contactCountView = new ContactCountView(this.uSU.uTo);
            this.vVD = contactCountView;
            listView.addFooterView(contactCountView, null, false);
            if (com.tencent.mm.bb.d.Jt("brandservice")) {
                this.vVz = new BizContactEntranceView(this.uSU.uTo);
                this.vVH.addView(this.vVz);
                this.vVz.setVisible(true);
                this.vVE = new i(this.uSU.uTo, new com.tencent.mm.ui.contact.i.a(this) {
                    final /* synthetic */ a vVM;

                    {
                        this.vVM = r1;
                    }

                    public final void BK(int i) {
                        if (this.vVM.vVE != null) {
                            if (i <= 0) {
                                this.vVM.vVE.setVisibility(8);
                            } else {
                                this.vVM.vVE.setVisibility(0);
                            }
                        }
                    }
                });
                if (this.vVE.bXV() <= 0) {
                    this.vVE.setVisibility(8);
                }
                this.vVH.addView(this.vVE);
            }
            this.kaU = new g(this.uSU.uTo);
            this.vVp.vVa = new com.tencent.mm.ui.contact.a.a(this) {
                final /* synthetic */ a vVM;

                {
                    this.vVM = r1;
                }
            };
            this.mZO.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ a vVM;

                {
                    this.vVM = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    w.i("MicroMsg.AddressUI", "onItemClick " + i + (this.vVM.vVq == null ? this.vVM.vVq : Boolean.valueOf(this.vVM.vVq.wsb)));
                    if ((i != 0 || "@biz.contact".equals(this.vVM.vUP)) && i >= this.vVM.mZO.getHeaderViewsCount()) {
                        int headerViewsCount = i - this.vVM.mZO.getHeaderViewsCount();
                        String str;
                        if (this.vVM.vVq == null || !this.vVM.vVq.wsb) {
                            com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) this.vVM.vVp.yQ(headerViewsCount);
                            if (fVar != null) {
                                str = fVar.field_username;
                                q qVar = this.vVM;
                                if (str != null && str.length() > 0) {
                                    if (o.fu(str)) {
                                        w.e("MicroMsg.AddressUI", "error, 4.5 do not contain this contact %s", str);
                                        return;
                                    }
                                    Intent intent = new Intent();
                                    intent.putExtra("Contact_User", str);
                                    if (o.eS(str)) {
                                        intent.putExtra("Is_group_card", true);
                                    }
                                    if (str != null && str.length() > 0) {
                                        e.a(intent, str);
                                        com.tencent.mm.bb.d.b(qVar.uSU.uTo, "profile", ".ui.ContactInfoUI", intent);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        boolean nJ = this.vVM.vVq.nJ(headerViewsCount);
                        boolean Ck = this.vVM.vVq.Ck(headerViewsCount);
                        w.i("MicroMsg.AddressUI", "onItemClick " + Ck);
                        if (Ck) {
                            this.vVM.vVq.Uv("");
                        } else if (nJ) {
                            awp Cj = this.vVM.vVq.Cj(headerViewsCount);
                            String str2 = Cj.ttp.tZr;
                            ap.yY();
                            af Rc = c.wR().Rc(str2);
                            if (com.tencent.mm.j.a.ez(Rc.field_type)) {
                                r1 = new Intent();
                                r1.putExtra("Contact_User", str2);
                                r1.putExtra("Contact_Scene", 3);
                                if (str2 != null && str2.length() > 0) {
                                    if (Rc.bLe()) {
                                        com.tencent.mm.plugin.report.service.g.oUh.A(10298, str2 + ",3");
                                    }
                                    e.a(r1, str2);
                                    com.tencent.mm.bb.d.b(this.vVM.uSU.uTo, "profile", ".ui.ContactInfoUI", r1);
                                    return;
                                }
                                return;
                            }
                            Intent intent2 = new Intent();
                            intent2.putExtra("Contact_User", Cj.ttp.tZr);
                            intent2.putExtra("Contact_Alias", Cj.hAI);
                            intent2.putExtra("Contact_Nick", Cj.tLj.tZr);
                            intent2.putExtra("Contact_Signature", Cj.hAG);
                            intent2.putExtra("Contact_RegionCode", RegionCodeDecoder.ab(Cj.hAM, Cj.hAE, Cj.hAF));
                            intent2.putExtra("Contact_Sex", Cj.hAD);
                            intent2.putExtra("Contact_VUser_Info", Cj.tMQ);
                            intent2.putExtra("Contact_VUser_Info_Flag", Cj.tMP);
                            intent2.putExtra("Contact_KWeibo_flag", Cj.tMT);
                            intent2.putExtra("Contact_KWeibo", Cj.tMR);
                            intent2.putExtra("Contact_KWeiboNick", Cj.tMS);
                            intent2.putExtra("Contact_KSnsIFlag", Cj.tMV.hAO);
                            intent2.putExtra("Contact_KSnsBgId", Cj.tMV.hAQ);
                            intent2.putExtra("Contact_KSnsBgUrl", Cj.tMV.hAP);
                            if (Cj.tMW != null) {
                                try {
                                    intent2.putExtra("Contact_customInfo", Cj.tMW.toByteArray());
                                } catch (Throwable e) {
                                    w.printErrStackTrace("MicroMsg.AddressUI", e, "", new Object[0]);
                                }
                            }
                            if ((Cj.tMP & 8) > 0) {
                                com.tencent.mm.plugin.report.service.g.oUh.A(10298, str2 + ",3");
                            }
                            com.tencent.mm.bb.d.b(this.vVM.uSU.uTo, "profile", ".ui.ContactInfoUI", intent2);
                        } else {
                            af kO = this.vVM.vVq.kO(headerViewsCount);
                            if (kO == null) {
                                w.e("MicroMsg.AddressUI", "on Contact ListView ItemClick, the item contact shoud not be null. count:%d, pos:%d ", Integer.valueOf(this.vVM.vVq.getCount()), Integer.valueOf(headerViewsCount));
                                return;
                            }
                            str = kO.field_username;
                            if (o.fu(str)) {
                                Intent intent3 = new Intent(this.vVM.uSU.uTo, AddressUI.class);
                                intent3.putExtra("Contact_GroupFilter_Type", "@biz.contact");
                                this.vVM.startActivity(intent3);
                                return;
                            }
                            r1 = new Intent();
                            r1.putExtra("Contact_User", str);
                            r1.putExtra("Contact_Scene", 3);
                            if (str != null && str.length() > 0) {
                                com.tencent.mm.bb.d.b(this.vVM.uSU.uTo, "profile", ".ui.ContactInfoUI", r1);
                            }
                        }
                    }
                }
            });
            this.mZO.setOnItemLongClickListener(new OnItemLongClickListener(this) {
                final /* synthetic */ a vVM;

                {
                    this.vVM = r1;
                }

                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    w.i("MicroMsg.AddressUI", "onItemLongClick, targetview is SearchBar::ListView, pos = " + i);
                    if (i < this.vVM.mZO.getHeaderViewsCount()) {
                        w.w("MicroMsg.AddressUI", "on item long click, but match header view");
                        return true;
                    } else if (this.vVM.vVq != null && this.vVM.vVq.wsb) {
                        return true;
                    } else {
                        com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) this.vVM.vVp.yQ(i - this.vVM.mZO.getHeaderViewsCount());
                        if (fVar == null) {
                            w.e("MicroMsg.AddressUI", "cont is null. position:%d, header count:%d", Integer.valueOf(i), Integer.valueOf(this.vVM.mZO.getHeaderViewsCount()));
                            return true;
                        }
                        String str = fVar.field_username;
                        if (o.fu(str) || o.fv(str)) {
                            return true;
                        }
                        this.vVM.vVs = str;
                        this.vVM.kaU.a(view, i, j, this.vVM, this.vVM.lmm, this.vVM.kaQ, this.vVM.kaR);
                        return true;
                    }
                }
            });
            this.mZO.setOnTouchListener(new OnTouchListener(this) {
                final /* synthetic */ a vVM;

                {
                    this.vVM = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    switch (motionEvent.getAction()) {
                        case 0:
                            this.vVM.are();
                            this.vVM.kaQ = (int) motionEvent.getRawX();
                            this.vVM.kaR = (int) motionEvent.getRawY();
                            break;
                    }
                    return false;
                }
            });
            this.mZO.setOnScrollListener(this.ktu);
            this.mZO.setDrawingCacheEnabled(false);
            this.vVu = (AlphabetScrollBar) findViewById(R.h.bnG);
            this.vVu.vpW = this.vVJ;
            ap.yY();
            c.wR().a(this.vVp);
            if (this.vVE != null) {
                com.tencent.mm.modelbiz.w.DH().a(this.vVE, null);
            }
        }

        protected final void bOm() {
            w.v("MicroMsg.AddressUI", "address ui on resume");
            long currentTimeMillis = System.currentTimeMillis();
            ap.yY();
            if (currentTimeMillis - u.d((Long) c.vr().get(340226, null)) >= 180000) {
                bXM();
            }
            if (this.vVG) {
                this.vVG = false;
                this.vVF = false;
                bXK();
                this.mZO.setAdapter(this.vVp);
                this.mZO.post(new Runnable(this) {
                    final /* synthetic */ a vVM;

                    {
                        this.vVM = r1;
                    }

                    public final void run() {
                        w.i("MicroMsg.AddressUI", "post to first init finish");
                        View findViewById = this.vVM.findViewById(R.h.cbT);
                        if (findViewById != null) {
                            findViewById.setVisibility(8);
                            findViewById.startAnimation(AnimationUtils.loadAnimation(this.vVM.uSU.uTo, R.a.aQY));
                        }
                    }
                });
                this.vVq.lP(false);
            } else if (this.vVF) {
                this.vVF = false;
                com.tencent.mm.sdk.f.e.b(new Runnable(this) {
                    final /* synthetic */ a vVM;

                    {
                        this.vVM = r1;
                    }

                    public final void run() {
                        Process.setThreadPriority(10);
                        this.vVM.bXL();
                    }
                }, "AddressUI_updateUIData", 4);
                this.vVD.bXO();
            }
            if (this.vVz != null) {
                BizContactEntranceView bizContactEntranceView = this.vVz;
                bizContactEntranceView.bXN();
                bizContactEntranceView.setVisible(true);
            }
            if (this.vVE != null) {
                if (this.vVE.bXV() <= 0) {
                    this.vVE.setVisibility(8);
                } else {
                    this.vVE.setVisibility(0);
                }
            }
            ap.yY();
            this.vVw = ((Boolean) c.vr().get(12296, Boolean.valueOf(false))).booleanValue();
            if (this.vVt == 2) {
                ap.yY();
                af Rc = c.wR().Rc(m.xL());
                if (!(Rc == null || (com.tencent.mm.j.a.ez(Rc.field_type) && u.mA(Rc.field_conRemark) && u.mA(Rc.field_conRemarkPYFull) && u.mA(Rc.field_conRemarkPYShort)))) {
                    Rc.tc();
                    Rc.bP("");
                    Rc.bV("");
                    Rc.bW("");
                    ap.yY();
                    c.wR().a(m.xL(), Rc);
                }
            }
            if (this.vVq != null) {
                this.vVq.onResume();
            }
            this.vVp.uOL = false;
            com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                final /* synthetic */ a vVM;

                {
                    this.vVM = r1;
                }

                public final void run() {
                    com.tencent.mm.ui.e eVar = this.vVM.vVp;
                    w.i(eVar.TAG, "newcursor resume ");
                    eVar.uOF = true;
                    eVar.aR("resume", true);
                }
            });
            if (this.vVy != null) {
                this.vVy.vXK = true;
                k.bXX();
            }
            LauncherUI launcherUI = (LauncherUI) this.uSU.uTo;
            if (launcherUI != null) {
                launcherUI.uRM.Y(this.vVL);
            }
        }

        public final synchronized void bXL() {
            long currentTimeMillis = System.currentTimeMillis();
            bXK();
            w.i("MicroMsg.AddressUI", "KEVIN updateBlockList() LAST" + (System.currentTimeMillis() - currentTimeMillis));
            currentTimeMillis = System.currentTimeMillis();
            if (this.vVp != null) {
                w.v("MicroMsg.AddressUI", "post to do refresh");
                com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                    final /* synthetic */ a vVM;

                    {
                        this.vVM = r1;
                    }

                    public final void run() {
                        this.vVM.vVp.bXJ();
                    }
                });
            }
            if (this.vVq != null) {
                com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                    final /* synthetic */ a vVM;

                    {
                        this.vVM = r1;
                    }

                    public final void run() {
                        w.v("MicroMsg.AddressUI", "post search adapter to do refresh");
                        this.vVM.vVq.a(null, null);
                    }
                });
            }
            w.i("MicroMsg.AddressUI", "KEVIN doRefresh() LAST" + (System.currentTimeMillis() - currentTimeMillis));
        }

        protected final void bOn() {
        }

        protected final void bOo() {
            w.i("MicroMsg.AddressUI", "AddressUI on Pause");
            ap.yY();
            c.vr().set(340226, Long.valueOf(System.currentTimeMillis()));
            ap.yY();
            c.vr().set(12296, Boolean.valueOf(this.vVw));
            if (this.vVq != null) {
                this.vVq.onPause();
            }
            this.vVp.bXI();
            com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                final /* synthetic */ a vVM;

                {
                    this.vVM = r1;
                }

                public final void run() {
                    this.vVM.vVp.pause();
                }
            });
            if (this.vVy != null) {
                this.vVy.vXK = false;
            }
            LauncherUI launcherUI = (LauncherUI) this.uSU.uTo;
            if (launcherUI != null) {
                launcherUI.uRM.Z(this.vVL);
            }
        }

        protected final void bOp() {
        }

        protected final void bOq() {
            w.v("MicroMsg.AddressUI", "onDestory");
            if (this.vVu != null) {
                this.vVu.vpW = null;
            }
            ap.vd().b(138, (e) this);
            if (this.vVp != null) {
                this.vVp.kh(true);
                a aVar = this.vVp;
                if (aVar.hBe != null) {
                    aVar.hBe.detach();
                    aVar.hBe = null;
                }
                this.vVp.bOL();
            }
            if (this.vVq != null) {
                this.vVq.detach();
                this.vVq.aEW();
            }
            if (ap.zb() && this.vVp != null) {
                ap.yY();
                c.wR().b(this.vVp);
            }
            if (ap.zb() && this.vVE != null) {
                com.tencent.mm.modelbiz.w.DH().a(this.vVE);
            }
            if (this.vVy != null) {
                k kVar = this.vVy;
                if (ap.zb()) {
                    l.Ky().f(kVar.vXJ);
                }
                this.vVy = null;
            }
            if (this.vVz != null) {
                this.vVz = null;
            }
            if (this.vVA != null) {
                this.vVA = null;
            }
            if (this.vVC != null) {
                this.vVC = null;
            }
        }

        public final void bOs() {
            if (this.vVp != null) {
                a aVar = this.vVp;
                aVar.vVg.clear();
                aVar.vVe.clear();
                aVar.vVf = false;
            }
            w.i("MicroMsg.INIT", "KEVIN Address turnTobg");
            if (this.vVz != null) {
                this.vVz.destroyDrawingCache();
            }
            if (this.vVA != null) {
                this.vVA.destroyDrawingCache();
            }
            if (this.vVC != null) {
                this.vVC.destroyDrawingCache();
            }
            if (this.vVD != null) {
                this.vVD.destroyDrawingCache();
            }
            if (this.vVy != null) {
                this.vVy.destroyDrawingCache();
            }
        }

        public final void bOt() {
            w.v("MicroMsg.INIT", "KEVIN Address turnTofg");
        }

        public final void bOr() {
            w.v("MicroMsg.AddressUI", "request to top");
            if (this.mZO != null) {
                BackwardSupportUtil.c.a(this.mZO);
            }
        }

        public final void bPh() {
            if (this.vVy != null) {
                k.bXX();
            }
        }

        public final void bXM() {
            if (this.mZO != null) {
                this.mZO.setSelection(0);
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        android.support.v4.app.l aR = aR();
        if (aR.E(16908290) == null) {
            this.vxO = new a();
            this.vxO.setArguments(getIntent().getExtras());
            aR.aV().a(16908290, this.vxO).commit();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
    }
}
