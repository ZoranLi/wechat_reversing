package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.shake.b.e;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.k;
import com.tencent.mm.ui.tools.l;
import com.tenpay.android.wechat.PayuSecureEncrypt;

public class ShakeItemListUI extends MMActivity {
    private com.tencent.mm.ah.a.a hHR = null;
    private int id;
    private d jWo = new d(this) {
        final /* synthetic */ ShakeItemListUI prd;

        {
            this.prd = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            m.baS().sv(this.prd.id);
        }
    };
    private View jjN;
    private ListView nWh;
    public long pra = 0;
    private boolean prb = false;
    private a prc;
    private int showType;

    class a extends k<com.tencent.mm.plugin.shake.b.d> {
        b hBe = new b(new com.tencent.mm.ui.applet.b.a(this) {
            final /* synthetic */ a prg;

            {
                this.prg = r1;
            }

            public final Bitmap jf(String str) {
                return com.tencent.mm.x.b.a(str, false, -1);
            }
        });
        private b.b hBf = null;
        final /* synthetic */ ShakeItemListUI prd;
        private int showType = 0;

        class a {
            ImageView hBi;
            TextView hBj;
            TextView hBk;
            TextView nWD;
            TextView nWE;
            ImageView nWF;
            final /* synthetic */ a prg;
            View prh;
            ImageView pri;
            TextView prj;
            LinearLayout prk;
            TextView prl;

            a(a aVar) {
                this.prg = aVar;
            }

            public final void clear() {
                if (this.hBi != null) {
                    this.hBi.setImageDrawable(null);
                    this.hBi.setVisibility(8);
                }
                if (this.hBj != null) {
                    this.hBj.setText("");
                    this.hBj.setVisibility(8);
                }
                if (this.hBk != null) {
                    this.hBk.setVisibility(8);
                }
                if (this.pri != null) {
                    this.pri.setVisibility(8);
                }
                if (this.nWD != null) {
                    this.nWD.setText("");
                    this.nWD.setVisibility(8);
                }
                if (this.nWE != null) {
                    this.nWE.setVisibility(8);
                    this.prh.setVisibility(8);
                }
                if (this.nWF != null) {
                    this.nWF.setVisibility(8);
                }
                if (this.prj != null) {
                    this.prj.setText("");
                    this.prj.setVisibility(8);
                }
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (com.tencent.mm.plugin.shake.b.d) obj;
            if (obj == null) {
                obj = new com.tencent.mm.plugin.shake.b.d();
            }
            if (cursor != null) {
                obj.b(cursor);
            }
            return obj;
        }

