package com.lovecandy.mvp.base;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;

/**
 * @author Created by lichao
 * @desc 基本的P 层, 处理绑定解绑
 * @time 2018/5/7 10:04
 * 邮箱：lichao@voole.com
 */

public class BasePresenter<V extends IView,M extends IModel> {
    private V mProxyView;
    //最好还是用一下软引用
    private WeakReference<V> mView;
    public M model = null;
    //view 一般都是activity ,设计到内存泄漏,但是已经解绑了不会导致内存泄漏.

    /**
     * 初始化view,绑定
     * @param view
     */
    public void attachView(V view) {
        this.mView = new WeakReference(view);
        mProxyView = (V) Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (mView==null||mView.get()==null){
                    return null;
                }
                return method.invoke(mView.get(),args);
            }
        });
        try {
            //getGenericSuperclass()获得带有泛型的父类
            ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
            //getActualTypeArguments获取参数化类型的数组，拿到modle的子类
            Class<M> modelClazz = (Class<M>) (parameterizedType.getActualTypeArguments()[1]);
            //初始化子类
            model = modelClazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解绑
     */
    public void dettachView() {
        this.mView.clear();
        this.mView = null;
        this.mProxyView = null;
    }

    /**
     * 获取当前V 层
     * @return
     */
    public V getView() {
        return mProxyView;
    }
}
