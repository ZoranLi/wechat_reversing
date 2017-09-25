package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.fp;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.record.a.g;
import com.tencent.mm.plugin.record.a.m;
import com.tencent.mm.plugin.record.a.s;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.plugin.record.ui.h;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;
import java.util.Map;

public final class c implements b {
    public static Map<String, View> oPZ = new HashMap();
    private OnClickListener lJz = new OnClickListener(this) {
        final /* synthetic */ c oQa;

        {
            this.oQa = r1;
        }

        public final void onClick(View view) {
            com.tencent.mm.plugin.record.ui.a.b bVar = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
            Intent intent;
            if (bVar.aMw == 0) {
                if (m.d(bVar.fKe, bVar.fGM)) {
                    w.i("MicroMsg.SightViewWrapper", "onclick: play sight");
                    intent = new Intent(view.getContext(), RecordMsgFileUI.class);
                    intent.putExtra("message_id", bVar.fGM);
                    intent.putExtra("record_xml", bVar.fTh);
                    intent.putExtra("record_data_id", bVar.fKe.lKv);
                    view.getContext().startActivity(intent);
                    return;
                }
                g Do = s.aWF().Do(m.d(bVar.fKe.lKv, bVar.fGM, true));
                String str = "MicroMsg.SightViewWrapper";
                String str2 = "onclick: cdnInfo status %s";
                Object[] objArr = new Object[1];
                objArr[0] = Do == null ? "null" : Integer.valueOf(Do.field_status);
                w.i(str, str2, objArr);
                if (!(Do == null || 2 == Do.field_status || 3 == Do.field_status)) {
                    if (4 == Do.field_status) {
                        com.tencent.mm.ui.base.g.bl(view.getContext(), view.getResources().getString(R.l.eji));
                        return;
                    } else if (Do.field_status == 0 || 1 == Do.field_status) {
                        return;
                    }
                }
                m.a(bVar.fKe, bVar.fGM, true);
            } else if (bVar.aMw == 1) {
                com.tencent.mm.sdk.b.b fpVar;
                w.i("MicroMsg.SightViewWrapper", "click item favid %d, localid %d, itemstatus %d", new Object[]{Integer.valueOf(bVar.oOR.field_id), Long.valueOf(bVar.oOR.field_localId), Integer.valueOf(bVar.oOR.field_itemStatus)});
                if (bVar.oOR.isDone()) {
                    fpVar = new fp();
                    fpVar.fKp.type = 14;
                    fpVar.fKp.fKr = bVar.fKe;
                    a.urY.m(fpVar);
                    w.i("MicroMsg.SightViewWrapper", "favItemInfo is Done,file exist ret = %d", new Object[]{Integer.valueOf(fpVar.fKq.ret)});
                    if (fpVar.fKq.ret == 1) {
                        intent = new Intent();
                        intent.putExtra("key_detail_info_id", bVar.oOR.field_localId);
                        intent.putExtra("key_detail_data_id", bVar.fKe.lKv);
                        intent.putExtra("key_detail_can_delete", false);
                        d.b(view.getContext(), "favorite", ".ui.detail.FavoriteFileDetailUI", intent);
                        return;
                    } else if (bg.mA(bVar.fKe.txi)) {
                        w.w("MicroMsg.SightViewWrapper", "favItemInfo getCdnDataUrl empty");
                        return;
                    } else {
                        w.w("MicroMsg.SightViewWrapper", "? info is done, source file not exist, cdn data url is not null");
                    }
                } else if (bVar.oOR.atl() || bVar.oOR.atj()) {
                    w.i("MicroMsg.SightViewWrapper", "favItemInfo isDownLoadFaied or isUploadFailed, wait download");
                } else if (bVar.oOR.atk() || bVar.oOR.ati()) {
                    w.i("MicroMsg.SightViewWrapper", "favItemInfo isDownloading or isUploadding, wait download");
                    return;
                } else {
                    w.w("MicroMsg.SightViewWrapper", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                }
                fpVar = new fp();
                fpVar.fKp.fFx = bVar.oOR.field_localId;
                if (bVar.oOR.atj()) {
                    w.w("MicroMsg.SightViewWrapper", "upload failed, try to restart...");
                    fpVar.fKp.type = 15;
                    a.urY.m(fpVar);
                    return;
                }
                w.w("MicroMsg.SightViewWrapper", "download failed, try to restart...");
                fpVar.fKp.type = 16;
                a.urY.m(fpVar);
            }
        }
    };
    private h.a oPj;

    public c(h.a aVar) {
        this.oPj = aVar;
    }

    public final View cJ(Context context) {
        View inflate = View.inflate(context, R.i.dmp, null);
        ((com.tencent.mm.plugin.sight.decode.a.a) inflate.findViewById(R.h.Kd)).sF(com.tencent.mm.bg.a.fromDPToPix(context, GameJsApiLaunchApplication.CTRL_BYTE));
        return inflate;
    }

    public final void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar) {
        view.setTag(bVar);
        view.setOnClickListener(this.lJz);
        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) view.findViewById(R.h.Kd);
        ImageView imageView = (ImageView) view.findViewById(R.h.cGq);
        MMPinProgressBtn mMPinProgressBtn = (MMPinProgressBtn) view.findViewById(R.h.progress);
        aVar.kj(i);
        com.tencent.mm.plugin.record.ui.a.c cVar = (com.tencent.mm.plugin.record.ui.a.c) bVar;
        h.a aVar2 = this.oPj;
        Map map = oPZ;
        com.tencent.mm.plugin.record.ui.h.a.c cVar2 = new com.tencent.mm.plugin.record.ui.h.a.c();
        cVar2.fKe = cVar.fKe;
        String c;
        if (cVar.aMw == 0) {
            cVar2.oPl = cVar.fGM;
            if (m.d(cVar.fKe, cVar.fGM)) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(8);
                c = m.c(cVar.fKe, cVar.fGM);
                if (!c.equals(aVar.Ls())) {
                    aVar.y(aVar2.a(cVar2));
                }
                aVar.ak(c, false);
                return;
            }
            g Do = s.aWF().Do(m.d(cVar.fKe.lKv, cVar.fGM, true));
            if (Do == null || 2 == Do.field_status) {
                imageView.setImageResource(R.k.dzz);
            } else if (3 == Do.field_status || 4 == Do.field_status) {
                imageView.setImageResource(R.g.bjR);
            } else if (Do.field_status == 0 || 1 == Do.field_status) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(0);
                mMPinProgressBtn.setProgress((int) ((((float) Do.field_offset) / ((float) Math.max(1, Do.field_totalLen))) * 100.0f));
                aVar.clear();
                aVar.y(aVar2.a(cVar2));
                return;
            } else {
                imageView.setImageResource(R.k.dzz);
            }
            imageView.setVisibility(0);
            mMPinProgressBtn.setVisibility(8);
            aVar.clear();
            aVar.y(aVar2.a(cVar2));
        } else if (cVar.aMw == 1) {
            map.put(cVar.fKe.lKv, view);
            w.d("MicroMsg.SightRecordData", "dataId %s, status %s", new Object[]{Long.valueOf(cVar.oOR.field_localId), Integer.valueOf(cVar.oOR.field_itemStatus)});
            cVar2.oPl = cVar.oOR.field_localId;
            com.tencent.mm.sdk.b.b fpVar = new fp();
            fpVar.fKp.type = 14;
            fpVar.fKp.fKr = cVar.fKe;
            a.urY.m(fpVar);
            if (cVar.oOR.isDone() || fpVar.fKq.ret == 1) {
                if (fpVar.fKq.ret == 1) {
                    imageView.setVisibility(8);
                    mMPinProgressBtn.setVisibility(8);
                    fpVar.fKp.type = 2;
                    a.urY.m(fpVar);
                    c = fpVar.fKq.path;
                    if (bg.mA(c)) {
                        w.w("MicroMsg.SightRecordData", "videoPath is null!");
                        return;
                    }
                    if (!c.equals(aVar.Ls())) {
                        aVar.y(aVar2.a(cVar2));
                    }
                    aVar.ak(c, false);
                    return;
                } else if (bg.mA(cVar.fKe.txi)) {
                    imageView.setImageResource(R.g.bjR);
                } else {
                    w.w("MicroMsg.SightRecordData", "? info is done, source file not exist, cdn data url is not null");
                    imageView.setImageResource(R.k.dzz);
                }
            } else if (cVar.oOR.atl() || cVar.oOR.atj()) {
                imageView.setImageResource(R.k.dzz);
            } else if (cVar.oOR.atk()) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(0);
                mMPinProgressBtn.caB();
                aVar.clear();
                aVar.y(aVar2.a(cVar2));
                return;
            } else {
                w.w("MicroMsg.SightRecordData", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                imageView.setImageResource(R.k.dzz);
            }
            imageView.setVisibility(0);
            mMPinProgressBtn.setVisibility(8);
            aVar.clear();
            aVar.y(aVar2.a(cVar2));
        }
    }

    public final void destroy() {
        this.oPj = null;
    }

    public final void pause() {
    }
}
