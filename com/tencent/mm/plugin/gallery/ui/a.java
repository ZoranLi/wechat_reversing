package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.media.MediaMetadataRetriever;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.ImageMediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.gridviewheaders.e;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map.Entry;

public final class a extends BaseAdapter implements e {
    private SimpleDateFormat kFt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private Context mContext;
    int mfj = 9;
    com.tencent.mm.plugin.gallery.stub.a mfk = null;
    ArrayList<MediaItem> mfl = new ArrayList();
    ArrayList<MediaItem> mfm = new ArrayList();
    private b mfn;
    int mfo;
    LinkedList<a> mfp = new LinkedList();
    boolean mfq = false;
    private OnClickListener mfr = new OnClickListener(this) {
        final /* synthetic */ a mft;

        {
            this.mft = r1;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r10) {
            /*
            r9 = this;
            r2 = 1;
            r3 = 0;
            r0 = com.tencent.mm.R.h.cjq;
            r0 = r10.getTag(r0);
            r0 = (java.lang.Integer) r0;
            r1 = r9.mft;
            r1 = r1.mfl;
            r4 = r0.intValue();
            r1 = r1.get(r4);
            r1 = (com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem) r1;
            r4 = "MicroMsg.AlbumAdapter";
            r5 = new java.lang.StringBuilder;
            r6 = "click Image path:";
            r5.<init>(r6);
            r6 = r1.hTf;
            r5 = r5.append(r6);
            r5 = r5.toString();
            com.tencent.mm.sdk.platformtools.w.i(r4, r5);
            r4 = r9.mft;
            r4 = r4.mfm;
            r4 = r4.contains(r1);
            if (r4 == 0) goto L_0x0097;
        L_0x003e:
            r4 = r9.mft;
            r4 = r4.mfm;
            r4.indexOf(r1);
            r4 = r9.mft;
            r4 = r4.mfm;
            r4.remove(r1);
            r1 = r2;
            r4 = r3;
        L_0x0052:
            if (r4 != 0) goto L_0x0157;
        L_0x0054:
            r4 = r9.mft;
            r4 = r4.mfn;
            if (r4 == 0) goto L_0x0071;
        L_0x005c:
            r4 = r9.mft;
            r4 = r4.mfn;
            r5 = r9.mft;
            r5 = r5.mfm;
            r5 = r5.size();
            r0 = r0.intValue();
            r4.A(r5, r0, r1);
        L_0x0071:
            if (r2 != r1) goto L_0x01f5;
        L_0x0073:
            r0 = com.tencent.mm.R.h.cjp;
            r0 = r10.getTag(r0);
            r0 = (android.widget.CheckBox) r0;
            r0.setChecked(r3);
            r0 = com.tencent.mm.R.h.cju;
            r0 = r10.getTag(r0);
            r0 = (android.view.View) r0;
            r0.setVisibility(r3);
            r0 = com.tencent.mm.R.h.cju;
            r0 = r10.getTag(r0);
            r0 = (android.view.View) r0;
            r1 = com.tencent.mm.R.g.bfR;
            r0.setBackgroundResource(r1);
        L_0x0096:
            return;
        L_0x0097:
            r4 = com.tencent.mm.plugin.gallery.model.c.ayk();
            r4 = r4.ayM();
            r5 = 3;
            if (r4 != r5) goto L_0x012f;
        L_0x00a2:
            if (r1 == 0) goto L_0x012f;
        L_0x00a4:
            r4 = r1.mMimeType;
            r5 = "image/gif";
            r4 = r4.equalsIgnoreCase(r5);
            if (r4 == 0) goto L_0x012f;
        L_0x00af:
            r4 = new com.tencent.mm.plugin.gif.d;
            r5 = r1.hTf;
            r4.<init>(r5);
            r5 = r1.hTf;
            r5 = com.tencent.mm.a.e.aN(r5);
            if (r5 == 0) goto L_0x00ca;
        L_0x00be:
            r6 = r9.mft;	 Catch:{ Exception -> 0x0122 }
            r6 = r6.mfk;	 Catch:{ Exception -> 0x0122 }
            r6 = r6.sC();	 Catch:{ Exception -> 0x0122 }
            if (r5 > r6) goto L_0x00ec;
        L_0x00ca:
            r6 = r4.mJo;	 Catch:{ Exception -> 0x0122 }
            r7 = 0;
            r6 = r6[r7];	 Catch:{ Exception -> 0x0122 }
            r7 = r9.mft;	 Catch:{ Exception -> 0x0122 }
            r7 = r7.mfk;	 Catch:{ Exception -> 0x0122 }
            r7 = r7.sB();	 Catch:{ Exception -> 0x0122 }
            if (r6 > r7) goto L_0x00ec;
        L_0x00db:
            r4 = r4.mJo;	 Catch:{ Exception -> 0x0122 }
            r6 = 1;
            r4 = r4[r6];	 Catch:{ Exception -> 0x0122 }
            r6 = r9.mft;	 Catch:{ Exception -> 0x0122 }
            r6 = r6.mfk;	 Catch:{ Exception -> 0x0122 }
            r6 = r6.sB();	 Catch:{ Exception -> 0x0122 }
            if (r4 <= r6) goto L_0x012f;
        L_0x00ec:
            r0 = r9.mft;	 Catch:{ Exception -> 0x0122 }
            r0 = r0.mfk;	 Catch:{ Exception -> 0x0122 }
            r1 = 13459; // 0x3493 float:1.886E-41 double:6.6496E-320;
            r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0122 }
            r2.<init>();	 Catch:{ Exception -> 0x0122 }
            r2 = r2.append(r5);	 Catch:{ Exception -> 0x0122 }
            r3 = ",1,,0";
            r2 = r2.append(r3);	 Catch:{ Exception -> 0x0122 }
            r2 = r2.toString();	 Catch:{ Exception -> 0x0122 }
            r0.aa(r1, r2);	 Catch:{ Exception -> 0x0122 }
            r0 = r9.mft;	 Catch:{ Exception -> 0x0122 }
            r0 = r0.mContext;	 Catch:{ Exception -> 0x0122 }
            r1 = r9.mft;	 Catch:{ Exception -> 0x0122 }
            r1 = r1.mContext;	 Catch:{ Exception -> 0x0122 }
            r2 = com.tencent.mm.R.l.enT;	 Catch:{ Exception -> 0x0122 }
            r1 = r1.getString(r2);	 Catch:{ Exception -> 0x0122 }
            com.tencent.mm.ui.base.g.bl(r0, r1);	 Catch:{ Exception -> 0x0122 }
            goto L_0x0096;
        L_0x0122:
            r0 = move-exception;
            r1 = "MicroMsg.AlbumAdapter";
            r0 = com.tencent.mm.sdk.platformtools.bg.g(r0);
            com.tencent.mm.sdk.platformtools.w.e(r1, r0);
            goto L_0x0096;
        L_0x012f:
            r4 = r9.mft;
            r4 = r4.mfm;
            r4 = r4.size();
            r5 = r9.mft;
            r5 = r5.mfj;
            if (r4 >= r5) goto L_0x021a;
        L_0x0141:
            r4 = r9.mft;
            r4 = r4.mfm;
            r4.add(r1);
            r1 = r9.mft;
            r1 = r1.mfm;
            r1.size();
            r1 = r3;
            r4 = r3;
            goto L_0x0052;
        L_0x0157:
            r0 = r9.mft;
            r0 = r0.mfo;
            if (r0 != r2) goto L_0x018e;
        L_0x015f:
            r0 = r9.mft;
            r0 = r0.mContext;
            r4 = r9.mft;
            r4 = r4.mContext;
            r4 = r4.getResources();
            r5 = com.tencent.mm.R.j.dsp;
            r6 = r9.mft;
            r6 = r6.mfj;
            r7 = new java.lang.Object[r2];
            r8 = r9.mft;
            r8 = r8.mfj;
            r8 = java.lang.Integer.valueOf(r8);
            r7[r3] = r8;
            r4 = r4.getQuantityString(r5, r6, r7);
            com.tencent.mm.ui.base.g.bl(r0, r4);
            goto L_0x0071;
        L_0x018e:
            r0 = r9.mft;
            r0 = r0.mfo;
            r4 = 2;
            if (r0 != r4) goto L_0x01c6;
        L_0x0197:
            r0 = r9.mft;
            r0 = r0.mContext;
            r4 = r9.mft;
            r4 = r4.mContext;
            r4 = r4.getResources();
            r5 = com.tencent.mm.R.j.dsr;
            r6 = r9.mft;
            r6 = r6.mfj;
            r7 = new java.lang.Object[r2];
            r8 = r9.mft;
            r8 = r8.mfj;
            r8 = java.lang.Integer.valueOf(r8);
            r7[r3] = r8;
            r4 = r4.getQuantityString(r5, r6, r7);
            com.tencent.mm.ui.base.g.bl(r0, r4);
            goto L_0x0071;
        L_0x01c6:
            r0 = r9.mft;
            r0 = r0.mContext;
            r4 = r9.mft;
            r4 = r4.mContext;
            r4 = r4.getResources();
            r5 = com.tencent.mm.R.j.dsq;
            r6 = r9.mft;
            r6 = r6.mfj;
            r7 = new java.lang.Object[r2];
            r8 = r9.mft;
            r8 = r8.mfj;
            r8 = java.lang.Integer.valueOf(r8);
            r7[r3] = r8;
            r4 = r4.getQuantityString(r5, r6, r7);
            com.tencent.mm.ui.base.g.bl(r0, r4);
            goto L_0x0071;
        L_0x01f5:
            r0 = com.tencent.mm.R.h.cjp;
            r0 = r10.getTag(r0);
            r0 = (android.widget.CheckBox) r0;
            r0.setChecked(r2);
            r0 = com.tencent.mm.R.h.cju;
            r0 = r10.getTag(r0);
            r0 = (android.view.View) r0;
            r0.setVisibility(r3);
            r0 = com.tencent.mm.R.h.cju;
            r0 = r10.getTag(r0);
            r0 = (android.view.View) r0;
            r1 = com.tencent.mm.R.e.aUk;
            r0.setBackgroundResource(r1);
            goto L_0x0096;
        L_0x021a:
            r1 = r2;
            r4 = r2;
            goto L_0x0052;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.gallery.ui.a.2.onClick(android.view.View):void");
        }
    };

    public interface a {
        View getView();
    }

    public interface b {
        void A(int i, int i2, int i3);
    }

    private static class c implements Runnable {
        public static HashMap<TextView, c> mfw = new HashMap();
        public WeakReference<TextView> lze;
        public VideoMediaItem mfu;
        public a mfv;

        private interface a {
            void a(c cVar, int i);
        }

        private c(TextView textView, VideoMediaItem videoMediaItem, a aVar) {
            this.lze = new WeakReference(textView);
            this.mfu = videoMediaItem;
            this.mfv = aVar;
        }

        private void f(TextView textView) {
            this.lze = new WeakReference(textView);
        }

        static void a(TextView textView, VideoMediaItem videoMediaItem) {
            Entry entry = null;
            if (textView == null || videoMediaItem == null) {
                w.e("MicroMsg.AlbumAdapter", "Error input for duration fetcher");
                return;
            }
            if (mfw.containsKey(textView)) {
                c cVar = (c) mfw.get(textView);
                if (!cVar.mfu.equals(videoMediaItem)) {
                    if (textView.equals(cVar.lze.get())) {
                        cVar.f(null);
                    }
                } else {
                    return;
                }
            }
            if (videoMediaItem.hTi >= 0) {
                w.i("MicroMsg.AlbumAdapter", "Directly attach durationMs %d to tv, path %s", new Object[]{Integer.valueOf(videoMediaItem.hTi), videoMediaItem});
                c(textView, videoMediaItem.hTi);
                mfw.remove(textView);
                return;
            }
            textView.setText("");
            Runnable cVar2 = new c(textView, videoMediaItem, new a() {
                public final void a(c cVar, int i) {
                    if (cVar != null && cVar.lze != null) {
                        TextView textView = (TextView) cVar.lze.get();
                        if (textView != null) {
                            c.c(textView, i);
                            c.mfw.remove(textView);
                        }
                    }
                }
            });
            if (com.tencent.mm.sdk.f.e.T(cVar2)) {
                w.i("MicroMsg.AlbumAdapter", "task has post to thread pool");
                for (Entry entry2 : mfw.entrySet()) {
                    if (cVar2.equals(entry2.getValue())) {
                        entry = entry2;
                        break;
                    }
                }
                if (entry == null || entry.getValue() == null) {
                    w.e("MicroMsg.AlbumAdapter", "no entry found");
                    return;
                }
                ((c) entry.getValue()).f(textView);
                mfw.remove(entry.getKey());
                mfw.put(textView, entry.getValue());
                return;
            }
            com.tencent.mm.sdk.f.e.post(cVar2, "load_duration_for_" + videoMediaItem.hTf);
            mfw.put(textView, cVar2);
        }

        public static void c(TextView textView, int i) {
            if (textView != null) {
                if (i < 0) {
                    textView.setText("--:--");
                    return;
                }
                int round = Math.round(((float) i) / 1000.0f);
                textView.setText(String.format(Locale.CHINA, "%d:%02d", new Object[]{Integer.valueOf(round / 60), Integer.valueOf(round % 60)}));
            }
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            return this.mfu.equals(((c) obj).mfu);
        }

        public final int hashCode() {
            return this.mfu.hashCode();
        }

        public final void run() {
            Throwable e;
            MediaMetadataRetriever mediaMetadataRetriever;
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(this.mfu.ayB());
                    this.mfu.hTi = bg.getInt(mediaMetadataRetriever.extractMetadata(9), -1);
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Throwable e2) {
                        w.printErrStackTrace("MicroMsg.AlbumAdapter", e2, "%s", new Object[]{e2.getMessage()});
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    try {
                        w.printErrStackTrace("MicroMsg.AlbumAdapter", e2, "Analysis duration of mediaItem %s error %s", new Object[]{this.mfu.hTf, e2.getMessage()});
                        if (mediaMetadataRetriever != null) {
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Throwable e22) {
                                w.printErrStackTrace("MicroMsg.AlbumAdapter", e22, "%s", new Object[]{e22.getMessage()});
                            }
                        }
                        if (Looper.myLooper() == Looper.getMainLooper()) {
                            af.v(new Runnable(this) {
                                final /* synthetic */ c mfx;

                                {
                                    this.mfx = r1;
                                }

                                public final void run() {
                                    if (this.mfx.mfv != null) {
                                        this.mfx.mfv.a(this.mfx, this.mfx.mfu.hTi);
                                    }
                                }
                            });
                        } else if (this.mfv == null) {
                            this.mfv.a(this, this.mfu.hTi);
                        }
                    } catch (Throwable th) {
                        e22 = th;
                        if (mediaMetadataRetriever != null) {
                            try {
                                mediaMetadataRetriever.release();
                            } catch (Throwable e4) {
                                w.printErrStackTrace("MicroMsg.AlbumAdapter", e4, "%s", new Object[]{e4.getMessage()});
                            }
                        }
                        throw e22;
                    }
                }
            } catch (Exception e5) {
                e22 = e5;
                mediaMetadataRetriever = null;
                w.printErrStackTrace("MicroMsg.AlbumAdapter", e22, "Analysis duration of mediaItem %s error %s", new Object[]{this.mfu.hTf, e22.getMessage()});
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    af.v(/* anonymous class already generated */);
                } else if (this.mfv == null) {
                    this.mfv.a(this, this.mfu.hTi);
                }
            } catch (Throwable th2) {
                e22 = th2;
                mediaMetadataRetriever = null;
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                throw e22;
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                af.v(/* anonymous class already generated */);
            } else if (this.mfv == null) {
                this.mfv.a(this, this.mfu.hTi);
            }
        }
    }

    private static class d {
        public RelativeLayout mfA;
        public TextView mfB;
        public TextView mfC;
        public CheckBox mfD;
        public View mfE;
        public ImageView mfF;
        public ImageView mfG;
        public ImageView mfH;
        public ImageView mfy;
        public ImageView mfz;
    }

    public final /* synthetic */ Object getItem(int i) {
        return nf(i);
    }

    public a(Context context, b bVar) {
        this.mContext = context;
        this.mfn = bVar;
    }

    public final void a(a aVar) {
        if (aVar == null) {
            w.w("MicroMsg.AlbumAdapter", "addHeader error, header is null");
            return;
        }
        this.mfp.remove(aVar);
        this.mfp.add(aVar);
    }

    public final ArrayList<String> ayQ() {
        ArrayList<String> arrayList = new ArrayList();
        Iterator it = this.mfm.iterator();
        while (it.hasNext()) {
            arrayList.add(((MediaItem) it.next()).hTf);
        }
        return arrayList;
    }

    public final void B(ArrayList<String> arrayList) {
        w.d("MicroMsg.AlbumAdapter", "before set selected paths, selected[%s]", new Object[]{this.mfm});
        this.mfm.clear();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                MediaItem a = MediaItem.a(0, 0, str, str, "");
                if (com.tencent.mm.plugin.gallery.model.c.aym() != null) {
                    int indexOf = com.tencent.mm.plugin.gallery.model.c.aym().indexOf(a);
                    if (indexOf >= 0) {
                        a = (MediaItem) com.tencent.mm.plugin.gallery.model.c.aym().get(indexOf);
                        if (a != null && a.getType() == 2) {
                            this.mfm.add(MediaItem.a(2, 0, str, "", ""));
                        }
                    }
                }
                w.d("MicroMsg.AlbumAdapter", "media item no exist on preview items.");
                int i = 1;
                long j = 0;
                String str2 = str;
                this.mfm.add(MediaItem.a(i, j, str2, "", ""));
            }
        }
        w.d("MicroMsg.AlbumAdapter", "after set selected paths, selected[%s]", new Object[]{this.mfm});
    }

    public final ArrayList<MediaItem> ne(int i) {
        ArrayList<MediaItem> arrayList = new ArrayList();
        Iterator it = this.mfl.iterator();
        while (it.hasNext()) {
            MediaItem mediaItem = (MediaItem) it.next();
            if (mediaItem.getType() == i) {
                arrayList.add(mediaItem);
            }
        }
        return arrayList;
    }

    public final int getCount() {
        return this.mfp.size() + this.mfl.size();
    }

    public final int getViewTypeCount() {
        return this.mfp.size() + 1;
    }

    public final int getItemViewType(int i) {
        return i < this.mfp.size() ? i : this.mfp.size();
    }

    public final MediaItem nf(int i) {
        if (i < this.mfp.size()) {
            w.i("MicroMsg.AlbumAdapter", "get header, pos[%d]", new Object[]{Integer.valueOf(i)});
            return null;
        }
        int size = i - this.mfp.size();
        if (size < this.mfl.size()) {
            return (MediaItem) this.mfl.get(size);
        }
        w.w("MicroMsg.AlbumAdapter", "get item error, media items size[%d], adjustPos[%d]", new Object[]{Integer.valueOf(this.mfl.size()), Integer.valueOf(size)});
        MediaItem imageMediaItem = new ImageMediaItem();
        imageMediaItem.meH = bg.Nz();
        return imageMediaItem;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        w.v("MicroMsg.AlbumAdapter", "duanyi getview index[%d] header size[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(this.mfp.size())});
        if (i < this.mfp.size()) {
            w.i("MicroMsg.AlbumAdapter", "position[%d], get header view", new Object[]{Integer.valueOf(i)});
            return ((a) this.mfp.get(i)).getView();
        }
        View inflate;
        d dVar;
        int size = i - this.mfp.size();
        MediaItem mediaItem = (MediaItem) this.mfl.get(size);
        w.i("MicroMsg.AlbumAdapter", "addtime:%s", new Object[]{Long.valueOf(mediaItem.meH)});
        if (view == null || !(view.getTag() instanceof d)) {
            String str = "MicroMsg.AlbumAdapter";
            String str2 = "converview is null?[%B]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(view == null);
            w.d(str, str2, objArr);
            inflate = LayoutInflater.from(this.mContext).inflate(R.i.dne, viewGroup, false);
            d dVar2 = new d();
            dVar2.mfy = (ImageView) inflate.findViewById(R.h.cjw);
            dVar2.mfz = (ImageView) inflate.findViewById(R.h.cjz);
            dVar2.mfA = (RelativeLayout) inflate.findViewById(R.h.cLU);
            dVar2.mfB = (TextView) inflate.findViewById(R.h.cLV);
            dVar2.mfD = (CheckBox) inflate.findViewById(R.h.cjp);
            dVar2.mfC = (TextView) inflate.findViewById(R.h.cBZ);
            dVar2.mfE = inflate.findViewById(R.h.cjq);
            dVar2.mfF = (ImageView) inflate.findViewById(R.h.cju);
            dVar2.mfE.setOnClickListener(this.mfr);
            dVar2.mfE.setTag(R.h.cjp, dVar2.mfD);
            dVar2.mfE.setTag(R.h.cBZ, dVar2.mfC);
            dVar2.mfE.setTag(R.h.cju, dVar2.mfF);
            if (com.tencent.mm.plugin.gallery.model.c.ayk().ayM() == 0 || com.tencent.mm.plugin.gallery.model.c.ayk().ayM() == 5 || com.tencent.mm.plugin.gallery.model.c.ayk().ayM() == 10 || com.tencent.mm.plugin.gallery.model.c.ayk().ayM() == 11) {
                dVar2.mfD.setVisibility(8);
                dVar2.mfC.setVisibility(8);
                dVar2.mfE.setVisibility(8);
                dVar2.mfF.setVisibility(8);
            }
            dVar2.mfG = (ImageView) inflate.findViewById(R.h.bVn);
            dVar2.mfH = (ImageView) inflate.findViewById(R.h.bKL);
            inflate.setTag(dVar2);
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
            inflate = view;
        }
        if (mediaItem == null) {
            w.e("MicroMsg.AlbumAdapter", "get item failed");
            return inflate;
        }
        dVar.mfy.setVisibility(0);
        if (mediaItem.getType() == 2) {
            dVar.mfA.setVisibility(0);
            c.a(dVar.mfB, (VideoMediaItem) mediaItem);
        } else {
            dVar.mfA.setVisibility(8);
        }
        if (mediaItem.mMimeType.equalsIgnoreCase("edit")) {
            dVar.mfH.setVisibility(0);
        } else {
            dVar.mfH.setVisibility(8);
        }
        str2 = mediaItem.ayB();
        String str3 = mediaItem.hTf;
        if (bg.mA(str2) && bg.mA(str3)) {
            w.e("MicroMsg.AlbumAdapter", "null or nil filepath: " + size);
            return inflate;
        }
        dVar.mfE.setTag(R.h.cjq, Integer.valueOf(size));
        int i2 = R.l.eFZ;
        if (mediaItem.getType() == 2) {
            i2 = R.l.cMl;
        }
        w.d("MicroMsg.AlbumAdapter", "thumbFilaPath: %s | origFilePath: %s | contentDescription %s", new Object[]{str2, str3, viewGroup.getContext().getString(i2, new Object[]{Integer.valueOf((i + 1) - this.mfp.size()), this.kFt.format(new Date(mediaItem.meH))})});
        dVar.mfz.setContentDescription(r2);
        final ImageView imageView = dVar.mfy;
        h.a(dVar.mfz, mediaItem.getType(), str2, str3, mediaItem.meG, -1, new com.tencent.mm.plugin.gallery.ui.h.a(this) {
            final /* synthetic */ a mft;

            public final void ayR() {
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            }
        });
        if (this.mfq) {
            if (mediaItem.getType() == 2) {
                dVar.mfD.setVisibility(8);
                dVar.mfC.setVisibility(8);
                dVar.mfE.setVisibility(8);
                dVar.mfF.setVisibility(8);
            } else if (this.mfm.contains(mediaItem)) {
                dVar.mfD.setChecked(true);
                dVar.mfC.setText((mediaItem == null ? -1 : this.mfm.indexOf(mediaItem)));
                dVar.mfF.setBackgroundResource(R.e.aUk);
                dVar.mfE.setVisibility(0);
                dVar.mfD.setVisibility(0);
                dVar.mfF.setVisibility(0);
            } else {
                dVar.mfC.setVisibility(8);
                dVar.mfD.setChecked(false);
                dVar.mfF.setBackgroundResource(R.g.bfR);
                dVar.mfD.setVisibility(0);
                dVar.mfE.setVisibility(0);
                dVar.mfF.setVisibility(0);
            }
        } else if (this.mfm.contains(mediaItem)) {
            dVar.mfD.setChecked(true);
            dVar.mfF.setVisibility(0);
            dVar.mfF.setBackgroundResource(R.e.aUk);
        } else {
            dVar.mfD.setChecked(false);
            dVar.mfC.setVisibility(8);
            dVar.mfF.setVisibility(0);
            dVar.mfF.setBackgroundResource(R.g.bfR);
        }
        if ((com.tencent.mm.plugin.gallery.model.c.ayk().ayM() == 3 || com.tencent.mm.plugin.gallery.model.c.ayk().ayM() == 11) && mediaItem != null && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
            dVar.mfG.setVisibility(0);
        } else {
            dVar.mfG.setVisibility(8);
        }
        return inflate;
    }

    public final long kS(int i) {
        if (i < this.mfp.size()) {
            w.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", new Object[]{Integer.valueOf(i)});
            i = this.mfp.size();
        }
        w.v("MicroMsg.AlbumAdapter", "getHeaderId, adjust pos[%d], date[%d] date[%s], headerID[%d]", new Object[]{Integer.valueOf(i), Long.valueOf(nf(i).meH), r1, Long.valueOf(com.tencent.mm.ui.gridviewheaders.a.bZj().a(new Date(nf(i).meH)))});
        return com.tencent.mm.ui.gridviewheaders.a.bZj().a(new Date(nf(i).meH));
    }

    public final String ng(int i) {
        if (i < this.mfp.size()) {
            w.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", new Object[]{Integer.valueOf(i)});
            i = this.mfp.size();
        }
        return com.tencent.mm.ui.gridviewheaders.a.bZj().a(new Date(nf(i).meH), this.mContext);
    }

    public final View a(int i, View view, ViewGroup viewGroup) {
        View textView;
        if (i < this.mfp.size()) {
            w.d("MicroMsg.AlbumAdapter", "want to get header view headerId, old pos[%d]", new Object[]{Integer.valueOf(i)});
            i = this.mfp.size();
        }
        if (view == null || view.getParent() != null) {
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            textView = new TextView(this.mContext);
            textView.setBackgroundResource(R.g.bgh);
            int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.f.aXR);
            int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(R.f.aXR);
            textView.setPadding(dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize);
            textView.setTextColor(this.mContext.getResources().getColor(R.e.aTS));
            textView.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(R.f.aXs));
            textView.setTypeface(null, 1);
            textView.setLayoutParams(layoutParams);
        } else {
            textView = view;
        }
        w.v("MicroMsg.AlbumAdapter", "getHeaderView, adjust pos[%d], date[%d] date[%s], headerStr[%s]", new Object[]{Integer.valueOf(i), Long.valueOf(r0.meH), new Date(nf(i).meH), com.tencent.mm.ui.gridviewheaders.a.bZj().a(new Date(nf(i).meH), this.mContext)});
        ((TextView) textView).setText(r3);
        return textView;
    }
}
