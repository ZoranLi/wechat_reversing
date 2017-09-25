package com.tencent.mm.plugin.webview.ui.tools;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.plugin.sight.base.b;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.plugin.webview.model.ah;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.base.s;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class OpenFileChooserUI extends MMActivity {
    private int count;
    private ProgressDialog isv = null;
    private int mgH;
    private int mgf;
    private int qLd;
    private String qjX;
    private String rWW;
    private boolean sbo;
    private int sbp;
    private int sbq;
    private boolean sbr = false;
    private OnCancelListener sbs = null;

    static /* synthetic */ void b(OpenFileChooserUI openFileChooserUI, String str) {
        String str2 = null;
        if (openFileChooserUI.sbq == 0) {
            w.e("MicroMsg.OpenFileChooserUI", "don't need thumb image");
            return;
        }
        File file;
        if (TextUtils.isEmpty(openFileChooserUI.rWW)) {
            w.e("MicroMsg.OpenFileChooserUI", "thumbFilePath is empty!");
            file = null;
        } else {
            file = new File(openFileChooserUI.rWW);
        }
        if (file == null || !file.exists()) {
            w.e("MicroMsg.OpenFileChooserUI", "file == null or file not exist for path:%s!", new Object[]{openFileChooserUI.rWW});
            String name = new File(str).getName();
            if (!TextUtils.isEmpty(name) && name.contains(".")) {
                str2 = name.substring(0, name.lastIndexOf("."));
            }
            if (TextUtils.isEmpty(str2)) {
                openFileChooserUI.rWW = e.gSz + ("microMsg_" + System.currentTimeMillis()) + ".jpeg";
            } else if (e.gSz == null || !e.gSz.endsWith("/")) {
                openFileChooserUI.rWW = e.gSz + "/" + str2 + ".jpeg";
            } else {
                openFileChooserUI.rWW = e.gSz + str2 + ".jpeg";
            }
            if (new File(openFileChooserUI.rWW).exists()) {
                w.i("MicroMsg.OpenFileChooserUI", "file is exist for path:%s!", new Object[]{openFileChooserUI.rWW});
                return;
            }
            w.i("MicroMsg.OpenFileChooserUI", "file not exist for path:%s!", new Object[]{openFileChooserUI.rWW});
            w.i("MicroMsg.OpenFileChooserUI", "create new thumb path:%s!", new Object[]{openFileChooserUI.rWW});
            Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
            if (createVideoThumbnail == null) {
                w.e("MicroMsg.OpenFileChooserUI", "createVideoThumbnail bitmap fail for path:%s!", new Object[]{openFileChooserUI.rWW});
                return;
            }
            try {
                d.a(ThumbnailUtils.extractThumbnail(createVideoThumbnail, 690, 400, 2), 30, CompressFormat.JPEG, openFileChooserUI.rWW, true);
                return;
            } catch (IOException e) {
                w.e("MicroMsg.OpenFileChooserUI", "saveBitmapToImage exist IOException:" + e.getMessage());
                return;
            }
        }
        w.i("MicroMsg.OpenFileChooserUI", "file is exist!, path:%s", new Object[]{openFileChooserUI.rWW});
    }

    static /* synthetic */ String d(OpenFileChooserUI openFileChooserUI) {
        if (TextUtils.isEmpty(openFileChooserUI.rWW)) {
            return "";
        }
        WebViewJSSDKFileItem IP = WebViewJSSDKFileItem.IP(openFileChooserUI.rWW);
        IP.rWW = openFileChooserUI.rWW;
        IP.iDE = true;
        IP.fIL = 1;
        f.bwZ().b(IP);
        return IP.fJz;
    }

    static /* synthetic */ String j(String str, List list) {
        int[] iArr = new int[2];
        j.b(str, iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        PInt pInt3 = new PInt();
        PInt pInt4 = new PInt();
        com.tencent.mm.plugin.sight.base.d.a(str, pInt, pInt2, pInt3, pInt4, new PInt());
        String str2 = e.gSz + "microMsg." + System.currentTimeMillis() + ".mp4";
        w.i("MicroMsg.OpenFileChooserUI", "remuxing [%s] to [%s], result %d, resolution:[%d, %d]", new Object[]{str, str2, Integer.valueOf(SightVideoJNI.remuxing(str, str2, i, i2, b.ptA, b.ptz, 8, 2, 25.0f, (float) pInt4.value, null, 0, b.pty)), Integer.valueOf(i), Integer.valueOf(i2)});
        WebViewJSSDKFileItem IR = WebViewJSSDKFileItem.IR(str2);
        IR.width = i;
        IR.height = i2;
        IR.duration = r2;
        IR.size = com.tencent.mm.a.e.aN(str2);
        list.add(IR.fJz);
        f.bwZ().b(IR);
        return IR.fJz;
    }

    protected final int getLayoutId() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        Intent intent;
        super.onCreate(bundle);
        this.count = getIntent().getIntExtra("key_pick_local_pic_count", 0);
        if (this.count <= 0 || this.count > 9) {
            this.count = 9;
        }
        this.qLd = this.count;
        this.mgf = getIntent().getIntExtra("key_pick_local_pic_query_source_type", 8);
        this.mgH = getIntent().getIntExtra("query_media_type", 1);
        this.sbo = getIntent().getBooleanExtra("key_pick_local_pic_send_raw", false);
        this.sbp = getIntent().getIntExtra("key_pick_local_pic_capture", 3);
        this.sbq = getIntent().getIntExtra("key_pick_local_media_video_type", 0);
        if ((this.mgf == 7 && this.mgH == 2) || this.mgH == 3) {
            if (!bxJ()) {
                s.makeText(this, getString(R.l.fmx), 1).show();
                this.sbr = true;
            }
            Intent intent2 = new Intent();
            intent2.putExtra("key_send_raw_image", this.sbo);
            intent2.putExtra("query_media_type", this.mgH);
            int intExtra;
            int intExtra2;
            if (this.sbq == 1) {
                if (this.sbp != Downloads.RECV_BUFFER_SIZE && (this.sbp & Downloads.RECV_BUFFER_SIZE) > 0) {
                    intExtra = getIntent().getIntExtra("key_pick_local_media_quality", 1);
                    intExtra2 = getIntent().getIntExtra("key_pick_local_media_duration", 60);
                    intent2.putExtra("KEY_SIGHT_PARAMS", wi(1));
                    intent2.putExtra("record_video_force_sys_camera", false);
                    intent2.putExtra("show_header_view", true);
                    intent2.putExtra("record_video_is_sight_capture", true);
                    intent2.putExtra("record_video_quality", intExtra);
                    intent2.putExtra("record_video_time_limit", intExtra2);
                    intent2.putExtra("video_full_path", this.qjX);
                    k.c(this, this.qLd, this.mgf, intent2);
                } else if (this.sbp == 16 || this.sbp == 256) {
                    intent2.putExtra("KEY_SIGHT_PARAMS", wi(1));
                    k.a(this, 6, intent2, 3, 1);
                } else if (this.sbp == Downloads.RECV_BUFFER_SIZE) {
                    intent2.putExtra("show_header_view", false);
                    k.c(this, this.qLd, this.mgf, intent2);
                }
            } else if (this.sbq == 2) {
                String mz = bg.mz(getIntent().getStringExtra("key_pick_local_media_sight_type"));
                if (this.sbp != Downloads.RECV_BUFFER_SIZE && (this.sbp & Downloads.RECV_BUFFER_SIZE) > 0) {
                    w.e("MicroMsg.OpenFileChooserUI", "choose media from local or camera is not support");
                    setResult(1);
                    finish();
                } else if (this.sbp == 16 || this.sbp == 256) {
                    intExtra = 0;
                    if (mz.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE) && mz.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
                        intExtra = 0;
                    } else if (mz.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                        intExtra = 1;
                    } else if (mz.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
                        intExtra = 2;
                    }
                    intent2.putExtra("KEY_SIGHT_PARAMS", wi(intExtra));
                    k.a(this, 7, intent2, 3, intExtra);
                } else if (this.sbp == Downloads.RECV_BUFFER_SIZE) {
                    r4 = 3;
                    if (mz.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE) && mz.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                        r4 = 3;
                    } else if (mz.contains(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
                        r4 = 1;
                    } else if (mz.contains(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
                        r4 = 2;
                    }
                    Intent intent3 = new Intent();
                    intent3.putExtra("key_can_select_video_and_pic", true);
                    intent3.putExtra("key_send_raw_image", this.sbo);
                    k.a(this, 8, this.qLd, this.mgf, r4, false, intent3);
                }
            } else if (this.sbp != Downloads.RECV_BUFFER_SIZE && (this.sbp & Downloads.RECV_BUFFER_SIZE) > 0) {
                this.qjX = e.gSz + "microMsg." + System.currentTimeMillis() + ".mp4";
                intExtra = getIntent().getIntExtra("key_pick_local_media_quality", 1);
                intExtra2 = getIntent().getIntExtra("key_pick_local_media_duration", 60);
                intent2.putExtra("record_video_force_sys_camera", true);
                intent2.putExtra("record_video_quality", intExtra);
                intent2.putExtra("record_video_time_limit", intExtra2);
                intent2.putExtra("video_full_path", this.qjX);
                k.c(this, this.qLd, this.mgf, intent2);
            } else if (this.sbp == 16 || this.sbp == 256) {
                this.qjX = e.gSz + "microMsg." + System.currentTimeMillis() + ".mp4";
                r4 = getIntent().getIntExtra("key_pick_local_media_quality", 1);
                k.a(this, this.qjX, 5, getIntent().getIntExtra("key_pick_local_media_duration", 60), r4, this.sbp == 16);
            } else if (this.sbp == Downloads.RECV_BUFFER_SIZE) {
                intent2.putExtra("show_header_view", false);
                k.c(this, this.qLd, this.mgf, intent2);
            }
            if (this.sbp != Downloads.RECV_BUFFER_SIZE && (this.sbp & Downloads.RECV_BUFFER_SIZE) > 0) {
                obj = 1;
                if (obj == null) {
                    if (!bxJ()) {
                        s.makeText(this, getString(R.l.fmx), 1).show();
                        this.sbr = true;
                    }
                    intent = new Intent();
                    intent.putExtra("key_send_raw_image", this.sbo);
                    intent.putExtra("query_media_type", this.mgH);
                    switch (this.sbp) {
                        case 1:
                            intent.putExtra("show_header_view", false);
                            k.a(this, 1, this.qLd, this.mgf, intent);
                            return;
                        case 2:
                            g.a(this, "", new String[]{getString(R.l.fmp)}, "", true, new c(this) {
                                final /* synthetic */ OpenFileChooserUI sbt;

                                {
                                    this.sbt = r1;
                                }

                                public final void hq(int i) {
                                    w.i("MicroMsg.OpenFileChooserUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this.sbt.uSU.uTo, "android.permission.CAMERA", 16, "", "")), bg.bJZ(), this.sbt.uSU.uTo});
                                    if (com.tencent.mm.pluginsdk.i.a.a(this.sbt.uSU.uTo, "android.permission.CAMERA", 16, "", "")) {
                                        k.c(this.sbt.uSU.uTo, e.gSz, "microMsg." + System.currentTimeMillis() + ".jpg", 2);
                                    }
                                }
                            }, new OnCancelListener(this) {
                                final /* synthetic */ OpenFileChooserUI sbt;

                                {
                                    this.sbt = r1;
                                }

                                public final void onCancel(DialogInterface dialogInterface) {
                                    this.sbt.setResult(0);
                                    this.sbt.finish();
                                }
                            });
                            return;
                        case 3:
                            k.a(this, 1, this.count, this.mgf, intent);
                            return;
                        default:
                            w.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
                            setResult(0);
                            finish();
                            return;
                    }
                }
            } else if (this.sbp == 16 || this.sbp == 256) {
                obj = 1;
                if (obj == null) {
                    if (bxJ()) {
                        s.makeText(this, getString(R.l.fmx), 1).show();
                        this.sbr = true;
                    }
                    intent = new Intent();
                    intent.putExtra("key_send_raw_image", this.sbo);
                    intent.putExtra("query_media_type", this.mgH);
                    switch (this.sbp) {
                        case 1:
                            intent.putExtra("show_header_view", false);
                            k.a(this, 1, this.qLd, this.mgf, intent);
                            return;
                        case 2:
                            g.a(this, "", new String[]{getString(R.l.fmp)}, "", true, /* anonymous class already generated */, /* anonymous class already generated */);
                            return;
                        case 3:
                            k.a(this, 1, this.count, this.mgf, intent);
                            return;
                        default:
                            w.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
                            setResult(0);
                            finish();
                            return;
                    }
                }
            } else if (this.sbp == Downloads.RECV_BUFFER_SIZE) {
                obj = 1;
                if (obj == null) {
                    if (bxJ()) {
                        s.makeText(this, getString(R.l.fmx), 1).show();
                        this.sbr = true;
                    }
                    intent = new Intent();
                    intent.putExtra("key_send_raw_image", this.sbo);
                    intent.putExtra("query_media_type", this.mgH);
                    switch (this.sbp) {
                        case 1:
                            intent.putExtra("show_header_view", false);
                            k.a(this, 1, this.qLd, this.mgf, intent);
                            return;
                        case 2:
                            g.a(this, "", new String[]{getString(R.l.fmp)}, "", true, /* anonymous class already generated */, /* anonymous class already generated */);
                            return;
                        case 3:
                            k.a(this, 1, this.count, this.mgf, intent);
                            return;
                        default:
                            w.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
                            setResult(0);
                            finish();
                            return;
                    }
                }
            }
        }
        obj = null;
        if (obj == null) {
            if (bxJ()) {
                s.makeText(this, getString(R.l.fmx), 1).show();
                this.sbr = true;
            }
            intent = new Intent();
            intent.putExtra("key_send_raw_image", this.sbo);
            intent.putExtra("query_media_type", this.mgH);
            switch (this.sbp) {
                case 1:
                    intent.putExtra("show_header_view", false);
                    k.a(this, 1, this.qLd, this.mgf, intent);
                    return;
                case 2:
                    g.a(this, "", new String[]{getString(R.l.fmp)}, "", true, /* anonymous class already generated */, /* anonymous class already generated */);
                    return;
                case 3:
                    k.a(this, 1, this.count, this.mgf, intent);
                    return;
                default:
                    w.e("MicroMsg.OpenFileChooserUI", "unkown scene, ignore this request");
                    setResult(0);
                    finish();
                    return;
            }
        }
    }

    private boolean bxJ() {
        w.i("MicroMsg.OpenFileChooserUI", "avaiableMem = %d", new Object[]{Long.valueOf(bg.en(this))});
        if (bg.en(this) <= 200) {
            return false;
        }
        return true;
    }

    private SightParams wi(int i) {
        String str = "microMsg_" + System.currentTimeMillis();
        this.qjX = e.gSz + str + ".mp4";
        this.rWW = e.gSz + str + ".jpeg";
        int intExtra = getIntent().getIntExtra("key_pick_local_media_duration", 60);
        SightParams sightParams = new SightParams(3, 1);
        sightParams.nAD = this.sbp == 16 ? 1 : 2;
        sightParams.mode = i;
        if (sightParams.nAE == null) {
            sightParams.nAE = new VideoTransPara();
        }
        sightParams.nAE.duration = intExtra;
        sightParams.h(str, this.qjX, this.rWW, e.gSz + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"}));
        return sightParams;
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        w.i("MicroMsg.OpenFileChooserUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId())});
        switch (i) {
            case 16:
                if (iArr[0] == 0) {
                    k.c(this.uSU.uTo, e.gSz, "microMsg." + System.currentTimeMillis() + ".jpg", 2);
                    return;
                } else {
                    g.a(this, getString(R.l.eFG), getString(R.l.eFM), getString(R.l.evw), getString(R.l.cancel), false, new OnClickListener(this) {
                        final /* synthetic */ OpenFileChooserUI sbt;

                        {
                            this.sbt = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            this.sbt.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                        }
                    }, null);
                    return;
                }
            default:
                return;
        }
    }

    protected void onActivityResult(int i, final int i2, final Intent intent) {
        File file = null;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            Intent intent2 = new Intent();
            intent2.putExtra("key_pick_local_media_show_memory_warning", this.sbr);
            setResult(i2, intent2);
            finish();
            return;
        }
        String b;
        Intent intent3;
        ArrayList arrayList;
        SightCaptureResult sightCaptureResult;
        switch (i) {
            case 1:
            case 3:
                ap.vL().D(new Runnable(this) {
                    final /* synthetic */ OpenFileChooserUI sbt;

                    public final void run() {
                        List<String> stringArrayListExtra = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                        boolean booleanExtra = intent.getBooleanExtra("isTakePhoto", false);
                        boolean booleanExtra2 = intent.getBooleanExtra("CropImage_Compress_Img", true);
                        ArrayList arrayList = new ArrayList();
                        for (String IP : stringArrayListExtra) {
                            WebViewJSSDKFileItem IP2 = WebViewJSSDKFileItem.IP(IP);
                            String str = IP2.fJz;
                            IP2.iDE = booleanExtra2;
                            f.bwZ().b(IP2);
                            w.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", new Object[]{IP, str});
                            arrayList.add(str);
                        }
                        w.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", new Object[]{ah.X(arrayList)});
                        Intent intent = new Intent();
                        intent.putExtra("key_pick_local_pic_callback_local_ids", IP);
                        intent.putExtra("key_pick_local_pic_source_type", booleanExtra ? "camera" : FFmpegMetadataRetriever.METADATA_KEY_ALBUM);
                        intent.putExtra("key_pick_local_media_show_memory_warning", this.sbt.sbr);
                        this.sbt.setResult(i2, intent);
                        this.sbt.finish();
                    }
                });
                return;
            case 2:
                b = k.b(this.uSU.uTo.getApplicationContext(), intent, e.gSz);
                if (bg.mA(b)) {
                    w.w("MicroMsg.OpenFileChooserUI", "take photo, but result is null");
                    setResult(-2, intent);
                    finish();
                    return;
                }
                w.i("MicroMsg.OpenFileChooserUI", "take photo, result[%s]", new Object[]{b});
                intent3 = new Intent();
                intent3.putExtra("key_send_raw_image", this.sbo);
                intent3.putExtra("max_select_count", this.qLd);
                intent3.putExtra("query_source_type", this.mgf);
                arrayList = new ArrayList(1);
                arrayList.add(b);
                intent3.putStringArrayListExtra("preview_image_list", arrayList);
                intent3.putExtra("preview_image", true);
                intent3.addFlags(67108864);
                com.tencent.mm.bb.d.b(this, "gallery", ".ui.GalleryEntryUI", intent3, 3);
                return;
            case 4:
                List stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                if (stringArrayListExtra == null || stringArrayListExtra.size() == 0) {
                    w.e("MicroMsg.OpenFileChooserUI", "choose video failed, path is null");
                    setResult(1);
                    finish();
                    return;
                }
                w.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_GALLERY_VIDEO");
                w.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[]{stringArrayListExtra.get(0)});
                if (this.sbq == 1 && !pj(this.rWW)) {
                    w.i("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
                }
                JD((String) stringArrayListExtra.get(0));
                return;
            case 5:
                if (new File(this.qjX).exists()) {
                    JD(this.qjX);
                    return;
                }
                w.e("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_VIDEO, file not exist : %s", new Object[]{this.qjX});
                setResult(1);
                finish();
                return;
            case 6:
                w.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_SIGHT_VIDEO");
                if (intent != null) {
                    w.i("MicroMsg.OpenFileChooserUI", "data is valid!");
                    sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        w.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
                        setResult(1);
                        finish();
                        return;
                    }
                    this.qjX = sightCaptureResult.nAw;
                    w.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[]{this.qjX});
                    if (!pj(this.rWW) && pj(sightCaptureResult.nAx)) {
                        this.rWW = sightCaptureResult.nAx;
                    }
                    if (!TextUtils.isEmpty(this.qjX)) {
                        file = new File(this.qjX);
                    }
                    if (file == null || !file.exists()) {
                        w.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", new Object[]{this.qjX});
                    } else {
                        w.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", new Object[]{this.qjX});
                        JD(this.qjX);
                        return;
                    }
                }
                w.e("MicroMsg.OpenFileChooserUI", "data is null!");
                setResult(1);
                finish();
                return;
            case 7:
                w.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_CAMERA");
                if (intent != null) {
                    w.i("MicroMsg.OpenFileChooserUI", "data is valid!");
                    sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        w.e("MicroMsg.OpenFileChooserUI", "sight capture result is null!");
                        setResult(1);
                        finish();
                        return;
                    } else if (sightCaptureResult.nAu) {
                        b = sightCaptureResult.nAC;
                        if (bg.mA(b)) {
                            w.e("MicroMsg.OpenFileChooserUI", "picture_picturePath file is not exist! path:%s", new Object[]{b});
                            setResult(1);
                            finish();
                            return;
                        }
                        ArrayList arrayList2 = new ArrayList();
                        WebViewJSSDKFileItem IP = WebViewJSSDKFileItem.IP(b);
                        IP.iDE = true;
                        IP.fIL = 1;
                        f.bwZ().b(IP);
                        arrayList2.add(IP.fJz);
                        w.i("MicroMsg.OpenFileChooserUI", "filepath is : %s, local id is : %s", new Object[]{b, IP.fJz});
                        w.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", new Object[]{ah.Y(arrayList2)});
                        intent3 = new Intent();
                        intent3.putExtra("key_pick_local_media_local_ids", b);
                        intent3.putExtra("key_pick_local_media_callback_type", 2);
                        setResult(i2, intent3);
                        finish();
                        return;
                    } else {
                        File file2;
                        this.qjX = sightCaptureResult.nAw;
                        w.i("MicroMsg.OpenFileChooserUI", "videoFilePath:%s", new Object[]{this.qjX});
                        if (!pj(this.rWW) && pj(sightCaptureResult.nAx)) {
                            this.rWW = sightCaptureResult.nAx;
                        }
                        if (TextUtils.isEmpty(this.qjX)) {
                            file2 = null;
                        } else {
                            file2 = new File(this.qjX);
                        }
                        if (file2 == null || !file2.exists()) {
                            w.e("MicroMsg.OpenFileChooserUI", "video file is not exist! path:%s", new Object[]{this.qjX});
                        } else {
                            w.e("MicroMsg.OpenFileChooserUI", "video file is exist! path:%s", new Object[]{this.qjX});
                            JD(this.qjX);
                            return;
                        }
                    }
                }
                w.e("MicroMsg.OpenFileChooserUI", "data is null!");
                setResult(1);
                finish();
                return;
            case 8:
                w.i("MicroMsg.OpenFileChooserUI", "REQUEST_CODE_TAKE_MEDIA_LOCAL");
                ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("key_select_video_list");
                if (stringArrayListExtra2 == null || stringArrayListExtra2.size() <= 0) {
                    List<String> stringArrayListExtra3 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    boolean booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", true);
                    if (stringArrayListExtra3 == null) {
                        w.e("MicroMsg.OpenFileChooserUI", "chosen is null");
                        setResult(1);
                        finish();
                        return;
                    }
                    arrayList = new ArrayList();
                    for (String b2 : stringArrayListExtra3) {
                        WebViewJSSDKFileItem IP2 = WebViewJSSDKFileItem.IP(b2);
                        String str = IP2.fJz;
                        IP2.iDE = booleanExtra;
                        f.bwZ().b(IP2);
                        w.i("MicroMsg.OpenFileChooserUI", "now filepath is : %s, local id is : %s", new Object[]{b2, str});
                        arrayList.add(str);
                    }
                    w.i("MicroMsg.OpenFileChooserUI", "after parse to json data : %s", new Object[]{ah.Y(arrayList)});
                    intent3 = new Intent();
                    intent3.putExtra("key_pick_local_media_local_ids", b2);
                    intent3.putExtra("key_pick_local_media_show_memory_warning", this.sbr);
                    intent3.putExtra("key_pick_local_media_callback_type", 2);
                    setResult(i2, intent3);
                    finish();
                    return;
                }
                JD((String) stringArrayListExtra2.get(0));
                return;
            default:
                w.e("MicroMsg.OpenFileChooserUI", "unknown request code = %d", new Object[]{Integer.valueOf(i)});
                setResult(1);
                finish();
                return;
        }
    }

    private void JD(final String str) {
        this.sbs = new OnCancelListener(this) {
            final /* synthetic */ OpenFileChooserUI sbt;

            {
                this.sbt = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                this.sbt.setResult(0);
                this.sbt.finish();
            }
        };
        getString(R.l.dIO);
        this.isv = g.a(this, getString(R.l.fmk), true, this.sbs);
        ap.vL().D(new Runnable(this) {
            final /* synthetic */ OpenFileChooserUI sbt;

            public final void run() {
                List arrayList = new ArrayList();
                int a = this.sbt.JF(str);
                if (a == -50002) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass6 sbu;

                        {
                            this.sbu = r1;
                        }

                        public final void run() {
                            if (this.sbu.sbt.mgf == 7 && this.sbu.sbt.mgH == 2) {
                                g.a(this.sbu.sbt, this.sbu.sbt.getString(R.l.fml), this.sbu.sbt.getString(R.l.dIO), this.sbu.sbt.getString(R.l.dHw), false, new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass1 sbv;

                                    {
                                        this.sbv = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.sbv.sbu.sbt.setResult(1);
                                        this.sbv.sbu.sbt.finish();
                                    }
                                });
                                return;
                            }
                            Toast.makeText(this.sbu.sbt, this.sbu.sbt.getString(R.l.fag), 0).show();
                            this.sbu.sbt.setResult(1);
                            this.sbu.sbt.finish();
                        }
                    });
                    return;
                }
                String j;
                String d;
                if (a == -50006) {
                    j = OpenFileChooserUI.j(str, arrayList);
                    OpenFileChooserUI.b(this.sbt, str);
                    d = OpenFileChooserUI.d(this.sbt);
                } else if (a == 1) {
                    j = this.sbt.JE(str);
                    OpenFileChooserUI.b(this.sbt, str);
                    d = OpenFileChooserUI.d(this.sbt);
                    if (bg.mA(j) && this.sbt.mgf == 7 && this.sbt.mgH == 2) {
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass6 sbu;

                            {
                                this.sbu = r1;
                            }

                            public final void run() {
                                g.a(this.sbu.sbt, this.sbu.sbt.getString(R.l.fmm), this.sbu.sbt.getString(R.l.dIO), this.sbu.sbt.getString(R.l.dHw), false, new OnClickListener(this) {
                                    final /* synthetic */ AnonymousClass2 sbw;

                                    {
                                        this.sbw = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        this.sbw.sbu.sbt.setResult(1);
                                        this.sbw.sbu.sbt.finish();
                                    }
                                });
                            }
                        });
                        return;
                    }
                } else {
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass6 sbu;

                        {
                            this.sbu = r1;
                        }

                        public final void run() {
                            this.sbu.sbt.setResult(1);
                            this.sbu.sbt.finish();
                        }
                    });
                    return;
                }
                if (bg.mA(j)) {
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass6 sbu;

                        {
                            this.sbu = r1;
                        }

                        public final void run() {
                            this.sbu.sbt.setResult(1);
                            this.sbu.sbt.finish();
                        }
                    });
                } else {
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass6 sbu;

                        public final void run() {
                            Intent intent = new Intent();
                            intent.putExtra("key_pick_local_media_callback_type", 1);
                            intent.putExtra("key_pick_local_media_local_id", j);
                            intent.putExtra("key_pick_local_media_thumb_local_id", d);
                            w.i("MicroMsg.OpenFileChooserUI", "thumbLocalId:%s", new Object[]{d});
                            this.sbu.sbt.setResult(-1, intent);
                            this.sbu.sbt.finish();
                        }
                    });
                }
            }
        });
    }

    private String JE(String str) {
        MediaMetadataRetriever mediaMetadataRetriever;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
        } catch (Exception e) {
            w.e("MicroMsg.OpenFileChooserUI", "addVideoItem, MetaDataRetriever setDataSource failed, e = %s", new Object[]{e});
            mediaMetadataRetriever = null;
        }
        if (mediaMetadataRetriever == null) {
            return null;
        }
        int i = bg.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
        int i2 = bg.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
        int i3 = bg.getInt(mediaMetadataRetriever.extractMetadata(9), 0);
        WebViewJSSDKFileItem IR = WebViewJSSDKFileItem.IR(str);
        IR.duration = (i3 + 500) / 1000;
        IR.width = i;
        IR.height = i2;
        IR.size = com.tencent.mm.a.e.aN(str);
        if (this.sbq == 1) {
            IR.rWW = this.rWW;
        }
        f.bwZ().b(IR);
        return IR.fJz;
    }

    private int JF(String str) {
        com.tencent.mm.compatible.i.a.a i;
        Intent intent = new Intent();
        intent.setData(Uri.parse("file://" + str));
        com.tencent.mm.compatible.i.a.a aVar = null;
        am.is2G(this);
        try {
            i = com.tencent.mm.compatible.i.a.i(this, intent);
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.OpenFileChooserUI", e, "", new Object[0]);
            i = aVar;
        }
        if (i == null) {
            w.e("MicroMsg.OpenFileChooserUI", "compressVideo filed.");
            return -50005;
        }
        int i2;
        String str2 = i.filename;
        boolean mD = com.tencent.mm.plugin.a.c.mD(str2);
        w.i("MicroMsg.OpenFileChooserUI", "isMp4 = %b", new Object[]{Boolean.valueOf(mD)});
        int i3 = -10000;
        if (mD) {
            i3 = SightVideoJNI.shouldRemuxing(str2, 660, 500, 20971520, 300000.0d, Constants.MAX_BUFFER_SIZE);
            w.i("MicroMsg.OpenFileChooserUI", "check remuxing, ret %d", new Object[]{Integer.valueOf(i3)});
        }
        if (i3 == -1 || !mD) {
            w.i("MicroMsg.OpenFileChooserUI", "fileLenght = %d", new Object[]{Integer.valueOf(com.tencent.mm.a.e.aN(str2))});
            if (com.tencent.mm.a.e.aN(str2) > 20971520) {
                i3 = -1;
            } else {
                i3 = 1;
            }
        }
        switch (i3) {
            case -6:
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
                return -50002;
            case 0:
                i2 = 1;
                i3 = 0;
                break;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                i2 = 0;
                i3 = 1;
                break;
            default:
                w.e("MicroMsg.OpenFileChooserUI", "unknown check type");
                return -50001;
        }
        if (i2 != 0) {
            i3 = -50006;
        }
        i2 = i.duration / 1000;
        w.i("MicroMsg.OpenFileChooserUI", "finish to import %s  ret %d | duration %d", new Object[]{str2, Integer.valueOf(i3), Integer.valueOf(i2)});
        return i3;
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.isv != null && this.isv.isShowing()) {
            this.isv.dismiss();
        }
    }

    private static boolean pj(String str) {
        if (TextUtils.isEmpty(str)) {
            w.e("MicroMsg.OpenFileChooserUI", "video thumb file path is null");
            return false;
        }
        File file = new File(str);
        w.i("MicroMsg.OpenFileChooserUI", "thumbFilePath:%s", new Object[]{str});
        if (file.exists()) {
            w.i("MicroMsg.OpenFileChooserUI", "video thumb file is exist");
            return true;
        }
        w.e("MicroMsg.OpenFileChooserUI", "video thumb file is not exist");
        return false;
    }
}
