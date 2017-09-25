package com.tencent.mm.plugin.exdevice.ui;

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
import com.tencent.mm.plugin.exdevice.f.b.a.e;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceLikeUI extends MMActivity {
    private String iQO;
    private ArrayList<e> lkX;
    private boolean lkY;
    private ListView lkZ;
    private a lla;
    private final int llb = 30;

    class a extends BaseAdapter {
        final /* synthetic */ ExdeviceLikeUI llc;

        class a {
            ImageView ioV;
            TextView itX;
            NoMeasuredTextView lld;
            TextView lle;
            final /* synthetic */ a llf;

            a(a aVar) {
                this.llf = aVar;
            }
        }

        a(ExdeviceLikeUI exdeviceLikeUI) {
            this.llc = exdeviceLikeUI;
        }

        public final int getCount() {
            return this.llc.lkX == null ? 0 : this.llc.lkX.size();
        }

        public final Object getItem(int i) {
            return this.llc.lkX.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            a aVar;
            e eVar = (e) this.llc.lkX.get(i);
            if (view == null) {
                if (this.llc.lkY) {
                    inflate = LayoutInflater.from(this.llc).inflate(R.i.dbB, viewGroup, false);
                } else {
                    inflate = LayoutInflater.from(this.llc).inflate(R.i.dbA, viewGroup, false);
                }
                a aVar2 = new a(this);
                aVar2.ioV = (ImageView) inflate.findViewById(R.h.bMD);
                aVar2.lld = (NoMeasuredTextView) inflate.findViewById(R.h.bNn);
                aVar2.itX = (TextView) inflate.findViewById(R.h.bNg);
                aVar2.lle = (TextView) inflate.findViewById(R.h.bNf);
                aVar2.lld.H(this.llc.getResources().getDimension(R.f.aXI));
                aVar2.lld.setTextColor(this.llc.getResources().getColor(R.e.black));
                aVar2.lld.bSn();
                aVar2.lld.voV = true;
                inflate.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
                inflate = view;
            }
            b.n(aVar.ioV, eVar.field_username);
            aVar.lld.setText(h.b(this.llc, n.eK(eVar.field_username), aVar.lld.gm.getTextSize()));
            if (!bg.mA(eVar.field_liketips) && aVar.itX != null) {
                aVar.itX.setVisibility(0);
                aVar.itX.setText(eVar.field_liketips);
            } else if (aVar.itX != null) {
                aVar.itX.setVisibility(8);
            }
            if (((int) ((((System.currentTimeMillis() / 1000) - ((long) eVar.field_timestamp)) / 60) + 1)) <= 30) {
                aVar.lle.setText(this.llc.getString(R.l.egc, new Object[]{Integer.valueOf(r3)}));
            } else {
                aVar.lle.setText(o.c(this.llc, ((long) eVar.field_timestamp) * 1000, true));
            }
            return inflate;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iQO = getIntent().getStringExtra("app_username");
        String stringExtra = getIntent().getStringExtra("key_rank_info");
        String stringExtra2 = getIntent().getStringExtra("key_rank_semi");
        this.lkY = getIntent().getBooleanExtra("key_is_like_read_only", false);
        if (bg.mA(stringExtra)) {
            stringExtra2 = getIntent().getStringExtra("rank_id");
            Assert.assertTrue(!bg.mA(stringExtra2));
            this.lkX = ad.apy().vg(stringExtra2);
        } else {
            ArrayList arrayList;
            String str = this.iQO;
            w.d("MicroMsg.ExdeviceMsgXmlParser", stringExtra);
            if (bg.mA(stringExtra)) {
                w.e("MicroMsg.ExdeviceMsgXmlParser", "like info is null or nil");
            } else {
                com.tencent.mm.t.f.a B = com.tencent.mm.t.f.a.B(stringExtra, stringExtra2);
                if (B != null) {
                    Map map = B.hho;
                    ArrayList arrayList2 = new ArrayList();
                    if (!(map == null || map.isEmpty())) {
                        int i = 0;
                        while (true) {
                            stringExtra = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".username");
                            if (bg.mA(stringExtra)) {
                                break;
                            }
                            stringExtra2 = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".rankid");
                            String str2 = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".liketip");
                            String str3 = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".timestamp");
                            e eVar = new e();
                            eVar.field_appusername = str;
                            eVar.field_rankID = stringExtra2;
                            eVar.field_username = stringExtra;
                            eVar.field_timestamp = bg.getInt(str3, 0);
                            eVar.field_liketips = str2;
                            arrayList2.add(eVar);
                            i++;
                        }
                        w.i("MicroMsg.ExdeviceMsgXmlParser", "should break now : %d", new Object[]{Integer.valueOf(i)});
                        arrayList = arrayList2;
                        this.lkX = arrayList;
                    }
                }
            }
            arrayList = null;
            this.lkX = arrayList;
        }
        this.lkZ = (ListView) findViewById(R.h.bMM);
        this.lkZ.setEmptyView(findViewById(R.h.empty));
        this.lla = new a(this);
        this.lkZ.setAdapter(this.lla);
        if (!this.lkY) {
            this.lkZ.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ ExdeviceLikeUI llc;

                {
                    this.llc = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    e eVar = (e) this.llc.lla.getItem(i);
                    Intent intent = new Intent(this.llc, ExdeviceRankInfoUI.class);
                    intent.putExtra("app_username", eVar.field_appusername);
                    intent.putExtra("rank_id", eVar.field_rankID);
                    intent.putExtra("device_type", 1);
                    this.llc.startActivity(intent);
                    this.llc.finish();
                }
            });
        }
        zi(R.l.egd);
        if (!this.lkY) {
            a(0, getString(R.l.egb), new OnMenuItemClickListener(this) {
                final /* synthetic */ ExdeviceLikeUI llc;

                {
                    this.llc = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent(this.llc, ExdeviceRankInfoUI.class);
                    intent.putExtra("app_username", this.llc.iQO);
                    intent.putExtra("rank_id", "#");
                    intent.putExtra("key_is_latest", true);
                    intent.putExtra("device_type", 1);
                    this.llc.startActivity(intent);
                    this.llc.finish();
                    return false;
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceLikeUI llc;

            {
                this.llc = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.llc.finish();
                return false;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.dbC;
    }
}
