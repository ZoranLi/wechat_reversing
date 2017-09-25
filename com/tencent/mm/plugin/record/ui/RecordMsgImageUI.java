package com.tencent.mm.plugin.record.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.bx;
import com.tencent.mm.e.a.cb;
import com.tencent.mm.e.a.lw;
import com.tencent.mm.e.a.ly;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.record.a.j;
import com.tencent.mm.plugin.record.a.m;
import com.tencent.mm.plugin.record.a.s;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.f;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@com.tencent.mm.ui.base.a(3)
public class RecordMsgImageUI extends MMActivity implements com.tencent.mm.plugin.record.a.i.a {
    private long fGM = -1;
    private l iYI;
    private d kTc = new d(this) {
        final /* synthetic */ RecordMsgImageUI oPH;

        {
            this.oPH = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            switch (menuItem.getItemId()) {
                case 0:
                    RecordMsgImageUI.f(this.oPH);
                    return;
                case 1:
                    Activity activity = this.oPH;
                    b cbVar = new cb();
                    e.a(cbVar, activity.getIntent().getIntExtra("key_favorite_source_type", 1), activity.aWV());
                    cbVar.fFA.fFH = 10;
                    cbVar.fFA.activity = activity;
                    com.tencent.mm.sdk.b.a.urY.m(cbVar);
                    return;
                case 2:
                    k.h(this.oPH.aWV(), this.oPH.uSU.uTo);
                    return;
                case 3:
                    String h = this.oPH.aWV();
                    if (!bg.mA(h)) {
                        ly lyVar = (ly) this.oPH.lHk.get(h);
                        if (lyVar != null) {
                            bx bxVar = new bx();
                            bxVar.fFn.activity = this.oPH;
                            bxVar.fFn.fDK = lyVar.fTe.result;
                            bxVar.fFn.fFo = lyVar.fTe.fFo;
                            bxVar.fFn.fFq = 8;
                            RecordMsgImageUI.a(this.oPH, bxVar);
                            bxVar.fFn.fFp = lyVar.fTe.fFp;
                            if (this.oPH.getIntent() != null) {
                                bxVar.fFn.fFu = this.oPH.getIntent().getBundleExtra("_stat_obj");
                            }
                            com.tencent.mm.sdk.b.a.urY.m(bxVar);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    private List<rm> kaa = new LinkedList();
    private MMGestureGallery klE;
    private Runnable lGL = new Runnable(this) {
        final /* synthetic */ RecordMsgImageUI oPH;

        {
            this.oPH = r1;
        }

        public final void run() {
            this.oPH.oPE.notifyDataSetChanged();
        }
    };
    private Map<String, ly> lHk = new HashMap();
    private c lHl = new c<ly>(this) {
        final /* synthetic */ RecordMsgImageUI oPH;

        {
            this.oPH = r2;
            this.usg = ly.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ly lyVar = (ly) bVar;
            this.oPH.lHk.put(lyVar.fTe.filePath, lyVar);
            if (this.oPH.iYI != null && this.oPH.iYI.qJe.isShowing()) {
                RecordMsgImageUI.d(this.oPH);
            }
            return true;
        }
    };
    private a oPE;
    private int oPF = 0;
    private String oPG = null;
    private j oPx;

    private static class a extends BaseAdapter {
        long fGM;
        List<rm> kaa;
        j oPx;

        private a() {
            this.kaa = new LinkedList();
            this.fGM = -1;
        }

        public final /* synthetic */ Object getItem(int i) {
            return rT(i);
        }

        public final int getCount() {
            return this.kaa.size();
        }

        public final rm rT(int i) {
            return (rm) this.kaa.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            j jVar = this.oPx;
            rm rT = rT(i);
            long j = this.fGM;
            Bitmap a = jVar.a(rT, j, false, false);
            if (a == null) {
                w.d("MicroMsg.RecordMsgImgService", "get image fail, try download, can retry:%B", new Object[]{Boolean.valueOf(jVar.a(rT, j))});
                m.a(rT, j, r0);
            }
            if (a == null) {
                w.w("MicroMsg.ShowImageUI", "get image fail");
                if (view == null || (view instanceof MultiTouchImageView)) {
                    view = View.inflate(viewGroup.getContext(), R.i.doA, null);
                }
                ((ImageView) view.findViewById(R.h.bWV)).setImageResource(R.k.dwC);
                view.setLayoutParams(new LayoutParams(-1, -1));
            } else {
                Context context = viewGroup.getContext();
                if (view == null || !(view instanceof MultiTouchImageView)) {
                    view = new MultiTouchImageView(context, a.getWidth(), a.getHeight());
                } else {
                    MultiTouchImageView multiTouchImageView = (MultiTouchImageView) view;
                    multiTouchImageView.dZ(a.getWidth(), a.getHeight());
                }
                com.tencent.mm.sdk.platformtools.k.i(view, a.getWidth(), a.getHeight());
                view.setLayoutParams(new LayoutParams(-1, -1));
                view.setImageBitmap(a);
                view.vol = true;
            }
            return view;
        }
    }

    static /* synthetic */ void a(RecordMsgImageUI recordMsgImageUI, bx bxVar) {
        int selectedItemPosition = recordMsgImageUI.klE.getSelectedItemPosition();
        if (-1 == selectedItemPosition) {
            w.w("MicroMsg.ShowImageUI", "error position");
            return;
        }
        rm rT = recordMsgImageUI.oPE.rT(selectedItemPosition);
        if (rT != null) {
            bxVar.fFn.imagePath = rT.txi;
            bxVar.fFn.fFt = rT.txk;
        }
    }

    static /* synthetic */ void d(RecordMsgImageUI recordMsgImageUI) {
        final List arrayList = new ArrayList();
        final List arrayList2 = new ArrayList();
        arrayList.add(Integer.valueOf(0));
        arrayList2.add(recordMsgImageUI.getString(R.l.eLL));
        arrayList.add(Integer.valueOf(1));
        arrayList2.add(recordMsgImageUI.getString(R.l.eGa));
        arrayList.add(Integer.valueOf(2));
        arrayList2.add(recordMsgImageUI.getString(R.l.eOm));
        String aWV = recordMsgImageUI.aWV();
        ly lyVar = (ly) recordMsgImageUI.lHk.get(aWV);
        if (lyVar == null) {
            b lwVar = new lw();
            lwVar.fTb.filePath = aWV;
            com.tencent.mm.sdk.b.a.urY.m(lwVar);
        } else if (!bg.mA(lyVar.fTe.result)) {
            arrayList.add(Integer.valueOf(3));
            arrayList2.add(recordMsgImageUI.getString(com.tencent.mm.plugin.scanner.a.ak(lyVar.fTe.fFo, lyVar.fTe.result) ? R.l.eIB : R.l.eIA));
        }
        if (recordMsgImageUI.iYI == null) {
            recordMsgImageUI.iYI = new l(recordMsgImageUI.uSU.uTo);
        }
        recordMsgImageUI.iYI.qJf = new n.c(recordMsgImageUI) {
            final /* synthetic */ RecordMsgImageUI oPH;

            public final void a(com.tencent.mm.ui.base.l lVar) {
                lVar.setHeaderTitle("");
                for (int i = 0; i < arrayList.size(); i++) {
                    lVar.e(((Integer) arrayList.get(i)).intValue(), (CharSequence) arrayList2.get(i));
                }
            }
        };
        recordMsgImageUI.iYI.qJg = recordMsgImageUI.kTc;
        recordMsgImageUI.iYI.e(new OnCancelListener(recordMsgImageUI) {
            final /* synthetic */ RecordMsgImageUI oPH;

            {
                this.oPH = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.oPH.iYI = null;
            }
        });
        g.a(recordMsgImageUI.uSU.uTo, recordMsgImageUI.iYI.blb());
    }

    static /* synthetic */ void f(RecordMsgImageUI recordMsgImageUI) {
        recordMsgImageUI.oPG = recordMsgImageUI.aWV();
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("image_path", recordMsgImageUI.oPG);
        com.tencent.mm.bb.d.a(recordMsgImageUI, ".ui.transmit.SelectConversationUI", intent, MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
    }

    protected final int getLayoutId() {
        return R.i.doz;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (VERSION.SDK_INT >= 21) {
            getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        }
        this.oPx = new j();
        this.fGM = getIntent().getLongExtra("message_id", -1);
        String stringExtra = getIntent().getStringExtra("record_data_id");
        com.tencent.mm.protocal.b.a.c Dp = m.Dp(getIntent().getStringExtra("record_xml"));
        if (Dp == null) {
            w.w("MicroMsg.ShowImageUI", "get record msg data error, empty");
            finish();
            return;
        }
        Iterator it = Dp.hkm.iterator();
        while (it.hasNext()) {
            rm rmVar = (rm) it.next();
            if (rmVar.aMw == 2) {
                this.kaa.add(rmVar);
                if (rmVar.lKv.equals(stringExtra)) {
                    this.oPF = this.kaa.size() - 1;
                }
            }
        }
        if (this.kaa.isEmpty()) {
            w.w("MicroMsg.ShowImageUI", "get image data error, empty");
            finish();
            return;
        }
        this.klE = (MMGestureGallery) findViewById(R.h.bSr);
        this.klE.setVerticalFadingEdgeEnabled(false);
        this.klE.setHorizontalFadingEdgeEnabled(false);
        this.oPE = new a();
        this.oPE.kaa = this.kaa;
        this.oPE.fGM = this.fGM;
        this.oPE.oPx = this.oPx;
        this.klE.setAdapter(this.oPE);
        this.klE.setSelection(this.oPF);
        this.klE.setOnItemSelectedListener(new OnItemSelectedListener(this) {
            final /* synthetic */ RecordMsgImageUI oPH;

            {
                this.oPH = r1;
            }

            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (m.d(this.oPH.oPE.rT(i), this.oPH.fGM)) {
                    this.oPH.qP(String.format("%d/%d", new Object[]{Integer.valueOf(i + 1), Integer.valueOf(this.oPH.kaa.size())}));
                    this.oPH.kr(true);
                    return;
                }
                this.oPH.kr(false);
            }

            public final void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.klE.wmR = new f(this) {
            final /* synthetic */ RecordMsgImageUI oPH;

            {
                this.oPH = r1;
            }

            public final void ahA() {
                this.oPH.finish();
            }
        };
        this.klE.wmS = new MMGestureGallery.c(this) {
            final /* synthetic */ RecordMsgImageUI oPH;

            {
                this.oPH = r1;
            }

            public final void auf() {
                RecordMsgImageUI.d(this.oPH);
            }
        };
        kp(true);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ RecordMsgImageUI oPH;

            {
                this.oPH = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.oPH.finish();
                return true;
            }
        });
        s.aWF().a(this);
        com.tencent.mm.sdk.b.a.urY.b(this.lHl);
    }

    protected void onDestroy() {
        s.aWF().b(this);
        this.oPx.destory();
        com.tencent.mm.sdk.b.a.urY.c(this.lHl);
        super.onDestroy();
    }

    final String aWV() {
        int selectedItemPosition = this.klE.getSelectedItemPosition();
        if (-1 == selectedItemPosition) {
            w.w("MicroMsg.ShowImageUI", "error position");
            return null;
        }
        w.d("MicroMsg.ShowImageUI", "cur pos %d path %s", new Object[]{Integer.valueOf(selectedItemPosition), m.c(this.oPE.rT(selectedItemPosition), this.fGM)});
        return m.c(this.oPE.rT(selectedItemPosition), this.fGM);
    }

    protected final void bE(View view) {
        x.d(x.a(getWindow(), null), this.uSU.uTa);
        ((ViewGroup) this.uSU.uTa.getParent()).removeView(this.uSU.uTa);
        ((ViewGroup) getWindow().getDecorView()).addView(this.uSU.uTa, 0);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED == i && -1 == i2) {
            String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
            final String stringExtra2 = intent == null ? null : intent.getStringExtra("custom_send_text");
            if (!bg.mA(stringExtra)) {
                final List f = bg.f(stringExtra.split(","));
                if (bg.bV(f)) {
                    w.w("MicroMsg.ShowImageUI", "want to send record msg, but toUser is null");
                    return;
                }
                final Dialog a = g.a(this.uSU.uTo, getString(R.l.eit), false, null);
                final Runnable anonymousClass10 = new Runnable(this) {
                    final /* synthetic */ RecordMsgImageUI oPH;

                    public final void run() {
                        a.dismiss();
                    }
                };
                ap.vL().D(new Runnable(this) {
                    final /* synthetic */ RecordMsgImageUI oPH;

                    public final void run() {
                        for (String str : f) {
                            com.tencent.mm.plugin.messenger.a.d.aJW().b(this.oPH.uSU.uTo, str, this.oPH.oPG, 0, "", "");
                            com.tencent.mm.plugin.messenger.a.d.aJW().cM(stringExtra2, str);
                        }
                        af.v(anonymousClass10);
                    }

                    public final String toString() {
                        return super.toString() + "|onActivityResult";
                    }
                });
                return;
            }
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void a(int i, com.tencent.mm.plugin.record.a.g gVar) {
        for (rm rmVar : this.kaa) {
            if (rmVar.lKv.equals(gVar.field_dataId)) {
                af.v(this.lGL);
                return;
            }
        }
    }
}
