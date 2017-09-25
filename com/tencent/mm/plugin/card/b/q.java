package com.tencent.mm.plugin.card.b;

public enum q {
    EN_DYNAMIC_CODE_SCENE_ENTER_FOREGROUND(1),
    EN_DYNAMIC_CODE_SCENE_ENTER_WXCARD(2),
    EN_DYNAMIC_CODE_SCENE_ENTER_CARD_DETAIL(3);
    
    public int scene;

    private q(int i) {
        this.scene = i;
    }
}
