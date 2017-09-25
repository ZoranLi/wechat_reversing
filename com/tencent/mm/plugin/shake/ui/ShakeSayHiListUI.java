package com.tencent.mm.plugin.shake.ui;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.av.j;
import com.tencent.mm.av.k;
import com.tencent.mm.av.l;
import com.tencent.mm.e.b.af;
import com.tencent.mm.j.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.e;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public class ShakeSayHiListUI extends MMActivity {
    private int aIo = 0;
    private ListView iss;
    private long jFH;
    private d jWo = new d(this) {
        final /* synthetic */ ShakeSayHiListUI psT;

        {
            this.psT = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            l.KA().lc(String.valueOf(this.psT.jFH));
            this.psT.psS.a(null, null);
        }
    };
    private int nWO = 0;
    private int nWP = 0;
    private k pqJ = null;
    private int psR = 0;
    private b psS;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.psR = getIntent().getIntExtra("IntentSayHiType", 1);
        if (this.psR == 1) {
            this.pqJ = l.KA();
            zi(R.l.eOr);
        } else {
            zi(R.l.eOq);
        }
        this.nWP = this.pqJ.Kr();
        this.aIo = this.nWP == 0 ? 8 : this.nWP;
        this.nWO = this.pqJ.getCount();
        k kVar = this.pqJ;
        ContentValues contentValues = new ContentValues();
        contentValues.put(DownloadInfo.STATUS, Integer.valueOf(4));
        if (kVar.gUz.update(kVar.getTableName(), contentValues, "status!=? ", new String[]{"4"}) != 0) {
            kVar.doNotify();
        }
        KC();
    }

    protected void onResume() {
        super.onResume();
        if (this.nWO != this.pqJ.getCount()) {
            this.nWO = this.pqJ.getCount();
            if (this.nWO == 0) {
                TextView textView = (TextView) findViewById(R.h.bLU);
                textView.setText(R.l.eOs);
                textView.setVisibility(0);
                kr(false);
            }
            this.psS.OK();
        }
        this.psS.notifyDataSetChanged();
    }

    public void onDestroy() {
        this.psS.aEW();
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        if (this.psS.jWb != null) {
            this.psS.jWb.aFh();
        }
    }

    protected final int getLayoutId() {
        return R.i.dgK;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    protected final void KC() {
        final View inflate = getLayoutInflater().inflate(R.i.dmN, null);
        this.iss = (ListView) findViewById(R.h.czH);
        inflate.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ShakeSayHiListUI psT;

            public final void onClick(View view) {
                this.psT.aIo = this.psT.aIo + 8;
                w.d("MicroMsg.SayHiListUI", "dkfooter more btn:" + this.psT.aIo);
                this.psT.psS.sB(this.psT.aIo);
                if (this.psT.nWO <= this.psT.aIo) {
                    this.psT.iss.removeFooterView(inflate);
                    w.d("MicroMsg.SayHiListUI", "dkfooter REMOVE more btn: " + this.psT.aIo);
                }
            }
        });
        a(0, getString(R.l.dGt), new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakeSayHiListUI psT;

            {
                this.psT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                g.a(this.psT.uSU.uTo, true, this.psT.getString(R.l.eOp), "", this.psT.getString(R.l.eOo), this.psT.getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass3 psU;

                    {
                        this.psU = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        this.psU.psT.pqJ.Ku();
                        this.psU.psT.psS.OK();
                        TextView textView = (TextView) this.psU.psT.findViewById(R.h.bLU);
                        textView.setText(R.l.eOs);
                        textView.setVisibility(0);
                        this.psU.psT.kr(false);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass3 psU;

                    {
                        this.psU = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        });
        if (this.nWO == 0) {
            TextView textView = (TextView) findViewById(R.h.bLU);
            textView.setText(R.l.eOs);
            textView.setVisibility(0);
            kr(false);
        }
        if (this.nWO > 0 && this.aIo < this.nWO) {
            this.iss.addFooterView(inflate);
        }
        this.psS = new b(this, this.pqJ, this.aIo);
        this.psS.a(new c(this) {
            final /* synthetic */ ShakeSayHiListUI psT;

            {
                this.psT = r1;
            }

            public final int cb(View view) {
                return this.psT.iss.getPositionForView(view);
            }
        });
        this.psS.a(new f(this) {
            final /* synthetic */ ShakeSayHiListUI psT;

            {
                this.psT = r1;
            }

            public final void s(View view, int i) {
                this.psT.iss.performItemClick(view, i, 0);
            }
        });
        this.psS.a(new e(this) {
            final /* synthetic */ ShakeSayHiListUI psT;

            {
                this.psT = r1;
            }

            public final void aQ(Object obj) {
                if (obj == null) {
                    w.e("MicroMsg.SayHiListUI", "onItemDel object null");
                    return;
                }
                l.KA().lc(obj.toString());
                this.psT.psS.a(null, null);
            }
        });
        this.iss.setAdapter(this.psS);
        this.iss.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ShakeSayHiListUI psT;

            {
                this.psT = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                j jVar = (j) this.psT.psS.getItem(i);
                if (jVar != null && jVar.field_content != null) {
                    au.d RI = au.d.RI(jVar.field_content);
                    Intent intent = new Intent();
                    intent.putExtra("Contact_User", RI.rUK);
                    intent.putExtra("Contact_Encryptusername", RI.uKj);
                    intent.putExtra("Contact_Alias", RI.gtR);
                    intent.putExtra("Contact_Nick", RI.fFa);
                    intent.putExtra("Contact_QuanPin", RI.hCf);
                    intent.putExtra("Contact_PyInitial", RI.hCe);
                    intent.putExtra("Contact_Sex", RI.gkr);
                    intent.putExtra("Contact_Signature", RI.signature);
                    intent.putExtra("Contact_Scene", RI.scene);
                    intent.putExtra("Contact_FMessageCard", true);
                    intent.putExtra("Contact_City", RI.getCity());
                    intent.putExtra("Contact_Province", RI.getProvince());
                    intent.putExtra("Contact_Content", bg.mA(jVar.field_sayhicontent) ? this.psT.getString(R.l.dTI) : jVar.field_sayhicontent);
                    intent.putExtra("Contact_verify_Scene", RI.scene);
                    intent.putExtra("Contact_Uin", RI.ovb);
                    intent.putExtra("Contact_QQNick", RI.hCg);
                    intent.putExtra("Contact_Mobile_MD5", RI.uJX);
                    intent.putExtra("User_From_Fmessage", true);
                    intent.putExtra("Contact_from_msgType", 37);
                    intent.putExtra("Verify_ticket", RI.osP);
                    intent.putExtra("Contact_ShowFMessageList", true);
                    intent.putExtra("Contact_Source_FMessage", RI.scene);
                    ap.yY();
                    af Rc = com.tencent.mm.u.c.wR().Rc(RI.rUK);
                    if (!(Rc == null || ((int) Rc.gTQ) < 0 || a.ez(Rc.field_type))) {
                        int i2 = RI.fJK;
                        if (i2 == 0 || i2 == 2 || i2 == 5) {
                            intent.putExtra("User_Verify", true);
                        }
                        intent.putExtra("Contact_IsLBSFriend", true);
                        intent.putExtra("Sns_from_Scene", 18);
                    }
                    com.tencent.mm.plugin.shake.a.imv.d(intent, this.psT);
                }
            }
        });
        final com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(this);
        this.iss.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ ShakeSayHiListUI psT;

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i < this.psT.iss.getHeaderViewsCount()) {
                    w.w("MicroMsg.SayHiListUI", "on header view long click, ignore");
                } else {
                    lVar.a(view, i, j, this.psT, this.psT.jWo);
                }
                return true;
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakeSayHiListUI psT;

            {
                this.psT = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.psT.aHf();
                this.psT.finish();
                return true;
            }
        });
        AnonymousClass10 anonymousClass10 = new OnClickListener(this) {
            final /* synthetic */ ShakeSayHiListUI psT;

            {
                this.psT = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.psT.iss);
            }
        };
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.jFH = ((j) this.psS.getItem(adapterContextMenuInfo.position)).field_svrid;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.dGB);
    }
}
