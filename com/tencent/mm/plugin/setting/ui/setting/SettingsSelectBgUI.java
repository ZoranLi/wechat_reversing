package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ap.b;
import com.tencent.mm.ap.j;
import com.tencent.mm.ap.m;
import com.tencent.mm.ap.n;
import com.tencent.mm.ap.t;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.k;
import com.tencent.mm.y.e;
import java.util.ArrayList;
import java.util.List;

public class SettingsSelectBgUI extends MMActivity implements e {
    private boolean pkR;
    private a plY;
    private GridView plZ;
    private j pma;
    private List<j> pmb = new ArrayList();
    private aj pmc = new aj(new com.tencent.mm.sdk.platformtools.aj.a(this) {
        final /* synthetic */ SettingsSelectBgUI pmd;

        {
            this.pmd = r1;
        }

        public final boolean oQ() {
            if (this.pmd.findViewById(R.h.cDw).getWidth() <= 0) {
                return true;
            }
            SettingsSelectBgUI.a(this.pmd);
            return false;
        }
    }, true);
    private String username;

    class a extends k<m> {
        private Context context;
        private int ksj;
        final /* synthetic */ SettingsSelectBgUI pmd;

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (m) obj;
            if (obj == null) {
                obj = new m();
            }
            obj.b(cursor);
            return obj;
        }

        public a(SettingsSelectBgUI settingsSelectBgUI, Context context, int i) {
            this.pmd = settingsSelectBgUI;
            super(context, new m());
            this.context = context;
            this.ksj = i;
        }

        public final int getCount() {
            return getCursor().getCount() + 2;
        }

        protected final void OL() {
            OK();
        }

        public final void OK() {
            n Ic = t.Ic();
            setCursor(Ic.hnH.a(new StringBuilder("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.type=1").toString(), null, 0));
            super.notifyDataSetChanged();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            if (view == null) {
                view = View.inflate(this.context, R.i.dog, null);
                view.setLayoutParams(new LayoutParams(this.ksj, this.ksj));
                b bVar2 = new b();
                bVar2.pnw = (LinearLayout) view.findViewById(R.h.cBD);
                bVar2.pnx = (LinearLayout) view.findViewById(R.h.cBC);
                bVar2.pny = (LinearLayout) view.findViewById(R.h.cBF);
                bVar2.pnz = (LinearLayout) view.findViewById(R.h.cBG);
                bVar2.pnA = (LinearLayout) view.findViewById(R.h.cBB);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            ap.yY();
            int a = bg.a((Integer) c.vr().get(12311, null), -2);
            com.tencent.mm.ap.a jT = t.Id().jT(this.pmd.username);
            if (i != 0) {
                if (i != 1) {
                    Bitmap Pg;
                    m mVar = (m) getItem(i - 2);
                    t.Ic();
                    ap.yY();
                    if (c.isSDCardAvailable()) {
                        Pg = d.Pg(n.HY() + n.aR(mVar.id, mVar.fKL));
                    } else {
                        Pg = BitmapFactory.decodeResource(this.pmd.getResources(), R.g.bhQ);
                    }
                    if (Pg != null) {
                        ((ImageView) view.findViewById(R.h.cBE)).setImageBitmap(d.a(Pg, true, 10.0f));
                        switch (mVar.status) {
                            case 1:
                                if (!this.pmd.pkR && jT != null && jT.hNQ != mVar.id) {
                                    bVar.Ec("downloaded");
                                    break;
                                }
                                bVar.Ec("using");
                                break;
                                break;
                            case 2:
                                if (!this.pmd.pkR && jT != null && jT.hNQ == mVar.id) {
                                    bVar.Ec("using");
                                    break;
                                }
                                bVar.Ec("downloaded");
                                break;
                                break;
                            case 3:
                                bVar.Ec("downloading");
                                break;
                            case 4:
                                bVar.Ec("canceling");
                                break;
                            case 5:
                                bVar.Ec("undownloaded");
                                break;
                            default:
                                break;
                        }
                    }
                }
                if (!(this.pmd.pkR && a == 0) && (!(!this.pmd.pkR && a == 0 && jT == null) && (jT == null || jT.hNQ != 0))) {
                    bVar.Ec("downloaded");
                } else {
                    bVar.Ec("using");
                }
                ((ImageView) view.findViewById(R.h.cBE)).setImageBitmap(d.a(BitmapFactory.decodeResource(this.context.getResources(), R.g.beb), true, 10.0f));
            } else {
                if (!(this.pmd.pkR && a == -2) && (!(!this.pmd.pkR && a == -2 && jT == null) && (jT == null || jT.hNQ != -2))) {
                    bVar.Ec("downloaded");
                } else {
                    bVar.Ec("using");
                }
                ((ImageView) view.findViewById(R.h.cBE)).setImageBitmap(d.a(BitmapFactory.decodeResource(this.context.getResources(), R.g.bec), true, 10.0f));
            }
            return view;
        }
    }

