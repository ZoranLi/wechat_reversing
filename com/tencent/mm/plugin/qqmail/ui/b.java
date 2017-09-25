package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.h.d;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.p.c;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.plugin.qqmail.b.y;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.y.e;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b implements e {
    public int mode;
    private TextView oBP;
    private ImageView oBQ;
    private OnClickListener oDA;
    public ComposeUI oDt;
    public ViewGroup oDu;
    public Map<String, y> oDv;
    public Map<String, o> oDw;
    public Map<String, String> oDx;
    public Map<String, String> oDy;
    b oDz;

    private class a {
        ImageView jbU;
        TextView kzl;
        final /* synthetic */ b oDC;
        ProgressBar oDJ;
        TextView oDK;
        ImageView oDL;
        ImageView oDM;
        TextView oDc;

        public a(b bVar) {
            this.oDC = bVar;
        }
    }

    public interface b {
        void aUP();

        void onComplete();
    }

    private b(ComposeUI composeUI, TextView textView, ImageView imageView, ViewGroup viewGroup) {
        this.oDv = new HashMap();
        this.oDw = new HashMap();
        this.oDx = new LinkedHashMap();
        this.oDy = new LinkedHashMap();
        this.oDz = null;
        this.oDA = null;
        this.mode = 5;
        this.oDt = composeUI;
        this.oDu = viewGroup;
        this.oDA = null;
        this.oBP = textView;
        this.oBQ = imageView;
        aUZ();
        ap.vd().a(484, this);
    }

    public b(ComposeUI composeUI, TextView textView, ImageView imageView, ViewGroup viewGroup, byte b) {
        this(composeUI, textView, imageView, viewGroup);
    }

    public final void bd(List<y> list) {
        if (list != null) {
            for (y yVar : list) {
                a(yVar);
                this.oDv.put(yVar.path, yVar);
            }
            if (this.mode == 6) {
                for (y yVar2 : list) {
                    this.oDx.put(yVar2.path, yVar2.oBh);
                    this.oDy.put(yVar2.path, yVar2.name);
                }
            }
        }
    }

    public final void de(String str, String str2) {
        if (str != null && str.length() != 0 && !this.oDv.containsKey(str)) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                y yVar = new y();
                yVar.path = str;
                if (str2 == null) {
                    yVar.name = file.getName();
                } else {
                    yVar.name = str2;
                }
                yVar.size = file.length();
                yVar.state = 0;
                this.oDv.put(str, yVar);
                a(yVar);
            }
        }
    }

    private void a(final y yVar) {
        final LinearLayout linearLayout = (LinearLayout) ((ViewGroup) View.inflate(this.oDt, R.i.dlB, null)).findViewById(R.h.crQ);
        ImageView imageView = (ImageView) linearLayout.findViewById(R.h.crP);
        TextView textView = (TextView) linearLayout.findViewById(R.h.crR);
        TextView textView2 = (TextView) linearLayout.findViewById(R.h.crT);
        ProgressBar progressBar = (ProgressBar) linearLayout.findViewById(R.h.crU);
        TextView textView3 = (TextView) linearLayout.findViewById(R.h.crV);
        final ImageView imageView2 = (ImageView) linearLayout.findViewById(R.h.crS);
        ImageView imageView3 = (ImageView) linearLayout.findViewById(R.h.crO);
        ((ViewGroup) linearLayout.getParent()).removeView(linearLayout);
        imageView.setImageResource(FileExplorerUI.Nl(yVar.name));
        textView.setText(yVar.name);
        textView2.setText(bg.ay(yVar.size));
        a aVar = new a(this);
        aVar.jbU = imageView;
        aVar.kzl = textView;
        aVar.oDc = textView2;
        aVar.oDJ = progressBar;
        aVar.oDK = textView3;
        aVar.oDL = imageView2;
        aVar.oDM = imageView3;
        linearLayout.setTag(aVar);
        linearLayout.setId(Math.abs(yVar.path.hashCode() / 2));
        if (this.oDA != null) {
            linearLayout.setOnClickListener(this.oDA);
        }
        this.oDu.addView(linearLayout);
        aUZ();
        linearLayout.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b oDC;

            public final void onClick(View view) {
                if (imageView2.getVisibility() == 0) {
                    imageView2.performClick();
                }
            }
        });
        imageView2.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b oDC;

            public final void onClick(View view) {
                if (this.oDC.mode == 5) {
                    yVar.oBg = this.oDC.CY(yVar.path);
                } else if (this.oDC.mode == 6) {
                    yVar.oBg = this.oDC.df(yVar.path, yVar.name);
                }
            }
        });
        imageView3.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b oDC;

            public final void onClick(View view) {
                g.a(this.oDC.oDt, R.l.eGf, R.l.dIO, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass3 oDF;

                    {
                        this.oDF = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        if (yVar.state == 0 || yVar.state == 1) {
                            b bVar = this.oDF.oDC;
                            y yVar = yVar;
                            if (bVar.mode == 5) {
                                w.aUz().cancel(yVar.oBg);
                            } else if (bVar.mode == 6) {
                                o oVar = (o) bVar.oDw.get(yVar.path);
                                if (oVar != null) {
                                    ap.vd().c(oVar);
                                }
                                bVar.oDx.remove(yVar.path);
                                bVar.oDy.remove(yVar.path);
                            }
                        }
                        this.oDF.oDC.oDv.remove(yVar.path);
                        this.oDF.oDC.oDw.remove(yVar.path);
                        this.oDF.oDC.oDx.remove(yVar.path);
                        this.oDF.oDC.oDy.remove(yVar.path);
                        this.oDF.oDC.oDu.removeView(linearLayout);
                        this.oDF.oDC.aUZ();
                    }
                }, null);
            }
        });
        this.oDu.post(new Runnable(this) {
            final /* synthetic */ b oDC;

            public final void run() {
                this.oDC.b(yVar);
            }
        });
        if (yVar.state != 0) {
            return;
        }
        if (this.mode == 5) {
            yVar.oBg = CY(yVar.path);
        } else if (this.mode == 6) {
            yVar.oBg = df(yVar.path, yVar.name);
        }
    }

    public final String aUU() {
        String str = "";
        for (String str2 : this.oDv.keySet()) {
            if (str.length() > 0) {
                str = str + "|";
            }
            str = str + ((y) this.oDv.get(str2)).oBh;
        }
        return str;
    }

    public final LinkedList<y> aUV() {
        LinkedList<y> linkedList = new LinkedList();
        for (String str : this.oDv.keySet()) {
            linkedList.add(this.oDv.get(str));
        }
        return linkedList;
    }

    public final void aUW() {
        y yVar;
        if (this.mode == 5) {
            for (String str : this.oDv.keySet()) {
                yVar = (y) this.oDv.get(str);
                if (yVar.state != 2) {
                    w.aUz().cancel(yVar.oBg);
                    yVar.state = 3;
                    b(yVar);
                }
            }
        } else if (this.mode == 6) {
            for (String str2 : this.oDv.keySet()) {
                yVar = (y) this.oDv.get(str2);
                if (yVar.state != 2) {
                    o oVar = (o) this.oDw.get(yVar.path);
                    if (oVar != null) {
                        ap.vd().c(oVar);
                        yVar.state = 3;
                        b(yVar);
                    }
                    this.oDx.remove(yVar.path);
                    this.oDy.remove(yVar.path);
                    this.oDw.remove(yVar.path);
                }
            }
        }
    }

    public final long CY(final String str) {
        c cVar = new c();
        cVar.oAr = false;
        cVar.oAq = true;
        return w.aUz().a("/cgi-bin/uploaddata", 1, null, new d("UploadFile", str), cVar, new com.tencent.mm.plugin.qqmail.b.p.a(this) {
            final /* synthetic */ b oDC;

            public final boolean onReady() {
                y yVar = (y) this.oDC.oDv.get(str);
                if (yVar != null) {
                    yVar.state = 1;
                    this.oDC.b(yVar);
                }
                return true;
            }

            public final void onSuccess(String str, Map<String, String> map) {
                String str2 = (String) map.get(".Response.result.DataID");
                y yVar = (y) this.oDC.oDv.get(str);
                if (yVar != null) {
                    yVar.state = 2;
                    yVar.oBh = str2;
                    this.oDC.b(yVar);
                }
            }

            public final void onError(int i, String str) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.FileUploadHelper", "errCode:%d, desc:%s", new Object[]{Integer.valueOf(i), str});
                y yVar = (y) this.oDC.oDv.get(str);
                if (yVar != null) {
                    yVar.state = 3;
                    this.oDC.b(yVar);
                }
                if (i == -5) {
                    this.oDC.oDt.oBX.a(new com.tencent.mm.plugin.qqmail.ui.c.a(this) {
                        final /* synthetic */ AnonymousClass5 oDG;

                        {
                            this.oDG = r1;
                        }

                        public final void aUC() {
                        }

                        public final void aUD() {
                        }
                    });
                }
            }

            public final void onComplete() {
                this.oDC.aUY();
            }
        });
    }

    public final long df(final String str, final String str2) {
        if (this.oDw.containsKey(str)) {
            return (long) ((o) this.oDw.get(str)).hashCode();
        }
        k oVar = new o(str, str, new f(this) {
            final /* synthetic */ b oDC;

            public final void a(int i, int i2, k kVar) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.FileUploadHelper", "offset: %d, totalLen: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                final y yVar;
                if (i < i2) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.FileUploadHelper", "uploading file: %s, offset: %d, totalLen: %d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
                    yVar = (y) this.oDC.oDv.get(str);
                    if (yVar != null) {
                        yVar.state = 1;
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass6 oDI;

                            public final void run() {
                                this.oDI.oDC.b(yVar);
                            }
                        });
                    }
                } else if (i >= i2) {
                    yVar = (y) this.oDC.oDv.get(str);
                    String str = ((o) kVar).aUs().tsQ;
                    this.oDC.oDx.put(str, str);
                    this.oDC.oDy.put(str, str2);
                    this.oDC.oDw.remove(str);
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.FileUploadHelper", "finish uploaded file: %s, attachId: %s", new Object[]{str, str});
                    if (yVar != null) {
                        yVar.state = 2;
                        yVar.oBh = str;
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass6 oDI;

                            public final void run() {
                                this.oDI.oDC.b(yVar);
                            }
                        });
                    }
                    this.oDC.aUY();
                }
            }
        });
        y yVar = (y) this.oDv.get(str);
        if (yVar != null) {
            yVar.state = 1;
        }
        b(yVar);
        ap.vd().a(oVar, 0);
        this.oDw.put(str, oVar);
        return (long) oVar.hashCode();
    }

    public final boolean aUX() {
        for (String str : this.oDv.keySet()) {
            y yVar = (y) this.oDv.get(str);
            if (yVar.state != 2 && yVar.state != 3) {
                return false;
            }
        }
        return true;
    }

    public final void aUY() {
        if (aUX()) {
            Object obj;
            for (String str : this.oDv.keySet()) {
                if (((y) this.oDv.get(str)).state != 2) {
                    obj = null;
                    break;
                }
            }
            obj = 1;
            if (obj != null && this.oDz != null) {
                this.oDz.onComplete();
            }
        } else if (this.oDz != null) {
            b bVar = this.oDz;
            this.oDv.size();
            for (String str2 : this.oDv.keySet()) {
                if (((y) this.oDv.get(str2)).state != 2) {
                    break;
                }
            }
            bVar.aUP();
        }
    }

    public final void aUZ() {
        if (this.oDv.size() == 0) {
            this.oBP.setText(this.oDt.getString(R.l.eGl) + " " + this.oDt.getString(R.l.eGo));
            this.oBQ.setImageResource(R.k.dyU);
            ((View) this.oDu.getParent()).setVisibility(8);
        } else {
            this.oBP.setText(this.oDt.getString(R.l.eGl) + this.oDt.getResources().getQuantityString(R.j.dsA, this.oDv.size(), new Object[]{Integer.valueOf(this.oDv.size()), bg.ay((long) aVa())}));
            this.oBQ.setImageResource(R.k.dyV);
            ((View) this.oDu.getParent()).setVisibility(0);
        }
        int childCount = this.oDu.getChildCount();
        int i = 0;
        while (i < childCount) {
            if (childCount == 1) {
                this.oDu.getChildAt(i).setBackgroundResource(R.g.bgQ);
            } else if (i == 0) {
                this.oDu.getChildAt(i).setBackgroundResource(R.g.bgR);
            } else if (i <= 0 || i >= childCount - 1) {
                this.oDu.getChildAt(i).setBackgroundResource(R.g.bgT);
            } else {
                this.oDu.getChildAt(i).setBackgroundResource(R.g.bgS);
            }
            i++;
        }
    }

    public final int aVa() {
        int i = 0;
        for (String str : this.oDv.keySet()) {
            long j = (long) i;
            i = (int) (((y) this.oDv.get(str)).size + j);
        }
        return i;
    }

    public final void b(y yVar) {
        LinearLayout linearLayout = (LinearLayout) this.oDu.findViewById(Math.abs(yVar.path.hashCode() / 2));
        if (linearLayout != null) {
            a aVar = (a) linearLayout.getTag();
            switch (yVar.state) {
                case 0:
                case 1:
                    aVar.kzl.setTextColor(WebView.NIGHT_MODE_COLOR);
                    aVar.oDJ.setVisibility(0);
                    aVar.oDK.setVisibility(8);
                    aVar.oDL.setVisibility(8);
                    aVar.oDM.setVisibility(0);
                    return;
                case 2:
                    aVar.kzl.setTextColor(WebView.NIGHT_MODE_COLOR);
                    aVar.oDJ.setVisibility(8);
                    aVar.oDK.setVisibility(8);
                    aVar.oDL.setVisibility(8);
                    aVar.oDM.setVisibility(0);
                    return;
                case 3:
                    aVar.kzl.setTextColor(com.tencent.mm.bg.a.b(this.oDt, R.e.aUz));
                    aVar.oDJ.setVisibility(8);
                    aVar.oDK.setVisibility(0);
                    aVar.oDL.setVisibility(0);
                    aVar.oDM.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 484) {
            o oVar = (o) kVar;
            String str2 = oVar.filePath;
            final y yVar = (y) this.oDv.get(str2);
            if (yVar == null) {
                return;
            }
            if (i != 0 || i2 != 0) {
                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.FileUploadHelper", "upload error, errType: %d, errCode: %d, file: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str2});
                yVar.state = 3;
                this.oDw.remove(str2);
                ap.vd().c(oVar);
                af.v(new Runnable(this) {
                    final /* synthetic */ b oDC;

                    public final void run() {
                        this.oDC.b(yVar);
                    }
                });
            }
        }
    }
}
