package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.mm.bb.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;

public final class r extends k {
    public r(Context context, h hVar, ViewGroup viewGroup) {
        super(context, hVar, viewGroup);
    }

    protected final void d(Button button) {
        button.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ r qjg;

            {
                this.qjg = r1;
            }

            public final void onClick(View view) {
                this.qjg.bgr();
                this.qjg.j(this.qjg.context, ((h) this.qjg.bgs()).qfk);
            }
        });
    }

    public final void j(Context context, long j) {
        Intent intent = new Intent();
        intent.putExtra("sns_landig_pages_from_source", 14);
        intent.putExtra("sns_landig_pages_origin_from_source", bgs().qfV);
        intent.putExtra("sns_landing_pages_xml", "");
        intent.putExtra("sns_landing_pages_pageid", j);
        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        intent.putExtra("sns_landing_pages_extra", "");
        intent.putExtra("sns_landing_pages_no_store", 0);
        intent.putExtra("sns_landing_pages_ux_info", bgs().pZI);
        intent.putExtra("sns_landing_is_native_sight_ad", bgs().qfW);
        d.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
    }
}
