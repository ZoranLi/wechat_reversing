package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.k;

public class IPCallAllRecordUI extends MMActivity {
    private String fWT;
    private String fWV;
    private ListView mST;
    private boolean mSU = false;

    private class a extends k<com.tencent.mm.plugin.ipcall.a.g.k> {
        final /* synthetic */ IPCallAllRecordUI mSV;

        class a {
            TextView ipa;
            TextView mSW;
            TextView mSX;
            final /* synthetic */ a mSY;

            a(a aVar) {
                this.mSY = aVar;
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (com.tencent.mm.plugin.ipcall.a.g.k) obj;
            if (obj == null) {
                obj = new com.tencent.mm.plugin.ipcall.a.g.k();
            }
            obj.b(cursor);
            return obj;
        }

        public a(IPCallAllRecordUI iPCallAllRecordUI, Context context) {
            this.mSV = iPCallAllRecordUI;
            super(context, null);
            ko(true);
        }

        public final void OK() {
            Cursor cursor = null;
            if (!bg.mA(this.mSV.fWT)) {
                String a = this.mSV.fWT;
                if (!bg.mA(a)) {
                    c yt = i.aEn().yt(a);
                    if (!(yt == null || yt.uxb == -1)) {
                        cursor = i.aEo().cu(yt.uxb);
                    }
                }
            } else if (!bg.mA(this.mSV.fWV)) {
                cursor = i.aEo().yx(this.mSV.fWV);
            }
            setCursor(cursor);
        }

        protected final void OL() {
            aEW();
            OK();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = this.mSV.getLayoutInflater().inflate(R.i.dgl, viewGroup, false);
                aVar = new a(this);
                aVar.mSW = (TextView) view.findViewById(R.h.cte);
                aVar.mSX = (TextView) view.findViewById(R.h.ctg);
                aVar.ipa = (TextView) view.findViewById(R.h.cth);
                view.setTag(aVar);
            }
            com.tencent.mm.plugin.ipcall.a.g.k kVar = (com.tencent.mm.plugin.ipcall.a.g.k) getItem(i);
            aVar = (a) view.getTag();
            aVar.mSX.setText(com.tencent.mm.plugin.ipcall.b.a.yY(kVar.field_phonenumber));
            if (kVar.field_duration > 0) {
                aVar.ipa.setText(com.tencent.mm.plugin.ipcall.b.c.cx(kVar.field_duration));
            } else {
                aVar.ipa.setText(com.tencent.mm.plugin.ipcall.b.c.oz(kVar.field_status));
            }
            aVar.mSW.setText(com.tencent.mm.plugin.ipcall.b.c.cv(kVar.field_calltime));
            return view;
        }
    }

    protected final int Ol() {
        return 1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fWV = getIntent().getStringExtra("IPCallAllRecordUI_phoneNumber");
        this.fWT = getIntent().getStringExtra("IPCallAllRecordUI_contactId");
        this.mSU = getIntent().getBooleanExtra("IPCallAllRecordUI_isSinglePhoneNumber", false);
        zi(R.l.eui);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ IPCallAllRecordUI mSV;

            {
                this.mSV = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mSV.finish();
                return true;
            }
        });
        this.mST = (ListView) findViewById(R.h.bou);
        this.mST.setAdapter(new a(this, this));
    }

    protected final int getLayoutId() {
        return R.i.dfY;
    }
}
