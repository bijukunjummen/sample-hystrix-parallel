package sample.command;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import sample.util.DelayUtil;

public class SampleRemoteCallCommand1 extends HystrixCommand<String> {

    public SampleRemoteCallCommand1() {
        super(Setter.withGroupKey(
                HystrixCommandGroupKey.Factory.asKey("sample1"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("sample1")
                )
        );
    }

    @Override
    protected String run() throws Exception {
        DelayUtil.delay(700);
        return "something";
    }

    @Override
    protected String getFallback() {
        return "error";
    }
}
