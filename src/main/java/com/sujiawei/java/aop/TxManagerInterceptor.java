package com.sujiawei.java.aop;

import com.sujiawei.java.annotation.TxManagerAnnotation;
import com.sujiawei.java.utils.TxManagerUtil;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Service;

@Service
public class TxManagerInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        TxManagerAnnotation txManagerAnnotation = methodInvocation.getMethod().getAnnotation(TxManagerAnnotation.class);
        String db = txManagerAnnotation.db();
        Integer level = txManagerAnnotation.level();
        TxManagerUtil txManagerUtil = new TxManagerUtil(db, level);

        Object result = null;
        try {
            txManagerUtil.begin();
            result = methodInvocation.proceed();
            txManagerUtil.commit();
        } catch (Exception e) {
            txManagerUtil.rollback();
        } finally {
            txManagerUtil.close();
        }
        return result;
    }
}