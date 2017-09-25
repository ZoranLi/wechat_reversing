package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.av.h;
import com.tencent.mm.av.i;
import com.tencent.mm.av.l;
import com.tencent.mm.e.a.j;
import com.tencent.mm.e.b.af;
import com.tencent.mm.i.g;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.nearby.a.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.k;
import com.tencent.mm.y.e;

public class NearbySayHiListUI extends MMActivity implements e {
    private int aIo = 0;
    private int gMU = 0;
    private p irJ = null;
    private ListView iss;
    private d jWo = new d(this) {
        final /* synthetic */ NearbySayHiListUI nWT;

        {
            this.nWT = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            l.Kz().lc(String.valueOf(this.nWT.nWR));
            this.nWT.nWN.a(null, null);
            if (this.nWT.nWO > 0) {
                this.nWT.nWO = this.nWT.nWO - 1;
            }
            NearbySayHiListUI.j(this.nWT);
        }
    };
    private c nVU;
    private i nWM = null;
    private a nWN;
    private int nWO = 0;
    private int nWP = 0;
    private boolean nWQ;
    private long nWR;
    private View nsQ;

    class a extends k<h> {
        int aIo = -1;
        private MMActivity fCi;
        protected f jVY;
        protected MMSlideDelView.c jVZ;
        protected MMSlideDelView.d jWb = MMSlideDelView.bSo();
        private i nWM;
        final /* synthetic */ NearbySayHiListUI nWT;
        protected MMSlideDelView.e nWW;

        class a {
            TextView hBj;
            ImageView ioV;
            View jWi;
            TextView jWj;
            final /* synthetic */ a nWX;
            TextView nxA;

            a(a aVar) {
                this.nWX = aVar;
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (h) obj;
            if (obj == null) {
                obj = new h();
            }
            obj.b(cursor);
            return obj;
        }

        public a(NearbySayHiListUI nearbySayHiListUI, Context context, i iVar, int i) {
            this.nWT = nearbySayHiListUI;
            super(context, new h());
            this.fCi = (MMActivity) context;
            this.aIo = i;
            this.nWM = iVar;
        }

        public final void a(f fVar) {
            this.jVY = fVar;
        }

        public final void a(MMSlideDelView.e eVar) {
            this.nWW = eVar;
        }

        public final void a(MMSlideDelView.c cVar) {
            this.jVZ = cVar;
        }

        protected final void OL() {
            OK();
        }

        public final void OK() {
            i iVar;
            if (com.tencent.mm.az.a.bCj()) {
                iVar = this.nWM;
                int i = this.aIo;
                setCursor(iVar.gUz.rawQuery("SELECT a.* FROM (" + ("SELECT sayhiencryptuser,max(createtime) createtime FROM " + iVar.getTableName() + " where isSend = 0 GROUP BY sayhiencryptuser LIMIT " + i) + ") b left join " + iVar.getTableName() + " a on b.sayhiencryptuser=a.sayhiencryptuser and b.createtime=a.createtime where a.isSend = 0 ORDER BY a.createtime desc LIMIT " + i, null));
            } else {
                iVar = this.nWM;
                setCursor(iVar.gUz.rawQuery("SELECT * FROM " + iVar.getTableName() + " where isSend = 0 ORDER BY createtime desc LIMIT " + this.aIo, null));
            }
            super.notifyDataSetChanged();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            CharSequence charSequence;
            h hVar = (h) getItem(i);
            if (view == null) {
                a aVar2 = new a(this);
                View view2 = (MMSlideDelView) View.inflate(this.fCi, R.i.cVu, null);
                View inflate = View.inflate(this.fCi, R.i.dmM, null);
                aVar2.ioV = (ImageView) inflate.findViewById(R.h.bGj);
                aVar2.hBj = (TextView) inflate.findViewById(R.h.bJC);
                aVar2.nxA = (TextView) inflate.findViewById(R.h.czJ);
                aVar2.jWi = view2.findViewById(R.h.cFy);
                aVar2.jWj = (TextView) view2.findViewById(R.h.cFz);
                view2.setView(inflate);
                view2.jVY = this.jVY;
                view2.jVZ = this.jVZ;
                view2.jWb = this.jWb;
                view2.lPM = false;
                view2.setTag(aVar2);
                view = view2;
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (hVar.field_flag != 0) {
                charSequence = au.d.RI(hVar.field_content).fFa;
            } else {
                charSequence = hVar.field_talker;
            }
            aVar.hBj.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.fCi, charSequence, aVar.hBj.getTextSize()));
            aVar.nxA.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.fCi, hVar.field_sayhicontent, aVar.nxA.getTextSize()));
            aVar.jWi.setTag(Long.valueOf(hVar.field_svrid));
            aVar.jWi.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a nWX;

