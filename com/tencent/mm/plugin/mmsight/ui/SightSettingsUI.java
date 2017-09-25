package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.u.a.e;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class SightSettingsUI extends MMActivity {
    private ListView iuu;
    private d lvq = new d(this);
    private CaptureMMProxy nAR;
    private a nLZ;
    private LinkedList<b> nMa = new LinkedList();

    class a extends BaseAdapter {
        final /* synthetic */ SightSettingsUI nMb;

        a(SightSettingsUI sightSettingsUI) {
            this.nMb = sightSettingsUI;
        }

        public final int getCount() {
            return this.nMb.nMa.size();
        }

        public final Object getItem(int i) {
            return this.nMb.nMa.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View textView = new TextView(this.nMb);
            final b bVar = (b) getItem(i);
            textView.setText(bVar.nMe + "->:" + bVar.pP(((Integer) bVar.nMb.nAR.get(bVar.nMh, Integer.valueOf(0))).intValue()));
            textView.setGravity(17);
            textView.setTextSize(1, 20.0f);
            textView.setHeight(com.tencent.mm.bg.a.fromDPToPix(ab.getContext(), 50));
            if (i % 2 == 1) {
                textView.setBackgroundColor(Color.parseColor("#e2efda"));
            }
            textView.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a nMd;

                public final void onClick(View view) {
                    b bVar = bVar;
                    List linkedList = new LinkedList();
                    List linkedList2 = new LinkedList();
                    for (int i = 0; i < bVar.nMf.length; i++) {
                        linkedList.add(bVar.nMf[i]);
                        linkedList2.add(Integer.valueOf(i));
                    }
                    g.a(bVar.nMb, "", linkedList, linkedList2, "", new g.d(bVar) {
                        final /* synthetic */ b nMi;

                        {
                            this.nMi = r1;
                        }

                        public final void bN(int i, int i2) {
                            this.nMi.nMb.nAR.set(this.nMi.nMh, Integer.valueOf(this.nMi.nMg[i]));
                            this.nMi.nMb.nLZ.notifyDataSetChanged();
                        }
                    });
                }
            });
            return textView;
        }
    }

    class b {
        final /* synthetic */ SightSettingsUI nMb;
        public String nMe;
        String[] nMf;
        int[] nMg;
        com.tencent.mm.storage.w.a nMh;

        public b(SightSettingsUI sightSettingsUI, String str, com.tencent.mm.storage.w.a aVar, String[] strArr, int[] iArr) {
            this.nMb = sightSettingsUI;
            this.nMe = str;
            this.nMf = strArr;
            this.nMh = aVar;
            this.nMg = iArr;
        }

        final String pP(int i) {
            int i2 = 0;
            while (i2 < this.nMg.length) {
                if (i == this.nMg[i2] && i2 < this.nMf.length) {
                    return this.nMf[i2];
                }
                i2++;
            }
            return this.nMf[0];
        }
    }

    static /* synthetic */ void a(SightSettingsUI sightSettingsUI) {
        SightSettingsUI sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.nMa.add(new b(sightSettingsUI2, "打开测试信息", com.tencent.mm.storage.w.a.uEZ, new String[]{"Y", "N"}, new int[]{1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.nMa.add(new b(sightSettingsUI2, "对焦方案", com.tencent.mm.storage.w.a.uFg, new String[]{"System", "啊..."}, new int[]{1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.nMa.add(new b(sightSettingsUI2, "裁剪方案", com.tencent.mm.storage.w.a.uFh, new String[]{"default", "mediacodecv21", "mediacodecv", "ffmpeg"}, new int[]{-1, 1, 2, 3}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.nMa.add(new b(sightSettingsUI2, "是否把双通音频压成单通道", com.tencent.mm.storage.w.a.uFi, new String[]{"-1", "yes", "no"}, new int[]{-1, 1, 0}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.nMa.add(new b(sightSettingsUI2, "Thread", com.tencent.mm.storage.w.a.uFe, new String[]{"-1", "1", "2", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "4", "5", "6"}, new int[]{-1, 1, 2, 3, 4, 5, 6}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.nMa.add(new b(sightSettingsUI2, "裁剪预览MediaPlayer", com.tencent.mm.storage.w.a.uFj, new String[]{"default", "系统方案", "MediaCodec解码播放方案"}, new int[]{-1, 1, 2}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.nMa.add(new b(sightSettingsUI2, "音频录制方案", com.tencent.mm.storage.w.a.uFk, new String[]{"-1", "MediaCodec", "MediaRecorder"}, new int[]{-1, 1, 2}));
        sightSettingsUI2 = sightSettingsUI;
        sightSettingsUI.nMa.add(new b(sightSettingsUI2, "预设配置", com.tencent.mm.storage.w.a.uFd, new String[]{"跟后台配置", "MediaCodec+540p录制", "MediaCodec+720p双倍码率录制+后期压缩", "FFMpeg+540p录制", "FFMpeg+720p双倍码率录制+后期压缩", "MediaCodec+720p原码率录制", "FFMpeg+720p原码率录制", "MediaCodec+1080p+实时压缩", "MediaCodec+1080p+实时压缩/旋转", "FFMpeg+1080p+实时压缩", "FFMpeg+1080p+实时压缩/旋转"}, new int[]{-1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
        sightSettingsUI.iuu = (ListView) sightSettingsUI.findViewById(com.tencent.mm.plugin.u.a.d.cbx);
        sightSettingsUI.nLZ = new a(sightSettingsUI);
        sightSettingsUI.iuu.setAdapter(sightSettingsUI.nLZ);
    }

    protected final int getLayoutId() {
        return e.nOd;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nAR = new CaptureMMProxy(this.lvq);
        this.lvq.G(new Runnable(this) {
            final /* synthetic */ SightSettingsUI nMb;

            {
                this.nMb = r1;
            }

            public final void run() {
                w.i("MicroMsg.SightSettingsUI", "has connect");
                SightSettingsUI.a(this.nMb);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SightSettingsUI nMb;

            {
                this.nMb = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.nMb.finish();
                return false;
            }
        });
    }

    public void onDestroy() {
        super.onDestroy();
        this.lvq.release();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }
}
