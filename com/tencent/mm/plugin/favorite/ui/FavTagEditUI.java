package com.tencent.mm.plugin.favorite.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.favorite.b.j;
import com.tencent.mm.plugin.favorite.b.t;
import com.tencent.mm.plugin.favorite.b.x;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.a.c;
import com.tencent.mm.plugin.favorite.ui.a.d;
import com.tencent.mm.plugin.favorite.ui.base.FavTagPanel;
import com.tencent.mm.protocal.c.sa;
import com.tencent.mm.protocal.c.sb;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.l.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class FavTagEditUI extends MMActivity {
    private j lIl;
    private List<String> lIm;
    private FavTagPanel lIn;
    private FavTagPanel lIo;
    private ListView lIp;
    private ListView lIq;
    private TextView lIr;
    private c lIs;
    private d lIt;
    private boolean lIu;

    protected final int getLayoutId() {
        return R.i.dcB;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        final long longExtra = getIntent().getLongExtra("key_fav_item_id", -1);
        if (-1 != longExtra) {
            this.lIl = h.ata().bT(longExtra);
        }
        this.lIm = getIntent().getStringArrayListExtra("key_fav_result_list");
        this.lIo = (FavTagPanel) findViewById(R.h.bOU);
        this.lIp = (ListView) findViewById(R.h.cHf);
        this.lIq = (ListView) findViewById(R.h.cBc);
        this.lIr = (TextView) findViewById(R.h.cjo);
        this.lIo.kU(true);
        this.lIo.Ak(R.g.bkq);
        this.lIo.vmN = true;
        this.lIo.vmJ = new a(this) {
            final /* synthetic */ FavTagEditUI lIv;

            {
                this.lIv = r1;
            }

            public final void uM(String str) {
                this.lIv.lIo.removeTag(str);
                this.lIv.lIs.wl(str);
                if (this.lIv.lIn != null) {
                    this.lIv.lIn.aU(str, false);
                }
                this.lIv.auh();
            }

            public final void uN(String str) {
            }

            public final void uO(String str) {
                this.lIv.lIo.removeTag(str);
                this.lIv.lIs.wl(str);
                if (this.lIv.lIn != null) {
                    this.lIv.lIn.aU(str, false);
                }
                this.lIv.auh();
            }

            public final void uP(String str) {
                if (bg.mA(str)) {
                    this.lIv.lIq.setVisibility(8);
                    this.lIv.lIp.setVisibility(0);
                } else {
                    d h = this.lIv.lIt;
                    h.lJt.clear();
                    h.lJs.clear();
                    h.lJr = bg.ap(str, "");
                    t asT = h.asT();
                    boolean mA = bg.mA(str);
                    Collection arrayList = new ArrayList(16);
                    Iterator it = asT.lEw.tzv.iterator();
                    while (it.hasNext()) {
                        Iterator it2 = ((sb) it.next()).tzu.iterator();
                        while (it2.hasNext()) {
                            sa saVar = (sa) it2.next();
                            if (mA || saVar.sgP.contains(str)) {
                                arrayList.add(saVar.sgP);
                            }
                        }
                    }
                    h.lJs.addAll(arrayList);
                    h.notifyDataSetChanged();
                    this.lIv.lIq.setVisibility(0);
                    this.lIv.lIp.setVisibility(8);
                }
                this.lIv.auh();
            }

            public final void uQ(String str) {
                if (bg.mA(str)) {
                    w.d("MicroMsg.FavTagEditUI", "on create tag, fail, tag is empty");
                    return;
                }
                this.lIv.lIo.aT(str, true);
                this.lIv.auh();
            }

            public final void aoI() {
            }

            public final void h(boolean z, int i) {
                this.lIv.lIu = z;
                TextView k = this.lIv.lIr;
                int i2 = (!this.lIv.lIu || i <= 0) ? 8 : 0;
                k.setVisibility(i2);
                this.lIv.lIr.setText(this.lIv.getString(R.l.ejE, new Object[]{Integer.valueOf(i)}));
                this.lIv.auh();
            }
        };
        this.lIo.postDelayed(new Runnable(this) {
            final /* synthetic */ FavTagEditUI lIv;

            {
                this.lIv = r1;
            }

            public final void run() {
                this.lIv.lIo.bSw();
                this.lIv.aHj();
            }
        }, 100);
        if (this.lIl != null) {
            this.lIo.a(this.lIl.field_tagProto.tzx, this.lIl.field_tagProto.tzx);
        } else if (this.lIm != null) {
            this.lIo.a(this.lIm, this.lIm);
        }
        this.lIs = new c(this, this.uSU.uTo) {
            final /* synthetic */ FavTagEditUI lIv;

            protected final void wi(String str) {
                this.lIv.lIo.aT(str, true);
                if (this.lIv.lIn != null) {
                    this.lIv.lIn.aU(str, true);
                }
                this.lIv.auh();
            }

            protected final void wj(String str) {
                this.lIv.lIo.removeTag(str);
                if (this.lIv.lIn != null) {
                    this.lIv.lIn.aU(str, false);
                }
                this.lIv.auh();
            }
        };
        this.lIs.aw(this.lIl == null ? null : this.lIl.field_tagProto.tzx);
        if (!(this.lIl == null || this.lIl.field_tagProto.tzw.isEmpty())) {
            View inflate = View.inflate(this.uSU.uTo, R.i.dcE, null);
            TextView textView = (TextView) inflate.findViewById(R.h.bOL);
            textView.setText(getString(R.l.eiY));
            textView.setVisibility(0);
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.aXj);
            this.lIn = (FavTagPanel) inflate.findViewById(R.h.bOV);
            this.lIn.setVisibility(0);
            this.lIn.a(this.lIl.field_tagProto.tzx, this.lIl.field_tagProto.tzw);
            this.lIn.setBackgroundResource(R.g.bgi);
            this.lIn.setPadding(0, 0, 0, dimensionPixelSize);
            this.lIn.vmJ = new a(this) {
                final /* synthetic */ FavTagEditUI lIv;

                {
                    this.lIv = r1;
                }

                public final void uM(String str) {
                    this.lIv.lIo.removeTag(str);
                    this.lIv.lIs.wl(str);
                    this.lIv.auh();
                }

                public final void uN(String str) {
                    this.lIv.lIo.aT(str, true);
                    this.lIv.lIs.wk(str);
                    this.lIv.auh();
                }

                public final void uO(String str) {
                }

                public final void aoI() {
                }

                public final void uP(String str) {
                }

                public final void uQ(String str) {
                }

                public final void h(boolean z, int i) {
                }
            };
            this.lIp.addHeaderView(inflate);
        }
        if (h.asT().atr() > 0) {
            this.lIp.addHeaderView(View.inflate(this.uSU.uTo, R.i.dcD, null));
        }
        this.lIp.setAdapter(this.lIs);
        this.lIp.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FavTagEditUI lIv;

            {
                this.lIv = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.lIv.lIo.bSx();
                return false;
            }
        });
        this.lIt = new d(this, this.uSU.uTo) {
            final /* synthetic */ FavTagEditUI lIv;

            protected final void vv(String str) {
                this.lIv.lIo.aT(str, true);
                this.lIv.lIs.wk(str);
                this.lIv.lIo.bSu();
                this.lIv.lIo.bSx();
                this.lIv.auh();
            }
        };
        this.lIq.setAdapter(this.lIt);
        this.lIq.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FavTagEditUI lIv;

            {
                this.lIv = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.lIv.lIo.bSx();
                return false;
            }
        });
        zi(R.l.ehS);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FavTagEditUI lIv;

            {
                this.lIv = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.lIv.aui();
                return true;
            }
        });
        a(0, getString(R.l.dHp), new OnMenuItemClickListener(this) {
            final /* synthetic */ FavTagEditUI lIv;

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.lIv.lIu) {
                    this.lIv.auh();
                } else {
                    Collection bSy = this.lIv.lIo.bSy();
                    String trim = this.lIv.lIo.bSt().trim();
                    if (!bg.mA(trim)) {
                        bSy.remove(trim);
                        bSy.add(trim);
                    }
                    this.lIv.lIl = h.ata().bT(longExtra);
                    Intent intent;
                    if (this.lIv.lIl != null) {
                        x.a(this.lIv.lIl, bSy, this.lIv.getIntent().getIntExtra("key_fav_scene", 1));
                        intent = new Intent();
                        intent.putExtra("key_fav_result_list", bSy);
                        this.lIv.setResult(-1, intent);
                    } else {
                        String[] strArr = new String[bSy.size()];
                        Iterator it = bSy.iterator();
                        int i = 0;
                        while (it.hasNext()) {
                            int i2 = i + 1;
                            strArr[i] = (String) it.next();
                            i = i2;
                        }
                        intent = new Intent();
                        intent.putExtra("key_fav_result_array", strArr);
                        intent.putExtra("key_fav_result_list", bSy);
                        this.lIv.setResult(-1, intent);
                    }
                    this.lIv.finish();
                    this.lIv.aHf();
                }
                return true;
            }
        }, b.uTY);
        auh();
        h.asT().a(this.lIs);
    }

    private void auh() {
        if (this.lIu) {
            w.w("MicroMsg.FavTagEditUI", "match max length, disable finish button");
            if (bPT()) {
                ae(0, false);
            }
        } else if (this.lIl == null) {
            if (this.lIo.tzv.size() > 0 || this.lIo.bSt().length() > 0) {
                if (!bPT()) {
                    ae(0, true);
                }
            } else if (bPT()) {
                ae(0, false);
            }
        } else if (this.lIl.field_tagProto.tzx.size() == this.lIo.tzv.size() && this.lIo.bSt().length() <= 0) {
            List bSy = this.lIo.bSy();
            int i = 0;
            while (i < bSy.size()) {
                if (((String) bSy.get(i)).equals(this.lIl.field_tagProto.tzx.get(i))) {
                    i++;
                } else if (!bPT()) {
                    ae(0, true);
                    return;
                } else {
                    return;
                }
            }
            if (bPT()) {
                ae(0, false);
            }
        } else if (!bPT()) {
            ae(0, true);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        t asT = h.asT();
        c cVar = this.lIs;
        if (cVar != null) {
            asT.hCU.remove(cVar.toString());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        aui();
        return true;
    }

    private void aui() {
        g.a(this.uSU.uTo, getString(R.l.eiX), "", getString(R.l.dDl), getString(R.l.dGs), new OnClickListener(this) {
            final /* synthetic */ FavTagEditUI lIv;

            {
                this.lIv = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.lIv.finish();
            }
        }, null);
    }
}
