package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.aby;
import com.tencent.mm.protocal.c.bfv;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.ui.d.f;
import com.tencent.mm.ui.l;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SettingsTrustFriendUI extends MMActivity implements e {
    private static int pml = 5;
    private p lrn;
    private TextView mED;
    private GridView mfI;
    private List<String> pmh;
    private a pmi;
    private View pmj;
    private boolean pmk;

    private class a extends BaseAdapter {
        final /* synthetic */ SettingsTrustFriendUI pmm;

        private class a {
            public TextView jML;
            public ImageView pcM;
            public ImageView pmp;
            final /* synthetic */ a pmq;

            public a(a aVar) {
                this.pmq = aVar;
            }
        }

        private a(SettingsTrustFriendUI settingsTrustFriendUI) {
            this.pmm = settingsTrustFriendUI;
        }

        public final int getCount() {
            int size = this.pmm.pmh.size();
            if (this.pmm.pmk) {
                return size;
            }
            if (size == 0) {
                return 1;
            }
            if (size <= 0 || size >= SettingsTrustFriendUI.pml) {
                return size >= SettingsTrustFriendUI.pml ? size + 1 : 0;
            } else {
                return size + 2;
            }
        }

        public final Object getItem(int i) {
            if (getItemViewType(i) == 0) {
                return this.pmm.pmh.get(i);
            }
            return null;
        }

        public final int getItemViewType(int i) {
            int size = this.pmm.pmh.size();
            if (this.pmm.pmk || i < size) {
                return 0;
            }
            if (size == 0) {
                return 1;
            }
            if (size >= SettingsTrustFriendUI.pml) {
                return 2;
            }
            if (i == size) {
                return 1;
            }
            if (i == size + 1) {
                return 2;
            }
            return -1;
        }

        public final int getViewTypeCount() {
            return 3;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = this.pmm.getLayoutInflater().inflate(R.i.doi, null);
                ImageView imageView = (ImageView) view.findViewById(R.h.cJH);
                ImageView imageView2 = (ImageView) view.findViewById(R.h.cJI);
                TextView textView = (TextView) view.findViewById(R.h.cJM);
                a aVar2 = new a(this);
                aVar2.pcM = imageView;
                aVar2.pmp = imageView2;
                aVar2.jML = textView;
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                String str = (String) this.pmm.pmh.get(i);
                ap.yY();
                x Rc = c.wR().Rc(str);
                aVar.pcM.setScaleType(ScaleType.FIT_XY);
                b.a(aVar.pcM, str);
                aVar.jML.setText(h.b(this.pmm, Rc.tL(), aVar.jML.getTextSize()));
                if (this.pmm.pmk) {
                    aVar.pmp.setVisibility(0);
                } else {
                    aVar.pmp.setVisibility(8);
                }
            } else {
                aVar.jML.setVisibility(4);
                aVar.pmp.setVisibility(8);
                aVar.pcM.setScaleType(ScaleType.FIT_XY);
                if (getItemViewType(i) == 1) {
                    aVar.pcM.setImageResource(R.g.bct);
                } else if (getItemViewType(i) == 2) {
                    aVar.pcM.setImageResource(R.g.bcu);
                }
            }
            return view;
        }
    }

    static /* synthetic */ void a(SettingsTrustFriendUI settingsTrustFriendUI) {
        final k cVar = new com.tencent.mm.plugin.setting.a.c();
        ap.vd().a(cVar, 0);
        settingsTrustFriendUI.getString(R.l.dGO);
        settingsTrustFriendUI.lrn = g.a(settingsTrustFriendUI, settingsTrustFriendUI.getString(R.l.cbS), true, new OnCancelListener(settingsTrustFriendUI) {
            final /* synthetic */ SettingsTrustFriendUI pmm;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(cVar);
            }
        });
    }

    static /* synthetic */ void h(SettingsTrustFriendUI settingsTrustFriendUI) {
        if (settingsTrustFriendUI.pmh.size() <= 0 || settingsTrustFriendUI.pmh.size() >= 3) {
            final k aVar = new com.tencent.mm.plugin.setting.a.a(settingsTrustFriendUI.pmh);
            ap.vd().a(aVar, 0);
            if (settingsTrustFriendUI.lrn != null) {
                settingsTrustFriendUI.lrn.dismiss();
            }
            settingsTrustFriendUI.getString(R.l.dGO);
            settingsTrustFriendUI.lrn = g.a(settingsTrustFriendUI, settingsTrustFriendUI.getString(R.l.dIB), true, new OnCancelListener(settingsTrustFriendUI) {
                final /* synthetic */ SettingsTrustFriendUI pmm;

                public final void onCancel(DialogInterface dialogInterface) {
                    ap.vd().c(aVar);
                }
            });
            return;
        }
        g.b(settingsTrustFriendUI, settingsTrustFriendUI.getString(R.l.eUz, new Object[]{Integer.valueOf(3)}), settingsTrustFriendUI.getString(R.l.dIO), true);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ap.yY();
        String str = (String) c.vr().get(352277, null);
        if (!bg.mA(str)) {
            this.pmh = bg.f(str.split(","));
        }
        if (this.pmh == null) {
            this.pmh = new ArrayList();
        }
        this.uSU.ipu.post(new Runnable(this) {
            final /* synthetic */ SettingsTrustFriendUI pmm;

            {
                this.pmm = r1;
            }

            public final void run() {
                SettingsTrustFriendUI.a(this.pmm);
            }
        });
        KC();
    }

    protected final int getLayoutId() {
        return R.i.doh;
    }

    public void onStart() {
        super.onStart();
        ap.vd().a(869, this);
        ap.vd().a(583, this);
    }

    protected void onStop() {
        super.onStop();
        ap.vd().b(869, this);
        ap.vd().b(583, this);
    }

    protected final void KC() {
        zi(R.l.doh);
        this.mfI = (GridView) findViewById(R.h.cJK);
        this.pmi = new a();
        this.mfI.setColumnWidth(getResources().getDimensionPixelSize(R.f.aXB));
        this.mfI.setNumColumns(-1);
        this.mfI.setStretchMode(1);
        this.mfI.setHorizontalSpacing(getResources().getDimensionPixelSize(R.f.bac) * 2);
        this.mfI.setVerticalSpacing(getResources().getDimensionPixelSize(R.f.bad));
        this.mfI.setAdapter(this.pmi);
        ((ViewGroup) this.mfI.getParent()).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SettingsTrustFriendUI pmm;

            {
                this.pmm = r1;
            }

            public final void onClick(View view) {
                if (this.pmm.pmk) {
                    this.pmm.pmk = false;
                    this.pmm.pmi.notifyDataSetChanged();
                }
            }
        });
        this.mfI.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SettingsTrustFriendUI pmm;

            {
                this.pmm = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!this.pmm.pmk || motionEvent.getAction() != 1 || this.pmm.mfI.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY()) != -1) {
                    return false;
                }
                this.pmm.pmk = false;
                this.pmm.pmi.notifyDataSetChanged();
                return true;
            }
        });
        this.mfI.setHorizontalScrollBarEnabled(false);
        this.mfI.setVerticalScrollBarEnabled(false);
        this.mfI.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SettingsTrustFriendUI pmm;

            {
                this.pmm = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.pmm.pmi.getItemViewType(i) == 1) {
                    Intent intent = new Intent();
                    intent.putExtra("list_type", 12);
                    intent.putExtra("titile", this.pmm.getString(R.l.dCT));
                    intent.putExtra("scene", 2);
                    intent.putExtra("max_limit_num", SettingsTrustFriendUI.pml);
                    intent.putExtra("stay_in_wechat", true);
                    intent.putExtra("already_select_contact", bg.c(this.pmm.pmh, ","));
                    intent.putExtra("block_contact", m.xL());
                    intent.putExtra("list_attr", s.ef(s.vYT, 256));
                    intent.putExtra("too_many_member_tip_string", this.pmm.getString(R.l.eUy, new Object[]{Integer.valueOf(SettingsTrustFriendUI.pml)}));
                    d.a(this.pmm, ".ui.contact.SelectContactUI", intent, 1);
                    return;
                }
                if (this.pmm.pmi.getItemViewType(i) == 2) {
                    if (!this.pmm.pmk) {
                        this.pmm.pmk = true;
                    } else {
                        return;
                    }
                } else if (this.pmm.pmi.getItemViewType(i) == 0 && this.pmm.pmk) {
                    this.pmm.pmh.remove(this.pmm.pmi.getItem(i));
                    if (this.pmm.pmh.size() == 0) {
                        this.pmm.pmk = false;
                    }
                } else {
                    return;
                }
                this.pmm.pmi.notifyDataSetChanged();
            }
        });
        this.mED = (TextView) findViewById(R.h.cJJ);
        CharSequence stringExtra = getIntent().getStringExtra(f.uOC);
        if (bg.mA(stringExtra)) {
            this.mED.setText(getResources().getString(R.l.eUA, new Object[]{Integer.valueOf(3)}));
        } else {
            this.mED.setText(stringExtra);
        }
        this.pmj = findViewById(R.h.cJN);
        this.pmj.setVisibility(8);
        ((TextView) this.pmj.findViewById(R.h.cSf)).setText(getString(R.l.eUz, new Object[]{Integer.valueOf(3)}));
        this.pmj.findViewById(R.h.bCB).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SettingsTrustFriendUI pmm;

            {
                this.pmm = r1;
            }

            public final void onClick(View view) {
                this.pmm.pmj.setVisibility(8);
            }
        });
        findViewById(R.h.cJL).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SettingsTrustFriendUI pmm;

            {
                this.pmm = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "https://weixin110.qq.com/security/readtemplate?t=w_security_center_website/trusted_friend_guide");
                d.b(this.pmm, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsTrustFriendUI pmm;

            {
                this.pmm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.pmm.baq();
                return true;
            }
        });
        a(1, getString(R.l.dHp), new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsTrustFriendUI pmm;

            {
                this.pmm = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsTrustFriendUI.h(this.pmm);
                return true;
            }
        }, l.b.uTY);
        ks(true);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Contact");
            if (!bg.mA(stringExtra)) {
                this.pmh.clear();
                this.pmh.addAll(bg.f(stringExtra.split(",")));
                this.pmi.notifyDataSetChanged();
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.d("MicroMsg.SettingsTrustFriendUI", "errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.lrn != null) {
            this.lrn.dismiss();
        }
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 869) {
                int i3;
                aby com_tencent_mm_protocal_c_aby = (aby) ((com.tencent.mm.y.b) kVar.hsK).hsk.hsr;
                pml = com_tencent_mm_protocal_c_aby.tHx;
                List<bfv> list = com_tencent_mm_protocal_c_aby.tfq;
                if (list.size() != this.pmh.size()) {
                    i3 = 1;
                    break;
                } else if (list.size() == 0) {
                    i3 = 0;
                } else {
                    for (bfv com_tencent_mm_protocal_c_bfv : list) {
                        if (!this.pmh.contains(com_tencent_mm_protocal_c_bfv.jNj)) {
                            i3 = 1;
                            break;
                        }
                    }
                    i3 = 0;
                }
                if (i3 != 0) {
                    this.pmh.clear();
                    for (bfv com_tencent_mm_protocal_c_bfv2 : list) {
                        this.pmh.add(com_tencent_mm_protocal_c_bfv2.jNj);
                    }
                    this.pmi.notifyDataSetChanged();
                }
                if (this.pmh.size() > 0 && this.pmh.size() < 3) {
                    this.pmj.setVisibility(0);
                }
                ap.yY();
                c.vr().set(352277, bg.c(this.pmh, ","));
            } else if (kVar.getType() == 583) {
                ap.yY();
                c.vr().set(352277, bg.c(this.pmh, ","));
                finish();
            }
        } else if (!bg.mA(str)) {
            g.bl(this, str);
        }
    }

    private void baq() {
        ap.yY();
        String str = (String) c.vr().get(352277, null);
        ArrayList arrayList = new ArrayList();
        if (bg.mA(str)) {
            Object obj = arrayList;
        } else {
            Collection f = bg.f(str.split(","));
        }
        if (this.pmh.size() == f.size() && this.pmh.containsAll(f)) {
            finish();
        } else {
            g.a(this, getString(R.l.eOl), getString(R.l.dIO), getString(R.l.dIx), getString(R.l.dHR), true, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SettingsTrustFriendUI pmm;

                {
                    this.pmm = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    SettingsTrustFriendUI.h(this.pmm);
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SettingsTrustFriendUI pmm;

                {
                    this.pmm = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.pmm.finish();
                }
            });
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        baq();
        return true;
    }
}
