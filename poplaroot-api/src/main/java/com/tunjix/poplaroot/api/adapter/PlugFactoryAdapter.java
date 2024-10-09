package com.tunjix.poplaroot.api.adapter;

import com.tunjix.poplaroot.api.core.*;

import java.util.Map;

/**
 * AUTHOR: XirAli · MaMat（西尔艾力·买买提）
 * DATE: 2024/7/23 14:26
 */
public abstract class PlugFactoryAdapter implements PlugFactory {

    @Override
    public void invoke(DualPlugContext dualPlugContext) {
        if(dualPlugContext.getMethodsByScene(dualPlugContext.getSceneKey())==null){
            throw new RuntimeException(dualPlugContext.getId()+" invalid dualPlugContext");
        }
        intensify(dualPlugContext,null);
    }

    protected abstract void intensify(DualPlugContext dualPlugContext, Map<String,Object> extendMap);

    protected abstract Class<? extends AdviceSelector> getVoidAdviceClass();

    protected abstract Class<? extends AdviceSelector> getNotVoidAdviceClass();
}
