package com.tencent.mm.plugin.brandservice.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.e;
import com.tencent.mm.modelbiz.l;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.plugin.brandservice.a.k;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.base.VerticalScrollBar;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.contact.u;
import com.tencent.mm.ui.widget.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BrandServiceSortView extends BaseSortView implements OnCreateContextMenuListener, OnItemLongClickListener, com.tencent.mm.plugin.brandservice.a.d.a, com.tencent.mm.plugin.brandservice.ui.base.BaseSortView.a {
    private boolean Ua;
    private String jia;
    private int kaQ = 0;
    private int kaR = 0;
    private g kaU;
    public boolean kaz;
    private ListView kbG;
    private HashMap<String, SpannableString> kbU = new HashMap();
    private d kbV = new d();
    private int kbW = 251658241;
    private boolean kbX = false;
    public a kbY;
    private String kbZ;
    private View kca;
    private TextView kcb;
    private n.d kcc = new n.d(this) {
        final /* synthetic */ BrandServiceSortView kcd;

        {
            this.kcd = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            if (bg.mA(this.kcd.jia)) {
                w.i("MicroMsg.BrandServiceSortView", "username is null or nil.");
            } else if (menuItem.getItemId() == 0) {
                w.i("MicroMsg.BrandServiceSortView", "Menu Item selected, pos(%d)", new Object[]{Integer.valueOf(i)});
                ap.yY();
                x Rc = c.wR().Rc(this.kcd.jia);
                BrandServiceSortView.a(this.kcd, e.hW(this.kcd.jia), this.kcd.getContext(), Rc, menuItem.getGroupId());
            }
        }
    };

    public interface a {
        boolean ael();
    }

    public static class b implements com.tencent.mm.modelbiz.l.a.a {
        static Bitmap kcf = null;
        String iconUrl;
        public View ipu;
        ImageView ipv;
        TextView jWd;
        public TextView jZy;
        ImageView kaZ;
        View kba;
        String username;

        public b() {
            com.tencent.mm.modelbiz.w.DP().a(this);
        }

        public final void aey() {
            if (this.ipv != null) {
                Bitmap b = l.b(this.username, this.iconUrl, 0);
                if (b == null) {
                    this.ipv.setImageResource(R.g.bcY);
                } else if (bg.mA(this.username) || this.ipv.getTag() == null) {
                    w.e("MicroMsg.BrandServiceSortView", "error in refreshAvatar, %s", new Object[]{this.username});
                } else if (this.username.equals(this.ipv.getTag())) {
                    this.ipv.setImageBitmap(b);
                }
            }
        }

        public final void in(String str) {
            if (str != null && str.equals(this.username)) {
                af.v(new Runnable(this) {
                    final /* synthetic */ b kcg;

                    {
                        this.kcg = r1;
                    }

                    public final void run() {
                        this.kcg.aey();
                    }
                });
            }
        }
    }

    static /* synthetic */ void a(BrandServiceSortView brandServiceSortView, TextView textView, Context context, String str, int i) {
        if (textView == null) {
            w.w("MicroMsg.BrandServiceSortView", "display area is null");
        } else if (bg.mA(str)) {
            w.w("MicroMsg.BrandServiceSortView", "remark is null");
        } else {
            SpannableString spannableString = (SpannableString) brandServiceSortView.kbU.get(str);
            if (spannableString == null) {
                try {
                    w.d("MicroMsg.BrandServiceSortView", "new one %s", new Object[]{str});
                    CharSequence spannableString2 = new SpannableString(h.c(context, str, i));
                    brandServiceSortView.kbU.put(str, spannableString2);
                    textView.setText(spannableString2);
                    return;
                } catch (Exception e) {
                    w.w("MicroMsg.BrandServiceSortView", "error, set empty str");
                    textView.setText("");
                    return;
                }
            }
            w.v("MicroMsg.BrandServiceSortView", "match one %s", new Object[]{str});
            textView.setText(spannableString);
        }
    }

    static /* synthetic */ void a(BrandServiceSortView brandServiceSortView, BizInfo bizInfo, final Context context, x xVar, final int i) {
        w.i("MicroMsg.BrandServiceSortView", "showRemoveBizAlertDialog");
        if (bizInfo == null || context == null || !(context instanceof Activity) || xVar == null) {
            w.e("MicroMsg.BrandServiceSortView", "bizInfo(%s) or context(%s) or contact(%s) is null", new Object[]{bizInfo, context, xVar});
            return;
        }
        final String str = xVar.field_username;
        ap.vL().D(new Runnable(brandServiceSortView) {
            final /* synthetic */ BrandServiceSortView kcd;

            public final void run() {
                BizInfo hO = com.tencent.mm.modelbiz.w.DH().hO(str);
                ap.yY();
                ((f) com.tencent.mm.kernel.h.h(f.class)).a(hO, (Activity) context, c.wR().Rc(str), false, new Runnable(this) {
                    final /* synthetic */ AnonymousClass4 kce;

                    {
                        this.kce = r1;
                    }

                    public final void run() {
                        List list = this.kce.kcd.kbI.kbK;
                        if (i >= 0 && list != null && i < list.size()) {
                            list.remove(i);
                            af.v(this.kce.kcd.kbI.kcj);
                        }
                    }
                });
            }
        });
    }

    public BrandServiceSortView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        L(false);
        refresh();
        d dVar = this.kbV;
        if (!(this == null || dVar.jZe.contains(this))) {
            w.i("MicroMsg.BrandService.BrandServiceMgr", "addListener:add");
            dVar.jZe.add(this);
        }
        this.kaU = new g(getContext());
        this.kbN = this;
        this.acN = new OnItemClickListener(this) {
            final /* synthetic */ BrandServiceSortView kcd;

            {
                this.kcd = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Object tag = view.getTag();
                if (tag == null || !(tag instanceof b)) {
                    w.w("MicroMsg.BrandServiceSortView", "view tag is null or is not a instance of ResHolder.");
                    return;
                }
                b bVar = (b) tag;
                if (bg.mA(bVar.username)) {
                    w.w("MicroMsg.BrandServiceSortView", "username is null or nil.");
                    return;
                }
                com.tencent.mm.as.f.jY(bVar.username);
                u.h(this.kcd.kbZ, 12, 4, i - 1);
                if (this.kcd.kaz) {
                    Intent intent = new Intent();
                    intent.putExtra("Select_Contact", bVar.username);
                    intent.putExtra("Select_Conv_User", bVar.username);
                    if (this.kcd.getContext() instanceof Activity) {
                        Activity activity = (Activity) this.kcd.getContext();
                        activity.setResult(-1, intent);
                        activity.finish();
                        return;
                    }
                }
                String str = bVar.username;
                Context context = this.kcd.getContext();
                w.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
                Intent putExtra = new Intent().putExtra("Chat_User", str);
                putExtra.putExtra("finish_direct", true);
                putExtra.putExtra("img_gallery_enter_from_chatting_ui", true);
                com.tencent.mm.plugin.brandservice.a.imv.e(putExtra, context);
            }
        };
        this.kbJ = this;
    }

    public final void refresh() {
        List list;
        List list2;
        this.kbV.init();
        d dVar = this.kbV;
        switch (this.kbW) {
            case 2:
                list = dVar.jZg;
                break;
            default:
                list = dVar.jZh;
                break;
        }
        if (list != null) {
            List arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) list.get(i);
                if (!(bVar == null || bVar.jiL == null)) {
                    f fVar = new f();
                    fVar.data = bVar;
                    int i2 = bVar.jiL.field_showHead;
                    if (i2 >= 97 && i2 <= 122) {
                        i2 -= 32;
                    }
                    if (i2 < 65 || i2 > 90) {
                        fVar.kcl = "#";
                    } else {
                        fVar.kcl = ((char) i2);
                    }
                    arrayList.add(fVar);
                }
            }
            list2 = arrayList;
        } else {
            list2 = null;
        }
        W(list2);
        super.refresh();
    }

    public final void release() {
        if (ap.zb()) {
            com.tencent.mm.modelbiz.w.DP().DB();
        }
        d dVar = this.kbV;
        if (this == null) {
            w.w("MicroMsg.BrandService.BrandServiceMgr", "removeListener:onChange is null");
            dVar.jZe.remove(null);
        }
        d dVar2 = this.kbV;
        ap.vd().b(387, dVar2);
        if (dVar2.jZf) {
            List arrayList = new ArrayList(dVar2.jZg.size() + dVar2.jZh.size());
            for (com.tencent.mm.plugin.brandservice.a.b add : dVar2.jZg) {
                arrayList.add(add);
            }
            for (com.tencent.mm.plugin.brandservice.a.b add2 : dVar2.jZh) {
                arrayList.add(add2);
            }
            ap.vd().a(new k(arrayList), 0);
        }
    }

    public final boolean a(String str, f fVar) {
        if (!(bg.mA(str) || fVar == null)) {
            this.kbZ = str;
            com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) fVar.data;
            if (bVar == null || bVar.jiL == null) {
                w.w("MicroMsg.BrandServiceSortView", "BrandServiceItem or contact is null.");
                return false;
            }
            x xVar = bVar.jiL;
            String tL = xVar.tL();
            String pB = xVar.pB();
            String pC = xVar.pC();
            String toUpperCase = str.toUpperCase();
            if (!(bg.mA(tL) || tL.toUpperCase().indexOf(toUpperCase) == -1) || (!(bg.mA(pB) || pB.toUpperCase().indexOf(toUpperCase) == -1) || (!bg.mA(pC) && pC.toUpperCase().startsWith(toUpperCase)))) {
                return true;
            }
        }
        return false;
    }

    public final View inflate() {
        return View.inflate(getContext(), R.i.cWc, this);
    }

    public final VerticalScrollBar aen() {
        return (VerticalScrollBar) findViewById(R.h.cFm);
    }

    public final ListView getListView() {
        this.kbG = (ListView) findViewById(R.h.cbx);
        if (this.kca == null) {
            this.kca = inflate(getContext(), R.i.cZR, null);
            if (!(this.kbG == null || this.kca == null)) {
                this.kcb = (TextView) this.kca.findViewById(R.h.bGN);
                this.kbG.addFooterView(this.kca, null, false);
            }
        }
        return this.kbG;
    }

    public final View aeo() {
        return findViewById(R.h.coo);
    }

    public final com.tencent.mm.plugin.brandservice.ui.base.e.a aep() {
        return new com.tencent.mm.plugin.brandservice.ui.base.e.a(this) {
            final /* synthetic */ BrandServiceSortView kcd;

            {
                this.kcd = r1;
            }

            public final View a(f fVar, View view, boolean z, boolean z2) {
                b bVar;
                long NA = bg.NA();
                Context context = this.kcd.getContext();
                if (view == null) {
                    view = LayoutInflater.from(context).inflate(R.i.cWb, null);
                    bVar = new b();
                    bVar.jZy = (TextView) view.findViewById(R.h.byO);
                    bVar.ipu = view.findViewById(R.h.bGx);
                    bVar.ipv = (ImageView) view.findViewById(R.h.boO);
                    bVar.kaZ = (ImageView) view.findViewById(R.h.cnM);
                    bVar.jWd = (TextView) view.findViewById(R.h.buQ);
                    bVar.kba = view.findViewById(R.h.cCn);
                    view.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                com.tencent.mm.plugin.brandservice.a.b bVar2 = (com.tencent.mm.plugin.brandservice.a.b) fVar.data;
                if (bVar2 == null) {
                    w.e("MicroMsg.BrandServiceSortView", "should not be empty");
                } else {
                    if (this.kcd.kbL && z) {
                        bVar.jZy.setText(fVar.kcl);
                        bVar.jZy.setVisibility(0);
                    } else {
                        bVar.jZy.setVisibility(8);
                    }
                    bVar.username = bVar2.userName;
                    bVar.iconUrl = bVar2.jZc.field_brandIconURL;
                    bVar.ipv.setTag(bVar2.userName);
                    bVar.aey();
                    BrandServiceSortView.a(this.kcd, bVar.jWd, context, bVar2.jiL.tL(), (int) bVar.jWd.getTextSize());
                    w.v("MicroMsg.BrandServiceSortView", "bizinfo status%d", new Object[]{Integer.valueOf(bVar2.jZc.field_status)});
                    ImageView imageView = bVar.kaZ;
                    int i = (this.kcd.kbX && bVar2.jZc.field_status == 1) ? 0 : 8;
                    imageView.setVisibility(i);
                    if (this.kcd.mMode == 0 && z2) {
                        bVar.kba.setBackgroundResource(R.g.bep);
                    } else {
                        bVar.kba.setBackgroundResource(R.g.bgh);
                    }
                    if (this.kcd.kbM) {
                        bVar.ipu.setPadding(bVar.ipu.getPaddingLeft(), bVar.ipu.getPaddingTop(), (int) this.kcd.getContext().getResources().getDimension(R.f.aWz), bVar.ipu.getPaddingBottom());
                    } else {
                        bVar.ipu.setPadding(bVar.ipu.getPaddingLeft(), bVar.ipu.getPaddingTop(), (int) this.kcd.getContext().getResources().getDimension(R.f.aXH), bVar.ipu.getPaddingBottom());
                    }
                    w.v("MicroMsg.BrandServiceSortView", "get view use %d ms", new Object[]{Long.valueOf(bg.aB(NA))});
                }
                return view;
            }
        };
    }

    public final void adZ() {
        refresh();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.kaQ = (int) motionEvent.getRawX();
            this.kaR = (int) motionEvent.getRawY();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.kaU.wvD = view;
        this.kaU.a(adapterView, i, j, this, this.kcc, this.kaQ, this.kaR);
        return true;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (contextMenuInfo == null) {
            w.i("MicroMsg.BrandServiceSortView", "menuInfo is null.");
            return;
        }
        w.i("MicroMsg.BrandServiceSortView", "onCreateContextMenu");
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        f fVar = (f) ((AdapterView) view).getItemAtPosition(adapterContextMenuInfo.position);
        if (fVar == null || fVar.data == null) {
            w.i("MicroMsg.BrandServiceSortView", "SortEntity(%s) is null or its data is null.", new Object[]{fVar});
            return;
        }
        com.tencent.mm.e.b.af afVar = ((com.tencent.mm.plugin.brandservice.a.b) fVar.data).jiL;
        if (afVar == null) {
            w.e("MicroMsg.BrandServiceSortView", "onCreateContextMenu, contact is null");
            return;
        }
        this.jia = afVar.field_username;
        contextMenu.setHeaderTitle(h.a(getContext(), afVar.tL()));
        BizInfo hW = e.hW(afVar.field_username);
        if (hW != null && !hW.CG()) {
            contextMenu.add(adapterContextMenuInfo.position, 0, 0, R.l.eyW);
        }
    }

    public final void X(List<f> list) {
        if (this.kcb != null && list != null) {
            this.kcb.setText(getContext().getString(R.l.dPI, new Object[]{Integer.valueOf(list.size())}));
        }
    }

    public final void L(boolean z) {
        this.Ua = z;
        BaseSortView.i(this.kcb, z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.kbY != null) {
            this.kbY.ael();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
