package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ah.n;
import com.tencent.mm.plugin.record.ui.b.c;
import com.tencent.mm.plugin.record.ui.b.d;
import com.tencent.mm.plugin.record.ui.b.e;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.ro;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.u.o;
import java.util.LinkedList;
import java.util.List;

public abstract class h extends BaseAdapter {
    ListView Fg;
    protected Context context;
    private Runnable lGL = new Runnable(this) {
        final /* synthetic */ h oPk;

        {
            this.oPk = r1;
        }

        public final void run() {
            w.d("MicroMsg.RecordMsgBaseAdapter", "refresh adapter");
            this.oPk.notifyDataSetChanged();
        }
    };
    protected List<rm> oOQ = new LinkedList();
    protected ae oPe = null;
    SparseArray<b> oPf = new SparseArray();
    boolean oPg = false;
    private boolean oPh = false;
    protected a oPi;
    protected a oPj;
    private int padding = com.tencent.mm.bg.a.fromDPToPix(this.context, 35);

    public interface a {

        public static class a {
            public rm fKe;
            public ImageView fKf;
            public int fKg;
            public int height;
            public long oPl;
            public int width;
        }

        public static class b {
            public rm fKe;
            public boolean fKh;
            public boolean fKi;
            public int maxWidth;
            public long oPl;
        }

        public static class c {
            public rm fKe;
            public long oPl;
        }

        Bitmap a(b bVar);

        Bitmap a(c cVar);

        void a(a aVar);

        void aWI();
    }

    public interface b {
        void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar);

        View cJ(Context context);

        void destroy();

