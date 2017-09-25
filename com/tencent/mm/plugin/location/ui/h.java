package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.location.model.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;
import java.util.Iterator;

public final class h {
    public Context context;
    private String kwe = "";
    private int lMV;
    private ae mHandler = new ae(Looper.getMainLooper());
    private boolean mIsInit = false;
    public MMHorList ndU;
    a ndV;
    public c ndW = null;

    class a extends BaseAdapter {
        final /* synthetic */ h ndX;
        ArrayList<b> ndZ = new ArrayList();

        public a(h hVar, ArrayList<b> arrayList) {
            this.ndX = hVar;
            this.ndZ.addAll(arrayList);
        }

        public final int getCount() {
            return this.ndZ.size();
        }

        public final Object getItem(int i) {
            return this.ndZ.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            return ((b) this.ndZ.get(i)).nec.ned;
        }

        public final b zx(String str) {
            for (int i = 0; i < this.ndZ.size(); i++) {
                if (((b) this.ndZ.get(i)).username.equals(str)) {
                    return (b) this.ndZ.get(i);
                }
            }
            return null;
        }

        public final boolean zy(String str) {
            for (int i = 0; i < this.ndZ.size(); i++) {
                if (((b) this.ndZ.get(i)).username.equals(str)) {
                    return true;
                }
            }
            return false;
        }

        public final ArrayList<String> aGB() {
            ArrayList<String> arrayList = new ArrayList();
            Iterator it = this.ndZ.iterator();
            while (it.hasNext()) {
                arrayList.add(((b) it.next()).username);
            }
            return arrayList;
        }
    }

    class b {
        final /* synthetic */ h ndX;
        boolean nea = false;
        private LayoutParams neb;
        a nec;
        String username;

        class a {
            ImageView iqx;
            RelativeLayout ned;
            final /* synthetic */ b nee;

            a(b bVar) {
                this.nee = bVar;
            }
        }

