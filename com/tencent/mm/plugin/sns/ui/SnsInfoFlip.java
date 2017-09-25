package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.e.a.ot;
import com.tencent.mm.memory.n;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.am;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.an;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.f;
import com.tencent.mm.ui.tools.MMGestureGallery;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SnsInfoFlip extends FlipView {
    private static int hhC = 0;
    private static int hhD = 0;
    private Context context;
    private ae handler = new ae();
    List<com.tencent.mm.plugin.sns.g.b> hoO;
    boolean pQJ = false;
    an pQT = an.uJM;
    b qBP;
    Gallery qBQ;
    private boolean qBR = true;
    HashMap<Integer, Integer> qBS = new HashMap();
    HashMap<Integer, Long> qBT = new HashMap();
    HashMap<Integer, Long> qBU = new HashMap();
    boolean qBV = false;
    boolean qBW = false;
    boolean qBX = false;
    boolean qBY = false;
    boolean qBZ = false;
    private boolean qCa = true;
    private boolean qCb = true;
    private float qCc = 1.0f;
    MMPageControlView qCd;
    Runnable qCe = null;
    private String qCf = "";
    private int qCg = -1;
    int qCh = -1;
    private boolean qCi = false;
    long qCj = 0;
    private HashSet<String> qCk = new HashSet();
    private Map<String, Boolean> qCl;
    private int qCm = 0;
    private int qCn = 0;
    private boolean qCo = false;
    c qCp;
    private HashMap<String, m> qCq = new HashMap();
    int qCr = -1;
    HashSet<String> qCs = new HashSet();
    public int qCt = 0;
    public int qCu = 0;
    private HashMap<String, a> qCv = new HashMap();
    private com.tencent.mm.ui.base.MultiTouchImageView.a qCw = new com.tencent.mm.ui.base.MultiTouchImageView.a(this) {
        final /* synthetic */ SnsInfoFlip qCx;

        {
            this.qCx = r1;
        }

        public final void bkv() {
            if (this.qCx.qBQ.getSelectedItem() != null && this.qCx.qBP != null) {
                int selectedItemPosition = this.qCx.qBQ.getSelectedItemPosition();
                m Gg = com.tencent.mm.plugin.sns.model.ae.beL().Gg(((com.tencent.mm.plugin.sns.g.b) this.qCx.qBQ.getSelectedItem()).qaD);
                if (Gg != null) {
                    aw.d(Gg, selectedItemPosition);
                }
            }
        }

        public final void bkw() {
            if (this.qCx.qBQ.getSelectedItem() != null && this.qCx.qBP != null) {
                int selectedItemPosition = this.qCx.qBQ.getSelectedItemPosition();
                m Gg = com.tencent.mm.plugin.sns.model.ae.beL().Gg(((com.tencent.mm.plugin.sns.g.b) this.qCx.qBQ.getSelectedItem()).qaD);
                if (Gg != null) {
                    aw.e(Gg, selectedItemPosition);
                }
            }
        }
    };
    boolean qze = false;
    boolean qzg = false;
    public String username;

    class a {
        int networkType;
        long pXO = -1;
        int pXP;
        long qCA = -1;
        long qCB = -1;
        String qCC;
        final /* synthetic */ SnsInfoFlip qCx;
        int qCz = -1;

        a(SnsInfoFlip snsInfoFlip) {
            this.qCx = snsInfoFlip;
        }
    }

    class b extends BaseAdapter {
        private Context context;
        private String hnS = "";
        private boolean kHg = true;
        private boolean qCD = false;
        Map<String, WeakReference<View>> qCE = new HashMap();
        private String qCF;
        final /* synthetic */ SnsInfoFlip qCx;
        private int qoX = 0;

        public b(SnsInfoFlip snsInfoFlip, Context context) {
            this.qCx = snsInfoFlip;
            this.context = context;
            this.qCD = f.bnc();
            this.qoX = snsInfoFlip.hoO.size();
            com.tencent.mm.modelcontrol.c.Er();
            this.kHg = com.tencent.mm.modelcontrol.c.Et();
        }

        public final int getCount() {
            return this.qCx.hoO == null ? 0 : this.qCx.hoO.size();
        }

        private void tX(int i) {
            alh com_tencent_mm_protocal_c_alh = ((com.tencent.mm.plugin.sns.g.b) this.qCx.hoO.get(i)).fVV;
            an a = an.a(this.qCx.pQT, ((com.tencent.mm.plugin.sns.g.b) this.qCx.hoO.get(i)).hFf);
            if (com_tencent_mm_protocal_c_alh.jOc == 2) {
                com.tencent.mm.plugin.sns.model.ae.beI();
                boolean a2 = g.a(com_tencent_mm_protocal_c_alh, a);
                if (this.qCx.qze && !a2) {
                    SnsInfoFlip.a(this.qCx, com_tencent_mm_protocal_c_alh.mQY);
                }
            }
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            if (((com.tencent.mm.plugin.sns.g.b) this.qCx.hoO.get(i)).fVV.jOc == 6) {
                return 0;
            }
            return 1;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (((com.tencent.mm.plugin.sns.g.b) this.qCx.hoO.get(i)).fVV.jOc == 6) {
                String str = "MicroMsg.SnsInfoFlip";
                String str2 = "fill view online sight %d convert view is null %b";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Boolean.valueOf(view == null);
                w.d(str, str2, objArr);
                com.tencent.mm.plugin.sns.g.b bVar = (com.tencent.mm.plugin.sns.g.b) this.qCx.hoO.get(i);
                if (bVar == null) {
                    w.w("MicroMsg.SnsInfoFlip", "fill online sight view, but flip item is null.");
                    return view;
                }
                str2 = bVar.qaD;
                if (bg.mA(str2)) {
                    w.w("MicroMsg.SnsInfoFlip", "fill online sight view, but sns local id is null.");
                    return view;
                }
                View onlineVideoView;
                WeakReference weakReference = (WeakReference) this.qCE.get(str2);
                if (weakReference == null || weakReference.get() == null) {
                    onlineVideoView = new OnlineVideoView(this.context);
                    this.qCE.put(str2, new WeakReference(onlineVideoView));
                } else {
                    onlineVideoView = (OnlineVideoView) weakReference.get();
                }
                if (bg.eB(str2, this.qCF)) {
                    tY(i);
                }
                w.i("MicroMsg.SnsInfoFlip", "return online sight view %d parent id %s", new Object[]{Integer.valueOf(onlineVideoView.hashCode()), bVar.qaD});
                return onlineVideoView;
            }
            d dVar;
            alh com_tencent_mm_protocal_c_alh;
            Bitmap a;
            LayoutParams layoutParams;
            alh com_tencent_mm_protocal_c_alh2 = ((com.tencent.mm.plugin.sns.g.b) this.qCx.hoO.get(i)).fVV;
            w.d("MicroMsg.SnsInfoFlip", "gallery position " + i + " " + this.qoX + " " + com_tencent_mm_protocal_c_alh2.mQY);
            if (i != this.qCx.qCg && (this.qCx.qBQ instanceof MMGestureGallery)) {
                ((MMGestureGallery) this.qCx.qBQ).wmU = false;
            }
            if (view == null) {
                d dVar2 = new d();
                view = View.inflate(this.context, i.g.pHA, null);
                dVar2.qCG = view.findViewById(i.f.pBX);
                dVar2.mAY = (ProgressBar) view.findViewById(i.f.cts);
                dVar2.ngK = (TextView) view.findViewById(i.f.pES);
                dVar2.qCH = (FrameLayout) view.findViewById(i.f.pBR);
                dVar2.fMY = (ImageView) view.findViewById(i.f.Kd);
                view.setTag(dVar2);
                dVar = dVar2;
            } else {
                dVar = (d) view.getTag();
            }
            dVar.position = i;
            an a2 = an.a(this.qCx.pQT, ((com.tencent.mm.plugin.sns.g.b) this.qCx.hoO.get(i)).hFf);
            view.setLayoutParams(new Gallery.LayoutParams(-1, -1));
            dVar.mAY.setVisibility(8);
            dVar.ngK.setVisibility(8);
            dVar.qCH.setVisibility(0);
            Object obj = (bg.mA(this.qCx.qCf) || !this.qCx.qCf.equals(com_tencent_mm_protocal_c_alh2.mQY)) ? null : 1;
            if (com_tencent_mm_protocal_c_alh2.mQY.startsWith("Locall_path") && !bg.mA(((com.tencent.mm.plugin.sns.g.b) this.qCx.hoO.get(i)).qaD)) {
                m mVar = (m) this.qCx.qCq.get(((com.tencent.mm.plugin.sns.g.b) this.qCx.hoO.get(i)).qaD);
                if (mVar == null) {
                    m Gg = com.tencent.mm.plugin.sns.model.ae.beL().Gg(((com.tencent.mm.plugin.sns.g.b) this.qCx.hoO.get(i)).qaD);
                    this.qCx.qCq.put(((com.tencent.mm.plugin.sns.g.b) this.qCx.hoO.get(i)).qaD, Gg);
                    mVar = Gg;
                }
                bfc bhd = mVar.bhd();
                if (bhd.ufB.tsO.size() > ((com.tencent.mm.plugin.sns.g.b) this.qCx.hoO.get(i)).qaE) {
                    com_tencent_mm_protocal_c_alh = (alh) bhd.ufB.tsO.get(((com.tencent.mm.plugin.sns.g.b) this.qCx.hoO.get(i)).qaE);
                    a = com.tencent.mm.plugin.sns.model.ae.beI().a(com_tencent_mm_protocal_c_alh, dVar.fMY, this.context.hashCode(), obj != null, a2);
                    if (a == null && this.qCx.qze) {
                        SnsInfoFlip.a(this.qCx, com_tencent_mm_protocal_c_alh.mQY);
                    }
                    layoutParams = dVar.fMY.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    dVar.fMY.setLayoutParams(layoutParams);
                    if (a != null && com_tencent_mm_protocal_c_alh.mQY != null && !com_tencent_mm_protocal_c_alh.mQY.startsWith("pre_temp_extend_pic")) {
                        LayoutParams layoutParams2 = dVar.fMY.getLayoutParams();
                        if (this.qCx.qCi) {
                            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.context, 73.0f);
                            dVar.fMY.setLayoutParams(layoutParams);
                            dVar.mAY.setVisibility(0);
                            dVar.fMY.setVisibility(0);
                            com.tencent.mm.plugin.sns.model.ae.beI().cn(dVar.fMY);
                            com.tencent.mm.plugin.sns.model.ae.beI().b(com_tencent_mm_protocal_c_alh, dVar.fMY, e.black, this.context.hashCode(), a2);
                        } else {
                            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.context, 160.0f);
                            int a3 = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.context, 200.0f);
                            com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(this.context, 44.0f);
                            g beI = com.tencent.mm.plugin.sns.model.ae.beI();
                            String an = com.tencent.mm.plugin.sns.data.i.an(1, com_tencent_mm_protocal_c_alh.mQY);
                            String str3 = com_tencent_mm_protocal_c_alh.mQY;
                            n EZ = beI.EZ(an);
                            if (!com.tencent.mm.plugin.sns.data.i.a(EZ)) {
                                EZ = null;
                            }
                            if (EZ != null) {
                                double width = (double) EZ.bitmap.getWidth();
                                double height = (double) EZ.bitmap.getHeight();
                                if (width > 0.0d && height > 0.0d) {
                                    Math.min(((double) a3) / width, ((double) a3) / height);
                                }
                            }
                            dVar.fMY.setLayoutParams(layoutParams);
                            dVar.mAY.setVisibility(0);
                            dVar.fMY.setVisibility(0);
                            com.tencent.mm.plugin.sns.model.ae.beI().cn(dVar.fMY);
                            com.tencent.mm.plugin.sns.model.ae.beI().c(com_tencent_mm_protocal_c_alh, dVar.fMY, e.black, this.context.hashCode(), a2);
                        }
                        SnsInfoFlip.hhD = layoutParams2.width;
                        SnsInfoFlip.hhC = layoutParams2.height;
                        if (obj != null) {
                            dVar.mAY.setVisibility(8);
                        }
                    } else if (this.qCD) {
                        dVar.mAY.setVisibility(8);
                        com.tencent.mm.plugin.sns.model.ae.beI().c(com_tencent_mm_protocal_c_alh, dVar.fMY, this.context.hashCode(), a2);
                        dVar.fMY.setImageBitmap(a);
                        dVar.fMY.setVisibility(0);
                    } else {
                        dVar.mAY.setVisibility(8);
                        if (a != null) {
                            if (!this.qCx.qCo) {
                                return view;
                            }
                            w.i("MicroMsg.SnsInfoFlip", "update view ");
                            View multiTouchImageView = new MultiTouchImageView(this.context, a.getWidth(), a.getHeight(), this.qCx.qCw);
                            multiTouchImageView.qBZ = this.qCx.qBZ;
                            multiTouchImageView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
                            com.tencent.mm.plugin.sns.model.ae.beI().c(com_tencent_mm_protocal_c_alh, multiTouchImageView, this.context.hashCode(), a2);
                            multiTouchImageView.setImageBitmap(a);
                            w.d("MicroMsg.SnsInfoFlip", "dancy mediaId: %s, isbigImgLoaded: %s, view: %s", new Object[]{com_tencent_mm_protocal_c_alh.mQY, this.qCx.qCl.get(com_tencent_mm_protocal_c_alh.mQY), Integer.valueOf(multiTouchImageView.getId())});
                            return multiTouchImageView;
                        }
                    }
                    if (!this.kHg && aa.bn(this.context)) {
                        if (i - 1 >= 0) {
                            tX(i - 1);
                        }
                        if (i + 1 >= this.qCx.qBP.getCount()) {
                            return view;
                        }
                        tX(i + 1);
                        return view;
                    }
                }
            }
            com_tencent_mm_protocal_c_alh = com_tencent_mm_protocal_c_alh2;
            if (obj != null) {
            }
            a = com.tencent.mm.plugin.sns.model.ae.beI().a(com_tencent_mm_protocal_c_alh, dVar.fMY, this.context.hashCode(), obj != null, a2);
            SnsInfoFlip.a(this.qCx, com_tencent_mm_protocal_c_alh.mQY);
            layoutParams = dVar.fMY.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            dVar.fMY.setLayoutParams(layoutParams);
            if (a != null) {
            }
            if (this.qCD) {
                dVar.mAY.setVisibility(8);
                com.tencent.mm.plugin.sns.model.ae.beI().c(com_tencent_mm_protocal_c_alh, dVar.fMY, this.context.hashCode(), a2);
                dVar.fMY.setImageBitmap(a);
                dVar.fMY.setVisibility(0);
            } else {
                dVar.mAY.setVisibility(8);
                if (a != null) {
                    if (!this.qCx.qCo) {
                        return view;
                    }
                    w.i("MicroMsg.SnsInfoFlip", "update view ");
                    View multiTouchImageView2 = new MultiTouchImageView(this.context, a.getWidth(), a.getHeight(), this.qCx.qCw);
                    multiTouchImageView2.qBZ = this.qCx.qBZ;
                    multiTouchImageView2.setLayoutParams(new Gallery.LayoutParams(-1, -1));
                    com.tencent.mm.plugin.sns.model.ae.beI().c(com_tencent_mm_protocal_c_alh, multiTouchImageView2, this.context.hashCode(), a2);
                    multiTouchImageView2.setImageBitmap(a);
                    w.d("MicroMsg.SnsInfoFlip", "dancy mediaId: %s, isbigImgLoaded: %s, view: %s", new Object[]{com_tencent_mm_protocal_c_alh.mQY, this.qCx.qCl.get(com_tencent_mm_protocal_c_alh.mQY), Integer.valueOf(multiTouchImageView2.getId())});
                    return multiTouchImageView2;
                }
            }
            return !this.kHg ? view : view;
        }

        public final void clear() {
            w.i("MicroMsg.SnsInfoFlip", "adapter clear.");
            this.qCE.clear();
        }

        public final void tY(int i) {
            com.tencent.mm.plugin.sns.g.b bVar = (com.tencent.mm.plugin.sns.g.b) this.qCx.hoO.get(i);
            if (bVar == null) {
                w.w("MicroMsg.SnsInfoFlip", "notify online sight play, but flip item is null.");
                return;
            }
            String str = bVar.qaD;
            if (bg.mA(str)) {
                w.w("MicroMsg.SnsInfoFlip", "notify online sight play, but sns local id is null.");
                return;
            }
            w.i("MicroMsg.SnsInfoFlip", "notify online sight play pos %s sns local id %s", new Object[]{Integer.valueOf(i), str});
            WeakReference weakReference = (WeakReference) this.qCE.get(str);
            if (weakReference == null) {
                w.w("MicroMsg.SnsInfoFlip", "notify online sight play, but view cache is null ");
                this.qCF = str;
                return;
            }
            OnlineVideoView onlineVideoView = (OnlineVideoView) weakReference.get();
            if (onlineVideoView == null) {
                w.w("MicroMsg.SnsInfoFlip", "online sight view is null, do nothing. snsLocalId %s", new Object[]{str});
                this.qCF = str;
                return;
            }
            w.i("MicroMsg.SnsInfoFlip", "%d notify online sight play video %s", new Object[]{Integer.valueOf(onlineVideoView.hashCode()), str});
            this.qCF = null;
            w.d("MicroMsg.OnlineVideoView", "%d register sns ui event", new Object[]{Integer.valueOf(onlineVideoView.hashCode())});
            com.tencent.mm.sdk.b.a.urY.b(onlineVideoView.qvM);
            onlineVideoView.a(bVar.fVV, bVar.qaD, bVar.hFf);
            com.tencent.mm.sdk.b.b otVar = new ot();
            otVar.fVN.fJK = 1;
            otVar.fVN.fJz = str;
            com.tencent.mm.sdk.b.a.urY.m(otVar);
        }

        public final void bkx() {
            w.i("MicroMsg.SnsInfoFlip", "notify online sight stop %s", new Object[]{bg.bJZ()});
            this.qCF = null;
            com.tencent.mm.sdk.b.b otVar = new ot();
            otVar.fVN.fJK = 2;
            com.tencent.mm.sdk.b.a.urY.m(otVar);
        }

        public final Object getItem(int i) {
            if (i >= this.qCx.hoO.size() || i < 0) {
                return null;
            }
            return this.qCx.hoO.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final void notifyDataSetChanged() {
            this.qoX = this.qCx.hoO.size();
            w.d("MicroMsg.SnsInfoFlip", "items.size:" + this.qCx.hoO.size());
            this.qCx.invalidate();
            this.qCx.requestLayout();
            super.notifyDataSetChanged();
            if (this.qCx.hoO.size() <= 0 && this.qCx.qCe != null) {
                this.qCx.qCe.run();
            }
        }
    }

    public interface c {
        void tZ(int i);
    }

    static class d {
        ImageView fMY;
        String fVB = "";
        ProgressBar mAY;
        TextView ngK;
        int position;
        View qCG;
        FrameLayout qCH;

        d() {
        }
    }

    static /* synthetic */ void a(SnsInfoFlip snsInfoFlip, String str) {
        w.d("MicroMsg.SnsInfoFlip", "recordLoadStart, bigPicId:%s", new Object[]{str});
        if (!snsInfoFlip.qCv.containsKey(str)) {
            a aVar = new a(snsInfoFlip);
            aVar.pXP = snsInfoFlip.getCount();
            aVar.networkType = bks();
            aVar.qCA = System.currentTimeMillis();
            aVar.qCC = str;
            snsInfoFlip.qCv.put(str, aVar);
            w.d("MicroMsg.SnsInfoFlip", "recordLoadStart, put to map");
        }
    }

    public SnsInfoFlip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public SnsInfoFlip(Context context) {
        super(context);
        init(context);
    }

    public final boolean biR() {
        return this.qze;
    }

    private void init(final Context context) {
        this.qCj = System.currentTimeMillis();
        this.context = context;
        View inflate = inflate(context, i.g.pHD, this);
        if (f.bnc()) {
            inflate.findViewById(i.f.pCA).setVisibility(0);
            this.qBQ = (Gallery) inflate.findViewById(i.f.pCA);
        } else {
            inflate.findViewById(i.f.pCB).setVisibility(0);
            this.qBQ = (Gallery) inflate.findViewById(i.f.pCB);
        }
        if (this.qBQ instanceof MMGestureGallery) {
            this.qBQ.setSpacing(50);
            ((MMGestureGallery) this.qBQ).wmR = new MMGestureGallery.f(this) {
                final /* synthetic */ SnsInfoFlip qCx;

                public final void ahA() {
                    if (context instanceof SnsBrowseUI) {
                        ((SnsBrowseUI) context).ahz();
                    } else if (this.qCx.qBX) {
                        ((MMActivity) context).finish();
                    } else {
                        this.qCx.handler.post(new Runnable(this) {
                            final /* synthetic */ AnonymousClass1 qCy;

                            {
                                this.qCy = r1;
                            }

                            public final void run() {
                                if (this.qCy.qCx.qtd != null && this.qCy.qCx.qBY) {
                                    this.qCy.qCx.qtd.adz();
                                }
                            }
                        });
                    }
                }
            };
            ((MMGestureGallery) this.qBQ).wmT = new MMGestureGallery.e(this) {
                final /* synthetic */ SnsInfoFlip qCx;

                {
                    this.qCx = r1;
                }

                public final void bku() {
                    if (this.qCx.qtd != null) {
                        this.qCx.qtd.biU();
                    }
                }
            };
        }
        this.qCd = (MMPageControlView) findViewById(i.f.pGv);
        this.qCd.vlf = i.g.pIz;
        this.qCl = new HashMap();
    }

    public final void tU(int i) {
        this.infoType = i;
    }

    public final com.tencent.mm.plugin.sns.g.b bkn() {
        if (this.qBQ == null) {
            return null;
        }
        return (com.tencent.mm.plugin.sns.g.b) this.qBQ.getSelectedItem();
    }

    private static int b(String str, bfc com_tencent_mm_protocal_c_bfc) {
        Iterator it = com_tencent_mm_protocal_c_bfc.ufB.tsO.iterator();
        int i = 0;
        while (it.hasNext()) {
            i++;
            if (str.equals(((alh) it.next()).mQY)) {
                return i;
            }
        }
        return 0;
    }

    private void a(alh com_tencent_mm_protocal_c_alh, int i, String str) {
        long j = 0;
        if (this.qBQ != null && (this.qBQ instanceof MMGestureGallery)) {
            float f;
            float f2;
            if (com_tencent_mm_protocal_c_alh.tPl != null) {
                f = com_tencent_mm_protocal_c_alh.tPl.tPZ;
                f2 = com_tencent_mm_protocal_c_alh.tPl.tPY;
            } else {
                f = 0.0f;
                f2 = 0.0f;
            }
            float f3;
            if (f <= 0.0f || f2 <= 0.0f) {
                Options Pe = com.tencent.mm.sdk.platformtools.d.Pe(com_tencent_mm_protocal_c_alh.mQY.startsWith("Locall_path") ? am.du(com.tencent.mm.plugin.sns.model.ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + com.tencent.mm.plugin.sns.data.i.m(com_tencent_mm_protocal_c_alh) : am.du(com.tencent.mm.plugin.sns.model.ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY) + com.tencent.mm.plugin.sns.data.i.d(com_tencent_mm_protocal_c_alh));
                if (Pe != null) {
                    f3 = (float) Pe.outWidth;
                    f2 = (float) Pe.outHeight;
                }
            } else {
                f3 = f2;
                f2 = f;
            }
            if (f2 > 0.0f && r5 > 0.0f) {
                MMGestureGallery mMGestureGallery = (MMGestureGallery) this.qBQ;
                if (!this.qBZ || ((double) r5) * 1.0d <= ((double) f2) * 2.0d) {
                    w.d("MicroMsg.SnsInfoFlip", "set on fling false");
                    mMGestureGallery.vnn = false;
                } else {
                    w.d("MicroMsg.SnsInfoFlip", "set on fling true");
                    mMGestureGallery.vnn = true;
                }
            }
        }
        if (this.qCp != null) {
            this.qCp.tZ(i);
        }
        m Gg = com.tencent.mm.plugin.sns.model.ae.beL().Gg(str);
        if (Gg != null) {
            aw.c(Gg, i);
        }
        if (this.qCg == -1) {
            this.qCg = i;
        }
        this.qCh = 1;
        String str2 = com_tencent_mm_protocal_c_alh.mQY;
        if (bg.mA(str)) {
            this.qtd.dF((i + 1) + " / " + this.qBP.getCount(), null);
            return;
        }
        Gg = (m) this.qCq.get(str);
        if (Gg == null) {
            Gg = com.tencent.mm.plugin.sns.model.ae.beL().Gg(str);
            this.qCq.put(str, Gg);
        }
        m mVar = Gg;
        if (mVar != null) {
            String str3;
            if (com_tencent_mm_protocal_c_alh.jOc == 2) {
                if (this.qBQ instanceof MMGestureGallery) {
                    ((MMGestureGallery) this.qBQ).wmU = false;
                }
            } else if (this.qBQ instanceof MMGestureGallery) {
                ((MMGestureGallery) this.qBQ).wmU = true;
            }
            if (com_tencent_mm_protocal_c_alh.jOc != 6) {
                com.tencent.mm.plugin.sns.model.ae.ayz().post(new Runnable(this) {
                    final /* synthetic */ SnsInfoFlip qCx;

                    {
                        this.qCx = r1;
                    }

                    public final void run() {
                        this.qCx.qBP.bkx();
                    }
                });
            }
            w.d("MicroMsg.SnsInfoFlip", "onItemSelected  " + i + " localId " + str);
            if (this.qCr != i) {
                this.qBS.put(Integer.valueOf(i), Integer.valueOf((this.qBS.containsKey(Integer.valueOf(i)) ? ((Integer) this.qBS.get(Integer.valueOf(i))).intValue() : 0) + 1));
                this.qBT.put(Integer.valueOf(i), Long.valueOf(bg.NA()));
                if (this.qCr >= 0) {
                    long longValue;
                    if (this.qBT.containsKey(Integer.valueOf(this.qCr))) {
                        longValue = ((Long) this.qBT.get(Integer.valueOf(this.qCr))).longValue();
                    } else {
                        longValue = 0;
                    }
                    if (longValue > 0) {
                        this.qBT.put(Integer.valueOf(this.qCr), Long.valueOf(0));
                        if (this.qBU.containsKey(Integer.valueOf(this.qCr))) {
                            j = ((Long) this.qBU.get(Integer.valueOf(this.qCr))).longValue();
                        }
                        longValue = bg.aB(longValue);
                        j += longValue;
                        this.qBU.put(Integer.valueOf(this.qCr), Long.valueOf(j));
                        w.i("MicroMsg.SnsInfoFlip", "lastSelectPosition " + this.qCr + " curtime " + j + " passtime " + (((double) longValue) / 1000.0d));
                    }
                }
                if (this.qze && this.qBP != null) {
                    com.tencent.mm.plugin.sns.g.b bVar = (com.tencent.mm.plugin.sns.g.b) this.qBP.getItem(this.qCr);
                    if (bVar != null) {
                        str3 = bVar.fVV.mQY;
                        w.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, bigPicId:%s", new Object[]{str3});
                        if (this.qCv.containsKey(str3)) {
                            a aVar = (a) this.qCv.get(str3);
                            aVar.networkType = bks();
                            if (aVar.qCB != -1) {
                                aVar.qCz = 1;
                                aVar.pXO = aVar.qCB - aVar.qCA;
                                w.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, load success, costTime:%d", new Object[]{Long.valueOf(aVar.pXO)});
                            } else {
                                aVar.qCz = 2;
                                aVar.qCB = System.currentTimeMillis();
                                aVar.pXO = aVar.qCB - aVar.qCA;
                                w.d("MicroMsg.SnsInfoFlip", "recordMediaScollOver, load failed, costTime:%d", new Object[]{Long.valueOf(aVar.pXO)});
                            }
                        }
                    }
                }
            }
            this.qCr = i;
            if (this.qtc != null) {
                this.qtc.GJ(str);
            }
            int i2 = mVar.field_createTime;
            bfc bhd = mVar.bhd();
            String l = ay.l(this.context, ((long) i2) * 1000);
            str3 = null;
            if (!(bhd == null || bhd.ufB == null || bhd.ufB.tsO.size() <= 1)) {
                str3 = (((com.tencent.mm.plugin.sns.g.b) this.hoO.get(i)).qaE + 1) + " / " + bhd.ufB.tsO.size();
                this.qCh = b(str2, bhd);
            }
            this.qtd.dF(l, str3);
            this.qtd.bO(str, i);
            if (this.qBP != null) {
                this.qBP.tY(i);
            }
        }
    }

    public final void a(List<com.tencent.mm.plugin.sns.g.b> list, String str, int i, u uVar, com.tencent.mm.plugin.sns.ui.s.a aVar) {
        com.tencent.mm.plugin.sns.model.ae.beG().a(this);
        this.hoO = list;
        this.qCi = this.hoO.size() > 1;
        ai.Fl(str);
        this.qtc = uVar;
        this.qtd = aVar;
        this.qBP = new b(this, this.context);
        this.qBQ.setAdapter(this.qBP);
        if (i >= 0 && i < this.hoO.size()) {
            this.qBQ.setSelection(i);
            if (this.qCb) {
                this.qCb = false;
                alh com_tencent_mm_protocal_c_alh = ((com.tencent.mm.plugin.sns.g.b) this.hoO.get(i)).fVV;
                if (com_tencent_mm_protocal_c_alh == null || com_tencent_mm_protocal_c_alh.tPl == null || com_tencent_mm_protocal_c_alh.tPl.tPZ <= 0.0f) {
                    this.qCc = 1.0f;
                } else {
                    this.qCc = com_tencent_mm_protocal_c_alh.tPl.tPY / com_tencent_mm_protocal_c_alh.tPl.tPZ;
                }
            }
        }
        this.qBQ.setFadingEdgeLength(0);
        this.qBQ.setOnItemSelectedListener(new OnItemSelectedListener(this) {
            final /* synthetic */ SnsInfoFlip qCx;

            {
                this.qCx = r1;
            }

            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.qCx.qBP != null) {
                    if (this.qCx.qBV && this.qCx.qBP.getCount() > 1) {
                        this.qCx.qCd.setVisibility(0);
                        this.qCx.qCd.tu(i);
                    }
                    this.qCx.a(((com.tencent.mm.plugin.sns.g.b) this.qCx.qBP.getItem(i)).fVV, i, ((com.tencent.mm.plugin.sns.g.b) this.qCx.qBP.getItem(i)).qaD);
                    if (view instanceof MultiTouchImageView) {
                        ((MultiTouchImageView) view).bSJ();
                    }
                    if ((this.qCx.qBQ instanceof MMGestureGallery) && (this.qCx.context instanceof SnsBrowseUI)) {
                        ((SnsBrowseUI) this.qCx.context).bjQ();
                    }
                }
            }

            public final void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        if (this.qBR) {
            this.qBQ.setOnItemLongClickListener(new OnItemLongClickListener(this) {
                final /* synthetic */ SnsInfoFlip qCx;

                {
                    this.qCx = r1;
                }

                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (!this.qCx.qBR) {
                        return true;
                    }
                    String str = ((com.tencent.mm.plugin.sns.g.b) this.qCx.qBP.getItem(i)).qaD;
                    if (bg.mA(str)) {
                        return false;
                    }
                    String str2 = ((com.tencent.mm.plugin.sns.g.b) this.qCx.qBP.getItem(i)).fVV.mQY;
                    this.qCx.e(am.du(com.tencent.mm.plugin.sns.model.ae.getAccSnsPath(), str2) + com.tencent.mm.plugin.sns.data.i.l(((com.tencent.mm.plugin.sns.g.b) this.qCx.qBP.getItem(i)).fVV), str, str2, true);
                    return true;
                }
            });
        }
        if (this.qBV && this.qBP.getCount() > 1) {
            this.qCd.setVisibility(0);
            this.qCd.dY(this.qBP.getCount(), i);
        }
        if (this.qzg && !bg.mA(((com.tencent.mm.plugin.sns.g.b) this.qBP.getItem(i)).qaD)) {
            GG(am.du(com.tencent.mm.plugin.sns.model.ae.getAccSnsPath(), ((com.tencent.mm.plugin.sns.g.b) this.qBP.getItem(i)).fVV.mQY) + com.tencent.mm.plugin.sns.data.i.l(((com.tencent.mm.plugin.sns.g.b) this.qBP.getItem(i)).fVV));
        }
    }

    public final long biQ() {
        com.tencent.mm.plugin.sns.g.b bVar = (com.tencent.mm.plugin.sns.g.b) this.qBQ.getSelectedItem();
        String str = bVar == null ? "" : bVar.qaD;
        if (bg.mA(str)) {
            return 0;
        }
        m Gg = com.tencent.mm.plugin.sns.model.ae.beL().Gg(str);
        return Gg == null ? 0 : Gg.field_snsId;
    }

    public final int getPosition() {
        return this.qCh;
    }

    private void bko() {
        if (this.qBQ.getSelectedItem() != null && this.qBP != null) {
            int selectedItemPosition = this.qBQ.getSelectedItemPosition();
            if (this.qBV && this.qBP.getCount() > 1) {
                this.qCd.setVisibility(0);
                this.qCd.tu(selectedItemPosition);
            }
            alh com_tencent_mm_protocal_c_alh = ((com.tencent.mm.plugin.sns.g.b) this.qBQ.getSelectedItem()).fVV;
            this.qCs.add(com_tencent_mm_protocal_c_alh.mQY);
            String str = ((com.tencent.mm.plugin.sns.g.b) this.qBQ.getSelectedItem()).qaD;
            String str2 = com_tencent_mm_protocal_c_alh.mQY;
            if (bg.mA(this.qCf) || !this.qCf.equals(str2)) {
                this.qCf = "";
            }
            a(com_tencent_mm_protocal_c_alh, selectedItemPosition, str);
        }
    }

    public final void asx() {
        if (this.qBP != null) {
            w.d("MicroMsg.SnsInfoFlip", "onRefresh ");
            this.qBP.notifyDataSetChanged();
            bko();
        }
    }

    protected final void onPause() {
        super.onPause();
        if (this.qBP != null) {
            this.qBP.bkx();
            this.qBP.clear();
        }
    }

    protected void onMeasure(int i, int i2) {
        this.qCo = true;
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.qCo = false;
        super.onLayout(z, i, i2, i3, i4);
    }

    public final void bkp() {
        w.i("MicroMsg.SnsInfoFlip", "sns info flip on detch.");
        if (this.qBP != null) {
            this.qBP.bkx();
            this.qBP.clear();
        }
        com.tencent.mm.plugin.sns.model.ae.beG().b(this);
    }

    public final int bkq() {
        if (this.qBQ == null) {
            return -1;
        }
        this.hoO.remove(this.qBQ.getSelectedItemPosition());
        this.qBP.notifyDataSetChanged();
        bko();
        return this.qBP.getCount();
    }

    public final int getCount() {
        if (this.qBP != null) {
            return this.qBP.getCount();
        }
        return 0;
    }

    public final alh biS() {
        if (this.qBP != null) {
            int selectedItemPosition = this.qBQ.getSelectedItemPosition();
            if (this.hoO != null && selectedItemPosition < this.hoO.size()) {
                return ((com.tencent.mm.plugin.sns.g.b) this.hoO.get(selectedItemPosition)).fVV;
            }
        }
        return null;
    }

    public final int bkr() {
        int i = 0;
        int i2 = 0;
        for (com.tencent.mm.plugin.sns.g.b bVar : this.hoO) {
            com.tencent.mm.plugin.sns.model.ae.beI();
            if (FileOp.aO(g.B(bVar.fVV))) {
                i2++;
            }
            int i3 = i + 1;
            if (i3 > 9) {
                break;
            }
            i = i3;
        }
        return i2;
    }

    public final void ao(String str, boolean z) {
        alh com_tencent_mm_protocal_c_alh;
        if (!z) {
            com_tencent_mm_protocal_c_alh = ((com.tencent.mm.plugin.sns.g.b) this.qBQ.getSelectedItem()).fVV;
            if (!(com_tencent_mm_protocal_c_alh == null || com_tencent_mm_protocal_c_alh.mQY == null || !com_tencent_mm_protocal_c_alh.mQY.equals(str))) {
                Toast.makeText(this.context, this.context.getString(j.pKI), 0).show();
                this.qCf = str;
            }
        }
        this.qCu++;
        if (this.qze) {
            w.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, bigPicId:%s, suceess:%b", new Object[]{str, Boolean.valueOf(z)});
            if (z && this.qCv.containsKey(str)) {
                a aVar = (a) this.qCv.get(str);
                aVar.qCB = System.currentTimeMillis();
                aVar.networkType = bks();
                w.d("MicroMsg.SnsInfoFlip", "recordLoadEnd, update map");
                this.qCl.put(str, Boolean.valueOf(true));
            }
        }
        if (this.qBP != null && ((com.tencent.mm.plugin.sns.g.b) this.qBQ.getSelectedItem()) != null) {
            com_tencent_mm_protocal_c_alh = ((com.tencent.mm.plugin.sns.g.b) this.qBQ.getSelectedItem()).fVV;
            if (com_tencent_mm_protocal_c_alh != null && com_tencent_mm_protocal_c_alh.mQY != null && com_tencent_mm_protocal_c_alh.mQY.equals(str)) {
                this.qBP.notifyDataSetChanged();
                if (this.qzg && com_tencent_mm_protocal_c_alh != null) {
                    String du = am.du(com.tencent.mm.plugin.sns.model.ae.getAccSnsPath(), com_tencent_mm_protocal_c_alh.mQY);
                    String l = com.tencent.mm.plugin.sns.data.i.l(com_tencent_mm_protocal_c_alh);
                    if (FileOp.aO(du + l)) {
                        l = du + l;
                        Intent intent = new Intent();
                        w.i("MicroMsg.FlipView", "edit image path:%s", new Object[]{l});
                        intent.putExtra("before_photo_edit", l);
                        intent.putExtra("from_scene", 293);
                        intent.putExtra("after_photo_edit", "");
                        intent.putExtra("Retr_Compress_Type", 0);
                        intent.putExtra("Retr_Msg_Type", 0);
                        intent.putExtra("Retr_FromMainTimeline", biR());
                        com.tencent.mm.bb.d.b(this.context, "photoedit", ".ui.MMPhotoEditUI", intent);
                    }
                }
            }
        }
    }

    public final void ap(String str, boolean z) {
        w.i("MicroMsg.SnsInfoFlip", "onSightFinish " + str + " " + z);
        if (!z) {
            alh com_tencent_mm_protocal_c_alh = ((com.tencent.mm.plugin.sns.g.b) this.qBQ.getSelectedItem()).fVV;
            if (!(com_tencent_mm_protocal_c_alh == null || com_tencent_mm_protocal_c_alh.mQY == null || !com_tencent_mm_protocal_c_alh.mQY.equals(str))) {
                Toast.makeText(this.context, this.context.getString(j.pKJ), 0).show();
                this.qCf = str;
            }
        }
        if (this.qBP != null) {
            this.qBP.notifyDataSetChanged();
        }
    }

    private static int bks() {
        Context context = ab.getContext();
        if (com.tencent.mm.sdk.platformtools.am.is2G(context)) {
            return 1;
        }
        if (com.tencent.mm.sdk.platformtools.am.is3G(context)) {
            return 2;
        }
        if (com.tencent.mm.sdk.platformtools.am.is4G(context)) {
            return 3;
        }
        if (com.tencent.mm.sdk.platformtools.am.isWifi(context)) {
            return 4;
        }
        return 0;
    }

    public final void bkt() {
        for (a aVar : this.qCv.values()) {
            if (aVar.qCz != -1) {
                com.tencent.mm.plugin.report.service.g.oUh.i(11601, new Object[]{Integer.valueOf(aVar.pXP), Integer.valueOf(aVar.qCz), Long.valueOf(aVar.pXO), Integer.valueOf(aVar.networkType)});
                w.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d", new Object[]{Integer.valueOf(aVar.pXP), Integer.valueOf(aVar.qCz), Long.valueOf(aVar.pXO), Integer.valueOf(aVar.networkType)});
            } else if (aVar.qCA != -1) {
                if (aVar.qCB != -1) {
                    aVar.qCz = 1;
                } else {
                    aVar.qCz = 2;
                    aVar.qCB = System.currentTimeMillis();
                }
                aVar.pXO = aVar.qCB - aVar.qCA;
                com.tencent.mm.plugin.report.service.g.oUh.i(11601, new Object[]{Integer.valueOf(aVar.pXP), Integer.valueOf(aVar.qCz), Long.valueOf(aVar.pXO), Integer.valueOf(aVar.networkType)});
                w.d("MicroMsg.SnsInfoFlip", "report big pic load, picNum:%d, loadResult:%d, loadCostTime:%d, networkType:%d", new Object[]{Integer.valueOf(aVar.pXP), Integer.valueOf(aVar.qCz), Long.valueOf(aVar.pXO), Integer.valueOf(aVar.networkType)});
            }
        }
        this.qCv.clear();
    }
}
