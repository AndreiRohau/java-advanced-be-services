package any.thing.service;

import java.util.Random;

public class AnyServiceImpl implements AnyService {
    @Override
    public int getAny() {
        return new Random().nextInt();
    }
}
