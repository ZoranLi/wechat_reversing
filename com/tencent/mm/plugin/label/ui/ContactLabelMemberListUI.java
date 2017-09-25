package com.tencent.mm.plugin.label.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.plugin.label.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;

public class ContactLabelMemberListUI extends MMActivity {
    private TextView jEZ;
    private ae mHandler = new ae(this) {
        final /* synthetic */ ContactLabelMemberListUI mZS;

        {
            this.mZS = r1;
        }

        public final void handleMessage(Message message) {
            w.d("MicroMsg.Label.ContactLabelMemberListUI", "handleMessage:%d", new Object[]{Integer.valueOf(message.what)});
            switch (message.what) {
                case 5001:
                    this.mZS.aFP();
                    return;
                default:
                    w.w("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] unknow msg.");
                    return;
            }
        }
    };
    private ListView mZO;
    private a mZP;
    private String mZQ;
    private String mZR;
    private b mZz = new b(this) {
        final /* synthetic */ ContactLabelMemberListUI mZS;

        {
            this.mZS = r1;
        }

        public final void a(int i, m mVar, Object obj) {
            w.d("MicroMsg.Label.ContactLabelMemberListUI", "event:%d, obj:%s", new Object[]{Integer.valueOf(i), obj});
            if (this.mZS.mHandler != null) {
                this.mZS.mHandler.removeMessages(5001);
                this.mZS.mHandler.sendEmptyMessageDelayed(5001, 300);
            }
        }
    };

    static /* synthetic */ void a(ContactLabelMemberListUI contactLabelMemberListUI, int i) {
        if (contactLabelMemberListUI.mZP != null && i <= contactLabelMemberListUI.mZP.getCount()) {
            af afVar = contactLabelMemberListUI.mZP.oB(i).jiL;
            if (afVar != null && !bg.mA(afVar.field_username) && afVar.field_deleteFlag != 1) {
                if (o.fu(afVar.field_username)) {
                    w.e("MicroMsg.Label.ContactLabelMemberListUI", "error, 4.5 do not contain this contact %s", new Object[]{afVar.field_username});
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Contact_User", afVar.field_username);
                intent.putExtra("Contact_Alias", afVar.pA());
                intent.putExtra("Contact_Nick", afVar.tK());
                intent.putExtra("Contact_QuanPin", afVar.pC());
                intent.putExtra("Contact_PyInitial", afVar.pB());
                intent.putExtra("Contact_Sex", afVar.gkr);
                intent.putExtra("Contact_Province", afVar.getProvince());
                intent.putExtra("Contact_City", afVar.getCity());
                intent.putExtra("Contact_Signature", afVar.signature);
                a.imv.d(intent, contactLabelMemberListUI);
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.cZD;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mZQ = getIntent().getStringExtra("label_id");
        this.mZR = getIntent().getStringExtra("label_name");
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactLabelMemberListUI mZS;

            {
                this.mZS = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mZS.finish();
                return false;
            }
        });
        a(0, getString(R.l.evC), new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactLabelMemberListUI mZS;

            {
                this.mZS = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent();
                intent.setClass(this.mZS, ContactLabelEditUI.class);
                intent.putExtra("label_id", this.mZS.mZQ);
                intent.putExtra("label_name", this.mZS.mZR);
                this.mZS.startActivityForResult(intent, CdnLogic.MediaType_FAVORITE_FILE);
                return false;
            }
        });
        qP(this.mZR);
        this.mZO = (ListView) findViewById(R.h.bFT);
        this.jEZ = (TextView) findViewById(R.h.empty);
        if (bg.mA(this.mZQ)) {
            w.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] inite view");
            finish();
        }
        this.mZP = new a(this.uSU.uTo);
        this.mZO.setAdapter(this.mZP);
        this.mZO.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ContactLabelMemberListUI mZS;

            {
                this.mZS = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ContactLabelMemberListUI.a(this.mZS, i);
            }
        });
        this.mZO.setEmptyView(this.jEZ);
    }

    protected void onResume() {
        ap.yY();
        c.wR().a(this.mZz);
        super.onResume();
        aFP();
    }

    protected void onPause() {
        ap.yY();
        c.wR().b(this.mZz);
        super.onPause();
    }

    protected void onDestroy() {
        if (this.mZP != null) {
            this.mZP.aEW();
            this.mZP.uSN = null;
        }
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. requestcode:%d resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        switch (i) {
            case CdnLogic.MediaType_FAVORITE_FILE /*10001*/:
                if (i2 == -1) {
                    finish();
                    return;
                } else {
                    aFP();
                    return;
                }
            default:
                w.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. unknow requestcode:%d", new Object[]{Integer.valueOf(i)});
                return;
        }
    }

    private void aFP() {
        if (this.mZP != null) {
            this.mZP.mZK = com.tencent.mm.plugin.label.a.a.aFG().zh(this.mZQ);
            this.mZP.a(null, null);
        }
        this.mZR = com.tencent.mm.plugin.label.a.a.aFG().zd(this.mZQ);
        if (!bg.mA(this.mZR)) {
            qP(this.mZR);
        }
    }
}
