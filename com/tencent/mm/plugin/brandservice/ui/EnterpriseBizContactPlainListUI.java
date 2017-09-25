package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.d;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.k;
import com.tencent.wcdb.FileUtils;
import java.util.HashMap;

public class EnterpriseBizContactPlainListUI extends MMActivity {
    private String huj;
    private ListView kaM;
    private a kbb;
    private long kbc;
    private OnItemClickListener kbd;
    private int scene;

    class a extends k<b> implements m.b {
        com.tencent.mm.ui.applet.b hBe = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a(this) {
            final /* synthetic */ a kbh;

            {
                this.kbh = r1;
            }

            public final Bitmap jf(String str) {
                return com.tencent.mm.x.b.a(str, false, -1);
            }
        });
        private com.tencent.mm.ui.applet.b.b hBf = null;
        final /* synthetic */ EnterpriseBizContactPlainListUI kbe;

        class a {
            ImageView hBi;
            TextView hBj;
            final /* synthetic */ a kbh;

            a(a aVar) {
                this.kbh = aVar;
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
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (b) obj;
            if (obj == null) {
                w.e("MicroMsg.EnterpriseBizListAdapter", "item == null");
                obj = new b();
            }
            if (cursor != null) {
                af xVar = new x();
                xVar.b(cursor);
                BizInfo bizInfo = new BizInfo();
                bizInfo.b(cursor);
                obj.userName = xVar.field_username;
                obj.jiL = xVar;
                obj.jZc = bizInfo;
                w.d("MicroMsg.EnterpriseBizListAdapter", "convertFrom userName = %s", new Object[]{obj.userName});
            }
            return obj;
        }

        public a(EnterpriseBizContactPlainListUI enterpriseBizContactPlainListUI, Context context) {
            this.kbe = enterpriseBizContactPlainListUI;
            super(context, new b());
            OK();
        }

        public final void a(String str, l lVar) {
            w.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange");
            com.tencent.mm.sdk.platformtools.af.v(new Runnable(this) {
                final /* synthetic */ a kbh;

                {
                    this.kbh = r1;
                }

                public final void run() {
                    this.kbh.OL();
                    TextView textView = (TextView) this.kbh.kbe.findViewById(R.h.bMn);
                    if (!(this.kbh.kbe.kaM == null || textView == null)) {
                        ap.yY();
                        af Rc = c.wR().Rc(this.kbh.kbe.huj);
                        if (Rc == null || !com.tencent.mm.j.a.ez(Rc.field_type)) {
                            this.kbh.kbe.kaM.setVisibility(8);
                            textView.setVisibility(0);
                        } else if (this.kbh.kbe.kbb.getCount() <= 0) {
                            this.kbh.kbe.kaM.setVisibility(8);
                            textView.setVisibility(0);
                        } else {
                            this.kbh.kbe.kaM.setVisibility(0);
                            textView.setVisibility(8);
                            this.kbh.kbe.kaM.setAdapter(this.kbh.kbe.kbb);
                            this.kbh.kbe.kaM.setOnItemClickListener(this.kbh.kbe.kbd);
                        }
                    }
                    this.kbh.notifyDataSetChanged();
                }
            });
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (this.hBf == null) {
                this.hBf = new com.tencent.mm.ui.applet.b.b(this) {
                    final /* synthetic */ a kbh;

                    {
                        this.kbh = r1;
                    }

                    public final String fE(int i) {
                        if (i < 0 || i >= this.kbh.getCount()) {
                            w.e("MicroMsg.EnterpriseBizListAdapter", "pos is invalid");
                            return null;
                        }
                        b bVar = (b) this.kbh.getItem(i);
                        return bVar == null ? null : bVar.userName;
                    }

                    public final int Fh() {
                        return this.kbh.getCount();
                    }
                };
            }
            if (this.hBe != null) {
                this.hBe.a(i, this.hBf);
            }
            if (view == null) {
                aVar = new a(this);
                view = View.inflate(this.context, R.i.dbb, null);
                aVar.hBi = (ImageView) view.findViewById(R.h.cmD);
                aVar.hBj = (TextView) view.findViewById(R.h.cmJ);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            b bVar = (b) getItem(i);
            if (bVar == null) {
                aVar.clear();
            } else {
                aVar.clear();
                int paddingBottom = view.getPaddingBottom();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingLeft = view.getPaddingLeft();
                view.setBackgroundDrawable(com.tencent.mm.bg.a.a(this.context, R.g.beo));
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                aVar.hBj.setText(h.b(this.context, bg.mz(bVar.jiL.tK()), aVar.hBj.getTextSize()));
                aVar.hBj.setVisibility(0);
                aVar.hBi.setVisibility(0);
                if (bg.mA(bVar.jiL.field_username)) {
                    aVar.hBi.setImageDrawable(null);
                } else {
                    com.tencent.mm.pluginsdk.ui.a.b.a(aVar.hBi, bVar.jiL.field_username);
                }
            }
            return view;
        }

        protected final void OL() {
            OK();
        }

        public final void OK() {
            Cursor cursor = null;
            if (ap.zb()) {
                aEW();
                switch (this.kbe.scene) {
                    case 1:
                        com.tencent.mm.modelbiz.w.DH();
                        cursor = d.v(this.kbe.huj, 25);
                        break;
                    case 2:
                        com.tencent.mm.modelbiz.w.DH();
                        String c = this.kbe.huj;
                        StringBuilder stringBuilder = new StringBuilder();
                        d.b(stringBuilder);
                        d.c(stringBuilder);
                        d.a(stringBuilder, c);
                        d.b(stringBuilder, false);
                        d.a(stringBuilder, false);
                        stringBuilder.append(" order by ");
                        stringBuilder.append(d.Dl());
                        w.i("MicroMsg.BizInfoStorage", "getEnterpriseDisableChild sql %s", new Object[]{stringBuilder.toString()});
                        cursor = com.tencent.mm.kernel.h.vI().gYg.a(c, null, 0);
                        break;
                    case 3:
                        com.tencent.mm.modelbiz.w.DH();
                        cursor = d.v(this.kbe.huj, FileUtils.S_IWUSR);
                        break;
                    case 4:
                        BizInfo hW = e.hW(this.kbe.huj);
                        if (!(hW == null || hW.field_enterpriseFather == null)) {
                            cursor = com.tencent.mm.modelbiz.w.DH().hQ(hW.field_enterpriseFather);
                            break;
                        }
                    default:
                        com.tencent.mm.modelbiz.w.DH();
                        cursor = d.t(this.kbe.huj, true);
                        break;
                }
                setCursor(cursor);
                return;
            }
            w.e("MicroMsg.EnterpriseBizListAdapter", "accHasReady");
        }
    }

