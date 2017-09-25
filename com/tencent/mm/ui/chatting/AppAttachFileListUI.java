package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import junit.framework.Assert;

public class AppAttachFileListUI extends MMActivity implements com.tencent.mm.plugin.messenger.foundation.a.a.c.a {
    private OnItemClickListener kbd = new OnItemClickListener(this) {
        final /* synthetic */ AppAttachFileListUI vxI;

        {
            this.vxI = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            Intent intent = new Intent();
            intent.setClassName(this.vxI, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
            intent.putExtra("app_msg_id", ((c) this.vxI.vxA.get(i)).fTk.field_msgId);
            intent.setFlags(67108864);
            this.vxI.startActivity(intent);
        }
    };
    private OnScrollListener kzc = new OnScrollListener(this) {
        final /* synthetic */ AppAttachFileListUI vxI;

        {
            this.vxI = r1;
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 0 && !this.vxI.vxF && this.vxI.vxE && absListView.getLastVisiblePosition() == this.vxI.vxD.getCount()) {
                w.d("MicroMsg.AppAttachFileListUI", "need to add item");
                int e = this.vxI.vxH;
                new a().execute(new Integer[]{Integer.valueOf(e), Integer.valueOf(20)});
                AppAttachFileListUI.f(this.vxI);
            }
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    };
    private ArrayList<c> vxA;
    private HashSet<Long> vxB;
    private ListView vxC;
    private b vxD;
    private boolean vxE = true;
    private boolean vxF = false;
    private View vxG;
    private int vxH;

    private class a extends AsyncTask<Integer, Integer, List<au>> {
        final /* synthetic */ AppAttachFileListUI vxI;

        private a(AppAttachFileListUI appAttachFileListUI) {
            this.vxI = appAttachFileListUI;
        }

        protected final /* synthetic */ Object doInBackground(Object[] objArr) {
            Integer[] numArr = (Integer[]) objArr;
            int intValue = numArr[0].intValue();
            int intValue2 = numArr[1].intValue();
            String xL = m.xL();
            ap.yY();
            List D = com.tencent.mm.u.c.wT().D(xL, intValue, intValue2);
            this.vxI.vxH = intValue2 + this.vxI.vxH;
            return D;
        }

        protected final /* synthetic */ void onPostExecute(Object obj) {
            List list = (List) obj;
            super.onPostExecute(list);
            AppAttachFileListUI.g(this.vxI);
            this.vxI.ct(list);
            this.vxI.vxD.notifyDataSetChanged();
        }
    }

    private class b extends BaseAdapter {
        final /* synthetic */ AppAttachFileListUI vxI;

        private b(AppAttachFileListUI appAttachFileListUI) {
            this.vxI = appAttachFileListUI;
        }

        public final int getCount() {
            return this.vxI.vxA.size();
        }

        public final Object getItem(int i) {
            return this.vxI.vxA.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            d dVar;
            String str;
            if (view == null) {
                view = this.vxI.getLayoutInflater().inflate(R.i.cTN, viewGroup, false);
                Assert.assertNotNull(view);
                dVar = new d(this.vxI);
                dVar.vxK = (MMImageView) view.findViewById(R.h.bPA);
                dVar.vxL = (TextView) view.findViewById(R.h.bPC);
                dVar.vxM = (TextView) view.findViewById(R.h.bPz);
                dVar.vxN = (TextView) view.findViewById(R.h.bPB);
                view.setTag(dVar);
            } else {
                dVar = (d) view.getTag();
            }
            Assert.assertNotNull(dVar);
            c cVar = (c) this.vxI.vxA.get(i);
            dVar.vxL.setText(cVar.vxJ.title);
            if (cVar.fTk.field_isSend == 1) {
                str = "自己";
            } else {
                str = n.eK(cVar.vxJ.fOu);
            }
            dVar.vxM.setText(String.format("大小：%s，来自：%s", new Object[]{bg.ay((long) cVar.vxJ.hhq), str}));
            dVar.vxN.setText(o.c(this.vxI, cVar.fTk.field_createTime, true));
            dVar.vxK.setImageResource(q.LV(cVar.vxJ.hhr));
            return view;
        }
    }

    private class c {
        public au fTk;
        final /* synthetic */ AppAttachFileListUI vxI;
        public com.tencent.mm.t.f.a vxJ;

        public c(AppAttachFileListUI appAttachFileListUI) {
            this.vxI = appAttachFileListUI;
        }
    }

    private class d {
        final /* synthetic */ AppAttachFileListUI vxI;
        public MMImageView vxK;
        public TextView vxL;
        public TextView vxM;
        public TextView vxN;

        public d(AppAttachFileListUI appAttachFileListUI) {
            this.vxI = appAttachFileListUI;
        }
    }

    static /* synthetic */ void f(AppAttachFileListUI appAttachFileListUI) {
        w.d("MicroMsg.AppAttachFileListUI", "start to load");
        appAttachFileListUI.vxF = true;
        appAttachFileListUI.vxG.setVisibility(0);
    }

    static /* synthetic */ void g(AppAttachFileListUI appAttachFileListUI) {
        appAttachFileListUI.vxF = false;
        appAttachFileListUI.vxG.setVisibility(8);
        w.d("MicroMsg.AppAttachFileListUI", "stop to load");
    }

    protected final int getLayoutId() {
        return R.i.cTO;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.ejZ);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AppAttachFileListUI vxI;

            {
                this.vxI = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.vxI.finish();
                return true;
            }
        });
        this.vxC = (ListView) findViewById(R.h.bPD);
        this.vxG = getLayoutInflater().inflate(R.i.cTM, null);
        this.vxC.addFooterView(this.vxG);
        this.vxG.setVisibility(8);
        this.vxA = new ArrayList();
        this.vxB = new HashSet();
        String xL = m.xL();
        ap.yY();
        List D = com.tencent.mm.u.c.wT().D(xL, 0, 20);
        this.vxH += 20;
        ct(D);
        this.vxD = new b();
        this.vxC.setAdapter(this.vxD);
        this.vxC.setOnItemClickListener(this.kbd);
        this.vxC.setOnScrollListener(this.kzc);
        ap.yY();
        com.tencent.mm.u.c.wT().a(this, getMainLooper());
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        ap.yY();
        com.tencent.mm.u.c.wT().a(this);
        super.onDestroy();
    }

    private void ct(List<au> list) {
        if (list.size() < 20) {
            this.vxE = false;
            this.vxC.removeFooterView(this.vxG);
        }
        for (au auVar : list) {
            c aa = aa(auVar);
            if (aa != null && aa.vxJ.type == 6 && this.vxB.add(Long.valueOf(auVar.field_msgId))) {
                this.vxA.add(aa);
            }
        }
        w.d("MicroMsg.AppAttachFileListUI", "append file item list size %d, current total size is %d", new Object[]{Integer.valueOf(list.size()), Integer.valueOf(this.vxA.size())});
    }

    private c aa(au auVar) {
        com.tencent.mm.t.f.a ek = com.tencent.mm.t.f.a.ek(auVar.field_content);
        if (ek == null) {
            return null;
        }
        c cVar = new c(this);
        cVar.fTk = auVar;
        cVar.vxJ = ek;
        return cVar;
    }

    public final void a(com.tencent.mm.plugin.messenger.foundation.a.a.c cVar, com.tencent.mm.plugin.messenger.foundation.a.a.c.c cVar2) {
        if ("insert".equals(cVar2.nyO)) {
            w.d("MicroMsg.AppAttachFileListUI", "reveive a msg");
            for (int size = cVar2.nyP.size() - 1; size >= 0; size--) {
                au auVar = (au) cVar2.nyP.get(size);
                if (auVar.axO()) {
                    c aa = aa(auVar);
                    if (aa != null && aa.vxJ.type == 6) {
                        this.vxA.add(0, aa);
                    }
                }
            }
            if (this.vxD != null) {
                this.vxD.notifyDataSetChanged();
            }
        }
    }
}
