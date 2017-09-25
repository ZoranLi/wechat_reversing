package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.g;
import com.tencent.mm.sdk.platformtools.w;

public class b extends a {
    protected final int getLayoutId() {
        return R.i.daH;
    }

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        w.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onAttach");
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        w.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onCreate");
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        w.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onCreateView");
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public final void onActivityCreated(Bundle bundle) {
        w.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onActivityCreated");
        super.onActivityCreated(bundle);
    }

    public final void onStart() {
        super.onStart();
        w.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onStart");
    }

    public final void onResume() {
        super.onResume();
        w.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onResume");
    }

    public final void onPause() {
        super.onPause();
        w.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onPause");
    }

    public final void onStop() {
        super.onStop();
        w.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onStop");
    }

    public final void onDestroyView() {
        super.onDestroyView();
        w.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onResume");
    }

    public final void onDestroy() {
        super.onDestroy();
        w.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onDestroy");
    }

    public final void onDetach() {
        super.onDetach();
        w.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onDestroy");
    }

    public final int amO() {
        return 5;
    }

    public final a amH() {
        return new g(this.uSU.uTo);
    }

    public final boolean aoz() {
        return true;
    }
}
