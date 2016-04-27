package none.rg.aspjtest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.junit.Test;
import java.util.*;

@Aspect
public class MethodLoggerAspect {
    
    static List<String> list = new ArrayList<>();

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                onClose();
            }
        });
    }

    static void onClose() {
        System.out.println("EXECUTED: " + list);
    }

    @Around("execution(* *(..)) && @annotation(Test)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = point.proceed();
        list.add(point.getSignature().getName());
        return result;
    }
}