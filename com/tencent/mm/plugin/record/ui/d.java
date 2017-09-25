package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.e.a.jr;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class d extends h {
    private static HashMap<String, Boolean> oOS = new HashMap();
    public c oOT = new c<jr>(this) {
        final /* synthetic */ d oOU;

        {
            this.oOU = r2;
            this.usg = jr.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            jr jrVar = (jr) bVar;
            final com.tencent.mm.plugin.record.a.b bVar2 = new com.tencent.mm.plugin.record.a.b();
            bVar2.field_dataId = jrVar.fQe.field_dataId;
            bVar2.field_favLocalId = jrVar.fQe.field_favLocalId;
            bVar2.field_offset = jrVar.fQe.field_offset;
            bVar2.field_totalLen = jrVar.fQe.field_totalLen;
            bVar2.field_status = jrVar.fQe.field_status;
            if (bVar2.field_favLocalId == ((b) this.oOU.oPi).oOR.field_localId) {
                w.d("MicroMsg.FavRecordAdapter", "on cdn status changed, fav local id %d, data id %s, status %d", new Object[]{Long.valueOf(bVar2.field_favLocalId), bVar2.field_dataId, Integer.valueOf(bVar2.field_status)});
                if (4 == bVar2.field_status) {
                    d.oOS.put(bg.ap(bVar2.field_dataId, "null"), Boolean.valueOf(true));
                }
                if (bVar2.isFinished()) {
                    this.oOU.oPe.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass1 oOW;

                        public final void run() {
                            View view = (View) com.tencent.mm.plugin.record.ui.b.c.oPZ.get(bVar2.field_dataId);
                            String str = "MicroMsg.FavRecordAdapter";
                            String str2 = "view is null %s";
                            Object[] objArr = new Object[1];
                            objArr[0] = Boolean.valueOf(view == null);
                            w.d(str, str2, objArr);
                            if (view != null) {
                                com.tencent.mm.plugin.record.ui.a.b bVar = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
                                str2 = com.tencent.mm.plugin.record.a.d.a(bVar);
                                w.d("MicroMsg.FavRecordAdapter", "dataItemId: %s", new Object[]{bVar.fKe.lKv});
                                if (bVar.fKe.lKv.equals(bVar2.field_dataId)) {
                                    objArr = new Object[4];
                                    com.tencent.mm.plugin.record.a.b bVar2 = bVar2;
                                    objArr[2] = Float.valueOf(Math.max(0.0f, Math.min(99.0f, ((float) bVar2.field_offset) / ((float) bVar2.field_totalLen)) * 100.0f));
                                    objArr[3] = Boolean.valueOf(bVar2.isFinished());
                                    w.d("MicroMsg.FavRecordAdapter", "change the sight status %s, dataId %s, progress %s cdnInfo %s", objArr);
                                    ImageView imageView = (ImageView) view.findViewById(R.h.cGq);
                                    MMPinProgressBtn mMPinProgressBtn = (MMPinProgressBtn) view.findViewById(R.h.progress);
                                    a aVar = (a) view.findViewById(R.h.Kd);
                                    imageView.setVisibility(8);
                                    mMPinProgressBtn.setVisibility(8);
                                    w.i("MicroMsg.FavRecordAdapter", "setVideoPath " + str2);
                                    aVar.gZ(true);
                                    aVar.ak(str2, false);
                                }
                            }
                        }
                    });
                }
                this.oOU.aWR();
            }
            return false;
        }
    };

    public d(Context context, h.a aVar) {
        super(context, aVar);
    }

    public final void a(a aVar) {
        w.i("MicroMsg.FavRecordAdapter", "updateData localId %s,status %s", new Object[]{Long.valueOf(((b) aVar).oOR.field_localId), Integer.valueOf(((b) aVar).oOR.field_itemStatus)});
        this.oPi = aVar;
        this.oOQ.clear();
        this.oOQ.addAll(aVar.oOQ);
        notifyDataSetChanged();
    }

    public final void d(com.tencent.mm.plugin.record.ui.a.b bVar) {
        w.d("MicroMsg.FavRecordAdapter", "setupRecord %s", new Object[]{Long.valueOf(((b) this.oPi).oOR.field_localId)});
        bVar.aMw = 1;
        bVar.oOR = ((b) this.oPi).oOR;
    }
}