    static /* synthetic */ void a(EnterpriseBizContactPlainListUI enterpriseBizContactPlainListUI, int i) {
        final b bVar = (b) enterpriseBizContactPlainListUI.kbb.getItem(i);
        if (bVar == null || bVar.userName == null) {
            w.e("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "item is null.");
        } else if (enterpriseBizContactPlainListUI.scene == 1) {
            com.tencent.mm.pluginsdk.ui.applet.d.b(enterpriseBizContactPlainListUI.uSU, bVar.userName, enterpriseBizContactPlainListUI.getString(R.l.eLK), n.eJ(bVar.userName), null, enterpriseBizContactPlainListUI.getString(R.l.dIA), new com.tencent.mm.pluginsdk.ui.applet.k.a(enterpriseBizContactPlainListUI) {
                final /* synthetic */ EnterpriseBizContactPlainListUI kbe;

                public final void a(boolean z, String str, int i) {
                    if (z) {
                        Intent intent = this.kbe.getIntent();
                        intent.putExtra("enterprise_biz_name", bVar.userName);
                        this.kbe.setResult(-1, intent);
                        this.kbe.finish();
                    }
                }
            });
        } else if (enterpriseBizContactPlainListUI.scene == 2) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", bVar.userName);
            com.tencent.mm.plugin.brandservice.a.imv.d(intent, enterpriseBizContactPlainListUI);
        } else if (enterpriseBizContactPlainListUI.scene == 3) {
            HashMap hashMap = (HashMap) enterpriseBizContactPlainListUI.getIntent().getSerializableExtra("enterprise_extra_params");
            String str = (String) hashMap.get("img_url");
            String str2 = (String) hashMap.get("desc");
            String str3 = (String) hashMap.get("title");
            final String str4 = bVar.userName;
            com.tencent.mm.pluginsdk.ui.applet.d.a(enterpriseBizContactPlainListUI.uSU, str3, str, str2, null, false, enterpriseBizContactPlainListUI.getResources().getString(R.l.dIA), new com.tencent.mm.pluginsdk.ui.applet.k.a(enterpriseBizContactPlainListUI) {
                final /* synthetic */ EnterpriseBizContactPlainListUI kbe;

                public final void a(boolean z, String str, int i) {
                    if (z && this.kbe.scene == 3) {
                        Intent intent = this.kbe.getIntent();
                        intent.putExtra("enterprise_biz_name", str4);
                        this.kbe.setResult(-1, intent);
                        this.kbe.finish();
                    }
                }
            });
        } else if (enterpriseBizContactPlainListUI.scene == 4) {
            BizInfo hW = e.hW(bVar.userName);
            String CN = hW == null ? null : hW.CN();
            if (!bg.mA(CN)) {
                com.tencent.mm.modelbiz.b hC = com.tencent.mm.modelbiz.w.DO().hC(hW.CO());
                int i2 = hC != null ? hC.field_qyUin : 0;
                int i3 = hC != null ? hC.field_userUin : 0;
                int hE = com.tencent.mm.modelbiz.w.DO().hE(hW.field_username);
                g.oUh.i(13419, new Object[]{Integer.valueOf(i2), Integer.valueOf(hE), Integer.valueOf(i3), Integer.valueOf(1)});
                w.d("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "bizEnterpriseActive report fatherUin:%d,childUin:%d,userUin:%d,scene:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(hE), Integer.valueOf(i3), Integer.valueOf(1)});
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", CN);
                intent2.putExtra("useJs", true);
                intent2.putExtra("srcUsername", bVar.userName);
                intent2.putExtra("enterprise_biz_name", enterpriseBizContactPlainListUI.huj);
                intent2.putExtra("biz_chat_chat_id", enterpriseBizContactPlainListUI.kbc);
                com.tencent.mm.bb.d.b(enterpriseBizContactPlainListUI.uSU.uTo, "webview", ".ui.tools.WebViewUI", intent2, 1);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.scene = getIntent().getIntExtra("enterprise_scene", 2);
        this.huj = getIntent().getStringExtra("enterprise_biz_name");
        this.kbc = getIntent().getLongExtra("biz_chat_chat_id", -1);
        w.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "bizName = %s", new Object[]{this.huj});
        KC();
        com.tencent.mm.modelbiz.w.DH().c(this.kbb);
        ap.yY();
        c.wR().a(this.kbb);
    }