        public a(ShakeItemListUI shakeItemListUI, ShakeItemListUI shakeItemListUI2) {
            this.prd = shakeItemListUI;
            super(shakeItemListUI2, new com.tencent.mm.plugin.shake.b.d());
            OL();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (this.hBf == null) {
                this.hBf = new b.b(this) {
                    final /* synthetic */ a prg;

                    {
                        this.prg = r1;
                    }

                    public final String fE(int i) {
                        if (i < 0 || i >= this.prg.getCount()) {
                            w.e("MicroMsg.ShakeFriendAdapter", "pos is invalid");
                            return null;
                        }
                        com.tencent.mm.plugin.shake.b.d dVar = (com.tencent.mm.plugin.shake.b.d) this.prg.getItem(i);
                        return dVar == null ? null : dVar.field_username;
                    }

                    public final int Fh() {
                        return this.prg.getCount();
                    }
                };
            }
            if (this.hBe != null) {
                this.hBe.a(i, this.hBf);
            }
            if (view == null) {
                aVar = new a(this);
                view = View.inflate(this.context, R.i.dol, null);
                aVar.hBi = (ImageView) view.findViewById(R.h.cmD);
                aVar.hBj = (TextView) view.findViewById(R.h.cmJ);
                aVar.hBk = (TextView) view.findViewById(R.h.cmG);
                aVar.pri = (ImageView) view.findViewById(R.h.cmL);
                aVar.nWD = (TextView) view.findViewById(R.h.cmE);
                aVar.nWE = (TextView) view.findViewById(R.h.cmM);
                aVar.nWF = (ImageView) view.findViewById(R.h.cmO);
                aVar.prj = (TextView) view.findViewById(R.h.cEq);
                aVar.prh = view.findViewById(R.h.cyW);
                aVar.prk = (LinearLayout) view.findViewById(R.h.cDE);
                aVar.prl = (TextView) view.findViewById(R.h.cDF);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            com.tencent.mm.plugin.shake.b.d dVar = (com.tencent.mm.plugin.shake.b.d) getItem(i);
            if (dVar != null) {
                aVar.clear();
                if (4 == dVar.field_type || (com.tencent.mm.plugin.shake.d.a.k.sA(dVar.field_type) && 6 != dVar.field_type)) {
                    if (4 != dVar.field_type) {
                        aVar.hBi.setScaleType(ScaleType.CENTER_CROP);
                    }
                    e.a(aVar.hBi, dVar.field_sns_bgurl, R.k.dtu, false);
                } else if (11 == dVar.field_type) {
                    this.prd.hHR.a(dVar.getProvince(), aVar.hBi);
                } else {
                    com.tencent.mm.pluginsdk.ui.a.b.a(aVar.hBi, dVar.field_username);
                }
                aVar.hBi.setVisibility(0);
                if (7 != dVar.field_type && 10 != dVar.field_type && 12 != dVar.field_type && 13 != dVar.field_type && (8 != dVar.field_type || !bg.mA(dVar.field_nickname) || !bg.mA(dVar.field_username))) {
                    aVar.prl.setVisibility(8);
                    aVar.prk.setVisibility(0);
                    if (8 == dVar.field_type && bg.mA(dVar.field_nickname)) {
                        dVar.field_nickname = dVar.field_distance;
                        dVar.field_distance = dVar.field_username;
                    }
                    aVar.hBj.setText(h.b(this.context, bg.mz(dVar.field_nickname), aVar.hBj.getTextSize()));
                    aVar.hBj.setVisibility(0);
                    int paddingBottom = view.getPaddingBottom();
                    int paddingTop = view.getPaddingTop();
                    int paddingRight = view.getPaddingRight();
                    int paddingLeft = view.getPaddingLeft();
                    if (dVar.field_insertBatch == 2) {
                        view.setBackgroundDrawable(com.tencent.mm.bg.a.a(this.context, R.g.ben));
                    } else {
                        view.setBackgroundDrawable(com.tencent.mm.bg.a.a(this.context, R.g.beo));
                    }
                    view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    switch (dVar.field_type) {
                        case 1:
                        case 2:
                        case 3:
                            aVar.prj.setText(dVar.field_nickname);
                            aVar.prj.setVisibility(0);
                            break;
                        default:
                            aVar.prh.setVisibility(0);
                            aVar.nWD.setText(dVar.field_distance);
                            aVar.nWD.setVisibility(0);
                            if (dVar.field_signature == null || dVar.field_signature.trim().equals("")) {
                                aVar.nWE.setVisibility(8);
                            } else {
                                aVar.nWE.setVisibility(0);
                                aVar.nWE.setText(h.b(this.context, dVar.field_signature, aVar.hBj.getTextSize()));
                            }
                            if (dVar.field_sex == 1) {
                                aVar.pri.setVisibility(0);
                                aVar.pri.setImageDrawable(com.tencent.mm.bg.a.a(this.context, R.k.dxs));
                                aVar.pri.setContentDescription(this.context.getString(R.l.ezq));
                            } else if (dVar.field_sex == 2) {
                                aVar.pri.setVisibility(0);
                                aVar.pri.setImageDrawable(com.tencent.mm.bg.a.a(this.context, R.k.dxr));
                                aVar.pri.setContentDescription(this.context.getString(R.l.ejV));
                            } else {
                                aVar.pri.setVisibility(8);
                            }
                            ap.yY();
                            af Rc = c.wR().Rc(dVar.field_username);
                            if (Rc == null || !com.tencent.mm.j.a.ez(Rc.field_type)) {
                                aVar.hBk.setVisibility(8);
                            } else {
                                aVar.hBk.setVisibility(0);
                                if (x.yC(dVar.field_reserved1)) {
                                    aVar.hBk.setText(this.context.getString(R.l.eCQ));
                                } else {
                                    aVar.hBk.setText(this.context.getString(R.l.eCS));
                                }
                            }
                            if (6 == dVar.field_type) {
                                aVar.nWD.setText(this.context.getString(R.l.eVk));
                                aVar.hBk.setVisibility(8);
                            }
                            if (dVar.field_reserved1 == 0) {
                                aVar.nWF.setVisibility(8);
                                break;
                            }
                            aVar.nWF.setVisibility(0);
                            aVar.nWF.setImageBitmap(BackwardSupportUtil.b.c(com.tencent.mm.u.ag.a.hlU.eY(dVar.field_reserved1), 2.0f));
                            aVar.pri.setVisibility(8);
                            break;
                            break;
                    }
                }
                if (8 == dVar.field_type) {
                    aVar.prl.setText(dVar.field_distance);
                } else {
                    aVar.prl.setText(dVar.field_nickname);
                }
                aVar.prl.setVisibility(0);
                aVar.prk.setVisibility(8);
            } else {
                aVar.clear();
            }
            return view;
        }

        protected final void OL() {
            aEW();
            OK();
        }

        public final void OK() {
            if (ap.zb()) {
                switch (this.showType) {
                    case -12:
                        e baS = m.baS();
                        int intExtra = this.prd.getIntent().getIntExtra("_ibeacon_new_insert_size", 2);
                        setCursor(baS.rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc limit ? ", new String[]{"11", String.valueOf(intExtra)}));
                        break;
                    case -6:
                        setCursor(m.baS().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", new String[]{"8", "2"}));
                        break;
                    case -5:
                        setCursor(m.baS().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", new String[]{"4", "2"}));
                        break;
                    case -1:
                        setCursor(m.baS().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by reserved2 desc, shakeItemID desc ", new String[]{"0", "2"}));
                        break;
                    case 0:
                        setCursor(m.baS().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", new String[]{"0"}));
                        break;
                    case 4:
                        setCursor(m.baS().baH());
                        break;
                    case 5:
                        setCursor(m.baS().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type in (?, ?, ?, ?, ?) order by shakeItemID desc ", new String[]{"7", "6", "8", "9", PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT, "12"}));
                        break;
                    case 11:
                        setCursor(m.baS().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", new String[]{"11"}));
                        break;
                    case 100:
                        setCursor(m.baS().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   order by shakeItemID desc ", new String[0]));
                        break;
                }
                super.notifyDataSetChanged();
            }
        }

        protected final void sC(int i) {
            this.showType = i;
            OL();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        m.baS().c(this.prc);
        this.prc.OL();
        w.i("MicroMsg.ShakeItemListUI", "onResume");
    }

    protected final void KC() {
        this.hHR = new com.tencent.mm.ah.a.a(this);
        ap.yY();
        final int a = bg.a((Integer) c.vr().get(12290, null), 0);
        this.showType = getIntent().getIntExtra("_key_show_type_", 0);
        String stringExtra = getIntent().getStringExtra("_key_title_");
        if (!bg.mA(stringExtra)) {
            qP(stringExtra);
        }
        this.prb = getIntent().getBooleanExtra("_key_show_from_shake_", false);
        a(0, getString(R.l.dGt), new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakeItemListUI prd;

            {
                this.prd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                g.a(this.prd, true, this.prd.getString(R.l.eOp), "", this.prd.getString(R.l.dGt), this.prd.getString(R.l.dGs), new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 pre;

                    {
                        this.pre = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        switch (this.pre.prd.showType) {
                            case -12:
                            case 11:
                                m.baS().sw(11);
                                break;
                            case -6:
                            case 5:
                                m.baS().sw(7);
                                m.baS().sw(6);
                                m.baS().sw(8);
                                m.baS().sw(9);
                                m.baS().sw(10);
                                m.baS().sw(12);
                                break;
                            case -5:
                            case 4:
                                ap.vL().D(new com.tencent.mm.plugin.shake.d.a.i.1());
                                m.baS().sw(4);
                                break;
                            case -1:
                            case 0:
                                m.baS().sw(0);
                                break;
                            case 100:
                                m.baS().sw(0);
                                m.baS().baJ();
                                break;
                        }
                        this.pre.prd.prc.OK();
                        this.pre.prd.nWh.setVisibility(8);
                        TextView textView = (TextView) this.pre.prd.findViewById(R.h.cmK);
                        textView.setText(ShakeItemListUI.sD(this.pre.prd.showType));
                        textView.setVisibility(0);
                        this.pre.prd.kr(false);
                    }
                }, null);
                return true;
            }
        });
        this.nWh = (ListView) findViewById(R.h.cmI);
        this.jjN = getLayoutInflater().inflate(R.i.dom, null);
        this.jjN.findViewById(R.h.cDC).setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ ShakeItemListUI prd;

            {
                this.prd = r1;
            }

            public final void onClick(View view) {
                this.prd.showType = this.prd.showType ^ -1;
                this.prd.sC(this.prd.showType);
            }
        });
        this.nWh.addFooterView(this.jjN);
        if (this.showType == -1) {
            this.jjN.findViewById(R.h.cDC).setVisibility(0);
        } else {
            this.jjN.findViewById(R.h.cDC).setVisibility(8);
        }
        this.prc = new a(this, this);
        this.prc.sC(this.showType);
        if (this.prc.getCount() <= 0) {
            this.nWh.setVisibility(8);
            TextView textView = (TextView) findViewById(R.h.cmK);
            textView.setText(sD(this.showType));
            textView.setVisibility(0);
            kr(false);
        } else {
            this.nWh.setAdapter(this.prc);
            this.nWh.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ ShakeItemListUI prd;

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    com.tencent.mm.plugin.shake.b.d dVar = (com.tencent.mm.plugin.shake.b.d) this.prd.prc.getItem(i);
                    if (dVar != null) {
                        e baS = m.baS();
                        if (dVar == null) {
                            w.w("MicroMsg.NewShakeItemStorage", "setRead, but item is null");
                        } else {
                            dVar.field_insertBatch = 1;
                            dVar.fRW = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                            if (-1 != baS.gUz.update("shakeitem1", dVar.pv(), "shakeItemID=? and insertBatch=?", new String[]{dVar.field_shakeItemID, "2"})) {
                                baS.doNotify();
                            }
                        }
                        int i2 = dVar.field_type;
                        Intent intent;
                        if (i2 == 4) {
                            intent = new Intent();
                            if (com.tencent.mm.am.c.HS()) {
                                com.tencent.mm.am.b.b(i.a(dVar.field_lvbuffer, 0));
                            } else {
                                com.tencent.mm.am.b.HH();
                                intent.putExtra("key_mode", 1);
                                intent.putExtra("KGlobalShakeMusic", true);
                                com.tencent.mm.am.b.c(i.a(dVar.field_lvbuffer, 0));
                            }
                            intent.putExtra("key_scene", 3);
                            com.tencent.mm.bb.d.b(this.prd, "music", ".ui.MusicMainUI", intent);
                        } else if (i2 == 11) {
                            if (System.currentTimeMillis() - this.prd.pra > 2000) {
                                this.prd.pra = System.currentTimeMillis();
                                intent = new Intent();
                                intent.putExtra("rawUrl", dVar.getCity());
                                intent.putExtra("scene", 27);
                                intent.putExtra("stastic_scene", 5);
                                com.tencent.mm.bb.d.b(ab.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                if (this.prd.prb) {
                                    com.tencent.mm.plugin.shake.d.a.h.a(dVar);
                                    com.tencent.mm.plugin.shake.d.a.h.b(dVar);
                                }
                            }
                        } else if (com.tencent.mm.plugin.shake.d.a.k.sA(i2)) {
                            com.tencent.mm.plugin.shake.d.a.k.a(dVar, this.prd, true);
                        } else {
                            String str = dVar.field_username;
                            ap.yY();
                            af Rc = c.wR().Rc(str);
                            w.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + str + " display:" + dVar.field_nickname + " position:" + i + " contactName" + Rc.field_username);
                            w.d("MicroMsg.ShakeItemListUI", "isContact:" + com.tencent.mm.j.a.ez(Rc.field_type) + "  contact:" + Rc);
                            if (com.tencent.mm.j.a.ez(Rc.field_type)) {
                                Intent intent2 = new Intent();
                                intent2.putExtra("Contact_User", str);
                                intent2.putExtra("Contact_Scene", a == dVar.field_sex ? 23 : 24);
                                intent2.putExtra("Sns_from_Scene", 22);
                                if (str != null && str.length() > 0) {
                                    if (Rc.bLe()) {
                                        com.tencent.mm.plugin.report.service.g.oUh.A(10298, dVar.field_username + "," + intent2.getIntExtra("Contact_Scene", 23));
                                        intent2.putExtra("Contact_Scene", 23);
                                    }
                                    com.tencent.mm.plugin.shake.a.imv.d(intent2, this.prd);
                                    return;
                                }
                                return;
                            }
                            w.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + str + " display:" + dVar.field_nickname + " position:" + i + " contactName" + Rc.field_username);
                            Intent intent3 = new Intent();
                            intent3.putExtra("Contact_User", dVar.field_username);
                            intent3.putExtra("Contact_Nick", dVar.field_nickname);
                            intent3.putExtra("Contact_Distance", dVar.field_distance);
                            intent3.putExtra("Contact_Signature", dVar.field_signature);
                            intent3.putExtra("Contact_Province", dVar.getProvince());
                            intent3.putExtra("Contact_City", dVar.getCity());
                            intent3.putExtra("Contact_Sex", dVar.field_sex);
                            intent3.putExtra("Contact_IsLBSFriend", true);
                            intent3.putExtra("Contact_VUser_Info", dVar.field_reserved3);
                            intent3.putExtra("Contact_VUser_Info_Flag", dVar.field_reserved1);
                            intent3.putExtra("Contact_Scene", a == dVar.field_sex ? 23 : 24);
                            intent3.putExtra("Sns_from_Scene", 22);
                            intent3.putExtra("Contact_KSnsIFlag", dVar.field_snsFlag);
                            intent3.putExtra("Contact_KSnsBgUrl", dVar.field_sns_bgurl);
                            if ((dVar.field_reserved1 & 8) > 0) {
                                com.tencent.mm.plugin.report.service.g.oUh.A(10298, dVar.field_username + "," + intent3.getIntExtra("Contact_Scene", 23));
                            }
                            com.tencent.mm.plugin.shake.a.imv.d(intent3, this.prd);
                        }
                    }
                }
            });
            final l lVar = new l(this);
            this.nWh.setOnItemLongClickListener(new OnItemLongClickListener(this) {
                final /* synthetic */ ShakeItemListUI prd;

                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i < this.prd.nWh.getHeaderViewsCount()) {
                        w.w("MicroMsg.ShakeItemListUI", "on header view long click, ignore");
                    } else {
                        lVar.a(view, i, j, this.prd, this.prd.jWo);
                    }
                    return true;
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakeItemListUI prd;

            {
                this.prd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.prd.aHf();
                this.prd.finish();
                return true;
            }
        });
        AnonymousClass6 anonymousClass6 = new View.OnClickListener(this) {
            final /* synthetic */ ShakeItemListUI prd;

            {
                this.prd = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.prd.nWh);
            }
        };
        this.nWh.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ShakeItemListUI prd;

            {
                this.prd = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.prd.prc != null) {
                    a b = this.prd.prc;
                    if (b.hBe != null) {
                        b.hBe.onTouchEvent(motionEvent);
                    }
                }
                return false;
            }
        });
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.id = ((com.tencent.mm.plugin.shake.b.d) this.prc.getItem(adapterContextMenuInfo.position)).field_shakeItemID;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.dGB);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        this.prc.aEW();
        a aVar = this.prc;
        if (aVar.hBe != null) {
            aVar.hBe.detach();
            aVar.hBe = null;
        }
        m.baS().f(this.prc);
        w.i("MicroMsg.ShakeItemListUI", "onPause");
        if (this.hHR != null) {
            this.hHR.detach();
        }
        super.onDestroy();
    }

    protected final void sC(int i) {
        this.prc.sC(i);
        switch (i) {
            case -12:
            case -1:
                if (this.jjN != null) {
                    this.jjN.findViewById(R.h.cDC).setVisibility(0);
                    return;
                }
                return;
            case 0:
            case 11:
                if (this.jjN != null) {
                    this.jjN.findViewById(R.h.cDC).setVisibility(8);
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return R.i.dok;
    }

    public static int sD(int i) {
        switch (i) {
            case -12:
            case 11:
                return R.l.eVo;
            case -6:
            case 5:
                return R.l.eVX;
            case -5:
            case 4:
                return R.l.eVF;
            case -1:
            case 0:
                return R.l.eVi;
            case 100:
                return R.l.eVl;
            default:
                return R.l.eVi;
        }
    }
}
