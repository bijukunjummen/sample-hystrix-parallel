package sample.command;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import sample.util.DelayUtil;

public class SampleRemoteCallCommand2 extends HystrixCommand<Integer> {

    public SampleRemoteCallCommand2() {
        super(Setter.withGroupKey(
                HystrixCommandGroupKey.Factory.asKey("sample2"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("sample2")
                )
        );
    }

    @Override
    protected Integer run() throws Exception {
        DelayUtil.delay(700);
        return 0;
    }

    @Override
    protected Integer getFallback() {
        return -1;
    }
}
