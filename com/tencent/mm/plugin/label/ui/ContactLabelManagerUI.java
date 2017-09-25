package com.tencent.mm.plugin.label.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.label.b.c;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.z;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.widget.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashMap;

public class ContactLabelManagerUI extends ContactLabelBaseUI implements OnCreateContextMenuListener, OnItemClickListener, d, e {
    private ListView Fg;
    private int WO;
    private View kQZ;
    private int kaQ = 0;
    private int kaR = 0;
    private g kaU;
    private ae mHandler = new ae(this) {
        final /* synthetic */ ContactLabelManagerUI mZA;

        {
            this.mZA = r1;
        }

        public final void handleMessage(Message message) {
            w.d("MicroMsg.Label.ContactLabelManagerUI", "handleMessage:%d", new Object[]{Integer.valueOf(message.what)});
            switch (message.what) {
                case 5001:
                    this.mZA.fj(false);
                    return;
                case 5002:
                    this.mZA.zi(this.mZA.getString(R.l.dJd));
                    return;
                case 5003:
                    this.mZA.aFI();
                    return;
                default:
                    return;
            }
        }
    };
    private b mZq = b.Normal;
    private View mZr;
    private View mZs;
    private a mZt;
    private ArrayList<z> mZu = new ArrayList();
    private HashMap<Integer, Integer> mZv = new HashMap();
    private boolean mZw = true;
    private OnClickListener mZx = new OnClickListener(this) {
        final /* synthetic */ ContactLabelManagerUI mZA;

        {
            this.mZA = r1;
        }

        public final void onClick(View view) {
            ContactLabelManagerUI.b(this.mZA);
        }
    };
    private com.tencent.mm.sdk.e.j.a mZy = new com.tencent.mm.sdk.e.j.a(this) {
        final /* synthetic */ ContactLabelManagerUI mZA;

        {
            this.mZA = r1;
        }

        public final void a(String str, l lVar) {
            if (!bg.mA(str)) {
                this.mZA.fj(false);
            }
        }
    };
    private com.tencent.mm.sdk.e.m.b mZz = new com.tencent.mm.sdk.e.m.b(this) {
        final /* synthetic */ ContactLabelManagerUI mZA;

        {
            this.mZA = r1;
        }

        public final void a(int i, m mVar, Object obj) {
            w.d("MicroMsg.Label.ContactLabelManagerUI", "event:%d, obj:%s", new Object[]{Integer.valueOf(i), obj});
            if (this.mZA.mHandler != null) {
                this.mZA.mHandler.removeMessages(5001);
                this.mZA.mHandler.sendEmptyMessageDelayed(5001, 400);
            }
        }
    };

    class a extends BaseAdapter {
        ArrayList<z> mData;
        final /* synthetic */ ContactLabelManagerUI mZA;

        a(ContactLabelManagerUI contactLabelManagerUI) {
            this.mZA = contactLabelManagerUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return oA(i);
        }

        public final int getCount() {
            return this.mData == null ? 0 : this.mData.size();
        }

        public final z oA(int i) {
            return (this.mData == null || i > this.mData.size()) ? null : (z) this.mData.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(this.mZA).inflate(R.i.cZA, viewGroup, false);
                cVar = new c(view);
                LayoutParams layoutParams = cVar.nax.getLayoutParams();
                layoutParams.height = (int) (((float) com.tencent.mm.bg.a.U(this.mZA, R.f.aXQ)) * com.tencent.mm.bg.a.dL(this.mZA));
                cVar.nax.setLayoutParams(layoutParams);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            z oA = oA(i);
            cVar.nav.setText(h.c(this.mZA.uSU.uTo, oA.field_labelName, this.mZA.WO));
            if (this.mZA.mZv == null || !this.mZA.mZv.containsKey(Integer.valueOf(oA.field_labelID))) {
                cVar.naw.setVisibility(0);
                cVar.naw.setText("(0)");
            } else {
                cVar.naw.setVisibility(0);
                cVar.naw.setText("(" + this.mZA.mZv.get(Integer.valueOf(oA.field_labelID)) + ")");
            }
            return view;
        }
    }

    public enum b {
        Normal,
        Empty
    }

    static /* synthetic */ void a(ContactLabelManagerUI contactLabelManagerUI, b bVar) {
        contactLabelManagerUI.mZq = bVar;
        switch (contactLabelManagerUI.mZq) {
            case Normal:
                contactLabelManagerUI.kQZ.setVisibility(0);
                contactLabelManagerUI.mZr.setVisibility(8);
                return;
            case Empty:
                contactLabelManagerUI.kQZ.setVisibility(8);
                contactLabelManagerUI.mZr.setVisibility(0);
                return;
            default:
                w.w("MicroMsg.Label.ContactLabelManagerUI", "unkonw mode:%s", new Object[]{contactLabelManagerUI.mZq});
                return;
        }
    }