        public b(h hVar, String str) {
            this.ndX = hVar;
            this.username = str;
            if (bg.mA(str)) {
                w.e("MicroMsg.ShareHeaderAvatarViewMgr", "init HeaderAvatar, username can't not be null");
                return;
            }
            this.nec = new a(this);
            LayoutInflater layoutInflater = (LayoutInflater) this.ndX.context.getSystemService("layout_inflater");
            this.nec.ned = (RelativeLayout) layoutInflater.inflate(R.i.dgR, null);
            this.nec.iqx = (ImageView) this.nec.ned.findViewById(R.h.bqG);
            com.tencent.mm.pluginsdk.ui.a.b.m(this.nec.iqx, this.username);
            this.nec.ned.setTag(this.username);
            this.neb = new LayoutParams(-2, -2);
            this.neb.leftMargin = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.ndX.context, 5.0f);
            this.neb.rightMargin = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.ndX.context, 5.0f);
            this.neb.gravity = 17;
        }

        public final void aGC() {
            w.i("MicroMsg.ShareHeaderAvatarViewMgr", "setTalking, username=%s", new Object[]{this.username});
            this.nec.ned.setBackgroundResource(R.g.bgq);
            this.nec.ned.invalidate();
            this.nea = true;
        }

        public final void aGD() {
            w.i("MicroMsg.ShareHeaderAvatarViewMgr", "exitTalking, username=%s", new Object[]{this.username});
            this.nec.ned.setBackgroundResource(R.g.bgp);
            this.nec.ned.invalidate();
            this.nea = false;
        }
    }

    public interface c {
        void zz(String str);
    }

    public h(Context context, View view, String str) {
        this.context = context;
        this.ndU = (MMHorList) view;
        this.kwe = str;
        aGz();
    }

    private void aGz() {
        w.d("MicroMsg.ShareHeaderAvatarViewMgr", "initAvatarList, memebers.size=%d", new Object[]{Integer.valueOf(l.aGf().zq(this.kwe).size())});
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (String str : r0) {
            if (!bg.mA(str)) {
                arrayList.add(new b(this, str));
                arrayList2.add(str);
            }
        }
        H(arrayList);
        I(arrayList2);
        this.ndU.invalidate();
        this.ndV.notifyDataSetChanged();
    }

    private void H(ArrayList<b> arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.nea) {
                bVar.aGC();
            }
        }
        this.lMV = com.tencent.mm.bg.a.fromDPToPix(this.context, 60);
        this.ndU.vkI = true;
        this.ndU.vkJ = this.lMV;
        this.ndU.vkH = true;
        this.ndU.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ h ndX;

            {
                this.ndX = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                String str = (String) view.getTag();
                if (!bg.mA(str)) {
                    g.oUh.i(10997, new Object[]{"15", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
                    if (this.ndX.ndW != null) {
                        this.ndX.ndW.zz(str);
                    }
                }
            }
        });
        this.ndV = new a(this, arrayList);
        this.ndU.setAdapter(this.ndV);
    }

    private void zu(String str) {
        w.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberEnter, usernmae=%s", new Object[]{str});
        if (!this.ndV.zy(str)) {
            b bVar = new b(this, str);
            a aVar = this.ndV;
            aVar.ndZ.add(bVar);
            aVar.notifyDataSetChanged();
            this.ndU.invalidate();
        }
    }

    private void zv(String str) {
        w.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberExit, username=%s", new Object[]{str});
        if (this.ndV.zy(str)) {
            a aVar = this.ndV;
            int i = 0;
            while (i < aVar.ndZ.size()) {
                if (((b) aVar.ndZ.get(i)).username.equals(str)) {
                    break;
                }
                i++;
            }
            i = -1;
            if (i != -1) {
                aVar.ndZ.remove(i);
                aVar.notifyDataSetChanged();
            }
            this.ndU.invalidate();
        }
    }

    public final void zw(String str) {
        int i = 0;
        w.d("MicroMsg.ShareHeaderAvatarViewMgr", "onMemberTalk, username=%s", new Object[]{str});
        if (this.ndV.zy(str)) {
            this.ndV.zx(str).aGC();
            this.ndV.notifyDataSetChanged();
            this.ndU.invalidate();
            if (!this.ndU.nUI && !bg.mA(str)) {
                a aVar = this.ndV;
                int i2 = 0;
                while (i2 < aVar.ndZ.size()) {
                    if (((b) aVar.ndZ.get(i2)).username.equals(str)) {
                        break;
                    }
                    i2++;
                }
                i2 = -1;
                w.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker, index=%d", new Object[]{Integer.valueOf(i2)});
                if (i2 != -1) {
                    int i3 = i2 * this.lMV;
                    int i4 = this.ndU.vkv;
                    if (i3 >= i4) {
                        i4 = i3 > i4 + (this.lMV * 3) ? i3 - (this.lMV * 3) : 0;
                    }
                    if (i2 != 0) {
                        i = i4;
                    }
                    this.mHandler.post(new Runnable(this) {
                        final /* synthetic */ h ndX;

                        public final void run() {
                            w.d("MicroMsg.ShareHeaderAvatarViewMgr", "scrollToTalker pos=%d", new Object[]{Integer.valueOf(i)});
                            this.ndX.ndU.Aj(i);
                        }
                    });
                }
            }
        }
    }

    public final void aGA() {
        a aVar = this.ndV;
        Iterator it = aVar.ndZ.iterator();
        while (it.hasNext()) {
            ((b) it.next()).aGD();
        }
        aVar.notifyDataSetChanged();
        this.ndU.invalidate();
    }

    public final void I(ArrayList<String> arrayList) {
        Iterator it;
        w.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, members.size=%d", new Object[]{Integer.valueOf(arrayList.size())});
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList aGB = this.ndV.aGB();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (aGB.indexOf(str) == -1) {
                arrayList2.add(str);
            }
        }
        Iterator it3 = aGB.iterator();
        while (it3.hasNext()) {
            str = (String) it3.next();
            if (arrayList.indexOf(str) == -1) {
                arrayList3.add(str);
            }
        }
        w.d("MicroMsg.ShareHeaderAvatarViewMgr", "onRefreshMemberList, newMember.size=%d, removeMember.size=%d", new Object[]{Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList3.size())});
        if (arrayList2.size() > 0) {
            it = arrayList2.iterator();
            while (it.hasNext()) {
                zu((String) it.next());
            }
        }
        if (arrayList3.size() > 0) {
            it = arrayList3.iterator();
            while (it.hasNext()) {
                zv((String) it.next());
            }
        }
    }
}
