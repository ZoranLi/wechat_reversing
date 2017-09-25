package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.e;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;
import java.util.List;

public class WxaBindBizInfoUI extends MMActivity {
    private TextView jkW;
    private ListView jkX;

    private static class a extends BaseAdapter {
        private LayoutInflater Du;
        private List<WxaEntryInfo> jkZ = new LinkedList();

        private static class a {
            TextView ioX;
            View ipY;
            ImageView jla;
        }

        public final /* synthetic */ Object getItem(int i) {
            return iy(i);
        }

        public a(LayoutInflater layoutInflater, List<WxaEntryInfo> list) {
            this.Du = layoutInflater;
            if (list != null) {
                this.jkZ.addAll(list);
            }
        }

        public final int getCount() {
            return this.jkZ.size();
        }

        private WxaEntryInfo iy(int i) {
            return (WxaEntryInfo) this.jkZ.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = this.Du.inflate(R.i.cUb, viewGroup, false);
                a aVar2 = new a();
                aVar2.jla = (ImageView) view.findViewById(R.h.icon);
                aVar2.ioX = (TextView) view.findViewById(R.h.csu);
                aVar2.ipY = view.findViewById(R.h.divider);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            WxaEntryInfo iy = iy(i);
            b.AY().a(aVar.jla, iy.iconUrl, com.tencent.mm.modelappbrand.a.a.AX(), e.hqF);
            aVar.ioX.setText(bg.mz(iy.title));
            if (this.jkZ != null) {
                int i2;
                View view2 = aVar.ipY;
                if (this.jkZ.size() - 1 == i) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                view2.setVisibility(i2);
            }
            return view;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WxaBindBizInfoUI jkY;

            {
                this.jkY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.jkY.finish();
                return false;
            }
        });
        zi(R.l.dFL);
        List parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("wxa_entry_info_list");
        View inflate = getLayoutInflater().inflate(R.i.cVK, null);
        this.jkW = (TextView) inflate.findViewById(R.h.cIV);
        this.jkW.setText(getString(R.l.dGm));
        this.jkX = (ListView) findViewById(R.h.bHF);
        this.jkX.addHeaderView(inflate);
        this.jkX.setAdapter(new a(getLayoutInflater(), parcelableArrayListExtra));
        this.jkX.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ WxaBindBizInfoUI jkY;

            {
                this.jkY = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                WxaEntryInfo wxaEntryInfo = (WxaEntryInfo) adapterView.getAdapter().getItem(i);
                if (wxaEntryInfo != null) {
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", wxaEntryInfo.username);
                    intent.putExtra("key_start_biz_profile_from_app_brand_profile", true);
                    intent.putExtra("force_get_contact", true);
                    d.b(this.jkY, "profile", ".ui.ContactInfoUI", intent);
                }
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.cVL;
    }
}