    static /* synthetic */ void a(ContactLabelManagerUI contactLabelManagerUI, z zVar) {
        if (zVar == null) {
            w.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteScene] can not do scene. lable is null");
            return;
        }
        contactLabelManagerUI.zi(contactLabelManagerUI.getString(R.l.evA));
        ap.vd().a(new com.tencent.mm.plugin.label.b.b(zVar.field_labelID), 0);
    }

    static /* synthetic */ void b(ContactLabelManagerUI contactLabelManagerUI) {
        if (contactLabelManagerUI.mZu == null || contactLabelManagerUI.mZu.isEmpty()) {
            com.tencent.mm.plugin.report.service.g.oUh.i(11347, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
        } else {
            com.tencent.mm.plugin.report.service.g.oUh.i(11347, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
        }
        w.i("MicroMsg.Label.ContactLabelManagerUI", "dz[dealAddLabel]");
        Intent intent = new Intent();
        intent.putExtra("list_attr", s.q(new int[]{s.vYO, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT}));
        intent.putExtra("list_type", 1);
        intent.putExtra("titile", contactLabelManagerUI.getString(R.l.evx));
        intent.putExtra("show_too_many_member", false);
        intent.putExtra("scene", 5);
        com.tencent.mm.bb.d.a(contactLabelManagerUI, ".ui.contact.SelectContactUI", intent, 7001);
    }

    protected final int getLayoutId() {
        return R.i.cZB;
    }

    protected final void KC() {
        this.WO = com.tencent.mm.bg.a.T(this.uSU.uTo, R.f.aXI);
        qP(getString(R.l.evy));
        a(0, getString(R.l.evE), new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactLabelManagerUI mZA;

            {
                this.mZA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                ContactLabelManagerUI.b(this.mZA);
                return false;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ContactLabelManagerUI mZA;

            {
                this.mZA = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.mZA.finish();
                return false;
            }
        });
        this.mZt = new a(this);
        this.kQZ = findViewById(R.h.cah);
        this.mZr = findViewById(R.h.cab);
        this.mZs = findViewById(R.h.cai);
        this.mZs.setOnClickListener(this.mZx);
        this.Fg = (ListView) findViewById(R.h.cag);
        this.kaU = new g(this);
        this.Fg.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ContactLabelManagerUI mZA;

            {
                this.mZA = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    this.mZA.kaQ = (int) motionEvent.getRawX();
                    this.mZA.kaR = (int) motionEvent.getRawY();
                }
                return false;
            }
        });
        this.Fg.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ ContactLabelManagerUI mZA;

            {
                this.mZA = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.mZA.kaU.a(view, i, j, this.mZA, this.mZA, this.mZA.kaQ, this.mZA.kaR);
                return true;
            }
        });
        this.Fg.setAdapter(this.mZt);
        this.Fg.setOnItemClickListener(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ ContactLabelManagerUI mZA;

            {
                this.mZA = r1;
            }

            public final void run() {
                ap.vd().a(new c(), 0);
            }
        });
        com.tencent.mm.plugin.label.e.aFF().c(this.mZy);
    }

    protected void onResume() {
        ap.vd().a(636, this);
        ap.yY();
        com.tencent.mm.u.c.wR().a(this.mZz);
        fj(true);
        super.onResume();
    }

    protected void onPause() {
        ap.vd().b(636, this);
        ap.yY();
        com.tencent.mm.u.c.wR().b(this.mZz);
        super.onPause();
    }

    protected void onDestroy() {
        com.tencent.mm.plugin.label.e.aFF().f(this.mZy);
        super.onDestroy();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.mZt != null && i >= 0) {
            z oA = this.mZt.oA(i);
            if (oA != null) {
                String str = oA.field_labelID;
                String str2 = oA.field_labelName;
                Intent intent = new Intent();
                intent.putExtra("label_id", str);
                intent.putExtra("label_name", str2);
                intent.setClass(this, ContactLabelEditUI.class);
                startActivity(intent);
                if (!bg.mA(str)) {
                    return;
                }
                if (this.mZu == null || this.mZu.isEmpty()) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(11347, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                    return;
                }
                com.tencent.mm.plugin.report.service.g.oUh.i(11347, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
            }
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        int i = ((AdapterContextMenuInfo) contextMenuInfo).position;
        if (this.mZt != null && i >= 0) {
            z oA = this.mZt.oA(i);
            if (oA != null) {
                contextMenu.setHeaderTitle(h.a(view.getContext(), oA.field_labelName));
                contextMenu.add(0, 0, 0, getString(R.l.dGB));
                contextMenu.add(0, 1, 1, getString(R.l.dGK));
            }
        }
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public final void c(MenuItem menuItem, int i) {
        int i2 = ((AdapterContextMenuInfo) menuItem.getMenuInfo()).position;
        if (this.mZt != null && i2 >= 0) {
            final z oA = this.mZt.oA(i2);
            switch (i) {
                case 0:
                    com.tencent.mm.ui.base.g.a(this, getString(R.l.evz), "", getString(R.l.dGB), getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ ContactLabelManagerUI mZA;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            if (oA == null) {
                                return;
                            }
                            if (oA.field_isTemporary) {
                                this.mZA.zm(oA.field_labelID);
                            } else {
                                ContactLabelManagerUI.a(this.mZA, oA);
                            }
                        }
                    }, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ ContactLabelManagerUI mZA;

                        {
                            this.mZA = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    return;
                case 1:
                    Intent intent = new Intent();
                    intent.setClass(this, ContactLabelEditUI.class);
                    intent.putExtra("label_id", oA.field_labelID);
                    intent.putExtra("label_name", oA.field_labelName);
                    startActivity(intent);
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd]errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        switch (kVar.getType()) {
            case 636:
                if (i == 0 && i2 == 0) {
                    zm(((com.tencent.mm.plugin.label.b.b) kVar).mYV);
                    return;
                }
                w.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[onSceneEnd] delete fail.");
                aFN();
                return;
            default:
                w.w("MicroMsg.Label.ContactLabelManagerUI", "unknow type.");
                return;
        }
    }

    private synchronized void fj(final boolean z) {
        w.d("MicroMsg.Label.ContactLabelManagerUI", "loading%s", new Object[]{String.valueOf(z)});
        if (z && this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(5002, 400);
        }
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ ContactLabelManagerUI mZA;

            public final void run() {
                this.mZA.mZu = com.tencent.mm.plugin.label.e.aFF().bLm();
                if (this.mZA.mZu == null || this.mZA.mZu.size() <= 0) {
                    w.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Empty");
                    if (this.mZA.mZw) {
                        com.tencent.mm.plugin.report.service.g.oUh.i(11346, new Object[]{Integer.valueOf(1), Integer.valueOf(0)});
                        this.mZA.mZw = false;
                    }
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass4 mZD;

                        {
                            this.mZD = r1;
                        }

                        public final void run() {
                            ContactLabelManagerUI.a(this.mZD.mZA, b.Empty);
                            if (z && this.mZD.mZA.mHandler != null) {
                                this.mZD.mZA.mHandler.removeMessages(5002);
                                this.mZD.mZA.mHandler.sendEmptyMessageDelayed(5003, 0);
                            }
                        }
                    });
                    return;
                }
                w.i("MicroMsg.Label.ContactLabelManagerUI", "cpan[updateData] Normal");
                if (this.mZA.mZw) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(11346, new Object[]{Integer.valueOf(1), Integer.valueOf(1)});
                    this.mZA.mZw = false;
                }
                if (this.mZA.mZu != null && this.mZA.mZu.size() > 0) {
                    int size = this.mZA.mZu.size();
                    com.tencent.mm.plugin.label.e.aFF().aFA();
                    for (int i = 0; i < size; i++) {
                        int i2 = ((z) this.mZA.mZu.get(i)).field_labelID;
                        ArrayList QS = com.tencent.mm.plugin.label.e.aFF().QS(String.valueOf(i2));
                        if (QS == null || QS.size() <= 0) {
                            this.mZA.mZv.put(Integer.valueOf(i2), Integer.valueOf(0));
                        } else {
                            this.mZA.mZv.put(Integer.valueOf(i2), Integer.valueOf(QS.size()));
                        }
                    }
                }
                af.v(new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 mZD;

                    {
                        this.mZD = r1;
                    }

                    public final void run() {
                        ContactLabelManagerUI.a(this.mZD.mZA, b.Normal);
                        a k = this.mZD.mZA.mZt;
                        k.mData = this.mZD.mZA.mZu;
                        k.notifyDataSetChanged();
                        this.mZD.mZA.mZt.notifyDataSetInvalidated();
                        if (z && this.mZD.mZA.mHandler != null) {
                            this.mZD.mZA.mHandler.removeMessages(5002);
                            this.mZD.mZA.mHandler.sendEmptyMessageDelayed(5003, 400);
                        }
                    }
                });
            }

            public final String toString() {
                return super.toString() + "|updateData";
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] requestCode:%d resultCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 7001:
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    w.i("MicroMsg.Label.ContactLabelManagerUI", "dz[onActivityResult] %s", new Object[]{stringExtra});
                    if (!bg.mA(stringExtra)) {
                        Intent intent2 = new Intent();
                        intent2.setClass(this, ContactLabelEditUI.class);
                        intent2.putExtra("Select_Contact", stringExtra);
                        startActivity(intent2);
                        break;
                    }
                    break;
            }
            super.onActivityResult(i, i2, intent);
        }
    }

    private void zm(String str) {
        if (com.tencent.mm.plugin.label.e.aFF().gR(str)) {
            aFI();
            fj(false);
            return;
        }
        w.w("MicroMsg.Label.ContactLabelManagerUI", "cpan[doDeleteContactLabel] fail.");
        aFN();
    }

    private void aFN() {
        aFI();
        uC(getString(R.l.ebp));
    }
}
