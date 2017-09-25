package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.av.b;
import com.tencent.mm.av.e;
import com.tencent.mm.av.l;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.a.f;
import com.tencent.mm.u.a.g;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.ui.bindmobile.MobileFriendUI;

public class FMessageConversationUI extends MMActivity {
    private d jWo = new d(this) {
        final /* synthetic */ FMessageConversationUI qTT;

        {
            this.qTT = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            e.d(this.qTT.qTS, this.qTT.oza);
        }
    };
    private String oza;
    private b qTB;
    private ListView qTP;
    private a qTQ;
    private TextView qTR;
    private long qTS;

    class a {
        TextView iUO;
        ImageView jki;
        final /* synthetic */ FMessageConversationUI qTT;

        public a(FMessageConversationUI fMessageConversationUI, View view) {
            this.qTT = fMessageConversationUI;
            this.jki = (ImageView) view.findViewById(R.h.bQG);
            this.iUO = (TextView) view.findViewById(R.h.bQH);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.ekY);
        try {
            ap.getNotification().qi();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.FMessageConversationUI", e, "try cancel notification fail", new Object[0]);
        }
        if (ap.zb()) {
            KC();
        } else {
            finish();
        }
    }

    protected void onPause() {
        super.onPause();
        ap.yY();
        c.vr().set(143618, Integer.valueOf(0));
    }

    protected void onResume() {
        super.onResume();
        if (!ap.zb()) {
            finish();
        } else if (this.qTR != null && bg.Hp()) {
            this.qTR.setText(R.l.elb);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        f.gz("1");
        l.Ky().Kl();
        if (this.qTB != null) {
            l.Ky().f(this.qTB);
        }
    }

    protected final void KC() {
        boolean z = true;
        if (g.Ae().gu("1") != null) {
            int i;
            String str = g.Ae().gu("1").value;
            if (str.equals("0")) {
                i = 0;
            } else if (str.equals("1")) {
                r0 = true;
            } else {
                r0 = true;
            }
            f.gy("1");
            int i2 = i;
        } else {
            boolean z2 = true;
        }
        this.qTB = new b(this.uSU.uTo);
        l.Ky().c(this.qTB);
        this.qTB.uSN = new com.tencent.mm.ui.k.a(this) {
            final /* synthetic */ FMessageConversationUI qTT;

            {
                this.qTT = r1;
            }

            public final void OI() {
            }

            public final void OH() {
                if (this.qTT.qTB.getCount() >= 0) {
                    this.qTT.ae(0, true);
                } else {
                    this.qTT.ae(0, false);
                }
            }
        };
        this.qTP = (ListView) findViewById(R.h.bQB);
        if (i2 != 0) {
            View inflate = LayoutInflater.from(this.uSU.uTo).inflate(R.i.ddo, null);
            inflate.findViewById(R.h.bQK).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FMessageConversationUI qTT;

                {
                    this.qTT = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.bb.d.b(this.qTT.uSU.uTo, "search", ".ui.FTSAddFriendUI", new Intent().putExtra("Search_Scene", 2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0));
                }
            });
            this.qTP.addHeaderView(inflate);
        }
        this.qTP.setAdapter(this.qTB);
        final com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this);
        this.qTP.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ FMessageConversationUI qTT;

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.qTT.qTP.getHeaderViewsCount()) {
                    w.w("MicroMsg.FMessageConversationUI", "on header view long click, ignore");
                } else {
                    View view2 = view;
                    lVar.a(view2, i - this.qTT.qTP.getHeaderViewsCount(), j, this.qTT, this.qTT.jWo);
                }
                return true;
            }
        });
        Context context = this.uSU.uTo;
        b bVar = this.qTB;
        if (this.qTP.getHeaderViewsCount() <= 0) {
            z = false;
        }
        this.qTQ = new a(context, bVar, z);
        this.qTP.setOnItemClickListener(this.qTQ);
        View findViewById;
        if (i2 == 0) {
            findViewById = findViewById(R.h.bQz);
            findViewById.setVisibility(0);
            ((TextView) findViewById(R.h.bLZ)).setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ FMessageConversationUI qTT;

                {
                    this.qTT = r1;
                }

                public final void onClick(View view) {
                    ap.yY();
                    if (bg.mA((String) c.vr().get(6, null))) {
                        Intent intent = new Intent(this.qTT.uSU.uTo, BindMContactIntroUI.class);
                        intent.putExtra("key_upload_scene", 5);
                        MMWizardActivity.z(this.qTT, intent);
                        return;
                    }
                    this.qTT.startActivity(new Intent(this.qTT, MobileFriendUI.class));
                }
            });
            this.qTP.setEmptyView(findViewById);
        } else {
            findViewById = findViewById(R.h.bQA);
            findViewById.setVisibility(0);
            this.qTR = (TextView) findViewById.findViewById(R.h.bQJ);
            ListView listView = (ListView) findViewById.findViewById(R.h.bQI);
            listView.setAdapter(new BaseAdapter(this) {
                final /* synthetic */ FMessageConversationUI qTT;

                {
                    this.qTT = r1;
                }

                public final View getView(int i, View view, ViewGroup viewGroup) {
                    a aVar;
                    if (view == null || view.getTag() == null) {
                        view = LayoutInflater.from(this.qTT.uSU.uTo).inflate(R.i.ddn, null);
                        aVar = new a(this.qTT, view);
                        view.setTag(aVar);
                    } else {
                        aVar = (a) view.getTag();
                    }
                    if (i == 0) {
                        aVar.jki.setImageResource(R.k.dxi);
                        aVar.iUO.setText(R.l.eke);
                    }
                    return view;
                }

                public final long getItemId(int i) {
                    return (long) i;
                }

                public final Object getItem(int i) {
                    return Integer.valueOf(i);
                }

                public final int getCount() {
                    return 1;
                }
            });
            listView.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ FMessageConversationUI qTT;

                {
                    this.qTT = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i != 0) {
                        return;
                    }
                    if (m.Fl() != com.tencent.mm.modelfriend.m.a.hBs) {
                        Intent intent = new Intent(this.qTT.uSU.uTo, BindMContactIntroUI.class);
                        intent.putExtra("key_upload_scene", 5);
                        MMWizardActivity.z(this.qTT.uSU.uTo, intent);
                        return;
                    }
                    this.qTT.startActivity(new Intent(this.qTT.uSU.uTo, MobileFriendUI.class));
                }
            });
            this.qTP.setEmptyView(findViewById);
        }
        a(0, getString(R.l.eAJ), new OnMenuItemClickListener(this) {
            final /* synthetic */ FMessageConversationUI qTT;

            {
                this.qTT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(this.qTT, AddMoreFriendsUI.class);
                intent.putExtra("invite_friend_scene", 3);
                this.qTT.startActivity(intent);
                return true;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FMessageConversationUI qTT;

            {
                this.qTT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qTT.finish();
                return true;
            }
        });
    }

    protected final int getLayoutId() {
        return R.i.ddm;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        b bVar = (b) this.qTB.getItem(adapterContextMenuInfo.position);
        if (bVar == null) {
            w.e("MicroMsg.FMessageConversationUI", "onItemLongClick, item is null, pos = " + adapterContextMenuInfo.position);
            return;
        }
        if (!bg.mA(bVar.field_displayName)) {
            contextMenu.setHeaderTitle(h.a(this, bVar.field_displayName));
        }
        contextMenu.add(0, 0, 0, R.l.dGB);
        this.qTS = bVar.field_fmsgSysRowId;
        this.oza = bVar.field_talker;
    }
}