    static /* synthetic */ void a(SettingsSelectBgUI settingsSelectBgUI) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) settingsSelectBgUI.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        settingsSelectBgUI.plY = new a(settingsSelectBgUI, settingsSelectBgUI, ((displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels) - 60) / 3);
        settingsSelectBgUI.plZ = (GridView) settingsSelectBgUI.findViewById(R.h.cDw);
        t.Ic().c(settingsSelectBgUI.plY);
        settingsSelectBgUI.plZ.setAdapter(settingsSelectBgUI.plY);
        settingsSelectBgUI.plZ.setOnItemClickListener(new OnItemClickListener(settingsSelectBgUI) {
            final /* synthetic */ SettingsSelectBgUI pmd;

            {
                this.pmd = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0) {
                    SettingsSelectBgUI.a(this.pmd, -2);
                    this.pmd.plY.OK();
                    if (!this.pmd.pkR) {
                        this.pmd.setResult(-1);
                        this.pmd.finish();
                    }
                } else if (i == 1) {
                    SettingsSelectBgUI.a(this.pmd, 0);
                    this.pmd.plY.OK();
                    if (!this.pmd.pkR) {
                        this.pmd.setResult(-1);
                        this.pmd.finish();
                    }
                } else {
                    ap.yY();
                    if (c.isSDCardAvailable()) {
                        m mVar = (m) adapterView.getItemAtPosition(i - 2);
                        if (mVar == null) {
                            w.e("MicroMsg.SettingsSelectBgUI", "onItemClick fail, info is null, position = " + i);
                            return;
                        }
                        n Ic;
                        switch (mVar.status) {
                            case 1:
                            case 2:
                                SettingsSelectBgUI.a(this.pmd, mVar.id);
                                if (this.pmd.pkR) {
                                    mVar.status = 1;
                                    Ic = t.Ic();
                                    Ic.gj(mVar.fKL);
                                    mVar.status = 1;
                                    Ic.b(mVar);
                                } else {
                                    this.pmd.plY.OK();
                                }
                                if (!this.pmd.pkR) {
                                    this.pmd.setResult(-1);
                                    this.pmd.finish();
                                    return;
                                }
                                return;
                            case 3:
                                if (this.pmd.pma != null && this.pmd.pma.hOj == mVar.id) {
                                    ap.vd().c(this.pmd.pma);
                                    t.Ic().aU(this.pmd.pma.hOj, 1);
                                    this.pmd.bl(this.pmd.pmb);
                                }
                                SettingsSelectBgUI.e(mVar.id, this.pmd.pmb);
                                Ic = t.Ic();
                                mVar.status = 4;
                                Ic.b(mVar);
                                final int i2 = mVar.id;
                                new ae(this) {
                                    final /* synthetic */ AnonymousClass3 pmg;

                                    public final void handleMessage(Message message) {
                                        Ic.aU(i2, 1);
                                    }
                                }.sendEmptyMessageDelayed(0, 1000);
                                return;
                            case 4:
                                t.Ic().aU(mVar.id, 1);
                                return;
                            case 5:
                                if (this.pmd.pma == null) {
                                    this.pmd.pma = new j(mVar.id, 1);
                                    ap.vd().a(this.pmd.pma, 0);
                                    return;
                                }
                                this.pmd.pmb.add(new j(mVar.id, 1));
                                return;
                            default:
                                return;
                        }
                    }
                    Toast.makeText(this.pmd, R.l.eTX, 1).show();
                }
            }
        });
    }

    static /* synthetic */ void a(SettingsSelectBgUI settingsSelectBgUI, int i) {
        ap.yY();
        c.vr().set(66820, Integer.valueOf(i));
        g.oUh.i(10198, new Object[]{Integer.valueOf(i)});
        w.i("MicroMsg.SettingsSelectBgUI", "set chating bg id:%d", new Object[]{Integer.valueOf(i)});
        if (settingsSelectBgUI.pkR) {
            ap.yY();
            c.vr().set(12311, Integer.valueOf(i));
            t.Ic().gj(1);
            return;
        }
        b Id = t.Id();
        com.tencent.mm.ap.a jT = Id.jT(settingsSelectBgUI.username);
        if (jT == null) {
            jT = new com.tencent.mm.ap.a();
            jT.username = settingsSelectBgUI.username;
            jT.hNQ = i;
            Id.a(jT);
            return;
        }
        jT.hNQ = i;
        Id.b(jT);
    }

    static /* synthetic */ void e(int i, List list) {
        for (j jVar : list) {
            if (jVar.hOj == i) {
                t.Ic().aU(jVar.hOj, 1);
                list.remove(jVar);
                return;
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dof;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        KC();
        ap.vd().a(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
        ap.vd().a(JsApiSetBackgroundAudioState.CTRL_INDEX, this);
        ap.yY();
        if (c.isSDCardAvailable()) {
            ap.vd().a(new com.tencent.mm.ap.k(1), 0);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.pma != null) {
            ap.vd().c(this.pma);
            t.Ic().aU(this.pma.hOj, 1);
        }
        List<j> list = this.pmb;
        for (j jVar : list) {
            t.Ic().aU(jVar.hOj, 1);
        }
        list.clear();
        ap.vd().b(JsApiGetBackgroundAudioState.CTRL_INDEX, this);
        ap.vd().b(JsApiSetBackgroundAudioState.CTRL_INDEX, this);
        this.plY.aEW();
        t.Ic().f(this.plY);
    }

    protected final void KC() {
        zi(R.l.eSl);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsSelectBgUI pmd;

            {
                this.pmd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pmd.finish();
                return true;
            }
        });
        this.pkR = getIntent().getBooleanExtra("isApplyToAll", true);
        this.username = getIntent().getStringExtra("username");
        this.pmc.v(20, 20);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
        if ((kVar instanceof com.tencent.mm.y.m) && ((com.tencent.mm.y.m) kVar).BQ() == 1) {
            int type = kVar.getType();
            if (type == JsApiGetBackgroundAudioState.CTRL_INDEX || type == JsApiSetBackgroundAudioState.CTRL_INDEX) {
                if (type == JsApiSetBackgroundAudioState.CTRL_INDEX) {
                    bl(this.pmb);
                }
                if (i == 0 && i2 != 0) {
                    return;
                }
                return;
            }
            return;
        }
        w.d("MicroMsg.SettingsSelectBgUI", "another scene");
    }

    private void bl(List<j> list) {
        if (list.size() > 0) {
            this.pma = (j) list.remove(0);
            ap.vd().a(this.pma, 0);
            return;
        }
        this.pma = null;
    }
}
