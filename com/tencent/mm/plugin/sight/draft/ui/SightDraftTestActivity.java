package com.tencent.mm.plugin.sight.draft.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class SightDraftTestActivity extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View sightDraftContainerView = new SightDraftContainerView(this);
        setContentView(sightDraftContainerView);
        sightDraftContainerView.bcE();
    }
}