    protected final void KC() {
        this.kaM = (ListView) findViewById(R.h.bMm);
        if (this.kbb == null) {
            this.kbb = new a(this, this);
            this.kbd = new OnItemClickListener(this) {
                final /* synthetic */ EnterpriseBizContactPlainListUI kbe;

                {
                    this.kbe = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    w.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "onItemClick position = %s", new Object[]{Integer.valueOf(i)});
                    EnterpriseBizContactPlainListUI.a(this.kbe, i);
                }
            };
        }
        w.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "count = %s", new Object[]{Integer.valueOf(this.kbb.getCount())});
        ap.yY();
        af Rc = c.wR().Rc(this.huj);
        if (this.scene == 2) {
            zi(R.l.eeI);
        } else if (Rc != null) {
            qP(Rc.tK());
        }
        if (Rc == null || !com.tencent.mm.j.a.ez(Rc.field_type) || this.kbb.getCount() <= 0) {
            this.kaM.setVisibility(8);
            TextView textView = (TextView) findViewById(R.h.bMn);
            textView.setText(R.l.eeO);
            textView.setVisibility(0);
        } else {
            this.kaM.setVisibility(0);
            this.kaM.setAdapter(this.kbb);
            this.kaM.setOnItemClickListener(this.kbd);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EnterpriseBizContactPlainListUI kbe;

            {
                this.kbe = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kbe.aHf();
                this.kbe.finish();
                return true;
            }
        });
        AnonymousClass3 anonymousClass3 = new OnClickListener(this) {
            final /* synthetic */ EnterpriseBizContactPlainListUI kbe;

            {
                this.kbe = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.kbe.kaM);
            }
        };
    }

    protected void onResume() {
        super.onResume();
        if (!o.eU(this.huj)) {
            w.e("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "%s !isContact", new Object[]{this.huj});
            finish();
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        com.tencent.mm.modelbiz.w.DH().f(this.kbb);
        ap.yY();
        c.wR().b(this.kbb);
        this.kbb.aEW();
        a aVar = this.kbb;
        if (aVar.hBe != null) {
            aVar.hBe.detach();
            aVar.hBe = null;
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return R.i.dbd;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.scene == 4) {
            finish();
        }
    }
}