        void pause();
    }

    public abstract void a(a aVar);

    public abstract void d(com.tencent.mm.plugin.record.ui.a.b bVar);

    public /* synthetic */ Object getItem(int i) {
        return rT(i);
    }

    public h(Context context, a aVar) {
        this.context = context;
        this.oPe = new ae(this, Looper.getMainLooper()) {
            final /* synthetic */ h oPk;

            public final void handleMessage(Message message) {
                if (message.what == 1) {
                    w.d("MicroMsg.RecordMsgBaseAdapter", "do play music");
                    this.oPk.notifyDataSetChanged();
                }
            }
        };
        this.oPj = aVar;
    }

    public final void aWQ() {
        this.oPf.put(0, new d(this.context));
        this.oPf.put(1, new com.tencent.mm.plugin.record.ui.b.a(this.oPj, this.Fg));
        this.oPf.put(2, new e());
        this.oPf.put(3, new com.tencent.mm.plugin.record.ui.b.b(this.oPj, this.oPe));
        this.oPf.put(4, new c(this.oPj));
    }

    public final void destroy() {
        for (int i = 0; i < this.oPf.size(); i++) {
            b bVar = (b) this.oPf.valueAt(i);
            if (bVar != null) {
                bVar.destroy();
            }
        }
        if (this.oPj != null) {
            this.oPj.aWI();
            this.oPj = null;
        }
    }

    public int getItemViewType(int i) {
        return m(rT(i));
    }

    private static int m(rm rmVar) {
        switch (rmVar.aMw) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                return 3;
        }
    }

    public int getViewTypeCount() {
        return 5;
    }

    public int getCount() {
        return this.oOQ == null ? 0 : this.oOQ.size();
    }

    private rm rT(int i) {
        if (this.oOQ != null && i >= 0 && i < this.oOQ.size()) {
            return (rm) this.oOQ.get(i);
        }
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        com.tencent.mm.plugin.record.ui.a.b aVar;
        rm rT = rT(i);
        b bVar = (b) this.oPf.get(m(rT));
        if (view == null) {
            view = bVar.cJ(this.context);
        }
        switch (rT.aMw) {
            case 2:
                aVar = new com.tencent.mm.plugin.record.ui.a.a();
                break;
            case 15:
                aVar = new com.tencent.mm.plugin.record.ui.a.c();
                break;
            default:
                aVar = new com.tencent.mm.plugin.record.ui.a.b();
                break;
        }
        aVar.fKe = rT;
        d(aVar);
        bVar.a(view, i, aVar);
        ImageView imageView = (ImageView) view.findViewById(R.h.cxd);
        TextView textView = (TextView) view.findViewById(R.h.cxh);
        textView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(textView.getContext(), rT.tye, textView.getTextSize()));
        textView = (TextView) view.findViewById(R.h.cxg);
        w.d("MicroMsg.RecordMsgBaseAdapter", "datasrctime %s", new Object[]{rT.tyg});
        if (rT.tyg != null) {
            if (this.oPg) {
                String str = rT.tyg;
                textView.setText(str.substring(str.indexOf("-") + 1));
            } else {
                String[] split = rT.tyg.split(" ");
                if (split.length < 2) {
                    textView.setText(rT.tyg);
                } else {
                    textView.setText(split[1]);
                }
            }
        }
        if (i == 0) {
            if (rT.tyc != null) {
                ro roVar = rT.tyc.tyu;
                imageView.setVisibility(0);
                if (roVar.tyR) {
                    Dr(roVar.tyQ);
                    if (com.tencent.mm.modelbiz.a.e.ir(roVar.tyQ)) {
                        n.GW().a(com.tencent.mm.modelbiz.a.e.iu(roVar.tyQ), imageView);
                    } else {
                        com.tencent.mm.pluginsdk.ui.a.b.a(imageView, roVar.tyQ);
                    }
                } else if (!roVar.tyM || (m.xL().equals(roVar.fOu) && roVar.fOu.equals(roVar.toUser))) {
                    imageView.setVisibility(8);
                    view.setPadding(this.padding, view.getPaddingTop(), this.padding, view.getPaddingBottom());
                    this.oPh = true;
                } else {
                    Dr(roVar.fOu);
                    com.tencent.mm.pluginsdk.ui.a.b.a(imageView, roVar.fOu);
                }
            } else {
                imageView.setVisibility(8);
                view.setPadding(this.padding, view.getPaddingTop(), this.padding, view.getPaddingBottom());
                this.oPh = true;
            }
        } else if (i <= 0 || this.oPh) {
            imageView.setVisibility(8);
            view.setPadding(this.padding, view.getPaddingTop(), this.padding, view.getPaddingBottom());
        } else {
            String str2 = "";
            ro roVar2 = rT.tyc.tyu;
            if (rT(i - 1).tyc.tyu.tyR) {
                str2 = rT(i - 1).tyc.tyu.tyQ;
            } else if (rT(i - 1).tyc.tyu.tyM) {
                str2 = rT(i - 1).tyc.tyu.fOu;
            }
            imageView.setVisibility(0);
            String str3;
            if (rT.tyc.tyu.tyR) {
                str3 = rT.tyc.tyu.tyQ;
                if (str2.equals(str3)) {
                    imageView.setVisibility(4);
                } else {
                    Dr(str3);
                    if (com.tencent.mm.modelbiz.a.e.ir(roVar2.tyQ)) {
                        n.GW().a(com.tencent.mm.modelbiz.a.e.iu(roVar2.tyQ), imageView);
                    } else {
                        com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str3);
                    }
                }
            } else if (rT.tyc.tyu.tyM) {
                str3 = rT.tyc.tyu.fOu;
                if (str2.equals(str3)) {
                    imageView.setVisibility(4);
                } else {
                    Dr(str3);
                    com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str3);
                }
            } else {
                imageView.setVisibility(4);
            }
        }
        if (i == getCount() - 1) {
            view.findViewById(R.h.cxf).setVisibility(8);
        } else {
            view.findViewById(R.h.cxf).setVisibility(0);
        }
        return view;
    }

    private static void Dr(String str) {
        if (!o.eU(str)) {
            com.tencent.mm.x.h hVar = new com.tencent.mm.x.h();
            hVar.username = str;
            com.tencent.mm.x.n.Bm().a(hVar);
        }
    }

    protected final void aWR() {
        this.oPe.post(this.lGL);
    }
}
