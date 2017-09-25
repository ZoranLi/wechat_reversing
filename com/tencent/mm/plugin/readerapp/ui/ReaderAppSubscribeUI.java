package com.tencent.mm.plugin.readerapp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.amu;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;

public class ReaderAppSubscribeUI extends MMActivity {
    private ListView oJY;
    private a oJZ;

    static class a extends BaseAdapter {
        private final Context context;
        final int[] oKb = new int[]{1, 2, 4, 8, 16, 32, 64, FileUtils.S_IWUSR, 256, 512, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, 2048, Downloads.RECV_BUFFER_SIZE, 8192};
        int oKc;
        private String[] oKd = null;
        int oKe = 0;

        static class a {
            TextView ipw;
            CheckBox ipy;

            a() {
            }
        }

        public final /* bridge */ /* synthetic */ Object getItem(int i) {
            return this.oKd[i];
        }

        public a(Context context, int i) {
            this.context = context;
            this.oKc = i;
            this.oKd = context.getString(R.l.eIg).split(";");
            this.oKe = rK(i);
        }

        public final int getCount() {
            return this.oKd.length;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(this.context, R.i.dlY, null);
                aVar2.ipw = (TextView) view.findViewById(R.h.cvL);
                aVar2.ipy = (CheckBox) view.findViewById(R.h.cvK);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.ipw.setText(this.oKd[i]);
            aVar.ipy.setChecked((this.oKc & this.oKb[i]) != 0);
            return view;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        private int rK(int i) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < this.oKb.length) {
                if ((this.oKb[i2] & i) != 0) {
                    i3++;
                }
                i2++;
            }
            return i3;
        }
    }

    protected final int getLayoutId() {
        return R.i.dlZ;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.yY();
        c.vr().set(868518890, "in");
        zi(R.l.dZi);
        KC();
    }

    protected final void KC() {
        ap.yY();
        this.oJZ = new a(this, bg.f((Integer) c.vr().get(868518889, null)));
        this.oJY = (ListView) findViewById(R.h.cvM);
        this.oJY.setAdapter(this.oJZ);
        this.oJY.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ReaderAppSubscribeUI oKa;

            {
                this.oKa = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 1;
                a a = this.oKa.oJZ;
                if ((a.oKc & a.oKb[i]) != 0) {
                    a.oKc &= a.oKb[i] ^ -1;
                    a.oKe--;
                    if (a.oKe < 0) {
                        a.oKe = 0;
                    }
                    a.notifyDataSetChanged();
                } else if (a.oKe < 3) {
                    a.oKc |= a.oKb[i];
                    a.oKe++;
                    if (a.oKe > a.oKb.length) {
                        a.oKe = a.oKb.length;
                    }
                    a.notifyDataSetChanged();
                } else {
                    i2 = 0;
                }
                if (i2 == 0) {
                    g.h(this.oKa, R.l.dZj, R.l.dIO);
                }
            }
        });
        this.oJZ.notifyDataSetChanged();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ReaderAppSubscribeUI oKa;

            {
                this.oKa = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oKa.rJ(this.oKa.oJZ.oKc);
                return true;
            }
        });
        AnonymousClass3 anonymousClass3 = new OnClickListener(this) {
            final /* synthetic */ ReaderAppSubscribeUI oKa;

            {
                this.oKa = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.oKa.oJY);
            }
        };
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.oJZ != null) {
            rJ(this.oJZ.oKc);
        }
        return true;
    }

    private void rJ(int i) {
        ap.yY();
        c.vr().set(868518889, Integer.valueOf(i));
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_amu = new amu();
        com_tencent_mm_protocal_c_amu.tRn = i;
        ap.yY();
        c.wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(43, com_tencent_mm_protocal_c_amu));
        Intent intent = new Intent();
        intent.putExtra("Contact_User", "newsapp");
        intent.addFlags(67108864);
        com.tencent.mm.plugin.readerapp.a.a.imv.d(intent, this);
        finish();
    }

    protected void onResume() {
        super.onResume();
        this.oJZ.notifyDataSetChanged();
    }
}
