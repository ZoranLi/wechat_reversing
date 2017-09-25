package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.j;
import com.tencent.mm.u.n;
import com.tencent.mm.u.o;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupCardSelectUI extends MMActivity {
    private TextView jWk;
    private List<x> nxk;
    private boolean vXM = true;
    private boolean vXN;
    private boolean vXO = false;
    private List<String> vXP = null;
    private int vXQ;
    private ListView vXR;
    private a vXS;
    private HashMap<String, Long> vXT;

    class a extends BaseAdapter {
        final /* synthetic */ GroupCardSelectUI vXU;

        public a(GroupCardSelectUI groupCardSelectUI) {
            this.vXU = groupCardSelectUI;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            x xVar = (x) this.vXU.nxk.get(i);
            if (view == null) {
                b bVar2 = new b(this.vXU);
                view = View.inflate(this.vXU, R.i.dfC, null);
                bVar2.naw = (TextView) view.findViewById(R.h.bVH);
                bVar2.vXV = (TextView) view.findViewById(R.h.bVI);
                bVar2.hBi = (ImageView) view.findViewById(R.h.bVG);
                bVar2.oqN = (CheckBox) view.findViewById(R.h.cBH);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            com.tencent.mm.pluginsdk.ui.a.b.a(bVar.hBi, xVar.field_username);
            bVar.vXV.setText(h.c(this.vXU, n.eK(xVar.field_username), com.tencent.mm.bg.a.T(this.vXU.uSU.uTo, R.f.aXI)));
            bVar.naw.setText("(" + j.eC(xVar.field_username) + ")");
            if (this.vXU.vXO) {
                bVar.oqN.setVisibility(0);
                if (this.vXU.vXP.contains(xVar.field_username)) {
                    bVar.oqN.setChecked(true);
                } else {
                    bVar.oqN.setChecked(false);
                }
            }
            return view;
        }

        public final int getCount() {
            return this.vXU.nxk.size();
        }

        public final Object getItem(int i) {
            return this.vXU.nxk.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }
    }

    class b {
        ImageView hBi;
        TextView naw;
        CheckBox oqN;
        final /* synthetic */ GroupCardSelectUI vXU;
        TextView vXV;

        b(GroupCardSelectUI groupCardSelectUI) {
            this.vXU = groupCardSelectUI;
        }
    }

    static /* synthetic */ void a(GroupCardSelectUI groupCardSelectUI, x xVar) {
        int i = 1;
        if (groupCardSelectUI.vXO) {
            if (groupCardSelectUI.vXP.contains(xVar.field_username)) {
                groupCardSelectUI.vXP.remove(xVar.field_username);
            } else {
                if (!groupCardSelectUI.vXO || groupCardSelectUI.vXP.size() < groupCardSelectUI.vXQ) {
                    i = 0;
                } else {
                    g.a(groupCardSelectUI.uSU.uTo, groupCardSelectUI.getString(R.l.eQr, new Object[]{Integer.valueOf(groupCardSelectUI.vXQ)}), groupCardSelectUI.getString(R.l.dIs), new OnClickListener(groupCardSelectUI) {
                        final /* synthetic */ GroupCardSelectUI vXU;

                        {
                            this.vXU = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
                if (i == 0) {
                    groupCardSelectUI.vXP.add(xVar.field_username);
                }
            }
            groupCardSelectUI.vXS.notifyDataSetChanged();
        } else if (!groupCardSelectUI.vXM) {
            r0 = new Intent();
            ap.yY();
            r0.putExtra("Select_Contact", bg.c(c.xa().fZ(xVar.field_username), ","));
            r0.putExtra("Select_room_name", n.eK(xVar.field_username));
            groupCardSelectUI.setResult(-1, r0);
            groupCardSelectUI.finish();
        } else if (groupCardSelectUI.vXN) {
            r0 = new Intent();
            r0.putExtra("Select_Conv_User", xVar.field_username);
            groupCardSelectUI.setResult(-1, r0);
            groupCardSelectUI.finish();
        } else {
            r0 = new Intent(groupCardSelectUI, En_5b8fbb1e.class);
            r0.addFlags(67108864);
            r0.putExtra("Chat_User", xVar.field_username);
            groupCardSelectUI.startActivity(r0);
            groupCardSelectUI.finish();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        qP(getString(R.l.dCM));
        this.vXM = getIntent().getBooleanExtra("group_select_type", true);
        this.vXN = getIntent().getBooleanExtra("group_select_need_result", false);
        this.vXO = getIntent().getBooleanExtra("group_multi_select", false);
        if (this.vXO) {
            String stringExtra = getIntent().getStringExtra("already_select_contact");
            if (bg.mA(stringExtra)) {
                this.vXP = new LinkedList();
            } else {
                this.vXP = u.f(stringExtra.split(","));
            }
            this.vXQ = getIntent().getIntExtra("max_limit_num", 0);
        }
        bXZ();
        KC();
        if (this.vXO) {
            a(1, getString(R.l.dHT), new OnMenuItemClickListener(this) {
                final /* synthetic */ GroupCardSelectUI vXU;

                {
                    this.vXU = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    Intent intent = new Intent();
                    intent.putExtra("Select_Conv_User", bg.c(this.vXU.vXP, ","));
                    this.vXU.setResult(-1, intent);
                    this.vXU.finish();
                    return true;
                }
            }, com.tencent.mm.ui.l.b.uTY);
            ae(1, true);
            Ok();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected final void KC() {
        this.vXR = (ListView) findViewById(R.h.bVJ);
        this.vXS = new a(this);
        this.vXR.setAdapter(this.vXS);
        this.vXR.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ GroupCardSelectUI vXU;

            {
                this.vXU = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                x xVar = (x) this.vXU.vXS.getItem(i);
                if (xVar == null) {
                    w.v("MicroMsg.GroupCardSelectUI", "onItemClick contact null");
                    return;
                }
                GroupCardSelectUI.a(this.vXU, xVar);
                this.vXU.Ok();
            }
        });
        this.jWk = (TextView) findViewById(R.h.bVF);
        if (this.vXS.getCount() <= 0) {
            this.jWk.setVisibility(0);
        } else {
            this.jWk.setVisibility(8);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ GroupCardSelectUI vXU;

            {
                this.vXU = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vXU.finish();
                return true;
            }
        });
    }

    private void bXZ() {
        ap.yY();
        this.vXT = c.wW().bLE();
        this.nxk = new LinkedList();
        List<x> yv = o.yv();
        if (yv.size() != 0) {
            int i = 0;
            for (x xVar : yv) {
                int i2;
                if (this.vXT.containsKey(xVar.field_username)) {
                    a(i, xVar, ((Long) this.vXT.get(xVar.field_username)).longValue());
                    i2 = i + 1;
                } else if (com.tencent.mm.j.a.ez(xVar.field_type)) {
                    this.nxk.add(xVar);
                } else {
                    i2 = i;
                }
                i = i2;
            }
            yv.clear();
        }
    }

    private void a(int i, x xVar, long j) {
        int i2 = 0;
        while (i2 < i && j <= ((Long) this.vXT.get(((x) this.nxk.get(i2)).field_username)).longValue()) {
            i2++;
        }
        this.nxk.add(i2, xVar);
    }

    protected final int getLayoutId() {
        return R.i.dfB;
    }

    private void Ok() {
        if (this.vXO) {
            String format;
            StringBuilder append = new StringBuilder().append(getString(R.l.dHT));
            if (this.vXP.size() > 0) {
                format = String.format("(%s)", new Object[]{Integer.valueOf(this.vXP.size())});
            } else {
                format = "";
            }
            aB(1, append.append(format).toString());
        }
    }
}