                {
                    this.nWX = r1;
                }

                public final void onClick(View view) {
                    w.v("MicroMsg.SayHiAdapter", "on delView clicked");
                    this.nWX.jWb.aFi();
                    if (this.nWX.nWW != null) {
                        this.nWX.nWW.aQ(view.getTag());
                    }
                }
            });
            b.a(aVar.ioV, hVar.field_sayhiuser);
            return view;
        }
    }

    static /* synthetic */ void j(NearbySayHiListUI nearbySayHiListUI) {
        if (nearbySayHiListUI.nWO == 0) {
            TextView textView = (TextView) nearbySayHiListUI.findViewById(R.h.bLU);
            textView.setText(R.l.eOs);
            textView.setVisibility(0);
            nearbySayHiListUI.kr(false);
        }
    }

    public void onCreate(Bundle bundle) {
        int i;
        NearbySayHiListUI nearbySayHiListUI;
        super.onCreate(bundle);
        this.gMU = bg.PY(g.sV().getValue("ThresholdToCleanLocation"));
        this.nWQ = getIntent().getBooleanExtra("show_clear_header", false);
        this.nWM = l.Kz();
        zi(R.l.eOq);
        this.nWP = this.nWM.Kr();
        this.nWO = this.nWM.getCount();
        if (com.tencent.mm.az.a.bCj()) {
            i = this.nWO;
            nearbySayHiListUI = this;
        } else if (this.nWP == 0) {
            i = 8;
            nearbySayHiListUI = this;
        } else {
            i = this.nWP;
            nearbySayHiListUI = this;
        }
        nearbySayHiListUI.aIo = i;
        this.nWM.Kt();
        KC();
    }

    protected void onResume() {
        super.onResume();
        if (this.nWO != this.nWM.getCount()) {
            this.nWO = this.nWM.getCount();
            if (this.nWO == 0) {
                TextView textView = (TextView) findViewById(R.h.bLU);
                textView.setText(R.l.eOs);
                textView.setVisibility(0);
                kr(false);
            }
            this.nWN.OK();
        }
        this.nWN.notifyDataSetChanged();
        ap.vd().a(JsApiScanCode.CTRL_INDEX, this);
    }

    public void onDestroy() {
        this.nWN.aEW();
        super.onDestroy();
    }

    public void onPause() {
        ap.vd().b(JsApiScanCode.CTRL_INDEX, this);
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.dgK;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    protected final void KC() {
        this.iss = (ListView) findViewById(R.h.czH);
        if (!com.tencent.mm.az.a.bCj()) {
            final View inflate = getLayoutInflater().inflate(R.i.dmN, null);
            inflate.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NearbySayHiListUI nWT;

                public final void onClick(View view) {
                    this.nWT.aIo = this.nWT.aIo + 8;
                    w.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + this.nWT.aIo);
                    a b = this.nWT.nWN;
                    int a = this.nWT.aIo;
                    b.aEW();
                    b.aIo = a;
                    b.OK();
                    if (this.nWT.nWO <= this.nWT.aIo) {
                        this.nWT.iss.removeFooterView(inflate);
                        w.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + this.nWT.aIo);
                    }
                }
            });
            if (this.nWO > 0 && this.aIo < this.nWO) {
                this.iss.addFooterView(inflate);
            }
        }
        a(0, getString(R.l.dGt), new OnMenuItemClickListener(this) {
            final /* synthetic */ NearbySayHiListUI nWT;

            {
                this.nWT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.base.g.a(this.nWT.uSU.uTo, true, this.nWT.getResources().getString(R.l.eOp), "", this.nWT.getResources().getString(R.l.eOo), this.nWT.getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass5 nWU;

                    {
                        this.nWU = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.nWU.nWT.nWM.Ku();
                        this.nWU.nWT.nWN.OK();
                        TextView textView = (TextView) this.nWU.nWT.findViewById(R.h.bLU);
                        textView.setText(R.l.eOs);
                        textView.setVisibility(0);
                        this.nWU.nWT.kr(false);
                    }
                }, null);
                return true;
            }
        });
        if (this.nWO == 0) {
            TextView textView = (TextView) findViewById(R.h.bLU);
            textView.setText(R.l.eOs);
            textView.setVisibility(0);
            kr(false);
        }
        if (this.nWQ && this.gMU != 0 && this.nWP >= this.gMU && bg.Hp()) {
            this.nsQ = new CleanLocationHeaderView(this);
            this.nsQ.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ NearbySayHiListUI nWT;

                {
                    this.nWT = r1;
                }

                public final void onClick(View view) {
                    this.nWT.nVU = new c(2, 0.0f, 0.0f, 0, 0, "", "");
                    ap.vd().a(this.nWT.nVU, 0);
                    NearbySayHiListUI nearbySayHiListUI = this.nWT;
                    Context context = this.nWT.uSU.uTo;
                    this.nWT.getString(R.l.dIO);
                    nearbySayHiListUI.irJ = com.tencent.mm.ui.base.g.a(context, this.nWT.getString(R.l.eCN), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass6 nWV;

                        {
                            this.nWV = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            ap.vd().c(this.nWV.nWT.nVU);
                        }
                    });
                    com.tencent.mm.plugin.report.service.g.oUh.A(11429, "0");
                }
            });
            this.iss.addHeaderView(this.nsQ);
        }
        this.nWN = new a(this, this, this.nWM, this.aIo);
        this.nWN.a(new MMSlideDelView.c(this) {
            final /* synthetic */ NearbySayHiListUI nWT;

            {
                this.nWT = r1;
            }

            public final int cb(View view) {
                return this.nWT.iss.getPositionForView(view);
            }
        });
        this.nWN.a(new f(this) {
            final /* synthetic */ NearbySayHiListUI nWT;

            {
                this.nWT = r1;
            }

            public final void s(View view, int i) {
                this.nWT.iss.performItemClick(view, i, 0);
            }
        });
        this.nWN.a(new MMSlideDelView.e(this) {
            final /* synthetic */ NearbySayHiListUI nWT;

            {
                this.nWT = r1;
            }

            public final void aQ(Object obj) {
                if (obj == null) {
                    w.e("MicroMsg.SayHiListUI", "onItemDel object null");
                    return;
                }
                l.Kz().lc(obj.toString());
                this.nWT.nWN.a(null, null);
            }
        });
        this.iss.setAdapter(this.nWN);
        final com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this);
        this.iss.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ NearbySayHiListUI nWT;

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.nWT.iss.getHeaderViewsCount()) {
                    w.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
                } else {
                    lVar.a(view, i, j, this.nWT, this.nWT.jWo);
                }
                return true;
            }
        });
        this.iss.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ NearbySayHiListUI nWT;

            {
                this.nWT = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.nWT.iss.getHeaderViewsCount() > 0) {
                    i -= this.nWT.iss.getHeaderViewsCount();
                }
                h hVar = (h) this.nWT.nWN.getItem(i);
                if (hVar != null && hVar.field_content != null) {
                    au.d RI = au.d.RI(hVar.field_content);
                    Intent intent = new Intent();
                    if (com.tencent.mm.az.a.bCj()) {
                        intent.putExtra("Chat_User", hVar.field_sayhiencryptuser);
                        intent.putExtra("lbs_mode", true);
                        intent.putExtra("add_scene", 18);
                        com.tencent.mm.plugin.nearby.a.imv.e(intent, this.nWT);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("Contact_User", bg.mA(RI.rUK) ? hVar.field_sayhiuser : RI.rUK);
                        intent2.putExtra("Contact_Alias", RI.gtR);
                        intent2.putExtra("Contact_Nick", RI.fFa);
                        intent2.putExtra("Contact_QuanPin", RI.hCf);
                        intent2.putExtra("Contact_PyInitial", RI.hCe);
                        intent2.putExtra("Contact_Sex", RI.gkr);
                        intent2.putExtra("Contact_Signature", RI.signature);
                        intent2.putExtra("Contact_Scene", RI.scene);
                        intent2.putExtra("Contact_FMessageCard", true);
                        intent2.putExtra("Contact_City", RI.getCity());
                        intent2.putExtra("Contact_Province", RI.getProvince());
                        intent2.putExtra("Contact_Content", bg.mA(hVar.field_sayhicontent) ? this.nWT.getString(R.l.dTI) : hVar.field_sayhicontent);
                        intent2.putExtra("Contact_verify_Scene", RI.scene);
                        intent2.putExtra("Contact_Uin", RI.ovb);
                        intent2.putExtra("Contact_QQNick", RI.hCg);
                        intent2.putExtra("Contact_Mobile_MD5", RI.uJX);
                        intent2.putExtra("User_From_Fmessage", true);
                        intent2.putExtra("Contact_from_msgType", 37);
                        intent2.putExtra("Verify_ticket", RI.osP);
                        intent2.putExtra("Contact_Source_FMessage", RI.scene);
                        intent2.putExtra("Contact_ShowFMessageList", true);
                        ap.yY();
                        af Rc = com.tencent.mm.u.c.wR().Rc(RI.rUK);
                        if (!(Rc == null || ((int) Rc.gTQ) < 0 || com.tencent.mm.j.a.ez(Rc.field_type))) {
                            int i2 = RI.fJK;
                            if (i2 == 0 || i2 == 2 || i2 == 5) {
                                intent2.putExtra("User_Verify", true);
                            }
                            intent2.putExtra("Contact_IsLBSFriend", true);
                            intent2.putExtra("Sns_from_Scene", 18);
                        }
                        com.tencent.mm.plugin.nearby.a.imv.d(intent2, this.nWT);
                    }
                    com.tencent.mm.sdk.b.b jVar = new j();
                    jVar.fCx.scene = RI.scene;
                    com.tencent.mm.sdk.b.a.urY.m(jVar);
                }
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ NearbySayHiListUI nWT;

            {
                this.nWT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nWT.aHf();
                this.nWT.setResult(0);
                this.nWT.finish();
                return true;
            }
        });
        AnonymousClass2 anonymousClass2 = new OnClickListener(this) {
            final /* synthetic */ NearbySayHiListUI nWT;

            {
                this.nWT = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.nWT.iss);
            }
        };
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        h hVar = (h) this.nWN.getItem(adapterContextMenuInfo.position);
        if (hVar == null) {
            w.e("MicroMsg.SayHiListUI", "onItemLongClick, item is null, pos = " + adapterContextMenuInfo.position);
            return;
        }
        contextMenu.add(0, 0, 0, R.l.dGB);
        this.nWR = hVar.field_svrid;
    }

    public void onBackPressed() {
        setResult(0);
        super.onBackPressed();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        w.i("MicroMsg.SayHiListUI", "onSceneEnd: errType=%d, errCode=%d, errMsg=%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.irJ != null) {
            this.irJ.dismiss();
            this.irJ = null;
        }
        if (i != 0 || i2 != 0) {
            w.w("MicroMsg.SayHiListUI", "[cpan] clear location failed.");
        } else if (((c) kVar).AJ() == 2) {
            com.tencent.mm.ui.base.g.a(this.uSU.uTo, getString(R.l.eCM), "", new DialogInterface.OnClickListener(this) {
                final /* synthetic */ NearbySayHiListUI nWT;

                {
                    this.nWT = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.nWT.setResult(-1);
                    this.nWT.finish();
                }
            });
            this.nVU = null;
        }
    }
}
