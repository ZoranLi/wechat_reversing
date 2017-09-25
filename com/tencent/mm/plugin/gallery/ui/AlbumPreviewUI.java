package com.tencent.mm.plugin.gallery.ui;

import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.model.g.b;
import com.tencent.mm.plugin.gallery.model.l;
import com.tencent.mm.plugin.gallery.stub.GalleryStubService;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.DrawedCallBackFrameLayout;
import com.tencent.mm.ui.base.g;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@com.tencent.mm.ui.base.a(19)
public class AlbumPreviewUI extends MMActivity implements b {
    private String fOu;
    private ProgressDialog isv;
    private GridView mfI;
    private TextView mfJ;
    private boolean mfK;
    private boolean mfL;
    private TextView mfM;
    private a mfN;
    private TextView mfO;
    private TextView mfP;
    private ImageFolderMgrView mfQ;
    private TextView mfR;
    private ImageButton mfS;
    private String mfT;
    private String mfU;
    private int mfV;
    private String mfW;
    private boolean mfX = false;
    private boolean mfY = false;
    private boolean mfZ = false;
    private com.tencent.mm.plugin.gallery.stub.a mfk = null;
    private boolean mga = false;
    private boolean mgb = false;
    private boolean mgc = false;
    private boolean mgd = false;
    private int mge;
    private int mgf;
    boolean mgg = false;
    private int mgh = 0;
    private int mgi = 0;
    private long mgj = 0;
    private long mgk;
    private int mgl = -1;
    private ServiceConnection mgm = new ServiceConnection(this) {
        final /* synthetic */ AlbumPreviewUI mgr;

        {
            this.mgr = r1;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            w.d("MicroMsg.AlbumPreviewUI", "onServiceConnected");
            this.mgr.mfk = com.tencent.mm.plugin.gallery.stub.a.a.O(iBinder);
            if (this.mgr.mfN != null) {
                this.mgr.mfN.mfk = this.mgr.mfk;
            }
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            w.d("MicroMsg.AlbumPreviewUI", "onServiceDisconnected");
            this.mgr.mfk = null;
        }
    };
    private long mgn = -1;
    private com.tencent.mm.plugin.gallery.ui.a.a mgo = new com.tencent.mm.plugin.gallery.ui.a.a(this) {
        private OnClickListener lJz = new OnClickListener(this) {
            final /* synthetic */ AnonymousClass7 mgv;

            {
                this.mgv = r1;
            }

            private void ayU() {
                String stringExtra = this.mgv.mgr.getIntent().getStringExtra("to_user");
                String stringExtra2 = this.mgv.mgr.getIntent().getStringExtra("file_name");
                String stringExtra3 = this.mgv.mgr.getIntent().getStringExtra("video_path");
                String stringExtra4 = this.mgv.mgr.getIntent().getStringExtra("video_full_path");
                String stringExtra5 = this.mgv.mgr.getIntent().getStringExtra("video_thumb_path");
                try {
                    Intent intent = new Intent();
                    intent.setClassName(this.mgv.mgr.uSU.uTo.getPackageName(), "com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderUI");
                    intent.putExtra("VideoRecorder_ToUser", stringExtra);
                    intent.putExtra("VideoRecorder_FileName", stringExtra2);
                    intent.putExtra("VideoRecorder_VideoPath", stringExtra3);
                    intent.putExtra("VideoRecorder_VideoFullPath", stringExtra4);
                    intent.putExtra("VideoRecorder_VideoThumbPath", stringExtra5);
                    w.d("MicroMsg.AlbumPreviewUI", "try to record video, dump intent:\n%s", new Object[]{intent});
                    this.mgv.mgr.startActivityForResult(intent, 4371);
                } catch (Exception e) {
                    w.w("MicroMsg.AlbumPreviewUI", e.toString());
                    if (!com.tencent.mm.n.a.aI(this.mgv.mgr.uSU.uTo) && !com.tencent.mm.n.a.aH(this.mgv.mgr.uSU.uTo)) {
                        com.tencent.mm.compatible.i.b.b(this.mgv.mgr.uSU.uTo, 4372);
                    }
                }
            }

            public final void onClick(View view) {
                w.d("MicroMsg.AlbumPreviewUI", "on click open camera, valid click times[%d]", new Object[]{Integer.valueOf(this.mgv.mgr.mgh)});
                if (this.mgv.mgr.mgd) {
                    w.w("MicroMsg.AlbumPreviewUI", "click open camera, but camera is opening");
                    return;
                }
                AlbumPreviewUI.C(this.mgv.mgr);
                this.mgv.mgr.mgd = true;
                if (c.ayk().ayN() == 2 || c.ayk().ayM() == 13) {
                    if (this.mgv.mgr.getIntent().getBooleanExtra("record_video_force_sys_camera", false)) {
                        int intExtra = this.mgv.mgr.getIntent().getIntExtra("record_video_quality", 0);
                        int intExtra2 = this.mgv.mgr.getIntent().getIntExtra("record_video_time_limit", 0);
                        k.a(this.mgv.mgr.uSU.uTo, this.mgv.mgr.getIntent().getStringExtra("video_full_path"), 4372, intExtra2, intExtra, false);
                    } else if (this.mgv.mgr.getIntent().getBooleanExtra("record_video_is_sight_capture", false)) {
                        if (((SightParams) this.mgv.mgr.getIntent().getParcelableExtra("KEY_SIGHT_PARAMS")) == null) {
                            w.e("MicroMsg.AlbumPreviewUI", "takeMMSight, sightParams == null");
                        }
                        if (c.ayk().ayM() != 13) {
                            k.a(this.mgv.mgr.uSU.uTo, 4375, this.mgv.mgr.getIntent(), 3, 1);
                        } else {
                            k.a(this.mgv.mgr.uSU.uTo, 4375, this.mgv.mgr.getIntent(), 4, 1);
                        }
                    } else if (p.gRl.gQa == 2) {
                        ayU();
                    } else if (p.gRl.gQa != 1 || com.tencent.mm.n.a.aI(this.mgv.mgr.uSU.uTo) || com.tencent.mm.n.a.aH(this.mgv.mgr.uSU.uTo)) {
                        ayU();
                    } else {
                        com.tencent.mm.compatible.i.b.b(this.mgv.mgr.uSU.uTo, 4372);
                    }
                } else if (c.ayk().ayN() == 1 || c.ayk().ayN() == 3) {
                    File file = new File(e.gSz);
                    if (file.exists() || file.mkdir()) {
                        w.i("MicroMsg.AlbumPreviewUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.mgv.mgr.uSU.uTo, "android.permission.CAMERA", 16, "", "")), bg.bJZ(), this.mgv.mgr.uSU.uTo});
                        if (com.tencent.mm.pluginsdk.i.a.a(this.mgv.mgr.uSU.uTo, "android.permission.CAMERA", 16, "", "")) {
                            this.mgv.mgr.adG();
                            return;
                        }
                        return;
                    }
                    Toast.makeText(this.mgv.mgr.uSU.uTo, this.mgv.mgr.getString(R.l.dVI), 1).show();
                }
            }
        };
        final /* synthetic */ AlbumPreviewUI mgr;

        {
            this.mgr = r2;
        }

        public final View getView() {
            View inflate = View.inflate(this.mgr.uSU.uTo, R.i.cXg, null);
            inflate.setOnClickListener(this.lJz);
            TextView textView = (TextView) inflate.findViewById(R.h.cjz);
            if (c.ayk().ayN() == 2 || c.ayk().ayM() == 13) {
                textView.setText(R.l.eoj);
            } else if (c.ayk().ayN() == 1) {
                textView.setText(R.l.eoi);
            }
            inflate.setLayerType(1, null);
            return inflate;
        }
    };
    private boolean mgp = false;
    private HashMap<String, Integer> mgq = new HashMap();
    private String toUser;

    private static class a implements Runnable {
        public ArrayList<MediaItem> mgA;
        public WeakReference<a> mgy;
        public WeakReference<ProgressDialog> mgz;

        public final void run() {
            String str = "MicroMsg.AlbumPreviewUI";
            String str2 = "on NotifyMediaItemsChanged, size %d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(this.mgA == null ? -1 : this.mgA.size());
            w.d(str, str2, objArr);
            if (this.mgy != null) {
                a aVar = (a) this.mgy.get();
                if (aVar != null) {
                    AlbumPreviewUI.D(this.mgA);
                    aVar.mfl.addAll(this.mgA);
                    aVar.notifyDataSetChanged();
                    if (this.mgz != null) {
                        ProgressDialog progressDialog = (ProgressDialog) this.mgz.get();
                        if (progressDialog != null && progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }
                    }
                }
            }
        }

        public final String toString() {
            return super.toString() + "|notifyRunnable";
        }
    }

    static /* synthetic */ int C(AlbumPreviewUI albumPreviewUI) {
        int i = albumPreviewUI.mgh + 1;
        albumPreviewUI.mgh = i;
        return i;
    }

    static /* synthetic */ void D(ArrayList arrayList) {
        long currentTimeMillis = System.currentTimeMillis();
        w.i("MicroMsg.AlbumPreviewUI", "[filterEditMediaItem] size:%s", new Object[]{Integer.valueOf(arrayList.size())});
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            MediaItem mediaItem = (MediaItem) it.next();
            Iterator it2 = c.ayn().iterator();
            while (it2.hasNext()) {
                MediaItem mediaItem2 = (MediaItem) it2.next();
                if (mediaItem2.meE.equals(mediaItem.hTf)) {
                    w.d("MicroMsg.AlbumPreviewUI", "item:%s replace editItem:%s", new Object[]{mediaItem, mediaItem2});
                    arrayList.set(i, mediaItem2);
                }
                if (mediaItem2.hTf.equals(mediaItem.hTf)) {
                    w.d("MicroMsg.AlbumPreviewUI", "remove editItem:%s", new Object[]{mediaItem2});
                    arrayList2.add(Integer.valueOf(i));
                }
            }
            i++;
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            arrayList.remove(((Integer) it3.next()).intValue());
        }
        w.d("MicroMsg.AlbumPreviewUI", "[filterEditMediaItem] cost%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    static /* synthetic */ void a(AlbumPreviewUI albumPreviewUI, MediaItem mediaItem) {
        if (c.ayk().ayM() == 3 && albumPreviewUI.mgb && 26214400 < com.tencent.mm.a.e.aN(mediaItem.hTf)) {
            w.w("MicroMsg.AlbumPreviewUI", "[checkRawImageItem] item:%s file size:%s", new Object[]{mediaItem, Integer.valueOf(com.tencent.mm.a.e.aN(mediaItem.hTf))});
            g.bk(albumPreviewUI, albumPreviewUI.getString(R.l.enX));
        }
    }

    static /* synthetic */ void e(AlbumPreviewUI albumPreviewUI) {
        if (albumPreviewUI.mgb) {
            Iterator it = albumPreviewUI.mfN.mfm.iterator();
            int i = 0;
            int i2 = 0;
            while (it.hasNext()) {
                int i3;
                MediaItem mediaItem = (MediaItem) it.next();
                if (mediaItem == null || mediaItem.getType() != 1) {
                    i3 = i;
                    i = i2;
                } else {
                    if (26214400 < com.tencent.mm.a.e.aN(mediaItem.hTf)) {
                        w.w("MicroMsg.AlbumPreviewUI", "[onClick] item:%s file size:%s", new Object[]{mediaItem, Integer.valueOf(com.tencent.mm.a.e.aN(mediaItem.hTf))});
                        i2++;
                    }
                    i3 = i + 1;
                    i = i2;
                }
                i2 = i;
                i = i3;
            }
            if (i2 <= 0) {
                return;
            }
            if (i == i2) {
                g.bk(albumPreviewUI, albumPreviewUI.getString(R.l.enX));
            } else {
                g.bk(albumPreviewUI, albumPreviewUI.getString(R.l.enU));
            }
        }
    }

    static /* synthetic */ void g(AlbumPreviewUI albumPreviewUI) {
        if (albumPreviewUI.mfN.mfm.size() > 0) {
            albumPreviewUI.kr(true);
        } else {
            albumPreviewUI.kr(false);
        }
    }

    static /* synthetic */ void s(AlbumPreviewUI albumPreviewUI) {
        g.h(albumPreviewUI, R.l.faf, R.l.eog);
        w.w("MicroMsg.AlbumPreviewUI", "video is import error");
    }

    static /* synthetic */ void t(AlbumPreviewUI albumPreviewUI) {
        g.h(albumPreviewUI, R.l.eoe, R.l.eog);
        w.w("MicroMsg.AlbumPreviewUI", "video is over size");
    }

    static /* synthetic */ int u(AlbumPreviewUI albumPreviewUI) {
        int i = albumPreviewUI.mgi + 1;
        albumPreviewUI.mgi = i;
        return i;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mgk = System.currentTimeMillis();
        w.i("MicroMsg.AlbumPreviewUI", "onCreate");
        if (bundle != null) {
            w.i("MicroMsg.AlbumPreviewUI", "savedInstanceState not null");
            this.mgf = bundle.getInt("constants_key");
            c.ayk().nd(this.mgf);
        }
        getString(R.l.dIO);
        this.isv = g.a(this, getString(R.l.dJd), true, new OnCancelListener(this) {
            final /* synthetic */ AlbumPreviewUI mgr;

            {
                this.mgr = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        int intExtra = getIntent().getIntExtra("query_source_type", 3);
        int intExtra2 = getIntent().getIntExtra("query_media_type", 1);
        w.i("MicroMsg.AlbumPreviewUI", "query souce: " + intExtra + ", queryType: " + intExtra2);
        c.ayk().nc(intExtra2);
        c.ayk().nd(intExtra);
        KC();
        c.ayk().meW.add(this);
        this.mgn = System.currentTimeMillis();
        l ayk = c.ayk();
        ayk.e(this.mfU, ayk.meY, this.mgn);
        bindService(new Intent(this.uSU.uTo, GalleryStubService.class), this.mgm, 1);
    }

    protected void onPause() {
        super.onPause();
        this.mgd = true;
        c.ayl().ayz().removeCallbacksAndMessages(null);
        c.ayl().ayA();
        w.d("MicroMsg.AlbumPreviewUI", "shouldSaveLastChoosePath: " + this.mfY);
        if (this.mfY) {
            ayS();
        }
        if (this.mfQ.To) {
            ImageFolderMgrView imageFolderMgrView = this.mfQ;
            if (!imageFolderMgrView.To) {
                w.w("MicroMsg.ImageFolderMgrView", "want to close, but it was closed");
            } else if (imageFolderMgrView.mgZ) {
                w.d("MicroMsg.ImageFolderMgrView", "want to close, but it is in animation");
            } else {
                imageFolderMgrView.mgV.setVisibility(8);
                imageFolderMgrView.To = false;
            }
        }
    }

    protected void onResume() {
        super.onResume();
        w.d("MicroMsg.AlbumPreviewUI", "on resume");
        this.mgd = false;
    }

    protected void onDestroy() {
        super.onDestroy();
        w.i("MicroMsg.AlbumPreviewUI", "onDestroy");
        c.ayk().b(this.mfQ);
        c.ayk().meW.remove(this);
        if (this.mgh > 0 || this.mgi > 0) {
            w.d("MicroMsg.AlbumPreviewUI", "report click camera count[%d], click folder count[%d]", new Object[]{Integer.valueOf(this.mgh), Integer.valueOf(this.mgi)});
            try {
                this.mfk.aa(11187, this.mgh + "," + this.mgi);
            } catch (Throwable e) {
                w.e("MicroMsg.AlbumPreviewUI", "report error, %s", new Object[]{e.getMessage()});
                w.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
            }
        } else {
            w.w("MicroMsg.AlbumPreviewUI", "do not click camera or folder!");
        }
        try {
            if (this.mgj > 0 || this.mfL) {
                c.a(this.mfk, this.mfW, C(this.mfN.mfm), this.mgb, this.mfK);
            }
            c.a(this.mfk, this.mfN.mfm.size(), this.mgb);
        } catch (Throwable e2) {
            w.printErrStackTrace("MicroMsg.AlbumPreviewUI", e2, "", new Object[0]);
        }
        sendBroadcast(new Intent("com.tencent.mm..plugin.photoedit.action.clear"));
        c.ayn().clear();
        c.ayo().clear();
        c.ayp().clear();
        try {
            unbindService(this.mgm);
        } catch (Throwable e22) {
            w.printErrStackTrace("MicroMsg.AlbumPreviewUI", e22, "Failed to unbindService when Activity.onDestroy is invoked.", new Object[0]);
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        this.mgf = c.ayk().ayM();
        bundle.putInt("constants_key", this.mgf);
    }

    protected final int getLayoutId() {
        return R.i.dnd;
    }

    private void ajj() {
        if (c.ayk().ayN() == 3) {
            zi(R.l.enu);
            this.mfM.setText(R.l.enu);
        } else if (c.ayk().ayN() == 1) {
            zi(R.l.eod);
            this.mfM.setText(R.l.ent);
        } else {
            zi(R.l.env);
            this.mfM.setText(R.l.env);
        }
    }

    private static int[] C(ArrayList<MediaItem> arrayList) {
        int[] iArr = new int[4];
        iArr[0] = arrayList.size();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            MediaItem mediaItem = (MediaItem) it.next();
            if (mediaItem != null) {
                if (!bg.mA(mediaItem.mMimeType) && mediaItem.mMimeType.equalsIgnoreCase("image/gif")) {
                    iArr[2] = iArr[2] + 1;
                } else if (mediaItem.getType() == 2) {
                    iArr[3] = iArr[3] + 1;
                } else if (mediaItem.getType() == 1) {
                    iArr[1] = iArr[1] + 1;
                }
            }
        }
        return iArr;
    }

    private void a(AlbumItem albumItem) {
        if (albumItem != null) {
            if (bg.ap(this.mfU, "").equals(albumItem.meC)) {
                w.w("MicroMsg.AlbumPreviewUI", "want to reset folder, same folder, return");
                return;
            }
            c.ayp().addAll(this.mfN.mfm);
            w.d("MicroMsg.AlbumPreviewUI", "reset folder[%s], path[%s]", new Object[]{albumItem.meC, albumItem.ayB()});
            this.mfT = albumItem.ayB();
            this.mfU = albumItem.meC;
            if (albumItem.meD != null) {
                this.mfV = albumItem.meD.getType();
            }
            if (bg.mA(this.mfT)) {
                w.w("MicroMsg.AlbumPreviewUI", "reset folder path failed");
                this.mfT = this.mfU;
            }
            if (bg.mA(this.mfU)) {
                if (getIntent().getBooleanExtra("show_header_view", true)) {
                    this.mfN.a(this.mgo);
                }
                ajj();
                this.mfV = c.ayk().ayN();
            } else {
                a aVar = this.mfN;
                com.tencent.mm.plugin.gallery.ui.a.a aVar2 = this.mgo;
                if (aVar2 == null) {
                    w.w("MicroMsg.AlbumAdapter", "removeHeader error, header is null");
                } else {
                    aVar.mfp.remove(aVar2);
                }
                this.mfM.setText(this.mfU);
            }
            this.mfN.mfl.clear();
            nh(this.mfN.mfm.size());
            this.mfN.notifyDataSetChanged();
            if (this.isv != null) {
                this.isv.dismiss();
            }
            getString(R.l.dIO);
            this.isv = g.a(this, getString(R.l.dJd), true, new OnCancelListener(this) {
                final /* synthetic */ AlbumPreviewUI mgr;

                {
                    this.mgr = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            String str = this.mfU;
            if (albumItem.meD != null) {
                int type = albumItem.meD.getType();
                w.i("MicroMsg.AlbumPreviewUI", "folder type[%d] queryType[%d]", new Object[]{Integer.valueOf(type), Integer.valueOf(c.ayk().ayN())});
                if (c.ayk().ayN() != 2 && albumItem.meD.getType() == 2) {
                    str = "";
                }
                if (bg.mA(albumItem.meC)) {
                    type = 3;
                }
                this.mgn = System.currentTimeMillis();
                c.ayk().e(str, type, this.mgn);
            }
        }
    }

    public final void I(int i, boolean z) {
        boolean z2 = true;
        switch (c.ayk().ayN()) {
            case 3:
                if (!bg.mA(this.fOu) && !"medianote".equals(this.toUser)) {
                    if (bg.NA() - this.mgj < 1000) {
                        w.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
                        return;
                    }
                    w.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
                    MediaItem mediaItem = (MediaItem) this.mfN.mfl.get(i);
                    if (mediaItem.getType() != 2) {
                        try {
                            com.tencent.mm.plugin.gallery.stub.a aVar = this.mfk;
                            String str = mediaItem.hTf;
                            String str2 = this.toUser;
                            if (!this.mfX && this.mgb) {
                                z2 = false;
                            }
                            aVar.a(str, str2, z2, 0, z);
                            return;
                        } catch (Exception e) {
                            return;
                        }
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final void KC() {
        boolean z;
        for (String str : getIntent().getExtras().keySet()) {
            w.d("MicroMsg.AlbumPreviewUI", "key=%s | value=%s", new Object[]{str, getIntent().getExtras().get(str)});
        }
        this.fOu = getIntent().getStringExtra("GalleryUI_FromUser");
        this.toUser = getIntent().getStringExtra("GalleryUI_ToUser");
        this.mge = getIntent().getIntExtra("max_select_count", 9);
        this.mfX = c.ayk().ayM() == 4;
        if (c.ayk().ayM() == 5) {
            z = true;
        } else {
            z = false;
        }
        this.mfZ = z;
        if (c.ayk().ayM() == 9) {
            z = true;
        } else {
            z = false;
        }
        this.mga = z;
        this.mfT = getIntent().getStringExtra("folder_path");
        this.mfU = getIntent().getStringExtra("folder_name");
        if (bg.mA(this.mfT)) {
            w.e("MicroMsg.AlbumPreviewUI", "get folder path failed");
            this.mfT = this.mfU;
        }
        this.mgb = getIntent().getBooleanExtra("key_send_raw_image", false);
        this.mgc = getIntent().getBooleanExtra("key_can_select_video_and_pic", false);
        this.mfR = (TextView) findViewById(R.h.cqq);
        this.mfS = (ImageButton) findViewById(R.h.cqp);
        this.mfR.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AlbumPreviewUI mgr;

            {
                this.mgr = r1;
            }

            public final void onClick(View view) {
                this.mgr.mfS.performClick();
            }
        });
        if (c.ayk().ayM() == 3) {
            this.mfS.setVisibility(0);
            this.mfR.setVisibility(0);
        } else {
            this.mfS.setVisibility(8);
            this.mfR.setVisibility(8);
        }
        if (this.mgb) {
            this.mfS.setImageResource(R.k.dze);
        } else {
            this.mfS.setImageResource(R.k.dzd);
        }
        this.mfS.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AlbumPreviewUI mgr;

            {
                this.mgr = r1;
            }

            public final void onClick(View view) {
                this.mgr.mgb = !this.mgr.mgb;
                AlbumPreviewUI.e(this.mgr);
                this.mgr.mfR.setText(this.mgr.uSU.uTo.getString(R.l.enF) + "");
                if (this.mgr.mgb) {
                    this.mgr.mfS.setImageResource(R.k.dze);
                } else {
                    this.mgr.mfS.setImageResource(R.k.dzd);
                }
                AlbumPreviewUI.g(this.mgr);
            }
        });
        this.mfO = (TextView) findViewById(R.h.bom);
        this.mfP = (TextView) findViewById(R.h.bol);
        this.mfJ = (TextView) findViewById(R.h.cjy);
        if (c.ayk().ayM() == 0 || c.ayk().ayM() == 5 || c.ayk().ayM() == 10 || c.ayk().ayM() == 11) {
            findViewById(R.h.bQV).setVisibility(8);
            this.mfJ.setVisibility(8);
        } else {
            this.mfJ.setVisibility(0);
            this.mfJ.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ AlbumPreviewUI mgr;

                {
                    this.mgr = r1;
                }

                public final void onClick(View view) {
                    this.mgr.mfK = true;
                    Intent intent = new Intent(this.mgr, ImagePreviewUI.class);
                    c.z(this.mgr.mfN.mfl);
                    intent.putStringArrayListExtra("preview_image_list", this.mgr.mfN.ayQ());
                    intent.putExtra("max_select_count", this.mgr.mge);
                    intent.putExtra("send_raw_img", this.mgr.mgb);
                    intent.putExtra("GalleryUI_FromUser", this.mgr.fOu);
                    intent.putExtra("GalleryUI_ToUser", this.mgr.toUser);
                    this.mgr.startActivityForResult(intent, 0);
                }
            });
            if ((c.ayk().ayN() == 1 || c.ayk().ayN() == 2 || c.ayk().ayN() == 3) && this.mge > 0) {
                OnMenuItemClickListener anonymousClass15 = new OnMenuItemClickListener(this) {
                    final /* synthetic */ AlbumPreviewUI mgr;

                    {
                        this.mgr = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        boolean z = false;
                        w.d("MicroMsg.AlbumPreviewUI", "send image, previewImageCount:%d, chooseForTimeline:%b", new Object[]{Integer.valueOf(c.ayr()), Boolean.valueOf(this.mgr.mfX)});
                        try {
                            this.mgr.mfk.aa(11610, (this.mgr.mfX ? 3 : 2) + "," + c.ayr());
                        } catch (Throwable e) {
                            w.e("MicroMsg.AlbumPreviewUI", "report error, %s", new Object[]{e.getMessage()});
                            w.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
                        }
                        if (this.mgr.mgl < 0) {
                            try {
                                this.mgr.mgl = this.mgr.mfk.ayP();
                            } catch (Throwable e2) {
                                this.mgr.mgl = 26214400;
                                w.e("MicroMsg.AlbumPreviewUI", "getMaxSendVideoSize error, %s", new Object[]{e2.getMessage()});
                                w.printErrStackTrace("MicroMsg.AlbumPreviewUI", e2, "", new Object[0]);
                            }
                        }
                        c.ayq();
                        if (this.mgr.mfN.ayQ().size() == 0) {
                            w.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick");
                            this.mgr.setResult(-2);
                            this.mgr.finish();
                        } else {
                            Intent intent = new Intent();
                            int ayN = c.ayk().ayN();
                            if (this.mgr.mfX) {
                                ayN = 1;
                            }
                            if (this.mgr.mgc) {
                                ayN = 1;
                            }
                            ArrayList arrayList;
                            MediaItem mediaItem;
                            if (ayN == 1) {
                                String str = "CropImage_Compress_Img";
                                boolean z2 = this.mgr.mfX ? true : !this.mgr.mgb;
                                intent.putExtra(str, z2);
                                arrayList = this.mgr.mfN.mfm;
                                ArrayList arrayList2 = new ArrayList();
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    mediaItem = (MediaItem) it.next();
                                    if (!mediaItem.mMimeType.equals("edit") || bg.mA(mediaItem.meF)) {
                                        arrayList2.add(mediaItem.hTf);
                                    } else {
                                        arrayList2.add(mediaItem.meF);
                                    }
                                }
                                intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList2);
                                intent.putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.mgr.mgk);
                                this.mgr.mgk = 0;
                                this.mgr.setResult(-1, intent);
                                this.mgr.mfY = true;
                                if (bg.mA(this.mgr.fOu) || "medianote".equals(this.mgr.toUser)) {
                                    this.mgr.finish();
                                } else if (bg.NA() - this.mgr.mgj < 1000) {
                                    w.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
                                } else {
                                    w.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
                                    this.mgr.mgj = bg.NA();
                                    intent.setClassName(this.mgr, "com.tencent.mm.ui.chatting.SendImgProxyUI");
                                    intent.putExtra("GalleryUI_FromUser", this.mgr.fOu);
                                    intent.putExtra("GalleryUI_ToUser", this.mgr.toUser);
                                    this.mgr.startActivityForResult(intent, 4373);
                                }
                            } else if (ayN == 2) {
                                w.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick video");
                                com.tencent.mm.pluginsdk.ui.c.a aVar = new com.tencent.mm.pluginsdk.ui.c.a((String) this.mgr.mfN.ayQ().get(0));
                                aVar.hP = this.mgr.mgl;
                                ayN = aVar.bGl();
                                if (ayN == 0) {
                                    intent.setData(Uri.fromFile(new File((String) this.mgr.mfN.ayQ().get(0))));
                                    intent.putStringArrayListExtra("key_select_video_list", this.mgr.mfN.ayQ());
                                    this.mgr.setResult(-1, intent);
                                    this.mgr.mfY = true;
                                    this.mgr.finish();
                                } else if (ayN == 2) {
                                    AlbumPreviewUI.s(this.mgr);
                                } else {
                                    AlbumPreviewUI.t(this.mgr);
                                }
                            } else if (ayN != 3) {
                                w.i("MicroMsg.AlbumPreviewUI", "onMenuItemClick default");
                                this.mgr.setResult(-2);
                                this.mgr.finish();
                            } else if (bg.NA() - this.mgr.mgj < 1000) {
                                w.w("MicroMsg.AlbumPreviewUI", "sendimg btn event frequence limit");
                            } else {
                                this.mgr.mgj = bg.NA();
                                arrayList = this.mgr.mfN.mfm;
                                ArrayList arrayList3 = new ArrayList();
                                ArrayList arrayList4 = new ArrayList();
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    mediaItem = (MediaItem) it2.next();
                                    if (mediaItem.getType() == 1) {
                                        if (!mediaItem.mMimeType.equals("edit") || bg.mA(mediaItem.meF)) {
                                            arrayList4.add(mediaItem.hTf);
                                        } else {
                                            arrayList4.add(mediaItem.meF);
                                        }
                                    } else if (mediaItem.getType() == 2) {
                                        arrayList3.add(mediaItem.hTf);
                                    }
                                }
                                String str2 = "CropImage_Compress_Img";
                                if (this.mgr.mfX) {
                                    z = true;
                                } else if (!this.mgr.mgb) {
                                    z = true;
                                }
                                intent.putExtra(str2, z);
                                intent.putStringArrayListExtra("key_select_video_list", arrayList3);
                                intent.putExtra("KSelectImgUseTime", System.currentTimeMillis() - this.mgr.mgk);
                                this.mgr.mgk = 0;
                                if (arrayList4.size() > 0) {
                                    intent.setClassName(this.mgr, "com.tencent.mm.ui.chatting.SendImgProxyUI");
                                    intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList4);
                                    intent.putExtra("GalleryUI_FromUser", this.mgr.fOu);
                                    intent.putExtra("GalleryUI_ToUser", this.mgr.toUser);
                                    intent.putExtra("CropImage_limit_Img_Size", 26214400);
                                    w.i("MicroMsg.AlbumPreviewUI", "switch to SendImgProxyUI");
                                    this.mgr.startActivityForResult(intent, 4373);
                                } else {
                                    w.i("MicroMsg.AlbumPreviewUI", "QueryTypeImageAndVideo");
                                    this.mgr.setResult(-1, intent);
                                    this.mgr.finish();
                                }
                            }
                        }
                        return true;
                    }
                };
                if (bg.mA(this.mfW)) {
                    a(0, ni(0), anonymousClass15, com.tencent.mm.ui.l.b.uTY);
                } else {
                    a(0, this.mfW, anonymousClass15);
                }
            }
        }
        this.mfQ = (ImageFolderMgrView) findViewById(R.h.bWJ);
        com.tencent.mm.plugin.gallery.model.g.a aVar = this.mfQ;
        c.ayk().b(aVar);
        c.ayk().a(aVar);
        c.ayk().ayO();
        this.mfQ.mgU = new com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView.a(this) {
            final /* synthetic */ AlbumPreviewUI mgr;

            {
                this.mgr = r1;
            }

            public final void b(AlbumItem albumItem) {
                this.mgr.a(albumItem);
            }
        };
        this.mfW = getIntent().getStringExtra("send_btn_string");
        findViewById(R.h.cjr).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AlbumPreviewUI mgr;

            {
                this.mgr = r1;
            }

            public final void onClick(View view) {
                AlbumPreviewUI.u(this.mgr);
                this.mgr.mfQ.ayV();
                w.d("MicroMsg.AlbumPreviewUI", "click folder times[%d]", new Object[]{Integer.valueOf(this.mgr.mgi)});
            }
        });
        this.mfM = (TextView) findViewById(R.h.cjs);
        if (this.mfZ) {
            ks(false);
        }
        kr(false);
        this.mfI = (GridView) findViewById(R.h.cjt);
        this.mfI.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ AlbumPreviewUI mgr;

            {
                this.mgr = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, final int i, long j) {
                int i2 = 1;
                MediaItem nf;
                if (c.ayk().ayM() == 0 || c.ayk().ayM() == 5 || c.ayk().ayM() == 10 || c.ayk().ayM() == 11) {
                    if (c.ayk().ayN() == 2) {
                        g.a(this.mgr, true, this.mgr.getString(R.l.eoh), "", this.mgr.getString(R.l.dIA), this.mgr.getString(R.l.dGs), new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ AnonymousClass2 mgs;

                            public final void onClick(DialogInterface dialogInterface, int i) {
                                MediaItem nf = this.mgs.mgr.mfN.nf(i);
                                if (nf == null) {
                                    w.w("MicroMsg.AlbumPreviewUI", "get item for video error, null, position %d", new Object[]{Integer.valueOf(i)});
                                    this.mgs.mgr.setResult(0);
                                } else {
                                    w.i("MicroMsg.AlbumPreviewUI", "ShowAlert");
                                    Intent intent = new Intent();
                                    intent.setData(Uri.parse("file://" + Uri.encode(nf.hTf)));
                                    this.mgs.mgr.setResult(-1, intent);
                                }
                                this.mgs.mgr.finish();
                            }
                        }, null);
                        return;
                    }
                    nf = this.mgr.mfN.nf(i);
                    if (nf == null) {
                        w.w("MicroMsg.AlbumPreviewUI", "get item error, null, position %d", new Object[]{Integer.valueOf(i)});
                        this.mgr.setResult(0);
                    } else {
                        Intent intent = new Intent();
                        if (nf.getType() == 2) {
                            intent.putExtra("is_video", true);
                            intent.putExtra("video_full_path", nf.hTf);
                        }
                        if (c.ayk().ayM() == 10) {
                            intent.putExtra("CropImage_OutputPath", nf.hTf);
                        }
                        intent.setData(Uri.parse(Uri.encode(nf.hTf)));
                        w.i("MicroMsg.AlbumPreviewUI", "getItem ok");
                        this.mgr.setResult(-1, intent);
                    }
                    this.mgr.finish();
                } else if (c.ayk().ayM() == 4) {
                    if (i < this.mgr.mfN.mfp.size()) {
                        w.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
                        return;
                    }
                    nf = this.mgr.mfN.nf(i);
                    if (nf == null) {
                        w.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!! MediaItem == null.");
                    } else if (nf.getType() != 2 || this.mgr.mfN.mfm.size() == 0) {
                        r2 = this.mgr.mfN.ne(nf.getType());
                        c.z(r2);
                        r3 = new Intent(this.mgr, ImagePreviewUI.class);
                        r3.putStringArrayListExtra("preview_image_list", this.mgr.mfN.ayQ());
                        r3.putExtra("preview_all", true);
                        r3.putExtra("preview_position", r2.indexOf(nf));
                        this.mgr.I(i - this.mgr.mfN.mfp.size(), true);
                        r3.putExtra("send_raw_img", this.mgr.mgb);
                        r3.putExtra("max_select_count", this.mgr.mge);
                        r3.putExtra("GalleryUI_FromUser", this.mgr.fOu);
                        r3.putExtra("GalleryUI_ToUser", this.mgr.toUser);
                        this.mgr.startActivityForResult(r3, 0);
                    } else {
                        g.bl(this.mgr.uSU.uTo, com.tencent.mm.bg.a.V(this.mgr.uSU.uTo, R.l.enA));
                    }
                } else if (this.mgr.mgc) {
                    if (i < this.mgr.mfN.mfp.size()) {
                        w.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
                        return;
                    }
                    nf = this.mgr.mfN.nf(i);
                    if (nf == null) {
                        w.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!! MediaItem == null.");
                    } else if (nf.getType() != 2 || this.mgr.mfN.mfm.size() == 0) {
                        r2 = this.mgr.mfN.ne(nf.getType());
                        c.z(r2);
                        r3 = new Intent(this.mgr, ImagePreviewUI.class);
                        r3.putStringArrayListExtra("preview_image_list", this.mgr.mfN.ayQ());
                        r3.putExtra("preview_all", true);
                        r3.putExtra("preview_position", r2.indexOf(nf));
                        this.mgr.I(i - this.mgr.mfN.mfp.size(), true);
                        r3.putExtra("send_raw_img", this.mgr.mgb);
                        String str = "max_select_count";
                        if (nf.getType() != 2) {
                            i2 = this.mgr.mge;
                        }
                        r3.putExtra(str, i2);
                        r3.putExtra("GalleryUI_FromUser", this.mgr.fOu);
                        r3.putExtra("GalleryUI_ToUser", this.mgr.toUser);
                        this.mgr.startActivityForResult(r3, 0);
                    } else {
                        g.bl(this.mgr.uSU.uTo, com.tencent.mm.bg.a.V(this.mgr.uSU.uTo, R.l.enA));
                    }
                } else if (i < this.mgr.mfN.mfp.size()) {
                    w.w("MicroMsg.AlbumPreviewUI", "POSITION ERROR!!!");
                } else {
                    c.z(this.mgr.mfN.mfl);
                    Intent intent2 = new Intent(this.mgr, ImagePreviewUI.class);
                    intent2.putStringArrayListExtra("preview_image_list", this.mgr.mfN.ayQ());
                    intent2.putExtra("preview_all", true);
                    intent2.putExtra("preview_position", i - this.mgr.mfN.mfp.size());
                    this.mgr.I(i - this.mgr.mfN.mfp.size(), true);
                    intent2.putExtra("send_raw_img", this.mgr.mgb);
                    intent2.putExtra("max_select_count", this.mgr.mge);
                    intent2.putExtra("GalleryUI_FromUser", this.mgr.fOu);
                    intent2.putExtra("GalleryUI_ToUser", this.mgr.toUser);
                    this.mgr.startActivityForResult(intent2, 0);
                }
            }
        });
        this.mfN = new a(this, new a.b(this) {
            final /* synthetic */ AlbumPreviewUI mgr;

            {
                this.mgr = r1;
            }

            public final void A(int i, int i2, int i3) {
                if (i3 == 0) {
                    MediaItem nf = this.mgr.mfN.nf(this.mgr.mfN.mfp.size() + i2);
                    if (nf != null && nf.getType() == 1) {
                        AlbumPreviewUI.a(this.mgr, nf);
                    } else if (nf != null && nf.getType() == 2) {
                        if (this.mgr.b(nf)) {
                            this.mgr.nh(i);
                            this.mgr.I(i2, true);
                            return;
                        }
                        this.mgr.mfN.mfm.remove(nf);
                        this.mgr.mfN.notifyDataSetChanged();
                        return;
                    }
                    this.mgr.nh(i);
                    this.mgr.I(i2, true);
                    return;
                }
                this.mgr.nh(i);
                this.mgr.I(i2, false);
            }
        });
        if (this.mfX) {
            this.mfN.mfq = true;
        }
        if (this.mgc) {
            this.mfN.mfq = true;
        }
        this.mfI.setNumColumns(3);
        this.mfI.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ AlbumPreviewUI mgr;
            private Runnable mgt = new Runnable(this) {
                final /* synthetic */ AnonymousClass4 mgu;

                {
                    this.mgu = r1;
                }

                public final void run() {
                    this.mgu.mgr.mfO.startAnimation(AnimationUtils.loadAnimation(this.mgu.mgr.uSU.uTo, R.a.aQY));
                    this.mgu.mgr.mfO.setVisibility(8);
                }
            };

            {
                this.mgr = r2;
            }

            private void et(boolean z) {
                if (z) {
                    this.mgr.mfO.removeCallbacks(this.mgt);
                    if (this.mgr.mfO.getVisibility() != 0) {
                        this.mgr.mfO.setText(this.mgr.mfN.ng(this.mgr.mfI.getFirstVisiblePosition()));
                        this.mgr.mfO.clearAnimation();
                        Animation loadAnimation = AnimationUtils.loadAnimation(this.mgr.uSU.uTo, R.a.aQX);
                        this.mgr.mfO.setVisibility(0);
                        this.mgr.mfO.startAnimation(loadAnimation);
                        return;
                    }
                    return;
                }
                this.mgr.mfO.removeCallbacks(this.mgt);
                this.mgr.mfO.postDelayed(this.mgt, 256);
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
                w.d("MicroMsg.AlbumPreviewUI", "scroll state[%d]", new Object[]{Integer.valueOf(i)});
                if (1 == i) {
                    et(true);
                } else if (i == 0) {
                    et(false);
                }
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                this.mgr.mfO.setText(this.mgr.mfN.ng(i));
            }
        });
        if (getIntent().getBooleanExtra("show_header_view", true)) {
            this.mfN.a(this.mgo);
        }
        this.mfN.mfo = c.ayk().ayN();
        this.mfN.mfj = this.mge;
        w.i("MicroMsg.AlbumPreviewUI", "limit count = " + getIntent().getIntExtra("max_select_count", 9));
        this.mfI.setAdapter(this.mfN);
        ajj();
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AlbumPreviewUI mgr;

            {
                this.mgr = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                w.i("MicroMsg.AlbumPreviewUI", "backBtn");
                this.mgr.setResult(-2);
                if (this.mgr.mfQ.To) {
                    this.mgr.mfQ.ayV();
                } else {
                    this.mgr.finish();
                }
                return true;
            }
        });
        ViewGroup viewGroup = (ViewGroup) findViewById(R.h.czn);
        if (viewGroup instanceof DrawedCallBackFrameLayout) {
            ((DrawedCallBackFrameLayout) viewGroup).vgH = new com.tencent.mm.ui.base.DrawedCallBackFrameLayout.a(this) {
                final /* synthetic */ AlbumPreviewUI mgr;

                {
                    this.mgr = r1;
                }

                public final void om() {
                    try {
                        this.mgr.mfk.om();
                    } catch (Throwable e) {
                        w.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
                    }
                    if (this.mgr.mgg) {
                        try {
                            this.mgr.unbindService(this.mgr.mgm);
                        } catch (Throwable e2) {
                            w.printErrStackTrace("MicroMsg.AlbumPreviewUI", e2, "Failed to unbindService when onViewDrawed is invoked.", new Object[0]);
                        }
                        this.mgr.mgg = false;
                    }
                }
            };
        }
    }

    private void adG() {
        if (k.c(this.uSU.uTo, e.gSz, "microMsg." + System.currentTimeMillis() + ".jpg", 4369)) {
            c.ayl().nb(0);
            System.gc();
            return;
        }
        Toast.makeText(this.uSU.uTo, getString(R.l.eQD), 1).show();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            w.i("MicroMsg.AlbumPreviewUI", "onKeyDown");
            setResult(-2);
            if (this.mfQ.To) {
                this.mfQ.ayV();
                return true;
            }
            finish();
            return true;
        } else if (i != 82) {
            return super.onKeyDown(i, keyEvent);
        } else {
            this.mgi++;
            this.mfQ.ayV();
            return true;
        }
    }

    protected final int Ol() {
        return 1;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        w.i("MicroMsg.AlbumPreviewUI", "on activity result, requestCode[%d] resultCode[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        ArrayList arrayList;
        if (4369 != i) {
            ArrayList stringArrayListExtra;
            if (4370 != i) {
                if (4371 != i) {
                    if (4372 != i) {
                        if (4373 != i) {
                            if (4375 != i) {
                                if (4376 != i) {
                                    switch (i2) {
                                        case -2:
                                            w.e("MicroMsg.AlbumPreviewUI", "WTF!!!");
                                            finish();
                                            break;
                                        case -1:
                                            if (intent == null) {
                                                intent = new Intent();
                                                intent.putExtra("CropImage_Compress_Img", true);
                                                intent.putStringArrayListExtra("CropImage_OutputPath_List", this.mfN.ayQ());
                                            }
                                            w.i("MicroMsg.AlbumPreviewUI", "onActivity Result ok");
                                            this.mfL = true;
                                            setResult(-1, intent);
                                            ayS();
                                            finish();
                                            break;
                                        case 0:
                                            if (intent != null) {
                                                boolean z;
                                                stringArrayListExtra = intent.getStringArrayListExtra("preview_image_list");
                                                if (stringArrayListExtra != null) {
                                                    this.mfN.B(stringArrayListExtra);
                                                    this.mfN.notifyDataSetChanged();
                                                    nh(stringArrayListExtra.size());
                                                }
                                                if (intent.getBooleanExtra("CropImage_Compress_Img", true)) {
                                                    z = false;
                                                } else {
                                                    z = true;
                                                }
                                                this.mgb = z;
                                                if (!this.mgb) {
                                                    this.mfS.setImageResource(R.k.dzd);
                                                    break;
                                                } else {
                                                    this.mfS.setImageResource(R.k.dze);
                                                    break;
                                                }
                                            }
                                            break;
                                        default:
                                            break;
                                    }
                                } else if (-1 != i2) {
                                    w.i("MicroMsg.AlbumPreviewUI", "REQUEST_SELECT_FOLDER goBack!");
                                    finish();
                                } else if (intent != null) {
                                    AlbumItem albumItem = (AlbumItem) intent.getParcelableExtra("select_folder_name");
                                    a(albumItem);
                                    qP(bg.ap(albumItem.meC, getString(R.l.enu)));
                                }
                            } else if (-1 == i2) {
                                if (intent == null) {
                                    intent = new Intent();
                                }
                                w.i("MicroMsg.AlbumPreviewUI", "sight capture record video, result[%s]", new Object[]{intent});
                                SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                                if (sightCaptureResult == null) {
                                    w.e("MicroMsg.AlbumPreviewUI", "sight capture result is null!");
                                    setResult(1);
                                    finish();
                                }
                                Serializable arrayList2 = new ArrayList();
                                String str = sightCaptureResult.nAw;
                                if (!bg.mA(str)) {
                                    arrayList2.add(str);
                                    intent.putExtra("key_select_video_list", arrayList2);
                                }
                                if (sightCaptureResult.nAu && !bg.mA(sightCaptureResult.nAC)) {
                                    arrayList = new ArrayList();
                                    arrayList.add(sightCaptureResult.nAC);
                                    intent.putStringArrayListExtra("CropImage_OutputPath_List", arrayList);
                                }
                                setResult(-1, intent);
                                finish();
                            } else {
                                return;
                            }
                        }
                        if (intent != null) {
                            intent.putExtra("GalleryUI_IsSendImgBackground", true);
                            w.e("MicroMsg.AlbumPreviewUI", "send img background, data is null!!");
                        }
                        w.i("MicroMsg.AlbumPreviewUI", "Request code sendimg proxy");
                        setResult(-1, intent);
                        this.mgg = true;
                        finish();
                    } else if (-1 == i2) {
                        if (intent == null) {
                            intent = new Intent();
                        }
                        w.i("MicroMsg.AlbumPreviewUI", "system record video, result[%s]", new Object[]{intent});
                        Serializable arrayList3 = new ArrayList();
                        String stringExtra = getIntent().getStringExtra("video_full_path");
                        if (!bg.mA(stringExtra)) {
                            arrayList3.add(stringExtra);
                            intent.putExtra("key_select_video_list", arrayList3);
                            intent.putExtra("key_selected_video_is_from_sys_camera", true);
                        }
                        setResult(-1, intent);
                        finish();
                    } else {
                        return;
                    }
                } else if (-1 == i2) {
                    if (intent != null) {
                        intent.putExtra("from_record", true);
                    }
                    w.i("MicroMsg.AlbumPreviewUI", "custom record video, result[%s]", new Object[]{intent});
                    setResult(-1, intent);
                    finish();
                } else {
                    return;
                }
            } else if (-1 != i2) {
                return;
            } else {
                if (intent.getBooleanExtra("GalleryUI_IsSendImgBackground", false)) {
                    w.i("MicroMsg.AlbumPreviewUI", "test onActivityResult");
                    setResult(-1, intent);
                    finish();
                    return;
                }
                stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                if (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) {
                    w.w("MicroMsg.AlbumPreviewUI", "send filepath is null or nil");
                    return;
                }
                w.i("MicroMsg.AlbumPreviewUI", "gallery photo:%s", new Object[]{stringArrayListExtra});
                setResult(-1, intent);
                finish();
            }
        } else if (-1 == i2) {
            String b = k.b(this.uSU.uTo.getApplicationContext(), intent, e.gSz);
            if (bg.mA(b)) {
                w.w("MicroMsg.AlbumPreviewUI", "take photo, but result is null");
                return;
            }
            w.i("MicroMsg.AlbumPreviewUI", "take photo, result[%s]", new Object[]{b});
            if (c.ayk().ayM() == 0 || c.ayk().ayM() == 5 || c.ayk().ayM() == 11) {
                Intent intent2 = new Intent();
                intent2.setData(Uri.parse("file://" + Uri.encode(b)));
                w.i("MicroMsg.AlbumPreviewUI", "take photo finish");
                setResult(-1, intent2);
                finish();
            } else {
                arrayList = new ArrayList(1);
                arrayList.add(b);
                Intent intent3 = new Intent(this, ImagePreviewUI.class);
                intent3.putExtra("isTakePhoto", true);
                intent3.putExtra("max_select_count", 1);
                intent3.putExtra("send_raw_img", this.mgb);
                intent3.putStringArrayListExtra("preview_image_list", arrayList);
                intent3.putExtra("GalleryUI_FromUser", this.fOu);
                intent3.putExtra("GalleryUI_ToUser", this.toUser);
                startActivityForResult(intent3, 4370);
            }
        } else {
            return;
        }
        if (intent != null && intent.getBooleanExtra("show_photo_edit_tip", false)) {
            SharedPreferences sharedPreferences = getSharedPreferences("photo_edit_pref", 0);
            if (!sharedPreferences.getBoolean("has_show_tip", false)) {
                this.mfP.setVisibility(0);
                this.mfP.setText(getString(R.l.eFX));
                Animation loadAnimation = AnimationUtils.loadAnimation(this.uSU.uTo, R.a.aQX);
                this.mfP.startAnimation(loadAnimation);
                loadAnimation.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ AlbumPreviewUI mgr;
                    private Runnable mgw = new Runnable(this) {
                        final /* synthetic */ AnonymousClass8 mgx;

                        {
                            this.mgx = r1;
                        }

                        public final void run() {
                            this.mgx.mgr.mfP.startAnimation(AnimationUtils.loadAnimation(this.mgx.mgr.uSU.uTo, R.a.aQY));
                            this.mgx.mgr.mfP.setVisibility(8);
                        }
                    };

                    {
                        this.mgr = r2;
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        this.mgr.mfP.setVisibility(0);
                        this.mgr.mfP.postDelayed(this.mgw, 4000);
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }
                });
                sharedPreferences.edit().putBoolean("has_show_tip", true).commit();
            }
        }
    }

    private void nh(int i) {
        if (i == 0) {
            this.mfJ.setEnabled(false);
            kr(false);
        } else {
            this.mfJ.setEnabled(true);
            kr(true);
        }
        if (i == 0) {
            this.mfJ.setText(R.l.enG);
        } else {
            this.mfJ.setText(getString(R.l.enG) + "(" + i + ")");
        }
        aB(0, ni(i));
    }

    private String ni(int i) {
        switch (c.ayk().ayM()) {
            case 4:
            case 7:
            case 8:
            case 13:
                if (i == 0 || this.mge <= 1) {
                    return getString(R.l.enH);
                }
                return getString(R.l.enH) + "(" + i + "/" + this.mge + ")";
            default:
                if (i == 0 || this.mge <= 1) {
                    return getString(R.l.dIA);
                }
                return getString(R.l.enB, new Object[]{Integer.valueOf(i), Integer.valueOf(this.mge)});
        }
    }

    public final void a(ArrayList<MediaItem> arrayList, long j) {
        if (j != this.mgn) {
            w.w("MicroMsg.AlbumPreviewUI", "%s %s, not my query, ignore.", new Object[]{Long.valueOf(j), Long.valueOf(this.mgn)});
            w.w("MicroMsg.AlbumPreviewUI", "If you saw too mush this log, maybe user had too many photos. This can be optimized.");
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add((MediaItem) it.next());
            }
        }
        if (this.mfN != null) {
            Runnable aVar = new a();
            aVar.mgy = new WeakReference(this.mfN);
            aVar.mgz = new WeakReference(this.isv);
            aVar.mgA = arrayList2;
            c.ayl().v(aVar);
        }
    }

    private void ayS() {
        if (this.mgp) {
            SharedPreferences sharedPreferences = getSharedPreferences("gallery_last_choose_album", 0);
            w.i("MicroMsg.AlbumPreviewUI", "last selected folderName and path: " + this.mfU + ", " + this.mfT);
            sharedPreferences.edit().putString(c.ayk().ayN(), this.mfU + "|" + this.mfT + "|" + this.mfV).commit();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.AlbumPreviewUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    adG();
                    return;
                } else {
                    g.a(this, getString(R.l.eFG), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AlbumPreviewUI mgr;

                        {
                            this.mgr = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.mgr.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }

    private boolean b(MediaItem mediaItem) {
        if (mediaItem == null) {
            w.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] item is null!");
            return false;
        } else if (this.mfk == null) {
            w.e("MicroMsg.AlbumPreviewUI", "[checkSelectedVideo] invoker is null!");
            return false;
        } else if (c.ayk().ayM() != 3) {
            return true;
        } else {
            if (new File(mediaItem.hTf).exists()) {
                try {
                    if (this.mfk.xp(mediaItem.hTf) > com.tencent.mm.plugin.appbrand.jsapi.l.e.CTRL_INDEX) {
                        g.bk(this, getString(R.l.enZ));
                        return false;
                    }
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.AlbumPreviewUI", e, "", new Object[0]);
                }
                return true;
            }
            g.bk(this, getString(R.l.enY));
            return false;
        }
    }
}
