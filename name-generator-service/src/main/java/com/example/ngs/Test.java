package com.example.ngs;
import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Test {
    @Autowired
    private Tracer tracer;
    
    @RequestMapping("/test")
    public String test() {
        Span spanA = tracer.buildSpan("testing").start();
 
        Span spanB = tracer.buildSpan("f1").asChildOf(spanA).start();
        f1();
        spanB.finish();
     
     
        Span spanC = tracer.buildSpan("f2").asChildOf(spanA).start();
        f2();
        spanC.finish();

        spanA.finish();
        return "Done!\n";
    }

    public void f1(){
        try {
            Thread.sleep(1000); //delay for 1 seconds
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void f2(){
        try {
            Thread.sleep(500); //delay for 1 seconds
        }
        catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
