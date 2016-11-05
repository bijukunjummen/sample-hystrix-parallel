package sample.aggregate;


import org.junit.Test;
import rx.Observable;
import sample.command.SampleRemoteCallCommand1;
import sample.command.SampleRemoteCallCommand2;

import static org.assertj.core.api.Assertions.assertThat;

public class AggregationTest {

    @Test
    public void aggregateWithHystrix() {

        SampleRemoteCallCommand1 command1 = new SampleRemoteCallCommand1();
        SampleRemoteCallCommand2 command2 = new SampleRemoteCallCommand2();

        Observable<String> result1Obs = command1.toObservable();
        Observable<Integer> result2Obs = command2.toObservable();

        Observable<String> result =
                Observable.zip(result1Obs, result2Obs, (result1, result2) -> result1 + result2);
        assertThat(result.toBlocking().single()).isEqualTo("something0");
    }
}
