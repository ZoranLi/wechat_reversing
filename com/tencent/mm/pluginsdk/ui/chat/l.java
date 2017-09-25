package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.m.a.e;
import com.tencent.mm.plugin.m.a.f;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.emoji.PreViewEmojiView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class l {
    private View Ih;
    private OnItemClickListener acN = new OnItemClickListener(this) {
        final /* synthetic */ l sQL;

        {
            this.sQL = r1;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            com.tencent.mm.storage.a.c ls = this.sQL.sQH == null ? null : this.sQL.sQH.ls(i);
            if (!(ls == null || this.sQL.sQC == null || this.sQL.sPo == null)) {
                this.sQL.sQC.n(ls);
                this.sQL.sPo.clear();
                g.oUh.i(10994, Integer.valueOf(1), this.sQL.sQD, "", Integer.valueOf(i), ls.EP(), Integer.valueOf(this.sQL.sQH.getCount()));
            }
            this.sQL.sQA.dismiss();
        }
    };
    private int jzd = 3;
    ArrayList<com.tencent.mm.storage.a.c> kRX = new ArrayList();
    public Context mContext;
    public ae mHandler = new ae(this) {
        final /* synthetic */ l sQL;

        {
            this.sQL = r1;
        }

        public final void handleMessage(Message message) {
            int i = 0;
            switch (message.what) {
                case 20001:
                    this.sQL.hide();
                    return;
                case 20002:
                    removeMessages(20001);
                    return;
                case 20003:
                    l lVar = this.sQL;
                    lVar.mHandler.removeMessages(20001);
                    if (lVar.sQF) {
                        b bVar = lVar.sQH;
                        bVar.mData = lVar.kRX;
                        bVar.notifyDataSetInvalidated();
                        if (lVar.kRX != null && lVar.kRX.size() > 2) {
                            lVar.sQA.setWidth(((int) (((double) lVar.sQy) * 2.5d)) + (lVar.sQz * 2));
                        } else if (lVar.kRX == null || lVar.kRX.size() != 2) {
                            lVar.sQA.setWidth(lVar.sQy + (lVar.sQz * 2));
                        } else {
                            lVar.sQA.setWidth((lVar.sQy * 2) + (lVar.sQz * 2));
                        }
                        lVar.bGd();
                        if (lVar.kRX == null || lVar.kRX.size() < 3) {
                            lVar.mHandler.sendEmptyMessageDelayed(20001, 3000);
                        } else {
                            lVar.mHandler.sendEmptyMessageDelayed(20001, 5000);
                        }
                        g gVar = g.oUh;
                        Object[] objArr = new Object[6];
                        objArr[0] = Integer.valueOf(0);
                        objArr[1] = lVar.sQD;
                        objArr[2] = "";
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = "";
                        if (lVar.kRX != null) {
                            i = lVar.kRX.size();
                        }
                        objArr[5] = Integer.valueOf(i);
                        gVar.i(10994, objArr);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    public a sPo;
    public o sQA;
    View sQB;
    public j sQC;
    public String sQD;
    public String sQE = "";
    public boolean sQF = true;
    private HorizontalListView sQG;
    public b sQH;
    private boolean sQI = true;
    private Comparator sQJ = new Comparator<com.tencent.mm.storage.a.c>(this) {
        final /* synthetic */ l sQL;

        {
            this.sQL = r1;
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            com.tencent.mm.storage.a.c cVar = (com.tencent.mm.storage.a.c) obj;
            com.tencent.mm.storage.a.c cVar2 = (com.tencent.mm.storage.a.c) obj2;
            if (cVar == null && cVar2 == null) {
                return 0;
            }
            if (cVar != null) {
                if (cVar2 == null) {
                    return 1;
                }
                if (cVar.field_lastUseTime == cVar2.field_lastUseTime) {
                    return 0;
                }
                if (cVar.field_lastUseTime > cVar2.field_lastUseTime) {
                    return 1;
                }
            }
            return -1;
        }
    };
    private com.tencent.mm.ui.base.HorizontalListView.a sQK = new com.tencent.mm.ui.base.HorizontalListView.a(this) {
        final /* synthetic */ l sQL;

        {
            this.sQL = r1;
        }

        public final boolean F(MotionEvent motionEvent) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.sQL.mHandler.sendEmptyMessage(20002);
                    break;
                case 1:
                case 3:
                    this.sQL.mHandler.sendEmptyMessageDelayed(20001, 3000);
                    break;
            }
            return false;
        }
    };
    public int sQy;
    int sQz;

    class AnonymousClass6 implements Runnable {
        final /* synthetic */ String hRW;
        final /* synthetic */ l sQL;

        public AnonymousClass6(l lVar, String str) {
            this.sQL = lVar;
            this.hRW = str;
        }

        public final void run() {
            if (this.sQL.ba(this.hRW)) {
                this.sQL.mHandler.sendEmptyMessage(20003);
                return;
            }
            this.sQL.mHandler.removeMessages(20003);
            this.sQL.mHandler.sendEmptyMessage(20001);
        }
    }

    public interface a {
        void clear();
    }

    class b extends BaseAdapter {
        ArrayList<com.tencent.mm.storage.a.c> mData;
        final /* synthetic */ l sQL;

        b(l lVar) {
            this.sQL = lVar;
        }

        public final /* synthetic */ Object getItem(int i) {
            return ls(i);
        }

        public final int getCount() {
            return this.mData == null ? 0 : this.mData.size();
        }

        public final com.tencent.mm.storage.a.c ls(int i) {
            if (this.mData == null || this.mData.size() <= i) {
                return null;
            }
            return (com.tencent.mm.storage.a.c) this.mData.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(this.sQL.mContext).inflate(f.lal, null);
                c cVar2 = new c(this.sQL, view);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            com.tencent.mm.storage.a.c ls = ls(i);
            cVar.kOy.hP = this.sQL.sQy;
            cVar.kOy.setScaleType(ScaleType.CENTER_INSIDE);
            CharSequence ue = ((PluginEmoji) h.j(PluginEmoji.class)).getEmojiMgr().ue(ls.EP());
            if (bg.mA(ue)) {
                cVar.kOy.setContentDescription(this.sQL.mContext.getString(com.tencent.mm.plugin.m.a.g.edO));
            } else {
                cVar.kOy.setContentDescription(ue);
            }
            if (ls == null) {
                w.w("MicroMsg.emoji.SuggestEmoticonBubble", "emoji info is null.");
            } else if (ls.bNt()) {
                cVar.kOy.a(com.tencent.mm.storage.a.c.bc(this.sQL.mContext, ls.getName()), ls.getName());
            } else {
                cVar.kOy.a(ls, "");
            }
            return view;
        }
    }

    class c {
        PreViewEmojiView kOy;
        final /* synthetic */ l sQL;

        public c(l lVar, View view) {
            this.sQL = lVar;
            this.kOy = (PreViewEmojiView) view.findViewById(e.lai);
            this.kOy.hP = lVar.sQy;
        }
    }

    public l(Context context) {
        this.mContext = context;
        this.Ih = View.inflate(this.mContext, f.lak, null);
        this.sQG = (HorizontalListView) this.Ih.findViewById(e.laj);
        this.sQH = new b(this);
        this.sQG.setAdapter(this.sQH);
        this.sQG.setOnItemClickListener(this.acN);
        this.sQG.setOnItemSelectedListener(new OnItemSelectedListener(this) {
            final /* synthetic */ l sQL;

            {
                this.sQL = r1;
            }

            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                w.d("MicroMsg.emoji.SuggestEmoticonBubble", "onItemSelected ...");
            }

            public final void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.sQG.sQK = this.sQK;
        this.sQy = com.tencent.mm.bg.a.T(this.mContext, com.tencent.mm.plugin.m.a.c.kZZ);
        this.sQz = com.tencent.mm.bg.a.T(this.mContext, com.tencent.mm.plugin.m.a.c.aXz);
        this.sQA = new o(this.Ih, this.sQy + (this.sQz * 2), this.sQy + (this.sQz * 2), true);
        this.sQA.setBackgroundDrawable(new ColorDrawable(0));
        this.sQA.setOutsideTouchable(true);
        this.sQA.setFocusable(false);
    }

    public final void bGd() {
        if (this.sQB != null) {
            int[] iArr = new int[2];
            this.sQB.getLocationOnScreen(iArr);
            this.sQA.showAtLocation(this.sQB, 0, iArr[0] - ((this.sQA.getWidth() - this.sQB.getWidth()) / 2), iArr[1] - this.sQA.getHeight());
        }
    }

    public final void hide() {
        if (this.sQA != null && this.sQA.isShowing()) {
            this.sQA.dismiss();
        }
    }

    public final boolean ba(String str) {
        try {
            if (!bg.mA(str)) {
                ArrayList ug = ((PluginEmoji) h.j(PluginEmoji.class)).getEmojiMgr().ug(str);
                if (!(ug == null || ug.isEmpty())) {
                    this.sQD = str.replaceAll(",", "");
                    if (ug == null || ug.isEmpty()) {
                        return false;
                    }
                    com.tencent.mm.storage.a.c ub;
                    ArrayList arrayList = new ArrayList();
                    this.kRX.clear();
                    int size = ug.size();
                    int i = 0;
                    while (i < size && i < 100) {
                        ub = ((PluginEmoji) h.j(PluginEmoji.class)).getEmojiMgr().ub((String) ug.get(i));
                        if (ub != null) {
                            arrayList.add(ub);
                        }
                        i++;
                    }
                    if (arrayList.isEmpty()) {
                        w.i("MicroMsg.emoji.SuggestEmoticonBubble", "sorEmojiList return. empty list.");
                        return false;
                    }
                    if (this.sQI) {
                        ub = (com.tencent.mm.storage.a.c) Collections.max(arrayList, this.sQJ);
                        this.kRX.add(ub);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            com.tencent.mm.storage.a.c cVar = (com.tencent.mm.storage.a.c) it.next();
                            if (!(cVar.bA(ub) || this.kRX.contains(cVar))) {
                                this.kRX.add(cVar);
                            }
                        }
                    } else {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            ub = (com.tencent.mm.storage.a.c) it2.next();
                            if (!this.kRX.contains(ub)) {
                                this.kRX.add(ub);
                            }
                        }
                    }
                    return (this.kRX == null || this.kRX.isEmpty()) ? false : true;
                }
            }
        } catch (Throwable e) {
            w.e("MicroMsg.emoji.SuggestEmoticonBubble", bg.g(e));
        }
        this.sQD = "";
        return false;
    }
}
