package com.dandan.designPattern.proxy;

/**
 * @author houhuafei
 * @description 王婆代理人类：代理潘金莲执行事情
 * @date 2021年06月16日 13:57
 */
public class WangPo implements KindWomen{
    KindWomen kindWomen;

    public WangPo(){
        // 默认代理潘金莲
        this.kindWomen = new PanJinLian();
    }

    public WangPo(KindWomen kindWomen){
        this.kindWomen = kindWomen;
    }

    @Override
    public void happyWithMan() {
        // 这么大年纪了 干不了了 让年清的代替吧？
        this.kindWomen.happyWithMan();
    }

    @Override
    public void makeEyesWithMan() {
        // 这么大年纪了谁还看抛媚眼 让年轻的干吧
        this.kindWomen.makeEyesWithMan();
    }
}
