package cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyEx implements MethodInterceptor {
    /**
     * 生成cglib代理对象
     * @param cls 真实对象
     * @return
     */
    public Object getProxy(Class cls) {
        Enhancer enhancer = new Enhancer();
        // 把被代理对象设置为父类
        enhancer.setSuperclass(cls);
        // 设置回调调用cls类中的方法都去调用intercept方法
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     * 代理逻辑方法
     * @param proxy 代理对象
     * @param method
     * @param args
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用前");
        Object o = methodProxy.invokeSuper(proxy, args);
        System.out.println("调用后");
        return o;
    }
}

class Test {
    public static void main(String[] args) {
        CglibProxyEx cglibProxyEx = new CglibProxyEx();
        HelloImpl hello = (HelloImpl) cglibProxyEx.getProxy(HelloImpl.class);
        hello.sayHello();
    }
}
