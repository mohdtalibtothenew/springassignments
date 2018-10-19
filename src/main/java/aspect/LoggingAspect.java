package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

        /*1) Create a logging aspect. Create a pointcut to log all methods Of services .
        2) Add a logging statement before and after the method ends
        3) Log all the methods which throw IOException
        5) Apply execution, within, args, this and bean expressions on the before and after advice of service bean.
        5) Demonstrate the use of pointCut @Pointcut annotation and Reuse the expression created
        6) Access the properties of the JoinPoint in before advice. Print Signature of method being called and its arguments
*/

@Aspect
public class LoggingAspect {
    @Pointcut("execution(* *service.ShapeService.*(..))")
    public void adviceForAll(){

    }
    @Before("adviceForAll()")
    public void beforAdvice(){
        System.out.println("Befor advice");
    }
    @After("adviceForAll()")
    public void afterAdvice(){
        System.out.println("After advice");

    }
    @AfterThrowing(pointcut = "adviceForAll()", throwing = "ex")
    public void AfterThrowingAdvice(Exception ex){
        System.out.println("There has been an exception: " + ex.toString());
    }
    @Pointcut("within(entity.Circle)")
    public void forCircle(){

    }
    @After("forCircle()")
    public void circleAdvice(){
        System.out.println("For circle");
    }
    @Before("args(String)")
    public void withArgument(JoinPoint joinPoint){
        System.out.println("Method called with String argument");
        System.out.println(joinPoint.toString());
    }


}
